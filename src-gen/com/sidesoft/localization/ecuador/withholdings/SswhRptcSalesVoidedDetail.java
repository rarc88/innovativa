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
 * Entity class for entity Sswh_Rptc_SalesVoided (stored in table Sswh_Rptc_SalesVoided).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SswhRptcSalesVoidedDetail extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "Sswh_Rptc_SalesVoided";
    public static final String ENTITY_NAME = "Sswh_Rptc_SalesVoided";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_TIPOIDENTIFICADOR = "tipoIdentificador";
    public static final String PROPERTY_ESTABLECIMIENTO = "establecimiento";
    public static final String PROPERTY_PUNTOEMISION = "puntoEmision";
    public static final String PROPERTY_SECUENCIAINICIO = "secuenciaInicio";
    public static final String PROPERTY_SECUENCIAFINAL = "secuenciaFinal";
    public static final String PROPERTY_AUTORIZACION = "autorizacion";
    public static final String PROPERTY_ACCOUNTINGDATE = "accountingDate";
    public static final String PROPERTY_PROCESS = "process";

    public SswhRptcSalesVoidedDetail() {
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

    public String getTipoIdentificador() {
        return (String) get(PROPERTY_TIPOIDENTIFICADOR);
    }

    public void setTipoIdentificador(String tipoIdentificador) {
        set(PROPERTY_TIPOIDENTIFICADOR, tipoIdentificador);
    }

    public String getEstablecimiento() {
        return (String) get(PROPERTY_ESTABLECIMIENTO);
    }

    public void setEstablecimiento(String establecimiento) {
        set(PROPERTY_ESTABLECIMIENTO, establecimiento);
    }

    public String getPuntoEmision() {
        return (String) get(PROPERTY_PUNTOEMISION);
    }

    public void setPuntoEmision(String puntoEmision) {
        set(PROPERTY_PUNTOEMISION, puntoEmision);
    }

    public String getSecuenciaInicio() {
        return (String) get(PROPERTY_SECUENCIAINICIO);
    }

    public void setSecuenciaInicio(String secuenciaInicio) {
        set(PROPERTY_SECUENCIAINICIO, secuenciaInicio);
    }

    public String getSecuenciaFinal() {
        return (String) get(PROPERTY_SECUENCIAFINAL);
    }

    public void setSecuenciaFinal(String secuenciaFinal) {
        set(PROPERTY_SECUENCIAFINAL, secuenciaFinal);
    }

    public String getAutorizacion() {
        return (String) get(PROPERTY_AUTORIZACION);
    }

    public void setAutorizacion(String autorizacion) {
        set(PROPERTY_AUTORIZACION, autorizacion);
    }

    public Date getAccountingDate() {
        return (Date) get(PROPERTY_ACCOUNTINGDATE);
    }

    public void setAccountingDate(Date accountingDate) {
        set(PROPERTY_ACCOUNTINGDATE, accountingDate);
    }

    public String getProcess() {
        return (String) get(PROPERTY_PROCESS);
    }

    public void setProcess(String process) {
        set(PROPERTY_PROCESS, process);
    }

}
