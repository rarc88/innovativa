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
package org.openbravo.model.common.order;

import com.sidesoft.flopec.budget.data.SFBBudgetArea;
import com.sidesoft.flopec.budget.data.SFBBudgetCertLineDet;
import com.sidesoft.flopec.budget.data.SFBOrderCloseAttempt;
import com.sidesoft.flopec.budget.data.sfb_budget_details_v;

import ec.com.sidesoft.authorization.process.AuthorizationLLine;
import ec.com.sidesoft.authorization.process.AuthorizationLevel;
import ec.com.sidesoft.localization.ecuador.viatical.ssve_budget_details_v;
import ec.com.sidesoft.localization.flow.ssfworderapproval;

import it.openia.crm.Opcrminvoice;
import it.openia.crm.Opcrmopportunities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.OrderLineTax;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.businesspartner.Location;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.enterprise.Warehouse;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.common.invoice.InvoiceV2;
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.accounting.UserDimension1;
import org.openbravo.model.financialmgmt.accounting.UserDimension2;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
import org.openbravo.model.financialmgmt.cashmgmt.CashJournalLine;
import org.openbravo.model.financialmgmt.gl.GLCharge;
import org.openbravo.model.financialmgmt.payment.DebtPayment;
import org.openbravo.model.financialmgmt.payment.DebtPaymentV;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentMethod;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentSchedInvV;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentSchedOrdV;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentSchedule;
import org.openbravo.model.financialmgmt.payment.Fin_OrigPaymentSchedule;
import org.openbravo.model.financialmgmt.payment.Incoterms;
import org.openbravo.model.financialmgmt.payment.PaymentPriority;
import org.openbravo.model.financialmgmt.payment.PaymentTerm;
import org.openbravo.model.marketing.Campaign;
import org.openbravo.model.materialmgmt.cost.ABCActivity;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOut;
import org.openbravo.model.pricing.pricelist.PriceList;
import org.openbravo.model.project.Project;
import org.openbravo.model.project.ProjectLine;
import org.openbravo.model.project.ProjectPhase;
import org.openbravo.model.shipping.ShippingCompany;
/**
 * Entity class for entity Order (stored in table C_Order).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Order extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_Order";
    public static final String ENTITY_NAME = "Order";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_SALESTRANSACTION = "salesTransaction";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_DOCUMENTSTATUS = "documentStatus";
    public static final String PROPERTY_DOCUMENTACTION = "documentAction";
    public static final String PROPERTY_PROCESSNOW = "processNow";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_DOCUMENTTYPE = "documentType";
    public static final String PROPERTY_TRANSACTIONDOCUMENT = "transactionDocument";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_DELIVERED = "delivered";
    public static final String PROPERTY_REINVOICE = "reinvoice";
    public static final String PROPERTY_PRINT = "print";
    public static final String PROPERTY_SELECTED = "selected";
    public static final String PROPERTY_SALESREPRESENTATIVE = "salesRepresentative";
    public static final String PROPERTY_ORDERDATE = "orderDate";
    public static final String PROPERTY_SCHEDULEDDELIVERYDATE = "scheduledDeliveryDate";
    public static final String PROPERTY_DATEPRINTED = "datePrinted";
    public static final String PROPERTY_ACCOUNTINGDATE = "accountingDate";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_INVOICEADDRESS = "invoiceAddress";
    public static final String PROPERTY_PARTNERADDRESS = "partnerAddress";
    public static final String PROPERTY_ORDERREFERENCE = "orderReference";
    public static final String PROPERTY_PRINTDISCOUNT = "printDiscount";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_FORMOFPAYMENT = "formOfPayment";
    public static final String PROPERTY_PAYMENTTERMS = "paymentTerms";
    public static final String PROPERTY_INVOICETERMS = "invoiceTerms";
    public static final String PROPERTY_DELIVERYTERMS = "deliveryTerms";
    public static final String PROPERTY_FREIGHTCOSTRULE = "freightCostRule";
    public static final String PROPERTY_FREIGHTAMOUNT = "freightAmount";
    public static final String PROPERTY_DELIVERYMETHOD = "deliveryMethod";
    public static final String PROPERTY_SHIPPINGCOMPANY = "shippingCompany";
    public static final String PROPERTY_CHARGE = "charge";
    public static final String PROPERTY_CHARGEAMOUNT = "chargeAmount";
    public static final String PROPERTY_PRIORITY = "priority";
    public static final String PROPERTY_SUMMEDLINEAMOUNT = "summedLineAmount";
    public static final String PROPERTY_GRANDTOTALAMOUNT = "grandTotalAmount";
    public static final String PROPERTY_WAREHOUSE = "warehouse";
    public static final String PROPERTY_PRICELIST = "priceList";
    public static final String PROPERTY_PRICEINCLUDESTAX = "priceIncludesTax";
    public static final String PROPERTY_SALESCAMPAIGN = "salesCampaign";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_ACTIVITY = "activity";
    public static final String PROPERTY_POSTED = "posted";
    public static final String PROPERTY_USERCONTACT = "userContact";
    public static final String PROPERTY_COPYFROM = "copyFrom";
    public static final String PROPERTY_DROPSHIPPARTNER = "dropShipPartner";
    public static final String PROPERTY_DROPSHIPLOCATION = "dropShipLocation";
    public static final String PROPERTY_DROPSHIPCONTACT = "dropShipContact";
    public static final String PROPERTY_SELFSERVICE = "selfService";
    public static final String PROPERTY_TRXORGANIZATION = "trxOrganization";
    public static final String PROPERTY_STDIMENSION = "stDimension";
    public static final String PROPERTY_NDDIMENSION = "ndDimension";
    public static final String PROPERTY_DELIVERYNOTES = "deliveryNotes";
    public static final String PROPERTY_INCOTERMS = "incoterms";
    public static final String PROPERTY_INCOTERMSDESCRIPTION = "iNCOTERMSDescription";
    public static final String PROPERTY_GENERATETEMPLATE = "generateTemplate";
    public static final String PROPERTY_DELIVERYLOCATION = "deliveryLocation";
    public static final String PROPERTY_COPYFROMPO = "copyFromPO";
    public static final String PROPERTY_PAYMENTMETHOD = "paymentMethod";
    public static final String PROPERTY_FINPAYMENTPRIORITY = "fINPaymentPriority";
    public static final String PROPERTY_PICKFROMSHIPMENT = "pickFromShipment";
    public static final String PROPERTY_RECEIVEMATERIALS = "receiveMaterials";
    public static final String PROPERTY_CREATEINVOICE = "createInvoice";
    public static final String PROPERTY_RETURNREASON = "returnReason";
    public static final String PROPERTY_ADDORPHANLINE = "addOrphanLine";
    public static final String PROPERTY_ASSET = "asset";
    public static final String PROPERTY_CALCULATEPROMOTIONS = "calculatePromotions";
    public static final String PROPERTY_COSTCENTER = "costcenter";
    public static final String PROPERTY_CREATEORDER = "createOrder";
    public static final String PROPERTY_REJECTREASON = "rejectReason";
    public static final String PROPERTY_VALIDUNTIL = "validUntil";
    public static final String PROPERTY_QUOTATION = "quotation";
    public static final String PROPERTY_RESERVATIONSTATUS = "reservationStatus";
    public static final String PROPERTY_CREATEPOLINES = "createPOLines";
    public static final String PROPERTY_CASHVAT = "cashVAT";
    public static final String PROPERTY_SFBHASHCODE = "sfbHashCode";
    public static final String PROPERTY_PICKFROMRECEIPT = "pickfromreceipt";
    public static final String PROPERTY_CANCELANDREPLACE = "cancelandreplace";
    public static final String PROPERTY_APRMADDPAYMENT = "aPRMAddPayment";
    public static final String PROPERTY_OPCRMCREATEOPPORT = "opcrmCreateOpport";
    public static final String PROPERTY_SFBNOBUDGETABLE = "sFBNoBudgetable";
    public static final String PROPERTY_OPCRMOPPFROMQUOT = "opcrmOppFromQuot";
    public static final String PROPERTY_SFBBUDGETAREA = "sfbBudgetArea";
    public static final String PROPERTY_OPCRMRELATEDLEAD = "opcrmRelatedlead";
    public static final String PROPERTY_SFBISBUDGETED = "sfbIsbudgeted";
    public static final String PROPERTY_SSFLENDDATE = "ssflEnddate";
    public static final String PROPERTY_SSFLORDERREFERENCE = "ssflOrderReference";
    public static final String PROPERTY_SSFWAPPROVAL = "ssfwApproval";
    public static final String PROPERTY_CONFIRMCANCELANDREPLACE = "confirmcancelandreplace";
    public static final String PROPERTY_SSFWREJECT = "ssfwReject";
    public static final String PROPERTY_CANCELLEDORDER = "cancelledorder";
    public static final String PROPERTY_REPLACEDORDER = "replacedorder";
    public static final String PROPERTY_ECSAPSIGN = "ecsapSign";
    public static final String PROPERTY_ISCANCELLED = "iscancelled";
    public static final String PROPERTY_ECSAPAUTHORIZATION = "ecsapAuthorization";
    public static final String PROPERTY_ECSAPAUTHLEVEL = "ecsapAuthLevel";
    public static final String PROPERTY_REPLACEMENTORDER = "replacementorder";
    public static final String PROPERTY_ECSAPSIGNED = "ecsapSigned";
    public static final String PROPERTY_ECSAPREJECT = "ecsapReject";
    public static final String PROPERTY__COMPUTEDCOLUMNS = "_computedColumns";
    public static final String PROPERTY_DEBTPAYMENTVLIST = "debtPaymentVList";
    public static final String PROPERTY_ECSAPAUTHOLINELIST = "eCSAPAuthoLineList";
    public static final String PROPERTY_FINPAYMENTSCHEDINVVLIST = "fINPaymentSchedInvVList";
    public static final String PROPERTY_FINPAYMENTSCHEDORDVLIST = "fINPaymentSchedOrdVList";
    public static final String PROPERTY_FINPAYMENTSCHEDULELIST = "fINPaymentScheduleList";
    public static final String PROPERTY_FINORIGPAYMENTSCHEDULELIST = "finOrigPaymentScheduleList";
    public static final String PROPERTY_FINANCIALMGMTDEBTPAYMENTLIST = "financialMgmtDebtPaymentList";
    public static final String PROPERTY_FINANCIALMGMTJOURNALLINELIST = "financialMgmtJournalLineList";
    public static final String PROPERTY_INVOICELIST = "invoiceList";
    public static final String PROPERTY_INVOICEV2LIST = "invoiceV2List";
    public static final String PROPERTY_MATERIALMGMTSHIPMENTINOUTLIST = "materialMgmtShipmentInOutList";
    public static final String PROPERTY_ORDERQUOTATIONLIST = "orderQuotationList";
    public static final String PROPERTY_ORDERCANCELLEDORDERLIST = "orderCancelledorderList";
    public static final String PROPERTY_ORDERREPLACEDORDERLIST = "orderReplacedorderList";
    public static final String PROPERTY_ORDERREPLACEMENTORDERIDLIST = "orderReplacementorderIDList";
    public static final String PROPERTY_ORDERDISCOUNTLIST = "orderDiscountList";
    public static final String PROPERTY_ORDERLINELIST = "orderLineList";
    public static final String PROPERTY_ORDERLINETAXLIST = "orderLineTaxList";
    public static final String PROPERTY_ORDERTAXLIST = "orderTaxList";
    public static final String PROPERTY_PROJECTLINELIST = "projectLineList";
    public static final String PROPERTY_PROJECTLINEPURCHASEORDERLIST = "projectLinePurchaseOrderList";
    public static final String PROPERTY_PROJECTPHASELIST = "projectPhaseList";
    public static final String PROPERTY_SFBORDERCLOSEATTEMPTLIST = "sFBOrderCloseAttemptList";
    public static final String PROPERTY_OPCRMINVOICELIST = "opcrmInvoiceList";
    public static final String PROPERTY_OPCRMOPPORTUNITIESLIST = "opcrmOpportunitiesList";
    public static final String PROPERTY_OPCRMOPPORTUNITIESSALESQUOTATIONIDLIST = "opcrmOpportunitiesSalesquotationIDList";
    public static final String PROPERTY_SFBBUDGETCERTLINEDETVLIST = "sfbBudgetCertLineDetVList";
    public static final String PROPERTY_SFBBUDGETDETAILSVLIST = "sfbBudgetDetailsVList";
    public static final String PROPERTY_SSFWORDERAPPROVALLIST = "ssfwOrderApprovalList";
    public static final String PROPERTY_SSVEBUDGETDETAILSVLIST = "ssveBudgetDetailsVList";


    // Computed columns properties, these properties cannot be directly accessed, they need
    // to be read through _commputedColumns proxy. They cannot be directly used in HQL, OBQuery
    // nor OBCriteria. 
    public static final String COMPUTED_COLUMN_DELIVERYSTATUS = "deliveryStatus";
    public static final String COMPUTED_COLUMN_INVOICESTATUS = "invoiceStatus";
    public static final String COMPUTED_COLUMN_PAYMENTSTATUS = "paymentStatus";

    public Order() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_DOCUMENTSTATUS, "DR");
        setDefaultValue(PROPERTY_DOCUMENTACTION, "CO");
        setDefaultValue(PROPERTY_PROCESSNOW, false);
        setDefaultValue(PROPERTY_PROCESSED, false);
        setDefaultValue(PROPERTY_DELIVERED, false);
        setDefaultValue(PROPERTY_REINVOICE, false);
        setDefaultValue(PROPERTY_PRINT, false);
        setDefaultValue(PROPERTY_SELECTED, false);
        setDefaultValue(PROPERTY_PRINTDISCOUNT, false);
        setDefaultValue(PROPERTY_FORMOFPAYMENT, "B");
        setDefaultValue(PROPERTY_INVOICETERMS, "D");
        setDefaultValue(PROPERTY_DELIVERYTERMS, "A");
        setDefaultValue(PROPERTY_FREIGHTCOSTRULE, "I");
        setDefaultValue(PROPERTY_DELIVERYMETHOD, "P");
        setDefaultValue(PROPERTY_CHARGEAMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_PRIORITY, "5");
        setDefaultValue(PROPERTY_PRICEINCLUDESTAX, false);
        setDefaultValue(PROPERTY_POSTED, "N");
        setDefaultValue(PROPERTY_COPYFROM, false);
        setDefaultValue(PROPERTY_SELFSERVICE, false);
        setDefaultValue(PROPERTY_GENERATETEMPLATE, false);
        setDefaultValue(PROPERTY_COPYFROMPO, false);
        setDefaultValue(PROPERTY_PICKFROMSHIPMENT, false);
        setDefaultValue(PROPERTY_RECEIVEMATERIALS, false);
        setDefaultValue(PROPERTY_CREATEINVOICE, false);
        setDefaultValue(PROPERTY_ADDORPHANLINE, false);
        setDefaultValue(PROPERTY_CALCULATEPROMOTIONS, false);
        setDefaultValue(PROPERTY_CREATEORDER, false);
        setDefaultValue(PROPERTY_CREATEPOLINES, false);
        setDefaultValue(PROPERTY_CASHVAT, false);
        setDefaultValue(PROPERTY_PICKFROMRECEIPT, false);
        setDefaultValue(PROPERTY_CANCELANDREPLACE, false);
        setDefaultValue(PROPERTY_APRMADDPAYMENT, false);
        setDefaultValue(PROPERTY_OPCRMCREATEOPPORT, false);
        setDefaultValue(PROPERTY_SFBNOBUDGETABLE, false);
        setDefaultValue(PROPERTY_OPCRMOPPFROMQUOT, false);
        setDefaultValue(PROPERTY_SFBISBUDGETED, false);
        setDefaultValue(PROPERTY_SSFWAPPROVAL, false);
        setDefaultValue(PROPERTY_CONFIRMCANCELANDREPLACE, false);
        setDefaultValue(PROPERTY_SSFWREJECT, "RE");
        setDefaultValue(PROPERTY_ECSAPSIGN, false);
        setDefaultValue(PROPERTY_ISCANCELLED, false);
        setDefaultValue(PROPERTY_ECSAPAUTHORIZATION, false);
        setDefaultValue(PROPERTY_ECSAPSIGNED, false);
        setDefaultValue(PROPERTY_ECSAPREJECT, false);
        setDefaultValue(PROPERTY_DEBTPAYMENTVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ECSAPAUTHOLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTSCHEDINVVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTSCHEDORDVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTSCHEDULELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINORIGPAYMENTSCHEDULELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTDEBTPAYMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTJOURNALLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICEV2LIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTSHIPMENTINOUTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERQUOTATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERCANCELLEDORDERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERREPLACEDORDERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERREPLACEMENTORDERIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERDISCOUNTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERLINETAXLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERTAXLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROJECTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROJECTLINEPURCHASEORDERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROJECTPHASELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBORDERCLOSEATTEMPTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OPCRMINVOICELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OPCRMOPPORTUNITIESLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OPCRMOPPORTUNITIESSALESQUOTATIONIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETCERTLINEDETVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETDETAILSVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSFWORDERAPPROVALLIST, new ArrayList<Object>());
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

    public Boolean isSalesTransaction() {
        return (Boolean) get(PROPERTY_SALESTRANSACTION);
    }

    public void setSalesTransaction(Boolean salesTransaction) {
        set(PROPERTY_SALESTRANSACTION, salesTransaction);
    }

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

    public String getDocumentStatus() {
        return (String) get(PROPERTY_DOCUMENTSTATUS);
    }

    public void setDocumentStatus(String documentStatus) {
        set(PROPERTY_DOCUMENTSTATUS, documentStatus);
    }

    public String getDocumentAction() {
        return (String) get(PROPERTY_DOCUMENTACTION);
    }

    public void setDocumentAction(String documentAction) {
        set(PROPERTY_DOCUMENTACTION, documentAction);
    }

    public Boolean isProcessNow() {
        return (Boolean) get(PROPERTY_PROCESSNOW);
    }

    public void setProcessNow(Boolean processNow) {
        set(PROPERTY_PROCESSNOW, processNow);
    }

    public Boolean isProcessed() {
        return (Boolean) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(Boolean processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public DocumentType getDocumentType() {
        return (DocumentType) get(PROPERTY_DOCUMENTTYPE);
    }

    public void setDocumentType(DocumentType documentType) {
        set(PROPERTY_DOCUMENTTYPE, documentType);
    }

    public DocumentType getTransactionDocument() {
        return (DocumentType) get(PROPERTY_TRANSACTIONDOCUMENT);
    }

    public void setTransactionDocument(DocumentType transactionDocument) {
        set(PROPERTY_TRANSACTIONDOCUMENT, transactionDocument);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Boolean isDelivered() {
        return (Boolean) get(PROPERTY_DELIVERED);
    }

    public void setDelivered(Boolean delivered) {
        set(PROPERTY_DELIVERED, delivered);
    }

    public Boolean isReinvoice() {
        return (Boolean) get(PROPERTY_REINVOICE);
    }

    public void setReinvoice(Boolean reinvoice) {
        set(PROPERTY_REINVOICE, reinvoice);
    }

    public Boolean isPrint() {
        return (Boolean) get(PROPERTY_PRINT);
    }

    public void setPrint(Boolean print) {
        set(PROPERTY_PRINT, print);
    }

    public Boolean isSelected() {
        return (Boolean) get(PROPERTY_SELECTED);
    }

    public void setSelected(Boolean selected) {
        set(PROPERTY_SELECTED, selected);
    }

    public User getSalesRepresentative() {
        return (User) get(PROPERTY_SALESREPRESENTATIVE);
    }

    public void setSalesRepresentative(User salesRepresentative) {
        set(PROPERTY_SALESREPRESENTATIVE, salesRepresentative);
    }

    public Date getOrderDate() {
        return (Date) get(PROPERTY_ORDERDATE);
    }

    public void setOrderDate(Date orderDate) {
        set(PROPERTY_ORDERDATE, orderDate);
    }

    public Date getScheduledDeliveryDate() {
        return (Date) get(PROPERTY_SCHEDULEDDELIVERYDATE);
    }

    public void setScheduledDeliveryDate(Date scheduledDeliveryDate) {
        set(PROPERTY_SCHEDULEDDELIVERYDATE, scheduledDeliveryDate);
    }

    public Date getDatePrinted() {
        return (Date) get(PROPERTY_DATEPRINTED);
    }

    public void setDatePrinted(Date datePrinted) {
        set(PROPERTY_DATEPRINTED, datePrinted);
    }

    public Date getAccountingDate() {
        return (Date) get(PROPERTY_ACCOUNTINGDATE);
    }

    public void setAccountingDate(Date accountingDate) {
        set(PROPERTY_ACCOUNTINGDATE, accountingDate);
    }

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public Location getInvoiceAddress() {
        return (Location) get(PROPERTY_INVOICEADDRESS);
    }

    public void setInvoiceAddress(Location invoiceAddress) {
        set(PROPERTY_INVOICEADDRESS, invoiceAddress);
    }

    public Location getPartnerAddress() {
        return (Location) get(PROPERTY_PARTNERADDRESS);
    }

    public void setPartnerAddress(Location partnerAddress) {
        set(PROPERTY_PARTNERADDRESS, partnerAddress);
    }

    public String getOrderReference() {
        return (String) get(PROPERTY_ORDERREFERENCE);
    }

    public void setOrderReference(String orderReference) {
        set(PROPERTY_ORDERREFERENCE, orderReference);
    }

    public Boolean isPrintDiscount() {
        return (Boolean) get(PROPERTY_PRINTDISCOUNT);
    }

    public void setPrintDiscount(Boolean printDiscount) {
        set(PROPERTY_PRINTDISCOUNT, printDiscount);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public String getFormOfPayment() {
        return (String) get(PROPERTY_FORMOFPAYMENT);
    }

    public void setFormOfPayment(String formOfPayment) {
        set(PROPERTY_FORMOFPAYMENT, formOfPayment);
    }

    public PaymentTerm getPaymentTerms() {
        return (PaymentTerm) get(PROPERTY_PAYMENTTERMS);
    }

    public void setPaymentTerms(PaymentTerm paymentTerms) {
        set(PROPERTY_PAYMENTTERMS, paymentTerms);
    }

    public String getInvoiceTerms() {
        return (String) get(PROPERTY_INVOICETERMS);
    }

    public void setInvoiceTerms(String invoiceTerms) {
        set(PROPERTY_INVOICETERMS, invoiceTerms);
    }

    public String getDeliveryTerms() {
        return (String) get(PROPERTY_DELIVERYTERMS);
    }

    public void setDeliveryTerms(String deliveryTerms) {
        set(PROPERTY_DELIVERYTERMS, deliveryTerms);
    }

    public String getFreightCostRule() {
        return (String) get(PROPERTY_FREIGHTCOSTRULE);
    }

    public void setFreightCostRule(String freightCostRule) {
        set(PROPERTY_FREIGHTCOSTRULE, freightCostRule);
    }

    public BigDecimal getFreightAmount() {
        return (BigDecimal) get(PROPERTY_FREIGHTAMOUNT);
    }

    public void setFreightAmount(BigDecimal freightAmount) {
        set(PROPERTY_FREIGHTAMOUNT, freightAmount);
    }

    public String getDeliveryMethod() {
        return (String) get(PROPERTY_DELIVERYMETHOD);
    }

    public void setDeliveryMethod(String deliveryMethod) {
        set(PROPERTY_DELIVERYMETHOD, deliveryMethod);
    }

    public ShippingCompany getShippingCompany() {
        return (ShippingCompany) get(PROPERTY_SHIPPINGCOMPANY);
    }

    public void setShippingCompany(ShippingCompany shippingCompany) {
        set(PROPERTY_SHIPPINGCOMPANY, shippingCompany);
    }

    public GLCharge getCharge() {
        return (GLCharge) get(PROPERTY_CHARGE);
    }

    public void setCharge(GLCharge charge) {
        set(PROPERTY_CHARGE, charge);
    }

    public BigDecimal getChargeAmount() {
        return (BigDecimal) get(PROPERTY_CHARGEAMOUNT);
    }

    public void setChargeAmount(BigDecimal chargeAmount) {
        set(PROPERTY_CHARGEAMOUNT, chargeAmount);
    }

    public String getPriority() {
        return (String) get(PROPERTY_PRIORITY);
    }

    public void setPriority(String priority) {
        set(PROPERTY_PRIORITY, priority);
    }

    public BigDecimal getSummedLineAmount() {
        return (BigDecimal) get(PROPERTY_SUMMEDLINEAMOUNT);
    }

    public void setSummedLineAmount(BigDecimal summedLineAmount) {
        set(PROPERTY_SUMMEDLINEAMOUNT, summedLineAmount);
    }

    public BigDecimal getGrandTotalAmount() {
        return (BigDecimal) get(PROPERTY_GRANDTOTALAMOUNT);
    }

    public void setGrandTotalAmount(BigDecimal grandTotalAmount) {
        set(PROPERTY_GRANDTOTALAMOUNT, grandTotalAmount);
    }

    public Warehouse getWarehouse() {
        return (Warehouse) get(PROPERTY_WAREHOUSE);
    }

    public void setWarehouse(Warehouse warehouse) {
        set(PROPERTY_WAREHOUSE, warehouse);
    }

    public PriceList getPriceList() {
        return (PriceList) get(PROPERTY_PRICELIST);
    }

    public void setPriceList(PriceList priceList) {
        set(PROPERTY_PRICELIST, priceList);
    }

    public Boolean isPriceIncludesTax() {
        return (Boolean) get(PROPERTY_PRICEINCLUDESTAX);
    }

    public void setPriceIncludesTax(Boolean priceIncludesTax) {
        set(PROPERTY_PRICEINCLUDESTAX, priceIncludesTax);
    }

    public Campaign getSalesCampaign() {
        return (Campaign) get(PROPERTY_SALESCAMPAIGN);
    }

    public void setSalesCampaign(Campaign salesCampaign) {
        set(PROPERTY_SALESCAMPAIGN, salesCampaign);
    }

    public Project getProject() {
        return (Project) get(PROPERTY_PROJECT);
    }

    public void setProject(Project project) {
        set(PROPERTY_PROJECT, project);
    }

    public ABCActivity getActivity() {
        return (ABCActivity) get(PROPERTY_ACTIVITY);
    }

    public void setActivity(ABCActivity activity) {
        set(PROPERTY_ACTIVITY, activity);
    }

    public String getPosted() {
        return (String) get(PROPERTY_POSTED);
    }

    public void setPosted(String posted) {
        set(PROPERTY_POSTED, posted);
    }

    public User getUserContact() {
        return (User) get(PROPERTY_USERCONTACT);
    }

    public void setUserContact(User userContact) {
        set(PROPERTY_USERCONTACT, userContact);
    }

    public Boolean isCopyFrom() {
        return (Boolean) get(PROPERTY_COPYFROM);
    }

    public void setCopyFrom(Boolean copyFrom) {
        set(PROPERTY_COPYFROM, copyFrom);
    }

    public BusinessPartner getDropShipPartner() {
        return (BusinessPartner) get(PROPERTY_DROPSHIPPARTNER);
    }

    public void setDropShipPartner(BusinessPartner dropShipPartner) {
        set(PROPERTY_DROPSHIPPARTNER, dropShipPartner);
    }

    public Location getDropShipLocation() {
        return (Location) get(PROPERTY_DROPSHIPLOCATION);
    }

    public void setDropShipLocation(Location dropShipLocation) {
        set(PROPERTY_DROPSHIPLOCATION, dropShipLocation);
    }

    public User getDropShipContact() {
        return (User) get(PROPERTY_DROPSHIPCONTACT);
    }

    public void setDropShipContact(User dropShipContact) {
        set(PROPERTY_DROPSHIPCONTACT, dropShipContact);
    }

    public Boolean isSelfService() {
        return (Boolean) get(PROPERTY_SELFSERVICE);
    }

    public void setSelfService(Boolean selfService) {
        set(PROPERTY_SELFSERVICE, selfService);
    }

    public Organization getTrxOrganization() {
        return (Organization) get(PROPERTY_TRXORGANIZATION);
    }

    public void setTrxOrganization(Organization trxOrganization) {
        set(PROPERTY_TRXORGANIZATION, trxOrganization);
    }

    public UserDimension1 getStDimension() {
        return (UserDimension1) get(PROPERTY_STDIMENSION);
    }

    public void setStDimension(UserDimension1 stDimension) {
        set(PROPERTY_STDIMENSION, stDimension);
    }

    public UserDimension2 getNdDimension() {
        return (UserDimension2) get(PROPERTY_NDDIMENSION);
    }

    public void setNdDimension(UserDimension2 ndDimension) {
        set(PROPERTY_NDDIMENSION, ndDimension);
    }

    public String getDeliveryNotes() {
        return (String) get(PROPERTY_DELIVERYNOTES);
    }

    public void setDeliveryNotes(String deliveryNotes) {
        set(PROPERTY_DELIVERYNOTES, deliveryNotes);
    }

    public Incoterms getIncoterms() {
        return (Incoterms) get(PROPERTY_INCOTERMS);
    }

    public void setIncoterms(Incoterms incoterms) {
        set(PROPERTY_INCOTERMS, incoterms);
    }

    public String getINCOTERMSDescription() {
        return (String) get(PROPERTY_INCOTERMSDESCRIPTION);
    }

    public void setINCOTERMSDescription(String iNCOTERMSDescription) {
        set(PROPERTY_INCOTERMSDESCRIPTION, iNCOTERMSDescription);
    }

    public Boolean isGenerateTemplate() {
        return (Boolean) get(PROPERTY_GENERATETEMPLATE);
    }

    public void setGenerateTemplate(Boolean generateTemplate) {
        set(PROPERTY_GENERATETEMPLATE, generateTemplate);
    }

    public Location getDeliveryLocation() {
        return (Location) get(PROPERTY_DELIVERYLOCATION);
    }

    public void setDeliveryLocation(Location deliveryLocation) {
        set(PROPERTY_DELIVERYLOCATION, deliveryLocation);
    }

    public Boolean isCopyFromPO() {
        return (Boolean) get(PROPERTY_COPYFROMPO);
    }

    public void setCopyFromPO(Boolean copyFromPO) {
        set(PROPERTY_COPYFROMPO, copyFromPO);
    }

    public FIN_PaymentMethod getPaymentMethod() {
        return (FIN_PaymentMethod) get(PROPERTY_PAYMENTMETHOD);
    }

    public void setPaymentMethod(FIN_PaymentMethod paymentMethod) {
        set(PROPERTY_PAYMENTMETHOD, paymentMethod);
    }

    public PaymentPriority getFINPaymentPriority() {
        return (PaymentPriority) get(PROPERTY_FINPAYMENTPRIORITY);
    }

    public void setFINPaymentPriority(PaymentPriority fINPaymentPriority) {
        set(PROPERTY_FINPAYMENTPRIORITY, fINPaymentPriority);
    }

    public Boolean isPickFromShipment() {
        return (Boolean) get(PROPERTY_PICKFROMSHIPMENT);
    }

    public void setPickFromShipment(Boolean pickFromShipment) {
        set(PROPERTY_PICKFROMSHIPMENT, pickFromShipment);
    }

    public Boolean isReceiveMaterials() {
        return (Boolean) get(PROPERTY_RECEIVEMATERIALS);
    }

    public void setReceiveMaterials(Boolean receiveMaterials) {
        set(PROPERTY_RECEIVEMATERIALS, receiveMaterials);
    }

    public Boolean isCreateInvoice() {
        return (Boolean) get(PROPERTY_CREATEINVOICE);
    }

    public void setCreateInvoice(Boolean createInvoice) {
        set(PROPERTY_CREATEINVOICE, createInvoice);
    }

    public ReturnReason getReturnReason() {
        return (ReturnReason) get(PROPERTY_RETURNREASON);
    }

    public void setReturnReason(ReturnReason returnReason) {
        set(PROPERTY_RETURNREASON, returnReason);
    }

    public Boolean isAddOrphanLine() {
        return (Boolean) get(PROPERTY_ADDORPHANLINE);
    }

    public void setAddOrphanLine(Boolean addOrphanLine) {
        set(PROPERTY_ADDORPHANLINE, addOrphanLine);
    }

    public Asset getAsset() {
        return (Asset) get(PROPERTY_ASSET);
    }

    public void setAsset(Asset asset) {
        set(PROPERTY_ASSET, asset);
    }

    public Boolean isCalculatePromotions() {
        return (Boolean) get(PROPERTY_CALCULATEPROMOTIONS);
    }

    public void setCalculatePromotions(Boolean calculatePromotions) {
        set(PROPERTY_CALCULATEPROMOTIONS, calculatePromotions);
    }

    public Costcenter getCostcenter() {
        return (Costcenter) get(PROPERTY_COSTCENTER);
    }

    public void setCostcenter(Costcenter costcenter) {
        set(PROPERTY_COSTCENTER, costcenter);
    }

    public Boolean isCreateOrder() {
        return (Boolean) get(PROPERTY_CREATEORDER);
    }

    public void setCreateOrder(Boolean createOrder) {
        set(PROPERTY_CREATEORDER, createOrder);
    }

    public RejectReason getRejectReason() {
        return (RejectReason) get(PROPERTY_REJECTREASON);
    }

    public void setRejectReason(RejectReason rejectReason) {
        set(PROPERTY_REJECTREASON, rejectReason);
    }

    public Date getValidUntil() {
        return (Date) get(PROPERTY_VALIDUNTIL);
    }

    public void setValidUntil(Date validUntil) {
        set(PROPERTY_VALIDUNTIL, validUntil);
    }

    public Order getQuotation() {
        return (Order) get(PROPERTY_QUOTATION);
    }

    public void setQuotation(Order quotation) {
        set(PROPERTY_QUOTATION, quotation);
    }

    public String getReservationStatus() {
        return (String) get(PROPERTY_RESERVATIONSTATUS);
    }

    public void setReservationStatus(String reservationStatus) {
        set(PROPERTY_RESERVATIONSTATUS, reservationStatus);
    }

    public Boolean isCreatePOLines() {
        return (Boolean) get(PROPERTY_CREATEPOLINES);
    }

    public void setCreatePOLines(Boolean createPOLines) {
        set(PROPERTY_CREATEPOLINES, createPOLines);
    }

    public Boolean isCashVAT() {
        return (Boolean) get(PROPERTY_CASHVAT);
    }

    public void setCashVAT(Boolean cashVAT) {
        set(PROPERTY_CASHVAT, cashVAT);
    }

    public String getSfbHashCode() {
        return (String) get(PROPERTY_SFBHASHCODE);
    }

    public void setSfbHashCode(String sfbHashCode) {
        set(PROPERTY_SFBHASHCODE, sfbHashCode);
    }

    public Boolean isPickfromreceipt() {
        return (Boolean) get(PROPERTY_PICKFROMRECEIPT);
    }

    public void setPickfromreceipt(Boolean pickfromreceipt) {
        set(PROPERTY_PICKFROMRECEIPT, pickfromreceipt);
    }

    public Boolean isCancelandreplace() {
        return (Boolean) get(PROPERTY_CANCELANDREPLACE);
    }

    public void setCancelandreplace(Boolean cancelandreplace) {
        set(PROPERTY_CANCELANDREPLACE, cancelandreplace);
    }

    public Boolean isAPRMAddPayment() {
        return (Boolean) get(PROPERTY_APRMADDPAYMENT);
    }

    public void setAPRMAddPayment(Boolean aPRMAddPayment) {
        set(PROPERTY_APRMADDPAYMENT, aPRMAddPayment);
    }

    public Boolean isOpcrmCreateOpport() {
        return (Boolean) get(PROPERTY_OPCRMCREATEOPPORT);
    }

    public void setOpcrmCreateOpport(Boolean opcrmCreateOpport) {
        set(PROPERTY_OPCRMCREATEOPPORT, opcrmCreateOpport);
    }

    public Boolean isSFBNoBudgetable() {
        return (Boolean) get(PROPERTY_SFBNOBUDGETABLE);
    }

    public void setSFBNoBudgetable(Boolean sFBNoBudgetable) {
        set(PROPERTY_SFBNOBUDGETABLE, sFBNoBudgetable);
    }

    public Boolean isOpcrmOppFromQuot() {
        return (Boolean) get(PROPERTY_OPCRMOPPFROMQUOT);
    }

    public void setOpcrmOppFromQuot(Boolean opcrmOppFromQuot) {
        set(PROPERTY_OPCRMOPPFROMQUOT, opcrmOppFromQuot);
    }

    public SFBBudgetArea getSfbBudgetArea() {
        return (SFBBudgetArea) get(PROPERTY_SFBBUDGETAREA);
    }

    public void setSfbBudgetArea(SFBBudgetArea sfbBudgetArea) {
        set(PROPERTY_SFBBUDGETAREA, sfbBudgetArea);
    }

    public User getOpcrmRelatedlead() {
        return (User) get(PROPERTY_OPCRMRELATEDLEAD);
    }

    public void setOpcrmRelatedlead(User opcrmRelatedlead) {
        set(PROPERTY_OPCRMRELATEDLEAD, opcrmRelatedlead);
    }

    public Boolean isSfbIsbudgeted() {
        return (Boolean) get(PROPERTY_SFBISBUDGETED);
    }

    public void setSfbIsbudgeted(Boolean sfbIsbudgeted) {
        set(PROPERTY_SFBISBUDGETED, sfbIsbudgeted);
    }

    public Date getSsflEnddate() {
        return (Date) get(PROPERTY_SSFLENDDATE);
    }

    public void setSsflEnddate(Date ssflEnddate) {
        set(PROPERTY_SSFLENDDATE, ssflEnddate);
    }

    public String getSsflOrderReference() {
        return (String) get(PROPERTY_SSFLORDERREFERENCE);
    }

    public void setSsflOrderReference(String ssflOrderReference) {
        set(PROPERTY_SSFLORDERREFERENCE, ssflOrderReference);
    }

    public Boolean isSsfwApproval() {
        return (Boolean) get(PROPERTY_SSFWAPPROVAL);
    }

    public void setSsfwApproval(Boolean ssfwApproval) {
        set(PROPERTY_SSFWAPPROVAL, ssfwApproval);
    }

    public Boolean isConfirmcancelandreplace() {
        return (Boolean) get(PROPERTY_CONFIRMCANCELANDREPLACE);
    }

    public void setConfirmcancelandreplace(Boolean confirmcancelandreplace) {
        set(PROPERTY_CONFIRMCANCELANDREPLACE, confirmcancelandreplace);
    }

    public String getSsfwReject() {
        return (String) get(PROPERTY_SSFWREJECT);
    }

    public void setSsfwReject(String ssfwReject) {
        set(PROPERTY_SSFWREJECT, ssfwReject);
    }

    public Order getCancelledorder() {
        return (Order) get(PROPERTY_CANCELLEDORDER);
    }

    public void setCancelledorder(Order cancelledorder) {
        set(PROPERTY_CANCELLEDORDER, cancelledorder);
    }

    public Order getReplacedorder() {
        return (Order) get(PROPERTY_REPLACEDORDER);
    }

    public void setReplacedorder(Order replacedorder) {
        set(PROPERTY_REPLACEDORDER, replacedorder);
    }

    public Boolean isEcsapSign() {
        return (Boolean) get(PROPERTY_ECSAPSIGN);
    }

    public void setEcsapSign(Boolean ecsapSign) {
        set(PROPERTY_ECSAPSIGN, ecsapSign);
    }

    public Boolean isCancelled() {
        return (Boolean) get(PROPERTY_ISCANCELLED);
    }

    public void setCancelled(Boolean iscancelled) {
        set(PROPERTY_ISCANCELLED, iscancelled);
    }

    public Boolean isEcsapAuthorization() {
        return (Boolean) get(PROPERTY_ECSAPAUTHORIZATION);
    }

    public void setEcsapAuthorization(Boolean ecsapAuthorization) {
        set(PROPERTY_ECSAPAUTHORIZATION, ecsapAuthorization);
    }

    public AuthorizationLevel getEcsapAuthLevel() {
        return (AuthorizationLevel) get(PROPERTY_ECSAPAUTHLEVEL);
    }

    public void setEcsapAuthLevel(AuthorizationLevel ecsapAuthLevel) {
        set(PROPERTY_ECSAPAUTHLEVEL, ecsapAuthLevel);
    }

    public Order getReplacementorder() {
        return (Order) get(PROPERTY_REPLACEMENTORDER);
    }

    public void setReplacementorder(Order replacementorder) {
        set(PROPERTY_REPLACEMENTORDER, replacementorder);
    }

    public Boolean isEcsapSigned() {
        return (Boolean) get(PROPERTY_ECSAPSIGNED);
    }

    public void setEcsapSigned(Boolean ecsapSigned) {
        set(PROPERTY_ECSAPSIGNED, ecsapSigned);
    }

    public Boolean isEcsapReject() {
        return (Boolean) get(PROPERTY_ECSAPREJECT);
    }

    public void setEcsapReject(Boolean ecsapReject) {
        set(PROPERTY_ECSAPREJECT, ecsapReject);
    }

    public Long getDeliveryStatus() {
        return (Long) get(COMPUTED_COLUMN_DELIVERYSTATUS);
    }

    public void setDeliveryStatus(Long deliveryStatus) {
        set(COMPUTED_COLUMN_DELIVERYSTATUS, deliveryStatus);
    }

    public Long getInvoiceStatus() {
        return (Long) get(COMPUTED_COLUMN_INVOICESTATUS);
    }

    public void setInvoiceStatus(Long invoiceStatus) {
        set(COMPUTED_COLUMN_INVOICESTATUS, invoiceStatus);
    }

    public Long getPaymentStatus() {
        return (Long) get(COMPUTED_COLUMN_PAYMENTSTATUS);
    }

    public void setPaymentStatus(Long paymentStatus) {
        set(COMPUTED_COLUMN_PAYMENTSTATUS, paymentStatus);
    }

    public Order_ComputedColumns get_computedColumns() {
        return (Order_ComputedColumns) get(PROPERTY__COMPUTEDCOLUMNS);
    }

    public void set_computedColumns(Order_ComputedColumns _computedColumns) {
        set(PROPERTY__COMPUTEDCOLUMNS, _computedColumns);
    }

    @SuppressWarnings("unchecked")
    public List<DebtPaymentV> getDebtPaymentVList() {
      return (List<DebtPaymentV>) get(PROPERTY_DEBTPAYMENTVLIST);
    }

    public void setDebtPaymentVList(List<DebtPaymentV> debtPaymentVList) {
        set(PROPERTY_DEBTPAYMENTVLIST, debtPaymentVList);
    }

    @SuppressWarnings("unchecked")
    public List<AuthorizationLLine> getECSAPAuthoLineList() {
      return (List<AuthorizationLLine>) get(PROPERTY_ECSAPAUTHOLINELIST);
    }

    public void setECSAPAuthoLineList(List<AuthorizationLLine> eCSAPAuthoLineList) {
        set(PROPERTY_ECSAPAUTHOLINELIST, eCSAPAuthoLineList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_PaymentSchedInvV> getFINPaymentSchedInvVList() {
      return (List<FIN_PaymentSchedInvV>) get(PROPERTY_FINPAYMENTSCHEDINVVLIST);
    }

    public void setFINPaymentSchedInvVList(List<FIN_PaymentSchedInvV> fINPaymentSchedInvVList) {
        set(PROPERTY_FINPAYMENTSCHEDINVVLIST, fINPaymentSchedInvVList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_PaymentSchedOrdV> getFINPaymentSchedOrdVList() {
      return (List<FIN_PaymentSchedOrdV>) get(PROPERTY_FINPAYMENTSCHEDORDVLIST);
    }

    public void setFINPaymentSchedOrdVList(List<FIN_PaymentSchedOrdV> fINPaymentSchedOrdVList) {
        set(PROPERTY_FINPAYMENTSCHEDORDVLIST, fINPaymentSchedOrdVList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_PaymentSchedule> getFINPaymentScheduleList() {
      return (List<FIN_PaymentSchedule>) get(PROPERTY_FINPAYMENTSCHEDULELIST);
    }

    public void setFINPaymentScheduleList(List<FIN_PaymentSchedule> fINPaymentScheduleList) {
        set(PROPERTY_FINPAYMENTSCHEDULELIST, fINPaymentScheduleList);
    }

    @SuppressWarnings("unchecked")
    public List<Fin_OrigPaymentSchedule> getFinOrigPaymentScheduleList() {
      return (List<Fin_OrigPaymentSchedule>) get(PROPERTY_FINORIGPAYMENTSCHEDULELIST);
    }

    public void setFinOrigPaymentScheduleList(List<Fin_OrigPaymentSchedule> finOrigPaymentScheduleList) {
        set(PROPERTY_FINORIGPAYMENTSCHEDULELIST, finOrigPaymentScheduleList);
    }

    @SuppressWarnings("unchecked")
    public List<DebtPayment> getFinancialMgmtDebtPaymentList() {
      return (List<DebtPayment>) get(PROPERTY_FINANCIALMGMTDEBTPAYMENTLIST);
    }

    public void setFinancialMgmtDebtPaymentList(List<DebtPayment> financialMgmtDebtPaymentList) {
        set(PROPERTY_FINANCIALMGMTDEBTPAYMENTLIST, financialMgmtDebtPaymentList);
    }

    @SuppressWarnings("unchecked")
    public List<CashJournalLine> getFinancialMgmtJournalLineList() {
      return (List<CashJournalLine>) get(PROPERTY_FINANCIALMGMTJOURNALLINELIST);
    }

    public void setFinancialMgmtJournalLineList(List<CashJournalLine> financialMgmtJournalLineList) {
        set(PROPERTY_FINANCIALMGMTJOURNALLINELIST, financialMgmtJournalLineList);
    }

    @SuppressWarnings("unchecked")
    public List<Invoice> getInvoiceList() {
      return (List<Invoice>) get(PROPERTY_INVOICELIST);
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        set(PROPERTY_INVOICELIST, invoiceList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceV2> getInvoiceV2List() {
      return (List<InvoiceV2>) get(PROPERTY_INVOICEV2LIST);
    }

    public void setInvoiceV2List(List<InvoiceV2> invoiceV2List) {
        set(PROPERTY_INVOICEV2LIST, invoiceV2List);
    }

    @SuppressWarnings("unchecked")
    public List<ShipmentInOut> getMaterialMgmtShipmentInOutList() {
      return (List<ShipmentInOut>) get(PROPERTY_MATERIALMGMTSHIPMENTINOUTLIST);
    }

    public void setMaterialMgmtShipmentInOutList(List<ShipmentInOut> materialMgmtShipmentInOutList) {
        set(PROPERTY_MATERIALMGMTSHIPMENTINOUTLIST, materialMgmtShipmentInOutList);
    }

    @SuppressWarnings("unchecked")
    public List<Order> getOrderQuotationList() {
      return (List<Order>) get(PROPERTY_ORDERQUOTATIONLIST);
    }

    public void setOrderQuotationList(List<Order> orderQuotationList) {
        set(PROPERTY_ORDERQUOTATIONLIST, orderQuotationList);
    }

    @SuppressWarnings("unchecked")
    public List<Order> getOrderCancelledorderList() {
      return (List<Order>) get(PROPERTY_ORDERCANCELLEDORDERLIST);
    }

    public void setOrderCancelledorderList(List<Order> orderCancelledorderList) {
        set(PROPERTY_ORDERCANCELLEDORDERLIST, orderCancelledorderList);
    }

    @SuppressWarnings("unchecked")
    public List<Order> getOrderReplacedorderList() {
      return (List<Order>) get(PROPERTY_ORDERREPLACEDORDERLIST);
    }

    public void setOrderReplacedorderList(List<Order> orderReplacedorderList) {
        set(PROPERTY_ORDERREPLACEDORDERLIST, orderReplacedorderList);
    }

    @SuppressWarnings("unchecked")
    public List<Order> getOrderReplacementorderIDList() {
      return (List<Order>) get(PROPERTY_ORDERREPLACEMENTORDERIDLIST);
    }

    public void setOrderReplacementorderIDList(List<Order> orderReplacementorderIDList) {
        set(PROPERTY_ORDERREPLACEMENTORDERIDLIST, orderReplacementorderIDList);
    }

    @SuppressWarnings("unchecked")
    public List<OrderDiscount> getOrderDiscountList() {
      return (List<OrderDiscount>) get(PROPERTY_ORDERDISCOUNTLIST);
    }

    public void setOrderDiscountList(List<OrderDiscount> orderDiscountList) {
        set(PROPERTY_ORDERDISCOUNTLIST, orderDiscountList);
    }

    @SuppressWarnings("unchecked")
    public List<OrderLine> getOrderLineList() {
      return (List<OrderLine>) get(PROPERTY_ORDERLINELIST);
    }

    public void setOrderLineList(List<OrderLine> orderLineList) {
        set(PROPERTY_ORDERLINELIST, orderLineList);
    }

    @SuppressWarnings("unchecked")
    public List<OrderLineTax> getOrderLineTaxList() {
      return (List<OrderLineTax>) get(PROPERTY_ORDERLINETAXLIST);
    }

    public void setOrderLineTaxList(List<OrderLineTax> orderLineTaxList) {
        set(PROPERTY_ORDERLINETAXLIST, orderLineTaxList);
    }

    @SuppressWarnings("unchecked")
    public List<OrderTax> getOrderTaxList() {
      return (List<OrderTax>) get(PROPERTY_ORDERTAXLIST);
    }

    public void setOrderTaxList(List<OrderTax> orderTaxList) {
        set(PROPERTY_ORDERTAXLIST, orderTaxList);
    }

    @SuppressWarnings("unchecked")
    public List<ProjectLine> getProjectLineList() {
      return (List<ProjectLine>) get(PROPERTY_PROJECTLINELIST);
    }

    public void setProjectLineList(List<ProjectLine> projectLineList) {
        set(PROPERTY_PROJECTLINELIST, projectLineList);
    }

    @SuppressWarnings("unchecked")
    public List<ProjectLine> getProjectLinePurchaseOrderList() {
      return (List<ProjectLine>) get(PROPERTY_PROJECTLINEPURCHASEORDERLIST);
    }

    public void setProjectLinePurchaseOrderList(List<ProjectLine> projectLinePurchaseOrderList) {
        set(PROPERTY_PROJECTLINEPURCHASEORDERLIST, projectLinePurchaseOrderList);
    }

    @SuppressWarnings("unchecked")
    public List<ProjectPhase> getProjectPhaseList() {
      return (List<ProjectPhase>) get(PROPERTY_PROJECTPHASELIST);
    }

    public void setProjectPhaseList(List<ProjectPhase> projectPhaseList) {
        set(PROPERTY_PROJECTPHASELIST, projectPhaseList);
    }

    @SuppressWarnings("unchecked")
    public List<SFBOrderCloseAttempt> getSFBOrderCloseAttemptList() {
      return (List<SFBOrderCloseAttempt>) get(PROPERTY_SFBORDERCLOSEATTEMPTLIST);
    }

    public void setSFBOrderCloseAttemptList(List<SFBOrderCloseAttempt> sFBOrderCloseAttemptList) {
        set(PROPERTY_SFBORDERCLOSEATTEMPTLIST, sFBOrderCloseAttemptList);
    }

    @SuppressWarnings("unchecked")
    public List<Opcrminvoice> getOpcrmInvoiceList() {
      return (List<Opcrminvoice>) get(PROPERTY_OPCRMINVOICELIST);
    }

    public void setOpcrmInvoiceList(List<Opcrminvoice> opcrmInvoiceList) {
        set(PROPERTY_OPCRMINVOICELIST, opcrmInvoiceList);
    }

    @SuppressWarnings("unchecked")
    public List<Opcrmopportunities> getOpcrmOpportunitiesList() {
      return (List<Opcrmopportunities>) get(PROPERTY_OPCRMOPPORTUNITIESLIST);
    }

    public void setOpcrmOpportunitiesList(List<Opcrmopportunities> opcrmOpportunitiesList) {
        set(PROPERTY_OPCRMOPPORTUNITIESLIST, opcrmOpportunitiesList);
    }

    @SuppressWarnings("unchecked")
    public List<Opcrmopportunities> getOpcrmOpportunitiesSalesquotationIDList() {
      return (List<Opcrmopportunities>) get(PROPERTY_OPCRMOPPORTUNITIESSALESQUOTATIONIDLIST);
    }

    public void setOpcrmOpportunitiesSalesquotationIDList(List<Opcrmopportunities> opcrmOpportunitiesSalesquotationIDList) {
        set(PROPERTY_OPCRMOPPORTUNITIESSALESQUOTATIONIDLIST, opcrmOpportunitiesSalesquotationIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SFBBudgetCertLineDet> getSfbBudgetCertLineDetVList() {
      return (List<SFBBudgetCertLineDet>) get(PROPERTY_SFBBUDGETCERTLINEDETVLIST);
    }

    public void setSfbBudgetCertLineDetVList(List<SFBBudgetCertLineDet> sfbBudgetCertLineDetVList) {
        set(PROPERTY_SFBBUDGETCERTLINEDETVLIST, sfbBudgetCertLineDetVList);
    }

    @SuppressWarnings("unchecked")
    public List<sfb_budget_details_v> getSfbBudgetDetailsVList() {
      return (List<sfb_budget_details_v>) get(PROPERTY_SFBBUDGETDETAILSVLIST);
    }

    public void setSfbBudgetDetailsVList(List<sfb_budget_details_v> sfbBudgetDetailsVList) {
        set(PROPERTY_SFBBUDGETDETAILSVLIST, sfbBudgetDetailsVList);
    }

    @SuppressWarnings("unchecked")
    public List<ssfworderapproval> getSsfwOrderApprovalList() {
      return (List<ssfworderapproval>) get(PROPERTY_SSFWORDERAPPROVALLIST);
    }

    public void setSsfwOrderApprovalList(List<ssfworderapproval> ssfwOrderApprovalList) {
        set(PROPERTY_SSFWORDERAPPROVALLIST, ssfwOrderApprovalList);
    }

    @SuppressWarnings("unchecked")
    public List<ssve_budget_details_v> getSsveBudgetDetailsVList() {
      return (List<ssve_budget_details_v>) get(PROPERTY_SSVEBUDGETDETAILSVLIST);
    }

    public void setSsveBudgetDetailsVList(List<ssve_budget_details_v> ssveBudgetDetailsVList) {
        set(PROPERTY_SSVEBUDGETDETAILSVLIST, ssveBudgetDetailsVList);
    }


    @Override
    public Object get(String propName) {
      if (COMPUTED_COLUMN_DELIVERYSTATUS.equals(propName)) {
        if (get_computedColumns() == null) {
          return null;
        }
        return get_computedColumns().getDeliveryStatus();
      }
      if (COMPUTED_COLUMN_INVOICESTATUS.equals(propName)) {
        if (get_computedColumns() == null) {
          return null;
        }
        return get_computedColumns().getInvoiceStatus();
      }
      if (COMPUTED_COLUMN_PAYMENTSTATUS.equals(propName)) {
        if (get_computedColumns() == null) {
          return null;
        }
        return get_computedColumns().getPaymentStatus();
      }
    
      return super.get(propName);
    }
}
