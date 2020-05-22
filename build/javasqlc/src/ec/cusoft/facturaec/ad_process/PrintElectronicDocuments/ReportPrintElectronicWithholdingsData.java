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

class ReportPrintElectronicWithholdingsData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportPrintElectronicWithholdingsData.class);
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

  public static ReportPrintElectronicWithholdingsData[] select(ConnectionProvider connectionProvider, String InvoiceID)    throws ServletException {
    return select(connectionProvider, InvoiceID, 0, 0);
  }

  public static ReportPrintElectronicWithholdingsData[] select(ConnectionProvider connectionProvider, String InvoiceID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "SELECT  * from c_invoice  " +
      "WHERE C_INVOICE_ID = ? ";

    ResultSet result;
    Vector<ReportPrintElectronicWithholdingsData> vector = new Vector<ReportPrintElectronicWithholdingsData>(0);
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
        ReportPrintElectronicWithholdingsData objectReportPrintElectronicWithholdingsData = new ReportPrintElectronicWithholdingsData();
        objectReportPrintElectronicWithholdingsData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectReportPrintElectronicWithholdingsData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectReportPrintElectronicWithholdingsData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectReportPrintElectronicWithholdingsData.isactive = UtilSql.getValue(result, "isactive");
        objectReportPrintElectronicWithholdingsData.created = UtilSql.getDateValue(result, "created", "dd-MM-yyyy");
        objectReportPrintElectronicWithholdingsData.createdby = UtilSql.getValue(result, "createdby");
        objectReportPrintElectronicWithholdingsData.updated = UtilSql.getDateValue(result, "updated", "dd-MM-yyyy");
        objectReportPrintElectronicWithholdingsData.updatedby = UtilSql.getValue(result, "updatedby");
        objectReportPrintElectronicWithholdingsData.issotrx = UtilSql.getValue(result, "issotrx");
        objectReportPrintElectronicWithholdingsData.documentno = UtilSql.getValue(result, "documentno");
        objectReportPrintElectronicWithholdingsData.docstatus = UtilSql.getValue(result, "docstatus");
        objectReportPrintElectronicWithholdingsData.docaction = UtilSql.getValue(result, "docaction");
        objectReportPrintElectronicWithholdingsData.processing = UtilSql.getValue(result, "processing");
        objectReportPrintElectronicWithholdingsData.processed = UtilSql.getValue(result, "processed");
        objectReportPrintElectronicWithholdingsData.posted = UtilSql.getValue(result, "posted");
        objectReportPrintElectronicWithholdingsData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectReportPrintElectronicWithholdingsData.cDoctypetargetId = UtilSql.getValue(result, "c_doctypetarget_id");
        objectReportPrintElectronicWithholdingsData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectReportPrintElectronicWithholdingsData.description = UtilSql.getValue(result, "description");
        objectReportPrintElectronicWithholdingsData.isprinted = UtilSql.getValue(result, "isprinted");
        objectReportPrintElectronicWithholdingsData.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectReportPrintElectronicWithholdingsData.dateinvoiced = UtilSql.getDateValue(result, "dateinvoiced", "dd-MM-yyyy");
        objectReportPrintElectronicWithholdingsData.dateprinted = UtilSql.getDateValue(result, "dateprinted", "dd-MM-yyyy");
        objectReportPrintElectronicWithholdingsData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectReportPrintElectronicWithholdingsData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectReportPrintElectronicWithholdingsData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectReportPrintElectronicWithholdingsData.poreference = UtilSql.getValue(result, "poreference");
        objectReportPrintElectronicWithholdingsData.isdiscountprinted = UtilSql.getValue(result, "isdiscountprinted");
        objectReportPrintElectronicWithholdingsData.dateordered = UtilSql.getDateValue(result, "dateordered", "dd-MM-yyyy");
        objectReportPrintElectronicWithholdingsData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectReportPrintElectronicWithholdingsData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectReportPrintElectronicWithholdingsData.cPaymenttermId = UtilSql.getValue(result, "c_paymentterm_id");
        objectReportPrintElectronicWithholdingsData.cChargeId = UtilSql.getValue(result, "c_charge_id");
        objectReportPrintElectronicWithholdingsData.chargeamt = UtilSql.getValue(result, "chargeamt");
        objectReportPrintElectronicWithholdingsData.totallines = UtilSql.getValue(result, "totallines");
        objectReportPrintElectronicWithholdingsData.grandtotal = UtilSql.getValue(result, "grandtotal");
        objectReportPrintElectronicWithholdingsData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectReportPrintElectronicWithholdingsData.istaxincluded = UtilSql.getValue(result, "istaxincluded");
        objectReportPrintElectronicWithholdingsData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectReportPrintElectronicWithholdingsData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectReportPrintElectronicWithholdingsData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectReportPrintElectronicWithholdingsData.createfrom = UtilSql.getValue(result, "createfrom");
        objectReportPrintElectronicWithholdingsData.generateto = UtilSql.getValue(result, "generateto");
        objectReportPrintElectronicWithholdingsData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectReportPrintElectronicWithholdingsData.copyfrom = UtilSql.getValue(result, "copyfrom");
        objectReportPrintElectronicWithholdingsData.isselfservice = UtilSql.getValue(result, "isselfservice");
        objectReportPrintElectronicWithholdingsData.adOrgtrxId = UtilSql.getValue(result, "ad_orgtrx_id");
        objectReportPrintElectronicWithholdingsData.user1Id = UtilSql.getValue(result, "user1_id");
        objectReportPrintElectronicWithholdingsData.user2Id = UtilSql.getValue(result, "user2_id");
        objectReportPrintElectronicWithholdingsData.withholdingamount = UtilSql.getValue(result, "withholdingamount");
        objectReportPrintElectronicWithholdingsData.taxdate = UtilSql.getDateValue(result, "taxdate", "dd-MM-yyyy");
        objectReportPrintElectronicWithholdingsData.cWithholdingId = UtilSql.getValue(result, "c_withholding_id");
        objectReportPrintElectronicWithholdingsData.ispaid = UtilSql.getValue(result, "ispaid");
        objectReportPrintElectronicWithholdingsData.totalpaid = UtilSql.getValue(result, "totalpaid");
        objectReportPrintElectronicWithholdingsData.outstandingamt = UtilSql.getValue(result, "outstandingamt");
        objectReportPrintElectronicWithholdingsData.daystilldue = UtilSql.getValue(result, "daystilldue");
        objectReportPrintElectronicWithholdingsData.dueamt = UtilSql.getValue(result, "dueamt");
        objectReportPrintElectronicWithholdingsData.lastcalculatedondate = UtilSql.getDateValue(result, "lastcalculatedondate", "dd-MM-yyyy");
        objectReportPrintElectronicWithholdingsData.updatepaymentmonitor = UtilSql.getValue(result, "updatepaymentmonitor");
        objectReportPrintElectronicWithholdingsData.finPaymentmethodId = UtilSql.getValue(result, "fin_paymentmethod_id");
        objectReportPrintElectronicWithholdingsData.finPaymentPriorityId = UtilSql.getValue(result, "fin_payment_priority_id");
        objectReportPrintElectronicWithholdingsData.finalsettlement = UtilSql.getDateValue(result, "finalsettlement", "dd-MM-yyyy");
        objectReportPrintElectronicWithholdingsData.daysoutstanding = UtilSql.getValue(result, "daysoutstanding");
        objectReportPrintElectronicWithholdingsData.percentageoverdue = UtilSql.getValue(result, "percentageoverdue");
        objectReportPrintElectronicWithholdingsData.cCostcenterId = UtilSql.getValue(result, "c_costcenter_id");
        objectReportPrintElectronicWithholdingsData.calculatePromotions = UtilSql.getValue(result, "calculate_promotions");
        objectReportPrintElectronicWithholdingsData.aAssetId = UtilSql.getValue(result, "a_asset_id");
        objectReportPrintElectronicWithholdingsData.iscashvat = UtilSql.getValue(result, "iscashvat");
        objectReportPrintElectronicWithholdingsData.emSfbHashcode = UtilSql.getValue(result, "em_sfb_hashcode");
        objectReportPrintElectronicWithholdingsData.emSfbIsnotbudgetable = UtilSql.getValue(result, "em_sfb_isnotbudgetable");
        objectReportPrintElectronicWithholdingsData.emSfbBudgetAreaId = UtilSql.getValue(result, "em_sfb_budget_area_id");
        objectReportPrintElectronicWithholdingsData.emSfbIsbudgeted = UtilSql.getValue(result, "em_sfb_isbudgeted");
        objectReportPrintElectronicWithholdingsData.emSsflBillingPeriodFrom = UtilSql.getDateValue(result, "em_ssfl_billing_period_from", "dd-MM-yyyy");
        objectReportPrintElectronicWithholdingsData.emSsflBillingPeriodTo = UtilSql.getDateValue(result, "em_ssfl_billing_period_to", "dd-MM-yyyy");
        objectReportPrintElectronicWithholdingsData.emSsflIsforeign = UtilSql.getValue(result, "em_ssfl_isforeign");
        objectReportPrintElectronicWithholdingsData.emSsflBankId = UtilSql.getValue(result, "em_ssfl_bank_id");
        objectReportPrintElectronicWithholdingsData.emSsflObservation = UtilSql.getValue(result, "em_ssfl_observation");
        objectReportPrintElectronicWithholdingsData.emSsflInvoiceReference = UtilSql.getValue(result, "em_ssfl_invoice_reference");
        objectReportPrintElectronicWithholdingsData.emSsflTypeRecap = UtilSql.getValue(result, "em_ssfl_type_recap");
        objectReportPrintElectronicWithholdingsData.emSsflPrintTypeRecap = UtilSql.getValue(result, "em_ssfl_print_type_recap");
        objectReportPrintElectronicWithholdingsData.emSsflDescriptionvoyage = UtilSql.getValue(result, "em_ssfl_descriptionvoyage");
        objectReportPrintElectronicWithholdingsData.emSsflRevised = UtilSql.getValue(result, "em_ssfl_revised");
        objectReportPrintElectronicWithholdingsData.emSsflDeferred = UtilSql.getValue(result, "em_ssfl_deferred");
        objectReportPrintElectronicWithholdingsData.emSipcIsTaxExpence = UtilSql.getValue(result, "em_sipc_is_tax_expence");
        objectReportPrintElectronicWithholdingsData.emSlciShipperId = UtilSql.getValue(result, "em_slci_shipper_id");
        objectReportPrintElectronicWithholdingsData.emSsreRefundedId = UtilSql.getValue(result, "em_ssre_refunded_id");
        objectReportPrintElectronicWithholdingsData.emSsreCBpartnerId = UtilSql.getValue(result, "em_ssre_c_bpartner_id");
        objectReportPrintElectronicWithholdingsData.emSsreIsrefund = UtilSql.getValue(result, "em_ssre_isrefund");
        objectReportPrintElectronicWithholdingsData.emSswhTotalwithholdingincome = UtilSql.getValue(result, "em_sswh_totalwithholdingincome");
        objectReportPrintElectronicWithholdingsData.emSswhTotalwithholdingvat = UtilSql.getValue(result, "em_sswh_totalwithholdingvat");
        objectReportPrintElectronicWithholdingsData.emSswhReceiptId = UtilSql.getValue(result, "em_sswh_receipt_id");
        objectReportPrintElectronicWithholdingsData.emSswhNroauthorization = UtilSql.getValue(result, "em_sswh_nroauthorization");
        objectReportPrintElectronicWithholdingsData.emSswhExpirationdate = UtilSql.getDateValue(result, "em_sswh_expirationdate", "dd-MM-yyyy");
        objectReportPrintElectronicWithholdingsData.emSswhLivelihood = UtilSql.getValue(result, "em_sswh_livelihood");
        objectReportPrintElectronicWithholdingsData.emSswhCodelivelihood = UtilSql.getValue(result, "em_sswh_codelivelihood");
        objectReportPrintElectronicWithholdingsData.emSswhWithholdingref = UtilSql.getValue(result, "em_sswh_withholdingref");
        objectReportPrintElectronicWithholdingsData.emSswhAuthorization = UtilSql.getValue(result, "em_sswh_authorization");
        objectReportPrintElectronicWithholdingsData.emSswhDatewithhold = UtilSql.getDateValue(result, "em_sswh_datewithhold", "dd-MM-yyyy");
        objectReportPrintElectronicWithholdingsData.emSswhCreditnote = UtilSql.getValue(result, "em_sswh_creditnote");
        objectReportPrintElectronicWithholdingsData.emSswhDateendinvoice = UtilSql.getDateValue(result, "em_sswh_dateendinvoice", "dd-MM-yyyy");
        objectReportPrintElectronicWithholdingsData.emSswhInvoiceRef = UtilSql.getValue(result, "em_sswh_invoice_ref");
        objectReportPrintElectronicWithholdingsData.emSswhKeyei = UtilSql.getValue(result, "em_sswh_keyei");
        objectReportPrintElectronicWithholdingsData.emSswhIseinvoice = UtilSql.getValue(result, "em_sswh_iseinvoice");
        objectReportPrintElectronicWithholdingsData.emSswhCDoctypeId = UtilSql.getValue(result, "em_sswh_c_doctype_id");
        objectReportPrintElectronicWithholdingsData.emSswhBankaccountId = UtilSql.getValue(result, "em_sswh_bankaccount_id");
        objectReportPrintElectronicWithholdingsData.emSswhWithholdingmanual = UtilSql.getValue(result, "em_sswh_withholdingmanual");
        objectReportPrintElectronicWithholdingsData.emSswhAuthorizationmanual = UtilSql.getValue(result, "em_sswh_authorizationmanual");
        objectReportPrintElectronicWithholdingsData.emSswhCreditnotereference = UtilSql.getValue(result, "em_sswh_creditnotereference");
        objectReportPrintElectronicWithholdingsData.emScnrInvoiceId = UtilSql.getValue(result, "em_scnr_invoice_id");
        objectReportPrintElectronicWithholdingsData.emScnrIsrefInv = UtilSql.getValue(result, "em_scnr_isref_inv");
        objectReportPrintElectronicWithholdingsData.emSqbQuickbillingId = UtilSql.getValue(result, "em_sqb_quickbilling_id");
        objectReportPrintElectronicWithholdingsData.emEeiCodigo = UtilSql.getValue(result, "em_eei_codigo");
        objectReportPrintElectronicWithholdingsData.emEeiNumauto = UtilSql.getValue(result, "em_eei_numauto");
        objectReportPrintElectronicWithholdingsData.emEeiFechaauto = UtilSql.getDateValue(result, "em_eei_fechaauto", "dd-MM-yyyy");
        objectReportPrintElectronicWithholdingsData.emEeiFechaautotext = UtilSql.getValue(result, "em_eei_fechaautotext");
        objectReportPrintElectronicWithholdingsData.emEeiGenerated = UtilSql.getValue(result, "em_eei_generated");
        objectReportPrintElectronicWithholdingsData.emEeiSent = UtilSql.getValue(result, "em_eei_sent");
        objectReportPrintElectronicWithholdingsData.emEeiEdocument = UtilSql.getValue(result, "em_eei_edocument");
        objectReportPrintElectronicWithholdingsData.emEeiRsiAuthNo = UtilSql.getValue(result, "em_eei_rsi_auth_no");
        objectReportPrintElectronicWithholdingsData.emEeiCreditnote = UtilSql.getValue(result, "em_eei_creditnote");
        objectReportPrintElectronicWithholdingsData.emEeiIsInvRef = UtilSql.getValue(result, "em_eei_is_inv_ref");
        objectReportPrintElectronicWithholdingsData.emEeiRefInvId = UtilSql.getValue(result, "em_eei_ref_inv_id");
        objectReportPrintElectronicWithholdingsData.emEeiDebitnote = UtilSql.getValue(result, "em_eei_debitnote");
        objectReportPrintElectronicWithholdingsData.emEeiWithholdingSend = UtilSql.getValue(result, "em_eei_withholding_send");
        objectReportPrintElectronicWithholdingsData.emEeiUrlxml = UtilSql.getValue(result, "em_eei_urlxml");
        objectReportPrintElectronicWithholdingsData.emEeiUrlride = UtilSql.getValue(result, "em_eei_urlride");
        objectReportPrintElectronicWithholdingsData.emEeiStatus = UtilSql.getValue(result, "em_eei_status");
        objectReportPrintElectronicWithholdingsData.emEeiTemporalsend = UtilSql.getValue(result, "em_eei_temporalsend");
        objectReportPrintElectronicWithholdingsData.emEeiResendinvoice = UtilSql.getValue(result, "em_eei_resendinvoice");
        objectReportPrintElectronicWithholdingsData.emEeiGenerateOffline = UtilSql.getValue(result, "em_eei_generate_offline");
        objectReportPrintElectronicWithholdingsData.emAprmAddpayment = UtilSql.getValue(result, "em_aprm_addpayment");
        objectReportPrintElectronicWithholdingsData.emAprmProcessinvoice = UtilSql.getValue(result, "em_aprm_processinvoice");
        objectReportPrintElectronicWithholdingsData.prepaymentamt = UtilSql.getValue(result, "prepaymentamt");
        objectReportPrintElectronicWithholdingsData.emSfbIsdeferred = UtilSql.getValue(result, "em_sfb_isdeferred");
        objectReportPrintElectronicWithholdingsData.emSfbDifferWithinYear = UtilSql.getValue(result, "em_sfb_differ_within_year");
        objectReportPrintElectronicWithholdingsData.emSsreLockdate = UtilSql.getDateValue(result, "em_ssre_lockdate", "dd-MM-yyyy");
        objectReportPrintElectronicWithholdingsData.emSsreIsrefunded = UtilSql.getValue(result, "em_ssre_isrefunded");
        objectReportPrintElectronicWithholdingsData.emSsreLockedby = UtilSql.getValue(result, "em_ssre_lockedby");
        objectReportPrintElectronicWithholdingsData.emSpincoTaxid = UtilSql.getValue(result, "em_spinco_taxid");
        objectReportPrintElectronicWithholdingsData.emEeiDescription = UtilSql.getValue(result, "em_eei_description");
        objectReportPrintElectronicWithholdingsData.emEcsapSigned = UtilSql.getValue(result, "em_ecsap_signed");
        objectReportPrintElectronicWithholdingsData.emEcsapSign = UtilSql.getValue(result, "em_ecsap_sign");
        objectReportPrintElectronicWithholdingsData.emEcsapAuthorization = UtilSql.getValue(result, "em_ecsap_authorization");
        objectReportPrintElectronicWithholdingsData.emEcsapAuthLevelId = UtilSql.getValue(result, "em_ecsap_auth_level_id");
        objectReportPrintElectronicWithholdingsData.emEcsapReject = UtilSql.getValue(result, "em_ecsap_reject");
        objectReportPrintElectronicWithholdingsData.emEeiStatus2 = UtilSql.getValue(result, "em_eei_status_2");
        objectReportPrintElectronicWithholdingsData.emEeiCodigo2 = UtilSql.getValue(result, "em_eei_codigo_2");
        objectReportPrintElectronicWithholdingsData.emEeiUrlxml2 = UtilSql.getValue(result, "em_eei_urlxml_2");
        objectReportPrintElectronicWithholdingsData.emEeiUrlride2 = UtilSql.getValue(result, "em_eei_urlride_2");
        objectReportPrintElectronicWithholdingsData.emEeiNumauto2 = UtilSql.getValue(result, "em_eei_numauto_2");
        objectReportPrintElectronicWithholdingsData.emEeiFechaautotext2 = UtilSql.getValue(result, "em_eei_fechaautotext_2");
        objectReportPrintElectronicWithholdingsData.emEeiGenerateOffline2 = UtilSql.getValue(result, "em_eei_generate_offline_2");
        objectReportPrintElectronicWithholdingsData.emEeiResendinvoice2 = UtilSql.getValue(result, "em_eei_resendinvoice_2");
        objectReportPrintElectronicWithholdingsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportPrintElectronicWithholdingsData);
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
    ReportPrintElectronicWithholdingsData objectReportPrintElectronicWithholdingsData[] = new ReportPrintElectronicWithholdingsData[vector.size()];
    vector.copyInto(objectReportPrintElectronicWithholdingsData);
    return(objectReportPrintElectronicWithholdingsData);
  }

  public static ReportPrintElectronicWithholdingsData[] set()    throws ServletException {
    ReportPrintElectronicWithholdingsData objectReportPrintElectronicWithholdingsData[] = new ReportPrintElectronicWithholdingsData[1];
    objectReportPrintElectronicWithholdingsData[0] = new ReportPrintElectronicWithholdingsData();
    objectReportPrintElectronicWithholdingsData[0].cInvoiceId = "";
    objectReportPrintElectronicWithholdingsData[0].adClientId = "";
    objectReportPrintElectronicWithholdingsData[0].adOrgId = "";
    objectReportPrintElectronicWithholdingsData[0].isactive = "";
    objectReportPrintElectronicWithholdingsData[0].created = "";
    objectReportPrintElectronicWithholdingsData[0].createdby = "";
    objectReportPrintElectronicWithholdingsData[0].updated = "";
    objectReportPrintElectronicWithholdingsData[0].updatedby = "";
    objectReportPrintElectronicWithholdingsData[0].issotrx = "";
    objectReportPrintElectronicWithholdingsData[0].documentno = "";
    objectReportPrintElectronicWithholdingsData[0].docstatus = "";
    objectReportPrintElectronicWithholdingsData[0].docaction = "";
    objectReportPrintElectronicWithholdingsData[0].processing = "";
    objectReportPrintElectronicWithholdingsData[0].processed = "";
    objectReportPrintElectronicWithholdingsData[0].posted = "";
    objectReportPrintElectronicWithholdingsData[0].cDoctypeId = "";
    objectReportPrintElectronicWithholdingsData[0].cDoctypetargetId = "";
    objectReportPrintElectronicWithholdingsData[0].cOrderId = "";
    objectReportPrintElectronicWithholdingsData[0].description = "";
    objectReportPrintElectronicWithholdingsData[0].isprinted = "";
    objectReportPrintElectronicWithholdingsData[0].salesrepId = "";
    objectReportPrintElectronicWithholdingsData[0].dateinvoiced = "";
    objectReportPrintElectronicWithholdingsData[0].dateprinted = "";
    objectReportPrintElectronicWithholdingsData[0].dateacct = "";
    objectReportPrintElectronicWithholdingsData[0].cBpartnerId = "";
    objectReportPrintElectronicWithholdingsData[0].cBpartnerLocationId = "";
    objectReportPrintElectronicWithholdingsData[0].poreference = "";
    objectReportPrintElectronicWithholdingsData[0].isdiscountprinted = "";
    objectReportPrintElectronicWithholdingsData[0].dateordered = "";
    objectReportPrintElectronicWithholdingsData[0].cCurrencyId = "";
    objectReportPrintElectronicWithholdingsData[0].paymentrule = "";
    objectReportPrintElectronicWithholdingsData[0].cPaymenttermId = "";
    objectReportPrintElectronicWithholdingsData[0].cChargeId = "";
    objectReportPrintElectronicWithholdingsData[0].chargeamt = "";
    objectReportPrintElectronicWithholdingsData[0].totallines = "";
    objectReportPrintElectronicWithholdingsData[0].grandtotal = "";
    objectReportPrintElectronicWithholdingsData[0].mPricelistId = "";
    objectReportPrintElectronicWithholdingsData[0].istaxincluded = "";
    objectReportPrintElectronicWithholdingsData[0].cCampaignId = "";
    objectReportPrintElectronicWithholdingsData[0].cProjectId = "";
    objectReportPrintElectronicWithholdingsData[0].cActivityId = "";
    objectReportPrintElectronicWithholdingsData[0].createfrom = "";
    objectReportPrintElectronicWithholdingsData[0].generateto = "";
    objectReportPrintElectronicWithholdingsData[0].adUserId = "";
    objectReportPrintElectronicWithholdingsData[0].copyfrom = "";
    objectReportPrintElectronicWithholdingsData[0].isselfservice = "";
    objectReportPrintElectronicWithholdingsData[0].adOrgtrxId = "";
    objectReportPrintElectronicWithholdingsData[0].user1Id = "";
    objectReportPrintElectronicWithholdingsData[0].user2Id = "";
    objectReportPrintElectronicWithholdingsData[0].withholdingamount = "";
    objectReportPrintElectronicWithholdingsData[0].taxdate = "";
    objectReportPrintElectronicWithholdingsData[0].cWithholdingId = "";
    objectReportPrintElectronicWithholdingsData[0].ispaid = "";
    objectReportPrintElectronicWithholdingsData[0].totalpaid = "";
    objectReportPrintElectronicWithholdingsData[0].outstandingamt = "";
    objectReportPrintElectronicWithholdingsData[0].daystilldue = "";
    objectReportPrintElectronicWithholdingsData[0].dueamt = "";
    objectReportPrintElectronicWithholdingsData[0].lastcalculatedondate = "";
    objectReportPrintElectronicWithholdingsData[0].updatepaymentmonitor = "";
    objectReportPrintElectronicWithholdingsData[0].finPaymentmethodId = "";
    objectReportPrintElectronicWithholdingsData[0].finPaymentPriorityId = "";
    objectReportPrintElectronicWithholdingsData[0].finalsettlement = "";
    objectReportPrintElectronicWithholdingsData[0].daysoutstanding = "";
    objectReportPrintElectronicWithholdingsData[0].percentageoverdue = "";
    objectReportPrintElectronicWithholdingsData[0].cCostcenterId = "";
    objectReportPrintElectronicWithholdingsData[0].calculatePromotions = "";
    objectReportPrintElectronicWithholdingsData[0].aAssetId = "";
    objectReportPrintElectronicWithholdingsData[0].iscashvat = "";
    objectReportPrintElectronicWithholdingsData[0].emSfbHashcode = "";
    objectReportPrintElectronicWithholdingsData[0].emSfbIsnotbudgetable = "";
    objectReportPrintElectronicWithholdingsData[0].emSfbBudgetAreaId = "";
    objectReportPrintElectronicWithholdingsData[0].emSfbIsbudgeted = "";
    objectReportPrintElectronicWithholdingsData[0].emSsflBillingPeriodFrom = "";
    objectReportPrintElectronicWithholdingsData[0].emSsflBillingPeriodTo = "";
    objectReportPrintElectronicWithholdingsData[0].emSsflIsforeign = "";
    objectReportPrintElectronicWithholdingsData[0].emSsflBankId = "";
    objectReportPrintElectronicWithholdingsData[0].emSsflObservation = "";
    objectReportPrintElectronicWithholdingsData[0].emSsflInvoiceReference = "";
    objectReportPrintElectronicWithholdingsData[0].emSsflTypeRecap = "";
    objectReportPrintElectronicWithholdingsData[0].emSsflPrintTypeRecap = "";
    objectReportPrintElectronicWithholdingsData[0].emSsflDescriptionvoyage = "";
    objectReportPrintElectronicWithholdingsData[0].emSsflRevised = "";
    objectReportPrintElectronicWithholdingsData[0].emSsflDeferred = "";
    objectReportPrintElectronicWithholdingsData[0].emSipcIsTaxExpence = "";
    objectReportPrintElectronicWithholdingsData[0].emSlciShipperId = "";
    objectReportPrintElectronicWithholdingsData[0].emSsreRefundedId = "";
    objectReportPrintElectronicWithholdingsData[0].emSsreCBpartnerId = "";
    objectReportPrintElectronicWithholdingsData[0].emSsreIsrefund = "";
    objectReportPrintElectronicWithholdingsData[0].emSswhTotalwithholdingincome = "";
    objectReportPrintElectronicWithholdingsData[0].emSswhTotalwithholdingvat = "";
    objectReportPrintElectronicWithholdingsData[0].emSswhReceiptId = "";
    objectReportPrintElectronicWithholdingsData[0].emSswhNroauthorization = "";
    objectReportPrintElectronicWithholdingsData[0].emSswhExpirationdate = "";
    objectReportPrintElectronicWithholdingsData[0].emSswhLivelihood = "";
    objectReportPrintElectronicWithholdingsData[0].emSswhCodelivelihood = "";
    objectReportPrintElectronicWithholdingsData[0].emSswhWithholdingref = "";
    objectReportPrintElectronicWithholdingsData[0].emSswhAuthorization = "";
    objectReportPrintElectronicWithholdingsData[0].emSswhDatewithhold = "";
    objectReportPrintElectronicWithholdingsData[0].emSswhCreditnote = "";
    objectReportPrintElectronicWithholdingsData[0].emSswhDateendinvoice = "";
    objectReportPrintElectronicWithholdingsData[0].emSswhInvoiceRef = "";
    objectReportPrintElectronicWithholdingsData[0].emSswhKeyei = "";
    objectReportPrintElectronicWithholdingsData[0].emSswhIseinvoice = "";
    objectReportPrintElectronicWithholdingsData[0].emSswhCDoctypeId = "";
    objectReportPrintElectronicWithholdingsData[0].emSswhBankaccountId = "";
    objectReportPrintElectronicWithholdingsData[0].emSswhWithholdingmanual = "";
    objectReportPrintElectronicWithholdingsData[0].emSswhAuthorizationmanual = "";
    objectReportPrintElectronicWithholdingsData[0].emSswhCreditnotereference = "";
    objectReportPrintElectronicWithholdingsData[0].emScnrInvoiceId = "";
    objectReportPrintElectronicWithholdingsData[0].emScnrIsrefInv = "";
    objectReportPrintElectronicWithholdingsData[0].emSqbQuickbillingId = "";
    objectReportPrintElectronicWithholdingsData[0].emEeiCodigo = "";
    objectReportPrintElectronicWithholdingsData[0].emEeiNumauto = "";
    objectReportPrintElectronicWithholdingsData[0].emEeiFechaauto = "";
    objectReportPrintElectronicWithholdingsData[0].emEeiFechaautotext = "";
    objectReportPrintElectronicWithholdingsData[0].emEeiGenerated = "";
    objectReportPrintElectronicWithholdingsData[0].emEeiSent = "";
    objectReportPrintElectronicWithholdingsData[0].emEeiEdocument = "";
    objectReportPrintElectronicWithholdingsData[0].emEeiRsiAuthNo = "";
    objectReportPrintElectronicWithholdingsData[0].emEeiCreditnote = "";
    objectReportPrintElectronicWithholdingsData[0].emEeiIsInvRef = "";
    objectReportPrintElectronicWithholdingsData[0].emEeiRefInvId = "";
    objectReportPrintElectronicWithholdingsData[0].emEeiDebitnote = "";
    objectReportPrintElectronicWithholdingsData[0].emEeiWithholdingSend = "";
    objectReportPrintElectronicWithholdingsData[0].emEeiUrlxml = "";
    objectReportPrintElectronicWithholdingsData[0].emEeiUrlride = "";
    objectReportPrintElectronicWithholdingsData[0].emEeiStatus = "";
    objectReportPrintElectronicWithholdingsData[0].emEeiTemporalsend = "";
    objectReportPrintElectronicWithholdingsData[0].emEeiResendinvoice = "";
    objectReportPrintElectronicWithholdingsData[0].emEeiGenerateOffline = "";
    objectReportPrintElectronicWithholdingsData[0].emAprmAddpayment = "";
    objectReportPrintElectronicWithholdingsData[0].emAprmProcessinvoice = "";
    objectReportPrintElectronicWithholdingsData[0].prepaymentamt = "";
    objectReportPrintElectronicWithholdingsData[0].emSfbIsdeferred = "";
    objectReportPrintElectronicWithholdingsData[0].emSfbDifferWithinYear = "";
    objectReportPrintElectronicWithholdingsData[0].emSsreLockdate = "";
    objectReportPrintElectronicWithholdingsData[0].emSsreIsrefunded = "";
    objectReportPrintElectronicWithholdingsData[0].emSsreLockedby = "";
    objectReportPrintElectronicWithholdingsData[0].emSpincoTaxid = "";
    objectReportPrintElectronicWithholdingsData[0].emEeiDescription = "";
    objectReportPrintElectronicWithholdingsData[0].emEcsapSigned = "";
    objectReportPrintElectronicWithholdingsData[0].emEcsapSign = "";
    objectReportPrintElectronicWithholdingsData[0].emEcsapAuthorization = "";
    objectReportPrintElectronicWithholdingsData[0].emEcsapAuthLevelId = "";
    objectReportPrintElectronicWithholdingsData[0].emEcsapReject = "";
    objectReportPrintElectronicWithholdingsData[0].emEeiStatus2 = "";
    objectReportPrintElectronicWithholdingsData[0].emEeiCodigo2 = "";
    objectReportPrintElectronicWithholdingsData[0].emEeiUrlxml2 = "";
    objectReportPrintElectronicWithholdingsData[0].emEeiUrlride2 = "";
    objectReportPrintElectronicWithholdingsData[0].emEeiNumauto2 = "";
    objectReportPrintElectronicWithholdingsData[0].emEeiFechaautotext2 = "";
    objectReportPrintElectronicWithholdingsData[0].emEeiGenerateOffline2 = "";
    objectReportPrintElectronicWithholdingsData[0].emEeiResendinvoice2 = "";
    return objectReportPrintElectronicWithholdingsData;
  }
}
