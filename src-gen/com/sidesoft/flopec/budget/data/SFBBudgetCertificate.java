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

import com.sidesoft.hrm.payroll.Payroll;
import com.sidesoft.hrm.payroll.sspr_settlement;

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
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.assetmgmt.Amortization;
import org.openbravo.model.financialmgmt.calendar.Period;
import org.openbravo.model.financialmgmt.calendar.Year;
/**
 * Entity class for entity sfb_budget_certificate (stored in table sfb_budget_certificate).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SFBBudgetCertificate extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sfb_budget_certificate";
    public static final String ENTITY_NAME = "sfb_budget_certificate";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_TYPEOFBUDGET = "typeOfBudget";
    public static final String PROPERTY_YEAR = "year";
    public static final String PROPERTY_DATEISSUE = "dateIssue";
    public static final String PROPERTY_HASHCODE = "hashCode";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_USERCONTACT = "userContact";
    public static final String PROPERTY_DOCUMENTTYPE = "documentType";
    public static final String PROPERTY_CERTIFICATESTATUS = "certificateStatus";
    public static final String PROPERTY_PROCESS = "process";
    public static final String PROPERTY_REQUEST = "request";
    public static final String PROPERTY_AREA = "area";
    public static final String PROPERTY_CLOSECERT = "closecert";
    public static final String PROPERTY_CERTIFIEDVALUE = "certifiedValue";
    public static final String PROPERTY_COMMITTEDVALUE = "committedValue";
    public static final String PROPERTY_EXECUTEDVALUE = "executedValue";
    public static final String PROPERTY_TYPEOFCERTIFICATE = "typeOfCertificate";
    public static final String PROPERTY_SSBPSSPRPAYROLL = "ssbpSsprPayroll";
    public static final String PROPERTY_SSBPCPERIOD = "ssbpCPeriod";
    public static final String PROPERTY_SSBPLOADPAYROLL = "ssbpLoadpayroll";
    public static final String PROPERTY_POSTED = "posted";
    public static final String PROPERTY_PROCESSNOW = "processNow";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_AMORTIZATION = "amortization";
    public static final String PROPERTY_LOADAMORTIZATION = "loadAmortization";
    public static final String PROPERTY_SSBPPAYROLLTYPE = "ssbpPayrolltype";
    public static final String PROPERTY_PROCESSEXECUTED = "processExecuted";
    public static final String PROPERTY_SSBPSSPRSETTLEMENT = "ssbpSsprSettlement";
    public static final String PROPERTY_REVIEW = "review";
    public static final String PROPERTY_SFBBUDGETCERTLINELIST = "sfbBudgetCertLineList";
    public static final String PROPERTY_SFBBUDGETLINEDETAILVLIST = "sfbBudgetLineDetailVList";
    public static final String PROPERTY_SSBPNOBUDGETCERTLINELIST = "ssbpNoBudgetCertLineList";

    public SFBBudgetCertificate() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_TYPEOFBUDGET, "O");
        setDefaultValue(PROPERTY_CERTIFICATESTATUS, "DR");
        setDefaultValue(PROPERTY_PROCESS, "N");
        setDefaultValue(PROPERTY_REQUEST, "N");
        setDefaultValue(PROPERTY_CLOSECERT, "N");
        setDefaultValue(PROPERTY_CERTIFIEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_COMMITTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_EXECUTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_SSBPLOADPAYROLL, "N");
        setDefaultValue(PROPERTY_POSTED, "N");
        setDefaultValue(PROPERTY_PROCESSNOW, false);
        setDefaultValue(PROPERTY_PROCESSED, false);
        setDefaultValue(PROPERTY_LOADAMORTIZATION, "N");
        setDefaultValue(PROPERTY_SSBPPAYROLLTYPE, false);
        setDefaultValue(PROPERTY_PROCESSEXECUTED, "N");
        setDefaultValue(PROPERTY_REVIEW, "N");
        setDefaultValue(PROPERTY_SFBBUDGETCERTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETLINEDETAILVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSBPNOBUDGETCERTLINELIST, new ArrayList<Object>());
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

    public String getTypeOfBudget() {
        return (String) get(PROPERTY_TYPEOFBUDGET);
    }

    public void setTypeOfBudget(String typeOfBudget) {
        set(PROPERTY_TYPEOFBUDGET, typeOfBudget);
    }

    public Year getYear() {
        return (Year) get(PROPERTY_YEAR);
    }

    public void setYear(Year year) {
        set(PROPERTY_YEAR, year);
    }

    public Date getDateIssue() {
        return (Date) get(PROPERTY_DATEISSUE);
    }

    public void setDateIssue(Date dateIssue) {
        set(PROPERTY_DATEISSUE, dateIssue);
    }

    public String getHashCode() {
        return (String) get(PROPERTY_HASHCODE);
    }

    public void setHashCode(String hashCode) {
        set(PROPERTY_HASHCODE, hashCode);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public User getUserContact() {
        return (User) get(PROPERTY_USERCONTACT);
    }

    public void setUserContact(User userContact) {
        set(PROPERTY_USERCONTACT, userContact);
    }

    public DocumentType getDocumentType() {
        return (DocumentType) get(PROPERTY_DOCUMENTTYPE);
    }

    public void setDocumentType(DocumentType documentType) {
        set(PROPERTY_DOCUMENTTYPE, documentType);
    }

    public String getCertificateStatus() {
        return (String) get(PROPERTY_CERTIFICATESTATUS);
    }

    public void setCertificateStatus(String certificateStatus) {
        set(PROPERTY_CERTIFICATESTATUS, certificateStatus);
    }

    public String getProcess() {
        return (String) get(PROPERTY_PROCESS);
    }

    public void setProcess(String process) {
        set(PROPERTY_PROCESS, process);
    }

    public String getRequest() {
        return (String) get(PROPERTY_REQUEST);
    }

    public void setRequest(String request) {
        set(PROPERTY_REQUEST, request);
    }

    public SFBBudgetArea getArea() {
        return (SFBBudgetArea) get(PROPERTY_AREA);
    }

    public void setArea(SFBBudgetArea area) {
        set(PROPERTY_AREA, area);
    }

    public String getClosecert() {
        return (String) get(PROPERTY_CLOSECERT);
    }

    public void setClosecert(String closecert) {
        set(PROPERTY_CLOSECERT, closecert);
    }

    public BigDecimal getCertifiedValue() {
        return (BigDecimal) get(PROPERTY_CERTIFIEDVALUE);
    }

    public void setCertifiedValue(BigDecimal certifiedValue) {
        set(PROPERTY_CERTIFIEDVALUE, certifiedValue);
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

    public String getTypeOfCertificate() {
        return (String) get(PROPERTY_TYPEOFCERTIFICATE);
    }

    public void setTypeOfCertificate(String typeOfCertificate) {
        set(PROPERTY_TYPEOFCERTIFICATE, typeOfCertificate);
    }

    public Payroll getSsbpSsprPayroll() {
        return (Payroll) get(PROPERTY_SSBPSSPRPAYROLL);
    }

    public void setSsbpSsprPayroll(Payroll ssbpSsprPayroll) {
        set(PROPERTY_SSBPSSPRPAYROLL, ssbpSsprPayroll);
    }

    public Period getSsbpCPeriod() {
        return (Period) get(PROPERTY_SSBPCPERIOD);
    }

    public void setSsbpCPeriod(Period ssbpCPeriod) {
        set(PROPERTY_SSBPCPERIOD, ssbpCPeriod);
    }

    public String getSsbpLoadpayroll() {
        return (String) get(PROPERTY_SSBPLOADPAYROLL);
    }

    public void setSsbpLoadpayroll(String ssbpLoadpayroll) {
        set(PROPERTY_SSBPLOADPAYROLL, ssbpLoadpayroll);
    }

    public String getPosted() {
        return (String) get(PROPERTY_POSTED);
    }

    public void setPosted(String posted) {
        set(PROPERTY_POSTED, posted);
    }

    public Boolean isProcessNow() {
        return (Boolean) get(PROPERTY_PROCESSNOW);
    }

    public void setProcessNow(Boolean processNow) {
        set(PROPERTY_PROCESSNOW, processNow);
    }

    public Boolean isProcessed() {
        return (Boolean) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(Boolean processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public Amortization getAmortization() {
        return (Amortization) get(PROPERTY_AMORTIZATION);
    }

    public void setAmortization(Amortization amortization) {
        set(PROPERTY_AMORTIZATION, amortization);
    }

    public String getLoadAmortization() {
        return (String) get(PROPERTY_LOADAMORTIZATION);
    }

    public void setLoadAmortization(String loadAmortization) {
        set(PROPERTY_LOADAMORTIZATION, loadAmortization);
    }

    public Boolean isSsbpPayrolltype() {
        return (Boolean) get(PROPERTY_SSBPPAYROLLTYPE);
    }

    public void setSsbpPayrolltype(Boolean ssbpPayrolltype) {
        set(PROPERTY_SSBPPAYROLLTYPE, ssbpPayrolltype);
    }

    public String getProcessExecuted() {
        return (String) get(PROPERTY_PROCESSEXECUTED);
    }

    public void setProcessExecuted(String processExecuted) {
        set(PROPERTY_PROCESSEXECUTED, processExecuted);
    }

    public sspr_settlement getSsbpSsprSettlement() {
        return (sspr_settlement) get(PROPERTY_SSBPSSPRSETTLEMENT);
    }

    public void setSsbpSsprSettlement(sspr_settlement ssbpSsprSettlement) {
        set(PROPERTY_SSBPSSPRSETTLEMENT, ssbpSsprSettlement);
    }

    public String getReview() {
        return (String) get(PROPERTY_REVIEW);
    }

    public void setReview(String review) {
        set(PROPERTY_REVIEW, review);
    }

    @SuppressWarnings("unchecked")
    public List<SFBBudgetCertLine> getSfbBudgetCertLineList() {
      return (List<SFBBudgetCertLine>) get(PROPERTY_SFBBUDGETCERTLINELIST);
    }

    public void setSfbBudgetCertLineList(List<SFBBudgetCertLine> sfbBudgetCertLineList) {
        set(PROPERTY_SFBBUDGETCERTLINELIST, sfbBudgetCertLineList);
    }

    @SuppressWarnings("unchecked")
    public List<SFBBudgetLineDetail> getSfbBudgetLineDetailVList() {
      return (List<SFBBudgetLineDetail>) get(PROPERTY_SFBBUDGETLINEDETAILVLIST);
    }

    public void setSfbBudgetLineDetailVList(List<SFBBudgetLineDetail> sfbBudgetLineDetailVList) {
        set(PROPERTY_SFBBUDGETLINEDETAILVLIST, sfbBudgetLineDetailVList);
    }

    @SuppressWarnings("unchecked")
    public List<SSBPNoBudgetCertLine> getSsbpNoBudgetCertLineList() {
      return (List<SSBPNoBudgetCertLine>) get(PROPERTY_SSBPNOBUDGETCERTLINELIST);
    }

    public void setSsbpNoBudgetCertLineList(List<SSBPNoBudgetCertLine> ssbpNoBudgetCertLineList) {
        set(PROPERTY_SSBPNOBUDGETCERTLINELIST, ssbpNoBudgetCertLineList);
    }

}
