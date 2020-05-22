
package org.openbravo.erpCommon.ad_actionButton;


import org.openbravo.erpCommon.utility.*;
import org.openbravo.erpCommon.reference.*;
import org.openbravo.utils.Replace;
import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.scheduling.ProcessRunner;
import org.openbravo.xmlEngine.XmlDocument;
import org.openbravo.database.SessionInfo;
import org.openbravo.erpCommon.obps.ActivationKey;
import org.openbravo.erpCommon.obps.ActivationKey.FeatureRestriction;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBDal;
import org.openbravo.model.ad.ui.Process;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.HashMap;

@SuppressWarnings("unused")
public class ActionButtonJava_Responser extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  protected static final String windowId = "ActionButtonResponser";
  
  public void init (ServletConfig config) {
    super.init(config);
    boolHist = false;
  }

  @Override
  public void service(HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
    VariablesSecureApp vars = new VariablesSecureApp(request);
    String strProcessId = getProcessId(vars);

    // set process type and id for audit
    SessionInfo.setProcessType("P");
    SessionInfo.setProcessId(strProcessId);
    SessionInfo.setUserId(vars.getSessionValue("#AD_User_ID"));
    SessionInfo.setSessionId(vars.getSessionValue("#AD_Session_ID"));
    SessionInfo.setQueryProfile("manualProcess");

    try {
      OBContext.setAdminMode();
      Process process = OBDal.getInstance().get(Process.class, strProcessId);
      if (process != null) {
        SessionInfo.setModuleId(process.getModule().getId());
      }
    } finally {
      OBContext.restorePreviousMode();
    }
    super.service(request, response);
  }

  private String getProcessId(VariablesSecureApp vars) throws ServletException {
    String command = vars.getCommand();
    if (command.equals("DEFAULT")) {
      return vars.getRequiredStringParameter("inpadProcessId");
    } else if (command.startsWith("BUTTON")) {
      return command.substring("BUTTON".length());
    } else if (command.startsWith("FRAMES")) {
      return command.substring("FRAMES".length());
    } else if (command.startsWith("SAVE_BUTTONActionButton")) {
      return command.substring("SAVE_BUTTONActionButton".length());
    }
    return null;
  }

  public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
    VariablesSecureApp vars = new VariablesSecureApp(request);
    String strProcessId = getProcessId(vars);
    
    if (vars.getCommand().startsWith("FRAMES")) {
      printPageFrames(response, vars, strProcessId);
    }
   
    if (!vars.commandIn("DEFAULT")) {
      //Check access
      FeatureRestriction featureRestriction = ActivationKey.getInstance().hasLicenseAccess("P",
          strProcessId);
      if (featureRestriction != FeatureRestriction.NO_RESTRICTION) {
        licenseError("P", strProcessId, featureRestriction, response, request, vars, true);
      }
      if (!hasGeneralAccess(vars, "P", strProcessId)) {
        bdErrorGeneralPopUp(request, response,
            Utility.messageBD(this, "Error", vars.getLanguage()), Utility.messageBD(this,
                "AccessTableNoView", vars.getLanguage()));
      }
    }
    
      
    if (vars.commandIn("DEFAULT")) {
      printPageDefault(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON9DB4D30BFC5144B9B431CB49DDE9270D")) {
        
        printPageButton9DB4D30BFC5144B9B431CB49DDE9270D(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON7CB6B4D1ECCF4036B3F111D2CF11AADE")) {
        
        printPageButton7CB6B4D1ECCF4036B3F111D2CF11AADE(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON970EAD9B846648A7AB1F0CCA5058356C")) {
        
        printPageButton970EAD9B846648A7AB1F0CCA5058356C(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON7EDBFEC35BDA4FF4AF05ED516CDAFB90")) {
        
        printPageButton7EDBFEC35BDA4FF4AF05ED516CDAFB90(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONABDFC8131D964936AD2EF7E0CED97FD9")) {
        
        printPageButtonABDFC8131D964936AD2EF7E0CED97FD9(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON3C386BC12832466790E50F2F8C5EBD85")) {
        
        printPageButton3C386BC12832466790E50F2F8C5EBD85(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONEFDBF909811544DAAE4E876AA781E5DC")) {
        
        printPageButtonEFDBF909811544DAAE4E876AA781E5DC(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON107")) {
        
        printPageButton107(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONCD7283DF804B449C97DA09446669EEEF")) {
        
        printPageButtonCD7283DF804B449C97DA09446669EEEF(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON85601427EAEE401FA0250FF0A6DD62EF")) {
        
        printPageButton85601427EAEE401FA0250FF0A6DD62EF(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONA3FE1F9892394386A49FB707AA50A0FA")) {
        
        printPageButtonA3FE1F9892394386A49FB707AA50A0FA(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON136")) {
        
        printPageButton136(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONFB740AB61B0E42B198D2C88D3A0D0CE6")) {
        
        printPageButtonFB740AB61B0E42B198D2C88D3A0D0CE6(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON58591E3E0F7648E4A09058E037CE49FC")) {
        
        printPageButton58591E3E0F7648E4A09058E037CE49FC(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON23D1B163EC0B41F790CE39BF01DA320E")) {
        
        printPageButton23D1B163EC0B41F790CE39BF01DA320E(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON6FBD65B0FDB74D1AB07F0EADF18D48AE")) {
        
        printPageButton6FBD65B0FDB74D1AB07F0EADF18D48AE(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON9EB2228A60684C0DBEC12D5CD8D85218")) {
        
        printPageButton9EB2228A60684C0DBEC12D5CD8D85218(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTOND85D5B5E368A49B1A6293BA4AE15F0F9")) {
        
        printPageButtonD85D5B5E368A49B1A6293BA4AE15F0F9(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONFF80808133362F6A013336781FCE0066")) {
        
        printPageButtonFF80808133362F6A013336781FCE0066(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONFF8081813219E68E013219ECFE930004")) {
        
        printPageButtonFF8081813219E68E013219ECFE930004(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONFF808181324D007801324D2AE1130066")) {
        
        printPageButtonFF808181324D007801324D2AE1130066(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONFF808181326CD80501326CE906D70042")) {
        
        printPageButtonFF808181326CD80501326CE906D70042(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON6BF16EFC772843AC9A17552AE0B26AB7")) {
        
        printPageButton6BF16EFC772843AC9A17552AE0B26AB7(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON0BDC2164ED3E48539FCEF4D306F29EFD")) {
        
        printPageButton0BDC2164ED3E48539FCEF4D306F29EFD(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON5BE14AA10165490A9ADEFB7532F7FA94")) {
        
        printPageButton5BE14AA10165490A9ADEFB7532F7FA94(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON15C8708DFC464C2D91286E59624FDD18")) {
        
        printPageButton15C8708DFC464C2D91286E59624FDD18(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON017312F51139438A9665775E3B5392A1")) {
        
        printPageButton017312F51139438A9665775E3B5392A1(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON6255BE488882480599C81284B70CD9B3")) {
        
        printPageButton6255BE488882480599C81284B70CD9B3(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONF68F2890E96D4D85A1DEF0274D105BCE")) {
        
        printPageButtonF68F2890E96D4D85A1DEF0274D105BCE(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON29D17F515727436DBCE32BC6CA28382B")) {
        
        printPageButton29D17F515727436DBCE32BC6CA28382B(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONDE1B382FDD2540199D223586F6E216D0")) {
        
        printPageButtonDE1B382FDD2540199D223586F6E216D0(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTOND16966FBF9604A3D91A50DC83C6EA8E3")) {
        
        printPageButtonD16966FBF9604A3D91A50DC83C6EA8E3(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONFF8080812E2F8EAE012E2F94CF470014")) {
        
        printPageButtonFF8080812E2F8EAE012E2F94CF470014(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONFF8080812F348A97012F349DC24F0007")) {
        
        printPageButtonFF8080812F348A97012F349DC24F0007(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONFF80818132A4F6AD0132A573DD7A0021")) {
        
        printPageButtonFF80818132A4F6AD0132A573DD7A0021(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON006D8983826D47F4A7065566788F93E8")) {
        
        printPageButton006D8983826D47F4A7065566788F93E8(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON928A4483850046239A217B445A680E29")) {
        
        printPageButton928A4483850046239A217B445A680E29(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON9E6670BCC807442BB3B98432993F79A8")) {
        
        printPageButton9E6670BCC807442BB3B98432993F79A8(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTOND10230FC59154A12ABC9FA6B4A9E4080")) {
        
        printPageButtonD10230FC59154A12ABC9FA6B4A9E4080(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON9E930637C9B44A73B0227D49AA30DD12")) {
        
        printPageButton9E930637C9B44A73B0227D49AA30DD12(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON7D052DBDB45F45648373F2064BECD521")) {
        
        printPageButton7D052DBDB45F45648373F2064BECD521(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON5AC5C4C39A8F4A37B6098A0512288889")) {
        
        printPageButton5AC5C4C39A8F4A37B6098A0512288889(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON72380902AAEC47B4A493717B4D504E9E")) {
        
        printPageButton72380902AAEC47B4A493717B4D504E9E(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON5FE514F293DB458DAC6DC79C4FE83A8D")) {
        
        printPageButton5FE514F293DB458DAC6DC79C4FE83A8D(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON98EC8B6FBAC145CA926C4740A2C2B6FF")) {
        
        printPageButton98EC8B6FBAC145CA926C4740A2C2B6FF(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON3A53E5B4438A432EA7F48FD4A4FB9992")) {
        
        printPageButton3A53E5B4438A432EA7F48FD4A4FB9992(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONED5960492A2C41929D59442D2C38F174")) {
        
        printPageButtonED5960492A2C41929D59442D2C38F174(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON6267329F022A4993A79776EEC7F2882F")) {
        
        printPageButton6267329F022A4993A79776EEC7F2882F(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON9337D1CEEC0647B888EC257259F025B2")) {
        
        printPageButton9337D1CEEC0647B888EC257259F025B2(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON8483E826BD4A4F4FABE988B7EE7193EC")) {
        
        printPageButton8483E826BD4A4F4FABE988B7EE7193EC(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONDD60049F200E490BA823A5B3532F57B4")) {
        
        printPageButtonDD60049F200E490BA823A5B3532F57B4(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON418D9416C62B4087BE59A1B358910954")) {
        
        printPageButton418D9416C62B4087BE59A1B358910954(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON0AF06FA75CC348D98ECBD5FFFEF79330")) {
        
        printPageButton0AF06FA75CC348D98ECBD5FFFEF79330(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON4FB68828FA684DAAA1478926ED32B84C")) {
        
        printPageButton4FB68828FA684DAAA1478926ED32B84C(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON05E6E7C50BE3447392C9BC02EB86500D")) {
        
        printPageButton05E6E7C50BE3447392C9BC02EB86500D(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONA1A4F42146B44313A85BAC9499EC15CE")) {
        
        printPageButtonA1A4F42146B44313A85BAC9499EC15CE(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONEF5BF59C53944CB6BBE5A6A4CACE7926")) {
        
        printPageButtonEF5BF59C53944CB6BBE5A6A4CACE7926(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON71146C7A96774E58A772B98A8B1C6953")) {
        
        printPageButton71146C7A96774E58A772B98A8B1C6953(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON1D419EB151AE45A9A5C8B86371B9818A")) {
        
        printPageButton1D419EB151AE45A9A5C8B86371B9818A(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON6AA269C7FB70428AB269794614AD4742")) {
        
        printPageButton6AA269C7FB70428AB269794614AD4742(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONEBCCB232196040B294F2E29F1846F9AC")) {
        
        printPageButtonEBCCB232196040B294F2E29F1846F9AC(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON4380C4EBA98A4E7EB784ABC1360FE8EA")) {
        
        printPageButton4380C4EBA98A4E7EB784ABC1360FE8EA(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON437B1EE180984960A698FB8154DE5D35")) {
        
        printPageButton437B1EE180984960A698FB8154DE5D35(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON837888BA221D47E6915FDE6DD361C1D9")) {
        
        printPageButton837888BA221D47E6915FDE6DD361C1D9(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON177A8D600E334A188E193EC8C647AED0")) {
        
        printPageButton177A8D600E334A188E193EC8C647AED0(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON6F5F5FCC3C124629A02179A1D55DB636")) {
        
        printPageButton6F5F5FCC3C124629A02179A1D55DB636(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON3FAE7B1AB61F4E61B67481247AE8215F")) {
        
        printPageButton3FAE7B1AB61F4E61B67481247AE8215F(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON7CC8083871A2456BAC7B948F3510BC3C")) {
        
        printPageButton7CC8083871A2456BAC7B948F3510BC3C(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON8388633AADD04FC487A0AEA775448333")) {
        
        printPageButton8388633AADD04FC487A0AEA775448333(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONCD35DC8F54624AC0948C891C7F7E70A1")) {
        
        printPageButtonCD35DC8F54624AC0948C891C7F7E70A1(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTOND93CCE4D4D954542BD7AA2F107404BAD")) {
        
        printPageButtonD93CCE4D4D954542BD7AA2F107404BAD(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON2DDE7D3618034C38A4462B7F3456C28D")) {
        
        printPageButton2DDE7D3618034C38A4462B7F3456C28D(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON58A9261BACEF45DDA526F29D8557272D")) {
        
        printPageButton58A9261BACEF45DDA526F29D8557272D(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON64B3FF29AC174F4B94538BD0A3CE1CD3")) {
        
        printPageButton64B3FF29AC174F4B94538BD0A3CE1CD3(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON5192F005F0524EE1A59AD3DCA8CDF4A3")) {
        
        printPageButton5192F005F0524EE1A59AD3DCA8CDF4A3(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON9ADF860D48FF43788F60A062258492A0")) {
        
        printPageButton9ADF860D48FF43788F60A062258492A0(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON0A94232190EE46A2B4D13CBF30C8F423")) {
        
        printPageButton0A94232190EE46A2B4D13CBF30C8F423(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONDBF26D81854746A19B1F2B1F0B4C0952")) {
        
        printPageButtonDBF26D81854746A19B1F2B1F0B4C0952(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTONB5C20B60DD3F4B4D93442FB7BE2DA6EA")) {
        
        printPageButtonB5C20B60DD3F4B4D93442FB7BE2DA6EA(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON77FC3840AB4A4814B8247BA69B484F87")) {
        
        printPageButton77FC3840AB4A4814B8247BA69B484F87(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON0A7A590F8CF641B4B63AD85D83D5FD63")) {
        
        printPageButton0A7A590F8CF641B4B63AD85D83D5FD63(response, vars, strProcessId);
    } else if (vars.commandIn("BUTTON66912CD2D96B494FA23F4AF2B7F795BA")) {
        
        printPageButton66912CD2D96B494FA23F4AF2B7F795BA(response, vars, strProcessId);

    } else if (vars.commandIn("SAVE_BUTTONActionButton9DB4D30BFC5144B9B431CB49DDE9270D")) {
        process9DB4D30BFC5144B9B431CB49DDE9270D(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton7CB6B4D1ECCF4036B3F111D2CF11AADE")) {
        process7CB6B4D1ECCF4036B3F111D2CF11AADE(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton970EAD9B846648A7AB1F0CCA5058356C")) {
        process970EAD9B846648A7AB1F0CCA5058356C(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton7EDBFEC35BDA4FF4AF05ED516CDAFB90")) {
        process7EDBFEC35BDA4FF4AF05ED516CDAFB90(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonABDFC8131D964936AD2EF7E0CED97FD9")) {
        processABDFC8131D964936AD2EF7E0CED97FD9(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton3C386BC12832466790E50F2F8C5EBD85")) {
        process3C386BC12832466790E50F2F8C5EBD85(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonEFDBF909811544DAAE4E876AA781E5DC")) {
        processEFDBF909811544DAAE4E876AA781E5DC(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton107")) {
        process107(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonCD7283DF804B449C97DA09446669EEEF")) {
        processCD7283DF804B449C97DA09446669EEEF(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton85601427EAEE401FA0250FF0A6DD62EF")) {
        process85601427EAEE401FA0250FF0A6DD62EF(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonA3FE1F9892394386A49FB707AA50A0FA")) {
        processA3FE1F9892394386A49FB707AA50A0FA(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton136")) {
        process136(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonFB740AB61B0E42B198D2C88D3A0D0CE6")) {
        processFB740AB61B0E42B198D2C88D3A0D0CE6(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton58591E3E0F7648E4A09058E037CE49FC")) {
        process58591E3E0F7648E4A09058E037CE49FC(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton23D1B163EC0B41F790CE39BF01DA320E")) {
        process23D1B163EC0B41F790CE39BF01DA320E(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton6FBD65B0FDB74D1AB07F0EADF18D48AE")) {
        process6FBD65B0FDB74D1AB07F0EADF18D48AE(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton9EB2228A60684C0DBEC12D5CD8D85218")) {
        process9EB2228A60684C0DBEC12D5CD8D85218(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonD85D5B5E368A49B1A6293BA4AE15F0F9")) {
        processD85D5B5E368A49B1A6293BA4AE15F0F9(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonFF80808133362F6A013336781FCE0066")) {
        processFF80808133362F6A013336781FCE0066(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonFF8081813219E68E013219ECFE930004")) {
        processFF8081813219E68E013219ECFE930004(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonFF808181324D007801324D2AE1130066")) {
        processFF808181324D007801324D2AE1130066(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonFF808181326CD80501326CE906D70042")) {
        processFF808181326CD80501326CE906D70042(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton6BF16EFC772843AC9A17552AE0B26AB7")) {
        process6BF16EFC772843AC9A17552AE0B26AB7(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton0BDC2164ED3E48539FCEF4D306F29EFD")) {
        process0BDC2164ED3E48539FCEF4D306F29EFD(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton5BE14AA10165490A9ADEFB7532F7FA94")) {
        process5BE14AA10165490A9ADEFB7532F7FA94(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton15C8708DFC464C2D91286E59624FDD18")) {
        process15C8708DFC464C2D91286E59624FDD18(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton017312F51139438A9665775E3B5392A1")) {
        process017312F51139438A9665775E3B5392A1(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton6255BE488882480599C81284B70CD9B3")) {
        process6255BE488882480599C81284B70CD9B3(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonF68F2890E96D4D85A1DEF0274D105BCE")) {
        processF68F2890E96D4D85A1DEF0274D105BCE(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton29D17F515727436DBCE32BC6CA28382B")) {
        process29D17F515727436DBCE32BC6CA28382B(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonDE1B382FDD2540199D223586F6E216D0")) {
        processDE1B382FDD2540199D223586F6E216D0(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonD16966FBF9604A3D91A50DC83C6EA8E3")) {
        processD16966FBF9604A3D91A50DC83C6EA8E3(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonFF8080812E2F8EAE012E2F94CF470014")) {
        processFF8080812E2F8EAE012E2F94CF470014(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonFF8080812F348A97012F349DC24F0007")) {
        processFF8080812F348A97012F349DC24F0007(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonFF80818132A4F6AD0132A573DD7A0021")) {
        processFF80818132A4F6AD0132A573DD7A0021(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton006D8983826D47F4A7065566788F93E8")) {
        process006D8983826D47F4A7065566788F93E8(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton928A4483850046239A217B445A680E29")) {
        process928A4483850046239A217B445A680E29(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton9E6670BCC807442BB3B98432993F79A8")) {
        process9E6670BCC807442BB3B98432993F79A8(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonD10230FC59154A12ABC9FA6B4A9E4080")) {
        processD10230FC59154A12ABC9FA6B4A9E4080(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton9E930637C9B44A73B0227D49AA30DD12")) {
        process9E930637C9B44A73B0227D49AA30DD12(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton7D052DBDB45F45648373F2064BECD521")) {
        process7D052DBDB45F45648373F2064BECD521(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton5AC5C4C39A8F4A37B6098A0512288889")) {
        process5AC5C4C39A8F4A37B6098A0512288889(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton72380902AAEC47B4A493717B4D504E9E")) {
        process72380902AAEC47B4A493717B4D504E9E(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton5FE514F293DB458DAC6DC79C4FE83A8D")) {
        process5FE514F293DB458DAC6DC79C4FE83A8D(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton98EC8B6FBAC145CA926C4740A2C2B6FF")) {
        process98EC8B6FBAC145CA926C4740A2C2B6FF(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton3A53E5B4438A432EA7F48FD4A4FB9992")) {
        process3A53E5B4438A432EA7F48FD4A4FB9992(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonED5960492A2C41929D59442D2C38F174")) {
        processED5960492A2C41929D59442D2C38F174(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton6267329F022A4993A79776EEC7F2882F")) {
        process6267329F022A4993A79776EEC7F2882F(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton9337D1CEEC0647B888EC257259F025B2")) {
        process9337D1CEEC0647B888EC257259F025B2(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton8483E826BD4A4F4FABE988B7EE7193EC")) {
        process8483E826BD4A4F4FABE988B7EE7193EC(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonDD60049F200E490BA823A5B3532F57B4")) {
        processDD60049F200E490BA823A5B3532F57B4(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton418D9416C62B4087BE59A1B358910954")) {
        process418D9416C62B4087BE59A1B358910954(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton0AF06FA75CC348D98ECBD5FFFEF79330")) {
        process0AF06FA75CC348D98ECBD5FFFEF79330(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton4FB68828FA684DAAA1478926ED32B84C")) {
        process4FB68828FA684DAAA1478926ED32B84C(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton05E6E7C50BE3447392C9BC02EB86500D")) {
        process05E6E7C50BE3447392C9BC02EB86500D(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonA1A4F42146B44313A85BAC9499EC15CE")) {
        processA1A4F42146B44313A85BAC9499EC15CE(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonEF5BF59C53944CB6BBE5A6A4CACE7926")) {
        processEF5BF59C53944CB6BBE5A6A4CACE7926(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton71146C7A96774E58A772B98A8B1C6953")) {
        process71146C7A96774E58A772B98A8B1C6953(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton1D419EB151AE45A9A5C8B86371B9818A")) {
        process1D419EB151AE45A9A5C8B86371B9818A(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton6AA269C7FB70428AB269794614AD4742")) {
        process6AA269C7FB70428AB269794614AD4742(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonEBCCB232196040B294F2E29F1846F9AC")) {
        processEBCCB232196040B294F2E29F1846F9AC(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton4380C4EBA98A4E7EB784ABC1360FE8EA")) {
        process4380C4EBA98A4E7EB784ABC1360FE8EA(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton437B1EE180984960A698FB8154DE5D35")) {
        process437B1EE180984960A698FB8154DE5D35(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton837888BA221D47E6915FDE6DD361C1D9")) {
        process837888BA221D47E6915FDE6DD361C1D9(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton177A8D600E334A188E193EC8C647AED0")) {
        process177A8D600E334A188E193EC8C647AED0(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton6F5F5FCC3C124629A02179A1D55DB636")) {
        process6F5F5FCC3C124629A02179A1D55DB636(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton3FAE7B1AB61F4E61B67481247AE8215F")) {
        process3FAE7B1AB61F4E61B67481247AE8215F(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton7CC8083871A2456BAC7B948F3510BC3C")) {
        process7CC8083871A2456BAC7B948F3510BC3C(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton8388633AADD04FC487A0AEA775448333")) {
        process8388633AADD04FC487A0AEA775448333(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonCD35DC8F54624AC0948C891C7F7E70A1")) {
        processCD35DC8F54624AC0948C891C7F7E70A1(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonD93CCE4D4D954542BD7AA2F107404BAD")) {
        processD93CCE4D4D954542BD7AA2F107404BAD(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton2DDE7D3618034C38A4462B7F3456C28D")) {
        process2DDE7D3618034C38A4462B7F3456C28D(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton58A9261BACEF45DDA526F29D8557272D")) {
        process58A9261BACEF45DDA526F29D8557272D(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton64B3FF29AC174F4B94538BD0A3CE1CD3")) {
        process64B3FF29AC174F4B94538BD0A3CE1CD3(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton5192F005F0524EE1A59AD3DCA8CDF4A3")) {
        process5192F005F0524EE1A59AD3DCA8CDF4A3(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton9ADF860D48FF43788F60A062258492A0")) {
        process9ADF860D48FF43788F60A062258492A0(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton0A94232190EE46A2B4D13CBF30C8F423")) {
        process0A94232190EE46A2B4D13CBF30C8F423(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonDBF26D81854746A19B1F2B1F0B4C0952")) {
        processDBF26D81854746A19B1F2B1F0B4C0952(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButtonB5C20B60DD3F4B4D93442FB7BE2DA6EA")) {
        processB5C20B60DD3F4B4D93442FB7BE2DA6EA(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton77FC3840AB4A4814B8247BA69B484F87")) {
        process77FC3840AB4A4814B8247BA69B484F87(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton0A7A590F8CF641B4B63AD85D83D5FD63")) {
        process0A7A590F8CF641B4B63AD85D83D5FD63(strProcessId, vars, request, response);
    } else if (vars.commandIn("SAVE_BUTTONActionButton66912CD2D96B494FA23F4AF2B7F795BA")) {
        process66912CD2D96B494FA23F4AF2B7F795BA(strProcessId, vars, request, response);

    } else pageErrorPopUp(response);
  }
  
  void printPageFrames(HttpServletResponse response, VariablesSecureApp vars, String strProcessId) throws IOException, ServletException {
    log4j.debug("Output: Default");
    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonDefaultFrames").createXmlDocument();
    xmlDocument.setParameter("processId", strProcessId);
    xmlDocument.setParameter("trlFormType", "PROCESS");
    xmlDocument.setParameter("type", "ActionButtonJava_Responser.html");
    xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
    out.println(xmlDocument.print());
    out.close();
  }

  void printPageDefault(HttpServletResponse response, VariablesSecureApp vars, String strProcessId) throws IOException, ServletException {
    log4j.debug("Output: Default");
    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonDefault").createXmlDocument();
    xmlDocument.setParameter("processId", strProcessId);
	  xmlDocument.setParameter("trlFormType", "PROCESS");
	  xmlDocument.setParameter("type", "ActionButtonJava_Responser.html");
	  xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
    out.println(xmlDocument.print());
    out.close();
  }

    void printPageButton9DB4D30BFC5144B9B431CB49DDE9270D(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 9DB4D30BFC5144B9B431CB49DDE9270D");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton9DB4D30BFC5144B9B431CB49DDE9270D", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
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
    void printPageButton7CB6B4D1ECCF4036B3F111D2CF11AADE(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 7CB6B4D1ECCF4036B3F111D2CF11AADE");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton7CB6B4D1ECCF4036B3F111D2CF11AADE", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("7CB6B4D1ECCF4036B3F111D2CF11AADE");
        vars.removeMessage("7CB6B4D1ECCF4036B3F111D2CF11AADE");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("M_Warehouse_ID", Utility.getContext(this, vars, "#M_Warehouse_ID", windowId));
    comboTableData = new ComboTableData(vars, this, "19", "M_Warehouse_ID", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, Utility.getContext(this, vars, "#M_Warehouse_ID", windowId));
    xmlDocument.setData("reportM_Warehouse_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton970EAD9B846648A7AB1F0CCA5058356C(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 970EAD9B846648A7AB1F0CCA5058356C");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton970EAD9B846648A7AB1F0CCA5058356C", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("970EAD9B846648A7AB1F0CCA5058356C");
        vars.removeMessage("970EAD9B846648A7AB1F0CCA5058356C");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    xmlDocument.setParameter("Name", "");
    xmlDocument.setParameter("ImportAuditInfo", "");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton7EDBFEC35BDA4FF4AF05ED516CDAFB90(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 7EDBFEC35BDA4FF4AF05ED516CDAFB90");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton7EDBFEC35BDA4FF4AF05ED516CDAFB90", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("7EDBFEC35BDA4FF4AF05ED516CDAFB90");
        vars.removeMessage("7EDBFEC35BDA4FF4AF05ED516CDAFB90");
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
    void printPageButtonABDFC8131D964936AD2EF7E0CED97FD9(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process ABDFC8131D964936AD2EF7E0CED97FD9");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonABDFC8131D964936AD2EF7E0CED97FD9", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("ABDFC8131D964936AD2EF7E0CED97FD9");
        vars.removeMessage("ABDFC8131D964936AD2EF7E0CED97FD9");
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
    void printPageButton3C386BC12832466790E50F2F8C5EBD85(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 3C386BC12832466790E50F2F8C5EBD85");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton3C386BC12832466790E50F2F8C5EBD85", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("3C386BC12832466790E50F2F8C5EBD85");
        vars.removeMessage("3C386BC12832466790E50F2F8C5EBD85");
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
    void printPageButtonEFDBF909811544DAAE4E876AA781E5DC(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process EFDBF909811544DAAE4E876AA781E5DC");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonEFDBF909811544DAAE4E876AA781E5DC", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("EFDBF909811544DAAE4E876AA781E5DC");
        vars.removeMessage("EFDBF909811544DAAE4E876AA781E5DC");
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
    void printPageButton107(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 107");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton107", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("107");
        vars.removeMessage("107");
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
    void printPageButtonCD7283DF804B449C97DA09446669EEEF(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process CD7283DF804B449C97DA09446669EEEF");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonCD7283DF804B449C97DA09446669EEEF", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("CD7283DF804B449C97DA09446669EEEF");
        vars.removeMessage("CD7283DF804B449C97DA09446669EEEF");
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
    void printPageButton85601427EAEE401FA0250FF0A6DD62EF(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 85601427EAEE401FA0250FF0A6DD62EF");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton85601427EAEE401FA0250FF0A6DD62EF", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("85601427EAEE401FA0250FF0A6DD62EF");
        vars.removeMessage("85601427EAEE401FA0250FF0A6DD62EF");
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
    void printPageButtonA3FE1F9892394386A49FB707AA50A0FA(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process A3FE1F9892394386A49FB707AA50A0FA");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonA3FE1F9892394386A49FB707AA50A0FA", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("A3FE1F9892394386A49FB707AA50A0FA");
        vars.removeMessage("A3FE1F9892394386A49FB707AA50A0FA");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    xmlDocument.setParameter("RecalculatePrices", "Y");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton136(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 136");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton136", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("136");
        vars.removeMessage("136");
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
    void printPageButtonFB740AB61B0E42B198D2C88D3A0D0CE6(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process FB740AB61B0E42B198D2C88D3A0D0CE6");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonFB740AB61B0E42B198D2C88D3A0D0CE6", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("FB740AB61B0E42B198D2C88D3A0D0CE6");
        vars.removeMessage("FB740AB61B0E42B198D2C88D3A0D0CE6");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("DueDate", Utility.getContext(this, vars, "Duedate", ""));
    xmlDocument.setParameter("DueDate_Format", vars.getSessionValue("#AD_SqlDateFormat"));
    xmlDocument.setParameter("FIN_Payment_Priority_ID", Utility.getContext(this, vars, "FIN_Payment_Priority_ID", ""));
    comboTableData = new ComboTableData(vars, this, "19", "FIN_Payment_Priority_ID", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, Utility.getContext(this, vars, "FIN_Payment_Priority_ID", ""));
    xmlDocument.setData("reportFIN_Payment_Priority_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton58591E3E0F7648E4A09058E037CE49FC(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 58591E3E0F7648E4A09058E037CE49FC");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton58591E3E0F7648E4A09058E037CE49FC", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("58591E3E0F7648E4A09058E037CE49FC");
        vars.removeMessage("58591E3E0F7648E4A09058E037CE49FC");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("M_Product_ID", "");
    xmlDocument.setParameter("M_Product_IDR", "");
    xmlDocument.setParameter("M_CH_Value_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "M_CH_Value_ID", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportM_CH_Value_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton23D1B163EC0B41F790CE39BF01DA320E(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 23D1B163EC0B41F790CE39BF01DA320E");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton23D1B163EC0B41F790CE39BF01DA320E", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("23D1B163EC0B41F790CE39BF01DA320E");
        vars.removeMessage("23D1B163EC0B41F790CE39BF01DA320E");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("M_Product_ID", "");
    xmlDocument.setParameter("M_AttributeSetInstance_ID", "");
    xmlDocument.setParameter("M_AttributeSetInstance_IDR", "");
    xmlDocument.setParameter("Returned", "");
    xmlDocument.setParameter("PriceStd", "");
    xmlDocument.setParameter("C_Tax_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "C_Tax_ID", "", "299FA667CF374AC5ACC74739C3251134", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportC_Tax_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("C_Return_Reason_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "C_Return_Reason_ID", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportC_Return_Reason_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton6FBD65B0FDB74D1AB07F0EADF18D48AE(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 6FBD65B0FDB74D1AB07F0EADF18D48AE");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton6FBD65B0FDB74D1AB07F0EADF18D48AE", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("6FBD65B0FDB74D1AB07F0EADF18D48AE");
        vars.removeMessage("6FBD65B0FDB74D1AB07F0EADF18D48AE");
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
    void printPageButton9EB2228A60684C0DBEC12D5CD8D85218(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 9EB2228A60684C0DBEC12D5CD8D85218");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton9EB2228A60684C0DBEC12D5CD8D85218", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("9EB2228A60684C0DBEC12D5CD8D85218");
        vars.removeMessage("9EB2228A60684C0DBEC12D5CD8D85218");
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
    void printPageButtonD85D5B5E368A49B1A6293BA4AE15F0F9(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process D85D5B5E368A49B1A6293BA4AE15F0F9");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonD85D5B5E368A49B1A6293BA4AE15F0F9", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("D85D5B5E368A49B1A6293BA4AE15F0F9");
        vars.removeMessage("D85D5B5E368A49B1A6293BA4AE15F0F9");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("Ad_Client_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "Ad_Client_ID", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportAd_Client_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("ExportAuditInfo", "");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonFF80808133362F6A013336781FCE0066(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process FF80808133362F6A013336781FCE0066");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonFF80808133362F6A013336781FCE0066", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("FF80808133362F6A013336781FCE0066");
        vars.removeMessage("FF80808133362F6A013336781FCE0066");
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
    void printPageButtonFF8081813219E68E013219ECFE930004(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process FF8081813219E68E013219ECFE930004");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonFF8081813219E68E013219ECFE930004", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("FF8081813219E68E013219ECFE930004");
        vars.removeMessage("FF8081813219E68E013219ECFE930004");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("Value", ActionButtonSQLDefaultData.selectActPFF8081813219E68E013219ECFE930004_Value(this, Utility.getContext(this, vars, "MA_SEQUENCEPRODUCT_ID", "")));
    xmlDocument.setParameter("Name", ActionButtonSQLDefaultData.selectActPFF8081813219E68E013219ECFE930004_Name(this, Utility.getContext(this, vars, "MA_SEQUENCEPRODUCT_ID", "")));
    xmlDocument.setParameter("M_Product_Category_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "M_Product_Category_ID", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportM_Product_Category_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("Productiontype", "+");
    comboTableData = new ComboTableData(vars, this, "17", "Productiontype", "800034", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "+");
    xmlDocument.setData("reportProductiontype", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("Qty", "0");
    xmlDocument.setParameter("Copyattribute", "Y");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonFF808181324D007801324D2AE1130066(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process FF808181324D007801324D2AE1130066");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonFF808181324D007801324D2AE1130066", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("FF808181324D007801324D2AE1130066");
        vars.removeMessage("FF808181324D007801324D2AE1130066");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    xmlDocument.setParameter("Date", "");
    xmlDocument.setParameter("Date_Format", vars.getSessionValue("#AD_SqlDateFormat"));
    xmlDocument.setParameter("Starttime", "");
    xmlDocument.setParameter("Endtime", "");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonFF808181326CD80501326CE906D70042(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process FF808181326CD80501326CE906D70042");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonFF808181326CD80501326CE906D70042", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("FF808181326CD80501326CE906D70042");
        vars.removeMessage("FF808181326CD80501326CE906D70042");
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
    void printPageButton6BF16EFC772843AC9A17552AE0B26AB7(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 6BF16EFC772843AC9A17552AE0B26AB7");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton6BF16EFC772843AC9A17552AE0B26AB7", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("6BF16EFC772843AC9A17552AE0B26AB7");
        vars.removeMessage("6BF16EFC772843AC9A17552AE0B26AB7");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("action", Utility.getContext(this, vars, "Process_Reconciliation", ""));
    comboTableData = new ComboTableData(vars, this, "17", "action", "FF8080812E443491012E443C053A001A", "FF808081332719060133271E5BB1001B", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, Utility.getContext(this, vars, "Process_Reconciliation", ""));
    xmlDocument.setData("reportaction", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton0BDC2164ED3E48539FCEF4D306F29EFD(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 0BDC2164ED3E48539FCEF4D306F29EFD");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton0BDC2164ED3E48539FCEF4D306F29EFD", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("0BDC2164ED3E48539FCEF4D306F29EFD");
        vars.removeMessage("0BDC2164ED3E48539FCEF4D306F29EFD");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("action", "");
    comboTableData = new ComboTableData(vars, this, "17", "action", "798239EB069F41A9BA8EE040C63DDBBC", "3842B167CA6F44239C3357A721E3BA6A", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportaction", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton5BE14AA10165490A9ADEFB7532F7FA94(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 5BE14AA10165490A9ADEFB7532F7FA94");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton5BE14AA10165490A9ADEFB7532F7FA94", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("5BE14AA10165490A9ADEFB7532F7FA94");
        vars.removeMessage("5BE14AA10165490A9ADEFB7532F7FA94");
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
    void printPageButton15C8708DFC464C2D91286E59624FDD18(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 15C8708DFC464C2D91286E59624FDD18");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton15C8708DFC464C2D91286E59624FDD18", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("15C8708DFC464C2D91286E59624FDD18");
        vars.removeMessage("15C8708DFC464C2D91286E59624FDD18");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    xmlDocument.setParameter("C_GLItem_ID", ActionButtonSQLDefaultData.selectActP15C8708DFC464C2D91286E59624FDD18_C_GLItem_ID(this, Utility.getContext(this, vars, "C_GLItem_ID", "")));
    xmlDocument.setParameter("M_Product_ID", Utility.getContext(this, vars, "M_Product_ID", ""));
    xmlDocument.setParameter("C_BPartner_ID", Utility.getContext(this, vars, "C_Bpartner_ID", ""));
    xmlDocument.setParameter("C_Project_ID", Utility.getContext(this, vars, "C_Project_ID", ""));
    xmlDocument.setParameter("C_Campaign_ID", Utility.getContext(this, vars, "C_Campaign_ID", ""));
    xmlDocument.setParameter("C_Activity_ID", Utility.getContext(this, vars, "C_Activity_ID", ""));
    xmlDocument.setParameter("C_SalesRegion_ID", Utility.getContext(this, vars, "C_Salesregion_ID", ""));
    xmlDocument.setParameter("C_Costcenter_ID", Utility.getContext(this, vars, "C_Costcenter_ID", ""));
    xmlDocument.setParameter("User1_ID", Utility.getContext(this, vars, "User1_ID", ""));
    xmlDocument.setParameter("User2_ID", Utility.getContext(this, vars, "User2_ID", ""));
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton017312F51139438A9665775E3B5392A1(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 017312F51139438A9665775E3B5392A1");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton017312F51139438A9665775E3B5392A1", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("017312F51139438A9665775E3B5392A1");
        vars.removeMessage("017312F51139438A9665775E3B5392A1");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("action", "");
    comboTableData = new ComboTableData(vars, this, "17", "action", "798239EB069F41A9BA8EE040C63DDBBC", "3842B167CA6F44239C3357A721E3BA6A", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportaction", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton6255BE488882480599C81284B70CD9B3(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 6255BE488882480599C81284B70CD9B3");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton6255BE488882480599C81284B70CD9B3", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("6255BE488882480599C81284B70CD9B3");
        vars.removeMessage("6255BE488882480599C81284B70CD9B3");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("action", Utility.getContext(this, vars, "EM_APRM_Process_Payment", ""));
    comboTableData = new ComboTableData(vars, this, "17", "action", "36972531DA994BB38ECB91993058282F", "575E470ABADB4C278132C957A78C47E3", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, Utility.getContext(this, vars, "EM_APRM_Process_Payment", ""));
    xmlDocument.setData("reportaction", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonF68F2890E96D4D85A1DEF0274D105BCE(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process F68F2890E96D4D85A1DEF0274D105BCE");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonF68F2890E96D4D85A1DEF0274D105BCE", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("F68F2890E96D4D85A1DEF0274D105BCE");
        vars.removeMessage("F68F2890E96D4D85A1DEF0274D105BCE");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("action", "");
    comboTableData = new ComboTableData(vars, this, "17", "action", "F671DDEA466D41A996F605590CB545BC", "FAE0D7C8A9D84FAFAE3C10CD5DCE6E30", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportaction", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton29D17F515727436DBCE32BC6CA28382B(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 29D17F515727436DBCE32BC6CA28382B");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton29D17F515727436DBCE32BC6CA28382B", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("29D17F515727436DBCE32BC6CA28382B");
        vars.removeMessage("29D17F515727436DBCE32BC6CA28382B");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("action", "RV");
    comboTableData = new ComboTableData(vars, this, "17", "action", "66F2DCC800A34F94923444C29478E70A", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "RV");
    xmlDocument.setData("reportaction", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("paymentDate", "");
    xmlDocument.setParameter("paymentDate_Format", vars.getSessionValue("#AD_SqlDateFormat"));
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonDE1B382FDD2540199D223586F6E216D0(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process DE1B382FDD2540199D223586F6E216D0");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonDE1B382FDD2540199D223586F6E216D0", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("DE1B382FDD2540199D223586F6E216D0");
        vars.removeMessage("DE1B382FDD2540199D223586F6E216D0");
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
    void printPageButtonD16966FBF9604A3D91A50DC83C6EA8E3(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process D16966FBF9604A3D91A50DC83C6EA8E3");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonD16966FBF9604A3D91A50DC83C6EA8E3", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("D16966FBF9604A3D91A50DC83C6EA8E3");
        vars.removeMessage("D16966FBF9604A3D91A50DC83C6EA8E3");
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
    void printPageButtonFF8080812E2F8EAE012E2F94CF470014(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process FF8080812E2F8EAE012E2F94CF470014");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonFF8080812E2F8EAE012E2F94CF470014", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("FF8080812E2F8EAE012E2F94CF470014");
        vars.removeMessage("FF8080812E2F8EAE012E2F94CF470014");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("action", Utility.getContext(this, vars, "Process_Reconciliation", ""));
    comboTableData = new ComboTableData(vars, this, "17", "action", "FF8080812E443491012E443C053A001A", "FF808081332719060133271E5BB1001B", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, Utility.getContext(this, vars, "Process_Reconciliation", ""));
    xmlDocument.setData("reportaction", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonFF8080812F348A97012F349DC24F0007(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process FF8080812F348A97012F349DC24F0007");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonFF8080812F348A97012F349DC24F0007", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("FF8080812F348A97012F349DC24F0007");
        vars.removeMessage("FF8080812F348A97012F349DC24F0007");
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
    void printPageButtonFF80818132A4F6AD0132A573DD7A0021(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process FF80818132A4F6AD0132A573DD7A0021");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonFF80818132A4F6AD0132A573DD7A0021", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("FF80818132A4F6AD0132A573DD7A0021");
        vars.removeMessage("FF80818132A4F6AD0132A573DD7A0021");
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
    void printPageButton006D8983826D47F4A7065566788F93E8(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 006D8983826D47F4A7065566788F93E8");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton006D8983826D47F4A7065566788F93E8", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("006D8983826D47F4A7065566788F93E8");
        vars.removeMessage("006D8983826D47F4A7065566788F93E8");
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
    void printPageButton928A4483850046239A217B445A680E29(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 928A4483850046239A217B445A680E29");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton928A4483850046239A217B445A680E29", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("928A4483850046239A217B445A680E29");
        vars.removeMessage("928A4483850046239A217B445A680E29");
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
    void printPageButton9E6670BCC807442BB3B98432993F79A8(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 9E6670BCC807442BB3B98432993F79A8");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton9E6670BCC807442BB3B98432993F79A8", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("9E6670BCC807442BB3B98432993F79A8");
        vars.removeMessage("9E6670BCC807442BB3B98432993F79A8");
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
    void printPageButtonD10230FC59154A12ABC9FA6B4A9E4080(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process D10230FC59154A12ABC9FA6B4A9E4080");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonD10230FC59154A12ABC9FA6B4A9E4080", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("D10230FC59154A12ABC9FA6B4A9E4080");
        vars.removeMessage("D10230FC59154A12ABC9FA6B4A9E4080");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("C_Period_ID", "");
    comboTableData = new ComboTableData(vars, this, "18", "C_Period_ID", "A22A0AE42F70499EB8ECEA83A25E6131", "F82DA8938E894B67812FCF23D82CA50D", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportC_Period_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton9E930637C9B44A73B0227D49AA30DD12(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 9E930637C9B44A73B0227D49AA30DD12");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton9E930637C9B44A73B0227D49AA30DD12", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("9E930637C9B44A73B0227D49AA30DD12");
        vars.removeMessage("9E930637C9B44A73B0227D49AA30DD12");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("ad_org_id", "");
    comboTableData = new ComboTableData(vars, this, "19", "ad_org_id", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportad_org_id", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("c_city_id", "");
    comboTableData = new ComboTableData(vars, this, "19", "c_city_id", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportc_city_id", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("c_period_id", "");
    comboTableData = new ComboTableData(vars, this, "18", "c_period_id", "A22A0AE42F70499EB8ECEA83A25E6131", "F82DA8938E894B67812FCF23D82CA50D", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportc_period_id", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("documentno", "");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton7D052DBDB45F45648373F2064BECD521(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 7D052DBDB45F45648373F2064BECD521");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton7D052DBDB45F45648373F2064BECD521", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("7D052DBDB45F45648373F2064BECD521");
        vars.removeMessage("7D052DBDB45F45648373F2064BECD521");
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
    void printPageButton5AC5C4C39A8F4A37B6098A0512288889(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 5AC5C4C39A8F4A37B6098A0512288889");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton5AC5C4C39A8F4A37B6098A0512288889", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
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
    void printPageButton72380902AAEC47B4A493717B4D504E9E(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 72380902AAEC47B4A493717B4D504E9E");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton72380902AAEC47B4A493717B4D504E9E", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("72380902AAEC47B4A493717B4D504E9E");
        vars.removeMessage("72380902AAEC47B4A493717B4D504E9E");
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
    void printPageButton5FE514F293DB458DAC6DC79C4FE83A8D(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 5FE514F293DB458DAC6DC79C4FE83A8D");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton5FE514F293DB458DAC6DC79C4FE83A8D", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
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
    void printPageButton98EC8B6FBAC145CA926C4740A2C2B6FF(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 98EC8B6FBAC145CA926C4740A2C2B6FF");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton98EC8B6FBAC145CA926C4740A2C2B6FF", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("98EC8B6FBAC145CA926C4740A2C2B6FF");
        vars.removeMessage("98EC8B6FBAC145CA926C4740A2C2B6FF");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("documentno", "");
    xmlDocument.setParameter("sspr_category_acct_id", "");
    comboTableData = new ComboTableData(vars, this, "19", "sspr_category_acct_id", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportsspr_category_acct_id", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("sendno", "");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton3A53E5B4438A432EA7F48FD4A4FB9992(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 3A53E5B4438A432EA7F48FD4A4FB9992");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton3A53E5B4438A432EA7F48FD4A4FB9992", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
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
    void printPageButtonED5960492A2C41929D59442D2C38F174(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process ED5960492A2C41929D59442D2C38F174");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonED5960492A2C41929D59442D2C38F174", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("ED5960492A2C41929D59442D2C38F174");
        vars.removeMessage("ED5960492A2C41929D59442D2C38F174");
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
    void printPageButton6267329F022A4993A79776EEC7F2882F(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 6267329F022A4993A79776EEC7F2882F");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton6267329F022A4993A79776EEC7F2882F", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("6267329F022A4993A79776EEC7F2882F");
        vars.removeMessage("6267329F022A4993A79776EEC7F2882F");
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
    void printPageButton9337D1CEEC0647B888EC257259F025B2(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 9337D1CEEC0647B888EC257259F025B2");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton9337D1CEEC0647B888EC257259F025B2", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("9337D1CEEC0647B888EC257259F025B2");
        vars.removeMessage("9337D1CEEC0647B888EC257259F025B2");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("AD_ORG_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "AD_ORG_ID", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportAD_ORG_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("C_Period_ID", "");
    comboTableData = new ComboTableData(vars, this, "18", "C_Period_ID", "0B30149ACA2043C3A6642049C22A262A", "88661FA3F6F4410BAF6A85FB0F1B516B", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportC_Period_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton8483E826BD4A4F4FABE988B7EE7193EC(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 8483E826BD4A4F4FABE988B7EE7193EC");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton8483E826BD4A4F4FABE988B7EE7193EC", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("8483E826BD4A4F4FABE988B7EE7193EC");
        vars.removeMessage("8483E826BD4A4F4FABE988B7EE7193EC");
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
    void printPageButtonDD60049F200E490BA823A5B3532F57B4(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process DD60049F200E490BA823A5B3532F57B4");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonDD60049F200E490BA823A5B3532F57B4", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("DD60049F200E490BA823A5B3532F57B4");
        vars.removeMessage("DD60049F200E490BA823A5B3532F57B4");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("c_doctype_id", "");
    comboTableData = new ComboTableData(vars, this, "19", "c_doctype_id", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportc_doctype_id", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("datefrom", "");
    xmlDocument.setParameter("datefrom_Format", vars.getSessionValue("#AD_SqlDateFormat"));
    xmlDocument.setParameter("dateto", "");
    xmlDocument.setParameter("dateto_Format", vars.getSessionValue("#AD_SqlDateFormat"));
    xmlDocument.setParameter("FIN_Financial_Account_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "FIN_Financial_Account_ID", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportFIN_Financial_Account_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("sendno", "");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton418D9416C62B4087BE59A1B358910954(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 418D9416C62B4087BE59A1B358910954");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton418D9416C62B4087BE59A1B358910954", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("418D9416C62B4087BE59A1B358910954");
        vars.removeMessage("418D9416C62B4087BE59A1B358910954");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("documentno", "");
    xmlDocument.setParameter("sspr_category_acct_id", "");
    comboTableData = new ComboTableData(vars, this, "19", "sspr_category_acct_id", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportsspr_category_acct_id", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("sendno", "");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton0AF06FA75CC348D98ECBD5FFFEF79330(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 0AF06FA75CC348D98ECBD5FFFEF79330");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton0AF06FA75CC348D98ECBD5FFFEF79330", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("0AF06FA75CC348D98ECBD5FFFEF79330");
        vars.removeMessage("0AF06FA75CC348D98ECBD5FFFEF79330");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("C_Year_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "C_Year_ID", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportC_Year_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton4FB68828FA684DAAA1478926ED32B84C(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 4FB68828FA684DAAA1478926ED32B84C");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton4FB68828FA684DAAA1478926ED32B84C", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("4FB68828FA684DAAA1478926ED32B84C");
        vars.removeMessage("4FB68828FA684DAAA1478926ED32B84C");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("documentno", "");
    xmlDocument.setParameter("ssfi_banktransfer_id", "");
    comboTableData = new ComboTableData(vars, this, "19", "ssfi_banktransfer_id", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportssfi_banktransfer_id", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("sspr_category_acct_id", "");
    comboTableData = new ComboTableData(vars, this, "19", "sspr_category_acct_id", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportsspr_category_acct_id", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton05E6E7C50BE3447392C9BC02EB86500D(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 05E6E7C50BE3447392C9BC02EB86500D");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton05E6E7C50BE3447392C9BC02EB86500D", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("05E6E7C50BE3447392C9BC02EB86500D");
        vars.removeMessage("05E6E7C50BE3447392C9BC02EB86500D");
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
    void printPageButtonA1A4F42146B44313A85BAC9499EC15CE(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process A1A4F42146B44313A85BAC9499EC15CE");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonA1A4F42146B44313A85BAC9499EC15CE", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("A1A4F42146B44313A85BAC9499EC15CE");
        vars.removeMessage("A1A4F42146B44313A85BAC9499EC15CE");
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
    void printPageButtonEF5BF59C53944CB6BBE5A6A4CACE7926(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process EF5BF59C53944CB6BBE5A6A4CACE7926");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonEF5BF59C53944CB6BBE5A6A4CACE7926", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("EF5BF59C53944CB6BBE5A6A4CACE7926");
        vars.removeMessage("EF5BF59C53944CB6BBE5A6A4CACE7926");
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
    void printPageButton71146C7A96774E58A772B98A8B1C6953(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 71146C7A96774E58A772B98A8B1C6953");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton71146C7A96774E58A772B98A8B1C6953", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("71146C7A96774E58A772B98A8B1C6953");
        vars.removeMessage("71146C7A96774E58A772B98A8B1C6953");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    xmlDocument.setParameter("Documentno", "");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton1D419EB151AE45A9A5C8B86371B9818A(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 1D419EB151AE45A9A5C8B86371B9818A");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton1D419EB151AE45A9A5C8B86371B9818A", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("1D419EB151AE45A9A5C8B86371B9818A");
        vars.removeMessage("1D419EB151AE45A9A5C8B86371B9818A");
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
    void printPageButton6AA269C7FB70428AB269794614AD4742(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 6AA269C7FB70428AB269794614AD4742");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton6AA269C7FB70428AB269794614AD4742", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("6AA269C7FB70428AB269794614AD4742");
        vars.removeMessage("6AA269C7FB70428AB269794614AD4742");
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
    void printPageButtonEBCCB232196040B294F2E29F1846F9AC(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process EBCCB232196040B294F2E29F1846F9AC");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonEBCCB232196040B294F2E29F1846F9AC", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("EBCCB232196040B294F2E29F1846F9AC");
        vars.removeMessage("EBCCB232196040B294F2E29F1846F9AC");
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
    void printPageButton4380C4EBA98A4E7EB784ABC1360FE8EA(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 4380C4EBA98A4E7EB784ABC1360FE8EA");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton4380C4EBA98A4E7EB784ABC1360FE8EA", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("4380C4EBA98A4E7EB784ABC1360FE8EA");
        vars.removeMessage("4380C4EBA98A4E7EB784ABC1360FE8EA");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("C_YEAR_ID", "");
    comboTableData = new ComboTableData(vars, this, "18", "C_YEAR_ID", "185F8664184A47B0BDC46266BA399B11", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportC_YEAR_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton437B1EE180984960A698FB8154DE5D35(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 437B1EE180984960A698FB8154DE5D35");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton437B1EE180984960A698FB8154DE5D35", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("437B1EE180984960A698FB8154DE5D35");
        vars.removeMessage("437B1EE180984960A698FB8154DE5D35");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("C_YEAR_ID", "");
    comboTableData = new ComboTableData(vars, this, "18", "C_YEAR_ID", "AB8C3318A0034E4CBA38D0820F37BF65", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportC_YEAR_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("outputtype", "");
    comboTableData = new ComboTableData(vars, this, "17", "outputtype", "53913B77F5684D31AE4C69CE5E8B3FDC", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportoutputtype", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton837888BA221D47E6915FDE6DD361C1D9(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 837888BA221D47E6915FDE6DD361C1D9");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton837888BA221D47E6915FDE6DD361C1D9", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("837888BA221D47E6915FDE6DD361C1D9");
        vars.removeMessage("837888BA221D47E6915FDE6DD361C1D9");
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
    void printPageButton177A8D600E334A188E193EC8C647AED0(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 177A8D600E334A188E193EC8C647AED0");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton177A8D600E334A188E193EC8C647AED0", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("177A8D600E334A188E193EC8C647AED0");
        vars.removeMessage("177A8D600E334A188E193EC8C647AED0");
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
    void printPageButton6F5F5FCC3C124629A02179A1D55DB636(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 6F5F5FCC3C124629A02179A1D55DB636");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton6F5F5FCC3C124629A02179A1D55DB636", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("6F5F5FCC3C124629A02179A1D55DB636");
        vars.removeMessage("6F5F5FCC3C124629A02179A1D55DB636");
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
    void printPageButton3FAE7B1AB61F4E61B67481247AE8215F(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 3FAE7B1AB61F4E61B67481247AE8215F");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton3FAE7B1AB61F4E61B67481247AE8215F", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("3FAE7B1AB61F4E61B67481247AE8215F");
        vars.removeMessage("3FAE7B1AB61F4E61B67481247AE8215F");
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
    void printPageButton7CC8083871A2456BAC7B948F3510BC3C(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 7CC8083871A2456BAC7B948F3510BC3C");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton7CC8083871A2456BAC7B948F3510BC3C", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("7CC8083871A2456BAC7B948F3510BC3C");
        vars.removeMessage("7CC8083871A2456BAC7B948F3510BC3C");
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
    void printPageButton8388633AADD04FC487A0AEA775448333(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 8388633AADD04FC487A0AEA775448333");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton8388633AADD04FC487A0AEA775448333", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("8388633AADD04FC487A0AEA775448333");
        vars.removeMessage("8388633AADD04FC487A0AEA775448333");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    xmlDocument.setParameter("Documentno", "");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonCD35DC8F54624AC0948C891C7F7E70A1(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process CD35DC8F54624AC0948C891C7F7E70A1");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonCD35DC8F54624AC0948C891C7F7E70A1", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("CD35DC8F54624AC0948C891C7F7E70A1");
        vars.removeMessage("CD35DC8F54624AC0948C891C7F7E70A1");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    xmlDocument.setParameter("Documentno", "");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonD93CCE4D4D954542BD7AA2F107404BAD(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process D93CCE4D4D954542BD7AA2F107404BAD");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonD93CCE4D4D954542BD7AA2F107404BAD", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("D93CCE4D4D954542BD7AA2F107404BAD");
        vars.removeMessage("D93CCE4D4D954542BD7AA2F107404BAD");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("c_year_id", "");
    comboTableData = new ComboTableData(vars, this, "18", "c_year_id", "DA52367C92304C72809B5302A830BADC", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, "");
    xmlDocument.setData("reportc_year_id", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton2DDE7D3618034C38A4462B7F3456C28D(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 2DDE7D3618034C38A4462B7F3456C28D");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton2DDE7D3618034C38A4462B7F3456C28D", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("2DDE7D3618034C38A4462B7F3456C28D");
        vars.removeMessage("2DDE7D3618034C38A4462B7F3456C28D");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("action", Utility.getContext(this, vars, "EM_APRM_Process_BS", ""));
    comboTableData = new ComboTableData(vars, this, "17", "action", "EC75B6F5A9504DB6B3F3356EA85F15EE", "CA425689672A42D7BE2158EE41E44F94", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, Utility.getContext(this, vars, "EM_APRM_Process_BS", ""));
    xmlDocument.setData("reportaction", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton58A9261BACEF45DDA526F29D8557272D(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 58A9261BACEF45DDA526F29D8557272D");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton58A9261BACEF45DDA526F29D8557272D", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("58A9261BACEF45DDA526F29D8557272D");
        vars.removeMessage("58A9261BACEF45DDA526F29D8557272D");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("action", Utility.getContext(this, vars, "EM_APRM_Process_BS", ""));
    comboTableData = new ComboTableData(vars, this, "17", "action", "EC75B6F5A9504DB6B3F3356EA85F15EE", "CA425689672A42D7BE2158EE41E44F94", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, null, comboTableData, windowId, Utility.getContext(this, vars, "EM_APRM_Process_BS", ""));
    xmlDocument.setData("reportaction", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButton64B3FF29AC174F4B94538BD0A3CE1CD3(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 64B3FF29AC174F4B94538BD0A3CE1CD3");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton64B3FF29AC174F4B94538BD0A3CE1CD3", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("64B3FF29AC174F4B94538BD0A3CE1CD3");
        vars.removeMessage("64B3FF29AC174F4B94538BD0A3CE1CD3");
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
    void printPageButton5192F005F0524EE1A59AD3DCA8CDF4A3(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 5192F005F0524EE1A59AD3DCA8CDF4A3");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton5192F005F0524EE1A59AD3DCA8CDF4A3", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("5192F005F0524EE1A59AD3DCA8CDF4A3");
        vars.removeMessage("5192F005F0524EE1A59AD3DCA8CDF4A3");
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
    void printPageButton9ADF860D48FF43788F60A062258492A0(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 9ADF860D48FF43788F60A062258492A0");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton9ADF860D48FF43788F60A062258492A0", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("9ADF860D48FF43788F60A062258492A0");
        vars.removeMessage("9ADF860D48FF43788F60A062258492A0");
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
    void printPageButton0A94232190EE46A2B4D13CBF30C8F423(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 0A94232190EE46A2B4D13CBF30C8F423");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton0A94232190EE46A2B4D13CBF30C8F423", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("0A94232190EE46A2B4D13CBF30C8F423");
        vars.removeMessage("0A94232190EE46A2B4D13CBF30C8F423");
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
    void printPageButtonDBF26D81854746A19B1F2B1F0B4C0952(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process DBF26D81854746A19B1F2B1F0B4C0952");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonDBF26D81854746A19B1F2B1F0B4C0952", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
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
    void printPageButtonB5C20B60DD3F4B4D93442FB7BE2DA6EA(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process B5C20B60DD3F4B4D93442FB7BE2DA6EA");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButtonB5C20B60DD3F4B4D93442FB7BE2DA6EA", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("B5C20B60DD3F4B4D93442FB7BE2DA6EA");
        vars.removeMessage("B5C20B60DD3F4B4D93442FB7BE2DA6EA");
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
    void printPageButton77FC3840AB4A4814B8247BA69B484F87(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 77FC3840AB4A4814B8247BA69B484F87");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton77FC3840AB4A4814B8247BA69B484F87", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("77FC3840AB4A4814B8247BA69B484F87");
        vars.removeMessage("77FC3840AB4A4814B8247BA69B484F87");
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
    void printPageButton0A7A590F8CF641B4B63AD85D83D5FD63(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 0A7A590F8CF641B4B63AD85D83D5FD63");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton0A7A590F8CF641B4B63AD85D83D5FD63", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("0A7A590F8CF641B4B63AD85D83D5FD63");
        vars.removeMessage("0A7A590F8CF641B4B63AD85D83D5FD63");
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
    void printPageButton66912CD2D96B494FA23F4AF2B7F795BA(HttpServletResponse response, VariablesSecureApp vars, String strProcessId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 66912CD2D96B494FA23F4AF2B7F795BA");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActionButton66912CD2D96B494FA23F4AF2B7F795BA", discard).createXmlDocument();
      xmlDocument.setParameter("processing", "Y");
      xmlDocument.setParameter("form", "ActionButtonJava_Responser.html");
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      xmlDocument.setParameter("processId", strProcessId);
			xmlDocument.setParameter("trlFormType", "PROCESS");
          
      {
        OBError myMessage = vars.getMessage("66912CD2D96B494FA23F4AF2B7F795BA");
        vars.removeMessage("66912CD2D96B494FA23F4AF2B7F795BA");
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


    private void process9DB4D30BFC5144B9B431CB49DDE9270D(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.erpCommon.ad_process.KillSession().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process7CB6B4D1ECCF4036B3F111D2CF11AADE(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strmWarehouseId = vars.getStringParameter("inpmWarehouseId");
params.put("mWarehouseId", strmWarehouseId);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.erpCommon.ad_process.MRPPurchaseCreateReservations().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process970EAD9B846648A7AB1F0CCA5058356C(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strname = vars.getStringParameter("inpname");
params.put("name", strname);
String strimportauditinfo = vars.getStringParameter("inpimportauditinfo", "N");
params.put("importauditinfo", strimportauditinfo);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.service.db.ImportClientProcess().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process7EDBFEC35BDA4FF4AF05ED516CDAFB90(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.erpCommon.ad_process.CreateCustomModule().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processABDFC8131D964936AD2EF7E0CED97FD9(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.erpCommon.ad_process.UpdateActuals().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process3C386BC12832466790E50F2F8C5EBD85(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.materialmgmt.VariantAutomaticGenerationProcess().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processEFDBF909811544DAAE4E876AA781E5DC(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.erpCommon.ad_process.EndYearClose().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process107(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.materialmgmt.InventoryCountProcess().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processCD7283DF804B449C97DA09446669EEEF(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.advpaymentmngt.process.ProcessBatch().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process85601427EAEE401FA0250FF0A6DD62EF(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.erpCommon.ad_process.assets.AssetLinearDepreciationMethodProcess().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processA3FE1F9892394386A49FB707AA50A0FA(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strrecalculateprices = vars.getStringParameter("inprecalculateprices", "N");
params.put("recalculateprices", strrecalculateprices);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.erpCommon.ad_process.ConvertQuotationIntoOrder().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process136(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.erpCommon.ad_process.VerifyBOM().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processFB740AB61B0E42B198D2C88D3A0D0CE6(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strduedate = vars.getStringParameter("inpduedate");
params.put("duedate", strduedate);
String strfinPaymentPriorityId = vars.getStringParameter("inpfinPaymentPriorityId");
params.put("finPaymentPriorityId", strfinPaymentPriorityId);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.erpCommon.ad_process.UpdatePaymentPlan().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process58591E3E0F7648E4A09058E037CE49FC(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strmProductId = vars.getStringParameter("inpmProductId");
params.put("mProductId", strmProductId);
String strmChValueId = vars.getStringParameter("inpmChValueId");
params.put("mChValueId", strmChValueId);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.materialmgmt.VariantChDescUpdateProcess().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process23D1B163EC0B41F790CE39BF01DA320E(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strmProductId = vars.getStringParameter("inpmProductId");
params.put("mProductId", strmProductId);
String strmAttributesetinstanceId = vars.getStringParameter("inpmAttributesetinstanceId");
params.put("mAttributesetinstanceId", strmAttributesetinstanceId);
String strreturned = vars.getNumericParameter("inpreturned");
params.put("returned", strreturned);
String strpricestd = vars.getNumericParameter("inppricestd");
params.put("pricestd", strpricestd);
String strcTaxId = vars.getStringParameter("inpcTaxId");
params.put("cTaxId", strcTaxId);
String strcReturnReasonId = vars.getStringParameter("inpcReturnReasonId");
params.put("cReturnReasonId", strcReturnReasonId);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.erpCommon.ad_actionButton.RMInsertOrphanLine().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process6FBD65B0FDB74D1AB07F0EADF18D48AE(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.erpCommon.ad_actionButton.MRPManufacturingPlanProcess().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process9EB2228A60684C0DBEC12D5CD8D85218(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.erpCommon.ad_process.CalculatePromotions().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processD85D5B5E368A49B1A6293BA4AE15F0F9(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String stradClientId = vars.getStringParameter("inpadClientId");
params.put("adClientId", stradClientId);
String strexportauditinfo = vars.getStringParameter("inpexportauditinfo", "N");
params.put("exportauditinfo", strexportauditinfo);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.service.db.ExportClientProcess().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processFF80808133362F6A013336781FCE0066(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.erpCommon.ad_actionButton.RMCreateInvoice().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processFF8081813219E68E013219ECFE930004(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strvalue = vars.getStringParameter("inpvalue");
params.put("value", strvalue);
String strname = vars.getStringParameter("inpname");
params.put("name", strname);
String strmProductCategoryId = vars.getStringParameter("inpmProductCategoryId");
params.put("mProductCategoryId", strmProductCategoryId);
String strproductiontype = vars.getStringParameter("inpproductiontype");
params.put("productiontype", strproductiontype);
String strqty = vars.getNumericParameter("inpqty");
params.put("qty", strqty);
String strcopyattribute = vars.getStringParameter("inpcopyattribute", "N");
params.put("copyattribute", strcopyattribute);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.erpCommon.ad_actionButton.SequenceProductCreate().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processFF808181324D007801324D2AE1130066(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strdate = vars.getStringParameter("inpdate");
params.put("date", strdate);
String strstarttime = vars.getStringParameter("inpstarttime");
params.put("starttime", strstarttime);
String strendtime = vars.getStringParameter("inpendtime");
params.put("endtime", strendtime);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.erpCommon.ad_actionButton.CreateWorkEffort().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processFF808181326CD80501326CE906D70042(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.erpCommon.ad_actionButton.ValidateWorkEffort_ProductionRun().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process6BF16EFC772843AC9A17552AE0B26AB7(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String straction = vars.getStringParameter("inpaction");
params.put("action", straction);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.advpaymentmngt.process.FIN_ReconciliationProcess().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process0BDC2164ED3E48539FCEF4D306F29EFD(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String straction = vars.getStringParameter("inpaction");
params.put("action", straction);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.advpaymentmngt.process.FIN_DoubtfulDebtProcess().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process5BE14AA10165490A9ADEFB7532F7FA94(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.advpaymentmngt.process.FIN_AddPaymentFromJournal().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process15C8708DFC464C2D91286E59624FDD18(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strcGlitemId = vars.getStringParameter("inpcGlitemId");
params.put("cGlitemId", strcGlitemId);
String strmProductId = vars.getStringParameter("inpmProductId");
params.put("mProductId", strmProductId);
String strcBpartnerId = vars.getStringParameter("inpcBpartnerId");
params.put("cBpartnerId", strcBpartnerId);
String strcProjectId = vars.getStringParameter("inpcProjectId");
params.put("cProjectId", strcProjectId);
String strcCampaignId = vars.getStringParameter("inpcCampaignId");
params.put("cCampaignId", strcCampaignId);
String strcActivityId = vars.getStringParameter("inpcActivityId");
params.put("cActivityId", strcActivityId);
String strcSalesregionId = vars.getStringParameter("inpcSalesregionId");
params.put("cSalesregionId", strcSalesregionId);
String strcCostcenterId = vars.getStringParameter("inpcCostcenterId");
params.put("cCostcenterId", strcCostcenterId);
String struser1Id = vars.getStringParameter("inpuser1Id");
params.put("user1Id", struser1Id);
String struser2Id = vars.getStringParameter("inpuser2Id");
params.put("user2Id", struser2Id);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.advpaymentmngt.process.FIN_TransactionModify().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process017312F51139438A9665775E3B5392A1(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String straction = vars.getStringParameter("inpaction");
params.put("action", straction);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.advpaymentmngt.process.FIN_DoubtfulDebtRunProcess().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process6255BE488882480599C81284B70CD9B3(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String straction = vars.getStringParameter("inpaction");
params.put("action", straction);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.advpaymentmngt.process.FIN_PaymentProcess().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processF68F2890E96D4D85A1DEF0274D105BCE(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String straction = vars.getStringParameter("inpaction");
params.put("action", straction);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.advpaymentmngt.process.FIN_TransactionProcess().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process29D17F515727436DBCE32BC6CA28382B(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String straction = vars.getStringParameter("inpaction");
params.put("action", straction);
String strpaymentdate = vars.getStringParameter("inppaymentdate");
params.put("paymentdate", strpaymentdate);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.advpaymentmngt.process.FIN_PaymentProcess().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processDE1B382FDD2540199D223586F6E216D0(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.advpaymentmngt.process.FIN_AddPaymentFromJournalLine().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processD16966FBF9604A3D91A50DC83C6EA8E3(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.advpaymentmngt.process.FIN_PaymentProposalProcess().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processFF8080812E2F8EAE012E2F94CF470014(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String straction = vars.getStringParameter("inpaction");
params.put("action", straction);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.advpaymentmngt.process.FIN_ReconciliationProcess().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processFF8080812F348A97012F349DC24F0007(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.advpaymentmngt.ad_actionbutton.DeleteTransaction().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processFF80818132A4F6AD0132A573DD7A0021(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.erpCommon.ad_actionButton.CreateStandards().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process006D8983826D47F4A7065566788F93E8(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.flopec.budget.ad_Process.RequestCertificate().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process928A4483850046239A217B445A680E29(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.flopec.budget.ad_Process.ProcessCertificate().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process9E6670BCC807442BB3B98432993F79A8(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.flopec.budget.ad_Process.ProcessLog().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processD10230FC59154A12ABC9FA6B4A9E4080(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strcPeriodId = vars.getStringParameter("inpcPeriodId");
params.put("cPeriodId", strcPeriodId);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.hrm.payroll.create_txt.ModifySalaryCSV().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process9E930637C9B44A73B0227D49AA30DD12(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String stradOrgId = vars.getStringParameter("inpadOrgId");
params.put("adOrgId", stradOrgId);
String strcCityId = vars.getStringParameter("inpcCityId");
params.put("cCityId", strcCityId);
String strcPeriodId = vars.getStringParameter("inpcPeriodId");
params.put("cPeriodId", strcPeriodId);
String strdocumentno = vars.getStringParameter("inpdocumentno");
params.put("documentno", strdocumentno);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.hrm.payroll.create_txt.ArchVariationSalaryCSV().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process7D052DBDB45F45648373F2064BECD521(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.flopec.budget.ad_Process.CloseCertificate().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process5AC5C4C39A8F4A37B6098A0512288889(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.flopec.budget.ad_Process.CreateVersion().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process72380902AAEC47B4A493717B4D504E9E(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.cusoft.facturaec.ad_process.GenerateFE().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process5FE514F293DB458DAC6DC79C4FE83A8D(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.flopec.budget.ad_Process.ApproveVersion().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process98EC8B6FBAC145CA926C4740A2C2B6FF(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strdocumentno = vars.getStringParameter("inpdocumentno");
params.put("documentno", strdocumentno);
String strssprCategoryAcctId = vars.getStringParameter("inpssprCategoryAcctId");
params.put("ssprCategoryAcctId", strssprCategoryAcctId);
String strsendno = vars.getStringParameter("inpsendno");
params.put("sendno", strsendno);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.hrm.payroll.create_txt.ArchPaymentCtralBankTXT().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process3A53E5B4438A432EA7F48FD4A4FB9992(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.ecuador.asset.allocation.ad_process.change_state().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processED5960492A2C41929D59442D2C38F174(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.ecuador.asset.allocation.ad_process.ReturnAssetsStore().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process6267329F022A4993A79776EEC7F2882F(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.flopec.budget.ad_Process.ProcessCertificateExecuted().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process9337D1CEEC0647B888EC257259F025B2(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String stradOrgId = vars.getStringParameter("inpadOrgId");
params.put("adOrgId", stradOrgId);
String strcPeriodId = vars.getStringParameter("inpcPeriodId");
params.put("cPeriodId", strcPeriodId);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.localization.ecuador.withholdings.create_xml.Create_xml().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process8483E826BD4A4F4FABE988B7EE7193EC(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.ecuador.asset.allocation.ad_process.Approved_state().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processDD60049F200E490BA823A5B3532F57B4(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strcDoctypeId = vars.getStringParameter("inpcDoctypeId");
params.put("cDoctypeId", strcDoctypeId);
String strdatefrom = vars.getStringParameter("inpdatefrom");
params.put("datefrom", strdatefrom);
String strdateto = vars.getStringParameter("inpdateto");
params.put("dateto", strdateto);
String strfinFinancialAccountId = vars.getStringParameter("inpfinFinancialAccountId");
params.put("finFinancialAccountId", strfinFinancialAccountId);
String strsendno = vars.getStringParameter("inpsendno");
params.put("sendno", strsendno);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.localization.ecuador.withholdings.create_xml.ArchProviderTransferTXT().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process418D9416C62B4087BE59A1B358910954(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strdocumentno = vars.getStringParameter("inpdocumentno");
params.put("documentno", strdocumentno);
String strssprCategoryAcctId = vars.getStringParameter("inpssprCategoryAcctId");
params.put("ssprCategoryAcctId", strssprCategoryAcctId);
String strsendno = vars.getStringParameter("inpsendno");
params.put("sendno", strsendno);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.hrm.payroll.tenth.create_txt.ArchTenthCtralBankTXT().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process0AF06FA75CC348D98ECBD5FFFEF79330(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strcYearId = vars.getStringParameter("inpcYearId");
params.put("cYearId", strcYearId);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.hrm.payroll.create_xml.Formulary107_xml().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process4FB68828FA684DAAA1478926ED32B84C(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strdocumentno = vars.getStringParameter("inpdocumentno");
params.put("documentno", strdocumentno);
String strssfiBanktransferId = vars.getStringParameter("inpssfiBanktransferId");
params.put("ssfiBanktransferId", strssfiBanktransferId);
String strssprCategoryAcctId = vars.getStringParameter("inpssprCategoryAcctId");
params.put("ssprCategoryAcctId", strssprCategoryAcctId);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.hrm.payroll.create_txt.ArchPaymentPichinchaBankTXT().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process05E6E7C50BE3447392C9BC02EB86500D(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.localization.ecuador.withholdings.ad_process.Sswh_ProcessWithholdingVoided().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processA1A4F42146B44313A85BAC9499EC15CE(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.custom.payroll.partialpayment.ad_process.PartialPaymentFIleTransferTXT().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processEF5BF59C53944CB6BBE5A6A4CACE7926(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.custom.payments.partialpayment.ad_process.SsppDownloadPaymentFile().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process71146C7A96774E58A772B98A8B1C6953(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strdocumentno = vars.getStringParameter("inpdocumentno");
params.put("documentno", strdocumentno);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.hrm.payroll.create_txt.ArchivePayrollPaymentRuminahuiBankTXT().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process1D419EB151AE45A9A5C8B86371B9818A(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.quick.billing.ad_process.Sqb_PrintReportCloseQuickBillingByUser().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process6AA269C7FB70428AB269794614AD4742(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.quick.billing.ad_process.Sqb_CreateQuickBilling().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processEBCCB232196040B294F2E29F1846F9AC(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.quick.billing.ad_process.Sqb_CreateCustomerQuickBilling().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process4380C4EBA98A4E7EB784ABC1360FE8EA(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strcYearId = vars.getStringParameter("inpcYearId");
params.put("cYearId", strcYearId);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.hrm.payroll.create_txt.ArchivePaymentUtilitiesRuminahuiBankTXT().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process437B1EE180984960A698FB8154DE5D35(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strcYearId = vars.getStringParameter("inpcYearId");
params.put("cYearId", strcYearId);
String stroutputtype = vars.getStringParameter("inpoutputtype");
params.put("outputtype", stroutputtype);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.hrm.payroll.create_txt.UtilitiesCSV().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process837888BA221D47E6915FDE6DD361C1D9(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.cusoft.facturaec.ad_offline.fe_generation_offline().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process177A8D600E334A188E193EC8C647AED0(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.ecuador.asset.move.amortization.AssetLinearDepreciationMethodProcess().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process6F5F5FCC3C124629A02179A1D55DB636(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.ecuador.asset.move.ad_process.ProcessBatchDepreciationAssets().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process3FAE7B1AB61F4E61B67481247AE8215F(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.cusoft.facturaec.ad_process.Generate_Remission_Guide().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process7CC8083871A2456BAC7B948F3510BC3C(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.cusoft.facturaec.ad_process.Generate_Movement().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process8388633AADD04FC487A0AEA775448333(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strdocumentno = vars.getStringParameter("inpdocumentno");
params.put("documentno", strdocumentno);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.hrm.payroll.create_txt.ArchivePaymentProdubancoBankTXT().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processCD35DC8F54624AC0948C891C7F7E70A1(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strdocumentno = vars.getStringParameter("inpdocumentno");
params.put("documentno", strdocumentno);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.hrm.payroll.create_txt.ArchivePaymentTenthProdubanco().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processD93CCE4D4D954542BD7AA2F107404BAD(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String strcYearId = vars.getStringParameter("inpcYearId");
params.put("cYearId", strcYearId);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.hrm.payroll.create_txt.ArchivePaymentUtilitiesProdubanco().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process2DDE7D3618034C38A4462B7F3456C28D(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String straction = vars.getStringParameter("inpaction");
params.put("action", straction);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.advpaymentmngt.process.FIN_BankStatementProcess().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process58A9261BACEF45DDA526F29D8557272D(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        String straction = vars.getStringParameter("inpaction");
params.put("action", straction);

        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.advpaymentmngt.process.FIN_BankStatementProcess().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process64B3FF29AC174F4B94538BD0A3CE1CD3(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new org.openbravo.costing.CostingMigrationProcess().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process5192F005F0524EE1A59AD3DCA8CDF4A3(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.custom.payments.partialpayment.ad_process.Sspp_ConfrimTransferPartialPayment().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process9ADF860D48FF43788F60A062258492A0(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.com.sidesoft.secondary.accounting.SSACCT_AddPaymentFromJournal().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process0A94232190EE46A2B4D13CBF30C8F423(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new it.openia.crm.LeadProfilingRecordsGenerator().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processDBF26D81854746A19B1F2B1F0B4C0952(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new it.openia.crm.CaseSender().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void processB5C20B60DD3F4B4D93442FB7BE2DA6EA(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new it.openia.crm.CaseUpdateSender().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process77FC3840AB4A4814B8247BA69B484F87(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new it.openia.crm.InviteSender().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process0A7A590F8CF641B4B63AD85D83D5FD63(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new com.sidesoft.flopec.budget.ad_Process.ReviewCertificate().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }
    private void process66912CD2D96B494FA23F4AF2B7F795BA(String strProcessId, VariablesSecureApp vars, HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
        
        
        ProcessBundle pb = new ProcessBundle(strProcessId, vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ec.cusoft.facturaec.ad_process.GeneratePurchaseSettlement().execute(pb);
          if((OBError)pb.getResult()!=null){
            myMessage = (OBError) pb.getResult();
            myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
            myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
          }
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error("Error calling process", ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          }
        }

        processButtonHelper(request, response, vars, myMessage); 
   }


  public String getServletInfo() {
    return "Servlet ActionButton_Responser. This Servlet was made by Wad constructor";
  } // end of the getServletInfo() method

  private void processButtonHelper(HttpServletRequest request, HttpServletResponse response, VariablesSecureApp vars, OBError myMessage) 
     throws ServletException, IOException {
      advisePopUp(request, response, myMessage.getType(), myMessage.getTitle(), myMessage.getMessage());
  }
}
