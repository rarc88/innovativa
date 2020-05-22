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
package com.sidesoft.hrm.payroll;

import com.sidesoft.flopec.budget.data.SFBBudgetArea;

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
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.accounting.UserDimension1;
import org.openbravo.model.financialmgmt.accounting.UserDimension2;
/**
 * Entity class for entity SSPR_Payroll_Ticket (stored in table SSPR_Payroll_Ticket).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class PayrollTicket extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "SSPR_Payroll_Ticket";
    public static final String ENTITY_NAME = "SSPR_Payroll_Ticket";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_SSPRPAYROLL = "ssprPayroll";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_TOTALINCOME = "totalincome";
    public static final String PROPERTY_TOTALEXPENSE = "totalexpense";
    public static final String PROPERTY_TOTALNET = "totalnet";
    public static final String PROPERTY_GENERATEPAYMENTOUT = "generatePaymentout";
    public static final String PROPERTY_BASICFRACTION = "basicfraction";
    public static final String PROPERTY_SCPPSTATUSPAYMENT = "scppStatusPayment";
    public static final String PROPERTY_AMOUNTBASICFRACTION = "amountbasicfraction";
    public static final String PROPERTY_EXCESSAMOUNTFRACTION = "excessamountfraction";
    public static final String PROPERTY_TAXABLE = "taxable";
    public static final String PROPERTY_DISABLED = "disabled";
    public static final String PROPERTY_SENIOR = "senior";
    public static final String PROPERTY_SPRCCOSTCENTER = "sprcCostcenter";
    public static final String PROPERTY_SPRCUSER1 = "sprcUser1";
    public static final String PROPERTY_SPRCUSER2 = "sprcUser2";
    public static final String PROPERTY_WORKINGDAYS = "workingdays";
    public static final String PROPERTY_SPRCCATACCT = "sprcCatAcct";
    public static final String PROPERTY_WORKEDDAYS = "workeddays";
    public static final String PROPERTY_SSBPSFBBUDGETAREA = "ssbpSfbBudgetArea";
    public static final String PROPERTY_SSBPBUDGETAREA = "ssbpBudgetArea";
    public static final String PROPERTY_SSPRPAYROLLTICKETCONCEPTLIST = "sSPRPayrollTicketConceptList";

    public PayrollTicket() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_TOTALINCOME, new BigDecimal(0));
        setDefaultValue(PROPERTY_TOTALEXPENSE, new BigDecimal(0));
        setDefaultValue(PROPERTY_TOTALNET, new BigDecimal(0));
        setDefaultValue(PROPERTY_GENERATEPAYMENTOUT, false);
        setDefaultValue(PROPERTY_SCPPSTATUSPAYMENT, "DR");
        setDefaultValue(PROPERTY_DISABLED, new BigDecimal(0));
        setDefaultValue(PROPERTY_SENIOR, new BigDecimal(0));
        setDefaultValue(PROPERTY_WORKINGDAYS, new BigDecimal(0));
        setDefaultValue(PROPERTY_WORKEDDAYS, new BigDecimal(0));
        setDefaultValue(PROPERTY_SSPRPAYROLLTICKETCONCEPTLIST, new ArrayList<Object>());
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

    public Payroll getSsprPayroll() {
        return (Payroll) get(PROPERTY_SSPRPAYROLL);
    }

    public void setSsprPayroll(Payroll ssprPayroll) {
        set(PROPERTY_SSPRPAYROLL, ssprPayroll);
    }

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public BigDecimal getTotalincome() {
        return (BigDecimal) get(PROPERTY_TOTALINCOME);
    }

    public void setTotalincome(BigDecimal totalincome) {
        set(PROPERTY_TOTALINCOME, totalincome);
    }

    public BigDecimal getTotalexpense() {
        return (BigDecimal) get(PROPERTY_TOTALEXPENSE);
    }

    public void setTotalexpense(BigDecimal totalexpense) {
        set(PROPERTY_TOTALEXPENSE, totalexpense);
    }

    public BigDecimal getTotalnet() {
        return (BigDecimal) get(PROPERTY_TOTALNET);
    }

    public void setTotalnet(BigDecimal totalnet) {
        set(PROPERTY_TOTALNET, totalnet);
    }

    public Boolean isGeneratePaymentout() {
        return (Boolean) get(PROPERTY_GENERATEPAYMENTOUT);
    }

    public void setGeneratePaymentout(Boolean generatePaymentout) {
        set(PROPERTY_GENERATEPAYMENTOUT, generatePaymentout);
    }

    public BigDecimal getBasicfraction() {
        return (BigDecimal) get(PROPERTY_BASICFRACTION);
    }

    public void setBasicfraction(BigDecimal basicfraction) {
        set(PROPERTY_BASICFRACTION, basicfraction);
    }

    public String getScppStatusPayment() {
        return (String) get(PROPERTY_SCPPSTATUSPAYMENT);
    }

    public void setScppStatusPayment(String scppStatusPayment) {
        set(PROPERTY_SCPPSTATUSPAYMENT, scppStatusPayment);
    }

    public BigDecimal getAmountbasicfraction() {
        return (BigDecimal) get(PROPERTY_AMOUNTBASICFRACTION);
    }

    public void setAmountbasicfraction(BigDecimal amountbasicfraction) {
        set(PROPERTY_AMOUNTBASICFRACTION, amountbasicfraction);
    }

    public BigDecimal getExcessamountfraction() {
        return (BigDecimal) get(PROPERTY_EXCESSAMOUNTFRACTION);
    }

    public void setExcessamountfraction(BigDecimal excessamountfraction) {
        set(PROPERTY_EXCESSAMOUNTFRACTION, excessamountfraction);
    }

    public BigDecimal getTaxable() {
        return (BigDecimal) get(PROPERTY_TAXABLE);
    }

    public void setTaxable(BigDecimal taxable) {
        set(PROPERTY_TAXABLE, taxable);
    }

    public BigDecimal getDisabled() {
        return (BigDecimal) get(PROPERTY_DISABLED);
    }

    public void setDisabled(BigDecimal disabled) {
        set(PROPERTY_DISABLED, disabled);
    }

    public BigDecimal getSenior() {
        return (BigDecimal) get(PROPERTY_SENIOR);
    }

    public void setSenior(BigDecimal senior) {
        set(PROPERTY_SENIOR, senior);
    }

    public Costcenter getSprcCostcenter() {
        return (Costcenter) get(PROPERTY_SPRCCOSTCENTER);
    }

    public void setSprcCostcenter(Costcenter sprcCostcenter) {
        set(PROPERTY_SPRCCOSTCENTER, sprcCostcenter);
    }

    public UserDimension1 getSprcUser1() {
        return (UserDimension1) get(PROPERTY_SPRCUSER1);
    }

    public void setSprcUser1(UserDimension1 sprcUser1) {
        set(PROPERTY_SPRCUSER1, sprcUser1);
    }

    public UserDimension2 getSprcUser2() {
        return (UserDimension2) get(PROPERTY_SPRCUSER2);
    }

    public void setSprcUser2(UserDimension2 sprcUser2) {
        set(PROPERTY_SPRCUSER2, sprcUser2);
    }

    public BigDecimal getWorkingdays() {
        return (BigDecimal) get(PROPERTY_WORKINGDAYS);
    }

    public void setWorkingdays(BigDecimal workingdays) {
        set(PROPERTY_WORKINGDAYS, workingdays);
    }

    public ssprcategoryacct getSprcCatAcct() {
        return (ssprcategoryacct) get(PROPERTY_SPRCCATACCT);
    }

    public void setSprcCatAcct(ssprcategoryacct sprcCatAcct) {
        set(PROPERTY_SPRCCATACCT, sprcCatAcct);
    }

    public BigDecimal getWorkeddays() {
        return (BigDecimal) get(PROPERTY_WORKEDDAYS);
    }

    public void setWorkeddays(BigDecimal workeddays) {
        set(PROPERTY_WORKEDDAYS, workeddays);
    }

    public SFBBudgetArea getSsbpSfbBudgetArea() {
        return (SFBBudgetArea) get(PROPERTY_SSBPSFBBUDGETAREA);
    }

    public void setSsbpSfbBudgetArea(SFBBudgetArea ssbpSfbBudgetArea) {
        set(PROPERTY_SSBPSFBBUDGETAREA, ssbpSfbBudgetArea);
    }

    public String getSsbpBudgetArea() {
        return (String) get(PROPERTY_SSBPBUDGETAREA);
    }

    public void setSsbpBudgetArea(String ssbpBudgetArea) {
        set(PROPERTY_SSBPBUDGETAREA, ssbpBudgetArea);
    }

    @SuppressWarnings("unchecked")
    public List<PayrollTicketConcept> getSSPRPayrollTicketConceptList() {
      return (List<PayrollTicketConcept>) get(PROPERTY_SSPRPAYROLLTICKETCONCEPTLIST);
    }

    public void setSSPRPayrollTicketConceptList(List<PayrollTicketConcept> sSPRPayrollTicketConceptList) {
        set(PROPERTY_SSPRPAYROLLTICKETCONCEPTLIST, sSPRPayrollTicketConceptList);
    }

}
