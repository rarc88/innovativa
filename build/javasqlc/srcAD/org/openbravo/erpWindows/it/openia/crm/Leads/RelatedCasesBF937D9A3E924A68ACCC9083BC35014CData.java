//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.it.openia.crm.Leads;

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
class RelatedCasesBF937D9A3E924A68ACCC9083BC35014CData implements FieldProvider {
static Logger log4j = Logger.getLogger(RelatedCasesBF937D9A3E924A68ACCC9083BC35014CData.class);
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

  public static RelatedCasesBF937D9A3E924A68ACCC9083BC35014CData[] dummy(ConnectionProvider connectionProvider)    throws ServletException {
    return dummy(connectionProvider, 0, 0);
  }

  public static RelatedCasesBF937D9A3E924A68ACCC9083BC35014CData[] dummy(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT '' AS dummy from DUAL";

    ResultSet result;
    Vector<RelatedCasesBF937D9A3E924A68ACCC9083BC35014CData> vector = new Vector<RelatedCasesBF937D9A3E924A68ACCC9083BC35014CData>(0);
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
        RelatedCasesBF937D9A3E924A68ACCC9083BC35014CData objectRelatedCasesBF937D9A3E924A68ACCC9083BC35014CData = new RelatedCasesBF937D9A3E924A68ACCC9083BC35014CData();
        objectRelatedCasesBF937D9A3E924A68ACCC9083BC35014CData.dummy = UtilSql.getValue(result, "dummy");
        objectRelatedCasesBF937D9A3E924A68ACCC9083BC35014CData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRelatedCasesBF937D9A3E924A68ACCC9083BC35014CData);
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
    RelatedCasesBF937D9A3E924A68ACCC9083BC35014CData objectRelatedCasesBF937D9A3E924A68ACCC9083BC35014CData[] = new RelatedCasesBF937D9A3E924A68ACCC9083BC35014CData[vector.size()];
    vector.copyInto(objectRelatedCasesBF937D9A3E924A68ACCC9083BC35014CData);
    return(objectRelatedCasesBF937D9A3E924A68ACCC9083BC35014CData);
  }

/**
Select for auxiliar field
 */
  public static String selectActP33BD1CE5A5934EDFAE283A16E6BF5257_startdate(ConnectionProvider connectionProvider, String opcrm_cases_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT c.deadline_date FROM opcrm_cases c WHERE c.opcrm_cases_id = ? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, opcrm_cases_id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "deadline_date");
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
  public static String selectActP33BD1CE5A5934EDFAE283A16E6BF5257_subject(ConnectionProvider connectionProvider, String opcrm_cases_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT c.case_subject FROM opcrm_cases c WHERE c.opcrm_cases_id = ? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, opcrm_cases_id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "case_subject");
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
