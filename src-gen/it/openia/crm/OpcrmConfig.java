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
package it.openia.crm;

import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.Category;
import org.openbravo.model.common.enterprise.Organization;
/**
 * Entity class for entity opcrm_config (stored in table opcrm_config).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class OpcrmConfig extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "opcrm_config";
    public static final String ENTITY_NAME = "opcrm_config";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_USERCONTACT = "userContact";
    public static final String PROPERTY_ZIMBRAHOST = "zimbraHost";
    public static final String PROPERTY_ZIMBRAPORT = "zimbraPort";
    public static final String PROPERTY_ZIMBRAUSESSL = "zimbraUseSsl";
    public static final String PROPERTY_ZIMBRAUSER = "zimbraUser";
    public static final String PROPERTY_ZIMBRAPASSWORD = "zimbraPassword";
    public static final String PROPERTY_ZIMBRAADDRESSBOOK = "zimbraAddressBook";
    public static final String PROPERTY_ZIMBRASYNCADDRESSBOOK = "zimbraSyncAddressBook";
    public static final String PROPERTY_BUSINESSPARTNERCATEGORY = "businessPartnerCategory";

    public OpcrmConfig() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_ZIMBRAUSESSL, false);
        setDefaultValue(PROPERTY_ZIMBRAADDRESSBOOK, "contacts");
        setDefaultValue(PROPERTY_ZIMBRASYNCADDRESSBOOK, true);
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

    public User getUserContact() {
        return (User) get(PROPERTY_USERCONTACT);
    }

    public void setUserContact(User userContact) {
        set(PROPERTY_USERCONTACT, userContact);
    }

    public String getZimbraHost() {
        return (String) get(PROPERTY_ZIMBRAHOST);
    }

    public void setZimbraHost(String zimbraHost) {
        set(PROPERTY_ZIMBRAHOST, zimbraHost);
    }

    public Long getZimbraPort() {
        return (Long) get(PROPERTY_ZIMBRAPORT);
    }

    public void setZimbraPort(Long zimbraPort) {
        set(PROPERTY_ZIMBRAPORT, zimbraPort);
    }

    public Boolean isZimbraUseSsl() {
        return (Boolean) get(PROPERTY_ZIMBRAUSESSL);
    }

    public void setZimbraUseSsl(Boolean zimbraUseSsl) {
        set(PROPERTY_ZIMBRAUSESSL, zimbraUseSsl);
    }

    public String getZimbraUser() {
        return (String) get(PROPERTY_ZIMBRAUSER);
    }

    public void setZimbraUser(String zimbraUser) {
        set(PROPERTY_ZIMBRAUSER, zimbraUser);
    }

    public String getZimbraPassword() {
        return (String) get(PROPERTY_ZIMBRAPASSWORD);
    }

    public void setZimbraPassword(String zimbraPassword) {
        set(PROPERTY_ZIMBRAPASSWORD, zimbraPassword);
    }

    public String getZimbraAddressBook() {
        return (String) get(PROPERTY_ZIMBRAADDRESSBOOK);
    }

    public void setZimbraAddressBook(String zimbraAddressBook) {
        set(PROPERTY_ZIMBRAADDRESSBOOK, zimbraAddressBook);
    }

    public Boolean isZimbraSyncAddressBook() {
        return (Boolean) get(PROPERTY_ZIMBRASYNCADDRESSBOOK);
    }

    public void setZimbraSyncAddressBook(Boolean zimbraSyncAddressBook) {
        set(PROPERTY_ZIMBRASYNCADDRESSBOOK, zimbraSyncAddressBook);
    }

    public Category getBusinessPartnerCategory() {
        return (Category) get(PROPERTY_BUSINESSPARTNERCATEGORY);
    }

    public void setBusinessPartnerCategory(Category businessPartnerCategory) {
        set(PROPERTY_BUSINESSPARTNERCATEGORY, businessPartnerCategory);
    }

}
