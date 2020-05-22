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
package com.sidesoft.localization.ecuador.withholdings;

import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.bank.Bank;
import org.openbravo.model.common.businesspartner.TaxCategory;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.payment.PaymentTerm;
/**
 * Entity class for entity SSWH_Pos (stored in table SSWH_Pos).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SSWHPos extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "SSWH_Pos";
    public static final String ENTITY_NAME = "SSWH_Pos";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DOCUMENTTYPE = "documentType";
    public static final String PROPERTY_PAYMENTTERMS = "paymentTerms";
    public static final String PROPERTY_BUSINESSPARTNERTAXCATEGORY = "businessPartnerTaxCategory";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_DATEPOS = "datePos";
    public static final String PROPERTY_GRANDTOTALAMOUNT = "grandTotalAmount";
    public static final String PROPERTY_TERMSPAYMENT = "termspayment";
    public static final String PROPERTY_AMOUNTCARD = "amountCard";
    public static final String PROPERTY_CHECK = "check";
    public static final String PROPERTY_AMOUNTCHECK = "amountCheck";
    public static final String PROPERTY_AMOUNCASH = "amounCash";
    public static final String PROPERTY_AMOUNTCREDIT = "amountCredit";
    public static final String PROPERTY_BANK = "bank";

    public SSWHPos() {
        setDefaultValue(PROPERTY_ACTIVE, true);
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

    public PaymentTerm getPaymentTerms() {
        return (PaymentTerm) get(PROPERTY_PAYMENTTERMS);
    }

    public void setPaymentTerms(PaymentTerm paymentTerms) {
        set(PROPERTY_PAYMENTTERMS, paymentTerms);
    }

    public TaxCategory getBusinessPartnerTaxCategory() {
        return (TaxCategory) get(PROPERTY_BUSINESSPARTNERTAXCATEGORY);
    }

    public void setBusinessPartnerTaxCategory(TaxCategory businessPartnerTaxCategory) {
        set(PROPERTY_BUSINESSPARTNERTAXCATEGORY, businessPartnerTaxCategory);
    }

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

    public Date getDatePos() {
        return (Date) get(PROPERTY_DATEPOS);
    }

    public void setDatePos(Date datePos) {
        set(PROPERTY_DATEPOS, datePos);
    }

    public Long getGrandTotalAmount() {
        return (Long) get(PROPERTY_GRANDTOTALAMOUNT);
    }

    public void setGrandTotalAmount(Long grandTotalAmount) {
        set(PROPERTY_GRANDTOTALAMOUNT, grandTotalAmount);
    }

    public String getTermspayment() {
        return (String) get(PROPERTY_TERMSPAYMENT);
    }

    public void setTermspayment(String termspayment) {
        set(PROPERTY_TERMSPAYMENT, termspayment);
    }

    public Long getAmountCard() {
        return (Long) get(PROPERTY_AMOUNTCARD);
    }

    public void setAmountCard(Long amountCard) {
        set(PROPERTY_AMOUNTCARD, amountCard);
    }

    public String getCheck() {
        return (String) get(PROPERTY_CHECK);
    }

    public void setCheck(String check) {
        set(PROPERTY_CHECK, check);
    }

    public Long getAmountCheck() {
        return (Long) get(PROPERTY_AMOUNTCHECK);
    }

    public void setAmountCheck(Long amountCheck) {
        set(PROPERTY_AMOUNTCHECK, amountCheck);
    }

    public Long getAmounCash() {
        return (Long) get(PROPERTY_AMOUNCASH);
    }

    public void setAmounCash(Long amounCash) {
        set(PROPERTY_AMOUNCASH, amounCash);
    }

    public Long getAmountCredit() {
        return (Long) get(PROPERTY_AMOUNTCREDIT);
    }

    public void setAmountCredit(Long amountCredit) {
        set(PROPERTY_AMOUNTCREDIT, amountCredit);
    }

    public Bank getBank() {
        return (Bank) get(PROPERTY_BANK);
    }

    public void setBank(Bank bank) {
        set(PROPERTY_BANK, bank);
    }

}
