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
package com.sidesoft.flopec;

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
import org.openbravo.model.financialmgmt.accounting.Costcenter;
/**
 * Entity class for entity ssfl_invoice_voyage (stored in table ssfl_invoice_voyage).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class InvoiceVoyage extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ssfl_invoice_voyage";
    public static final String ENTITY_NAME = "ssfl_invoice_voyage";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_INVOICE = "invoice";
    public static final String PROPERTY_STARTDATE = "startDate";
    public static final String PROPERTY_ENDDATE = "endDate";
    public static final String PROPERTY_BROKERVALUE = "brokerValue";
    public static final String PROPERTY_CONTRACTNO = "contractNo";
    public static final String PROPERTY_CONTRACTDATE = "contractDate";
    public static final String PROPERTY_CUSTOMERVOYAGENO = "customerVoyageNo";
    public static final String PROPERTY_VOYAGENO = "voyageNo";
    public static final String PROPERTY_BILLVIA = "billVia";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_ADDRESS = "address";
    public static final String PROPERTY_SSFLPORT = "ssflPort";
    public static final String PROPERTY_BLDATE = "bldate";
    public static final String PROPERTY_BLREFERENCE = "blreference";
    public static final String PROPERTY_COSTCENTER = "costcenter";
    public static final String PROPERTY_RECAP = "recap";

    public InvoiceVoyage() {
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

    public Invoice getInvoice() {
        return (Invoice) get(PROPERTY_INVOICE);
    }

    public void setInvoice(Invoice invoice) {
        set(PROPERTY_INVOICE, invoice);
    }

    public Date getStartDate() {
        return (Date) get(PROPERTY_STARTDATE);
    }

    public void setStartDate(Date startDate) {
        set(PROPERTY_STARTDATE, startDate);
    }

    public Date getEndDate() {
        return (Date) get(PROPERTY_ENDDATE);
    }

    public void setEndDate(Date endDate) {
        set(PROPERTY_ENDDATE, endDate);
    }

    public BusinessPartner getBrokerValue() {
        return (BusinessPartner) get(PROPERTY_BROKERVALUE);
    }

    public void setBrokerValue(BusinessPartner brokerValue) {
        set(PROPERTY_BROKERVALUE, brokerValue);
    }

    public String getContractNo() {
        return (String) get(PROPERTY_CONTRACTNO);
    }

    public void setContractNo(String contractNo) {
        set(PROPERTY_CONTRACTNO, contractNo);
    }

    public Date getContractDate() {
        return (Date) get(PROPERTY_CONTRACTDATE);
    }

    public void setContractDate(Date contractDate) {
        set(PROPERTY_CONTRACTDATE, contractDate);
    }

    public String getCustomerVoyageNo() {
        return (String) get(PROPERTY_CUSTOMERVOYAGENO);
    }

    public void setCustomerVoyageNo(String customerVoyageNo) {
        set(PROPERTY_CUSTOMERVOYAGENO, customerVoyageNo);
    }

    public String getVoyageNo() {
        return (String) get(PROPERTY_VOYAGENO);
    }

    public void setVoyageNo(String voyageNo) {
        set(PROPERTY_VOYAGENO, voyageNo);
    }

    public String getBillVia() {
        return (String) get(PROPERTY_BILLVIA);
    }

    public void setBillVia(String billVia) {
        set(PROPERTY_BILLVIA, billVia);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public String getAddress() {
        return (String) get(PROPERTY_ADDRESS);
    }

    public void setAddress(String address) {
        set(PROPERTY_ADDRESS, address);
    }

    public Port getSsflPort() {
        return (Port) get(PROPERTY_SSFLPORT);
    }

    public void setSsflPort(Port ssflPort) {
        set(PROPERTY_SSFLPORT, ssflPort);
    }

    public Date getBldate() {
        return (Date) get(PROPERTY_BLDATE);
    }

    public void setBldate(Date bldate) {
        set(PROPERTY_BLDATE, bldate);
    }

    public String getBlreference() {
        return (String) get(PROPERTY_BLREFERENCE);
    }

    public void setBlreference(String blreference) {
        set(PROPERTY_BLREFERENCE, blreference);
    }

    public Costcenter getCostcenter() {
        return (Costcenter) get(PROPERTY_COSTCENTER);
    }

    public void setCostcenter(Costcenter costcenter) {
        set(PROPERTY_COSTCENTER, costcenter);
    }

    public ssflRecap getRecap() {
        return (ssflRecap) get(PROPERTY_RECAP);
    }

    public void setRecap(ssflRecap recap) {
        set(PROPERTY_RECAP, recap);
    }

}
