//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.it.openia.crm.Activities;

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
class Activities046D51DD5D4840C58C36AA09C776F0E1Data implements FieldProvider {
static Logger log4j = Logger.getLogger(Activities046D51DD5D4840C58C36AA09C776F0E1Data.class);
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

  public static Activities046D51DD5D4840C58C36AA09C776F0E1Data[] dummy(ConnectionProvider connectionProvider)    throws ServletException {
    return dummy(connectionProvider, 0, 0);
  }

  public static Activities046D51DD5D4840C58C36AA09C776F0E1Data[] dummy(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT '' AS dummy from DUAL";

    ResultSet result;
    Vector<Activities046D51DD5D4840C58C36AA09C776F0E1Data> vector = new Vector<Activities046D51DD5D4840C58C36AA09C776F0E1Data>(0);
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
        Activities046D51DD5D4840C58C36AA09C776F0E1Data objectActivities046D51DD5D4840C58C36AA09C776F0E1Data = new Activities046D51DD5D4840C58C36AA09C776F0E1Data();
        objectActivities046D51DD5D4840C58C36AA09C776F0E1Data.dummy = UtilSql.getValue(result, "dummy");
        objectActivities046D51DD5D4840C58C36AA09C776F0E1Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectActivities046D51DD5D4840C58C36AA09C776F0E1Data);
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
    Activities046D51DD5D4840C58C36AA09C776F0E1Data objectActivities046D51DD5D4840C58C36AA09C776F0E1Data[] = new Activities046D51DD5D4840C58C36AA09C776F0E1Data[vector.size()];
    vector.copyInto(objectActivities046D51DD5D4840C58C36AA09C776F0E1Data);
    return(objectActivities046D51DD5D4840C58C36AA09C776F0E1Data);
  }

/**
Select for auxiliar field
 */
  public static String selectActP69AADF0AEB704D5B86A892FED02C8190_subject(ConnectionProvider connectionProvider, String opcrm_activity_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT act.activity_subject FROM opcrm_activity act WHERE act.opcrm_activity_id = ? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, opcrm_activity_id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "activity_subject");
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

/**
Select for auxiliar field
 */
  public static String selectActPAD9E33FEC65145B38F6AFDB3C5A4E55F_subject(ConnectionProvider connectionProvider, String opcrm_activity_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT act.activity_subject FROM opcrm_activity act WHERE act.opcrm_activity_id = ? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, opcrm_activity_id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "activity_subject");
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
