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

import com.sidesoft.hrm.payroll.ssprleaveemp;

import ec.com.sidesoft.custom.payroll.partialpayment.scppapprovalpaymentline;

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
import org.openbravo.model.common.geography.Location;
import org.openbravo.model.financialmgmt.accounting.Costcenter;
/**
 * Entity class for entity sshr_department (stored in table sshr_department).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class sshrDepartment extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sshr_department";
    public static final String ENTITY_NAME = "sshr_department";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_SEARCHKEY = "searchKey";
    public static final String PROPERTY_LOCATIONADDRESS = "locationAddress";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_COSTCENTER = "costCenter";
    public static final String PROPERTY_DEPARTMENT2 = "department2";
    public static final String PROPERTY_BUSINESSPARTNEREMSSHRDEPARTMENTIDLIST = "businessPartnerEMSshrDepartmentIDList";
    public static final String PROPERTY_SSPRLEAVEEMPEMSSHRDEPARTMENTLIST = "sSPRLeaveEmpEMSSHRDepartmentList";
    public static final String PROPERTY_SCPPAPPROVALPAYMENTLINELIST = "scppApprovalpaymentlineList";
    public static final String PROPERTY_SSHRDEPARTMENTDEPARTMENT2IDLIST = "sshrDepartmentDepartment2IDList";
    public static final String PROPERTY_SSHRJOBLIST = "sshrJobList";
    public static final String PROPERTY_SSHRRULESCONCOURSLIST = "sshrRulesConcoursList";

    public sshrDepartment() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_BUSINESSPARTNEREMSSHRDEPARTMENTIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRLEAVEEMPEMSSHRDEPARTMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCPPAPPROVALPAYMENTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSHRDEPARTMENTDEPARTMENT2IDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSHRJOBLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSHRRULESCONCOURSLIST, new ArrayList<Object>());
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

    public String getSearchKey() {
        return (String) get(PROPERTY_SEARCHKEY);
    }

    public void setSearchKey(String searchKey) {
        set(PROPERTY_SEARCHKEY, searchKey);
    }

    public Location getLocationAddress() {
        return (Location) get(PROPERTY_LOCATIONADDRESS);
    }

    public void setLocationAddress(Location locationAddress) {
        set(PROPERTY_LOCATIONADDRESS, locationAddress);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Costcenter getCostCenter() {
        return (Costcenter) get(PROPERTY_COSTCENTER);
    }

    public void setCostCenter(Costcenter costCenter) {
        set(PROPERTY_COSTCENTER, costCenter);
    }

    public sshrDepartment getDepartment2() {
        return (sshrDepartment) get(PROPERTY_DEPARTMENT2);
    }

    public void setDepartment2(sshrDepartment department2) {
        set(PROPERTY_DEPARTMENT2, department2);
    }

    @SuppressWarnings("unchecked")
    public List<BusinessPartner> getBusinessPartnerEMSshrDepartmentIDList() {
      return (List<BusinessPartner>) get(PROPERTY_BUSINESSPARTNEREMSSHRDEPARTMENTIDLIST);
    }

    public void setBusinessPartnerEMSshrDepartmentIDList(List<BusinessPartner> businessPartnerEMSshrDepartmentIDList) {
        set(PROPERTY_BUSINESSPARTNEREMSSHRDEPARTMENTIDLIST, businessPartnerEMSshrDepartmentIDList);
    }

    @SuppressWarnings("unchecked")
    public List<ssprleaveemp> getSSPRLeaveEmpEMSSHRDepartmentList() {
      return (List<ssprleaveemp>) get(PROPERTY_SSPRLEAVEEMPEMSSHRDEPARTMENTLIST);
    }

    public void setSSPRLeaveEmpEMSSHRDepartmentList(List<ssprleaveemp> sSPRLeaveEmpEMSSHRDepartmentList) {
        set(PROPERTY_SSPRLEAVEEMPEMSSHRDEPARTMENTLIST, sSPRLeaveEmpEMSSHRDepartmentList);
    }

    @SuppressWarnings("unchecked")
    public List<scppapprovalpaymentline> getScppApprovalpaymentlineList() {
      return (List<scppapprovalpaymentline>) get(PROPERTY_SCPPAPPROVALPAYMENTLINELIST);
    }

    public void setScppApprovalpaymentlineList(List<scppapprovalpaymentline> scppApprovalpaymentlineList) {
        set(PROPERTY_SCPPAPPROVALPAYMENTLINELIST, scppApprovalpaymentlineList);
    }

    @SuppressWarnings("unchecked")
    public List<sshrDepartment> getSshrDepartmentDepartment2IDList() {
      return (List<sshrDepartment>) get(PROPERTY_SSHRDEPARTMENTDEPARTMENT2IDLIST);
    }

    public void setSshrDepartmentDepartment2IDList(List<sshrDepartment> sshrDepartmentDepartment2IDList) {
        set(PROPERTY_SSHRDEPARTMENTDEPARTMENT2IDLIST, sshrDepartmentDepartment2IDList);
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

}
