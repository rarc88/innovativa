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

class DocWithholdingSaleData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocWithholdingSaleData.class);
  private String InitRecordNumber="0";
  public String adClientId;
  public String adOrgId;
  public String documentno;
  public String dateacct;
  public String cCurrencyId;
  public String cDoctypeId;
  public String posted;
  public String totalAmt;
  public String customerAcctId;
  public String vendorAcctId;
  public String withholdingtype;

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
    else if (fieldName.equalsIgnoreCase("dateacct"))
      return dateacct;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_doctype_id") || fieldName.equals("cDoctypeId"))
      return cDoctypeId;
    else if (fieldName.equalsIgnoreCase("posted"))
      return posted;
    else if (fieldName.equalsIgnoreCase("total_amt") || fieldName.equals("totalAmt"))
      return totalAmt;
    else if (fieldName.equalsIgnoreCase("customer_acct_id") || fieldName.equals("customerAcctId"))
      return customerAcctId;
    else if (fieldName.equalsIgnoreCase("vendor_acct_id") || fieldName.equals("vendorAcctId"))
      return vendorAcctId;
    else if (fieldName.equalsIgnoreCase("withholdingtype"))
      return withholdingtype;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocWithholdingSaleData[] selectRecord(ConnectionProvider connectionProvider, String client, String id)    throws ServletException {
    return selectRecord(connectionProvider, client, id, 0, 0);
  }

  public static DocWithholdingSaleData[] selectRecord(ConnectionProvider connectionProvider, String client, String id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT WS.AD_CLIENT_ID, WS.AD_ORG_ID, WS.DOCUMENTNO, WS.DATEACCT, WS.C_CURRENCY_ID, WS.C_DOCTYPE_ID, WS.POSTED," +
      "        WS.TOTALWHRENTALAMT + WS.TOTALWHIVAAMT AS TOTAL_AMT, BPCAC.C_RECEIVABLE_ACCT AS CUSTOMER_ACCT_ID, BPVAC.V_LIABILITY_ACCT AS VENDOR_ACCT_ID," +
      "        WS.WITHHOLDINGTYPE" +
      "        FROM SSWS_WITHHOLDINGSALE WS" +
      "        JOIN C_BPARTNER BP ON BP.C_BPARTNER_ID = WS.C_BPARTNER_ID" +
      "        LEFT JOIN C_BP_CUSTOMER_ACCT BPCAC ON BPCAC.C_BPARTNER_ID = BP.C_BPARTNER_ID" +
      "        LEFT JOIN C_BP_VENDOR_ACCT BPVAC ON BPVAC.C_BPARTNER_ID = BP.C_BPARTNER_ID" +
      "        WHERE WS.AD_Client_ID=?" +
      "        AND WS.SSWS_WITHHOLDINGSALE_ID=?";

    ResultSet result;
    Vector<DocWithholdingSaleData> vector = new Vector<DocWithholdingSaleData>(0);
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
        DocWithholdingSaleData objectDocWithholdingSaleData = new DocWithholdingSaleData();
        objectDocWithholdingSaleData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDocWithholdingSaleData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocWithholdingSaleData.documentno = UtilSql.getValue(result, "documentno");
        objectDocWithholdingSaleData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectDocWithholdingSaleData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectDocWithholdingSaleData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectDocWithholdingSaleData.posted = UtilSql.getValue(result, "posted");
        objectDocWithholdingSaleData.totalAmt = UtilSql.getValue(result, "total_amt");
        objectDocWithholdingSaleData.customerAcctId = UtilSql.getValue(result, "customer_acct_id");
        objectDocWithholdingSaleData.vendorAcctId = UtilSql.getValue(result, "vendor_acct_id");
        objectDocWithholdingSaleData.withholdingtype = UtilSql.getValue(result, "withholdingtype");
        objectDocWithholdingSaleData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocWithholdingSaleData);
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
    DocWithholdingSaleData objectDocWithholdingSaleData[] = new DocWithholdingSaleData[vector.size()];
    vector.copyInto(objectDocWithholdingSaleData);
    return(objectDocWithholdingSaleData);
  }
}
