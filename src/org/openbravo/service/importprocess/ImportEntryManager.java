/*
 *************************************************************************
 * The contents of this file are subject to the Openbravo  Public  License
 * Version  1.1  (the  "License"),  being   the  Mozilla   Public  License
 * Version 1.1  with a permitted attribution clause; you may not  use this
 * file except in compliance with the License. You  may  obtain  a copy of
 * the License at http://www.openbravo.com/legal/license.html 
 * Software distributed under the License  is  distributed  on  an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific  language  governing  rights  and  limitations
 * under the License. 
 * The Original Code is Openbravo ERP. 
 * The Initial Developer of the Original Code is Openbravo SLU 
 * All portions are Copyright (C) 2015-2018 Openbravo SLU
 * All Rights Reserved.
 * Contributor(s):  ______________________________________.
 ************************************************************************
 */
package org.openbravo.service.importprocess;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.Query;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.base.session.OBPropertiesProvider;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.core.SessionHandler;
import org.openbravo.dal.service.OBDal;
import org.openbravo.model.ad.access.Role;
import org.openbravo.service.json.JsonUtils;

/**
 * This class is the main manager for performing multi-threaded and parallel import of data from the
 * {@link ImportEntry} entity/table. The {@link ImportEntryManager} is a singleton/ApplicationScoped
 * class.
 * 
 * @author mtaal
 */
@ApplicationScoped
public class ImportEntryManager {

  /*
   * For an overview of the technical layer, first view this presentation:
   * http://wiki.openbravo.com/
   * wiki/Projects:Retail_Operations_Buffer#Presentation_on_Technical_Structure (note: hyperlink
   * maybe cut by line-break)
   * 
   * {@link ImportEntry} records are created by for example data synchronization processes. For
   * creating a new {@link ImportEntry} preferably the {@link #createImportEntry(String, String,
   * String)} method should be used. This method also takes care of calling all the relevant {@link
   * ImportEntryPreProcessor} instances. As the {@link ImportEntryManager} is a
   * singleton/applicationscoped class it should preferably be obtained through Weld.
   * 
   * After creating a new {@link ImportEntry} and committing the transaction the creator of the
   * {@link ImportEntry} should preferably call the method {@link #notifyNewImportEntryCreated()}.
   * This to wake up the {@link ImportEntryManagerThread} to process the new entry.
   * 
   * The {@link ImportEntryManager} runs a thread (the {@link ImportEntryManagerThread}) which
   * periodically queries if there are {@link ImportEntry} records in state 'Initial'. Any {@link
   * ImportEntry} with status 'Initial' is to be processed. The {@link ImportEntryManagerThread} is
   * started when the application starts and is shutdown when the Tomcat application stops, see the
   * {@link #start()} and {@link #shutdown()} methods which are called from the {@link
   * ImportProcessContextListener}.
   * 
   * As mentioned above, the {@link ImportEntryManagerThread} periodically checks if there are
   * {@link ImportEntry} records in state 'Initial'. This thread is also notified when a new {@link
   * ImportEntry} is created. If there are no notifications or {@link ImportEntry} records in state
   * 'Initial', then the thread waits for a preset amount of time before querying the {@link
   * ImportEntry} table again. This notification and waiting is managed through the {@link
   * #notifyNewImportEntryCreated()} and {@link ImportEntryManagerThread#doNotify()} and {@link
   * ImportEntryManagerThread#doWait()} methods. This mechanism uses a monitor object. See here for
   * more information:
   * http://javarevisited.blogspot.nl/2011/05/wait-notify-and-notifyall-in-java.html
   * 
   * When the {@link ImportEntryManagerThread} retrieves an {@link ImportEntry} instance in state
   * 'Initial' then it tries to find an {@link ImportEntryProcessor} which can handle this instance.
   * The right {@link ImportEntryProcessor} is found by using the {@link ImportEntryQualifier} and
   * Weld selections.
   * 
   * The {@link ImportEntryProcessor#handleImportEntry(ImportEntry)} method gets the {@link
   * ImportEntry} and processes it.
   * 
   * As the {@link ImportEntryManagerThread} runs periodically and the processing of {@link
   * ImportEntry} instances can take a long it is possible that an ImportEntry is again 'offered' to
   * the {@link ImportEntryProcessor} for processing. The {@link ImportEntryProcessor} should handle
   * this case robustly.
   * 
   * For more information see the {@link ImportEntryProcessor}.
   * 
   * This class also provides methods for error handling and result processing: {@link
   * #setImportEntryProcessed(String)}, {@link #setImportEntryError(String, Throwable)}, {@link
   * #setImportEntryErrorIndependent(String, Throwable)}.
   */

  private static final Logger log = Logger.getLogger(ImportEntryManager.class);

  private static ImportEntryManager instance;

  public static ImportEntryManager getInstance() {
    return instance;
  }

  @Inject
  @Any
  private Instance<ImportEntryPreProcessor> entryPreProcessors;

  @Inject
  @Any
  private Instance<ImportEntryProcessor> entryProcessors;

  @Inject
  @Any
  private ImportEntryArchiveManager importEntryArchiveManager;

  @Inject
  private ImportEntryClusterService clusterService;

  private ImportEntryManagerThread managerThread;
  private ThreadPoolExecutor executorService;

  private Map<String, ImportEntryProcessor> importEntryProcessors = new HashMap<String, ImportEntryProcessor>();

  private Map<String, ImportStatistics> stats = new HashMap<String, ImportEntryManager.ImportStatistics>();

  private boolean threadsStarted = false;

  private long initialWaitTime = 10000;
  private long managerWaitTime = 600_000L;

  // default to number of processors plus some additionals for the main threads
  private int numberOfThreads = Runtime.getRuntime().availableProcessors() + 3;

  // defines the batch size of reading and processing import entries by the
  // main thread, for each type of data the batch size is being read
  private int importBatchSize = 5000;

  // task queue limit in the executorservice, sufficiently large
  // to allow large sets of tasks but small enough to limit an implementing
  // subclass of ImportEntryProcessor going wild
  private int maxTaskQueueSize = 1000;

  private boolean isShutDown = false;

  public boolean isShutDown() {
    return isShutDown;
  }

  @PostConstruct
  private void init() {
    instance = this;
    importBatchSize = ImportProcessUtils.getCheckIntProperty(log, "import.batch.size",
        importBatchSize, 1000);
    numberOfThreads = ImportProcessUtils.getCheckIntProperty(log, "import.number.of.threads",
        numberOfThreads, 4);
    maxTaskQueueSize = ImportProcessUtils.getCheckIntProperty(log, "import.max.task.queue.size",
        maxTaskQueueSize, 50);
    managerWaitTime = ImportProcessUtils.getCheckIntProperty(log, "import.wait.time", 600, 1);

    // property defined in secs, convert to ms
    managerWaitTime = managerWaitTime * 1000;
  }

  public synchronized void start() {
    if (ImportProcessUtils.isImportProcessDisabled()) {
      log.debug("Import process disabled, not starting it");
      return;
    }

    if (threadsStarted) {
      return;
    }
    threadsStarted = true;

    log.debug("Starting Import Entry Framework");

    // same as fixed threadpool, will only stop accepting new tasks (throw an exception)
    // if there are maxTaskQueueSize in the queue, see the catch exception in submitRunnable.
    // http://www.nurkiewicz.com/2014/11/executorservice-10-tips-and-tricks.html
    final BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(maxTaskQueueSize);
    executorService = new ThreadPoolExecutor(numberOfThreads, numberOfThreads, 0L,
        TimeUnit.MILLISECONDS, queue, new DaemonThreadFactory());

    // create, start the manager thread
    managerThread = new ImportEntryManagerThread(this);
    executorService.submit(managerThread);
    importEntryArchiveManager.start();
    isShutDown = false;
  }

  public long getNumberOfQueuedTasks() {
    return executorService.getQueue() == null ? 0 : executorService.getQueue().size();
  }

  public long getNumberOfActiveTasks() {
    return executorService.getActiveCount();
  }

  public boolean isExecutorRunning() {
    return executorService != null && !executorService.isShutdown()
        && !executorService.isTerminated() && managerThread.isRunning();
  }

  /**
   * Is called by the {@link ImportEntryProcessor} objects to submit a
   * {@link ImportEntryProcessor.ImportEntryProcessRunnable}. for execution.
   */
  public void submitRunnable(Runnable runnable) {
    try {
      executorService.submit(runnable);
    } catch (Exception e) {
      // except for logging we can ignore the exception
      // as the import entry will be offered again for reprocessing later anyway
      log.warn("Exception while trying to add runnable " + runnable
          + " to the list of tasks to run", e);
    }
  }

  /**
   * This method is used to set the cluster service into an state that indicates that it is
   * currently processing import entries. Note that if we are not in a clustered environment, this
   * method has no effect.
   */
  public void notifyStartProcessingInCluster() {
    clusterService.startProcessing();
  }

  /**
   * This method is used to set the cluster service into an state that indicates that it is
   * currently not processing import entries. Note that if we are not in a clustered environment,
   * this method has no effect.
   */
  public void notifyEndProcessingInCluster() {
    clusterService.endProcessing();
  }

  /**
   * Shutdown all the threads being used by the import framework
   */
  public void shutdown() {
    if (!threadsStarted) {
      return;
    }
    log.debug("Shutting down Import Entry Framework");

    isShutDown = true;

    if (executorService != null) {
      executorService.shutdownNow();
    }

    for (ImportEntryProcessor importEntryProcessor : importEntryProcessors.values()) {
      importEntryProcessor.shutdown();
    }
    importEntryArchiveManager.shutdown();
    executorService = null;
    threadsStarted = false;
    managerThread = null;
  }

  /**
   * Creates and saves the import entry, calls the
   * {@link ImportEntryPreProcessor#beforeCreate(ImportEntry)} on the
   * {@link ImportEntryPreProcessor} instances.
   * 
   * Note will commit the session/connection using {@link OBDal#commitAndClose()}
   */
  public void createImportEntry(String id, String typeOfData, String json) {
    createImportEntry(id, typeOfData, json, true);
  }

  /**
   * Creates and saves the import entry, calls the
   * {@link ImportEntryPreProcessor#beforeCreate(ImportEntry)} on the
   * {@link ImportEntryPreProcessor} instances.
   * 
   * Note will commit the session/connection using {@link OBDal#commitAndClose()}
   */
  public void createImportEntry(String id, String typeOfData, String json, boolean commitAndClose) {
    OBContext.setAdminMode(true);
    try {
      // check if it is not there already or already archived
      {
        final Query qry = SessionHandler.getInstance().getSession()
            .createQuery("select count(*) from " + ImportEntry.ENTITY_NAME + " where id=:id");
        qry.setParameter("id", id);
        if (((Number) qry.uniqueResult()).intValue() > 0) {
          log.debug("Entry already exists, ignoring it, id/typeofdata " + id + "/" + typeOfData
              + " json " + json);
          return;
        }
      }
      {
        final Query qry = SessionHandler
            .getInstance()
            .getSession()
            .createQuery("select count(*) from " + ImportEntryArchive.ENTITY_NAME + " where id=:id");
        qry.setParameter("id", id);
        if (((Number) qry.uniqueResult()).intValue() > 0) {
          log.debug("Entry already archived, ignoring it, id/typeofdata " + id + "/" + typeOfData
              + " json " + json);
          return;
        }
      }

      ImportEntry importEntry = OBProvider.getInstance().get(ImportEntry.class);
      importEntry.setId(id);
      importEntry.setRole(OBDal.getInstance().getProxy(Role.class,
          OBContext.getOBContext().getRole().getId()));
      importEntry.setNewOBObject(true);
      importEntry.setImportStatus("Initial");
      importEntry.setCreatedtimestamp((new Date()).getTime());
      importEntry.setImported(null);
      importEntry.setTypeofdata(typeOfData);
      importEntry.setJsonInfo(json);

      for (ImportEntryPreProcessor processor : entryPreProcessors) {
        processor.beforeCreate(importEntry);
      }
      OBDal.getInstance().save(importEntry);
      if (commitAndClose) {
        OBDal.getInstance().commitAndClose();

        notifyNewImportEntryCreated();
      }
    } finally {
      OBContext.restorePreviousMode();
    }
  }

  public void reportStats(String typeOfData, long timeForEntry) {
    ImportStatistics importStatistics = stats.get(typeOfData);
    if (importStatistics == null) {
      createStatsEntry(typeOfData);
      importStatistics = stats.get(typeOfData);
    }
    importStatistics.addTiming(timeForEntry);
    if ((importStatistics.getCnt() % 100) == 0) {
      importStatistics.log();
    }
  }

  private void createStatsEntry(String typeOfData) {
    if (stats.containsKey(typeOfData)) {
      return;
    }
    ImportStatistics importStatistics = new ImportStatistics();
    importStatistics.setTypeOfData(typeOfData);
    stats.put(typeOfData, importStatistics);
  }

  /**
   * Is used to tell the import entry manager that a new entry was created in the import entry
   * table, so it can go process it immediately.
   */
  public void notifyNewImportEntryCreated() {
    // make sure that the threads have started
    if (!threadsStarted) {
      start();
    }

    if (managerThread != null) {
      managerThread.doNotify();
    }
  }

  private void handleImportEntry(ImportEntry importEntry) {

    try {
      ImportEntryProcessor entryProcessor = getImportEntryProcessor(importEntry.getTypeofdata());
      if (entryProcessor == null) {
        log.warn("No import entry processor defined for type of data " + importEntry);
      } else {
        entryProcessor.handleImportEntry(importEntry);
      }
    } catch (Throwable t) {
      log.error(
          "Error while saving import message " + importEntry + " " + "  message: " + t.getMessage(),
          t);
      setImportEntryErrorIndependent(importEntry.getId(), t);
    }
  }

  // somehow cache the import entry processors, Weld seems to create many instances
  // caching is probably also faster
  private ImportEntryProcessor getImportEntryProcessor(String qualifier) {
    ImportEntryProcessor importEntryProcessor = importEntryProcessors.get(qualifier);
    if (importEntryProcessor == null) {
      importEntryProcessor = entryProcessors.select(new ImportEntryProcessorSelector(qualifier))
          .get();
      if (importEntryProcessor != null) {
        importEntryProcessors.put(qualifier, importEntryProcessor);
      } else {
        // caller should handle it
        return null;
      }
    }
    return importEntryProcessor;
  }

  public void handleImportError(ImportEntry importEntry, Throwable t) {
    importEntry.setImportStatus("Error");
    importEntry.setErrorinfo(ImportProcessUtils.getErrorMessage(t));
    importEntry.setResponseinfo(createErrorResponseContent(t));
    OBDal.getInstance().save(importEntry);
  }

  /**
   * Set the ImportEntry to status Processed in the same transaction as the caller.
   */
  public void setImportEntryProcessed(String importEntryId) {
    ImportEntry importEntry = OBDal.getInstance().get(ImportEntry.class, importEntryId);
    if (importEntry != null && !"Processed".equals(importEntry.getImportStatus())) {
      importEntry.setImportStatus("Processed");
      importEntry.setImported(new Date());
      OBDal.getInstance().save(importEntry);
    }
  }

  /**
   * Set the ImportEntry to status Error in the same transaction as the caller.
   */
  public void setImportEntryError(String importEntryId, Throwable t) {
    ImportEntry importEntry = OBDal.getInstance().get(ImportEntry.class, importEntryId);
    if (importEntry != null && !"Processed".equals(importEntry.getImportStatus())) {
      importEntry.setImportStatus("Error");
      importEntry.setErrorinfo(ImportProcessUtils.getErrorMessage(t));
      importEntry.setResponseinfo(createErrorResponseContent(t));
      OBDal.getInstance().save(importEntry);
    }
  }

  /**
   * Returns whether the ImportEntry is in status Error in the same transaction as the caller.
   */
  public boolean isImportEntryError(String importEntryId) {
    ImportEntry importEntry = OBDal.getInstance().get(ImportEntry.class, importEntryId);
    return importEntry != null && "Error".equals(importEntry.getImportStatus());
  }

  /**
   * Sets an {@link ImportEntry} in status Error but does this in its own transaction so not
   * together with the original data. This is relevant when the previous transaction which tried to
   * import the data fails.
   */
  public void setImportEntryErrorIndependent(String importEntryId, Throwable t) {
    OBDal.getInstance().rollbackAndClose();
    final OBContext prevOBContext = OBContext.getOBContext();
    OBContext.setOBContext("0", "0", "0", "0");
    try {
      // do not do org/client check as the error can be related to org/client access
      // so prevent this check to be done to even be able to save org/client access
      // exceptions
      OBContext.setAdminMode(false);
      ImportEntry importEntry = OBDal.getInstance().get(ImportEntry.class, importEntryId);
      if (importEntry != null && !"Processed".equals(importEntry.getImportStatus())) {
        importEntry.setImportStatus("Error");
        importEntry.setErrorinfo(ImportProcessUtils.getErrorMessage(t));
        importEntry.setResponseinfo(createErrorResponseContent(t));
        OBDal.getInstance().save(importEntry);
        OBDal.getInstance().commitAndClose();
      }
    } catch (Throwable throwable) {
      try {
        OBDal.getInstance().rollbackAndClose();
      } catch (Throwable ignored) {
      }
      throw new OBException(throwable);
    } finally {
      OBContext.restorePreviousMode();
      OBContext.setOBContext(prevOBContext);
    }
  }

  private String createErrorResponseContent(Throwable t) {
    try {
      final String jsonStr = JsonUtils.convertExceptionToJson(t);
      final JSONObject json = new JSONObject(jsonStr);
      if (json.has("response")) {
        return json.getJSONObject("response").toString();
      }
      return json.toString();
    } catch (Exception logIt) {
      log.error(logIt.getMessage(), logIt);
      return "{error:\"" + logIt.getMessage() + "\"}";
    }
  }

  private static class ImportEntryManagerThread implements Runnable {

    private final ImportEntryManager manager;

    private boolean isRunning = false;
    private Object monitorObject = new Object();
    private boolean wasNotifiedInParallel = false;

    ImportEntryManagerThread(ImportEntryManager manager) {
      this.manager = manager;
    }

    // http://javarevisited.blogspot.nl/2011/05/wait-notify-and-notifyall-in-java.html
    // note the doNotify and doWait methods should not be synchronized themselves
    // the synchronization should happen on the monitorObject
    private void doNotify() {
      synchronized (monitorObject) {
        wasNotifiedInParallel = true;
        monitorObject.notifyAll();
      }
    }

    private void doWait() {
      synchronized (monitorObject) {
        try {
          if (!wasNotifiedInParallel) {
            log.debug("Waiting for next cycle or new import entries");
            monitorObject.wait(manager.managerWaitTime);
            log.debug("Woken");
          }
          wasNotifiedInParallel = false;
        } catch (InterruptedException ignore) {
        }
      }
    }

    @Override
    public void run() {
      isRunning = true;

      Thread.currentThread().setName("Import Entry Manager Main");

      boolean isTest = OBPropertiesProvider.getInstance().getBooleanProperty("test.environment");

      // don't start right away at startup, give the system time to
      // really start
      log.debug("Started, first sleep " + manager.initialWaitTime);
      try {
        Thread.sleep(manager.initialWaitTime);
      } catch (Exception ignored) {
      }
      if (manager.isShutDown) {
        return;
      }
      log.debug("Run loop started");
      try {
        List<String> typesOfData = null;
        while (true) {
          try {

            // system is shutting down, bail out
            if (manager.isShutDown) {
              return;
            }

            if (shouldWait()) {
              doWait();
              // woken, re-start from beginning of loop
              continue;
            }

            // obcontext cleared or wrong obcontext, repair
            if (OBContext.getOBContext() == null
                || !"0".equals(OBContext.getOBContext().getUser().getId())) {
              // make ourselves an admin
              OBContext.setOBContext("0", "0", "0", "0");
            }

            if (typesOfData == null) {
              typesOfData = ImportProcessUtils.getOrderedTypesOfData();
            }

            int entryCount = 0;
            try {

              // start processing, so ignore any notifications happening before
              wasNotifiedInParallel = false;

              // read the types of data one by one in a specific order, so that they
              // don't block eachother with the limited batch size
              // being read
              for (String typeOfData : typesOfData) {

                log.debug("Reading import entries for type of data " + typeOfData);

                final String importEntryQryStr = "from " + ImportEntry.ENTITY_NAME + " where "
                    + ImportEntry.PROPERTY_TYPEOFDATA + "='" + typeOfData + "' and "
                    + ImportEntry.PROPERTY_IMPORTSTATUS + "='Initial' order by "
                    + ImportEntry.PROPERTY_CREATIONDATE + ", "
                    + ImportEntry.PROPERTY_CREATEDTIMESTAMP;

                final Query entriesQry = OBDal.getInstance().getSession()
                    .createQuery(importEntryQryStr);
                entriesQry.setFirstResult(0);
                entriesQry.setFetchSize(100);
                entriesQry.setMaxResults(manager.importBatchSize);

                final ScrollableResults entries = entriesQry.scroll(ScrollMode.FORWARD_ONLY);
                try {
                  while (entries.next() && isHandlingImportEntries()) {
                    entryCount++;
                    final ImportEntry entry = (ImportEntry) entries.get(0);

                    if (log.isDebugEnabled()) {
                      log.debug("Handle import entry " + entry.getIdentifier());
                    }

                    try {
                      manager.handleImportEntry(entry);
                      // remove it from the internal cache to keep it small
                      OBDal.getInstance().getSession().evict(entry);
                    } catch (Throwable t) {
                      ImportProcessUtils.logError(log, t);

                      // ImportEntryProcessors are custom implementations which can cause
                      // errors, so always catch them to prevent other import entries
                      // from not getting processed
                      manager.setImportEntryError(entry.getId(), t);
                    }
                  }
                } finally {
                  entries.close();
                }
              }

            } catch (Throwable t) {
              ImportProcessUtils.logError(log, t);
            } finally {
              OBDal.getInstance().commitAndClose();
            }

            if (entryCount > 0) {
              // if there was data then just wait some time
              // give the threads time to process it all before trying
              // a next batch of entries
              try {
                // wait one second per 30 records, somewhat arbitrary
                // but high enough for most cases, also always wait 300 millis additional to
                // start up threads etc.
                // note computation of timing ensures that int rounding is done on 1000* entrycount
                if (isTest) {
                  // in case of test don't wait minimal 2 seconds
                  Thread.sleep(300 + ((1000 * entryCount) / 30));
                } else {
                  log.debug("Entries have been processed, wait a shorter time, and try again to capture new entries which have been added");
                  // wait minimal 2 seconds or based on entry count
                  Thread.sleep(Math.max(2000, 300 + ((1000 * entryCount) / 30)));
                }
              } catch (Exception ignored) {
              }
            } else {
              // else wait for new ones to arrive or check after a certain
              // amount of time
              doWait();
            }

          } catch (Throwable t) {
            ImportProcessUtils.logError(log, t);

            // wait for 5 min otherwise the loop goes wild in case of really severe
            // system errors like full disk
            try {
              Thread.sleep(300_000L);
            } catch (Exception ignored) {
            }
          }
        }
      } finally {
        isRunning = false;
      }
    }

    private boolean shouldWait() {
      if (manager.executorService.getQueue() != null
          && manager.executorService.getQueue().size() > (manager.maxTaskQueueSize - 1)) {
        // too busy, don't process, but wait
        return true;
      }
      // - in cluster: process if we are in the node in charge of handling the import entries,
      // otherwise just wait
      // - not in cluster: do not wait
      return !isHandlingImportEntries();
    }

    private boolean isHandlingImportEntries() {
      return manager.clusterService.isHandledInCurrentNode();
    }

    public boolean isRunning() {
      return isRunning;
    }
  }

  @javax.inject.Qualifier
  @Retention(RetentionPolicy.RUNTIME)
  @Target({ ElementType.TYPE })
  public @interface ImportEntryQualifier {
    String entity();
  }

  @SuppressWarnings("all")
  public static class ImportEntryProcessorSelector extends AnnotationLiteral<ImportEntryQualifier>
      implements ImportEntryQualifier {
    private static final long serialVersionUID = 1L;

    final String entity;

    public ImportEntryProcessorSelector(String entity) {
      this.entity = entity;
    }

    public String entity() {
      return entity;
    }
  }

  private static class ImportStatistics {
    private String typeOfData;
    private long cnt;
    private long totalTime;

    public void setTypeOfData(String typeOfData) {
      this.typeOfData = typeOfData;
    }

    public long getCnt() {
      return cnt;
    }

    public synchronized void addTiming(long timeForEntry) {
      cnt++;
      totalTime += timeForEntry;
    }

    public synchronized void log() {
      log.info("Timings for " + typeOfData + " cnt: " + cnt + " avg millis: " + (totalTime / cnt));
    }
  }

  /**
   * Creates threads which have deamon set to true.
   */
  public static class DaemonThreadFactory implements ThreadFactory {
    private AtomicInteger threadNumber = new AtomicInteger(0);
    private final ThreadGroup group;

    public DaemonThreadFactory() {
      SecurityManager s = System.getSecurityManager();
      group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
    }

    @Override
    public Thread newThread(Runnable runnable) {

      final Thread thread = new Thread(group, runnable, "Import Entry - "
          + threadNumber.getAndIncrement(), 0);

      if (thread.getPriority() != Thread.NORM_PRIORITY) {
        thread.setPriority(Thread.NORM_PRIORITY);
      }

      thread.setDaemon(true);
      return thread;
    }
  }
}
