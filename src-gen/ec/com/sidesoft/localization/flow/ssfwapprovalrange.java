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

import java.math.BigDecimal;
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
/**
 * Entity class for entity ssfw_approval_range (stored in table ssfw_approval_range).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ssfwapprovalrange extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ssfw_approval_range";
    public static final String ENTITY_NAME = "ssfw_approval_range";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_SSFWAPPROVALDOCTYPE = "ssfwApprovalDoctype";
    public static final String PROPERTY_RANGEBEGIN = "rangeBegin";
    public static final String PROPERTY_RANGEEND = "rangeEnd";
    public static final String PROPERTY_APPROVER1STLEVEL = "approver1stLevel";
    public static final String PROPERTY_APPROVER2NDLEVEL = "approver2ndLevel";
    public static final String PROPERTY_APPROVERSIMPLE = "approverSimple";
    public static final String PROPERTY_DESCRIPTION = "description";

    public ssfwapprovalrange() {
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

    public ssfwapprovaldoctype getSsfwApprovalDoctype() {
        return (ssfwapprovaldoctype) get(PROPERTY_SSFWAPPROVALDOCTYPE);
    }

    public void setSsfwApprovalDoctype(ssfwapprovaldoctype ssfwApprovalDoctype) {
        set(PROPERTY_SSFWAPPROVALDOCTYPE, ssfwApprovalDoctype);
    }

    public BigDecimal getRangeBegin() {
        return (BigDecimal) get(PROPERTY_RANGEBEGIN);
    }

    public void setRangeBegin(BigDecimal rangeBegin) {
        set(PROPERTY_RANGEBEGIN, rangeBegin);
    }

    public BigDecimal getRangeEnd() {
        return (BigDecimal) get(PROPERTY_RANGEEND);
    }

    public void setRangeEnd(BigDecimal rangeEnd) {
        set(PROPERTY_RANGEEND, rangeEnd);
    }

    public BusinessPartner getApprover1stLevel() {
        return (BusinessPartner) get(PROPERTY_APPROVER1STLEVEL);
    }

    public void setApprover1stLevel(BusinessPartner approver1stLevel) {
        set(PROPERTY_APPROVER1STLEVEL, approver1stLevel);
    }

    public BusinessPartner getApprover2ndLevel() {
        return (BusinessPartner) get(PROPERTY_APPROVER2NDLEVEL);
    }

    public void setApprover2ndLevel(BusinessPartner approver2ndLevel) {
        set(PROPERTY_APPROVER2NDLEVEL, approver2ndLevel);
    }

    public BusinessPartner getApproverSimple() {
        return (BusinessPartner) get(PROPERTY_APPROVERSIMPLE);
    }

    public void setApproverSimple(BusinessPartner approverSimple) {
        set(PROPERTY_APPROVERSIMPLE, approverSimple);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

}
