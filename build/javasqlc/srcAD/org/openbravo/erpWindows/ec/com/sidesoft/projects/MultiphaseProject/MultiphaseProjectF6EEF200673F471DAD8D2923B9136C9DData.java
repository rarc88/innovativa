//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.ec.com.sidesoft.projects.MultiphaseProject;

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
class MultiphaseProjectF6EEF200673F471DAD8D2923B9136C9DData implements FieldProvider {
static Logger log4j = Logger.getLogger(MultiphaseProjectF6EEF200673F471DAD8D2923B9136C9DData.class);
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

  public static MultiphaseProjectF6EEF200673F471DAD8D2923B9136C9DData[] dummy(ConnectionProvider connectionProvider)    throws ServletException {
    return dummy(connectionProvider, 0, 0);
  }

  public static MultiphaseProjectF6EEF200673F471DAD8D2923B9136C9DData[] dummy(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT '' AS dummy from DUAL";

    ResultSet result;
    Vector<MultiphaseProjectF6EEF200673F471DAD8D2923B9136C9DData> vector = new Vector<MultiphaseProjectF6EEF200673F471DAD8D2923B9136C9DData>(0);
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
        MultiphaseProjectF6EEF200673F471DAD8D2923B9136C9DData objectMultiphaseProjectF6EEF200673F471DAD8D2923B9136C9DData = new MultiphaseProjectF6EEF200673F471DAD8D2923B9136C9DData();
        objectMultiphaseProjectF6EEF200673F471DAD8D2923B9136C9DData.dummy = UtilSql.getValue(result, "dummy");
        objectMultiphaseProjectF6EEF200673F471DAD8D2923B9136C9DData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectMultiphaseProjectF6EEF200673F471DAD8D2923B9136C9DData);
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
    MultiphaseProjectF6EEF200673F471DAD8D2923B9136C9DData objectMultiphaseProjectF6EEF200673F471DAD8D2923B9136C9DData[] = new MultiphaseProjectF6EEF200673F471DAD8D2923B9136C9DData[vector.size()];
    vector.copyInto(objectMultiphaseProjectF6EEF200673F471DAD8D2923B9136C9DData);
    return(objectMultiphaseProjectF6EEF200673F471DAD8D2923B9136C9DData);
  }

  public static int updateChangeProjectStatus(ConnectionProvider connectionProvider, String changeprojectstatus, String cProjectId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE C_Project" +
      "        SET changeprojectstatus = ? " +
      "        WHERE C_Project.C_Project_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, changeprojectstatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);

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

/**
Select for action search
 */
  public static String selectActDefC_Project_ID(ConnectionProvider connectionProvider, String C_Project_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT Value FROM C_Project WHERE isActive='Y' AND C_Project_ID = ?  ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_Project_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "value");
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
