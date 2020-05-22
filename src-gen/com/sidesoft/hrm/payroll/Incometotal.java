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
 * Entity class for entity sspr_incometotal (stored in table sspr_incometotal).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Incometotal extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sspr_incometotal";
    public static final String ENTITY_NAME = "sspr_incometotal";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_YEAR = "year";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_TOTALIN = "totalin";
    public static final String PROPERTY_TOTALIESS = "totaliess";
    public static final String PROPERTY_TOTALDEDUCTIBLE = "totaldeductible";
    public static final String PROPERTY_BASETAX = "baseTax";
    public static final String PROPERTY_BASIC = "basic";
    public static final String PROPERTY_EXCEDENT = "excedent";
    public static final String PROPERTY_TAXYEAR = "taxyear";
    public static final String PROPERTY_TAXMOTH = "taxmoth";
    public static final String PROPERTY_TOTALIN2 = "totalin2";
    public static final String PROPERTY_TOTALIESS2 = "totaliess2";
    public static final String PROPERTY_BASETAX2 = "baseTax2";
    public static final String PROPERTY_BASETOTAL = "basetotal";
    public static final String PROPERTY_BASIC1 = "basic1";
    public static final String PROPERTY_EXCEDENT1 = "excedent1";
    public static final String PROPERTY_TAXYEAR1 = "taxYear1";
    public static final String PROPERTY_TAXMONTH1 = "taxmonth1";
    public static final String PROPERTY_TOTALINCOMEYEAR = "totalIncomeYear";
    public static final String PROPERTY_TOTALINCOMEMONTH = "totalIncomeMonth";
    public static final String PROPERTY_TAXBEFOREPROJECTED = "taxBeforeProjected";
    public static final String PROPERTY_TAXPAID = "taxpaid";
    public static final String PROPERTY_TAXPURCHASE = "taxpurchase";
    public static final String PROPERTY_PERCENTBENDISAB = "percentBenDisab";
    public static final String PROPERTY_TOTDISAB = "tOTDisab";
    public static final String PROPERTY_BASETOTALDISAB = "basetotalDisab";
    public static final String PROPERTY_AGE = "age";
    public static final String PROPERTY_TOTSENIORS = "tOTSeniors";

    public Incometotal() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_TOTALIN, (long) 0);
        setDefaultValue(PROPERTY_TOTALIESS, new BigDecimal(0));
        setDefaultValue(PROPERTY_TOTALDEDUCTIBLE, new BigDecimal(0));
        setDefaultValue(PROPERTY_BASETAX, new BigDecimal(0));
        setDefaultValue(PROPERTY_BASIC, (long) 0);
        setDefaultValue(PROPERTY_EXCEDENT, (long) 0);
        setDefaultValue(PROPERTY_TAXYEAR, (long) 0);
        setDefaultValue(PROPERTY_TAXMOTH, new BigDecimal(0));
        setDefaultValue(PROPERTY_TOTALIN2, (long) 0);
        setDefaultValue(PROPERTY_TOTALIESS2, (long) 0);
        setDefaultValue(PROPERTY_BASETAX2, (long) 0);
        setDefaultValue(PROPERTY_BASETOTAL, (long) 0);
        setDefaultValue(PROPERTY_BASIC1, (long) 0);
        setDefaultValue(PROPERTY_EXCEDENT1, (long) 0);
        setDefaultValue(PROPERTY_TAXYEAR1, (long) 0);
        setDefaultValue(PROPERTY_TAXMONTH1, (long) 0);
        setDefaultValue(PROPERTY_TOTALINCOMEYEAR, (long) 0);
        setDefaultValue(PROPERTY_TOTALINCOMEMONTH, (long) 0);
        setDefaultValue(PROPERTY_TAXBEFOREPROJECTED, (long) 0);
        setDefaultValue(PROPERTY_TAXPAID, (long) 0);
        setDefaultValue(PROPERTY_TAXPURCHASE, (long) 0);
        setDefaultValue(PROPERTY_PERCENTBENDISAB, (long) 0);
        setDefaultValue(PROPERTY_TOTDISAB, (long) 0);
        setDefaultValue(PROPERTY_BASETOTALDISAB, (long) 0);
        setDefaultValue(PROPERTY_AGE, (long) 0);
        setDefaultValue(PROPERTY_TOTSENIORS, (long) 0);
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

    public Year getYear() {
        return (Year) get(PROPERTY_YEAR);
    }

    public void setYear(Year year) {
        set(PROPERTY_YEAR, year);
    }

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public Long getTotalin() {
        return (Long) get(PROPERTY_TOTALIN);
    }

    public void setTotalin(Long totalin) {
        set(PROPERTY_TOTALIN, totalin);
    }

    public BigDecimal getTotaliess() {
        return (BigDecimal) get(PROPERTY_TOTALIESS);
    }

    public void setTotaliess(BigDecimal totaliess) {
        set(PROPERTY_TOTALIESS, totaliess);
    }

    public BigDecimal getTotaldeductible() {
        return (BigDecimal) get(PROPERTY_TOTALDEDUCTIBLE);
    }

    public void setTotaldeductible(BigDecimal totaldeductible) {
        set(PROPERTY_TOTALDEDUCTIBLE, totaldeductible);
    }

    public BigDecimal getBaseTax() {
        return (BigDecimal) get(PROPERTY_BASETAX);
    }

    public void setBaseTax(BigDecimal baseTax) {
        set(PROPERTY_BASETAX, baseTax);
    }

    public Long getBasic() {
        return (Long) get(PROPERTY_BASIC);
    }

    public void setBasic(Long basic) {
        set(PROPERTY_BASIC, basic);
    }

    public Long getExcedent() {
        return (Long) get(PROPERTY_EXCEDENT);
    }

    public void setExcedent(Long excedent) {
        set(PROPERTY_EXCEDENT, excedent);
    }

    public Long getTaxyear() {
        return (Long) get(PROPERTY_TAXYEAR);
    }

    public void setTaxyear(Long taxyear) {
        set(PROPERTY_TAXYEAR, taxyear);
    }

    public BigDecimal getTaxmoth() {
        return (BigDecimal) get(PROPERTY_TAXMOTH);
    }

    public void setTaxmoth(BigDecimal taxmoth) {
        set(PROPERTY_TAXMOTH, taxmoth);
    }

    public Long getTotalin2() {
        return (Long) get(PROPERTY_TOTALIN2);
    }

    public void setTotalin2(Long totalin2) {
        set(PROPERTY_TOTALIN2, totalin2);
    }

    public Long getTotaliess2() {
        return (Long) get(PROPERTY_TOTALIESS2);
    }

    public void setTotaliess2(Long totaliess2) {
        set(PROPERTY_TOTALIESS2, totaliess2);
    }

    public Long getBaseTax2() {
        return (Long) get(PROPERTY_BASETAX2);
    }

    public void setBaseTax2(Long baseTax2) {
        set(PROPERTY_BASETAX2, baseTax2);
    }

    public Long getBasetotal() {
        return (Long) get(PROPERTY_BASETOTAL);
    }

    public void setBasetotal(Long basetotal) {
        set(PROPERTY_BASETOTAL, basetotal);
    }

    public Long getBasic1() {
        return (Long) get(PROPERTY_BASIC1);
    }

    public void setBasic1(Long basic1) {
        set(PROPERTY_BASIC1, basic1);
    }

    public Long getExcedent1() {
        return (Long) get(PROPERTY_EXCEDENT1);
    }

    public void setExcedent1(Long excedent1) {
        set(PROPERTY_EXCEDENT1, excedent1);
    }

    public Long getTaxYear1() {
        return (Long) get(PROPERTY_TAXYEAR1);
    }

    public void setTaxYear1(Long taxYear1) {
        set(PROPERTY_TAXYEAR1, taxYear1);
    }

    public Long getTaxmonth1() {
        return (Long) get(PROPERTY_TAXMONTH1);
    }

    public void setTaxmonth1(Long taxmonth1) {
        set(PROPERTY_TAXMONTH1, taxmonth1);
    }

    public Long getTotalIncomeYear() {
        return (Long) get(PROPERTY_TOTALINCOMEYEAR);
    }

    public void setTotalIncomeYear(Long totalIncomeYear) {
        set(PROPERTY_TOTALINCOMEYEAR, totalIncomeYear);
    }

    public Long getTotalIncomeMonth() {
        return (Long) get(PROPERTY_TOTALINCOMEMONTH);
    }

    public void setTotalIncomeMonth(Long totalIncomeMonth) {
        set(PROPERTY_TOTALINCOMEMONTH, totalIncomeMonth);
    }

    public Long getTaxBeforeProjected() {
        return (Long) get(PROPERTY_TAXBEFOREPROJECTED);
    }

    public void setTaxBeforeProjected(Long taxBeforeProjected) {
        set(PROPERTY_TAXBEFOREPROJECTED, taxBeforeProjected);
    }

    public Long getTaxpaid() {
        return (Long) get(PROPERTY_TAXPAID);
    }

    public void setTaxpaid(Long taxpaid) {
        set(PROPERTY_TAXPAID, taxpaid);
    }

    public Long getTaxpurchase() {
        return (Long) get(PROPERTY_TAXPURCHASE);
    }

    public void setTaxpurchase(Long taxpurchase) {
        set(PROPERTY_TAXPURCHASE, taxpurchase);
    }

    public Long getPercentBenDisab() {
        return (Long) get(PROPERTY_PERCENTBENDISAB);
    }

    public void setPercentBenDisab(Long percentBenDisab) {
        set(PROPERTY_PERCENTBENDISAB, percentBenDisab);
    }

    public Long getTOTDisab() {
        return (Long) get(PROPERTY_TOTDISAB);
    }

    public void setTOTDisab(Long tOTDisab) {
        set(PROPERTY_TOTDISAB, tOTDisab);
    }

    public Long getBasetotalDisab() {
        return (Long) get(PROPERTY_BASETOTALDISAB);
    }

    public void setBasetotalDisab(Long basetotalDisab) {
        set(PROPERTY_BASETOTALDISAB, basetotalDisab);
    }

    public Long getAge() {
        return (Long) get(PROPERTY_AGE);
    }

    public void setAge(Long age) {
        set(PROPERTY_AGE, age);
    }

    public Long getTOTSeniors() {
        return (Long) get(PROPERTY_TOTSENIORS);
    }

    public void setTOTSeniors(Long tOTSeniors) {
        set(PROPERTY_TOTSENIORS, tOTSeniors);
    }

}
