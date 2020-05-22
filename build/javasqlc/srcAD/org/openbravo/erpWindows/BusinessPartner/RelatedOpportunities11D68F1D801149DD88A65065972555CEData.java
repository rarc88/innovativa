//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.BusinessPartner;

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
class RelatedOpportunities11D68F1D801149DD88A65065972555CEData implements FieldProvider {
static Logger log4j = Logger.getLogger(RelatedOpportunities11D68F1D801149DD88A65065972555CEData.class);
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

  public static RelatedOpportunities11D68F1D801149DD88A65065972555CEData[] dummy(ConnectionProvider connectionProvider)    throws ServletException {
    return dummy(connectionProvider, 0, 0);
  }

  public static RelatedOpportunities11D68F1D801149DD88A65065972555CEData[] dummy(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT '' AS dummy from DUAL";

    ResultSet result;
    Vector<RelatedOpportunities11D68F1D801149DD88A65065972555CEData> vector = new Vector<RelatedOpportunities11D68F1D801149DD88A65065972555CEData>(0);
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
        RelatedOpportunities11D68F1D801149DD88A65065972555CEData objectRelatedOpportunities11D68F1D801149DD88A65065972555CEData = new RelatedOpportunities11D68F1D801149DD88A65065972555CEData();
        objectRelatedOpportunities11D68F1D801149DD88A65065972555CEData.dummy = UtilSql.getValue(result, "dummy");
        objectRelatedOpportunities11D68F1D801149DD88A65065972555CEData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRelatedOpportunities11D68F1D801149DD88A65065972555CEData);
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
    RelatedOpportunities11D68F1D801149DD88A65065972555CEData objectRelatedOpportunities11D68F1D801149DD88A65065972555CEData[] = new RelatedOpportunities11D68F1D801149DD88A65065972555CEData[vector.size()];
    vector.copyInto(objectRelatedOpportunities11D68F1D801149DD88A65065972555CEData);
    return(objectRelatedOpportunities11D68F1D801149DD88A65065972555CEData);
  }

/**
Select for auxiliar field
 */
  public static String selectActP5B560F0BDD824D5A9DCAFE653D04FEC3_subject(ConnectionProvider connectionProvider, String opcrm_opportunities_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT op.opportunity_name FROM opcrm_opportunities op WHERE op.opcrm_opportunities_id = ? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, opcrm_opportunities_id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "opportunity_name");
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
