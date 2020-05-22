//Sqlc generated V1.O00-1
package com.sidesoft.localization.ecuador.withholdings.reports;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class RptWithholdingStatementData implements FieldProvider {
static Logger log4j = Logger.getLogger(RptWithholdingStatementData.class);
  private String InitRecordNumber="0";
  public String cInvoiceId;
  public String organizationid;
  public String organizationTaxid;
  public String organizationAddress;
  public String organizationId;
  public String nameOrg;
  public String socialNameOrg;
  public String bpLanguage;
  public String idpartner;
  public String client;
  public String address;
  public String referenceno;
  public String fiscalname;
  public String taxid;
  public String documentno;
  public String datewithholding;
  public String yearWithholding;
  public String vatname;
  public String emSswhWithholdingref;
  public String emSswhAuthorization;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_invoice_id") || fieldName.equals("cInvoiceId"))
      return cInvoiceId;
    else if (fieldName.equalsIgnoreCase("organizationid"))
      return organizationid;
    else if (fieldName.equalsIgnoreCase("organization_taxid") || fieldName.equals("organizationTaxid"))
      return organizationTaxid;
    else if (fieldName.equalsIgnoreCase("organization_address") || fieldName.equals("organizationAddress"))
      return organizationAddress;
    else if (fieldName.equalsIgnoreCase("organization_id") || fieldName.equals("organizationId"))
      return organizationId;
    else if (fieldName.equalsIgnoreCase("name_org") || fieldName.equals("nameOrg"))
      return nameOrg;
    else if (fieldName.equalsIgnoreCase("social_name_org") || fieldName.equals("socialNameOrg"))
      return socialNameOrg;
    else if (fieldName.equalsIgnoreCase("bp_language") || fieldName.equals("bpLanguage"))
      return bpLanguage;
    else if (fieldName.equalsIgnoreCase("idpartner"))
      return idpartner;
    else if (fieldName.equalsIgnoreCase("client"))
      return client;
    else if (fieldName.equalsIgnoreCase("address"))
      return address;
    else if (fieldName.equalsIgnoreCase("referenceno"))
      return referenceno;
    else if (fieldName.equalsIgnoreCase("fiscalname"))
      return fiscalname;
    else if (fieldName.equalsIgnoreCase("taxid"))
      return taxid;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("datewithholding"))
      return datewithholding;
    else if (fieldName.equalsIgnoreCase("year_withholding") || fieldName.equals("yearWithholding"))
      return yearWithholding;
    else if (fieldName.equalsIgnoreCase("vatname"))
      return vatname;
    else if (fieldName.equalsIgnoreCase("em_sswh_withholdingref") || fieldName.equals("emSswhWithholdingref"))
      return emSswhWithholdingref;
    else if (fieldName.equalsIgnoreCase("em_sswh_authorization") || fieldName.equals("emSswhAuthorization"))
      return emSswhAuthorization;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static RptWithholdingStatementData[] select(ConnectionProvider connectionProvider, String invoice)    throws ServletException {
    return select(connectionProvider, invoice, 0, 0);
  }

  public static RptWithholdingStatementData[] select(ConnectionProvider connectionProvider, String invoice, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "SELECT i.c_invoice_id," +
      " i.ad_org_id as organizationid," +
      " aoi.taxid as organization_taxid," +
      " coalesce(to_char(clo.address1),to_char(clo.address2)) as organization_address," +
      " i.ad_org_id as organization_id," +
      " org.name AS name_org,org.social_name as  social_name_org,bp.AD_language as bp_language,bp.c_bpartner_id as idpartner" +
      " ,bp.name as client,cl.address1 as address,i.poreference as referenceno,bp.name2 AS fiscalname," +
      " bp.taxid, i.documentno,to_char(i.em_sswh_datewithhold) AS datewithholding," +
      "to_char(i.em_sswh_datewithhold,'yyyy') as year_withholding, TO_CHAR('') AS vatname," +
      " i.em_sswh_withholdingref, i.em_sswh_authorization FROM C_INVOICE i" +
      "  LEFT JOIN C_INVOICELINE il ON il.C_INVOICE_ID = i.C_INVOICE_ID" +
      " LEFT JOIN C_BPARTNER bp ON i.C_BPARTNER_ID = bp.C_BPARTNER_ID" +
      " LEFT JOIN c_bpartner_location cbl on cbl.c_bpartner_id = bp.c_bpartner_id and cbl.isbillto = 'Y'" +
      " LEFT JOIN c_location cl on cl.c_location_id = cbl.c_location_id" +
      " LEFT JOIN AD_ORG ORG ON ORG.AD_ORG_ID = I.AD_ORG_ID" +
      " LEFT JOIN ad_orginfo aoi on aoi.ad_org_id = i.ad_org_id" +
      " LEFT JOIN c_location clo on clo.c_location_id = aoi.c_location_id" +
      " WHERE i.C_INVOICE_ID = ?";

    ResultSet result;
    Vector<RptWithholdingStatementData> vector = new Vector<RptWithholdingStatementData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoice);

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
        RptWithholdingStatementData objectRptWithholdingStatementData = new RptWithholdingStatementData();
        objectRptWithholdingStatementData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectRptWithholdingStatementData.organizationid = UtilSql.getValue(result, "organizationid");
        objectRptWithholdingStatementData.organizationTaxid = UtilSql.getValue(result, "organization_taxid");
        objectRptWithholdingStatementData.organizationAddress = UtilSql.getValue(result, "organization_address");
        objectRptWithholdingStatementData.organizationId = UtilSql.getValue(result, "organization_id");
        objectRptWithholdingStatementData.nameOrg = UtilSql.getValue(result, "name_org");
        objectRptWithholdingStatementData.socialNameOrg = UtilSql.getValue(result, "social_name_org");
        objectRptWithholdingStatementData.bpLanguage = UtilSql.getValue(result, "bp_language");
        objectRptWithholdingStatementData.idpartner = UtilSql.getValue(result, "idpartner");
        objectRptWithholdingStatementData.client = UtilSql.getValue(result, "client");
        objectRptWithholdingStatementData.address = UtilSql.getValue(result, "address");
        objectRptWithholdingStatementData.referenceno = UtilSql.getValue(result, "referenceno");
        objectRptWithholdingStatementData.fiscalname = UtilSql.getValue(result, "fiscalname");
        objectRptWithholdingStatementData.taxid = UtilSql.getValue(result, "taxid");
        objectRptWithholdingStatementData.documentno = UtilSql.getValue(result, "documentno");
        objectRptWithholdingStatementData.datewithholding = UtilSql.getValue(result, "datewithholding");
        objectRptWithholdingStatementData.yearWithholding = UtilSql.getValue(result, "year_withholding");
        objectRptWithholdingStatementData.vatname = UtilSql.getValue(result, "vatname");
        objectRptWithholdingStatementData.emSswhWithholdingref = UtilSql.getValue(result, "em_sswh_withholdingref");
        objectRptWithholdingStatementData.emSswhAuthorization = UtilSql.getValue(result, "em_sswh_authorization");
        objectRptWithholdingStatementData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptWithholdingStatementData);
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
    RptWithholdingStatementData objectRptWithholdingStatementData[] = new RptWithholdingStatementData[vector.size()];
    vector.copyInto(objectRptWithholdingStatementData);
    return(objectRptWithholdingStatementData);
  }

  public static RptWithholdingStatementData[] set()    throws ServletException {
    RptWithholdingStatementData objectRptWithholdingStatementData[] = new RptWithholdingStatementData[1];
    objectRptWithholdingStatementData[0] = new RptWithholdingStatementData();
    objectRptWithholdingStatementData[0].cInvoiceId = "";
    objectRptWithholdingStatementData[0].organizationid = "";
    objectRptWithholdingStatementData[0].organizationTaxid = "";
    objectRptWithholdingStatementData[0].organizationAddress = "";
    objectRptWithholdingStatementData[0].organizationId = "";
    objectRptWithholdingStatementData[0].nameOrg = "";
    objectRptWithholdingStatementData[0].socialNameOrg = "";
    objectRptWithholdingStatementData[0].bpLanguage = "";
    objectRptWithholdingStatementData[0].idpartner = "";
    objectRptWithholdingStatementData[0].client = "";
    objectRptWithholdingStatementData[0].address = "";
    objectRptWithholdingStatementData[0].referenceno = "";
    objectRptWithholdingStatementData[0].fiscalname = "";
    objectRptWithholdingStatementData[0].taxid = "";
    objectRptWithholdingStatementData[0].documentno = "";
    objectRptWithholdingStatementData[0].datewithholding = "";
    objectRptWithholdingStatementData[0].yearWithholding = "";
    objectRptWithholdingStatementData[0].vatname = "";
    objectRptWithholdingStatementData[0].emSswhWithholdingref = "";
    objectRptWithholdingStatementData[0].emSswhAuthorization = "";
    return objectRptWithholdingStatementData;
  }
}
