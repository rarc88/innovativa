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
/**
 * Entity class for entity sspr_settlementdata (stored in table sspr_settlementdata).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class sspr_settlementdata extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sspr_settlementdata";
    public static final String ENTITY_NAME = "sspr_settlementdata";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_SSPRSETTLEMENT = "ssprSettlement";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_LINENO = "lineNo";
    public static final String PROPERTY_CONCEPT = "concept";
    public static final String PROPERTY_AMOUNT = "amount";
    public static final String PROPERTY_QUANTITY = "quantity";
    public static final String PROPERTY_TOTALNET = "totalNet";
    public static final String PROPERTY_PAYROLL = "payroll";
    public static final String PROPERTY_ISINCOMECALCULATED = "isIncomeCalculated";
    public static final String PROPERTY_ISCUMULATIVE = "isCumulative";
    public static final String PROPERTY_ISPROJECTED = "isProjected";
    public static final String PROPERTY_ISIESS = "isIess";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_DISPLAY = "display";

    public sspr_settlementdata() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_AMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_QUANTITY, new BigDecimal(0));
        setDefaultValue(PROPERTY_TOTALNET, new BigDecimal(0));
        setDefaultValue(PROPERTY_ISINCOMECALCULATED, false);
        setDefaultValue(PROPERTY_ISCUMULATIVE, false);
        setDefaultValue(PROPERTY_ISPROJECTED, false);
        setDefaultValue(PROPERTY_ISIESS, false);
        setDefaultValue(PROPERTY_DISPLAY, "Y");
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

    public sspr_settlement getSsprSettlement() {
        return (sspr_settlement) get(PROPERTY_SSPRSETTLEMENT);
    }

    public void setSsprSettlement(sspr_settlement ssprSettlement) {
        set(PROPERTY_SSPRSETTLEMENT, ssprSettlement);
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

    public BigDecimal getAmount() {
        return (BigDecimal) get(PROPERTY_AMOUNT);
    }

    public void setAmount(BigDecimal amount) {
        set(PROPERTY_AMOUNT, amount);
    }

    public BigDecimal getQuantity() {
        return (BigDecimal) get(PROPERTY_QUANTITY);
    }

    public void setQuantity(BigDecimal quantity) {
        set(PROPERTY_QUANTITY, quantity);
    }

    public BigDecimal getTotalNet() {
        return (BigDecimal) get(PROPERTY_TOTALNET);
    }

    public void setTotalNet(BigDecimal totalNet) {
        set(PROPERTY_TOTALNET, totalNet);
    }

    public Payroll getPayroll() {
        return (Payroll) get(PROPERTY_PAYROLL);
    }

    public void setPayroll(Payroll payroll) {
        set(PROPERTY_PAYROLL, payroll);
    }

    public Boolean isIncomeCalculated() {
        return (Boolean) get(PROPERTY_ISINCOMECALCULATED);
    }

    public void setIncomeCalculated(Boolean isIncomeCalculated) {
        set(PROPERTY_ISINCOMECALCULATED, isIncomeCalculated);
    }

    public Boolean isCumulative() {
        return (Boolean) get(PROPERTY_ISCUMULATIVE);
    }

    public void setCumulative(Boolean isCumulative) {
        set(PROPERTY_ISCUMULATIVE, isCumulative);
    }

    public Boolean isProjected() {
        return (Boolean) get(PROPERTY_ISPROJECTED);
    }

    public void setProjected(Boolean isProjected) {
        set(PROPERTY_ISPROJECTED, isProjected);
    }

    public Boolean isIess() {
        return (Boolean) get(PROPERTY_ISIESS);
    }

    public void setIess(Boolean isIess) {
        set(PROPERTY_ISIESS, isIess);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public String getDisplay() {
        return (String) get(PROPERTY_DISPLAY);
    }

    public void setDisplay(String display) {
        set(PROPERTY_DISPLAY, display);
    }

}
