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
package com.sidesoft.ecuador.asset.move;

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
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.invoice.InvoiceLine;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
/**
 * Entity class for entity ssam_alienate (stored in table ssam_alienate).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ssamalienate extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ssam_alienate";
    public static final String ENTITY_NAME = "ssam_alienate";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_DESCRIPTIONALIENATE = "descriptionAlienate";
    public static final String PROPERTY_POSTED = "posted";
    public static final String PROPERTY_PROCESSNOW = "processNow";
    public static final String PROPERTY_DOCUMENTTYPE = "documentType";
    public static final String PROPERTY_ALERTSTATUS = "alertStatus";
    public static final String PROPERTY_TYPEREASON = "typereason";
    public static final String PROPERTY_SSAMREASONALIENATE = "ssamReasonAlienate";
    public static final String PROPERTY_CREATELINE = "createline";
    public static final String PROPERTY_DATEDOC = "datedoc";
    public static final String PROPERTY_ASSETSTART = "assetstart";
    public static final String PROPERTY_ASSETEND = "assetend";
    public static final String PROPERTY_BPARTNER = "bpartner";
    public static final String PROPERTY_ASSETTYPEPOST = "assettypepost";
    public static final String PROPERTY_INVOICELINEEMSSAMALIENATEIDLIST = "invoiceLineEMSsamAlienateIDList";
    public static final String PROPERTY_SSAMALIENATELINELIST = "ssamAlienatelineList";

    public ssamalienate() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_PROCESSED, "N");
        setDefaultValue(PROPERTY_POSTED, "N");
        setDefaultValue(PROPERTY_PROCESSNOW, false);
        setDefaultValue(PROPERTY_ALERTSTATUS, false);
        setDefaultValue(PROPERTY_CREATELINE, "N");
        setDefaultValue(PROPERTY_ASSETTYPEPOST, "N");
        setDefaultValue(PROPERTY_INVOICELINEEMSSAMALIENATEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSAMALIENATELINELIST, new ArrayList<Object>());
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

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

    public String getProcessed() {
        return (String) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(String processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public String getDescriptionAlienate() {
        return (String) get(PROPERTY_DESCRIPTIONALIENATE);
    }

    public void setDescriptionAlienate(String descriptionAlienate) {
        set(PROPERTY_DESCRIPTIONALIENATE, descriptionAlienate);
    }

    public String getPosted() {
        return (String) get(PROPERTY_POSTED);
    }

    public void setPosted(String posted) {
        set(PROPERTY_POSTED, posted);
    }

    public Boolean isProcessNow() {
        return (Boolean) get(PROPERTY_PROCESSNOW);
    }

    public void setProcessNow(Boolean processNow) {
        set(PROPERTY_PROCESSNOW, processNow);
    }

    public DocumentType getDocumentType() {
        return (DocumentType) get(PROPERTY_DOCUMENTTYPE);
    }

    public void setDocumentType(DocumentType documentType) {
        set(PROPERTY_DOCUMENTTYPE, documentType);
    }

    public Boolean isAlertStatus() {
        return (Boolean) get(PROPERTY_ALERTSTATUS);
    }

    public void setAlertStatus(Boolean alertStatus) {
        set(PROPERTY_ALERTSTATUS, alertStatus);
    }

    public String getTypereason() {
        return (String) get(PROPERTY_TYPEREASON);
    }

    public void setTypereason(String typereason) {
        set(PROPERTY_TYPEREASON, typereason);
    }

    public ssamreasonalienate getSsamReasonAlienate() {
        return (ssamreasonalienate) get(PROPERTY_SSAMREASONALIENATE);
    }

    public void setSsamReasonAlienate(ssamreasonalienate ssamReasonAlienate) {
        set(PROPERTY_SSAMREASONALIENATE, ssamReasonAlienate);
    }

    public String getCreateline() {
        return (String) get(PROPERTY_CREATELINE);
    }

    public void setCreateline(String createline) {
        set(PROPERTY_CREATELINE, createline);
    }

    public Date getDatedoc() {
        return (Date) get(PROPERTY_DATEDOC);
    }

    public void setDatedoc(Date datedoc) {
        set(PROPERTY_DATEDOC, datedoc);
    }

    public Asset getAssetstart() {
        return (Asset) get(PROPERTY_ASSETSTART);
    }

    public void setAssetstart(Asset assetstart) {
        set(PROPERTY_ASSETSTART, assetstart);
    }

    public Asset getAssetend() {
        return (Asset) get(PROPERTY_ASSETEND);
    }

    public void setAssetend(Asset assetend) {
        set(PROPERTY_ASSETEND, assetend);
    }

    public BusinessPartner getBpartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBpartner(BusinessPartner bpartner) {
        set(PROPERTY_BPARTNER, bpartner);
    }

    public String getAssettypepost() {
        return (String) get(PROPERTY_ASSETTYPEPOST);
    }

    public void setAssettypepost(String assettypepost) {
        set(PROPERTY_ASSETTYPEPOST, assettypepost);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceLine> getInvoiceLineEMSsamAlienateIDList() {
      return (List<InvoiceLine>) get(PROPERTY_INVOICELINEEMSSAMALIENATEIDLIST);
    }

    public void setInvoiceLineEMSsamAlienateIDList(List<InvoiceLine> invoiceLineEMSsamAlienateIDList) {
        set(PROPERTY_INVOICELINEEMSSAMALIENATEIDLIST, invoiceLineEMSsamAlienateIDList);
    }

    @SuppressWarnings("unchecked")
    public List<ssamalienateline> getSsamAlienatelineList() {
      return (List<ssamalienateline>) get(PROPERTY_SSAMALIENATELINELIST);
    }

    public void setSsamAlienatelineList(List<ssamalienateline> ssamAlienatelineList) {
        set(PROPERTY_SSAMALIENATELINELIST, ssamAlienatelineList);
    }

}
