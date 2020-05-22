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
package com.sidesoft.localization.ecuador.finances;

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
 * Entity class for entity Ssfi_InvoiceSummaryV (stored in table SSFI_INVOICE_SUMMARY_V).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SsfiInvoiceSummaryV extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "SSFI_INVOICE_SUMMARY_V";
    public static final String ENTITY_NAME = "Ssfi_InvoiceSummaryV";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_INVOICE = "invoice";
    public static final String PROPERTY_IMPORTEBRUTO = "importeBruto";
    public static final String PROPERTY_IMPORTEIMPONIBLE = "importeImponible";
    public static final String PROPERTY_IMPUESTO = "impuesto";
    public static final String PROPERTY_BASECERO = "basecero";
    public static final String PROPERTY_BASE12 = "base12";
    public static final String PROPERTY_IVA12 = "iva12";

    public SsfiInvoiceSummaryV() {
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

    public Invoice getInvoice() {
        return (Invoice) get(PROPERTY_INVOICE);
    }

    public void setInvoice(Invoice invoice) {
        set(PROPERTY_INVOICE, invoice);
    }

    public BigDecimal getImporteBruto() {
        return (BigDecimal) get(PROPERTY_IMPORTEBRUTO);
    }

    public void setImporteBruto(BigDecimal importeBruto) {
        set(PROPERTY_IMPORTEBRUTO, importeBruto);
    }

    public BigDecimal getImporteImponible() {
        return (BigDecimal) get(PROPERTY_IMPORTEIMPONIBLE);
    }

    public void setImporteImponible(BigDecimal importeImponible) {
        set(PROPERTY_IMPORTEIMPONIBLE, importeImponible);
    }

    public BigDecimal getImpuesto() {
        return (BigDecimal) get(PROPERTY_IMPUESTO);
    }

    public void setImpuesto(BigDecimal impuesto) {
        set(PROPERTY_IMPUESTO, impuesto);
    }

    public BigDecimal getBasecero() {
        return (BigDecimal) get(PROPERTY_BASECERO);
    }

    public void setBasecero(BigDecimal basecero) {
        set(PROPERTY_BASECERO, basecero);
    }

    public BigDecimal getBase12() {
        return (BigDecimal) get(PROPERTY_BASE12);
    }

    public void setBase12(BigDecimal base12) {
        set(PROPERTY_BASE12, base12);
    }

    public BigDecimal getIva12() {
        return (BigDecimal) get(PROPERTY_IVA12);
    }

    public void setIva12(BigDecimal iva12) {
        set(PROPERTY_IVA12, iva12);
    }

}
