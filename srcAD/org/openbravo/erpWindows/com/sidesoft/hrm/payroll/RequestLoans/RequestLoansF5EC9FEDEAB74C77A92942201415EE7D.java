
package org.openbravo.erpWindows.com.sidesoft.hrm.payroll.RequestLoans;


import org.openbravo.erpCommon.reference.*;



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
public class RequestLoansF5EC9FEDEAB74C77A92942201415EE7D extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "DC31E6F121DF4D76B896CCE17FF3E699";
  private static final String tabId = "F5EC9FEDEAB74C77A92942201415EE7D";
  private static final int accesslevel = 3;
  private static final String moduleId = "169A6DDBFEB948C98F0617CE3B4CABD5";
  
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
     
      if (command.contains("7160E828ED0646D0B9A63C9DCEE777B5")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("7160E828ED0646D0B9A63C9DCEE777B5");
        SessionInfo.setModuleId("169A6DDBFEB948C98F0617CE3B4CABD5");
        if (securedProcess || explicitAccess.contains("7160E828ED0646D0B9A63C9DCEE777B5")) {
          classInfo.type = "P";
          classInfo.id = "7160E828ED0646D0B9A63C9DCEE777B5";
        }
      }
     
      if (command.contains("35F175AAF27348EC900221DC46412586")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("35F175AAF27348EC900221DC46412586");
        SessionInfo.setModuleId("169A6DDBFEB948C98F0617CE3B4CABD5");
        if (securedProcess || explicitAccess.contains("35F175AAF27348EC900221DC46412586")) {
          classInfo.type = "P";
          classInfo.id = "35F175AAF27348EC900221DC46412586";
        }
      }
     
      if (command.contains("5C46DE95579F426E9EE06A87093DC2A1")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("5C46DE95579F426E9EE06A87093DC2A1");
        SessionInfo.setModuleId("169A6DDBFEB948C98F0617CE3B4CABD5");
        if (securedProcess || explicitAccess.contains("5C46DE95579F426E9EE06A87093DC2A1")) {
          classInfo.type = "P";
          classInfo.id = "5C46DE95579F426E9EE06A87093DC2A1";
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

     } else if (vars.commandIn("BUTTONComplete7160E828ED0646D0B9A63C9DCEE777B5")) {
        vars.setSessionValue("button7160E828ED0646D0B9A63C9DCEE777B5.strcomplete", vars.getStringParameter("inpcomplete"));
        vars.setSessionValue("button7160E828ED0646D0B9A63C9DCEE777B5.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button7160E828ED0646D0B9A63C9DCEE777B5.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button7160E828ED0646D0B9A63C9DCEE777B5.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button7160E828ED0646D0B9A63C9DCEE777B5.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "7160E828ED0646D0B9A63C9DCEE777B5", request.getServletPath());    
     } else if (vars.commandIn("BUTTON7160E828ED0646D0B9A63C9DCEE777B5")) {
        String strSspr_Loans_ID = vars.getGlobalVariable("inpssprLoansId", windowId + "|Sspr_Loans_ID", "");
        String strcomplete = vars.getSessionValue("button7160E828ED0646D0B9A63C9DCEE777B5.strcomplete");
        String strProcessing = vars.getSessionValue("button7160E828ED0646D0B9A63C9DCEE777B5.strProcessing");
        String strOrg = vars.getSessionValue("button7160E828ED0646D0B9A63C9DCEE777B5.strOrg");
        String strClient = vars.getSessionValue("button7160E828ED0646D0B9A63C9DCEE777B5.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonComplete7160E828ED0646D0B9A63C9DCEE777B5(response, vars, strSspr_Loans_ID, strcomplete, strProcessing);
        }

     } else if (vars.commandIn("BUTTONCompletestatus35F175AAF27348EC900221DC46412586")) {
        vars.setSessionValue("button35F175AAF27348EC900221DC46412586.strcompletestatus", vars.getStringParameter("inpcompletestatus"));
        vars.setSessionValue("button35F175AAF27348EC900221DC46412586.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button35F175AAF27348EC900221DC46412586.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button35F175AAF27348EC900221DC46412586.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button35F175AAF27348EC900221DC46412586.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "35F175AAF27348EC900221DC46412586", request.getServletPath());    
     } else if (vars.commandIn("BUTTON35F175AAF27348EC900221DC46412586")) {
        String strSspr_Loans_ID = vars.getGlobalVariable("inpssprLoansId", windowId + "|Sspr_Loans_ID", "");
        String strcompletestatus = vars.getSessionValue("button35F175AAF27348EC900221DC46412586.strcompletestatus");
        String strProcessing = vars.getSessionValue("button35F175AAF27348EC900221DC46412586.strProcessing");
        String strOrg = vars.getSessionValue("button35F175AAF27348EC900221DC46412586.strOrg");
        String strClient = vars.getSessionValue("button35F175AAF27348EC900221DC46412586.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonCompletestatus35F175AAF27348EC900221DC46412586(response, vars, strSspr_Loans_ID, strcompletestatus, strProcessing);
        }

     } else if (vars.commandIn("BUTTONReactive5C46DE95579F426E9EE06A87093DC2A1")) {
        vars.setSessionValue("button5C46DE95579F426E9EE06A87093DC2A1.strreactive", vars.getStringParameter("inpreactive"));
        vars.setSessionValue("button5C46DE95579F426E9EE06A87093DC2A1.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button5C46DE95579F426E9EE06A87093DC2A1.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button5C46DE95579F426E9EE06A87093DC2A1.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button5C46DE95579F426E9EE06A87093DC2A1.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "5C46DE95579F426E9EE06A87093DC2A1", request.getServletPath());    
     } else if (vars.commandIn("BUTTON5C46DE95579F426E9EE06A87093DC2A1")) {
        String strSspr_Loans_ID = vars.getGlobalVariable("inpssprLoansId", windowId + "|Sspr_Loans_ID", "");
        String strreactive = vars.getSessionValue("button5C46DE95579F426E9EE06A87093DC2A1.strreactive");
        String strProcessing = vars.getSessionValue("button5C46DE95579F426E9EE06A87093DC2A1.strProcessing");
        String strOrg = vars.getSessionValue("button5C46DE95579F426E9EE06A87093DC2A1.strOrg");
        String strClient = vars.getSessionValue("button5C46DE95579F426E9EE06A87093DC2A1.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonReactive5C46DE95579F426E9EE06A87093DC2A1(response, vars, strSspr_Loans_ID, strreactive, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONComplete7160E828ED0646D0B9A63C9DCEE777B5")) {
        String strSspr_Loans_ID = vars.getGlobalVariable("inpKey", windowId + "|Sspr_Loans_ID", "");
        String strcomplete = vars.getStringParameter("inpcomplete");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "7160E828ED0646D0B9A63C9DCEE777B5", (("Sspr_Loans_ID".equalsIgnoreCase("AD_Language"))?"0":strSspr_Loans_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONCompletestatus35F175AAF27348EC900221DC46412586")) {
        String strSspr_Loans_ID = vars.getGlobalVariable("inpKey", windowId + "|Sspr_Loans_ID", "");
        String strcompletestatus = vars.getStringParameter("inpcompletestatus");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "35F175AAF27348EC900221DC46412586", (("Sspr_Loans_ID".equalsIgnoreCase("AD_Language"))?"0":strSspr_Loans_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          String strstatusdoc = vars.getStringParameter("inpstatusdoc");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "statusdoc", strstatusdoc, vars.getClient(), vars.getOrg(), vars.getUser());

          
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
    } else if (vars.commandIn("SAVE_BUTTONReactive5C46DE95579F426E9EE06A87093DC2A1")) {
        String strSspr_Loans_ID = vars.getGlobalVariable("inpKey", windowId + "|Sspr_Loans_ID", "");
        String strreactive = vars.getStringParameter("inpreactive");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "5C46DE95579F426E9EE06A87093DC2A1", (("Sspr_Loans_ID".equalsIgnoreCase("AD_Language"))?"0":strSspr_Loans_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    private void printPageButtonComplete7160E828ED0646D0B9A63C9DCEE777B5(HttpServletResponse response, VariablesSecureApp vars, String strSspr_Loans_ID, String strcomplete, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 7160E828ED0646D0B9A63C9DCEE777B5");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Complete7160E828ED0646D0B9A63C9DCEE777B5", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSspr_Loans_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "RequestLoansF5EC9FEDEAB74C77A92942201415EE7D_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "7160E828ED0646D0B9A63C9DCEE777B5");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("7160E828ED0646D0B9A63C9DCEE777B5");
        vars.removeMessage("7160E828ED0646D0B9A63C9DCEE777B5");
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
    private void printPageButtonCompletestatus35F175AAF27348EC900221DC46412586(HttpServletResponse response, VariablesSecureApp vars, String strSspr_Loans_ID, String strcompletestatus, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 35F175AAF27348EC900221DC46412586");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Completestatus35F175AAF27348EC900221DC46412586", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSspr_Loans_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "RequestLoansF5EC9FEDEAB74C77A92942201415EE7D_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "35F175AAF27348EC900221DC46412586");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("35F175AAF27348EC900221DC46412586");
        vars.removeMessage("35F175AAF27348EC900221DC46412586");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("statusdoc", "");
    comboTableData = new ComboTableData(vars, this, "17", "statusdoc", "6A5520572FA54CD290F547BE26FCED5A", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, (FieldProvider) vars.getSessionObject("button35F175AAF27348EC900221DC46412586.originalParams"), comboTableData, windowId, "");
    xmlDocument.setData("reportstatusdoc", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      
      out.println(xmlDocument.print());
      out.close();
    }
    private void printPageButtonReactive5C46DE95579F426E9EE06A87093DC2A1(HttpServletResponse response, VariablesSecureApp vars, String strSspr_Loans_ID, String strreactive, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 5C46DE95579F426E9EE06A87093DC2A1");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Reactive5C46DE95579F426E9EE06A87093DC2A1", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSspr_Loans_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "RequestLoansF5EC9FEDEAB74C77A92942201415EE7D_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "5C46DE95579F426E9EE06A87093DC2A1");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("5C46DE95579F426E9EE06A87093DC2A1");
        vars.removeMessage("5C46DE95579F426E9EE06A87093DC2A1");
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
