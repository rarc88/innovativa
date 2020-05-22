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
package org.openbravo.model.common.enterprise;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.RoleOrganization;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.financialmgmt.accounting.coa.AcctSchema;
import org.openbravo.model.financialmgmt.calendar.Calendar;
import org.openbravo.model.financialmgmt.calendar.PeriodControlV;
import org.openbravo.model.financialmgmt.gl.GLItem;
/**
 * Entity class for entity Organization (stored in table AD_Org).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Organization extends BaseOBObject implements Traceable, ClientEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "AD_Org";
    public static final String ENTITY_NAME = "Organization";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_SEARCHKEY = "searchKey";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_SUMMARYLEVEL = "summaryLevel";
    public static final String PROPERTY_ORGANIZATIONTYPE = "organizationType";
    public static final String PROPERTY_ALLOWPERIODCONTROL = "allowPeriodControl";
    public static final String PROPERTY_CALENDAR = "calendar";
    public static final String PROPERTY_READY = "ready";
    public static final String PROPERTY_SSWHDESCRIPTION2 = "sswhDescription2";
    public static final String PROPERTY_SOCIALNAME = "socialName";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_GENERALLEDGER = "generalLedger";
    public static final String PROPERTY_APRMGLITEM = "aPRMGlitem";
    public static final String PROPERTY_PERIODCONTROLALLOWEDORGANIZATION = "periodControlAllowedOrganization";
    public static final String PROPERTY_CALENDAROWNERORGANIZATION = "calendarOwnerOrganization";
    public static final String PROPERTY_LEGALENTITYORGANIZATION = "legalEntityOrganization";
    public static final String PROPERTY_INHERITEDCALENDAR = "inheritedCalendar";
    public static final String PROPERTY_BUSINESSUNITORGANIZATION = "businessUnitOrganization";
    public static final String PROPERTY_SFCBRBALANCESIGN1 = "sfcbrBalanceSign1";
    public static final String PROPERTY_SFCBRBALANCESIGN2 = "sfcbrBalanceSign2";
    public static final String PROPERTY_EEISHOWREMISSIONGUIDE = "eeiShowRemissionGuide";
    public static final String PROPERTY_ADROLEORGANIZATIONLIST = "aDRoleOrganizationList";
    public static final String PROPERTY_FINANCIALMGMTPERIODCONTROLVLIST = "financialMgmtPeriodControlVList";
    public static final String PROPERTY_ORGANIZATIONINFORMATIONLIST = "organizationInformationList";
    public static final String PROPERTY_ORGANIZATIONMODULEVLIST = "organizationModuleVList";
    public static final String PROPERTY_ORGANIZATIONTREELIST = "organizationTreeList";
    public static final String PROPERTY_ORGANIZATIONWAREHOUSELIST = "organizationWarehouseList";

    public Organization() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_SUMMARYLEVEL, false);
        setDefaultValue(PROPERTY_ALLOWPERIODCONTROL, false);
        setDefaultValue(PROPERTY_READY, false);
        setDefaultValue(PROPERTY_EEISHOWREMISSIONGUIDE, false);
        setDefaultValue(PROPERTY_ADROLEORGANIZATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTPERIODCONTROLVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORGANIZATIONINFORMATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORGANIZATIONMODULEVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORGANIZATIONTREELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORGANIZATIONWAREHOUSELIST, new ArrayList<Object>());
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

    public String getSearchKey() {
        return (String) get(PROPERTY_SEARCHKEY);
    }

    public void setSearchKey(String searchKey) {
        set(PROPERTY_SEARCHKEY, searchKey);
    }

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Boolean isSummaryLevel() {
        return (Boolean) get(PROPERTY_SUMMARYLEVEL);
    }

    public void setSummaryLevel(Boolean summaryLevel) {
        set(PROPERTY_SUMMARYLEVEL, summaryLevel);
    }

    public OrganizationType getOrganizationType() {
        return (OrganizationType) get(PROPERTY_ORGANIZATIONTYPE);
    }

    public void setOrganizationType(OrganizationType organizationType) {
        set(PROPERTY_ORGANIZATIONTYPE, organizationType);
    }

    public Boolean isAllowPeriodControl() {
        return (Boolean) get(PROPERTY_ALLOWPERIODCONTROL);
    }

    public void setAllowPeriodControl(Boolean allowPeriodControl) {
        set(PROPERTY_ALLOWPERIODCONTROL, allowPeriodControl);
    }

    public Calendar getCalendar() {
        return (Calendar) get(PROPERTY_CALENDAR);
    }

    public void setCalendar(Calendar calendar) {
        set(PROPERTY_CALENDAR, calendar);
    }

    public Boolean isReady() {
        return (Boolean) get(PROPERTY_READY);
    }

    public void setReady(Boolean ready) {
        set(PROPERTY_READY, ready);
    }

    public String getSswhDescription2() {
        return (String) get(PROPERTY_SSWHDESCRIPTION2);
    }

    public void setSswhDescription2(String sswhDescription2) {
        set(PROPERTY_SSWHDESCRIPTION2, sswhDescription2);
    }

    public String getSocialName() {
        return (String) get(PROPERTY_SOCIALNAME);
    }

    public void setSocialName(String socialName) {
        set(PROPERTY_SOCIALNAME, socialName);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public AcctSchema getGeneralLedger() {
        return (AcctSchema) get(PROPERTY_GENERALLEDGER);
    }

    public void setGeneralLedger(AcctSchema generalLedger) {
        set(PROPERTY_GENERALLEDGER, generalLedger);
    }

    public GLItem getAPRMGlitem() {
        return (GLItem) get(PROPERTY_APRMGLITEM);
    }

    public void setAPRMGlitem(GLItem aPRMGlitem) {
        set(PROPERTY_APRMGLITEM, aPRMGlitem);
    }

    public Organization getPeriodControlAllowedOrganization() {
        return (Organization) get(PROPERTY_PERIODCONTROLALLOWEDORGANIZATION);
    }

    public void setPeriodControlAllowedOrganization(Organization periodControlAllowedOrganization) {
        set(PROPERTY_PERIODCONTROLALLOWEDORGANIZATION, periodControlAllowedOrganization);
    }

    public Organization getCalendarOwnerOrganization() {
        return (Organization) get(PROPERTY_CALENDAROWNERORGANIZATION);
    }

    public void setCalendarOwnerOrganization(Organization calendarOwnerOrganization) {
        set(PROPERTY_CALENDAROWNERORGANIZATION, calendarOwnerOrganization);
    }

    public Organization getLegalEntityOrganization() {
        return (Organization) get(PROPERTY_LEGALENTITYORGANIZATION);
    }

    public void setLegalEntityOrganization(Organization legalEntityOrganization) {
        set(PROPERTY_LEGALENTITYORGANIZATION, legalEntityOrganization);
    }

    public Calendar getInheritedCalendar() {
        return (Calendar) get(PROPERTY_INHERITEDCALENDAR);
    }

    public void setInheritedCalendar(Calendar inheritedCalendar) {
        set(PROPERTY_INHERITEDCALENDAR, inheritedCalendar);
    }

    public Organization getBusinessUnitOrganization() {
        return (Organization) get(PROPERTY_BUSINESSUNITORGANIZATION);
    }

    public void setBusinessUnitOrganization(Organization businessUnitOrganization) {
        set(PROPERTY_BUSINESSUNITORGANIZATION, businessUnitOrganization);
    }

    public BusinessPartner getSfcbrBalanceSign1() {
        return (BusinessPartner) get(PROPERTY_SFCBRBALANCESIGN1);
    }

    public void setSfcbrBalanceSign1(BusinessPartner sfcbrBalanceSign1) {
        set(PROPERTY_SFCBRBALANCESIGN1, sfcbrBalanceSign1);
    }

    public BusinessPartner getSfcbrBalanceSign2() {
        return (BusinessPartner) get(PROPERTY_SFCBRBALANCESIGN2);
    }

    public void setSfcbrBalanceSign2(BusinessPartner sfcbrBalanceSign2) {
        set(PROPERTY_SFCBRBALANCESIGN2, sfcbrBalanceSign2);
    }

    public Boolean isEeiShowRemissionGuide() {
        return (Boolean) get(PROPERTY_EEISHOWREMISSIONGUIDE);
    }

    public void setEeiShowRemissionGuide(Boolean eeiShowRemissionGuide) {
        set(PROPERTY_EEISHOWREMISSIONGUIDE, eeiShowRemissionGuide);
    }

    @SuppressWarnings("unchecked")
    public List<RoleOrganization> getADRoleOrganizationList() {
      return (List<RoleOrganization>) get(PROPERTY_ADROLEORGANIZATIONLIST);
    }

    public void setADRoleOrganizationList(List<RoleOrganization> aDRoleOrganizationList) {
        set(PROPERTY_ADROLEORGANIZATIONLIST, aDRoleOrganizationList);
    }

    @SuppressWarnings("unchecked")
    public List<PeriodControlV> getFinancialMgmtPeriodControlVList() {
      return (List<PeriodControlV>) get(PROPERTY_FINANCIALMGMTPERIODCONTROLVLIST);
    }

    public void setFinancialMgmtPeriodControlVList(List<PeriodControlV> financialMgmtPeriodControlVList) {
        set(PROPERTY_FINANCIALMGMTPERIODCONTROLVLIST, financialMgmtPeriodControlVList);
    }

    @SuppressWarnings("unchecked")
    public List<OrganizationInformation> getOrganizationInformationList() {
      return (List<OrganizationInformation>) get(PROPERTY_ORGANIZATIONINFORMATIONLIST);
    }

    public void setOrganizationInformationList(List<OrganizationInformation> organizationInformationList) {
        set(PROPERTY_ORGANIZATIONINFORMATIONLIST, organizationInformationList);
    }

    @SuppressWarnings("unchecked")
    public List<OrganizationModuleV> getOrganizationModuleVList() {
      return (List<OrganizationModuleV>) get(PROPERTY_ORGANIZATIONMODULEVLIST);
    }

    public void setOrganizationModuleVList(List<OrganizationModuleV> organizationModuleVList) {
        set(PROPERTY_ORGANIZATIONMODULEVLIST, organizationModuleVList);
    }

    @SuppressWarnings("unchecked")
    public List<OrganizationTree> getOrganizationTreeList() {
      return (List<OrganizationTree>) get(PROPERTY_ORGANIZATIONTREELIST);
    }

    public void setOrganizationTreeList(List<OrganizationTree> organizationTreeList) {
        set(PROPERTY_ORGANIZATIONTREELIST, organizationTreeList);
    }

    @SuppressWarnings("unchecked")
    public List<OrgWarehouse> getOrganizationWarehouseList() {
      return (List<OrgWarehouse>) get(PROPERTY_ORGANIZATIONWAREHOUSELIST);
    }

    public void setOrganizationWarehouseList(List<OrgWarehouse> organizationWarehouseList) {
        set(PROPERTY_ORGANIZATIONWAREHOUSELIST, organizationWarehouseList);
    }

}
