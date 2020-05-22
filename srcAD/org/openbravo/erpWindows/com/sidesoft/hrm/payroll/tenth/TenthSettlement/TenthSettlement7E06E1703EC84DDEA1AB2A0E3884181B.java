
package org.openbravo.erpWindows.com.sidesoft.hrm.payroll.tenth.TenthSettlement;


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
public class TenthSettlement7E06E1703EC84DDEA1AB2A0E3884181B extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "0B869CDD039E4358AEF6C6E62DD36A74";
  private static final String tabId = "7E06E1703EC84DDEA1AB2A0E3884181B";
  private static final int accesslevel = 7;
  private static final String moduleId = "913FE64FE6F74E51A6929D2A21460CFB";
  
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
     
      if (command.contains("23C07ADC56F24E1992291A868CE5D654")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("23C07ADC56F24E1992291A868CE5D654");
        SessionInfo.setModuleId("913FE64FE6F74E51A6929D2A21460CFB");
        if (securedProcess || explicitAccess.contains("23C07ADC56F24E1992291A868CE5D654")) {
          classInfo.type = "P";
          classInfo.id = "23C07ADC56F24E1992291A868CE5D654";
        }
      }
     
      if (command.contains("A74312D2CAE84C29A4731D7DD9736E46")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("A74312D2CAE84C29A4731D7DD9736E46");
        SessionInfo.setModuleId("913FE64FE6F74E51A6929D2A21460CFB");
        if (securedProcess || explicitAccess.contains("A74312D2CAE84C29A4731D7DD9736E46")) {
          classInfo.type = "P";
          classInfo.id = "A74312D2CAE84C29A4731D7DD9736E46";
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

     } else if (vars.commandIn("BUTTONCreatelines23C07ADC56F24E1992291A868CE5D654")) {
        vars.setSessionValue("button23C07ADC56F24E1992291A868CE5D654.strcreatelines", vars.getStringParameter("inpcreatelines"));
        vars.setSessionValue("button23C07ADC56F24E1992291A868CE5D654.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button23C07ADC56F24E1992291A868CE5D654.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button23C07ADC56F24E1992291A868CE5D654.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button23C07ADC56F24E1992291A868CE5D654.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "23C07ADC56F24E1992291A868CE5D654", request.getServletPath());    
     } else if (vars.commandIn("BUTTON23C07ADC56F24E1992291A868CE5D654")) {
        String strSsph_Tenth_Settlement_ID = vars.getGlobalVariable("inpssphTenthSettlementId", windowId + "|Ssph_Tenth_Settlement_ID", "");
        String strcreatelines = vars.getSessionValue("button23C07ADC56F24E1992291A868CE5D654.strcreatelines");
        String strProcessing = vars.getSessionValue("button23C07ADC56F24E1992291A868CE5D654.strProcessing");
        String strOrg = vars.getSessionValue("button23C07ADC56F24E1992291A868CE5D654.strOrg");
        String strClient = vars.getSessionValue("button23C07ADC56F24E1992291A868CE5D654.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonCreatelines23C07ADC56F24E1992291A868CE5D654(response, vars, strSsph_Tenth_Settlement_ID, strcreatelines, strProcessing);
        }

     } else if (vars.commandIn("BUTTONProcessedA74312D2CAE84C29A4731D7DD9736E46")) {
        vars.setSessionValue("buttonA74312D2CAE84C29A4731D7DD9736E46.strprocessed", vars.getStringParameter("inpprocessed"));
        vars.setSessionValue("buttonA74312D2CAE84C29A4731D7DD9736E46.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonA74312D2CAE84C29A4731D7DD9736E46.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonA74312D2CAE84C29A4731D7DD9736E46.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonA74312D2CAE84C29A4731D7DD9736E46.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "A74312D2CAE84C29A4731D7DD9736E46", request.getServletPath());    
     } else if (vars.commandIn("BUTTONA74312D2CAE84C29A4731D7DD9736E46")) {
        String strSsph_Tenth_Settlement_ID = vars.getGlobalVariable("inpssphTenthSettlementId", windowId + "|Ssph_Tenth_Settlement_ID", "");
        String strprocessed = vars.getSessionValue("buttonA74312D2CAE84C29A4731D7DD9736E46.strprocessed");
        String strProcessing = vars.getSessionValue("buttonA74312D2CAE84C29A4731D7DD9736E46.strProcessing");
        String strOrg = vars.getSessionValue("buttonA74312D2CAE84C29A4731D7DD9736E46.strOrg");
        String strClient = vars.getSessionValue("buttonA74312D2CAE84C29A4731D7DD9736E46.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcessedA74312D2CAE84C29A4731D7DD9736E46(response, vars, strSsph_Tenth_Settlement_ID, strprocessed, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONCreatelines23C07ADC56F24E1992291A868CE5D654")) {
        String strSsph_Tenth_Settlement_ID = vars.getGlobalVariable("inpKey", windowId + "|Ssph_Tenth_Settlement_ID", "");
        String strcreatelines = vars.getStringParameter("inpcreatelines");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "23C07ADC56F24E1992291A868CE5D654", (("Ssph_Tenth_Settlement_ID".equalsIgnoreCase("AD_Language"))?"0":strSsph_Tenth_Settlement_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONProcessedA74312D2CAE84C29A4731D7DD9736E46")) {
        String strSsph_Tenth_Settlement_ID = vars.getGlobalVariable("inpKey", windowId + "|Ssph_Tenth_Settlement_ID", "");
        String strprocessed = vars.getStringParameter("inpprocessed");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "A74312D2CAE84C29A4731D7DD9736E46", (("Ssph_Tenth_Settlement_ID".equalsIgnoreCase("AD_Language"))?"0":strSsph_Tenth_Settlement_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    private void printPageButtonCreatelines23C07ADC56F24E1992291A868CE5D654(HttpServletResponse response, VariablesSecureApp vars, String strSsph_Tenth_Settlement_ID, String strcreatelines, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 23C07ADC56F24E1992291A868CE5D654");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Createlines23C07ADC56F24E1992291A868CE5D654", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSsph_Tenth_Settlement_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "TenthSettlement7E06E1703EC84DDEA1AB2A0E3884181B_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "23C07ADC56F24E1992291A868CE5D654");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("23C07ADC56F24E1992291A868CE5D654");
        vars.removeMessage("23C07ADC56F24E1992291A868CE5D654");
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
    private void printPageButtonProcessedA74312D2CAE84C29A4731D7DD9736E46(HttpServletResponse response, VariablesSecureApp vars, String strSsph_Tenth_Settlement_ID, String strprocessed, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process A74312D2CAE84C29A4731D7DD9736E46");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ProcessedA74312D2CAE84C29A4731D7DD9736E46", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSsph_Tenth_Settlement_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "TenthSettlement7E06E1703EC84DDEA1AB2A0E3884181B_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "A74312D2CAE84C29A4731D7DD9736E46");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("A74312D2CAE84C29A4731D7DD9736E46");
        vars.removeMessage("A74312D2CAE84C29A4731D7DD9736E46");
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
