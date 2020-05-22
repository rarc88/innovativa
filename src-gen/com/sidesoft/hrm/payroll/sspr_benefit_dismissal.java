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
 * Entity class for entity sspr_benefit_dismissal (stored in table sspr_benefit_dismissal).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class sspr_benefit_dismissal extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sspr_benefit_dismissal";
    public static final String ENTITY_NAME = "sspr_benefit_dismissal";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_LINENO = "lineNo";
    public static final String PROPERTY_CONCEPT = "concept";
    public static final String PROPERTY_VALUEIESSRATE = "valueIESSRate";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_RATE = "rate";
    public static final String PROPERTY_PERYEAR = "perYear";
    public static final String PROPERTY_FULLYEAR = "fullYear";
    public static final String PROPERTY_MAXVALUE = "maxValue";
    public static final String PROPERTY_NAMEIESSRATE = "nameIESSRate";
    public static final String PROPERTY_SSPRSETTLEMENTCONFIGLINELIST = "sSPRSettlementConfigLineList";

    public sspr_benefit_dismissal() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_RATE, new BigDecimal(1));
        setDefaultValue(PROPERTY_PERYEAR, false);
        setDefaultValue(PROPERTY_FULLYEAR, false);
        setDefaultValue(PROPERTY_MAXVALUE, false);
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

    public Long getLineNo() {
        return (Long) get(PROPERTY_LINENO);
    }

    public void setLineNo(Long lineNo) {
        set(PROPERTY_LINENO, lineNo);
    }

    public Concept getConcept() {
        return (Concept) get(PROPERTY_CONCEPT);
    }

    public void setConcept(Concept concept) {
        set(PROPERTY_CONCEPT, concept);
    }

    public String getValueIESSRate() {
        return (String) get(PROPERTY_VALUEIESSRATE);
    }

    public void setValueIESSRate(String valueIESSRate) {
        set(PROPERTY_VALUEIESSRATE, valueIESSRate);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public BigDecimal getRate() {
        return (BigDecimal) get(PROPERTY_RATE);
    }

    public void setRate(BigDecimal rate) {
        set(PROPERTY_RATE, rate);
    }

    public Boolean isPerYear() {
        return (Boolean) get(PROPERTY_PERYEAR);
    }

    public void setPerYear(Boolean perYear) {
        set(PROPERTY_PERYEAR, perYear);
    }

    public Boolean isFullYear() {
        return (Boolean) get(PROPERTY_FULLYEAR);
    }

    public void setFullYear(Boolean fullYear) {
        set(PROPERTY_FULLYEAR, fullYear);
    }

    public Boolean isMaxValue() {
        return (Boolean) get(PROPERTY_MAXVALUE);
    }

    public void setMaxValue(Boolean maxValue) {
        set(PROPERTY_MAXVALUE, maxValue);
    }

    public String getNameIESSRate() {
        return (String) get(PROPERTY_NAMEIESSRATE);
    }

    public void setNameIESSRate(String nameIESSRate) {
        set(PROPERTY_NAMEIESSRATE, nameIESSRate);
    }

    @SuppressWarnings("unchecked")
    public List<SSPRSettlementConfigLine> getSSPRSettlementConfigLineList() {
      return (List<SSPRSettlementConfigLine>) get(PROPERTY_SSPRSETTLEMENTCONFIGLINELIST);
    }

    public void setSSPRSettlementConfigLineList(List<SSPRSettlementConfigLine> sSPRSettlementConfigLineList) {
        set(PROPERTY_SSPRSETTLEMENTCONFIGLINELIST, sSPRSettlementConfigLineList);
    }

}
