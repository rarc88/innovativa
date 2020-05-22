
package org.openbravo.erpWindows.ec.com.sidesoft.custom.payroll.partialpayment.PayrollPaymentApprovalFileTransfer;


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
public class PayrollPaymentApprovalFileTransferB482F46C3BFE4A0380B72DD082D7C547 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "47357F8B41F141BE82597BA11842C7B8";
  private static final String tabId = "B482F46C3BFE4A0380B72DD082D7C547";
  private static final int accesslevel = 3;
  private static final String moduleId = "9846F7078EF4482BA6AE0813C9371571";
  
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
     
      if (command.contains("A1A4F42146B44313A85BAC9499EC15CE")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("A1A4F42146B44313A85BAC9499EC15CE");
        SessionInfo.setModuleId("9846F7078EF4482BA6AE0813C9371571");
      }
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     
      if (command.contains("148F1B720DBF46C288642D518205B626")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("148F1B720DBF46C288642D518205B626");
        SessionInfo.setModuleId("9846F7078EF4482BA6AE0813C9371571");
        if (securedProcess || explicitAccess.contains("148F1B720DBF46C288642D518205B626")) {
          classInfo.type = "P";
          classInfo.id = "148F1B720DBF46C288642D518205B626";
        }
      }
     
      if (command.contains("F499384EDA2E4DF0A26274A89DA6C77E")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("F499384EDA2E4DF0A26274A89DA6C77E");
        SessionInfo.setModuleId("9846F7078EF4482BA6AE0813C9371571");
        if (securedProcess || explicitAccess.contains("F499384EDA2E4DF0A26274A89DA6C77E")) {
          classInfo.type = "P";
          classInfo.id = "F499384EDA2E4DF0A26274A89DA6C77E";
        }
      }
     
      if (command.contains("19A9BFF89D6348009A5164B61B3DA49C")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("19A9BFF89D6348009A5164B61B3DA49C");
        SessionInfo.setModuleId("9846F7078EF4482BA6AE0813C9371571");
        if (securedProcess || explicitAccess.contains("19A9BFF89D6348009A5164B61B3DA49C")) {
          classInfo.type = "P";
          classInfo.id = "19A9BFF89D6348009A5164B61B3DA49C";
        }
      }
     
      if (command.contains("94A66E08FAF94387A49077DDDCD6E64C")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("94A66E08FAF94387A49077DDDCD6E64C");
        SessionInfo.setModuleId("9846F7078EF4482BA6AE0813C9371571");
        if (securedProcess || explicitAccess.contains("94A66E08FAF94387A49077DDDCD6E64C")) {
          classInfo.type = "P";
          classInfo.id = "94A66E08FAF94387A49077DDDCD6E64C";
        }
      }
     

     
      if (explicitAccess.contains("A1A4F42146B44313A85BAC9499EC15CE") || (securedProcess && command.contains("A1A4F42146B44313A85BAC9499EC15CE"))) {
        classInfo.type = "P";
        classInfo.id = "A1A4F42146B44313A85BAC9499EC15CE";
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

     } else if (vars.commandIn("BUTTONIncludepartners148F1B720DBF46C288642D518205B626")) {
        vars.setSessionValue("button148F1B720DBF46C288642D518205B626.strincludepartners", vars.getStringParameter("inpincludepartners"));
        vars.setSessionValue("button148F1B720DBF46C288642D518205B626.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button148F1B720DBF46C288642D518205B626.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button148F1B720DBF46C288642D518205B626.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button148F1B720DBF46C288642D518205B626.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "148F1B720DBF46C288642D518205B626", request.getServletPath());    
     } else if (vars.commandIn("BUTTON148F1B720DBF46C288642D518205B626")) {
        String strScpp_Approvalpayment_ID = vars.getGlobalVariable("inpscppApprovalpaymentId", windowId + "|Scpp_Approvalpayment_ID", "");
        String strincludepartners = vars.getSessionValue("button148F1B720DBF46C288642D518205B626.strincludepartners");
        String strProcessing = vars.getSessionValue("button148F1B720DBF46C288642D518205B626.strProcessing");
        String strOrg = vars.getSessionValue("button148F1B720DBF46C288642D518205B626.strOrg");
        String strClient = vars.getSessionValue("button148F1B720DBF46C288642D518205B626.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonIncludepartners148F1B720DBF46C288642D518205B626(response, vars, strScpp_Approvalpayment_ID, strincludepartners, strProcessing);
        }

     } else if (vars.commandIn("BUTTONReactiveF499384EDA2E4DF0A26274A89DA6C77E")) {
        vars.setSessionValue("buttonF499384EDA2E4DF0A26274A89DA6C77E.strreactive", vars.getStringParameter("inpreactive"));
        vars.setSessionValue("buttonF499384EDA2E4DF0A26274A89DA6C77E.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonF499384EDA2E4DF0A26274A89DA6C77E.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonF499384EDA2E4DF0A26274A89DA6C77E.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonF499384EDA2E4DF0A26274A89DA6C77E.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "F499384EDA2E4DF0A26274A89DA6C77E", request.getServletPath());    
     } else if (vars.commandIn("BUTTONF499384EDA2E4DF0A26274A89DA6C77E")) {
        String strScpp_Approvalpayment_ID = vars.getGlobalVariable("inpscppApprovalpaymentId", windowId + "|Scpp_Approvalpayment_ID", "");
        String strreactive = vars.getSessionValue("buttonF499384EDA2E4DF0A26274A89DA6C77E.strreactive");
        String strProcessing = vars.getSessionValue("buttonF499384EDA2E4DF0A26274A89DA6C77E.strProcessing");
        String strOrg = vars.getSessionValue("buttonF499384EDA2E4DF0A26274A89DA6C77E.strOrg");
        String strClient = vars.getSessionValue("buttonF499384EDA2E4DF0A26274A89DA6C77E.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonReactiveF499384EDA2E4DF0A26274A89DA6C77E(response, vars, strScpp_Approvalpayment_ID, strreactive, strProcessing);
        }

     } else if (vars.commandIn("BUTTONApprove19A9BFF89D6348009A5164B61B3DA49C")) {
        vars.setSessionValue("button19A9BFF89D6348009A5164B61B3DA49C.strapprove", vars.getStringParameter("inpapprove"));
        vars.setSessionValue("button19A9BFF89D6348009A5164B61B3DA49C.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button19A9BFF89D6348009A5164B61B3DA49C.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button19A9BFF89D6348009A5164B61B3DA49C.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button19A9BFF89D6348009A5164B61B3DA49C.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "19A9BFF89D6348009A5164B61B3DA49C", request.getServletPath());    
     } else if (vars.commandIn("BUTTON19A9BFF89D6348009A5164B61B3DA49C")) {
        String strScpp_Approvalpayment_ID = vars.getGlobalVariable("inpscppApprovalpaymentId", windowId + "|Scpp_Approvalpayment_ID", "");
        String strapprove = vars.getSessionValue("button19A9BFF89D6348009A5164B61B3DA49C.strapprove");
        String strProcessing = vars.getSessionValue("button19A9BFF89D6348009A5164B61B3DA49C.strProcessing");
        String strOrg = vars.getSessionValue("button19A9BFF89D6348009A5164B61B3DA49C.strOrg");
        String strClient = vars.getSessionValue("button19A9BFF89D6348009A5164B61B3DA49C.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonApprove19A9BFF89D6348009A5164B61B3DA49C(response, vars, strScpp_Approvalpayment_ID, strapprove, strProcessing);
        }

     } else if (vars.commandIn("BUTTONConfirmpaymet94A66E08FAF94387A49077DDDCD6E64C")) {
        vars.setSessionValue("button94A66E08FAF94387A49077DDDCD6E64C.strconfirmpaymet", vars.getStringParameter("inpconfirmpaymet"));
        vars.setSessionValue("button94A66E08FAF94387A49077DDDCD6E64C.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button94A66E08FAF94387A49077DDDCD6E64C.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button94A66E08FAF94387A49077DDDCD6E64C.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button94A66E08FAF94387A49077DDDCD6E64C.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "94A66E08FAF94387A49077DDDCD6E64C", request.getServletPath());    
     } else if (vars.commandIn("BUTTON94A66E08FAF94387A49077DDDCD6E64C")) {
        String strScpp_Approvalpayment_ID = vars.getGlobalVariable("inpscppApprovalpaymentId", windowId + "|Scpp_Approvalpayment_ID", "");
        String strconfirmpaymet = vars.getSessionValue("button94A66E08FAF94387A49077DDDCD6E64C.strconfirmpaymet");
        String strProcessing = vars.getSessionValue("button94A66E08FAF94387A49077DDDCD6E64C.strProcessing");
        String strOrg = vars.getSessionValue("button94A66E08FAF94387A49077DDDCD6E64C.strOrg");
        String strClient = vars.getSessionValue("button94A66E08FAF94387A49077DDDCD6E64C.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonConfirmpaymet94A66E08FAF94387A49077DDDCD6E64C(response, vars, strScpp_Approvalpayment_ID, strconfirmpaymet, strProcessing);
        }

    } else if (vars.commandIn("BUTTONGeneratefileA1A4F42146B44313A85BAC9499EC15CE")) {
        vars.setSessionValue("buttonA1A4F42146B44313A85BAC9499EC15CE.strgeneratefile", vars.getStringParameter("inpgeneratefile"));
        vars.setSessionValue("buttonA1A4F42146B44313A85BAC9499EC15CE.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonA1A4F42146B44313A85BAC9499EC15CE.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonA1A4F42146B44313A85BAC9499EC15CE.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonA1A4F42146B44313A85BAC9499EC15CE.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "A1A4F42146B44313A85BAC9499EC15CE", request.getServletPath());
      } else if (vars.commandIn("BUTTONA1A4F42146B44313A85BAC9499EC15CE")) {
        String strScpp_Approvalpayment_ID = vars.getGlobalVariable("inpscppApprovalpaymentId", windowId + "|Scpp_Approvalpayment_ID", "");
        String strgeneratefile = vars.getSessionValue("buttonA1A4F42146B44313A85BAC9499EC15CE.strgeneratefile");
        String strProcessing = vars.getSessionValue("buttonA1A4F42146B44313A85BAC9499EC15CE.strProcessing");
        String strOrg = vars.getSessionValue("buttonA1A4F42146B44313A85BAC9499EC15CE.strOrg");
        String strClient = vars.getSessionValue("buttonA1A4F42146B44313A85BAC9499EC15CE.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonGeneratefileA1A4F42146B44313A85BAC9499EC15CE(response, vars, strScpp_Approvalpayment_ID, strgeneratefile, strProcessing);
        }

    } else if (vars.commandIn("SAVE_BUTTONIncludepartners148F1B720DBF46C288642D518205B626")) {
        String strScpp_Approvalpayment_ID = vars.getGlobalVariable("inpKey", windowId + "|Scpp_Approvalpayment_ID", "");
        String strincludepartners = vars.getStringParameter("inpincludepartners");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "148F1B720DBF46C288642D518205B626", (("Scpp_Approvalpayment_ID".equalsIgnoreCase("AD_Language"))?"0":strScpp_Approvalpayment_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONReactiveF499384EDA2E4DF0A26274A89DA6C77E")) {
        String strScpp_Approvalpayment_ID = vars.getGlobalVariable("inpKey", windowId + "|Scpp_Approvalpayment_ID", "");
        String strreactive = vars.getStringParameter("inpreactive");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "F499384EDA2E4DF0A26274A89DA6C77E", (("Scpp_Approvalpayment_ID".equalsIgnoreCase("AD_Language"))?"0":strScpp_Approvalpayment_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONApprove19A9BFF89D6348009A5164B61B3DA49C")) {
        String strScpp_Approvalpayment_ID = vars.getGlobalVariable("inpKey", windowId + "|Scpp_Approvalpayment_ID", "");
        String strapprove = vars.getStringParameter("inpapprove");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "19A9BFF89D6348009A5164B61B3DA49C", (("Scpp_Approvalpayment_ID".equalsIgnoreCase("AD_Language"))?"0":strScpp_Approvalpayment_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONConfirmpaymet94A66E08FAF94387A49077DDDCD6E64C")) {
        String strScpp_Approvalpayment_ID = vars.getGlobalVariable("inpKey", windowId + "|Scpp_Approvalpayment_ID", "");
        String strconfirmpaymet = vars.getStringParameter("inpconfirmpaymet");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "94A66E08FAF94387A49077DDDCD6E64C", (("Scpp_Approvalpayment_ID".equalsIgnoreCase("AD_Language"))?"0":strScpp_Approvalpayment_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    } else if (vars.commandIn("SAVE_BUTTONGeneratefileA1A4F42146B44313A85BAC9499EC15CE")) {
        String strScpp_Approvalpayment_ID = vars.getGlobalVariable("inpKey", windowId + "|Scpp_Approvalpayment_ID", "");
        
        ProcessBundle pb = new ProcessBundle("A1A4F42146B44313A85BAC9499EC15CE", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("Scpp_Approvalpayment_ID", strScpp_Approvalpayment_ID);
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

    private void printPageButtonIncludepartners148F1B720DBF46C288642D518205B626(HttpServletResponse response, VariablesSecureApp vars, String strScpp_Approvalpayment_ID, String strincludepartners, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 148F1B720DBF46C288642D518205B626");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Includepartners148F1B720DBF46C288642D518205B626", discard).createXmlDocument();
      xmlDocument.setParameter("key", strScpp_Approvalpayment_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "PayrollPaymentApprovalFileTransferB482F46C3BFE4A0380B72DD082D7C547_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "148F1B720DBF46C288642D518205B626");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("148F1B720DBF46C288642D518205B626");
        vars.removeMessage("148F1B720DBF46C288642D518205B626");
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
    private void printPageButtonReactiveF499384EDA2E4DF0A26274A89DA6C77E(HttpServletResponse response, VariablesSecureApp vars, String strScpp_Approvalpayment_ID, String strreactive, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process F499384EDA2E4DF0A26274A89DA6C77E");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ReactiveF499384EDA2E4DF0A26274A89DA6C77E", discard).createXmlDocument();
      xmlDocument.setParameter("key", strScpp_Approvalpayment_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "PayrollPaymentApprovalFileTransferB482F46C3BFE4A0380B72DD082D7C547_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "F499384EDA2E4DF0A26274A89DA6C77E");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("F499384EDA2E4DF0A26274A89DA6C77E");
        vars.removeMessage("F499384EDA2E4DF0A26274A89DA6C77E");
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
    private void printPageButtonApprove19A9BFF89D6348009A5164B61B3DA49C(HttpServletResponse response, VariablesSecureApp vars, String strScpp_Approvalpayment_ID, String strapprove, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 19A9BFF89D6348009A5164B61B3DA49C");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Approve19A9BFF89D6348009A5164B61B3DA49C", discard).createXmlDocument();
      xmlDocument.setParameter("key", strScpp_Approvalpayment_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "PayrollPaymentApprovalFileTransferB482F46C3BFE4A0380B72DD082D7C547_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "19A9BFF89D6348009A5164B61B3DA49C");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("19A9BFF89D6348009A5164B61B3DA49C");
        vars.removeMessage("19A9BFF89D6348009A5164B61B3DA49C");
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
    private void printPageButtonConfirmpaymet94A66E08FAF94387A49077DDDCD6E64C(HttpServletResponse response, VariablesSecureApp vars, String strScpp_Approvalpayment_ID, String strconfirmpaymet, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 94A66E08FAF94387A49077DDDCD6E64C");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Confirmpaymet94A66E08FAF94387A49077DDDCD6E64C", discard).createXmlDocument();
      xmlDocument.setParameter("key", strScpp_Approvalpayment_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "PayrollPaymentApprovalFileTransferB482F46C3BFE4A0380B72DD082D7C547_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "94A66E08FAF94387A49077DDDCD6E64C");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("94A66E08FAF94387A49077DDDCD6E64C");
        vars.removeMessage("94A66E08FAF94387A49077DDDCD6E64C");
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


    void printPageButtonGeneratefileA1A4F42146B44313A85BAC9499EC15CE(HttpServletResponse response, VariablesSecureApp vars, String strScpp_Approvalpayment_ID, String strgeneratefile, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process A1A4F42146B44313A85BAC9499EC15CE");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/GeneratefileA1A4F42146B44313A85BAC9499EC15CE", discard).createXmlDocument();
      xmlDocument.setParameter("key", strScpp_Approvalpayment_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "PayrollPaymentApprovalFileTransferB482F46C3BFE4A0380B72DD082D7C547_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "A1A4F42146B44313A85BAC9499EC15CE");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("A1A4F42146B44313A85BAC9499EC15CE");
        vars.removeMessage("A1A4F42146B44313A85BAC9499EC15CE");
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
