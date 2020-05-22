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
package ec.com.sidesoft.custom.payments.partialpayment;

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
import org.openbravo.model.financialmgmt.payment.FIN_FinancialAccount;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentMethod;
/**
 * Entity class for entity SSPP_PAYMENTS (stored in table SSPP_PAYMENTS).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SSPPPAYMENTS extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "SSPP_PAYMENTS";
    public static final String ENTITY_NAME = "SSPP_PAYMENTS";
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
    public static final String PROPERTY_DOCTYPEPAYMENT = "doctypePayment";
    public static final String PROPERTY_DOCUMENTNOFROM = "documentnofrom";
    public static final String PROPERTY_DOCUMENTNOTO = "documentnoto";
    public static final String PROPERTY_FINANCIALACCOUNT = "financialAccount";
    public static final String PROPERTY_PAYMENTMETHOD = "paymentMethod";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_STARTINGDATE = "startingDate";
    public static final String PROPERTY_ENDINGDATE = "endingDate";
    public static final String PROPERTY_APPROVALDATE = "approvaldate";
    public static final String PROPERTY_ALERTSTATUS = "alertStatus";
    public static final String PROPERTY_LOADLINE = "loadLine";
    public static final String PROPERTY_PAYMENTAPPROVAL = "paymentApproval";
    public static final String PROPERTY_REACTIVATEPAYMENT = "reactivatePayment";
    public static final String PROPERTY_GENERATEFILE = "generateFile";
    public static final String PROPERTY_CONFIRM = "confirm";
    public static final String PROPERTY_SSPPRREFERENCENO = "sspprReferenceno";
    public static final String PROPERTY_PAYTO = "pAYTo";
    public static final String PROPERTY_SSPPPARTIALPAYINFOCONCEPT = "ssppPartialpayInfoconcept";
    public static final String PROPERTY_DESCRIPTIONPAY = "descriptionPay";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_CONFIRMTRANSFER = "confirmTransfer";
    public static final String PROPERTY_SSPPPAYMENTSLINELIST = "sSPPPAYMENTSLINEList";

    public SSPPPAYMENTS() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_CREATIONDATE, new Date());
        setDefaultValue(PROPERTY_UPDATED, new Date());
        setDefaultValue(PROPERTY_ALERTSTATUS, "DR");
        setDefaultValue(PROPERTY_LOADLINE, false);
        setDefaultValue(PROPERTY_PAYMENTAPPROVAL, false);
        setDefaultValue(PROPERTY_REACTIVATEPAYMENT, false);
        setDefaultValue(PROPERTY_GENERATEFILE, false);
        setDefaultValue(PROPERTY_CONFIRM, "CT");
        setDefaultValue(PROPERTY_PAYTO, "OT");
        setDefaultValue(PROPERTY_CONFIRMTRANSFER, "CT");
        setDefaultValue(PROPERTY_SSPPPAYMENTSLINELIST, new ArrayList<Object>());
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

    public DocumentType getDoctypePayment() {
        return (DocumentType) get(PROPERTY_DOCTYPEPAYMENT);
    }

    public void setDoctypePayment(DocumentType doctypePayment) {
        set(PROPERTY_DOCTYPEPAYMENT, doctypePayment);
    }

    public String getDocumentnofrom() {
        return (String) get(PROPERTY_DOCUMENTNOFROM);
    }

    public void setDocumentnofrom(String documentnofrom) {
        set(PROPERTY_DOCUMENTNOFROM, documentnofrom);
    }

    public String getDocumentnoto() {
        return (String) get(PROPERTY_DOCUMENTNOTO);
    }

    public void setDocumentnoto(String documentnoto) {
        set(PROPERTY_DOCUMENTNOTO, documentnoto);
    }

    public FIN_FinancialAccount getFinancialAccount() {
        return (FIN_FinancialAccount) get(PROPERTY_FINANCIALACCOUNT);
    }

    public void setFinancialAccount(FIN_FinancialAccount financialAccount) {
        set(PROPERTY_FINANCIALACCOUNT, financialAccount);
    }

    public FIN_PaymentMethod getPaymentMethod() {
        return (FIN_PaymentMethod) get(PROPERTY_PAYMENTMETHOD);
    }

    public void setPaymentMethod(FIN_PaymentMethod paymentMethod) {
        set(PROPERTY_PAYMENTMETHOD, paymentMethod);
    }

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
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

    public Date getApprovaldate() {
        return (Date) get(PROPERTY_APPROVALDATE);
    }

    public void setApprovaldate(Date approvaldate) {
        set(PROPERTY_APPROVALDATE, approvaldate);
    }

    public String getAlertStatus() {
        return (String) get(PROPERTY_ALERTSTATUS);
    }

    public void setAlertStatus(String alertStatus) {
        set(PROPERTY_ALERTSTATUS, alertStatus);
    }

    public Boolean isLoadLine() {
        return (Boolean) get(PROPERTY_LOADLINE);
    }

    public void setLoadLine(Boolean loadLine) {
        set(PROPERTY_LOADLINE, loadLine);
    }

    public Boolean isPaymentApproval() {
        return (Boolean) get(PROPERTY_PAYMENTAPPROVAL);
    }

    public void setPaymentApproval(Boolean paymentApproval) {
        set(PROPERTY_PAYMENTAPPROVAL, paymentApproval);
    }

    public Boolean isReactivatePayment() {
        return (Boolean) get(PROPERTY_REACTIVATEPAYMENT);
    }

    public void setReactivatePayment(Boolean reactivatePayment) {
        set(PROPERTY_REACTIVATEPAYMENT, reactivatePayment);
    }

    public Boolean isGenerateFile() {
        return (Boolean) get(PROPERTY_GENERATEFILE);
    }

    public void setGenerateFile(Boolean generateFile) {
        set(PROPERTY_GENERATEFILE, generateFile);
    }

    public String getConfirm() {
        return (String) get(PROPERTY_CONFIRM);
    }

    public void setConfirm(String confirm) {
        set(PROPERTY_CONFIRM, confirm);
    }

    public String getSspprReferenceno() {
        return (String) get(PROPERTY_SSPPRREFERENCENO);
    }

    public void setSspprReferenceno(String sspprReferenceno) {
        set(PROPERTY_SSPPRREFERENCENO, sspprReferenceno);
    }

    public String getPAYTo() {
        return (String) get(PROPERTY_PAYTO);
    }

    public void setPAYTo(String pAYTo) {
        set(PROPERTY_PAYTO, pAYTo);
    }

    public SsppPartialPaymentInfoConcept getSsppPartialpayInfoconcept() {
        return (SsppPartialPaymentInfoConcept) get(PROPERTY_SSPPPARTIALPAYINFOCONCEPT);
    }

    public void setSsppPartialpayInfoconcept(SsppPartialPaymentInfoConcept ssppPartialpayInfoconcept) {
        set(PROPERTY_SSPPPARTIALPAYINFOCONCEPT, ssppPartialpayInfoconcept);
    }

    public String getDescriptionPay() {
        return (String) get(PROPERTY_DESCRIPTIONPAY);
    }

    public void setDescriptionPay(String descriptionPay) {
        set(PROPERTY_DESCRIPTIONPAY, descriptionPay);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public String getConfirmTransfer() {
        return (String) get(PROPERTY_CONFIRMTRANSFER);
    }

    public void setConfirmTransfer(String confirmTransfer) {
        set(PROPERTY_CONFIRMTRANSFER, confirmTransfer);
    }

    @SuppressWarnings("unchecked")
    public List<SSPPPAYMENTSLINE> getSSPPPAYMENTSLINEList() {
      return (List<SSPPPAYMENTSLINE>) get(PROPERTY_SSPPPAYMENTSLINELIST);
    }

    public void setSSPPPAYMENTSLINEList(List<SSPPPAYMENTSLINE> sSPPPAYMENTSLINEList) {
        set(PROPERTY_SSPPPAYMENTSLINELIST, sSPPPAYMENTSLINEList);
    }

}
