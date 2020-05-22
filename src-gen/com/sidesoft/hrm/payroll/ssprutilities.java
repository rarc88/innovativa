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
import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.calendar.Year;
/**
 * Entity class for entity sspr_utilities (stored in table sspr_utilities).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ssprutilities extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sspr_utilities";
    public static final String ENTITY_NAME = "sspr_utilities";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_EMPLOYEE = "employee";
    public static final String PROPERTY_YEAR = "year";
    public static final String PROPERTY_AVERAGEINCOME = "averageIncome";
    public static final String PROPERTY_LIVINGWAGE = "livingWage";
    public static final String PROPERTY_WAGECOMPENSATION = "wageCompensation";
    public static final String PROPERTY_VALUE10 = "value10";
    public static final String PROPERTY_VALUE5 = "value5";
    public static final String PROPERTY_TOTALPROFITS = "totalProfits";
    public static final String PROPERTY_NUMBERCHARGES = "numberCharges";
    public static final String PROPERTY_WORKINGDAYS = "workingDays";
    public static final String PROPERTY_WORKEDDAYS = "workedDays";
    public static final String PROPERTY_JUDICIALRETENTION = "judicialRetention";
    public static final String PROPERTY_SSPRSUPPLEMENTARYDATA = "ssprSupplementaryData";
    public static final String PROPERTY_CONCEPTFORMULARY = "conceptFormulary";

    public ssprutilities() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_AVERAGEINCOME, new BigDecimal(0));
        setDefaultValue(PROPERTY_LIVINGWAGE, new BigDecimal(0));
        setDefaultValue(PROPERTY_WAGECOMPENSATION, new BigDecimal(0));
        setDefaultValue(PROPERTY_VALUE10, new BigDecimal(0));
        setDefaultValue(PROPERTY_VALUE5, new BigDecimal(0));
        setDefaultValue(PROPERTY_TOTALPROFITS, new BigDecimal(0));
        setDefaultValue(PROPERTY_NUMBERCHARGES, new BigDecimal(0));
        setDefaultValue(PROPERTY_WORKINGDAYS, new BigDecimal(0));
        setDefaultValue(PROPERTY_WORKEDDAYS, new BigDecimal(0));
        setDefaultValue(PROPERTY_JUDICIALRETENTION, new BigDecimal(0));
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

    public BusinessPartner getEmployee() {
        return (BusinessPartner) get(PROPERTY_EMPLOYEE);
    }

    public void setEmployee(BusinessPartner employee) {
        set(PROPERTY_EMPLOYEE, employee);
    }

    public Year getYear() {
        return (Year) get(PROPERTY_YEAR);
    }

    public void setYear(Year year) {
        set(PROPERTY_YEAR, year);
    }

    public BigDecimal getAverageIncome() {
        return (BigDecimal) get(PROPERTY_AVERAGEINCOME);
    }

    public void setAverageIncome(BigDecimal averageIncome) {
        set(PROPERTY_AVERAGEINCOME, averageIncome);
    }

    public BigDecimal getLivingWage() {
        return (BigDecimal) get(PROPERTY_LIVINGWAGE);
    }

    public void setLivingWage(BigDecimal livingWage) {
        set(PROPERTY_LIVINGWAGE, livingWage);
    }

    public BigDecimal getWageCompensation() {
        return (BigDecimal) get(PROPERTY_WAGECOMPENSATION);
    }

    public void setWageCompensation(BigDecimal wageCompensation) {
        set(PROPERTY_WAGECOMPENSATION, wageCompensation);
    }

    public BigDecimal getValue10() {
        return (BigDecimal) get(PROPERTY_VALUE10);
    }

    public void setValue10(BigDecimal value10) {
        set(PROPERTY_VALUE10, value10);
    }

    public BigDecimal getValue5() {
        return (BigDecimal) get(PROPERTY_VALUE5);
    }

    public void setValue5(BigDecimal value5) {
        set(PROPERTY_VALUE5, value5);
    }

    public BigDecimal getTotalProfits() {
        return (BigDecimal) get(PROPERTY_TOTALPROFITS);
    }

    public void setTotalProfits(BigDecimal totalProfits) {
        set(PROPERTY_TOTALPROFITS, totalProfits);
    }

    public BigDecimal getNumberCharges() {
        return (BigDecimal) get(PROPERTY_NUMBERCHARGES);
    }

    public void setNumberCharges(BigDecimal numberCharges) {
        set(PROPERTY_NUMBERCHARGES, numberCharges);
    }

    public BigDecimal getWorkingDays() {
        return (BigDecimal) get(PROPERTY_WORKINGDAYS);
    }

    public void setWorkingDays(BigDecimal workingDays) {
        set(PROPERTY_WORKINGDAYS, workingDays);
    }

    public BigDecimal getWorkedDays() {
        return (BigDecimal) get(PROPERTY_WORKEDDAYS);
    }

    public void setWorkedDays(BigDecimal workedDays) {
        set(PROPERTY_WORKEDDAYS, workedDays);
    }

    public BigDecimal getJudicialRetention() {
        return (BigDecimal) get(PROPERTY_JUDICIALRETENTION);
    }

    public void setJudicialRetention(BigDecimal judicialRetention) {
        set(PROPERTY_JUDICIALRETENTION, judicialRetention);
    }

    public SsprSupplementaryData getSsprSupplementaryData() {
        return (SsprSupplementaryData) get(PROPERTY_SSPRSUPPLEMENTARYDATA);
    }

    public void setSsprSupplementaryData(SsprSupplementaryData ssprSupplementaryData) {
        set(PROPERTY_SSPRSUPPLEMENTARYDATA, ssprSupplementaryData);
    }

    public ssprcodeformulary107 getConceptFormulary() {
        return (ssprcodeformulary107) get(PROPERTY_CONCEPTFORMULARY);
    }

    public void setConceptFormulary(ssprcodeformulary107 conceptFormulary) {
        set(PROPERTY_CONCEPTFORMULARY, conceptFormulary);
    }

}
