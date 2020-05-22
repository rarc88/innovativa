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
package org.openbravo.model.common.invoice;

import com.sidesoft.localization.ecuador.withholdings.ReceiptTax;

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
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.tax.TaxRate;
import org.openbravo.model.financialmgmt.tax.TaxRegisterline;
/**
 * Entity class for entity InvoiceTax (stored in table C_InvoiceTax).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class InvoiceTax extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_InvoiceTax";
    public static final String ENTITY_NAME = "InvoiceTax";
    public static final String PROPERTY_TAX = "tax";
    public static final String PROPERTY_INVOICE = "invoice";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_TAXABLEAMOUNT = "taxableAmount";
    public static final String PROPERTY_TAXAMOUNT = "taxAmount";
    public static final String PROPERTY_LINENO = "lineNo";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_RECALCULATE = "recalculate";
    public static final String PROPERTY_SSWHISWITHHOLDING = "sswhIswithholding";
    public static final String PROPERTY_SSWHISPROCESSWITHHOLDING = "sswhIsprocesswithholding";
    public static final String PROPERTY_EEIEXCLUDEDWITHHOLDING = "eeiExcludedWithholding";
    public static final String PROPERTY_INVOICETAXCASHVATVLIST = "invoiceTaxCashVATVList";
    public static final String PROPERTY_FINANCIALMGMTTAXREGISTERLINELIST = "financialMgmtTaxRegisterlineList";
    public static final String PROPERTY_INVOICELINEEMSSWHINVOICETAXINCOMEIDLIST = "invoiceLineEMSswhInvoicetaxIncomeIDList";
    public static final String PROPERTY_INVOICELINEEMSSWHINVOICETAXVATIDLIST = "invoiceLineEMSswhInvoicetaxVatIDList";
    public static final String PROPERTY_INVOICETAXCASHVATLIST = "invoiceTaxCashVATList";
    public static final String PROPERTY_SSWHRECEIPTTAXLIST = "sSWHReceiptTaxList";

    public InvoiceTax() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_RECALCULATE, false);
        setDefaultValue(PROPERTY_SSWHISWITHHOLDING, false);
        setDefaultValue(PROPERTY_SSWHISPROCESSWITHHOLDING, false);
        setDefaultValue(PROPERTY_EEIEXCLUDEDWITHHOLDING, false);
        setDefaultValue(PROPERTY_INVOICETAXCASHVATVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTTAXREGISTERLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELINEEMSSWHINVOICETAXINCOMEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELINEEMSSWHINVOICETAXVATIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICETAXCASHVATLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWHRECEIPTTAXLIST, new ArrayList<Object>());
    }

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
    }

    public TaxRate getTax() {
        return (TaxRate) get(PROPERTY_TAX);
    }

    public void setTax(TaxRate tax) {
        set(PROPERTY_TAX, tax);
    }

    public Invoice getInvoice() {
        return (Invoice) get(PROPERTY_INVOICE);
    }

    public void setInvoice(Invoice invoice) {
        set(PROPERTY_INVOICE, invoice);
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

    public BigDecimal getTaxableAmount() {
        return (BigDecimal) get(PROPERTY_TAXABLEAMOUNT);
    }

    public void setTaxableAmount(BigDecimal taxableAmount) {
        set(PROPERTY_TAXABLEAMOUNT, taxableAmount);
    }

    public BigDecimal getTaxAmount() {
        return (BigDecimal) get(PROPERTY_TAXAMOUNT);
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        set(PROPERTY_TAXAMOUNT, taxAmount);
    }

    public Long getLineNo() {
        return (Long) get(PROPERTY_LINENO);
    }

    public void setLineNo(Long lineNo) {
        set(PROPERTY_LINENO, lineNo);
    }

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
    }

    public Boolean isRecalculate() {
        return (Boolean) get(PROPERTY_RECALCULATE);
    }

    public void setRecalculate(Boolean recalculate) {
        set(PROPERTY_RECALCULATE, recalculate);
    }

    public Boolean isSswhIswithholding() {
        return (Boolean) get(PROPERTY_SSWHISWITHHOLDING);
    }

    public void setSswhIswithholding(Boolean sswhIswithholding) {
        set(PROPERTY_SSWHISWITHHOLDING, sswhIswithholding);
    }

    public Boolean isSswhIsprocesswithholding() {
        return (Boolean) get(PROPERTY_SSWHISPROCESSWITHHOLDING);
    }

    public void setSswhIsprocesswithholding(Boolean sswhIsprocesswithholding) {
        set(PROPERTY_SSWHISPROCESSWITHHOLDING, sswhIsprocesswithholding);
    }

    public Boolean isEeiExcludedWithholding() {
        return (Boolean) get(PROPERTY_EEIEXCLUDEDWITHHOLDING);
    }

    public void setEeiExcludedWithholding(Boolean eeiExcludedWithholding) {
        set(PROPERTY_EEIEXCLUDEDWITHHOLDING, eeiExcludedWithholding);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceTaxCashVAT_V> getInvoiceTaxCashVATVList() {
      return (List<InvoiceTaxCashVAT_V>) get(PROPERTY_INVOICETAXCASHVATVLIST);
    }

    public void setInvoiceTaxCashVATVList(List<InvoiceTaxCashVAT_V> invoiceTaxCashVATVList) {
        set(PROPERTY_INVOICETAXCASHVATVLIST, invoiceTaxCashVATVList);
    }

    @SuppressWarnings("unchecked")
    public List<TaxRegisterline> getFinancialMgmtTaxRegisterlineList() {
      return (List<TaxRegisterline>) get(PROPERTY_FINANCIALMGMTTAXREGISTERLINELIST);
    }

    public void setFinancialMgmtTaxRegisterlineList(List<TaxRegisterline> financialMgmtTaxRegisterlineList) {
        set(PROPERTY_FINANCIALMGMTTAXREGISTERLINELIST, financialMgmtTaxRegisterlineList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceLine> getInvoiceLineEMSswhInvoicetaxIncomeIDList() {
      return (List<InvoiceLine>) get(PROPERTY_INVOICELINEEMSSWHINVOICETAXINCOMEIDLIST);
    }

    public void setInvoiceLineEMSswhInvoicetaxIncomeIDList(List<InvoiceLine> invoiceLineEMSswhInvoicetaxIncomeIDList) {
        set(PROPERTY_INVOICELINEEMSSWHINVOICETAXINCOMEIDLIST, invoiceLineEMSswhInvoicetaxIncomeIDList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceLine> getInvoiceLineEMSswhInvoicetaxVatIDList() {
      return (List<InvoiceLine>) get(PROPERTY_INVOICELINEEMSSWHINVOICETAXVATIDLIST);
    }

    public void setInvoiceLineEMSswhInvoicetaxVatIDList(List<InvoiceLine> invoiceLineEMSswhInvoicetaxVatIDList) {
        set(PROPERTY_INVOICELINEEMSSWHINVOICETAXVATIDLIST, invoiceLineEMSswhInvoicetaxVatIDList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceTaxCashVAT> getInvoiceTaxCashVATList() {
      return (List<InvoiceTaxCashVAT>) get(PROPERTY_INVOICETAXCASHVATLIST);
    }

    public void setInvoiceTaxCashVATList(List<InvoiceTaxCashVAT> invoiceTaxCashVATList) {
        set(PROPERTY_INVOICETAXCASHVATLIST, invoiceTaxCashVATList);
    }

    @SuppressWarnings("unchecked")
    public List<ReceiptTax> getSSWHReceiptTaxList() {
      return (List<ReceiptTax>) get(PROPERTY_SSWHRECEIPTTAXLIST);
    }

    public void setSSWHReceiptTaxList(List<ReceiptTax> sSWHReceiptTaxList) {
        set(PROPERTY_SSWHRECEIPTTAXLIST, sSWHReceiptTaxList);
    }

}
