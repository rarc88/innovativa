
package org.openbravo.erpWindows.com.sidesoft.hrm.payroll.BusinessConcept;


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
public class BusinessConceptB1ACCC8868B141A29DB8904B6BA51A81 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "D0D450C8478F4586B4CDD0F71844B266";
  private static final String tabId = "B1ACCC8868B141A29DB8904B6BA51A81";
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
     
      if (command.contains("2D50426F284D4DC794BC15161CC110D4")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("2D50426F284D4DC794BC15161CC110D4");
        SessionInfo.setModuleId("169A6DDBFEB948C98F0617CE3B4CABD5");
        if (securedProcess || explicitAccess.contains("2D50426F284D4DC794BC15161CC110D4")) {
          classInfo.type = "P";
          classInfo.id = "2D50426F284D4DC794BC15161CC110D4";
        }
      }
     
      if (command.contains("D16D6A8B6D064730B366017596B5316A")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("D16D6A8B6D064730B366017596B5316A");
        SessionInfo.setModuleId("169A6DDBFEB948C98F0617CE3B4CABD5");
        if (securedProcess || explicitAccess.contains("D16D6A8B6D064730B366017596B5316A")) {
          classInfo.type = "P";
          classInfo.id = "D16D6A8B6D064730B366017596B5316A";
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

     } else if (vars.commandIn("BUTTONDeleteformula2D50426F284D4DC794BC15161CC110D4")) {
        vars.setSessionValue("button2D50426F284D4DC794BC15161CC110D4.strdeleteformula", vars.getStringParameter("inpdeleteformula"));
        vars.setSessionValue("button2D50426F284D4DC794BC15161CC110D4.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button2D50426F284D4DC794BC15161CC110D4.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button2D50426F284D4DC794BC15161CC110D4.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button2D50426F284D4DC794BC15161CC110D4.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "2D50426F284D4DC794BC15161CC110D4", request.getServletPath());    
     } else if (vars.commandIn("BUTTON2D50426F284D4DC794BC15161CC110D4")) {
        String strSspr_Concept_ID = vars.getGlobalVariable("inpssprConceptId", windowId + "|Sspr_Concept_ID", "");
        String strdeleteformula = vars.getSessionValue("button2D50426F284D4DC794BC15161CC110D4.strdeleteformula");
        String strProcessing = vars.getSessionValue("button2D50426F284D4DC794BC15161CC110D4.strProcessing");
        String strOrg = vars.getSessionValue("button2D50426F284D4DC794BC15161CC110D4.strOrg");
        String strClient = vars.getSessionValue("button2D50426F284D4DC794BC15161CC110D4.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonDeleteformula2D50426F284D4DC794BC15161CC110D4(response, vars, strSspr_Concept_ID, strdeleteformula, strProcessing);
        }

     } else if (vars.commandIn("BUTTONCreate_Concept_AmountsD16D6A8B6D064730B366017596B5316A")) {
        vars.setSessionValue("buttonD16D6A8B6D064730B366017596B5316A.strcreateConceptAmounts", vars.getStringParameter("inpcreateConceptAmounts"));
        vars.setSessionValue("buttonD16D6A8B6D064730B366017596B5316A.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonD16D6A8B6D064730B366017596B5316A.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonD16D6A8B6D064730B366017596B5316A.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonD16D6A8B6D064730B366017596B5316A.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "D16D6A8B6D064730B366017596B5316A", request.getServletPath());    
     } else if (vars.commandIn("BUTTOND16D6A8B6D064730B366017596B5316A")) {
        String strSspr_Concept_ID = vars.getGlobalVariable("inpssprConceptId", windowId + "|Sspr_Concept_ID", "");
        String strcreateConceptAmounts = vars.getSessionValue("buttonD16D6A8B6D064730B366017596B5316A.strcreateConceptAmounts");
        String strProcessing = vars.getSessionValue("buttonD16D6A8B6D064730B366017596B5316A.strProcessing");
        String strOrg = vars.getSessionValue("buttonD16D6A8B6D064730B366017596B5316A.strOrg");
        String strClient = vars.getSessionValue("buttonD16D6A8B6D064730B366017596B5316A.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonCreate_Concept_AmountsD16D6A8B6D064730B366017596B5316A(response, vars, strSspr_Concept_ID, strcreateConceptAmounts, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONDeleteformula2D50426F284D4DC794BC15161CC110D4")) {
        String strSspr_Concept_ID = vars.getGlobalVariable("inpKey", windowId + "|Sspr_Concept_ID", "");
        String strdeleteformula = vars.getStringParameter("inpdeleteformula");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "2D50426F284D4DC794BC15161CC110D4", (("Sspr_Concept_ID".equalsIgnoreCase("AD_Language"))?"0":strSspr_Concept_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONCreate_Concept_AmountsD16D6A8B6D064730B366017596B5316A")) {
        String strSspr_Concept_ID = vars.getGlobalVariable("inpKey", windowId + "|Sspr_Concept_ID", "");
        String strcreateConceptAmounts = vars.getStringParameter("inpcreateConceptAmounts");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "D16D6A8B6D064730B366017596B5316A", (("Sspr_Concept_ID".equalsIgnoreCase("AD_Language"))?"0":strSspr_Concept_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          String strstartperiod = vars.getStringParameter("inpstartperiod");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "StartPeriod", strstartperiod, vars.getClient(), vars.getOrg(), vars.getUser());
String strendperiod = vars.getStringParameter("inpendperiod");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "20", "EndPeriod", strendperiod, vars.getClient(), vars.getOrg(), vars.getUser());
String strcBpartnerId = vars.getStringParameter("inpcBpartnerId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "30", "C_BPartner_ID", strcBpartnerId, vars.getClient(), vars.getOrg(), vars.getUser());
String stramount = vars.getNumericParameter("inpamount");
PInstanceProcessData.insertPInstanceParamNumber(this, pinstance, "40", "Amount", stramount, vars.getClient(), vars.getOrg(), vars.getUser());

          
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

    private void printPageButtonDeleteformula2D50426F284D4DC794BC15161CC110D4(HttpServletResponse response, VariablesSecureApp vars, String strSspr_Concept_ID, String strdeleteformula, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 2D50426F284D4DC794BC15161CC110D4");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Deleteformula2D50426F284D4DC794BC15161CC110D4", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSspr_Concept_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "BusinessConceptB1ACCC8868B141A29DB8904B6BA51A81_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "2D50426F284D4DC794BC15161CC110D4");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("2D50426F284D4DC794BC15161CC110D4");
        vars.removeMessage("2D50426F284D4DC794BC15161CC110D4");
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
    private void printPageButtonCreate_Concept_AmountsD16D6A8B6D064730B366017596B5316A(HttpServletResponse response, VariablesSecureApp vars, String strSspr_Concept_ID, String strcreateConceptAmounts, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process D16D6A8B6D064730B366017596B5316A");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Create_Concept_AmountsD16D6A8B6D064730B366017596B5316A", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSspr_Concept_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "BusinessConceptB1ACCC8868B141A29DB8904B6BA51A81_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "D16D6A8B6D064730B366017596B5316A");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("D16D6A8B6D064730B366017596B5316A");
        vars.removeMessage("D16D6A8B6D064730B366017596B5316A");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("StartPeriod", "");
    comboTableData = new ComboTableData(vars, this, "18", "StartPeriod", "423DA51196E442C9BCAABF60EC51D7B3", "C61660C5ADB1450D986E6DD2833194DC", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, (FieldProvider) vars.getSessionObject("buttonD16D6A8B6D064730B366017596B5316A.originalParams"), comboTableData, windowId, "");
    xmlDocument.setData("reportStartPeriod", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("EndPeriod", "");
    comboTableData = new ComboTableData(vars, this, "18", "EndPeriod", "423DA51196E442C9BCAABF60EC51D7B3", "44C55EDC83864BD58E759EE52404EB26", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, (FieldProvider) vars.getSessionObject("buttonD16D6A8B6D064730B366017596B5316A.originalParams"), comboTableData, windowId, "");
    xmlDocument.setData("reportEndPeriod", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("C_BPartner_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "C_BPartner_ID", "", "BFED439FF6D049179699C526574A7D61", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, (FieldProvider) vars.getSessionObject("buttonD16D6A8B6D064730B366017596B5316A.originalParams"), comboTableData, windowId, "");
    xmlDocument.setData("reportC_BPartner_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("Amount", "0");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      
      out.println(xmlDocument.print());
      out.close();
    }



}
