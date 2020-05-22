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

class DocBudgetCertificateData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocBudgetCertificateData.class);
  private String InitRecordNumber="0";
  public String adClientId;
  public String adOrgId;
  public String documentno;
  public String datedoc;
  public String cCurrencyId;
  public String cDoctypeId;
  public String posted;
  public String certifiedValue;

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
    else if (fieldName.equalsIgnoreCase("certified_value") || fieldName.equals("certifiedValue"))
      return certifiedValue;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocBudgetCertificateData[] selectRecord(ConnectionProvider connectionProvider, String client, String id)    throws ServletException {
    return selectRecord(connectionProvider, client, id, 0, 0);
  }

  public static DocBudgetCertificateData[] selectRecord(ConnectionProvider connectionProvider, String client, String id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_CLIENT_ID, AD_ORG_ID, DOCUMENTNO, DATE_ISSUE AS DATEDOC, C_CURRENCY_ID, C_DOCTYPE_ID, POSTED," +
      "        CERTIFIED_VALUE" +
      "        FROM SFB_BUDGET_CERTIFICATE" +
      "        WHERE AD_Client_ID=?" +
      "        AND SFB_BUDGET_CERTIFICATE_ID=?";

    ResultSet result;
    Vector<DocBudgetCertificateData> vector = new Vector<DocBudgetCertificateData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

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
        DocBudgetCertificateData objectDocBudgetCertificateData = new DocBudgetCertificateData();
        objectDocBudgetCertificateData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDocBudgetCertificateData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocBudgetCertificateData.documentno = UtilSql.getValue(result, "documentno");
        objectDocBudgetCertificateData.datedoc = UtilSql.getDateValue(result, "datedoc", "dd-MM-yyyy");
        objectDocBudgetCertificateData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectDocBudgetCertificateData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectDocBudgetCertificateData.posted = UtilSql.getValue(result, "posted");
        objectDocBudgetCertificateData.certifiedValue = UtilSql.getValue(result, "certified_value");
        objectDocBudgetCertificateData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocBudgetCertificateData);
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
    DocBudgetCertificateData objectDocBudgetCertificateData[] = new DocBudgetCertificateData[vector.size()];
    vector.copyInto(objectDocBudgetCertificateData);
    return(objectDocBudgetCertificateData);
  }
}
