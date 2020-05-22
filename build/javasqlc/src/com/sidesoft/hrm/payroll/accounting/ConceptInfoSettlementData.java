//Sqlc generated V1.O00-1
package com.sidesoft.hrm.payroll.accounting;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class ConceptInfoSettlementData implements FieldProvider {
static Logger log4j = Logger.getLogger(ConceptInfoSettlementData.class);
  private String InitRecordNumber="0";
  public String conceptsubtype;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("conceptsubtype"))
      return conceptsubtype;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ConceptInfoSettlementData[] selectConceptType(ConnectionProvider connectionProvider, String sspr_concept_id)    throws ServletException {
    return selectConceptType(connectionProvider, sspr_concept_id, 0, 0);
  }

  public static ConceptInfoSettlementData[] selectConceptType(ConnectionProvider connectionProvider, String sspr_concept_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT CONCEPTSUBTYPE " +
      "      FROM SSPR_CONCEPT" +
      "      WHERE SSPR_CONCEPT_ID =?";

    ResultSet result;
    Vector<ConceptInfoSettlementData> vector = new Vector<ConceptInfoSettlementData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sspr_concept_id);

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
        ConceptInfoSettlementData objectConceptInfoSettlementData = new ConceptInfoSettlementData();
        objectConceptInfoSettlementData.conceptsubtype = UtilSql.getValue(result, "conceptsubtype");
        objectConceptInfoSettlementData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectConceptInfoSettlementData);
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
    ConceptInfoSettlementData objectConceptInfoSettlementData[] = new ConceptInfoSettlementData[vector.size()];
    vector.copyInto(objectConceptInfoSettlementData);
    return(objectConceptInfoSettlementData);
  }
}
