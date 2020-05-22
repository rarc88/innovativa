package ec.com.sidesoft.quick.billing.ad_process;

import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.openbravo.base.ConfigParameters;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.client.kernel.RequestContext;
import org.openbravo.dal.core.OBContext;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.model.financialmgmt.tax.TaxRate;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.DalBaseProcess;
import org.openbravo.service.db.DalConnectionProvider;
import org.quartz.SchedulerContext;

public class Sqb_PrintReportCloseQuickBillingByUser extends DalBaseProcess {
  OBError message;
  static Logger log4j = Logger.getLogger(Sqb_PrintReportCloseQuickBillingByUser.class);
  public static String dateTimeFormat;
  public static String sqlDateTimeFormat;
  private SchedulerContext ctx;
  public TaxRate taxRate;
  public String strSearchUserID;
  public String strAttachment;
  public String strFTP;
  public Connection connectionDB = null;
  public String strSearchInvoice;
  public ConfigParameters cf;
  public String successMessage = null;

  @Override
  protected void doExecute(ProcessBundle bundle) throws Exception {
    String language = OBContext.getOBContext().getLanguage().getLanguage();
    ConnectionProvider conn = new DalConnectionProvider(false);

    try {
      message = new OBError();
      processRequest(bundle);
    } catch (Exception e) {
      message.setTitle(Utility.messageBD(conn, "Error", language));
      message.setType("Error");
      message.setMessage(e.getMessage());
    } finally {
      bundle.setResult(message);
    }
    // Y process, N unprocess Status
  }

  private void processRequest(ProcessBundle bundle) {

    // Recuperar Formato de Fecha SQL
    cf = ConfigParameters.retrieveFrom(RequestContext.get().getRequest().getSession()
        .getServletContext());
    dateTimeFormat = cf.getJavaDateTimeFormat();
    VariablesSecureApp vars = bundle.getContext().toVars();
    strSearchUserID = vars.getUser() == null ? "ND" : vars.getUser();

    strAttachment = cf.getBaseDesignPath() + "/design/";
    strFTP = cf.strFTPDirectory;
    System.out.println("Ruta attachment: " + strAttachment);
    System.out.println("Ruta FTP: " + strFTP);
    ConnectionProvider conn = new DalConnectionProvider(false);

    try {
      connectionDB = conn.getTransactionConnection();
    } catch (Exception e) {

    }

    if (!strSearchUserID.equals("ND")) {
      printReport(vars, strSearchUserID);
    }
  }

  public static final String format(Date date) {
    return date == null ? null : new SimpleDateFormat(dateTimeFormat).format(date);
  }

  public ConfigParameters getConfigParameters() {
    return (ConfigParameters) ctx.get(ConfigParameters.CONFIG_ATTRIBUTE);
  }

  public void printReport(VariablesSecureApp vars, String strQuickBillingID) {
    final HttpServletRequest request = RequestContext.get().getRequest();
    final HttpServletResponse response = RequestContext.get().getResponse();

    Sqb_PrintReportCloseBoxQuickBilling sqbPrintPDF = new Sqb_PrintReportCloseBoxQuickBilling();
    try {
      sqbPrintPDF.doPost(request, response, strQuickBillingID, strAttachment, strFTP, connectionDB);

    } catch (IOException e) {
      e.printStackTrace();
    } catch (ServletException e) {
      e.printStackTrace();
    }

  }

}