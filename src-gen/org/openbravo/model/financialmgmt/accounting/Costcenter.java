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
package org.openbravo.model.financialmgmt.accounting;

import com.sidesoft.ecuador.asset.allocation.SsalApplActive;
import com.sidesoft.ecuador.asset.allocation.ssalassetreturnline;
import com.sidesoft.ecuador.humanResources.sshrDepartment;
import com.sidesoft.flopec.InvoiceVoyage;
import com.sidesoft.flopec.UserDimension1CostCenter;
import com.sidesoft.flopec.budget.data.SFBBudgetCertLine;
import com.sidesoft.flopec.budget.data.SFBBudgetConfiguration;
import com.sidesoft.flopec.budget.data.SFBBudgetLine;
import com.sidesoft.flopec.budget.data.SFBBudgetLog;
import com.sidesoft.flopec.budget.data.SFBDeferredInvoice;
import com.sidesoft.flopec.budget.data.sfb_budget_details_v;
import com.sidesoft.flopec.budget.data.sfb_budget_log_v;
import com.sidesoft.flopec.budget.data.sfbbudgetaddline;
import com.sidesoft.flopec.ssflLoad_type;
import com.sidesoft.flopec.ssflRecap;
import com.sidesoft.flopec.ssflVesseltype;
import com.sidesoft.hrm.payroll.ConceptAcct;
import com.sidesoft.hrm.payroll.PayrollTicket;
import com.sidesoft.hrm.payroll.advanced.SfprEmployeeRve;
import com.sidesoft.hrm.payroll.advanced.SfprEmployeeSituation;
import com.sidesoft.hrm.payroll.advanced.SfprEmployeeSituationProposal;
import com.sidesoft.hrm.payroll.advanced.SfprProvisionProperty;
import com.sidesoft.hrm.payroll.advanced.SfprRveDetail;
import com.sidesoft.hrm.payroll.disaccounting.sspdpctdistcostcenter;
import com.sidesoft.hrm.payroll.ssprleaveemp;

import ec.com.sidesoft.budget.payroll.SSBPNoBudgetCertLine;
import ec.com.sidesoft.budget.transfers.SfbtrBudgetaryReforms;
import ec.com.sidesoft.budget.transfers.SfbtrTransferFrom;
import ec.com.sidesoft.budget.transfers.SfbtrTransferTo;
import ec.com.sidesoft.custom.budget.direct.SCBDBudgetDirect;
import ec.com.sidesoft.custom.payroll.partialpayment.scppapprovalpaymentline;
import ec.com.sidesoft.dimension.byrole.SdbrlcCostcenterDim;
import ec.com.sidesoft.localization.ecuador.viatical.SSVEViatical;
import ec.com.sidesoft.localization.ecuador.viatical.SSVEViaticalSettlement;
import ec.com.sidesoft.localization.ecuador.viatical.ssve_budget_details_v;
import ec.com.sidesoft.quick.billing.SqbConfigQuickBilling;
import ec.com.sidesoft.secondary.accounting.AccountingFactSecondary;
import ec.com.sidesoft.secondary.accounting.SSACCTJOURNAL;
import ec.com.sidesoft.secondary.accounting.SSACCTJournalLine;
import ec.com.sidesoft.ws.invoicecreate.data.SWSICConfig;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openbravo.advpaymentmngt.APRM_FinaccTransactionV;
import org.openbravo.advpaymentmngt.FinAccTransactionAccounting;
import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.geography.Country;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.common.invoice.InvoiceLine;
import org.openbravo.model.common.invoice.InvoiceLineAccountingDimension;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.common.order.OrderLine;
import org.openbravo.model.common.order.OrderLineAccountingDimension;
import org.openbravo.model.financialmgmt.accounting.coa.AccountingCombination;
import org.openbravo.model.financialmgmt.assetmgmt.AmortizationLine;
import org.openbravo.model.financialmgmt.assetmgmt.AmortizationLineAccountingDimension;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
import org.openbravo.model.financialmgmt.gl.GLJournal;
import org.openbravo.model.financialmgmt.gl.GLJournalLine;
import org.openbravo.model.financialmgmt.payment.DoubtfulDebt;
import org.openbravo.model.financialmgmt.payment.FIN_FinaccTransaction;
import org.openbravo.model.financialmgmt.payment.FIN_Payment;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentDetail;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentScheduleDetail;
import org.openbravo.model.materialmgmt.transaction.InOutLineAccountingDimension;
import org.openbravo.model.materialmgmt.transaction.InternalConsumption;
import org.openbravo.model.materialmgmt.transaction.InternalMovement;
import org.openbravo.model.materialmgmt.transaction.InventoryCount;
import org.openbravo.model.materialmgmt.transaction.ProductionTransaction;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOut;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOutLine;
import org.openbravo.model.timeandexpense.Sheet;
import org.openbravo.model.timeandexpense.SheetLine;
/**
 * Entity class for entity Costcenter (stored in table C_Costcenter).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Costcenter extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_Costcenter";
    public static final String ENTITY_NAME = "Costcenter";
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
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_SUMMARYLEVEL = "summaryLevel";
    public static final String PROPERTY_SSFLIMOVALUE = "ssflImovalue";
    public static final String PROPERTY_SSFLVESSELTYPE = "ssflVesselType";
    public static final String PROPERTY_SSFLLOADTYPE = "ssflLoadType";
    public static final String PROPERTY_SSFLISOWN = "ssflIsown";
    public static final String PROPERTY_SSFLTRV = "ssflTrv";
    public static final String PROPERTY_SSFLTONNAGE = "ssflTonnage";
    public static final String PROPERTY_SSFLCCOUNTRY = "ssflCCountry";
    public static final String PROPERTY_SSFLVALIDCOMBINATION = "ssflValidcombination";
    public static final String PROPERTY_APRMFINACCTRANSACTIONACCTVLIST = "aPRMFinAccTransactionAcctVList";
    public static final String PROPERTY_APRMFINACCTRANSACTIONVLIST = "aPRMFinaccTransactionVList";
    public static final String PROPERTY_AMORTIZATIONLINEACCOUNTINGDIMENSIONLIST = "amortizationLineAccountingDimensionList";
    public static final String PROPERTY_BUSINESSPARTNEREMSSPRCOSTCENTERIDLIST = "businessPartnerEMSsprCostcenterIDList";
    public static final String PROPERTY_FINDOUBTFULDEBTLIST = "fINDoubtfulDebtList";
    public static final String PROPERTY_FINFINACCTRANSACTIONLIST = "fINFinaccTransactionList";
    public static final String PROPERTY_FINPAYMENTLIST = "fINPaymentList";
    public static final String PROPERTY_FINPAYMENTDETAILEMSFBCCOSTCENTERIDLIST = "fINPaymentDetailEMSfbCCostcenterIDList";
    public static final String PROPERTY_FINPAYMENTSCHEDULEDETAILLIST = "fINPaymentScheduleDetailList";
    public static final String PROPERTY_FINANCIALMGMTACCOUNTINGFACTLIST = "financialMgmtAccountingFactList";
    public static final String PROPERTY_FINANCIALMGMTAMORTIZATIONLINELIST = "financialMgmtAmortizationLineList";
    public static final String PROPERTY_FINANCIALMGMTASSETLIST = "financialMgmtAssetList";
    public static final String PROPERTY_FINANCIALMGMTBUDGETLINELIST = "financialMgmtBudgetLineList";
    public static final String PROPERTY_FINANCIALMGMTGLJOURNALLIST = "financialMgmtGLJournalList";
    public static final String PROPERTY_FINANCIALMGMTGLJOURNALLINELIST = "financialMgmtGLJournalLineList";
    public static final String PROPERTY_INOUTLINEACCOUNTINGDIMENSIONLIST = "inOutLineAccountingDimensionList";
    public static final String PROPERTY_INVOICELIST = "invoiceList";
    public static final String PROPERTY_INVOICELINELIST = "invoiceLineList";
    public static final String PROPERTY_INVOICELINEACCOUNTINGDIMENSIONLIST = "invoiceLineAccountingDimensionList";
    public static final String PROPERTY_MATERIALMGMTINTERNALCONSUMPTIONLIST = "materialMgmtInternalConsumptionList";
    public static final String PROPERTY_MATERIALMGMTINTERNALMOVEMENTLIST = "materialMgmtInternalMovementList";
    public static final String PROPERTY_MATERIALMGMTINVENTORYCOUNTLIST = "materialMgmtInventoryCountList";
    public static final String PROPERTY_MATERIALMGMTPRODUCTIONTRANSACTIONLIST = "materialMgmtProductionTransactionList";
    public static final String PROPERTY_MATERIALMGMTSHIPMENTINOUTLIST = "materialMgmtShipmentInOutList";
    public static final String PROPERTY_MATERIALMGMTSHIPMENTINOUTLINELIST = "materialMgmtShipmentInOutLineList";
    public static final String PROPERTY_ORDERLIST = "orderList";
    public static final String PROPERTY_ORDERLINELIST = "orderLineList";
    public static final String PROPERTY_ORDERLINEACCOUNTINGDIMENSIONLIST = "orderLineAccountingDimensionList";
    public static final String PROPERTY_SCBDBUDGETDIRECTLIST = "sCBDBudgetDirectList";
    public static final String PROPERTY_SFBDEFERREDINVOICELIST = "sFBDeferredInvoiceList";
    public static final String PROPERTY_SSACCTACCOUNTINGFACTSECONDARYLIST = "sSACCTAccountingFactSecondaryList";
    public static final String PROPERTY_SSACCTJOURNALLIST = "sSACCTJOURNALList";
    public static final String PROPERTY_SSACCTJOURNALLINELIST = "sSACCTJournalLineList";
    public static final String PROPERTY_SSFLUSERDIMENSION1COSTCENTERLIST = "sSFLUserDimension1CostCenterList";
    public static final String PROPERTY_SSPRLEAVEEMPLIST = "sSPRLeaveEmpList";
    public static final String PROPERTY_SSPRPAYROLLTICKETEMSPRCCOSTCENTERIDLIST = "sSPRPayrollTicketEMSprcCostcenterIDList";
    public static final String PROPERTY_SSVEVIATICALLIST = "sSVEViaticalList";
    public static final String PROPERTY_SSVEVIATICALSETTLEMENTLIST = "sSVEViaticalSettlementList";
    public static final String PROPERTY_SWSICCONFIGLIST = "sWSICConfigList";
    public static final String PROPERTY_SFBTRBUDGETARYREFORMSLIST = "sfbtrBudgetaryReformsList";
    public static final String PROPERTY_SFBTRTRANSFERFROMLIST = "sfbtrTransferFromList";
    public static final String PROPERTY_SFBTRTRANSFERTOLIST = "sfbtrTransferToList";
    public static final String PROPERTY_TIMEANDEXPENSESHEETLIST = "timeAndExpenseSheetList";
    public static final String PROPERTY_TIMEANDEXPENSESHEETLINELIST = "timeAndExpenseSheetLineList";
    public static final String PROPERTY_USERDIMENSION2EMSSFLCCOSTCENTERIDLIST = "userDimension2EMSsflCCostcenterIDList";
    public static final String PROPERTY_SCPPAPPROVALPAYMENTLINELIST = "scppApprovalpaymentlineList";
    public static final String PROPERTY_SDBRLCCOSTCENTERDIMLIST = "sdbrlCCostcenterDimList";
    public static final String PROPERTY_SFBBUDGETADDLINELIST = "sfbBudgetAddlineList";
    public static final String PROPERTY_SFBBUDGETCERTLINELIST = "sfbBudgetCertLineList";
    public static final String PROPERTY_SFBBUDGETCONFIGURATIONLIST = "sfbBudgetConfigurationList";
    public static final String PROPERTY_SFBBUDGETDETAILSVLIST = "sfbBudgetDetailsVList";
    public static final String PROPERTY_SFBBUDGETLINELIST = "sfbBudgetLineList";
    public static final String PROPERTY_SFBBUDGETLOGLIST = "sfbBudgetLogList";
    public static final String PROPERTY_SFBBUDGETLOGCOSTCENTERTOLIST = "sfbBudgetLogCostCenterToList";
    public static final String PROPERTY_SFBBUDGETLOGVBUQUEIDLIST = "sfbBudgetLogVBuqueIDList";
    public static final String PROPERTY_SFPREMPLOYEERVELIST = "sfprEmployeeRveList";
    public static final String PROPERTY_SFPREMPLOYEESITUATIONLIST = "sfprEmployeeSituationList";
    public static final String PROPERTY_SFPREMPLOYEESITUATION2LIST = "sfprEmployeeSituation2List";
    public static final String PROPERTY_SFPRPROVISIONPROPERTYLIST = "sfprProvisionPropertyList";
    public static final String PROPERTY_SFPRRVEDETAILLIST = "sfprRveDetailList";
    public static final String PROPERTY_SQBCONFIGQUICKBILLINGLIST = "sqbConfigQuickbillingList";
    public static final String PROPERTY_SSALAPPLACTIVELIST = "ssalApplActiveList";
    public static final String PROPERTY_SSALASSETRETURNLINELIST = "ssalAssetReturnlineList";
    public static final String PROPERTY_SSBPNOBUDGETCERTLINELIST = "ssbpNoBudgetCertLineList";
    public static final String PROPERTY_SSFLINVOICEVOYAGELIST = "ssflInvoiceVoyageList";
    public static final String PROPERTY_SSFLRECAPLIST = "ssflRecapList";
    public static final String PROPERTY_SSHRDEPARTMENTLIST = "sshrDepartmentList";
    public static final String PROPERTY_SSPDPCTDISTCOSTCENTERLIST = "sspdPctdistCostcenterList";
    public static final String PROPERTY_SSPRCONCEPTACCTEMSSBPCCOSTCENTERIDLIST = "ssprConceptAcctEMSsbpCCostcenterIDList";
    public static final String PROPERTY_SSVEBUDGETDETAILSVLIST = "ssveBudgetDetailsVList";

    public Costcenter() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_SUMMARYLEVEL, false);
        setDefaultValue(PROPERTY_SSFLISOWN, true);
        setDefaultValue(PROPERTY_SSFLTONNAGE, new BigDecimal(0));
        setDefaultValue(PROPERTY_APRMFINACCTRANSACTIONACCTVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_APRMFINACCTRANSACTIONVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_AMORTIZATIONLINEACCOUNTINGDIMENSIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_BUSINESSPARTNEREMSSPRCOSTCENTERIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINDOUBTFULDEBTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINFINACCTRANSACTIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTDETAILEMSFBCCOSTCENTERIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTSCHEDULEDETAILLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTACCOUNTINGFACTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTAMORTIZATIONLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTASSETLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTBUDGETLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTGLJOURNALLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTGLJOURNALLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INOUTLINEACCOUNTINGDIMENSIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELINEACCOUNTINGDIMENSIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTINTERNALCONSUMPTIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTINTERNALMOVEMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTINVENTORYCOUNTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTPRODUCTIONTRANSACTIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTSHIPMENTINOUTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTSHIPMENTINOUTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERLINEACCOUNTINGDIMENSIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCBDBUDGETDIRECTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBDEFERREDINVOICELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSACCTACCOUNTINGFACTSECONDARYLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSACCTJOURNALLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSACCTJOURNALLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSFLUSERDIMENSION1COSTCENTERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRLEAVEEMPLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRPAYROLLTICKETEMSPRCCOSTCENTERIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSVEVIATICALLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSVEVIATICALSETTLEMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SWSICCONFIGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBTRBUDGETARYREFORMSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBTRTRANSFERFROMLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBTRTRANSFERTOLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_TIMEANDEXPENSESHEETLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_TIMEANDEXPENSESHEETLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_USERDIMENSION2EMSSFLCCOSTCENTERIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCPPAPPROVALPAYMENTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SDBRLCCOSTCENTERDIMLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETADDLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETCERTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETCONFIGURATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETDETAILSVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETLOGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETLOGCOSTCENTERTOLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETLOGVBUQUEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPREMPLOYEERVELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPREMPLOYEESITUATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPREMPLOYEESITUATION2LIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPRPROVISIONPROPERTYLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPRRVEDETAILLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SQBCONFIGQUICKBILLINGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALAPPLACTIVELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALASSETRETURNLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSBPNOBUDGETCERTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSFLINVOICEVOYAGELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSFLRECAPLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSHRDEPARTMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPDPCTDISTCOSTCENTERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRCONCEPTACCTEMSSBPCCOSTCENTERIDLIST, new ArrayList<Object>());
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

    public String getSsflImovalue() {
        return (String) get(PROPERTY_SSFLIMOVALUE);
    }

    public void setSsflImovalue(String ssflImovalue) {
        set(PROPERTY_SSFLIMOVALUE, ssflImovalue);
    }

    public ssflVesseltype getSsflVesselType() {
        return (ssflVesseltype) get(PROPERTY_SSFLVESSELTYPE);
    }

    public void setSsflVesselType(ssflVesseltype ssflVesselType) {
        set(PROPERTY_SSFLVESSELTYPE, ssflVesselType);
    }

    public ssflLoad_type getSsflLoadType() {
        return (ssflLoad_type) get(PROPERTY_SSFLLOADTYPE);
    }

    public void setSsflLoadType(ssflLoad_type ssflLoadType) {
        set(PROPERTY_SSFLLOADTYPE, ssflLoadType);
    }

    public Boolean isSsflIsown() {
        return (Boolean) get(PROPERTY_SSFLISOWN);
    }

    public void setSsflIsown(Boolean ssflIsown) {
        set(PROPERTY_SSFLISOWN, ssflIsown);
    }

    public String getSsflTrv() {
        return (String) get(PROPERTY_SSFLTRV);
    }

    public void setSsflTrv(String ssflTrv) {
        set(PROPERTY_SSFLTRV, ssflTrv);
    }

    public BigDecimal getSsflTonnage() {
        return (BigDecimal) get(PROPERTY_SSFLTONNAGE);
    }

    public void setSsflTonnage(BigDecimal ssflTonnage) {
        set(PROPERTY_SSFLTONNAGE, ssflTonnage);
    }

    public Country getSsflCCountry() {
        return (Country) get(PROPERTY_SSFLCCOUNTRY);
    }

    public void setSsflCCountry(Country ssflCCountry) {
        set(PROPERTY_SSFLCCOUNTRY, ssflCCountry);
    }

    public AccountingCombination getSsflValidcombination() {
        return (AccountingCombination) get(PROPERTY_SSFLVALIDCOMBINATION);
    }

    public void setSsflValidcombination(AccountingCombination ssflValidcombination) {
        set(PROPERTY_SSFLVALIDCOMBINATION, ssflValidcombination);
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
    public List<AmortizationLineAccountingDimension> getAmortizationLineAccountingDimensionList() {
      return (List<AmortizationLineAccountingDimension>) get(PROPERTY_AMORTIZATIONLINEACCOUNTINGDIMENSIONLIST);
    }

    public void setAmortizationLineAccountingDimensionList(List<AmortizationLineAccountingDimension> amortizationLineAccountingDimensionList) {
        set(PROPERTY_AMORTIZATIONLINEACCOUNTINGDIMENSIONLIST, amortizationLineAccountingDimensionList);
    }

    @SuppressWarnings("unchecked")
    public List<BusinessPartner> getBusinessPartnerEMSsprCostcenterIDList() {
      return (List<BusinessPartner>) get(PROPERTY_BUSINESSPARTNEREMSSPRCOSTCENTERIDLIST);
    }

    public void setBusinessPartnerEMSsprCostcenterIDList(List<BusinessPartner> businessPartnerEMSsprCostcenterIDList) {
        set(PROPERTY_BUSINESSPARTNEREMSSPRCOSTCENTERIDLIST, businessPartnerEMSsprCostcenterIDList);
    }

    @SuppressWarnings("unchecked")
    public List<DoubtfulDebt> getFINDoubtfulDebtList() {
      return (List<DoubtfulDebt>) get(PROPERTY_FINDOUBTFULDEBTLIST);
    }

    public void setFINDoubtfulDebtList(List<DoubtfulDebt> fINDoubtfulDebtList) {
        set(PROPERTY_FINDOUBTFULDEBTLIST, fINDoubtfulDebtList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_FinaccTransaction> getFINFinaccTransactionList() {
      return (List<FIN_FinaccTransaction>) get(PROPERTY_FINFINACCTRANSACTIONLIST);
    }

    public void setFINFinaccTransactionList(List<FIN_FinaccTransaction> fINFinaccTransactionList) {
        set(PROPERTY_FINFINACCTRANSACTIONLIST, fINFinaccTransactionList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_Payment> getFINPaymentList() {
      return (List<FIN_Payment>) get(PROPERTY_FINPAYMENTLIST);
    }

    public void setFINPaymentList(List<FIN_Payment> fINPaymentList) {
        set(PROPERTY_FINPAYMENTLIST, fINPaymentList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_PaymentDetail> getFINPaymentDetailEMSfbCCostcenterIDList() {
      return (List<FIN_PaymentDetail>) get(PROPERTY_FINPAYMENTDETAILEMSFBCCOSTCENTERIDLIST);
    }

    public void setFINPaymentDetailEMSfbCCostcenterIDList(List<FIN_PaymentDetail> fINPaymentDetailEMSfbCCostcenterIDList) {
        set(PROPERTY_FINPAYMENTDETAILEMSFBCCOSTCENTERIDLIST, fINPaymentDetailEMSfbCCostcenterIDList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_PaymentScheduleDetail> getFINPaymentScheduleDetailList() {
      return (List<FIN_PaymentScheduleDetail>) get(PROPERTY_FINPAYMENTSCHEDULEDETAILLIST);
    }

    public void setFINPaymentScheduleDetailList(List<FIN_PaymentScheduleDetail> fINPaymentScheduleDetailList) {
        set(PROPERTY_FINPAYMENTSCHEDULEDETAILLIST, fINPaymentScheduleDetailList);
    }

    @SuppressWarnings("unchecked")
    public List<AccountingFact> getFinancialMgmtAccountingFactList() {
      return (List<AccountingFact>) get(PROPERTY_FINANCIALMGMTACCOUNTINGFACTLIST);
    }

    public void setFinancialMgmtAccountingFactList(List<AccountingFact> financialMgmtAccountingFactList) {
        set(PROPERTY_FINANCIALMGMTACCOUNTINGFACTLIST, financialMgmtAccountingFactList);
    }

    @SuppressWarnings("unchecked")
    public List<AmortizationLine> getFinancialMgmtAmortizationLineList() {
      return (List<AmortizationLine>) get(PROPERTY_FINANCIALMGMTAMORTIZATIONLINELIST);
    }

    public void setFinancialMgmtAmortizationLineList(List<AmortizationLine> financialMgmtAmortizationLineList) {
        set(PROPERTY_FINANCIALMGMTAMORTIZATIONLINELIST, financialMgmtAmortizationLineList);
    }

    @SuppressWarnings("unchecked")
    public List<Asset> getFinancialMgmtAssetList() {
      return (List<Asset>) get(PROPERTY_FINANCIALMGMTASSETLIST);
    }

    public void setFinancialMgmtAssetList(List<Asset> financialMgmtAssetList) {
        set(PROPERTY_FINANCIALMGMTASSETLIST, financialMgmtAssetList);
    }

    @SuppressWarnings("unchecked")
    public List<BudgetLine> getFinancialMgmtBudgetLineList() {
      return (List<BudgetLine>) get(PROPERTY_FINANCIALMGMTBUDGETLINELIST);
    }

    public void setFinancialMgmtBudgetLineList(List<BudgetLine> financialMgmtBudgetLineList) {
        set(PROPERTY_FINANCIALMGMTBUDGETLINELIST, financialMgmtBudgetLineList);
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
    public List<InvoiceLine> getInvoiceLineList() {
      return (List<InvoiceLine>) get(PROPERTY_INVOICELINELIST);
    }

    public void setInvoiceLineList(List<InvoiceLine> invoiceLineList) {
        set(PROPERTY_INVOICELINELIST, invoiceLineList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceLineAccountingDimension> getInvoiceLineAccountingDimensionList() {
      return (List<InvoiceLineAccountingDimension>) get(PROPERTY_INVOICELINEACCOUNTINGDIMENSIONLIST);
    }

    public void setInvoiceLineAccountingDimensionList(List<InvoiceLineAccountingDimension> invoiceLineAccountingDimensionList) {
        set(PROPERTY_INVOICELINEACCOUNTINGDIMENSIONLIST, invoiceLineAccountingDimensionList);
    }

    @SuppressWarnings("unchecked")
    public List<InternalConsumption> getMaterialMgmtInternalConsumptionList() {
      return (List<InternalConsumption>) get(PROPERTY_MATERIALMGMTINTERNALCONSUMPTIONLIST);
    }

    public void setMaterialMgmtInternalConsumptionList(List<InternalConsumption> materialMgmtInternalConsumptionList) {
        set(PROPERTY_MATERIALMGMTINTERNALCONSUMPTIONLIST, materialMgmtInternalConsumptionList);
    }

    @SuppressWarnings("unchecked")
    public List<InternalMovement> getMaterialMgmtInternalMovementList() {
      return (List<InternalMovement>) get(PROPERTY_MATERIALMGMTINTERNALMOVEMENTLIST);
    }

    public void setMaterialMgmtInternalMovementList(List<InternalMovement> materialMgmtInternalMovementList) {
        set(PROPERTY_MATERIALMGMTINTERNALMOVEMENTLIST, materialMgmtInternalMovementList);
    }

    @SuppressWarnings("unchecked")
    public List<InventoryCount> getMaterialMgmtInventoryCountList() {
      return (List<InventoryCount>) get(PROPERTY_MATERIALMGMTINVENTORYCOUNTLIST);
    }

    public void setMaterialMgmtInventoryCountList(List<InventoryCount> materialMgmtInventoryCountList) {
        set(PROPERTY_MATERIALMGMTINVENTORYCOUNTLIST, materialMgmtInventoryCountList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductionTransaction> getMaterialMgmtProductionTransactionList() {
      return (List<ProductionTransaction>) get(PROPERTY_MATERIALMGMTPRODUCTIONTRANSACTIONLIST);
    }

    public void setMaterialMgmtProductionTransactionList(List<ProductionTransaction> materialMgmtProductionTransactionList) {
        set(PROPERTY_MATERIALMGMTPRODUCTIONTRANSACTIONLIST, materialMgmtProductionTransactionList);
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
    public List<UserDimension1CostCenter> getSSFLUserDimension1CostCenterList() {
      return (List<UserDimension1CostCenter>) get(PROPERTY_SSFLUSERDIMENSION1COSTCENTERLIST);
    }

    public void setSSFLUserDimension1CostCenterList(List<UserDimension1CostCenter> sSFLUserDimension1CostCenterList) {
        set(PROPERTY_SSFLUSERDIMENSION1COSTCENTERLIST, sSFLUserDimension1CostCenterList);
    }

    @SuppressWarnings("unchecked")
    public List<ssprleaveemp> getSSPRLeaveEmpList() {
      return (List<ssprleaveemp>) get(PROPERTY_SSPRLEAVEEMPLIST);
    }

    public void setSSPRLeaveEmpList(List<ssprleaveemp> sSPRLeaveEmpList) {
        set(PROPERTY_SSPRLEAVEEMPLIST, sSPRLeaveEmpList);
    }

    @SuppressWarnings("unchecked")
    public List<PayrollTicket> getSSPRPayrollTicketEMSprcCostcenterIDList() {
      return (List<PayrollTicket>) get(PROPERTY_SSPRPAYROLLTICKETEMSPRCCOSTCENTERIDLIST);
    }

    public void setSSPRPayrollTicketEMSprcCostcenterIDList(List<PayrollTicket> sSPRPayrollTicketEMSprcCostcenterIDList) {
        set(PROPERTY_SSPRPAYROLLTICKETEMSPRCCOSTCENTERIDLIST, sSPRPayrollTicketEMSprcCostcenterIDList);
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
    public List<SWSICConfig> getSWSICConfigList() {
      return (List<SWSICConfig>) get(PROPERTY_SWSICCONFIGLIST);
    }

    public void setSWSICConfigList(List<SWSICConfig> sWSICConfigList) {
        set(PROPERTY_SWSICCONFIGLIST, sWSICConfigList);
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
    public List<UserDimension2> getUserDimension2EMSsflCCostcenterIDList() {
      return (List<UserDimension2>) get(PROPERTY_USERDIMENSION2EMSSFLCCOSTCENTERIDLIST);
    }

    public void setUserDimension2EMSsflCCostcenterIDList(List<UserDimension2> userDimension2EMSsflCCostcenterIDList) {
        set(PROPERTY_USERDIMENSION2EMSSFLCCOSTCENTERIDLIST, userDimension2EMSsflCCostcenterIDList);
    }

    @SuppressWarnings("unchecked")
    public List<scppapprovalpaymentline> getScppApprovalpaymentlineList() {
      return (List<scppapprovalpaymentline>) get(PROPERTY_SCPPAPPROVALPAYMENTLINELIST);
    }

    public void setScppApprovalpaymentlineList(List<scppapprovalpaymentline> scppApprovalpaymentlineList) {
        set(PROPERTY_SCPPAPPROVALPAYMENTLINELIST, scppApprovalpaymentlineList);
    }

    @SuppressWarnings("unchecked")
    public List<SdbrlcCostcenterDim> getSdbrlCCostcenterDimList() {
      return (List<SdbrlcCostcenterDim>) get(PROPERTY_SDBRLCCOSTCENTERDIMLIST);
    }

    public void setSdbrlCCostcenterDimList(List<SdbrlcCostcenterDim> sdbrlCCostcenterDimList) {
        set(PROPERTY_SDBRLCCOSTCENTERDIMLIST, sdbrlCCostcenterDimList);
    }

    @SuppressWarnings("unchecked")
    public List<sfbbudgetaddline> getSfbBudgetAddlineList() {
      return (List<sfbbudgetaddline>) get(PROPERTY_SFBBUDGETADDLINELIST);
    }

    public void setSfbBudgetAddlineList(List<sfbbudgetaddline> sfbBudgetAddlineList) {
        set(PROPERTY_SFBBUDGETADDLINELIST, sfbBudgetAddlineList);
    }

    @SuppressWarnings("unchecked")
    public List<SFBBudgetCertLine> getSfbBudgetCertLineList() {
      return (List<SFBBudgetCertLine>) get(PROPERTY_SFBBUDGETCERTLINELIST);
    }

    public void setSfbBudgetCertLineList(List<SFBBudgetCertLine> sfbBudgetCertLineList) {
        set(PROPERTY_SFBBUDGETCERTLINELIST, sfbBudgetCertLineList);
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
    public List<SFBBudgetLog> getSfbBudgetLogCostCenterToList() {
      return (List<SFBBudgetLog>) get(PROPERTY_SFBBUDGETLOGCOSTCENTERTOLIST);
    }

    public void setSfbBudgetLogCostCenterToList(List<SFBBudgetLog> sfbBudgetLogCostCenterToList) {
        set(PROPERTY_SFBBUDGETLOGCOSTCENTERTOLIST, sfbBudgetLogCostCenterToList);
    }

    @SuppressWarnings("unchecked")
    public List<sfb_budget_log_v> getSfbBudgetLogVBuqueIDList() {
      return (List<sfb_budget_log_v>) get(PROPERTY_SFBBUDGETLOGVBUQUEIDLIST);
    }

    public void setSfbBudgetLogVBuqueIDList(List<sfb_budget_log_v> sfbBudgetLogVBuqueIDList) {
        set(PROPERTY_SFBBUDGETLOGVBUQUEIDLIST, sfbBudgetLogVBuqueIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprEmployeeRve> getSfprEmployeeRveList() {
      return (List<SfprEmployeeRve>) get(PROPERTY_SFPREMPLOYEERVELIST);
    }

    public void setSfprEmployeeRveList(List<SfprEmployeeRve> sfprEmployeeRveList) {
        set(PROPERTY_SFPREMPLOYEERVELIST, sfprEmployeeRveList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprEmployeeSituation> getSfprEmployeeSituationList() {
      return (List<SfprEmployeeSituation>) get(PROPERTY_SFPREMPLOYEESITUATIONLIST);
    }

    public void setSfprEmployeeSituationList(List<SfprEmployeeSituation> sfprEmployeeSituationList) {
        set(PROPERTY_SFPREMPLOYEESITUATIONLIST, sfprEmployeeSituationList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprEmployeeSituationProposal> getSfprEmployeeSituation2List() {
      return (List<SfprEmployeeSituationProposal>) get(PROPERTY_SFPREMPLOYEESITUATION2LIST);
    }

    public void setSfprEmployeeSituation2List(List<SfprEmployeeSituationProposal> sfprEmployeeSituation2List) {
        set(PROPERTY_SFPREMPLOYEESITUATION2LIST, sfprEmployeeSituation2List);
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
    public List<SqbConfigQuickBilling> getSqbConfigQuickbillingList() {
      return (List<SqbConfigQuickBilling>) get(PROPERTY_SQBCONFIGQUICKBILLINGLIST);
    }

    public void setSqbConfigQuickbillingList(List<SqbConfigQuickBilling> sqbConfigQuickbillingList) {
        set(PROPERTY_SQBCONFIGQUICKBILLINGLIST, sqbConfigQuickbillingList);
    }

    @SuppressWarnings("unchecked")
    public List<SsalApplActive> getSsalApplActiveList() {
      return (List<SsalApplActive>) get(PROPERTY_SSALAPPLACTIVELIST);
    }

    public void setSsalApplActiveList(List<SsalApplActive> ssalApplActiveList) {
        set(PROPERTY_SSALAPPLACTIVELIST, ssalApplActiveList);
    }

    @SuppressWarnings("unchecked")
    public List<ssalassetreturnline> getSsalAssetReturnlineList() {
      return (List<ssalassetreturnline>) get(PROPERTY_SSALASSETRETURNLINELIST);
    }

    public void setSsalAssetReturnlineList(List<ssalassetreturnline> ssalAssetReturnlineList) {
        set(PROPERTY_SSALASSETRETURNLINELIST, ssalAssetReturnlineList);
    }

    @SuppressWarnings("unchecked")
    public List<SSBPNoBudgetCertLine> getSsbpNoBudgetCertLineList() {
      return (List<SSBPNoBudgetCertLine>) get(PROPERTY_SSBPNOBUDGETCERTLINELIST);
    }

    public void setSsbpNoBudgetCertLineList(List<SSBPNoBudgetCertLine> ssbpNoBudgetCertLineList) {
        set(PROPERTY_SSBPNOBUDGETCERTLINELIST, ssbpNoBudgetCertLineList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceVoyage> getSsflInvoiceVoyageList() {
      return (List<InvoiceVoyage>) get(PROPERTY_SSFLINVOICEVOYAGELIST);
    }

    public void setSsflInvoiceVoyageList(List<InvoiceVoyage> ssflInvoiceVoyageList) {
        set(PROPERTY_SSFLINVOICEVOYAGELIST, ssflInvoiceVoyageList);
    }

    @SuppressWarnings("unchecked")
    public List<ssflRecap> getSsflRecapList() {
      return (List<ssflRecap>) get(PROPERTY_SSFLRECAPLIST);
    }

    public void setSsflRecapList(List<ssflRecap> ssflRecapList) {
        set(PROPERTY_SSFLRECAPLIST, ssflRecapList);
    }

    @SuppressWarnings("unchecked")
    public List<sshrDepartment> getSshrDepartmentList() {
      return (List<sshrDepartment>) get(PROPERTY_SSHRDEPARTMENTLIST);
    }

    public void setSshrDepartmentList(List<sshrDepartment> sshrDepartmentList) {
        set(PROPERTY_SSHRDEPARTMENTLIST, sshrDepartmentList);
    }

    @SuppressWarnings("unchecked")
    public List<sspdpctdistcostcenter> getSspdPctdistCostcenterList() {
      return (List<sspdpctdistcostcenter>) get(PROPERTY_SSPDPCTDISTCOSTCENTERLIST);
    }

    public void setSspdPctdistCostcenterList(List<sspdpctdistcostcenter> sspdPctdistCostcenterList) {
        set(PROPERTY_SSPDPCTDISTCOSTCENTERLIST, sspdPctdistCostcenterList);
    }

    @SuppressWarnings("unchecked")
    public List<ConceptAcct> getSsprConceptAcctEMSsbpCCostcenterIDList() {
      return (List<ConceptAcct>) get(PROPERTY_SSPRCONCEPTACCTEMSSBPCCOSTCENTERIDLIST);
    }

    public void setSsprConceptAcctEMSsbpCCostcenterIDList(List<ConceptAcct> ssprConceptAcctEMSsbpCCostcenterIDList) {
        set(PROPERTY_SSPRCONCEPTACCTEMSSBPCCOSTCENTERIDLIST, ssprConceptAcctEMSsbpCCostcenterIDList);
    }

    @SuppressWarnings("unchecked")
    public List<ssve_budget_details_v> getSsveBudgetDetailsVList() {
      return (List<ssve_budget_details_v>) get(PROPERTY_SSVEBUDGETDETAILSVLIST);
    }

    public void setSsveBudgetDetailsVList(List<ssve_budget_details_v> ssveBudgetDetailsVList) {
        set(PROPERTY_SSVEBUDGETDETAILSVLIST, ssveBudgetDetailsVList);
    }

}
