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
package org.openbravo.model.common.enterprise;

import com.sidesoft.ecuador.asset.allocation.SsalApplActive;
import com.sidesoft.ecuador.asset.allocation.SsalAssetReturn;
import com.sidesoft.ecuador.asset.move.ssamalienate;
import com.sidesoft.flopec.budget.data.SFBBudgetCertificate;
import com.sidesoft.flopec.budget.data.SFBBudgetDoctype;
import com.sidesoft.flopec.budget.data.sfbbudgetaddline;
import com.sidesoft.hrm.payroll.Payroll;
import com.sidesoft.hrm.payroll.advanced.SfprMovementType;
import com.sidesoft.hrm.payroll.sspr_settlement;
import com.sidesoft.hrm.payroll.sspremployeesettlement;
import com.sidesoft.hrm.payroll.ssprleaveemp;
import com.sidesoft.hrm.payroll.ssprloans;
import com.sidesoft.hrm.payroll.ssprpayrollpayment;
import com.sidesoft.hrm.payroll.tenth.SSPHTenthSettlement;
import com.sidesoft.localization.ecuador.finances.SsfiFinancialUser;
import com.sidesoft.localization.ecuador.withholdings.Authorization;
import com.sidesoft.localization.ecuador.withholdings.Receipt;
import com.sidesoft.localization.ecuador.withholdings.SSWHPos;
import com.sidesoft.localization.ecuador.withholdings.SswhWithhCardCredit;
import com.sidesoft.localization.ecuador.withholdings.SswhWithholdingsVoided;
import com.sidesoft.localization.ecuador.withholdings.sswhtypereceipt;

import ec.com.sidesoft.contract.ssctcontract;
import ec.com.sidesoft.custom.budget.direct.SCBDBudgetDirect;
import ec.com.sidesoft.custom.payments.partialpayment.SSPPPAYMENTS;
import ec.com.sidesoft.custom.payroll.partialpayment.scppapprovalpayment;
import ec.com.sidesoft.custom.payroll.reports.sscprreportcertificate;
import ec.com.sidesoft.custom.reports.SescrTemplateReport;
import ec.com.sidesoft.custom.signature.SCSDCSignaturesperdoc;
import ec.com.sidesoft.localization.ecuador.viatical.SSVEViatical;
import ec.com.sidesoft.localization.ecuador.viatical.SSVEViaticalSettlement;
import ec.com.sidesoft.localization.ecuador.withholdingssales.SSWSConfig;
import ec.com.sidesoft.localization.ecuador.withholdingssales.SSWSWithholdingSale;
import ec.com.sidesoft.localization.flow.ssfwapprovaldoctype;
import ec.com.sidesoft.poa.pac.EcsppPOA;
import ec.com.sidesoft.quick.billing.SqbConfigQuickBilling;
import ec.com.sidesoft.quick.billing.SqbQuickBilling;
import ec.com.sidesoft.report.salesinvoice.SRSISalesInvoiceV;
import ec.com.sidesoft.secondary.accounting.AccountingFactSecondary;
import ec.com.sidesoft.secondary.accounting.SSACCTJOURNAL;
import ec.com.sidesoft.ws.invoicecreate.data.SWSICConfig;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openbravo.advpaymentmngt.APRM_Reconciliation_v;
import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.datamodel.Table;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.ad.utility.Sequence;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.common.invoice.InvoiceV2;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.financialmgmt.accounting.AccountingFact;
import org.openbravo.model.financialmgmt.assetmgmt.Amortization;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
import org.openbravo.model.financialmgmt.gl.GLCategory;
import org.openbravo.model.financialmgmt.gl.GLJournal;
import org.openbravo.model.financialmgmt.payment.DPManagement;
import org.openbravo.model.financialmgmt.payment.DoubtfulDebt;
import org.openbravo.model.financialmgmt.payment.FIN_BankStatement;
import org.openbravo.model.financialmgmt.payment.FIN_Payment;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentProposal;
import org.openbravo.model.financialmgmt.payment.FIN_Reconciliation;
import org.openbravo.model.financialmgmt.payment.Settlement;
import org.openbravo.model.financialmgmt.tax.TaxRegisterTypeLines;
import org.openbravo.model.manufacturing.transaction.WorkRequirement;
import org.openbravo.model.materialmgmt.cost.CostAdjustment;
import org.openbravo.model.materialmgmt.cost.InventoryAmountUpdate;
import org.openbravo.model.materialmgmt.cost.LandedCost;
import org.openbravo.model.materialmgmt.cost.LandedCostCost;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOut;
import org.openbravo.model.pos.ExternalPOS;
/**
 * Entity class for entity DocumentType (stored in table C_DocType).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class DocumentType extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_DocType";
    public static final String ENTITY_NAME = "DocumentType";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_PRINTTEXT = "printText";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_DOCUMENTCATEGORY = "documentCategory";
    public static final String PROPERTY_SALESTRANSACTION = "salesTransaction";
    public static final String PROPERTY_SOSUBTYPE = "sOSubType";
    public static final String PROPERTY_DOCUMENTTYPEFORSHIPMENT = "documentTypeForShipment";
    public static final String PROPERTY_DOCUMENTTYPEFORINVOICE = "documentTypeForInvoice";
    public static final String PROPERTY_SEQUENCEDDOCUMENT = "sequencedDocument";
    public static final String PROPERTY_DOCUMENTSEQUENCE = "documentSequence";
    public static final String PROPERTY_GLCATEGORY = "gLCategory";
    public static final String PROPERTY_COMMENTS = "comments";
    public static final String PROPERTY_DEFAULT = "default";
    public static final String PROPERTY_NUMBEROFCOPIES = "numberOfCopies";
    public static final String PROPERTY_TABLE = "table";
    public static final String PROPERTY_FILTERBYORGANIZATION = "filterByOrganization";
    public static final String PROPERTY_DOCUMENTCANCELLED = "documentCancelled";
    public static final String PROPERTY_EXPENSE = "expense";
    public static final String PROPERTY_REVERSAL = "reversal";
    public static final String PROPERTY_RETURN = "return";
    public static final String PROPERTY_DOCUMENTTYPEFORORDER = "documentTypeForOrder";
    public static final String PROPERTY_SSWHIMPLEMENTAUTORIZA = "sswhImplementautoriza";
    public static final String PROPERTY_SSWHISWITHHOLDING = "sswhIswithholding";
    public static final String PROPERTY_SSWHISCLIENT = "sswhIsclient";
    public static final String PROPERTY_SSWHISWITHHOLDINGSALE = "sswhIswithholdingsale";
    public static final String PROPERTY_SSWHTYPERECEIPT = "sswhTypereceipt";
    public static final String PROPERTY_SSWHDOCTYPE = "sswhDoctype";
    public static final String PROPERTY_SSWHAFECTEDZONE = "sswhAfectedZone";
    public static final String PROPERTY_SSWHCODE = "sswhCode";
    public static final String PROPERTY_SSWHPERCENTAGE = "sSWHPercentage";
    public static final String PROPERTY_EEIEDOCTYPE = "eeiEdocType";
    public static final String PROPERTY_SSFLPRINT = "ssflPrint";
    public static final String PROPERTY_EEIISEDOC = "eeiIsEdoc";
    public static final String PROPERTY_EEIREMISSIONFORSALES = "eeiRemissionForSales";
    public static final String PROPERTY_SSWHEXTWITHH = "sswhExtWithh";
    public static final String PROPERTY_SSFIISCROSSING = "ssfiIscrossing";
    public static final String PROPERTY_SSWHWITHHCODE = "sswhWithhCode";
    public static final String PROPERTY_EEIKEYACCESSGENERATED = "eeiKeyAccessGenerated";
    public static final String PROPERTY_SSPEWEXCLFORWITHHOLD = "sspewExclforwithhold";
    public static final String PROPERTY_ECSAPSUBJECTAUTHORIZATION = "ecsapSubjectAuthorization";
    public static final String PROPERTY_EEIDESCRIPTIONFIELDS = "eeiDescriptionfields";
    public static final String PROPERTY_EEIISREFUND = "eeiIsrefund";
    public static final String PROPERTY_EEIREFUNDCODE = "eeiRefundCode";
    public static final String PROPERTY_APRMRECONCILIATIONLIST = "aPRMReconciliationList";
    public static final String PROPERTY_BUSINESSPARTNEREMOPCRMDOCTYPEIDLIST = "businessPartnerEMOpcrmDoctypeIDList";
    public static final String PROPERTY_COSTADJUSTMENTLIST = "costAdjustmentList";
    public static final String PROPERTY_DOCUMENTTEMPLATELIST = "documentTemplateList";
    public static final String PROPERTY_DOCUMENTTYPEDOCUMENTTYPEFORSHIPMENTLIST = "documentTypeDocumentTypeForShipmentList";
    public static final String PROPERTY_DOCUMENTTYPEDOCUMENTTYPEFORINVOICELIST = "documentTypeDocumentTypeForInvoiceList";
    public static final String PROPERTY_DOCUMENTTYPEDOCUMENTCANCELLEDLIST = "documentTypeDocumentCancelledList";
    public static final String PROPERTY_DOCUMENTTYPEDOCUMENTTYPEFORORDERLIST = "documentTypeDocumentTypeForOrderList";
    public static final String PROPERTY_DOCUMENTTYPETRLLIST = "documentTypeTrlList";
    public static final String PROPERTY_EXTERNALPOSLIST = "externalPOSList";
    public static final String PROPERTY_FINBANKSTATEMENTLIST = "fINBankStatementList";
    public static final String PROPERTY_FINDOUBTFULDEBTLIST = "fINDoubtfulDebtList";
    public static final String PROPERTY_FINPAYMENTLIST = "fINPaymentList";
    public static final String PROPERTY_FINPAYMENTPROPOSALLIST = "fINPaymentProposalList";
    public static final String PROPERTY_FINPAYMENTPROPOSALEMSLPPPAYMENTDOCTYPEIDLIST = "fINPaymentProposalEMSlppPaymentDoctypeIDList";
    public static final String PROPERTY_FINRECONCILIATIONLIST = "fINReconciliationList";
    public static final String PROPERTY_FINANCIALMGMTACCOUNTINGFACTLIST = "financialMgmtAccountingFactList";
    public static final String PROPERTY_FINANCIALMGMTAMORTIZATIONLIST = "financialMgmtAmortizationList";
    public static final String PROPERTY_FINANCIALMGMTASSETEMSSALCDOCTYPEIDLIST = "financialMgmtAssetEMSsalCDoctypeIDList";
    public static final String PROPERTY_FINANCIALMGMTDPMANAGEMENTLIST = "financialMgmtDPManagementList";
    public static final String PROPERTY_FINANCIALMGMTGLJOURNALLIST = "financialMgmtGLJournalList";
    public static final String PROPERTY_FINANCIALMGMTSETTLEMENTLIST = "financialMgmtSettlementList";
    public static final String PROPERTY_FINANCIALMGMTTAXREGISTERTYPELINESLIST = "financialMgmtTaxRegisterTypeLinesList";
    public static final String PROPERTY_INVENTORYAMOUNTUPDATELIST = "inventoryAmountUpdateList";
    public static final String PROPERTY_INVOICELIST = "invoiceList";
    public static final String PROPERTY_INVOICETRANSACTIONDOCUMENTLIST = "invoiceTransactionDocumentList";
    public static final String PROPERTY_INVOICEEMSSWHCDOCTYPEIDLIST = "invoiceEMSswhCDoctypeIDList";
    public static final String PROPERTY_INVOICEV2LIST = "invoiceV2List";
    public static final String PROPERTY_INVOICEV2TRANSACTIONDOCUMENTLIST = "invoiceV2TransactionDocumentList";
    public static final String PROPERTY_LANDEDCOSTLIST = "landedCostList";
    public static final String PROPERTY_LANDEDCOSTCOSTLIST = "landedCostCostList";
    public static final String PROPERTY_MANUFACTURINGWORKREQUIREMENTLIST = "manufacturingWorkRequirementList";
    public static final String PROPERTY_MATERIALMGMTSHIPMENTINOUTLIST = "materialMgmtShipmentInOutList";
    public static final String PROPERTY_ORDERLIST = "orderList";
    public static final String PROPERTY_ORDERTRANSACTIONDOCUMENTLIST = "orderTransactionDocumentList";
    public static final String PROPERTY_SCBDBUDGETDIRECTLIST = "sCBDBudgetDirectList";
    public static final String PROPERTY_SCSDCSIGNATURESPERDOCLIST = "sCSDCSignaturesperdocList";
    public static final String PROPERTY_SRSISALESINVOICEVLIST = "sRSISalesInvoiceVList";
    public static final String PROPERTY_SSACCTACCOUNTINGFACTSECONDARYLIST = "sSACCTAccountingFactSecondaryList";
    public static final String PROPERTY_SSACCTJOURNALLIST = "sSACCTJOURNALList";
    public static final String PROPERTY_SSPHTENTHSETTLEMENTLIST = "sSPHTenthSettlementList";
    public static final String PROPERTY_SSPPPAYMENTSLIST = "sSPPPAYMENTSList";
    public static final String PROPERTY_SSPPPAYMENTSCDOCTYPEPAYMENTIDLIST = "sSPPPAYMENTSCDoctypePaymentIDList";
    public static final String PROPERTY_SSPRLEAVEEMPLIST = "sSPRLeaveEmpList";
    public static final String PROPERTY_SSPRPAYROLLLIST = "sSPRPayrollList";
    public static final String PROPERTY_SSVEVIATICALLIST = "sSVEViaticalList";
    public static final String PROPERTY_SSVEVIATICALSETTLEMENTLIST = "sSVEViaticalSettlementList";
    public static final String PROPERTY_SSWHAUTHORIZATIONLIST = "sSWHAuthorizationList";
    public static final String PROPERTY_SSWHPOSLIST = "sSWHPosList";
    public static final String PROPERTY_SSWHRECEIPTLIST = "sSWHReceiptList";
    public static final String PROPERTY_SSWSCONFIGLIST = "sSWSConfigList";
    public static final String PROPERTY_SSWSWITHHOLDINGSALELIST = "sSWSWithholdingSaleList";
    public static final String PROPERTY_SWSICCONFIGLIST = "sWSICConfigList";
    public static final String PROPERTY_SWSICCONFIGCDOCTYPEPAYMENTINIDLIST = "sWSICConfigCDoctypePaymentInIDList";
    public static final String PROPERTY_ECSPPPOALIST = "ecsppPoaList";
    public static final String PROPERTY_SCPPAPPROVALPAYMENTLIST = "scppApprovalpaymentList";
    public static final String PROPERTY_SESCRTEMPLATEREPORTLIST = "sescrTemplateReportList";
    public static final String PROPERTY_SFBBUDGETADDLINELIST = "sfbBudgetAddlineList";
    public static final String PROPERTY_SFBBUDGETCERTIFICATELIST = "sfbBudgetCertificateList";
    public static final String PROPERTY_SFBBUDGETDOCTYPELIST = "sfbBudgetDoctypeList";
    public static final String PROPERTY_SFPRMOVEMENTTYPELIST = "sfprMovementTypeList";
    public static final String PROPERTY_SQBCONFIGQUICKBILLINGLIST = "sqbConfigQuickbillingList";
    public static final String PROPERTY_SQBCONFIGQUICKBILLINGCDOCTYPEPAYMENTINIDLIST = "sqbConfigQuickbillingCDoctypePaymentInIDList";
    public static final String PROPERTY_SQBQUICKBILLINGLIST = "sqbQuickbillingList";
    public static final String PROPERTY_SSALAPPLACTIVELIST = "ssalApplActiveList";
    public static final String PROPERTY_SSALAPPLACTIVECDOCTYPEIDRETURNLIST = "ssalApplActiveCDoctypeIdReturnList";
    public static final String PROPERTY_SSALASSETRETURNLIST = "ssalAssetReturnList";
    public static final String PROPERTY_SSAMALIENATELIST = "ssamAlienateList";
    public static final String PROPERTY_SSCPRREPORTCERTIFICATELIST = "sscprReportcertificateList";
    public static final String PROPERTY_SSCTCONTRACTLIST = "ssctContractList";
    public static final String PROPERTY_SSFIFINANCIALUSERLIST = "ssfiFinancialUserList";
    public static final String PROPERTY_SSFWAPPROVALDOCTYPELIST = "ssfwApprovalDoctypeList";
    public static final String PROPERTY_SSPREMPLOYEESETTLEMENTLIST = "ssprEmployeesettlementList";
    public static final String PROPERTY_SSPRLOANSEMSFPRCDOCTYPEIDLIST = "ssprLoansEMSfprCDoctypeIDList";
    public static final String PROPERTY_SSPRPAYROLLPAYMENTLIST = "ssprPayrollpaymentList";
    public static final String PROPERTY_SSPRSETTLEMENTLIST = "ssprSettlementList";
    public static final String PROPERTY_SSWHWITHHCARDCREDITLIST = "sswhWithhCardCreditList";
    public static final String PROPERTY_SSWHWITHHOLDINGSVOIDEDLIST = "sswhWithholdingsVoidedList";
    public static final String PROPERTY_SSWHWITHHOLDINGSVOIDEDCDOCTYPE2IDLIST = "sswhWithholdingsVoidedCDoctype2IDList";

    public DocumentType() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_SALESTRANSACTION, false);
        setDefaultValue(PROPERTY_SEQUENCEDDOCUMENT, true);
        setDefaultValue(PROPERTY_DEFAULT, false);
        setDefaultValue(PROPERTY_NUMBEROFCOPIES, (long) 1);
        setDefaultValue(PROPERTY_FILTERBYORGANIZATION, false);
        setDefaultValue(PROPERTY_EXPENSE, false);
        setDefaultValue(PROPERTY_REVERSAL, false);
        setDefaultValue(PROPERTY_RETURN, false);
        setDefaultValue(PROPERTY_SSWHIMPLEMENTAUTORIZA, false);
        setDefaultValue(PROPERTY_SSWHISWITHHOLDING, false);
        setDefaultValue(PROPERTY_SSWHISCLIENT, false);
        setDefaultValue(PROPERTY_SSWHISWITHHOLDINGSALE, false);
        setDefaultValue(PROPERTY_SSWHAFECTEDZONE, false);
        setDefaultValue(PROPERTY_EEIEDOCTYPE, "01");
        setDefaultValue(PROPERTY_SSFLPRINT, "N");
        setDefaultValue(PROPERTY_EEIISEDOC, false);
        setDefaultValue(PROPERTY_EEIREMISSIONFORSALES, false);
        setDefaultValue(PROPERTY_SSWHEXTWITHH, false);
        setDefaultValue(PROPERTY_SSFIISCROSSING, false);
        setDefaultValue(PROPERTY_EEIKEYACCESSGENERATED, false);
        setDefaultValue(PROPERTY_SSPEWEXCLFORWITHHOLD, false);
        setDefaultValue(PROPERTY_ECSAPSUBJECTAUTHORIZATION, false);
        setDefaultValue(PROPERTY_EEIDESCRIPTIONFIELDS, "DEDA");
        setDefaultValue(PROPERTY_EEIISREFUND, false);
        setDefaultValue(PROPERTY_APRMRECONCILIATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_BUSINESSPARTNEREMOPCRMDOCTYPEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_COSTADJUSTMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_DOCUMENTTEMPLATELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_DOCUMENTTYPEDOCUMENTTYPEFORSHIPMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_DOCUMENTTYPEDOCUMENTTYPEFORINVOICELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_DOCUMENTTYPEDOCUMENTCANCELLEDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_DOCUMENTTYPEDOCUMENTTYPEFORORDERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_DOCUMENTTYPETRLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_EXTERNALPOSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINBANKSTATEMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINDOUBTFULDEBTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTPROPOSALLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTPROPOSALEMSLPPPAYMENTDOCTYPEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINRECONCILIATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTACCOUNTINGFACTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTAMORTIZATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTASSETEMSSALCDOCTYPEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTDPMANAGEMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTGLJOURNALLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTSETTLEMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTTAXREGISTERTYPELINESLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVENTORYAMOUNTUPDATELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICETRANSACTIONDOCUMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICEEMSSWHCDOCTYPEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICEV2LIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICEV2TRANSACTIONDOCUMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_LANDEDCOSTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_LANDEDCOSTCOSTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MANUFACTURINGWORKREQUIREMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTSHIPMENTINOUTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERTRANSACTIONDOCUMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCBDBUDGETDIRECTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCSDCSIGNATURESPERDOCLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SRSISALESINVOICEVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSACCTACCOUNTINGFACTSECONDARYLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSACCTJOURNALLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPHTENTHSETTLEMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPPPAYMENTSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPPPAYMENTSCDOCTYPEPAYMENTIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRLEAVEEMPLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRPAYROLLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSVEVIATICALLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSVEVIATICALSETTLEMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWHAUTHORIZATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWHPOSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWHRECEIPTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWSCONFIGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWSWITHHOLDINGSALELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SWSICCONFIGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SWSICCONFIGCDOCTYPEPAYMENTINIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ECSPPPOALIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCPPAPPROVALPAYMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SESCRTEMPLATEREPORTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETADDLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETCERTIFICATELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETDOCTYPELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPRMOVEMENTTYPELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SQBCONFIGQUICKBILLINGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SQBCONFIGQUICKBILLINGCDOCTYPEPAYMENTINIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SQBQUICKBILLINGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALAPPLACTIVELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALAPPLACTIVECDOCTYPEIDRETURNLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALASSETRETURNLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSAMALIENATELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSCPRREPORTCERTIFICATELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSCTCONTRACTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSFIFINANCIALUSERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSFWAPPROVALDOCTYPELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPREMPLOYEESETTLEMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRLOANSEMSFPRCDOCTYPEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRPAYROLLPAYMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRSETTLEMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWHWITHHCARDCREDITLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWHWITHHOLDINGSVOIDEDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWHWITHHOLDINGSVOIDEDCDOCTYPE2IDLIST, new ArrayList<Object>());
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

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public String getPrintText() {
        return (String) get(PROPERTY_PRINTTEXT);
    }

    public void setPrintText(String printText) {
        set(PROPERTY_PRINTTEXT, printText);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public String getDocumentCategory() {
        return (String) get(PROPERTY_DOCUMENTCATEGORY);
    }

    public void setDocumentCategory(String documentCategory) {
        set(PROPERTY_DOCUMENTCATEGORY, documentCategory);
    }

    public Boolean isSalesTransaction() {
        return (Boolean) get(PROPERTY_SALESTRANSACTION);
    }

    public void setSalesTransaction(Boolean salesTransaction) {
        set(PROPERTY_SALESTRANSACTION, salesTransaction);
    }

    public String getSOSubType() {
        return (String) get(PROPERTY_SOSUBTYPE);
    }

    public void setSOSubType(String sOSubType) {
        set(PROPERTY_SOSUBTYPE, sOSubType);
    }

    public DocumentType getDocumentTypeForShipment() {
        return (DocumentType) get(PROPERTY_DOCUMENTTYPEFORSHIPMENT);
    }

    public void setDocumentTypeForShipment(DocumentType documentTypeForShipment) {
        set(PROPERTY_DOCUMENTTYPEFORSHIPMENT, documentTypeForShipment);
    }

    public DocumentType getDocumentTypeForInvoice() {
        return (DocumentType) get(PROPERTY_DOCUMENTTYPEFORINVOICE);
    }

    public void setDocumentTypeForInvoice(DocumentType documentTypeForInvoice) {
        set(PROPERTY_DOCUMENTTYPEFORINVOICE, documentTypeForInvoice);
    }

    public Boolean isSequencedDocument() {
        return (Boolean) get(PROPERTY_SEQUENCEDDOCUMENT);
    }

    public void setSequencedDocument(Boolean sequencedDocument) {
        set(PROPERTY_SEQUENCEDDOCUMENT, sequencedDocument);
    }

    public Sequence getDocumentSequence() {
        return (Sequence) get(PROPERTY_DOCUMENTSEQUENCE);
    }

    public void setDocumentSequence(Sequence documentSequence) {
        set(PROPERTY_DOCUMENTSEQUENCE, documentSequence);
    }

    public GLCategory getGLCategory() {
        return (GLCategory) get(PROPERTY_GLCATEGORY);
    }

    public void setGLCategory(GLCategory gLCategory) {
        set(PROPERTY_GLCATEGORY, gLCategory);
    }

    public String getComments() {
        return (String) get(PROPERTY_COMMENTS);
    }

    public void setComments(String comments) {
        set(PROPERTY_COMMENTS, comments);
    }

    public Boolean isDefault() {
        return (Boolean) get(PROPERTY_DEFAULT);
    }

    public void setDefault(Boolean deflt) {
        set(PROPERTY_DEFAULT, deflt);
    }

    public Long getNumberOfCopies() {
        return (Long) get(PROPERTY_NUMBEROFCOPIES);
    }

    public void setNumberOfCopies(Long numberOfCopies) {
        set(PROPERTY_NUMBEROFCOPIES, numberOfCopies);
    }

    public Table getTable() {
        return (Table) get(PROPERTY_TABLE);
    }

    public void setTable(Table table) {
        set(PROPERTY_TABLE, table);
    }

    public Boolean isFilterByOrganization() {
        return (Boolean) get(PROPERTY_FILTERBYORGANIZATION);
    }

    public void setFilterByOrganization(Boolean filterByOrganization) {
        set(PROPERTY_FILTERBYORGANIZATION, filterByOrganization);
    }

    public DocumentType getDocumentCancelled() {
        return (DocumentType) get(PROPERTY_DOCUMENTCANCELLED);
    }

    public void setDocumentCancelled(DocumentType documentCancelled) {
        set(PROPERTY_DOCUMENTCANCELLED, documentCancelled);
    }

    public Boolean isExpense() {
        return (Boolean) get(PROPERTY_EXPENSE);
    }

    public void setExpense(Boolean expense) {
        set(PROPERTY_EXPENSE, expense);
    }

    public Boolean isReversal() {
        return (Boolean) get(PROPERTY_REVERSAL);
    }

    public void setReversal(Boolean reversal) {
        set(PROPERTY_REVERSAL, reversal);
    }

    public Boolean isReturn() {
        return (Boolean) get(PROPERTY_RETURN);
    }

    public void setReturn(Boolean rturn) {
        set(PROPERTY_RETURN, rturn);
    }

    public DocumentType getDocumentTypeForOrder() {
        return (DocumentType) get(PROPERTY_DOCUMENTTYPEFORORDER);
    }

    public void setDocumentTypeForOrder(DocumentType documentTypeForOrder) {
        set(PROPERTY_DOCUMENTTYPEFORORDER, documentTypeForOrder);
    }

    public Boolean isSswhImplementautoriza() {
        return (Boolean) get(PROPERTY_SSWHIMPLEMENTAUTORIZA);
    }

    public void setSswhImplementautoriza(Boolean sswhImplementautoriza) {
        set(PROPERTY_SSWHIMPLEMENTAUTORIZA, sswhImplementautoriza);
    }

    public Boolean isSswhIswithholding() {
        return (Boolean) get(PROPERTY_SSWHISWITHHOLDING);
    }

    public void setSswhIswithholding(Boolean sswhIswithholding) {
        set(PROPERTY_SSWHISWITHHOLDING, sswhIswithholding);
    }

    public Boolean isSswhIsclient() {
        return (Boolean) get(PROPERTY_SSWHISCLIENT);
    }

    public void setSswhIsclient(Boolean sswhIsclient) {
        set(PROPERTY_SSWHISCLIENT, sswhIsclient);
    }

    public Boolean isSswhIswithholdingsale() {
        return (Boolean) get(PROPERTY_SSWHISWITHHOLDINGSALE);
    }

    public void setSswhIswithholdingsale(Boolean sswhIswithholdingsale) {
        set(PROPERTY_SSWHISWITHHOLDINGSALE, sswhIswithholdingsale);
    }

    public sswhtypereceipt getSswhTypereceipt() {
        return (sswhtypereceipt) get(PROPERTY_SSWHTYPERECEIPT);
    }

    public void setSswhTypereceipt(sswhtypereceipt sswhTypereceipt) {
        set(PROPERTY_SSWHTYPERECEIPT, sswhTypereceipt);
    }

    public String getSswhDoctype() {
        return (String) get(PROPERTY_SSWHDOCTYPE);
    }

    public void setSswhDoctype(String sswhDoctype) {
        set(PROPERTY_SSWHDOCTYPE, sswhDoctype);
    }

    public Boolean isSswhAfectedZone() {
        return (Boolean) get(PROPERTY_SSWHAFECTEDZONE);
    }

    public void setSswhAfectedZone(Boolean sswhAfectedZone) {
        set(PROPERTY_SSWHAFECTEDZONE, sswhAfectedZone);
    }

    public String getSswhCode() {
        return (String) get(PROPERTY_SSWHCODE);
    }

    public void setSswhCode(String sswhCode) {
        set(PROPERTY_SSWHCODE, sswhCode);
    }

    public Long getSSWHPercentage() {
        return (Long) get(PROPERTY_SSWHPERCENTAGE);
    }

    public void setSSWHPercentage(Long sSWHPercentage) {
        set(PROPERTY_SSWHPERCENTAGE, sSWHPercentage);
    }

    public String getEeiEdocType() {
        return (String) get(PROPERTY_EEIEDOCTYPE);
    }

    public void setEeiEdocType(String eeiEdocType) {
        set(PROPERTY_EEIEDOCTYPE, eeiEdocType);
    }

    public String getSsflPrint() {
        return (String) get(PROPERTY_SSFLPRINT);
    }

    public void setSsflPrint(String ssflPrint) {
        set(PROPERTY_SSFLPRINT, ssflPrint);
    }

    public Boolean isEeiIsEdoc() {
        return (Boolean) get(PROPERTY_EEIISEDOC);
    }

    public void setEeiIsEdoc(Boolean eeiIsEdoc) {
        set(PROPERTY_EEIISEDOC, eeiIsEdoc);
    }

    public Boolean isEeiRemissionForSales() {
        return (Boolean) get(PROPERTY_EEIREMISSIONFORSALES);
    }

    public void setEeiRemissionForSales(Boolean eeiRemissionForSales) {
        set(PROPERTY_EEIREMISSIONFORSALES, eeiRemissionForSales);
    }

    public Boolean isSswhExtWithh() {
        return (Boolean) get(PROPERTY_SSWHEXTWITHH);
    }

    public void setSswhExtWithh(Boolean sswhExtWithh) {
        set(PROPERTY_SSWHEXTWITHH, sswhExtWithh);
    }

    public Boolean isSsfiIscrossing() {
        return (Boolean) get(PROPERTY_SSFIISCROSSING);
    }

    public void setSsfiIscrossing(Boolean ssfiIscrossing) {
        set(PROPERTY_SSFIISCROSSING, ssfiIscrossing);
    }

    public String getSswhWithhCode() {
        return (String) get(PROPERTY_SSWHWITHHCODE);
    }

    public void setSswhWithhCode(String sswhWithhCode) {
        set(PROPERTY_SSWHWITHHCODE, sswhWithhCode);
    }

    public Boolean isEeiKeyAccessGenerated() {
        return (Boolean) get(PROPERTY_EEIKEYACCESSGENERATED);
    }

    public void setEeiKeyAccessGenerated(Boolean eeiKeyAccessGenerated) {
        set(PROPERTY_EEIKEYACCESSGENERATED, eeiKeyAccessGenerated);
    }

    public Boolean isSspewExclforwithhold() {
        return (Boolean) get(PROPERTY_SSPEWEXCLFORWITHHOLD);
    }

    public void setSspewExclforwithhold(Boolean sspewExclforwithhold) {
        set(PROPERTY_SSPEWEXCLFORWITHHOLD, sspewExclforwithhold);
    }

    public Boolean isEcsapSubjectAuthorization() {
        return (Boolean) get(PROPERTY_ECSAPSUBJECTAUTHORIZATION);
    }

    public void setEcsapSubjectAuthorization(Boolean ecsapSubjectAuthorization) {
        set(PROPERTY_ECSAPSUBJECTAUTHORIZATION, ecsapSubjectAuthorization);
    }

    public String getEeiDescriptionfields() {
        return (String) get(PROPERTY_EEIDESCRIPTIONFIELDS);
    }

    public void setEeiDescriptionfields(String eeiDescriptionfields) {
        set(PROPERTY_EEIDESCRIPTIONFIELDS, eeiDescriptionfields);
    }

    public Boolean isEeiIsrefund() {
        return (Boolean) get(PROPERTY_EEIISREFUND);
    }

    public void setEeiIsrefund(Boolean eeiIsrefund) {
        set(PROPERTY_EEIISREFUND, eeiIsrefund);
    }

    public Long getEeiRefundCode() {
        return (Long) get(PROPERTY_EEIREFUNDCODE);
    }

    public void setEeiRefundCode(Long eeiRefundCode) {
        set(PROPERTY_EEIREFUNDCODE, eeiRefundCode);
    }

    @SuppressWarnings("unchecked")
    public List<APRM_Reconciliation_v> getAPRMReconciliationList() {
      return (List<APRM_Reconciliation_v>) get(PROPERTY_APRMRECONCILIATIONLIST);
    }

    public void setAPRMReconciliationList(List<APRM_Reconciliation_v> aPRMReconciliationList) {
        set(PROPERTY_APRMRECONCILIATIONLIST, aPRMReconciliationList);
    }

    @SuppressWarnings("unchecked")
    public List<BusinessPartner> getBusinessPartnerEMOpcrmDoctypeIDList() {
      return (List<BusinessPartner>) get(PROPERTY_BUSINESSPARTNEREMOPCRMDOCTYPEIDLIST);
    }

    public void setBusinessPartnerEMOpcrmDoctypeIDList(List<BusinessPartner> businessPartnerEMOpcrmDoctypeIDList) {
        set(PROPERTY_BUSINESSPARTNEREMOPCRMDOCTYPEIDLIST, businessPartnerEMOpcrmDoctypeIDList);
    }

    @SuppressWarnings("unchecked")
    public List<CostAdjustment> getCostAdjustmentList() {
      return (List<CostAdjustment>) get(PROPERTY_COSTADJUSTMENTLIST);
    }

    public void setCostAdjustmentList(List<CostAdjustment> costAdjustmentList) {
        set(PROPERTY_COSTADJUSTMENTLIST, costAdjustmentList);
    }

    @SuppressWarnings("unchecked")
    public List<DocumentTemplate> getDocumentTemplateList() {
      return (List<DocumentTemplate>) get(PROPERTY_DOCUMENTTEMPLATELIST);
    }

    public void setDocumentTemplateList(List<DocumentTemplate> documentTemplateList) {
        set(PROPERTY_DOCUMENTTEMPLATELIST, documentTemplateList);
    }

    @SuppressWarnings("unchecked")
    public List<DocumentType> getDocumentTypeDocumentTypeForShipmentList() {
      return (List<DocumentType>) get(PROPERTY_DOCUMENTTYPEDOCUMENTTYPEFORSHIPMENTLIST);
    }

    public void setDocumentTypeDocumentTypeForShipmentList(List<DocumentType> documentTypeDocumentTypeForShipmentList) {
        set(PROPERTY_DOCUMENTTYPEDOCUMENTTYPEFORSHIPMENTLIST, documentTypeDocumentTypeForShipmentList);
    }

    @SuppressWarnings("unchecked")
    public List<DocumentType> getDocumentTypeDocumentTypeForInvoiceList() {
      return (List<DocumentType>) get(PROPERTY_DOCUMENTTYPEDOCUMENTTYPEFORINVOICELIST);
    }

    public void setDocumentTypeDocumentTypeForInvoiceList(List<DocumentType> documentTypeDocumentTypeForInvoiceList) {
        set(PROPERTY_DOCUMENTTYPEDOCUMENTTYPEFORINVOICELIST, documentTypeDocumentTypeForInvoiceList);
    }

    @SuppressWarnings("unchecked")
    public List<DocumentType> getDocumentTypeDocumentCancelledList() {
      return (List<DocumentType>) get(PROPERTY_DOCUMENTTYPEDOCUMENTCANCELLEDLIST);
    }

    public void setDocumentTypeDocumentCancelledList(List<DocumentType> documentTypeDocumentCancelledList) {
        set(PROPERTY_DOCUMENTTYPEDOCUMENTCANCELLEDLIST, documentTypeDocumentCancelledList);
    }

    @SuppressWarnings("unchecked")
    public List<DocumentType> getDocumentTypeDocumentTypeForOrderList() {
      return (List<DocumentType>) get(PROPERTY_DOCUMENTTYPEDOCUMENTTYPEFORORDERLIST);
    }

    public void setDocumentTypeDocumentTypeForOrderList(List<DocumentType> documentTypeDocumentTypeForOrderList) {
        set(PROPERTY_DOCUMENTTYPEDOCUMENTTYPEFORORDERLIST, documentTypeDocumentTypeForOrderList);
    }

    @SuppressWarnings("unchecked")
    public List<DocumentTypeTrl> getDocumentTypeTrlList() {
      return (List<DocumentTypeTrl>) get(PROPERTY_DOCUMENTTYPETRLLIST);
    }

    public void setDocumentTypeTrlList(List<DocumentTypeTrl> documentTypeTrlList) {
        set(PROPERTY_DOCUMENTTYPETRLLIST, documentTypeTrlList);
    }

    @SuppressWarnings("unchecked")
    public List<ExternalPOS> getExternalPOSList() {
      return (List<ExternalPOS>) get(PROPERTY_EXTERNALPOSLIST);
    }

    public void setExternalPOSList(List<ExternalPOS> externalPOSList) {
        set(PROPERTY_EXTERNALPOSLIST, externalPOSList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_BankStatement> getFINBankStatementList() {
      return (List<FIN_BankStatement>) get(PROPERTY_FINBANKSTATEMENTLIST);
    }

    public void setFINBankStatementList(List<FIN_BankStatement> fINBankStatementList) {
        set(PROPERTY_FINBANKSTATEMENTLIST, fINBankStatementList);
    }

    @SuppressWarnings("unchecked")
    public List<DoubtfulDebt> getFINDoubtfulDebtList() {
      return (List<DoubtfulDebt>) get(PROPERTY_FINDOUBTFULDEBTLIST);
    }

    public void setFINDoubtfulDebtList(List<DoubtfulDebt> fINDoubtfulDebtList) {
        set(PROPERTY_FINDOUBTFULDEBTLIST, fINDoubtfulDebtList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_Payment> getFINPaymentList() {
      return (List<FIN_Payment>) get(PROPERTY_FINPAYMENTLIST);
    }

    public void setFINPaymentList(List<FIN_Payment> fINPaymentList) {
        set(PROPERTY_FINPAYMENTLIST, fINPaymentList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_PaymentProposal> getFINPaymentProposalList() {
      return (List<FIN_PaymentProposal>) get(PROPERTY_FINPAYMENTPROPOSALLIST);
    }

    public void setFINPaymentProposalList(List<FIN_PaymentProposal> fINPaymentProposalList) {
        set(PROPERTY_FINPAYMENTPROPOSALLIST, fINPaymentProposalList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_PaymentProposal> getFINPaymentProposalEMSlppPaymentDoctypeIDList() {
      return (List<FIN_PaymentProposal>) get(PROPERTY_FINPAYMENTPROPOSALEMSLPPPAYMENTDOCTYPEIDLIST);
    }

    public void setFINPaymentProposalEMSlppPaymentDoctypeIDList(List<FIN_PaymentProposal> fINPaymentProposalEMSlppPaymentDoctypeIDList) {
        set(PROPERTY_FINPAYMENTPROPOSALEMSLPPPAYMENTDOCTYPEIDLIST, fINPaymentProposalEMSlppPaymentDoctypeIDList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_Reconciliation> getFINReconciliationList() {
      return (List<FIN_Reconciliation>) get(PROPERTY_FINRECONCILIATIONLIST);
    }

    public void setFINReconciliationList(List<FIN_Reconciliation> fINReconciliationList) {
        set(PROPERTY_FINRECONCILIATIONLIST, fINReconciliationList);
    }

    @SuppressWarnings("unchecked")
    public List<AccountingFact> getFinancialMgmtAccountingFactList() {
      return (List<AccountingFact>) get(PROPERTY_FINANCIALMGMTACCOUNTINGFACTLIST);
    }

    public void setFinancialMgmtAccountingFactList(List<AccountingFact> financialMgmtAccountingFactList) {
        set(PROPERTY_FINANCIALMGMTACCOUNTINGFACTLIST, financialMgmtAccountingFactList);
    }

    @SuppressWarnings("unchecked")
    public List<Amortization> getFinancialMgmtAmortizationList() {
      return (List<Amortization>) get(PROPERTY_FINANCIALMGMTAMORTIZATIONLIST);
    }

    public void setFinancialMgmtAmortizationList(List<Amortization> financialMgmtAmortizationList) {
        set(PROPERTY_FINANCIALMGMTAMORTIZATIONLIST, financialMgmtAmortizationList);
    }

    @SuppressWarnings("unchecked")
    public List<Asset> getFinancialMgmtAssetEMSsalCDoctypeIDList() {
      return (List<Asset>) get(PROPERTY_FINANCIALMGMTASSETEMSSALCDOCTYPEIDLIST);
    }

    public void setFinancialMgmtAssetEMSsalCDoctypeIDList(List<Asset> financialMgmtAssetEMSsalCDoctypeIDList) {
        set(PROPERTY_FINANCIALMGMTASSETEMSSALCDOCTYPEIDLIST, financialMgmtAssetEMSsalCDoctypeIDList);
    }

    @SuppressWarnings("unchecked")
    public List<DPManagement> getFinancialMgmtDPManagementList() {
      return (List<DPManagement>) get(PROPERTY_FINANCIALMGMTDPMANAGEMENTLIST);
    }

    public void setFinancialMgmtDPManagementList(List<DPManagement> financialMgmtDPManagementList) {
        set(PROPERTY_FINANCIALMGMTDPMANAGEMENTLIST, financialMgmtDPManagementList);
    }

    @SuppressWarnings("unchecked")
    public List<GLJournal> getFinancialMgmtGLJournalList() {
      return (List<GLJournal>) get(PROPERTY_FINANCIALMGMTGLJOURNALLIST);
    }

    public void setFinancialMgmtGLJournalList(List<GLJournal> financialMgmtGLJournalList) {
        set(PROPERTY_FINANCIALMGMTGLJOURNALLIST, financialMgmtGLJournalList);
    }

    @SuppressWarnings("unchecked")
    public List<Settlement> getFinancialMgmtSettlementList() {
      return (List<Settlement>) get(PROPERTY_FINANCIALMGMTSETTLEMENTLIST);
    }

    public void setFinancialMgmtSettlementList(List<Settlement> financialMgmtSettlementList) {
        set(PROPERTY_FINANCIALMGMTSETTLEMENTLIST, financialMgmtSettlementList);
    }

    @SuppressWarnings("unchecked")
    public List<TaxRegisterTypeLines> getFinancialMgmtTaxRegisterTypeLinesList() {
      return (List<TaxRegisterTypeLines>) get(PROPERTY_FINANCIALMGMTTAXREGISTERTYPELINESLIST);
    }

    public void setFinancialMgmtTaxRegisterTypeLinesList(List<TaxRegisterTypeLines> financialMgmtTaxRegisterTypeLinesList) {
        set(PROPERTY_FINANCIALMGMTTAXREGISTERTYPELINESLIST, financialMgmtTaxRegisterTypeLinesList);
    }

    @SuppressWarnings("unchecked")
    public List<InventoryAmountUpdate> getInventoryAmountUpdateList() {
      return (List<InventoryAmountUpdate>) get(PROPERTY_INVENTORYAMOUNTUPDATELIST);
    }

    public void setInventoryAmountUpdateList(List<InventoryAmountUpdate> inventoryAmountUpdateList) {
        set(PROPERTY_INVENTORYAMOUNTUPDATELIST, inventoryAmountUpdateList);
    }

    @SuppressWarnings("unchecked")
    public List<Invoice> getInvoiceList() {
      return (List<Invoice>) get(PROPERTY_INVOICELIST);
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        set(PROPERTY_INVOICELIST, invoiceList);
    }

    @SuppressWarnings("unchecked")
    public List<Invoice> getInvoiceTransactionDocumentList() {
      return (List<Invoice>) get(PROPERTY_INVOICETRANSACTIONDOCUMENTLIST);
    }

    public void setInvoiceTransactionDocumentList(List<Invoice> invoiceTransactionDocumentList) {
        set(PROPERTY_INVOICETRANSACTIONDOCUMENTLIST, invoiceTransactionDocumentList);
    }

    @SuppressWarnings("unchecked")
    public List<Invoice> getInvoiceEMSswhCDoctypeIDList() {
      return (List<Invoice>) get(PROPERTY_INVOICEEMSSWHCDOCTYPEIDLIST);
    }

    public void setInvoiceEMSswhCDoctypeIDList(List<Invoice> invoiceEMSswhCDoctypeIDList) {
        set(PROPERTY_INVOICEEMSSWHCDOCTYPEIDLIST, invoiceEMSswhCDoctypeIDList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceV2> getInvoiceV2List() {
      return (List<InvoiceV2>) get(PROPERTY_INVOICEV2LIST);
    }

    public void setInvoiceV2List(List<InvoiceV2> invoiceV2List) {
        set(PROPERTY_INVOICEV2LIST, invoiceV2List);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceV2> getInvoiceV2TransactionDocumentList() {
      return (List<InvoiceV2>) get(PROPERTY_INVOICEV2TRANSACTIONDOCUMENTLIST);
    }

    public void setInvoiceV2TransactionDocumentList(List<InvoiceV2> invoiceV2TransactionDocumentList) {
        set(PROPERTY_INVOICEV2TRANSACTIONDOCUMENTLIST, invoiceV2TransactionDocumentList);
    }

    @SuppressWarnings("unchecked")
    public List<LandedCost> getLandedCostList() {
      return (List<LandedCost>) get(PROPERTY_LANDEDCOSTLIST);
    }

    public void setLandedCostList(List<LandedCost> landedCostList) {
        set(PROPERTY_LANDEDCOSTLIST, landedCostList);
    }

    @SuppressWarnings("unchecked")
    public List<LandedCostCost> getLandedCostCostList() {
      return (List<LandedCostCost>) get(PROPERTY_LANDEDCOSTCOSTLIST);
    }

    public void setLandedCostCostList(List<LandedCostCost> landedCostCostList) {
        set(PROPERTY_LANDEDCOSTCOSTLIST, landedCostCostList);
    }

    @SuppressWarnings("unchecked")
    public List<WorkRequirement> getManufacturingWorkRequirementList() {
      return (List<WorkRequirement>) get(PROPERTY_MANUFACTURINGWORKREQUIREMENTLIST);
    }

    public void setManufacturingWorkRequirementList(List<WorkRequirement> manufacturingWorkRequirementList) {
        set(PROPERTY_MANUFACTURINGWORKREQUIREMENTLIST, manufacturingWorkRequirementList);
    }

    @SuppressWarnings("unchecked")
    public List<ShipmentInOut> getMaterialMgmtShipmentInOutList() {
      return (List<ShipmentInOut>) get(PROPERTY_MATERIALMGMTSHIPMENTINOUTLIST);
    }

    public void setMaterialMgmtShipmentInOutList(List<ShipmentInOut> materialMgmtShipmentInOutList) {
        set(PROPERTY_MATERIALMGMTSHIPMENTINOUTLIST, materialMgmtShipmentInOutList);
    }

    @SuppressWarnings("unchecked")
    public List<Order> getOrderList() {
      return (List<Order>) get(PROPERTY_ORDERLIST);
    }

    public void setOrderList(List<Order> orderList) {
        set(PROPERTY_ORDERLIST, orderList);
    }

    @SuppressWarnings("unchecked")
    public List<Order> getOrderTransactionDocumentList() {
      return (List<Order>) get(PROPERTY_ORDERTRANSACTIONDOCUMENTLIST);
    }

    public void setOrderTransactionDocumentList(List<Order> orderTransactionDocumentList) {
        set(PROPERTY_ORDERTRANSACTIONDOCUMENTLIST, orderTransactionDocumentList);
    }

    @SuppressWarnings("unchecked")
    public List<SCBDBudgetDirect> getSCBDBudgetDirectList() {
      return (List<SCBDBudgetDirect>) get(PROPERTY_SCBDBUDGETDIRECTLIST);
    }

    public void setSCBDBudgetDirectList(List<SCBDBudgetDirect> sCBDBudgetDirectList) {
        set(PROPERTY_SCBDBUDGETDIRECTLIST, sCBDBudgetDirectList);
    }

    @SuppressWarnings("unchecked")
    public List<SCSDCSignaturesperdoc> getSCSDCSignaturesperdocList() {
      return (List<SCSDCSignaturesperdoc>) get(PROPERTY_SCSDCSIGNATURESPERDOCLIST);
    }

    public void setSCSDCSignaturesperdocList(List<SCSDCSignaturesperdoc> sCSDCSignaturesperdocList) {
        set(PROPERTY_SCSDCSIGNATURESPERDOCLIST, sCSDCSignaturesperdocList);
    }

    @SuppressWarnings("unchecked")
    public List<SRSISalesInvoiceV> getSRSISalesInvoiceVList() {
      return (List<SRSISalesInvoiceV>) get(PROPERTY_SRSISALESINVOICEVLIST);
    }

    public void setSRSISalesInvoiceVList(List<SRSISalesInvoiceV> sRSISalesInvoiceVList) {
        set(PROPERTY_SRSISALESINVOICEVLIST, sRSISalesInvoiceVList);
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
    public List<SSPHTenthSettlement> getSSPHTenthSettlementList() {
      return (List<SSPHTenthSettlement>) get(PROPERTY_SSPHTENTHSETTLEMENTLIST);
    }

    public void setSSPHTenthSettlementList(List<SSPHTenthSettlement> sSPHTenthSettlementList) {
        set(PROPERTY_SSPHTENTHSETTLEMENTLIST, sSPHTenthSettlementList);
    }

    @SuppressWarnings("unchecked")
    public List<SSPPPAYMENTS> getSSPPPAYMENTSList() {
      return (List<SSPPPAYMENTS>) get(PROPERTY_SSPPPAYMENTSLIST);
    }

    public void setSSPPPAYMENTSList(List<SSPPPAYMENTS> sSPPPAYMENTSList) {
        set(PROPERTY_SSPPPAYMENTSLIST, sSPPPAYMENTSList);
    }

    @SuppressWarnings("unchecked")
    public List<SSPPPAYMENTS> getSSPPPAYMENTSCDoctypePaymentIDList() {
      return (List<SSPPPAYMENTS>) get(PROPERTY_SSPPPAYMENTSCDOCTYPEPAYMENTIDLIST);
    }

    public void setSSPPPAYMENTSCDoctypePaymentIDList(List<SSPPPAYMENTS> sSPPPAYMENTSCDoctypePaymentIDList) {
        set(PROPERTY_SSPPPAYMENTSCDOCTYPEPAYMENTIDLIST, sSPPPAYMENTSCDoctypePaymentIDList);
    }

    @SuppressWarnings("unchecked")
    public List<ssprleaveemp> getSSPRLeaveEmpList() {
      return (List<ssprleaveemp>) get(PROPERTY_SSPRLEAVEEMPLIST);
    }

    public void setSSPRLeaveEmpList(List<ssprleaveemp> sSPRLeaveEmpList) {
        set(PROPERTY_SSPRLEAVEEMPLIST, sSPRLeaveEmpList);
    }

    @SuppressWarnings("unchecked")
    public List<Payroll> getSSPRPayrollList() {
      return (List<Payroll>) get(PROPERTY_SSPRPAYROLLLIST);
    }

    public void setSSPRPayrollList(List<Payroll> sSPRPayrollList) {
        set(PROPERTY_SSPRPAYROLLLIST, sSPRPayrollList);
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
    public List<Authorization> getSSWHAuthorizationList() {
      return (List<Authorization>) get(PROPERTY_SSWHAUTHORIZATIONLIST);
    }

    public void setSSWHAuthorizationList(List<Authorization> sSWHAuthorizationList) {
        set(PROPERTY_SSWHAUTHORIZATIONLIST, sSWHAuthorizationList);
    }

    @SuppressWarnings("unchecked")
    public List<SSWHPos> getSSWHPosList() {
      return (List<SSWHPos>) get(PROPERTY_SSWHPOSLIST);
    }

    public void setSSWHPosList(List<SSWHPos> sSWHPosList) {
        set(PROPERTY_SSWHPOSLIST, sSWHPosList);
    }

    @SuppressWarnings("unchecked")
    public List<Receipt> getSSWHReceiptList() {
      return (List<Receipt>) get(PROPERTY_SSWHRECEIPTLIST);
    }

    public void setSSWHReceiptList(List<Receipt> sSWHReceiptList) {
        set(PROPERTY_SSWHRECEIPTLIST, sSWHReceiptList);
    }

    @SuppressWarnings("unchecked")
    public List<SSWSConfig> getSSWSConfigList() {
      return (List<SSWSConfig>) get(PROPERTY_SSWSCONFIGLIST);
    }

    public void setSSWSConfigList(List<SSWSConfig> sSWSConfigList) {
        set(PROPERTY_SSWSCONFIGLIST, sSWSConfigList);
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
    public List<SWSICConfig> getSWSICConfigCDoctypePaymentInIDList() {
      return (List<SWSICConfig>) get(PROPERTY_SWSICCONFIGCDOCTYPEPAYMENTINIDLIST);
    }

    public void setSWSICConfigCDoctypePaymentInIDList(List<SWSICConfig> sWSICConfigCDoctypePaymentInIDList) {
        set(PROPERTY_SWSICCONFIGCDOCTYPEPAYMENTINIDLIST, sWSICConfigCDoctypePaymentInIDList);
    }

    @SuppressWarnings("unchecked")
    public List<EcsppPOA> getEcsppPoaList() {
      return (List<EcsppPOA>) get(PROPERTY_ECSPPPOALIST);
    }

    public void setEcsppPoaList(List<EcsppPOA> ecsppPoaList) {
        set(PROPERTY_ECSPPPOALIST, ecsppPoaList);
    }

    @SuppressWarnings("unchecked")
    public List<scppapprovalpayment> getScppApprovalpaymentList() {
      return (List<scppapprovalpayment>) get(PROPERTY_SCPPAPPROVALPAYMENTLIST);
    }

    public void setScppApprovalpaymentList(List<scppapprovalpayment> scppApprovalpaymentList) {
        set(PROPERTY_SCPPAPPROVALPAYMENTLIST, scppApprovalpaymentList);
    }

    @SuppressWarnings("unchecked")
    public List<SescrTemplateReport> getSescrTemplateReportList() {
      return (List<SescrTemplateReport>) get(PROPERTY_SESCRTEMPLATEREPORTLIST);
    }

    public void setSescrTemplateReportList(List<SescrTemplateReport> sescrTemplateReportList) {
        set(PROPERTY_SESCRTEMPLATEREPORTLIST, sescrTemplateReportList);
    }

    @SuppressWarnings("unchecked")
    public List<sfbbudgetaddline> getSfbBudgetAddlineList() {
      return (List<sfbbudgetaddline>) get(PROPERTY_SFBBUDGETADDLINELIST);
    }

    public void setSfbBudgetAddlineList(List<sfbbudgetaddline> sfbBudgetAddlineList) {
        set(PROPERTY_SFBBUDGETADDLINELIST, sfbBudgetAddlineList);
    }

    @SuppressWarnings("unchecked")
    public List<SFBBudgetCertificate> getSfbBudgetCertificateList() {
      return (List<SFBBudgetCertificate>) get(PROPERTY_SFBBUDGETCERTIFICATELIST);
    }

    public void setSfbBudgetCertificateList(List<SFBBudgetCertificate> sfbBudgetCertificateList) {
        set(PROPERTY_SFBBUDGETCERTIFICATELIST, sfbBudgetCertificateList);
    }

    @SuppressWarnings("unchecked")
    public List<SFBBudgetDoctype> getSfbBudgetDoctypeList() {
      return (List<SFBBudgetDoctype>) get(PROPERTY_SFBBUDGETDOCTYPELIST);
    }

    public void setSfbBudgetDoctypeList(List<SFBBudgetDoctype> sfbBudgetDoctypeList) {
        set(PROPERTY_SFBBUDGETDOCTYPELIST, sfbBudgetDoctypeList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprMovementType> getSfprMovementTypeList() {
      return (List<SfprMovementType>) get(PROPERTY_SFPRMOVEMENTTYPELIST);
    }

    public void setSfprMovementTypeList(List<SfprMovementType> sfprMovementTypeList) {
        set(PROPERTY_SFPRMOVEMENTTYPELIST, sfprMovementTypeList);
    }

    @SuppressWarnings("unchecked")
    public List<SqbConfigQuickBilling> getSqbConfigQuickbillingList() {
      return (List<SqbConfigQuickBilling>) get(PROPERTY_SQBCONFIGQUICKBILLINGLIST);
    }

    public void setSqbConfigQuickbillingList(List<SqbConfigQuickBilling> sqbConfigQuickbillingList) {
        set(PROPERTY_SQBCONFIGQUICKBILLINGLIST, sqbConfigQuickbillingList);
    }

    @SuppressWarnings("unchecked")
    public List<SqbConfigQuickBilling> getSqbConfigQuickbillingCDoctypePaymentInIDList() {
      return (List<SqbConfigQuickBilling>) get(PROPERTY_SQBCONFIGQUICKBILLINGCDOCTYPEPAYMENTINIDLIST);
    }

    public void setSqbConfigQuickbillingCDoctypePaymentInIDList(List<SqbConfigQuickBilling> sqbConfigQuickbillingCDoctypePaymentInIDList) {
        set(PROPERTY_SQBCONFIGQUICKBILLINGCDOCTYPEPAYMENTINIDLIST, sqbConfigQuickbillingCDoctypePaymentInIDList);
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
    public List<SsalApplActive> getSsalApplActiveCDoctypeIdReturnList() {
      return (List<SsalApplActive>) get(PROPERTY_SSALAPPLACTIVECDOCTYPEIDRETURNLIST);
    }

    public void setSsalApplActiveCDoctypeIdReturnList(List<SsalApplActive> ssalApplActiveCDoctypeIdReturnList) {
        set(PROPERTY_SSALAPPLACTIVECDOCTYPEIDRETURNLIST, ssalApplActiveCDoctypeIdReturnList);
    }

    @SuppressWarnings("unchecked")
    public List<SsalAssetReturn> getSsalAssetReturnList() {
      return (List<SsalAssetReturn>) get(PROPERTY_SSALASSETRETURNLIST);
    }

    public void setSsalAssetReturnList(List<SsalAssetReturn> ssalAssetReturnList) {
        set(PROPERTY_SSALASSETRETURNLIST, ssalAssetReturnList);
    }

    @SuppressWarnings("unchecked")
    public List<ssamalienate> getSsamAlienateList() {
      return (List<ssamalienate>) get(PROPERTY_SSAMALIENATELIST);
    }

    public void setSsamAlienateList(List<ssamalienate> ssamAlienateList) {
        set(PROPERTY_SSAMALIENATELIST, ssamAlienateList);
    }

    @SuppressWarnings("unchecked")
    public List<sscprreportcertificate> getSscprReportcertificateList() {
      return (List<sscprreportcertificate>) get(PROPERTY_SSCPRREPORTCERTIFICATELIST);
    }

    public void setSscprReportcertificateList(List<sscprreportcertificate> sscprReportcertificateList) {
        set(PROPERTY_SSCPRREPORTCERTIFICATELIST, sscprReportcertificateList);
    }

    @SuppressWarnings("unchecked")
    public List<ssctcontract> getSsctContractList() {
      return (List<ssctcontract>) get(PROPERTY_SSCTCONTRACTLIST);
    }

    public void setSsctContractList(List<ssctcontract> ssctContractList) {
        set(PROPERTY_SSCTCONTRACTLIST, ssctContractList);
    }

    @SuppressWarnings("unchecked")
    public List<SsfiFinancialUser> getSsfiFinancialUserList() {
      return (List<SsfiFinancialUser>) get(PROPERTY_SSFIFINANCIALUSERLIST);
    }

    public void setSsfiFinancialUserList(List<SsfiFinancialUser> ssfiFinancialUserList) {
        set(PROPERTY_SSFIFINANCIALUSERLIST, ssfiFinancialUserList);
    }

    @SuppressWarnings("unchecked")
    public List<ssfwapprovaldoctype> getSsfwApprovalDoctypeList() {
      return (List<ssfwapprovaldoctype>) get(PROPERTY_SSFWAPPROVALDOCTYPELIST);
    }

    public void setSsfwApprovalDoctypeList(List<ssfwapprovaldoctype> ssfwApprovalDoctypeList) {
        set(PROPERTY_SSFWAPPROVALDOCTYPELIST, ssfwApprovalDoctypeList);
    }

    @SuppressWarnings("unchecked")
    public List<sspremployeesettlement> getSsprEmployeesettlementList() {
      return (List<sspremployeesettlement>) get(PROPERTY_SSPREMPLOYEESETTLEMENTLIST);
    }

    public void setSsprEmployeesettlementList(List<sspremployeesettlement> ssprEmployeesettlementList) {
        set(PROPERTY_SSPREMPLOYEESETTLEMENTLIST, ssprEmployeesettlementList);
    }

    @SuppressWarnings("unchecked")
    public List<ssprloans> getSsprLoansEMSfprCDoctypeIDList() {
      return (List<ssprloans>) get(PROPERTY_SSPRLOANSEMSFPRCDOCTYPEIDLIST);
    }

    public void setSsprLoansEMSfprCDoctypeIDList(List<ssprloans> ssprLoansEMSfprCDoctypeIDList) {
        set(PROPERTY_SSPRLOANSEMSFPRCDOCTYPEIDLIST, ssprLoansEMSfprCDoctypeIDList);
    }

    @SuppressWarnings("unchecked")
    public List<ssprpayrollpayment> getSsprPayrollpaymentList() {
      return (List<ssprpayrollpayment>) get(PROPERTY_SSPRPAYROLLPAYMENTLIST);
    }

    public void setSsprPayrollpaymentList(List<ssprpayrollpayment> ssprPayrollpaymentList) {
        set(PROPERTY_SSPRPAYROLLPAYMENTLIST, ssprPayrollpaymentList);
    }

    @SuppressWarnings("unchecked")
    public List<sspr_settlement> getSsprSettlementList() {
      return (List<sspr_settlement>) get(PROPERTY_SSPRSETTLEMENTLIST);
    }

    public void setSsprSettlementList(List<sspr_settlement> ssprSettlementList) {
        set(PROPERTY_SSPRSETTLEMENTLIST, ssprSettlementList);
    }

    @SuppressWarnings("unchecked")
    public List<SswhWithhCardCredit> getSswhWithhCardCreditList() {
      return (List<SswhWithhCardCredit>) get(PROPERTY_SSWHWITHHCARDCREDITLIST);
    }

    public void setSswhWithhCardCreditList(List<SswhWithhCardCredit> sswhWithhCardCreditList) {
        set(PROPERTY_SSWHWITHHCARDCREDITLIST, sswhWithhCardCreditList);
    }

    @SuppressWarnings("unchecked")
    public List<SswhWithholdingsVoided> getSswhWithholdingsVoidedList() {
      return (List<SswhWithholdingsVoided>) get(PROPERTY_SSWHWITHHOLDINGSVOIDEDLIST);
    }

    public void setSswhWithholdingsVoidedList(List<SswhWithholdingsVoided> sswhWithholdingsVoidedList) {
        set(PROPERTY_SSWHWITHHOLDINGSVOIDEDLIST, sswhWithholdingsVoidedList);
    }

    @SuppressWarnings("unchecked")
    public List<SswhWithholdingsVoided> getSswhWithholdingsVoidedCDoctype2IDList() {
      return (List<SswhWithholdingsVoided>) get(PROPERTY_SSWHWITHHOLDINGSVOIDEDCDOCTYPE2IDLIST);
    }

    public void setSswhWithholdingsVoidedCDoctype2IDList(List<SswhWithholdingsVoided> sswhWithholdingsVoidedCDoctype2IDList) {
        set(PROPERTY_SSWHWITHHOLDINGSVOIDEDCDOCTYPE2IDLIST, sswhWithholdingsVoidedCDoctype2IDList);
    }

}
