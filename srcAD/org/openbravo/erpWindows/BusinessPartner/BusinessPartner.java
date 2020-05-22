
package org.openbravo.erpWindows.BusinessPartner;


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
public class BusinessPartner extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "123";
  private static final String tabId = "220";
  private static final int accesslevel = 3;
  private static final String moduleId = "0";
  
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
     
      if (command.contains("1873CBE0299C4EA398676C9335F9E6D1")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("1873CBE0299C4EA398676C9335F9E6D1");
        SessionInfo.setModuleId("9FF1C0E7BAEF407EA93F0C2732F6CD11");
        if (securedProcess || explicitAccess.contains("1873CBE0299C4EA398676C9335F9E6D1")) {
          classInfo.type = "P";
          classInfo.id = "1873CBE0299C4EA398676C9335F9E6D1";
        }
      }
     
      if (command.contains("DA74EEED5C7E41868BFE9C018209DAE4")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("DA74EEED5C7E41868BFE9C018209DAE4");
        SessionInfo.setModuleId("9FF1C0E7BAEF407EA93F0C2732F6CD11");
        if (securedProcess || explicitAccess.contains("DA74EEED5C7E41868BFE9C018209DAE4")) {
          classInfo.type = "P";
          classInfo.id = "DA74EEED5C7E41868BFE9C018209DAE4";
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

     } else if (vars.commandIn("BUTTONEM_Opcrm_Btn_Createopp1873CBE0299C4EA398676C9335F9E6D1")) {
        vars.setSessionValue("button1873CBE0299C4EA398676C9335F9E6D1.stremOpcrmBtnCreateopp", vars.getStringParameter("inpemOpcrmBtnCreateopp"));
        vars.setSessionValue("button1873CBE0299C4EA398676C9335F9E6D1.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button1873CBE0299C4EA398676C9335F9E6D1.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button1873CBE0299C4EA398676C9335F9E6D1.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button1873CBE0299C4EA398676C9335F9E6D1.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "1873CBE0299C4EA398676C9335F9E6D1", request.getServletPath());    
     } else if (vars.commandIn("BUTTON1873CBE0299C4EA398676C9335F9E6D1")) {
        String strC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID", "");
        String stremOpcrmBtnCreateopp = vars.getSessionValue("button1873CBE0299C4EA398676C9335F9E6D1.stremOpcrmBtnCreateopp");
        String strProcessing = vars.getSessionValue("button1873CBE0299C4EA398676C9335F9E6D1.strProcessing");
        String strOrg = vars.getSessionValue("button1873CBE0299C4EA398676C9335F9E6D1.strOrg");
        String strClient = vars.getSessionValue("button1873CBE0299C4EA398676C9335F9E6D1.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Opcrm_Btn_Createopp1873CBE0299C4EA398676C9335F9E6D1(response, vars, strC_BPartner_ID, stremOpcrmBtnCreateopp, strProcessing);
        }

     } else if (vars.commandIn("BUTTONEM_Opcrm_Btn_CreateactDA74EEED5C7E41868BFE9C018209DAE4")) {
        vars.setSessionValue("buttonDA74EEED5C7E41868BFE9C018209DAE4.stremOpcrmBtnCreateact", vars.getStringParameter("inpemOpcrmBtnCreateact"));
        vars.setSessionValue("buttonDA74EEED5C7E41868BFE9C018209DAE4.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonDA74EEED5C7E41868BFE9C018209DAE4.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonDA74EEED5C7E41868BFE9C018209DAE4.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonDA74EEED5C7E41868BFE9C018209DAE4.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "DA74EEED5C7E41868BFE9C018209DAE4", request.getServletPath());    
     } else if (vars.commandIn("BUTTONDA74EEED5C7E41868BFE9C018209DAE4")) {
        String strC_BPartner_ID = vars.getGlobalVariable("inpcBpartnerId", windowId + "|C_BPartner_ID", "");
        String stremOpcrmBtnCreateact = vars.getSessionValue("buttonDA74EEED5C7E41868BFE9C018209DAE4.stremOpcrmBtnCreateact");
        String strProcessing = vars.getSessionValue("buttonDA74EEED5C7E41868BFE9C018209DAE4.strProcessing");
        String strOrg = vars.getSessionValue("buttonDA74EEED5C7E41868BFE9C018209DAE4.strOrg");
        String strClient = vars.getSessionValue("buttonDA74EEED5C7E41868BFE9C018209DAE4.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Opcrm_Btn_CreateactDA74EEED5C7E41868BFE9C018209DAE4(response, vars, strC_BPartner_ID, stremOpcrmBtnCreateact, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONEM_Opcrm_Btn_Createopp1873CBE0299C4EA398676C9335F9E6D1")) {
        String strC_BPartner_ID = vars.getGlobalVariable("inpKey", windowId + "|C_BPartner_ID", "");
        String stremOpcrmBtnCreateopp = vars.getStringParameter("inpemOpcrmBtnCreateopp");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "1873CBE0299C4EA398676C9335F9E6D1", (("C_BPartner_ID".equalsIgnoreCase("AD_Language"))?"0":strC_BPartner_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
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
    } else if (vars.commandIn("SAVE_BUTTONEM_Opcrm_Btn_CreateactDA74EEED5C7E41868BFE9C018209DAE4")) {
        String strC_BPartner_ID = vars.getGlobalVariable("inpKey", windowId + "|C_BPartner_ID", "");
        String stremOpcrmBtnCreateact = vars.getStringParameter("inpemOpcrmBtnCreateact");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "DA74EEED5C7E41868BFE9C018209DAE4", (("C_BPartner_ID".equalsIgnoreCase("AD_Language"))?"0":strC_BPartner_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          String strsubject = vars.getStringParameter("inpsubject");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "subject", strsubject, vars.getClient(), vars.getOrg(), vars.getUser());
String stractivityType = vars.getStringParameter("inpactivityType");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "20", "Activity_Type", stractivityType, vars.getClient(), vars.getOrg(), vars.getUser());
String strstartdate = vars.getStringParameter("inpstartdate");
PInstanceProcessData.insertPInstanceParamDate(this, pinstance, "30", "startdate", strstartdate, vars.getClient(), vars.getOrg(), vars.getUser());
String strstartH = vars.getNumericParameter("inpstartH");
PInstanceProcessData.insertPInstanceParamNumber(this, pinstance, "40", "start_h", strstartH, vars.getClient(), vars.getOrg(), vars.getUser());
String strstartM = vars.getNumericParameter("inpstartM");
PInstanceProcessData.insertPInstanceParamNumber(this, pinstance, "50", "start_m", strstartM, vars.getClient(), vars.getOrg(), vars.getUser());
String strdurationH = vars.getNumericParameter("inpdurationH");
PInstanceProcessData.insertPInstanceParamNumber(this, pinstance, "60", "duration_h", strdurationH, vars.getClient(), vars.getOrg(), vars.getUser());
String strdurationM = vars.getNumericParameter("inpdurationM");
PInstanceProcessData.insertPInstanceParamNumber(this, pinstance, "70", "duration_m", strdurationM, vars.getClient(), vars.getOrg(), vars.getUser());
String strdescription = vars.getStringParameter("inpdescription");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "80", "description", strdescription, vars.getClient(), vars.getOrg(), vars.getUser());

          
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

    private void printPageButtonEM_Opcrm_Btn_Createopp1873CBE0299C4EA398676C9335F9E6D1(HttpServletResponse response, VariablesSecureApp vars, String strC_BPartner_ID, String stremOpcrmBtnCreateopp, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 1873CBE0299C4EA398676C9335F9E6D1");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Opcrm_Btn_Createopp1873CBE0299C4EA398676C9335F9E6D1", discard).createXmlDocument();
      xmlDocument.setParameter("key", strC_BPartner_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "BusinessPartner_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "1873CBE0299C4EA398676C9335F9E6D1");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("1873CBE0299C4EA398676C9335F9E6D1");
        vars.removeMessage("1873CBE0299C4EA398676C9335F9E6D1");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    xmlDocument.setParameter("subject", "");
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
    private void printPageButtonEM_Opcrm_Btn_CreateactDA74EEED5C7E41868BFE9C018209DAE4(HttpServletResponse response, VariablesSecureApp vars, String strC_BPartner_ID, String stremOpcrmBtnCreateact, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process DA74EEED5C7E41868BFE9C018209DAE4");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Opcrm_Btn_CreateactDA74EEED5C7E41868BFE9C018209DAE4", discard).createXmlDocument();
      xmlDocument.setParameter("key", strC_BPartner_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "BusinessPartner_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "DA74EEED5C7E41868BFE9C018209DAE4");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("DA74EEED5C7E41868BFE9C018209DAE4");
        vars.removeMessage("DA74EEED5C7E41868BFE9C018209DAE4");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("subject", "");
    xmlDocument.setParameter("Activity_Type", "");
    comboTableData = new ComboTableData(vars, this, "17", "Activity_Type", "5DD1BD096384449E8E30774781EFE2B5", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, (FieldProvider) vars.getSessionObject("buttonDA74EEED5C7E41868BFE9C018209DAE4.originalParams"), comboTableData, windowId, "");
    xmlDocument.setData("reportActivity_Type", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("startdate", "");
    xmlDocument.setParameter("startdate_Format", vars.getSessionValue("#AD_SqlDateFormat"));
    xmlDocument.setParameter("start_h", "9");
    xmlDocument.setParameter("start_m", "0");
    xmlDocument.setParameter("duration_h", "1");
    xmlDocument.setParameter("duration_m", "0");
    xmlDocument.setParameter("description", "");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      
      out.println(xmlDocument.print());
      out.close();
    }



}
