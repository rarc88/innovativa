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
package com.sidesoft.flopec;

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
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.accounting.UserDimension2;
/**
 * Entity class for entity ssfl_recap (stored in table ssfl_recap).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ssflRecap extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ssfl_recap";
    public static final String ENTITY_NAME = "ssfl_recap";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_COMMENTMARITIME = "commentMaritime";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_CONTRACTDATE = "contractDate";
    public static final String PROPERTY_COSTCENTER = "costCenter";
    public static final String PROPERTY_SSFLFAREA = "ssflFareA";
    public static final String PROPERTY_SSFLFAREB = "ssflFareB";
    public static final String PROPERTY_SSFLWSCONTRACT = "ssflWsContract";
    public static final String PROPERTY_SSFLWSCONTRACTB = "ssflWsContractB";
    public static final String PROPERTY_OWNER = "owner";
    public static final String PROPERTY_COMMERCIALNAME = "commercialName";
    public static final String PROPERTY_SEARCHKEY = "searchKey";
    public static final String PROPERTY_FAREA = "fareA";
    public static final String PROPERTY_FAREB = "fareB";
    public static final String PROPERTY_CONTRACTA = "contractA";
    public static final String PROPERTY_CONTRACTB = "contractB";
    public static final String PROPERTY_PRINTTYPERECAP = "printTypeRecap";
    public static final String PROPERTY_DESCRIPTIONAG = "descriptionAg";
    public static final String PROPERTY_DESCRIPTIONREM = "descriptionRem";
    public static final String PROPERTY_USERDIMENSION2EMSSFLVALUERECAP1LIST = "userDimension2EMSsflValuerecap1List";
    public static final String PROPERTY_USERDIMENSION2EMSSFLVALUERECAP2LIST = "userDimension2EMSsflValuerecap2List";
    public static final String PROPERTY_USERDIMENSION2EMSSFLVALUERECAP3LIST = "userDimension2EMSsflValuerecap3List";
    public static final String PROPERTY_SSFLINVOICEVOYAGERECAPIDLIST = "ssflInvoiceVoyageRecapIDList";

    public ssflRecap() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_PRINTTYPERECAP, "1");
        setDefaultValue(PROPERTY_USERDIMENSION2EMSSFLVALUERECAP1LIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_USERDIMENSION2EMSSFLVALUERECAP2LIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_USERDIMENSION2EMSSFLVALUERECAP3LIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSFLINVOICEVOYAGERECAPIDLIST, new ArrayList<Object>());
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

    public Date getUpdated() {
        return (Date) get(PROPERTY_UPDATED);
    }

    public void setUpdated(Date updated) {
        set(PROPERTY_UPDATED, updated);
    }

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
    }

    public String getCommentMaritime() {
        return (String) get(PROPERTY_COMMENTMARITIME);
    }

    public void setCommentMaritime(String commentMaritime) {
        set(PROPERTY_COMMENTMARITIME, commentMaritime);
    }

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public Date getContractDate() {
        return (Date) get(PROPERTY_CONTRACTDATE);
    }

    public void setContractDate(Date contractDate) {
        set(PROPERTY_CONTRACTDATE, contractDate);
    }

    public Costcenter getCostCenter() {
        return (Costcenter) get(PROPERTY_COSTCENTER);
    }

    public void setCostCenter(Costcenter costCenter) {
        set(PROPERTY_COSTCENTER, costCenter);
    }

    public ssflFare_A getSsflFareA() {
        return (ssflFare_A) get(PROPERTY_SSFLFAREA);
    }

    public void setSsflFareA(ssflFare_A ssflFareA) {
        set(PROPERTY_SSFLFAREA, ssflFareA);
    }

    public ssflFare_B getSsflFareB() {
        return (ssflFare_B) get(PROPERTY_SSFLFAREB);
    }

    public void setSsflFareB(ssflFare_B ssflFareB) {
        set(PROPERTY_SSFLFAREB, ssflFareB);
    }

    public ssflWs_contract getSsflWsContract() {
        return (ssflWs_contract) get(PROPERTY_SSFLWSCONTRACT);
    }

    public void setSsflWsContract(ssflWs_contract ssflWsContract) {
        set(PROPERTY_SSFLWSCONTRACT, ssflWsContract);
    }

    public ssflWs_contract_B getSsflWsContractB() {
        return (ssflWs_contract_B) get(PROPERTY_SSFLWSCONTRACTB);
    }

    public void setSsflWsContractB(ssflWs_contract_B ssflWsContractB) {
        set(PROPERTY_SSFLWSCONTRACTB, ssflWsContractB);
    }

    public BusinessPartner getOwner() {
        return (BusinessPartner) get(PROPERTY_OWNER);
    }

    public void setOwner(BusinessPartner owner) {
        set(PROPERTY_OWNER, owner);
    }

    public String getCommercialName() {
        return (String) get(PROPERTY_COMMERCIALNAME);
    }

    public void setCommercialName(String commercialName) {
        set(PROPERTY_COMMERCIALNAME, commercialName);
    }

    public String getSearchKey() {
        return (String) get(PROPERTY_SEARCHKEY);
    }

    public void setSearchKey(String searchKey) {
        set(PROPERTY_SEARCHKEY, searchKey);
    }

    public BigDecimal getFareA() {
        return (BigDecimal) get(PROPERTY_FAREA);
    }

    public void setFareA(BigDecimal fareA) {
        set(PROPERTY_FAREA, fareA);
    }

    public BigDecimal getFareB() {
        return (BigDecimal) get(PROPERTY_FAREB);
    }

    public void setFareB(BigDecimal fareB) {
        set(PROPERTY_FAREB, fareB);
    }

    public String getContractA() {
        return (String) get(PROPERTY_CONTRACTA);
    }

    public void setContractA(String contractA) {
        set(PROPERTY_CONTRACTA, contractA);
    }

    public String getContractB() {
        return (String) get(PROPERTY_CONTRACTB);
    }

    public void setContractB(String contractB) {
        set(PROPERTY_CONTRACTB, contractB);
    }

    public String getPrintTypeRecap() {
        return (String) get(PROPERTY_PRINTTYPERECAP);
    }

    public void setPrintTypeRecap(String printTypeRecap) {
        set(PROPERTY_PRINTTYPERECAP, printTypeRecap);
    }

    public String getDescriptionAg() {
        return (String) get(PROPERTY_DESCRIPTIONAG);
    }

    public void setDescriptionAg(String descriptionAg) {
        set(PROPERTY_DESCRIPTIONAG, descriptionAg);
    }

    public String getDescriptionRem() {
        return (String) get(PROPERTY_DESCRIPTIONREM);
    }

    public void setDescriptionRem(String descriptionRem) {
        set(PROPERTY_DESCRIPTIONREM, descriptionRem);
    }

    @SuppressWarnings("unchecked")
    public List<UserDimension2> getUserDimension2EMSsflValuerecap1List() {
      return (List<UserDimension2>) get(PROPERTY_USERDIMENSION2EMSSFLVALUERECAP1LIST);
    }

    public void setUserDimension2EMSsflValuerecap1List(List<UserDimension2> userDimension2EMSsflValuerecap1List) {
        set(PROPERTY_USERDIMENSION2EMSSFLVALUERECAP1LIST, userDimension2EMSsflValuerecap1List);
    }

    @SuppressWarnings("unchecked")
    public List<UserDimension2> getUserDimension2EMSsflValuerecap2List() {
      return (List<UserDimension2>) get(PROPERTY_USERDIMENSION2EMSSFLVALUERECAP2LIST);
    }

    public void setUserDimension2EMSsflValuerecap2List(List<UserDimension2> userDimension2EMSsflValuerecap2List) {
        set(PROPERTY_USERDIMENSION2EMSSFLVALUERECAP2LIST, userDimension2EMSsflValuerecap2List);
    }

    @SuppressWarnings("unchecked")
    public List<UserDimension2> getUserDimension2EMSsflValuerecap3List() {
      return (List<UserDimension2>) get(PROPERTY_USERDIMENSION2EMSSFLVALUERECAP3LIST);
    }

    public void setUserDimension2EMSsflValuerecap3List(List<UserDimension2> userDimension2EMSsflValuerecap3List) {
        set(PROPERTY_USERDIMENSION2EMSSFLVALUERECAP3LIST, userDimension2EMSsflValuerecap3List);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceVoyage> getSsflInvoiceVoyageRecapIDList() {
      return (List<InvoiceVoyage>) get(PROPERTY_SSFLINVOICEVOYAGERECAPIDLIST);
    }

    public void setSsflInvoiceVoyageRecapIDList(List<InvoiceVoyage> ssflInvoiceVoyageRecapIDList) {
        set(PROPERTY_SSFLINVOICEVOYAGERECAPIDLIST, ssflInvoiceVoyageRecapIDList);
    }

}
