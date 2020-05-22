
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
public class AdvanceFA0361705F854CA5B845C7DB4418ADFA extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "240FE3FCD7904F84B731EDB285FEC5DC";
  private static final String tabId = "FA0361705F854CA5B845C7DB4418ADFA";
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
     
      if (command.contains("BE4BA6F9C69A40DBBD1272B3130E3BC7")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("BE4BA6F9C69A40DBBD1272B3130E3BC7");
        SessionInfo.setModuleId("3919F47D4BA24A6A8670C1F88CBC1FAF");
        if (securedProcess || explicitAccess.contains("BE4BA6F9C69A40DBBD1272B3130E3BC7")) {
          classInfo.type = "P";
          classInfo.id = "BE4BA6F9C69A40DBBD1272B3130E3BC7";
        }
      }
     
      if (command.contains("4D5CA698991D41E8BCCD18A2806E9703")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("4D5CA698991D41E8BCCD18A2806E9703");
        SessionInfo.setModuleId("3919F47D4BA24A6A8670C1F88CBC1FAF");
        if (securedProcess || explicitAccess.contains("4D5CA698991D41E8BCCD18A2806E9703")) {
          classInfo.type = "P";
          classInfo.id = "4D5CA698991D41E8BCCD18A2806E9703";
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

     } else if (vars.commandIn("BUTTONProcessedBE4BA6F9C69A40DBBD1272B3130E3BC7")) {
        vars.setSessionValue("buttonBE4BA6F9C69A40DBBD1272B3130E3BC7.strprocessed", vars.getStringParameter("inpprocessed"));
        vars.setSessionValue("buttonBE4BA6F9C69A40DBBD1272B3130E3BC7.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonBE4BA6F9C69A40DBBD1272B3130E3BC7.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonBE4BA6F9C69A40DBBD1272B3130E3BC7.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonBE4BA6F9C69A40DBBD1272B3130E3BC7.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "BE4BA6F9C69A40DBBD1272B3130E3BC7", request.getServletPath());    
     } else if (vars.commandIn("BUTTONBE4BA6F9C69A40DBBD1272B3130E3BC7")) {
        String strSsct_Advance_ID = vars.getGlobalVariable("inpssctAdvanceId", windowId + "|Ssct_Advance_ID", "");
        String strprocessed = vars.getSessionValue("buttonBE4BA6F9C69A40DBBD1272B3130E3BC7.strprocessed");
        String strProcessing = vars.getSessionValue("buttonBE4BA6F9C69A40DBBD1272B3130E3BC7.strProcessing");
        String strOrg = vars.getSessionValue("buttonBE4BA6F9C69A40DBBD1272B3130E3BC7.strOrg");
        String strClient = vars.getSessionValue("buttonBE4BA6F9C69A40DBBD1272B3130E3BC7.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcessedBE4BA6F9C69A40DBBD1272B3130E3BC7(response, vars, strSsct_Advance_ID, strprocessed, strProcessing);
        }

     } else if (vars.commandIn("BUTTONUnprocessed4D5CA698991D41E8BCCD18A2806E9703")) {
        vars.setSessionValue("button4D5CA698991D41E8BCCD18A2806E9703.strunprocessed", vars.getStringParameter("inpunprocessed"));
        vars.setSessionValue("button4D5CA698991D41E8BCCD18A2806E9703.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button4D5CA698991D41E8BCCD18A2806E9703.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button4D5CA698991D41E8BCCD18A2806E9703.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button4D5CA698991D41E8BCCD18A2806E9703.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "4D5CA698991D41E8BCCD18A2806E9703", request.getServletPath());    
     } else if (vars.commandIn("BUTTON4D5CA698991D41E8BCCD18A2806E9703")) {
        String strSsct_Advance_ID = vars.getGlobalVariable("inpssctAdvanceId", windowId + "|Ssct_Advance_ID", "");
        String strunprocessed = vars.getSessionValue("button4D5CA698991D41E8BCCD18A2806E9703.strunprocessed");
        String strProcessing = vars.getSessionValue("button4D5CA698991D41E8BCCD18A2806E9703.strProcessing");
        String strOrg = vars.getSessionValue("button4D5CA698991D41E8BCCD18A2806E9703.strOrg");
        String strClient = vars.getSessionValue("button4D5CA698991D41E8BCCD18A2806E9703.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonUnprocessed4D5CA698991D41E8BCCD18A2806E9703(response, vars, strSsct_Advance_ID, strunprocessed, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONProcessedBE4BA6F9C69A40DBBD1272B3130E3BC7")) {
        String strSsct_Advance_ID = vars.getGlobalVariable("inpKey", windowId + "|Ssct_Advance_ID", "");
        String strprocessed = vars.getStringParameter("inpprocessed");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "BE4BA6F9C69A40DBBD1272B3130E3BC7", (("Ssct_Advance_ID".equalsIgnoreCase("AD_Language"))?"0":strSsct_Advance_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          String strstatus = vars.getStringParameter("inpstatus");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "Status", strstatus, vars.getClient(), vars.getOrg(), vars.getUser());

          
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
    } else if (vars.commandIn("SAVE_BUTTONUnprocessed4D5CA698991D41E8BCCD18A2806E9703")) {
        String strSsct_Advance_ID = vars.getGlobalVariable("inpKey", windowId + "|Ssct_Advance_ID", "");
        String strunprocessed = vars.getStringParameter("inpunprocessed");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "4D5CA698991D41E8BCCD18A2806E9703", (("Ssct_Advance_ID".equalsIgnoreCase("AD_Language"))?"0":strSsct_Advance_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    private void printPageButtonProcessedBE4BA6F9C69A40DBBD1272B3130E3BC7(HttpServletResponse response, VariablesSecureApp vars, String strSsct_Advance_ID, String strprocessed, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process BE4BA6F9C69A40DBBD1272B3130E3BC7");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ProcessedBE4BA6F9C69A40DBBD1272B3130E3BC7", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSsct_Advance_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "AdvanceFA0361705F854CA5B845C7DB4418ADFA_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "BE4BA6F9C69A40DBBD1272B3130E3BC7");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("BE4BA6F9C69A40DBBD1272B3130E3BC7");
        vars.removeMessage("BE4BA6F9C69A40DBBD1272B3130E3BC7");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("Status", "");
    comboTableData = new ComboTableData(vars, this, "17", "Status", "2525157AB0544A67888375699FC64E50", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, (FieldProvider) vars.getSessionObject("buttonBE4BA6F9C69A40DBBD1272B3130E3BC7.originalParams"), comboTableData, windowId, "");
    xmlDocument.setData("reportStatus", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      
      out.println(xmlDocument.print());
      out.close();
    }
    private void printPageButtonUnprocessed4D5CA698991D41E8BCCD18A2806E9703(HttpServletResponse response, VariablesSecureApp vars, String strSsct_Advance_ID, String strunprocessed, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 4D5CA698991D41E8BCCD18A2806E9703");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Unprocessed4D5CA698991D41E8BCCD18A2806E9703", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSsct_Advance_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "AdvanceFA0361705F854CA5B845C7DB4418ADFA_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "4D5CA698991D41E8BCCD18A2806E9703");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("4D5CA698991D41E8BCCD18A2806E9703");
        vars.removeMessage("4D5CA698991D41E8BCCD18A2806E9703");
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
