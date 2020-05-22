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
package org.openbravo.model.common.businesspartner;

import com.sidesoft.ecuador.asset.allocation.SsalApplActive;
import com.sidesoft.ecuador.asset.allocation.SsalAssetReturn;
import com.sidesoft.ecuador.asset.move.ssamalienate;
import com.sidesoft.ecuador.humanResources.SshrEmployeeLanguage;
import com.sidesoft.ecuador.humanResources.SshrEmployeeProject;
import com.sidesoft.ecuador.humanResources.SshrEmployeePromotion;
import com.sidesoft.ecuador.humanResources.SshrExaminationTest;
import com.sidesoft.ecuador.humanResources.SshrTrainingCalendar;
import com.sidesoft.ecuador.humanResources.sshrDepartment;
import com.sidesoft.ecuador.humanResources.sshrEducation;
import com.sidesoft.ecuador.humanResources.sshrJob;
import com.sidesoft.ecuador.humanResources.sshrPositionTitle;
import com.sidesoft.ecuador.humanResources.sshrRace;
import com.sidesoft.ecuador.humanResources.sshrReportTo;
import com.sidesoft.ecuador.humanResources.sshrSalaryComponent;
import com.sidesoft.ecuador.humanResources.sshrSkills;
import com.sidesoft.ecuador.humanResources.sshrWorkExpirence;
import com.sidesoft.ecuador.humanResources.sshrchintext;
import com.sidesoft.ecuador.humanResources.sshrdisability;
import com.sidesoft.ecuador.humanResources.sshrpositsubtitle;
import com.sidesoft.ecuador.humanResources.sshrtcourses;
import com.sidesoft.ecuador.humanResources.sshrtrainingline;
import com.sidesoft.flopec.InvoiceVoyage;
import com.sidesoft.flopec.budget.data.SFBBudgetArea;
import com.sidesoft.flopec.budget.data.SFBBudgetCertLineDet;
import com.sidesoft.flopec.budget.data.sfb_budget_details_v;
import com.sidesoft.flopec.budget.data.sfbbudgetpaymentdetv;
import com.sidesoft.flopec.ssflRecap;
import com.sidesoft.hrm.payroll.Concept;
import com.sidesoft.hrm.payroll.ConceptAmount;
import com.sidesoft.hrm.payroll.Contract;
import com.sidesoft.hrm.payroll.Costemployee;
import com.sidesoft.hrm.payroll.CumulativeConcept;
import com.sidesoft.hrm.payroll.Family;
import com.sidesoft.hrm.payroll.Incometotal;
import com.sidesoft.hrm.payroll.PAYROLLTEMPLATE;
import com.sidesoft.hrm.payroll.Payroll;
import com.sidesoft.hrm.payroll.PayrollTicket;
import com.sidesoft.hrm.payroll.Period;
import com.sidesoft.hrm.payroll.SsprUtilityDetail;
import com.sidesoft.hrm.payroll.advanced.SfprEmployeeOther;
import com.sidesoft.hrm.payroll.advanced.SfprEmployeePermit;
import com.sidesoft.hrm.payroll.advanced.SfprEmployeeRve;
import com.sidesoft.hrm.payroll.advanced.SfprEmployeeSurrogate;
import com.sidesoft.hrm.payroll.advanced.SfprEmployeeVacation;
import com.sidesoft.hrm.payroll.advanced.SfprJobAction;
import com.sidesoft.hrm.payroll.advanced.SfprProvisionProperty;
import com.sidesoft.hrm.payroll.advanced.SfprRveDetail;
import com.sidesoft.hrm.payroll.advanced.SfprSurrogateDetail;
import com.sidesoft.hrm.payroll.disaccounting.sspdpctdistemp;
import com.sidesoft.hrm.payroll.sspr_iessrate;
import com.sidesoft.hrm.payroll.sspr_leave_group;
import com.sidesoft.hrm.payroll.sspr_level_ed;
import com.sidesoft.hrm.payroll.sspr_payrollemp;
import com.sidesoft.hrm.payroll.sspr_settlement;
import com.sidesoft.hrm.payroll.ssprattendance;
import com.sidesoft.hrm.payroll.ssprbank;
import com.sidesoft.hrm.payroll.ssprcategoryacct;
import com.sidesoft.hrm.payroll.sspremployeesettlement;
import com.sidesoft.hrm.payroll.ssprestablishmentcode;
import com.sidesoft.hrm.payroll.ssprformulary107detailv;
import com.sidesoft.hrm.payroll.ssprformularyline107;
import com.sidesoft.hrm.payroll.ssprleaveconfdefault;
import com.sidesoft.hrm.payroll.ssprleaveemp;
import com.sidesoft.hrm.payroll.ssprleavehrmanagement;
import com.sidesoft.hrm.payroll.ssprloans;
import com.sidesoft.hrm.payroll.ssprprofits;
import com.sidesoft.hrm.payroll.ssprreadmissions;
import com.sidesoft.hrm.payroll.ssprutilities;
import com.sidesoft.hrm.payroll.ssprvacations;
import com.sidesoft.hrm.payroll.tenth.SSPHTenthSettlementLine;
import com.sidesoft.localization.ecuador.finances.ssfiFin_payment_detail_v;
import com.sidesoft.localization.ecuador.refunds.ssrerefundinvoice;
import com.sidesoft.localization.ecuador.withholdings.Receipt;
import com.sidesoft.localization.ecuador.withholdings.SSWHCheckbookpos;
import com.sidesoft.localization.ecuador.withholdings.SSWHCheckbookposLine;
import com.sidesoft.localization.ecuador.withholdings.SSWHTermpayment;
import com.sidesoft.localization.ecuador.withholdings.SSWHWithholdingvendor;
import com.sidesoft.localization.ecuador.withholdings.SswhRptcPurchaseWith;
import com.sidesoft.localization.ecuador.withholdings.SswhWithhCardCredit;
import com.sidesoft.localization.ecuador.withholdings.Taxpayer;

import ec.com.sidesoft.budget.transfers.SfbtrBudgetaryReforms;
import ec.com.sidesoft.contract.ssctcontract;
import ec.com.sidesoft.custom.payments.partialpayment.SSPPPAYMENTS;
import ec.com.sidesoft.custom.payments.partialpayment.SSPPPAYMENTSLINE;
import ec.com.sidesoft.custom.payroll.partialpayment.scppapprovalpaymentline;
import ec.com.sidesoft.localization.ecuador.bpartner.complement.SBPCInfoPartnersV;
import ec.com.sidesoft.localization.ecuador.bpartner.complement.sbpceducation;
import ec.com.sidesoft.localization.ecuador.viatical.SSVEViatical;
import ec.com.sidesoft.localization.ecuador.viatical.SSVEViaticalSettlement;
import ec.com.sidesoft.localization.ecuador.viatical.ssve_budget_details_v;
import ec.com.sidesoft.localization.ecuador.viatical.ssve_viatical_details_v;
import ec.com.sidesoft.localization.ecuador.withholdingssales.SSWSWithholdingSale;
import ec.com.sidesoft.localization.flow.ssfwapprovalrange;
import ec.com.sidesoft.localization.flow.ssfworderapproval;
import ec.com.sidesoft.quick.billing.SqbConfigQuickBilling;
import ec.com.sidesoft.quick.billing.SqbQuickBilling;
import ec.com.sidesoft.report.salesinvoice.SRSISalesInvoiceV;
import ec.com.sidesoft.secondary.accounting.AccountingFactSecondary;
import ec.com.sidesoft.secondary.accounting.SSACCTJOURNAL;
import ec.com.sidesoft.secondary.accounting.SSACCTJournalLine;
import ec.com.sidesoft.ws.invoicecreate.data.SWSICConfig;
import ec.cusoft.facturaec.EEIFormat;
import ec.cusoft.facturaec.EEI_Platform;
import ec.cusoft.facturaec.EeiPaymentDetailV;

import it.openia.crm.Opcrmactivity;
import it.openia.crm.Opcrmcase;
import it.openia.crm.Opcrmdocuments;
import it.openia.crm.Opcrmopportunities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openbravo.advpaymentmngt.APRM_FinaccTransactionV;
import org.openbravo.advpaymentmngt.APRM_Finacc_Trx_Full_Acct_V;
import org.openbravo.advpaymentmngt.APRM_PaymentProposalPickEdit;
import org.openbravo.advpaymentmngt.FinAccTransactionAccounting;
import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.ad.system.ClientInformation;
import org.openbravo.model.ad.system.Language;
import org.openbravo.model.common.bank.Bank;
import org.openbravo.model.common.bank.BankAccount;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.enterprise.OrganizationInformation;
import org.openbravo.model.common.enterprise.WarehouseShipper;
import org.openbravo.model.common.geography.City;
import org.openbravo.model.common.geography.Country;
import org.openbravo.model.common.hcm.SalaryCategory;
import org.openbravo.model.common.interaction.EmailInteraction;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.common.invoice.InvoiceLine;
import org.openbravo.model.common.invoice.InvoiceLineAccountingDimension;
import org.openbravo.model.common.invoice.InvoiceLineV2;
import org.openbravo.model.common.invoice.InvoiceSchedule;
import org.openbravo.model.common.invoice.InvoiceTaxCashVAT_V;
import org.openbravo.model.common.invoice.InvoiceV2;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.common.order.OrderLine;
import org.openbravo.model.common.order.OrderLineAccountingDimension;
import org.openbravo.model.common.plm.ApprovedVendor;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.plm.ProductCustomer;
import org.openbravo.model.financialmgmt.accounting.AccountingFact;
import org.openbravo.model.financialmgmt.accounting.BudgetLine;
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.accounting.UserDimension1;
import org.openbravo.model.financialmgmt.accounting.UserDimension2;
import org.openbravo.model.financialmgmt.accounting.coa.AccountingCombination;
import org.openbravo.model.financialmgmt.accounting.coa.AcctSchemaElement;
import org.openbravo.model.financialmgmt.assetmgmt.AmortizationLineAccountingDimension;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
import org.openbravo.model.financialmgmt.cashmgmt.BankStatement;
import org.openbravo.model.financialmgmt.cashmgmt.BankStatementLine;
import org.openbravo.model.financialmgmt.gl.GLJournal;
import org.openbravo.model.financialmgmt.gl.GLJournalLine;
import org.openbravo.model.financialmgmt.payment.DebtPayment;
import org.openbravo.model.financialmgmt.payment.DebtPaymentCancelV;
import org.openbravo.model.financialmgmt.payment.DebtPaymentGenerateV;
import org.openbravo.model.financialmgmt.payment.DoubtfulDebt;
import org.openbravo.model.financialmgmt.payment.DoubtfulDebtRun;
import org.openbravo.model.financialmgmt.payment.DoubtfulDebtV;
import org.openbravo.model.financialmgmt.payment.FIN_BankStatementLine;
import org.openbravo.model.financialmgmt.payment.FIN_FinaccTransaction;
import org.openbravo.model.financialmgmt.payment.FIN_FinancialAccount;
import org.openbravo.model.financialmgmt.payment.FIN_Payment;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentDetailV;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentMethod;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentPropDetailV;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentProposal;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentScheduleDetail;
import org.openbravo.model.financialmgmt.payment.Incoterms;
import org.openbravo.model.financialmgmt.payment.PaymentTerm;
import org.openbravo.model.financialmgmt.tax.TaxPayment;
import org.openbravo.model.manufacturing.maintenance.Worker;
import org.openbravo.model.manufacturing.transaction.ProductionRunEmployee;
import org.openbravo.model.manufacturing.transaction.WorkEffortEmployee;
import org.openbravo.model.marketing.Campaign;
import org.openbravo.model.materialmgmt.onhandquantity.PrereservationManualPickEdit;
import org.openbravo.model.materialmgmt.onhandquantity.Reservation;
import org.openbravo.model.materialmgmt.transaction.InOutLineAccountingDimension;
import org.openbravo.model.materialmgmt.transaction.MaterialTransactionV;
import org.openbravo.model.materialmgmt.transaction.ReturnMaterialReceiptPickEdit;
import org.openbravo.model.materialmgmt.transaction.ReturnMaterialShipmentPickEdit;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOut;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOutLine;
import org.openbravo.model.mrp.ProductionRun;
import org.openbravo.model.mrp.PurchasingRun;
import org.openbravo.model.mrp.PurchasingRunLine;
import org.openbravo.model.mrp.SalesForecast;
import org.openbravo.model.pos.ExternalPOS;
import org.openbravo.model.pricing.pricelist.PriceList;
import org.openbravo.model.pricing.pricelist.PriceListSchemeLine;
import org.openbravo.model.procurement.Requisition;
import org.openbravo.model.procurement.RequisitionLine;
import org.openbravo.model.project.ActiveProposal;
import org.openbravo.model.project.Project;
import org.openbravo.model.project.ProjectProposal;
import org.openbravo.model.project.ProjectVendor;
import org.openbravo.model.sales.Commission;
import org.openbravo.model.sales.CommissionLine;
import org.openbravo.model.shipping.ShippingCompany;
import org.openbravo.model.timeandexpense.Sheet;
import org.openbravo.model.timeandexpense.SheetLine;
import org.openbravo.model.timeandexpense.SheetLineV;
/**
 * Entity class for entity BusinessPartner (stored in table C_BPartner).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class BusinessPartner extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_BPartner";
    public static final String ENTITY_NAME = "BusinessPartner";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_SEARCHKEY = "searchKey";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_NAME2 = "name2";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_SUMMARYLEVEL = "summaryLevel";
    public static final String PROPERTY_BUSINESSPARTNERCATEGORY = "businessPartnerCategory";
    public static final String PROPERTY_ONETIMETRANSACTION = "oneTimeTransaction";
    public static final String PROPERTY_POTENTIALCUSTOMER = "potentialCustomer";
    public static final String PROPERTY_VENDOR = "vendor";
    public static final String PROPERTY_CUSTOMER = "customer";
    public static final String PROPERTY_EMPLOYEE = "employee";
    public static final String PROPERTY_ISSALESREPRESENTATIVE = "isSalesRepresentative";
    public static final String PROPERTY_REFERENCENO = "referenceNo";
    public static final String PROPERTY_DUNS = "dUNS";
    public static final String PROPERTY_URL = "uRL";
    public static final String PROPERTY_LANGUAGE = "language";
    public static final String PROPERTY_TAXID = "taxID";
    public static final String PROPERTY_TAXEXEMPT = "taxExempt";
    public static final String PROPERTY_INVOICESCHEDULE = "invoiceSchedule";
    public static final String PROPERTY_VALUATION = "valuation";
    public static final String PROPERTY_VOLUMEOFSALES = "volumeOfSales";
    public static final String PROPERTY_NOOFEMPLOYEES = "noOfEmployees";
    public static final String PROPERTY_NAICSSIC = "nAICSSIC";
    public static final String PROPERTY_DATEOFFIRSTSALE = "dateOfFirstSale";
    public static final String PROPERTY_ACQUISITIONCOST = "acquisitionCost";
    public static final String PROPERTY_EXPECTEDLIFETIMEREVENUE = "expectedLifetimeRevenue";
    public static final String PROPERTY_LIFETIMEREVENUETODATE = "lifetimeRevenueToDate";
    public static final String PROPERTY_SHARE = "share";
    public static final String PROPERTY_FORMOFPAYMENT = "formOfPayment";
    public static final String PROPERTY_CREDITLIMIT = "creditLimit";
    public static final String PROPERTY_CREDITUSED = "creditUsed";
    public static final String PROPERTY_PAYMENTTERMS = "paymentTerms";
    public static final String PROPERTY_PRICELIST = "priceList";
    public static final String PROPERTY_PRINTDISCOUNT = "printDiscount";
    public static final String PROPERTY_ORDERDESCRIPTION = "orderDescription";
    public static final String PROPERTY_ORDERREFERENCE = "orderReference";
    public static final String PROPERTY_POFORMOFPAYMENT = "pOFormOfPayment";
    public static final String PROPERTY_PURCHASEPRICELIST = "purchasePricelist";
    public static final String PROPERTY_POPAYMENTTERMS = "pOPaymentTerms";
    public static final String PROPERTY_NUMBEROFCOPIES = "numberOfCopies";
    public static final String PROPERTY_GREETING = "greeting";
    public static final String PROPERTY_INVOICETERMS = "invoiceTerms";
    public static final String PROPERTY_DELIVERYTERMS = "deliveryTerms";
    public static final String PROPERTY_DELIVERYMETHOD = "deliveryMethod";
    public static final String PROPERTY_SALESREPRESENTATIVE = "salesRepresentative";
    public static final String PROPERTY_PARTNERPARENT = "partnerParent";
    public static final String PROPERTY_CREDITSTATUS = "creditStatus";
    public static final String PROPERTY_FORCEDORG = "forcedOrg";
    public static final String PROPERTY_PRICESSHOWNINORDER = "pricesShownInOrder";
    public static final String PROPERTY_INVOICEGROUPING = "invoiceGrouping";
    public static final String PROPERTY_MATURITYDATE1 = "maturityDate1";
    public static final String PROPERTY_MATURITYDATE2 = "maturityDate2";
    public static final String PROPERTY_MATURITYDATE3 = "maturityDate3";
    public static final String PROPERTY_OPERATOR = "operator";
    public static final String PROPERTY_UPCEAN = "uPCEAN";
    public static final String PROPERTY_SALARYCATEGORY = "salaryCategory";
    public static final String PROPERTY_INVOICEPRINTFORMAT = "invoicePrintformat";
    public static final String PROPERTY_CONSUMPTIONDAYS = "consumptionDays";
    public static final String PROPERTY_BANKACCOUNT = "bankAccount";
    public static final String PROPERTY_TAXCATEGORY = "taxCategory";
    public static final String PROPERTY_POMATURITYDATE1 = "pOMaturityDate1";
    public static final String PROPERTY_POMATURITYDATE2 = "pOMaturityDate2";
    public static final String PROPERTY_POMATURITYDATE3 = "pOMaturityDate3";
    public static final String PROPERTY_TRANSACTIONALBANKACCOUNT = "transactionalBankAccount";
    public static final String PROPERTY_SOBPTAXCATEGORY = "sOBPTaxCategory";
    public static final String PROPERTY_FISCALCODE = "fiscalcode";
    public static final String PROPERTY_ISOFISCALCODE = "isofiscalcode";
    public static final String PROPERTY_INCOTERMSPO = "incotermsPO";
    public static final String PROPERTY_INCOTERMSSO = "incotermsSO";
    public static final String PROPERTY_PAYMENTMETHOD = "paymentMethod";
    public static final String PROPERTY_POPAYMENTMETHOD = "pOPaymentMethod";
    public static final String PROPERTY_ACCOUNT = "account";
    public static final String PROPERTY_POFINANCIALACCOUNT = "pOFinancialAccount";
    public static final String PROPERTY_CUSTOMERBLOCKING = "customerBlocking";
    public static final String PROPERTY_SSWHTAXIDTYPE = "sswhTaxidtype";
    public static final String PROPERTY_VENDORBLOCKING = "vendorBlocking";
    public static final String PROPERTY_SSWHSALEADVISOR = "sswhSaleadvisor";
    public static final String PROPERTY_PAYMENTIN = "paymentIn";
    public static final String PROPERTY_SSWHCOLLECTINGAGENT = "sswhCollectingagent";
    public static final String PROPERTY_PAYMENTOUT = "paymentOut";
    public static final String PROPERTY_SALESINVOICE = "salesInvoice";
    public static final String PROPERTY_PURCHASEINVOICE = "purchaseInvoice";
    public static final String PROPERTY_SALESORDER = "salesOrder";
    public static final String PROPERTY_PURCHASEORDER = "purchaseOrder";
    public static final String PROPERTY_GOODSSHIPMENT = "goodsShipment";
    public static final String PROPERTY_GOODSRECEIPT = "goodsReceipt";
    public static final String PROPERTY_CASHVAT = "cashVAT";
    public static final String PROPERTY_OPCRMBPEMAIL = "opcrmBpEmail";
    public static final String PROPERTY_EEIEEIOICE = "eEIEeioice";
    public static final String PROPERTY_OPCRMBPTYPE = "opcrmBpType";
    public static final String PROPERTY_SSWHTAXPAYER = "sSWHTaxpayer";
    public static final String PROPERTY_SETNEWCURRENCY = "setNewCurrency";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_EEIFORMAT = "eEIFormat";
    public static final String PROPERTY_OPCRMBPINDUSTRY = "opcrmBpIndustry";
    public static final String PROPERTY_SSHRRACE = "sshrRace";
    public static final String PROPERTY_BIRTHPLACE = "birthPlace";
    public static final String PROPERTY_EEIPLATFORM = "eEIPlatform";
    public static final String PROPERTY_OPCRMBPANNUALREVENUE = "opcrmBpAnnualRevenue";
    public static final String PROPERTY_SSHRCOUNTRY = "sshrCountry";
    public static final String PROPERTY_BIRTHDAY = "birthDay";
    public static final String PROPERTY_EEIEMAIL = "eEIEmail";
    public static final String PROPERTY_OPCRMBPEMPLOYEES = "opcrmBpEmployees";
    public static final String PROPERTY_SSHRGENDER = "sshrGender";
    public static final String PROPERTY_EEIDELIVERYMODE = "eEIDeliverymode";
    public static final String PROPERTY_OPCRMBPSICCODE = "opcrmBpSicCode";
    public static final String PROPERTY_SSHRDISABILITY = "sshrDisability";
    public static final String PROPERTY_OPCRMBPTICKERSYMBOL = "opcrmBpTickerSymbol";
    public static final String PROPERTY_SSHRLEVEL = "sshrLevel";
    public static final String PROPERTY_OPCRMBPOWNERSHIP = "opcrmBpOwnership";
    public static final String PROPERTY_SSHRNOCARD = "sshrNocard";
    public static final String PROPERTY_SSWHNAME3 = "sswhName3";
    public static final String PROPERTY_OPCRMBPRATING = "opcrmBpRating";
    public static final String PROPERTY_SSHRAGE = "sshrAge";
    public static final String PROPERTY_OPCRMBPCCAMPAIGN = "opcrmBpCCampaign";
    public static final String PROPERTY_SSHRMILITARYNO = "sshrMilitaryno";
    public static final String PROPERTY_OPCRMBPASSIGNEDTO = "opcrmBpAssignedTo";
    public static final String PROPERTY_SSHREMAIL = "sshrEmail";
    public static final String PROPERTY_SSWHRESOLUTIONNO = "sswhResolutionno";
    public static final String PROPERTY_OPCRMBTNCREATEOPP = "opcrmBtnCreateopp";
    public static final String PROPERTY_SSHRTYPEBLOOD = "sshrTypeblood";
    public static final String PROPERTY_OPCRMBTNCREATEACT = "opcrmBtnCreateact";
    public static final String PROPERTY_SSHRDISABILITYCHK = "sshrDisabilityChk";
    public static final String PROPERTY_OPCRMDOCTYPE = "opcrmDoctype";
    public static final String PROPERTY_EEIEEIOICEV = "eeiEeioicev";
    public static final String PROPERTY_OPCRMISPOSDEFAULT = "opcrmIsposdefault";
    public static final String PROPERTY_SSPRSTATUS = "sSPRStatus";
    public static final String PROPERTY_SSPRBIRTHDAY = "sSPRBirthday";
    public static final String PROPERTY_EEIDELIVERYMODEV = "eeiDeliverymodev";
    public static final String PROPERTY_SSPRENTRYDATE = "sSPREntrydate";
    public static final String PROPERTY_SSPRDOCUMENTTYPE = "sSPRDocumenttype";
    public static final String PROPERTY_SSPRDOCUMENTNO = "sSPRDocumentNo";
    public static final String PROPERTY_SSPRSPECIALSITUATION = "sSPRSpecialsituation";
    public static final String PROPERTY_SSWHTERMPAY = "sswhTermpay";
    public static final String PROPERTY_SSPRLABORREGIME = "sSPRLaborregime";
    public static final String PROPERTY_SSPRINCOMEFREQUENCY = "sSPRIncomefrequency";
    public static final String PROPERTY_SSPRTYPEOFINCOME = "sSPRTypeofincome";
    public static final String PROPERTY_SSPRPROLLTEMPLATE = "sSPRProlltemplate";
    public static final String PROPERTY_SSPRPROLLTEMPLATE2 = "sSPRProlltemplate2";
    public static final String PROPERTY_SSPRPROJECT = "ssprProject";
    public static final String PROPERTY_SSPRCITY = "ssprCity";
    public static final String PROPERTY_SSPRRESERVEFUNDSIESS = "ssprReservefundsiess";
    public static final String PROPERTY_SSPRRESERVEFUNDSCOMPANY = "ssprReservefundscompany";
    public static final String PROPERTY_SSPRCONCEPT = "ssprConcept";
    public static final String PROPERTY_SSPRCOSTCENTER = "ssprCostcenter";
    public static final String PROPERTY_SSPRUSER1 = "ssprUser1";
    public static final String PROPERTY_SSPRUSER2 = "ssprUser2";
    public static final String PROPERTY_SSPRSEVERANCEFOUNDS = "ssprSeverancefounds";
    public static final String PROPERTY_SSPRCREATEPAYROLL = "ssprCreatePayroll";
    public static final String PROPERTY_SSPRLEVELED = "ssprLevelEd";
    public static final String PROPERTY_SSFLRELACIONADO = "sSFLRelacionado";
    public static final String PROPERTY_SFPRISFPR = "sfprIsfpr";
    public static final String PROPERTY_SFPRNODAYS = "sfprNodays";
    public static final String PROPERTY_SSFLADDITIONAL = "ssflAdditional";
    public static final String PROPERTY_SSHRDEPARTMENT = "sshrDepartment";
    public static final String PROPERTY_SSHRPOSITIONTITLE = "sshrPositionTitle";
    public static final String PROPERTY_SSHRPOSITSUBTITLE = "sshrPositSubTitle";
    public static final String PROPERTY_SSPRISDISABLED = "ssprIsdisabled";
    public static final String PROPERTY_SSPRDISABILITY = "ssprDisability";
    public static final String PROPERTY_SSPRBANK = "ssprBank";
    public static final String PROPERTY_SSPRCOMPERS = "ssprCompers";
    public static final String PROPERTY_SSPRCURRENTSALARY = "ssprCurrentsalary";
    public static final String PROPERTY_SSPRIESSRATE = "ssprIessrate";
    public static final String PROPERTY_SSPRISEXECUTIVE = "ssprIsexecutive";
    public static final String PROPERTY_SSPRTHIRTEENTH = "ssprThirteenth";
    public static final String PROPERTY_SSPRFOURTEENTH = "ssprFourteenth";
    public static final String PROPERTY_SSPRCONCEPTTHIRTEENTH = "ssprConceptThirteenth";
    public static final String PROPERTY_SSPRCODOCUPACIESS = "ssprCodOcupacIess";
    public static final String PROPERTY_SSPRCONCEPTFOURTEENTH = "ssprConceptFourteenth";
    public static final String PROPERTY_SSPRDESCRIPDISAB = "ssprDescripDisab";
    public static final String PROPERTY_SSPRDATEDISAB = "ssprDateDisab";
    public static final String PROPERTY_SSPRCONCEPTVAC = "ssprConceptVac";
    public static final String PROPERTY_SSPRCATEGORYACCT = "ssprCategoryAcct";
    public static final String PROPERTY_EEIDETAILEI = "eeiDetailEi";
    public static final String PROPERTY_SBPCBLOODTYPE = "sbpcBloodtype";
    public static final String PROPERTY_SQBNAMETAXID = "sqbNameTaxid";
    public static final String PROPERTY_SSPRISPASSANT = "ssprIspassant";
    public static final String PROPERTY_SSPRFORTNIGHT = "ssprFortnight";
    public static final String PROPERTY_SBPCLICENSETYPE = "sbpcLicenseType";
    public static final String PROPERTY_SSPRCOMPLYBONOS = "ssprComplyBonos";
    public static final String PROPERTY_EEIPORTALPASS = "eeiPortalPass";
    public static final String PROPERTY_SSPRMOBILIZATION = "ssprMobilization";
    public static final String PROPERTY_SSPREXTRAHOURS = "ssprExtraHours";
    public static final String PROPERTY_SBPCCIVILSTATUS = "sbpcCivilStatus";
    public static final String PROPERTY_SSPRBONUSPUNCTUAL = "ssprBonusPunctual";
    public static final String PROPERTY_SSPREMAIL = "ssprEmail";
    public static final String PROPERTY_SSPRLASTNAME = "ssprLastname";
    public static final String PROPERTY_SSPRFIRSTNAME = "ssprFirstname";
    public static final String PROPERTY_SSPRREPRESENTSDISABLED = "ssprRepresentsdisabled";
    public static final String PROPERTY_SSPRBPARTNERDISABLED = "ssprBpartnerDisabled";
    public static final String PROPERTY_SSPRESTABLISHMENTCODE = "ssprEstablishmentcode";
    public static final String PROPERTY_SSBPSFBBUDGETAREA = "ssbpSfbBudgetArea";
    public static final String PROPERTY_SBPCCLIENTTYPE = "sbpcClientType";
    public static final String PROPERTY_SSFLISCHARTERER = "sSFLIsCharterer";
    public static final String PROPERTY_SSWHCODETAXPAYER = "sswhCodetaxpayer";
    public static final String PROPERTY_SBPCAGE = "sbpcAge";
    public static final String PROPERTY_SBPCDATEBIRTH = "sbpcDatebirth";
    public static final String PROPERTY_SBPCDATEENTRY = "sbpcDateentry";
    public static final String PROPERTY_SBPCDATEEXIT = "sbpcDateexit";
    public static final String PROPERTY_SBPCEDUCATION = "sbpcEducation";
    public static final String PROPERTY_SBPCGENDER = "sbpcGender";
    public static final String PROPERTY_SSFIFOREIGN = "ssfiForeign";
    public static final String PROPERTY_SSFLISOWNER = "ssflIsowner";
    public static final String PROPERTY_ADUSERLIST = "aDUserList";
    public static final String PROPERTY_ADUSEREMOPCRMREPORTSTOLIST = "aDUserEMOPCRMReportsToList";
    public static final String PROPERTY_APRMFINACCTRANSACTIONACCTVLIST = "aPRMFinAccTransactionAcctVList";
    public static final String PROPERTY_APRMFINACCTRANSACTIONVLIST = "aPRMFinaccTransactionVList";
    public static final String PROPERTY_APRMFINACCTRXFULLACCTVLIST = "aPRMFinaccTrxFullAcctVList";
    public static final String PROPERTY_APRMPAYMENTPROPOSALPICKEDITLIST = "aPRMPaymentProposalPickEditList";
    public static final String PROPERTY_ACTIVEPROPOSALVLIST = "activeProposalVList";
    public static final String PROPERTY_AMORTIZATIONLINEACCOUNTINGDIMENSIONLIST = "amortizationLineAccountingDimensionList";
    public static final String PROPERTY_APPROVEDVENDORLIST = "approvedVendorList";
    public static final String PROPERTY_BANKLIST = "bankList";
    public static final String PROPERTY_BUSINESSPARTNERSALESREPRESENTATIVELIST = "businessPartnerSalesRepresentativeList";
    public static final String PROPERTY_BUSINESSPARTNEREMSSWHSALEADVISORLIST = "businessPartnerEMSswhSaleadvisorList";
    public static final String PROPERTY_BUSINESSPARTNEREMSSWHCOLLECTINGAGENTLIST = "businessPartnerEMSswhCollectingagentList";
    public static final String PROPERTY_BUSINESSPARTNEREMSSPRBPARTNERDISABLEDIDLIST = "businessPartnerEMSsprBpartnerDisabledIDList";
    public static final String PROPERTY_BUSINESSPARTNERBANKACCOUNTLIST = "businessPartnerBankAccountList";
    public static final String PROPERTY_BUSINESSPARTNERDISCOUNTLIST = "businessPartnerDiscountList";
    public static final String PROPERTY_BUSINESSPARTNERLOCATIONLIST = "businessPartnerLocationList";
    public static final String PROPERTY_BUSINESSPARTNERPRODUCTTEMPLATELIST = "businessPartnerProductTemplateList";
    public static final String PROPERTY_BUSINESSPARTNERWITHHOLDINGLIST = "businessPartnerWithholdingList";
    public static final String PROPERTY_INVOICETAXCASHVATVLIST = "invoiceTaxCashVATVList";
    public static final String PROPERTY_CLIENTINFORMATIONTEMPLATEBPARTNERLIST = "clientInformationTemplateBPartnerList";
    public static final String PROPERTY_CLIENTINFORMATIONEMSSPRCBPARTNERIDLIST = "clientInformationEMSsprCBpartnerIDList";
    public static final String PROPERTY_CUSTOMERACCOUNTSLIST = "customerAccountsList";
    public static final String PROPERTY_EMAILINTERACTIONLIST = "emailInteractionList";
    public static final String PROPERTY_EMPLOYEEACCOUNTSLIST = "employeeAccountsList";
    public static final String PROPERTY_EMPLOYEESALARYCATEGORYLIST = "employeeSalaryCategoryList";
    public static final String PROPERTY_EXTERNALPOSLIST = "externalPOSList";
    public static final String PROPERTY_FINBANKSTATEMENTLINELIST = "fINBankStatementLineList";
    public static final String PROPERTY_FINDOUBTFULDEBTLIST = "fINDoubtfulDebtList";
    public static final String PROPERTY_FINDOUBTFULDEBTRUNLIST = "fINDoubtfulDebtRunList";
    public static final String PROPERTY_FINDOUBTFULDEBTVLIST = "fINDoubtfulDebtVList";
    public static final String PROPERTY_FINFINACCTRANSACTIONLIST = "fINFinaccTransactionList";
    public static final String PROPERTY_FINFINANCIALACCOUNTLIST = "fINFinancialAccountList";
    public static final String PROPERTY_FINPAYMENTLIST = "fINPaymentList";
    public static final String PROPERTY_FINPAYMENTEMSSPACCBPARTNERIDLIST = "fINPaymentEMSspacCBpartnerIDList";
    public static final String PROPERTY_FINPAYMENTDETAILVLIST = "fINPaymentDetailVList";
    public static final String PROPERTY_FINPAYMENTDETAILVBUSINESSPARTNERDIMLIST = "fINPaymentDetailVBusinessPartnerdimList";
    public static final String PROPERTY_FINPAYMENTPROPDETAILVLIST = "fINPaymentPropDetailVList";
    public static final String PROPERTY_FINPAYMENTPROPOSALLIST = "fINPaymentProposalList";
    public static final String PROPERTY_FINPAYMENTSCHEDULEDETAILLIST = "fINPaymentScheduleDetailList";
    public static final String PROPERTY_FINANCIALMGMTACCOUNTINGCOMBINATIONLIST = "financialMgmtAccountingCombinationList";
    public static final String PROPERTY_FINANCIALMGMTACCOUNTINGFACTLIST = "financialMgmtAccountingFactList";
    public static final String PROPERTY_FINANCIALMGMTACCTSCHEMAELEMENTLIST = "financialMgmtAcctSchemaElementList";
    public static final String PROPERTY_FINANCIALMGMTASSETLIST = "financialMgmtAssetList";
    public static final String PROPERTY_FINANCIALMGMTASSETEMSSALCUSTODIOIDLIST = "financialMgmtAssetEMSsalCustodioIDList";
    public static final String PROPERTY_FINANCIALMGMTBANKSTATEMENTEMSSWHBUSINESSPARTNERLIST = "financialMgmtBankStatementEMSSWHBusinessPartnerList";
    public static final String PROPERTY_FINANCIALMGMTBANKSTATEMENTLINEEMSSWHPARTNERIDLIST = "financialMgmtBankStatementLineEMSswhPartnerIDList";
    public static final String PROPERTY_FINANCIALMGMTBUDGETLINELIST = "financialMgmtBudgetLineList";
    public static final String PROPERTY_FINANCIALMGMTDEBTPAYMENTLIST = "financialMgmtDebtPaymentList";
    public static final String PROPERTY_FINANCIALMGMTDEBTPAYMENTCANCELVLIST = "financialMgmtDebtPaymentCancelVList";
    public static final String PROPERTY_FINANCIALMGMTDEBTPAYMENTGENERATEVLIST = "financialMgmtDebtPaymentGenerateVList";
    public static final String PROPERTY_FINANCIALMGMTGLJOURNALLIST = "financialMgmtGLJournalList";
    public static final String PROPERTY_FINANCIALMGMTGLJOURNALLINELIST = "financialMgmtGLJournalLineList";
    public static final String PROPERTY_FINANCIALMGMTTAXPAYMENTLIST = "financialMgmtTaxPaymentList";
    public static final String PROPERTY_FINANCIALMGMTWITHHOLDINGBENEFICIARYLIST = "financialMgmtWithholdingBeneficiaryList";
    public static final String PROPERTY_INOUTLINEACCOUNTINGDIMENSIONLIST = "inOutLineAccountingDimensionList";
    public static final String PROPERTY_INVOICELIST = "invoiceList";
    public static final String PROPERTY_INVOICEEMSSRECBPARTNERIDLIST = "invoiceEMSsreCBpartnerIDList";
    public static final String PROPERTY_INVOICELINELIST = "invoiceLineList";
    public static final String PROPERTY_INVOICELINEEMSSRECBPARTNERIDLIST = "invoiceLineEMSsreCBpartnerIDList";
    public static final String PROPERTY_INVOICELINEACCOUNTINGDIMENSIONLIST = "invoiceLineAccountingDimensionList";
    public static final String PROPERTY_INVOICELINEV2LIST = "invoiceLineV2List";
    public static final String PROPERTY_INVOICEV2LIST = "invoiceV2List";
    public static final String PROPERTY_MRPPRODUCTIONRUNLIST = "mRPProductionRunList";
    public static final String PROPERTY_MRPPURCHASINGRUNVENDORLIST = "mRPPurchasingRunVendorList";
    public static final String PROPERTY_MRPPURCHASINGRUNLIST = "mRPPurchasingRunList";
    public static final String PROPERTY_MRPPURCHASINGRUNLINELIST = "mRPPurchasingRunLineList";
    public static final String PROPERTY_MRPSALESFORECASTLIST = "mRPSalesForecastList";
    public static final String PROPERTY_MANUFACTURINGMAINTENANCEWORKERLIST = "manufacturingMaintenanceWorkerList";
    public static final String PROPERTY_MANUFACTURINGPRODUCTIONRUNEMPLOYEELIST = "manufacturingProductionRunEmployeeList";
    public static final String PROPERTY_MANUFACTURINGWORKEFFORTEMPLOYEELIST = "manufacturingWorkEffortEmployeeList";
    public static final String PROPERTY_MATERIALMGMTRESERVATIONLIST = "materialMgmtReservationList";
    public static final String PROPERTY_MATERIALMGMTSHIPMENTINOUTLIST = "materialMgmtShipmentInOutList";
    public static final String PROPERTY_MATERIALMGMTSHIPMENTINOUTLINELIST = "materialMgmtShipmentInOutLineList";
    public static final String PROPERTY_ORDERLIST = "orderList";
    public static final String PROPERTY_ORDERDROPSHIPPARTNERLIST = "orderDropShipPartnerList";
    public static final String PROPERTY_ORDERLINELIST = "orderLineList";
    public static final String PROPERTY_ORDERLINEACCOUNTINGDIMENSIONLIST = "orderLineAccountingDimensionList";
    public static final String PROPERTY_ORGANIZATIONEMSFCBRBALANCESIGN1LIST = "organizationEMSfcbrBalanceSign1List";
    public static final String PROPERTY_ORGANIZATIONEMSFCBRBALANCESIGN2LIST = "organizationEMSfcbrBalanceSign2List";
    public static final String PROPERTY_ORGANIZATIONINFORMATIONLIST = "organizationInformationList";
    public static final String PROPERTY_PRERESERVATIONMANUALPICKEDITLIST = "prereservationManualPickEditList";
    public static final String PROPERTY_PRICINGADJUSTMENTBUSINESSPARTNERLIST = "pricingAdjustmentBusinessPartnerList";
    public static final String PROPERTY_PRICINGPRICELISTSCHEMELINELIST = "pricingPriceListSchemeLineList";
    public static final String PROPERTY_PRICINGVOLUMEDISCOUNTBUSINESSPARTNERLIST = "pricingVolumeDiscountBusinessPartnerList";
    public static final String PROPERTY_PROCUREMENTREQUISITIONLIST = "procurementRequisitionList";
    public static final String PROPERTY_PROCUREMENTREQUISITIONLINELIST = "procurementRequisitionLineList";
    public static final String PROPERTY_PRODUCTLIST = "productList";
    public static final String PROPERTY_PRODUCTCUSTOMERLIST = "productCustomerList";
    public static final String PROPERTY_PROJECTLIST = "projectList";
    public static final String PROPERTY_PROJECTPERSONINCHARGELIST = "projectPersonInChargeList";
    public static final String PROPERTY_PROJECTPROPOSALLIST = "projectProposalList";
    public static final String PROPERTY_PROJECTVENDORLIST = "projectVendorList";
    public static final String PROPERTY_RETURNMATERIALRECEIPTPICKEDITLIST = "returnMaterialReceiptPickEditList";
    public static final String PROPERTY_RETURNMATERIALSHIPMENTPICKEDITLIST = "returnMaterialShipmentPickEditList";
    public static final String PROPERTY_SBPCINFOPARTNERSVLIST = "sBPCInfoPartnersVList";
    public static final String PROPERTY_SBPCINFOPARTNERSVCBPARTNERIDTAXLIST = "sBPCInfoPartnersVCBpartnerIdTaxList";
    public static final String PROPERTY_SBPCINFOPARTNERSVCBPARTNERIDNAMELIST = "sBPCInfoPartnersVCBpartnerIdNameList";
    public static final String PROPERTY_SBPCINFOPARTNERSVCBPARTNERIDMAILLIST = "sBPCInfoPartnersVCBpartnerIdMailList";
    public static final String PROPERTY_SRSISALESINVOICEVCBPARTNERIDCODLIST = "sRSISalesInvoiceVCBpartnerIdCodList";
    public static final String PROPERTY_SRSISALESINVOICEVCBPARTNERIDNAMELIST = "sRSISalesInvoiceVCBpartnerIdNameList";
    public static final String PROPERTY_SSACCTACCOUNTINGFACTSECONDARYLIST = "sSACCTAccountingFactSecondaryList";
    public static final String PROPERTY_SSACCTJOURNALLIST = "sSACCTJOURNALList";
    public static final String PROPERTY_SSACCTJOURNALLINELIST = "sSACCTJournalLineList";
    public static final String PROPERTY_SSPHTENTHSETTLEMENTLINELIST = "sSPHTenthSettlementLineList";
    public static final String PROPERTY_SSPPPAYMENTSLIST = "sSPPPAYMENTSList";
    public static final String PROPERTY_SSPPPAYMENTSLINELIST = "sSPPPAYMENTSLINEList";
    public static final String PROPERTY_SSPRCATEGORYLIST = "sSPRCategoryList";
    public static final String PROPERTY_SSPRCONCEPTAMOUNTLIST = "sSPRConceptAmountList";
    public static final String PROPERTY_SSPRCONTRACTLIST = "sSPRContractList";
    public static final String PROPERTY_SSPRFAMILYLIST = "sSPRFamilyList";
    public static final String PROPERTY_SSPRLEAVEEMPLIST = "sSPRLeaveEmpList";
    public static final String PROPERTY_SSPRLEAVEEMPWHOREPLACELIST = "sSPRLeaveEmpWhoReplaceList";
    public static final String PROPERTY_SSPRLEAVEEMPAUTHORIZEDLIST = "sSPRLeaveEmpAuthorizedList";
    public static final String PROPERTY_SSPRLEAVEEMPCURRENTUSERIDLIST = "sSPRLeaveEmpCurrentUserIDList";
    public static final String PROPERTY_SSPRPAYROLLLIST = "sSPRPayrollList";
    public static final String PROPERTY_SSPRPAYROLLTICKETLIST = "sSPRPayrollTicketList";
    public static final String PROPERTY_SSPRPERIODLIST = "sSPRPeriodList";
    public static final String PROPERTY_SSVEVIATICALLIST = "sSVEViaticalList";
    public static final String PROPERTY_SSVEVIATICALSETTLEMENTLIST = "sSVEViaticalSettlementList";
    public static final String PROPERTY_SSWHCHECKBOOKPOSLIST = "sSWHCheckbookposList";
    public static final String PROPERTY_SSWHCHECKBOOKPOSLINELIST = "sSWHCheckbookposLineList";
    public static final String PROPERTY_SSWHRECEIPTLIST = "sSWHReceiptList";
    public static final String PROPERTY_SSWHWITHHOLDINGVENDORLIST = "sSWHWithholdingVendorList";
    public static final String PROPERTY_SSWSWITHHOLDINGSALELIST = "sSWSWithholdingSaleList";
    public static final String PROPERTY_SWSICCONFIGLIST = "sWSICConfigList";
    public static final String PROPERTY_SALESCOMMISSIONLIST = "salesCommissionList";
    public static final String PROPERTY_SALESCOMMISSIONLINELIST = "salesCommissionLineList";
    public static final String PROPERTY_SFBTRBUDGETARYREFORMSLIST = "sfbtrBudgetaryReformsList";
    public static final String PROPERTY_SHIPPINGSHIPPINGCOMPANYLIST = "shippingShippingCompanyList";
    public static final String PROPERTY_SSWHRPTCPURCHASEWITHLIST = "sswhRptcPurchaseWithList";
    public static final String PROPERTY_TIMEANDEXPENSESHEETLIST = "timeAndExpenseSheetList";
    public static final String PROPERTY_TIMEANDEXPENSESHEETLINELIST = "timeAndExpenseSheetLineList";
    public static final String PROPERTY_TIMEANDEXPENSESHEETLINEVLIST = "timeAndExpenseSheetLineVList";
    public static final String PROPERTY_TIMEANDEXPENSESHEETLINEVCHARGEDBUSINESSPARTNERLIST = "timeAndExpenseSheetLineVChargedBusinessPartnerList";
    public static final String PROPERTY_TRANSACTIONVLIST = "transactionVList";
    public static final String PROPERTY_USERDIMENSION2EMSSFLBROKERVALUELIST = "userDimension2EMSsflBrokervalueList";
    public static final String PROPERTY_USERDIMENSION2EMSSFLBROKERVALUE2LIST = "userDimension2EMSsflBrokervalue2List";
    public static final String PROPERTY_VENDORACCOUNTSLIST = "vendorAccountsList";
    public static final String PROPERTY_WAREHOUSESHIPPERLIST = "warehouseShipperList";
    public static final String PROPERTY_EEIPAYMENTDETAILVLIST = "eeiPaymentDetailVList";
    public static final String PROPERTY_OPCRMACTIVITYLIST = "opcrmActivityList";
    public static final String PROPERTY_OPCRMCASESLIST = "opcrmCasesList";
    public static final String PROPERTY_OPCRMDOCUMENTSLIST = "opcrmDocumentsList";
    public static final String PROPERTY_OPCRMOPPORTUNITIESLIST = "opcrmOpportunitiesList";
    public static final String PROPERTY_SCPPAPPROVALPAYMENTLINELIST = "scppApprovalpaymentlineList";
    public static final String PROPERTY_SFBBUDGETCERTLINEDETVORDERBUSINESSPARTNERLIST = "sfbBudgetCertLineDetVOrderBusinessPartnerList";
    public static final String PROPERTY_SFBBUDGETCERTLINEDETVINVOICEBUSINESSPARTNERLIST = "sfbBudgetCertLineDetVInvoiceBusinessPartnerList";
    public static final String PROPERTY_SFBBUDGETDETAILSVCBPARTNERORDIDLIST = "sfbBudgetDetailsVCBpartnerOrdIDList";
    public static final String PROPERTY_SFBBUDGETDETAILSVCBPARTNERINVIDLIST = "sfbBudgetDetailsVCBpartnerInvIDList";
    public static final String PROPERTY_SFBBUDGETDETAILSVCBPARTNERIDPAYLIST = "sfbBudgetDetailsVCBpartnerIdPayList";
    public static final String PROPERTY_SFBBUDGETPAYMENTDETVLIST = "sfbBudgetPaymentDetVList";
    public static final String PROPERTY_SFPREMPLOYEEOTHERLIST = "sfprEmployeeOtherList";
    public static final String PROPERTY_SFPREMPLOYEEPERMITLIST = "sfprEmployeePermitList";
    public static final String PROPERTY_SFPREMPLOYEERVELIST = "sfprEmployeeRveList";
    public static final String PROPERTY_SFPREMPLOYEESURROGATELIST = "sfprEmployeeSurrogateList";
    public static final String PROPERTY_SFPREMPLOYEEVACATIONLIST = "sfprEmployeeVacationList";
    public static final String PROPERTY_SFPRJOBACTIONLIST = "sfprJobActionList";
    public static final String PROPERTY_SFPRPROVISIONPROPERTYLIST = "sfprProvisionPropertyList";
    public static final String PROPERTY_SFPRRVEDETAILLIST = "sfprRveDetailList";
    public static final String PROPERTY_SFPRSURROGATEDETAILLIST = "sfprSurrogateDetailList";
    public static final String PROPERTY_SQBCONFIGQUICKBILLINGBPARTNERIDLIST = "sqbConfigQuickbillingBpartnerIDList";
    public static final String PROPERTY_SQBQUICKBILLINGLIST = "sqbQuickbillingList";
    public static final String PROPERTY_SSALAPPLACTIVELIST = "ssalApplActiveList";
    public static final String PROPERTY_SSALAPPLACTIVECCUSTODIANIDLIST = "ssalApplActiveCCustodianIDList";
    public static final String PROPERTY_SSALASSETRETURNLIST = "ssalAssetReturnList";
    public static final String PROPERTY_SSALASSETRETURNCUSTODIANLIST = "ssalAssetReturnCustodianList";
    public static final String PROPERTY_SSAMALIENATELIST = "ssamAlienateList";
    public static final String PROPERTY_SSCTCONTRACTLIST = "ssctContractList";
    public static final String PROPERTY_SSCTCONTRACTADMINISTRATORLIST = "ssctContractAdministratorList";
    public static final String PROPERTY_SSFIFINPAYMENTDETAILVLIST = "ssfiFinPaymentDetailVList";
    public static final String PROPERTY_SSFIFINPAYMENTDETAILVBUSINESSPARTNERDIMLIST = "ssfiFinPaymentDetailVBusinessPartnerdimList";
    public static final String PROPERTY_SSFLINVOICEVOYAGEBROKERVALUELIST = "ssflInvoiceVoyageBrokerValueList";
    public static final String PROPERTY_SSFLRECAPLIST = "ssflRecapList";
    public static final String PROPERTY_SSFLRECAPOWNERIDLIST = "ssflRecapOwnerIDList";
    public static final String PROPERTY_SSFWAPPROVALRANGEAPPROVER1STLEVELLIST = "ssfwApprovalRangeApprover1stLevelList";
    public static final String PROPERTY_SSFWAPPROVALRANGEAPPROVER2NDLEVELLIST = "ssfwApprovalRangeApprover2ndLevelList";
    public static final String PROPERTY_SSFWAPPROVALRANGEAPPROVERSIMPLELIST = "ssfwApprovalRangeApproverSimpleList";
    public static final String PROPERTY_SSFWORDERAPPROVALAPPROVER1STLEVELLIST = "ssfwOrderApprovalApprover1stLevelList";
    public static final String PROPERTY_SSFWORDERAPPROVALAPPROVER2NDLEVELLIST = "ssfwOrderApprovalApprover2ndLevelList";
    public static final String PROPERTY_SSHRCHINTEXTINTERNALLIST = "sshrChIntExtInternalList";
    public static final String PROPERTY_SSHRCHINTEXTEXTERNALLIST = "sshrChIntExtExternalList";
    public static final String PROPERTY_SSHREMPLOYEELANGUAGELIST = "sshrEmployeeLanguageList";
    public static final String PROPERTY_SSHREMPLOYEEPROJECTLIST = "sshrEmployeeProjectList";
    public static final String PROPERTY_SSHREMPLOYEEPROMOTIONLIST = "sshrEmployeePromotionList";
    public static final String PROPERTY_SSHREXAMINATIONTESTLIST = "sshrExaminationTestList";
    public static final String PROPERTY_SSHRJOBLIST = "sshrJobList";
    public static final String PROPERTY_SSHRQEDUCATIONLIST = "sshrQeducationList";
    public static final String PROPERTY_SSHRQSKILLSLIST = "sshrQskillsList";
    public static final String PROPERTY_SSHRQWORKEXPIRENCELIST = "sshrQworkExpirenceList";
    public static final String PROPERTY_SSHRREPORTTOLIST = "sshrReporttoList";
    public static final String PROPERTY_SSHRREPORTTOBOSSLIST = "sshrReporttoBossList";
    public static final String PROPERTY_SSHRREPORTTOBOSSALLTERNATINGLIST = "sshrReporttoBossAllternatingList";
    public static final String PROPERTY_SSHRSALARYCOMPONENTLIST = "sshrSalaryComponentList";
    public static final String PROPERTY_SSHRTCOURSESLIST = "sshrTcoursesList";
    public static final String PROPERTY_SSHRTRAININGCALENDARLIST = "sshrTrainingCalendarList";
    public static final String PROPERTY_SSHRTRAININGLINELIST = "sshrTraininglineList";
    public static final String PROPERTY_SSPDPCTDISTEMPLIST = "sspdPctdistEmpList";
    public static final String PROPERTY_SSPRATTENDANCELIST = "ssprAttendanceList";
    public static final String PROPERTY_SSPRCOSTEMPLOYEELIST = "ssprCostemployeeList";
    public static final String PROPERTY_SSPRCUMULATIVECONCEPTLIST = "ssprCumulativeconceptList";
    public static final String PROPERTY_SSPREMPLOYEESETTLEMENTLIST = "ssprEmployeesettlementList";
    public static final String PROPERTY_SSPRFORMULARY107DETAILVLIST = "ssprFormulary107DetailVList";
    public static final String PROPERTY_SSPRFORMULARYLINE107LIST = "ssprFormularyline107List";
    public static final String PROPERTY_SSPRINCOMETOTALLIST = "ssprIncometotalList";
    public static final String PROPERTY_SSPRLEAVECONFDEFAULTLIST = "ssprLeaveConfDefaultList";
    public static final String PROPERTY_SSPRLEAVEGROUPLIST = "ssprLeaveGroupList";
    public static final String PROPERTY_SSPRLEAVEHRMANAGEMENTLIST = "ssprLeaveHrManagementList";
    public static final String PROPERTY_SSPRLOANSLIST = "ssprLoansList";
    public static final String PROPERTY_SSPRPAYROLLEMPLIST = "ssprPayrollEmpList";
    public static final String PROPERTY_SSPRPROFITSLIST = "ssprProfitsList";
    public static final String PROPERTY_SSPRREADMISSIONSLIST = "ssprReadmissionsList";
    public static final String PROPERTY_SSPRSETTLEMENTLIST = "ssprSettlementList";
    public static final String PROPERTY_SSPRUTILITIESLIST = "ssprUtilitiesList";
    public static final String PROPERTY_SSPRUTILITYDETAILLIST = "ssprUtilityDetailList";
    public static final String PROPERTY_SSPRVACATIONSLIST = "ssprVacationsList";
    public static final String PROPERTY_SSREREFUNDINVOICELIST = "ssreRefundinvoiceList";
    public static final String PROPERTY_SSVEBUDGETDETAILSVCBPARTNERORDIDLIST = "ssveBudgetDetailsVCBpartnerOrdIDList";
    public static final String PROPERTY_SSVEBUDGETDETAILSVCBPARTNERINVIDLIST = "ssveBudgetDetailsVCBpartnerInvIDList";
    public static final String PROPERTY_SSVEBUDGETDETAILSVCBPARTNERIDPAYLIST = "ssveBudgetDetailsVCBpartnerIdPayList";
    public static final String PROPERTY_SSVEBUDGETDETAILSVCBPARTNERIDVIALIST = "ssveBudgetDetailsVCBpartnerIdViaList";
    public static final String PROPERTY_SSVEVIATICALDETAILSVLIST = "ssveViaticalDetailsVList";
    public static final String PROPERTY_SSWHWITHHCARDCREDITLIST = "sswhWithhCardCreditList";

    public BusinessPartner() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_SUMMARYLEVEL, false);
        setDefaultValue(PROPERTY_ONETIMETRANSACTION, false);
        setDefaultValue(PROPERTY_POTENTIALCUSTOMER, false);
        setDefaultValue(PROPERTY_VENDOR, false);
        setDefaultValue(PROPERTY_CUSTOMER, true);
        setDefaultValue(PROPERTY_EMPLOYEE, false);
        setDefaultValue(PROPERTY_ISSALESREPRESENTATIVE, false);
        setDefaultValue(PROPERTY_TAXEXEMPT, false);
        setDefaultValue(PROPERTY_PRINTDISCOUNT, false);
        setDefaultValue(PROPERTY_INVOICETERMS, "I");
        setDefaultValue(PROPERTY_PRICESSHOWNINORDER, true);
        setDefaultValue(PROPERTY_INVOICEGROUPING, "000000000000000");
        setDefaultValue(PROPERTY_OPERATOR, false);
        setDefaultValue(PROPERTY_CONSUMPTIONDAYS, (long) 1000);
        setDefaultValue(PROPERTY_CUSTOMERBLOCKING, false);
        setDefaultValue(PROPERTY_SSWHTAXIDTYPE, "D");
        setDefaultValue(PROPERTY_VENDORBLOCKING, false);
        setDefaultValue(PROPERTY_PAYMENTIN, false);
        setDefaultValue(PROPERTY_PAYMENTOUT, true);
        setDefaultValue(PROPERTY_SALESINVOICE, true);
        setDefaultValue(PROPERTY_PURCHASEINVOICE, true);
        setDefaultValue(PROPERTY_SALESORDER, true);
        setDefaultValue(PROPERTY_PURCHASEORDER, true);
        setDefaultValue(PROPERTY_GOODSSHIPMENT, true);
        setDefaultValue(PROPERTY_GOODSRECEIPT, false);
        setDefaultValue(PROPERTY_CASHVAT, false);
        setDefaultValue(PROPERTY_EEIEEIOICE, false);
        setDefaultValue(PROPERTY_SETNEWCURRENCY, false);
        setDefaultValue(PROPERTY_OPCRMBTNCREATEOPP, false);
        setDefaultValue(PROPERTY_OPCRMBTNCREATEACT, false);
        setDefaultValue(PROPERTY_SSHRDISABILITYCHK, false);
        setDefaultValue(PROPERTY_EEIEEIOICEV, false);
        setDefaultValue(PROPERTY_OPCRMISPOSDEFAULT, false);
        setDefaultValue(PROPERTY_SSPRRESERVEFUNDSIESS, false);
        setDefaultValue(PROPERTY_SSPRRESERVEFUNDSCOMPANY, false);
        setDefaultValue(PROPERTY_SSPRSEVERANCEFOUNDS, false);
        setDefaultValue(PROPERTY_SSPRCREATEPAYROLL, true);
        setDefaultValue(PROPERTY_SSFLRELACIONADO, false);
        setDefaultValue(PROPERTY_SFPRISFPR, false);
        setDefaultValue(PROPERTY_SSPRISDISABLED, false);
        setDefaultValue(PROPERTY_SSPRISEXECUTIVE, false);
        setDefaultValue(PROPERTY_SSPRTHIRTEENTH, false);
        setDefaultValue(PROPERTY_SSPRFOURTEENTH, false);
        setDefaultValue(PROPERTY_EEIDETAILEI, false);
        setDefaultValue(PROPERTY_SSPRISPASSANT, false);
        setDefaultValue(PROPERTY_SSPREXTRAHOURS, false);
        setDefaultValue(PROPERTY_SSPRBONUSPUNCTUAL, false);
        setDefaultValue(PROPERTY_SSPRREPRESENTSDISABLED, false);
        setDefaultValue(PROPERTY_SSFLISCHARTERER, false);
        setDefaultValue(PROPERTY_SSFIFOREIGN, false);
        setDefaultValue(PROPERTY_SSFLISOWNER, false);
        setDefaultValue(PROPERTY_ADUSERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADUSEREMOPCRMREPORTSTOLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_APRMFINACCTRANSACTIONACCTVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_APRMFINACCTRANSACTIONVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_APRMFINACCTRXFULLACCTVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_APRMPAYMENTPROPOSALPICKEDITLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ACTIVEPROPOSALVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_AMORTIZATIONLINEACCOUNTINGDIMENSIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_APPROVEDVENDORLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_BANKLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_BUSINESSPARTNERSALESREPRESENTATIVELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_BUSINESSPARTNEREMSSWHSALEADVISORLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_BUSINESSPARTNEREMSSWHCOLLECTINGAGENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_BUSINESSPARTNEREMSSPRBPARTNERDISABLEDIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_BUSINESSPARTNERBANKACCOUNTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_BUSINESSPARTNERDISCOUNTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_BUSINESSPARTNERLOCATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_BUSINESSPARTNERPRODUCTTEMPLATELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_BUSINESSPARTNERWITHHOLDINGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICETAXCASHVATVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_CLIENTINFORMATIONTEMPLATEBPARTNERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_CLIENTINFORMATIONEMSSPRCBPARTNERIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_CUSTOMERACCOUNTSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_EMAILINTERACTIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_EMPLOYEEACCOUNTSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_EMPLOYEESALARYCATEGORYLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_EXTERNALPOSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINBANKSTATEMENTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINDOUBTFULDEBTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINDOUBTFULDEBTRUNLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINDOUBTFULDEBTVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINFINACCTRANSACTIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINFINANCIALACCOUNTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTEMSSPACCBPARTNERIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTDETAILVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTDETAILVBUSINESSPARTNERDIMLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTPROPDETAILVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTPROPOSALLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTSCHEDULEDETAILLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTACCOUNTINGCOMBINATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTACCOUNTINGFACTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTACCTSCHEMAELEMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTASSETLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTASSETEMSSALCUSTODIOIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTBANKSTATEMENTEMSSWHBUSINESSPARTNERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTBANKSTATEMENTLINEEMSSWHPARTNERIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTBUDGETLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTDEBTPAYMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTDEBTPAYMENTCANCELVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTDEBTPAYMENTGENERATEVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTGLJOURNALLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTGLJOURNALLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTTAXPAYMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTWITHHOLDINGBENEFICIARYLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INOUTLINEACCOUNTINGDIMENSIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICEEMSSRECBPARTNERIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELINEEMSSRECBPARTNERIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELINEACCOUNTINGDIMENSIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELINEV2LIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICEV2LIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MRPPRODUCTIONRUNLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MRPPURCHASINGRUNVENDORLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MRPPURCHASINGRUNLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MRPPURCHASINGRUNLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MRPSALESFORECASTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MANUFACTURINGMAINTENANCEWORKERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MANUFACTURINGPRODUCTIONRUNEMPLOYEELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MANUFACTURINGWORKEFFORTEMPLOYEELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTRESERVATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTSHIPMENTINOUTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTSHIPMENTINOUTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERDROPSHIPPARTNERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERLINEACCOUNTINGDIMENSIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORGANIZATIONEMSFCBRBALANCESIGN1LIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORGANIZATIONEMSFCBRBALANCESIGN2LIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORGANIZATIONINFORMATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRERESERVATIONMANUALPICKEDITLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRICINGADJUSTMENTBUSINESSPARTNERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRICINGPRICELISTSCHEMELINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRICINGVOLUMEDISCOUNTBUSINESSPARTNERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROCUREMENTREQUISITIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROCUREMENTREQUISITIONLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRODUCTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRODUCTCUSTOMERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROJECTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROJECTPERSONINCHARGELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROJECTPROPOSALLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROJECTVENDORLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_RETURNMATERIALRECEIPTPICKEDITLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_RETURNMATERIALSHIPMENTPICKEDITLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SBPCINFOPARTNERSVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SBPCINFOPARTNERSVCBPARTNERIDTAXLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SBPCINFOPARTNERSVCBPARTNERIDNAMELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SBPCINFOPARTNERSVCBPARTNERIDMAILLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SRSISALESINVOICEVCBPARTNERIDCODLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SRSISALESINVOICEVCBPARTNERIDNAMELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSACCTACCOUNTINGFACTSECONDARYLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSACCTJOURNALLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSACCTJOURNALLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPHTENTHSETTLEMENTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPPPAYMENTSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPPPAYMENTSLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRCATEGORYLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRCONCEPTAMOUNTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRCONTRACTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRFAMILYLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRLEAVEEMPLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRLEAVEEMPWHOREPLACELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRLEAVEEMPAUTHORIZEDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRLEAVEEMPCURRENTUSERIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRPAYROLLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRPAYROLLTICKETLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRPERIODLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSVEVIATICALLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSVEVIATICALSETTLEMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWHCHECKBOOKPOSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWHCHECKBOOKPOSLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWHRECEIPTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWHWITHHOLDINGVENDORLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWSWITHHOLDINGSALELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SWSICCONFIGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SALESCOMMISSIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SALESCOMMISSIONLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBTRBUDGETARYREFORMSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SHIPPINGSHIPPINGCOMPANYLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWHRPTCPURCHASEWITHLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_TIMEANDEXPENSESHEETLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_TIMEANDEXPENSESHEETLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_TIMEANDEXPENSESHEETLINEVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_TIMEANDEXPENSESHEETLINEVCHARGEDBUSINESSPARTNERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_TRANSACTIONVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_USERDIMENSION2EMSSFLBROKERVALUELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_USERDIMENSION2EMSSFLBROKERVALUE2LIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_VENDORACCOUNTSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_WAREHOUSESHIPPERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_EEIPAYMENTDETAILVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OPCRMACTIVITYLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OPCRMCASESLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OPCRMDOCUMENTSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OPCRMOPPORTUNITIESLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCPPAPPROVALPAYMENTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETCERTLINEDETVORDERBUSINESSPARTNERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETCERTLINEDETVINVOICEBUSINESSPARTNERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETDETAILSVCBPARTNERORDIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETDETAILSVCBPARTNERINVIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETDETAILSVCBPARTNERIDPAYLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETPAYMENTDETVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPREMPLOYEEOTHERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPREMPLOYEEPERMITLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPREMPLOYEERVELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPREMPLOYEESURROGATELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPREMPLOYEEVACATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPRJOBACTIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPRPROVISIONPROPERTYLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPRRVEDETAILLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPRSURROGATEDETAILLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SQBCONFIGQUICKBILLINGBPARTNERIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SQBQUICKBILLINGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALAPPLACTIVELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALAPPLACTIVECCUSTODIANIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALASSETRETURNLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALASSETRETURNCUSTODIANLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSAMALIENATELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSCTCONTRACTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSCTCONTRACTADMINISTRATORLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSFIFINPAYMENTDETAILVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSFIFINPAYMENTDETAILVBUSINESSPARTNERDIMLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSFLINVOICEVOYAGEBROKERVALUELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSFLRECAPLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSFLRECAPOWNERIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSFWAPPROVALRANGEAPPROVER1STLEVELLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSFWAPPROVALRANGEAPPROVER2NDLEVELLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSFWAPPROVALRANGEAPPROVERSIMPLELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSFWORDERAPPROVALAPPROVER1STLEVELLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSFWORDERAPPROVALAPPROVER2NDLEVELLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSHRCHINTEXTINTERNALLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSHRCHINTEXTEXTERNALLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSHREMPLOYEELANGUAGELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSHREMPLOYEEPROJECTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSHREMPLOYEEPROMOTIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSHREXAMINATIONTESTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSHRJOBLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSHRQEDUCATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSHRQSKILLSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSHRQWORKEXPIRENCELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSHRREPORTTOLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSHRREPORTTOBOSSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSHRREPORTTOBOSSALLTERNATINGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSHRSALARYCOMPONENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSHRTCOURSESLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSHRTRAININGCALENDARLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSHRTRAININGLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPDPCTDISTEMPLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRATTENDANCELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRCOSTEMPLOYEELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRCUMULATIVECONCEPTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPREMPLOYEESETTLEMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRFORMULARY107DETAILVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRFORMULARYLINE107LIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRINCOMETOTALLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRLEAVECONFDEFAULTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRLEAVEGROUPLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRLEAVEHRMANAGEMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRLOANSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRPAYROLLEMPLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRPROFITSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRREADMISSIONSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRSETTLEMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRUTILITIESLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRUTILITYDETAILLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRVACATIONSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSREREFUNDINVOICELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSVEBUDGETDETAILSVCBPARTNERORDIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSVEBUDGETDETAILSVCBPARTNERINVIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSVEBUDGETDETAILSVCBPARTNERIDPAYLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSVEBUDGETDETAILSVCBPARTNERIDVIALIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSVEVIATICALDETAILSVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWHWITHHCARDCREDITLIST, new ArrayList<Object>());
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

    public String getSearchKey() {
        return (String) get(PROPERTY_SEARCHKEY);
    }

    public void setSearchKey(String searchKey) {
        set(PROPERTY_SEARCHKEY, searchKey);
    }

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public String getName2() {
        return (String) get(PROPERTY_NAME2);
    }

    public void setName2(String name2) {
        set(PROPERTY_NAME2, name2);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Boolean isSummaryLevel() {
        return (Boolean) get(PROPERTY_SUMMARYLEVEL);
    }

    public void setSummaryLevel(Boolean summaryLevel) {
        set(PROPERTY_SUMMARYLEVEL, summaryLevel);
    }

    public Category getBusinessPartnerCategory() {
        return (Category) get(PROPERTY_BUSINESSPARTNERCATEGORY);
    }

    public void setBusinessPartnerCategory(Category businessPartnerCategory) {
        set(PROPERTY_BUSINESSPARTNERCATEGORY, businessPartnerCategory);
    }

    public Boolean isOneTimeTransaction() {
        return (Boolean) get(PROPERTY_ONETIMETRANSACTION);
    }

    public void setOneTimeTransaction(Boolean oneTimeTransaction) {
        set(PROPERTY_ONETIMETRANSACTION, oneTimeTransaction);
    }

    public Boolean isPotentialCustomer() {
        return (Boolean) get(PROPERTY_POTENTIALCUSTOMER);
    }

    public void setPotentialCustomer(Boolean potentialCustomer) {
        set(PROPERTY_POTENTIALCUSTOMER, potentialCustomer);
    }

    public Boolean isVendor() {
        return (Boolean) get(PROPERTY_VENDOR);
    }

    public void setVendor(Boolean vendor) {
        set(PROPERTY_VENDOR, vendor);
    }

    public Boolean isCustomer() {
        return (Boolean) get(PROPERTY_CUSTOMER);
    }

    public void setCustomer(Boolean customer) {
        set(PROPERTY_CUSTOMER, customer);
    }

    public Boolean isEmployee() {
        return (Boolean) get(PROPERTY_EMPLOYEE);
    }

    public void setEmployee(Boolean employee) {
        set(PROPERTY_EMPLOYEE, employee);
    }

    public Boolean isSalesRepresentative() {
        return (Boolean) get(PROPERTY_ISSALESREPRESENTATIVE);
    }

    public void setSalesRepresentative(Boolean isSalesRepresentative) {
        set(PROPERTY_ISSALESREPRESENTATIVE, isSalesRepresentative);
    }

    public String getReferenceNo() {
        return (String) get(PROPERTY_REFERENCENO);
    }

    public void setReferenceNo(String referenceNo) {
        set(PROPERTY_REFERENCENO, referenceNo);
    }

    public String getDUNS() {
        return (String) get(PROPERTY_DUNS);
    }

    public void setDUNS(String dUNS) {
        set(PROPERTY_DUNS, dUNS);
    }

    public String getURL() {
        return (String) get(PROPERTY_URL);
    }

    public void setURL(String uRL) {
        set(PROPERTY_URL, uRL);
    }

    public Language getLanguage() {
        return (Language) get(PROPERTY_LANGUAGE);
    }

    public void setLanguage(Language language) {
        set(PROPERTY_LANGUAGE, language);
    }

    public String getTaxID() {
        return (String) get(PROPERTY_TAXID);
    }

    public void setTaxID(String taxID) {
        set(PROPERTY_TAXID, taxID);
    }

    public Boolean isTaxExempt() {
        return (Boolean) get(PROPERTY_TAXEXEMPT);
    }

    public void setTaxExempt(Boolean taxExempt) {
        set(PROPERTY_TAXEXEMPT, taxExempt);
    }

    public InvoiceSchedule getInvoiceSchedule() {
        return (InvoiceSchedule) get(PROPERTY_INVOICESCHEDULE);
    }

    public void setInvoiceSchedule(InvoiceSchedule invoiceSchedule) {
        set(PROPERTY_INVOICESCHEDULE, invoiceSchedule);
    }

    public String getValuation() {
        return (String) get(PROPERTY_VALUATION);
    }

    public void setValuation(String valuation) {
        set(PROPERTY_VALUATION, valuation);
    }

    public BigDecimal getVolumeOfSales() {
        return (BigDecimal) get(PROPERTY_VOLUMEOFSALES);
    }

    public void setVolumeOfSales(BigDecimal volumeOfSales) {
        set(PROPERTY_VOLUMEOFSALES, volumeOfSales);
    }

    public Long getNoOfEmployees() {
        return (Long) get(PROPERTY_NOOFEMPLOYEES);
    }

    public void setNoOfEmployees(Long noOfEmployees) {
        set(PROPERTY_NOOFEMPLOYEES, noOfEmployees);
    }

    public String getNAICSSIC() {
        return (String) get(PROPERTY_NAICSSIC);
    }

    public void setNAICSSIC(String nAICSSIC) {
        set(PROPERTY_NAICSSIC, nAICSSIC);
    }

    public Date getDateOfFirstSale() {
        return (Date) get(PROPERTY_DATEOFFIRSTSALE);
    }

    public void setDateOfFirstSale(Date dateOfFirstSale) {
        set(PROPERTY_DATEOFFIRSTSALE, dateOfFirstSale);
    }

    public BigDecimal getAcquisitionCost() {
        return (BigDecimal) get(PROPERTY_ACQUISITIONCOST);
    }

    public void setAcquisitionCost(BigDecimal acquisitionCost) {
        set(PROPERTY_ACQUISITIONCOST, acquisitionCost);
    }

    public BigDecimal getExpectedLifetimeRevenue() {
        return (BigDecimal) get(PROPERTY_EXPECTEDLIFETIMEREVENUE);
    }

    public void setExpectedLifetimeRevenue(BigDecimal expectedLifetimeRevenue) {
        set(PROPERTY_EXPECTEDLIFETIMEREVENUE, expectedLifetimeRevenue);
    }

    public BigDecimal getLifetimeRevenueToDate() {
        return (BigDecimal) get(PROPERTY_LIFETIMEREVENUETODATE);
    }

    public void setLifetimeRevenueToDate(BigDecimal lifetimeRevenueToDate) {
        set(PROPERTY_LIFETIMEREVENUETODATE, lifetimeRevenueToDate);
    }

    public Long getShare() {
        return (Long) get(PROPERTY_SHARE);
    }

    public void setShare(Long share) {
        set(PROPERTY_SHARE, share);
    }

    public String getFormOfPayment() {
        return (String) get(PROPERTY_FORMOFPAYMENT);
    }

    public void setFormOfPayment(String formOfPayment) {
        set(PROPERTY_FORMOFPAYMENT, formOfPayment);
    }

    public BigDecimal getCreditLimit() {
        return (BigDecimal) get(PROPERTY_CREDITLIMIT);
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        set(PROPERTY_CREDITLIMIT, creditLimit);
    }

    public BigDecimal getCreditUsed() {
        return (BigDecimal) get(PROPERTY_CREDITUSED);
    }

    public void setCreditUsed(BigDecimal creditUsed) {
        set(PROPERTY_CREDITUSED, creditUsed);
    }

    public PaymentTerm getPaymentTerms() {
        return (PaymentTerm) get(PROPERTY_PAYMENTTERMS);
    }

    public void setPaymentTerms(PaymentTerm paymentTerms) {
        set(PROPERTY_PAYMENTTERMS, paymentTerms);
    }

    public PriceList getPriceList() {
        return (PriceList) get(PROPERTY_PRICELIST);
    }

    public void setPriceList(PriceList priceList) {
        set(PROPERTY_PRICELIST, priceList);
    }

    public Boolean isPrintDiscount() {
        return (Boolean) get(PROPERTY_PRINTDISCOUNT);
    }

    public void setPrintDiscount(Boolean printDiscount) {
        set(PROPERTY_PRINTDISCOUNT, printDiscount);
    }

    public String getOrderDescription() {
        return (String) get(PROPERTY_ORDERDESCRIPTION);
    }

    public void setOrderDescription(String orderDescription) {
        set(PROPERTY_ORDERDESCRIPTION, orderDescription);
    }

    public String getOrderReference() {
        return (String) get(PROPERTY_ORDERREFERENCE);
    }

    public void setOrderReference(String orderReference) {
        set(PROPERTY_ORDERREFERENCE, orderReference);
    }

    public String getPOFormOfPayment() {
        return (String) get(PROPERTY_POFORMOFPAYMENT);
    }

    public void setPOFormOfPayment(String pOFormOfPayment) {
        set(PROPERTY_POFORMOFPAYMENT, pOFormOfPayment);
    }

    public PriceList getPurchasePricelist() {
        return (PriceList) get(PROPERTY_PURCHASEPRICELIST);
    }

    public void setPurchasePricelist(PriceList purchasePricelist) {
        set(PROPERTY_PURCHASEPRICELIST, purchasePricelist);
    }

    public PaymentTerm getPOPaymentTerms() {
        return (PaymentTerm) get(PROPERTY_POPAYMENTTERMS);
    }

    public void setPOPaymentTerms(PaymentTerm pOPaymentTerms) {
        set(PROPERTY_POPAYMENTTERMS, pOPaymentTerms);
    }

    public Long getNumberOfCopies() {
        return (Long) get(PROPERTY_NUMBEROFCOPIES);
    }

    public void setNumberOfCopies(Long numberOfCopies) {
        set(PROPERTY_NUMBEROFCOPIES, numberOfCopies);
    }

    public Greeting getGreeting() {
        return (Greeting) get(PROPERTY_GREETING);
    }

    public void setGreeting(Greeting greeting) {
        set(PROPERTY_GREETING, greeting);
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

    public String getDeliveryMethod() {
        return (String) get(PROPERTY_DELIVERYMETHOD);
    }

    public void setDeliveryMethod(String deliveryMethod) {
        set(PROPERTY_DELIVERYMETHOD, deliveryMethod);
    }

    public BusinessPartner getSalesRepresentative() {
        return (BusinessPartner) get(PROPERTY_SALESREPRESENTATIVE);
    }

    public void setSalesRepresentative(BusinessPartner salesRepresentative) {
        set(PROPERTY_SALESREPRESENTATIVE, salesRepresentative);
    }

    public String getPartnerParent() {
        return (String) get(PROPERTY_PARTNERPARENT);
    }

    public void setPartnerParent(String partnerParent) {
        set(PROPERTY_PARTNERPARENT, partnerParent);
    }

    public String getCreditStatus() {
        return (String) get(PROPERTY_CREDITSTATUS);
    }

    public void setCreditStatus(String creditStatus) {
        set(PROPERTY_CREDITSTATUS, creditStatus);
    }

    public Organization getForcedOrg() {
        return (Organization) get(PROPERTY_FORCEDORG);
    }

    public void setForcedOrg(Organization forcedOrg) {
        set(PROPERTY_FORCEDORG, forcedOrg);
    }

    public Boolean isPricesShownInOrder() {
        return (Boolean) get(PROPERTY_PRICESSHOWNINORDER);
    }

    public void setPricesShownInOrder(Boolean pricesShownInOrder) {
        set(PROPERTY_PRICESSHOWNINORDER, pricesShownInOrder);
    }

    public String getInvoiceGrouping() {
        return (String) get(PROPERTY_INVOICEGROUPING);
    }

    public void setInvoiceGrouping(String invoiceGrouping) {
        set(PROPERTY_INVOICEGROUPING, invoiceGrouping);
    }

    public Long getMaturityDate1() {
        return (Long) get(PROPERTY_MATURITYDATE1);
    }

    public void setMaturityDate1(Long maturityDate1) {
        set(PROPERTY_MATURITYDATE1, maturityDate1);
    }

    public Long getMaturityDate2() {
        return (Long) get(PROPERTY_MATURITYDATE2);
    }

    public void setMaturityDate2(Long maturityDate2) {
        set(PROPERTY_MATURITYDATE2, maturityDate2);
    }

    public Long getMaturityDate3() {
        return (Long) get(PROPERTY_MATURITYDATE3);
    }

    public void setMaturityDate3(Long maturityDate3) {
        set(PROPERTY_MATURITYDATE3, maturityDate3);
    }

    public Boolean isOperator() {
        return (Boolean) get(PROPERTY_OPERATOR);
    }

    public void setOperator(Boolean operator) {
        set(PROPERTY_OPERATOR, operator);
    }

    public String getUPCEAN() {
        return (String) get(PROPERTY_UPCEAN);
    }

    public void setUPCEAN(String uPCEAN) {
        set(PROPERTY_UPCEAN, uPCEAN);
    }

    public SalaryCategory getSalaryCategory() {
        return (SalaryCategory) get(PROPERTY_SALARYCATEGORY);
    }

    public void setSalaryCategory(SalaryCategory salaryCategory) {
        set(PROPERTY_SALARYCATEGORY, salaryCategory);
    }

    public String getInvoicePrintformat() {
        return (String) get(PROPERTY_INVOICEPRINTFORMAT);
    }

    public void setInvoicePrintformat(String invoicePrintformat) {
        set(PROPERTY_INVOICEPRINTFORMAT, invoicePrintformat);
    }

    public Long getConsumptionDays() {
        return (Long) get(PROPERTY_CONSUMPTIONDAYS);
    }

    public void setConsumptionDays(Long consumptionDays) {
        set(PROPERTY_CONSUMPTIONDAYS, consumptionDays);
    }

    public BankAccount getBankAccount() {
        return (BankAccount) get(PROPERTY_BANKACCOUNT);
    }

    public void setBankAccount(BankAccount bankAccount) {
        set(PROPERTY_BANKACCOUNT, bankAccount);
    }

    public TaxCategory getTaxCategory() {
        return (TaxCategory) get(PROPERTY_TAXCATEGORY);
    }

    public void setTaxCategory(TaxCategory taxCategory) {
        set(PROPERTY_TAXCATEGORY, taxCategory);
    }

    public Long getPOMaturityDate1() {
        return (Long) get(PROPERTY_POMATURITYDATE1);
    }

    public void setPOMaturityDate1(Long pOMaturityDate1) {
        set(PROPERTY_POMATURITYDATE1, pOMaturityDate1);
    }

    public Long getPOMaturityDate2() {
        return (Long) get(PROPERTY_POMATURITYDATE2);
    }

    public void setPOMaturityDate2(Long pOMaturityDate2) {
        set(PROPERTY_POMATURITYDATE2, pOMaturityDate2);
    }

    public Long getPOMaturityDate3() {
        return (Long) get(PROPERTY_POMATURITYDATE3);
    }

    public void setPOMaturityDate3(Long pOMaturityDate3) {
        set(PROPERTY_POMATURITYDATE3, pOMaturityDate3);
    }

    public BankAccount getTransactionalBankAccount() {
        return (BankAccount) get(PROPERTY_TRANSACTIONALBANKACCOUNT);
    }

    public void setTransactionalBankAccount(BankAccount transactionalBankAccount) {
        set(PROPERTY_TRANSACTIONALBANKACCOUNT, transactionalBankAccount);
    }

    public TaxCategory getSOBPTaxCategory() {
        return (TaxCategory) get(PROPERTY_SOBPTAXCATEGORY);
    }

    public void setSOBPTaxCategory(TaxCategory sOBPTaxCategory) {
        set(PROPERTY_SOBPTAXCATEGORY, sOBPTaxCategory);
    }

    public String getFiscalcode() {
        return (String) get(PROPERTY_FISCALCODE);
    }

    public void setFiscalcode(String fiscalcode) {
        set(PROPERTY_FISCALCODE, fiscalcode);
    }

    public String getIsofiscalcode() {
        return (String) get(PROPERTY_ISOFISCALCODE);
    }

    public void setIsofiscalcode(String isofiscalcode) {
        set(PROPERTY_ISOFISCALCODE, isofiscalcode);
    }

    public Incoterms getIncotermsPO() {
        return (Incoterms) get(PROPERTY_INCOTERMSPO);
    }

    public void setIncotermsPO(Incoterms incotermsPO) {
        set(PROPERTY_INCOTERMSPO, incotermsPO);
    }

    public Incoterms getIncotermsSO() {
        return (Incoterms) get(PROPERTY_INCOTERMSSO);
    }

    public void setIncotermsSO(Incoterms incotermsSO) {
        set(PROPERTY_INCOTERMSSO, incotermsSO);
    }

    public FIN_PaymentMethod getPaymentMethod() {
        return (FIN_PaymentMethod) get(PROPERTY_PAYMENTMETHOD);
    }

    public void setPaymentMethod(FIN_PaymentMethod paymentMethod) {
        set(PROPERTY_PAYMENTMETHOD, paymentMethod);
    }

    public FIN_PaymentMethod getPOPaymentMethod() {
        return (FIN_PaymentMethod) get(PROPERTY_POPAYMENTMETHOD);
    }

    public void setPOPaymentMethod(FIN_PaymentMethod pOPaymentMethod) {
        set(PROPERTY_POPAYMENTMETHOD, pOPaymentMethod);
    }

    public FIN_FinancialAccount getAccount() {
        return (FIN_FinancialAccount) get(PROPERTY_ACCOUNT);
    }

    public void setAccount(FIN_FinancialAccount account) {
        set(PROPERTY_ACCOUNT, account);
    }

    public FIN_FinancialAccount getPOFinancialAccount() {
        return (FIN_FinancialAccount) get(PROPERTY_POFINANCIALACCOUNT);
    }

    public void setPOFinancialAccount(FIN_FinancialAccount pOFinancialAccount) {
        set(PROPERTY_POFINANCIALACCOUNT, pOFinancialAccount);
    }

    public Boolean isCustomerBlocking() {
        return (Boolean) get(PROPERTY_CUSTOMERBLOCKING);
    }

    public void setCustomerBlocking(Boolean customerBlocking) {
        set(PROPERTY_CUSTOMERBLOCKING, customerBlocking);
    }

    public String getSswhTaxidtype() {
        return (String) get(PROPERTY_SSWHTAXIDTYPE);
    }

    public void setSswhTaxidtype(String sswhTaxidtype) {
        set(PROPERTY_SSWHTAXIDTYPE, sswhTaxidtype);
    }

    public Boolean isVendorBlocking() {
        return (Boolean) get(PROPERTY_VENDORBLOCKING);
    }

    public void setVendorBlocking(Boolean vendorBlocking) {
        set(PROPERTY_VENDORBLOCKING, vendorBlocking);
    }

    public BusinessPartner getSswhSaleadvisor() {
        return (BusinessPartner) get(PROPERTY_SSWHSALEADVISOR);
    }

    public void setSswhSaleadvisor(BusinessPartner sswhSaleadvisor) {
        set(PROPERTY_SSWHSALEADVISOR, sswhSaleadvisor);
    }

    public Boolean isPaymentIn() {
        return (Boolean) get(PROPERTY_PAYMENTIN);
    }

    public void setPaymentIn(Boolean paymentIn) {
        set(PROPERTY_PAYMENTIN, paymentIn);
    }

    public BusinessPartner getSswhCollectingagent() {
        return (BusinessPartner) get(PROPERTY_SSWHCOLLECTINGAGENT);
    }

    public void setSswhCollectingagent(BusinessPartner sswhCollectingagent) {
        set(PROPERTY_SSWHCOLLECTINGAGENT, sswhCollectingagent);
    }

    public Boolean isPaymentOut() {
        return (Boolean) get(PROPERTY_PAYMENTOUT);
    }

    public void setPaymentOut(Boolean paymentOut) {
        set(PROPERTY_PAYMENTOUT, paymentOut);
    }

    public Boolean isSalesInvoice() {
        return (Boolean) get(PROPERTY_SALESINVOICE);
    }

    public void setSalesInvoice(Boolean salesInvoice) {
        set(PROPERTY_SALESINVOICE, salesInvoice);
    }

    public Boolean isPurchaseInvoice() {
        return (Boolean) get(PROPERTY_PURCHASEINVOICE);
    }

    public void setPurchaseInvoice(Boolean purchaseInvoice) {
        set(PROPERTY_PURCHASEINVOICE, purchaseInvoice);
    }

    public Boolean isSalesOrder() {
        return (Boolean) get(PROPERTY_SALESORDER);
    }

    public void setSalesOrder(Boolean salesOrder) {
        set(PROPERTY_SALESORDER, salesOrder);
    }

    public Boolean isPurchaseOrder() {
        return (Boolean) get(PROPERTY_PURCHASEORDER);
    }

    public void setPurchaseOrder(Boolean purchaseOrder) {
        set(PROPERTY_PURCHASEORDER, purchaseOrder);
    }

    public Boolean isGoodsShipment() {
        return (Boolean) get(PROPERTY_GOODSSHIPMENT);
    }

    public void setGoodsShipment(Boolean goodsShipment) {
        set(PROPERTY_GOODSSHIPMENT, goodsShipment);
    }

    public Boolean isGoodsReceipt() {
        return (Boolean) get(PROPERTY_GOODSRECEIPT);
    }

    public void setGoodsReceipt(Boolean goodsReceipt) {
        set(PROPERTY_GOODSRECEIPT, goodsReceipt);
    }

    public Boolean isCashVAT() {
        return (Boolean) get(PROPERTY_CASHVAT);
    }

    public void setCashVAT(Boolean cashVAT) {
        set(PROPERTY_CASHVAT, cashVAT);
    }

    public String getOpcrmBpEmail() {
        return (String) get(PROPERTY_OPCRMBPEMAIL);
    }

    public void setOpcrmBpEmail(String opcrmBpEmail) {
        set(PROPERTY_OPCRMBPEMAIL, opcrmBpEmail);
    }

    public Boolean isEEIEeioice() {
        return (Boolean) get(PROPERTY_EEIEEIOICE);
    }

    public void setEEIEeioice(Boolean eEIEeioice) {
        set(PROPERTY_EEIEEIOICE, eEIEeioice);
    }

    public String getOpcrmBpType() {
        return (String) get(PROPERTY_OPCRMBPTYPE);
    }

    public void setOpcrmBpType(String opcrmBpType) {
        set(PROPERTY_OPCRMBPTYPE, opcrmBpType);
    }

    public Taxpayer getSSWHTaxpayer() {
        return (Taxpayer) get(PROPERTY_SSWHTAXPAYER);
    }

    public void setSSWHTaxpayer(Taxpayer sSWHTaxpayer) {
        set(PROPERTY_SSWHTAXPAYER, sSWHTaxpayer);
    }

    public Boolean isSetNewCurrency() {
        return (Boolean) get(PROPERTY_SETNEWCURRENCY);
    }

    public void setSetNewCurrency(Boolean setNewCurrency) {
        set(PROPERTY_SETNEWCURRENCY, setNewCurrency);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public EEIFormat getEEIFormat() {
        return (EEIFormat) get(PROPERTY_EEIFORMAT);
    }

    public void setEEIFormat(EEIFormat eEIFormat) {
        set(PROPERTY_EEIFORMAT, eEIFormat);
    }

    public String getOpcrmBpIndustry() {
        return (String) get(PROPERTY_OPCRMBPINDUSTRY);
    }

    public void setOpcrmBpIndustry(String opcrmBpIndustry) {
        set(PROPERTY_OPCRMBPINDUSTRY, opcrmBpIndustry);
    }

    public sshrRace getSshrRace() {
        return (sshrRace) get(PROPERTY_SSHRRACE);
    }

    public void setSshrRace(sshrRace sshrRace) {
        set(PROPERTY_SSHRRACE, sshrRace);
    }

    public String getBirthPlace() {
        return (String) get(PROPERTY_BIRTHPLACE);
    }

    public void setBirthPlace(String birthPlace) {
        set(PROPERTY_BIRTHPLACE, birthPlace);
    }

    public EEI_Platform getEEIPlatform() {
        return (EEI_Platform) get(PROPERTY_EEIPLATFORM);
    }

    public void setEEIPlatform(EEI_Platform eEIPlatform) {
        set(PROPERTY_EEIPLATFORM, eEIPlatform);
    }

    public Long getOpcrmBpAnnualRevenue() {
        return (Long) get(PROPERTY_OPCRMBPANNUALREVENUE);
    }

    public void setOpcrmBpAnnualRevenue(Long opcrmBpAnnualRevenue) {
        set(PROPERTY_OPCRMBPANNUALREVENUE, opcrmBpAnnualRevenue);
    }

    public Country getSshrCountry() {
        return (Country) get(PROPERTY_SSHRCOUNTRY);
    }

    public void setSshrCountry(Country sshrCountry) {
        set(PROPERTY_SSHRCOUNTRY, sshrCountry);
    }

    public Date getBirthDay() {
        return (Date) get(PROPERTY_BIRTHDAY);
    }

    public void setBirthDay(Date birthDay) {
        set(PROPERTY_BIRTHDAY, birthDay);
    }

    public String getEEIEmail() {
        return (String) get(PROPERTY_EEIEMAIL);
    }

    public void setEEIEmail(String eEIEmail) {
        set(PROPERTY_EEIEMAIL, eEIEmail);
    }

    public Long getOpcrmBpEmployees() {
        return (Long) get(PROPERTY_OPCRMBPEMPLOYEES);
    }

    public void setOpcrmBpEmployees(Long opcrmBpEmployees) {
        set(PROPERTY_OPCRMBPEMPLOYEES, opcrmBpEmployees);
    }

    public String getSshrGender() {
        return (String) get(PROPERTY_SSHRGENDER);
    }

    public void setSshrGender(String sshrGender) {
        set(PROPERTY_SSHRGENDER, sshrGender);
    }

    public String getEEIDeliverymode() {
        return (String) get(PROPERTY_EEIDELIVERYMODE);
    }

    public void setEEIDeliverymode(String eEIDeliverymode) {
        set(PROPERTY_EEIDELIVERYMODE, eEIDeliverymode);
    }

    public String getOpcrmBpSicCode() {
        return (String) get(PROPERTY_OPCRMBPSICCODE);
    }

    public void setOpcrmBpSicCode(String opcrmBpSicCode) {
        set(PROPERTY_OPCRMBPSICCODE, opcrmBpSicCode);
    }

    public sshrdisability getSshrDisability() {
        return (sshrdisability) get(PROPERTY_SSHRDISABILITY);
    }

    public void setSshrDisability(sshrdisability sshrDisability) {
        set(PROPERTY_SSHRDISABILITY, sshrDisability);
    }

    public String getOpcrmBpTickerSymbol() {
        return (String) get(PROPERTY_OPCRMBPTICKERSYMBOL);
    }

    public void setOpcrmBpTickerSymbol(String opcrmBpTickerSymbol) {
        set(PROPERTY_OPCRMBPTICKERSYMBOL, opcrmBpTickerSymbol);
    }

    public String getSshrLevel() {
        return (String) get(PROPERTY_SSHRLEVEL);
    }

    public void setSshrLevel(String sshrLevel) {
        set(PROPERTY_SSHRLEVEL, sshrLevel);
    }

    public String getOpcrmBpOwnership() {
        return (String) get(PROPERTY_OPCRMBPOWNERSHIP);
    }

    public void setOpcrmBpOwnership(String opcrmBpOwnership) {
        set(PROPERTY_OPCRMBPOWNERSHIP, opcrmBpOwnership);
    }

    public String getSshrNocard() {
        return (String) get(PROPERTY_SSHRNOCARD);
    }

    public void setSshrNocard(String sshrNocard) {
        set(PROPERTY_SSHRNOCARD, sshrNocard);
    }

    public String getSswhName3() {
        return (String) get(PROPERTY_SSWHNAME3);
    }

    public void setSswhName3(String sswhName3) {
        set(PROPERTY_SSWHNAME3, sswhName3);
    }

    public String getOpcrmBpRating() {
        return (String) get(PROPERTY_OPCRMBPRATING);
    }

    public void setOpcrmBpRating(String opcrmBpRating) {
        set(PROPERTY_OPCRMBPRATING, opcrmBpRating);
    }

    public String getSshrAge() {
        return (String) get(PROPERTY_SSHRAGE);
    }

    public void setSshrAge(String sshrAge) {
        set(PROPERTY_SSHRAGE, sshrAge);
    }

    public Campaign getOpcrmBpCCampaign() {
        return (Campaign) get(PROPERTY_OPCRMBPCCAMPAIGN);
    }

    public void setOpcrmBpCCampaign(Campaign opcrmBpCCampaign) {
        set(PROPERTY_OPCRMBPCCAMPAIGN, opcrmBpCCampaign);
    }

    public String getSshrMilitaryno() {
        return (String) get(PROPERTY_SSHRMILITARYNO);
    }

    public void setSshrMilitaryno(String sshrMilitaryno) {
        set(PROPERTY_SSHRMILITARYNO, sshrMilitaryno);
    }

    public User getOpcrmBpAssignedTo() {
        return (User) get(PROPERTY_OPCRMBPASSIGNEDTO);
    }

    public void setOpcrmBpAssignedTo(User opcrmBpAssignedTo) {
        set(PROPERTY_OPCRMBPASSIGNEDTO, opcrmBpAssignedTo);
    }

    public String getSshrEmail() {
        return (String) get(PROPERTY_SSHREMAIL);
    }

    public void setSshrEmail(String sshrEmail) {
        set(PROPERTY_SSHREMAIL, sshrEmail);
    }

    public String getSswhResolutionno() {
        return (String) get(PROPERTY_SSWHRESOLUTIONNO);
    }

    public void setSswhResolutionno(String sswhResolutionno) {
        set(PROPERTY_SSWHRESOLUTIONNO, sswhResolutionno);
    }

    public Boolean isOpcrmBtnCreateopp() {
        return (Boolean) get(PROPERTY_OPCRMBTNCREATEOPP);
    }

    public void setOpcrmBtnCreateopp(Boolean opcrmBtnCreateopp) {
        set(PROPERTY_OPCRMBTNCREATEOPP, opcrmBtnCreateopp);
    }

    public String getSshrTypeblood() {
        return (String) get(PROPERTY_SSHRTYPEBLOOD);
    }

    public void setSshrTypeblood(String sshrTypeblood) {
        set(PROPERTY_SSHRTYPEBLOOD, sshrTypeblood);
    }

    public Boolean isOpcrmBtnCreateact() {
        return (Boolean) get(PROPERTY_OPCRMBTNCREATEACT);
    }

    public void setOpcrmBtnCreateact(Boolean opcrmBtnCreateact) {
        set(PROPERTY_OPCRMBTNCREATEACT, opcrmBtnCreateact);
    }

    public Boolean isSshrDisabilityChk() {
        return (Boolean) get(PROPERTY_SSHRDISABILITYCHK);
    }

    public void setSshrDisabilityChk(Boolean sshrDisabilityChk) {
        set(PROPERTY_SSHRDISABILITYCHK, sshrDisabilityChk);
    }

    public DocumentType getOpcrmDoctype() {
        return (DocumentType) get(PROPERTY_OPCRMDOCTYPE);
    }

    public void setOpcrmDoctype(DocumentType opcrmDoctype) {
        set(PROPERTY_OPCRMDOCTYPE, opcrmDoctype);
    }

    public Boolean isEeiEeioicev() {
        return (Boolean) get(PROPERTY_EEIEEIOICEV);
    }

    public void setEeiEeioicev(Boolean eeiEeioicev) {
        set(PROPERTY_EEIEEIOICEV, eeiEeioicev);
    }

    public Boolean isOpcrmIsposdefault() {
        return (Boolean) get(PROPERTY_OPCRMISPOSDEFAULT);
    }

    public void setOpcrmIsposdefault(Boolean opcrmIsposdefault) {
        set(PROPERTY_OPCRMISPOSDEFAULT, opcrmIsposdefault);
    }

    public String getSSPRStatus() {
        return (String) get(PROPERTY_SSPRSTATUS);
    }

    public void setSSPRStatus(String sSPRStatus) {
        set(PROPERTY_SSPRSTATUS, sSPRStatus);
    }

    public Date getSSPRBirthday() {
        return (Date) get(PROPERTY_SSPRBIRTHDAY);
    }

    public void setSSPRBirthday(Date sSPRBirthday) {
        set(PROPERTY_SSPRBIRTHDAY, sSPRBirthday);
    }

    public String getEeiDeliverymodev() {
        return (String) get(PROPERTY_EEIDELIVERYMODEV);
    }

    public void setEeiDeliverymodev(String eeiDeliverymodev) {
        set(PROPERTY_EEIDELIVERYMODEV, eeiDeliverymodev);
    }

    public Date getSSPREntrydate() {
        return (Date) get(PROPERTY_SSPRENTRYDATE);
    }

    public void setSSPREntrydate(Date sSPREntrydate) {
        set(PROPERTY_SSPRENTRYDATE, sSPREntrydate);
    }

    public String getSSPRDocumenttype() {
        return (String) get(PROPERTY_SSPRDOCUMENTTYPE);
    }

    public void setSSPRDocumenttype(String sSPRDocumenttype) {
        set(PROPERTY_SSPRDOCUMENTTYPE, sSPRDocumenttype);
    }

    public String getSSPRDocumentNo() {
        return (String) get(PROPERTY_SSPRDOCUMENTNO);
    }

    public void setSSPRDocumentNo(String sSPRDocumentNo) {
        set(PROPERTY_SSPRDOCUMENTNO, sSPRDocumentNo);
    }

    public String getSSPRSpecialsituation() {
        return (String) get(PROPERTY_SSPRSPECIALSITUATION);
    }

    public void setSSPRSpecialsituation(String sSPRSpecialsituation) {
        set(PROPERTY_SSPRSPECIALSITUATION, sSPRSpecialsituation);
    }

    public SSWHTermpayment getSswhTermpay() {
        return (SSWHTermpayment) get(PROPERTY_SSWHTERMPAY);
    }

    public void setSswhTermpay(SSWHTermpayment sswhTermpay) {
        set(PROPERTY_SSWHTERMPAY, sswhTermpay);
    }

    public String getSSPRLaborregime() {
        return (String) get(PROPERTY_SSPRLABORREGIME);
    }

    public void setSSPRLaborregime(String sSPRLaborregime) {
        set(PROPERTY_SSPRLABORREGIME, sSPRLaborregime);
    }

    public String getSSPRIncomefrequency() {
        return (String) get(PROPERTY_SSPRINCOMEFREQUENCY);
    }

    public void setSSPRIncomefrequency(String sSPRIncomefrequency) {
        set(PROPERTY_SSPRINCOMEFREQUENCY, sSPRIncomefrequency);
    }

    public String getSSPRTypeofincome() {
        return (String) get(PROPERTY_SSPRTYPEOFINCOME);
    }

    public void setSSPRTypeofincome(String sSPRTypeofincome) {
        set(PROPERTY_SSPRTYPEOFINCOME, sSPRTypeofincome);
    }

    public PAYROLLTEMPLATE getSSPRProlltemplate() {
        return (PAYROLLTEMPLATE) get(PROPERTY_SSPRPROLLTEMPLATE);
    }

    public void setSSPRProlltemplate(PAYROLLTEMPLATE sSPRProlltemplate) {
        set(PROPERTY_SSPRPROLLTEMPLATE, sSPRProlltemplate);
    }

    public PAYROLLTEMPLATE getSSPRProlltemplate2() {
        return (PAYROLLTEMPLATE) get(PROPERTY_SSPRPROLLTEMPLATE2);
    }

    public void setSSPRProlltemplate2(PAYROLLTEMPLATE sSPRProlltemplate2) {
        set(PROPERTY_SSPRPROLLTEMPLATE2, sSPRProlltemplate2);
    }

    public Project getSsprProject() {
        return (Project) get(PROPERTY_SSPRPROJECT);
    }

    public void setSsprProject(Project ssprProject) {
        set(PROPERTY_SSPRPROJECT, ssprProject);
    }

    public City getSsprCity() {
        return (City) get(PROPERTY_SSPRCITY);
    }

    public void setSsprCity(City ssprCity) {
        set(PROPERTY_SSPRCITY, ssprCity);
    }

    public Boolean isSsprReservefundsiess() {
        return (Boolean) get(PROPERTY_SSPRRESERVEFUNDSIESS);
    }

    public void setSsprReservefundsiess(Boolean ssprReservefundsiess) {
        set(PROPERTY_SSPRRESERVEFUNDSIESS, ssprReservefundsiess);
    }

    public Boolean isSsprReservefundscompany() {
        return (Boolean) get(PROPERTY_SSPRRESERVEFUNDSCOMPANY);
    }

    public void setSsprReservefundscompany(Boolean ssprReservefundscompany) {
        set(PROPERTY_SSPRRESERVEFUNDSCOMPANY, ssprReservefundscompany);
    }

    public Concept getSsprConcept() {
        return (Concept) get(PROPERTY_SSPRCONCEPT);
    }

    public void setSsprConcept(Concept ssprConcept) {
        set(PROPERTY_SSPRCONCEPT, ssprConcept);
    }

    public Costcenter getSsprCostcenter() {
        return (Costcenter) get(PROPERTY_SSPRCOSTCENTER);
    }

    public void setSsprCostcenter(Costcenter ssprCostcenter) {
        set(PROPERTY_SSPRCOSTCENTER, ssprCostcenter);
    }

    public UserDimension1 getSsprUser1() {
        return (UserDimension1) get(PROPERTY_SSPRUSER1);
    }

    public void setSsprUser1(UserDimension1 ssprUser1) {
        set(PROPERTY_SSPRUSER1, ssprUser1);
    }

    public UserDimension2 getSsprUser2() {
        return (UserDimension2) get(PROPERTY_SSPRUSER2);
    }

    public void setSsprUser2(UserDimension2 ssprUser2) {
        set(PROPERTY_SSPRUSER2, ssprUser2);
    }

    public Boolean isSsprSeverancefounds() {
        return (Boolean) get(PROPERTY_SSPRSEVERANCEFOUNDS);
    }

    public void setSsprSeverancefounds(Boolean ssprSeverancefounds) {
        set(PROPERTY_SSPRSEVERANCEFOUNDS, ssprSeverancefounds);
    }

    public Boolean isSsprCreatePayroll() {
        return (Boolean) get(PROPERTY_SSPRCREATEPAYROLL);
    }

    public void setSsprCreatePayroll(Boolean ssprCreatePayroll) {
        set(PROPERTY_SSPRCREATEPAYROLL, ssprCreatePayroll);
    }

    public sspr_level_ed getSsprLevelEd() {
        return (sspr_level_ed) get(PROPERTY_SSPRLEVELED);
    }

    public void setSsprLevelEd(sspr_level_ed ssprLevelEd) {
        set(PROPERTY_SSPRLEVELED, ssprLevelEd);
    }

    public Boolean isSSFLRelacionado() {
        return (Boolean) get(PROPERTY_SSFLRELACIONADO);
    }

    public void setSSFLRelacionado(Boolean sSFLRelacionado) {
        set(PROPERTY_SSFLRELACIONADO, sSFLRelacionado);
    }

    public Boolean isSfprIsfpr() {
        return (Boolean) get(PROPERTY_SFPRISFPR);
    }

    public void setSfprIsfpr(Boolean sfprIsfpr) {
        set(PROPERTY_SFPRISFPR, sfprIsfpr);
    }

    public Long getSfprNodays() {
        return (Long) get(PROPERTY_SFPRNODAYS);
    }

    public void setSfprNodays(Long sfprNodays) {
        set(PROPERTY_SFPRNODAYS, sfprNodays);
    }

    public String getSsflAdditional() {
        return (String) get(PROPERTY_SSFLADDITIONAL);
    }

    public void setSsflAdditional(String ssflAdditional) {
        set(PROPERTY_SSFLADDITIONAL, ssflAdditional);
    }

    public sshrDepartment getSshrDepartment() {
        return (sshrDepartment) get(PROPERTY_SSHRDEPARTMENT);
    }

    public void setSshrDepartment(sshrDepartment sshrDepartment) {
        set(PROPERTY_SSHRDEPARTMENT, sshrDepartment);
    }

    public sshrPositionTitle getSshrPositionTitle() {
        return (sshrPositionTitle) get(PROPERTY_SSHRPOSITIONTITLE);
    }

    public void setSshrPositionTitle(sshrPositionTitle sshrPositionTitle) {
        set(PROPERTY_SSHRPOSITIONTITLE, sshrPositionTitle);
    }

    public sshrpositsubtitle getSshrPositSubTitle() {
        return (sshrpositsubtitle) get(PROPERTY_SSHRPOSITSUBTITLE);
    }

    public void setSshrPositSubTitle(sshrpositsubtitle sshrPositSubTitle) {
        set(PROPERTY_SSHRPOSITSUBTITLE, sshrPositSubTitle);
    }

    public Boolean isSsprIsdisabled() {
        return (Boolean) get(PROPERTY_SSPRISDISABLED);
    }

    public void setSsprIsdisabled(Boolean ssprIsdisabled) {
        set(PROPERTY_SSPRISDISABLED, ssprIsdisabled);
    }

    public String getSsprDisability() {
        return (String) get(PROPERTY_SSPRDISABILITY);
    }

    public void setSsprDisability(String ssprDisability) {
        set(PROPERTY_SSPRDISABILITY, ssprDisability);
    }

    public ssprbank getSsprBank() {
        return (ssprbank) get(PROPERTY_SSPRBANK);
    }

    public void setSsprBank(ssprbank ssprBank) {
        set(PROPERTY_SSPRBANK, ssprBank);
    }

    public Long getSsprCompers() {
        return (Long) get(PROPERTY_SSPRCOMPERS);
    }

    public void setSsprCompers(Long ssprCompers) {
        set(PROPERTY_SSPRCOMPERS, ssprCompers);
    }

    public BigDecimal getSsprCurrentsalary() {
        return (BigDecimal) get(PROPERTY_SSPRCURRENTSALARY);
    }

    public void setSsprCurrentsalary(BigDecimal ssprCurrentsalary) {
        set(PROPERTY_SSPRCURRENTSALARY, ssprCurrentsalary);
    }

    public sspr_iessrate getSsprIessrate() {
        return (sspr_iessrate) get(PROPERTY_SSPRIESSRATE);
    }

    public void setSsprIessrate(sspr_iessrate ssprIessrate) {
        set(PROPERTY_SSPRIESSRATE, ssprIessrate);
    }

    public Boolean isSsprIsexecutive() {
        return (Boolean) get(PROPERTY_SSPRISEXECUTIVE);
    }

    public void setSsprIsexecutive(Boolean ssprIsexecutive) {
        set(PROPERTY_SSPRISEXECUTIVE, ssprIsexecutive);
    }

    public Boolean isSsprThirteenth() {
        return (Boolean) get(PROPERTY_SSPRTHIRTEENTH);
    }

    public void setSsprThirteenth(Boolean ssprThirteenth) {
        set(PROPERTY_SSPRTHIRTEENTH, ssprThirteenth);
    }

    public Boolean isSsprFourteenth() {
        return (Boolean) get(PROPERTY_SSPRFOURTEENTH);
    }

    public void setSsprFourteenth(Boolean ssprFourteenth) {
        set(PROPERTY_SSPRFOURTEENTH, ssprFourteenth);
    }

    public Concept getSsprConceptThirteenth() {
        return (Concept) get(PROPERTY_SSPRCONCEPTTHIRTEENTH);
    }

    public void setSsprConceptThirteenth(Concept ssprConceptThirteenth) {
        set(PROPERTY_SSPRCONCEPTTHIRTEENTH, ssprConceptThirteenth);
    }

    public String getSsprCodOcupacIess() {
        return (String) get(PROPERTY_SSPRCODOCUPACIESS);
    }

    public void setSsprCodOcupacIess(String ssprCodOcupacIess) {
        set(PROPERTY_SSPRCODOCUPACIESS, ssprCodOcupacIess);
    }

    public Concept getSsprConceptFourteenth() {
        return (Concept) get(PROPERTY_SSPRCONCEPTFOURTEENTH);
    }

    public void setSsprConceptFourteenth(Concept ssprConceptFourteenth) {
        set(PROPERTY_SSPRCONCEPTFOURTEENTH, ssprConceptFourteenth);
    }

    public String getSsprDescripDisab() {
        return (String) get(PROPERTY_SSPRDESCRIPDISAB);
    }

    public void setSsprDescripDisab(String ssprDescripDisab) {
        set(PROPERTY_SSPRDESCRIPDISAB, ssprDescripDisab);
    }

    public Date getSsprDateDisab() {
        return (Date) get(PROPERTY_SSPRDATEDISAB);
    }

    public void setSsprDateDisab(Date ssprDateDisab) {
        set(PROPERTY_SSPRDATEDISAB, ssprDateDisab);
    }

    public Concept getSsprConceptVac() {
        return (Concept) get(PROPERTY_SSPRCONCEPTVAC);
    }

    public void setSsprConceptVac(Concept ssprConceptVac) {
        set(PROPERTY_SSPRCONCEPTVAC, ssprConceptVac);
    }

    public ssprcategoryacct getSsprCategoryAcct() {
        return (ssprcategoryacct) get(PROPERTY_SSPRCATEGORYACCT);
    }

    public void setSsprCategoryAcct(ssprcategoryacct ssprCategoryAcct) {
        set(PROPERTY_SSPRCATEGORYACCT, ssprCategoryAcct);
    }

    public Boolean isEeiDetailEi() {
        return (Boolean) get(PROPERTY_EEIDETAILEI);
    }

    public void setEeiDetailEi(Boolean eeiDetailEi) {
        set(PROPERTY_EEIDETAILEI, eeiDetailEi);
    }

    public String getSbpcBloodtype() {
        return (String) get(PROPERTY_SBPCBLOODTYPE);
    }

    public void setSbpcBloodtype(String sbpcBloodtype) {
        set(PROPERTY_SBPCBLOODTYPE, sbpcBloodtype);
    }

    public String getSqbNameTaxid() {
        return (String) get(PROPERTY_SQBNAMETAXID);
    }

    public void setSqbNameTaxid(String sqbNameTaxid) {
        set(PROPERTY_SQBNAMETAXID, sqbNameTaxid);
    }

    public Boolean isSsprIspassant() {
        return (Boolean) get(PROPERTY_SSPRISPASSANT);
    }

    public void setSsprIspassant(Boolean ssprIspassant) {
        set(PROPERTY_SSPRISPASSANT, ssprIspassant);
    }

    public BigDecimal getSsprFortnight() {
        return (BigDecimal) get(PROPERTY_SSPRFORTNIGHT);
    }

    public void setSsprFortnight(BigDecimal ssprFortnight) {
        set(PROPERTY_SSPRFORTNIGHT, ssprFortnight);
    }

    public String getSbpcLicenseType() {
        return (String) get(PROPERTY_SBPCLICENSETYPE);
    }

    public void setSbpcLicenseType(String sbpcLicenseType) {
        set(PROPERTY_SBPCLICENSETYPE, sbpcLicenseType);
    }

    public BigDecimal getSsprComplyBonos() {
        return (BigDecimal) get(PROPERTY_SSPRCOMPLYBONOS);
    }

    public void setSsprComplyBonos(BigDecimal ssprComplyBonos) {
        set(PROPERTY_SSPRCOMPLYBONOS, ssprComplyBonos);
    }

    public String getEeiPortalPass() {
        return (String) get(PROPERTY_EEIPORTALPASS);
    }

    public void setEeiPortalPass(String eeiPortalPass) {
        set(PROPERTY_EEIPORTALPASS, eeiPortalPass);
    }

    public BigDecimal getSsprMobilization() {
        return (BigDecimal) get(PROPERTY_SSPRMOBILIZATION);
    }

    public void setSsprMobilization(BigDecimal ssprMobilization) {
        set(PROPERTY_SSPRMOBILIZATION, ssprMobilization);
    }

    public Boolean isSsprExtraHours() {
        return (Boolean) get(PROPERTY_SSPREXTRAHOURS);
    }

    public void setSsprExtraHours(Boolean ssprExtraHours) {
        set(PROPERTY_SSPREXTRAHOURS, ssprExtraHours);
    }

    public String getSbpcCivilStatus() {
        return (String) get(PROPERTY_SBPCCIVILSTATUS);
    }

    public void setSbpcCivilStatus(String sbpcCivilStatus) {
        set(PROPERTY_SBPCCIVILSTATUS, sbpcCivilStatus);
    }

    public Boolean isSsprBonusPunctual() {
        return (Boolean) get(PROPERTY_SSPRBONUSPUNCTUAL);
    }

    public void setSsprBonusPunctual(Boolean ssprBonusPunctual) {
        set(PROPERTY_SSPRBONUSPUNCTUAL, ssprBonusPunctual);
    }

    public String getSsprEmail() {
        return (String) get(PROPERTY_SSPREMAIL);
    }

    public void setSsprEmail(String ssprEmail) {
        set(PROPERTY_SSPREMAIL, ssprEmail);
    }

    public String getSsprLastname() {
        return (String) get(PROPERTY_SSPRLASTNAME);
    }

    public void setSsprLastname(String ssprLastname) {
        set(PROPERTY_SSPRLASTNAME, ssprLastname);
    }

    public String getSsprFirstname() {
        return (String) get(PROPERTY_SSPRFIRSTNAME);
    }

    public void setSsprFirstname(String ssprFirstname) {
        set(PROPERTY_SSPRFIRSTNAME, ssprFirstname);
    }

    public Boolean isSsprRepresentsdisabled() {
        return (Boolean) get(PROPERTY_SSPRREPRESENTSDISABLED);
    }

    public void setSsprRepresentsdisabled(Boolean ssprRepresentsdisabled) {
        set(PROPERTY_SSPRREPRESENTSDISABLED, ssprRepresentsdisabled);
    }

    public BusinessPartner getSsprBpartnerDisabled() {
        return (BusinessPartner) get(PROPERTY_SSPRBPARTNERDISABLED);
    }

    public void setSsprBpartnerDisabled(BusinessPartner ssprBpartnerDisabled) {
        set(PROPERTY_SSPRBPARTNERDISABLED, ssprBpartnerDisabled);
    }

    public ssprestablishmentcode getSsprEstablishmentcode() {
        return (ssprestablishmentcode) get(PROPERTY_SSPRESTABLISHMENTCODE);
    }

    public void setSsprEstablishmentcode(ssprestablishmentcode ssprEstablishmentcode) {
        set(PROPERTY_SSPRESTABLISHMENTCODE, ssprEstablishmentcode);
    }

    public SFBBudgetArea getSsbpSfbBudgetArea() {
        return (SFBBudgetArea) get(PROPERTY_SSBPSFBBUDGETAREA);
    }

    public void setSsbpSfbBudgetArea(SFBBudgetArea ssbpSfbBudgetArea) {
        set(PROPERTY_SSBPSFBBUDGETAREA, ssbpSfbBudgetArea);
    }

    public String getSbpcClientType() {
        return (String) get(PROPERTY_SBPCCLIENTTYPE);
    }

    public void setSbpcClientType(String sbpcClientType) {
        set(PROPERTY_SBPCCLIENTTYPE, sbpcClientType);
    }

    public Boolean isSSFLIsCharterer() {
        return (Boolean) get(PROPERTY_SSFLISCHARTERER);
    }

    public void setSSFLIsCharterer(Boolean sSFLIsCharterer) {
        set(PROPERTY_SSFLISCHARTERER, sSFLIsCharterer);
    }

    public String getSswhCodetaxpayer() {
        return (String) get(PROPERTY_SSWHCODETAXPAYER);
    }

    public void setSswhCodetaxpayer(String sswhCodetaxpayer) {
        set(PROPERTY_SSWHCODETAXPAYER, sswhCodetaxpayer);
    }

    public String getSbpcAge() {
        return (String) get(PROPERTY_SBPCAGE);
    }

    public void setSbpcAge(String sbpcAge) {
        set(PROPERTY_SBPCAGE, sbpcAge);
    }

    public Date getSbpcDatebirth() {
        return (Date) get(PROPERTY_SBPCDATEBIRTH);
    }

    public void setSbpcDatebirth(Date sbpcDatebirth) {
        set(PROPERTY_SBPCDATEBIRTH, sbpcDatebirth);
    }

    public Date getSbpcDateentry() {
        return (Date) get(PROPERTY_SBPCDATEENTRY);
    }

    public void setSbpcDateentry(Date sbpcDateentry) {
        set(PROPERTY_SBPCDATEENTRY, sbpcDateentry);
    }

    public Date getSbpcDateexit() {
        return (Date) get(PROPERTY_SBPCDATEEXIT);
    }

    public void setSbpcDateexit(Date sbpcDateexit) {
        set(PROPERTY_SBPCDATEEXIT, sbpcDateexit);
    }

    public sbpceducation getSbpcEducation() {
        return (sbpceducation) get(PROPERTY_SBPCEDUCATION);
    }

    public void setSbpcEducation(sbpceducation sbpcEducation) {
        set(PROPERTY_SBPCEDUCATION, sbpcEducation);
    }

    public String getSbpcGender() {
        return (String) get(PROPERTY_SBPCGENDER);
    }

    public void setSbpcGender(String sbpcGender) {
        set(PROPERTY_SBPCGENDER, sbpcGender);
    }

    public Boolean isSsfiForeign() {
        return (Boolean) get(PROPERTY_SSFIFOREIGN);
    }

    public void setSsfiForeign(Boolean ssfiForeign) {
        set(PROPERTY_SSFIFOREIGN, ssfiForeign);
    }

    public Boolean isSsflIsowner() {
        return (Boolean) get(PROPERTY_SSFLISOWNER);
    }

    public void setSsflIsowner(Boolean ssflIsowner) {
        set(PROPERTY_SSFLISOWNER, ssflIsowner);
    }

    @SuppressWarnings("unchecked")
    public List<User> getADUserList() {
      return (List<User>) get(PROPERTY_ADUSERLIST);
    }

    public void setADUserList(List<User> aDUserList) {
        set(PROPERTY_ADUSERLIST, aDUserList);
    }

    @SuppressWarnings("unchecked")
    public List<User> getADUserEMOPCRMReportsToList() {
      return (List<User>) get(PROPERTY_ADUSEREMOPCRMREPORTSTOLIST);
    }

    public void setADUserEMOPCRMReportsToList(List<User> aDUserEMOPCRMReportsToList) {
        set(PROPERTY_ADUSEREMOPCRMREPORTSTOLIST, aDUserEMOPCRMReportsToList);
    }

    @SuppressWarnings("unchecked")
    public List<FinAccTransactionAccounting> getAPRMFinAccTransactionAcctVList() {
      return (List<FinAccTransactionAccounting>) get(PROPERTY_APRMFINACCTRANSACTIONACCTVLIST);
    }

    public void setAPRMFinAccTransactionAcctVList(List<FinAccTransactionAccounting> aPRMFinAccTransactionAcctVList) {
        set(PROPERTY_APRMFINACCTRANSACTIONACCTVLIST, aPRMFinAccTransactionAcctVList);
    }

    @SuppressWarnings("unchecked")
    public List<APRM_FinaccTransactionV> getAPRMFinaccTransactionVList() {
      return (List<APRM_FinaccTransactionV>) get(PROPERTY_APRMFINACCTRANSACTIONVLIST);
    }

    public void setAPRMFinaccTransactionVList(List<APRM_FinaccTransactionV> aPRMFinaccTransactionVList) {
        set(PROPERTY_APRMFINACCTRANSACTIONVLIST, aPRMFinaccTransactionVList);
    }

    @SuppressWarnings("unchecked")
    public List<APRM_Finacc_Trx_Full_Acct_V> getAPRMFinaccTrxFullAcctVList() {
      return (List<APRM_Finacc_Trx_Full_Acct_V>) get(PROPERTY_APRMFINACCTRXFULLACCTVLIST);
    }

    public void setAPRMFinaccTrxFullAcctVList(List<APRM_Finacc_Trx_Full_Acct_V> aPRMFinaccTrxFullAcctVList) {
        set(PROPERTY_APRMFINACCTRXFULLACCTVLIST, aPRMFinaccTrxFullAcctVList);
    }

    @SuppressWarnings("unchecked")
    public List<APRM_PaymentProposalPickEdit> getAPRMPaymentProposalPickEditList() {
      return (List<APRM_PaymentProposalPickEdit>) get(PROPERTY_APRMPAYMENTPROPOSALPICKEDITLIST);
    }

    public void setAPRMPaymentProposalPickEditList(List<APRM_PaymentProposalPickEdit> aPRMPaymentProposalPickEditList) {
        set(PROPERTY_APRMPAYMENTPROPOSALPICKEDITLIST, aPRMPaymentProposalPickEditList);
    }

    @SuppressWarnings("unchecked")
    public List<ActiveProposal> getActiveProposalVList() {
      return (List<ActiveProposal>) get(PROPERTY_ACTIVEPROPOSALVLIST);
    }

    public void setActiveProposalVList(List<ActiveProposal> activeProposalVList) {
        set(PROPERTY_ACTIVEPROPOSALVLIST, activeProposalVList);
    }

    @SuppressWarnings("unchecked")
    public List<AmortizationLineAccountingDimension> getAmortizationLineAccountingDimensionList() {
      return (List<AmortizationLineAccountingDimension>) get(PROPERTY_AMORTIZATIONLINEACCOUNTINGDIMENSIONLIST);
    }

    public void setAmortizationLineAccountingDimensionList(List<AmortizationLineAccountingDimension> amortizationLineAccountingDimensionList) {
        set(PROPERTY_AMORTIZATIONLINEACCOUNTINGDIMENSIONLIST, amortizationLineAccountingDimensionList);
    }

    @SuppressWarnings("unchecked")
    public List<ApprovedVendor> getApprovedVendorList() {
      return (List<ApprovedVendor>) get(PROPERTY_APPROVEDVENDORLIST);
    }

    public void setApprovedVendorList(List<ApprovedVendor> approvedVendorList) {
        set(PROPERTY_APPROVEDVENDORLIST, approvedVendorList);
    }

    @SuppressWarnings("unchecked")
    public List<Bank> getBankList() {
      return (List<Bank>) get(PROPERTY_BANKLIST);
    }

    public void setBankList(List<Bank> bankList) {
        set(PROPERTY_BANKLIST, bankList);
    }

    @SuppressWarnings("unchecked")
    public List<BusinessPartner> getBusinessPartnerSalesRepresentativeList() {
      return (List<BusinessPartner>) get(PROPERTY_BUSINESSPARTNERSALESREPRESENTATIVELIST);
    }

    public void setBusinessPartnerSalesRepresentativeList(List<BusinessPartner> businessPartnerSalesRepresentativeList) {
        set(PROPERTY_BUSINESSPARTNERSALESREPRESENTATIVELIST, businessPartnerSalesRepresentativeList);
    }

    @SuppressWarnings("unchecked")
    public List<BusinessPartner> getBusinessPartnerEMSswhSaleadvisorList() {
      return (List<BusinessPartner>) get(PROPERTY_BUSINESSPARTNEREMSSWHSALEADVISORLIST);
    }

    public void setBusinessPartnerEMSswhSaleadvisorList(List<BusinessPartner> businessPartnerEMSswhSaleadvisorList) {
        set(PROPERTY_BUSINESSPARTNEREMSSWHSALEADVISORLIST, businessPartnerEMSswhSaleadvisorList);
    }

    @SuppressWarnings("unchecked")
    public List<BusinessPartner> getBusinessPartnerEMSswhCollectingagentList() {
      return (List<BusinessPartner>) get(PROPERTY_BUSINESSPARTNEREMSSWHCOLLECTINGAGENTLIST);
    }

    public void setBusinessPartnerEMSswhCollectingagentList(List<BusinessPartner> businessPartnerEMSswhCollectingagentList) {
        set(PROPERTY_BUSINESSPARTNEREMSSWHCOLLECTINGAGENTLIST, businessPartnerEMSswhCollectingagentList);
    }

    @SuppressWarnings("unchecked")
    public List<BusinessPartner> getBusinessPartnerEMSsprBpartnerDisabledIDList() {
      return (List<BusinessPartner>) get(PROPERTY_BUSINESSPARTNEREMSSPRBPARTNERDISABLEDIDLIST);
    }

    public void setBusinessPartnerEMSsprBpartnerDisabledIDList(List<BusinessPartner> businessPartnerEMSsprBpartnerDisabledIDList) {
        set(PROPERTY_BUSINESSPARTNEREMSSPRBPARTNERDISABLEDIDLIST, businessPartnerEMSsprBpartnerDisabledIDList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.model.common.businesspartner.BankAccount> getBusinessPartnerBankAccountList() {
      return (List<org.openbravo.model.common.businesspartner.BankAccount>) get(PROPERTY_BUSINESSPARTNERBANKACCOUNTLIST);
    }

    public void setBusinessPartnerBankAccountList(List<org.openbravo.model.common.businesspartner.BankAccount> businessPartnerBankAccountList) {
        set(PROPERTY_BUSINESSPARTNERBANKACCOUNTLIST, businessPartnerBankAccountList);
    }

    @SuppressWarnings("unchecked")
    public List<Discount> getBusinessPartnerDiscountList() {
      return (List<Discount>) get(PROPERTY_BUSINESSPARTNERDISCOUNTLIST);
    }

    public void setBusinessPartnerDiscountList(List<Discount> businessPartnerDiscountList) {
        set(PROPERTY_BUSINESSPARTNERDISCOUNTLIST, businessPartnerDiscountList);
    }

    @SuppressWarnings("unchecked")
    public List<Location> getBusinessPartnerLocationList() {
      return (List<Location>) get(PROPERTY_BUSINESSPARTNERLOCATIONLIST);
    }

    public void setBusinessPartnerLocationList(List<Location> businessPartnerLocationList) {
        set(PROPERTY_BUSINESSPARTNERLOCATIONLIST, businessPartnerLocationList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductTemplate> getBusinessPartnerProductTemplateList() {
      return (List<ProductTemplate>) get(PROPERTY_BUSINESSPARTNERPRODUCTTEMPLATELIST);
    }

    public void setBusinessPartnerProductTemplateList(List<ProductTemplate> businessPartnerProductTemplateList) {
        set(PROPERTY_BUSINESSPARTNERPRODUCTTEMPLATELIST, businessPartnerProductTemplateList);
    }

    @SuppressWarnings("unchecked")
    public List<Withholding> getBusinessPartnerWithholdingList() {
      return (List<Withholding>) get(PROPERTY_BUSINESSPARTNERWITHHOLDINGLIST);
    }

    public void setBusinessPartnerWithholdingList(List<Withholding> businessPartnerWithholdingList) {
        set(PROPERTY_BUSINESSPARTNERWITHHOLDINGLIST, businessPartnerWithholdingList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceTaxCashVAT_V> getInvoiceTaxCashVATVList() {
      return (List<InvoiceTaxCashVAT_V>) get(PROPERTY_INVOICETAXCASHVATVLIST);
    }

    public void setInvoiceTaxCashVATVList(List<InvoiceTaxCashVAT_V> invoiceTaxCashVATVList) {
        set(PROPERTY_INVOICETAXCASHVATVLIST, invoiceTaxCashVATVList);
    }

    @SuppressWarnings("unchecked")
    public List<ClientInformation> getClientInformationTemplateBPartnerList() {
      return (List<ClientInformation>) get(PROPERTY_CLIENTINFORMATIONTEMPLATEBPARTNERLIST);
    }

    public void setClientInformationTemplateBPartnerList(List<ClientInformation> clientInformationTemplateBPartnerList) {
        set(PROPERTY_CLIENTINFORMATIONTEMPLATEBPARTNERLIST, clientInformationTemplateBPartnerList);
    }

    @SuppressWarnings("unchecked")
    public List<ClientInformation> getClientInformationEMSsprCBpartnerIDList() {
      return (List<ClientInformation>) get(PROPERTY_CLIENTINFORMATIONEMSSPRCBPARTNERIDLIST);
    }

    public void setClientInformationEMSsprCBpartnerIDList(List<ClientInformation> clientInformationEMSsprCBpartnerIDList) {
        set(PROPERTY_CLIENTINFORMATIONEMSSPRCBPARTNERIDLIST, clientInformationEMSsprCBpartnerIDList);
    }

    @SuppressWarnings("unchecked")
    public List<CustomerAccounts> getCustomerAccountsList() {
      return (List<CustomerAccounts>) get(PROPERTY_CUSTOMERACCOUNTSLIST);
    }

    public void setCustomerAccountsList(List<CustomerAccounts> customerAccountsList) {
        set(PROPERTY_CUSTOMERACCOUNTSLIST, customerAccountsList);
    }

    @SuppressWarnings("unchecked")
    public List<EmailInteraction> getEmailInteractionList() {
      return (List<EmailInteraction>) get(PROPERTY_EMAILINTERACTIONLIST);
    }

    public void setEmailInteractionList(List<EmailInteraction> emailInteractionList) {
        set(PROPERTY_EMAILINTERACTIONLIST, emailInteractionList);
    }

    @SuppressWarnings("unchecked")
    public List<EmployeeAccounts> getEmployeeAccountsList() {
      return (List<EmployeeAccounts>) get(PROPERTY_EMPLOYEEACCOUNTSLIST);
    }

    public void setEmployeeAccountsList(List<EmployeeAccounts> employeeAccountsList) {
        set(PROPERTY_EMPLOYEEACCOUNTSLIST, employeeAccountsList);
    }

    @SuppressWarnings("unchecked")
    public List<EmployeeSalaryCategory> getEmployeeSalaryCategoryList() {
      return (List<EmployeeSalaryCategory>) get(PROPERTY_EMPLOYEESALARYCATEGORYLIST);
    }

    public void setEmployeeSalaryCategoryList(List<EmployeeSalaryCategory> employeeSalaryCategoryList) {
        set(PROPERTY_EMPLOYEESALARYCATEGORYLIST, employeeSalaryCategoryList);
    }

    @SuppressWarnings("unchecked")
    public List<ExternalPOS> getExternalPOSList() {
      return (List<ExternalPOS>) get(PROPERTY_EXTERNALPOSLIST);
    }

    public void setExternalPOSList(List<ExternalPOS> externalPOSList) {
        set(PROPERTY_EXTERNALPOSLIST, externalPOSList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_BankStatementLine> getFINBankStatementLineList() {
      return (List<FIN_BankStatementLine>) get(PROPERTY_FINBANKSTATEMENTLINELIST);
    }

    public void setFINBankStatementLineList(List<FIN_BankStatementLine> fINBankStatementLineList) {
        set(PROPERTY_FINBANKSTATEMENTLINELIST, fINBankStatementLineList);
    }

    @SuppressWarnings("unchecked")
    public List<DoubtfulDebt> getFINDoubtfulDebtList() {
      return (List<DoubtfulDebt>) get(PROPERTY_FINDOUBTFULDEBTLIST);
    }

    public void setFINDoubtfulDebtList(List<DoubtfulDebt> fINDoubtfulDebtList) {
        set(PROPERTY_FINDOUBTFULDEBTLIST, fINDoubtfulDebtList);
    }

    @SuppressWarnings("unchecked")
    public List<DoubtfulDebtRun> getFINDoubtfulDebtRunList() {
      return (List<DoubtfulDebtRun>) get(PROPERTY_FINDOUBTFULDEBTRUNLIST);
    }

    public void setFINDoubtfulDebtRunList(List<DoubtfulDebtRun> fINDoubtfulDebtRunList) {
        set(PROPERTY_FINDOUBTFULDEBTRUNLIST, fINDoubtfulDebtRunList);
    }

    @SuppressWarnings("unchecked")
    public List<DoubtfulDebtV> getFINDoubtfulDebtVList() {
      return (List<DoubtfulDebtV>) get(PROPERTY_FINDOUBTFULDEBTVLIST);
    }

    public void setFINDoubtfulDebtVList(List<DoubtfulDebtV> fINDoubtfulDebtVList) {
        set(PROPERTY_FINDOUBTFULDEBTVLIST, fINDoubtfulDebtVList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_FinaccTransaction> getFINFinaccTransactionList() {
      return (List<FIN_FinaccTransaction>) get(PROPERTY_FINFINACCTRANSACTIONLIST);
    }

    public void setFINFinaccTransactionList(List<FIN_FinaccTransaction> fINFinaccTransactionList) {
        set(PROPERTY_FINFINACCTRANSACTIONLIST, fINFinaccTransactionList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_FinancialAccount> getFINFinancialAccountList() {
      return (List<FIN_FinancialAccount>) get(PROPERTY_FINFINANCIALACCOUNTLIST);
    }

    public void setFINFinancialAccountList(List<FIN_FinancialAccount> fINFinancialAccountList) {
        set(PROPERTY_FINFINANCIALACCOUNTLIST, fINFinancialAccountList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_Payment> getFINPaymentList() {
      return (List<FIN_Payment>) get(PROPERTY_FINPAYMENTLIST);
    }

    public void setFINPaymentList(List<FIN_Payment> fINPaymentList) {
        set(PROPERTY_FINPAYMENTLIST, fINPaymentList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_Payment> getFINPaymentEMSspacCBpartnerIDList() {
      return (List<FIN_Payment>) get(PROPERTY_FINPAYMENTEMSSPACCBPARTNERIDLIST);
    }

    public void setFINPaymentEMSspacCBpartnerIDList(List<FIN_Payment> fINPaymentEMSspacCBpartnerIDList) {
        set(PROPERTY_FINPAYMENTEMSSPACCBPARTNERIDLIST, fINPaymentEMSspacCBpartnerIDList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_PaymentDetailV> getFINPaymentDetailVList() {
      return (List<FIN_PaymentDetailV>) get(PROPERTY_FINPAYMENTDETAILVLIST);
    }

    public void setFINPaymentDetailVList(List<FIN_PaymentDetailV> fINPaymentDetailVList) {
        set(PROPERTY_FINPAYMENTDETAILVLIST, fINPaymentDetailVList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_PaymentDetailV> getFINPaymentDetailVBusinessPartnerdimList() {
      return (List<FIN_PaymentDetailV>) get(PROPERTY_FINPAYMENTDETAILVBUSINESSPARTNERDIMLIST);
    }

    public void setFINPaymentDetailVBusinessPartnerdimList(List<FIN_PaymentDetailV> fINPaymentDetailVBusinessPartnerdimList) {
        set(PROPERTY_FINPAYMENTDETAILVBUSINESSPARTNERDIMLIST, fINPaymentDetailVBusinessPartnerdimList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_PaymentPropDetailV> getFINPaymentPropDetailVList() {
      return (List<FIN_PaymentPropDetailV>) get(PROPERTY_FINPAYMENTPROPDETAILVLIST);
    }

    public void setFINPaymentPropDetailVList(List<FIN_PaymentPropDetailV> fINPaymentPropDetailVList) {
        set(PROPERTY_FINPAYMENTPROPDETAILVLIST, fINPaymentPropDetailVList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_PaymentProposal> getFINPaymentProposalList() {
      return (List<FIN_PaymentProposal>) get(PROPERTY_FINPAYMENTPROPOSALLIST);
    }

    public void setFINPaymentProposalList(List<FIN_PaymentProposal> fINPaymentProposalList) {
        set(PROPERTY_FINPAYMENTPROPOSALLIST, fINPaymentProposalList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_PaymentScheduleDetail> getFINPaymentScheduleDetailList() {
      return (List<FIN_PaymentScheduleDetail>) get(PROPERTY_FINPAYMENTSCHEDULEDETAILLIST);
    }

    public void setFINPaymentScheduleDetailList(List<FIN_PaymentScheduleDetail> fINPaymentScheduleDetailList) {
        set(PROPERTY_FINPAYMENTSCHEDULEDETAILLIST, fINPaymentScheduleDetailList);
    }

    @SuppressWarnings("unchecked")
    public List<AccountingCombination> getFinancialMgmtAccountingCombinationList() {
      return (List<AccountingCombination>) get(PROPERTY_FINANCIALMGMTACCOUNTINGCOMBINATIONLIST);
    }

    public void setFinancialMgmtAccountingCombinationList(List<AccountingCombination> financialMgmtAccountingCombinationList) {
        set(PROPERTY_FINANCIALMGMTACCOUNTINGCOMBINATIONLIST, financialMgmtAccountingCombinationList);
    }

    @SuppressWarnings("unchecked")
    public List<AccountingFact> getFinancialMgmtAccountingFactList() {
      return (List<AccountingFact>) get(PROPERTY_FINANCIALMGMTACCOUNTINGFACTLIST);
    }

    public void setFinancialMgmtAccountingFactList(List<AccountingFact> financialMgmtAccountingFactList) {
        set(PROPERTY_FINANCIALMGMTACCOUNTINGFACTLIST, financialMgmtAccountingFactList);
    }

    @SuppressWarnings("unchecked")
    public List<AcctSchemaElement> getFinancialMgmtAcctSchemaElementList() {
      return (List<AcctSchemaElement>) get(PROPERTY_FINANCIALMGMTACCTSCHEMAELEMENTLIST);
    }

    public void setFinancialMgmtAcctSchemaElementList(List<AcctSchemaElement> financialMgmtAcctSchemaElementList) {
        set(PROPERTY_FINANCIALMGMTACCTSCHEMAELEMENTLIST, financialMgmtAcctSchemaElementList);
    }

    @SuppressWarnings("unchecked")
    public List<Asset> getFinancialMgmtAssetList() {
      return (List<Asset>) get(PROPERTY_FINANCIALMGMTASSETLIST);
    }

    public void setFinancialMgmtAssetList(List<Asset> financialMgmtAssetList) {
        set(PROPERTY_FINANCIALMGMTASSETLIST, financialMgmtAssetList);
    }

    @SuppressWarnings("unchecked")
    public List<Asset> getFinancialMgmtAssetEMSsalCustodioIDList() {
      return (List<Asset>) get(PROPERTY_FINANCIALMGMTASSETEMSSALCUSTODIOIDLIST);
    }

    public void setFinancialMgmtAssetEMSsalCustodioIDList(List<Asset> financialMgmtAssetEMSsalCustodioIDList) {
        set(PROPERTY_FINANCIALMGMTASSETEMSSALCUSTODIOIDLIST, financialMgmtAssetEMSsalCustodioIDList);
    }

    @SuppressWarnings("unchecked")
    public List<BankStatement> getFinancialMgmtBankStatementEMSSWHBusinessPartnerList() {
      return (List<BankStatement>) get(PROPERTY_FINANCIALMGMTBANKSTATEMENTEMSSWHBUSINESSPARTNERLIST);
    }

    public void setFinancialMgmtBankStatementEMSSWHBusinessPartnerList(List<BankStatement> financialMgmtBankStatementEMSSWHBusinessPartnerList) {
        set(PROPERTY_FINANCIALMGMTBANKSTATEMENTEMSSWHBUSINESSPARTNERLIST, financialMgmtBankStatementEMSSWHBusinessPartnerList);
    }

    @SuppressWarnings("unchecked")
    public List<BankStatementLine> getFinancialMgmtBankStatementLineEMSswhPartnerIDList() {
      return (List<BankStatementLine>) get(PROPERTY_FINANCIALMGMTBANKSTATEMENTLINEEMSSWHPARTNERIDLIST);
    }

    public void setFinancialMgmtBankStatementLineEMSswhPartnerIDList(List<BankStatementLine> financialMgmtBankStatementLineEMSswhPartnerIDList) {
        set(PROPERTY_FINANCIALMGMTBANKSTATEMENTLINEEMSSWHPARTNERIDLIST, financialMgmtBankStatementLineEMSswhPartnerIDList);
    }

    @SuppressWarnings("unchecked")
    public List<BudgetLine> getFinancialMgmtBudgetLineList() {
      return (List<BudgetLine>) get(PROPERTY_FINANCIALMGMTBUDGETLINELIST);
    }

    public void setFinancialMgmtBudgetLineList(List<BudgetLine> financialMgmtBudgetLineList) {
        set(PROPERTY_FINANCIALMGMTBUDGETLINELIST, financialMgmtBudgetLineList);
    }

    @SuppressWarnings("unchecked")
    public List<DebtPayment> getFinancialMgmtDebtPaymentList() {
      return (List<DebtPayment>) get(PROPERTY_FINANCIALMGMTDEBTPAYMENTLIST);
    }

    public void setFinancialMgmtDebtPaymentList(List<DebtPayment> financialMgmtDebtPaymentList) {
        set(PROPERTY_FINANCIALMGMTDEBTPAYMENTLIST, financialMgmtDebtPaymentList);
    }

    @SuppressWarnings("unchecked")
    public List<DebtPaymentCancelV> getFinancialMgmtDebtPaymentCancelVList() {
      return (List<DebtPaymentCancelV>) get(PROPERTY_FINANCIALMGMTDEBTPAYMENTCANCELVLIST);
    }

    public void setFinancialMgmtDebtPaymentCancelVList(List<DebtPaymentCancelV> financialMgmtDebtPaymentCancelVList) {
        set(PROPERTY_FINANCIALMGMTDEBTPAYMENTCANCELVLIST, financialMgmtDebtPaymentCancelVList);
    }

    @SuppressWarnings("unchecked")
    public List<DebtPaymentGenerateV> getFinancialMgmtDebtPaymentGenerateVList() {
      return (List<DebtPaymentGenerateV>) get(PROPERTY_FINANCIALMGMTDEBTPAYMENTGENERATEVLIST);
    }

    public void setFinancialMgmtDebtPaymentGenerateVList(List<DebtPaymentGenerateV> financialMgmtDebtPaymentGenerateVList) {
        set(PROPERTY_FINANCIALMGMTDEBTPAYMENTGENERATEVLIST, financialMgmtDebtPaymentGenerateVList);
    }

    @SuppressWarnings("unchecked")
    public List<GLJournal> getFinancialMgmtGLJournalList() {
      return (List<GLJournal>) get(PROPERTY_FINANCIALMGMTGLJOURNALLIST);
    }

    public void setFinancialMgmtGLJournalList(List<GLJournal> financialMgmtGLJournalList) {
        set(PROPERTY_FINANCIALMGMTGLJOURNALLIST, financialMgmtGLJournalList);
    }

    @SuppressWarnings("unchecked")
    public List<GLJournalLine> getFinancialMgmtGLJournalLineList() {
      return (List<GLJournalLine>) get(PROPERTY_FINANCIALMGMTGLJOURNALLINELIST);
    }

    public void setFinancialMgmtGLJournalLineList(List<GLJournalLine> financialMgmtGLJournalLineList) {
        set(PROPERTY_FINANCIALMGMTGLJOURNALLINELIST, financialMgmtGLJournalLineList);
    }

    @SuppressWarnings("unchecked")
    public List<TaxPayment> getFinancialMgmtTaxPaymentList() {
      return (List<TaxPayment>) get(PROPERTY_FINANCIALMGMTTAXPAYMENTLIST);
    }

    public void setFinancialMgmtTaxPaymentList(List<TaxPayment> financialMgmtTaxPaymentList) {
        set(PROPERTY_FINANCIALMGMTTAXPAYMENTLIST, financialMgmtTaxPaymentList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.model.financialmgmt.tax.Withholding> getFinancialMgmtWithholdingBeneficiaryList() {
      return (List<org.openbravo.model.financialmgmt.tax.Withholding>) get(PROPERTY_FINANCIALMGMTWITHHOLDINGBENEFICIARYLIST);
    }

    public void setFinancialMgmtWithholdingBeneficiaryList(List<org.openbravo.model.financialmgmt.tax.Withholding> financialMgmtWithholdingBeneficiaryList) {
        set(PROPERTY_FINANCIALMGMTWITHHOLDINGBENEFICIARYLIST, financialMgmtWithholdingBeneficiaryList);
    }

    @SuppressWarnings("unchecked")
    public List<InOutLineAccountingDimension> getInOutLineAccountingDimensionList() {
      return (List<InOutLineAccountingDimension>) get(PROPERTY_INOUTLINEACCOUNTINGDIMENSIONLIST);
    }

    public void setInOutLineAccountingDimensionList(List<InOutLineAccountingDimension> inOutLineAccountingDimensionList) {
        set(PROPERTY_INOUTLINEACCOUNTINGDIMENSIONLIST, inOutLineAccountingDimensionList);
    }

    @SuppressWarnings("unchecked")
    public List<Invoice> getInvoiceList() {
      return (List<Invoice>) get(PROPERTY_INVOICELIST);
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        set(PROPERTY_INVOICELIST, invoiceList);
    }

    @SuppressWarnings("unchecked")
    public List<Invoice> getInvoiceEMSsreCBpartnerIDList() {
      return (List<Invoice>) get(PROPERTY_INVOICEEMSSRECBPARTNERIDLIST);
    }

    public void setInvoiceEMSsreCBpartnerIDList(List<Invoice> invoiceEMSsreCBpartnerIDList) {
        set(PROPERTY_INVOICEEMSSRECBPARTNERIDLIST, invoiceEMSsreCBpartnerIDList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceLine> getInvoiceLineList() {
      return (List<InvoiceLine>) get(PROPERTY_INVOICELINELIST);
    }

    public void setInvoiceLineList(List<InvoiceLine> invoiceLineList) {
        set(PROPERTY_INVOICELINELIST, invoiceLineList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceLine> getInvoiceLineEMSsreCBpartnerIDList() {
      return (List<InvoiceLine>) get(PROPERTY_INVOICELINEEMSSRECBPARTNERIDLIST);
    }

    public void setInvoiceLineEMSsreCBpartnerIDList(List<InvoiceLine> invoiceLineEMSsreCBpartnerIDList) {
        set(PROPERTY_INVOICELINEEMSSRECBPARTNERIDLIST, invoiceLineEMSsreCBpartnerIDList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceLineAccountingDimension> getInvoiceLineAccountingDimensionList() {
      return (List<InvoiceLineAccountingDimension>) get(PROPERTY_INVOICELINEACCOUNTINGDIMENSIONLIST);
    }

    public void setInvoiceLineAccountingDimensionList(List<InvoiceLineAccountingDimension> invoiceLineAccountingDimensionList) {
        set(PROPERTY_INVOICELINEACCOUNTINGDIMENSIONLIST, invoiceLineAccountingDimensionList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceLineV2> getInvoiceLineV2List() {
      return (List<InvoiceLineV2>) get(PROPERTY_INVOICELINEV2LIST);
    }

    public void setInvoiceLineV2List(List<InvoiceLineV2> invoiceLineV2List) {
        set(PROPERTY_INVOICELINEV2LIST, invoiceLineV2List);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceV2> getInvoiceV2List() {
      return (List<InvoiceV2>) get(PROPERTY_INVOICEV2LIST);
    }

    public void setInvoiceV2List(List<InvoiceV2> invoiceV2List) {
        set(PROPERTY_INVOICEV2LIST, invoiceV2List);
    }

    @SuppressWarnings("unchecked")
    public List<ProductionRun> getMRPProductionRunList() {
      return (List<ProductionRun>) get(PROPERTY_MRPPRODUCTIONRUNLIST);
    }

    public void setMRPProductionRunList(List<ProductionRun> mRPProductionRunList) {
        set(PROPERTY_MRPPRODUCTIONRUNLIST, mRPProductionRunList);
    }

    @SuppressWarnings("unchecked")
    public List<PurchasingRun> getMRPPurchasingRunVendorList() {
      return (List<PurchasingRun>) get(PROPERTY_MRPPURCHASINGRUNVENDORLIST);
    }

    public void setMRPPurchasingRunVendorList(List<PurchasingRun> mRPPurchasingRunVendorList) {
        set(PROPERTY_MRPPURCHASINGRUNVENDORLIST, mRPPurchasingRunVendorList);
    }

    @SuppressWarnings("unchecked")
    public List<PurchasingRun> getMRPPurchasingRunList() {
      return (List<PurchasingRun>) get(PROPERTY_MRPPURCHASINGRUNLIST);
    }

    public void setMRPPurchasingRunList(List<PurchasingRun> mRPPurchasingRunList) {
        set(PROPERTY_MRPPURCHASINGRUNLIST, mRPPurchasingRunList);
    }

    @SuppressWarnings("unchecked")
    public List<PurchasingRunLine> getMRPPurchasingRunLineList() {
      return (List<PurchasingRunLine>) get(PROPERTY_MRPPURCHASINGRUNLINELIST);
    }

    public void setMRPPurchasingRunLineList(List<PurchasingRunLine> mRPPurchasingRunLineList) {
        set(PROPERTY_MRPPURCHASINGRUNLINELIST, mRPPurchasingRunLineList);
    }

    @SuppressWarnings("unchecked")
    public List<SalesForecast> getMRPSalesForecastList() {
      return (List<SalesForecast>) get(PROPERTY_MRPSALESFORECASTLIST);
    }

    public void setMRPSalesForecastList(List<SalesForecast> mRPSalesForecastList) {
        set(PROPERTY_MRPSALESFORECASTLIST, mRPSalesForecastList);
    }

    @SuppressWarnings("unchecked")
    public List<Worker> getManufacturingMaintenanceWorkerList() {
      return (List<Worker>) get(PROPERTY_MANUFACTURINGMAINTENANCEWORKERLIST);
    }

    public void setManufacturingMaintenanceWorkerList(List<Worker> manufacturingMaintenanceWorkerList) {
        set(PROPERTY_MANUFACTURINGMAINTENANCEWORKERLIST, manufacturingMaintenanceWorkerList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductionRunEmployee> getManufacturingProductionRunEmployeeList() {
      return (List<ProductionRunEmployee>) get(PROPERTY_MANUFACTURINGPRODUCTIONRUNEMPLOYEELIST);
    }

    public void setManufacturingProductionRunEmployeeList(List<ProductionRunEmployee> manufacturingProductionRunEmployeeList) {
        set(PROPERTY_MANUFACTURINGPRODUCTIONRUNEMPLOYEELIST, manufacturingProductionRunEmployeeList);
    }

    @SuppressWarnings("unchecked")
    public List<WorkEffortEmployee> getManufacturingWorkEffortEmployeeList() {
      return (List<WorkEffortEmployee>) get(PROPERTY_MANUFACTURINGWORKEFFORTEMPLOYEELIST);
    }

    public void setManufacturingWorkEffortEmployeeList(List<WorkEffortEmployee> manufacturingWorkEffortEmployeeList) {
        set(PROPERTY_MANUFACTURINGWORKEFFORTEMPLOYEELIST, manufacturingWorkEffortEmployeeList);
    }

    @SuppressWarnings("unchecked")
    public List<Reservation> getMaterialMgmtReservationList() {
      return (List<Reservation>) get(PROPERTY_MATERIALMGMTRESERVATIONLIST);
    }

    public void setMaterialMgmtReservationList(List<Reservation> materialMgmtReservationList) {
        set(PROPERTY_MATERIALMGMTRESERVATIONLIST, materialMgmtReservationList);
    }

    @SuppressWarnings("unchecked")
    public List<ShipmentInOut> getMaterialMgmtShipmentInOutList() {
      return (List<ShipmentInOut>) get(PROPERTY_MATERIALMGMTSHIPMENTINOUTLIST);
    }

    public void setMaterialMgmtShipmentInOutList(List<ShipmentInOut> materialMgmtShipmentInOutList) {
        set(PROPERTY_MATERIALMGMTSHIPMENTINOUTLIST, materialMgmtShipmentInOutList);
    }

    @SuppressWarnings("unchecked")
    public List<ShipmentInOutLine> getMaterialMgmtShipmentInOutLineList() {
      return (List<ShipmentInOutLine>) get(PROPERTY_MATERIALMGMTSHIPMENTINOUTLINELIST);
    }

    public void setMaterialMgmtShipmentInOutLineList(List<ShipmentInOutLine> materialMgmtShipmentInOutLineList) {
        set(PROPERTY_MATERIALMGMTSHIPMENTINOUTLINELIST, materialMgmtShipmentInOutLineList);
    }

    @SuppressWarnings("unchecked")
    public List<Order> getOrderList() {
      return (List<Order>) get(PROPERTY_ORDERLIST);
    }

    public void setOrderList(List<Order> orderList) {
        set(PROPERTY_ORDERLIST, orderList);
    }

    @SuppressWarnings("unchecked")
    public List<Order> getOrderDropShipPartnerList() {
      return (List<Order>) get(PROPERTY_ORDERDROPSHIPPARTNERLIST);
    }

    public void setOrderDropShipPartnerList(List<Order> orderDropShipPartnerList) {
        set(PROPERTY_ORDERDROPSHIPPARTNERLIST, orderDropShipPartnerList);
    }

    @SuppressWarnings("unchecked")
    public List<OrderLine> getOrderLineList() {
      return (List<OrderLine>) get(PROPERTY_ORDERLINELIST);
    }

    public void setOrderLineList(List<OrderLine> orderLineList) {
        set(PROPERTY_ORDERLINELIST, orderLineList);
    }

    @SuppressWarnings("unchecked")
    public List<OrderLineAccountingDimension> getOrderLineAccountingDimensionList() {
      return (List<OrderLineAccountingDimension>) get(PROPERTY_ORDERLINEACCOUNTINGDIMENSIONLIST);
    }

    public void setOrderLineAccountingDimensionList(List<OrderLineAccountingDimension> orderLineAccountingDimensionList) {
        set(PROPERTY_ORDERLINEACCOUNTINGDIMENSIONLIST, orderLineAccountingDimensionList);
    }

    @SuppressWarnings("unchecked")
    public List<Organization> getOrganizationEMSfcbrBalanceSign1List() {
      return (List<Organization>) get(PROPERTY_ORGANIZATIONEMSFCBRBALANCESIGN1LIST);
    }

    public void setOrganizationEMSfcbrBalanceSign1List(List<Organization> organizationEMSfcbrBalanceSign1List) {
        set(PROPERTY_ORGANIZATIONEMSFCBRBALANCESIGN1LIST, organizationEMSfcbrBalanceSign1List);
    }

    @SuppressWarnings("unchecked")
    public List<Organization> getOrganizationEMSfcbrBalanceSign2List() {
      return (List<Organization>) get(PROPERTY_ORGANIZATIONEMSFCBRBALANCESIGN2LIST);
    }

    public void setOrganizationEMSfcbrBalanceSign2List(List<Organization> organizationEMSfcbrBalanceSign2List) {
        set(PROPERTY_ORGANIZATIONEMSFCBRBALANCESIGN2LIST, organizationEMSfcbrBalanceSign2List);
    }

    @SuppressWarnings("unchecked")
    public List<OrganizationInformation> getOrganizationInformationList() {
      return (List<OrganizationInformation>) get(PROPERTY_ORGANIZATIONINFORMATIONLIST);
    }

    public void setOrganizationInformationList(List<OrganizationInformation> organizationInformationList) {
        set(PROPERTY_ORGANIZATIONINFORMATIONLIST, organizationInformationList);
    }

    @SuppressWarnings("unchecked")
    public List<PrereservationManualPickEdit> getPrereservationManualPickEditList() {
      return (List<PrereservationManualPickEdit>) get(PROPERTY_PRERESERVATIONMANUALPICKEDITLIST);
    }

    public void setPrereservationManualPickEditList(List<PrereservationManualPickEdit> prereservationManualPickEditList) {
        set(PROPERTY_PRERESERVATIONMANUALPICKEDITLIST, prereservationManualPickEditList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.model.pricing.priceadjustment.BusinessPartner> getPricingAdjustmentBusinessPartnerList() {
      return (List<org.openbravo.model.pricing.priceadjustment.BusinessPartner>) get(PROPERTY_PRICINGADJUSTMENTBUSINESSPARTNERLIST);
    }

    public void setPricingAdjustmentBusinessPartnerList(List<org.openbravo.model.pricing.priceadjustment.BusinessPartner> pricingAdjustmentBusinessPartnerList) {
        set(PROPERTY_PRICINGADJUSTMENTBUSINESSPARTNERLIST, pricingAdjustmentBusinessPartnerList);
    }

    @SuppressWarnings("unchecked")
    public List<PriceListSchemeLine> getPricingPriceListSchemeLineList() {
      return (List<PriceListSchemeLine>) get(PROPERTY_PRICINGPRICELISTSCHEMELINELIST);
    }

    public void setPricingPriceListSchemeLineList(List<PriceListSchemeLine> pricingPriceListSchemeLineList) {
        set(PROPERTY_PRICINGPRICELISTSCHEMELINELIST, pricingPriceListSchemeLineList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.model.pricing.volumediscount.BusinessPartner> getPricingVolumeDiscountBusinessPartnerList() {
      return (List<org.openbravo.model.pricing.volumediscount.BusinessPartner>) get(PROPERTY_PRICINGVOLUMEDISCOUNTBUSINESSPARTNERLIST);
    }

    public void setPricingVolumeDiscountBusinessPartnerList(List<org.openbravo.model.pricing.volumediscount.BusinessPartner> pricingVolumeDiscountBusinessPartnerList) {
        set(PROPERTY_PRICINGVOLUMEDISCOUNTBUSINESSPARTNERLIST, pricingVolumeDiscountBusinessPartnerList);
    }

    @SuppressWarnings("unchecked")
    public List<Requisition> getProcurementRequisitionList() {
      return (List<Requisition>) get(PROPERTY_PROCUREMENTREQUISITIONLIST);
    }

    public void setProcurementRequisitionList(List<Requisition> procurementRequisitionList) {
        set(PROPERTY_PROCUREMENTREQUISITIONLIST, procurementRequisitionList);
    }

    @SuppressWarnings("unchecked")
    public List<RequisitionLine> getProcurementRequisitionLineList() {
      return (List<RequisitionLine>) get(PROPERTY_PROCUREMENTREQUISITIONLINELIST);
    }

    public void setProcurementRequisitionLineList(List<RequisitionLine> procurementRequisitionLineList) {
        set(PROPERTY_PROCUREMENTREQUISITIONLINELIST, procurementRequisitionLineList);
    }

    @SuppressWarnings("unchecked")
    public List<Product> getProductList() {
      return (List<Product>) get(PROPERTY_PRODUCTLIST);
    }

    public void setProductList(List<Product> productList) {
        set(PROPERTY_PRODUCTLIST, productList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductCustomer> getProductCustomerList() {
      return (List<ProductCustomer>) get(PROPERTY_PRODUCTCUSTOMERLIST);
    }

    public void setProductCustomerList(List<ProductCustomer> productCustomerList) {
        set(PROPERTY_PRODUCTCUSTOMERLIST, productCustomerList);
    }

    @SuppressWarnings("unchecked")
    public List<Project> getProjectList() {
      return (List<Project>) get(PROPERTY_PROJECTLIST);
    }

    public void setProjectList(List<Project> projectList) {
        set(PROPERTY_PROJECTLIST, projectList);
    }

    @SuppressWarnings("unchecked")
    public List<Project> getProjectPersonInChargeList() {
      return (List<Project>) get(PROPERTY_PROJECTPERSONINCHARGELIST);
    }

    public void setProjectPersonInChargeList(List<Project> projectPersonInChargeList) {
        set(PROPERTY_PROJECTPERSONINCHARGELIST, projectPersonInChargeList);
    }

    @SuppressWarnings("unchecked")
    public List<ProjectProposal> getProjectProposalList() {
      return (List<ProjectProposal>) get(PROPERTY_PROJECTPROPOSALLIST);
    }

    public void setProjectProposalList(List<ProjectProposal> projectProposalList) {
        set(PROPERTY_PROJECTPROPOSALLIST, projectProposalList);
    }

    @SuppressWarnings("unchecked")
    public List<ProjectVendor> getProjectVendorList() {
      return (List<ProjectVendor>) get(PROPERTY_PROJECTVENDORLIST);
    }

    public void setProjectVendorList(List<ProjectVendor> projectVendorList) {
        set(PROPERTY_PROJECTVENDORLIST, projectVendorList);
    }

    @SuppressWarnings("unchecked")
    public List<ReturnMaterialReceiptPickEdit> getReturnMaterialReceiptPickEditList() {
      return (List<ReturnMaterialReceiptPickEdit>) get(PROPERTY_RETURNMATERIALRECEIPTPICKEDITLIST);
    }

    public void setReturnMaterialReceiptPickEditList(List<ReturnMaterialReceiptPickEdit> returnMaterialReceiptPickEditList) {
        set(PROPERTY_RETURNMATERIALRECEIPTPICKEDITLIST, returnMaterialReceiptPickEditList);
    }

    @SuppressWarnings("unchecked")
    public List<ReturnMaterialShipmentPickEdit> getReturnMaterialShipmentPickEditList() {
      return (List<ReturnMaterialShipmentPickEdit>) get(PROPERTY_RETURNMATERIALSHIPMENTPICKEDITLIST);
    }

    public void setReturnMaterialShipmentPickEditList(List<ReturnMaterialShipmentPickEdit> returnMaterialShipmentPickEditList) {
        set(PROPERTY_RETURNMATERIALSHIPMENTPICKEDITLIST, returnMaterialShipmentPickEditList);
    }

    @SuppressWarnings("unchecked")
    public List<SBPCInfoPartnersV> getSBPCInfoPartnersVList() {
      return (List<SBPCInfoPartnersV>) get(PROPERTY_SBPCINFOPARTNERSVLIST);
    }

    public void setSBPCInfoPartnersVList(List<SBPCInfoPartnersV> sBPCInfoPartnersVList) {
        set(PROPERTY_SBPCINFOPARTNERSVLIST, sBPCInfoPartnersVList);
    }

    @SuppressWarnings("unchecked")
    public List<SBPCInfoPartnersV> getSBPCInfoPartnersVCBpartnerIdTaxList() {
      return (List<SBPCInfoPartnersV>) get(PROPERTY_SBPCINFOPARTNERSVCBPARTNERIDTAXLIST);
    }

    public void setSBPCInfoPartnersVCBpartnerIdTaxList(List<SBPCInfoPartnersV> sBPCInfoPartnersVCBpartnerIdTaxList) {
        set(PROPERTY_SBPCINFOPARTNERSVCBPARTNERIDTAXLIST, sBPCInfoPartnersVCBpartnerIdTaxList);
    }

    @SuppressWarnings("unchecked")
    public List<SBPCInfoPartnersV> getSBPCInfoPartnersVCBpartnerIdNameList() {
      return (List<SBPCInfoPartnersV>) get(PROPERTY_SBPCINFOPARTNERSVCBPARTNERIDNAMELIST);
    }

    public void setSBPCInfoPartnersVCBpartnerIdNameList(List<SBPCInfoPartnersV> sBPCInfoPartnersVCBpartnerIdNameList) {
        set(PROPERTY_SBPCINFOPARTNERSVCBPARTNERIDNAMELIST, sBPCInfoPartnersVCBpartnerIdNameList);
    }

    @SuppressWarnings("unchecked")
    public List<SBPCInfoPartnersV> getSBPCInfoPartnersVCBpartnerIdMailList() {
      return (List<SBPCInfoPartnersV>) get(PROPERTY_SBPCINFOPARTNERSVCBPARTNERIDMAILLIST);
    }

    public void setSBPCInfoPartnersVCBpartnerIdMailList(List<SBPCInfoPartnersV> sBPCInfoPartnersVCBpartnerIdMailList) {
        set(PROPERTY_SBPCINFOPARTNERSVCBPARTNERIDMAILLIST, sBPCInfoPartnersVCBpartnerIdMailList);
    }

    @SuppressWarnings("unchecked")
    public List<SRSISalesInvoiceV> getSRSISalesInvoiceVCBpartnerIdCodList() {
      return (List<SRSISalesInvoiceV>) get(PROPERTY_SRSISALESINVOICEVCBPARTNERIDCODLIST);
    }

    public void setSRSISalesInvoiceVCBpartnerIdCodList(List<SRSISalesInvoiceV> sRSISalesInvoiceVCBpartnerIdCodList) {
        set(PROPERTY_SRSISALESINVOICEVCBPARTNERIDCODLIST, sRSISalesInvoiceVCBpartnerIdCodList);
    }

    @SuppressWarnings("unchecked")
    public List<SRSISalesInvoiceV> getSRSISalesInvoiceVCBpartnerIdNameList() {
      return (List<SRSISalesInvoiceV>) get(PROPERTY_SRSISALESINVOICEVCBPARTNERIDNAMELIST);
    }

    public void setSRSISalesInvoiceVCBpartnerIdNameList(List<SRSISalesInvoiceV> sRSISalesInvoiceVCBpartnerIdNameList) {
        set(PROPERTY_SRSISALESINVOICEVCBPARTNERIDNAMELIST, sRSISalesInvoiceVCBpartnerIdNameList);
    }

    @SuppressWarnings("unchecked")
    public List<AccountingFactSecondary> getSSACCTAccountingFactSecondaryList() {
      return (List<AccountingFactSecondary>) get(PROPERTY_SSACCTACCOUNTINGFACTSECONDARYLIST);
    }

    public void setSSACCTAccountingFactSecondaryList(List<AccountingFactSecondary> sSACCTAccountingFactSecondaryList) {
        set(PROPERTY_SSACCTACCOUNTINGFACTSECONDARYLIST, sSACCTAccountingFactSecondaryList);
    }

    @SuppressWarnings("unchecked")
    public List<SSACCTJOURNAL> getSSACCTJOURNALList() {
      return (List<SSACCTJOURNAL>) get(PROPERTY_SSACCTJOURNALLIST);
    }

    public void setSSACCTJOURNALList(List<SSACCTJOURNAL> sSACCTJOURNALList) {
        set(PROPERTY_SSACCTJOURNALLIST, sSACCTJOURNALList);
    }

    @SuppressWarnings("unchecked")
    public List<SSACCTJournalLine> getSSACCTJournalLineList() {
      return (List<SSACCTJournalLine>) get(PROPERTY_SSACCTJOURNALLINELIST);
    }

    public void setSSACCTJournalLineList(List<SSACCTJournalLine> sSACCTJournalLineList) {
        set(PROPERTY_SSACCTJOURNALLINELIST, sSACCTJournalLineList);
    }

    @SuppressWarnings("unchecked")
    public List<SSPHTenthSettlementLine> getSSPHTenthSettlementLineList() {
      return (List<SSPHTenthSettlementLine>) get(PROPERTY_SSPHTENTHSETTLEMENTLINELIST);
    }

    public void setSSPHTenthSettlementLineList(List<SSPHTenthSettlementLine> sSPHTenthSettlementLineList) {
        set(PROPERTY_SSPHTENTHSETTLEMENTLINELIST, sSPHTenthSettlementLineList);
    }

    @SuppressWarnings("unchecked")
    public List<SSPPPAYMENTS> getSSPPPAYMENTSList() {
      return (List<SSPPPAYMENTS>) get(PROPERTY_SSPPPAYMENTSLIST);
    }

    public void setSSPPPAYMENTSList(List<SSPPPAYMENTS> sSPPPAYMENTSList) {
        set(PROPERTY_SSPPPAYMENTSLIST, sSPPPAYMENTSList);
    }

    @SuppressWarnings("unchecked")
    public List<SSPPPAYMENTSLINE> getSSPPPAYMENTSLINEList() {
      return (List<SSPPPAYMENTSLINE>) get(PROPERTY_SSPPPAYMENTSLINELIST);
    }

    public void setSSPPPAYMENTSLINEList(List<SSPPPAYMENTSLINE> sSPPPAYMENTSLINEList) {
        set(PROPERTY_SSPPPAYMENTSLINELIST, sSPPPAYMENTSLINEList);
    }

    @SuppressWarnings("unchecked")
    public List<com.sidesoft.hrm.payroll.Category> getSSPRCategoryList() {
      return (List<com.sidesoft.hrm.payroll.Category>) get(PROPERTY_SSPRCATEGORYLIST);
    }

    public void setSSPRCategoryList(List<com.sidesoft.hrm.payroll.Category> sSPRCategoryList) {
        set(PROPERTY_SSPRCATEGORYLIST, sSPRCategoryList);
    }

    @SuppressWarnings("unchecked")
    public List<ConceptAmount> getSSPRConceptAmountList() {
      return (List<ConceptAmount>) get(PROPERTY_SSPRCONCEPTAMOUNTLIST);
    }

    public void setSSPRConceptAmountList(List<ConceptAmount> sSPRConceptAmountList) {
        set(PROPERTY_SSPRCONCEPTAMOUNTLIST, sSPRConceptAmountList);
    }

    @SuppressWarnings("unchecked")
    public List<Contract> getSSPRContractList() {
      return (List<Contract>) get(PROPERTY_SSPRCONTRACTLIST);
    }

    public void setSSPRContractList(List<Contract> sSPRContractList) {
        set(PROPERTY_SSPRCONTRACTLIST, sSPRContractList);
    }

    @SuppressWarnings("unchecked")
    public List<Family> getSSPRFamilyList() {
      return (List<Family>) get(PROPERTY_SSPRFAMILYLIST);
    }

    public void setSSPRFamilyList(List<Family> sSPRFamilyList) {
        set(PROPERTY_SSPRFAMILYLIST, sSPRFamilyList);
    }

    @SuppressWarnings("unchecked")
    public List<ssprleaveemp> getSSPRLeaveEmpList() {
      return (List<ssprleaveemp>) get(PROPERTY_SSPRLEAVEEMPLIST);
    }

    public void setSSPRLeaveEmpList(List<ssprleaveemp> sSPRLeaveEmpList) {
        set(PROPERTY_SSPRLEAVEEMPLIST, sSPRLeaveEmpList);
    }

    @SuppressWarnings("unchecked")
    public List<ssprleaveemp> getSSPRLeaveEmpWhoReplaceList() {
      return (List<ssprleaveemp>) get(PROPERTY_SSPRLEAVEEMPWHOREPLACELIST);
    }

    public void setSSPRLeaveEmpWhoReplaceList(List<ssprleaveemp> sSPRLeaveEmpWhoReplaceList) {
        set(PROPERTY_SSPRLEAVEEMPWHOREPLACELIST, sSPRLeaveEmpWhoReplaceList);
    }

    @SuppressWarnings("unchecked")
    public List<ssprleaveemp> getSSPRLeaveEmpAuthorizedList() {
      return (List<ssprleaveemp>) get(PROPERTY_SSPRLEAVEEMPAUTHORIZEDLIST);
    }

    public void setSSPRLeaveEmpAuthorizedList(List<ssprleaveemp> sSPRLeaveEmpAuthorizedList) {
        set(PROPERTY_SSPRLEAVEEMPAUTHORIZEDLIST, sSPRLeaveEmpAuthorizedList);
    }

    @SuppressWarnings("unchecked")
    public List<ssprleaveemp> getSSPRLeaveEmpCurrentUserIDList() {
      return (List<ssprleaveemp>) get(PROPERTY_SSPRLEAVEEMPCURRENTUSERIDLIST);
    }

    public void setSSPRLeaveEmpCurrentUserIDList(List<ssprleaveemp> sSPRLeaveEmpCurrentUserIDList) {
        set(PROPERTY_SSPRLEAVEEMPCURRENTUSERIDLIST, sSPRLeaveEmpCurrentUserIDList);
    }

    @SuppressWarnings("unchecked")
    public List<Payroll> getSSPRPayrollList() {
      return (List<Payroll>) get(PROPERTY_SSPRPAYROLLLIST);
    }

    public void setSSPRPayrollList(List<Payroll> sSPRPayrollList) {
        set(PROPERTY_SSPRPAYROLLLIST, sSPRPayrollList);
    }

    @SuppressWarnings("unchecked")
    public List<PayrollTicket> getSSPRPayrollTicketList() {
      return (List<PayrollTicket>) get(PROPERTY_SSPRPAYROLLTICKETLIST);
    }

    public void setSSPRPayrollTicketList(List<PayrollTicket> sSPRPayrollTicketList) {
        set(PROPERTY_SSPRPAYROLLTICKETLIST, sSPRPayrollTicketList);
    }

    @SuppressWarnings("unchecked")
    public List<Period> getSSPRPeriodList() {
      return (List<Period>) get(PROPERTY_SSPRPERIODLIST);
    }

    public void setSSPRPeriodList(List<Period> sSPRPeriodList) {
        set(PROPERTY_SSPRPERIODLIST, sSPRPeriodList);
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
    public List<SSWHCheckbookpos> getSSWHCheckbookposList() {
      return (List<SSWHCheckbookpos>) get(PROPERTY_SSWHCHECKBOOKPOSLIST);
    }

    public void setSSWHCheckbookposList(List<SSWHCheckbookpos> sSWHCheckbookposList) {
        set(PROPERTY_SSWHCHECKBOOKPOSLIST, sSWHCheckbookposList);
    }

    @SuppressWarnings("unchecked")
    public List<SSWHCheckbookposLine> getSSWHCheckbookposLineList() {
      return (List<SSWHCheckbookposLine>) get(PROPERTY_SSWHCHECKBOOKPOSLINELIST);
    }

    public void setSSWHCheckbookposLineList(List<SSWHCheckbookposLine> sSWHCheckbookposLineList) {
        set(PROPERTY_SSWHCHECKBOOKPOSLINELIST, sSWHCheckbookposLineList);
    }

    @SuppressWarnings("unchecked")
    public List<Receipt> getSSWHReceiptList() {
      return (List<Receipt>) get(PROPERTY_SSWHRECEIPTLIST);
    }

    public void setSSWHReceiptList(List<Receipt> sSWHReceiptList) {
        set(PROPERTY_SSWHRECEIPTLIST, sSWHReceiptList);
    }

    @SuppressWarnings("unchecked")
    public List<SSWHWithholdingvendor> getSSWHWithholdingVendorList() {
      return (List<SSWHWithholdingvendor>) get(PROPERTY_SSWHWITHHOLDINGVENDORLIST);
    }

    public void setSSWHWithholdingVendorList(List<SSWHWithholdingvendor> sSWHWithholdingVendorList) {
        set(PROPERTY_SSWHWITHHOLDINGVENDORLIST, sSWHWithholdingVendorList);
    }

    @SuppressWarnings("unchecked")
    public List<SSWSWithholdingSale> getSSWSWithholdingSaleList() {
      return (List<SSWSWithholdingSale>) get(PROPERTY_SSWSWITHHOLDINGSALELIST);
    }

    public void setSSWSWithholdingSaleList(List<SSWSWithholdingSale> sSWSWithholdingSaleList) {
        set(PROPERTY_SSWSWITHHOLDINGSALELIST, sSWSWithholdingSaleList);
    }

    @SuppressWarnings("unchecked")
    public List<SWSICConfig> getSWSICConfigList() {
      return (List<SWSICConfig>) get(PROPERTY_SWSICCONFIGLIST);
    }

    public void setSWSICConfigList(List<SWSICConfig> sWSICConfigList) {
        set(PROPERTY_SWSICCONFIGLIST, sWSICConfigList);
    }

    @SuppressWarnings("unchecked")
    public List<Commission> getSalesCommissionList() {
      return (List<Commission>) get(PROPERTY_SALESCOMMISSIONLIST);
    }

    public void setSalesCommissionList(List<Commission> salesCommissionList) {
        set(PROPERTY_SALESCOMMISSIONLIST, salesCommissionList);
    }

    @SuppressWarnings("unchecked")
    public List<CommissionLine> getSalesCommissionLineList() {
      return (List<CommissionLine>) get(PROPERTY_SALESCOMMISSIONLINELIST);
    }

    public void setSalesCommissionLineList(List<CommissionLine> salesCommissionLineList) {
        set(PROPERTY_SALESCOMMISSIONLINELIST, salesCommissionLineList);
    }

    @SuppressWarnings("unchecked")
    public List<SfbtrBudgetaryReforms> getSfbtrBudgetaryReformsList() {
      return (List<SfbtrBudgetaryReforms>) get(PROPERTY_SFBTRBUDGETARYREFORMSLIST);
    }

    public void setSfbtrBudgetaryReformsList(List<SfbtrBudgetaryReforms> sfbtrBudgetaryReformsList) {
        set(PROPERTY_SFBTRBUDGETARYREFORMSLIST, sfbtrBudgetaryReformsList);
    }

    @SuppressWarnings("unchecked")
    public List<ShippingCompany> getShippingShippingCompanyList() {
      return (List<ShippingCompany>) get(PROPERTY_SHIPPINGSHIPPINGCOMPANYLIST);
    }

    public void setShippingShippingCompanyList(List<ShippingCompany> shippingShippingCompanyList) {
        set(PROPERTY_SHIPPINGSHIPPINGCOMPANYLIST, shippingShippingCompanyList);
    }

    @SuppressWarnings("unchecked")
    public List<SswhRptcPurchaseWith> getSswhRptcPurchaseWithList() {
      return (List<SswhRptcPurchaseWith>) get(PROPERTY_SSWHRPTCPURCHASEWITHLIST);
    }

    public void setSswhRptcPurchaseWithList(List<SswhRptcPurchaseWith> sswhRptcPurchaseWithList) {
        set(PROPERTY_SSWHRPTCPURCHASEWITHLIST, sswhRptcPurchaseWithList);
    }

    @SuppressWarnings("unchecked")
    public List<Sheet> getTimeAndExpenseSheetList() {
      return (List<Sheet>) get(PROPERTY_TIMEANDEXPENSESHEETLIST);
    }

    public void setTimeAndExpenseSheetList(List<Sheet> timeAndExpenseSheetList) {
        set(PROPERTY_TIMEANDEXPENSESHEETLIST, timeAndExpenseSheetList);
    }

    @SuppressWarnings("unchecked")
    public List<SheetLine> getTimeAndExpenseSheetLineList() {
      return (List<SheetLine>) get(PROPERTY_TIMEANDEXPENSESHEETLINELIST);
    }

    public void setTimeAndExpenseSheetLineList(List<SheetLine> timeAndExpenseSheetLineList) {
        set(PROPERTY_TIMEANDEXPENSESHEETLINELIST, timeAndExpenseSheetLineList);
    }

    @SuppressWarnings("unchecked")
    public List<SheetLineV> getTimeAndExpenseSheetLineVList() {
      return (List<SheetLineV>) get(PROPERTY_TIMEANDEXPENSESHEETLINEVLIST);
    }

    public void setTimeAndExpenseSheetLineVList(List<SheetLineV> timeAndExpenseSheetLineVList) {
        set(PROPERTY_TIMEANDEXPENSESHEETLINEVLIST, timeAndExpenseSheetLineVList);
    }

    @SuppressWarnings("unchecked")
    public List<SheetLineV> getTimeAndExpenseSheetLineVChargedBusinessPartnerList() {
      return (List<SheetLineV>) get(PROPERTY_TIMEANDEXPENSESHEETLINEVCHARGEDBUSINESSPARTNERLIST);
    }

    public void setTimeAndExpenseSheetLineVChargedBusinessPartnerList(List<SheetLineV> timeAndExpenseSheetLineVChargedBusinessPartnerList) {
        set(PROPERTY_TIMEANDEXPENSESHEETLINEVCHARGEDBUSINESSPARTNERLIST, timeAndExpenseSheetLineVChargedBusinessPartnerList);
    }

    @SuppressWarnings("unchecked")
    public List<MaterialTransactionV> getTransactionVList() {
      return (List<MaterialTransactionV>) get(PROPERTY_TRANSACTIONVLIST);
    }

    public void setTransactionVList(List<MaterialTransactionV> transactionVList) {
        set(PROPERTY_TRANSACTIONVLIST, transactionVList);
    }

    @SuppressWarnings("unchecked")
    public List<UserDimension2> getUserDimension2EMSsflBrokervalueList() {
      return (List<UserDimension2>) get(PROPERTY_USERDIMENSION2EMSSFLBROKERVALUELIST);
    }

    public void setUserDimension2EMSsflBrokervalueList(List<UserDimension2> userDimension2EMSsflBrokervalueList) {
        set(PROPERTY_USERDIMENSION2EMSSFLBROKERVALUELIST, userDimension2EMSsflBrokervalueList);
    }

    @SuppressWarnings("unchecked")
    public List<UserDimension2> getUserDimension2EMSsflBrokervalue2List() {
      return (List<UserDimension2>) get(PROPERTY_USERDIMENSION2EMSSFLBROKERVALUE2LIST);
    }

    public void setUserDimension2EMSsflBrokervalue2List(List<UserDimension2> userDimension2EMSsflBrokervalue2List) {
        set(PROPERTY_USERDIMENSION2EMSSFLBROKERVALUE2LIST, userDimension2EMSsflBrokervalue2List);
    }

    @SuppressWarnings("unchecked")
    public List<VendorAccounts> getVendorAccountsList() {
      return (List<VendorAccounts>) get(PROPERTY_VENDORACCOUNTSLIST);
    }

    public void setVendorAccountsList(List<VendorAccounts> vendorAccountsList) {
        set(PROPERTY_VENDORACCOUNTSLIST, vendorAccountsList);
    }

    @SuppressWarnings("unchecked")
    public List<WarehouseShipper> getWarehouseShipperList() {
      return (List<WarehouseShipper>) get(PROPERTY_WAREHOUSESHIPPERLIST);
    }

    public void setWarehouseShipperList(List<WarehouseShipper> warehouseShipperList) {
        set(PROPERTY_WAREHOUSESHIPPERLIST, warehouseShipperList);
    }

    @SuppressWarnings("unchecked")
    public List<EeiPaymentDetailV> getEeiPaymentDetailVList() {
      return (List<EeiPaymentDetailV>) get(PROPERTY_EEIPAYMENTDETAILVLIST);
    }

    public void setEeiPaymentDetailVList(List<EeiPaymentDetailV> eeiPaymentDetailVList) {
        set(PROPERTY_EEIPAYMENTDETAILVLIST, eeiPaymentDetailVList);
    }

    @SuppressWarnings("unchecked")
    public List<Opcrmactivity> getOpcrmActivityList() {
      return (List<Opcrmactivity>) get(PROPERTY_OPCRMACTIVITYLIST);
    }

    public void setOpcrmActivityList(List<Opcrmactivity> opcrmActivityList) {
        set(PROPERTY_OPCRMACTIVITYLIST, opcrmActivityList);
    }

    @SuppressWarnings("unchecked")
    public List<Opcrmcase> getOpcrmCasesList() {
      return (List<Opcrmcase>) get(PROPERTY_OPCRMCASESLIST);
    }

    public void setOpcrmCasesList(List<Opcrmcase> opcrmCasesList) {
        set(PROPERTY_OPCRMCASESLIST, opcrmCasesList);
    }

    @SuppressWarnings("unchecked")
    public List<Opcrmdocuments> getOpcrmDocumentsList() {
      return (List<Opcrmdocuments>) get(PROPERTY_OPCRMDOCUMENTSLIST);
    }

    public void setOpcrmDocumentsList(List<Opcrmdocuments> opcrmDocumentsList) {
        set(PROPERTY_OPCRMDOCUMENTSLIST, opcrmDocumentsList);
    }

    @SuppressWarnings("unchecked")
    public List<Opcrmopportunities> getOpcrmOpportunitiesList() {
      return (List<Opcrmopportunities>) get(PROPERTY_OPCRMOPPORTUNITIESLIST);
    }

    public void setOpcrmOpportunitiesList(List<Opcrmopportunities> opcrmOpportunitiesList) {
        set(PROPERTY_OPCRMOPPORTUNITIESLIST, opcrmOpportunitiesList);
    }

    @SuppressWarnings("unchecked")
    public List<scppapprovalpaymentline> getScppApprovalpaymentlineList() {
      return (List<scppapprovalpaymentline>) get(PROPERTY_SCPPAPPROVALPAYMENTLINELIST);
    }

    public void setScppApprovalpaymentlineList(List<scppapprovalpaymentline> scppApprovalpaymentlineList) {
        set(PROPERTY_SCPPAPPROVALPAYMENTLINELIST, scppApprovalpaymentlineList);
    }

    @SuppressWarnings("unchecked")
    public List<SFBBudgetCertLineDet> getSfbBudgetCertLineDetVOrderBusinessPartnerList() {
      return (List<SFBBudgetCertLineDet>) get(PROPERTY_SFBBUDGETCERTLINEDETVORDERBUSINESSPARTNERLIST);
    }

    public void setSfbBudgetCertLineDetVOrderBusinessPartnerList(List<SFBBudgetCertLineDet> sfbBudgetCertLineDetVOrderBusinessPartnerList) {
        set(PROPERTY_SFBBUDGETCERTLINEDETVORDERBUSINESSPARTNERLIST, sfbBudgetCertLineDetVOrderBusinessPartnerList);
    }

    @SuppressWarnings("unchecked")
    public List<SFBBudgetCertLineDet> getSfbBudgetCertLineDetVInvoiceBusinessPartnerList() {
      return (List<SFBBudgetCertLineDet>) get(PROPERTY_SFBBUDGETCERTLINEDETVINVOICEBUSINESSPARTNERLIST);
    }

    public void setSfbBudgetCertLineDetVInvoiceBusinessPartnerList(List<SFBBudgetCertLineDet> sfbBudgetCertLineDetVInvoiceBusinessPartnerList) {
        set(PROPERTY_SFBBUDGETCERTLINEDETVINVOICEBUSINESSPARTNERLIST, sfbBudgetCertLineDetVInvoiceBusinessPartnerList);
    }

    @SuppressWarnings("unchecked")
    public List<sfb_budget_details_v> getSfbBudgetDetailsVCBpartnerOrdIDList() {
      return (List<sfb_budget_details_v>) get(PROPERTY_SFBBUDGETDETAILSVCBPARTNERORDIDLIST);
    }

    public void setSfbBudgetDetailsVCBpartnerOrdIDList(List<sfb_budget_details_v> sfbBudgetDetailsVCBpartnerOrdIDList) {
        set(PROPERTY_SFBBUDGETDETAILSVCBPARTNERORDIDLIST, sfbBudgetDetailsVCBpartnerOrdIDList);
    }

    @SuppressWarnings("unchecked")
    public List<sfb_budget_details_v> getSfbBudgetDetailsVCBpartnerInvIDList() {
      return (List<sfb_budget_details_v>) get(PROPERTY_SFBBUDGETDETAILSVCBPARTNERINVIDLIST);
    }

    public void setSfbBudgetDetailsVCBpartnerInvIDList(List<sfb_budget_details_v> sfbBudgetDetailsVCBpartnerInvIDList) {
        set(PROPERTY_SFBBUDGETDETAILSVCBPARTNERINVIDLIST, sfbBudgetDetailsVCBpartnerInvIDList);
    }

    @SuppressWarnings("unchecked")
    public List<sfb_budget_details_v> getSfbBudgetDetailsVCBpartnerIdPayList() {
      return (List<sfb_budget_details_v>) get(PROPERTY_SFBBUDGETDETAILSVCBPARTNERIDPAYLIST);
    }

    public void setSfbBudgetDetailsVCBpartnerIdPayList(List<sfb_budget_details_v> sfbBudgetDetailsVCBpartnerIdPayList) {
        set(PROPERTY_SFBBUDGETDETAILSVCBPARTNERIDPAYLIST, sfbBudgetDetailsVCBpartnerIdPayList);
    }

    @SuppressWarnings("unchecked")
    public List<sfbbudgetpaymentdetv> getSfbBudgetPaymentDetVList() {
      return (List<sfbbudgetpaymentdetv>) get(PROPERTY_SFBBUDGETPAYMENTDETVLIST);
    }

    public void setSfbBudgetPaymentDetVList(List<sfbbudgetpaymentdetv> sfbBudgetPaymentDetVList) {
        set(PROPERTY_SFBBUDGETPAYMENTDETVLIST, sfbBudgetPaymentDetVList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprEmployeeOther> getSfprEmployeeOtherList() {
      return (List<SfprEmployeeOther>) get(PROPERTY_SFPREMPLOYEEOTHERLIST);
    }

    public void setSfprEmployeeOtherList(List<SfprEmployeeOther> sfprEmployeeOtherList) {
        set(PROPERTY_SFPREMPLOYEEOTHERLIST, sfprEmployeeOtherList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprEmployeePermit> getSfprEmployeePermitList() {
      return (List<SfprEmployeePermit>) get(PROPERTY_SFPREMPLOYEEPERMITLIST);
    }

    public void setSfprEmployeePermitList(List<SfprEmployeePermit> sfprEmployeePermitList) {
        set(PROPERTY_SFPREMPLOYEEPERMITLIST, sfprEmployeePermitList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprEmployeeRve> getSfprEmployeeRveList() {
      return (List<SfprEmployeeRve>) get(PROPERTY_SFPREMPLOYEERVELIST);
    }

    public void setSfprEmployeeRveList(List<SfprEmployeeRve> sfprEmployeeRveList) {
        set(PROPERTY_SFPREMPLOYEERVELIST, sfprEmployeeRveList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprEmployeeSurrogate> getSfprEmployeeSurrogateList() {
      return (List<SfprEmployeeSurrogate>) get(PROPERTY_SFPREMPLOYEESURROGATELIST);
    }

    public void setSfprEmployeeSurrogateList(List<SfprEmployeeSurrogate> sfprEmployeeSurrogateList) {
        set(PROPERTY_SFPREMPLOYEESURROGATELIST, sfprEmployeeSurrogateList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprEmployeeVacation> getSfprEmployeeVacationList() {
      return (List<SfprEmployeeVacation>) get(PROPERTY_SFPREMPLOYEEVACATIONLIST);
    }

    public void setSfprEmployeeVacationList(List<SfprEmployeeVacation> sfprEmployeeVacationList) {
        set(PROPERTY_SFPREMPLOYEEVACATIONLIST, sfprEmployeeVacationList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprJobAction> getSfprJobActionList() {
      return (List<SfprJobAction>) get(PROPERTY_SFPRJOBACTIONLIST);
    }

    public void setSfprJobActionList(List<SfprJobAction> sfprJobActionList) {
        set(PROPERTY_SFPRJOBACTIONLIST, sfprJobActionList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprProvisionProperty> getSfprProvisionPropertyList() {
      return (List<SfprProvisionProperty>) get(PROPERTY_SFPRPROVISIONPROPERTYLIST);
    }

    public void setSfprProvisionPropertyList(List<SfprProvisionProperty> sfprProvisionPropertyList) {
        set(PROPERTY_SFPRPROVISIONPROPERTYLIST, sfprProvisionPropertyList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprRveDetail> getSfprRveDetailList() {
      return (List<SfprRveDetail>) get(PROPERTY_SFPRRVEDETAILLIST);
    }

    public void setSfprRveDetailList(List<SfprRveDetail> sfprRveDetailList) {
        set(PROPERTY_SFPRRVEDETAILLIST, sfprRveDetailList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprSurrogateDetail> getSfprSurrogateDetailList() {
      return (List<SfprSurrogateDetail>) get(PROPERTY_SFPRSURROGATEDETAILLIST);
    }

    public void setSfprSurrogateDetailList(List<SfprSurrogateDetail> sfprSurrogateDetailList) {
        set(PROPERTY_SFPRSURROGATEDETAILLIST, sfprSurrogateDetailList);
    }

    @SuppressWarnings("unchecked")
    public List<SqbConfigQuickBilling> getSqbConfigQuickbillingBpartnerIDList() {
      return (List<SqbConfigQuickBilling>) get(PROPERTY_SQBCONFIGQUICKBILLINGBPARTNERIDLIST);
    }

    public void setSqbConfigQuickbillingBpartnerIDList(List<SqbConfigQuickBilling> sqbConfigQuickbillingBpartnerIDList) {
        set(PROPERTY_SQBCONFIGQUICKBILLINGBPARTNERIDLIST, sqbConfigQuickbillingBpartnerIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SqbQuickBilling> getSqbQuickbillingList() {
      return (List<SqbQuickBilling>) get(PROPERTY_SQBQUICKBILLINGLIST);
    }

    public void setSqbQuickbillingList(List<SqbQuickBilling> sqbQuickbillingList) {
        set(PROPERTY_SQBQUICKBILLINGLIST, sqbQuickbillingList);
    }

    @SuppressWarnings("unchecked")
    public List<SsalApplActive> getSsalApplActiveList() {
      return (List<SsalApplActive>) get(PROPERTY_SSALAPPLACTIVELIST);
    }

    public void setSsalApplActiveList(List<SsalApplActive> ssalApplActiveList) {
        set(PROPERTY_SSALAPPLACTIVELIST, ssalApplActiveList);
    }

    @SuppressWarnings("unchecked")
    public List<SsalApplActive> getSsalApplActiveCCustodianIDList() {
      return (List<SsalApplActive>) get(PROPERTY_SSALAPPLACTIVECCUSTODIANIDLIST);
    }

    public void setSsalApplActiveCCustodianIDList(List<SsalApplActive> ssalApplActiveCCustodianIDList) {
        set(PROPERTY_SSALAPPLACTIVECCUSTODIANIDLIST, ssalApplActiveCCustodianIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SsalAssetReturn> getSsalAssetReturnList() {
      return (List<SsalAssetReturn>) get(PROPERTY_SSALASSETRETURNLIST);
    }

    public void setSsalAssetReturnList(List<SsalAssetReturn> ssalAssetReturnList) {
        set(PROPERTY_SSALASSETRETURNLIST, ssalAssetReturnList);
    }

    @SuppressWarnings("unchecked")
    public List<SsalAssetReturn> getSsalAssetReturnCustodianList() {
      return (List<SsalAssetReturn>) get(PROPERTY_SSALASSETRETURNCUSTODIANLIST);
    }

    public void setSsalAssetReturnCustodianList(List<SsalAssetReturn> ssalAssetReturnCustodianList) {
        set(PROPERTY_SSALASSETRETURNCUSTODIANLIST, ssalAssetReturnCustodianList);
    }

    @SuppressWarnings("unchecked")
    public List<ssamalienate> getSsamAlienateList() {
      return (List<ssamalienate>) get(PROPERTY_SSAMALIENATELIST);
    }

    public void setSsamAlienateList(List<ssamalienate> ssamAlienateList) {
        set(PROPERTY_SSAMALIENATELIST, ssamAlienateList);
    }

    @SuppressWarnings("unchecked")
    public List<ssctcontract> getSsctContractList() {
      return (List<ssctcontract>) get(PROPERTY_SSCTCONTRACTLIST);
    }

    public void setSsctContractList(List<ssctcontract> ssctContractList) {
        set(PROPERTY_SSCTCONTRACTLIST, ssctContractList);
    }

    @SuppressWarnings("unchecked")
    public List<ssctcontract> getSsctContractAdministratorList() {
      return (List<ssctcontract>) get(PROPERTY_SSCTCONTRACTADMINISTRATORLIST);
    }

    public void setSsctContractAdministratorList(List<ssctcontract> ssctContractAdministratorList) {
        set(PROPERTY_SSCTCONTRACTADMINISTRATORLIST, ssctContractAdministratorList);
    }

    @SuppressWarnings("unchecked")
    public List<ssfiFin_payment_detail_v> getSsfiFinPaymentDetailVList() {
      return (List<ssfiFin_payment_detail_v>) get(PROPERTY_SSFIFINPAYMENTDETAILVLIST);
    }

    public void setSsfiFinPaymentDetailVList(List<ssfiFin_payment_detail_v> ssfiFinPaymentDetailVList) {
        set(PROPERTY_SSFIFINPAYMENTDETAILVLIST, ssfiFinPaymentDetailVList);
    }

    @SuppressWarnings("unchecked")
    public List<ssfiFin_payment_detail_v> getSsfiFinPaymentDetailVBusinessPartnerdimList() {
      return (List<ssfiFin_payment_detail_v>) get(PROPERTY_SSFIFINPAYMENTDETAILVBUSINESSPARTNERDIMLIST);
    }

    public void setSsfiFinPaymentDetailVBusinessPartnerdimList(List<ssfiFin_payment_detail_v> ssfiFinPaymentDetailVBusinessPartnerdimList) {
        set(PROPERTY_SSFIFINPAYMENTDETAILVBUSINESSPARTNERDIMLIST, ssfiFinPaymentDetailVBusinessPartnerdimList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceVoyage> getSsflInvoiceVoyageBrokerValueList() {
      return (List<InvoiceVoyage>) get(PROPERTY_SSFLINVOICEVOYAGEBROKERVALUELIST);
    }

    public void setSsflInvoiceVoyageBrokerValueList(List<InvoiceVoyage> ssflInvoiceVoyageBrokerValueList) {
        set(PROPERTY_SSFLINVOICEVOYAGEBROKERVALUELIST, ssflInvoiceVoyageBrokerValueList);
    }

    @SuppressWarnings("unchecked")
    public List<ssflRecap> getSsflRecapList() {
      return (List<ssflRecap>) get(PROPERTY_SSFLRECAPLIST);
    }

    public void setSsflRecapList(List<ssflRecap> ssflRecapList) {
        set(PROPERTY_SSFLRECAPLIST, ssflRecapList);
    }

    @SuppressWarnings("unchecked")
    public List<ssflRecap> getSsflRecapOwnerIDList() {
      return (List<ssflRecap>) get(PROPERTY_SSFLRECAPOWNERIDLIST);
    }

    public void setSsflRecapOwnerIDList(List<ssflRecap> ssflRecapOwnerIDList) {
        set(PROPERTY_SSFLRECAPOWNERIDLIST, ssflRecapOwnerIDList);
    }

    @SuppressWarnings("unchecked")
    public List<ssfwapprovalrange> getSsfwApprovalRangeApprover1stLevelList() {
      return (List<ssfwapprovalrange>) get(PROPERTY_SSFWAPPROVALRANGEAPPROVER1STLEVELLIST);
    }

    public void setSsfwApprovalRangeApprover1stLevelList(List<ssfwapprovalrange> ssfwApprovalRangeApprover1stLevelList) {
        set(PROPERTY_SSFWAPPROVALRANGEAPPROVER1STLEVELLIST, ssfwApprovalRangeApprover1stLevelList);
    }

    @SuppressWarnings("unchecked")
    public List<ssfwapprovalrange> getSsfwApprovalRangeApprover2ndLevelList() {
      return (List<ssfwapprovalrange>) get(PROPERTY_SSFWAPPROVALRANGEAPPROVER2NDLEVELLIST);
    }

    public void setSsfwApprovalRangeApprover2ndLevelList(List<ssfwapprovalrange> ssfwApprovalRangeApprover2ndLevelList) {
        set(PROPERTY_SSFWAPPROVALRANGEAPPROVER2NDLEVELLIST, ssfwApprovalRangeApprover2ndLevelList);
    }

    @SuppressWarnings("unchecked")
    public List<ssfwapprovalrange> getSsfwApprovalRangeApproverSimpleList() {
      return (List<ssfwapprovalrange>) get(PROPERTY_SSFWAPPROVALRANGEAPPROVERSIMPLELIST);
    }

    public void setSsfwApprovalRangeApproverSimpleList(List<ssfwapprovalrange> ssfwApprovalRangeApproverSimpleList) {
        set(PROPERTY_SSFWAPPROVALRANGEAPPROVERSIMPLELIST, ssfwApprovalRangeApproverSimpleList);
    }

    @SuppressWarnings("unchecked")
    public List<ssfworderapproval> getSsfwOrderApprovalApprover1stLevelList() {
      return (List<ssfworderapproval>) get(PROPERTY_SSFWORDERAPPROVALAPPROVER1STLEVELLIST);
    }

    public void setSsfwOrderApprovalApprover1stLevelList(List<ssfworderapproval> ssfwOrderApprovalApprover1stLevelList) {
        set(PROPERTY_SSFWORDERAPPROVALAPPROVER1STLEVELLIST, ssfwOrderApprovalApprover1stLevelList);
    }

    @SuppressWarnings("unchecked")
    public List<ssfworderapproval> getSsfwOrderApprovalApprover2ndLevelList() {
      return (List<ssfworderapproval>) get(PROPERTY_SSFWORDERAPPROVALAPPROVER2NDLEVELLIST);
    }

    public void setSsfwOrderApprovalApprover2ndLevelList(List<ssfworderapproval> ssfwOrderApprovalApprover2ndLevelList) {
        set(PROPERTY_SSFWORDERAPPROVALAPPROVER2NDLEVELLIST, ssfwOrderApprovalApprover2ndLevelList);
    }

    @SuppressWarnings("unchecked")
    public List<sshrchintext> getSshrChIntExtInternalList() {
      return (List<sshrchintext>) get(PROPERTY_SSHRCHINTEXTINTERNALLIST);
    }

    public void setSshrChIntExtInternalList(List<sshrchintext> sshrChIntExtInternalList) {
        set(PROPERTY_SSHRCHINTEXTINTERNALLIST, sshrChIntExtInternalList);
    }

    @SuppressWarnings("unchecked")
    public List<sshrchintext> getSshrChIntExtExternalList() {
      return (List<sshrchintext>) get(PROPERTY_SSHRCHINTEXTEXTERNALLIST);
    }

    public void setSshrChIntExtExternalList(List<sshrchintext> sshrChIntExtExternalList) {
        set(PROPERTY_SSHRCHINTEXTEXTERNALLIST, sshrChIntExtExternalList);
    }

    @SuppressWarnings("unchecked")
    public List<SshrEmployeeLanguage> getSshrEmployeeLanguageList() {
      return (List<SshrEmployeeLanguage>) get(PROPERTY_SSHREMPLOYEELANGUAGELIST);
    }

    public void setSshrEmployeeLanguageList(List<SshrEmployeeLanguage> sshrEmployeeLanguageList) {
        set(PROPERTY_SSHREMPLOYEELANGUAGELIST, sshrEmployeeLanguageList);
    }

    @SuppressWarnings("unchecked")
    public List<SshrEmployeeProject> getSshrEmployeeProjectList() {
      return (List<SshrEmployeeProject>) get(PROPERTY_SSHREMPLOYEEPROJECTLIST);
    }

    public void setSshrEmployeeProjectList(List<SshrEmployeeProject> sshrEmployeeProjectList) {
        set(PROPERTY_SSHREMPLOYEEPROJECTLIST, sshrEmployeeProjectList);
    }

    @SuppressWarnings("unchecked")
    public List<SshrEmployeePromotion> getSshrEmployeePromotionList() {
      return (List<SshrEmployeePromotion>) get(PROPERTY_SSHREMPLOYEEPROMOTIONLIST);
    }

    public void setSshrEmployeePromotionList(List<SshrEmployeePromotion> sshrEmployeePromotionList) {
        set(PROPERTY_SSHREMPLOYEEPROMOTIONLIST, sshrEmployeePromotionList);
    }

    @SuppressWarnings("unchecked")
    public List<SshrExaminationTest> getSshrExaminationTestList() {
      return (List<SshrExaminationTest>) get(PROPERTY_SSHREXAMINATIONTESTLIST);
    }

    public void setSshrExaminationTestList(List<SshrExaminationTest> sshrExaminationTestList) {
        set(PROPERTY_SSHREXAMINATIONTESTLIST, sshrExaminationTestList);
    }

    @SuppressWarnings("unchecked")
    public List<sshrJob> getSshrJobList() {
      return (List<sshrJob>) get(PROPERTY_SSHRJOBLIST);
    }

    public void setSshrJobList(List<sshrJob> sshrJobList) {
        set(PROPERTY_SSHRJOBLIST, sshrJobList);
    }

    @SuppressWarnings("unchecked")
    public List<sshrEducation> getSshrQeducationList() {
      return (List<sshrEducation>) get(PROPERTY_SSHRQEDUCATIONLIST);
    }

    public void setSshrQeducationList(List<sshrEducation> sshrQeducationList) {
        set(PROPERTY_SSHRQEDUCATIONLIST, sshrQeducationList);
    }

    @SuppressWarnings("unchecked")
    public List<sshrSkills> getSshrQskillsList() {
      return (List<sshrSkills>) get(PROPERTY_SSHRQSKILLSLIST);
    }

    public void setSshrQskillsList(List<sshrSkills> sshrQskillsList) {
        set(PROPERTY_SSHRQSKILLSLIST, sshrQskillsList);
    }

    @SuppressWarnings("unchecked")
    public List<sshrWorkExpirence> getSshrQworkExpirenceList() {
      return (List<sshrWorkExpirence>) get(PROPERTY_SSHRQWORKEXPIRENCELIST);
    }

    public void setSshrQworkExpirenceList(List<sshrWorkExpirence> sshrQworkExpirenceList) {
        set(PROPERTY_SSHRQWORKEXPIRENCELIST, sshrQworkExpirenceList);
    }

    @SuppressWarnings("unchecked")
    public List<sshrReportTo> getSshrReporttoList() {
      return (List<sshrReportTo>) get(PROPERTY_SSHRREPORTTOLIST);
    }

    public void setSshrReporttoList(List<sshrReportTo> sshrReporttoList) {
        set(PROPERTY_SSHRREPORTTOLIST, sshrReporttoList);
    }

    @SuppressWarnings("unchecked")
    public List<sshrReportTo> getSshrReporttoBossList() {
      return (List<sshrReportTo>) get(PROPERTY_SSHRREPORTTOBOSSLIST);
    }

    public void setSshrReporttoBossList(List<sshrReportTo> sshrReporttoBossList) {
        set(PROPERTY_SSHRREPORTTOBOSSLIST, sshrReporttoBossList);
    }

    @SuppressWarnings("unchecked")
    public List<sshrReportTo> getSshrReporttoBossAllternatingList() {
      return (List<sshrReportTo>) get(PROPERTY_SSHRREPORTTOBOSSALLTERNATINGLIST);
    }

    public void setSshrReporttoBossAllternatingList(List<sshrReportTo> sshrReporttoBossAllternatingList) {
        set(PROPERTY_SSHRREPORTTOBOSSALLTERNATINGLIST, sshrReporttoBossAllternatingList);
    }

    @SuppressWarnings("unchecked")
    public List<sshrSalaryComponent> getSshrSalaryComponentList() {
      return (List<sshrSalaryComponent>) get(PROPERTY_SSHRSALARYCOMPONENTLIST);
    }

    public void setSshrSalaryComponentList(List<sshrSalaryComponent> sshrSalaryComponentList) {
        set(PROPERTY_SSHRSALARYCOMPONENTLIST, sshrSalaryComponentList);
    }

    @SuppressWarnings("unchecked")
    public List<sshrtcourses> getSshrTcoursesList() {
      return (List<sshrtcourses>) get(PROPERTY_SSHRTCOURSESLIST);
    }

    public void setSshrTcoursesList(List<sshrtcourses> sshrTcoursesList) {
        set(PROPERTY_SSHRTCOURSESLIST, sshrTcoursesList);
    }

    @SuppressWarnings("unchecked")
    public List<SshrTrainingCalendar> getSshrTrainingCalendarList() {
      return (List<SshrTrainingCalendar>) get(PROPERTY_SSHRTRAININGCALENDARLIST);
    }

    public void setSshrTrainingCalendarList(List<SshrTrainingCalendar> sshrTrainingCalendarList) {
        set(PROPERTY_SSHRTRAININGCALENDARLIST, sshrTrainingCalendarList);
    }

    @SuppressWarnings("unchecked")
    public List<sshrtrainingline> getSshrTraininglineList() {
      return (List<sshrtrainingline>) get(PROPERTY_SSHRTRAININGLINELIST);
    }

    public void setSshrTraininglineList(List<sshrtrainingline> sshrTraininglineList) {
        set(PROPERTY_SSHRTRAININGLINELIST, sshrTraininglineList);
    }

    @SuppressWarnings("unchecked")
    public List<sspdpctdistemp> getSspdPctdistEmpList() {
      return (List<sspdpctdistemp>) get(PROPERTY_SSPDPCTDISTEMPLIST);
    }

    public void setSspdPctdistEmpList(List<sspdpctdistemp> sspdPctdistEmpList) {
        set(PROPERTY_SSPDPCTDISTEMPLIST, sspdPctdistEmpList);
    }

    @SuppressWarnings("unchecked")
    public List<ssprattendance> getSsprAttendanceList() {
      return (List<ssprattendance>) get(PROPERTY_SSPRATTENDANCELIST);
    }

    public void setSsprAttendanceList(List<ssprattendance> ssprAttendanceList) {
        set(PROPERTY_SSPRATTENDANCELIST, ssprAttendanceList);
    }

    @SuppressWarnings("unchecked")
    public List<Costemployee> getSsprCostemployeeList() {
      return (List<Costemployee>) get(PROPERTY_SSPRCOSTEMPLOYEELIST);
    }

    public void setSsprCostemployeeList(List<Costemployee> ssprCostemployeeList) {
        set(PROPERTY_SSPRCOSTEMPLOYEELIST, ssprCostemployeeList);
    }

    @SuppressWarnings("unchecked")
    public List<CumulativeConcept> getSsprCumulativeconceptList() {
      return (List<CumulativeConcept>) get(PROPERTY_SSPRCUMULATIVECONCEPTLIST);
    }

    public void setSsprCumulativeconceptList(List<CumulativeConcept> ssprCumulativeconceptList) {
        set(PROPERTY_SSPRCUMULATIVECONCEPTLIST, ssprCumulativeconceptList);
    }

    @SuppressWarnings("unchecked")
    public List<sspremployeesettlement> getSsprEmployeesettlementList() {
      return (List<sspremployeesettlement>) get(PROPERTY_SSPREMPLOYEESETTLEMENTLIST);
    }

    public void setSsprEmployeesettlementList(List<sspremployeesettlement> ssprEmployeesettlementList) {
        set(PROPERTY_SSPREMPLOYEESETTLEMENTLIST, ssprEmployeesettlementList);
    }

    @SuppressWarnings("unchecked")
    public List<ssprformulary107detailv> getSsprFormulary107DetailVList() {
      return (List<ssprformulary107detailv>) get(PROPERTY_SSPRFORMULARY107DETAILVLIST);
    }

    public void setSsprFormulary107DetailVList(List<ssprformulary107detailv> ssprFormulary107DetailVList) {
        set(PROPERTY_SSPRFORMULARY107DETAILVLIST, ssprFormulary107DetailVList);
    }

    @SuppressWarnings("unchecked")
    public List<ssprformularyline107> getSsprFormularyline107List() {
      return (List<ssprformularyline107>) get(PROPERTY_SSPRFORMULARYLINE107LIST);
    }

    public void setSsprFormularyline107List(List<ssprformularyline107> ssprFormularyline107List) {
        set(PROPERTY_SSPRFORMULARYLINE107LIST, ssprFormularyline107List);
    }

    @SuppressWarnings("unchecked")
    public List<Incometotal> getSsprIncometotalList() {
      return (List<Incometotal>) get(PROPERTY_SSPRINCOMETOTALLIST);
    }

    public void setSsprIncometotalList(List<Incometotal> ssprIncometotalList) {
        set(PROPERTY_SSPRINCOMETOTALLIST, ssprIncometotalList);
    }

    @SuppressWarnings("unchecked")
    public List<ssprleaveconfdefault> getSsprLeaveConfDefaultList() {
      return (List<ssprleaveconfdefault>) get(PROPERTY_SSPRLEAVECONFDEFAULTLIST);
    }

    public void setSsprLeaveConfDefaultList(List<ssprleaveconfdefault> ssprLeaveConfDefaultList) {
        set(PROPERTY_SSPRLEAVECONFDEFAULTLIST, ssprLeaveConfDefaultList);
    }

    @SuppressWarnings("unchecked")
    public List<sspr_leave_group> getSsprLeaveGroupList() {
      return (List<sspr_leave_group>) get(PROPERTY_SSPRLEAVEGROUPLIST);
    }

    public void setSsprLeaveGroupList(List<sspr_leave_group> ssprLeaveGroupList) {
        set(PROPERTY_SSPRLEAVEGROUPLIST, ssprLeaveGroupList);
    }

    @SuppressWarnings("unchecked")
    public List<ssprleavehrmanagement> getSsprLeaveHrManagementList() {
      return (List<ssprleavehrmanagement>) get(PROPERTY_SSPRLEAVEHRMANAGEMENTLIST);
    }

    public void setSsprLeaveHrManagementList(List<ssprleavehrmanagement> ssprLeaveHrManagementList) {
        set(PROPERTY_SSPRLEAVEHRMANAGEMENTLIST, ssprLeaveHrManagementList);
    }

    @SuppressWarnings("unchecked")
    public List<ssprloans> getSsprLoansList() {
      return (List<ssprloans>) get(PROPERTY_SSPRLOANSLIST);
    }

    public void setSsprLoansList(List<ssprloans> ssprLoansList) {
        set(PROPERTY_SSPRLOANSLIST, ssprLoansList);
    }

    @SuppressWarnings("unchecked")
    public List<sspr_payrollemp> getSsprPayrollEmpList() {
      return (List<sspr_payrollemp>) get(PROPERTY_SSPRPAYROLLEMPLIST);
    }

    public void setSsprPayrollEmpList(List<sspr_payrollemp> ssprPayrollEmpList) {
        set(PROPERTY_SSPRPAYROLLEMPLIST, ssprPayrollEmpList);
    }

    @SuppressWarnings("unchecked")
    public List<ssprprofits> getSsprProfitsList() {
      return (List<ssprprofits>) get(PROPERTY_SSPRPROFITSLIST);
    }

    public void setSsprProfitsList(List<ssprprofits> ssprProfitsList) {
        set(PROPERTY_SSPRPROFITSLIST, ssprProfitsList);
    }

    @SuppressWarnings("unchecked")
    public List<ssprreadmissions> getSsprReadmissionsList() {
      return (List<ssprreadmissions>) get(PROPERTY_SSPRREADMISSIONSLIST);
    }

    public void setSsprReadmissionsList(List<ssprreadmissions> ssprReadmissionsList) {
        set(PROPERTY_SSPRREADMISSIONSLIST, ssprReadmissionsList);
    }

    @SuppressWarnings("unchecked")
    public List<sspr_settlement> getSsprSettlementList() {
      return (List<sspr_settlement>) get(PROPERTY_SSPRSETTLEMENTLIST);
    }

    public void setSsprSettlementList(List<sspr_settlement> ssprSettlementList) {
        set(PROPERTY_SSPRSETTLEMENTLIST, ssprSettlementList);
    }

    @SuppressWarnings("unchecked")
    public List<ssprutilities> getSsprUtilitiesList() {
      return (List<ssprutilities>) get(PROPERTY_SSPRUTILITIESLIST);
    }

    public void setSsprUtilitiesList(List<ssprutilities> ssprUtilitiesList) {
        set(PROPERTY_SSPRUTILITIESLIST, ssprUtilitiesList);
    }

    @SuppressWarnings("unchecked")
    public List<SsprUtilityDetail> getSsprUtilityDetailList() {
      return (List<SsprUtilityDetail>) get(PROPERTY_SSPRUTILITYDETAILLIST);
    }

    public void setSsprUtilityDetailList(List<SsprUtilityDetail> ssprUtilityDetailList) {
        set(PROPERTY_SSPRUTILITYDETAILLIST, ssprUtilityDetailList);
    }

    @SuppressWarnings("unchecked")
    public List<ssprvacations> getSsprVacationsList() {
      return (List<ssprvacations>) get(PROPERTY_SSPRVACATIONSLIST);
    }

    public void setSsprVacationsList(List<ssprvacations> ssprVacationsList) {
        set(PROPERTY_SSPRVACATIONSLIST, ssprVacationsList);
    }

    @SuppressWarnings("unchecked")
    public List<ssrerefundinvoice> getSsreRefundinvoiceList() {
      return (List<ssrerefundinvoice>) get(PROPERTY_SSREREFUNDINVOICELIST);
    }

    public void setSsreRefundinvoiceList(List<ssrerefundinvoice> ssreRefundinvoiceList) {
        set(PROPERTY_SSREREFUNDINVOICELIST, ssreRefundinvoiceList);
    }

    @SuppressWarnings("unchecked")
    public List<ssve_budget_details_v> getSsveBudgetDetailsVCBpartnerOrdIDList() {
      return (List<ssve_budget_details_v>) get(PROPERTY_SSVEBUDGETDETAILSVCBPARTNERORDIDLIST);
    }

    public void setSsveBudgetDetailsVCBpartnerOrdIDList(List<ssve_budget_details_v> ssveBudgetDetailsVCBpartnerOrdIDList) {
        set(PROPERTY_SSVEBUDGETDETAILSVCBPARTNERORDIDLIST, ssveBudgetDetailsVCBpartnerOrdIDList);
    }

    @SuppressWarnings("unchecked")
    public List<ssve_budget_details_v> getSsveBudgetDetailsVCBpartnerInvIDList() {
      return (List<ssve_budget_details_v>) get(PROPERTY_SSVEBUDGETDETAILSVCBPARTNERINVIDLIST);
    }

    public void setSsveBudgetDetailsVCBpartnerInvIDList(List<ssve_budget_details_v> ssveBudgetDetailsVCBpartnerInvIDList) {
        set(PROPERTY_SSVEBUDGETDETAILSVCBPARTNERINVIDLIST, ssveBudgetDetailsVCBpartnerInvIDList);
    }

    @SuppressWarnings("unchecked")
    public List<ssve_budget_details_v> getSsveBudgetDetailsVCBpartnerIdPayList() {
      return (List<ssve_budget_details_v>) get(PROPERTY_SSVEBUDGETDETAILSVCBPARTNERIDPAYLIST);
    }

    public void setSsveBudgetDetailsVCBpartnerIdPayList(List<ssve_budget_details_v> ssveBudgetDetailsVCBpartnerIdPayList) {
        set(PROPERTY_SSVEBUDGETDETAILSVCBPARTNERIDPAYLIST, ssveBudgetDetailsVCBpartnerIdPayList);
    }

    @SuppressWarnings("unchecked")
    public List<ssve_budget_details_v> getSsveBudgetDetailsVCBpartnerIdViaList() {
      return (List<ssve_budget_details_v>) get(PROPERTY_SSVEBUDGETDETAILSVCBPARTNERIDVIALIST);
    }

    public void setSsveBudgetDetailsVCBpartnerIdViaList(List<ssve_budget_details_v> ssveBudgetDetailsVCBpartnerIdViaList) {
        set(PROPERTY_SSVEBUDGETDETAILSVCBPARTNERIDVIALIST, ssveBudgetDetailsVCBpartnerIdViaList);
    }

    @SuppressWarnings("unchecked")
    public List<ssve_viatical_details_v> getSsveViaticalDetailsVList() {
      return (List<ssve_viatical_details_v>) get(PROPERTY_SSVEVIATICALDETAILSVLIST);
    }

    public void setSsveViaticalDetailsVList(List<ssve_viatical_details_v> ssveViaticalDetailsVList) {
        set(PROPERTY_SSVEVIATICALDETAILSVLIST, ssveViaticalDetailsVList);
    }

    @SuppressWarnings("unchecked")
    public List<SswhWithhCardCredit> getSswhWithhCardCreditList() {
      return (List<SswhWithhCardCredit>) get(PROPERTY_SSWHWITHHCARDCREDITLIST);
    }

    public void setSswhWithhCardCreditList(List<SswhWithhCardCredit> sswhWithhCardCreditList) {
        set(PROPERTY_SSWHWITHHCARDCREDITLIST, sswhWithhCardCreditList);
    }

}
