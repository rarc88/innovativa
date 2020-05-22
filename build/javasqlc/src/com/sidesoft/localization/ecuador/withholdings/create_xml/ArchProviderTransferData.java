//Sqlc generated V1.O00-1
package com.sidesoft.localization.ecuador.withholdings.create_xml;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

public class ArchProviderTransferData implements FieldProvider {
static Logger log4j = Logger.getLogger(ArchProviderTransferData.class);
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
  public String fleetcode;
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
    else if (fieldName.equalsIgnoreCase("fleetcode"))
      return fleetcode;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("ci"))
      return ci;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ArchProviderTransferData[] select(ConnectionProvider connectionProvider, String datefrom, String dateto, String c_doctype_id, String fin_financial_account_id)    throws ServletException {
    return select(connectionProvider, datefrom, dateto, c_doctype_id, fin_financial_account_id, 0, 0);
  }

  public static ArchProviderTransferData[] select(ConnectionProvider connectionProvider, String datefrom, String dateto, String c_doctype_id, String fin_financial_account_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT NOW() AS DATEPROCESS," +
      "          (" +
      "            SELECT COUNT(FIN_PAYMENT.C_BPARTNER_ID)" +
      "            FROM FIN_PAYMENT" +
      "            LEFT JOIN C_BPARTNER ON C_BPARTNER.C_BPARTNER_ID = FIN_PAYMENT.C_BPARTNER_ID" +
      "            --LEFT JOIN SSPR_CATEGORY_ACCT ON SSPR_CATEGORY_ACCT.SSPR_CATEGORY_ACCT_ID = C_BPARTNER.EM_SSPR_CATEGORY_ACCT_ID" +
      "            WHERE (FIN_PAYMENT.PAYMENTDATE BETWEEN ? AND ?) " +
      "            AND FIN_PAYMENT.C_DOCTYPE_ID = ? AND FIN_PAYMENT.ISRECEIPT='N' AND FIN_PAYMENT.FIN_FINANCIAL_ACCOUNT_ID = ?" +
      "          ) AS NUMBEREMPLOYEE," +
      "          '1' AS CONSTANTE1," +
      "          (" +
      "            SELECT SUM(ROUND(FIN_PAYMENT.AMOUNT,2))" +
      "            FROM FIN_PAYMENT" +
      "            LEFT JOIN C_BPARTNER ON C_BPARTNER.C_BPARTNER_ID = FIN_PAYMENT.C_BPARTNER_ID" +
      "            --LEFT JOIN SSPR_CATEGORY_ACCT ON SSPR_CATEGORY_ACCT.SSPR_CATEGORY_ACCT_ID = C_BPARTNER.EM_SSPR_CATEGORY_ACCT_ID" +
      "            WHERE (FIN_PAYMENT.PAYMENTDATE BETWEEN ? AND ?) AND" +
      "            FIN_PAYMENT.C_DOCTYPE_ID = ? AND FIN_PAYMENT.ISRECEIPT='N' AND FIN_PAYMENT.FIN_FINANCIAL_ACCOUNT_ID = ?" +
      "          ) AS TOTALNETEMPLOYEE," +
      "          '0' AS CONSTANTE2," +
      "          '01310086' AS CONSTANTE3," +
      "          '01310086' AS CONSTANTE4," +
      "          AD_ORG.NAME AS RAZONSOCIAL, C_LOCATION.CITY  AS CITY," +
      "          (" +
      "            SELECT C_PERIOD.PERIODNO||'/'||C_YEAR.YEAR " +
      "            FROM C_PERIOD" +
      "            LEFT JOIN C_YEAR ON C_YEAR.C_YEAR_ID = C_PERIOD.C_YEAR_ID " +
      "            WHERE TO_DATE(?) BETWEEN C_PERIOD.STARTDATE AND C_PERIOD.ENDDATE " +
      "          ) AS PERIOD," +
      "          ROUND(FIN_PAYMENT.AMOUNT,2) AS TOTALNET," +
      "          '' AS CODCATEGORYACCT," +
      "          SSFI_BANKTRANSFER.CODE AS BANKCODE," +
      "          C_BP_BANKACCOUNT.ACCOUNTNO," +
      "          ( " +
      "            CASE WHEN C_BP_BANKACCOUNT.BANKACCOUNTTYPE = 'S' THEN '02'" +
      "            WHEN C_BP_BANKACCOUNT.BANKACCOUNTTYPE = 'C' THEN '01'" +
      "            END " +
      "          ) AS BANKACCOUNTTYPE," +
      "          C_BPARTNER.NAME AS EMPLOYEE," +
      "          C_BPARTNER.DESCRIPTION AS FLEETCODE," +
      "          C_DOCTYPE.NAME AS DESCRIPTION," +
      "          COALESCE(C_BP_BANKACCOUNT.EM_SSWH_TAXIDNO,  C_BPARTNER.TAXID) AS CI" +
      "        FROM FIN_PAYMENT" +
      "        LEFT JOIN C_BPARTNER ON C_BPARTNER.C_BPARTNER_ID = FIN_PAYMENT.C_BPARTNER_ID" +
      "        LEFT JOIN AD_ORG ON AD_ORG.AD_ORG_ID = FIN_PAYMENT.AD_ORG_ID" +
      "        LEFT JOIN AD_ORGINFO ON AD_ORGINFO.AD_ORG_ID = FIN_PAYMENT.AD_ORG_ID" +
      "        LEFT JOIN C_LOCATION ON C_LOCATION.C_LOCATION_ID = AD_ORGINFO.C_LOCATION_ID" +
      "        --LEFT JOIN SSPR_CATEGORY_ACCT ON SSPR_CATEGORY_ACCT.SSPR_CATEGORY_ACCT_ID = C_BPARTNER.EM_SSPR_CATEGORY_ACCT_ID" +
      "        LEFT JOIN C_DOCTYPE ON C_DOCTYPE.C_DOCTYPE_ID = FIN_PAYMENT.C_DOCTYPE_ID" +
      "        LEFT JOIN C_BP_BANKACCOUNT ON C_BP_BANKACCOUNT.C_BP_BANKACCOUNT_ID = FIN_PAYMENT.EM_SSWH_BP_BANKACCOUNT_ID" +
      "        LEFT JOIN SSFI_BANKTRANSFER ON SSFI_BANKTRANSFER.SSFI_BANKTRANSFER_ID = C_BP_BANKACCOUNT.EM_SSFI_BANKTRANSFER_ID" +
      "        WHERE (FIN_PAYMENT.PAYMENTDATE BETWEEN ? AND ?) " +
      "        AND FIN_PAYMENT.C_DOCTYPE_ID = ? AND FIN_PAYMENT.ISRECEIPT='N' AND FIN_PAYMENT.FIN_FINANCIAL_ACCOUNT_ID = ?" +
      "        ORDER BY C_BPARTNER.NAME";

    ResultSet result;
    Vector<ArchProviderTransferData> vector = new Vector<ArchProviderTransferData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_doctype_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fin_financial_account_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_doctype_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fin_financial_account_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, datefrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_doctype_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fin_financial_account_id);

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
        ArchProviderTransferData objectArchProviderTransferData = new ArchProviderTransferData();
        objectArchProviderTransferData.dateprocess = UtilSql.getDateValue(result, "dateprocess", "dd-MM-yyyy");
        objectArchProviderTransferData.numberemployee = UtilSql.getValue(result, "numberemployee");
        objectArchProviderTransferData.constante1 = UtilSql.getValue(result, "constante1");
        objectArchProviderTransferData.totalnetemployee = UtilSql.getValue(result, "totalnetemployee");
        objectArchProviderTransferData.constante2 = UtilSql.getValue(result, "constante2");
        objectArchProviderTransferData.constante3 = UtilSql.getValue(result, "constante3");
        objectArchProviderTransferData.constante4 = UtilSql.getValue(result, "constante4");
        objectArchProviderTransferData.razonsocial = UtilSql.getValue(result, "razonsocial");
        objectArchProviderTransferData.city = UtilSql.getValue(result, "city");
        objectArchProviderTransferData.period = UtilSql.getValue(result, "period");
        objectArchProviderTransferData.totalnet = UtilSql.getValue(result, "totalnet");
        objectArchProviderTransferData.codcategoryacct = UtilSql.getValue(result, "codcategoryacct");
        objectArchProviderTransferData.bankcode = UtilSql.getValue(result, "bankcode");
        objectArchProviderTransferData.accountno = UtilSql.getValue(result, "accountno");
        objectArchProviderTransferData.bankaccounttype = UtilSql.getValue(result, "bankaccounttype");
        objectArchProviderTransferData.employee = UtilSql.getValue(result, "employee");
        objectArchProviderTransferData.fleetcode = UtilSql.getValue(result, "fleetcode");
        objectArchProviderTransferData.description = UtilSql.getValue(result, "description");
        objectArchProviderTransferData.ci = UtilSql.getValue(result, "ci");
        objectArchProviderTransferData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectArchProviderTransferData);
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
    ArchProviderTransferData objectArchProviderTransferData[] = new ArchProviderTransferData[vector.size()];
    vector.copyInto(objectArchProviderTransferData);
    return(objectArchProviderTransferData);
  }
}
