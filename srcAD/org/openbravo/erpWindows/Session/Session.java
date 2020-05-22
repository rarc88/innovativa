
package org.openbravo.erpWindows.Session;




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
public class Session extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "264";
  private static final String tabId = "475";
  private static final int accesslevel = 4;
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
     
      if (command.contains("9DB4D30BFC5144B9B431CB49DDE9270D")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("9DB4D30BFC5144B9B431CB49DDE9270D");
        SessionInfo.setModuleId("0");
      }
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     

     
      if (explicitAccess.contains("9DB4D30BFC5144B9B431CB49DDE9270D") || (securedProcess && command.contains("9DB4D30BFC5144B9B431CB49DDE9270D"))) {
        classInfo.type = "P";
        classInfo.id = "9DB4D30BFC5144B9B431CB49DDE9270D";
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

    } else if (vars.commandIn("BUTTONSession_Active9DB4D30BFC5144B9B431CB49DDE9270D")) {
        vars.setSessionValue("button9DB4D30BFC5144B9B431CB49DDE9270D.strsessionActive", vars.getStringParameter("inpsessionActive"));
        vars.setSessionValue("button9DB4D30BFC5144B9B431CB49DDE9270D.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button9DB4D30BFC5144B9B431CB49DDE9270D.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button9DB4D30BFC5144B9B431CB49DDE9270D.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button9DB4D30BFC5144B9B431CB49DDE9270D.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "9DB4D30BFC5144B9B431CB49DDE9270D", request.getServletPath());
      } else if (vars.commandIn("BUTTON9DB4D30BFC5144B9B431CB49DDE9270D")) {
        String strAD_Session_ID = vars.getGlobalVariable("inpadSessionId", windowId + "|AD_Session_ID", "");
        String strsessionActive = vars.getSessionValue("button9DB4D30BFC5144B9B431CB49DDE9270D.strsessionActive");
        String strProcessing = vars.getSessionValue("button9DB4D30BFC5144B9B431CB49DDE9270D.strProcessing");
        String strOrg = vars.getSessionValue("button9DB4D30BFC5144B9B431CB49DDE9270D.strOrg");
        String strClient = vars.getSessionValue("button9DB4D30BFC5144B9B431CB49DDE9270D.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonSession_Active9DB4D30BFC5144B9B431CB49DDE9270D(response, vars, strAD_Session_ID, strsessionActive, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONSession_Active9DB4D30BFC5144B9B431CB49DDE9270D")) {
        String strAD_Session_ID = vars.getGlobalVariable("inpKey", windowId + "|AD_Session_ID", "");
        
        ProcessBundle pb = new ProcessBundle("9DB4D30BFC5144B9B431CB49DDE9270D", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("AD_Session_ID", strAD_Session_ID);
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



    void printPageButtonSession_Active9DB4D30BFC5144B9B431CB49DDE9270D(HttpServletResponse response, VariablesSecureApp vars, String strAD_Session_ID, String strsessionActive, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 9DB4D30BFC5144B9B431CB49DDE9270D");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Session_Active9DB4D30BFC5144B9B431CB49DDE9270D", discard).createXmlDocument();
      xmlDocument.setParameter("key", strAD_Session_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Session_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "9DB4D30BFC5144B9B431CB49DDE9270D");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("9DB4D30BFC5144B9B431CB49DDE9270D");
        vars.removeMessage("9DB4D30BFC5144B9B431CB49DDE9270D");
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
