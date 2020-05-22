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
 * Entity class for entity opcrm_cases (stored in table opcrm_cases).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Opcrmcase extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "opcrm_cases";
    public static final String ENTITY_NAME = "opcrm_cases";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_CASEPRIORITY = "casePriority";
    public static final String PROPERTY_CASESTATUS = "caseStatus";
    public static final String PROPERTY_CASETYPE = "caseType";
    public static final String PROPERTY_CASESUBJECT = "caseSubject";
    public static final String PROPERTY_ASSIGNEDTO = "assignedTo";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_ADDUSERS = "addUsers";
    public static final String PROPERTY_DEADLINEDATE = "deadlineDate";
    public static final String PROPERTY_SENDBUTTON = "sendButton";
    public static final String PROPERTY_TICKETNUMBER = "ticketnumber";
    public static final String PROPERTY_CASEDESCRIPTION = "caseDescription";
    public static final String PROPERTY_CASERESOLUTION = "caseResolution";
    public static final String PROPERTY_ACTIVITYBUTTON = "activityButton";
    public static final String PROPERTY_STARTDATE = "startDate";
    public static final String PROPERTY_STARTHOUR = "starthour";
    public static final String PROPERTY_STARTMINUTES = "startminutes";
    public static final String PROPERTY_ENDDATE = "endDate";
    public static final String PROPERTY_ENDHOURS = "endhours";
    public static final String PROPERTY_ENDMINUTES = "endminutes";
    public static final String PROPERTY_TIMESPENTHOURS = "timeSpenthours";
    public static final String PROPERTY_TIMESPENTMINUTES = "timeSpentminutes";
    public static final String PROPERTY_BEGINBUTTON = "beginButton";
    public static final String PROPERTY_ENDBUTTON = "eNDButton";
    public static final String PROPERTY_SPECIFYOPERATION = "specifyOperation";
    public static final String PROPERTY_RELATEDLEAD = "relatedLead";
    public static final String PROPERTY_CASEKIND = "casekind";
    public static final String PROPERTY_OPCRMACTIVITY = "opcrmActivity";
    public static final String PROPERTY_BILL = "bill";
    public static final String PROPERTY_SUSPEND = "suspend";
    public static final String PROPERTY_OPCRMCASEACTIVITY = "opcrmCaseactivity";
    public static final String PROPERTY_OPCRMWORKTYPE = "opcrmWorktype";
    public static final String PROPERTY_REFERENCEFIELD = "referencefield";
    public static final String PROPERTY_FINISHED = "finished";
    public static final String PROPERTY_TIMEESTIMATEDHOURS = "timeEstimatedhours";
    public static final String PROPERTY_TIMEESTIMATEDMINUTES = "timeEstimatedminutes";
    public static final String PROPERTY_TIMEFINALH = "timeFinalH";
    public static final String PROPERTY_TIMEFINALM = "timeFinalM";
    public static final String PROPERTY_CASECREATED = "caseCreated";
    public static final String PROPERTY_CASECREATEDBY = "caseCreatedby";
    public static final String PROPERTY_SENDUPDATE = "sendupdate";
    public static final String PROPERTY_OPCRMCASESACCESSLIST = "opcrmCasesAccessList";

    public Opcrmcase() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_ADDUSERS, false);
        setDefaultValue(PROPERTY_SENDBUTTON, false);
        setDefaultValue(PROPERTY_ACTIVITYBUTTON, false);
        setDefaultValue(PROPERTY_BEGINBUTTON, false);
        setDefaultValue(PROPERTY_ENDBUTTON, false);
        setDefaultValue(PROPERTY_BILL, false);
        setDefaultValue(PROPERTY_SUSPEND, false);
        setDefaultValue(PROPERTY_FINISHED, false);
        setDefaultValue(PROPERTY_SENDUPDATE, false);
        setDefaultValue(PROPERTY_OPCRMCASESACCESSLIST, new ArrayList<Object>());
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

    public String getCasePriority() {
        return (String) get(PROPERTY_CASEPRIORITY);
    }

    public void setCasePriority(String casePriority) {
        set(PROPERTY_CASEPRIORITY, casePriority);
    }

    public String getCaseStatus() {
        return (String) get(PROPERTY_CASESTATUS);
    }

    public void setCaseStatus(String caseStatus) {
        set(PROPERTY_CASESTATUS, caseStatus);
    }

    public String getCaseType() {
        return (String) get(PROPERTY_CASETYPE);
    }

    public void setCaseType(String caseType) {
        set(PROPERTY_CASETYPE, caseType);
    }

    public String getCaseSubject() {
        return (String) get(PROPERTY_CASESUBJECT);
    }

    public void setCaseSubject(String caseSubject) {
        set(PROPERTY_CASESUBJECT, caseSubject);
    }

    public User getAssignedTo() {
        return (User) get(PROPERTY_ASSIGNEDTO);
    }

    public void setAssignedTo(User assignedTo) {
        set(PROPERTY_ASSIGNEDTO, assignedTo);
    }

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public Boolean isAddUsers() {
        return (Boolean) get(PROPERTY_ADDUSERS);
    }

    public void setAddUsers(Boolean addUsers) {
        set(PROPERTY_ADDUSERS, addUsers);
    }

    public Date getDeadlineDate() {
        return (Date) get(PROPERTY_DEADLINEDATE);
    }

    public void setDeadlineDate(Date deadlineDate) {
        set(PROPERTY_DEADLINEDATE, deadlineDate);
    }

    public Boolean isSendButton() {
        return (Boolean) get(PROPERTY_SENDBUTTON);
    }

    public void setSendButton(Boolean sendButton) {
        set(PROPERTY_SENDBUTTON, sendButton);
    }

    public Long getTicketnumber() {
        return (Long) get(PROPERTY_TICKETNUMBER);
    }

    public void setTicketnumber(Long ticketnumber) {
        set(PROPERTY_TICKETNUMBER, ticketnumber);
    }

    public String getCaseDescription() {
        return (String) get(PROPERTY_CASEDESCRIPTION);
    }

    public void setCaseDescription(String caseDescription) {
        set(PROPERTY_CASEDESCRIPTION, caseDescription);
    }

    public String getCaseResolution() {
        return (String) get(PROPERTY_CASERESOLUTION);
    }

    public void setCaseResolution(String caseResolution) {
        set(PROPERTY_CASERESOLUTION, caseResolution);
    }

    public Boolean isActivityButton() {
        return (Boolean) get(PROPERTY_ACTIVITYBUTTON);
    }

    public void setActivityButton(Boolean activityButton) {
        set(PROPERTY_ACTIVITYBUTTON, activityButton);
    }

    public Date getStartDate() {
        return (Date) get(PROPERTY_STARTDATE);
    }

    public void setStartDate(Date startDate) {
        set(PROPERTY_STARTDATE, startDate);
    }

    public Long getStarthour() {
        return (Long) get(PROPERTY_STARTHOUR);
    }

    public void setStarthour(Long starthour) {
        set(PROPERTY_STARTHOUR, starthour);
    }

    public Long getStartminutes() {
        return (Long) get(PROPERTY_STARTMINUTES);
    }

    public void setStartminutes(Long startminutes) {
        set(PROPERTY_STARTMINUTES, startminutes);
    }

    public Date getEndDate() {
        return (Date) get(PROPERTY_ENDDATE);
    }

    public void setEndDate(Date endDate) {
        set(PROPERTY_ENDDATE, endDate);
    }

    public Long getEndhours() {
        return (Long) get(PROPERTY_ENDHOURS);
    }

    public void setEndhours(Long endhours) {
        set(PROPERTY_ENDHOURS, endhours);
    }

    public Long getEndminutes() {
        return (Long) get(PROPERTY_ENDMINUTES);
    }

    public void setEndminutes(Long endminutes) {
        set(PROPERTY_ENDMINUTES, endminutes);
    }

    public Long getTimeSpenthours() {
        return (Long) get(PROPERTY_TIMESPENTHOURS);
    }

    public void setTimeSpenthours(Long timeSpenthours) {
        set(PROPERTY_TIMESPENTHOURS, timeSpenthours);
    }

    public Long getTimeSpentminutes() {
        return (Long) get(PROPERTY_TIMESPENTMINUTES);
    }

    public void setTimeSpentminutes(Long timeSpentminutes) {
        set(PROPERTY_TIMESPENTMINUTES, timeSpentminutes);
    }

    public Boolean isBeginButton() {
        return (Boolean) get(PROPERTY_BEGINBUTTON);
    }

    public void setBeginButton(Boolean beginButton) {
        set(PROPERTY_BEGINBUTTON, beginButton);
    }

    public Boolean isENDButton() {
        return (Boolean) get(PROPERTY_ENDBUTTON);
    }

    public void setENDButton(Boolean eNDButton) {
        set(PROPERTY_ENDBUTTON, eNDButton);
    }

    public String getSpecifyOperation() {
        return (String) get(PROPERTY_SPECIFYOPERATION);
    }

    public void setSpecifyOperation(String specifyOperation) {
        set(PROPERTY_SPECIFYOPERATION, specifyOperation);
    }

    public User getRelatedLead() {
        return (User) get(PROPERTY_RELATEDLEAD);
    }

    public void setRelatedLead(User relatedLead) {
        set(PROPERTY_RELATEDLEAD, relatedLead);
    }

    public String getCasekind() {
        return (String) get(PROPERTY_CASEKIND);
    }

    public void setCasekind(String casekind) {
        set(PROPERTY_CASEKIND, casekind);
    }

    public Opcrmactivity getOpcrmActivity() {
        return (Opcrmactivity) get(PROPERTY_OPCRMACTIVITY);
    }

    public void setOpcrmActivity(Opcrmactivity opcrmActivity) {
        set(PROPERTY_OPCRMACTIVITY, opcrmActivity);
    }

    public Boolean isBill() {
        return (Boolean) get(PROPERTY_BILL);
    }

    public void setBill(Boolean bill) {
        set(PROPERTY_BILL, bill);
    }

    public Boolean isSuspend() {
        return (Boolean) get(PROPERTY_SUSPEND);
    }

    public void setSuspend(Boolean suspend) {
        set(PROPERTY_SUSPEND, suspend);
    }

    public OpcrmCaseactivity getOpcrmCaseactivity() {
        return (OpcrmCaseactivity) get(PROPERTY_OPCRMCASEACTIVITY);
    }

    public void setOpcrmCaseactivity(OpcrmCaseactivity opcrmCaseactivity) {
        set(PROPERTY_OPCRMCASEACTIVITY, opcrmCaseactivity);
    }

    public OpcrmWorktype getOpcrmWorktype() {
        return (OpcrmWorktype) get(PROPERTY_OPCRMWORKTYPE);
    }

    public void setOpcrmWorktype(OpcrmWorktype opcrmWorktype) {
        set(PROPERTY_OPCRMWORKTYPE, opcrmWorktype);
    }

    public String getReferencefield() {
        return (String) get(PROPERTY_REFERENCEFIELD);
    }

    public void setReferencefield(String referencefield) {
        set(PROPERTY_REFERENCEFIELD, referencefield);
    }

    public Boolean isFinished() {
        return (Boolean) get(PROPERTY_FINISHED);
    }

    public void setFinished(Boolean finished) {
        set(PROPERTY_FINISHED, finished);
    }

    public Long getTimeEstimatedhours() {
        return (Long) get(PROPERTY_TIMEESTIMATEDHOURS);
    }

    public void setTimeEstimatedhours(Long timeEstimatedhours) {
        set(PROPERTY_TIMEESTIMATEDHOURS, timeEstimatedhours);
    }

    public Long getTimeEstimatedminutes() {
        return (Long) get(PROPERTY_TIMEESTIMATEDMINUTES);
    }

    public void setTimeEstimatedminutes(Long timeEstimatedminutes) {
        set(PROPERTY_TIMEESTIMATEDMINUTES, timeEstimatedminutes);
    }

    public Long getTimeFinalH() {
        return (Long) get(PROPERTY_TIMEFINALH);
    }

    public void setTimeFinalH(Long timeFinalH) {
        set(PROPERTY_TIMEFINALH, timeFinalH);
    }

    public Long getTimeFinalM() {
        return (Long) get(PROPERTY_TIMEFINALM);
    }

    public void setTimeFinalM(Long timeFinalM) {
        set(PROPERTY_TIMEFINALM, timeFinalM);
    }

    public Date getCaseCreated() {
        return (Date) get(PROPERTY_CASECREATED);
    }

    public void setCaseCreated(Date caseCreated) {
        set(PROPERTY_CASECREATED, caseCreated);
    }

    public User getCaseCreatedby() {
        return (User) get(PROPERTY_CASECREATEDBY);
    }

    public void setCaseCreatedby(User caseCreatedby) {
        set(PROPERTY_CASECREATEDBY, caseCreatedby);
    }

    public Boolean isSendupdate() {
        return (Boolean) get(PROPERTY_SENDUPDATE);
    }

    public void setSendupdate(Boolean sendupdate) {
        set(PROPERTY_SENDUPDATE, sendupdate);
    }

    @SuppressWarnings("unchecked")
    public List<opcrmCasesAccess> getOpcrmCasesAccessList() {
      return (List<opcrmCasesAccess>) get(PROPERTY_OPCRMCASESACCESSLIST);
    }

    public void setOpcrmCasesAccessList(List<opcrmCasesAccess> opcrmCasesAccessList) {
        set(PROPERTY_OPCRMCASESACCESSLIST, opcrmCasesAccessList);
    }

}
