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
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.accounting.UserDimension1;
import org.openbravo.model.financialmgmt.accounting.UserDimension2;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
import org.openbravo.model.financialmgmt.assetmgmt.AssetGroup;
/**
 * Entity class for entity ssal_appl_active (stored in table ssal_appl_active).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SsalApplActive extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ssal_appl_active";
    public static final String ENTITY_NAME = "ssal_appl_active";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_DOCUMENTTYPE = "documentType";
    public static final String PROPERTY_COSTCENTER = "costCenter";
    public static final String PROPERTY_STDIMENSION = "stDimension";
    public static final String PROPERTY_NDDIMENSION = "ndDimension";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_DATEAPPLICATION = "dateApplication";
    public static final String PROPERTY_QUANTITY = "quantity";
    public static final String PROPERTY_SEARCHKEY = "searchKey";
    public static final String PROPERTY_JUSTIFICATION = "justification";
    public static final String PROPERTY_COMMERCIALNAME = "commercialName";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_APPROVED = "approved";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_CANCELPROCESSED = "cancelProcessed";
    public static final String PROPERTY_EDIFICE = "edifice";
    public static final String PROPERTY_UNIT = "unit";
    public static final String PROPERTY_DEPARTMENT = "department";
    public static final String PROPERTY_PROCESSREQUEST = "processRequest";
    public static final String PROPERTY_STATE = "state";
    public static final String PROPERTY_ASSET = "asset";
    public static final String PROPERTY_ASSETCATEGORY = "assetCategory";
    public static final String PROPERTY_DATETRANSACTION = "dateTransaction";
    public static final String PROPERTY_DESCRIPTIONMOV = "descriptionMov";
    public static final String PROPERTY_ASSETCOD = "assetCod";
    public static final String PROPERTY_DATERETURN = "dateReturn";
    public static final String PROPERTY_MOTIVERETURN = "motiveReturn";
    public static final String PROPERTY_RETURN = "return";
    public static final String PROPERTY_DOCTYPEIDRETURN = "doctypeIdReturn";
    public static final String PROPERTY_DOCUMENTNORETURN = "documentnoReturn";
    public static final String PROPERTY_STARTDATE = "startdate";
    public static final String PROPERTY_ENDDATE = "enddate";
    public static final String PROPERTY_CUSTODIAN = "custodian";
    public static final String PROPERTY_UPCEAN = "uPCEAN";
    public static final String PROPERTY_DESCRIPTIONACTIVE = "descriptionActive";
    public static final String PROPERTY_SSALASSETRETURNSSALASSETAPPIDLIST = "ssalAssetReturnSsalAssetAppIDList";
    public static final String PROPERTY_SSALASSETRETURNLINELIST = "ssalAssetReturnlineList";

    public SsalApplActive() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_APPROVED, false);
        setDefaultValue(PROPERTY_PROCESSED, false);
        setDefaultValue(PROPERTY_CANCELPROCESSED, false);
        setDefaultValue(PROPERTY_PROCESSREQUEST, false);
        setDefaultValue(PROPERTY_RETURN, false);
        setDefaultValue(PROPERTY_SSALASSETRETURNSSALASSETAPPIDLIST, new ArrayList<Object>());
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

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public DocumentType getDocumentType() {
        return (DocumentType) get(PROPERTY_DOCUMENTTYPE);
    }

    public void setDocumentType(DocumentType documentType) {
        set(PROPERTY_DOCUMENTTYPE, documentType);
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

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public Date getDateApplication() {
        return (Date) get(PROPERTY_DATEAPPLICATION);
    }

    public void setDateApplication(Date dateApplication) {
        set(PROPERTY_DATEAPPLICATION, dateApplication);
    }

    public Long getQuantity() {
        return (Long) get(PROPERTY_QUANTITY);
    }

    public void setQuantity(Long quantity) {
        set(PROPERTY_QUANTITY, quantity);
    }

    public String getSearchKey() {
        return (String) get(PROPERTY_SEARCHKEY);
    }

    public void setSearchKey(String searchKey) {
        set(PROPERTY_SEARCHKEY, searchKey);
    }

    public String getJustification() {
        return (String) get(PROPERTY_JUSTIFICATION);
    }

    public void setJustification(String justification) {
        set(PROPERTY_JUSTIFICATION, justification);
    }

    public String getCommercialName() {
        return (String) get(PROPERTY_COMMERCIALNAME);
    }

    public void setCommercialName(String commercialName) {
        set(PROPERTY_COMMERCIALNAME, commercialName);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

    public Boolean isApproved() {
        return (Boolean) get(PROPERTY_APPROVED);
    }

    public void setApproved(Boolean approved) {
        set(PROPERTY_APPROVED, approved);
    }

    public Boolean isProcessed() {
        return (Boolean) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(Boolean processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public Boolean isCancelProcessed() {
        return (Boolean) get(PROPERTY_CANCELPROCESSED);
    }

    public void setCancelProcessed(Boolean cancelProcessed) {
        set(PROPERTY_CANCELPROCESSED, cancelProcessed);
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

    public Boolean isProcessRequest() {
        return (Boolean) get(PROPERTY_PROCESSREQUEST);
    }

    public void setProcessRequest(Boolean processRequest) {
        set(PROPERTY_PROCESSREQUEST, processRequest);
    }

    public String getState() {
        return (String) get(PROPERTY_STATE);
    }

    public void setState(String state) {
        set(PROPERTY_STATE, state);
    }

    public Asset getAsset() {
        return (Asset) get(PROPERTY_ASSET);
    }

    public void setAsset(Asset asset) {
        set(PROPERTY_ASSET, asset);
    }

    public AssetGroup getAssetCategory() {
        return (AssetGroup) get(PROPERTY_ASSETCATEGORY);
    }

    public void setAssetCategory(AssetGroup assetCategory) {
        set(PROPERTY_ASSETCATEGORY, assetCategory);
    }

    public Date getDateTransaction() {
        return (Date) get(PROPERTY_DATETRANSACTION);
    }

    public void setDateTransaction(Date dateTransaction) {
        set(PROPERTY_DATETRANSACTION, dateTransaction);
    }

    public String getDescriptionMov() {
        return (String) get(PROPERTY_DESCRIPTIONMOV);
    }

    public void setDescriptionMov(String descriptionMov) {
        set(PROPERTY_DESCRIPTIONMOV, descriptionMov);
    }

    public Asset getAssetCod() {
        return (Asset) get(PROPERTY_ASSETCOD);
    }

    public void setAssetCod(Asset assetCod) {
        set(PROPERTY_ASSETCOD, assetCod);
    }

    public Date getDateReturn() {
        return (Date) get(PROPERTY_DATERETURN);
    }

    public void setDateReturn(Date dateReturn) {
        set(PROPERTY_DATERETURN, dateReturn);
    }

    public String getMotiveReturn() {
        return (String) get(PROPERTY_MOTIVERETURN);
    }

    public void setMotiveReturn(String motiveReturn) {
        set(PROPERTY_MOTIVERETURN, motiveReturn);
    }

    public Boolean isReturn() {
        return (Boolean) get(PROPERTY_RETURN);
    }

    public void setReturn(Boolean rturn) {
        set(PROPERTY_RETURN, rturn);
    }

    public DocumentType getDoctypeIdReturn() {
        return (DocumentType) get(PROPERTY_DOCTYPEIDRETURN);
    }

    public void setDoctypeIdReturn(DocumentType doctypeIdReturn) {
        set(PROPERTY_DOCTYPEIDRETURN, doctypeIdReturn);
    }

    public String getDocumentnoReturn() {
        return (String) get(PROPERTY_DOCUMENTNORETURN);
    }

    public void setDocumentnoReturn(String documentnoReturn) {
        set(PROPERTY_DOCUMENTNORETURN, documentnoReturn);
    }

    public Date getStartdate() {
        return (Date) get(PROPERTY_STARTDATE);
    }

    public void setStartdate(Date startdate) {
        set(PROPERTY_STARTDATE, startdate);
    }

    public Date getEnddate() {
        return (Date) get(PROPERTY_ENDDATE);
    }

    public void setEnddate(Date enddate) {
        set(PROPERTY_ENDDATE, enddate);
    }

    public BusinessPartner getCustodian() {
        return (BusinessPartner) get(PROPERTY_CUSTODIAN);
    }

    public void setCustodian(BusinessPartner custodian) {
        set(PROPERTY_CUSTODIAN, custodian);
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

    @SuppressWarnings("unchecked")
    public List<SsalAssetReturn> getSsalAssetReturnSsalAssetAppIDList() {
      return (List<SsalAssetReturn>) get(PROPERTY_SSALASSETRETURNSSALASSETAPPIDLIST);
    }

    public void setSsalAssetReturnSsalAssetAppIDList(List<SsalAssetReturn> ssalAssetReturnSsalAssetAppIDList) {
        set(PROPERTY_SSALASSETRETURNSSALASSETAPPIDLIST, ssalAssetReturnSsalAssetAppIDList);
    }

    @SuppressWarnings("unchecked")
    public List<ssalassetreturnline> getSsalAssetReturnlineList() {
      return (List<ssalassetreturnline>) get(PROPERTY_SSALASSETRETURNLINELIST);
    }

    public void setSsalAssetReturnlineList(List<ssalassetreturnline> ssalAssetReturnlineList) {
        set(PROPERTY_SSALASSETRETURNLINELIST, ssalAssetReturnlineList);
    }

}
