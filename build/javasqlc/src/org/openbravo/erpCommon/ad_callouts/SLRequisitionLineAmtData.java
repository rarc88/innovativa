//Sqlc generated V1.O00-1
package org.openbravo.erpCommon.ad_callouts;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class SLRequisitionLineAmtData implements FieldProvider {
static Logger log4j = Logger.getLogger(SLRequisitionLineAmtData.class);
  private String InitRecordNumber="0";
  public String stdprecision;
  public String priceprecision;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("stdprecision"))
      return stdprecision;
    else if (fieldName.equalsIgnoreCase("priceprecision"))
      return priceprecision;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SLRequisitionLineAmtData[] select(ConnectionProvider connectionProvider, String mRequisitionId)    throws ServletException {
    return select(connectionProvider, mRequisitionId, 0, 0);
  }

  public static SLRequisitionLineAmtData[] select(ConnectionProvider connectionProvider, String mRequisitionId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_Currency.StdPrecision, C_Currency.PricePrecision" +
      "      FROM M_Requisition, M_PriceList, C_Currency " +
      "      WHERE M_Requisition.M_PriceList_ID = M_PriceList.M_PriceList_ID" +
      "      AND M_PriceList.C_Currency_ID = C_Currency.C_Currency_ID" +
      "      AND M_Requisition.M_Requisition_ID = ?";

    ResultSet result;
    Vector<SLRequisitionLineAmtData> vector = new Vector<SLRequisitionLineAmtData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mRequisitionId);

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
        SLRequisitionLineAmtData objectSLRequisitionLineAmtData = new SLRequisitionLineAmtData();
        objectSLRequisitionLineAmtData.stdprecision = UtilSql.getValue(result, "stdprecision");
        objectSLRequisitionLineAmtData.priceprecision = UtilSql.getValue(result, "priceprecision");
        objectSLRequisitionLineAmtData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSLRequisitionLineAmtData);
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
    SLRequisitionLineAmtData objectSLRequisitionLineAmtData[] = new SLRequisitionLineAmtData[vector.size()];
    vector.copyInto(objectSLRequisitionLineAmtData);
    return(objectSLRequisitionLineAmtData);
  }

  public static SLRequisitionLineAmtData[] selectPriceListLine(ConnectionProvider connectionProvider, String mPriceListId)    throws ServletException {
    return selectPriceListLine(connectionProvider, mPriceListId, 0, 0);
  }

  public static SLRequisitionLineAmtData[] selectPriceListLine(ConnectionProvider connectionProvider, String mPriceListId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT C_Currency.StdPrecision, C_Currency.PricePrecision" +
      "      FROM M_PriceList, C_Currency " +
      "      WHERE M_PriceList.C_Currency_ID = C_Currency.C_Currency_ID" +
      "      AND M_PriceList.M_Pricelist_ID = ?";

    ResultSet result;
    Vector<SLRequisitionLineAmtData> vector = new Vector<SLRequisitionLineAmtData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPriceListId);

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
        SLRequisitionLineAmtData objectSLRequisitionLineAmtData = new SLRequisitionLineAmtData();
        objectSLRequisitionLineAmtData.stdprecision = UtilSql.getValue(result, "stdprecision");
        objectSLRequisitionLineAmtData.priceprecision = UtilSql.getValue(result, "priceprecision");
        objectSLRequisitionLineAmtData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSLRequisitionLineAmtData);
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
    SLRequisitionLineAmtData objectSLRequisitionLineAmtData[] = new SLRequisitionLineAmtData[vector.size()];
    vector.copyInto(objectSLRequisitionLineAmtData);
    return(objectSLRequisitionLineAmtData);
  }
}
