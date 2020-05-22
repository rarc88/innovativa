
package org.openbravo.erpWindows.it.openia.crm.Leads;


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
public class Contacts84A996CBB6434F07949CD86F62F05E71 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "69469E04533A46EDA7D923964AE18BCA";
  private static final String tabId = "84A996CBB6434F07949CD86F62F05E71";
  private static final int accesslevel = 7;
  private static final String moduleId = "9FF1C0E7BAEF407EA93F0C2732F6CD11";
  
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
     
      if (command.contains("C351ECDB50E64B5289BD668A2804BE59")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("C351ECDB50E64B5289BD668A2804BE59");
        SessionInfo.setModuleId("9FF1C0E7BAEF407EA93F0C2732F6CD11");
        if (securedProcess || explicitAccess.contains("C351ECDB50E64B5289BD668A2804BE59")) {
          classInfo.type = "P";
          classInfo.id = "C351ECDB50E64B5289BD668A2804BE59";
        }
      }
     
      if (command.contains("B84F4DE3795745D381B683BE4C120FE3")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("B84F4DE3795745D381B683BE4C120FE3");
        SessionInfo.setModuleId("9FF1C0E7BAEF407EA93F0C2732F6CD11");
        if (securedProcess || explicitAccess.contains("B84F4DE3795745D381B683BE4C120FE3")) {
          classInfo.type = "P";
          classInfo.id = "B84F4DE3795745D381B683BE4C120FE3";
        }
      }
     
      if (command.contains("5DC06629C50343499DA878CFBAE5AA3E")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("5DC06629C50343499DA878CFBAE5AA3E");
        SessionInfo.setModuleId("9FF1C0E7BAEF407EA93F0C2732F6CD11");
        if (securedProcess || explicitAccess.contains("5DC06629C50343499DA878CFBAE5AA3E")) {
          classInfo.type = "P";
          classInfo.id = "5DC06629C50343499DA878CFBAE5AA3E";
        }
      }
     
      if (command.contains("1A3A89BD1E9F4CCFB700878230C249B5")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("1A3A89BD1E9F4CCFB700878230C249B5");
        SessionInfo.setModuleId("9FF1C0E7BAEF407EA93F0C2732F6CD11");
        if (securedProcess || explicitAccess.contains("1A3A89BD1E9F4CCFB700878230C249B5")) {
          classInfo.type = "P";
          classInfo.id = "1A3A89BD1E9F4CCFB700878230C249B5";
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

     } else if (vars.commandIn("BUTTONEM_Opcrm_CreatepartnerC351ECDB50E64B5289BD668A2804BE59")) {
        vars.setSessionValue("buttonC351ECDB50E64B5289BD668A2804BE59.stremOpcrmCreatepartner", vars.getStringParameter("inpemOpcrmCreatepartner"));
        vars.setSessionValue("buttonC351ECDB50E64B5289BD668A2804BE59.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonC351ECDB50E64B5289BD668A2804BE59.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonC351ECDB50E64B5289BD668A2804BE59.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonC351ECDB50E64B5289BD668A2804BE59.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "C351ECDB50E64B5289BD668A2804BE59", request.getServletPath());    
     } else if (vars.commandIn("BUTTONC351ECDB50E64B5289BD668A2804BE59")) {
        String strAD_User_ID = vars.getGlobalVariable("inpadUserId", windowId + "|AD_User_ID", "");
        String stremOpcrmCreatepartner = vars.getSessionValue("buttonC351ECDB50E64B5289BD668A2804BE59.stremOpcrmCreatepartner");
        String strProcessing = vars.getSessionValue("buttonC351ECDB50E64B5289BD668A2804BE59.strProcessing");
        String strOrg = vars.getSessionValue("buttonC351ECDB50E64B5289BD668A2804BE59.strOrg");
        String strClient = vars.getSessionValue("buttonC351ECDB50E64B5289BD668A2804BE59.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Opcrm_CreatepartnerC351ECDB50E64B5289BD668A2804BE59(response, vars, strAD_User_ID, stremOpcrmCreatepartner, strProcessing);
        }

     } else if (vars.commandIn("BUTTONEM_Opcrm_CreateoppB84F4DE3795745D381B683BE4C120FE3")) {
        vars.setSessionValue("buttonB84F4DE3795745D381B683BE4C120FE3.stremOpcrmCreateopp", vars.getStringParameter("inpemOpcrmCreateopp"));
        vars.setSessionValue("buttonB84F4DE3795745D381B683BE4C120FE3.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonB84F4DE3795745D381B683BE4C120FE3.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonB84F4DE3795745D381B683BE4C120FE3.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonB84F4DE3795745D381B683BE4C120FE3.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "B84F4DE3795745D381B683BE4C120FE3", request.getServletPath());    
     } else if (vars.commandIn("BUTTONB84F4DE3795745D381B683BE4C120FE3")) {
        String strAD_User_ID = vars.getGlobalVariable("inpadUserId", windowId + "|AD_User_ID", "");
        String stremOpcrmCreateopp = vars.getSessionValue("buttonB84F4DE3795745D381B683BE4C120FE3.stremOpcrmCreateopp");
        String strProcessing = vars.getSessionValue("buttonB84F4DE3795745D381B683BE4C120FE3.strProcessing");
        String strOrg = vars.getSessionValue("buttonB84F4DE3795745D381B683BE4C120FE3.strOrg");
        String strClient = vars.getSessionValue("buttonB84F4DE3795745D381B683BE4C120FE3.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Opcrm_CreateoppB84F4DE3795745D381B683BE4C120FE3(response, vars, strAD_User_ID, stremOpcrmCreateopp, strProcessing);
        }

     } else if (vars.commandIn("BUTTONEM_Opcrm_Createactivity5DC06629C50343499DA878CFBAE5AA3E")) {
        vars.setSessionValue("button5DC06629C50343499DA878CFBAE5AA3E.stremOpcrmCreateactivity", vars.getStringParameter("inpemOpcrmCreateactivity"));
        vars.setSessionValue("button5DC06629C50343499DA878CFBAE5AA3E.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button5DC06629C50343499DA878CFBAE5AA3E.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button5DC06629C50343499DA878CFBAE5AA3E.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button5DC06629C50343499DA878CFBAE5AA3E.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "5DC06629C50343499DA878CFBAE5AA3E", request.getServletPath());    
     } else if (vars.commandIn("BUTTON5DC06629C50343499DA878CFBAE5AA3E")) {
        String strAD_User_ID = vars.getGlobalVariable("inpadUserId", windowId + "|AD_User_ID", "");
        String stremOpcrmCreateactivity = vars.getSessionValue("button5DC06629C50343499DA878CFBAE5AA3E.stremOpcrmCreateactivity");
        String strProcessing = vars.getSessionValue("button5DC06629C50343499DA878CFBAE5AA3E.strProcessing");
        String strOrg = vars.getSessionValue("button5DC06629C50343499DA878CFBAE5AA3E.strOrg");
        String strClient = vars.getSessionValue("button5DC06629C50343499DA878CFBAE5AA3E.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Opcrm_Createactivity5DC06629C50343499DA878CFBAE5AA3E(response, vars, strAD_User_ID, stremOpcrmCreateactivity, strProcessing);
        }

     } else if (vars.commandIn("BUTTONEM_Opcrm_Add_Users1A3A89BD1E9F4CCFB700878230C249B5")) {
        vars.setSessionValue("button1A3A89BD1E9F4CCFB700878230C249B5.stremOpcrmAddUsers", vars.getStringParameter("inpemOpcrmAddUsers"));
        vars.setSessionValue("button1A3A89BD1E9F4CCFB700878230C249B5.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button1A3A89BD1E9F4CCFB700878230C249B5.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button1A3A89BD1E9F4CCFB700878230C249B5.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button1A3A89BD1E9F4CCFB700878230C249B5.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "1A3A89BD1E9F4CCFB700878230C249B5", request.getServletPath());    
     } else if (vars.commandIn("BUTTON1A3A89BD1E9F4CCFB700878230C249B5")) {
        String strAD_User_ID = vars.getGlobalVariable("inpadUserId", windowId + "|AD_User_ID", "");
        String stremOpcrmAddUsers = vars.getSessionValue("button1A3A89BD1E9F4CCFB700878230C249B5.stremOpcrmAddUsers");
        String strProcessing = vars.getSessionValue("button1A3A89BD1E9F4CCFB700878230C249B5.strProcessing");
        String strOrg = vars.getSessionValue("button1A3A89BD1E9F4CCFB700878230C249B5.strOrg");
        String strClient = vars.getSessionValue("button1A3A89BD1E9F4CCFB700878230C249B5.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Opcrm_Add_Users1A3A89BD1E9F4CCFB700878230C249B5(response, vars, strAD_User_ID, stremOpcrmAddUsers, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONEM_Opcrm_CreatepartnerC351ECDB50E64B5289BD668A2804BE59")) {
        String strAD_User_ID = vars.getGlobalVariable("inpKey", windowId + "|AD_User_ID", "");
        String stremOpcrmCreatepartner = vars.getStringParameter("inpemOpcrmCreatepartner");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "C351ECDB50E64B5289BD668A2804BE59", (("AD_User_ID".equalsIgnoreCase("AD_Language"))?"0":strAD_User_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONEM_Opcrm_CreateoppB84F4DE3795745D381B683BE4C120FE3")) {
        String strAD_User_ID = vars.getGlobalVariable("inpKey", windowId + "|AD_User_ID", "");
        String stremOpcrmCreateopp = vars.getStringParameter("inpemOpcrmCreateopp");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "B84F4DE3795745D381B683BE4C120FE3", (("AD_User_ID".equalsIgnoreCase("AD_Language"))?"0":strAD_User_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          String strsubject = vars.getStringParameter("inpsubject");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "subject", strsubject, vars.getClient(), vars.getOrg(), vars.getUser());
String strclosedate = vars.getStringParameter("inpclosedate");
PInstanceProcessData.insertPInstanceParamDate(this, pinstance, "20", "closedate", strclosedate, vars.getClient(), vars.getOrg(), vars.getUser());
String stroppAmount = vars.getNumericParameter("inpoppAmount");
PInstanceProcessData.insertPInstanceParamNumber(this, pinstance, "30", "opp_amount", stroppAmount, vars.getClient(), vars.getOrg(), vars.getUser());
String strprobability = vars.getNumericParameter("inpprobability");
PInstanceProcessData.insertPInstanceParamNumber(this, pinstance, "40", "probability", strprobability, vars.getClient(), vars.getOrg(), vars.getUser());

          
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
    } else if (vars.commandIn("SAVE_BUTTONEM_Opcrm_Createactivity5DC06629C50343499DA878CFBAE5AA3E")) {
        String strAD_User_ID = vars.getGlobalVariable("inpKey", windowId + "|AD_User_ID", "");
        String stremOpcrmCreateactivity = vars.getStringParameter("inpemOpcrmCreateactivity");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "5DC06629C50343499DA878CFBAE5AA3E", (("AD_User_ID".equalsIgnoreCase("AD_Language"))?"0":strAD_User_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          String strsubject = vars.getStringParameter("inpsubject");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "subject", strsubject, vars.getClient(), vars.getOrg(), vars.getUser());
String stractivityType = vars.getStringParameter("inpactivityType");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "15", "Activity_Type", stractivityType, vars.getClient(), vars.getOrg(), vars.getUser());
String stractivityStatus = vars.getStringParameter("inpactivityStatus");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "17", "Activity_Status", stractivityStatus, vars.getClient(), vars.getOrg(), vars.getUser());
String strstartdate = vars.getStringParameter("inpstartdate");
PInstanceProcessData.insertPInstanceParamDate(this, pinstance, "20", "startdate", strstartdate, vars.getClient(), vars.getOrg(), vars.getUser());
String strstartH = vars.getNumericParameter("inpstartH");
PInstanceProcessData.insertPInstanceParamNumber(this, pinstance, "30", "start_h", strstartH, vars.getClient(), vars.getOrg(), vars.getUser());
String strstartM = vars.getNumericParameter("inpstartM");
PInstanceProcessData.insertPInstanceParamNumber(this, pinstance, "40", "start_m", strstartM, vars.getClient(), vars.getOrg(), vars.getUser());
String strdurationH = vars.getNumericParameter("inpdurationH");
PInstanceProcessData.insertPInstanceParamNumber(this, pinstance, "50", "duration_h", strdurationH, vars.getClient(), vars.getOrg(), vars.getUser());
String strdurationM = vars.getNumericParameter("inpdurationM");
PInstanceProcessData.insertPInstanceParamNumber(this, pinstance, "60", "duration_m", strdurationM, vars.getClient(), vars.getOrg(), vars.getUser());
String strdescription = vars.getStringParameter("inpdescription");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "70", "description", strdescription, vars.getClient(), vars.getOrg(), vars.getUser());
String strleadstatus = vars.getStringParameter("inpleadstatus");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "80", "leadstatus", strleadstatus, vars.getClient(), vars.getOrg(), vars.getUser());

          
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
    } else if (vars.commandIn("SAVE_BUTTONEM_Opcrm_Add_Users1A3A89BD1E9F4CCFB700878230C249B5")) {
        String strAD_User_ID = vars.getGlobalVariable("inpKey", windowId + "|AD_User_ID", "");
        String stremOpcrmAddUsers = vars.getStringParameter("inpemOpcrmAddUsers");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "1A3A89BD1E9F4CCFB700878230C249B5", (("AD_User_ID".equalsIgnoreCase("AD_Language"))?"0":strAD_User_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          String stradRoleId = vars.getStringParameter("inpadRoleId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "ad_role_id", stradRoleId, vars.getClient(), vars.getOrg(), vars.getUser());

          
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

    private void printPageButtonEM_Opcrm_CreatepartnerC351ECDB50E64B5289BD668A2804BE59(HttpServletResponse response, VariablesSecureApp vars, String strAD_User_ID, String stremOpcrmCreatepartner, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process C351ECDB50E64B5289BD668A2804BE59");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Opcrm_CreatepartnerC351ECDB50E64B5289BD668A2804BE59", discard).createXmlDocument();
      xmlDocument.setParameter("key", strAD_User_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Contacts84A996CBB6434F07949CD86F62F05E71_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "C351ECDB50E64B5289BD668A2804BE59");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("C351ECDB50E64B5289BD668A2804BE59");
        vars.removeMessage("C351ECDB50E64B5289BD668A2804BE59");
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
    private void printPageButtonEM_Opcrm_CreateoppB84F4DE3795745D381B683BE4C120FE3(HttpServletResponse response, VariablesSecureApp vars, String strAD_User_ID, String stremOpcrmCreateopp, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process B84F4DE3795745D381B683BE4C120FE3");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Opcrm_CreateoppB84F4DE3795745D381B683BE4C120FE3", discard).createXmlDocument();
      xmlDocument.setParameter("key", strAD_User_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Contacts84A996CBB6434F07949CD86F62F05E71_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "B84F4DE3795745D381B683BE4C120FE3");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("B84F4DE3795745D381B683BE4C120FE3");
        vars.removeMessage("B84F4DE3795745D381B683BE4C120FE3");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    xmlDocument.setParameter("subject", Contacts84A996CBB6434F07949CD86F62F05E71Data.selectActPB84F4DE3795745D381B683BE4C120FE3_subject(this, Utility.getContext(this, vars, "ad_user_id", "69469E04533A46EDA7D923964AE18BCA")));
    xmlDocument.setParameter("closedate", DateTimeData.today(this));
    xmlDocument.setParameter("closedate_Format", vars.getSessionValue("#AD_SqlDateFormat"));
    xmlDocument.setParameter("opp_amount", "");
    xmlDocument.setParameter("probability", "");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      
      out.println(xmlDocument.print());
      out.close();
    }
    private void printPageButtonEM_Opcrm_Createactivity5DC06629C50343499DA878CFBAE5AA3E(HttpServletResponse response, VariablesSecureApp vars, String strAD_User_ID, String stremOpcrmCreateactivity, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 5DC06629C50343499DA878CFBAE5AA3E");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Opcrm_Createactivity5DC06629C50343499DA878CFBAE5AA3E", discard).createXmlDocument();
      xmlDocument.setParameter("key", strAD_User_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Contacts84A996CBB6434F07949CD86F62F05E71_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "5DC06629C50343499DA878CFBAE5AA3E");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("5DC06629C50343499DA878CFBAE5AA3E");
        vars.removeMessage("5DC06629C50343499DA878CFBAE5AA3E");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("subject", Contacts84A996CBB6434F07949CD86F62F05E71Data.selectActP5DC06629C50343499DA878CFBAE5AA3E_subject(this, Utility.getContext(this, vars, "ad_user_id", "69469E04533A46EDA7D923964AE18BCA")));
    xmlDocument.setParameter("Activity_Type", "");
    comboTableData = new ComboTableData(vars, this, "17", "Activity_Type", "5DD1BD096384449E8E30774781EFE2B5", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, (FieldProvider) vars.getSessionObject("button5DC06629C50343499DA878CFBAE5AA3E.originalParams"), comboTableData, windowId, "");
    xmlDocument.setData("reportActivity_Type", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("Activity_Status", "");
    comboTableData = new ComboTableData(vars, this, "18", "Activity_Status", "4AF7C49CF7A84AC084E23CDFAF1F6584", "DBF434EE3D954E28B02FCBB03869D060", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, (FieldProvider) vars.getSessionObject("button5DC06629C50343499DA878CFBAE5AA3E.originalParams"), comboTableData, windowId, "");
    xmlDocument.setData("reportActivity_Status", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("startdate", DateTimeData.today(this));
    xmlDocument.setParameter("startdate_Format", vars.getSessionValue("#AD_SqlDateFormat"));
    xmlDocument.setParameter("start_h", "9");
    xmlDocument.setParameter("start_m", "0");
    xmlDocument.setParameter("duration_h", "1");
    xmlDocument.setParameter("duration_m", "0");
    xmlDocument.setParameter("description", "");
    xmlDocument.setParameter("leadstatus", Contacts84A996CBB6434F07949CD86F62F05E71Data.selectActP5DC06629C50343499DA878CFBAE5AA3E_leadstatus(this, Utility.getContext(this, vars, "ad_user_id", "69469E04533A46EDA7D923964AE18BCA")));
    comboTableData = new ComboTableData(vars, this, "17", "leadstatus", "CD2A0471C22241479956AA806EFDC9A4", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, (FieldProvider) vars.getSessionObject("button5DC06629C50343499DA878CFBAE5AA3E.originalParams"), comboTableData, windowId, Contacts84A996CBB6434F07949CD86F62F05E71Data.selectActP5DC06629C50343499DA878CFBAE5AA3E_leadstatus(this, Utility.getContext(this, vars, "ad_user_id", "69469E04533A46EDA7D923964AE18BCA")));
    xmlDocument.setData("reportleadstatus", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      
      out.println(xmlDocument.print());
      out.close();
    }
    private void printPageButtonEM_Opcrm_Add_Users1A3A89BD1E9F4CCFB700878230C249B5(HttpServletResponse response, VariablesSecureApp vars, String strAD_User_ID, String stremOpcrmAddUsers, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 1A3A89BD1E9F4CCFB700878230C249B5");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Opcrm_Add_Users1A3A89BD1E9F4CCFB700878230C249B5", discard).createXmlDocument();
      xmlDocument.setParameter("key", strAD_User_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Contacts84A996CBB6434F07949CD86F62F05E71_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "1A3A89BD1E9F4CCFB700878230C249B5");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("1A3A89BD1E9F4CCFB700878230C249B5");
        vars.removeMessage("1A3A89BD1E9F4CCFB700878230C249B5");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("ad_role_id", "");
    comboTableData = new ComboTableData(vars, this, "18", "ad_role_id", "800105", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, (FieldProvider) vars.getSessionObject("button1A3A89BD1E9F4CCFB700878230C249B5.originalParams"), comboTableData, windowId, "");
    xmlDocument.setData("reportad_role_id", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      
      out.println(xmlDocument.print());
      out.close();
    }



}
