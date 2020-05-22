//Sqlc generated V1.O00-1
package com.sidesoft.hrm.payroll.tenth.create_txt;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

public class ArchTenthCtralBankData implements FieldProvider {
static Logger log4j = Logger.getLogger(ArchTenthCtralBankData.class);
  private String InitRecordNumber="0";
  public String dateprocess;
  public String numberemployee;
  public String constante1;
  public String totalnetemployee;
  public String constante2;
  public String constante3;
  public String constante4;
  public String razonsocial;
  public String city;
  public String period;
  public String totalnet;
  public String codcategoryacct;
  public String bankcode;
  public String accountno;
  public String bankaccounttype;
  public String employee;
  public String description;
  public String ci;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("dateprocess"))
      return dateprocess;
    else if (fieldName.equalsIgnoreCase("numberemployee"))
      return numberemployee;
    else if (fieldName.equalsIgnoreCase("constante1"))
      return constante1;
    else if (fieldName.equalsIgnoreCase("totalnetemployee"))
      return totalnetemployee;
    else if (fieldName.equalsIgnoreCase("constante2"))
      return constante2;
    else if (fieldName.equalsIgnoreCase("constante3"))
      return constante3;
    else if (fieldName.equalsIgnoreCase("constante4"))
      return constante4;
    else if (fieldName.equalsIgnoreCase("razonsocial"))
      return razonsocial;
    else if (fieldName.equalsIgnoreCase("city"))
      return city;
    else if (fieldName.equalsIgnoreCase("period"))
      return period;
    else if (fieldName.equalsIgnoreCase("totalnet"))
      return totalnet;
    else if (fieldName.equalsIgnoreCase("codcategoryacct"))
      return codcategoryacct;
    else if (fieldName.equalsIgnoreCase("bankcode"))
      return bankcode;
    else if (fieldName.equalsIgnoreCase("accountno"))
      return accountno;
    else if (fieldName.equalsIgnoreCase("bankaccounttype"))
      return bankaccounttype;
    else if (fieldName.equalsIgnoreCase("employee"))
      return employee;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("ci"))
      return ci;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ArchTenthCtralBankData[] select(ConnectionProvider connectionProvider, String documentno, String sspr_category_acct_id)    throws ServletException {
    return select(connectionProvider, documentno, sspr_category_acct_id, 0, 0);
  }

  public static ArchTenthCtralBankData[] select(ConnectionProvider connectionProvider, String documentno, String sspr_category_acct_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    select  now() as dateprocess," +
      "            (select count(ssph_tenth_settlement_line.c_bpartner_id)" +
      "            from ssph_tenth_settlement" +
      "            join ssph_tenth_settlement_line on ssph_tenth_settlement.ssph_tenth_settlement_id  = ssph_tenth_settlement_line.ssph_tenth_settlement_id" +
      "            join c_bpartner on c_bpartner.c_bpartner_id = ssph_tenth_settlement_line.c_bpartner_id" +
      "            left join sspr_category_acct on sspr_category_acct.sspr_category_acct_id = c_bpartner.em_sspr_category_acct_id" +
      "            where ssph_tenth_settlement.documentno = ?" +
      "            and sspr_category_acct.sspr_category_acct_id = ? " +
      "            ) as numberemployee," +
      "            '1' as constante1," +
      "            (select sum(round(coalesce(ssph_tenth_settlement_line.adjustedamt,ssph_tenth_settlement_line.linenetamt,0),2))" +
      "            from ssph_tenth_settlement" +
      "            join ssph_tenth_settlement_line on ssph_tenth_settlement.ssph_tenth_settlement_id  = ssph_tenth_settlement_line.ssph_tenth_settlement_id" +
      "            join c_bpartner on c_bpartner.c_bpartner_id = ssph_tenth_settlement_line.c_bpartner_id" +
      "            left join sspr_category_acct on sspr_category_acct.sspr_category_acct_id = c_bpartner.em_sspr_category_acct_id" +
      "            where ssph_tenth_settlement.documentno = ?" +
      "            and sspr_category_acct.sspr_category_acct_id = ?" +
      "            ) as totalnetemployee," +
      "            '0' as constante2," +
      "            '01310086' as constante3," +
      "            '01310086' as constante4," +
      "            ad_org.name as razonsocial, c_location.city  as city," +
      "            (extract(month from ssph_tenth_settlement.settlementdate))||'/'||c_year.year as period," +
      "            round(coalesce(ssph_tenth_settlement_line.adjustedamt,ssph_tenth_settlement_line.linenetamt,0),2) as totalnet," +
      "            sspr_category_acct.value as codcategoryacct," +
      "            ssfi_banktransfer.code as bankcode," +
      "            C_BP_BankAccount.accountno," +
      "            case when C_BP_BankAccount.bankaccounttype = 'S' then '02'" +
      "                 when C_BP_BankAccount.bankaccounttype = 'C' then '01'" +
      "            end as bankaccounttype," +
      "            c_bpartner.name as employee," +
      "            'REMUNERACI��N MENSUAL' as description," +
      "            c_bpartner.taxid as ci" +
      "        from ssph_tenth_settlement" +
      "        join ssph_tenth_settlement_line on ssph_tenth_settlement.ssph_tenth_settlement_id = ssph_tenth_settlement_line.ssph_tenth_settlement_id" +
      "        left join c_bpartner on c_bpartner.c_bpartner_id = ssph_tenth_settlement_line.c_bpartner_id" +
      "        left join ad_org on ad_org.ad_org_id = ssph_tenth_settlement.ad_org_id" +
      "        left join ad_orginfo on ad_orginfo.ad_org_id = ssph_tenth_settlement.ad_org_id" +
      "        left join c_location on c_location.c_location_id = ad_orginfo.c_location_id" +
      "        left join c_year on c_year.c_year_id = ssph_tenth_settlement.c_year_id" +
      "        left join sspr_category_acct on sspr_category_acct.sspr_category_acct_id = c_bpartner.em_sspr_category_acct_id" +
      "        left join C_BP_BankAccount on C_BP_BankAccount.c_bpartner_id = c_bpartner.c_bpartner_id and C_BP_BankAccount.em_sspr_ispayroll = 'Y' " +
      "        left join ssfi_banktransfer on ssfi_banktransfer.ssfi_banktransfer_id = C_BP_BankAccount.em_ssfi_banktransfer_id" +
      "        where ssph_tenth_settlement.documentno = ?" +
      "        and sspr_category_acct.sspr_category_acct_id = ?" +
      "        order by c_bpartner.name";

    ResultSet result;
    Vector<ArchTenthCtralBankData> vector = new Vector<ArchTenthCtralBankData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sspr_category_acct_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sspr_category_acct_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sspr_category_acct_id);

      result = st.executeQuery();
      long countRecord = 0;
      long countRecordSkip = 1;
      boolean continueResult = true;
      while(countRecordSkip < firstRegister && continueResult) {
        continueResult = result.next();
        countRecordSkip++;
      }
      while(continueResult && result.next()) {
        countRecord++;
        ArchTenthCtralBankData objectArchTenthCtralBankData = new ArchTenthCtralBankData();
        objectArchTenthCtralBankData.dateprocess = UtilSql.getDateValue(result, "dateprocess", "dd-MM-yyyy");
        objectArchTenthCtralBankData.numberemployee = UtilSql.getValue(result, "numberemployee");
        objectArchTenthCtralBankData.constante1 = UtilSql.getValue(result, "constante1");
        objectArchTenthCtralBankData.totalnetemployee = UtilSql.getValue(result, "totalnetemployee");
        objectArchTenthCtralBankData.constante2 = UtilSql.getValue(result, "constante2");
        objectArchTenthCtralBankData.constante3 = UtilSql.getValue(result, "constante3");
        objectArchTenthCtralBankData.constante4 = UtilSql.getValue(result, "constante4");
        objectArchTenthCtralBankData.razonsocial = UtilSql.getValue(result, "razonsocial");
        objectArchTenthCtralBankData.city = UtilSql.getValue(result, "city");
        objectArchTenthCtralBankData.period = UtilSql.getValue(result, "period");
        objectArchTenthCtralBankData.totalnet = UtilSql.getValue(result, "totalnet");
        objectArchTenthCtralBankData.codcategoryacct = UtilSql.getValue(result, "codcategoryacct");
        objectArchTenthCtralBankData.bankcode = UtilSql.getValue(result, "bankcode");
        objectArchTenthCtralBankData.accountno = UtilSql.getValue(result, "accountno");
        objectArchTenthCtralBankData.bankaccounttype = UtilSql.getValue(result, "bankaccounttype");
        objectArchTenthCtralBankData.employee = UtilSql.getValue(result, "employee");
        objectArchTenthCtralBankData.description = UtilSql.getValue(result, "description");
        objectArchTenthCtralBankData.ci = UtilSql.getValue(result, "ci");
        objectArchTenthCtralBankData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectArchTenthCtralBankData);
        if (countRecord >= numberRegisters && numberRegisters != 0) {
          continueResult = false;
        }
      }
      result.close();
    } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    ArchTenthCtralBankData objectArchTenthCtralBankData[] = new ArchTenthCtralBankData[vector.size()];
    vector.copyInto(objectArchTenthCtralBankData);
    return(objectArchTenthCtralBankData);
  }
}
