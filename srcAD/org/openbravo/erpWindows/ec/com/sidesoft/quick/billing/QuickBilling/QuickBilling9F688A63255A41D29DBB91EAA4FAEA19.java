
package org.openbravo.erpWindows.ec.com.sidesoft.quick.billing.QuickBilling;




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
public class QuickBilling9F688A63255A41D29DBB91EAA4FAEA19 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "3A4D34306AB743069FF5A867CF0A3BBF";
  private static final String tabId = "9F688A63255A41D29DBB91EAA4FAEA19";
  private static final int accesslevel = 3;
  private static final String moduleId = "D1D370BDBFB548D380608DD6AD2011F4";
  
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
     
      if (command.contains("EBCCB232196040B294F2E29F1846F9AC")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("EBCCB232196040B294F2E29F1846F9AC");
        SessionInfo.setModuleId("D1D370BDBFB548D380608DD6AD2011F4");
      }
     
      if (command.contains("6AA269C7FB70428AB269794614AD4742")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("6AA269C7FB70428AB269794614AD4742");
        SessionInfo.setModuleId("D1D370BDBFB548D380608DD6AD2011F4");
      }
     
      if (command.contains("1D419EB151AE45A9A5C8B86371B9818A")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("1D419EB151AE45A9A5C8B86371B9818A");
        SessionInfo.setModuleId("D1D370BDBFB548D380608DD6AD2011F4");
      }
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     

     
      if (explicitAccess.contains("EBCCB232196040B294F2E29F1846F9AC") || (securedProcess && command.contains("EBCCB232196040B294F2E29F1846F9AC"))) {
        classInfo.type = "P";
        classInfo.id = "EBCCB232196040B294F2E29F1846F9AC";
      }
     
      if (explicitAccess.contains("6AA269C7FB70428AB269794614AD4742") || (securedProcess && command.contains("6AA269C7FB70428AB269794614AD4742"))) {
        classInfo.type = "P";
        classInfo.id = "6AA269C7FB70428AB269794614AD4742";
      }
     
      if (explicitAccess.contains("1D419EB151AE45A9A5C8B86371B9818A") || (securedProcess && command.contains("1D419EB151AE45A9A5C8B86371B9818A"))) {
        classInfo.type = "P";
        classInfo.id = "1D419EB151AE45A9A5C8B86371B9818A";
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

    } else if (vars.commandIn("BUTTONSave_AssignEBCCB232196040B294F2E29F1846F9AC")) {
        vars.setSessionValue("buttonEBCCB232196040B294F2E29F1846F9AC.strsaveAssign", vars.getStringParameter("inpsaveAssign"));
        vars.setSessionValue("buttonEBCCB232196040B294F2E29F1846F9AC.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonEBCCB232196040B294F2E29F1846F9AC.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonEBCCB232196040B294F2E29F1846F9AC.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonEBCCB232196040B294F2E29F1846F9AC.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "EBCCB232196040B294F2E29F1846F9AC", request.getServletPath());
      } else if (vars.commandIn("BUTTONEBCCB232196040B294F2E29F1846F9AC")) {
        String strSQB_Quickbilling_ID = vars.getGlobalVariable("inpsqbQuickbillingId", windowId + "|SQB_Quickbilling_ID", "");
        String strsaveAssign = vars.getSessionValue("buttonEBCCB232196040B294F2E29F1846F9AC.strsaveAssign");
        String strProcessing = vars.getSessionValue("buttonEBCCB232196040B294F2E29F1846F9AC.strProcessing");
        String strOrg = vars.getSessionValue("buttonEBCCB232196040B294F2E29F1846F9AC.strOrg");
        String strClient = vars.getSessionValue("buttonEBCCB232196040B294F2E29F1846F9AC.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonSave_AssignEBCCB232196040B294F2E29F1846F9AC(response, vars, strSQB_Quickbilling_ID, strsaveAssign, strProcessing);
        }
    } else if (vars.commandIn("BUTTONTO_Invoice6AA269C7FB70428AB269794614AD4742")) {
        vars.setSessionValue("button6AA269C7FB70428AB269794614AD4742.strtoInvoice", vars.getStringParameter("inptoInvoice"));
        vars.setSessionValue("button6AA269C7FB70428AB269794614AD4742.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button6AA269C7FB70428AB269794614AD4742.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button6AA269C7FB70428AB269794614AD4742.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button6AA269C7FB70428AB269794614AD4742.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "6AA269C7FB70428AB269794614AD4742", request.getServletPath());
      } else if (vars.commandIn("BUTTON6AA269C7FB70428AB269794614AD4742")) {
        String strSQB_Quickbilling_ID = vars.getGlobalVariable("inpsqbQuickbillingId", windowId + "|SQB_Quickbilling_ID", "");
        String strtoInvoice = vars.getSessionValue("button6AA269C7FB70428AB269794614AD4742.strtoInvoice");
        String strProcessing = vars.getSessionValue("button6AA269C7FB70428AB269794614AD4742.strProcessing");
        String strOrg = vars.getSessionValue("button6AA269C7FB70428AB269794614AD4742.strOrg");
        String strClient = vars.getSessionValue("button6AA269C7FB70428AB269794614AD4742.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonTO_Invoice6AA269C7FB70428AB269794614AD4742(response, vars, strSQB_Quickbilling_ID, strtoInvoice, strProcessing);
        }
    } else if (vars.commandIn("BUTTONClose_Box1D419EB151AE45A9A5C8B86371B9818A")) {
        vars.setSessionValue("button1D419EB151AE45A9A5C8B86371B9818A.strcloseBox", vars.getStringParameter("inpcloseBox"));
        vars.setSessionValue("button1D419EB151AE45A9A5C8B86371B9818A.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button1D419EB151AE45A9A5C8B86371B9818A.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button1D419EB151AE45A9A5C8B86371B9818A.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button1D419EB151AE45A9A5C8B86371B9818A.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "1D419EB151AE45A9A5C8B86371B9818A", request.getServletPath());
      } else if (vars.commandIn("BUTTON1D419EB151AE45A9A5C8B86371B9818A")) {
        String strSQB_Quickbilling_ID = vars.getGlobalVariable("inpsqbQuickbillingId", windowId + "|SQB_Quickbilling_ID", "");
        String strcloseBox = vars.getSessionValue("button1D419EB151AE45A9A5C8B86371B9818A.strcloseBox");
        String strProcessing = vars.getSessionValue("button1D419EB151AE45A9A5C8B86371B9818A.strProcessing");
        String strOrg = vars.getSessionValue("button1D419EB151AE45A9A5C8B86371B9818A.strOrg");
        String strClient = vars.getSessionValue("button1D419EB151AE45A9A5C8B86371B9818A.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonClose_Box1D419EB151AE45A9A5C8B86371B9818A(response, vars, strSQB_Quickbilling_ID, strcloseBox, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONSave_AssignEBCCB232196040B294F2E29F1846F9AC")) {
        String strSQB_Quickbilling_ID = vars.getGlobalVariable("inpKey", windowId + "|SQB_Quickbilling_ID", "");
        
        ProcessBundle pb = new ProcessBundle("EBCCB232196040B294F2E29F1846F9AC", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("SQB_Quickbilling_ID", strSQB_Quickbilling_ID);
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
    } else if (vars.commandIn("SAVE_BUTTONTO_Invoice6AA269C7FB70428AB269794614AD4742")) {
        String strSQB_Quickbilling_ID = vars.getGlobalVariable("inpKey", windowId + "|SQB_Quickbilling_ID", "");
        
        ProcessBundle pb = new ProcessBundle("6AA269C7FB70428AB269794614AD4742", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("SQB_Quickbilling_ID", strSQB_Quickbilling_ID);
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
    } else if (vars.commandIn("SAVE_BUTTONClose_Box1D419EB151AE45A9A5C8B86371B9818A")) {
        String strSQB_Quickbilling_ID = vars.getGlobalVariable("inpKey", windowId + "|SQB_Quickbilling_ID", "");
        
        ProcessBundle pb = new ProcessBundle("1D419EB151AE45A9A5C8B86371B9818A", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("SQB_Quickbilling_ID", strSQB_Quickbilling_ID);
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



    void printPageButtonSave_AssignEBCCB232196040B294F2E29F1846F9AC(HttpServletResponse response, VariablesSecureApp vars, String strSQB_Quickbilling_ID, String strsaveAssign, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process EBCCB232196040B294F2E29F1846F9AC");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Save_AssignEBCCB232196040B294F2E29F1846F9AC", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSQB_Quickbilling_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "QuickBilling9F688A63255A41D29DBB91EAA4FAEA19_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "EBCCB232196040B294F2E29F1846F9AC");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("EBCCB232196040B294F2E29F1846F9AC");
        vars.removeMessage("EBCCB232196040B294F2E29F1846F9AC");
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
    void printPageButtonTO_Invoice6AA269C7FB70428AB269794614AD4742(HttpServletResponse response, VariablesSecureApp vars, String strSQB_Quickbilling_ID, String strtoInvoice, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 6AA269C7FB70428AB269794614AD4742");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/TO_Invoice6AA269C7FB70428AB269794614AD4742", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSQB_Quickbilling_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "QuickBilling9F688A63255A41D29DBB91EAA4FAEA19_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "6AA269C7FB70428AB269794614AD4742");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("6AA269C7FB70428AB269794614AD4742");
        vars.removeMessage("6AA269C7FB70428AB269794614AD4742");
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
    void printPageButtonClose_Box1D419EB151AE45A9A5C8B86371B9818A(HttpServletResponse response, VariablesSecureApp vars, String strSQB_Quickbilling_ID, String strcloseBox, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 1D419EB151AE45A9A5C8B86371B9818A");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Close_Box1D419EB151AE45A9A5C8B86371B9818A", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSQB_Quickbilling_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "QuickBilling9F688A63255A41D29DBB91EAA4FAEA19_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "1D419EB151AE45A9A5C8B86371B9818A");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("1D419EB151AE45A9A5C8B86371B9818A");
        vars.removeMessage("1D419EB151AE45A9A5C8B86371B9818A");
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
