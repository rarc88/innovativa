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

import com.sidesoft.flopec.budget.data.SFBBudget;
import com.sidesoft.flopec.budget.data.SFBBudgetCertificate;
import com.sidesoft.flopec.budget.data.SFBBudgetLog;
import com.sidesoft.flopec.budget.data.sfb_budget_details_v;
import com.sidesoft.flopec.budget.data.sfbbudgetaddline;
import com.sidesoft.hrm.payroll.Contract;
import com.sidesoft.hrm.payroll.Costemployee;
import com.sidesoft.hrm.payroll.CumulativeConcept;
import com.sidesoft.hrm.payroll.Incometax;
import com.sidesoft.hrm.payroll.Incometotal;
import com.sidesoft.hrm.payroll.SsprConfigurationUtility;
import com.sidesoft.hrm.payroll.SsprSupplementaryData;
import com.sidesoft.hrm.payroll.SsprUtilityDetail;
import com.sidesoft.hrm.payroll.SsprValuesIndicesPeriod;
import com.sidesoft.hrm.payroll.sspr_disability;
import com.sidesoft.hrm.payroll.ssprcostdeductiblemax;
import com.sidesoft.hrm.payroll.ssprformulary107;
import com.sidesoft.hrm.payroll.ssprformulary107detailv;
import com.sidesoft.hrm.payroll.ssprprofits;
import com.sidesoft.hrm.payroll.ssprutilities;
import com.sidesoft.hrm.payroll.tenth.SSPHTenthSettlement;

import ec.com.sidesoft.budget.transfers.SfbtrBudgetaryReforms;
import ec.com.sidesoft.custom.budget.direct.SCBDBudgetDirect;
import ec.com.sidesoft.localization.ecuador.viatical.ssve_budget_details_v;

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
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.accounting.Budget;
import org.openbravo.model.financialmgmt.accounting.OrganizationClosing;
/**
 * Entity class for entity FinancialMgmtYear (stored in table C_Year).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Year extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_Year";
    public static final String ENTITY_NAME = "FinancialMgmtYear";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_FISCALYEAR = "fiscalYear";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_CALENDAR = "calendar";
    public static final String PROPERTY_PROCESSNOW = "processNow";
    public static final String PROPERTY_CREATEREGFACTACCT = "createRegFactAcct";
    public static final String PROPERTY_DROPREGFACTACCT = "dropRegFactAcct";
    public static final String PROPERTY_FINANCIALMGMTBUDGETLIST = "financialMgmtBudgetList";
    public static final String PROPERTY_FINANCIALMGMTPERIODLIST = "financialMgmtPeriodList";
    public static final String PROPERTY_ORGANIZATIONCLOSINGLIST = "organizationClosingList";
    public static final String PROPERTY_PERIODCONTROLLOGLIST = "periodControlLogList";
    public static final String PROPERTY_SCBDBUDGETDIRECTLIST = "sCBDBudgetDirectList";
    public static final String PROPERTY_SSPHTENTHSETTLEMENTLIST = "sSPHTenthSettlementList";
    public static final String PROPERTY_SSPRCONTRACTLIST = "sSPRContractList";
    public static final String PROPERTY_SFBTRBUDGETARYREFORMSLIST = "sfbtrBudgetaryReformsList";
    public static final String PROPERTY_YEARCLOSEVLIST = "yearCloseVList";
    public static final String PROPERTY_SFBBUDGETLIST = "sfbBudgetList";
    public static final String PROPERTY_SFBBUDGETADDLINELIST = "sfbBudgetAddlineList";
    public static final String PROPERTY_SFBBUDGETCERTIFICATELIST = "sfbBudgetCertificateList";
    public static final String PROPERTY_SFBBUDGETDETAILSVLIST = "sfbBudgetDetailsVList";
    public static final String PROPERTY_SFBBUDGETLOGLIST = "sfbBudgetLogList";
    public static final String PROPERTY_SSPRCONFIGURATIONUTILITYLIST = "ssprConfigurationutilityList";
    public static final String PROPERTY_SSPRCOSTDEDUCTIBLEMAXLIST = "ssprCostdeductiblemaxList";
    public static final String PROPERTY_SSPRCOSTEMPLOYEELIST = "ssprCostemployeeList";
    public static final String PROPERTY_SSPRCUMULATIVECONCEPTLIST = "ssprCumulativeconceptList";
    public static final String PROPERTY_SSPRDISABILITYLIST = "ssprDisabilityList";
    public static final String PROPERTY_SSPRFORMULARY107LIST = "ssprFormulary107List";
    public static final String PROPERTY_SSPRFORMULARY107DETAILVLIST = "ssprFormulary107DetailVList";
    public static final String PROPERTY_SSPRINCOMETAXLIST = "ssprIncometaxList";
    public static final String PROPERTY_SSPRINCOMETOTALLIST = "ssprIncometotalList";
    public static final String PROPERTY_SSPRPROFITSLIST = "ssprProfitsList";
    public static final String PROPERTY_SSPRSUPPLEMENTARYDATALIST = "ssprSupplementaryDataList";
    public static final String PROPERTY_SSPRUTILITIESLIST = "ssprUtilitiesList";
    public static final String PROPERTY_SSPRUTILITYDETAILLIST = "ssprUtilityDetailList";
    public static final String PROPERTY_SSPRVALUESINDICESPERIODLIST = "ssprValuesindicesperiodList";
    public static final String PROPERTY_SSVEBUDGETDETAILSVLIST = "ssveBudgetDetailsVList";

    public Year() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_PROCESSNOW, false);
        setDefaultValue(PROPERTY_CREATEREGFACTACCT, false);
        setDefaultValue(PROPERTY_DROPREGFACTACCT, false);
        setDefaultValue(PROPERTY_FINANCIALMGMTBUDGETLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTPERIODLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORGANIZATIONCLOSINGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PERIODCONTROLLOGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCBDBUDGETDIRECTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPHTENTHSETTLEMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRCONTRACTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBTRBUDGETARYREFORMSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_YEARCLOSEVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETADDLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETCERTIFICATELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETDETAILSVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETLOGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRCONFIGURATIONUTILITYLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRCOSTDEDUCTIBLEMAXLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRCOSTEMPLOYEELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRCUMULATIVECONCEPTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRDISABILITYLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRFORMULARY107LIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRFORMULARY107DETAILVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRINCOMETAXLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRINCOMETOTALLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRPROFITSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRSUPPLEMENTARYDATALIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRUTILITIESLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRUTILITYDETAILLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRVALUESINDICESPERIODLIST, new ArrayList<Object>());
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

    public String getFiscalYear() {
        return (String) get(PROPERTY_FISCALYEAR);
    }

    public void setFiscalYear(String fiscalYear) {
        set(PROPERTY_FISCALYEAR, fiscalYear);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Calendar getCalendar() {
        return (Calendar) get(PROPERTY_CALENDAR);
    }

    public void setCalendar(Calendar calendar) {
        set(PROPERTY_CALENDAR, calendar);
    }

    public Boolean isProcessNow() {
        return (Boolean) get(PROPERTY_PROCESSNOW);
    }

    public void setProcessNow(Boolean processNow) {
        set(PROPERTY_PROCESSNOW, processNow);
    }

    public Boolean isCreateRegFactAcct() {
        return (Boolean) get(PROPERTY_CREATEREGFACTACCT);
    }

    public void setCreateRegFactAcct(Boolean createRegFactAcct) {
        set(PROPERTY_CREATEREGFACTACCT, createRegFactAcct);
    }

    public Boolean isDropRegFactAcct() {
        return (Boolean) get(PROPERTY_DROPREGFACTACCT);
    }

    public void setDropRegFactAcct(Boolean dropRegFactAcct) {
        set(PROPERTY_DROPREGFACTACCT, dropRegFactAcct);
    }

    @SuppressWarnings("unchecked")
    public List<Budget> getFinancialMgmtBudgetList() {
      return (List<Budget>) get(PROPERTY_FINANCIALMGMTBUDGETLIST);
    }

    public void setFinancialMgmtBudgetList(List<Budget> financialMgmtBudgetList) {
        set(PROPERTY_FINANCIALMGMTBUDGETLIST, financialMgmtBudgetList);
    }

    @SuppressWarnings("unchecked")
    public List<Period> getFinancialMgmtPeriodList() {
      return (List<Period>) get(PROPERTY_FINANCIALMGMTPERIODLIST);
    }

    public void setFinancialMgmtPeriodList(List<Period> financialMgmtPeriodList) {
        set(PROPERTY_FINANCIALMGMTPERIODLIST, financialMgmtPeriodList);
    }

    @SuppressWarnings("unchecked")
    public List<OrganizationClosing> getOrganizationClosingList() {
      return (List<OrganizationClosing>) get(PROPERTY_ORGANIZATIONCLOSINGLIST);
    }

    public void setOrganizationClosingList(List<OrganizationClosing> organizationClosingList) {
        set(PROPERTY_ORGANIZATIONCLOSINGLIST, organizationClosingList);
    }

    @SuppressWarnings("unchecked")
    public List<PeriodControlLog> getPeriodControlLogList() {
      return (List<PeriodControlLog>) get(PROPERTY_PERIODCONTROLLOGLIST);
    }

    public void setPeriodControlLogList(List<PeriodControlLog> periodControlLogList) {
        set(PROPERTY_PERIODCONTROLLOGLIST, periodControlLogList);
    }

    @SuppressWarnings("unchecked")
    public List<SCBDBudgetDirect> getSCBDBudgetDirectList() {
      return (List<SCBDBudgetDirect>) get(PROPERTY_SCBDBUDGETDIRECTLIST);
    }

    public void setSCBDBudgetDirectList(List<SCBDBudgetDirect> sCBDBudgetDirectList) {
        set(PROPERTY_SCBDBUDGETDIRECTLIST, sCBDBudgetDirectList);
    }

    @SuppressWarnings("unchecked")
    public List<SSPHTenthSettlement> getSSPHTenthSettlementList() {
      return (List<SSPHTenthSettlement>) get(PROPERTY_SSPHTENTHSETTLEMENTLIST);
    }

    public void setSSPHTenthSettlementList(List<SSPHTenthSettlement> sSPHTenthSettlementList) {
        set(PROPERTY_SSPHTENTHSETTLEMENTLIST, sSPHTenthSettlementList);
    }

    @SuppressWarnings("unchecked")
    public List<Contract> getSSPRContractList() {
      return (List<Contract>) get(PROPERTY_SSPRCONTRACTLIST);
    }

    public void setSSPRContractList(List<Contract> sSPRContractList) {
        set(PROPERTY_SSPRCONTRACTLIST, sSPRContractList);
    }

    @SuppressWarnings("unchecked")
    public List<SfbtrBudgetaryReforms> getSfbtrBudgetaryReformsList() {
      return (List<SfbtrBudgetaryReforms>) get(PROPERTY_SFBTRBUDGETARYREFORMSLIST);
    }

    public void setSfbtrBudgetaryReformsList(List<SfbtrBudgetaryReforms> sfbtrBudgetaryReformsList) {
        set(PROPERTY_SFBTRBUDGETARYREFORMSLIST, sfbtrBudgetaryReformsList);
    }

    @SuppressWarnings("unchecked")
    public List<YearClose> getYearCloseVList() {
      return (List<YearClose>) get(PROPERTY_YEARCLOSEVLIST);
    }

    public void setYearCloseVList(List<YearClose> yearCloseVList) {
        set(PROPERTY_YEARCLOSEVLIST, yearCloseVList);
    }

    @SuppressWarnings("unchecked")
    public List<SFBBudget> getSfbBudgetList() {
      return (List<SFBBudget>) get(PROPERTY_SFBBUDGETLIST);
    }

    public void setSfbBudgetList(List<SFBBudget> sfbBudgetList) {
        set(PROPERTY_SFBBUDGETLIST, sfbBudgetList);
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
    public List<sfb_budget_details_v> getSfbBudgetDetailsVList() {
      return (List<sfb_budget_details_v>) get(PROPERTY_SFBBUDGETDETAILSVLIST);
    }

    public void setSfbBudgetDetailsVList(List<sfb_budget_details_v> sfbBudgetDetailsVList) {
        set(PROPERTY_SFBBUDGETDETAILSVLIST, sfbBudgetDetailsVList);
    }

    @SuppressWarnings("unchecked")
    public List<SFBBudgetLog> getSfbBudgetLogList() {
      return (List<SFBBudgetLog>) get(PROPERTY_SFBBUDGETLOGLIST);
    }

    public void setSfbBudgetLogList(List<SFBBudgetLog> sfbBudgetLogList) {
        set(PROPERTY_SFBBUDGETLOGLIST, sfbBudgetLogList);
    }

    @SuppressWarnings("unchecked")
    public List<SsprConfigurationUtility> getSsprConfigurationutilityList() {
      return (List<SsprConfigurationUtility>) get(PROPERTY_SSPRCONFIGURATIONUTILITYLIST);
    }

    public void setSsprConfigurationutilityList(List<SsprConfigurationUtility> ssprConfigurationutilityList) {
        set(PROPERTY_SSPRCONFIGURATIONUTILITYLIST, ssprConfigurationutilityList);
    }

    @SuppressWarnings("unchecked")
    public List<ssprcostdeductiblemax> getSsprCostdeductiblemaxList() {
      return (List<ssprcostdeductiblemax>) get(PROPERTY_SSPRCOSTDEDUCTIBLEMAXLIST);
    }

    public void setSsprCostdeductiblemaxList(List<ssprcostdeductiblemax> ssprCostdeductiblemaxList) {
        set(PROPERTY_SSPRCOSTDEDUCTIBLEMAXLIST, ssprCostdeductiblemaxList);
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
    public List<sspr_disability> getSsprDisabilityList() {
      return (List<sspr_disability>) get(PROPERTY_SSPRDISABILITYLIST);
    }

    public void setSsprDisabilityList(List<sspr_disability> ssprDisabilityList) {
        set(PROPERTY_SSPRDISABILITYLIST, ssprDisabilityList);
    }

    @SuppressWarnings("unchecked")
    public List<ssprformulary107> getSsprFormulary107List() {
      return (List<ssprformulary107>) get(PROPERTY_SSPRFORMULARY107LIST);
    }

    public void setSsprFormulary107List(List<ssprformulary107> ssprFormulary107List) {
        set(PROPERTY_SSPRFORMULARY107LIST, ssprFormulary107List);
    }

    @SuppressWarnings("unchecked")
    public List<ssprformulary107detailv> getSsprFormulary107DetailVList() {
      return (List<ssprformulary107detailv>) get(PROPERTY_SSPRFORMULARY107DETAILVLIST);
    }

    public void setSsprFormulary107DetailVList(List<ssprformulary107detailv> ssprFormulary107DetailVList) {
        set(PROPERTY_SSPRFORMULARY107DETAILVLIST, ssprFormulary107DetailVList);
    }

    @SuppressWarnings("unchecked")
    public List<Incometax> getSsprIncometaxList() {
      return (List<Incometax>) get(PROPERTY_SSPRINCOMETAXLIST);
    }

    public void setSsprIncometaxList(List<Incometax> ssprIncometaxList) {
        set(PROPERTY_SSPRINCOMETAXLIST, ssprIncometaxList);
    }

    @SuppressWarnings("unchecked")
    public List<Incometotal> getSsprIncometotalList() {
      return (List<Incometotal>) get(PROPERTY_SSPRINCOMETOTALLIST);
    }

    public void setSsprIncometotalList(List<Incometotal> ssprIncometotalList) {
        set(PROPERTY_SSPRINCOMETOTALLIST, ssprIncometotalList);
    }

    @SuppressWarnings("unchecked")
    public List<ssprprofits> getSsprProfitsList() {
      return (List<ssprprofits>) get(PROPERTY_SSPRPROFITSLIST);
    }

    public void setSsprProfitsList(List<ssprprofits> ssprProfitsList) {
        set(PROPERTY_SSPRPROFITSLIST, ssprProfitsList);
    }

    @SuppressWarnings("unchecked")
    public List<SsprSupplementaryData> getSsprSupplementaryDataList() {
      return (List<SsprSupplementaryData>) get(PROPERTY_SSPRSUPPLEMENTARYDATALIST);
    }

    public void setSsprSupplementaryDataList(List<SsprSupplementaryData> ssprSupplementaryDataList) {
        set(PROPERTY_SSPRSUPPLEMENTARYDATALIST, ssprSupplementaryDataList);
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
    public List<SsprValuesIndicesPeriod> getSsprValuesindicesperiodList() {
      return (List<SsprValuesIndicesPeriod>) get(PROPERTY_SSPRVALUESINDICESPERIODLIST);
    }

    public void setSsprValuesindicesperiodList(List<SsprValuesIndicesPeriod> ssprValuesindicesperiodList) {
        set(PROPERTY_SSPRVALUESINDICESPERIODLIST, ssprValuesindicesperiodList);
    }

    @SuppressWarnings("unchecked")
    public List<ssve_budget_details_v> getSsveBudgetDetailsVList() {
      return (List<ssve_budget_details_v>) get(PROPERTY_SSVEBUDGETDETAILSVLIST);
    }

    public void setSsveBudgetDetailsVList(List<ssve_budget_details_v> ssveBudgetDetailsVList) {
        set(PROPERTY_SSVEBUDGETDETAILSVLIST, ssveBudgetDetailsVList);
    }

}
