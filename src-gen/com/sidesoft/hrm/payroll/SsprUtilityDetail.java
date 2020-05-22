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
import org.openbravo.model.financialmgmt.calendar.Year;
/**
 * Entity class for entity sspr_utility_detail (stored in table sspr_utility_detail).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SsprUtilityDetail extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sspr_utility_detail";
    public static final String ENTITY_NAME = "sspr_utility_detail";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_YEAR = "year";
    public static final String PROPERTY_EMPLOYEE = "employee";
    public static final String PROPERTY_STARTINGDATE = "startingDate";
    public static final String PROPERTY_ENDINGDATE = "endingDate";
    public static final String PROPERTY_DAYSWORKED = "daysWorked";
    public static final String PROPERTY_DAYSLOADS = "daysLoads";
    public static final String PROPERTY_UTILITYEMPLOYEE = "utilityEmployee";
    public static final String PROPERTY_UTILITYLOADS = "utilityLoads";
    public static final String PROPERTY_NOLOADS = "noloads";

    public SsprUtilityDetail() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_DAYSWORKED, (long) 0);
        setDefaultValue(PROPERTY_DAYSLOADS, (long) 0);
        setDefaultValue(PROPERTY_UTILITYEMPLOYEE, (long) 0);
        setDefaultValue(PROPERTY_UTILITYLOADS, (long) 0);
        setDefaultValue(PROPERTY_NOLOADS, (long) 0);
    }

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
    }

    public Organization getOrganization() {
        return (Organization) get(PROPERTY_ORGANIZATION);
    }

    public void setOrganization(Organization organization) {
        set(PROPERTY_ORGANIZATION, organization);
    }

    public Client getClient() {
        return (Client) get(PROPERTY_CLIENT);
    }

    public void setClient(Client client) {
        set(PROPERTY_CLIENT, client);
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

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
    }

    public Year getYear() {
        return (Year) get(PROPERTY_YEAR);
    }

    public void setYear(Year year) {
        set(PROPERTY_YEAR, year);
    }

    public BusinessPartner getEmployee() {
        return (BusinessPartner) get(PROPERTY_EMPLOYEE);
    }

    public void setEmployee(BusinessPartner employee) {
        set(PROPERTY_EMPLOYEE, employee);
    }

    public Date getStartingDate() {
        return (Date) get(PROPERTY_STARTINGDATE);
    }

    public void setStartingDate(Date startingDate) {
        set(PROPERTY_STARTINGDATE, startingDate);
    }

    public Date getEndingDate() {
        return (Date) get(PROPERTY_ENDINGDATE);
    }

    public void setEndingDate(Date endingDate) {
        set(PROPERTY_ENDINGDATE, endingDate);
    }

    public Long getDaysWorked() {
        return (Long) get(PROPERTY_DAYSWORKED);
    }

    public void setDaysWorked(Long daysWorked) {
        set(PROPERTY_DAYSWORKED, daysWorked);
    }

    public Long getDaysLoads() {
        return (Long) get(PROPERTY_DAYSLOADS);
    }

    public void setDaysLoads(Long daysLoads) {
        set(PROPERTY_DAYSLOADS, daysLoads);
    }

    public Long getUtilityEmployee() {
        return (Long) get(PROPERTY_UTILITYEMPLOYEE);
    }

    public void setUtilityEmployee(Long utilityEmployee) {
        set(PROPERTY_UTILITYEMPLOYEE, utilityEmployee);
    }

    public Long getUtilityLoads() {
        return (Long) get(PROPERTY_UTILITYLOADS);
    }

    public void setUtilityLoads(Long utilityLoads) {
        set(PROPERTY_UTILITYLOADS, utilityLoads);
    }

    public Long getNoloads() {
        return (Long) get(PROPERTY_NOLOADS);
    }

    public void setNoloads(Long noloads) {
        set(PROPERTY_NOLOADS, noloads);
    }

}
