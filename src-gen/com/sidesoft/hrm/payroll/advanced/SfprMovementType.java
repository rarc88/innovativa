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
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
/**
 * Entity class for entity sfpr_movement_type (stored in table sfpr_movement_type).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SfprMovementType extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sfpr_movement_type";
    public static final String ENTITY_NAME = "sfpr_movement_type";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_DOCUMENTTYPE = "documentType";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_MOVEMENTOFDATE = "movementOfDate";
    public static final String PROPERTY_OBSERVATION = "observation";
    public static final String PROPERTY_SFPREMPLOYEEOTHERLIST = "sfprEmployeeOtherList";
    public static final String PROPERTY_SFPREMPLOYEEPERMITLIST = "sfprEmployeePermitList";
    public static final String PROPERTY_SFPREMPLOYEERVELIST = "sfprEmployeeRveList";
    public static final String PROPERTY_SFPREMPLOYEESURROGATELIST = "sfprEmployeeSurrogateList";
    public static final String PROPERTY_SFPREMPLOYEEVACATIONLIST = "sfprEmployeeVacationList";
    public static final String PROPERTY_SFPRRVEDETAILLIST = "sfprRveDetailList";
    public static final String PROPERTY_SFPRSURROGATEDETAILLIST = "sfprSurrogateDetailList";

    public SfprMovementType() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_SFPREMPLOYEEOTHERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPREMPLOYEEPERMITLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPREMPLOYEERVELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPREMPLOYEESURROGATELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPREMPLOYEEVACATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPRRVEDETAILLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPRSURROGATEDETAILLIST, new ArrayList<Object>());
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

    public Boolean isActive() {
        return (Boolean) get(PROPERTY_ACTIVE);
    }

    public void setActive(Boolean active) {
        set(PROPERTY_ACTIVE, active);
    }

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
    }

    public DocumentType getDocumentType() {
        return (DocumentType) get(PROPERTY_DOCUMENTTYPE);
    }

    public void setDocumentType(DocumentType documentType) {
        set(PROPERTY_DOCUMENTTYPE, documentType);
    }

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

    public Date getMovementOfDate() {
        return (Date) get(PROPERTY_MOVEMENTOFDATE);
    }

    public void setMovementOfDate(Date movementOfDate) {
        set(PROPERTY_MOVEMENTOFDATE, movementOfDate);
    }

    public String getObservation() {
        return (String) get(PROPERTY_OBSERVATION);
    }

    public void setObservation(String observation) {
        set(PROPERTY_OBSERVATION, observation);
    }

    @SuppressWarnings("unchecked")
    public List<SfprEmployeeOther> getSfprEmployeeOtherList() {
      return (List<SfprEmployeeOther>) get(PROPERTY_SFPREMPLOYEEOTHERLIST);
    }

    public void setSfprEmployeeOtherList(List<SfprEmployeeOther> sfprEmployeeOtherList) {
        set(PROPERTY_SFPREMPLOYEEOTHERLIST, sfprEmployeeOtherList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprEmployeePermit> getSfprEmployeePermitList() {
      return (List<SfprEmployeePermit>) get(PROPERTY_SFPREMPLOYEEPERMITLIST);
    }

    public void setSfprEmployeePermitList(List<SfprEmployeePermit> sfprEmployeePermitList) {
        set(PROPERTY_SFPREMPLOYEEPERMITLIST, sfprEmployeePermitList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprEmployeeRve> getSfprEmployeeRveList() {
      return (List<SfprEmployeeRve>) get(PROPERTY_SFPREMPLOYEERVELIST);
    }

    public void setSfprEmployeeRveList(List<SfprEmployeeRve> sfprEmployeeRveList) {
        set(PROPERTY_SFPREMPLOYEERVELIST, sfprEmployeeRveList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprEmployeeSurrogate> getSfprEmployeeSurrogateList() {
      return (List<SfprEmployeeSurrogate>) get(PROPERTY_SFPREMPLOYEESURROGATELIST);
    }

    public void setSfprEmployeeSurrogateList(List<SfprEmployeeSurrogate> sfprEmployeeSurrogateList) {
        set(PROPERTY_SFPREMPLOYEESURROGATELIST, sfprEmployeeSurrogateList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprEmployeeVacation> getSfprEmployeeVacationList() {
      return (List<SfprEmployeeVacation>) get(PROPERTY_SFPREMPLOYEEVACATIONLIST);
    }

    public void setSfprEmployeeVacationList(List<SfprEmployeeVacation> sfprEmployeeVacationList) {
        set(PROPERTY_SFPREMPLOYEEVACATIONLIST, sfprEmployeeVacationList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprRveDetail> getSfprRveDetailList() {
      return (List<SfprRveDetail>) get(PROPERTY_SFPRRVEDETAILLIST);
    }

    public void setSfprRveDetailList(List<SfprRveDetail> sfprRveDetailList) {
        set(PROPERTY_SFPRRVEDETAILLIST, sfprRveDetailList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprSurrogateDetail> getSfprSurrogateDetailList() {
      return (List<SfprSurrogateDetail>) get(PROPERTY_SFPRSURROGATEDETAILLIST);
    }

    public void setSfprSurrogateDetailList(List<SfprSurrogateDetail> sfprSurrogateDetailList) {
        set(PROPERTY_SFPRSURROGATEDETAILLIST, sfprSurrogateDetailList);
    }

}
