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

import java.math.BigDecimal;
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
/**
 * Entity class for entity sspr_loans (stored in table sspr_loans).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ssprloans extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sspr_loans";
    public static final String ENTITY_NAME = "sspr_loans";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_PREVIOUSBALANCE = "previousBalance";
    public static final String PROPERTY_REQUESTDATE = "requestdate";
    public static final String PROPERTY_AMOUNT = "amount";
    public static final String PROPERTY_INTEREST = "interest";
    public static final String PROPERTY_STATUS = "status";
    public static final String PROPERTY_FIRSTDATE = "firstdate";
    public static final String PROPERTY_TIME = "time";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_COMPLETE = "complete";
    public static final String PROPERTY_CONCEPT = "concept";
    public static final String PROPERTY_SSPRTYPEGUARANTOR = "ssprTypeguarantor";
    public static final String PROPERTY_GUARANTOR = "guarantor";
    public static final String PROPERTY_APPLY = "apply";
    public static final String PROPERTY_APPROVE = "approve";
    public static final String PROPERTY_SFPRCDOCTYPE = "sfprCDoctype";
    public static final String PROPERTY_SFPRDOCUMENTNO = "sfprDocumentno";
    public static final String PROPERTY_SFPRSENDEMAIL = "sfprSendemail";
    public static final String PROPERTY_REACTIVE = "reactive";
    public static final String PROPERTY_SSPRLINELOANSLIST = "ssprLineLoansList";

    public ssprloans() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_STATUS, "dr");
        setDefaultValue(PROPERTY_COMPLETE, false);
        setDefaultValue(PROPERTY_APPLY, false);
        setDefaultValue(PROPERTY_APPROVE, false);
        setDefaultValue(PROPERTY_SFPRSENDEMAIL, false);
        setDefaultValue(PROPERTY_REACTIVE, false);
        setDefaultValue(PROPERTY_SSPRLINELOANSLIST, new ArrayList<Object>());
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

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public Long getPreviousBalance() {
        return (Long) get(PROPERTY_PREVIOUSBALANCE);
    }

    public void setPreviousBalance(Long previousBalance) {
        set(PROPERTY_PREVIOUSBALANCE, previousBalance);
    }

    public Date getRequestdate() {
        return (Date) get(PROPERTY_REQUESTDATE);
    }

    public void setRequestdate(Date requestdate) {
        set(PROPERTY_REQUESTDATE, requestdate);
    }

    public BigDecimal getAmount() {
        return (BigDecimal) get(PROPERTY_AMOUNT);
    }

    public void setAmount(BigDecimal amount) {
        set(PROPERTY_AMOUNT, amount);
    }

    public String getInterest() {
        return (String) get(PROPERTY_INTEREST);
    }

    public void setInterest(String interest) {
        set(PROPERTY_INTEREST, interest);
    }

    public String getStatus() {
        return (String) get(PROPERTY_STATUS);
    }

    public void setStatus(String status) {
        set(PROPERTY_STATUS, status);
    }

    public Date getFirstdate() {
        return (Date) get(PROPERTY_FIRSTDATE);
    }

    public void setFirstdate(Date firstdate) {
        set(PROPERTY_FIRSTDATE, firstdate);
    }

    public Long getTime() {
        return (Long) get(PROPERTY_TIME);
    }

    public void setTime(Long time) {
        set(PROPERTY_TIME, time);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Boolean isComplete() {
        return (Boolean) get(PROPERTY_COMPLETE);
    }

    public void setComplete(Boolean complete) {
        set(PROPERTY_COMPLETE, complete);
    }

    public Concept getConcept() {
        return (Concept) get(PROPERTY_CONCEPT);
    }

    public void setConcept(Concept concept) {
        set(PROPERTY_CONCEPT, concept);
    }

    public SsprTypeguarantor getSsprTypeguarantor() {
        return (SsprTypeguarantor) get(PROPERTY_SSPRTYPEGUARANTOR);
    }

    public void setSsprTypeguarantor(SsprTypeguarantor ssprTypeguarantor) {
        set(PROPERTY_SSPRTYPEGUARANTOR, ssprTypeguarantor);
    }

    public String getGuarantor() {
        return (String) get(PROPERTY_GUARANTOR);
    }

    public void setGuarantor(String guarantor) {
        set(PROPERTY_GUARANTOR, guarantor);
    }

    public Boolean isApply() {
        return (Boolean) get(PROPERTY_APPLY);
    }

    public void setApply(Boolean apply) {
        set(PROPERTY_APPLY, apply);
    }

    public Boolean isApprove() {
        return (Boolean) get(PROPERTY_APPROVE);
    }

    public void setApprove(Boolean approve) {
        set(PROPERTY_APPROVE, approve);
    }

    public DocumentType getSfprCDoctype() {
        return (DocumentType) get(PROPERTY_SFPRCDOCTYPE);
    }

    public void setSfprCDoctype(DocumentType sfprCDoctype) {
        set(PROPERTY_SFPRCDOCTYPE, sfprCDoctype);
    }

    public String getSfprDocumentno() {
        return (String) get(PROPERTY_SFPRDOCUMENTNO);
    }

    public void setSfprDocumentno(String sfprDocumentno) {
        set(PROPERTY_SFPRDOCUMENTNO, sfprDocumentno);
    }

    public Boolean isSfprSendemail() {
        return (Boolean) get(PROPERTY_SFPRSENDEMAIL);
    }

    public void setSfprSendemail(Boolean sfprSendemail) {
        set(PROPERTY_SFPRSENDEMAIL, sfprSendemail);
    }

    public Boolean isReactive() {
        return (Boolean) get(PROPERTY_REACTIVE);
    }

    public void setReactive(Boolean reactive) {
        set(PROPERTY_REACTIVE, reactive);
    }

    @SuppressWarnings("unchecked")
    public List<ssprline_loans> getSsprLineLoansList() {
      return (List<ssprline_loans>) get(PROPERTY_SSPRLINELOANSLIST);
    }

    public void setSsprLineLoansList(List<ssprline_loans> ssprLineLoansList) {
        set(PROPERTY_SSPRLINELOANSLIST, ssprLineLoansList);
    }

}
