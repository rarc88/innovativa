//Sqlc generated V1.O00-1
package com.sidesoft.flopec.reportjournal;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class ReportGeneralLedgerJournalData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportGeneralLedgerJournalData.class);
  private String InitRecordNumber="0";
  public String namedocbasetype;
  public String organization;
  public String partnerName;
  public String invoicedocumentno;
  public String documentnom;
  public String invoiceDescription;
  public String dateinvoiced;
  public String withholdingReference;
  public String grandtotal;
  public String schemaId;
  public String schemaName;
  public String identifier;
  public String dateacct;
  public String value;
  public String name;
  public String combination;
  public String id;
  public String adTableId;
  public String docbasetype;
  public String seqno;
  public String total;
  public String description;
  public String factaccttype2;
  public String amtacctdr;
  public String amtacctcr;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("namedocbasetype"))
      return namedocbasetype;
    else if (fieldName.equalsIgnoreCase("organization"))
      return organization;
    else if (fieldName.equalsIgnoreCase("partner_name") || fieldName.equals("partnerName"))
      return partnerName;
    else if (fieldName.equalsIgnoreCase("invoicedocumentno"))
      return invoicedocumentno;
    else if (fieldName.equalsIgnoreCase("documentnom"))
      return documentnom;
    else if (fieldName.equalsIgnoreCase("invoice_description") || fieldName.equals("invoiceDescription"))
      return invoiceDescription;
    else if (fieldName.equalsIgnoreCase("dateinvoiced"))
      return dateinvoiced;
    else if (fieldName.equalsIgnoreCase("withholding_reference") || fieldName.equals("withholdingReference"))
      return withholdingReference;
    else if (fieldName.equalsIgnoreCase("grandtotal"))
      return grandtotal;
    else if (fieldName.equalsIgnoreCase("schema_id") || fieldName.equals("schemaId"))
      return schemaId;
    else if (fieldName.equalsIgnoreCase("schema_name") || fieldName.equals("schemaName"))
      return schemaName;
    else if (fieldName.equalsIgnoreCase("identifier"))
      return identifier;
    else if (fieldName.equalsIgnoreCase("dateacct"))
      return dateacct;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("combination"))
      return combination;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("ad_table_id") || fieldName.equals("adTableId"))
      return adTableId;
    else if (fieldName.equalsIgnoreCase("docbasetype"))
      return docbasetype;
    else if (fieldName.equalsIgnoreCase("seqno"))
      return seqno;
    else if (fieldName.equalsIgnoreCase("total"))
      return total;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("factaccttype2"))
      return factaccttype2;
    else if (fieldName.equalsIgnoreCase("amtacctdr"))
      return amtacctdr;
    else if (fieldName.equalsIgnoreCase("amtacctcr"))
      return amtacctcr;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportGeneralLedgerJournalData[] select(ConnectionProvider connectionProvider, String invoice, String language)    throws ServletException {
    return select(connectionProvider, invoice, language, 0, 0);
  }

  public static ReportGeneralLedgerJournalData[] select(ConnectionProvider connectionProvider, String invoice, String language, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "SELECT NAMEDOCBASETYPE,ORGANIZATION,PARTNER_NAME,INVOICEDOCUMENTNO,DOCUMENTNOM,INVOICE_DESCRIPTION," +
      "DATEINVOICED,WITHHOLDING_REFERENCE,GRANDTOTAL," +
      "SCHEMA_ID,SCHEMA_NAME,IDENTIFIER,DATEACCT,VALUE,NAME,combination,ID,AD_TABLE_ID," +
      "DOCBASETYPE,SEQNO,TOTAL," +
      "(COALESCE(TO_CHAR(costcenter),'') || '-' || COALESCE(TO_CHAR(user1),'')) AS DESCRIPTION," +
      "FACTACCTTYPE2,AMTACCTDR,AMTACCTCR" +
      " FROM (" +
      "      SELECT coalesce(ARLT.NAME,ARL.NAME) AS NAMEDOCBASETYPE,AD.NAME AS ORGANIZATION,'' AS DOCNAME,CBP.NAME AS PARTNER_NAME,CI.DOCUMENTNO AS INVOICEDOCUMENTNO,CI.poreference as DOCUMENTNOM," +
      "      CI.DESCRIPTION AS INVOICE_DESCRIPTION,to_char(CI.DATEACCT) as DATEINVOICED," +
      "      CASE WHEN CI.ISSOTRX='N' THEN CI.EM_Sswh_Withholdingref WHEN CI.ISSOTRX='Y' THEN 'N/A' END AS WITHHOLDING_REFERENCE," +
      "      CI.GRANDTOTAL AS GRANDTOTAL," +
      "      AA.SCHEMA_ID, AA.SCHEMA_NAME, AA.IDENTIFIER, AA.DATEACCT, AA.VALUE, AA.NAME, aa.combination, AA.ID," +
      "      AA.AD_TABLE_ID, AA.DOCBASETYPE, AA.SEQNO, '' AS TOTAL, '' AS DESCRIPTION," +
      "      (CASE FACTACCTTYPE WHEN 'O' THEN 1 WHEN 'N' THEN 2 WHEN 'R' THEN 3 ELSE 4 END) AS FACTACCTTYPE2," +
      "      (CASE AMTACCTDR WHEN 0 THEN NULL ELSE AMTACCTDR END) AS AMTACCTDR, (CASE AMTACCTCR WHEN 0 THEN NULL ELSE AMTACCTCR END) AS AMTACCTCR" +
      "      ,AA.costcenter,AA.user1" +
      "      FROM" +
      "      (" +
      "        SELECT" +
      "        F.RECORD_ID,F.C_ACCTSCHEMA_ID AS SCHEMA_ID, SC.NAME AS SCHEMA_NAME, F.FACT_ACCT_GROUP_ID AS IDENTIFIER, to_char(F.DATEACCT) as DATEACCT," +
      "        F.ACCTVALUE AS VALUE," +
      "        vc.combination," +
      "        F.ACCTDESCRIPTION || F.DESCRIPTION AS NAME,F.RECORD_ID AS ID, F.AD_TABLE_ID, F.DOCBASETYPE," +
      "        sum(F.AMTACCTDR) AS AMTACCTDR, sum(F.AMTACCTCR) AS AMTACCTCR, MIN(SEQNO) AS SEQNO, F.FACTACCTTYPE AS FACTACCTTYPE," +
      "        (select name from c_costcenter where c_costcenter_id= F.c_costcenter_id) as costcenter," +
      "        (select name from user1 where user1_id= F.user1_id) as user1" +
      "        FROM FACT_ACCT F" +
      "        join C_ACCTSCHEMA SC on f.C_ACCTSCHEMA_ID = SC.C_ACCTSCHEMA_ID" +
      "        left join fin_payment_schedule ps on ps.fin_payment_schedule_id = f.line_id" +
      "        left join c_costcenter cc on cc.c_costcenter_id = f.c_costcenter_id and ps.fin_payment_schedule_id is not null" +
      "        left join c_validcombination vc on vc.c_validcombination_id = cc.em_ssfl_validcombination_id" +
      "        WHERE F.RECORD_ID = ?" +
      "        GROUP BY F.RECORD_ID,f.C_ACCTSCHEMA_ID, SC.NAME, F.AD_TABLE_ID, F.DATEACCT, F.ACCTDESCRIPTION || F.DESCRIPTION, F.ACCTVALUE, vc.combination, F.DOCBASETYPE, F.RECORD_ID," +
      "        F.FACT_ACCT_GROUP_ID, F.ACCOUNT_ID,F.FACTACCTTYPE,F.c_costcenter_id,F.user1_id," +
      "        (CASE F.AMTACCTDR WHEN 0 THEN (CASE SIGN(F.AMTACCTCR) WHEN -1 THEN 1 ELSE 2 END) ELSE (CASE SIGN(F.AMTACCTDR)" +
      "        WHEN -1 THEN 3 ELSE 4 END) END)) AA" +
      "      LEFT JOIN C_INVOICE CI ON CI.C_INVOICE_ID = AA.RECORD_ID" +
      "      LEFT JOIN C_BPARTNER CBP ON CBP.C_BPARTNER_ID = CI.C_BPARTNER_ID" +
      "      LEFT JOIN AD_ORG AD ON AD.AD_ORG_ID = CI.AD_ORG_ID" +
      "      LEFT JOIN C_DOCTYPE CDT ON CDT.C_DOCTYPE_ID = CI.C_DOCTYPE_ID" +
      "      LEFT JOIN AD_REF_LIST ARL ON (ARL.VALUE = CDT.DOCBASETYPE AND ARL.AD_REFERENCE_ID = '183')" +
      "      LEFT JOIN AD_REF_LIST_TRL ARLT ON  (ARLT.AD_REF_LIST_ID = ARL.AD_REF_LIST_ID AND ARLT.AD_LANGUAGE= ? )" +
      "      WHERE CI.DOCSTATUS = 'CO'" +
      "      ) BB" +
      "      ORDER BY BB.SCHEMA_NAME, BB.DATEACCT, BB.IDENTIFIER, BB.SEQNO";

    ResultSet result;
    Vector<ReportGeneralLedgerJournalData> vector = new Vector<ReportGeneralLedgerJournalData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);

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
        ReportGeneralLedgerJournalData objectReportGeneralLedgerJournalData = new ReportGeneralLedgerJournalData();
        objectReportGeneralLedgerJournalData.namedocbasetype = UtilSql.getValue(result, "namedocbasetype");
        objectReportGeneralLedgerJournalData.organization = UtilSql.getValue(result, "organization");
        objectReportGeneralLedgerJournalData.partnerName = UtilSql.getValue(result, "partner_name");
        objectReportGeneralLedgerJournalData.invoicedocumentno = UtilSql.getValue(result, "invoicedocumentno");
        objectReportGeneralLedgerJournalData.documentnom = UtilSql.getValue(result, "documentnom");
        objectReportGeneralLedgerJournalData.invoiceDescription = UtilSql.getValue(result, "invoice_description");
        objectReportGeneralLedgerJournalData.dateinvoiced = UtilSql.getValue(result, "dateinvoiced");
        objectReportGeneralLedgerJournalData.withholdingReference = UtilSql.getValue(result, "withholding_reference");
        objectReportGeneralLedgerJournalData.grandtotal = UtilSql.getValue(result, "grandtotal");
        objectReportGeneralLedgerJournalData.schemaId = UtilSql.getValue(result, "schema_id");
        objectReportGeneralLedgerJournalData.schemaName = UtilSql.getValue(result, "schema_name");
        objectReportGeneralLedgerJournalData.identifier = UtilSql.getValue(result, "identifier");
        objectReportGeneralLedgerJournalData.dateacct = UtilSql.getValue(result, "dateacct");
        objectReportGeneralLedgerJournalData.value = UtilSql.getValue(result, "value");
        objectReportGeneralLedgerJournalData.name = UtilSql.getValue(result, "name");
        objectReportGeneralLedgerJournalData.combination = UtilSql.getValue(result, "combination");
        objectReportGeneralLedgerJournalData.id = UtilSql.getValue(result, "id");
        objectReportGeneralLedgerJournalData.adTableId = UtilSql.getValue(result, "ad_table_id");
        objectReportGeneralLedgerJournalData.docbasetype = UtilSql.getValue(result, "docbasetype");
        objectReportGeneralLedgerJournalData.seqno = UtilSql.getValue(result, "seqno");
        objectReportGeneralLedgerJournalData.total = UtilSql.getValue(result, "total");
        objectReportGeneralLedgerJournalData.description = UtilSql.getValue(result, "description");
        objectReportGeneralLedgerJournalData.factaccttype2 = UtilSql.getValue(result, "factaccttype2");
        objectReportGeneralLedgerJournalData.amtacctdr = UtilSql.getValue(result, "amtacctdr");
        objectReportGeneralLedgerJournalData.amtacctcr = UtilSql.getValue(result, "amtacctcr");
        objectReportGeneralLedgerJournalData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportGeneralLedgerJournalData);
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
    ReportGeneralLedgerJournalData objectReportGeneralLedgerJournalData[] = new ReportGeneralLedgerJournalData[vector.size()];
    vector.copyInto(objectReportGeneralLedgerJournalData);
    return(objectReportGeneralLedgerJournalData);
  }

  public static ReportGeneralLedgerJournalData[] set()    throws ServletException {
    ReportGeneralLedgerJournalData objectReportGeneralLedgerJournalData[] = new ReportGeneralLedgerJournalData[1];
    objectReportGeneralLedgerJournalData[0] = new ReportGeneralLedgerJournalData();
    objectReportGeneralLedgerJournalData[0].namedocbasetype = "";
    objectReportGeneralLedgerJournalData[0].organization = "";
    objectReportGeneralLedgerJournalData[0].partnerName = "";
    objectReportGeneralLedgerJournalData[0].invoicedocumentno = "";
    objectReportGeneralLedgerJournalData[0].documentnom = "";
    objectReportGeneralLedgerJournalData[0].invoiceDescription = "";
    objectReportGeneralLedgerJournalData[0].dateinvoiced = "";
    objectReportGeneralLedgerJournalData[0].withholdingReference = "";
    objectReportGeneralLedgerJournalData[0].grandtotal = "";
    objectReportGeneralLedgerJournalData[0].schemaId = "";
    objectReportGeneralLedgerJournalData[0].schemaName = "";
    objectReportGeneralLedgerJournalData[0].identifier = "";
    objectReportGeneralLedgerJournalData[0].dateacct = "";
    objectReportGeneralLedgerJournalData[0].value = "";
    objectReportGeneralLedgerJournalData[0].name = "";
    objectReportGeneralLedgerJournalData[0].combination = "";
    objectReportGeneralLedgerJournalData[0].id = "";
    objectReportGeneralLedgerJournalData[0].adTableId = "";
    objectReportGeneralLedgerJournalData[0].docbasetype = "";
    objectReportGeneralLedgerJournalData[0].seqno = "";
    objectReportGeneralLedgerJournalData[0].total = "";
    objectReportGeneralLedgerJournalData[0].description = "";
    objectReportGeneralLedgerJournalData[0].factaccttype2 = "";
    objectReportGeneralLedgerJournalData[0].amtacctdr = "";
    objectReportGeneralLedgerJournalData[0].amtacctcr = "";
    return objectReportGeneralLedgerJournalData;
  }
}
