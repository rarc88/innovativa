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

import com.sidesoft.ecuador.humanResources.sshrJob;

import java.math.BigDecimal;
import java.sql.Timestamp;
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
import org.openbravo.model.common.enterprise.Organization;
/**
 * Entity class for entity SSPR_Shift (stored in table SSPR_Shift).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Shift extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "SSPR_Shift";
    public static final String ENTITY_NAME = "SSPR_Shift";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_STARTTIME = "starttime";
    public static final String PROPERTY_ENDTIME = "endtime";
    public static final String PROPERTY_ISLUNCH = "islunch";
    public static final String PROPERTY_LUNCHTIMEMIN = "lunchtimemin";
    public static final String PROPERTY_LUNCHTIMEMAX = "lunchtimemax";
    public static final String PROPERTY_SHIFTTYPE = "shifttype";
    public static final String PROPERTY_POSITION = "position";
    public static final String PROPERTY_SSHRHOURSTART = "sshrHourstart";
    public static final String PROPERTY_SSHRHOUREND = "sshrHourend";
    public static final String PROPERTY_ENTRY = "entry";
    public static final String PROPERTY_EXIT = "exit";
    public static final String PROPERTY_NAMEMOVEMENT = "nameMovement";
    public static final String PROPERTY_VALUE = "value";
    public static final String PROPERTY_SSPRCONTRACTLIST = "sSPRContractList";
    public static final String PROPERTY_SSHRJOBLIST = "sshrJobList";

    public Shift() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_ISLUNCH, false);
        setDefaultValue(PROPERTY_SSPRCONTRACTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSHRJOBLIST, new ArrayList<Object>());
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

    public Timestamp getStarttime() {
        return (Timestamp) get(PROPERTY_STARTTIME);
    }

    public void setStarttime(Timestamp starttime) {
        set(PROPERTY_STARTTIME, starttime);
    }

    public Timestamp getEndtime() {
        return (Timestamp) get(PROPERTY_ENDTIME);
    }

    public void setEndtime(Timestamp endtime) {
        set(PROPERTY_ENDTIME, endtime);
    }

    public Boolean isLunch() {
        return (Boolean) get(PROPERTY_ISLUNCH);
    }

    public void setLunch(Boolean islunch) {
        set(PROPERTY_ISLUNCH, islunch);
    }

    public BigDecimal getLunchtimemin() {
        return (BigDecimal) get(PROPERTY_LUNCHTIMEMIN);
    }

    public void setLunchtimemin(BigDecimal lunchtimemin) {
        set(PROPERTY_LUNCHTIMEMIN, lunchtimemin);
    }

    public BigDecimal getLunchtimemax() {
        return (BigDecimal) get(PROPERTY_LUNCHTIMEMAX);
    }

    public void setLunchtimemax(BigDecimal lunchtimemax) {
        set(PROPERTY_LUNCHTIMEMAX, lunchtimemax);
    }

    public String getShifttype() {
        return (String) get(PROPERTY_SHIFTTYPE);
    }

    public void setShifttype(String shifttype) {
        set(PROPERTY_SHIFTTYPE, shifttype);
    }

    public Position getPosition() {
        return (Position) get(PROPERTY_POSITION);
    }

    public void setPosition(Position position) {
        set(PROPERTY_POSITION, position);
    }

    public Timestamp getSshrHourstart() {
        return (Timestamp) get(PROPERTY_SSHRHOURSTART);
    }

    public void setSshrHourstart(Timestamp sshrHourstart) {
        set(PROPERTY_SSHRHOURSTART, sshrHourstart);
    }

    public Timestamp getSshrHourend() {
        return (Timestamp) get(PROPERTY_SSHRHOUREND);
    }

    public void setSshrHourend(Timestamp sshrHourend) {
        set(PROPERTY_SSHRHOUREND, sshrHourend);
    }

    public Timestamp getEntry() {
        return (Timestamp) get(PROPERTY_ENTRY);
    }

    public void setEntry(Timestamp entry) {
        set(PROPERTY_ENTRY, entry);
    }

    public Timestamp getExit() {
        return (Timestamp) get(PROPERTY_EXIT);
    }

    public void setExit(Timestamp exit) {
        set(PROPERTY_EXIT, exit);
    }

    public String getNameMovement() {
        return (String) get(PROPERTY_NAMEMOVEMENT);
    }

    public void setNameMovement(String nameMovement) {
        set(PROPERTY_NAMEMOVEMENT, nameMovement);
    }

    public String getValue() {
        return (String) get(PROPERTY_VALUE);
    }

    public void setValue(String value) {
        set(PROPERTY_VALUE, value);
    }

    @SuppressWarnings("unchecked")
    public List<Contract> getSSPRContractList() {
      return (List<Contract>) get(PROPERTY_SSPRCONTRACTLIST);
    }

    public void setSSPRContractList(List<Contract> sSPRContractList) {
        set(PROPERTY_SSPRCONTRACTLIST, sSPRContractList);
    }

    @SuppressWarnings("unchecked")
    public List<sshrJob> getSshrJobList() {
      return (List<sshrJob>) get(PROPERTY_SSHRJOBLIST);
    }

    public void setSshrJobList(List<sshrJob> sshrJobList) {
        set(PROPERTY_SSHRJOBLIST, sshrJobList);
    }

}
