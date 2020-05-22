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
package com.sidesoft.localization.ecuador.withholdings;

import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
/**
 * Entity class for entity sswh_withholdings_voided (stored in table sswh_withholdings_voided).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SswhWithholdingsVoided extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sswh_withholdings_voided";
    public static final String ENTITY_NAME = "sswh_withholdings_voided";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_DOCUMENTTYPE = "documentType";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_WITHHOLDINGDATE = "withholdingdate";
    public static final String PROPERTY_STABLISHMENT = "stablishment";
    public static final String PROPERTY_SHELL = "shell";
    public static final String PROPERTY_REFERENCENOFROM = "referencenoFrom";
    public static final String PROPERTY_REFERENCENOTO = "referencenoTo";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_DOCTYPE2 = "doctype2";
    public static final String PROPERTY_DOCVOIDED = "dOCVoided";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_AUTHORIZATIONNO = "authorizationno";

    public SswhWithholdingsVoided() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_PROCESSED, "N");
        setDefaultValue(PROPERTY_AUTHORIZATIONNO, "1234567890");
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

    public DocumentType getDocumentType() {
        return (DocumentType) get(PROPERTY_DOCUMENTTYPE);
    }

    public void setDocumentType(DocumentType documentType) {
        set(PROPERTY_DOCUMENTTYPE, documentType);
    }

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

    public Date getWithholdingdate() {
        return (Date) get(PROPERTY_WITHHOLDINGDATE);
    }

    public void setWithholdingdate(Date withholdingdate) {
        set(PROPERTY_WITHHOLDINGDATE, withholdingdate);
    }

    public String getStablishment() {
        return (String) get(PROPERTY_STABLISHMENT);
    }

    public void setStablishment(String stablishment) {
        set(PROPERTY_STABLISHMENT, stablishment);
    }

    public String getShell() {
        return (String) get(PROPERTY_SHELL);
    }

    public void setShell(String shell) {
        set(PROPERTY_SHELL, shell);
    }

    public String getReferencenoFrom() {
        return (String) get(PROPERTY_REFERENCENOFROM);
    }

    public void setReferencenoFrom(String referencenoFrom) {
        set(PROPERTY_REFERENCENOFROM, referencenoFrom);
    }

    public String getReferencenoTo() {
        return (String) get(PROPERTY_REFERENCENOTO);
    }

    public void setReferencenoTo(String referencenoTo) {
        set(PROPERTY_REFERENCENOTO, referencenoTo);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public DocumentType getDoctype2() {
        return (DocumentType) get(PROPERTY_DOCTYPE2);
    }

    public void setDoctype2(DocumentType doctype2) {
        set(PROPERTY_DOCTYPE2, doctype2);
    }

    public String getDOCVoided() {
        return (String) get(PROPERTY_DOCVOIDED);
    }

    public void setDOCVoided(String dOCVoided) {
        set(PROPERTY_DOCVOIDED, dOCVoided);
    }

    public String getProcessed() {
        return (String) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(String processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public String getAuthorizationno() {
        return (String) get(PROPERTY_AUTHORIZATIONNO);
    }

    public void setAuthorizationno(String authorizationno) {
        set(PROPERTY_AUTHORIZATIONNO, authorizationno);
    }

}
