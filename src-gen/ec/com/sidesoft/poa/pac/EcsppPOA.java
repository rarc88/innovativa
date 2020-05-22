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
package ec.com.sidesoft.poa.pac;

import java.math.BigDecimal;
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
 * Entity class for entity ecspp_poa (stored in table ecspp_poa).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class EcsppPOA extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ecspp_poa";
    public static final String ENTITY_NAME = "ecspp_poa";
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
    public static final String PROPERTY_OEI = "oei";
    public static final String PROPERTY_GOALASKED = "goalAsked";
    public static final String PROPERTY_OBJETIVEPROCESS = "objetiveProcess";
    public static final String PROPERTY_RESULTPOA = "resultPoa";
    public static final String PROPERTY_INDICATORS = "indicators";
    public static final String PROPERTY_SEMESTER1 = "semester1";
    public static final String PROPERTY_SEMESTER2 = "semester2";
    public static final String PROPERTY_SEMESTERTIME1 = "semesterTime1";
    public static final String PROPERTY_SEMESTERTIME2 = "semesterTime2";
    public static final String PROPERTY_ACTIVITIES = "activities";
    public static final String PROPERTY_MEANSVERIFICATION = "meansVerification";
    public static final String PROPERTY_RESOURCES1 = "resources1";
    public static final String PROPERTY_RESOURCES2 = "resources2";
    public static final String PROPERTY_RESOURCESPREASIG1 = "resourcesPreasig1";
    public static final String PROPERTY_OTHERS = "others";
    public static final String PROPERTY_TOTALBUDGET = "totalBudget";
    public static final String PROPERTY_RESPONSIBLES = "responsibles";

    public EcsppPOA() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_SEMESTER1, new BigDecimal(0));
        setDefaultValue(PROPERTY_SEMESTER2, new BigDecimal(0));
        setDefaultValue(PROPERTY_SEMESTERTIME1, new BigDecimal(0));
        setDefaultValue(PROPERTY_SEMESTERTIME2, new BigDecimal(0));
        setDefaultValue(PROPERTY_RESOURCES1, new BigDecimal(0));
        setDefaultValue(PROPERTY_RESOURCES2, new BigDecimal(0));
        setDefaultValue(PROPERTY_RESOURCESPREASIG1, new BigDecimal(0));
        setDefaultValue(PROPERTY_OTHERS, new BigDecimal(0));
        setDefaultValue(PROPERTY_TOTALBUDGET, new BigDecimal(0));
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

    public String getOei() {
        return (String) get(PROPERTY_OEI);
    }

    public void setOei(String oei) {
        set(PROPERTY_OEI, oei);
    }

    public String getGoalAsked() {
        return (String) get(PROPERTY_GOALASKED);
    }

    public void setGoalAsked(String goalAsked) {
        set(PROPERTY_GOALASKED, goalAsked);
    }

    public String getObjetiveProcess() {
        return (String) get(PROPERTY_OBJETIVEPROCESS);
    }

    public void setObjetiveProcess(String objetiveProcess) {
        set(PROPERTY_OBJETIVEPROCESS, objetiveProcess);
    }

    public String getResultPoa() {
        return (String) get(PROPERTY_RESULTPOA);
    }

    public void setResultPoa(String resultPoa) {
        set(PROPERTY_RESULTPOA, resultPoa);
    }

    public String getIndicators() {
        return (String) get(PROPERTY_INDICATORS);
    }

    public void setIndicators(String indicators) {
        set(PROPERTY_INDICATORS, indicators);
    }

    public BigDecimal getSemester1() {
        return (BigDecimal) get(PROPERTY_SEMESTER1);
    }

    public void setSemester1(BigDecimal semester1) {
        set(PROPERTY_SEMESTER1, semester1);
    }

    public BigDecimal getSemester2() {
        return (BigDecimal) get(PROPERTY_SEMESTER2);
    }

    public void setSemester2(BigDecimal semester2) {
        set(PROPERTY_SEMESTER2, semester2);
    }

    public BigDecimal getSemesterTime1() {
        return (BigDecimal) get(PROPERTY_SEMESTERTIME1);
    }

    public void setSemesterTime1(BigDecimal semesterTime1) {
        set(PROPERTY_SEMESTERTIME1, semesterTime1);
    }

    public BigDecimal getSemesterTime2() {
        return (BigDecimal) get(PROPERTY_SEMESTERTIME2);
    }

    public void setSemesterTime2(BigDecimal semesterTime2) {
        set(PROPERTY_SEMESTERTIME2, semesterTime2);
    }

    public String getActivities() {
        return (String) get(PROPERTY_ACTIVITIES);
    }

    public void setActivities(String activities) {
        set(PROPERTY_ACTIVITIES, activities);
    }

    public String getMeansVerification() {
        return (String) get(PROPERTY_MEANSVERIFICATION);
    }

    public void setMeansVerification(String meansVerification) {
        set(PROPERTY_MEANSVERIFICATION, meansVerification);
    }

    public BigDecimal getResources1() {
        return (BigDecimal) get(PROPERTY_RESOURCES1);
    }

    public void setResources1(BigDecimal resources1) {
        set(PROPERTY_RESOURCES1, resources1);
    }

    public BigDecimal getResources2() {
        return (BigDecimal) get(PROPERTY_RESOURCES2);
    }

    public void setResources2(BigDecimal resources2) {
        set(PROPERTY_RESOURCES2, resources2);
    }

    public BigDecimal getResourcesPreasig1() {
        return (BigDecimal) get(PROPERTY_RESOURCESPREASIG1);
    }

    public void setResourcesPreasig1(BigDecimal resourcesPreasig1) {
        set(PROPERTY_RESOURCESPREASIG1, resourcesPreasig1);
    }

    public BigDecimal getOthers() {
        return (BigDecimal) get(PROPERTY_OTHERS);
    }

    public void setOthers(BigDecimal others) {
        set(PROPERTY_OTHERS, others);
    }

    public BigDecimal getTotalBudget() {
        return (BigDecimal) get(PROPERTY_TOTALBUDGET);
    }

    public void setTotalBudget(BigDecimal totalBudget) {
        set(PROPERTY_TOTALBUDGET, totalBudget);
    }

    public String getResponsibles() {
        return (String) get(PROPERTY_RESPONSIBLES);
    }

    public void setResponsibles(String responsibles) {
        set(PROPERTY_RESPONSIBLES, responsibles);
    }

}
