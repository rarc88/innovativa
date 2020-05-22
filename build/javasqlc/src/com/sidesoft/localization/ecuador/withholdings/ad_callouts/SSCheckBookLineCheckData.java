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

public class SSCheckBookLineCheckData implements FieldProvider {
static Logger log4j = Logger.getLogger(SSCheckBookLineCheckData.class);
  private String InitRecordNumber="0";
  public String nrolinea;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("nrolinea"))
      return nrolinea;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SSCheckBookLineCheckData[] select(ConnectionProvider connectionProvider, String CheckbookId)    throws ServletException {
    return select(connectionProvider, CheckbookId, 0, 0);
  }

  public static SSCheckBookLineCheckData[] select(ConnectionProvider connectionProvider, String CheckbookId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		SELECT MIN(linecheck) AS nrolinea " +
      "        FROM  sswh_checkbookline" +
      "        WHERE sswh_checkbook_id = ? AND doc_line_status = 'P'";

    ResultSet result;
    Vector<SSCheckBookLineCheckData> vector = new Vector<SSCheckBookLineCheckData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, CheckbookId);

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
        SSCheckBookLineCheckData objectSSCheckBookLineCheckData = new SSCheckBookLineCheckData();
        objectSSCheckBookLineCheckData.nrolinea = UtilSql.getValue(result, "nrolinea");
        objectSSCheckBookLineCheckData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSSCheckBookLineCheckData);
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
    SSCheckBookLineCheckData objectSSCheckBookLineCheckData[] = new SSCheckBookLineCheckData[vector.size()];
    vector.copyInto(objectSSCheckBookLineCheckData);
    return(objectSSCheckBookLineCheckData);
  }
}
