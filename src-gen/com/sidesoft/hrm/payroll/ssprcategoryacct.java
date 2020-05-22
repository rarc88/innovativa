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

import com.sidesoft.flopec.budget.data.SFBBudgetCertLine;
import com.sidesoft.hrm.payroll.advanced.SfprRveDetail;
import com.sidesoft.hrm.payroll.advanced.SfprSurrogateDetail;
import com.sidesoft.hrm.payroll.disaccounting.sspdpctdistcostcenter;

import ec.com.sidesoft.budget.payroll.SSBPNoBudgetCertLine;
import ec.com.sidesoft.custom.payroll.partialpayment.scppapprovalpaymentline;
import ec.com.sidesoft.localization.ecuador.viatical.SsveViaticalConfigAcct;

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
import org.openbravo.model.financialmgmt.accounting.coa.AccountingCombination;
/**
 * Entity class for entity sspr_category_acct (stored in table sspr_category_acct).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ssprcategoryacct extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sspr_category_acct";
    public static final String ENTITY_NAME = "sspr_category_acct";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_VALUE = "value";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_BALANCEACCT = "balanceacct";
    public static final String PROPERTY_CLEARANCEACCOUNT = "clearanceAccount";
    public static final String PROPERTY_BUSINESSPARTNEREMSSPRCATEGORYACCTIDLIST = "businessPartnerEMSsprCategoryAcctIDList";
    public static final String PROPERTY_SSPRPAYROLLTICKETEMSPRCCATACCTIDLIST = "sSPRPayrollTicketEMSprcCatAcctIDList";
    public static final String PROPERTY_SSVEVIATICALCONFIGACCTLIST = "ssveViaticalConfigAcctList";
    public static final String PROPERTY_SCPPAPPROVALPAYMENTLINELIST = "scppApprovalpaymentlineList";
    public static final String PROPERTY_SFBBUDGETCERTLINEEMSSBPSSPRCATEGORYACCTIDLIST = "sfbBudgetCertLineEMSsbpSsprCategoryAcctIDList";
    public static final String PROPERTY_SFPRRVEDETAILLIST = "sfprRveDetailList";
    public static final String PROPERTY_SFPRSURROGATEDETAILLIST = "sfprSurrogateDetailList";
    public static final String PROPERTY_SSBPNOBUDGETCERTLINELIST = "ssbpNoBudgetCertLineList";
    public static final String PROPERTY_SSPDPCTDISTCOSTCENTEREMSSPRCATEGORYACCTIDLIST = "sspdPctdistCostcenterEMSsprCategoryAcctIDList";
    public static final String PROPERTY_SSPRCONCEPTACCTLIST = "ssprConceptAcctList";

    public ssprcategoryacct() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_BUSINESSPARTNEREMSSPRCATEGORYACCTIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRPAYROLLTICKETEMSPRCCATACCTIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSVEVIATICALCONFIGACCTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCPPAPPROVALPAYMENTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETCERTLINEEMSSBPSSPRCATEGORYACCTIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPRRVEDETAILLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPRSURROGATEDETAILLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSBPNOBUDGETCERTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPDPCTDISTCOSTCENTEREMSSPRCATEGORYACCTIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRCONCEPTACCTLIST, new ArrayList<Object>());
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

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public String getValue() {
        return (String) get(PROPERTY_VALUE);
    }

    public void setValue(String value) {
        set(PROPERTY_VALUE, value);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public AccountingCombination getBalanceacct() {
        return (AccountingCombination) get(PROPERTY_BALANCEACCT);
    }

    public void setBalanceacct(AccountingCombination balanceacct) {
        set(PROPERTY_BALANCEACCT, balanceacct);
    }

    public AccountingCombination getClearanceAccount() {
        return (AccountingCombination) get(PROPERTY_CLEARANCEACCOUNT);
    }

    public void setClearanceAccount(AccountingCombination clearanceAccount) {
        set(PROPERTY_CLEARANCEACCOUNT, clearanceAccount);
    }

    @SuppressWarnings("unchecked")
    public List<BusinessPartner> getBusinessPartnerEMSsprCategoryAcctIDList() {
      return (List<BusinessPartner>) get(PROPERTY_BUSINESSPARTNEREMSSPRCATEGORYACCTIDLIST);
    }

    public void setBusinessPartnerEMSsprCategoryAcctIDList(List<BusinessPartner> businessPartnerEMSsprCategoryAcctIDList) {
        set(PROPERTY_BUSINESSPARTNEREMSSPRCATEGORYACCTIDLIST, businessPartnerEMSsprCategoryAcctIDList);
    }

    @SuppressWarnings("unchecked")
    public List<PayrollTicket> getSSPRPayrollTicketEMSprcCatAcctIDList() {
      return (List<PayrollTicket>) get(PROPERTY_SSPRPAYROLLTICKETEMSPRCCATACCTIDLIST);
    }

    public void setSSPRPayrollTicketEMSprcCatAcctIDList(List<PayrollTicket> sSPRPayrollTicketEMSprcCatAcctIDList) {
        set(PROPERTY_SSPRPAYROLLTICKETEMSPRCCATACCTIDLIST, sSPRPayrollTicketEMSprcCatAcctIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SsveViaticalConfigAcct> getSsveViaticalConfigAcctList() {
      return (List<SsveViaticalConfigAcct>) get(PROPERTY_SSVEVIATICALCONFIGACCTLIST);
    }

    public void setSsveViaticalConfigAcctList(List<SsveViaticalConfigAcct> ssveViaticalConfigAcctList) {
        set(PROPERTY_SSVEVIATICALCONFIGACCTLIST, ssveViaticalConfigAcctList);
    }

    @SuppressWarnings("unchecked")
    public List<scppapprovalpaymentline> getScppApprovalpaymentlineList() {
      return (List<scppapprovalpaymentline>) get(PROPERTY_SCPPAPPROVALPAYMENTLINELIST);
    }

    public void setScppApprovalpaymentlineList(List<scppapprovalpaymentline> scppApprovalpaymentlineList) {
        set(PROPERTY_SCPPAPPROVALPAYMENTLINELIST, scppApprovalpaymentlineList);
    }

    @SuppressWarnings("unchecked")
    public List<SFBBudgetCertLine> getSfbBudgetCertLineEMSsbpSsprCategoryAcctIDList() {
      return (List<SFBBudgetCertLine>) get(PROPERTY_SFBBUDGETCERTLINEEMSSBPSSPRCATEGORYACCTIDLIST);
    }

    public void setSfbBudgetCertLineEMSsbpSsprCategoryAcctIDList(List<SFBBudgetCertLine> sfbBudgetCertLineEMSsbpSsprCategoryAcctIDList) {
        set(PROPERTY_SFBBUDGETCERTLINEEMSSBPSSPRCATEGORYACCTIDLIST, sfbBudgetCertLineEMSsbpSsprCategoryAcctIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprRveDetail> getSfprRveDetailList() {
      return (List<SfprRveDetail>) get(PROPERTY_SFPRRVEDETAILLIST);
    }

    public void setSfprRveDetailList(List<SfprRveDetail> sfprRveDetailList) {
        set(PROPERTY_SFPRRVEDETAILLIST, sfprRveDetailList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprSurrogateDetail> getSfprSurrogateDetailList() {
      return (List<SfprSurrogateDetail>) get(PROPERTY_SFPRSURROGATEDETAILLIST);
    }

    public void setSfprSurrogateDetailList(List<SfprSurrogateDetail> sfprSurrogateDetailList) {
        set(PROPERTY_SFPRSURROGATEDETAILLIST, sfprSurrogateDetailList);
    }

    @SuppressWarnings("unchecked")
    public List<SSBPNoBudgetCertLine> getSsbpNoBudgetCertLineList() {
      return (List<SSBPNoBudgetCertLine>) get(PROPERTY_SSBPNOBUDGETCERTLINELIST);
    }

    public void setSsbpNoBudgetCertLineList(List<SSBPNoBudgetCertLine> ssbpNoBudgetCertLineList) {
        set(PROPERTY_SSBPNOBUDGETCERTLINELIST, ssbpNoBudgetCertLineList);
    }

    @SuppressWarnings("unchecked")
    public List<sspdpctdistcostcenter> getSspdPctdistCostcenterEMSsprCategoryAcctIDList() {
      return (List<sspdpctdistcostcenter>) get(PROPERTY_SSPDPCTDISTCOSTCENTEREMSSPRCATEGORYACCTIDLIST);
    }

    public void setSspdPctdistCostcenterEMSsprCategoryAcctIDList(List<sspdpctdistcostcenter> sspdPctdistCostcenterEMSsprCategoryAcctIDList) {
        set(PROPERTY_SSPDPCTDISTCOSTCENTEREMSSPRCATEGORYACCTIDLIST, sspdPctdistCostcenterEMSsprCategoryAcctIDList);
    }

    @SuppressWarnings("unchecked")
    public List<ConceptAcct> getSsprConceptAcctList() {
      return (List<ConceptAcct>) get(PROPERTY_SSPRCONCEPTACCTLIST);
    }

    public void setSsprConceptAcctList(List<ConceptAcct> ssprConceptAcctList) {
        set(PROPERTY_SSPRCONCEPTACCTLIST, ssprConceptAcctList);
    }

}
