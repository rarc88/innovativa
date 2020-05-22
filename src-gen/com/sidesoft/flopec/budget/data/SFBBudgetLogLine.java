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
package com.sidesoft.flopec.budget.data;

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
 * Entity class for entity SFB_Budget_Log_Line (stored in table SFB_Budget_Log_Line).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SFBBudgetLogLine extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "SFB_Budget_Log_Line";
    public static final String ENTITY_NAME = "SFB_Budget_Log_Line";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_BUDGETLINE = "budgetLine";
    public static final String PROPERTY_LINENO = "lineNo";
    public static final String PROPERTY_JANUARYNEWADJUSTEDVALUE = "januaryNewAdjustedValue";
    public static final String PROPERTY_FEBRUARYNEWADJUSTEDVALUE = "februaryNewAdjustedValue";
    public static final String PROPERTY_MARCHNEWADJUSTEDVALUE = "marchNewAdjustedValue";
    public static final String PROPERTY_APRILNEWADJUSTEDVALUE = "aprilNewAdjustedValue";
    public static final String PROPERTY_MAYNEWADJUSTEDVALUE = "mayNewAdjustedValue";
    public static final String PROPERTY_JUNENEWADJUSTEDVALUE = "juneNewAdjustedValue";
    public static final String PROPERTY_JULYNEWADJUSTEDVALUE = "julyNewAdjustedValue";
    public static final String PROPERTY_AUGUSTNEWADJUSTEDVALUE = "augustNewAdjustedValue";
    public static final String PROPERTY_SEPTEMBERNEWADJUSTEDVALUE = "septemberNewAdjustedValue";
    public static final String PROPERTY_OCTOBERNEWADJUSTEDVALUE = "octoberNewAdjustedValue";
    public static final String PROPERTY_NOVEMBERNEWADJUSTEDVALUE = "novemberNewAdjustedValue";
    public static final String PROPERTY_DECEMBERNEWADJUSTEDVALUE = "decemberNewAdjustedValue";
    public static final String PROPERTY_JANUARYADJUSTEDVALUE = "januaryAdjustedValue";
    public static final String PROPERTY_FEBRUARYADJUSTEDVALUE = "februaryAdjustedValue";
    public static final String PROPERTY_MARCHADJUSTEDVALUE = "marchAdjustedValue";
    public static final String PROPERTY_APRILADJUSTEDVALUE = "aprilAdjustedValue";
    public static final String PROPERTY_MAYADJUSTEDVALUE = "mayAdjustedValue";
    public static final String PROPERTY_JUNEADJUSTEDVALUE = "juneAdjustedValue";
    public static final String PROPERTY_JULYADJUSTEDVALUE = "julyAdjustedValue";
    public static final String PROPERTY_AUGUSTADJUSTEDVALUE = "augustAdjustedValue";
    public static final String PROPERTY_SEPTEMBERADJUSTEDVALUE = "septemberAdjustedValue";
    public static final String PROPERTY_OCTOBERADJUSTEDVALUE = "octoberAdjustedValue";
    public static final String PROPERTY_NOVEMBERADJUSTEDVALUE = "novemberAdjustedValue";
    public static final String PROPERTY_DECEMBERADJUSTEDVALUE = "decemberAdjustedValue";
    public static final String PROPERTY_BUDGETLOG = "budgetLog";
    public static final String PROPERTY_DIRECTION = "direction";

    public SFBBudgetLogLine() {
        setDefaultValue(PROPERTY_ACTIVE, true);
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

    public SFBBudgetLine getBudgetLine() {
        return (SFBBudgetLine) get(PROPERTY_BUDGETLINE);
    }

    public void setBudgetLine(SFBBudgetLine budgetLine) {
        set(PROPERTY_BUDGETLINE, budgetLine);
    }

    public Long getLineNo() {
        return (Long) get(PROPERTY_LINENO);
    }

    public void setLineNo(Long lineNo) {
        set(PROPERTY_LINENO, lineNo);
    }

    public BigDecimal getJanuaryNewAdjustedValue() {
        return (BigDecimal) get(PROPERTY_JANUARYNEWADJUSTEDVALUE);
    }

    public void setJanuaryNewAdjustedValue(BigDecimal januaryNewAdjustedValue) {
        set(PROPERTY_JANUARYNEWADJUSTEDVALUE, januaryNewAdjustedValue);
    }

    public BigDecimal getFebruaryNewAdjustedValue() {
        return (BigDecimal) get(PROPERTY_FEBRUARYNEWADJUSTEDVALUE);
    }

    public void setFebruaryNewAdjustedValue(BigDecimal februaryNewAdjustedValue) {
        set(PROPERTY_FEBRUARYNEWADJUSTEDVALUE, februaryNewAdjustedValue);
    }

    public BigDecimal getMarchNewAdjustedValue() {
        return (BigDecimal) get(PROPERTY_MARCHNEWADJUSTEDVALUE);
    }

    public void setMarchNewAdjustedValue(BigDecimal marchNewAdjustedValue) {
        set(PROPERTY_MARCHNEWADJUSTEDVALUE, marchNewAdjustedValue);
    }

    public BigDecimal getAprilNewAdjustedValue() {
        return (BigDecimal) get(PROPERTY_APRILNEWADJUSTEDVALUE);
    }

    public void setAprilNewAdjustedValue(BigDecimal aprilNewAdjustedValue) {
        set(PROPERTY_APRILNEWADJUSTEDVALUE, aprilNewAdjustedValue);
    }

    public BigDecimal getMayNewAdjustedValue() {
        return (BigDecimal) get(PROPERTY_MAYNEWADJUSTEDVALUE);
    }

    public void setMayNewAdjustedValue(BigDecimal mayNewAdjustedValue) {
        set(PROPERTY_MAYNEWADJUSTEDVALUE, mayNewAdjustedValue);
    }

    public BigDecimal getJuneNewAdjustedValue() {
        return (BigDecimal) get(PROPERTY_JUNENEWADJUSTEDVALUE);
    }

    public void setJuneNewAdjustedValue(BigDecimal juneNewAdjustedValue) {
        set(PROPERTY_JUNENEWADJUSTEDVALUE, juneNewAdjustedValue);
    }

    public BigDecimal getJulyNewAdjustedValue() {
        return (BigDecimal) get(PROPERTY_JULYNEWADJUSTEDVALUE);
    }

    public void setJulyNewAdjustedValue(BigDecimal julyNewAdjustedValue) {
        set(PROPERTY_JULYNEWADJUSTEDVALUE, julyNewAdjustedValue);
    }

    public BigDecimal getAugustNewAdjustedValue() {
        return (BigDecimal) get(PROPERTY_AUGUSTNEWADJUSTEDVALUE);
    }

    public void setAugustNewAdjustedValue(BigDecimal augustNewAdjustedValue) {
        set(PROPERTY_AUGUSTNEWADJUSTEDVALUE, augustNewAdjustedValue);
    }

    public BigDecimal getSeptemberNewAdjustedValue() {
        return (BigDecimal) get(PROPERTY_SEPTEMBERNEWADJUSTEDVALUE);
    }

    public void setSeptemberNewAdjustedValue(BigDecimal septemberNewAdjustedValue) {
        set(PROPERTY_SEPTEMBERNEWADJUSTEDVALUE, septemberNewAdjustedValue);
    }

    public BigDecimal getOctoberNewAdjustedValue() {
        return (BigDecimal) get(PROPERTY_OCTOBERNEWADJUSTEDVALUE);
    }

    public void setOctoberNewAdjustedValue(BigDecimal octoberNewAdjustedValue) {
        set(PROPERTY_OCTOBERNEWADJUSTEDVALUE, octoberNewAdjustedValue);
    }

    public BigDecimal getNovemberNewAdjustedValue() {
        return (BigDecimal) get(PROPERTY_NOVEMBERNEWADJUSTEDVALUE);
    }

    public void setNovemberNewAdjustedValue(BigDecimal novemberNewAdjustedValue) {
        set(PROPERTY_NOVEMBERNEWADJUSTEDVALUE, novemberNewAdjustedValue);
    }

    public BigDecimal getDecemberNewAdjustedValue() {
        return (BigDecimal) get(PROPERTY_DECEMBERNEWADJUSTEDVALUE);
    }

    public void setDecemberNewAdjustedValue(BigDecimal decemberNewAdjustedValue) {
        set(PROPERTY_DECEMBERNEWADJUSTEDVALUE, decemberNewAdjustedValue);
    }

    public BigDecimal getJanuaryAdjustedValue() {
        return (BigDecimal) get(PROPERTY_JANUARYADJUSTEDVALUE);
    }

    public void setJanuaryAdjustedValue(BigDecimal januaryAdjustedValue) {
        set(PROPERTY_JANUARYADJUSTEDVALUE, januaryAdjustedValue);
    }

    public BigDecimal getFebruaryAdjustedValue() {
        return (BigDecimal) get(PROPERTY_FEBRUARYADJUSTEDVALUE);
    }

    public void setFebruaryAdjustedValue(BigDecimal februaryAdjustedValue) {
        set(PROPERTY_FEBRUARYADJUSTEDVALUE, februaryAdjustedValue);
    }

    public BigDecimal getMarchAdjustedValue() {
        return (BigDecimal) get(PROPERTY_MARCHADJUSTEDVALUE);
    }

    public void setMarchAdjustedValue(BigDecimal marchAdjustedValue) {
        set(PROPERTY_MARCHADJUSTEDVALUE, marchAdjustedValue);
    }

    public BigDecimal getAprilAdjustedValue() {
        return (BigDecimal) get(PROPERTY_APRILADJUSTEDVALUE);
    }

    public void setAprilAdjustedValue(BigDecimal aprilAdjustedValue) {
        set(PROPERTY_APRILADJUSTEDVALUE, aprilAdjustedValue);
    }

    public BigDecimal getMayAdjustedValue() {
        return (BigDecimal) get(PROPERTY_MAYADJUSTEDVALUE);
    }

    public void setMayAdjustedValue(BigDecimal mayAdjustedValue) {
        set(PROPERTY_MAYADJUSTEDVALUE, mayAdjustedValue);
    }

    public BigDecimal getJuneAdjustedValue() {
        return (BigDecimal) get(PROPERTY_JUNEADJUSTEDVALUE);
    }

    public void setJuneAdjustedValue(BigDecimal juneAdjustedValue) {
        set(PROPERTY_JUNEADJUSTEDVALUE, juneAdjustedValue);
    }

    public BigDecimal getJulyAdjustedValue() {
        return (BigDecimal) get(PROPERTY_JULYADJUSTEDVALUE);
    }

    public void setJulyAdjustedValue(BigDecimal julyAdjustedValue) {
        set(PROPERTY_JULYADJUSTEDVALUE, julyAdjustedValue);
    }

    public BigDecimal getAugustAdjustedValue() {
        return (BigDecimal) get(PROPERTY_AUGUSTADJUSTEDVALUE);
    }

    public void setAugustAdjustedValue(BigDecimal augustAdjustedValue) {
        set(PROPERTY_AUGUSTADJUSTEDVALUE, augustAdjustedValue);
    }

    public BigDecimal getSeptemberAdjustedValue() {
        return (BigDecimal) get(PROPERTY_SEPTEMBERADJUSTEDVALUE);
    }

    public void setSeptemberAdjustedValue(BigDecimal septemberAdjustedValue) {
        set(PROPERTY_SEPTEMBERADJUSTEDVALUE, septemberAdjustedValue);
    }

    public BigDecimal getOctoberAdjustedValue() {
        return (BigDecimal) get(PROPERTY_OCTOBERADJUSTEDVALUE);
    }

    public void setOctoberAdjustedValue(BigDecimal octoberAdjustedValue) {
        set(PROPERTY_OCTOBERADJUSTEDVALUE, octoberAdjustedValue);
    }

    public BigDecimal getNovemberAdjustedValue() {
        return (BigDecimal) get(PROPERTY_NOVEMBERADJUSTEDVALUE);
    }

    public void setNovemberAdjustedValue(BigDecimal novemberAdjustedValue) {
        set(PROPERTY_NOVEMBERADJUSTEDVALUE, novemberAdjustedValue);
    }

    public BigDecimal getDecemberAdjustedValue() {
        return (BigDecimal) get(PROPERTY_DECEMBERADJUSTEDVALUE);
    }

    public void setDecemberAdjustedValue(BigDecimal decemberAdjustedValue) {
        set(PROPERTY_DECEMBERADJUSTEDVALUE, decemberAdjustedValue);
    }

    public SFBBudgetLog getBudgetLog() {
        return (SFBBudgetLog) get(PROPERTY_BUDGETLOG);
    }

    public void setBudgetLog(SFBBudgetLog budgetLog) {
        set(PROPERTY_BUDGETLOG, budgetLog);
    }

    public String getDirection() {
        return (String) get(PROPERTY_DIRECTION);
    }

    public void setDirection(String direction) {
        set(PROPERTY_DIRECTION, direction);
    }

}
