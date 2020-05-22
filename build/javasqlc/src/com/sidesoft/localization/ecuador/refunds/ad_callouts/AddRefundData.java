//Sqlc generated V1.O00-1
package com.sidesoft.localization.ecuador.refunds.ad_callouts;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class AddRefundData implements FieldProvider {
static Logger log4j = Logger.getLogger(AddRefundData.class);
  private String InitRecordNumber="0";
  public String sswhCodelivelihoodtId;
  public String sswhLivelihoodtId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("sswh_codelivelihoodt_id") || fieldName.equals("sswhCodelivelihoodtId"))
      return sswhCodelivelihoodtId;
    else if (fieldName.equalsIgnoreCase("sswh_livelihoodt_id") || fieldName.equals("sswhLivelihoodtId"))
      return sswhLivelihoodtId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static AddRefundData[] select(ConnectionProvider connectionProvider, String ssreRefundId)    throws ServletException {
    return select(connectionProvider, ssreRefundId, 0, 0);
  }

  public static AddRefundData[] select(ConnectionProvider connectionProvider, String ssreRefundId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT SSWH_CODELIVELIHOODT_ID, SSWH_LIVELIHOODT_ID" +
      "      FROM SSRE_REFUND" +
      "      WHERE SSRE_REFUND_ID = ?";

    ResultSet result;
    Vector<AddRefundData> vector = new Vector<AddRefundData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ssreRefundId);

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
        AddRefundData objectAddRefundData = new AddRefundData();
        objectAddRefundData.sswhCodelivelihoodtId = UtilSql.getValue(result, "sswh_codelivelihoodt_id");
        objectAddRefundData.sswhLivelihoodtId = UtilSql.getValue(result, "sswh_livelihoodt_id");
        objectAddRefundData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAddRefundData);
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
    AddRefundData objectAddRefundData[] = new AddRefundData[vector.size()];
    vector.copyInto(objectAddRefundData);
    return(objectAddRefundData);
  }
}
