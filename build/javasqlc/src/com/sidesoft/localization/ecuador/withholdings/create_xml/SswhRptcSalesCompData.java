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

public class SswhRptcSalesCompData implements FieldProvider {
static Logger log4j = Logger.getLogger(SswhRptcSalesCompData.class);
  private String InitRecordNumber="0";
  public String compType;
  public String compensatedAmount;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("comp_type") || fieldName.equals("compType"))
      return compType;
    else if (fieldName.equalsIgnoreCase("compensated_amount") || fieldName.equals("compensatedAmount"))
      return compensatedAmount;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SswhRptcSalesCompData[] select(ConnectionProvider connectionProvider, String periodId, String OrgId, String identCli, String periodId2, String OrgId2, String identCli2, String periodId3, String OrgId3, String identCli3)    throws ServletException {
    return select(connectionProvider, periodId, OrgId, identCli, periodId2, OrgId2, identCli2, periodId3, OrgId3, identCli3, 0, 0);
  }

  public static SswhRptcSalesCompData[] select(ConnectionProvider connectionProvider, String periodId, String OrgId, String identCli, String periodId2, String OrgId2, String identCli2, String periodId3, String OrgId3, String identCli3, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select " +
      "comp_type" +
      ",round(sum(compensated_amount),2) as compensated_amount " +
      "from  " +
      "(" +
      "      SELECT  sia.afectedzone_code AS comp_type, sum(sia.monto_iva * COALESCE(sia.afectedzone_percent, 100) / 100) AS compensated_amount" +
      "        FROM sswh_salesinvoice_nats sia" +
      "        JOIN c_period p ON sia.dateacct BETWEEN p.startdate AND p.enddate" +
      "        WHERE sia.afectedzone = 'Y'" +
      "          AND p.c_period_id = ?" +
      "          AND (sia.ad_org_id = ? or ? is null)" +
      "          AND sia.identif_cliente = ?" +
      "        GROUP BY sia.afectedzone_code" +
      "        UNION ALL" +
      "        select " +
      "        comp_type" +
      "        ,sum(compensated_amount)" +
      "        from" +
      "        (" +
      "        SELECT  pm.em_sswh_code AS comp_type,sum(((sia.monto_iva *ps.paidamt)/i.grandtotal)  * COALESCE(pm.em_sswh_percentage, 100) / 100) AS compensated_amount" +
      "        FROM sswh_salesinvoice_nats sia" +
      "        JOIN c_period p ON sia.dateacct BETWEEN p.startdate AND p.enddate" +
      "        JOIN c_invoice i ON sia.c_invoice_id = i.c_invoice_id" +
      "        JOIN fin_payment_schedule ps ON ps.c_invoice_id = sia.c_invoice_id" +
      "        LEFT JOIN ssfi_fin_payment_detail_v pdv ON ps.fin_payment_schedule_id = pdv.fin_payment_sched_inv_id" +
      "        JOIN fin_paymentmethod pm ON pm.fin_paymentmethod_id = COALESCE(pdv.fin_paymentmethod_id, ps.fin_paymentmethod_id)" +
      "        WHERE pm.em_sswh_electronicmoney = 'Y'" +
      "        AND p.c_period_id = ?" +
      "        AND (sia.ad_org_id = ? or ? is null)" +
      "        AND sia.identif_cliente = ?" +
      "        GROUP BY pm.em_sswh_code" +
      "    union all" +
      "        SELECT  pm.em_sswh_code AS comp_type,sum(((sia.monto_iva *ps.outstandingamt)/i.grandtotal)  * COALESCE(pm.em_sswh_percentage, 100) / 100) AS compensated_amount" +
      "        FROM sswh_salesinvoice_nats sia" +
      "        JOIN c_period p ON sia.dateacct BETWEEN p.startdate AND p.enddate" +
      "        JOIN c_invoice i ON sia.c_invoice_id = i.c_invoice_id" +
      "        JOIN fin_payment_schedule ps ON ps.c_invoice_id = sia.c_invoice_id" +
      "        LEFT JOIN ssfi_fin_payment_detail_v pdv ON ps.fin_payment_schedule_id = pdv.fin_payment_sched_inv_id" +
      "        JOIN fin_paymentmethod pm ON pm.fin_paymentmethod_id = COALESCE(pdv.fin_paymentmethod_id, ps.fin_paymentmethod_id)" +
      "        WHERE pm.em_sswh_electronicmoney = 'Y'" +
      "        and ps.outstandingamt<>0      " +
      "    AND p.c_period_id = ?" +
      "    AND (sia.ad_org_id = ? or ? is null)" +
      "        AND sia.identif_cliente = ?" +
      "        GROUP BY pm.em_sswh_code" +
      "        ) compen" +
      "        group by" +
      "        comp_type" +
      "        ,compensated_amount" +
      ") payform    " +
      "group by comp_type   " +
      "order by comp_type     ";

    ResultSet result;
    Vector<SswhRptcSalesCompData> vector = new Vector<SswhRptcSalesCompData>(0);
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, periodId3);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, OrgId3);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, OrgId3);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, identCli3);

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
        SswhRptcSalesCompData objectSswhRptcSalesCompData = new SswhRptcSalesCompData();
        objectSswhRptcSalesCompData.compType = UtilSql.getValue(result, "comp_type");
        objectSswhRptcSalesCompData.compensatedAmount = UtilSql.getValue(result, "compensated_amount");
        objectSswhRptcSalesCompData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSswhRptcSalesCompData);
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
    SswhRptcSalesCompData objectSswhRptcSalesCompData[] = new SswhRptcSalesCompData[vector.size()];
    vector.copyInto(objectSswhRptcSalesCompData);
    return(objectSswhRptcSalesCompData);
  }
}
