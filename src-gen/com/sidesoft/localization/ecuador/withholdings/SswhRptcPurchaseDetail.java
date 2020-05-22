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
 * Entity class for entity Sswh_Rptc_PurchaseDet (stored in table Sswh_Rptc_PurchaseDet).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SswhRptcPurchaseDetail extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "Sswh_Rptc_PurchaseDet";
    public static final String ENTITY_NAME = "Sswh_Rptc_PurchaseDet";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_AUTORIRETENCION = "autoriRetencion";
    public static final String PROPERTY_AUTORIZACION = "autorizacion";
    public static final String PROPERTY_AUTORIZACIONNC = "autorizacionNc";
    public static final String PROPERTY_BASEIVACERO = "baseIvaCero";
    public static final String PROPERTY_BASEIVADOCE = "baseIvaDoce";
    public static final String PROPERTY_BASENOIVA = "baseNoIva";
    public static final String PROPERTY_CODIGOCOMPRA = "codigoCompra";
    public static final String PROPERTY_CODSUSTENTO = "cODSustento";
    public static final String PROPERTY_CONVENIOTRIB = "convenioTrib";
    public static final String PROPERTY_DOCUMENTOCREDITNOTE = "documentoCreditnote";
    public static final String PROPERTY_ESTABLECIMIENTO = "establecimiento";
    public static final String PROPERTY_ESTABLECIMIENTONC = "establecimientoNc";
    public static final String PROPERTY_ESTABLECIMIENTORET = "establecimientoRet";
    public static final String PROPERTY_FECHAEMISION = "fechaEmision";
    public static final String PROPERTY_FECHAEMISIONRET = "fechaEmisionRet";
    public static final String PROPERTY_FECHAREGISTRO = "fechaRegistro";
    public static final String PROPERTY_MONTOICE = "montoIce";
    public static final String PROPERTY_MONTOIVA = "montoIva";
    public static final String PROPERTY_NORMALEGAL = "normaLegal";
    public static final String PROPERTY_NUMEROIDENT = "numeroIdent";
    public static final String PROPERTY_PAGOLOCAL = "pagoLocal";
    public static final String PROPERTY_PAISPAGO = "paisPago";
    public static final String PROPERTY_PARTERELACIONADA = "parteRelacionada";
    public static final String PROPERTY_ORDERREFERENCE = "orderReference";
    public static final String PROPERTY_POSTED = "posted";
    public static final String PROPERTY_PUNTOEMISION = "puntoEmision";
    public static final String PROPERTY_PUNTOEMISIONNC = "puntoEmisionNc";
    public static final String PROPERTY_PUNTOEMISIONRET = "puntoEmisionRet";
    public static final String PROPERTY_REFERENCECREDITNOTE = "referencecreditnote";
    public static final String PROPERTY_REFRETENCION = "rEFRetencion";
    public static final String PROPERTY_RETIVA100 = "rETIva100";
    public static final String PROPERTY_RETIVA30 = "rETIva30";
    public static final String PROPERTY_RETIVA50 = "rETIva50";
    public static final String PROPERTY_RETIVA70 = "rETIva70";
    public static final String PROPERTY_RETIVA20 = "rETIva20";
    public static final String PROPERTY_RETIVA10 = "rETIva10";
    public static final String PROPERTY_SECUENCIA = "secuencia";
    public static final String PROPERTY_SECUENCIANC = "secuenciaNc";
    public static final String PROPERTY_SECUENCIARET = "secuenciaRet";
    public static final String PROPERTY_TIPOCOMPROBANTE = "tipoComprobante";
    public static final String PROPERTY_TIPOIDENTIFICADOR = "tipoIdentificador";
    public static final String PROPERTY_TIPOPROVEEDOR = "tipoProveedor";
    public static final String PROPERTY_TYPEDOC = "typedoc";
    public static final String PROPERTY_BASEEXCENTA = "baseExcenta";
    public static final String PROPERTY_FISCALREGIME = "fiscalregime";
    public static final String PROPERTY_FISCALNAME = "fiscalname";
    public static final String PROPERTY_TIPOREGIMEN = "tipoRegimen";
    public static final String PROPERTY_PAISPAGOGENERAL = "paisPagoGeneral";
    public static final String PROPERTY_PAISPAGOPARAISO = "paisPagoParaiso";
    public static final String PROPERTY_DENOPAGOREGFIS = "denoPagoRegfis";
    public static final String PROPERTY_INVOICE = "invoice";
    public static final String PROPERTY_PROCESS = "process";

    public SswhRptcPurchaseDetail() {
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

    public String getAutoriRetencion() {
        return (String) get(PROPERTY_AUTORIRETENCION);
    }

    public void setAutoriRetencion(String autoriRetencion) {
        set(PROPERTY_AUTORIRETENCION, autoriRetencion);
    }

    public String getAutorizacion() {
        return (String) get(PROPERTY_AUTORIZACION);
    }

    public void setAutorizacion(String autorizacion) {
        set(PROPERTY_AUTORIZACION, autorizacion);
    }

    public String getAutorizacionNc() {
        return (String) get(PROPERTY_AUTORIZACIONNC);
    }

    public void setAutorizacionNc(String autorizacionNc) {
        set(PROPERTY_AUTORIZACIONNC, autorizacionNc);
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

    public BigDecimal getBaseNoIva() {
        return (BigDecimal) get(PROPERTY_BASENOIVA);
    }

    public void setBaseNoIva(BigDecimal baseNoIva) {
        set(PROPERTY_BASENOIVA, baseNoIva);
    }

    public String getCodigoCompra() {
        return (String) get(PROPERTY_CODIGOCOMPRA);
    }

    public void setCodigoCompra(String codigoCompra) {
        set(PROPERTY_CODIGOCOMPRA, codigoCompra);
    }

    public String getCODSustento() {
        return (String) get(PROPERTY_CODSUSTENTO);
    }

    public void setCODSustento(String cODSustento) {
        set(PROPERTY_CODSUSTENTO, cODSustento);
    }

    public String getConvenioTrib() {
        return (String) get(PROPERTY_CONVENIOTRIB);
    }

    public void setConvenioTrib(String convenioTrib) {
        set(PROPERTY_CONVENIOTRIB, convenioTrib);
    }

    public String getDocumentoCreditnote() {
        return (String) get(PROPERTY_DOCUMENTOCREDITNOTE);
    }

    public void setDocumentoCreditnote(String documentoCreditnote) {
        set(PROPERTY_DOCUMENTOCREDITNOTE, documentoCreditnote);
    }

    public String getEstablecimiento() {
        return (String) get(PROPERTY_ESTABLECIMIENTO);
    }

    public void setEstablecimiento(String establecimiento) {
        set(PROPERTY_ESTABLECIMIENTO, establecimiento);
    }

    public String getEstablecimientoNc() {
        return (String) get(PROPERTY_ESTABLECIMIENTONC);
    }

    public void setEstablecimientoNc(String establecimientoNc) {
        set(PROPERTY_ESTABLECIMIENTONC, establecimientoNc);
    }

    public String getEstablecimientoRet() {
        return (String) get(PROPERTY_ESTABLECIMIENTORET);
    }

    public void setEstablecimientoRet(String establecimientoRet) {
        set(PROPERTY_ESTABLECIMIENTORET, establecimientoRet);
    }

    public Date getFechaEmision() {
        return (Date) get(PROPERTY_FECHAEMISION);
    }

    public void setFechaEmision(Date fechaEmision) {
        set(PROPERTY_FECHAEMISION, fechaEmision);
    }

    public Date getFechaEmisionRet() {
        return (Date) get(PROPERTY_FECHAEMISIONRET);
    }

    public void setFechaEmisionRet(Date fechaEmisionRet) {
        set(PROPERTY_FECHAEMISIONRET, fechaEmisionRet);
    }

    public Date getFechaRegistro() {
        return (Date) get(PROPERTY_FECHAREGISTRO);
    }

    public void setFechaRegistro(Date fechaRegistro) {
        set(PROPERTY_FECHAREGISTRO, fechaRegistro);
    }

    public BigDecimal getMontoIce() {
        return (BigDecimal) get(PROPERTY_MONTOICE);
    }

    public void setMontoIce(BigDecimal montoIce) {
        set(PROPERTY_MONTOICE, montoIce);
    }

    public BigDecimal getMontoIva() {
        return (BigDecimal) get(PROPERTY_MONTOIVA);
    }

    public void setMontoIva(BigDecimal montoIva) {
        set(PROPERTY_MONTOIVA, montoIva);
    }

    public String getNormaLegal() {
        return (String) get(PROPERTY_NORMALEGAL);
    }

    public void setNormaLegal(String normaLegal) {
        set(PROPERTY_NORMALEGAL, normaLegal);
    }

    public String getNumeroIdent() {
        return (String) get(PROPERTY_NUMEROIDENT);
    }

    public void setNumeroIdent(String numeroIdent) {
        set(PROPERTY_NUMEROIDENT, numeroIdent);
    }

    public String getPagoLocal() {
        return (String) get(PROPERTY_PAGOLOCAL);
    }

    public void setPagoLocal(String pagoLocal) {
        set(PROPERTY_PAGOLOCAL, pagoLocal);
    }

    public String getPaisPago() {
        return (String) get(PROPERTY_PAISPAGO);
    }

    public void setPaisPago(String paisPago) {
        set(PROPERTY_PAISPAGO, paisPago);
    }

    public String getParteRelacionada() {
        return (String) get(PROPERTY_PARTERELACIONADA);
    }

    public void setParteRelacionada(String parteRelacionada) {
        set(PROPERTY_PARTERELACIONADA, parteRelacionada);
    }

    public String getOrderReference() {
        return (String) get(PROPERTY_ORDERREFERENCE);
    }

    public void setOrderReference(String orderReference) {
        set(PROPERTY_ORDERREFERENCE, orderReference);
    }

    public String getPosted() {
        return (String) get(PROPERTY_POSTED);
    }

    public void setPosted(String posted) {
        set(PROPERTY_POSTED, posted);
    }

    public String getPuntoEmision() {
        return (String) get(PROPERTY_PUNTOEMISION);
    }

    public void setPuntoEmision(String puntoEmision) {
        set(PROPERTY_PUNTOEMISION, puntoEmision);
    }

    public String getPuntoEmisionNc() {
        return (String) get(PROPERTY_PUNTOEMISIONNC);
    }

    public void setPuntoEmisionNc(String puntoEmisionNc) {
        set(PROPERTY_PUNTOEMISIONNC, puntoEmisionNc);
    }

    public String getPuntoEmisionRet() {
        return (String) get(PROPERTY_PUNTOEMISIONRET);
    }

    public void setPuntoEmisionRet(String puntoEmisionRet) {
        set(PROPERTY_PUNTOEMISIONRET, puntoEmisionRet);
    }

    public String getReferencecreditnote() {
        return (String) get(PROPERTY_REFERENCECREDITNOTE);
    }

    public void setReferencecreditnote(String referencecreditnote) {
        set(PROPERTY_REFERENCECREDITNOTE, referencecreditnote);
    }

    public String getREFRetencion() {
        return (String) get(PROPERTY_REFRETENCION);
    }

    public void setREFRetencion(String rEFRetencion) {
        set(PROPERTY_REFRETENCION, rEFRetencion);
    }

    public BigDecimal getRETIva100() {
        return (BigDecimal) get(PROPERTY_RETIVA100);
    }

    public void setRETIva100(BigDecimal rETIva100) {
        set(PROPERTY_RETIVA100, rETIva100);
    }

    public BigDecimal getRETIva30() {
        return (BigDecimal) get(PROPERTY_RETIVA30);
    }

    public void setRETIva30(BigDecimal rETIva30) {
        set(PROPERTY_RETIVA30, rETIva30);
    }

    public Long getRETIva50() {
        return (Long) get(PROPERTY_RETIVA50);
    }

    public void setRETIva50(Long rETIva50) {
        set(PROPERTY_RETIVA50, rETIva50);
    }

    public BigDecimal getRETIva70() {
        return (BigDecimal) get(PROPERTY_RETIVA70);
    }

    public void setRETIva70(BigDecimal rETIva70) {
        set(PROPERTY_RETIVA70, rETIva70);
    }

    public BigDecimal getRETIva20() {
        return (BigDecimal) get(PROPERTY_RETIVA20);
    }

    public void setRETIva20(BigDecimal rETIva20) {
        set(PROPERTY_RETIVA20, rETIva20);
    }

    public BigDecimal getRETIva10() {
        return (BigDecimal) get(PROPERTY_RETIVA10);
    }

    public void setRETIva10(BigDecimal rETIva10) {
        set(PROPERTY_RETIVA10, rETIva10);
    }

    public String getSecuencia() {
        return (String) get(PROPERTY_SECUENCIA);
    }

    public void setSecuencia(String secuencia) {
        set(PROPERTY_SECUENCIA, secuencia);
    }

    public String getSecuenciaNc() {
        return (String) get(PROPERTY_SECUENCIANC);
    }

    public void setSecuenciaNc(String secuenciaNc) {
        set(PROPERTY_SECUENCIANC, secuenciaNc);
    }

    public String getSecuenciaRet() {
        return (String) get(PROPERTY_SECUENCIARET);
    }

    public void setSecuenciaRet(String secuenciaRet) {
        set(PROPERTY_SECUENCIARET, secuenciaRet);
    }

    public String getTipoComprobante() {
        return (String) get(PROPERTY_TIPOCOMPROBANTE);
    }

    public void setTipoComprobante(String tipoComprobante) {
        set(PROPERTY_TIPOCOMPROBANTE, tipoComprobante);
    }

    public String getTipoIdentificador() {
        return (String) get(PROPERTY_TIPOIDENTIFICADOR);
    }

    public void setTipoIdentificador(String tipoIdentificador) {
        set(PROPERTY_TIPOIDENTIFICADOR, tipoIdentificador);
    }

    public String getTipoProveedor() {
        return (String) get(PROPERTY_TIPOPROVEEDOR);
    }

    public void setTipoProveedor(String tipoProveedor) {
        set(PROPERTY_TIPOPROVEEDOR, tipoProveedor);
    }

    public String getTypedoc() {
        return (String) get(PROPERTY_TYPEDOC);
    }

    public void setTypedoc(String typedoc) {
        set(PROPERTY_TYPEDOC, typedoc);
    }

    public BigDecimal getBaseExcenta() {
        return (BigDecimal) get(PROPERTY_BASEEXCENTA);
    }

    public void setBaseExcenta(BigDecimal baseExcenta) {
        set(PROPERTY_BASEEXCENTA, baseExcenta);
    }

    public String getFiscalregime() {
        return (String) get(PROPERTY_FISCALREGIME);
    }

    public void setFiscalregime(String fiscalregime) {
        set(PROPERTY_FISCALREGIME, fiscalregime);
    }

    public String getFiscalname() {
        return (String) get(PROPERTY_FISCALNAME);
    }

    public void setFiscalname(String fiscalname) {
        set(PROPERTY_FISCALNAME, fiscalname);
    }

    public String getTipoRegimen() {
        return (String) get(PROPERTY_TIPOREGIMEN);
    }

    public void setTipoRegimen(String tipoRegimen) {
        set(PROPERTY_TIPOREGIMEN, tipoRegimen);
    }

    public String getPaisPagoGeneral() {
        return (String) get(PROPERTY_PAISPAGOGENERAL);
    }

    public void setPaisPagoGeneral(String paisPagoGeneral) {
        set(PROPERTY_PAISPAGOGENERAL, paisPagoGeneral);
    }

    public String getPaisPagoParaiso() {
        return (String) get(PROPERTY_PAISPAGOPARAISO);
    }

    public void setPaisPagoParaiso(String paisPagoParaiso) {
        set(PROPERTY_PAISPAGOPARAISO, paisPagoParaiso);
    }

    public String getDenoPagoRegfis() {
        return (String) get(PROPERTY_DENOPAGOREGFIS);
    }

    public void setDenoPagoRegfis(String denoPagoRegfis) {
        set(PROPERTY_DENOPAGOREGFIS, denoPagoRegfis);
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
