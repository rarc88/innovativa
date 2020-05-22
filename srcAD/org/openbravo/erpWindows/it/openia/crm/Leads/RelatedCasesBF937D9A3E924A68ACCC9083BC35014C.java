
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
public class RelatedCasesBF937D9A3E924A68ACCC9083BC35014C extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "69469E04533A46EDA7D923964AE18BCA";
  private static final String tabId = "BF937D9A3E924A68ACCC9083BC35014C";
  private static final int accesslevel = 3;
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
     
      if (command.contains("DBF26D81854746A19B1F2B1F0B4C0952")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("DBF26D81854746A19B1F2B1F0B4C0952");
        SessionInfo.setModuleId("9FF1C0E7BAEF407EA93F0C2732F6CD11");
      }
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     
      if (command.contains("6B86D15CA45A4849B1EA1D922751E292")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("6B86D15CA45A4849B1EA1D922751E292");
        SessionInfo.setModuleId("9FF1C0E7BAEF407EA93F0C2732F6CD11");
        if (securedProcess || explicitAccess.contains("6B86D15CA45A4849B1EA1D922751E292")) {
          classInfo.type = "P";
          classInfo.id = "6B86D15CA45A4849B1EA1D922751E292";
        }
      }
     
      if (command.contains("33BD1CE5A5934EDFAE283A16E6BF5257")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("33BD1CE5A5934EDFAE283A16E6BF5257");
        SessionInfo.setModuleId("9FF1C0E7BAEF407EA93F0C2732F6CD11");
        if (securedProcess || explicitAccess.contains("33BD1CE5A5934EDFAE283A16E6BF5257")) {
          classInfo.type = "P";
          classInfo.id = "33BD1CE5A5934EDFAE283A16E6BF5257";
        }
      }
     
      if (command.contains("CC5E57D367314D2A9C01498FEF216FF4")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("CC5E57D367314D2A9C01498FEF216FF4");
        SessionInfo.setModuleId("9FF1C0E7BAEF407EA93F0C2732F6CD11");
        if (securedProcess || explicitAccess.contains("CC5E57D367314D2A9C01498FEF216FF4")) {
          classInfo.type = "P";
          classInfo.id = "CC5E57D367314D2A9C01498FEF216FF4";
        }
      }
     
      if (command.contains("014175B1E891443F8B85EF51C2BF897B")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("014175B1E891443F8B85EF51C2BF897B");
        SessionInfo.setModuleId("9FF1C0E7BAEF407EA93F0C2732F6CD11");
        if (securedProcess || explicitAccess.contains("014175B1E891443F8B85EF51C2BF897B")) {
          classInfo.type = "P";
          classInfo.id = "014175B1E891443F8B85EF51C2BF897B";
        }
      }
     

     
      if (explicitAccess.contains("DBF26D81854746A19B1F2B1F0B4C0952") || (securedProcess && command.contains("DBF26D81854746A19B1F2B1F0B4C0952"))) {
        classInfo.type = "P";
        classInfo.id = "DBF26D81854746A19B1F2B1F0B4C0952";
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

     } else if (vars.commandIn("BUTTONADD_Users6B86D15CA45A4849B1EA1D922751E292")) {
        vars.setSessionValue("button6B86D15CA45A4849B1EA1D922751E292.straddUsers", vars.getStringParameter("inpaddUsers"));
        vars.setSessionValue("button6B86D15CA45A4849B1EA1D922751E292.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button6B86D15CA45A4849B1EA1D922751E292.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button6B86D15CA45A4849B1EA1D922751E292.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button6B86D15CA45A4849B1EA1D922751E292.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "6B86D15CA45A4849B1EA1D922751E292", request.getServletPath());    
     } else if (vars.commandIn("BUTTON6B86D15CA45A4849B1EA1D922751E292")) {
        String strOpcrm_Cases_ID = vars.getGlobalVariable("inpopcrmCasesId", windowId + "|Opcrm_Cases_ID", "");
        String straddUsers = vars.getSessionValue("button6B86D15CA45A4849B1EA1D922751E292.straddUsers");
        String strProcessing = vars.getSessionValue("button6B86D15CA45A4849B1EA1D922751E292.strProcessing");
        String strOrg = vars.getSessionValue("button6B86D15CA45A4849B1EA1D922751E292.strOrg");
        String strClient = vars.getSessionValue("button6B86D15CA45A4849B1EA1D922751E292.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonADD_Users6B86D15CA45A4849B1EA1D922751E292(response, vars, strOpcrm_Cases_ID, straddUsers, strProcessing);
        }

     } else if (vars.commandIn("BUTTONActivity_Button33BD1CE5A5934EDFAE283A16E6BF5257")) {
        vars.setSessionValue("button33BD1CE5A5934EDFAE283A16E6BF5257.stractivityButton", vars.getStringParameter("inpactivityButton"));
        vars.setSessionValue("button33BD1CE5A5934EDFAE283A16E6BF5257.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button33BD1CE5A5934EDFAE283A16E6BF5257.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button33BD1CE5A5934EDFAE283A16E6BF5257.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button33BD1CE5A5934EDFAE283A16E6BF5257.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "33BD1CE5A5934EDFAE283A16E6BF5257", request.getServletPath());    
     } else if (vars.commandIn("BUTTON33BD1CE5A5934EDFAE283A16E6BF5257")) {
        String strOpcrm_Cases_ID = vars.getGlobalVariable("inpopcrmCasesId", windowId + "|Opcrm_Cases_ID", "");
        String stractivityButton = vars.getSessionValue("button33BD1CE5A5934EDFAE283A16E6BF5257.stractivityButton");
        String strProcessing = vars.getSessionValue("button33BD1CE5A5934EDFAE283A16E6BF5257.strProcessing");
        String strOrg = vars.getSessionValue("button33BD1CE5A5934EDFAE283A16E6BF5257.strOrg");
        String strClient = vars.getSessionValue("button33BD1CE5A5934EDFAE283A16E6BF5257.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonActivity_Button33BD1CE5A5934EDFAE283A16E6BF5257(response, vars, strOpcrm_Cases_ID, stractivityButton, strProcessing);
        }

     } else if (vars.commandIn("BUTTONBegin_ButtonCC5E57D367314D2A9C01498FEF216FF4")) {
        vars.setSessionValue("buttonCC5E57D367314D2A9C01498FEF216FF4.strbeginButton", vars.getStringParameter("inpbeginButton"));
        vars.setSessionValue("buttonCC5E57D367314D2A9C01498FEF216FF4.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonCC5E57D367314D2A9C01498FEF216FF4.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonCC5E57D367314D2A9C01498FEF216FF4.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonCC5E57D367314D2A9C01498FEF216FF4.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "CC5E57D367314D2A9C01498FEF216FF4", request.getServletPath());    
     } else if (vars.commandIn("BUTTONCC5E57D367314D2A9C01498FEF216FF4")) {
        String strOpcrm_Cases_ID = vars.getGlobalVariable("inpopcrmCasesId", windowId + "|Opcrm_Cases_ID", "");
        String strbeginButton = vars.getSessionValue("buttonCC5E57D367314D2A9C01498FEF216FF4.strbeginButton");
        String strProcessing = vars.getSessionValue("buttonCC5E57D367314D2A9C01498FEF216FF4.strProcessing");
        String strOrg = vars.getSessionValue("buttonCC5E57D367314D2A9C01498FEF216FF4.strOrg");
        String strClient = vars.getSessionValue("buttonCC5E57D367314D2A9C01498FEF216FF4.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonBegin_ButtonCC5E57D367314D2A9C01498FEF216FF4(response, vars, strOpcrm_Cases_ID, strbeginButton, strProcessing);
        }

     } else if (vars.commandIn("BUTTONEND_Button014175B1E891443F8B85EF51C2BF897B")) {
        vars.setSessionValue("button014175B1E891443F8B85EF51C2BF897B.strendButton", vars.getStringParameter("inpendButton"));
        vars.setSessionValue("button014175B1E891443F8B85EF51C2BF897B.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button014175B1E891443F8B85EF51C2BF897B.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button014175B1E891443F8B85EF51C2BF897B.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button014175B1E891443F8B85EF51C2BF897B.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "014175B1E891443F8B85EF51C2BF897B", request.getServletPath());    
     } else if (vars.commandIn("BUTTON014175B1E891443F8B85EF51C2BF897B")) {
        String strOpcrm_Cases_ID = vars.getGlobalVariable("inpopcrmCasesId", windowId + "|Opcrm_Cases_ID", "");
        String strendButton = vars.getSessionValue("button014175B1E891443F8B85EF51C2BF897B.strendButton");
        String strProcessing = vars.getSessionValue("button014175B1E891443F8B85EF51C2BF897B.strProcessing");
        String strOrg = vars.getSessionValue("button014175B1E891443F8B85EF51C2BF897B.strOrg");
        String strClient = vars.getSessionValue("button014175B1E891443F8B85EF51C2BF897B.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEND_Button014175B1E891443F8B85EF51C2BF897B(response, vars, strOpcrm_Cases_ID, strendButton, strProcessing);
        }

    } else if (vars.commandIn("BUTTONSend_ButtonDBF26D81854746A19B1F2B1F0B4C0952")) {
        vars.setSessionValue("buttonDBF26D81854746A19B1F2B1F0B4C0952.strsendButton", vars.getStringParameter("inpsendButton"));
        vars.setSessionValue("buttonDBF26D81854746A19B1F2B1F0B4C0952.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonDBF26D81854746A19B1F2B1F0B4C0952.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonDBF26D81854746A19B1F2B1F0B4C0952.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonDBF26D81854746A19B1F2B1F0B4C0952.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "DBF26D81854746A19B1F2B1F0B4C0952", request.getServletPath());
      } else if (vars.commandIn("BUTTONDBF26D81854746A19B1F2B1F0B4C0952")) {
        String strOpcrm_Cases_ID = vars.getGlobalVariable("inpopcrmCasesId", windowId + "|Opcrm_Cases_ID", "");
        String strsendButton = vars.getSessionValue("buttonDBF26D81854746A19B1F2B1F0B4C0952.strsendButton");
        String strProcessing = vars.getSessionValue("buttonDBF26D81854746A19B1F2B1F0B4C0952.strProcessing");
        String strOrg = vars.getSessionValue("buttonDBF26D81854746A19B1F2B1F0B4C0952.strOrg");
        String strClient = vars.getSessionValue("buttonDBF26D81854746A19B1F2B1F0B4C0952.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonSend_ButtonDBF26D81854746A19B1F2B1F0B4C0952(response, vars, strOpcrm_Cases_ID, strsendButton, strProcessing);
        }

    } else if (vars.commandIn("SAVE_BUTTONADD_Users6B86D15CA45A4849B1EA1D922751E292")) {
        String strOpcrm_Cases_ID = vars.getGlobalVariable("inpKey", windowId + "|Opcrm_Cases_ID", "");
        String straddUsers = vars.getStringParameter("inpaddUsers");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "6B86D15CA45A4849B1EA1D922751E292", (("Opcrm_Cases_ID".equalsIgnoreCase("AD_Language"))?"0":strOpcrm_Cases_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
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
    } else if (vars.commandIn("SAVE_BUTTONActivity_Button33BD1CE5A5934EDFAE283A16E6BF5257")) {
        String strOpcrm_Cases_ID = vars.getGlobalVariable("inpKey", windowId + "|Opcrm_Cases_ID", "");
        String stractivityButton = vars.getStringParameter("inpactivityButton");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "33BD1CE5A5934EDFAE283A16E6BF5257", (("Opcrm_Cases_ID".equalsIgnoreCase("AD_Language"))?"0":strOpcrm_Cases_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          String strsubject = vars.getStringParameter("inpsubject");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "subject", strsubject, vars.getClient(), vars.getOrg(), vars.getUser());
String strstartdate = vars.getStringParameter("inpstartdate");
PInstanceProcessData.insertPInstanceParamDate(this, pinstance, "20", "startdate", strstartdate, vars.getClient(), vars.getOrg(), vars.getUser());
String strstartH = vars.getNumericParameter("inpstartH");
PInstanceProcessData.insertPInstanceParamNumber(this, pinstance, "30", "start_h", strstartH, vars.getClient(), vars.getOrg(), vars.getUser());
String strstartM = vars.getNumericParameter("inpstartM");
PInstanceProcessData.insertPInstanceParamNumber(this, pinstance, "40", "start_m", strstartM, vars.getClient(), vars.getOrg(), vars.getUser());

          
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
    } else if (vars.commandIn("SAVE_BUTTONBegin_ButtonCC5E57D367314D2A9C01498FEF216FF4")) {
        String strOpcrm_Cases_ID = vars.getGlobalVariable("inpKey", windowId + "|Opcrm_Cases_ID", "");
        String strbeginButton = vars.getStringParameter("inpbeginButton");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "CC5E57D367314D2A9C01498FEF216FF4", (("Opcrm_Cases_ID".equalsIgnoreCase("AD_Language"))?"0":strOpcrm_Cases_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONEND_Button014175B1E891443F8B85EF51C2BF897B")) {
        String strOpcrm_Cases_ID = vars.getGlobalVariable("inpKey", windowId + "|Opcrm_Cases_ID", "");
        String strendButton = vars.getStringParameter("inpendButton");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "014175B1E891443F8B85EF51C2BF897B", (("Opcrm_Cases_ID".equalsIgnoreCase("AD_Language"))?"0":strOpcrm_Cases_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    } else if (vars.commandIn("SAVE_BUTTONSend_ButtonDBF26D81854746A19B1F2B1F0B4C0952")) {
        String strOpcrm_Cases_ID = vars.getGlobalVariable("inpKey", windowId + "|Opcrm_Cases_ID", "");
        
        ProcessBundle pb = new ProcessBundle("DBF26D81854746A19B1F2B1F0B4C0952", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("Opcrm_Cases_ID", strOpcrm_Cases_ID);
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

    private void printPageButtonADD_Users6B86D15CA45A4849B1EA1D922751E292(HttpServletResponse response, VariablesSecureApp vars, String strOpcrm_Cases_ID, String straddUsers, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 6B86D15CA45A4849B1EA1D922751E292");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ADD_Users6B86D15CA45A4849B1EA1D922751E292", discard).createXmlDocument();
      xmlDocument.setParameter("key", strOpcrm_Cases_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "RelatedCasesBF937D9A3E924A68ACCC9083BC35014C_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "6B86D15CA45A4849B1EA1D922751E292");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("6B86D15CA45A4849B1EA1D922751E292");
        vars.removeMessage("6B86D15CA45A4849B1EA1D922751E292");
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
    Utility.fillSQLParameters(this, vars, (FieldProvider) vars.getSessionObject("button6B86D15CA45A4849B1EA1D922751E292.originalParams"), comboTableData, windowId, "");
    xmlDocument.setData("reportad_role_id", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      
      out.println(xmlDocument.print());
      out.close();
    }
    private void printPageButtonActivity_Button33BD1CE5A5934EDFAE283A16E6BF5257(HttpServletResponse response, VariablesSecureApp vars, String strOpcrm_Cases_ID, String stractivityButton, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 33BD1CE5A5934EDFAE283A16E6BF5257");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Activity_Button33BD1CE5A5934EDFAE283A16E6BF5257", discard).createXmlDocument();
      xmlDocument.setParameter("key", strOpcrm_Cases_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "RelatedCasesBF937D9A3E924A68ACCC9083BC35014C_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "33BD1CE5A5934EDFAE283A16E6BF5257");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("33BD1CE5A5934EDFAE283A16E6BF5257");
        vars.removeMessage("33BD1CE5A5934EDFAE283A16E6BF5257");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    xmlDocument.setParameter("subject", RelatedCasesBF937D9A3E924A68ACCC9083BC35014CData.selectActP33BD1CE5A5934EDFAE283A16E6BF5257_subject(this, Utility.getContext(this, vars, "opcrm_cases_id", "69469E04533A46EDA7D923964AE18BCA")));
    xmlDocument.setParameter("startdate", RelatedCasesBF937D9A3E924A68ACCC9083BC35014CData.selectActP33BD1CE5A5934EDFAE283A16E6BF5257_startdate(this, Utility.getContext(this, vars, "opcrm_cases_id", "69469E04533A46EDA7D923964AE18BCA")));
    xmlDocument.setParameter("startdate_Format", vars.getSessionValue("#AD_SqlDateFormat"));
    xmlDocument.setParameter("start_h", "9");
    xmlDocument.setParameter("start_m", "0");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      
      out.println(xmlDocument.print());
      out.close();
    }
    private void printPageButtonBegin_ButtonCC5E57D367314D2A9C01498FEF216FF4(HttpServletResponse response, VariablesSecureApp vars, String strOpcrm_Cases_ID, String strbeginButton, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process CC5E57D367314D2A9C01498FEF216FF4");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Begin_ButtonCC5E57D367314D2A9C01498FEF216FF4", discard).createXmlDocument();
      xmlDocument.setParameter("key", strOpcrm_Cases_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "RelatedCasesBF937D9A3E924A68ACCC9083BC35014C_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "CC5E57D367314D2A9C01498FEF216FF4");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("CC5E57D367314D2A9C01498FEF216FF4");
        vars.removeMessage("CC5E57D367314D2A9C01498FEF216FF4");
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
    private void printPageButtonEND_Button014175B1E891443F8B85EF51C2BF897B(HttpServletResponse response, VariablesSecureApp vars, String strOpcrm_Cases_ID, String strendButton, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 014175B1E891443F8B85EF51C2BF897B");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/END_Button014175B1E891443F8B85EF51C2BF897B", discard).createXmlDocument();
      xmlDocument.setParameter("key", strOpcrm_Cases_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "RelatedCasesBF937D9A3E924A68ACCC9083BC35014C_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "014175B1E891443F8B85EF51C2BF897B");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("014175B1E891443F8B85EF51C2BF897B");
        vars.removeMessage("014175B1E891443F8B85EF51C2BF897B");
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


    void printPageButtonSend_ButtonDBF26D81854746A19B1F2B1F0B4C0952(HttpServletResponse response, VariablesSecureApp vars, String strOpcrm_Cases_ID, String strsendButton, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process DBF26D81854746A19B1F2B1F0B4C0952");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Send_ButtonDBF26D81854746A19B1F2B1F0B4C0952", discard).createXmlDocument();
      xmlDocument.setParameter("key", strOpcrm_Cases_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "RelatedCasesBF937D9A3E924A68ACCC9083BC35014C_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "DBF26D81854746A19B1F2B1F0B4C0952");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("DBF26D81854746A19B1F2B1F0B4C0952");
        vars.removeMessage("DBF26D81854746A19B1F2B1F0B4C0952");
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
