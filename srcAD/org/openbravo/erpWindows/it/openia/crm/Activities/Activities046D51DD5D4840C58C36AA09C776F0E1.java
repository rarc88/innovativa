
package org.openbravo.erpWindows.it.openia.crm.Activities;


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
public class Activities046D51DD5D4840C58C36AA09C776F0E1 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "62BBB1F6FB0A4BE18266EAFBD33226C0";
  private static final String tabId = "046D51DD5D4840C58C36AA09C776F0E1";
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
     
      if (command.contains("77FC3840AB4A4814B8247BA69B484F87")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("77FC3840AB4A4814B8247BA69B484F87");
        SessionInfo.setModuleId("9FF1C0E7BAEF407EA93F0C2732F6CD11");
      }
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     
      if (command.contains("37294B1179D84E9ABCCC924AE71E1A4E")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("37294B1179D84E9ABCCC924AE71E1A4E");
        SessionInfo.setModuleId("9FF1C0E7BAEF407EA93F0C2732F6CD11");
        if (securedProcess || explicitAccess.contains("37294B1179D84E9ABCCC924AE71E1A4E")) {
          classInfo.type = "P";
          classInfo.id = "37294B1179D84E9ABCCC924AE71E1A4E";
        }
      }
     
      if (command.contains("AE95B0457DD84967B0DE6DFCF9A3BF65")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("AE95B0457DD84967B0DE6DFCF9A3BF65");
        SessionInfo.setModuleId("9FF1C0E7BAEF407EA93F0C2732F6CD11");
        if (securedProcess || explicitAccess.contains("AE95B0457DD84967B0DE6DFCF9A3BF65")) {
          classInfo.type = "P";
          classInfo.id = "AE95B0457DD84967B0DE6DFCF9A3BF65";
        }
      }
     
      if (command.contains("69AADF0AEB704D5B86A892FED02C8190")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("69AADF0AEB704D5B86A892FED02C8190");
        SessionInfo.setModuleId("9FF1C0E7BAEF407EA93F0C2732F6CD11");
        if (securedProcess || explicitAccess.contains("69AADF0AEB704D5B86A892FED02C8190")) {
          classInfo.type = "P";
          classInfo.id = "69AADF0AEB704D5B86A892FED02C8190";
        }
      }
     
      if (command.contains("AD9E33FEC65145B38F6AFDB3C5A4E55F")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("AD9E33FEC65145B38F6AFDB3C5A4E55F");
        SessionInfo.setModuleId("9FF1C0E7BAEF407EA93F0C2732F6CD11");
        if (securedProcess || explicitAccess.contains("AD9E33FEC65145B38F6AFDB3C5A4E55F")) {
          classInfo.type = "P";
          classInfo.id = "AD9E33FEC65145B38F6AFDB3C5A4E55F";
        }
      }
     

     
      if (explicitAccess.contains("77FC3840AB4A4814B8247BA69B484F87") || (securedProcess && command.contains("77FC3840AB4A4814B8247BA69B484F87"))) {
        classInfo.type = "P";
        classInfo.id = "77FC3840AB4A4814B8247BA69B484F87";
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

     } else if (vars.commandIn("BUTTONADD_Users37294B1179D84E9ABCCC924AE71E1A4E")) {
        vars.setSessionValue("button37294B1179D84E9ABCCC924AE71E1A4E.straddUsers", vars.getStringParameter("inpaddUsers"));
        vars.setSessionValue("button37294B1179D84E9ABCCC924AE71E1A4E.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button37294B1179D84E9ABCCC924AE71E1A4E.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button37294B1179D84E9ABCCC924AE71E1A4E.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button37294B1179D84E9ABCCC924AE71E1A4E.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "37294B1179D84E9ABCCC924AE71E1A4E", request.getServletPath());    
     } else if (vars.commandIn("BUTTON37294B1179D84E9ABCCC924AE71E1A4E")) {
        String strOpcrm_Activity_ID = vars.getGlobalVariable("inpopcrmActivityId", windowId + "|Opcrm_Activity_ID", "");
        String straddUsers = vars.getSessionValue("button37294B1179D84E9ABCCC924AE71E1A4E.straddUsers");
        String strProcessing = vars.getSessionValue("button37294B1179D84E9ABCCC924AE71E1A4E.strProcessing");
        String strOrg = vars.getSessionValue("button37294B1179D84E9ABCCC924AE71E1A4E.strOrg");
        String strClient = vars.getSessionValue("button37294B1179D84E9ABCCC924AE71E1A4E.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonADD_Users37294B1179D84E9ABCCC924AE71E1A4E(response, vars, strOpcrm_Activity_ID, straddUsers, strProcessing);
        }

     } else if (vars.commandIn("BUTTONCreateleadbuttonAE95B0457DD84967B0DE6DFCF9A3BF65")) {
        vars.setSessionValue("buttonAE95B0457DD84967B0DE6DFCF9A3BF65.strcreateleadbutton", vars.getStringParameter("inpcreateleadbutton"));
        vars.setSessionValue("buttonAE95B0457DD84967B0DE6DFCF9A3BF65.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonAE95B0457DD84967B0DE6DFCF9A3BF65.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonAE95B0457DD84967B0DE6DFCF9A3BF65.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonAE95B0457DD84967B0DE6DFCF9A3BF65.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "AE95B0457DD84967B0DE6DFCF9A3BF65", request.getServletPath());    
     } else if (vars.commandIn("BUTTONAE95B0457DD84967B0DE6DFCF9A3BF65")) {
        String strOpcrm_Activity_ID = vars.getGlobalVariable("inpopcrmActivityId", windowId + "|Opcrm_Activity_ID", "");
        String strcreateleadbutton = vars.getSessionValue("buttonAE95B0457DD84967B0DE6DFCF9A3BF65.strcreateleadbutton");
        String strProcessing = vars.getSessionValue("buttonAE95B0457DD84967B0DE6DFCF9A3BF65.strProcessing");
        String strOrg = vars.getSessionValue("buttonAE95B0457DD84967B0DE6DFCF9A3BF65.strOrg");
        String strClient = vars.getSessionValue("buttonAE95B0457DD84967B0DE6DFCF9A3BF65.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonCreateleadbuttonAE95B0457DD84967B0DE6DFCF9A3BF65(response, vars, strOpcrm_Activity_ID, strcreateleadbutton, strProcessing);
        }

     } else if (vars.commandIn("BUTTONCreatecasebtn69AADF0AEB704D5B86A892FED02C8190")) {
        vars.setSessionValue("button69AADF0AEB704D5B86A892FED02C8190.strcreatecasebtn", vars.getStringParameter("inpcreatecasebtn"));
        vars.setSessionValue("button69AADF0AEB704D5B86A892FED02C8190.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button69AADF0AEB704D5B86A892FED02C8190.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button69AADF0AEB704D5B86A892FED02C8190.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button69AADF0AEB704D5B86A892FED02C8190.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "69AADF0AEB704D5B86A892FED02C8190", request.getServletPath());    
     } else if (vars.commandIn("BUTTON69AADF0AEB704D5B86A892FED02C8190")) {
        String strOpcrm_Activity_ID = vars.getGlobalVariable("inpopcrmActivityId", windowId + "|Opcrm_Activity_ID", "");
        String strcreatecasebtn = vars.getSessionValue("button69AADF0AEB704D5B86A892FED02C8190.strcreatecasebtn");
        String strProcessing = vars.getSessionValue("button69AADF0AEB704D5B86A892FED02C8190.strProcessing");
        String strOrg = vars.getSessionValue("button69AADF0AEB704D5B86A892FED02C8190.strOrg");
        String strClient = vars.getSessionValue("button69AADF0AEB704D5B86A892FED02C8190.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonCreatecasebtn69AADF0AEB704D5B86A892FED02C8190(response, vars, strOpcrm_Activity_ID, strcreatecasebtn, strProcessing);
        }

     } else if (vars.commandIn("BUTTONCreateopportbtnAD9E33FEC65145B38F6AFDB3C5A4E55F")) {
        vars.setSessionValue("buttonAD9E33FEC65145B38F6AFDB3C5A4E55F.strcreateopportbtn", vars.getStringParameter("inpcreateopportbtn"));
        vars.setSessionValue("buttonAD9E33FEC65145B38F6AFDB3C5A4E55F.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonAD9E33FEC65145B38F6AFDB3C5A4E55F.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonAD9E33FEC65145B38F6AFDB3C5A4E55F.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonAD9E33FEC65145B38F6AFDB3C5A4E55F.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "AD9E33FEC65145B38F6AFDB3C5A4E55F", request.getServletPath());    
     } else if (vars.commandIn("BUTTONAD9E33FEC65145B38F6AFDB3C5A4E55F")) {
        String strOpcrm_Activity_ID = vars.getGlobalVariable("inpopcrmActivityId", windowId + "|Opcrm_Activity_ID", "");
        String strcreateopportbtn = vars.getSessionValue("buttonAD9E33FEC65145B38F6AFDB3C5A4E55F.strcreateopportbtn");
        String strProcessing = vars.getSessionValue("buttonAD9E33FEC65145B38F6AFDB3C5A4E55F.strProcessing");
        String strOrg = vars.getSessionValue("buttonAD9E33FEC65145B38F6AFDB3C5A4E55F.strOrg");
        String strClient = vars.getSessionValue("buttonAD9E33FEC65145B38F6AFDB3C5A4E55F.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonCreateopportbtnAD9E33FEC65145B38F6AFDB3C5A4E55F(response, vars, strOpcrm_Activity_ID, strcreateopportbtn, strProcessing);
        }

    } else if (vars.commandIn("BUTTONInvitebutton77FC3840AB4A4814B8247BA69B484F87")) {
        vars.setSessionValue("button77FC3840AB4A4814B8247BA69B484F87.strinvitebutton", vars.getStringParameter("inpinvitebutton"));
        vars.setSessionValue("button77FC3840AB4A4814B8247BA69B484F87.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button77FC3840AB4A4814B8247BA69B484F87.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button77FC3840AB4A4814B8247BA69B484F87.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button77FC3840AB4A4814B8247BA69B484F87.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "77FC3840AB4A4814B8247BA69B484F87", request.getServletPath());
      } else if (vars.commandIn("BUTTON77FC3840AB4A4814B8247BA69B484F87")) {
        String strOpcrm_Activity_ID = vars.getGlobalVariable("inpopcrmActivityId", windowId + "|Opcrm_Activity_ID", "");
        String strinvitebutton = vars.getSessionValue("button77FC3840AB4A4814B8247BA69B484F87.strinvitebutton");
        String strProcessing = vars.getSessionValue("button77FC3840AB4A4814B8247BA69B484F87.strProcessing");
        String strOrg = vars.getSessionValue("button77FC3840AB4A4814B8247BA69B484F87.strOrg");
        String strClient = vars.getSessionValue("button77FC3840AB4A4814B8247BA69B484F87.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonInvitebutton77FC3840AB4A4814B8247BA69B484F87(response, vars, strOpcrm_Activity_ID, strinvitebutton, strProcessing);
        }

    } else if (vars.commandIn("SAVE_BUTTONADD_Users37294B1179D84E9ABCCC924AE71E1A4E")) {
        String strOpcrm_Activity_ID = vars.getGlobalVariable("inpKey", windowId + "|Opcrm_Activity_ID", "");
        String straddUsers = vars.getStringParameter("inpaddUsers");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "37294B1179D84E9ABCCC924AE71E1A4E", (("Opcrm_Activity_ID".equalsIgnoreCase("AD_Language"))?"0":strOpcrm_Activity_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
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
    } else if (vars.commandIn("SAVE_BUTTONCreateleadbuttonAE95B0457DD84967B0DE6DFCF9A3BF65")) {
        String strOpcrm_Activity_ID = vars.getGlobalVariable("inpKey", windowId + "|Opcrm_Activity_ID", "");
        String strcreateleadbutton = vars.getStringParameter("inpcreateleadbutton");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "AE95B0457DD84967B0DE6DFCF9A3BF65", (("Opcrm_Activity_ID".equalsIgnoreCase("AD_Language"))?"0":strOpcrm_Activity_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          String strfirstname = vars.getStringParameter("inpfirstname");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "firstname", strfirstname, vars.getClient(), vars.getOrg(), vars.getUser());
String strlastname = vars.getStringParameter("inplastname");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "20", "lastname", strlastname, vars.getClient(), vars.getOrg(), vars.getUser());
String strcommercialname = vars.getStringParameter("inpcommercialname");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "30", "Commercialname", strcommercialname, vars.getClient(), vars.getOrg(), vars.getUser());
String stremail = vars.getStringParameter("inpemail");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "40", "email", stremail, vars.getClient(), vars.getOrg(), vars.getUser());
String strtelephone = vars.getStringParameter("inptelephone");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "50", "telephone", strtelephone, vars.getClient(), vars.getOrg(), vars.getUser());
String strcelphone = vars.getStringParameter("inpcelphone");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "60", "celphone", strcelphone, vars.getClient(), vars.getOrg(), vars.getUser());

          
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
    } else if (vars.commandIn("SAVE_BUTTONCreatecasebtn69AADF0AEB704D5B86A892FED02C8190")) {
        String strOpcrm_Activity_ID = vars.getGlobalVariable("inpKey", windowId + "|Opcrm_Activity_ID", "");
        String strcreatecasebtn = vars.getStringParameter("inpcreatecasebtn");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "69AADF0AEB704D5B86A892FED02C8190", (("Opcrm_Activity_ID".equalsIgnoreCase("AD_Language"))?"0":strOpcrm_Activity_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          String strsubject = vars.getStringParameter("inpsubject");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "subject", strsubject, vars.getClient(), vars.getOrg(), vars.getUser());
String strdeadline = vars.getStringParameter("inpdeadline");
PInstanceProcessData.insertPInstanceParamDate(this, pinstance, "20", "deadline", strdeadline, vars.getClient(), vars.getOrg(), vars.getUser());

          
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
    } else if (vars.commandIn("SAVE_BUTTONCreateopportbtnAD9E33FEC65145B38F6AFDB3C5A4E55F")) {
        String strOpcrm_Activity_ID = vars.getGlobalVariable("inpKey", windowId + "|Opcrm_Activity_ID", "");
        String strcreateopportbtn = vars.getStringParameter("inpcreateopportbtn");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "AD9E33FEC65145B38F6AFDB3C5A4E55F", (("Opcrm_Activity_ID".equalsIgnoreCase("AD_Language"))?"0":strOpcrm_Activity_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
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

    } else if (vars.commandIn("SAVE_BUTTONInvitebutton77FC3840AB4A4814B8247BA69B484F87")) {
        String strOpcrm_Activity_ID = vars.getGlobalVariable("inpKey", windowId + "|Opcrm_Activity_ID", "");
        
        ProcessBundle pb = new ProcessBundle("77FC3840AB4A4814B8247BA69B484F87", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("Opcrm_Activity_ID", strOpcrm_Activity_ID);
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

    private void printPageButtonADD_Users37294B1179D84E9ABCCC924AE71E1A4E(HttpServletResponse response, VariablesSecureApp vars, String strOpcrm_Activity_ID, String straddUsers, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 37294B1179D84E9ABCCC924AE71E1A4E");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ADD_Users37294B1179D84E9ABCCC924AE71E1A4E", discard).createXmlDocument();
      xmlDocument.setParameter("key", strOpcrm_Activity_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Activities046D51DD5D4840C58C36AA09C776F0E1_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "37294B1179D84E9ABCCC924AE71E1A4E");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("37294B1179D84E9ABCCC924AE71E1A4E");
        vars.removeMessage("37294B1179D84E9ABCCC924AE71E1A4E");
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
    Utility.fillSQLParameters(this, vars, (FieldProvider) vars.getSessionObject("button37294B1179D84E9ABCCC924AE71E1A4E.originalParams"), comboTableData, windowId, "");
    xmlDocument.setData("reportad_role_id", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      
      out.println(xmlDocument.print());
      out.close();
    }
    private void printPageButtonCreateleadbuttonAE95B0457DD84967B0DE6DFCF9A3BF65(HttpServletResponse response, VariablesSecureApp vars, String strOpcrm_Activity_ID, String strcreateleadbutton, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process AE95B0457DD84967B0DE6DFCF9A3BF65");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/CreateleadbuttonAE95B0457DD84967B0DE6DFCF9A3BF65", discard).createXmlDocument();
      xmlDocument.setParameter("key", strOpcrm_Activity_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Activities046D51DD5D4840C58C36AA09C776F0E1_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "AE95B0457DD84967B0DE6DFCF9A3BF65");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("AE95B0457DD84967B0DE6DFCF9A3BF65");
        vars.removeMessage("AE95B0457DD84967B0DE6DFCF9A3BF65");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    xmlDocument.setParameter("firstname", "");
    xmlDocument.setParameter("lastname", "");
    xmlDocument.setParameter("Commercialname", "");
    xmlDocument.setParameter("email", "");
    xmlDocument.setParameter("telephone", "");
    xmlDocument.setParameter("celphone", "");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      
      out.println(xmlDocument.print());
      out.close();
    }
    private void printPageButtonCreatecasebtn69AADF0AEB704D5B86A892FED02C8190(HttpServletResponse response, VariablesSecureApp vars, String strOpcrm_Activity_ID, String strcreatecasebtn, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 69AADF0AEB704D5B86A892FED02C8190");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Createcasebtn69AADF0AEB704D5B86A892FED02C8190", discard).createXmlDocument();
      xmlDocument.setParameter("key", strOpcrm_Activity_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Activities046D51DD5D4840C58C36AA09C776F0E1_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "69AADF0AEB704D5B86A892FED02C8190");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("69AADF0AEB704D5B86A892FED02C8190");
        vars.removeMessage("69AADF0AEB704D5B86A892FED02C8190");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    xmlDocument.setParameter("subject", Activities046D51DD5D4840C58C36AA09C776F0E1Data.selectActP69AADF0AEB704D5B86A892FED02C8190_subject(this, Utility.getContext(this, vars, "opcrm_activity_id", "62BBB1F6FB0A4BE18266EAFBD33226C0")));
    xmlDocument.setParameter("deadline", "");
    xmlDocument.setParameter("deadline_Format", vars.getSessionValue("#AD_SqlDateFormat"));
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      
      out.println(xmlDocument.print());
      out.close();
    }
    private void printPageButtonCreateopportbtnAD9E33FEC65145B38F6AFDB3C5A4E55F(HttpServletResponse response, VariablesSecureApp vars, String strOpcrm_Activity_ID, String strcreateopportbtn, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process AD9E33FEC65145B38F6AFDB3C5A4E55F");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/CreateopportbtnAD9E33FEC65145B38F6AFDB3C5A4E55F", discard).createXmlDocument();
      xmlDocument.setParameter("key", strOpcrm_Activity_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Activities046D51DD5D4840C58C36AA09C776F0E1_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "AD9E33FEC65145B38F6AFDB3C5A4E55F");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("AD9E33FEC65145B38F6AFDB3C5A4E55F");
        vars.removeMessage("AD9E33FEC65145B38F6AFDB3C5A4E55F");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    xmlDocument.setParameter("subject", Activities046D51DD5D4840C58C36AA09C776F0E1Data.selectActPAD9E33FEC65145B38F6AFDB3C5A4E55F_subject(this, Utility.getContext(this, vars, "opcrm_activity_id", "62BBB1F6FB0A4BE18266EAFBD33226C0")));
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


    void printPageButtonInvitebutton77FC3840AB4A4814B8247BA69B484F87(HttpServletResponse response, VariablesSecureApp vars, String strOpcrm_Activity_ID, String strinvitebutton, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 77FC3840AB4A4814B8247BA69B484F87");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Invitebutton77FC3840AB4A4814B8247BA69B484F87", discard).createXmlDocument();
      xmlDocument.setParameter("key", strOpcrm_Activity_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Activities046D51DD5D4840C58C36AA09C776F0E1_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "77FC3840AB4A4814B8247BA69B484F87");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("77FC3840AB4A4814B8247BA69B484F87");
        vars.removeMessage("77FC3840AB4A4814B8247BA69B484F87");
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
