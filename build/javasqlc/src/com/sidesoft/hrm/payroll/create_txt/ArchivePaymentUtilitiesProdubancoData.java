//Sqlc generated V1.O00-1
package com.sidesoft.hrm.payroll.create_txt;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

public class ArchivePaymentUtilitiesProdubancoData implements FieldProvider {
static Logger log4j = Logger.getLogger(ArchivePaymentUtilitiesProdubancoData.class);
  private String InitRecordNumber="0";
  public String pa;
  public String cuentacompania;
  public String comprobantepago;
  public String contrapartida;
  public String usd;
  public String valor;
  public String formapago;
  public String codigobanco;
  public String tipocta;
  public String nocuenta;
  public String tipoidempleado;
  public String cedula;
  public String nombreempleado;
  public String direccion;
  public String ciudad;
  public String telefono;
  public String localidad;
  public String referencia;
  public String referenciaadicional;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("pa"))
      return pa;
    else if (fieldName.equalsIgnoreCase("cuentacompania"))
      return cuentacompania;
    else if (fieldName.equalsIgnoreCase("comprobantepago"))
      return comprobantepago;
    else if (fieldName.equalsIgnoreCase("contrapartida"))
      return contrapartida;
    else if (fieldName.equalsIgnoreCase("usd"))
      return usd;
    else if (fieldName.equalsIgnoreCase("valor"))
      return valor;
    else if (fieldName.equalsIgnoreCase("formapago"))
      return formapago;
    else if (fieldName.equalsIgnoreCase("codigobanco"))
      return codigobanco;
    else if (fieldName.equalsIgnoreCase("tipocta"))
      return tipocta;
    else if (fieldName.equalsIgnoreCase("nocuenta"))
      return nocuenta;
    else if (fieldName.equalsIgnoreCase("tipoidempleado"))
      return tipoidempleado;
    else if (fieldName.equalsIgnoreCase("cedula"))
      return cedula;
    else if (fieldName.equalsIgnoreCase("nombreempleado"))
      return nombreempleado;
    else if (fieldName.equalsIgnoreCase("direccion"))
      return direccion;
    else if (fieldName.equalsIgnoreCase("ciudad"))
      return ciudad;
    else if (fieldName.equalsIgnoreCase("telefono"))
      return telefono;
    else if (fieldName.equalsIgnoreCase("localidad"))
      return localidad;
    else if (fieldName.equalsIgnoreCase("referencia"))
      return referencia;
    else if (fieldName.equalsIgnoreCase("referenciaadicional"))
      return referenciaadicional;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ArchivePaymentUtilitiesProdubancoData[] select(ConnectionProvider connectionProvider, String c_year_id)    throws ServletException {
    return select(connectionProvider, c_year_id, 0, 0);
  }

  public static ArchivePaymentUtilitiesProdubancoData[] select(ConnectionProvider connectionProvider, String c_year_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT 'PA' AS PA, BBA.ACCOUNTNO AS CUENTACOMPANIA, '' AS COMPROBANTEPAGO," +
      "            BBE.ACCOUNTNO AS CONTRAPARTIDA, CC.ISO_CODE AS USD, ROUND(U.TOTALPROFITS,2) AS VALOR," +
      "            'CTA' AS FORMAPAGO, BT.CODE AS CODIGOBANCO, " +
      "            CASE WHEN BBE.BANKACCOUNTTYPE = 'S' THEN 'AHO' WHEN BBE.BANKACCOUNTTYPE = 'C' THEN  'CTE' ELSE 'NO DEFINIDO' END TIPOCTA," +
      "            BBE.ACCOUNTNO AS NOCUENTA, " +
      "            CASE WHEN B.EM_SSPR_DOCUMENTTYPE = 'P' THEN 'P'" +
      "                 WHEN B.EM_SSPR_DOCUMENTTYPE = 'SRT' THEN 'R'" +
      "                 WHEN B.EM_SSPR_DOCUMENTTYPE = 'NI' THEN 'C'" +
      "                 ELSE 'NO DEFINIDO' END AS TIPOIDEMPLEADO," +
      "            B.TAXID AS CEDULA," +
      "            B.NAME AS NOMBREEMPLEADO," +
      "            '' AS DIRECCION," +
      "            '' AS CIUDAD, " +
      "            '' AS TELEFONO, " +
      "            '' AS LOCALIDAD," +
      "            CU.DESCRIPTION AS REFERENCIA," +
      "            '' AS REFERENCIAADICIONAL" +
      "            FROM SSPR_UTILITIES U" +
      "            LEFT JOIN SSPR_CONFIGURATIONUTILITY CU ON CU.C_YEAR_ID = U.C_YEAR_ID" +
      "            LEFT JOIN C_BPARTNER B ON B.C_BPARTNER_ID = U.C_BPARTNER_ID" +
      "            LEFT JOIN AD_ORGINFO O ON O.AD_ORG_ID = U.AD_ORG_ID" +
      "            LEFT JOIN C_BPARTNER BA ON BA.C_BPARTNER_ID = O.C_BPARTNER_ID" +
      "            LEFT JOIN C_BP_BANKACCOUNT BBA ON BBA.C_BPARTNER_ID = BA.C_BPARTNER_ID" +
      "            LEFT JOIN C_BP_BANKACCOUNT BBE ON BBE.C_BPARTNER_ID = B.C_BPARTNER_ID" +
      "            LEFT JOIN AD_CLIENT C ON C.AD_CLIENT_ID = U.AD_CLIENT_ID" +
      "            LEFT JOIN C_CURRENCY CC ON CC.C_CURRENCY_ID = C.C_CURRENCY_ID" +
      "            LEFT JOIN SSFI_BANKTRANSFER BT ON BT.SSFI_BANKTRANSFER_ID = BBE.EM_SSFI_BANKTRANSFER_ID" +
      "            WHERE U.C_YEAR_ID = ?" +
      "            AND B.EM_SSPR_TYPEOFINCOME = 'D'";

    ResultSet result;
    Vector<ArchivePaymentUtilitiesProdubancoData> vector = new Vector<ArchivePaymentUtilitiesProdubancoData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_year_id);

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
        ArchivePaymentUtilitiesProdubancoData objectArchivePaymentUtilitiesProdubancoData = new ArchivePaymentUtilitiesProdubancoData();
        objectArchivePaymentUtilitiesProdubancoData.pa = UtilSql.getValue(result, "pa");
        objectArchivePaymentUtilitiesProdubancoData.cuentacompania = UtilSql.getValue(result, "cuentacompania");
        objectArchivePaymentUtilitiesProdubancoData.comprobantepago = UtilSql.getValue(result, "comprobantepago");
        objectArchivePaymentUtilitiesProdubancoData.contrapartida = UtilSql.getValue(result, "contrapartida");
        objectArchivePaymentUtilitiesProdubancoData.usd = UtilSql.getValue(result, "usd");
        objectArchivePaymentUtilitiesProdubancoData.valor = UtilSql.getValue(result, "valor");
        objectArchivePaymentUtilitiesProdubancoData.formapago = UtilSql.getValue(result, "formapago");
        objectArchivePaymentUtilitiesProdubancoData.codigobanco = UtilSql.getValue(result, "codigobanco");
        objectArchivePaymentUtilitiesProdubancoData.tipocta = UtilSql.getValue(result, "tipocta");
        objectArchivePaymentUtilitiesProdubancoData.nocuenta = UtilSql.getValue(result, "nocuenta");
        objectArchivePaymentUtilitiesProdubancoData.tipoidempleado = UtilSql.getValue(result, "tipoidempleado");
        objectArchivePaymentUtilitiesProdubancoData.cedula = UtilSql.getValue(result, "cedula");
        objectArchivePaymentUtilitiesProdubancoData.nombreempleado = UtilSql.getValue(result, "nombreempleado");
        objectArchivePaymentUtilitiesProdubancoData.direccion = UtilSql.getValue(result, "direccion");
        objectArchivePaymentUtilitiesProdubancoData.ciudad = UtilSql.getValue(result, "ciudad");
        objectArchivePaymentUtilitiesProdubancoData.telefono = UtilSql.getValue(result, "telefono");
        objectArchivePaymentUtilitiesProdubancoData.localidad = UtilSql.getValue(result, "localidad");
        objectArchivePaymentUtilitiesProdubancoData.referencia = UtilSql.getValue(result, "referencia");
        objectArchivePaymentUtilitiesProdubancoData.referenciaadicional = UtilSql.getValue(result, "referenciaadicional");
        objectArchivePaymentUtilitiesProdubancoData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectArchivePaymentUtilitiesProdubancoData);
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
    ArchivePaymentUtilitiesProdubancoData objectArchivePaymentUtilitiesProdubancoData[] = new ArchivePaymentUtilitiesProdubancoData[vector.size()];
    vector.copyInto(objectArchivePaymentUtilitiesProdubancoData);
    return(objectArchivePaymentUtilitiesProdubancoData);
  }
}
