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
package com.sidesoft.hrm.payroll;

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
/**
 * Entity class for entity sspr_vacations (stored in table sspr_vacations).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ssprvacations extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sspr_vacations";
    public static final String ENTITY_NAME = "sspr_vacations";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_ENTRYDATE = "entrydate";
    public static final String PROPERTY_ENDDATE = "endDate";
    public static final String PROPERTY_NODAYS = "nodays";
    public static final String PROPERTY_NODAYSTOMADOS = "nodaystomados";
    public static final String PROPERTY_NODAYSPENDING = "nodayspending";
    public static final String PROPERTY_NODAYSTOTAL = "nodaystotal";
    public static final String PROPERTY_CONCEPT = "concept";
    public static final String PROPERTY_ALERTSTATUS = "alertStatus";
    public static final String PROPERTY_VACATIONSVALUE = "vacationsvalue";
    public static final String PROPERTY_TOTALVALUE = "totalvalue";
    public static final String PROPERTY_DAYVALUE = "dayvalue";
    public static final String PROPERTY_CANCELLIQUIDATION = "cancelliquidation";
    public static final String PROPERTY_NODAYSTOTALLIQ = "nodaystotalLiq";
    public static final String PROPERTY_STARTINGBALANCE = "startingbalance";
    public static final String PROPERTY_NOADDITIONALDAYS = "noadditionaldays";
    public static final String PROPERTY_NOADDITIONALTOMADOS = "noadditionaltomados";
    public static final String PROPERTY_NOADDITIONALTOTAL = "noadditionaltotal";
    public static final String PROPERTY_NODAYSVACATIONS = "nodaysvacations";
    public static final String PROPERTY_SSPRSETTLEMENT = "ssprSettlement";
    public static final String PROPERTY_CONTRACT = "contract";
    public static final String PROPERTY_COMPLETEDAYS = "completeDays";
    public static final String PROPERTY_EARNEDDAYS = "earneddays";
    public static final String PROPERTY_EARNEDDAYSADD = "earneddaysAdd";
    public static final String PROPERTY_EARNEDDAYSTOT = "earneddaysTot";
    public static final String PROPERTY_UPLOADEDSCRIPT = "uploadedscript";
    public static final String PROPERTY_SSPRVACATIONSINIBAL = "ssprVacationsinibal";
    public static final String PROPERTY_SSPRLEAVEEMPVACLIST = "ssprLeaveEmpVacList";
    public static final String PROPERTY_SSPRVACATIONSSSPRVACATIONSINIBALIDLIST = "ssprVacationsSsprVacationsinibalIDList";

    public ssprvacations() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_CANCELLIQUIDATION, false);
        setDefaultValue(PROPERTY_NODAYSTOTALLIQ, new BigDecimal(0));
        setDefaultValue(PROPERTY_STARTINGBALANCE, true);
        setDefaultValue(PROPERTY_NOADDITIONALDAYS, new BigDecimal(0));
        setDefaultValue(PROPERTY_NOADDITIONALTOMADOS, new BigDecimal(0));
        setDefaultValue(PROPERTY_NOADDITIONALTOTAL, new BigDecimal(0));
        setDefaultValue(PROPERTY_NODAYSVACATIONS, new BigDecimal(0));
        setDefaultValue(PROPERTY_COMPLETEDAYS, false);
        setDefaultValue(PROPERTY_EARNEDDAYS, new BigDecimal(0));
        setDefaultValue(PROPERTY_EARNEDDAYSADD, new BigDecimal(0));
        setDefaultValue(PROPERTY_EARNEDDAYSTOT, new BigDecimal(0));
        setDefaultValue(PROPERTY_UPLOADEDSCRIPT, false);
        setDefaultValue(PROPERTY_SSPRLEAVEEMPVACLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRVACATIONSSSPRVACATIONSINIBALIDLIST, new ArrayList<Object>());
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

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public Date getEntrydate() {
        return (Date) get(PROPERTY_ENTRYDATE);
    }

    public void setEntrydate(Date entrydate) {
        set(PROPERTY_ENTRYDATE, entrydate);
    }

    public Date getEndDate() {
        return (Date) get(PROPERTY_ENDDATE);
    }

    public void setEndDate(Date endDate) {
        set(PROPERTY_ENDDATE, endDate);
    }

    public BigDecimal getNodays() {
        return (BigDecimal) get(PROPERTY_NODAYS);
    }

    public void setNodays(BigDecimal nodays) {
        set(PROPERTY_NODAYS, nodays);
    }

    public BigDecimal getNodaystomados() {
        return (BigDecimal) get(PROPERTY_NODAYSTOMADOS);
    }

    public void setNodaystomados(BigDecimal nodaystomados) {
        set(PROPERTY_NODAYSTOMADOS, nodaystomados);
    }

    public BigDecimal getNodayspending() {
        return (BigDecimal) get(PROPERTY_NODAYSPENDING);
    }

    public void setNodayspending(BigDecimal nodayspending) {
        set(PROPERTY_NODAYSPENDING, nodayspending);
    }

    public BigDecimal getNodaystotal() {
        return (BigDecimal) get(PROPERTY_NODAYSTOTAL);
    }

    public void setNodaystotal(BigDecimal nodaystotal) {
        set(PROPERTY_NODAYSTOTAL, nodaystotal);
    }

    public Concept getConcept() {
        return (Concept) get(PROPERTY_CONCEPT);
    }

    public void setConcept(Concept concept) {
        set(PROPERTY_CONCEPT, concept);
    }

    public String getAlertStatus() {
        return (String) get(PROPERTY_ALERTSTATUS);
    }

    public void setAlertStatus(String alertStatus) {
        set(PROPERTY_ALERTSTATUS, alertStatus);
    }

    public BigDecimal getVacationsvalue() {
        return (BigDecimal) get(PROPERTY_VACATIONSVALUE);
    }

    public void setVacationsvalue(BigDecimal vacationsvalue) {
        set(PROPERTY_VACATIONSVALUE, vacationsvalue);
    }

    public BigDecimal getTotalvalue() {
        return (BigDecimal) get(PROPERTY_TOTALVALUE);
    }

    public void setTotalvalue(BigDecimal totalvalue) {
        set(PROPERTY_TOTALVALUE, totalvalue);
    }

    public BigDecimal getDayvalue() {
        return (BigDecimal) get(PROPERTY_DAYVALUE);
    }

    public void setDayvalue(BigDecimal dayvalue) {
        set(PROPERTY_DAYVALUE, dayvalue);
    }

    public Boolean isCancelliquidation() {
        return (Boolean) get(PROPERTY_CANCELLIQUIDATION);
    }

    public void setCancelliquidation(Boolean cancelliquidation) {
        set(PROPERTY_CANCELLIQUIDATION, cancelliquidation);
    }

    public BigDecimal getNodaystotalLiq() {
        return (BigDecimal) get(PROPERTY_NODAYSTOTALLIQ);
    }

    public void setNodaystotalLiq(BigDecimal nodaystotalLiq) {
        set(PROPERTY_NODAYSTOTALLIQ, nodaystotalLiq);
    }

    public Boolean isStartingbalance() {
        return (Boolean) get(PROPERTY_STARTINGBALANCE);
    }

    public void setStartingbalance(Boolean startingbalance) {
        set(PROPERTY_STARTINGBALANCE, startingbalance);
    }

    public BigDecimal getNoadditionaldays() {
        return (BigDecimal) get(PROPERTY_NOADDITIONALDAYS);
    }

    public void setNoadditionaldays(BigDecimal noadditionaldays) {
        set(PROPERTY_NOADDITIONALDAYS, noadditionaldays);
    }

    public BigDecimal getNoadditionaltomados() {
        return (BigDecimal) get(PROPERTY_NOADDITIONALTOMADOS);
    }

    public void setNoadditionaltomados(BigDecimal noadditionaltomados) {
        set(PROPERTY_NOADDITIONALTOMADOS, noadditionaltomados);
    }

    public BigDecimal getNoadditionaltotal() {
        return (BigDecimal) get(PROPERTY_NOADDITIONALTOTAL);
    }

    public void setNoadditionaltotal(BigDecimal noadditionaltotal) {
        set(PROPERTY_NOADDITIONALTOTAL, noadditionaltotal);
    }

    public BigDecimal getNodaysvacations() {
        return (BigDecimal) get(PROPERTY_NODAYSVACATIONS);
    }

    public void setNodaysvacations(BigDecimal nodaysvacations) {
        set(PROPERTY_NODAYSVACATIONS, nodaysvacations);
    }

    public sspr_settlement getSsprSettlement() {
        return (sspr_settlement) get(PROPERTY_SSPRSETTLEMENT);
    }

    public void setSsprSettlement(sspr_settlement ssprSettlement) {
        set(PROPERTY_SSPRSETTLEMENT, ssprSettlement);
    }

    public Contract getContract() {
        return (Contract) get(PROPERTY_CONTRACT);
    }

    public void setContract(Contract contract) {
        set(PROPERTY_CONTRACT, contract);
    }

    public Boolean isCompleteDays() {
        return (Boolean) get(PROPERTY_COMPLETEDAYS);
    }

    public void setCompleteDays(Boolean completeDays) {
        set(PROPERTY_COMPLETEDAYS, completeDays);
    }

    public BigDecimal getEarneddays() {
        return (BigDecimal) get(PROPERTY_EARNEDDAYS);
    }

    public void setEarneddays(BigDecimal earneddays) {
        set(PROPERTY_EARNEDDAYS, earneddays);
    }

    public BigDecimal getEarneddaysAdd() {
        return (BigDecimal) get(PROPERTY_EARNEDDAYSADD);
    }

    public void setEarneddaysAdd(BigDecimal earneddaysAdd) {
        set(PROPERTY_EARNEDDAYSADD, earneddaysAdd);
    }

    public BigDecimal getEarneddaysTot() {
        return (BigDecimal) get(PROPERTY_EARNEDDAYSTOT);
    }

    public void setEarneddaysTot(BigDecimal earneddaysTot) {
        set(PROPERTY_EARNEDDAYSTOT, earneddaysTot);
    }

    public Boolean isUploadedscript() {
        return (Boolean) get(PROPERTY_UPLOADEDSCRIPT);
    }

    public void setUploadedscript(Boolean uploadedscript) {
        set(PROPERTY_UPLOADEDSCRIPT, uploadedscript);
    }

    public ssprvacations getSsprVacationsinibal() {
        return (ssprvacations) get(PROPERTY_SSPRVACATIONSINIBAL);
    }

    public void setSsprVacationsinibal(ssprvacations ssprVacationsinibal) {
        set(PROPERTY_SSPRVACATIONSINIBAL, ssprVacationsinibal);
    }

    @SuppressWarnings("unchecked")
    public List<sspr_leave_emp_vac> getSsprLeaveEmpVacList() {
      return (List<sspr_leave_emp_vac>) get(PROPERTY_SSPRLEAVEEMPVACLIST);
    }

    public void setSsprLeaveEmpVacList(List<sspr_leave_emp_vac> ssprLeaveEmpVacList) {
        set(PROPERTY_SSPRLEAVEEMPVACLIST, ssprLeaveEmpVacList);
    }

    @SuppressWarnings("unchecked")
    public List<ssprvacations> getSsprVacationsSsprVacationsinibalIDList() {
      return (List<ssprvacations>) get(PROPERTY_SSPRVACATIONSSSPRVACATIONSINIBALIDLIST);
    }

    public void setSsprVacationsSsprVacationsinibalIDList(List<ssprvacations> ssprVacationsSsprVacationsinibalIDList) {
        set(PROPERTY_SSPRVACATIONSSSPRVACATIONSINIBALIDLIST, ssprVacationsSsprVacationsinibalIDList);
    }

}
