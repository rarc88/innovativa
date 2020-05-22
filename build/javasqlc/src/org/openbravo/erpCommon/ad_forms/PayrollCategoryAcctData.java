//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_forms;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class PayrollCategoryAcctData implements FieldProvider {
static Logger log4j = Logger.getLogger(PayrollCategoryAcctData.class);
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

  public static PayrollCategoryAcctData[] select(ConnectionProvider connectionProvider, String BusinessPartner)    throws ServletException {
    return select(connectionProvider, BusinessPartner, 0, 0);
  }

  public static PayrollCategoryAcctData[] select(ConnectionProvider connectionProvider, String BusinessPartner, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT CA.AD_CLIENT_ID, CA.AD_ORG_ID, CA.VALUE, CA.NAME, CA.DESCRIPTION, CA.BALANCEACCT_ID" +
      "        FROM SSPR_CATEGORY_ACCT CA" +
      "        JOIN C_BPARTNER BP ON BP.EM_SSPR_CATEGORY_ACCT_ID = CA.SSPR_CATEGORY_ACCT_ID" +
      "        WHERE BP.C_BPARTNER_ID = ?";

    ResultSet result;
    Vector<PayrollCategoryAcctData> vector = new Vector<PayrollCategoryAcctData>(0);
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
        PayrollCategoryAcctData objectPayrollCategoryAcctData = new PayrollCategoryAcctData();
        objectPayrollCategoryAcctData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectPayrollCategoryAcctData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectPayrollCategoryAcctData.value = UtilSql.getValue(result, "value");
        objectPayrollCategoryAcctData.name = UtilSql.getValue(result, "name");
        objectPayrollCategoryAcctData.description = UtilSql.getValue(result, "description");
        objectPayrollCategoryAcctData.balanceacctId = UtilSql.getValue(result, "balanceacct_id");
        objectPayrollCategoryAcctData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPayrollCategoryAcctData);
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
    PayrollCategoryAcctData objectPayrollCategoryAcctData[] = new PayrollCategoryAcctData[vector.size()];
    vector.copyInto(objectPayrollCategoryAcctData);
    return(objectPayrollCategoryAcctData);
  }
}
