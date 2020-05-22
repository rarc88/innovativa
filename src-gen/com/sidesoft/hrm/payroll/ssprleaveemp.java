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

import com.sidesoft.ecuador.humanResources.sshrDepartment;

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
import org.openbravo.model.common.geography.City;
import org.openbravo.model.financialmgmt.accounting.Costcenter;
/**
 * Entity class for entity SSPR_Leave_Emp (stored in table SSPR_Leave_Emp).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ssprleaveemp extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "SSPR_Leave_Emp";
    public static final String ENTITY_NAME = "SSPR_Leave_Emp";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_STARDATE = "stardate";
    public static final String PROPERTY_ENDINGDATE = "endingDate";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_STATUS = "status";
    public static final String PROPERTY_LEAVETYPE = "leaveType";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_ADDTOVACANCIES = "addToVacancies";
    public static final String PROPERTY_NOHOURS = "noHours";
    public static final String PROPERTY_NODAYS = "noDays";
    public static final String PROPERTY_SFPRALERTSEND = "sfprAlertsend";
    public static final String PROPERTY_ISDISCOUNTLABORDAY = "isdiscountlaborday";
    public static final String PROPERTY_STATUSAPPROVE = "statusApprove";
    public static final String PROPERTY_STATUSREQUEST = "statusRequest";
    public static final String PROPERTY_LEAVECATEGORY = "leaveCategory";
    public static final String PROPERTY_STARTHOUR = "startHour";
    public static final String PROPERTY_ENDHOUR = "endHour";
    public static final String PROPERTY_WHOREPLACE = "whoReplace";
    public static final String PROPERTY_AUTHORIZED = "authorized";
    public static final String PROPERTY_DETAILSSINISTER = "detailsSinister";
    public static final String PROPERTY_DATESINISTER = "dateSinister";
    public static final String PROPERTY_DETAILSNAMES = "detailsNames";
    public static final String PROPERTY_RELATIONSHIP = "relationship";
    public static final String PROPERTY_DATEDEATH = "dateDeath";
    public static final String PROPERTY_OFICIALSPECS = "oficialSpecs";
    public static final String PROPERTY_STATUSSOL = "statusSol";
    public static final String PROPERTY_CURRENTUSER = "currentUser";
    public static final String PROPERTY_COSTCENTER = "costCenter";
    public static final String PROPERTY_DOCUMENTTYPE = "documentType";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_SSHRDEPARTMENT = "sSHRDepartment";
    public static final String PROPERTY_CLOSED = "closed";
    public static final String PROPERTY_AUTHORIZEDDATE = "authorizedDate";
    public static final String PROPERTY_SPECS = "specs";
    public static final String PROPERTY_CITY = "city";
    public static final String PROPERTY_TYPEVACATIONS = "typevacations";
    public static final String PROPERTY_STARDATEABSENT = "stardateabsent";
    public static final String PROPERTY_PAIDVACATIONS = "paidVacations";
    public static final String PROPERTY_PROCESSREACTIVE = "processReactive";
    public static final String PROPERTY_APPROVEDSTATUS = "approvedStatus";
    public static final String PROPERTY_SSPRLEAVEEMPDETAILSLIST = "ssprLeaveEmpDetailsList";
    public static final String PROPERTY_SSPRLEAVEEMPVACLIST = "ssprLeaveEmpVacList";
    public static final String PROPERTY_SSPRLEAVEGROUPLIST = "ssprLeaveGroupList";

    public ssprleaveemp() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_STATUS, "ad");
        setDefaultValue(PROPERTY_ADDTOVACANCIES, false);
        setDefaultValue(PROPERTY_NOHOURS, new BigDecimal(0));
        setDefaultValue(PROPERTY_NODAYS, (long) 1);
        setDefaultValue(PROPERTY_SFPRALERTSEND, false);
        setDefaultValue(PROPERTY_ISDISCOUNTLABORDAY, false);
        setDefaultValue(PROPERTY_STATUSAPPROVE, "pe");
        setDefaultValue(PROPERTY_CLOSED, false);
        setDefaultValue(PROPERTY_SPECS, "NO");
        setDefaultValue(PROPERTY_PAIDVACATIONS, false);
        setDefaultValue(PROPERTY_PROCESSREACTIVE, false);
        setDefaultValue(PROPERTY_APPROVEDSTATUS, false);
        setDefaultValue(PROPERTY_SSPRLEAVEEMPDETAILSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRLEAVEEMPVACLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRLEAVEGROUPLIST, new ArrayList<Object>());
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

    public Date getStardate() {
        return (Date) get(PROPERTY_STARDATE);
    }

    public void setStardate(Date stardate) {
        set(PROPERTY_STARDATE, stardate);
    }

    public Date getEndingDate() {
        return (Date) get(PROPERTY_ENDINGDATE);
    }

    public void setEndingDate(Date endingDate) {
        set(PROPERTY_ENDINGDATE, endingDate);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public String getStatus() {
        return (String) get(PROPERTY_STATUS);
    }

    public void setStatus(String status) {
        set(PROPERTY_STATUS, status);
    }

    public ssprleavetype getLeaveType() {
        return (ssprleavetype) get(PROPERTY_LEAVETYPE);
    }

    public void setLeaveType(ssprleavetype leaveType) {
        set(PROPERTY_LEAVETYPE, leaveType);
    }

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public Boolean isAddToVacancies() {
        return (Boolean) get(PROPERTY_ADDTOVACANCIES);
    }

    public void setAddToVacancies(Boolean addToVacancies) {
        set(PROPERTY_ADDTOVACANCIES, addToVacancies);
    }

    public BigDecimal getNoHours() {
        return (BigDecimal) get(PROPERTY_NOHOURS);
    }

    public void setNoHours(BigDecimal noHours) {
        set(PROPERTY_NOHOURS, noHours);
    }

    public Long getNoDays() {
        return (Long) get(PROPERTY_NODAYS);
    }

    public void setNoDays(Long noDays) {
        set(PROPERTY_NODAYS, noDays);
    }

    public Boolean isSfprAlertsend() {
        return (Boolean) get(PROPERTY_SFPRALERTSEND);
    }

    public void setSfprAlertsend(Boolean sfprAlertsend) {
        set(PROPERTY_SFPRALERTSEND, sfprAlertsend);
    }

    public Boolean isDiscountlaborday() {
        return (Boolean) get(PROPERTY_ISDISCOUNTLABORDAY);
    }

    public void setDiscountlaborday(Boolean isdiscountlaborday) {
        set(PROPERTY_ISDISCOUNTLABORDAY, isdiscountlaborday);
    }

    public String getStatusApprove() {
        return (String) get(PROPERTY_STATUSAPPROVE);
    }

    public void setStatusApprove(String statusApprove) {
        set(PROPERTY_STATUSAPPROVE, statusApprove);
    }

    public String getStatusRequest() {
        return (String) get(PROPERTY_STATUSREQUEST);
    }

    public void setStatusRequest(String statusRequest) {
        set(PROPERTY_STATUSREQUEST, statusRequest);
    }

    public ssprleavecategory getLeaveCategory() {
        return (ssprleavecategory) get(PROPERTY_LEAVECATEGORY);
    }

    public void setLeaveCategory(ssprleavecategory leaveCategory) {
        set(PROPERTY_LEAVECATEGORY, leaveCategory);
    }

    public Date getStartHour() {
        return (Date) get(PROPERTY_STARTHOUR);
    }

    public void setStartHour(Date startHour) {
        set(PROPERTY_STARTHOUR, startHour);
    }

    public Date getEndHour() {
        return (Date) get(PROPERTY_ENDHOUR);
    }

    public void setEndHour(Date endHour) {
        set(PROPERTY_ENDHOUR, endHour);
    }

    public BusinessPartner getWhoReplace() {
        return (BusinessPartner) get(PROPERTY_WHOREPLACE);
    }

    public void setWhoReplace(BusinessPartner whoReplace) {
        set(PROPERTY_WHOREPLACE, whoReplace);
    }

    public BusinessPartner getAuthorized() {
        return (BusinessPartner) get(PROPERTY_AUTHORIZED);
    }

    public void setAuthorized(BusinessPartner authorized) {
        set(PROPERTY_AUTHORIZED, authorized);
    }

    public String getDetailsSinister() {
        return (String) get(PROPERTY_DETAILSSINISTER);
    }

    public void setDetailsSinister(String detailsSinister) {
        set(PROPERTY_DETAILSSINISTER, detailsSinister);
    }

    public Date getDateSinister() {
        return (Date) get(PROPERTY_DATESINISTER);
    }

    public void setDateSinister(Date dateSinister) {
        set(PROPERTY_DATESINISTER, dateSinister);
    }

    public String getDetailsNames() {
        return (String) get(PROPERTY_DETAILSNAMES);
    }

    public void setDetailsNames(String detailsNames) {
        set(PROPERTY_DETAILSNAMES, detailsNames);
    }

    public ssprleaveempcon getRelationship() {
        return (ssprleaveempcon) get(PROPERTY_RELATIONSHIP);
    }

    public void setRelationship(ssprleaveempcon relationship) {
        set(PROPERTY_RELATIONSHIP, relationship);
    }

    public Date getDateDeath() {
        return (Date) get(PROPERTY_DATEDEATH);
    }

    public void setDateDeath(Date dateDeath) {
        set(PROPERTY_DATEDEATH, dateDeath);
    }

    public String getOficialSpecs() {
        return (String) get(PROPERTY_OFICIALSPECS);
    }

    public void setOficialSpecs(String oficialSpecs) {
        set(PROPERTY_OFICIALSPECS, oficialSpecs);
    }

    public String getStatusSol() {
        return (String) get(PROPERTY_STATUSSOL);
    }

    public void setStatusSol(String statusSol) {
        set(PROPERTY_STATUSSOL, statusSol);
    }

    public BusinessPartner getCurrentUser() {
        return (BusinessPartner) get(PROPERTY_CURRENTUSER);
    }

    public void setCurrentUser(BusinessPartner currentUser) {
        set(PROPERTY_CURRENTUSER, currentUser);
    }

    public Costcenter getCostCenter() {
        return (Costcenter) get(PROPERTY_COSTCENTER);
    }

    public void setCostCenter(Costcenter costCenter) {
        set(PROPERTY_COSTCENTER, costCenter);
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

    public sshrDepartment getSSHRDepartment() {
        return (sshrDepartment) get(PROPERTY_SSHRDEPARTMENT);
    }

    public void setSSHRDepartment(sshrDepartment sSHRDepartment) {
        set(PROPERTY_SSHRDEPARTMENT, sSHRDepartment);
    }

    public Boolean isClosed() {
        return (Boolean) get(PROPERTY_CLOSED);
    }

    public void setClosed(Boolean closed) {
        set(PROPERTY_CLOSED, closed);
    }

    public Date getAuthorizedDate() {
        return (Date) get(PROPERTY_AUTHORIZEDDATE);
    }

    public void setAuthorizedDate(Date authorizedDate) {
        set(PROPERTY_AUTHORIZEDDATE, authorizedDate);
    }

    public String getSpecs() {
        return (String) get(PROPERTY_SPECS);
    }

    public void setSpecs(String specs) {
        set(PROPERTY_SPECS, specs);
    }

    public City getCity() {
        return (City) get(PROPERTY_CITY);
    }

    public void setCity(City city) {
        set(PROPERTY_CITY, city);
    }

    public String getTypevacations() {
        return (String) get(PROPERTY_TYPEVACATIONS);
    }

    public void setTypevacations(String typevacations) {
        set(PROPERTY_TYPEVACATIONS, typevacations);
    }

    public Date getStardateabsent() {
        return (Date) get(PROPERTY_STARDATEABSENT);
    }

    public void setStardateabsent(Date stardateabsent) {
        set(PROPERTY_STARDATEABSENT, stardateabsent);
    }

    public Boolean isPaidVacations() {
        return (Boolean) get(PROPERTY_PAIDVACATIONS);
    }

    public void setPaidVacations(Boolean paidVacations) {
        set(PROPERTY_PAIDVACATIONS, paidVacations);
    }

    public Boolean isProcessReactive() {
        return (Boolean) get(PROPERTY_PROCESSREACTIVE);
    }

    public void setProcessReactive(Boolean processReactive) {
        set(PROPERTY_PROCESSREACTIVE, processReactive);
    }

    public Boolean isApprovedStatus() {
        return (Boolean) get(PROPERTY_APPROVEDSTATUS);
    }

    public void setApprovedStatus(Boolean approvedStatus) {
        set(PROPERTY_APPROVEDSTATUS, approvedStatus);
    }

    @SuppressWarnings("unchecked")
    public List<ssprleaveempdetails> getSsprLeaveEmpDetailsList() {
      return (List<ssprleaveempdetails>) get(PROPERTY_SSPRLEAVEEMPDETAILSLIST);
    }

    public void setSsprLeaveEmpDetailsList(List<ssprleaveempdetails> ssprLeaveEmpDetailsList) {
        set(PROPERTY_SSPRLEAVEEMPDETAILSLIST, ssprLeaveEmpDetailsList);
    }

    @SuppressWarnings("unchecked")
    public List<sspr_leave_emp_vac> getSsprLeaveEmpVacList() {
      return (List<sspr_leave_emp_vac>) get(PROPERTY_SSPRLEAVEEMPVACLIST);
    }

    public void setSsprLeaveEmpVacList(List<sspr_leave_emp_vac> ssprLeaveEmpVacList) {
        set(PROPERTY_SSPRLEAVEEMPVACLIST, ssprLeaveEmpVacList);
    }

    @SuppressWarnings("unchecked")
    public List<sspr_leave_group> getSsprLeaveGroupList() {
      return (List<sspr_leave_group>) get(PROPERTY_SSPRLEAVEGROUPLIST);
    }

    public void setSsprLeaveGroupList(List<sspr_leave_group> ssprLeaveGroupList) {
        set(PROPERTY_SSPRLEAVEGROUPLIST, ssprLeaveGroupList);
    }

}
