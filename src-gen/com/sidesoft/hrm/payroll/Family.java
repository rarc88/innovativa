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

import com.sidesoft.ecuador.humanResources.sshrdisability;
import com.sidesoft.ecuador.humanResources.sshrlevelstudies;

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
 * Entity class for entity SSPR_Family (stored in table SSPR_Family).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Family extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "SSPR_Family";
    public static final String ENTITY_NAME = "SSPR_Family";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_BIRTHOFDAY = "birthOfDay";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_LOCATIONADDRESS = "locationAddress";
    public static final String PROPERTY_LEAVEDATE = "leavedate";
    public static final String PROPERTY_ACCREDITATIONDOC = "accreditationdoc";
    public static final String PROPERTY_FIRSTNAME = "firstName";
    public static final String PROPERTY_LASTNAME = "lastName";
    public static final String PROPERTY_ISADDRESS = "isaddress";
    public static final String PROPERTY_PATERNITYACCREDITATION = "paternityaccreditation";
    public static final String PROPERTY_FAMILYTIES = "familyties";
    public static final String PROPERTY_REASONFORLEAVING = "reasonforleaving";
    public static final String PROPERTY_DOCUMENTTYPE = "documenttype";
    public static final String PROPERTY_DOCUMENTNO = "documentno";
    public static final String PROPERTY_JOINDATE = "joindate";
    public static final String PROPERTY_DISABILITY = "disability";
    public static final String PROPERTY_SSHRLEVELSTUDIES = "sshrLevelStudies";
    public static final String PROPERTY_SSHRLEVEL = "sSHRLevel";
    public static final String PROPERTY_ISDISABLED = "isdisabled";
    public static final String PROPERTY_SSHRNOCARD = "sshrNocard";
    public static final String PROPERTY_SSHRDISABILITY = "sshrDisability";
    public static final String PROPERTY_SSHRDISABILITYCHK = "sshrDisabilityChk";
    public static final String PROPERTY_JUDICIALRETENTION = "judicialRetention";

    public Family() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_ISADDRESS, true);
        setDefaultValue(PROPERTY_ISDISABLED, false);
        setDefaultValue(PROPERTY_SSHRDISABILITYCHK, false);
        setDefaultValue(PROPERTY_JUDICIALRETENTION, false);
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

    public Date getBirthOfDay() {
        return (Date) get(PROPERTY_BIRTHOFDAY);
    }

    public void setBirthOfDay(Date birthOfDay) {
        set(PROPERTY_BIRTHOFDAY, birthOfDay);
    }

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public Location getLocationAddress() {
        return (Location) get(PROPERTY_LOCATIONADDRESS);
    }

    public void setLocationAddress(Location locationAddress) {
        set(PROPERTY_LOCATIONADDRESS, locationAddress);
    }

    public Date getLeavedate() {
        return (Date) get(PROPERTY_LEAVEDATE);
    }

    public void setLeavedate(Date leavedate) {
        set(PROPERTY_LEAVEDATE, leavedate);
    }

    public String getAccreditationdoc() {
        return (String) get(PROPERTY_ACCREDITATIONDOC);
    }

    public void setAccreditationdoc(String accreditationdoc) {
        set(PROPERTY_ACCREDITATIONDOC, accreditationdoc);
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

    public Boolean isAddress() {
        return (Boolean) get(PROPERTY_ISADDRESS);
    }

    public void setAddress(Boolean isaddress) {
        set(PROPERTY_ISADDRESS, isaddress);
    }

    public String getPaternityaccreditation() {
        return (String) get(PROPERTY_PATERNITYACCREDITATION);
    }

    public void setPaternityaccreditation(String paternityaccreditation) {
        set(PROPERTY_PATERNITYACCREDITATION, paternityaccreditation);
    }

    public String getFamilyties() {
        return (String) get(PROPERTY_FAMILYTIES);
    }

    public void setFamilyties(String familyties) {
        set(PROPERTY_FAMILYTIES, familyties);
    }

    public String getReasonforleaving() {
        return (String) get(PROPERTY_REASONFORLEAVING);
    }

    public void setReasonforleaving(String reasonforleaving) {
        set(PROPERTY_REASONFORLEAVING, reasonforleaving);
    }

    public String getDocumenttype() {
        return (String) get(PROPERTY_DOCUMENTTYPE);
    }

    public void setDocumenttype(String documenttype) {
        set(PROPERTY_DOCUMENTTYPE, documenttype);
    }

    public String getDocumentno() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentno(String documentno) {
        set(PROPERTY_DOCUMENTNO, documentno);
    }

    public Date getJoindate() {
        return (Date) get(PROPERTY_JOINDATE);
    }

    public void setJoindate(Date joindate) {
        set(PROPERTY_JOINDATE, joindate);
    }

    public String getDisability() {
        return (String) get(PROPERTY_DISABILITY);
    }

    public void setDisability(String disability) {
        set(PROPERTY_DISABILITY, disability);
    }

    public sshrlevelstudies getSshrLevelStudies() {
        return (sshrlevelstudies) get(PROPERTY_SSHRLEVELSTUDIES);
    }

    public void setSshrLevelStudies(sshrlevelstudies sshrLevelStudies) {
        set(PROPERTY_SSHRLEVELSTUDIES, sshrLevelStudies);
    }

    public String getSSHRLevel() {
        return (String) get(PROPERTY_SSHRLEVEL);
    }

    public void setSSHRLevel(String sSHRLevel) {
        set(PROPERTY_SSHRLEVEL, sSHRLevel);
    }

    public Boolean isDisabled() {
        return (Boolean) get(PROPERTY_ISDISABLED);
    }

    public void setDisabled(Boolean isdisabled) {
        set(PROPERTY_ISDISABLED, isdisabled);
    }

    public String getSshrNocard() {
        return (String) get(PROPERTY_SSHRNOCARD);
    }

    public void setSshrNocard(String sshrNocard) {
        set(PROPERTY_SSHRNOCARD, sshrNocard);
    }

    public sshrdisability getSshrDisability() {
        return (sshrdisability) get(PROPERTY_SSHRDISABILITY);
    }

    public void setSshrDisability(sshrdisability sshrDisability) {
        set(PROPERTY_SSHRDISABILITY, sshrDisability);
    }

    public Boolean isSshrDisabilityChk() {
        return (Boolean) get(PROPERTY_SSHRDISABILITYCHK);
    }

    public void setSshrDisabilityChk(Boolean sshrDisabilityChk) {
        set(PROPERTY_SSHRDISABILITYCHK, sshrDisabilityChk);
    }

    public Boolean isJudicialRetention() {
        return (Boolean) get(PROPERTY_JUDICIALRETENTION);
    }

    public void setJudicialRetention(Boolean judicialRetention) {
        set(PROPERTY_JUDICIALRETENTION, judicialRetention);
    }

}
