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
package com.sidesoft.hrm.payroll;

import java.math.BigDecimal;
import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.calendar.Year;
/**
 * Entity class for entity sspr_formulary107_detail_v (stored in table sspr_formulary107_detail_v).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ssprformulary107detailv extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sspr_formulary107_detail_v";
    public static final String ENTITY_NAME = "sspr_formulary107_detail_v";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_ANIOENTREGA = "anioEntrega";
    public static final String PROPERTY_MESENTREGA = "mESEntrega";
    public static final String PROPERTY_DIAENTREGA = "dIAEntrega";
    public static final String PROPERTY_TAXIDORG = "taxidOrg";
    public static final String PROPERTY_ORG = "org";
    public static final String PROPERTY_FISCALYEAR = "fiscalYear";
    public static final String PROPERTY_YEAR = "year";
    public static final String PROPERTY_EMPLOYEE = "employee";
    public static final String PROPERTY_TAXIDEMPLOYEE = "taxidEmployee";
    public static final String PROPERTY_EMPLEADO = "empleado";
    public static final String PROPERTY_TIPOIDENTIFICACION = "tipoidentificacion";
    public static final String PROPERTY_NUMEROIDENTIFICACION = "numeroidentificacion";
    public static final String PROPERTY_EMPLEADOAPELLIDO = "empleadoapellido";
    public static final String PROPERTY_EMPLEADONOMBRE = "empleadonombre";
    public static final String PROPERTY_CODIGOESTAB = "codigoestab";
    public static final String PROPERTY_PAIS = "pais";
    public static final String PROPERTY_CODIGOPAIS = "codigopais";
    public static final String PROPERTY_APLICACONVENIO = "aplicaconvenio";
    public static final String PROPERTY_DISCAPACITADO = "discapacitado";
    public static final String PROPERTY_PORCENTAJEDISCAPACIDAD = "porcentajediscapacidad";
    public static final String PROPERTY_TIPOIDENTDISCAPACIDAD = "tipoidentdiscapacidad";
    public static final String PROPERTY_NUMEROIDENTIFDISCAPACIDAD = "numeroidentifdiscapacidad";
    public static final String PROPERTY_SUELDO = "sueldo";
    public static final String PROPERTY_BONOS = "bonos";
    public static final String PROPERTY_UTILIDADES = "utilidades";
    public static final String PROPERTY_IMPUESTORENTA = "impuestorenta";
    public static final String PROPERTY_DECIMOTERCERO = "decimotercero";
    public static final String PROPERTY_DECIMOCUARTO = "decimocuarto";
    public static final String PROPERTY_FONDOSRESERVA = "fondosreserva";
    public static final String PROPERTY_COMPENSACIONSALARIODIGNO = "compensacionsalariodigno";
    public static final String PROPERTY_OTROSINGRENTAGRAVADA = "otrosingRentagravada";
    public static final String PROPERTY_INGRESOSGRAV349 = "ingresosgrav349";
    public static final String PROPERTY_SISTEMASALARIODIGNO = "sistemasalariodigno";
    public static final String PROPERTY_APORTEPERSONAL = "aportepersonal";
    public static final String PROPERTY_IMPUESTORENTACAUSADO = "impuestorentacausado";
    public static final String PROPERTY_VALORIMPRETTRABAJADOR = "valorimprettrabajador";
    public static final String PROPERTY_GASTOSVIVIENDA = "gastosvivienda";
    public static final String PROPERTY_GASTOSSALUD = "gastossalud";
    public static final String PROPERTY_GASTOSEDUCACION = "gastoseducacion";
    public static final String PROPERTY_GASTOALIMENTACION = "gastoalimentacion";
    public static final String PROPERTY_GASTOSVESTIMENTA = "gastosvestimenta";
    public static final String PROPERTY_INGRESOSGRAVADOS = "ingresosgravados";
    public static final String PROPERTY_APORTEPERSONALO = "aportepersonalo";
    public static final String PROPERTY_EXONERACIONPORDISCAPACIDAD = "exoneracionpordiscapacidad";
    public static final String PROPERTY_EXONERACIONPORTERCERASEDAD = "exoneracionportercerasedad";
    public static final String PROPERTY_VALORIMPRET403 = "valorimpret403";
    public static final String PROPERTY_VALORIMPASUMIDO405 = "valorimpasumido405";
    public static final String PROPERTY_BASEIMPONIBLEGRAV = "baseimponiblegrav";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";

    public ssprformulary107detailv() {
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

    public String getAnioEntrega() {
        return (String) get(PROPERTY_ANIOENTREGA);
    }

    public void setAnioEntrega(String anioEntrega) {
        set(PROPERTY_ANIOENTREGA, anioEntrega);
    }

    public String getMESEntrega() {
        return (String) get(PROPERTY_MESENTREGA);
    }

    public void setMESEntrega(String mESEntrega) {
        set(PROPERTY_MESENTREGA, mESEntrega);
    }

    public String getDIAEntrega() {
        return (String) get(PROPERTY_DIAENTREGA);
    }

    public void setDIAEntrega(String dIAEntrega) {
        set(PROPERTY_DIAENTREGA, dIAEntrega);
    }

    public String getTaxidOrg() {
        return (String) get(PROPERTY_TAXIDORG);
    }

    public void setTaxidOrg(String taxidOrg) {
        set(PROPERTY_TAXIDORG, taxidOrg);
    }

    public String getOrg() {
        return (String) get(PROPERTY_ORG);
    }

    public void setOrg(String org) {
        set(PROPERTY_ORG, org);
    }

    public String getFiscalYear() {
        return (String) get(PROPERTY_FISCALYEAR);
    }

    public void setFiscalYear(String fiscalYear) {
        set(PROPERTY_FISCALYEAR, fiscalYear);
    }

    public Year getYear() {
        return (Year) get(PROPERTY_YEAR);
    }

    public void setYear(Year year) {
        set(PROPERTY_YEAR, year);
    }

    public BusinessPartner getEmployee() {
        return (BusinessPartner) get(PROPERTY_EMPLOYEE);
    }

    public void setEmployee(BusinessPartner employee) {
        set(PROPERTY_EMPLOYEE, employee);
    }

    public String getTaxidEmployee() {
        return (String) get(PROPERTY_TAXIDEMPLOYEE);
    }

    public void setTaxidEmployee(String taxidEmployee) {
        set(PROPERTY_TAXIDEMPLOYEE, taxidEmployee);
    }

    public String getEmpleado() {
        return (String) get(PROPERTY_EMPLEADO);
    }

    public void setEmpleado(String empleado) {
        set(PROPERTY_EMPLEADO, empleado);
    }

    public String getTipoidentificacion() {
        return (String) get(PROPERTY_TIPOIDENTIFICACION);
    }

    public void setTipoidentificacion(String tipoidentificacion) {
        set(PROPERTY_TIPOIDENTIFICACION, tipoidentificacion);
    }

    public String getNumeroidentificacion() {
        return (String) get(PROPERTY_NUMEROIDENTIFICACION);
    }

    public void setNumeroidentificacion(String numeroidentificacion) {
        set(PROPERTY_NUMEROIDENTIFICACION, numeroidentificacion);
    }

    public String getEmpleadoapellido() {
        return (String) get(PROPERTY_EMPLEADOAPELLIDO);
    }

    public void setEmpleadoapellido(String empleadoapellido) {
        set(PROPERTY_EMPLEADOAPELLIDO, empleadoapellido);
    }

    public String getEmpleadonombre() {
        return (String) get(PROPERTY_EMPLEADONOMBRE);
    }

    public void setEmpleadonombre(String empleadonombre) {
        set(PROPERTY_EMPLEADONOMBRE, empleadonombre);
    }

    public String getCodigoestab() {
        return (String) get(PROPERTY_CODIGOESTAB);
    }

    public void setCodigoestab(String codigoestab) {
        set(PROPERTY_CODIGOESTAB, codigoestab);
    }

    public String getPais() {
        return (String) get(PROPERTY_PAIS);
    }

    public void setPais(String pais) {
        set(PROPERTY_PAIS, pais);
    }

    public String getCodigopais() {
        return (String) get(PROPERTY_CODIGOPAIS);
    }

    public void setCodigopais(String codigopais) {
        set(PROPERTY_CODIGOPAIS, codigopais);
    }

    public String getAplicaconvenio() {
        return (String) get(PROPERTY_APLICACONVENIO);
    }

    public void setAplicaconvenio(String aplicaconvenio) {
        set(PROPERTY_APLICACONVENIO, aplicaconvenio);
    }

    public String getDiscapacitado() {
        return (String) get(PROPERTY_DISCAPACITADO);
    }

    public void setDiscapacitado(String discapacitado) {
        set(PROPERTY_DISCAPACITADO, discapacitado);
    }

    public String getPorcentajediscapacidad() {
        return (String) get(PROPERTY_PORCENTAJEDISCAPACIDAD);
    }

    public void setPorcentajediscapacidad(String porcentajediscapacidad) {
        set(PROPERTY_PORCENTAJEDISCAPACIDAD, porcentajediscapacidad);
    }

    public String getTipoidentdiscapacidad() {
        return (String) get(PROPERTY_TIPOIDENTDISCAPACIDAD);
    }

    public void setTipoidentdiscapacidad(String tipoidentdiscapacidad) {
        set(PROPERTY_TIPOIDENTDISCAPACIDAD, tipoidentdiscapacidad);
    }

    public String getNumeroidentifdiscapacidad() {
        return (String) get(PROPERTY_NUMEROIDENTIFDISCAPACIDAD);
    }

    public void setNumeroidentifdiscapacidad(String numeroidentifdiscapacidad) {
        set(PROPERTY_NUMEROIDENTIFDISCAPACIDAD, numeroidentifdiscapacidad);
    }

    public BigDecimal getSueldo() {
        return (BigDecimal) get(PROPERTY_SUELDO);
    }

    public void setSueldo(BigDecimal sueldo) {
        set(PROPERTY_SUELDO, sueldo);
    }

    public BigDecimal getBonos() {
        return (BigDecimal) get(PROPERTY_BONOS);
    }

    public void setBonos(BigDecimal bonos) {
        set(PROPERTY_BONOS, bonos);
    }

    public BigDecimal getUtilidades() {
        return (BigDecimal) get(PROPERTY_UTILIDADES);
    }

    public void setUtilidades(BigDecimal utilidades) {
        set(PROPERTY_UTILIDADES, utilidades);
    }

    public BigDecimal getImpuestorenta() {
        return (BigDecimal) get(PROPERTY_IMPUESTORENTA);
    }

    public void setImpuestorenta(BigDecimal impuestorenta) {
        set(PROPERTY_IMPUESTORENTA, impuestorenta);
    }

    public BigDecimal getDecimotercero() {
        return (BigDecimal) get(PROPERTY_DECIMOTERCERO);
    }

    public void setDecimotercero(BigDecimal decimotercero) {
        set(PROPERTY_DECIMOTERCERO, decimotercero);
    }

    public BigDecimal getDecimocuarto() {
        return (BigDecimal) get(PROPERTY_DECIMOCUARTO);
    }

    public void setDecimocuarto(BigDecimal decimocuarto) {
        set(PROPERTY_DECIMOCUARTO, decimocuarto);
    }

    public BigDecimal getFondosreserva() {
        return (BigDecimal) get(PROPERTY_FONDOSRESERVA);
    }

    public void setFondosreserva(BigDecimal fondosreserva) {
        set(PROPERTY_FONDOSRESERVA, fondosreserva);
    }

    public BigDecimal getCompensacionsalariodigno() {
        return (BigDecimal) get(PROPERTY_COMPENSACIONSALARIODIGNO);
    }

    public void setCompensacionsalariodigno(BigDecimal compensacionsalariodigno) {
        set(PROPERTY_COMPENSACIONSALARIODIGNO, compensacionsalariodigno);
    }

    public BigDecimal getOtrosingRentagravada() {
        return (BigDecimal) get(PROPERTY_OTROSINGRENTAGRAVADA);
    }

    public void setOtrosingRentagravada(BigDecimal otrosingRentagravada) {
        set(PROPERTY_OTROSINGRENTAGRAVADA, otrosingRentagravada);
    }

    public BigDecimal getIngresosgrav349() {
        return (BigDecimal) get(PROPERTY_INGRESOSGRAV349);
    }

    public void setIngresosgrav349(BigDecimal ingresosgrav349) {
        set(PROPERTY_INGRESOSGRAV349, ingresosgrav349);
    }

    public BigDecimal getSistemasalariodigno() {
        return (BigDecimal) get(PROPERTY_SISTEMASALARIODIGNO);
    }

    public void setSistemasalariodigno(BigDecimal sistemasalariodigno) {
        set(PROPERTY_SISTEMASALARIODIGNO, sistemasalariodigno);
    }

    public BigDecimal getAportepersonal() {
        return (BigDecimal) get(PROPERTY_APORTEPERSONAL);
    }

    public void setAportepersonal(BigDecimal aportepersonal) {
        set(PROPERTY_APORTEPERSONAL, aportepersonal);
    }

    public BigDecimal getImpuestorentacausado() {
        return (BigDecimal) get(PROPERTY_IMPUESTORENTACAUSADO);
    }

    public void setImpuestorentacausado(BigDecimal impuestorentacausado) {
        set(PROPERTY_IMPUESTORENTACAUSADO, impuestorentacausado);
    }

    public BigDecimal getValorimprettrabajador() {
        return (BigDecimal) get(PROPERTY_VALORIMPRETTRABAJADOR);
    }

    public void setValorimprettrabajador(BigDecimal valorimprettrabajador) {
        set(PROPERTY_VALORIMPRETTRABAJADOR, valorimprettrabajador);
    }

    public BigDecimal getGastosvivienda() {
        return (BigDecimal) get(PROPERTY_GASTOSVIVIENDA);
    }

    public void setGastosvivienda(BigDecimal gastosvivienda) {
        set(PROPERTY_GASTOSVIVIENDA, gastosvivienda);
    }

    public BigDecimal getGastossalud() {
        return (BigDecimal) get(PROPERTY_GASTOSSALUD);
    }

    public void setGastossalud(BigDecimal gastossalud) {
        set(PROPERTY_GASTOSSALUD, gastossalud);
    }

    public BigDecimal getGastoseducacion() {
        return (BigDecimal) get(PROPERTY_GASTOSEDUCACION);
    }

    public void setGastoseducacion(BigDecimal gastoseducacion) {
        set(PROPERTY_GASTOSEDUCACION, gastoseducacion);
    }

    public BigDecimal getGastoalimentacion() {
        return (BigDecimal) get(PROPERTY_GASTOALIMENTACION);
    }

    public void setGastoalimentacion(BigDecimal gastoalimentacion) {
        set(PROPERTY_GASTOALIMENTACION, gastoalimentacion);
    }

    public BigDecimal getGastosvestimenta() {
        return (BigDecimal) get(PROPERTY_GASTOSVESTIMENTA);
    }

    public void setGastosvestimenta(BigDecimal gastosvestimenta) {
        set(PROPERTY_GASTOSVESTIMENTA, gastosvestimenta);
    }

    public BigDecimal getIngresosgravados() {
        return (BigDecimal) get(PROPERTY_INGRESOSGRAVADOS);
    }

    public void setIngresosgravados(BigDecimal ingresosgravados) {
        set(PROPERTY_INGRESOSGRAVADOS, ingresosgravados);
    }

    public BigDecimal getAportepersonalo() {
        return (BigDecimal) get(PROPERTY_APORTEPERSONALO);
    }

    public void setAportepersonalo(BigDecimal aportepersonalo) {
        set(PROPERTY_APORTEPERSONALO, aportepersonalo);
    }

    public BigDecimal getExoneracionpordiscapacidad() {
        return (BigDecimal) get(PROPERTY_EXONERACIONPORDISCAPACIDAD);
    }

    public void setExoneracionpordiscapacidad(BigDecimal exoneracionpordiscapacidad) {
        set(PROPERTY_EXONERACIONPORDISCAPACIDAD, exoneracionpordiscapacidad);
    }

    public BigDecimal getExoneracionportercerasedad() {
        return (BigDecimal) get(PROPERTY_EXONERACIONPORTERCERASEDAD);
    }

    public void setExoneracionportercerasedad(BigDecimal exoneracionportercerasedad) {
        set(PROPERTY_EXONERACIONPORTERCERASEDAD, exoneracionportercerasedad);
    }

    public BigDecimal getValorimpret403() {
        return (BigDecimal) get(PROPERTY_VALORIMPRET403);
    }

    public void setValorimpret403(BigDecimal valorimpret403) {
        set(PROPERTY_VALORIMPRET403, valorimpret403);
    }

    public BigDecimal getValorimpasumido405() {
        return (BigDecimal) get(PROPERTY_VALORIMPASUMIDO405);
    }

    public void setValorimpasumido405(BigDecimal valorimpasumido405) {
        set(PROPERTY_VALORIMPASUMIDO405, valorimpasumido405);
    }

    public BigDecimal getBaseimponiblegrav() {
        return (BigDecimal) get(PROPERTY_BASEIMPONIBLEGRAV);
    }

    public void setBaseimponiblegrav(BigDecimal baseimponiblegrav) {
        set(PROPERTY_BASEIMPONIBLEGRAV, baseimponiblegrav);
    }

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

}
