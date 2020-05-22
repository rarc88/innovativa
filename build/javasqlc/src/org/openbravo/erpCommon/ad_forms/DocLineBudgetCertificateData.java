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

class DocLineBudgetCertificateData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocLineBudgetCertificateData.class);
  private String InitRecordNumber="0";
  public String sfbBudgetCertLineId;
  public String adOrgId;
  public String line;
  public String description;
  public String budgetCertifiedValue;
  public String cCurrencyId;
  public String cCostcenterId;
  public String user1Id;
  public String emSsbpSsprConceptId;
  public String emSsbpSsprCategoryAcctId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("sfb_budget_cert_line_id") || fieldName.equals("sfbBudgetCertLineId"))
      return sfbBudgetCertLineId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("budget_certified_value") || fieldName.equals("budgetCertifiedValue"))
      return budgetCertifiedValue;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_costcenter_id") || fieldName.equals("cCostcenterId"))
      return cCostcenterId;
    else if (fieldName.equalsIgnoreCase("user1_id") || fieldName.equals("user1Id"))
      return user1Id;
    else if (fieldName.equalsIgnoreCase("em_ssbp_sspr_concept_id") || fieldName.equals("emSsbpSsprConceptId"))
      return emSsbpSsprConceptId;
    else if (fieldName.equalsIgnoreCase("em_ssbp_sspr_category_acct_id") || fieldName.equals("emSsbpSsprCategoryAcctId"))
      return emSsbpSsprCategoryAcctId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocLineBudgetCertificateData[] select(ConnectionProvider connectionProvider, String certificate)    throws ServletException {
    return select(connectionProvider, certificate, 0, 0);
  }

  public static DocLineBudgetCertificateData[] select(ConnectionProvider connectionProvider, String certificate, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT CL.SFB_BUDGET_CERT_LINE_ID, CL.AD_ORG_ID, CL.LINE, CL.DESCRIPTION, " +
      "        CL.BUDGET_CERTIFIED_VALUE, C.C_CURRENCY_ID, CL.C_COSTCENTER_ID, CL.USER1_ID, CL.EM_SSBP_SSPR_CONCEPT_ID," +
      "        Cl.EM_SSBP_SSPR_CATEGORY_ACCT_ID" +
      "        FROM SFB_BUDGET_CERT_LINE Cl left join SFB_BUDGET_CERTIFICATE C on C.SFB_BUDGET_CERTIFICATE_ID = CL.SFB_BUDGET_CERTIFICATE_ID" +
      "        WHERE C.SFB_BUDGET_CERTIFICATE_ID=? AND CL.BUDGET_CERTIFIED_VALUE > 0" +
      "        UNION ALL" +
      "        SELECT NCL.SSBP_NO_BUDGET_CERT_LINE_ID, NCL.AD_ORG_ID, NCL.LINE, '' AS DESCRIPTION, " +
      "        NCL.AMOUNT, C.C_CURRENCY_ID, NCL.C_COSTCENTER_ID, NCL.USER1_ID, NCL.SSPR_CONCEPT_ID," +
      "        NCl.SSPR_CATEGORY_ACCT_ID" +
      "        FROM SSBP_NO_BUDGET_CERT_LINE NCL LEFT JOIN SFB_BUDGET_CERTIFICATE C ON C.SFB_BUDGET_CERTIFICATE_ID = NCL.SFB_BUDGET_CERTIFICATE_ID" +
      "        WHERE C.SFB_BUDGET_CERTIFICATE_ID=? AND NCL.AMOUNT > 0" +
      "        ORDER BY Line";

    ResultSet result;
    Vector<DocLineBudgetCertificateData> vector = new Vector<DocLineBudgetCertificateData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, certificate);
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
        DocLineBudgetCertificateData objectDocLineBudgetCertificateData = new DocLineBudgetCertificateData();
        objectDocLineBudgetCertificateData.sfbBudgetCertLineId = UtilSql.getValue(result, "sfb_budget_cert_line_id");
        objectDocLineBudgetCertificateData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocLineBudgetCertificateData.line = UtilSql.getValue(result, "line");
        objectDocLineBudgetCertificateData.description = UtilSql.getValue(result, "description");
        objectDocLineBudgetCertificateData.budgetCertifiedValue = UtilSql.getValue(result, "budget_certified_value");
        objectDocLineBudgetCertificateData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectDocLineBudgetCertificateData.cCostcenterId = UtilSql.getValue(result, "c_costcenter_id");
        objectDocLineBudgetCertificateData.user1Id = UtilSql.getValue(result, "user1_id");
        objectDocLineBudgetCertificateData.emSsbpSsprConceptId = UtilSql.getValue(result, "em_ssbp_sspr_concept_id");
        objectDocLineBudgetCertificateData.emSsbpSsprCategoryAcctId = UtilSql.getValue(result, "em_ssbp_sspr_category_acct_id");
        objectDocLineBudgetCertificateData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocLineBudgetCertificateData);
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
    DocLineBudgetCertificateData objectDocLineBudgetCertificateData[] = new DocLineBudgetCertificateData[vector.size()];
    vector.copyInto(objectDocLineBudgetCertificateData);
    return(objectDocLineBudgetCertificateData);
  }
}
