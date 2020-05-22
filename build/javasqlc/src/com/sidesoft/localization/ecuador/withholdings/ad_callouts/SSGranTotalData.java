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

public class SSGranTotalData implements FieldProvider {
static Logger log4j = Logger.getLogger(SSGranTotalData.class);
  private String InitRecordNumber="0";
  public String ttotal;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ttotal"))
      return ttotal;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SSGranTotalData[] select(ConnectionProvider connectionProvider, String cDebtPaymentId)    throws ServletException {
    return select(connectionProvider, cDebtPaymentId, 0, 0);
  }

  public static SSGranTotalData[] select(ConnectionProvider connectionProvider, String cDebtPaymentId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		SELECT abs(round(AMOUNT,4)) as ttotal FROM C_DEBT_PAYMENT" +
      "		WHERE c_debt_payment_id=?";

    ResultSet result;
    Vector<SSGranTotalData> vector = new Vector<SSGranTotalData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDebtPaymentId);

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
        SSGranTotalData objectSSGranTotalData = new SSGranTotalData();
        objectSSGranTotalData.ttotal = UtilSql.getValue(result, "ttotal");
        objectSSGranTotalData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSSGranTotalData);
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
    SSGranTotalData objectSSGranTotalData[] = new SSGranTotalData[vector.size()];
    vector.copyInto(objectSSGranTotalData);
    return(objectSSGranTotalData);
  }
}
