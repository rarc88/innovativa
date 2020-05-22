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
import org.openbravo.model.financialmgmt.calendar.Period;
import org.openbravo.model.financialmgmt.calendar.Year;
/**
 * Entity class for entity sspr_cumulativeconcept (stored in table sspr_cumulativeconcept).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class CumulativeConcept extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sspr_cumulativeconcept";
    public static final String ENTITY_NAME = "sspr_cumulativeconcept";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_BUSINESSCONCEPT = "businessConcept";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_PERIOD = "period";
    public static final String PROPERTY_AMOUNTCONCEPT = "amountConcept";
    public static final String PROPERTY_PERIODNO = "periodNo";
    public static final String PROPERTY_YEAR = "year";
    public static final String PROPERTY_TOTALPERIOD = "totalPeriod";
    public static final String PROPERTY_ACUMULATIVE = "acumulative";
    public static final String PROPERTY_AMOUNTPROJECTED = "amountProjected";
    public static final String PROPERTY_ISCUMULATIVE = "iscumulative";
    public static final String PROPERTY_ISPROJECTED = "isProjected";
    public static final String PROPERTY_ISAFFECTIONMONTHLY = "isaffectionmonthly";
    public static final String PROPERTY_CONCEPTSUBTYPE = "conceptsubtype";
    public static final String PROPERTY_ISIESS = "isIess";
    public static final String PROPERTY_LIQUIDATION = "liquidation";

    public CumulativeConcept() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_ISCUMULATIVE, false);
        setDefaultValue(PROPERTY_ISPROJECTED, false);
        setDefaultValue(PROPERTY_ISAFFECTIONMONTHLY, false);
        setDefaultValue(PROPERTY_ISIESS, false);
        setDefaultValue(PROPERTY_LIQUIDATION, false);
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

    public Concept getBusinessConcept() {
        return (Concept) get(PROPERTY_BUSINESSCONCEPT);
    }

    public void setBusinessConcept(Concept businessConcept) {
        set(PROPERTY_BUSINESSCONCEPT, businessConcept);
    }

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public Period getPeriod() {
        return (Period) get(PROPERTY_PERIOD);
    }

    public void setPeriod(Period period) {
        set(PROPERTY_PERIOD, period);
    }

    public Long getAmountConcept() {
        return (Long) get(PROPERTY_AMOUNTCONCEPT);
    }

    public void setAmountConcept(Long amountConcept) {
        set(PROPERTY_AMOUNTCONCEPT, amountConcept);
    }

    public Long getPeriodNo() {
        return (Long) get(PROPERTY_PERIODNO);
    }

    public void setPeriodNo(Long periodNo) {
        set(PROPERTY_PERIODNO, periodNo);
    }

    public Year getYear() {
        return (Year) get(PROPERTY_YEAR);
    }

    public void setYear(Year year) {
        set(PROPERTY_YEAR, year);
    }

    public Long getTotalPeriod() {
        return (Long) get(PROPERTY_TOTALPERIOD);
    }

    public void setTotalPeriod(Long totalPeriod) {
        set(PROPERTY_TOTALPERIOD, totalPeriod);
    }

    public Long getAcumulative() {
        return (Long) get(PROPERTY_ACUMULATIVE);
    }

    public void setAcumulative(Long acumulative) {
        set(PROPERTY_ACUMULATIVE, acumulative);
    }

    public Long getAmountProjected() {
        return (Long) get(PROPERTY_AMOUNTPROJECTED);
    }

    public void setAmountProjected(Long amountProjected) {
        set(PROPERTY_AMOUNTPROJECTED, amountProjected);
    }

    public Boolean isCumulative() {
        return (Boolean) get(PROPERTY_ISCUMULATIVE);
    }

    public void setCumulative(Boolean iscumulative) {
        set(PROPERTY_ISCUMULATIVE, iscumulative);
    }

    public Boolean isProjected() {
        return (Boolean) get(PROPERTY_ISPROJECTED);
    }

    public void setProjected(Boolean isProjected) {
        set(PROPERTY_ISPROJECTED, isProjected);
    }

    public Boolean isAffectionmonthly() {
        return (Boolean) get(PROPERTY_ISAFFECTIONMONTHLY);
    }

    public void setAffectionmonthly(Boolean isaffectionmonthly) {
        set(PROPERTY_ISAFFECTIONMONTHLY, isaffectionmonthly);
    }

    public String getConceptsubtype() {
        return (String) get(PROPERTY_CONCEPTSUBTYPE);
    }

    public void setConceptsubtype(String conceptsubtype) {
        set(PROPERTY_CONCEPTSUBTYPE, conceptsubtype);
    }

    public Boolean isIess() {
        return (Boolean) get(PROPERTY_ISIESS);
    }

    public void setIess(Boolean isIess) {
        set(PROPERTY_ISIESS, isIess);
    }

    public Boolean isLiquidation() {
        return (Boolean) get(PROPERTY_LIQUIDATION);
    }

    public void setLiquidation(Boolean liquidation) {
        set(PROPERTY_LIQUIDATION, liquidation);
    }

}
