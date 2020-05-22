
package org.openbravo.erpWindows.ec.com.sidesoft.budget.transfers.Budgetaryreforms;


import org.openbravo.erpCommon.reference.*;


import org.openbravo.erpCommon.ad_actionButton.*;


import org.openbravo.erpCommon.utility.*;
import org.openbravo.data.FieldProvider;
import org.openbravo.utils.FormatUtilities;
import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.base.exception.OBException;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.scheduling.ProcessRunner;
import org.openbravo.xmlEngine.XmlDocument;
import org.openbravo.database.SessionInfo;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

// Generated old code, not worth to make i.e. java imports perfect
@SuppressWarnings("unused")
public class BudgetaryreformsA5F838A4D797400B968816E1D33BFFBE extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "05C2A8D5AFAC4696B6F77348FB60BA4D";
  private static final String tabId = "A5F838A4D797400B968816E1D33BFFBE";
  private static final int accesslevel = 3;
  private static final String moduleId = "9620032C4FE8459BBFE6496B5446871A";
  
  @Override
  public void init(ServletConfig config) {
    setClassInfo("W", tabId, moduleId);
    super.init(config);
  }
  
  
  @Override
  public void service(HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
    VariablesSecureApp vars = new VariablesSecureApp(request);
    String command = vars.getCommand();
    
    boolean securedProcess = false;
    if (command.contains("BUTTON")) {
     List<String> explicitAccess = Arrays.asList( "");
    
     SessionInfo.setUserId(vars.getSessionValue("#AD_User_ID"));
     SessionInfo.setSessionId(vars.getSessionValue("#AD_Session_ID"));
     SessionInfo.setQueryProfile("manualProcess");
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     
      if (command.contains("48C11A70389344F298C765377148118A")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("48C11A70389344F298C765377148118A");
        SessionInfo.setModuleId("9620032C4FE8459BBFE6496B5446871A");
        if (securedProcess || explicitAccess.contains("48C11A70389344F298C765377148118A")) {
          classInfo.type = "P";
          classInfo.id = "48C11A70389344F298C765377148118A";
        }
      }
     
      if (command.contains("4D9BC99E5D0046F8ABBD079630CB33AC")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("4D9BC99E5D0046F8ABBD079630CB33AC");
        SessionInfo.setModuleId("9620032C4FE8459BBFE6496B5446871A");
        if (securedProcess || explicitAccess.contains("4D9BC99E5D0046F8ABBD079630CB33AC")) {
          classInfo.type = "P";
          classInfo.id = "4D9BC99E5D0046F8ABBD079630CB33AC";
        }
      }
     

     
    }
    if (!securedProcess) {
      setClassInfo("W", tabId, moduleId);
    }
    super.service(request, response);
  }
  

  public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
    VariablesSecureApp vars = new VariablesSecureApp(request);
    Boolean saveRequest = (Boolean) request.getAttribute("autosave");
    
    if(saveRequest != null && saveRequest){
      throw new OBException("2.50 style request.autosave is no longer supported: " + vars.getCommand());
    }
    
    if (vars.commandIn("DEFAULT", "DIRECT", "TAB", "SEARCH", "RELATION", "NEW", "EDIT", "NEXT",
        "PREVIOUS", "FIRST_RELATION", "PREVIOUS_RELATION", "NEXT_RELATION", "LAST_RELATION",
        "LAST", "SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT", "SAVE_EDIT_RELATION",
        "SAVE_EDIT_NEW", "SAVE_EDIT_EDIT", "SAVE_EDIT_NEXT", "DELETE", "SAVE_XHR")) {
      throw new OBException("2.50 style command is no longer supported: " + vars.getCommand());

     } else if (vars.commandIn("BUTTONActionbutton48C11A70389344F298C765377148118A")) {
        vars.setSessionValue("button48C11A70389344F298C765377148118A.stractionbutton", vars.getStringParameter("inpactionbutton"));
        vars.setSessionValue("button48C11A70389344F298C765377148118A.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button48C11A70389344F298C765377148118A.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button48C11A70389344F298C765377148118A.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button48C11A70389344F298C765377148118A.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "48C11A70389344F298C765377148118A", request.getServletPath());    
     } else if (vars.commandIn("BUTTON48C11A70389344F298C765377148118A")) {
        String strSfbtr_Budgetary_Reforms_ID = vars.getGlobalVariable("inpsfbtrBudgetaryReformsId", windowId + "|Sfbtr_Budgetary_Reforms_ID", "");
        String stractionbutton = vars.getSessionValue("button48C11A70389344F298C765377148118A.stractionbutton");
        String strProcessing = vars.getSessionValue("button48C11A70389344F298C765377148118A.strProcessing");
        String strOrg = vars.getSessionValue("button48C11A70389344F298C765377148118A.strOrg");
        String strClient = vars.getSessionValue("button48C11A70389344F298C765377148118A.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonActionbutton48C11A70389344F298C765377148118A(response, vars, strSfbtr_Budgetary_Reforms_ID, stractionbutton, strProcessing);
        }

     } else if (vars.commandIn("BUTTONActionbuttondes4D9BC99E5D0046F8ABBD079630CB33AC")) {
        vars.setSessionValue("button4D9BC99E5D0046F8ABBD079630CB33AC.stractionbuttondes", vars.getStringParameter("inpactionbuttondes"));
        vars.setSessionValue("button4D9BC99E5D0046F8ABBD079630CB33AC.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button4D9BC99E5D0046F8ABBD079630CB33AC.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button4D9BC99E5D0046F8ABBD079630CB33AC.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button4D9BC99E5D0046F8ABBD079630CB33AC.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "4D9BC99E5D0046F8ABBD079630CB33AC", request.getServletPath());    
     } else if (vars.commandIn("BUTTON4D9BC99E5D0046F8ABBD079630CB33AC")) {
        String strSfbtr_Budgetary_Reforms_ID = vars.getGlobalVariable("inpsfbtrBudgetaryReformsId", windowId + "|Sfbtr_Budgetary_Reforms_ID", "");
        String stractionbuttondes = vars.getSessionValue("button4D9BC99E5D0046F8ABBD079630CB33AC.stractionbuttondes");
        String strProcessing = vars.getSessionValue("button4D9BC99E5D0046F8ABBD079630CB33AC.strProcessing");
        String strOrg = vars.getSessionValue("button4D9BC99E5D0046F8ABBD079630CB33AC.strOrg");
        String strClient = vars.getSessionValue("button4D9BC99E5D0046F8ABBD079630CB33AC.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonActionbuttondes4D9BC99E5D0046F8ABBD079630CB33AC(response, vars, strSfbtr_Budgetary_Reforms_ID, stractionbuttondes, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONActionbutton48C11A70389344F298C765377148118A")) {
        String strSfbtr_Budgetary_Reforms_ID = vars.getGlobalVariable("inpKey", windowId + "|Sfbtr_Budgetary_Reforms_ID", "");
        String stractionbutton = vars.getStringParameter("inpactionbutton");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "48C11A70389344F298C765377148118A", (("Sfbtr_Budgetary_Reforms_ID".equalsIgnoreCase("AD_Language"))?"0":strSfbtr_Budgetary_Reforms_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
          ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
          new ProcessRunner(bundle).execute(this);
          
          PInstanceProcessData[] pinstanceData = PInstanceProcessData.select(this, pinstance);
          myMessage = Utility.getProcessInstanceMessage(this, vars, pinstanceData);
        } catch (ServletException ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          } else vars.setMessage(tabId, myMessage);
        }
        //close popup
        if (myMessage!=null) {
          if (log4j.isDebugEnabled()) log4j.debug(myMessage.getMessage());
          vars.setMessage(tabId, myMessage);
        }
        printPageClosePopUp(response, vars);
    } else if (vars.commandIn("SAVE_BUTTONActionbuttondes4D9BC99E5D0046F8ABBD079630CB33AC")) {
        String strSfbtr_Budgetary_Reforms_ID = vars.getGlobalVariable("inpKey", windowId + "|Sfbtr_Budgetary_Reforms_ID", "");
        String stractionbuttondes = vars.getStringParameter("inpactionbuttondes");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "4D9BC99E5D0046F8ABBD079630CB33AC", (("Sfbtr_Budgetary_Reforms_ID".equalsIgnoreCase("AD_Language"))?"0":strSfbtr_Budgetary_Reforms_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
          ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
          new ProcessRunner(bundle).execute(this);
          
          PInstanceProcessData[] pinstanceData = PInstanceProcessData.select(this, pinstance);
          myMessage = Utility.getProcessInstanceMessage(this, vars, pinstanceData);
        } catch (ServletException ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          } else vars.setMessage(tabId, myMessage);
        }
        //close popup
        if (myMessage!=null) {
          if (log4j.isDebugEnabled()) log4j.debug(myMessage.getMessage());
          vars.setMessage(tabId, myMessage);
        }
        printPageClosePopUp(response, vars);




    } else if (vars.getCommand().toUpperCase().startsWith("BUTTON") || vars.getCommand().toUpperCase().startsWith("SAVE_BUTTON")) {
      pageErrorPopUp(response);
    } else pageError(response);
  }

  private void printPageButtonFS(HttpServletResponse response, VariablesSecureApp vars, String strProcessId, String path) throws IOException, ServletException {
    log4j.debug("Output: Frames action button");
    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate(
        "org/openbravo/erpCommon/ad_actionButton/ActionButtonDefaultFrames").createXmlDocument();
    xmlDocument.ignoreTranslation = true;
    xmlDocument.setParameter("processId", strProcessId);
    xmlDocument.setParameter("trlFormType", "PROCESS");
    xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
    xmlDocument.setParameter("type", strDireccion + path);
    out.println(xmlDocument.print());
    out.close();
  }

    private void printPageButtonActionbutton48C11A70389344F298C765377148118A(HttpServletResponse response, VariablesSecureApp vars, String strSfbtr_Budgetary_Reforms_ID, String stractionbutton, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 48C11A70389344F298C765377148118A");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Actionbutton48C11A70389344F298C765377148118A", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSfbtr_Budgetary_Reforms_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "BudgetaryreformsA5F838A4D797400B968816E1D33BFFBE_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "48C11A70389344F298C765377148118A");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("48C11A70389344F298C765377148118A");
        vars.removeMessage("48C11A70389344F298C765377148118A");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      
      out.println(xmlDocument.print());
      out.close();
    }
    private void printPageButtonActionbuttondes4D9BC99E5D0046F8ABBD079630CB33AC(HttpServletResponse response, VariablesSecureApp vars, String strSfbtr_Budgetary_Reforms_ID, String stractionbuttondes, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 4D9BC99E5D0046F8ABBD079630CB33AC");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Actionbuttondes4D9BC99E5D0046F8ABBD079630CB33AC", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSfbtr_Budgetary_Reforms_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "BudgetaryreformsA5F838A4D797400B968816E1D33BFFBE_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "4D9BC99E5D0046F8ABBD079630CB33AC");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("4D9BC99E5D0046F8ABBD079630CB33AC");
        vars.removeMessage("4D9BC99E5D0046F8ABBD079630CB33AC");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      
      out.println(xmlDocument.print());
      out.close();
    }



}
