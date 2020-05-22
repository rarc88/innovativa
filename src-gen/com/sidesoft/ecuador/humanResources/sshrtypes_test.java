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
package com.sidesoft.ecuador.humanResources;

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
import org.openbravo.model.common.enterprise.Organization;
/**
 * Entity class for entity sshr_types_test (stored in table sshr_types_test).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class sshrtypes_test extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sshr_types_test";
    public static final String ENTITY_NAME = "sshr_types_test";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_SCOREMAX = "scoreMax";
    public static final String PROPERTY_SCOREMIN = "scoreMin";
    public static final String PROPERTY_POSITIONTITLE = "positionTitle";
    public static final String PROPERTY_TESTSKNOWLEDGE = "testsKnowledge";
    public static final String PROPERTY_TESTSPSYCHOLOGICAL = "testsPsychological";
    public static final String PROPERTY_SSHREXAMINATIONTESTLIST = "sshrExaminationTestList";
    public static final String PROPERTY_SSHRQTESTINGTESTKNOWLEDGELIST = "sshrQtestingTestKnowledgeList";
    public static final String PROPERTY_SSHRQTESTINGTESTPSYCHOLOGYLIST = "sshrQtestingTestPsychologyList";

    public sshrtypes_test() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_TESTSKNOWLEDGE, false);
        setDefaultValue(PROPERTY_TESTSPSYCHOLOGICAL, false);
        setDefaultValue(PROPERTY_SSHREXAMINATIONTESTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSHRQTESTINGTESTKNOWLEDGELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSHRQTESTINGTESTPSYCHOLOGYLIST, new ArrayList<Object>());
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

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public Long getScoreMax() {
        return (Long) get(PROPERTY_SCOREMAX);
    }

    public void setScoreMax(Long scoreMax) {
        set(PROPERTY_SCOREMAX, scoreMax);
    }

    public Long getScoreMin() {
        return (Long) get(PROPERTY_SCOREMIN);
    }

    public void setScoreMin(Long scoreMin) {
        set(PROPERTY_SCOREMIN, scoreMin);
    }

    public sshrPositionTitle getPositionTitle() {
        return (sshrPositionTitle) get(PROPERTY_POSITIONTITLE);
    }

    public void setPositionTitle(sshrPositionTitle positionTitle) {
        set(PROPERTY_POSITIONTITLE, positionTitle);
    }

    public Boolean isTestsKnowledge() {
        return (Boolean) get(PROPERTY_TESTSKNOWLEDGE);
    }

    public void setTestsKnowledge(Boolean testsKnowledge) {
        set(PROPERTY_TESTSKNOWLEDGE, testsKnowledge);
    }

    public Boolean isTestsPsychological() {
        return (Boolean) get(PROPERTY_TESTSPSYCHOLOGICAL);
    }

    public void setTestsPsychological(Boolean testsPsychological) {
        set(PROPERTY_TESTSPSYCHOLOGICAL, testsPsychological);
    }

    @SuppressWarnings("unchecked")
    public List<SshrExaminationTest> getSshrExaminationTestList() {
      return (List<SshrExaminationTest>) get(PROPERTY_SSHREXAMINATIONTESTLIST);
    }

    public void setSshrExaminationTestList(List<SshrExaminationTest> sshrExaminationTestList) {
        set(PROPERTY_SSHREXAMINATIONTESTLIST, sshrExaminationTestList);
    }

    @SuppressWarnings("unchecked")
    public List<sshrqtesting> getSshrQtestingTestKnowledgeList() {
      return (List<sshrqtesting>) get(PROPERTY_SSHRQTESTINGTESTKNOWLEDGELIST);
    }

    public void setSshrQtestingTestKnowledgeList(List<sshrqtesting> sshrQtestingTestKnowledgeList) {
        set(PROPERTY_SSHRQTESTINGTESTKNOWLEDGELIST, sshrQtestingTestKnowledgeList);
    }

    @SuppressWarnings("unchecked")
    public List<sshrqtesting> getSshrQtestingTestPsychologyList() {
      return (List<sshrqtesting>) get(PROPERTY_SSHRQTESTINGTESTPSYCHOLOGYLIST);
    }

    public void setSshrQtestingTestPsychologyList(List<sshrqtesting> sshrQtestingTestPsychologyList) {
        set(PROPERTY_SSHRQTESTINGTESTPSYCHOLOGYLIST, sshrQtestingTestPsychologyList);
    }

}
