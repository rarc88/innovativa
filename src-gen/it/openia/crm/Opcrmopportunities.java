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
package it.openia.crm;

import java.math.BigDecimal;
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
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.marketing.Campaign;
/**
 * Entity class for entity opcrm_opportunities (stored in table opcrm_opportunities).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Opcrmopportunities extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "opcrm_opportunities";
    public static final String ENTITY_NAME = "opcrm_opportunities";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_OPPORTUNITYNAME = "opportunityName";
    public static final String PROPERTY_SALESCAMPAIGN = "salesCampaign";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_OPPORTUNITYAMOUNT = "opportunityAmount";
    public static final String PROPERTY_NEXTSTEP = "nextStep";
    public static final String PROPERTY_LEADSOURCE = "leadSource";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_OPPORTUNITYTYPE = "opportunityType";
    public static final String PROPERTY_EXPECTEDCLOSEDATE = "expectedCloseDate";
    public static final String PROPERTY_SALESSTAGE = "salesStage";
    public static final String PROPERTY_PROBABILITY = "probability";
    public static final String PROPERTY_ASSIGNEDTO = "assignedTo";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_SALESORDER = "salesOrder";
    public static final String PROPERTY_CREATEACTIVITY = "createActivity";
    public static final String PROPERTY_ADDUSERS = "addUsers";
    public static final String PROPERTY_SALESQUOTATION = "salesquotation";
    public static final String PROPERTY_OPPORTSTATUS = "opportstatus";
    public static final String PROPERTY_RELATEDLEAD = "relatedLead";
    public static final String PROPERTY_INVOICE = "invoice";
    public static final String PROPERTY_OPCRMACTIVITYLIST = "opcrmActivityList";
    public static final String PROPERTY_OPCRMOPPACCESSLIST = "opcrmOppAccessList";

    public Opcrmopportunities() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_CREATEACTIVITY, false);
        setDefaultValue(PROPERTY_ADDUSERS, false);
        setDefaultValue(PROPERTY_OPCRMACTIVITYLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OPCRMOPPACCESSLIST, new ArrayList<Object>());
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

    public String getOpportunityName() {
        return (String) get(PROPERTY_OPPORTUNITYNAME);
    }

    public void setOpportunityName(String opportunityName) {
        set(PROPERTY_OPPORTUNITYNAME, opportunityName);
    }

    public Campaign getSalesCampaign() {
        return (Campaign) get(PROPERTY_SALESCAMPAIGN);
    }

    public void setSalesCampaign(Campaign salesCampaign) {
        set(PROPERTY_SALESCAMPAIGN, salesCampaign);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public BigDecimal getOpportunityAmount() {
        return (BigDecimal) get(PROPERTY_OPPORTUNITYAMOUNT);
    }

    public void setOpportunityAmount(BigDecimal opportunityAmount) {
        set(PROPERTY_OPPORTUNITYAMOUNT, opportunityAmount);
    }

    public String getNextStep() {
        return (String) get(PROPERTY_NEXTSTEP);
    }

    public void setNextStep(String nextStep) {
        set(PROPERTY_NEXTSTEP, nextStep);
    }

    public String getLeadSource() {
        return (String) get(PROPERTY_LEADSOURCE);
    }

    public void setLeadSource(String leadSource) {
        set(PROPERTY_LEADSOURCE, leadSource);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public String getOpportunityType() {
        return (String) get(PROPERTY_OPPORTUNITYTYPE);
    }

    public void setOpportunityType(String opportunityType) {
        set(PROPERTY_OPPORTUNITYTYPE, opportunityType);
    }

    public Date getExpectedCloseDate() {
        return (Date) get(PROPERTY_EXPECTEDCLOSEDATE);
    }

    public void setExpectedCloseDate(Date expectedCloseDate) {
        set(PROPERTY_EXPECTEDCLOSEDATE, expectedCloseDate);
    }

    public String getSalesStage() {
        return (String) get(PROPERTY_SALESSTAGE);
    }

    public void setSalesStage(String salesStage) {
        set(PROPERTY_SALESSTAGE, salesStage);
    }

    public BigDecimal getProbability() {
        return (BigDecimal) get(PROPERTY_PROBABILITY);
    }

    public void setProbability(BigDecimal probability) {
        set(PROPERTY_PROBABILITY, probability);
    }

    public User getAssignedTo() {
        return (User) get(PROPERTY_ASSIGNEDTO);
    }

    public void setAssignedTo(User assignedTo) {
        set(PROPERTY_ASSIGNEDTO, assignedTo);
    }

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public Order getSalesOrder() {
        return (Order) get(PROPERTY_SALESORDER);
    }

    public void setSalesOrder(Order salesOrder) {
        set(PROPERTY_SALESORDER, salesOrder);
    }

    public Boolean isCreateActivity() {
        return (Boolean) get(PROPERTY_CREATEACTIVITY);
    }

    public void setCreateActivity(Boolean createActivity) {
        set(PROPERTY_CREATEACTIVITY, createActivity);
    }

    public Boolean isAddUsers() {
        return (Boolean) get(PROPERTY_ADDUSERS);
    }

    public void setAddUsers(Boolean addUsers) {
        set(PROPERTY_ADDUSERS, addUsers);
    }

    public Order getSalesquotation() {
        return (Order) get(PROPERTY_SALESQUOTATION);
    }

    public void setSalesquotation(Order salesquotation) {
        set(PROPERTY_SALESQUOTATION, salesquotation);
    }

    public String getOpportstatus() {
        return (String) get(PROPERTY_OPPORTSTATUS);
    }

    public void setOpportstatus(String opportstatus) {
        set(PROPERTY_OPPORTSTATUS, opportstatus);
    }

    public User getRelatedLead() {
        return (User) get(PROPERTY_RELATEDLEAD);
    }

    public void setRelatedLead(User relatedLead) {
        set(PROPERTY_RELATEDLEAD, relatedLead);
    }

    public Invoice getInvoice() {
        return (Invoice) get(PROPERTY_INVOICE);
    }

    public void setInvoice(Invoice invoice) {
        set(PROPERTY_INVOICE, invoice);
    }

    @SuppressWarnings("unchecked")
    public List<Opcrmactivity> getOpcrmActivityList() {
      return (List<Opcrmactivity>) get(PROPERTY_OPCRMACTIVITYLIST);
    }

    public void setOpcrmActivityList(List<Opcrmactivity> opcrmActivityList) {
        set(PROPERTY_OPCRMACTIVITYLIST, opcrmActivityList);
    }

    @SuppressWarnings("unchecked")
    public List<opcrmOppAccess> getOpcrmOppAccessList() {
      return (List<opcrmOppAccess>) get(PROPERTY_OPCRMOPPACCESSLIST);
    }

    public void setOpcrmOppAccessList(List<opcrmOppAccess> opcrmOppAccessList) {
        set(PROPERTY_OPCRMOPPACCESSLIST, opcrmOppAccessList);
    }

}
