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
package ec.com.sidesoft.budget.transfers;

import com.sidesoft.flopec.budget.data.SFBBudgetArea;
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
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.accounting.UserDimension1;
/**
 * Entity class for entity Sfbtr_Transfer_From (stored in table Sfbtr_Transfer_From).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SfbtrTransferFrom extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "Sfbtr_Transfer_From";
    public static final String ENTITY_NAME = "Sfbtr_Transfer_From";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_LINENO = "lineNo";
    public static final String PROPERTY_AREA = "area";
    public static final String PROPERTY_COSTCENTER = "costCenter";
    public static final String PROPERTY_STDIMENSION = "stDimension";
    public static final String PROPERTY_EXCHANGEDIFFERENCEBUDGETITEM = "exchangeDifferenceBudgetItem";
    public static final String PROPERTY_SFBTRBUDGETARYREFORMS = "sfbtrBudgetaryReforms";
    public static final String PROPERTY_AVAILABLEVALUE = "availableValue";
    public static final String PROPERTY_VALUEDISCOUNTED = "valueDiscounted";
    public static final String PROPERTY_SUMMARYLEVEL = "summaryLevel";
    public static final String PROPERTY_BUDGETLINE = "budgetLine";

    public SfbtrTransferFrom() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_SUMMARYLEVEL, false);
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

    public SFBBudgetArea getArea() {
        return (SFBBudgetArea) get(PROPERTY_AREA);
    }

    public void setArea(SFBBudgetArea area) {
        set(PROPERTY_AREA, area);
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

    public SFBBudgetItem getExchangeDifferenceBudgetItem() {
        return (SFBBudgetItem) get(PROPERTY_EXCHANGEDIFFERENCEBUDGETITEM);
    }

    public void setExchangeDifferenceBudgetItem(SFBBudgetItem exchangeDifferenceBudgetItem) {
        set(PROPERTY_EXCHANGEDIFFERENCEBUDGETITEM, exchangeDifferenceBudgetItem);
    }

    public SfbtrBudgetaryReforms getSfbtrBudgetaryReforms() {
        return (SfbtrBudgetaryReforms) get(PROPERTY_SFBTRBUDGETARYREFORMS);
    }

    public void setSfbtrBudgetaryReforms(SfbtrBudgetaryReforms sfbtrBudgetaryReforms) {
        set(PROPERTY_SFBTRBUDGETARYREFORMS, sfbtrBudgetaryReforms);
    }

    public BigDecimal getAvailableValue() {
        return (BigDecimal) get(PROPERTY_AVAILABLEVALUE);
    }

    public void setAvailableValue(BigDecimal availableValue) {
        set(PROPERTY_AVAILABLEVALUE, availableValue);
    }

    public BigDecimal getValueDiscounted() {
        return (BigDecimal) get(PROPERTY_VALUEDISCOUNTED);
    }

    public void setValueDiscounted(BigDecimal valueDiscounted) {
        set(PROPERTY_VALUEDISCOUNTED, valueDiscounted);
    }

    public Boolean isSummaryLevel() {
        return (Boolean) get(PROPERTY_SUMMARYLEVEL);
    }

    public void setSummaryLevel(Boolean summaryLevel) {
        set(PROPERTY_SUMMARYLEVEL, summaryLevel);
    }

    public SFBBudgetLine getBudgetLine() {
        return (SFBBudgetLine) get(PROPERTY_BUDGETLINE);
    }

    public void setBudgetLine(SFBBudgetLine budgetLine) {
        set(PROPERTY_BUDGETLINE, budgetLine);
    }

}
