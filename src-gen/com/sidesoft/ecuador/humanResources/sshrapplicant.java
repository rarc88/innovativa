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

import com.sidesoft.hrm.payroll.Position;

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
 * Entity class for entity sshr_applicant (stored in table sshr_applicant).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class sshrapplicant extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sshr_applicant";
    public static final String ENTITY_NAME = "sshr_applicant";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DOCUMENTTYPENAME = "documentTypeName";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_GENDER = "gender";
    public static final String PROPERTY_DISABILITY = "disability";
    public static final String PROPERTY_LEVELDISABILITY = "levelDisability";
    public static final String PROPERTY_NOCARD = "nocard";
    public static final String PROPERTY_EMAIL = "email";
    public static final String PROPERTY_HAVEDISABILITY = "haveDisability";
    public static final String PROPERTY_PHONE = "phone";
    public static final String PROPERTY_ALTERNATINGPHONE = "alternatingPhone";
    public static final String PROPERTY_ADDRESS = "address";
    public static final String PROPERTY_LEVELSTUDIES = "levelStudies";
    public static final String PROPERTY_SPECIALIZATION = "specialization";
    public static final String PROPERTY_YEARSEXPERIENCE = "yearsExperience";
    public static final String PROPERTY_DESCRIPTIONEXPERIENCE = "descriptionExperience";
    public static final String PROPERTY_HOURSTRAININGS = "hoursTrainings";
    public static final String PROPERTY_DESCRIPTIONTRAININGS = "descriptionTrainings";
    public static final String PROPERTY_SKILLS = "skills";
    public static final String PROPERTY_SALARYASPIRATION = "salaryAspiration";
    public static final String PROPERTY_DATE = "date";
    public static final String PROPERTY_SSHRRULESCONCOURS = "sshrRulesConcours";
    public static final String PROPERTY_SSHRCOMPETENT = "sshrCompetent";
    public static final String PROPERTY_SSHRPOSITION = "sshrPosition";
    public static final String PROPERTY_SSHRAPPLICANTCONCOURSLIST = "sshrApplicantConcoursList";

    public sshrapplicant() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_HAVEDISABILITY, false);
        setDefaultValue(PROPERTY_SSHRCOMPETENT, false);
        setDefaultValue(PROPERTY_SSHRAPPLICANTCONCOURSLIST, new ArrayList<Object>());
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

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public String getDocumentTypeName() {
        return (String) get(PROPERTY_DOCUMENTTYPENAME);
    }

    public void setDocumentTypeName(String documentTypeName) {
        set(PROPERTY_DOCUMENTTYPENAME, documentTypeName);
    }

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

    public String getGender() {
        return (String) get(PROPERTY_GENDER);
    }

    public void setGender(String gender) {
        set(PROPERTY_GENDER, gender);
    }

    public sshrdisability getDisability() {
        return (sshrdisability) get(PROPERTY_DISABILITY);
    }

    public void setDisability(sshrdisability disability) {
        set(PROPERTY_DISABILITY, disability);
    }

    public String getLevelDisability() {
        return (String) get(PROPERTY_LEVELDISABILITY);
    }

    public void setLevelDisability(String levelDisability) {
        set(PROPERTY_LEVELDISABILITY, levelDisability);
    }

    public String getNocard() {
        return (String) get(PROPERTY_NOCARD);
    }

    public void setNocard(String nocard) {
        set(PROPERTY_NOCARD, nocard);
    }

    public String getEmail() {
        return (String) get(PROPERTY_EMAIL);
    }

    public void setEmail(String email) {
        set(PROPERTY_EMAIL, email);
    }

    public Boolean isHaveDisability() {
        return (Boolean) get(PROPERTY_HAVEDISABILITY);
    }

    public void setHaveDisability(Boolean haveDisability) {
        set(PROPERTY_HAVEDISABILITY, haveDisability);
    }

    public String getPhone() {
        return (String) get(PROPERTY_PHONE);
    }

    public void setPhone(String phone) {
        set(PROPERTY_PHONE, phone);
    }

    public String getAlternatingPhone() {
        return (String) get(PROPERTY_ALTERNATINGPHONE);
    }

    public void setAlternatingPhone(String alternatingPhone) {
        set(PROPERTY_ALTERNATINGPHONE, alternatingPhone);
    }

    public String getAddress() {
        return (String) get(PROPERTY_ADDRESS);
    }

    public void setAddress(String address) {
        set(PROPERTY_ADDRESS, address);
    }

    public sshrlevelstudies getLevelStudies() {
        return (sshrlevelstudies) get(PROPERTY_LEVELSTUDIES);
    }

    public void setLevelStudies(sshrlevelstudies levelStudies) {
        set(PROPERTY_LEVELSTUDIES, levelStudies);
    }

    public sshrspecialization getSpecialization() {
        return (sshrspecialization) get(PROPERTY_SPECIALIZATION);
    }

    public void setSpecialization(sshrspecialization specialization) {
        set(PROPERTY_SPECIALIZATION, specialization);
    }

    public String getYearsExperience() {
        return (String) get(PROPERTY_YEARSEXPERIENCE);
    }

    public void setYearsExperience(String yearsExperience) {
        set(PROPERTY_YEARSEXPERIENCE, yearsExperience);
    }

    public String getDescriptionExperience() {
        return (String) get(PROPERTY_DESCRIPTIONEXPERIENCE);
    }

    public void setDescriptionExperience(String descriptionExperience) {
        set(PROPERTY_DESCRIPTIONEXPERIENCE, descriptionExperience);
    }

    public String getHoursTrainings() {
        return (String) get(PROPERTY_HOURSTRAININGS);
    }

    public void setHoursTrainings(String hoursTrainings) {
        set(PROPERTY_HOURSTRAININGS, hoursTrainings);
    }

    public String getDescriptionTrainings() {
        return (String) get(PROPERTY_DESCRIPTIONTRAININGS);
    }

    public void setDescriptionTrainings(String descriptionTrainings) {
        set(PROPERTY_DESCRIPTIONTRAININGS, descriptionTrainings);
    }

    public sshrskillsss getSkills() {
        return (sshrskillsss) get(PROPERTY_SKILLS);
    }

    public void setSkills(sshrskillsss skills) {
        set(PROPERTY_SKILLS, skills);
    }

    public String getSalaryAspiration() {
        return (String) get(PROPERTY_SALARYASPIRATION);
    }

    public void setSalaryAspiration(String salaryAspiration) {
        set(PROPERTY_SALARYASPIRATION, salaryAspiration);
    }

    public Date getDate() {
        return (Date) get(PROPERTY_DATE);
    }

    public void setDate(Date date) {
        set(PROPERTY_DATE, date);
    }

    public String getSshrRulesConcours() {
        return (String) get(PROPERTY_SSHRRULESCONCOURS);
    }

    public void setSshrRulesConcours(String sshrRulesConcours) {
        set(PROPERTY_SSHRRULESCONCOURS, sshrRulesConcours);
    }

    public Boolean isSshrCompetent() {
        return (Boolean) get(PROPERTY_SSHRCOMPETENT);
    }

    public void setSshrCompetent(Boolean sshrCompetent) {
        set(PROPERTY_SSHRCOMPETENT, sshrCompetent);
    }

    public Position getSshrPosition() {
        return (Position) get(PROPERTY_SSHRPOSITION);
    }

    public void setSshrPosition(Position sshrPosition) {
        set(PROPERTY_SSHRPOSITION, sshrPosition);
    }

    @SuppressWarnings("unchecked")
    public List<sshrapplicantconcours> getSshrApplicantConcoursList() {
      return (List<sshrapplicantconcours>) get(PROPERTY_SSHRAPPLICANTCONCOURSLIST);
    }

    public void setSshrApplicantConcoursList(List<sshrapplicantconcours> sshrApplicantConcoursList) {
        set(PROPERTY_SSHRAPPLICANTCONCOURSLIST, sshrApplicantConcoursList);
    }

}
