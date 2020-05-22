
package org.openbravo.erpWindows.com.sidesoft.localization.ecuador.withholdings.WithholdingsCard;


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
public class WithholdingsCard26723DEBE7BA4570ADF0AE5C2D3846DC extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "9A40FFB27B554816AD41F0732442246E";
  private static final String tabId = "26723DEBE7BA4570ADF0AE5C2D3846DC";
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
     
      if (command.contains("1CA6DCB97C7646E39C30B20F96653B02")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("1CA6DCB97C7646E39C30B20F96653B02");
        SessionInfo.setModuleId("771BE2659A444EC4996F01A0E8414A49");
        if (securedProcess || explicitAccess.contains("1CA6DCB97C7646E39C30B20F96653B02")) {
          classInfo.type = "P";
          classInfo.id = "1CA6DCB97C7646E39C30B20F96653B02";
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

     } else if (vars.commandIn("BUTTONProcessed1CA6DCB97C7646E39C30B20F96653B02")) {
        vars.setSessionValue("button1CA6DCB97C7646E39C30B20F96653B02.strprocessed", vars.getStringParameter("inpprocessed"));
        vars.setSessionValue("button1CA6DCB97C7646E39C30B20F96653B02.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button1CA6DCB97C7646E39C30B20F96653B02.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button1CA6DCB97C7646E39C30B20F96653B02.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button1CA6DCB97C7646E39C30B20F96653B02.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "1CA6DCB97C7646E39C30B20F96653B02", request.getServletPath());    
     } else if (vars.commandIn("BUTTON1CA6DCB97C7646E39C30B20F96653B02")) {
        String strSswh_Withh_Card_Credit_ID = vars.getGlobalVariable("inpsswhWithhCardCreditId", windowId + "|Sswh_Withh_Card_Credit_ID", "");
        String strprocessed = vars.getSessionValue("button1CA6DCB97C7646E39C30B20F96653B02.strprocessed");
        String strProcessing = vars.getSessionValue("button1CA6DCB97C7646E39C30B20F96653B02.strProcessing");
        String strOrg = vars.getSessionValue("button1CA6DCB97C7646E39C30B20F96653B02.strOrg");
        String strClient = vars.getSessionValue("button1CA6DCB97C7646E39C30B20F96653B02.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcessed1CA6DCB97C7646E39C30B20F96653B02(response, vars, strSswh_Withh_Card_Credit_ID, strprocessed, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONProcessed1CA6DCB97C7646E39C30B20F96653B02")) {
        String strSswh_Withh_Card_Credit_ID = vars.getGlobalVariable("inpKey", windowId + "|Sswh_Withh_Card_Credit_ID", "");
        String strprocessed = vars.getStringParameter("inpprocessed");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "1CA6DCB97C7646E39C30B20F96653B02", (("Sswh_Withh_Card_Credit_ID".equalsIgnoreCase("AD_Language"))?"0":strSswh_Withh_Card_Credit_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    private void printPageButtonProcessed1CA6DCB97C7646E39C30B20F96653B02(HttpServletResponse response, VariablesSecureApp vars, String strSswh_Withh_Card_Credit_ID, String strprocessed, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 1CA6DCB97C7646E39C30B20F96653B02");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Processed1CA6DCB97C7646E39C30B20F96653B02", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSswh_Withh_Card_Credit_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "WithholdingsCard26723DEBE7BA4570ADF0AE5C2D3846DC_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "1CA6DCB97C7646E39C30B20F96653B02");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("1CA6DCB97C7646E39C30B20F96653B02");
        vars.removeMessage("1CA6DCB97C7646E39C30B20F96653B02");
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
