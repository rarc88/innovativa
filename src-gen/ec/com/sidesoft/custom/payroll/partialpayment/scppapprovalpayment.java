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
package ec.com.sidesoft.custom.payroll.partialpayment;

import com.sidesoft.hrm.payroll.Payroll;
import com.sidesoft.hrm.payroll.tenth.SSPHTenthSettlement;

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
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.calendar.Period;
/**
 * Entity class for entity scpp_approvalpayment (stored in table scpp_approvalpayment).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class scppapprovalpayment extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "scpp_approvalpayment";
    public static final String ENTITY_NAME = "scpp_approvalpayment";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DOCUMENTTYPE = "documentType";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_PAYROLL = "payroll";
    public static final String PROPERTY_PERIOD = "period";
    public static final String PROPERTY_DATEAPPROVAL = "dateApproval";
    public static final String PROPERTY_DATEPAYMENT = "datePayment";
    public static final String PROPERTY_STATUS = "status";
    public static final String PROPERTY_INCLUDEPARTNERS = "includePartners";
    public static final String PROPERTY_REACTIVE = "reactive";
    public static final String PROPERTY_APPROVE = "approve";
    public static final String PROPERTY_GENERATEFILE = "generateFile";
    public static final String PROPERTY_CONFIRMPAYMET = "confirmPaymet";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_TYPEOFINCOME = "typeOfIncome";
    public static final String PROPERTY_OUTPUTFILETYPE = "outputFileType";
    public static final String PROPERTY_CONCEPT = "concept";
    public static final String PROPERTY_PROCESS = "process";
    public static final String PROPERTY_SSPHTENTHSETTLEMENT = "ssphTenthSettlement";
    public static final String PROPERTY_SCPPAPPROVALPAYMENTLINELIST = "scppApprovalpaymentlineList";
    public static final String PROPERTY_SCPPPAYMENTDETAILVLIST = "scppPaymentDetailVList";

    public scppapprovalpayment() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_STATUS, "DR");
        setDefaultValue(PROPERTY_INCLUDEPARTNERS, false);
        setDefaultValue(PROPERTY_REACTIVE, false);
        setDefaultValue(PROPERTY_APPROVE, false);
        setDefaultValue(PROPERTY_GENERATEFILE, false);
        setDefaultValue(PROPERTY_CONFIRMPAYMET, false);
        setDefaultValue(PROPERTY_SCPPAPPROVALPAYMENTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCPPPAYMENTDETAILVLIST, new ArrayList<Object>());
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

    public DocumentType getDocumentType() {
        return (DocumentType) get(PROPERTY_DOCUMENTTYPE);
    }

    public void setDocumentType(DocumentType documentType) {
        set(PROPERTY_DOCUMENTTYPE, documentType);
    }

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

    public Payroll getPayroll() {
        return (Payroll) get(PROPERTY_PAYROLL);
    }

    public void setPayroll(Payroll payroll) {
        set(PROPERTY_PAYROLL, payroll);
    }

    public Period getPeriod() {
        return (Period) get(PROPERTY_PERIOD);
    }

    public void setPeriod(Period period) {
        set(PROPERTY_PERIOD, period);
    }

    public Date getDateApproval() {
        return (Date) get(PROPERTY_DATEAPPROVAL);
    }

    public void setDateApproval(Date dateApproval) {
        set(PROPERTY_DATEAPPROVAL, dateApproval);
    }

    public Date getDatePayment() {
        return (Date) get(PROPERTY_DATEPAYMENT);
    }

    public void setDatePayment(Date datePayment) {
        set(PROPERTY_DATEPAYMENT, datePayment);
    }

    public String getStatus() {
        return (String) get(PROPERTY_STATUS);
    }

    public void setStatus(String status) {
        set(PROPERTY_STATUS, status);
    }

    public Boolean isIncludePartners() {
        return (Boolean) get(PROPERTY_INCLUDEPARTNERS);
    }

    public void setIncludePartners(Boolean includePartners) {
        set(PROPERTY_INCLUDEPARTNERS, includePartners);
    }

    public Boolean isReactive() {
        return (Boolean) get(PROPERTY_REACTIVE);
    }

    public void setReactive(Boolean reactive) {
        set(PROPERTY_REACTIVE, reactive);
    }

    public Boolean isApprove() {
        return (Boolean) get(PROPERTY_APPROVE);
    }

    public void setApprove(Boolean approve) {
        set(PROPERTY_APPROVE, approve);
    }

    public Boolean isGenerateFile() {
        return (Boolean) get(PROPERTY_GENERATEFILE);
    }

    public void setGenerateFile(Boolean generateFile) {
        set(PROPERTY_GENERATEFILE, generateFile);
    }

    public Boolean isConfirmPaymet() {
        return (Boolean) get(PROPERTY_CONFIRMPAYMET);
    }

    public void setConfirmPaymet(Boolean confirmPaymet) {
        set(PROPERTY_CONFIRMPAYMET, confirmPaymet);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public String getTypeOfIncome() {
        return (String) get(PROPERTY_TYPEOFINCOME);
    }

    public void setTypeOfIncome(String typeOfIncome) {
        set(PROPERTY_TYPEOFINCOME, typeOfIncome);
    }

    public String getOutputFileType() {
        return (String) get(PROPERTY_OUTPUTFILETYPE);
    }

    public void setOutputFileType(String outputFileType) {
        set(PROPERTY_OUTPUTFILETYPE, outputFileType);
    }

    public ScppCconcept getConcept() {
        return (ScppCconcept) get(PROPERTY_CONCEPT);
    }

    public void setConcept(ScppCconcept concept) {
        set(PROPERTY_CONCEPT, concept);
    }

    public String getProcess() {
        return (String) get(PROPERTY_PROCESS);
    }

    public void setProcess(String process) {
        set(PROPERTY_PROCESS, process);
    }

    public SSPHTenthSettlement getSsphTenthSettlement() {
        return (SSPHTenthSettlement) get(PROPERTY_SSPHTENTHSETTLEMENT);
    }

    public void setSsphTenthSettlement(SSPHTenthSettlement ssphTenthSettlement) {
        set(PROPERTY_SSPHTENTHSETTLEMENT, ssphTenthSettlement);
    }

    @SuppressWarnings("unchecked")
    public List<scppapprovalpaymentline> getScppApprovalpaymentlineList() {
      return (List<scppapprovalpaymentline>) get(PROPERTY_SCPPAPPROVALPAYMENTLINELIST);
    }

    public void setScppApprovalpaymentlineList(List<scppapprovalpaymentline> scppApprovalpaymentlineList) {
        set(PROPERTY_SCPPAPPROVALPAYMENTLINELIST, scppApprovalpaymentlineList);
    }

    @SuppressWarnings("unchecked")
    public List<scpppaymentdetailv> getScppPaymentDetailVList() {
      return (List<scpppaymentdetailv>) get(PROPERTY_SCPPPAYMENTDETAILVLIST);
    }

    public void setScppPaymentDetailVList(List<scpppaymentdetailv> scppPaymentDetailVList) {
        set(PROPERTY_SCPPPAYMENTDETAILVLIST, scppPaymentDetailVList);
    }

}
