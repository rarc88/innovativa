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

import java.math.BigDecimal;
import java.sql.Timestamp;
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
 * Entity class for entity SSVE_Viatical_Transp (stored in table SSVE_Viatical_Transp).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SSVEViaticalTransp extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "SSVE_Viatical_Transp";
    public static final String ENTITY_NAME = "SSVE_Viatical_Transp";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_SSVEVIATICAL = "ssveViatical";
    public static final String PROPERTY_LINENO = "lineNo";
    public static final String PROPERTY_LINENETAMOUNT = "lineNetAmount";
    public static final String PROPERTY_TRANSPORTATIONTYPE = "transportationtype";
    public static final String PROPERTY_ISREFUNDABLE = "isrefundable";
    public static final String PROPERTY_COMMERCIALNAME = "commercialName";
    public static final String PROPERTY_ROUTE = "route";
    public static final String PROPERTY_DEPARTUREDATE = "departuredate";
    public static final String PROPERTY_ARRIVALDATE = "arrivaldate";
    public static final String PROPERTY_DEPARTURETIME = "departuretime";
    public static final String PROPERTY_ARRIVALTIME = "arrivaltime";
    public static final String PROPERTY_HASHCODE = "hashCode";
    public static final String PROPERTY_ISNOTBUDGETABLE = "isNotBudgetable";
    public static final String PROPERTY_CERTIFICATELINE = "certificateLine";

    public SSVEViaticalTransp() {
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

    public SSVEViatical getSsveViatical() {
        return (SSVEViatical) get(PROPERTY_SSVEVIATICAL);
    }

    public void setSsveViatical(SSVEViatical ssveViatical) {
        set(PROPERTY_SSVEVIATICAL, ssveViatical);
    }

    public Long getLineNo() {
        return (Long) get(PROPERTY_LINENO);
    }

    public void setLineNo(Long lineNo) {
        set(PROPERTY_LINENO, lineNo);
    }

    public BigDecimal getLineNetAmount() {
        return (BigDecimal) get(PROPERTY_LINENETAMOUNT);
    }

    public void setLineNetAmount(BigDecimal lineNetAmount) {
        set(PROPERTY_LINENETAMOUNT, lineNetAmount);
    }

    public String getTransportationtype() {
        return (String) get(PROPERTY_TRANSPORTATIONTYPE);
    }

    public void setTransportationtype(String transportationtype) {
        set(PROPERTY_TRANSPORTATIONTYPE, transportationtype);
    }

    public Boolean isRefundable() {
        return (Boolean) get(PROPERTY_ISREFUNDABLE);
    }

    public void setRefundable(Boolean isrefundable) {
        set(PROPERTY_ISREFUNDABLE, isrefundable);
    }

    public String getCommercialName() {
        return (String) get(PROPERTY_COMMERCIALNAME);
    }

    public void setCommercialName(String commercialName) {
        set(PROPERTY_COMMERCIALNAME, commercialName);
    }

    public String getRoute() {
        return (String) get(PROPERTY_ROUTE);
    }

    public void setRoute(String route) {
        set(PROPERTY_ROUTE, route);
    }

    public Date getDeparturedate() {
        return (Date) get(PROPERTY_DEPARTUREDATE);
    }

    public void setDeparturedate(Date departuredate) {
        set(PROPERTY_DEPARTUREDATE, departuredate);
    }

    public Date getArrivaldate() {
        return (Date) get(PROPERTY_ARRIVALDATE);
    }

    public void setArrivaldate(Date arrivaldate) {
        set(PROPERTY_ARRIVALDATE, arrivaldate);
    }

    public Timestamp getDeparturetime() {
        return (Timestamp) get(PROPERTY_DEPARTURETIME);
    }

    public void setDeparturetime(Timestamp departuretime) {
        set(PROPERTY_DEPARTURETIME, departuretime);
    }

    public Timestamp getArrivaltime() {
        return (Timestamp) get(PROPERTY_ARRIVALTIME);
    }

    public void setArrivaltime(Timestamp arrivaltime) {
        set(PROPERTY_ARRIVALTIME, arrivaltime);
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
