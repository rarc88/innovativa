
package org.openbravo.erpWindows.Client;


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
public class Client extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "109";
  private static final String tabId = "145";
  private static final int accesslevel = 6;
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
     
      if (command.contains("1779E98DEB1A4AE19B14610A5DE93B96")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("1779E98DEB1A4AE19B14610A5DE93B96");
        SessionInfo.setModuleId("9FF1C0E7BAEF407EA93F0C2732F6CD11");
        if (securedProcess || explicitAccess.contains("1779E98DEB1A4AE19B14610A5DE93B96")) {
          classInfo.type = "P";
          classInfo.id = "1779E98DEB1A4AE19B14610A5DE93B96";
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

     } else if (vars.commandIn("BUTTONEM_Opcrm_Clientid_Btn1779E98DEB1A4AE19B14610A5DE93B96")) {
        vars.setSessionValue("button1779E98DEB1A4AE19B14610A5DE93B96.stremOpcrmClientidBtn", vars.getStringParameter("inpemOpcrmClientidBtn"));
        vars.setSessionValue("button1779E98DEB1A4AE19B14610A5DE93B96.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button1779E98DEB1A4AE19B14610A5DE93B96.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button1779E98DEB1A4AE19B14610A5DE93B96.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button1779E98DEB1A4AE19B14610A5DE93B96.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "1779E98DEB1A4AE19B14610A5DE93B96", request.getServletPath());    
     } else if (vars.commandIn("BUTTON1779E98DEB1A4AE19B14610A5DE93B96")) {
        String strAD_Client_ID = vars.getGlobalVariable("inpadClientId", windowId + "|AD_Client_ID", "");
        String stremOpcrmClientidBtn = vars.getSessionValue("button1779E98DEB1A4AE19B14610A5DE93B96.stremOpcrmClientidBtn");
        String strProcessing = vars.getSessionValue("button1779E98DEB1A4AE19B14610A5DE93B96.strProcessing");
        String strOrg = vars.getSessionValue("button1779E98DEB1A4AE19B14610A5DE93B96.strOrg");
        String strClient = vars.getSessionValue("button1779E98DEB1A4AE19B14610A5DE93B96.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Opcrm_Clientid_Btn1779E98DEB1A4AE19B14610A5DE93B96(response, vars, strAD_Client_ID, stremOpcrmClientidBtn, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONEM_Opcrm_Clientid_Btn1779E98DEB1A4AE19B14610A5DE93B96")) {
        String strAD_Client_ID = vars.getGlobalVariable("inpKey", windowId + "|AD_Client_ID", "");
        String stremOpcrmClientidBtn = vars.getStringParameter("inpemOpcrmClientidBtn");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "1779E98DEB1A4AE19B14610A5DE93B96", (("AD_Client_ID".equalsIgnoreCase("AD_Language"))?"0":strAD_Client_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    private void printPageButtonEM_Opcrm_Clientid_Btn1779E98DEB1A4AE19B14610A5DE93B96(HttpServletResponse response, VariablesSecureApp vars, String strAD_Client_ID, String stremOpcrmClientidBtn, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 1779E98DEB1A4AE19B14610A5DE93B96");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Opcrm_Clientid_Btn1779E98DEB1A4AE19B14610A5DE93B96", discard).createXmlDocument();
      xmlDocument.setParameter("key", strAD_Client_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Client_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "1779E98DEB1A4AE19B14610A5DE93B96");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("1779E98DEB1A4AE19B14610A5DE93B96");
        vars.removeMessage("1779E98DEB1A4AE19B14610A5DE93B96");
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
