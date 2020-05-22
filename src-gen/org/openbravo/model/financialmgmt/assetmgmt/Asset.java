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
package org.openbravo.model.financialmgmt.assetmgmt;

import com.sidesoft.ecuador.asset.allocation.SsalApplActive;
import com.sidesoft.ecuador.asset.allocation.ssalassetcom;
import com.sidesoft.ecuador.asset.allocation.ssalassetreturnline;
import com.sidesoft.ecuador.asset.allocation.ssalmark;
import com.sidesoft.ecuador.asset.allocation.ssalmodel;
import com.sidesoft.ecuador.asset.allocation.ssalstateasset;
import com.sidesoft.ecuador.asset.move.ssamalienate;
import com.sidesoft.ecuador.asset.move.ssamalienateline;
import com.sidesoft.flopec.budget.data.SFBBudgetCertLine;
import com.sidesoft.flopec.budget.data.SFBBudgetItem;

import ec.com.sidesoft.secondary.accounting.AccountingFactSecondary;
import ec.com.sidesoft.secondary.accounting.SSACCTJOURNAL;
import ec.com.sidesoft.secondary.accounting.SSACCTJournalLine;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openbravo.advpaymentmngt.APRM_Finacc_Trx_Full_Acct_V;
import org.openbravo.advpaymentmngt.FinAccTransactionAccounting;
import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.businesspartner.Location;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Locator;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.common.invoice.InvoiceLine;
import org.openbravo.model.common.invoice.InvoiceLineAccountingDimension;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.common.order.OrderLine;
import org.openbravo.model.common.order.OrderLineAccountingDimension;
import org.openbravo.model.common.plm.AttributeSetInstance;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.financialmgmt.accounting.AccountingFact;
import org.openbravo.model.financialmgmt.accounting.BudgetLine;
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.accounting.UserDimension1;
import org.openbravo.model.financialmgmt.accounting.UserDimension2;
import org.openbravo.model.financialmgmt.gl.GLJournal;
import org.openbravo.model.financialmgmt.gl.GLJournalLine;
import org.openbravo.model.financialmgmt.payment.DoubtfulDebt;
import org.openbravo.model.materialmgmt.transaction.InOutLineAccountingDimension;
import org.openbravo.model.materialmgmt.transaction.InternalMovement;
import org.openbravo.model.materialmgmt.transaction.InventoryCount;
import org.openbravo.model.materialmgmt.transaction.ProductionTransaction;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOut;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOutLine;
import org.openbravo.model.project.Project;
import org.openbravo.model.timeandexpense.Sheet;
import org.openbravo.model.timeandexpense.SheetLine;
/**
 * Entity class for entity FinancialMgmtAsset (stored in table A_Asset).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Asset extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "A_Asset";
    public static final String ENTITY_NAME = "FinancialMgmtAsset";
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
    public static final String PROPERTY_HELPCOMMENT = "helpComment";
    public static final String PROPERTY_ASSETCATEGORY = "assetCategory";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_SERIALNO = "serialNo";
    public static final String PROPERTY_LOTNAME = "lotName";
    public static final String PROPERTY_VERSIONNO = "versionNo";
    public static final String PROPERTY_EXPIRATIONDATE = "expirationDate";
    public static final String PROPERTY_INSERVICEDATE = "inServiceDate";
    public static final String PROPERTY_OWNED = "owned";
    public static final String PROPERTY_ASSETDEPRECIATIONDATE = "assetDepreciationDate";
    public static final String PROPERTY_USABLELIFEYEARS = "usableLifeYears";
    public static final String PROPERTY_USABLELIFEMONTHS = "usableLifeMonths";
    public static final String PROPERTY_LIFEUSE = "lifeUse";
    public static final String PROPERTY_USEUNITS = "useUnits";
    public static final String PROPERTY_DISPOSED = "disposed";
    public static final String PROPERTY_ASSETDISPOSALDATE = "assetDisposalDate";
    public static final String PROPERTY_INPOSSESSION = "inPossession";
    public static final String PROPERTY_LOCATIONCOMMENT = "locationComment";
    public static final String PROPERTY_STORAGEBIN = "storageBin";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_PARTNERADDRESS = "partnerAddress";
    public static final String PROPERTY_LOCATIONADDRESS = "locationAddress";
    public static final String PROPERTY_PROCESSNOW = "processNow";
    public static final String PROPERTY_DEPRECIATE = "depreciate";
    public static final String PROPERTY_FULLYDEPRECIATED = "fullyDepreciated";
    public static final String PROPERTY_USERCONTACT = "userContact";
    public static final String PROPERTY_DEPRECIATIONENDDATE = "depreciationEndDate";
    public static final String PROPERTY_DEPRECIATIONSTARTDATE = "depreciationStartDate";
    public static final String PROPERTY_ANNUALDEPRECIATION = "annualDepreciation";
    public static final String PROPERTY_ASSETVALUE = "assetValue";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_CANCELLATIONDATE = "cancellationDate";
    public static final String PROPERTY_PURCHASEDATE = "purchaseDate";
    public static final String PROPERTY_ATTRIBUTESETVALUE = "attributeSetValue";
    public static final String PROPERTY_RESIDUALASSETVALUE = "residualAssetValue";
    public static final String PROPERTY_ACCTVALUEAMT = "acctvalueamt";
    public static final String PROPERTY_DEPRECIATIONTYPE = "depreciationType";
    public static final String PROPERTY_DEPRECIATIONAMT = "depreciationAmt";
    public static final String PROPERTY_AMORTIZE = "amortize";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_PROFIT = "profit";
    public static final String PROPERTY_QUANTITY = "quantity";
    public static final String PROPERTY_CALCULATETYPE = "calculateType";
    public static final String PROPERTY_DEPRECIATEDPLAN = "depreciatedPlan";
    public static final String PROPERTY_PREVIOUSLYDEPRECIATEDAMT = "previouslyDepreciatedAmt";
    public static final String PROPERTY_DEPRECIATEDVALUE = "depreciatedValue";
    public static final String PROPERTY_SUMMARYLEVEL = "summaryLevel";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_STATIC = "static";
    public static final String PROPERTY_EVERYMONTHIS30DAYS = "everyMonthIs30Days";
    public static final String PROPERTY_SSALCDOCTYPE = "ssalCDoctype";
    public static final String PROPERTY_SSALDESCRIPTIONCH = "ssalDescriptionCh";
    public static final String PROPERTY_SSALVESSEL = "sSALVessel";
    public static final String PROPERTY_PROCESSASSET = "processAsset";
    public static final String PROPERTY_SSALMARK = "ssalMark";
    public static final String PROPERTY_SSALMODEL = "ssalModel";
    public static final String PROPERTY_SSALISAVAILABLE = "ssalIsavailable";
    public static final String PROPERTY_SSALSERIES = "ssalSeries";
    public static final String PROPERTY_SSALCUSTODIO = "ssalCustodio";
    public static final String PROPERTY_SSALBARCODE = "ssalBarCode";
    public static final String PROPERTY_SSALSTATEASSET = "ssalStateAsset";
    public static final String PROPERTY_SFBBUDGETITEM = "sfbBudgetItem";
    public static final String PROPERTY_SSAMALIENATED = "ssamAlienated";
    public static final String PROPERTY_SSAMSTATUS = "ssamStatus";
    public static final String PROPERTY_SSAMINVOICED = "ssamInvoiced";
    public static final String PROPERTY_SSALLOWREASON = "ssalLowreason";
    public static final String PROPERTY_SSAMCBPARTNER = "ssamCBpartner";
    public static final String PROPERTY_SSALLOWDATE = "ssalLowdate";
    public static final String PROPERTY_SSAMTAXID = "ssamTaxid";
    public static final String PROPERTY_SSALLOWPROCESS = "ssalLowprocess";
    public static final String PROPERTY_SSAMNETWORTH = "ssamNetWorth";
    public static final String PROPERTY_SSALLOWSTATUS = "ssalLowstatus";
    public static final String PROPERTY_SSAMMODEL = "ssamModel";
    public static final String PROPERTY_SSAMSERIE = "ssamSerie";
    public static final String PROPERTY_SSAMBRAND = "ssamBrand";
    public static final String PROPERTY_SSAMREPLACEMENTVALUE = "ssamReplacementValue";
    public static final String PROPERTY_SSAMCONDITION = "ssamCondition";
    public static final String PROPERTY_SSAMASSETTYPE = "ssamAssettype";
    public static final String PROPERTY_SSAMALIENATELINE = "ssamAlienateline";
    public static final String PROPERTY_SSAMSTATUSDEP = "ssamStatusdep";
    public static final String PROPERTY_SSAMCHANGEOFVALUE = "ssamChangeofvalue";
    public static final String PROPERTY_SSAMTYPEOFCHANGE = "ssamTypeofchange";
    public static final String PROPERTY_SSAMOBSERVATIONS = "ssamObservations";
    public static final String PROPERTY_STDIMENSION = "stDimension";
    public static final String PROPERTY_NDDIMENSION = "ndDimension";
    public static final String PROPERTY_COSTCENTER = "costcenter";
    public static final String PROPERTY_APRMFINACCTRANSACTIONACCTVLIST = "aPRMFinAccTransactionAcctVList";
    public static final String PROPERTY_APRMFINACCTRXFULLACCTVLIST = "aPRMFinaccTrxFullAcctVList";
    public static final String PROPERTY_AMORTIZATIONLINEACCOUNTINGDIMENSIONLIST = "amortizationLineAccountingDimensionList";
    public static final String PROPERTY_FINDOUBTFULDEBTLIST = "fINDoubtfulDebtList";
    public static final String PROPERTY_FINANCIALMGMTACCOUNTINGFACTLIST = "financialMgmtAccountingFactList";
    public static final String PROPERTY_FINANCIALMGMTAMORTIZATIONLINELIST = "financialMgmtAmortizationLineList";
    public static final String PROPERTY_FINANCIALMGMTASSETEMSSAMCBPARTNERIDLIST = "financialMgmtAssetEMSsamCBpartnerIDList";
    public static final String PROPERTY_FINANCIALMGMTASSETACCOUNTSLIST = "financialMgmtAssetAccountsList";
    public static final String PROPERTY_FINANCIALMGMTBUDGETLINELIST = "financialMgmtBudgetLineList";
    public static final String PROPERTY_FINANCIALMGMTGLJOURNALLIST = "financialMgmtGLJournalList";
    public static final String PROPERTY_FINANCIALMGMTGLJOURNALLINELIST = "financialMgmtGLJournalLineList";
    public static final String PROPERTY_INOUTLINEACCOUNTINGDIMENSIONLIST = "inOutLineAccountingDimensionList";
    public static final String PROPERTY_INVOICELIST = "invoiceList";
    public static final String PROPERTY_INVOICELINELIST = "invoiceLineList";
    public static final String PROPERTY_INVOICELINEEMSSAMAASSETIDLIST = "invoiceLineEMSsamAAssetIDList";
    public static final String PROPERTY_INVOICELINEACCOUNTINGDIMENSIONLIST = "invoiceLineAccountingDimensionList";
    public static final String PROPERTY_MATERIALMGMTINTERNALMOVEMENTLIST = "materialMgmtInternalMovementList";
    public static final String PROPERTY_MATERIALMGMTINVENTORYCOUNTLIST = "materialMgmtInventoryCountList";
    public static final String PROPERTY_MATERIALMGMTPRODUCTIONTRANSACTIONLIST = "materialMgmtProductionTransactionList";
    public static final String PROPERTY_MATERIALMGMTSHIPMENTINOUTLIST = "materialMgmtShipmentInOutList";
    public static final String PROPERTY_MATERIALMGMTSHIPMENTINOUTLINELIST = "materialMgmtShipmentInOutLineList";
    public static final String PROPERTY_ORDERLIST = "orderList";
    public static final String PROPERTY_ORDERLINELIST = "orderLineList";
    public static final String PROPERTY_ORDERLINEACCOUNTINGDIMENSIONLIST = "orderLineAccountingDimensionList";
    public static final String PROPERTY_SSACCTACCOUNTINGFACTSECONDARYLIST = "sSACCTAccountingFactSecondaryList";
    public static final String PROPERTY_SSACCTJOURNALLIST = "sSACCTJOURNALList";
    public static final String PROPERTY_SSACCTJOURNALLINELIST = "sSACCTJournalLineList";
    public static final String PROPERTY_TIMEANDEXPENSESHEETLIST = "timeAndExpenseSheetList";
    public static final String PROPERTY_TIMEANDEXPENSESHEETLINELIST = "timeAndExpenseSheetLineList";
    public static final String PROPERTY_SFBBUDGETCERTLINELIST = "sfbBudgetCertLineList";
    public static final String PROPERTY_SSALAPPLACTIVELIST = "ssalApplActiveList";
    public static final String PROPERTY_SSALAPPLACTIVEAASSETCODIDLIST = "ssalApplActiveAAssetCodIDList";
    public static final String PROPERTY_SSALAPPLACTIVEUPCEANLIST = "ssalApplActiveUPCEANList";
    public static final String PROPERTY_SSALAPPLACTIVEDESCRIPTIONACTIVELIST = "ssalApplActiveDescriptionActiveList";
    public static final String PROPERTY_SSALASSETCOMLIST = "ssalAssetComList";
    public static final String PROPERTY_SSALASSETRETURNLINECDIGOACTIVOLIST = "ssalAssetReturnlineCdigoActivoList";
    public static final String PROPERTY_SSALASSETRETURNLINEUPCEANLIST = "ssalAssetReturnlineUPCEANList";
    public static final String PROPERTY_SSALASSETRETURNLINEDESCRIPTIONACTIVELIST = "ssalAssetReturnlineDescriptionActiveList";
    public static final String PROPERTY_SSAMALIENATEAASSETSTARTIDLIST = "ssamAlienateAAssetstartIDList";
    public static final String PROPERTY_SSAMALIENATEAASSETENDIDLIST = "ssamAlienateAAssetendIDList";
    public static final String PROPERTY_SSAMALIENATELINELIST = "ssamAlienatelineList";

    public Asset() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_OWNED, false);
        setDefaultValue(PROPERTY_DISPOSED, false);
        setDefaultValue(PROPERTY_INPOSSESSION, false);
        setDefaultValue(PROPERTY_PROCESSNOW, false);
        setDefaultValue(PROPERTY_DEPRECIATE, false);
        setDefaultValue(PROPERTY_FULLYDEPRECIATED, false);
        setDefaultValue(PROPERTY_PROCESSED, "N");
        setDefaultValue(PROPERTY_DEPRECIATEDPLAN, new BigDecimal(0));
        setDefaultValue(PROPERTY_PREVIOUSLYDEPRECIATEDAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_DEPRECIATEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_SUMMARYLEVEL, false);
        setDefaultValue(PROPERTY_STATIC, false);
        setDefaultValue(PROPERTY_EVERYMONTHIS30DAYS, true);
        setDefaultValue(PROPERTY_SSALVESSEL, false);
        setDefaultValue(PROPERTY_PROCESSASSET, "N");
        setDefaultValue(PROPERTY_SSALISAVAILABLE, true);
        setDefaultValue(PROPERTY_SSAMALIENATED, false);
        setDefaultValue(PROPERTY_SSAMINVOICED, "N");
        setDefaultValue(PROPERTY_SSALLOWPROCESS, false);
        setDefaultValue(PROPERTY_SSAMNETWORTH, new BigDecimal(0));
        setDefaultValue(PROPERTY_SSAMREPLACEMENTVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_SSAMCHANGEOFVALUE, false);
        setDefaultValue(PROPERTY_APRMFINACCTRANSACTIONACCTVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_APRMFINACCTRXFULLACCTVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_AMORTIZATIONLINEACCOUNTINGDIMENSIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINDOUBTFULDEBTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTACCOUNTINGFACTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTAMORTIZATIONLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTASSETEMSSAMCBPARTNERIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTASSETACCOUNTSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTBUDGETLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTGLJOURNALLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTGLJOURNALLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INOUTLINEACCOUNTINGDIMENSIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELINEEMSSAMAASSETIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELINEACCOUNTINGDIMENSIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTINTERNALMOVEMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTINVENTORYCOUNTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTPRODUCTIONTRANSACTIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTSHIPMENTINOUTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTSHIPMENTINOUTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERLINEACCOUNTINGDIMENSIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSACCTACCOUNTINGFACTSECONDARYLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSACCTJOURNALLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSACCTJOURNALLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_TIMEANDEXPENSESHEETLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_TIMEANDEXPENSESHEETLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETCERTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALAPPLACTIVELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALAPPLACTIVEAASSETCODIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALAPPLACTIVEUPCEANLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALAPPLACTIVEDESCRIPTIONACTIVELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALASSETCOMLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALASSETRETURNLINECDIGOACTIVOLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALASSETRETURNLINEUPCEANLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALASSETRETURNLINEDESCRIPTIONACTIVELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSAMALIENATEAASSETSTARTIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSAMALIENATEAASSETENDIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSAMALIENATELINELIST, new ArrayList<Object>());
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

    public String getHelpComment() {
        return (String) get(PROPERTY_HELPCOMMENT);
    }

    public void setHelpComment(String helpComment) {
        set(PROPERTY_HELPCOMMENT, helpComment);
    }

    public AssetGroup getAssetCategory() {
        return (AssetGroup) get(PROPERTY_ASSETCATEGORY);
    }

    public void setAssetCategory(AssetGroup assetCategory) {
        set(PROPERTY_ASSETCATEGORY, assetCategory);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public String getSerialNo() {
        return (String) get(PROPERTY_SERIALNO);
    }

    public void setSerialNo(String serialNo) {
        set(PROPERTY_SERIALNO, serialNo);
    }

    public String getLotName() {
        return (String) get(PROPERTY_LOTNAME);
    }

    public void setLotName(String lotName) {
        set(PROPERTY_LOTNAME, lotName);
    }

    public String getVersionNo() {
        return (String) get(PROPERTY_VERSIONNO);
    }

    public void setVersionNo(String versionNo) {
        set(PROPERTY_VERSIONNO, versionNo);
    }

    public Date getExpirationDate() {
        return (Date) get(PROPERTY_EXPIRATIONDATE);
    }

    public void setExpirationDate(Date expirationDate) {
        set(PROPERTY_EXPIRATIONDATE, expirationDate);
    }

    public Date getInServiceDate() {
        return (Date) get(PROPERTY_INSERVICEDATE);
    }

    public void setInServiceDate(Date inServiceDate) {
        set(PROPERTY_INSERVICEDATE, inServiceDate);
    }

    public Boolean isOwned() {
        return (Boolean) get(PROPERTY_OWNED);
    }

    public void setOwned(Boolean owned) {
        set(PROPERTY_OWNED, owned);
    }

    public Date getAssetDepreciationDate() {
        return (Date) get(PROPERTY_ASSETDEPRECIATIONDATE);
    }

    public void setAssetDepreciationDate(Date assetDepreciationDate) {
        set(PROPERTY_ASSETDEPRECIATIONDATE, assetDepreciationDate);
    }

    public Long getUsableLifeYears() {
        return (Long) get(PROPERTY_USABLELIFEYEARS);
    }

    public void setUsableLifeYears(Long usableLifeYears) {
        set(PROPERTY_USABLELIFEYEARS, usableLifeYears);
    }

    public Long getUsableLifeMonths() {
        return (Long) get(PROPERTY_USABLELIFEMONTHS);
    }

    public void setUsableLifeMonths(Long usableLifeMonths) {
        set(PROPERTY_USABLELIFEMONTHS, usableLifeMonths);
    }

    public Long getLifeUse() {
        return (Long) get(PROPERTY_LIFEUSE);
    }

    public void setLifeUse(Long lifeUse) {
        set(PROPERTY_LIFEUSE, lifeUse);
    }

    public Long getUseUnits() {
        return (Long) get(PROPERTY_USEUNITS);
    }

    public void setUseUnits(Long useUnits) {
        set(PROPERTY_USEUNITS, useUnits);
    }

    public Boolean isDisposed() {
        return (Boolean) get(PROPERTY_DISPOSED);
    }

    public void setDisposed(Boolean disposed) {
        set(PROPERTY_DISPOSED, disposed);
    }

    public Date getAssetDisposalDate() {
        return (Date) get(PROPERTY_ASSETDISPOSALDATE);
    }

    public void setAssetDisposalDate(Date assetDisposalDate) {
        set(PROPERTY_ASSETDISPOSALDATE, assetDisposalDate);
    }

    public Boolean isInPossession() {
        return (Boolean) get(PROPERTY_INPOSSESSION);
    }

    public void setInPossession(Boolean inPossession) {
        set(PROPERTY_INPOSSESSION, inPossession);
    }

    public String getLocationComment() {
        return (String) get(PROPERTY_LOCATIONCOMMENT);
    }

    public void setLocationComment(String locationComment) {
        set(PROPERTY_LOCATIONCOMMENT, locationComment);
    }

    public Locator getStorageBin() {
        return (Locator) get(PROPERTY_STORAGEBIN);
    }

    public void setStorageBin(Locator storageBin) {
        set(PROPERTY_STORAGEBIN, storageBin);
    }

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public Location getPartnerAddress() {
        return (Location) get(PROPERTY_PARTNERADDRESS);
    }

    public void setPartnerAddress(Location partnerAddress) {
        set(PROPERTY_PARTNERADDRESS, partnerAddress);
    }

    public org.openbravo.model.common.geography.Location getLocationAddress() {
        return (org.openbravo.model.common.geography.Location) get(PROPERTY_LOCATIONADDRESS);
    }

    public void setLocationAddress(org.openbravo.model.common.geography.Location locationAddress) {
        set(PROPERTY_LOCATIONADDRESS, locationAddress);
    }

    public Boolean isProcessNow() {
        return (Boolean) get(PROPERTY_PROCESSNOW);
    }

    public void setProcessNow(Boolean processNow) {
        set(PROPERTY_PROCESSNOW, processNow);
    }

    public Boolean isDepreciate() {
        return (Boolean) get(PROPERTY_DEPRECIATE);
    }

    public void setDepreciate(Boolean depreciate) {
        set(PROPERTY_DEPRECIATE, depreciate);
    }

    public Boolean isFullyDepreciated() {
        return (Boolean) get(PROPERTY_FULLYDEPRECIATED);
    }

    public void setFullyDepreciated(Boolean fullyDepreciated) {
        set(PROPERTY_FULLYDEPRECIATED, fullyDepreciated);
    }

    public User getUserContact() {
        return (User) get(PROPERTY_USERCONTACT);
    }

    public void setUserContact(User userContact) {
        set(PROPERTY_USERCONTACT, userContact);
    }

    public Date getDepreciationEndDate() {
        return (Date) get(PROPERTY_DEPRECIATIONENDDATE);
    }

    public void setDepreciationEndDate(Date depreciationEndDate) {
        set(PROPERTY_DEPRECIATIONENDDATE, depreciationEndDate);
    }

    public Date getDepreciationStartDate() {
        return (Date) get(PROPERTY_DEPRECIATIONSTARTDATE);
    }

    public void setDepreciationStartDate(Date depreciationStartDate) {
        set(PROPERTY_DEPRECIATIONSTARTDATE, depreciationStartDate);
    }

    public BigDecimal getAnnualDepreciation() {
        return (BigDecimal) get(PROPERTY_ANNUALDEPRECIATION);
    }

    public void setAnnualDepreciation(BigDecimal annualDepreciation) {
        set(PROPERTY_ANNUALDEPRECIATION, annualDepreciation);
    }

    public BigDecimal getAssetValue() {
        return (BigDecimal) get(PROPERTY_ASSETVALUE);
    }

    public void setAssetValue(BigDecimal assetValue) {
        set(PROPERTY_ASSETVALUE, assetValue);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public Date getCancellationDate() {
        return (Date) get(PROPERTY_CANCELLATIONDATE);
    }

    public void setCancellationDate(Date cancellationDate) {
        set(PROPERTY_CANCELLATIONDATE, cancellationDate);
    }

    public Date getPurchaseDate() {
        return (Date) get(PROPERTY_PURCHASEDATE);
    }

    public void setPurchaseDate(Date purchaseDate) {
        set(PROPERTY_PURCHASEDATE, purchaseDate);
    }

    public AttributeSetInstance getAttributeSetValue() {
        return (AttributeSetInstance) get(PROPERTY_ATTRIBUTESETVALUE);
    }

    public void setAttributeSetValue(AttributeSetInstance attributeSetValue) {
        set(PROPERTY_ATTRIBUTESETVALUE, attributeSetValue);
    }

    public BigDecimal getResidualAssetValue() {
        return (BigDecimal) get(PROPERTY_RESIDUALASSETVALUE);
    }

    public void setResidualAssetValue(BigDecimal residualAssetValue) {
        set(PROPERTY_RESIDUALASSETVALUE, residualAssetValue);
    }

    public BigDecimal getAcctvalueamt() {
        return (BigDecimal) get(PROPERTY_ACCTVALUEAMT);
    }

    public void setAcctvalueamt(BigDecimal acctvalueamt) {
        set(PROPERTY_ACCTVALUEAMT, acctvalueamt);
    }

    public String getDepreciationType() {
        return (String) get(PROPERTY_DEPRECIATIONTYPE);
    }

    public void setDepreciationType(String depreciationType) {
        set(PROPERTY_DEPRECIATIONTYPE, depreciationType);
    }

    public BigDecimal getDepreciationAmt() {
        return (BigDecimal) get(PROPERTY_DEPRECIATIONAMT);
    }

    public void setDepreciationAmt(BigDecimal depreciationAmt) {
        set(PROPERTY_DEPRECIATIONAMT, depreciationAmt);
    }

    public String getAmortize() {
        return (String) get(PROPERTY_AMORTIZE);
    }

    public void setAmortize(String amortize) {
        set(PROPERTY_AMORTIZE, amortize);
    }

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

    public String getProcessed() {
        return (String) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(String processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public BigDecimal getProfit() {
        return (BigDecimal) get(PROPERTY_PROFIT);
    }

    public void setProfit(BigDecimal profit) {
        set(PROPERTY_PROFIT, profit);
    }

    public BigDecimal getQuantity() {
        return (BigDecimal) get(PROPERTY_QUANTITY);
    }

    public void setQuantity(BigDecimal quantity) {
        set(PROPERTY_QUANTITY, quantity);
    }

    public String getCalculateType() {
        return (String) get(PROPERTY_CALCULATETYPE);
    }

    public void setCalculateType(String calculateType) {
        set(PROPERTY_CALCULATETYPE, calculateType);
    }

    public BigDecimal getDepreciatedPlan() {
        return (BigDecimal) get(PROPERTY_DEPRECIATEDPLAN);
    }

    public void setDepreciatedPlan(BigDecimal depreciatedPlan) {
        set(PROPERTY_DEPRECIATEDPLAN, depreciatedPlan);
    }

    public BigDecimal getPreviouslyDepreciatedAmt() {
        return (BigDecimal) get(PROPERTY_PREVIOUSLYDEPRECIATEDAMT);
    }

    public void setPreviouslyDepreciatedAmt(BigDecimal previouslyDepreciatedAmt) {
        set(PROPERTY_PREVIOUSLYDEPRECIATEDAMT, previouslyDepreciatedAmt);
    }

    public BigDecimal getDepreciatedValue() {
        return (BigDecimal) get(PROPERTY_DEPRECIATEDVALUE);
    }

    public void setDepreciatedValue(BigDecimal depreciatedValue) {
        set(PROPERTY_DEPRECIATEDVALUE, depreciatedValue);
    }

    public Boolean isSummaryLevel() {
        return (Boolean) get(PROPERTY_SUMMARYLEVEL);
    }

    public void setSummaryLevel(Boolean summaryLevel) {
        set(PROPERTY_SUMMARYLEVEL, summaryLevel);
    }

    public Project getProject() {
        return (Project) get(PROPERTY_PROJECT);
    }

    public void setProject(Project project) {
        set(PROPERTY_PROJECT, project);
    }

    public Boolean isStatic() {
        return (Boolean) get(PROPERTY_STATIC);
    }

    public void setStatic(Boolean statc) {
        set(PROPERTY_STATIC, statc);
    }

    public Boolean isEveryMonthIs30Days() {
        return (Boolean) get(PROPERTY_EVERYMONTHIS30DAYS);
    }

    public void setEveryMonthIs30Days(Boolean everyMonthIs30Days) {
        set(PROPERTY_EVERYMONTHIS30DAYS, everyMonthIs30Days);
    }

    public DocumentType getSsalCDoctype() {
        return (DocumentType) get(PROPERTY_SSALCDOCTYPE);
    }

    public void setSsalCDoctype(DocumentType ssalCDoctype) {
        set(PROPERTY_SSALCDOCTYPE, ssalCDoctype);
    }

    public String getSsalDescriptionCh() {
        return (String) get(PROPERTY_SSALDESCRIPTIONCH);
    }

    public void setSsalDescriptionCh(String ssalDescriptionCh) {
        set(PROPERTY_SSALDESCRIPTIONCH, ssalDescriptionCh);
    }

    public Boolean isSSALVessel() {
        return (Boolean) get(PROPERTY_SSALVESSEL);
    }

    public void setSSALVessel(Boolean sSALVessel) {
        set(PROPERTY_SSALVESSEL, sSALVessel);
    }

    public String getProcessAsset() {
        return (String) get(PROPERTY_PROCESSASSET);
    }

    public void setProcessAsset(String processAsset) {
        set(PROPERTY_PROCESSASSET, processAsset);
    }

    public ssalmark getSsalMark() {
        return (ssalmark) get(PROPERTY_SSALMARK);
    }

    public void setSsalMark(ssalmark ssalMark) {
        set(PROPERTY_SSALMARK, ssalMark);
    }

    public ssalmodel getSsalModel() {
        return (ssalmodel) get(PROPERTY_SSALMODEL);
    }

    public void setSsalModel(ssalmodel ssalModel) {
        set(PROPERTY_SSALMODEL, ssalModel);
    }

    public Boolean isSsalIsavailable() {
        return (Boolean) get(PROPERTY_SSALISAVAILABLE);
    }

    public void setSsalIsavailable(Boolean ssalIsavailable) {
        set(PROPERTY_SSALISAVAILABLE, ssalIsavailable);
    }

    public String getSsalSeries() {
        return (String) get(PROPERTY_SSALSERIES);
    }

    public void setSsalSeries(String ssalSeries) {
        set(PROPERTY_SSALSERIES, ssalSeries);
    }

    public BusinessPartner getSsalCustodio() {
        return (BusinessPartner) get(PROPERTY_SSALCUSTODIO);
    }

    public void setSsalCustodio(BusinessPartner ssalCustodio) {
        set(PROPERTY_SSALCUSTODIO, ssalCustodio);
    }

    public String getSsalBarCode() {
        return (String) get(PROPERTY_SSALBARCODE);
    }

    public void setSsalBarCode(String ssalBarCode) {
        set(PROPERTY_SSALBARCODE, ssalBarCode);
    }

    public ssalstateasset getSsalStateAsset() {
        return (ssalstateasset) get(PROPERTY_SSALSTATEASSET);
    }

    public void setSsalStateAsset(ssalstateasset ssalStateAsset) {
        set(PROPERTY_SSALSTATEASSET, ssalStateAsset);
    }

    public SFBBudgetItem getSfbBudgetItem() {
        return (SFBBudgetItem) get(PROPERTY_SFBBUDGETITEM);
    }

    public void setSfbBudgetItem(SFBBudgetItem sfbBudgetItem) {
        set(PROPERTY_SFBBUDGETITEM, sfbBudgetItem);
    }

    public Boolean isSsamAlienated() {
        return (Boolean) get(PROPERTY_SSAMALIENATED);
    }

    public void setSsamAlienated(Boolean ssamAlienated) {
        set(PROPERTY_SSAMALIENATED, ssamAlienated);
    }

    public String getSsamStatus() {
        return (String) get(PROPERTY_SSAMSTATUS);
    }

    public void setSsamStatus(String ssamStatus) {
        set(PROPERTY_SSAMSTATUS, ssamStatus);
    }

    public String getSsamInvoiced() {
        return (String) get(PROPERTY_SSAMINVOICED);
    }

    public void setSsamInvoiced(String ssamInvoiced) {
        set(PROPERTY_SSAMINVOICED, ssamInvoiced);
    }

    public String getSsalLowreason() {
        return (String) get(PROPERTY_SSALLOWREASON);
    }

    public void setSsalLowreason(String ssalLowreason) {
        set(PROPERTY_SSALLOWREASON, ssalLowreason);
    }

    public Asset getSsamCBpartner() {
        return (Asset) get(PROPERTY_SSAMCBPARTNER);
    }

    public void setSsamCBpartner(Asset ssamCBpartner) {
        set(PROPERTY_SSAMCBPARTNER, ssamCBpartner);
    }

    public Date getSsalLowdate() {
        return (Date) get(PROPERTY_SSALLOWDATE);
    }

    public void setSsalLowdate(Date ssalLowdate) {
        set(PROPERTY_SSALLOWDATE, ssalLowdate);
    }

    public String getSsamTaxid() {
        return (String) get(PROPERTY_SSAMTAXID);
    }

    public void setSsamTaxid(String ssamTaxid) {
        set(PROPERTY_SSAMTAXID, ssamTaxid);
    }

    public Boolean isSsalLowprocess() {
        return (Boolean) get(PROPERTY_SSALLOWPROCESS);
    }

    public void setSsalLowprocess(Boolean ssalLowprocess) {
        set(PROPERTY_SSALLOWPROCESS, ssalLowprocess);
    }

    public BigDecimal getSsamNetWorth() {
        return (BigDecimal) get(PROPERTY_SSAMNETWORTH);
    }

    public void setSsamNetWorth(BigDecimal ssamNetWorth) {
        set(PROPERTY_SSAMNETWORTH, ssamNetWorth);
    }

    public String getSsalLowstatus() {
        return (String) get(PROPERTY_SSALLOWSTATUS);
    }

    public void setSsalLowstatus(String ssalLowstatus) {
        set(PROPERTY_SSALLOWSTATUS, ssalLowstatus);
    }

    public String getSsamModel() {
        return (String) get(PROPERTY_SSAMMODEL);
    }

    public void setSsamModel(String ssamModel) {
        set(PROPERTY_SSAMMODEL, ssamModel);
    }

    public String getSsamSerie() {
        return (String) get(PROPERTY_SSAMSERIE);
    }

    public void setSsamSerie(String ssamSerie) {
        set(PROPERTY_SSAMSERIE, ssamSerie);
    }

    public String getSsamBrand() {
        return (String) get(PROPERTY_SSAMBRAND);
    }

    public void setSsamBrand(String ssamBrand) {
        set(PROPERTY_SSAMBRAND, ssamBrand);
    }

    public BigDecimal getSsamReplacementValue() {
        return (BigDecimal) get(PROPERTY_SSAMREPLACEMENTVALUE);
    }

    public void setSsamReplacementValue(BigDecimal ssamReplacementValue) {
        set(PROPERTY_SSAMREPLACEMENTVALUE, ssamReplacementValue);
    }

    public String getSsamCondition() {
        return (String) get(PROPERTY_SSAMCONDITION);
    }

    public void setSsamCondition(String ssamCondition) {
        set(PROPERTY_SSAMCONDITION, ssamCondition);
    }

    public String getSsamAssettype() {
        return (String) get(PROPERTY_SSAMASSETTYPE);
    }

    public void setSsamAssettype(String ssamAssettype) {
        set(PROPERTY_SSAMASSETTYPE, ssamAssettype);
    }

    public ssamalienateline getSsamAlienateline() {
        return (ssamalienateline) get(PROPERTY_SSAMALIENATELINE);
    }

    public void setSsamAlienateline(ssamalienateline ssamAlienateline) {
        set(PROPERTY_SSAMALIENATELINE, ssamAlienateline);
    }

    public String getSsamStatusdep() {
        return (String) get(PROPERTY_SSAMSTATUSDEP);
    }

    public void setSsamStatusdep(String ssamStatusdep) {
        set(PROPERTY_SSAMSTATUSDEP, ssamStatusdep);
    }

    public Boolean isSsamChangeofvalue() {
        return (Boolean) get(PROPERTY_SSAMCHANGEOFVALUE);
    }

    public void setSsamChangeofvalue(Boolean ssamChangeofvalue) {
        set(PROPERTY_SSAMCHANGEOFVALUE, ssamChangeofvalue);
    }

    public String getSsamTypeofchange() {
        return (String) get(PROPERTY_SSAMTYPEOFCHANGE);
    }

    public void setSsamTypeofchange(String ssamTypeofchange) {
        set(PROPERTY_SSAMTYPEOFCHANGE, ssamTypeofchange);
    }

    public String getSsamObservations() {
        return (String) get(PROPERTY_SSAMOBSERVATIONS);
    }

    public void setSsamObservations(String ssamObservations) {
        set(PROPERTY_SSAMOBSERVATIONS, ssamObservations);
    }

    public UserDimension1 getStDimension() {
        return (UserDimension1) get(PROPERTY_STDIMENSION);
    }

    public void setStDimension(UserDimension1 stDimension) {
        set(PROPERTY_STDIMENSION, stDimension);
    }

    public UserDimension2 getNdDimension() {
        return (UserDimension2) get(PROPERTY_NDDIMENSION);
    }

    public void setNdDimension(UserDimension2 ndDimension) {
        set(PROPERTY_NDDIMENSION, ndDimension);
    }

    public Costcenter getCostcenter() {
        return (Costcenter) get(PROPERTY_COSTCENTER);
    }

    public void setCostcenter(Costcenter costcenter) {
        set(PROPERTY_COSTCENTER, costcenter);
    }

    @SuppressWarnings("unchecked")
    public List<FinAccTransactionAccounting> getAPRMFinAccTransactionAcctVList() {
      return (List<FinAccTransactionAccounting>) get(PROPERTY_APRMFINACCTRANSACTIONACCTVLIST);
    }

    public void setAPRMFinAccTransactionAcctVList(List<FinAccTransactionAccounting> aPRMFinAccTransactionAcctVList) {
        set(PROPERTY_APRMFINACCTRANSACTIONACCTVLIST, aPRMFinAccTransactionAcctVList);
    }

    @SuppressWarnings("unchecked")
    public List<APRM_Finacc_Trx_Full_Acct_V> getAPRMFinaccTrxFullAcctVList() {
      return (List<APRM_Finacc_Trx_Full_Acct_V>) get(PROPERTY_APRMFINACCTRXFULLACCTVLIST);
    }

    public void setAPRMFinaccTrxFullAcctVList(List<APRM_Finacc_Trx_Full_Acct_V> aPRMFinaccTrxFullAcctVList) {
        set(PROPERTY_APRMFINACCTRXFULLACCTVLIST, aPRMFinaccTrxFullAcctVList);
    }

    @SuppressWarnings("unchecked")
    public List<AmortizationLineAccountingDimension> getAmortizationLineAccountingDimensionList() {
      return (List<AmortizationLineAccountingDimension>) get(PROPERTY_AMORTIZATIONLINEACCOUNTINGDIMENSIONLIST);
    }

    public void setAmortizationLineAccountingDimensionList(List<AmortizationLineAccountingDimension> amortizationLineAccountingDimensionList) {
        set(PROPERTY_AMORTIZATIONLINEACCOUNTINGDIMENSIONLIST, amortizationLineAccountingDimensionList);
    }

    @SuppressWarnings("unchecked")
    public List<DoubtfulDebt> getFINDoubtfulDebtList() {
      return (List<DoubtfulDebt>) get(PROPERTY_FINDOUBTFULDEBTLIST);
    }

    public void setFINDoubtfulDebtList(List<DoubtfulDebt> fINDoubtfulDebtList) {
        set(PROPERTY_FINDOUBTFULDEBTLIST, fINDoubtfulDebtList);
    }

    @SuppressWarnings("unchecked")
    public List<AccountingFact> getFinancialMgmtAccountingFactList() {
      return (List<AccountingFact>) get(PROPERTY_FINANCIALMGMTACCOUNTINGFACTLIST);
    }

    public void setFinancialMgmtAccountingFactList(List<AccountingFact> financialMgmtAccountingFactList) {
        set(PROPERTY_FINANCIALMGMTACCOUNTINGFACTLIST, financialMgmtAccountingFactList);
    }

    @SuppressWarnings("unchecked")
    public List<AmortizationLine> getFinancialMgmtAmortizationLineList() {
      return (List<AmortizationLine>) get(PROPERTY_FINANCIALMGMTAMORTIZATIONLINELIST);
    }

    public void setFinancialMgmtAmortizationLineList(List<AmortizationLine> financialMgmtAmortizationLineList) {
        set(PROPERTY_FINANCIALMGMTAMORTIZATIONLINELIST, financialMgmtAmortizationLineList);
    }

    @SuppressWarnings("unchecked")
    public List<Asset> getFinancialMgmtAssetEMSsamCBpartnerIDList() {
      return (List<Asset>) get(PROPERTY_FINANCIALMGMTASSETEMSSAMCBPARTNERIDLIST);
    }

    public void setFinancialMgmtAssetEMSsamCBpartnerIDList(List<Asset> financialMgmtAssetEMSsamCBpartnerIDList) {
        set(PROPERTY_FINANCIALMGMTASSETEMSSAMCBPARTNERIDLIST, financialMgmtAssetEMSsamCBpartnerIDList);
    }

    @SuppressWarnings("unchecked")
    public List<AssetAccounts> getFinancialMgmtAssetAccountsList() {
      return (List<AssetAccounts>) get(PROPERTY_FINANCIALMGMTASSETACCOUNTSLIST);
    }

    public void setFinancialMgmtAssetAccountsList(List<AssetAccounts> financialMgmtAssetAccountsList) {
        set(PROPERTY_FINANCIALMGMTASSETACCOUNTSLIST, financialMgmtAssetAccountsList);
    }

    @SuppressWarnings("unchecked")
    public List<BudgetLine> getFinancialMgmtBudgetLineList() {
      return (List<BudgetLine>) get(PROPERTY_FINANCIALMGMTBUDGETLINELIST);
    }

    public void setFinancialMgmtBudgetLineList(List<BudgetLine> financialMgmtBudgetLineList) {
        set(PROPERTY_FINANCIALMGMTBUDGETLINELIST, financialMgmtBudgetLineList);
    }

    @SuppressWarnings("unchecked")
    public List<GLJournal> getFinancialMgmtGLJournalList() {
      return (List<GLJournal>) get(PROPERTY_FINANCIALMGMTGLJOURNALLIST);
    }

    public void setFinancialMgmtGLJournalList(List<GLJournal> financialMgmtGLJournalList) {
        set(PROPERTY_FINANCIALMGMTGLJOURNALLIST, financialMgmtGLJournalList);
    }

    @SuppressWarnings("unchecked")
    public List<GLJournalLine> getFinancialMgmtGLJournalLineList() {
      return (List<GLJournalLine>) get(PROPERTY_FINANCIALMGMTGLJOURNALLINELIST);
    }

    public void setFinancialMgmtGLJournalLineList(List<GLJournalLine> financialMgmtGLJournalLineList) {
        set(PROPERTY_FINANCIALMGMTGLJOURNALLINELIST, financialMgmtGLJournalLineList);
    }

    @SuppressWarnings("unchecked")
    public List<InOutLineAccountingDimension> getInOutLineAccountingDimensionList() {
      return (List<InOutLineAccountingDimension>) get(PROPERTY_INOUTLINEACCOUNTINGDIMENSIONLIST);
    }

    public void setInOutLineAccountingDimensionList(List<InOutLineAccountingDimension> inOutLineAccountingDimensionList) {
        set(PROPERTY_INOUTLINEACCOUNTINGDIMENSIONLIST, inOutLineAccountingDimensionList);
    }

    @SuppressWarnings("unchecked")
    public List<Invoice> getInvoiceList() {
      return (List<Invoice>) get(PROPERTY_INVOICELIST);
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        set(PROPERTY_INVOICELIST, invoiceList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceLine> getInvoiceLineList() {
      return (List<InvoiceLine>) get(PROPERTY_INVOICELINELIST);
    }

    public void setInvoiceLineList(List<InvoiceLine> invoiceLineList) {
        set(PROPERTY_INVOICELINELIST, invoiceLineList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceLine> getInvoiceLineEMSsamAAssetIDList() {
      return (List<InvoiceLine>) get(PROPERTY_INVOICELINEEMSSAMAASSETIDLIST);
    }

    public void setInvoiceLineEMSsamAAssetIDList(List<InvoiceLine> invoiceLineEMSsamAAssetIDList) {
        set(PROPERTY_INVOICELINEEMSSAMAASSETIDLIST, invoiceLineEMSsamAAssetIDList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceLineAccountingDimension> getInvoiceLineAccountingDimensionList() {
      return (List<InvoiceLineAccountingDimension>) get(PROPERTY_INVOICELINEACCOUNTINGDIMENSIONLIST);
    }

    public void setInvoiceLineAccountingDimensionList(List<InvoiceLineAccountingDimension> invoiceLineAccountingDimensionList) {
        set(PROPERTY_INVOICELINEACCOUNTINGDIMENSIONLIST, invoiceLineAccountingDimensionList);
    }

    @SuppressWarnings("unchecked")
    public List<InternalMovement> getMaterialMgmtInternalMovementList() {
      return (List<InternalMovement>) get(PROPERTY_MATERIALMGMTINTERNALMOVEMENTLIST);
    }

    public void setMaterialMgmtInternalMovementList(List<InternalMovement> materialMgmtInternalMovementList) {
        set(PROPERTY_MATERIALMGMTINTERNALMOVEMENTLIST, materialMgmtInternalMovementList);
    }

    @SuppressWarnings("unchecked")
    public List<InventoryCount> getMaterialMgmtInventoryCountList() {
      return (List<InventoryCount>) get(PROPERTY_MATERIALMGMTINVENTORYCOUNTLIST);
    }

    public void setMaterialMgmtInventoryCountList(List<InventoryCount> materialMgmtInventoryCountList) {
        set(PROPERTY_MATERIALMGMTINVENTORYCOUNTLIST, materialMgmtInventoryCountList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductionTransaction> getMaterialMgmtProductionTransactionList() {
      return (List<ProductionTransaction>) get(PROPERTY_MATERIALMGMTPRODUCTIONTRANSACTIONLIST);
    }

    public void setMaterialMgmtProductionTransactionList(List<ProductionTransaction> materialMgmtProductionTransactionList) {
        set(PROPERTY_MATERIALMGMTPRODUCTIONTRANSACTIONLIST, materialMgmtProductionTransactionList);
    }

    @SuppressWarnings("unchecked")
    public List<ShipmentInOut> getMaterialMgmtShipmentInOutList() {
      return (List<ShipmentInOut>) get(PROPERTY_MATERIALMGMTSHIPMENTINOUTLIST);
    }

    public void setMaterialMgmtShipmentInOutList(List<ShipmentInOut> materialMgmtShipmentInOutList) {
        set(PROPERTY_MATERIALMGMTSHIPMENTINOUTLIST, materialMgmtShipmentInOutList);
    }

    @SuppressWarnings("unchecked")
    public List<ShipmentInOutLine> getMaterialMgmtShipmentInOutLineList() {
      return (List<ShipmentInOutLine>) get(PROPERTY_MATERIALMGMTSHIPMENTINOUTLINELIST);
    }

    public void setMaterialMgmtShipmentInOutLineList(List<ShipmentInOutLine> materialMgmtShipmentInOutLineList) {
        set(PROPERTY_MATERIALMGMTSHIPMENTINOUTLINELIST, materialMgmtShipmentInOutLineList);
    }

    @SuppressWarnings("unchecked")
    public List<Order> getOrderList() {
      return (List<Order>) get(PROPERTY_ORDERLIST);
    }

    public void setOrderList(List<Order> orderList) {
        set(PROPERTY_ORDERLIST, orderList);
    }

    @SuppressWarnings("unchecked")
    public List<OrderLine> getOrderLineList() {
      return (List<OrderLine>) get(PROPERTY_ORDERLINELIST);
    }

    public void setOrderLineList(List<OrderLine> orderLineList) {
        set(PROPERTY_ORDERLINELIST, orderLineList);
    }

    @SuppressWarnings("unchecked")
    public List<OrderLineAccountingDimension> getOrderLineAccountingDimensionList() {
      return (List<OrderLineAccountingDimension>) get(PROPERTY_ORDERLINEACCOUNTINGDIMENSIONLIST);
    }

    public void setOrderLineAccountingDimensionList(List<OrderLineAccountingDimension> orderLineAccountingDimensionList) {
        set(PROPERTY_ORDERLINEACCOUNTINGDIMENSIONLIST, orderLineAccountingDimensionList);
    }

    @SuppressWarnings("unchecked")
    public List<AccountingFactSecondary> getSSACCTAccountingFactSecondaryList() {
      return (List<AccountingFactSecondary>) get(PROPERTY_SSACCTACCOUNTINGFACTSECONDARYLIST);
    }

    public void setSSACCTAccountingFactSecondaryList(List<AccountingFactSecondary> sSACCTAccountingFactSecondaryList) {
        set(PROPERTY_SSACCTACCOUNTINGFACTSECONDARYLIST, sSACCTAccountingFactSecondaryList);
    }

    @SuppressWarnings("unchecked")
    public List<SSACCTJOURNAL> getSSACCTJOURNALList() {
      return (List<SSACCTJOURNAL>) get(PROPERTY_SSACCTJOURNALLIST);
    }

    public void setSSACCTJOURNALList(List<SSACCTJOURNAL> sSACCTJOURNALList) {
        set(PROPERTY_SSACCTJOURNALLIST, sSACCTJOURNALList);
    }

    @SuppressWarnings("unchecked")
    public List<SSACCTJournalLine> getSSACCTJournalLineList() {
      return (List<SSACCTJournalLine>) get(PROPERTY_SSACCTJOURNALLINELIST);
    }

    public void setSSACCTJournalLineList(List<SSACCTJournalLine> sSACCTJournalLineList) {
        set(PROPERTY_SSACCTJOURNALLINELIST, sSACCTJournalLineList);
    }

    @SuppressWarnings("unchecked")
    public List<Sheet> getTimeAndExpenseSheetList() {
      return (List<Sheet>) get(PROPERTY_TIMEANDEXPENSESHEETLIST);
    }

    public void setTimeAndExpenseSheetList(List<Sheet> timeAndExpenseSheetList) {
        set(PROPERTY_TIMEANDEXPENSESHEETLIST, timeAndExpenseSheetList);
    }

    @SuppressWarnings("unchecked")
    public List<SheetLine> getTimeAndExpenseSheetLineList() {
      return (List<SheetLine>) get(PROPERTY_TIMEANDEXPENSESHEETLINELIST);
    }

    public void setTimeAndExpenseSheetLineList(List<SheetLine> timeAndExpenseSheetLineList) {
        set(PROPERTY_TIMEANDEXPENSESHEETLINELIST, timeAndExpenseSheetLineList);
    }

    @SuppressWarnings("unchecked")
    public List<SFBBudgetCertLine> getSfbBudgetCertLineList() {
      return (List<SFBBudgetCertLine>) get(PROPERTY_SFBBUDGETCERTLINELIST);
    }

    public void setSfbBudgetCertLineList(List<SFBBudgetCertLine> sfbBudgetCertLineList) {
        set(PROPERTY_SFBBUDGETCERTLINELIST, sfbBudgetCertLineList);
    }

    @SuppressWarnings("unchecked")
    public List<SsalApplActive> getSsalApplActiveList() {
      return (List<SsalApplActive>) get(PROPERTY_SSALAPPLACTIVELIST);
    }

    public void setSsalApplActiveList(List<SsalApplActive> ssalApplActiveList) {
        set(PROPERTY_SSALAPPLACTIVELIST, ssalApplActiveList);
    }

    @SuppressWarnings("unchecked")
    public List<SsalApplActive> getSsalApplActiveAAssetCodIDList() {
      return (List<SsalApplActive>) get(PROPERTY_SSALAPPLACTIVEAASSETCODIDLIST);
    }

    public void setSsalApplActiveAAssetCodIDList(List<SsalApplActive> ssalApplActiveAAssetCodIDList) {
        set(PROPERTY_SSALAPPLACTIVEAASSETCODIDLIST, ssalApplActiveAAssetCodIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SsalApplActive> getSsalApplActiveUPCEANList() {
      return (List<SsalApplActive>) get(PROPERTY_SSALAPPLACTIVEUPCEANLIST);
    }

    public void setSsalApplActiveUPCEANList(List<SsalApplActive> ssalApplActiveUPCEANList) {
        set(PROPERTY_SSALAPPLACTIVEUPCEANLIST, ssalApplActiveUPCEANList);
    }

    @SuppressWarnings("unchecked")
    public List<SsalApplActive> getSsalApplActiveDescriptionActiveList() {
      return (List<SsalApplActive>) get(PROPERTY_SSALAPPLACTIVEDESCRIPTIONACTIVELIST);
    }

    public void setSsalApplActiveDescriptionActiveList(List<SsalApplActive> ssalApplActiveDescriptionActiveList) {
        set(PROPERTY_SSALAPPLACTIVEDESCRIPTIONACTIVELIST, ssalApplActiveDescriptionActiveList);
    }

    @SuppressWarnings("unchecked")
    public List<ssalassetcom> getSsalAssetComList() {
      return (List<ssalassetcom>) get(PROPERTY_SSALASSETCOMLIST);
    }

    public void setSsalAssetComList(List<ssalassetcom> ssalAssetComList) {
        set(PROPERTY_SSALASSETCOMLIST, ssalAssetComList);
    }

    @SuppressWarnings("unchecked")
    public List<ssalassetreturnline> getSsalAssetReturnlineCdigoActivoList() {
      return (List<ssalassetreturnline>) get(PROPERTY_SSALASSETRETURNLINECDIGOACTIVOLIST);
    }

    public void setSsalAssetReturnlineCdigoActivoList(List<ssalassetreturnline> ssalAssetReturnlineCdigoActivoList) {
        set(PROPERTY_SSALASSETRETURNLINECDIGOACTIVOLIST, ssalAssetReturnlineCdigoActivoList);
    }

    @SuppressWarnings("unchecked")
    public List<ssalassetreturnline> getSsalAssetReturnlineUPCEANList() {
      return (List<ssalassetreturnline>) get(PROPERTY_SSALASSETRETURNLINEUPCEANLIST);
    }

    public void setSsalAssetReturnlineUPCEANList(List<ssalassetreturnline> ssalAssetReturnlineUPCEANList) {
        set(PROPERTY_SSALASSETRETURNLINEUPCEANLIST, ssalAssetReturnlineUPCEANList);
    }

    @SuppressWarnings("unchecked")
    public List<ssalassetreturnline> getSsalAssetReturnlineDescriptionActiveList() {
      return (List<ssalassetreturnline>) get(PROPERTY_SSALASSETRETURNLINEDESCRIPTIONACTIVELIST);
    }

    public void setSsalAssetReturnlineDescriptionActiveList(List<ssalassetreturnline> ssalAssetReturnlineDescriptionActiveList) {
        set(PROPERTY_SSALASSETRETURNLINEDESCRIPTIONACTIVELIST, ssalAssetReturnlineDescriptionActiveList);
    }

    @SuppressWarnings("unchecked")
    public List<ssamalienate> getSsamAlienateAAssetstartIDList() {
      return (List<ssamalienate>) get(PROPERTY_SSAMALIENATEAASSETSTARTIDLIST);
    }

    public void setSsamAlienateAAssetstartIDList(List<ssamalienate> ssamAlienateAAssetstartIDList) {
        set(PROPERTY_SSAMALIENATEAASSETSTARTIDLIST, ssamAlienateAAssetstartIDList);
    }

    @SuppressWarnings("unchecked")
    public List<ssamalienate> getSsamAlienateAAssetendIDList() {
      return (List<ssamalienate>) get(PROPERTY_SSAMALIENATEAASSETENDIDLIST);
    }

    public void setSsamAlienateAAssetendIDList(List<ssamalienate> ssamAlienateAAssetendIDList) {
        set(PROPERTY_SSAMALIENATEAASSETENDIDLIST, ssamAlienateAAssetendIDList);
    }

    @SuppressWarnings("unchecked")
    public List<ssamalienateline> getSsamAlienatelineList() {
      return (List<ssamalienateline>) get(PROPERTY_SSAMALIENATELINELIST);
    }

    public void setSsamAlienatelineList(List<ssamalienateline> ssamAlienatelineList) {
        set(PROPERTY_SSAMALIENATELINELIST, ssamAlienatelineList);
    }

}
