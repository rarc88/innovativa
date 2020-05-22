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
package com.sidesoft.localization.ecuador.refunds;

import com.sidesoft.localization.ecuador.withholdings.SSWHCodelivelihoodt;
import com.sidesoft.localization.ecuador.withholdings.SSWHLivelihoodt;

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
import org.openbravo.model.common.invoice.Invoice;
/**
 * Entity class for entity ssre_refundinvoice (stored in table ssre_refundinvoice).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ssrerefundinvoice extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ssre_refundinvoice";
    public static final String ENTITY_NAME = "ssre_refundinvoice";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_INVOICE = "invoice";
    public static final String PROPERTY_LIVELIHOOD = "livelihood";
    public static final String PROPERTY_SSWHCODELIVELIHOODT = "sswhCodelivelihoodt";
    public static final String PROPERTY_TAXIDTYPE = "taxidtype";
    public static final String PROPERTY_TAXIDRUC = "taxidruc";
    public static final String PROPERTY_STABLISHMENT = "stablishment";
    public static final String PROPERTY_SHELL = "shell";
    public static final String PROPERTY_ORDERREFERENCE = "orderReference";
    public static final String PROPERTY_DATEEMISSION = "dateemission";
    public static final String PROPERTY_WITHHOLDINGAUTHORIZATION = "withholdingAuthorization";
    public static final String PROPERTY_TAXBASE = "taxbase";
    public static final String PROPERTY_TAXBASEREFUND = "taxbaserefund";
    public static final String PROPERTY_TAXABLEAMOUNT = "taxableAmount";
    public static final String PROPERTY_TAXAMOUNT = "taxAmount";
    public static final String PROPERTY_TAXICE = "taxice";
    public static final String PROPERTY_UNTAXEDBASIS = "untaxedBasis";
    public static final String PROPERTY_BPARTNER = "bpartner";
    public static final String PROPERTY_EXEMPTBASE = "exemptBase";
    public static final String PROPERTY_GRANDTOTALAMOUNT = "grandTotalAmount";

    public ssrerefundinvoice() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_TAXBASE, new BigDecimal(0));
        setDefaultValue(PROPERTY_TAXBASEREFUND, new BigDecimal(0));
        setDefaultValue(PROPERTY_TAXABLEAMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_TAXAMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_TAXICE, new BigDecimal(0));
        setDefaultValue(PROPERTY_UNTAXEDBASIS, new BigDecimal(0));
        setDefaultValue(PROPERTY_EXEMPTBASE, new BigDecimal(0));
        setDefaultValue(PROPERTY_GRANDTOTALAMOUNT, new BigDecimal(0));
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

    public SSWHLivelihoodt getLivelihood() {
        return (SSWHLivelihoodt) get(PROPERTY_LIVELIHOOD);
    }

    public void setLivelihood(SSWHLivelihoodt livelihood) {
        set(PROPERTY_LIVELIHOOD, livelihood);
    }

    public SSWHCodelivelihoodt getSswhCodelivelihoodt() {
        return (SSWHCodelivelihoodt) get(PROPERTY_SSWHCODELIVELIHOODT);
    }

    public void setSswhCodelivelihoodt(SSWHCodelivelihoodt sswhCodelivelihoodt) {
        set(PROPERTY_SSWHCODELIVELIHOODT, sswhCodelivelihoodt);
    }

    public String getTaxidtype() {
        return (String) get(PROPERTY_TAXIDTYPE);
    }

    public void setTaxidtype(String taxidtype) {
        set(PROPERTY_TAXIDTYPE, taxidtype);
    }

    public String getTaxidruc() {
        return (String) get(PROPERTY_TAXIDRUC);
    }

    public void setTaxidruc(String taxidruc) {
        set(PROPERTY_TAXIDRUC, taxidruc);
    }

    public String getStablishment() {
        return (String) get(PROPERTY_STABLISHMENT);
    }

    public void setStablishment(String stablishment) {
        set(PROPERTY_STABLISHMENT, stablishment);
    }

    public String getShell() {
        return (String) get(PROPERTY_SHELL);
    }

    public void setShell(String shell) {
        set(PROPERTY_SHELL, shell);
    }

    public String getOrderReference() {
        return (String) get(PROPERTY_ORDERREFERENCE);
    }

    public void setOrderReference(String orderReference) {
        set(PROPERTY_ORDERREFERENCE, orderReference);
    }

    public Date getDateemission() {
        return (Date) get(PROPERTY_DATEEMISSION);
    }

    public void setDateemission(Date dateemission) {
        set(PROPERTY_DATEEMISSION, dateemission);
    }

    public String getWithholdingAuthorization() {
        return (String) get(PROPERTY_WITHHOLDINGAUTHORIZATION);
    }

    public void setWithholdingAuthorization(String withholdingAuthorization) {
        set(PROPERTY_WITHHOLDINGAUTHORIZATION, withholdingAuthorization);
    }

    public BigDecimal getTaxbase() {
        return (BigDecimal) get(PROPERTY_TAXBASE);
    }

    public void setTaxbase(BigDecimal taxbase) {
        set(PROPERTY_TAXBASE, taxbase);
    }

    public BigDecimal getTaxbaserefund() {
        return (BigDecimal) get(PROPERTY_TAXBASEREFUND);
    }

    public void setTaxbaserefund(BigDecimal taxbaserefund) {
        set(PROPERTY_TAXBASEREFUND, taxbaserefund);
    }

    public BigDecimal getTaxableAmount() {
        return (BigDecimal) get(PROPERTY_TAXABLEAMOUNT);
    }

    public void setTaxableAmount(BigDecimal taxableAmount) {
        set(PROPERTY_TAXABLEAMOUNT, taxableAmount);
    }

    public BigDecimal getTaxAmount() {
        return (BigDecimal) get(PROPERTY_TAXAMOUNT);
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        set(PROPERTY_TAXAMOUNT, taxAmount);
    }

    public BigDecimal getTaxice() {
        return (BigDecimal) get(PROPERTY_TAXICE);
    }

    public void setTaxice(BigDecimal taxice) {
        set(PROPERTY_TAXICE, taxice);
    }

    public BigDecimal getUntaxedBasis() {
        return (BigDecimal) get(PROPERTY_UNTAXEDBASIS);
    }

    public void setUntaxedBasis(BigDecimal untaxedBasis) {
        set(PROPERTY_UNTAXEDBASIS, untaxedBasis);
    }

    public BusinessPartner getBpartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBpartner(BusinessPartner bpartner) {
        set(PROPERTY_BPARTNER, bpartner);
    }

    public BigDecimal getExemptBase() {
        return (BigDecimal) get(PROPERTY_EXEMPTBASE);
    }

    public void setExemptBase(BigDecimal exemptBase) {
        set(PROPERTY_EXEMPTBASE, exemptBase);
    }

    public BigDecimal getGrandTotalAmount() {
        return (BigDecimal) get(PROPERTY_GRANDTOTALAMOUNT);
    }

    public void setGrandTotalAmount(BigDecimal grandTotalAmount) {
        set(PROPERTY_GRANDTOTALAMOUNT, grandTotalAmount);
    }

}
