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
package com.sidesoft.ecuador.humanResources;

import com.sidesoft.hrm.payroll.Shift;

import java.math.BigDecimal;
import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.geography.Location;
/**
 * Entity class for entity sshr_job (stored in table sshr_job).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class sshrJob extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sshr_job";
    public static final String ENTITY_NAME = "sshr_job";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_POSITIONTITLE = "positionTitle";
    public static final String PROPERTY_DEPARTMENT = "department";
    public static final String PROPERTY_LOCATIONADDRESS = "locationAddress";
    public static final String PROPERTY_STARTDATE = "startDate";
    public static final String PROPERTY_ENDDATE = "endDate";
    public static final String PROPERTY_DETAILS = "details";
    public static final String PROPERTY_SALARY = "salary";
    public static final String PROPERTY_AMOUNTS = "amounts";
    public static final String PROPERTY_BOSS = "boss";
    public static final String PROPERTY_SHIFT = "shift";

    public sshrJob() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_AMOUNTS, new BigDecimal(0));
        setDefaultValue(PROPERTY_BOSS, false);
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

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public sshrPositionTitle getPositionTitle() {
        return (sshrPositionTitle) get(PROPERTY_POSITIONTITLE);
    }

    public void setPositionTitle(sshrPositionTitle positionTitle) {
        set(PROPERTY_POSITIONTITLE, positionTitle);
    }

    public sshrDepartment getDepartment() {
        return (sshrDepartment) get(PROPERTY_DEPARTMENT);
    }

    public void setDepartment(sshrDepartment department) {
        set(PROPERTY_DEPARTMENT, department);
    }

    public Location getLocationAddress() {
        return (Location) get(PROPERTY_LOCATIONADDRESS);
    }

    public void setLocationAddress(Location locationAddress) {
        set(PROPERTY_LOCATIONADDRESS, locationAddress);
    }

    public Date getStartDate() {
        return (Date) get(PROPERTY_STARTDATE);
    }

    public void setStartDate(Date startDate) {
        set(PROPERTY_STARTDATE, startDate);
    }

    public Date getEndDate() {
        return (Date) get(PROPERTY_ENDDATE);
    }

    public void setEndDate(Date endDate) {
        set(PROPERTY_ENDDATE, endDate);
    }

    public String getDetails() {
        return (String) get(PROPERTY_DETAILS);
    }

    public void setDetails(String details) {
        set(PROPERTY_DETAILS, details);
    }

    public sshrSalaryGrade getSalary() {
        return (sshrSalaryGrade) get(PROPERTY_SALARY);
    }

    public void setSalary(sshrSalaryGrade salary) {
        set(PROPERTY_SALARY, salary);
    }

    public BigDecimal getAmounts() {
        return (BigDecimal) get(PROPERTY_AMOUNTS);
    }

    public void setAmounts(BigDecimal amounts) {
        set(PROPERTY_AMOUNTS, amounts);
    }

    public Boolean isBoss() {
        return (Boolean) get(PROPERTY_BOSS);
    }

    public void setBoss(Boolean boss) {
        set(PROPERTY_BOSS, boss);
    }

    public Shift getShift() {
        return (Shift) get(PROPERTY_SHIFT);
    }

    public void setShift(Shift shift) {
        set(PROPERTY_SHIFT, shift);
    }

}
