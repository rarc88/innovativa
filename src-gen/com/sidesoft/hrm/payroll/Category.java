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

import java.util.Date;

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
 * Entity class for entity SSPR_Category (stored in table SSPR_Category).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Category extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "SSPR_Category";
    public static final String ENTITY_NAME = "SSPR_Category";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_CATEGORY = "category";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_PENSIONTYPE = "pensiontype";
    public static final String PROPERTY_ENTRYDATE = "entrydate";
    public static final String PROPERTY_SITUATION = "situation";
    public static final String PROPERTY_RUC = "ruc";
    public static final String PROPERTY_ISTAXFOURTH = "istaxfourth";
    public static final String PROPERTY_MODETYPE = "modetype";
    public static final String PROPERTY_ISHEALTHINSURANCE = "ishealthinsurance";
    public static final String PROPERTY_STUDYCENTER = "studycenter";
    public static final String PROPERTY_ISRESPONSIBLEMOTHER = "isresponsiblemother";
    public static final String PROPERTY_ISNIGHT = "isnight";
    public static final String PROPERTY_THIRDRUC = "thirdruc";
    public static final String PROPERTY_STARTDATE = "startdate";
    public static final String PROPERTY_CUSSP = "cussp";
    public static final String PROPERTY_EMPLOYEETYPE = "employeetype";
    public static final String PROPERTY_SSPROCCUPATION = "ssprOccupation";
    public static final String PROPERTY_ENDDATE = "enddate";
    public static final String PROPERTY_SSPRPENSIONSYSTEM = "ssprPensionSystem";
    public static final String PROPERTY_ESSALUDCODE = "essaludcode";

    public Category() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_ISTAXFOURTH, false);
        setDefaultValue(PROPERTY_ISHEALTHINSURANCE, false);
        setDefaultValue(PROPERTY_ISRESPONSIBLEMOTHER, false);
        setDefaultValue(PROPERTY_ISNIGHT, false);
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

    public String getCategory() {
        return (String) get(PROPERTY_CATEGORY);
    }

    public void setCategory(String category) {
        set(PROPERTY_CATEGORY, category);
    }

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public String getPensiontype() {
        return (String) get(PROPERTY_PENSIONTYPE);
    }

    public void setPensiontype(String pensiontype) {
        set(PROPERTY_PENSIONTYPE, pensiontype);
    }

    public Date getEntrydate() {
        return (Date) get(PROPERTY_ENTRYDATE);
    }

    public void setEntrydate(Date entrydate) {
        set(PROPERTY_ENTRYDATE, entrydate);
    }

    public String getSituation() {
        return (String) get(PROPERTY_SITUATION);
    }

    public void setSituation(String situation) {
        set(PROPERTY_SITUATION, situation);
    }

    public String getRuc() {
        return (String) get(PROPERTY_RUC);
    }

    public void setRuc(String ruc) {
        set(PROPERTY_RUC, ruc);
    }

    public Boolean isTaxfourth() {
        return (Boolean) get(PROPERTY_ISTAXFOURTH);
    }

    public void setTaxfourth(Boolean istaxfourth) {
        set(PROPERTY_ISTAXFOURTH, istaxfourth);
    }

    public String getModetype() {
        return (String) get(PROPERTY_MODETYPE);
    }

    public void setModetype(String modetype) {
        set(PROPERTY_MODETYPE, modetype);
    }

    public Boolean isHealthinsurance() {
        return (Boolean) get(PROPERTY_ISHEALTHINSURANCE);
    }

    public void setHealthinsurance(Boolean ishealthinsurance) {
        set(PROPERTY_ISHEALTHINSURANCE, ishealthinsurance);
    }

    public String getStudycenter() {
        return (String) get(PROPERTY_STUDYCENTER);
    }

    public void setStudycenter(String studycenter) {
        set(PROPERTY_STUDYCENTER, studycenter);
    }

    public Boolean isResponsiblemother() {
        return (Boolean) get(PROPERTY_ISRESPONSIBLEMOTHER);
    }

    public void setResponsiblemother(Boolean isresponsiblemother) {
        set(PROPERTY_ISRESPONSIBLEMOTHER, isresponsiblemother);
    }

    public Boolean isNight() {
        return (Boolean) get(PROPERTY_ISNIGHT);
    }

    public void setNight(Boolean isnight) {
        set(PROPERTY_ISNIGHT, isnight);
    }

    public String getThirdruc() {
        return (String) get(PROPERTY_THIRDRUC);
    }

    public void setThirdruc(String thirdruc) {
        set(PROPERTY_THIRDRUC, thirdruc);
    }

    public Date getStartdate() {
        return (Date) get(PROPERTY_STARTDATE);
    }

    public void setStartdate(Date startdate) {
        set(PROPERTY_STARTDATE, startdate);
    }

    public String getCussp() {
        return (String) get(PROPERTY_CUSSP);
    }

    public void setCussp(String cussp) {
        set(PROPERTY_CUSSP, cussp);
    }

    public String getEmployeetype() {
        return (String) get(PROPERTY_EMPLOYEETYPE);
    }

    public void setEmployeetype(String employeetype) {
        set(PROPERTY_EMPLOYEETYPE, employeetype);
    }

    public Occupation getSsprOccupation() {
        return (Occupation) get(PROPERTY_SSPROCCUPATION);
    }

    public void setSsprOccupation(Occupation ssprOccupation) {
        set(PROPERTY_SSPROCCUPATION, ssprOccupation);
    }

    public Date getEnddate() {
        return (Date) get(PROPERTY_ENDDATE);
    }

    public void setEnddate(Date enddate) {
        set(PROPERTY_ENDDATE, enddate);
    }

    public PensionSystem getSsprPensionSystem() {
        return (PensionSystem) get(PROPERTY_SSPRPENSIONSYSTEM);
    }

    public void setSsprPensionSystem(PensionSystem ssprPensionSystem) {
        set(PROPERTY_SSPRPENSIONSYSTEM, ssprPensionSystem);
    }

    public String getEssaludcode() {
        return (String) get(PROPERTY_ESSALUDCODE);
    }

    public void setEssaludcode(String essaludcode) {
        set(PROPERTY_ESSALUDCODE, essaludcode);
    }

}
