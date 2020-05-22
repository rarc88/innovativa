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
package com.sidesoft.localization.ecuador.finances;

import ec.com.sidesoft.localization.ecuador.viatical.SSVEViatical;
import ec.com.sidesoft.localization.ecuador.viatical.SSVEViaticalSettlement;

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
import org.openbravo.model.common.businesspartner.BankAccount;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.payment.FIN_Payment;
/**
 * Entity class for entity ssfi_banktransfer (stored in table ssfi_banktransfer).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ssfiBanktransfer extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ssfi_banktransfer";
    public static final String ENTITY_NAME = "ssfi_banktransfer";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_COMMERCIALNAME = "commercialName";
    public static final String PROPERTY_CODE = "code";
    public static final String PROPERTY_SEARCHKEY = "searchKey";
    public static final String PROPERTY_SAVINGCODEAUX = "savingcodeAux";
    public static final String PROPERTY_PAYMENTMETHOD = "paymentmethod";
    public static final String PROPERTY_CURRENTCODEAUX = "currentcodeAux";
    public static final String PROPERTY_CURRENTCODE = "currentcode";
    public static final String PROPERTY_SAVINGCODE = "savingcode";
    public static final String PROPERTY_BUSINESSPARTNERBANKACCOUNTEMSSFIBANKTRANSFERIDLIST = "businessPartnerBankAccountEmSsfiBanktransferIdList";
    public static final String PROPERTY_FINPAYMENTEMSSFIBANKTRANSFERIDLIST = "fINPaymentEMSsfiBanktransferIDList";
    public static final String PROPERTY_SSVEVIATICALLIST = "sSVEViaticalList";
    public static final String PROPERTY_SSVEVIATICALSETTLEMENTLIST = "sSVEViaticalSettlementList";

    public ssfiBanktransfer() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_BUSINESSPARTNERBANKACCOUNTEMSSFIBANKTRANSFERIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTEMSSFIBANKTRANSFERIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSVEVIATICALLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSVEVIATICALSETTLEMENTLIST, new ArrayList<Object>());
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

    public String getCode() {
        return (String) get(PROPERTY_CODE);
    }

    public void setCode(String code) {
        set(PROPERTY_CODE, code);
    }

    public String getSearchKey() {
        return (String) get(PROPERTY_SEARCHKEY);
    }

    public void setSearchKey(String searchKey) {
        set(PROPERTY_SEARCHKEY, searchKey);
    }

    public Long getSavingcodeAux() {
        return (Long) get(PROPERTY_SAVINGCODEAUX);
    }

    public void setSavingcodeAux(Long savingcodeAux) {
        set(PROPERTY_SAVINGCODEAUX, savingcodeAux);
    }

    public String getPaymentmethod() {
        return (String) get(PROPERTY_PAYMENTMETHOD);
    }

    public void setPaymentmethod(String paymentmethod) {
        set(PROPERTY_PAYMENTMETHOD, paymentmethod);
    }

    public BigDecimal getCurrentcodeAux() {
        return (BigDecimal) get(PROPERTY_CURRENTCODEAUX);
    }

    public void setCurrentcodeAux(BigDecimal currentcodeAux) {
        set(PROPERTY_CURRENTCODEAUX, currentcodeAux);
    }

    public String getCurrentcode() {
        return (String) get(PROPERTY_CURRENTCODE);
    }

    public void setCurrentcode(String currentcode) {
        set(PROPERTY_CURRENTCODE, currentcode);
    }

    public String getSavingcode() {
        return (String) get(PROPERTY_SAVINGCODE);
    }

    public void setSavingcode(String savingcode) {
        set(PROPERTY_SAVINGCODE, savingcode);
    }

    @SuppressWarnings("unchecked")
    public List<BankAccount> getBusinessPartnerBankAccountEmSsfiBanktransferIdList() {
      return (List<BankAccount>) get(PROPERTY_BUSINESSPARTNERBANKACCOUNTEMSSFIBANKTRANSFERIDLIST);
    }

    public void setBusinessPartnerBankAccountEmSsfiBanktransferIdList(List<BankAccount> businessPartnerBankAccountEmSsfiBanktransferIdList) {
        set(PROPERTY_BUSINESSPARTNERBANKACCOUNTEMSSFIBANKTRANSFERIDLIST, businessPartnerBankAccountEmSsfiBanktransferIdList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_Payment> getFINPaymentEMSsfiBanktransferIDList() {
      return (List<FIN_Payment>) get(PROPERTY_FINPAYMENTEMSSFIBANKTRANSFERIDLIST);
    }

    public void setFINPaymentEMSsfiBanktransferIDList(List<FIN_Payment> fINPaymentEMSsfiBanktransferIDList) {
        set(PROPERTY_FINPAYMENTEMSSFIBANKTRANSFERIDLIST, fINPaymentEMSsfiBanktransferIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SSVEViatical> getSSVEViaticalList() {
      return (List<SSVEViatical>) get(PROPERTY_SSVEVIATICALLIST);
    }

    public void setSSVEViaticalList(List<SSVEViatical> sSVEViaticalList) {
        set(PROPERTY_SSVEVIATICALLIST, sSVEViaticalList);
    }

    @SuppressWarnings("unchecked")
    public List<SSVEViaticalSettlement> getSSVEViaticalSettlementList() {
      return (List<SSVEViaticalSettlement>) get(PROPERTY_SSVEVIATICALSETTLEMENTLIST);
    }

    public void setSSVEViaticalSettlementList(List<SSVEViaticalSettlement> sSVEViaticalSettlementList) {
        set(PROPERTY_SSVEVIATICALSETTLEMENTLIST, sSVEViaticalSettlementList);
    }

}
