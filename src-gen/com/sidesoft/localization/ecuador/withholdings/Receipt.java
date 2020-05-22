/*
 *************************************************************************
 * The contents of this file are subject to the Openbravo  Public  License
 * Version  1.1  (the  "License"),  being   the  Mozilla   Public  License
 * Version 1.1  with a permitted attribution clause; you may not  use this
 * file except in compliance with the License. You  may  obtain  a copy of
 * the License at http://www.openbravo.com/legal/license.html
 * Software distributed under the License  is  distributed  on  an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific  language  governing  rights  and  limitations
 * under the License.
 * The Original Code is Openbravo ERP.
 * The Initial Developer of the Original Code is Openbravo SLU
 * All portions are Copyright (C) 2008-2014 Openbravo SLU
 * All Rights Reserved.
 * Contributor(s):  ______________________________________.
 ************************************************************************
*/
package com.sidesoft.localization.ecuador.withholdings;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.invoice.Invoice;
/**
 * Entity class for entity SSWH_Receipt (stored in table SSWH_Receipt).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Receipt extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "SSWH_Receipt";
    public static final String ENTITY_NAME = "SSWH_Receipt";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_DATEDOC = "datedoc";
    public static final String PROPERTY_REFERENCE = "reference";
    public static final String PROPERTY_TOTALWITHHOLDINGINCOME = "totalwithholdingincome";
    public static final String PROPERTY_TOTALWITHHOLDINGVAT = "totalwithholdingvat";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_AUTHORIZATIONNO = "authorizationno";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_POSTED = "posted";
    public static final String PROPERTY_PROCESSNOW = "processNow";
    public static final String PROPERTY_DOCUMENTTYPE = "documentType";
    public static final String PROPERTY_CALCULATEDTOTALWITHHOLDINGINCOME = "calculatedtotalwithholdingincome";
    public static final String PROPERTY_CALCULATEDTOTALWITHHOLDINGVAT = "calculatedtotalwithholdingvat";
    public static final String PROPERTY_INVOICE = "invoice";
    public static final String PROPERTY_INVOICEEMSSWHRECEIPTIDLIST = "invoiceEMSswhReceiptIDList";
    public static final String PROPERTY_SSWHRECEIPTTAXLIST = "sSWHReceiptTaxList";

    public Receipt() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_TOTALWITHHOLDINGINCOME, new BigDecimal(0));
        setDefaultValue(PROPERTY_TOTALWITHHOLDINGVAT, new BigDecimal(0));
        setDefaultValue(PROPERTY_PROCESSED, "N");
        setDefaultValue(PROPERTY_POSTED, "N");
        setDefaultValue(PROPERTY_PROCESSNOW, false);
        setDefaultValue(PROPERTY_CALCULATEDTOTALWITHHOLDINGINCOME, new BigDecimal(0));
        setDefaultValue(PROPERTY_CALCULATEDTOTALWITHHOLDINGVAT, new BigDecimal(0));
        setDefaultValue(PROPERTY_INVOICEEMSSWHRECEIPTIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWHRECEIPTTAXLIST, new ArrayList<Object>());
    }

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
    }

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
    }

    public Client getClient() {
        return (Client) get(PROPERTY_CLIENT);
    }

    public void setClient(Client client) {
        set(PROPERTY_CLIENT, client);
    }

    public Organization getOrganization() {
        return (Organization) get(PROPERTY_ORGANIZATION);
    }

    public void setOrganization(Organization organization) {
        set(PROPERTY_ORGANIZATION, organization);
    }

    public Boolean isActive() {
        return (Boolean) get(PROPERTY_ACTIVE);
    }

    public void setActive(Boolean active) {
        set(PROPERTY_ACTIVE, active);
    }

    public Date getCreationDate() {
        return (Date) get(PROPERTY_CREATIONDATE);
    }

    public void setCreationDate(Date creationDate) {
        set(PROPERTY_CREATIONDATE, creationDate);
    }

    public User getCreatedBy() {
        return (User) get(PROPERTY_CREATEDBY);
    }

    public void setCreatedBy(User createdBy) {
        set(PROPERTY_CREATEDBY, createdBy);
    }

    public Date getUpdated() {
        return (Date) get(PROPERTY_UPDATED);
    }

    public void setUpdated(Date updated) {
        set(PROPERTY_UPDATED, updated);
    }

    public User getUpdatedBy() {
        return (User) get(PROPERTY_UPDATEDBY);
    }

    public void setUpdatedBy(User updatedBy) {
        set(PROPERTY_UPDATEDBY, updatedBy);
    }

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

    public Date getDatedoc() {
        return (Date) get(PROPERTY_DATEDOC);
    }

    public void setDatedoc(Date datedoc) {
        set(PROPERTY_DATEDOC, datedoc);
    }

    public String getReference() {
        return (String) get(PROPERTY_REFERENCE);
    }

    public void setReference(String reference) {
        set(PROPERTY_REFERENCE, reference);
    }

    public BigDecimal getTotalwithholdingincome() {
        return (BigDecimal) get(PROPERTY_TOTALWITHHOLDINGINCOME);
    }

    public void setTotalwithholdingincome(BigDecimal totalwithholdingincome) {
        set(PROPERTY_TOTALWITHHOLDINGINCOME, totalwithholdingincome);
    }

    public BigDecimal getTotalwithholdingvat() {
        return (BigDecimal) get(PROPERTY_TOTALWITHHOLDINGVAT);
    }

    public void setTotalwithholdingvat(BigDecimal totalwithholdingvat) {
        set(PROPERTY_TOTALWITHHOLDINGVAT, totalwithholdingvat);
    }

    public String getProcessed() {
        return (String) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(String processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public String getAuthorizationno() {
        return (String) get(PROPERTY_AUTHORIZATIONNO);
    }

    public void setAuthorizationno(String authorizationno) {
        set(PROPERTY_AUTHORIZATIONNO, authorizationno);
    }

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public String getPosted() {
        return (String) get(PROPERTY_POSTED);
    }

    public void setPosted(String posted) {
        set(PROPERTY_POSTED, posted);
    }

    public Boolean isProcessNow() {
        return (Boolean) get(PROPERTY_PROCESSNOW);
    }

    public void setProcessNow(Boolean processNow) {
        set(PROPERTY_PROCESSNOW, processNow);
    }

    public DocumentType getDocumentType() {
        return (DocumentType) get(PROPERTY_DOCUMENTTYPE);
    }

    public void setDocumentType(DocumentType documentType) {
        set(PROPERTY_DOCUMENTTYPE, documentType);
    }

    public BigDecimal getCalculatedtotalwithholdingincome() {
        return (BigDecimal) get(PROPERTY_CALCULATEDTOTALWITHHOLDINGINCOME);
    }

    public void setCalculatedtotalwithholdingincome(BigDecimal calculatedtotalwithholdingincome) {
        set(PROPERTY_CALCULATEDTOTALWITHHOLDINGINCOME, calculatedtotalwithholdingincome);
    }

    public BigDecimal getCalculatedtotalwithholdingvat() {
        return (BigDecimal) get(PROPERTY_CALCULATEDTOTALWITHHOLDINGVAT);
    }

    public void setCalculatedtotalwithholdingvat(BigDecimal calculatedtotalwithholdingvat) {
        set(PROPERTY_CALCULATEDTOTALWITHHOLDINGVAT, calculatedtotalwithholdingvat);
    }

    public Invoice getInvoice() {
        return (Invoice) get(PROPERTY_INVOICE);
    }

    public void setInvoice(Invoice invoice) {
        set(PROPERTY_INVOICE, invoice);
    }

    @SuppressWarnings("unchecked")
    public List<Invoice> getInvoiceEMSswhReceiptIDList() {
      return (List<Invoice>) get(PROPERTY_INVOICEEMSSWHRECEIPTIDLIST);
    }

    public void setInvoiceEMSswhReceiptIDList(List<Invoice> invoiceEMSswhReceiptIDList) {
        set(PROPERTY_INVOICEEMSSWHRECEIPTIDLIST, invoiceEMSswhReceiptIDList);
    }

    @SuppressWarnings("unchecked")
    public List<ReceiptTax> getSSWHReceiptTaxList() {
      return (List<ReceiptTax>) get(PROPERTY_SSWHRECEIPTTAXLIST);
    }

    public void setSSWHReceiptTaxList(List<ReceiptTax> sSWHReceiptTaxList) {
        set(PROPERTY_SSWHRECEIPTTAXLIST, sSWHReceiptTaxList);
    }

}
