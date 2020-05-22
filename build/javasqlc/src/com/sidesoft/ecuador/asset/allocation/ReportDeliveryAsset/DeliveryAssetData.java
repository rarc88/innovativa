//Sqlc generated V1.O00-1
package com.sidesoft.ecuador.asset.allocation.ReportDeliveryAsset;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class DeliveryAssetData implements FieldProvider {
static Logger log4j = Logger.getLogger(DeliveryAssetData.class);
  private String InitRecordNumber="0";
  public String organizationid;
  public String ssalAssetReturnId;
  public String dateMov;
  public String documentno;
  public String gerencia;
  public String unidad;
  public String custodiodesde;
  public String idcustodiasd;
  public String custodiohasta;
  public String idcustodiash;
  public String value;
  public String emSsalBarCode;
  public String name;
  public String emSsalSeries;
  public String description;
  public String estado;
  public String observaciones;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("organizationid"))
      return organizationid;
    else if (fieldName.equalsIgnoreCase("ssal_asset_return_id") || fieldName.equals("ssalAssetReturnId"))
      return ssalAssetReturnId;
    else if (fieldName.equalsIgnoreCase("date_mov") || fieldName.equals("dateMov"))
      return dateMov;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("gerencia"))
      return gerencia;
    else if (fieldName.equalsIgnoreCase("unidad"))
      return unidad;
    else if (fieldName.equalsIgnoreCase("custodiodesde"))
      return custodiodesde;
    else if (fieldName.equalsIgnoreCase("idcustodiasd"))
      return idcustodiasd;
    else if (fieldName.equalsIgnoreCase("custodiohasta"))
      return custodiohasta;
    else if (fieldName.equalsIgnoreCase("idcustodiash"))
      return idcustodiash;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("em_ssal_bar_code") || fieldName.equals("emSsalBarCode"))
      return emSsalBarCode;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("em_ssal_series") || fieldName.equals("emSsalSeries"))
      return emSsalSeries;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("estado"))
      return estado;
    else if (fieldName.equalsIgnoreCase("observaciones"))
      return observaciones;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DeliveryAssetData[] select(ConnectionProvider connectionProvider, String reportaptitude_id)    throws ServletException {
    return select(connectionProvider, reportaptitude_id, 0, 0);
  }

  public static DeliveryAssetData[] select(ConnectionProvider connectionProvider, String reportaptitude_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "select a.ad_org_id AS organizationid" +
      ",a.ssal_asset_return_id" +
      ",to_char(a.date_mov,'dd-MM-yyyy') as date_mov" +
      ",a.documentno" +
      ",h.name as gerencia" +
      ",g.name as unidad" +
      ",e.name as custodiodesde" +
      ",e.taxid as idcustodiasd" +
      ",f.name as custodiohasta" +
      ",f.taxid as idcustodiash" +
      ",d.value" +
      ",d.em_ssal_bar_code" +
      ",d.name" +
      ",d.em_ssal_series" +
      ",d.description" +
      ",i.name as estado" +
      ",a.description as observaciones from ssal_asset_return a left join ssal_asset_returnline b on a.ssal_asset_return_id = b.ssal_asset_return_id" +
      "  left join ssal_appl_active c on b.ssal_appl_active_id = c.ssal_appl_active_id" +
      "  left join a_asset d on c.a_asset_id = d.a_asset_id" +
      "  left join ssal_unit g on b.ssal_unit_id = g.ssal_unit_id" +
      "  left join c_costcenter h on b.c_costcenter_id = h.c_costcenter_id" +
      "  left join ssal_state_asset i on d.em_ssal_state_asset_id = i.ssal_state_asset_id" +
      "  left join c_bpartner e on a.c_bpartner_id = e.c_bpartner_id" +
      "  left join c_bpartner f on a.c_custodian_id = f.c_bpartner_id where b.tranfer='Y' and a.ssal_asset_return_ID = (?)";

    ResultSet result;
    Vector<DeliveryAssetData> vector = new Vector<DeliveryAssetData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, reportaptitude_id);

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
        DeliveryAssetData objectDeliveryAssetData = new DeliveryAssetData();
        objectDeliveryAssetData.organizationid = UtilSql.getValue(result, "organizationid");
        objectDeliveryAssetData.ssalAssetReturnId = UtilSql.getValue(result, "ssal_asset_return_id");
        objectDeliveryAssetData.dateMov = UtilSql.getValue(result, "date_mov");
        objectDeliveryAssetData.documentno = UtilSql.getValue(result, "documentno");
        objectDeliveryAssetData.gerencia = UtilSql.getValue(result, "gerencia");
        objectDeliveryAssetData.unidad = UtilSql.getValue(result, "unidad");
        objectDeliveryAssetData.custodiodesde = UtilSql.getValue(result, "custodiodesde");
        objectDeliveryAssetData.idcustodiasd = UtilSql.getValue(result, "idcustodiasd");
        objectDeliveryAssetData.custodiohasta = UtilSql.getValue(result, "custodiohasta");
        objectDeliveryAssetData.idcustodiash = UtilSql.getValue(result, "idcustodiash");
        objectDeliveryAssetData.value = UtilSql.getValue(result, "value");
        objectDeliveryAssetData.emSsalBarCode = UtilSql.getValue(result, "em_ssal_bar_code");
        objectDeliveryAssetData.name = UtilSql.getValue(result, "name");
        objectDeliveryAssetData.emSsalSeries = UtilSql.getValue(result, "em_ssal_series");
        objectDeliveryAssetData.description = UtilSql.getValue(result, "description");
        objectDeliveryAssetData.estado = UtilSql.getValue(result, "estado");
        objectDeliveryAssetData.observaciones = UtilSql.getValue(result, "observaciones");
        objectDeliveryAssetData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDeliveryAssetData);
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
    DeliveryAssetData objectDeliveryAssetData[] = new DeliveryAssetData[vector.size()];
    vector.copyInto(objectDeliveryAssetData);
    return(objectDeliveryAssetData);
  }

  public static DeliveryAssetData[] set()    throws ServletException {
    DeliveryAssetData objectDeliveryAssetData[] = new DeliveryAssetData[1];
    objectDeliveryAssetData[0] = new DeliveryAssetData();
    objectDeliveryAssetData[0].organizationid = "";
    objectDeliveryAssetData[0].ssalAssetReturnId = "";
    objectDeliveryAssetData[0].dateMov = "";
    objectDeliveryAssetData[0].documentno = "";
    objectDeliveryAssetData[0].gerencia = "";
    objectDeliveryAssetData[0].unidad = "";
    objectDeliveryAssetData[0].custodiodesde = "";
    objectDeliveryAssetData[0].idcustodiasd = "";
    objectDeliveryAssetData[0].custodiohasta = "";
    objectDeliveryAssetData[0].idcustodiash = "";
    objectDeliveryAssetData[0].value = "";
    objectDeliveryAssetData[0].emSsalBarCode = "";
    objectDeliveryAssetData[0].name = "";
    objectDeliveryAssetData[0].emSsalSeries = "";
    objectDeliveryAssetData[0].description = "";
    objectDeliveryAssetData[0].estado = "";
    objectDeliveryAssetData[0].observaciones = "";
    return objectDeliveryAssetData;
  }
}
