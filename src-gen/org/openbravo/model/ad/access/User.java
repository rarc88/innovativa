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
package org.openbravo.model.ad.access;

import com.sidesoft.flopec.budget.data.SFBBudgetCertificate;
import com.sidesoft.flopec.budget.data.SFBBudgetUserArea;
import com.sidesoft.localization.ecuador.finances.SsfiFinancialUser;

import ec.com.sidesoft.authorization.process.AuthorizationInvoice;
import ec.com.sidesoft.authorization.process.AuthorizationLLine;
import ec.com.sidesoft.authorization.process.AuthorizationLevel;
import ec.com.sidesoft.dimension.byrole.SdbrlUser1Dim;
import ec.com.sidesoft.dimension.byrole.SdbrlcCostcenterDim;
import ec.com.sidesoft.localization.ecuador.bpartner.complement.SBPCInfoPartnersV;
import ec.com.sidesoft.quick.billing.SqbConfigUser;
import ec.com.sidesoft.report.salesinvoice.SRSISalesInvoiceV;
import ec.com.sidesoft.ws.invoicecreate.data.SWSICConfig;
import ec.cusoft.facturaec.EEIMailServer;

import it.openia.crm.OpcrmConfig;
import it.openia.crm.OpcrmEmployNum;
import it.openia.crm.OpcrmEvaluation;
import it.openia.crm.OpcrmFuncInterest;
import it.openia.crm.OpcrmFuncinterestviewV;
import it.openia.crm.OpcrmIndustry;
import it.openia.crm.OpcrmInterests;
import it.openia.crm.OpcrmLeadPos;
import it.openia.crm.OpcrmLeadSource;
import it.openia.crm.OpcrmLeadToInterests;
import it.openia.crm.OpcrmLocationviewV;
import it.openia.crm.OpcrmProfile;
import it.openia.crm.OpcrmRecentlyupdatedV;
import it.openia.crm.OpcrmRejectFact;
import it.openia.crm.OpcrmRevenue;
import it.openia.crm.OpcrmStatStage;
import it.openia.crm.OpcrmStrategy;
import it.openia.crm.OpcrmSuperact;
import it.openia.crm.OpcrmSupercase;
import it.openia.crm.OpcrmSuperopp;
import it.openia.crm.OpcrmSuperusers;
import it.openia.crm.OpcrmTitle;
import it.openia.crm.Opcrmactivity;
import it.openia.crm.Opcrmcase;
import it.openia.crm.Opcrmopportunities;
import it.openia.crm.opcrmCasesAccess;
import it.openia.crm.opcrmGuest;
import it.openia.crm.opcrmLeadAccess;
import it.openia.crm.opcrmLeadActivity;
import it.openia.crm.opcrmOppAccess;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.client.application.UIPersonalization;
import org.openbravo.client.myob.WidgetInstance;
import org.openbravo.model.ad.alert.Alert;
import org.openbravo.model.ad.alert.AlertRecipient;
import org.openbravo.model.ad.domain.Preference;
import org.openbravo.model.ad.process.ProcessInstance;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.ad.system.Language;
import org.openbravo.model.ad.ui.ProcessExecution;
import org.openbravo.model.ad.ui.ProcessRequest;
import org.openbravo.model.ad.utility.AuditTrail;
import org.openbravo.model.ad.utility.Image;
import org.openbravo.model.common.businesspartner.BankAccount;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.businesspartner.Greeting;
import org.openbravo.model.common.businesspartner.Location;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.enterprise.OrganizationInformation;
import org.openbravo.model.common.enterprise.Warehouse;
import org.openbravo.model.common.interaction.ContactEmailInteraction;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.common.invoice.InvoiceLineV2;
import org.openbravo.model.common.invoice.InvoiceV2;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
import org.openbravo.model.manufacturing.quality.MeasureShift;
import org.openbravo.model.marketing.Campaign;
import org.openbravo.model.materialmgmt.onhandquantity.Reservation;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOut;
import org.openbravo.model.pos.ExternalPOS;
import org.openbravo.model.procurement.Requisition;
import org.openbravo.model.procurement.RequisitionLine;
import org.openbravo.model.project.ActiveProposal;
import org.openbravo.model.project.Project;
import org.openbravo.model.project.ProjectProposal;
import org.openbravo.model.project.ProjectProposalTask;
import org.openbravo.model.sales.SalesRegion;
import org.openbravo.model.timeandexpense.Resource;
import org.openbravo.service.integration.openid.OBSOIDUserIdentifier;
/**
 * Entity class for entity ADUser (stored in table AD_User).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class User extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "AD_User";
    public static final String ENTITY_NAME = "ADUser";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_PASSWORD = "password";
    public static final String PROPERTY_EMAIL = "email";
    public static final String PROPERTY_SUPERVISOR = "supervisor";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_PROCESSNOW = "processNow";
    public static final String PROPERTY_EMAILSERVERUSERNAME = "emailServerUsername";
    public static final String PROPERTY_EMAILSERVERPASSWORD = "emailServerPassword";
    public static final String PROPERTY_PARTNERADDRESS = "partnerAddress";
    public static final String PROPERTY_GREETING = "greeting";
    public static final String PROPERTY_POSITION = "position";
    public static final String PROPERTY_COMMENTS = "comments";
    public static final String PROPERTY_PHONE = "phone";
    public static final String PROPERTY_ALTERNATIVEPHONE = "alternativePhone";
    public static final String PROPERTY_FAX = "fax";
    public static final String PROPERTY_LASTCONTACTDATE = "lastContactDate";
    public static final String PROPERTY_LASTCONTACTRESULT = "lastContactResult";
    public static final String PROPERTY_BIRTHDAY = "birthday";
    public static final String PROPERTY_TRXORGANIZATION = "trxOrganization";
    public static final String PROPERTY_FIRSTNAME = "firstName";
    public static final String PROPERTY_LASTNAME = "lastName";
    public static final String PROPERTY_USERNAME = "username";
    public static final String PROPERTY_DEFAULTCLIENT = "defaultClient";
    public static final String PROPERTY_DEFAULTLANGUAGE = "defaultLanguage";
    public static final String PROPERTY_DEFAULTORGANIZATION = "defaultOrganization";
    public static final String PROPERTY_DEFAULTROLE = "defaultRole";
    public static final String PROPERTY_DEFAULTWAREHOUSE = "defaultWarehouse";
    public static final String PROPERTY_LOCKED = "locked";
    public static final String PROPERTY_IMAGE = "image";
    public static final String PROPERTY_GRANTPORTALACCESS = "grantPortalAccess";
    public static final String PROPERTY_EEIMAILSERVER = "eeiMailserver";
    public static final String PROPERTY_SSHRRELATIONSHIP = "sshrRelationship";
    public static final String PROPERTY_LASTPASSWORDUPDATE = "lastPasswordUpdate";
    public static final String PROPERTY_EEIEMAILUSER = "eeiEmailuser";
    public static final String PROPERTY_OPCRMSECONDARYEMAIL = "opcrmSecondaryEmail";
    public static final String PROPERTY_ISPASSWORDEXPIRED = "isPasswordExpired";
    public static final String PROPERTY_OPCRMASSIGNEDTO = "oPCRMAssignedTo";
    public static final String PROPERTY_OPCRMREPORTSTO = "oPCRMReportsTo";
    public static final String PROPERTY_OPCRMLEADSOURCE = "opcrmLeadSource";
    public static final String PROPERTY_SSHRDESCRIPTION = "sshrDescription";
    public static final String PROPERTY_OPCRMDONOTCALL = "opcrmDonotcall";
    public static final String PROPERTY_ECSAPSIGNDIGITAL = "ecsapSignDigital";
    public static final String PROPERTY_OPCRMISLEAD = "opcrmIslead";
    public static final String PROPERTY_OPCRMLEADSTATUS = "opcrmLeadstatus";
    public static final String PROPERTY_OPCRMSTATUSDESCR = "opcrmStatusdescr";
    public static final String PROPERTY_OPCRMAMOUNT = "opcrmAmount";
    public static final String PROPERTY_OPCRMZM = "opcrmZm";
    public static final String PROPERTY_OPCRMZMREV = "opcrmZmRev";
    public static final String PROPERTY_OPCRMCREATEPARTNER = "opcrmCreatepartner";
    public static final String PROPERTY_OPCRMCOMMERCIALNAME = "opcrmCommercialname";
    public static final String PROPERTY_OPCRMISCRMUSER = "opcrmIsCrmUser";
    public static final String PROPERTY_OPCRMCREATEOPP = "opcrmCreateopp";
    public static final String PROPERTY_OPCRMCREATEACTIVITY = "opcrmCreateactivity";
    public static final String PROPERTY_OPCRMADDUSERS = "opcrmAddUsers";
    public static final String PROPERTY_OPCRMLEADURL = "opcrmLeadurl";
    public static final String PROPERTY_OPCRMMOBILE = "opcrmMobile";
    public static final String PROPERTY_OPCRMSCORE = "opcrmScore";
    public static final String PROPERTY_OPCRMSTATSTAGE = "opcrmStatStage";
    public static final String PROPERTY_OPCRMREJECT = "opcrmReject";
    public static final String PROPERTY_OPCRMPOSITIONTAB = "opcrmPositionTab";
    public static final String PROPERTY_OPCRMPROFILE = "opcrmProfile";
    public static final String PROPERTY_OPCRMINDUSTRY = "opcrmIndustry";
    public static final String PROPERTY_OPCRMEMPLOYEE = "opcrmEmployee";
    public static final String PROPERTY_OPCRMINTEREST = "opcrmInterest";
    public static final String PROPERTY_OPCRMSTRATEGY = "opcrmStrategy";
    public static final String PROPERTY_OPCRMEVALTIME = "opcrmEvaltime";
    public static final String PROPERTY_OPCRMEXPCLOSEDATE = "opcrmExpclosedate";
    public static final String PROPERTY_OPCRMFUNCINTEREST = "opcrmFuncinterest";
    public static final String PROPERTY_OPCRMLSOURCETAB = "opcrmLsourcetab";
    public static final String PROPERTY_OPCRMTITLE = "opcrmTitle";
    public static final String PROPERTY_OPCRMPECEMAIL = "opcrmPecemail";
    public static final String PROPERTY_OPCRMTAXID = "opcrmTaxid";
    public static final String PROPERTY_OPCRMEXPECTEDREVENUE = "oPCRMExpectedRevenue";
    public static final String PROPERTY_OPCRMSTRAT = "opcrmStrat";
    public static final String PROPERTY_OPCRMCOMPUTEDNAMES = "opcrmComputednames";
    public static final String PROPERTY_OPCRMUSRIMAGE = "opcrmUsrimage";
    public static final String PROPERTY_OPCRMSALESREP = "opcrmSalesrep";
    public static final String PROPERTY_OPCRMFISCALCODE = "opcrmFiscalcode";
    public static final String PROPERTY_OPCRMSTATUSUPDATED = "opcrmStatusupdated";
    public static final String PROPERTY_ADALERTLIST = "aDAlertList";
    public static final String PROPERTY_ADALERTRECIPIENTLIST = "aDAlertRecipientList";
    public static final String PROPERTY_ADPREFERENCELIST = "aDPreferenceList";
    public static final String PROPERTY_ADPROCESSINSTANCELIST = "aDProcessInstanceList";
    public static final String PROPERTY_ADUSERSUPERVISORLIST = "aDUserSupervisorList";
    public static final String PROPERTY_ADUSEREMOPCRMASSIGNEDTOLIST = "aDUserEMOPCRMAssignedToList";
    public static final String PROPERTY_ADUSEREMOPCRMSALESREPIDLIST = "aDUserEMOpcrmSalesrepIDList";
    public static final String PROPERTY_ADUSERROLESLIST = "aDUserRolesList";
    public static final String PROPERTY_AUDITTRAILLIST = "auditTrailList";
    public static final String PROPERTY_ACTIVEPROPOSALVLIST = "activeProposalVList";
    public static final String PROPERTY_BUSINESSPARTNEREMOPCRMBPASSIGNEDTOLIST = "businessPartnerEMOpcrmBpAssignedToList";
    public static final String PROPERTY_BUSINESSPARTNERBANKACCOUNTLIST = "businessPartnerBankAccountList";
    public static final String PROPERTY_CONTACTEMAILINTERACTIONLIST = "contactEmailInteractionList";
    public static final String PROPERTY_ECSAPAUTHOINVOICELIST = "eCSAPAuthoInvoiceList";
    public static final String PROPERTY_ECSAPAUTHOLINELIST = "eCSAPAuthoLineList";
    public static final String PROPERTY_EXTERNALPOSSALESREPRESENTATIVELIST = "externalPOSSalesRepresentativeList";
    public static final String PROPERTY_FINANCIALMGMTASSETLIST = "financialMgmtAssetList";
    public static final String PROPERTY_INVOICESALESREPRESENTATIVELIST = "invoiceSalesRepresentativeList";
    public static final String PROPERTY_INVOICELIST = "invoiceList";
    public static final String PROPERTY_INVOICELINEV2SALESREPRESENTATIVELIST = "invoiceLineV2SalesRepresentativeList";
    public static final String PROPERTY_INVOICEV2SALESREPRESENTATIVELIST = "invoiceV2SalesRepresentativeList";
    public static final String PROPERTY_INVOICEV2LIST = "invoiceV2List";
    public static final String PROPERTY_LOCATIONEMOPCRMADUSERIDLIST = "locationEMOpcrmAdUserIDList";
    public static final String PROPERTY_MANUFACTURINGMEASURESHIFTLIST = "manufacturingMeasureShiftList";
    public static final String PROPERTY_MARKETINGCAMPAIGNEMOPCRMASSIGNEDTOLIST = "marketingCampaignEMOPCRMAssignedToList";
    public static final String PROPERTY_MATERIALMGMTRESERVATIONLIST = "materialMgmtReservationList";
    public static final String PROPERTY_MATERIALMGMTSHIPMENTINOUTLIST = "materialMgmtShipmentInOutList";
    public static final String PROPERTY_MATERIALMGMTSHIPMENTINOUTSALESREPRESENTATIVELIST = "materialMgmtShipmentInOutSalesRepresentativeList";
    public static final String PROPERTY_OBKMOWIDGETINSTANCEVISIBLEATUSERLIST = "oBKMOWidgetInstanceVisibleAtUserList";
    public static final String PROPERTY_OBSOIDUSERIDENTIFIERLIST = "oBSOIDUserIdentifierList";
    public static final String PROPERTY_OBUIAPPUIPERSONALIZATIONLIST = "oBUIAPPUIPersonalizationList";
    public static final String PROPERTY_ORDERSALESREPRESENTATIVELIST = "orderSalesRepresentativeList";
    public static final String PROPERTY_ORDERLIST = "orderList";
    public static final String PROPERTY_ORDERDROPSHIPCONTACTLIST = "orderDropShipContactList";
    public static final String PROPERTY_ORDEREMOPCRMRELATEDLEADLIST = "orderEMOpcrmRelatedleadList";
    public static final String PROPERTY_ORGANIZATIONINFORMATIONLIST = "organizationInformationList";
    public static final String PROPERTY_PROCESSEXECUTIONLIST = "processExecutionList";
    public static final String PROPERTY_PROCESSGROUPEXECUTIONLIST = "processGroupExecutionList";
    public static final String PROPERTY_PROCESSREQUESTLIST = "processRequestList";
    public static final String PROPERTY_PROCUREMENTREQUISITIONLIST = "procurementRequisitionList";
    public static final String PROPERTY_PROCUREMENTREQUISITIONLINELOCKEDBYLIST = "procurementRequisitionLineLockedByList";
    public static final String PROPERTY_PRODUCTSALESREPRESENTATIVELIST = "productSalesRepresentativeList";
    public static final String PROPERTY_PROJECTLIST = "projectList";
    public static final String PROPERTY_PROJECTSALESREPRESENTATIVELIST = "projectSalesRepresentativeList";
    public static final String PROPERTY_PROJECTPROJECTPROPOSALTASKLIST = "projectProjectProposalTaskList";
    public static final String PROPERTY_PROJECTPROPOSALLIST = "projectProposalList";
    public static final String PROPERTY_RESOURCELIST = "resourceList";
    public static final String PROPERTY_SBPCINFOPARTNERSVLIST = "sBPCInfoPartnersVList";
    public static final String PROPERTY_SBPCINFOPARTNERSVADUSERIDEMAILLIST = "sBPCInfoPartnersVADUserIdEmailList";
    public static final String PROPERTY_SBPCINFOPARTNERSVADUSERIDPHONE1LIST = "sBPCInfoPartnersVADUserIdPhone1List";
    public static final String PROPERTY_SBPCINFOPARTNERSVADUSERIDPHONE2LIST = "sBPCInfoPartnersVADUserIdPhone2List";
    public static final String PROPERTY_SRSISALESINVOICEVLIST = "sRSISalesInvoiceVList";
    public static final String PROPERTY_SWSICCONFIGLIST = "sWSICConfigList";
    public static final String PROPERTY_SALESREGIONSALESREPRESENTATIVELIST = "salesRegionSalesRepresentativeList";
    public static final String PROPERTY_ECSAPAUTHORIZATIONLEVELLIST = "ecsapAuthorizationLevelList";
    public static final String PROPERTY_OPCRMACTIVITYASSIGNEDTOLIST = "opcrmActivityAssignedToList";
    public static final String PROPERTY_OPCRMACTIVITYRELATEDLEADLIST = "opcrmActivityRelatedLeadList";
    public static final String PROPERTY_OPCRMCASESASSIGNEDTOLIST = "opcrmCasesAssignedToList";
    public static final String PROPERTY_OPCRMCASESRELATEDLEADLIST = "opcrmCasesRelatedLeadList";
    public static final String PROPERTY_OPCRMCASESCASECREATEDBYLIST = "opcrmCasesCaseCreatedbyList";
    public static final String PROPERTY_OPCRMCASESACCESSLIST = "opcrmCasesAccessList";
    public static final String PROPERTY_OPCRMCONFIGLIST = "opcrmConfigList";
    public static final String PROPERTY_OPCRMFUNCINTERESTVIEWVLIST = "opcrmFuncinterestviewVList";
    public static final String PROPERTY_OPCRMFUNCINTERESTVIEWVASSIGNEDTOLIST = "opcrmFuncinterestviewVAssignedToList";
    public static final String PROPERTY_OPCRMGUESTLIST = "opcrmGuestList";
    public static final String PROPERTY_OPCRMLEADACCESSLIST = "opcrmLeadAccessList";
    public static final String PROPERTY_OPCRMLEADACCESSCRMUSERIDLIST = "opcrmLeadAccessCRMUserIDList";
    public static final String PROPERTY_OPCRMLEADACTIVITYLIST = "opcrmLeadActivityList";
    public static final String PROPERTY_OPCRMLEADTOINTERESTSLIST = "opcrmLeadtointerestsList";
    public static final String PROPERTY_OPCRMLOCATIONVIEWVLIST = "opcrmLocationviewVList";
    public static final String PROPERTY_OPCRMLOCATIONVIEWVASSIGNEDTOLIST = "opcrmLocationviewVAssignedToList";
    public static final String PROPERTY_OPCRMOPPACCESSLIST = "opcrmOppAccessList";
    public static final String PROPERTY_OPCRMOPPORTUNITIESASSIGNEDTOLIST = "opcrmOpportunitiesAssignedToList";
    public static final String PROPERTY_OPCRMOPPORTUNITIESRELATEDLEADLIST = "opcrmOpportunitiesRelatedLeadList";
    public static final String PROPERTY_OPCRMRECENTLYUPDATEDVLIST = "opcrmRecentlyupdatedVList";
    public static final String PROPERTY_OPCRMRECENTLYUPDATEDVASSIGNEDTOLIST = "opcrmRecentlyupdatedVAssignedToList";
    public static final String PROPERTY_OPCRMSUPERACTLIST = "opcrmSuperactList";
    public static final String PROPERTY_OPCRMSUPERCASELIST = "opcrmSupercaseList";
    public static final String PROPERTY_OPCRMSUPEROPPLIST = "opcrmSuperoppList";
    public static final String PROPERTY_OPCRMSUPERUSERSLIST = "opcrmSuperusersList";
    public static final String PROPERTY_SDBRLCCOSTCENTERDIMLIST = "sdbrlCCostcenterDimList";
    public static final String PROPERTY_SDBRLUSER1DIMLIST = "sdbrlUser1DimList";
    public static final String PROPERTY_SFBBUDGETCERTIFICATELIST = "sfbBudgetCertificateList";
    public static final String PROPERTY_SFBBUDGETUSERAREALIST = "sfbBudgetUserAreaList";
    public static final String PROPERTY_SQBCONFIGUSERLIST = "sqbConfigUserList";
    public static final String PROPERTY_SSFIFINANCIALUSERLIST = "ssfiFinancialUserList";

    public User() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_PROCESSNOW, false);
        setDefaultValue(PROPERTY_LOCKED, false);
        setDefaultValue(PROPERTY_GRANTPORTALACCESS, false);
        setDefaultValue(PROPERTY_ISPASSWORDEXPIRED, false);
        setDefaultValue(PROPERTY_OPCRMDONOTCALL, false);
        setDefaultValue(PROPERTY_OPCRMISLEAD, false);
        setDefaultValue(PROPERTY_OPCRMLEADSTATUS, "opcrmNew");
        setDefaultValue(PROPERTY_OPCRMCREATEPARTNER, false);
        setDefaultValue(PROPERTY_OPCRMISCRMUSER, false);
        setDefaultValue(PROPERTY_OPCRMCREATEOPP, false);
        setDefaultValue(PROPERTY_OPCRMCREATEACTIVITY, false);
        setDefaultValue(PROPERTY_OPCRMADDUSERS, false);
        setDefaultValue(PROPERTY_ADALERTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADALERTRECIPIENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADPREFERENCELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADPROCESSINSTANCELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADUSERSUPERVISORLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADUSEREMOPCRMASSIGNEDTOLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADUSEREMOPCRMSALESREPIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ADUSERROLESLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_AUDITTRAILLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ACTIVEPROPOSALVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_BUSINESSPARTNEREMOPCRMBPASSIGNEDTOLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_BUSINESSPARTNERBANKACCOUNTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_CONTACTEMAILINTERACTIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ECSAPAUTHOINVOICELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ECSAPAUTHOLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_EXTERNALPOSSALESREPRESENTATIVELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTASSETLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICESALESREPRESENTATIVELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELINEV2SALESREPRESENTATIVELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICEV2SALESREPRESENTATIVELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICEV2LIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_LOCATIONEMOPCRMADUSERIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MANUFACTURINGMEASURESHIFTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MARKETINGCAMPAIGNEMOPCRMASSIGNEDTOLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTRESERVATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTSHIPMENTINOUTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTSHIPMENTINOUTSALESREPRESENTATIVELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OBKMOWIDGETINSTANCEVISIBLEATUSERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OBSOIDUSERIDENTIFIERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OBUIAPPUIPERSONALIZATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERSALESREPRESENTATIVELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERDROPSHIPCONTACTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDEREMOPCRMRELATEDLEADLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORGANIZATIONINFORMATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROCESSEXECUTIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROCESSGROUPEXECUTIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROCESSREQUESTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROCUREMENTREQUISITIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROCUREMENTREQUISITIONLINELOCKEDBYLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRODUCTSALESREPRESENTATIVELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROJECTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROJECTSALESREPRESENTATIVELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROJECTPROJECTPROPOSALTASKLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROJECTPROPOSALLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_RESOURCELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SBPCINFOPARTNERSVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SBPCINFOPARTNERSVADUSERIDEMAILLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SBPCINFOPARTNERSVADUSERIDPHONE1LIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SBPCINFOPARTNERSVADUSERIDPHONE2LIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SRSISALESINVOICEVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SWSICCONFIGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SALESREGIONSALESREPRESENTATIVELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ECSAPAUTHORIZATIONLEVELLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OPCRMACTIVITYASSIGNEDTOLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OPCRMACTIVITYRELATEDLEADLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OPCRMCASESASSIGNEDTOLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OPCRMCASESRELATEDLEADLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OPCRMCASESCASECREATEDBYLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OPCRMCASESACCESSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OPCRMCONFIGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OPCRMFUNCINTERESTVIEWVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OPCRMFUNCINTERESTVIEWVASSIGNEDTOLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OPCRMGUESTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OPCRMLEADACCESSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OPCRMLEADACCESSCRMUSERIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OPCRMLEADACTIVITYLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OPCRMLEADTOINTERESTSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OPCRMLOCATIONVIEWVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OPCRMLOCATIONVIEWVASSIGNEDTOLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OPCRMOPPACCESSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OPCRMOPPORTUNITIESASSIGNEDTOLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OPCRMOPPORTUNITIESRELATEDLEADLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OPCRMRECENTLYUPDATEDVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OPCRMRECENTLYUPDATEDVASSIGNEDTOLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OPCRMSUPERACTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OPCRMSUPERCASELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OPCRMSUPEROPPLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OPCRMSUPERUSERSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SDBRLCCOSTCENTERDIMLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SDBRLUSER1DIMLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETCERTIFICATELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFBBUDGETUSERAREALIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SQBCONFIGUSERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSFIFINANCIALUSERLIST, new ArrayList<Object>());
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

    public String getPassword() {
        return (String) get(PROPERTY_PASSWORD);
    }

    public void setPassword(String password) {
        set(PROPERTY_PASSWORD, password);
    }

    public String getEmail() {
        return (String) get(PROPERTY_EMAIL);
    }

    public void setEmail(String email) {
        set(PROPERTY_EMAIL, email);
    }

    public User getSupervisor() {
        return (User) get(PROPERTY_SUPERVISOR);
    }

    public void setSupervisor(User supervisor) {
        set(PROPERTY_SUPERVISOR, supervisor);
    }

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public Boolean isProcessNow() {
        return (Boolean) get(PROPERTY_PROCESSNOW);
    }

    public void setProcessNow(Boolean processNow) {
        set(PROPERTY_PROCESSNOW, processNow);
    }

    public String getEmailServerUsername() {
        return (String) get(PROPERTY_EMAILSERVERUSERNAME);
    }

    public void setEmailServerUsername(String emailServerUsername) {
        set(PROPERTY_EMAILSERVERUSERNAME, emailServerUsername);
    }

    public String getEmailServerPassword() {
        return (String) get(PROPERTY_EMAILSERVERPASSWORD);
    }

    public void setEmailServerPassword(String emailServerPassword) {
        set(PROPERTY_EMAILSERVERPASSWORD, emailServerPassword);
    }

    public Location getPartnerAddress() {
        return (Location) get(PROPERTY_PARTNERADDRESS);
    }

    public void setPartnerAddress(Location partnerAddress) {
        set(PROPERTY_PARTNERADDRESS, partnerAddress);
    }

    public Greeting getGreeting() {
        return (Greeting) get(PROPERTY_GREETING);
    }

    public void setGreeting(Greeting greeting) {
        set(PROPERTY_GREETING, greeting);
    }

    public String getPosition() {
        return (String) get(PROPERTY_POSITION);
    }

    public void setPosition(String position) {
        set(PROPERTY_POSITION, position);
    }

    public String getComments() {
        return (String) get(PROPERTY_COMMENTS);
    }

    public void setComments(String comments) {
        set(PROPERTY_COMMENTS, comments);
    }

    public String getPhone() {
        return (String) get(PROPERTY_PHONE);
    }

    public void setPhone(String phone) {
        set(PROPERTY_PHONE, phone);
    }

    public String getAlternativePhone() {
        return (String) get(PROPERTY_ALTERNATIVEPHONE);
    }

    public void setAlternativePhone(String alternativePhone) {
        set(PROPERTY_ALTERNATIVEPHONE, alternativePhone);
    }

    public String getFax() {
        return (String) get(PROPERTY_FAX);
    }

    public void setFax(String fax) {
        set(PROPERTY_FAX, fax);
    }

    public Date getLastContactDate() {
        return (Date) get(PROPERTY_LASTCONTACTDATE);
    }

    public void setLastContactDate(Date lastContactDate) {
        set(PROPERTY_LASTCONTACTDATE, lastContactDate);
    }

    public String getLastContactResult() {
        return (String) get(PROPERTY_LASTCONTACTRESULT);
    }

    public void setLastContactResult(String lastContactResult) {
        set(PROPERTY_LASTCONTACTRESULT, lastContactResult);
    }

    public Date getBirthday() {
        return (Date) get(PROPERTY_BIRTHDAY);
    }

    public void setBirthday(Date birthday) {
        set(PROPERTY_BIRTHDAY, birthday);
    }

    public Organization getTrxOrganization() {
        return (Organization) get(PROPERTY_TRXORGANIZATION);
    }

    public void setTrxOrganization(Organization trxOrganization) {
        set(PROPERTY_TRXORGANIZATION, trxOrganization);
    }

    public String getFirstName() {
        return (String) get(PROPERTY_FIRSTNAME);
    }

    public void setFirstName(String firstName) {
        set(PROPERTY_FIRSTNAME, firstName);
    }

    public String getLastName() {
        return (String) get(PROPERTY_LASTNAME);
    }

    public void setLastName(String lastName) {
        set(PROPERTY_LASTNAME, lastName);
    }

    public String getUsername() {
        return (String) get(PROPERTY_USERNAME);
    }

    public void setUsername(String username) {
        set(PROPERTY_USERNAME, username);
    }

    public Client getDefaultClient() {
        return (Client) get(PROPERTY_DEFAULTCLIENT);
    }

    public void setDefaultClient(Client defaultClient) {
        set(PROPERTY_DEFAULTCLIENT, defaultClient);
    }

    public Language getDefaultLanguage() {
        return (Language) get(PROPERTY_DEFAULTLANGUAGE);
    }

    public void setDefaultLanguage(Language defaultLanguage) {
        set(PROPERTY_DEFAULTLANGUAGE, defaultLanguage);
    }

    public Organization getDefaultOrganization() {
        return (Organization) get(PROPERTY_DEFAULTORGANIZATION);
    }

    public void setDefaultOrganization(Organization defaultOrganization) {
        set(PROPERTY_DEFAULTORGANIZATION, defaultOrganization);
    }

    public Role getDefaultRole() {
        return (Role) get(PROPERTY_DEFAULTROLE);
    }

    public void setDefaultRole(Role defaultRole) {
        set(PROPERTY_DEFAULTROLE, defaultRole);
    }

    public Warehouse getDefaultWarehouse() {
        return (Warehouse) get(PROPERTY_DEFAULTWAREHOUSE);
    }

    public void setDefaultWarehouse(Warehouse defaultWarehouse) {
        set(PROPERTY_DEFAULTWAREHOUSE, defaultWarehouse);
    }

    public Boolean isLocked() {
        return (Boolean) get(PROPERTY_LOCKED);
    }

    public void setLocked(Boolean locked) {
        set(PROPERTY_LOCKED, locked);
    }

    public Image getImage() {
        return (Image) get(PROPERTY_IMAGE);
    }

    public void setImage(Image image) {
        set(PROPERTY_IMAGE, image);
    }

    public Boolean isGrantPortalAccess() {
        return (Boolean) get(PROPERTY_GRANTPORTALACCESS);
    }

    public void setGrantPortalAccess(Boolean grantPortalAccess) {
        set(PROPERTY_GRANTPORTALACCESS, grantPortalAccess);
    }

    public EEIMailServer getEeiMailserver() {
        return (EEIMailServer) get(PROPERTY_EEIMAILSERVER);
    }

    public void setEeiMailserver(EEIMailServer eeiMailserver) {
        set(PROPERTY_EEIMAILSERVER, eeiMailserver);
    }

    public String getSshrRelationship() {
        return (String) get(PROPERTY_SSHRRELATIONSHIP);
    }

    public void setSshrRelationship(String sshrRelationship) {
        set(PROPERTY_SSHRRELATIONSHIP, sshrRelationship);
    }

    public Date getLastPasswordUpdate() {
        return (Date) get(PROPERTY_LASTPASSWORDUPDATE);
    }

    public void setLastPasswordUpdate(Date lastPasswordUpdate) {
        set(PROPERTY_LASTPASSWORDUPDATE, lastPasswordUpdate);
    }

    public String getEeiEmailuser() {
        return (String) get(PROPERTY_EEIEMAILUSER);
    }

    public void setEeiEmailuser(String eeiEmailuser) {
        set(PROPERTY_EEIEMAILUSER, eeiEmailuser);
    }

    public String getOpcrmSecondaryEmail() {
        return (String) get(PROPERTY_OPCRMSECONDARYEMAIL);
    }

    public void setOpcrmSecondaryEmail(String opcrmSecondaryEmail) {
        set(PROPERTY_OPCRMSECONDARYEMAIL, opcrmSecondaryEmail);
    }

    public Boolean isPasswordExpired() {
        return (Boolean) get(PROPERTY_ISPASSWORDEXPIRED);
    }

    public void setPasswordExpired(Boolean isPasswordExpired) {
        set(PROPERTY_ISPASSWORDEXPIRED, isPasswordExpired);
    }

    public User getOPCRMAssignedTo() {
        return (User) get(PROPERTY_OPCRMASSIGNEDTO);
    }

    public void setOPCRMAssignedTo(User oPCRMAssignedTo) {
        set(PROPERTY_OPCRMASSIGNEDTO, oPCRMAssignedTo);
    }

    public BusinessPartner getOPCRMReportsTo() {
        return (BusinessPartner) get(PROPERTY_OPCRMREPORTSTO);
    }

    public void setOPCRMReportsTo(BusinessPartner oPCRMReportsTo) {
        set(PROPERTY_OPCRMREPORTSTO, oPCRMReportsTo);
    }

    public String getOpcrmLeadSource() {
        return (String) get(PROPERTY_OPCRMLEADSOURCE);
    }

    public void setOpcrmLeadSource(String opcrmLeadSource) {
        set(PROPERTY_OPCRMLEADSOURCE, opcrmLeadSource);
    }

    public String getSshrDescription() {
        return (String) get(PROPERTY_SSHRDESCRIPTION);
    }

    public void setSshrDescription(String sshrDescription) {
        set(PROPERTY_SSHRDESCRIPTION, sshrDescription);
    }

    public Boolean isOpcrmDonotcall() {
        return (Boolean) get(PROPERTY_OPCRMDONOTCALL);
    }

    public void setOpcrmDonotcall(Boolean opcrmDonotcall) {
        set(PROPERTY_OPCRMDONOTCALL, opcrmDonotcall);
    }

    public String getEcsapSignDigital() {
        return (String) get(PROPERTY_ECSAPSIGNDIGITAL);
    }

    public void setEcsapSignDigital(String ecsapSignDigital) {
        set(PROPERTY_ECSAPSIGNDIGITAL, ecsapSignDigital);
    }

    public Boolean isOpcrmIslead() {
        return (Boolean) get(PROPERTY_OPCRMISLEAD);
    }

    public void setOpcrmIslead(Boolean opcrmIslead) {
        set(PROPERTY_OPCRMISLEAD, opcrmIslead);
    }

    public String getOpcrmLeadstatus() {
        return (String) get(PROPERTY_OPCRMLEADSTATUS);
    }

    public void setOpcrmLeadstatus(String opcrmLeadstatus) {
        set(PROPERTY_OPCRMLEADSTATUS, opcrmLeadstatus);
    }

    public String getOpcrmStatusdescr() {
        return (String) get(PROPERTY_OPCRMSTATUSDESCR);
    }

    public void setOpcrmStatusdescr(String opcrmStatusdescr) {
        set(PROPERTY_OPCRMSTATUSDESCR, opcrmStatusdescr);
    }

    public BigDecimal getOpcrmAmount() {
        return (BigDecimal) get(PROPERTY_OPCRMAMOUNT);
    }

    public void setOpcrmAmount(BigDecimal opcrmAmount) {
        set(PROPERTY_OPCRMAMOUNT, opcrmAmount);
    }

    public String getOpcrmZm() {
        return (String) get(PROPERTY_OPCRMZM);
    }

    public void setOpcrmZm(String opcrmZm) {
        set(PROPERTY_OPCRMZM, opcrmZm);
    }

    public String getOpcrmZmRev() {
        return (String) get(PROPERTY_OPCRMZMREV);
    }

    public void setOpcrmZmRev(String opcrmZmRev) {
        set(PROPERTY_OPCRMZMREV, opcrmZmRev);
    }

    public Boolean isOpcrmCreatepartner() {
        return (Boolean) get(PROPERTY_OPCRMCREATEPARTNER);
    }

    public void setOpcrmCreatepartner(Boolean opcrmCreatepartner) {
        set(PROPERTY_OPCRMCREATEPARTNER, opcrmCreatepartner);
    }

    public String getOpcrmCommercialname() {
        return (String) get(PROPERTY_OPCRMCOMMERCIALNAME);
    }

    public void setOpcrmCommercialname(String opcrmCommercialname) {
        set(PROPERTY_OPCRMCOMMERCIALNAME, opcrmCommercialname);
    }

    public Boolean isOpcrmIsCrmUser() {
        return (Boolean) get(PROPERTY_OPCRMISCRMUSER);
    }

    public void setOpcrmIsCrmUser(Boolean opcrmIsCrmUser) {
        set(PROPERTY_OPCRMISCRMUSER, opcrmIsCrmUser);
    }

    public Boolean isOpcrmCreateopp() {
        return (Boolean) get(PROPERTY_OPCRMCREATEOPP);
    }

    public void setOpcrmCreateopp(Boolean opcrmCreateopp) {
        set(PROPERTY_OPCRMCREATEOPP, opcrmCreateopp);
    }

    public Boolean isOpcrmCreateactivity() {
        return (Boolean) get(PROPERTY_OPCRMCREATEACTIVITY);
    }

    public void setOpcrmCreateactivity(Boolean opcrmCreateactivity) {
        set(PROPERTY_OPCRMCREATEACTIVITY, opcrmCreateactivity);
    }

    public Boolean isOpcrmAddUsers() {
        return (Boolean) get(PROPERTY_OPCRMADDUSERS);
    }

    public void setOpcrmAddUsers(Boolean opcrmAddUsers) {
        set(PROPERTY_OPCRMADDUSERS, opcrmAddUsers);
    }

    public String getOpcrmLeadurl() {
        return (String) get(PROPERTY_OPCRMLEADURL);
    }

    public void setOpcrmLeadurl(String opcrmLeadurl) {
        set(PROPERTY_OPCRMLEADURL, opcrmLeadurl);
    }

    public String getOpcrmMobile() {
        return (String) get(PROPERTY_OPCRMMOBILE);
    }

    public void setOpcrmMobile(String opcrmMobile) {
        set(PROPERTY_OPCRMMOBILE, opcrmMobile);
    }

    public Long getOpcrmScore() {
        return (Long) get(PROPERTY_OPCRMSCORE);
    }

    public void setOpcrmScore(Long opcrmScore) {
        set(PROPERTY_OPCRMSCORE, opcrmScore);
    }

    public OpcrmStatStage getOpcrmStatStage() {
        return (OpcrmStatStage) get(PROPERTY_OPCRMSTATSTAGE);
    }

    public void setOpcrmStatStage(OpcrmStatStage opcrmStatStage) {
        set(PROPERTY_OPCRMSTATSTAGE, opcrmStatStage);
    }

    public OpcrmRejectFact getOpcrmReject() {
        return (OpcrmRejectFact) get(PROPERTY_OPCRMREJECT);
    }

    public void setOpcrmReject(OpcrmRejectFact opcrmReject) {
        set(PROPERTY_OPCRMREJECT, opcrmReject);
    }

    public OpcrmLeadPos getOpcrmPositionTab() {
        return (OpcrmLeadPos) get(PROPERTY_OPCRMPOSITIONTAB);
    }

    public void setOpcrmPositionTab(OpcrmLeadPos opcrmPositionTab) {
        set(PROPERTY_OPCRMPOSITIONTAB, opcrmPositionTab);
    }

    public OpcrmProfile getOpcrmProfile() {
        return (OpcrmProfile) get(PROPERTY_OPCRMPROFILE);
    }

    public void setOpcrmProfile(OpcrmProfile opcrmProfile) {
        set(PROPERTY_OPCRMPROFILE, opcrmProfile);
    }

    public OpcrmIndustry getOpcrmIndustry() {
        return (OpcrmIndustry) get(PROPERTY_OPCRMINDUSTRY);
    }

    public void setOpcrmIndustry(OpcrmIndustry opcrmIndustry) {
        set(PROPERTY_OPCRMINDUSTRY, opcrmIndustry);
    }

    public OpcrmEmployNum getOpcrmEmployee() {
        return (OpcrmEmployNum) get(PROPERTY_OPCRMEMPLOYEE);
    }

    public void setOpcrmEmployee(OpcrmEmployNum opcrmEmployee) {
        set(PROPERTY_OPCRMEMPLOYEE, opcrmEmployee);
    }

    public OpcrmInterests getOpcrmInterest() {
        return (OpcrmInterests) get(PROPERTY_OPCRMINTEREST);
    }

    public void setOpcrmInterest(OpcrmInterests opcrmInterest) {
        set(PROPERTY_OPCRMINTEREST, opcrmInterest);
    }

    public String getOpcrmStrategy() {
        return (String) get(PROPERTY_OPCRMSTRATEGY);
    }

    public void setOpcrmStrategy(String opcrmStrategy) {
        set(PROPERTY_OPCRMSTRATEGY, opcrmStrategy);
    }

    public OpcrmEvaluation getOpcrmEvaltime() {
        return (OpcrmEvaluation) get(PROPERTY_OPCRMEVALTIME);
    }

    public void setOpcrmEvaltime(OpcrmEvaluation opcrmEvaltime) {
        set(PROPERTY_OPCRMEVALTIME, opcrmEvaltime);
    }

    public Date getOpcrmExpclosedate() {
        return (Date) get(PROPERTY_OPCRMEXPCLOSEDATE);
    }

    public void setOpcrmExpclosedate(Date opcrmExpclosedate) {
        set(PROPERTY_OPCRMEXPCLOSEDATE, opcrmExpclosedate);
    }

    public OpcrmFuncInterest getOpcrmFuncinterest() {
        return (OpcrmFuncInterest) get(PROPERTY_OPCRMFUNCINTEREST);
    }

    public void setOpcrmFuncinterest(OpcrmFuncInterest opcrmFuncinterest) {
        set(PROPERTY_OPCRMFUNCINTEREST, opcrmFuncinterest);
    }

    public OpcrmLeadSource getOpcrmLsourcetab() {
        return (OpcrmLeadSource) get(PROPERTY_OPCRMLSOURCETAB);
    }

    public void setOpcrmLsourcetab(OpcrmLeadSource opcrmLsourcetab) {
        set(PROPERTY_OPCRMLSOURCETAB, opcrmLsourcetab);
    }

    public OpcrmTitle getOpcrmTitle() {
        return (OpcrmTitle) get(PROPERTY_OPCRMTITLE);
    }

    public void setOpcrmTitle(OpcrmTitle opcrmTitle) {
        set(PROPERTY_OPCRMTITLE, opcrmTitle);
    }

    public String getOpcrmPecemail() {
        return (String) get(PROPERTY_OPCRMPECEMAIL);
    }

    public void setOpcrmPecemail(String opcrmPecemail) {
        set(PROPERTY_OPCRMPECEMAIL, opcrmPecemail);
    }

    public String getOpcrmTaxid() {
        return (String) get(PROPERTY_OPCRMTAXID);
    }

    public void setOpcrmTaxid(String opcrmTaxid) {
        set(PROPERTY_OPCRMTAXID, opcrmTaxid);
    }

    public OpcrmRevenue getOPCRMExpectedRevenue() {
        return (OpcrmRevenue) get(PROPERTY_OPCRMEXPECTEDREVENUE);
    }

    public void setOPCRMExpectedRevenue(OpcrmRevenue oPCRMExpectedRevenue) {
        set(PROPERTY_OPCRMEXPECTEDREVENUE, oPCRMExpectedRevenue);
    }

    public OpcrmStrategy getOpcrmStrat() {
        return (OpcrmStrategy) get(PROPERTY_OPCRMSTRAT);
    }

    public void setOpcrmStrat(OpcrmStrategy opcrmStrat) {
        set(PROPERTY_OPCRMSTRAT, opcrmStrat);
    }

    public String getOpcrmComputednames() {
        return (String) get(PROPERTY_OPCRMCOMPUTEDNAMES);
    }

    public void setOpcrmComputednames(String opcrmComputednames) {
        set(PROPERTY_OPCRMCOMPUTEDNAMES, opcrmComputednames);
    }

    public String getOpcrmUsrimage() {
        return (String) get(PROPERTY_OPCRMUSRIMAGE);
    }

    public void setOpcrmUsrimage(String opcrmUsrimage) {
        set(PROPERTY_OPCRMUSRIMAGE, opcrmUsrimage);
    }

    public User getOpcrmSalesrep() {
        return (User) get(PROPERTY_OPCRMSALESREP);
    }

    public void setOpcrmSalesrep(User opcrmSalesrep) {
        set(PROPERTY_OPCRMSALESREP, opcrmSalesrep);
    }

    public String getOpcrmFiscalcode() {
        return (String) get(PROPERTY_OPCRMFISCALCODE);
    }

    public void setOpcrmFiscalcode(String opcrmFiscalcode) {
        set(PROPERTY_OPCRMFISCALCODE, opcrmFiscalcode);
    }

    public Date getOpcrmStatusupdated() {
        return (Date) get(PROPERTY_OPCRMSTATUSUPDATED);
    }

    public void setOpcrmStatusupdated(Date opcrmStatusupdated) {
        set(PROPERTY_OPCRMSTATUSUPDATED, opcrmStatusupdated);
    }

    @SuppressWarnings("unchecked")
    public List<Alert> getADAlertList() {
      return (List<Alert>) get(PROPERTY_ADALERTLIST);
    }

    public void setADAlertList(List<Alert> aDAlertList) {
        set(PROPERTY_ADALERTLIST, aDAlertList);
    }

    @SuppressWarnings("unchecked")
    public List<AlertRecipient> getADAlertRecipientList() {
      return (List<AlertRecipient>) get(PROPERTY_ADALERTRECIPIENTLIST);
    }

    public void setADAlertRecipientList(List<AlertRecipient> aDAlertRecipientList) {
        set(PROPERTY_ADALERTRECIPIENTLIST, aDAlertRecipientList);
    }

    @SuppressWarnings("unchecked")
    public List<Preference> getADPreferenceList() {
      return (List<Preference>) get(PROPERTY_ADPREFERENCELIST);
    }

    public void setADPreferenceList(List<Preference> aDPreferenceList) {
        set(PROPERTY_ADPREFERENCELIST, aDPreferenceList);
    }

    @SuppressWarnings("unchecked")
    public List<ProcessInstance> getADProcessInstanceList() {
      return (List<ProcessInstance>) get(PROPERTY_ADPROCESSINSTANCELIST);
    }

    public void setADProcessInstanceList(List<ProcessInstance> aDProcessInstanceList) {
        set(PROPERTY_ADPROCESSINSTANCELIST, aDProcessInstanceList);
    }

    @SuppressWarnings("unchecked")
    public List<User> getADUserSupervisorList() {
      return (List<User>) get(PROPERTY_ADUSERSUPERVISORLIST);
    }

    public void setADUserSupervisorList(List<User> aDUserSupervisorList) {
        set(PROPERTY_ADUSERSUPERVISORLIST, aDUserSupervisorList);
    }

    @SuppressWarnings("unchecked")
    public List<User> getADUserEMOPCRMAssignedToList() {
      return (List<User>) get(PROPERTY_ADUSEREMOPCRMASSIGNEDTOLIST);
    }

    public void setADUserEMOPCRMAssignedToList(List<User> aDUserEMOPCRMAssignedToList) {
        set(PROPERTY_ADUSEREMOPCRMASSIGNEDTOLIST, aDUserEMOPCRMAssignedToList);
    }

    @SuppressWarnings("unchecked")
    public List<User> getADUserEMOpcrmSalesrepIDList() {
      return (List<User>) get(PROPERTY_ADUSEREMOPCRMSALESREPIDLIST);
    }

    public void setADUserEMOpcrmSalesrepIDList(List<User> aDUserEMOpcrmSalesrepIDList) {
        set(PROPERTY_ADUSEREMOPCRMSALESREPIDLIST, aDUserEMOpcrmSalesrepIDList);
    }

    @SuppressWarnings("unchecked")
    public List<UserRoles> getADUserRolesList() {
      return (List<UserRoles>) get(PROPERTY_ADUSERROLESLIST);
    }

    public void setADUserRolesList(List<UserRoles> aDUserRolesList) {
        set(PROPERTY_ADUSERROLESLIST, aDUserRolesList);
    }

    @SuppressWarnings("unchecked")
    public List<AuditTrail> getAuditTrailList() {
      return (List<AuditTrail>) get(PROPERTY_AUDITTRAILLIST);
    }

    public void setAuditTrailList(List<AuditTrail> auditTrailList) {
        set(PROPERTY_AUDITTRAILLIST, auditTrailList);
    }

    @SuppressWarnings("unchecked")
    public List<ActiveProposal> getActiveProposalVList() {
      return (List<ActiveProposal>) get(PROPERTY_ACTIVEPROPOSALVLIST);
    }

    public void setActiveProposalVList(List<ActiveProposal> activeProposalVList) {
        set(PROPERTY_ACTIVEPROPOSALVLIST, activeProposalVList);
    }

    @SuppressWarnings("unchecked")
    public List<BusinessPartner> getBusinessPartnerEMOpcrmBpAssignedToList() {
      return (List<BusinessPartner>) get(PROPERTY_BUSINESSPARTNEREMOPCRMBPASSIGNEDTOLIST);
    }

    public void setBusinessPartnerEMOpcrmBpAssignedToList(List<BusinessPartner> businessPartnerEMOpcrmBpAssignedToList) {
        set(PROPERTY_BUSINESSPARTNEREMOPCRMBPASSIGNEDTOLIST, businessPartnerEMOpcrmBpAssignedToList);
    }

    @SuppressWarnings("unchecked")
    public List<BankAccount> getBusinessPartnerBankAccountList() {
      return (List<BankAccount>) get(PROPERTY_BUSINESSPARTNERBANKACCOUNTLIST);
    }

    public void setBusinessPartnerBankAccountList(List<BankAccount> businessPartnerBankAccountList) {
        set(PROPERTY_BUSINESSPARTNERBANKACCOUNTLIST, businessPartnerBankAccountList);
    }

    @SuppressWarnings("unchecked")
    public List<ContactEmailInteraction> getContactEmailInteractionList() {
      return (List<ContactEmailInteraction>) get(PROPERTY_CONTACTEMAILINTERACTIONLIST);
    }

    public void setContactEmailInteractionList(List<ContactEmailInteraction> contactEmailInteractionList) {
        set(PROPERTY_CONTACTEMAILINTERACTIONLIST, contactEmailInteractionList);
    }

    @SuppressWarnings("unchecked")
    public List<AuthorizationInvoice> getECSAPAuthoInvoiceList() {
      return (List<AuthorizationInvoice>) get(PROPERTY_ECSAPAUTHOINVOICELIST);
    }

    public void setECSAPAuthoInvoiceList(List<AuthorizationInvoice> eCSAPAuthoInvoiceList) {
        set(PROPERTY_ECSAPAUTHOINVOICELIST, eCSAPAuthoInvoiceList);
    }

    @SuppressWarnings("unchecked")
    public List<AuthorizationLLine> getECSAPAuthoLineList() {
      return (List<AuthorizationLLine>) get(PROPERTY_ECSAPAUTHOLINELIST);
    }

    public void setECSAPAuthoLineList(List<AuthorizationLLine> eCSAPAuthoLineList) {
        set(PROPERTY_ECSAPAUTHOLINELIST, eCSAPAuthoLineList);
    }

    @SuppressWarnings("unchecked")
    public List<ExternalPOS> getExternalPOSSalesRepresentativeList() {
      return (List<ExternalPOS>) get(PROPERTY_EXTERNALPOSSALESREPRESENTATIVELIST);
    }

    public void setExternalPOSSalesRepresentativeList(List<ExternalPOS> externalPOSSalesRepresentativeList) {
        set(PROPERTY_EXTERNALPOSSALESREPRESENTATIVELIST, externalPOSSalesRepresentativeList);
    }

    @SuppressWarnings("unchecked")
    public List<Asset> getFinancialMgmtAssetList() {
      return (List<Asset>) get(PROPERTY_FINANCIALMGMTASSETLIST);
    }

    public void setFinancialMgmtAssetList(List<Asset> financialMgmtAssetList) {
        set(PROPERTY_FINANCIALMGMTASSETLIST, financialMgmtAssetList);
    }

    @SuppressWarnings("unchecked")
    public List<Invoice> getInvoiceSalesRepresentativeList() {
      return (List<Invoice>) get(PROPERTY_INVOICESALESREPRESENTATIVELIST);
    }

    public void setInvoiceSalesRepresentativeList(List<Invoice> invoiceSalesRepresentativeList) {
        set(PROPERTY_INVOICESALESREPRESENTATIVELIST, invoiceSalesRepresentativeList);
    }

    @SuppressWarnings("unchecked")
    public List<Invoice> getInvoiceList() {
      return (List<Invoice>) get(PROPERTY_INVOICELIST);
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        set(PROPERTY_INVOICELIST, invoiceList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceLineV2> getInvoiceLineV2SalesRepresentativeList() {
      return (List<InvoiceLineV2>) get(PROPERTY_INVOICELINEV2SALESREPRESENTATIVELIST);
    }

    public void setInvoiceLineV2SalesRepresentativeList(List<InvoiceLineV2> invoiceLineV2SalesRepresentativeList) {
        set(PROPERTY_INVOICELINEV2SALESREPRESENTATIVELIST, invoiceLineV2SalesRepresentativeList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceV2> getInvoiceV2SalesRepresentativeList() {
      return (List<InvoiceV2>) get(PROPERTY_INVOICEV2SALESREPRESENTATIVELIST);
    }

    public void setInvoiceV2SalesRepresentativeList(List<InvoiceV2> invoiceV2SalesRepresentativeList) {
        set(PROPERTY_INVOICEV2SALESREPRESENTATIVELIST, invoiceV2SalesRepresentativeList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceV2> getInvoiceV2List() {
      return (List<InvoiceV2>) get(PROPERTY_INVOICEV2LIST);
    }

    public void setInvoiceV2List(List<InvoiceV2> invoiceV2List) {
        set(PROPERTY_INVOICEV2LIST, invoiceV2List);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.model.common.geography.Location> getLocationEMOpcrmAdUserIDList() {
      return (List<org.openbravo.model.common.geography.Location>) get(PROPERTY_LOCATIONEMOPCRMADUSERIDLIST);
    }

    public void setLocationEMOpcrmAdUserIDList(List<org.openbravo.model.common.geography.Location> locationEMOpcrmAdUserIDList) {
        set(PROPERTY_LOCATIONEMOPCRMADUSERIDLIST, locationEMOpcrmAdUserIDList);
    }

    @SuppressWarnings("unchecked")
    public List<MeasureShift> getManufacturingMeasureShiftList() {
      return (List<MeasureShift>) get(PROPERTY_MANUFACTURINGMEASURESHIFTLIST);
    }

    public void setManufacturingMeasureShiftList(List<MeasureShift> manufacturingMeasureShiftList) {
        set(PROPERTY_MANUFACTURINGMEASURESHIFTLIST, manufacturingMeasureShiftList);
    }

    @SuppressWarnings("unchecked")
    public List<Campaign> getMarketingCampaignEMOPCRMAssignedToList() {
      return (List<Campaign>) get(PROPERTY_MARKETINGCAMPAIGNEMOPCRMASSIGNEDTOLIST);
    }

    public void setMarketingCampaignEMOPCRMAssignedToList(List<Campaign> marketingCampaignEMOPCRMAssignedToList) {
        set(PROPERTY_MARKETINGCAMPAIGNEMOPCRMASSIGNEDTOLIST, marketingCampaignEMOPCRMAssignedToList);
    }

    @SuppressWarnings("unchecked")
    public List<Reservation> getMaterialMgmtReservationList() {
      return (List<Reservation>) get(PROPERTY_MATERIALMGMTRESERVATIONLIST);
    }

    public void setMaterialMgmtReservationList(List<Reservation> materialMgmtReservationList) {
        set(PROPERTY_MATERIALMGMTRESERVATIONLIST, materialMgmtReservationList);
    }

    @SuppressWarnings("unchecked")
    public List<ShipmentInOut> getMaterialMgmtShipmentInOutList() {
      return (List<ShipmentInOut>) get(PROPERTY_MATERIALMGMTSHIPMENTINOUTLIST);
    }

    public void setMaterialMgmtShipmentInOutList(List<ShipmentInOut> materialMgmtShipmentInOutList) {
        set(PROPERTY_MATERIALMGMTSHIPMENTINOUTLIST, materialMgmtShipmentInOutList);
    }

    @SuppressWarnings("unchecked")
    public List<ShipmentInOut> getMaterialMgmtShipmentInOutSalesRepresentativeList() {
      return (List<ShipmentInOut>) get(PROPERTY_MATERIALMGMTSHIPMENTINOUTSALESREPRESENTATIVELIST);
    }

    public void setMaterialMgmtShipmentInOutSalesRepresentativeList(List<ShipmentInOut> materialMgmtShipmentInOutSalesRepresentativeList) {
        set(PROPERTY_MATERIALMGMTSHIPMENTINOUTSALESREPRESENTATIVELIST, materialMgmtShipmentInOutSalesRepresentativeList);
    }

    @SuppressWarnings("unchecked")
    public List<WidgetInstance> getOBKMOWidgetInstanceVisibleAtUserList() {
      return (List<WidgetInstance>) get(PROPERTY_OBKMOWIDGETINSTANCEVISIBLEATUSERLIST);
    }

    public void setOBKMOWidgetInstanceVisibleAtUserList(List<WidgetInstance> oBKMOWidgetInstanceVisibleAtUserList) {
        set(PROPERTY_OBKMOWIDGETINSTANCEVISIBLEATUSERLIST, oBKMOWidgetInstanceVisibleAtUserList);
    }

    @SuppressWarnings("unchecked")
    public List<OBSOIDUserIdentifier> getOBSOIDUserIdentifierList() {
      return (List<OBSOIDUserIdentifier>) get(PROPERTY_OBSOIDUSERIDENTIFIERLIST);
    }

    public void setOBSOIDUserIdentifierList(List<OBSOIDUserIdentifier> oBSOIDUserIdentifierList) {
        set(PROPERTY_OBSOIDUSERIDENTIFIERLIST, oBSOIDUserIdentifierList);
    }

    @SuppressWarnings("unchecked")
    public List<UIPersonalization> getOBUIAPPUIPersonalizationList() {
      return (List<UIPersonalization>) get(PROPERTY_OBUIAPPUIPERSONALIZATIONLIST);
    }

    public void setOBUIAPPUIPersonalizationList(List<UIPersonalization> oBUIAPPUIPersonalizationList) {
        set(PROPERTY_OBUIAPPUIPERSONALIZATIONLIST, oBUIAPPUIPersonalizationList);
    }

    @SuppressWarnings("unchecked")
    public List<Order> getOrderSalesRepresentativeList() {
      return (List<Order>) get(PROPERTY_ORDERSALESREPRESENTATIVELIST);
    }

    public void setOrderSalesRepresentativeList(List<Order> orderSalesRepresentativeList) {
        set(PROPERTY_ORDERSALESREPRESENTATIVELIST, orderSalesRepresentativeList);
    }

    @SuppressWarnings("unchecked")
    public List<Order> getOrderList() {
      return (List<Order>) get(PROPERTY_ORDERLIST);
    }

    public void setOrderList(List<Order> orderList) {
        set(PROPERTY_ORDERLIST, orderList);
    }

    @SuppressWarnings("unchecked")
    public List<Order> getOrderDropShipContactList() {
      return (List<Order>) get(PROPERTY_ORDERDROPSHIPCONTACTLIST);
    }

    public void setOrderDropShipContactList(List<Order> orderDropShipContactList) {
        set(PROPERTY_ORDERDROPSHIPCONTACTLIST, orderDropShipContactList);
    }

    @SuppressWarnings("unchecked")
    public List<Order> getOrderEMOpcrmRelatedleadList() {
      return (List<Order>) get(PROPERTY_ORDEREMOPCRMRELATEDLEADLIST);
    }

    public void setOrderEMOpcrmRelatedleadList(List<Order> orderEMOpcrmRelatedleadList) {
        set(PROPERTY_ORDEREMOPCRMRELATEDLEADLIST, orderEMOpcrmRelatedleadList);
    }

    @SuppressWarnings("unchecked")
    public List<OrganizationInformation> getOrganizationInformationList() {
      return (List<OrganizationInformation>) get(PROPERTY_ORGANIZATIONINFORMATIONLIST);
    }

    public void setOrganizationInformationList(List<OrganizationInformation> organizationInformationList) {
        set(PROPERTY_ORGANIZATIONINFORMATIONLIST, organizationInformationList);
    }

    @SuppressWarnings("unchecked")
    public List<ProcessExecution> getProcessExecutionList() {
      return (List<ProcessExecution>) get(PROPERTY_PROCESSEXECUTIONLIST);
    }

    public void setProcessExecutionList(List<ProcessExecution> processExecutionList) {
        set(PROPERTY_PROCESSEXECUTIONLIST, processExecutionList);
    }

    @SuppressWarnings("unchecked")
    public List<ProcessGroupExecution> getProcessGroupExecutionList() {
      return (List<ProcessGroupExecution>) get(PROPERTY_PROCESSGROUPEXECUTIONLIST);
    }

    public void setProcessGroupExecutionList(List<ProcessGroupExecution> processGroupExecutionList) {
        set(PROPERTY_PROCESSGROUPEXECUTIONLIST, processGroupExecutionList);
    }

    @SuppressWarnings("unchecked")
    public List<ProcessRequest> getProcessRequestList() {
      return (List<ProcessRequest>) get(PROPERTY_PROCESSREQUESTLIST);
    }

    public void setProcessRequestList(List<ProcessRequest> processRequestList) {
        set(PROPERTY_PROCESSREQUESTLIST, processRequestList);
    }

    @SuppressWarnings("unchecked")
    public List<Requisition> getProcurementRequisitionList() {
      return (List<Requisition>) get(PROPERTY_PROCUREMENTREQUISITIONLIST);
    }

    public void setProcurementRequisitionList(List<Requisition> procurementRequisitionList) {
        set(PROPERTY_PROCUREMENTREQUISITIONLIST, procurementRequisitionList);
    }

    @SuppressWarnings("unchecked")
    public List<RequisitionLine> getProcurementRequisitionLineLockedByList() {
      return (List<RequisitionLine>) get(PROPERTY_PROCUREMENTREQUISITIONLINELOCKEDBYLIST);
    }

    public void setProcurementRequisitionLineLockedByList(List<RequisitionLine> procurementRequisitionLineLockedByList) {
        set(PROPERTY_PROCUREMENTREQUISITIONLINELOCKEDBYLIST, procurementRequisitionLineLockedByList);
    }

    @SuppressWarnings("unchecked")
    public List<Product> getProductSalesRepresentativeList() {
      return (List<Product>) get(PROPERTY_PRODUCTSALESREPRESENTATIVELIST);
    }

    public void setProductSalesRepresentativeList(List<Product> productSalesRepresentativeList) {
        set(PROPERTY_PRODUCTSALESREPRESENTATIVELIST, productSalesRepresentativeList);
    }

    @SuppressWarnings("unchecked")
    public List<Project> getProjectList() {
      return (List<Project>) get(PROPERTY_PROJECTLIST);
    }

    public void setProjectList(List<Project> projectList) {
        set(PROPERTY_PROJECTLIST, projectList);
    }

    @SuppressWarnings("unchecked")
    public List<Project> getProjectSalesRepresentativeList() {
      return (List<Project>) get(PROPERTY_PROJECTSALESREPRESENTATIVELIST);
    }

    public void setProjectSalesRepresentativeList(List<Project> projectSalesRepresentativeList) {
        set(PROPERTY_PROJECTSALESREPRESENTATIVELIST, projectSalesRepresentativeList);
    }

    @SuppressWarnings("unchecked")
    public List<ProjectProposalTask> getProjectProjectProposalTaskList() {
      return (List<ProjectProposalTask>) get(PROPERTY_PROJECTPROJECTPROPOSALTASKLIST);
    }

    public void setProjectProjectProposalTaskList(List<ProjectProposalTask> projectProjectProposalTaskList) {
        set(PROPERTY_PROJECTPROJECTPROPOSALTASKLIST, projectProjectProposalTaskList);
    }

    @SuppressWarnings("unchecked")
    public List<ProjectProposal> getProjectProposalList() {
      return (List<ProjectProposal>) get(PROPERTY_PROJECTPROPOSALLIST);
    }

    public void setProjectProposalList(List<ProjectProposal> projectProposalList) {
        set(PROPERTY_PROJECTPROPOSALLIST, projectProposalList);
    }

    @SuppressWarnings("unchecked")
    public List<Resource> getResourceList() {
      return (List<Resource>) get(PROPERTY_RESOURCELIST);
    }

    public void setResourceList(List<Resource> resourceList) {
        set(PROPERTY_RESOURCELIST, resourceList);
    }

    @SuppressWarnings("unchecked")
    public List<SBPCInfoPartnersV> getSBPCInfoPartnersVList() {
      return (List<SBPCInfoPartnersV>) get(PROPERTY_SBPCINFOPARTNERSVLIST);
    }

    public void setSBPCInfoPartnersVList(List<SBPCInfoPartnersV> sBPCInfoPartnersVList) {
        set(PROPERTY_SBPCINFOPARTNERSVLIST, sBPCInfoPartnersVList);
    }

    @SuppressWarnings("unchecked")
    public List<SBPCInfoPartnersV> getSBPCInfoPartnersVADUserIdEmailList() {
      return (List<SBPCInfoPartnersV>) get(PROPERTY_SBPCINFOPARTNERSVADUSERIDEMAILLIST);
    }

    public void setSBPCInfoPartnersVADUserIdEmailList(List<SBPCInfoPartnersV> sBPCInfoPartnersVADUserIdEmailList) {
        set(PROPERTY_SBPCINFOPARTNERSVADUSERIDEMAILLIST, sBPCInfoPartnersVADUserIdEmailList);
    }

    @SuppressWarnings("unchecked")
    public List<SBPCInfoPartnersV> getSBPCInfoPartnersVADUserIdPhone1List() {
      return (List<SBPCInfoPartnersV>) get(PROPERTY_SBPCINFOPARTNERSVADUSERIDPHONE1LIST);
    }

    public void setSBPCInfoPartnersVADUserIdPhone1List(List<SBPCInfoPartnersV> sBPCInfoPartnersVADUserIdPhone1List) {
        set(PROPERTY_SBPCINFOPARTNERSVADUSERIDPHONE1LIST, sBPCInfoPartnersVADUserIdPhone1List);
    }

    @SuppressWarnings("unchecked")
    public List<SBPCInfoPartnersV> getSBPCInfoPartnersVADUserIdPhone2List() {
      return (List<SBPCInfoPartnersV>) get(PROPERTY_SBPCINFOPARTNERSVADUSERIDPHONE2LIST);
    }

    public void setSBPCInfoPartnersVADUserIdPhone2List(List<SBPCInfoPartnersV> sBPCInfoPartnersVADUserIdPhone2List) {
        set(PROPERTY_SBPCINFOPARTNERSVADUSERIDPHONE2LIST, sBPCInfoPartnersVADUserIdPhone2List);
    }

    @SuppressWarnings("unchecked")
    public List<SRSISalesInvoiceV> getSRSISalesInvoiceVList() {
      return (List<SRSISalesInvoiceV>) get(PROPERTY_SRSISALESINVOICEVLIST);
    }

    public void setSRSISalesInvoiceVList(List<SRSISalesInvoiceV> sRSISalesInvoiceVList) {
        set(PROPERTY_SRSISALESINVOICEVLIST, sRSISalesInvoiceVList);
    }

    @SuppressWarnings("unchecked")
    public List<SWSICConfig> getSWSICConfigList() {
      return (List<SWSICConfig>) get(PROPERTY_SWSICCONFIGLIST);
    }

    public void setSWSICConfigList(List<SWSICConfig> sWSICConfigList) {
        set(PROPERTY_SWSICCONFIGLIST, sWSICConfigList);
    }

    @SuppressWarnings("unchecked")
    public List<SalesRegion> getSalesRegionSalesRepresentativeList() {
      return (List<SalesRegion>) get(PROPERTY_SALESREGIONSALESREPRESENTATIVELIST);
    }

    public void setSalesRegionSalesRepresentativeList(List<SalesRegion> salesRegionSalesRepresentativeList) {
        set(PROPERTY_SALESREGIONSALESREPRESENTATIVELIST, salesRegionSalesRepresentativeList);
    }

    @SuppressWarnings("unchecked")
    public List<AuthorizationLevel> getEcsapAuthorizationLevelList() {
      return (List<AuthorizationLevel>) get(PROPERTY_ECSAPAUTHORIZATIONLEVELLIST);
    }

    public void setEcsapAuthorizationLevelList(List<AuthorizationLevel> ecsapAuthorizationLevelList) {
        set(PROPERTY_ECSAPAUTHORIZATIONLEVELLIST, ecsapAuthorizationLevelList);
    }

    @SuppressWarnings("unchecked")
    public List<Opcrmactivity> getOpcrmActivityAssignedToList() {
      return (List<Opcrmactivity>) get(PROPERTY_OPCRMACTIVITYASSIGNEDTOLIST);
    }

    public void setOpcrmActivityAssignedToList(List<Opcrmactivity> opcrmActivityAssignedToList) {
        set(PROPERTY_OPCRMACTIVITYASSIGNEDTOLIST, opcrmActivityAssignedToList);
    }

    @SuppressWarnings("unchecked")
    public List<Opcrmactivity> getOpcrmActivityRelatedLeadList() {
      return (List<Opcrmactivity>) get(PROPERTY_OPCRMACTIVITYRELATEDLEADLIST);
    }

    public void setOpcrmActivityRelatedLeadList(List<Opcrmactivity> opcrmActivityRelatedLeadList) {
        set(PROPERTY_OPCRMACTIVITYRELATEDLEADLIST, opcrmActivityRelatedLeadList);
    }

    @SuppressWarnings("unchecked")
    public List<Opcrmcase> getOpcrmCasesAssignedToList() {
      return (List<Opcrmcase>) get(PROPERTY_OPCRMCASESASSIGNEDTOLIST);
    }

    public void setOpcrmCasesAssignedToList(List<Opcrmcase> opcrmCasesAssignedToList) {
        set(PROPERTY_OPCRMCASESASSIGNEDTOLIST, opcrmCasesAssignedToList);
    }

    @SuppressWarnings("unchecked")
    public List<Opcrmcase> getOpcrmCasesRelatedLeadList() {
      return (List<Opcrmcase>) get(PROPERTY_OPCRMCASESRELATEDLEADLIST);
    }

    public void setOpcrmCasesRelatedLeadList(List<Opcrmcase> opcrmCasesRelatedLeadList) {
        set(PROPERTY_OPCRMCASESRELATEDLEADLIST, opcrmCasesRelatedLeadList);
    }

    @SuppressWarnings("unchecked")
    public List<Opcrmcase> getOpcrmCasesCaseCreatedbyList() {
      return (List<Opcrmcase>) get(PROPERTY_OPCRMCASESCASECREATEDBYLIST);
    }

    public void setOpcrmCasesCaseCreatedbyList(List<Opcrmcase> opcrmCasesCaseCreatedbyList) {
        set(PROPERTY_OPCRMCASESCASECREATEDBYLIST, opcrmCasesCaseCreatedbyList);
    }

    @SuppressWarnings("unchecked")
    public List<opcrmCasesAccess> getOpcrmCasesAccessList() {
      return (List<opcrmCasesAccess>) get(PROPERTY_OPCRMCASESACCESSLIST);
    }

    public void setOpcrmCasesAccessList(List<opcrmCasesAccess> opcrmCasesAccessList) {
        set(PROPERTY_OPCRMCASESACCESSLIST, opcrmCasesAccessList);
    }

    @SuppressWarnings("unchecked")
    public List<OpcrmConfig> getOpcrmConfigList() {
      return (List<OpcrmConfig>) get(PROPERTY_OPCRMCONFIGLIST);
    }

    public void setOpcrmConfigList(List<OpcrmConfig> opcrmConfigList) {
        set(PROPERTY_OPCRMCONFIGLIST, opcrmConfigList);
    }

    @SuppressWarnings("unchecked")
    public List<OpcrmFuncinterestviewV> getOpcrmFuncinterestviewVList() {
      return (List<OpcrmFuncinterestviewV>) get(PROPERTY_OPCRMFUNCINTERESTVIEWVLIST);
    }

    public void setOpcrmFuncinterestviewVList(List<OpcrmFuncinterestviewV> opcrmFuncinterestviewVList) {
        set(PROPERTY_OPCRMFUNCINTERESTVIEWVLIST, opcrmFuncinterestviewVList);
    }

    @SuppressWarnings("unchecked")
    public List<OpcrmFuncinterestviewV> getOpcrmFuncinterestviewVAssignedToList() {
      return (List<OpcrmFuncinterestviewV>) get(PROPERTY_OPCRMFUNCINTERESTVIEWVASSIGNEDTOLIST);
    }

    public void setOpcrmFuncinterestviewVAssignedToList(List<OpcrmFuncinterestviewV> opcrmFuncinterestviewVAssignedToList) {
        set(PROPERTY_OPCRMFUNCINTERESTVIEWVASSIGNEDTOLIST, opcrmFuncinterestviewVAssignedToList);
    }

    @SuppressWarnings("unchecked")
    public List<opcrmGuest> getOpcrmGuestList() {
      return (List<opcrmGuest>) get(PROPERTY_OPCRMGUESTLIST);
    }

    public void setOpcrmGuestList(List<opcrmGuest> opcrmGuestList) {
        set(PROPERTY_OPCRMGUESTLIST, opcrmGuestList);
    }

    @SuppressWarnings("unchecked")
    public List<opcrmLeadAccess> getOpcrmLeadAccessList() {
      return (List<opcrmLeadAccess>) get(PROPERTY_OPCRMLEADACCESSLIST);
    }

    public void setOpcrmLeadAccessList(List<opcrmLeadAccess> opcrmLeadAccessList) {
        set(PROPERTY_OPCRMLEADACCESSLIST, opcrmLeadAccessList);
    }

    @SuppressWarnings("unchecked")
    public List<opcrmLeadAccess> getOpcrmLeadAccessCRMUserIDList() {
      return (List<opcrmLeadAccess>) get(PROPERTY_OPCRMLEADACCESSCRMUSERIDLIST);
    }

    public void setOpcrmLeadAccessCRMUserIDList(List<opcrmLeadAccess> opcrmLeadAccessCRMUserIDList) {
        set(PROPERTY_OPCRMLEADACCESSCRMUSERIDLIST, opcrmLeadAccessCRMUserIDList);
    }

    @SuppressWarnings("unchecked")
    public List<opcrmLeadActivity> getOpcrmLeadActivityList() {
      return (List<opcrmLeadActivity>) get(PROPERTY_OPCRMLEADACTIVITYLIST);
    }

    public void setOpcrmLeadActivityList(List<opcrmLeadActivity> opcrmLeadActivityList) {
        set(PROPERTY_OPCRMLEADACTIVITYLIST, opcrmLeadActivityList);
    }

    @SuppressWarnings("unchecked")
    public List<OpcrmLeadToInterests> getOpcrmLeadtointerestsList() {
      return (List<OpcrmLeadToInterests>) get(PROPERTY_OPCRMLEADTOINTERESTSLIST);
    }

    public void setOpcrmLeadtointerestsList(List<OpcrmLeadToInterests> opcrmLeadtointerestsList) {
        set(PROPERTY_OPCRMLEADTOINTERESTSLIST, opcrmLeadtointerestsList);
    }

    @SuppressWarnings("unchecked")
    public List<OpcrmLocationviewV> getOpcrmLocationviewVList() {
      return (List<OpcrmLocationviewV>) get(PROPERTY_OPCRMLOCATIONVIEWVLIST);
    }

    public void setOpcrmLocationviewVList(List<OpcrmLocationviewV> opcrmLocationviewVList) {
        set(PROPERTY_OPCRMLOCATIONVIEWVLIST, opcrmLocationviewVList);
    }

    @SuppressWarnings("unchecked")
    public List<OpcrmLocationviewV> getOpcrmLocationviewVAssignedToList() {
      return (List<OpcrmLocationviewV>) get(PROPERTY_OPCRMLOCATIONVIEWVASSIGNEDTOLIST);
    }

    public void setOpcrmLocationviewVAssignedToList(List<OpcrmLocationviewV> opcrmLocationviewVAssignedToList) {
        set(PROPERTY_OPCRMLOCATIONVIEWVASSIGNEDTOLIST, opcrmLocationviewVAssignedToList);
    }

    @SuppressWarnings("unchecked")
    public List<opcrmOppAccess> getOpcrmOppAccessList() {
      return (List<opcrmOppAccess>) get(PROPERTY_OPCRMOPPACCESSLIST);
    }

    public void setOpcrmOppAccessList(List<opcrmOppAccess> opcrmOppAccessList) {
        set(PROPERTY_OPCRMOPPACCESSLIST, opcrmOppAccessList);
    }

    @SuppressWarnings("unchecked")
    public List<Opcrmopportunities> getOpcrmOpportunitiesAssignedToList() {
      return (List<Opcrmopportunities>) get(PROPERTY_OPCRMOPPORTUNITIESASSIGNEDTOLIST);
    }

    public void setOpcrmOpportunitiesAssignedToList(List<Opcrmopportunities> opcrmOpportunitiesAssignedToList) {
        set(PROPERTY_OPCRMOPPORTUNITIESASSIGNEDTOLIST, opcrmOpportunitiesAssignedToList);
    }

    @SuppressWarnings("unchecked")
    public List<Opcrmopportunities> getOpcrmOpportunitiesRelatedLeadList() {
      return (List<Opcrmopportunities>) get(PROPERTY_OPCRMOPPORTUNITIESRELATEDLEADLIST);
    }

    public void setOpcrmOpportunitiesRelatedLeadList(List<Opcrmopportunities> opcrmOpportunitiesRelatedLeadList) {
        set(PROPERTY_OPCRMOPPORTUNITIESRELATEDLEADLIST, opcrmOpportunitiesRelatedLeadList);
    }

    @SuppressWarnings("unchecked")
    public List<OpcrmRecentlyupdatedV> getOpcrmRecentlyupdatedVList() {
      return (List<OpcrmRecentlyupdatedV>) get(PROPERTY_OPCRMRECENTLYUPDATEDVLIST);
    }

    public void setOpcrmRecentlyupdatedVList(List<OpcrmRecentlyupdatedV> opcrmRecentlyupdatedVList) {
        set(PROPERTY_OPCRMRECENTLYUPDATEDVLIST, opcrmRecentlyupdatedVList);
    }

    @SuppressWarnings("unchecked")
    public List<OpcrmRecentlyupdatedV> getOpcrmRecentlyupdatedVAssignedToList() {
      return (List<OpcrmRecentlyupdatedV>) get(PROPERTY_OPCRMRECENTLYUPDATEDVASSIGNEDTOLIST);
    }

    public void setOpcrmRecentlyupdatedVAssignedToList(List<OpcrmRecentlyupdatedV> opcrmRecentlyupdatedVAssignedToList) {
        set(PROPERTY_OPCRMRECENTLYUPDATEDVASSIGNEDTOLIST, opcrmRecentlyupdatedVAssignedToList);
    }

    @SuppressWarnings("unchecked")
    public List<OpcrmSuperact> getOpcrmSuperactList() {
      return (List<OpcrmSuperact>) get(PROPERTY_OPCRMSUPERACTLIST);
    }

    public void setOpcrmSuperactList(List<OpcrmSuperact> opcrmSuperactList) {
        set(PROPERTY_OPCRMSUPERACTLIST, opcrmSuperactList);
    }

    @SuppressWarnings("unchecked")
    public List<OpcrmSupercase> getOpcrmSupercaseList() {
      return (List<OpcrmSupercase>) get(PROPERTY_OPCRMSUPERCASELIST);
    }

    public void setOpcrmSupercaseList(List<OpcrmSupercase> opcrmSupercaseList) {
        set(PROPERTY_OPCRMSUPERCASELIST, opcrmSupercaseList);
    }

    @SuppressWarnings("unchecked")
    public List<OpcrmSuperopp> getOpcrmSuperoppList() {
      return (List<OpcrmSuperopp>) get(PROPERTY_OPCRMSUPEROPPLIST);
    }

    public void setOpcrmSuperoppList(List<OpcrmSuperopp> opcrmSuperoppList) {
        set(PROPERTY_OPCRMSUPEROPPLIST, opcrmSuperoppList);
    }

    @SuppressWarnings("unchecked")
    public List<OpcrmSuperusers> getOpcrmSuperusersList() {
      return (List<OpcrmSuperusers>) get(PROPERTY_OPCRMSUPERUSERSLIST);
    }

    public void setOpcrmSuperusersList(List<OpcrmSuperusers> opcrmSuperusersList) {
        set(PROPERTY_OPCRMSUPERUSERSLIST, opcrmSuperusersList);
    }

    @SuppressWarnings("unchecked")
    public List<SdbrlcCostcenterDim> getSdbrlCCostcenterDimList() {
      return (List<SdbrlcCostcenterDim>) get(PROPERTY_SDBRLCCOSTCENTERDIMLIST);
    }

    public void setSdbrlCCostcenterDimList(List<SdbrlcCostcenterDim> sdbrlCCostcenterDimList) {
        set(PROPERTY_SDBRLCCOSTCENTERDIMLIST, sdbrlCCostcenterDimList);
    }

    @SuppressWarnings("unchecked")
    public List<SdbrlUser1Dim> getSdbrlUser1DimList() {
      return (List<SdbrlUser1Dim>) get(PROPERTY_SDBRLUSER1DIMLIST);
    }

    public void setSdbrlUser1DimList(List<SdbrlUser1Dim> sdbrlUser1DimList) {
        set(PROPERTY_SDBRLUSER1DIMLIST, sdbrlUser1DimList);
    }

    @SuppressWarnings("unchecked")
    public List<SFBBudgetCertificate> getSfbBudgetCertificateList() {
      return (List<SFBBudgetCertificate>) get(PROPERTY_SFBBUDGETCERTIFICATELIST);
    }

    public void setSfbBudgetCertificateList(List<SFBBudgetCertificate> sfbBudgetCertificateList) {
        set(PROPERTY_SFBBUDGETCERTIFICATELIST, sfbBudgetCertificateList);
    }

    @SuppressWarnings("unchecked")
    public List<SFBBudgetUserArea> getSfbBudgetUserAreaList() {
      return (List<SFBBudgetUserArea>) get(PROPERTY_SFBBUDGETUSERAREALIST);
    }

    public void setSfbBudgetUserAreaList(List<SFBBudgetUserArea> sfbBudgetUserAreaList) {
        set(PROPERTY_SFBBUDGETUSERAREALIST, sfbBudgetUserAreaList);
    }

    @SuppressWarnings("unchecked")
    public List<SqbConfigUser> getSqbConfigUserList() {
      return (List<SqbConfigUser>) get(PROPERTY_SQBCONFIGUSERLIST);
    }

    public void setSqbConfigUserList(List<SqbConfigUser> sqbConfigUserList) {
        set(PROPERTY_SQBCONFIGUSERLIST, sqbConfigUserList);
    }

    @SuppressWarnings("unchecked")
    public List<SsfiFinancialUser> getSsfiFinancialUserList() {
      return (List<SsfiFinancialUser>) get(PROPERTY_SSFIFINANCIALUSERLIST);
    }

    public void setSsfiFinancialUserList(List<SsfiFinancialUser> ssfiFinancialUserList) {
        set(PROPERTY_SSFIFINANCIALUSERLIST, ssfiFinancialUserList);
    }

}
