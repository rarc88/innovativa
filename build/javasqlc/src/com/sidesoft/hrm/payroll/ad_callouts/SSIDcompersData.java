//Sqlc generated V1.O00-1
package com.sidesoft.hrm.payroll.ad_callouts;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class SSIDcompersData implements FieldProvider {
static Logger log4j = Logger.getLogger(SSIDcompersData.class);
  private String InitRecordNumber="0";
  public String numMax;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("num_max") || fieldName.equals("numMax"))
      return numMax;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SSIDcompersData[] select(ConnectionProvider connectionProvider)    throws ServletException {
    return select(connectionProvider, 0, 0);
  }

  public static SSIDcompersData[] select(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "select to_char(max(em_sspr_compers_id)) as num_max from c_bpartner";

    ResultSet result;
    Vector<SSIDcompersData> vector = new Vector<SSIDcompersData>(0);
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
        SSIDcompersData objectSSIDcompersData = new SSIDcompersData();
        objectSSIDcompersData.numMax = UtilSql.getValue(result, "num_max");
        objectSSIDcompersData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSSIDcompersData);
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
    SSIDcompersData objectSSIDcompersData[] = new SSIDcompersData[vector.size()];
    vector.copyInto(objectSSIDcompersData);
    return(objectSSIDcompersData);
  }

  public static SSIDcompersData[] set()    throws ServletException {
    SSIDcompersData objectSSIDcompersData[] = new SSIDcompersData[1];
    objectSSIDcompersData[0] = new SSIDcompersData();
    objectSSIDcompersData[0].numMax = "";
    return objectSSIDcompersData;
  }
}
