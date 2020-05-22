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

public class SswhRptcSalesDetData implements FieldProvider {
static Logger log4j = Logger.getLogger(SswhRptcSalesDetData.class);
  private String InitRecordNumber="0";
  public String tipoIdentificador;
  public String identifCliente;
  public String codTipoComprobante;
  public String count;
  public String baseNoIva;
  public String baseIvaCero;
  public String baseIvaDoce;
  public String montoIva;
  public String montoRetIva;
  public String montoRetRenta;
  public String cPeriodId;
  public String posted;
  public String isactive;
  public String sswhRptcSalesdetId;
  public String parteRelacionada;
  public String montoice;
  public String tipoCliente;
  public String denoCli;
  public String tipoEm;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("tipo_identificador") || fieldName.equals("tipoIdentificador"))
      return tipoIdentificador;
    else if (fieldName.equalsIgnoreCase("identif_cliente") || fieldName.equals("identifCliente"))
      return identifCliente;
    else if (fieldName.equalsIgnoreCase("cod_tipo_comprobante") || fieldName.equals("codTipoComprobante"))
      return codTipoComprobante;
    else if (fieldName.equalsIgnoreCase("count"))
      return count;
    else if (fieldName.equalsIgnoreCase("base_no_iva") || fieldName.equals("baseNoIva"))
      return baseNoIva;
    else if (fieldName.equalsIgnoreCase("base_iva_cero") || fieldName.equals("baseIvaCero"))
      return baseIvaCero;
    else if (fieldName.equalsIgnoreCase("base_iva_doce") || fieldName.equals("baseIvaDoce"))
      return baseIvaDoce;
    else if (fieldName.equalsIgnoreCase("monto_iva") || fieldName.equals("montoIva"))
      return montoIva;
    else if (fieldName.equalsIgnoreCase("monto_ret_iva") || fieldName.equals("montoRetIva"))
      return montoRetIva;
    else if (fieldName.equalsIgnoreCase("monto_ret_renta") || fieldName.equals("montoRetRenta"))
      return montoRetRenta;
    else if (fieldName.equalsIgnoreCase("c_period_id") || fieldName.equals("cPeriodId"))
      return cPeriodId;
    else if (fieldName.equalsIgnoreCase("posted"))
      return posted;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("sswh_rptc_salesdet_id") || fieldName.equals("sswhRptcSalesdetId"))
      return sswhRptcSalesdetId;
    else if (fieldName.equalsIgnoreCase("parte_relacionada") || fieldName.equals("parteRelacionada"))
      return parteRelacionada;
    else if (fieldName.equalsIgnoreCase("montoice"))
      return montoice;
    else if (fieldName.equalsIgnoreCase("tipo_cliente") || fieldName.equals("tipoCliente"))
      return tipoCliente;
    else if (fieldName.equalsIgnoreCase("deno_cli") || fieldName.equals("denoCli"))
      return denoCli;
    else if (fieldName.equalsIgnoreCase("tipo_em") || fieldName.equals("tipoEm"))
      return tipoEm;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SswhRptcSalesDetData[] select(ConnectionProvider connectionProvider, String periodId)    throws ServletException {
    return select(connectionProvider, periodId, 0, 0);
  }

  public static SswhRptcSalesDetData[] select(ConnectionProvider connectionProvider, String periodId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "select tipo_identificador, identif_cliente, cod_tipo_comprobante, (count) AS count, " +
      " (base_no_iva) AS base_no_iva, (base_iva_cero) AS base_iva_cero, (base_iva_doce) AS base_iva_doce, " +
      " (monto_iva) AS monto_iva, (monto_ret_iva) AS monto_ret_iva, " +
      " (monto_ret_renta) AS monto_ret_renta, c_period_id," +
      "  posted,  isactive,sswh_rptc_salesdet_id, parte_relacionada, (montoice) AS montoice, tipo_contrib as tipo_cliente, deno_cli, tipo_em " +
      "     from sswh_rptc_salesdet" +
      "   where  process = ?  " +
      "    order by 1";

    ResultSet result;
    Vector<SswhRptcSalesDetData> vector = new Vector<SswhRptcSalesDetData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, periodId);

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
        SswhRptcSalesDetData objectSswhRptcSalesDetData = new SswhRptcSalesDetData();
        objectSswhRptcSalesDetData.tipoIdentificador = UtilSql.getValue(result, "tipo_identificador");
        objectSswhRptcSalesDetData.identifCliente = UtilSql.getValue(result, "identif_cliente");
        objectSswhRptcSalesDetData.codTipoComprobante = UtilSql.getValue(result, "cod_tipo_comprobante");
        objectSswhRptcSalesDetData.count = UtilSql.getValue(result, "count");
        objectSswhRptcSalesDetData.baseNoIva = UtilSql.getValue(result, "base_no_iva");
        objectSswhRptcSalesDetData.baseIvaCero = UtilSql.getValue(result, "base_iva_cero");
        objectSswhRptcSalesDetData.baseIvaDoce = UtilSql.getValue(result, "base_iva_doce");
        objectSswhRptcSalesDetData.montoIva = UtilSql.getValue(result, "monto_iva");
        objectSswhRptcSalesDetData.montoRetIva = UtilSql.getValue(result, "monto_ret_iva");
        objectSswhRptcSalesDetData.montoRetRenta = UtilSql.getValue(result, "monto_ret_renta");
        objectSswhRptcSalesDetData.cPeriodId = UtilSql.getValue(result, "c_period_id");
        objectSswhRptcSalesDetData.posted = UtilSql.getValue(result, "posted");
        objectSswhRptcSalesDetData.isactive = UtilSql.getValue(result, "isactive");
        objectSswhRptcSalesDetData.sswhRptcSalesdetId = UtilSql.getValue(result, "sswh_rptc_salesdet_id");
        objectSswhRptcSalesDetData.parteRelacionada = UtilSql.getValue(result, "parte_relacionada");
        objectSswhRptcSalesDetData.montoice = UtilSql.getValue(result, "montoice");
        objectSswhRptcSalesDetData.tipoCliente = UtilSql.getValue(result, "tipo_cliente");
        objectSswhRptcSalesDetData.denoCli = UtilSql.getValue(result, "deno_cli");
        objectSswhRptcSalesDetData.tipoEm = UtilSql.getValue(result, "tipo_em");
        objectSswhRptcSalesDetData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSswhRptcSalesDetData);
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
    SswhRptcSalesDetData objectSswhRptcSalesDetData[] = new SswhRptcSalesDetData[vector.size()];
    vector.copyInto(objectSswhRptcSalesDetData);
    return(objectSswhRptcSalesDetData);
  }
}
