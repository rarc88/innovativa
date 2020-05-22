//Sqlc generated V1.O00-1
package com.sidesoft.localization.ecuador.withholdings.ad_process;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class SswhPaymentMonitorProcessData implements FieldProvider {
static Logger log4j = Logger.getLogger(SswhPaymentMonitorProcessData.class);
  private String InitRecordNumber="0";
  public String outstandingamt;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("outstandingamt"))
      return outstandingamt;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SswhPaymentMonitorProcessData[] selectRecord(ConnectionProvider connectionProvider, String C_invoice_ID)    throws ServletException {
    return selectRecord(connectionProvider, C_invoice_ID, 0, 0);
  }

  public static SswhPaymentMonitorProcessData[] selectRecord(ConnectionProvider connectionProvider, String C_invoice_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		select  " +
      "		   coalesce((select round(sum(outstandingamt),2) as outstandingamt  from fin_payment_schedule where c_invoice_id = ?),0) as outstandingamt  " +
      "		from dual ";

    ResultSet result;
    Vector<SswhPaymentMonitorProcessData> vector = new Vector<SswhPaymentMonitorProcessData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_invoice_ID);

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
        SswhPaymentMonitorProcessData objectSswhPaymentMonitorProcessData = new SswhPaymentMonitorProcessData();
        objectSswhPaymentMonitorProcessData.outstandingamt = UtilSql.getValue(result, "outstandingamt");
        objectSswhPaymentMonitorProcessData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSswhPaymentMonitorProcessData);
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
    SswhPaymentMonitorProcessData objectSswhPaymentMonitorProcessData[] = new SswhPaymentMonitorProcessData[vector.size()];
    vector.copyInto(objectSswhPaymentMonitorProcessData);
    return(objectSswhPaymentMonitorProcessData);
  }
}
