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
package ec.cusoft.facturaec;

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
 * Entity class for entity EEI_Param_Facturae (stored in table EEI_Param_Facturae).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class EEIParamFacturae extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "EEI_Param_Facturae";
    public static final String ENTITY_NAME = "EEI_Param_Facturae";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_URLWSVALIDACION = "uRLWsValidacion";
    public static final String PROPERTY_URLWSAUTORIZACION = "uRLWsAutorizacion";
    public static final String PROPERTY_DIRCERTIFICADO = "dIRCertificado";
    public static final String PROPERTY_PASSWORD = "password";
    public static final String PROPERTY_DIRFILES = "dIRFiles";
    public static final String PROPERTY_DIRLLAVEPRIVADA = "dIRLlaveprivada";
    public static final String PROPERTY_ENVIRONMENT = "environment";
    public static final String PROPERTY_SENDINGTYPE = "sendingType";
    public static final String PROPERTY_TYPEOFBATCH = "typeOfBatch";
    public static final String PROPERTY_SHOWPRINCIPALCODE = "showprincipalcode";
    public static final String PROPERTY_SHOWAUXILIARYCODE = "showauxiliarycode";
    public static final String PROPERTY_TIMEOUTRESPONSE = "timeoutResponse";
    public static final String PROPERTY_DEFAULTEMAIL = "defaultEmail";
    public static final String PROPERTY_KEYACCESSGENERATION = "keyaccessGeneration";
    public static final String PROPERTY_COUNTRYCODE = "countryCode";

    public EEIParamFacturae() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_ENVIRONMENT, "1");
        setDefaultValue(PROPERTY_SENDINGTYPE, "1");
        setDefaultValue(PROPERTY_SHOWPRINCIPALCODE, true);
        setDefaultValue(PROPERTY_SHOWAUXILIARYCODE, true);
        setDefaultValue(PROPERTY_TIMEOUTRESPONSE, (long) 120000);
        setDefaultValue(PROPERTY_DEFAULTEMAIL, ".");
        setDefaultValue(PROPERTY_KEYACCESSGENERATION, false);
        setDefaultValue(PROPERTY_COUNTRYCODE, "593");
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

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public String getURLWsValidacion() {
        return (String) get(PROPERTY_URLWSVALIDACION);
    }

    public void setURLWsValidacion(String uRLWsValidacion) {
        set(PROPERTY_URLWSVALIDACION, uRLWsValidacion);
    }

    public String getURLWsAutorizacion() {
        return (String) get(PROPERTY_URLWSAUTORIZACION);
    }

    public void setURLWsAutorizacion(String uRLWsAutorizacion) {
        set(PROPERTY_URLWSAUTORIZACION, uRLWsAutorizacion);
    }

    public String getDIRCertificado() {
        return (String) get(PROPERTY_DIRCERTIFICADO);
    }

    public void setDIRCertificado(String dIRCertificado) {
        set(PROPERTY_DIRCERTIFICADO, dIRCertificado);
    }

    public String getPassword() {
        return (String) get(PROPERTY_PASSWORD);
    }

    public void setPassword(String password) {
        set(PROPERTY_PASSWORD, password);
    }

    public String getDIRFiles() {
        return (String) get(PROPERTY_DIRFILES);
    }

    public void setDIRFiles(String dIRFiles) {
        set(PROPERTY_DIRFILES, dIRFiles);
    }

    public String getDIRLlaveprivada() {
        return (String) get(PROPERTY_DIRLLAVEPRIVADA);
    }

    public void setDIRLlaveprivada(String dIRLlaveprivada) {
        set(PROPERTY_DIRLLAVEPRIVADA, dIRLlaveprivada);
    }

    public String getEnvironment() {
        return (String) get(PROPERTY_ENVIRONMENT);
    }

    public void setEnvironment(String environment) {
        set(PROPERTY_ENVIRONMENT, environment);
    }

    public String getSendingType() {
        return (String) get(PROPERTY_SENDINGTYPE);
    }

    public void setSendingType(String sendingType) {
        set(PROPERTY_SENDINGTYPE, sendingType);
    }

    public String getTypeOfBatch() {
        return (String) get(PROPERTY_TYPEOFBATCH);
    }

    public void setTypeOfBatch(String typeOfBatch) {
        set(PROPERTY_TYPEOFBATCH, typeOfBatch);
    }

    public Boolean isShowprincipalcode() {
        return (Boolean) get(PROPERTY_SHOWPRINCIPALCODE);
    }

    public void setShowprincipalcode(Boolean showprincipalcode) {
        set(PROPERTY_SHOWPRINCIPALCODE, showprincipalcode);
    }

    public Boolean isShowauxiliarycode() {
        return (Boolean) get(PROPERTY_SHOWAUXILIARYCODE);
    }

    public void setShowauxiliarycode(Boolean showauxiliarycode) {
        set(PROPERTY_SHOWAUXILIARYCODE, showauxiliarycode);
    }

    public Long getTimeoutResponse() {
        return (Long) get(PROPERTY_TIMEOUTRESPONSE);
    }

    public void setTimeoutResponse(Long timeoutResponse) {
        set(PROPERTY_TIMEOUTRESPONSE, timeoutResponse);
    }

    public String getDefaultEmail() {
        return (String) get(PROPERTY_DEFAULTEMAIL);
    }

    public void setDefaultEmail(String defaultEmail) {
        set(PROPERTY_DEFAULTEMAIL, defaultEmail);
    }

    public Boolean isKeyaccessGeneration() {
        return (Boolean) get(PROPERTY_KEYACCESSGENERATION);
    }

    public void setKeyaccessGeneration(Boolean keyaccessGeneration) {
        set(PROPERTY_KEYACCESSGENERATION, keyaccessGeneration);
    }

    public String getCountryCode() {
        return (String) get(PROPERTY_COUNTRYCODE);
    }

    public void setCountryCode(String countryCode) {
        set(PROPERTY_COUNTRYCODE, countryCode);
    }

}
