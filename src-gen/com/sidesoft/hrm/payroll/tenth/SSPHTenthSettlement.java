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
package com.sidesoft.hrm.payroll.tenth;

import com.sidesoft.hrm.payroll.LaborRegime;
import com.sidesoft.hrm.payroll.ssprcodeformulary107;

import ec.com.sidesoft.custom.payroll.partialpayment.scppapprovalpayment;

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
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.calendar.Year;
/**
 * Entity class for entity SSPH_Tenth_Settlement (stored in table SSPH_Tenth_Settlement).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SSPHTenthSettlement extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "SSPH_Tenth_Settlement";
    public static final String ENTITY_NAME = "SSPH_Tenth_Settlement";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_DOCUMENTTYPE = "documentType";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_PROCESSNOW = "processNow";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_DOCUMENTSTATUS = "documentStatus";
    public static final String PROPERTY_SETTLEMENTDATE = "settlementdate";
    public static final String PROPERTY_CONCEPT = "concept";
    public static final String PROPERTY_LABORREGIME = "laborRegime";
    public static final String PROPERTY_CREATELINES = "createlines";
    public static final String PROPERTY_YEAR = "year";
    public static final String PROPERTY_SSPRCODEFORMULARY107 = "ssprCodeformulary107";
    public static final String PROPERTY_STARTDATE = "startdate";
    public static final String PROPERTY_ENDDATE = "enddate";
    public static final String PROPERTY_SSPHTENTHSETTLEMENTLINELIST = "sSPHTenthSettlementLineList";
    public static final String PROPERTY_SCPPAPPROVALPAYMENTLIST = "scppApprovalpaymentList";

    public SSPHTenthSettlement() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_PROCESSNOW, false);
        setDefaultValue(PROPERTY_PROCESSED, "N");
        setDefaultValue(PROPERTY_DOCUMENTSTATUS, "DR");
        setDefaultValue(PROPERTY_CREATELINES, false);
        setDefaultValue(PROPERTY_SSPHTENTHSETTLEMENTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCPPAPPROVALPAYMENTLIST, new ArrayList<Object>());
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

    public Boolean isProcessNow() {
        return (Boolean) get(PROPERTY_PROCESSNOW);
    }

    public void setProcessNow(Boolean processNow) {
        set(PROPERTY_PROCESSNOW, processNow);
    }

    public String getProcessed() {
        return (String) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(String processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public String getDocumentStatus() {
        return (String) get(PROPERTY_DOCUMENTSTATUS);
    }

    public void setDocumentStatus(String documentStatus) {
        set(PROPERTY_DOCUMENTSTATUS, documentStatus);
    }

    public Date getSettlementdate() {
        return (Date) get(PROPERTY_SETTLEMENTDATE);
    }

    public void setSettlementdate(Date settlementdate) {
        set(PROPERTY_SETTLEMENTDATE, settlementdate);
    }

    public String getConcept() {
        return (String) get(PROPERTY_CONCEPT);
    }

    public void setConcept(String concept) {
        set(PROPERTY_CONCEPT, concept);
    }

    public LaborRegime getLaborRegime() {
        return (LaborRegime) get(PROPERTY_LABORREGIME);
    }

    public void setLaborRegime(LaborRegime laborRegime) {
        set(PROPERTY_LABORREGIME, laborRegime);
    }

    public Boolean isCreatelines() {
        return (Boolean) get(PROPERTY_CREATELINES);
    }

    public void setCreatelines(Boolean createlines) {
        set(PROPERTY_CREATELINES, createlines);
    }

    public Year getYear() {
        return (Year) get(PROPERTY_YEAR);
    }

    public void setYear(Year year) {
        set(PROPERTY_YEAR, year);
    }

    public ssprcodeformulary107 getSsprCodeformulary107() {
        return (ssprcodeformulary107) get(PROPERTY_SSPRCODEFORMULARY107);
    }

    public void setSsprCodeformulary107(ssprcodeformulary107 ssprCodeformulary107) {
        set(PROPERTY_SSPRCODEFORMULARY107, ssprCodeformulary107);
    }

    public Date getStartdate() {
        return (Date) get(PROPERTY_STARTDATE);
    }

    public void setStartdate(Date startdate) {
        set(PROPERTY_STARTDATE, startdate);
    }

    public Date getEnddate() {
        return (Date) get(PROPERTY_ENDDATE);
    }

    public void setEnddate(Date enddate) {
        set(PROPERTY_ENDDATE, enddate);
    }

    @SuppressWarnings("unchecked")
    public List<SSPHTenthSettlementLine> getSSPHTenthSettlementLineList() {
      return (List<SSPHTenthSettlementLine>) get(PROPERTY_SSPHTENTHSETTLEMENTLINELIST);
    }

    public void setSSPHTenthSettlementLineList(List<SSPHTenthSettlementLine> sSPHTenthSettlementLineList) {
        set(PROPERTY_SSPHTENTHSETTLEMENTLINELIST, sSPHTenthSettlementLineList);
    }

    @SuppressWarnings("unchecked")
    public List<scppapprovalpayment> getScppApprovalpaymentList() {
      return (List<scppapprovalpayment>) get(PROPERTY_SCPPAPPROVALPAYMENTLIST);
    }

    public void setScppApprovalpaymentList(List<scppapprovalpayment> scppApprovalpaymentList) {
        set(PROPERTY_SCPPAPPROVALPAYMENTLIST, scppApprovalpaymentList);
    }

}
