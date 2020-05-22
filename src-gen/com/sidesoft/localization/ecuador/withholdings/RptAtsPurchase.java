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
 * Entity class for entity SSWH_Rpt_Ats_Purchase (stored in table SSWH_Rpt_Ats_Purchase).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class RptAtsPurchase extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "SSWH_Rpt_Ats_Purchase";
    public static final String ENTITY_NAME = "SSWH_Rpt_Ats_Purchase";
    public static final String PROPERTY_EMPRESA = "empresa";
    public static final String PROPERTY_LINEA = "linea";
    public static final String PROPERTY_CODSUSTENTO = "codsustento";
    public static final String PROPERTY_TPIDPROV = "tpidprov";
    public static final String PROPERTY_IDPROV = "idprov";
    public static final String PROPERTY_TIPOCOMPROBANTE = "tipocomprobante";
    public static final String PROPERTY_FECHAREGISTRO = "fechaRegistro";
    public static final String PROPERTY_ESTABLECIMIENTO = "establecimiento";
    public static final String PROPERTY_PUNTOEMISION = "puntoemision";
    public static final String PROPERTY_SECUENCIAL = "secuencial";
    public static final String PROPERTY_FECHAEMISION = "fechaemision";
    public static final String PROPERTY_AUTORIZACION = "autorizacion";
    public static final String PROPERTY_BASENOGRAIVA = "basenograiva";
    public static final String PROPERTY_BASEIMPONIBLE = "baseimponible";
    public static final String PROPERTY_BASEIMPGRAV = "baseimpgrav";
    public static final String PROPERTY_MONTOICE = "montoice";
    public static final String PROPERTY_MONTOIVA = "montoiva";
    public static final String PROPERTY_VALORRETBIENES = "valorretbienes";
    public static final String PROPERTY_VALORRETSERVICIOS = "valorretservicios";
    public static final String PROPERTY_VALORRETSERV100 = "valorretserv100";
    public static final String PROPERTY_ESTABRETENCION1 = "estabretencion1";
    public static final String PROPERTY_PTOEMIRETENCION1 = "ptoemiretencion1";
    public static final String PROPERTY_SECRETENCION1 = "secretencion1";
    public static final String PROPERTY_AUTRETENCION1 = "autretencion1";
    public static final String PROPERTY_FECHAEMIRET1 = "fechaemiret1";
    public static final String PROPERTY_DOCMODIFICADO = "docmodificado";
    public static final String PROPERTY_ESTABMODIFICADO = "estabmodificado";
    public static final String PROPERTY_PTOEMIMODIFICADO = "ptoemimodificado";
    public static final String PROPERTY_SECMODIFICADO = "secmodificado";
    public static final String PROPERTY_AUTMODIFICADO = "autmodificado";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";

    public RptAtsPurchase() {
        setDefaultValue(PROPERTY_ACTIVE, true);
    }

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
    }

    public String getEmpresa() {
        return (String) get(PROPERTY_EMPRESA);
    }

    public void setEmpresa(String empresa) {
        set(PROPERTY_EMPRESA, empresa);
    }

    public Long getLinea() {
        return (Long) get(PROPERTY_LINEA);
    }

    public void setLinea(Long linea) {
        set(PROPERTY_LINEA, linea);
    }

    public String getCodsustento() {
        return (String) get(PROPERTY_CODSUSTENTO);
    }

    public void setCodsustento(String codsustento) {
        set(PROPERTY_CODSUSTENTO, codsustento);
    }

    public String getTpidprov() {
        return (String) get(PROPERTY_TPIDPROV);
    }

    public void setTpidprov(String tpidprov) {
        set(PROPERTY_TPIDPROV, tpidprov);
    }

    public String getIdprov() {
        return (String) get(PROPERTY_IDPROV);
    }

    public void setIdprov(String idprov) {
        set(PROPERTY_IDPROV, idprov);
    }

    public String getTipocomprobante() {
        return (String) get(PROPERTY_TIPOCOMPROBANTE);
    }

    public void setTipocomprobante(String tipocomprobante) {
        set(PROPERTY_TIPOCOMPROBANTE, tipocomprobante);
    }

    public Date getFechaRegistro() {
        return (Date) get(PROPERTY_FECHAREGISTRO);
    }

    public void setFechaRegistro(Date fechaRegistro) {
        set(PROPERTY_FECHAREGISTRO, fechaRegistro);
    }

    public String getEstablecimiento() {
        return (String) get(PROPERTY_ESTABLECIMIENTO);
    }

    public void setEstablecimiento(String establecimiento) {
        set(PROPERTY_ESTABLECIMIENTO, establecimiento);
    }

    public String getPuntoemision() {
        return (String) get(PROPERTY_PUNTOEMISION);
    }

    public void setPuntoemision(String puntoemision) {
        set(PROPERTY_PUNTOEMISION, puntoemision);
    }

    public String getSecuencial() {
        return (String) get(PROPERTY_SECUENCIAL);
    }

    public void setSecuencial(String secuencial) {
        set(PROPERTY_SECUENCIAL, secuencial);
    }

    public Date getFechaemision() {
        return (Date) get(PROPERTY_FECHAEMISION);
    }

    public void setFechaemision(Date fechaemision) {
        set(PROPERTY_FECHAEMISION, fechaemision);
    }

    public String getAutorizacion() {
        return (String) get(PROPERTY_AUTORIZACION);
    }

    public void setAutorizacion(String autorizacion) {
        set(PROPERTY_AUTORIZACION, autorizacion);
    }

    public Long getBasenograiva() {
        return (Long) get(PROPERTY_BASENOGRAIVA);
    }

    public void setBasenograiva(Long basenograiva) {
        set(PROPERTY_BASENOGRAIVA, basenograiva);
    }

    public Long getBaseimponible() {
        return (Long) get(PROPERTY_BASEIMPONIBLE);
    }

    public void setBaseimponible(Long baseimponible) {
        set(PROPERTY_BASEIMPONIBLE, baseimponible);
    }

    public Long getBaseimpgrav() {
        return (Long) get(PROPERTY_BASEIMPGRAV);
    }

    public void setBaseimpgrav(Long baseimpgrav) {
        set(PROPERTY_BASEIMPGRAV, baseimpgrav);
    }

    public Long getMontoice() {
        return (Long) get(PROPERTY_MONTOICE);
    }

    public void setMontoice(Long montoice) {
        set(PROPERTY_MONTOICE, montoice);
    }

    public Long getMontoiva() {
        return (Long) get(PROPERTY_MONTOIVA);
    }

    public void setMontoiva(Long montoiva) {
        set(PROPERTY_MONTOIVA, montoiva);
    }

    public Long getValorretbienes() {
        return (Long) get(PROPERTY_VALORRETBIENES);
    }

    public void setValorretbienes(Long valorretbienes) {
        set(PROPERTY_VALORRETBIENES, valorretbienes);
    }

    public Long getValorretservicios() {
        return (Long) get(PROPERTY_VALORRETSERVICIOS);
    }

    public void setValorretservicios(Long valorretservicios) {
        set(PROPERTY_VALORRETSERVICIOS, valorretservicios);
    }

    public Long getValorretserv100() {
        return (Long) get(PROPERTY_VALORRETSERV100);
    }

    public void setValorretserv100(Long valorretserv100) {
        set(PROPERTY_VALORRETSERV100, valorretserv100);
    }

    public String getEstabretencion1() {
        return (String) get(PROPERTY_ESTABRETENCION1);
    }

    public void setEstabretencion1(String estabretencion1) {
        set(PROPERTY_ESTABRETENCION1, estabretencion1);
    }

    public String getPtoemiretencion1() {
        return (String) get(PROPERTY_PTOEMIRETENCION1);
    }

    public void setPtoemiretencion1(String ptoemiretencion1) {
        set(PROPERTY_PTOEMIRETENCION1, ptoemiretencion1);
    }

    public String getSecretencion1() {
        return (String) get(PROPERTY_SECRETENCION1);
    }

    public void setSecretencion1(String secretencion1) {
        set(PROPERTY_SECRETENCION1, secretencion1);
    }

    public String getAutretencion1() {
        return (String) get(PROPERTY_AUTRETENCION1);
    }

    public void setAutretencion1(String autretencion1) {
        set(PROPERTY_AUTRETENCION1, autretencion1);
    }

    public Date getFechaemiret1() {
        return (Date) get(PROPERTY_FECHAEMIRET1);
    }

    public void setFechaemiret1(Date fechaemiret1) {
        set(PROPERTY_FECHAEMIRET1, fechaemiret1);
    }

    public String getDocmodificado() {
        return (String) get(PROPERTY_DOCMODIFICADO);
    }

    public void setDocmodificado(String docmodificado) {
        set(PROPERTY_DOCMODIFICADO, docmodificado);
    }

    public String getEstabmodificado() {
        return (String) get(PROPERTY_ESTABMODIFICADO);
    }

    public void setEstabmodificado(String estabmodificado) {
        set(PROPERTY_ESTABMODIFICADO, estabmodificado);
    }

    public String getPtoemimodificado() {
        return (String) get(PROPERTY_PTOEMIMODIFICADO);
    }

    public void setPtoemimodificado(String ptoemimodificado) {
        set(PROPERTY_PTOEMIMODIFICADO, ptoemimodificado);
    }

    public String getSecmodificado() {
        return (String) get(PROPERTY_SECMODIFICADO);
    }

    public void setSecmodificado(String secmodificado) {
        set(PROPERTY_SECMODIFICADO, secmodificado);
    }

    public String getAutmodificado() {
        return (String) get(PROPERTY_AUTMODIFICADO);
    }

    public void setAutmodificado(String autmodificado) {
        set(PROPERTY_AUTMODIFICADO, autmodificado);
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

}
