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

class DocLineInvoiceData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocLineInvoiceData.class);
  private String InitRecordNumber="0";
  public String ilTaxamt;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("il_taxamt") || fieldName.equals("ilTaxamt"))
      return ilTaxamt;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocLineInvoiceData[] selectTaxTotalForInvoiceLine(ConnectionProvider connectionProvider, String C_Invoiceline_ID)    throws ServletException {
    return selectTaxTotalForInvoiceLine(connectionProvider, C_Invoiceline_ID, 0, 0);
  }

  public static DocLineInvoiceData[] selectTaxTotalForInvoiceLine(ConnectionProvider connectionProvider, String C_Invoiceline_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT sum(ilt.Taxamt) as IL_TAXAMT" +
      "		FROM C_InvoiceLineTax ilt" +
      "        WHERE ilt.C_Invoiceline_ID = ?; 		  ";

    ResultSet result;
    Vector<DocLineInvoiceData> vector = new Vector<DocLineInvoiceData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Invoiceline_ID);

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
        DocLineInvoiceData objectDocLineInvoiceData = new DocLineInvoiceData();
        objectDocLineInvoiceData.ilTaxamt = UtilSql.getValue(result, "il_taxamt");
        objectDocLineInvoiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocLineInvoiceData);
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
    DocLineInvoiceData objectDocLineInvoiceData[] = new DocLineInvoiceData[vector.size()];
    vector.copyInto(objectDocLineInvoiceData);
    return(objectDocLineInvoiceData);
  }
}
