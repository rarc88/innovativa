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
import org.openbravo.model.financialmgmt.calendar.Year;
/**
 * Entity class for entity sspr_supplementary_data (stored in table sspr_supplementary_data).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SsprSupplementaryData extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sspr_supplementary_data";
    public static final String ENTITY_NAME = "sspr_supplementary_data";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_YEAR = "yEAR";
    public static final String PROPERTY_TAXIDCOMPANY = "taxidCompany";
    public static final String PROPERTY_TAXIDPARTNER = "taxidPartner";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_SURNAME = "surname";
    public static final String PROPERTY_GENDER = "gender";
    public static final String PROPERTY_OCCUPCODEIESS = "occupCodeIess";
    public static final String PROPERTY_NUMCHARGES = "nUMCharges";
    public static final String PROPERTY_DAYSWORKED = "daysworked";
    public static final String PROPERTY_PAYMENTTYPE = "paymenttype";
    public static final String PROPERTY_JUDICIALRETENTION = "judicialRetention";
    public static final String PROPERTY_NAMESURNAME = "nameSurname";
    public static final String PROPERTY_SSPRPROFITSLIST = "ssprProfitsList";
    public static final String PROPERTY_SSPRUTILITIESLIST = "ssprUtilitiesList";

    public SsprSupplementaryData() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_OCCUPCODEIESS, "0");
        setDefaultValue(PROPERTY_NUMCHARGES, (long) 0);
        setDefaultValue(PROPERTY_DAYSWORKED, (long) 0);
        setDefaultValue(PROPERTY_JUDICIALRETENTION, (long) 0);
        setDefaultValue(PROPERTY_SSPRPROFITSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRUTILITIESLIST, new ArrayList<Object>());
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

    public Year getYEAR() {
        return (Year) get(PROPERTY_YEAR);
    }

    public void setYEAR(Year yEAR) {
        set(PROPERTY_YEAR, yEAR);
    }

    public String getTaxidCompany() {
        return (String) get(PROPERTY_TAXIDCOMPANY);
    }

    public void setTaxidCompany(String taxidCompany) {
        set(PROPERTY_TAXIDCOMPANY, taxidCompany);
    }

    public String getTaxidPartner() {
        return (String) get(PROPERTY_TAXIDPARTNER);
    }

    public void setTaxidPartner(String taxidPartner) {
        set(PROPERTY_TAXIDPARTNER, taxidPartner);
    }

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public String getSurname() {
        return (String) get(PROPERTY_SURNAME);
    }

    public void setSurname(String surname) {
        set(PROPERTY_SURNAME, surname);
    }

    public String getGender() {
        return (String) get(PROPERTY_GENDER);
    }

    public void setGender(String gender) {
        set(PROPERTY_GENDER, gender);
    }

    public String getOccupCodeIess() {
        return (String) get(PROPERTY_OCCUPCODEIESS);
    }

    public void setOccupCodeIess(String occupCodeIess) {
        set(PROPERTY_OCCUPCODEIESS, occupCodeIess);
    }

    public Long getNUMCharges() {
        return (Long) get(PROPERTY_NUMCHARGES);
    }

    public void setNUMCharges(Long nUMCharges) {
        set(PROPERTY_NUMCHARGES, nUMCharges);
    }

    public Long getDaysworked() {
        return (Long) get(PROPERTY_DAYSWORKED);
    }

    public void setDaysworked(Long daysworked) {
        set(PROPERTY_DAYSWORKED, daysworked);
    }

    public String getPaymenttype() {
        return (String) get(PROPERTY_PAYMENTTYPE);
    }

    public void setPaymenttype(String paymenttype) {
        set(PROPERTY_PAYMENTTYPE, paymenttype);
    }

    public Long getJudicialRetention() {
        return (Long) get(PROPERTY_JUDICIALRETENTION);
    }

    public void setJudicialRetention(Long judicialRetention) {
        set(PROPERTY_JUDICIALRETENTION, judicialRetention);
    }

    public String getNameSurname() {
        return (String) get(PROPERTY_NAMESURNAME);
    }

    public void setNameSurname(String nameSurname) {
        set(PROPERTY_NAMESURNAME, nameSurname);
    }

    @SuppressWarnings("unchecked")
    public List<ssprprofits> getSsprProfitsList() {
      return (List<ssprprofits>) get(PROPERTY_SSPRPROFITSLIST);
    }

    public void setSsprProfitsList(List<ssprprofits> ssprProfitsList) {
        set(PROPERTY_SSPRPROFITSLIST, ssprProfitsList);
    }

    @SuppressWarnings("unchecked")
    public List<ssprutilities> getSsprUtilitiesList() {
      return (List<ssprutilities>) get(PROPERTY_SSPRUTILITIESLIST);
    }

    public void setSsprUtilitiesList(List<ssprutilities> ssprUtilitiesList) {
        set(PROPERTY_SSPRUTILITIESLIST, ssprUtilitiesList);
    }

}
