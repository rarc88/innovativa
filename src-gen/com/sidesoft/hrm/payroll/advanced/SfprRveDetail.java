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
package com.sidesoft.hrm.payroll.advanced;

import com.sidesoft.flopec.ssflVesseltype;
import com.sidesoft.hrm.payroll.Concept;
import com.sidesoft.hrm.payroll.ConceptAmount;
import com.sidesoft.hrm.payroll.Position;
import com.sidesoft.hrm.payroll.ssprcategoryacct;

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
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.calendar.Period;
/**
 * Entity class for entity sfpr_rve_detail (stored in table sfpr_rve_detail).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SfprRveDetail extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sfpr_rve_detail";
    public static final String ENTITY_NAME = "sfpr_rve_detail";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_SFPRRVE = "sfprRve";
    public static final String PROPERTY_PERIOD = "period";
    public static final String PROPERTY_EMPLOYEE = "employee";
    public static final String PROPERTY_NODAYS = "noDays";
    public static final String PROPERTY_GRANDTOTALAMOUNT = "grandTotalAmount";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CONCEPT = "concept";
    public static final String PROPERTY_STATUS = "status";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_PERIODPROCESS = "periodProcess";
    public static final String PROPERTY_MOVEMENTTYPE = "movementType";
    public static final String PROPERTY_SSFLVESSELTYPE = "sSFLVesselType";
    public static final String PROPERTY_UNPROCESSED = "unprocessed";
    public static final String PROPERTY_SFPREMPLOYEERVE = "sfprEmployeeRve";
    public static final String PROPERTY_COSTCENTER = "costcenter";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_ISPAYMENTRVE = "ispaymentrve";
    public static final String PROPERTY_CONCEPTPAYMENTRVE = "conceptPaymentRve";
    public static final String PROPERTY_TODISCOUNT = "toDiscount";
    public static final String PROPERTY_STARTINGDATE = "startingDate";
    public static final String PROPERTY_ENDINGDATE = "endingDate";
    public static final String PROPERTY_SSPRCATEGORYACCT = "ssprCategoryAcct";
    public static final String PROPERTY_RVEPAYONBOARD = "rVEPayOnBoard";
    public static final String PROPERTY_POSITION = "position";
    public static final String PROPERTY_SUPPLEMENTARYHOURS = "supplementaryHours";
    public static final String PROPERTY_EXTRAORDINARYHOURS = "extraordinaryHours";
    public static final String PROPERTY_RMU = "rmu";
    public static final String PROPERTY_SSPRCONCEPTAMOUNTEMSFPRRVEDETAILIDLIST = "sSPRConceptAmountEMSfprRveDetailIDList";

    public SfprRveDetail() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_STATUS, "DR");
        setDefaultValue(PROPERTY_PROCESSED, false);
        setDefaultValue(PROPERTY_UNPROCESSED, false);
        setDefaultValue(PROPERTY_ISPAYMENTRVE, false);
        setDefaultValue(PROPERTY_TODISCOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_RMU, new BigDecimal(0));
        setDefaultValue(PROPERTY_SSPRCONCEPTAMOUNTEMSFPRRVEDETAILIDLIST, new ArrayList<Object>());
    }

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
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

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
    }

    public SfprRve getSfprRve() {
        return (SfprRve) get(PROPERTY_SFPRRVE);
    }

    public void setSfprRve(SfprRve sfprRve) {
        set(PROPERTY_SFPRRVE, sfprRve);
    }

    public Period getPeriod() {
        return (Period) get(PROPERTY_PERIOD);
    }

    public void setPeriod(Period period) {
        set(PROPERTY_PERIOD, period);
    }

    public BusinessPartner getEmployee() {
        return (BusinessPartner) get(PROPERTY_EMPLOYEE);
    }

    public void setEmployee(BusinessPartner employee) {
        set(PROPERTY_EMPLOYEE, employee);
    }

    public Long getNoDays() {
        return (Long) get(PROPERTY_NODAYS);
    }

    public void setNoDays(Long noDays) {
        set(PROPERTY_NODAYS, noDays);
    }

    public BigDecimal getGrandTotalAmount() {
        return (BigDecimal) get(PROPERTY_GRANDTOTALAMOUNT);
    }

    public void setGrandTotalAmount(BigDecimal grandTotalAmount) {
        set(PROPERTY_GRANDTOTALAMOUNT, grandTotalAmount);
    }

    public Boolean isActive() {
        return (Boolean) get(PROPERTY_ACTIVE);
    }

    public void setActive(Boolean active) {
        set(PROPERTY_ACTIVE, active);
    }

    public Concept getConcept() {
        return (Concept) get(PROPERTY_CONCEPT);
    }

    public void setConcept(Concept concept) {
        set(PROPERTY_CONCEPT, concept);
    }

    public String getStatus() {
        return (String) get(PROPERTY_STATUS);
    }

    public void setStatus(String status) {
        set(PROPERTY_STATUS, status);
    }

    public Boolean isProcessed() {
        return (Boolean) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(Boolean processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public Period getPeriodProcess() {
        return (Period) get(PROPERTY_PERIODPROCESS);
    }

    public void setPeriodProcess(Period periodProcess) {
        set(PROPERTY_PERIODPROCESS, periodProcess);
    }

    public SfprMovementType getMovementType() {
        return (SfprMovementType) get(PROPERTY_MOVEMENTTYPE);
    }

    public void setMovementType(SfprMovementType movementType) {
        set(PROPERTY_MOVEMENTTYPE, movementType);
    }

    public ssflVesseltype getSSFLVesselType() {
        return (ssflVesseltype) get(PROPERTY_SSFLVESSELTYPE);
    }

    public void setSSFLVesselType(ssflVesseltype sSFLVesselType) {
        set(PROPERTY_SSFLVESSELTYPE, sSFLVesselType);
    }

    public Boolean isUnprocessed() {
        return (Boolean) get(PROPERTY_UNPROCESSED);
    }

    public void setUnprocessed(Boolean unprocessed) {
        set(PROPERTY_UNPROCESSED, unprocessed);
    }

    public SfprEmployeeRve getSfprEmployeeRve() {
        return (SfprEmployeeRve) get(PROPERTY_SFPREMPLOYEERVE);
    }

    public void setSfprEmployeeRve(SfprEmployeeRve sfprEmployeeRve) {
        set(PROPERTY_SFPREMPLOYEERVE, sfprEmployeeRve);
    }

    public Costcenter getCostcenter() {
        return (Costcenter) get(PROPERTY_COSTCENTER);
    }

    public void setCostcenter(Costcenter costcenter) {
        set(PROPERTY_COSTCENTER, costcenter);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Boolean isPaymentrve() {
        return (Boolean) get(PROPERTY_ISPAYMENTRVE);
    }

    public void setPaymentrve(Boolean ispaymentrve) {
        set(PROPERTY_ISPAYMENTRVE, ispaymentrve);
    }

    public Concept getConceptPaymentRve() {
        return (Concept) get(PROPERTY_CONCEPTPAYMENTRVE);
    }

    public void setConceptPaymentRve(Concept conceptPaymentRve) {
        set(PROPERTY_CONCEPTPAYMENTRVE, conceptPaymentRve);
    }

    public BigDecimal getToDiscount() {
        return (BigDecimal) get(PROPERTY_TODISCOUNT);
    }

    public void setToDiscount(BigDecimal toDiscount) {
        set(PROPERTY_TODISCOUNT, toDiscount);
    }

    public Date getStartingDate() {
        return (Date) get(PROPERTY_STARTINGDATE);
    }

    public void setStartingDate(Date startingDate) {
        set(PROPERTY_STARTINGDATE, startingDate);
    }

    public Date getEndingDate() {
        return (Date) get(PROPERTY_ENDINGDATE);
    }

    public void setEndingDate(Date endingDate) {
        set(PROPERTY_ENDINGDATE, endingDate);
    }

    public ssprcategoryacct getSsprCategoryAcct() {
        return (ssprcategoryacct) get(PROPERTY_SSPRCATEGORYACCT);
    }

    public void setSsprCategoryAcct(ssprcategoryacct ssprCategoryAcct) {
        set(PROPERTY_SSPRCATEGORYACCT, ssprCategoryAcct);
    }

    public BigDecimal getRVEPayOnBoard() {
        return (BigDecimal) get(PROPERTY_RVEPAYONBOARD);
    }

    public void setRVEPayOnBoard(BigDecimal rVEPayOnBoard) {
        set(PROPERTY_RVEPAYONBOARD, rVEPayOnBoard);
    }

    public Position getPosition() {
        return (Position) get(PROPERTY_POSITION);
    }

    public void setPosition(Position position) {
        set(PROPERTY_POSITION, position);
    }

    public BigDecimal getSupplementaryHours() {
        return (BigDecimal) get(PROPERTY_SUPPLEMENTARYHOURS);
    }

    public void setSupplementaryHours(BigDecimal supplementaryHours) {
        set(PROPERTY_SUPPLEMENTARYHOURS, supplementaryHours);
    }

    public BigDecimal getExtraordinaryHours() {
        return (BigDecimal) get(PROPERTY_EXTRAORDINARYHOURS);
    }

    public void setExtraordinaryHours(BigDecimal extraordinaryHours) {
        set(PROPERTY_EXTRAORDINARYHOURS, extraordinaryHours);
    }

    public BigDecimal getRmu() {
        return (BigDecimal) get(PROPERTY_RMU);
    }

    public void setRmu(BigDecimal rmu) {
        set(PROPERTY_RMU, rmu);
    }

    @SuppressWarnings("unchecked")
    public List<ConceptAmount> getSSPRConceptAmountEMSfprRveDetailIDList() {
      return (List<ConceptAmount>) get(PROPERTY_SSPRCONCEPTAMOUNTEMSFPRRVEDETAILIDLIST);
    }

    public void setSSPRConceptAmountEMSfprRveDetailIDList(List<ConceptAmount> sSPRConceptAmountEMSfprRveDetailIDList) {
        set(PROPERTY_SSPRCONCEPTAMOUNTEMSFPRRVEDETAILIDLIST, sSPRConceptAmountEMSfprRveDetailIDList);
    }

}
