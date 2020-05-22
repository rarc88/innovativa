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
package com.sidesoft.ecuador.asset.allocation;

import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.accounting.UserDimension1;
import org.openbravo.model.financialmgmt.accounting.UserDimension2;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
import org.openbravo.model.financialmgmt.assetmgmt.AssetGroup;
/**
 * Entity class for entity ssal_asset_returnline (stored in table ssal_asset_returnline).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ssalassetreturnline extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ssal_asset_returnline";
    public static final String ENTITY_NAME = "ssal_asset_returnline";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_SSALASSETRETURN = "ssalAssetReturn";
    public static final String PROPERTY_SSALAPPLACTIVE = "ssalApplActive";
    public static final String PROPERTY_TRANFER = "tranfer";
    public static final String PROPERTY_EDIFICE = "edifice";
    public static final String PROPERTY_UNIT = "unit";
    public static final String PROPERTY_DEPARTMENT = "department";
    public static final String PROPERTY_COSTCENTER = "costCenter";
    public static final String PROPERTY_STDIMENSION = "stDimension";
    public static final String PROPERTY_NDDIMENSION = "ndDimension";
    public static final String PROPERTY_ASSETCATEGORY = "assetCategory";
    public static final String PROPERTY_CDIGOACTIVO = "cdigoActivo";
    public static final String PROPERTY_UPCEAN = "uPCEAN";
    public static final String PROPERTY_DESCRIPTIONACTIVE = "descriptionActive";

    public ssalassetreturnline() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_TRANFER, false);
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

    public SsalAssetReturn getSsalAssetReturn() {
        return (SsalAssetReturn) get(PROPERTY_SSALASSETRETURN);
    }

    public void setSsalAssetReturn(SsalAssetReturn ssalAssetReturn) {
        set(PROPERTY_SSALASSETRETURN, ssalAssetReturn);
    }

    public SsalApplActive getSsalApplActive() {
        return (SsalApplActive) get(PROPERTY_SSALAPPLACTIVE);
    }

    public void setSsalApplActive(SsalApplActive ssalApplActive) {
        set(PROPERTY_SSALAPPLACTIVE, ssalApplActive);
    }

    public Boolean isTranfer() {
        return (Boolean) get(PROPERTY_TRANFER);
    }

    public void setTranfer(Boolean tranfer) {
        set(PROPERTY_TRANFER, tranfer);
    }

    public ssalbuilding getEdifice() {
        return (ssalbuilding) get(PROPERTY_EDIFICE);
    }

    public void setEdifice(ssalbuilding edifice) {
        set(PROPERTY_EDIFICE, edifice);
    }

    public ssal_unit getUnit() {
        return (ssal_unit) get(PROPERTY_UNIT);
    }

    public void setUnit(ssal_unit unit) {
        set(PROPERTY_UNIT, unit);
    }

    public ssaldepartment getDepartment() {
        return (ssaldepartment) get(PROPERTY_DEPARTMENT);
    }

    public void setDepartment(ssaldepartment department) {
        set(PROPERTY_DEPARTMENT, department);
    }

    public Costcenter getCostCenter() {
        return (Costcenter) get(PROPERTY_COSTCENTER);
    }

    public void setCostCenter(Costcenter costCenter) {
        set(PROPERTY_COSTCENTER, costCenter);
    }

    public UserDimension1 getStDimension() {
        return (UserDimension1) get(PROPERTY_STDIMENSION);
    }

    public void setStDimension(UserDimension1 stDimension) {
        set(PROPERTY_STDIMENSION, stDimension);
    }

    public UserDimension2 getNdDimension() {
        return (UserDimension2) get(PROPERTY_NDDIMENSION);
    }

    public void setNdDimension(UserDimension2 ndDimension) {
        set(PROPERTY_NDDIMENSION, ndDimension);
    }

    public AssetGroup getAssetCategory() {
        return (AssetGroup) get(PROPERTY_ASSETCATEGORY);
    }

    public void setAssetCategory(AssetGroup assetCategory) {
        set(PROPERTY_ASSETCATEGORY, assetCategory);
    }

    public Asset getCdigoActivo() {
        return (Asset) get(PROPERTY_CDIGOACTIVO);
    }

    public void setCdigoActivo(Asset cdigoActivo) {
        set(PROPERTY_CDIGOACTIVO, cdigoActivo);
    }

    public Asset getUPCEAN() {
        return (Asset) get(PROPERTY_UPCEAN);
    }

    public void setUPCEAN(Asset uPCEAN) {
        set(PROPERTY_UPCEAN, uPCEAN);
    }

    public Asset getDescriptionActive() {
        return (Asset) get(PROPERTY_DESCRIPTIONACTIVE);
    }

    public void setDescriptionActive(Asset descriptionActive) {
        set(PROPERTY_DESCRIPTIONACTIVE, descriptionActive);
    }

}
