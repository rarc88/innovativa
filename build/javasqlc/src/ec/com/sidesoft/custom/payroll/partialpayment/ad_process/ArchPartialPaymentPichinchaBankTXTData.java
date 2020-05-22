//Sqlc generated V1.O00-1
package ec.com.sidesoft.custom.payroll.partialpayment.ad_process;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

public class ArchPartialPaymentPichinchaBankTXTData implements FieldProvider {
static Logger log4j = Logger.getLogger(ArchPartialPaymentPichinchaBankTXTData.class);
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

  public static ArchPartialPaymentPichinchaBankTXTData[] select(ConnectionProvider connectionProvider, String documentno, String typeofincome, String scpp_approvalpayment_id)    throws ServletException {
    return select(connectionProvider, documentno, typeofincome, scpp_approvalpayment_id, 0, 0);
  }

  public static ArchPartialPaymentPichinchaBankTXTData[] select(ConnectionProvider connectionProvider, String documentno, String typeofincome, String scpp_approvalpayment_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	select " +
      "	A.SSPR_PAYROLL_ID," +
      "	A.DOCUMENTNO," +
      "	'PA' AS PA," +
      "	'1' AS CONTRAPARTIDA," +
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
      "   	LEFT JOIN SSFI_BANKTRANSFER G ON F.em_ssfi_banktransfer_id = G.ssfi_banktransfer_id	  " +
      "	left join scpp_approvalpaymentline on d.em_scpp_approvalpaymentline_id = scpp_approvalpaymentline.scpp_approvalpaymentline_id" +
      "    left join scpp_approvalpayment on scpp_approvalpaymentline.scpp_approvalpayment_id = scpp_approvalpayment.scpp_approvalpayment_id	 " +
      "	WHERE A.DOCUMENTNO = ? AND EM_SSPR_Typeofincome= ? and ispayroll='Y' and processed= 'Y'	  " +
      "	and scpp_approvalpayment.scpp_approvalpayment_id = ? ORDER BY E.NAME";

    ResultSet result;
    Vector<ArchPartialPaymentPichinchaBankTXTData> vector = new Vector<ArchPartialPaymentPichinchaBankTXTData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, typeofincome);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, scpp_approvalpayment_id);

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
        ArchPartialPaymentPichinchaBankTXTData objectArchPartialPaymentPichinchaBankTXTData = new ArchPartialPaymentPichinchaBankTXTData();
        objectArchPartialPaymentPichinchaBankTXTData.ssprPayrollId = UtilSql.getValue(result, "sspr_payroll_id");
        objectArchPartialPaymentPichinchaBankTXTData.documentno = UtilSql.getValue(result, "documentno");
        objectArchPartialPaymentPichinchaBankTXTData.pa = UtilSql.getValue(result, "pa");
        objectArchPartialPaymentPichinchaBankTXTData.contrapartida = UtilSql.getValue(result, "contrapartida");
        objectArchPartialPaymentPichinchaBankTXTData.moneda = UtilSql.getValue(result, "moneda");
        objectArchPartialPaymentPichinchaBankTXTData.valor = UtilSql.getValue(result, "valor");
        objectArchPartialPaymentPichinchaBankTXTData.formacobro = UtilSql.getValue(result, "formacobro");
        objectArchPartialPaymentPichinchaBankTXTData.tipocuenta = UtilSql.getValue(result, "tipocuenta");
        objectArchPartialPaymentPichinchaBankTXTData.cuenta = UtilSql.getValue(result, "cuenta");
        objectArchPartialPaymentPichinchaBankTXTData.referencia = UtilSql.getValue(result, "referencia");
        objectArchPartialPaymentPichinchaBankTXTData.tipoidcliente = UtilSql.getValue(result, "tipoidcliente");
        objectArchPartialPaymentPichinchaBankTXTData.numidcliente = UtilSql.getValue(result, "numidcliente");
        objectArchPartialPaymentPichinchaBankTXTData.tercero = UtilSql.getValue(result, "tercero");
        objectArchPartialPaymentPichinchaBankTXTData.code = UtilSql.getValue(result, "code");
        objectArchPartialPaymentPichinchaBankTXTData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectArchPartialPaymentPichinchaBankTXTData);
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
    ArchPartialPaymentPichinchaBankTXTData objectArchPartialPaymentPichinchaBankTXTData[] = new ArchPartialPaymentPichinchaBankTXTData[vector.size()];
    vector.copyInto(objectArchPartialPaymentPichinchaBankTXTData);
    return(objectArchPartialPaymentPichinchaBankTXTData);
  }
}
