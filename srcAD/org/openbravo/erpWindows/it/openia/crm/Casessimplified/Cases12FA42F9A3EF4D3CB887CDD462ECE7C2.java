
package org.openbravo.erpWindows.it.openia.crm.Casessimplified;


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
public class Cases12FA42F9A3EF4D3CB887CDD462ECE7C2 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "B914093B318E494FBE6006BE1F002265";
  private static final String tabId = "12FA42F9A3EF4D3CB887CDD462ECE7C2";
  private static final int accesslevel = 3;
  private static final String moduleId = "9FF1C0E7BAEF407EA93F0C2732F6CD11";
  
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
     
      if (command.contains("DBF26D81854746A19B1F2B1F0B4C0952")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("DBF26D81854746A19B1F2B1F0B4C0952");
        SessionInfo.setModuleId("9FF1C0E7BAEF407EA93F0C2732F6CD11");
      }
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     
      if (command.contains("6B86D15CA45A4849B1EA1D922751E292")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("6B86D15CA45A4849B1EA1D922751E292");
        SessionInfo.setModuleId("9FF1C0E7BAEF407EA93F0C2732F6CD11");
        if (securedProcess || explicitAccess.contains("6B86D15CA45A4849B1EA1D922751E292")) {
          classInfo.type = "P";
          classInfo.id = "6B86D15CA45A4849B1EA1D922751E292";
        }
      }
     

     
      if (explicitAccess.contains("DBF26D81854746A19B1F2B1F0B4C0952") || (securedProcess && command.contains("DBF26D81854746A19B1F2B1F0B4C0952"))) {
        classInfo.type = "P";
        classInfo.id = "DBF26D81854746A19B1F2B1F0B4C0952";
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

     } else if (vars.commandIn("BUTTONADD_Users6B86D15CA45A4849B1EA1D922751E292")) {
        vars.setSessionValue("button6B86D15CA45A4849B1EA1D922751E292.straddUsers", vars.getStringParameter("inpaddUsers"));
        vars.setSessionValue("button6B86D15CA45A4849B1EA1D922751E292.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button6B86D15CA45A4849B1EA1D922751E292.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button6B86D15CA45A4849B1EA1D922751E292.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button6B86D15CA45A4849B1EA1D922751E292.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "6B86D15CA45A4849B1EA1D922751E292", request.getServletPath());    
     } else if (vars.commandIn("BUTTON6B86D15CA45A4849B1EA1D922751E292")) {
        String strOpcrm_Cases_ID = vars.getGlobalVariable("inpopcrmCasesId", windowId + "|Opcrm_Cases_ID", "");
        String straddUsers = vars.getSessionValue("button6B86D15CA45A4849B1EA1D922751E292.straddUsers");
        String strProcessing = vars.getSessionValue("button6B86D15CA45A4849B1EA1D922751E292.strProcessing");
        String strOrg = vars.getSessionValue("button6B86D15CA45A4849B1EA1D922751E292.strOrg");
        String strClient = vars.getSessionValue("button6B86D15CA45A4849B1EA1D922751E292.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonADD_Users6B86D15CA45A4849B1EA1D922751E292(response, vars, strOpcrm_Cases_ID, straddUsers, strProcessing);
        }

    } else if (vars.commandIn("BUTTONSend_ButtonDBF26D81854746A19B1F2B1F0B4C0952")) {
        vars.setSessionValue("buttonDBF26D81854746A19B1F2B1F0B4C0952.strsendButton", vars.getStringParameter("inpsendButton"));
        vars.setSessionValue("buttonDBF26D81854746A19B1F2B1F0B4C0952.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonDBF26D81854746A19B1F2B1F0B4C0952.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonDBF26D81854746A19B1F2B1F0B4C0952.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonDBF26D81854746A19B1F2B1F0B4C0952.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "DBF26D81854746A19B1F2B1F0B4C0952", request.getServletPath());
      } else if (vars.commandIn("BUTTONDBF26D81854746A19B1F2B1F0B4C0952")) {
        String strOpcrm_Cases_ID = vars.getGlobalVariable("inpopcrmCasesId", windowId + "|Opcrm_Cases_ID", "");
        String strsendButton = vars.getSessionValue("buttonDBF26D81854746A19B1F2B1F0B4C0952.strsendButton");
        String strProcessing = vars.getSessionValue("buttonDBF26D81854746A19B1F2B1F0B4C0952.strProcessing");
        String strOrg = vars.getSessionValue("buttonDBF26D81854746A19B1F2B1F0B4C0952.strOrg");
        String strClient = vars.getSessionValue("buttonDBF26D81854746A19B1F2B1F0B4C0952.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonSend_ButtonDBF26D81854746A19B1F2B1F0B4C0952(response, vars, strOpcrm_Cases_ID, strsendButton, strProcessing);
        }

    } else if (vars.commandIn("SAVE_BUTTONADD_Users6B86D15CA45A4849B1EA1D922751E292")) {
        String strOpcrm_Cases_ID = vars.getGlobalVariable("inpKey", windowId + "|Opcrm_Cases_ID", "");
        String straddUsers = vars.getStringParameter("inpaddUsers");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "6B86D15CA45A4849B1EA1D922751E292", (("Opcrm_Cases_ID".equalsIgnoreCase("AD_Language"))?"0":strOpcrm_Cases_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          String stradRoleId = vars.getStringParameter("inpadRoleId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "ad_role_id", stradRoleId, vars.getClient(), vars.getOrg(), vars.getUser());

          
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

    } else if (vars.commandIn("SAVE_BUTTONSend_ButtonDBF26D81854746A19B1F2B1F0B4C0952")) {
        String strOpcrm_Cases_ID = vars.getGlobalVariable("inpKey", windowId + "|Opcrm_Cases_ID", "");
        
        ProcessBundle pb = new ProcessBundle("DBF26D81854746A19B1F2B1F0B4C0952", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("Opcrm_Cases_ID", strOpcrm_Cases_ID);
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

    private void printPageButtonADD_Users6B86D15CA45A4849B1EA1D922751E292(HttpServletResponse response, VariablesSecureApp vars, String strOpcrm_Cases_ID, String straddUsers, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 6B86D15CA45A4849B1EA1D922751E292");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ADD_Users6B86D15CA45A4849B1EA1D922751E292", discard).createXmlDocument();
      xmlDocument.setParameter("key", strOpcrm_Cases_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Cases12FA42F9A3EF4D3CB887CDD462ECE7C2_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "6B86D15CA45A4849B1EA1D922751E292");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("6B86D15CA45A4849B1EA1D922751E292");
        vars.removeMessage("6B86D15CA45A4849B1EA1D922751E292");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("ad_role_id", "");
    comboTableData = new ComboTableData(vars, this, "18", "ad_role_id", "800105", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, (FieldProvider) vars.getSessionObject("button6B86D15CA45A4849B1EA1D922751E292.originalParams"), comboTableData, windowId, "");
    xmlDocument.setData("reportad_role_id", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      
      out.println(xmlDocument.print());
      out.close();
    }


    void printPageButtonSend_ButtonDBF26D81854746A19B1F2B1F0B4C0952(HttpServletResponse response, VariablesSecureApp vars, String strOpcrm_Cases_ID, String strsendButton, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process DBF26D81854746A19B1F2B1F0B4C0952");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Send_ButtonDBF26D81854746A19B1F2B1F0B4C0952", discard).createXmlDocument();
      xmlDocument.setParameter("key", strOpcrm_Cases_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Cases12FA42F9A3EF4D3CB887CDD462ECE7C2_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "DBF26D81854746A19B1F2B1F0B4C0952");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("DBF26D81854746A19B1F2B1F0B4C0952");
        vars.removeMessage("DBF26D81854746A19B1F2B1F0B4C0952");
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
