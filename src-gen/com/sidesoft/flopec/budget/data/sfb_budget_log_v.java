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
 * Entity class for entity sfb_budget_log_v (stored in table sfb_budget_log_v).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class sfb_budget_log_v extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sfb_budget_log_v";
    public static final String ENTITY_NAME = "sfb_budget_log_v";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_AREA = "area";
    public static final String PROPERTY_AREA9 = "area9";
    public static final String PROPERTY_BUQUE = "buque";
    public static final String PROPERTY_BUQUE11 = "buque11";
    public static final String PROPERTY_LINEANEGOCIO = "lineaNegocio";
    public static final String PROPERTY_LINEANEGOCIO13 = "lineaNegocio13";
    public static final String PROPERTY_ITEMFROM = "itemFrom";
    public static final String PROPERTY_ITEMFROM15 = "itemFrom15";
    public static final String PROPERTY_ITEMTO = "itemTo";
    public static final String PROPERTY_ITEMTO17 = "itemTo17";
    public static final String PROPERTY_PRESUPUESTO = "presupuesto";
    public static final String PROPERTY_LINEAPRESUPUESTO = "lineaPresupuesto";
    public static final String PROPERTY_BUDGETLOG = "budgetLog";
    public static final String PROPERTY_TYPE = "type";
    public static final String PROPERTY_RESOLUTIONNO = "resolutionNo";
    public static final String PROPERTY_FROMMONTH = "fromMonth";
    public static final String PROPERTY_TOMONTH = "toMonth";
    public static final String PROPERTY_BUDGETLOGSTATUS = "budgetLogStatus";
    public static final String PROPERTY_AMOUNT = "amount";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_TYPEOFOPERATION = "typeOfOperation";
    public static final String PROPERTY_REGISTRATIONDATE = "registrationDate";

    public sfb_budget_log_v() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_BUDGETLOGSTATUS, false);
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

    public Organization getOrganization() {
        return (Organization) get(PROPERTY_ORGANIZATION);
    }

    public void setOrganization(Organization organization) {
        set(PROPERTY_ORGANIZATION, organization);
    }

    public Client getClient() {
        return (Client) get(PROPERTY_CLIENT);
    }

    public void setClient(Client client) {
        set(PROPERTY_CLIENT, client);
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

    public User getUpdatedBy() {
        return (User) get(PROPERTY_UPDATEDBY);
    }

    public void setUpdatedBy(User updatedBy) {
        set(PROPERTY_UPDATEDBY, updatedBy);
    }

    public Date getUpdated() {
        return (Date) get(PROPERTY_UPDATED);
    }

    public void setUpdated(Date updated) {
        set(PROPERTY_UPDATED, updated);
    }

    public Boolean isActive() {
        return (Boolean) get(PROPERTY_ACTIVE);
    }

    public void setActive(Boolean active) {
        set(PROPERTY_ACTIVE, active);
    }

    public SFBBudgetArea getArea() {
        return (SFBBudgetArea) get(PROPERTY_AREA);
    }

    public void setArea(SFBBudgetArea area) {
        set(PROPERTY_AREA, area);
    }

    public String getArea9() {
        return (String) get(PROPERTY_AREA9);
    }

    public void setArea9(String area9) {
        set(PROPERTY_AREA9, area9);
    }

    public Costcenter getBuque() {
        return (Costcenter) get(PROPERTY_BUQUE);
    }

    public void setBuque(Costcenter buque) {
        set(PROPERTY_BUQUE, buque);
    }

    public String getBuque11() {
        return (String) get(PROPERTY_BUQUE11);
    }

    public void setBuque11(String buque11) {
        set(PROPERTY_BUQUE11, buque11);
    }

    public UserDimension1 getLineaNegocio() {
        return (UserDimension1) get(PROPERTY_LINEANEGOCIO);
    }

    public void setLineaNegocio(UserDimension1 lineaNegocio) {
        set(PROPERTY_LINEANEGOCIO, lineaNegocio);
    }

    public String getLineaNegocio13() {
        return (String) get(PROPERTY_LINEANEGOCIO13);
    }

    public void setLineaNegocio13(String lineaNegocio13) {
        set(PROPERTY_LINEANEGOCIO13, lineaNegocio13);
    }

    public SFBBudgetItem getItemFrom() {
        return (SFBBudgetItem) get(PROPERTY_ITEMFROM);
    }

    public void setItemFrom(SFBBudgetItem itemFrom) {
        set(PROPERTY_ITEMFROM, itemFrom);
    }

    public String getItemFrom15() {
        return (String) get(PROPERTY_ITEMFROM15);
    }

    public void setItemFrom15(String itemFrom15) {
        set(PROPERTY_ITEMFROM15, itemFrom15);
    }

    public SFBBudgetItem getItemTo() {
        return (SFBBudgetItem) get(PROPERTY_ITEMTO);
    }

    public void setItemTo(SFBBudgetItem itemTo) {
        set(PROPERTY_ITEMTO, itemTo);
    }

    public String getItemTo17() {
        return (String) get(PROPERTY_ITEMTO17);
    }

    public void setItemTo17(String itemTo17) {
        set(PROPERTY_ITEMTO17, itemTo17);
    }

    public SFBBudgetLine getPresupuesto() {
        return (SFBBudgetLine) get(PROPERTY_PRESUPUESTO);
    }

    public void setPresupuesto(SFBBudgetLine presupuesto) {
        set(PROPERTY_PRESUPUESTO, presupuesto);
    }

    public Long getLineaPresupuesto() {
        return (Long) get(PROPERTY_LINEAPRESUPUESTO);
    }

    public void setLineaPresupuesto(Long lineaPresupuesto) {
        set(PROPERTY_LINEAPRESUPUESTO, lineaPresupuesto);
    }

    public SFBBudgetLog getBudgetLog() {
        return (SFBBudgetLog) get(PROPERTY_BUDGETLOG);
    }

    public void setBudgetLog(SFBBudgetLog budgetLog) {
        set(PROPERTY_BUDGETLOG, budgetLog);
    }

    public String getType() {
        return (String) get(PROPERTY_TYPE);
    }

    public void setType(String type) {
        set(PROPERTY_TYPE, type);
    }

    public String getResolutionNo() {
        return (String) get(PROPERTY_RESOLUTIONNO);
    }

    public void setResolutionNo(String resolutionNo) {
        set(PROPERTY_RESOLUTIONNO, resolutionNo);
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

    public Boolean isBudgetLogStatus() {
        return (Boolean) get(PROPERTY_BUDGETLOGSTATUS);
    }

    public void setBudgetLogStatus(Boolean budgetLogStatus) {
        set(PROPERTY_BUDGETLOGSTATUS, budgetLogStatus);
    }

    public BigDecimal getAmount() {
        return (BigDecimal) get(PROPERTY_AMOUNT);
    }

    public void setAmount(BigDecimal amount) {
        set(PROPERTY_AMOUNT, amount);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public String getTypeOfOperation() {
        return (String) get(PROPERTY_TYPEOFOPERATION);
    }

    public void setTypeOfOperation(String typeOfOperation) {
        set(PROPERTY_TYPEOFOPERATION, typeOfOperation);
    }

    public Date getRegistrationDate() {
        return (Date) get(PROPERTY_REGISTRATIONDATE);
    }

    public void setRegistrationDate(Date registrationDate) {
        set(PROPERTY_REGISTRATIONDATE, registrationDate);
    }

}
