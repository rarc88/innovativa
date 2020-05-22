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
/**
 * Entity class for entity sspr_leave_group (stored in table sspr_leave_group).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class sspr_leave_group extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sspr_leave_group";
    public static final String ENTITY_NAME = "sspr_leave_group";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_EMPLOYEE = "employee";
    public static final String PROPERTY_CURRENTSALARY = "currentsalary";
    public static final String PROPERTY_STARDATE = "stardate";
    public static final String PROPERTY_ENDINGDATE = "endingDate";
    public static final String PROPERTY_PERCENTAGECOVEREDBYCOMPANY = "percentageCoveredByCompany";
    public static final String PROPERTY_LEAVEEMPLOYEE = "leaveEmployee";
    public static final String PROPERTY_DAYLEAVE = "dayleave";
    public static final String PROPERTY_AMOUNTLEAVE = "amountleave";
    public static final String PROPERTY_SSPRCONCEPT = "ssprConcept";

    public sspr_leave_group() {
        setDefaultValue(PROPERTY_ACTIVE, true);
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

    public BusinessPartner getEmployee() {
        return (BusinessPartner) get(PROPERTY_EMPLOYEE);
    }

    public void setEmployee(BusinessPartner employee) {
        set(PROPERTY_EMPLOYEE, employee);
    }

    public Long getCurrentsalary() {
        return (Long) get(PROPERTY_CURRENTSALARY);
    }

    public void setCurrentsalary(Long currentsalary) {
        set(PROPERTY_CURRENTSALARY, currentsalary);
    }

    public Date getStardate() {
        return (Date) get(PROPERTY_STARDATE);
    }

    public void setStardate(Date stardate) {
        set(PROPERTY_STARDATE, stardate);
    }

    public Date getEndingDate() {
        return (Date) get(PROPERTY_ENDINGDATE);
    }

    public void setEndingDate(Date endingDate) {
        set(PROPERTY_ENDINGDATE, endingDate);
    }

    public Long getPercentageCoveredByCompany() {
        return (Long) get(PROPERTY_PERCENTAGECOVEREDBYCOMPANY);
    }

    public void setPercentageCoveredByCompany(Long percentageCoveredByCompany) {
        set(PROPERTY_PERCENTAGECOVEREDBYCOMPANY, percentageCoveredByCompany);
    }

    public ssprleaveemp getLeaveEmployee() {
        return (ssprleaveemp) get(PROPERTY_LEAVEEMPLOYEE);
    }

    public void setLeaveEmployee(ssprleaveemp leaveEmployee) {
        set(PROPERTY_LEAVEEMPLOYEE, leaveEmployee);
    }

    public Long getDayleave() {
        return (Long) get(PROPERTY_DAYLEAVE);
    }

    public void setDayleave(Long dayleave) {
        set(PROPERTY_DAYLEAVE, dayleave);
    }

    public Long getAmountleave() {
        return (Long) get(PROPERTY_AMOUNTLEAVE);
    }

    public void setAmountleave(Long amountleave) {
        set(PROPERTY_AMOUNTLEAVE, amountleave);
    }

    public Concept getSsprConcept() {
        return (Concept) get(PROPERTY_SSPRCONCEPT);
    }

    public void setSsprConcept(Concept ssprConcept) {
        set(PROPERTY_SSPRCONCEPT, ssprConcept);
    }

}
