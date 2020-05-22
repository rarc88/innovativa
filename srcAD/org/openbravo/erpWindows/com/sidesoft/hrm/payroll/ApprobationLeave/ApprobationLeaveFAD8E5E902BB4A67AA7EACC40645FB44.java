
package org.openbravo.erpWindows.com.sidesoft.hrm.payroll.ApprobationLeave;


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
public class ApprobationLeaveFAD8E5E902BB4A67AA7EACC40645FB44 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "EADFCC9FB0D04E088F50393A47E721B1";
  private static final String tabId = "FAD8E5E902BB4A67AA7EACC40645FB44";
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
     
      if (command.contains("05EC084A82EF4EE2A8B9C317586238A7")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("05EC084A82EF4EE2A8B9C317586238A7");
        SessionInfo.setModuleId("169A6DDBFEB948C98F0617CE3B4CABD5");
        if (securedProcess || explicitAccess.contains("05EC084A82EF4EE2A8B9C317586238A7")) {
          classInfo.type = "P";
          classInfo.id = "05EC084A82EF4EE2A8B9C317586238A7";
        }
      }
     
      if (command.contains("750589DEF78C4F17ABDD748B02907F2D")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("750589DEF78C4F17ABDD748B02907F2D");
        SessionInfo.setModuleId("169A6DDBFEB948C98F0617CE3B4CABD5");
        if (securedProcess || explicitAccess.contains("750589DEF78C4F17ABDD748B02907F2D")) {
          classInfo.type = "P";
          classInfo.id = "750589DEF78C4F17ABDD748B02907F2D";
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

     } else if (vars.commandIn("BUTTONProcess_Reactive05EC084A82EF4EE2A8B9C317586238A7")) {
        vars.setSessionValue("button05EC084A82EF4EE2A8B9C317586238A7.strprocessReactive", vars.getStringParameter("inpprocessReactive"));
        vars.setSessionValue("button05EC084A82EF4EE2A8B9C317586238A7.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button05EC084A82EF4EE2A8B9C317586238A7.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button05EC084A82EF4EE2A8B9C317586238A7.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button05EC084A82EF4EE2A8B9C317586238A7.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "05EC084A82EF4EE2A8B9C317586238A7", request.getServletPath());    
     } else if (vars.commandIn("BUTTON05EC084A82EF4EE2A8B9C317586238A7")) {
        String strSspr_Leave_Emp_ID = vars.getGlobalVariable("inpssprLeaveEmpId", windowId + "|Sspr_Leave_Emp_ID", "");
        String strprocessReactive = vars.getSessionValue("button05EC084A82EF4EE2A8B9C317586238A7.strprocessReactive");
        String strProcessing = vars.getSessionValue("button05EC084A82EF4EE2A8B9C317586238A7.strProcessing");
        String strOrg = vars.getSessionValue("button05EC084A82EF4EE2A8B9C317586238A7.strOrg");
        String strClient = vars.getSessionValue("button05EC084A82EF4EE2A8B9C317586238A7.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcess_Reactive05EC084A82EF4EE2A8B9C317586238A7(response, vars, strSspr_Leave_Emp_ID, strprocessReactive, strProcessing);
        }

     } else if (vars.commandIn("BUTTONApproved_Status750589DEF78C4F17ABDD748B02907F2D")) {
        vars.setSessionValue("button750589DEF78C4F17ABDD748B02907F2D.strapprovedStatus", vars.getStringParameter("inpapprovedStatus"));
        vars.setSessionValue("button750589DEF78C4F17ABDD748B02907F2D.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button750589DEF78C4F17ABDD748B02907F2D.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button750589DEF78C4F17ABDD748B02907F2D.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button750589DEF78C4F17ABDD748B02907F2D.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "750589DEF78C4F17ABDD748B02907F2D", request.getServletPath());    
     } else if (vars.commandIn("BUTTON750589DEF78C4F17ABDD748B02907F2D")) {
        String strSspr_Leave_Emp_ID = vars.getGlobalVariable("inpssprLeaveEmpId", windowId + "|Sspr_Leave_Emp_ID", "");
        String strapprovedStatus = vars.getSessionValue("button750589DEF78C4F17ABDD748B02907F2D.strapprovedStatus");
        String strProcessing = vars.getSessionValue("button750589DEF78C4F17ABDD748B02907F2D.strProcessing");
        String strOrg = vars.getSessionValue("button750589DEF78C4F17ABDD748B02907F2D.strOrg");
        String strClient = vars.getSessionValue("button750589DEF78C4F17ABDD748B02907F2D.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonApproved_Status750589DEF78C4F17ABDD748B02907F2D(response, vars, strSspr_Leave_Emp_ID, strapprovedStatus, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONProcess_Reactive05EC084A82EF4EE2A8B9C317586238A7")) {
        String strSspr_Leave_Emp_ID = vars.getGlobalVariable("inpKey", windowId + "|Sspr_Leave_Emp_ID", "");
        String strprocessReactive = vars.getStringParameter("inpprocessReactive");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "05EC084A82EF4EE2A8B9C317586238A7", (("Sspr_Leave_Emp_ID".equalsIgnoreCase("AD_Language"))?"0":strSspr_Leave_Emp_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONApproved_Status750589DEF78C4F17ABDD748B02907F2D")) {
        String strSspr_Leave_Emp_ID = vars.getGlobalVariable("inpKey", windowId + "|Sspr_Leave_Emp_ID", "");
        String strapprovedStatus = vars.getStringParameter("inpapprovedStatus");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "750589DEF78C4F17ABDD748B02907F2D", (("Sspr_Leave_Emp_ID".equalsIgnoreCase("AD_Language"))?"0":strSspr_Leave_Emp_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          String strstatusdoc = vars.getStringParameter("inpstatusdoc");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "statusdoc", strstatusdoc, vars.getClient(), vars.getOrg(), vars.getUser());

          
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

    private void printPageButtonProcess_Reactive05EC084A82EF4EE2A8B9C317586238A7(HttpServletResponse response, VariablesSecureApp vars, String strSspr_Leave_Emp_ID, String strprocessReactive, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 05EC084A82EF4EE2A8B9C317586238A7");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Process_Reactive05EC084A82EF4EE2A8B9C317586238A7", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSspr_Leave_Emp_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "ApprobationLeaveFAD8E5E902BB4A67AA7EACC40645FB44_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "05EC084A82EF4EE2A8B9C317586238A7");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("05EC084A82EF4EE2A8B9C317586238A7");
        vars.removeMessage("05EC084A82EF4EE2A8B9C317586238A7");
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
    private void printPageButtonApproved_Status750589DEF78C4F17ABDD748B02907F2D(HttpServletResponse response, VariablesSecureApp vars, String strSspr_Leave_Emp_ID, String strapprovedStatus, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 750589DEF78C4F17ABDD748B02907F2D");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Approved_Status750589DEF78C4F17ABDD748B02907F2D", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSspr_Leave_Emp_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "ApprobationLeaveFAD8E5E902BB4A67AA7EACC40645FB44_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "750589DEF78C4F17ABDD748B02907F2D");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("750589DEF78C4F17ABDD748B02907F2D");
        vars.removeMessage("750589DEF78C4F17ABDD748B02907F2D");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("statusdoc", "");
    comboTableData = new ComboTableData(vars, this, "17", "statusdoc", "9F8E4CDDDB8B4AB19A1267AB5FEB018D", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, (FieldProvider) vars.getSessionObject("button750589DEF78C4F17ABDD748B02907F2D.originalParams"), comboTableData, windowId, "");
    xmlDocument.setData("reportstatusdoc", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      
      out.println(xmlDocument.print());
      out.close();
    }



}
