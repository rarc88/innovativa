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
 * All portions are Copyright (C) 2013-2017 Openbravo SLU
 * All Rights Reserved.
 * Contributor(s):  ______________________________________.
 ************************************************************************
*/
package com.sidesoft.flopec.budget.data;

import java.math.BigDecimal;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
/**
 * Virtual entity class to hold computed columns for entity sfb_budget_line.
 *
 * NOTE: This class should not be instantiated directly.
 */
public class SFBBudgetLine_ComputedColumns extends BaseOBObject implements ClientEnabled , OrganizationEnabled {
    private static final long serialVersionUID = 1L;
    public static final String ENTITY_NAME = "SFBBudgetLine_ComputedColumns";
    
    public static final String PROPERTY_REFORMS = "reforms";
    public static final String PROPERTY_COMMITMENTS = "commitments";
    public static final String PROPERTY_FORCOMPROMISING = "fORCompromising";
    public static final String PROPERTY_VALUETOEXECUTE = "valuetoexecute";
    public static final String PROPERTY_TYPEOFBUDGET = "typeOfBudget";
    public static final String PROPERTY_VERSIONSTATUS = "versionStatus";
    public static final String PROPERTY_YEAR = "year";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
    }

    public BigDecimal getReforms() {
      return (BigDecimal) get(PROPERTY_REFORMS);
    }

    public void setReforms(BigDecimal reforms) {
      set(PROPERTY_REFORMS, reforms);
    }
    public BigDecimal getCommitments() {
      return (BigDecimal) get(PROPERTY_COMMITMENTS);
    }

    public void setCommitments(BigDecimal commitments) {
      set(PROPERTY_COMMITMENTS, commitments);
    }
    public BigDecimal getFORCompromising() {
      return (BigDecimal) get(PROPERTY_FORCOMPROMISING);
    }

    public void setFORCompromising(BigDecimal fORCompromising) {
      set(PROPERTY_FORCOMPROMISING, fORCompromising);
    }
    public BigDecimal getValuetoexecute() {
      return (BigDecimal) get(PROPERTY_VALUETOEXECUTE);
    }

    public void setValuetoexecute(BigDecimal valuetoexecute) {
      set(PROPERTY_VALUETOEXECUTE, valuetoexecute);
    }
    public String getTypeOfBudget() {
      return (String) get(PROPERTY_TYPEOFBUDGET);
    }

    public void setTypeOfBudget(String typeOfBudget) {
      set(PROPERTY_TYPEOFBUDGET, typeOfBudget);
    }
    public String getVersionStatus() {
      return (String) get(PROPERTY_VERSIONSTATUS);
    }

    public void setVersionStatus(String versionStatus) {
      set(PROPERTY_VERSIONSTATUS, versionStatus);
    }
    public String getYear() {
      return (String) get(PROPERTY_YEAR);
    }

    public void setYear(String year) {
      set(PROPERTY_YEAR, year);
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
}
