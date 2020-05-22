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
 * Entity class for entity SSWH_Rpt_Ats_With_Purchase (stored in table SSWH_Rpt_Ats_With_Purchase).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class RptAtsWithPurchase extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "SSWH_Rpt_Ats_With_Purchase";
    public static final String ENTITY_NAME = "SSWH_Rpt_Ats_With_Purchase";
    public static final String PROPERTY_LINEA = "linea";
    public static final String PROPERTY_EMPRESA = "empresa";
    public static final String PROPERTY_PLINEA = "plinea";
    public static final String PROPERTY_CODRETAIR = "codretair";
    public static final String PROPERTY_BASE = "base";
    public static final String PROPERTY_PORCENTAJEAIR = "porcentajeair";
    public static final String PROPERTY_VALRETAIR = "valretair";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";

    public RptAtsWithPurchase() {
        setDefaultValue(PROPERTY_ACTIVE, true);
    }

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
    }

    public Long getLinea() {
        return (Long) get(PROPERTY_LINEA);
    }

    public void setLinea(Long linea) {
        set(PROPERTY_LINEA, linea);
    }

    public String getEmpresa() {
        return (String) get(PROPERTY_EMPRESA);
    }

    public void setEmpresa(String empresa) {
        set(PROPERTY_EMPRESA, empresa);
    }

    public Long getPlinea() {
        return (Long) get(PROPERTY_PLINEA);
    }

    public void setPlinea(Long plinea) {
        set(PROPERTY_PLINEA, plinea);
    }

    public String getCodretair() {
        return (String) get(PROPERTY_CODRETAIR);
    }

    public void setCodretair(String codretair) {
        set(PROPERTY_CODRETAIR, codretair);
    }

    public Long getBase() {
        return (Long) get(PROPERTY_BASE);
    }

    public void setBase(Long base) {
        set(PROPERTY_BASE, base);
    }

    public Long getPorcentajeair() {
        return (Long) get(PROPERTY_PORCENTAJEAIR);
    }

    public void setPorcentajeair(Long porcentajeair) {
        set(PROPERTY_PORCENTAJEAIR, porcentajeair);
    }

    public Long getValretair() {
        return (Long) get(PROPERTY_VALRETAIR);
    }

    public void setValretair(Long valretair) {
        set(PROPERTY_VALRETAIR, valretair);
    }

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
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

    public Boolean isActive() {
        return (Boolean) get(PROPERTY_ACTIVE);
    }

    public void setActive(Boolean active) {
        set(PROPERTY_ACTIVE, active);
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
