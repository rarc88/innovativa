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
package com.sidesoft.flopec.budget.data;

import com.sidesoft.hrm.payroll.ConceptAcct;
import com.sidesoft.hrm.payroll.PayrollTicket;

import ec.com.sidesoft.budget.transfers.SfbtrBudgetaryReforms;
import ec.com.sidesoft.budget.transfers.SfbtrTransferFrom;
import ec.com.sidesoft.budget.transfers.SfbtrTransferTo;
import ec.com.sidesoft.custom.budget.direct.SCBDBudgetDirect;
import ec.com.sidesoft.localization.ecuador.viatical.SSVEViatical;
import ec.com.sidesoft.localization.ecuador.viatical.SSVEViaticalSettlement;
import ec.com.sidesoft.localization.ecuador.viatical.ssve_budget_details_v;
import ec.com.sidesoft.localization.flow.ssfwapprovaldoctype;
import ec.com.sidesoft.quick.billing.SqbConfigQuickBilling;
import ec.com.sidesoft.secondary.accounting.SSACCTJOURNAL;
import ec.com.sidesoft.ws.invoicecreate.data.SWSICConfig;

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
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.common.invoice.InvoiceLine;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.financialmgmt.gl.GLJournal;
import org.openbravo.model.financialmgmt.payment.FIN_Payment;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOut;
/**
 * Entity class for entity sfb_budget_area (stored in table sfb_budget_area).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SFBBudgetArea extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sfb_budget_area";
    public static final String ENTITY_NAME = "sfb_budget_area";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_IDENTIFIER = "identifier";
    public static final String PROPERTY_COMMERCIALNAME = "commercialName";
    public static final String PROPERTY_BUSINESSPARTNEREMSSBPSFBBUDGETAREAIDLIST = "businessPartnerEMSsbpSfbBudgetAreaIDList";
    public static final String PROPERTY_FINPAYMENTEMSFBBUDGETAREAIDLIST = "fINPaymentEMSfbBudgetAreaIDList";
    public static final String PROPERTY_FINANCIALMGMTGLJOURNALEMSFBAREALIST = "financialMgmtGLJournalEMSFBAreaList";
    public static final String PROPERTY_INVOICEEMSFBBUDGETAREAIDLIST = "invoiceEMSfbBudgetAreaIDList";
    public static final String PROPERTY_INVOICELINEEMSFBINBUDGETAREAIDLIST = "invoiceLineEMSfbinBudgetAreaIDList";
    public static final String PROPERTY_MATERIALMGMTSHIPMENTINOUTEMSFBBUDGETAREAIDLIST = "materialMgmtShipmentInOutEMSfbBudgetAreaIDList";
    public static final String PROPERTY_ORDEREMSFBBUDGETAREAIDLIST = "orderEMSfbBudgetAreaIDList";
    public static final String PROPERTY_SCBDBUDGETDIRECTLIST = "sCBDBudgetDirectList";
    public static final String PROPERTY_SFBDEFERREDINVOICELIST = "sFBDeferredInvoiceList";
    public static final String PROPERTY_SSACCTJOURNALBUDGETAREAIDLIST = "sSACCTJOURNALBudgetAreaIDList";
    public static final String PROPERTY_SSPRPAYROLLTICKETEMSSBPSFBBUDGETAREAIDLIST = "sSPRPayrollTicketEMSsbpSfbBudgetAreaIDList";
    public static final String PROPERTY_SSVEVIATICALLIST = "sSVEViaticalList";
    public static final String PROPERTY_SSVEVIATICALSETTLEMENTLIST = "sSVEViaticalSettlementList";
    public static final String PROPERTY_SWSICCONFIGEMSWSICBBUDGETAREAIDLIST = "sWSICConfigEMSwsicbBudgetAreaIDList";
    public static final String PROPERTY_SFBTRBUDGETARYREFORMSLIST = "sfbtrBudgetaryReformsList";
    public static final String PROPERTY_SFBTRTRANSFERFROMLIST = "sfbtrTransferFromList";
    public static final String PROPERTY_SFBTRTRANSFERTOLIST = "sfbtrTransferToList";
    public static final String PROPERTY_SFBBUDGETADDLINELIST = "sfbBudgetAddlineList";
    public static final String PROPERTY_SFBBUDGETAREAITEMLIST = "sfbBudgetAreaItemList";
    public static final String PROPERTY_SFBBUDGETCERTLINEEMSSBPSFBBUDGETAREAIDLIST = "sfbBudgetCertLineEMSsbpSfbBudgetAreaIDList";
    public static final String PROPERTY_SFBBUDGETCERTIFICATELIST = "sfbBudgetCertificateList";
    public static final String PROPERTY_SFBBUDGETCONFIGURATIONLIST = "sfbBudgetConfigurationList";
    public static final String PROPERTY_SFBBUDGETDETAILSVLIST = "sfbBudgetDetailsVList";
    public static final String PROPERTY_SFBBUDGETLINELIST = "sfbBudgetLineList";
    public static final String PROPERTY_SFBBUDGETLOGLIST = "sfbBudgetLogList";
    public static final String PROPERTY_SFBBUDGETLOGAREATOLIST = "sfbBudgetLogAreaToList";
    public static final String PROPERTY_SFBBUDGETLOGVAREAIDLIST = "sfbBudgetLogVAreaIDList";
    public static final String PROPERTY_SFBBUDGETUSERAREALIST = "sfbBudgetUserAreaList";
    public static final String PROPERTY_SQBCONFIGQUICKBILLINGEMSQBBUBUDGETAREAIDLIST = "sqbConfigQuickbillingEMSqbbuBudgetAreaIDList";
    public static final String PROPERTY_SSFWAPPROVALDOCTYPEEMSFBBUDGETAREAIDLIST = "ssfwApprovalDoctypeEMSfbBudgetAreaIDList";
    public static final String PROPERTY_SSPRCONCEPTACCTEMSSBPSFBBUDGETAREAIDLIST = "ssprConceptAcctEMSsbpSfbBudgetAreaIDList";
    public static final String PROPERTY_SSVEBUDGETDETAILSVLIST = "ssveBudgetDetailsVList";

    public SFBBudgetArea() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_BUSINESSPARTNEREMSSBPSFBBUDGETAREAIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTEMSFBBUDGETAREAIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTGLJOURNALEMSFBAREALIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICEEMSFBBUDGETAREAIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELINEEMSFBINBUDGETAREAIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTSHIPMENTINOUTEMSFBBUDGETAREAIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDEREMSFBBUDGETAREAIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCBDBUDGETDIRECTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBDEFERREDINVOICELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSACCTJOURNALBUDGETAREAIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRPAYROLLTICKETEMSSBPSFBBUDGETAREAIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSVEVIATICALLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSVEVIATICALSETTLEMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SWSICCONFIGEMSWSICBBUDGETAREAIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBTRBUDGETARYREFORMSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBTRTRANSFERFROMLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBTRTRANSFERTOLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETADDLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETAREAITEMLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETCERTLINEEMSSBPSFBBUDGETAREAIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETCERTIFICATELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETCONFIGURATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETDETAILSVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETLOGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETLOGAREATOLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETLOGVAREAIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETUSERAREALIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SQBCONFIGQUICKBILLINGEMSQBBUBUDGETAREAIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSFWAPPROVALDOCTYPEEMSFBBUDGETAREAIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRCONCEPTACCTEMSSBPSFBBUDGETAREAIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSVEBUDGETDETAILSVLIST, new ArrayList<Object>());
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

    public String getIdentifier() {
        return (String) get(PROPERTY_IDENTIFIER);
    }

    public void setIdentifier(String identifier) {
        set(PROPERTY_IDENTIFIER, identifier);
    }

    public String getCommercialName() {
        return (String) get(PROPERTY_COMMERCIALNAME);
    }

    public void setCommercialName(String commercialName) {
        set(PROPERTY_COMMERCIALNAME, commercialName);
    }

    @SuppressWarnings("unchecked")
    public List<BusinessPartner> getBusinessPartnerEMSsbpSfbBudgetAreaIDList() {
      return (List<BusinessPartner>) get(PROPERTY_BUSINESSPARTNEREMSSBPSFBBUDGETAREAIDLIST);
    }

    public void setBusinessPartnerEMSsbpSfbBudgetAreaIDList(List<BusinessPartner> businessPartnerEMSsbpSfbBudgetAreaIDList) {
        set(PROPERTY_BUSINESSPARTNEREMSSBPSFBBUDGETAREAIDLIST, businessPartnerEMSsbpSfbBudgetAreaIDList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_Payment> getFINPaymentEMSfbBudgetAreaIDList() {
      return (List<FIN_Payment>) get(PROPERTY_FINPAYMENTEMSFBBUDGETAREAIDLIST);
    }

    public void setFINPaymentEMSfbBudgetAreaIDList(List<FIN_Payment> fINPaymentEMSfbBudgetAreaIDList) {
        set(PROPERTY_FINPAYMENTEMSFBBUDGETAREAIDLIST, fINPaymentEMSfbBudgetAreaIDList);
    }

    @SuppressWarnings("unchecked")
    public List<GLJournal> getFinancialMgmtGLJournalEMSFBAreaList() {
      return (List<GLJournal>) get(PROPERTY_FINANCIALMGMTGLJOURNALEMSFBAREALIST);
    }

    public void setFinancialMgmtGLJournalEMSFBAreaList(List<GLJournal> financialMgmtGLJournalEMSFBAreaList) {
        set(PROPERTY_FINANCIALMGMTGLJOURNALEMSFBAREALIST, financialMgmtGLJournalEMSFBAreaList);
    }

    @SuppressWarnings("unchecked")
    public List<Invoice> getInvoiceEMSfbBudgetAreaIDList() {
      return (List<Invoice>) get(PROPERTY_INVOICEEMSFBBUDGETAREAIDLIST);
    }

    public void setInvoiceEMSfbBudgetAreaIDList(List<Invoice> invoiceEMSfbBudgetAreaIDList) {
        set(PROPERTY_INVOICEEMSFBBUDGETAREAIDLIST, invoiceEMSfbBudgetAreaIDList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceLine> getInvoiceLineEMSfbinBudgetAreaIDList() {
      return (List<InvoiceLine>) get(PROPERTY_INVOICELINEEMSFBINBUDGETAREAIDLIST);
    }

    public void setInvoiceLineEMSfbinBudgetAreaIDList(List<InvoiceLine> invoiceLineEMSfbinBudgetAreaIDList) {
        set(PROPERTY_INVOICELINEEMSFBINBUDGETAREAIDLIST, invoiceLineEMSfbinBudgetAreaIDList);
    }

    @SuppressWarnings("unchecked")
    public List<ShipmentInOut> getMaterialMgmtShipmentInOutEMSfbBudgetAreaIDList() {
      return (List<ShipmentInOut>) get(PROPERTY_MATERIALMGMTSHIPMENTINOUTEMSFBBUDGETAREAIDLIST);
    }

    public void setMaterialMgmtShipmentInOutEMSfbBudgetAreaIDList(List<ShipmentInOut> materialMgmtShipmentInOutEMSfbBudgetAreaIDList) {
        set(PROPERTY_MATERIALMGMTSHIPMENTINOUTEMSFBBUDGETAREAIDLIST, materialMgmtShipmentInOutEMSfbBudgetAreaIDList);
    }

    @SuppressWarnings("unchecked")
    public List<Order> getOrderEMSfbBudgetAreaIDList() {
      return (List<Order>) get(PROPERTY_ORDEREMSFBBUDGETAREAIDLIST);
    }

    public void setOrderEMSfbBudgetAreaIDList(List<Order> orderEMSfbBudgetAreaIDList) {
        set(PROPERTY_ORDEREMSFBBUDGETAREAIDLIST, orderEMSfbBudgetAreaIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SCBDBudgetDirect> getSCBDBudgetDirectList() {
      return (List<SCBDBudgetDirect>) get(PROPERTY_SCBDBUDGETDIRECTLIST);
    }

    public void setSCBDBudgetDirectList(List<SCBDBudgetDirect> sCBDBudgetDirectList) {
        set(PROPERTY_SCBDBUDGETDIRECTLIST, sCBDBudgetDirectList);
    }

    @SuppressWarnings("unchecked")
    public List<SFBDeferredInvoice> getSFBDeferredInvoiceList() {
      return (List<SFBDeferredInvoice>) get(PROPERTY_SFBDEFERREDINVOICELIST);
    }

    public void setSFBDeferredInvoiceList(List<SFBDeferredInvoice> sFBDeferredInvoiceList) {
        set(PROPERTY_SFBDEFERREDINVOICELIST, sFBDeferredInvoiceList);
    }

    @SuppressWarnings("unchecked")
    public List<SSACCTJOURNAL> getSSACCTJOURNALBudgetAreaIDList() {
      return (List<SSACCTJOURNAL>) get(PROPERTY_SSACCTJOURNALBUDGETAREAIDLIST);
    }

    public void setSSACCTJOURNALBudgetAreaIDList(List<SSACCTJOURNAL> sSACCTJOURNALBudgetAreaIDList) {
        set(PROPERTY_SSACCTJOURNALBUDGETAREAIDLIST, sSACCTJOURNALBudgetAreaIDList);
    }

    @SuppressWarnings("unchecked")
    public List<PayrollTicket> getSSPRPayrollTicketEMSsbpSfbBudgetAreaIDList() {
      return (List<PayrollTicket>) get(PROPERTY_SSPRPAYROLLTICKETEMSSBPSFBBUDGETAREAIDLIST);
    }

    public void setSSPRPayrollTicketEMSsbpSfbBudgetAreaIDList(List<PayrollTicket> sSPRPayrollTicketEMSsbpSfbBudgetAreaIDList) {
        set(PROPERTY_SSPRPAYROLLTICKETEMSSBPSFBBUDGETAREAIDLIST, sSPRPayrollTicketEMSsbpSfbBudgetAreaIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SSVEViatical> getSSVEViaticalList() {
      return (List<SSVEViatical>) get(PROPERTY_SSVEVIATICALLIST);
    }

    public void setSSVEViaticalList(List<SSVEViatical> sSVEViaticalList) {
        set(PROPERTY_SSVEVIATICALLIST, sSVEViaticalList);
    }

    @SuppressWarnings("unchecked")
    public List<SSVEViaticalSettlement> getSSVEViaticalSettlementList() {
      return (List<SSVEViaticalSettlement>) get(PROPERTY_SSVEVIATICALSETTLEMENTLIST);
    }

    public void setSSVEViaticalSettlementList(List<SSVEViaticalSettlement> sSVEViaticalSettlementList) {
        set(PROPERTY_SSVEVIATICALSETTLEMENTLIST, sSVEViaticalSettlementList);
    }

    @SuppressWarnings("unchecked")
    public List<SWSICConfig> getSWSICConfigEMSwsicbBudgetAreaIDList() {
      return (List<SWSICConfig>) get(PROPERTY_SWSICCONFIGEMSWSICBBUDGETAREAIDLIST);
    }

    public void setSWSICConfigEMSwsicbBudgetAreaIDList(List<SWSICConfig> sWSICConfigEMSwsicbBudgetAreaIDList) {
        set(PROPERTY_SWSICCONFIGEMSWSICBBUDGETAREAIDLIST, sWSICConfigEMSwsicbBudgetAreaIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SfbtrBudgetaryReforms> getSfbtrBudgetaryReformsList() {
      return (List<SfbtrBudgetaryReforms>) get(PROPERTY_SFBTRBUDGETARYREFORMSLIST);
    }

    public void setSfbtrBudgetaryReformsList(List<SfbtrBudgetaryReforms> sfbtrBudgetaryReformsList) {
        set(PROPERTY_SFBTRBUDGETARYREFORMSLIST, sfbtrBudgetaryReformsList);
    }

    @SuppressWarnings("unchecked")
    public List<SfbtrTransferFrom> getSfbtrTransferFromList() {
      return (List<SfbtrTransferFrom>) get(PROPERTY_SFBTRTRANSFERFROMLIST);
    }

    public void setSfbtrTransferFromList(List<SfbtrTransferFrom> sfbtrTransferFromList) {
        set(PROPERTY_SFBTRTRANSFERFROMLIST, sfbtrTransferFromList);
    }

    @SuppressWarnings("unchecked")
    public List<SfbtrTransferTo> getSfbtrTransferToList() {
      return (List<SfbtrTransferTo>) get(PROPERTY_SFBTRTRANSFERTOLIST);
    }

    public void setSfbtrTransferToList(List<SfbtrTransferTo> sfbtrTransferToList) {
        set(PROPERTY_SFBTRTRANSFERTOLIST, sfbtrTransferToList);
    }

    @SuppressWarnings("unchecked")
    public List<sfbbudgetaddline> getSfbBudgetAddlineList() {
      return (List<sfbbudgetaddline>) get(PROPERTY_SFBBUDGETADDLINELIST);
    }

    public void setSfbBudgetAddlineList(List<sfbbudgetaddline> sfbBudgetAddlineList) {
        set(PROPERTY_SFBBUDGETADDLINELIST, sfbBudgetAddlineList);
    }

    @SuppressWarnings("unchecked")
    public List<SFBBudgetAreaItem> getSfbBudgetAreaItemList() {
      return (List<SFBBudgetAreaItem>) get(PROPERTY_SFBBUDGETAREAITEMLIST);
    }

    public void setSfbBudgetAreaItemList(List<SFBBudgetAreaItem> sfbBudgetAreaItemList) {
        set(PROPERTY_SFBBUDGETAREAITEMLIST, sfbBudgetAreaItemList);
    }

    @SuppressWarnings("unchecked")
    public List<SFBBudgetCertLine> getSfbBudgetCertLineEMSsbpSfbBudgetAreaIDList() {
      return (List<SFBBudgetCertLine>) get(PROPERTY_SFBBUDGETCERTLINEEMSSBPSFBBUDGETAREAIDLIST);
    }

    public void setSfbBudgetCertLineEMSsbpSfbBudgetAreaIDList(List<SFBBudgetCertLine> sfbBudgetCertLineEMSsbpSfbBudgetAreaIDList) {
        set(PROPERTY_SFBBUDGETCERTLINEEMSSBPSFBBUDGETAREAIDLIST, sfbBudgetCertLineEMSsbpSfbBudgetAreaIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SFBBudgetCertificate> getSfbBudgetCertificateList() {
      return (List<SFBBudgetCertificate>) get(PROPERTY_SFBBUDGETCERTIFICATELIST);
    }

    public void setSfbBudgetCertificateList(List<SFBBudgetCertificate> sfbBudgetCertificateList) {
        set(PROPERTY_SFBBUDGETCERTIFICATELIST, sfbBudgetCertificateList);
    }

    @SuppressWarnings("unchecked")
    public List<SFBBudgetConfiguration> getSfbBudgetConfigurationList() {
      return (List<SFBBudgetConfiguration>) get(PROPERTY_SFBBUDGETCONFIGURATIONLIST);
    }

    public void setSfbBudgetConfigurationList(List<SFBBudgetConfiguration> sfbBudgetConfigurationList) {
        set(PROPERTY_SFBBUDGETCONFIGURATIONLIST, sfbBudgetConfigurationList);
    }

    @SuppressWarnings("unchecked")
    public List<sfb_budget_details_v> getSfbBudgetDetailsVList() {
      return (List<sfb_budget_details_v>) get(PROPERTY_SFBBUDGETDETAILSVLIST);
    }

    public void setSfbBudgetDetailsVList(List<sfb_budget_details_v> sfbBudgetDetailsVList) {
        set(PROPERTY_SFBBUDGETDETAILSVLIST, sfbBudgetDetailsVList);
    }

    @SuppressWarnings("unchecked")
    public List<SFBBudgetLine> getSfbBudgetLineList() {
      return (List<SFBBudgetLine>) get(PROPERTY_SFBBUDGETLINELIST);
    }

    public void setSfbBudgetLineList(List<SFBBudgetLine> sfbBudgetLineList) {
        set(PROPERTY_SFBBUDGETLINELIST, sfbBudgetLineList);
    }

    @SuppressWarnings("unchecked")
    public List<SFBBudgetLog> getSfbBudgetLogList() {
      return (List<SFBBudgetLog>) get(PROPERTY_SFBBUDGETLOGLIST);
    }

    public void setSfbBudgetLogList(List<SFBBudgetLog> sfbBudgetLogList) {
        set(PROPERTY_SFBBUDGETLOGLIST, sfbBudgetLogList);
    }

    @SuppressWarnings("unchecked")
    public List<SFBBudgetLog> getSfbBudgetLogAreaToList() {
      return (List<SFBBudgetLog>) get(PROPERTY_SFBBUDGETLOGAREATOLIST);
    }

    public void setSfbBudgetLogAreaToList(List<SFBBudgetLog> sfbBudgetLogAreaToList) {
        set(PROPERTY_SFBBUDGETLOGAREATOLIST, sfbBudgetLogAreaToList);
    }

    @SuppressWarnings("unchecked")
    public List<sfb_budget_log_v> getSfbBudgetLogVAreaIDList() {
      return (List<sfb_budget_log_v>) get(PROPERTY_SFBBUDGETLOGVAREAIDLIST);
    }

    public void setSfbBudgetLogVAreaIDList(List<sfb_budget_log_v> sfbBudgetLogVAreaIDList) {
        set(PROPERTY_SFBBUDGETLOGVAREAIDLIST, sfbBudgetLogVAreaIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SFBBudgetUserArea> getSfbBudgetUserAreaList() {
      return (List<SFBBudgetUserArea>) get(PROPERTY_SFBBUDGETUSERAREALIST);
    }

    public void setSfbBudgetUserAreaList(List<SFBBudgetUserArea> sfbBudgetUserAreaList) {
        set(PROPERTY_SFBBUDGETUSERAREALIST, sfbBudgetUserAreaList);
    }

    @SuppressWarnings("unchecked")
    public List<SqbConfigQuickBilling> getSqbConfigQuickbillingEMSqbbuBudgetAreaIDList() {
      return (List<SqbConfigQuickBilling>) get(PROPERTY_SQBCONFIGQUICKBILLINGEMSQBBUBUDGETAREAIDLIST);
    }

    public void setSqbConfigQuickbillingEMSqbbuBudgetAreaIDList(List<SqbConfigQuickBilling> sqbConfigQuickbillingEMSqbbuBudgetAreaIDList) {
        set(PROPERTY_SQBCONFIGQUICKBILLINGEMSQBBUBUDGETAREAIDLIST, sqbConfigQuickbillingEMSqbbuBudgetAreaIDList);
    }

    @SuppressWarnings("unchecked")
    public List<ssfwapprovaldoctype> getSsfwApprovalDoctypeEMSfbBudgetAreaIDList() {
      return (List<ssfwapprovaldoctype>) get(PROPERTY_SSFWAPPROVALDOCTYPEEMSFBBUDGETAREAIDLIST);
    }

    public void setSsfwApprovalDoctypeEMSfbBudgetAreaIDList(List<ssfwapprovaldoctype> ssfwApprovalDoctypeEMSfbBudgetAreaIDList) {
        set(PROPERTY_SSFWAPPROVALDOCTYPEEMSFBBUDGETAREAIDLIST, ssfwApprovalDoctypeEMSfbBudgetAreaIDList);
    }

    @SuppressWarnings("unchecked")
    public List<ConceptAcct> getSsprConceptAcctEMSsbpSfbBudgetAreaIDList() {
      return (List<ConceptAcct>) get(PROPERTY_SSPRCONCEPTACCTEMSSBPSFBBUDGETAREAIDLIST);
    }

    public void setSsprConceptAcctEMSsbpSfbBudgetAreaIDList(List<ConceptAcct> ssprConceptAcctEMSsbpSfbBudgetAreaIDList) {
        set(PROPERTY_SSPRCONCEPTACCTEMSSBPSFBBUDGETAREAIDLIST, ssprConceptAcctEMSsbpSfbBudgetAreaIDList);
    }

    @SuppressWarnings("unchecked")
    public List<ssve_budget_details_v> getSsveBudgetDetailsVList() {
      return (List<ssve_budget_details_v>) get(PROPERTY_SSVEBUDGETDETAILSVLIST);
    }

    public void setSsveBudgetDetailsVList(List<ssve_budget_details_v> ssveBudgetDetailsVList) {
        set(PROPERTY_SSVEBUDGETDETAILSVLIST, ssveBudgetDetailsVList);
    }

}
