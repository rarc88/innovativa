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

import com.sidesoft.hrm.payroll.advanced.SfprEmployeeSituation;
import com.sidesoft.hrm.payroll.advanced.SfprEmployeeSituationProposal;
import com.sidesoft.hrm.payroll.advanced.SfprEvolutionSalary;
import com.sidesoft.hrm.payroll.advanced.SfprGrade;
import com.sidesoft.hrm.payroll.advanced.SfprLevel;

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
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.geography.City;
import org.openbravo.model.financialmgmt.accounting.UserDimension1;
import org.openbravo.model.financialmgmt.calendar.Year;
/**
 * Entity class for entity SSPR_Contract (stored in table SSPR_Contract).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Contract extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "SSPR_Contract";
    public static final String ENTITY_NAME = "SSPR_Contract";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_CONTRACTCONDITION = "contractcondition";
    public static final String PROPERTY_STARTDATE = "startdate";
    public static final String PROPERTY_ENDDATE = "enddate";
    public static final String PROPERTY_ISNIGHT = "isnight";
    public static final String PROPERTY_ISCUMULATIVEREGIME = "iscumulativeregime";
    public static final String PROPERTY_ISTIMEMAX = "istimemax";
    public static final String PROPERTY_SSPRSHIFT = "ssprShift";
    public static final String PROPERTY_SSPRLABORREGIME = "ssprLaborRegime";
    public static final String PROPERTY_REASONENDPERIOD = "reasonendperiod";
    public static final String PROPERTY_PERMANENTREMUNERATION = "permanentremuneration";
    public static final String PROPERTY_HOURSPERWEEK = "hoursperweek";
    public static final String PROPERTY_ACTIVITY = "activity";
    public static final String PROPERTY_EMPLOYEESTATUS = "employeestatus";
    public static final String PROPERTY_SSPRCONTRACTTYPE = "ssprContracttype";
    public static final String PROPERTY_FORMATTYPE = "formattype";
    public static final String PROPERTY_PREVIOUSINCOME = "previousincome";
    public static final String PROPERTY_PREVIOUSWITHHOLDING = "previouswithholding";
    public static final String PROPERTY_CONTRACTADDENDUM = "contractaddendum";
    public static final String PROPERTY_SFPRGRADE = "sfprGrade";
    public static final String PROPERTY_YEAR = "year";
    public static final String PROPERTY_SFPRLEVEL = "sfprLevel";
    public static final String PROPERTY_SSPRCONCEPT = "ssprConcept";
    public static final String PROPERTY_STARTDATEENDDATE = "startdateEnddate";
    public static final String PROPERTY_STATUSLIQUIDATION = "statusliquidation";
    public static final String PROPERTY_CITY = "city";
    public static final String PROPERTY_UPDATESALARY = "updateSalary";
    public static final String PROPERTY_ISPARTTIME = "isparttime";
    public static final String PROPERTY_WEEKLYHOURSPARTTIME = "weeklyhoursparttime";
    public static final String PROPERTY_STDIMENSION = "stDimension";
    public static final String PROPERTY_SSPRCONTRACTCONTRACTADDENDUMIDLIST = "sSPRContractContractaddendumIDList";
    public static final String PROPERTY_SSPRCONTRACTPOSITIONLIST = "sSPRContractPositionList";
    public static final String PROPERTY_SFPREMPLOYEESITUATIONEMSSPRCONTRACTIDLIST = "sfprEmployeeSituationEMSsprContractIDList";
    public static final String PROPERTY_SFPREMPLOYEESITUATION2EMSSPRCONTRACTIDLIST = "sfprEmployeeSituation2EMSsprContractIDList";
    public static final String PROPERTY_SFPREVOLUTIONSALARYLIST = "sfprEvolutionSalaryList";
    public static final String PROPERTY_SSPRPAYROLLEMPLIST = "ssprPayrollEmpList";
    public static final String PROPERTY_SSPRSETTLEMENTLIST = "ssprSettlementList";
    public static final String PROPERTY_SSPRVACATIONSLIST = "ssprVacationsList";

    public Contract() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_ISNIGHT, false);
        setDefaultValue(PROPERTY_ISCUMULATIVEREGIME, false);
        setDefaultValue(PROPERTY_ISTIMEMAX, false);
        setDefaultValue(PROPERTY_PERMANENTREMUNERATION, new BigDecimal(0));
        setDefaultValue(PROPERTY_HOURSPERWEEK, (long) 0);
        setDefaultValue(PROPERTY_PREVIOUSINCOME, new BigDecimal(0));
        setDefaultValue(PROPERTY_PREVIOUSWITHHOLDING, new BigDecimal(0));
        setDefaultValue(PROPERTY_STATUSLIQUIDATION, false);
        setDefaultValue(PROPERTY_UPDATESALARY, false);
        setDefaultValue(PROPERTY_ISPARTTIME, false);
        setDefaultValue(PROPERTY_SSPRCONTRACTCONTRACTADDENDUMIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRCONTRACTPOSITIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPREMPLOYEESITUATIONEMSSPRCONTRACTIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPREMPLOYEESITUATION2EMSSPRCONTRACTIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPREVOLUTIONSALARYLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRPAYROLLEMPLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRSETTLEMENTLIST, new ArrayList<Object>());
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

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public String getContractcondition() {
        return (String) get(PROPERTY_CONTRACTCONDITION);
    }

    public void setContractcondition(String contractcondition) {
        set(PROPERTY_CONTRACTCONDITION, contractcondition);
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

    public Boolean isNight() {
        return (Boolean) get(PROPERTY_ISNIGHT);
    }

    public void setNight(Boolean isnight) {
        set(PROPERTY_ISNIGHT, isnight);
    }

    public Boolean isCumulativeregime() {
        return (Boolean) get(PROPERTY_ISCUMULATIVEREGIME);
    }

    public void setCumulativeregime(Boolean iscumulativeregime) {
        set(PROPERTY_ISCUMULATIVEREGIME, iscumulativeregime);
    }

    public Boolean isTimemax() {
        return (Boolean) get(PROPERTY_ISTIMEMAX);
    }

    public void setTimemax(Boolean istimemax) {
        set(PROPERTY_ISTIMEMAX, istimemax);
    }

    public Shift getSsprShift() {
        return (Shift) get(PROPERTY_SSPRSHIFT);
    }

    public void setSsprShift(Shift ssprShift) {
        set(PROPERTY_SSPRSHIFT, ssprShift);
    }

    public LaborRegime getSsprLaborRegime() {
        return (LaborRegime) get(PROPERTY_SSPRLABORREGIME);
    }

    public void setSsprLaborRegime(LaborRegime ssprLaborRegime) {
        set(PROPERTY_SSPRLABORREGIME, ssprLaborRegime);
    }

    public String getReasonendperiod() {
        return (String) get(PROPERTY_REASONENDPERIOD);
    }

    public void setReasonendperiod(String reasonendperiod) {
        set(PROPERTY_REASONENDPERIOD, reasonendperiod);
    }

    public BigDecimal getPermanentremuneration() {
        return (BigDecimal) get(PROPERTY_PERMANENTREMUNERATION);
    }

    public void setPermanentremuneration(BigDecimal permanentremuneration) {
        set(PROPERTY_PERMANENTREMUNERATION, permanentremuneration);
    }

    public Long getHoursperweek() {
        return (Long) get(PROPERTY_HOURSPERWEEK);
    }

    public void setHoursperweek(Long hoursperweek) {
        set(PROPERTY_HOURSPERWEEK, hoursperweek);
    }

    public String getActivity() {
        return (String) get(PROPERTY_ACTIVITY);
    }

    public void setActivity(String activity) {
        set(PROPERTY_ACTIVITY, activity);
    }

    public String getEmployeestatus() {
        return (String) get(PROPERTY_EMPLOYEESTATUS);
    }

    public void setEmployeestatus(String employeestatus) {
        set(PROPERTY_EMPLOYEESTATUS, employeestatus);
    }

    public ContractType getSsprContracttype() {
        return (ContractType) get(PROPERTY_SSPRCONTRACTTYPE);
    }

    public void setSsprContracttype(ContractType ssprContracttype) {
        set(PROPERTY_SSPRCONTRACTTYPE, ssprContracttype);
    }

    public String getFormattype() {
        return (String) get(PROPERTY_FORMATTYPE);
    }

    public void setFormattype(String formattype) {
        set(PROPERTY_FORMATTYPE, formattype);
    }

    public BigDecimal getPreviousincome() {
        return (BigDecimal) get(PROPERTY_PREVIOUSINCOME);
    }

    public void setPreviousincome(BigDecimal previousincome) {
        set(PROPERTY_PREVIOUSINCOME, previousincome);
    }

    public BigDecimal getPreviouswithholding() {
        return (BigDecimal) get(PROPERTY_PREVIOUSWITHHOLDING);
    }

    public void setPreviouswithholding(BigDecimal previouswithholding) {
        set(PROPERTY_PREVIOUSWITHHOLDING, previouswithholding);
    }

    public Contract getContractaddendum() {
        return (Contract) get(PROPERTY_CONTRACTADDENDUM);
    }

    public void setContractaddendum(Contract contractaddendum) {
        set(PROPERTY_CONTRACTADDENDUM, contractaddendum);
    }

    public SfprGrade getSfprGrade() {
        return (SfprGrade) get(PROPERTY_SFPRGRADE);
    }

    public void setSfprGrade(SfprGrade sfprGrade) {
        set(PROPERTY_SFPRGRADE, sfprGrade);
    }

    public Year getYear() {
        return (Year) get(PROPERTY_YEAR);
    }

    public void setYear(Year year) {
        set(PROPERTY_YEAR, year);
    }

    public SfprLevel getSfprLevel() {
        return (SfprLevel) get(PROPERTY_SFPRLEVEL);
    }

    public void setSfprLevel(SfprLevel sfprLevel) {
        set(PROPERTY_SFPRLEVEL, sfprLevel);
    }

    public Concept getSsprConcept() {
        return (Concept) get(PROPERTY_SSPRCONCEPT);
    }

    public void setSsprConcept(Concept ssprConcept) {
        set(PROPERTY_SSPRCONCEPT, ssprConcept);
    }

    public String getStartdateEnddate() {
        return (String) get(PROPERTY_STARTDATEENDDATE);
    }

    public void setStartdateEnddate(String startdateEnddate) {
        set(PROPERTY_STARTDATEENDDATE, startdateEnddate);
    }

    public Boolean isStatusliquidation() {
        return (Boolean) get(PROPERTY_STATUSLIQUIDATION);
    }

    public void setStatusliquidation(Boolean statusliquidation) {
        set(PROPERTY_STATUSLIQUIDATION, statusliquidation);
    }

    public City getCity() {
        return (City) get(PROPERTY_CITY);
    }

    public void setCity(City city) {
        set(PROPERTY_CITY, city);
    }

    public Boolean isUpdateSalary() {
        return (Boolean) get(PROPERTY_UPDATESALARY);
    }

    public void setUpdateSalary(Boolean updateSalary) {
        set(PROPERTY_UPDATESALARY, updateSalary);
    }

    public Boolean isParttime() {
        return (Boolean) get(PROPERTY_ISPARTTIME);
    }

    public void setParttime(Boolean isparttime) {
        set(PROPERTY_ISPARTTIME, isparttime);
    }

    public Long getWeeklyhoursparttime() {
        return (Long) get(PROPERTY_WEEKLYHOURSPARTTIME);
    }

    public void setWeeklyhoursparttime(Long weeklyhoursparttime) {
        set(PROPERTY_WEEKLYHOURSPARTTIME, weeklyhoursparttime);
    }

    public UserDimension1 getStDimension() {
        return (UserDimension1) get(PROPERTY_STDIMENSION);
    }

    public void setStDimension(UserDimension1 stDimension) {
        set(PROPERTY_STDIMENSION, stDimension);
    }

    @SuppressWarnings("unchecked")
    public List<Contract> getSSPRContractContractaddendumIDList() {
      return (List<Contract>) get(PROPERTY_SSPRCONTRACTCONTRACTADDENDUMIDLIST);
    }

    public void setSSPRContractContractaddendumIDList(List<Contract> sSPRContractContractaddendumIDList) {
        set(PROPERTY_SSPRCONTRACTCONTRACTADDENDUMIDLIST, sSPRContractContractaddendumIDList);
    }

    @SuppressWarnings("unchecked")
    public List<ContractPosition> getSSPRContractPositionList() {
      return (List<ContractPosition>) get(PROPERTY_SSPRCONTRACTPOSITIONLIST);
    }

    public void setSSPRContractPositionList(List<ContractPosition> sSPRContractPositionList) {
        set(PROPERTY_SSPRCONTRACTPOSITIONLIST, sSPRContractPositionList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprEmployeeSituation> getSfprEmployeeSituationEMSsprContractIDList() {
      return (List<SfprEmployeeSituation>) get(PROPERTY_SFPREMPLOYEESITUATIONEMSSPRCONTRACTIDLIST);
    }

    public void setSfprEmployeeSituationEMSsprContractIDList(List<SfprEmployeeSituation> sfprEmployeeSituationEMSsprContractIDList) {
        set(PROPERTY_SFPREMPLOYEESITUATIONEMSSPRCONTRACTIDLIST, sfprEmployeeSituationEMSsprContractIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprEmployeeSituationProposal> getSfprEmployeeSituation2EMSsprContractIDList() {
      return (List<SfprEmployeeSituationProposal>) get(PROPERTY_SFPREMPLOYEESITUATION2EMSSPRCONTRACTIDLIST);
    }

    public void setSfprEmployeeSituation2EMSsprContractIDList(List<SfprEmployeeSituationProposal> sfprEmployeeSituation2EMSsprContractIDList) {
        set(PROPERTY_SFPREMPLOYEESITUATION2EMSSPRCONTRACTIDLIST, sfprEmployeeSituation2EMSsprContractIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprEvolutionSalary> getSfprEvolutionSalaryList() {
      return (List<SfprEvolutionSalary>) get(PROPERTY_SFPREVOLUTIONSALARYLIST);
    }

    public void setSfprEvolutionSalaryList(List<SfprEvolutionSalary> sfprEvolutionSalaryList) {
        set(PROPERTY_SFPREVOLUTIONSALARYLIST, sfprEvolutionSalaryList);
    }

    @SuppressWarnings("unchecked")
    public List<sspr_payrollemp> getSsprPayrollEmpList() {
      return (List<sspr_payrollemp>) get(PROPERTY_SSPRPAYROLLEMPLIST);
    }

    public void setSsprPayrollEmpList(List<sspr_payrollemp> ssprPayrollEmpList) {
        set(PROPERTY_SSPRPAYROLLEMPLIST, ssprPayrollEmpList);
    }

    @SuppressWarnings("unchecked")
    public List<sspr_settlement> getSsprSettlementList() {
      return (List<sspr_settlement>) get(PROPERTY_SSPRSETTLEMENTLIST);
    }

    public void setSsprSettlementList(List<sspr_settlement> ssprSettlementList) {
        set(PROPERTY_SSPRSETTLEMENTLIST, ssprSettlementList);
    }

    @SuppressWarnings("unchecked")
    public List<ssprvacations> getSsprVacationsList() {
      return (List<ssprvacations>) get(PROPERTY_SSPRVACATIONSLIST);
    }

    public void setSsprVacationsList(List<ssprvacations> ssprVacationsList) {
        set(PROPERTY_SSPRVACATIONSLIST, ssprVacationsList);
    }

}
