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
package org.openbravo.model.financialmgmt.calendar;

import com.sidesoft.flopec.budget.data.SFBBudgetCertificate;
import com.sidesoft.hrm.payroll.ConceptAmount;
import com.sidesoft.hrm.payroll.CumulativeConcept;
import com.sidesoft.hrm.payroll.Payroll;
import com.sidesoft.hrm.payroll.SsprConfigurationUtility;
import com.sidesoft.hrm.payroll.advanced.SfprRveDetail;
import com.sidesoft.hrm.payroll.advanced.SfprSurrogateDetail;
import com.sidesoft.hrm.payroll.disaccounting.sspdpctdist;
import com.sidesoft.hrm.payroll.ssprline_loans;
import com.sidesoft.hrm.payroll.ssprpayrollaut;
import com.sidesoft.localization.ecuador.withholdings.SswhRptcSalesDet;

import ec.com.sidesoft.custom.payroll.partialpayment.scppapprovalpayment;
import ec.com.sidesoft.secondary.accounting.AccountingFactSecondary;
import ec.com.sidesoft.secondary.accounting.SSACCTJOURNAL;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openbravo.advpaymentmngt.APRM_Finacc_Trx_Full_Acct_V;
import org.openbravo.advpaymentmngt.FinAccTransactionAccounting;
import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.invoice.InvoiceLine;
import org.openbravo.model.financialmgmt.accounting.AccountingFact;
import org.openbravo.model.financialmgmt.accounting.BudgetLine;
import org.openbravo.model.financialmgmt.accounting.coa.AcctSchema;
import org.openbravo.model.financialmgmt.gl.GLBatch;
import org.openbravo.model.financialmgmt.gl.GLJournal;
import org.openbravo.model.materialmgmt.onhandquantity.ValuedStockAggregated;
/**
 * Entity class for entity FinancialMgmtPeriod (stored in table C_Period).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Period extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_Period";
    public static final String ENTITY_NAME = "FinancialMgmtPeriod";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_PERIODNO = "periodNo";
    public static final String PROPERTY_YEAR = "year";
    public static final String PROPERTY_STARTINGDATE = "startingDate";
    public static final String PROPERTY_ENDINGDATE = "endingDate";
    public static final String PROPERTY_PERIODTYPE = "periodType";
    public static final String PROPERTY_PROCESSNOW = "processNow";
    public static final String PROPERTY_CLOSINGFACTACCTGROUP = "closingFactAcctGroup";
    public static final String PROPERTY_REGULARIZATIONFACTACCTGROUP = "regularizationFactAcctGroup";
    public static final String PROPERTY_DIVIDEUPFACTACCTGROUP = "divideupFactAcctGroup";
    public static final String PROPERTY_OPENFACTACCTGROUP = "openFactAcctGroup";
    public static final String PROPERTY_OPENCLOSE = "openClose";
    public static final String PROPERTY__COMPUTEDCOLUMNS = "_computedColumns";
    public static final String PROPERTY_APRMFINACCTRANSACTIONACCTVLIST = "aPRMFinAccTransactionAcctVList";
    public static final String PROPERTY_APRMFINACCTRXFULLACCTVLIST = "aPRMFinaccTrxFullAcctVList";
    public static final String PROPERTY_FINANCIALMGMTACCOUNTINGFACTLIST = "financialMgmtAccountingFactList";
    public static final String PROPERTY_FINANCIALMGMTACCTSCHEMALIST = "financialMgmtAcctSchemaList";
    public static final String PROPERTY_FINANCIALMGMTBUDGETLINELIST = "financialMgmtBudgetLineList";
    public static final String PROPERTY_FINANCIALMGMTGLBATCHLIST = "financialMgmtGLBatchList";
    public static final String PROPERTY_FINANCIALMGMTGLJOURNALLIST = "financialMgmtGLJournalList";
    public static final String PROPERTY_FINANCIALMGMTPERIODCONTROLLIST = "financialMgmtPeriodControlList";
    public static final String PROPERTY_FINANCIALMGMTPERIODCONTROLVLIST = "financialMgmtPeriodControlVList";
    public static final String PROPERTY_INVOICELINELIST = "invoiceLineList";
    public static final String PROPERTY_PERIODCONTROLLOGPERIODNOLIST = "periodControlLogPeriodNoList";
    public static final String PROPERTY_PERIODCONTROLLOGLIST = "periodControlLogList";
    public static final String PROPERTY_SSACCTACCOUNTINGFACTSECONDARYLIST = "sSACCTAccountingFactSecondaryList";
    public static final String PROPERTY_SSACCTJOURNALLIST = "sSACCTJOURNALList";
    public static final String PROPERTY_SSPRCONCEPTAMOUNTLIST = "sSPRConceptAmountList";
    public static final String PROPERTY_SSPRPAYROLLLIST = "sSPRPayrollList";
    public static final String PROPERTY_SSPRPERIODLIST = "sSPRPeriodList";
    public static final String PROPERTY_SSWHRPTCSALESDETLIST = "sswhRptcSalesDetList";
    public static final String PROPERTY_VALUEDSTOCKAGGREGATEDLIST = "valuedStockAggregatedList";
    public static final String PROPERTY_SCPPAPPROVALPAYMENTLIST = "scppApprovalpaymentList";
    public static final String PROPERTY_SFBBUDGETCERTIFICATEEMSSBPCPERIODIDLIST = "sfbBudgetCertificateEMSsbpCPeriodIDList";
    public static final String PROPERTY_SFPRRVEDETAILLIST = "sfprRveDetailList";
    public static final String PROPERTY_SFPRRVEDETAILPERIODPROCESSLIST = "sfprRveDetailPeriodProcessList";
    public static final String PROPERTY_SFPRSURROGATEDETAILLIST = "sfprSurrogateDetailList";
    public static final String PROPERTY_SFPRSURROGATEDETAILPERIODPROCESSEDLIST = "sfprSurrogateDetailPeriodProcessedList";
    public static final String PROPERTY_SSPDPCTDISTLIST = "sspdPctdistList";
    public static final String PROPERTY_SSPRCONFIGURATIONUTILITYLIST = "ssprConfigurationutilityList";
    public static final String PROPERTY_SSPRCUMULATIVECONCEPTLIST = "ssprCumulativeconceptList";
    public static final String PROPERTY_SSPRLINELOANSLIST = "ssprLineLoansList";
    public static final String PROPERTY_SSPRPAYROLLAUTLIST = "ssprPayrollAutList";


    // Computed columns properties, these properties cannot be directly accessed, they need
    // to be read through _commputedColumns proxy. They cannot be directly used in HQL, OBQuery
    // nor OBCriteria. 
    public static final String COMPUTED_COLUMN_STATUS = "status";

    public Period() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_PERIODTYPE, "S");
        setDefaultValue(PROPERTY_PROCESSNOW, false);
        setDefaultValue(PROPERTY_OPENCLOSE, "O");
        setDefaultValue(PROPERTY_APRMFINACCTRANSACTIONACCTVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_APRMFINACCTRXFULLACCTVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTACCOUNTINGFACTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTACCTSCHEMALIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTBUDGETLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTGLBATCHLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTGLJOURNALLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTPERIODCONTROLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTPERIODCONTROLVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PERIODCONTROLLOGPERIODNOLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PERIODCONTROLLOGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSACCTACCOUNTINGFACTSECONDARYLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSACCTJOURNALLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRCONCEPTAMOUNTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRPAYROLLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRPERIODLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWHRPTCSALESDETLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_VALUEDSTOCKAGGREGATEDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCPPAPPROVALPAYMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETCERTIFICATEEMSSBPCPERIODIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPRRVEDETAILLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPRRVEDETAILPERIODPROCESSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPRSURROGATEDETAILLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPRSURROGATEDETAILPERIODPROCESSEDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPDPCTDISTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRCONFIGURATIONUTILITYLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRCUMULATIVECONCEPTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRLINELOANSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRPAYROLLAUTLIST, new ArrayList<Object>());
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

    public Long getPeriodNo() {
        return (Long) get(PROPERTY_PERIODNO);
    }

    public void setPeriodNo(Long periodNo) {
        set(PROPERTY_PERIODNO, periodNo);
    }

    public Year getYear() {
        return (Year) get(PROPERTY_YEAR);
    }

    public void setYear(Year year) {
        set(PROPERTY_YEAR, year);
    }

    public Date getStartingDate() {
        return (Date) get(PROPERTY_STARTINGDATE);
    }

    public void setStartingDate(Date startingDate) {
        set(PROPERTY_STARTINGDATE, startingDate);
    }

    public Date getEndingDate() {
        return (Date) get(PROPERTY_ENDINGDATE);
    }

    public void setEndingDate(Date endingDate) {
        set(PROPERTY_ENDINGDATE, endingDate);
    }

    public String getPeriodType() {
        return (String) get(PROPERTY_PERIODTYPE);
    }

    public void setPeriodType(String periodType) {
        set(PROPERTY_PERIODTYPE, periodType);
    }

    public Boolean isProcessNow() {
        return (Boolean) get(PROPERTY_PROCESSNOW);
    }

    public void setProcessNow(Boolean processNow) {
        set(PROPERTY_PROCESSNOW, processNow);
    }

    public String getClosingFactAcctGroup() {
        return (String) get(PROPERTY_CLOSINGFACTACCTGROUP);
    }

    public void setClosingFactAcctGroup(String closingFactAcctGroup) {
        set(PROPERTY_CLOSINGFACTACCTGROUP, closingFactAcctGroup);
    }

    public String getRegularizationFactAcctGroup() {
        return (String) get(PROPERTY_REGULARIZATIONFACTACCTGROUP);
    }

    public void setRegularizationFactAcctGroup(String regularizationFactAcctGroup) {
        set(PROPERTY_REGULARIZATIONFACTACCTGROUP, regularizationFactAcctGroup);
    }

    public String getDivideupFactAcctGroup() {
        return (String) get(PROPERTY_DIVIDEUPFACTACCTGROUP);
    }

    public void setDivideupFactAcctGroup(String divideupFactAcctGroup) {
        set(PROPERTY_DIVIDEUPFACTACCTGROUP, divideupFactAcctGroup);
    }

    public String getOpenFactAcctGroup() {
        return (String) get(PROPERTY_OPENFACTACCTGROUP);
    }

    public void setOpenFactAcctGroup(String openFactAcctGroup) {
        set(PROPERTY_OPENFACTACCTGROUP, openFactAcctGroup);
    }

    public String getOpenClose() {
        return (String) get(PROPERTY_OPENCLOSE);
    }

    public void setOpenClose(String openClose) {
        set(PROPERTY_OPENCLOSE, openClose);
    }

    public String getStatus() {
        return (String) get(COMPUTED_COLUMN_STATUS);
    }

    public void setStatus(String status) {
        set(COMPUTED_COLUMN_STATUS, status);
    }

    public Period_ComputedColumns get_computedColumns() {
        return (Period_ComputedColumns) get(PROPERTY__COMPUTEDCOLUMNS);
    }

    public void set_computedColumns(Period_ComputedColumns _computedColumns) {
        set(PROPERTY__COMPUTEDCOLUMNS, _computedColumns);
    }

    @SuppressWarnings("unchecked")
    public List<FinAccTransactionAccounting> getAPRMFinAccTransactionAcctVList() {
      return (List<FinAccTransactionAccounting>) get(PROPERTY_APRMFINACCTRANSACTIONACCTVLIST);
    }

    public void setAPRMFinAccTransactionAcctVList(List<FinAccTransactionAccounting> aPRMFinAccTransactionAcctVList) {
        set(PROPERTY_APRMFINACCTRANSACTIONACCTVLIST, aPRMFinAccTransactionAcctVList);
    }

    @SuppressWarnings("unchecked")
    public List<APRM_Finacc_Trx_Full_Acct_V> getAPRMFinaccTrxFullAcctVList() {
      return (List<APRM_Finacc_Trx_Full_Acct_V>) get(PROPERTY_APRMFINACCTRXFULLACCTVLIST);
    }

    public void setAPRMFinaccTrxFullAcctVList(List<APRM_Finacc_Trx_Full_Acct_V> aPRMFinaccTrxFullAcctVList) {
        set(PROPERTY_APRMFINACCTRXFULLACCTVLIST, aPRMFinaccTrxFullAcctVList);
    }

    @SuppressWarnings("unchecked")
    public List<AccountingFact> getFinancialMgmtAccountingFactList() {
      return (List<AccountingFact>) get(PROPERTY_FINANCIALMGMTACCOUNTINGFACTLIST);
    }

    public void setFinancialMgmtAccountingFactList(List<AccountingFact> financialMgmtAccountingFactList) {
        set(PROPERTY_FINANCIALMGMTACCOUNTINGFACTLIST, financialMgmtAccountingFactList);
    }

    @SuppressWarnings("unchecked")
    public List<AcctSchema> getFinancialMgmtAcctSchemaList() {
      return (List<AcctSchema>) get(PROPERTY_FINANCIALMGMTACCTSCHEMALIST);
    }

    public void setFinancialMgmtAcctSchemaList(List<AcctSchema> financialMgmtAcctSchemaList) {
        set(PROPERTY_FINANCIALMGMTACCTSCHEMALIST, financialMgmtAcctSchemaList);
    }

    @SuppressWarnings("unchecked")
    public List<BudgetLine> getFinancialMgmtBudgetLineList() {
      return (List<BudgetLine>) get(PROPERTY_FINANCIALMGMTBUDGETLINELIST);
    }

    public void setFinancialMgmtBudgetLineList(List<BudgetLine> financialMgmtBudgetLineList) {
        set(PROPERTY_FINANCIALMGMTBUDGETLINELIST, financialMgmtBudgetLineList);
    }

    @SuppressWarnings("unchecked")
    public List<GLBatch> getFinancialMgmtGLBatchList() {
      return (List<GLBatch>) get(PROPERTY_FINANCIALMGMTGLBATCHLIST);
    }

    public void setFinancialMgmtGLBatchList(List<GLBatch> financialMgmtGLBatchList) {
        set(PROPERTY_FINANCIALMGMTGLBATCHLIST, financialMgmtGLBatchList);
    }

    @SuppressWarnings("unchecked")
    public List<GLJournal> getFinancialMgmtGLJournalList() {
      return (List<GLJournal>) get(PROPERTY_FINANCIALMGMTGLJOURNALLIST);
    }

    public void setFinancialMgmtGLJournalList(List<GLJournal> financialMgmtGLJournalList) {
        set(PROPERTY_FINANCIALMGMTGLJOURNALLIST, financialMgmtGLJournalList);
    }

    @SuppressWarnings("unchecked")
    public List<PeriodControl> getFinancialMgmtPeriodControlList() {
      return (List<PeriodControl>) get(PROPERTY_FINANCIALMGMTPERIODCONTROLLIST);
    }

    public void setFinancialMgmtPeriodControlList(List<PeriodControl> financialMgmtPeriodControlList) {
        set(PROPERTY_FINANCIALMGMTPERIODCONTROLLIST, financialMgmtPeriodControlList);
    }

    @SuppressWarnings("unchecked")
    public List<PeriodControlV> getFinancialMgmtPeriodControlVList() {
      return (List<PeriodControlV>) get(PROPERTY_FINANCIALMGMTPERIODCONTROLVLIST);
    }

    public void setFinancialMgmtPeriodControlVList(List<PeriodControlV> financialMgmtPeriodControlVList) {
        set(PROPERTY_FINANCIALMGMTPERIODCONTROLVLIST, financialMgmtPeriodControlVList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceLine> getInvoiceLineList() {
      return (List<InvoiceLine>) get(PROPERTY_INVOICELINELIST);
    }

    public void setInvoiceLineList(List<InvoiceLine> invoiceLineList) {
        set(PROPERTY_INVOICELINELIST, invoiceLineList);
    }

    @SuppressWarnings("unchecked")
    public List<PeriodControlLog> getPeriodControlLogPeriodNoList() {
      return (List<PeriodControlLog>) get(PROPERTY_PERIODCONTROLLOGPERIODNOLIST);
    }

    public void setPeriodControlLogPeriodNoList(List<PeriodControlLog> periodControlLogPeriodNoList) {
        set(PROPERTY_PERIODCONTROLLOGPERIODNOLIST, periodControlLogPeriodNoList);
    }

    @SuppressWarnings("unchecked")
    public List<PeriodControlLog> getPeriodControlLogList() {
      return (List<PeriodControlLog>) get(PROPERTY_PERIODCONTROLLOGLIST);
    }

    public void setPeriodControlLogList(List<PeriodControlLog> periodControlLogList) {
        set(PROPERTY_PERIODCONTROLLOGLIST, periodControlLogList);
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
    public List<ConceptAmount> getSSPRConceptAmountList() {
      return (List<ConceptAmount>) get(PROPERTY_SSPRCONCEPTAMOUNTLIST);
    }

    public void setSSPRConceptAmountList(List<ConceptAmount> sSPRConceptAmountList) {
        set(PROPERTY_SSPRCONCEPTAMOUNTLIST, sSPRConceptAmountList);
    }

    @SuppressWarnings("unchecked")
    public List<Payroll> getSSPRPayrollList() {
      return (List<Payroll>) get(PROPERTY_SSPRPAYROLLLIST);
    }

    public void setSSPRPayrollList(List<Payroll> sSPRPayrollList) {
        set(PROPERTY_SSPRPAYROLLLIST, sSPRPayrollList);
    }

    @SuppressWarnings("unchecked")
    public List<com.sidesoft.hrm.payroll.Period> getSSPRPeriodList() {
      return (List<com.sidesoft.hrm.payroll.Period>) get(PROPERTY_SSPRPERIODLIST);
    }

    public void setSSPRPeriodList(List<com.sidesoft.hrm.payroll.Period> sSPRPeriodList) {
        set(PROPERTY_SSPRPERIODLIST, sSPRPeriodList);
    }

    @SuppressWarnings("unchecked")
    public List<SswhRptcSalesDet> getSswhRptcSalesDetList() {
      return (List<SswhRptcSalesDet>) get(PROPERTY_SSWHRPTCSALESDETLIST);
    }

    public void setSswhRptcSalesDetList(List<SswhRptcSalesDet> sswhRptcSalesDetList) {
        set(PROPERTY_SSWHRPTCSALESDETLIST, sswhRptcSalesDetList);
    }

    @SuppressWarnings("unchecked")
    public List<ValuedStockAggregated> getValuedStockAggregatedList() {
      return (List<ValuedStockAggregated>) get(PROPERTY_VALUEDSTOCKAGGREGATEDLIST);
    }

    public void setValuedStockAggregatedList(List<ValuedStockAggregated> valuedStockAggregatedList) {
        set(PROPERTY_VALUEDSTOCKAGGREGATEDLIST, valuedStockAggregatedList);
    }

    @SuppressWarnings("unchecked")
    public List<scppapprovalpayment> getScppApprovalpaymentList() {
      return (List<scppapprovalpayment>) get(PROPERTY_SCPPAPPROVALPAYMENTLIST);
    }

    public void setScppApprovalpaymentList(List<scppapprovalpayment> scppApprovalpaymentList) {
        set(PROPERTY_SCPPAPPROVALPAYMENTLIST, scppApprovalpaymentList);
    }

    @SuppressWarnings("unchecked")
    public List<SFBBudgetCertificate> getSfbBudgetCertificateEMSsbpCPeriodIDList() {
      return (List<SFBBudgetCertificate>) get(PROPERTY_SFBBUDGETCERTIFICATEEMSSBPCPERIODIDLIST);
    }

    public void setSfbBudgetCertificateEMSsbpCPeriodIDList(List<SFBBudgetCertificate> sfbBudgetCertificateEMSsbpCPeriodIDList) {
        set(PROPERTY_SFBBUDGETCERTIFICATEEMSSBPCPERIODIDLIST, sfbBudgetCertificateEMSsbpCPeriodIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprRveDetail> getSfprRveDetailList() {
      return (List<SfprRveDetail>) get(PROPERTY_SFPRRVEDETAILLIST);
    }

    public void setSfprRveDetailList(List<SfprRveDetail> sfprRveDetailList) {
        set(PROPERTY_SFPRRVEDETAILLIST, sfprRveDetailList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprRveDetail> getSfprRveDetailPeriodProcessList() {
      return (List<SfprRveDetail>) get(PROPERTY_SFPRRVEDETAILPERIODPROCESSLIST);
    }

    public void setSfprRveDetailPeriodProcessList(List<SfprRveDetail> sfprRveDetailPeriodProcessList) {
        set(PROPERTY_SFPRRVEDETAILPERIODPROCESSLIST, sfprRveDetailPeriodProcessList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprSurrogateDetail> getSfprSurrogateDetailList() {
      return (List<SfprSurrogateDetail>) get(PROPERTY_SFPRSURROGATEDETAILLIST);
    }

    public void setSfprSurrogateDetailList(List<SfprSurrogateDetail> sfprSurrogateDetailList) {
        set(PROPERTY_SFPRSURROGATEDETAILLIST, sfprSurrogateDetailList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprSurrogateDetail> getSfprSurrogateDetailPeriodProcessedList() {
      return (List<SfprSurrogateDetail>) get(PROPERTY_SFPRSURROGATEDETAILPERIODPROCESSEDLIST);
    }

    public void setSfprSurrogateDetailPeriodProcessedList(List<SfprSurrogateDetail> sfprSurrogateDetailPeriodProcessedList) {
        set(PROPERTY_SFPRSURROGATEDETAILPERIODPROCESSEDLIST, sfprSurrogateDetailPeriodProcessedList);
    }

    @SuppressWarnings("unchecked")
    public List<sspdpctdist> getSspdPctdistList() {
      return (List<sspdpctdist>) get(PROPERTY_SSPDPCTDISTLIST);
    }

    public void setSspdPctdistList(List<sspdpctdist> sspdPctdistList) {
        set(PROPERTY_SSPDPCTDISTLIST, sspdPctdistList);
    }

    @SuppressWarnings("unchecked")
    public List<SsprConfigurationUtility> getSsprConfigurationutilityList() {
      return (List<SsprConfigurationUtility>) get(PROPERTY_SSPRCONFIGURATIONUTILITYLIST);
    }

    public void setSsprConfigurationutilityList(List<SsprConfigurationUtility> ssprConfigurationutilityList) {
        set(PROPERTY_SSPRCONFIGURATIONUTILITYLIST, ssprConfigurationutilityList);
    }

    @SuppressWarnings("unchecked")
    public List<CumulativeConcept> getSsprCumulativeconceptList() {
      return (List<CumulativeConcept>) get(PROPERTY_SSPRCUMULATIVECONCEPTLIST);
    }

    public void setSsprCumulativeconceptList(List<CumulativeConcept> ssprCumulativeconceptList) {
        set(PROPERTY_SSPRCUMULATIVECONCEPTLIST, ssprCumulativeconceptList);
    }

    @SuppressWarnings("unchecked")
    public List<ssprline_loans> getSsprLineLoansList() {
      return (List<ssprline_loans>) get(PROPERTY_SSPRLINELOANSLIST);
    }

    public void setSsprLineLoansList(List<ssprline_loans> ssprLineLoansList) {
        set(PROPERTY_SSPRLINELOANSLIST, ssprLineLoansList);
    }

    @SuppressWarnings("unchecked")
    public List<ssprpayrollaut> getSsprPayrollAutList() {
      return (List<ssprpayrollaut>) get(PROPERTY_SSPRPAYROLLAUTLIST);
    }

    public void setSsprPayrollAutList(List<ssprpayrollaut> ssprPayrollAutList) {
        set(PROPERTY_SSPRPAYROLLAUTLIST, ssprPayrollAutList);
    }


    @Override
    public Object get(String propName) {
      if (COMPUTED_COLUMN_STATUS.equals(propName)) {
        if (get_computedColumns() == null) {
          return null;
        }
        return get_computedColumns().getStatus();
      }
    
      return super.get(propName);
    }
}
