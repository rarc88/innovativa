
package org.openbravo.erpWindows.ec.com.sidesoft.localization.ecuador.viatical.ViaticalApplication;


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
public class ViaticalApplication893B013D688B4B2893A3B157088AB17F extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "41A171004C1749978EDC07AFEE06782D";
  private static final String tabId = "893B013D688B4B2893A3B157088AB17F";
  private static final int accesslevel = 3;
  private static final String moduleId = "34806599C8BE45F7916577F44028DFB2";
  
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
     
      if (command.contains("689FF3B213C4442DA9B6A97C55E9A9F1")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("689FF3B213C4442DA9B6A97C55E9A9F1");
        SessionInfo.setModuleId("34806599C8BE45F7916577F44028DFB2");
        if (securedProcess || explicitAccess.contains("689FF3B213C4442DA9B6A97C55E9A9F1")) {
          classInfo.type = "P";
          classInfo.id = "689FF3B213C4442DA9B6A97C55E9A9F1";
        }
      }
     
      if (command.contains("DC74691C2D5246C492DE58D007DB062B")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("DC74691C2D5246C492DE58D007DB062B");
        SessionInfo.setModuleId("34806599C8BE45F7916577F44028DFB2");
        if (securedProcess || explicitAccess.contains("DC74691C2D5246C492DE58D007DB062B")) {
          classInfo.type = "P";
          classInfo.id = "DC74691C2D5246C492DE58D007DB062B";
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

     } else if (vars.commandIn("BUTTONGetlines689FF3B213C4442DA9B6A97C55E9A9F1")) {
        vars.setSessionValue("button689FF3B213C4442DA9B6A97C55E9A9F1.strgetlines", vars.getStringParameter("inpgetlines"));
        vars.setSessionValue("button689FF3B213C4442DA9B6A97C55E9A9F1.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button689FF3B213C4442DA9B6A97C55E9A9F1.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button689FF3B213C4442DA9B6A97C55E9A9F1.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button689FF3B213C4442DA9B6A97C55E9A9F1.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "689FF3B213C4442DA9B6A97C55E9A9F1", request.getServletPath());    
     } else if (vars.commandIn("BUTTON689FF3B213C4442DA9B6A97C55E9A9F1")) {
        String strSsve_Viatical_ID = vars.getGlobalVariable("inpssveViaticalId", windowId + "|Ssve_Viatical_ID", "");
        String strgetlines = vars.getSessionValue("button689FF3B213C4442DA9B6A97C55E9A9F1.strgetlines");
        String strProcessing = vars.getSessionValue("button689FF3B213C4442DA9B6A97C55E9A9F1.strProcessing");
        String strOrg = vars.getSessionValue("button689FF3B213C4442DA9B6A97C55E9A9F1.strOrg");
        String strClient = vars.getSessionValue("button689FF3B213C4442DA9B6A97C55E9A9F1.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonGetlines689FF3B213C4442DA9B6A97C55E9A9F1(response, vars, strSsve_Viatical_ID, strgetlines, strProcessing);
        }

     } else if (vars.commandIn("BUTTONProcessedDC74691C2D5246C492DE58D007DB062B")) {
        vars.setSessionValue("buttonDC74691C2D5246C492DE58D007DB062B.strprocessed", vars.getStringParameter("inpprocessed"));
        vars.setSessionValue("buttonDC74691C2D5246C492DE58D007DB062B.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonDC74691C2D5246C492DE58D007DB062B.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonDC74691C2D5246C492DE58D007DB062B.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonDC74691C2D5246C492DE58D007DB062B.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "DC74691C2D5246C492DE58D007DB062B", request.getServletPath());    
     } else if (vars.commandIn("BUTTONDC74691C2D5246C492DE58D007DB062B")) {
        String strSsve_Viatical_ID = vars.getGlobalVariable("inpssveViaticalId", windowId + "|Ssve_Viatical_ID", "");
        String strprocessed = vars.getSessionValue("buttonDC74691C2D5246C492DE58D007DB062B.strprocessed");
        String strProcessing = vars.getSessionValue("buttonDC74691C2D5246C492DE58D007DB062B.strProcessing");
        String strOrg = vars.getSessionValue("buttonDC74691C2D5246C492DE58D007DB062B.strOrg");
        String strClient = vars.getSessionValue("buttonDC74691C2D5246C492DE58D007DB062B.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcessedDC74691C2D5246C492DE58D007DB062B(response, vars, strSsve_Viatical_ID, strprocessed, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONGetlines689FF3B213C4442DA9B6A97C55E9A9F1")) {
        String strSsve_Viatical_ID = vars.getGlobalVariable("inpKey", windowId + "|Ssve_Viatical_ID", "");
        String strgetlines = vars.getStringParameter("inpgetlines");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "689FF3B213C4442DA9B6A97C55E9A9F1", (("Ssve_Viatical_ID".equalsIgnoreCase("AD_Language"))?"0":strSsve_Viatical_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONProcessedDC74691C2D5246C492DE58D007DB062B")) {
        String strSsve_Viatical_ID = vars.getGlobalVariable("inpKey", windowId + "|Ssve_Viatical_ID", "");
        String strprocessed = vars.getStringParameter("inpprocessed");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "DC74691C2D5246C492DE58D007DB062B", (("Ssve_Viatical_ID".equalsIgnoreCase("AD_Language"))?"0":strSsve_Viatical_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    private void printPageButtonGetlines689FF3B213C4442DA9B6A97C55E9A9F1(HttpServletResponse response, VariablesSecureApp vars, String strSsve_Viatical_ID, String strgetlines, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 689FF3B213C4442DA9B6A97C55E9A9F1");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Getlines689FF3B213C4442DA9B6A97C55E9A9F1", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSsve_Viatical_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "ViaticalApplication893B013D688B4B2893A3B157088AB17F_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "689FF3B213C4442DA9B6A97C55E9A9F1");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("689FF3B213C4442DA9B6A97C55E9A9F1");
        vars.removeMessage("689FF3B213C4442DA9B6A97C55E9A9F1");
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
    private void printPageButtonProcessedDC74691C2D5246C492DE58D007DB062B(HttpServletResponse response, VariablesSecureApp vars, String strSsve_Viatical_ID, String strprocessed, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process DC74691C2D5246C492DE58D007DB062B");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ProcessedDC74691C2D5246C492DE58D007DB062B", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSsve_Viatical_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "ViaticalApplication893B013D688B4B2893A3B157088AB17F_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "DC74691C2D5246C492DE58D007DB062B");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("DC74691C2D5246C492DE58D007DB062B");
        vars.removeMessage("DC74691C2D5246C492DE58D007DB062B");
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
