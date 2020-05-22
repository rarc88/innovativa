
package org.openbravo.erpWindows.com.sidesoft.flopec.budget.Certificate;


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
public class Header9B63557BA200471C8946158BE84AC654 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "EDA5B6043FE04CCC901B3A7C045D7F44";
  private static final String tabId = "9B63557BA200471C8946158BE84AC654";
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
     List<String> explicitAccess = Arrays.asList("0A7A590F8CF641B4B63AD85D83D5FD63",  "");
    
     SessionInfo.setUserId(vars.getSessionValue("#AD_User_ID"));
     SessionInfo.setSessionId(vars.getSessionValue("#AD_Session_ID"));
     SessionInfo.setQueryProfile("manualProcess");
     
      if (command.contains("006D8983826D47F4A7065566788F93E8")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("006D8983826D47F4A7065566788F93E8");
        SessionInfo.setModuleId("75856ABEF4614636A5FABB70AD0CD4C8");
      }
     
      if (command.contains("0A7A590F8CF641B4B63AD85D83D5FD63")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("0A7A590F8CF641B4B63AD85D83D5FD63");
        SessionInfo.setModuleId("75856ABEF4614636A5FABB70AD0CD4C8");
      }
     
      if (command.contains("928A4483850046239A217B445A680E29")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("928A4483850046239A217B445A680E29");
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
     

     
      if (explicitAccess.contains("006D8983826D47F4A7065566788F93E8") || (securedProcess && command.contains("006D8983826D47F4A7065566788F93E8"))) {
        classInfo.type = "P";
        classInfo.id = "006D8983826D47F4A7065566788F93E8";
      }
     
      if (explicitAccess.contains("0A7A590F8CF641B4B63AD85D83D5FD63") || (securedProcess && command.contains("0A7A590F8CF641B4B63AD85D83D5FD63"))) {
        classInfo.type = "P";
        classInfo.id = "0A7A590F8CF641B4B63AD85D83D5FD63";
      }
     
      if (explicitAccess.contains("928A4483850046239A217B445A680E29") || (securedProcess && command.contains("928A4483850046239A217B445A680E29"))) {
        classInfo.type = "P";
        classInfo.id = "928A4483850046239A217B445A680E29";
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
    } else if (vars.commandIn("BUTTONReview0A7A590F8CF641B4B63AD85D83D5FD63")) {
        vars.setSessionValue("button0A7A590F8CF641B4B63AD85D83D5FD63.strreview", vars.getStringParameter("inpreview"));
        vars.setSessionValue("button0A7A590F8CF641B4B63AD85D83D5FD63.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button0A7A590F8CF641B4B63AD85D83D5FD63.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button0A7A590F8CF641B4B63AD85D83D5FD63.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button0A7A590F8CF641B4B63AD85D83D5FD63.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "0A7A590F8CF641B4B63AD85D83D5FD63", request.getServletPath());
      } else if (vars.commandIn("BUTTON0A7A590F8CF641B4B63AD85D83D5FD63")) {
        String strSFB_Budget_Certificate_ID = vars.getGlobalVariable("inpsfbBudgetCertificateId", windowId + "|SFB_Budget_Certificate_ID", "");
        String strreview = vars.getSessionValue("button0A7A590F8CF641B4B63AD85D83D5FD63.strreview");
        String strProcessing = vars.getSessionValue("button0A7A590F8CF641B4B63AD85D83D5FD63.strProcessing");
        String strOrg = vars.getSessionValue("button0A7A590F8CF641B4B63AD85D83D5FD63.strOrg");
        String strClient = vars.getSessionValue("button0A7A590F8CF641B4B63AD85D83D5FD63.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonReview0A7A590F8CF641B4B63AD85D83D5FD63(response, vars, strSFB_Budget_Certificate_ID, strreview, strProcessing);
        }
    } else if (vars.commandIn("BUTTONProcess928A4483850046239A217B445A680E29")) {
        vars.setSessionValue("button928A4483850046239A217B445A680E29.strprocess", vars.getStringParameter("inpprocess"));
        vars.setSessionValue("button928A4483850046239A217B445A680E29.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button928A4483850046239A217B445A680E29.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button928A4483850046239A217B445A680E29.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button928A4483850046239A217B445A680E29.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "928A4483850046239A217B445A680E29", request.getServletPath());
      } else if (vars.commandIn("BUTTON928A4483850046239A217B445A680E29")) {
        String strSFB_Budget_Certificate_ID = vars.getGlobalVariable("inpsfbBudgetCertificateId", windowId + "|SFB_Budget_Certificate_ID", "");
        String strprocess = vars.getSessionValue("button928A4483850046239A217B445A680E29.strprocess");
        String strProcessing = vars.getSessionValue("button928A4483850046239A217B445A680E29.strProcessing");
        String strOrg = vars.getSessionValue("button928A4483850046239A217B445A680E29.strOrg");
        String strClient = vars.getSessionValue("button928A4483850046239A217B445A680E29.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcess928A4483850046239A217B445A680E29(response, vars, strSFB_Budget_Certificate_ID, strprocess, strProcessing);
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
    } else if (vars.commandIn("SAVE_BUTTONReview0A7A590F8CF641B4B63AD85D83D5FD63")) {
        String strSFB_Budget_Certificate_ID = vars.getGlobalVariable("inpKey", windowId + "|SFB_Budget_Certificate_ID", "");
        
        ProcessBundle pb = new ProcessBundle("0A7A590F8CF641B4B63AD85D83D5FD63", vars).init(this);
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
    } else if (vars.commandIn("SAVE_BUTTONProcess928A4483850046239A217B445A680E29")) {
        String strSFB_Budget_Certificate_ID = vars.getGlobalVariable("inpKey", windowId + "|SFB_Budget_Certificate_ID", "");
        
        ProcessBundle pb = new ProcessBundle("928A4483850046239A217B445A680E29", vars).init(this);
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



    void printPageButtonRequest006D8983826D47F4A7065566788F93E8(HttpServletResponse response, VariablesSecureApp vars, String strSFB_Budget_Certificate_ID, String strrequest, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 006D8983826D47F4A7065566788F93E8");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Request006D8983826D47F4A7065566788F93E8", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSFB_Budget_Certificate_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Header9B63557BA200471C8946158BE84AC654_Edition.html");
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
    void printPageButtonReview0A7A590F8CF641B4B63AD85D83D5FD63(HttpServletResponse response, VariablesSecureApp vars, String strSFB_Budget_Certificate_ID, String strreview, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 0A7A590F8CF641B4B63AD85D83D5FD63");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Review0A7A590F8CF641B4B63AD85D83D5FD63", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSFB_Budget_Certificate_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Header9B63557BA200471C8946158BE84AC654_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "0A7A590F8CF641B4B63AD85D83D5FD63");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("0A7A590F8CF641B4B63AD85D83D5FD63");
        vars.removeMessage("0A7A590F8CF641B4B63AD85D83D5FD63");
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
    void printPageButtonProcess928A4483850046239A217B445A680E29(HttpServletResponse response, VariablesSecureApp vars, String strSFB_Budget_Certificate_ID, String strprocess, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 928A4483850046239A217B445A680E29");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Process928A4483850046239A217B445A680E29", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSFB_Budget_Certificate_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Header9B63557BA200471C8946158BE84AC654_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "928A4483850046239A217B445A680E29");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("928A4483850046239A217B445A680E29");
        vars.removeMessage("928A4483850046239A217B445A680E29");
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
      xmlDocument.setParameter("form", "Header9B63557BA200471C8946158BE84AC654_Edition.html");
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
