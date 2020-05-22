//Sqlc generated V1.O00-1
package com.sidesoft.ecuador.asset.allocation.ReportActReception;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class ActReceptionData implements FieldProvider {
static Logger log4j = Logger.getLogger(ActReceptionData.class);
  private String InitRecordNumber="0";
  public String org;
  public String fechaemision;
  public String custodiod;
  public String custodioh;
  public String codigoActivo;
  public String activo;
  public String valor;
  public String description;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("org"))
      return org;
    else if (fieldName.equalsIgnoreCase("fechaemision"))
      return fechaemision;
    else if (fieldName.equalsIgnoreCase("custodiod"))
      return custodiod;
    else if (fieldName.equalsIgnoreCase("custodioh"))
      return custodioh;
    else if (fieldName.equalsIgnoreCase("codigo_activo") || fieldName.equals("codigoActivo"))
      return codigoActivo;
    else if (fieldName.equalsIgnoreCase("activo"))
      return activo;
    else if (fieldName.equalsIgnoreCase("valor"))
      return valor;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ActReceptionData[] select(ConnectionProvider connectionProvider, String ssal_asset_return_id)    throws ServletException {
    return select(connectionProvider, ssal_asset_return_id, 0, 0);
  }

  public static ActReceptionData[] select(ConnectionProvider connectionProvider, String ssal_asset_return_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "select c.name as org," +
      "to_date(now()) as fechaemision," +
      "d.name as custodiod," +
      "e.name as custodioh," +
      "g.value as codigo_activo," +
      "g.name as activo," +
      "g.assetvalueamt as valor," +
      "g.description from ssal_asset_return a left join ssal_asset_returnline b on a.ssal_asset_return_id = b.ssal_asset_return_id 	" +
      "  left join ad_org c on a.ad_org_id = c.ad_org_id" +
      "  left join c_bpartner d on a.c_bpartner_id = d.c_bpartner_id" +
      "  left join c_bpartner e on a.c_custodian_id = e.c_bpartner_id" +
      "  left join ssal_appl_active f on b.ssal_appl_active_id = f.ssal_appl_active_id" +
      "  left join a_asset g on  f.a_asset_id = g.a_asset_id 	" +
      "  where a.ssal_asset_return_id in (?)";

    ResultSet result;
    Vector<ActReceptionData> vector = new Vector<ActReceptionData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ssal_asset_return_id);

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
        ActReceptionData objectActReceptionData = new ActReceptionData();
        objectActReceptionData.org = UtilSql.getValue(result, "org");
        objectActReceptionData.fechaemision = UtilSql.getDateValue(result, "fechaemision", "dd-MM-yyyy");
        objectActReceptionData.custodiod = UtilSql.getValue(result, "custodiod");
        objectActReceptionData.custodioh = UtilSql.getValue(result, "custodioh");
        objectActReceptionData.codigoActivo = UtilSql.getValue(result, "codigo_activo");
        objectActReceptionData.activo = UtilSql.getValue(result, "activo");
        objectActReceptionData.valor = UtilSql.getValue(result, "valor");
        objectActReceptionData.description = UtilSql.getValue(result, "description");
        objectActReceptionData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectActReceptionData);
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
    ActReceptionData objectActReceptionData[] = new ActReceptionData[vector.size()];
    vector.copyInto(objectActReceptionData);
    return(objectActReceptionData);
  }

  public static ActReceptionData[] set()    throws ServletException {
    ActReceptionData objectActReceptionData[] = new ActReceptionData[1];
    objectActReceptionData[0] = new ActReceptionData();
    objectActReceptionData[0].org = "";
    objectActReceptionData[0].fechaemision = "";
    objectActReceptionData[0].custodiod = "";
    objectActReceptionData[0].custodioh = "";
    objectActReceptionData[0].codigoActivo = "";
    objectActReceptionData[0].activo = "";
    objectActReceptionData[0].valor = "";
    objectActReceptionData[0].description = "";
    return objectActReceptionData;
  }
}
