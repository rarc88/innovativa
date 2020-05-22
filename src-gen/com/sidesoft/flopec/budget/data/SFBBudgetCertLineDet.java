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
package com.sidesoft.flopec.budget.data;

import java.math.BigDecimal;
import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.common.invoice.InvoiceLine;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.common.order.OrderLine;
/**
 * Entity class for entity sfb_budget_cert_line_det_v (stored in table sfb_budget_cert_line_det_v).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SFBBudgetCertLineDet extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sfb_budget_cert_line_det_v";
    public static final String ENTITY_NAME = "sfb_budget_cert_line_det_v";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_SALESORDERLINE = "salesOrderLine";
    public static final String PROPERTY_SFBBUDGETCERTLINE = "sfbBudgetCertLine";
    public static final String PROPERTY_SALESORDER = "salesOrder";
    public static final String PROPERTY_ORDERBUSINESSPARTNER = "orderBusinessPartner";
    public static final String PROPERTY_ORDERCURRENCY = "orderCurrency";
    public static final String PROPERTY_ORDERLINETOTALAMOUNT = "orderLineTotalAmount";
    public static final String PROPERTY_INVOICELINE = "invoiceLine";
    public static final String PROPERTY_INVOICE = "invoice";
    public static final String PROPERTY_INVOICEBUSINESSPARTNER = "invoiceBusinessPartner";
    public static final String PROPERTY_INVOICECURRENCY = "invoiceCurrency";
    public static final String PROPERTY_INVOICELINETOTALAMOUNT = "invoiceLineTotalAmount";
    public static final String PROPERTY_STATUSINV = "statusInv";
    public static final String PROPERTY_STATUSORD = "statusOrd";
    public static final String PROPERTY_DATEINV = "dateInv";
    public static final String PROPERTY_DATEORD = "dateOrd";

    public SFBBudgetCertLineDet() {
        setDefaultValue(PROPERTY_ACTIVE, true);
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

    public Boolean isActive() {
        return (Boolean) get(PROPERTY_ACTIVE);
    }

    public void setActive(Boolean active) {
        set(PROPERTY_ACTIVE, active);
    }

    public OrderLine getSalesOrderLine() {
        return (OrderLine) get(PROPERTY_SALESORDERLINE);
    }

    public void setSalesOrderLine(OrderLine salesOrderLine) {
        set(PROPERTY_SALESORDERLINE, salesOrderLine);
    }

    public SFBBudgetCertLine getSfbBudgetCertLine() {
        return (SFBBudgetCertLine) get(PROPERTY_SFBBUDGETCERTLINE);
    }

    public void setSfbBudgetCertLine(SFBBudgetCertLine sfbBudgetCertLine) {
        set(PROPERTY_SFBBUDGETCERTLINE, sfbBudgetCertLine);
    }

    public Order getSalesOrder() {
        return (Order) get(PROPERTY_SALESORDER);
    }

    public void setSalesOrder(Order salesOrder) {
        set(PROPERTY_SALESORDER, salesOrder);
    }

    public BusinessPartner getOrderBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_ORDERBUSINESSPARTNER);
    }

    public void setOrderBusinessPartner(BusinessPartner orderBusinessPartner) {
        set(PROPERTY_ORDERBUSINESSPARTNER, orderBusinessPartner);
    }

    public Currency getOrderCurrency() {
        return (Currency) get(PROPERTY_ORDERCURRENCY);
    }

    public void setOrderCurrency(Currency orderCurrency) {
        set(PROPERTY_ORDERCURRENCY, orderCurrency);
    }

    public BigDecimal getOrderLineTotalAmount() {
        return (BigDecimal) get(PROPERTY_ORDERLINETOTALAMOUNT);
    }

    public void setOrderLineTotalAmount(BigDecimal orderLineTotalAmount) {
        set(PROPERTY_ORDERLINETOTALAMOUNT, orderLineTotalAmount);
    }

    public InvoiceLine getInvoiceLine() {
        return (InvoiceLine) get(PROPERTY_INVOICELINE);
    }

    public void setInvoiceLine(InvoiceLine invoiceLine) {
        set(PROPERTY_INVOICELINE, invoiceLine);
    }

    public Invoice getInvoice() {
        return (Invoice) get(PROPERTY_INVOICE);
    }

    public void setInvoice(Invoice invoice) {
        set(PROPERTY_INVOICE, invoice);
    }

    public BusinessPartner getInvoiceBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_INVOICEBUSINESSPARTNER);
    }

    public void setInvoiceBusinessPartner(BusinessPartner invoiceBusinessPartner) {
        set(PROPERTY_INVOICEBUSINESSPARTNER, invoiceBusinessPartner);
    }

    public Currency getInvoiceCurrency() {
        return (Currency) get(PROPERTY_INVOICECURRENCY);
    }

    public void setInvoiceCurrency(Currency invoiceCurrency) {
        set(PROPERTY_INVOICECURRENCY, invoiceCurrency);
    }

    public BigDecimal getInvoiceLineTotalAmount() {
        return (BigDecimal) get(PROPERTY_INVOICELINETOTALAMOUNT);
    }

    public void setInvoiceLineTotalAmount(BigDecimal invoiceLineTotalAmount) {
        set(PROPERTY_INVOICELINETOTALAMOUNT, invoiceLineTotalAmount);
    }

    public String getStatusInv() {
        return (String) get(PROPERTY_STATUSINV);
    }

    public void setStatusInv(String statusInv) {
        set(PROPERTY_STATUSINV, statusInv);
    }

    public String getStatusOrd() {
        return (String) get(PROPERTY_STATUSORD);
    }

    public void setStatusOrd(String statusOrd) {
        set(PROPERTY_STATUSORD, statusOrd);
    }

    public Date getDateInv() {
        return (Date) get(PROPERTY_DATEINV);
    }

    public void setDateInv(Date dateInv) {
        set(PROPERTY_DATEINV, dateInv);
    }

    public Date getDateOrd() {
        return (Date) get(PROPERTY_DATEORD);
    }

    public void setDateOrd(Date dateOrd) {
        set(PROPERTY_DATEORD, dateOrd);
    }

}
