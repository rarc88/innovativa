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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
 * Entity class for entity ssre_refund (stored in table ssre_refund).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ssrerefund extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ssre_refund";
    public static final String ENTITY_NAME = "ssre_refund";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_TYPE = "type";
    public static final String PROPERTY_CODIGO = "codigo";
    public static final String PROPERTY_SEARCHKEY = "searchKey";
    public static final String PROPERTY_SSWHLIVELIHOODT = "sswhLivelihoodt";
    public static final String PROPERTY_SSWHCODELIVELIHOODT = "sswhCodelivelihoodt";
    public static final String PROPERTY_CUSTOMERACCOUNT = "customerAccount";
    public static final String PROPERTY_INVOICEEMSSREREFUNDEDIDLIST = "invoiceEmSsreRefundedIdList";
    public static final String PROPERTY_INVOICELINEEMSSREREFUNDEDIDLIST = "invoiceLineEMSsreRefundedIDList";

    public ssrerefund() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_CUSTOMERACCOUNT, false);
        setDefaultValue(PROPERTY_INVOICEEMSSREREFUNDEDIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELINEEMSSREREFUNDEDIDLIST, new ArrayList<Object>());
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

    public String getType() {
        return (String) get(PROPERTY_TYPE);
    }

    public void setType(String type) {
        set(PROPERTY_TYPE, type);
    }

    public String getCodigo() {
        return (String) get(PROPERTY_CODIGO);
    }

    public void setCodigo(String codigo) {
        set(PROPERTY_CODIGO, codigo);
    }

    public String getSearchKey() {
        return (String) get(PROPERTY_SEARCHKEY);
    }

    public void setSearchKey(String searchKey) {
        set(PROPERTY_SEARCHKEY, searchKey);
    }

    public SSWHLivelihoodt getSswhLivelihoodt() {
        return (SSWHLivelihoodt) get(PROPERTY_SSWHLIVELIHOODT);
    }

    public void setSswhLivelihoodt(SSWHLivelihoodt sswhLivelihoodt) {
        set(PROPERTY_SSWHLIVELIHOODT, sswhLivelihoodt);
    }

    public SSWHCodelivelihoodt getSswhCodelivelihoodt() {
        return (SSWHCodelivelihoodt) get(PROPERTY_SSWHCODELIVELIHOODT);
    }

    public void setSswhCodelivelihoodt(SSWHCodelivelihoodt sswhCodelivelihoodt) {
        set(PROPERTY_SSWHCODELIVELIHOODT, sswhCodelivelihoodt);
    }

    public Boolean isCustomerAccount() {
        return (Boolean) get(PROPERTY_CUSTOMERACCOUNT);
    }

    public void setCustomerAccount(Boolean customerAccount) {
        set(PROPERTY_CUSTOMERACCOUNT, customerAccount);
    }

    @SuppressWarnings("unchecked")
    public List<Invoice> getInvoiceEmSsreRefundedIdList() {
      return (List<Invoice>) get(PROPERTY_INVOICEEMSSREREFUNDEDIDLIST);
    }

    public void setInvoiceEmSsreRefundedIdList(List<Invoice> invoiceEmSsreRefundedIdList) {
        set(PROPERTY_INVOICEEMSSREREFUNDEDIDLIST, invoiceEmSsreRefundedIdList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceLine> getInvoiceLineEMSsreRefundedIDList() {
      return (List<InvoiceLine>) get(PROPERTY_INVOICELINEEMSSREREFUNDEDIDLIST);
    }

    public void setInvoiceLineEMSsreRefundedIDList(List<InvoiceLine> invoiceLineEMSsreRefundedIDList) {
        set(PROPERTY_INVOICELINEEMSSREREFUNDEDIDLIST, invoiceLineEMSsreRefundedIDList);
    }

}
