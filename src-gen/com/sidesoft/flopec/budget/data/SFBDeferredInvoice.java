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
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.accounting.UserDimension1;
/**
 * Entity class for entity SFB_Deferred_Invoice (stored in table SFB_Deferred_Invoice).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SFBDeferredInvoice extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "SFB_Deferred_Invoice";
    public static final String ENTITY_NAME = "SFB_Deferred_Invoice";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_COSTCENTER = "costCenter";
    public static final String PROPERTY_BUDGETITEM = "budgetItem";
    public static final String PROPERTY_STDIMENSION = "stDimension";
    public static final String PROPERTY_AREA = "area";
    public static final String PROPERTY_APPLIED = "applied";
    public static final String PROPERTY_YEAR = "year";
    public static final String PROPERTY_TYPEOFBUDGET = "typeOfBudget";
    public static final String PROPERTY_JANUARYEXECUTEDVALUE = "januaryExecutedValue";
    public static final String PROPERTY_FEBRUARYEXECUTEDVALUE = "februaryExecutedValue";
    public static final String PROPERTY_MARCHEXECUTEDVALUE = "marchExecutedValue";
    public static final String PROPERTY_APRILEXECUTEDVALUE = "aprilExecutedValue";
    public static final String PROPERTY_MAYEXECUTEDVALUE = "mayExecutedValue";
    public static final String PROPERTY_JUNEEXECUTEDVALUE = "juneExecutedValue";
    public static final String PROPERTY_JULYEXECUTEDVALUE = "julyExecutedValue";
    public static final String PROPERTY_AUGUSTEXECUTEDVALUE = "augustExecutedValue";
    public static final String PROPERTY_SEPTEMBEREXECUTEDVALUE = "septemberExecutedValue";
    public static final String PROPERTY_OCTOBEREXECUTEDVALUE = "octoberExecutedValue";
    public static final String PROPERTY_NOVEMBEREXECUTEDVALUE = "novemberExecutedValue";
    public static final String PROPERTY_DECEMBEREXECUTEDVALUE = "decemberExecutedValue";
    public static final String PROPERTY_INVOICE = "invoice";

    public SFBDeferredInvoice() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_APPLIED, false);
        setDefaultValue(PROPERTY_JANUARYEXECUTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_FEBRUARYEXECUTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_MARCHEXECUTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_APRILEXECUTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_MAYEXECUTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_JUNEEXECUTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_JULYEXECUTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_AUGUSTEXECUTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_SEPTEMBEREXECUTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_OCTOBEREXECUTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_NOVEMBEREXECUTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_DECEMBEREXECUTEDVALUE, new BigDecimal(0));
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

    public Costcenter getCostCenter() {
        return (Costcenter) get(PROPERTY_COSTCENTER);
    }

    public void setCostCenter(Costcenter costCenter) {
        set(PROPERTY_COSTCENTER, costCenter);
    }

    public SFBBudgetItem getBudgetItem() {
        return (SFBBudgetItem) get(PROPERTY_BUDGETITEM);
    }

    public void setBudgetItem(SFBBudgetItem budgetItem) {
        set(PROPERTY_BUDGETITEM, budgetItem);
    }

    public UserDimension1 getStDimension() {
        return (UserDimension1) get(PROPERTY_STDIMENSION);
    }

    public void setStDimension(UserDimension1 stDimension) {
        set(PROPERTY_STDIMENSION, stDimension);
    }

    public SFBBudgetArea getArea() {
        return (SFBBudgetArea) get(PROPERTY_AREA);
    }

    public void setArea(SFBBudgetArea area) {
        set(PROPERTY_AREA, area);
    }

    public Boolean isApplied() {
        return (Boolean) get(PROPERTY_APPLIED);
    }

    public void setApplied(Boolean applied) {
        set(PROPERTY_APPLIED, applied);
    }

    public String getYear() {
        return (String) get(PROPERTY_YEAR);
    }

    public void setYear(String year) {
        set(PROPERTY_YEAR, year);
    }

    public String getTypeOfBudget() {
        return (String) get(PROPERTY_TYPEOFBUDGET);
    }

    public void setTypeOfBudget(String typeOfBudget) {
        set(PROPERTY_TYPEOFBUDGET, typeOfBudget);
    }

    public BigDecimal getJanuaryExecutedValue() {
        return (BigDecimal) get(PROPERTY_JANUARYEXECUTEDVALUE);
    }

    public void setJanuaryExecutedValue(BigDecimal januaryExecutedValue) {
        set(PROPERTY_JANUARYEXECUTEDVALUE, januaryExecutedValue);
    }

    public BigDecimal getFebruaryExecutedValue() {
        return (BigDecimal) get(PROPERTY_FEBRUARYEXECUTEDVALUE);
    }

    public void setFebruaryExecutedValue(BigDecimal februaryExecutedValue) {
        set(PROPERTY_FEBRUARYEXECUTEDVALUE, februaryExecutedValue);
    }

    public BigDecimal getMarchExecutedValue() {
        return (BigDecimal) get(PROPERTY_MARCHEXECUTEDVALUE);
    }

    public void setMarchExecutedValue(BigDecimal marchExecutedValue) {
        set(PROPERTY_MARCHEXECUTEDVALUE, marchExecutedValue);
    }

    public BigDecimal getAprilExecutedValue() {
        return (BigDecimal) get(PROPERTY_APRILEXECUTEDVALUE);
    }

    public void setAprilExecutedValue(BigDecimal aprilExecutedValue) {
        set(PROPERTY_APRILEXECUTEDVALUE, aprilExecutedValue);
    }

    public BigDecimal getMayExecutedValue() {
        return (BigDecimal) get(PROPERTY_MAYEXECUTEDVALUE);
    }

    public void setMayExecutedValue(BigDecimal mayExecutedValue) {
        set(PROPERTY_MAYEXECUTEDVALUE, mayExecutedValue);
    }

    public BigDecimal getJuneExecutedValue() {
        return (BigDecimal) get(PROPERTY_JUNEEXECUTEDVALUE);
    }

    public void setJuneExecutedValue(BigDecimal juneExecutedValue) {
        set(PROPERTY_JUNEEXECUTEDVALUE, juneExecutedValue);
    }

    public BigDecimal getJulyExecutedValue() {
        return (BigDecimal) get(PROPERTY_JULYEXECUTEDVALUE);
    }

    public void setJulyExecutedValue(BigDecimal julyExecutedValue) {
        set(PROPERTY_JULYEXECUTEDVALUE, julyExecutedValue);
    }

    public BigDecimal getAugustExecutedValue() {
        return (BigDecimal) get(PROPERTY_AUGUSTEXECUTEDVALUE);
    }

    public void setAugustExecutedValue(BigDecimal augustExecutedValue) {
        set(PROPERTY_AUGUSTEXECUTEDVALUE, augustExecutedValue);
    }

    public BigDecimal getSeptemberExecutedValue() {
        return (BigDecimal) get(PROPERTY_SEPTEMBEREXECUTEDVALUE);
    }

    public void setSeptemberExecutedValue(BigDecimal septemberExecutedValue) {
        set(PROPERTY_SEPTEMBEREXECUTEDVALUE, septemberExecutedValue);
    }

    public BigDecimal getOctoberExecutedValue() {
        return (BigDecimal) get(PROPERTY_OCTOBEREXECUTEDVALUE);
    }

    public void setOctoberExecutedValue(BigDecimal octoberExecutedValue) {
        set(PROPERTY_OCTOBEREXECUTEDVALUE, octoberExecutedValue);
    }

    public BigDecimal getNovemberExecutedValue() {
        return (BigDecimal) get(PROPERTY_NOVEMBEREXECUTEDVALUE);
    }

    public void setNovemberExecutedValue(BigDecimal novemberExecutedValue) {
        set(PROPERTY_NOVEMBEREXECUTEDVALUE, novemberExecutedValue);
    }

    public BigDecimal getDecemberExecutedValue() {
        return (BigDecimal) get(PROPERTY_DECEMBEREXECUTEDVALUE);
    }

    public void setDecemberExecutedValue(BigDecimal decemberExecutedValue) {
        set(PROPERTY_DECEMBEREXECUTEDVALUE, decemberExecutedValue);
    }

    public Invoice getInvoice() {
        return (Invoice) get(PROPERTY_INVOICE);
    }

    public void setInvoice(Invoice invoice) {
        set(PROPERTY_INVOICE, invoice);
    }

}
