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
 * Entity class for entity opcrm_funcinterestview_v (stored in table opcrm_funcinterestview_v).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class OpcrmFuncinterestviewV extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "opcrm_funcinterestview_v";
    public static final String ENTITY_NAME = "opcrm_funcinterestview_v";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_OPCRMLEADTOINTERESTS = "opcrmLeadtointerests";
    public static final String PROPERTY_COMMERCIALNAME = "commercialName";
    public static final String PROPERTY_FUNCTIONALITYOFINTEREST = "functionalityOfInterest";
    public static final String PROPERTY_USERCONTACT = "userContact";
    public static final String PROPERTY_EMAIL = "email";
    public static final String PROPERTY_PHONE = "phone";
    public static final String PROPERTY_OPCRMLEADSTATUS = "opcrmLeadstatus";
    public static final String PROPERTY_OPCRMSTATSTAGE = "opcrmStatStage";
    public static final String PROPERTY_LEADCREATED = "leadcreated";
    public static final String PROPERTY_FIRSTNAME = "firstName";
    public static final String PROPERTY_LASTNAME = "lastName";
    public static final String PROPERTY_LEADCOMMERCIALNAME = "leadcommercialname";
    public static final String PROPERTY_COMMENTS = "comments";
    public static final String PROPERTY_MOBILE = "mobile";
    public static final String PROPERTY_ASSIGNEDTO = "assignedTo";

    public OpcrmFuncinterestviewV() {
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

    public OpcrmLeadToInterests getOpcrmLeadtointerests() {
        return (OpcrmLeadToInterests) get(PROPERTY_OPCRMLEADTOINTERESTS);
    }

    public void setOpcrmLeadtointerests(OpcrmLeadToInterests opcrmLeadtointerests) {
        set(PROPERTY_OPCRMLEADTOINTERESTS, opcrmLeadtointerests);
    }

    public String getCommercialName() {
        return (String) get(PROPERTY_COMMERCIALNAME);
    }

    public void setCommercialName(String commercialName) {
        set(PROPERTY_COMMERCIALNAME, commercialName);
    }

    public OpcrmFuncInterest getFunctionalityOfInterest() {
        return (OpcrmFuncInterest) get(PROPERTY_FUNCTIONALITYOFINTEREST);
    }

    public void setFunctionalityOfInterest(OpcrmFuncInterest functionalityOfInterest) {
        set(PROPERTY_FUNCTIONALITYOFINTEREST, functionalityOfInterest);
    }

    public User getUserContact() {
        return (User) get(PROPERTY_USERCONTACT);
    }

    public void setUserContact(User userContact) {
        set(PROPERTY_USERCONTACT, userContact);
    }

    public String getEmail() {
        return (String) get(PROPERTY_EMAIL);
    }

    public void setEmail(String email) {
        set(PROPERTY_EMAIL, email);
    }

    public String getPhone() {
        return (String) get(PROPERTY_PHONE);
    }

    public void setPhone(String phone) {
        set(PROPERTY_PHONE, phone);
    }

    public String getOpcrmLeadstatus() {
        return (String) get(PROPERTY_OPCRMLEADSTATUS);
    }

    public void setOpcrmLeadstatus(String opcrmLeadstatus) {
        set(PROPERTY_OPCRMLEADSTATUS, opcrmLeadstatus);
    }

    public OpcrmStatStage getOpcrmStatStage() {
        return (OpcrmStatStage) get(PROPERTY_OPCRMSTATSTAGE);
    }

    public void setOpcrmStatStage(OpcrmStatStage opcrmStatStage) {
        set(PROPERTY_OPCRMSTATSTAGE, opcrmStatStage);
    }

    public Date getLeadcreated() {
        return (Date) get(PROPERTY_LEADCREATED);
    }

    public void setLeadcreated(Date leadcreated) {
        set(PROPERTY_LEADCREATED, leadcreated);
    }

    public String getFirstName() {
        return (String) get(PROPERTY_FIRSTNAME);
    }

    public void setFirstName(String firstName) {
        set(PROPERTY_FIRSTNAME, firstName);
    }

    public String getLastName() {
        return (String) get(PROPERTY_LASTNAME);
    }

    public void setLastName(String lastName) {
        set(PROPERTY_LASTNAME, lastName);
    }

    public String getLeadcommercialname() {
        return (String) get(PROPERTY_LEADCOMMERCIALNAME);
    }

    public void setLeadcommercialname(String leadcommercialname) {
        set(PROPERTY_LEADCOMMERCIALNAME, leadcommercialname);
    }

    public String getComments() {
        return (String) get(PROPERTY_COMMENTS);
    }

    public void setComments(String comments) {
        set(PROPERTY_COMMENTS, comments);
    }

    public String getMobile() {
        return (String) get(PROPERTY_MOBILE);
    }

    public void setMobile(String mobile) {
        set(PROPERTY_MOBILE, mobile);
    }

    public User getAssignedTo() {
        return (User) get(PROPERTY_ASSIGNEDTO);
    }

    public void setAssignedTo(User assignedTo) {
        set(PROPERTY_ASSIGNEDTO, assignedTo);
    }

}
