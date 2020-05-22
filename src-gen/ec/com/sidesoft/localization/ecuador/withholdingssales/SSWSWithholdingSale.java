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
package ec.com.sidesoft.localization.ecuador.withholdingssales;

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
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.financialmgmt.gl.GLItem;
import org.openbravo.model.financialmgmt.payment.FIN_Payment;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentScheduleDetail;
/**
 * Entity class for entity SSWS_WithholdingSale (stored in table SSWS_WithholdingSale).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SSWSWithholdingSale extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "SSWS_WithholdingSale";
    public static final String ENTITY_NAME = "SSWS_WithholdingSale";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_WITHHOLDINGDATE = "withholdingDate";
    public static final String PROPERTY_PROCESSNOW = "processNow";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_POSTED = "posted";
    public static final String PROPERTY_ACCOUNTINGDATE = "accountingDate";
    public static final String PROPERTY_TOTALWHRENTALAMT = "totalWhRentalAmt";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_DOCUMENTTYPE = "documentType";
    public static final String PROPERTY_TOTALWHIVAAMT = "totalWhIVAAmt";
    public static final String PROPERTY_DOCUMENTSTATUS = "documentStatus";
    public static final String PROPERTY_DOCUMENTACTION = "documentAction";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_INVOICE = "invoice";
    public static final String PROPERTY_WITHHOLDINGTYPE = "withholdingType";
    public static final String PROPERTY_GETLINES = "getlines";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_CODIGO = "codigo";
    public static final String PROPERTY_NUMAUTO = "numauto";
    public static final String PROPERTY_FECHAAUTOTEXT = "fechaautotext";
    public static final String PROPERTY_PAIDINVOICE = "paidinvoice";
    public static final String PROPERTY_GLITEM = "glitem";
    public static final String PROPERTY_ISAGREEMMENT = "isagreemment";
    public static final String PROPERTY_PAYMENTSCHEDULEDETAIL = "paymentScheduleDetail";
    public static final String PROPERTY_FINPAYMENTEMSWHPIWITHHOLDINGSALEIDLIST = "fINPaymentEMSwhpiWithholdingsaleIDList";
    public static final String PROPERTY_FINPAYMENTSCHEDULEDETAILEMSSWSWITHHOLDINGSSALESLIST = "fINPaymentScheduleDetailEMSSWSWithholdingsSalesList";
    public static final String PROPERTY_SSWSWHSALEDETAILVLIST = "sSWSWhSaleDetailVList";
    public static final String PROPERTY_SSWSWITHHOLDINGSALELINELIST = "sSWSWithholdingSaleLineList";
    public static final String PROPERTY_SSWSWITHHOLDINGSALELOGLIST = "sSWSWithholdingSaleLogList";

    public SSWSWithholdingSale() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_PROCESSNOW, false);
        setDefaultValue(PROPERTY_PROCESSED, "N");
        setDefaultValue(PROPERTY_DOCUMENTSTATUS, "DR");
        setDefaultValue(PROPERTY_WITHHOLDINGTYPE, "WS");
        setDefaultValue(PROPERTY_GETLINES, false);
        setDefaultValue(PROPERTY_PAIDINVOICE, false);
        setDefaultValue(PROPERTY_ISAGREEMMENT, false);
        setDefaultValue(PROPERTY_FINPAYMENTEMSWHPIWITHHOLDINGSALEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTSCHEDULEDETAILEMSSWSWITHHOLDINGSSALESLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWSWHSALEDETAILVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWSWITHHOLDINGSALELINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWSWITHHOLDINGSALELOGLIST, new ArrayList<Object>());
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

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Date getWithholdingDate() {
        return (Date) get(PROPERTY_WITHHOLDINGDATE);
    }

    public void setWithholdingDate(Date withholdingDate) {
        set(PROPERTY_WITHHOLDINGDATE, withholdingDate);
    }

    public Boolean isProcessNow() {
        return (Boolean) get(PROPERTY_PROCESSNOW);
    }

    public void setProcessNow(Boolean processNow) {
        set(PROPERTY_PROCESSNOW, processNow);
    }

    public String getProcessed() {
        return (String) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(String processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public String getPosted() {
        return (String) get(PROPERTY_POSTED);
    }

    public void setPosted(String posted) {
        set(PROPERTY_POSTED, posted);
    }

    public Date getAccountingDate() {
        return (Date) get(PROPERTY_ACCOUNTINGDATE);
    }

    public void setAccountingDate(Date accountingDate) {
        set(PROPERTY_ACCOUNTINGDATE, accountingDate);
    }

    public BigDecimal getTotalWhRentalAmt() {
        return (BigDecimal) get(PROPERTY_TOTALWHRENTALAMT);
    }

    public void setTotalWhRentalAmt(BigDecimal totalWhRentalAmt) {
        set(PROPERTY_TOTALWHRENTALAMT, totalWhRentalAmt);
    }

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

    public DocumentType getDocumentType() {
        return (DocumentType) get(PROPERTY_DOCUMENTTYPE);
    }

    public void setDocumentType(DocumentType documentType) {
        set(PROPERTY_DOCUMENTTYPE, documentType);
    }

    public BigDecimal getTotalWhIVAAmt() {
        return (BigDecimal) get(PROPERTY_TOTALWHIVAAMT);
    }

    public void setTotalWhIVAAmt(BigDecimal totalWhIVAAmt) {
        set(PROPERTY_TOTALWHIVAAMT, totalWhIVAAmt);
    }

    public String getDocumentStatus() {
        return (String) get(PROPERTY_DOCUMENTSTATUS);
    }

    public void setDocumentStatus(String documentStatus) {
        set(PROPERTY_DOCUMENTSTATUS, documentStatus);
    }

    public String getDocumentAction() {
        return (String) get(PROPERTY_DOCUMENTACTION);
    }

    public void setDocumentAction(String documentAction) {
        set(PROPERTY_DOCUMENTACTION, documentAction);
    }

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public Invoice getInvoice() {
        return (Invoice) get(PROPERTY_INVOICE);
    }

    public void setInvoice(Invoice invoice) {
        set(PROPERTY_INVOICE, invoice);
    }

    public String getWithholdingType() {
        return (String) get(PROPERTY_WITHHOLDINGTYPE);
    }

    public void setWithholdingType(String withholdingType) {
        set(PROPERTY_WITHHOLDINGTYPE, withholdingType);
    }

    public Boolean isGetlines() {
        return (Boolean) get(PROPERTY_GETLINES);
    }

    public void setGetlines(Boolean getlines) {
        set(PROPERTY_GETLINES, getlines);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public String getCodigo() {
        return (String) get(PROPERTY_CODIGO);
    }

    public void setCodigo(String codigo) {
        set(PROPERTY_CODIGO, codigo);
    }

    public String getNumauto() {
        return (String) get(PROPERTY_NUMAUTO);
    }

    public void setNumauto(String numauto) {
        set(PROPERTY_NUMAUTO, numauto);
    }

    public String getFechaautotext() {
        return (String) get(PROPERTY_FECHAAUTOTEXT);
    }

    public void setFechaautotext(String fechaautotext) {
        set(PROPERTY_FECHAAUTOTEXT, fechaautotext);
    }

    public Boolean isPaidinvoice() {
        return (Boolean) get(PROPERTY_PAIDINVOICE);
    }

    public void setPaidinvoice(Boolean paidinvoice) {
        set(PROPERTY_PAIDINVOICE, paidinvoice);
    }

    public GLItem getGlitem() {
        return (GLItem) get(PROPERTY_GLITEM);
    }

    public void setGlitem(GLItem glitem) {
        set(PROPERTY_GLITEM, glitem);
    }

    public Boolean isAgreemment() {
        return (Boolean) get(PROPERTY_ISAGREEMMENT);
    }

    public void setAgreemment(Boolean isagreemment) {
        set(PROPERTY_ISAGREEMMENT, isagreemment);
    }

    public FIN_PaymentScheduleDetail getPaymentScheduleDetail() {
        return (FIN_PaymentScheduleDetail) get(PROPERTY_PAYMENTSCHEDULEDETAIL);
    }

    public void setPaymentScheduleDetail(FIN_PaymentScheduleDetail paymentScheduleDetail) {
        set(PROPERTY_PAYMENTSCHEDULEDETAIL, paymentScheduleDetail);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_Payment> getFINPaymentEMSwhpiWithholdingsaleIDList() {
      return (List<FIN_Payment>) get(PROPERTY_FINPAYMENTEMSWHPIWITHHOLDINGSALEIDLIST);
    }

    public void setFINPaymentEMSwhpiWithholdingsaleIDList(List<FIN_Payment> fINPaymentEMSwhpiWithholdingsaleIDList) {
        set(PROPERTY_FINPAYMENTEMSWHPIWITHHOLDINGSALEIDLIST, fINPaymentEMSwhpiWithholdingsaleIDList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_PaymentScheduleDetail> getFINPaymentScheduleDetailEMSSWSWithholdingsSalesList() {
      return (List<FIN_PaymentScheduleDetail>) get(PROPERTY_FINPAYMENTSCHEDULEDETAILEMSSWSWITHHOLDINGSSALESLIST);
    }

    public void setFINPaymentScheduleDetailEMSSWSWithholdingsSalesList(List<FIN_PaymentScheduleDetail> fINPaymentScheduleDetailEMSSWSWithholdingsSalesList) {
        set(PROPERTY_FINPAYMENTSCHEDULEDETAILEMSSWSWITHHOLDINGSSALESLIST, fINPaymentScheduleDetailEMSSWSWithholdingsSalesList);
    }

    @SuppressWarnings("unchecked")
    public List<SSWSWhSaleDetailV> getSSWSWhSaleDetailVList() {
      return (List<SSWSWhSaleDetailV>) get(PROPERTY_SSWSWHSALEDETAILVLIST);
    }

    public void setSSWSWhSaleDetailVList(List<SSWSWhSaleDetailV> sSWSWhSaleDetailVList) {
        set(PROPERTY_SSWSWHSALEDETAILVLIST, sSWSWhSaleDetailVList);
    }

    @SuppressWarnings("unchecked")
    public List<SSWSWithholdingSaleLine> getSSWSWithholdingSaleLineList() {
      return (List<SSWSWithholdingSaleLine>) get(PROPERTY_SSWSWITHHOLDINGSALELINELIST);
    }

    public void setSSWSWithholdingSaleLineList(List<SSWSWithholdingSaleLine> sSWSWithholdingSaleLineList) {
        set(PROPERTY_SSWSWITHHOLDINGSALELINELIST, sSWSWithholdingSaleLineList);
    }

    @SuppressWarnings("unchecked")
    public List<SSWSWithholdingSaleLog> getSSWSWithholdingSaleLogList() {
      return (List<SSWSWithholdingSaleLog>) get(PROPERTY_SSWSWITHHOLDINGSALELOGLIST);
    }

    public void setSSWSWithholdingSaleLogList(List<SSWSWithholdingSaleLog> sSWSWithholdingSaleLogList) {
        set(PROPERTY_SSWSWITHHOLDINGSALELOGLIST, sSWSWithholdingSaleLogList);
    }

}
