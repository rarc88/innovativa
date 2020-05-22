//Sqlc generated V1.O00-1
package org.openbravo.idl.proc;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class BusinessPartnerLocationData implements FieldProvider {
static Logger log4j = Logger.getLogger(BusinessPartnerLocationData.class);
  private String InitRecordNumber="0";
  public String cBpartnerId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static BusinessPartnerLocationData[] select(ConnectionProvider connectionProvider, String cBpartnerId, String orgList, String city1, String city2, String address1a, String address1b, String address2a, String address2b, String postal1, String postal2, String country1, String country2, String region1, String region2)    throws ServletException {
    return select(connectionProvider, cBpartnerId, orgList, city1, city2, address1a, address1b, address2a, address2b, postal1, postal2, country1, country2, region1, region2, 0, 0);
  }

  public static BusinessPartnerLocationData[] select(ConnectionProvider connectionProvider, String cBpartnerId, String orgList, String city1, String city2, String address1a, String address1b, String address2a, String address2b, String postal1, String postal2, String country1, String country2, String region1, String region2, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT bp.c_bpartner_id" +
      "      FROM c_bpartner bp join c_bpartner_location bpl on (bp.c_bpartner_id = bpl.c_bpartner_id)" +
      "           join c_location loc on (bpl.c_location_id = loc.c_location_id)" +
      "           join c_country c on (loc.c_country_id = c.c_country_id)" +
      "           left join c_region reg on (loc.c_region_id = reg.c_region_id)" +
      "      WHERE bp.c_bpartner_id = ?" +
      "            AND loc.ad_org_id in (";
    strSql = strSql + ((orgList==null || orgList.equals(""))?"":orgList);
    strSql = strSql + 
      ")" +
      "            AND 1=1";
    strSql = strSql + ((city1==null || city1.equals(""))?"":"  AND loc.city= ? ");
    strSql = strSql + ((city2==null || city2.equals(""))?"":"  AND loc.city is null AND 1=? ");
    strSql = strSql + ((address1a==null || address1a.equals(""))?"":"  AND loc.address1 = ? ");
    strSql = strSql + ((address1b==null || address1b.equals(""))?"":"  AND loc.address1 is null AND 1=? ");
    strSql = strSql + ((address2a==null || address2a.equals(""))?"":"  AND loc.address2 = ? ");
    strSql = strSql + ((address2b==null || address2b.equals(""))?"":"  AND loc.address2 is null AND 1=? ");
    strSql = strSql + ((postal1==null || postal1.equals(""))?"":"  AND loc.postal = ? ");
    strSql = strSql + ((postal2==null || postal2.equals(""))?"":"  AND loc.postal is null AND 1=? ");
    strSql = strSql + ((country1==null || country1.equals(""))?"":"  AND c.name = ? ");
    strSql = strSql + ((country2==null || country2.equals(""))?"":"  AND c.name is null AND 1=? ");
    strSql = strSql + ((region1==null || region1.equals(""))?"":"  AND reg.name = ? ");
    strSql = strSql + ((region2==null || region2.equals(""))?"":"  AND reg.name is null AND 1=? ");

    ResultSet result;
    Vector<BusinessPartnerLocationData> vector = new Vector<BusinessPartnerLocationData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      if (orgList != null && !(orgList.equals(""))) {
        }
      if (city1 != null && !(city1.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, city1);
      }
      if (city2 != null && !(city2.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, city2);
      }
      if (address1a != null && !(address1a.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, address1a);
      }
      if (address1b != null && !(address1b.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, address1b);
      }
      if (address2a != null && !(address2a.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, address2a);
      }
      if (address2b != null && !(address2b.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, address2b);
      }
      if (postal1 != null && !(postal1.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, postal1);
      }
      if (postal2 != null && !(postal2.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, postal2);
      }
      if (country1 != null && !(country1.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, country1);
      }
      if (country2 != null && !(country2.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, country2);
      }
      if (region1 != null && !(region1.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, region1);
      }
      if (region2 != null && !(region2.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, region2);
      }

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
        BusinessPartnerLocationData objectBusinessPartnerLocationData = new BusinessPartnerLocationData();
        objectBusinessPartnerLocationData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectBusinessPartnerLocationData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectBusinessPartnerLocationData);
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
    BusinessPartnerLocationData objectBusinessPartnerLocationData[] = new BusinessPartnerLocationData[vector.size()];
    vector.copyInto(objectBusinessPartnerLocationData);
    return(objectBusinessPartnerLocationData);
  }
}
