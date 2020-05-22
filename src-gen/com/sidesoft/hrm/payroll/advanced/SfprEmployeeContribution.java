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
package com.sidesoft.hrm.payroll.advanced;

import com.sidesoft.hrm.payroll.Concept;

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
 * Entity class for entity sfpr_employee_contribution (stored in table sfpr_employee_contribution).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SfprEmployeeContribution extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sfpr_employee_contribution";
    public static final String ENTITY_NAME = "sfpr_employee_contribution";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_COMMERCIALNAME = "commercialName";
    public static final String PROPERTY_PERSONALCONCEPT = "personalConcept";
    public static final String PROPERTY_PERSONAL = "personal";
    public static final String PROPERTY_CONCEPTBOSSES = "conceptBosses";
    public static final String PROPERTY_PORCBOSSES = "porcBosses";
    public static final String PROPERTY_TOTALINCOMECONCEPT = "totalIncomeConcept";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_ISLABORALREGIMEN = "isLaboralRegimen";
    public static final String PROPERTY_INCOME = "income";

    public SfprEmployeeContribution() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_ISLABORALREGIMEN, false);
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

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
    }

    public String getCommercialName() {
        return (String) get(PROPERTY_COMMERCIALNAME);
    }

    public void setCommercialName(String commercialName) {
        set(PROPERTY_COMMERCIALNAME, commercialName);
    }

    public Concept getPersonalConcept() {
        return (Concept) get(PROPERTY_PERSONALCONCEPT);
    }

    public void setPersonalConcept(Concept personalConcept) {
        set(PROPERTY_PERSONALCONCEPT, personalConcept);
    }

    public BigDecimal getPersonal() {
        return (BigDecimal) get(PROPERTY_PERSONAL);
    }

    public void setPersonal(BigDecimal personal) {
        set(PROPERTY_PERSONAL, personal);
    }

    public Concept getConceptBosses() {
        return (Concept) get(PROPERTY_CONCEPTBOSSES);
    }

    public void setConceptBosses(Concept conceptBosses) {
        set(PROPERTY_CONCEPTBOSSES, conceptBosses);
    }

    public BigDecimal getPorcBosses() {
        return (BigDecimal) get(PROPERTY_PORCBOSSES);
    }

    public void setPorcBosses(BigDecimal porcBosses) {
        set(PROPERTY_PORCBOSSES, porcBosses);
    }

    public Concept getTotalIncomeConcept() {
        return (Concept) get(PROPERTY_TOTALINCOMECONCEPT);
    }

    public void setTotalIncomeConcept(Concept totalIncomeConcept) {
        set(PROPERTY_TOTALINCOMECONCEPT, totalIncomeConcept);
    }

    public Boolean isActive() {
        return (Boolean) get(PROPERTY_ACTIVE);
    }

    public void setActive(Boolean active) {
        set(PROPERTY_ACTIVE, active);
    }

    public Boolean isLaboralRegimen() {
        return (Boolean) get(PROPERTY_ISLABORALREGIMEN);
    }

    public void setLaboralRegimen(Boolean isLaboralRegimen) {
        set(PROPERTY_ISLABORALREGIMEN, isLaboralRegimen);
    }

    public Concept getIncome() {
        return (Concept) get(PROPERTY_INCOME);
    }

    public void setIncome(Concept income) {
        set(PROPERTY_INCOME, income);
    }

}
