//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_forms;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class ConceptInfoData implements FieldProvider {
static Logger log4j = Logger.getLogger(ConceptInfoData.class);
  private String InitRecordNumber="0";
  public String adClientId;
  public String adOrgId;
  public String conceptsubtype;
  public String concepttype;
  public String affectationtype;
  public String cDebit;
  public String cCredit;
  public String cClosing;
  public String isaccountpayroll;
  public String isliability;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("conceptsubtype"))
      return conceptsubtype;
    else if (fieldName.equalsIgnoreCase("concepttype"))
      return concepttype;
    else if (fieldName.equalsIgnoreCase("affectationtype"))
      return affectationtype;
    else if (fieldName.equalsIgnoreCase("c_debit") || fieldName.equals("cDebit"))
      return cDebit;
    else if (fieldName.equalsIgnoreCase("c_credit") || fieldName.equals("cCredit"))
      return cCredit;
    else if (fieldName.equalsIgnoreCase("c_closing") || fieldName.equals("cClosing"))
      return cClosing;
    else if (fieldName.equalsIgnoreCase("isaccountpayroll"))
      return isaccountpayroll;
    else if (fieldName.equalsIgnoreCase("isliability"))
      return isliability;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ConceptInfoData[] select(ConnectionProvider connectionProvider, String Concept)    throws ServletException {
    return select(connectionProvider, Concept, 0, 0);
  }

  public static ConceptInfoData[] select(ConnectionProvider connectionProvider, String Concept, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_CLIENT_ID, AD_ORG_ID, CONCEPTSUBTYPE, CONCEPTTYPE, AFFECTATIONTYPE, '' as C_Debit, '' as C_Credit, '' as C_Closing," +
      "        '' as IsAccountPayroll, '' as IsLiability" +
      "        FROM SSPR_CONCEPT" +
      "        WHERE SSPR_CONCEPT_ID=?";

    ResultSet result;
    Vector<ConceptInfoData> vector = new Vector<ConceptInfoData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Concept);

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
        ConceptInfoData objectConceptInfoData = new ConceptInfoData();
        objectConceptInfoData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectConceptInfoData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectConceptInfoData.conceptsubtype = UtilSql.getValue(result, "conceptsubtype");
        objectConceptInfoData.concepttype = UtilSql.getValue(result, "concepttype");
        objectConceptInfoData.affectationtype = UtilSql.getValue(result, "affectationtype");
        objectConceptInfoData.cDebit = UtilSql.getValue(result, "c_debit");
        objectConceptInfoData.cCredit = UtilSql.getValue(result, "c_credit");
        objectConceptInfoData.cClosing = UtilSql.getValue(result, "c_closing");
        objectConceptInfoData.isaccountpayroll = UtilSql.getValue(result, "isaccountpayroll");
        objectConceptInfoData.isliability = UtilSql.getValue(result, "isliability");
        objectConceptInfoData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectConceptInfoData);
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
    ConceptInfoData objectConceptInfoData[] = new ConceptInfoData[vector.size()];
    vector.copyInto(objectConceptInfoData);
    return(objectConceptInfoData);
  }

  public static ConceptInfoData[] selectConceptAcct(ConnectionProvider connectionProvider, String Concept, String AcctSchema, String AcctCategory)    throws ServletException {
    return selectConceptAcct(connectionProvider, Concept, AcctSchema, AcctCategory, 0, 0);
  }

  public static ConceptInfoData[] selectConceptAcct(ConnectionProvider connectionProvider, String Concept, String AcctSchema, String AcctCategory, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_Debit_Acct as C_Debit, C_Credit_Acct as C_Credit" +
      "        FROM SSPR_Concept_Acct" +
      "        WHERE SSPR_Concept_ID=?" +
      "        AND C_AcctSchema_ID=?" +
      "        AND SSPR_CATEGORY_ACCT_ID=?";

    ResultSet result;
    Vector<ConceptInfoData> vector = new Vector<ConceptInfoData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Concept);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AcctSchema);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AcctCategory);

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
        ConceptInfoData objectConceptInfoData = new ConceptInfoData();
        objectConceptInfoData.cDebit = UtilSql.getValue(result, "c_debit");
        objectConceptInfoData.cCredit = UtilSql.getValue(result, "c_credit");
        objectConceptInfoData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectConceptInfoData);
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
    ConceptInfoData objectConceptInfoData[] = new ConceptInfoData[vector.size()];
    vector.copyInto(objectConceptInfoData);
    return(objectConceptInfoData);
  }

  public static ConceptInfoData[] selectDefaultAcct(ConnectionProvider connectionProvider, String AcctSchema)    throws ServletException {
    return selectDefaultAcct(connectionProvider, AcctSchema, 0, 0);
  }

  public static ConceptInfoData[] selectDefaultAcct(ConnectionProvider connectionProvider, String AcctSchema, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT EM_SSPR_C_Debit_Acct as C_Debit, EM_SSPR_C_Credit_ACCT as C_Credit, EM_SSPR_C_Closing_ACCT as C_Closing" +
      "        FROM c_acctschema_default" +
      "        WHERE C_AcctSchema_ID=?";

    ResultSet result;
    Vector<ConceptInfoData> vector = new Vector<ConceptInfoData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AcctSchema);

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
        ConceptInfoData objectConceptInfoData = new ConceptInfoData();
        objectConceptInfoData.cDebit = UtilSql.getValue(result, "c_debit");
        objectConceptInfoData.cCredit = UtilSql.getValue(result, "c_credit");
        objectConceptInfoData.cClosing = UtilSql.getValue(result, "c_closing");
        objectConceptInfoData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectConceptInfoData);
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
    ConceptInfoData objectConceptInfoData[] = new ConceptInfoData[vector.size()];
    vector.copyInto(objectConceptInfoData);
    return(objectConceptInfoData);
  }

  public static ConceptInfoData[] selectConceptAcctDetails(ConnectionProvider connectionProvider, String Concept, String AcctSchema, String AcctCategory)    throws ServletException {
    return selectConceptAcctDetails(connectionProvider, Concept, AcctSchema, AcctCategory, 0, 0);
  }

  public static ConceptInfoData[] selectConceptAcctDetails(ConnectionProvider connectionProvider, String Concept, String AcctSchema, String AcctCategory, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT IsAccountPayroll,IsLiability" +
      "        FROM SSPR_CONCEPT_ACCT" +
      "        WHERE SSPR_CONCEPT_ID=?" +
      "        AND  C_ACCTSCHEMA_ID=?" +
      "        AND SSPR_CATEGORY_ACCT_ID=?";

    ResultSet result;
    Vector<ConceptInfoData> vector = new Vector<ConceptInfoData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Concept);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AcctSchema);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AcctCategory);

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
        ConceptInfoData objectConceptInfoData = new ConceptInfoData();
        objectConceptInfoData.isaccountpayroll = UtilSql.getValue(result, "isaccountpayroll");
        objectConceptInfoData.isliability = UtilSql.getValue(result, "isliability");
        objectConceptInfoData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectConceptInfoData);
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
    ConceptInfoData objectConceptInfoData[] = new ConceptInfoData[vector.size()];
    vector.copyInto(objectConceptInfoData);
    return(objectConceptInfoData);
  }
}
