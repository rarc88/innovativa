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
package com.sidesoft.localization.ecuador.withholdings;

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
 * Entity class for entity sswh_form_aux (stored in table sswh_form_aux).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SswhFormAux extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sswh_form_aux";
    public static final String ENTITY_NAME = "sswh_form_aux";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_FATHERCODE = "fatherCode";
    public static final String PROPERTY_BASEAMOUNT = "baseamount";
    public static final String PROPERTY_SONCODE = "sONCode";
    public static final String PROPERTY_TAXAMOUNT = "taxamount";
    public static final String PROPERTY_FORMULA = "formula";
    public static final String PROPERTY_GRANDFATHERCODE = "grandfatherCode";
    public static final String PROPERTY_AMOUNT = "amount";
    public static final String PROPERTY_LINE = "line";
    public static final String PROPERTY_FORMULASON = "formulaSon";
    public static final String PROPERTY_FORMULAGF = "formulaGf";

    public SswhFormAux() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_BASEAMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_TAXAMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_AMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_LINE, (long) 10);
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

    public String getFatherCode() {
        return (String) get(PROPERTY_FATHERCODE);
    }

    public void setFatherCode(String fatherCode) {
        set(PROPERTY_FATHERCODE, fatherCode);
    }

    public BigDecimal getBaseamount() {
        return (BigDecimal) get(PROPERTY_BASEAMOUNT);
    }

    public void setBaseamount(BigDecimal baseamount) {
        set(PROPERTY_BASEAMOUNT, baseamount);
    }

    public String getSONCode() {
        return (String) get(PROPERTY_SONCODE);
    }

    public void setSONCode(String sONCode) {
        set(PROPERTY_SONCODE, sONCode);
    }

    public BigDecimal getTaxamount() {
        return (BigDecimal) get(PROPERTY_TAXAMOUNT);
    }

    public void setTaxamount(BigDecimal taxamount) {
        set(PROPERTY_TAXAMOUNT, taxamount);
    }

    public String getFormula() {
        return (String) get(PROPERTY_FORMULA);
    }

    public void setFormula(String formula) {
        set(PROPERTY_FORMULA, formula);
    }

    public String getGrandfatherCode() {
        return (String) get(PROPERTY_GRANDFATHERCODE);
    }

    public void setGrandfatherCode(String grandfatherCode) {
        set(PROPERTY_GRANDFATHERCODE, grandfatherCode);
    }

    public BigDecimal getAmount() {
        return (BigDecimal) get(PROPERTY_AMOUNT);
    }

    public void setAmount(BigDecimal amount) {
        set(PROPERTY_AMOUNT, amount);
    }

    public Long getLine() {
        return (Long) get(PROPERTY_LINE);
    }

    public void setLine(Long line) {
        set(PROPERTY_LINE, line);
    }

    public String getFormulaSon() {
        return (String) get(PROPERTY_FORMULASON);
    }

    public void setFormulaSon(String formulaSon) {
        set(PROPERTY_FORMULASON, formulaSon);
    }

    public String getFormulaGf() {
        return (String) get(PROPERTY_FORMULAGF);
    }

    public void setFormulaGf(String formulaGf) {
        set(PROPERTY_FORMULAGF, formulaGf);
    }

}
