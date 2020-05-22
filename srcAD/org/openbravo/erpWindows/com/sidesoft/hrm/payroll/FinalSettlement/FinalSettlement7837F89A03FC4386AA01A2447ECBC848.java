
package org.openbravo.erpWindows.com.sidesoft.hrm.payroll.FinalSettlement;


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
public class FinalSettlement7837F89A03FC4386AA01A2447ECBC848 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "3F0BFA1E7F2643CD84E05BA6BDA8220D";
  private static final String tabId = "7837F89A03FC4386AA01A2447ECBC848";
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
     
      if (command.contains("A6257031E1CE4E6695EEF614F243E129")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("A6257031E1CE4E6695EEF614F243E129");
        SessionInfo.setModuleId("169A6DDBFEB948C98F0617CE3B4CABD5");
        if (securedProcess || explicitAccess.contains("A6257031E1CE4E6695EEF614F243E129")) {
          classInfo.type = "P";
          classInfo.id = "A6257031E1CE4E6695EEF614F243E129";
        }
      }
     
      if (command.contains("EE081693B6A9405C8A2068E531FB714E")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("EE081693B6A9405C8A2068E531FB714E");
        SessionInfo.setModuleId("169A6DDBFEB948C98F0617CE3B4CABD5");
        if (securedProcess || explicitAccess.contains("EE081693B6A9405C8A2068E531FB714E")) {
          classInfo.type = "P";
          classInfo.id = "EE081693B6A9405C8A2068E531FB714E";
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

     } else if (vars.commandIn("BUTTONProcessedA6257031E1CE4E6695EEF614F243E129")) {
        vars.setSessionValue("buttonA6257031E1CE4E6695EEF614F243E129.strprocessed", vars.getStringParameter("inpprocessed"));
        vars.setSessionValue("buttonA6257031E1CE4E6695EEF614F243E129.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonA6257031E1CE4E6695EEF614F243E129.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonA6257031E1CE4E6695EEF614F243E129.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonA6257031E1CE4E6695EEF614F243E129.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "A6257031E1CE4E6695EEF614F243E129", request.getServletPath());    
     } else if (vars.commandIn("BUTTONA6257031E1CE4E6695EEF614F243E129")) {
        String strSspr_Settlement_ID = vars.getGlobalVariable("inpssprSettlementId", windowId + "|Sspr_Settlement_ID", "");
        String strprocessed = vars.getSessionValue("buttonA6257031E1CE4E6695EEF614F243E129.strprocessed");
        String strProcessing = vars.getSessionValue("buttonA6257031E1CE4E6695EEF614F243E129.strProcessing");
        String strOrg = vars.getSessionValue("buttonA6257031E1CE4E6695EEF614F243E129.strOrg");
        String strClient = vars.getSessionValue("buttonA6257031E1CE4E6695EEF614F243E129.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcessedA6257031E1CE4E6695EEF614F243E129(response, vars, strSspr_Settlement_ID, strprocessed, strProcessing);
        }

     } else if (vars.commandIn("BUTTONCompleteEE081693B6A9405C8A2068E531FB714E")) {
        vars.setSessionValue("buttonEE081693B6A9405C8A2068E531FB714E.strcomplete", vars.getStringParameter("inpcomplete"));
        vars.setSessionValue("buttonEE081693B6A9405C8A2068E531FB714E.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonEE081693B6A9405C8A2068E531FB714E.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonEE081693B6A9405C8A2068E531FB714E.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonEE081693B6A9405C8A2068E531FB714E.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "EE081693B6A9405C8A2068E531FB714E", request.getServletPath());    
     } else if (vars.commandIn("BUTTONEE081693B6A9405C8A2068E531FB714E")) {
        String strSspr_Settlement_ID = vars.getGlobalVariable("inpssprSettlementId", windowId + "|Sspr_Settlement_ID", "");
        String strcomplete = vars.getSessionValue("buttonEE081693B6A9405C8A2068E531FB714E.strcomplete");
        String strProcessing = vars.getSessionValue("buttonEE081693B6A9405C8A2068E531FB714E.strProcessing");
        String strOrg = vars.getSessionValue("buttonEE081693B6A9405C8A2068E531FB714E.strOrg");
        String strClient = vars.getSessionValue("buttonEE081693B6A9405C8A2068E531FB714E.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonCompleteEE081693B6A9405C8A2068E531FB714E(response, vars, strSspr_Settlement_ID, strcomplete, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONProcessedA6257031E1CE4E6695EEF614F243E129")) {
        String strSspr_Settlement_ID = vars.getGlobalVariable("inpKey", windowId + "|Sspr_Settlement_ID", "");
        String strprocessed = vars.getStringParameter("inpprocessed");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "A6257031E1CE4E6695EEF614F243E129", (("Sspr_Settlement_ID".equalsIgnoreCase("AD_Language"))?"0":strSspr_Settlement_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONCompleteEE081693B6A9405C8A2068E531FB714E")) {
        String strSspr_Settlement_ID = vars.getGlobalVariable("inpKey", windowId + "|Sspr_Settlement_ID", "");
        String strcomplete = vars.getStringParameter("inpcomplete");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "EE081693B6A9405C8A2068E531FB714E", (("Sspr_Settlement_ID".equalsIgnoreCase("AD_Language"))?"0":strSspr_Settlement_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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



    } else if (vars.commandIn("BUTTONPosted")) {
        String strSspr_Settlement_ID = vars.getGlobalVariable("inpssprSettlementId", windowId + "|Sspr_Settlement_ID", "");
        String strTableId = "DC962E28F8E2426DB8C0AD4BF8744B8D";
        String strPosted = vars.getStringParameter("inpposted");
        String strProcessId = "";
        log4j.debug("Loading Posted button in table: " + strTableId);
        String strOrg = vars.getStringParameter("inpadOrgId");
        String strClient = vars.getStringParameter("inpadClientId");
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{
          vars.setSessionValue("Posted|key", strSspr_Settlement_ID);
          vars.setSessionValue("Posted|tableId", strTableId);
          vars.setSessionValue("Posted|tabId", tabId);
          vars.setSessionValue("Posted|posted", strPosted);
          vars.setSessionValue("Posted|processId", strProcessId);
          vars.setSessionValue("Posted|path", strDireccion + request.getServletPath());
          vars.setSessionValue("Posted|windowId", windowId);
          vars.setSessionValue("Posted|tabName", "FinalSettlement7837F89A03FC4386AA01A2447ECBC848");
          response.sendRedirect(strDireccion + "/ad_actionButton/Posted.html");
        }

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

    private void printPageButtonProcessedA6257031E1CE4E6695EEF614F243E129(HttpServletResponse response, VariablesSecureApp vars, String strSspr_Settlement_ID, String strprocessed, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process A6257031E1CE4E6695EEF614F243E129");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ProcessedA6257031E1CE4E6695EEF614F243E129", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSspr_Settlement_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "FinalSettlement7837F89A03FC4386AA01A2447ECBC848_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "A6257031E1CE4E6695EEF614F243E129");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("A6257031E1CE4E6695EEF614F243E129");
        vars.removeMessage("A6257031E1CE4E6695EEF614F243E129");
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
    private void printPageButtonCompleteEE081693B6A9405C8A2068E531FB714E(HttpServletResponse response, VariablesSecureApp vars, String strSspr_Settlement_ID, String strcomplete, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process EE081693B6A9405C8A2068E531FB714E");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/CompleteEE081693B6A9405C8A2068E531FB714E", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSspr_Settlement_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "FinalSettlement7837F89A03FC4386AA01A2447ECBC848_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "EE081693B6A9405C8A2068E531FB714E");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("EE081693B6A9405C8A2068E531FB714E");
        vars.removeMessage("EE081693B6A9405C8A2068E531FB714E");
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
