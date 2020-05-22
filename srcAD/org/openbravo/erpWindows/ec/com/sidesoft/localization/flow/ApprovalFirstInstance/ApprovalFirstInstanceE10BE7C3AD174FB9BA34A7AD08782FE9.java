
package org.openbravo.erpWindows.ec.com.sidesoft.localization.flow.ApprovalFirstInstance;


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
public class ApprovalFirstInstanceE10BE7C3AD174FB9BA34A7AD08782FE9 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "E1A9C0D2A1844B79BE4C9FA1E0FCFAEC";
  private static final String tabId = "E10BE7C3AD174FB9BA34A7AD08782FE9";
  private static final int accesslevel = 1;
  private static final String moduleId = "AEF6EDFE80F94F238460BAFE629B235B";
  
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
     
      if (command.contains("BCB5B8E9C9E64E75831B2E25E1BD5BEF")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("BCB5B8E9C9E64E75831B2E25E1BD5BEF");
        SessionInfo.setModuleId("AEF6EDFE80F94F238460BAFE629B235B");
        if (securedProcess || explicitAccess.contains("BCB5B8E9C9E64E75831B2E25E1BD5BEF")) {
          classInfo.type = "P";
          classInfo.id = "BCB5B8E9C9E64E75831B2E25E1BD5BEF";
        }
      }
     
      if (command.contains("104")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("104");
        SessionInfo.setModuleId("0");
        if (securedProcess || explicitAccess.contains("104")) {
          classInfo.type = "P";
          classInfo.id = "104";
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

     } else if (vars.commandIn("BUTTONEM_Ssfw_ApprovalBCB5B8E9C9E64E75831B2E25E1BD5BEF")) {
        vars.setSessionValue("buttonBCB5B8E9C9E64E75831B2E25E1BD5BEF.stremSsfwApproval", vars.getStringParameter("inpemSsfwApproval"));
        vars.setSessionValue("buttonBCB5B8E9C9E64E75831B2E25E1BD5BEF.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonBCB5B8E9C9E64E75831B2E25E1BD5BEF.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonBCB5B8E9C9E64E75831B2E25E1BD5BEF.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonBCB5B8E9C9E64E75831B2E25E1BD5BEF.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "BCB5B8E9C9E64E75831B2E25E1BD5BEF", request.getServletPath());    
     } else if (vars.commandIn("BUTTONBCB5B8E9C9E64E75831B2E25E1BD5BEF")) {
        String strC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID", "");
        String stremSsfwApproval = vars.getSessionValue("buttonBCB5B8E9C9E64E75831B2E25E1BD5BEF.stremSsfwApproval");
        String strProcessing = vars.getSessionValue("buttonBCB5B8E9C9E64E75831B2E25E1BD5BEF.strProcessing");
        String strOrg = vars.getSessionValue("buttonBCB5B8E9C9E64E75831B2E25E1BD5BEF.strOrg");
        String strClient = vars.getSessionValue("buttonBCB5B8E9C9E64E75831B2E25E1BD5BEF.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Ssfw_ApprovalBCB5B8E9C9E64E75831B2E25E1BD5BEF(response, vars, strC_Order_ID, stremSsfwApproval, strProcessing);
        }

     } else if (vars.commandIn("BUTTONEM_Ssfw_Reject104")) {
        vars.setSessionValue("button104.stremSsfwReject", vars.getStringParameter("inpemSsfwReject"));
        vars.setSessionValue("button104.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button104.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button104.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button104.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "104", request.getServletPath());    
     } else if (vars.commandIn("BUTTON104")) {
        String strC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID", "");
        String stremSsfwReject = vars.getSessionValue("button104.stremSsfwReject");
        String strProcessing = vars.getSessionValue("button104.strProcessing");
        String strOrg = vars.getSessionValue("button104.strOrg");
        String strClient = vars.getSessionValue("button104.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Ssfw_Reject104(response, vars, strC_Order_ID, stremSsfwReject, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONEM_Ssfw_ApprovalBCB5B8E9C9E64E75831B2E25E1BD5BEF")) {
        String strC_Order_ID = vars.getGlobalVariable("inpKey", windowId + "|C_Order_ID", "");
        String stremSsfwApproval = vars.getStringParameter("inpemSsfwApproval");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "BCB5B8E9C9E64E75831B2E25E1BD5BEF", (("C_Order_ID".equalsIgnoreCase("AD_Language"))?"0":strC_Order_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONEM_Ssfw_Reject104")) {
        String strC_Order_ID = vars.getGlobalVariable("inpKey", windowId + "|C_Order_ID", "");
        String stremSsfwReject = vars.getStringParameter("inpemSsfwReject");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "104", (("C_Order_ID".equalsIgnoreCase("AD_Language"))?"0":strC_Order_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    private void printPageButtonEM_Ssfw_ApprovalBCB5B8E9C9E64E75831B2E25E1BD5BEF(HttpServletResponse response, VariablesSecureApp vars, String strC_Order_ID, String stremSsfwApproval, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process BCB5B8E9C9E64E75831B2E25E1BD5BEF");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Ssfw_ApprovalBCB5B8E9C9E64E75831B2E25E1BD5BEF", discard).createXmlDocument();
      xmlDocument.setParameter("key", strC_Order_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "ApprovalFirstInstanceE10BE7C3AD174FB9BA34A7AD08782FE9_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "BCB5B8E9C9E64E75831B2E25E1BD5BEF");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("BCB5B8E9C9E64E75831B2E25E1BD5BEF");
        vars.removeMessage("BCB5B8E9C9E64E75831B2E25E1BD5BEF");
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
    private void printPageButtonEM_Ssfw_Reject104(HttpServletResponse response, VariablesSecureApp vars, String strC_Order_ID, String stremSsfwReject, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 104");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Ssfw_Reject104", discard).createXmlDocument();
      xmlDocument.setParameter("key", strC_Order_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "ApprovalFirstInstanceE10BE7C3AD174FB9BA34A7AD08782FE9_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "104");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("104");
        vars.removeMessage("104");
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
