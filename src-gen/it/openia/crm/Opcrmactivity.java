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
 * Entity class for entity opcrm_activity (stored in table opcrm_activity).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Opcrmactivity extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "opcrm_activity";
    public static final String ENTITY_NAME = "opcrm_activity";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ACTIVITYSUBJECT = "activitySubject";
    public static final String PROPERTY_ACTIVITYSTARTDATE = "activityStartdate";
    public static final String PROPERTY_STARTHOUR = "startHour";
    public static final String PROPERTY_STARTMINUTE = "startMinute";
    public static final String PROPERTY_DURATIONHOURS = "durationHours";
    public static final String PROPERTY_DURATIONMINUTES = "durationMinutes";
    public static final String PROPERTY_ACTIVITYBOUND = "activityBound";
    public static final String PROPERTY_RELATEDTO = "relatedTo";
    public static final String PROPERTY_ASSIGNEDTO = "assignedTo";
    public static final String PROPERTY_REMINDER = "reminder";
    public static final String PROPERTY_ACTIVITYLOCATION = "activityLocation";
    public static final String PROPERTY_PRIORITY = "priority";
    public static final String PROPERTY_ACTIVITYDUEDATE = "activityDueDate";
    public static final String PROPERTY_ACTIVITYTYPE = "activityType";
    public static final String PROPERTY_ACTIVITYSTATUS = "activityStatus";
    public static final String PROPERTY_ALLDAY = "allday";
    public static final String PROPERTY_ACTIVITYURL = "activityUrl";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_OPCRMOPPORTUNITIES = "opcrmOpportunities";
    public static final String PROPERTY_RELATEDLEAD = "relatedLead";
    public static final String PROPERTY_ADDUSERS = "aDDUsers";
    public static final String PROPERTY_LEADSTATUS = "leadstatus";
    public static final String PROPERTY_ACTIVITYENDDATE = "activityEnddate";
    public static final String PROPERTY_ICSFILEBUTTON = "icsfilebutton";
    public static final String PROPERTY_INVITEBUTTON = "invitebutton";
    public static final String PROPERTY_CREATELEADBUTTON = "createleadbutton";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_CREATECASEBTN = "createcasebtn";
    public static final String PROPERTY_CREATEOPPORTBTN = "createopportbtn";
    public static final String PROPERTY_HIDEINCALENDAR = "hideincalendar";
    public static final String PROPERTY_OPCRMCASESLIST = "opcrmCasesList";
    public static final String PROPERTY_OPCRMGUESTLIST = "opcrmGuestList";
    public static final String PROPERTY_OPCRMINVOICELIST = "opcrmInvoiceList";
    public static final String PROPERTY_OPCRMLEADACTIVITYLIST = "opcrmLeadActivityList";

    public Opcrmactivity() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_REMINDER, "opcrmReminder15min");
        setDefaultValue(PROPERTY_ALLDAY, false);
        setDefaultValue(PROPERTY_ADDUSERS, false);
        setDefaultValue(PROPERTY_ICSFILEBUTTON, false);
        setDefaultValue(PROPERTY_INVITEBUTTON, false);
        setDefaultValue(PROPERTY_CREATELEADBUTTON, false);
        setDefaultValue(PROPERTY_CREATECASEBTN, false);
        setDefaultValue(PROPERTY_CREATEOPPORTBTN, false);
        setDefaultValue(PROPERTY_HIDEINCALENDAR, false);
        setDefaultValue(PROPERTY_OPCRMCASESLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OPCRMGUESTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OPCRMINVOICELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OPCRMLEADACTIVITYLIST, new ArrayList<Object>());
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

    public String getActivitySubject() {
        return (String) get(PROPERTY_ACTIVITYSUBJECT);
    }

    public void setActivitySubject(String activitySubject) {
        set(PROPERTY_ACTIVITYSUBJECT, activitySubject);
    }

    public Date getActivityStartdate() {
        return (Date) get(PROPERTY_ACTIVITYSTARTDATE);
    }

    public void setActivityStartdate(Date activityStartdate) {
        set(PROPERTY_ACTIVITYSTARTDATE, activityStartdate);
    }

    public Long getStartHour() {
        return (Long) get(PROPERTY_STARTHOUR);
    }

    public void setStartHour(Long startHour) {
        set(PROPERTY_STARTHOUR, startHour);
    }

    public Long getStartMinute() {
        return (Long) get(PROPERTY_STARTMINUTE);
    }

    public void setStartMinute(Long startMinute) {
        set(PROPERTY_STARTMINUTE, startMinute);
    }

    public Long getDurationHours() {
        return (Long) get(PROPERTY_DURATIONHOURS);
    }

    public void setDurationHours(Long durationHours) {
        set(PROPERTY_DURATIONHOURS, durationHours);
    }

    public Long getDurationMinutes() {
        return (Long) get(PROPERTY_DURATIONMINUTES);
    }

    public void setDurationMinutes(Long durationMinutes) {
        set(PROPERTY_DURATIONMINUTES, durationMinutes);
    }

    public String getActivityBound() {
        return (String) get(PROPERTY_ACTIVITYBOUND);
    }

    public void setActivityBound(String activityBound) {
        set(PROPERTY_ACTIVITYBOUND, activityBound);
    }

    public String getRelatedTo() {
        return (String) get(PROPERTY_RELATEDTO);
    }

    public void setRelatedTo(String relatedTo) {
        set(PROPERTY_RELATEDTO, relatedTo);
    }

    public User getAssignedTo() {
        return (User) get(PROPERTY_ASSIGNEDTO);
    }

    public void setAssignedTo(User assignedTo) {
        set(PROPERTY_ASSIGNEDTO, assignedTo);
    }

    public String getReminder() {
        return (String) get(PROPERTY_REMINDER);
    }

    public void setReminder(String reminder) {
        set(PROPERTY_REMINDER, reminder);
    }

    public String getActivityLocation() {
        return (String) get(PROPERTY_ACTIVITYLOCATION);
    }

    public void setActivityLocation(String activityLocation) {
        set(PROPERTY_ACTIVITYLOCATION, activityLocation);
    }

    public String getPriority() {
        return (String) get(PROPERTY_PRIORITY);
    }

    public void setPriority(String priority) {
        set(PROPERTY_PRIORITY, priority);
    }

    public Date getActivityDueDate() {
        return (Date) get(PROPERTY_ACTIVITYDUEDATE);
    }

    public void setActivityDueDate(Date activityDueDate) {
        set(PROPERTY_ACTIVITYDUEDATE, activityDueDate);
    }

    public String getActivityType() {
        return (String) get(PROPERTY_ACTIVITYTYPE);
    }

    public void setActivityType(String activityType) {
        set(PROPERTY_ACTIVITYTYPE, activityType);
    }

    public Opcrmstatusfilter getActivityStatus() {
        return (Opcrmstatusfilter) get(PROPERTY_ACTIVITYSTATUS);
    }

    public void setActivityStatus(Opcrmstatusfilter activityStatus) {
        set(PROPERTY_ACTIVITYSTATUS, activityStatus);
    }

    public Boolean isAllday() {
        return (Boolean) get(PROPERTY_ALLDAY);
    }

    public void setAllday(Boolean allday) {
        set(PROPERTY_ALLDAY, allday);
    }

    public String getActivityUrl() {
        return (String) get(PROPERTY_ACTIVITYURL);
    }

    public void setActivityUrl(String activityUrl) {
        set(PROPERTY_ACTIVITYURL, activityUrl);
    }

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public Opcrmopportunities getOpcrmOpportunities() {
        return (Opcrmopportunities) get(PROPERTY_OPCRMOPPORTUNITIES);
    }

    public void setOpcrmOpportunities(Opcrmopportunities opcrmOpportunities) {
        set(PROPERTY_OPCRMOPPORTUNITIES, opcrmOpportunities);
    }

    public User getRelatedLead() {
        return (User) get(PROPERTY_RELATEDLEAD);
    }

    public void setRelatedLead(User relatedLead) {
        set(PROPERTY_RELATEDLEAD, relatedLead);
    }

    public Boolean isADDUsers() {
        return (Boolean) get(PROPERTY_ADDUSERS);
    }

    public void setADDUsers(Boolean aDDUsers) {
        set(PROPERTY_ADDUSERS, aDDUsers);
    }

    public String getLeadstatus() {
        return (String) get(PROPERTY_LEADSTATUS);
    }

    public void setLeadstatus(String leadstatus) {
        set(PROPERTY_LEADSTATUS, leadstatus);
    }

    public Date getActivityEnddate() {
        return (Date) get(PROPERTY_ACTIVITYENDDATE);
    }

    public void setActivityEnddate(Date activityEnddate) {
        set(PROPERTY_ACTIVITYENDDATE, activityEnddate);
    }

    public Boolean isIcsfilebutton() {
        return (Boolean) get(PROPERTY_ICSFILEBUTTON);
    }

    public void setIcsfilebutton(Boolean icsfilebutton) {
        set(PROPERTY_ICSFILEBUTTON, icsfilebutton);
    }

    public Boolean isInvitebutton() {
        return (Boolean) get(PROPERTY_INVITEBUTTON);
    }

    public void setInvitebutton(Boolean invitebutton) {
        set(PROPERTY_INVITEBUTTON, invitebutton);
    }

    public Boolean isCreateleadbutton() {
        return (Boolean) get(PROPERTY_CREATELEADBUTTON);
    }

    public void setCreateleadbutton(Boolean createleadbutton) {
        set(PROPERTY_CREATELEADBUTTON, createleadbutton);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Boolean isCreatecasebtn() {
        return (Boolean) get(PROPERTY_CREATECASEBTN);
    }

    public void setCreatecasebtn(Boolean createcasebtn) {
        set(PROPERTY_CREATECASEBTN, createcasebtn);
    }

    public Boolean isCreateopportbtn() {
        return (Boolean) get(PROPERTY_CREATEOPPORTBTN);
    }

    public void setCreateopportbtn(Boolean createopportbtn) {
        set(PROPERTY_CREATEOPPORTBTN, createopportbtn);
    }

    public Boolean isHideincalendar() {
        return (Boolean) get(PROPERTY_HIDEINCALENDAR);
    }

    public void setHideincalendar(Boolean hideincalendar) {
        set(PROPERTY_HIDEINCALENDAR, hideincalendar);
    }

    @SuppressWarnings("unchecked")
    public List<Opcrmcase> getOpcrmCasesList() {
      return (List<Opcrmcase>) get(PROPERTY_OPCRMCASESLIST);
    }

    public void setOpcrmCasesList(List<Opcrmcase> opcrmCasesList) {
        set(PROPERTY_OPCRMCASESLIST, opcrmCasesList);
    }

    @SuppressWarnings("unchecked")
    public List<opcrmGuest> getOpcrmGuestList() {
      return (List<opcrmGuest>) get(PROPERTY_OPCRMGUESTLIST);
    }

    public void setOpcrmGuestList(List<opcrmGuest> opcrmGuestList) {
        set(PROPERTY_OPCRMGUESTLIST, opcrmGuestList);
    }

    @SuppressWarnings("unchecked")
    public List<Opcrminvoice> getOpcrmInvoiceList() {
      return (List<Opcrminvoice>) get(PROPERTY_OPCRMINVOICELIST);
    }

    public void setOpcrmInvoiceList(List<Opcrminvoice> opcrmInvoiceList) {
        set(PROPERTY_OPCRMINVOICELIST, opcrmInvoiceList);
    }

    @SuppressWarnings("unchecked")
    public List<opcrmLeadActivity> getOpcrmLeadActivityList() {
      return (List<opcrmLeadActivity>) get(PROPERTY_OPCRMLEADACTIVITYLIST);
    }

    public void setOpcrmLeadActivityList(List<opcrmLeadActivity> opcrmLeadActivityList) {
        set(PROPERTY_OPCRMLEADACTIVITYLIST, opcrmLeadActivityList);
    }

}
