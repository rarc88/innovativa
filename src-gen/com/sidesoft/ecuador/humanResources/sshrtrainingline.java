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
 * Entity class for entity sshr_trainingline (stored in table sshr_trainingline).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class sshrtrainingline extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sshr_trainingline";
    public static final String ENTITY_NAME = "sshr_trainingline";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_EMPLOYEE = "employee";
    public static final String PROPERTY_ASSISTANCE = "assistance";
    public static final String PROPERTY_TRAININGSTATUS = "trainingStatus";
    public static final String PROPERTY_STARTINGDATE = "startingDate";
    public static final String PROPERTY_ENDDATE = "enddate";
    public static final String PROPERTY_INTERNALEXTERNAL = "internalExternal";
    public static final String PROPERTY_TRAININGINSTITUTE = "trainingInstitute";
    public static final String PROPERTY_QUALIFICATION = "qualification";
    public static final String PROPERTY_NOHOURS = "nohours";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_SSHRTRAININGCALENDAR = "sshrTrainingCalendar";

    public sshrtrainingline() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_ASSISTANCE, false);
        setDefaultValue(PROPERTY_INTERNALEXTERNAL, false);
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

    public Boolean isAssistance() {
        return (Boolean) get(PROPERTY_ASSISTANCE);
    }

    public void setAssistance(Boolean assistance) {
        set(PROPERTY_ASSISTANCE, assistance);
    }

    public String getTrainingStatus() {
        return (String) get(PROPERTY_TRAININGSTATUS);
    }

    public void setTrainingStatus(String trainingStatus) {
        set(PROPERTY_TRAININGSTATUS, trainingStatus);
    }

    public Date getStartingDate() {
        return (Date) get(PROPERTY_STARTINGDATE);
    }

    public void setStartingDate(Date startingDate) {
        set(PROPERTY_STARTINGDATE, startingDate);
    }

    public Date getEnddate() {
        return (Date) get(PROPERTY_ENDDATE);
    }

    public void setEnddate(Date enddate) {
        set(PROPERTY_ENDDATE, enddate);
    }

    public Boolean isInternalExternal() {
        return (Boolean) get(PROPERTY_INTERNALEXTERNAL);
    }

    public void setInternalExternal(Boolean internalExternal) {
        set(PROPERTY_INTERNALEXTERNAL, internalExternal);
    }

    public String getTrainingInstitute() {
        return (String) get(PROPERTY_TRAININGINSTITUTE);
    }

    public void setTrainingInstitute(String trainingInstitute) {
        set(PROPERTY_TRAININGINSTITUTE, trainingInstitute);
    }

    public Long getQualification() {
        return (Long) get(PROPERTY_QUALIFICATION);
    }

    public void setQualification(Long qualification) {
        set(PROPERTY_QUALIFICATION, qualification);
    }

    public Long getNohours() {
        return (Long) get(PROPERTY_NOHOURS);
    }

    public void setNohours(Long nohours) {
        set(PROPERTY_NOHOURS, nohours);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public SshrTrainingCalendar getSshrTrainingCalendar() {
        return (SshrTrainingCalendar) get(PROPERTY_SSHRTRAININGCALENDAR);
    }

    public void setSshrTrainingCalendar(SshrTrainingCalendar sshrTrainingCalendar) {
        set(PROPERTY_SSHRTRAININGCALENDAR, sshrTrainingCalendar);
    }

}
