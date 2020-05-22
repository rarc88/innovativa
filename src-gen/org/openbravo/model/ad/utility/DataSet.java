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
package org.openbravo.model.ad.utility;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.module.Module;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.enterprise.OrganizationModuleV;
/**
 * Entity class for entity DataSet (stored in table AD_Dataset).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class DataSet extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "AD_Dataset";
    public static final String ENTITY_NAME = "DataSet";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_SEARCHKEY = "searchKey";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_MODULE = "module";
    public static final String PROPERTY_EXPORT = "export";
    public static final String PROPERTY_DATAACCESSLEVEL = "dataAccessLevel";
    public static final String PROPERTY_EXPORTALLOWED = "exportAllowed";
    public static final String PROPERTY_CHECKSUM = "checksum";
    public static final String PROPERTY_SEQUENCENUMBER = "sequenceNumber";
    public static final String PROPERTY_DEFAULTVALUESDATASET = "defaultValuesDataSet";
    public static final String PROPERTY_DATASETTABLELIST = "dataSetTableList";
    public static final String PROPERTY_ORGANIZATIONMODULEVLIST = "organizationModuleVList";

    public DataSet() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_CREATIONDATE, new Date());
        setDefaultValue(PROPERTY_UPDATED, new Date());
        setDefaultValue(PROPERTY_EXPORT, false);
        setDefaultValue(PROPERTY_DATAACCESSLEVEL, "4");
        setDefaultValue(PROPERTY_EXPORTALLOWED, true);
        setDefaultValue(PROPERTY_DEFAULTVALUESDATASET, false);
        setDefaultValue(PROPERTY_DATASETTABLELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORGANIZATIONMODULEVLIST, new ArrayList<Object>());
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

    public String getSearchKey() {
        return (String) get(PROPERTY_SEARCHKEY);
    }

    public void setSearchKey(String searchKey) {
        set(PROPERTY_SEARCHKEY, searchKey);
    }

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Module getModule() {
        return (Module) get(PROPERTY_MODULE);
    }

    public void setModule(Module module) {
        set(PROPERTY_MODULE, module);
    }

    public Boolean isExport() {
        return (Boolean) get(PROPERTY_EXPORT);
    }

    public void setExport(Boolean export) {
        set(PROPERTY_EXPORT, export);
    }

    public String getDataAccessLevel() {
        return (String) get(PROPERTY_DATAACCESSLEVEL);
    }

    public void setDataAccessLevel(String dataAccessLevel) {
        set(PROPERTY_DATAACCESSLEVEL, dataAccessLevel);
    }

    public Boolean isExportAllowed() {
        return (Boolean) get(PROPERTY_EXPORTALLOWED);
    }

    public void setExportAllowed(Boolean exportAllowed) {
        set(PROPERTY_EXPORTALLOWED, exportAllowed);
    }

    public String getChecksum() {
        return (String) get(PROPERTY_CHECKSUM);
    }

    public void setChecksum(String checksum) {
        set(PROPERTY_CHECKSUM, checksum);
    }

    public Long getSequenceNumber() {
        return (Long) get(PROPERTY_SEQUENCENUMBER);
    }

    public void setSequenceNumber(Long sequenceNumber) {
        set(PROPERTY_SEQUENCENUMBER, sequenceNumber);
    }

    public Boolean isDefaultValuesDataSet() {
        return (Boolean) get(PROPERTY_DEFAULTVALUESDATASET);
    }

    public void setDefaultValuesDataSet(Boolean defaultValuesDataSet) {
        set(PROPERTY_DEFAULTVALUESDATASET, defaultValuesDataSet);
    }

    @SuppressWarnings("unchecked")
    public List<DataSetTable> getDataSetTableList() {
      return (List<DataSetTable>) get(PROPERTY_DATASETTABLELIST);
    }

    public void setDataSetTableList(List<DataSetTable> dataSetTableList) {
        set(PROPERTY_DATASETTABLELIST, dataSetTableList);
    }

    @SuppressWarnings("unchecked")
    public List<OrganizationModuleV> getOrganizationModuleVList() {
      return (List<OrganizationModuleV>) get(PROPERTY_ORGANIZATIONMODULEVLIST);
    }

    public void setOrganizationModuleVList(List<OrganizationModuleV> organizationModuleVList) {
        set(PROPERTY_ORGANIZATIONMODULEVLIST, organizationModuleVList);
    }

}
