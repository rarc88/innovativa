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
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
/**
 * Entity class for entity ssct_contract (stored in table ssct_contract).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ssctcontract extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ssct_contract";
    public static final String ENTITY_NAME = "ssct_contract";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_OBJECT = "object";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_AMOUNT = "amount";
    public static final String PROPERTY_CONTRACTTERM = "contractTerm";
    public static final String PROPERTY_ADMINISTRATOR = "administrator";
    public static final String PROPERTY_OBSERVATIONS = "observations";
    public static final String PROPERTY_OUTSTANDINGAMOUNT = "outstandingAmount";
    public static final String PROPERTY_DOCTYPE = "doctype";
    public static final String PROPERTY_CONTRACTTYPE = "contractType";
    public static final String PROPERTY_REFERENCECONTRACT = "referenceContract";
    public static final String PROPERTY_PERCENTAGEADVANCE = "percentageadvance";
    public static final String PROPERTY_CLIENTPROVIDER = "clientProvider";
    public static final String PROPERTY_SSCTADVANCELIST = "ssctAdvanceList";
    public static final String PROPERTY_SSCTCONTRACTREFERENCECONTRACTIDLIST = "ssctContractReferenceContractIDList";
    public static final String PROPERTY_SSCTPAYMENTLIST = "ssctPaymentList";
    public static final String PROPERTY_SSCTWARRANTYLIST = "ssctWarrantyList";

    public ssctcontract() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_AMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_OUTSTANDINGAMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_PERCENTAGEADVANCE, (long) 0);
        setDefaultValue(PROPERTY_SSCTADVANCELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSCTCONTRACTREFERENCECONTRACTIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSCTPAYMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSCTWARRANTYLIST, new ArrayList<Object>());
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

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public String getObject() {
        return (String) get(PROPERTY_OBJECT);
    }

    public void setObject(String object) {
        set(PROPERTY_OBJECT, object);
    }

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public BigDecimal getAmount() {
        return (BigDecimal) get(PROPERTY_AMOUNT);
    }

    public void setAmount(BigDecimal amount) {
        set(PROPERTY_AMOUNT, amount);
    }

    public ssctcontractterm getContractTerm() {
        return (ssctcontractterm) get(PROPERTY_CONTRACTTERM);
    }

    public void setContractTerm(ssctcontractterm contractTerm) {
        set(PROPERTY_CONTRACTTERM, contractTerm);
    }

    public BusinessPartner getAdministrator() {
        return (BusinessPartner) get(PROPERTY_ADMINISTRATOR);
    }

    public void setAdministrator(BusinessPartner administrator) {
        set(PROPERTY_ADMINISTRATOR, administrator);
    }

    public String getObservations() {
        return (String) get(PROPERTY_OBSERVATIONS);
    }

    public void setObservations(String observations) {
        set(PROPERTY_OBSERVATIONS, observations);
    }

    public BigDecimal getOutstandingAmount() {
        return (BigDecimal) get(PROPERTY_OUTSTANDINGAMOUNT);
    }

    public void setOutstandingAmount(BigDecimal outstandingAmount) {
        set(PROPERTY_OUTSTANDINGAMOUNT, outstandingAmount);
    }

    public DocumentType getDoctype() {
        return (DocumentType) get(PROPERTY_DOCTYPE);
    }

    public void setDoctype(DocumentType doctype) {
        set(PROPERTY_DOCTYPE, doctype);
    }

    public SsctContractType getContractType() {
        return (SsctContractType) get(PROPERTY_CONTRACTTYPE);
    }

    public void setContractType(SsctContractType contractType) {
        set(PROPERTY_CONTRACTTYPE, contractType);
    }

    public ssctcontract getReferenceContract() {
        return (ssctcontract) get(PROPERTY_REFERENCECONTRACT);
    }

    public void setReferenceContract(ssctcontract referenceContract) {
        set(PROPERTY_REFERENCECONTRACT, referenceContract);
    }

    public Long getPercentageadvance() {
        return (Long) get(PROPERTY_PERCENTAGEADVANCE);
    }

    public void setPercentageadvance(Long percentageadvance) {
        set(PROPERTY_PERCENTAGEADVANCE, percentageadvance);
    }

    public String getClientProvider() {
        return (String) get(PROPERTY_CLIENTPROVIDER);
    }

    public void setClientProvider(String clientProvider) {
        set(PROPERTY_CLIENTPROVIDER, clientProvider);
    }

    @SuppressWarnings("unchecked")
    public List<ssctadvance> getSsctAdvanceList() {
      return (List<ssctadvance>) get(PROPERTY_SSCTADVANCELIST);
    }

    public void setSsctAdvanceList(List<ssctadvance> ssctAdvanceList) {
        set(PROPERTY_SSCTADVANCELIST, ssctAdvanceList);
    }

    @SuppressWarnings("unchecked")
    public List<ssctcontract> getSsctContractReferenceContractIDList() {
      return (List<ssctcontract>) get(PROPERTY_SSCTCONTRACTREFERENCECONTRACTIDLIST);
    }

    public void setSsctContractReferenceContractIDList(List<ssctcontract> ssctContractReferenceContractIDList) {
        set(PROPERTY_SSCTCONTRACTREFERENCECONTRACTIDLIST, ssctContractReferenceContractIDList);
    }

    @SuppressWarnings("unchecked")
    public List<ssctpayment> getSsctPaymentList() {
      return (List<ssctpayment>) get(PROPERTY_SSCTPAYMENTLIST);
    }

    public void setSsctPaymentList(List<ssctpayment> ssctPaymentList) {
        set(PROPERTY_SSCTPAYMENTLIST, ssctPaymentList);
    }

    @SuppressWarnings("unchecked")
    public List<ssctwarranty> getSsctWarrantyList() {
      return (List<ssctwarranty>) get(PROPERTY_SSCTWARRANTYLIST);
    }

    public void setSsctWarrantyList(List<ssctwarranty> ssctWarrantyList) {
        set(PROPERTY_SSCTWARRANTYLIST, ssctWarrantyList);
    }

}
