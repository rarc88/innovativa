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
import org.openbravo.model.financialmgmt.calendar.Period;
/**
 * Entity class for entity sfpr_surrogate_detail (stored in table sfpr_surrogate_detail).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SfprSurrogateDetail extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sfpr_surrogate_detail";
    public static final String ENTITY_NAME = "sfpr_surrogate_detail";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_SFPRMOVEMENTTYPE = "sfprMovementType";
    public static final String PROPERTY_PERIOD = "period";
    public static final String PROPERTY_EMPLOYEE = "employee";
    public static final String PROPERTY_POSITION = "position";
    public static final String PROPERTY_SURROGATERMU = "surrogateRMU";
    public static final String PROPERTY_EMPLOYEERMU = "employeeRMU";
    public static final String PROPERTY_DIFERENCERMU = "diferenceRMU";
    public static final String PROPERTY_NODAYS = "noDays";
    public static final String PROPERTY_GRANDTOTALAMOUNT = "grandTotalAmount";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CONCEPTSURROGATE = "conceptSurrogate";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_STATUS = "status";
    public static final String PROPERTY_PERIODPROCESSED = "periodProcessed";
    public static final String PROPERTY_UNPROCESSED = "unprocessed";
    public static final String PROPERTY_SFPREMPLOYEESURROGATE = "sfprEmployeeSurrogate";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_SSPRCATEGORYACCT = "ssprCategoryAcct";
    public static final String PROPERTY_STARTINGDATE = "startingDate";
    public static final String PROPERTY_ENDINGDATE = "endingDate";
    public static final String PROPERTY_SSPRCONCEPTAMOUNTEMSFPRSURROGATEDETAILIDLIST = "sSPRConceptAmountEMSfprSurrogateDetailIDList";

    public SfprSurrogateDetail() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_PROCESSED, false);
        setDefaultValue(PROPERTY_STATUS, "DR");
        setDefaultValue(PROPERTY_UNPROCESSED, false);
        setDefaultValue(PROPERTY_SSPRCONCEPTAMOUNTEMSFPRSURROGATEDETAILIDLIST, new ArrayList<Object>());
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

    public SfprMovementType getSfprMovementType() {
        return (SfprMovementType) get(PROPERTY_SFPRMOVEMENTTYPE);
    }

    public void setSfprMovementType(SfprMovementType sfprMovementType) {
        set(PROPERTY_SFPRMOVEMENTTYPE, sfprMovementType);
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

    public Position getPosition() {
        return (Position) get(PROPERTY_POSITION);
    }

    public void setPosition(Position position) {
        set(PROPERTY_POSITION, position);
    }

    public BigDecimal getSurrogateRMU() {
        return (BigDecimal) get(PROPERTY_SURROGATERMU);
    }

    public void setSurrogateRMU(BigDecimal surrogateRMU) {
        set(PROPERTY_SURROGATERMU, surrogateRMU);
    }

    public BigDecimal getEmployeeRMU() {
        return (BigDecimal) get(PROPERTY_EMPLOYEERMU);
    }

    public void setEmployeeRMU(BigDecimal employeeRMU) {
        set(PROPERTY_EMPLOYEERMU, employeeRMU);
    }

    public Long getDiferenceRMU() {
        return (Long) get(PROPERTY_DIFERENCERMU);
    }

    public void setDiferenceRMU(Long diferenceRMU) {
        set(PROPERTY_DIFERENCERMU, diferenceRMU);
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

    public Concept getConceptSurrogate() {
        return (Concept) get(PROPERTY_CONCEPTSURROGATE);
    }

    public void setConceptSurrogate(Concept conceptSurrogate) {
        set(PROPERTY_CONCEPTSURROGATE, conceptSurrogate);
    }

    public Boolean isProcessed() {
        return (Boolean) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(Boolean processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public String getStatus() {
        return (String) get(PROPERTY_STATUS);
    }

    public void setStatus(String status) {
        set(PROPERTY_STATUS, status);
    }

    public Period getPeriodProcessed() {
        return (Period) get(PROPERTY_PERIODPROCESSED);
    }

    public void setPeriodProcessed(Period periodProcessed) {
        set(PROPERTY_PERIODPROCESSED, periodProcessed);
    }

    public Boolean isUnprocessed() {
        return (Boolean) get(PROPERTY_UNPROCESSED);
    }

    public void setUnprocessed(Boolean unprocessed) {
        set(PROPERTY_UNPROCESSED, unprocessed);
    }

    public SfprEmployeeSurrogate getSfprEmployeeSurrogate() {
        return (SfprEmployeeSurrogate) get(PROPERTY_SFPREMPLOYEESURROGATE);
    }

    public void setSfprEmployeeSurrogate(SfprEmployeeSurrogate sfprEmployeeSurrogate) {
        set(PROPERTY_SFPREMPLOYEESURROGATE, sfprEmployeeSurrogate);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public ssprcategoryacct getSsprCategoryAcct() {
        return (ssprcategoryacct) get(PROPERTY_SSPRCATEGORYACCT);
    }

    public void setSsprCategoryAcct(ssprcategoryacct ssprCategoryAcct) {
        set(PROPERTY_SSPRCATEGORYACCT, ssprCategoryAcct);
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

    @SuppressWarnings("unchecked")
    public List<ConceptAmount> getSSPRConceptAmountEMSfprSurrogateDetailIDList() {
      return (List<ConceptAmount>) get(PROPERTY_SSPRCONCEPTAMOUNTEMSFPRSURROGATEDETAILIDLIST);
    }

    public void setSSPRConceptAmountEMSfprSurrogateDetailIDList(List<ConceptAmount> sSPRConceptAmountEMSfprSurrogateDetailIDList) {
        set(PROPERTY_SSPRCONCEPTAMOUNTEMSFPRSURROGATEDETAILIDLIST, sSPRConceptAmountEMSfprSurrogateDetailIDList);
    }

}
