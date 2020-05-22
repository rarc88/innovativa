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
package ec.com.sidesoft.localization.ecuador.withholdingssales;

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
import org.openbravo.model.common.invoice.InvoiceLine;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.financialmgmt.tax.TaxRate;
/**
 * Entity class for entity SSWS_WithholdingSaleLine (stored in table SSWS_WithholdingSaleLine).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SSWSWithholdingSaleLine extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "SSWS_WithholdingSaleLine";
    public static final String ENTITY_NAME = "SSWS_WithholdingSaleLine";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_SSWSWITHHOLDINGSALE = "sswsWithholdingsale";
    public static final String PROPERTY_LINENO = "lineNo";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_LINENETAMOUNT = "lineNetAmount";
    public static final String PROPERTY_LINEIVAAMOUNT = "lineIVAAmount";
    public static final String PROPERTY_WHITHHOLDINGRENTALAMOUNT = "whithholdingRentalAmount";
    public static final String PROPERTY_WHITHHOLDINGIVAAMOUNT = "whithholdingIVAAmount";
    public static final String PROPERTY_TAX = "tax";
    public static final String PROPERTY_INVOICELINE = "invoiceLine";
    public static final String PROPERTY_ISRENTAL = "isRental";

    public SSWSWithholdingSaleLine() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_LINENETAMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_LINEIVAAMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_WHITHHOLDINGRENTALAMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_WHITHHOLDINGIVAAMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_ISRENTAL, true);
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

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public SSWSWithholdingSale getSswsWithholdingsale() {
        return (SSWSWithholdingSale) get(PROPERTY_SSWSWITHHOLDINGSALE);
    }

    public void setSswsWithholdingsale(SSWSWithholdingSale sswsWithholdingsale) {
        set(PROPERTY_SSWSWITHHOLDINGSALE, sswsWithholdingsale);
    }

    public Long getLineNo() {
        return (Long) get(PROPERTY_LINENO);
    }

    public void setLineNo(Long lineNo) {
        set(PROPERTY_LINENO, lineNo);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public BigDecimal getLineNetAmount() {
        return (BigDecimal) get(PROPERTY_LINENETAMOUNT);
    }

    public void setLineNetAmount(BigDecimal lineNetAmount) {
        set(PROPERTY_LINENETAMOUNT, lineNetAmount);
    }

    public BigDecimal getLineIVAAmount() {
        return (BigDecimal) get(PROPERTY_LINEIVAAMOUNT);
    }

    public void setLineIVAAmount(BigDecimal lineIVAAmount) {
        set(PROPERTY_LINEIVAAMOUNT, lineIVAAmount);
    }

    public BigDecimal getWhithholdingRentalAmount() {
        return (BigDecimal) get(PROPERTY_WHITHHOLDINGRENTALAMOUNT);
    }

    public void setWhithholdingRentalAmount(BigDecimal whithholdingRentalAmount) {
        set(PROPERTY_WHITHHOLDINGRENTALAMOUNT, whithholdingRentalAmount);
    }

    public BigDecimal getWhithholdingIVAAmount() {
        return (BigDecimal) get(PROPERTY_WHITHHOLDINGIVAAMOUNT);
    }

    public void setWhithholdingIVAAmount(BigDecimal whithholdingIVAAmount) {
        set(PROPERTY_WHITHHOLDINGIVAAMOUNT, whithholdingIVAAmount);
    }

    public TaxRate getTax() {
        return (TaxRate) get(PROPERTY_TAX);
    }

    public void setTax(TaxRate tax) {
        set(PROPERTY_TAX, tax);
    }

    public InvoiceLine getInvoiceLine() {
        return (InvoiceLine) get(PROPERTY_INVOICELINE);
    }

    public void setInvoiceLine(InvoiceLine invoiceLine) {
        set(PROPERTY_INVOICELINE, invoiceLine);
    }

    public Boolean isRental() {
        return (Boolean) get(PROPERTY_ISRENTAL);
    }

    public void setRental(Boolean isRental) {
        set(PROPERTY_ISRENTAL, isRental);
    }

}
