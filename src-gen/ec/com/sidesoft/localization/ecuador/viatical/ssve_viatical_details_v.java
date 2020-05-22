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
 * Entity class for entity ssve_viatical_details_v (stored in table ssve_viatical_details_v).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ssve_viatical_details_v extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ssve_viatical_details_v";
    public static final String ENTITY_NAME = "ssve_viatical_details_v";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_BPARTNER = "bpartner";
    public static final String PROPERTY_SSVEVIATICAL = "ssveViatical";
    public static final String PROPERTY_TOTALAMTVIATICAL = "totalamtViatical";
    public static final String PROPERTY_SSVEVIATICALSETTLEMENT = "ssveViaticalSettlement";
    public static final String PROPERTY_TOTALAMTSETT = "totalamtSett";
    public static final String PROPERTY_SFBBUDGETCERTLINE = "sFBBudgetCertLine";
    public static final String PROPERTY_DOCUMENTSTATUS = "documentStatus";
    public static final String PROPERTY_VIATICALDATE = "viaticaldate";

    public ssve_viatical_details_v() {
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

    public BusinessPartner getBpartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBpartner(BusinessPartner bpartner) {
        set(PROPERTY_BPARTNER, bpartner);
    }

    public SSVEViatical getSsveViatical() {
        return (SSVEViatical) get(PROPERTY_SSVEVIATICAL);
    }

    public void setSsveViatical(SSVEViatical ssveViatical) {
        set(PROPERTY_SSVEVIATICAL, ssveViatical);
    }

    public BigDecimal getTotalamtViatical() {
        return (BigDecimal) get(PROPERTY_TOTALAMTVIATICAL);
    }

    public void setTotalamtViatical(BigDecimal totalamtViatical) {
        set(PROPERTY_TOTALAMTVIATICAL, totalamtViatical);
    }

    public SSVEViaticalSettlement getSsveViaticalSettlement() {
        return (SSVEViaticalSettlement) get(PROPERTY_SSVEVIATICALSETTLEMENT);
    }

    public void setSsveViaticalSettlement(SSVEViaticalSettlement ssveViaticalSettlement) {
        set(PROPERTY_SSVEVIATICALSETTLEMENT, ssveViaticalSettlement);
    }

    public BigDecimal getTotalamtSett() {
        return (BigDecimal) get(PROPERTY_TOTALAMTSETT);
    }

    public void setTotalamtSett(BigDecimal totalamtSett) {
        set(PROPERTY_TOTALAMTSETT, totalamtSett);
    }

    public SFBBudgetCertLine getSFBBudgetCertLine() {
        return (SFBBudgetCertLine) get(PROPERTY_SFBBUDGETCERTLINE);
    }

    public void setSFBBudgetCertLine(SFBBudgetCertLine sFBBudgetCertLine) {
        set(PROPERTY_SFBBUDGETCERTLINE, sFBBudgetCertLine);
    }

    public String getDocumentStatus() {
        return (String) get(PROPERTY_DOCUMENTSTATUS);
    }

    public void setDocumentStatus(String documentStatus) {
        set(PROPERTY_DOCUMENTSTATUS, documentStatus);
    }

    public Date getViaticaldate() {
        return (Date) get(PROPERTY_VIATICALDATE);
    }

    public void setViaticaldate(Date viaticaldate) {
        set(PROPERTY_VIATICALDATE, viaticaldate);
    }

}
