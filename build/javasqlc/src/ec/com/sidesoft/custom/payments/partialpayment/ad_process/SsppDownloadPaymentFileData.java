//Sqlc generated V1.O00-1
package ec.com.sidesoft.custom.payments.partialpayment.ad_process;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class SsppDownloadPaymentFileData implements FieldProvider {
static Logger log4j = Logger.getLogger(SsppDownloadPaymentFileData.class);
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

  public static SsppDownloadPaymentFileData[] select(ConnectionProvider connectionProvider, String ssppp_payment_id)    throws ServletException {
    return select(connectionProvider, ssppp_payment_id, 0, 0);
  }

  public static SsppDownloadPaymentFileData[] select(ConnectionProvider connectionProvider, String ssppp_payment_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select  " +
      "      cedula_ruc_pasaporte," +
      "      referencia," +
      "      tercero," +
      "      institucion_financiera," +
      "      cuenta_beneficiario," +
      "      tipo_cuenta," +
      "      sum(valor) as valor," +
      "      concepto," +
      "      detalle  " +
      "      from " +
      "	(select   " +
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
      ", to_number(coalesce(( case cbpb.bankaccounttype " +
      "    when 'C' then '1' " +
      "    when 'S' then '2' " +
      "    else '0' " +
      "    end ),'0')) as tipo_cuenta" +
      ", coalesce(round(sum(spl.amount),2),0) as valor" +
      ", to_number(coalesce(sspp_returnbudgetbypartner(cbp.taxid,sp.sspp_payments_id,'1',spl.fin_payment_id),'0')) as concepto" +
      ", coalesce(sspp_returnbudgetbypartner(cbp.taxid,sp.sspp_payments_id,'2',spl.fin_payment_id),'-') as detalle, sp.ad_client_id" +
      ", sp.ad_org_id" +
      ", sp.created" +
      ", sp.createdby" +
      ", sp.updated" +
      ", sp.updatedby" +
      ", sp.isactive" +
      ", sp.sspp_payments_id as sspp_transferpayment_v_id   " +
      "  from sspp_payments sp          " +
      "  left join sspp_paymentsline spl on sp.sspp_payments_id = spl.sspp_payments_id  " +
      "  left join c_bpartner cbp on cbp.c_bpartner_id = spl.c_bpartner_id   " +
      "  left join fin_payment fp on fp.fin_payment_id = spl.fin_payment_id  " +
      "  left join c_bp_bankaccount cbpb on cbpb.c_bp_bankaccount_id = fp.EM_Sswh_Bp_Bankaccount_ID  " +
      "  left join ssfi_banktransfer sb on sb.ssfi_banktransfer_id = cbpb.em_ssfi_banktransfer_id    " +
      "  where sp.sspp_payments_id = ?  " +
      " group by cbpb.em_sswh_taxidno,sb.value, cbpb.EM_Sswh_Taxidtype,cbp.name,cbpb.accountno,cbpb.bankaccounttype   " +
      ", sp.ad_client_id" +
      ", sp.ad_org_id" +
      ", sp.created" +
      ", sp.createdby" +
      ", sp.updated" +
      ", sp.updatedby" +
      ", sp.isactive" +
      ", sp.sspp_payments_id  " +
      ",cbp.taxid,spl.fin_payment_id  " +
      " order by cbpb.em_sswh_taxidno,sb.value " +
      " ) a " +
      " group by  " +
      "      cedula_ruc_pasaporte," +
      "      referencia," +
      "      tercero," +
      "      institucion_financiera," +
      "      cuenta_beneficiario," +
      "      tipo_cuenta," +
      "      concepto," +
      "      detalle";

    ResultSet result;
    Vector<SsppDownloadPaymentFileData> vector = new Vector<SsppDownloadPaymentFileData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ssppp_payment_id);

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
        SsppDownloadPaymentFileData objectSsppDownloadPaymentFileData = new SsppDownloadPaymentFileData();
        objectSsppDownloadPaymentFileData.cedulaRucPasaporte = UtilSql.getValue(result, "cedula_ruc_pasaporte");
        objectSsppDownloadPaymentFileData.referencia = UtilSql.getValue(result, "referencia");
        objectSsppDownloadPaymentFileData.tercero = UtilSql.getValue(result, "tercero");
        objectSsppDownloadPaymentFileData.institucionFinanciera = UtilSql.getValue(result, "institucion_financiera");
        objectSsppDownloadPaymentFileData.cuentaBeneficiario = UtilSql.getValue(result, "cuenta_beneficiario");
        objectSsppDownloadPaymentFileData.tipoCuenta = UtilSql.getValue(result, "tipo_cuenta");
        objectSsppDownloadPaymentFileData.valor = UtilSql.getValue(result, "valor");
        objectSsppDownloadPaymentFileData.concepto = UtilSql.getValue(result, "concepto");
        objectSsppDownloadPaymentFileData.detalle = UtilSql.getValue(result, "detalle");
        objectSsppDownloadPaymentFileData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSsppDownloadPaymentFileData);
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
    SsppDownloadPaymentFileData objectSsppDownloadPaymentFileData[] = new SsppDownloadPaymentFileData[vector.size()];
    vector.copyInto(objectSsppDownloadPaymentFileData);
    return(objectSsppDownloadPaymentFileData);
  }
}
