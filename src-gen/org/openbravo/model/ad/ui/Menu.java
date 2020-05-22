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
package org.openbravo.model.ad.ui;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.client.application.MenuParameter;
import org.openbravo.client.application.OBUIAPPViewImplementation;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.module.Module;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
/**
 * Entity class for entity ADMenu (stored in table AD_Menu).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Menu extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "AD_Menu";
    public static final String ENTITY_NAME = "ADMenu";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_SUMMARYLEVEL = "summaryLevel";
    public static final String PROPERTY_ACTION = "action";
    public static final String PROPERTY_WINDOW = "window";
    public static final String PROPERTY_PROCESS = "process";
    public static final String PROPERTY_SPECIALFORM = "specialForm";
    public static final String PROPERTY_URL = "uRL";
    public static final String PROPERTY_MODULE = "module";
    public static final String PROPERTY_OBUIAPPVIEW = "obuiappView";
    public static final String PROPERTY_OBUIAPPPROCESSDEFINITION = "oBUIAPPProcessDefinition";
    public static final String PROPERTY_OPENLINKINBROWSER = "openlinkinbrowser";
    public static final String PROPERTY_ADMENUTRLLIST = "aDMenuTrlList";
    public static final String PROPERTY_OBUIAPPMENUPARAMETERSLIST = "oBUIAPPMenuParametersList";

    public Menu() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_SUMMARYLEVEL, false);
        setDefaultValue(PROPERTY_OPENLINKINBROWSER, false);
        setDefaultValue(PROPERTY_ADMENUTRLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OBUIAPPMENUPARAMETERSLIST, new ArrayList<Object>());
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

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
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

    public Boolean isSummaryLevel() {
        return (Boolean) get(PROPERTY_SUMMARYLEVEL);
    }

    public void setSummaryLevel(Boolean summaryLevel) {
        set(PROPERTY_SUMMARYLEVEL, summaryLevel);
    }

    public String getAction() {
        return (String) get(PROPERTY_ACTION);
    }

    public void setAction(String action) {
        set(PROPERTY_ACTION, action);
    }

    public Window getWindow() {
        return (Window) get(PROPERTY_WINDOW);
    }

    public void setWindow(Window window) {
        set(PROPERTY_WINDOW, window);
    }

    public Process getProcess() {
        return (Process) get(PROPERTY_PROCESS);
    }

    public void setProcess(Process process) {
        set(PROPERTY_PROCESS, process);
    }

    public Form getSpecialForm() {
        return (Form) get(PROPERTY_SPECIALFORM);
    }

    public void setSpecialForm(Form specialForm) {
        set(PROPERTY_SPECIALFORM, specialForm);
    }

    public String getURL() {
        return (String) get(PROPERTY_URL);
    }

    public void setURL(String uRL) {
        set(PROPERTY_URL, uRL);
    }

    public Module getModule() {
        return (Module) get(PROPERTY_MODULE);
    }

    public void setModule(Module module) {
        set(PROPERTY_MODULE, module);
    }

    public OBUIAPPViewImplementation getObuiappView() {
        return (OBUIAPPViewImplementation) get(PROPERTY_OBUIAPPVIEW);
    }

    public void setObuiappView(OBUIAPPViewImplementation obuiappView) {
        set(PROPERTY_OBUIAPPVIEW, obuiappView);
    }

    public org.openbravo.client.application.Process getOBUIAPPProcessDefinition() {
        return (org.openbravo.client.application.Process) get(PROPERTY_OBUIAPPPROCESSDEFINITION);
    }

    public void setOBUIAPPProcessDefinition(org.openbravo.client.application.Process oBUIAPPProcessDefinition) {
        set(PROPERTY_OBUIAPPPROCESSDEFINITION, oBUIAPPProcessDefinition);
    }

    public Boolean isOpenlinkinbrowser() {
        return (Boolean) get(PROPERTY_OPENLINKINBROWSER);
    }

    public void setOpenlinkinbrowser(Boolean openlinkinbrowser) {
        set(PROPERTY_OPENLINKINBROWSER, openlinkinbrowser);
    }

    @SuppressWarnings("unchecked")
    public List<MenuTrl> getADMenuTrlList() {
      return (List<MenuTrl>) get(PROPERTY_ADMENUTRLLIST);
    }

    public void setADMenuTrlList(List<MenuTrl> aDMenuTrlList) {
        set(PROPERTY_ADMENUTRLLIST, aDMenuTrlList);
    }

    @SuppressWarnings("unchecked")
    public List<MenuParameter> getOBUIAPPMenuParametersList() {
      return (List<MenuParameter>) get(PROPERTY_OBUIAPPMENUPARAMETERSLIST);
    }

    public void setOBUIAPPMenuParametersList(List<MenuParameter> oBUIAPPMenuParametersList) {
        set(PROPERTY_OBUIAPPMENUPARAMETERSLIST, oBUIAPPMenuParametersList);
    }

}
