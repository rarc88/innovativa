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

import com.sidesoft.hrm.payroll.tenth.SSPHTenthSettlement;
import com.sidesoft.hrm.payroll.tenth.SSPHTenthSettlementLine;

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
 * Entity class for entity SSPR_Labor_Regime (stored in table SSPR_Labor_Regime).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class LaborRegime extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "SSPR_Labor_Regime";
    public static final String ENTITY_NAME = "SSPR_Labor_Regime";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_SFPRAMOUNT = "sfprAmount";
    public static final String PROPERTY_SFPRCONCEPT = "sfprConcept";
    public static final String PROPERTY_VACATIONDAYS = "vacationdays";
    public static final String PROPERTY_VACATIONDAYSADD = "vacationdaysAdd";
    public static final String PROPERTY_SSPHTENTHSETTLEMENTLIST = "sSPHTenthSettlementList";
    public static final String PROPERTY_SSPHTENTHSETTLEMENTLINELIST = "sSPHTenthSettlementLineList";
    public static final String PROPERTY_SSPRCONTRACTLIST = "sSPRContractList";
    public static final String PROPERTY_SSPRLABORREGIMEDETAILLIST = "sSPRLaborRegimeDetailList";

    public LaborRegime() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_SFPRAMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_VACATIONDAYS, (long) 0);
        setDefaultValue(PROPERTY_VACATIONDAYSADD, (long) 0);
        setDefaultValue(PROPERTY_SSPHTENTHSETTLEMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPHTENTHSETTLEMENTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRCONTRACTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRLABORREGIMEDETAILLIST, new ArrayList<Object>());
    }

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
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

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
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

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public BigDecimal getSfprAmount() {
        return (BigDecimal) get(PROPERTY_SFPRAMOUNT);
    }

    public void setSfprAmount(BigDecimal sfprAmount) {
        set(PROPERTY_SFPRAMOUNT, sfprAmount);
    }

    public Concept getSfprConcept() {
        return (Concept) get(PROPERTY_SFPRCONCEPT);
    }

    public void setSfprConcept(Concept sfprConcept) {
        set(PROPERTY_SFPRCONCEPT, sfprConcept);
    }

    public Long getVacationdays() {
        return (Long) get(PROPERTY_VACATIONDAYS);
    }

    public void setVacationdays(Long vacationdays) {
        set(PROPERTY_VACATIONDAYS, vacationdays);
    }

    public Long getVacationdaysAdd() {
        return (Long) get(PROPERTY_VACATIONDAYSADD);
    }

    public void setVacationdaysAdd(Long vacationdaysAdd) {
        set(PROPERTY_VACATIONDAYSADD, vacationdaysAdd);
    }

    @SuppressWarnings("unchecked")
    public List<SSPHTenthSettlement> getSSPHTenthSettlementList() {
      return (List<SSPHTenthSettlement>) get(PROPERTY_SSPHTENTHSETTLEMENTLIST);
    }

    public void setSSPHTenthSettlementList(List<SSPHTenthSettlement> sSPHTenthSettlementList) {
        set(PROPERTY_SSPHTENTHSETTLEMENTLIST, sSPHTenthSettlementList);
    }

    @SuppressWarnings("unchecked")
    public List<SSPHTenthSettlementLine> getSSPHTenthSettlementLineList() {
      return (List<SSPHTenthSettlementLine>) get(PROPERTY_SSPHTENTHSETTLEMENTLINELIST);
    }

    public void setSSPHTenthSettlementLineList(List<SSPHTenthSettlementLine> sSPHTenthSettlementLineList) {
        set(PROPERTY_SSPHTENTHSETTLEMENTLINELIST, sSPHTenthSettlementLineList);
    }

    @SuppressWarnings("unchecked")
    public List<Contract> getSSPRContractList() {
      return (List<Contract>) get(PROPERTY_SSPRCONTRACTLIST);
    }

    public void setSSPRContractList(List<Contract> sSPRContractList) {
        set(PROPERTY_SSPRCONTRACTLIST, sSPRContractList);
    }

    @SuppressWarnings("unchecked")
    public List<LaborRegimeDetail> getSSPRLaborRegimeDetailList() {
      return (List<LaborRegimeDetail>) get(PROPERTY_SSPRLABORREGIMEDETAILLIST);
    }

    public void setSSPRLaborRegimeDetailList(List<LaborRegimeDetail> sSPRLaborRegimeDetailList) {
        set(PROPERTY_SSPRLABORREGIMEDETAILLIST, sSPRLaborRegimeDetailList);
    }

}
