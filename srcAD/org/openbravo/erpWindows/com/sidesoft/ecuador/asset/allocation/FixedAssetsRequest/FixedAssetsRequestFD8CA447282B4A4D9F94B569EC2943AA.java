
package org.openbravo.erpWindows.com.sidesoft.ecuador.asset.allocation.FixedAssetsRequest;




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
public class FixedAssetsRequestFD8CA447282B4A4D9F94B569EC2943AA extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "8850B801A49941B98A4A391408AA5E84";
  private static final String tabId = "FD8CA447282B4A4D9F94B569EC2943AA";
  private static final int accesslevel = 3;
  private static final String moduleId = "1718FB3B55584F899FEEBF24BFF807AF";
  
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
     
      if (command.contains("3A53E5B4438A432EA7F48FD4A4FB9992")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("3A53E5B4438A432EA7F48FD4A4FB9992");
        SessionInfo.setModuleId("1718FB3B55584F899FEEBF24BFF807AF");
      }
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     

     
      if (explicitAccess.contains("3A53E5B4438A432EA7F48FD4A4FB9992") || (securedProcess && command.contains("3A53E5B4438A432EA7F48FD4A4FB9992"))) {
        classInfo.type = "P";
        classInfo.id = "3A53E5B4438A432EA7F48FD4A4FB9992";
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

    } else if (vars.commandIn("BUTTONProcess_Request3A53E5B4438A432EA7F48FD4A4FB9992")) {
        vars.setSessionValue("button3A53E5B4438A432EA7F48FD4A4FB9992.strprocessRequest", vars.getStringParameter("inpprocessRequest"));
        vars.setSessionValue("button3A53E5B4438A432EA7F48FD4A4FB9992.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button3A53E5B4438A432EA7F48FD4A4FB9992.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button3A53E5B4438A432EA7F48FD4A4FB9992.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button3A53E5B4438A432EA7F48FD4A4FB9992.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "3A53E5B4438A432EA7F48FD4A4FB9992", request.getServletPath());
      } else if (vars.commandIn("BUTTON3A53E5B4438A432EA7F48FD4A4FB9992")) {
        String strSsal_Appl_Active_ID = vars.getGlobalVariable("inpssalApplActiveId", windowId + "|Ssal_Appl_Active_ID", "");
        String strprocessRequest = vars.getSessionValue("button3A53E5B4438A432EA7F48FD4A4FB9992.strprocessRequest");
        String strProcessing = vars.getSessionValue("button3A53E5B4438A432EA7F48FD4A4FB9992.strProcessing");
        String strOrg = vars.getSessionValue("button3A53E5B4438A432EA7F48FD4A4FB9992.strOrg");
        String strClient = vars.getSessionValue("button3A53E5B4438A432EA7F48FD4A4FB9992.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcess_Request3A53E5B4438A432EA7F48FD4A4FB9992(response, vars, strSsal_Appl_Active_ID, strprocessRequest, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONProcess_Request3A53E5B4438A432EA7F48FD4A4FB9992")) {
        String strSsal_Appl_Active_ID = vars.getGlobalVariable("inpKey", windowId + "|Ssal_Appl_Active_ID", "");
        
        ProcessBundle pb = new ProcessBundle("3A53E5B4438A432EA7F48FD4A4FB9992", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("Ssal_Appl_Active_ID", strSsal_Appl_Active_ID);
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



    void printPageButtonProcess_Request3A53E5B4438A432EA7F48FD4A4FB9992(HttpServletResponse response, VariablesSecureApp vars, String strSsal_Appl_Active_ID, String strprocessRequest, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 3A53E5B4438A432EA7F48FD4A4FB9992");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Process_Request3A53E5B4438A432EA7F48FD4A4FB9992", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSsal_Appl_Active_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "FixedAssetsRequestFD8CA447282B4A4D9F94B569EC2943AA_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "3A53E5B4438A432EA7F48FD4A4FB9992");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("3A53E5B4438A432EA7F48FD4A4FB9992");
        vars.removeMessage("3A53E5B4438A432EA7F48FD4A4FB9992");
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
