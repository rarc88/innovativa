
package org.openbravo.erpWindows.ec.com.sidesoft.contract.Contracts;


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
public class PaymentFormE6545FCB778548D09E7765630EE8F82A extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "240FE3FCD7904F84B731EDB285FEC5DC";
  private static final String tabId = "E6545FCB778548D09E7765630EE8F82A";
  private static final int accesslevel = 3;
  private static final String moduleId = "3919F47D4BA24A6A8670C1F88CBC1FAF";
  
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
     
      if (command.contains("A50940460C4E4974885473E518AC2515")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("A50940460C4E4974885473E518AC2515");
        SessionInfo.setModuleId("3919F47D4BA24A6A8670C1F88CBC1FAF");
        if (securedProcess || explicitAccess.contains("A50940460C4E4974885473E518AC2515")) {
          classInfo.type = "P";
          classInfo.id = "A50940460C4E4974885473E518AC2515";
        }
      }
     
      if (command.contains("901A13F106724D0C95B23B09F3338025")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("901A13F106724D0C95B23B09F3338025");
        SessionInfo.setModuleId("3919F47D4BA24A6A8670C1F88CBC1FAF");
        if (securedProcess || explicitAccess.contains("901A13F106724D0C95B23B09F3338025")) {
          classInfo.type = "P";
          classInfo.id = "901A13F106724D0C95B23B09F3338025";
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

     } else if (vars.commandIn("BUTTONProcess_ActionA50940460C4E4974885473E518AC2515")) {
        vars.setSessionValue("buttonA50940460C4E4974885473E518AC2515.strprocessAction", vars.getStringParameter("inpprocessAction"));
        vars.setSessionValue("buttonA50940460C4E4974885473E518AC2515.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonA50940460C4E4974885473E518AC2515.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonA50940460C4E4974885473E518AC2515.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonA50940460C4E4974885473E518AC2515.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "A50940460C4E4974885473E518AC2515", request.getServletPath());    
     } else if (vars.commandIn("BUTTONA50940460C4E4974885473E518AC2515")) {
        String strSsct_Payment_ID = vars.getGlobalVariable("inpssctPaymentId", windowId + "|Ssct_Payment_ID", "");
        String strprocessAction = vars.getSessionValue("buttonA50940460C4E4974885473E518AC2515.strprocessAction");
        String strProcessing = vars.getSessionValue("buttonA50940460C4E4974885473E518AC2515.strProcessing");
        String strOrg = vars.getSessionValue("buttonA50940460C4E4974885473E518AC2515.strOrg");
        String strClient = vars.getSessionValue("buttonA50940460C4E4974885473E518AC2515.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcess_ActionA50940460C4E4974885473E518AC2515(response, vars, strSsct_Payment_ID, strprocessAction, strProcessing);
        }

     } else if (vars.commandIn("BUTTONReactive_Action901A13F106724D0C95B23B09F3338025")) {
        vars.setSessionValue("button901A13F106724D0C95B23B09F3338025.strreactiveAction", vars.getStringParameter("inpreactiveAction"));
        vars.setSessionValue("button901A13F106724D0C95B23B09F3338025.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button901A13F106724D0C95B23B09F3338025.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button901A13F106724D0C95B23B09F3338025.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button901A13F106724D0C95B23B09F3338025.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "901A13F106724D0C95B23B09F3338025", request.getServletPath());    
     } else if (vars.commandIn("BUTTON901A13F106724D0C95B23B09F3338025")) {
        String strSsct_Payment_ID = vars.getGlobalVariable("inpssctPaymentId", windowId + "|Ssct_Payment_ID", "");
        String strreactiveAction = vars.getSessionValue("button901A13F106724D0C95B23B09F3338025.strreactiveAction");
        String strProcessing = vars.getSessionValue("button901A13F106724D0C95B23B09F3338025.strProcessing");
        String strOrg = vars.getSessionValue("button901A13F106724D0C95B23B09F3338025.strOrg");
        String strClient = vars.getSessionValue("button901A13F106724D0C95B23B09F3338025.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonReactive_Action901A13F106724D0C95B23B09F3338025(response, vars, strSsct_Payment_ID, strreactiveAction, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONProcess_ActionA50940460C4E4974885473E518AC2515")) {
        String strSsct_Payment_ID = vars.getGlobalVariable("inpKey", windowId + "|Ssct_Payment_ID", "");
        String strprocessAction = vars.getStringParameter("inpprocessAction");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "A50940460C4E4974885473E518AC2515", (("Ssct_Payment_ID".equalsIgnoreCase("AD_Language"))?"0":strSsct_Payment_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONReactive_Action901A13F106724D0C95B23B09F3338025")) {
        String strSsct_Payment_ID = vars.getGlobalVariable("inpKey", windowId + "|Ssct_Payment_ID", "");
        String strreactiveAction = vars.getStringParameter("inpreactiveAction");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "901A13F106724D0C95B23B09F3338025", (("Ssct_Payment_ID".equalsIgnoreCase("AD_Language"))?"0":strSsct_Payment_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    private void printPageButtonProcess_ActionA50940460C4E4974885473E518AC2515(HttpServletResponse response, VariablesSecureApp vars, String strSsct_Payment_ID, String strprocessAction, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process A50940460C4E4974885473E518AC2515");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Process_ActionA50940460C4E4974885473E518AC2515", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSsct_Payment_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "PaymentFormE6545FCB778548D09E7765630EE8F82A_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "A50940460C4E4974885473E518AC2515");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("A50940460C4E4974885473E518AC2515");
        vars.removeMessage("A50940460C4E4974885473E518AC2515");
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
    private void printPageButtonReactive_Action901A13F106724D0C95B23B09F3338025(HttpServletResponse response, VariablesSecureApp vars, String strSsct_Payment_ID, String strreactiveAction, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 901A13F106724D0C95B23B09F3338025");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Reactive_Action901A13F106724D0C95B23B09F3338025", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSsct_Payment_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "PaymentFormE6545FCB778548D09E7765630EE8F82A_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "901A13F106724D0C95B23B09F3338025");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("901A13F106724D0C95B23B09F3338025");
        vars.removeMessage("901A13F106724D0C95B23B09F3338025");
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
