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
package ec.cusoft.facturaec;

import com.sidesoft.localization.ecuador.finances.ssfiFin_payment_detail_v;

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
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.financialmgmt.payment.FIN_FinancialAccount;
import org.openbravo.model.financialmgmt.payment.FIN_Payment;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentMethod;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentSchedInvV;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentSchedOrdV;
import org.openbravo.model.marketing.Campaign;
import org.openbravo.model.materialmgmt.cost.ABCActivity;
import org.openbravo.model.project.Project;
import org.openbravo.model.sales.SalesRegion;
/**
 * Entity class for entity eei_payment_detail_v (stored in table eei_payment_detail_v).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class EeiPaymentDetailV extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "eei_payment_detail_v";
    public static final String ENTITY_NAME = "eei_payment_detail_v";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_INVOICE = "invoice";
    public static final String PROPERTY_ISSOTRX = "issotrx";
    public static final String PROPERTY_DOCSTATUS = "docstatus";
    public static final String PROPERTY_SSFIFINPAYMENTDETAILV = "ssfiFinPaymentDetailV";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_FINPAYMENTSCHEDINVV = "fINPaymentSchedInvV";
    public static final String PROPERTY_FINPAYMENTSCHEDORDV = "fINPaymentSchedOrdV";
    public static final String PROPERTY_INVOICENO = "invoiceno";
    public static final String PROPERTY_ORDERNO = "orderno";
    public static final String PROPERTY_PAYMENTNO = "paymentno";
    public static final String PROPERTY_FINPAYMENT = "fINPayment";
    public static final String PROPERTY_DUEDATE = "duedate";
    public static final String PROPERTY_INVOICEDAMT = "invoicedamt";
    public static final String PROPERTY_EXPECTED = "expected";
    public static final String PROPERTY_PAIDAMT = "paidamt";
    public static final String PROPERTY_BPARTNER = "bpartner";
    public static final String PROPERTY_FINPAYMENTMETHOD = "fINPaymentmethod";
    public static final String PROPERTY_FINFINANCIALACCOUNT = "fINFinancialAccount";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_PAYMENTDATE = "paymentdate";
    public static final String PROPERTY_GLITEMNAME = "glitemname";
    public static final String PROPERTY_WRITEOFFAMT = "writeoffamt";
    public static final String PROPERTY_FINACCTXNCONVERTRATE = "finaccTxnConvertRate";
    public static final String PROPERTY_AMOUNT = "amount";
    public static final String PROPERTY_PAIDCONVERTED = "paidconverted";
    public static final String PROPERTY_COALESCE = "coalesce";
    public static final String PROPERTY_EXPECTEDCONVERTED = "expectedconverted";
    public static final String PROPERTY_ISCANCELED = "iscanceled";
    public static final String PROPERTY_BPARTNERIDDIM = "bpartnerIdDim";
    public static final String PROPERTY_ACTIVITY = "activity";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_CAMPAIGN = "campaign";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_SALESREGION = "salesregion";
    public static final String PROPERTY_STATUS = "status";
    public static final String PROPERTY_INVOICEREFERENCE = "invoiceReference";

    public EeiPaymentDetailV() {
        setDefaultValue(PROPERTY_ISSOTRX, false);
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_ISCANCELED, false);
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

    public Invoice getInvoice() {
        return (Invoice) get(PROPERTY_INVOICE);
    }

    public void setInvoice(Invoice invoice) {
        set(PROPERTY_INVOICE, invoice);
    }

    public Boolean isSotrx() {
        return (Boolean) get(PROPERTY_ISSOTRX);
    }

    public void setSotrx(Boolean issotrx) {
        set(PROPERTY_ISSOTRX, issotrx);
    }

    public String getDocstatus() {
        return (String) get(PROPERTY_DOCSTATUS);
    }

    public void setDocstatus(String docstatus) {
        set(PROPERTY_DOCSTATUS, docstatus);
    }

    public ssfiFin_payment_detail_v getSsfiFinPaymentDetailV() {
        return (ssfiFin_payment_detail_v) get(PROPERTY_SSFIFINPAYMENTDETAILV);
    }

    public void setSsfiFinPaymentDetailV(ssfiFin_payment_detail_v ssfiFinPaymentDetailV) {
        set(PROPERTY_SSFIFINPAYMENTDETAILV, ssfiFinPaymentDetailV);
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

    public FIN_PaymentSchedInvV getFINPaymentSchedInvV() {
        return (FIN_PaymentSchedInvV) get(PROPERTY_FINPAYMENTSCHEDINVV);
    }

    public void setFINPaymentSchedInvV(FIN_PaymentSchedInvV fINPaymentSchedInvV) {
        set(PROPERTY_FINPAYMENTSCHEDINVV, fINPaymentSchedInvV);
    }

    public FIN_PaymentSchedOrdV getFINPaymentSchedOrdV() {
        return (FIN_PaymentSchedOrdV) get(PROPERTY_FINPAYMENTSCHEDORDV);
    }

    public void setFINPaymentSchedOrdV(FIN_PaymentSchedOrdV fINPaymentSchedOrdV) {
        set(PROPERTY_FINPAYMENTSCHEDORDV, fINPaymentSchedOrdV);
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

    public FIN_Payment getFINPayment() {
        return (FIN_Payment) get(PROPERTY_FINPAYMENT);
    }

    public void setFINPayment(FIN_Payment fINPayment) {
        set(PROPERTY_FINPAYMENT, fINPayment);
    }

    public Date getDuedate() {
        return (Date) get(PROPERTY_DUEDATE);
    }

    public void setDuedate(Date duedate) {
        set(PROPERTY_DUEDATE, duedate);
    }

    public Long getInvoicedamt() {
        return (Long) get(PROPERTY_INVOICEDAMT);
    }

    public void setInvoicedamt(Long invoicedamt) {
        set(PROPERTY_INVOICEDAMT, invoicedamt);
    }

    public Long getExpected() {
        return (Long) get(PROPERTY_EXPECTED);
    }

    public void setExpected(Long expected) {
        set(PROPERTY_EXPECTED, expected);
    }

    public Long getPaidamt() {
        return (Long) get(PROPERTY_PAIDAMT);
    }

    public void setPaidamt(Long paidamt) {
        set(PROPERTY_PAIDAMT, paidamt);
    }

    public BusinessPartner getBpartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBpartner(BusinessPartner bpartner) {
        set(PROPERTY_BPARTNER, bpartner);
    }

    public FIN_PaymentMethod getFINPaymentmethod() {
        return (FIN_PaymentMethod) get(PROPERTY_FINPAYMENTMETHOD);
    }

    public void setFINPaymentmethod(FIN_PaymentMethod fINPaymentmethod) {
        set(PROPERTY_FINPAYMENTMETHOD, fINPaymentmethod);
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

    public Date getPaymentdate() {
        return (Date) get(PROPERTY_PAYMENTDATE);
    }

    public void setPaymentdate(Date paymentdate) {
        set(PROPERTY_PAYMENTDATE, paymentdate);
    }

    public String getGlitemname() {
        return (String) get(PROPERTY_GLITEMNAME);
    }

    public void setGlitemname(String glitemname) {
        set(PROPERTY_GLITEMNAME, glitemname);
    }

    public Long getWriteoffamt() {
        return (Long) get(PROPERTY_WRITEOFFAMT);
    }

    public void setWriteoffamt(Long writeoffamt) {
        set(PROPERTY_WRITEOFFAMT, writeoffamt);
    }

    public Long getFinaccTxnConvertRate() {
        return (Long) get(PROPERTY_FINACCTXNCONVERTRATE);
    }

    public void setFinaccTxnConvertRate(Long finaccTxnConvertRate) {
        set(PROPERTY_FINACCTXNCONVERTRATE, finaccTxnConvertRate);
    }

    public Long getAmount() {
        return (Long) get(PROPERTY_AMOUNT);
    }

    public void setAmount(Long amount) {
        set(PROPERTY_AMOUNT, amount);
    }

    public Long getPaidconverted() {
        return (Long) get(PROPERTY_PAIDCONVERTED);
    }

    public void setPaidconverted(Long paidconverted) {
        set(PROPERTY_PAIDCONVERTED, paidconverted);
    }

    public Long getCoalesce() {
        return (Long) get(PROPERTY_COALESCE);
    }

    public void setCoalesce(Long coalesce) {
        set(PROPERTY_COALESCE, coalesce);
    }

    public Long getExpectedconverted() {
        return (Long) get(PROPERTY_EXPECTEDCONVERTED);
    }

    public void setExpectedconverted(Long expectedconverted) {
        set(PROPERTY_EXPECTEDCONVERTED, expectedconverted);
    }

    public Boolean isCanceled() {
        return (Boolean) get(PROPERTY_ISCANCELED);
    }

    public void setCanceled(Boolean iscanceled) {
        set(PROPERTY_ISCANCELED, iscanceled);
    }

    public String getBpartnerIdDim() {
        return (String) get(PROPERTY_BPARTNERIDDIM);
    }

    public void setBpartnerIdDim(String bpartnerIdDim) {
        set(PROPERTY_BPARTNERIDDIM, bpartnerIdDim);
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

    public Campaign getCampaign() {
        return (Campaign) get(PROPERTY_CAMPAIGN);
    }

    public void setCampaign(Campaign campaign) {
        set(PROPERTY_CAMPAIGN, campaign);
    }

    public Project getProject() {
        return (Project) get(PROPERTY_PROJECT);
    }

    public void setProject(Project project) {
        set(PROPERTY_PROJECT, project);
    }

    public SalesRegion getSalesregion() {
        return (SalesRegion) get(PROPERTY_SALESREGION);
    }

    public void setSalesregion(SalesRegion salesregion) {
        set(PROPERTY_SALESREGION, salesregion);
    }

    public String getStatus() {
        return (String) get(PROPERTY_STATUS);
    }

    public void setStatus(String status) {
        set(PROPERTY_STATUS, status);
    }

    public String getInvoiceReference() {
        return (String) get(PROPERTY_INVOICEREFERENCE);
    }

    public void setInvoiceReference(String invoiceReference) {
        set(PROPERTY_INVOICEREFERENCE, invoiceReference);
    }

}
