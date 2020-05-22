
package org.openbravo.erpWindows.com.sidesoft.flopec.budget.AssetsCertificate;


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
public class Header2CC678D2B22D4E7B8C4B8D7F427111A9 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "94BA47CB410240C6930FF2B05435295C";
  private static final String tabId = "2CC678D2B22D4E7B8C4B8D7F427111A9";
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
     
      if (command.contains("006D8983826D47F4A7065566788F93E8")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("006D8983826D47F4A7065566788F93E8");
        SessionInfo.setModuleId("75856ABEF4614636A5FABB70AD0CD4C8");
      }
     
      if (command.contains("6267329F022A4993A79776EEC7F2882F")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("6267329F022A4993A79776EEC7F2882F");
        SessionInfo.setModuleId("75856ABEF4614636A5FABB70AD0CD4C8");
      }
     
      if (command.contains("7D052DBDB45F45648373F2064BECD521")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("7D052DBDB45F45648373F2064BECD521");
        SessionInfo.setModuleId("75856ABEF4614636A5FABB70AD0CD4C8");
      }
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     
      if (command.contains("7FE9F21345B34211AEFDEEA20260D9F9")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("7FE9F21345B34211AEFDEEA20260D9F9");
        SessionInfo.setModuleId("75856ABEF4614636A5FABB70AD0CD4C8");
        if (securedProcess || explicitAccess.contains("7FE9F21345B34211AEFDEEA20260D9F9")) {
          classInfo.type = "P";
          classInfo.id = "7FE9F21345B34211AEFDEEA20260D9F9";
        }
      }
     

     
      if (explicitAccess.contains("006D8983826D47F4A7065566788F93E8") || (securedProcess && command.contains("006D8983826D47F4A7065566788F93E8"))) {
        classInfo.type = "P";
        classInfo.id = "006D8983826D47F4A7065566788F93E8";
      }
     
      if (explicitAccess.contains("6267329F022A4993A79776EEC7F2882F") || (securedProcess && command.contains("6267329F022A4993A79776EEC7F2882F"))) {
        classInfo.type = "P";
        classInfo.id = "6267329F022A4993A79776EEC7F2882F";
      }
     
      if (explicitAccess.contains("7D052DBDB45F45648373F2064BECD521") || (securedProcess && command.contains("7D052DBDB45F45648373F2064BECD521"))) {
        classInfo.type = "P";
        classInfo.id = "7D052DBDB45F45648373F2064BECD521";
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

     } else if (vars.commandIn("BUTTONLoad_Amortization7FE9F21345B34211AEFDEEA20260D9F9")) {
        vars.setSessionValue("button7FE9F21345B34211AEFDEEA20260D9F9.strloadAmortization", vars.getStringParameter("inploadAmortization"));
        vars.setSessionValue("button7FE9F21345B34211AEFDEEA20260D9F9.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button7FE9F21345B34211AEFDEEA20260D9F9.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button7FE9F21345B34211AEFDEEA20260D9F9.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button7FE9F21345B34211AEFDEEA20260D9F9.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "7FE9F21345B34211AEFDEEA20260D9F9", request.getServletPath());    
     } else if (vars.commandIn("BUTTON7FE9F21345B34211AEFDEEA20260D9F9")) {
        String strSFB_Budget_Certificate_ID = vars.getGlobalVariable("inpsfbBudgetCertificateId", windowId + "|SFB_Budget_Certificate_ID", "");
        String strloadAmortization = vars.getSessionValue("button7FE9F21345B34211AEFDEEA20260D9F9.strloadAmortization");
        String strProcessing = vars.getSessionValue("button7FE9F21345B34211AEFDEEA20260D9F9.strProcessing");
        String strOrg = vars.getSessionValue("button7FE9F21345B34211AEFDEEA20260D9F9.strOrg");
        String strClient = vars.getSessionValue("button7FE9F21345B34211AEFDEEA20260D9F9.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonLoad_Amortization7FE9F21345B34211AEFDEEA20260D9F9(response, vars, strSFB_Budget_Certificate_ID, strloadAmortization, strProcessing);
        }

    } else if (vars.commandIn("BUTTONRequest006D8983826D47F4A7065566788F93E8")) {
        vars.setSessionValue("button006D8983826D47F4A7065566788F93E8.strrequest", vars.getStringParameter("inprequest"));
        vars.setSessionValue("button006D8983826D47F4A7065566788F93E8.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button006D8983826D47F4A7065566788F93E8.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button006D8983826D47F4A7065566788F93E8.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button006D8983826D47F4A7065566788F93E8.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "006D8983826D47F4A7065566788F93E8", request.getServletPath());
      } else if (vars.commandIn("BUTTON006D8983826D47F4A7065566788F93E8")) {
        String strSFB_Budget_Certificate_ID = vars.getGlobalVariable("inpsfbBudgetCertificateId", windowId + "|SFB_Budget_Certificate_ID", "");
        String strrequest = vars.getSessionValue("button006D8983826D47F4A7065566788F93E8.strrequest");
        String strProcessing = vars.getSessionValue("button006D8983826D47F4A7065566788F93E8.strProcessing");
        String strOrg = vars.getSessionValue("button006D8983826D47F4A7065566788F93E8.strOrg");
        String strClient = vars.getSessionValue("button006D8983826D47F4A7065566788F93E8.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonRequest006D8983826D47F4A7065566788F93E8(response, vars, strSFB_Budget_Certificate_ID, strrequest, strProcessing);
        }
    } else if (vars.commandIn("BUTTONProcess_Executed6267329F022A4993A79776EEC7F2882F")) {
        vars.setSessionValue("button6267329F022A4993A79776EEC7F2882F.strprocessExecuted", vars.getStringParameter("inpprocessExecuted"));
        vars.setSessionValue("button6267329F022A4993A79776EEC7F2882F.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button6267329F022A4993A79776EEC7F2882F.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button6267329F022A4993A79776EEC7F2882F.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button6267329F022A4993A79776EEC7F2882F.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "6267329F022A4993A79776EEC7F2882F", request.getServletPath());
      } else if (vars.commandIn("BUTTON6267329F022A4993A79776EEC7F2882F")) {
        String strSFB_Budget_Certificate_ID = vars.getGlobalVariable("inpsfbBudgetCertificateId", windowId + "|SFB_Budget_Certificate_ID", "");
        String strprocessExecuted = vars.getSessionValue("button6267329F022A4993A79776EEC7F2882F.strprocessExecuted");
        String strProcessing = vars.getSessionValue("button6267329F022A4993A79776EEC7F2882F.strProcessing");
        String strOrg = vars.getSessionValue("button6267329F022A4993A79776EEC7F2882F.strOrg");
        String strClient = vars.getSessionValue("button6267329F022A4993A79776EEC7F2882F.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcess_Executed6267329F022A4993A79776EEC7F2882F(response, vars, strSFB_Budget_Certificate_ID, strprocessExecuted, strProcessing);
        }
    } else if (vars.commandIn("BUTTONClosecert7D052DBDB45F45648373F2064BECD521")) {
        vars.setSessionValue("button7D052DBDB45F45648373F2064BECD521.strclosecert", vars.getStringParameter("inpclosecert"));
        vars.setSessionValue("button7D052DBDB45F45648373F2064BECD521.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button7D052DBDB45F45648373F2064BECD521.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button7D052DBDB45F45648373F2064BECD521.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button7D052DBDB45F45648373F2064BECD521.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "7D052DBDB45F45648373F2064BECD521", request.getServletPath());
      } else if (vars.commandIn("BUTTON7D052DBDB45F45648373F2064BECD521")) {
        String strSFB_Budget_Certificate_ID = vars.getGlobalVariable("inpsfbBudgetCertificateId", windowId + "|SFB_Budget_Certificate_ID", "");
        String strclosecert = vars.getSessionValue("button7D052DBDB45F45648373F2064BECD521.strclosecert");
        String strProcessing = vars.getSessionValue("button7D052DBDB45F45648373F2064BECD521.strProcessing");
        String strOrg = vars.getSessionValue("button7D052DBDB45F45648373F2064BECD521.strOrg");
        String strClient = vars.getSessionValue("button7D052DBDB45F45648373F2064BECD521.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonClosecert7D052DBDB45F45648373F2064BECD521(response, vars, strSFB_Budget_Certificate_ID, strclosecert, strProcessing);
        }

    } else if (vars.commandIn("SAVE_BUTTONLoad_Amortization7FE9F21345B34211AEFDEEA20260D9F9")) {
        String strSFB_Budget_Certificate_ID = vars.getGlobalVariable("inpKey", windowId + "|SFB_Budget_Certificate_ID", "");
        String strloadAmortization = vars.getStringParameter("inploadAmortization");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "7FE9F21345B34211AEFDEEA20260D9F9", (("SFB_Budget_Certificate_ID".equalsIgnoreCase("AD_Language"))?"0":strSFB_Budget_Certificate_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    } else if (vars.commandIn("SAVE_BUTTONRequest006D8983826D47F4A7065566788F93E8")) {
        String strSFB_Budget_Certificate_ID = vars.getGlobalVariable("inpKey", windowId + "|SFB_Budget_Certificate_ID", "");
        
        ProcessBundle pb = new ProcessBundle("006D8983826D47F4A7065566788F93E8", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("SFB_Budget_Certificate_ID", strSFB_Budget_Certificate_ID);
        params.put("adOrgId", vars.getStringParameter("inpadOrgId"));
        params.put("adClientId", vars.getStringParameter("inpadClientId"));
        params.put("tabId", tabId);
        
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ProcessRunner(pb).execute(this);
          myMessage = (OBError) pb.getResult();
          myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
          myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error(ex);
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
    } else if (vars.commandIn("SAVE_BUTTONProcess_Executed6267329F022A4993A79776EEC7F2882F")) {
        String strSFB_Budget_Certificate_ID = vars.getGlobalVariable("inpKey", windowId + "|SFB_Budget_Certificate_ID", "");
        
        ProcessBundle pb = new ProcessBundle("6267329F022A4993A79776EEC7F2882F", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("SFB_Budget_Certificate_ID", strSFB_Budget_Certificate_ID);
        params.put("adOrgId", vars.getStringParameter("inpadOrgId"));
        params.put("adClientId", vars.getStringParameter("inpadClientId"));
        params.put("tabId", tabId);
        
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ProcessRunner(pb).execute(this);
          myMessage = (OBError) pb.getResult();
          myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
          myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error(ex);
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
    } else if (vars.commandIn("SAVE_BUTTONClosecert7D052DBDB45F45648373F2064BECD521")) {
        String strSFB_Budget_Certificate_ID = vars.getGlobalVariable("inpKey", windowId + "|SFB_Budget_Certificate_ID", "");
        
        ProcessBundle pb = new ProcessBundle("7D052DBDB45F45648373F2064BECD521", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("SFB_Budget_Certificate_ID", strSFB_Budget_Certificate_ID);
        params.put("adOrgId", vars.getStringParameter("inpadOrgId"));
        params.put("adClientId", vars.getStringParameter("inpadClientId"));
        params.put("tabId", tabId);
        
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ProcessRunner(pb).execute(this);
          myMessage = (OBError) pb.getResult();
          myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
          myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error(ex);
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

    private void printPageButtonLoad_Amortization7FE9F21345B34211AEFDEEA20260D9F9(HttpServletResponse response, VariablesSecureApp vars, String strSFB_Budget_Certificate_ID, String strloadAmortization, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 7FE9F21345B34211AEFDEEA20260D9F9");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Load_Amortization7FE9F21345B34211AEFDEEA20260D9F9", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSFB_Budget_Certificate_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Header2CC678D2B22D4E7B8C4B8D7F427111A9_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "7FE9F21345B34211AEFDEEA20260D9F9");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("7FE9F21345B34211AEFDEEA20260D9F9");
        vars.removeMessage("7FE9F21345B34211AEFDEEA20260D9F9");
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


    void printPageButtonRequest006D8983826D47F4A7065566788F93E8(HttpServletResponse response, VariablesSecureApp vars, String strSFB_Budget_Certificate_ID, String strrequest, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 006D8983826D47F4A7065566788F93E8");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Request006D8983826D47F4A7065566788F93E8", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSFB_Budget_Certificate_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Header2CC678D2B22D4E7B8C4B8D7F427111A9_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "006D8983826D47F4A7065566788F93E8");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("006D8983826D47F4A7065566788F93E8");
        vars.removeMessage("006D8983826D47F4A7065566788F93E8");
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
    void printPageButtonProcess_Executed6267329F022A4993A79776EEC7F2882F(HttpServletResponse response, VariablesSecureApp vars, String strSFB_Budget_Certificate_ID, String strprocessExecuted, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 6267329F022A4993A79776EEC7F2882F");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Process_Executed6267329F022A4993A79776EEC7F2882F", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSFB_Budget_Certificate_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Header2CC678D2B22D4E7B8C4B8D7F427111A9_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "6267329F022A4993A79776EEC7F2882F");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("6267329F022A4993A79776EEC7F2882F");
        vars.removeMessage("6267329F022A4993A79776EEC7F2882F");
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
    void printPageButtonClosecert7D052DBDB45F45648373F2064BECD521(HttpServletResponse response, VariablesSecureApp vars, String strSFB_Budget_Certificate_ID, String strclosecert, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 7D052DBDB45F45648373F2064BECD521");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Closecert7D052DBDB45F45648373F2064BECD521", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSFB_Budget_Certificate_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Header2CC678D2B22D4E7B8C4B8D7F427111A9_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "7D052DBDB45F45648373F2064BECD521");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("7D052DBDB45F45648373F2064BECD521");
        vars.removeMessage("7D052DBDB45F45648373F2064BECD521");
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
