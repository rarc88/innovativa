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
package ec.com.sidesoft.quick.billing;

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
import org.openbravo.model.financialmgmt.payment.FIN_PaymentMethod;
/**
 * Entity class for entity sqb_quickbilling (stored in table sqb_quickbilling).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SqbQuickBilling extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sqb_quickbilling";
    public static final String ENTITY_NAME = "sqb_quickbilling";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_SAVEASSIGN = "saveAssign";
    public static final String PROPERTY_INVOICE = "invoice";
    public static final String PROPERTY_TAXID = "taxid";
    public static final String PROPERTY_TAXIDTYPE = "taxidtype";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_PHONE = "phone";
    public static final String PROPERTY_ADDRESS = "address";
    public static final String PROPERTY_DOCTYPE = "doctype";
    public static final String PROPERTY_DOCUMENTNO = "documentno";
    public static final String PROPERTY_BPARTNER = "bpartner";
    public static final String PROPERTY_SUBTOTALQB = "subtotalQb";
    public static final String PROPERTY_VAT = "vat";
    public static final String PROPERTY_TOTAL = "total";
    public static final String PROPERTY_DOCSTATUS = "docstatus";
    public static final String PROPERTY_EMAIL = "email";
    public static final String PROPERTY_FINPAYMENTMETHOD = "fINPaymentmethod";
    public static final String PROPERTY_INVOICE24 = "invoice24";
    public static final String PROPERTY_CLOSEBOX = "closeBox";
    public static final String PROPERTY_STATUSCLOSE = "statusClose";
    public static final String PROPERTY_TOTALSTATUSBAR = "totalStatusbar";
    public static final String PROPERTY_DATEINVOICED = "dateinvoiced";
    public static final String PROPERTY_INVOICEEMSQBQUICKBILLINGIDLIST = "invoiceEMSqbQuickbillingIDList";
    public static final String PROPERTY_SQBQUICKBILLINGLINELIST = "sqbQuickbillinglineList";

    public SqbQuickBilling() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_SAVEASSIGN, false);
        setDefaultValue(PROPERTY_INVOICE, false);
        setDefaultValue(PROPERTY_SUBTOTALQB, new BigDecimal(0));
        setDefaultValue(PROPERTY_VAT, new BigDecimal(0));
        setDefaultValue(PROPERTY_TOTAL, new BigDecimal(0));
        setDefaultValue(PROPERTY_DOCSTATUS, "DR");
        setDefaultValue(PROPERTY_CLOSEBOX, false);
        setDefaultValue(PROPERTY_STATUSCLOSE, "O");
        setDefaultValue(PROPERTY_INVOICEEMSQBQUICKBILLINGIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SQBQUICKBILLINGLINELIST, new ArrayList<Object>());
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

    public Boolean isSaveAssign() {
        return (Boolean) get(PROPERTY_SAVEASSIGN);
    }

    public void setSaveAssign(Boolean saveAssign) {
        set(PROPERTY_SAVEASSIGN, saveAssign);
    }

    public Boolean isInvoice() {
        return (Boolean) get(PROPERTY_INVOICE);
    }

    public void setInvoice(Boolean invoice) {
        set(PROPERTY_INVOICE, invoice);
    }

    public String getTaxid() {
        return (String) get(PROPERTY_TAXID);
    }

    public void setTaxid(String taxid) {
        set(PROPERTY_TAXID, taxid);
    }

    public String getTaxidtype() {
        return (String) get(PROPERTY_TAXIDTYPE);
    }

    public void setTaxidtype(String taxidtype) {
        set(PROPERTY_TAXIDTYPE, taxidtype);
    }

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public String getPhone() {
        return (String) get(PROPERTY_PHONE);
    }

    public void setPhone(String phone) {
        set(PROPERTY_PHONE, phone);
    }

    public String getAddress() {
        return (String) get(PROPERTY_ADDRESS);
    }

    public void setAddress(String address) {
        set(PROPERTY_ADDRESS, address);
    }

    public DocumentType getDoctype() {
        return (DocumentType) get(PROPERTY_DOCTYPE);
    }

    public void setDoctype(DocumentType doctype) {
        set(PROPERTY_DOCTYPE, doctype);
    }

    public String getDocumentno() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentno(String documentno) {
        set(PROPERTY_DOCUMENTNO, documentno);
    }

    public BusinessPartner getBpartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBpartner(BusinessPartner bpartner) {
        set(PROPERTY_BPARTNER, bpartner);
    }

    public BigDecimal getSubtotalQb() {
        return (BigDecimal) get(PROPERTY_SUBTOTALQB);
    }

    public void setSubtotalQb(BigDecimal subtotalQb) {
        set(PROPERTY_SUBTOTALQB, subtotalQb);
    }

    public BigDecimal getVat() {
        return (BigDecimal) get(PROPERTY_VAT);
    }

    public void setVat(BigDecimal vat) {
        set(PROPERTY_VAT, vat);
    }

    public BigDecimal getTotal() {
        return (BigDecimal) get(PROPERTY_TOTAL);
    }

    public void setTotal(BigDecimal total) {
        set(PROPERTY_TOTAL, total);
    }

    public String getDocstatus() {
        return (String) get(PROPERTY_DOCSTATUS);
    }

    public void setDocstatus(String docstatus) {
        set(PROPERTY_DOCSTATUS, docstatus);
    }

    public String getEmail() {
        return (String) get(PROPERTY_EMAIL);
    }

    public void setEmail(String email) {
        set(PROPERTY_EMAIL, email);
    }

    public FIN_PaymentMethod getFINPaymentmethod() {
        return (FIN_PaymentMethod) get(PROPERTY_FINPAYMENTMETHOD);
    }

    public void setFINPaymentmethod(FIN_PaymentMethod fINPaymentmethod) {
        set(PROPERTY_FINPAYMENTMETHOD, fINPaymentmethod);
    }

    public Invoice getInvoice24() {
        return (Invoice) get(PROPERTY_INVOICE24);
    }

    public void setInvoice24(Invoice invoice24) {
        set(PROPERTY_INVOICE24, invoice24);
    }

    public Boolean isCloseBox() {
        return (Boolean) get(PROPERTY_CLOSEBOX);
    }

    public void setCloseBox(Boolean closeBox) {
        set(PROPERTY_CLOSEBOX, closeBox);
    }

    public String getStatusClose() {
        return (String) get(PROPERTY_STATUSCLOSE);
    }

    public void setStatusClose(String statusClose) {
        set(PROPERTY_STATUSCLOSE, statusClose);
    }

    public BigDecimal getTotalStatusbar() {
        return (BigDecimal) get(PROPERTY_TOTALSTATUSBAR);
    }

    public void setTotalStatusbar(BigDecimal totalStatusbar) {
        set(PROPERTY_TOTALSTATUSBAR, totalStatusbar);
    }

    public Date getDateinvoiced() {
        return (Date) get(PROPERTY_DATEINVOICED);
    }

    public void setDateinvoiced(Date dateinvoiced) {
        set(PROPERTY_DATEINVOICED, dateinvoiced);
    }

    @SuppressWarnings("unchecked")
    public List<Invoice> getInvoiceEMSqbQuickbillingIDList() {
      return (List<Invoice>) get(PROPERTY_INVOICEEMSQBQUICKBILLINGIDLIST);
    }

    public void setInvoiceEMSqbQuickbillingIDList(List<Invoice> invoiceEMSqbQuickbillingIDList) {
        set(PROPERTY_INVOICEEMSQBQUICKBILLINGIDLIST, invoiceEMSqbQuickbillingIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SqbQuickBillingLine> getSqbQuickbillinglineList() {
      return (List<SqbQuickBillingLine>) get(PROPERTY_SQBQUICKBILLINGLINELIST);
    }

    public void setSqbQuickbillinglineList(List<SqbQuickBillingLine> sqbQuickbillinglineList) {
        set(PROPERTY_SQBQUICKBILLINGLINELIST, sqbQuickbillinglineList);
    }

}
