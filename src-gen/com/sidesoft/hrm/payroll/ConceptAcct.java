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
import com.sidesoft.flopec.budget.data.SFBBudgetItem;

import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.accounting.UserDimension1;
import org.openbravo.model.financialmgmt.accounting.coa.AccountingCombination;
import org.openbravo.model.financialmgmt.accounting.coa.AcctSchema;
/**
 * Entity class for entity sspr_concept_acct (stored in table sspr_concept_acct).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ConceptAcct extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sspr_concept_acct";
    public static final String ENTITY_NAME = "sspr_concept_acct";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_BUSINESSCONCEPT = "businessConcept";
    public static final String PROPERTY_ACCOUNTINGSCHEMA = "accountingSchema";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DEBIT = "debit";
    public static final String PROPERTY_CREDIT = "credit";
    public static final String PROPERTY_ISPASSIVEPROVISION = "ispassiveprovision";
    public static final String PROPERTY_ISEXPEND = "isexpend";
    public static final String PROPERTY_ISLIABILITY = "isliability";
    public static final String PROPERTY_ISNTACCOUNTPAYROLL = "isntaccountpayroll";
    public static final String PROPERTY_ISDEBE = "isdebe";
    public static final String PROPERTY_ISHABER = "isHaber";
    public static final String PROPERTY_CATEGORYACCOUNTING = "categoryAccounting";
    public static final String PROPERTY_SSBPSFBBUDGETITEM = "ssbpSfbBudgetItem";
    public static final String PROPERTY_SSBPSFBBUDGETAREA = "ssbpSfbBudgetArea";
    public static final String PROPERTY_SSBPCCOSTCENTER = "ssbpCCostcenter";
    public static final String PROPERTY_SSBPUSER1 = "ssbpUser1";

    public ConceptAcct() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_ISPASSIVEPROVISION, false);
        setDefaultValue(PROPERTY_ISEXPEND, false);
        setDefaultValue(PROPERTY_ISLIABILITY, false);
        setDefaultValue(PROPERTY_ISNTACCOUNTPAYROLL, true);
        setDefaultValue(PROPERTY_ISDEBE, true);
        setDefaultValue(PROPERTY_ISHABER, true);
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

    public Concept getBusinessConcept() {
        return (Concept) get(PROPERTY_BUSINESSCONCEPT);
    }

    public void setBusinessConcept(Concept businessConcept) {
        set(PROPERTY_BUSINESSCONCEPT, businessConcept);
    }

    public AcctSchema getAccountingSchema() {
        return (AcctSchema) get(PROPERTY_ACCOUNTINGSCHEMA);
    }

    public void setAccountingSchema(AcctSchema accountingSchema) {
        set(PROPERTY_ACCOUNTINGSCHEMA, accountingSchema);
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

    public AccountingCombination getDebit() {
        return (AccountingCombination) get(PROPERTY_DEBIT);
    }

    public void setDebit(AccountingCombination debit) {
        set(PROPERTY_DEBIT, debit);
    }

    public AccountingCombination getCredit() {
        return (AccountingCombination) get(PROPERTY_CREDIT);
    }

    public void setCredit(AccountingCombination credit) {
        set(PROPERTY_CREDIT, credit);
    }

    public Boolean isPassiveprovision() {
        return (Boolean) get(PROPERTY_ISPASSIVEPROVISION);
    }

    public void setPassiveprovision(Boolean ispassiveprovision) {
        set(PROPERTY_ISPASSIVEPROVISION, ispassiveprovision);
    }

    public Boolean isExpend() {
        return (Boolean) get(PROPERTY_ISEXPEND);
    }

    public void setExpend(Boolean isexpend) {
        set(PROPERTY_ISEXPEND, isexpend);
    }

    public Boolean isLiability() {
        return (Boolean) get(PROPERTY_ISLIABILITY);
    }

    public void setLiability(Boolean isliability) {
        set(PROPERTY_ISLIABILITY, isliability);
    }

    public Boolean isNtaccountpayroll() {
        return (Boolean) get(PROPERTY_ISNTACCOUNTPAYROLL);
    }

    public void setNtaccountpayroll(Boolean isntaccountpayroll) {
        set(PROPERTY_ISNTACCOUNTPAYROLL, isntaccountpayroll);
    }

    public Boolean isDebe() {
        return (Boolean) get(PROPERTY_ISDEBE);
    }

    public void setDebe(Boolean isdebe) {
        set(PROPERTY_ISDEBE, isdebe);
    }

    public Boolean isHaber() {
        return (Boolean) get(PROPERTY_ISHABER);
    }

    public void setHaber(Boolean isHaber) {
        set(PROPERTY_ISHABER, isHaber);
    }

    public ssprcategoryacct getCategoryAccounting() {
        return (ssprcategoryacct) get(PROPERTY_CATEGORYACCOUNTING);
    }

    public void setCategoryAccounting(ssprcategoryacct categoryAccounting) {
        set(PROPERTY_CATEGORYACCOUNTING, categoryAccounting);
    }

    public SFBBudgetItem getSsbpSfbBudgetItem() {
        return (SFBBudgetItem) get(PROPERTY_SSBPSFBBUDGETITEM);
    }

    public void setSsbpSfbBudgetItem(SFBBudgetItem ssbpSfbBudgetItem) {
        set(PROPERTY_SSBPSFBBUDGETITEM, ssbpSfbBudgetItem);
    }

    public SFBBudgetArea getSsbpSfbBudgetArea() {
        return (SFBBudgetArea) get(PROPERTY_SSBPSFBBUDGETAREA);
    }

    public void setSsbpSfbBudgetArea(SFBBudgetArea ssbpSfbBudgetArea) {
        set(PROPERTY_SSBPSFBBUDGETAREA, ssbpSfbBudgetArea);
    }

    public Costcenter getSsbpCCostcenter() {
        return (Costcenter) get(PROPERTY_SSBPCCOSTCENTER);
    }

    public void setSsbpCCostcenter(Costcenter ssbpCCostcenter) {
        set(PROPERTY_SSBPCCOSTCENTER, ssbpCCostcenter);
    }

    public UserDimension1 getSsbpUser1() {
        return (UserDimension1) get(PROPERTY_SSBPUSER1);
    }

    public void setSsbpUser1(UserDimension1 ssbpUser1) {
        set(PROPERTY_SSBPUSER1, ssbpUser1);
    }

}
