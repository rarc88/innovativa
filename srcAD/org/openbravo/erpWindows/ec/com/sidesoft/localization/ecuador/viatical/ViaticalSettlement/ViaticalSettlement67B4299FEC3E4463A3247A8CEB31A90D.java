
package org.openbravo.erpWindows.ec.com.sidesoft.localization.ecuador.viatical.ViaticalSettlement;


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
public class ViaticalSettlement67B4299FEC3E4463A3247A8CEB31A90D extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "5DDCA5F8BC6E456791A480D97916527A";
  private static final String tabId = "67B4299FEC3E4463A3247A8CEB31A90D";
  private static final int accesslevel = 3;
  private static final String moduleId = "34806599C8BE45F7916577F44028DFB2";
  
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
     
      if (command.contains("DFAADA670A39474496E7559755480708")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("DFAADA670A39474496E7559755480708");
        SessionInfo.setModuleId("34806599C8BE45F7916577F44028DFB2");
        if (securedProcess || explicitAccess.contains("DFAADA670A39474496E7559755480708")) {
          classInfo.type = "P";
          classInfo.id = "DFAADA670A39474496E7559755480708";
        }
      }
     
      if (command.contains("A39CE7408400461E86C06D1FE6BF4BA4")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("A39CE7408400461E86C06D1FE6BF4BA4");
        SessionInfo.setModuleId("34806599C8BE45F7916577F44028DFB2");
        if (securedProcess || explicitAccess.contains("A39CE7408400461E86C06D1FE6BF4BA4")) {
          classInfo.type = "P";
          classInfo.id = "A39CE7408400461E86C06D1FE6BF4BA4";
        }
      }
     
      if (command.contains("7C86BE53A1F14B32BD1290CF85776D12")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("7C86BE53A1F14B32BD1290CF85776D12");
        SessionInfo.setModuleId("34806599C8BE45F7916577F44028DFB2");
        if (securedProcess || explicitAccess.contains("7C86BE53A1F14B32BD1290CF85776D12")) {
          classInfo.type = "P";
          classInfo.id = "7C86BE53A1F14B32BD1290CF85776D12";
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

     } else if (vars.commandIn("BUTTONGetlinesDFAADA670A39474496E7559755480708")) {
        vars.setSessionValue("buttonDFAADA670A39474496E7559755480708.strgetlines", vars.getStringParameter("inpgetlines"));
        vars.setSessionValue("buttonDFAADA670A39474496E7559755480708.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonDFAADA670A39474496E7559755480708.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonDFAADA670A39474496E7559755480708.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonDFAADA670A39474496E7559755480708.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "DFAADA670A39474496E7559755480708", request.getServletPath());    
     } else if (vars.commandIn("BUTTONDFAADA670A39474496E7559755480708")) {
        String strSsve_Viatical_Settlement_ID = vars.getGlobalVariable("inpssveViaticalSettlementId", windowId + "|Ssve_Viatical_Settlement_ID", "");
        String strgetlines = vars.getSessionValue("buttonDFAADA670A39474496E7559755480708.strgetlines");
        String strProcessing = vars.getSessionValue("buttonDFAADA670A39474496E7559755480708.strProcessing");
        String strOrg = vars.getSessionValue("buttonDFAADA670A39474496E7559755480708.strOrg");
        String strClient = vars.getSessionValue("buttonDFAADA670A39474496E7559755480708.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonGetlinesDFAADA670A39474496E7559755480708(response, vars, strSsve_Viatical_Settlement_ID, strgetlines, strProcessing);
        }

     } else if (vars.commandIn("BUTTONProcessedA39CE7408400461E86C06D1FE6BF4BA4")) {
        vars.setSessionValue("buttonA39CE7408400461E86C06D1FE6BF4BA4.strprocessed", vars.getStringParameter("inpprocessed"));
        vars.setSessionValue("buttonA39CE7408400461E86C06D1FE6BF4BA4.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonA39CE7408400461E86C06D1FE6BF4BA4.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonA39CE7408400461E86C06D1FE6BF4BA4.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonA39CE7408400461E86C06D1FE6BF4BA4.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "A39CE7408400461E86C06D1FE6BF4BA4", request.getServletPath());    
     } else if (vars.commandIn("BUTTONA39CE7408400461E86C06D1FE6BF4BA4")) {
        String strSsve_Viatical_Settlement_ID = vars.getGlobalVariable("inpssveViaticalSettlementId", windowId + "|Ssve_Viatical_Settlement_ID", "");
        String strprocessed = vars.getSessionValue("buttonA39CE7408400461E86C06D1FE6BF4BA4.strprocessed");
        String strProcessing = vars.getSessionValue("buttonA39CE7408400461E86C06D1FE6BF4BA4.strProcessing");
        String strOrg = vars.getSessionValue("buttonA39CE7408400461E86C06D1FE6BF4BA4.strOrg");
        String strClient = vars.getSessionValue("buttonA39CE7408400461E86C06D1FE6BF4BA4.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcessedA39CE7408400461E86C06D1FE6BF4BA4(response, vars, strSsve_Viatical_Settlement_ID, strprocessed, strProcessing);
        }

     } else if (vars.commandIn("BUTTONSettle7C86BE53A1F14B32BD1290CF85776D12")) {
        vars.setSessionValue("button7C86BE53A1F14B32BD1290CF85776D12.strsettle", vars.getStringParameter("inpsettle"));
        vars.setSessionValue("button7C86BE53A1F14B32BD1290CF85776D12.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button7C86BE53A1F14B32BD1290CF85776D12.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button7C86BE53A1F14B32BD1290CF85776D12.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button7C86BE53A1F14B32BD1290CF85776D12.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "7C86BE53A1F14B32BD1290CF85776D12", request.getServletPath());    
     } else if (vars.commandIn("BUTTON7C86BE53A1F14B32BD1290CF85776D12")) {
        String strSsve_Viatical_Settlement_ID = vars.getGlobalVariable("inpssveViaticalSettlementId", windowId + "|Ssve_Viatical_Settlement_ID", "");
        String strsettle = vars.getSessionValue("button7C86BE53A1F14B32BD1290CF85776D12.strsettle");
        String strProcessing = vars.getSessionValue("button7C86BE53A1F14B32BD1290CF85776D12.strProcessing");
        String strOrg = vars.getSessionValue("button7C86BE53A1F14B32BD1290CF85776D12.strOrg");
        String strClient = vars.getSessionValue("button7C86BE53A1F14B32BD1290CF85776D12.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonSettle7C86BE53A1F14B32BD1290CF85776D12(response, vars, strSsve_Viatical_Settlement_ID, strsettle, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONGetlinesDFAADA670A39474496E7559755480708")) {
        String strSsve_Viatical_Settlement_ID = vars.getGlobalVariable("inpKey", windowId + "|Ssve_Viatical_Settlement_ID", "");
        String strgetlines = vars.getStringParameter("inpgetlines");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "DFAADA670A39474496E7559755480708", (("Ssve_Viatical_Settlement_ID".equalsIgnoreCase("AD_Language"))?"0":strSsve_Viatical_Settlement_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONProcessedA39CE7408400461E86C06D1FE6BF4BA4")) {
        String strSsve_Viatical_Settlement_ID = vars.getGlobalVariable("inpKey", windowId + "|Ssve_Viatical_Settlement_ID", "");
        String strprocessed = vars.getStringParameter("inpprocessed");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "A39CE7408400461E86C06D1FE6BF4BA4", (("Ssve_Viatical_Settlement_ID".equalsIgnoreCase("AD_Language"))?"0":strSsve_Viatical_Settlement_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONSettle7C86BE53A1F14B32BD1290CF85776D12")) {
        String strSsve_Viatical_Settlement_ID = vars.getGlobalVariable("inpKey", windowId + "|Ssve_Viatical_Settlement_ID", "");
        String strsettle = vars.getStringParameter("inpsettle");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "7C86BE53A1F14B32BD1290CF85776D12", (("Ssve_Viatical_Settlement_ID".equalsIgnoreCase("AD_Language"))?"0":strSsve_Viatical_Settlement_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
        String strSsve_Viatical_Settlement_ID = vars.getGlobalVariable("inpssveViaticalSettlementId", windowId + "|Ssve_Viatical_Settlement_ID", "");
        String strTableId = "5E2670C090A14B798B165203C31FA920";
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
          vars.setSessionValue("Posted|key", strSsve_Viatical_Settlement_ID);
          vars.setSessionValue("Posted|tableId", strTableId);
          vars.setSessionValue("Posted|tabId", tabId);
          vars.setSessionValue("Posted|posted", strPosted);
          vars.setSessionValue("Posted|processId", strProcessId);
          vars.setSessionValue("Posted|path", strDireccion + request.getServletPath());
          vars.setSessionValue("Posted|windowId", windowId);
          vars.setSessionValue("Posted|tabName", "ViaticalSettlement67B4299FEC3E4463A3247A8CEB31A90D");
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

    private void printPageButtonGetlinesDFAADA670A39474496E7559755480708(HttpServletResponse response, VariablesSecureApp vars, String strSsve_Viatical_Settlement_ID, String strgetlines, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process DFAADA670A39474496E7559755480708");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/GetlinesDFAADA670A39474496E7559755480708", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSsve_Viatical_Settlement_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "ViaticalSettlement67B4299FEC3E4463A3247A8CEB31A90D_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "DFAADA670A39474496E7559755480708");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("DFAADA670A39474496E7559755480708");
        vars.removeMessage("DFAADA670A39474496E7559755480708");
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
    private void printPageButtonProcessedA39CE7408400461E86C06D1FE6BF4BA4(HttpServletResponse response, VariablesSecureApp vars, String strSsve_Viatical_Settlement_ID, String strprocessed, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process A39CE7408400461E86C06D1FE6BF4BA4");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ProcessedA39CE7408400461E86C06D1FE6BF4BA4", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSsve_Viatical_Settlement_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "ViaticalSettlement67B4299FEC3E4463A3247A8CEB31A90D_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "A39CE7408400461E86C06D1FE6BF4BA4");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("A39CE7408400461E86C06D1FE6BF4BA4");
        vars.removeMessage("A39CE7408400461E86C06D1FE6BF4BA4");
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
    private void printPageButtonSettle7C86BE53A1F14B32BD1290CF85776D12(HttpServletResponse response, VariablesSecureApp vars, String strSsve_Viatical_Settlement_ID, String strsettle, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 7C86BE53A1F14B32BD1290CF85776D12");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Settle7C86BE53A1F14B32BD1290CF85776D12", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSsve_Viatical_Settlement_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "ViaticalSettlement67B4299FEC3E4463A3247A8CEB31A90D_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "7C86BE53A1F14B32BD1290CF85776D12");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("7C86BE53A1F14B32BD1290CF85776D12");
        vars.removeMessage("7C86BE53A1F14B32BD1290CF85776D12");
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
