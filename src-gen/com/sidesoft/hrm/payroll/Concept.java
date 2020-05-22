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
package com.sidesoft.hrm.payroll;

import com.sidesoft.flopec.budget.data.SFBBudgetCertLine;
import com.sidesoft.hrm.payroll.advanced.SfprEmployeeContribution;
import com.sidesoft.hrm.payroll.advanced.SfprEmployeeRve;
import com.sidesoft.hrm.payroll.advanced.SfprJobActionline;
import com.sidesoft.hrm.payroll.advanced.SfprRveDetail;
import com.sidesoft.hrm.payroll.advanced.SfprSurrogateDetail;

import ec.com.sidesoft.budget.payroll.SSBPNoBudgetCertLine;

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
import org.openbravo.model.common.enterprise.Organization;
/**
 * Entity class for entity SSPR_Concept (stored in table SSPR_Concept).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Concept extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "SSPR_Concept";
    public static final String ENTITY_NAME = "SSPR_Concept";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_VALUE = "value";
    public static final String PROPERTY_AFFECTATIONTYPE = "affectationtype";
    public static final String PROPERTY_CONCEPTSUBTYPE = "conceptsubtype";
    public static final String PROPERTY_SSPRCONCEPTFORMULA = "ssprConceptFormula";
    public static final String PROPERTY_FORMULA = "formula";
    public static final String PROPERTY_CONCEPTTYPE = "concepttype";
    public static final String PROPERTY_AMOUNT = "amount";
    public static final String PROPERTY_OPERATION = "operation";
    public static final String PROPERTY_CREATECONCEPTAMOUNTS = "createConceptAmounts";
    public static final String PROPERTY_ISINCOMETAX = "isIncomeTax";
    public static final String PROPERTY_INCOMECALCULATED = "incomeCalculated";
    public static final String PROPERTY_ISCUMULATIVE = "iscumulative";
    public static final String PROPERTY_ISPROJECTED = "isProjected";
    public static final String PROPERTY_ISAFFECTIONMONTHLY = "isaffectionmonthly";
    public static final String PROPERTY_ISIESS = "isIess";
    public static final String PROPERTY_ISRESERVEFUNDS = "isreservefunds";
    public static final String PROPERTY_ISFORTNIGHT = "isFortnight";
    public static final String PROPERTY_ISSALARY = "isSalary";
    public static final String PROPERTY_DELETEFORMULA = "deleteformula";
    public static final String PROPERTY_ISLOAN = "isloan";
    public static final String PROPERTY_ISOVERTIME = "isovertime";
    public static final String PROPERTY_SFPRISOTHER = "sfprIsother";
    public static final String PROPERTY_ORDERPRINT = "orderprint";
    public static final String PROPERTY_CONCEPTTYPEPAYROLL = "concepttypepayroll";
    public static final String PROPERTY_SFPRISWORKHISTORY = "sfprIsworkhistory";
    public static final String PROPERTY_CONCEPTFORMULATES = "conceptformulates";
    public static final String PROPERTY_SFPRISCONTRIBUTIONIESS = "sfprIscontributioniess";
    public static final String PROPERTY_VARIATIONSALARY = "variationsalary";
    public static final String PROPERTY_PRINTOBSERVREPORT = "printObservReport";
    public static final String PROPERTY_CODEFORMULARY107 = "codeFormulary107";
    public static final String PROPERTY_GROUPCONCEPT = "groupConcept";
    public static final String PROPERTY_PRINT = "print";
    public static final String PROPERTY_BUSINESSPARTNEREMSSPRCONCEPTIDLIST = "businessPartnerEmSsprConceptIdList";
    public static final String PROPERTY_BUSINESSPARTNEREMSSPRCONCEPTTHIRTEENTHIDLIST = "businessPartnerEMSsprConceptThirteenthIDList";
    public static final String PROPERTY_BUSINESSPARTNEREMSSPRCONCEPTFOURTEENTHIDLIST = "businessPartnerEMSsprConceptFourteenthIDList";
    public static final String PROPERTY_BUSINESSPARTNEREMSSPRCONCEPTVACIDLIST = "businessPartnerEMSsprConceptVacIDList";
    public static final String PROPERTY_SSPRCONCEPTSSPRCONCEPTFORMULAIDLIST = "sSPRConceptSsprConceptFormulaIDList";
    public static final String PROPERTY_SSPRCONCEPTCONCEPTFORMULATESLIST = "sSPRConceptConceptformulatesList";
    public static final String PROPERTY_SSPRCONCEPTAMOUNTLIST = "sSPRConceptAmountList";
    public static final String PROPERTY_SSPRCONTRACTLIST = "sSPRContractList";
    public static final String PROPERTY_SSPRLABORREGIMEEMSFPRCONCEPTIDLIST = "sSPRLaborRegimeEMSfprConceptIDList";
    public static final String PROPERTY_SSPRPAYROLLTICKETCONCEPTLIST = "sSPRPayrollTicketConceptList";
    public static final String PROPERTY_SSPRPERIODCONCEPTLIST = "sSPRPeriodConceptList";
    public static final String PROPERTY_SSPRPROLLTEMLINESLIST = "sSPRProlltemLinesList";
    public static final String PROPERTY_SFBBUDGETCERTLINEEMSSBPSSPRCONCEPTIDLIST = "sfbBudgetCertLineEMSsbpSsprConceptIDList";
    public static final String PROPERTY_SFPREMPLOYEECONTRIBUTIONPERSONALCONCEPTLIST = "sfprEmployeeContributionPersonalConceptList";
    public static final String PROPERTY_SFPREMPLOYEECONTRIBUTIONCONCEPTBOSSESLIST = "sfprEmployeeContributionConceptBossesList";
    public static final String PROPERTY_SFPREMPLOYEECONTRIBUTIONTOTALINCOMECONCEPTLIST = "sfprEmployeeContributionTotalIncomeConceptList";
    public static final String PROPERTY_SFPREMPLOYEECONTRIBUTIONINCOMELIST = "sfprEmployeeContributionIncomeList";
    public static final String PROPERTY_SFPREMPLOYEERVEEMSSPRCONCEPTIDLIST = "sfprEmployeeRveEMSsprConceptIDList";
    public static final String PROPERTY_SFPRJOBACTIONLINELIST = "sfprJobActionlineList";
    public static final String PROPERTY_SFPRRVEDETAILCONCEPTLIST = "sfprRveDetailConceptList";
    public static final String PROPERTY_SFPRRVEDETAILCONCEPTPAYMENTRVEIDLIST = "sfprRveDetailConceptPaymentRveIDList";
    public static final String PROPERTY_SFPRSURROGATEDETAILCONCEPTSURROGATELIST = "sfprSurrogateDetailConceptSurrogateList";
    public static final String PROPERTY_SSBPNOBUDGETCERTLINELIST = "ssbpNoBudgetCertLineList";
    public static final String PROPERTY_SSPRBENEFITDISMISSALLIST = "ssprBenefitDismissalList";
    public static final String PROPERTY_SSPRCONCEPTACCTLIST = "ssprConceptAcctList";
    public static final String PROPERTY_SSPRCONFIGURATIONUTILITYLIST = "ssprConfigurationutilityList";
    public static final String PROPERTY_SSPRCUMULATIVECONCEPTLIST = "ssprCumulativeconceptList";
    public static final String PROPERTY_SSPREMPLOYEESETTLEMENTLINELIST = "ssprEmployeesettlementlineList";
    public static final String PROPERTY_SSPRLEAVECATEGORYLIST = "ssprLeaveCategoryList";
    public static final String PROPERTY_SSPRLEAVEGROUPLIST = "ssprLeaveGroupList";
    public static final String PROPERTY_SSPRLOANSLIST = "ssprLoansList";
    public static final String PROPERTY_SSPRPROCESSPAYROLLCONCEPTINLIST = "ssprProcessPayrollConceptInList";
    public static final String PROPERTY_SSPRPROCESSPAYROLLCONCEPTOUTLIST = "ssprProcessPayrollConceptOutList";
    public static final String PROPERTY_SSPRSETTLEMENTDATALIST = "ssprSettlementdataList";
    public static final String PROPERTY_SSPRSETTLEMENTLINELIST = "ssprSettlementlineList";
    public static final String PROPERTY_SSPRVACATIONSLIST = "ssprVacationsList";

    public Concept() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_CREATECONCEPTAMOUNTS, false);
        setDefaultValue(PROPERTY_ISINCOMETAX, false);
        setDefaultValue(PROPERTY_INCOMECALCULATED, false);
        setDefaultValue(PROPERTY_ISCUMULATIVE, false);
        setDefaultValue(PROPERTY_ISPROJECTED, false);
        setDefaultValue(PROPERTY_ISAFFECTIONMONTHLY, false);
        setDefaultValue(PROPERTY_ISIESS, false);
        setDefaultValue(PROPERTY_ISRESERVEFUNDS, false);
        setDefaultValue(PROPERTY_ISFORTNIGHT, false);
        setDefaultValue(PROPERTY_ISSALARY, false);
        setDefaultValue(PROPERTY_DELETEFORMULA, false);
        setDefaultValue(PROPERTY_ISLOAN, false);
        setDefaultValue(PROPERTY_ISOVERTIME, false);
        setDefaultValue(PROPERTY_SFPRISOTHER, false);
        setDefaultValue(PROPERTY_SFPRISWORKHISTORY, false);
        setDefaultValue(PROPERTY_SFPRISCONTRIBUTIONIESS, false);
        setDefaultValue(PROPERTY_VARIATIONSALARY, false);
        setDefaultValue(PROPERTY_PRINTOBSERVREPORT, false);
        setDefaultValue(PROPERTY_PRINT, true);
        setDefaultValue(PROPERTY_BUSINESSPARTNEREMSSPRCONCEPTIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_BUSINESSPARTNEREMSSPRCONCEPTTHIRTEENTHIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_BUSINESSPARTNEREMSSPRCONCEPTFOURTEENTHIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_BUSINESSPARTNEREMSSPRCONCEPTVACIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRCONCEPTSSPRCONCEPTFORMULAIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRCONCEPTCONCEPTFORMULATESLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRCONCEPTAMOUNTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRCONTRACTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRLABORREGIMEEMSFPRCONCEPTIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRPAYROLLTICKETCONCEPTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRPERIODCONCEPTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRPROLLTEMLINESLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETCERTLINEEMSSBPSSPRCONCEPTIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPREMPLOYEECONTRIBUTIONPERSONALCONCEPTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPREMPLOYEECONTRIBUTIONCONCEPTBOSSESLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPREMPLOYEECONTRIBUTIONTOTALINCOMECONCEPTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPREMPLOYEECONTRIBUTIONINCOMELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPREMPLOYEERVEEMSSPRCONCEPTIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPRJOBACTIONLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPRRVEDETAILCONCEPTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPRRVEDETAILCONCEPTPAYMENTRVEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPRSURROGATEDETAILCONCEPTSURROGATELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSBPNOBUDGETCERTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRBENEFITDISMISSALLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRCONCEPTACCTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRCONFIGURATIONUTILITYLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRCUMULATIVECONCEPTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPREMPLOYEESETTLEMENTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRLEAVECATEGORYLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRLEAVEGROUPLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRLOANSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRPROCESSPAYROLLCONCEPTINLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRPROCESSPAYROLLCONCEPTOUTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRSETTLEMENTDATALIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRSETTLEMENTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRVACATIONSLIST, new ArrayList<Object>());
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

    public String getValue() {
        return (String) get(PROPERTY_VALUE);
    }

    public void setValue(String value) {
        set(PROPERTY_VALUE, value);
    }

    public String getAffectationtype() {
        return (String) get(PROPERTY_AFFECTATIONTYPE);
    }

    public void setAffectationtype(String affectationtype) {
        set(PROPERTY_AFFECTATIONTYPE, affectationtype);
    }

    public String getConceptsubtype() {
        return (String) get(PROPERTY_CONCEPTSUBTYPE);
    }

    public void setConceptsubtype(String conceptsubtype) {
        set(PROPERTY_CONCEPTSUBTYPE, conceptsubtype);
    }

    public Concept getSsprConceptFormula() {
        return (Concept) get(PROPERTY_SSPRCONCEPTFORMULA);
    }

    public void setSsprConceptFormula(Concept ssprConceptFormula) {
        set(PROPERTY_SSPRCONCEPTFORMULA, ssprConceptFormula);
    }

    public String getFormula() {
        return (String) get(PROPERTY_FORMULA);
    }

    public void setFormula(String formula) {
        set(PROPERTY_FORMULA, formula);
    }

    public String getConcepttype() {
        return (String) get(PROPERTY_CONCEPTTYPE);
    }

    public void setConcepttype(String concepttype) {
        set(PROPERTY_CONCEPTTYPE, concepttype);
    }

    public BigDecimal getAmount() {
        return (BigDecimal) get(PROPERTY_AMOUNT);
    }

    public void setAmount(BigDecimal amount) {
        set(PROPERTY_AMOUNT, amount);
    }

    public String getOperation() {
        return (String) get(PROPERTY_OPERATION);
    }

    public void setOperation(String operation) {
        set(PROPERTY_OPERATION, operation);
    }

    public Boolean isCreateConceptAmounts() {
        return (Boolean) get(PROPERTY_CREATECONCEPTAMOUNTS);
    }

    public void setCreateConceptAmounts(Boolean createConceptAmounts) {
        set(PROPERTY_CREATECONCEPTAMOUNTS, createConceptAmounts);
    }

    public Boolean isIncomeTax() {
        return (Boolean) get(PROPERTY_ISINCOMETAX);
    }

    public void setIncomeTax(Boolean isIncomeTax) {
        set(PROPERTY_ISINCOMETAX, isIncomeTax);
    }

    public Boolean isIncomeCalculated() {
        return (Boolean) get(PROPERTY_INCOMECALCULATED);
    }

    public void setIncomeCalculated(Boolean incomeCalculated) {
        set(PROPERTY_INCOMECALCULATED, incomeCalculated);
    }

    public Boolean isCumulative() {
        return (Boolean) get(PROPERTY_ISCUMULATIVE);
    }

    public void setCumulative(Boolean iscumulative) {
        set(PROPERTY_ISCUMULATIVE, iscumulative);
    }

    public Boolean isProjected() {
        return (Boolean) get(PROPERTY_ISPROJECTED);
    }

    public void setProjected(Boolean isProjected) {
        set(PROPERTY_ISPROJECTED, isProjected);
    }

    public Boolean isAffectionmonthly() {
        return (Boolean) get(PROPERTY_ISAFFECTIONMONTHLY);
    }

    public void setAffectionmonthly(Boolean isaffectionmonthly) {
        set(PROPERTY_ISAFFECTIONMONTHLY, isaffectionmonthly);
    }

    public Boolean isIess() {
        return (Boolean) get(PROPERTY_ISIESS);
    }

    public void setIess(Boolean isIess) {
        set(PROPERTY_ISIESS, isIess);
    }

    public Boolean isReservefunds() {
        return (Boolean) get(PROPERTY_ISRESERVEFUNDS);
    }

    public void setReservefunds(Boolean isreservefunds) {
        set(PROPERTY_ISRESERVEFUNDS, isreservefunds);
    }

    public Boolean isFortnight() {
        return (Boolean) get(PROPERTY_ISFORTNIGHT);
    }

    public void setFortnight(Boolean isFortnight) {
        set(PROPERTY_ISFORTNIGHT, isFortnight);
    }

    public Boolean isSalary() {
        return (Boolean) get(PROPERTY_ISSALARY);
    }

    public void setSalary(Boolean isSalary) {
        set(PROPERTY_ISSALARY, isSalary);
    }

    public Boolean isDeleteformula() {
        return (Boolean) get(PROPERTY_DELETEFORMULA);
    }

    public void setDeleteformula(Boolean deleteformula) {
        set(PROPERTY_DELETEFORMULA, deleteformula);
    }

    public Boolean isLoan() {
        return (Boolean) get(PROPERTY_ISLOAN);
    }

    public void setLoan(Boolean isloan) {
        set(PROPERTY_ISLOAN, isloan);
    }

    public Boolean isOvertime() {
        return (Boolean) get(PROPERTY_ISOVERTIME);
    }

    public void setOvertime(Boolean isovertime) {
        set(PROPERTY_ISOVERTIME, isovertime);
    }

    public Boolean isSfprIsother() {
        return (Boolean) get(PROPERTY_SFPRISOTHER);
    }

    public void setSfprIsother(Boolean sfprIsother) {
        set(PROPERTY_SFPRISOTHER, sfprIsother);
    }

    public Long getOrderprint() {
        return (Long) get(PROPERTY_ORDERPRINT);
    }

    public void setOrderprint(Long orderprint) {
        set(PROPERTY_ORDERPRINT, orderprint);
    }

    public String getConcepttypepayroll() {
        return (String) get(PROPERTY_CONCEPTTYPEPAYROLL);
    }

    public void setConcepttypepayroll(String concepttypepayroll) {
        set(PROPERTY_CONCEPTTYPEPAYROLL, concepttypepayroll);
    }

    public Boolean isSfprIsworkhistory() {
        return (Boolean) get(PROPERTY_SFPRISWORKHISTORY);
    }

    public void setSfprIsworkhistory(Boolean sfprIsworkhistory) {
        set(PROPERTY_SFPRISWORKHISTORY, sfprIsworkhistory);
    }

    public Concept getConceptformulates() {
        return (Concept) get(PROPERTY_CONCEPTFORMULATES);
    }

    public void setConceptformulates(Concept conceptformulates) {
        set(PROPERTY_CONCEPTFORMULATES, conceptformulates);
    }

    public Boolean isSfprIscontributioniess() {
        return (Boolean) get(PROPERTY_SFPRISCONTRIBUTIONIESS);
    }

    public void setSfprIscontributioniess(Boolean sfprIscontributioniess) {
        set(PROPERTY_SFPRISCONTRIBUTIONIESS, sfprIscontributioniess);
    }

    public Boolean isVariationsalary() {
        return (Boolean) get(PROPERTY_VARIATIONSALARY);
    }

    public void setVariationsalary(Boolean variationsalary) {
        set(PROPERTY_VARIATIONSALARY, variationsalary);
    }

    public Boolean isPrintObservReport() {
        return (Boolean) get(PROPERTY_PRINTOBSERVREPORT);
    }

    public void setPrintObservReport(Boolean printObservReport) {
        set(PROPERTY_PRINTOBSERVREPORT, printObservReport);
    }

    public ssprcodeformulary107 getCodeFormulary107() {
        return (ssprcodeformulary107) get(PROPERTY_CODEFORMULARY107);
    }

    public void setCodeFormulary107(ssprcodeformulary107 codeFormulary107) {
        set(PROPERTY_CODEFORMULARY107, codeFormulary107);
    }

    public String getGroupConcept() {
        return (String) get(PROPERTY_GROUPCONCEPT);
    }

    public void setGroupConcept(String groupConcept) {
        set(PROPERTY_GROUPCONCEPT, groupConcept);
    }

    public Boolean isPrint() {
        return (Boolean) get(PROPERTY_PRINT);
    }

    public void setPrint(Boolean print) {
        set(PROPERTY_PRINT, print);
    }

    @SuppressWarnings("unchecked")
    public List<BusinessPartner> getBusinessPartnerEmSsprConceptIdList() {
      return (List<BusinessPartner>) get(PROPERTY_BUSINESSPARTNEREMSSPRCONCEPTIDLIST);
    }

    public void setBusinessPartnerEmSsprConceptIdList(List<BusinessPartner> businessPartnerEmSsprConceptIdList) {
        set(PROPERTY_BUSINESSPARTNEREMSSPRCONCEPTIDLIST, businessPartnerEmSsprConceptIdList);
    }

    @SuppressWarnings("unchecked")
    public List<BusinessPartner> getBusinessPartnerEMSsprConceptThirteenthIDList() {
      return (List<BusinessPartner>) get(PROPERTY_BUSINESSPARTNEREMSSPRCONCEPTTHIRTEENTHIDLIST);
    }

    public void setBusinessPartnerEMSsprConceptThirteenthIDList(List<BusinessPartner> businessPartnerEMSsprConceptThirteenthIDList) {
        set(PROPERTY_BUSINESSPARTNEREMSSPRCONCEPTTHIRTEENTHIDLIST, businessPartnerEMSsprConceptThirteenthIDList);
    }

    @SuppressWarnings("unchecked")
    public List<BusinessPartner> getBusinessPartnerEMSsprConceptFourteenthIDList() {
      return (List<BusinessPartner>) get(PROPERTY_BUSINESSPARTNEREMSSPRCONCEPTFOURTEENTHIDLIST);
    }

    public void setBusinessPartnerEMSsprConceptFourteenthIDList(List<BusinessPartner> businessPartnerEMSsprConceptFourteenthIDList) {
        set(PROPERTY_BUSINESSPARTNEREMSSPRCONCEPTFOURTEENTHIDLIST, businessPartnerEMSsprConceptFourteenthIDList);
    }

    @SuppressWarnings("unchecked")
    public List<BusinessPartner> getBusinessPartnerEMSsprConceptVacIDList() {
      return (List<BusinessPartner>) get(PROPERTY_BUSINESSPARTNEREMSSPRCONCEPTVACIDLIST);
    }

    public void setBusinessPartnerEMSsprConceptVacIDList(List<BusinessPartner> businessPartnerEMSsprConceptVacIDList) {
        set(PROPERTY_BUSINESSPARTNEREMSSPRCONCEPTVACIDLIST, businessPartnerEMSsprConceptVacIDList);
    }

    @SuppressWarnings("unchecked")
    public List<Concept> getSSPRConceptSsprConceptFormulaIDList() {
      return (List<Concept>) get(PROPERTY_SSPRCONCEPTSSPRCONCEPTFORMULAIDLIST);
    }

    public void setSSPRConceptSsprConceptFormulaIDList(List<Concept> sSPRConceptSsprConceptFormulaIDList) {
        set(PROPERTY_SSPRCONCEPTSSPRCONCEPTFORMULAIDLIST, sSPRConceptSsprConceptFormulaIDList);
    }

    @SuppressWarnings("unchecked")
    public List<Concept> getSSPRConceptConceptformulatesList() {
      return (List<Concept>) get(PROPERTY_SSPRCONCEPTCONCEPTFORMULATESLIST);
    }

    public void setSSPRConceptConceptformulatesList(List<Concept> sSPRConceptConceptformulatesList) {
        set(PROPERTY_SSPRCONCEPTCONCEPTFORMULATESLIST, sSPRConceptConceptformulatesList);
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
    public List<LaborRegime> getSSPRLaborRegimeEMSfprConceptIDList() {
      return (List<LaborRegime>) get(PROPERTY_SSPRLABORREGIMEEMSFPRCONCEPTIDLIST);
    }

    public void setSSPRLaborRegimeEMSfprConceptIDList(List<LaborRegime> sSPRLaborRegimeEMSfprConceptIDList) {
        set(PROPERTY_SSPRLABORREGIMEEMSFPRCONCEPTIDLIST, sSPRLaborRegimeEMSfprConceptIDList);
    }

    @SuppressWarnings("unchecked")
    public List<PayrollTicketConcept> getSSPRPayrollTicketConceptList() {
      return (List<PayrollTicketConcept>) get(PROPERTY_SSPRPAYROLLTICKETCONCEPTLIST);
    }

    public void setSSPRPayrollTicketConceptList(List<PayrollTicketConcept> sSPRPayrollTicketConceptList) {
        set(PROPERTY_SSPRPAYROLLTICKETCONCEPTLIST, sSPRPayrollTicketConceptList);
    }

    @SuppressWarnings("unchecked")
    public List<PeriodConcept> getSSPRPeriodConceptList() {
      return (List<PeriodConcept>) get(PROPERTY_SSPRPERIODCONCEPTLIST);
    }

    public void setSSPRPeriodConceptList(List<PeriodConcept> sSPRPeriodConceptList) {
        set(PROPERTY_SSPRPERIODCONCEPTLIST, sSPRPeriodConceptList);
    }

    @SuppressWarnings("unchecked")
    public List<PAYROLLLINES> getSSPRProlltemLinesList() {
      return (List<PAYROLLLINES>) get(PROPERTY_SSPRPROLLTEMLINESLIST);
    }

    public void setSSPRProlltemLinesList(List<PAYROLLLINES> sSPRProlltemLinesList) {
        set(PROPERTY_SSPRPROLLTEMLINESLIST, sSPRProlltemLinesList);
    }

    @SuppressWarnings("unchecked")
    public List<SFBBudgetCertLine> getSfbBudgetCertLineEMSsbpSsprConceptIDList() {
      return (List<SFBBudgetCertLine>) get(PROPERTY_SFBBUDGETCERTLINEEMSSBPSSPRCONCEPTIDLIST);
    }

    public void setSfbBudgetCertLineEMSsbpSsprConceptIDList(List<SFBBudgetCertLine> sfbBudgetCertLineEMSsbpSsprConceptIDList) {
        set(PROPERTY_SFBBUDGETCERTLINEEMSSBPSSPRCONCEPTIDLIST, sfbBudgetCertLineEMSsbpSsprConceptIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprEmployeeContribution> getSfprEmployeeContributionPersonalConceptList() {
      return (List<SfprEmployeeContribution>) get(PROPERTY_SFPREMPLOYEECONTRIBUTIONPERSONALCONCEPTLIST);
    }

    public void setSfprEmployeeContributionPersonalConceptList(List<SfprEmployeeContribution> sfprEmployeeContributionPersonalConceptList) {
        set(PROPERTY_SFPREMPLOYEECONTRIBUTIONPERSONALCONCEPTLIST, sfprEmployeeContributionPersonalConceptList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprEmployeeContribution> getSfprEmployeeContributionConceptBossesList() {
      return (List<SfprEmployeeContribution>) get(PROPERTY_SFPREMPLOYEECONTRIBUTIONCONCEPTBOSSESLIST);
    }

    public void setSfprEmployeeContributionConceptBossesList(List<SfprEmployeeContribution> sfprEmployeeContributionConceptBossesList) {
        set(PROPERTY_SFPREMPLOYEECONTRIBUTIONCONCEPTBOSSESLIST, sfprEmployeeContributionConceptBossesList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprEmployeeContribution> getSfprEmployeeContributionTotalIncomeConceptList() {
      return (List<SfprEmployeeContribution>) get(PROPERTY_SFPREMPLOYEECONTRIBUTIONTOTALINCOMECONCEPTLIST);
    }

    public void setSfprEmployeeContributionTotalIncomeConceptList(List<SfprEmployeeContribution> sfprEmployeeContributionTotalIncomeConceptList) {
        set(PROPERTY_SFPREMPLOYEECONTRIBUTIONTOTALINCOMECONCEPTLIST, sfprEmployeeContributionTotalIncomeConceptList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprEmployeeContribution> getSfprEmployeeContributionIncomeList() {
      return (List<SfprEmployeeContribution>) get(PROPERTY_SFPREMPLOYEECONTRIBUTIONINCOMELIST);
    }

    public void setSfprEmployeeContributionIncomeList(List<SfprEmployeeContribution> sfprEmployeeContributionIncomeList) {
        set(PROPERTY_SFPREMPLOYEECONTRIBUTIONINCOMELIST, sfprEmployeeContributionIncomeList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprEmployeeRve> getSfprEmployeeRveEMSsprConceptIDList() {
      return (List<SfprEmployeeRve>) get(PROPERTY_SFPREMPLOYEERVEEMSSPRCONCEPTIDLIST);
    }

    public void setSfprEmployeeRveEMSsprConceptIDList(List<SfprEmployeeRve> sfprEmployeeRveEMSsprConceptIDList) {
        set(PROPERTY_SFPREMPLOYEERVEEMSSPRCONCEPTIDLIST, sfprEmployeeRveEMSsprConceptIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprJobActionline> getSfprJobActionlineList() {
      return (List<SfprJobActionline>) get(PROPERTY_SFPRJOBACTIONLINELIST);
    }

    public void setSfprJobActionlineList(List<SfprJobActionline> sfprJobActionlineList) {
        set(PROPERTY_SFPRJOBACTIONLINELIST, sfprJobActionlineList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprRveDetail> getSfprRveDetailConceptList() {
      return (List<SfprRveDetail>) get(PROPERTY_SFPRRVEDETAILCONCEPTLIST);
    }

    public void setSfprRveDetailConceptList(List<SfprRveDetail> sfprRveDetailConceptList) {
        set(PROPERTY_SFPRRVEDETAILCONCEPTLIST, sfprRveDetailConceptList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprRveDetail> getSfprRveDetailConceptPaymentRveIDList() {
      return (List<SfprRveDetail>) get(PROPERTY_SFPRRVEDETAILCONCEPTPAYMENTRVEIDLIST);
    }

    public void setSfprRveDetailConceptPaymentRveIDList(List<SfprRveDetail> sfprRveDetailConceptPaymentRveIDList) {
        set(PROPERTY_SFPRRVEDETAILCONCEPTPAYMENTRVEIDLIST, sfprRveDetailConceptPaymentRveIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprSurrogateDetail> getSfprSurrogateDetailConceptSurrogateList() {
      return (List<SfprSurrogateDetail>) get(PROPERTY_SFPRSURROGATEDETAILCONCEPTSURROGATELIST);
    }

    public void setSfprSurrogateDetailConceptSurrogateList(List<SfprSurrogateDetail> sfprSurrogateDetailConceptSurrogateList) {
        set(PROPERTY_SFPRSURROGATEDETAILCONCEPTSURROGATELIST, sfprSurrogateDetailConceptSurrogateList);
    }

    @SuppressWarnings("unchecked")
    public List<SSBPNoBudgetCertLine> getSsbpNoBudgetCertLineList() {
      return (List<SSBPNoBudgetCertLine>) get(PROPERTY_SSBPNOBUDGETCERTLINELIST);
    }

    public void setSsbpNoBudgetCertLineList(List<SSBPNoBudgetCertLine> ssbpNoBudgetCertLineList) {
        set(PROPERTY_SSBPNOBUDGETCERTLINELIST, ssbpNoBudgetCertLineList);
    }

    @SuppressWarnings("unchecked")
    public List<sspr_benefit_dismissal> getSsprBenefitDismissalList() {
      return (List<sspr_benefit_dismissal>) get(PROPERTY_SSPRBENEFITDISMISSALLIST);
    }

    public void setSsprBenefitDismissalList(List<sspr_benefit_dismissal> ssprBenefitDismissalList) {
        set(PROPERTY_SSPRBENEFITDISMISSALLIST, ssprBenefitDismissalList);
    }

    @SuppressWarnings("unchecked")
    public List<ConceptAcct> getSsprConceptAcctList() {
      return (List<ConceptAcct>) get(PROPERTY_SSPRCONCEPTACCTLIST);
    }

    public void setSsprConceptAcctList(List<ConceptAcct> ssprConceptAcctList) {
        set(PROPERTY_SSPRCONCEPTACCTLIST, ssprConceptAcctList);
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
    public List<sspremployeesettlementline> getSsprEmployeesettlementlineList() {
      return (List<sspremployeesettlementline>) get(PROPERTY_SSPREMPLOYEESETTLEMENTLINELIST);
    }

    public void setSsprEmployeesettlementlineList(List<sspremployeesettlementline> ssprEmployeesettlementlineList) {
        set(PROPERTY_SSPREMPLOYEESETTLEMENTLINELIST, ssprEmployeesettlementlineList);
    }

    @SuppressWarnings("unchecked")
    public List<ssprleavecategory> getSsprLeaveCategoryList() {
      return (List<ssprleavecategory>) get(PROPERTY_SSPRLEAVECATEGORYLIST);
    }

    public void setSsprLeaveCategoryList(List<ssprleavecategory> ssprLeaveCategoryList) {
        set(PROPERTY_SSPRLEAVECATEGORYLIST, ssprLeaveCategoryList);
    }

    @SuppressWarnings("unchecked")
    public List<sspr_leave_group> getSsprLeaveGroupList() {
      return (List<sspr_leave_group>) get(PROPERTY_SSPRLEAVEGROUPLIST);
    }

    public void setSsprLeaveGroupList(List<sspr_leave_group> ssprLeaveGroupList) {
        set(PROPERTY_SSPRLEAVEGROUPLIST, ssprLeaveGroupList);
    }

    @SuppressWarnings("unchecked")
    public List<ssprloans> getSsprLoansList() {
      return (List<ssprloans>) get(PROPERTY_SSPRLOANSLIST);
    }

    public void setSsprLoansList(List<ssprloans> ssprLoansList) {
        set(PROPERTY_SSPRLOANSLIST, ssprLoansList);
    }

    @SuppressWarnings("unchecked")
    public List<ssprprocesspayroll> getSsprProcessPayrollConceptInList() {
      return (List<ssprprocesspayroll>) get(PROPERTY_SSPRPROCESSPAYROLLCONCEPTINLIST);
    }

    public void setSsprProcessPayrollConceptInList(List<ssprprocesspayroll> ssprProcessPayrollConceptInList) {
        set(PROPERTY_SSPRPROCESSPAYROLLCONCEPTINLIST, ssprProcessPayrollConceptInList);
    }

    @SuppressWarnings("unchecked")
    public List<ssprprocesspayroll> getSsprProcessPayrollConceptOutList() {
      return (List<ssprprocesspayroll>) get(PROPERTY_SSPRPROCESSPAYROLLCONCEPTOUTLIST);
    }

    public void setSsprProcessPayrollConceptOutList(List<ssprprocesspayroll> ssprProcessPayrollConceptOutList) {
        set(PROPERTY_SSPRPROCESSPAYROLLCONCEPTOUTLIST, ssprProcessPayrollConceptOutList);
    }

    @SuppressWarnings("unchecked")
    public List<sspr_settlementdata> getSsprSettlementdataList() {
      return (List<sspr_settlementdata>) get(PROPERTY_SSPRSETTLEMENTDATALIST);
    }

    public void setSsprSettlementdataList(List<sspr_settlementdata> ssprSettlementdataList) {
        set(PROPERTY_SSPRSETTLEMENTDATALIST, ssprSettlementdataList);
    }

    @SuppressWarnings("unchecked")
    public List<sspr_settlementline> getSsprSettlementlineList() {
      return (List<sspr_settlementline>) get(PROPERTY_SSPRSETTLEMENTLINELIST);
    }

    public void setSsprSettlementlineList(List<sspr_settlementline> ssprSettlementlineList) {
        set(PROPERTY_SSPRSETTLEMENTLINELIST, ssprSettlementlineList);
    }

    @SuppressWarnings("unchecked")
    public List<ssprvacations> getSsprVacationsList() {
      return (List<ssprvacations>) get(PROPERTY_SSPRVACATIONSLIST);
    }

    public void setSsprVacationsList(List<ssprvacations> ssprVacationsList) {
        set(PROPERTY_SSPRVACATIONSLIST, ssprVacationsList);
    }

}
