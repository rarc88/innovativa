
package org.openbravo.erpWindows.com.sidesoft.ecuador.asset.allocation.ReturnActive;


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
public class ReturnActive04B7D63E1CC84DEAA692ED791FAB12F9 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "1BCE01C581F848AC8710B8DFC2C8B9B2";
  private static final String tabId = "04B7D63E1CC84DEAA692ED791FAB12F9";
  private static final int accesslevel = 3;
  private static final String moduleId = "1718FB3B55584F899FEEBF24BFF807AF";
  
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
     
      if (command.contains("0F9CBED1BEE64CBEA85095C6132F5EC9")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("0F9CBED1BEE64CBEA85095C6132F5EC9");
        SessionInfo.setModuleId("1718FB3B55584F899FEEBF24BFF807AF");
        if (securedProcess || explicitAccess.contains("0F9CBED1BEE64CBEA85095C6132F5EC9")) {
          classInfo.type = "P";
          classInfo.id = "0F9CBED1BEE64CBEA85095C6132F5EC9";
        }
      }
     
      if (command.contains("F398E0CF81C7455E8A811A11B42DDD0B")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("F398E0CF81C7455E8A811A11B42DDD0B");
        SessionInfo.setModuleId("1718FB3B55584F899FEEBF24BFF807AF");
        if (securedProcess || explicitAccess.contains("F398E0CF81C7455E8A811A11B42DDD0B")) {
          classInfo.type = "P";
          classInfo.id = "F398E0CF81C7455E8A811A11B42DDD0B";
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

     } else if (vars.commandIn("BUTTONLoad_Active0F9CBED1BEE64CBEA85095C6132F5EC9")) {
        vars.setSessionValue("button0F9CBED1BEE64CBEA85095C6132F5EC9.strloadActive", vars.getStringParameter("inploadActive"));
        vars.setSessionValue("button0F9CBED1BEE64CBEA85095C6132F5EC9.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button0F9CBED1BEE64CBEA85095C6132F5EC9.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button0F9CBED1BEE64CBEA85095C6132F5EC9.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button0F9CBED1BEE64CBEA85095C6132F5EC9.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "0F9CBED1BEE64CBEA85095C6132F5EC9", request.getServletPath());    
     } else if (vars.commandIn("BUTTON0F9CBED1BEE64CBEA85095C6132F5EC9")) {
        String strSsal_Asset_Return_ID = vars.getGlobalVariable("inpssalAssetReturnId", windowId + "|Ssal_Asset_Return_ID", "");
        String strloadActive = vars.getSessionValue("button0F9CBED1BEE64CBEA85095C6132F5EC9.strloadActive");
        String strProcessing = vars.getSessionValue("button0F9CBED1BEE64CBEA85095C6132F5EC9.strProcessing");
        String strOrg = vars.getSessionValue("button0F9CBED1BEE64CBEA85095C6132F5EC9.strOrg");
        String strClient = vars.getSessionValue("button0F9CBED1BEE64CBEA85095C6132F5EC9.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonLoad_Active0F9CBED1BEE64CBEA85095C6132F5EC9(response, vars, strSsal_Asset_Return_ID, strloadActive, strProcessing);
        }

     } else if (vars.commandIn("BUTTONGeneratelinesF398E0CF81C7455E8A811A11B42DDD0B")) {
        vars.setSessionValue("buttonF398E0CF81C7455E8A811A11B42DDD0B.strgeneratelines", vars.getStringParameter("inpgeneratelines"));
        vars.setSessionValue("buttonF398E0CF81C7455E8A811A11B42DDD0B.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonF398E0CF81C7455E8A811A11B42DDD0B.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonF398E0CF81C7455E8A811A11B42DDD0B.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonF398E0CF81C7455E8A811A11B42DDD0B.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "F398E0CF81C7455E8A811A11B42DDD0B", request.getServletPath());    
     } else if (vars.commandIn("BUTTONF398E0CF81C7455E8A811A11B42DDD0B")) {
        String strSsal_Asset_Return_ID = vars.getGlobalVariable("inpssalAssetReturnId", windowId + "|Ssal_Asset_Return_ID", "");
        String strgeneratelines = vars.getSessionValue("buttonF398E0CF81C7455E8A811A11B42DDD0B.strgeneratelines");
        String strProcessing = vars.getSessionValue("buttonF398E0CF81C7455E8A811A11B42DDD0B.strProcessing");
        String strOrg = vars.getSessionValue("buttonF398E0CF81C7455E8A811A11B42DDD0B.strOrg");
        String strClient = vars.getSessionValue("buttonF398E0CF81C7455E8A811A11B42DDD0B.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonGeneratelinesF398E0CF81C7455E8A811A11B42DDD0B(response, vars, strSsal_Asset_Return_ID, strgeneratelines, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONLoad_Active0F9CBED1BEE64CBEA85095C6132F5EC9")) {
        String strSsal_Asset_Return_ID = vars.getGlobalVariable("inpKey", windowId + "|Ssal_Asset_Return_ID", "");
        String strloadActive = vars.getStringParameter("inploadActive");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "0F9CBED1BEE64CBEA85095C6132F5EC9", (("Ssal_Asset_Return_ID".equalsIgnoreCase("AD_Language"))?"0":strSsal_Asset_Return_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONGeneratelinesF398E0CF81C7455E8A811A11B42DDD0B")) {
        String strSsal_Asset_Return_ID = vars.getGlobalVariable("inpKey", windowId + "|Ssal_Asset_Return_ID", "");
        String strgeneratelines = vars.getStringParameter("inpgeneratelines");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "F398E0CF81C7455E8A811A11B42DDD0B", (("Ssal_Asset_Return_ID".equalsIgnoreCase("AD_Language"))?"0":strSsal_Asset_Return_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    private void printPageButtonLoad_Active0F9CBED1BEE64CBEA85095C6132F5EC9(HttpServletResponse response, VariablesSecureApp vars, String strSsal_Asset_Return_ID, String strloadActive, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 0F9CBED1BEE64CBEA85095C6132F5EC9");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Load_Active0F9CBED1BEE64CBEA85095C6132F5EC9", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSsal_Asset_Return_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "ReturnActive04B7D63E1CC84DEAA692ED791FAB12F9_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "0F9CBED1BEE64CBEA85095C6132F5EC9");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("0F9CBED1BEE64CBEA85095C6132F5EC9");
        vars.removeMessage("0F9CBED1BEE64CBEA85095C6132F5EC9");
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
    private void printPageButtonGeneratelinesF398E0CF81C7455E8A811A11B42DDD0B(HttpServletResponse response, VariablesSecureApp vars, String strSsal_Asset_Return_ID, String strgeneratelines, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process F398E0CF81C7455E8A811A11B42DDD0B");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/GeneratelinesF398E0CF81C7455E8A811A11B42DDD0B", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSsal_Asset_Return_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "ReturnActive04B7D63E1CC84DEAA692ED791FAB12F9_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "F398E0CF81C7455E8A811A11B42DDD0B");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("F398E0CF81C7455E8A811A11B42DDD0B");
        vars.removeMessage("F398E0CF81C7455E8A811A11B42DDD0B");
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
