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

class DocLineAlienateData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocLineAlienateData.class);
  private String InitRecordNumber="0";
  public String ssamAlienatelineId;
  public String adOrgId;
  public String line;
  public String description;
  public String cCurrencyId;
  public String cCostcenterId;
  public String user1Id;
  public String user2Id;
  public String aAssetId;
  public String aAssetGroupId;
  public String typereason;
  public String assetvalueamt;
  public String amortizationvalue;
  public String netvalue;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ssam_alienateline_id") || fieldName.equals("ssamAlienatelineId"))
      return ssamAlienatelineId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_costcenter_id") || fieldName.equals("cCostcenterId"))
      return cCostcenterId;
    else if (fieldName.equalsIgnoreCase("user1_id") || fieldName.equals("user1Id"))
      return user1Id;
    else if (fieldName.equalsIgnoreCase("user2_id") || fieldName.equals("user2Id"))
      return user2Id;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("a_asset_group_id") || fieldName.equals("aAssetGroupId"))
      return aAssetGroupId;
    else if (fieldName.equalsIgnoreCase("typereason"))
      return typereason;
    else if (fieldName.equalsIgnoreCase("assetvalueamt"))
      return assetvalueamt;
    else if (fieldName.equalsIgnoreCase("amortizationvalue"))
      return amortizationvalue;
    else if (fieldName.equalsIgnoreCase("netvalue"))
      return netvalue;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocLineAlienateData[] select(ConnectionProvider connectionProvider, String SSAM_ALIENATE_ID)    throws ServletException {
    return select(connectionProvider, SSAM_ALIENATE_ID, 0, 0);
  }

  public static DocLineAlienateData[] select(ConnectionProvider connectionProvider, String SSAM_ALIENATE_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT B.SSAM_ALIENATELINE_ID, A.AD_ORG_ID, B.LINE, A.DESCRIPTION ||' - '||C.NAME AS DESCRIPTION, C.C_CURRENCY_ID, C.C_COSTCENTER_ID," +
      "			C.USER1_ID, C.USER2_ID, C.A_ASSET_ID, C.A_ASSET_GROUP_ID, A.TYPEREASON," +
      "			B.ASSETVALUEAMT, B.AMORTIZATIONVALUE, B.NETVALUE" +
      "		FROM SSAM_ALIENATE A" +
      "		LEFT JOIN SSAM_ALIENATELINE B ON B.SSAM_ALIENATE_ID = A.SSAM_ALIENATE_ID" +
      "		LEFT JOIN A_ASSET C ON C.A_ASSET_ID = B.A_ASSET_ID" +
      "		WHERE A.SSAM_ALIENATE_ID = ?" +
      "		AND B.STATUS = 'Y'" +
      "		AND C.EM_SSAM_ASSETTYPE <> 'AC'";

    ResultSet result;
    Vector<DocLineAlienateData> vector = new Vector<DocLineAlienateData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, SSAM_ALIENATE_ID);

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
        DocLineAlienateData objectDocLineAlienateData = new DocLineAlienateData();
        objectDocLineAlienateData.ssamAlienatelineId = UtilSql.getValue(result, "ssam_alienateline_id");
        objectDocLineAlienateData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocLineAlienateData.line = UtilSql.getValue(result, "line");
        objectDocLineAlienateData.description = UtilSql.getValue(result, "description");
        objectDocLineAlienateData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectDocLineAlienateData.cCostcenterId = UtilSql.getValue(result, "c_costcenter_id");
        objectDocLineAlienateData.user1Id = UtilSql.getValue(result, "user1_id");
        objectDocLineAlienateData.user2Id = UtilSql.getValue(result, "user2_id");
        objectDocLineAlienateData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectDocLineAlienateData.aAssetGroupId = UtilSql.getValue(result, "a_asset_group_id");
        objectDocLineAlienateData.typereason = UtilSql.getValue(result, "typereason");
        objectDocLineAlienateData.assetvalueamt = UtilSql.getValue(result, "assetvalueamt");
        objectDocLineAlienateData.amortizationvalue = UtilSql.getValue(result, "amortizationvalue");
        objectDocLineAlienateData.netvalue = UtilSql.getValue(result, "netvalue");
        objectDocLineAlienateData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocLineAlienateData);
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
    DocLineAlienateData objectDocLineAlienateData[] = new DocLineAlienateData[vector.size()];
    vector.copyInto(objectDocLineAlienateData);
    return(objectDocLineAlienateData);
  }
}
