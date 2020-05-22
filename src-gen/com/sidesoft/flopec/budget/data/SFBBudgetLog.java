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
package com.sidesoft.flopec.budget.data;

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
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.accounting.UserDimension1;
import org.openbravo.model.financialmgmt.calendar.Year;
/**
 * Entity class for entity sfb_budget_log (stored in table sfb_budget_log).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SFBBudgetLog extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sfb_budget_log";
    public static final String ENTITY_NAME = "sfb_budget_log";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_TYPE = "type";
    public static final String PROPERTY_BUDGETITEMFROM = "budgetItemFrom";
    public static final String PROPERTY_BUDGETITEMTO = "budgetItemTo";
    public static final String PROPERTY_FROMMONTH = "fromMonth";
    public static final String PROPERTY_TOMONTH = "toMonth";
    public static final String PROPERTY_VALUE = "value";
    public static final String PROPERTY_REGDATE = "rEGDate";
    public static final String PROPERTY_ALERTSTATUS = "alertStatus";
    public static final String PROPERTY_RESOLUTIONNO = "resolutionno";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_TYPEOFBUDGET = "typeOfBudget";
    public static final String PROPERTY_YEAR = "year";
    public static final String PROPERTY_AREA = "area";
    public static final String PROPERTY_PROCESS = "process";
    public static final String PROPERTY_COSTCENTER = "costCenter";
    public static final String PROPERTY_STDIMENSION = "stDimension";
    public static final String PROPERTY_TYPEOFOPERATION = "typeOfOperation";
    public static final String PROPERTY_AREATO = "areaTo";
    public static final String PROPERTY_COSTCENTERTO = "costCenterTo";
    public static final String PROPERTY_STDIMENSIONTO = "stDimensionTo";
    public static final String PROPERTY_GETLINES = "getLines";
    public static final String PROPERTY_PROCESSNOW = "processNow";
    public static final String PROPERTY_SFBBUDGETLOGLINELIST = "sFBBudgetLogLineList";
    public static final String PROPERTY_SFBBUDGETLOGVLIST = "sfbBudgetLogVList";

    public SFBBudgetLog() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_VALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_ALERTSTATUS, "DR");
        setDefaultValue(PROPERTY_TYPEOFBUDGET, "O");
        setDefaultValue(PROPERTY_PROCESS, "N");
        setDefaultValue(PROPERTY_TYPEOFOPERATION, "N");
        setDefaultValue(PROPERTY_GETLINES, "N");
        setDefaultValue(PROPERTY_PROCESSNOW, false);
        setDefaultValue(PROPERTY_SFBBUDGETLOGLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETLOGVLIST, new ArrayList<Object>());
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

    public String getType() {
        return (String) get(PROPERTY_TYPE);
    }

    public void setType(String type) {
        set(PROPERTY_TYPE, type);
    }

    public SFBBudgetItem getBudgetItemFrom() {
        return (SFBBudgetItem) get(PROPERTY_BUDGETITEMFROM);
    }

    public void setBudgetItemFrom(SFBBudgetItem budgetItemFrom) {
        set(PROPERTY_BUDGETITEMFROM, budgetItemFrom);
    }

    public SFBBudgetItem getBudgetItemTo() {
        return (SFBBudgetItem) get(PROPERTY_BUDGETITEMTO);
    }

    public void setBudgetItemTo(SFBBudgetItem budgetItemTo) {
        set(PROPERTY_BUDGETITEMTO, budgetItemTo);
    }

    public String getFromMonth() {
        return (String) get(PROPERTY_FROMMONTH);
    }

    public void setFromMonth(String fromMonth) {
        set(PROPERTY_FROMMONTH, fromMonth);
    }

    public String getToMonth() {
        return (String) get(PROPERTY_TOMONTH);
    }

    public void setToMonth(String toMonth) {
        set(PROPERTY_TOMONTH, toMonth);
    }

    public BigDecimal getValue() {
        return (BigDecimal) get(PROPERTY_VALUE);
    }

    public void setValue(BigDecimal value) {
        set(PROPERTY_VALUE, value);
    }

    public Date getREGDate() {
        return (Date) get(PROPERTY_REGDATE);
    }

    public void setREGDate(Date rEGDate) {
        set(PROPERTY_REGDATE, rEGDate);
    }

    public String getAlertStatus() {
        return (String) get(PROPERTY_ALERTSTATUS);
    }

    public void setAlertStatus(String alertStatus) {
        set(PROPERTY_ALERTSTATUS, alertStatus);
    }

    public String getResolutionno() {
        return (String) get(PROPERTY_RESOLUTIONNO);
    }

    public void setResolutionno(String resolutionno) {
        set(PROPERTY_RESOLUTIONNO, resolutionno);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
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

    public SFBBudgetArea getArea() {
        return (SFBBudgetArea) get(PROPERTY_AREA);
    }

    public void setArea(SFBBudgetArea area) {
        set(PROPERTY_AREA, area);
    }

    public String getProcess() {
        return (String) get(PROPERTY_PROCESS);
    }

    public void setProcess(String process) {
        set(PROPERTY_PROCESS, process);
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

    public String getTypeOfOperation() {
        return (String) get(PROPERTY_TYPEOFOPERATION);
    }

    public void setTypeOfOperation(String typeOfOperation) {
        set(PROPERTY_TYPEOFOPERATION, typeOfOperation);
    }

    public SFBBudgetArea getAreaTo() {
        return (SFBBudgetArea) get(PROPERTY_AREATO);
    }

    public void setAreaTo(SFBBudgetArea areaTo) {
        set(PROPERTY_AREATO, areaTo);
    }

    public Costcenter getCostCenterTo() {
        return (Costcenter) get(PROPERTY_COSTCENTERTO);
    }

    public void setCostCenterTo(Costcenter costCenterTo) {
        set(PROPERTY_COSTCENTERTO, costCenterTo);
    }

    public UserDimension1 getStDimensionTo() {
        return (UserDimension1) get(PROPERTY_STDIMENSIONTO);
    }

    public void setStDimensionTo(UserDimension1 stDimensionTo) {
        set(PROPERTY_STDIMENSIONTO, stDimensionTo);
    }

    public String getGetLines() {
        return (String) get(PROPERTY_GETLINES);
    }

    public void setGetLines(String getLines) {
        set(PROPERTY_GETLINES, getLines);
    }

    public Boolean isProcessNow() {
        return (Boolean) get(PROPERTY_PROCESSNOW);
    }

    public void setProcessNow(Boolean processNow) {
        set(PROPERTY_PROCESSNOW, processNow);
    }

    @SuppressWarnings("unchecked")
    public List<SFBBudgetLogLine> getSFBBudgetLogLineList() {
      return (List<SFBBudgetLogLine>) get(PROPERTY_SFBBUDGETLOGLINELIST);
    }

    public void setSFBBudgetLogLineList(List<SFBBudgetLogLine> sFBBudgetLogLineList) {
        set(PROPERTY_SFBBUDGETLOGLINELIST, sFBBudgetLogLineList);
    }

    @SuppressWarnings("unchecked")
    public List<sfb_budget_log_v> getSfbBudgetLogVList() {
      return (List<sfb_budget_log_v>) get(PROPERTY_SFBBUDGETLOGVLIST);
    }

    public void setSfbBudgetLogVList(List<sfb_budget_log_v> sfbBudgetLogVList) {
        set(PROPERTY_SFBBUDGETLOGVLIST, sfbBudgetLogVList);
    }

}
