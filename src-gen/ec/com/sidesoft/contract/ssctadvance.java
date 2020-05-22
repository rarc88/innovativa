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
package ec.com.sidesoft.contract;

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
 * Entity class for entity ssct_advance (stored in table ssct_advance).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ssctadvance extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ssct_advance";
    public static final String ENTITY_NAME = "ssct_advance";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_CONTRACT = "contract";
    public static final String PROPERTY_ACTIVITY = "activity";
    public static final String PROPERTY_DATESTART = "dateStart";
    public static final String PROPERTY_DATEEND = "dateEnd";
    public static final String PROPERTY_ADVANCE = "advance";
    public static final String PROPERTY_OBSERVATIONS = "observations";
    public static final String PROPERTY_LINENO = "lineNo";
    public static final String PROPERTY_RENOVATIONNO = "renovationno";
    public static final String PROPERTY_PREVENTIONDAY = "preventionday";
    public static final String PROPERTY_STATUS = "status";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_UNPROCESSED = "unprocessed";

    public ssctadvance() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_ADVANCE, (long) 0);
        setDefaultValue(PROPERTY_RENOVATIONNO, (long) 0);
        setDefaultValue(PROPERTY_PREVENTIONDAY, (long) 0);
        setDefaultValue(PROPERTY_STATUS, "PE");
        setDefaultValue(PROPERTY_PROCESSED, false);
        setDefaultValue(PROPERTY_UNPROCESSED, true);
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

    public ssctcontract getContract() {
        return (ssctcontract) get(PROPERTY_CONTRACT);
    }

    public void setContract(ssctcontract contract) {
        set(PROPERTY_CONTRACT, contract);
    }

    public String getActivity() {
        return (String) get(PROPERTY_ACTIVITY);
    }

    public void setActivity(String activity) {
        set(PROPERTY_ACTIVITY, activity);
    }

    public Date getDateStart() {
        return (Date) get(PROPERTY_DATESTART);
    }

    public void setDateStart(Date dateStart) {
        set(PROPERTY_DATESTART, dateStart);
    }

    public Date getDateEnd() {
        return (Date) get(PROPERTY_DATEEND);
    }

    public void setDateEnd(Date dateEnd) {
        set(PROPERTY_DATEEND, dateEnd);
    }

    public Long getAdvance() {
        return (Long) get(PROPERTY_ADVANCE);
    }

    public void setAdvance(Long advance) {
        set(PROPERTY_ADVANCE, advance);
    }

    public String getObservations() {
        return (String) get(PROPERTY_OBSERVATIONS);
    }

    public void setObservations(String observations) {
        set(PROPERTY_OBSERVATIONS, observations);
    }

    public Long getLineNo() {
        return (Long) get(PROPERTY_LINENO);
    }

    public void setLineNo(Long lineNo) {
        set(PROPERTY_LINENO, lineNo);
    }

    public Long getRenovationno() {
        return (Long) get(PROPERTY_RENOVATIONNO);
    }

    public void setRenovationno(Long renovationno) {
        set(PROPERTY_RENOVATIONNO, renovationno);
    }

    public Long getPreventionday() {
        return (Long) get(PROPERTY_PREVENTIONDAY);
    }

    public void setPreventionday(Long preventionday) {
        set(PROPERTY_PREVENTIONDAY, preventionday);
    }

    public String getStatus() {
        return (String) get(PROPERTY_STATUS);
    }

    public void setStatus(String status) {
        set(PROPERTY_STATUS, status);
    }

    public Boolean isProcessed() {
        return (Boolean) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(Boolean processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public Boolean isUnprocessed() {
        return (Boolean) get(PROPERTY_UNPROCESSED);
    }

    public void setUnprocessed(Boolean unprocessed) {
        set(PROPERTY_UNPROCESSED, unprocessed);
    }

}
