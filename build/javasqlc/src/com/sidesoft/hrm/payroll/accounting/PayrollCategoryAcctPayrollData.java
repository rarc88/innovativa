//Sqlc generated V1.O00-1
package com.sidesoft.hrm.payroll.accounting;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class PayrollCategoryAcctPayrollData implements FieldProvider {
static Logger log4j = Logger.getLogger(PayrollCategoryAcctPayrollData.class);
  private String InitRecordNumber="0";
  public String adClientId;
  public String adOrgId;
  public String value;
  public String name;
  public String description;
  public String balanceacctId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("balanceacct_id") || fieldName.equals("balanceacctId"))
      return balanceacctId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static PayrollCategoryAcctPayrollData[] select(ConnectionProvider connectionProvider, String BusinessPartner)    throws ServletException {
    return select(connectionProvider, BusinessPartner, 0, 0);
  }

  public static PayrollCategoryAcctPayrollData[] select(ConnectionProvider connectionProvider, String BusinessPartner, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT CA.AD_CLIENT_ID, CA.AD_ORG_ID, CA.VALUE, CA.NAME, CA.DESCRIPTION, CA.BALANCEACCT_ID" +
      "        FROM SSPR_CATEGORY_ACCT CA" +
      "        JOIN C_BPARTNER BP ON BP.EM_SSPR_CATEGORY_ACCT_ID = CA.SSPR_CATEGORY_ACCT_ID" +
      "        WHERE BP.C_BPARTNER_ID = ?";

    ResultSet result;
    Vector<PayrollCategoryAcctPayrollData> vector = new Vector<PayrollCategoryAcctPayrollData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, BusinessPartner);

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
        PayrollCategoryAcctPayrollData objectPayrollCategoryAcctPayrollData = new PayrollCategoryAcctPayrollData();
        objectPayrollCategoryAcctPayrollData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectPayrollCategoryAcctPayrollData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectPayrollCategoryAcctPayrollData.value = UtilSql.getValue(result, "value");
        objectPayrollCategoryAcctPayrollData.name = UtilSql.getValue(result, "name");
        objectPayrollCategoryAcctPayrollData.description = UtilSql.getValue(result, "description");
        objectPayrollCategoryAcctPayrollData.balanceacctId = UtilSql.getValue(result, "balanceacct_id");
        objectPayrollCategoryAcctPayrollData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPayrollCategoryAcctPayrollData);
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
    PayrollCategoryAcctPayrollData objectPayrollCategoryAcctPayrollData[] = new PayrollCategoryAcctPayrollData[vector.size()];
    vector.copyInto(objectPayrollCategoryAcctPayrollData);
    return(objectPayrollCategoryAcctPayrollData);
  }
}
