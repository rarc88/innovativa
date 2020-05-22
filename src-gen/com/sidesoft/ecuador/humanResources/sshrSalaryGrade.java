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
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.Organization;
/**
 * Entity class for entity sshr_salary_grade (stored in table sshr_salary_grade).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class sshrSalaryGrade extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sshr_salary_grade";
    public static final String ENTITY_NAME = "sshr_salary_grade";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_SALARYMIN = "salaryMin";
    public static final String PROPERTY_SALARYMAX = "salaryMax";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_SSHRJOBLIST = "sshrJobList";
    public static final String PROPERTY_SSHRRULESCONCOURSLIST = "sshrRulesConcoursList";
    public static final String PROPERTY_SSHRSALARYCOMPONENTLIST = "sshrSalaryComponentList";

    public sshrSalaryGrade() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_SALARYMIN, (long) 0);
        setDefaultValue(PROPERTY_SALARYMAX, (long) 0);
        setDefaultValue(PROPERTY_SSHRJOBLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSHRRULESCONCOURSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSHRSALARYCOMPONENTLIST, new ArrayList<Object>());
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

    public Position getName() {
        return (Position) get(PROPERTY_NAME);
    }

    public void setName(Position name) {
        set(PROPERTY_NAME, name);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Long getSalaryMin() {
        return (Long) get(PROPERTY_SALARYMIN);
    }

    public void setSalaryMin(Long salaryMin) {
        set(PROPERTY_SALARYMIN, salaryMin);
    }

    public Long getSalaryMax() {
        return (Long) get(PROPERTY_SALARYMAX);
    }

    public void setSalaryMax(Long salaryMax) {
        set(PROPERTY_SALARYMAX, salaryMax);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    @SuppressWarnings("unchecked")
    public List<sshrJob> getSshrJobList() {
      return (List<sshrJob>) get(PROPERTY_SSHRJOBLIST);
    }

    public void setSshrJobList(List<sshrJob> sshrJobList) {
        set(PROPERTY_SSHRJOBLIST, sshrJobList);
    }

    @SuppressWarnings("unchecked")
    public List<sshrrulesconcours> getSshrRulesConcoursList() {
      return (List<sshrrulesconcours>) get(PROPERTY_SSHRRULESCONCOURSLIST);
    }

    public void setSshrRulesConcoursList(List<sshrrulesconcours> sshrRulesConcoursList) {
        set(PROPERTY_SSHRRULESCONCOURSLIST, sshrRulesConcoursList);
    }

    @SuppressWarnings("unchecked")
    public List<sshrSalaryComponent> getSshrSalaryComponentList() {
      return (List<sshrSalaryComponent>) get(PROPERTY_SSHRSALARYCOMPONENTLIST);
    }

    public void setSshrSalaryComponentList(List<sshrSalaryComponent> sshrSalaryComponentList) {
        set(PROPERTY_SSHRSALARYCOMPONENTLIST, sshrSalaryComponentList);
    }

}
