//Sqlc generated V1.O00-1
package ec.com.sidesoft.purchase.advanced.accounting.payment;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class DocPaidInvoiceData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocPaidInvoiceData.class);
  private String InitRecordNumber="0";
  public String totalamt;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("totalamt"))
      return totalamt;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocPaidInvoiceData[] selectPaidAmt(ConnectionProvider connectionProvider, String C_Invoice_ID)    throws ServletException {
    return selectPaidAmt(connectionProvider, C_Invoice_ID, 0, 0);
  }

  public static DocPaidInvoiceData[] selectPaidAmt(ConnectionProvider connectionProvider, String C_Invoice_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            select coalesce(sum(paidamt), 0) as totalamt from ssfi_fin_payment_detail_v" +
      "            inner join fin_payment on ssfi_fin_payment_detail_v.fin_payment_id = fin_payment.fin_payment_id" +
      "            where c_invoice_id = ? and fin_payment.posted = 'Y';        ";

    ResultSet result;
    Vector<DocPaidInvoiceData> vector = new Vector<DocPaidInvoiceData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Invoice_ID);

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
        DocPaidInvoiceData objectDocPaidInvoiceData = new DocPaidInvoiceData();
        objectDocPaidInvoiceData.totalamt = UtilSql.getValue(result, "totalamt");
        objectDocPaidInvoiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocPaidInvoiceData);
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
    DocPaidInvoiceData objectDocPaidInvoiceData[] = new DocPaidInvoiceData[vector.size()];
    vector.copyInto(objectDocPaidInvoiceData);
    return(objectDocPaidInvoiceData);
  }
}
