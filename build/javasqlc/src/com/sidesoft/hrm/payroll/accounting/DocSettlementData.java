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

class DocSettlementData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocSettlementData.class);
  private String InitRecordNumber="0";
  public String adClientId;
  public String adOrgId;
  public String documentno;
  public String datedoc;
  public String cCurrencyId;
  public String cDoctypeId;
  public String posted;
  public String value;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("datedoc"))
      return datedoc;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_doctype_id") || fieldName.equals("cDoctypeId"))
      return cDoctypeId;
    else if (fieldName.equalsIgnoreCase("posted"))
      return posted;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocSettlementData[] selectRecord(ConnectionProvider connectionProvider, String ad_client_id, String sspr_settlement_id)    throws ServletException {
    return selectRecord(connectionProvider, ad_client_id, sspr_settlement_id, 0, 0);
  }

  public static DocSettlementData[] selectRecord(ConnectionProvider connectionProvider, String ad_client_id, String sspr_settlement_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		SELECT AD_CLIENT_ID, AD_ORG_ID, DOCUMENTNONEW AS DOCUMENTNO, MOVEMENTDATE AS DATEDOC, '100' AS C_CURRENCY_ID, C_DOCTYPE_ID, POSTED, 0 AS VALUE" +
      "		FROM SSPR_SETTLEMENT" +
      "		WHERE AD_CLIENT_ID = ?" +
      "		AND SSPR_SETTLEMENT_ID = ?";

    ResultSet result;
    Vector<DocSettlementData> vector = new Vector<DocSettlementData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_client_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sspr_settlement_id);

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
        DocSettlementData objectDocSettlementData = new DocSettlementData();
        objectDocSettlementData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDocSettlementData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocSettlementData.documentno = UtilSql.getValue(result, "documentno");
        objectDocSettlementData.datedoc = UtilSql.getDateValue(result, "datedoc", "dd-MM-yyyy");
        objectDocSettlementData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectDocSettlementData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectDocSettlementData.posted = UtilSql.getValue(result, "posted");
        objectDocSettlementData.value = UtilSql.getValue(result, "value");
        objectDocSettlementData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocSettlementData);
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
    DocSettlementData objectDocSettlementData[] = new DocSettlementData[vector.size()];
    vector.copyInto(objectDocSettlementData);
    return(objectDocSettlementData);
  }
}
