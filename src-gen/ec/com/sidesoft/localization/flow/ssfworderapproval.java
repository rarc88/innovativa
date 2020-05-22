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
package ec.com.sidesoft.localization.flow;

import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.order.Order;
/**
 * Entity class for entity ssfw_order_approval (stored in table ssfw_order_approval).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ssfworderapproval extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ssfw_order_approval";
    public static final String ENTITY_NAME = "ssfw_order_approval";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ORDER = "order";
    public static final String PROPERTY_APPROVER1STLEVEL = "approver1stLevel";
    public static final String PROPERTY_APPROVAL1 = "approval1";
    public static final String PROPERTY_APPROVER2NDLEVEL = "approver2ndLevel";
    public static final String PROPERTY_APPROVAL2 = "approval2";
    public static final String PROPERTY_OBSERVATIONS1 = "observations1";
    public static final String PROPERTY_OBSERVATIONS2 = "observations2";

    public ssfworderapproval() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_APPROVAL1, false);
        setDefaultValue(PROPERTY_APPROVAL2, false);
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

    public Order getOrder() {
        return (Order) get(PROPERTY_ORDER);
    }

    public void setOrder(Order order) {
        set(PROPERTY_ORDER, order);
    }

    public BusinessPartner getApprover1stLevel() {
        return (BusinessPartner) get(PROPERTY_APPROVER1STLEVEL);
    }

    public void setApprover1stLevel(BusinessPartner approver1stLevel) {
        set(PROPERTY_APPROVER1STLEVEL, approver1stLevel);
    }

    public Boolean isApproval1() {
        return (Boolean) get(PROPERTY_APPROVAL1);
    }

    public void setApproval1(Boolean approval1) {
        set(PROPERTY_APPROVAL1, approval1);
    }

    public BusinessPartner getApprover2ndLevel() {
        return (BusinessPartner) get(PROPERTY_APPROVER2NDLEVEL);
    }

    public void setApprover2ndLevel(BusinessPartner approver2ndLevel) {
        set(PROPERTY_APPROVER2NDLEVEL, approver2ndLevel);
    }

    public Boolean isApproval2() {
        return (Boolean) get(PROPERTY_APPROVAL2);
    }

    public void setApproval2(Boolean approval2) {
        set(PROPERTY_APPROVAL2, approval2);
    }

    public String getObservations1() {
        return (String) get(PROPERTY_OBSERVATIONS1);
    }

    public void setObservations1(String observations1) {
        set(PROPERTY_OBSERVATIONS1, observations1);
    }

    public String getObservations2() {
        return (String) get(PROPERTY_OBSERVATIONS2);
    }

    public void setObservations2(String observations2) {
        set(PROPERTY_OBSERVATIONS2, observations2);
    }

}
