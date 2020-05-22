//Sqlc generated V1.O00-1
package com.sidesoft.ecuador.asset.move.accounting;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

public class DocAlienateAcctData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocAlienateAcctData.class);
  private String InitRecordNumber="0";
  public String aAssetId;
  public String assDepreciationAcct;
  public String assAccumdepreciationAcct;
  public String assSalesAcct;
  public String assHistoriccostAcct;
  public String assResultalienateAcct;
  public String grpDepreciationAcct;
  public String grpAccumdepreciationAcct;
  public String grpSalesAcct;
  public String grpHistoriccostAcct;
  public String grpResultalienateAcct;
  public String nameassets;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("ass_depreciation_acct") || fieldName.equals("assDepreciationAcct"))
      return assDepreciationAcct;
    else if (fieldName.equalsIgnoreCase("ass_accumdepreciation_acct") || fieldName.equals("assAccumdepreciationAcct"))
      return assAccumdepreciationAcct;
    else if (fieldName.equalsIgnoreCase("ass_sales_acct") || fieldName.equals("assSalesAcct"))
      return assSalesAcct;
    else if (fieldName.equalsIgnoreCase("ass_historiccost_acct") || fieldName.equals("assHistoriccostAcct"))
      return assHistoriccostAcct;
    else if (fieldName.equalsIgnoreCase("ass_resultalienate_acct") || fieldName.equals("assResultalienateAcct"))
      return assResultalienateAcct;
    else if (fieldName.equalsIgnoreCase("grp_depreciation_acct") || fieldName.equals("grpDepreciationAcct"))
      return grpDepreciationAcct;
    else if (fieldName.equalsIgnoreCase("grp_accumdepreciation_acct") || fieldName.equals("grpAccumdepreciationAcct"))
      return grpAccumdepreciationAcct;
    else if (fieldName.equalsIgnoreCase("grp_sales_acct") || fieldName.equals("grpSalesAcct"))
      return grpSalesAcct;
    else if (fieldName.equalsIgnoreCase("grp_historiccost_acct") || fieldName.equals("grpHistoriccostAcct"))
      return grpHistoriccostAcct;
    else if (fieldName.equalsIgnoreCase("grp_resultalienate_acct") || fieldName.equals("grpResultalienateAcct"))
      return grpResultalienateAcct;
    else if (fieldName.equalsIgnoreCase("nameassets"))
      return nameassets;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocAlienateAcctData[] selectAcct(ConnectionProvider connectionProvider, String A_ASSET_ID, String C_ACCTSCHEMA_ID)    throws ServletException {
    return selectAcct(connectionProvider, A_ASSET_ID, C_ACCTSCHEMA_ID, 0, 0);
  }

  public static DocAlienateAcctData[] selectAcct(ConnectionProvider connectionProvider, String A_ASSET_ID, String C_ACCTSCHEMA_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "     	SELECT 	C.A_ASSET_ID ,D.A_DEPRECIATION_ACCT AS ASS_DEPRECIATION_ACCT, D.A_ACCUMDEPRECIATION_ACCT AS ASS_ACCUMDEPRECIATION_ACCT, D.EM_SSAM_SALES_ACCT AS ASS_SALES_ACCT, " +
      "			D.EM_SSAM_HISTORICCOST_ACCT AS ASS_HISTORICCOST_ACCT, D.EM_SSAM_RESULTALIENATE_ACCT AS ASS_RESULTALIENATE_ACCT," +
      "			E.A_DEPRECIATION_ACCT AS GRP_DEPRECIATION_ACCT, E.A_ACCUMDEPRECIATION_ACCT AS GRP_ACCUMDEPRECIATION_ACCT, E.EM_SSAM_SALES_ACCT AS GRP_SALES_ACCT, " +
      "			E.EM_SSAM_HISTORICCOST_ACCT AS GRP_HISTORICCOST_ACCT, E.EM_SSAM_RESULTALIENATE_ACCT AS GRP_RESULTALIENATE_ACCT," +
      "			C.NAME AS NAMEASSETS" +
      "		FROM A_ASSET C " +
      "		LEFT JOIN A_ASSET_ACCT D ON D.A_ASSET_ID = C.A_ASSET_ID" +
      "		LEFT JOIN A_ASSET_GROUP_ACCT E ON E.A_ASSET_GROUP_ID = C.A_ASSET_GROUP_ID AND E.C_ACCTSCHEMA_ID = D.C_ACCTSCHEMA_ID" +
      "		WHERE C.A_ASSET_ID = ?" +
      "		AND D.C_ACCTSCHEMA_ID = ? ";

    ResultSet result;
    Vector<DocAlienateAcctData> vector = new Vector<DocAlienateAcctData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, A_ASSET_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_ACCTSCHEMA_ID);

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
        DocAlienateAcctData objectDocAlienateAcctData = new DocAlienateAcctData();
        objectDocAlienateAcctData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectDocAlienateAcctData.assDepreciationAcct = UtilSql.getValue(result, "ass_depreciation_acct");
        objectDocAlienateAcctData.assAccumdepreciationAcct = UtilSql.getValue(result, "ass_accumdepreciation_acct");
        objectDocAlienateAcctData.assSalesAcct = UtilSql.getValue(result, "ass_sales_acct");
        objectDocAlienateAcctData.assHistoriccostAcct = UtilSql.getValue(result, "ass_historiccost_acct");
        objectDocAlienateAcctData.assResultalienateAcct = UtilSql.getValue(result, "ass_resultalienate_acct");
        objectDocAlienateAcctData.grpDepreciationAcct = UtilSql.getValue(result, "grp_depreciation_acct");
        objectDocAlienateAcctData.grpAccumdepreciationAcct = UtilSql.getValue(result, "grp_accumdepreciation_acct");
        objectDocAlienateAcctData.grpSalesAcct = UtilSql.getValue(result, "grp_sales_acct");
        objectDocAlienateAcctData.grpHistoriccostAcct = UtilSql.getValue(result, "grp_historiccost_acct");
        objectDocAlienateAcctData.grpResultalienateAcct = UtilSql.getValue(result, "grp_resultalienate_acct");
        objectDocAlienateAcctData.nameassets = UtilSql.getValue(result, "nameassets");
        objectDocAlienateAcctData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocAlienateAcctData);
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
    DocAlienateAcctData objectDocAlienateAcctData[] = new DocAlienateAcctData[vector.size()];
    vector.copyInto(objectDocAlienateAcctData);
    return(objectDocAlienateAcctData);
  }

  public static int updateStatusAsset(ConnectionProvider connectionProvider, String STATUS, String A_ASSET_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE A_ASSET " +
      "        SET EM_SSAM_STATUS = ?" +
      "        WHERE A_ASSET_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, STATUS);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, A_ASSET_ID);

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
}
