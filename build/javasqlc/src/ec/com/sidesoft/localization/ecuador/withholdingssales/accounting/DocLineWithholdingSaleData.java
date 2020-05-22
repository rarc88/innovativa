//Sqlc generated V1.O00-1
package ec.com.sidesoft.localization.ecuador.withholdingssales.accounting;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class DocLineWithholdingSaleData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocLineWithholdingSaleData.class);
  private String InitRecordNumber="0";
  public String sswsWithholdingsalelineId;
  public String adOrgId;
  public String line;
  public String description;
  public String amount;
  public String cCurrencyId;
  public String customerTaxAcctId;
  public String vendorTaxAcctId;
  public String withholdingtype;
  public String paidinvoice;
  public String cGlitemId;
  public String glitemCreditAcct;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ssws_withholdingsaleline_id") || fieldName.equals("sswsWithholdingsalelineId"))
      return sswsWithholdingsalelineId;
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
    else if (fieldName.equalsIgnoreCase("customer_tax_acct_id") || fieldName.equals("customerTaxAcctId"))
      return customerTaxAcctId;
    else if (fieldName.equalsIgnoreCase("vendor_tax_acct_id") || fieldName.equals("vendorTaxAcctId"))
      return vendorTaxAcctId;
    else if (fieldName.equalsIgnoreCase("withholdingtype"))
      return withholdingtype;
    else if (fieldName.equalsIgnoreCase("paidinvoice"))
      return paidinvoice;
    else if (fieldName.equalsIgnoreCase("c_glitem_id") || fieldName.equals("cGlitemId"))
      return cGlitemId;
    else if (fieldName.equalsIgnoreCase("glitem_credit_acct") || fieldName.equals("glitemCreditAcct"))
      return glitemCreditAcct;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocLineWithholdingSaleData[] select(ConnectionProvider connectionProvider, String certificate)    throws ServletException {
    return select(connectionProvider, certificate, 0, 0);
  }

  public static DocLineWithholdingSaleData[] select(ConnectionProvider connectionProvider, String certificate, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT WSL.SSWS_WITHHOLDINGSALELINE_ID, WSL.AD_ORG_ID, WSL.LINE, WSL.DESCRIPTION, " +
      "               COALESCE(WSL.WHRENTALAMT + WSL.WHIVAAMT, 0) AS AMOUNT, WS.C_CURRENCY_ID," +
      "               TAXAC.T_DUE_ACCT AS CUSTOMER_TAX_ACCT_ID, TAXAC.T_CREDIT_ACCT AS VENDOR_TAX_ACCT_ID," +
      "               WS.WITHHOLDINGTYPE, WS.PAIDINVOICE, WS.C_GLITEM_ID, GL.GLITEM_CREDIT_ACCT" +
      "        FROM SSWS_WITHHOLDINGSALELINE WSL" +
      "        JOIN SSWS_WITHHOLDINGSALE WS ON WS.SSWS_WITHHOLDINGSALE_ID = WSL.SSWS_WITHHOLDINGSALE_ID" +
      "        JOIN C_TAX TAX ON TAX.C_TAX_ID = WSL.C_TAX_ID" +
      "        LEFT JOIN C_TAX_ACCT TAXAC ON TAXAC.C_TAX_ID = TAX.C_TAX_ID" +
      "        LEFT JOIN C_GLITEM_ACCT GL ON GL.C_GLITEM_ID = WS.C_GLITEM_ID" +
      "        WHERE (WSL.ISRENTAL = 'Y' AND COALESCE(WSL.WHRENTALAMT, 0) <> 0 OR WSL.ISRENTAL = 'N' AND COALESCE(WSL.WHIVAAMT, 0) <> 0) " +
      "        AND   WS.SSWS_WITHHOLDINGSALE_ID = ?" +
      "        ORDER BY Line";

    ResultSet result;
    Vector<DocLineWithholdingSaleData> vector = new Vector<DocLineWithholdingSaleData>(0);
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
        DocLineWithholdingSaleData objectDocLineWithholdingSaleData = new DocLineWithholdingSaleData();
        objectDocLineWithholdingSaleData.sswsWithholdingsalelineId = UtilSql.getValue(result, "ssws_withholdingsaleline_id");
        objectDocLineWithholdingSaleData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocLineWithholdingSaleData.line = UtilSql.getValue(result, "line");
        objectDocLineWithholdingSaleData.description = UtilSql.getValue(result, "description");
        objectDocLineWithholdingSaleData.amount = UtilSql.getValue(result, "amount");
        objectDocLineWithholdingSaleData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectDocLineWithholdingSaleData.customerTaxAcctId = UtilSql.getValue(result, "customer_tax_acct_id");
        objectDocLineWithholdingSaleData.vendorTaxAcctId = UtilSql.getValue(result, "vendor_tax_acct_id");
        objectDocLineWithholdingSaleData.withholdingtype = UtilSql.getValue(result, "withholdingtype");
        objectDocLineWithholdingSaleData.paidinvoice = UtilSql.getValue(result, "paidinvoice");
        objectDocLineWithholdingSaleData.cGlitemId = UtilSql.getValue(result, "c_glitem_id");
        objectDocLineWithholdingSaleData.glitemCreditAcct = UtilSql.getValue(result, "glitem_credit_acct");
        objectDocLineWithholdingSaleData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocLineWithholdingSaleData);
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
    DocLineWithholdingSaleData objectDocLineWithholdingSaleData[] = new DocLineWithholdingSaleData[vector.size()];
    vector.copyInto(objectDocLineWithholdingSaleData);
    return(objectDocLineWithholdingSaleData);
  }
}
