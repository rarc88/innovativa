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
package com.sidesoft.hrm.payroll.advanced;

import com.sidesoft.flopec.ssflVesseltype;
import com.sidesoft.hrm.payroll.Position;

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
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.Organization;
/**
 * Entity class for entity sfpr_employee_surrogate (stored in table sfpr_employee_surrogate).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SfprEmployeeSurrogate extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sfpr_employee_surrogate";
    public static final String ENTITY_NAME = "sfpr_employee_surrogate";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_EMPLOYEE = "employee";
    public static final String PROPERTY_STARTINGDATE = "startingDate";
    public static final String PROPERTY_ENDINGDATE = "endingDate";
    public static final String PROPERTY_SFPRMOVEMENTTYPE = "sfprMovementType";
    public static final String PROPERTY_SURROGATETO = "surrogateTo";
    public static final String PROPERTY_LINE = "line";
    public static final String PROPERTY_OBSERVATION = "observation";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_LINKSURROGATE = "linkSurrogate";
    public static final String PROPERTY_SSFLVESSELTYPE = "ssflVesselType";
    public static final String PROPERTY_SFPRSURROGATEDETAILLIST = "sfprSurrogateDetailList";

    public SfprEmployeeSurrogate() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_PROCESSED, false);
        setDefaultValue(PROPERTY_SFPRSURROGATEDETAILLIST, new ArrayList<Object>());
    }

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
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

    public Boolean isActive() {
        return (Boolean) get(PROPERTY_ACTIVE);
    }

    public void setActive(Boolean active) {
        set(PROPERTY_ACTIVE, active);
    }

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
    }

    public BusinessPartner getEmployee() {
        return (BusinessPartner) get(PROPERTY_EMPLOYEE);
    }

    public void setEmployee(BusinessPartner employee) {
        set(PROPERTY_EMPLOYEE, employee);
    }

    public Date getStartingDate() {
        return (Date) get(PROPERTY_STARTINGDATE);
    }

    public void setStartingDate(Date startingDate) {
        set(PROPERTY_STARTINGDATE, startingDate);
    }

    public Date getEndingDate() {
        return (Date) get(PROPERTY_ENDINGDATE);
    }

    public void setEndingDate(Date endingDate) {
        set(PROPERTY_ENDINGDATE, endingDate);
    }

    public SfprMovementType getSfprMovementType() {
        return (SfprMovementType) get(PROPERTY_SFPRMOVEMENTTYPE);
    }

    public void setSfprMovementType(SfprMovementType sfprMovementType) {
        set(PROPERTY_SFPRMOVEMENTTYPE, sfprMovementType);
    }

    public Position getSurrogateTo() {
        return (Position) get(PROPERTY_SURROGATETO);
    }

    public void setSurrogateTo(Position surrogateTo) {
        set(PROPERTY_SURROGATETO, surrogateTo);
    }

    public Long getLine() {
        return (Long) get(PROPERTY_LINE);
    }

    public void setLine(Long line) {
        set(PROPERTY_LINE, line);
    }

    public String getObservation() {
        return (String) get(PROPERTY_OBSERVATION);
    }

    public void setObservation(String observation) {
        set(PROPERTY_OBSERVATION, observation);
    }

    public Boolean isProcessed() {
        return (Boolean) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(Boolean processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public String getLinkSurrogate() {
        return (String) get(PROPERTY_LINKSURROGATE);
    }

    public void setLinkSurrogate(String linkSurrogate) {
        set(PROPERTY_LINKSURROGATE, linkSurrogate);
    }

    public ssflVesseltype getSsflVesselType() {
        return (ssflVesseltype) get(PROPERTY_SSFLVESSELTYPE);
    }

    public void setSsflVesselType(ssflVesseltype ssflVesselType) {
        set(PROPERTY_SSFLVESSELTYPE, ssflVesselType);
    }

    @SuppressWarnings("unchecked")
    public List<SfprSurrogateDetail> getSfprSurrogateDetailList() {
      return (List<SfprSurrogateDetail>) get(PROPERTY_SFPRSURROGATEDETAILLIST);
    }

    public void setSfprSurrogateDetailList(List<SfprSurrogateDetail> sfprSurrogateDetailList) {
        set(PROPERTY_SFPRSURROGATEDETAILLIST, sfprSurrogateDetailList);
    }

}
