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
/**
 * Entity class for entity sfb_budget_version (stored in table sfb_budget_version).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SFBBudgetVersion extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sfb_budget_version";
    public static final String ENTITY_NAME = "sfb_budget_version";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DATEFROM = "dateFrom";
    public static final String PROPERTY_SFBBUDGET = "sFBBudget";
    public static final String PROPERTY_CREATEVERSION = "createVersion";
    public static final String PROPERTY_TOTALBUDGETEDAMOUNT = "totalBudgetedAmount";
    public static final String PROPERTY_TOTALCOMMITTEDAMOUNT = "totalCommittedAmount";
    public static final String PROPERTY_TOTALAVAILABLEBALANCE = "totalAvailableBalance";
    public static final String PROPERTY_TOTALACTUALAMOUNT = "totalActualAmount";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_BASEVERSION = "baseVersion";
    public static final String PROPERTY_VERSIONSTATUS = "versionStatus";
    public static final String PROPERTY_APPROVEVERSION = "approveVersion";
    public static final String PROPERTY_TOTALEXECUTEDAMOUNT = "totalExecutedAmount";
    public static final String PROPERTY_TOTALADJUSTEDAMOUNT = "totalAdjustedAmount";
    public static final String PROPERTY_SFBBUDGETLINELIST = "sfbBudgetLineList";
    public static final String PROPERTY_SFBBUDGETVERSIONBASEVERSIONIDLIST = "sfbBudgetVersionBaseVersionIDList";

    public SFBBudgetVersion() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_CREATEVERSION, false);
        setDefaultValue(PROPERTY_TOTALBUDGETEDAMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_TOTALCOMMITTEDAMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_TOTALAVAILABLEBALANCE, new BigDecimal(0));
        setDefaultValue(PROPERTY_TOTALACTUALAMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_PROCESSED, false);
        setDefaultValue(PROPERTY_VERSIONSTATUS, "DR");
        setDefaultValue(PROPERTY_APPROVEVERSION, false);
        setDefaultValue(PROPERTY_TOTALEXECUTEDAMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_TOTALADJUSTEDAMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_SFBBUDGETLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETVERSIONBASEVERSIONIDLIST, new ArrayList<Object>());
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

    public Date getDateFrom() {
        return (Date) get(PROPERTY_DATEFROM);
    }

    public void setDateFrom(Date dateFrom) {
        set(PROPERTY_DATEFROM, dateFrom);
    }

    public SFBBudget getSFBBudget() {
        return (SFBBudget) get(PROPERTY_SFBBUDGET);
    }

    public void setSFBBudget(SFBBudget sFBBudget) {
        set(PROPERTY_SFBBUDGET, sFBBudget);
    }

    public Boolean isCreateVersion() {
        return (Boolean) get(PROPERTY_CREATEVERSION);
    }

    public void setCreateVersion(Boolean createVersion) {
        set(PROPERTY_CREATEVERSION, createVersion);
    }

    public BigDecimal getTotalBudgetedAmount() {
        return (BigDecimal) get(PROPERTY_TOTALBUDGETEDAMOUNT);
    }

    public void setTotalBudgetedAmount(BigDecimal totalBudgetedAmount) {
        set(PROPERTY_TOTALBUDGETEDAMOUNT, totalBudgetedAmount);
    }

    public BigDecimal getTotalCommittedAmount() {
        return (BigDecimal) get(PROPERTY_TOTALCOMMITTEDAMOUNT);
    }

    public void setTotalCommittedAmount(BigDecimal totalCommittedAmount) {
        set(PROPERTY_TOTALCOMMITTEDAMOUNT, totalCommittedAmount);
    }

    public BigDecimal getTotalAvailableBalance() {
        return (BigDecimal) get(PROPERTY_TOTALAVAILABLEBALANCE);
    }

    public void setTotalAvailableBalance(BigDecimal totalAvailableBalance) {
        set(PROPERTY_TOTALAVAILABLEBALANCE, totalAvailableBalance);
    }

    public BigDecimal getTotalActualAmount() {
        return (BigDecimal) get(PROPERTY_TOTALACTUALAMOUNT);
    }

    public void setTotalActualAmount(BigDecimal totalActualAmount) {
        set(PROPERTY_TOTALACTUALAMOUNT, totalActualAmount);
    }

    public Boolean isProcessed() {
        return (Boolean) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(Boolean processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public SFBBudgetVersion getBaseVersion() {
        return (SFBBudgetVersion) get(PROPERTY_BASEVERSION);
    }

    public void setBaseVersion(SFBBudgetVersion baseVersion) {
        set(PROPERTY_BASEVERSION, baseVersion);
    }

    public String getVersionStatus() {
        return (String) get(PROPERTY_VERSIONSTATUS);
    }

    public void setVersionStatus(String versionStatus) {
        set(PROPERTY_VERSIONSTATUS, versionStatus);
    }

    public Boolean isApproveVersion() {
        return (Boolean) get(PROPERTY_APPROVEVERSION);
    }

    public void setApproveVersion(Boolean approveVersion) {
        set(PROPERTY_APPROVEVERSION, approveVersion);
    }

    public BigDecimal getTotalExecutedAmount() {
        return (BigDecimal) get(PROPERTY_TOTALEXECUTEDAMOUNT);
    }

    public void setTotalExecutedAmount(BigDecimal totalExecutedAmount) {
        set(PROPERTY_TOTALEXECUTEDAMOUNT, totalExecutedAmount);
    }

    public BigDecimal getTotalAdjustedAmount() {
        return (BigDecimal) get(PROPERTY_TOTALADJUSTEDAMOUNT);
    }

    public void setTotalAdjustedAmount(BigDecimal totalAdjustedAmount) {
        set(PROPERTY_TOTALADJUSTEDAMOUNT, totalAdjustedAmount);
    }

    @SuppressWarnings("unchecked")
    public List<SFBBudgetLine> getSfbBudgetLineList() {
      return (List<SFBBudgetLine>) get(PROPERTY_SFBBUDGETLINELIST);
    }

    public void setSfbBudgetLineList(List<SFBBudgetLine> sfbBudgetLineList) {
        set(PROPERTY_SFBBUDGETLINELIST, sfbBudgetLineList);
    }

    @SuppressWarnings("unchecked")
    public List<SFBBudgetVersion> getSfbBudgetVersionBaseVersionIDList() {
      return (List<SFBBudgetVersion>) get(PROPERTY_SFBBUDGETVERSIONBASEVERSIONIDLIST);
    }

    public void setSfbBudgetVersionBaseVersionIDList(List<SFBBudgetVersion> sfbBudgetVersionBaseVersionIDList) {
        set(PROPERTY_SFBBUDGETVERSIONBASEVERSIONIDLIST, sfbBudgetVersionBaseVersionIDList);
    }

}
