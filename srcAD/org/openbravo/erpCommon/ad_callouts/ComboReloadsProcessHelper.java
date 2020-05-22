
package org.openbravo.erpCommon.ad_callouts;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.erpCommon.utility.ComboTableData;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.xmlEngine.XmlDocument;


public class ComboReloadsProcessHelper extends CalloutHelper {
  private static final long serialVersionUID = 1L;

  void printPage(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
   String strProcessId = vars.getStringParameter("inpadProcessId");
   
     if (strProcessId.equals("6255BE488882480599C81284B70CD9B3")) {
       process6255BE488882480599C81284B70CD9B3(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("C1349783EEA54D9494B0034D6424B5D2")) {
       processC1349783EEA54D9494B0034D6424B5D2(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("7035CF2A33C14C2688A401932AB3A028")) {
       process7035CF2A33C14C2688A401932AB3A028(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("930BF970C16640E39049FE957E0F41F8")) {
       process930BF970C16640E39049FE957E0F41F8(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("36415E726DE74F04BFAF026DD9038711")) {
       process36415E726DE74F04BFAF026DD9038711(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("785A5AE0739D404E8F1255B6E526B6F6")) {
       process785A5AE0739D404E8F1255B6E526B6F6(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("58A9261BACEF45DDA526F29D8557272D")) {
       process58A9261BACEF45DDA526F29D8557272D(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("0BDC2164ED3E48539FCEF4D306F29EFD")) {
       process0BDC2164ED3E48539FCEF4D306F29EFD(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("3548A9A058F2427ABFA7D664BBFAB9FC")) {
       process3548A9A058F2427ABFA7D664BBFAB9FC(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("C44B9B1B10574061BE489F8AF19E2202")) {
       processC44B9B1B10574061BE489F8AF19E2202(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("B5170DE3EA0B4D4FBEAB4FD19BEB8A6A")) {
       processB5170DE3EA0B4D4FBEAB4FD19BEB8A6A(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("4BD8913AD8C94F0AA9F81BC1BFC5874B")) {
       process4BD8913AD8C94F0AA9F81BC1BFC5874B(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("A0A2EADA7A4241A18FAECAC16939A644")) {
       processA0A2EADA7A4241A18FAECAC16939A644(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("BF50E41377E54EAA909BA4A385ADA280")) {
       processBF50E41377E54EAA909BA4A385ADA280(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("5DD1AA46AA584DED8A2C37026791AA61")) {
       process5DD1AA46AA584DED8A2C37026791AA61(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("4FD1E6ACB05E466094255CE3D4FAA338")) {
       process4FD1E6ACB05E466094255CE3D4FAA338(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("BD7C961A29A643C68C18507AE933BECE")) {
       processBD7C961A29A643C68C18507AE933BECE(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("B73F7827CF00490F9A5739EBCE8DC0CF")) {
       processB73F7827CF00490F9A5739EBCE8DC0CF(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("A822B5CBE10F4032803F0D7AC90261F6")) {
       processA822B5CBE10F4032803F0D7AC90261F6(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("9B2153B0D111459CAD4FAEC2CFB19F02")) {
       process9B2153B0D111459CAD4FAEC2CFB19F02(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("A171E9AE85D444338A245F080B01C0D5")) {
       processA171E9AE85D444338A245F080B01C0D5(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("D16D6A8B6D064730B366017596B5316A")) {
       processD16D6A8B6D064730B366017596B5316A(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("A096ED130B03469A9B57D986C50FB838")) {
       processA096ED130B03469A9B57D986C50FB838(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("224")) {
       process224(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("348D59136F8645AD8806DA0A854DB965")) {
       process348D59136F8645AD8806DA0A854DB965(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("108")) {
       process108(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("8E0340F567E946429D2050826A2D802E")) {
       process8E0340F567E946429D2050826A2D802E(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("155")) {
       process155(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("221")) {
       process221(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("BEE1975A3DC34447A6C5E609193B441D")) {
       processBEE1975A3DC34447A6C5E609193B441D(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("FE45F939437A49B19E7C959786ECCE3A")) {
       processFE45F939437A49B19E7C959786ECCE3A(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("4842943F0E2F4E13B109258AC8553D63")) {
       process4842943F0E2F4E13B109258AC8553D63(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("E810563A7A5E44929B487B20F9B19641")) {
       processE810563A7A5E44929B487B20F9B19641(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("5E00B35F1C974EA99D02B366AFDD0437")) {
       process5E00B35F1C974EA99D02B366AFDD0437(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("55E8FC206F1145E1B0683D36DAD72DEC")) {
       process55E8FC206F1145E1B0683D36DAD72DEC(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("F7115FF7535F4B1B8932C20DD15996DF")) {
       processF7115FF7535F4B1B8932C20DD15996DF(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("0719B2413BF04EFE9C2402A830AC5FC8")) {
       process0719B2413BF04EFE9C2402A830AC5FC8(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("EEEAD80E24FE4221BBFC086AD7E17AD8")) {
       processEEEAD80E24FE4221BBFC086AD7E17AD8(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("6BF16EFC772843AC9A17552AE0B26AB7")) {
       process6BF16EFC772843AC9A17552AE0B26AB7(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("5DC06629C50343499DA878CFBAE5AA3E")) {
       process5DC06629C50343499DA878CFBAE5AA3E(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("A9D3EBC6D98F4306B34442C22AF6C73A")) {
       processA9D3EBC6D98F4306B34442C22AF6C73A(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("99D49BDD337A4FF8B81231F7B2620163")) {
       process99D49BDD337A4FF8B81231F7B2620163(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("175")) {
       process175(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("0584DA2C77CB4122B2D7917BB421B302")) {
       process0584DA2C77CB4122B2D7917BB421B302(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("800163")) {
       process800163(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("A80CF18E882E4946881E803876894B50")) {
       processA80CF18E882E4946881E803876894B50(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("5F9D9C4FF27844C0A0B997642D6481FF")) {
       process5F9D9C4FF27844C0A0B997642D6481FF(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("D6F97EBF983746488C841A50214A4639")) {
       processD6F97EBF983746488C841A50214A4639(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("466F6E93DA86438E8B3F9DB6C0734AA4")) {
       process466F6E93DA86438E8B3F9DB6C0734AA4(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("58F6FA73AB3040D182068E7E5E6731FF")) {
       process58F6FA73AB3040D182068E7E5E6731FF(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("9E930637C9B44A73B0227D49AA30DD12")) {
       process9E930637C9B44A73B0227D49AA30DD12(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("819CBE9A5E9F47318DEC8FD0BADE15C3")) {
       process819CBE9A5E9F47318DEC8FD0BADE15C3(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("800131")) {
       process800131(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("A6D27B4A77D24AD08B25DCB70FF0B632")) {
       processA6D27B4A77D24AD08B25DCB70FF0B632(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("34081FAA0C434EB2B2484C345D49006F")) {
       process34081FAA0C434EB2B2484C345D49006F(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("AA5ABC49CE994897A11DA59F251B3686")) {
       processAA5ABC49CE994897A11DA59F251B3686(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("246FB8C734D04BB7834C3DFC4E4CA742")) {
       process246FB8C734D04BB7834C3DFC4E4CA742(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("017312F51139438A9665775E3B5392A1")) {
       process017312F51139438A9665775E3B5392A1(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("7A9AD4BA75494258A48AFECBFF8D6E70")) {
       process7A9AD4BA75494258A48AFECBFF8D6E70(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("09CD97BDA0A140E4AAFA186D7E2E7B4B")) {
       process09CD97BDA0A140E4AAFA186D7E2E7B4B(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("84EFF9F3A2B145D9A2AA2E7330B070FB")) {
       process84EFF9F3A2B145D9A2AA2E7330B070FB(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("48EF850A2A4B47F8821F8D14031472ED")) {
       process48EF850A2A4B47F8821F8D14031472ED(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("112")) {
       process112(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("FF8080812E2F8EAE012E2F94CF470014")) {
       processFF8080812E2F8EAE012E2F94CF470014(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("1C2C41FDF28A4A1684AD7A1D0E93FE37")) {
       process1C2C41FDF28A4A1684AD7A1D0E93FE37(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("171D526C7A5447B186B7A0F87244E4FC")) {
       process171D526C7A5447B186B7A0F87244E4FC(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("176")) {
       process176(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("FC40DEC74E12418FB7CA04A35A634419")) {
       processFC40DEC74E12418FB7CA04A35A634419(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("85877950A7C44A3F886D8ABD87C2B7BF")) {
       process85877950A7C44A3F886D8ABD87C2B7BF(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("FCB6C3AFA81A471CBE8954EE84EC9A1F")) {
       processFCB6C3AFA81A471CBE8954EE84EC9A1F(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("3C40792C947A47638FD6740F0FF8BCAA")) {
       process3C40792C947A47638FD6740F0FF8BCAA(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("F666D842BF6C419FA927365261354B4E")) {
       processF666D842BF6C419FA927365261354B4E(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("9337D1CEEC0647B888EC257259F025B2")) {
       process9337D1CEEC0647B888EC257259F025B2(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("953824D9E596435A9F7F036E7346C0AF")) {
       process953824D9E596435A9F7F036E7346C0AF(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("5A2A0AF88AF54BB085DCC52FCC9B17B7")) {
       process5A2A0AF88AF54BB085DCC52FCC9B17B7(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("140")) {
       process140(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("56518071D39043D6B0B87FFFE93E0E61")) {
       process56518071D39043D6B0B87FFFE93E0E61(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("54D424B44CC342DC8CAC57880C25C195")) {
       process54D424B44CC342DC8CAC57880C25C195(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("F68F2890E96D4D85A1DEF0274D105BCE")) {
       processF68F2890E96D4D85A1DEF0274D105BCE(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("739CED3FF1054A5F9A69A243DDFD3E4E")) {
       process739CED3FF1054A5F9A69A243DDFD3E4E(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("800136")) {
       process800136(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("154")) {
       process154(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("3E6636E8D13149A7B01231AA3530CE17")) {
       process3E6636E8D13149A7B01231AA3530CE17(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("63BB5E7F5B9643DFBA257F7F91C1009F")) {
       process63BB5E7F5B9643DFBA257F7F91C1009F(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("D234AE084F7040DCB66E281A4237FF99")) {
       processD234AE084F7040DCB66E281A4237FF99(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("800172")) {
       process800172(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("4149C945342A4DA2A2CDC9C367B5B72A")) {
       process4149C945342A4DA2A2CDC9C367B5B72A(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("E928D18E8BD44BA596AE1436DB3FC90D")) {
       processE928D18E8BD44BA596AE1436DB3FC90D(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("CDE0D5A454684752AD4E3AE241EF8821")) {
       processCDE0D5A454684752AD4E3AE241EF8821(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("073A24C010DB437CBE2F5045FF391C0C")) {
       process073A24C010DB437CBE2F5045FF391C0C(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("EFBD3CAED270415894992F58236E3241")) {
       processEFBD3CAED270415894992F58236E3241(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("2FE29E6E07404609818FD55BFC2AE7D2")) {
       process2FE29E6E07404609818FD55BFC2AE7D2(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("23D1B163EC0B41F790CE39BF01DA320E")) {
       process23D1B163EC0B41F790CE39BF01DA320E(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("059C7B83511F4CC4AA037026569AF57E")) {
       process059C7B83511F4CC4AA037026569AF57E(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("A8674311F55D4AABB24EED50AB2BF9AB")) {
       processA8674311F55D4AABB24EED50AB2BF9AB(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("DC855AE32FDC4BE1A91C35D27A29DFAE")) {
       processDC855AE32FDC4BE1A91C35D27A29DFAE(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("BCCB498B375F4189B48F4844C41DEADE")) {
       processBCCB498B375F4189B48F4844C41DEADE(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("2DDE7D3618034C38A4462B7F3456C28D")) {
       process2DDE7D3618034C38A4462B7F3456C28D(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("E7C6834B50B34E9C93D17651673B6E1B")) {
       processE7C6834B50B34E9C93D17651673B6E1B(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("CB808DD623804DC58F144CC5D7D45FFB")) {
       processCB808DD623804DC58F144CC5D7D45FFB(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("A347E177486848CDB548D5ECA1CFD6E6")) {
       processA347E177486848CDB548D5ECA1CFD6E6(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("F70CBA510FBD4A41B4468490D82CCBDF")) {
       processF70CBA510FBD4A41B4468490D82CCBDF(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("5337EE4017214D7F90AF9DD00F2E6DE7")) {
       process5337EE4017214D7F90AF9DD00F2E6DE7(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("617A01DD098A42D2B78CEDCFDB078F90")) {
       process617A01DD098A42D2B78CEDCFDB078F90(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("F126D2397DC34A4C8202D361A631A848")) {
       processF126D2397DC34A4C8202D361A631A848(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("DE363C2279934FE08CCF266B5CD4C296")) {
       processDE363C2279934FE08CCF266B5CD4C296(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("E264309FF8244A94936502BF51829109")) {
       processE264309FF8244A94936502BF51829109(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("D615D7D7DCE541E4849B88DAEEED8253")) {
       processD615D7D7DCE541E4849B88DAEEED8253(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("18BBDA4443DB4CEC8287036B0CB2E586")) {
       process18BBDA4443DB4CEC8287036B0CB2E586(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("91A8DDAABA474E97AA8F1F44E68B5526")) {
       process91A8DDAABA474E97AA8F1F44E68B5526(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("8BD1617B9D134461B37AA2A7E7C227C3")) {
       process8BD1617B9D134461B37AA2A7E7C227C3(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("B53CBF732CAB4EBBBF2F4F620FE4A136")) {
       processB53CBF732CAB4EBBBF2F4F620FE4A136(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("7404C291E97A4E95A335F6801976BE0B")) {
       process7404C291E97A4E95A335F6801976BE0B(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("D3FE9C9093054C2194A6BBAB95D9DAB9")) {
       processD3FE9C9093054C2194A6BBAB95D9DAB9(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("1004400000")) {
       process1004400000(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("800075")) {
       process800075(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("4C3A2C75B70F42A78B7B8DBF3FD15A6F")) {
       process4C3A2C75B70F42A78B7B8DBF3FD15A6F(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("8049DB455663436491DE46EF6E49B686")) {
       process8049DB455663436491DE46EF6E49B686(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("74A0DDCBA57D40738D6080C23BC6815B")) {
       process74A0DDCBA57D40738D6080C23BC6815B(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("225")) {
       process225(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("8C0C61BB43FE43D1B5D6B7710D38AD8D")) {
       process8C0C61BB43FE43D1B5D6B7710D38AD8D(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("2F4E363962094B46B5F17569F82063B7")) {
       process2F4E363962094B46B5F17569F82063B7(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("CC0E4572F5334B2AB8AE9DB977B44860")) {
       processCC0E4572F5334B2AB8AE9DB977B44860(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("E041B544CC384252BDE836DB9B62D0E8")) {
       processE041B544CC384252BDE836DB9B62D0E8(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("598CD3CFC58549CB9267C4B37D50D4F6")) {
       process598CD3CFC58549CB9267C4B37D50D4F6(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("80EB3DB8BA62441CB2D5AA17B5331AA1")) {
       process80EB3DB8BA62441CB2D5AA17B5331AA1(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("45A5EE58A3834A38BC256A831DD632D8")) {
       process45A5EE58A3834A38BC256A831DD632D8(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("ECC738C8BD194D629534D94F616FBCA1")) {
       processECC738C8BD194D629534D94F616FBCA1(response, vars, strTabId, windowId);
       return;
     }
    
     if (strProcessId.equals("5498B90303C245F0B9FEF1D5021BC059")) {
       process5498B90303C245F0B9FEF1D5021BC059(response, vars, strTabId, windowId);
       return;
     }
    
    
    pageError(response);
  }
  
  
    private void process6255BE488882480599C81284B70CD9B3(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads6255BE488882480599C81284B70CD9B3';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpemAprmProcessPayment", "inpemAprmProcessPayment", "inpfinPaymentId", "inpemAprmProcessPayment", "inpfinPaymentId", "inpemAprmProcessPayment", "inpstatus", "inpemAprmProcessPayment")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "action", "36972531DA994BB38ECB91993058282F", "575E470ABADB4C278132C957A78C47E3", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpaction";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processC1349783EEA54D9494B0034D6424B5D2(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsC1349783EEA54D9494B0034D6424B5D2';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_User_ID", "110", "346C1C93C1E747EB9E5CE7368909DD0B", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process7035CF2A33C14C2688A401932AB3A028(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads7035CF2A33C14C2688A401932AB3A028';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "0D644423F84947E98CB502BE8F4B30D6", "E468F380BF13415687165A6403B79E1A", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "ad_org_id", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "nivel", "CBEB2EA7397B461DB43333511804F1C8", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpnivel";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "User1_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpuser1Id";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "C_CostCenter_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcCostcenterId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process930BF970C16640E39049FE957E0F41F8(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads930BF970C16640E39049FE957E0F41F8';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_User_ID", "B6A2E8C9939A4998B7FD4A254E34497C", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process36415E726DE74F04BFAF026DD9038711(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads36415E726DE74F04BFAF026DD9038711';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adClientId", "inp#adOrgId", "inp#adClientId", "inp#adOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "C_DocTypeTarget_ID", "170", "9B3C7259B0284EFCA8DD209BA6134E68", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcDoctypetargetId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process785A5AE0739D404E8F1255B6E526B6F6(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads785A5AE0739D404E8F1255B6E526B6F6';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_User_ID", "110", "EDED1A9C91E94F45938EFB7E2769BD9E", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "Posted", "2D725D380DD3459DBA63DB04A3A533C4", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpposted";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_Org_ID", "276", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process58A9261BACEF45DDA526F29D8557272D(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads58A9261BACEF45DDA526F29D8557272D';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpprocessed", "inpprocessed")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "action", "EC75B6F5A9504DB6B3F3356EA85F15EE", "CA425689672A42D7BE2158EE41E44F94", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpaction";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process0BDC2164ED3E48539FCEF4D306F29EFD(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads0BDC2164ED3E48539FCEF4D306F29EFD';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpemAprmProcess", "inpemAprmProcess")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "action", "798239EB069F41A9BA8EE040C63DDBBC", "3842B167CA6F44239C3357A721E3BA6A", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpaction";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process3548A9A058F2427ABFA7D664BBFAB9FC(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads3548A9A058F2427ABFA7D664BBFAB9FC';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "110", "8A60F870D20949ADAEC8C1B3327C01D6", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processC44B9B1B10574061BE489F8AF19E2202(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsC44B9B1B10574061BE489F8AF19E2202';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "4A2704DCBCBD42D6A5464AAF7CEE5F40", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "c_city_id", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcCityId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "ad_org_id", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processB5170DE3EA0B4D4FBEAB4FD19BEB8A6A(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsB5170DE3EA0B4D4FBEAB4FD19BEB8A6A';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "110", "346C1C93C1E747EB9E5CE7368909DD0B", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process4BD8913AD8C94F0AA9F81BC1BFC5874B(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads4BD8913AD8C94F0AA9F81BC1BFC5874B';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "110", "A03D5A5CAC154AD39EB39FB9E2C6C56E", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processA0A2EADA7A4241A18FAECAC16939A644(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsA0A2EADA7A4241A18FAECAC16939A644';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "Docstatus", "7F41446F81B8443BB6C8487EC5EF76A9", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpdocstatus";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_ORG_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processBF50E41377E54EAA909BA4A385ADA280(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsBF50E41377E54EAA909BA4A385ADA280';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_USER_ID", "", "55CF2C913D74470BAE16F5BF288A7D48", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process5DD1AA46AA584DED8A2C37026791AA61(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads5DD1AA46AA584DED8A2C37026791AA61';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_User_ID", "110", "D457D756A43F48F58F01C7FF6601BA6B", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process4FD1E6ACB05E466094255CE3D4FAA338(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads4FD1E6ACB05E466094255CE3D4FAA338';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpendperiod", "inpendperiod")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "EndPeriod", "423DA51196E442C9BCAABF60EC51D7B3", "C33222DB27D84183BE99E585BB463A92", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpendperiod";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpstartperiod", "inpstartperiod")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "StartPeriod", "423DA51196E442C9BCAABF60EC51D7B3", "C561ACC971D842708CD8A6A5D07618F9", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpstartperiod";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processBD7C961A29A643C68C18507AE933BECE(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsBD7C961A29A643C68C18507AE933BECE';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "ad_org_id", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processB73F7827CF00490F9A5739EBCE8DC0CF(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsB73F7827CF00490F9A5739EBCE8DC0CF';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "C3C90E60A3624BD099465A59125247F7", "064515359D8F41A5BA6E99C3594294A5", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processA822B5CBE10F4032803F0D7AC90261F6(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsA822B5CBE10F4032803F0D7AC90261F6';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adClientId", "inp#adOrgId", "inp#adClientId", "inp#adOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "C_DocTypeTarget_ID", "170", "9B3C7259B0284EFCA8DD209BA6134E68", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcDoctypetargetId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "Posted", "7F41446F81B8443BB6C8487EC5EF76A9", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpposted";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_Org_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process9B2153B0D111459CAD4FAEC2CFB19F02(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads9B2153B0D111459CAD4FAEC2CFB19F02';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "Docstatus", "7F41446F81B8443BB6C8487EC5EF76A9", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpdocstatus";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_ORG_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processA171E9AE85D444338A245F080B01C0D5(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsA171E9AE85D444338A245F080B01C0D5';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpcCostcenterId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "USER1_ID", "F0636247C0194954AAD23B6715BF7557", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpuser1Id";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpcCostcenterId", "inpuser1Id")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "USER2_ID", "7CCD8BE549594FEDA7A7EF54A9BDC87C", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpuser2Id";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processD16D6A8B6D064730B366017596B5316A(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsD16D6A8B6D064730B366017596B5316A';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpstartperiod", "inpstartperiod")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "EndPeriod", "423DA51196E442C9BCAABF60EC51D7B3", "44C55EDC83864BD58E759EE52404EB26", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpendperiod";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpendperiod", "inpendperiod")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "StartPeriod", "423DA51196E442C9BCAABF60EC51D7B3", "C61660C5ADB1450D986E6DD2833194DC", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpstartperiod";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processA096ED130B03469A9B57D986C50FB838(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsA096ED130B03469A9B57D986C50FB838';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_User_ID", "110", "A03D5A5CAC154AD39EB39FB9E2C6C56E", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process224(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads224';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpcProjectId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "C_ProjectLine_ID", "", "175", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcProjectlineId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process348D59136F8645AD8806DA0A854DB965(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads348D59136F8645AD8806DA0A854DB965';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpcCostcenterId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "USER1_ID", "CBD9F5E584B74DBDB9310AF965F56217", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpuser1Id";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpcCostcenterId", "inpuser1Id")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "USER2_ID", "4FA861973E3D4526A61B781461100335", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpuser2Id";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process108(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads108';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpcAcctschemaId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "C_AcctSchema_ID", "", "FDA7BA9355A6468DAF67E1C5288990A6", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcAcctschemaId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process8E0340F567E946429D2050826A2D802E(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads8E0340F567E946429D2050826A2D802E';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpendperiod", "inpendperiod")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "StartPeriod", "423DA51196E442C9BCAABF60EC51D7B3", "C61660C5ADB1450D986E6DD2833194DC", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpstartperiod";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process155(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads155';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpinppaymentrule")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "PaymentRule", "195", "162", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inppaymentrule";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process221(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads221';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "C_BankAccount_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcBankaccountId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processBEE1975A3DC34447A6C5E609193B441D(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsBEE1975A3DC34447A6C5E609193B441D';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "8989E0B3E3674CE2ADD70FBF0107960F", "C407EB6DA1774487A8CCB456EC1C8E3D", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processFE45F939437A49B19E7C959786ECCE3A(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsFE45F939437A49B19E7C959786ECCE3A';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpcCostcenterId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "USER1_ID", "CBD9F5E584B74DBDB9310AF965F56217", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpuser1Id";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpcCostcenterId", "inpuser1Id")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "USER2_ID", "4FA861973E3D4526A61B781461100335", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpuser2Id";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process4842943F0E2F4E13B109258AC8553D63(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads4842943F0E2F4E13B109258AC8553D63';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_Org_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processE810563A7A5E44929B487B20F9B19641(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsE810563A7A5E44929B487B20F9B19641';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adClientId", "inp#adOrgId", "inp#adClientId", "inp#adOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "C_DocTypeTarget_ID", "170", "9B3C7259B0284EFCA8DD209BA6134E68", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcDoctypetargetId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process5E00B35F1C974EA99D02B366AFDD0437(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads5E00B35F1C974EA99D02B366AFDD0437';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "8989E0B3E3674CE2ADD70FBF0107960F", "C407EB6DA1774487A8CCB456EC1C8E3D", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process55E8FC206F1145E1B0683D36DAD72DEC(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads55E8FC206F1145E1B0683D36DAD72DEC';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#userClient")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "ad_client_id", "129", "103", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadClientId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadClientId", "inpadClientId", "inp#userClient", "inp#userOrg")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "ad_org_id", "276", "104", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "sales_stage", "8AEE970AF96B4F35BB80D53205A3BBCF", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpsalesStage";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "opportstatus", "1A136B80CA924A71B895B2BAA2D0EDC8", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpopportstatus";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processF7115FF7535F4B1B8932C20DD15996DF(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsF7115FF7535F4B1B8932C20DD15996DF';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_User_ID", "110", "346C1C93C1E747EB9E5CE7368909DD0B", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process0719B2413BF04EFE9C2402A830AC5FC8(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads0719B2413BF04EFE9C2402A830AC5FC8';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpinpoutputtype")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "2844588CA3124DC0BF0364053DF56126", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processEEEAD80E24FE4221BBFC086AD7E17AD8(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsEEEAD80E24FE4221BBFC086AD7E17AD8';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "Docstatus", "7F41446F81B8443BB6C8487EC5EF76A9", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpdocstatus";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_ORG_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process6BF16EFC772843AC9A17552AE0B26AB7(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads6BF16EFC772843AC9A17552AE0B26AB7';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpprocessed", "inpprocessed")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "action", "FF8080812E443491012E443C053A001A", "FF808081332719060133271E5BB1001B", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpaction";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process5DC06629C50343499DA878CFBAE5AA3E(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads5DC06629C50343499DA878CFBAE5AA3E';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpactivityType")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "Activity_Status", "4AF7C49CF7A84AC084E23CDFAF1F6584", "DBF434EE3D954E28B02FCBB03869D060", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpactivityStatus";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processA9D3EBC6D98F4306B34442C22AF6C73A(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsA9D3EBC6D98F4306B34442C22AF6C73A';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_User_ID", "110", "B06611B34B894A4892D75E2E9DC6B432", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process99D49BDD337A4FF8B81231F7B2620163(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads99D49BDD337A4FF8B81231F7B2620163';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "0D644423F84947E98CB502BE8F4B30D6", "E468F380BF13415687165A6403B79E1A", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_ORG_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "USER1_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpuser1Id";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "C_COSTCENTER_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcCostcenterId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process175(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads175';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#userClient")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "Ad_Client_ID", "", "103", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadClientId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inp#adLanguage")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_Table_ID", "800022", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadTableId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process0584DA2C77CB4122B2D7917BB421B302(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads0584DA2C77CB4122B2D7917BB421B302';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adClientId", "inp#adOrgId", "inp#adClientId", "inp#adOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "C_DocTypeTarget_ID", "170", "BE610A5797874F5CBF0667E8519695EB", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcDoctypetargetId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "110", "07457FFB378D4EBD9B14A959884BDAA1", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process800163(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads800163';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "M_Warehouse_ID", "", "71188F0005494DA08311B4FFB2C5A993", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpmWarehouseId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processA80CF18E882E4946881E803876894B50(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsA80CF18E882E4946881E803876894B50';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "4E075467EB874372A3E081E9D820C99A", "37E3A545D50D4B9EBDF76F0668BE5E0A", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process5F9D9C4FF27844C0A0B997642D6481FF(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads5F9D9C4FF27844C0A0B997642D6481FF';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "C3C90E60A3624BD099465A59125247F7", "064515359D8F41A5BA6E99C3594294A5", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processD6F97EBF983746488C841A50214A4639(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsD6F97EBF983746488C841A50214A4639';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "ad_user", "110", "8A60F870D20949ADAEC8C1B3327C01D6", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUser";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "m_product_id", "1F603F334B704F53928B8DB908611657", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpmProductId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "ad_org_id", "276", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "m_prod_category", "163", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpmProdCategory";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process466F6E93DA86438E8B3F9DB6C0734AA4(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads466F6E93DA86438E8B3F9DB6C0734AA4';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_User_ID", "110", "A03D5A5CAC154AD39EB39FB9E2C6C56E", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process58F6FA73AB3040D182068E7E5E6731FF(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads58F6FA73AB3040D182068E7E5E6731FF';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpcYearId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "ssph_tenth_settlement", "FFE5B4CD8D364932B4D96EFBD973500E", "7DF7DD0790BC4279920FB9D95261AFAF", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpssphTenthSettlement";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "ad_user_id", "110", "A03D5A5CAC154AD39EB39FB9E2C6C56E", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process9E930637C9B44A73B0227D49AA30DD12(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads9E930637C9B44A73B0227D49AA30DD12';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "ad_org_id", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "c_city_id", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcCityId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process819CBE9A5E9F47318DEC8FD0BADE15C3(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads819CBE9A5E9F47318DEC8FD0BADE15C3';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "110", "A03D5A5CAC154AD39EB39FB9E2C6C56E", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process800131(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads800131';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpstatus", "inpstatus")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "action", "657B89EF105149F2B011CF8F5034FF92", "C5A7AABB91A440EBAA53A0222B99FF2F", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpaction";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processA6D27B4A77D24AD08B25DCB70FF0B632(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsA6D27B4A77D24AD08B25DCB70FF0B632';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "Ad_User_Id", "110", "D091C881E4F744C4826FE24EDA041A46", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process34081FAA0C434EB2B2484C345D49006F(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads34081FAA0C434EB2B2484C345D49006F';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "C3C90E60A3624BD099465A59125247F7", "064515359D8F41A5BA6E99C3594294A5", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processAA5ABC49CE994897A11DA59F251B3686(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsAA5ABC49CE994897A11DA59F251B3686';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "C3C90E60A3624BD099465A59125247F7", "064515359D8F41A5BA6E99C3594294A5", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process246FB8C734D04BB7834C3DFC4E4CA742(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads246FB8C734D04BB7834C3DFC4E4CA742';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "Docstatus", "7F41446F81B8443BB6C8487EC5EF76A9", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpdocstatus";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_ORG_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process017312F51139438A9665775E3B5392A1(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads017312F51139438A9665775E3B5392A1';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpemAprmProcess", "inpemAprmProcess")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "action", "798239EB069F41A9BA8EE040C63DDBBC", "3842B167CA6F44239C3357A721E3BA6A", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpaction";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process7A9AD4BA75494258A48AFECBFF8D6E70(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads7A9AD4BA75494258A48AFECBFF8D6E70';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "C3C90E60A3624BD099465A59125247F7", "064515359D8F41A5BA6E99C3594294A5", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process09CD97BDA0A140E4AAFA186D7E2E7B4B(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads09CD97BDA0A140E4AAFA186D7E2E7B4B';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "Docstatus", "7F41446F81B8443BB6C8487EC5EF76A9", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpdocstatus";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_ORG_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process84EFF9F3A2B145D9A2AA2E7330B070FB(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads84EFF9F3A2B145D9A2AA2E7330B070FB';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "Docstatus", "7F41446F81B8443BB6C8487EC5EF76A9", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpdocstatus";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_ORG_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process48EF850A2A4B47F8821F8D14031472ED(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads48EF850A2A4B47F8821F8D14031472ED';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_Org_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process112(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads112';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId", "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "C_AcctSchema_ID", "", "FF8081812F06A183012F07323A2A001C", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcAcctschemaId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processFF8080812E2F8EAE012E2F94CF470014(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsFF8080812E2F8EAE012E2F94CF470014';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpprocessed", "inpprocessed")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "action", "FF8080812E443491012E443C053A001A", "FF808081332719060133271E5BB1001B", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpaction";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process1C2C41FDF28A4A1684AD7A1D0E93FE37(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads1C2C41FDF28A4A1684AD7A1D0E93FE37';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "3661EF23F0FB4424B62EDAC76010CF19", "80AEBDF1DE4C4D6B8E32222A78BFBADD", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process171D526C7A5447B186B7A0F87244E4FC(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads171D526C7A5447B186B7A0F87244E4FC';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "C3C90E60A3624BD099465A59125247F7", "064515359D8F41A5BA6E99C3594294A5", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process176(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads176';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#userClient")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "Ad_Client_ID", "", "103", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadClientId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inp#adLanguage")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_Table_ID", "800022", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadTableId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processFC40DEC74E12418FB7CA04A35A634419(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsFC40DEC74E12418FB7CA04A35A634419';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_User_ID", "", "B06611B34B894A4892D75E2E9DC6B432", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process85877950A7C44A3F886D8ABD87C2B7BF(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads85877950A7C44A3F886D8ABD87C2B7BF';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adClientId", "inp#adOrgId", "inp#adClientId", "inp#adOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "C_DocTypeTarget_ID", "170", "68E0C439D57D4081A57C979E1CC5F55F", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcDoctypetargetId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processFCB6C3AFA81A471CBE8954EE84EC9A1F(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsFCB6C3AFA81A471CBE8954EE84EC9A1F';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpendperiod", "inpendperiod")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "StartPeriod", "423DA51196E442C9BCAABF60EC51D7B3", "C61660C5ADB1450D986E6DD2833194DC", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpstartperiod";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process3C40792C947A47638FD6740F0FF8BCAA(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads3C40792C947A47638FD6740F0FF8BCAA';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "Ad_User_Id", "FD6B72335EE2471585B9D99F01186B71", "758D95F7C85A4853B746A9ADE5D2F4C8", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "Ad_Org_Id", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processF666D842BF6C419FA927365261354B4E(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsF666D842BF6C419FA927365261354B4E';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpcProjectId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "C_ProjectLine_ID", "", "175", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcProjectlineId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process9337D1CEEC0647B888EC257259F025B2(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads9337D1CEEC0647B888EC257259F025B2';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_ORG_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process953824D9E596435A9F7F036E7346C0AF(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads953824D9E596435A9F7F036E7346C0AF';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_User_ID", "110", "A03D5A5CAC154AD39EB39FB9E2C6C56E", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process5A2A0AF88AF54BB085DCC52FCC9B17B7(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads5A2A0AF88AF54BB085DCC52FCC9B17B7';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpresStatus", "inpresStatus", "inpresStatus", "inpresStatus")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "RES_Action", "440DDA64A43F4799AAFF48BC86DC8F78", "1645143617E44289A08A1EA4D617A184", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpresAction";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process140(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads140';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId", "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "C_AcctSchema_ID", "", "FF8081812F06A183012F07323A2A001C", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcAcctschemaId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process56518071D39043D6B0B87FFFE93E0E61(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads56518071D39043D6B0B87FFFE93E0E61';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "Ad_User", "110", "A03D5A5CAC154AD39EB39FB9E2C6C56E", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUser";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process54D424B44CC342DC8CAC57880C25C195(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads54D424B44CC342DC8CAC57880C25C195';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "AB84E0BFCA7442AEB32F740217F646DD", "FC9B5D2EFC904975BC20A1CC6216E40F", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processF68F2890E96D4D85A1DEF0274D105BCE(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsF68F2890E96D4D85A1DEF0274D105BCE';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpprocessed", "inpprocessed")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "action", "F671DDEA466D41A996F605590CB545BC", "FAE0D7C8A9D84FAFAE3C10CD5DCE6E30", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpaction";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process739CED3FF1054A5F9A69A243DDFD3E4E(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads739CED3FF1054A5F9A69A243DDFD3E4E';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpendperiod", "inpendperiod")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "StartPeriod", "423DA51196E442C9BCAABF60EC51D7B3", "C61660C5ADB1450D986E6DD2833194DC", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpstartperiod";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process800136(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads800136';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId", "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "C_AcctSchema_ID", "", "FF8081812F06A183012F07323A2A001C", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcAcctschemaId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process154(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads154';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpissotrx", "inpadOrgId", "inpadClientId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "M_PriceList_Version_ID", "", "26D8602C48004E1182B46310DF7015AE", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpmPricelistVersionId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process3E6636E8D13149A7B01231AA3530CE17(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads3E6636E8D13149A7B01231AA3530CE17';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpcCostcenterId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "USER1_ID", "CBD9F5E584B74DBDB9310AF965F56217", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpuser1Id";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpcCostcenterId", "inpuser1Id")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "USER2_ID", "4FA861973E3D4526A61B781461100335", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpuser2Id";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process63BB5E7F5B9643DFBA257F7F91C1009F(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads63BB5E7F5B9643DFBA257F7F91C1009F';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpendperiod", "inpendperiod")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "StartPeriod", "423DA51196E442C9BCAABF60EC51D7B3", "C61660C5ADB1450D986E6DD2833194DC", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpstartperiod";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processD234AE084F7040DCB66E281A4237FF99(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsD234AE084F7040DCB66E281A4237FF99';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adRoleId", "inp#adRoleId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_Org_ID", "", "D9463AFD77E44F619D396C19BF9E6A15", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "reportType", "B82C3C28E51F4AA6B87D98E7ABBF92F0", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpreporttype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "C_AcctSchema_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcAcctschemaId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process800172(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads800172';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpinpoutputtype")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "1000200002", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process4149C945342A4DA2A2CDC9C367B5B72A(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads4149C945342A4DA2A2CDC9C367B5B72A';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_ORG_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "Docstatus", "7F41446F81B8443BB6C8487EC5EF76A9", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpdocstatus";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processE928D18E8BD44BA596AE1436DB3FC90D(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsE928D18E8BD44BA596AE1436DB3FC90D';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "C3C90E60A3624BD099465A59125247F7", "064515359D8F41A5BA6E99C3594294A5", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processCDE0D5A454684752AD4E3AE241EF8821(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsCDE0D5A454684752AD4E3AE241EF8821';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "Financial_Account_ID", "DF1CEA94B3564A33AFDB37C07E1CE353", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpfinancialAccountId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process073A24C010DB437CBE2F5045FF391C0C(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads073A24C010DB437CBE2F5045FF391C0C';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpendperiod", "inpendperiod")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "StartPeriod", "423DA51196E442C9BCAABF60EC51D7B3", "C61660C5ADB1450D986E6DD2833194DC", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpstartperiod";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processEFBD3CAED270415894992F58236E3241(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsEFBD3CAED270415894992F58236E3241';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "Ad_User_Id", "110", "EDED1A9C91E94F45938EFB7E2769BD9E", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process2FE29E6E07404609818FD55BFC2AE7D2(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads2FE29E6E07404609818FD55BFC2AE7D2';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "ad_org_id", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "StartPeriod", "185F8664184A47B0BDC46266BA399B11", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpstartperiod";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process23D1B163EC0B41F790CE39BF01DA320E(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads23D1B163EC0B41F790CE39BF01DA320E';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpissotrx", "inpadClientId", "inpadOrgId", "inp#adClientId", "inpmProductId", "inpissotrx", "inpadOrgId", "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "C_Tax_ID", "", "299FA667CF374AC5ACC74739C3251134", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcTaxId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process059C7B83511F4CC4AA037026569AF57E(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads059C7B83511F4CC4AA037026569AF57E';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "C3C90E60A3624BD099465A59125247F7", "064515359D8F41A5BA6E99C3594294A5", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processA8674311F55D4AABB24EED50AB2BF9AB(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsA8674311F55D4AABB24EED50AB2BF9AB';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId", "inp#adClientId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "c_doctype_ID", "", "59D0BFCA70244A759DF360574891931C", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcDoctypeId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "Ad_User_Id", "110", "8A60F870D20949ADAEC8C1B3327C01D6", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processDC855AE32FDC4BE1A91C35D27A29DFAE(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsDC855AE32FDC4BE1A91C35D27A29DFAE';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "Ad_User_Id", "", "39DEE2C0EE4D4D1F9DF945CCE46380FB", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processBCCB498B375F4189B48F4844C41DEADE(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsBCCB498B375F4189B48F4844C41DEADE';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpstartperiod", "inpstartperiod")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "EndPeriod", "423DA51196E442C9BCAABF60EC51D7B3", "44C55EDC83864BD58E759EE52404EB26", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpendperiod";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpendperiod", "inpendperiod")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "StartPeriod", "423DA51196E442C9BCAABF60EC51D7B3", "C61660C5ADB1450D986E6DD2833194DC", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpstartperiod";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process2DDE7D3618034C38A4462B7F3456C28D(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads2DDE7D3618034C38A4462B7F3456C28D';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpprocessed", "inpprocessed")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "action", "EC75B6F5A9504DB6B3F3356EA85F15EE", "CA425689672A42D7BE2158EE41E44F94", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpaction";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processE7C6834B50B34E9C93D17651673B6E1B(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsE7C6834B50B34E9C93D17651673B6E1B';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "C3C90E60A3624BD099465A59125247F7", "064515359D8F41A5BA6E99C3594294A5", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processCB808DD623804DC58F144CC5D7D45FFB(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsCB808DD623804DC58F144CC5D7D45FFB';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpcYearId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "C_Period_ID", "65447418FD4D428CA025AC9AF26ADA21", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcPeriodId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processA347E177486848CDB548D5ECA1CFD6E6(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsA347E177486848CDB548D5ECA1CFD6E6';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_ORG_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processF70CBA510FBD4A41B4468490D82CCBDF(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsF70CBA510FBD4A41B4468490D82CCBDF';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "0D644423F84947E98CB502BE8F4B30D6", "E468F380BF13415687165A6403B79E1A", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "ad_org_id", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "nivel", "CBEB2EA7397B461DB43333511804F1C8", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpnivel";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process5337EE4017214D7F90AF9DD00F2E6DE7(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads5337EE4017214D7F90AF9DD00F2E6DE7';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "0D644423F84947E98CB502BE8F4B30D6", "E468F380BF13415687165A6403B79E1A", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "nivel", "CBEB2EA7397B461DB43333511804F1C8", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpnivel";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "ad_org_id", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process617A01DD098A42D2B78CEDCFDB078F90(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads617A01DD098A42D2B78CEDCFDB078F90';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpcCostcenterId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "USER1_ID", "CBD9F5E584B74DBDB9310AF965F56217", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpuser1Id";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpcCostcenterId", "inpuser1Id")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "USER2_ID", "4FA861973E3D4526A61B781461100335", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpuser2Id";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processF126D2397DC34A4C8202D361A631A848(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsF126D2397DC34A4C8202D361A631A848';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "Ad_User_Id", "", "B06611B34B894A4892D75E2E9DC6B432", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processDE363C2279934FE08CCF266B5CD4C296(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsDE363C2279934FE08CCF266B5CD4C296';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_User_ID", "110", "A03D5A5CAC154AD39EB39FB9E2C6C56E", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processE264309FF8244A94936502BF51829109(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsE264309FF8244A94936502BF51829109';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#userClient")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "Ad_Client_ID", "", "103", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadClientId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inp#adLanguage")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_Table_ID", "800022", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadTableId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processD615D7D7DCE541E4849B88DAEEED8253(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsD615D7D7DCE541E4849B88DAEEED8253';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_USER_ID", "", "8A60F870D20949ADAEC8C1B3327C01D6", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process18BBDA4443DB4CEC8287036B0CB2E586(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads18BBDA4443DB4CEC8287036B0CB2E586';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "Docstatus", "7F41446F81B8443BB6C8487EC5EF76A9", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpdocstatus";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_ORG_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process91A8DDAABA474E97AA8F1F44E68B5526(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads91A8DDAABA474E97AA8F1F44E68B5526';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpendperiod", "inpendperiod")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "EndPeriod", "423DA51196E442C9BCAABF60EC51D7B3", "C33222DB27D84183BE99E585BB463A92", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpendperiod";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpstartperiod", "inpstartperiod")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "StartPeriod", "423DA51196E442C9BCAABF60EC51D7B3", "C561ACC971D842708CD8A6A5D07618F9", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpstartperiod";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process8BD1617B9D134461B37AA2A7E7C227C3(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads8BD1617B9D134461B37AA2A7E7C227C3';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "110", "A41D78E0F41E47A9816DF2B5DB278083", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processB53CBF732CAB4EBBBF2F4F620FE4A136(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsB53CBF732CAB4EBBBF2F4F620FE4A136';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "ad_user_id", "110", "EDED1A9C91E94F45938EFB7E2769BD9E", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "posted", "2D725D380DD3459DBA63DB04A3A533C4", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpposted";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "ad_org_id", "276", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process7404C291E97A4E95A335F6801976BE0B(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads7404C291E97A4E95A335F6801976BE0B';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adClientId", "inp#adOrgId", "inp#adClientId", "inp#adOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "C_DocTypeTarget_ID", "170", "9B3C7259B0284EFCA8DD209BA6134E68", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcDoctypetargetId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processD3FE9C9093054C2194A6BBAB95D9DAB9(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsD3FE9C9093054C2194A6BBAB95D9DAB9';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "ad_user_id", "110", "A03D5A5CAC154AD39EB39FB9E2C6C56E", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process1004400000(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads1004400000';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "M_Warehouse_ID", "", "A3DCDE5EDD4A4403AC205B131F10F84D", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpmWarehouseId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process800075(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads800075';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adClientId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "M_Warehouse_ID", "197", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpmWarehouseId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process4C3A2C75B70F42A78B7B8DBF3FD15A6F(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads4C3A2C75B70F42A78B7B8DBF3FD15A6F';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "Docstatus", "7F41446F81B8443BB6C8487EC5EF76A9", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpdocstatus";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_ORG_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process8049DB455663436491DE46EF6E49B686(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads8049DB455663436491DE46EF6E49B686';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inptypereason")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "ssam_reason_alienate_id", "", "A248F645E46B432EACE740D54F571CAC", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpssamReasonAlienateId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process74A0DDCBA57D40738D6080C23BC6815B(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads74A0DDCBA57D40738D6080C23BC6815B';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpcProjectId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "C_ProjectLine_ID", "", "174", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcProjectlineId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process225(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads225';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpcProjectId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "C_ProjectLine_ID", "", "174", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcProjectlineId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process8C0C61BB43FE43D1B5D6B7710D38AD8D(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads8C0C61BB43FE43D1B5D6B7710D38AD8D';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_ORG_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process2F4E363962094B46B5F17569F82063B7(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads2F4E363962094B46B5F17569F82063B7';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_Org_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processCC0E4572F5334B2AB8AE9DB977B44860(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsCC0E4572F5334B2AB8AE9DB977B44860';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "AD_Org_ID", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processE041B544CC384252BDE836DB9B62D0E8(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsE041B544CC384252BDE836DB9B62D0E8';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "0D644423F84947E98CB502BE8F4B30D6", "E468F380BF13415687165A6403B79E1A", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "nivel", "CBEB2EA7397B461DB43333511804F1C8", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpnivel";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "19", "ad_org_id", "", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process598CD3CFC58549CB9267C4B37D50D4F6(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads598CD3CFC58549CB9267C4B37D50D4F6';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adClientId", "inp#adOrgId", "inp#adClientId", "inp#adOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "C_DocTypeTarget_ID", "170", "BE610A5797874F5CBF0667E8519695EB", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpcDoctypetargetId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process80EB3DB8BA62441CB2D5AA17B5331AA1(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads80EB3DB8BA62441CB2D5AA17B5331AA1';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_USER_ID", "8989E0B3E3674CE2ADD70FBF0107960F", "C407EB6DA1774487A8CCB456EC1C8E3D", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process45A5EE58A3834A38BC256A831DD632D8(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads45A5EE58A3834A38BC256A831DD632D8';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "ad_user", "110", "8A60F870D20949ADAEC8C1B3327C01D6", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUser";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "17", "outputType", "800104", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpoutputtype";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "m_product_id", "1F603F334B704F53928B8DB908611657", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpmProductId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "ad_org_id", "276", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadOrgId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
      if (CalloutHelper.commandInCommandList(command, "inpadOrgId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "m_prod_category", "163", "", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpmProdCategory";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void processECC738C8BD194D629534D94F616FBCA1(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloadsECC738C8BD194D629534D94F616FBCA1';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "AD_User_ID", "110", "A03D5A5CAC154AD39EB39FB9E2C6C56E", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUserId";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
    private void process5498B90303C245F0B9FEF1D5021BC059(HttpServletResponse response, VariablesSecureApp vars, String strTabId, String windowId) throws IOException, ServletException {
        String resultField;
        String command = vars.getStringParameter("Command", "DEFAULT");
        XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_callouts/CallOut").createXmlDocument();
        
        StringBuffer resultado = new StringBuffer();
        boolean isFirst=true;
        ComboTableData comboTableData = null;
        resultado.append("var calloutName='ComboReloads5498B90303C245F0B9FEF1D5021BC059';\n\n");
        resultado.append("var respuesta = new Array(\n");
    
        try {
          
      if (CalloutHelper.commandInCommandList(command, "inp#adUserId")) {
        if (!isFirst) resultado.append(", \n");
        comboTableData = new ComboTableData(vars, this, "18", "Ad_User", "110", "A03D5A5CAC154AD39EB39FB9E2C6C56E", Utility.getReferenceableOrg(vars, vars.getStringParameter("inpadOrgId")), Utility.getContext(this, vars, "#User_Client", windowId), 0);
        comboTableData.fillParameters(null, windowId, "");
        resultField = "inpadUser";

        resultado.append("new Array(\"" + resultField + "\", ");
        resultado.append(generateArray(comboTableData.select(false), vars.getStringParameter(resultField)));
        comboTableData = null;
        resultado.append(")");
        isFirst=false;
      }
    
        } catch (ServletException ex) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        } catch (Exception ex1) {
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), ex1.toString());
          bdErrorHidden(response, myError.getType(), myError.getTitle(), myError.getMessage());
          return;
        }
    
        resultado.append("\n);");
    
        xmlDocument.setParameter("array", resultado.toString());
        xmlDocument.setParameter("frameName", "mainframe");
        xmlDocument.setParameter("frameName1", "mainframe");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(xmlDocument.print());
        out.close();
 
       return;
     }
    
}
