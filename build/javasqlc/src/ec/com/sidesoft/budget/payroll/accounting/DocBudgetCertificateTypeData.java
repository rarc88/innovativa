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

class DocBudgetCertificateTypeData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocBudgetCertificateTypeData.class);
  private String InitRecordNumber="0";
  public String adClientId;
  public String adOrgId;
  public String documentno;
  public String datedoc;
  public String cCurrencyId;
  public String cDoctypeId;
  public String posted;
  public String certifiedValue;
  public String emSsbpPayrolltype;
  public String emSsbpSsprSettlementId;

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
    else if (fieldName.equalsIgnoreCase("em_ssbp_payrolltype") || fieldName.equals("emSsbpPayrolltype"))
      return emSsbpPayrolltype;
    else if (fieldName.equalsIgnoreCase("em_ssbp_sspr_settlement_id") || fieldName.equals("emSsbpSsprSettlementId"))
      return emSsbpSsprSettlementId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocBudgetCertificateTypeData[] selectTypeCertificate(ConnectionProvider connectionProvider, String id)    throws ServletException {
    return selectTypeCertificate(connectionProvider, id, 0, 0);
  }

  public static DocBudgetCertificateTypeData[] selectTypeCertificate(ConnectionProvider connectionProvider, String id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_CLIENT_ID, AD_ORG_ID, DOCUMENTNO, DATE_ISSUE AS DATEDOC, C_CURRENCY_ID, C_DOCTYPE_ID, POSTED," +
      "        CERTIFIED_VALUE, EM_SSBP_PAYROLLTYPE, EM_SSBP_SSPR_SETTLEMENT_ID" +
      "        FROM SFB_BUDGET_CERTIFICATE" +
      "        WHERE SFB_BUDGET_CERTIFICATE_ID=?";

    ResultSet result;
    Vector<DocBudgetCertificateTypeData> vector = new Vector<DocBudgetCertificateTypeData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
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
        DocBudgetCertificateTypeData objectDocBudgetCertificateTypeData = new DocBudgetCertificateTypeData();
        objectDocBudgetCertificateTypeData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDocBudgetCertificateTypeData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocBudgetCertificateTypeData.documentno = UtilSql.getValue(result, "documentno");
        objectDocBudgetCertificateTypeData.datedoc = UtilSql.getDateValue(result, "datedoc", "dd-MM-yyyy");
        objectDocBudgetCertificateTypeData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectDocBudgetCertificateTypeData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectDocBudgetCertificateTypeData.posted = UtilSql.getValue(result, "posted");
        objectDocBudgetCertificateTypeData.certifiedValue = UtilSql.getValue(result, "certified_value");
        objectDocBudgetCertificateTypeData.emSsbpPayrolltype = UtilSql.getValue(result, "em_ssbp_payrolltype");
        objectDocBudgetCertificateTypeData.emSsbpSsprSettlementId = UtilSql.getValue(result, "em_ssbp_sspr_settlement_id");
        objectDocBudgetCertificateTypeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocBudgetCertificateTypeData);
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
    DocBudgetCertificateTypeData objectDocBudgetCertificateTypeData[] = new DocBudgetCertificateTypeData[vector.size()];
    vector.copyInto(objectDocBudgetCertificateTypeData);
    return(objectDocBudgetCertificateTypeData);
  }
}
