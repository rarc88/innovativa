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

import com.sidesoft.hrm.payroll.tenth.SSPHTenthSettlementLine;

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
 * Entity class for entity SSPR_Payroll_Ticket_Concept (stored in table SSPR_Payroll_Ticket_Concept).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class PayrollTicketConcept extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "SSPR_Payroll_Ticket_Concept";
    public static final String ENTITY_NAME = "SSPR_Payroll_Ticket_Concept";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_SSPRPAYROLLTICKET = "ssprPayrollTicket";
    public static final String PROPERTY_SSPRCONCEPT = "ssprConcept";
    public static final String PROPERTY_AMOUNT = "amount";
    public static final String PROPERTY_ISINCOMECALCULATED = "isincomecalculated";
    public static final String PROPERTY_ISCUMULATIVE = "iscumulative";
    public static final String PROPERTY_ISPROJECTED = "isprojected";
    public static final String PROPERTY_ISIESS = "isiess";
    public static final String PROPERTY_SSPHEARNED = "ssphEarned";
    public static final String PROPERTY_SSPHTENTHSETTLINE = "ssphTenthSettLine";
    public static final String PROPERTY_VALUECONCEPT = "valueconcept";
    public static final String PROPERTY_REFERENCESETTLEMENT = "referenceSettlement";

    public PayrollTicketConcept() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_AMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_ISINCOMECALCULATED, false);
        setDefaultValue(PROPERTY_ISCUMULATIVE, false);
        setDefaultValue(PROPERTY_ISPROJECTED, false);
        setDefaultValue(PROPERTY_ISIESS, false);
        setDefaultValue(PROPERTY_SSPHEARNED, false);
        setDefaultValue(PROPERTY_VALUECONCEPT, new BigDecimal(0));
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

    public PayrollTicket getSsprPayrollTicket() {
        return (PayrollTicket) get(PROPERTY_SSPRPAYROLLTICKET);
    }

    public void setSsprPayrollTicket(PayrollTicket ssprPayrollTicket) {
        set(PROPERTY_SSPRPAYROLLTICKET, ssprPayrollTicket);
    }

    public Concept getSsprConcept() {
        return (Concept) get(PROPERTY_SSPRCONCEPT);
    }

    public void setSsprConcept(Concept ssprConcept) {
        set(PROPERTY_SSPRCONCEPT, ssprConcept);
    }

    public BigDecimal getAmount() {
        return (BigDecimal) get(PROPERTY_AMOUNT);
    }

    public void setAmount(BigDecimal amount) {
        set(PROPERTY_AMOUNT, amount);
    }

    public Boolean isIncomecalculated() {
        return (Boolean) get(PROPERTY_ISINCOMECALCULATED);
    }

    public void setIncomecalculated(Boolean isincomecalculated) {
        set(PROPERTY_ISINCOMECALCULATED, isincomecalculated);
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

    public void setProjected(Boolean isprojected) {
        set(PROPERTY_ISPROJECTED, isprojected);
    }

    public Boolean isIess() {
        return (Boolean) get(PROPERTY_ISIESS);
    }

    public void setIess(Boolean isiess) {
        set(PROPERTY_ISIESS, isiess);
    }

    public Boolean isSsphEarned() {
        return (Boolean) get(PROPERTY_SSPHEARNED);
    }

    public void setSsphEarned(Boolean ssphEarned) {
        set(PROPERTY_SSPHEARNED, ssphEarned);
    }

    public SSPHTenthSettlementLine getSsphTenthSettLine() {
        return (SSPHTenthSettlementLine) get(PROPERTY_SSPHTENTHSETTLINE);
    }

    public void setSsphTenthSettLine(SSPHTenthSettlementLine ssphTenthSettLine) {
        set(PROPERTY_SSPHTENTHSETTLINE, ssphTenthSettLine);
    }

    public BigDecimal getValueconcept() {
        return (BigDecimal) get(PROPERTY_VALUECONCEPT);
    }

    public void setValueconcept(BigDecimal valueconcept) {
        set(PROPERTY_VALUECONCEPT, valueconcept);
    }

    public String getReferenceSettlement() {
        return (String) get(PROPERTY_REFERENCESETTLEMENT);
    }

    public void setReferenceSettlement(String referenceSettlement) {
        set(PROPERTY_REFERENCESETTLEMENT, referenceSettlement);
    }

}
