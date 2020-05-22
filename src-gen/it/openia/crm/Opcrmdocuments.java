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
package it.openia.crm;

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
 * Entity class for entity opcrm_documents (stored in table opcrm_documents).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Opcrmdocuments extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "opcrm_documents";
    public static final String ENTITY_NAME = "opcrm_documents";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DOCUMENTNAME = "documentName";
    public static final String PROPERTY_DOCUMENTTYPE = "documentType";
    public static final String PROPERTY_PUBLISHDATE = "publishDate";
    public static final String PROPERTY_EXPIRATIONDATE = "expirationDate";
    public static final String PROPERTY_RELATEDDOCUMENT = "relatedDocument";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_REVISION = "revision";
    public static final String PROPERTY_DOCTEMPLATE = "dOCTemplate";
    public static final String PROPERTY_CATEGORY = "category";
    public static final String PROPERTY_SUBCATEGORY = "sUBCategory";
    public static final String PROPERTY_OPCRMDOCSTATUS = "opcrmDocStatus";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_OPCRMDOCUMENTSRELATEDDOCUMENTLIST = "opcrmDocumentsRelatedDocumentList";

    public Opcrmdocuments() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_DOCTEMPLATE, false);
        setDefaultValue(PROPERTY_OPCRMDOCUMENTSRELATEDDOCUMENTLIST, new ArrayList<Object>());
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

    public String getDocumentName() {
        return (String) get(PROPERTY_DOCUMENTNAME);
    }

    public void setDocumentName(String documentName) {
        set(PROPERTY_DOCUMENTNAME, documentName);
    }

    public String getDocumentType() {
        return (String) get(PROPERTY_DOCUMENTTYPE);
    }

    public void setDocumentType(String documentType) {
        set(PROPERTY_DOCUMENTTYPE, documentType);
    }

    public Date getPublishDate() {
        return (Date) get(PROPERTY_PUBLISHDATE);
    }

    public void setPublishDate(Date publishDate) {
        set(PROPERTY_PUBLISHDATE, publishDate);
    }

    public Date getExpirationDate() {
        return (Date) get(PROPERTY_EXPIRATIONDATE);
    }

    public void setExpirationDate(Date expirationDate) {
        set(PROPERTY_EXPIRATIONDATE, expirationDate);
    }

    public Opcrmdocuments getRelatedDocument() {
        return (Opcrmdocuments) get(PROPERTY_RELATEDDOCUMENT);
    }

    public void setRelatedDocument(Opcrmdocuments relatedDocument) {
        set(PROPERTY_RELATEDDOCUMENT, relatedDocument);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Long getRevision() {
        return (Long) get(PROPERTY_REVISION);
    }

    public void setRevision(Long revision) {
        set(PROPERTY_REVISION, revision);
    }

    public Boolean isDOCTemplate() {
        return (Boolean) get(PROPERTY_DOCTEMPLATE);
    }

    public void setDOCTemplate(Boolean dOCTemplate) {
        set(PROPERTY_DOCTEMPLATE, dOCTemplate);
    }

    public String getCategory() {
        return (String) get(PROPERTY_CATEGORY);
    }

    public void setCategory(String category) {
        set(PROPERTY_CATEGORY, category);
    }

    public String getSUBCategory() {
        return (String) get(PROPERTY_SUBCATEGORY);
    }

    public void setSUBCategory(String sUBCategory) {
        set(PROPERTY_SUBCATEGORY, sUBCategory);
    }

    public String getOpcrmDocStatus() {
        return (String) get(PROPERTY_OPCRMDOCSTATUS);
    }

    public void setOpcrmDocStatus(String opcrmDocStatus) {
        set(PROPERTY_OPCRMDOCSTATUS, opcrmDocStatus);
    }

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    @SuppressWarnings("unchecked")
    public List<Opcrmdocuments> getOpcrmDocumentsRelatedDocumentList() {
      return (List<Opcrmdocuments>) get(PROPERTY_OPCRMDOCUMENTSRELATEDDOCUMENTLIST);
    }

    public void setOpcrmDocumentsRelatedDocumentList(List<Opcrmdocuments> opcrmDocumentsRelatedDocumentList) {
        set(PROPERTY_OPCRMDOCUMENTSRELATEDDOCUMENTLIST, opcrmDocumentsRelatedDocumentList);
    }

}
