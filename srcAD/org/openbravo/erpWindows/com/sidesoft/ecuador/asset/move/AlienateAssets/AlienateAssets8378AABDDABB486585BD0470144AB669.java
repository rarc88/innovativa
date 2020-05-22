
package org.openbravo.erpWindows.com.sidesoft.ecuador.asset.move.AlienateAssets;


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
public class AlienateAssets8378AABDDABB486585BD0470144AB669 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "4D8410A8736C4C62AACEDE8507B0517C";
  private static final String tabId = "8378AABDDABB486585BD0470144AB669";
  private static final int accesslevel = 3;
  private static final String moduleId = "109FD67312E942D78B0202B3DD4C1E81";
  
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
     
      if (command.contains("939B8BFD4ABF44E08DA98CF14D273779")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("939B8BFD4ABF44E08DA98CF14D273779");
        SessionInfo.setModuleId("109FD67312E942D78B0202B3DD4C1E81");
        if (securedProcess || explicitAccess.contains("939B8BFD4ABF44E08DA98CF14D273779")) {
          classInfo.type = "P";
          classInfo.id = "939B8BFD4ABF44E08DA98CF14D273779";
        }
      }
     
      if (command.contains("AD30C9D2251741598C27F4395FA71676")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("AD30C9D2251741598C27F4395FA71676");
        SessionInfo.setModuleId("109FD67312E942D78B0202B3DD4C1E81");
        if (securedProcess || explicitAccess.contains("AD30C9D2251741598C27F4395FA71676")) {
          classInfo.type = "P";
          classInfo.id = "AD30C9D2251741598C27F4395FA71676";
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

     } else if (vars.commandIn("BUTTONProcessed939B8BFD4ABF44E08DA98CF14D273779")) {
        vars.setSessionValue("button939B8BFD4ABF44E08DA98CF14D273779.strprocessed", vars.getStringParameter("inpprocessed"));
        vars.setSessionValue("button939B8BFD4ABF44E08DA98CF14D273779.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button939B8BFD4ABF44E08DA98CF14D273779.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button939B8BFD4ABF44E08DA98CF14D273779.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button939B8BFD4ABF44E08DA98CF14D273779.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "939B8BFD4ABF44E08DA98CF14D273779", request.getServletPath());    
     } else if (vars.commandIn("BUTTON939B8BFD4ABF44E08DA98CF14D273779")) {
        String strSsam_Alienate_ID = vars.getGlobalVariable("inpssamAlienateId", windowId + "|Ssam_Alienate_ID", "");
        String strprocessed = vars.getSessionValue("button939B8BFD4ABF44E08DA98CF14D273779.strprocessed");
        String strProcessing = vars.getSessionValue("button939B8BFD4ABF44E08DA98CF14D273779.strProcessing");
        String strOrg = vars.getSessionValue("button939B8BFD4ABF44E08DA98CF14D273779.strOrg");
        String strClient = vars.getSessionValue("button939B8BFD4ABF44E08DA98CF14D273779.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcessed939B8BFD4ABF44E08DA98CF14D273779(response, vars, strSsam_Alienate_ID, strprocessed, strProcessing);
        }

     } else if (vars.commandIn("BUTTONCreatelineAD30C9D2251741598C27F4395FA71676")) {
        vars.setSessionValue("buttonAD30C9D2251741598C27F4395FA71676.strcreateline", vars.getStringParameter("inpcreateline"));
        vars.setSessionValue("buttonAD30C9D2251741598C27F4395FA71676.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonAD30C9D2251741598C27F4395FA71676.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonAD30C9D2251741598C27F4395FA71676.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonAD30C9D2251741598C27F4395FA71676.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "AD30C9D2251741598C27F4395FA71676", request.getServletPath());    
     } else if (vars.commandIn("BUTTONAD30C9D2251741598C27F4395FA71676")) {
        String strSsam_Alienate_ID = vars.getGlobalVariable("inpssamAlienateId", windowId + "|Ssam_Alienate_ID", "");
        String strcreateline = vars.getSessionValue("buttonAD30C9D2251741598C27F4395FA71676.strcreateline");
        String strProcessing = vars.getSessionValue("buttonAD30C9D2251741598C27F4395FA71676.strProcessing");
        String strOrg = vars.getSessionValue("buttonAD30C9D2251741598C27F4395FA71676.strOrg");
        String strClient = vars.getSessionValue("buttonAD30C9D2251741598C27F4395FA71676.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonCreatelineAD30C9D2251741598C27F4395FA71676(response, vars, strSsam_Alienate_ID, strcreateline, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONProcessed939B8BFD4ABF44E08DA98CF14D273779")) {
        String strSsam_Alienate_ID = vars.getGlobalVariable("inpKey", windowId + "|Ssam_Alienate_ID", "");
        String strprocessed = vars.getStringParameter("inpprocessed");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "939B8BFD4ABF44E08DA98CF14D273779", (("Ssam_Alienate_ID".equalsIgnoreCase("AD_Language"))?"0":strSsam_Alienate_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONCreatelineAD30C9D2251741598C27F4395FA71676")) {
        String strSsam_Alienate_ID = vars.getGlobalVariable("inpKey", windowId + "|Ssam_Alienate_ID", "");
        String strcreateline = vars.getStringParameter("inpcreateline");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "AD30C9D2251741598C27F4395FA71676", (("Ssam_Alienate_ID".equalsIgnoreCase("AD_Language"))?"0":strSsam_Alienate_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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



    } else if (vars.commandIn("BUTTONPosted")) {
        String strSsam_Alienate_ID = vars.getGlobalVariable("inpssamAlienateId", windowId + "|Ssam_Alienate_ID", "");
        String strTableId = "FC1F2D243F8D4FD1B5562F9B37CECB12";
        String strPosted = vars.getStringParameter("inpposted");
        String strProcessId = "";
        log4j.debug("Loading Posted button in table: " + strTableId);
        String strOrg = vars.getStringParameter("inpadOrgId");
        String strClient = vars.getStringParameter("inpadClientId");
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{
          vars.setSessionValue("Posted|key", strSsam_Alienate_ID);
          vars.setSessionValue("Posted|tableId", strTableId);
          vars.setSessionValue("Posted|tabId", tabId);
          vars.setSessionValue("Posted|posted", strPosted);
          vars.setSessionValue("Posted|processId", strProcessId);
          vars.setSessionValue("Posted|path", strDireccion + request.getServletPath());
          vars.setSessionValue("Posted|windowId", windowId);
          vars.setSessionValue("Posted|tabName", "AlienateAssets8378AABDDABB486585BD0470144AB669");
          response.sendRedirect(strDireccion + "/ad_actionButton/Posted.html");
        }

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

    private void printPageButtonProcessed939B8BFD4ABF44E08DA98CF14D273779(HttpServletResponse response, VariablesSecureApp vars, String strSsam_Alienate_ID, String strprocessed, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 939B8BFD4ABF44E08DA98CF14D273779");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Processed939B8BFD4ABF44E08DA98CF14D273779", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSsam_Alienate_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "AlienateAssets8378AABDDABB486585BD0470144AB669_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "939B8BFD4ABF44E08DA98CF14D273779");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("939B8BFD4ABF44E08DA98CF14D273779");
        vars.removeMessage("939B8BFD4ABF44E08DA98CF14D273779");
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
    private void printPageButtonCreatelineAD30C9D2251741598C27F4395FA71676(HttpServletResponse response, VariablesSecureApp vars, String strSsam_Alienate_ID, String strcreateline, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process AD30C9D2251741598C27F4395FA71676");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/CreatelineAD30C9D2251741598C27F4395FA71676", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSsam_Alienate_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "AlienateAssets8378AABDDABB486585BD0470144AB669_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "AD30C9D2251741598C27F4395FA71676");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("AD30C9D2251741598C27F4395FA71676");
        vars.removeMessage("AD30C9D2251741598C27F4395FA71676");
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
