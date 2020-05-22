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

public class ArchPaymentPichinchaBankTXTData implements FieldProvider {
static Logger log4j = Logger.getLogger(ArchPaymentPichinchaBankTXTData.class);
  private String InitRecordNumber="0";
  public String ssprPayrollId;
  public String documentno;
  public String pa;
  public String contrapartida;
  public String moneda;
  public String valor;
  public String formacobro;
  public String tipocuenta;
  public String cuenta;
  public String referencia;
  public String tipoidcliente;
  public String numidcliente;
  public String tercero;
  public String code;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("sspr_payroll_id") || fieldName.equals("ssprPayrollId"))
      return ssprPayrollId;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("pa"))
      return pa;
    else if (fieldName.equalsIgnoreCase("contrapartida"))
      return contrapartida;
    else if (fieldName.equalsIgnoreCase("moneda"))
      return moneda;
    else if (fieldName.equalsIgnoreCase("valor"))
      return valor;
    else if (fieldName.equalsIgnoreCase("formacobro"))
      return formacobro;
    else if (fieldName.equalsIgnoreCase("tipocuenta"))
      return tipocuenta;
    else if (fieldName.equalsIgnoreCase("cuenta"))
      return cuenta;
    else if (fieldName.equalsIgnoreCase("referencia"))
      return referencia;
    else if (fieldName.equalsIgnoreCase("tipoidcliente"))
      return tipoidcliente;
    else if (fieldName.equalsIgnoreCase("numidcliente"))
      return numidcliente;
    else if (fieldName.equalsIgnoreCase("tercero"))
      return tercero;
    else if (fieldName.equalsIgnoreCase("code"))
      return code;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ArchPaymentPichinchaBankTXTData[] select(ConnectionProvider connectionProvider, String documentno, String bankid, String categoryid)    throws ServletException {
    return select(connectionProvider, documentno, bankid, categoryid, 0, 0);
  }

  public static ArchPaymentPichinchaBankTXTData[] select(ConnectionProvider connectionProvider, String documentno, String bankid, String categoryid, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	select " +
      "	A.SSPR_PAYROLL_ID," +
      "	A.DOCUMENTNO," +
      "	to_char('') as PA," +
      "	EM_SSPR_DocumentNo AS CONTRAPARTIDA," +
      "	C.ISO_CODE AS MONEDA," +
      "	ROUND(TOTALNET,2) AS VALOR," +
      "	'CTA' AS FORMACOBRO," +
      "	CASE WHEN F.BankAccountType='S' THEN 'AHO'" +
      "	WHEN F.BankAccountType='C' THEN 'CTE' END" +
      "	AS TIPOCUENTA," +
      "	F.AccountNo AS CUENTA," +
      "	A.DESCRIPTION AS REFERENCIA," +
      "	CASE WHEN EM_SSPR_Documenttype = 'NI' THEN 'C'" +
      "	WHEN EM_SSPR_Documenttype = 'SRT' THEN 'R'" +
      "	WHEN EM_SSPR_Documenttype = 'P' THEN 'P'" +
      "	ELSE 'ND' END" +
      "	as TIPOIDCLIENTE," +
      "	EM_SSPR_DocumentNo AS NUMIDCLIENTE," +
      "	E.NAME AS TERCERO," +
      "	G.CODE From SSPR_PAYROLL A LEFT JOIN AD_ORG B ON A.AD_ORG_ID = B.AD_ORG_ID  	" +
      "	LEFT JOIN C_CURRENCY C ON B.C_CURRENCY_ID = C.C_CURRENCY_ID  	" +
      "	LEFT JOIN SSPR_PAYROLL_TICKET D ON A.SSPR_PAYROLL_ID = D.SSPR_PAYROLL_ID  		" +
      "	LEFT JOIN C_BPARTNER E ON D.C_BPARTNER_ID = E.C_BPARTNER_ID  		" +
      "	LEFT JOIN C_BP_BankAccount F ON E.C_BPARTNER_ID = F.C_BPARTNER_ID  	" +
      "    LEFT JOIN SSFI_BANKTRANSFER G ON F.em_ssfi_banktransfer_id = G.ssfi_banktransfer_id " +
      "    WHERE A.DOCUMENTNO = ? " +
      "    AND G.ssfi_banktransfer_id = ?" +
      "    AND (E.em_sspr_category_acct_id = ? OR ? IS NULL)" +
      "    AND EM_SSPR_Typeofincome= 'D' " +
      "    AND ispayroll='Y' " +
      "    AND processed= 'Y' " +
      "    ORDER BY E.NAME";

    ResultSet result;
    Vector<ArchPaymentPichinchaBankTXTData> vector = new Vector<ArchPaymentPichinchaBankTXTData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bankid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, categoryid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, categoryid);

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
        ArchPaymentPichinchaBankTXTData objectArchPaymentPichinchaBankTXTData = new ArchPaymentPichinchaBankTXTData();
        objectArchPaymentPichinchaBankTXTData.ssprPayrollId = UtilSql.getValue(result, "sspr_payroll_id");
        objectArchPaymentPichinchaBankTXTData.documentno = UtilSql.getValue(result, "documentno");
        objectArchPaymentPichinchaBankTXTData.pa = UtilSql.getValue(result, "pa");
        objectArchPaymentPichinchaBankTXTData.contrapartida = UtilSql.getValue(result, "contrapartida");
        objectArchPaymentPichinchaBankTXTData.moneda = UtilSql.getValue(result, "moneda");
        objectArchPaymentPichinchaBankTXTData.valor = UtilSql.getValue(result, "valor");
        objectArchPaymentPichinchaBankTXTData.formacobro = UtilSql.getValue(result, "formacobro");
        objectArchPaymentPichinchaBankTXTData.tipocuenta = UtilSql.getValue(result, "tipocuenta");
        objectArchPaymentPichinchaBankTXTData.cuenta = UtilSql.getValue(result, "cuenta");
        objectArchPaymentPichinchaBankTXTData.referencia = UtilSql.getValue(result, "referencia");
        objectArchPaymentPichinchaBankTXTData.tipoidcliente = UtilSql.getValue(result, "tipoidcliente");
        objectArchPaymentPichinchaBankTXTData.numidcliente = UtilSql.getValue(result, "numidcliente");
        objectArchPaymentPichinchaBankTXTData.tercero = UtilSql.getValue(result, "tercero");
        objectArchPaymentPichinchaBankTXTData.code = UtilSql.getValue(result, "code");
        objectArchPaymentPichinchaBankTXTData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectArchPaymentPichinchaBankTXTData);
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
    ArchPaymentPichinchaBankTXTData objectArchPaymentPichinchaBankTXTData[] = new ArchPaymentPichinchaBankTXTData[vector.size()];
    vector.copyInto(objectArchPaymentPichinchaBankTXTData);
    return(objectArchPaymentPichinchaBankTXTData);
  }
}
