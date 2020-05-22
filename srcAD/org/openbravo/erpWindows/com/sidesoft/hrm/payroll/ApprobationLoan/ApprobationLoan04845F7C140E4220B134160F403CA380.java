
package org.openbravo.erpWindows.com.sidesoft.hrm.payroll.ApprobationLoan;


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
public class ApprobationLoan04845F7C140E4220B134160F403CA380 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "46823D326B7044E58ABA3B846E703527";
  private static final String tabId = "04845F7C140E4220B134160F403CA380";
  private static final int accesslevel = 3;
  private static final String moduleId = "169A6DDBFEB948C98F0617CE3B4CABD5";
  
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
     
      if (command.contains("82280D46D0A84A0FB03838F070BDECFC")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("82280D46D0A84A0FB03838F070BDECFC");
        SessionInfo.setModuleId("169A6DDBFEB948C98F0617CE3B4CABD5");
        if (securedProcess || explicitAccess.contains("82280D46D0A84A0FB03838F070BDECFC")) {
          classInfo.type = "P";
          classInfo.id = "82280D46D0A84A0FB03838F070BDECFC";
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

     } else if (vars.commandIn("BUTTONCompletestatus_Approve82280D46D0A84A0FB03838F070BDECFC")) {
        vars.setSessionValue("button82280D46D0A84A0FB03838F070BDECFC.strcompletestatusApprove", vars.getStringParameter("inpcompletestatusApprove"));
        vars.setSessionValue("button82280D46D0A84A0FB03838F070BDECFC.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button82280D46D0A84A0FB03838F070BDECFC.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button82280D46D0A84A0FB03838F070BDECFC.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button82280D46D0A84A0FB03838F070BDECFC.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "82280D46D0A84A0FB03838F070BDECFC", request.getServletPath());    
     } else if (vars.commandIn("BUTTON82280D46D0A84A0FB03838F070BDECFC")) {
        String strSspr_Loans_ID = vars.getGlobalVariable("inpssprLoansId", windowId + "|Sspr_Loans_ID", "");
        String strcompletestatusApprove = vars.getSessionValue("button82280D46D0A84A0FB03838F070BDECFC.strcompletestatusApprove");
        String strProcessing = vars.getSessionValue("button82280D46D0A84A0FB03838F070BDECFC.strProcessing");
        String strOrg = vars.getSessionValue("button82280D46D0A84A0FB03838F070BDECFC.strOrg");
        String strClient = vars.getSessionValue("button82280D46D0A84A0FB03838F070BDECFC.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonCompletestatus_Approve82280D46D0A84A0FB03838F070BDECFC(response, vars, strSspr_Loans_ID, strcompletestatusApprove, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONCompletestatus_Approve82280D46D0A84A0FB03838F070BDECFC")) {
        String strSspr_Loans_ID = vars.getGlobalVariable("inpKey", windowId + "|Sspr_Loans_ID", "");
        String strcompletestatusApprove = vars.getStringParameter("inpcompletestatusApprove");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "82280D46D0A84A0FB03838F070BDECFC", (("Sspr_Loans_ID".equalsIgnoreCase("AD_Language"))?"0":strSspr_Loans_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          String strstatusdoc = vars.getStringParameter("inpstatusdoc");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "statusdoc", strstatusdoc, vars.getClient(), vars.getOrg(), vars.getUser());

          
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

    private void printPageButtonCompletestatus_Approve82280D46D0A84A0FB03838F070BDECFC(HttpServletResponse response, VariablesSecureApp vars, String strSspr_Loans_ID, String strcompletestatusApprove, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 82280D46D0A84A0FB03838F070BDECFC");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Completestatus_Approve82280D46D0A84A0FB03838F070BDECFC", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSspr_Loans_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "ApprobationLoan04845F7C140E4220B134160F403CA380_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "82280D46D0A84A0FB03838F070BDECFC");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("82280D46D0A84A0FB03838F070BDECFC");
        vars.removeMessage("82280D46D0A84A0FB03838F070BDECFC");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("statusdoc", "");
    comboTableData = new ComboTableData(vars, this, "17", "statusdoc", "9F8E4CDDDB8B4AB19A1267AB5FEB018D", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, (FieldProvider) vars.getSessionObject("button82280D46D0A84A0FB03838F070BDECFC.originalParams"), comboTableData, windowId, "");
    xmlDocument.setData("reportstatusdoc", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      
      out.println(xmlDocument.print());
      out.close();
    }



}
