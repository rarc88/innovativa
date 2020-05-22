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
package ec.com.sidesoft.contract;

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
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.financialmgmt.payment.FIN_Payment;
/**
 * Entity class for entity ssct_payment (stored in table ssct_payment).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ssctpayment extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ssct_payment";
    public static final String ENTITY_NAME = "ssct_payment";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_CONTRACT = "contract";
    public static final String PROPERTY_PAYMENTFORM = "paymentForm";
    public static final String PROPERTY_PERCENTAGEPAYMENT = "percentagePayment";
    public static final String PROPERTY_DATEPAYMENT = "datePayment";
    public static final String PROPERTY_PAYMENT = "payment";
    public static final String PROPERTY_AMOUNTPAYMENT = "amountPayment";
    public static final String PROPERTY_INVOICEDATE = "invoiceDate";
    public static final String PROPERTY_INVOICE = "invoice";
    public static final String PROPERTY_SUMMEDLINEAMOUNT = "summedLineAmount";
    public static final String PROPERTY_VAT = "vat";
    public static final String PROPERTY_GRANDTOTALAMOUNT = "grandTotalAmount";
    public static final String PROPERTY_AMOUNTACCRUED = "amountAccrued";
    public static final String PROPERTY_AMOUNTPAID = "amountPaid";
    public static final String PROPERTY_BALANCE = "balance";
    public static final String PROPERTY_OBSERVATIONS = "observations";
    public static final String PROPERTY_ADVANCE = "advance";
    public static final String PROPERTY_PROCESS = "process";
    public static final String PROPERTY_PROCESED = "procesed";
    public static final String PROPERTY_REACTIVE = "reactive";
    public static final String PROPERTY_AMOUNTPAIDWITHTAX = "amountPaidWithTax";
    public static final String PROPERTY_LINENO = "lineNo";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_PERCENTAGEADVANCED = "percentageAdvanced";
    public static final String PROPERTY_SSCTPAYMENTADVANCELIST = "ssctPaymentAdvanceList";

    public ssctpayment() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_PERCENTAGEPAYMENT, new BigDecimal(0));
        setDefaultValue(PROPERTY_AMOUNTPAYMENT, new BigDecimal(0));
        setDefaultValue(PROPERTY_SUMMEDLINEAMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_VAT, new BigDecimal(0));
        setDefaultValue(PROPERTY_GRANDTOTALAMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_AMOUNTACCRUED, new BigDecimal(0));
        setDefaultValue(PROPERTY_AMOUNTPAID, new BigDecimal(0));
        setDefaultValue(PROPERTY_BALANCE, new BigDecimal(0));
        setDefaultValue(PROPERTY_PROCESS, false);
        setDefaultValue(PROPERTY_PROCESED, false);
        setDefaultValue(PROPERTY_REACTIVE, false);
        setDefaultValue(PROPERTY_AMOUNTPAIDWITHTAX, new BigDecimal(0));
        setDefaultValue(PROPERTY_PERCENTAGEADVANCED, false);
        setDefaultValue(PROPERTY_SSCTPAYMENTADVANCELIST, new ArrayList<Object>());
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

    public ssctcontract getContract() {
        return (ssctcontract) get(PROPERTY_CONTRACT);
    }

    public void setContract(ssctcontract contract) {
        set(PROPERTY_CONTRACT, contract);
    }

    public String getPaymentForm() {
        return (String) get(PROPERTY_PAYMENTFORM);
    }

    public void setPaymentForm(String paymentForm) {
        set(PROPERTY_PAYMENTFORM, paymentForm);
    }

    public BigDecimal getPercentagePayment() {
        return (BigDecimal) get(PROPERTY_PERCENTAGEPAYMENT);
    }

    public void setPercentagePayment(BigDecimal percentagePayment) {
        set(PROPERTY_PERCENTAGEPAYMENT, percentagePayment);
    }

    public Date getDatePayment() {
        return (Date) get(PROPERTY_DATEPAYMENT);
    }

    public void setDatePayment(Date datePayment) {
        set(PROPERTY_DATEPAYMENT, datePayment);
    }

    public FIN_Payment getPayment() {
        return (FIN_Payment) get(PROPERTY_PAYMENT);
    }

    public void setPayment(FIN_Payment payment) {
        set(PROPERTY_PAYMENT, payment);
    }

    public BigDecimal getAmountPayment() {
        return (BigDecimal) get(PROPERTY_AMOUNTPAYMENT);
    }

    public void setAmountPayment(BigDecimal amountPayment) {
        set(PROPERTY_AMOUNTPAYMENT, amountPayment);
    }

    public Date getInvoiceDate() {
        return (Date) get(PROPERTY_INVOICEDATE);
    }

    public void setInvoiceDate(Date invoiceDate) {
        set(PROPERTY_INVOICEDATE, invoiceDate);
    }

    public Invoice getInvoice() {
        return (Invoice) get(PROPERTY_INVOICE);
    }

    public void setInvoice(Invoice invoice) {
        set(PROPERTY_INVOICE, invoice);
    }

    public BigDecimal getSummedLineAmount() {
        return (BigDecimal) get(PROPERTY_SUMMEDLINEAMOUNT);
    }

    public void setSummedLineAmount(BigDecimal summedLineAmount) {
        set(PROPERTY_SUMMEDLINEAMOUNT, summedLineAmount);
    }

    public BigDecimal getVat() {
        return (BigDecimal) get(PROPERTY_VAT);
    }

    public void setVat(BigDecimal vat) {
        set(PROPERTY_VAT, vat);
    }

    public BigDecimal getGrandTotalAmount() {
        return (BigDecimal) get(PROPERTY_GRANDTOTALAMOUNT);
    }

    public void setGrandTotalAmount(BigDecimal grandTotalAmount) {
        set(PROPERTY_GRANDTOTALAMOUNT, grandTotalAmount);
    }

    public BigDecimal getAmountAccrued() {
        return (BigDecimal) get(PROPERTY_AMOUNTACCRUED);
    }

    public void setAmountAccrued(BigDecimal amountAccrued) {
        set(PROPERTY_AMOUNTACCRUED, amountAccrued);
    }

    public BigDecimal getAmountPaid() {
        return (BigDecimal) get(PROPERTY_AMOUNTPAID);
    }

    public void setAmountPaid(BigDecimal amountPaid) {
        set(PROPERTY_AMOUNTPAID, amountPaid);
    }

    public BigDecimal getBalance() {
        return (BigDecimal) get(PROPERTY_BALANCE);
    }

    public void setBalance(BigDecimal balance) {
        set(PROPERTY_BALANCE, balance);
    }

    public String getObservations() {
        return (String) get(PROPERTY_OBSERVATIONS);
    }

    public void setObservations(String observations) {
        set(PROPERTY_OBSERVATIONS, observations);
    }

    public ssctpayment getAdvance() {
        return (ssctpayment) get(PROPERTY_ADVANCE);
    }

    public void setAdvance(ssctpayment advance) {
        set(PROPERTY_ADVANCE, advance);
    }

    public Boolean isProcess() {
        return (Boolean) get(PROPERTY_PROCESS);
    }

    public void setProcess(Boolean process) {
        set(PROPERTY_PROCESS, process);
    }

    public Boolean isProcesed() {
        return (Boolean) get(PROPERTY_PROCESED);
    }

    public void setProcesed(Boolean procesed) {
        set(PROPERTY_PROCESED, procesed);
    }

    public Boolean isReactive() {
        return (Boolean) get(PROPERTY_REACTIVE);
    }

    public void setReactive(Boolean reactive) {
        set(PROPERTY_REACTIVE, reactive);
    }

    public BigDecimal getAmountPaidWithTax() {
        return (BigDecimal) get(PROPERTY_AMOUNTPAIDWITHTAX);
    }

    public void setAmountPaidWithTax(BigDecimal amountPaidWithTax) {
        set(PROPERTY_AMOUNTPAIDWITHTAX, amountPaidWithTax);
    }

    public Long getLineNo() {
        return (Long) get(PROPERTY_LINENO);
    }

    public void setLineNo(Long lineNo) {
        set(PROPERTY_LINENO, lineNo);
    }

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public Boolean isPercentageAdvanced() {
        return (Boolean) get(PROPERTY_PERCENTAGEADVANCED);
    }

    public void setPercentageAdvanced(Boolean percentageAdvanced) {
        set(PROPERTY_PERCENTAGEADVANCED, percentageAdvanced);
    }

    @SuppressWarnings("unchecked")
    public List<ssctpayment> getSsctPaymentAdvanceList() {
      return (List<ssctpayment>) get(PROPERTY_SSCTPAYMENTADVANCELIST);
    }

    public void setSsctPaymentAdvanceList(List<ssctpayment> ssctPaymentAdvanceList) {
        set(PROPERTY_SSCTPAYMENTADVANCELIST, ssctPaymentAdvanceList);
    }

}
