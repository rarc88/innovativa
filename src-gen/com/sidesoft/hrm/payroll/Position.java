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

import com.sidesoft.ecuador.humanResources.SshrEmployeePromotion;
import com.sidesoft.ecuador.humanResources.sshrSalaryGrade;
import com.sidesoft.ecuador.humanResources.sshrapplicant;
import com.sidesoft.ecuador.humanResources.sshrchaactivity;
import com.sidesoft.ecuador.humanResources.sshrchresponsibilities;
import com.sidesoft.ecuador.humanResources.sshrconfigure360;
import com.sidesoft.ecuador.humanResources.sshremployeeposition;
import com.sidesoft.ecuador.humanResources.sshrpositsubtitle;
import com.sidesoft.ecuador.humanResources.sshrskillsss;
import com.sidesoft.hrm.payroll.advanced.SfprEmployeeRve;
import com.sidesoft.hrm.payroll.advanced.SfprEmployeeSituation;
import com.sidesoft.hrm.payroll.advanced.SfprEmployeeSituationProposal;
import com.sidesoft.hrm.payroll.advanced.SfprEmployeeSurrogate;
import com.sidesoft.hrm.payroll.advanced.SfprGrade;
import com.sidesoft.hrm.payroll.advanced.SfprLevel;
import com.sidesoft.hrm.payroll.advanced.SfprRve;
import com.sidesoft.hrm.payroll.advanced.SfprRveDetail;
import com.sidesoft.hrm.payroll.advanced.SfprSurrogateDetail;

import ec.com.sidesoft.localization.ecuador.viatical.SSVEPositionLevel;
import ec.com.sidesoft.localization.ecuador.viatical.SSVEViatical;
import ec.com.sidesoft.localization.ecuador.viatical.SSVEViaticalSettlement;

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
 * Entity class for entity SSPR_Position (stored in table SSPR_Position).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Position extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "SSPR_Position";
    public static final String ENTITY_NAME = "SSPR_Position";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_COMPERS = "compers";
    public static final String PROPERTY_SSPRCONTRACTPOSITIONLIST = "sSPRContractPositionList";
    public static final String PROPERTY_SSPRSHIFTPOSITIONLIST = "sSPRShiftPositionList";
    public static final String PROPERTY_SSVEPOSITIONLEVELLIST = "sSVEPositionLevelList";
    public static final String PROPERTY_SSVEVIATICALLIST = "sSVEViaticalList";
    public static final String PROPERTY_SSVEVIATICALSETTLEMENTLIST = "sSVEViaticalSettlementList";
    public static final String PROPERTY_SFPREMPLOYEERVESURROGATETOLIST = "sfprEmployeeRveSurrogateToList";
    public static final String PROPERTY_SFPREMPLOYEESITUATIONPOSITIONLIST = "sfprEmployeeSituationPositionList";
    public static final String PROPERTY_SFPREMPLOYEESITUATION2POSITIONLIST = "sfprEmployeeSituation2PositionList";
    public static final String PROPERTY_SFPREMPLOYEESURROGATESURROGATETOLIST = "sfprEmployeeSurrogateSurrogateToList";
    public static final String PROPERTY_SFPRGRADESFPREMPLOYEEPOSITIONIDLIST = "sfprGradeSfprEmployeePositionIDList";
    public static final String PROPERTY_SFPRLEVELPOSITIONLIST = "sfprLevelPositionList";
    public static final String PROPERTY_SFPRRVEPOSITIONLIST = "sfprRvePositionList";
    public static final String PROPERTY_SFPRRVEDETAILLIST = "sfprRveDetailList";
    public static final String PROPERTY_SFPRSURROGATEDETAILPOSITIONLIST = "sfprSurrogateDetailPositionList";
    public static final String PROPERTY_SSHRAPPLICANTSSHRPOSITIONLIST = "sshrApplicantSshrPositionList";
    public static final String PROPERTY_SSHRCHRESPONSIBILITIESLIST = "sshrChResponsibilitiesList";
    public static final String PROPERTY_SSHRCHAACTIVITYLIST = "sshrChaActivityList";
    public static final String PROPERTY_SSHRCONFIGURE360LIST = "sshrConfigure360List";
    public static final String PROPERTY_SSHREMPLOYEEPOSITIONLIST = "sshrEmployeePositionList";
    public static final String PROPERTY_SSHREMPLOYEEPROMOTIONPOSITIONLIST = "sshrEmployeePromotionPositionList";
    public static final String PROPERTY_SSHRPOSITSUBTITLEPOSITIONLIST = "sshrPositSubTitlePositionList";
    public static final String PROPERTY_SSHRSALARYGRADENAMELIST = "sshrSalaryGradeNameList";
    public static final String PROPERTY_SSHRSKILLSSSHRPOSITIONSKLIST = "sshrSkillsSshrPositionSkList";

    public Position() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_SSPRCONTRACTPOSITIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRSHIFTPOSITIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSVEPOSITIONLEVELLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSVEVIATICALLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSVEVIATICALSETTLEMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPREMPLOYEERVESURROGATETOLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPREMPLOYEESITUATIONPOSITIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPREMPLOYEESITUATION2POSITIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPREMPLOYEESURROGATESURROGATETOLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPRGRADESFPREMPLOYEEPOSITIONIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPRLEVELPOSITIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPRRVEPOSITIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPRRVEDETAILLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPRSURROGATEDETAILPOSITIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSHRAPPLICANTSSHRPOSITIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSHRCHRESPONSIBILITIESLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSHRCHAACTIVITYLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSHRCONFIGURE360LIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSHREMPLOYEEPOSITIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSHREMPLOYEEPROMOTIONPOSITIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSHRPOSITSUBTITLEPOSITIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSHRSALARYGRADENAMELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSHRSKILLSSSHRPOSITIONSKLIST, new ArrayList<Object>());
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

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Long getCompers() {
        return (Long) get(PROPERTY_COMPERS);
    }

    public void setCompers(Long compers) {
        set(PROPERTY_COMPERS, compers);
    }

    @SuppressWarnings("unchecked")
    public List<ContractPosition> getSSPRContractPositionList() {
      return (List<ContractPosition>) get(PROPERTY_SSPRCONTRACTPOSITIONLIST);
    }

    public void setSSPRContractPositionList(List<ContractPosition> sSPRContractPositionList) {
        set(PROPERTY_SSPRCONTRACTPOSITIONLIST, sSPRContractPositionList);
    }

    @SuppressWarnings("unchecked")
    public List<Shift> getSSPRShiftPositionList() {
      return (List<Shift>) get(PROPERTY_SSPRSHIFTPOSITIONLIST);
    }

    public void setSSPRShiftPositionList(List<Shift> sSPRShiftPositionList) {
        set(PROPERTY_SSPRSHIFTPOSITIONLIST, sSPRShiftPositionList);
    }

    @SuppressWarnings("unchecked")
    public List<SSVEPositionLevel> getSSVEPositionLevelList() {
      return (List<SSVEPositionLevel>) get(PROPERTY_SSVEPOSITIONLEVELLIST);
    }

    public void setSSVEPositionLevelList(List<SSVEPositionLevel> sSVEPositionLevelList) {
        set(PROPERTY_SSVEPOSITIONLEVELLIST, sSVEPositionLevelList);
    }

    @SuppressWarnings("unchecked")
    public List<SSVEViatical> getSSVEViaticalList() {
      return (List<SSVEViatical>) get(PROPERTY_SSVEVIATICALLIST);
    }

    public void setSSVEViaticalList(List<SSVEViatical> sSVEViaticalList) {
        set(PROPERTY_SSVEVIATICALLIST, sSVEViaticalList);
    }

    @SuppressWarnings("unchecked")
    public List<SSVEViaticalSettlement> getSSVEViaticalSettlementList() {
      return (List<SSVEViaticalSettlement>) get(PROPERTY_SSVEVIATICALSETTLEMENTLIST);
    }

    public void setSSVEViaticalSettlementList(List<SSVEViaticalSettlement> sSVEViaticalSettlementList) {
        set(PROPERTY_SSVEVIATICALSETTLEMENTLIST, sSVEViaticalSettlementList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprEmployeeRve> getSfprEmployeeRveSurrogateToList() {
      return (List<SfprEmployeeRve>) get(PROPERTY_SFPREMPLOYEERVESURROGATETOLIST);
    }

    public void setSfprEmployeeRveSurrogateToList(List<SfprEmployeeRve> sfprEmployeeRveSurrogateToList) {
        set(PROPERTY_SFPREMPLOYEERVESURROGATETOLIST, sfprEmployeeRveSurrogateToList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprEmployeeSituation> getSfprEmployeeSituationPositionList() {
      return (List<SfprEmployeeSituation>) get(PROPERTY_SFPREMPLOYEESITUATIONPOSITIONLIST);
    }

    public void setSfprEmployeeSituationPositionList(List<SfprEmployeeSituation> sfprEmployeeSituationPositionList) {
        set(PROPERTY_SFPREMPLOYEESITUATIONPOSITIONLIST, sfprEmployeeSituationPositionList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprEmployeeSituationProposal> getSfprEmployeeSituation2PositionList() {
      return (List<SfprEmployeeSituationProposal>) get(PROPERTY_SFPREMPLOYEESITUATION2POSITIONLIST);
    }

    public void setSfprEmployeeSituation2PositionList(List<SfprEmployeeSituationProposal> sfprEmployeeSituation2PositionList) {
        set(PROPERTY_SFPREMPLOYEESITUATION2POSITIONLIST, sfprEmployeeSituation2PositionList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprEmployeeSurrogate> getSfprEmployeeSurrogateSurrogateToList() {
      return (List<SfprEmployeeSurrogate>) get(PROPERTY_SFPREMPLOYEESURROGATESURROGATETOLIST);
    }

    public void setSfprEmployeeSurrogateSurrogateToList(List<SfprEmployeeSurrogate> sfprEmployeeSurrogateSurrogateToList) {
        set(PROPERTY_SFPREMPLOYEESURROGATESURROGATETOLIST, sfprEmployeeSurrogateSurrogateToList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprGrade> getSfprGradeSfprEmployeePositionIDList() {
      return (List<SfprGrade>) get(PROPERTY_SFPRGRADESFPREMPLOYEEPOSITIONIDLIST);
    }

    public void setSfprGradeSfprEmployeePositionIDList(List<SfprGrade> sfprGradeSfprEmployeePositionIDList) {
        set(PROPERTY_SFPRGRADESFPREMPLOYEEPOSITIONIDLIST, sfprGradeSfprEmployeePositionIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprLevel> getSfprLevelPositionList() {
      return (List<SfprLevel>) get(PROPERTY_SFPRLEVELPOSITIONLIST);
    }

    public void setSfprLevelPositionList(List<SfprLevel> sfprLevelPositionList) {
        set(PROPERTY_SFPRLEVELPOSITIONLIST, sfprLevelPositionList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprRve> getSfprRvePositionList() {
      return (List<SfprRve>) get(PROPERTY_SFPRRVEPOSITIONLIST);
    }

    public void setSfprRvePositionList(List<SfprRve> sfprRvePositionList) {
        set(PROPERTY_SFPRRVEPOSITIONLIST, sfprRvePositionList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprRveDetail> getSfprRveDetailList() {
      return (List<SfprRveDetail>) get(PROPERTY_SFPRRVEDETAILLIST);
    }

    public void setSfprRveDetailList(List<SfprRveDetail> sfprRveDetailList) {
        set(PROPERTY_SFPRRVEDETAILLIST, sfprRveDetailList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprSurrogateDetail> getSfprSurrogateDetailPositionList() {
      return (List<SfprSurrogateDetail>) get(PROPERTY_SFPRSURROGATEDETAILPOSITIONLIST);
    }

    public void setSfprSurrogateDetailPositionList(List<SfprSurrogateDetail> sfprSurrogateDetailPositionList) {
        set(PROPERTY_SFPRSURROGATEDETAILPOSITIONLIST, sfprSurrogateDetailPositionList);
    }

    @SuppressWarnings("unchecked")
    public List<sshrapplicant> getSshrApplicantSshrPositionList() {
      return (List<sshrapplicant>) get(PROPERTY_SSHRAPPLICANTSSHRPOSITIONLIST);
    }

    public void setSshrApplicantSshrPositionList(List<sshrapplicant> sshrApplicantSshrPositionList) {
        set(PROPERTY_SSHRAPPLICANTSSHRPOSITIONLIST, sshrApplicantSshrPositionList);
    }

    @SuppressWarnings("unchecked")
    public List<sshrchresponsibilities> getSshrChResponsibilitiesList() {
      return (List<sshrchresponsibilities>) get(PROPERTY_SSHRCHRESPONSIBILITIESLIST);
    }

    public void setSshrChResponsibilitiesList(List<sshrchresponsibilities> sshrChResponsibilitiesList) {
        set(PROPERTY_SSHRCHRESPONSIBILITIESLIST, sshrChResponsibilitiesList);
    }

    @SuppressWarnings("unchecked")
    public List<sshrchaactivity> getSshrChaActivityList() {
      return (List<sshrchaactivity>) get(PROPERTY_SSHRCHAACTIVITYLIST);
    }

    public void setSshrChaActivityList(List<sshrchaactivity> sshrChaActivityList) {
        set(PROPERTY_SSHRCHAACTIVITYLIST, sshrChaActivityList);
    }

    @SuppressWarnings("unchecked")
    public List<sshrconfigure360> getSshrConfigure360List() {
      return (List<sshrconfigure360>) get(PROPERTY_SSHRCONFIGURE360LIST);
    }

    public void setSshrConfigure360List(List<sshrconfigure360> sshrConfigure360List) {
        set(PROPERTY_SSHRCONFIGURE360LIST, sshrConfigure360List);
    }

    @SuppressWarnings("unchecked")
    public List<sshremployeeposition> getSshrEmployeePositionList() {
      return (List<sshremployeeposition>) get(PROPERTY_SSHREMPLOYEEPOSITIONLIST);
    }

    public void setSshrEmployeePositionList(List<sshremployeeposition> sshrEmployeePositionList) {
        set(PROPERTY_SSHREMPLOYEEPOSITIONLIST, sshrEmployeePositionList);
    }

    @SuppressWarnings("unchecked")
    public List<SshrEmployeePromotion> getSshrEmployeePromotionPositionList() {
      return (List<SshrEmployeePromotion>) get(PROPERTY_SSHREMPLOYEEPROMOTIONPOSITIONLIST);
    }

    public void setSshrEmployeePromotionPositionList(List<SshrEmployeePromotion> sshrEmployeePromotionPositionList) {
        set(PROPERTY_SSHREMPLOYEEPROMOTIONPOSITIONLIST, sshrEmployeePromotionPositionList);
    }

    @SuppressWarnings("unchecked")
    public List<sshrpositsubtitle> getSshrPositSubTitlePositionList() {
      return (List<sshrpositsubtitle>) get(PROPERTY_SSHRPOSITSUBTITLEPOSITIONLIST);
    }

    public void setSshrPositSubTitlePositionList(List<sshrpositsubtitle> sshrPositSubTitlePositionList) {
        set(PROPERTY_SSHRPOSITSUBTITLEPOSITIONLIST, sshrPositSubTitlePositionList);
    }

    @SuppressWarnings("unchecked")
    public List<sshrSalaryGrade> getSshrSalaryGradeNameList() {
      return (List<sshrSalaryGrade>) get(PROPERTY_SSHRSALARYGRADENAMELIST);
    }

    public void setSshrSalaryGradeNameList(List<sshrSalaryGrade> sshrSalaryGradeNameList) {
        set(PROPERTY_SSHRSALARYGRADENAMELIST, sshrSalaryGradeNameList);
    }

    @SuppressWarnings("unchecked")
    public List<sshrskillsss> getSshrSkillsSshrPositionSkList() {
      return (List<sshrskillsss>) get(PROPERTY_SSHRSKILLSSSHRPOSITIONSKLIST);
    }

    public void setSshrSkillsSshrPositionSkList(List<sshrskillsss> sshrSkillsSshrPositionSkList) {
        set(PROPERTY_SSHRSKILLSSSHRPOSITIONSKLIST, sshrSkillsSshrPositionSkList);
    }

}
