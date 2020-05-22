
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
public class RelatedactivitiesACBCEB371F5048A3B318F6D50DEBA503 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "69469E04533A46EDA7D923964AE18BCA";
  private static final String tabId = "ACBCEB371F5048A3B318F6D50DEBA503";
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
     
      if (command.contains("AD9E33FEC65145B38F6AFDB3C5A4E55F")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("AD9E33FEC65145B38F6AFDB3C5A4E55F");
        SessionInfo.setModuleId("9FF1C0E7BAEF407EA93F0C2732F6CD11");
        if (securedProcess || explicitAccess.contains("AD9E33FEC65145B38F6AFDB3C5A4E55F")) {
          classInfo.type = "P";
          classInfo.id = "AD9E33FEC65145B38F6AFDB3C5A4E55F";
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

    private void printPageButtonCreateopportbtnAD9E33FEC65145B38F6AFDB3C5A4E55F(HttpServletResponse response, VariablesSecureApp vars, String strOpcrm_Activity_ID, String strcreateopportbtn, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process AD9E33FEC65145B38F6AFDB3C5A4E55F");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/CreateopportbtnAD9E33FEC65145B38F6AFDB3C5A4E55F", discard).createXmlDocument();
      xmlDocument.setParameter("key", strOpcrm_Activity_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "RelatedactivitiesACBCEB371F5048A3B318F6D50DEBA503_Edition.html");
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
    xmlDocument.setParameter("subject", RelatedactivitiesACBCEB371F5048A3B318F6D50DEBA503Data.selectActPAD9E33FEC65145B38F6AFDB3C5A4E55F_subject(this, Utility.getContext(this, vars, "opcrm_activity_id", "69469E04533A46EDA7D923964AE18BCA")));
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
    private void printPageButtonCreatecasebtn69AADF0AEB704D5B86A892FED02C8190(HttpServletResponse response, VariablesSecureApp vars, String strOpcrm_Activity_ID, String strcreatecasebtn, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 69AADF0AEB704D5B86A892FED02C8190");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Createcasebtn69AADF0AEB704D5B86A892FED02C8190", discard).createXmlDocument();
      xmlDocument.setParameter("key", strOpcrm_Activity_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "RelatedactivitiesACBCEB371F5048A3B318F6D50DEBA503_Edition.html");
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
    xmlDocument.setParameter("subject", RelatedactivitiesACBCEB371F5048A3B318F6D50DEBA503Data.selectActP69AADF0AEB704D5B86A892FED02C8190_subject(this, Utility.getContext(this, vars, "opcrm_activity_id", "69469E04533A46EDA7D923964AE18BCA")));
    xmlDocument.setParameter("deadline", "");
    xmlDocument.setParameter("deadline_Format", vars.getSessionValue("#AD_SqlDateFormat"));
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      
      out.println(xmlDocument.print());
      out.close();
    }



}
