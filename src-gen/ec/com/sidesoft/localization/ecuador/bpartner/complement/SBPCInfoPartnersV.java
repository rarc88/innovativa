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
package ec.com.sidesoft.localization.ecuador.bpartner.complement;

import com.sidesoft.localization.ecuador.withholdings.Taxpayer;

import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.businesspartner.Category;
import org.openbravo.model.common.businesspartner.Location;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.geography.Country;
import org.openbravo.model.common.geography.Region;
/**
 * Entity class for entity SBPC_Info_Partners_V (stored in table SBPC_Info_Partners_V).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SBPCInfoPartnersV extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "SBPC_Info_Partners_V";
    public static final String ENTITY_NAME = "SBPC_Info_Partners_V";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_BUSINESSPARTNERCATEGORY = "businessPartnerCategory";
    public static final String PROPERTY_VENDOR = "vendor";
    public static final String PROPERTY_CUSTOMER = "customer";
    public static final String PROPERTY_EMPLOYEE = "employee";
    public static final String PROPERTY_ISSALESREPRESENTATIVE = "isSalesRepresentative";
    public static final String PROPERTY_BPARTNERIDTAX = "bpartnerIdTax";
    public static final String PROPERTY_CREDITLINELIMIT = "creditLineLimit";
    public static final String PROPERTY_CURRENTBALANCE = "currentBalance";
    public static final String PROPERTY_BPARTNERIDNAME = "bpartnerIdName";
    public static final String PROPERTY_SSWHTAXPAYER = "sswhTaxpayer";
    public static final String PROPERTY_PARTNERADDRESS = "partnerAddress";
    public static final String PROPERTY_LOCATIONIDADD1 = "locationIdAdd1";
    public static final String PROPERTY_LOCATIONIDADD2 = "locationIdAdd2";
    public static final String PROPERTY_LOCATIONIDCITY = "locationIdCity";
    public static final String PROPERTY_REGION = "region";
    public static final String PROPERTY_COUNTRY = "country";
    public static final String PROPERTY_BPARTNERLOCATIONIDPHONE1 = "bpartnerLocationIdPhone1";
    public static final String PROPERTY_BPARTNERLOCATIONIDPHONE2 = "bpartnerLocationIdPhone2";
    public static final String PROPERTY_INVOICINGADDRESS = "invoicingAddress";
    public static final String PROPERTY_SHIPPINGADDRESS = "shippingAddress";
    public static final String PROPERTY_PAYFROMADDRESS = "payFromAddress";
    public static final String PROPERTY_USERCONTACT = "userContact";
    public static final String PROPERTY_USERIDEMAIL = "userIdEmail";
    public static final String PROPERTY_USERIDPHONE1 = "userIdPhone1";
    public static final String PROPERTY_USERIDPHONE2 = "userIdPhone2";
    public static final String PROPERTY_BPARTNERIDMAIL = "bpartnerIdMail";

    public SBPCInfoPartnersV() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_VENDOR, false);
        setDefaultValue(PROPERTY_CUSTOMER, false);
        setDefaultValue(PROPERTY_EMPLOYEE, false);
        setDefaultValue(PROPERTY_ISSALESREPRESENTATIVE, false);
        setDefaultValue(PROPERTY_INVOICINGADDRESS, false);
        setDefaultValue(PROPERTY_SHIPPINGADDRESS, false);
        setDefaultValue(PROPERTY_PAYFROMADDRESS, false);
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

    public Category getBusinessPartnerCategory() {
        return (Category) get(PROPERTY_BUSINESSPARTNERCATEGORY);
    }

    public void setBusinessPartnerCategory(Category businessPartnerCategory) {
        set(PROPERTY_BUSINESSPARTNERCATEGORY, businessPartnerCategory);
    }

    public Boolean isVendor() {
        return (Boolean) get(PROPERTY_VENDOR);
    }

    public void setVendor(Boolean vendor) {
        set(PROPERTY_VENDOR, vendor);
    }

    public Boolean isCustomer() {
        return (Boolean) get(PROPERTY_CUSTOMER);
    }

    public void setCustomer(Boolean customer) {
        set(PROPERTY_CUSTOMER, customer);
    }

    public Boolean isEmployee() {
        return (Boolean) get(PROPERTY_EMPLOYEE);
    }

    public void setEmployee(Boolean employee) {
        set(PROPERTY_EMPLOYEE, employee);
    }

    public Boolean isSalesRepresentative() {
        return (Boolean) get(PROPERTY_ISSALESREPRESENTATIVE);
    }

    public void setSalesRepresentative(Boolean isSalesRepresentative) {
        set(PROPERTY_ISSALESREPRESENTATIVE, isSalesRepresentative);
    }

    public BusinessPartner getBpartnerIdTax() {
        return (BusinessPartner) get(PROPERTY_BPARTNERIDTAX);
    }

    public void setBpartnerIdTax(BusinessPartner bpartnerIdTax) {
        set(PROPERTY_BPARTNERIDTAX, bpartnerIdTax);
    }

    public Long getCreditLineLimit() {
        return (Long) get(PROPERTY_CREDITLINELIMIT);
    }

    public void setCreditLineLimit(Long creditLineLimit) {
        set(PROPERTY_CREDITLINELIMIT, creditLineLimit);
    }

    public Long getCurrentBalance() {
        return (Long) get(PROPERTY_CURRENTBALANCE);
    }

    public void setCurrentBalance(Long currentBalance) {
        set(PROPERTY_CURRENTBALANCE, currentBalance);
    }

    public BusinessPartner getBpartnerIdName() {
        return (BusinessPartner) get(PROPERTY_BPARTNERIDNAME);
    }

    public void setBpartnerIdName(BusinessPartner bpartnerIdName) {
        set(PROPERTY_BPARTNERIDNAME, bpartnerIdName);
    }

    public Taxpayer getSswhTaxpayer() {
        return (Taxpayer) get(PROPERTY_SSWHTAXPAYER);
    }

    public void setSswhTaxpayer(Taxpayer sswhTaxpayer) {
        set(PROPERTY_SSWHTAXPAYER, sswhTaxpayer);
    }

    public Location getPartnerAddress() {
        return (Location) get(PROPERTY_PARTNERADDRESS);
    }

    public void setPartnerAddress(Location partnerAddress) {
        set(PROPERTY_PARTNERADDRESS, partnerAddress);
    }

    public org.openbravo.model.common.geography.Location getLocationIdAdd1() {
        return (org.openbravo.model.common.geography.Location) get(PROPERTY_LOCATIONIDADD1);
    }

    public void setLocationIdAdd1(org.openbravo.model.common.geography.Location locationIdAdd1) {
        set(PROPERTY_LOCATIONIDADD1, locationIdAdd1);
    }

    public org.openbravo.model.common.geography.Location getLocationIdAdd2() {
        return (org.openbravo.model.common.geography.Location) get(PROPERTY_LOCATIONIDADD2);
    }

    public void setLocationIdAdd2(org.openbravo.model.common.geography.Location locationIdAdd2) {
        set(PROPERTY_LOCATIONIDADD2, locationIdAdd2);
    }

    public org.openbravo.model.common.geography.Location getLocationIdCity() {
        return (org.openbravo.model.common.geography.Location) get(PROPERTY_LOCATIONIDCITY);
    }

    public void setLocationIdCity(org.openbravo.model.common.geography.Location locationIdCity) {
        set(PROPERTY_LOCATIONIDCITY, locationIdCity);
    }

    public Region getRegion() {
        return (Region) get(PROPERTY_REGION);
    }

    public void setRegion(Region region) {
        set(PROPERTY_REGION, region);
    }

    public Country getCountry() {
        return (Country) get(PROPERTY_COUNTRY);
    }

    public void setCountry(Country country) {
        set(PROPERTY_COUNTRY, country);
    }

    public Location getBpartnerLocationIdPhone1() {
        return (Location) get(PROPERTY_BPARTNERLOCATIONIDPHONE1);
    }

    public void setBpartnerLocationIdPhone1(Location bpartnerLocationIdPhone1) {
        set(PROPERTY_BPARTNERLOCATIONIDPHONE1, bpartnerLocationIdPhone1);
    }

    public Location getBpartnerLocationIdPhone2() {
        return (Location) get(PROPERTY_BPARTNERLOCATIONIDPHONE2);
    }

    public void setBpartnerLocationIdPhone2(Location bpartnerLocationIdPhone2) {
        set(PROPERTY_BPARTNERLOCATIONIDPHONE2, bpartnerLocationIdPhone2);
    }

    public Boolean isInvoicingAddress() {
        return (Boolean) get(PROPERTY_INVOICINGADDRESS);
    }

    public void setInvoicingAddress(Boolean invoicingAddress) {
        set(PROPERTY_INVOICINGADDRESS, invoicingAddress);
    }

    public Boolean isShippingAddress() {
        return (Boolean) get(PROPERTY_SHIPPINGADDRESS);
    }

    public void setShippingAddress(Boolean shippingAddress) {
        set(PROPERTY_SHIPPINGADDRESS, shippingAddress);
    }

    public Boolean isPayFromAddress() {
        return (Boolean) get(PROPERTY_PAYFROMADDRESS);
    }

    public void setPayFromAddress(Boolean payFromAddress) {
        set(PROPERTY_PAYFROMADDRESS, payFromAddress);
    }

    public User getUserContact() {
        return (User) get(PROPERTY_USERCONTACT);
    }

    public void setUserContact(User userContact) {
        set(PROPERTY_USERCONTACT, userContact);
    }

    public User getUserIdEmail() {
        return (User) get(PROPERTY_USERIDEMAIL);
    }

    public void setUserIdEmail(User userIdEmail) {
        set(PROPERTY_USERIDEMAIL, userIdEmail);
    }

    public User getUserIdPhone1() {
        return (User) get(PROPERTY_USERIDPHONE1);
    }

    public void setUserIdPhone1(User userIdPhone1) {
        set(PROPERTY_USERIDPHONE1, userIdPhone1);
    }

    public User getUserIdPhone2() {
        return (User) get(PROPERTY_USERIDPHONE2);
    }

    public void setUserIdPhone2(User userIdPhone2) {
        set(PROPERTY_USERIDPHONE2, userIdPhone2);
    }

    public BusinessPartner getBpartnerIdMail() {
        return (BusinessPartner) get(PROPERTY_BPARTNERIDMAIL);
    }

    public void setBpartnerIdMail(BusinessPartner bpartnerIdMail) {
        set(PROPERTY_BPARTNERIDMAIL, bpartnerIdMail);
    }

}
