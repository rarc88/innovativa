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
package ec.com.sidesoft.localization.ecuador.viatical;

import com.sidesoft.flopec.budget.data.SFBBudgetCertLine;

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
 * Entity class for entity SSVE_ViatSettl_Transp (stored in table SSVE_ViatSettl_Transp).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SSVEViatSettlTransp extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "SSVE_ViatSettl_Transp";
    public static final String ENTITY_NAME = "SSVE_ViatSettl_Transp";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_SSVEVIATICALSETTLEMENT = "ssveViaticalSettlement";
    public static final String PROPERTY_LINENO = "lineNo";
    public static final String PROPERTY_LINENETAMOUNT = "lineNetAmount";
    public static final String PROPERTY_TRANSPORTATIONTYPE = "transportationType";
    public static final String PROPERTY_ISREFUNDABLE = "isrefundable";
    public static final String PROPERTY_NAMEIESSRATE = "nameIESSRate";
    public static final String PROPERTY_ROUTE = "route";
    public static final String PROPERTY_DEPARTUREDATE = "departureDate";
    public static final String PROPERTY_ARRIVALDATE = "arrivalDate";
    public static final String PROPERTY_DEPARTURETIME = "departureTime";
    public static final String PROPERTY_ARRIVALTIME = "arrivalTime";
    public static final String PROPERTY_HASHCODE = "hashCode";
    public static final String PROPERTY_ISNOTBUDGETABLE = "isNotBudgetable";
    public static final String PROPERTY_CERTIFICATELINE = "certificateLine";

    public SSVEViatSettlTransp() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_ISREFUNDABLE, false);
        setDefaultValue(PROPERTY_ISNOTBUDGETABLE, false);
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

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public SSVEViaticalSettlement getSsveViaticalSettlement() {
        return (SSVEViaticalSettlement) get(PROPERTY_SSVEVIATICALSETTLEMENT);
    }

    public void setSsveViaticalSettlement(SSVEViaticalSettlement ssveViaticalSettlement) {
        set(PROPERTY_SSVEVIATICALSETTLEMENT, ssveViaticalSettlement);
    }

    public Long getLineNo() {
        return (Long) get(PROPERTY_LINENO);
    }

    public void setLineNo(Long lineNo) {
        set(PROPERTY_LINENO, lineNo);
    }

    public Long getLineNetAmount() {
        return (Long) get(PROPERTY_LINENETAMOUNT);
    }

    public void setLineNetAmount(Long lineNetAmount) {
        set(PROPERTY_LINENETAMOUNT, lineNetAmount);
    }

    public String getTransportationType() {
        return (String) get(PROPERTY_TRANSPORTATIONTYPE);
    }

    public void setTransportationType(String transportationType) {
        set(PROPERTY_TRANSPORTATIONTYPE, transportationType);
    }

    public Boolean isRefundable() {
        return (Boolean) get(PROPERTY_ISREFUNDABLE);
    }

    public void setRefundable(Boolean isrefundable) {
        set(PROPERTY_ISREFUNDABLE, isrefundable);
    }

    public String getNameIESSRate() {
        return (String) get(PROPERTY_NAMEIESSRATE);
    }

    public void setNameIESSRate(String nameIESSRate) {
        set(PROPERTY_NAMEIESSRATE, nameIESSRate);
    }

    public String getRoute() {
        return (String) get(PROPERTY_ROUTE);
    }

    public void setRoute(String route) {
        set(PROPERTY_ROUTE, route);
    }

    public Date getDepartureDate() {
        return (Date) get(PROPERTY_DEPARTUREDATE);
    }

    public void setDepartureDate(Date departureDate) {
        set(PROPERTY_DEPARTUREDATE, departureDate);
    }

    public Date getArrivalDate() {
        return (Date) get(PROPERTY_ARRIVALDATE);
    }

    public void setArrivalDate(Date arrivalDate) {
        set(PROPERTY_ARRIVALDATE, arrivalDate);
    }

    public Date getDepartureTime() {
        return (Date) get(PROPERTY_DEPARTURETIME);
    }

    public void setDepartureTime(Date departureTime) {
        set(PROPERTY_DEPARTURETIME, departureTime);
    }

    public Date getArrivalTime() {
        return (Date) get(PROPERTY_ARRIVALTIME);
    }

    public void setArrivalTime(Date arrivalTime) {
        set(PROPERTY_ARRIVALTIME, arrivalTime);
    }

    public String getHashCode() {
        return (String) get(PROPERTY_HASHCODE);
    }

    public void setHashCode(String hashCode) {
        set(PROPERTY_HASHCODE, hashCode);
    }

    public Boolean isNotBudgetable() {
        return (Boolean) get(PROPERTY_ISNOTBUDGETABLE);
    }

    public void setNotBudgetable(Boolean isNotBudgetable) {
        set(PROPERTY_ISNOTBUDGETABLE, isNotBudgetable);
    }

    public SFBBudgetCertLine getCertificateLine() {
        return (SFBBudgetCertLine) get(PROPERTY_CERTIFICATELINE);
    }

    public void setCertificateLine(SFBBudgetCertLine certificateLine) {
        set(PROPERTY_CERTIFICATELINE, certificateLine);
    }

}
