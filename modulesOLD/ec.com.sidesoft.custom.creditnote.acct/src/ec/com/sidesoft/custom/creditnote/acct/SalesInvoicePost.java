package ec.com.sidesoft.custom.creditnote.acct;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;

import javax.servlet.ServletException;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.ad_forms.Account;
import org.openbravo.erpCommon.ad_forms.AcctSchema;
import org.openbravo.erpCommon.ad_forms.AcctServer;
import org.openbravo.erpCommon.ad_forms.DocInvoice;
import org.openbravo.erpCommon.ad_forms.DocInvoiceTemplate;
import org.openbravo.erpCommon.ad_forms.DocLine;
import org.openbravo.erpCommon.ad_forms.DocLine_FinPaymentSchedule;
import org.openbravo.erpCommon.ad_forms.DocLine_Invoice;
import org.openbravo.erpCommon.ad_forms.DocLine_Payment;
import org.openbravo.erpCommon.ad_forms.DocTax;
import org.openbravo.erpCommon.ad_forms.Fact;
import org.openbravo.erpCommon.ad_forms.FactLine;
import org.openbravo.erpCommon.ad_forms.ProductInfo;
import org.openbravo.erpCommon.utility.CashVATUtil;
import org.openbravo.erpCommon.utility.SequenceIdData;
import org.openbravo.model.common.currency.ConversionRateDoc;

public class SalesInvoicePost extends DocInvoiceTemplate {
  static Logger log4jDocInvoice = Logger.getLogger(SalesInvoicePost.class);

  @Override
  public Fact createFact(DocInvoice docInvoice, AcctSchema as, ConnectionProvider conn,
      Connection con, VariablesSecureApp vars) throws ServletException {
    // create Fact Header
    Fact fact = new Fact(docInvoice, as, Fact.POST_Actual);
    String Fact_Acct_Group_ID = SequenceIdData.getUUID();
    // Cash based accounting
    if (!as.isAccrual())
      return null;

    log4jDocInvoice.debug("Point 2");
    // Receivables CR
    DocLine_FinPaymentSchedule[] m_payments = docInvoice.getM_payments();
    DocLine_Payment[] m_debt_payments = docInvoice.m_debt_payments;
    String C_BPartner_ID = docInvoice.C_BPartner_ID;
    String C_Currency_ID = docInvoice.C_Currency_ID;
    String DateAcct = docInvoice.DateAcct;
    String AD_Client_ID = docInvoice.AD_Client_ID;
    String AD_Org_ID = docInvoice.AD_Org_ID;
    String DocumentType = docInvoice.DocumentType;
    String Record_ID = docInvoice.Record_ID;
    if (m_payments == null || m_payments.length == 0)
      for (int i = 0; m_debt_payments != null && i < m_debt_payments.length; i++) {
        BigDecimal amount = new BigDecimal(m_debt_payments[i].getAmount());
        // BigDecimal ZERO = BigDecimal.ZERO;
        fact.createLine(
            m_debt_payments[i],
            getNCAccountBPartner(C_BPartner_ID, as, true, m_debt_payments[i].getDpStatus(), conn,
                docInvoice), C_Currency_ID, "", AcctServer.getConvertedAmt(
                ((amount.negate())).toPlainString(), m_debt_payments[i].getC_Currency_ID_From(),
                C_Currency_ID, DateAcct, "", AD_Client_ID, AD_Org_ID, conn), Fact_Acct_Group_ID,
            docInvoice.nextSeqNo(docInvoice.getSeqNo()), DocumentType, conn);
      }
    else
      for (int i = 0; m_payments != null && i < m_payments.length; i++) {
        BigDecimal amount = new BigDecimal(m_payments[i].getAmount());
        BigDecimal prepaidAmount = new BigDecimal(m_payments[i].getPrepaidAmount());
        fact.createLine(m_payments[i],
            getNCAccountBPartner(C_BPartner_ID, as, true, "false", conn, docInvoice),
            C_Currency_ID, "", amount.negate().toString(), Fact_Acct_Group_ID,
            docInvoice.nextSeqNo(docInvoice.getSeqNo()), DocumentType, conn);
        // Pre-payment: Probably not needed as at this point we can not generate pre-payments
        // against ARC. Amount is negated
        if (m_payments[i].getC_Currency_ID_From().equals(as.m_C_Currency_ID)
            && prepaidAmount.compareTo(BigDecimal.ZERO) != 0) {
          fact.createLine(m_payments[i],
              getNCAccountBPartner(C_BPartner_ID, as, true, "true", conn, docInvoice),
              C_Currency_ID, "", prepaidAmount.negate().toString(), Fact_Acct_Group_ID,
              docInvoice.nextSeqNo(docInvoice.getSeqNo()), DocumentType, conn);
        } else if (!m_payments[i].getC_Currency_ID_From().equals(as.m_C_Currency_ID)) {
          try {
            DocInvoiceData[] prepayments = DocInvoiceData.selectPrepayments(
                docInvoice.getConnectionProvider(), m_payments[i].getLine_ID(), Record_ID);
            for (int j = 0; j < prepayments.length; j++) {
              BigDecimal prePaymentAmt = docInvoice.convertAmount(new BigDecimal(
                  prepayments[j].prepaidamt), true, docInvoice.DateAcct,
                  docInvoice.TABLEID_Payment, prepayments[j].finPaymentId, docInvoice
                      .getM_payments()[i].getC_Currency_ID_From(), as.m_C_Currency_ID, docInvoice
                      .getM_payments()[i], as, fact, Fact_Acct_Group_ID, docInvoice
                      .nextSeqNo(docInvoice.getSeqNo()), conn);
              fact.createLine(m_payments[i],
                  getNCAccountBPartner(C_BPartner_ID, as, true, "true", conn, docInvoice),
                  m_payments[i].getC_Currency_ID_From(), "", prePaymentAmt.toString(),
                  Fact_Acct_Group_ID, docInvoice.nextSeqNo(docInvoice.getSeqNo()), DocumentType,
                  conn);
            }
          } catch (ServletException e) {
            log4jDocInvoice.warn(e);
          }
        }
      }
    if ((m_payments == null || m_payments.length == 0)
        && (m_debt_payments == null || m_debt_payments.length == 0)) {
      fact.createLine(null,
          getNCAccountBPartner(C_BPartner_ID, as, true, "false", conn, docInvoice), C_Currency_ID,
          "", docInvoice.Amounts[docInvoice.AMTTYPE_Gross], Fact_Acct_Group_ID,
          docInvoice.nextSeqNo(docInvoice.getSeqNo()), DocumentType, conn);
    }
    // Charge DR
    fact.createLine(null, docInvoice.getAccount(AcctServer.ACCTTYPE_Charge, as, conn),
        C_Currency_ID, docInvoice.getAmount(AcctServer.AMTTYPE_Charge), "", Fact_Acct_Group_ID,
        docInvoice.nextSeqNo(docInvoice.getSeqNo()), DocumentType, conn);
    // TaxDue DR
    DocTax[] m_taxes = docInvoice.getM_taxes();
    for (int i = 0; m_taxes != null && i < m_taxes.length; i++) {
      // New docLine created to assign C_Tax_ID value to the entry
      DocLine docLine = new DocLine(DocumentType, Record_ID, "");
      docLine.m_C_Tax_ID = m_taxes[i].m_C_Tax_ID;

      BigDecimal percentageFinalAccount = CashVATUtil._100;
      final BigDecimal taxesAmountTotal = new BigDecimal(
          StringUtils.isBlank(m_taxes[i].getAmount()) ? "0" : m_taxes[i].getAmount());
      BigDecimal taxToTransAccount = BigDecimal.ZERO;
      if (docInvoice.isCashVAT && m_taxes[i].m_isCashVAT) {
        percentageFinalAccount = CashVATUtil.calculatePrepaidPercentageForCashVATTax(
            m_taxes[i].m_C_Tax_ID, Record_ID);
        taxToTransAccount = CashVATUtil.calculatePercentageAmount(
            CashVATUtil._100.subtract(percentageFinalAccount), taxesAmountTotal, C_Currency_ID);
        fact.createLine(docLine, m_taxes[i].getAccount(DocTax.ACCTTYPE_TaxDue_Trans, as, conn),
            C_Currency_ID, taxToTransAccount.toString(), "", Fact_Acct_Group_ID,
            docInvoice.nextSeqNo(docInvoice.getSeqNo()), DocumentType, conn);
      }
      final BigDecimal taxToFinalAccount = taxesAmountTotal.subtract(taxToTransAccount);
      fact.createLine(docLine, m_taxes[i].getAccount(DocTax.ACCTTYPE_TaxDue, as, conn),
          C_Currency_ID, taxToFinalAccount.toString(), "", Fact_Acct_Group_ID,
          docInvoice.nextSeqNo(docInvoice.getSeqNo()), DocumentType, conn);
    }
    // Revenue CR
    DocLine[] p_lines = docInvoice.p_lines;
    for (int i = 0; p_lines != null && i < p_lines.length; i++) {
      String amount = p_lines[i].getAmount();
      String amountCoverted = "";
      ConversionRateDoc conversionRateCurrentDoc = docInvoice.getConversionRateDoc(
          docInvoice.TABLEID_Invoice, Record_ID, C_Currency_ID, as.m_C_Currency_ID);
      if (conversionRateCurrentDoc != null) {
        amountCoverted = docInvoice
            .applyRate(new BigDecimal(p_lines[i].getAmount()), conversionRateCurrentDoc, true)
            .setScale(2, RoundingMode.HALF_UP).toString();
      } else {
        amountCoverted = docInvoice.getConvertedAmt(p_lines[i].getAmount(), C_Currency_ID,
            as.m_C_Currency_ID, DateAcct, "", AD_Client_ID, AD_Org_ID, conn);
      }
      Account account = ((DocLine_Invoice) p_lines[i]).getAccount(ProductInfo.ACCTTYPE_P_Revenue,
          as, conn);
      if (((DocLine_Invoice) p_lines[i]).isDeferred()) {
        amount = docInvoice.createAccDefRevenueFact(fact, (DocLine_Invoice) p_lines[i], account,
            ((DocLine_Invoice) p_lines[i]).getAccount(ProductInfo.ACCTTYPE_P_DefRevenue, as, conn),
            amountCoverted, as.m_C_Currency_ID, conn);
        fact.createLine(p_lines[i], account, as.m_C_Currency_ID, amount, "", Fact_Acct_Group_ID,
            docInvoice.nextSeqNo(docInvoice.getSeqNo()), DocumentType, conn);
      } else {
        fact.createLine(p_lines[i], account, C_Currency_ID, amount, "", Fact_Acct_Group_ID,
            docInvoice.nextSeqNo(docInvoice.getSeqNo()), DocumentType, conn);
      }
      // If revenue has been deferred
      if (((DocLine_Invoice) p_lines[i]).isDeferred() && !amount.equals(amountCoverted)) {
        amount = new BigDecimal(amountCoverted).subtract(new BigDecimal(amount)).toString();
        fact.createLine(p_lines[i],
            ((DocLine_Invoice) p_lines[i]).getAccount(ProductInfo.ACCTTYPE_P_DefRevenue, as, conn),
            as.m_C_Currency_ID, amount, "", Fact_Acct_Group_ID,
            docInvoice.nextSeqNo(docInvoice.getSeqNo()), DocumentType, conn);
      }
    }
    // Set Locations
    FactLine[] fLines = fact.getLines();
    for (int i = 0; fLines != null && i < fLines.length; i++) {
      if (fLines[i] != null) {
        fLines[i].setLocationFromOrg(fLines[i].getAD_Org_ID(conn), true, conn); // from Loc
        fLines[i].setLocationFromBPartner(docInvoice.C_BPartner_Location_ID, false, conn); // to Loc
      }
    }

    docInvoice.setSeqNo("0");
    return fact;
  }

  private Account getNCAccountBPartner(String cBPartnerId, AcctSchema as, boolean isReceipt,
      String dpStatus, ConnectionProvider conn, DocInvoice docInvoice) {
    DocInvoiceData[] data = null;
    try {
      data = DocInvoiceData.selectBPartnerCustomerAcct(conn, cBPartnerId, as.m_C_AcctSchema_ID,
          dpStatus);
    } catch (ServletException e) {
      log4jDocInvoice.warn(e);
    }

    // Get Acct
    String Account_ID = "";
    if (data != null && data.length != 0) {
      Account_ID = data[0].accountId;
    } else
      return null;
    // No account
    if (Account_ID.equals("")) {
      log4jDocInvoice.warn("DocInvoice - getAccountBPartner - NO account BPartner=" + cBPartnerId
          + ", Record=" + docInvoice.Record_ID + ", status " + dpStatus);
      return null;
    }
    // Return Account
    Account acct = null;

    try {
      acct = Account.getAccount(conn, Account_ID);
    } catch (ServletException e) {
      log4jDocInvoice.warn(e);
    }
    return acct;
  }

}
