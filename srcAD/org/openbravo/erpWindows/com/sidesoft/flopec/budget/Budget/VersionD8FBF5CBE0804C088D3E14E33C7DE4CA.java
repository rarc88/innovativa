
package org.openbravo.erpWindows.com.sidesoft.flopec.budget.Budget;




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
public class VersionD8FBF5CBE0804C088D3E14E33C7DE4CA extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "2998ACDCA6A649B5A39372022878287C";
  private static final String tabId = "D8FBF5CBE0804C088D3E14E33C7DE4CA";
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
     
      if (command.contains("5AC5C4C39A8F4A37B6098A0512288889")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("5AC5C4C39A8F4A37B6098A0512288889");
        SessionInfo.setModuleId("75856ABEF4614636A5FABB70AD0CD4C8");
      }
     
      if (command.contains("5FE514F293DB458DAC6DC79C4FE83A8D")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("5FE514F293DB458DAC6DC79C4FE83A8D");
        SessionInfo.setModuleId("75856ABEF4614636A5FABB70AD0CD4C8");
      }
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     

     
      if (explicitAccess.contains("5AC5C4C39A8F4A37B6098A0512288889") || (securedProcess && command.contains("5AC5C4C39A8F4A37B6098A0512288889"))) {
        classInfo.type = "P";
        classInfo.id = "5AC5C4C39A8F4A37B6098A0512288889";
      }
     
      if (explicitAccess.contains("5FE514F293DB458DAC6DC79C4FE83A8D") || (securedProcess && command.contains("5FE514F293DB458DAC6DC79C4FE83A8D"))) {
        classInfo.type = "P";
        classInfo.id = "5FE514F293DB458DAC6DC79C4FE83A8D";
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

    } else if (vars.commandIn("BUTTONCreate_Version5AC5C4C39A8F4A37B6098A0512288889")) {
        vars.setSessionValue("button5AC5C4C39A8F4A37B6098A0512288889.strcreateVersion", vars.getStringParameter("inpcreateVersion"));
        vars.setSessionValue("button5AC5C4C39A8F4A37B6098A0512288889.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button5AC5C4C39A8F4A37B6098A0512288889.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button5AC5C4C39A8F4A37B6098A0512288889.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button5AC5C4C39A8F4A37B6098A0512288889.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "5AC5C4C39A8F4A37B6098A0512288889", request.getServletPath());
      } else if (vars.commandIn("BUTTON5AC5C4C39A8F4A37B6098A0512288889")) {
        String strSFB_Budget_Version_ID = vars.getGlobalVariable("inpsfbBudgetVersionId", windowId + "|SFB_Budget_Version_ID", "");
        String strcreateVersion = vars.getSessionValue("button5AC5C4C39A8F4A37B6098A0512288889.strcreateVersion");
        String strProcessing = vars.getSessionValue("button5AC5C4C39A8F4A37B6098A0512288889.strProcessing");
        String strOrg = vars.getSessionValue("button5AC5C4C39A8F4A37B6098A0512288889.strOrg");
        String strClient = vars.getSessionValue("button5AC5C4C39A8F4A37B6098A0512288889.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonCreate_Version5AC5C4C39A8F4A37B6098A0512288889(response, vars, strSFB_Budget_Version_ID, strcreateVersion, strProcessing);
        }
    } else if (vars.commandIn("BUTTONApprove_Version5FE514F293DB458DAC6DC79C4FE83A8D")) {
        vars.setSessionValue("button5FE514F293DB458DAC6DC79C4FE83A8D.strapproveVersion", vars.getStringParameter("inpapproveVersion"));
        vars.setSessionValue("button5FE514F293DB458DAC6DC79C4FE83A8D.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button5FE514F293DB458DAC6DC79C4FE83A8D.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button5FE514F293DB458DAC6DC79C4FE83A8D.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button5FE514F293DB458DAC6DC79C4FE83A8D.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "5FE514F293DB458DAC6DC79C4FE83A8D", request.getServletPath());
      } else if (vars.commandIn("BUTTON5FE514F293DB458DAC6DC79C4FE83A8D")) {
        String strSFB_Budget_Version_ID = vars.getGlobalVariable("inpsfbBudgetVersionId", windowId + "|SFB_Budget_Version_ID", "");
        String strapproveVersion = vars.getSessionValue("button5FE514F293DB458DAC6DC79C4FE83A8D.strapproveVersion");
        String strProcessing = vars.getSessionValue("button5FE514F293DB458DAC6DC79C4FE83A8D.strProcessing");
        String strOrg = vars.getSessionValue("button5FE514F293DB458DAC6DC79C4FE83A8D.strOrg");
        String strClient = vars.getSessionValue("button5FE514F293DB458DAC6DC79C4FE83A8D.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonApprove_Version5FE514F293DB458DAC6DC79C4FE83A8D(response, vars, strSFB_Budget_Version_ID, strapproveVersion, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONCreate_Version5AC5C4C39A8F4A37B6098A0512288889")) {
        String strSFB_Budget_Version_ID = vars.getGlobalVariable("inpKey", windowId + "|SFB_Budget_Version_ID", "");
        
        ProcessBundle pb = new ProcessBundle("5AC5C4C39A8F4A37B6098A0512288889", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("SFB_Budget_Version_ID", strSFB_Budget_Version_ID);
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
    } else if (vars.commandIn("SAVE_BUTTONApprove_Version5FE514F293DB458DAC6DC79C4FE83A8D")) {
        String strSFB_Budget_Version_ID = vars.getGlobalVariable("inpKey", windowId + "|SFB_Budget_Version_ID", "");
        
        ProcessBundle pb = new ProcessBundle("5FE514F293DB458DAC6DC79C4FE83A8D", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("SFB_Budget_Version_ID", strSFB_Budget_Version_ID);
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



    void printPageButtonCreate_Version5AC5C4C39A8F4A37B6098A0512288889(HttpServletResponse response, VariablesSecureApp vars, String strSFB_Budget_Version_ID, String strcreateVersion, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 5AC5C4C39A8F4A37B6098A0512288889");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Create_Version5AC5C4C39A8F4A37B6098A0512288889", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSFB_Budget_Version_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "VersionD8FBF5CBE0804C088D3E14E33C7DE4CA_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "5AC5C4C39A8F4A37B6098A0512288889");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("5AC5C4C39A8F4A37B6098A0512288889");
        vars.removeMessage("5AC5C4C39A8F4A37B6098A0512288889");
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
    void printPageButtonApprove_Version5FE514F293DB458DAC6DC79C4FE83A8D(HttpServletResponse response, VariablesSecureApp vars, String strSFB_Budget_Version_ID, String strapproveVersion, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 5FE514F293DB458DAC6DC79C4FE83A8D");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Approve_Version5FE514F293DB458DAC6DC79C4FE83A8D", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSFB_Budget_Version_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "VersionD8FBF5CBE0804C088D3E14E33C7DE4CA_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "5FE514F293DB458DAC6DC79C4FE83A8D");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("5FE514F293DB458DAC6DC79C4FE83A8D");
        vars.removeMessage("5FE514F293DB458DAC6DC79C4FE83A8D");
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
