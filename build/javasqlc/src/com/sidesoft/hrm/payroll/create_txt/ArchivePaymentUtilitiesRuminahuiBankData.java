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

public class ArchivePaymentUtilitiesRuminahuiBankData implements FieldProvider {
static Logger log4j = Logger.getLogger(ArchivePaymentUtilitiesRuminahuiBankData.class);
  private String InitRecordNumber="0";
  public String pa;
  public String idcliente;
  public String moneda;
  public String totalutilidades;
  public String cta;
  public String bankacctype;
  public String accountno;
  public String referencia;
  public String typeid;
  public String idcliente2;
  public String cliente;
  public String codigobanco;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("pa"))
      return pa;
    else if (fieldName.equalsIgnoreCase("idcliente"))
      return idcliente;
    else if (fieldName.equalsIgnoreCase("moneda"))
      return moneda;
    else if (fieldName.equalsIgnoreCase("totalutilidades"))
      return totalutilidades;
    else if (fieldName.equalsIgnoreCase("cta"))
      return cta;
    else if (fieldName.equalsIgnoreCase("bankacctype"))
      return bankacctype;
    else if (fieldName.equalsIgnoreCase("accountno"))
      return accountno;
    else if (fieldName.equalsIgnoreCase("referencia"))
      return referencia;
    else if (fieldName.equalsIgnoreCase("typeid"))
      return typeid;
    else if (fieldName.equalsIgnoreCase("idcliente2"))
      return idcliente2;
    else if (fieldName.equalsIgnoreCase("cliente"))
      return cliente;
    else if (fieldName.equalsIgnoreCase("codigobanco"))
      return codigobanco;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ArchivePaymentUtilitiesRuminahuiBankData[] select(ConnectionProvider connectionProvider, String C_YEAR_ID)    throws ServletException {
    return select(connectionProvider, C_YEAR_ID, 0, 0);
  }

  public static ArchivePaymentUtilitiesRuminahuiBankData[] select(ConnectionProvider connectionProvider, String C_YEAR_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "select to_char('PA') as pa  " +
      ",cbp.taxid as idcliente   " +
      ",to_char('USD') as moneda   " +
      ",to_char(round(totalprofits,2)) as totalutilidades   " +
      ",to_char('CTA') as cta   " +
      ",case bpba.bankaccounttype when 'S' then 'AHO' when 'C' then 'CTE' else '' end as bankacctype   " +
      ", bpba.accountno    " +
      ",to_char('Utilidades') as referencia" +
      ",case cbp.em_sspr_documenttype when 'NI' then 'C' when 'SRT' then 'R' else '' end as typeid   " +
      ",cbp.taxid as idcliente2   " +
      ",cbp.name as cliente   " +
      ",bt.code as codigobanco   " +
      "from sspr_utilities su   " +
      "left join c_bpartner cbp on cbp.c_bpartner_id = su.c_bpartner_id   " +
      "left join c_bp_bankaccount bpba on bpba.c_bpartner_id = cbp.c_bpartner_id and bpba.em_sspr_ispayroll = 'Y'    " +
      "left join ssfi_banktransfer bt on bpba.em_ssfi_banktransfer_id = bt.ssfi_banktransfer_id  " +
      "where su.c_year_id = ?     " +
      "and cbp.EM_SSPR_Typeofincome = 'D'    " +
      "ORDER BY cbp.NAME    ";

    ResultSet result;
    Vector<ArchivePaymentUtilitiesRuminahuiBankData> vector = new Vector<ArchivePaymentUtilitiesRuminahuiBankData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_YEAR_ID);

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
        ArchivePaymentUtilitiesRuminahuiBankData objectArchivePaymentUtilitiesRuminahuiBankData = new ArchivePaymentUtilitiesRuminahuiBankData();
        objectArchivePaymentUtilitiesRuminahuiBankData.pa = UtilSql.getValue(result, "pa");
        objectArchivePaymentUtilitiesRuminahuiBankData.idcliente = UtilSql.getValue(result, "idcliente");
        objectArchivePaymentUtilitiesRuminahuiBankData.moneda = UtilSql.getValue(result, "moneda");
        objectArchivePaymentUtilitiesRuminahuiBankData.totalutilidades = UtilSql.getValue(result, "totalutilidades");
        objectArchivePaymentUtilitiesRuminahuiBankData.cta = UtilSql.getValue(result, "cta");
        objectArchivePaymentUtilitiesRuminahuiBankData.bankacctype = UtilSql.getValue(result, "bankacctype");
        objectArchivePaymentUtilitiesRuminahuiBankData.accountno = UtilSql.getValue(result, "accountno");
        objectArchivePaymentUtilitiesRuminahuiBankData.referencia = UtilSql.getValue(result, "referencia");
        objectArchivePaymentUtilitiesRuminahuiBankData.typeid = UtilSql.getValue(result, "typeid");
        objectArchivePaymentUtilitiesRuminahuiBankData.idcliente2 = UtilSql.getValue(result, "idcliente2");
        objectArchivePaymentUtilitiesRuminahuiBankData.cliente = UtilSql.getValue(result, "cliente");
        objectArchivePaymentUtilitiesRuminahuiBankData.codigobanco = UtilSql.getValue(result, "codigobanco");
        objectArchivePaymentUtilitiesRuminahuiBankData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectArchivePaymentUtilitiesRuminahuiBankData);
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
    ArchivePaymentUtilitiesRuminahuiBankData objectArchivePaymentUtilitiesRuminahuiBankData[] = new ArchivePaymentUtilitiesRuminahuiBankData[vector.size()];
    vector.copyInto(objectArchivePaymentUtilitiesRuminahuiBankData);
    return(objectArchivePaymentUtilitiesRuminahuiBankData);
  }
}
