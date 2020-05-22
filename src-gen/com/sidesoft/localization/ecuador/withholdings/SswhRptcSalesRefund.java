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
import org.openbravo.model.common.invoice.Invoice;
/**
 * Entity class for entity Sswh_Rptc_SalesRefund (stored in table Sswh_Rptc_SalesRefund).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SswhRptcSalesRefund extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "Sswh_Rptc_SalesRefund";
    public static final String ENTITY_NAME = "Sswh_Rptc_SalesRefund";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_CODIGOCOMPRA = "codigoCompra";
    public static final String PROPERTY_TIPOCOMPREEMB = "tipoCompReemb";
    public static final String PROPERTY_TIPOIDENTIFICADOR = "tipoIdentificador";
    public static final String PROPERTY_IDENTIFICADORPROVEEDOR = "identificadorProveedor";
    public static final String PROPERTY_ESTABLECIMIENTO = "establecimiento";
    public static final String PROPERTY_PUNTOEMISION = "puntoEmision";
    public static final String PROPERTY_SECUENCIAL = "secuencial";
    public static final String PROPERTY_FECHAEMISION = "fechaEmision";
    public static final String PROPERTY_AUTHORIZATION = "authorization";
    public static final String PROPERTY_BASEIMPGRABADA = "baseImpGrabada";
    public static final String PROPERTY_BASEIMPGRABREEM = "baseImpGrabReem";
    public static final String PROPERTY_BASENOGRABIVA = "baseNoGrabIva";
    public static final String PROPERTY_MONTOICE = "montoIce";
    public static final String PROPERTY_MONTORETIVA = "montoRetIva";
    public static final String PROPERTY_ACCOUNTINGDATE = "accountingDate";
    public static final String PROPERTY_BASEEXENTA = "baseExenta";
    public static final String PROPERTY_INVOICE = "invoice";
    public static final String PROPERTY_PROCESS = "process";

    public SswhRptcSalesRefund() {
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

    public String getCodigoCompra() {
        return (String) get(PROPERTY_CODIGOCOMPRA);
    }

    public void setCodigoCompra(String codigoCompra) {
        set(PROPERTY_CODIGOCOMPRA, codigoCompra);
    }

    public String getTipoCompReemb() {
        return (String) get(PROPERTY_TIPOCOMPREEMB);
    }

    public void setTipoCompReemb(String tipoCompReemb) {
        set(PROPERTY_TIPOCOMPREEMB, tipoCompReemb);
    }

    public String getTipoIdentificador() {
        return (String) get(PROPERTY_TIPOIDENTIFICADOR);
    }

    public void setTipoIdentificador(String tipoIdentificador) {
        set(PROPERTY_TIPOIDENTIFICADOR, tipoIdentificador);
    }

    public String getIdentificadorProveedor() {
        return (String) get(PROPERTY_IDENTIFICADORPROVEEDOR);
    }

    public void setIdentificadorProveedor(String identificadorProveedor) {
        set(PROPERTY_IDENTIFICADORPROVEEDOR, identificadorProveedor);
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

    public String getSecuencial() {
        return (String) get(PROPERTY_SECUENCIAL);
    }

    public void setSecuencial(String secuencial) {
        set(PROPERTY_SECUENCIAL, secuencial);
    }

    public Date getFechaEmision() {
        return (Date) get(PROPERTY_FECHAEMISION);
    }

    public void setFechaEmision(Date fechaEmision) {
        set(PROPERTY_FECHAEMISION, fechaEmision);
    }

    public String getAuthorization() {
        return (String) get(PROPERTY_AUTHORIZATION);
    }

    public void setAuthorization(String authorization) {
        set(PROPERTY_AUTHORIZATION, authorization);
    }

    public BigDecimal getBaseImpGrabada() {
        return (BigDecimal) get(PROPERTY_BASEIMPGRABADA);
    }

    public void setBaseImpGrabada(BigDecimal baseImpGrabada) {
        set(PROPERTY_BASEIMPGRABADA, baseImpGrabada);
    }

    public BigDecimal getBaseImpGrabReem() {
        return (BigDecimal) get(PROPERTY_BASEIMPGRABREEM);
    }

    public void setBaseImpGrabReem(BigDecimal baseImpGrabReem) {
        set(PROPERTY_BASEIMPGRABREEM, baseImpGrabReem);
    }

    public BigDecimal getBaseNoGrabIva() {
        return (BigDecimal) get(PROPERTY_BASENOGRABIVA);
    }

    public void setBaseNoGrabIva(BigDecimal baseNoGrabIva) {
        set(PROPERTY_BASENOGRABIVA, baseNoGrabIva);
    }

    public BigDecimal getMontoIce() {
        return (BigDecimal) get(PROPERTY_MONTOICE);
    }

    public void setMontoIce(BigDecimal montoIce) {
        set(PROPERTY_MONTOICE, montoIce);
    }

    public BigDecimal getMontoRetIva() {
        return (BigDecimal) get(PROPERTY_MONTORETIVA);
    }

    public void setMontoRetIva(BigDecimal montoRetIva) {
        set(PROPERTY_MONTORETIVA, montoRetIva);
    }

    public Date getAccountingDate() {
        return (Date) get(PROPERTY_ACCOUNTINGDATE);
    }

    public void setAccountingDate(Date accountingDate) {
        set(PROPERTY_ACCOUNTINGDATE, accountingDate);
    }

    public BigDecimal getBaseExenta() {
        return (BigDecimal) get(PROPERTY_BASEEXENTA);
    }

    public void setBaseExenta(BigDecimal baseExenta) {
        set(PROPERTY_BASEEXENTA, baseExenta);
    }

    public Invoice getInvoice() {
        return (Invoice) get(PROPERTY_INVOICE);
    }

    public void setInvoice(Invoice invoice) {
        set(PROPERTY_INVOICE, invoice);
    }

    public String getProcess() {
        return (String) get(PROPERTY_PROCESS);
    }

    public void setProcess(String process) {
        set(PROPERTY_PROCESS, process);
    }

}
