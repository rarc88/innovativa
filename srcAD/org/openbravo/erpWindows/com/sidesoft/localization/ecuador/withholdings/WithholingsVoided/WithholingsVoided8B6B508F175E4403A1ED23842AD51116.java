
package org.openbravo.erpWindows.com.sidesoft.localization.ecuador.withholdings.WithholingsVoided;


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
public class WithholingsVoided8B6B508F175E4403A1ED23842AD51116 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "71AD442B55164E4B8482DE2EE117211B";
  private static final String tabId = "8B6B508F175E4403A1ED23842AD51116";
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
     
      if (command.contains("05E6E7C50BE3447392C9BC02EB86500D")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("05E6E7C50BE3447392C9BC02EB86500D");
        SessionInfo.setModuleId("771BE2659A444EC4996F01A0E8414A49");
      }
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     

     
      if (explicitAccess.contains("05E6E7C50BE3447392C9BC02EB86500D") || (securedProcess && command.contains("05E6E7C50BE3447392C9BC02EB86500D"))) {
        classInfo.type = "P";
        classInfo.id = "05E6E7C50BE3447392C9BC02EB86500D";
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

    } else if (vars.commandIn("BUTTONProcessed05E6E7C50BE3447392C9BC02EB86500D")) {
        vars.setSessionValue("button05E6E7C50BE3447392C9BC02EB86500D.strprocessed", vars.getStringParameter("inpprocessed"));
        vars.setSessionValue("button05E6E7C50BE3447392C9BC02EB86500D.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button05E6E7C50BE3447392C9BC02EB86500D.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button05E6E7C50BE3447392C9BC02EB86500D.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button05E6E7C50BE3447392C9BC02EB86500D.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "05E6E7C50BE3447392C9BC02EB86500D", request.getServletPath());
      } else if (vars.commandIn("BUTTON05E6E7C50BE3447392C9BC02EB86500D")) {
        String strSswh_Withholdings_Voided_ID = vars.getGlobalVariable("inpsswhWithholdingsVoidedId", windowId + "|Sswh_Withholdings_Voided_ID", "");
        String strprocessed = vars.getSessionValue("button05E6E7C50BE3447392C9BC02EB86500D.strprocessed");
        String strProcessing = vars.getSessionValue("button05E6E7C50BE3447392C9BC02EB86500D.strProcessing");
        String strOrg = vars.getSessionValue("button05E6E7C50BE3447392C9BC02EB86500D.strOrg");
        String strClient = vars.getSessionValue("button05E6E7C50BE3447392C9BC02EB86500D.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcessed05E6E7C50BE3447392C9BC02EB86500D(response, vars, strSswh_Withholdings_Voided_ID, strprocessed, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONProcessed05E6E7C50BE3447392C9BC02EB86500D")) {
        String strSswh_Withholdings_Voided_ID = vars.getGlobalVariable("inpKey", windowId + "|Sswh_Withholdings_Voided_ID", "");
        
        ProcessBundle pb = new ProcessBundle("05E6E7C50BE3447392C9BC02EB86500D", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("Sswh_Withholdings_Voided_ID", strSswh_Withholdings_Voided_ID);
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



    void printPageButtonProcessed05E6E7C50BE3447392C9BC02EB86500D(HttpServletResponse response, VariablesSecureApp vars, String strSswh_Withholdings_Voided_ID, String strprocessed, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 05E6E7C50BE3447392C9BC02EB86500D");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Processed05E6E7C50BE3447392C9BC02EB86500D", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSswh_Withholdings_Voided_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "WithholingsVoided8B6B508F175E4403A1ED23842AD51116_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "05E6E7C50BE3447392C9BC02EB86500D");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("05E6E7C50BE3447392C9BC02EB86500D");
        vars.removeMessage("05E6E7C50BE3447392C9BC02EB86500D");
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
