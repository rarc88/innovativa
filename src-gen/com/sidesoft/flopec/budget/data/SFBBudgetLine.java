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
package com.sidesoft.flopec.budget.data;

import ec.com.sidesoft.budget.transfers.SfbtrBudgetaryReforms;
import ec.com.sidesoft.budget.transfers.SfbtrTransferFrom;
import ec.com.sidesoft.budget.transfers.SfbtrTransferTo;
import ec.com.sidesoft.poa.pac.EcsppPAC;

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
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.invoice.InvoiceLine;
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.accounting.UserDimension1;
/**
 * Entity class for entity sfb_budget_line (stored in table sfb_budget_line).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SFBBudgetLine extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sfb_budget_line";
    public static final String ENTITY_NAME = "sfb_budget_line";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_SFBBUDGETVERSION = "sFBBudgetVersion";
    public static final String PROPERTY_COSTCENTER = "costCenter";
    public static final String PROPERTY_LINENO = "lineNo";
    public static final String PROPERTY_CONCEPT = "concept";
    public static final String PROPERTY_BUDGETITEM = "budgetItem";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_JANBUDGETEDVALUE = "jANBudgetedValue";
    public static final String PROPERTY_JANCOMMITTEDVALUE = "jANCommittedValue";
    public static final String PROPERTY_JANAVAILABLEBALANCE = "jANAvailableBalance";
    public static final String PROPERTY_JANACTUALVALUE = "jANActualValue";
    public static final String PROPERTY_FEBBUDGETEDVALUE = "fEBBudgetedValue";
    public static final String PROPERTY_FEBCOMMITTEDVALUE = "fEBCommittedValue";
    public static final String PROPERTY_FEBAVAILABLEBALANCE = "fEBAvailableBalance";
    public static final String PROPERTY_FEBACTUALVALUE = "fEBActualValue";
    public static final String PROPERTY_MARBUDGETEDVALUE = "mARBudgetedValue";
    public static final String PROPERTY_MARCOMMITTEDVALUE = "mARCommittedValue";
    public static final String PROPERTY_MARAVAILABLEBALANCE = "mARAvailableBalance";
    public static final String PROPERTY_MARACTUALVALUE = "mARActualValue";
    public static final String PROPERTY_APRBUDGETEDVALUE = "aPRBudgetedValue";
    public static final String PROPERTY_APRCOMMITTEDVALUE = "aPRCommittedValue";
    public static final String PROPERTY_APRAVAILABLEBALANCE = "aPRAvailableBalance";
    public static final String PROPERTY_APRACTUALVALUE = "aPRActualValue";
    public static final String PROPERTY_MAYBUDGETEDVALUE = "mAYBudgetedValue";
    public static final String PROPERTY_MAYCOMMITTEDVALUE = "mAYCommittedValue";
    public static final String PROPERTY_MAYAVAILABLEBALANCE = "mAYAvailableBalance";
    public static final String PROPERTY_MAYACTUALVALUE = "mAYActualValue";
    public static final String PROPERTY_JUNBUDGETEDVALUE = "jUNBudgetedValue";
    public static final String PROPERTY_JUNCOMMITTEDVALUE = "jUNCommittedValue";
    public static final String PROPERTY_JUNAVAILABLEBALANCE = "jUNAvailableBalance";
    public static final String PROPERTY_JUNACTUALVALUE = "jUNActualValue";
    public static final String PROPERTY_JULBUDGETEDVALUE = "jULBudgetedValue";
    public static final String PROPERTY_JULCOMMITTEDVALUE = "jULCommittedValue";
    public static final String PROPERTY_JULAVAILABLEBALANCE = "jULAvailableBalance";
    public static final String PROPERTY_JULACTUALVALUE = "jULActualValue";
    public static final String PROPERTY_AUGBUDGETEDVALUE = "aUGBudgetedValue";
    public static final String PROPERTY_AUGCOMMITTEDVALUE = "aUGCommittedValue";
    public static final String PROPERTY_AUGAVAILABLEBALANCE = "aUGAvailableBalance";
    public static final String PROPERTY_AUGACTUALVALUE = "aUGActualValue";
    public static final String PROPERTY_SEPBUDGETEDVALUE = "sEPBudgetedValue";
    public static final String PROPERTY_SEPCOMMITTEDVALUE = "sEPCommittedValue";
    public static final String PROPERTY_SEPAVAILABLEBALANCE = "sEPAvailableBalance";
    public static final String PROPERTY_SEPACTUALVALUE = "sEPActualValue";
    public static final String PROPERTY_OCTBUDGETEDVALUE = "oCTBudgetedValue";
    public static final String PROPERTY_OCTCOMMITTEDVALUE = "oCTCommittedValue";
    public static final String PROPERTY_OCTAVAILABLEBALANCE = "oCTAvailableBalance";
    public static final String PROPERTY_OCTACTUALVALUE = "oCTActualValue";
    public static final String PROPERTY_NOVBUDGETEDVALUE = "nOVBudgetedValue";
    public static final String PROPERTY_NOVCOMMITTEDVALUE = "nOVCommittedValue";
    public static final String PROPERTY_NOVAVAILABLEBALANCE = "nOVAvailableBalance";
    public static final String PROPERTY_NOVACTUALVALUE = "nOVActualValue";
    public static final String PROPERTY_DECBUDGETEDVALUE = "dECBudgetedValue";
    public static final String PROPERTY_DECCOMMITTEDVALUE = "dECCommittedValue";
    public static final String PROPERTY_DECAVAILABLEBALANCE = "dECAvailableBalance";
    public static final String PROPERTY_DECACTUALVALUE = "dECActualValue";
    public static final String PROPERTY_BUDGETEDVALUE = "budgetedValue";
    public static final String PROPERTY_COMMITTEDVALUE = "committedValue";
    public static final String PROPERTY_AVAILABLEBALANCE = "availableBalance";
    public static final String PROPERTY_ACTUALVALUE = "actualValue";
    public static final String PROPERTY_JANEXECUTEDVALUE = "jANExecutedValue";
    public static final String PROPERTY_FEBEXECUTEDVALUE = "fEBExecutedValue";
    public static final String PROPERTY_MAREXECUTEDVALUE = "mARExecutedValue";
    public static final String PROPERTY_APREXECUTEDVALUE = "aPRExecutedValue";
    public static final String PROPERTY_MAYEXECUTEDVALUE = "mAYExecutedValue";
    public static final String PROPERTY_JUNEXECUTEDVALUE = "jUNExecutedValue";
    public static final String PROPERTY_JULEXECUTEDVALUE = "jULExecutedValue";
    public static final String PROPERTY_AUGEXECUTEDVALUE = "aUGExecutedValue";
    public static final String PROPERTY_SEPEXECUTEDVALUE = "sEPExecutedValue";
    public static final String PROPERTY_OCTEXECUTEDVALUE = "oCTExecutedValue";
    public static final String PROPERTY_NOVEXECUTEDVALUE = "nOVExecutedValue";
    public static final String PROPERTY_DECEXECUTEDVALUE = "dECExecutedValue";
    public static final String PROPERTY_EXECUTEDVALUE = "executedValue";
    public static final String PROPERTY_STDIMENSION = "stDimension";
    public static final String PROPERTY_ISEXCHANGE = "isexchange";
    public static final String PROPERTY_AREA = "area";
    public static final String PROPERTY_ADJUSTEDVALUE = "adjustedValue";
    public static final String PROPERTY_JANADJUSTEDVALUE = "jANAdjustedValue";
    public static final String PROPERTY_FEBADJUSTEDVALUE = "fEBAdjustedValue";
    public static final String PROPERTY_MARADJUSTEDVALUE = "mARAdjustedValue";
    public static final String PROPERTY_APRADJUSTEDVALUE = "aPRAdjustedValue";
    public static final String PROPERTY_MAYADJUSTEDVALUE = "mAYAdjustedValue";
    public static final String PROPERTY_JUNADJUSTEDVALUE = "jUNAdjustedValue";
    public static final String PROPERTY_JULADJUSTEDVALUE = "jULAdjustedValue";
    public static final String PROPERTY_AUGADJUSTEDVALUE = "aUGAdjustedValue";
    public static final String PROPERTY_SEPADJUSTEDVALUE = "sEPAdjustedValue";
    public static final String PROPERTY_OCTADJUSTEDVALUE = "oCTAdjustedValue";
    public static final String PROPERTY_NOVADJUSTEDVALUE = "nOVAdjustedValue";
    public static final String PROPERTY_DECADJUSTEDVALUE = "dECAdjustedValue";
    public static final String PROPERTY_INSERTPROCESS = "insertprocess";
    public static final String PROPERTY_SFBBUDGETADDLINE = "sFBBudgetAddline";
    public static final String PROPERTY_ISTBN = "isTBN";
    public static final String PROPERTY_PAIDOUTVALUE = "paidOutValue";
    public static final String PROPERTY_PAIDOUTJANUARY = "paidOutJanuary";
    public static final String PROPERTY_PAIDOUTFEBRUARY = "paidOutFebruary";
    public static final String PROPERTY_PAIDOUTMARCH = "paidOutMarch";
    public static final String PROPERTY_PAIDOUTAPRIL = "paidOutApril";
    public static final String PROPERTY_PAIDOUTMAY = "paidOutMay";
    public static final String PROPERTY_PAIDOUTJUNE = "paidOutJune";
    public static final String PROPERTY_PAIDOUTJULY = "paidOutJuly";
    public static final String PROPERTY_PAIDOUTAUGUST = "paidOutAugust";
    public static final String PROPERTY_PAIDOUTSEPTEMBER = "paidOutSeptember";
    public static final String PROPERTY_PAIDOUTOCTOBER = "paidOutOctober";
    public static final String PROPERTY_PAIDOUTNOVEMBER = "paidOutNovember";
    public static final String PROPERTY_PAIDOUTDECEMBER = "paidOutDecember";
    public static final String PROPERTY__COMPUTEDCOLUMNS = "_computedColumns";
    public static final String PROPERTY_INVOICELINEEMSSRFCBUDGETLINEIDLIST = "invoiceLineEMSsrfcBudgetLineIDList";
    public static final String PROPERTY_SFBBUDGETLOGLINELIST = "sFBBudgetLogLineList";
    public static final String PROPERTY_SFBTRBUDGETARYREFORMSLIST = "sfbtrBudgetaryReformsList";
    public static final String PROPERTY_SFBTRTRANSFERFROMLIST = "sfbtrTransferFromList";
    public static final String PROPERTY_SFBTRTRANSFERTOLIST = "sfbtrTransferToList";
    public static final String PROPERTY_ECSPPPACBUDGETLINEIDLIST = "ecsppPacBudgetLineIDList";
    public static final String PROPERTY_SFBBUDGETLINEDETAILVLIST = "sfbBudgetLineDetailVList";
    public static final String PROPERTY_SFBBUDGETLOGVPRESUPUESTOIDLIST = "sfbBudgetLogVPresupuestoIDList";


    // Computed columns properties, these properties cannot be directly accessed, they need
    // to be read through _commputedColumns proxy. They cannot be directly used in HQL, OBQuery
    // nor OBCriteria. 
    public static final String COMPUTED_COLUMN_REFORMS = "reforms";
    public static final String COMPUTED_COLUMN_COMMITMENTS = "commitments";
    public static final String COMPUTED_COLUMN_FORCOMPROMISING = "fORCompromising";
    public static final String COMPUTED_COLUMN_VALUETOEXECUTE = "valuetoexecute";
    public static final String COMPUTED_COLUMN_TYPEOFBUDGET = "typeOfBudget";
    public static final String COMPUTED_COLUMN_VERSIONSTATUS = "versionStatus";
    public static final String COMPUTED_COLUMN_YEAR = "year";

    public SFBBudgetLine() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_PROCESSED, false);
        setDefaultValue(PROPERTY_JANBUDGETEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_JANCOMMITTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_JANAVAILABLEBALANCE, new BigDecimal(0));
        setDefaultValue(PROPERTY_JANACTUALVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_FEBBUDGETEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_FEBCOMMITTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_FEBAVAILABLEBALANCE, new BigDecimal(0));
        setDefaultValue(PROPERTY_FEBACTUALVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_MARBUDGETEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_MARCOMMITTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_MARAVAILABLEBALANCE, new BigDecimal(0));
        setDefaultValue(PROPERTY_MARACTUALVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_APRBUDGETEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_APRCOMMITTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_APRAVAILABLEBALANCE, new BigDecimal(0));
        setDefaultValue(PROPERTY_APRACTUALVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_MAYBUDGETEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_MAYCOMMITTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_MAYAVAILABLEBALANCE, new BigDecimal(0));
        setDefaultValue(PROPERTY_MAYACTUALVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_JUNBUDGETEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_JUNCOMMITTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_JUNAVAILABLEBALANCE, new BigDecimal(0));
        setDefaultValue(PROPERTY_JUNACTUALVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_JULBUDGETEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_JULCOMMITTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_JULAVAILABLEBALANCE, new BigDecimal(0));
        setDefaultValue(PROPERTY_JULACTUALVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_AUGBUDGETEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_AUGCOMMITTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_AUGAVAILABLEBALANCE, new BigDecimal(0));
        setDefaultValue(PROPERTY_AUGACTUALVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_SEPBUDGETEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_SEPCOMMITTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_SEPAVAILABLEBALANCE, new BigDecimal(0));
        setDefaultValue(PROPERTY_SEPACTUALVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_OCTBUDGETEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_OCTCOMMITTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_OCTAVAILABLEBALANCE, new BigDecimal(0));
        setDefaultValue(PROPERTY_OCTACTUALVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_NOVBUDGETEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_NOVCOMMITTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_NOVAVAILABLEBALANCE, new BigDecimal(0));
        setDefaultValue(PROPERTY_NOVACTUALVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_DECBUDGETEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_DECCOMMITTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_DECAVAILABLEBALANCE, new BigDecimal(0));
        setDefaultValue(PROPERTY_DECACTUALVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_BUDGETEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_COMMITTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_AVAILABLEBALANCE, new BigDecimal(0));
        setDefaultValue(PROPERTY_ACTUALVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_JANEXECUTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_FEBEXECUTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_MAREXECUTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_APREXECUTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_MAYEXECUTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_JUNEXECUTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_JULEXECUTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_AUGEXECUTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_SEPEXECUTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_OCTEXECUTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_NOVEXECUTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_DECEXECUTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_EXECUTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_ISEXCHANGE, false);
        setDefaultValue(PROPERTY_ADJUSTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_JANADJUSTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_FEBADJUSTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_MARADJUSTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_APRADJUSTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_MAYADJUSTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_JUNADJUSTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_JULADJUSTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_AUGADJUSTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_SEPADJUSTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_OCTADJUSTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_NOVADJUSTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_DECADJUSTEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_INSERTPROCESS, false);
        setDefaultValue(PROPERTY_ISTBN, false);
        setDefaultValue(PROPERTY_PAIDOUTVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_PAIDOUTJANUARY, new BigDecimal(0));
        setDefaultValue(PROPERTY_PAIDOUTFEBRUARY, new BigDecimal(0));
        setDefaultValue(PROPERTY_PAIDOUTMARCH, new BigDecimal(0));
        setDefaultValue(PROPERTY_PAIDOUTAPRIL, new BigDecimal(0));
        setDefaultValue(PROPERTY_PAIDOUTMAY, new BigDecimal(0));
        setDefaultValue(PROPERTY_PAIDOUTJUNE, new BigDecimal(0));
        setDefaultValue(PROPERTY_PAIDOUTJULY, new BigDecimal(0));
        setDefaultValue(PROPERTY_PAIDOUTAUGUST, new BigDecimal(0));
        setDefaultValue(PROPERTY_PAIDOUTSEPTEMBER, new BigDecimal(0));
        setDefaultValue(PROPERTY_PAIDOUTOCTOBER, new BigDecimal(0));
        setDefaultValue(PROPERTY_PAIDOUTNOVEMBER, new BigDecimal(0));
        setDefaultValue(PROPERTY_PAIDOUTDECEMBER, new BigDecimal(0));
        setDefaultValue(PROPERTY_INVOICELINEEMSSRFCBUDGETLINEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETLOGLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBTRBUDGETARYREFORMSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBTRTRANSFERFROMLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBTRTRANSFERTOLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ECSPPPACBUDGETLINEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETLINEDETAILVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETLOGVPRESUPUESTOIDLIST, new ArrayList<Object>());
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

    public SFBBudgetVersion getSFBBudgetVersion() {
        return (SFBBudgetVersion) get(PROPERTY_SFBBUDGETVERSION);
    }

    public void setSFBBudgetVersion(SFBBudgetVersion sFBBudgetVersion) {
        set(PROPERTY_SFBBUDGETVERSION, sFBBudgetVersion);
    }

    public Costcenter getCostCenter() {
        return (Costcenter) get(PROPERTY_COSTCENTER);
    }

    public void setCostCenter(Costcenter costCenter) {
        set(PROPERTY_COSTCENTER, costCenter);
    }

    public Long getLineNo() {
        return (Long) get(PROPERTY_LINENO);
    }

    public void setLineNo(Long lineNo) {
        set(PROPERTY_LINENO, lineNo);
    }

    public String getConcept() {
        return (String) get(PROPERTY_CONCEPT);
    }

    public void setConcept(String concept) {
        set(PROPERTY_CONCEPT, concept);
    }

    public SFBBudgetItem getBudgetItem() {
        return (SFBBudgetItem) get(PROPERTY_BUDGETITEM);
    }

    public void setBudgetItem(SFBBudgetItem budgetItem) {
        set(PROPERTY_BUDGETITEM, budgetItem);
    }

    public Boolean isProcessed() {
        return (Boolean) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(Boolean processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public BigDecimal getJANBudgetedValue() {
        return (BigDecimal) get(PROPERTY_JANBUDGETEDVALUE);
    }

    public void setJANBudgetedValue(BigDecimal jANBudgetedValue) {
        set(PROPERTY_JANBUDGETEDVALUE, jANBudgetedValue);
    }

    public BigDecimal getJANCommittedValue() {
        return (BigDecimal) get(PROPERTY_JANCOMMITTEDVALUE);
    }

    public void setJANCommittedValue(BigDecimal jANCommittedValue) {
        set(PROPERTY_JANCOMMITTEDVALUE, jANCommittedValue);
    }

    public BigDecimal getJANAvailableBalance() {
        return (BigDecimal) get(PROPERTY_JANAVAILABLEBALANCE);
    }

    public void setJANAvailableBalance(BigDecimal jANAvailableBalance) {
        set(PROPERTY_JANAVAILABLEBALANCE, jANAvailableBalance);
    }

    public BigDecimal getJANActualValue() {
        return (BigDecimal) get(PROPERTY_JANACTUALVALUE);
    }

    public void setJANActualValue(BigDecimal jANActualValue) {
        set(PROPERTY_JANACTUALVALUE, jANActualValue);
    }

    public BigDecimal getFEBBudgetedValue() {
        return (BigDecimal) get(PROPERTY_FEBBUDGETEDVALUE);
    }

    public void setFEBBudgetedValue(BigDecimal fEBBudgetedValue) {
        set(PROPERTY_FEBBUDGETEDVALUE, fEBBudgetedValue);
    }

    public BigDecimal getFEBCommittedValue() {
        return (BigDecimal) get(PROPERTY_FEBCOMMITTEDVALUE);
    }

    public void setFEBCommittedValue(BigDecimal fEBCommittedValue) {
        set(PROPERTY_FEBCOMMITTEDVALUE, fEBCommittedValue);
    }

    public BigDecimal getFEBAvailableBalance() {
        return (BigDecimal) get(PROPERTY_FEBAVAILABLEBALANCE);
    }

    public void setFEBAvailableBalance(BigDecimal fEBAvailableBalance) {
        set(PROPERTY_FEBAVAILABLEBALANCE, fEBAvailableBalance);
    }

    public BigDecimal getFEBActualValue() {
        return (BigDecimal) get(PROPERTY_FEBACTUALVALUE);
    }

    public void setFEBActualValue(BigDecimal fEBActualValue) {
        set(PROPERTY_FEBACTUALVALUE, fEBActualValue);
    }

    public BigDecimal getMARBudgetedValue() {
        return (BigDecimal) get(PROPERTY_MARBUDGETEDVALUE);
    }

    public void setMARBudgetedValue(BigDecimal mARBudgetedValue) {
        set(PROPERTY_MARBUDGETEDVALUE, mARBudgetedValue);
    }

    public BigDecimal getMARCommittedValue() {
        return (BigDecimal) get(PROPERTY_MARCOMMITTEDVALUE);
    }

    public void setMARCommittedValue(BigDecimal mARCommittedValue) {
        set(PROPERTY_MARCOMMITTEDVALUE, mARCommittedValue);
    }

    public BigDecimal getMARAvailableBalance() {
        return (BigDecimal) get(PROPERTY_MARAVAILABLEBALANCE);
    }

    public void setMARAvailableBalance(BigDecimal mARAvailableBalance) {
        set(PROPERTY_MARAVAILABLEBALANCE, mARAvailableBalance);
    }

    public BigDecimal getMARActualValue() {
        return (BigDecimal) get(PROPERTY_MARACTUALVALUE);
    }

    public void setMARActualValue(BigDecimal mARActualValue) {
        set(PROPERTY_MARACTUALVALUE, mARActualValue);
    }

    public BigDecimal getAPRBudgetedValue() {
        return (BigDecimal) get(PROPERTY_APRBUDGETEDVALUE);
    }

    public void setAPRBudgetedValue(BigDecimal aPRBudgetedValue) {
        set(PROPERTY_APRBUDGETEDVALUE, aPRBudgetedValue);
    }

    public BigDecimal getAPRCommittedValue() {
        return (BigDecimal) get(PROPERTY_APRCOMMITTEDVALUE);
    }

    public void setAPRCommittedValue(BigDecimal aPRCommittedValue) {
        set(PROPERTY_APRCOMMITTEDVALUE, aPRCommittedValue);
    }

    public BigDecimal getAPRAvailableBalance() {
        return (BigDecimal) get(PROPERTY_APRAVAILABLEBALANCE);
    }

    public void setAPRAvailableBalance(BigDecimal aPRAvailableBalance) {
        set(PROPERTY_APRAVAILABLEBALANCE, aPRAvailableBalance);
    }

    public BigDecimal getAPRActualValue() {
        return (BigDecimal) get(PROPERTY_APRACTUALVALUE);
    }

    public void setAPRActualValue(BigDecimal aPRActualValue) {
        set(PROPERTY_APRACTUALVALUE, aPRActualValue);
    }

    public BigDecimal getMAYBudgetedValue() {
        return (BigDecimal) get(PROPERTY_MAYBUDGETEDVALUE);
    }

    public void setMAYBudgetedValue(BigDecimal mAYBudgetedValue) {
        set(PROPERTY_MAYBUDGETEDVALUE, mAYBudgetedValue);
    }

    public BigDecimal getMAYCommittedValue() {
        return (BigDecimal) get(PROPERTY_MAYCOMMITTEDVALUE);
    }

    public void setMAYCommittedValue(BigDecimal mAYCommittedValue) {
        set(PROPERTY_MAYCOMMITTEDVALUE, mAYCommittedValue);
    }

    public BigDecimal getMAYAvailableBalance() {
        return (BigDecimal) get(PROPERTY_MAYAVAILABLEBALANCE);
    }

    public void setMAYAvailableBalance(BigDecimal mAYAvailableBalance) {
        set(PROPERTY_MAYAVAILABLEBALANCE, mAYAvailableBalance);
    }

    public BigDecimal getMAYActualValue() {
        return (BigDecimal) get(PROPERTY_MAYACTUALVALUE);
    }

    public void setMAYActualValue(BigDecimal mAYActualValue) {
        set(PROPERTY_MAYACTUALVALUE, mAYActualValue);
    }

    public BigDecimal getJUNBudgetedValue() {
        return (BigDecimal) get(PROPERTY_JUNBUDGETEDVALUE);
    }

    public void setJUNBudgetedValue(BigDecimal jUNBudgetedValue) {
        set(PROPERTY_JUNBUDGETEDVALUE, jUNBudgetedValue);
    }

    public BigDecimal getJUNCommittedValue() {
        return (BigDecimal) get(PROPERTY_JUNCOMMITTEDVALUE);
    }

    public void setJUNCommittedValue(BigDecimal jUNCommittedValue) {
        set(PROPERTY_JUNCOMMITTEDVALUE, jUNCommittedValue);
    }

    public BigDecimal getJUNAvailableBalance() {
        return (BigDecimal) get(PROPERTY_JUNAVAILABLEBALANCE);
    }

    public void setJUNAvailableBalance(BigDecimal jUNAvailableBalance) {
        set(PROPERTY_JUNAVAILABLEBALANCE, jUNAvailableBalance);
    }

    public BigDecimal getJUNActualValue() {
        return (BigDecimal) get(PROPERTY_JUNACTUALVALUE);
    }

    public void setJUNActualValue(BigDecimal jUNActualValue) {
        set(PROPERTY_JUNACTUALVALUE, jUNActualValue);
    }

    public BigDecimal getJULBudgetedValue() {
        return (BigDecimal) get(PROPERTY_JULBUDGETEDVALUE);
    }

    public void setJULBudgetedValue(BigDecimal jULBudgetedValue) {
        set(PROPERTY_JULBUDGETEDVALUE, jULBudgetedValue);
    }

    public BigDecimal getJULCommittedValue() {
        return (BigDecimal) get(PROPERTY_JULCOMMITTEDVALUE);
    }

    public void setJULCommittedValue(BigDecimal jULCommittedValue) {
        set(PROPERTY_JULCOMMITTEDVALUE, jULCommittedValue);
    }

    public BigDecimal getJULAvailableBalance() {
        return (BigDecimal) get(PROPERTY_JULAVAILABLEBALANCE);
    }

    public void setJULAvailableBalance(BigDecimal jULAvailableBalance) {
        set(PROPERTY_JULAVAILABLEBALANCE, jULAvailableBalance);
    }

    public BigDecimal getJULActualValue() {
        return (BigDecimal) get(PROPERTY_JULACTUALVALUE);
    }

    public void setJULActualValue(BigDecimal jULActualValue) {
        set(PROPERTY_JULACTUALVALUE, jULActualValue);
    }

    public BigDecimal getAUGBudgetedValue() {
        return (BigDecimal) get(PROPERTY_AUGBUDGETEDVALUE);
    }

    public void setAUGBudgetedValue(BigDecimal aUGBudgetedValue) {
        set(PROPERTY_AUGBUDGETEDVALUE, aUGBudgetedValue);
    }

    public BigDecimal getAUGCommittedValue() {
        return (BigDecimal) get(PROPERTY_AUGCOMMITTEDVALUE);
    }

    public void setAUGCommittedValue(BigDecimal aUGCommittedValue) {
        set(PROPERTY_AUGCOMMITTEDVALUE, aUGCommittedValue);
    }

    public BigDecimal getAUGAvailableBalance() {
        return (BigDecimal) get(PROPERTY_AUGAVAILABLEBALANCE);
    }

    public void setAUGAvailableBalance(BigDecimal aUGAvailableBalance) {
        set(PROPERTY_AUGAVAILABLEBALANCE, aUGAvailableBalance);
    }

    public BigDecimal getAUGActualValue() {
        return (BigDecimal) get(PROPERTY_AUGACTUALVALUE);
    }

    public void setAUGActualValue(BigDecimal aUGActualValue) {
        set(PROPERTY_AUGACTUALVALUE, aUGActualValue);
    }

    public BigDecimal getSEPBudgetedValue() {
        return (BigDecimal) get(PROPERTY_SEPBUDGETEDVALUE);
    }

    public void setSEPBudgetedValue(BigDecimal sEPBudgetedValue) {
        set(PROPERTY_SEPBUDGETEDVALUE, sEPBudgetedValue);
    }

    public BigDecimal getSEPCommittedValue() {
        return (BigDecimal) get(PROPERTY_SEPCOMMITTEDVALUE);
    }

    public void setSEPCommittedValue(BigDecimal sEPCommittedValue) {
        set(PROPERTY_SEPCOMMITTEDVALUE, sEPCommittedValue);
    }

    public BigDecimal getSEPAvailableBalance() {
        return (BigDecimal) get(PROPERTY_SEPAVAILABLEBALANCE);
    }

    public void setSEPAvailableBalance(BigDecimal sEPAvailableBalance) {
        set(PROPERTY_SEPAVAILABLEBALANCE, sEPAvailableBalance);
    }

    public BigDecimal getSEPActualValue() {
        return (BigDecimal) get(PROPERTY_SEPACTUALVALUE);
    }

    public void setSEPActualValue(BigDecimal sEPActualValue) {
        set(PROPERTY_SEPACTUALVALUE, sEPActualValue);
    }

    public BigDecimal getOCTBudgetedValue() {
        return (BigDecimal) get(PROPERTY_OCTBUDGETEDVALUE);
    }

    public void setOCTBudgetedValue(BigDecimal oCTBudgetedValue) {
        set(PROPERTY_OCTBUDGETEDVALUE, oCTBudgetedValue);
    }

    public BigDecimal getOCTCommittedValue() {
        return (BigDecimal) get(PROPERTY_OCTCOMMITTEDVALUE);
    }

    public void setOCTCommittedValue(BigDecimal oCTCommittedValue) {
        set(PROPERTY_OCTCOMMITTEDVALUE, oCTCommittedValue);
    }

    public BigDecimal getOCTAvailableBalance() {
        return (BigDecimal) get(PROPERTY_OCTAVAILABLEBALANCE);
    }

    public void setOCTAvailableBalance(BigDecimal oCTAvailableBalance) {
        set(PROPERTY_OCTAVAILABLEBALANCE, oCTAvailableBalance);
    }

    public BigDecimal getOCTActualValue() {
        return (BigDecimal) get(PROPERTY_OCTACTUALVALUE);
    }

    public void setOCTActualValue(BigDecimal oCTActualValue) {
        set(PROPERTY_OCTACTUALVALUE, oCTActualValue);
    }

    public BigDecimal getNOVBudgetedValue() {
        return (BigDecimal) get(PROPERTY_NOVBUDGETEDVALUE);
    }

    public void setNOVBudgetedValue(BigDecimal nOVBudgetedValue) {
        set(PROPERTY_NOVBUDGETEDVALUE, nOVBudgetedValue);
    }

    public BigDecimal getNOVCommittedValue() {
        return (BigDecimal) get(PROPERTY_NOVCOMMITTEDVALUE);
    }

    public void setNOVCommittedValue(BigDecimal nOVCommittedValue) {
        set(PROPERTY_NOVCOMMITTEDVALUE, nOVCommittedValue);
    }

    public BigDecimal getNOVAvailableBalance() {
        return (BigDecimal) get(PROPERTY_NOVAVAILABLEBALANCE);
    }

    public void setNOVAvailableBalance(BigDecimal nOVAvailableBalance) {
        set(PROPERTY_NOVAVAILABLEBALANCE, nOVAvailableBalance);
    }

    public BigDecimal getNOVActualValue() {
        return (BigDecimal) get(PROPERTY_NOVACTUALVALUE);
    }

    public void setNOVActualValue(BigDecimal nOVActualValue) {
        set(PROPERTY_NOVACTUALVALUE, nOVActualValue);
    }

    public BigDecimal getDECBudgetedValue() {
        return (BigDecimal) get(PROPERTY_DECBUDGETEDVALUE);
    }

    public void setDECBudgetedValue(BigDecimal dECBudgetedValue) {
        set(PROPERTY_DECBUDGETEDVALUE, dECBudgetedValue);
    }

    public BigDecimal getDECCommittedValue() {
        return (BigDecimal) get(PROPERTY_DECCOMMITTEDVALUE);
    }

    public void setDECCommittedValue(BigDecimal dECCommittedValue) {
        set(PROPERTY_DECCOMMITTEDVALUE, dECCommittedValue);
    }

    public BigDecimal getDECAvailableBalance() {
        return (BigDecimal) get(PROPERTY_DECAVAILABLEBALANCE);
    }

    public void setDECAvailableBalance(BigDecimal dECAvailableBalance) {
        set(PROPERTY_DECAVAILABLEBALANCE, dECAvailableBalance);
    }

    public BigDecimal getDECActualValue() {
        return (BigDecimal) get(PROPERTY_DECACTUALVALUE);
    }

    public void setDECActualValue(BigDecimal dECActualValue) {
        set(PROPERTY_DECACTUALVALUE, dECActualValue);
    }

    public BigDecimal getBudgetedValue() {
        return (BigDecimal) get(PROPERTY_BUDGETEDVALUE);
    }

    public void setBudgetedValue(BigDecimal budgetedValue) {
        set(PROPERTY_BUDGETEDVALUE, budgetedValue);
    }

    public BigDecimal getCommittedValue() {
        return (BigDecimal) get(PROPERTY_COMMITTEDVALUE);
    }

    public void setCommittedValue(BigDecimal committedValue) {
        set(PROPERTY_COMMITTEDVALUE, committedValue);
    }

    public BigDecimal getAvailableBalance() {
        return (BigDecimal) get(PROPERTY_AVAILABLEBALANCE);
    }

    public void setAvailableBalance(BigDecimal availableBalance) {
        set(PROPERTY_AVAILABLEBALANCE, availableBalance);
    }

    public BigDecimal getActualValue() {
        return (BigDecimal) get(PROPERTY_ACTUALVALUE);
    }

    public void setActualValue(BigDecimal actualValue) {
        set(PROPERTY_ACTUALVALUE, actualValue);
    }

    public BigDecimal getJANExecutedValue() {
        return (BigDecimal) get(PROPERTY_JANEXECUTEDVALUE);
    }

    public void setJANExecutedValue(BigDecimal jANExecutedValue) {
        set(PROPERTY_JANEXECUTEDVALUE, jANExecutedValue);
    }

    public BigDecimal getFEBExecutedValue() {
        return (BigDecimal) get(PROPERTY_FEBEXECUTEDVALUE);
    }

    public void setFEBExecutedValue(BigDecimal fEBExecutedValue) {
        set(PROPERTY_FEBEXECUTEDVALUE, fEBExecutedValue);
    }

    public BigDecimal getMARExecutedValue() {
        return (BigDecimal) get(PROPERTY_MAREXECUTEDVALUE);
    }

    public void setMARExecutedValue(BigDecimal mARExecutedValue) {
        set(PROPERTY_MAREXECUTEDVALUE, mARExecutedValue);
    }

    public BigDecimal getAPRExecutedValue() {
        return (BigDecimal) get(PROPERTY_APREXECUTEDVALUE);
    }

    public void setAPRExecutedValue(BigDecimal aPRExecutedValue) {
        set(PROPERTY_APREXECUTEDVALUE, aPRExecutedValue);
    }

    public BigDecimal getMAYExecutedValue() {
        return (BigDecimal) get(PROPERTY_MAYEXECUTEDVALUE);
    }

    public void setMAYExecutedValue(BigDecimal mAYExecutedValue) {
        set(PROPERTY_MAYEXECUTEDVALUE, mAYExecutedValue);
    }

    public BigDecimal getJUNExecutedValue() {
        return (BigDecimal) get(PROPERTY_JUNEXECUTEDVALUE);
    }

    public void setJUNExecutedValue(BigDecimal jUNExecutedValue) {
        set(PROPERTY_JUNEXECUTEDVALUE, jUNExecutedValue);
    }

    public BigDecimal getJULExecutedValue() {
        return (BigDecimal) get(PROPERTY_JULEXECUTEDVALUE);
    }

    public void setJULExecutedValue(BigDecimal jULExecutedValue) {
        set(PROPERTY_JULEXECUTEDVALUE, jULExecutedValue);
    }

    public BigDecimal getAUGExecutedValue() {
        return (BigDecimal) get(PROPERTY_AUGEXECUTEDVALUE);
    }

    public void setAUGExecutedValue(BigDecimal aUGExecutedValue) {
        set(PROPERTY_AUGEXECUTEDVALUE, aUGExecutedValue);
    }

    public BigDecimal getSEPExecutedValue() {
        return (BigDecimal) get(PROPERTY_SEPEXECUTEDVALUE);
    }

    public void setSEPExecutedValue(BigDecimal sEPExecutedValue) {
        set(PROPERTY_SEPEXECUTEDVALUE, sEPExecutedValue);
    }

    public BigDecimal getOCTExecutedValue() {
        return (BigDecimal) get(PROPERTY_OCTEXECUTEDVALUE);
    }

    public void setOCTExecutedValue(BigDecimal oCTExecutedValue) {
        set(PROPERTY_OCTEXECUTEDVALUE, oCTExecutedValue);
    }

    public BigDecimal getNOVExecutedValue() {
        return (BigDecimal) get(PROPERTY_NOVEXECUTEDVALUE);
    }

    public void setNOVExecutedValue(BigDecimal nOVExecutedValue) {
        set(PROPERTY_NOVEXECUTEDVALUE, nOVExecutedValue);
    }

    public BigDecimal getDECExecutedValue() {
        return (BigDecimal) get(PROPERTY_DECEXECUTEDVALUE);
    }

    public void setDECExecutedValue(BigDecimal dECExecutedValue) {
        set(PROPERTY_DECEXECUTEDVALUE, dECExecutedValue);
    }

    public BigDecimal getExecutedValue() {
        return (BigDecimal) get(PROPERTY_EXECUTEDVALUE);
    }

    public void setExecutedValue(BigDecimal executedValue) {
        set(PROPERTY_EXECUTEDVALUE, executedValue);
    }

    public UserDimension1 getStDimension() {
        return (UserDimension1) get(PROPERTY_STDIMENSION);
    }

    public void setStDimension(UserDimension1 stDimension) {
        set(PROPERTY_STDIMENSION, stDimension);
    }

    public Boolean isExchange() {
        return (Boolean) get(PROPERTY_ISEXCHANGE);
    }

    public void setExchange(Boolean isexchange) {
        set(PROPERTY_ISEXCHANGE, isexchange);
    }

    public SFBBudgetArea getArea() {
        return (SFBBudgetArea) get(PROPERTY_AREA);
    }

    public void setArea(SFBBudgetArea area) {
        set(PROPERTY_AREA, area);
    }

    public BigDecimal getAdjustedValue() {
        return (BigDecimal) get(PROPERTY_ADJUSTEDVALUE);
    }

    public void setAdjustedValue(BigDecimal adjustedValue) {
        set(PROPERTY_ADJUSTEDVALUE, adjustedValue);
    }

    public BigDecimal getJANAdjustedValue() {
        return (BigDecimal) get(PROPERTY_JANADJUSTEDVALUE);
    }

    public void setJANAdjustedValue(BigDecimal jANAdjustedValue) {
        set(PROPERTY_JANADJUSTEDVALUE, jANAdjustedValue);
    }

    public BigDecimal getFEBAdjustedValue() {
        return (BigDecimal) get(PROPERTY_FEBADJUSTEDVALUE);
    }

    public void setFEBAdjustedValue(BigDecimal fEBAdjustedValue) {
        set(PROPERTY_FEBADJUSTEDVALUE, fEBAdjustedValue);
    }

    public BigDecimal getMARAdjustedValue() {
        return (BigDecimal) get(PROPERTY_MARADJUSTEDVALUE);
    }

    public void setMARAdjustedValue(BigDecimal mARAdjustedValue) {
        set(PROPERTY_MARADJUSTEDVALUE, mARAdjustedValue);
    }

    public BigDecimal getAPRAdjustedValue() {
        return (BigDecimal) get(PROPERTY_APRADJUSTEDVALUE);
    }

    public void setAPRAdjustedValue(BigDecimal aPRAdjustedValue) {
        set(PROPERTY_APRADJUSTEDVALUE, aPRAdjustedValue);
    }

    public BigDecimal getMAYAdjustedValue() {
        return (BigDecimal) get(PROPERTY_MAYADJUSTEDVALUE);
    }

    public void setMAYAdjustedValue(BigDecimal mAYAdjustedValue) {
        set(PROPERTY_MAYADJUSTEDVALUE, mAYAdjustedValue);
    }

    public BigDecimal getJUNAdjustedValue() {
        return (BigDecimal) get(PROPERTY_JUNADJUSTEDVALUE);
    }

    public void setJUNAdjustedValue(BigDecimal jUNAdjustedValue) {
        set(PROPERTY_JUNADJUSTEDVALUE, jUNAdjustedValue);
    }

    public BigDecimal getJULAdjustedValue() {
        return (BigDecimal) get(PROPERTY_JULADJUSTEDVALUE);
    }

    public void setJULAdjustedValue(BigDecimal jULAdjustedValue) {
        set(PROPERTY_JULADJUSTEDVALUE, jULAdjustedValue);
    }

    public BigDecimal getAUGAdjustedValue() {
        return (BigDecimal) get(PROPERTY_AUGADJUSTEDVALUE);
    }

    public void setAUGAdjustedValue(BigDecimal aUGAdjustedValue) {
        set(PROPERTY_AUGADJUSTEDVALUE, aUGAdjustedValue);
    }

    public BigDecimal getSEPAdjustedValue() {
        return (BigDecimal) get(PROPERTY_SEPADJUSTEDVALUE);
    }

    public void setSEPAdjustedValue(BigDecimal sEPAdjustedValue) {
        set(PROPERTY_SEPADJUSTEDVALUE, sEPAdjustedValue);
    }

    public BigDecimal getOCTAdjustedValue() {
        return (BigDecimal) get(PROPERTY_OCTADJUSTEDVALUE);
    }

    public void setOCTAdjustedValue(BigDecimal oCTAdjustedValue) {
        set(PROPERTY_OCTADJUSTEDVALUE, oCTAdjustedValue);
    }

    public BigDecimal getNOVAdjustedValue() {
        return (BigDecimal) get(PROPERTY_NOVADJUSTEDVALUE);
    }

    public void setNOVAdjustedValue(BigDecimal nOVAdjustedValue) {
        set(PROPERTY_NOVADJUSTEDVALUE, nOVAdjustedValue);
    }

    public BigDecimal getDECAdjustedValue() {
        return (BigDecimal) get(PROPERTY_DECADJUSTEDVALUE);
    }

    public void setDECAdjustedValue(BigDecimal dECAdjustedValue) {
        set(PROPERTY_DECADJUSTEDVALUE, dECAdjustedValue);
    }

    public Boolean isInsertprocess() {
        return (Boolean) get(PROPERTY_INSERTPROCESS);
    }

    public void setInsertprocess(Boolean insertprocess) {
        set(PROPERTY_INSERTPROCESS, insertprocess);
    }

    public sfbbudgetaddline getSFBBudgetAddline() {
        return (sfbbudgetaddline) get(PROPERTY_SFBBUDGETADDLINE);
    }

    public void setSFBBudgetAddline(sfbbudgetaddline sFBBudgetAddline) {
        set(PROPERTY_SFBBUDGETADDLINE, sFBBudgetAddline);
    }

    public Boolean isTBN() {
        return (Boolean) get(PROPERTY_ISTBN);
    }

    public void setTBN(Boolean isTBN) {
        set(PROPERTY_ISTBN, isTBN);
    }

    public BigDecimal getPaidOutValue() {
        return (BigDecimal) get(PROPERTY_PAIDOUTVALUE);
    }

    public void setPaidOutValue(BigDecimal paidOutValue) {
        set(PROPERTY_PAIDOUTVALUE, paidOutValue);
    }

    public BigDecimal getPaidOutJanuary() {
        return (BigDecimal) get(PROPERTY_PAIDOUTJANUARY);
    }

    public void setPaidOutJanuary(BigDecimal paidOutJanuary) {
        set(PROPERTY_PAIDOUTJANUARY, paidOutJanuary);
    }

    public BigDecimal getPaidOutFebruary() {
        return (BigDecimal) get(PROPERTY_PAIDOUTFEBRUARY);
    }

    public void setPaidOutFebruary(BigDecimal paidOutFebruary) {
        set(PROPERTY_PAIDOUTFEBRUARY, paidOutFebruary);
    }

    public BigDecimal getPaidOutMarch() {
        return (BigDecimal) get(PROPERTY_PAIDOUTMARCH);
    }

    public void setPaidOutMarch(BigDecimal paidOutMarch) {
        set(PROPERTY_PAIDOUTMARCH, paidOutMarch);
    }

    public BigDecimal getPaidOutApril() {
        return (BigDecimal) get(PROPERTY_PAIDOUTAPRIL);
    }

    public void setPaidOutApril(BigDecimal paidOutApril) {
        set(PROPERTY_PAIDOUTAPRIL, paidOutApril);
    }

    public BigDecimal getPaidOutMay() {
        return (BigDecimal) get(PROPERTY_PAIDOUTMAY);
    }

    public void setPaidOutMay(BigDecimal paidOutMay) {
        set(PROPERTY_PAIDOUTMAY, paidOutMay);
    }

    public BigDecimal getPaidOutJune() {
        return (BigDecimal) get(PROPERTY_PAIDOUTJUNE);
    }

    public void setPaidOutJune(BigDecimal paidOutJune) {
        set(PROPERTY_PAIDOUTJUNE, paidOutJune);
    }

    public BigDecimal getPaidOutJuly() {
        return (BigDecimal) get(PROPERTY_PAIDOUTJULY);
    }

    public void setPaidOutJuly(BigDecimal paidOutJuly) {
        set(PROPERTY_PAIDOUTJULY, paidOutJuly);
    }

    public BigDecimal getPaidOutAugust() {
        return (BigDecimal) get(PROPERTY_PAIDOUTAUGUST);
    }

    public void setPaidOutAugust(BigDecimal paidOutAugust) {
        set(PROPERTY_PAIDOUTAUGUST, paidOutAugust);
    }

    public BigDecimal getPaidOutSeptember() {
        return (BigDecimal) get(PROPERTY_PAIDOUTSEPTEMBER);
    }

    public void setPaidOutSeptember(BigDecimal paidOutSeptember) {
        set(PROPERTY_PAIDOUTSEPTEMBER, paidOutSeptember);
    }

    public BigDecimal getPaidOutOctober() {
        return (BigDecimal) get(PROPERTY_PAIDOUTOCTOBER);
    }

    public void setPaidOutOctober(BigDecimal paidOutOctober) {
        set(PROPERTY_PAIDOUTOCTOBER, paidOutOctober);
    }

    public BigDecimal getPaidOutNovember() {
        return (BigDecimal) get(PROPERTY_PAIDOUTNOVEMBER);
    }

    public void setPaidOutNovember(BigDecimal paidOutNovember) {
        set(PROPERTY_PAIDOUTNOVEMBER, paidOutNovember);
    }

    public BigDecimal getPaidOutDecember() {
        return (BigDecimal) get(PROPERTY_PAIDOUTDECEMBER);
    }

    public void setPaidOutDecember(BigDecimal paidOutDecember) {
        set(PROPERTY_PAIDOUTDECEMBER, paidOutDecember);
    }

    public BigDecimal getReforms() {
        return (BigDecimal) get(COMPUTED_COLUMN_REFORMS);
    }

    public void setReforms(BigDecimal reforms) {
        set(COMPUTED_COLUMN_REFORMS, reforms);
    }

    public BigDecimal getCommitments() {
        return (BigDecimal) get(COMPUTED_COLUMN_COMMITMENTS);
    }

    public void setCommitments(BigDecimal commitments) {
        set(COMPUTED_COLUMN_COMMITMENTS, commitments);
    }

    public BigDecimal getFORCompromising() {
        return (BigDecimal) get(COMPUTED_COLUMN_FORCOMPROMISING);
    }

    public void setFORCompromising(BigDecimal fORCompromising) {
        set(COMPUTED_COLUMN_FORCOMPROMISING, fORCompromising);
    }

    public BigDecimal getValuetoexecute() {
        return (BigDecimal) get(COMPUTED_COLUMN_VALUETOEXECUTE);
    }

    public void setValuetoexecute(BigDecimal valuetoexecute) {
        set(COMPUTED_COLUMN_VALUETOEXECUTE, valuetoexecute);
    }

    public String getTypeOfBudget() {
        return (String) get(COMPUTED_COLUMN_TYPEOFBUDGET);
    }

    public void setTypeOfBudget(String typeOfBudget) {
        set(COMPUTED_COLUMN_TYPEOFBUDGET, typeOfBudget);
    }

    public String getVersionStatus() {
        return (String) get(COMPUTED_COLUMN_VERSIONSTATUS);
    }

    public void setVersionStatus(String versionStatus) {
        set(COMPUTED_COLUMN_VERSIONSTATUS, versionStatus);
    }

    public String getYear() {
        return (String) get(COMPUTED_COLUMN_YEAR);
    }

    public void setYear(String year) {
        set(COMPUTED_COLUMN_YEAR, year);
    }

    public SFBBudgetLine_ComputedColumns get_computedColumns() {
        return (SFBBudgetLine_ComputedColumns) get(PROPERTY__COMPUTEDCOLUMNS);
    }

    public void set_computedColumns(SFBBudgetLine_ComputedColumns _computedColumns) {
        set(PROPERTY__COMPUTEDCOLUMNS, _computedColumns);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceLine> getInvoiceLineEMSsrfcBudgetLineIDList() {
      return (List<InvoiceLine>) get(PROPERTY_INVOICELINEEMSSRFCBUDGETLINEIDLIST);
    }

    public void setInvoiceLineEMSsrfcBudgetLineIDList(List<InvoiceLine> invoiceLineEMSsrfcBudgetLineIDList) {
        set(PROPERTY_INVOICELINEEMSSRFCBUDGETLINEIDLIST, invoiceLineEMSsrfcBudgetLineIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SFBBudgetLogLine> getSFBBudgetLogLineList() {
      return (List<SFBBudgetLogLine>) get(PROPERTY_SFBBUDGETLOGLINELIST);
    }

    public void setSFBBudgetLogLineList(List<SFBBudgetLogLine> sFBBudgetLogLineList) {
        set(PROPERTY_SFBBUDGETLOGLINELIST, sFBBudgetLogLineList);
    }

    @SuppressWarnings("unchecked")
    public List<SfbtrBudgetaryReforms> getSfbtrBudgetaryReformsList() {
      return (List<SfbtrBudgetaryReforms>) get(PROPERTY_SFBTRBUDGETARYREFORMSLIST);
    }

    public void setSfbtrBudgetaryReformsList(List<SfbtrBudgetaryReforms> sfbtrBudgetaryReformsList) {
        set(PROPERTY_SFBTRBUDGETARYREFORMSLIST, sfbtrBudgetaryReformsList);
    }

    @SuppressWarnings("unchecked")
    public List<SfbtrTransferFrom> getSfbtrTransferFromList() {
      return (List<SfbtrTransferFrom>) get(PROPERTY_SFBTRTRANSFERFROMLIST);
    }

    public void setSfbtrTransferFromList(List<SfbtrTransferFrom> sfbtrTransferFromList) {
        set(PROPERTY_SFBTRTRANSFERFROMLIST, sfbtrTransferFromList);
    }

    @SuppressWarnings("unchecked")
    public List<SfbtrTransferTo> getSfbtrTransferToList() {
      return (List<SfbtrTransferTo>) get(PROPERTY_SFBTRTRANSFERTOLIST);
    }

    public void setSfbtrTransferToList(List<SfbtrTransferTo> sfbtrTransferToList) {
        set(PROPERTY_SFBTRTRANSFERTOLIST, sfbtrTransferToList);
    }

    @SuppressWarnings("unchecked")
    public List<EcsppPAC> getEcsppPacBudgetLineIDList() {
      return (List<EcsppPAC>) get(PROPERTY_ECSPPPACBUDGETLINEIDLIST);
    }

    public void setEcsppPacBudgetLineIDList(List<EcsppPAC> ecsppPacBudgetLineIDList) {
        set(PROPERTY_ECSPPPACBUDGETLINEIDLIST, ecsppPacBudgetLineIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SFBBudgetLineDetail> getSfbBudgetLineDetailVList() {
      return (List<SFBBudgetLineDetail>) get(PROPERTY_SFBBUDGETLINEDETAILVLIST);
    }

    public void setSfbBudgetLineDetailVList(List<SFBBudgetLineDetail> sfbBudgetLineDetailVList) {
        set(PROPERTY_SFBBUDGETLINEDETAILVLIST, sfbBudgetLineDetailVList);
    }

    @SuppressWarnings("unchecked")
    public List<sfb_budget_log_v> getSfbBudgetLogVPresupuestoIDList() {
      return (List<sfb_budget_log_v>) get(PROPERTY_SFBBUDGETLOGVPRESUPUESTOIDLIST);
    }

    public void setSfbBudgetLogVPresupuestoIDList(List<sfb_budget_log_v> sfbBudgetLogVPresupuestoIDList) {
        set(PROPERTY_SFBBUDGETLOGVPRESUPUESTOIDLIST, sfbBudgetLogVPresupuestoIDList);
    }


    @Override
    public Object get(String propName) {
      if (COMPUTED_COLUMN_REFORMS.equals(propName)) {
        if (get_computedColumns() == null) {
          return null;
        }
        return get_computedColumns().getReforms();
      }
      if (COMPUTED_COLUMN_COMMITMENTS.equals(propName)) {
        if (get_computedColumns() == null) {
          return null;
        }
        return get_computedColumns().getCommitments();
      }
      if (COMPUTED_COLUMN_FORCOMPROMISING.equals(propName)) {
        if (get_computedColumns() == null) {
          return null;
        }
        return get_computedColumns().getFORCompromising();
      }
      if (COMPUTED_COLUMN_VALUETOEXECUTE.equals(propName)) {
        if (get_computedColumns() == null) {
          return null;
        }
        return get_computedColumns().getValuetoexecute();
      }
      if (COMPUTED_COLUMN_TYPEOFBUDGET.equals(propName)) {
        if (get_computedColumns() == null) {
          return null;
        }
        return get_computedColumns().getTypeOfBudget();
      }
      if (COMPUTED_COLUMN_VERSIONSTATUS.equals(propName)) {
        if (get_computedColumns() == null) {
          return null;
        }
        return get_computedColumns().getVersionStatus();
      }
      if (COMPUTED_COLUMN_YEAR.equals(propName)) {
        if (get_computedColumns() == null) {
          return null;
        }
        return get_computedColumns().getYear();
      }
    
      return super.get(propName);
    }
}
