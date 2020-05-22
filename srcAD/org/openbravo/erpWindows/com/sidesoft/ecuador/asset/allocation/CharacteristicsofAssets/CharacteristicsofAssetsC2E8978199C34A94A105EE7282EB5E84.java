
package org.openbravo.erpWindows.com.sidesoft.ecuador.asset.allocation.CharacteristicsofAssets;


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
public class CharacteristicsofAssetsC2E8978199C34A94A105EE7282EB5E84 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "46C41886EF63481F80BD345D36151BB1";
  private static final String tabId = "C2E8978199C34A94A105EE7282EB5E84";
  private static final int accesslevel = 1;
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
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     
      if (command.contains("B8BE8149426647D9AD9333D481F701BF")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("B8BE8149426647D9AD9333D481F701BF");
        SessionInfo.setModuleId("1718FB3B55584F899FEEBF24BFF807AF");
        if (securedProcess || explicitAccess.contains("B8BE8149426647D9AD9333D481F701BF")) {
          classInfo.type = "P";
          classInfo.id = "B8BE8149426647D9AD9333D481F701BF";
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

     } else if (vars.commandIn("BUTTONEM_Ssal_LowprocessB8BE8149426647D9AD9333D481F701BF")) {
        vars.setSessionValue("buttonB8BE8149426647D9AD9333D481F701BF.stremSsalLowprocess", vars.getStringParameter("inpemSsalLowprocess"));
        vars.setSessionValue("buttonB8BE8149426647D9AD9333D481F701BF.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonB8BE8149426647D9AD9333D481F701BF.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonB8BE8149426647D9AD9333D481F701BF.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonB8BE8149426647D9AD9333D481F701BF.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "B8BE8149426647D9AD9333D481F701BF", request.getServletPath());    
     } else if (vars.commandIn("BUTTONB8BE8149426647D9AD9333D481F701BF")) {
        String strA_Asset_ID = vars.getGlobalVariable("inpaAssetId", windowId + "|A_Asset_ID", "");
        String stremSsalLowprocess = vars.getSessionValue("buttonB8BE8149426647D9AD9333D481F701BF.stremSsalLowprocess");
        String strProcessing = vars.getSessionValue("buttonB8BE8149426647D9AD9333D481F701BF.strProcessing");
        String strOrg = vars.getSessionValue("buttonB8BE8149426647D9AD9333D481F701BF.strOrg");
        String strClient = vars.getSessionValue("buttonB8BE8149426647D9AD9333D481F701BF.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Ssal_LowprocessB8BE8149426647D9AD9333D481F701BF(response, vars, strA_Asset_ID, stremSsalLowprocess, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONEM_Ssal_LowprocessB8BE8149426647D9AD9333D481F701BF")) {
        String strA_Asset_ID = vars.getGlobalVariable("inpKey", windowId + "|A_Asset_ID", "");
        String stremSsalLowprocess = vars.getStringParameter("inpemSsalLowprocess");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "B8BE8149426647D9AD9333D481F701BF", (("A_Asset_ID".equalsIgnoreCase("AD_Language"))?"0":strA_Asset_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    private void printPageButtonEM_Ssal_LowprocessB8BE8149426647D9AD9333D481F701BF(HttpServletResponse response, VariablesSecureApp vars, String strA_Asset_ID, String stremSsalLowprocess, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process B8BE8149426647D9AD9333D481F701BF");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Ssal_LowprocessB8BE8149426647D9AD9333D481F701BF", discard).createXmlDocument();
      xmlDocument.setParameter("key", strA_Asset_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "CharacteristicsofAssetsC2E8978199C34A94A105EE7282EB5E84_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "B8BE8149426647D9AD9333D481F701BF");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("B8BE8149426647D9AD9333D481F701BF");
        vars.removeMessage("B8BE8149426647D9AD9333D481F701BF");
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
