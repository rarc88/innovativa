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
package ec.com.sidesoft.quick.billing;

import com.sidesoft.flopec.budget.data.SFBBudgetArea;
import com.sidesoft.localization.ecuador.withholdings.Taxpayer;

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
import org.openbravo.model.ad.system.Language;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.businesspartner.Category;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.geography.Country;
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.accounting.UserDimension1;
import org.openbravo.model.financialmgmt.accounting.UserDimension2;
import org.openbravo.model.financialmgmt.payment.FIN_FinancialAccount;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentMethod;
import org.openbravo.model.financialmgmt.payment.PaymentTerm;
import org.openbravo.model.pricing.pricelist.PriceList;
/**
 * Entity class for entity sqb_config_quickbilling (stored in table sqb_config_quickbilling).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SqbConfigQuickBilling extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sqb_config_quickbilling";
    public static final String ENTITY_NAME = "sqb_config_quickbilling";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_BPARTNER = "bpartner";
    public static final String PROPERTY_DOCTYPE = "doctype";
    public static final String PROPERTY_FINPAYMENTMETHOD = "fINPaymentmethod";
    public static final String PROPERTY_PAYMENTTERM = "paymentterm";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_PRICELIST = "pricelist";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_BPGROUP = "bpGroup";
    public static final String PROPERTY_LANGUAGE = "language";
    public static final String PROPERTY_COUNTRY = "country";
    public static final String PROPERTY_AUTOMATICPAYMENT = "automaticPayment";
    public static final String PROPERTY_FINFINANCIALACCOUNT = "fINFinancialAccount";
    public static final String PROPERTY_DOCTYPEPAYMENTIN = "doctypePaymentIn";
    public static final String PROPERTY_SSWHTAXPAYER = "sswhTaxpayer";
    public static final String PROPERTY_COSTCENTER = "costcenter";
    public static final String PROPERTY_USER1 = "user1";
    public static final String PROPERTY_USER2 = "user2";
    public static final String PROPERTY_MAXBILLINGVALUE = "mAXBillingValue";
    public static final String PROPERTY_PAYMENTMETHODENABLE = "paymentmethodEnable";
    public static final String PROPERTY_SQBBUBUDGETAREA = "sqbbuBudgetArea";
    public static final String PROPERTY_SQBCONFIGPRODUCTLIST = "sqbConfigProductList";
    public static final String PROPERTY_SQBCONFIGUSERLIST = "sqbConfigUserList";

    public SqbConfigQuickBilling() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_AUTOMATICPAYMENT, false);
        setDefaultValue(PROPERTY_MAXBILLINGVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_PAYMENTMETHODENABLE, false);
        setDefaultValue(PROPERTY_SQBCONFIGPRODUCTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SQBCONFIGUSERLIST, new ArrayList<Object>());
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

    public BusinessPartner getBpartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBpartner(BusinessPartner bpartner) {
        set(PROPERTY_BPARTNER, bpartner);
    }

    public DocumentType getDoctype() {
        return (DocumentType) get(PROPERTY_DOCTYPE);
    }

    public void setDoctype(DocumentType doctype) {
        set(PROPERTY_DOCTYPE, doctype);
    }

    public FIN_PaymentMethod getFINPaymentmethod() {
        return (FIN_PaymentMethod) get(PROPERTY_FINPAYMENTMETHOD);
    }

    public void setFINPaymentmethod(FIN_PaymentMethod fINPaymentmethod) {
        set(PROPERTY_FINPAYMENTMETHOD, fINPaymentmethod);
    }

    public PaymentTerm getPaymentterm() {
        return (PaymentTerm) get(PROPERTY_PAYMENTTERM);
    }

    public void setPaymentterm(PaymentTerm paymentterm) {
        set(PROPERTY_PAYMENTTERM, paymentterm);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public PriceList getPricelist() {
        return (PriceList) get(PROPERTY_PRICELIST);
    }

    public void setPricelist(PriceList pricelist) {
        set(PROPERTY_PRICELIST, pricelist);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public Category getBpGroup() {
        return (Category) get(PROPERTY_BPGROUP);
    }

    public void setBpGroup(Category bpGroup) {
        set(PROPERTY_BPGROUP, bpGroup);
    }

    public Language getLanguage() {
        return (Language) get(PROPERTY_LANGUAGE);
    }

    public void setLanguage(Language language) {
        set(PROPERTY_LANGUAGE, language);
    }

    public Country getCountry() {
        return (Country) get(PROPERTY_COUNTRY);
    }

    public void setCountry(Country country) {
        set(PROPERTY_COUNTRY, country);
    }

    public Boolean isAutomaticPayment() {
        return (Boolean) get(PROPERTY_AUTOMATICPAYMENT);
    }

    public void setAutomaticPayment(Boolean automaticPayment) {
        set(PROPERTY_AUTOMATICPAYMENT, automaticPayment);
    }

    public FIN_FinancialAccount getFINFinancialAccount() {
        return (FIN_FinancialAccount) get(PROPERTY_FINFINANCIALACCOUNT);
    }

    public void setFINFinancialAccount(FIN_FinancialAccount fINFinancialAccount) {
        set(PROPERTY_FINFINANCIALACCOUNT, fINFinancialAccount);
    }

    public DocumentType getDoctypePaymentIn() {
        return (DocumentType) get(PROPERTY_DOCTYPEPAYMENTIN);
    }

    public void setDoctypePaymentIn(DocumentType doctypePaymentIn) {
        set(PROPERTY_DOCTYPEPAYMENTIN, doctypePaymentIn);
    }

    public Taxpayer getSswhTaxpayer() {
        return (Taxpayer) get(PROPERTY_SSWHTAXPAYER);
    }

    public void setSswhTaxpayer(Taxpayer sswhTaxpayer) {
        set(PROPERTY_SSWHTAXPAYER, sswhTaxpayer);
    }

    public Costcenter getCostcenter() {
        return (Costcenter) get(PROPERTY_COSTCENTER);
    }

    public void setCostcenter(Costcenter costcenter) {
        set(PROPERTY_COSTCENTER, costcenter);
    }

    public UserDimension1 getUser1() {
        return (UserDimension1) get(PROPERTY_USER1);
    }

    public void setUser1(UserDimension1 user1) {
        set(PROPERTY_USER1, user1);
    }

    public UserDimension2 getUser2() {
        return (UserDimension2) get(PROPERTY_USER2);
    }

    public void setUser2(UserDimension2 user2) {
        set(PROPERTY_USER2, user2);
    }

    public BigDecimal getMAXBillingValue() {
        return (BigDecimal) get(PROPERTY_MAXBILLINGVALUE);
    }

    public void setMAXBillingValue(BigDecimal mAXBillingValue) {
        set(PROPERTY_MAXBILLINGVALUE, mAXBillingValue);
    }

    public Boolean isPaymentmethodEnable() {
        return (Boolean) get(PROPERTY_PAYMENTMETHODENABLE);
    }

    public void setPaymentmethodEnable(Boolean paymentmethodEnable) {
        set(PROPERTY_PAYMENTMETHODENABLE, paymentmethodEnable);
    }

    public SFBBudgetArea getSqbbuBudgetArea() {
        return (SFBBudgetArea) get(PROPERTY_SQBBUBUDGETAREA);
    }

    public void setSqbbuBudgetArea(SFBBudgetArea sqbbuBudgetArea) {
        set(PROPERTY_SQBBUBUDGETAREA, sqbbuBudgetArea);
    }

    @SuppressWarnings("unchecked")
    public List<SqbConfigProduct> getSqbConfigProductList() {
      return (List<SqbConfigProduct>) get(PROPERTY_SQBCONFIGPRODUCTLIST);
    }

    public void setSqbConfigProductList(List<SqbConfigProduct> sqbConfigProductList) {
        set(PROPERTY_SQBCONFIGPRODUCTLIST, sqbConfigProductList);
    }

    @SuppressWarnings("unchecked")
    public List<SqbConfigUser> getSqbConfigUserList() {
      return (List<SqbConfigUser>) get(PROPERTY_SQBCONFIGUSERLIST);
    }

    public void setSqbConfigUserList(List<SqbConfigUser> sqbConfigUserList) {
        set(PROPERTY_SQBCONFIGUSERLIST, sqbConfigUserList);
    }

}
