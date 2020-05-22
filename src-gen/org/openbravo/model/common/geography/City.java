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
package org.openbravo.model.common.geography;

import com.sidesoft.hrm.payroll.Contract;
import com.sidesoft.hrm.payroll.ssprleaveemp;

import ec.com.sidesoft.localization.ecuador.viatical.SSVECityZone;
import ec.com.sidesoft.localization.ecuador.viatical.SSVEMobilCityValue;
import ec.com.sidesoft.localization.ecuador.viatical.SSVEViatical;
import ec.com.sidesoft.localization.ecuador.viatical.SSVEViaticalSettlement;

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
 * Entity class for entity City (stored in table C_City).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class City extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_City";
    public static final String ENTITY_NAME = "City";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_ABBREVIATION = "abbreviation";
    public static final String PROPERTY_COORDINATES = "coordinates";
    public static final String PROPERTY_POSTALCODE = "postalCode";
    public static final String PROPERTY_AREACODE = "areaCode";
    public static final String PROPERTY_COUNTRY = "country";
    public static final String PROPERTY_REGION = "region";
    public static final String PROPERTY_SSPRVALUE = "ssprValue";
    public static final String PROPERTY_BUSINESSPARTNEREMSSPRCITYLIST = "businessPartnerEMSsprCityList";
    public static final String PROPERTY_LOCATIONLIST = "locationList";
    public static final String PROPERTY_SSPRCONTRACTLIST = "sSPRContractList";
    public static final String PROPERTY_SSPRLEAVEEMPLIST = "sSPRLeaveEmpList";
    public static final String PROPERTY_SSVECITYZONELIST = "sSVECityZoneList";
    public static final String PROPERTY_SSVEMOBILCITYVALUELIST = "sSVEMobilCityValueList";
    public static final String PROPERTY_SSVEVIATICALLIST = "sSVEViaticalList";
    public static final String PROPERTY_SSVEVIATICALEMPLOYEECITYLIST = "sSVEViaticalEmployeeCityList";
    public static final String PROPERTY_SSVEVIATICALMOBILIZATIONCITYLIST = "sSVEViaticalMobilizationCityList";
    public static final String PROPERTY_SSVEVIATICALSETTLEMENTLIST = "sSVEViaticalSettlementList";
    public static final String PROPERTY_SSVEVIATICALSETTLEMENTEMPLOYEECITYLIST = "sSVEViaticalSettlementEmployeeCityList";
    public static final String PROPERTY_SSVEVIATICALSETTLEMENTMOBILIZATIONCITYLIST = "sSVEViaticalSettlementMobilizationCityList";

    public City() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_BUSINESSPARTNEREMSSPRCITYLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_LOCATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRCONTRACTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRLEAVEEMPLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSVECITYZONELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSVEMOBILCITYVALUELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSVEVIATICALLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSVEVIATICALEMPLOYEECITYLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSVEVIATICALMOBILIZATIONCITYLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSVEVIATICALSETTLEMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSVEVIATICALSETTLEMENTEMPLOYEECITYLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSVEVIATICALSETTLEMENTMOBILIZATIONCITYLIST, new ArrayList<Object>());
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

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public String getAbbreviation() {
        return (String) get(PROPERTY_ABBREVIATION);
    }

    public void setAbbreviation(String abbreviation) {
        set(PROPERTY_ABBREVIATION, abbreviation);
    }

    public String getCoordinates() {
        return (String) get(PROPERTY_COORDINATES);
    }

    public void setCoordinates(String coordinates) {
        set(PROPERTY_COORDINATES, coordinates);
    }

    public String getPostalCode() {
        return (String) get(PROPERTY_POSTALCODE);
    }

    public void setPostalCode(String postalCode) {
        set(PROPERTY_POSTALCODE, postalCode);
    }

    public String getAreaCode() {
        return (String) get(PROPERTY_AREACODE);
    }

    public void setAreaCode(String areaCode) {
        set(PROPERTY_AREACODE, areaCode);
    }

    public Country getCountry() {
        return (Country) get(PROPERTY_COUNTRY);
    }

    public void setCountry(Country country) {
        set(PROPERTY_COUNTRY, country);
    }

    public Region getRegion() {
        return (Region) get(PROPERTY_REGION);
    }

    public void setRegion(Region region) {
        set(PROPERTY_REGION, region);
    }

    public String getSsprValue() {
        return (String) get(PROPERTY_SSPRVALUE);
    }

    public void setSsprValue(String ssprValue) {
        set(PROPERTY_SSPRVALUE, ssprValue);
    }

    @SuppressWarnings("unchecked")
    public List<BusinessPartner> getBusinessPartnerEMSsprCityList() {
      return (List<BusinessPartner>) get(PROPERTY_BUSINESSPARTNEREMSSPRCITYLIST);
    }

    public void setBusinessPartnerEMSsprCityList(List<BusinessPartner> businessPartnerEMSsprCityList) {
        set(PROPERTY_BUSINESSPARTNEREMSSPRCITYLIST, businessPartnerEMSsprCityList);
    }

    @SuppressWarnings("unchecked")
    public List<Location> getLocationList() {
      return (List<Location>) get(PROPERTY_LOCATIONLIST);
    }

    public void setLocationList(List<Location> locationList) {
        set(PROPERTY_LOCATIONLIST, locationList);
    }

    @SuppressWarnings("unchecked")
    public List<Contract> getSSPRContractList() {
      return (List<Contract>) get(PROPERTY_SSPRCONTRACTLIST);
    }

    public void setSSPRContractList(List<Contract> sSPRContractList) {
        set(PROPERTY_SSPRCONTRACTLIST, sSPRContractList);
    }

    @SuppressWarnings("unchecked")
    public List<ssprleaveemp> getSSPRLeaveEmpList() {
      return (List<ssprleaveemp>) get(PROPERTY_SSPRLEAVEEMPLIST);
    }

    public void setSSPRLeaveEmpList(List<ssprleaveemp> sSPRLeaveEmpList) {
        set(PROPERTY_SSPRLEAVEEMPLIST, sSPRLeaveEmpList);
    }

    @SuppressWarnings("unchecked")
    public List<SSVECityZone> getSSVECityZoneList() {
      return (List<SSVECityZone>) get(PROPERTY_SSVECITYZONELIST);
    }

    public void setSSVECityZoneList(List<SSVECityZone> sSVECityZoneList) {
        set(PROPERTY_SSVECITYZONELIST, sSVECityZoneList);
    }

    @SuppressWarnings("unchecked")
    public List<SSVEMobilCityValue> getSSVEMobilCityValueList() {
      return (List<SSVEMobilCityValue>) get(PROPERTY_SSVEMOBILCITYVALUELIST);
    }

    public void setSSVEMobilCityValueList(List<SSVEMobilCityValue> sSVEMobilCityValueList) {
        set(PROPERTY_SSVEMOBILCITYVALUELIST, sSVEMobilCityValueList);
    }

    @SuppressWarnings("unchecked")
    public List<SSVEViatical> getSSVEViaticalList() {
      return (List<SSVEViatical>) get(PROPERTY_SSVEVIATICALLIST);
    }

    public void setSSVEViaticalList(List<SSVEViatical> sSVEViaticalList) {
        set(PROPERTY_SSVEVIATICALLIST, sSVEViaticalList);
    }

    @SuppressWarnings("unchecked")
    public List<SSVEViatical> getSSVEViaticalEmployeeCityList() {
      return (List<SSVEViatical>) get(PROPERTY_SSVEVIATICALEMPLOYEECITYLIST);
    }

    public void setSSVEViaticalEmployeeCityList(List<SSVEViatical> sSVEViaticalEmployeeCityList) {
        set(PROPERTY_SSVEVIATICALEMPLOYEECITYLIST, sSVEViaticalEmployeeCityList);
    }

    @SuppressWarnings("unchecked")
    public List<SSVEViatical> getSSVEViaticalMobilizationCityList() {
      return (List<SSVEViatical>) get(PROPERTY_SSVEVIATICALMOBILIZATIONCITYLIST);
    }

    public void setSSVEViaticalMobilizationCityList(List<SSVEViatical> sSVEViaticalMobilizationCityList) {
        set(PROPERTY_SSVEVIATICALMOBILIZATIONCITYLIST, sSVEViaticalMobilizationCityList);
    }

    @SuppressWarnings("unchecked")
    public List<SSVEViaticalSettlement> getSSVEViaticalSettlementList() {
      return (List<SSVEViaticalSettlement>) get(PROPERTY_SSVEVIATICALSETTLEMENTLIST);
    }

    public void setSSVEViaticalSettlementList(List<SSVEViaticalSettlement> sSVEViaticalSettlementList) {
        set(PROPERTY_SSVEVIATICALSETTLEMENTLIST, sSVEViaticalSettlementList);
    }

    @SuppressWarnings("unchecked")
    public List<SSVEViaticalSettlement> getSSVEViaticalSettlementEmployeeCityList() {
      return (List<SSVEViaticalSettlement>) get(PROPERTY_SSVEVIATICALSETTLEMENTEMPLOYEECITYLIST);
    }

    public void setSSVEViaticalSettlementEmployeeCityList(List<SSVEViaticalSettlement> sSVEViaticalSettlementEmployeeCityList) {
        set(PROPERTY_SSVEVIATICALSETTLEMENTEMPLOYEECITYLIST, sSVEViaticalSettlementEmployeeCityList);
    }

    @SuppressWarnings("unchecked")
    public List<SSVEViaticalSettlement> getSSVEViaticalSettlementMobilizationCityList() {
      return (List<SSVEViaticalSettlement>) get(PROPERTY_SSVEVIATICALSETTLEMENTMOBILIZATIONCITYLIST);
    }

    public void setSSVEViaticalSettlementMobilizationCityList(List<SSVEViaticalSettlement> sSVEViaticalSettlementMobilizationCityList) {
        set(PROPERTY_SSVEVIATICALSETTLEMENTMOBILIZATIONCITYLIST, sSVEViaticalSettlementMobilizationCityList);
    }

}
