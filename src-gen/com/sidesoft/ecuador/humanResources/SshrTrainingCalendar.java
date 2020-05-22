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
/**
 * Entity class for entity sshr_training_calendar (stored in table sshr_training_calendar).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SshrTrainingCalendar extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sshr_training_calendar";
    public static final String ENTITY_NAME = "sshr_training_calendar";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_NOHOURS = "noHours";
    public static final String PROPERTY_STARTDATE = "startDate";
    public static final String PROPERTY_ENDDATE = "endDate";
    public static final String PROPERTY_CERTIFIEDBY = "certifiedBy";
    public static final String PROPERTY_PLACE = "place";
    public static final String PROPERTY_COST = "cost";
    public static final String PROPERTY_DETAILCOST = "detailCost";
    public static final String PROPERTY_TRAINING = "training";
    public static final String PROPERTY_NOPERSON = "noPerson";
    public static final String PROPERTY_PROVIDER = "provider";
    public static final String PROPERTY_SPONSOR = "sponsor";
    public static final String PROPERTY_LEVEL = "level";
    public static final String PROPERTY_MATERIALS = "materials";
    public static final String PROPERTY_REASON = "reason";
    public static final String PROPERTY_STARTTIME = "startTime";
    public static final String PROPERTY_TRAININGTYPE = "trainingType";
    public static final String PROPERTY_PRIORITY = "priority";
    public static final String PROPERTY_SSHRTRAININGLINELIST = "sshrTraininglineList";

    public SshrTrainingCalendar() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_LEVEL, "B");
        setDefaultValue(PROPERTY_PRIORITY, "L");
        setDefaultValue(PROPERTY_SSHRTRAININGLINELIST, new ArrayList<Object>());
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

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public String getNoHours() {
        return (String) get(PROPERTY_NOHOURS);
    }

    public void setNoHours(String noHours) {
        set(PROPERTY_NOHOURS, noHours);
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

    public String getCertifiedBy() {
        return (String) get(PROPERTY_CERTIFIEDBY);
    }

    public void setCertifiedBy(String certifiedBy) {
        set(PROPERTY_CERTIFIEDBY, certifiedBy);
    }

    public String getPlace() {
        return (String) get(PROPERTY_PLACE);
    }

    public void setPlace(String place) {
        set(PROPERTY_PLACE, place);
    }

    public BigDecimal getCost() {
        return (BigDecimal) get(PROPERTY_COST);
    }

    public void setCost(BigDecimal cost) {
        set(PROPERTY_COST, cost);
    }

    public String getDetailCost() {
        return (String) get(PROPERTY_DETAILCOST);
    }

    public void setDetailCost(String detailCost) {
        set(PROPERTY_DETAILCOST, detailCost);
    }

    public sshrtraining getTraining() {
        return (sshrtraining) get(PROPERTY_TRAINING);
    }

    public void setTraining(sshrtraining training) {
        set(PROPERTY_TRAINING, training);
    }

    public Long getNoPerson() {
        return (Long) get(PROPERTY_NOPERSON);
    }

    public void setNoPerson(Long noPerson) {
        set(PROPERTY_NOPERSON, noPerson);
    }

    public BusinessPartner getProvider() {
        return (BusinessPartner) get(PROPERTY_PROVIDER);
    }

    public void setProvider(BusinessPartner provider) {
        set(PROPERTY_PROVIDER, provider);
    }

    public String getSponsor() {
        return (String) get(PROPERTY_SPONSOR);
    }

    public void setSponsor(String sponsor) {
        set(PROPERTY_SPONSOR, sponsor);
    }

    public String getLevel() {
        return (String) get(PROPERTY_LEVEL);
    }

    public void setLevel(String level) {
        set(PROPERTY_LEVEL, level);
    }

    public String getMaterials() {
        return (String) get(PROPERTY_MATERIALS);
    }

    public void setMaterials(String materials) {
        set(PROPERTY_MATERIALS, materials);
    }

    public String getReason() {
        return (String) get(PROPERTY_REASON);
    }

    public void setReason(String reason) {
        set(PROPERTY_REASON, reason);
    }

    public String getStartTime() {
        return (String) get(PROPERTY_STARTTIME);
    }

    public void setStartTime(String startTime) {
        set(PROPERTY_STARTTIME, startTime);
    }

    public SshrTrainingType getTrainingType() {
        return (SshrTrainingType) get(PROPERTY_TRAININGTYPE);
    }

    public void setTrainingType(SshrTrainingType trainingType) {
        set(PROPERTY_TRAININGTYPE, trainingType);
    }

    public String getPriority() {
        return (String) get(PROPERTY_PRIORITY);
    }

    public void setPriority(String priority) {
        set(PROPERTY_PRIORITY, priority);
    }

    @SuppressWarnings("unchecked")
    public List<sshrtrainingline> getSshrTraininglineList() {
      return (List<sshrtrainingline>) get(PROPERTY_SSHRTRAININGLINELIST);
    }

    public void setSshrTraininglineList(List<sshrtrainingline> sshrTraininglineList) {
        set(PROPERTY_SSHRTRAININGLINELIST, sshrTraininglineList);
    }

}
