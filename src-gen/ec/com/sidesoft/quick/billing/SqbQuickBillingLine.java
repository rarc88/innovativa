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
package ec.com.sidesoft.quick.billing;

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
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.financialmgmt.tax.TaxRate;
/**
 * Entity class for entity sqb_quickbillingline (stored in table sqb_quickbillingline).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SqbQuickBillingLine extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sqb_quickbillingline";
    public static final String ENTITY_NAME = "sqb_quickbillingline";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_SQBQUICKBILLING = "sQBQuickbilling";
    public static final String PROPERTY_LINE = "line";
    public static final String PROPERTY_QTYQUICKBILLING = "qtyquickbilling";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_PRICEQUICKBILLING = "pricequickbilling";
    public static final String PROPERTY_PRICEQUICKBILLINGLIST = "pricequickbillinglist";
    public static final String PROPERTY_SUBTOTALQB = "subtotalQb";
    public static final String PROPERTY_VAT = "vat";
    public static final String PROPERTY_DOCSTATUS = "docstatus";
    public static final String PROPERTY_TAX = "tax";
    public static final String PROPERTY_DISCOUNT = "discount";
    public static final String PROPERTY_INITIALSUBTOTAL = "initialSubtotal";

    public SqbQuickBillingLine() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_QTYQUICKBILLING, new BigDecimal(1));
        setDefaultValue(PROPERTY_PRICEQUICKBILLING, new BigDecimal(0));
        setDefaultValue(PROPERTY_PRICEQUICKBILLINGLIST, new BigDecimal(0));
        setDefaultValue(PROPERTY_SUBTOTALQB, new BigDecimal(0));
        setDefaultValue(PROPERTY_VAT, new BigDecimal(0));
        setDefaultValue(PROPERTY_DISCOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_INITIALSUBTOTAL, new BigDecimal(0));
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

    public SqbQuickBilling getSQBQuickbilling() {
        return (SqbQuickBilling) get(PROPERTY_SQBQUICKBILLING);
    }

    public void setSQBQuickbilling(SqbQuickBilling sQBQuickbilling) {
        set(PROPERTY_SQBQUICKBILLING, sQBQuickbilling);
    }

    public Long getLine() {
        return (Long) get(PROPERTY_LINE);
    }

    public void setLine(Long line) {
        set(PROPERTY_LINE, line);
    }

    public BigDecimal getQtyquickbilling() {
        return (BigDecimal) get(PROPERTY_QTYQUICKBILLING);
    }

    public void setQtyquickbilling(BigDecimal qtyquickbilling) {
        set(PROPERTY_QTYQUICKBILLING, qtyquickbilling);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public BigDecimal getPricequickbilling() {
        return (BigDecimal) get(PROPERTY_PRICEQUICKBILLING);
    }

    public void setPricequickbilling(BigDecimal pricequickbilling) {
        set(PROPERTY_PRICEQUICKBILLING, pricequickbilling);
    }

    public BigDecimal getPricequickbillinglist() {
        return (BigDecimal) get(PROPERTY_PRICEQUICKBILLINGLIST);
    }

    public void setPricequickbillinglist(BigDecimal pricequickbillinglist) {
        set(PROPERTY_PRICEQUICKBILLINGLIST, pricequickbillinglist);
    }

    public BigDecimal getSubtotalQb() {
        return (BigDecimal) get(PROPERTY_SUBTOTALQB);
    }

    public void setSubtotalQb(BigDecimal subtotalQb) {
        set(PROPERTY_SUBTOTALQB, subtotalQb);
    }

    public BigDecimal getVat() {
        return (BigDecimal) get(PROPERTY_VAT);
    }

    public void setVat(BigDecimal vat) {
        set(PROPERTY_VAT, vat);
    }

    public String getDocstatus() {
        return (String) get(PROPERTY_DOCSTATUS);
    }

    public void setDocstatus(String docstatus) {
        set(PROPERTY_DOCSTATUS, docstatus);
    }

    public TaxRate getTax() {
        return (TaxRate) get(PROPERTY_TAX);
    }

    public void setTax(TaxRate tax) {
        set(PROPERTY_TAX, tax);
    }

    public BigDecimal getDiscount() {
        return (BigDecimal) get(PROPERTY_DISCOUNT);
    }

    public void setDiscount(BigDecimal discount) {
        set(PROPERTY_DISCOUNT, discount);
    }

    public BigDecimal getInitialSubtotal() {
        return (BigDecimal) get(PROPERTY_INITIALSUBTOTAL);
    }

    public void setInitialSubtotal(BigDecimal initialSubtotal) {
        set(PROPERTY_INITIALSUBTOTAL, initialSubtotal);
    }

}
