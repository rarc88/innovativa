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
package com.sidesoft.hrm.payroll;

import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
/**
 * Entity class for entity sspr_leave_emp_mant (stored in table sspr_leave_emp_mant).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ssprleaveempmant extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sspr_leave_emp_mant";
    public static final String ENTITY_NAME = "sspr_leave_emp_mant";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_REVISION = "revision";
    public static final String PROPERTY_WRITTENBY = "writtenby";
    public static final String PROPERTY_APPROBEDBY = "approbedby";
    public static final String PROPERTY_IDENTIFICACTION = "identificaction";
    public static final String PROPERTY_SGI = "sgi";
    public static final String PROPERTY_VALIDED = "valided";
    public static final String PROPERTY_ORIGINAL = "original";
    public static final String PROPERTY_COPY = "copy";
    public static final String PROPERTY_LEAVETYPE = "leaveType";

    public ssprleaveempmant() {
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

    public String getRevision() {
        return (String) get(PROPERTY_REVISION);
    }

    public void setRevision(String revision) {
        set(PROPERTY_REVISION, revision);
    }

    public String getWrittenby() {
        return (String) get(PROPERTY_WRITTENBY);
    }

    public void setWrittenby(String writtenby) {
        set(PROPERTY_WRITTENBY, writtenby);
    }

    public String getApprobedby() {
        return (String) get(PROPERTY_APPROBEDBY);
    }

    public void setApprobedby(String approbedby) {
        set(PROPERTY_APPROBEDBY, approbedby);
    }

    public String getIdentificaction() {
        return (String) get(PROPERTY_IDENTIFICACTION);
    }

    public void setIdentificaction(String identificaction) {
        set(PROPERTY_IDENTIFICACTION, identificaction);
    }

    public String getSgi() {
        return (String) get(PROPERTY_SGI);
    }

    public void setSgi(String sgi) {
        set(PROPERTY_SGI, sgi);
    }

    public String getValided() {
        return (String) get(PROPERTY_VALIDED);
    }

    public void setValided(String valided) {
        set(PROPERTY_VALIDED, valided);
    }

    public String getOriginal() {
        return (String) get(PROPERTY_ORIGINAL);
    }

    public void setOriginal(String original) {
        set(PROPERTY_ORIGINAL, original);
    }

    public String getCopy() {
        return (String) get(PROPERTY_COPY);
    }

    public void setCopy(String copy) {
        set(PROPERTY_COPY, copy);
    }

    public ssprleavetype getLeaveType() {
        return (ssprleavetype) get(PROPERTY_LEAVETYPE);
    }

    public void setLeaveType(ssprleavetype leaveType) {
        set(PROPERTY_LEAVETYPE, leaveType);
    }

}
