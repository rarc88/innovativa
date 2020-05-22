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
 * Entity class for entity sspr_leave_type (stored in table sspr_leave_type).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ssprleavetype extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sspr_leave_type";
    public static final String ENTITY_NAME = "sspr_leave_type";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_COMMERCIALNAME = "commercialName";
    public static final String PROPERTY_SEARCHKEY = "searchKey";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_NODAYS = "nodays";
    public static final String PROPERTY_NOHOURS = "nohours";
    public static final String PROPERTY_ADDTOVACANCIES = "addToVacancies";
    public static final String PROPERTY_SSPRLEAVEEMPLIST = "sSPRLeaveEmpList";
    public static final String PROPERTY_SSPRLEAVECATEGORYLIST = "ssprLeaveCategoryList";
    public static final String PROPERTY_SSPRLEAVEEMPMANTLIST = "ssprLeaveEmpMantList";
    public static final String PROPERTY_SSPRLEAVEEMPNOTESLIST = "ssprLeaveEmpNotesList";
    public static final String PROPERTY_SSPRLEAVEHRMANAGEMENTLIST = "ssprLeaveHrManagementList";

    public ssprleavetype() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_NODAYS, (long) 0);
        setDefaultValue(PROPERTY_NOHOURS, (long) 0);
        setDefaultValue(PROPERTY_ADDTOVACANCIES, false);
        setDefaultValue(PROPERTY_SSPRLEAVEEMPLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRLEAVECATEGORYLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRLEAVEEMPMANTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRLEAVEEMPNOTESLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRLEAVEHRMANAGEMENTLIST, new ArrayList<Object>());
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

    public String getCommercialName() {
        return (String) get(PROPERTY_COMMERCIALNAME);
    }

    public void setCommercialName(String commercialName) {
        set(PROPERTY_COMMERCIALNAME, commercialName);
    }

    public String getSearchKey() {
        return (String) get(PROPERTY_SEARCHKEY);
    }

    public void setSearchKey(String searchKey) {
        set(PROPERTY_SEARCHKEY, searchKey);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Long getNodays() {
        return (Long) get(PROPERTY_NODAYS);
    }

    public void setNodays(Long nodays) {
        set(PROPERTY_NODAYS, nodays);
    }

    public Long getNohours() {
        return (Long) get(PROPERTY_NOHOURS);
    }

    public void setNohours(Long nohours) {
        set(PROPERTY_NOHOURS, nohours);
    }

    public Boolean isAddToVacancies() {
        return (Boolean) get(PROPERTY_ADDTOVACANCIES);
    }

    public void setAddToVacancies(Boolean addToVacancies) {
        set(PROPERTY_ADDTOVACANCIES, addToVacancies);
    }

    @SuppressWarnings("unchecked")
    public List<ssprleaveemp> getSSPRLeaveEmpList() {
      return (List<ssprleaveemp>) get(PROPERTY_SSPRLEAVEEMPLIST);
    }

    public void setSSPRLeaveEmpList(List<ssprleaveemp> sSPRLeaveEmpList) {
        set(PROPERTY_SSPRLEAVEEMPLIST, sSPRLeaveEmpList);
    }

    @SuppressWarnings("unchecked")
    public List<ssprleavecategory> getSsprLeaveCategoryList() {
      return (List<ssprleavecategory>) get(PROPERTY_SSPRLEAVECATEGORYLIST);
    }

    public void setSsprLeaveCategoryList(List<ssprleavecategory> ssprLeaveCategoryList) {
        set(PROPERTY_SSPRLEAVECATEGORYLIST, ssprLeaveCategoryList);
    }

    @SuppressWarnings("unchecked")
    public List<ssprleaveempmant> getSsprLeaveEmpMantList() {
      return (List<ssprleaveempmant>) get(PROPERTY_SSPRLEAVEEMPMANTLIST);
    }

    public void setSsprLeaveEmpMantList(List<ssprleaveempmant> ssprLeaveEmpMantList) {
        set(PROPERTY_SSPRLEAVEEMPMANTLIST, ssprLeaveEmpMantList);
    }

    @SuppressWarnings("unchecked")
    public List<ssprleaveempnotes> getSsprLeaveEmpNotesList() {
      return (List<ssprleaveempnotes>) get(PROPERTY_SSPRLEAVEEMPNOTESLIST);
    }

    public void setSsprLeaveEmpNotesList(List<ssprleaveempnotes> ssprLeaveEmpNotesList) {
        set(PROPERTY_SSPRLEAVEEMPNOTESLIST, ssprLeaveEmpNotesList);
    }

    @SuppressWarnings("unchecked")
    public List<ssprleavehrmanagement> getSsprLeaveHrManagementList() {
      return (List<ssprleavehrmanagement>) get(PROPERTY_SSPRLEAVEHRMANAGEMENTLIST);
    }

    public void setSsprLeaveHrManagementList(List<ssprleavehrmanagement> ssprLeaveHrManagementList) {
        set(PROPERTY_SSPRLEAVEHRMANAGEMENTLIST, ssprLeaveHrManagementList);
    }

}
