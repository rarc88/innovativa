
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
public class RelatedOpportunities11D68F1D801149DD88A65065972555CE extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "123";
  private static final String tabId = "11D68F1D801149DD88A65065972555CE";
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
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     
      if (command.contains("5B560F0BDD824D5A9DCAFE653D04FEC3")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("5B560F0BDD824D5A9DCAFE653D04FEC3");
        SessionInfo.setModuleId("9FF1C0E7BAEF407EA93F0C2732F6CD11");
        if (securedProcess || explicitAccess.contains("5B560F0BDD824D5A9DCAFE653D04FEC3")) {
          classInfo.type = "P";
          classInfo.id = "5B560F0BDD824D5A9DCAFE653D04FEC3";
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

     } else if (vars.commandIn("BUTTONCreate_Activity5B560F0BDD824D5A9DCAFE653D04FEC3")) {
        vars.setSessionValue("button5B560F0BDD824D5A9DCAFE653D04FEC3.strcreateActivity", vars.getStringParameter("inpcreateActivity"));
        vars.setSessionValue("button5B560F0BDD824D5A9DCAFE653D04FEC3.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button5B560F0BDD824D5A9DCAFE653D04FEC3.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button5B560F0BDD824D5A9DCAFE653D04FEC3.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button5B560F0BDD824D5A9DCAFE653D04FEC3.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "5B560F0BDD824D5A9DCAFE653D04FEC3", request.getServletPath());    
     } else if (vars.commandIn("BUTTON5B560F0BDD824D5A9DCAFE653D04FEC3")) {
        String strOpcrm_Opportunities_ID = vars.getGlobalVariable("inpopcrmOpportunitiesId", windowId + "|Opcrm_Opportunities_ID", "");
        String strcreateActivity = vars.getSessionValue("button5B560F0BDD824D5A9DCAFE653D04FEC3.strcreateActivity");
        String strProcessing = vars.getSessionValue("button5B560F0BDD824D5A9DCAFE653D04FEC3.strProcessing");
        String strOrg = vars.getSessionValue("button5B560F0BDD824D5A9DCAFE653D04FEC3.strOrg");
        String strClient = vars.getSessionValue("button5B560F0BDD824D5A9DCAFE653D04FEC3.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonCreate_Activity5B560F0BDD824D5A9DCAFE653D04FEC3(response, vars, strOpcrm_Opportunities_ID, strcreateActivity, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONCreate_Activity5B560F0BDD824D5A9DCAFE653D04FEC3")) {
        String strOpcrm_Opportunities_ID = vars.getGlobalVariable("inpKey", windowId + "|Opcrm_Opportunities_ID", "");
        String strcreateActivity = vars.getStringParameter("inpcreateActivity");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "5B560F0BDD824D5A9DCAFE653D04FEC3", (("Opcrm_Opportunities_ID".equalsIgnoreCase("AD_Language"))?"0":strOpcrm_Opportunities_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          String strsubject = vars.getStringParameter("inpsubject");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "subject", strsubject, vars.getClient(), vars.getOrg(), vars.getUser());
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

    private void printPageButtonCreate_Activity5B560F0BDD824D5A9DCAFE653D04FEC3(HttpServletResponse response, VariablesSecureApp vars, String strOpcrm_Opportunities_ID, String strcreateActivity, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 5B560F0BDD824D5A9DCAFE653D04FEC3");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Create_Activity5B560F0BDD824D5A9DCAFE653D04FEC3", discard).createXmlDocument();
      xmlDocument.setParameter("key", strOpcrm_Opportunities_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "RelatedOpportunities11D68F1D801149DD88A65065972555CE_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "5B560F0BDD824D5A9DCAFE653D04FEC3");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("5B560F0BDD824D5A9DCAFE653D04FEC3");
        vars.removeMessage("5B560F0BDD824D5A9DCAFE653D04FEC3");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    xmlDocument.setParameter("subject", RelatedOpportunities11D68F1D801149DD88A65065972555CEData.selectActP5B560F0BDD824D5A9DCAFE653D04FEC3_subject(this, Utility.getContext(this, vars, "opcrm_opportunities_id", "123")));
    xmlDocument.setParameter("startdate", DateTimeData.today(this));
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
