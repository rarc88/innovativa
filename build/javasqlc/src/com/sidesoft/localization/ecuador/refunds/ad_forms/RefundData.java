//Sqlc generated V1.O00-1
package com.sidesoft.localization.ecuador.refunds.ad_forms;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;
import org.openbravo.database.RDBMSIndependent;
import org.openbravo.exception.*;

class RefundData implements FieldProvider {
static Logger log4j = Logger.getLogger(RefundData.class);
  private String InitRecordNumber="0";
  public String mAttributesetinstanceId;
  public String finPaymentmethodId;
  public String paymentrule;
  public String cPaymenttermId;
  public String qtyinvoiced;
  public String grandtotal;
  public String cInvoiceId;
  public String documentno;
  public String poreference;
  public String mPricelistId;
  public String dateinvoiced;
  public String mProductId;
  public String customerId;
  public String customer;
  public String vendor;
  public String product;
  public String requester;
  public String pricelistid;
  public String adOrgId;
  public String org;
  public String description;
  public String quantity;
  public String discount;
  public String tax;
  public String uomname;
  public String cUomId;
  public String rownum;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("m_attributesetinstance_id") || fieldName.equals("mAttributesetinstanceId"))
      return mAttributesetinstanceId;
    else if (fieldName.equalsIgnoreCase("fin_paymentmethod_id") || fieldName.equals("finPaymentmethodId"))
      return finPaymentmethodId;
    else if (fieldName.equalsIgnoreCase("paymentrule"))
      return paymentrule;
    else if (fieldName.equalsIgnoreCase("c_paymentterm_id") || fieldName.equals("cPaymenttermId"))
      return cPaymenttermId;
    else if (fieldName.equalsIgnoreCase("qtyinvoiced"))
      return qtyinvoiced;
    else if (fieldName.equalsIgnoreCase("grandtotal"))
      return grandtotal;
    else if (fieldName.equalsIgnoreCase("c_invoice_id") || fieldName.equals("cInvoiceId"))
      return cInvoiceId;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("poreference"))
      return poreference;
    else if (fieldName.equalsIgnoreCase("m_pricelist_id") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("dateinvoiced"))
      return dateinvoiced;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("customer_id") || fieldName.equals("customerId"))
      return customerId;
    else if (fieldName.equalsIgnoreCase("customer"))
      return customer;
    else if (fieldName.equalsIgnoreCase("vendor"))
      return vendor;
    else if (fieldName.equalsIgnoreCase("product"))
      return product;
    else if (fieldName.equalsIgnoreCase("requester"))
      return requester;
    else if (fieldName.equalsIgnoreCase("pricelistid"))
      return pricelistid;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("org"))
      return org;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("quantity"))
      return quantity;
    else if (fieldName.equalsIgnoreCase("discount"))
      return discount;
    else if (fieldName.equalsIgnoreCase("tax"))
      return tax;
    else if (fieldName.equalsIgnoreCase("uomname"))
      return uomname;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equals("rownum"))
      return rownum;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static RefundData[] select(ConnectionProvider connectionProvider)    throws ServletException {
    return select(connectionProvider, 0, 0);
  }

  public static RefundData[] select(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT '' AS M_ATTRIBUTESETINSTANCE_ID, '' AS FIN_PAYMENTMETHOD_ID, '' AS PAYMENTRULE, '' AS C_PAYMENTTERM_ID, '' AS QTYINVOICED, " +
      "          '' AS GRANDTOTAL, '' AS C_INVOICE_ID, '' AS DOCUMENTNO, '' AS POREFERENCE, " +
      "          '' AS M_PRICELIST_ID, '' AS DATEINVOICED," +
      "          '' AS M_PRODUCT_ID, '' AS CUSTOMER_ID, '' AS CUSTOMER, '' AS VENDOR, '' AS PRODUCT, ''  AS REQUESTER," +
      "          '' AS PRICELISTID, '' AS AD_ORG_ID, '' AS ORG, '' AS DESCRIPTION,'' AS QUANTITY," +
      "          '' AS DISCOUNT, '' AS TAX, '' AS UOMNAME, '' AS C_UOM_ID" +
      "        FROM DUAL";

    ResultSet result;
    Vector<RefundData> vector = new Vector<RefundData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());

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
        RefundData objectRefundData = new RefundData();
        objectRefundData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectRefundData.finPaymentmethodId = UtilSql.getValue(result, "fin_paymentmethod_id");
        objectRefundData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectRefundData.cPaymenttermId = UtilSql.getValue(result, "c_paymentterm_id");
        objectRefundData.qtyinvoiced = UtilSql.getValue(result, "qtyinvoiced");
        objectRefundData.grandtotal = UtilSql.getValue(result, "grandtotal");
        objectRefundData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectRefundData.documentno = UtilSql.getValue(result, "documentno");
        objectRefundData.poreference = UtilSql.getValue(result, "poreference");
        objectRefundData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectRefundData.dateinvoiced = UtilSql.getValue(result, "dateinvoiced");
        objectRefundData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectRefundData.customerId = UtilSql.getValue(result, "customer_id");
        objectRefundData.customer = UtilSql.getValue(result, "customer");
        objectRefundData.vendor = UtilSql.getValue(result, "vendor");
        objectRefundData.product = UtilSql.getValue(result, "product");
        objectRefundData.requester = UtilSql.getValue(result, "requester");
        objectRefundData.pricelistid = UtilSql.getValue(result, "pricelistid");
        objectRefundData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectRefundData.org = UtilSql.getValue(result, "org");
        objectRefundData.description = UtilSql.getValue(result, "description");
        objectRefundData.quantity = UtilSql.getValue(result, "quantity");
        objectRefundData.discount = UtilSql.getValue(result, "discount");
        objectRefundData.tax = UtilSql.getValue(result, "tax");
        objectRefundData.uomname = UtilSql.getValue(result, "uomname");
        objectRefundData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectRefundData.rownum = Long.toString(countRecord);
        objectRefundData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRefundData);
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
    RefundData objectRefundData[] = new RefundData[vector.size()];
    vector.copyInto(objectRefundData);
    return(objectRefundData);
  }

  public static RefundData[] set()    throws ServletException {
    RefundData objectRefundData[] = new RefundData[1];
    objectRefundData[0] = new RefundData();
    objectRefundData[0].mAttributesetinstanceId = "";
    objectRefundData[0].finPaymentmethodId = "";
    objectRefundData[0].paymentrule = "";
    objectRefundData[0].cPaymenttermId = "";
    objectRefundData[0].qtyinvoiced = "";
    objectRefundData[0].grandtotal = "";
    objectRefundData[0].cInvoiceId = "";
    objectRefundData[0].documentno = "";
    objectRefundData[0].poreference = "";
    objectRefundData[0].mPricelistId = "";
    objectRefundData[0].dateinvoiced = "";
    objectRefundData[0].mProductId = "";
    objectRefundData[0].customerId = "";
    objectRefundData[0].customer = "";
    objectRefundData[0].vendor = "";
    objectRefundData[0].product = "";
    objectRefundData[0].requester = "";
    objectRefundData[0].pricelistid = "";
    objectRefundData[0].adOrgId = "";
    objectRefundData[0].org = "";
    objectRefundData[0].description = "";
    objectRefundData[0].quantity = "";
    objectRefundData[0].discount = "";
    objectRefundData[0].tax = "";
    objectRefundData[0].uomname = "";
    objectRefundData[0].cUomId = "";
    return objectRefundData;
  }

  public static RefundData[] selectLines(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgId, String parDateFrom, String parDateTo, String parRequester, String parCustomerInc, String parCustomer, String poReference)    throws ServletException {
    return selectLines(connectionProvider, language, adUserClient, adOrgId, parDateFrom, parDateTo, parRequester, parCustomerInc, parCustomer, poReference, 0, 0);
  }

  public static RefundData[] selectLines(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgId, String parDateFrom, String parDateTo, String parRequester, String parCustomerInc, String parCustomer, String poReference, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_INVOICE_ID, DOCUMENTNO, POREFERENCE, DATEINVOICED, " +
      "          (GRANDTOTAL - EM_SSWH_TOTALWITHHOLDINGINCOME - EM_SSWH_TOTALWITHHOLDINGVAT) AS GRANDTOTAL," +
      "          AD_COLUMN_IDENTIFIER(to_char('C_BPartner'), to_char(EM_SSRE_C_BPARTNER_ID), ?) AS CUSTOMER," +
      "          AD_COLUMN_IDENTIFIER(to_char('C_BPartner'), to_char(C_BPARTNER_ID), ?) AS VENDOR," +
      "          AD_COLUMN_IDENTIFIER(to_char('AD_User'), to_char(ci.CREATEDBY), ?) AS REQUESTER" +
      "        FROM C_INVOICE ci LEFT JOIN SSRE_REFUND r ON ci.em_ssre_refunded_id = r.ssre_refund_id" +
      "        WHERE ci.ISACTIVE = 'Y'" +
      "          AND DOCSTATUS = 'CO'" +
      "          AND ISSOTRX = 'N'" +
      "          AND r.TYPE = 'CR'" +
      "          AND EM_SSRE_ISREFUNDED = 'N'" +
      "          AND (EM_SSRE_LOCKEDBY IS NULL OR COALESCE (EM_SSRE_LOCKDATE, TO_DATE('01-01-1900', 'DD-MM-YYYY')) < (now()-3))" +
      "          AND ci.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "          AND ci.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "          AND 1=1";
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":"  AND DATEINVOICED >= TO_DATE(?) ");
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":"  AND C_INVOICE.DATEINVOICED < TO_DATE(?) ");
    strSql = strSql + ((parRequester==null || parRequester.equals(""))?"":"  AND AD_USER_ID = TO_CHAR(?) ");
    strSql = strSql + ((parCustomerInc==null || parCustomerInc.equals(""))?"":"  AND (COALESCE(EM_SSRE_C_BPARTNER_ID, '-1') = TO_CHAR(?) OR (EM_SSRE_C_BPARTNER_ID IS NULL)) ");
    strSql = strSql + ((parCustomer==null || parCustomer.equals(""))?"":"  AND COALESCE(EM_SSRE_C_BPARTNER_ID,'-1') = TO_CHAR(?) ");
    strSql = strSql + ((poReference==null || poReference.equals(""))?"":"  AND POREFERENCE LIKE TO_CHAR(?) ");
    strSql = strSql + 
      "        ORDER BY DATEINVOICED, DOCUMENTNO";

    ResultSet result;
    Vector<RefundData> vector = new Vector<RefundData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }
      if (parDateFrom != null && !(parDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom);
      }
      if (parDateTo != null && !(parDateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo);
      }
      if (parRequester != null && !(parRequester.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parRequester);
      }
      if (parCustomerInc != null && !(parCustomerInc.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parCustomerInc);
      }
      if (parCustomer != null && !(parCustomer.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parCustomer);
      }
      if (poReference != null && !(poReference.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, poReference);
      }

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
        RefundData objectRefundData = new RefundData();
        objectRefundData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectRefundData.documentno = UtilSql.getValue(result, "documentno");
        objectRefundData.poreference = UtilSql.getValue(result, "poreference");
        objectRefundData.dateinvoiced = UtilSql.getDateValue(result, "dateinvoiced", "dd-MM-yyyy");
        objectRefundData.grandtotal = UtilSql.getValue(result, "grandtotal");
        objectRefundData.customer = UtilSql.getValue(result, "customer");
        objectRefundData.vendor = UtilSql.getValue(result, "vendor");
        objectRefundData.requester = UtilSql.getValue(result, "requester");
        objectRefundData.rownum = Long.toString(countRecord);
        objectRefundData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRefundData);
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
    RefundData objectRefundData[] = new RefundData[vector.size()];
    vector.copyInto(objectRefundData);
    return(objectRefundData);
  }

  public static RefundData[] selectSelected(ConnectionProvider connectionProvider, String language, String adUserId, String adUserClient, String adOrgId)    throws ServletException {
    return selectSelected(connectionProvider, language, adUserId, adUserClient, adOrgId, 0, 0);
  }

  public static RefundData[] selectSelected(ConnectionProvider connectionProvider, String language, String adUserId, String adUserClient, String adOrgId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT cu.NAME AS UOMNAME, rc.QUANTITY, C_INVOICE_ID, DOCUMENTNO, POREFERENCE, DATEINVOICED, " +
      "          (GRANDTOTAL - EM_SSWH_TOTALWITHHOLDINGINCOME - EM_SSWH_TOTALWITHHOLDINGVAT) AS GRANDTOTAL," +
      "          COALESCE(EM_SSRE_C_BPARTNER_ID, '-1') AS CUSTOMER_ID," +
      "          COALESCE(ci.M_PRICELIST_ID, '-1') AS M_PRICELIST_ID," +
      "          AD_COLUMN_IDENTIFIER(to_char('C_BPartner'), to_char(EM_SSRE_C_BPARTNER_ID), ?) AS CUSTOMER," +
      "          AD_COLUMN_IDENTIFIER(to_char('C_BPartner'), to_char(ci.C_BPARTNER_ID), ?) AS VENDOR," +
      "          AD_COLUMN_IDENTIFIER(to_char('M_Product'), to_char(mp.M_PRODUCT_ID), ?) AS PRODUCT," +
      "          AD_COLUMN_IDENTIFIER(to_char('M_PriceList'), to_char(ci.M_PRICELIST_ID), ?) AS PRICELISTID" +
      "        FROM C_INVOICE ci LEFT JOIN SSRE_REFUND r ON ci.em_ssre_refunded_id = r.ssre_refund_id," +
      "             SSRE_REFUND_CONFIGURATION rc " +
      "             LEFT JOIN M_PRODUCT mp ON mp.M_PRODUCT_ID = rc.M_PRODUCT_ID" +
      "             LEFT JOIN C_UOM cu ON cu.C_UOM_ID = mp.C_UOM_ID" +
      "        WHERE ci.AD_CLIENT_ID = rc.AD_CLIENT_ID" +
      "          AND ci.AD_ORG_ID = rc.AD_ORG_ID" +
      "          AND ci.ISACTIVE = 'Y'" +
      "          AND DOCSTATUS = 'CO'" +
      "          AND ISSOTRX = 'N'" +
      "          AND r.TYPE = 'CR'" +
      "          AND EM_SSRE_ISREFUNDED = 'N'" +
      "          AND EM_SSRE_LOCKEDBY = ?" +
      "          AND EM_SSRE_LOCKDATE >= (now()-3)        " +
      "          AND ci.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "          AND ci.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "        ORDER BY CUSTOMER_ID, M_PRICELIST_ID";

    ResultSet result;
    Vector<RefundData> vector = new Vector<RefundData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }

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
        RefundData objectRefundData = new RefundData();
        objectRefundData.uomname = UtilSql.getValue(result, "uomname");
        objectRefundData.quantity = UtilSql.getValue(result, "quantity");
        objectRefundData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectRefundData.documentno = UtilSql.getValue(result, "documentno");
        objectRefundData.poreference = UtilSql.getValue(result, "poreference");
        objectRefundData.dateinvoiced = UtilSql.getDateValue(result, "dateinvoiced", "dd-MM-yyyy");
        objectRefundData.grandtotal = UtilSql.getValue(result, "grandtotal");
        objectRefundData.customerId = UtilSql.getValue(result, "customer_id");
        objectRefundData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectRefundData.customer = UtilSql.getValue(result, "customer");
        objectRefundData.vendor = UtilSql.getValue(result, "vendor");
        objectRefundData.product = UtilSql.getValue(result, "product");
        objectRefundData.pricelistid = UtilSql.getValue(result, "pricelistid");
        objectRefundData.rownum = Long.toString(countRecord);
        objectRefundData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRefundData);
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
    RefundData objectRefundData[] = new RefundData[vector.size()];
    vector.copyInto(objectRefundData);
    return(objectRefundData);
  }

  public static RefundData[] linesToInvoice(ConnectionProvider connectionProvider, String invoicedate, String org, String warehouse, String billto, String shipto, String parRefundLines)    throws ServletException {
    return linesToInvoice(connectionProvider, invoicedate, org, warehouse, billto, shipto, parRefundLines, 0, 0);
  }

  public static RefundData[] linesToInvoice(ConnectionProvider connectionProvider, String invoicedate, String org, String warehouse, String billto, String shipto, String parRefundLines, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT mp.M_PRODUCT_ID," +
      "               mp.C_UOM_ID," +
      "               mp.M_ATTRIBUTESETINSTANCE_ID," +
      "               ci.DESCRIPTION," +
      "               rc.QUANTITY AS QTYINVOICED," +
      "               C_INVOICE_ID," +
      "               (GRANDTOTAL - EM_SSWH_TOTALWITHHOLDINGINCOME - EM_SSWH_TOTALWITHHOLDINGVAT) AS GRANDTOTAL," +
      "               0 AS DISCOUNT," +
      "               C_GetTax(mp.M_PRODUCT_ID, to_date(?), ?, ?, ?, ?, null, 'N') AS TAX" +
      "        FROM C_INVOICE ci, SSRE_REFUND_CONFIGURATION rc " +
      "             LEFT JOIN M_PRODUCT mp ON mp.M_PRODUCT_ID = rc.M_PRODUCT_ID" +
      "        WHERE 1=1";
    strSql = strSql + ((parRefundLines==null || parRefundLines.equals(""))?"":"  AND C_INVOICE_ID IN" + parRefundLines);
    strSql = strSql + 
      "              AND ci.AD_CLIENT_ID = rc.AD_CLIENT_ID" +
      "              AND ci.AD_ORG_ID = rc.AD_ORG_ID" +
      "        ORDER BY DOCUMENTNO";

    ResultSet result;
    Vector<RefundData> vector = new Vector<RefundData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, org);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, warehouse);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, billto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shipto);
      if (parRefundLines != null && !(parRefundLines.equals(""))) {
        }

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
        RefundData objectRefundData = new RefundData();
        objectRefundData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectRefundData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectRefundData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectRefundData.description = UtilSql.getValue(result, "description");
        objectRefundData.qtyinvoiced = UtilSql.getValue(result, "qtyinvoiced");
        objectRefundData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectRefundData.grandtotal = UtilSql.getValue(result, "grandtotal");
        objectRefundData.discount = UtilSql.getValue(result, "discount");
        objectRefundData.tax = UtilSql.getValue(result, "tax");
        objectRefundData.rownum = Long.toString(countRecord);
        objectRefundData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRefundData);
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
    RefundData objectRefundData[] = new RefundData[vector.size()];
    vector.copyInto(objectRefundData);
    return(objectRefundData);
  }

  public static RefundData[] selectCustomer(ConnectionProvider connectionProvider, String parRefundLines)    throws ServletException {
    return selectCustomer(connectionProvider, parRefundLines, 0, 0);
  }

  public static RefundData[] selectCustomer(ConnectionProvider connectionProvider, String parRefundLines, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT DISTINCT EM_SSRE_C_BPARTNER_ID AS CUSTOMER_ID" +
      "      FROM C_INVOICE" +
      "      WHERE EM_SSRE_C_BPARTNER_ID IS NOT NULL" +
      "        AND 1=1";
    strSql = strSql + ((parRefundLines==null || parRefundLines.equals(""))?"":" AND C_INVOICE_ID IN" + parRefundLines);

    ResultSet result;
    Vector<RefundData> vector = new Vector<RefundData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (parRefundLines != null && !(parRefundLines.equals(""))) {
        }

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
        RefundData objectRefundData = new RefundData();
        objectRefundData.customerId = UtilSql.getValue(result, "customer_id");
        objectRefundData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRefundData);
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
    RefundData objectRefundData[] = new RefundData[vector.size()];
    vector.copyInto(objectRefundData);
    return(objectRefundData);
  }

  public static RefundData[] selectPriceList(ConnectionProvider connectionProvider, String language, String parRefundLines)    throws ServletException {
    return selectPriceList(connectionProvider, language, parRefundLines, 0, 0);
  }

  public static RefundData[] selectPriceList(ConnectionProvider connectionProvider, String language, String parRefundLines, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT DISTINCT C_BPARTNER.M_PRICELIST_ID," +
      "          AD_COLUMN_IDENTIFIER(to_char('M_PriceList'), to_char(C_BPARTNER.M_PRICELIST_ID), ?) AS PRICELISTID" +
      "        FROM C_INVOICE, C_BPARTNER" +
      "        WHERE C_INVOICE.EM_SSRE_C_BPARTNER_ID = C_BPARTNER.C_BPARTNER_ID" +
      "          AND 1=1";
    strSql = strSql + ((parRefundLines==null || parRefundLines.equals(""))?"":" AND C_INVOICE_ID IN" + parRefundLines);

    ResultSet result;
    Vector<RefundData> vector = new Vector<RefundData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      if (parRefundLines != null && !(parRefundLines.equals(""))) {
        }

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
        RefundData objectRefundData = new RefundData();
        objectRefundData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectRefundData.pricelistid = UtilSql.getValue(result, "pricelistid");
        objectRefundData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRefundData);
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
    RefundData objectRefundData[] = new RefundData[vector.size()];
    vector.copyInto(objectRefundData);
    return(objectRefundData);
  }

  public static RefundData[] selectOrg(ConnectionProvider connectionProvider, String language, String parRefundLines)    throws ServletException {
    return selectOrg(connectionProvider, language, parRefundLines, 0, 0);
  }

  public static RefundData[] selectOrg(ConnectionProvider connectionProvider, String language, String parRefundLines, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT DISTINCT AD_ORG_ID," +
      "          AD_COLUMN_IDENTIFIER(to_char('AD_Org'), to_char(AD_ORG_ID), ?) AS ORG" +
      "        FROM C_INVOICE" +
      "        WHERE 1=1";
    strSql = strSql + ((parRefundLines==null || parRefundLines.equals(""))?"":" AND C_INVOICE_ID IN" + parRefundLines);

    ResultSet result;
    Vector<RefundData> vector = new Vector<RefundData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      if (parRefundLines != null && !(parRefundLines.equals(""))) {
        }

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
        RefundData objectRefundData = new RefundData();
        objectRefundData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectRefundData.org = UtilSql.getValue(result, "org");
        objectRefundData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRefundData);
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
    RefundData objectRefundData[] = new RefundData[vector.size()];
    vector.copyInto(objectRefundData);
    return(objectRefundData);
  }

  public static RefundData[] selectCustomerData(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    return selectCustomerData(connectionProvider, cBpartnerId, 0, 0);
  }

  public static RefundData[] selectCustomerData(ConnectionProvider connectionProvider, String cBpartnerId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT PaymentRule, C_PaymentTerm_ID, FIN_PaymentMethod_ID" +
      "      FROM C_BPartner" +
      "      WHERE C_BPartner_ID = ?";

    ResultSet result;
    Vector<RefundData> vector = new Vector<RefundData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

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
        RefundData objectRefundData = new RefundData();
        objectRefundData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectRefundData.cPaymenttermId = UtilSql.getValue(result, "c_paymentterm_id");
        objectRefundData.finPaymentmethodId = UtilSql.getValue(result, "fin_paymentmethod_id");
        objectRefundData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRefundData);
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
    RefundData objectRefundData[] = new RefundData[vector.size()];
    vector.copyInto(objectRefundData);
    return(objectRefundData);
  }

  public static String bPartnerDescription(ConnectionProvider connectionProvider, String partnerid, String language)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_COLUMN_IDENTIFIER(to_char('C_BPartner'), to_char(?), to_char(?)) AS CUSTOMER" +
      "        FROM DUAL";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, partnerid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "customer");
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
    return(strReturn);
  }

  public static String getPricelistVersion(ConnectionProvider connectionProvider, String pricelist, String invoicedate)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_GET_PRICELIST_VERSION(?, to_date(?)) AS PRICELISTID" +
      "        FROM DUAL";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedate);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "pricelistid");
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
    return(strReturn);
  }

  public static String treeOrg(ConnectionProvider connectionProvider, String client)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_TREE_ORG_ID FROM AD_CLIENTINFO" +
      "        WHERE AD_CLIENT_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_tree_org_id");
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
    return(strReturn);
  }

  public static String cDoctypeTarget(ConnectionProvider connectionProvider, String adClientId, String adOrgId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_GET_DOCTYPE(?, ?, 'ARI', null) FROM DUAL";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_get_doctype");
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
    return(strReturn);
  }

  public static String cBPartnerLocationId(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT MAX(C_BPARTNER_LOCATION_ID) FROM C_BPARTNER_LOCATION" +
      "        WHERE C_BPARTNER_ID = ?" +
      "        AND C_BPartner_Location.IsActive='Y'";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "max");
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
    return(strReturn);
  }

  public static String billto(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT MAX(C_BPARTNER_LOCATION_ID) FROM C_BPARTNER_LOCATION" +
      "        WHERE  C_BPartner_Location.IsBillTo='Y'" +
      "        AND C_BPartner_Location.IsActive='Y'" +
      "        AND C_BPARTNER_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "max");
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
    return(strReturn);
  }

  public static String selectCurrency(ConnectionProvider connectionProvider, String mPricelistId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_CURRENCY_ID" +
      "        FROM M_PRICELIST" +
      "        WHERE  M_PRICELIST_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_currency_id");
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
    return(strReturn);
  }

  public static int unlock(ConnectionProvider connectionProvider, String refundlines)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE C_INVOICE" +
      "        SET EM_SSRE_LOCKEDBY = null," +
      "            EM_SSRE_LOCKDATE = null" +
      "        WHERE C_INVOICE_ID IN ";
    strSql = strSql + ((refundlines==null || refundlines.equals(""))?"":refundlines);

    int updateCount = 0;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (refundlines != null && !(refundlines.equals(""))) {
        }

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      updateCount = st.executeUpdate();
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
    return(updateCount);
  }

  public static int lock(ConnectionProvider connectionProvider, String userId, String refundlines)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE C_INVOICE" +
      "        SET EM_SSRE_LOCKEDBY = ?," +
      "            EM_SSRE_LOCKDATE = now()" +
      "        WHERE C_INVOICE_ID IN ";
    strSql = strSql + ((refundlines==null || refundlines.equals(""))?"":refundlines);

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, userId);
      if (refundlines != null && !(refundlines.equals(""))) {
        }

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      updateCount = st.executeUpdate();
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
    return(updateCount);
  }

  public static int insertCInvoice(Connection conn, ConnectionProvider connectionProvider, String cInvoiceId, String adClientId, String adOrgId, String user, String documentNo, String docStatus, String docAction, String cDoctypeId, String cDoctypetargetId, String dateinvoiced, String dateacct, String cBpartnerId, String cBpartnerLocationId, String cCurrencyId, String paymentrule, String cPaymenttermId, String mPricelistId, String cProjectId, String cActivityId, String cCampaignId, String finPaymentMethodId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO C_INVOICE (C_INVOICE_ID, AD_CLIENT_ID, AD_ORG_ID, CREATED, CREATEDBY, UPDATED, UPDATEDBY, DOCUMENTNO," +
      "        DOCSTATUS, DOCACTION, C_DOCTYPE_ID, C_DOCTYPETARGET_ID," +
      "        DATEINVOICED, DATEACCT, C_BPARTNER_ID, C_BPARTNER_LOCATION_ID, C_CURRENCY_ID, " +
      "        PAYMENTRULE, C_PAYMENTTERM_ID, M_PRICELIST_ID, " +
      "        C_PROJECT_ID, C_ACTIVITY_ID, C_CAMPAIGN_ID, ISSOTRX," +
      "        FIN_PAYMENTMETHOD_ID,EM_SSRE_ISREFUND,EM_SFB_ISNOTBUDGETABLE)" +
      "        VALUES (?,?,?,now(),?,now(),?,?,?,?,?,?,TO_DATE(?),TO_DATE(?),?,?,?,?,?,?,?,?,?,'Y',?,'Y','Y')";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentNo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docStatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docAction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypetargetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, finPaymentMethodId);

      SessionInfo.saveContextInfoIntoDB(conn);
      updateCount = st.executeUpdate();
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(updateCount);
  }

  public static int insertCInvoiceline(Connection conn, ConnectionProvider connectionProvider, String cInvoicelineId, String adClientId, String adOrgId, String user, String cInvoiceId, String line, String cBpartnerId, String description, String mProductId, String mAttributeSetInstanceId, String cUomId, String qtyinvoiced, String pricelist, String priceactual, String linenetamt, String taxamt, String taxbaseamt, String pricelimit, String cTaxId, String sResourceassignmentId, String pricestd, String cRefundedInvoiceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO C_INVOICELINE (C_INVOICELINE_ID, AD_CLIENT_ID, AD_ORG_ID, CREATED, CREATEDBY, UPDATED, UPDATEDBY," +
      "        C_INVOICE_ID, LINE, C_BPARTNER_ID, DESCRIPTION, " +
      "        M_PRODUCT_ID, M_ATTRIBUTESETINSTANCE_ID," +
      "        C_UOM_ID, QTYINVOICED, PRICELIST, " +
      "        PRICEACTUAL, " +
      "        LINENETAMT," +
      "        TAXAMT," +
      "        TAXBASEAMT, PRICELIMIT, C_TAX_ID, S_RESOURCEASSIGNMENT_ID, PRICESTD, EM_SSRE_REFUNDEDINVOICE_REF_ID)" +
      "        VALUES (?,?,?,now(),?,now(),?," +
      "        ?,TO_NUMBER(?),?,?," +
      "        ?,?," +
      "        ?,TO_NUMBER(?),TO_NUMBER(?)," +
      "        TO_NUMBER(?), " +
      "        TO_NUMBER(?)," +
      "        TO_NUMBER(?), " +
      "        TO_NUMBER(?), TO_NUMBER(?),?,?,TO_NUMBER(?),?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoicelineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributeSetInstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceactual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, linenetamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxbaseamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelimit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sResourceassignmentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricestd);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cRefundedInvoiceId);

      SessionInfo.saveContextInfoIntoDB(conn);
      updateCount = st.executeUpdate();
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(updateCount);
  }

  public static RefundData cInvoicePost0(Connection conn, ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL C_Invoice_Post0(?)";

    RefundData objectRefundData = new RefundData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(conn);
      st.execute();
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(conn, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectRefundData);
  }

  public static int refunded(Connection conn, ConnectionProvider connectionProvider, String userId, String cInvoiceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE C_Invoice" +
      "        SET em_ssre_isrefunded = 'Y'," +
      "            Updated = TO_DATE(NOW())," +
      "            UpdatedBy = ?" +
      "            WHERE C_Invoice_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, userId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);

      SessionInfo.saveContextInfoIntoDB(conn);
      updateCount = st.executeUpdate();
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(updateCount);
  }
}
