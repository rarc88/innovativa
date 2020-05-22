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
package com.sidesoft.flopec;

import com.sidesoft.hrm.payroll.advanced.SfprEmployeeRve;
import com.sidesoft.hrm.payroll.advanced.SfprEmployeeSurrogate;
import com.sidesoft.hrm.payroll.advanced.SfprRveDetail;

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
import org.openbravo.model.financialmgmt.accounting.Costcenter;
/**
 * Entity class for entity ssfl_vessel_type (stored in table ssfl_vessel_type).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ssflVesseltype extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ssfl_vessel_type";
    public static final String ENTITY_NAME = "ssfl_vessel_type";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_SEARCHKEY = "searchKey";
    public static final String PROPERTY_VESSELTYPE = "vesselType";
    public static final String PROPERTY_COSTCENTEREMSSFLVESSELTYPEIDLIST = "costcenterEMSsflVesselTypeIDList";
    public static final String PROPERTY_SFPREMPLOYEERVEEMSSFLVESSELTYPEIDLIST = "sfprEmployeeRveEMSsflVesselTypeIDList";
    public static final String PROPERTY_SFPREMPLOYEESURROGATEEMSSFLVESSELTYPEIDLIST = "sfprEmployeeSurrogateEMSsflVesselTypeIDList";
    public static final String PROPERTY_SFPRRVEDETAILEMSSFLVESSELTYPELIST = "sfprRveDetailEMSSFLVesselTypeList";

    public ssflVesseltype() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_VESSELTYPE, "H");
        setDefaultValue(PROPERTY_COSTCENTEREMSSFLVESSELTYPEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPREMPLOYEERVEEMSSFLVESSELTYPEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPREMPLOYEESURROGATEEMSSFLVESSELTYPEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPRRVEDETAILEMSSFLVESSELTYPELIST, new ArrayList<Object>());
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

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
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

    public Boolean isActive() {
        return (Boolean) get(PROPERTY_ACTIVE);
    }

    public void setActive(Boolean active) {
        set(PROPERTY_ACTIVE, active);
    }

    public String getSearchKey() {
        return (String) get(PROPERTY_SEARCHKEY);
    }

    public void setSearchKey(String searchKey) {
        set(PROPERTY_SEARCHKEY, searchKey);
    }

    public String getVesselType() {
        return (String) get(PROPERTY_VESSELTYPE);
    }

    public void setVesselType(String vesselType) {
        set(PROPERTY_VESSELTYPE, vesselType);
    }

    @SuppressWarnings("unchecked")
    public List<Costcenter> getCostcenterEMSsflVesselTypeIDList() {
      return (List<Costcenter>) get(PROPERTY_COSTCENTEREMSSFLVESSELTYPEIDLIST);
    }

    public void setCostcenterEMSsflVesselTypeIDList(List<Costcenter> costcenterEMSsflVesselTypeIDList) {
        set(PROPERTY_COSTCENTEREMSSFLVESSELTYPEIDLIST, costcenterEMSsflVesselTypeIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprEmployeeRve> getSfprEmployeeRveEMSsflVesselTypeIDList() {
      return (List<SfprEmployeeRve>) get(PROPERTY_SFPREMPLOYEERVEEMSSFLVESSELTYPEIDLIST);
    }

    public void setSfprEmployeeRveEMSsflVesselTypeIDList(List<SfprEmployeeRve> sfprEmployeeRveEMSsflVesselTypeIDList) {
        set(PROPERTY_SFPREMPLOYEERVEEMSSFLVESSELTYPEIDLIST, sfprEmployeeRveEMSsflVesselTypeIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprEmployeeSurrogate> getSfprEmployeeSurrogateEMSsflVesselTypeIDList() {
      return (List<SfprEmployeeSurrogate>) get(PROPERTY_SFPREMPLOYEESURROGATEEMSSFLVESSELTYPEIDLIST);
    }

    public void setSfprEmployeeSurrogateEMSsflVesselTypeIDList(List<SfprEmployeeSurrogate> sfprEmployeeSurrogateEMSsflVesselTypeIDList) {
        set(PROPERTY_SFPREMPLOYEESURROGATEEMSSFLVESSELTYPEIDLIST, sfprEmployeeSurrogateEMSsflVesselTypeIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprRveDetail> getSfprRveDetailEMSSFLVesselTypeList() {
      return (List<SfprRveDetail>) get(PROPERTY_SFPRRVEDETAILEMSSFLVESSELTYPELIST);
    }

    public void setSfprRveDetailEMSSFLVesselTypeList(List<SfprRveDetail> sfprRveDetailEMSSFLVesselTypeList) {
        set(PROPERTY_SFPRRVEDETAILEMSSFLVESSELTYPELIST, sfprRveDetailEMSSFLVesselTypeList);
    }

}
