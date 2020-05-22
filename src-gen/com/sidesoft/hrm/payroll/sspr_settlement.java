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

import com.sidesoft.flopec.budget.data.SFBBudgetCertificate;

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
 * Entity class for entity sspr_settlement (stored in table sspr_settlement).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class sspr_settlement extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sspr_settlement";
    public static final String ENTITY_NAME = "sspr_settlement";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DOCTYPE = "doctype";
    public static final String PROPERTY_DOCUMENTNO = "documentno";
    public static final String PROPERTY_MOVEMENTDATE = "movementdate";
    public static final String PROPERTY_DOCUMENTACTION = "documentAction";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_BPARTNER = "bpartner";
    public static final String PROPERTY_REASONENDCONTRACT = "reasonEndContract";
    public static final String PROPERTY_ENDDATECONTRACT = "enddatecontract";
    public static final String PROPERTY_SSPRPAYROLLIDNORMAL = "ssprPayrollIdNormal";
    public static final String PROPERTY_SSPRPAYROLLIDPROVISION = "ssprPayrollIdProvision";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_SSPRCONTRACT = "ssprContract";
    public static final String PROPERTY_DOCUMENTNONEW = "documentnonew";
    public static final String PROPERTY_COMPLETE = "complete";
    public static final String PROPERTY_STATUSPAYROLL = "statusPayroll";
    public static final String PROPERTY_POSTED = "posted";
    public static final String PROPERTY_PROCESSNOW = "processNow";
    public static final String PROPERTY_SFBBUDGETCERTIFICATEEMSSBPSSPRSETTLEMENTIDLIST = "sfbBudgetCertificateEMSsbpSsprSettlementIDList";
    public static final String PROPERTY_SSPRSETTLEMENTDATALIST = "ssprSettlementdataList";
    public static final String PROPERTY_SSPRSETTLEMENTLINELIST = "ssprSettlementlineList";
    public static final String PROPERTY_SSPRVACATIONSLIST = "ssprVacationsList";

    public sspr_settlement() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_DOCUMENTACTION, false);
        setDefaultValue(PROPERTY_PROCESSED, "N");
        setDefaultValue(PROPERTY_COMPLETE, "N");
        setDefaultValue(PROPERTY_POSTED, "N");
        setDefaultValue(PROPERTY_PROCESSNOW, false);
        setDefaultValue(PROPERTY_SFBBUDGETCERTIFICATEEMSSBPSSPRSETTLEMENTIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRSETTLEMENTDATALIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRSETTLEMENTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRVACATIONSLIST, new ArrayList<Object>());
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

    public DocumentType getDoctype() {
        return (DocumentType) get(PROPERTY_DOCTYPE);
    }

    public void setDoctype(DocumentType doctype) {
        set(PROPERTY_DOCTYPE, doctype);
    }

    public String getDocumentno() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentno(String documentno) {
        set(PROPERTY_DOCUMENTNO, documentno);
    }

    public Date getMovementdate() {
        return (Date) get(PROPERTY_MOVEMENTDATE);
    }

    public void setMovementdate(Date movementdate) {
        set(PROPERTY_MOVEMENTDATE, movementdate);
    }

    public Boolean isDocumentAction() {
        return (Boolean) get(PROPERTY_DOCUMENTACTION);
    }

    public void setDocumentAction(Boolean documentAction) {
        set(PROPERTY_DOCUMENTACTION, documentAction);
    }

    public String getProcessed() {
        return (String) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(String processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public BusinessPartner getBpartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBpartner(BusinessPartner bpartner) {
        set(PROPERTY_BPARTNER, bpartner);
    }

    public String getReasonEndContract() {
        return (String) get(PROPERTY_REASONENDCONTRACT);
    }

    public void setReasonEndContract(String reasonEndContract) {
        set(PROPERTY_REASONENDCONTRACT, reasonEndContract);
    }

    public Date getEnddatecontract() {
        return (Date) get(PROPERTY_ENDDATECONTRACT);
    }

    public void setEnddatecontract(Date enddatecontract) {
        set(PROPERTY_ENDDATECONTRACT, enddatecontract);
    }

    public Payroll getSsprPayrollIdNormal() {
        return (Payroll) get(PROPERTY_SSPRPAYROLLIDNORMAL);
    }

    public void setSsprPayrollIdNormal(Payroll ssprPayrollIdNormal) {
        set(PROPERTY_SSPRPAYROLLIDNORMAL, ssprPayrollIdNormal);
    }

    public Payroll getSsprPayrollIdProvision() {
        return (Payroll) get(PROPERTY_SSPRPAYROLLIDPROVISION);
    }

    public void setSsprPayrollIdProvision(Payroll ssprPayrollIdProvision) {
        set(PROPERTY_SSPRPAYROLLIDPROVISION, ssprPayrollIdProvision);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Contract getSsprContract() {
        return (Contract) get(PROPERTY_SSPRCONTRACT);
    }

    public void setSsprContract(Contract ssprContract) {
        set(PROPERTY_SSPRCONTRACT, ssprContract);
    }

    public String getDocumentnonew() {
        return (String) get(PROPERTY_DOCUMENTNONEW);
    }

    public void setDocumentnonew(String documentnonew) {
        set(PROPERTY_DOCUMENTNONEW, documentnonew);
    }

    public String getComplete() {
        return (String) get(PROPERTY_COMPLETE);
    }

    public void setComplete(String complete) {
        set(PROPERTY_COMPLETE, complete);
    }

    public String getStatusPayroll() {
        return (String) get(PROPERTY_STATUSPAYROLL);
    }

    public void setStatusPayroll(String statusPayroll) {
        set(PROPERTY_STATUSPAYROLL, statusPayroll);
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

    @SuppressWarnings("unchecked")
    public List<SFBBudgetCertificate> getSfbBudgetCertificateEMSsbpSsprSettlementIDList() {
      return (List<SFBBudgetCertificate>) get(PROPERTY_SFBBUDGETCERTIFICATEEMSSBPSSPRSETTLEMENTIDLIST);
    }

    public void setSfbBudgetCertificateEMSsbpSsprSettlementIDList(List<SFBBudgetCertificate> sfbBudgetCertificateEMSsbpSsprSettlementIDList) {
        set(PROPERTY_SFBBUDGETCERTIFICATEEMSSBPSSPRSETTLEMENTIDLIST, sfbBudgetCertificateEMSsbpSsprSettlementIDList);
    }

    @SuppressWarnings("unchecked")
    public List<sspr_settlementdata> getSsprSettlementdataList() {
      return (List<sspr_settlementdata>) get(PROPERTY_SSPRSETTLEMENTDATALIST);
    }

    public void setSsprSettlementdataList(List<sspr_settlementdata> ssprSettlementdataList) {
        set(PROPERTY_SSPRSETTLEMENTDATALIST, ssprSettlementdataList);
    }

    @SuppressWarnings("unchecked")
    public List<sspr_settlementline> getSsprSettlementlineList() {
      return (List<sspr_settlementline>) get(PROPERTY_SSPRSETTLEMENTLINELIST);
    }

    public void setSsprSettlementlineList(List<sspr_settlementline> ssprSettlementlineList) {
        set(PROPERTY_SSPRSETTLEMENTLINELIST, ssprSettlementlineList);
    }

    @SuppressWarnings("unchecked")
    public List<ssprvacations> getSsprVacationsList() {
      return (List<ssprvacations>) get(PROPERTY_SSPRVACATIONSLIST);
    }

    public void setSsprVacationsList(List<ssprvacations> ssprVacationsList) {
        set(PROPERTY_SSPRVACATIONSLIST, ssprVacationsList);
    }

}
