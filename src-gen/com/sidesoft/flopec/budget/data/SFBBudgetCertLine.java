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

import com.sidesoft.hrm.payroll.Concept;
import com.sidesoft.hrm.payroll.ssprcategoryacct;

import ec.com.sidesoft.custom.budget.direct.SCBDBudgetDirect;
import ec.com.sidesoft.localization.ecuador.viatical.SSVEViatSettlTransp;
import ec.com.sidesoft.localization.ecuador.viatical.SSVEViatSettlementLine;
import ec.com.sidesoft.localization.ecuador.viatical.SSVEViatical;
import ec.com.sidesoft.localization.ecuador.viatical.SSVEViaticalLine;
import ec.com.sidesoft.localization.ecuador.viatical.SSVEViaticalSettlement;
import ec.com.sidesoft.localization.ecuador.viatical.SSVEViaticalTransp;
import ec.com.sidesoft.localization.ecuador.viatical.ssve_viatical_details_v;
import ec.com.sidesoft.revenue.collected.SSRFCBalancecontrol;
import ec.com.sidesoft.secondary.accounting.SSACCTJournalLine;

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
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.invoice.InvoiceLine;
import org.openbravo.model.common.order.OrderLine;
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.accounting.UserDimension1;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
import org.openbravo.model.financialmgmt.assetmgmt.AssetGroup;
import org.openbravo.model.financialmgmt.gl.GLJournalLine;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentDetail;
/**
 * Entity class for entity sfb_budget_cert_line (stored in table sfb_budget_cert_line).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SFBBudgetCertLine extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sfb_budget_cert_line";
    public static final String ENTITY_NAME = "sfb_budget_cert_line";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_BUDGETITEM = "budgetItem";
    public static final String PROPERTY_COSTCENTER = "costCenter";
    public static final String PROPERTY_CONCEPT = "concept";
    public static final String PROPERTY_COMMITTEDVALUE = "committedValue";
    public static final String PROPERTY_EXECUTEDVALUE = "executedValue";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_SFBBUDGETCERTIFICATE = "sFBBudgetCertificate";
    public static final String PROPERTY_CERTIFIEDVALUE = "certifiedValue";
    public static final String PROPERTY_LINENO = "lineNo";
    public static final String PROPERTY_BUDGETCERTIFIEDVALUE = "budgetCertifiedValue";
    public static final String PROPERTY_BUDGETCOMMITTEDVALUE = "budgetCommittedValue";
    public static final String PROPERTY_BUDGETEXECUTEDVALUE = "budgetExecutedValue";
    public static final String PROPERTY_ACTUALVALUE = "actualValue";
    public static final String PROPERTY_AVAILABLEBALANCE = "availableBalance";
    public static final String PROPERTY_BUDGETAVAILABLEBALANCE = "budgetAvailableBalance";
    public static final String PROPERTY_BUDGETACTUALVALUE = "budgetActualValue";
    public static final String PROPERTY_STDIMENSION = "stDimension";
    public static final String PROPERTY_SSBPSSPRCONCEPT = "ssbpSsprConcept";
    public static final String PROPERTY_SSBPSSPRCATEGORYACCT = "ssbpSsprCategoryAcct";
    public static final String PROPERTY_ASSET = "asset";
    public static final String PROPERTY_ASSETCATEGORY = "assetCategory";
    public static final String PROPERTY_PAIDOUTVALUE = "paidoutValue";
    public static final String PROPERTY_PAIDOUTVALUECURRENCY = "paidoutValueCurrency";
    public static final String PROPERTY_SSBPSFBBUDGETAREA = "ssbpSfbBudgetArea";
    public static final String PROPERTY_FINPAYMENTDETAILEMSFBCERTIFICATELINELIST = "fINPaymentDetailEMSFBCertificateLineList";
    public static final String PROPERTY_FINANCIALMGMTGLJOURNALLINEEMSFBCERTIFICATELINELIST = "financialMgmtGLJournalLineEMSFBCertificateLineList";
    public static final String PROPERTY_INVOICELINEEMSFBBUDGETCERTLINELIST = "invoiceLineEMSfbBudgetCertLineList";
    public static final String PROPERTY_ORDERLINEEMSFBBUDGETCERTLINELIST = "orderLineEMSFBBudgetCertLineList";
    public static final String PROPERTY_SCBDBUDGETDIRECTLIST = "sCBDBudgetDirectList";
    public static final String PROPERTY_SSACCTJOURNALLINELIST = "sSACCTJournalLineList";
    public static final String PROPERTY_SSRFCBALANCECONTROLLIST = "sSRFCBalancecontrolList";
    public static final String PROPERTY_SSVEVIATSETTLTRANSPLIST = "sSVEViatSettlTranspList";
    public static final String PROPERTY_SSVEVIATSETTLEMENTLINELIST = "sSVEViatSettlementLineList";
    public static final String PROPERTY_SSVEVIATICALLIST = "sSVEViaticalList";
    public static final String PROPERTY_SSVEVIATICALLINELIST = "sSVEViaticalLineList";
    public static final String PROPERTY_SSVEVIATICALSETTLEMENTLIST = "sSVEViaticalSettlementList";
    public static final String PROPERTY_SSVEVIATICALTRANSPLIST = "sSVEViaticalTranspList";
    public static final String PROPERTY_SFBBUDGETCERTLINEDETVEMSFBBUDGETCERTLINEIDLIST = "sfbBudgetCertLineDetVEMSfbBudgetCertLineIDList";
    public static final String PROPERTY_SFBBUDGETJOURNALINEDETVLIST = "sfbBudgetJournalineDetVList";
    public static final String PROPERTY_SFBBUDGETLINEDETAILVLIST = "sfbBudgetLineDetailVList";
    public static final String PROPERTY_SFBBUDGETPAYMENTDETVLIST = "sfbBudgetPaymentDetVList";
    public static final String PROPERTY_SSVEVIATICALDETAILSVLIST = "ssveViaticalDetailsVList";

    public SFBBudgetCertLine() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_COMMITTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_EXECUTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_CERTIFIEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_BUDGETCERTIFIEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_BUDGETCOMMITTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_BUDGETEXECUTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_ACTUALVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_AVAILABLEBALANCE, new BigDecimal(0));
        setDefaultValue(PROPERTY_BUDGETAVAILABLEBALANCE, new BigDecimal(0));
        setDefaultValue(PROPERTY_BUDGETACTUALVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_PAIDOUTVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_PAIDOUTVALUECURRENCY, new BigDecimal(0));
        setDefaultValue(PROPERTY_FINPAYMENTDETAILEMSFBCERTIFICATELINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTGLJOURNALLINEEMSFBCERTIFICATELINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELINEEMSFBBUDGETCERTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERLINEEMSFBBUDGETCERTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCBDBUDGETDIRECTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSACCTJOURNALLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSRFCBALANCECONTROLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSVEVIATSETTLTRANSPLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSVEVIATSETTLEMENTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSVEVIATICALLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSVEVIATICALLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSVEVIATICALSETTLEMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSVEVIATICALTRANSPLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETCERTLINEDETVEMSFBBUDGETCERTLINEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETJOURNALINEDETVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETLINEDETAILVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETPAYMENTDETVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSVEVIATICALDETAILSVLIST, new ArrayList<Object>());
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

    public SFBBudgetItem getBudgetItem() {
        return (SFBBudgetItem) get(PROPERTY_BUDGETITEM);
    }

    public void setBudgetItem(SFBBudgetItem budgetItem) {
        set(PROPERTY_BUDGETITEM, budgetItem);
    }

    public Costcenter getCostCenter() {
        return (Costcenter) get(PROPERTY_COSTCENTER);
    }

    public void setCostCenter(Costcenter costCenter) {
        set(PROPERTY_COSTCENTER, costCenter);
    }

    public String getConcept() {
        return (String) get(PROPERTY_CONCEPT);
    }

    public void setConcept(String concept) {
        set(PROPERTY_CONCEPT, concept);
    }

    public BigDecimal getCommittedValue() {
        return (BigDecimal) get(PROPERTY_COMMITTEDVALUE);
    }

    public void setCommittedValue(BigDecimal committedValue) {
        set(PROPERTY_COMMITTEDVALUE, committedValue);
    }

    public BigDecimal getExecutedValue() {
        return (BigDecimal) get(PROPERTY_EXECUTEDVALUE);
    }

    public void setExecutedValue(BigDecimal executedValue) {
        set(PROPERTY_EXECUTEDVALUE, executedValue);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public SFBBudgetCertificate getSFBBudgetCertificate() {
        return (SFBBudgetCertificate) get(PROPERTY_SFBBUDGETCERTIFICATE);
    }

    public void setSFBBudgetCertificate(SFBBudgetCertificate sFBBudgetCertificate) {
        set(PROPERTY_SFBBUDGETCERTIFICATE, sFBBudgetCertificate);
    }

    public BigDecimal getCertifiedValue() {
        return (BigDecimal) get(PROPERTY_CERTIFIEDVALUE);
    }

    public void setCertifiedValue(BigDecimal certifiedValue) {
        set(PROPERTY_CERTIFIEDVALUE, certifiedValue);
    }

    public Long getLineNo() {
        return (Long) get(PROPERTY_LINENO);
    }

    public void setLineNo(Long lineNo) {
        set(PROPERTY_LINENO, lineNo);
    }

    public BigDecimal getBudgetCertifiedValue() {
        return (BigDecimal) get(PROPERTY_BUDGETCERTIFIEDVALUE);
    }

    public void setBudgetCertifiedValue(BigDecimal budgetCertifiedValue) {
        set(PROPERTY_BUDGETCERTIFIEDVALUE, budgetCertifiedValue);
    }

    public BigDecimal getBudgetCommittedValue() {
        return (BigDecimal) get(PROPERTY_BUDGETCOMMITTEDVALUE);
    }

    public void setBudgetCommittedValue(BigDecimal budgetCommittedValue) {
        set(PROPERTY_BUDGETCOMMITTEDVALUE, budgetCommittedValue);
    }

    public BigDecimal getBudgetExecutedValue() {
        return (BigDecimal) get(PROPERTY_BUDGETEXECUTEDVALUE);
    }

    public void setBudgetExecutedValue(BigDecimal budgetExecutedValue) {
        set(PROPERTY_BUDGETEXECUTEDVALUE, budgetExecutedValue);
    }

    public BigDecimal getActualValue() {
        return (BigDecimal) get(PROPERTY_ACTUALVALUE);
    }

    public void setActualValue(BigDecimal actualValue) {
        set(PROPERTY_ACTUALVALUE, actualValue);
    }

    public BigDecimal getAvailableBalance() {
        return (BigDecimal) get(PROPERTY_AVAILABLEBALANCE);
    }

    public void setAvailableBalance(BigDecimal availableBalance) {
        set(PROPERTY_AVAILABLEBALANCE, availableBalance);
    }

    public BigDecimal getBudgetAvailableBalance() {
        return (BigDecimal) get(PROPERTY_BUDGETAVAILABLEBALANCE);
    }

    public void setBudgetAvailableBalance(BigDecimal budgetAvailableBalance) {
        set(PROPERTY_BUDGETAVAILABLEBALANCE, budgetAvailableBalance);
    }

    public BigDecimal getBudgetActualValue() {
        return (BigDecimal) get(PROPERTY_BUDGETACTUALVALUE);
    }

    public void setBudgetActualValue(BigDecimal budgetActualValue) {
        set(PROPERTY_BUDGETACTUALVALUE, budgetActualValue);
    }

    public UserDimension1 getStDimension() {
        return (UserDimension1) get(PROPERTY_STDIMENSION);
    }

    public void setStDimension(UserDimension1 stDimension) {
        set(PROPERTY_STDIMENSION, stDimension);
    }

    public Concept getSsbpSsprConcept() {
        return (Concept) get(PROPERTY_SSBPSSPRCONCEPT);
    }

    public void setSsbpSsprConcept(Concept ssbpSsprConcept) {
        set(PROPERTY_SSBPSSPRCONCEPT, ssbpSsprConcept);
    }

    public ssprcategoryacct getSsbpSsprCategoryAcct() {
        return (ssprcategoryacct) get(PROPERTY_SSBPSSPRCATEGORYACCT);
    }

    public void setSsbpSsprCategoryAcct(ssprcategoryacct ssbpSsprCategoryAcct) {
        set(PROPERTY_SSBPSSPRCATEGORYACCT, ssbpSsprCategoryAcct);
    }

    public Asset getAsset() {
        return (Asset) get(PROPERTY_ASSET);
    }

    public void setAsset(Asset asset) {
        set(PROPERTY_ASSET, asset);
    }

    public AssetGroup getAssetCategory() {
        return (AssetGroup) get(PROPERTY_ASSETCATEGORY);
    }

    public void setAssetCategory(AssetGroup assetCategory) {
        set(PROPERTY_ASSETCATEGORY, assetCategory);
    }

    public BigDecimal getPaidoutValue() {
        return (BigDecimal) get(PROPERTY_PAIDOUTVALUE);
    }

    public void setPaidoutValue(BigDecimal paidoutValue) {
        set(PROPERTY_PAIDOUTVALUE, paidoutValue);
    }

    public BigDecimal getPaidoutValueCurrency() {
        return (BigDecimal) get(PROPERTY_PAIDOUTVALUECURRENCY);
    }

    public void setPaidoutValueCurrency(BigDecimal paidoutValueCurrency) {
        set(PROPERTY_PAIDOUTVALUECURRENCY, paidoutValueCurrency);
    }

    public SFBBudgetArea getSsbpSfbBudgetArea() {
        return (SFBBudgetArea) get(PROPERTY_SSBPSFBBUDGETAREA);
    }

    public void setSsbpSfbBudgetArea(SFBBudgetArea ssbpSfbBudgetArea) {
        set(PROPERTY_SSBPSFBBUDGETAREA, ssbpSfbBudgetArea);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_PaymentDetail> getFINPaymentDetailEMSFBCertificateLineList() {
      return (List<FIN_PaymentDetail>) get(PROPERTY_FINPAYMENTDETAILEMSFBCERTIFICATELINELIST);
    }

    public void setFINPaymentDetailEMSFBCertificateLineList(List<FIN_PaymentDetail> fINPaymentDetailEMSFBCertificateLineList) {
        set(PROPERTY_FINPAYMENTDETAILEMSFBCERTIFICATELINELIST, fINPaymentDetailEMSFBCertificateLineList);
    }

    @SuppressWarnings("unchecked")
    public List<GLJournalLine> getFinancialMgmtGLJournalLineEMSFBCertificateLineList() {
      return (List<GLJournalLine>) get(PROPERTY_FINANCIALMGMTGLJOURNALLINEEMSFBCERTIFICATELINELIST);
    }

    public void setFinancialMgmtGLJournalLineEMSFBCertificateLineList(List<GLJournalLine> financialMgmtGLJournalLineEMSFBCertificateLineList) {
        set(PROPERTY_FINANCIALMGMTGLJOURNALLINEEMSFBCERTIFICATELINELIST, financialMgmtGLJournalLineEMSFBCertificateLineList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceLine> getInvoiceLineEMSfbBudgetCertLineList() {
      return (List<InvoiceLine>) get(PROPERTY_INVOICELINEEMSFBBUDGETCERTLINELIST);
    }

    public void setInvoiceLineEMSfbBudgetCertLineList(List<InvoiceLine> invoiceLineEMSfbBudgetCertLineList) {
        set(PROPERTY_INVOICELINEEMSFBBUDGETCERTLINELIST, invoiceLineEMSfbBudgetCertLineList);
    }

    @SuppressWarnings("unchecked")
    public List<OrderLine> getOrderLineEMSFBBudgetCertLineList() {
      return (List<OrderLine>) get(PROPERTY_ORDERLINEEMSFBBUDGETCERTLINELIST);
    }

    public void setOrderLineEMSFBBudgetCertLineList(List<OrderLine> orderLineEMSFBBudgetCertLineList) {
        set(PROPERTY_ORDERLINEEMSFBBUDGETCERTLINELIST, orderLineEMSFBBudgetCertLineList);
    }

    @SuppressWarnings("unchecked")
    public List<SCBDBudgetDirect> getSCBDBudgetDirectList() {
      return (List<SCBDBudgetDirect>) get(PROPERTY_SCBDBUDGETDIRECTLIST);
    }

    public void setSCBDBudgetDirectList(List<SCBDBudgetDirect> sCBDBudgetDirectList) {
        set(PROPERTY_SCBDBUDGETDIRECTLIST, sCBDBudgetDirectList);
    }

    @SuppressWarnings("unchecked")
    public List<SSACCTJournalLine> getSSACCTJournalLineList() {
      return (List<SSACCTJournalLine>) get(PROPERTY_SSACCTJOURNALLINELIST);
    }

    public void setSSACCTJournalLineList(List<SSACCTJournalLine> sSACCTJournalLineList) {
        set(PROPERTY_SSACCTJOURNALLINELIST, sSACCTJournalLineList);
    }

    @SuppressWarnings("unchecked")
    public List<SSRFCBalancecontrol> getSSRFCBalancecontrolList() {
      return (List<SSRFCBalancecontrol>) get(PROPERTY_SSRFCBALANCECONTROLLIST);
    }

    public void setSSRFCBalancecontrolList(List<SSRFCBalancecontrol> sSRFCBalancecontrolList) {
        set(PROPERTY_SSRFCBALANCECONTROLLIST, sSRFCBalancecontrolList);
    }

    @SuppressWarnings("unchecked")
    public List<SSVEViatSettlTransp> getSSVEViatSettlTranspList() {
      return (List<SSVEViatSettlTransp>) get(PROPERTY_SSVEVIATSETTLTRANSPLIST);
    }

    public void setSSVEViatSettlTranspList(List<SSVEViatSettlTransp> sSVEViatSettlTranspList) {
        set(PROPERTY_SSVEVIATSETTLTRANSPLIST, sSVEViatSettlTranspList);
    }

    @SuppressWarnings("unchecked")
    public List<SSVEViatSettlementLine> getSSVEViatSettlementLineList() {
      return (List<SSVEViatSettlementLine>) get(PROPERTY_SSVEVIATSETTLEMENTLINELIST);
    }

    public void setSSVEViatSettlementLineList(List<SSVEViatSettlementLine> sSVEViatSettlementLineList) {
        set(PROPERTY_SSVEVIATSETTLEMENTLINELIST, sSVEViatSettlementLineList);
    }

    @SuppressWarnings("unchecked")
    public List<SSVEViatical> getSSVEViaticalList() {
      return (List<SSVEViatical>) get(PROPERTY_SSVEVIATICALLIST);
    }

    public void setSSVEViaticalList(List<SSVEViatical> sSVEViaticalList) {
        set(PROPERTY_SSVEVIATICALLIST, sSVEViaticalList);
    }

    @SuppressWarnings("unchecked")
    public List<SSVEViaticalLine> getSSVEViaticalLineList() {
      return (List<SSVEViaticalLine>) get(PROPERTY_SSVEVIATICALLINELIST);
    }

    public void setSSVEViaticalLineList(List<SSVEViaticalLine> sSVEViaticalLineList) {
        set(PROPERTY_SSVEVIATICALLINELIST, sSVEViaticalLineList);
    }

    @SuppressWarnings("unchecked")
    public List<SSVEViaticalSettlement> getSSVEViaticalSettlementList() {
      return (List<SSVEViaticalSettlement>) get(PROPERTY_SSVEVIATICALSETTLEMENTLIST);
    }

    public void setSSVEViaticalSettlementList(List<SSVEViaticalSettlement> sSVEViaticalSettlementList) {
        set(PROPERTY_SSVEVIATICALSETTLEMENTLIST, sSVEViaticalSettlementList);
    }

    @SuppressWarnings("unchecked")
    public List<SSVEViaticalTransp> getSSVEViaticalTranspList() {
      return (List<SSVEViaticalTransp>) get(PROPERTY_SSVEVIATICALTRANSPLIST);
    }

    public void setSSVEViaticalTranspList(List<SSVEViaticalTransp> sSVEViaticalTranspList) {
        set(PROPERTY_SSVEVIATICALTRANSPLIST, sSVEViaticalTranspList);
    }

    @SuppressWarnings("unchecked")
    public List<SFBBudgetCertLineDet> getSfbBudgetCertLineDetVEMSfbBudgetCertLineIDList() {
      return (List<SFBBudgetCertLineDet>) get(PROPERTY_SFBBUDGETCERTLINEDETVEMSFBBUDGETCERTLINEIDLIST);
    }

    public void setSfbBudgetCertLineDetVEMSfbBudgetCertLineIDList(List<SFBBudgetCertLineDet> sfbBudgetCertLineDetVEMSfbBudgetCertLineIDList) {
        set(PROPERTY_SFBBUDGETCERTLINEDETVEMSFBBUDGETCERTLINEIDLIST, sfbBudgetCertLineDetVEMSfbBudgetCertLineIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SfbBudgetJournalineDetV> getSfbBudgetJournalineDetVList() {
      return (List<SfbBudgetJournalineDetV>) get(PROPERTY_SFBBUDGETJOURNALINEDETVLIST);
    }

    public void setSfbBudgetJournalineDetVList(List<SfbBudgetJournalineDetV> sfbBudgetJournalineDetVList) {
        set(PROPERTY_SFBBUDGETJOURNALINEDETVLIST, sfbBudgetJournalineDetVList);
    }

    @SuppressWarnings("unchecked")
    public List<SFBBudgetLineDetail> getSfbBudgetLineDetailVList() {
      return (List<SFBBudgetLineDetail>) get(PROPERTY_SFBBUDGETLINEDETAILVLIST);
    }

    public void setSfbBudgetLineDetailVList(List<SFBBudgetLineDetail> sfbBudgetLineDetailVList) {
        set(PROPERTY_SFBBUDGETLINEDETAILVLIST, sfbBudgetLineDetailVList);
    }

    @SuppressWarnings("unchecked")
    public List<sfbbudgetpaymentdetv> getSfbBudgetPaymentDetVList() {
      return (List<sfbbudgetpaymentdetv>) get(PROPERTY_SFBBUDGETPAYMENTDETVLIST);
    }

    public void setSfbBudgetPaymentDetVList(List<sfbbudgetpaymentdetv> sfbBudgetPaymentDetVList) {
        set(PROPERTY_SFBBUDGETPAYMENTDETVLIST, sfbBudgetPaymentDetVList);
    }

    @SuppressWarnings("unchecked")
    public List<ssve_viatical_details_v> getSsveViaticalDetailsVList() {
      return (List<ssve_viatical_details_v>) get(PROPERTY_SSVEVIATICALDETAILSVLIST);
    }

    public void setSsveViaticalDetailsVList(List<ssve_viatical_details_v> ssveViaticalDetailsVList) {
        set(PROPERTY_SSVEVIATICALDETAILSVLIST, ssveViaticalDetailsVList);
    }

}
