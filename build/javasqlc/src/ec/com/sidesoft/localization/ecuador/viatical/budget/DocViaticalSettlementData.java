//Sqlc generated V1.O00-1
package ec.com.sidesoft.localization.ecuador.viatical.budget;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class DocViaticalSettlementData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocViaticalSettlementData.class);
  private String InitRecordNumber="0";
  public String adClientId;
  public String adOrgId;
  public String documentno;
  public String dateacct;
  public String cCurrencyId;
  public String cDoctypeId;
  public String posted;
  public String totalAmt;
  public String cCostcenterId;
  public String user1Id;
  public String cExpenseaccountId;
  public String cPayableaccountId;

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
    else if (fieldName.equalsIgnoreCase("c_costcenter_id") || fieldName.equals("cCostcenterId"))
      return cCostcenterId;
    else if (fieldName.equalsIgnoreCase("user1_id") || fieldName.equals("user1Id"))
      return user1Id;
    else if (fieldName.equalsIgnoreCase("c_expenseaccount_id") || fieldName.equals("cExpenseaccountId"))
      return cExpenseaccountId;
    else if (fieldName.equalsIgnoreCase("c_payableaccount_id") || fieldName.equals("cPayableaccountId"))
      return cPayableaccountId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocViaticalSettlementData[] selectRecord(ConnectionProvider connectionProvider, String id, String client)    throws ServletException {
    return selectRecord(connectionProvider, id, client, 0, 0);
  }

  public static DocViaticalSettlementData[] selectRecord(ConnectionProvider connectionProvider, String id, String client, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT VS.AD_CLIENT_ID, VS.AD_ORG_ID, VS.DOCUMENTNO, VS.VIATICALDATE AS DATEACCT, VS.C_CURRENCY_ID, VS.C_DOCTYPE_ID, VS.POSTED," +
      "        VS.TOTALAMT AS TOTAL_AMT, VS.C_COSTCENTER_ID, VS.USER1_ID, " +
      "		COALESCE((SELECT MAX(VCA01.C_EXPENSEACCOUNT_ID) " +
      "		          FROM SSVE_VIATICAL_CONFIG_ACCT VCA01 " +
      "		          WHERE VCA01.EM_SVTB_ACCOUNTINGBUDGET = 'Y' " +
      "				  AND VCA01.VIATICALACCTTYPE = (SELECT CASE WHEN L.C_COUNTRY_ID = VS.C_COUNTRY_ID THEN 'NAT' ELSE 'INT' END " +
      "				                                FROM  AD_ORG ORG01 INNER JOIN AD_ORGINFO ORGI ON ORG01.AD_ORG_ID = ORGI.AD_ORG_ID" +
      "                                                INNER JOIN C_LOCATION L ON L.C_LOCATION_ID = ORGI.C_LOCATION_ID" +
      "                                                WHERE VS.AD_ORG_ID = ORG01.AD_ORG_ID)" +
      "				  AND EXISTS (SELECT 1 FROM SSVE_VIATSETTLEMENTLINE SSVL INNER JOIN SFB_BUDGET_CERT_LINE BCL ON  BCL.SFB_BUDGET_CERT_LINE_ID = SSVL.SFB_BUDGET_CERT_LINE_ID" +
      "				              WHERE BCL.SFB_BUDGET_ITEM_ID = VCA01.EM_SVTB_BUDGET_ITEM " +
      "					          AND SSVL.SSVE_VIATICAL_SETTLEMENT_ID = ?)), VCA.C_EXPENSEACCOUNT_ID) AS C_EXPENSEACCOUNT_ID, " +
      "		COALESCE((SELECT MAX(VCA02.C_PAYABLEACCOUNT_ID)" +
      "		          FROM SSVE_VIATICAL_CONFIG_ACCT VCA02 " +
      "		          WHERE VCA02.EM_SVTB_ACCOUNTINGBUDGET = 'Y' " +
      "				  AND VCA02.VIATICALACCTTYPE = (SELECT CASE WHEN L.C_COUNTRY_ID = VS.C_COUNTRY_ID THEN 'NAT' ELSE 'INT' END " +
      "				                                FROM  AD_ORG ORG01 INNER JOIN AD_ORGINFO ORGI ON ORG01.AD_ORG_ID = ORGI.AD_ORG_ID" +
      "                                                INNER JOIN C_LOCATION L ON L.C_LOCATION_ID = ORGI.C_LOCATION_ID" +
      "                                                WHERE VS.AD_ORG_ID = ORG01.AD_ORG_ID)" +
      "				  AND EXISTS (SELECT 1 FROM SSVE_VIATSETTLEMENTLINE SSVL INNER JOIN SFB_BUDGET_CERT_LINE BCL ON  BCL.SFB_BUDGET_CERT_LINE_ID = SSVL.SFB_BUDGET_CERT_LINE_ID" +
      "				              WHERE BCL.SFB_BUDGET_ITEM_ID = VCA02.EM_SVTB_BUDGET_ITEM " +
      "							  AND SSVL.SSVE_VIATICAL_SETTLEMENT_ID = ? )), VCA.C_PAYABLEACCOUNT_ID) AS C_PAYABLEACCOUNT_ID" +
      "        FROM SSVE_VIATICAL_SETTLEMENT VS" +
      "        JOIN C_BPARTNER BP ON BP.C_BPARTNER_ID = VS.C_BPARTNER_ID" +
      "        LEFT JOIN SSVE_VIATICAL_CONFIG_ACCT VCA ON BP.EM_SSPR_CATEGORY_ACCT_ID = VCA.SSPR_CATEGORY_ACCT_ID" +
      "        WHERE VS.AD_CLIENT_ID=?" +
      "        AND VS.SSVE_VIATICAL_SETTLEMENT_ID=?";

    ResultSet result;
    Vector<DocViaticalSettlementData> vector = new Vector<DocViaticalSettlementData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);
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
        DocViaticalSettlementData objectDocViaticalSettlementData = new DocViaticalSettlementData();
        objectDocViaticalSettlementData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDocViaticalSettlementData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocViaticalSettlementData.documentno = UtilSql.getValue(result, "documentno");
        objectDocViaticalSettlementData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectDocViaticalSettlementData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectDocViaticalSettlementData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectDocViaticalSettlementData.posted = UtilSql.getValue(result, "posted");
        objectDocViaticalSettlementData.totalAmt = UtilSql.getValue(result, "total_amt");
        objectDocViaticalSettlementData.cCostcenterId = UtilSql.getValue(result, "c_costcenter_id");
        objectDocViaticalSettlementData.user1Id = UtilSql.getValue(result, "user1_id");
        objectDocViaticalSettlementData.cExpenseaccountId = UtilSql.getValue(result, "c_expenseaccount_id");
        objectDocViaticalSettlementData.cPayableaccountId = UtilSql.getValue(result, "c_payableaccount_id");
        objectDocViaticalSettlementData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocViaticalSettlementData);
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
    DocViaticalSettlementData objectDocViaticalSettlementData[] = new DocViaticalSettlementData[vector.size()];
    vector.copyInto(objectDocViaticalSettlementData);
    return(objectDocViaticalSettlementData);
  }
}
