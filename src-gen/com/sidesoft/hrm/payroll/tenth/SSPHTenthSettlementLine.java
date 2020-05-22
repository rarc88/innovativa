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
package com.sidesoft.hrm.payroll.tenth;

import com.sidesoft.hrm.payroll.LaborRegime;
import com.sidesoft.hrm.payroll.PayrollTicketConcept;

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
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.Organization;
/**
 * Entity class for entity SSPH_Tenth_Settlement_Line (stored in table SSPH_Tenth_Settlement_Line).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SSPHTenthSettlementLine extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "SSPH_Tenth_Settlement_Line";
    public static final String ENTITY_NAME = "SSPH_Tenth_Settlement_Line";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_SSPHTENTHSETTLEMENT = "ssphTenthSettlement";
    public static final String PROPERTY_LINENO = "lineNo";
    public static final String PROPERTY_EMPLOYEE = "employee";
    public static final String PROPERTY_LINENETAMOUNT = "lineNetAmount";
    public static final String PROPERTY_LABORREGIME = "laborRegime";
    public static final String PROPERTY_ADJUSTMENTAMOUNT = "adjustmentAmount";
    public static final String PROPERTY_ADJUSTEDAMOUNT = "adjustedAmount";
    public static final String PROPERTY_ADJUSTMENT2AMOUNT = "adjustment2Amount";
    public static final String PROPERTY_CALCULATEAMOUNT = "calculateamount";
    public static final String PROPERTY_DAYSWORKED = "daysworked";
    public static final String PROPERTY_JUDICIALRETENTION = "judicialRetention";
    public static final String PROPERTY_SSPRPAYROLLTICKETCONCEPTEMSSPHTENTHSETTLINEIDLIST = "sSPRPayrollTicketConceptEMSsphTenthSettLineIDList";

    public SSPHTenthSettlementLine() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_ADJUSTMENTAMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_ADJUSTEDAMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_SSPRPAYROLLTICKETCONCEPTEMSSPHTENTHSETTLINEIDLIST, new ArrayList<Object>());
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

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public SSPHTenthSettlement getSsphTenthSettlement() {
        return (SSPHTenthSettlement) get(PROPERTY_SSPHTENTHSETTLEMENT);
    }

    public void setSsphTenthSettlement(SSPHTenthSettlement ssphTenthSettlement) {
        set(PROPERTY_SSPHTENTHSETTLEMENT, ssphTenthSettlement);
    }

    public Long getLineNo() {
        return (Long) get(PROPERTY_LINENO);
    }

    public void setLineNo(Long lineNo) {
        set(PROPERTY_LINENO, lineNo);
    }

    public BusinessPartner getEmployee() {
        return (BusinessPartner) get(PROPERTY_EMPLOYEE);
    }

    public void setEmployee(BusinessPartner employee) {
        set(PROPERTY_EMPLOYEE, employee);
    }

    public BigDecimal getLineNetAmount() {
        return (BigDecimal) get(PROPERTY_LINENETAMOUNT);
    }

    public void setLineNetAmount(BigDecimal lineNetAmount) {
        set(PROPERTY_LINENETAMOUNT, lineNetAmount);
    }

    public LaborRegime getLaborRegime() {
        return (LaborRegime) get(PROPERTY_LABORREGIME);
    }

    public void setLaborRegime(LaborRegime laborRegime) {
        set(PROPERTY_LABORREGIME, laborRegime);
    }

    public BigDecimal getAdjustmentAmount() {
        return (BigDecimal) get(PROPERTY_ADJUSTMENTAMOUNT);
    }

    public void setAdjustmentAmount(BigDecimal adjustmentAmount) {
        set(PROPERTY_ADJUSTMENTAMOUNT, adjustmentAmount);
    }

    public BigDecimal getAdjustedAmount() {
        return (BigDecimal) get(PROPERTY_ADJUSTEDAMOUNT);
    }

    public void setAdjustedAmount(BigDecimal adjustedAmount) {
        set(PROPERTY_ADJUSTEDAMOUNT, adjustedAmount);
    }

    public BigDecimal getAdjustment2Amount() {
        return (BigDecimal) get(PROPERTY_ADJUSTMENT2AMOUNT);
    }

    public void setAdjustment2Amount(BigDecimal adjustment2Amount) {
        set(PROPERTY_ADJUSTMENT2AMOUNT, adjustment2Amount);
    }

    public BigDecimal getCalculateamount() {
        return (BigDecimal) get(PROPERTY_CALCULATEAMOUNT);
    }

    public void setCalculateamount(BigDecimal calculateamount) {
        set(PROPERTY_CALCULATEAMOUNT, calculateamount);
    }

    public Long getDaysworked() {
        return (Long) get(PROPERTY_DAYSWORKED);
    }

    public void setDaysworked(Long daysworked) {
        set(PROPERTY_DAYSWORKED, daysworked);
    }

    public BigDecimal getJudicialRetention() {
        return (BigDecimal) get(PROPERTY_JUDICIALRETENTION);
    }

    public void setJudicialRetention(BigDecimal judicialRetention) {
        set(PROPERTY_JUDICIALRETENTION, judicialRetention);
    }

    @SuppressWarnings("unchecked")
    public List<PayrollTicketConcept> getSSPRPayrollTicketConceptEMSsphTenthSettLineIDList() {
      return (List<PayrollTicketConcept>) get(PROPERTY_SSPRPAYROLLTICKETCONCEPTEMSSPHTENTHSETTLINEIDLIST);
    }

    public void setSSPRPayrollTicketConceptEMSsphTenthSettLineIDList(List<PayrollTicketConcept> sSPRPayrollTicketConceptEMSsphTenthSettLineIDList) {
        set(PROPERTY_SSPRPAYROLLTICKETCONCEPTEMSSPHTENTHSETTLINEIDLIST, sSPRPayrollTicketConceptEMSsphTenthSettLineIDList);
    }

}
