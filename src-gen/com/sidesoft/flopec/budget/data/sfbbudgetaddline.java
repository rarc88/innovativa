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
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.accounting.UserDimension1;
import org.openbravo.model.financialmgmt.calendar.Year;
/**
 * Entity class for entity sfb_budget_addline (stored in table sfb_budget_addline).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class sfbbudgetaddline extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sfb_budget_addline";
    public static final String ENTITY_NAME = "sfb_budget_addline";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DOCUMENTTYPE = "documentType";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_RESOLUTIONNO = "resolutionNo";
    public static final String PROPERTY_TYPEOFBUDGET = "typeOfBudget";
    public static final String PROPERTY_YEAR = "year";
    public static final String PROPERTY_TRANSACTIONDATE = "transactionDate";
    public static final String PROPERTY_AREA = "area";
    public static final String PROPERTY_COSTCENTER = "costCenter";
    public static final String PROPERTY_STDIMENSION = "stDimension";
    public static final String PROPERTY_EXCHANGEDIFFERENCEBUDGETITEM = "exchangeDifferenceBudgetItem";
    public static final String PROPERTY_ALERTSTATUS = "alertStatus";
    public static final String PROPERTY_COMMENTMARITIME = "commentMaritime";
    public static final String PROPERTY_PROCESS = "process";
    public static final String PROPERTY_REACTIVE = "reactive";
    public static final String PROPERTY_ISTBN = "istbn";
    public static final String PROPERTY_SFBBUDGETLINELIST = "sfbBudgetLineList";

    public sfbbudgetaddline() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_TYPEOFBUDGET, "O");
        setDefaultValue(PROPERTY_ALERTSTATUS, "DR");
        setDefaultValue(PROPERTY_PROCESS, false);
        setDefaultValue(PROPERTY_REACTIVE, false);
        setDefaultValue(PROPERTY_ISTBN, false);
        setDefaultValue(PROPERTY_SFBBUDGETLINELIST, new ArrayList<Object>());
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

    public String getResolutionNo() {
        return (String) get(PROPERTY_RESOLUTIONNO);
    }

    public void setResolutionNo(String resolutionNo) {
        set(PROPERTY_RESOLUTIONNO, resolutionNo);
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

    public Date getTransactionDate() {
        return (Date) get(PROPERTY_TRANSACTIONDATE);
    }

    public void setTransactionDate(Date transactionDate) {
        set(PROPERTY_TRANSACTIONDATE, transactionDate);
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

    public String getAlertStatus() {
        return (String) get(PROPERTY_ALERTSTATUS);
    }

    public void setAlertStatus(String alertStatus) {
        set(PROPERTY_ALERTSTATUS, alertStatus);
    }

    public String getCommentMaritime() {
        return (String) get(PROPERTY_COMMENTMARITIME);
    }

    public void setCommentMaritime(String commentMaritime) {
        set(PROPERTY_COMMENTMARITIME, commentMaritime);
    }

    public Boolean isProcess() {
        return (Boolean) get(PROPERTY_PROCESS);
    }

    public void setProcess(Boolean process) {
        set(PROPERTY_PROCESS, process);
    }

    public Boolean isReactive() {
        return (Boolean) get(PROPERTY_REACTIVE);
    }

    public void setReactive(Boolean reactive) {
        set(PROPERTY_REACTIVE, reactive);
    }

    public Boolean isTbn() {
        return (Boolean) get(PROPERTY_ISTBN);
    }

    public void setTbn(Boolean istbn) {
        set(PROPERTY_ISTBN, istbn);
    }

    @SuppressWarnings("unchecked")
    public List<SFBBudgetLine> getSfbBudgetLineList() {
      return (List<SFBBudgetLine>) get(PROPERTY_SFBBUDGETLINELIST);
    }

    public void setSfbBudgetLineList(List<SFBBudgetLine> sfbBudgetLineList) {
        set(PROPERTY_SFBBUDGETLINELIST, sfbBudgetLineList);
    }

}
