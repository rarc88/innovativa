//Sqlc generated V1.O00-1
package com.sidesoft.localization.ecuador.withholdings.ad_callouts;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

public class SSInvoiceReferenceData implements FieldProvider {
static Logger log4j = Logger.getLogger(SSInvoiceReferenceData.class);
  private String InitRecordNumber="0";
  public String noreferencia;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("noreferencia"))
      return noreferencia;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SSInvoiceReferenceData[] select(ConnectionProvider connectionProvider, String strDateEnd, String c_bpartner_id)    throws ServletException {
    return select(connectionProvider, strDateEnd, c_bpartner_id, 0, 0);
  }

  public static SSInvoiceReferenceData[] select(ConnectionProvider connectionProvider, String strDateEnd, String c_bpartner_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		SELECT COALESCE(TO_CHAR(poreference), '<no hay datos>')  AS noreferencia" +
      "        FROM c_invoice" +
      "        WHERE issotrx = 'Y' AND docstatus = 'CO' AND dateinvoiced >= TO_DATE(?) AND c_bpartner_id = ?";

    ResultSet result;
    Vector<SSInvoiceReferenceData> vector = new Vector<SSInvoiceReferenceData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, strDateEnd);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_bpartner_id);

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
        SSInvoiceReferenceData objectSSInvoiceReferenceData = new SSInvoiceReferenceData();
        objectSSInvoiceReferenceData.noreferencia = UtilSql.getValue(result, "noreferencia");
        objectSSInvoiceReferenceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSSInvoiceReferenceData);
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
    SSInvoiceReferenceData objectSSInvoiceReferenceData[] = new SSInvoiceReferenceData[vector.size()];
    vector.copyInto(objectSSInvoiceReferenceData);
    return(objectSSInvoiceReferenceData);
  }
}
