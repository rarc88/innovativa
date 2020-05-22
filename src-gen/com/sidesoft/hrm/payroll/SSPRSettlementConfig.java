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
import org.openbravo.model.common.enterprise.Organization;
/**
 * Entity class for entity SSPR_SettlementConfig (stored in table SSPR_SettlementConfig).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SSPRSettlementConfig extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "SSPR_SettlementConfig";
    public static final String ENTITY_NAME = "SSPR_SettlementConfig";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_CONTRACTTYPE = "contractType";
    public static final String PROPERTY_REASONENDLABORRELATIONS = "reasonEndLaborRelations";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_BYINTERVAL = "byInterval";
    public static final String PROPERTY_INTERVALFROM = "intervalFrom";
    public static final String PROPERTY_INTERVALTO = "intervalTo";
    public static final String PROPERTY_SSPRSETTLEMENTCONFIGLINELIST = "sSPRSettlementConfigLineList";

    public SSPRSettlementConfig() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_BYINTERVAL, false);
        setDefaultValue(PROPERTY_INTERVALFROM, new BigDecimal(0));
        setDefaultValue(PROPERTY_INTERVALTO, (long) 0);
        setDefaultValue(PROPERTY_SSPRSETTLEMENTCONFIGLINELIST, new ArrayList<Object>());
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

    public ContractType getContractType() {
        return (ContractType) get(PROPERTY_CONTRACTTYPE);
    }

    public void setContractType(ContractType contractType) {
        set(PROPERTY_CONTRACTTYPE, contractType);
    }

    public String getReasonEndLaborRelations() {
        return (String) get(PROPERTY_REASONENDLABORRELATIONS);
    }

    public void setReasonEndLaborRelations(String reasonEndLaborRelations) {
        set(PROPERTY_REASONENDLABORRELATIONS, reasonEndLaborRelations);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Boolean isByInterval() {
        return (Boolean) get(PROPERTY_BYINTERVAL);
    }

    public void setByInterval(Boolean byInterval) {
        set(PROPERTY_BYINTERVAL, byInterval);
    }

    public BigDecimal getIntervalFrom() {
        return (BigDecimal) get(PROPERTY_INTERVALFROM);
    }

    public void setIntervalFrom(BigDecimal intervalFrom) {
        set(PROPERTY_INTERVALFROM, intervalFrom);
    }

    public Long getIntervalTo() {
        return (Long) get(PROPERTY_INTERVALTO);
    }

    public void setIntervalTo(Long intervalTo) {
        set(PROPERTY_INTERVALTO, intervalTo);
    }

    @SuppressWarnings("unchecked")
    public List<SSPRSettlementConfigLine> getSSPRSettlementConfigLineList() {
      return (List<SSPRSettlementConfigLine>) get(PROPERTY_SSPRSETTLEMENTCONFIGLINELIST);
    }

    public void setSSPRSettlementConfigLineList(List<SSPRSettlementConfigLine> sSPRSettlementConfigLineList) {
        set(PROPERTY_SSPRSETTLEMENTCONFIGLINELIST, sSPRSettlementConfigLineList);
    }

}
