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
import com.sidesoft.localization.ecuador.finances.esigef.SsfiegFinPayableCreditV;
import com.sidesoft.localization.ecuador.finances.esigef.SsfiegFinPayableDebitV;

import ec.com.sidesoft.budget.transfers.SfbtrBudgetaryReforms;
import ec.com.sidesoft.budget.transfers.SfbtrTransferFrom;
import ec.com.sidesoft.budget.transfers.SfbtrTransferTo;
import ec.com.sidesoft.custom.budget.direct.SCBDBudgetDirect;
import ec.com.sidesoft.localization.ecuador.viatical.SSVEViaticalConfig;
import ec.com.sidesoft.localization.ecuador.viatical.SsveViaticalConfigAcct;
import ec.com.sidesoft.localization.ecuador.viatical.ssve_budget_details_v;
import ec.com.sidesoft.poa.pac.EcsppPAC;

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
import org.openbravo.model.common.businesspartner.VendorAccounts;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
import org.openbravo.model.financialmgmt.assetmgmt.AssetGroup;
/**
 * Entity class for entity sfb_budget_item (stored in table sfb_budget_item).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SFBBudgetItem extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sfb_budget_item";
    public static final String ENTITY_NAME = "sfb_budget_item";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_COMMERCIALNAME = "commercialName";
    public static final String PROPERTY_SEARCHKEY = "searchKey";
    public static final String PROPERTY_NEGATIVE = "negative";
    public static final String PROPERTY_SFBINISINCOME = "sfbinIsincome";
    public static final String PROPERTY_SUMMARYLEVEL = "summaryLevel";
    public static final String PROPERTY_FINANCIALMGMTASSETEMSFBBUDGETITEMIDLIST = "financialMgmtAssetEMSfbBudgetItemIDList";
    public static final String PROPERTY_FINANCIALMGMTASSETGROUPEMSFBBUDGETITEMIDLIST = "financialMgmtAssetGroupEMSfbBudgetItemIDList";
    public static final String PROPERTY_SCBDBUDGETDIRECTLIST = "sCBDBudgetDirectList";
    public static final String PROPERTY_SFBDEFERREDINVOICELIST = "sFBDeferredInvoiceList";
    public static final String PROPERTY_SSVEVIATICALCONFIGLIST = "sSVEViaticalConfigList";
    public static final String PROPERTY_SFBTRBUDGETARYREFORMSLIST = "sfbtrBudgetaryReformsList";
    public static final String PROPERTY_SFBTRTRANSFERFROMLIST = "sfbtrTransferFromList";
    public static final String PROPERTY_SFBTRTRANSFERTOLIST = "sfbtrTransferToList";
    public static final String PROPERTY_SSVEVIATICALCONFIGACCTEMSVTBBUDGETITEMLIST = "ssveViaticalConfigAcctEMSvtbBudgetItemList";
    public static final String PROPERTY_VENDORACCOUNTSEMSPAABUDGETITEMLIST = "vendorAccountsEMSpaaBudgetItemList";
    public static final String PROPERTY_ECSPPPACBUDGETITEMLIST = "ecsppPacBudgetItemList";
    public static final String PROPERTY_SFBBUDGETADDLINELIST = "sfbBudgetAddlineList";
    public static final String PROPERTY_SFBBUDGETAREAITEMLIST = "sfbBudgetAreaItemList";
    public static final String PROPERTY_SFBBUDGETCERTLINELIST = "sfbBudgetCertLineList";
    public static final String PROPERTY_SFBBUDGETCONFIGURATIONLIST = "sfbBudgetConfigurationList";
    public static final String PROPERTY_SFBBUDGETDETAILSVLIST = "sfbBudgetDetailsVList";
    public static final String PROPERTY_SFBBUDGETITEMACCOUNTLIST = "sfbBudgetItemAccountList";
    public static final String PROPERTY_SFBBUDGETLINELIST = "sfbBudgetLineList";
    public static final String PROPERTY_SFBBUDGETLOGBUDGETITEMFROMIDLIST = "sfbBudgetLogBudgetItemFromIDList";
    public static final String PROPERTY_SFBBUDGETLOGBUDGETITEMTOIDLIST = "sfbBudgetLogBudgetItemToIDList";
    public static final String PROPERTY_SFBBUDGETLOGVITEMFROMIDLIST = "sfbBudgetLogVItemFromIDList";
    public static final String PROPERTY_SFBBUDGETLOGVITEMTOIDLIST = "sfbBudgetLogVItemToIDList";
    public static final String PROPERTY_SSFIEGFINPAYABLECREDITVLIST = "ssfiegFinPayableCreditVList";
    public static final String PROPERTY_SSFIEGFINPAYABLEDEBITVLIST = "ssfiegFinPayableDebitVList";
    public static final String PROPERTY_SSPRCONCEPTACCTEMSSBPSFBBUDGETITEMIDLIST = "ssprConceptAcctEMSsbpSfbBudgetItemIDList";
    public static final String PROPERTY_SSVEBUDGETDETAILSVLIST = "ssveBudgetDetailsVList";

    public SFBBudgetItem() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_NEGATIVE, false);
        setDefaultValue(PROPERTY_SFBINISINCOME, false);
        setDefaultValue(PROPERTY_SUMMARYLEVEL, false);
        setDefaultValue(PROPERTY_FINANCIALMGMTASSETEMSFBBUDGETITEMIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTASSETGROUPEMSFBBUDGETITEMIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCBDBUDGETDIRECTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBDEFERREDINVOICELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSVEVIATICALCONFIGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBTRBUDGETARYREFORMSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBTRTRANSFERFROMLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBTRTRANSFERTOLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSVEVIATICALCONFIGACCTEMSVTBBUDGETITEMLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_VENDORACCOUNTSEMSPAABUDGETITEMLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ECSPPPACBUDGETITEMLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETADDLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETAREAITEMLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETCERTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETCONFIGURATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETDETAILSVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETITEMACCOUNTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETLOGBUDGETITEMFROMIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETLOGBUDGETITEMTOIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETLOGVITEMFROMIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETLOGVITEMTOIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSFIEGFINPAYABLECREDITVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSFIEGFINPAYABLEDEBITVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRCONCEPTACCTEMSSBPSFBBUDGETITEMIDLIST, new ArrayList<Object>());
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

    public String getCommercialName() {
        return (String) get(PROPERTY_COMMERCIALNAME);
    }

    public void setCommercialName(String commercialName) {
        set(PROPERTY_COMMERCIALNAME, commercialName);
    }

    public String getSearchKey() {
        return (String) get(PROPERTY_SEARCHKEY);
    }

    public void setSearchKey(String searchKey) {
        set(PROPERTY_SEARCHKEY, searchKey);
    }

    public Boolean isNegative() {
        return (Boolean) get(PROPERTY_NEGATIVE);
    }

    public void setNegative(Boolean negative) {
        set(PROPERTY_NEGATIVE, negative);
    }

    public Boolean isSfbinIsincome() {
        return (Boolean) get(PROPERTY_SFBINISINCOME);
    }

    public void setSfbinIsincome(Boolean sfbinIsincome) {
        set(PROPERTY_SFBINISINCOME, sfbinIsincome);
    }

    public Boolean isSummaryLevel() {
        return (Boolean) get(PROPERTY_SUMMARYLEVEL);
    }

    public void setSummaryLevel(Boolean summaryLevel) {
        set(PROPERTY_SUMMARYLEVEL, summaryLevel);
    }

    @SuppressWarnings("unchecked")
    public List<Asset> getFinancialMgmtAssetEMSfbBudgetItemIDList() {
      return (List<Asset>) get(PROPERTY_FINANCIALMGMTASSETEMSFBBUDGETITEMIDLIST);
    }

    public void setFinancialMgmtAssetEMSfbBudgetItemIDList(List<Asset> financialMgmtAssetEMSfbBudgetItemIDList) {
        set(PROPERTY_FINANCIALMGMTASSETEMSFBBUDGETITEMIDLIST, financialMgmtAssetEMSfbBudgetItemIDList);
    }

    @SuppressWarnings("unchecked")
    public List<AssetGroup> getFinancialMgmtAssetGroupEMSfbBudgetItemIDList() {
      return (List<AssetGroup>) get(PROPERTY_FINANCIALMGMTASSETGROUPEMSFBBUDGETITEMIDLIST);
    }

    public void setFinancialMgmtAssetGroupEMSfbBudgetItemIDList(List<AssetGroup> financialMgmtAssetGroupEMSfbBudgetItemIDList) {
        set(PROPERTY_FINANCIALMGMTASSETGROUPEMSFBBUDGETITEMIDLIST, financialMgmtAssetGroupEMSfbBudgetItemIDList);
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
    public List<SSVEViaticalConfig> getSSVEViaticalConfigList() {
      return (List<SSVEViaticalConfig>) get(PROPERTY_SSVEVIATICALCONFIGLIST);
    }

    public void setSSVEViaticalConfigList(List<SSVEViaticalConfig> sSVEViaticalConfigList) {
        set(PROPERTY_SSVEVIATICALCONFIGLIST, sSVEViaticalConfigList);
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
    public List<SsveViaticalConfigAcct> getSsveViaticalConfigAcctEMSvtbBudgetItemList() {
      return (List<SsveViaticalConfigAcct>) get(PROPERTY_SSVEVIATICALCONFIGACCTEMSVTBBUDGETITEMLIST);
    }

    public void setSsveViaticalConfigAcctEMSvtbBudgetItemList(List<SsveViaticalConfigAcct> ssveViaticalConfigAcctEMSvtbBudgetItemList) {
        set(PROPERTY_SSVEVIATICALCONFIGACCTEMSVTBBUDGETITEMLIST, ssveViaticalConfigAcctEMSvtbBudgetItemList);
    }

    @SuppressWarnings("unchecked")
    public List<VendorAccounts> getVendorAccountsEMSpaaBudgetItemList() {
      return (List<VendorAccounts>) get(PROPERTY_VENDORACCOUNTSEMSPAABUDGETITEMLIST);
    }

    public void setVendorAccountsEMSpaaBudgetItemList(List<VendorAccounts> vendorAccountsEMSpaaBudgetItemList) {
        set(PROPERTY_VENDORACCOUNTSEMSPAABUDGETITEMLIST, vendorAccountsEMSpaaBudgetItemList);
    }

    @SuppressWarnings("unchecked")
    public List<EcsppPAC> getEcsppPacBudgetItemList() {
      return (List<EcsppPAC>) get(PROPERTY_ECSPPPACBUDGETITEMLIST);
    }

    public void setEcsppPacBudgetItemList(List<EcsppPAC> ecsppPacBudgetItemList) {
        set(PROPERTY_ECSPPPACBUDGETITEMLIST, ecsppPacBudgetItemList);
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
    public List<SFBBudgetItemAccount> getSfbBudgetItemAccountList() {
      return (List<SFBBudgetItemAccount>) get(PROPERTY_SFBBUDGETITEMACCOUNTLIST);
    }

    public void setSfbBudgetItemAccountList(List<SFBBudgetItemAccount> sfbBudgetItemAccountList) {
        set(PROPERTY_SFBBUDGETITEMACCOUNTLIST, sfbBudgetItemAccountList);
    }

    @SuppressWarnings("unchecked")
    public List<SFBBudgetLine> getSfbBudgetLineList() {
      return (List<SFBBudgetLine>) get(PROPERTY_SFBBUDGETLINELIST);
    }

    public void setSfbBudgetLineList(List<SFBBudgetLine> sfbBudgetLineList) {
        set(PROPERTY_SFBBUDGETLINELIST, sfbBudgetLineList);
    }

    @SuppressWarnings("unchecked")
    public List<SFBBudgetLog> getSfbBudgetLogBudgetItemFromIDList() {
      return (List<SFBBudgetLog>) get(PROPERTY_SFBBUDGETLOGBUDGETITEMFROMIDLIST);
    }

    public void setSfbBudgetLogBudgetItemFromIDList(List<SFBBudgetLog> sfbBudgetLogBudgetItemFromIDList) {
        set(PROPERTY_SFBBUDGETLOGBUDGETITEMFROMIDLIST, sfbBudgetLogBudgetItemFromIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SFBBudgetLog> getSfbBudgetLogBudgetItemToIDList() {
      return (List<SFBBudgetLog>) get(PROPERTY_SFBBUDGETLOGBUDGETITEMTOIDLIST);
    }

    public void setSfbBudgetLogBudgetItemToIDList(List<SFBBudgetLog> sfbBudgetLogBudgetItemToIDList) {
        set(PROPERTY_SFBBUDGETLOGBUDGETITEMTOIDLIST, sfbBudgetLogBudgetItemToIDList);
    }

    @SuppressWarnings("unchecked")
    public List<sfb_budget_log_v> getSfbBudgetLogVItemFromIDList() {
      return (List<sfb_budget_log_v>) get(PROPERTY_SFBBUDGETLOGVITEMFROMIDLIST);
    }

    public void setSfbBudgetLogVItemFromIDList(List<sfb_budget_log_v> sfbBudgetLogVItemFromIDList) {
        set(PROPERTY_SFBBUDGETLOGVITEMFROMIDLIST, sfbBudgetLogVItemFromIDList);
    }

    @SuppressWarnings("unchecked")
    public List<sfb_budget_log_v> getSfbBudgetLogVItemToIDList() {
      return (List<sfb_budget_log_v>) get(PROPERTY_SFBBUDGETLOGVITEMTOIDLIST);
    }

    public void setSfbBudgetLogVItemToIDList(List<sfb_budget_log_v> sfbBudgetLogVItemToIDList) {
        set(PROPERTY_SFBBUDGETLOGVITEMTOIDLIST, sfbBudgetLogVItemToIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SsfiegFinPayableCreditV> getSsfiegFinPayableCreditVList() {
      return (List<SsfiegFinPayableCreditV>) get(PROPERTY_SSFIEGFINPAYABLECREDITVLIST);
    }

    public void setSsfiegFinPayableCreditVList(List<SsfiegFinPayableCreditV> ssfiegFinPayableCreditVList) {
        set(PROPERTY_SSFIEGFINPAYABLECREDITVLIST, ssfiegFinPayableCreditVList);
    }

    @SuppressWarnings("unchecked")
    public List<SsfiegFinPayableDebitV> getSsfiegFinPayableDebitVList() {
      return (List<SsfiegFinPayableDebitV>) get(PROPERTY_SSFIEGFINPAYABLEDEBITVLIST);
    }

    public void setSsfiegFinPayableDebitVList(List<SsfiegFinPayableDebitV> ssfiegFinPayableDebitVList) {
        set(PROPERTY_SSFIEGFINPAYABLEDEBITVLIST, ssfiegFinPayableDebitVList);
    }

    @SuppressWarnings("unchecked")
    public List<ConceptAcct> getSsprConceptAcctEMSsbpSfbBudgetItemIDList() {
      return (List<ConceptAcct>) get(PROPERTY_SSPRCONCEPTACCTEMSSBPSFBBUDGETITEMIDLIST);
    }

    public void setSsprConceptAcctEMSsbpSfbBudgetItemIDList(List<ConceptAcct> ssprConceptAcctEMSsbpSfbBudgetItemIDList) {
        set(PROPERTY_SSPRCONCEPTACCTEMSSBPSFBBUDGETITEMIDLIST, ssprConceptAcctEMSsbpSfbBudgetItemIDList);
    }

    @SuppressWarnings("unchecked")
    public List<ssve_budget_details_v> getSsveBudgetDetailsVList() {
      return (List<ssve_budget_details_v>) get(PROPERTY_SSVEBUDGETDETAILSVLIST);
    }

    public void setSsveBudgetDetailsVList(List<ssve_budget_details_v> ssveBudgetDetailsVList) {
        set(PROPERTY_SSVEBUDGETDETAILSVLIST, ssveBudgetDetailsVList);
    }

}
