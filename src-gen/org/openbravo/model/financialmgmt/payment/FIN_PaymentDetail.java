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

import com.sidesoft.flopec.budget.data.SFBBudgetCertLine;
import com.sidesoft.flopec.budget.data.sfbbudgetpaymentdetv;

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
import org.openbravo.model.common.invoice.InvoiceTaxCashVAT;
import org.openbravo.model.common.invoice.InvoiceTaxCashVAT_V;
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.accounting.UserDimension1;
import org.openbravo.model.financialmgmt.accounting.UserDimension2;
import org.openbravo.model.financialmgmt.gl.GLItem;
/**
 * Entity class for entity FIN_Payment_Detail (stored in table FIN_Payment_Detail).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class FIN_PaymentDetail extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "FIN_Payment_Detail";
    public static final String ENTITY_NAME = "FIN_Payment_Detail";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_FINPAYMENT = "finPayment";
    public static final String PROPERTY_AMOUNT = "amount";
    public static final String PROPERTY_REFUND = "refund";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_WRITEOFFAMOUNT = "writeoffAmount";
    public static final String PROPERTY_GLITEM = "gLItem";
    public static final String PROPERTY_ISPREPAYMENT = "isprepayment";
    public static final String PROPERTY_SFBHASHCODE = "sFBHashCode";
    public static final String PROPERTY_SFBCERTIFICATELINE = "sFBCertificateLine";
    public static final String PROPERTY_SFBCCOSTCENTER = "sfbCCostcenter";
    public static final String PROPERTY_SFBUSER1 = "sfbUser1";
    public static final String PROPERTY_SFBUSER2 = "sfbUser2";
    public static final String PROPERTY_INVOICETAXCASHVATVLIST = "invoiceTaxCashVATVList";
    public static final String PROPERTY_FINPAYMENTSCHEDULEDETAILLIST = "fINPaymentScheduleDetailList";
    public static final String PROPERTY_INVOICETAXCASHVATLIST = "invoiceTaxCashVATList";
    public static final String PROPERTY_SFBBUDGETPAYMENTDETVLIST = "sfbBudgetPaymentDetVList";

    public FIN_PaymentDetail() {
        setDefaultValue(PROPERTY_CREATIONDATE, new Date());
        setDefaultValue(PROPERTY_UPDATED, new Date());
        setDefaultValue(PROPERTY_AMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_REFUND, true);
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_WRITEOFFAMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_ISPREPAYMENT, false);
        setDefaultValue(PROPERTY_INVOICETAXCASHVATVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTSCHEDULEDETAILLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICETAXCASHVATLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETPAYMENTDETVLIST, new ArrayList<Object>());
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

    public FIN_Payment getFinPayment() {
        return (FIN_Payment) get(PROPERTY_FINPAYMENT);
    }

    public void setFinPayment(FIN_Payment finPayment) {
        set(PROPERTY_FINPAYMENT, finPayment);
    }

    public BigDecimal getAmount() {
        return (BigDecimal) get(PROPERTY_AMOUNT);
    }

    public void setAmount(BigDecimal amount) {
        set(PROPERTY_AMOUNT, amount);
    }

    public Boolean isRefund() {
        return (Boolean) get(PROPERTY_REFUND);
    }

    public void setRefund(Boolean refund) {
        set(PROPERTY_REFUND, refund);
    }

    public Boolean isActive() {
        return (Boolean) get(PROPERTY_ACTIVE);
    }

    public void setActive(Boolean active) {
        set(PROPERTY_ACTIVE, active);
    }

    public BigDecimal getWriteoffAmount() {
        return (BigDecimal) get(PROPERTY_WRITEOFFAMOUNT);
    }

    public void setWriteoffAmount(BigDecimal writeoffAmount) {
        set(PROPERTY_WRITEOFFAMOUNT, writeoffAmount);
    }

    public GLItem getGLItem() {
        return (GLItem) get(PROPERTY_GLITEM);
    }

    public void setGLItem(GLItem gLItem) {
        set(PROPERTY_GLITEM, gLItem);
    }

    public Boolean isPrepayment() {
        return (Boolean) get(PROPERTY_ISPREPAYMENT);
    }

    public void setPrepayment(Boolean isprepayment) {
        set(PROPERTY_ISPREPAYMENT, isprepayment);
    }

    public String getSFBHashCode() {
        return (String) get(PROPERTY_SFBHASHCODE);
    }

    public void setSFBHashCode(String sFBHashCode) {
        set(PROPERTY_SFBHASHCODE, sFBHashCode);
    }

    public SFBBudgetCertLine getSFBCertificateLine() {
        return (SFBBudgetCertLine) get(PROPERTY_SFBCERTIFICATELINE);
    }

    public void setSFBCertificateLine(SFBBudgetCertLine sFBCertificateLine) {
        set(PROPERTY_SFBCERTIFICATELINE, sFBCertificateLine);
    }

    public Costcenter getSfbCCostcenter() {
        return (Costcenter) get(PROPERTY_SFBCCOSTCENTER);
    }

    public void setSfbCCostcenter(Costcenter sfbCCostcenter) {
        set(PROPERTY_SFBCCOSTCENTER, sfbCCostcenter);
    }

    public UserDimension1 getSfbUser1() {
        return (UserDimension1) get(PROPERTY_SFBUSER1);
    }

    public void setSfbUser1(UserDimension1 sfbUser1) {
        set(PROPERTY_SFBUSER1, sfbUser1);
    }

    public UserDimension2 getSfbUser2() {
        return (UserDimension2) get(PROPERTY_SFBUSER2);
    }

    public void setSfbUser2(UserDimension2 sfbUser2) {
        set(PROPERTY_SFBUSER2, sfbUser2);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceTaxCashVAT_V> getInvoiceTaxCashVATVList() {
      return (List<InvoiceTaxCashVAT_V>) get(PROPERTY_INVOICETAXCASHVATVLIST);
    }

    public void setInvoiceTaxCashVATVList(List<InvoiceTaxCashVAT_V> invoiceTaxCashVATVList) {
        set(PROPERTY_INVOICETAXCASHVATVLIST, invoiceTaxCashVATVList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_PaymentScheduleDetail> getFINPaymentScheduleDetailList() {
      return (List<FIN_PaymentScheduleDetail>) get(PROPERTY_FINPAYMENTSCHEDULEDETAILLIST);
    }

    public void setFINPaymentScheduleDetailList(List<FIN_PaymentScheduleDetail> fINPaymentScheduleDetailList) {
        set(PROPERTY_FINPAYMENTSCHEDULEDETAILLIST, fINPaymentScheduleDetailList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceTaxCashVAT> getInvoiceTaxCashVATList() {
      return (List<InvoiceTaxCashVAT>) get(PROPERTY_INVOICETAXCASHVATLIST);
    }

    public void setInvoiceTaxCashVATList(List<InvoiceTaxCashVAT> invoiceTaxCashVATList) {
        set(PROPERTY_INVOICETAXCASHVATLIST, invoiceTaxCashVATList);
    }

    @SuppressWarnings("unchecked")
    public List<sfbbudgetpaymentdetv> getSfbBudgetPaymentDetVList() {
      return (List<sfbbudgetpaymentdetv>) get(PROPERTY_SFBBUDGETPAYMENTDETVLIST);
    }

    public void setSfbBudgetPaymentDetVList(List<sfbbudgetpaymentdetv> sfbBudgetPaymentDetVList) {
        set(PROPERTY_SFBBUDGETPAYMENTDETVLIST, sfbBudgetPaymentDetVList);
    }

}
