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

public class SswhRptcSalesPayFormData implements FieldProvider {
static Logger log4j = Logger.getLogger(SswhRptcSalesPayFormData.class);
  private String InitRecordNumber="0";
  public String formOfPayment;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("form_of_payment") || fieldName.equals("formOfPayment"))
      return formOfPayment;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SswhRptcSalesPayFormData[] select(ConnectionProvider connectionProvider, String periodId, String OrgId, String identCli, String periodId2, String OrgId2, String identCli2)    throws ServletException {
    return select(connectionProvider, periodId, OrgId, identCli, periodId2, OrgId2, identCli2, 0, 0);
  }

  public static SswhRptcSalesPayFormData[] select(ConnectionProvider connectionProvider, String periodId, String OrgId, String identCli, String periodId2, String OrgId2, String identCli2, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select  " +
      "form_of_payment  " +
      "from  " +
      "(SELECT  pm.em_sswh_codeats AS form_of_payment   " +
      "        FROM (SELECT sswh_salesinvoice_nats_v.dateinvoiced, sswh_salesinvoice_nats_v.tipo_identificador, sswh_salesinvoice_nats_v.identif_cliente, sswh_salesinvoice_nats_v.nombre_cliente, sswh_salesinvoice_nats_v.cod_tipo_comprobante, sswh_salesinvoice_nats_v.doctype, sswh_salesinvoice_nats_v.count, sswh_salesinvoice_nats_v.base_no_iva, sswh_salesinvoice_nats_v.base_iva_cero, sswh_salesinvoice_nats_v.base_iva_doce, sswh_salesinvoice_nats_v.monto_iva, sswh_salesinvoice_nats_v.monto_ret_iva1 AS monto_ret_iva, sswh_salesinvoice_nats_v.monto_ret_renta1 AS monto_ret_renta, sswh_salesinvoice_nats_v.dateacct, sswh_salesinvoice_nats_v.posted, sswh_salesinvoice_nats_v.parte_relacionada, sswh_salesinvoice_nats_v.montoice, COALESCE(withhsales.ws_retencion_iva, 0) AS ws_retencion_iva, COALESCE(withhsales.ws_retencion_renta, 0) AS ws_retencion_renta, sswh_salesinvoice_nats_v.c_invoice_id, sswh_salesinvoice_nats_v.ad_org_id, sswh_salesinvoice_nats_v.tipo_contrib, sswh_salesinvoice_nats_v.deno_cli, sswh_salesinvoice_nats_v.tipo_em, sswh_salesinvoice_nats_v.documentno, sswh_salesinvoice_nats_v.afectedzone, sswh_salesinvoice_nats_v.afectedzone_code, sswh_salesinvoice_nats_v.afectedzone_percent  " +
      "   FROM (         SELECT a.c_invoice_id, a.dateinvoiced,   " +
      "                        CASE c.em_sswh_taxidtype " +
      "                            WHEN 'R' THEN '04' " +
      "                            WHEN 'P' THEN '06'  " +
      "                            WHEN 'D' THEN '05'  " +
      "                            WHEN 'C' THEN '07'  " +
      "                            ELSE NULL  " +
      "                        END AS tipo_identificador,   " +
      "                        CASE c.em_sswh_taxidtype  " +
      "                            WHEN 'C' THEN to_char('9999999999999')  " +
      "                            ELSE to_char(c.taxid)  " +
      "                        END AS identif_cliente,   " +
      "                        CASE c.em_sswh_taxidtype  " +
      "                            WHEN 'C' THEN to_char('CF')  " +
      "                            ELSE to_char(c.name)  " +
      "                        END AS nombre_cliente, '18' AS cod_tipo_comprobante, g.name AS doctype, count(DISTINCT a.c_invoice_id) * " +
      "                        CASE " +
      "                            WHEN g.em_sswh_doctype = 'C' THEN 1  " +
      "                            ELSE 1  " +
      "                        END AS count, sum(" +
      "                        CASE f.istaxundeductable  " +
      "                            WHEN 'Y' THEN   " +
      "                            CASE f.rate  " +
      "                                WHEN 0 THEN abs(e.taxbaseamt)  " +
      "                                ELSE 0.00  " +
      "                            END  " +
      "                            ELSE 0.00  " +
      "                        END) AS base_no_iva, sum(  " +
      "                        CASE f.istaxdeductable  " +
      "                            WHEN 'Y' THEN   " +
      "                            CASE f.rate   " +
      "                                WHEN 0 THEN abs(e.taxbaseamt)  " +
      "                                ELSE 0.00  " +
      "                            END  " +
      "                            ELSE 0.00  " +
      "                        END) AS base_iva_cero, sum(  " +
      "                        CASE f.istaxdeductable  " +
      "                            WHEN 'Y' THEN   " +
      "                            CASE  " +
      "                                WHEN f.rate <> 0 THEN abs(e.taxbaseamt)  " +
      "                                ELSE 0.00  " +
      "                            END  " +
      "                            ELSE 0.00  " +
      "                        END) AS base_iva_doce, sum(  " +
      "                        CASE f.istaxdeductable  " +
      "                            WHEN 'Y' THEN   " +
      "                            CASE  " +
      "                                WHEN f.rate <> 0 THEN abs(e.taxamt)  " +
      "                                ELSE 0.00  " +
      "                            END   " +
      "                            ELSE 0.00  " +
      "                        END) AS monto_iva, COALESCE(abs(sum(withhol.monto_ret_iva1)), 0) AS monto_ret_iva1, COALESCE(abs(sum(withhol.monto_ret_renta1)), 0) AS monto_ret_renta1, a.dateacct, a.posted,   " +
      "                        CASE tp.relatedpart   " +
      "                            WHEN 'Y' THEN 'SI'  " +
      "                            ELSE 'NO'  " +
      "                        END AS parte_relacionada, 0.00 AS montoice, a.ad_org_id,   " +
      "                        CASE c.em_sswh_taxidtype  " +
      "                            WHEN 'P' THEN tp.value  " +
      "                            ELSE NULL  " +
      "                        END AS tipo_contrib,   " +
      "                        CASE c.em_sswh_taxidtype  " +
      "                            WHEN 'P' THEN c.name2  " +
      "                            ELSE NULL  " +
      "                        END AS deno_cli,   " +
      "                        CASE sswh_document_ei(g.c_doctype_id)   " +
      "                            WHEN 'Y' THEN 'E'   " +
      "                            ELSE 'F'   " +
      "                        END AS tipo_em, a.documentno, g.em_sswh_afectedzone AS afectedzone, g.em_sswh_code AS afectedzone_code, g.em_sswh_percentage AS afectedzone_percent   " +
      "                   FROM c_invoice a   " +
      "              LEFT JOIN c_bpartner c ON a.c_bpartner_id = c.c_bpartner_id  " +
      "         LEFT JOIN c_invoicetax e ON a.c_invoice_id = e.c_invoice_id  " +
      "    LEFT JOIN c_tax f ON e.c_tax_id = f.c_tax_id  " +
      "   LEFT JOIN c_doctype g ON a.c_doctype_id = g.c_doctype_id  " +
      "   LEFT JOIN sswh_taxpayer tp ON c.em_sswh_taxpayer_id = tp.sswh_taxpayer_id  " +
      "   LEFT JOIN ( SELECT a_1.c_invoice_id, a_1.documentno, a_1.c_bpartner_id, abs(sum(  " +
      "        CASE ffa.em_sswh_withh_type  " +
      "            WHEN 'RW' THEN fft.depositamt  " +
      "            ELSE 0.00  " +
      "        END)) AS monto_ret_renta1, abs(sum(  " +
      "        CASE ffa.em_sswh_withh_type  " +
      "            WHEN 'WV' THEN fft.depositamt  " +
      "            ELSE 0.00  " +
      "        END)) AS monto_ret_iva1, a_1.ad_org_id  " +
      "   FROM c_invoice a_1  " +
      "   LEFT JOIN ssfi_fin_payment_detail_v fpd ON a_1.documentno = fpd.invoiceno  " +
      "   LEFT JOIN fin_finacc_transaction fft ON fft.fin_payment_id = fpd.fin_payment_id  " +
      "   LEFT JOIN fin_financial_account ffa ON ffa.fin_financial_account_id = fpd.fin_financial_account_id  " +
      "  WHERE ffa.em_sswh_withh_type = 'RW' OR ffa.em_sswh_withh_type = 'WV'  " +
      "  GROUP BY a_1.c_invoice_id, a_1.documentno, a_1.c_bpartner_id, a_1.ad_org_id) withhol ON withhol.c_invoice_id = a.c_invoice_id AND withhol.c_bpartner_id = a.c_bpartner_id  " +
      "  WHERE a.issotrx = 'Y' AND a.processed = 'Y' AND a.docstatus <> 'VO' AND g.em_sswh_implementautoriza = 'Y' AND g.isreversal = 'N' AND g.docbasetype = 'ARI' AND (g.em_sswh_doctype = 'I' OR g.em_sswh_doctype = 'C')  " +
      "  GROUP BY c.em_sswh_taxidtype, c.taxid, c.name, g.name, a.dateinvoiced, a.dateacct, a.posted, tp.relatedpart, g.em_sswh_doctype, a.c_invoice_id, a.ad_org_id, tp.value, c.name2, g.c_doctype_id, a.documentno, g.em_sswh_afectedzone, g.em_sswh_code, g.em_sswh_percentage  " +
      "          ) sswh_salesinvoice_nats_v  " +
      "   LEFT JOIN ( SELECT sw.c_invoice_id, sw.c_bpartner_id, sum(   " +
      "                CASE  " +
      "                    WHEN swl.isrental = 'Y' THEN swl.whrentalamt  " +
      "                    ELSE 0  " +
      "                END) AS ws_retencion_renta, sum(  " +
      "                CASE  " +
      "                    WHEN swl.isrental = 'N' THEN swl.whivaamt  " +
      "                    ELSE 0  " +
      "                END) AS ws_retencion_iva  " +
      "           FROM ssws_withholdingsale sw  " +
      "      JOIN ssws_withholdingsaleline swl ON sw.ssws_withholdingsale_id = swl.ssws_withholdingsale_id  " +
      "   JOIN c_tax ct ON ct.c_tax_id = swl.c_tax_id  " +
      "  WHERE sw.processed = 'Y' AND (ct.em_sswh_ats_source = 'Y' OR ct.em_sswh_ats_iva = 'Y')  " +
      "  GROUP BY sw.c_invoice_id, sw.c_bpartner_id) withhsales ON withhsales.c_invoice_id = sswh_salesinvoice_nats_v.c_invoice_id   " +
      "        ) sia  " +
      "        JOIN c_period p ON sia.dateacct BETWEEN p.startdate AND p.enddate  " +
      "        JOIN fin_payment_schedule ps ON ps.c_invoice_id = sia.c_invoice_id  " +
      "        LEFT JOIN ssfi_fin_payment_detail_v pdv ON ps.fin_payment_schedule_id = pdv.fin_payment_sched_inv_id  " +
      "        JOIN fin_paymentmethod pm ON pm.fin_paymentmethod_id = COALESCE(pdv.fin_paymentmethod_id, ps.fin_paymentmethod_id)  " +
      "                WHERE p.c_period_id = ?  " +
      "          AND (sia.ad_org_id = ? or ? is null)  " +
      "          AND sia.identif_cliente = ?  " +
      "        GROUP BY pm.em_sswh_codeats  " +
      "        union all  " +
      "select   " +
      "pm.em_sswh_codeats AS form_of_payment  " +
      "from (SELECT sswh_salesinvoice_nats_v.dateinvoiced, sswh_salesinvoice_nats_v.tipo_identificador, sswh_salesinvoice_nats_v.identif_cliente, sswh_salesinvoice_nats_v.nombre_cliente, sswh_salesinvoice_nats_v.cod_tipo_comprobante, sswh_salesinvoice_nats_v.doctype, sswh_salesinvoice_nats_v.count, sswh_salesinvoice_nats_v.base_no_iva, sswh_salesinvoice_nats_v.base_iva_cero, sswh_salesinvoice_nats_v.base_iva_doce, sswh_salesinvoice_nats_v.monto_iva, sswh_salesinvoice_nats_v.monto_ret_iva1 AS monto_ret_iva, sswh_salesinvoice_nats_v.monto_ret_renta1 AS monto_ret_renta, sswh_salesinvoice_nats_v.dateacct, sswh_salesinvoice_nats_v.posted, sswh_salesinvoice_nats_v.parte_relacionada, sswh_salesinvoice_nats_v.montoice, COALESCE(withhsales.ws_retencion_iva, 0) AS ws_retencion_iva, COALESCE(withhsales.ws_retencion_renta, 0) AS ws_retencion_renta, sswh_salesinvoice_nats_v.c_invoice_id, sswh_salesinvoice_nats_v.ad_org_id, sswh_salesinvoice_nats_v.tipo_contrib, sswh_salesinvoice_nats_v.deno_cli, sswh_salesinvoice_nats_v.tipo_em, sswh_salesinvoice_nats_v.documentno, sswh_salesinvoice_nats_v.afectedzone, sswh_salesinvoice_nats_v.afectedzone_code, sswh_salesinvoice_nats_v.afectedzone_percent  " +
      "   FROM (         SELECT a.c_invoice_id, a.dateinvoiced,   " +
      "                        CASE c.em_sswh_taxidtype " +
      "                            WHEN 'R' THEN '04' " +
      "                            WHEN 'P' THEN '06'  " +
      "                            WHEN 'D' THEN '05'  " +
      "                            WHEN 'C' THEN '07'  " +
      "                            ELSE NULL  " +
      "                        END AS tipo_identificador,   " +
      "                        CASE c.em_sswh_taxidtype  " +
      "                            WHEN 'C' THEN to_char('9999999999999')  " +
      "                            ELSE to_char(c.taxid)  " +
      "                        END AS identif_cliente,   " +
      "                        CASE c.em_sswh_taxidtype  " +
      "                            WHEN 'C' THEN to_char('CF')  " +
      "                            ELSE to_char(c.name)  " +
      "                        END AS nombre_cliente, '18' AS cod_tipo_comprobante, g.name AS doctype, count(DISTINCT a.c_invoice_id) * " +
      "                        CASE " +
      "                            WHEN g.em_sswh_doctype = 'C' THEN 1  " +
      "                            ELSE 1  " +
      "                        END AS count, sum(" +
      "                        CASE f.istaxundeductable  " +
      "                            WHEN 'Y' THEN   " +
      "                            CASE f.rate  " +
      "                                WHEN 0 THEN abs(e.taxbaseamt)  " +
      "                                ELSE 0.00  " +
      "                            END  " +
      "                            ELSE 0.00  " +
      "                        END) AS base_no_iva, sum(  " +
      "                        CASE f.istaxdeductable  " +
      "                            WHEN 'Y' THEN   " +
      "                            CASE f.rate   " +
      "                                WHEN 0 THEN abs(e.taxbaseamt)  " +
      "                                ELSE 0.00  " +
      "                            END  " +
      "                            ELSE 0.00  " +
      "                        END) AS base_iva_cero, sum(  " +
      "                        CASE f.istaxdeductable  " +
      "                            WHEN 'Y' THEN   " +
      "                            CASE  " +
      "                                WHEN f.rate <> 0 THEN abs(e.taxbaseamt)  " +
      "                                ELSE 0.00  " +
      "                            END  " +
      "                            ELSE 0.00  " +
      "                        END) AS base_iva_doce, sum(  " +
      "                        CASE f.istaxdeductable  " +
      "                            WHEN 'Y' THEN   " +
      "                            CASE  " +
      "                                WHEN f.rate <> 0 THEN abs(e.taxamt)  " +
      "                                ELSE 0.00  " +
      "                            END   " +
      "                            ELSE 0.00  " +
      "                        END) AS monto_iva, COALESCE(abs(sum(withhol.monto_ret_iva1)), 0) AS monto_ret_iva1, COALESCE(abs(sum(withhol.monto_ret_renta1)), 0) AS monto_ret_renta1, a.dateacct, a.posted,   " +
      "                        CASE tp.relatedpart   " +
      "                            WHEN 'Y' THEN 'SI'  " +
      "                            ELSE 'NO'  " +
      "                        END AS parte_relacionada, 0.00 AS montoice, a.ad_org_id,   " +
      "                        CASE c.em_sswh_taxidtype  " +
      "                            WHEN 'P' THEN tp.value  " +
      "                            ELSE NULL  " +
      "                        END AS tipo_contrib,   " +
      "                        CASE c.em_sswh_taxidtype  " +
      "                            WHEN 'P' THEN c.name2  " +
      "                            ELSE NULL  " +
      "                        END AS deno_cli,   " +
      "                        CASE sswh_document_ei(g.c_doctype_id)   " +
      "                            WHEN 'Y' THEN 'E'   " +
      "                            ELSE 'F'   " +
      "                        END AS tipo_em, a.documentno, g.em_sswh_afectedzone AS afectedzone, g.em_sswh_code AS afectedzone_code, g.em_sswh_percentage AS afectedzone_percent   " +
      "                   FROM c_invoice a   " +
      "              LEFT JOIN c_bpartner c ON a.c_bpartner_id = c.c_bpartner_id  " +
      "         LEFT JOIN c_invoicetax e ON a.c_invoice_id = e.c_invoice_id  " +
      "    LEFT JOIN c_tax f ON e.c_tax_id = f.c_tax_id  " +
      "   LEFT JOIN c_doctype g ON a.c_doctype_id = g.c_doctype_id  " +
      "   LEFT JOIN sswh_taxpayer tp ON c.em_sswh_taxpayer_id = tp.sswh_taxpayer_id  " +
      "   LEFT JOIN ( SELECT a_1.c_invoice_id, a_1.documentno, a_1.c_bpartner_id, abs(sum(  " +
      "        CASE ffa.em_sswh_withh_type  " +
      "            WHEN 'RW' THEN fft.depositamt  " +
      "            ELSE 0.00  " +
      "        END)) AS monto_ret_renta1, abs(sum(  " +
      "        CASE ffa.em_sswh_withh_type  " +
      "            WHEN 'WV' THEN fft.depositamt  " +
      "            ELSE 0.00  " +
      "        END)) AS monto_ret_iva1, a_1.ad_org_id  " +
      "   FROM c_invoice a_1  " +
      "   LEFT JOIN ssfi_fin_payment_detail_v fpd ON a_1.documentno = fpd.invoiceno  " +
      "   LEFT JOIN fin_finacc_transaction fft ON fft.fin_payment_id = fpd.fin_payment_id  " +
      "   LEFT JOIN fin_financial_account ffa ON ffa.fin_financial_account_id = fpd.fin_financial_account_id  " +
      "  WHERE ffa.em_sswh_withh_type = 'RW' OR ffa.em_sswh_withh_type = 'WV'  " +
      "  GROUP BY a_1.c_invoice_id, a_1.documentno, a_1.c_bpartner_id, a_1.ad_org_id) withhol ON withhol.c_invoice_id = a.c_invoice_id AND withhol.c_bpartner_id = a.c_bpartner_id  " +
      "  WHERE a.issotrx = 'Y' AND a.processed = 'Y' AND a.docstatus <> 'VO' AND g.em_sswh_implementautoriza = 'Y' AND g.isreversal = 'N' AND g.docbasetype = 'ARI' AND (g.em_sswh_doctype = 'I' OR g.em_sswh_doctype = 'C')  " +
      "  GROUP BY c.em_sswh_taxidtype, c.taxid, c.name, g.name, a.dateinvoiced, a.dateacct, a.posted, tp.relatedpart, g.em_sswh_doctype, a.c_invoice_id, a.ad_org_id, tp.value, c.name2, g.c_doctype_id, a.documentno, g.em_sswh_afectedzone, g.em_sswh_code, g.em_sswh_percentage  " +
      "          ) sswh_salesinvoice_nats_v  " +
      "   LEFT JOIN ( SELECT sw.c_invoice_id, sw.c_bpartner_id, sum(   " +
      "                CASE  " +
      "                    WHEN swl.isrental = 'Y' THEN swl.whrentalamt  " +
      "                    ELSE 0  " +
      "                END) AS ws_retencion_renta, sum(  " +
      "                CASE  " +
      "                    WHEN swl.isrental = 'N' THEN swl.whivaamt  " +
      "                    ELSE 0  " +
      "                END) AS ws_retencion_iva  " +
      "           FROM ssws_withholdingsale sw  " +
      "      JOIN ssws_withholdingsaleline swl ON sw.ssws_withholdingsale_id = swl.ssws_withholdingsale_id  " +
      "   JOIN c_tax ct ON ct.c_tax_id = swl.c_tax_id  " +
      "  WHERE sw.processed = 'Y' AND (ct.em_sswh_ats_source = 'Y' OR ct.em_sswh_ats_iva = 'Y')  " +
      "  GROUP BY sw.c_invoice_id, sw.c_bpartner_id) withhsales ON withhsales.c_invoice_id = sswh_salesinvoice_nats_v.c_invoice_id   " +
      ") sia  " +
      "    JOIN c_period p ON sia.dateacct BETWEEN p.startdate AND p.enddate " +
      "    JOIN fin_payment_schedule ps ON ps.c_invoice_id = sia.c_invoice_id  " +
      "        LEFT JOIN ssfi_fin_payment_detail_v pdv ON ps.fin_payment_schedule_id = pdv.fin_payment_sched_inv_id  " +
      "        JOIN fin_paymentmethod pm ON pm.fin_paymentmethod_id = COALESCE(pdv.fin_paymentmethod_id, ps.fin_paymentmethod_id)  " +
      "    where ps.outstandingamt>0        " +
      "    AND p.c_period_id = ?  " +
      "    AND (sia.ad_org_id = ? or ? is null)  " +
      "        AND sia.identif_cliente = ?  " +
      "        GROUP BY pm.em_sswh_codeats  " +
      ") form_of_payment   " +
      "where form_of_payment is not null  " +
      "group by form_of_payment";

    ResultSet result;
    Vector<SswhRptcSalesPayFormData> vector = new Vector<SswhRptcSalesPayFormData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, periodId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, OrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, OrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, identCli);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, periodId2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, OrgId2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, OrgId2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, identCli2);

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
        SswhRptcSalesPayFormData objectSswhRptcSalesPayFormData = new SswhRptcSalesPayFormData();
        objectSswhRptcSalesPayFormData.formOfPayment = UtilSql.getValue(result, "form_of_payment");
        objectSswhRptcSalesPayFormData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSswhRptcSalesPayFormData);
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
    SswhRptcSalesPayFormData objectSswhRptcSalesPayFormData[] = new SswhRptcSalesPayFormData[vector.size()];
    vector.copyInto(objectSswhRptcSalesPayFormData);
    return(objectSswhRptcSalesPayFormData);
  }
}
