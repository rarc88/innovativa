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
package ec.com.sidesoft.localization.ecuador.viatical;

import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
/**
 * Entity class for entity SSVE_Viatical_Config_Ondays (stored in table SSVE_Viatical_Config_Ondays).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SSVEViaticalConfigOndays extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "SSVE_Viatical_Config_Ondays";
    public static final String ENTITY_NAME = "SSVE_Viatical_Config_Ondays";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_SSVEVIATICALCONFIG = "ssveViaticalConfig";
    public static final String PROPERTY_FROMDAY = "fromDay";
    public static final String PROPERTY_TODAY = "toDay";
    public static final String PROPERTY_VIATICALPERCENT = "viaticalPercent";
    public static final String PROPERTY_INFINITY = "infinity";

    public SSVEViaticalConfigOndays() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_INFINITY, false);
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

    public SSVEViaticalConfig getSsveViaticalConfig() {
        return (SSVEViaticalConfig) get(PROPERTY_SSVEVIATICALCONFIG);
    }

    public void setSsveViaticalConfig(SSVEViaticalConfig ssveViaticalConfig) {
        set(PROPERTY_SSVEVIATICALCONFIG, ssveViaticalConfig);
    }

    public Long getFromDay() {
        return (Long) get(PROPERTY_FROMDAY);
    }

    public void setFromDay(Long fromDay) {
        set(PROPERTY_FROMDAY, fromDay);
    }

    public Long getToDay() {
        return (Long) get(PROPERTY_TODAY);
    }

    public void setToDay(Long toDay) {
        set(PROPERTY_TODAY, toDay);
    }

    public Long getViaticalPercent() {
        return (Long) get(PROPERTY_VIATICALPERCENT);
    }

    public void setViaticalPercent(Long viaticalPercent) {
        set(PROPERTY_VIATICALPERCENT, viaticalPercent);
    }

    public Boolean isInfinity() {
        return (Boolean) get(PROPERTY_INFINITY);
    }

    public void setInfinity(Boolean infinity) {
        set(PROPERTY_INFINITY, infinity);
    }

}
