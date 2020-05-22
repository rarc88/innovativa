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
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.calendar.Period;
import org.openbravo.model.financialmgmt.calendar.Year;
/**
 * Entity class for entity sspr_configurationutility (stored in table sspr_configurationutility).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SsprConfigurationUtility extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sspr_configurationutility";
    public static final String ENTITY_NAME = "sspr_configurationutility";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_YEAR = "year";
    public static final String PROPERTY_PERCPARTICIPATIONEMPLOYEE = "percParticipationEmployee";
    public static final String PROPERTY_PERCEARNINGSEMPLOYEE = "percEarningsEmployee";
    public static final String PROPERTY_PERCUTILITYLOADS = "percUtilityLoads";
    public static final String PROPERTY_AGELIMITCHILD = "aGELimitChild";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_NETPROFIT = "netprofit";
    public static final String PROPERTY_LIVINGWAGE = "livingwage";
    public static final String PROPERTY_WORKEDDAYSTOTAL = "workeddaystotal";
    public static final String PROPERTY_WAGECOMPENSATIONTOTAL = "wagecompensationtotal";
    public static final String PROPERTY_WORKEDDAYSWAGETOTAL = "workeddayswagetotal";
    public static final String PROPERTY_NUMBERCHARGESTOTAL = "numberchargestotal";
    public static final String PROPERTY_WORKEDDAYSCHARGESTOTAL = "workeddayschargestotal";
    public static final String PROPERTY_PRINTTYPE = "printType";
    public static final String PROPERTY_CHARGESWORKEDTOTAL = "chargesWorkedTotal";
    public static final String PROPERTY_SSPRCODEFORMULARY107 = "ssprCodeformulary107";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_SSPRCONCEPT = "ssprConcept";
    public static final String PROPERTY_PERIOD = "period";

    public SsprConfigurationUtility() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_PERCPARTICIPATIONEMPLOYEE, new BigDecimal(0));
        setDefaultValue(PROPERTY_PERCEARNINGSEMPLOYEE, new BigDecimal(0));
        setDefaultValue(PROPERTY_PERCUTILITYLOADS, new BigDecimal(0));
        setDefaultValue(PROPERTY_NETPROFIT, new BigDecimal(0));
        setDefaultValue(PROPERTY_LIVINGWAGE, new BigDecimal(0));
        setDefaultValue(PROPERTY_WORKEDDAYSTOTAL, new BigDecimal(0));
        setDefaultValue(PROPERTY_WAGECOMPENSATIONTOTAL, new BigDecimal(0));
        setDefaultValue(PROPERTY_WORKEDDAYSWAGETOTAL, new BigDecimal(0));
        setDefaultValue(PROPERTY_NUMBERCHARGESTOTAL, (long) 0);
        setDefaultValue(PROPERTY_WORKEDDAYSCHARGESTOTAL, new BigDecimal(0));
        setDefaultValue(PROPERTY_PRINTTYPE, "NG");
        setDefaultValue(PROPERTY_CHARGESWORKEDTOTAL, new BigDecimal(0));
    }

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
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

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
    }

    public Year getYear() {
        return (Year) get(PROPERTY_YEAR);
    }

    public void setYear(Year year) {
        set(PROPERTY_YEAR, year);
    }

    public BigDecimal getPercParticipationEmployee() {
        return (BigDecimal) get(PROPERTY_PERCPARTICIPATIONEMPLOYEE);
    }

    public void setPercParticipationEmployee(BigDecimal percParticipationEmployee) {
        set(PROPERTY_PERCPARTICIPATIONEMPLOYEE, percParticipationEmployee);
    }

    public BigDecimal getPercEarningsEmployee() {
        return (BigDecimal) get(PROPERTY_PERCEARNINGSEMPLOYEE);
    }

    public void setPercEarningsEmployee(BigDecimal percEarningsEmployee) {
        set(PROPERTY_PERCEARNINGSEMPLOYEE, percEarningsEmployee);
    }

    public BigDecimal getPercUtilityLoads() {
        return (BigDecimal) get(PROPERTY_PERCUTILITYLOADS);
    }

    public void setPercUtilityLoads(BigDecimal percUtilityLoads) {
        set(PROPERTY_PERCUTILITYLOADS, percUtilityLoads);
    }

    public Long getAGELimitChild() {
        return (Long) get(PROPERTY_AGELIMITCHILD);
    }

    public void setAGELimitChild(Long aGELimitChild) {
        set(PROPERTY_AGELIMITCHILD, aGELimitChild);
    }

    public User getUpdatedBy() {
        return (User) get(PROPERTY_UPDATEDBY);
    }

    public void setUpdatedBy(User updatedBy) {
        set(PROPERTY_UPDATEDBY, updatedBy);
    }

    public BigDecimal getNetprofit() {
        return (BigDecimal) get(PROPERTY_NETPROFIT);
    }

    public void setNetprofit(BigDecimal netprofit) {
        set(PROPERTY_NETPROFIT, netprofit);
    }

    public BigDecimal getLivingwage() {
        return (BigDecimal) get(PROPERTY_LIVINGWAGE);
    }

    public void setLivingwage(BigDecimal livingwage) {
        set(PROPERTY_LIVINGWAGE, livingwage);
    }

    public BigDecimal getWorkeddaystotal() {
        return (BigDecimal) get(PROPERTY_WORKEDDAYSTOTAL);
    }

    public void setWorkeddaystotal(BigDecimal workeddaystotal) {
        set(PROPERTY_WORKEDDAYSTOTAL, workeddaystotal);
    }

    public BigDecimal getWagecompensationtotal() {
        return (BigDecimal) get(PROPERTY_WAGECOMPENSATIONTOTAL);
    }

    public void setWagecompensationtotal(BigDecimal wagecompensationtotal) {
        set(PROPERTY_WAGECOMPENSATIONTOTAL, wagecompensationtotal);
    }

    public BigDecimal getWorkeddayswagetotal() {
        return (BigDecimal) get(PROPERTY_WORKEDDAYSWAGETOTAL);
    }

    public void setWorkeddayswagetotal(BigDecimal workeddayswagetotal) {
        set(PROPERTY_WORKEDDAYSWAGETOTAL, workeddayswagetotal);
    }

    public Long getNumberchargestotal() {
        return (Long) get(PROPERTY_NUMBERCHARGESTOTAL);
    }

    public void setNumberchargestotal(Long numberchargestotal) {
        set(PROPERTY_NUMBERCHARGESTOTAL, numberchargestotal);
    }

    public BigDecimal getWorkeddayschargestotal() {
        return (BigDecimal) get(PROPERTY_WORKEDDAYSCHARGESTOTAL);
    }

    public void setWorkeddayschargestotal(BigDecimal workeddayschargestotal) {
        set(PROPERTY_WORKEDDAYSCHARGESTOTAL, workeddayschargestotal);
    }

    public String getPrintType() {
        return (String) get(PROPERTY_PRINTTYPE);
    }

    public void setPrintType(String printType) {
        set(PROPERTY_PRINTTYPE, printType);
    }

    public BigDecimal getChargesWorkedTotal() {
        return (BigDecimal) get(PROPERTY_CHARGESWORKEDTOTAL);
    }

    public void setChargesWorkedTotal(BigDecimal chargesWorkedTotal) {
        set(PROPERTY_CHARGESWORKEDTOTAL, chargesWorkedTotal);
    }

    public ssprcodeformulary107 getSsprCodeformulary107() {
        return (ssprcodeformulary107) get(PROPERTY_SSPRCODEFORMULARY107);
    }

    public void setSsprCodeformulary107(ssprcodeformulary107 ssprCodeformulary107) {
        set(PROPERTY_SSPRCODEFORMULARY107, ssprCodeformulary107);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Concept getSsprConcept() {
        return (Concept) get(PROPERTY_SSPRCONCEPT);
    }

    public void setSsprConcept(Concept ssprConcept) {
        set(PROPERTY_SSPRCONCEPT, ssprConcept);
    }

    public Period getPeriod() {
        return (Period) get(PROPERTY_PERIOD);
    }

    public void setPeriod(Period period) {
        set(PROPERTY_PERIOD, period);
    }

}
