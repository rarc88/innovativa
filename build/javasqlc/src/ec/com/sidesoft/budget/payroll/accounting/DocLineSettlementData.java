//Sqlc generated V1.O00-1
package ec.com.sidesoft.budget.payroll.accounting;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class DocLineSettlementData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocLineSettlementData.class);
  private String InitRecordNumber="0";
  public String ssprSettlementlineId;
  public String adOrgId;
  public String line;
  public String description;
  public String totalnet;
  public String cCurrencyId;
  public String cCostcenterId;
  public String user1Id;
  public String user2Id;
  public String ssprConceptId;
  public String ssprCategoryAcctId;
  public String cBpartnerId;
  public String iscomplete;
  public String balanceacctId;
  public String nameconcept;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("sspr_settlementline_id") || fieldName.equals("ssprSettlementlineId"))
      return ssprSettlementlineId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("totalnet"))
      return totalnet;
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
    else if (fieldName.equalsIgnoreCase("iscomplete"))
      return iscomplete;
    else if (fieldName.equalsIgnoreCase("balanceacct_id") || fieldName.equals("balanceacctId"))
      return balanceacctId;
    else if (fieldName.equalsIgnoreCase("nameconcept"))
      return nameconcept;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocLineSettlementData[] selectline(ConnectionProvider connectionProvider, String sspr_settlement_id, String sspr_settlement_id1)    throws ServletException {
    return selectline(connectionProvider, sspr_settlement_id, sspr_settlement_id1, 0, 0);
  }

  public static DocLineSettlementData[] selectline(ConnectionProvider connectionProvider, String sspr_settlement_id, String sspr_settlement_id1, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		SELECT B.SSPR_SETTLEMENTLINE_ID, A.AD_ORG_ID, B.LINE, A.DESCRIPTION, CASE WHEN B.TOTALNET < 0 THEN B.TOTALNET * -1 ELSE B.TOTALNET END AS TOTALNET," +
      "	  '100' AS C_CURRENCY_ID, C.EM_SSPR_COSTCENTER_ID AS C_COSTCENTER_ID, C.EM_SSPR_USER1_ID AS USER1_ID, C.EM_SSPR_USER2_ID AS USER2_ID," +
      "		      B.SSPR_CONCEPT_ID, C.EM_SSPR_CATEGORY_ACCT_ID AS SSPR_CATEGORY_ACCT_ID, C.C_BPARTNER_ID, 'N' AS ISCOMPLETE, NULL AS BALANCEACCT_ID,SC.NAME AS NAMECONCEPT" +
      "		FROM SSPR_SETTLEMENT A" +
      "		LEFT JOIN SSPR_SETTLEMENTLINE B ON B.SSPR_SETTLEMENT_ID = A.SSPR_SETTLEMENT_ID" +
      "		LEFT JOIN C_BPARTNER C ON C.C_BPARTNER_ID = A.C_BPARTNER_ID" +
      "		LEFT JOIN SSPR_CONCEPT SC ON SC.SSPR_CONCEPT_ID = B.SSPR_CONCEPT_ID" +
      "		WHERE A.SSPR_SETTLEMENT_ID = ?" +
      "		AND B.SSPR_PAYROLL_ID IS NULL" +
      "		UNION ALL" +
      "		SELECT D.SSPR_SETTLEMENT_ID, D.AD_ORG_ID, 1000 AS LINE, D.DESCRIPTION, 0 AS TOTALNET, '100' AS C_CURRENCY_ID," +
      "			CB.EM_SSPR_COSTCENTER_ID AS C_COSTCENTER_ID, CB.EM_SSPR_USER1_ID AS USER1_ID, CB.EM_SSPR_USER2_ID AS USER2_ID," +
      "		 NULL AS SSPR_CONCEPT_ID , CB.EM_SSPR_CATEGORY_ACCT_ID AS SSPR_CATEGORY_ACCT_ID, CB.C_BPARTNER_ID,'Y' AS ISCOMPLETE, ACC.BALANCEACCT_ID, NULL AS NAMECONCEPT" +
      "		FROM SSPR_SETTLEMENT D" +
      "		LEFT JOIN C_BPARTNER CB ON CB.C_BPARTNER_ID = D.C_BPARTNER_ID " +
      "		LEFT JOIN SSPR_CATEGORY_ACCT ACC ON ACC.SSPR_CATEGORY_ACCT_ID = CB.EM_SSPR_CATEGORY_ACCT_ID" +
      "		WHERE SSPR_SETTLEMENT_ID = ? " +
      "		ORDER BY LINE      ";

    ResultSet result;
    Vector<DocLineSettlementData> vector = new Vector<DocLineSettlementData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sspr_settlement_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sspr_settlement_id1);

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
        DocLineSettlementData objectDocLineSettlementData = new DocLineSettlementData();
        objectDocLineSettlementData.ssprSettlementlineId = UtilSql.getValue(result, "sspr_settlementline_id");
        objectDocLineSettlementData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocLineSettlementData.line = UtilSql.getValue(result, "line");
        objectDocLineSettlementData.description = UtilSql.getValue(result, "description");
        objectDocLineSettlementData.totalnet = UtilSql.getValue(result, "totalnet");
        objectDocLineSettlementData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectDocLineSettlementData.cCostcenterId = UtilSql.getValue(result, "c_costcenter_id");
        objectDocLineSettlementData.user1Id = UtilSql.getValue(result, "user1_id");
        objectDocLineSettlementData.user2Id = UtilSql.getValue(result, "user2_id");
        objectDocLineSettlementData.ssprConceptId = UtilSql.getValue(result, "sspr_concept_id");
        objectDocLineSettlementData.ssprCategoryAcctId = UtilSql.getValue(result, "sspr_category_acct_id");
        objectDocLineSettlementData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectDocLineSettlementData.iscomplete = UtilSql.getValue(result, "iscomplete");
        objectDocLineSettlementData.balanceacctId = UtilSql.getValue(result, "balanceacct_id");
        objectDocLineSettlementData.nameconcept = UtilSql.getValue(result, "nameconcept");
        objectDocLineSettlementData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocLineSettlementData);
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
    DocLineSettlementData objectDocLineSettlementData[] = new DocLineSettlementData[vector.size()];
    vector.copyInto(objectDocLineSettlementData);
    return(objectDocLineSettlementData);
  }
}
