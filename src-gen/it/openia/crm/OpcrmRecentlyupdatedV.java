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
package it.openia.crm;

import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
/**
 * Entity class for entity opcrm_recentlyupdated_v (stored in table opcrm_recentlyupdated_v).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class OpcrmRecentlyupdatedV extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "opcrm_recentlyupdated_v";
    public static final String ENTITY_NAME = "opcrm_recentlyupdated_v";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_USERCONTACT = "userContact";
    public static final String PROPERTY_COMMERCIALNAME = "commercialName";
    public static final String PROPERTY_LEADSTATUS = "leadStatus";
    public static final String PROPERTY_LEADSTAGE = "leadStage";
    public static final String PROPERTY_COMMENTS = "comments";
    public static final String PROPERTY_PHONE = "phone";
    public static final String PROPERTY_EMAIL = "email";
    public static final String PROPERTY_ASSIGNEDTO = "assignedTo";
    public static final String PROPERTY_STATUSUPDATED = "statusupdated";
    public static final String PROPERTY_OPPORTUNITYNAME = "opportunityName";
    public static final String PROPERTY_OPPORTUNITYAMOUNT = "opportunityAmount";
    public static final String PROPERTY_OPPORTUNITYSTATUS = "opportunityStatus";
    public static final String PROPERTY_EXPECTEDCLOSEDATE = "expectedCloseDate";
    public static final String PROPERTY_PROBABILITY = "probability";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_LASTUPDATED = "lastupdated";

    public OpcrmRecentlyupdatedV() {
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

    public User getUserContact() {
        return (User) get(PROPERTY_USERCONTACT);
    }

    public void setUserContact(User userContact) {
        set(PROPERTY_USERCONTACT, userContact);
    }

    public String getCommercialName() {
        return (String) get(PROPERTY_COMMERCIALNAME);
    }

    public void setCommercialName(String commercialName) {
        set(PROPERTY_COMMERCIALNAME, commercialName);
    }

    public String getLeadStatus() {
        return (String) get(PROPERTY_LEADSTATUS);
    }

    public void setLeadStatus(String leadStatus) {
        set(PROPERTY_LEADSTATUS, leadStatus);
    }

    public OpcrmStatStage getLeadStage() {
        return (OpcrmStatStage) get(PROPERTY_LEADSTAGE);
    }

    public void setLeadStage(OpcrmStatStage leadStage) {
        set(PROPERTY_LEADSTAGE, leadStage);
    }

    public String getComments() {
        return (String) get(PROPERTY_COMMENTS);
    }

    public void setComments(String comments) {
        set(PROPERTY_COMMENTS, comments);
    }

    public String getPhone() {
        return (String) get(PROPERTY_PHONE);
    }

    public void setPhone(String phone) {
        set(PROPERTY_PHONE, phone);
    }

    public String getEmail() {
        return (String) get(PROPERTY_EMAIL);
    }

    public void setEmail(String email) {
        set(PROPERTY_EMAIL, email);
    }

    public User getAssignedTo() {
        return (User) get(PROPERTY_ASSIGNEDTO);
    }

    public void setAssignedTo(User assignedTo) {
        set(PROPERTY_ASSIGNEDTO, assignedTo);
    }

    public Date getStatusupdated() {
        return (Date) get(PROPERTY_STATUSUPDATED);
    }

    public void setStatusupdated(Date statusupdated) {
        set(PROPERTY_STATUSUPDATED, statusupdated);
    }

    public String getOpportunityName() {
        return (String) get(PROPERTY_OPPORTUNITYNAME);
    }

    public void setOpportunityName(String opportunityName) {
        set(PROPERTY_OPPORTUNITYNAME, opportunityName);
    }

    public Long getOpportunityAmount() {
        return (Long) get(PROPERTY_OPPORTUNITYAMOUNT);
    }

    public void setOpportunityAmount(Long opportunityAmount) {
        set(PROPERTY_OPPORTUNITYAMOUNT, opportunityAmount);
    }

    public String getOpportunityStatus() {
        return (String) get(PROPERTY_OPPORTUNITYSTATUS);
    }

    public void setOpportunityStatus(String opportunityStatus) {
        set(PROPERTY_OPPORTUNITYSTATUS, opportunityStatus);
    }

    public Date getExpectedCloseDate() {
        return (Date) get(PROPERTY_EXPECTEDCLOSEDATE);
    }

    public void setExpectedCloseDate(Date expectedCloseDate) {
        set(PROPERTY_EXPECTEDCLOSEDATE, expectedCloseDate);
    }

    public Long getProbability() {
        return (Long) get(PROPERTY_PROBABILITY);
    }

    public void setProbability(Long probability) {
        set(PROPERTY_PROBABILITY, probability);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Date getLastupdated() {
        return (Date) get(PROPERTY_LASTUPDATED);
    }

    public void setLastupdated(Date lastupdated) {
        set(PROPERTY_LASTUPDATED, lastupdated);
    }

}
