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
package com.sidesoft.ecuador.humanResources;

import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.Organization;
/**
 * Entity class for entity sshr_salary_component (stored in table sshr_salary_component).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class sshrSalaryComponent extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sshr_salary_component";
    public static final String ENTITY_NAME = "sshr_salary_component";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_SSHRSALARYGRADE = "sshrSalaryGrade";
    public static final String PROPERTY_SALARYCOMPONENT = "salaryComponent";
    public static final String PROPERTY_FREQUENCY = "frequency";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_AMOUNT = "amount";
    public static final String PROPERTY_COMMENTS = "comments";
    public static final String PROPERTY_ISDIRECTDEPOSIT = "isdirectdeposit";
    public static final String PROPERTY_ACCOUNTNUMBER = "accountNumber";
    public static final String PROPERTY_ACCOUNTTYPE = "accountType";
    public static final String PROPERTY_ROUTINGNUMBER = "routingNumber";
    public static final String PROPERTY_AMOUNTDEPOSIT = "amountDeposit";

    public sshrSalaryComponent() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_ISDIRECTDEPOSIT, true);
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

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public sshrSalaryGrade getSshrSalaryGrade() {
        return (sshrSalaryGrade) get(PROPERTY_SSHRSALARYGRADE);
    }

    public void setSshrSalaryGrade(sshrSalaryGrade sshrSalaryGrade) {
        set(PROPERTY_SSHRSALARYGRADE, sshrSalaryGrade);
    }

    public String getSalaryComponent() {
        return (String) get(PROPERTY_SALARYCOMPONENT);
    }

    public void setSalaryComponent(String salaryComponent) {
        set(PROPERTY_SALARYCOMPONENT, salaryComponent);
    }

    public String getFrequency() {
        return (String) get(PROPERTY_FREQUENCY);
    }

    public void setFrequency(String frequency) {
        set(PROPERTY_FREQUENCY, frequency);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public Long getAmount() {
        return (Long) get(PROPERTY_AMOUNT);
    }

    public void setAmount(Long amount) {
        set(PROPERTY_AMOUNT, amount);
    }

    public String getComments() {
        return (String) get(PROPERTY_COMMENTS);
    }

    public void setComments(String comments) {
        set(PROPERTY_COMMENTS, comments);
    }

    public Boolean isDirectdeposit() {
        return (Boolean) get(PROPERTY_ISDIRECTDEPOSIT);
    }

    public void setDirectdeposit(Boolean isdirectdeposit) {
        set(PROPERTY_ISDIRECTDEPOSIT, isdirectdeposit);
    }

    public String getAccountNumber() {
        return (String) get(PROPERTY_ACCOUNTNUMBER);
    }

    public void setAccountNumber(String accountNumber) {
        set(PROPERTY_ACCOUNTNUMBER, accountNumber);
    }

    public String getAccountType() {
        return (String) get(PROPERTY_ACCOUNTTYPE);
    }

    public void setAccountType(String accountType) {
        set(PROPERTY_ACCOUNTTYPE, accountType);
    }

    public String getRoutingNumber() {
        return (String) get(PROPERTY_ROUTINGNUMBER);
    }

    public void setRoutingNumber(String routingNumber) {
        set(PROPERTY_ROUTINGNUMBER, routingNumber);
    }

    public Long getAmountDeposit() {
        return (Long) get(PROPERTY_AMOUNTDEPOSIT);
    }

    public void setAmountDeposit(Long amountDeposit) {
        set(PROPERTY_AMOUNTDEPOSIT, amountDeposit);
    }

}
