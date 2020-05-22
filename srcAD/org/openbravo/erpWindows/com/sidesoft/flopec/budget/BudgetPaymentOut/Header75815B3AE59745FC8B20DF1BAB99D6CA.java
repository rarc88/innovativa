
package org.openbravo.erpWindows.com.sidesoft.flopec.budget.BudgetPaymentOut;


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
public class Header75815B3AE59745FC8B20DF1BAB99D6CA extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "5BE1F75DD7234788AEA37D254B6769F7";
  private static final String tabId = "75815B3AE59745FC8B20DF1BAB99D6CA";
  private static final int accesslevel = 1;
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
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     
      if (command.contains("1461598AD3FC4C0B841E1922ED08F653")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("1461598AD3FC4C0B841E1922ED08F653");
        SessionInfo.setModuleId("75856ABEF4614636A5FABB70AD0CD4C8");
        if (securedProcess || explicitAccess.contains("1461598AD3FC4C0B841E1922ED08F653")) {
          classInfo.type = "P";
          classInfo.id = "1461598AD3FC4C0B841E1922ED08F653";
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

     } else if (vars.commandIn("BUTTONEM_Sfb_Process1461598AD3FC4C0B841E1922ED08F653")) {
        vars.setSessionValue("button1461598AD3FC4C0B841E1922ED08F653.stremSfbProcess", vars.getStringParameter("inpemSfbProcess"));
        vars.setSessionValue("button1461598AD3FC4C0B841E1922ED08F653.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button1461598AD3FC4C0B841E1922ED08F653.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button1461598AD3FC4C0B841E1922ED08F653.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button1461598AD3FC4C0B841E1922ED08F653.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "1461598AD3FC4C0B841E1922ED08F653", request.getServletPath());    
     } else if (vars.commandIn("BUTTON1461598AD3FC4C0B841E1922ED08F653")) {
        String strFin_Payment_ID = vars.getGlobalVariable("inpfinPaymentId", windowId + "|Fin_Payment_ID", "");
        String stremSfbProcess = vars.getSessionValue("button1461598AD3FC4C0B841E1922ED08F653.stremSfbProcess");
        String strProcessing = vars.getSessionValue("button1461598AD3FC4C0B841E1922ED08F653.strProcessing");
        String strOrg = vars.getSessionValue("button1461598AD3FC4C0B841E1922ED08F653.strOrg");
        String strClient = vars.getSessionValue("button1461598AD3FC4C0B841E1922ED08F653.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Sfb_Process1461598AD3FC4C0B841E1922ED08F653(response, vars, strFin_Payment_ID, stremSfbProcess, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONEM_Sfb_Process1461598AD3FC4C0B841E1922ED08F653")) {
        String strFin_Payment_ID = vars.getGlobalVariable("inpKey", windowId + "|Fin_Payment_ID", "");
        String stremSfbProcess = vars.getStringParameter("inpemSfbProcess");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "1461598AD3FC4C0B841E1922ED08F653", (("Fin_Payment_ID".equalsIgnoreCase("AD_Language"))?"0":strFin_Payment_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
        String strFin_Payment_ID = vars.getGlobalVariable("inpfinPaymentId", windowId + "|Fin_Payment_ID", "");
        String strTableId = "D1A97202E832470285C9B1EB026D54E2";
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
          vars.setSessionValue("Posted|key", strFin_Payment_ID);
          vars.setSessionValue("Posted|tableId", strTableId);
          vars.setSessionValue("Posted|tabId", tabId);
          vars.setSessionValue("Posted|posted", strPosted);
          vars.setSessionValue("Posted|processId", strProcessId);
          vars.setSessionValue("Posted|path", strDireccion + request.getServletPath());
          vars.setSessionValue("Posted|windowId", windowId);
          vars.setSessionValue("Posted|tabName", "Header75815B3AE59745FC8B20DF1BAB99D6CA");
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

    private void printPageButtonEM_Sfb_Process1461598AD3FC4C0B841E1922ED08F653(HttpServletResponse response, VariablesSecureApp vars, String strFin_Payment_ID, String stremSfbProcess, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 1461598AD3FC4C0B841E1922ED08F653");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Sfb_Process1461598AD3FC4C0B841E1922ED08F653", discard).createXmlDocument();
      xmlDocument.setParameter("key", strFin_Payment_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Header75815B3AE59745FC8B20DF1BAB99D6CA_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "1461598AD3FC4C0B841E1922ED08F653");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("1461598AD3FC4C0B841E1922ED08F653");
        vars.removeMessage("1461598AD3FC4C0B841E1922ED08F653");
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
