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
 * Entity class for entity sshr_rules_concours (stored in table sshr_rules_concours).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class sshrrulesconcours extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sshr_rules_concours";
    public static final String ENTITY_NAME = "sshr_rules_concours";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_POSITIONTITLE = "positionTitle";
    public static final String PROPERTY_DEPARTMENT = "department";
    public static final String PROPERTY_SALARY = "salary";
    public static final String PROPERTY_AMOUNTSALARY = "amountSalary";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DATE = "date";
    public static final String PROPERTY_NOVACANCIES = "noVacancies";
    public static final String PROPERTY_SSHRAPPLICANTCONCOURSLIST = "sshrApplicantConcoursList";
    public static final String PROPERTY_SSHRRULESEDUCATIONLIST = "sshrRulesEducationList";
    public static final String PROPERTY_SSHRRULESEXPERIENCELIST = "sshrRulesExperienceList";
    public static final String PROPERTY_SSHRRULESSKILLSLIST = "sshrRulesSkillsList";
    public static final String PROPERTY_SSHRRULESTRAININGSLIST = "sshrRulesTrainingsList";

    public sshrrulesconcours() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_SSHRAPPLICANTCONCOURSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSHRRULESEDUCATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSHRRULESEXPERIENCELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSHRRULESSKILLSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSHRRULESTRAININGSLIST, new ArrayList<Object>());
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

    public sshremployeeposition getPositionTitle() {
        return (sshremployeeposition) get(PROPERTY_POSITIONTITLE);
    }

    public void setPositionTitle(sshremployeeposition positionTitle) {
        set(PROPERTY_POSITIONTITLE, positionTitle);
    }

    public sshrDepartment getDepartment() {
        return (sshrDepartment) get(PROPERTY_DEPARTMENT);
    }

    public void setDepartment(sshrDepartment department) {
        set(PROPERTY_DEPARTMENT, department);
    }

    public sshrSalaryGrade getSalary() {
        return (sshrSalaryGrade) get(PROPERTY_SALARY);
    }

    public void setSalary(sshrSalaryGrade salary) {
        set(PROPERTY_SALARY, salary);
    }

    public String getAmountSalary() {
        return (String) get(PROPERTY_AMOUNTSALARY);
    }

    public void setAmountSalary(String amountSalary) {
        set(PROPERTY_AMOUNTSALARY, amountSalary);
    }

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public Date getDate() {
        return (Date) get(PROPERTY_DATE);
    }

    public void setDate(Date date) {
        set(PROPERTY_DATE, date);
    }

    public Long getNoVacancies() {
        return (Long) get(PROPERTY_NOVACANCIES);
    }

    public void setNoVacancies(Long noVacancies) {
        set(PROPERTY_NOVACANCIES, noVacancies);
    }

    @SuppressWarnings("unchecked")
    public List<sshrapplicantconcours> getSshrApplicantConcoursList() {
      return (List<sshrapplicantconcours>) get(PROPERTY_SSHRAPPLICANTCONCOURSLIST);
    }

    public void setSshrApplicantConcoursList(List<sshrapplicantconcours> sshrApplicantConcoursList) {
        set(PROPERTY_SSHRAPPLICANTCONCOURSLIST, sshrApplicantConcoursList);
    }

    @SuppressWarnings("unchecked")
    public List<sshrruleseducation> getSshrRulesEducationList() {
      return (List<sshrruleseducation>) get(PROPERTY_SSHRRULESEDUCATIONLIST);
    }

    public void setSshrRulesEducationList(List<sshrruleseducation> sshrRulesEducationList) {
        set(PROPERTY_SSHRRULESEDUCATIONLIST, sshrRulesEducationList);
    }

    @SuppressWarnings("unchecked")
    public List<sshrrulesexperience> getSshrRulesExperienceList() {
      return (List<sshrrulesexperience>) get(PROPERTY_SSHRRULESEXPERIENCELIST);
    }

    public void setSshrRulesExperienceList(List<sshrrulesexperience> sshrRulesExperienceList) {
        set(PROPERTY_SSHRRULESEXPERIENCELIST, sshrRulesExperienceList);
    }

    @SuppressWarnings("unchecked")
    public List<sshrrulesskills> getSshrRulesSkillsList() {
      return (List<sshrrulesskills>) get(PROPERTY_SSHRRULESSKILLSLIST);
    }

    public void setSshrRulesSkillsList(List<sshrrulesskills> sshrRulesSkillsList) {
        set(PROPERTY_SSHRRULESSKILLSLIST, sshrRulesSkillsList);
    }

    @SuppressWarnings("unchecked")
    public List<sshrrulestrainings> getSshrRulesTrainingsList() {
      return (List<sshrrulestrainings>) get(PROPERTY_SSHRRULESTRAININGSLIST);
    }

    public void setSshrRulesTrainingsList(List<sshrrulestrainings> sshrRulesTrainingsList) {
        set(PROPERTY_SSHRRULESTRAININGSLIST, sshrRulesTrainingsList);
    }

}
