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
package it.openia.crm;

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
 * Entity class for entity opcrm_stat_stage (stored in table opcrm_stat_stage).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class OpcrmStatStage extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "opcrm_stat_stage";
    public static final String ENTITY_NAME = "opcrm_stat_stage";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_STAGENAME = "stagename";
    public static final String PROPERTY_COMMERCIALNAME = "commercialName";
    public static final String PROPERTY_ORDERING = "ordering";
    public static final String PROPERTY_ADUSEREMOPCRMSTATSTAGEIDLIST = "aDUserEMOpcrmStatStageIDList";
    public static final String PROPERTY_OPCRMFUNCINTERESTVIEWVLIST = "opcrmFuncinterestviewVList";
    public static final String PROPERTY_OPCRMLOCATIONVIEWVLIST = "opcrmLocationviewVList";
    public static final String PROPERTY_OPCRMRECENTLYUPDATEDVLIST = "opcrmRecentlyupdatedVList";
    public static final String PROPERTY_OPCRMSTATSTAGETRLLIST = "opcrmStatStageTrlList";

    public OpcrmStatStage() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_ADUSEREMOPCRMSTATSTAGEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OPCRMFUNCINTERESTVIEWVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OPCRMLOCATIONVIEWVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OPCRMRECENTLYUPDATEDVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OPCRMSTATSTAGETRLLIST, new ArrayList<Object>());
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

    public String getStagename() {
        return (String) get(PROPERTY_STAGENAME);
    }

    public void setStagename(String stagename) {
        set(PROPERTY_STAGENAME, stagename);
    }

    public String getCommercialName() {
        return (String) get(PROPERTY_COMMERCIALNAME);
    }

    public void setCommercialName(String commercialName) {
        set(PROPERTY_COMMERCIALNAME, commercialName);
    }

    public Long getOrdering() {
        return (Long) get(PROPERTY_ORDERING);
    }

    public void setOrdering(Long ordering) {
        set(PROPERTY_ORDERING, ordering);
    }

    @SuppressWarnings("unchecked")
    public List<User> getADUserEMOpcrmStatStageIDList() {
      return (List<User>) get(PROPERTY_ADUSEREMOPCRMSTATSTAGEIDLIST);
    }

    public void setADUserEMOpcrmStatStageIDList(List<User> aDUserEMOpcrmStatStageIDList) {
        set(PROPERTY_ADUSEREMOPCRMSTATSTAGEIDLIST, aDUserEMOpcrmStatStageIDList);
    }

    @SuppressWarnings("unchecked")
    public List<OpcrmFuncinterestviewV> getOpcrmFuncinterestviewVList() {
      return (List<OpcrmFuncinterestviewV>) get(PROPERTY_OPCRMFUNCINTERESTVIEWVLIST);
    }

    public void setOpcrmFuncinterestviewVList(List<OpcrmFuncinterestviewV> opcrmFuncinterestviewVList) {
        set(PROPERTY_OPCRMFUNCINTERESTVIEWVLIST, opcrmFuncinterestviewVList);
    }

    @SuppressWarnings("unchecked")
    public List<OpcrmLocationviewV> getOpcrmLocationviewVList() {
      return (List<OpcrmLocationviewV>) get(PROPERTY_OPCRMLOCATIONVIEWVLIST);
    }

    public void setOpcrmLocationviewVList(List<OpcrmLocationviewV> opcrmLocationviewVList) {
        set(PROPERTY_OPCRMLOCATIONVIEWVLIST, opcrmLocationviewVList);
    }

    @SuppressWarnings("unchecked")
    public List<OpcrmRecentlyupdatedV> getOpcrmRecentlyupdatedVList() {
      return (List<OpcrmRecentlyupdatedV>) get(PROPERTY_OPCRMRECENTLYUPDATEDVLIST);
    }

    public void setOpcrmRecentlyupdatedVList(List<OpcrmRecentlyupdatedV> opcrmRecentlyupdatedVList) {
        set(PROPERTY_OPCRMRECENTLYUPDATEDVLIST, opcrmRecentlyupdatedVList);
    }

    @SuppressWarnings("unchecked")
    public List<OpcrmStatStageTrl> getOpcrmStatStageTrlList() {
      return (List<OpcrmStatStageTrl>) get(PROPERTY_OPCRMSTATSTAGETRLLIST);
    }

    public void setOpcrmStatStageTrlList(List<OpcrmStatStageTrl> opcrmStatStageTrlList) {
        set(PROPERTY_OPCRMSTATSTAGETRLLIST, opcrmStatStageTrlList);
    }

}
