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

import com.sidesoft.flopec.budget.data.SFBBudgetCertificate;

import ec.com.sidesoft.custom.payroll.partialpayment.scppapprovalpayment;
import ec.com.sidesoft.custom.payroll.partialpayment.scpppaymentdetailv;

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
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.calendar.Period;
import org.openbravo.model.financialmgmt.gl.GLBatch;
/**
 * Entity class for entity SSPR_Payroll (stored in table SSPR_Payroll).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Payroll extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "SSPR_Payroll";
    public static final String ENTITY_NAME = "SSPR_Payroll";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_DOCUMENTDATE = "documentDate";
    public static final String PROPERTY_PERIOD = "period";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_PAYROLL = "payroll";
    public static final String PROPERTY_GENERATEACCOUNTING = "generateAccounting";
    public static final String PROPERTY_LIQUIDATION = "liquidation";
    public static final String PROPERTY_EMPLOYEE = "employee";
    public static final String PROPERTY_JOURNALBATCH = "journalBatch";
    public static final String PROPERTY_COMPLETELIQUIDATION = "completeLiquidation";
    public static final String PROPERTY_AUTOMATICPROCESS = "automaticprocess";
    public static final String PROPERTY_SSPMSENDMAIL = "sspmSendmail";
    public static final String PROPERTY_POSTED = "posted";
    public static final String PROPERTY_SSPMSENTMAIL = "sspmSentmail";
    public static final String PROPERTY_PROCESSNOW = "processNow";
    public static final String PROPERTY_DOCUMENTTYPE = "documentType";
    public static final String PROPERTY_SSPRPAYROLLTICKETLIST = "sSPRPayrollTicketList";
    public static final String PROPERTY_SCPPAPPROVALPAYMENTLIST = "scppApprovalpaymentList";
    public static final String PROPERTY_SCPPPAYMENTDETAILVLIST = "scppPaymentDetailVList";
    public static final String PROPERTY_SFBBUDGETCERTIFICATEEMSSBPSSPRPAYROLLIDLIST = "sfbBudgetCertificateEMSsbpSsprPayrollIDList";
    public static final String PROPERTY_SSPRPAYROLLAUTLINELIST = "ssprPayrollAutLineList";
    public static final String PROPERTY_SSPRPAYROLLEMPLIST = "ssprPayrollEmpList";
    public static final String PROPERTY_SSPRSETTLEMENTSSPRPAYROLLIDNORMALLIST = "ssprSettlementSsprPayrollIdNormalList";
    public static final String PROPERTY_SSPRSETTLEMENTSSPRPAYROLLIDPROVISIONLIST = "ssprSettlementSsprPayrollIdProvisionList";
    public static final String PROPERTY_SSPRSETTLEMENTDATALIST = "ssprSettlementdataList";
    public static final String PROPERTY_SSPRSETTLEMENTLINELIST = "ssprSettlementlineList";

    public Payroll() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_PROCESSED, "N");
        setDefaultValue(PROPERTY_PAYROLL, false);
        setDefaultValue(PROPERTY_GENERATEACCOUNTING, false);
        setDefaultValue(PROPERTY_LIQUIDATION, false);
        setDefaultValue(PROPERTY_COMPLETELIQUIDATION, false);
        setDefaultValue(PROPERTY_AUTOMATICPROCESS, false);
        setDefaultValue(PROPERTY_SSPMSENDMAIL, false);
        setDefaultValue(PROPERTY_POSTED, "N");
        setDefaultValue(PROPERTY_SSPMSENTMAIL, false);
        setDefaultValue(PROPERTY_PROCESSNOW, false);
        setDefaultValue(PROPERTY_SSPRPAYROLLTICKETLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCPPAPPROVALPAYMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCPPPAYMENTDETAILVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETCERTIFICATEEMSSBPSSPRPAYROLLIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRPAYROLLAUTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRPAYROLLEMPLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRSETTLEMENTSSPRPAYROLLIDNORMALLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRSETTLEMENTSSPRPAYROLLIDPROVISIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRSETTLEMENTDATALIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRSETTLEMENTLINELIST, new ArrayList<Object>());
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

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

    public Date getDocumentDate() {
        return (Date) get(PROPERTY_DOCUMENTDATE);
    }

    public void setDocumentDate(Date documentDate) {
        set(PROPERTY_DOCUMENTDATE, documentDate);
    }

    public Period getPeriod() {
        return (Period) get(PROPERTY_PERIOD);
    }

    public void setPeriod(Period period) {
        set(PROPERTY_PERIOD, period);
    }

    public String getProcessed() {
        return (String) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(String processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Boolean isPayroll() {
        return (Boolean) get(PROPERTY_PAYROLL);
    }

    public void setPayroll(Boolean payroll) {
        set(PROPERTY_PAYROLL, payroll);
    }

    public Boolean isGenerateAccounting() {
        return (Boolean) get(PROPERTY_GENERATEACCOUNTING);
    }

    public void setGenerateAccounting(Boolean generateAccounting) {
        set(PROPERTY_GENERATEACCOUNTING, generateAccounting);
    }

    public Boolean isLiquidation() {
        return (Boolean) get(PROPERTY_LIQUIDATION);
    }

    public void setLiquidation(Boolean liquidation) {
        set(PROPERTY_LIQUIDATION, liquidation);
    }

    public BusinessPartner getEmployee() {
        return (BusinessPartner) get(PROPERTY_EMPLOYEE);
    }

    public void setEmployee(BusinessPartner employee) {
        set(PROPERTY_EMPLOYEE, employee);
    }

    public GLBatch getJournalBatch() {
        return (GLBatch) get(PROPERTY_JOURNALBATCH);
    }

    public void setJournalBatch(GLBatch journalBatch) {
        set(PROPERTY_JOURNALBATCH, journalBatch);
    }

    public Boolean isCompleteLiquidation() {
        return (Boolean) get(PROPERTY_COMPLETELIQUIDATION);
    }

    public void setCompleteLiquidation(Boolean completeLiquidation) {
        set(PROPERTY_COMPLETELIQUIDATION, completeLiquidation);
    }

    public Boolean isAutomaticprocess() {
        return (Boolean) get(PROPERTY_AUTOMATICPROCESS);
    }

    public void setAutomaticprocess(Boolean automaticprocess) {
        set(PROPERTY_AUTOMATICPROCESS, automaticprocess);
    }

    public Boolean isSspmSendmail() {
        return (Boolean) get(PROPERTY_SSPMSENDMAIL);
    }

    public void setSspmSendmail(Boolean sspmSendmail) {
        set(PROPERTY_SSPMSENDMAIL, sspmSendmail);
    }

    public String getPosted() {
        return (String) get(PROPERTY_POSTED);
    }

    public void setPosted(String posted) {
        set(PROPERTY_POSTED, posted);
    }

    public Boolean isSspmSentmail() {
        return (Boolean) get(PROPERTY_SSPMSENTMAIL);
    }

    public void setSspmSentmail(Boolean sspmSentmail) {
        set(PROPERTY_SSPMSENTMAIL, sspmSentmail);
    }

    public Boolean isProcessNow() {
        return (Boolean) get(PROPERTY_PROCESSNOW);
    }

    public void setProcessNow(Boolean processNow) {
        set(PROPERTY_PROCESSNOW, processNow);
    }

    public DocumentType getDocumentType() {
        return (DocumentType) get(PROPERTY_DOCUMENTTYPE);
    }

    public void setDocumentType(DocumentType documentType) {
        set(PROPERTY_DOCUMENTTYPE, documentType);
    }

    @SuppressWarnings("unchecked")
    public List<PayrollTicket> getSSPRPayrollTicketList() {
      return (List<PayrollTicket>) get(PROPERTY_SSPRPAYROLLTICKETLIST);
    }

    public void setSSPRPayrollTicketList(List<PayrollTicket> sSPRPayrollTicketList) {
        set(PROPERTY_SSPRPAYROLLTICKETLIST, sSPRPayrollTicketList);
    }

    @SuppressWarnings("unchecked")
    public List<scppapprovalpayment> getScppApprovalpaymentList() {
      return (List<scppapprovalpayment>) get(PROPERTY_SCPPAPPROVALPAYMENTLIST);
    }

    public void setScppApprovalpaymentList(List<scppapprovalpayment> scppApprovalpaymentList) {
        set(PROPERTY_SCPPAPPROVALPAYMENTLIST, scppApprovalpaymentList);
    }

    @SuppressWarnings("unchecked")
    public List<scpppaymentdetailv> getScppPaymentDetailVList() {
      return (List<scpppaymentdetailv>) get(PROPERTY_SCPPPAYMENTDETAILVLIST);
    }

    public void setScppPaymentDetailVList(List<scpppaymentdetailv> scppPaymentDetailVList) {
        set(PROPERTY_SCPPPAYMENTDETAILVLIST, scppPaymentDetailVList);
    }

    @SuppressWarnings("unchecked")
    public List<SFBBudgetCertificate> getSfbBudgetCertificateEMSsbpSsprPayrollIDList() {
      return (List<SFBBudgetCertificate>) get(PROPERTY_SFBBUDGETCERTIFICATEEMSSBPSSPRPAYROLLIDLIST);
    }

    public void setSfbBudgetCertificateEMSsbpSsprPayrollIDList(List<SFBBudgetCertificate> sfbBudgetCertificateEMSsbpSsprPayrollIDList) {
        set(PROPERTY_SFBBUDGETCERTIFICATEEMSSBPSSPRPAYROLLIDLIST, sfbBudgetCertificateEMSsbpSsprPayrollIDList);
    }

    @SuppressWarnings("unchecked")
    public List<ssprpayrollautline> getSsprPayrollAutLineList() {
      return (List<ssprpayrollautline>) get(PROPERTY_SSPRPAYROLLAUTLINELIST);
    }

    public void setSsprPayrollAutLineList(List<ssprpayrollautline> ssprPayrollAutLineList) {
        set(PROPERTY_SSPRPAYROLLAUTLINELIST, ssprPayrollAutLineList);
    }

    @SuppressWarnings("unchecked")
    public List<sspr_payrollemp> getSsprPayrollEmpList() {
      return (List<sspr_payrollemp>) get(PROPERTY_SSPRPAYROLLEMPLIST);
    }

    public void setSsprPayrollEmpList(List<sspr_payrollemp> ssprPayrollEmpList) {
        set(PROPERTY_SSPRPAYROLLEMPLIST, ssprPayrollEmpList);
    }

    @SuppressWarnings("unchecked")
    public List<sspr_settlement> getSsprSettlementSsprPayrollIdNormalList() {
      return (List<sspr_settlement>) get(PROPERTY_SSPRSETTLEMENTSSPRPAYROLLIDNORMALLIST);
    }

    public void setSsprSettlementSsprPayrollIdNormalList(List<sspr_settlement> ssprSettlementSsprPayrollIdNormalList) {
        set(PROPERTY_SSPRSETTLEMENTSSPRPAYROLLIDNORMALLIST, ssprSettlementSsprPayrollIdNormalList);
    }

    @SuppressWarnings("unchecked")
    public List<sspr_settlement> getSsprSettlementSsprPayrollIdProvisionList() {
      return (List<sspr_settlement>) get(PROPERTY_SSPRSETTLEMENTSSPRPAYROLLIDPROVISIONLIST);
    }

    public void setSsprSettlementSsprPayrollIdProvisionList(List<sspr_settlement> ssprSettlementSsprPayrollIdProvisionList) {
        set(PROPERTY_SSPRSETTLEMENTSSPRPAYROLLIDPROVISIONLIST, ssprSettlementSsprPayrollIdProvisionList);
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

}
