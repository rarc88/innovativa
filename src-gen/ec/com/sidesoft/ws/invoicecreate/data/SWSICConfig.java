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
package ec.com.sidesoft.ws.invoicecreate.data;

import com.sidesoft.flopec.budget.data.SFBBudgetArea;
import com.sidesoft.localization.ecuador.withholdings.Taxpayer;

import java.util.Date;

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
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.accounting.UserDimension1;
import org.openbravo.model.financialmgmt.accounting.UserDimension2;
import org.openbravo.model.financialmgmt.payment.FIN_FinancialAccount;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentMethod;
import org.openbravo.model.financialmgmt.payment.PaymentTerm;
import org.openbravo.model.financialmgmt.tax.TaxRate;
import org.openbravo.model.pricing.pricelist.PriceList;
/**
 * Entity class for entity SWSIC_Config (stored in table SWSIC_Config).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SWSICConfig extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "SWSIC_Config";
    public static final String ENTITY_NAME = "SWSIC_Config";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DOCTYPE = "doctype";
    public static final String PROPERTY_USERCONTACT = "userContact";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_PAYMENTTERM = "paymentterm";
    public static final String PROPERTY_PRICELIST = "pricelist";
    public static final String PROPERTY_BPGROUP = "bpGroup";
    public static final String PROPERTY_SSWHTAXPAYER = "sswhTaxpayer";
    public static final String PROPERTY_LANGUAGE = "language";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_COSTCENTER = "costcenter";
    public static final String PROPERTY_BPARTNER = "bpartner";
    public static final String PROPERTY_FINPAYMENTMETHOD = "fINPaymentmethod";
    public static final String PROPERTY_USER1 = "user1";
    public static final String PROPERTY_USER2 = "user2";
    public static final String PROPERTY_TAXIVA = "tAXIva";
    public static final String PROPERTY_TAXSERVICE = "tAXService";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_COUNTRY = "country";
    public static final String PROPERTY_AUTOMATICPAYMENT = "automaticPayment";
    public static final String PROPERTY_DOCTYPEPAYMENTIN = "doctypePaymentIn";
    public static final String PROPERTY_FINFINANCIALACCOUNT = "fINFinancialAccount";
    public static final String PROPERTY_SWSICBBUDGETAREA = "swsicbBudgetArea";

    public SWSICConfig() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_AUTOMATICPAYMENT, false);
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

    public DocumentType getDoctype() {
        return (DocumentType) get(PROPERTY_DOCTYPE);
    }

    public void setDoctype(DocumentType doctype) {
        set(PROPERTY_DOCTYPE, doctype);
    }

    public User getUserContact() {
        return (User) get(PROPERTY_USERCONTACT);
    }

    public void setUserContact(User userContact) {
        set(PROPERTY_USERCONTACT, userContact);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public PaymentTerm getPaymentterm() {
        return (PaymentTerm) get(PROPERTY_PAYMENTTERM);
    }

    public void setPaymentterm(PaymentTerm paymentterm) {
        set(PROPERTY_PAYMENTTERM, paymentterm);
    }

    public PriceList getPricelist() {
        return (PriceList) get(PROPERTY_PRICELIST);
    }

    public void setPricelist(PriceList pricelist) {
        set(PROPERTY_PRICELIST, pricelist);
    }

    public Category getBpGroup() {
        return (Category) get(PROPERTY_BPGROUP);
    }

    public void setBpGroup(Category bpGroup) {
        set(PROPERTY_BPGROUP, bpGroup);
    }

    public Taxpayer getSswhTaxpayer() {
        return (Taxpayer) get(PROPERTY_SSWHTAXPAYER);
    }

    public void setSswhTaxpayer(Taxpayer sswhTaxpayer) {
        set(PROPERTY_SSWHTAXPAYER, sswhTaxpayer);
    }

    public Language getLanguage() {
        return (Language) get(PROPERTY_LANGUAGE);
    }

    public void setLanguage(Language language) {
        set(PROPERTY_LANGUAGE, language);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public Costcenter getCostcenter() {
        return (Costcenter) get(PROPERTY_COSTCENTER);
    }

    public void setCostcenter(Costcenter costcenter) {
        set(PROPERTY_COSTCENTER, costcenter);
    }

    public BusinessPartner getBpartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBpartner(BusinessPartner bpartner) {
        set(PROPERTY_BPARTNER, bpartner);
    }

    public FIN_PaymentMethod getFINPaymentmethod() {
        return (FIN_PaymentMethod) get(PROPERTY_FINPAYMENTMETHOD);
    }

    public void setFINPaymentmethod(FIN_PaymentMethod fINPaymentmethod) {
        set(PROPERTY_FINPAYMENTMETHOD, fINPaymentmethod);
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

    public TaxRate getTAXIva() {
        return (TaxRate) get(PROPERTY_TAXIVA);
    }

    public void setTAXIva(TaxRate tAXIva) {
        set(PROPERTY_TAXIVA, tAXIva);
    }

    public TaxRate getTAXService() {
        return (TaxRate) get(PROPERTY_TAXSERVICE);
    }

    public void setTAXService(TaxRate tAXService) {
        set(PROPERTY_TAXSERVICE, tAXService);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
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

    public DocumentType getDoctypePaymentIn() {
        return (DocumentType) get(PROPERTY_DOCTYPEPAYMENTIN);
    }

    public void setDoctypePaymentIn(DocumentType doctypePaymentIn) {
        set(PROPERTY_DOCTYPEPAYMENTIN, doctypePaymentIn);
    }

    public FIN_FinancialAccount getFINFinancialAccount() {
        return (FIN_FinancialAccount) get(PROPERTY_FINFINANCIALACCOUNT);
    }

    public void setFINFinancialAccount(FIN_FinancialAccount fINFinancialAccount) {
        set(PROPERTY_FINFINANCIALACCOUNT, fINFinancialAccount);
    }

    public SFBBudgetArea getSwsicbBudgetArea() {
        return (SFBBudgetArea) get(PROPERTY_SWSICBBUDGETAREA);
    }

    public void setSwsicbBudgetArea(SFBBudgetArea swsicbBudgetArea) {
        set(PROPERTY_SWSICBBUDGETAREA, swsicbBudgetArea);
    }

}
