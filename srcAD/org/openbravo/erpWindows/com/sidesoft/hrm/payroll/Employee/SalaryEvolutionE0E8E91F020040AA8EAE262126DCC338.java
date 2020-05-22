
package org.openbravo.erpWindows.com.sidesoft.hrm.payroll.Employee;


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
public class SalaryEvolutionE0E8E91F020040AA8EAE262126DCC338 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "DB061BED6348461D9D11D24699BDF566";
  private static final String tabId = "E0E8E91F020040AA8EAE262126DCC338";
  private static final int accesslevel = 3;
  private static final String moduleId = "87126CADE0354F8490DC55FE7C35EB88";
  
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
     
      if (command.contains("7B9E55D77FAA49B988FB1D889DD7CC9A")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("7B9E55D77FAA49B988FB1D889DD7CC9A");
        SessionInfo.setModuleId("87126CADE0354F8490DC55FE7C35EB88");
        if (securedProcess || explicitAccess.contains("7B9E55D77FAA49B988FB1D889DD7CC9A")) {
          classInfo.type = "P";
          classInfo.id = "7B9E55D77FAA49B988FB1D889DD7CC9A";
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

     } else if (vars.commandIn("BUTTONExpire7B9E55D77FAA49B988FB1D889DD7CC9A")) {
        vars.setSessionValue("button7B9E55D77FAA49B988FB1D889DD7CC9A.strexpire", vars.getStringParameter("inpexpire"));
        vars.setSessionValue("button7B9E55D77FAA49B988FB1D889DD7CC9A.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button7B9E55D77FAA49B988FB1D889DD7CC9A.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button7B9E55D77FAA49B988FB1D889DD7CC9A.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button7B9E55D77FAA49B988FB1D889DD7CC9A.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "7B9E55D77FAA49B988FB1D889DD7CC9A", request.getServletPath());    
     } else if (vars.commandIn("BUTTON7B9E55D77FAA49B988FB1D889DD7CC9A")) {
        String strSfpr_Evolution_Salary_ID = vars.getGlobalVariable("inpsfprEvolutionSalaryId", windowId + "|Sfpr_Evolution_Salary_ID", "");
        String strexpire = vars.getSessionValue("button7B9E55D77FAA49B988FB1D889DD7CC9A.strexpire");
        String strProcessing = vars.getSessionValue("button7B9E55D77FAA49B988FB1D889DD7CC9A.strProcessing");
        String strOrg = vars.getSessionValue("button7B9E55D77FAA49B988FB1D889DD7CC9A.strOrg");
        String strClient = vars.getSessionValue("button7B9E55D77FAA49B988FB1D889DD7CC9A.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonExpire7B9E55D77FAA49B988FB1D889DD7CC9A(response, vars, strSfpr_Evolution_Salary_ID, strexpire, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONExpire7B9E55D77FAA49B988FB1D889DD7CC9A")) {
        String strSfpr_Evolution_Salary_ID = vars.getGlobalVariable("inpKey", windowId + "|Sfpr_Evolution_Salary_ID", "");
        String strexpire = vars.getStringParameter("inpexpire");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "7B9E55D77FAA49B988FB1D889DD7CC9A", (("Sfpr_Evolution_Salary_ID".equalsIgnoreCase("AD_Language"))?"0":strSfpr_Evolution_Salary_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    private void printPageButtonExpire7B9E55D77FAA49B988FB1D889DD7CC9A(HttpServletResponse response, VariablesSecureApp vars, String strSfpr_Evolution_Salary_ID, String strexpire, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 7B9E55D77FAA49B988FB1D889DD7CC9A");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Expire7B9E55D77FAA49B988FB1D889DD7CC9A", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSfpr_Evolution_Salary_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "SalaryEvolutionE0E8E91F020040AA8EAE262126DCC338_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "7B9E55D77FAA49B988FB1D889DD7CC9A");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("7B9E55D77FAA49B988FB1D889DD7CC9A");
        vars.removeMessage("7B9E55D77FAA49B988FB1D889DD7CC9A");
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
