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
import org.openbravo.model.common.bank.BankAccount;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.cashmgmt.BankStatement;
/**
 * Entity class for entity SSWH_checkbook (stored in table SSWH_checkbook).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SSWHCheckbook extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "SSWH_checkbook";
    public static final String ENTITY_NAME = "SSWH_checkbook";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_BANKACCOUNT = "bankAccount";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_ACCOUNTTYPE = "accountType";
    public static final String PROPERTY_GENERICACCOUNT = "genericAccount";
    public static final String PROPERTY_TYPECHECK = "typecheck";
    public static final String PROPERTY_SECTORY = "sectory";
    public static final String PROPERTY_PHONE = "phone";
    public static final String PROPERTY_FROM = "from";
    public static final String PROPERTY_TO = "to";
    public static final String PROPERTY_NROCHECK = "nroCheck";
    public static final String PROPERTY_GENERATETO = "generateTo";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_PROCESSNOW = "processNow";
    public static final String PROPERTY_DOCUMENTACTION = "documentAction";
    public static final String PROPERTY_DOCUMENTSTATUS = "documentStatus";
    public static final String PROPERTY_FINANCIALMGMTBANKSTATEMENTEMSSWHCHECKBOOKLIST = "financialMgmtBankStatementEMSswhCheckbookList";
    public static final String PROPERTY_SSWHCHECKBOOKLINELIST = "sSWHCheckbooklineList";

    public SSWHCheckbook() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_ACCOUNTTYPE, "C");
        setDefaultValue(PROPERTY_GENERATETO, false);
        setDefaultValue(PROPERTY_PROCESSED, "N");
        setDefaultValue(PROPERTY_PROCESSNOW, false);
        setDefaultValue(PROPERTY_DOCUMENTACTION, false);
        setDefaultValue(PROPERTY_DOCUMENTSTATUS, "DR");
        setDefaultValue(PROPERTY_FINANCIALMGMTBANKSTATEMENTEMSSWHCHECKBOOKLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWHCHECKBOOKLINELIST, new ArrayList<Object>());
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

    public BankAccount getBankAccount() {
        return (BankAccount) get(PROPERTY_BANKACCOUNT);
    }

    public void setBankAccount(BankAccount bankAccount) {
        set(PROPERTY_BANKACCOUNT, bankAccount);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public String getAccountType() {
        return (String) get(PROPERTY_ACCOUNTTYPE);
    }

    public void setAccountType(String accountType) {
        set(PROPERTY_ACCOUNTTYPE, accountType);
    }

    public String getGenericAccount() {
        return (String) get(PROPERTY_GENERICACCOUNT);
    }

    public void setGenericAccount(String genericAccount) {
        set(PROPERTY_GENERICACCOUNT, genericAccount);
    }

    public String getTypecheck() {
        return (String) get(PROPERTY_TYPECHECK);
    }

    public void setTypecheck(String typecheck) {
        set(PROPERTY_TYPECHECK, typecheck);
    }

    public String getSectory() {
        return (String) get(PROPERTY_SECTORY);
    }

    public void setSectory(String sectory) {
        set(PROPERTY_SECTORY, sectory);
    }

    public String getPhone() {
        return (String) get(PROPERTY_PHONE);
    }

    public void setPhone(String phone) {
        set(PROPERTY_PHONE, phone);
    }

    public String getFrom() {
        return (String) get(PROPERTY_FROM);
    }

    public void setFrom(String from) {
        set(PROPERTY_FROM, from);
    }

    public String getTo() {
        return (String) get(PROPERTY_TO);
    }

    public void setTo(String to) {
        set(PROPERTY_TO, to);
    }

    public String getNroCheck() {
        return (String) get(PROPERTY_NROCHECK);
    }

    public void setNroCheck(String nroCheck) {
        set(PROPERTY_NROCHECK, nroCheck);
    }

    public Boolean isGenerateTo() {
        return (Boolean) get(PROPERTY_GENERATETO);
    }

    public void setGenerateTo(Boolean generateTo) {
        set(PROPERTY_GENERATETO, generateTo);
    }

    public String getProcessed() {
        return (String) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(String processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public Boolean isProcessNow() {
        return (Boolean) get(PROPERTY_PROCESSNOW);
    }

    public void setProcessNow(Boolean processNow) {
        set(PROPERTY_PROCESSNOW, processNow);
    }

    public Boolean isDocumentAction() {
        return (Boolean) get(PROPERTY_DOCUMENTACTION);
    }

    public void setDocumentAction(Boolean documentAction) {
        set(PROPERTY_DOCUMENTACTION, documentAction);
    }

    public String getDocumentStatus() {
        return (String) get(PROPERTY_DOCUMENTSTATUS);
    }

    public void setDocumentStatus(String documentStatus) {
        set(PROPERTY_DOCUMENTSTATUS, documentStatus);
    }

    @SuppressWarnings("unchecked")
    public List<BankStatement> getFinancialMgmtBankStatementEMSswhCheckbookList() {
      return (List<BankStatement>) get(PROPERTY_FINANCIALMGMTBANKSTATEMENTEMSSWHCHECKBOOKLIST);
    }

    public void setFinancialMgmtBankStatementEMSswhCheckbookList(List<BankStatement> financialMgmtBankStatementEMSswhCheckbookList) {
        set(PROPERTY_FINANCIALMGMTBANKSTATEMENTEMSSWHCHECKBOOKLIST, financialMgmtBankStatementEMSswhCheckbookList);
    }

    @SuppressWarnings("unchecked")
    public List<SSWHCheckbookline> getSSWHCheckbooklineList() {
      return (List<SSWHCheckbookline>) get(PROPERTY_SSWHCHECKBOOKLINELIST);
    }

    public void setSSWHCheckbooklineList(List<SSWHCheckbookline> sSWHCheckbooklineList) {
        set(PROPERTY_SSWHCHECKBOOKLINELIST, sSWHCheckbooklineList);
    }

}
