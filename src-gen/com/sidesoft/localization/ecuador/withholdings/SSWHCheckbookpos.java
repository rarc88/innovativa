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
import org.openbravo.model.common.bank.Bank;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.Organization;
/**
 * Entity class for entity SSWH_Checkbookpos (stored in table SSWH_Checkbookpos).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SSWHCheckbookpos extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "SSWH_Checkbookpos";
    public static final String ENTITY_NAME = "SSWH_Checkbookpos";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_ACCOUNTTYPE = "accountType";
    public static final String PROPERTY_GENERICACCOUNT = "genericAccount";
    public static final String PROPERTY_TYPECHECK = "typecheck";
    public static final String PROPERTY_GENERATETO = "generateTo";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_PROCESSNOW = "processNow";
    public static final String PROPERTY_DOCUMENTACTION = "documentAction";
    public static final String PROPERTY_DOCUMENTSTATUS = "documentStatus";
    public static final String PROPERTY_LINECHECK = "linecheck";
    public static final String PROPERTY_DATECREATED = "dateCreated";
    public static final String PROPERTY_DATEEXPIRED = "dateExpired";
    public static final String PROPERTY_TOTAL = "total";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_TYPEOPERATION = "typeOperation";
    public static final String PROPERTY_BANK = "bank";
    public static final String PROPERTY_SSWHCHECKBOOKPOSLINELIST = "sSWHCheckbookposLineList";

    public SSWHCheckbookpos() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_ACCOUNTTYPE, "C");
        setDefaultValue(PROPERTY_GENERATETO, false);
        setDefaultValue(PROPERTY_PROCESSED, "N");
        setDefaultValue(PROPERTY_PROCESSNOW, false);
        setDefaultValue(PROPERTY_DOCUMENTSTATUS, "P");
        setDefaultValue(PROPERTY_SSWHCHECKBOOKPOSLINELIST, new ArrayList<Object>());
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

    public String getDocumentAction() {
        return (String) get(PROPERTY_DOCUMENTACTION);
    }

    public void setDocumentAction(String documentAction) {
        set(PROPERTY_DOCUMENTACTION, documentAction);
    }

    public String getDocumentStatus() {
        return (String) get(PROPERTY_DOCUMENTSTATUS);
    }

    public void setDocumentStatus(String documentStatus) {
        set(PROPERTY_DOCUMENTSTATUS, documentStatus);
    }

    public String getLinecheck() {
        return (String) get(PROPERTY_LINECHECK);
    }

    public void setLinecheck(String linecheck) {
        set(PROPERTY_LINECHECK, linecheck);
    }

    public Date getDateCreated() {
        return (Date) get(PROPERTY_DATECREATED);
    }

    public void setDateCreated(Date dateCreated) {
        set(PROPERTY_DATECREATED, dateCreated);
    }

    public Date getDateExpired() {
        return (Date) get(PROPERTY_DATEEXPIRED);
    }

    public void setDateExpired(Date dateExpired) {
        set(PROPERTY_DATEEXPIRED, dateExpired);
    }

    public BigDecimal getTotal() {
        return (BigDecimal) get(PROPERTY_TOTAL);
    }

    public void setTotal(BigDecimal total) {
        set(PROPERTY_TOTAL, total);
    }

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public String getTypeOperation() {
        return (String) get(PROPERTY_TYPEOPERATION);
    }

    public void setTypeOperation(String typeOperation) {
        set(PROPERTY_TYPEOPERATION, typeOperation);
    }

    public Bank getBank() {
        return (Bank) get(PROPERTY_BANK);
    }

    public void setBank(Bank bank) {
        set(PROPERTY_BANK, bank);
    }

    @SuppressWarnings("unchecked")
    public List<SSWHCheckbookposLine> getSSWHCheckbookposLineList() {
      return (List<SSWHCheckbookposLine>) get(PROPERTY_SSWHCHECKBOOKPOSLINELIST);
    }

    public void setSSWHCheckbookposLineList(List<SSWHCheckbookposLine> sSWHCheckbookposLineList) {
        set(PROPERTY_SSWHCHECKBOOKPOSLINELIST, sSWHCheckbookposLineList);
    }

}
