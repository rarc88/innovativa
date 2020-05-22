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

import com.sidesoft.hrm.payroll.Position;

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
/**
 * Entity class for entity sfpr_rve (stored in table sfpr_rve).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SfprRve extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sfpr_rve";
    public static final String ENTITY_NAME = "sfpr_rve";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_GRADE = "grade";
    public static final String PROPERTY_POSITION = "position";
    public static final String PROPERTY_RMU = "rmu";
    public static final String PROPERTY_HANDIMAX = "handimax";
    public static final String PROPERTY_RVEHANDIMAXDAILY = "rVEHandimaxDaily";
    public static final String PROPERTY_PANAMAX = "panamax";
    public static final String PROPERTY_RVEPANAMAXDAILY = "rVEPanamaxDaily";
    public static final String PROPERTY_AFRAMAX = "aframax";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_RVEAFRAMAXDAILY = "rVEAframaxDaily";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_VALUEOF1STLEVEL = "valueOf1stLevel";
    public static final String PROPERTY_VALUEOF2NDLEVEL = "valueOf2ndLevel";
    public static final String PROPERTY_VALUEOF3RDLEVEL = "valueOf3rdLevel";
    public static final String PROPERTY_SFPRRVEDETAILLIST = "sfprRveDetailList";

    public SfprRve() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_SFPRRVEDETAILLIST, new ArrayList<Object>());
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

    public SfprGrade getGrade() {
        return (SfprGrade) get(PROPERTY_GRADE);
    }

    public void setGrade(SfprGrade grade) {
        set(PROPERTY_GRADE, grade);
    }

    public Position getPosition() {
        return (Position) get(PROPERTY_POSITION);
    }

    public void setPosition(Position position) {
        set(PROPERTY_POSITION, position);
    }

    public Long getRmu() {
        return (Long) get(PROPERTY_RMU);
    }

    public void setRmu(Long rmu) {
        set(PROPERTY_RMU, rmu);
    }

    public BigDecimal getHandimax() {
        return (BigDecimal) get(PROPERTY_HANDIMAX);
    }

    public void setHandimax(BigDecimal handimax) {
        set(PROPERTY_HANDIMAX, handimax);
    }

    public BigDecimal getRVEHandimaxDaily() {
        return (BigDecimal) get(PROPERTY_RVEHANDIMAXDAILY);
    }

    public void setRVEHandimaxDaily(BigDecimal rVEHandimaxDaily) {
        set(PROPERTY_RVEHANDIMAXDAILY, rVEHandimaxDaily);
    }

    public BigDecimal getPanamax() {
        return (BigDecimal) get(PROPERTY_PANAMAX);
    }

    public void setPanamax(BigDecimal panamax) {
        set(PROPERTY_PANAMAX, panamax);
    }

    public BigDecimal getRVEPanamaxDaily() {
        return (BigDecimal) get(PROPERTY_RVEPANAMAXDAILY);
    }

    public void setRVEPanamaxDaily(BigDecimal rVEPanamaxDaily) {
        set(PROPERTY_RVEPANAMAXDAILY, rVEPanamaxDaily);
    }

    public BigDecimal getAframax() {
        return (BigDecimal) get(PROPERTY_AFRAMAX);
    }

    public void setAframax(BigDecimal aframax) {
        set(PROPERTY_AFRAMAX, aframax);
    }

    public Boolean isActive() {
        return (Boolean) get(PROPERTY_ACTIVE);
    }

    public void setActive(Boolean active) {
        set(PROPERTY_ACTIVE, active);
    }

    public BigDecimal getRVEAframaxDaily() {
        return (BigDecimal) get(PROPERTY_RVEAFRAMAXDAILY);
    }

    public void setRVEAframaxDaily(BigDecimal rVEAframaxDaily) {
        set(PROPERTY_RVEAFRAMAXDAILY, rVEAframaxDaily);
    }

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
    }

    public User getUpdatedBy() {
        return (User) get(PROPERTY_UPDATEDBY);
    }

    public void setUpdatedBy(User updatedBy) {
        set(PROPERTY_UPDATEDBY, updatedBy);
    }

    public Long getValueOf1stLevel() {
        return (Long) get(PROPERTY_VALUEOF1STLEVEL);
    }

    public void setValueOf1stLevel(Long valueOf1stLevel) {
        set(PROPERTY_VALUEOF1STLEVEL, valueOf1stLevel);
    }

    public Long getValueOf2ndLevel() {
        return (Long) get(PROPERTY_VALUEOF2NDLEVEL);
    }

    public void setValueOf2ndLevel(Long valueOf2ndLevel) {
        set(PROPERTY_VALUEOF2NDLEVEL, valueOf2ndLevel);
    }

    public Long getValueOf3rdLevel() {
        return (Long) get(PROPERTY_VALUEOF3RDLEVEL);
    }

    public void setValueOf3rdLevel(Long valueOf3rdLevel) {
        set(PROPERTY_VALUEOF3RDLEVEL, valueOf3rdLevel);
    }

    @SuppressWarnings("unchecked")
    public List<SfprRveDetail> getSfprRveDetailList() {
      return (List<SfprRveDetail>) get(PROPERTY_SFPRRVEDETAILLIST);
    }

    public void setSfprRveDetailList(List<SfprRveDetail> sfprRveDetailList) {
        set(PROPERTY_SFPRRVEDETAILLIST, sfprRveDetailList);
    }

}
