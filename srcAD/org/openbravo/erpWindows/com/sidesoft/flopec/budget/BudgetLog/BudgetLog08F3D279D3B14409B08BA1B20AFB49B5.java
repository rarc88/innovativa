
package org.openbravo.erpWindows.com.sidesoft.flopec.budget.BudgetLog;


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
public class BudgetLog08F3D279D3B14409B08BA1B20AFB49B5 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "D649C02936244ED2BDC062547D579E39";
  private static final String tabId = "08F3D279D3B14409B08BA1B20AFB49B5";
  private static final int accesslevel = 3;
  private static final String moduleId = "75856ABEF4614636A5FABB70AD0CD4C8";
  
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
     
      if (command.contains("E53228B7BE4143B5870F5BE80015CC09")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("E53228B7BE4143B5870F5BE80015CC09");
        SessionInfo.setModuleId("75856ABEF4614636A5FABB70AD0CD4C8");
        if (securedProcess || explicitAccess.contains("E53228B7BE4143B5870F5BE80015CC09")) {
          classInfo.type = "P";
          classInfo.id = "E53228B7BE4143B5870F5BE80015CC09";
        }
      }
     
      if (command.contains("3554A6EF36544167B80B576909EC1F8A")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("3554A6EF36544167B80B576909EC1F8A");
        SessionInfo.setModuleId("75856ABEF4614636A5FABB70AD0CD4C8");
        if (securedProcess || explicitAccess.contains("3554A6EF36544167B80B576909EC1F8A")) {
          classInfo.type = "P";
          classInfo.id = "3554A6EF36544167B80B576909EC1F8A";
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

     } else if (vars.commandIn("BUTTONProcessE53228B7BE4143B5870F5BE80015CC09")) {
        vars.setSessionValue("buttonE53228B7BE4143B5870F5BE80015CC09.strprocess", vars.getStringParameter("inpprocess"));
        vars.setSessionValue("buttonE53228B7BE4143B5870F5BE80015CC09.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonE53228B7BE4143B5870F5BE80015CC09.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonE53228B7BE4143B5870F5BE80015CC09.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonE53228B7BE4143B5870F5BE80015CC09.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "E53228B7BE4143B5870F5BE80015CC09", request.getServletPath());    
     } else if (vars.commandIn("BUTTONE53228B7BE4143B5870F5BE80015CC09")) {
        String strSFB_Budget_Log_ID = vars.getGlobalVariable("inpsfbBudgetLogId", windowId + "|SFB_Budget_Log_ID", "");
        String strprocess = vars.getSessionValue("buttonE53228B7BE4143B5870F5BE80015CC09.strprocess");
        String strProcessing = vars.getSessionValue("buttonE53228B7BE4143B5870F5BE80015CC09.strProcessing");
        String strOrg = vars.getSessionValue("buttonE53228B7BE4143B5870F5BE80015CC09.strOrg");
        String strClient = vars.getSessionValue("buttonE53228B7BE4143B5870F5BE80015CC09.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcessE53228B7BE4143B5870F5BE80015CC09(response, vars, strSFB_Budget_Log_ID, strprocess, strProcessing);
        }

     } else if (vars.commandIn("BUTTONGetlines3554A6EF36544167B80B576909EC1F8A")) {
        vars.setSessionValue("button3554A6EF36544167B80B576909EC1F8A.strgetlines", vars.getStringParameter("inpgetlines"));
        vars.setSessionValue("button3554A6EF36544167B80B576909EC1F8A.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button3554A6EF36544167B80B576909EC1F8A.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button3554A6EF36544167B80B576909EC1F8A.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button3554A6EF36544167B80B576909EC1F8A.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "3554A6EF36544167B80B576909EC1F8A", request.getServletPath());    
     } else if (vars.commandIn("BUTTON3554A6EF36544167B80B576909EC1F8A")) {
        String strSFB_Budget_Log_ID = vars.getGlobalVariable("inpsfbBudgetLogId", windowId + "|SFB_Budget_Log_ID", "");
        String strgetlines = vars.getSessionValue("button3554A6EF36544167B80B576909EC1F8A.strgetlines");
        String strProcessing = vars.getSessionValue("button3554A6EF36544167B80B576909EC1F8A.strProcessing");
        String strOrg = vars.getSessionValue("button3554A6EF36544167B80B576909EC1F8A.strOrg");
        String strClient = vars.getSessionValue("button3554A6EF36544167B80B576909EC1F8A.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonGetlines3554A6EF36544167B80B576909EC1F8A(response, vars, strSFB_Budget_Log_ID, strgetlines, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONProcessE53228B7BE4143B5870F5BE80015CC09")) {
        String strSFB_Budget_Log_ID = vars.getGlobalVariable("inpKey", windowId + "|SFB_Budget_Log_ID", "");
        String strprocess = vars.getStringParameter("inpprocess");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "E53228B7BE4143B5870F5BE80015CC09", (("SFB_Budget_Log_ID".equalsIgnoreCase("AD_Language"))?"0":strSFB_Budget_Log_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONGetlines3554A6EF36544167B80B576909EC1F8A")) {
        String strSFB_Budget_Log_ID = vars.getGlobalVariable("inpKey", windowId + "|SFB_Budget_Log_ID", "");
        String strgetlines = vars.getStringParameter("inpgetlines");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "3554A6EF36544167B80B576909EC1F8A", (("SFB_Budget_Log_ID".equalsIgnoreCase("AD_Language"))?"0":strSFB_Budget_Log_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    private void printPageButtonProcessE53228B7BE4143B5870F5BE80015CC09(HttpServletResponse response, VariablesSecureApp vars, String strSFB_Budget_Log_ID, String strprocess, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process E53228B7BE4143B5870F5BE80015CC09");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ProcessE53228B7BE4143B5870F5BE80015CC09", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSFB_Budget_Log_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "BudgetLog08F3D279D3B14409B08BA1B20AFB49B5_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "E53228B7BE4143B5870F5BE80015CC09");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("E53228B7BE4143B5870F5BE80015CC09");
        vars.removeMessage("E53228B7BE4143B5870F5BE80015CC09");
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
    private void printPageButtonGetlines3554A6EF36544167B80B576909EC1F8A(HttpServletResponse response, VariablesSecureApp vars, String strSFB_Budget_Log_ID, String strgetlines, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 3554A6EF36544167B80B576909EC1F8A");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Getlines3554A6EF36544167B80B576909EC1F8A", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSFB_Budget_Log_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "BudgetLog08F3D279D3B14409B08BA1B20AFB49B5_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "3554A6EF36544167B80B576909EC1F8A");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("3554A6EF36544167B80B576909EC1F8A");
        vars.removeMessage("3554A6EF36544167B80B576909EC1F8A");
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
