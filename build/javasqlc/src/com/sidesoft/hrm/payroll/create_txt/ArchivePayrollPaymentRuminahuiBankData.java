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

public class ArchivePayrollPaymentRuminahuiBankData implements FieldProvider {
static Logger log4j = Logger.getLogger(ArchivePayrollPaymentRuminahuiBankData.class);
  private String InitRecordNumber="0";
  public String servicecode;
  public String ci;
  public String currency;
  public String valor;
  public String bankaccount;
  public String bankacctype;
  public String accountno;
  public String observation;
  public String typeid;
  public String name;
  public String code;
  public String documentno;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("servicecode"))
      return servicecode;
    else if (fieldName.equalsIgnoreCase("ci"))
      return ci;
    else if (fieldName.equalsIgnoreCase("currency"))
      return currency;
    else if (fieldName.equalsIgnoreCase("valor"))
      return valor;
    else if (fieldName.equalsIgnoreCase("bankaccount"))
      return bankaccount;
    else if (fieldName.equalsIgnoreCase("bankacctype"))
      return bankacctype;
    else if (fieldName.equalsIgnoreCase("accountno"))
      return accountno;
    else if (fieldName.equalsIgnoreCase("observation"))
      return observation;
    else if (fieldName.equalsIgnoreCase("typeid"))
      return typeid;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("code"))
      return code;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ArchivePayrollPaymentRuminahuiBankData[] select(ConnectionProvider connectionProvider, String documentno)    throws ServletException {
    return select(connectionProvider, documentno, 0, 0);
  }

  public static ArchivePayrollPaymentRuminahuiBankData[] select(ConnectionProvider connectionProvider, String documentno, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "select  'PA' as servicecode," +
      "                bp.em_sspr_documentno as ci," +
      "                'USD' as currency," +
      "                ROUND(TOTALNET,2) as valor," +
      "                'CTA' as bankaccount," +
      "                case bpba.bankaccounttype when 'S' then 'AHO' when 'C' then 'CTE' else '' end as bankacctype," +
      "                bpba.accountno," +
      "                A.DESCRIPTION as observation," +
      "                case bp.em_sspr_documenttype when 'NI' then 'C' when 'SRT' then 'R' else '' end as typeid," +
      "                bp.name," +
      "                bt.code, " +
      "                a.documentno    " +
      "    From SSPR_PAYROLL A LEFT JOIN AD_ORG B ON A.AD_ORG_ID = B.AD_ORG_ID       " +
      "    LEFT JOIN C_CURRENCY C ON B.C_CURRENCY_ID = C.C_CURRENCY_ID       " +
      "    LEFT JOIN SSPR_PAYROLL_TICKET D ON A.SSPR_PAYROLL_ID = D.SSPR_PAYROLL_ID        " +
      "        join c_bpartner bp on D.c_bpartner_id = bp.c_bpartner_id  " +
      "        left join c_bp_bankaccount bpba on bpba.c_bpartner_id = bp.c_bpartner_id and bpba.em_sspr_ispayroll = 'Y'  " +
      "        left join ssfi_banktransfer bt on bpba.em_ssfi_banktransfer_id = bt.ssfi_banktransfer_id  " +
      "    WHERE   " +
      "    A.DOCUMENTNO = ? AND  " +
      "    bp.EM_SSPR_Typeofincome= 'D' and ispayroll='Y' and processed= 'Y'   " +
      "    and a.isliquidation  = 'N'  ORDER BY bp.NAME      ";

    ResultSet result;
    Vector<ArchivePayrollPaymentRuminahuiBankData> vector = new Vector<ArchivePayrollPaymentRuminahuiBankData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);

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
        ArchivePayrollPaymentRuminahuiBankData objectArchivePayrollPaymentRuminahuiBankData = new ArchivePayrollPaymentRuminahuiBankData();
        objectArchivePayrollPaymentRuminahuiBankData.servicecode = UtilSql.getValue(result, "servicecode");
        objectArchivePayrollPaymentRuminahuiBankData.ci = UtilSql.getValue(result, "ci");
        objectArchivePayrollPaymentRuminahuiBankData.currency = UtilSql.getValue(result, "currency");
        objectArchivePayrollPaymentRuminahuiBankData.valor = UtilSql.getValue(result, "valor");
        objectArchivePayrollPaymentRuminahuiBankData.bankaccount = UtilSql.getValue(result, "bankaccount");
        objectArchivePayrollPaymentRuminahuiBankData.bankacctype = UtilSql.getValue(result, "bankacctype");
        objectArchivePayrollPaymentRuminahuiBankData.accountno = UtilSql.getValue(result, "accountno");
        objectArchivePayrollPaymentRuminahuiBankData.observation = UtilSql.getValue(result, "observation");
        objectArchivePayrollPaymentRuminahuiBankData.typeid = UtilSql.getValue(result, "typeid");
        objectArchivePayrollPaymentRuminahuiBankData.name = UtilSql.getValue(result, "name");
        objectArchivePayrollPaymentRuminahuiBankData.code = UtilSql.getValue(result, "code");
        objectArchivePayrollPaymentRuminahuiBankData.documentno = UtilSql.getValue(result, "documentno");
        objectArchivePayrollPaymentRuminahuiBankData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectArchivePayrollPaymentRuminahuiBankData);
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
    ArchivePayrollPaymentRuminahuiBankData objectArchivePayrollPaymentRuminahuiBankData[] = new ArchivePayrollPaymentRuminahuiBankData[vector.size()];
    vector.copyInto(objectArchivePayrollPaymentRuminahuiBankData);
    return(objectArchivePayrollPaymentRuminahuiBankData);
  }
}
