
package org.openbravo.erpWindows.ec.com.sidesoft.custom.payments.partialpayment.BatchTransferPayments;


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
public class BatchTransferPayments8F6A112677B54C6E9DE2B4AE1717D17D extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "00E058D512D048EF9AD984A924141680";
  private static final String tabId = "8F6A112677B54C6E9DE2B4AE1717D17D";
  private static final int accesslevel = 3;
  private static final String moduleId = "577639B19CD34C309EFE74B0C992133A";
  
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
     
      if (command.contains("EF5BF59C53944CB6BBE5A6A4CACE7926")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("EF5BF59C53944CB6BBE5A6A4CACE7926");
        SessionInfo.setModuleId("577639B19CD34C309EFE74B0C992133A");
      }
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     
      if (command.contains("147B48EB662046E29B1F3F867556898F")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("147B48EB662046E29B1F3F867556898F");
        SessionInfo.setModuleId("577639B19CD34C309EFE74B0C992133A");
        if (securedProcess || explicitAccess.contains("147B48EB662046E29B1F3F867556898F")) {
          classInfo.type = "P";
          classInfo.id = "147B48EB662046E29B1F3F867556898F";
        }
      }
     
      if (command.contains("8597AA01967B4882ACA8929A0172C7E5")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("8597AA01967B4882ACA8929A0172C7E5");
        SessionInfo.setModuleId("34CF32D8AE6149139DA634D49E22994F");
        if (securedProcess || explicitAccess.contains("8597AA01967B4882ACA8929A0172C7E5")) {
          classInfo.type = "P";
          classInfo.id = "8597AA01967B4882ACA8929A0172C7E5";
        }
      }
     
      if (command.contains("12FEA9914A6C418B8D277CCCAB27AFBA")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("12FEA9914A6C418B8D277CCCAB27AFBA");
        SessionInfo.setModuleId("577639B19CD34C309EFE74B0C992133A");
        if (securedProcess || explicitAccess.contains("12FEA9914A6C418B8D277CCCAB27AFBA")) {
          classInfo.type = "P";
          classInfo.id = "12FEA9914A6C418B8D277CCCAB27AFBA";
        }
      }
     
      if (command.contains("1D6DFFA71DD9419F8657F6EA27180BAA")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("1D6DFFA71DD9419F8657F6EA27180BAA");
        SessionInfo.setModuleId("34CF32D8AE6149139DA634D49E22994F");
        if (securedProcess || explicitAccess.contains("1D6DFFA71DD9419F8657F6EA27180BAA")) {
          classInfo.type = "P";
          classInfo.id = "1D6DFFA71DD9419F8657F6EA27180BAA";
        }
      }
     

     
      if (explicitAccess.contains("EF5BF59C53944CB6BBE5A6A4CACE7926") || (securedProcess && command.contains("EF5BF59C53944CB6BBE5A6A4CACE7926"))) {
        classInfo.type = "P";
        classInfo.id = "EF5BF59C53944CB6BBE5A6A4CACE7926";
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

     } else if (vars.commandIn("BUTTONLoad_Line147B48EB662046E29B1F3F867556898F")) {
        vars.setSessionValue("button147B48EB662046E29B1F3F867556898F.strloadLine", vars.getStringParameter("inploadLine"));
        vars.setSessionValue("button147B48EB662046E29B1F3F867556898F.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button147B48EB662046E29B1F3F867556898F.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button147B48EB662046E29B1F3F867556898F.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button147B48EB662046E29B1F3F867556898F.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "147B48EB662046E29B1F3F867556898F", request.getServletPath());    
     } else if (vars.commandIn("BUTTON147B48EB662046E29B1F3F867556898F")) {
        String strSspp_Payments_ID = vars.getGlobalVariable("inpssppPaymentsId", windowId + "|Sspp_Payments_ID", "");
        String strloadLine = vars.getSessionValue("button147B48EB662046E29B1F3F867556898F.strloadLine");
        String strProcessing = vars.getSessionValue("button147B48EB662046E29B1F3F867556898F.strProcessing");
        String strOrg = vars.getSessionValue("button147B48EB662046E29B1F3F867556898F.strOrg");
        String strClient = vars.getSessionValue("button147B48EB662046E29B1F3F867556898F.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonLoad_Line147B48EB662046E29B1F3F867556898F(response, vars, strSspp_Payments_ID, strloadLine, strProcessing);
        }

     } else if (vars.commandIn("BUTTONPayment_Approval8597AA01967B4882ACA8929A0172C7E5")) {
        vars.setSessionValue("button8597AA01967B4882ACA8929A0172C7E5.strpaymentApproval", vars.getStringParameter("inppaymentApproval"));
        vars.setSessionValue("button8597AA01967B4882ACA8929A0172C7E5.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button8597AA01967B4882ACA8929A0172C7E5.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button8597AA01967B4882ACA8929A0172C7E5.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button8597AA01967B4882ACA8929A0172C7E5.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "8597AA01967B4882ACA8929A0172C7E5", request.getServletPath());    
     } else if (vars.commandIn("BUTTON8597AA01967B4882ACA8929A0172C7E5")) {
        String strSspp_Payments_ID = vars.getGlobalVariable("inpssppPaymentsId", windowId + "|Sspp_Payments_ID", "");
        String strpaymentApproval = vars.getSessionValue("button8597AA01967B4882ACA8929A0172C7E5.strpaymentApproval");
        String strProcessing = vars.getSessionValue("button8597AA01967B4882ACA8929A0172C7E5.strProcessing");
        String strOrg = vars.getSessionValue("button8597AA01967B4882ACA8929A0172C7E5.strOrg");
        String strClient = vars.getSessionValue("button8597AA01967B4882ACA8929A0172C7E5.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonPayment_Approval8597AA01967B4882ACA8929A0172C7E5(response, vars, strSspp_Payments_ID, strpaymentApproval, strProcessing);
        }

     } else if (vars.commandIn("BUTTONReactivate_Payment12FEA9914A6C418B8D277CCCAB27AFBA")) {
        vars.setSessionValue("button12FEA9914A6C418B8D277CCCAB27AFBA.strreactivatePayment", vars.getStringParameter("inpreactivatePayment"));
        vars.setSessionValue("button12FEA9914A6C418B8D277CCCAB27AFBA.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button12FEA9914A6C418B8D277CCCAB27AFBA.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button12FEA9914A6C418B8D277CCCAB27AFBA.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button12FEA9914A6C418B8D277CCCAB27AFBA.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "12FEA9914A6C418B8D277CCCAB27AFBA", request.getServletPath());    
     } else if (vars.commandIn("BUTTON12FEA9914A6C418B8D277CCCAB27AFBA")) {
        String strSspp_Payments_ID = vars.getGlobalVariable("inpssppPaymentsId", windowId + "|Sspp_Payments_ID", "");
        String strreactivatePayment = vars.getSessionValue("button12FEA9914A6C418B8D277CCCAB27AFBA.strreactivatePayment");
        String strProcessing = vars.getSessionValue("button12FEA9914A6C418B8D277CCCAB27AFBA.strProcessing");
        String strOrg = vars.getSessionValue("button12FEA9914A6C418B8D277CCCAB27AFBA.strOrg");
        String strClient = vars.getSessionValue("button12FEA9914A6C418B8D277CCCAB27AFBA.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonReactivate_Payment12FEA9914A6C418B8D277CCCAB27AFBA(response, vars, strSspp_Payments_ID, strreactivatePayment, strProcessing);
        }

     } else if (vars.commandIn("BUTTONConfirm1D6DFFA71DD9419F8657F6EA27180BAA")) {
        vars.setSessionValue("button1D6DFFA71DD9419F8657F6EA27180BAA.strconfirm", vars.getStringParameter("inpconfirm"));
        vars.setSessionValue("button1D6DFFA71DD9419F8657F6EA27180BAA.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button1D6DFFA71DD9419F8657F6EA27180BAA.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button1D6DFFA71DD9419F8657F6EA27180BAA.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button1D6DFFA71DD9419F8657F6EA27180BAA.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "1D6DFFA71DD9419F8657F6EA27180BAA", request.getServletPath());    
     } else if (vars.commandIn("BUTTON1D6DFFA71DD9419F8657F6EA27180BAA")) {
        String strSspp_Payments_ID = vars.getGlobalVariable("inpssppPaymentsId", windowId + "|Sspp_Payments_ID", "");
        String strconfirm = vars.getSessionValue("button1D6DFFA71DD9419F8657F6EA27180BAA.strconfirm");
        String strProcessing = vars.getSessionValue("button1D6DFFA71DD9419F8657F6EA27180BAA.strProcessing");
        String strOrg = vars.getSessionValue("button1D6DFFA71DD9419F8657F6EA27180BAA.strOrg");
        String strClient = vars.getSessionValue("button1D6DFFA71DD9419F8657F6EA27180BAA.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonConfirm1D6DFFA71DD9419F8657F6EA27180BAA(response, vars, strSspp_Payments_ID, strconfirm, strProcessing);
        }

    } else if (vars.commandIn("BUTTONGenerate_FileEF5BF59C53944CB6BBE5A6A4CACE7926")) {
        vars.setSessionValue("buttonEF5BF59C53944CB6BBE5A6A4CACE7926.strgenerateFile", vars.getStringParameter("inpgenerateFile"));
        vars.setSessionValue("buttonEF5BF59C53944CB6BBE5A6A4CACE7926.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonEF5BF59C53944CB6BBE5A6A4CACE7926.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonEF5BF59C53944CB6BBE5A6A4CACE7926.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonEF5BF59C53944CB6BBE5A6A4CACE7926.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "EF5BF59C53944CB6BBE5A6A4CACE7926", request.getServletPath());
      } else if (vars.commandIn("BUTTONEF5BF59C53944CB6BBE5A6A4CACE7926")) {
        String strSspp_Payments_ID = vars.getGlobalVariable("inpssppPaymentsId", windowId + "|Sspp_Payments_ID", "");
        String strgenerateFile = vars.getSessionValue("buttonEF5BF59C53944CB6BBE5A6A4CACE7926.strgenerateFile");
        String strProcessing = vars.getSessionValue("buttonEF5BF59C53944CB6BBE5A6A4CACE7926.strProcessing");
        String strOrg = vars.getSessionValue("buttonEF5BF59C53944CB6BBE5A6A4CACE7926.strOrg");
        String strClient = vars.getSessionValue("buttonEF5BF59C53944CB6BBE5A6A4CACE7926.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonGenerate_FileEF5BF59C53944CB6BBE5A6A4CACE7926(response, vars, strSspp_Payments_ID, strgenerateFile, strProcessing);
        }

    } else if (vars.commandIn("SAVE_BUTTONLoad_Line147B48EB662046E29B1F3F867556898F")) {
        String strSspp_Payments_ID = vars.getGlobalVariable("inpKey", windowId + "|Sspp_Payments_ID", "");
        String strloadLine = vars.getStringParameter("inploadLine");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "147B48EB662046E29B1F3F867556898F", (("Sspp_Payments_ID".equalsIgnoreCase("AD_Language"))?"0":strSspp_Payments_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONPayment_Approval8597AA01967B4882ACA8929A0172C7E5")) {
        String strSspp_Payments_ID = vars.getGlobalVariable("inpKey", windowId + "|Sspp_Payments_ID", "");
        String strpaymentApproval = vars.getStringParameter("inppaymentApproval");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "8597AA01967B4882ACA8929A0172C7E5", (("Sspp_Payments_ID".equalsIgnoreCase("AD_Language"))?"0":strSspp_Payments_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONReactivate_Payment12FEA9914A6C418B8D277CCCAB27AFBA")) {
        String strSspp_Payments_ID = vars.getGlobalVariable("inpKey", windowId + "|Sspp_Payments_ID", "");
        String strreactivatePayment = vars.getStringParameter("inpreactivatePayment");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "12FEA9914A6C418B8D277CCCAB27AFBA", (("Sspp_Payments_ID".equalsIgnoreCase("AD_Language"))?"0":strSspp_Payments_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONConfirm1D6DFFA71DD9419F8657F6EA27180BAA")) {
        String strSspp_Payments_ID = vars.getGlobalVariable("inpKey", windowId + "|Sspp_Payments_ID", "");
        String strconfirm = vars.getStringParameter("inpconfirm");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "1D6DFFA71DD9419F8657F6EA27180BAA", (("Sspp_Payments_ID".equalsIgnoreCase("AD_Language"))?"0":strSspp_Payments_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    } else if (vars.commandIn("SAVE_BUTTONGenerate_FileEF5BF59C53944CB6BBE5A6A4CACE7926")) {
        String strSspp_Payments_ID = vars.getGlobalVariable("inpKey", windowId + "|Sspp_Payments_ID", "");
        
        ProcessBundle pb = new ProcessBundle("EF5BF59C53944CB6BBE5A6A4CACE7926", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("Sspp_Payments_ID", strSspp_Payments_ID);
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

    private void printPageButtonLoad_Line147B48EB662046E29B1F3F867556898F(HttpServletResponse response, VariablesSecureApp vars, String strSspp_Payments_ID, String strloadLine, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 147B48EB662046E29B1F3F867556898F");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Load_Line147B48EB662046E29B1F3F867556898F", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSspp_Payments_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "BatchTransferPayments8F6A112677B54C6E9DE2B4AE1717D17D_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "147B48EB662046E29B1F3F867556898F");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("147B48EB662046E29B1F3F867556898F");
        vars.removeMessage("147B48EB662046E29B1F3F867556898F");
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
    private void printPageButtonPayment_Approval8597AA01967B4882ACA8929A0172C7E5(HttpServletResponse response, VariablesSecureApp vars, String strSspp_Payments_ID, String strpaymentApproval, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 8597AA01967B4882ACA8929A0172C7E5");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Payment_Approval8597AA01967B4882ACA8929A0172C7E5", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSspp_Payments_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "BatchTransferPayments8F6A112677B54C6E9DE2B4AE1717D17D_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "8597AA01967B4882ACA8929A0172C7E5");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("8597AA01967B4882ACA8929A0172C7E5");
        vars.removeMessage("8597AA01967B4882ACA8929A0172C7E5");
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
    private void printPageButtonReactivate_Payment12FEA9914A6C418B8D277CCCAB27AFBA(HttpServletResponse response, VariablesSecureApp vars, String strSspp_Payments_ID, String strreactivatePayment, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 12FEA9914A6C418B8D277CCCAB27AFBA");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Reactivate_Payment12FEA9914A6C418B8D277CCCAB27AFBA", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSspp_Payments_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "BatchTransferPayments8F6A112677B54C6E9DE2B4AE1717D17D_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "12FEA9914A6C418B8D277CCCAB27AFBA");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("12FEA9914A6C418B8D277CCCAB27AFBA");
        vars.removeMessage("12FEA9914A6C418B8D277CCCAB27AFBA");
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
    private void printPageButtonConfirm1D6DFFA71DD9419F8657F6EA27180BAA(HttpServletResponse response, VariablesSecureApp vars, String strSspp_Payments_ID, String strconfirm, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 1D6DFFA71DD9419F8657F6EA27180BAA");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Confirm1D6DFFA71DD9419F8657F6EA27180BAA", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSspp_Payments_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "BatchTransferPayments8F6A112677B54C6E9DE2B4AE1717D17D_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "1D6DFFA71DD9419F8657F6EA27180BAA");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("1D6DFFA71DD9419F8657F6EA27180BAA");
        vars.removeMessage("1D6DFFA71DD9419F8657F6EA27180BAA");
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


    void printPageButtonGenerate_FileEF5BF59C53944CB6BBE5A6A4CACE7926(HttpServletResponse response, VariablesSecureApp vars, String strSspp_Payments_ID, String strgenerateFile, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process EF5BF59C53944CB6BBE5A6A4CACE7926");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Generate_FileEF5BF59C53944CB6BBE5A6A4CACE7926", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSspp_Payments_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "BatchTransferPayments8F6A112677B54C6E9DE2B4AE1717D17D_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "EF5BF59C53944CB6BBE5A6A4CACE7926");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("EF5BF59C53944CB6BBE5A6A4CACE7926");
        vars.removeMessage("EF5BF59C53944CB6BBE5A6A4CACE7926");
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
