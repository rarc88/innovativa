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
 * Entity class for entity sspr_codeformulary107 (stored in table sspr_codeformulary107).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ssprcodeformulary107 extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sspr_codeformulary107";
    public static final String ENTITY_NAME = "sspr_codeformulary107";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_VALUE = "value";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_SSPHEARNED = "sSPHEarned";
    public static final String PROPERTY_TYPECONCEPTFORMULARY = "typeConceptFormulary";
    public static final String PROPERTY_SSPHTENTHSETTLEMENTEMSSPRCODEFORMULARY107IDLIST = "sSPHTenthSettlementEMSsprCodeformulary107IDList";
    public static final String PROPERTY_SSPRCONCEPTLIST = "sSPRConceptList";
    public static final String PROPERTY_SSPRCONFIGURATIONUTILITYLIST = "ssprConfigurationutilityList";
    public static final String PROPERTY_SSPRCOSTEMPLOYEELINELIST = "ssprCostemployeelineList";
    public static final String PROPERTY_SSPRFORMULARYLINE107LIST = "ssprFormularyline107List";
    public static final String PROPERTY_SSPRUTILITIESLIST = "ssprUtilitiesList";

    public ssprcodeformulary107() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_SSPHEARNED, false);
        setDefaultValue(PROPERTY_SSPHTENTHSETTLEMENTEMSSPRCODEFORMULARY107IDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRCONCEPTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRCONFIGURATIONUTILITYLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRCOSTEMPLOYEELINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRFORMULARYLINE107LIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRUTILITIESLIST, new ArrayList<Object>());
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

    public String getValue() {
        return (String) get(PROPERTY_VALUE);
    }

    public void setValue(String value) {
        set(PROPERTY_VALUE, value);
    }

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public Boolean isSSPHEarned() {
        return (Boolean) get(PROPERTY_SSPHEARNED);
    }

    public void setSSPHEarned(Boolean sSPHEarned) {
        set(PROPERTY_SSPHEARNED, sSPHEarned);
    }

    public String getTypeConceptFormulary() {
        return (String) get(PROPERTY_TYPECONCEPTFORMULARY);
    }

    public void setTypeConceptFormulary(String typeConceptFormulary) {
        set(PROPERTY_TYPECONCEPTFORMULARY, typeConceptFormulary);
    }

    @SuppressWarnings("unchecked")
    public List<SSPHTenthSettlement> getSSPHTenthSettlementEMSsprCodeformulary107IDList() {
      return (List<SSPHTenthSettlement>) get(PROPERTY_SSPHTENTHSETTLEMENTEMSSPRCODEFORMULARY107IDLIST);
    }

    public void setSSPHTenthSettlementEMSsprCodeformulary107IDList(List<SSPHTenthSettlement> sSPHTenthSettlementEMSsprCodeformulary107IDList) {
        set(PROPERTY_SSPHTENTHSETTLEMENTEMSSPRCODEFORMULARY107IDLIST, sSPHTenthSettlementEMSsprCodeformulary107IDList);
    }

    @SuppressWarnings("unchecked")
    public List<Concept> getSSPRConceptList() {
      return (List<Concept>) get(PROPERTY_SSPRCONCEPTLIST);
    }

    public void setSSPRConceptList(List<Concept> sSPRConceptList) {
        set(PROPERTY_SSPRCONCEPTLIST, sSPRConceptList);
    }

    @SuppressWarnings("unchecked")
    public List<SsprConfigurationUtility> getSsprConfigurationutilityList() {
      return (List<SsprConfigurationUtility>) get(PROPERTY_SSPRCONFIGURATIONUTILITYLIST);
    }

    public void setSsprConfigurationutilityList(List<SsprConfigurationUtility> ssprConfigurationutilityList) {
        set(PROPERTY_SSPRCONFIGURATIONUTILITYLIST, ssprConfigurationutilityList);
    }

    @SuppressWarnings("unchecked")
    public List<CostEmployeeline> getSsprCostemployeelineList() {
      return (List<CostEmployeeline>) get(PROPERTY_SSPRCOSTEMPLOYEELINELIST);
    }

    public void setSsprCostemployeelineList(List<CostEmployeeline> ssprCostemployeelineList) {
        set(PROPERTY_SSPRCOSTEMPLOYEELINELIST, ssprCostemployeelineList);
    }

    @SuppressWarnings("unchecked")
    public List<ssprformularyline107> getSsprFormularyline107List() {
      return (List<ssprformularyline107>) get(PROPERTY_SSPRFORMULARYLINE107LIST);
    }

    public void setSsprFormularyline107List(List<ssprformularyline107> ssprFormularyline107List) {
        set(PROPERTY_SSPRFORMULARYLINE107LIST, ssprFormularyline107List);
    }

    @SuppressWarnings("unchecked")
    public List<ssprutilities> getSsprUtilitiesList() {
      return (List<ssprutilities>) get(PROPERTY_SSPRUTILITIESLIST);
    }

    public void setSsprUtilitiesList(List<ssprutilities> ssprUtilitiesList) {
        set(PROPERTY_SSPRUTILITIESLIST, ssprUtilitiesList);
    }

}
