//Sqlc generated V1.O00-1
package com.sidesoft.localization.ecuador.withholdings.create_xml;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

public class SswhDebitCreditNoteDetData implements FieldProvider {
static Logger log4j = Logger.getLogger(SswhDebitCreditNoteDetData.class);
  private String InitRecordNumber="0";
  public String tipoComprobante;
  public String establecimiento;
  public String caja;
  public String secuencia;
  public String autorizacion;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("tipo_comprobante") || fieldName.equals("tipoComprobante"))
      return tipoComprobante;
    else if (fieldName.equalsIgnoreCase("establecimiento"))
      return establecimiento;
    else if (fieldName.equalsIgnoreCase("caja"))
      return caja;
    else if (fieldName.equalsIgnoreCase("secuencia"))
      return secuencia;
    else if (fieldName.equalsIgnoreCase("autorizacion"))
      return autorizacion;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SswhDebitCreditNoteDetData[] select(ConnectionProvider connectionProvider, String InvoiceID)    throws ServletException {
    return select(connectionProvider, InvoiceID, 0, 0);
  }

  public static SswhDebitCreditNoteDetData[] select(ConnectionProvider connectionProvider, String InvoiceID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "select tipo_comprobante,establecimiento,caja,secuencia,autorizacion from sswh_dc_note_v where c_invoice_id = ? ";

    ResultSet result;
    Vector<SswhDebitCreditNoteDetData> vector = new Vector<SswhDebitCreditNoteDetData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, InvoiceID);

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
        SswhDebitCreditNoteDetData objectSswhDebitCreditNoteDetData = new SswhDebitCreditNoteDetData();
        objectSswhDebitCreditNoteDetData.tipoComprobante = UtilSql.getValue(result, "tipo_comprobante");
        objectSswhDebitCreditNoteDetData.establecimiento = UtilSql.getValue(result, "establecimiento");
        objectSswhDebitCreditNoteDetData.caja = UtilSql.getValue(result, "caja");
        objectSswhDebitCreditNoteDetData.secuencia = UtilSql.getValue(result, "secuencia");
        objectSswhDebitCreditNoteDetData.autorizacion = UtilSql.getValue(result, "autorizacion");
        objectSswhDebitCreditNoteDetData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSswhDebitCreditNoteDetData);
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
    SswhDebitCreditNoteDetData objectSswhDebitCreditNoteDetData[] = new SswhDebitCreditNoteDetData[vector.size()];
    vector.copyInto(objectSswhDebitCreditNoteDetData);
    return(objectSswhDebitCreditNoteDetData);
  }
}
