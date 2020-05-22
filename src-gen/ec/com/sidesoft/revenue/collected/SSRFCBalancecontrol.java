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
package ec.com.sidesoft.revenue.collected;

import com.sidesoft.flopec.budget.data.SFBBudget;
import com.sidesoft.flopec.budget.data.SFBBudgetCertLine;

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
import org.openbravo.model.common.invoice.InvoiceLine;
/**
 * Entity class for entity SSRFC_balancecontrol (stored in table SSRFC_balancecontrol).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SSRFCBalancecontrol extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "SSRFC_balancecontrol";
    public static final String ENTITY_NAME = "SSRFC_balancecontrol";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DATEINVOICE = "dateinvoice";
    public static final String PROPERTY_INVOICE = "invoice";
    public static final String PROPERTY_INVOICELINE = "invoiceline";
    public static final String PROPERTY_AMMOUNT = "ammount";
    public static final String PROPERTY_SFBBUDGETCERTLINE = "sFBBudgetCertLine";
    public static final String PROPERTY_SFBBUDGET = "sFBBudget";

    public SSRFCBalancecontrol() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_AMMOUNT, new BigDecimal(0));
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

    public Date getDateinvoice() {
        return (Date) get(PROPERTY_DATEINVOICE);
    }

    public void setDateinvoice(Date dateinvoice) {
        set(PROPERTY_DATEINVOICE, dateinvoice);
    }

    public Invoice getInvoice() {
        return (Invoice) get(PROPERTY_INVOICE);
    }

    public void setInvoice(Invoice invoice) {
        set(PROPERTY_INVOICE, invoice);
    }

    public InvoiceLine getInvoiceline() {
        return (InvoiceLine) get(PROPERTY_INVOICELINE);
    }

    public void setInvoiceline(InvoiceLine invoiceline) {
        set(PROPERTY_INVOICELINE, invoiceline);
    }

    public BigDecimal getAmmount() {
        return (BigDecimal) get(PROPERTY_AMMOUNT);
    }

    public void setAmmount(BigDecimal ammount) {
        set(PROPERTY_AMMOUNT, ammount);
    }

    public SFBBudgetCertLine getSFBBudgetCertLine() {
        return (SFBBudgetCertLine) get(PROPERTY_SFBBUDGETCERTLINE);
    }

    public void setSFBBudgetCertLine(SFBBudgetCertLine sFBBudgetCertLine) {
        set(PROPERTY_SFBBUDGETCERTLINE, sFBBudgetCertLine);
    }

    public SFBBudget getSFBBudget() {
        return (SFBBudget) get(PROPERTY_SFBBUDGET);
    }

    public void setSFBBudget(SFBBudget sFBBudget) {
        set(PROPERTY_SFBBUDGET, sFBBudget);
    }

}
