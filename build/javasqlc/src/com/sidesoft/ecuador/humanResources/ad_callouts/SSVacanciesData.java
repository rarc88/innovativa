//Sqlc generated V1.O00-1
package com.sidesoft.ecuador.humanResources.ad_callouts;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

public class SSVacanciesData implements FieldProvider {
static Logger log4j = Logger.getLogger(SSVacanciesData.class);
  private String InitRecordNumber="0";
  public String vacancies;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("vacancies"))
      return vacancies;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SSVacanciesData[] select(ConnectionProvider connectionProvider, String sshrPositionId)    throws ServletException {
    return select(connectionProvider, sshrPositionId, 0, 0);
  }

  public static SSVacanciesData[] select(ConnectionProvider connectionProvider, String sshrPositionId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		select positions_available as vacancies" +
      "		from sshr_position_title" +
      "		where sshr_position_title_id = ?";

    ResultSet result;
    Vector<SSVacanciesData> vector = new Vector<SSVacanciesData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sshrPositionId);

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
        SSVacanciesData objectSSVacanciesData = new SSVacanciesData();
        objectSSVacanciesData.vacancies = UtilSql.getValue(result, "vacancies");
        objectSSVacanciesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSSVacanciesData);
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
    SSVacanciesData objectSSVacanciesData[] = new SSVacanciesData[vector.size()];
    vector.copyInto(objectSSVacanciesData);
    return(objectSSVacanciesData);
  }
}
