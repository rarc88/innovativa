//Sqlc generated V1.O00-1
package com.sidesoft.localization.ecuador.withholdings.create_xml;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

public class SswhRptcSalesByStablData implements FieldProvider {
static Logger log4j = Logger.getLogger(SswhRptcSalesByStablData.class);
  private String InitRecordNumber="0";
  public String establecimiento;
  public String valor;
  public String compensacion;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("establecimiento"))
      return establecimiento;
    else if (fieldName.equalsIgnoreCase("valor"))
      return valor;
    else if (fieldName.equalsIgnoreCase("compensacion"))
      return compensacion;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SswhRptcSalesByStablData[] select(ConnectionProvider connectionProvider, String dateFrom, String dateTo, String OrgID, String OrgID2)    throws ServletException {
    return select(connectionProvider, dateFrom, dateTo, OrgID, OrgID2, 0, 0);
  }

  public static SswhRptcSalesByStablData[] select(ConnectionProvider connectionProvider, String dateFrom, String dateTo, String OrgID, String OrgID2, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select establecimiento,sum(valor) as valor,coalesce(sum(compensacion),0) as compensacion from sswh_rptc_salesbystab where (dateacct between ? and ?) and (ad_org_id = ? or ? is null)   group by establecimiento order by 1";

    ResultSet result;
    Vector<SswhRptcSalesByStablData> vector = new Vector<SswhRptcSalesByStablData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFrom);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateTo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, OrgID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, OrgID2);

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
        SswhRptcSalesByStablData objectSswhRptcSalesByStablData = new SswhRptcSalesByStablData();
        objectSswhRptcSalesByStablData.establecimiento = UtilSql.getValue(result, "establecimiento");
        objectSswhRptcSalesByStablData.valor = UtilSql.getValue(result, "valor");
        objectSswhRptcSalesByStablData.compensacion = UtilSql.getValue(result, "compensacion");
        objectSswhRptcSalesByStablData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSswhRptcSalesByStablData);
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
    SswhRptcSalesByStablData objectSswhRptcSalesByStablData[] = new SswhRptcSalesByStablData[vector.size()];
    vector.copyInto(objectSswhRptcSalesByStablData);
    return(objectSswhRptcSalesByStablData);
  }
}
