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
package com.sidesoft.localization.ecuador.finances;

import ec.cusoft.facturaec.EeiPaymentDetailV;

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
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.financialmgmt.payment.FIN_FinancialAccount;
import org.openbravo.model.financialmgmt.payment.FIN_Payment;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentMethod;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentSchedInvV;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentSchedOrdV;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentSchedule;
import org.openbravo.model.marketing.Campaign;
import org.openbravo.model.materialmgmt.cost.ABCActivity;
import org.openbravo.model.project.Project;
import org.openbravo.model.sales.SalesRegion;
/**
 * Entity class for entity ssfi_fin_payment_detail_v (stored in table ssfi_fin_payment_detail_v).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ssfiFin_payment_detail_v extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ssfi_fin_payment_detail_v";
    public static final String ENTITY_NAME = "ssfi_fin_payment_detail_v";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_INVOICEPAYMENTPLAN = "invoicePaymentPlan";
    public static final String PROPERTY_ORDERPAYMENTPLAN = "orderPaymentPlan";
    public static final String PROPERTY_FINPAYMENTSCHEDINV = "fINPaymentSchedInv";
    public static final String PROPERTY_PAYMENTPLANORDER = "paymentPlanOrder";
    public static final String PROPERTY_INVOICENO = "invoiceno";
    public static final String PROPERTY_ORDERNO = "orderno";
    public static final String PROPERTY_PAYMENTNO = "paymentno";
    public static final String PROPERTY_PAYMENT = "payment";
    public static final String PROPERTY_DUEDATE = "duedate";
    public static final String PROPERTY_INVOICEDAMT = "invoicedamt";
    public static final String PROPERTY_EXPECTED = "expected";
    public static final String PROPERTY_PAIDAMOUNT = "paidAmount";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_PAYMENTMETHOD = "paymentMethod";
    public static final String PROPERTY_FINFINANCIALACCOUNT = "fINFinancialAccount";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_PAYMENTDATE = "paymentDate";
    public static final String PROPERTY_GLITEMNAME = "glitemname";
    public static final String PROPERTY_WRITEOFFAMOUNT = "writeoffAmount";
    public static final String PROPERTY_FINACCCURRENCY = "finaccCurrency";
    public static final String PROPERTY_FINACCTXNCONVERTRATE = "finaccTxnConvertRate";
    public static final String PROPERTY_PAIDCONVERTED = "paidconverted";
    public static final String PROPERTY_EXPECTEDCONVERTED = "expectedconverted";
    public static final String PROPERTY_CANCELED = "canceled";
    public static final String PROPERTY_BUSINESSPARTNERDIM = "businessPartnerdim";
    public static final String PROPERTY_ACTIVITY = "activity";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_SALESCAMPAIGN = "salesCampaign";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_SALESREGION = "salesRegion";
    public static final String PROPERTY_STATUS = "status";
    public static final String PROPERTY_REFERENCE = "reference";
    public static final String PROPERTY_INVOICE = "invoice";
    public static final String PROPERTY_EEIPAYMENTDETAILVLIST = "eeiPaymentDetailVList";

    public ssfiFin_payment_detail_v() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_CANCELED, false);
        setDefaultValue(PROPERTY_EEIPAYMENTDETAILVLIST, new ArrayList<Object>());
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

    public FIN_PaymentSchedInvV getInvoicePaymentPlan() {
        return (FIN_PaymentSchedInvV) get(PROPERTY_INVOICEPAYMENTPLAN);
    }

    public void setInvoicePaymentPlan(FIN_PaymentSchedInvV invoicePaymentPlan) {
        set(PROPERTY_INVOICEPAYMENTPLAN, invoicePaymentPlan);
    }

    public FIN_PaymentSchedOrdV getOrderPaymentPlan() {
        return (FIN_PaymentSchedOrdV) get(PROPERTY_ORDERPAYMENTPLAN);
    }

    public void setOrderPaymentPlan(FIN_PaymentSchedOrdV orderPaymentPlan) {
        set(PROPERTY_ORDERPAYMENTPLAN, orderPaymentPlan);
    }

    public FIN_PaymentSchedule getFINPaymentSchedInv() {
        return (FIN_PaymentSchedule) get(PROPERTY_FINPAYMENTSCHEDINV);
    }

    public void setFINPaymentSchedInv(FIN_PaymentSchedule fINPaymentSchedInv) {
        set(PROPERTY_FINPAYMENTSCHEDINV, fINPaymentSchedInv);
    }

    public FIN_PaymentSchedule getPaymentPlanOrder() {
        return (FIN_PaymentSchedule) get(PROPERTY_PAYMENTPLANORDER);
    }

    public void setPaymentPlanOrder(FIN_PaymentSchedule paymentPlanOrder) {
        set(PROPERTY_PAYMENTPLANORDER, paymentPlanOrder);
    }

    public String getInvoiceno() {
        return (String) get(PROPERTY_INVOICENO);
    }

    public void setInvoiceno(String invoiceno) {
        set(PROPERTY_INVOICENO, invoiceno);
    }

    public String getOrderno() {
        return (String) get(PROPERTY_ORDERNO);
    }

    public void setOrderno(String orderno) {
        set(PROPERTY_ORDERNO, orderno);
    }

    public String getPaymentno() {
        return (String) get(PROPERTY_PAYMENTNO);
    }

    public void setPaymentno(String paymentno) {
        set(PROPERTY_PAYMENTNO, paymentno);
    }

    public FIN_Payment getPayment() {
        return (FIN_Payment) get(PROPERTY_PAYMENT);
    }

    public void setPayment(FIN_Payment payment) {
        set(PROPERTY_PAYMENT, payment);
    }

    public Date getDuedate() {
        return (Date) get(PROPERTY_DUEDATE);
    }

    public void setDuedate(Date duedate) {
        set(PROPERTY_DUEDATE, duedate);
    }

    public BigDecimal getInvoicedamt() {
        return (BigDecimal) get(PROPERTY_INVOICEDAMT);
    }

    public void setInvoicedamt(BigDecimal invoicedamt) {
        set(PROPERTY_INVOICEDAMT, invoicedamt);
    }

    public BigDecimal getExpected() {
        return (BigDecimal) get(PROPERTY_EXPECTED);
    }

    public void setExpected(BigDecimal expected) {
        set(PROPERTY_EXPECTED, expected);
    }

    public BigDecimal getPaidAmount() {
        return (BigDecimal) get(PROPERTY_PAIDAMOUNT);
    }

    public void setPaidAmount(BigDecimal paidAmount) {
        set(PROPERTY_PAIDAMOUNT, paidAmount);
    }

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public FIN_PaymentMethod getPaymentMethod() {
        return (FIN_PaymentMethod) get(PROPERTY_PAYMENTMETHOD);
    }

    public void setPaymentMethod(FIN_PaymentMethod paymentMethod) {
        set(PROPERTY_PAYMENTMETHOD, paymentMethod);
    }

    public FIN_FinancialAccount getFINFinancialAccount() {
        return (FIN_FinancialAccount) get(PROPERTY_FINFINANCIALACCOUNT);
    }

    public void setFINFinancialAccount(FIN_FinancialAccount fINFinancialAccount) {
        set(PROPERTY_FINFINANCIALACCOUNT, fINFinancialAccount);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public Date getPaymentDate() {
        return (Date) get(PROPERTY_PAYMENTDATE);
    }

    public void setPaymentDate(Date paymentDate) {
        set(PROPERTY_PAYMENTDATE, paymentDate);
    }

    public String getGlitemname() {
        return (String) get(PROPERTY_GLITEMNAME);
    }

    public void setGlitemname(String glitemname) {
        set(PROPERTY_GLITEMNAME, glitemname);
    }

    public BigDecimal getWriteoffAmount() {
        return (BigDecimal) get(PROPERTY_WRITEOFFAMOUNT);
    }

    public void setWriteoffAmount(BigDecimal writeoffAmount) {
        set(PROPERTY_WRITEOFFAMOUNT, writeoffAmount);
    }

    public Currency getFinaccCurrency() {
        return (Currency) get(PROPERTY_FINACCCURRENCY);
    }

    public void setFinaccCurrency(Currency finaccCurrency) {
        set(PROPERTY_FINACCCURRENCY, finaccCurrency);
    }

    public BigDecimal getFinaccTxnConvertRate() {
        return (BigDecimal) get(PROPERTY_FINACCTXNCONVERTRATE);
    }

    public void setFinaccTxnConvertRate(BigDecimal finaccTxnConvertRate) {
        set(PROPERTY_FINACCTXNCONVERTRATE, finaccTxnConvertRate);
    }

    public BigDecimal getPaidconverted() {
        return (BigDecimal) get(PROPERTY_PAIDCONVERTED);
    }

    public void setPaidconverted(BigDecimal paidconverted) {
        set(PROPERTY_PAIDCONVERTED, paidconverted);
    }

    public BigDecimal getExpectedconverted() {
        return (BigDecimal) get(PROPERTY_EXPECTEDCONVERTED);
    }

    public void setExpectedconverted(BigDecimal expectedconverted) {
        set(PROPERTY_EXPECTEDCONVERTED, expectedconverted);
    }

    public Boolean isCanceled() {
        return (Boolean) get(PROPERTY_CANCELED);
    }

    public void setCanceled(Boolean canceled) {
        set(PROPERTY_CANCELED, canceled);
    }

    public BusinessPartner getBusinessPartnerdim() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNERDIM);
    }

    public void setBusinessPartnerdim(BusinessPartner businessPartnerdim) {
        set(PROPERTY_BUSINESSPARTNERDIM, businessPartnerdim);
    }

    public ABCActivity getActivity() {
        return (ABCActivity) get(PROPERTY_ACTIVITY);
    }

    public void setActivity(ABCActivity activity) {
        set(PROPERTY_ACTIVITY, activity);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public Campaign getSalesCampaign() {
        return (Campaign) get(PROPERTY_SALESCAMPAIGN);
    }

    public void setSalesCampaign(Campaign salesCampaign) {
        set(PROPERTY_SALESCAMPAIGN, salesCampaign);
    }

    public Project getProject() {
        return (Project) get(PROPERTY_PROJECT);
    }

    public void setProject(Project project) {
        set(PROPERTY_PROJECT, project);
    }

    public SalesRegion getSalesRegion() {
        return (SalesRegion) get(PROPERTY_SALESREGION);
    }

    public void setSalesRegion(SalesRegion salesRegion) {
        set(PROPERTY_SALESREGION, salesRegion);
    }

    public String getStatus() {
        return (String) get(PROPERTY_STATUS);
    }

    public void setStatus(String status) {
        set(PROPERTY_STATUS, status);
    }

    public String getReference() {
        return (String) get(PROPERTY_REFERENCE);
    }

    public void setReference(String reference) {
        set(PROPERTY_REFERENCE, reference);
    }

    public Invoice getInvoice() {
        return (Invoice) get(PROPERTY_INVOICE);
    }

    public void setInvoice(Invoice invoice) {
        set(PROPERTY_INVOICE, invoice);
    }

    @SuppressWarnings("unchecked")
    public List<EeiPaymentDetailV> getEeiPaymentDetailVList() {
      return (List<EeiPaymentDetailV>) get(PROPERTY_EEIPAYMENTDETAILVLIST);
    }

    public void setEeiPaymentDetailVList(List<EeiPaymentDetailV> eeiPaymentDetailVList) {
        set(PROPERTY_EEIPAYMENTDETAILVLIST, eeiPaymentDetailVList);
    }

}
