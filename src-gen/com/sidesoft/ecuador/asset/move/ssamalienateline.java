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
package com.sidesoft.ecuador.asset.move;

import java.math.BigDecimal;
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
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
import org.openbravo.model.financialmgmt.assetmgmt.AssetGroup;
/**
 * Entity class for entity ssam_alienateline (stored in table ssam_alienateline).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ssamalienateline extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ssam_alienateline";
    public static final String ENTITY_NAME = "ssam_alienateline";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_LINENO = "lineNo";
    public static final String PROPERTY_ALERTSTATUS = "alertStatus";
    public static final String PROPERTY_ALIENATEDATE = "alienatedate";
    public static final String PROPERTY_SSAMALIENATE = "ssamAlienate";
    public static final String PROPERTY_ASSET = "asset";
    public static final String PROPERTY_ASSETGROUP = "assetGroup";
    public static final String PROPERTY_DEPRECIATIONENDDATE = "depreciationEndDate";
    public static final String PROPERTY_DEPRECIATIONSTARTDATE = "depreciationStartDate";
    public static final String PROPERTY_AMORTIZATIONTYPE = "amortizationtype";
    public static final String PROPERTY_AMORTIZATIONCALCTYPE = "amortizationcalctype";
    public static final String PROPERTY_CANCELLATIONDATE = "cancellationDate";
    public static final String PROPERTY_PURCHASEDATE = "purchaseDate";
    public static final String PROPERTY_ASSETVALUE = "assetValue";
    public static final String PROPERTY_AMORTIZATIONVALUE = "amortizationvalue";
    public static final String PROPERTY_NETVALUE = "netvalue";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_INVOICE = "invoice";
    public static final String PROPERTY_REPLACEMENTVALUE = "replacementValue";
    public static final String PROPERTY_FINANCIALMGMTASSETEMSSAMALIENATELINEIDLIST = "financialMgmtAssetEMSsamAlienatelineIDList";

    public ssamalienateline() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_ALERTSTATUS, false);
        setDefaultValue(PROPERTY_ASSETVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_AMORTIZATIONVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_NETVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_REPLACEMENTVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_FINANCIALMGMTASSETEMSSAMALIENATELINEIDLIST, new ArrayList<Object>());
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

    public Long getLineNo() {
        return (Long) get(PROPERTY_LINENO);
    }

    public void setLineNo(Long lineNo) {
        set(PROPERTY_LINENO, lineNo);
    }

    public Boolean isAlertStatus() {
        return (Boolean) get(PROPERTY_ALERTSTATUS);
    }

    public void setAlertStatus(Boolean alertStatus) {
        set(PROPERTY_ALERTSTATUS, alertStatus);
    }

    public Date getAlienatedate() {
        return (Date) get(PROPERTY_ALIENATEDATE);
    }

    public void setAlienatedate(Date alienatedate) {
        set(PROPERTY_ALIENATEDATE, alienatedate);
    }

    public ssamalienate getSsamAlienate() {
        return (ssamalienate) get(PROPERTY_SSAMALIENATE);
    }

    public void setSsamAlienate(ssamalienate ssamAlienate) {
        set(PROPERTY_SSAMALIENATE, ssamAlienate);
    }

    public Asset getAsset() {
        return (Asset) get(PROPERTY_ASSET);
    }

    public void setAsset(Asset asset) {
        set(PROPERTY_ASSET, asset);
    }

    public AssetGroup getAssetGroup() {
        return (AssetGroup) get(PROPERTY_ASSETGROUP);
    }

    public void setAssetGroup(AssetGroup assetGroup) {
        set(PROPERTY_ASSETGROUP, assetGroup);
    }

    public Date getDepreciationEndDate() {
        return (Date) get(PROPERTY_DEPRECIATIONENDDATE);
    }

    public void setDepreciationEndDate(Date depreciationEndDate) {
        set(PROPERTY_DEPRECIATIONENDDATE, depreciationEndDate);
    }

    public Date getDepreciationStartDate() {
        return (Date) get(PROPERTY_DEPRECIATIONSTARTDATE);
    }

    public void setDepreciationStartDate(Date depreciationStartDate) {
        set(PROPERTY_DEPRECIATIONSTARTDATE, depreciationStartDate);
    }

    public String getAmortizationtype() {
        return (String) get(PROPERTY_AMORTIZATIONTYPE);
    }

    public void setAmortizationtype(String amortizationtype) {
        set(PROPERTY_AMORTIZATIONTYPE, amortizationtype);
    }

    public String getAmortizationcalctype() {
        return (String) get(PROPERTY_AMORTIZATIONCALCTYPE);
    }

    public void setAmortizationcalctype(String amortizationcalctype) {
        set(PROPERTY_AMORTIZATIONCALCTYPE, amortizationcalctype);
    }

    public Date getCancellationDate() {
        return (Date) get(PROPERTY_CANCELLATIONDATE);
    }

    public void setCancellationDate(Date cancellationDate) {
        set(PROPERTY_CANCELLATIONDATE, cancellationDate);
    }

    public Date getPurchaseDate() {
        return (Date) get(PROPERTY_PURCHASEDATE);
    }

    public void setPurchaseDate(Date purchaseDate) {
        set(PROPERTY_PURCHASEDATE, purchaseDate);
    }

    public BigDecimal getAssetValue() {
        return (BigDecimal) get(PROPERTY_ASSETVALUE);
    }

    public void setAssetValue(BigDecimal assetValue) {
        set(PROPERTY_ASSETVALUE, assetValue);
    }

    public BigDecimal getAmortizationvalue() {
        return (BigDecimal) get(PROPERTY_AMORTIZATIONVALUE);
    }

    public void setAmortizationvalue(BigDecimal amortizationvalue) {
        set(PROPERTY_AMORTIZATIONVALUE, amortizationvalue);
    }

    public BigDecimal getNetvalue() {
        return (BigDecimal) get(PROPERTY_NETVALUE);
    }

    public void setNetvalue(BigDecimal netvalue) {
        set(PROPERTY_NETVALUE, netvalue);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Invoice getInvoice() {
        return (Invoice) get(PROPERTY_INVOICE);
    }

    public void setInvoice(Invoice invoice) {
        set(PROPERTY_INVOICE, invoice);
    }

    public BigDecimal getReplacementValue() {
        return (BigDecimal) get(PROPERTY_REPLACEMENTVALUE);
    }

    public void setReplacementValue(BigDecimal replacementValue) {
        set(PROPERTY_REPLACEMENTVALUE, replacementValue);
    }

    @SuppressWarnings("unchecked")
    public List<Asset> getFinancialMgmtAssetEMSsamAlienatelineIDList() {
      return (List<Asset>) get(PROPERTY_FINANCIALMGMTASSETEMSSAMALIENATELINEIDLIST);
    }

    public void setFinancialMgmtAssetEMSsamAlienatelineIDList(List<Asset> financialMgmtAssetEMSsamAlienatelineIDList) {
        set(PROPERTY_FINANCIALMGMTASSETEMSSAMALIENATELINEIDLIST, financialMgmtAssetEMSsamAlienatelineIDList);
    }

}
