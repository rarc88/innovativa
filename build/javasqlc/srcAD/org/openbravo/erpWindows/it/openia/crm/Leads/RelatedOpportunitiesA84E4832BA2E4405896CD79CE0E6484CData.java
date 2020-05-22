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
class RelatedOpportunitiesA84E4832BA2E4405896CD79CE0E6484CData implements FieldProvider {
static Logger log4j = Logger.getLogger(RelatedOpportunitiesA84E4832BA2E4405896CD79CE0E6484CData.class);
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

  public static RelatedOpportunitiesA84E4832BA2E4405896CD79CE0E6484CData[] dummy(ConnectionProvider connectionProvider)    throws ServletException {
    return dummy(connectionProvider, 0, 0);
  }

  public static RelatedOpportunitiesA84E4832BA2E4405896CD79CE0E6484CData[] dummy(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT '' AS dummy from DUAL";

    ResultSet result;
    Vector<RelatedOpportunitiesA84E4832BA2E4405896CD79CE0E6484CData> vector = new Vector<RelatedOpportunitiesA84E4832BA2E4405896CD79CE0E6484CData>(0);
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
        RelatedOpportunitiesA84E4832BA2E4405896CD79CE0E6484CData objectRelatedOpportunitiesA84E4832BA2E4405896CD79CE0E6484CData = new RelatedOpportunitiesA84E4832BA2E4405896CD79CE0E6484CData();
        objectRelatedOpportunitiesA84E4832BA2E4405896CD79CE0E6484CData.dummy = UtilSql.getValue(result, "dummy");
        objectRelatedOpportunitiesA84E4832BA2E4405896CD79CE0E6484CData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRelatedOpportunitiesA84E4832BA2E4405896CD79CE0E6484CData);
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
    RelatedOpportunitiesA84E4832BA2E4405896CD79CE0E6484CData objectRelatedOpportunitiesA84E4832BA2E4405896CD79CE0E6484CData[] = new RelatedOpportunitiesA84E4832BA2E4405896CD79CE0E6484CData[vector.size()];
    vector.copyInto(objectRelatedOpportunitiesA84E4832BA2E4405896CD79CE0E6484CData);
    return(objectRelatedOpportunitiesA84E4832BA2E4405896CD79CE0E6484CData);
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
