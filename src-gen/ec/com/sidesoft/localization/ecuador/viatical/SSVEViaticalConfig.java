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

import com.sidesoft.flopec.budget.data.SFBBudgetItem;

import java.math.BigDecimal;
import java.sql.Timestamp;
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
/**
 * Entity class for entity SSVE_Viatical_Config (stored in table SSVE_Viatical_Config).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SSVEViaticalConfig extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "SSVE_Viatical_Config";
    public static final String ENTITY_NAME = "SSVE_Viatical_Config";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_SUBSISTENCEPERCENT = "subsistencePercent";
    public static final String PROPERTY_ISBASEDPERCENT = "isBasedPercent";
    public static final String PROPERTY_LIMITTIME = "limitTime";
    public static final String PROPERTY_FEEDINGVALUE = "feedingValue";
    public static final String PROPERTY_TRANSPORTCALCULATIONTYPE = "transportCalculationType";
    public static final String PROPERTY_DEPARTURETIMELIMIT = "departureTimeLimit";
    public static final String PROPERTY_ARRIVALTIMELIMIT = "arrivalTimeLimit";
    public static final String PROPERTY_EXCHANGEDIFFERENCEBUDGETITEM = "exchangeDifferenceBudgetItem";
    public static final String PROPERTY_SSVEMOBILCITYVALUELIST = "sSVEMobilCityValueList";
    public static final String PROPERTY_SSVEVIATCONFIGONDAYSINTLIST = "sSVEViatConfigOndaysIntList";
    public static final String PROPERTY_SSVEVIATICALCONFIGONDAYSLIST = "sSVEViaticalConfigOndaysList";
    public static final String PROPERTY_SSVEVIATICALCONFIGACCTLIST = "ssveViaticalConfigAcctList";

    public SSVEViaticalConfig() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_FEEDINGVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_SSVEMOBILCITYVALUELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSVEVIATCONFIGONDAYSINTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSVEVIATICALCONFIGONDAYSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSVEVIATICALCONFIGACCTLIST, new ArrayList<Object>());
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

    public Long getSubsistencePercent() {
        return (Long) get(PROPERTY_SUBSISTENCEPERCENT);
    }

    public void setSubsistencePercent(Long subsistencePercent) {
        set(PROPERTY_SUBSISTENCEPERCENT, subsistencePercent);
    }

    public Long getIsBasedPercent() {
        return (Long) get(PROPERTY_ISBASEDPERCENT);
    }

    public void setIsBasedPercent(Long isBasedPercent) {
        set(PROPERTY_ISBASEDPERCENT, isBasedPercent);
    }

    public Timestamp getLimitTime() {
        return (Timestamp) get(PROPERTY_LIMITTIME);
    }

    public void setLimitTime(Timestamp limitTime) {
        set(PROPERTY_LIMITTIME, limitTime);
    }

    public BigDecimal getFeedingValue() {
        return (BigDecimal) get(PROPERTY_FEEDINGVALUE);
    }

    public void setFeedingValue(BigDecimal feedingValue) {
        set(PROPERTY_FEEDINGVALUE, feedingValue);
    }

    public String getTransportCalculationType() {
        return (String) get(PROPERTY_TRANSPORTCALCULATIONTYPE);
    }

    public void setTransportCalculationType(String transportCalculationType) {
        set(PROPERTY_TRANSPORTCALCULATIONTYPE, transportCalculationType);
    }

    public Timestamp getDepartureTimeLimit() {
        return (Timestamp) get(PROPERTY_DEPARTURETIMELIMIT);
    }

    public void setDepartureTimeLimit(Timestamp departureTimeLimit) {
        set(PROPERTY_DEPARTURETIMELIMIT, departureTimeLimit);
    }

    public Timestamp getArrivalTimeLimit() {
        return (Timestamp) get(PROPERTY_ARRIVALTIMELIMIT);
    }

    public void setArrivalTimeLimit(Timestamp arrivalTimeLimit) {
        set(PROPERTY_ARRIVALTIMELIMIT, arrivalTimeLimit);
    }

    public SFBBudgetItem getExchangeDifferenceBudgetItem() {
        return (SFBBudgetItem) get(PROPERTY_EXCHANGEDIFFERENCEBUDGETITEM);
    }

    public void setExchangeDifferenceBudgetItem(SFBBudgetItem exchangeDifferenceBudgetItem) {
        set(PROPERTY_EXCHANGEDIFFERENCEBUDGETITEM, exchangeDifferenceBudgetItem);
    }

    @SuppressWarnings("unchecked")
    public List<SSVEMobilCityValue> getSSVEMobilCityValueList() {
      return (List<SSVEMobilCityValue>) get(PROPERTY_SSVEMOBILCITYVALUELIST);
    }

    public void setSSVEMobilCityValueList(List<SSVEMobilCityValue> sSVEMobilCityValueList) {
        set(PROPERTY_SSVEMOBILCITYVALUELIST, sSVEMobilCityValueList);
    }

    @SuppressWarnings("unchecked")
    public List<SSVEViatConfigOndaysInt> getSSVEViatConfigOndaysIntList() {
      return (List<SSVEViatConfigOndaysInt>) get(PROPERTY_SSVEVIATCONFIGONDAYSINTLIST);
    }

    public void setSSVEViatConfigOndaysIntList(List<SSVEViatConfigOndaysInt> sSVEViatConfigOndaysIntList) {
        set(PROPERTY_SSVEVIATCONFIGONDAYSINTLIST, sSVEViatConfigOndaysIntList);
    }

    @SuppressWarnings("unchecked")
    public List<SSVEViaticalConfigOndays> getSSVEViaticalConfigOndaysList() {
      return (List<SSVEViaticalConfigOndays>) get(PROPERTY_SSVEVIATICALCONFIGONDAYSLIST);
    }

    public void setSSVEViaticalConfigOndaysList(List<SSVEViaticalConfigOndays> sSVEViaticalConfigOndaysList) {
        set(PROPERTY_SSVEVIATICALCONFIGONDAYSLIST, sSVEViaticalConfigOndaysList);
    }

    @SuppressWarnings("unchecked")
    public List<SsveViaticalConfigAcct> getSsveViaticalConfigAcctList() {
      return (List<SsveViaticalConfigAcct>) get(PROPERTY_SSVEVIATICALCONFIGACCTLIST);
    }

    public void setSsveViaticalConfigAcctList(List<SsveViaticalConfigAcct> ssveViaticalConfigAcctList) {
        set(PROPERTY_SSVEVIATICALCONFIGACCTLIST, ssveViaticalConfigAcctList);
    }

}
