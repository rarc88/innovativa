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
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.plm.Product;
/**
 * Entity class for entity ssal_asset_return (stored in table ssal_asset_return).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SsalAssetReturn extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ssal_asset_return";
    public static final String ENTITY_NAME = "ssal_asset_return";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_SSALSTATE = "ssalState";
    public static final String PROPERTY_DATEMOV = "dateMov";
    public static final String PROPERTY_LOADASSETS = "loadAssets";
    public static final String PROPERTY_DOCUMENTTYPE = "documentType";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_LOADACTIVE = "loadActive";
    public static final String PROPERTY_SSALASSETAPP = "ssalAssetApp";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_ENDDATE = "enddate";
    public static final String PROPERTY_GENERATELINES = "generateLines";
    public static final String PROPERTY_CUSTODIAN = "custodian";
    public static final String PROPERTY_SSALASSETRETURNLINELIST = "ssalAssetReturnlineList";

    public SsalAssetReturn() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_LOADASSETS, false);
        setDefaultValue(PROPERTY_LOADACTIVE, false);
        setDefaultValue(PROPERTY_GENERATELINES, false);
        setDefaultValue(PROPERTY_SSALASSETRETURNLINELIST, new ArrayList<Object>());
    }

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
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

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
    }

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public String getSsalState() {
        return (String) get(PROPERTY_SSALSTATE);
    }

    public void setSsalState(String ssalState) {
        set(PROPERTY_SSALSTATE, ssalState);
    }

    public Date getDateMov() {
        return (Date) get(PROPERTY_DATEMOV);
    }

    public void setDateMov(Date dateMov) {
        set(PROPERTY_DATEMOV, dateMov);
    }

    public Boolean isLoadAssets() {
        return (Boolean) get(PROPERTY_LOADASSETS);
    }

    public void setLoadAssets(Boolean loadAssets) {
        set(PROPERTY_LOADASSETS, loadAssets);
    }

    public DocumentType getDocumentType() {
        return (DocumentType) get(PROPERTY_DOCUMENTTYPE);
    }

    public void setDocumentType(DocumentType documentType) {
        set(PROPERTY_DOCUMENTTYPE, documentType);
    }

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

    public Boolean isLoadActive() {
        return (Boolean) get(PROPERTY_LOADACTIVE);
    }

    public void setLoadActive(Boolean loadActive) {
        set(PROPERTY_LOADACTIVE, loadActive);
    }

    public SsalApplActive getSsalAssetApp() {
        return (SsalApplActive) get(PROPERTY_SSALASSETAPP);
    }

    public void setSsalAssetApp(SsalApplActive ssalAssetApp) {
        set(PROPERTY_SSALASSETAPP, ssalAssetApp);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Date getEnddate() {
        return (Date) get(PROPERTY_ENDDATE);
    }

    public void setEnddate(Date enddate) {
        set(PROPERTY_ENDDATE, enddate);
    }

    public Boolean isGenerateLines() {
        return (Boolean) get(PROPERTY_GENERATELINES);
    }

    public void setGenerateLines(Boolean generateLines) {
        set(PROPERTY_GENERATELINES, generateLines);
    }

    public BusinessPartner getCustodian() {
        return (BusinessPartner) get(PROPERTY_CUSTODIAN);
    }

    public void setCustodian(BusinessPartner custodian) {
        set(PROPERTY_CUSTODIAN, custodian);
    }

    @SuppressWarnings("unchecked")
    public List<ssalassetreturnline> getSsalAssetReturnlineList() {
      return (List<ssalassetreturnline>) get(PROPERTY_SSALASSETRETURNLINELIST);
    }

    public void setSsalAssetReturnlineList(List<ssalassetreturnline> ssalAssetReturnlineList) {
        set(PROPERTY_SSALASSETRETURNLINELIST, ssalAssetReturnlineList);
    }

}
