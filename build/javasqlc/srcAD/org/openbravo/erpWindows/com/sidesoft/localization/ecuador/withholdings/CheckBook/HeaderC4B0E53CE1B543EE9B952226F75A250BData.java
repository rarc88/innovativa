//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.com.sidesoft.localization.ecuador.withholdings.CheckBook;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

/**
WAD Generated class
 */
class HeaderC4B0E53CE1B543EE9B952226F75A250BData implements FieldProvider {
static Logger log4j = Logger.getLogger(HeaderC4B0E53CE1B543EE9B952226F75A250BData.class);
  private String InitRecordNumber="0";
  public String dummy;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("dummy"))
      return dummy;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static HeaderC4B0E53CE1B543EE9B952226F75A250BData[] dummy(ConnectionProvider connectionProvider)    throws ServletException {
    return dummy(connectionProvider, 0, 0);
  }

  public static HeaderC4B0E53CE1B543EE9B952226F75A250BData[] dummy(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT '' AS dummy from DUAL";

    ResultSet result;
    Vector<HeaderC4B0E53CE1B543EE9B952226F75A250BData> vector = new Vector<HeaderC4B0E53CE1B543EE9B952226F75A250BData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());

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
        HeaderC4B0E53CE1B543EE9B952226F75A250BData objectHeaderC4B0E53CE1B543EE9B952226F75A250BData = new HeaderC4B0E53CE1B543EE9B952226F75A250BData();
        objectHeaderC4B0E53CE1B543EE9B952226F75A250BData.dummy = UtilSql.getValue(result, "dummy");
        objectHeaderC4B0E53CE1B543EE9B952226F75A250BData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectHeaderC4B0E53CE1B543EE9B952226F75A250BData);
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
    HeaderC4B0E53CE1B543EE9B952226F75A250BData objectHeaderC4B0E53CE1B543EE9B952226F75A250BData[] = new HeaderC4B0E53CE1B543EE9B952226F75A250BData[vector.size()];
    vector.copyInto(objectHeaderC4B0E53CE1B543EE9B952226F75A250BData);
    return(objectHeaderC4B0E53CE1B543EE9B952226F75A250BData);
  }

  public static int updateDocaction(ConnectionProvider connectionProvider, String docaction, String sswhCheckbookId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE SSWH_checkbook" +
      "        SET docaction = ? " +
      "        WHERE SSWH_checkbook.Sswh_Checkbook_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docaction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sswhCheckbookId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      updateCount = st.executeUpdate();
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
    return(updateCount);
  }
}
