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
package org.openbravo.model.financialmgmt.gl;

import com.sidesoft.hrm.payroll.ssprpayrollpayment;

import ec.com.sidesoft.localization.ecuador.withholdingssales.SSWSWithholdingSale;
import ec.com.sidesoft.secondary.accounting.SSACCTJournalLine;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openbravo.advpaymentmngt.APRM_FinaccTransactionV;
import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.invoice.InvoiceLine;
import org.openbravo.model.financialmgmt.cashmgmt.BankStatementLine;
import org.openbravo.model.financialmgmt.cashmgmt.CashJournalLine;
import org.openbravo.model.financialmgmt.payment.DebtPayment;
import org.openbravo.model.financialmgmt.payment.DebtPaymentBalReplace;
import org.openbravo.model.financialmgmt.payment.DebtPaymentBalancing;
import org.openbravo.model.financialmgmt.payment.DebtPaymentGenerateV;
import org.openbravo.model.financialmgmt.payment.FIN_BankStatementLine;
import org.openbravo.model.financialmgmt.payment.FIN_FinaccTransaction;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentDetail;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentPropDetail;
import org.openbravo.model.financialmgmt.payment.FIN_ReconciliationLine_v;
import org.openbravo.model.financialmgmt.tax.TaxCategory;
import org.openbravo.model.financialmgmt.tax.TaxRate;
import org.openbravo.model.financialmgmt.tax.TaxRegisterType;
import org.openbravo.model.financialmgmt.tax.Withholding;
import org.openbravo.model.materialmgmt.cost.LandedCostType;
/**
 * Entity class for entity FinancialMgmtGLItem (stored in table C_Glitem).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class GLItem extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_Glitem";
    public static final String ENTITY_NAME = "FinancialMgmtGLItem";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_ENABLEINCASH = "enableInCash";
    public static final String PROPERTY_ENABLEINFINANCIALINVOICES = "enableInFinancialInvoices";
    public static final String PROPERTY_TAXCATEGORY = "taxCategory";
    public static final String PROPERTY_TAX = "tax";
    public static final String PROPERTY_WITHHOLDING = "withholding";
    public static final String PROPERTY_APRMFINACCTRANSACTIONVLIST = "aPRMFinaccTransactionVList";
    public static final String PROPERTY_FINBANKSTATEMENTLINELIST = "fINBankStatementLineList";
    public static final String PROPERTY_FINFINACCTRANSACTIONLIST = "fINFinaccTransactionList";
    public static final String PROPERTY_FINPAYMENTDETAILLIST = "fINPaymentDetailList";
    public static final String PROPERTY_FINPAYMENTPROPDETAILLIST = "fINPaymentPropDetailList";
    public static final String PROPERTY_FINRECONCILIATIONLINEVLIST = "fINReconciliationLineVList";
    public static final String PROPERTY_FINANCIALMGMTBANKSTATEMENTLINELIST = "financialMgmtBankStatementLineList";
    public static final String PROPERTY_FINANCIALMGMTDEBTPAYMENTLIST = "financialMgmtDebtPaymentList";
    public static final String PROPERTY_FINANCIALMGMTDEBTPAYMENTBALREPLACELIST = "financialMgmtDebtPaymentBalReplaceList";
    public static final String PROPERTY_FINANCIALMGMTDEBTPAYMENTBALANCINGLIST = "financialMgmtDebtPaymentBalancingList";
    public static final String PROPERTY_FINANCIALMGMTDEBTPAYMENTGENERATEVLIST = "financialMgmtDebtPaymentGenerateVList";
    public static final String PROPERTY_FINANCIALMGMTGLITEMACCOUNTSLIST = "financialMgmtGLItemAccountsList";
    public static final String PROPERTY_FINANCIALMGMTGLJOURNALLINELIST = "financialMgmtGLJournalLineList";
    public static final String PROPERTY_FINANCIALMGMTGLJOURNALLINEGLITEMSLIST = "financialMgmtGLJournalLineGLItemsList";
    public static final String PROPERTY_FINANCIALMGMTJOURNALLINELIST = "financialMgmtJournalLineList";
    public static final String PROPERTY_FINANCIALMGMTTAXREGISTERTYPELIST = "financialMgmtTaxRegisterTypeList";
    public static final String PROPERTY_INVOICELINEACCOUNTLIST = "invoiceLineAccountList";
    public static final String PROPERTY_LANDEDCOSTTYPEACCOUNTLIST = "landedCostTypeAccountList";
    public static final String PROPERTY_ORGANIZATIONEMAPRMGLITEMIDLIST = "organizationEMAPRMGlitemIDList";
    public static final String PROPERTY_SSACCTJOURNALLINELIST = "sSACCTJournalLineList";
    public static final String PROPERTY_SSACCTJOURNALLINEGLITEMSLIST = "sSACCTJournalLineGLItemsList";
    public static final String PROPERTY_SSWSWITHHOLDINGSALELIST = "sSWSWithholdingSaleList";
    public static final String PROPERTY_SSPRPAYROLLPAYMENTLIST = "ssprPayrollpaymentList";

    public GLItem() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_ENABLEINCASH, false);
        setDefaultValue(PROPERTY_ENABLEINFINANCIALINVOICES, false);
        setDefaultValue(PROPERTY_APRMFINACCTRANSACTIONVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINBANKSTATEMENTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINFINACCTRANSACTIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTDETAILLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTPROPDETAILLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINRECONCILIATIONLINEVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTBANKSTATEMENTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTDEBTPAYMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTDEBTPAYMENTBALREPLACELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTDEBTPAYMENTBALANCINGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTDEBTPAYMENTGENERATEVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTGLITEMACCOUNTSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTGLJOURNALLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTGLJOURNALLINEGLITEMSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTJOURNALLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTTAXREGISTERTYPELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELINEACCOUNTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_LANDEDCOSTTYPEACCOUNTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORGANIZATIONEMAPRMGLITEMIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSACCTJOURNALLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSACCTJOURNALLINEGLITEMSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWSWITHHOLDINGSALELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRPAYROLLPAYMENTLIST, new ArrayList<Object>());
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

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Boolean isEnableInCash() {
        return (Boolean) get(PROPERTY_ENABLEINCASH);
    }

    public void setEnableInCash(Boolean enableInCash) {
        set(PROPERTY_ENABLEINCASH, enableInCash);
    }

    public Boolean isEnableInFinancialInvoices() {
        return (Boolean) get(PROPERTY_ENABLEINFINANCIALINVOICES);
    }

    public void setEnableInFinancialInvoices(Boolean enableInFinancialInvoices) {
        set(PROPERTY_ENABLEINFINANCIALINVOICES, enableInFinancialInvoices);
    }

    public TaxCategory getTaxCategory() {
        return (TaxCategory) get(PROPERTY_TAXCATEGORY);
    }

    public void setTaxCategory(TaxCategory taxCategory) {
        set(PROPERTY_TAXCATEGORY, taxCategory);
    }

    public TaxRate getTax() {
        return (TaxRate) get(PROPERTY_TAX);
    }

    public void setTax(TaxRate tax) {
        set(PROPERTY_TAX, tax);
    }

    public Withholding getWithholding() {
        return (Withholding) get(PROPERTY_WITHHOLDING);
    }

    public void setWithholding(Withholding withholding) {
        set(PROPERTY_WITHHOLDING, withholding);
    }

    @SuppressWarnings("unchecked")
    public List<APRM_FinaccTransactionV> getAPRMFinaccTransactionVList() {
      return (List<APRM_FinaccTransactionV>) get(PROPERTY_APRMFINACCTRANSACTIONVLIST);
    }

    public void setAPRMFinaccTransactionVList(List<APRM_FinaccTransactionV> aPRMFinaccTransactionVList) {
        set(PROPERTY_APRMFINACCTRANSACTIONVLIST, aPRMFinaccTransactionVList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_BankStatementLine> getFINBankStatementLineList() {
      return (List<FIN_BankStatementLine>) get(PROPERTY_FINBANKSTATEMENTLINELIST);
    }

    public void setFINBankStatementLineList(List<FIN_BankStatementLine> fINBankStatementLineList) {
        set(PROPERTY_FINBANKSTATEMENTLINELIST, fINBankStatementLineList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_FinaccTransaction> getFINFinaccTransactionList() {
      return (List<FIN_FinaccTransaction>) get(PROPERTY_FINFINACCTRANSACTIONLIST);
    }

    public void setFINFinaccTransactionList(List<FIN_FinaccTransaction> fINFinaccTransactionList) {
        set(PROPERTY_FINFINACCTRANSACTIONLIST, fINFinaccTransactionList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_PaymentDetail> getFINPaymentDetailList() {
      return (List<FIN_PaymentDetail>) get(PROPERTY_FINPAYMENTDETAILLIST);
    }

    public void setFINPaymentDetailList(List<FIN_PaymentDetail> fINPaymentDetailList) {
        set(PROPERTY_FINPAYMENTDETAILLIST, fINPaymentDetailList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_PaymentPropDetail> getFINPaymentPropDetailList() {
      return (List<FIN_PaymentPropDetail>) get(PROPERTY_FINPAYMENTPROPDETAILLIST);
    }

    public void setFINPaymentPropDetailList(List<FIN_PaymentPropDetail> fINPaymentPropDetailList) {
        set(PROPERTY_FINPAYMENTPROPDETAILLIST, fINPaymentPropDetailList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_ReconciliationLine_v> getFINReconciliationLineVList() {
      return (List<FIN_ReconciliationLine_v>) get(PROPERTY_FINRECONCILIATIONLINEVLIST);
    }

    public void setFINReconciliationLineVList(List<FIN_ReconciliationLine_v> fINReconciliationLineVList) {
        set(PROPERTY_FINRECONCILIATIONLINEVLIST, fINReconciliationLineVList);
    }

    @SuppressWarnings("unchecked")
    public List<BankStatementLine> getFinancialMgmtBankStatementLineList() {
      return (List<BankStatementLine>) get(PROPERTY_FINANCIALMGMTBANKSTATEMENTLINELIST);
    }

    public void setFinancialMgmtBankStatementLineList(List<BankStatementLine> financialMgmtBankStatementLineList) {
        set(PROPERTY_FINANCIALMGMTBANKSTATEMENTLINELIST, financialMgmtBankStatementLineList);
    }

    @SuppressWarnings("unchecked")
    public List<DebtPayment> getFinancialMgmtDebtPaymentList() {
      return (List<DebtPayment>) get(PROPERTY_FINANCIALMGMTDEBTPAYMENTLIST);
    }

    public void setFinancialMgmtDebtPaymentList(List<DebtPayment> financialMgmtDebtPaymentList) {
        set(PROPERTY_FINANCIALMGMTDEBTPAYMENTLIST, financialMgmtDebtPaymentList);
    }

    @SuppressWarnings("unchecked")
    public List<DebtPaymentBalReplace> getFinancialMgmtDebtPaymentBalReplaceList() {
      return (List<DebtPaymentBalReplace>) get(PROPERTY_FINANCIALMGMTDEBTPAYMENTBALREPLACELIST);
    }

    public void setFinancialMgmtDebtPaymentBalReplaceList(List<DebtPaymentBalReplace> financialMgmtDebtPaymentBalReplaceList) {
        set(PROPERTY_FINANCIALMGMTDEBTPAYMENTBALREPLACELIST, financialMgmtDebtPaymentBalReplaceList);
    }

    @SuppressWarnings("unchecked")
    public List<DebtPaymentBalancing> getFinancialMgmtDebtPaymentBalancingList() {
      return (List<DebtPaymentBalancing>) get(PROPERTY_FINANCIALMGMTDEBTPAYMENTBALANCINGLIST);
    }

    public void setFinancialMgmtDebtPaymentBalancingList(List<DebtPaymentBalancing> financialMgmtDebtPaymentBalancingList) {
        set(PROPERTY_FINANCIALMGMTDEBTPAYMENTBALANCINGLIST, financialMgmtDebtPaymentBalancingList);
    }

    @SuppressWarnings("unchecked")
    public List<DebtPaymentGenerateV> getFinancialMgmtDebtPaymentGenerateVList() {
      return (List<DebtPaymentGenerateV>) get(PROPERTY_FINANCIALMGMTDEBTPAYMENTGENERATEVLIST);
    }

    public void setFinancialMgmtDebtPaymentGenerateVList(List<DebtPaymentGenerateV> financialMgmtDebtPaymentGenerateVList) {
        set(PROPERTY_FINANCIALMGMTDEBTPAYMENTGENERATEVLIST, financialMgmtDebtPaymentGenerateVList);
    }

    @SuppressWarnings("unchecked")
    public List<GLItemAccounts> getFinancialMgmtGLItemAccountsList() {
      return (List<GLItemAccounts>) get(PROPERTY_FINANCIALMGMTGLITEMACCOUNTSLIST);
    }

    public void setFinancialMgmtGLItemAccountsList(List<GLItemAccounts> financialMgmtGLItemAccountsList) {
        set(PROPERTY_FINANCIALMGMTGLITEMACCOUNTSLIST, financialMgmtGLItemAccountsList);
    }

    @SuppressWarnings("unchecked")
    public List<GLJournalLine> getFinancialMgmtGLJournalLineList() {
      return (List<GLJournalLine>) get(PROPERTY_FINANCIALMGMTGLJOURNALLINELIST);
    }

    public void setFinancialMgmtGLJournalLineList(List<GLJournalLine> financialMgmtGLJournalLineList) {
        set(PROPERTY_FINANCIALMGMTGLJOURNALLINELIST, financialMgmtGLJournalLineList);
    }

    @SuppressWarnings("unchecked")
    public List<GLJournalLine> getFinancialMgmtGLJournalLineGLItemsList() {
      return (List<GLJournalLine>) get(PROPERTY_FINANCIALMGMTGLJOURNALLINEGLITEMSLIST);
    }

    public void setFinancialMgmtGLJournalLineGLItemsList(List<GLJournalLine> financialMgmtGLJournalLineGLItemsList) {
        set(PROPERTY_FINANCIALMGMTGLJOURNALLINEGLITEMSLIST, financialMgmtGLJournalLineGLItemsList);
    }

    @SuppressWarnings("unchecked")
    public List<CashJournalLine> getFinancialMgmtJournalLineList() {
      return (List<CashJournalLine>) get(PROPERTY_FINANCIALMGMTJOURNALLINELIST);
    }

    public void setFinancialMgmtJournalLineList(List<CashJournalLine> financialMgmtJournalLineList) {
        set(PROPERTY_FINANCIALMGMTJOURNALLINELIST, financialMgmtJournalLineList);
    }

    @SuppressWarnings("unchecked")
    public List<TaxRegisterType> getFinancialMgmtTaxRegisterTypeList() {
      return (List<TaxRegisterType>) get(PROPERTY_FINANCIALMGMTTAXREGISTERTYPELIST);
    }

    public void setFinancialMgmtTaxRegisterTypeList(List<TaxRegisterType> financialMgmtTaxRegisterTypeList) {
        set(PROPERTY_FINANCIALMGMTTAXREGISTERTYPELIST, financialMgmtTaxRegisterTypeList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceLine> getInvoiceLineAccountList() {
      return (List<InvoiceLine>) get(PROPERTY_INVOICELINEACCOUNTLIST);
    }

    public void setInvoiceLineAccountList(List<InvoiceLine> invoiceLineAccountList) {
        set(PROPERTY_INVOICELINEACCOUNTLIST, invoiceLineAccountList);
    }

    @SuppressWarnings("unchecked")
    public List<LandedCostType> getLandedCostTypeAccountList() {
      return (List<LandedCostType>) get(PROPERTY_LANDEDCOSTTYPEACCOUNTLIST);
    }

    public void setLandedCostTypeAccountList(List<LandedCostType> landedCostTypeAccountList) {
        set(PROPERTY_LANDEDCOSTTYPEACCOUNTLIST, landedCostTypeAccountList);
    }

    @SuppressWarnings("unchecked")
    public List<Organization> getOrganizationEMAPRMGlitemIDList() {
      return (List<Organization>) get(PROPERTY_ORGANIZATIONEMAPRMGLITEMIDLIST);
    }

    public void setOrganizationEMAPRMGlitemIDList(List<Organization> organizationEMAPRMGlitemIDList) {
        set(PROPERTY_ORGANIZATIONEMAPRMGLITEMIDLIST, organizationEMAPRMGlitemIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SSACCTJournalLine> getSSACCTJournalLineList() {
      return (List<SSACCTJournalLine>) get(PROPERTY_SSACCTJOURNALLINELIST);
    }

    public void setSSACCTJournalLineList(List<SSACCTJournalLine> sSACCTJournalLineList) {
        set(PROPERTY_SSACCTJOURNALLINELIST, sSACCTJournalLineList);
    }

    @SuppressWarnings("unchecked")
    public List<SSACCTJournalLine> getSSACCTJournalLineGLItemsList() {
      return (List<SSACCTJournalLine>) get(PROPERTY_SSACCTJOURNALLINEGLITEMSLIST);
    }

    public void setSSACCTJournalLineGLItemsList(List<SSACCTJournalLine> sSACCTJournalLineGLItemsList) {
        set(PROPERTY_SSACCTJOURNALLINEGLITEMSLIST, sSACCTJournalLineGLItemsList);
    }

    @SuppressWarnings("unchecked")
    public List<SSWSWithholdingSale> getSSWSWithholdingSaleList() {
      return (List<SSWSWithholdingSale>) get(PROPERTY_SSWSWITHHOLDINGSALELIST);
    }

    public void setSSWSWithholdingSaleList(List<SSWSWithholdingSale> sSWSWithholdingSaleList) {
        set(PROPERTY_SSWSWITHHOLDINGSALELIST, sSWSWithholdingSaleList);
    }

    @SuppressWarnings("unchecked")
    public List<ssprpayrollpayment> getSsprPayrollpaymentList() {
      return (List<ssprpayrollpayment>) get(PROPERTY_SSPRPAYROLLPAYMENTLIST);
    }

    public void setSsprPayrollpaymentList(List<ssprpayrollpayment> ssprPayrollpaymentList) {
        set(PROPERTY_SSPRPAYROLLPAYMENTLIST, ssprPayrollpaymentList);
    }

}
