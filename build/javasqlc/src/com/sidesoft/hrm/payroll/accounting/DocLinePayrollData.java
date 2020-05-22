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

class DocLinePayrollData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocLinePayrollData.class);
  private String InitRecordNumber="0";
  public String ssprPayrollTicketConceptId;
  public String adOrgId;
  public String line;
  public String description;
  public String amount;
  public String cCurrencyId;
  public String cCostcenterId;
  public String user1Id;
  public String user2Id;
  public String ssprConceptId;
  public String ssprCategoryAcctId;
  public String cBpartnerId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("sspr_payroll_ticket_concept_id") || fieldName.equals("ssprPayrollTicketConceptId"))
      return ssprPayrollTicketConceptId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("amount"))
      return amount;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_costcenter_id") || fieldName.equals("cCostcenterId"))
      return cCostcenterId;
    else if (fieldName.equalsIgnoreCase("user1_id") || fieldName.equals("user1Id"))
      return user1Id;
    else if (fieldName.equalsIgnoreCase("user2_id") || fieldName.equals("user2Id"))
      return user2Id;
    else if (fieldName.equalsIgnoreCase("sspr_concept_id") || fieldName.equals("ssprConceptId"))
      return ssprConceptId;
    else if (fieldName.equalsIgnoreCase("sspr_category_acct_id") || fieldName.equals("ssprCategoryAcctId"))
      return ssprCategoryAcctId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocLinePayrollData[] select(ConnectionProvider connectionProvider, String certificate)    throws ServletException {
    return select(connectionProvider, certificate, 0, 0);
  }

  public static DocLinePayrollData[] select(ConnectionProvider connectionProvider, String certificate, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT PRTC.SSPR_PAYROLL_TICKET_CONCEPT_ID, PRT.AD_ORG_ID, 10 AS LINE, PR.DESCRIPTION, " +
      "        PRTC.AMOUNT, '100' AS C_CURRENCY_ID, BP.EM_SSPR_COSTCENTER_ID AS C_COSTCENTER_ID, BP.EM_SSPR_USER1_ID AS USER1_ID, BP.EM_SSPR_USER2_ID AS USER2_ID, " +
      "        PRTC.SSPR_CONCEPT_ID, BP.EM_SSPR_CATEGORY_ACCT_ID AS SSPR_CATEGORY_ACCT_ID, BP.C_BPARTNER_ID" +
      "        FROM SSPR_PAYROLL PR " +
      "        LEFT JOIN SSPR_PAYROLL_TICKET PRT ON PR.SSPR_PAYROLL_ID = PRT.SSPR_PAYROLL_ID" +
      "        LEFT JOIN SSPR_PAYROLL_TICKET_CONCEPT PRTC ON PRTC.SSPR_PAYROLL_TICKET_ID = PRT.SSPR_PAYROLL_TICKET_ID" +
      "        LEFT JOIN C_BPARTNER BP ON PRT.C_BPARTNER_ID = BP.C_BPARTNER_ID" +
      "        WHERE PR.SSPR_PAYROLL_ID=? AND PRTC.AMOUNT <> 0          " +
      "        ORDER BY BP.C_BPARTNER_ID";

    ResultSet result;
    Vector<DocLinePayrollData> vector = new Vector<DocLinePayrollData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, certificate);

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
        DocLinePayrollData objectDocLinePayrollData = new DocLinePayrollData();
        objectDocLinePayrollData.ssprPayrollTicketConceptId = UtilSql.getValue(result, "sspr_payroll_ticket_concept_id");
        objectDocLinePayrollData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocLinePayrollData.line = UtilSql.getValue(result, "line");
        objectDocLinePayrollData.description = UtilSql.getValue(result, "description");
        objectDocLinePayrollData.amount = UtilSql.getValue(result, "amount");
        objectDocLinePayrollData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectDocLinePayrollData.cCostcenterId = UtilSql.getValue(result, "c_costcenter_id");
        objectDocLinePayrollData.user1Id = UtilSql.getValue(result, "user1_id");
        objectDocLinePayrollData.user2Id = UtilSql.getValue(result, "user2_id");
        objectDocLinePayrollData.ssprConceptId = UtilSql.getValue(result, "sspr_concept_id");
        objectDocLinePayrollData.ssprCategoryAcctId = UtilSql.getValue(result, "sspr_category_acct_id");
        objectDocLinePayrollData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectDocLinePayrollData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocLinePayrollData);
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
    DocLinePayrollData objectDocLinePayrollData[] = new DocLinePayrollData[vector.size()];
    vector.copyInto(objectDocLinePayrollData);
    return(objectDocLinePayrollData);
  }
}
