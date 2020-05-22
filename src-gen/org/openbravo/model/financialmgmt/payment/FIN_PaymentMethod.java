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
package org.openbravo.model.financialmgmt.payment;

import com.sidesoft.hrm.payroll.ssprpayrollpayment;
import com.sidesoft.localization.ecuador.finances.ssfiFin_payment_detail_v;
import com.sidesoft.localization.ecuador.withholdings.ReceiptTax;
import com.sidesoft.localization.ecuador.withholdings.SswhWithhCardCredit;
import com.sidesoft.localization.ecuador.withholdings.sswhcountrypayment;

import ec.com.sidesoft.custom.payments.partialpayment.SSPPPAYMENTS;
import ec.com.sidesoft.localization.ecuador.withholdingssales.SSWSConfig;
import ec.com.sidesoft.quick.billing.SqbConfigQuickBilling;
import ec.com.sidesoft.quick.billing.SqbQuickBilling;
import ec.com.sidesoft.secondary.accounting.SSACCTJournalLine;
import ec.com.sidesoft.ws.invoicecreate.data.SWSICConfig;
import ec.cusoft.facturaec.EeiPaymentDetailV;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openbravo.advpaymentmngt.APRM_PaymentProposalPickEdit;
import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.common.invoice.InvoiceTaxCashVAT_V;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.financialmgmt.gl.GLJournalLine;
import org.openbravo.model.project.Project;
import org.openbravo.model.project.ProjectProposal;
/**
 * Entity class for entity FIN_PaymentMethod (stored in table FIN_PaymentMethod).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class FIN_PaymentMethod extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "FIN_PaymentMethod";
    public static final String ENTITY_NAME = "FIN_PaymentMethod";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_AUTOMATICRECEIPT = "automaticReceipt";
    public static final String PROPERTY_AUTOMATICPAYMENT = "automaticPayment";
    public static final String PROPERTY_AUTOMATICDEPOSIT = "automaticDeposit";
    public static final String PROPERTY_AUTOMATICWITHDRAWN = "automaticWithdrawn";
    public static final String PROPERTY_PAYINALLOW = "payinAllow";
    public static final String PROPERTY_PAYOUTALLOW = "payoutAllow";
    public static final String PROPERTY_PAYINEXECUTIONTYPE = "payinExecutionType";
    public static final String PROPERTY_PAYOUTEXECUTIONTYPE = "payoutExecutionType";
    public static final String PROPERTY_PAYINEXECUTIONPROCESS = "payinExecutionProcess";
    public static final String PROPERTY_PAYOUTEXECUTIONPROCESS = "payoutExecutionProcess";
    public static final String PROPERTY_PAYINDEFERRED = "payinDeferred";
    public static final String PROPERTY_PAYOUTDEFERRED = "payoutDeferred";
    public static final String PROPERTY_UPONRECEIPTUSE = "uponReceiptUse";
    public static final String PROPERTY_UPONDEPOSITUSE = "uponDepositUse";
    public static final String PROPERTY_INUPONCLEARINGUSE = "iNUponClearingUse";
    public static final String PROPERTY_UPONPAYMENTUSE = "uponPaymentUse";
    public static final String PROPERTY_UPONWITHDRAWALUSE = "uponWithdrawalUse";
    public static final String PROPERTY_OUTUPONCLEARINGUSE = "oUTUponClearingUse";
    public static final String PROPERTY_PAYINISMULTICURRENCY = "payinIsMulticurrency";
    public static final String PROPERTY_PAYOUTISMULTICURRENCY = "payoutIsMulticurrency";
    public static final String PROPERTY_SSWHWITHHOLDINGTYPE = "sSWHWithholdingType";
    public static final String PROPERTY_SSWHVALUE = "sswhValue";
    public static final String PROPERTY_SSWHTYPEPAYMENT = "sSWHTypePayment";
    public static final String PROPERTY_SSWHCOUNTRYSOURCEOFPAYMENT = "sSWHCountrySourceOfPayment";
    public static final String PROPERTY_SSWHSUBJECTTOWITHHOLDING = "sSWHSubjectToWithholding";
    public static final String PROPERTY_SSWHAPPLYDOUBLETAXATION = "sSWHApplyDoubleTaxation";
    public static final String PROPERTY_SSWHCODEATS = "sswhCodeats";
    public static final String PROPERTY_SSWHFISCALREGIME = "sswhFiscalregime";
    public static final String PROPERTY_SSWHCODE = "sswhCode";
    public static final String PROPERTY_SSWHPERCENTAGE = "sswhPercentage";
    public static final String PROPERTY_SSWHELECTRONICMONEY = "sswhElectronicMoney";
    public static final String PROPERTY_EEICODEEI = "eeiCodeEi";
    public static final String PROPERTY_SSPPWIRETRANSFER = "sSPPWireTransfer";
    public static final String PROPERTY_APRMPAYMENTPROPOSALPICKEDITLIST = "aPRMPaymentProposalPickEditList";
    public static final String PROPERTY_BUSINESSPARTNERLIST = "businessPartnerList";
    public static final String PROPERTY_BUSINESSPARTNERPOPAYMENTMETHODLIST = "businessPartnerPOPaymentMethodList";
    public static final String PROPERTY_INVOICETAXCASHVATVLIST = "invoiceTaxCashVATVList";
    public static final String PROPERTY_FINDOUBTFULDEBTVLIST = "fINDoubtfulDebtVList";
    public static final String PROPERTY_FINPAYMENTLIST = "fINPaymentList";
    public static final String PROPERTY_FINPAYMENTDETAILVLIST = "fINPaymentDetailVList";
    public static final String PROPERTY_FINPAYMENTDETAILVEMAPRMDISPLAYEDPAYMMETHIDLIST = "fINPaymentDetailVEMAPRMDisplayedPaymmethIDList";
    public static final String PROPERTY_FINPAYMENTPROPOSALLIST = "fINPaymentProposalList";
    public static final String PROPERTY_FINPAYMENTSCHEDINVVLIST = "fINPaymentSchedInvVList";
    public static final String PROPERTY_FINPAYMENTSCHEDORDVLIST = "fINPaymentSchedOrdVList";
    public static final String PROPERTY_FINPAYMENTSCHEDULELIST = "fINPaymentScheduleList";
    public static final String PROPERTY_FINORIGPAYMENTSCHEDULELIST = "finOrigPaymentScheduleList";
    public static final String PROPERTY_FINANCIALMGMTFINACCPAYMENTMETHODLIST = "financialMgmtFinAccPaymentMethodList";
    public static final String PROPERTY_FINANCIALMGMTGLJOURNALLINELIST = "financialMgmtGLJournalLineList";
    public static final String PROPERTY_FINANCIALMGMTPAYMENTTERMLINELIST = "financialMgmtPaymentTermLineList";
    public static final String PROPERTY_INVOICELIST = "invoiceList";
    public static final String PROPERTY_ORDERLIST = "orderList";
    public static final String PROPERTY_PROJECTLIST = "projectList";
    public static final String PROPERTY_PROJECTPROPOSALLIST = "projectProposalList";
    public static final String PROPERTY_SSACCTJOURNALLINELIST = "sSACCTJournalLineList";
    public static final String PROPERTY_SSPPPAYMENTSLIST = "sSPPPAYMENTSList";
    public static final String PROPERTY_SSWHRECEIPTTAXLIST = "sSWHReceiptTaxList";
    public static final String PROPERTY_SSWSCONFIGLIST = "sSWSConfigList";
    public static final String PROPERTY_SWSICCONFIGLIST = "sWSICConfigList";
    public static final String PROPERTY_EEIPAYMENTDETAILVLIST = "eeiPaymentDetailVList";
    public static final String PROPERTY_SQBCONFIGQUICKBILLINGLIST = "sqbConfigQuickbillingList";
    public static final String PROPERTY_SQBQUICKBILLINGLIST = "sqbQuickbillingList";
    public static final String PROPERTY_SSFIFINPAYMENTDETAILVLIST = "ssfiFinPaymentDetailVList";
    public static final String PROPERTY_SSPRPAYROLLPAYMENTLIST = "ssprPayrollpaymentList";
    public static final String PROPERTY_SSWHWITHHCARDCREDITLIST = "sswhWithhCardCreditList";

    public FIN_PaymentMethod() {
        setDefaultValue(PROPERTY_CREATIONDATE, new Date());
        setDefaultValue(PROPERTY_UPDATED, new Date());
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_AUTOMATICRECEIPT, false);
        setDefaultValue(PROPERTY_AUTOMATICPAYMENT, false);
        setDefaultValue(PROPERTY_AUTOMATICDEPOSIT, false);
        setDefaultValue(PROPERTY_AUTOMATICWITHDRAWN, false);
        setDefaultValue(PROPERTY_PAYINALLOW, true);
        setDefaultValue(PROPERTY_PAYOUTALLOW, true);
        setDefaultValue(PROPERTY_PAYINEXECUTIONTYPE, "M");
        setDefaultValue(PROPERTY_PAYOUTEXECUTIONTYPE, "M");
        setDefaultValue(PROPERTY_PAYINDEFERRED, false);
        setDefaultValue(PROPERTY_PAYOUTDEFERRED, false);
        setDefaultValue(PROPERTY_PAYINISMULTICURRENCY, false);
        setDefaultValue(PROPERTY_PAYOUTISMULTICURRENCY, false);
        setDefaultValue(PROPERTY_SSWHSUBJECTTOWITHHOLDING, false);
        setDefaultValue(PROPERTY_SSWHAPPLYDOUBLETAXATION, false);
        setDefaultValue(PROPERTY_SSWHFISCALREGIME, false);
        setDefaultValue(PROPERTY_SSWHELECTRONICMONEY, false);
        setDefaultValue(PROPERTY_SSPPWIRETRANSFER, false);
        setDefaultValue(PROPERTY_APRMPAYMENTPROPOSALPICKEDITLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_BUSINESSPARTNERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_BUSINESSPARTNERPOPAYMENTMETHODLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICETAXCASHVATVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINDOUBTFULDEBTVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTDETAILVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTDETAILVEMAPRMDISPLAYEDPAYMMETHIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTPROPOSALLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTSCHEDINVVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTSCHEDORDVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTSCHEDULELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINORIGPAYMENTSCHEDULELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTFINACCPAYMENTMETHODLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTGLJOURNALLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTPAYMENTTERMLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROJECTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROJECTPROPOSALLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSACCTJOURNALLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPPPAYMENTSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWHRECEIPTTAXLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWSCONFIGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SWSICCONFIGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_EEIPAYMENTDETAILVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SQBCONFIGQUICKBILLINGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SQBQUICKBILLINGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSFIFINPAYMENTDETAILVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRPAYROLLPAYMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWHWITHHCARDCREDITLIST, new ArrayList<Object>());
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

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Boolean isAutomaticReceipt() {
        return (Boolean) get(PROPERTY_AUTOMATICRECEIPT);
    }

    public void setAutomaticReceipt(Boolean automaticReceipt) {
        set(PROPERTY_AUTOMATICRECEIPT, automaticReceipt);
    }

    public Boolean isAutomaticPayment() {
        return (Boolean) get(PROPERTY_AUTOMATICPAYMENT);
    }

    public void setAutomaticPayment(Boolean automaticPayment) {
        set(PROPERTY_AUTOMATICPAYMENT, automaticPayment);
    }

    public Boolean isAutomaticDeposit() {
        return (Boolean) get(PROPERTY_AUTOMATICDEPOSIT);
    }

    public void setAutomaticDeposit(Boolean automaticDeposit) {
        set(PROPERTY_AUTOMATICDEPOSIT, automaticDeposit);
    }

    public Boolean isAutomaticWithdrawn() {
        return (Boolean) get(PROPERTY_AUTOMATICWITHDRAWN);
    }

    public void setAutomaticWithdrawn(Boolean automaticWithdrawn) {
        set(PROPERTY_AUTOMATICWITHDRAWN, automaticWithdrawn);
    }

    public Boolean isPayinAllow() {
        return (Boolean) get(PROPERTY_PAYINALLOW);
    }

    public void setPayinAllow(Boolean payinAllow) {
        set(PROPERTY_PAYINALLOW, payinAllow);
    }

    public Boolean isPayoutAllow() {
        return (Boolean) get(PROPERTY_PAYOUTALLOW);
    }

    public void setPayoutAllow(Boolean payoutAllow) {
        set(PROPERTY_PAYOUTALLOW, payoutAllow);
    }

    public String getPayinExecutionType() {
        return (String) get(PROPERTY_PAYINEXECUTIONTYPE);
    }

    public void setPayinExecutionType(String payinExecutionType) {
        set(PROPERTY_PAYINEXECUTIONTYPE, payinExecutionType);
    }

    public String getPayoutExecutionType() {
        return (String) get(PROPERTY_PAYOUTEXECUTIONTYPE);
    }

    public void setPayoutExecutionType(String payoutExecutionType) {
        set(PROPERTY_PAYOUTEXECUTIONTYPE, payoutExecutionType);
    }

    public PaymentExecutionProcess getPayinExecutionProcess() {
        return (PaymentExecutionProcess) get(PROPERTY_PAYINEXECUTIONPROCESS);
    }

    public void setPayinExecutionProcess(PaymentExecutionProcess payinExecutionProcess) {
        set(PROPERTY_PAYINEXECUTIONPROCESS, payinExecutionProcess);
    }

    public PaymentExecutionProcess getPayoutExecutionProcess() {
        return (PaymentExecutionProcess) get(PROPERTY_PAYOUTEXECUTIONPROCESS);
    }

    public void setPayoutExecutionProcess(PaymentExecutionProcess payoutExecutionProcess) {
        set(PROPERTY_PAYOUTEXECUTIONPROCESS, payoutExecutionProcess);
    }

    public Boolean isPayinDeferred() {
        return (Boolean) get(PROPERTY_PAYINDEFERRED);
    }

    public void setPayinDeferred(Boolean payinDeferred) {
        set(PROPERTY_PAYINDEFERRED, payinDeferred);
    }

    public Boolean isPayoutDeferred() {
        return (Boolean) get(PROPERTY_PAYOUTDEFERRED);
    }

    public void setPayoutDeferred(Boolean payoutDeferred) {
        set(PROPERTY_PAYOUTDEFERRED, payoutDeferred);
    }

    public String getUponReceiptUse() {
        return (String) get(PROPERTY_UPONRECEIPTUSE);
    }

    public void setUponReceiptUse(String uponReceiptUse) {
        set(PROPERTY_UPONRECEIPTUSE, uponReceiptUse);
    }

    public String getUponDepositUse() {
        return (String) get(PROPERTY_UPONDEPOSITUSE);
    }

    public void setUponDepositUse(String uponDepositUse) {
        set(PROPERTY_UPONDEPOSITUSE, uponDepositUse);
    }

    public String getINUponClearingUse() {
        return (String) get(PROPERTY_INUPONCLEARINGUSE);
    }

    public void setINUponClearingUse(String iNUponClearingUse) {
        set(PROPERTY_INUPONCLEARINGUSE, iNUponClearingUse);
    }

    public String getUponPaymentUse() {
        return (String) get(PROPERTY_UPONPAYMENTUSE);
    }

    public void setUponPaymentUse(String uponPaymentUse) {
        set(PROPERTY_UPONPAYMENTUSE, uponPaymentUse);
    }

    public String getUponWithdrawalUse() {
        return (String) get(PROPERTY_UPONWITHDRAWALUSE);
    }

    public void setUponWithdrawalUse(String uponWithdrawalUse) {
        set(PROPERTY_UPONWITHDRAWALUSE, uponWithdrawalUse);
    }

    public String getOUTUponClearingUse() {
        return (String) get(PROPERTY_OUTUPONCLEARINGUSE);
    }

    public void setOUTUponClearingUse(String oUTUponClearingUse) {
        set(PROPERTY_OUTUPONCLEARINGUSE, oUTUponClearingUse);
    }

    public Boolean isPayinIsMulticurrency() {
        return (Boolean) get(PROPERTY_PAYINISMULTICURRENCY);
    }

    public void setPayinIsMulticurrency(Boolean payinIsMulticurrency) {
        set(PROPERTY_PAYINISMULTICURRENCY, payinIsMulticurrency);
    }

    public Boolean isPayoutIsMulticurrency() {
        return (Boolean) get(PROPERTY_PAYOUTISMULTICURRENCY);
    }

    public void setPayoutIsMulticurrency(Boolean payoutIsMulticurrency) {
        set(PROPERTY_PAYOUTISMULTICURRENCY, payoutIsMulticurrency);
    }

    public String getSSWHWithholdingType() {
        return (String) get(PROPERTY_SSWHWITHHOLDINGTYPE);
    }

    public void setSSWHWithholdingType(String sSWHWithholdingType) {
        set(PROPERTY_SSWHWITHHOLDINGTYPE, sSWHWithholdingType);
    }

    public String getSswhValue() {
        return (String) get(PROPERTY_SSWHVALUE);
    }

    public void setSswhValue(String sswhValue) {
        set(PROPERTY_SSWHVALUE, sswhValue);
    }

    public String getSSWHTypePayment() {
        return (String) get(PROPERTY_SSWHTYPEPAYMENT);
    }

    public void setSSWHTypePayment(String sSWHTypePayment) {
        set(PROPERTY_SSWHTYPEPAYMENT, sSWHTypePayment);
    }

    public sswhcountrypayment getSSWHCountrySourceOfPayment() {
        return (sswhcountrypayment) get(PROPERTY_SSWHCOUNTRYSOURCEOFPAYMENT);
    }

    public void setSSWHCountrySourceOfPayment(sswhcountrypayment sSWHCountrySourceOfPayment) {
        set(PROPERTY_SSWHCOUNTRYSOURCEOFPAYMENT, sSWHCountrySourceOfPayment);
    }

    public Boolean isSSWHSubjectToWithholding() {
        return (Boolean) get(PROPERTY_SSWHSUBJECTTOWITHHOLDING);
    }

    public void setSSWHSubjectToWithholding(Boolean sSWHSubjectToWithholding) {
        set(PROPERTY_SSWHSUBJECTTOWITHHOLDING, sSWHSubjectToWithholding);
    }

    public Boolean isSSWHApplyDoubleTaxation() {
        return (Boolean) get(PROPERTY_SSWHAPPLYDOUBLETAXATION);
    }

    public void setSSWHApplyDoubleTaxation(Boolean sSWHApplyDoubleTaxation) {
        set(PROPERTY_SSWHAPPLYDOUBLETAXATION, sSWHApplyDoubleTaxation);
    }

    public String getSswhCodeats() {
        return (String) get(PROPERTY_SSWHCODEATS);
    }

    public void setSswhCodeats(String sswhCodeats) {
        set(PROPERTY_SSWHCODEATS, sswhCodeats);
    }

    public Boolean isSswhFiscalregime() {
        return (Boolean) get(PROPERTY_SSWHFISCALREGIME);
    }

    public void setSswhFiscalregime(Boolean sswhFiscalregime) {
        set(PROPERTY_SSWHFISCALREGIME, sswhFiscalregime);
    }

    public String getSswhCode() {
        return (String) get(PROPERTY_SSWHCODE);
    }

    public void setSswhCode(String sswhCode) {
        set(PROPERTY_SSWHCODE, sswhCode);
    }

    public Long getSswhPercentage() {
        return (Long) get(PROPERTY_SSWHPERCENTAGE);
    }

    public void setSswhPercentage(Long sswhPercentage) {
        set(PROPERTY_SSWHPERCENTAGE, sswhPercentage);
    }

    public Boolean isSswhElectronicMoney() {
        return (Boolean) get(PROPERTY_SSWHELECTRONICMONEY);
    }

    public void setSswhElectronicMoney(Boolean sswhElectronicMoney) {
        set(PROPERTY_SSWHELECTRONICMONEY, sswhElectronicMoney);
    }

    public String getEeiCodeEi() {
        return (String) get(PROPERTY_EEICODEEI);
    }

    public void setEeiCodeEi(String eeiCodeEi) {
        set(PROPERTY_EEICODEEI, eeiCodeEi);
    }

    public Boolean isSSPPWireTransfer() {
        return (Boolean) get(PROPERTY_SSPPWIRETRANSFER);
    }

    public void setSSPPWireTransfer(Boolean sSPPWireTransfer) {
        set(PROPERTY_SSPPWIRETRANSFER, sSPPWireTransfer);
    }

    @SuppressWarnings("unchecked")
    public List<APRM_PaymentProposalPickEdit> getAPRMPaymentProposalPickEditList() {
      return (List<APRM_PaymentProposalPickEdit>) get(PROPERTY_APRMPAYMENTPROPOSALPICKEDITLIST);
    }

    public void setAPRMPaymentProposalPickEditList(List<APRM_PaymentProposalPickEdit> aPRMPaymentProposalPickEditList) {
        set(PROPERTY_APRMPAYMENTPROPOSALPICKEDITLIST, aPRMPaymentProposalPickEditList);
    }

    @SuppressWarnings("unchecked")
    public List<BusinessPartner> getBusinessPartnerList() {
      return (List<BusinessPartner>) get(PROPERTY_BUSINESSPARTNERLIST);
    }

    public void setBusinessPartnerList(List<BusinessPartner> businessPartnerList) {
        set(PROPERTY_BUSINESSPARTNERLIST, businessPartnerList);
    }

    @SuppressWarnings("unchecked")
    public List<BusinessPartner> getBusinessPartnerPOPaymentMethodList() {
      return (List<BusinessPartner>) get(PROPERTY_BUSINESSPARTNERPOPAYMENTMETHODLIST);
    }

    public void setBusinessPartnerPOPaymentMethodList(List<BusinessPartner> businessPartnerPOPaymentMethodList) {
        set(PROPERTY_BUSINESSPARTNERPOPAYMENTMETHODLIST, businessPartnerPOPaymentMethodList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceTaxCashVAT_V> getInvoiceTaxCashVATVList() {
      return (List<InvoiceTaxCashVAT_V>) get(PROPERTY_INVOICETAXCASHVATVLIST);
    }

    public void setInvoiceTaxCashVATVList(List<InvoiceTaxCashVAT_V> invoiceTaxCashVATVList) {
        set(PROPERTY_INVOICETAXCASHVATVLIST, invoiceTaxCashVATVList);
    }

    @SuppressWarnings("unchecked")
    public List<DoubtfulDebtV> getFINDoubtfulDebtVList() {
      return (List<DoubtfulDebtV>) get(PROPERTY_FINDOUBTFULDEBTVLIST);
    }

    public void setFINDoubtfulDebtVList(List<DoubtfulDebtV> fINDoubtfulDebtVList) {
        set(PROPERTY_FINDOUBTFULDEBTVLIST, fINDoubtfulDebtVList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_Payment> getFINPaymentList() {
      return (List<FIN_Payment>) get(PROPERTY_FINPAYMENTLIST);
    }

    public void setFINPaymentList(List<FIN_Payment> fINPaymentList) {
        set(PROPERTY_FINPAYMENTLIST, fINPaymentList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_PaymentDetailV> getFINPaymentDetailVList() {
      return (List<FIN_PaymentDetailV>) get(PROPERTY_FINPAYMENTDETAILVLIST);
    }

    public void setFINPaymentDetailVList(List<FIN_PaymentDetailV> fINPaymentDetailVList) {
        set(PROPERTY_FINPAYMENTDETAILVLIST, fINPaymentDetailVList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_PaymentDetailV> getFINPaymentDetailVEMAPRMDisplayedPaymmethIDList() {
      return (List<FIN_PaymentDetailV>) get(PROPERTY_FINPAYMENTDETAILVEMAPRMDISPLAYEDPAYMMETHIDLIST);
    }

    public void setFINPaymentDetailVEMAPRMDisplayedPaymmethIDList(List<FIN_PaymentDetailV> fINPaymentDetailVEMAPRMDisplayedPaymmethIDList) {
        set(PROPERTY_FINPAYMENTDETAILVEMAPRMDISPLAYEDPAYMMETHIDLIST, fINPaymentDetailVEMAPRMDisplayedPaymmethIDList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_PaymentProposal> getFINPaymentProposalList() {
      return (List<FIN_PaymentProposal>) get(PROPERTY_FINPAYMENTPROPOSALLIST);
    }

    public void setFINPaymentProposalList(List<FIN_PaymentProposal> fINPaymentProposalList) {
        set(PROPERTY_FINPAYMENTPROPOSALLIST, fINPaymentProposalList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_PaymentSchedInvV> getFINPaymentSchedInvVList() {
      return (List<FIN_PaymentSchedInvV>) get(PROPERTY_FINPAYMENTSCHEDINVVLIST);
    }

    public void setFINPaymentSchedInvVList(List<FIN_PaymentSchedInvV> fINPaymentSchedInvVList) {
        set(PROPERTY_FINPAYMENTSCHEDINVVLIST, fINPaymentSchedInvVList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_PaymentSchedOrdV> getFINPaymentSchedOrdVList() {
      return (List<FIN_PaymentSchedOrdV>) get(PROPERTY_FINPAYMENTSCHEDORDVLIST);
    }

    public void setFINPaymentSchedOrdVList(List<FIN_PaymentSchedOrdV> fINPaymentSchedOrdVList) {
        set(PROPERTY_FINPAYMENTSCHEDORDVLIST, fINPaymentSchedOrdVList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_PaymentSchedule> getFINPaymentScheduleList() {
      return (List<FIN_PaymentSchedule>) get(PROPERTY_FINPAYMENTSCHEDULELIST);
    }

    public void setFINPaymentScheduleList(List<FIN_PaymentSchedule> fINPaymentScheduleList) {
        set(PROPERTY_FINPAYMENTSCHEDULELIST, fINPaymentScheduleList);
    }

    @SuppressWarnings("unchecked")
    public List<Fin_OrigPaymentSchedule> getFinOrigPaymentScheduleList() {
      return (List<Fin_OrigPaymentSchedule>) get(PROPERTY_FINORIGPAYMENTSCHEDULELIST);
    }

    public void setFinOrigPaymentScheduleList(List<Fin_OrigPaymentSchedule> finOrigPaymentScheduleList) {
        set(PROPERTY_FINORIGPAYMENTSCHEDULELIST, finOrigPaymentScheduleList);
    }

    @SuppressWarnings("unchecked")
    public List<FinAccPaymentMethod> getFinancialMgmtFinAccPaymentMethodList() {
      return (List<FinAccPaymentMethod>) get(PROPERTY_FINANCIALMGMTFINACCPAYMENTMETHODLIST);
    }

    public void setFinancialMgmtFinAccPaymentMethodList(List<FinAccPaymentMethod> financialMgmtFinAccPaymentMethodList) {
        set(PROPERTY_FINANCIALMGMTFINACCPAYMENTMETHODLIST, financialMgmtFinAccPaymentMethodList);
    }

    @SuppressWarnings("unchecked")
    public List<GLJournalLine> getFinancialMgmtGLJournalLineList() {
      return (List<GLJournalLine>) get(PROPERTY_FINANCIALMGMTGLJOURNALLINELIST);
    }

    public void setFinancialMgmtGLJournalLineList(List<GLJournalLine> financialMgmtGLJournalLineList) {
        set(PROPERTY_FINANCIALMGMTGLJOURNALLINELIST, financialMgmtGLJournalLineList);
    }

    @SuppressWarnings("unchecked")
    public List<PaymentTermLine> getFinancialMgmtPaymentTermLineList() {
      return (List<PaymentTermLine>) get(PROPERTY_FINANCIALMGMTPAYMENTTERMLINELIST);
    }

    public void setFinancialMgmtPaymentTermLineList(List<PaymentTermLine> financialMgmtPaymentTermLineList) {
        set(PROPERTY_FINANCIALMGMTPAYMENTTERMLINELIST, financialMgmtPaymentTermLineList);
    }

    @SuppressWarnings("unchecked")
    public List<Invoice> getInvoiceList() {
      return (List<Invoice>) get(PROPERTY_INVOICELIST);
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        set(PROPERTY_INVOICELIST, invoiceList);
    }

    @SuppressWarnings("unchecked")
    public List<Order> getOrderList() {
      return (List<Order>) get(PROPERTY_ORDERLIST);
    }

    public void setOrderList(List<Order> orderList) {
        set(PROPERTY_ORDERLIST, orderList);
    }

    @SuppressWarnings("unchecked")
    public List<Project> getProjectList() {
      return (List<Project>) get(PROPERTY_PROJECTLIST);
    }

    public void setProjectList(List<Project> projectList) {
        set(PROPERTY_PROJECTLIST, projectList);
    }

    @SuppressWarnings("unchecked")
    public List<ProjectProposal> getProjectProposalList() {
      return (List<ProjectProposal>) get(PROPERTY_PROJECTPROPOSALLIST);
    }

    public void setProjectProposalList(List<ProjectProposal> projectProposalList) {
        set(PROPERTY_PROJECTPROPOSALLIST, projectProposalList);
    }

    @SuppressWarnings("unchecked")
    public List<SSACCTJournalLine> getSSACCTJournalLineList() {
      return (List<SSACCTJournalLine>) get(PROPERTY_SSACCTJOURNALLINELIST);
    }

    public void setSSACCTJournalLineList(List<SSACCTJournalLine> sSACCTJournalLineList) {
        set(PROPERTY_SSACCTJOURNALLINELIST, sSACCTJournalLineList);
    }

    @SuppressWarnings("unchecked")
    public List<SSPPPAYMENTS> getSSPPPAYMENTSList() {
      return (List<SSPPPAYMENTS>) get(PROPERTY_SSPPPAYMENTSLIST);
    }

    public void setSSPPPAYMENTSList(List<SSPPPAYMENTS> sSPPPAYMENTSList) {
        set(PROPERTY_SSPPPAYMENTSLIST, sSPPPAYMENTSList);
    }

    @SuppressWarnings("unchecked")
    public List<ReceiptTax> getSSWHReceiptTaxList() {
      return (List<ReceiptTax>) get(PROPERTY_SSWHRECEIPTTAXLIST);
    }

    public void setSSWHReceiptTaxList(List<ReceiptTax> sSWHReceiptTaxList) {
        set(PROPERTY_SSWHRECEIPTTAXLIST, sSWHReceiptTaxList);
    }

    @SuppressWarnings("unchecked")
    public List<SSWSConfig> getSSWSConfigList() {
      return (List<SSWSConfig>) get(PROPERTY_SSWSCONFIGLIST);
    }

    public void setSSWSConfigList(List<SSWSConfig> sSWSConfigList) {
        set(PROPERTY_SSWSCONFIGLIST, sSWSConfigList);
    }

    @SuppressWarnings("unchecked")
    public List<SWSICConfig> getSWSICConfigList() {
      return (List<SWSICConfig>) get(PROPERTY_SWSICCONFIGLIST);
    }

    public void setSWSICConfigList(List<SWSICConfig> sWSICConfigList) {
        set(PROPERTY_SWSICCONFIGLIST, sWSICConfigList);
    }

    @SuppressWarnings("unchecked")
    public List<EeiPaymentDetailV> getEeiPaymentDetailVList() {
      return (List<EeiPaymentDetailV>) get(PROPERTY_EEIPAYMENTDETAILVLIST);
    }

    public void setEeiPaymentDetailVList(List<EeiPaymentDetailV> eeiPaymentDetailVList) {
        set(PROPERTY_EEIPAYMENTDETAILVLIST, eeiPaymentDetailVList);
    }

    @SuppressWarnings("unchecked")
    public List<SqbConfigQuickBilling> getSqbConfigQuickbillingList() {
      return (List<SqbConfigQuickBilling>) get(PROPERTY_SQBCONFIGQUICKBILLINGLIST);
    }

    public void setSqbConfigQuickbillingList(List<SqbConfigQuickBilling> sqbConfigQuickbillingList) {
        set(PROPERTY_SQBCONFIGQUICKBILLINGLIST, sqbConfigQuickbillingList);
    }

    @SuppressWarnings("unchecked")
    public List<SqbQuickBilling> getSqbQuickbillingList() {
      return (List<SqbQuickBilling>) get(PROPERTY_SQBQUICKBILLINGLIST);
    }

    public void setSqbQuickbillingList(List<SqbQuickBilling> sqbQuickbillingList) {
        set(PROPERTY_SQBQUICKBILLINGLIST, sqbQuickbillingList);
    }

    @SuppressWarnings("unchecked")
    public List<ssfiFin_payment_detail_v> getSsfiFinPaymentDetailVList() {
      return (List<ssfiFin_payment_detail_v>) get(PROPERTY_SSFIFINPAYMENTDETAILVLIST);
    }

    public void setSsfiFinPaymentDetailVList(List<ssfiFin_payment_detail_v> ssfiFinPaymentDetailVList) {
        set(PROPERTY_SSFIFINPAYMENTDETAILVLIST, ssfiFinPaymentDetailVList);
    }

    @SuppressWarnings("unchecked")
    public List<ssprpayrollpayment> getSsprPayrollpaymentList() {
      return (List<ssprpayrollpayment>) get(PROPERTY_SSPRPAYROLLPAYMENTLIST);
    }

    public void setSsprPayrollpaymentList(List<ssprpayrollpayment> ssprPayrollpaymentList) {
        set(PROPERTY_SSPRPAYROLLPAYMENTLIST, ssprPayrollpaymentList);
    }

    @SuppressWarnings("unchecked")
    public List<SswhWithhCardCredit> getSswhWithhCardCreditList() {
      return (List<SswhWithhCardCredit>) get(PROPERTY_SSWHWITHHCARDCREDITLIST);
    }

    public void setSswhWithhCardCreditList(List<SswhWithhCardCredit> sswhWithhCardCreditList) {
        set(PROPERTY_SSWHWITHHCARDCREDITLIST, sswhWithhCardCreditList);
    }

}
