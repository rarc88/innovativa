//Sqlc generated V1.O00-1
package ec.cusoft.facturaec.ad_process.PrintElectronicDocuments;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class ReportPrintElectronicInvoiceData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportPrintElectronicInvoiceData.class);
  private String InitRecordNumber="0";
  public String cInvoiceId;
  public String adClientId;
  public String adOrgId;
  public String isactive;
  public String created;
  public String createdby;
  public String updated;
  public String updatedby;
  public String issotrx;
  public String documentno;
  public String docstatus;
  public String docaction;
  public String processing;
  public String processed;
  public String posted;
  public String cDoctypeId;
  public String cDoctypetargetId;
  public String cOrderId;
  public String description;
  public String isprinted;
  public String salesrepId;
  public String dateinvoiced;
  public String dateprinted;
  public String dateacct;
  public String cBpartnerId;
  public String cBpartnerLocationId;
  public String poreference;
  public String isdiscountprinted;
  public String dateordered;
  public String cCurrencyId;
  public String paymentrule;
  public String cPaymenttermId;
  public String cChargeId;
  public String chargeamt;
  public String totallines;
  public String grandtotal;
  public String mPricelistId;
  public String istaxincluded;
  public String cCampaignId;
  public String cProjectId;
  public String cActivityId;
  public String createfrom;
  public String generateto;
  public String adUserId;
  public String copyfrom;
  public String isselfservice;
  public String adOrgtrxId;
  public String user1Id;
  public String user2Id;
  public String withholdingamount;
  public String taxdate;
  public String cWithholdingId;
  public String ispaid;
  public String totalpaid;
  public String outstandingamt;
  public String daystilldue;
  public String dueamt;
  public String lastcalculatedondate;
  public String updatepaymentmonitor;
  public String finPaymentmethodId;
  public String finPaymentPriorityId;
  public String finalsettlement;
  public String daysoutstanding;
  public String percentageoverdue;
  public String cCostcenterId;
  public String calculatePromotions;
  public String aAssetId;
  public String iscashvat;
  public String emSfbHashcode;
  public String emSfbIsnotbudgetable;
  public String emSfbBudgetAreaId;
  public String emSfbIsbudgeted;
  public String emSsflBillingPeriodFrom;
  public String emSsflBillingPeriodTo;
  public String emSsflIsforeign;
  public String emSsflBankId;
  public String emSsflObservation;
  public String emSsflInvoiceReference;
  public String emSsflTypeRecap;
  public String emSsflPrintTypeRecap;
  public String emSsflDescriptionvoyage;
  public String emSsflRevised;
  public String emSsflDeferred;
  public String emSipcIsTaxExpence;
  public String emSlciShipperId;
  public String emSsreRefundedId;
  public String emSsreCBpartnerId;
  public String emSsreIsrefund;
  public String emSswhTotalwithholdingincome;
  public String emSswhTotalwithholdingvat;
  public String emSswhReceiptId;
  public String emSswhNroauthorization;
  public String emSswhExpirationdate;
  public String emSswhLivelihood;
  public String emSswhCodelivelihood;
  public String emSswhWithholdingref;
  public String emSswhAuthorization;
  public String emSswhDatewithhold;
  public String emSswhCreditnote;
  public String emSswhDateendinvoice;
  public String emSswhInvoiceRef;
  public String emSswhKeyei;
  public String emSswhIseinvoice;
  public String emSswhCDoctypeId;
  public String emSswhBankaccountId;
  public String emSswhWithholdingmanual;
  public String emSswhAuthorizationmanual;
  public String emSswhCreditnotereference;
  public String emScnrInvoiceId;
  public String emScnrIsrefInv;
  public String emSqbQuickbillingId;
  public String emEeiCodigo;
  public String emEeiNumauto;
  public String emEeiFechaauto;
  public String emEeiFechaautotext;
  public String emEeiGenerated;
  public String emEeiSent;
  public String emEeiEdocument;
  public String emEeiRsiAuthNo;
  public String emEeiCreditnote;
  public String emEeiIsInvRef;
  public String emEeiRefInvId;
  public String emEeiDebitnote;
  public String emEeiWithholdingSend;
  public String emEeiUrlxml;
  public String emEeiUrlride;
  public String emEeiStatus;
  public String emEeiTemporalsend;
  public String emEeiResendinvoice;
  public String emEeiGenerateOffline;
  public String emAprmAddpayment;
  public String emAprmProcessinvoice;
  public String prepaymentamt;
  public String emSfbIsdeferred;
  public String emSfbDifferWithinYear;
  public String emSsreLockdate;
  public String emSsreIsrefunded;
  public String emSsreLockedby;
  public String emSpincoTaxid;
  public String emEeiDescription;
  public String emEcsapSigned;
  public String emEcsapSign;
  public String emEcsapAuthorization;
  public String emEcsapAuthLevelId;
  public String emEcsapReject;
  public String emEeiStatus2;
  public String emEeiCodigo2;
  public String emEeiUrlxml2;
  public String emEeiUrlride2;
  public String emEeiNumauto2;
  public String emEeiFechaautotext2;
  public String emEeiGenerateOffline2;
  public String emEeiResendinvoice2;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_invoice_id") || fieldName.equals("cInvoiceId"))
      return cInvoiceId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("created"))
      return created;
    else if (fieldName.equalsIgnoreCase("createdby"))
      return createdby;
    else if (fieldName.equalsIgnoreCase("updated"))
      return updated;
    else if (fieldName.equalsIgnoreCase("updatedby"))
      return updatedby;
    else if (fieldName.equalsIgnoreCase("issotrx"))
      return issotrx;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("docstatus"))
      return docstatus;
    else if (fieldName.equalsIgnoreCase("docaction"))
      return docaction;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
    else if (fieldName.equalsIgnoreCase("posted"))
      return posted;
    else if (fieldName.equalsIgnoreCase("c_doctype_id") || fieldName.equals("cDoctypeId"))
      return cDoctypeId;
    else if (fieldName.equalsIgnoreCase("c_doctypetarget_id") || fieldName.equals("cDoctypetargetId"))
      return cDoctypetargetId;
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("isprinted"))
      return isprinted;
    else if (fieldName.equalsIgnoreCase("salesrep_id") || fieldName.equals("salesrepId"))
      return salesrepId;
    else if (fieldName.equalsIgnoreCase("dateinvoiced"))
      return dateinvoiced;
    else if (fieldName.equalsIgnoreCase("dateprinted"))
      return dateprinted;
    else if (fieldName.equalsIgnoreCase("dateacct"))
      return dateacct;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("poreference"))
      return poreference;
    else if (fieldName.equalsIgnoreCase("isdiscountprinted"))
      return isdiscountprinted;
    else if (fieldName.equalsIgnoreCase("dateordered"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("paymentrule"))
      return paymentrule;
    else if (fieldName.equalsIgnoreCase("c_paymentterm_id") || fieldName.equals("cPaymenttermId"))
      return cPaymenttermId;
    else if (fieldName.equalsIgnoreCase("c_charge_id") || fieldName.equals("cChargeId"))
      return cChargeId;
    else if (fieldName.equalsIgnoreCase("chargeamt"))
      return chargeamt;
    else if (fieldName.equalsIgnoreCase("totallines"))
      return totallines;
    else if (fieldName.equalsIgnoreCase("grandtotal"))
      return grandtotal;
    else if (fieldName.equalsIgnoreCase("m_pricelist_id") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("istaxincluded"))
      return istaxincluded;
    else if (fieldName.equalsIgnoreCase("c_campaign_id") || fieldName.equals("cCampaignId"))
      return cCampaignId;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_activity_id") || fieldName.equals("cActivityId"))
      return cActivityId;
    else if (fieldName.equalsIgnoreCase("createfrom"))
      return createfrom;
    else if (fieldName.equalsIgnoreCase("generateto"))
      return generateto;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("copyfrom"))
      return copyfrom;
    else if (fieldName.equalsIgnoreCase("isselfservice"))
      return isselfservice;
    else if (fieldName.equalsIgnoreCase("ad_orgtrx_id") || fieldName.equals("adOrgtrxId"))
      return adOrgtrxId;
    else if (fieldName.equalsIgnoreCase("user1_id") || fieldName.equals("user1Id"))
      return user1Id;
    else if (fieldName.equalsIgnoreCase("user2_id") || fieldName.equals("user2Id"))
      return user2Id;
    else if (fieldName.equalsIgnoreCase("withholdingamount"))
      return withholdingamount;
    else if (fieldName.equalsIgnoreCase("taxdate"))
      return taxdate;
    else if (fieldName.equalsIgnoreCase("c_withholding_id") || fieldName.equals("cWithholdingId"))
      return cWithholdingId;
    else if (fieldName.equalsIgnoreCase("ispaid"))
      return ispaid;
    else if (fieldName.equalsIgnoreCase("totalpaid"))
      return totalpaid;
    else if (fieldName.equalsIgnoreCase("outstandingamt"))
      return outstandingamt;
    else if (fieldName.equalsIgnoreCase("daystilldue"))
      return daystilldue;
    else if (fieldName.equalsIgnoreCase("dueamt"))
      return dueamt;
    else if (fieldName.equalsIgnoreCase("lastcalculatedondate"))
      return lastcalculatedondate;
    else if (fieldName.equalsIgnoreCase("updatepaymentmonitor"))
      return updatepaymentmonitor;
    else if (fieldName.equalsIgnoreCase("fin_paymentmethod_id") || fieldName.equals("finPaymentmethodId"))
      return finPaymentmethodId;
    else if (fieldName.equalsIgnoreCase("fin_payment_priority_id") || fieldName.equals("finPaymentPriorityId"))
      return finPaymentPriorityId;
    else if (fieldName.equalsIgnoreCase("finalsettlement"))
      return finalsettlement;
    else if (fieldName.equalsIgnoreCase("daysoutstanding"))
      return daysoutstanding;
    else if (fieldName.equalsIgnoreCase("percentageoverdue"))
      return percentageoverdue;
    else if (fieldName.equalsIgnoreCase("c_costcenter_id") || fieldName.equals("cCostcenterId"))
      return cCostcenterId;
    else if (fieldName.equalsIgnoreCase("calculate_promotions") || fieldName.equals("calculatePromotions"))
      return calculatePromotions;
    else if (fieldName.equalsIgnoreCase("a_asset_id") || fieldName.equals("aAssetId"))
      return aAssetId;
    else if (fieldName.equalsIgnoreCase("iscashvat"))
      return iscashvat;
    else if (fieldName.equalsIgnoreCase("em_sfb_hashcode") || fieldName.equals("emSfbHashcode"))
      return emSfbHashcode;
    else if (fieldName.equalsIgnoreCase("em_sfb_isnotbudgetable") || fieldName.equals("emSfbIsnotbudgetable"))
      return emSfbIsnotbudgetable;
    else if (fieldName.equalsIgnoreCase("em_sfb_budget_area_id") || fieldName.equals("emSfbBudgetAreaId"))
      return emSfbBudgetAreaId;
    else if (fieldName.equalsIgnoreCase("em_sfb_isbudgeted") || fieldName.equals("emSfbIsbudgeted"))
      return emSfbIsbudgeted;
    else if (fieldName.equalsIgnoreCase("em_ssfl_billing_period_from") || fieldName.equals("emSsflBillingPeriodFrom"))
      return emSsflBillingPeriodFrom;
    else if (fieldName.equalsIgnoreCase("em_ssfl_billing_period_to") || fieldName.equals("emSsflBillingPeriodTo"))
      return emSsflBillingPeriodTo;
    else if (fieldName.equalsIgnoreCase("em_ssfl_isforeign") || fieldName.equals("emSsflIsforeign"))
      return emSsflIsforeign;
    else if (fieldName.equalsIgnoreCase("em_ssfl_bank_id") || fieldName.equals("emSsflBankId"))
      return emSsflBankId;
    else if (fieldName.equalsIgnoreCase("em_ssfl_observation") || fieldName.equals("emSsflObservation"))
      return emSsflObservation;
    else if (fieldName.equalsIgnoreCase("em_ssfl_invoice_reference") || fieldName.equals("emSsflInvoiceReference"))
      return emSsflInvoiceReference;
    else if (fieldName.equalsIgnoreCase("em_ssfl_type_recap") || fieldName.equals("emSsflTypeRecap"))
      return emSsflTypeRecap;
    else if (fieldName.equalsIgnoreCase("em_ssfl_print_type_recap") || fieldName.equals("emSsflPrintTypeRecap"))
      return emSsflPrintTypeRecap;
    else if (fieldName.equalsIgnoreCase("em_ssfl_descriptionvoyage") || fieldName.equals("emSsflDescriptionvoyage"))
      return emSsflDescriptionvoyage;
    else if (fieldName.equalsIgnoreCase("em_ssfl_revised") || fieldName.equals("emSsflRevised"))
      return emSsflRevised;
    else if (fieldName.equalsIgnoreCase("em_ssfl_deferred") || fieldName.equals("emSsflDeferred"))
      return emSsflDeferred;
    else if (fieldName.equalsIgnoreCase("em_sipc_is_tax_expence") || fieldName.equals("emSipcIsTaxExpence"))
      return emSipcIsTaxExpence;
    else if (fieldName.equalsIgnoreCase("em_slci_shipper_id") || fieldName.equals("emSlciShipperId"))
      return emSlciShipperId;
    else if (fieldName.equalsIgnoreCase("em_ssre_refunded_id") || fieldName.equals("emSsreRefundedId"))
      return emSsreRefundedId;
    else if (fieldName.equalsIgnoreCase("em_ssre_c_bpartner_id") || fieldName.equals("emSsreCBpartnerId"))
      return emSsreCBpartnerId;
    else if (fieldName.equalsIgnoreCase("em_ssre_isrefund") || fieldName.equals("emSsreIsrefund"))
      return emSsreIsrefund;
    else if (fieldName.equalsIgnoreCase("em_sswh_totalwithholdingincome") || fieldName.equals("emSswhTotalwithholdingincome"))
      return emSswhTotalwithholdingincome;
    else if (fieldName.equalsIgnoreCase("em_sswh_totalwithholdingvat") || fieldName.equals("emSswhTotalwithholdingvat"))
      return emSswhTotalwithholdingvat;
    else if (fieldName.equalsIgnoreCase("em_sswh_receipt_id") || fieldName.equals("emSswhReceiptId"))
      return emSswhReceiptId;
    else if (fieldName.equalsIgnoreCase("em_sswh_nroauthorization") || fieldName.equals("emSswhNroauthorization"))
      return emSswhNroauthorization;
    else if (fieldName.equalsIgnoreCase("em_sswh_expirationdate") || fieldName.equals("emSswhExpirationdate"))
      return emSswhExpirationdate;
    else if (fieldName.equalsIgnoreCase("em_sswh_livelihood") || fieldName.equals("emSswhLivelihood"))
      return emSswhLivelihood;
    else if (fieldName.equalsIgnoreCase("em_sswh_codelivelihood") || fieldName.equals("emSswhCodelivelihood"))
      return emSswhCodelivelihood;
    else if (fieldName.equalsIgnoreCase("em_sswh_withholdingref") || fieldName.equals("emSswhWithholdingref"))
      return emSswhWithholdingref;
    else if (fieldName.equalsIgnoreCase("em_sswh_authorization") || fieldName.equals("emSswhAuthorization"))
      return emSswhAuthorization;
    else if (fieldName.equalsIgnoreCase("em_sswh_datewithhold") || fieldName.equals("emSswhDatewithhold"))
      return emSswhDatewithhold;
    else if (fieldName.equalsIgnoreCase("em_sswh_creditnote") || fieldName.equals("emSswhCreditnote"))
      return emSswhCreditnote;
    else if (fieldName.equalsIgnoreCase("em_sswh_dateendinvoice") || fieldName.equals("emSswhDateendinvoice"))
      return emSswhDateendinvoice;
    else if (fieldName.equalsIgnoreCase("em_sswh_invoice_ref") || fieldName.equals("emSswhInvoiceRef"))
      return emSswhInvoiceRef;
    else if (fieldName.equalsIgnoreCase("em_sswh_keyei") || fieldName.equals("emSswhKeyei"))
      return emSswhKeyei;
    else if (fieldName.equalsIgnoreCase("em_sswh_iseinvoice") || fieldName.equals("emSswhIseinvoice"))
      return emSswhIseinvoice;
    else if (fieldName.equalsIgnoreCase("em_sswh_c_doctype_id") || fieldName.equals("emSswhCDoctypeId"))
      return emSswhCDoctypeId;
    else if (fieldName.equalsIgnoreCase("em_sswh_bankaccount_id") || fieldName.equals("emSswhBankaccountId"))
      return emSswhBankaccountId;
    else if (fieldName.equalsIgnoreCase("em_sswh_withholdingmanual") || fieldName.equals("emSswhWithholdingmanual"))
      return emSswhWithholdingmanual;
    else if (fieldName.equalsIgnoreCase("em_sswh_authorizationmanual") || fieldName.equals("emSswhAuthorizationmanual"))
      return emSswhAuthorizationmanual;
    else if (fieldName.equalsIgnoreCase("em_sswh_creditnotereference") || fieldName.equals("emSswhCreditnotereference"))
      return emSswhCreditnotereference;
    else if (fieldName.equalsIgnoreCase("em_scnr_invoice_id") || fieldName.equals("emScnrInvoiceId"))
      return emScnrInvoiceId;
    else if (fieldName.equalsIgnoreCase("em_scnr_isref_inv") || fieldName.equals("emScnrIsrefInv"))
      return emScnrIsrefInv;
    else if (fieldName.equalsIgnoreCase("em_sqb_quickbilling_id") || fieldName.equals("emSqbQuickbillingId"))
      return emSqbQuickbillingId;
    else if (fieldName.equalsIgnoreCase("em_eei_codigo") || fieldName.equals("emEeiCodigo"))
      return emEeiCodigo;
    else if (fieldName.equalsIgnoreCase("em_eei_numauto") || fieldName.equals("emEeiNumauto"))
      return emEeiNumauto;
    else if (fieldName.equalsIgnoreCase("em_eei_fechaauto") || fieldName.equals("emEeiFechaauto"))
      return emEeiFechaauto;
    else if (fieldName.equalsIgnoreCase("em_eei_fechaautotext") || fieldName.equals("emEeiFechaautotext"))
      return emEeiFechaautotext;
    else if (fieldName.equalsIgnoreCase("em_eei_generated") || fieldName.equals("emEeiGenerated"))
      return emEeiGenerated;
    else if (fieldName.equalsIgnoreCase("em_eei_sent") || fieldName.equals("emEeiSent"))
      return emEeiSent;
    else if (fieldName.equalsIgnoreCase("em_eei_edocument") || fieldName.equals("emEeiEdocument"))
      return emEeiEdocument;
    else if (fieldName.equalsIgnoreCase("em_eei_rsi_auth_no") || fieldName.equals("emEeiRsiAuthNo"))
      return emEeiRsiAuthNo;
    else if (fieldName.equalsIgnoreCase("em_eei_creditnote") || fieldName.equals("emEeiCreditnote"))
      return emEeiCreditnote;
    else if (fieldName.equalsIgnoreCase("em_eei_is_inv_ref") || fieldName.equals("emEeiIsInvRef"))
      return emEeiIsInvRef;
    else if (fieldName.equalsIgnoreCase("em_eei_ref_inv_id") || fieldName.equals("emEeiRefInvId"))
      return emEeiRefInvId;
    else if (fieldName.equalsIgnoreCase("em_eei_debitnote") || fieldName.equals("emEeiDebitnote"))
      return emEeiDebitnote;
    else if (fieldName.equalsIgnoreCase("em_eei_withholding_send") || fieldName.equals("emEeiWithholdingSend"))
      return emEeiWithholdingSend;
    else if (fieldName.equalsIgnoreCase("em_eei_urlxml") || fieldName.equals("emEeiUrlxml"))
      return emEeiUrlxml;
    else if (fieldName.equalsIgnoreCase("em_eei_urlride") || fieldName.equals("emEeiUrlride"))
      return emEeiUrlride;
    else if (fieldName.equalsIgnoreCase("em_eei_status") || fieldName.equals("emEeiStatus"))
      return emEeiStatus;
    else if (fieldName.equalsIgnoreCase("em_eei_temporalsend") || fieldName.equals("emEeiTemporalsend"))
      return emEeiTemporalsend;
    else if (fieldName.equalsIgnoreCase("em_eei_resendinvoice") || fieldName.equals("emEeiResendinvoice"))
      return emEeiResendinvoice;
    else if (fieldName.equalsIgnoreCase("em_eei_generate_offline") || fieldName.equals("emEeiGenerateOffline"))
      return emEeiGenerateOffline;
    else if (fieldName.equalsIgnoreCase("em_aprm_addpayment") || fieldName.equals("emAprmAddpayment"))
      return emAprmAddpayment;
    else if (fieldName.equalsIgnoreCase("em_aprm_processinvoice") || fieldName.equals("emAprmProcessinvoice"))
      return emAprmProcessinvoice;
    else if (fieldName.equalsIgnoreCase("prepaymentamt"))
      return prepaymentamt;
    else if (fieldName.equalsIgnoreCase("em_sfb_isdeferred") || fieldName.equals("emSfbIsdeferred"))
      return emSfbIsdeferred;
    else if (fieldName.equalsIgnoreCase("em_sfb_differ_within_year") || fieldName.equals("emSfbDifferWithinYear"))
      return emSfbDifferWithinYear;
    else if (fieldName.equalsIgnoreCase("em_ssre_lockdate") || fieldName.equals("emSsreLockdate"))
      return emSsreLockdate;
    else if (fieldName.equalsIgnoreCase("em_ssre_isrefunded") || fieldName.equals("emSsreIsrefunded"))
      return emSsreIsrefunded;
    else if (fieldName.equalsIgnoreCase("em_ssre_lockedby") || fieldName.equals("emSsreLockedby"))
      return emSsreLockedby;
    else if (fieldName.equalsIgnoreCase("em_spinco_taxid") || fieldName.equals("emSpincoTaxid"))
      return emSpincoTaxid;
    else if (fieldName.equalsIgnoreCase("em_eei_description") || fieldName.equals("emEeiDescription"))
      return emEeiDescription;
    else if (fieldName.equalsIgnoreCase("em_ecsap_signed") || fieldName.equals("emEcsapSigned"))
      return emEcsapSigned;
    else if (fieldName.equalsIgnoreCase("em_ecsap_sign") || fieldName.equals("emEcsapSign"))
      return emEcsapSign;
    else if (fieldName.equalsIgnoreCase("em_ecsap_authorization") || fieldName.equals("emEcsapAuthorization"))
      return emEcsapAuthorization;
    else if (fieldName.equalsIgnoreCase("em_ecsap_auth_level_id") || fieldName.equals("emEcsapAuthLevelId"))
      return emEcsapAuthLevelId;
    else if (fieldName.equalsIgnoreCase("em_ecsap_reject") || fieldName.equals("emEcsapReject"))
      return emEcsapReject;
    else if (fieldName.equalsIgnoreCase("em_eei_status_2") || fieldName.equals("emEeiStatus2"))
      return emEeiStatus2;
    else if (fieldName.equalsIgnoreCase("em_eei_codigo_2") || fieldName.equals("emEeiCodigo2"))
      return emEeiCodigo2;
    else if (fieldName.equalsIgnoreCase("em_eei_urlxml_2") || fieldName.equals("emEeiUrlxml2"))
      return emEeiUrlxml2;
    else if (fieldName.equalsIgnoreCase("em_eei_urlride_2") || fieldName.equals("emEeiUrlride2"))
      return emEeiUrlride2;
    else if (fieldName.equalsIgnoreCase("em_eei_numauto_2") || fieldName.equals("emEeiNumauto2"))
      return emEeiNumauto2;
    else if (fieldName.equalsIgnoreCase("em_eei_fechaautotext_2") || fieldName.equals("emEeiFechaautotext2"))
      return emEeiFechaautotext2;
    else if (fieldName.equalsIgnoreCase("em_eei_generate_offline_2") || fieldName.equals("emEeiGenerateOffline2"))
      return emEeiGenerateOffline2;
    else if (fieldName.equalsIgnoreCase("em_eei_resendinvoice_2") || fieldName.equals("emEeiResendinvoice2"))
      return emEeiResendinvoice2;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportPrintElectronicInvoiceData[] select(ConnectionProvider connectionProvider, String InvoiceID)    throws ServletException {
    return select(connectionProvider, InvoiceID, 0, 0);
  }

  public static ReportPrintElectronicInvoiceData[] select(ConnectionProvider connectionProvider, String InvoiceID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		SELECT" +
      "		* from c_invoice where c_invoice_id = ?";

    ResultSet result;
    Vector<ReportPrintElectronicInvoiceData> vector = new Vector<ReportPrintElectronicInvoiceData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, InvoiceID);

      result = st.executeQuery();
      long countRecord = 0;
      long countRecordSkip = 1;
      boolean continueResult = true;
      while(countRecordSkip < firstRegister && continueResult) {
        continueResult = result.next();
        countRecordSkip++;
      }
      while(continueResult && result.next()) {
        countRecord++;
        ReportPrintElectronicInvoiceData objectReportPrintElectronicInvoiceData = new ReportPrintElectronicInvoiceData();
        objectReportPrintElectronicInvoiceData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectReportPrintElectronicInvoiceData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectReportPrintElectronicInvoiceData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectReportPrintElectronicInvoiceData.isactive = UtilSql.getValue(result, "isactive");
        objectReportPrintElectronicInvoiceData.created = UtilSql.getDateValue(result, "created", "dd-MM-yyyy");
        objectReportPrintElectronicInvoiceData.createdby = UtilSql.getValue(result, "createdby");
        objectReportPrintElectronicInvoiceData.updated = UtilSql.getDateValue(result, "updated", "dd-MM-yyyy");
        objectReportPrintElectronicInvoiceData.updatedby = UtilSql.getValue(result, "updatedby");
        objectReportPrintElectronicInvoiceData.issotrx = UtilSql.getValue(result, "issotrx");
        objectReportPrintElectronicInvoiceData.documentno = UtilSql.getValue(result, "documentno");
        objectReportPrintElectronicInvoiceData.docstatus = UtilSql.getValue(result, "docstatus");
        objectReportPrintElectronicInvoiceData.docaction = UtilSql.getValue(result, "docaction");
        objectReportPrintElectronicInvoiceData.processing = UtilSql.getValue(result, "processing");
        objectReportPrintElectronicInvoiceData.processed = UtilSql.getValue(result, "processed");
        objectReportPrintElectronicInvoiceData.posted = UtilSql.getValue(result, "posted");
        objectReportPrintElectronicInvoiceData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectReportPrintElectronicInvoiceData.cDoctypetargetId = UtilSql.getValue(result, "c_doctypetarget_id");
        objectReportPrintElectronicInvoiceData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectReportPrintElectronicInvoiceData.description = UtilSql.getValue(result, "description");
        objectReportPrintElectronicInvoiceData.isprinted = UtilSql.getValue(result, "isprinted");
        objectReportPrintElectronicInvoiceData.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectReportPrintElectronicInvoiceData.dateinvoiced = UtilSql.getDateValue(result, "dateinvoiced", "dd-MM-yyyy");
        objectReportPrintElectronicInvoiceData.dateprinted = UtilSql.getDateValue(result, "dateprinted", "dd-MM-yyyy");
        objectReportPrintElectronicInvoiceData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectReportPrintElectronicInvoiceData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectReportPrintElectronicInvoiceData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectReportPrintElectronicInvoiceData.poreference = UtilSql.getValue(result, "poreference");
        objectReportPrintElectronicInvoiceData.isdiscountprinted = UtilSql.getValue(result, "isdiscountprinted");
        objectReportPrintElectronicInvoiceData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectReportPrintElectronicInvoiceData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectReportPrintElectronicInvoiceData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectReportPrintElectronicInvoiceData.cPaymenttermId = UtilSql.getValue(result, "c_paymentterm_id");
        objectReportPrintElectronicInvoiceData.cChargeId = UtilSql.getValue(result, "c_charge_id");
        objectReportPrintElectronicInvoiceData.chargeamt = UtilSql.getValue(result, "chargeamt");
        objectReportPrintElectronicInvoiceData.totallines = UtilSql.getValue(result, "totallines");
        objectReportPrintElectronicInvoiceData.grandtotal = UtilSql.getValue(result, "grandtotal");
        objectReportPrintElectronicInvoiceData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectReportPrintElectronicInvoiceData.istaxincluded = UtilSql.getValue(result, "istaxincluded");
        objectReportPrintElectronicInvoiceData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectReportPrintElectronicInvoiceData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectReportPrintElectronicInvoiceData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectReportPrintElectronicInvoiceData.createfrom = UtilSql.getValue(result, "createfrom");
        objectReportPrintElectronicInvoiceData.generateto = UtilSql.getValue(result, "generateto");
        objectReportPrintElectronicInvoiceData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectReportPrintElectronicInvoiceData.copyfrom = UtilSql.getValue(result, "copyfrom");
        objectReportPrintElectronicInvoiceData.isselfservice = UtilSql.getValue(result, "isselfservice");
        objectReportPrintElectronicInvoiceData.adOrgtrxId = UtilSql.getValue(result, "ad_orgtrx_id");
        objectReportPrintElectronicInvoiceData.user1Id = UtilSql.getValue(result, "user1_id");
        objectReportPrintElectronicInvoiceData.user2Id = UtilSql.getValue(result, "user2_id");
        objectReportPrintElectronicInvoiceData.withholdingamount = UtilSql.getValue(result, "withholdingamount");
        objectReportPrintElectronicInvoiceData.taxdate = UtilSql.getDateValue(result, "taxdate", "dd-MM-yyyy");
        objectReportPrintElectronicInvoiceData.cWithholdingId = UtilSql.getValue(result, "c_withholding_id");
        objectReportPrintElectronicInvoiceData.ispaid = UtilSql.getValue(result, "ispaid");
        objectReportPrintElectronicInvoiceData.totalpaid = UtilSql.getValue(result, "totalpaid");
        objectReportPrintElectronicInvoiceData.outstandingamt = UtilSql.getValue(result, "outstandingamt");
        objectReportPrintElectronicInvoiceData.daystilldue = UtilSql.getValue(result, "daystilldue");
        objectReportPrintElectronicInvoiceData.dueamt = UtilSql.getValue(result, "dueamt");
        objectReportPrintElectronicInvoiceData.lastcalculatedondate = UtilSql.getDateValue(result, "lastcalculatedondate", "dd-MM-yyyy");
        objectReportPrintElectronicInvoiceData.updatepaymentmonitor = UtilSql.getValue(result, "updatepaymentmonitor");
        objectReportPrintElectronicInvoiceData.finPaymentmethodId = UtilSql.getValue(result, "fin_paymentmethod_id");
        objectReportPrintElectronicInvoiceData.finPaymentPriorityId = UtilSql.getValue(result, "fin_payment_priority_id");
        objectReportPrintElectronicInvoiceData.finalsettlement = UtilSql.getDateValue(result, "finalsettlement", "dd-MM-yyyy");
        objectReportPrintElectronicInvoiceData.daysoutstanding = UtilSql.getValue(result, "daysoutstanding");
        objectReportPrintElectronicInvoiceData.percentageoverdue = UtilSql.getValue(result, "percentageoverdue");
        objectReportPrintElectronicInvoiceData.cCostcenterId = UtilSql.getValue(result, "c_costcenter_id");
        objectReportPrintElectronicInvoiceData.calculatePromotions = UtilSql.getValue(result, "calculate_promotions");
        objectReportPrintElectronicInvoiceData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectReportPrintElectronicInvoiceData.iscashvat = UtilSql.getValue(result, "iscashvat");
        objectReportPrintElectronicInvoiceData.emSfbHashcode = UtilSql.getValue(result, "em_sfb_hashcode");
        objectReportPrintElectronicInvoiceData.emSfbIsnotbudgetable = UtilSql.getValue(result, "em_sfb_isnotbudgetable");
        objectReportPrintElectronicInvoiceData.emSfbBudgetAreaId = UtilSql.getValue(result, "em_sfb_budget_area_id");
        objectReportPrintElectronicInvoiceData.emSfbIsbudgeted = UtilSql.getValue(result, "em_sfb_isbudgeted");
        objectReportPrintElectronicInvoiceData.emSsflBillingPeriodFrom = UtilSql.getDateValue(result, "em_ssfl_billing_period_from", "dd-MM-yyyy");
        objectReportPrintElectronicInvoiceData.emSsflBillingPeriodTo = UtilSql.getDateValue(result, "em_ssfl_billing_period_to", "dd-MM-yyyy");
        objectReportPrintElectronicInvoiceData.emSsflIsforeign = UtilSql.getValue(result, "em_ssfl_isforeign");
        objectReportPrintElectronicInvoiceData.emSsflBankId = UtilSql.getValue(result, "em_ssfl_bank_id");
        objectReportPrintElectronicInvoiceData.emSsflObservation = UtilSql.getValue(result, "em_ssfl_observation");
        objectReportPrintElectronicInvoiceData.emSsflInvoiceReference = UtilSql.getValue(result, "em_ssfl_invoice_reference");
        objectReportPrintElectronicInvoiceData.emSsflTypeRecap = UtilSql.getValue(result, "em_ssfl_type_recap");
        objectReportPrintElectronicInvoiceData.emSsflPrintTypeRecap = UtilSql.getValue(result, "em_ssfl_print_type_recap");
        objectReportPrintElectronicInvoiceData.emSsflDescriptionvoyage = UtilSql.getValue(result, "em_ssfl_descriptionvoyage");
        objectReportPrintElectronicInvoiceData.emSsflRevised = UtilSql.getValue(result, "em_ssfl_revised");
        objectReportPrintElectronicInvoiceData.emSsflDeferred = UtilSql.getValue(result, "em_ssfl_deferred");
        objectReportPrintElectronicInvoiceData.emSipcIsTaxExpence = UtilSql.getValue(result, "em_sipc_is_tax_expence");
        objectReportPrintElectronicInvoiceData.emSlciShipperId = UtilSql.getValue(result, "em_slci_shipper_id");
        objectReportPrintElectronicInvoiceData.emSsreRefundedId = UtilSql.getValue(result, "em_ssre_refunded_id");
        objectReportPrintElectronicInvoiceData.emSsreCBpartnerId = UtilSql.getValue(result, "em_ssre_c_bpartner_id");
        objectReportPrintElectronicInvoiceData.emSsreIsrefund = UtilSql.getValue(result, "em_ssre_isrefund");
        objectReportPrintElectronicInvoiceData.emSswhTotalwithholdingincome = UtilSql.getValue(result, "em_sswh_totalwithholdingincome");
        objectReportPrintElectronicInvoiceData.emSswhTotalwithholdingvat = UtilSql.getValue(result, "em_sswh_totalwithholdingvat");
        objectReportPrintElectronicInvoiceData.emSswhReceiptId = UtilSql.getValue(result, "em_sswh_receipt_id");
        objectReportPrintElectronicInvoiceData.emSswhNroauthorization = UtilSql.getValue(result, "em_sswh_nroauthorization");
        objectReportPrintElectronicInvoiceData.emSswhExpirationdate = UtilSql.getDateValue(result, "em_sswh_expirationdate", "dd-MM-yyyy");
        objectReportPrintElectronicInvoiceData.emSswhLivelihood = UtilSql.getValue(result, "em_sswh_livelihood");
        objectReportPrintElectronicInvoiceData.emSswhCodelivelihood = UtilSql.getValue(result, "em_sswh_codelivelihood");
        objectReportPrintElectronicInvoiceData.emSswhWithholdingref = UtilSql.getValue(result, "em_sswh_withholdingref");
        objectReportPrintElectronicInvoiceData.emSswhAuthorization = UtilSql.getValue(result, "em_sswh_authorization");
        objectReportPrintElectronicInvoiceData.emSswhDatewithhold = UtilSql.getDateValue(result, "em_sswh_datewithhold", "dd-MM-yyyy");
        objectReportPrintElectronicInvoiceData.emSswhCreditnote = UtilSql.getValue(result, "em_sswh_creditnote");
        objectReportPrintElectronicInvoiceData.emSswhDateendinvoice = UtilSql.getDateValue(result, "em_sswh_dateendinvoice", "dd-MM-yyyy");
        objectReportPrintElectronicInvoiceData.emSswhInvoiceRef = UtilSql.getValue(result, "em_sswh_invoice_ref");
        objectReportPrintElectronicInvoiceData.emSswhKeyei = UtilSql.getValue(result, "em_sswh_keyei");
        objectReportPrintElectronicInvoiceData.emSswhIseinvoice = UtilSql.getValue(result, "em_sswh_iseinvoice");
        objectReportPrintElectronicInvoiceData.emSswhCDoctypeId = UtilSql.getValue(result, "em_sswh_c_doctype_id");
        objectReportPrintElectronicInvoiceData.emSswhBankaccountId = UtilSql.getValue(result, "em_sswh_bankaccount_id");
        objectReportPrintElectronicInvoiceData.emSswhWithholdingmanual = UtilSql.getValue(result, "em_sswh_withholdingmanual");
        objectReportPrintElectronicInvoiceData.emSswhAuthorizationmanual = UtilSql.getValue(result, "em_sswh_authorizationmanual");
        objectReportPrintElectronicInvoiceData.emSswhCreditnotereference = UtilSql.getValue(result, "em_sswh_creditnotereference");
        objectReportPrintElectronicInvoiceData.emScnrInvoiceId = UtilSql.getValue(result, "em_scnr_invoice_id");
        objectReportPrintElectronicInvoiceData.emScnrIsrefInv = UtilSql.getValue(result, "em_scnr_isref_inv");
        objectReportPrintElectronicInvoiceData.emSqbQuickbillingId = UtilSql.getValue(result, "em_sqb_quickbilling_id");
        objectReportPrintElectronicInvoiceData.emEeiCodigo = UtilSql.getValue(result, "em_eei_codigo");
        objectReportPrintElectronicInvoiceData.emEeiNumauto = UtilSql.getValue(result, "em_eei_numauto");
        objectReportPrintElectronicInvoiceData.emEeiFechaauto = UtilSql.getDateValue(result, "em_eei_fechaauto", "dd-MM-yyyy");
        objectReportPrintElectronicInvoiceData.emEeiFechaautotext = UtilSql.getValue(result, "em_eei_fechaautotext");
        objectReportPrintElectronicInvoiceData.emEeiGenerated = UtilSql.getValue(result, "em_eei_generated");
        objectReportPrintElectronicInvoiceData.emEeiSent = UtilSql.getValue(result, "em_eei_sent");
        objectReportPrintElectronicInvoiceData.emEeiEdocument = UtilSql.getValue(result, "em_eei_edocument");
        objectReportPrintElectronicInvoiceData.emEeiRsiAuthNo = UtilSql.getValue(result, "em_eei_rsi_auth_no");
        objectReportPrintElectronicInvoiceData.emEeiCreditnote = UtilSql.getValue(result, "em_eei_creditnote");
        objectReportPrintElectronicInvoiceData.emEeiIsInvRef = UtilSql.getValue(result, "em_eei_is_inv_ref");
        objectReportPrintElectronicInvoiceData.emEeiRefInvId = UtilSql.getValue(result, "em_eei_ref_inv_id");
        objectReportPrintElectronicInvoiceData.emEeiDebitnote = UtilSql.getValue(result, "em_eei_debitnote");
        objectReportPrintElectronicInvoiceData.emEeiWithholdingSend = UtilSql.getValue(result, "em_eei_withholding_send");
        objectReportPrintElectronicInvoiceData.emEeiUrlxml = UtilSql.getValue(result, "em_eei_urlxml");
        objectReportPrintElectronicInvoiceData.emEeiUrlride = UtilSql.getValue(result, "em_eei_urlride");
        objectReportPrintElectronicInvoiceData.emEeiStatus = UtilSql.getValue(result, "em_eei_status");
        objectReportPrintElectronicInvoiceData.emEeiTemporalsend = UtilSql.getValue(result, "em_eei_temporalsend");
        objectReportPrintElectronicInvoiceData.emEeiResendinvoice = UtilSql.getValue(result, "em_eei_resendinvoice");
        objectReportPrintElectronicInvoiceData.emEeiGenerateOffline = UtilSql.getValue(result, "em_eei_generate_offline");
        objectReportPrintElectronicInvoiceData.emAprmAddpayment = UtilSql.getValue(result, "em_aprm_addpayment");
        objectReportPrintElectronicInvoiceData.emAprmProcessinvoice = UtilSql.getValue(result, "em_aprm_processinvoice");
        objectReportPrintElectronicInvoiceData.prepaymentamt = UtilSql.getValue(result, "prepaymentamt");
        objectReportPrintElectronicInvoiceData.emSfbIsdeferred = UtilSql.getValue(result, "em_sfb_isdeferred");
        objectReportPrintElectronicInvoiceData.emSfbDifferWithinYear = UtilSql.getValue(result, "em_sfb_differ_within_year");
        objectReportPrintElectronicInvoiceData.emSsreLockdate = UtilSql.getDateValue(result, "em_ssre_lockdate", "dd-MM-yyyy");
        objectReportPrintElectronicInvoiceData.emSsreIsrefunded = UtilSql.getValue(result, "em_ssre_isrefunded");
        objectReportPrintElectronicInvoiceData.emSsreLockedby = UtilSql.getValue(result, "em_ssre_lockedby");
        objectReportPrintElectronicInvoiceData.emSpincoTaxid = UtilSql.getValue(result, "em_spinco_taxid");
        objectReportPrintElectronicInvoiceData.emEeiDescription = UtilSql.getValue(result, "em_eei_description");
        objectReportPrintElectronicInvoiceData.emEcsapSigned = UtilSql.getValue(result, "em_ecsap_signed");
        objectReportPrintElectronicInvoiceData.emEcsapSign = UtilSql.getValue(result, "em_ecsap_sign");
        objectReportPrintElectronicInvoiceData.emEcsapAuthorization = UtilSql.getValue(result, "em_ecsap_authorization");
        objectReportPrintElectronicInvoiceData.emEcsapAuthLevelId = UtilSql.getValue(result, "em_ecsap_auth_level_id");
        objectReportPrintElectronicInvoiceData.emEcsapReject = UtilSql.getValue(result, "em_ecsap_reject");
        objectReportPrintElectronicInvoiceData.emEeiStatus2 = UtilSql.getValue(result, "em_eei_status_2");
        objectReportPrintElectronicInvoiceData.emEeiCodigo2 = UtilSql.getValue(result, "em_eei_codigo_2");
        objectReportPrintElectronicInvoiceData.emEeiUrlxml2 = UtilSql.getValue(result, "em_eei_urlxml_2");
        objectReportPrintElectronicInvoiceData.emEeiUrlride2 = UtilSql.getValue(result, "em_eei_urlride_2");
        objectReportPrintElectronicInvoiceData.emEeiNumauto2 = UtilSql.getValue(result, "em_eei_numauto_2");
        objectReportPrintElectronicInvoiceData.emEeiFechaautotext2 = UtilSql.getValue(result, "em_eei_fechaautotext_2");
        objectReportPrintElectronicInvoiceData.emEeiGenerateOffline2 = UtilSql.getValue(result, "em_eei_generate_offline_2");
        objectReportPrintElectronicInvoiceData.emEeiResendinvoice2 = UtilSql.getValue(result, "em_eei_resendinvoice_2");
        objectReportPrintElectronicInvoiceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportPrintElectronicInvoiceData);
        if (countRecord >= numberRegisters && numberRegisters != 0) {
          continueResult = false;
        }
      }
      result.close();
    } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    ReportPrintElectronicInvoiceData objectReportPrintElectronicInvoiceData[] = new ReportPrintElectronicInvoiceData[vector.size()];
    vector.copyInto(objectReportPrintElectronicInvoiceData);
    return(objectReportPrintElectronicInvoiceData);
  }

  public static ReportPrintElectronicInvoiceData[] set()    throws ServletException {
    ReportPrintElectronicInvoiceData objectReportPrintElectronicInvoiceData[] = new ReportPrintElectronicInvoiceData[1];
    objectReportPrintElectronicInvoiceData[0] = new ReportPrintElectronicInvoiceData();
    objectReportPrintElectronicInvoiceData[0].cInvoiceId = "";
    objectReportPrintElectronicInvoiceData[0].adClientId = "";
    objectReportPrintElectronicInvoiceData[0].adOrgId = "";
    objectReportPrintElectronicInvoiceData[0].isactive = "";
    objectReportPrintElectronicInvoiceData[0].created = "";
    objectReportPrintElectronicInvoiceData[0].createdby = "";
    objectReportPrintElectronicInvoiceData[0].updated = "";
    objectReportPrintElectronicInvoiceData[0].updatedby = "";
    objectReportPrintElectronicInvoiceData[0].issotrx = "";
    objectReportPrintElectronicInvoiceData[0].documentno = "";
    objectReportPrintElectronicInvoiceData[0].docstatus = "";
    objectReportPrintElectronicInvoiceData[0].docaction = "";
    objectReportPrintElectronicInvoiceData[0].processing = "";
    objectReportPrintElectronicInvoiceData[0].processed = "";
    objectReportPrintElectronicInvoiceData[0].posted = "";
    objectReportPrintElectronicInvoiceData[0].cDoctypeId = "";
    objectReportPrintElectronicInvoiceData[0].cDoctypetargetId = "";
    objectReportPrintElectronicInvoiceData[0].cOrderId = "";
    objectReportPrintElectronicInvoiceData[0].description = "";
    objectReportPrintElectronicInvoiceData[0].isprinted = "";
    objectReportPrintElectronicInvoiceData[0].salesrepId = "";
    objectReportPrintElectronicInvoiceData[0].dateinvoiced = "";
    objectReportPrintElectronicInvoiceData[0].dateprinted = "";
    objectReportPrintElectronicInvoiceData[0].dateacct = "";
    objectReportPrintElectronicInvoiceData[0].cBpartnerId = "";
    objectReportPrintElectronicInvoiceData[0].cBpartnerLocationId = "";
    objectReportPrintElectronicInvoiceData[0].poreference = "";
    objectReportPrintElectronicInvoiceData[0].isdiscountprinted = "";
    objectReportPrintElectronicInvoiceData[0].dateordered = "";
    objectReportPrintElectronicInvoiceData[0].cCurrencyId = "";
    objectReportPrintElectronicInvoiceData[0].paymentrule = "";
    objectReportPrintElectronicInvoiceData[0].cPaymenttermId = "";
    objectReportPrintElectronicInvoiceData[0].cChargeId = "";
    objectReportPrintElectronicInvoiceData[0].chargeamt = "";
    objectReportPrintElectronicInvoiceData[0].totallines = "";
    objectReportPrintElectronicInvoiceData[0].grandtotal = "";
    objectReportPrintElectronicInvoiceData[0].mPricelistId = "";
    objectReportPrintElectronicInvoiceData[0].istaxincluded = "";
    objectReportPrintElectronicInvoiceData[0].cCampaignId = "";
    objectReportPrintElectronicInvoiceData[0].cProjectId = "";
    objectReportPrintElectronicInvoiceData[0].cActivityId = "";
    objectReportPrintElectronicInvoiceData[0].createfrom = "";
    objectReportPrintElectronicInvoiceData[0].generateto = "";
    objectReportPrintElectronicInvoiceData[0].adUserId = "";
    objectReportPrintElectronicInvoiceData[0].copyfrom = "";
    objectReportPrintElectronicInvoiceData[0].isselfservice = "";
    objectReportPrintElectronicInvoiceData[0].adOrgtrxId = "";
    objectReportPrintElectronicInvoiceData[0].user1Id = "";
    objectReportPrintElectronicInvoiceData[0].user2Id = "";
    objectReportPrintElectronicInvoiceData[0].withholdingamount = "";
    objectReportPrintElectronicInvoiceData[0].taxdate = "";
    objectReportPrintElectronicInvoiceData[0].cWithholdingId = "";
    objectReportPrintElectronicInvoiceData[0].ispaid = "";
    objectReportPrintElectronicInvoiceData[0].totalpaid = "";
    objectReportPrintElectronicInvoiceData[0].outstandingamt = "";
    objectReportPrintElectronicInvoiceData[0].daystilldue = "";
    objectReportPrintElectronicInvoiceData[0].dueamt = "";
    objectReportPrintElectronicInvoiceData[0].lastcalculatedondate = "";
    objectReportPrintElectronicInvoiceData[0].updatepaymentmonitor = "";
    objectReportPrintElectronicInvoiceData[0].finPaymentmethodId = "";
    objectReportPrintElectronicInvoiceData[0].finPaymentPriorityId = "";
    objectReportPrintElectronicInvoiceData[0].finalsettlement = "";
    objectReportPrintElectronicInvoiceData[0].daysoutstanding = "";
    objectReportPrintElectronicInvoiceData[0].percentageoverdue = "";
    objectReportPrintElectronicInvoiceData[0].cCostcenterId = "";
    objectReportPrintElectronicInvoiceData[0].calculatePromotions = "";
    objectReportPrintElectronicInvoiceData[0].aAssetId = "";
    objectReportPrintElectronicInvoiceData[0].iscashvat = "";
    objectReportPrintElectronicInvoiceData[0].emSfbHashcode = "";
    objectReportPrintElectronicInvoiceData[0].emSfbIsnotbudgetable = "";
    objectReportPrintElectronicInvoiceData[0].emSfbBudgetAreaId = "";
    objectReportPrintElectronicInvoiceData[0].emSfbIsbudgeted = "";
    objectReportPrintElectronicInvoiceData[0].emSsflBillingPeriodFrom = "";
    objectReportPrintElectronicInvoiceData[0].emSsflBillingPeriodTo = "";
    objectReportPrintElectronicInvoiceData[0].emSsflIsforeign = "";
    objectReportPrintElectronicInvoiceData[0].emSsflBankId = "";
    objectReportPrintElectronicInvoiceData[0].emSsflObservation = "";
    objectReportPrintElectronicInvoiceData[0].emSsflInvoiceReference = "";
    objectReportPrintElectronicInvoiceData[0].emSsflTypeRecap = "";
    objectReportPrintElectronicInvoiceData[0].emSsflPrintTypeRecap = "";
    objectReportPrintElectronicInvoiceData[0].emSsflDescriptionvoyage = "";
    objectReportPrintElectronicInvoiceData[0].emSsflRevised = "";
    objectReportPrintElectronicInvoiceData[0].emSsflDeferred = "";
    objectReportPrintElectronicInvoiceData[0].emSipcIsTaxExpence = "";
    objectReportPrintElectronicInvoiceData[0].emSlciShipperId = "";
    objectReportPrintElectronicInvoiceData[0].emSsreRefundedId = "";
    objectReportPrintElectronicInvoiceData[0].emSsreCBpartnerId = "";
    objectReportPrintElectronicInvoiceData[0].emSsreIsrefund = "";
    objectReportPrintElectronicInvoiceData[0].emSswhTotalwithholdingincome = "";
    objectReportPrintElectronicInvoiceData[0].emSswhTotalwithholdingvat = "";
    objectReportPrintElectronicInvoiceData[0].emSswhReceiptId = "";
    objectReportPrintElectronicInvoiceData[0].emSswhNroauthorization = "";
    objectReportPrintElectronicInvoiceData[0].emSswhExpirationdate = "";
    objectReportPrintElectronicInvoiceData[0].emSswhLivelihood = "";
    objectReportPrintElectronicInvoiceData[0].emSswhCodelivelihood = "";
    objectReportPrintElectronicInvoiceData[0].emSswhWithholdingref = "";
    objectReportPrintElectronicInvoiceData[0].emSswhAuthorization = "";
    objectReportPrintElectronicInvoiceData[0].emSswhDatewithhold = "";
    objectReportPrintElectronicInvoiceData[0].emSswhCreditnote = "";
    objectReportPrintElectronicInvoiceData[0].emSswhDateendinvoice = "";
    objectReportPrintElectronicInvoiceData[0].emSswhInvoiceRef = "";
    objectReportPrintElectronicInvoiceData[0].emSswhKeyei = "";
    objectReportPrintElectronicInvoiceData[0].emSswhIseinvoice = "";
    objectReportPrintElectronicInvoiceData[0].emSswhCDoctypeId = "";
    objectReportPrintElectronicInvoiceData[0].emSswhBankaccountId = "";
    objectReportPrintElectronicInvoiceData[0].emSswhWithholdingmanual = "";
    objectReportPrintElectronicInvoiceData[0].emSswhAuthorizationmanual = "";
    objectReportPrintElectronicInvoiceData[0].emSswhCreditnotereference = "";
    objectReportPrintElectronicInvoiceData[0].emScnrInvoiceId = "";
    objectReportPrintElectronicInvoiceData[0].emScnrIsrefInv = "";
    objectReportPrintElectronicInvoiceData[0].emSqbQuickbillingId = "";
    objectReportPrintElectronicInvoiceData[0].emEeiCodigo = "";
    objectReportPrintElectronicInvoiceData[0].emEeiNumauto = "";
    objectReportPrintElectronicInvoiceData[0].emEeiFechaauto = "";
    objectReportPrintElectronicInvoiceData[0].emEeiFechaautotext = "";
    objectReportPrintElectronicInvoiceData[0].emEeiGenerated = "";
    objectReportPrintElectronicInvoiceData[0].emEeiSent = "";
    objectReportPrintElectronicInvoiceData[0].emEeiEdocument = "";
    objectReportPrintElectronicInvoiceData[0].emEeiRsiAuthNo = "";
    objectReportPrintElectronicInvoiceData[0].emEeiCreditnote = "";
    objectReportPrintElectronicInvoiceData[0].emEeiIsInvRef = "";
    objectReportPrintElectronicInvoiceData[0].emEeiRefInvId = "";
    objectReportPrintElectronicInvoiceData[0].emEeiDebitnote = "";
    objectReportPrintElectronicInvoiceData[0].emEeiWithholdingSend = "";
    objectReportPrintElectronicInvoiceData[0].emEeiUrlxml = "";
    objectReportPrintElectronicInvoiceData[0].emEeiUrlride = "";
    objectReportPrintElectronicInvoiceData[0].emEeiStatus = "";
    objectReportPrintElectronicInvoiceData[0].emEeiTemporalsend = "";
    objectReportPrintElectronicInvoiceData[0].emEeiResendinvoice = "";
    objectReportPrintElectronicInvoiceData[0].emEeiGenerateOffline = "";
    objectReportPrintElectronicInvoiceData[0].emAprmAddpayment = "";
    objectReportPrintElectronicInvoiceData[0].emAprmProcessinvoice = "";
    objectReportPrintElectronicInvoiceData[0].prepaymentamt = "";
    objectReportPrintElectronicInvoiceData[0].emSfbIsdeferred = "";
    objectReportPrintElectronicInvoiceData[0].emSfbDifferWithinYear = "";
    objectReportPrintElectronicInvoiceData[0].emSsreLockdate = "";
    objectReportPrintElectronicInvoiceData[0].emSsreIsrefunded = "";
    objectReportPrintElectronicInvoiceData[0].emSsreLockedby = "";
    objectReportPrintElectronicInvoiceData[0].emSpincoTaxid = "";
    objectReportPrintElectronicInvoiceData[0].emEeiDescription = "";
    objectReportPrintElectronicInvoiceData[0].emEcsapSigned = "";
    objectReportPrintElectronicInvoiceData[0].emEcsapSign = "";
    objectReportPrintElectronicInvoiceData[0].emEcsapAuthorization = "";
    objectReportPrintElectronicInvoiceData[0].emEcsapAuthLevelId = "";
    objectReportPrintElectronicInvoiceData[0].emEcsapReject = "";
    objectReportPrintElectronicInvoiceData[0].emEeiStatus2 = "";
    objectReportPrintElectronicInvoiceData[0].emEeiCodigo2 = "";
    objectReportPrintElectronicInvoiceData[0].emEeiUrlxml2 = "";
    objectReportPrintElectronicInvoiceData[0].emEeiUrlride2 = "";
    objectReportPrintElectronicInvoiceData[0].emEeiNumauto2 = "";
    objectReportPrintElectronicInvoiceData[0].emEeiFechaautotext2 = "";
    objectReportPrintElectronicInvoiceData[0].emEeiGenerateOffline2 = "";
    objectReportPrintElectronicInvoiceData[0].emEeiResendinvoice2 = "";
    return objectReportPrintElectronicInvoiceData;
  }
}
