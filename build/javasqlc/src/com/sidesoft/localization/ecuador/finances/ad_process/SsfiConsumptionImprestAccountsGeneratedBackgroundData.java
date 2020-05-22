//Sqlc generated V1.O00-1
package com.sidesoft.localization.ecuador.finances.ad_process;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class SsfiConsumptionImprestAccountsGeneratedBackgroundData implements FieldProvider {
static Logger log4j = Logger.getLogger(SsfiConsumptionImprestAccountsGeneratedBackgroundData.class);
  private String InitRecordNumber="0";
  public String finPaymentId;
  public String documentno;
  public String usedCredit;
  public String amount;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("fin_payment_id") || fieldName.equals("finPaymentId"))
      return finPaymentId;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("used_credit") || fieldName.equals("usedCredit"))
      return usedCredit;
    else if (fieldName.equalsIgnoreCase("amount"))
      return amount;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SsfiConsumptionImprestAccountsGeneratedBackgroundData[] select(ConnectionProvider connectionProvider, String ispayment)    throws ServletException {
    return select(connectionProvider, ispayment, 0, 0);
  }

  public static SsfiConsumptionImprestAccountsGeneratedBackgroundData[] select(ConnectionProvider connectionProvider, String ispayment, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "SELECT p.fin_payment_id, p.documentno, p.used_credit, pct.amount  " +
      "FROM fin_payment p  " +
      "JOIN (" +
      "  SELECT pc.fin_payment_id_used, sum(pc.amount) AS amount  " +
      "  FROM fin_payment_credit pc  " +
      "  GROUP BY pc.fin_payment_id_used  " +
      ") pct ON pct.fin_payment_id_used = p.fin_payment_id   " +
      "WHERE p.used_credit <> pct.amount" +
      " and '1' = ?";

    ResultSet result;
    Vector<SsfiConsumptionImprestAccountsGeneratedBackgroundData> vector = new Vector<SsfiConsumptionImprestAccountsGeneratedBackgroundData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ispayment);

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
        SsfiConsumptionImprestAccountsGeneratedBackgroundData objectSsfiConsumptionImprestAccountsGeneratedBackgroundData = new SsfiConsumptionImprestAccountsGeneratedBackgroundData();
        objectSsfiConsumptionImprestAccountsGeneratedBackgroundData.finPaymentId = UtilSql.getValue(result, "fin_payment_id");
        objectSsfiConsumptionImprestAccountsGeneratedBackgroundData.documentno = UtilSql.getValue(result, "documentno");
        objectSsfiConsumptionImprestAccountsGeneratedBackgroundData.usedCredit = UtilSql.getValue(result, "used_credit");
        objectSsfiConsumptionImprestAccountsGeneratedBackgroundData.amount = UtilSql.getValue(result, "amount");
        objectSsfiConsumptionImprestAccountsGeneratedBackgroundData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSsfiConsumptionImprestAccountsGeneratedBackgroundData);
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
    SsfiConsumptionImprestAccountsGeneratedBackgroundData objectSsfiConsumptionImprestAccountsGeneratedBackgroundData[] = new SsfiConsumptionImprestAccountsGeneratedBackgroundData[vector.size()];
    vector.copyInto(objectSsfiConsumptionImprestAccountsGeneratedBackgroundData);
    return(objectSsfiConsumptionImprestAccountsGeneratedBackgroundData);
  }

  public static SsfiConsumptionImprestAccountsGeneratedBackgroundData[] set()    throws ServletException {
    SsfiConsumptionImprestAccountsGeneratedBackgroundData objectSsfiConsumptionImprestAccountsGeneratedBackgroundData[] = new SsfiConsumptionImprestAccountsGeneratedBackgroundData[1];
    objectSsfiConsumptionImprestAccountsGeneratedBackgroundData[0] = new SsfiConsumptionImprestAccountsGeneratedBackgroundData();
    objectSsfiConsumptionImprestAccountsGeneratedBackgroundData[0].finPaymentId = "";
    objectSsfiConsumptionImprestAccountsGeneratedBackgroundData[0].documentno = "";
    objectSsfiConsumptionImprestAccountsGeneratedBackgroundData[0].usedCredit = "";
    objectSsfiConsumptionImprestAccountsGeneratedBackgroundData[0].amount = "";
    return objectSsfiConsumptionImprestAccountsGeneratedBackgroundData;
  }
}
