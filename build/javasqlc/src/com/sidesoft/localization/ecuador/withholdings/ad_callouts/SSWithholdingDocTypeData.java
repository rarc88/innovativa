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

class SSWithholdingDocTypeData implements FieldProvider {
static Logger log4j = Logger.getLogger(SSWithholdingDocTypeData.class);
  private String InitRecordNumber="0";
  public String isdocnocontrolled;
  public String currentnext;
  public String authorizationno;
  public String emSswhCDoctypeId;
  public String dateinvoiced;
  public String emSswhWithholdingref;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("isdocnocontrolled"))
      return isdocnocontrolled;
    else if (fieldName.equalsIgnoreCase("currentnext"))
      return currentnext;
    else if (fieldName.equalsIgnoreCase("authorizationno"))
      return authorizationno;
    else if (fieldName.equalsIgnoreCase("em_sswh_c_doctype_id") || fieldName.equals("emSswhCDoctypeId"))
      return emSswhCDoctypeId;
    else if (fieldName.equalsIgnoreCase("dateinvoiced"))
      return dateinvoiced;
    else if (fieldName.equalsIgnoreCase("em_sswh_withholdingref") || fieldName.equals("emSswhWithholdingref"))
      return emSswhWithholdingref;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SSWithholdingDocTypeData[] select(ConnectionProvider connectionProvider, String cDocTypeId, String dateWithhold)    throws ServletException {
    return select(connectionProvider, cDocTypeId, dateWithhold, 0, 0);
  }

  public static SSWithholdingDocTypeData[] select(ConnectionProvider connectionProvider, String cDocTypeId, String dateWithhold, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT d.IsDocNoControlled," +
      "        s.CurrentNext, a.authorizationno, '' AS EM_SSWH_C_DOCTYPE_ID, '' AS DATEINVOICED, '' AS EM_SSWH_WITHHOLDINGREF" +
      "        FROM C_DocType d LEFT JOIN  AD_Sequence s ON d.DocNoSequence_ID=s.AD_Sequence_ID" +
      "                         LEFT JOIN SSWH_Authorization a ON d.C_Doctype_ID=a.C_Doctype_ID" +
      "        WHERE d.C_DocType_ID=? AND TO_DATE(?) BETWEEN datefrom AND dateto " +
      "                               AND s.CurrentNext BETWEEN NUMBERFROM AND NUMBERTO";

    ResultSet result;
    Vector<SSWithholdingDocTypeData> vector = new Vector<SSWithholdingDocTypeData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDocTypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateWithhold);

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
        SSWithholdingDocTypeData objectSSWithholdingDocTypeData = new SSWithholdingDocTypeData();
        objectSSWithholdingDocTypeData.isdocnocontrolled = UtilSql.getValue(result, "isdocnocontrolled");
        objectSSWithholdingDocTypeData.currentnext = UtilSql.getValue(result, "currentnext");
        objectSSWithholdingDocTypeData.authorizationno = UtilSql.getValue(result, "authorizationno");
        objectSSWithholdingDocTypeData.emSswhCDoctypeId = UtilSql.getValue(result, "em_sswh_c_doctype_id");
        objectSSWithholdingDocTypeData.dateinvoiced = UtilSql.getValue(result, "dateinvoiced");
        objectSSWithholdingDocTypeData.emSswhWithholdingref = UtilSql.getValue(result, "em_sswh_withholdingref");
        objectSSWithholdingDocTypeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSSWithholdingDocTypeData);
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
    SSWithholdingDocTypeData objectSSWithholdingDocTypeData[] = new SSWithholdingDocTypeData[vector.size()];
    vector.copyInto(objectSSWithholdingDocTypeData);
    return(objectSSWithholdingDocTypeData);
  }

  public static String selectWithholdingDoctypeinvoice(ConnectionProvider connectionProvider, String cInvoiceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT EM_SSWH_C_DOCTYPE_ID" +
      "        FROM C_INVOICE" +
      "        WHERE C_INVOICE_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "em_sswh_c_doctype_id");
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
    return(strReturn);
  }

  public static String selectActualinvoicewithholding(ConnectionProvider connectionProvider, String cInvoiceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT EM_SSWH_WITHHOLDINGREF" +
      "        FROM C_INVOICE" +
      "        WHERE C_INVOICE_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "em_sswh_withholdingref");
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
    return(strReturn);
  }
}
