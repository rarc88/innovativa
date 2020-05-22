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
package ec.com.sidesoft.poa.pac;

import com.sidesoft.flopec.budget.data.SFBBudgetItem;
import com.sidesoft.flopec.budget.data.SFBBudgetLine;

import java.math.BigDecimal;
import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.uom.UOM;
/**
 * Entity class for entity ecspp_pac (stored in table ecspp_pac).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class EcsppPAC extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ecspp_pac";
    public static final String ENTITY_NAME = "ecspp_pac";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_BUDGETITEM = "budgetItem";
    public static final String PROPERTY_BUDGETLINE = "budgetLine";
    public static final String PROPERTY_CPC = "cpc";
    public static final String PROPERTY_PRODUCTPURCHASETYPE = "productPurchaseType";
    public static final String PROPERTY_REGIMENTYPE = "regimenType";
    public static final String PROPERTY_BACKGROUNDBID = "backgroundBid";
    public static final String PROPERTY_BUDGETTYPE = "budgetType";
    public static final String PROPERTY_PRODUCTTYPE = "productType";
    public static final String PROPERTY_ELECTRONICCAT = "electronicCat";
    public static final String PROPERTY_PROCEDURES = "procedures";
    public static final String PROPERTY_QTYANNUAL = "qtyannual";
    public static final String PROPERTY_UOM = "uom";
    public static final String PROPERTY_COSTUNIT = "costunit";
    public static final String PROPERTY_BYPRODUCT = "byproduct";
    public static final String PROPERTY_TOTALITEM = "totalItem";
    public static final String PROPERTY_FOURMONTH1 = "fourMonth1";
    public static final String PROPERTY_FOURMONTH2 = "fourMonth2";
    public static final String PROPERTY_FOURMONTH3 = "fourMonth3";
    public static final String PROPERTY_OBSERVATION = "observation";

    public EcsppPAC() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_ELECTRONICCAT, true);
        setDefaultValue(PROPERTY_QTYANNUAL, new BigDecimal(0));
        setDefaultValue(PROPERTY_COSTUNIT, new BigDecimal(0));
        setDefaultValue(PROPERTY_TOTALITEM, new BigDecimal(0));
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

    public SFBBudgetItem getBudgetItem() {
        return (SFBBudgetItem) get(PROPERTY_BUDGETITEM);
    }

    public void setBudgetItem(SFBBudgetItem budgetItem) {
        set(PROPERTY_BUDGETITEM, budgetItem);
    }

    public SFBBudgetLine getBudgetLine() {
        return (SFBBudgetLine) get(PROPERTY_BUDGETLINE);
    }

    public void setBudgetLine(SFBBudgetLine budgetLine) {
        set(PROPERTY_BUDGETLINE, budgetLine);
    }

    public String getCpc() {
        return (String) get(PROPERTY_CPC);
    }

    public void setCpc(String cpc) {
        set(PROPERTY_CPC, cpc);
    }

    public String getProductPurchaseType() {
        return (String) get(PROPERTY_PRODUCTPURCHASETYPE);
    }

    public void setProductPurchaseType(String productPurchaseType) {
        set(PROPERTY_PRODUCTPURCHASETYPE, productPurchaseType);
    }

    public String getRegimenType() {
        return (String) get(PROPERTY_REGIMENTYPE);
    }

    public void setRegimenType(String regimenType) {
        set(PROPERTY_REGIMENTYPE, regimenType);
    }

    public String getBackgroundBid() {
        return (String) get(PROPERTY_BACKGROUNDBID);
    }

    public void setBackgroundBid(String backgroundBid) {
        set(PROPERTY_BACKGROUNDBID, backgroundBid);
    }

    public String getBudgetType() {
        return (String) get(PROPERTY_BUDGETTYPE);
    }

    public void setBudgetType(String budgetType) {
        set(PROPERTY_BUDGETTYPE, budgetType);
    }

    public String getProductType() {
        return (String) get(PROPERTY_PRODUCTTYPE);
    }

    public void setProductType(String productType) {
        set(PROPERTY_PRODUCTTYPE, productType);
    }

    public Boolean isElectronicCat() {
        return (Boolean) get(PROPERTY_ELECTRONICCAT);
    }

    public void setElectronicCat(Boolean electronicCat) {
        set(PROPERTY_ELECTRONICCAT, electronicCat);
    }

    public String getProcedures() {
        return (String) get(PROPERTY_PROCEDURES);
    }

    public void setProcedures(String procedures) {
        set(PROPERTY_PROCEDURES, procedures);
    }

    public BigDecimal getQtyannual() {
        return (BigDecimal) get(PROPERTY_QTYANNUAL);
    }

    public void setQtyannual(BigDecimal qtyannual) {
        set(PROPERTY_QTYANNUAL, qtyannual);
    }

    public UOM getUom() {
        return (UOM) get(PROPERTY_UOM);
    }

    public void setUom(UOM uom) {
        set(PROPERTY_UOM, uom);
    }

    public BigDecimal getCostunit() {
        return (BigDecimal) get(PROPERTY_COSTUNIT);
    }

    public void setCostunit(BigDecimal costunit) {
        set(PROPERTY_COSTUNIT, costunit);
    }

    public String getByproduct() {
        return (String) get(PROPERTY_BYPRODUCT);
    }

    public void setByproduct(String byproduct) {
        set(PROPERTY_BYPRODUCT, byproduct);
    }

    public BigDecimal getTotalItem() {
        return (BigDecimal) get(PROPERTY_TOTALITEM);
    }

    public void setTotalItem(BigDecimal totalItem) {
        set(PROPERTY_TOTALITEM, totalItem);
    }

    public String getFourMonth1() {
        return (String) get(PROPERTY_FOURMONTH1);
    }

    public void setFourMonth1(String fourMonth1) {
        set(PROPERTY_FOURMONTH1, fourMonth1);
    }

    public String getFourMonth2() {
        return (String) get(PROPERTY_FOURMONTH2);
    }

    public void setFourMonth2(String fourMonth2) {
        set(PROPERTY_FOURMONTH2, fourMonth2);
    }

    public String getFourMonth3() {
        return (String) get(PROPERTY_FOURMONTH3);
    }

    public void setFourMonth3(String fourMonth3) {
        set(PROPERTY_FOURMONTH3, fourMonth3);
    }

    public String getObservation() {
        return (String) get(PROPERTY_OBSERVATION);
    }

    public void setObservation(String observation) {
        set(PROPERTY_OBSERVATION, observation);
    }

}
