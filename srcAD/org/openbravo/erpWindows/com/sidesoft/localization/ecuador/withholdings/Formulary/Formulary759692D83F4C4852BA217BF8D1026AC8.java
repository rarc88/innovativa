
package org.openbravo.erpWindows.com.sidesoft.localization.ecuador.withholdings.Formulary;


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
public class Formulary759692D83F4C4852BA217BF8D1026AC8 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "0AA43DE6B4AF41D08058F2407CA11C0D";
  private static final String tabId = "759692D83F4C4852BA217BF8D1026AC8";
  private static final int accesslevel = 3;
  private static final String moduleId = "771BE2659A444EC4996F01A0E8414A49";
  
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
     
      if (command.contains("04E8DDB2B4EB406293022426AC23BA90")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("04E8DDB2B4EB406293022426AC23BA90");
        SessionInfo.setModuleId("771BE2659A444EC4996F01A0E8414A49");
        if (securedProcess || explicitAccess.contains("04E8DDB2B4EB406293022426AC23BA90")) {
          classInfo.type = "P";
          classInfo.id = "04E8DDB2B4EB406293022426AC23BA90";
        }
      }
     
      if (command.contains("83F27E53DECE4B3E83DE8A6AC62C0F38")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("83F27E53DECE4B3E83DE8A6AC62C0F38");
        SessionInfo.setModuleId("771BE2659A444EC4996F01A0E8414A49");
        if (securedProcess || explicitAccess.contains("83F27E53DECE4B3E83DE8A6AC62C0F38")) {
          classInfo.type = "P";
          classInfo.id = "83F27E53DECE4B3E83DE8A6AC62C0F38";
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

     } else if (vars.commandIn("BUTTONProcess04E8DDB2B4EB406293022426AC23BA90")) {
        vars.setSessionValue("button04E8DDB2B4EB406293022426AC23BA90.strprocess", vars.getStringParameter("inpprocess"));
        vars.setSessionValue("button04E8DDB2B4EB406293022426AC23BA90.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button04E8DDB2B4EB406293022426AC23BA90.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button04E8DDB2B4EB406293022426AC23BA90.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button04E8DDB2B4EB406293022426AC23BA90.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "04E8DDB2B4EB406293022426AC23BA90", request.getServletPath());    
     } else if (vars.commandIn("BUTTON04E8DDB2B4EB406293022426AC23BA90")) {
        String strSswh_Formulary_ID = vars.getGlobalVariable("inpsswhFormularyId", windowId + "|Sswh_Formulary_ID", "");
        String strprocess = vars.getSessionValue("button04E8DDB2B4EB406293022426AC23BA90.strprocess");
        String strProcessing = vars.getSessionValue("button04E8DDB2B4EB406293022426AC23BA90.strProcessing");
        String strOrg = vars.getSessionValue("button04E8DDB2B4EB406293022426AC23BA90.strOrg");
        String strClient = vars.getSessionValue("button04E8DDB2B4EB406293022426AC23BA90.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcess04E8DDB2B4EB406293022426AC23BA90(response, vars, strSswh_Formulary_ID, strprocess, strProcessing);
        }

     } else if (vars.commandIn("BUTTONUnprocess83F27E53DECE4B3E83DE8A6AC62C0F38")) {
        vars.setSessionValue("button83F27E53DECE4B3E83DE8A6AC62C0F38.strunprocess", vars.getStringParameter("inpunprocess"));
        vars.setSessionValue("button83F27E53DECE4B3E83DE8A6AC62C0F38.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button83F27E53DECE4B3E83DE8A6AC62C0F38.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button83F27E53DECE4B3E83DE8A6AC62C0F38.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button83F27E53DECE4B3E83DE8A6AC62C0F38.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "83F27E53DECE4B3E83DE8A6AC62C0F38", request.getServletPath());    
     } else if (vars.commandIn("BUTTON83F27E53DECE4B3E83DE8A6AC62C0F38")) {
        String strSswh_Formulary_ID = vars.getGlobalVariable("inpsswhFormularyId", windowId + "|Sswh_Formulary_ID", "");
        String strunprocess = vars.getSessionValue("button83F27E53DECE4B3E83DE8A6AC62C0F38.strunprocess");
        String strProcessing = vars.getSessionValue("button83F27E53DECE4B3E83DE8A6AC62C0F38.strProcessing");
        String strOrg = vars.getSessionValue("button83F27E53DECE4B3E83DE8A6AC62C0F38.strOrg");
        String strClient = vars.getSessionValue("button83F27E53DECE4B3E83DE8A6AC62C0F38.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonUnprocess83F27E53DECE4B3E83DE8A6AC62C0F38(response, vars, strSswh_Formulary_ID, strunprocess, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONProcess04E8DDB2B4EB406293022426AC23BA90")) {
        String strSswh_Formulary_ID = vars.getGlobalVariable("inpKey", windowId + "|Sswh_Formulary_ID", "");
        String strprocess = vars.getStringParameter("inpprocess");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "04E8DDB2B4EB406293022426AC23BA90", (("Sswh_Formulary_ID".equalsIgnoreCase("AD_Language"))?"0":strSswh_Formulary_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONUnprocess83F27E53DECE4B3E83DE8A6AC62C0F38")) {
        String strSswh_Formulary_ID = vars.getGlobalVariable("inpKey", windowId + "|Sswh_Formulary_ID", "");
        String strunprocess = vars.getStringParameter("inpunprocess");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "83F27E53DECE4B3E83DE8A6AC62C0F38", (("Sswh_Formulary_ID".equalsIgnoreCase("AD_Language"))?"0":strSswh_Formulary_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    private void printPageButtonProcess04E8DDB2B4EB406293022426AC23BA90(HttpServletResponse response, VariablesSecureApp vars, String strSswh_Formulary_ID, String strprocess, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 04E8DDB2B4EB406293022426AC23BA90");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Process04E8DDB2B4EB406293022426AC23BA90", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSswh_Formulary_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Formulary759692D83F4C4852BA217BF8D1026AC8_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "04E8DDB2B4EB406293022426AC23BA90");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("04E8DDB2B4EB406293022426AC23BA90");
        vars.removeMessage("04E8DDB2B4EB406293022426AC23BA90");
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
    private void printPageButtonUnprocess83F27E53DECE4B3E83DE8A6AC62C0F38(HttpServletResponse response, VariablesSecureApp vars, String strSswh_Formulary_ID, String strunprocess, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 83F27E53DECE4B3E83DE8A6AC62C0F38");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Unprocess83F27E53DECE4B3E83DE8A6AC62C0F38", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSswh_Formulary_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Formulary759692D83F4C4852BA217BF8D1026AC8_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "83F27E53DECE4B3E83DE8A6AC62C0F38");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("83F27E53DECE4B3E83DE8A6AC62C0F38");
        vars.removeMessage("83F27E53DECE4B3E83DE8A6AC62C0F38");
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
