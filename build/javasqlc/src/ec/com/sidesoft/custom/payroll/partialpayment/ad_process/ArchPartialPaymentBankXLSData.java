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

public class ArchPartialPaymentBankXLSData implements FieldProvider {
static Logger log4j = Logger.getLogger(ArchPartialPaymentBankXLSData.class);
  private String InitRecordNumber="0";
  public String cedulaRucPasaporte;
  public String referencia;
  public String tercero;
  public String institucionFinanciera;
  public String cuentaBeneficiario;
  public String tipoCuenta;
  public String valor;
  public String concepto;
  public String detalle;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("cedula_ruc_pasaporte") || fieldName.equals("cedulaRucPasaporte"))
      return cedulaRucPasaporte;
    else if (fieldName.equalsIgnoreCase("referencia"))
      return referencia;
    else if (fieldName.equalsIgnoreCase("tercero"))
      return tercero;
    else if (fieldName.equalsIgnoreCase("institucion_financiera") || fieldName.equals("institucionFinanciera"))
      return institucionFinanciera;
    else if (fieldName.equalsIgnoreCase("cuenta_beneficiario") || fieldName.equals("cuentaBeneficiario"))
      return cuentaBeneficiario;
    else if (fieldName.equalsIgnoreCase("tipo_cuenta") || fieldName.equals("tipoCuenta"))
      return tipoCuenta;
    else if (fieldName.equalsIgnoreCase("valor"))
      return valor;
    else if (fieldName.equalsIgnoreCase("concepto"))
      return concepto;
    else if (fieldName.equalsIgnoreCase("detalle"))
      return detalle;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ArchPartialPaymentBankXLSData[] select(ConnectionProvider connectionProvider, String scpp_approvalpayment_id)    throws ServletException {
    return select(connectionProvider, scpp_approvalpayment_id, 0, 0);
  }

  public static ArchPartialPaymentBankXLSData[] select(ConnectionProvider connectionProvider, String scpp_approvalpayment_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "select  " +
      "  coalesce(cbpb.em_sswh_taxidno,'-')::varchar as cedula_ruc_pasaporte" +
      ",coalesce((case cbpb.EM_Sswh_Taxidtype " +
      "when 'D' then 1  " +
      "when 'P' then 3 " +
      "when 'R' then 2 " +
      "else 0 " +
      " end),0) as referencia" +
      ", substr(cbp.name,1,29)::varchar as tercero" +
      ", to_number(coalesce(sb.value,'0')) as institucion_financiera" +
      ", to_number(coalesce(cbpb.accountno,'0')) as cuenta_beneficiario" +
      ", coalesce(( case cbpb.bankaccounttype " +
      "    when 'C' then 1 " +
      "    when 'S' then 2 " +
      "    else 0 " +
      "    end ),0) as tipo_cuenta" +
      ", coalesce(round(sum(spl.payrollamount),2),0) as valor" +
      ", to_number(coalesce(sc.value,'0')) as concepto" +
      ", coalesce('ROL ' || cp.name,'-')::varchar as detalle  " +
      "  from scpp_approvalpayment   sp           " +
      "  left join scpp_approvalpaymentline spl on sp.scpp_approvalpayment_id = spl.scpp_approvalpayment_id" +
      "  left join c_bpartner cbp on cbp.c_bpartner_id = spl.c_bpartner_id  " +
      "  left join c_bp_bankaccount cbpb on cbpb.c_bpartner_id =cbp.c_bpartner_id and cbpb.isactive ='Y'  " +
      "  left join ssfi_banktransfer sb on sb.ssfi_banktransfer_id = em_ssfi_banktransfer_id   " +
      "  left join scpp_concept sc on sc.scpp_concept_id = sp.scpp_concept_id" +
      "  left join c_period cp on cp.c_period_id = sp.c_period_id" +
      "  where sp.scpp_approvalpayment_id = ?  " +
      "  group by cbpb.em_sswh_taxidno, cbpb.EM_Sswh_Taxidtype,cbp.name,sb.value,cbpb.accountno,cbpb.bankaccounttype, sc.value, cp.name" +
      "  ,cbp.taxid   " +
      "order by cbpb.em_sswh_taxidno ";

    ResultSet result;
    Vector<ArchPartialPaymentBankXLSData> vector = new Vector<ArchPartialPaymentBankXLSData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
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
        ArchPartialPaymentBankXLSData objectArchPartialPaymentBankXLSData = new ArchPartialPaymentBankXLSData();
        objectArchPartialPaymentBankXLSData.cedulaRucPasaporte = UtilSql.getValue(result, "cedula_ruc_pasaporte");
        objectArchPartialPaymentBankXLSData.referencia = UtilSql.getValue(result, "referencia");
        objectArchPartialPaymentBankXLSData.tercero = UtilSql.getValue(result, "tercero");
        objectArchPartialPaymentBankXLSData.institucionFinanciera = UtilSql.getValue(result, "institucion_financiera");
        objectArchPartialPaymentBankXLSData.cuentaBeneficiario = UtilSql.getValue(result, "cuenta_beneficiario");
        objectArchPartialPaymentBankXLSData.tipoCuenta = UtilSql.getValue(result, "tipo_cuenta");
        objectArchPartialPaymentBankXLSData.valor = UtilSql.getValue(result, "valor");
        objectArchPartialPaymentBankXLSData.concepto = UtilSql.getValue(result, "concepto");
        objectArchPartialPaymentBankXLSData.detalle = UtilSql.getValue(result, "detalle");
        objectArchPartialPaymentBankXLSData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectArchPartialPaymentBankXLSData);
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
    ArchPartialPaymentBankXLSData objectArchPartialPaymentBankXLSData[] = new ArchPartialPaymentBankXLSData[vector.size()];
    vector.copyInto(objectArchPartialPaymentBankXLSData);
    return(objectArchPartialPaymentBankXLSData);
  }
}
