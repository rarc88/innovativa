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

public class SSCheckBookBankAccountData implements FieldProvider {
static Logger log4j = Logger.getLogger(SSCheckBookBankAccountData.class);
  private String InitRecordNumber="0";
  public String genericaccount;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("genericaccount"))
      return genericaccount;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SSCheckBookBankAccountData[] select(ConnectionProvider connectionProvider, String cBankaccountId)    throws ServletException {
    return select(connectionProvider, cBankaccountId, 0, 0);
  }

  public static SSCheckBookBankAccountData[] select(ConnectionProvider connectionProvider, String cBankaccountId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		select genericaccount from c_bankaccount " +
      "		where c_bankaccount_id=?";

    ResultSet result;
    Vector<SSCheckBookBankAccountData> vector = new Vector<SSCheckBookBankAccountData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBankaccountId);

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
        SSCheckBookBankAccountData objectSSCheckBookBankAccountData = new SSCheckBookBankAccountData();
        objectSSCheckBookBankAccountData.genericaccount = UtilSql.getValue(result, "genericaccount");
        objectSSCheckBookBankAccountData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSSCheckBookBankAccountData);
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
    SSCheckBookBankAccountData objectSSCheckBookBankAccountData[] = new SSCheckBookBankAccountData[vector.size()];
    vector.copyInto(objectSSCheckBookBankAccountData);
    return(objectSSCheckBookBankAccountData);
  }
}
