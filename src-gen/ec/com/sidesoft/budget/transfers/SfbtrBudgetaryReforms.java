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
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.accounting.UserDimension1;
import org.openbravo.model.financialmgmt.calendar.Year;
/**
 * Entity class for entity Sfbtr_Budgetary_Reforms (stored in table Sfbtr_Budgetary_Reforms).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SfbtrBudgetaryReforms extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "Sfbtr_Budgetary_Reforms";
    public static final String ENTITY_NAME = "Sfbtr_Budgetary_Reforms";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_BANKSTATEMENTTYPE = "bankStatementType";
    public static final String PROPERTY_TYPEOFBUDGET = "typeOfBudget";
    public static final String PROPERTY_YEAR = "year";
    public static final String PROPERTY_RESOLUTION = "resolution";
    public static final String PROPERTY_REGISTRATIONDATE = "registrationDate";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_AREA = "area";
    public static final String PROPERTY_COSTCENTER = "costCenter";
    public static final String PROPERTY_STDIMENSION = "stDimension";
    public static final String PROPERTY_EXCHANGEDIFFERENCEBUDGETITEM = "exchangeDifferenceBudgetItem";
    public static final String PROPERTY_AVAILABLEVALUE = "availableValue";
    public static final String PROPERTY_VALUETOADJUST = "valueToAdjust";
    public static final String PROPERTY_COMMENTMARITIME = "commentMaritime";
    public static final String PROPERTY_VALUEDISCOUNTED = "valueDiscounted";
    public static final String PROPERTY_VALUEINCREASE = "valueIncrease";
    public static final String PROPERTY_ALERTSTATUS = "alertStatus";
    public static final String PROPERTY_SUMMARYLEVEL = "summaryLevel";
    public static final String PROPERTY_ACTIONBUTTON = "actionbutton";
    public static final String PROPERTY_ACTIONBUTTONDES = "actionbuttondes";
    public static final String PROPERTY_BUDGETLINE = "budgetLine";
    public static final String PROPERTY_SFBTRTRANSFERFROMLIST = "sfbtrTransferFromList";
    public static final String PROPERTY_SFBTRTRANSFERTOLIST = "sfbtrTransferToList";

    public SfbtrBudgetaryReforms() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_ALERTSTATUS, "DR");
        setDefaultValue(PROPERTY_SUMMARYLEVEL, false);
        setDefaultValue(PROPERTY_ACTIONBUTTON, "ND");
        setDefaultValue(PROPERTY_ACTIONBUTTONDES, false);
        setDefaultValue(PROPERTY_SFBTRTRANSFERFROMLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBTRTRANSFERTOLIST, new ArrayList<Object>());
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

    public String getBankStatementType() {
        return (String) get(PROPERTY_BANKSTATEMENTTYPE);
    }

    public void setBankStatementType(String bankStatementType) {
        set(PROPERTY_BANKSTATEMENTTYPE, bankStatementType);
    }

    public String getTypeOfBudget() {
        return (String) get(PROPERTY_TYPEOFBUDGET);
    }

    public void setTypeOfBudget(String typeOfBudget) {
        set(PROPERTY_TYPEOFBUDGET, typeOfBudget);
    }

    public Year getYear() {
        return (Year) get(PROPERTY_YEAR);
    }

    public void setYear(Year year) {
        set(PROPERTY_YEAR, year);
    }

    public String getResolution() {
        return (String) get(PROPERTY_RESOLUTION);
    }

    public void setResolution(String resolution) {
        set(PROPERTY_RESOLUTION, resolution);
    }

    public Date getRegistrationDate() {
        return (Date) get(PROPERTY_REGISTRATIONDATE);
    }

    public void setRegistrationDate(Date registrationDate) {
        set(PROPERTY_REGISTRATIONDATE, registrationDate);
    }

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
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

    public BigDecimal getAvailableValue() {
        return (BigDecimal) get(PROPERTY_AVAILABLEVALUE);
    }

    public void setAvailableValue(BigDecimal availableValue) {
        set(PROPERTY_AVAILABLEVALUE, availableValue);
    }

    public BigDecimal getValueToAdjust() {
        return (BigDecimal) get(PROPERTY_VALUETOADJUST);
    }

    public void setValueToAdjust(BigDecimal valueToAdjust) {
        set(PROPERTY_VALUETOADJUST, valueToAdjust);
    }

    public String getCommentMaritime() {
        return (String) get(PROPERTY_COMMENTMARITIME);
    }

    public void setCommentMaritime(String commentMaritime) {
        set(PROPERTY_COMMENTMARITIME, commentMaritime);
    }

    public BigDecimal getValueDiscounted() {
        return (BigDecimal) get(PROPERTY_VALUEDISCOUNTED);
    }

    public void setValueDiscounted(BigDecimal valueDiscounted) {
        set(PROPERTY_VALUEDISCOUNTED, valueDiscounted);
    }

    public BigDecimal getValueIncrease() {
        return (BigDecimal) get(PROPERTY_VALUEINCREASE);
    }

    public void setValueIncrease(BigDecimal valueIncrease) {
        set(PROPERTY_VALUEINCREASE, valueIncrease);
    }

    public String getAlertStatus() {
        return (String) get(PROPERTY_ALERTSTATUS);
    }

    public void setAlertStatus(String alertStatus) {
        set(PROPERTY_ALERTSTATUS, alertStatus);
    }

    public Boolean isSummaryLevel() {
        return (Boolean) get(PROPERTY_SUMMARYLEVEL);
    }

    public void setSummaryLevel(Boolean summaryLevel) {
        set(PROPERTY_SUMMARYLEVEL, summaryLevel);
    }

    public String getActionbutton() {
        return (String) get(PROPERTY_ACTIONBUTTON);
    }

    public void setActionbutton(String actionbutton) {
        set(PROPERTY_ACTIONBUTTON, actionbutton);
    }

    public Boolean isActionbuttondes() {
        return (Boolean) get(PROPERTY_ACTIONBUTTONDES);
    }

    public void setActionbuttondes(Boolean actionbuttondes) {
        set(PROPERTY_ACTIONBUTTONDES, actionbuttondes);
    }

    public SFBBudgetLine getBudgetLine() {
        return (SFBBudgetLine) get(PROPERTY_BUDGETLINE);
    }

    public void setBudgetLine(SFBBudgetLine budgetLine) {
        set(PROPERTY_BUDGETLINE, budgetLine);
    }

    @SuppressWarnings("unchecked")
    public List<SfbtrTransferFrom> getSfbtrTransferFromList() {
      return (List<SfbtrTransferFrom>) get(PROPERTY_SFBTRTRANSFERFROMLIST);
    }

    public void setSfbtrTransferFromList(List<SfbtrTransferFrom> sfbtrTransferFromList) {
        set(PROPERTY_SFBTRTRANSFERFROMLIST, sfbtrTransferFromList);
    }

    @SuppressWarnings("unchecked")
    public List<SfbtrTransferTo> getSfbtrTransferToList() {
      return (List<SfbtrTransferTo>) get(PROPERTY_SFBTRTRANSFERTOLIST);
    }

    public void setSfbtrTransferToList(List<SfbtrTransferTo> sfbtrTransferToList) {
        set(PROPERTY_SFBTRTRANSFERTOLIST, sfbtrTransferToList);
    }

}
