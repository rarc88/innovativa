//Sqlc generated V1.O00-1
package com.sidesoft.hrm.payroll.ad_Reports;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class RptRequestLoanData implements FieldProvider {
static Logger log4j = Logger.getLogger(RptRequestLoanData.class);
  private String InitRecordNumber="0";
  public String organizationid;
  public String nombreempleado;
  public String fechasolicitud;
  public String tipodocumento;
  public String nodocumento;
  public String primerpago;
  public String montototal;
  public String ci;
  public String numerocuotas;
  public String nombrebanco;
  public String nocuenta;
  public String tipocuenta;
  public String descripcion;
  public String gerencia;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("organizationid"))
      return organizationid;
    else if (fieldName.equalsIgnoreCase("nombreempleado"))
      return nombreempleado;
    else if (fieldName.equalsIgnoreCase("fechasolicitud"))
      return fechasolicitud;
    else if (fieldName.equalsIgnoreCase("tipodocumento"))
      return tipodocumento;
    else if (fieldName.equalsIgnoreCase("nodocumento"))
      return nodocumento;
    else if (fieldName.equalsIgnoreCase("primerpago"))
      return primerpago;
    else if (fieldName.equalsIgnoreCase("montototal"))
      return montototal;
    else if (fieldName.equalsIgnoreCase("ci"))
      return ci;
    else if (fieldName.equalsIgnoreCase("numerocuotas"))
      return numerocuotas;
    else if (fieldName.equalsIgnoreCase("nombrebanco"))
      return nombrebanco;
    else if (fieldName.equalsIgnoreCase("nocuenta"))
      return nocuenta;
    else if (fieldName.equalsIgnoreCase("tipocuenta"))
      return tipocuenta;
    else if (fieldName.equalsIgnoreCase("descripcion"))
      return descripcion;
    else if (fieldName.equalsIgnoreCase("gerencia"))
      return gerencia;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static RptRequestLoanData[] select(ConnectionProvider connectionProvider, String loans)    throws ServletException {
    return select(connectionProvider, loans, 0, 0);
  }

  public static RptRequestLoanData[] select(ConnectionProvider connectionProvider, String loans, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       select sspr_loans.ad_org_id as organizationid, " +
      "        c_bpartner.name as nombreempleado," +
      "       to_char(sspr_loans.requestdate) as fechasolicitud," +
      "       c_doctype.name as tipodocumento," +
      "       sspr_loans.em_sfpr_documentno as nodocumento," +
      "       to_char(sspr_loans.firstdate) as primerpago," +
      "    sspr_loans.amount as montototal," +
      "    c_bpartner.taxid as ci," +
      "    sspr_loans.time as numerocuotas," +
      "    ssfi_banktransfer.name as nombrebanco," +
      "    C_BP_BankAccount.accountno as nocuenta," +
      "    case when C_BP_BankAccount.bankaccounttype = 'S' then 'Ahorros'" +
      "       when C_BP_BankAccount.bankaccounttype = 'C' then 'Corriente'" +
      "    end as tipocuenta," +
      "    sspr_loans.description as descripcion," +
      "    c_costcenter.name as gerencia" +
      "    from sspr_loans" +
      "    left join c_bpartner on c_bpartner.c_bpartner_id = sspr_loans.c_bpartner_id" +
      "    left join c_doctype on c_doctype.c_doctype_id = sspr_loans.em_sfpr_c_doctype_id" +
      "    left join c_bp_bankaccount on c_bp_bankaccount.c_bpartner_id = c_bpartner.c_bpartner_id" +
      "    left join ssfi_banktransfer on ssfi_banktransfer.ssfi_banktransfer_id = c_bp_bankaccount.em_ssfi_banktransfer_id" +
      "    left join c_costcenter on c_costcenter.c_costcenter_id = c_bpartner.em_sspr_costcenter_id" +
      "    where sspr_loans.sspr_loans_id = ? and sspr_loans.status = 'ap'";

    ResultSet result;
    Vector<RptRequestLoanData> vector = new Vector<RptRequestLoanData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, loans);

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
        RptRequestLoanData objectRptRequestLoanData = new RptRequestLoanData();
        objectRptRequestLoanData.organizationid = UtilSql.getValue(result, "organizationid");
        objectRptRequestLoanData.nombreempleado = UtilSql.getValue(result, "nombreempleado");
        objectRptRequestLoanData.fechasolicitud = UtilSql.getValue(result, "fechasolicitud");
        objectRptRequestLoanData.tipodocumento = UtilSql.getValue(result, "tipodocumento");
        objectRptRequestLoanData.nodocumento = UtilSql.getValue(result, "nodocumento");
        objectRptRequestLoanData.primerpago = UtilSql.getValue(result, "primerpago");
        objectRptRequestLoanData.montototal = UtilSql.getValue(result, "montototal");
        objectRptRequestLoanData.ci = UtilSql.getValue(result, "ci");
        objectRptRequestLoanData.numerocuotas = UtilSql.getValue(result, "numerocuotas");
        objectRptRequestLoanData.nombrebanco = UtilSql.getValue(result, "nombrebanco");
        objectRptRequestLoanData.nocuenta = UtilSql.getValue(result, "nocuenta");
        objectRptRequestLoanData.tipocuenta = UtilSql.getValue(result, "tipocuenta");
        objectRptRequestLoanData.descripcion = UtilSql.getValue(result, "descripcion");
        objectRptRequestLoanData.gerencia = UtilSql.getValue(result, "gerencia");
        objectRptRequestLoanData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptRequestLoanData);
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
    RptRequestLoanData objectRptRequestLoanData[] = new RptRequestLoanData[vector.size()];
    vector.copyInto(objectRptRequestLoanData);
    return(objectRptRequestLoanData);
  }

  public static RptRequestLoanData[] set()    throws ServletException {
    RptRequestLoanData objectRptRequestLoanData[] = new RptRequestLoanData[1];
    objectRptRequestLoanData[0] = new RptRequestLoanData();
    objectRptRequestLoanData[0].organizationid = "";
    objectRptRequestLoanData[0].nombreempleado = "";
    objectRptRequestLoanData[0].fechasolicitud = "";
    objectRptRequestLoanData[0].tipodocumento = "";
    objectRptRequestLoanData[0].nodocumento = "";
    objectRptRequestLoanData[0].primerpago = "";
    objectRptRequestLoanData[0].montototal = "";
    objectRptRequestLoanData[0].ci = "";
    objectRptRequestLoanData[0].numerocuotas = "";
    objectRptRequestLoanData[0].nombrebanco = "";
    objectRptRequestLoanData[0].nocuenta = "";
    objectRptRequestLoanData[0].tipocuenta = "";
    objectRptRequestLoanData[0].descripcion = "";
    objectRptRequestLoanData[0].gerencia = "";
    return objectRptRequestLoanData;
  }
}
