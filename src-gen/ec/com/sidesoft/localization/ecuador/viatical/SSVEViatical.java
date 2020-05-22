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
package ec.com.sidesoft.localization.ecuador.viatical;

import com.sidesoft.flopec.budget.data.SFBBudgetArea;
import com.sidesoft.flopec.budget.data.SFBBudgetCertLine;
import com.sidesoft.hrm.payroll.Position;
import com.sidesoft.localization.ecuador.finances.ssfiBanktransfer;

import java.math.BigDecimal;
import java.sql.Timestamp;
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
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.geography.City;
import org.openbravo.model.common.geography.Country;
import org.openbravo.model.common.geography.Region;
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.accounting.UserDimension1;
import org.openbravo.model.financialmgmt.payment.FIN_Payment;
/**
 * Entity class for entity SSVE_Viatical (stored in table SSVE_Viatical).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SSVEViatical extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "SSVE_Viatical";
    public static final String ENTITY_NAME = "SSVE_Viatical";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_APPLICATIONDATE = "applicationDate";
    public static final String PROPERTY_PROCESSNOW = "processNow";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_TOTALVIATICALAMMOUNT = "totalViaticalAmmount";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_DOCUMENTTYPE = "documentType";
    public static final String PROPERTY_TOTALTRANSPAMMOUNT = "totalTranspAmmount";
    public static final String PROPERTY_DOCUMENTSTATUS = "documentStatus";
    public static final String PROPERTY_DOCUMENTACTION = "documentAction";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_GETLINES = "getLines";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_TOTALAMOUNT = "totalAmount";
    public static final String PROPERTY_COUNTRY = "country";
    public static final String PROPERTY_REGION = "region";
    public static final String PROPERTY_CITY = "city";
    public static final String PROPERTY_DEPARTUREDATE = "departureDate";
    public static final String PROPERTY_ARRIVALDATE = "arrivalDate";
    public static final String PROPERTY_DEPARTURETIME = "departureTime";
    public static final String PROPERTY_ARRIVALTIME = "arrivalTime";
    public static final String PROPERTY_NATIONALIDENTIFICATIONDOCUMENT = "nationalIdentificationDocument";
    public static final String PROPERTY_SSFIBANKTRANSFER = "ssfiBanktransfer";
    public static final String PROPERTY_ACCOUNTTYPE = "accountType";
    public static final String PROPERTY_POSITION = "position";
    public static final String PROPERTY_ISBASED = "isBased";
    public static final String PROPERTY_VIATICALTYPE = "viaticalType";
    public static final String PROPERTY_EMPLOYEECITY = "employeeCity";
    public static final String PROPERTY_MOBILDEPARTUREDATE = "mobilDepartureDate";
    public static final String PROPERTY_MOBILARRIVALDATE = "mobilArrivalDate";
    public static final String PROPERTY_MOBILDEPARTURETIME = "mobilDepartureTime";
    public static final String PROPERTY_MOBILARRIVALTIME = "mobilArrivalTime";
    public static final String PROPERTY_TRANSPORTATIONTYPE = "transportationType";
    public static final String PROPERTY_ADDITIONALFUNDS = "additionalFunds";
    public static final String PROPERTY_MOBILIZATIONAMMOUNT = "mobilizationAmmount";
    public static final String PROPERTY_FEEDINGAMMOUNT = "feedingAmmount";
    public static final String PROPERTY_MOBILIZATIONCITY = "mobilizationCity";
    public static final String PROPERTY_MOBILIZATIONDESCRIPTION = "mobilizationDescription";
    public static final String PROPERTY_HASHCODE = "hashCode";
    public static final String PROPERTY_ISNOTBUDGETABLE = "isNotBudgetable";
    public static final String PROPERTY_AREA = "area";
    public static final String PROPERTY_ISBUDGETED = "isBudgeted";
    public static final String PROPERTY_STDIMENSION = "stDimension";
    public static final String PROPERTY_COSTCENTER = "costCenter";
    public static final String PROPERTY_CERTIFICATELINEFORADDITIONALVALUES = "certificateLineForAdditionalValues";
    public static final String PROPERTY_BUDGETADDITIONALFUNDS = "budgetAdditionalFunds";
    public static final String PROPERTY_BUDGETMOBILIZATIONAMOUNT = "budgetMobilizationAmount";
    public static final String PROPERTY_BUDGETFEEDINGAMT = "budgetfeedingamt";
    public static final String PROPERTY_LEAVEWITHPAY = "leaveWithPay";
    public static final String PROPERTY_COMMISSIONPEOPLE = "commissionPeople";
    public static final String PROPERTY_FINPAYMENTEMSSVEVIATICALIDLIST = "fINPaymentEMSsveViaticalIDList";
    public static final String PROPERTY_SSVEVIATICALLINELIST = "sSVEViaticalLineList";
    public static final String PROPERTY_SSVEVIATICALSETTLEMENTLIST = "sSVEViaticalSettlementList";
    public static final String PROPERTY_SSVEVIATICALTRANSPLIST = "sSVEViaticalTranspList";
    public static final String PROPERTY_SSVEBUDGETDETAILSVLIST = "ssveBudgetDetailsVList";
    public static final String PROPERTY_SSVEVIATICALDETAILSVLIST = "ssveViaticalDetailsVList";

    public SSVEViatical() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_PROCESSNOW, false);
        setDefaultValue(PROPERTY_PROCESSED, "N");
        setDefaultValue(PROPERTY_TOTALVIATICALAMMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_TOTALTRANSPAMMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_DOCUMENTSTATUS, "DR");
        setDefaultValue(PROPERTY_DOCUMENTACTION, "--");
        setDefaultValue(PROPERTY_GETLINES, false);
        setDefaultValue(PROPERTY_TOTALAMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_ISBASED, false);
        setDefaultValue(PROPERTY_ADDITIONALFUNDS, new BigDecimal(0));
        setDefaultValue(PROPERTY_MOBILIZATIONAMMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_FEEDINGAMMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_ISNOTBUDGETABLE, false);
        setDefaultValue(PROPERTY_ISBUDGETED, false);
        setDefaultValue(PROPERTY_BUDGETADDITIONALFUNDS, new BigDecimal(0));
        setDefaultValue(PROPERTY_BUDGETMOBILIZATIONAMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_BUDGETFEEDINGAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_FINPAYMENTEMSSVEVIATICALIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSVEVIATICALLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSVEVIATICALSETTLEMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSVEVIATICALTRANSPLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSVEBUDGETDETAILSVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSVEVIATICALDETAILSVLIST, new ArrayList<Object>());
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

    public Date getApplicationDate() {
        return (Date) get(PROPERTY_APPLICATIONDATE);
    }

    public void setApplicationDate(Date applicationDate) {
        set(PROPERTY_APPLICATIONDATE, applicationDate);
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

    public BigDecimal getTotalViaticalAmmount() {
        return (BigDecimal) get(PROPERTY_TOTALVIATICALAMMOUNT);
    }

    public void setTotalViaticalAmmount(BigDecimal totalViaticalAmmount) {
        set(PROPERTY_TOTALVIATICALAMMOUNT, totalViaticalAmmount);
    }

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

    public DocumentType getDocumentType() {
        return (DocumentType) get(PROPERTY_DOCUMENTTYPE);
    }

    public void setDocumentType(DocumentType documentType) {
        set(PROPERTY_DOCUMENTTYPE, documentType);
    }

    public BigDecimal getTotalTranspAmmount() {
        return (BigDecimal) get(PROPERTY_TOTALTRANSPAMMOUNT);
    }

    public void setTotalTranspAmmount(BigDecimal totalTranspAmmount) {
        set(PROPERTY_TOTALTRANSPAMMOUNT, totalTranspAmmount);
    }

    public String getDocumentStatus() {
        return (String) get(PROPERTY_DOCUMENTSTATUS);
    }

    public void setDocumentStatus(String documentStatus) {
        set(PROPERTY_DOCUMENTSTATUS, documentStatus);
    }

    public String getDocumentAction() {
        return (String) get(PROPERTY_DOCUMENTACTION);
    }

    public void setDocumentAction(String documentAction) {
        set(PROPERTY_DOCUMENTACTION, documentAction);
    }

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public Boolean isGetLines() {
        return (Boolean) get(PROPERTY_GETLINES);
    }

    public void setGetLines(Boolean getLines) {
        set(PROPERTY_GETLINES, getLines);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public BigDecimal getTotalAmount() {
        return (BigDecimal) get(PROPERTY_TOTALAMOUNT);
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        set(PROPERTY_TOTALAMOUNT, totalAmount);
    }

    public Country getCountry() {
        return (Country) get(PROPERTY_COUNTRY);
    }

    public void setCountry(Country country) {
        set(PROPERTY_COUNTRY, country);
    }

    public Region getRegion() {
        return (Region) get(PROPERTY_REGION);
    }

    public void setRegion(Region region) {
        set(PROPERTY_REGION, region);
    }

    public City getCity() {
        return (City) get(PROPERTY_CITY);
    }

    public void setCity(City city) {
        set(PROPERTY_CITY, city);
    }

    public Date getDepartureDate() {
        return (Date) get(PROPERTY_DEPARTUREDATE);
    }

    public void setDepartureDate(Date departureDate) {
        set(PROPERTY_DEPARTUREDATE, departureDate);
    }

    public Date getArrivalDate() {
        return (Date) get(PROPERTY_ARRIVALDATE);
    }

    public void setArrivalDate(Date arrivalDate) {
        set(PROPERTY_ARRIVALDATE, arrivalDate);
    }

    public Timestamp getDepartureTime() {
        return (Timestamp) get(PROPERTY_DEPARTURETIME);
    }

    public void setDepartureTime(Timestamp departureTime) {
        set(PROPERTY_DEPARTURETIME, departureTime);
    }

    public Timestamp getArrivalTime() {
        return (Timestamp) get(PROPERTY_ARRIVALTIME);
    }

    public void setArrivalTime(Timestamp arrivalTime) {
        set(PROPERTY_ARRIVALTIME, arrivalTime);
    }

    public String getNationalIdentificationDocument() {
        return (String) get(PROPERTY_NATIONALIDENTIFICATIONDOCUMENT);
    }

    public void setNationalIdentificationDocument(String nationalIdentificationDocument) {
        set(PROPERTY_NATIONALIDENTIFICATIONDOCUMENT, nationalIdentificationDocument);
    }

    public ssfiBanktransfer getSsfiBanktransfer() {
        return (ssfiBanktransfer) get(PROPERTY_SSFIBANKTRANSFER);
    }

    public void setSsfiBanktransfer(ssfiBanktransfer ssfiBanktransfer) {
        set(PROPERTY_SSFIBANKTRANSFER, ssfiBanktransfer);
    }

    public String getAccountType() {
        return (String) get(PROPERTY_ACCOUNTTYPE);
    }

    public void setAccountType(String accountType) {
        set(PROPERTY_ACCOUNTTYPE, accountType);
    }

    public Position getPosition() {
        return (Position) get(PROPERTY_POSITION);
    }

    public void setPosition(Position position) {
        set(PROPERTY_POSITION, position);
    }

    public Boolean isBased() {
        return (Boolean) get(PROPERTY_ISBASED);
    }

    public void setBased(Boolean isBased) {
        set(PROPERTY_ISBASED, isBased);
    }

    public String getViaticalType() {
        return (String) get(PROPERTY_VIATICALTYPE);
    }

    public void setViaticalType(String viaticalType) {
        set(PROPERTY_VIATICALTYPE, viaticalType);
    }

    public City getEmployeeCity() {
        return (City) get(PROPERTY_EMPLOYEECITY);
    }

    public void setEmployeeCity(City employeeCity) {
        set(PROPERTY_EMPLOYEECITY, employeeCity);
    }

    public Date getMobilDepartureDate() {
        return (Date) get(PROPERTY_MOBILDEPARTUREDATE);
    }

    public void setMobilDepartureDate(Date mobilDepartureDate) {
        set(PROPERTY_MOBILDEPARTUREDATE, mobilDepartureDate);
    }

    public Date getMobilArrivalDate() {
        return (Date) get(PROPERTY_MOBILARRIVALDATE);
    }

    public void setMobilArrivalDate(Date mobilArrivalDate) {
        set(PROPERTY_MOBILARRIVALDATE, mobilArrivalDate);
    }

    public Timestamp getMobilDepartureTime() {
        return (Timestamp) get(PROPERTY_MOBILDEPARTURETIME);
    }

    public void setMobilDepartureTime(Timestamp mobilDepartureTime) {
        set(PROPERTY_MOBILDEPARTURETIME, mobilDepartureTime);
    }

    public Timestamp getMobilArrivalTime() {
        return (Timestamp) get(PROPERTY_MOBILARRIVALTIME);
    }

    public void setMobilArrivalTime(Timestamp mobilArrivalTime) {
        set(PROPERTY_MOBILARRIVALTIME, mobilArrivalTime);
    }

    public String getTransportationType() {
        return (String) get(PROPERTY_TRANSPORTATIONTYPE);
    }

    public void setTransportationType(String transportationType) {
        set(PROPERTY_TRANSPORTATIONTYPE, transportationType);
    }

    public BigDecimal getAdditionalFunds() {
        return (BigDecimal) get(PROPERTY_ADDITIONALFUNDS);
    }

    public void setAdditionalFunds(BigDecimal additionalFunds) {
        set(PROPERTY_ADDITIONALFUNDS, additionalFunds);
    }

    public BigDecimal getMobilizationAmmount() {
        return (BigDecimal) get(PROPERTY_MOBILIZATIONAMMOUNT);
    }

    public void setMobilizationAmmount(BigDecimal mobilizationAmmount) {
        set(PROPERTY_MOBILIZATIONAMMOUNT, mobilizationAmmount);
    }

    public BigDecimal getFeedingAmmount() {
        return (BigDecimal) get(PROPERTY_FEEDINGAMMOUNT);
    }

    public void setFeedingAmmount(BigDecimal feedingAmmount) {
        set(PROPERTY_FEEDINGAMMOUNT, feedingAmmount);
    }

    public City getMobilizationCity() {
        return (City) get(PROPERTY_MOBILIZATIONCITY);
    }

    public void setMobilizationCity(City mobilizationCity) {
        set(PROPERTY_MOBILIZATIONCITY, mobilizationCity);
    }

    public String getMobilizationDescription() {
        return (String) get(PROPERTY_MOBILIZATIONDESCRIPTION);
    }

    public void setMobilizationDescription(String mobilizationDescription) {
        set(PROPERTY_MOBILIZATIONDESCRIPTION, mobilizationDescription);
    }

    public String getHashCode() {
        return (String) get(PROPERTY_HASHCODE);
    }

    public void setHashCode(String hashCode) {
        set(PROPERTY_HASHCODE, hashCode);
    }

    public Boolean isNotBudgetable() {
        return (Boolean) get(PROPERTY_ISNOTBUDGETABLE);
    }

    public void setNotBudgetable(Boolean isNotBudgetable) {
        set(PROPERTY_ISNOTBUDGETABLE, isNotBudgetable);
    }

    public SFBBudgetArea getArea() {
        return (SFBBudgetArea) get(PROPERTY_AREA);
    }

    public void setArea(SFBBudgetArea area) {
        set(PROPERTY_AREA, area);
    }

    public Boolean isBudgeted() {
        return (Boolean) get(PROPERTY_ISBUDGETED);
    }

    public void setBudgeted(Boolean isBudgeted) {
        set(PROPERTY_ISBUDGETED, isBudgeted);
    }

    public UserDimension1 getStDimension() {
        return (UserDimension1) get(PROPERTY_STDIMENSION);
    }

    public void setStDimension(UserDimension1 stDimension) {
        set(PROPERTY_STDIMENSION, stDimension);
    }

    public Costcenter getCostCenter() {
        return (Costcenter) get(PROPERTY_COSTCENTER);
    }

    public void setCostCenter(Costcenter costCenter) {
        set(PROPERTY_COSTCENTER, costCenter);
    }

    public SFBBudgetCertLine getCertificateLineForAdditionalValues() {
        return (SFBBudgetCertLine) get(PROPERTY_CERTIFICATELINEFORADDITIONALVALUES);
    }

    public void setCertificateLineForAdditionalValues(SFBBudgetCertLine certificateLineForAdditionalValues) {
        set(PROPERTY_CERTIFICATELINEFORADDITIONALVALUES, certificateLineForAdditionalValues);
    }

    public BigDecimal getBudgetAdditionalFunds() {
        return (BigDecimal) get(PROPERTY_BUDGETADDITIONALFUNDS);
    }

    public void setBudgetAdditionalFunds(BigDecimal budgetAdditionalFunds) {
        set(PROPERTY_BUDGETADDITIONALFUNDS, budgetAdditionalFunds);
    }

    public BigDecimal getBudgetMobilizationAmount() {
        return (BigDecimal) get(PROPERTY_BUDGETMOBILIZATIONAMOUNT);
    }

    public void setBudgetMobilizationAmount(BigDecimal budgetMobilizationAmount) {
        set(PROPERTY_BUDGETMOBILIZATIONAMOUNT, budgetMobilizationAmount);
    }

    public BigDecimal getBudgetfeedingamt() {
        return (BigDecimal) get(PROPERTY_BUDGETFEEDINGAMT);
    }

    public void setBudgetfeedingamt(BigDecimal budgetfeedingamt) {
        set(PROPERTY_BUDGETFEEDINGAMT, budgetfeedingamt);
    }

    public String getLeaveWithPay() {
        return (String) get(PROPERTY_LEAVEWITHPAY);
    }

    public void setLeaveWithPay(String leaveWithPay) {
        set(PROPERTY_LEAVEWITHPAY, leaveWithPay);
    }

    public String getCommissionPeople() {
        return (String) get(PROPERTY_COMMISSIONPEOPLE);
    }

    public void setCommissionPeople(String commissionPeople) {
        set(PROPERTY_COMMISSIONPEOPLE, commissionPeople);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_Payment> getFINPaymentEMSsveViaticalIDList() {
      return (List<FIN_Payment>) get(PROPERTY_FINPAYMENTEMSSVEVIATICALIDLIST);
    }

    public void setFINPaymentEMSsveViaticalIDList(List<FIN_Payment> fINPaymentEMSsveViaticalIDList) {
        set(PROPERTY_FINPAYMENTEMSSVEVIATICALIDLIST, fINPaymentEMSsveViaticalIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SSVEViaticalLine> getSSVEViaticalLineList() {
      return (List<SSVEViaticalLine>) get(PROPERTY_SSVEVIATICALLINELIST);
    }

    public void setSSVEViaticalLineList(List<SSVEViaticalLine> sSVEViaticalLineList) {
        set(PROPERTY_SSVEVIATICALLINELIST, sSVEViaticalLineList);
    }

    @SuppressWarnings("unchecked")
    public List<SSVEViaticalSettlement> getSSVEViaticalSettlementList() {
      return (List<SSVEViaticalSettlement>) get(PROPERTY_SSVEVIATICALSETTLEMENTLIST);
    }

    public void setSSVEViaticalSettlementList(List<SSVEViaticalSettlement> sSVEViaticalSettlementList) {
        set(PROPERTY_SSVEVIATICALSETTLEMENTLIST, sSVEViaticalSettlementList);
    }

    @SuppressWarnings("unchecked")
    public List<SSVEViaticalTransp> getSSVEViaticalTranspList() {
      return (List<SSVEViaticalTransp>) get(PROPERTY_SSVEVIATICALTRANSPLIST);
    }

    public void setSSVEViaticalTranspList(List<SSVEViaticalTransp> sSVEViaticalTranspList) {
        set(PROPERTY_SSVEVIATICALTRANSPLIST, sSVEViaticalTranspList);
    }

    @SuppressWarnings("unchecked")
    public List<ssve_budget_details_v> getSsveBudgetDetailsVList() {
      return (List<ssve_budget_details_v>) get(PROPERTY_SSVEBUDGETDETAILSVLIST);
    }

    public void setSsveBudgetDetailsVList(List<ssve_budget_details_v> ssveBudgetDetailsVList) {
        set(PROPERTY_SSVEBUDGETDETAILSVLIST, ssveBudgetDetailsVList);
    }

    @SuppressWarnings("unchecked")
    public List<ssve_viatical_details_v> getSsveViaticalDetailsVList() {
      return (List<ssve_viatical_details_v>) get(PROPERTY_SSVEVIATICALDETAILSVLIST);
    }

    public void setSsveViaticalDetailsVList(List<ssve_viatical_details_v> ssveViaticalDetailsVList) {
        set(PROPERTY_SSVEVIATICALDETAILSVLIST, ssveViaticalDetailsVList);
    }

}
