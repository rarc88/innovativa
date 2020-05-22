
package org.openbravo.erpWindows.com.sidesoft.flopec.budget.CreateLineBudget;


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
public class CreateLineBudgetEF1C3532EEF243E1B24E95AA61D6021A extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "3C5F8CE04C274D03A56D0E40D3B79BA0";
  private static final String tabId = "EF1C3532EEF243E1B24E95AA61D6021A";
  private static final int accesslevel = 3;
  private static final String moduleId = "75856ABEF4614636A5FABB70AD0CD4C8";
  
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
     
      if (command.contains("06BC21DBA5654E72A3EA175259AF4797")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("06BC21DBA5654E72A3EA175259AF4797");
        SessionInfo.setModuleId("75856ABEF4614636A5FABB70AD0CD4C8");
        if (securedProcess || explicitAccess.contains("06BC21DBA5654E72A3EA175259AF4797")) {
          classInfo.type = "P";
          classInfo.id = "06BC21DBA5654E72A3EA175259AF4797";
        }
      }
     
      if (command.contains("4013B59DE8634430A564A7410D2399E0")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("4013B59DE8634430A564A7410D2399E0");
        SessionInfo.setModuleId("75856ABEF4614636A5FABB70AD0CD4C8");
        if (securedProcess || explicitAccess.contains("4013B59DE8634430A564A7410D2399E0")) {
          classInfo.type = "P";
          classInfo.id = "4013B59DE8634430A564A7410D2399E0";
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

     } else if (vars.commandIn("BUTTONProcess06BC21DBA5654E72A3EA175259AF4797")) {
        vars.setSessionValue("button06BC21DBA5654E72A3EA175259AF4797.strprocess", vars.getStringParameter("inpprocess"));
        vars.setSessionValue("button06BC21DBA5654E72A3EA175259AF4797.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button06BC21DBA5654E72A3EA175259AF4797.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button06BC21DBA5654E72A3EA175259AF4797.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button06BC21DBA5654E72A3EA175259AF4797.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "06BC21DBA5654E72A3EA175259AF4797", request.getServletPath());    
     } else if (vars.commandIn("BUTTON06BC21DBA5654E72A3EA175259AF4797")) {
        String strSFB_Budget_Addline_ID = vars.getGlobalVariable("inpsfbBudgetAddlineId", windowId + "|SFB_Budget_Addline_ID", "");
        String strprocess = vars.getSessionValue("button06BC21DBA5654E72A3EA175259AF4797.strprocess");
        String strProcessing = vars.getSessionValue("button06BC21DBA5654E72A3EA175259AF4797.strProcessing");
        String strOrg = vars.getSessionValue("button06BC21DBA5654E72A3EA175259AF4797.strOrg");
        String strClient = vars.getSessionValue("button06BC21DBA5654E72A3EA175259AF4797.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcess06BC21DBA5654E72A3EA175259AF4797(response, vars, strSFB_Budget_Addline_ID, strprocess, strProcessing);
        }

     } else if (vars.commandIn("BUTTONReactive4013B59DE8634430A564A7410D2399E0")) {
        vars.setSessionValue("button4013B59DE8634430A564A7410D2399E0.strreactive", vars.getStringParameter("inpreactive"));
        vars.setSessionValue("button4013B59DE8634430A564A7410D2399E0.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button4013B59DE8634430A564A7410D2399E0.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button4013B59DE8634430A564A7410D2399E0.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button4013B59DE8634430A564A7410D2399E0.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "4013B59DE8634430A564A7410D2399E0", request.getServletPath());    
     } else if (vars.commandIn("BUTTON4013B59DE8634430A564A7410D2399E0")) {
        String strSFB_Budget_Addline_ID = vars.getGlobalVariable("inpsfbBudgetAddlineId", windowId + "|SFB_Budget_Addline_ID", "");
        String strreactive = vars.getSessionValue("button4013B59DE8634430A564A7410D2399E0.strreactive");
        String strProcessing = vars.getSessionValue("button4013B59DE8634430A564A7410D2399E0.strProcessing");
        String strOrg = vars.getSessionValue("button4013B59DE8634430A564A7410D2399E0.strOrg");
        String strClient = vars.getSessionValue("button4013B59DE8634430A564A7410D2399E0.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonReactive4013B59DE8634430A564A7410D2399E0(response, vars, strSFB_Budget_Addline_ID, strreactive, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONProcess06BC21DBA5654E72A3EA175259AF4797")) {
        String strSFB_Budget_Addline_ID = vars.getGlobalVariable("inpKey", windowId + "|SFB_Budget_Addline_ID", "");
        String strprocess = vars.getStringParameter("inpprocess");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "06BC21DBA5654E72A3EA175259AF4797", (("SFB_Budget_Addline_ID".equalsIgnoreCase("AD_Language"))?"0":strSFB_Budget_Addline_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONReactive4013B59DE8634430A564A7410D2399E0")) {
        String strSFB_Budget_Addline_ID = vars.getGlobalVariable("inpKey", windowId + "|SFB_Budget_Addline_ID", "");
        String strreactive = vars.getStringParameter("inpreactive");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "4013B59DE8634430A564A7410D2399E0", (("SFB_Budget_Addline_ID".equalsIgnoreCase("AD_Language"))?"0":strSFB_Budget_Addline_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    private void printPageButtonProcess06BC21DBA5654E72A3EA175259AF4797(HttpServletResponse response, VariablesSecureApp vars, String strSFB_Budget_Addline_ID, String strprocess, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 06BC21DBA5654E72A3EA175259AF4797");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Process06BC21DBA5654E72A3EA175259AF4797", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSFB_Budget_Addline_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "CreateLineBudgetEF1C3532EEF243E1B24E95AA61D6021A_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "06BC21DBA5654E72A3EA175259AF4797");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("06BC21DBA5654E72A3EA175259AF4797");
        vars.removeMessage("06BC21DBA5654E72A3EA175259AF4797");
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
    private void printPageButtonReactive4013B59DE8634430A564A7410D2399E0(HttpServletResponse response, VariablesSecureApp vars, String strSFB_Budget_Addline_ID, String strreactive, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 4013B59DE8634430A564A7410D2399E0");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Reactive4013B59DE8634430A564A7410D2399E0", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSFB_Budget_Addline_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "CreateLineBudgetEF1C3532EEF243E1B24E95AA61D6021A_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "4013B59DE8634430A564A7410D2399E0");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("4013B59DE8634430A564A7410D2399E0");
        vars.removeMessage("4013B59DE8634430A564A7410D2399E0");
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
