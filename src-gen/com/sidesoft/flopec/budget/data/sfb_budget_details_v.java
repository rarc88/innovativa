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
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.accounting.UserDimension1;
import org.openbravo.model.financialmgmt.calendar.Year;
import org.openbravo.model.financialmgmt.gl.GLJournal;
import org.openbravo.model.financialmgmt.gl.GLJournalLine;
import org.openbravo.model.financialmgmt.payment.FIN_Payment;
/**
 * Entity class for entity sfb_budget_details_v (stored in table sfb_budget_details_v).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class sfb_budget_details_v extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sfb_budget_details_v";
    public static final String ENTITY_NAME = "sfb_budget_details_v";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_YEAR = "year";
    public static final String PROPERTY_TYPEOFBUDGET = "typeOfBudget";
    public static final String PROPERTY_DATEFROM = "dateFrom";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_LINE = "line";
    public static final String PROPERTY_SFBBUDGETAREA = "sFBBudgetArea";
    public static final String PROPERTY_COSTCENTER = "costcenter";
    public static final String PROPERTY_SFBBUDGETITEM = "sFBBudgetItem";
    public static final String PROPERTY_USER1 = "user1";
    public static final String PROPERTY_BUDGETEDVALUE = "budgetedValue";
    public static final String PROPERTY_ADJUSTEDVALUE = "adjustedValue";
    public static final String PROPERTY_COMMITTEDVALUE = "committedValue";
    public static final String PROPERTY_AVAILABLEBALANCE = "availableBalance";
    public static final String PROPERTY_EXECUTEDVALUE = "executedValue";
    public static final String PROPERTY_ACTUALVALUE = "actualValue";
    public static final String PROPERTY_CERTIFIEDVALUECERT = "certifiedValueCert";
    public static final String PROPERTY_COMMITTEDVALUECERT = "committedValueCert";
    public static final String PROPERTY_AVAILABLEBALANCECERT = "availableBalanceCert";
    public static final String PROPERTY_EXECUTEDVALUECERT = "executedValueCert";
    public static final String PROPERTY_ACTUALVALUECERT = "actualValueCert";
    public static final String PROPERTY_ORDER = "order";
    public static final String PROPERTY_ORDERLINE = "orderline";
    public static final String PROPERTY_BPARTNERORD = "bpartnerOrd";
    public static final String PROPERTY_TOTALAMTORD = "totalamtOrd";
    public static final String PROPERTY_INVOICE = "invoice";
    public static final String PROPERTY_INVOICELINE = "invoiceline";
    public static final String PROPERTY_BPARTNERINV = "bpartnerInv";
    public static final String PROPERTY_TOTALAMTINV = "totalamtInv";
    public static final String PROPERTY_JOURNAL = "journal";
    public static final String PROPERTY_JOURNALLINE = "journalline";
    public static final String PROPERTY_TOTALAMTJOUR = "totalamtJour";
    public static final String PROPERTY_FINPAYMENT = "fINPayment";
    public static final String PROPERTY_BPARTNERIDPAY = "bpartnerIdPay";
    public static final String PROPERTY_AMOUNTPAY = "amountPay";

    public sfb_budget_details_v() {
        setDefaultValue(PROPERTY_ACTIVE, true);
    }

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
    }

    public User getUpdatedBy() {
        return (User) get(PROPERTY_UPDATEDBY);
    }

    public void setUpdatedBy(User updatedBy) {
        set(PROPERTY_UPDATEDBY, updatedBy);
    }

    public Date getUpdated() {
        return (Date) get(PROPERTY_UPDATED);
    }

    public void setUpdated(Date updated) {
        set(PROPERTY_UPDATED, updated);
    }

    public User getCreatedBy() {
        return (User) get(PROPERTY_CREATEDBY);
    }

    public void setCreatedBy(User createdBy) {
        set(PROPERTY_CREATEDBY, createdBy);
    }

    public Date getCreationDate() {
        return (Date) get(PROPERTY_CREATIONDATE);
    }

    public void setCreationDate(Date creationDate) {
        set(PROPERTY_CREATIONDATE, creationDate);
    }

    public Boolean isActive() {
        return (Boolean) get(PROPERTY_ACTIVE);
    }

    public void setActive(Boolean active) {
        set(PROPERTY_ACTIVE, active);
    }

    public Client getClient() {
        return (Client) get(PROPERTY_CLIENT);
    }

    public void setClient(Client client) {
        set(PROPERTY_CLIENT, client);
    }

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
    }

    public Organization getOrganization() {
        return (Organization) get(PROPERTY_ORGANIZATION);
    }

    public void setOrganization(Organization organization) {
        set(PROPERTY_ORGANIZATION, organization);
    }

    public Year getYear() {
        return (Year) get(PROPERTY_YEAR);
    }

    public void setYear(Year year) {
        set(PROPERTY_YEAR, year);
    }

    public String getTypeOfBudget() {
        return (String) get(PROPERTY_TYPEOFBUDGET);
    }

    public void setTypeOfBudget(String typeOfBudget) {
        set(PROPERTY_TYPEOFBUDGET, typeOfBudget);
    }

    public Date getDateFrom() {
        return (Date) get(PROPERTY_DATEFROM);
    }

    public void setDateFrom(Date dateFrom) {
        set(PROPERTY_DATEFROM, dateFrom);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public Long getLine() {
        return (Long) get(PROPERTY_LINE);
    }

    public void setLine(Long line) {
        set(PROPERTY_LINE, line);
    }

    public SFBBudgetArea getSFBBudgetArea() {
        return (SFBBudgetArea) get(PROPERTY_SFBBUDGETAREA);
    }

    public void setSFBBudgetArea(SFBBudgetArea sFBBudgetArea) {
        set(PROPERTY_SFBBUDGETAREA, sFBBudgetArea);
    }

    public Costcenter getCostcenter() {
        return (Costcenter) get(PROPERTY_COSTCENTER);
    }

    public void setCostcenter(Costcenter costcenter) {
        set(PROPERTY_COSTCENTER, costcenter);
    }

    public SFBBudgetItem getSFBBudgetItem() {
        return (SFBBudgetItem) get(PROPERTY_SFBBUDGETITEM);
    }

    public void setSFBBudgetItem(SFBBudgetItem sFBBudgetItem) {
        set(PROPERTY_SFBBUDGETITEM, sFBBudgetItem);
    }

    public UserDimension1 getUser1() {
        return (UserDimension1) get(PROPERTY_USER1);
    }

    public void setUser1(UserDimension1 user1) {
        set(PROPERTY_USER1, user1);
    }

    public BigDecimal getBudgetedValue() {
        return (BigDecimal) get(PROPERTY_BUDGETEDVALUE);
    }

    public void setBudgetedValue(BigDecimal budgetedValue) {
        set(PROPERTY_BUDGETEDVALUE, budgetedValue);
    }

    public BigDecimal getAdjustedValue() {
        return (BigDecimal) get(PROPERTY_ADJUSTEDVALUE);
    }

    public void setAdjustedValue(BigDecimal adjustedValue) {
        set(PROPERTY_ADJUSTEDVALUE, adjustedValue);
    }

    public BigDecimal getCommittedValue() {
        return (BigDecimal) get(PROPERTY_COMMITTEDVALUE);
    }

    public void setCommittedValue(BigDecimal committedValue) {
        set(PROPERTY_COMMITTEDVALUE, committedValue);
    }

    public BigDecimal getAvailableBalance() {
        return (BigDecimal) get(PROPERTY_AVAILABLEBALANCE);
    }

    public void setAvailableBalance(BigDecimal availableBalance) {
        set(PROPERTY_AVAILABLEBALANCE, availableBalance);
    }

    public BigDecimal getExecutedValue() {
        return (BigDecimal) get(PROPERTY_EXECUTEDVALUE);
    }

    public void setExecutedValue(BigDecimal executedValue) {
        set(PROPERTY_EXECUTEDVALUE, executedValue);
    }

    public BigDecimal getActualValue() {
        return (BigDecimal) get(PROPERTY_ACTUALVALUE);
    }

    public void setActualValue(BigDecimal actualValue) {
        set(PROPERTY_ACTUALVALUE, actualValue);
    }

    public BigDecimal getCertifiedValueCert() {
        return (BigDecimal) get(PROPERTY_CERTIFIEDVALUECERT);
    }

    public void setCertifiedValueCert(BigDecimal certifiedValueCert) {
        set(PROPERTY_CERTIFIEDVALUECERT, certifiedValueCert);
    }

    public BigDecimal getCommittedValueCert() {
        return (BigDecimal) get(PROPERTY_COMMITTEDVALUECERT);
    }

    public void setCommittedValueCert(BigDecimal committedValueCert) {
        set(PROPERTY_COMMITTEDVALUECERT, committedValueCert);
    }

    public BigDecimal getAvailableBalanceCert() {
        return (BigDecimal) get(PROPERTY_AVAILABLEBALANCECERT);
    }

    public void setAvailableBalanceCert(BigDecimal availableBalanceCert) {
        set(PROPERTY_AVAILABLEBALANCECERT, availableBalanceCert);
    }

    public BigDecimal getExecutedValueCert() {
        return (BigDecimal) get(PROPERTY_EXECUTEDVALUECERT);
    }

    public void setExecutedValueCert(BigDecimal executedValueCert) {
        set(PROPERTY_EXECUTEDVALUECERT, executedValueCert);
    }

    public BigDecimal getActualValueCert() {
        return (BigDecimal) get(PROPERTY_ACTUALVALUECERT);
    }

    public void setActualValueCert(BigDecimal actualValueCert) {
        set(PROPERTY_ACTUALVALUECERT, actualValueCert);
    }

    public Order getOrder() {
        return (Order) get(PROPERTY_ORDER);
    }

    public void setOrder(Order order) {
        set(PROPERTY_ORDER, order);
    }

    public OrderLine getOrderline() {
        return (OrderLine) get(PROPERTY_ORDERLINE);
    }

    public void setOrderline(OrderLine orderline) {
        set(PROPERTY_ORDERLINE, orderline);
    }

    public BusinessPartner getBpartnerOrd() {
        return (BusinessPartner) get(PROPERTY_BPARTNERORD);
    }

    public void setBpartnerOrd(BusinessPartner bpartnerOrd) {
        set(PROPERTY_BPARTNERORD, bpartnerOrd);
    }

    public BigDecimal getTotalamtOrd() {
        return (BigDecimal) get(PROPERTY_TOTALAMTORD);
    }

    public void setTotalamtOrd(BigDecimal totalamtOrd) {
        set(PROPERTY_TOTALAMTORD, totalamtOrd);
    }

    public Invoice getInvoice() {
        return (Invoice) get(PROPERTY_INVOICE);
    }

    public void setInvoice(Invoice invoice) {
        set(PROPERTY_INVOICE, invoice);
    }

    public InvoiceLine getInvoiceline() {
        return (InvoiceLine) get(PROPERTY_INVOICELINE);
    }

    public void setInvoiceline(InvoiceLine invoiceline) {
        set(PROPERTY_INVOICELINE, invoiceline);
    }

    public BusinessPartner getBpartnerInv() {
        return (BusinessPartner) get(PROPERTY_BPARTNERINV);
    }

    public void setBpartnerInv(BusinessPartner bpartnerInv) {
        set(PROPERTY_BPARTNERINV, bpartnerInv);
    }

    public BigDecimal getTotalamtInv() {
        return (BigDecimal) get(PROPERTY_TOTALAMTINV);
    }

    public void setTotalamtInv(BigDecimal totalamtInv) {
        set(PROPERTY_TOTALAMTINV, totalamtInv);
    }

    public GLJournal getJournal() {
        return (GLJournal) get(PROPERTY_JOURNAL);
    }

    public void setJournal(GLJournal journal) {
        set(PROPERTY_JOURNAL, journal);
    }

    public GLJournalLine getJournalline() {
        return (GLJournalLine) get(PROPERTY_JOURNALLINE);
    }

    public void setJournalline(GLJournalLine journalline) {
        set(PROPERTY_JOURNALLINE, journalline);
    }

    public BigDecimal getTotalamtJour() {
        return (BigDecimal) get(PROPERTY_TOTALAMTJOUR);
    }

    public void setTotalamtJour(BigDecimal totalamtJour) {
        set(PROPERTY_TOTALAMTJOUR, totalamtJour);
    }

    public FIN_Payment getFINPayment() {
        return (FIN_Payment) get(PROPERTY_FINPAYMENT);
    }

    public void setFINPayment(FIN_Payment fINPayment) {
        set(PROPERTY_FINPAYMENT, fINPayment);
    }

    public BusinessPartner getBpartnerIdPay() {
        return (BusinessPartner) get(PROPERTY_BPARTNERIDPAY);
    }

    public void setBpartnerIdPay(BusinessPartner bpartnerIdPay) {
        set(PROPERTY_BPARTNERIDPAY, bpartnerIdPay);
    }

    public BigDecimal getAmountPay() {
        return (BigDecimal) get(PROPERTY_AMOUNTPAY);
    }

    public void setAmountPay(BigDecimal amountPay) {
        set(PROPERTY_AMOUNTPAY, amountPay);
    }

}
