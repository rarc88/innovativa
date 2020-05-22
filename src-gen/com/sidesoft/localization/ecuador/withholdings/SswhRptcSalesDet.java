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
import org.openbravo.model.financialmgmt.calendar.Period;
/**
 * Entity class for entity Sswh_Rptc_SalesDet (stored in table Sswh_Rptc_SalesDet).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SswhRptcSalesDet extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "Sswh_Rptc_SalesDet";
    public static final String ENTITY_NAME = "Sswh_Rptc_SalesDet";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_TIPOIDENTIFICADOR = "tipoIdentificador";
    public static final String PROPERTY_IDENTIFCLIENTE = "identifCliente";
    public static final String PROPERTY_CODTIPOCOMPROBANTE = "cODTipoComprobante";
    public static final String PROPERTY_COUNT = "count";
    public static final String PROPERTY_BASENOIVA = "baseNoIva";
    public static final String PROPERTY_BASEIVACERO = "baseIvaCero";
    public static final String PROPERTY_BASEIVADOCE = "baseIvaDoce";
    public static final String PROPERTY_MONTOIVA = "montoIva";
    public static final String PROPERTY_MONTORETIVA = "montoRetIva";
    public static final String PROPERTY_MONTORETRENTA = "montoRetRenta";
    public static final String PROPERTY_PERIOD = "period";
    public static final String PROPERTY_POSTED = "posted";
    public static final String PROPERTY_PARTERELACIONADA = "parteRelacionada";
    public static final String PROPERTY_MONTOICE = "montoice";
    public static final String PROPERTY_TIPOCONTRIB = "tipoContrib";
    public static final String PROPERTY_DENOCLI = "denoCli";
    public static final String PROPERTY_TIPOEM = "tipoEm";
    public static final String PROPERTY_PROCESS = "process";

    public SswhRptcSalesDet() {
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

    public String getIdentifCliente() {
        return (String) get(PROPERTY_IDENTIFCLIENTE);
    }

    public void setIdentifCliente(String identifCliente) {
        set(PROPERTY_IDENTIFCLIENTE, identifCliente);
    }

    public String getCODTipoComprobante() {
        return (String) get(PROPERTY_CODTIPOCOMPROBANTE);
    }

    public void setCODTipoComprobante(String cODTipoComprobante) {
        set(PROPERTY_CODTIPOCOMPROBANTE, cODTipoComprobante);
    }

    public BigDecimal getCount() {
        return (BigDecimal) get(PROPERTY_COUNT);
    }

    public void setCount(BigDecimal count) {
        set(PROPERTY_COUNT, count);
    }

    public BigDecimal getBaseNoIva() {
        return (BigDecimal) get(PROPERTY_BASENOIVA);
    }

    public void setBaseNoIva(BigDecimal baseNoIva) {
        set(PROPERTY_BASENOIVA, baseNoIva);
    }

    public BigDecimal getBaseIvaCero() {
        return (BigDecimal) get(PROPERTY_BASEIVACERO);
    }

    public void setBaseIvaCero(BigDecimal baseIvaCero) {
        set(PROPERTY_BASEIVACERO, baseIvaCero);
    }

    public BigDecimal getBaseIvaDoce() {
        return (BigDecimal) get(PROPERTY_BASEIVADOCE);
    }

    public void setBaseIvaDoce(BigDecimal baseIvaDoce) {
        set(PROPERTY_BASEIVADOCE, baseIvaDoce);
    }

    public BigDecimal getMontoIva() {
        return (BigDecimal) get(PROPERTY_MONTOIVA);
    }

    public void setMontoIva(BigDecimal montoIva) {
        set(PROPERTY_MONTOIVA, montoIva);
    }

    public BigDecimal getMontoRetIva() {
        return (BigDecimal) get(PROPERTY_MONTORETIVA);
    }

    public void setMontoRetIva(BigDecimal montoRetIva) {
        set(PROPERTY_MONTORETIVA, montoRetIva);
    }

    public BigDecimal getMontoRetRenta() {
        return (BigDecimal) get(PROPERTY_MONTORETRENTA);
    }

    public void setMontoRetRenta(BigDecimal montoRetRenta) {
        set(PROPERTY_MONTORETRENTA, montoRetRenta);
    }

    public Period getPeriod() {
        return (Period) get(PROPERTY_PERIOD);
    }

    public void setPeriod(Period period) {
        set(PROPERTY_PERIOD, period);
    }

    public String getPosted() {
        return (String) get(PROPERTY_POSTED);
    }

    public void setPosted(String posted) {
        set(PROPERTY_POSTED, posted);
    }

    public String getParteRelacionada() {
        return (String) get(PROPERTY_PARTERELACIONADA);
    }

    public void setParteRelacionada(String parteRelacionada) {
        set(PROPERTY_PARTERELACIONADA, parteRelacionada);
    }

    public BigDecimal getMontoice() {
        return (BigDecimal) get(PROPERTY_MONTOICE);
    }

    public void setMontoice(BigDecimal montoice) {
        set(PROPERTY_MONTOICE, montoice);
    }

    public String getTipoContrib() {
        return (String) get(PROPERTY_TIPOCONTRIB);
    }

    public void setTipoContrib(String tipoContrib) {
        set(PROPERTY_TIPOCONTRIB, tipoContrib);
    }

    public String getDenoCli() {
        return (String) get(PROPERTY_DENOCLI);
    }

    public void setDenoCli(String denoCli) {
        set(PROPERTY_DENOCLI, denoCli);
    }

    public String getTipoEm() {
        return (String) get(PROPERTY_TIPOEM);
    }

    public void setTipoEm(String tipoEm) {
        set(PROPERTY_TIPOEM, tipoEm);
    }

    public String getProcess() {
        return (String) get(PROPERTY_PROCESS);
    }

    public void setProcess(String process) {
        set(PROPERTY_PROCESS, process);
    }

}
