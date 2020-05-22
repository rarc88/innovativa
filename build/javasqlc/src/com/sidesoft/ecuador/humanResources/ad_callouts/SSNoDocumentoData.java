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

public class SSNoDocumentoData implements FieldProvider {
static Logger log4j = Logger.getLogger(SSNoDocumentoData.class);
  private String InitRecordNumber="0";
  public String ci;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ci"))
      return ci;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SSNoDocumentoData[] select(ConnectionProvider connectionProvider, String sshrPartnerId)    throws ServletException {
    return select(connectionProvider, sshrPartnerId, 0, 0);
  }

  public static SSNoDocumentoData[] select(ConnectionProvider connectionProvider, String sshrPartnerId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		select value as ci" +
      "		from c_bpartner" +
      "		where c_bpartner_id = ?	";

    ResultSet result;
    Vector<SSNoDocumentoData> vector = new Vector<SSNoDocumentoData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sshrPartnerId);

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
        SSNoDocumentoData objectSSNoDocumentoData = new SSNoDocumentoData();
        objectSSNoDocumentoData.ci = UtilSql.getValue(result, "ci");
        objectSSNoDocumentoData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSSNoDocumentoData);
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
    SSNoDocumentoData objectSSNoDocumentoData[] = new SSNoDocumentoData[vector.size()];
    vector.copyInto(objectSSNoDocumentoData);
    return(objectSSNoDocumentoData);
  }
}
