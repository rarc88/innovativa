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
package ec.com.sidesoft.contract;

import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
/**
 * Entity class for entity ssct_warranty (stored in table ssct_warranty).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ssctwarranty extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ssct_warranty";
    public static final String ENTITY_NAME = "ssct_warranty";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_CONTRACT = "contract";
    public static final String PROPERTY_WARRANTYFORM = "warrantyForm";
    public static final String PROPERTY_WARRANTYTYPES = "warrantyTypes";
    public static final String PROPERTY_VALIDITYDATEPOLICY = "validityDatePolicy";
    public static final String PROPERTY_AMOUNTINSURED = "amountInsured";
    public static final String PROPERTY_RENOVATIONNO = "renovationNo";
    public static final String PROPERTY_WARRANTYSTATUS = "warrantyStatus";
    public static final String PROPERTY_WARRANTYCUSTODY = "warrantyCustody";
    public static final String PROPERTY_OBSERVATIONS = "observations";
    public static final String PROPERTY_PREVENTIONDAY = "preventionDay";
    public static final String PROPERTY_LINENO = "lineNo";
    public static final String PROPERTY_INSURANCEWARRANTIES = "insuranceWarranties";

    public ssctwarranty() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_AMOUNTINSURED, (long) 0);
        setDefaultValue(PROPERTY_WARRANTYCUSTODY, false);
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

    public ssctcontract getContract() {
        return (ssctcontract) get(PROPERTY_CONTRACT);
    }

    public void setContract(ssctcontract contract) {
        set(PROPERTY_CONTRACT, contract);
    }

    public ssctwarrantyform getWarrantyForm() {
        return (ssctwarrantyform) get(PROPERTY_WARRANTYFORM);
    }

    public void setWarrantyForm(ssctwarrantyform warrantyForm) {
        set(PROPERTY_WARRANTYFORM, warrantyForm);
    }

    public ssctwarrantytypes getWarrantyTypes() {
        return (ssctwarrantytypes) get(PROPERTY_WARRANTYTYPES);
    }

    public void setWarrantyTypes(ssctwarrantytypes warrantyTypes) {
        set(PROPERTY_WARRANTYTYPES, warrantyTypes);
    }

    public Date getValidityDatePolicy() {
        return (Date) get(PROPERTY_VALIDITYDATEPOLICY);
    }

    public void setValidityDatePolicy(Date validityDatePolicy) {
        set(PROPERTY_VALIDITYDATEPOLICY, validityDatePolicy);
    }

    public Long getAmountInsured() {
        return (Long) get(PROPERTY_AMOUNTINSURED);
    }

    public void setAmountInsured(Long amountInsured) {
        set(PROPERTY_AMOUNTINSURED, amountInsured);
    }

    public String getRenovationNo() {
        return (String) get(PROPERTY_RENOVATIONNO);
    }

    public void setRenovationNo(String renovationNo) {
        set(PROPERTY_RENOVATIONNO, renovationNo);
    }

    public ssctwarrantystatus getWarrantyStatus() {
        return (ssctwarrantystatus) get(PROPERTY_WARRANTYSTATUS);
    }

    public void setWarrantyStatus(ssctwarrantystatus warrantyStatus) {
        set(PROPERTY_WARRANTYSTATUS, warrantyStatus);
    }

    public Boolean isWarrantyCustody() {
        return (Boolean) get(PROPERTY_WARRANTYCUSTODY);
    }

    public void setWarrantyCustody(Boolean warrantyCustody) {
        set(PROPERTY_WARRANTYCUSTODY, warrantyCustody);
    }

    public String getObservations() {
        return (String) get(PROPERTY_OBSERVATIONS);
    }

    public void setObservations(String observations) {
        set(PROPERTY_OBSERVATIONS, observations);
    }

    public Long getPreventionDay() {
        return (Long) get(PROPERTY_PREVENTIONDAY);
    }

    public void setPreventionDay(Long preventionDay) {
        set(PROPERTY_PREVENTIONDAY, preventionDay);
    }

    public Long getLineNo() {
        return (Long) get(PROPERTY_LINENO);
    }

    public void setLineNo(Long lineNo) {
        set(PROPERTY_LINENO, lineNo);
    }

    public SsctInsuranceWarranties getInsuranceWarranties() {
        return (SsctInsuranceWarranties) get(PROPERTY_INSURANCEWARRANTIES);
    }

    public void setInsuranceWarranties(SsctInsuranceWarranties insuranceWarranties) {
        set(PROPERTY_INSURANCEWARRANTIES, insuranceWarranties);
    }

}
