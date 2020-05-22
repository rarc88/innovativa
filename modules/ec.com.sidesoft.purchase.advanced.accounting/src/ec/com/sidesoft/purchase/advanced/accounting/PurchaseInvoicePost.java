package ec.com.sidesoft.purchase.advanced.accounting;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.ad_forms.Account;
import org.openbravo.erpCommon.ad_forms.AcctSchema;
import org.openbravo.erpCommon.ad_forms.AcctServer;
import org.openbravo.erpCommon.ad_forms.DocInvoice;
import org.openbravo.erpCommon.ad_forms.DocInvoiceTemplate;
import org.openbravo.erpCommon.ad_forms.DocLine;
import org.openbravo.erpCommon.ad_forms.DocLine_Invoice;
import org.openbravo.erpCommon.ad_forms.DocTax;
import org.openbravo.erpCommon.ad_forms.Fact;
import org.openbravo.erpCommon.ad_forms.FactLine;
import org.openbravo.erpCommon.ad_forms.ProductInfo;
import org.openbravo.erpCommon.utility.CashVATUtil;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.SequenceIdData;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.model.ad.system.ClientInformation;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.businesspartner.VendorAccounts;
import org.openbravo.model.common.currency.ConversionRateDoc;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.common.invoice.InvoiceLine;

public class PurchaseInvoicePost extends DocInvoiceTemplate {
  static Logger log4jDocInvoice = Logger.getLogger(DocInvoice.class);
  private BigDecimal totalamtForLineForPos = BigDecimal.ZERO;

  @Override
  public Fact createFact(DocInvoice docInvoice, AcctSchema as, ConnectionProvider conn,
      Connection con, VariablesSecureApp vars) throws ServletException {
    // create Fact Header
    Fact fact = new Fact(docInvoice, as, Fact.POST_Actual);
    String Fact_Acct_Group_ID = SequenceIdData.getUUID();
    // Cash based accounting
    if (!as.isAccrual())
      return null;

    /** @todo Assumes TaxIncluded = N */

    // API
    if (docInvoice.DocumentType.equals(AcctServer.DOCTYPE_APInvoice)) {
      log4jDocInvoice.debug("Point 3");

      Invoice invoice = OBDal.getInstance().get(Invoice.class, docInvoice.Record_ID);

      DocLineInvoiceData[] InvoiceLineNotConfig = DocLineInvoiceData.existInvoiceLineNotConfig(
          conn, docInvoice.Record_ID, as.getC_AcctSchema_ID(), docInvoice.C_BPartner_ID);

      if (InvoiceLineNotConfig.length > 0) {
        docInvoice.setStatus("E");
        OBError err = new OBError();
        err.setType("Error");
        err.setMessage(Utility.messageBD(conn, "SPAA_ErrorPosPurchaseInvoice", vars.getLanguage()));
        docInvoice.setMessageResult(err);
        return null;
      }

      log4jDocInvoice.debug("Point 3");
      // Liability CR
      int p_linePosition = 0;
      if (docInvoice.getM_payments() == null || docInvoice.getM_payments().length == 0)
        for (int i = 0; docInvoice.m_debt_payments != null && i < docInvoice.m_debt_payments.length; i++) {
          BigDecimal debtPaymentAmount = new BigDecimal(docInvoice.m_debt_payments[i].getAmount());
          p_linePosition = posForInvoiceLine(docInvoice, as, conn, fact, Fact_Acct_Group_ID,
              debtPaymentAmount, p_linePosition, false);
          p_linePosition = totalamtForLineForPos.compareTo(BigDecimal.ZERO) == 0 ? p_linePosition + 1
              : p_linePosition;
        }
      else
        for (int i = 0; docInvoice.getM_payments() != null && i < docInvoice.getM_payments().length; i++) {
          BigDecimal debtPaymentAmount = new BigDecimal(docInvoice.getM_payments()[i].getAmount());
          p_linePosition = posForInvoiceLine(docInvoice, as, conn, fact, Fact_Acct_Group_ID,
              debtPaymentAmount, p_linePosition, false);
          p_linePosition = totalamtForLineForPos.compareTo(BigDecimal.ZERO) == 0 ? p_linePosition + 1
              : p_linePosition;

          if (docInvoice.getM_payments()[i].getC_Currency_ID_From().equals(as.m_C_Currency_ID)
              && new BigDecimal(docInvoice.getM_payments()[i].getPrepaidAmount())
                  .compareTo(docInvoice.ZERO) != 0) {
            debtPaymentAmount = new BigDecimal(docInvoice.getM_payments()[i].getPrepaidAmount());

            p_linePosition = posForInvoiceLine(docInvoice, as, conn, fact, Fact_Acct_Group_ID,
                debtPaymentAmount, p_linePosition, true);

            p_linePosition = totalamtForLineForPos.compareTo(BigDecimal.ZERO) == 0 ? p_linePosition + 1
                : p_linePosition;

          } else if (!docInvoice.getM_payments()[i].getC_Currency_ID_From().equals(
              as.m_C_Currency_ID)) {
            try {
              DocInvoiceData[] prepayments = DocInvoiceData.selectPrepayments(
                  docInvoice.getConnectionProvider(), docInvoice.getM_payments()[i].getLine_ID());
              for (int j = 0; j < prepayments.length; j++) {
                BigDecimal prePaymentAmt = docInvoice.convertAmount(new BigDecimal(
                    prepayments[j].prepaidamt), false, docInvoice.DateAcct,
                    AcctServer.TABLEID_Payment, prepayments[j].finPaymentId, docInvoice
                        .getM_payments()[i].getC_Currency_ID_From(), as.m_C_Currency_ID, docInvoice
                        .getM_payments()[i], as, fact, Fact_Acct_Group_ID, docInvoice
                        .nextSeqNo(docInvoice.getSeqNo()), conn);
                p_linePosition = posForInvoiceLine(docInvoice, as, conn, fact, Fact_Acct_Group_ID,
                    prePaymentAmt, p_linePosition, true);
                p_linePosition = totalamtForLineForPos.compareTo(BigDecimal.ZERO) == 0 ? p_linePosition + 1
                    : p_linePosition;

              }
            } catch (ServletException e) {
              log4jDocInvoice.warn(e);
            }
          }
        }
      if ((docInvoice.getM_payments() == null || docInvoice.getM_payments().length == 0)
          && (docInvoice.m_debt_payments == null || docInvoice.m_debt_payments.length == 0)) {

        p_linePosition = 0;
        BigDecimal debtPaymentAmount = new BigDecimal(docInvoice.Amounts[AcctServer.AMTTYPE_Gross]);
        p_linePosition = posForInvoiceLine(docInvoice, as, conn, fact, Fact_Acct_Group_ID,
            debtPaymentAmount, p_linePosition, false);
      }

      // Charge DR
      fact.createLine(null, docInvoice.getAccount(AcctServer.ACCTTYPE_Charge, as, conn),
          docInvoice.C_Currency_ID, docInvoice.getAmount(AcctServer.AMTTYPE_Charge), "",
          Fact_Acct_Group_ID, docInvoice.nextSeqNo(docInvoice.getSeqNo()), docInvoice.DocumentType,
          conn);

      // If IsTaxExpense don't post taxes
      ClientInformation clientInfo = OBDal.getInstance().get(ClientInformation.class,
          docInvoice.AD_Client_ID);
      boolean isTaxExpense = false;
      try {
        OBContext.setAdminMode(true);

        isTaxExpense = clientInfo.isSipcIsTaxExpence();
      } finally {
        OBContext.restorePreviousMode();
      }

      // TaxCredit DR Only Withholdings
      DocTax[] taxExpenseWithholdings = loadWithholdingsTaxes(conn, docInvoice.Record_ID);
      for (int i = 0; taxExpenseWithholdings != null && i < taxExpenseWithholdings.length; i++) {
        // New docLine created to assign C_Tax_ID value to the entry
        DocLine docLine = new DocLine(docInvoice.DocumentType, docInvoice.Record_ID, "");
        docLine.m_C_Tax_ID = taxExpenseWithholdings[i].m_C_Tax_ID;

        if (!taxExpenseWithholdings[i].m_isTaxUndeductable) {
          BigDecimal percentageFinalAccount = CashVATUtil._100;
          final BigDecimal taxesAmountTotal = new BigDecimal(
              StringUtils.isBlank(taxExpenseWithholdings[i].getAmount()) ? "0"
                  : taxExpenseWithholdings[i].getAmount());
          BigDecimal taxToTransAccount = BigDecimal.ZERO;
          if (docInvoice.IsReversal.equals("Y")) {
            if (docInvoice.isCashVAT && docInvoice.getM_taxes()[i].m_isCashVAT) {
              percentageFinalAccount = CashVATUtil.calculatePrepaidPercentageForCashVATTax(
                  taxExpenseWithholdings[i].m_C_Tax_ID, docInvoice.Record_ID);
              taxToTransAccount = CashVATUtil.calculatePercentageAmount(
                  CashVATUtil._100.subtract(percentageFinalAccount), taxesAmountTotal,
                  docInvoice.C_Currency_ID);
              fact.createLine(docLine,
                  taxExpenseWithholdings[i].getAccount(DocTax.ACCTTYPE_TaxCredit_Trans, as, conn),
                  docInvoice.C_Currency_ID, "", taxToTransAccount.toString(), Fact_Acct_Group_ID,
                  docInvoice.nextSeqNo(docInvoice.getSeqNo()), docInvoice.DocumentType, conn);
            }
            final BigDecimal taxToFinalAccount = taxesAmountTotal.subtract(taxToTransAccount);
            fact.createLine(docLine,
                taxExpenseWithholdings[i].getAccount(DocTax.ACCTTYPE_TaxCredit, as, conn),
                docInvoice.C_Currency_ID, "", taxToFinalAccount.toString(), Fact_Acct_Group_ID,
                docInvoice.nextSeqNo(docInvoice.getSeqNo()), docInvoice.DocumentType, conn);

          } else {
            if (docInvoice.isCashVAT && docInvoice.getM_taxes()[i].m_isCashVAT) {
              percentageFinalAccount = CashVATUtil.calculatePrepaidPercentageForCashVATTax(
                  taxExpenseWithholdings[i].m_C_Tax_ID, docInvoice.Record_ID);
              taxToTransAccount = CashVATUtil.calculatePercentageAmount(
                  CashVATUtil._100.subtract(percentageFinalAccount), taxesAmountTotal,
                  docInvoice.C_Currency_ID);
              fact.createLine(docLine,
                  taxExpenseWithholdings[i].getAccount(DocTax.ACCTTYPE_TaxCredit_Trans, as, conn),
                  docInvoice.C_Currency_ID, taxToTransAccount.toString(), "", Fact_Acct_Group_ID,
                  docInvoice.nextSeqNo(docInvoice.getSeqNo()), docInvoice.DocumentType, conn);
            }
            final BigDecimal taxToFinalAccount = taxesAmountTotal.subtract(taxToTransAccount);
            fact.createLine(docLine,
                taxExpenseWithholdings[i].getAccount(DocTax.ACCTTYPE_TaxCredit, as, conn),
                docInvoice.C_Currency_ID, taxToFinalAccount.toString(), "", Fact_Acct_Group_ID,
                docInvoice.nextSeqNo(docInvoice.getSeqNo()), docInvoice.DocumentType, conn);
          }
        }
      }

      // TaxLineExpenseCredit DR
      DocLineTax[] taxExpenseLines = loadLineTaxes(as, conn, docInvoice.Record_ID);
      for (int i = 0; taxExpenseLines != null && i < taxExpenseLines.length; i++) {
        // New docLine created to assign C_Tax_ID value to the entry
        DocLine docLine = new DocLine(docInvoice.DocumentType, docInvoice.Record_ID, "");
        docLine.m_C_Tax_ID = taxExpenseLines[i].m_C_Tax_ID;

        if (!taxExpenseLines[i].m_isTaxUndeductable) {
          BigDecimal percentageFinalAccount = CashVATUtil._100;
          final BigDecimal taxesAmountTotal = new BigDecimal(StringUtils.isBlank(taxExpenseLines[i]
              .getAmount()) ? "0" : taxExpenseLines[i].getAmount());
          BigDecimal taxToTransAccount = BigDecimal.ZERO;
          if (docInvoice.IsReversal.equals("Y")) {
            if (docInvoice.isCashVAT && docInvoice.getM_taxes()[i].m_isCashVAT) {
              percentageFinalAccount = CashVATUtil.calculatePrepaidPercentageForCashVATTax(
                  taxExpenseLines[i].m_C_Tax_ID, docInvoice.Record_ID);
              taxToTransAccount = CashVATUtil.calculatePercentageAmount(
                  CashVATUtil._100.subtract(percentageFinalAccount), taxesAmountTotal,
                  docInvoice.C_Currency_ID);
              if (isTaxExpense || invoice.isSIPCTaxExpenses() || taxExpenseLines[i].m_isTaxExpence) {
                fact.createLine(docLine,
                    Account.getAccount(conn, taxExpenseLines[i].m_AssetAcct_ID),
                    docInvoice.C_Currency_ID, "", taxToTransAccount.toString(), Fact_Acct_Group_ID,
                    docInvoice.nextSeqNo(docInvoice.getSeqNo()), docInvoice.DocumentType, conn);
              } else {
                fact.createLine(docLine,
                    taxExpenseLines[i].getAccount(DocTax.ACCTTYPE_TaxCredit_Trans, as, conn),
                    docInvoice.C_Currency_ID, "", taxToTransAccount.toString(), Fact_Acct_Group_ID,
                    docInvoice.nextSeqNo(docInvoice.getSeqNo()), docInvoice.DocumentType, conn);
              }

            }
            final BigDecimal taxToFinalAccount = taxesAmountTotal.subtract(taxToTransAccount);
            if (isTaxExpense || invoice.isSIPCTaxExpenses() || taxExpenseLines[i].m_isTaxExpence) {
              fact.createLine(docLine, Account.getAccount(conn, taxExpenseLines[i].m_AssetAcct_ID),
                  docInvoice.C_Currency_ID, "", taxToFinalAccount.toString(), Fact_Acct_Group_ID,
                  docInvoice.nextSeqNo(docInvoice.getSeqNo()), docInvoice.DocumentType, conn);
            } else {
              fact.createLine(docLine,
                  taxExpenseLines[i].getAccount(DocTax.ACCTTYPE_TaxCredit, as, conn),
                  docInvoice.C_Currency_ID, "", taxToFinalAccount.toString(), Fact_Acct_Group_ID,
                  docInvoice.nextSeqNo(docInvoice.getSeqNo()), docInvoice.DocumentType, conn);
            }

          } else {
            if (docInvoice.isCashVAT && docInvoice.getM_taxes()[i].m_isCashVAT) {
              percentageFinalAccount = CashVATUtil.calculatePrepaidPercentageForCashVATTax(
                  taxExpenseLines[i].m_C_Tax_ID, docInvoice.Record_ID);
              taxToTransAccount = CashVATUtil.calculatePercentageAmount(
                  CashVATUtil._100.subtract(percentageFinalAccount), taxesAmountTotal,
                  docInvoice.C_Currency_ID);
              if (isTaxExpense || invoice.isSIPCTaxExpenses() || taxExpenseLines[i].m_isTaxExpence) {
                fact.createLine(docLine,
                    Account.getAccount(conn, taxExpenseLines[i].m_AssetAcct_ID),
                    docInvoice.C_Currency_ID, taxToTransAccount.toString(), "", Fact_Acct_Group_ID,
                    docInvoice.nextSeqNo(docInvoice.getSeqNo()), docInvoice.DocumentType, conn);
              } else {
                fact.createLine(docLine,
                    taxExpenseLines[i].getAccount(DocTax.ACCTTYPE_TaxCredit_Trans, as, conn),
                    docInvoice.C_Currency_ID, taxToTransAccount.toString(), "", Fact_Acct_Group_ID,
                    docInvoice.nextSeqNo(docInvoice.getSeqNo()), docInvoice.DocumentType, conn);
              }
            }
            final BigDecimal taxToFinalAccount = taxesAmountTotal.subtract(taxToTransAccount);
            if (isTaxExpense || invoice.isSIPCTaxExpenses() || taxExpenseLines[i].m_isTaxExpence) {
              fact.createLine(docLine, Account.getAccount(conn, taxExpenseLines[i].m_AssetAcct_ID),
                  docInvoice.C_Currency_ID, taxToFinalAccount.toString(), "", Fact_Acct_Group_ID,
                  docInvoice.nextSeqNo(docInvoice.getSeqNo()), docInvoice.DocumentType, conn);
            } else {
              fact.createLine(docLine,
                  taxExpenseLines[i].getAccount(DocTax.ACCTTYPE_TaxCredit, as, conn),
                  docInvoice.C_Currency_ID, taxToFinalAccount.toString(), "", Fact_Acct_Group_ID,
                  docInvoice.nextSeqNo(docInvoice.getSeqNo()), docInvoice.DocumentType, conn);
            }

          }
        } else {
          DocLineInvoiceData[] data = null;
          try {
            data = DocLineInvoiceData.selectUndeductable(docInvoice.getConnectionProvider(),
                docInvoice.Record_ID);
          } catch (ServletException e) {
            log4jDocInvoice.warn(e);
          }

          BigDecimal cumulativeTaxLineAmount = new BigDecimal(0);
          BigDecimal taxAmount = new BigDecimal(0);
          for (int j = 0; data != null && j < data.length; j++) {
            DocLine docLine1 = new DocLine(docInvoice.DocumentType, docInvoice.Record_ID, "");
            docLine1.m_C_Tax_ID = data[j].cTaxId;
            docLine1.m_C_BPartner_ID = data[j].cBpartnerId;
            docLine1.m_M_Product_ID = data[j].mProductId;
            docLine1.m_C_Costcenter_ID = data[j].cCostcenterId;
            docLine1.m_C_Project_ID = data[j].cProjectId;
            docLine1.m_User1_ID = data[j].user1id;
            docLine1.m_User2_ID = data[j].user2id;
            docLine1.m_C_Activity_ID = data[j].cActivityId;
            docLine1.m_C_Campaign_ID = data[j].cCampaignId;
            docLine1.m_A_Asset_ID = data[j].aAssetId;
            String strtaxAmount = null;

            try {

              DocInvoiceData[] dataEx = DocInvoiceData.selectProductAcct(conn,
                  as.getC_AcctSchema_ID(), taxExpenseLines[i].m_C_Tax_ID, docInvoice.Record_ID);
              if (dataEx.length == 0) {
                dataEx = DocInvoiceData.selectGLItemAcctForTaxLine(conn, as.getC_AcctSchema_ID(),
                    taxExpenseLines[i].m_C_Tax_ID, docInvoice.Record_ID);
              }
              strtaxAmount = taxExpenseLines[i].getAmount();
              taxAmount = new BigDecimal(strtaxAmount.equals("") ? "0.00" : strtaxAmount);
              if (j == data.length - 1) {
                data[j].taxamt = taxAmount.subtract(cumulativeTaxLineAmount).toPlainString();
              }
              try {

                if (docInvoice.DocumentType.equals(AcctServer.DOCTYPE_APInvoice)) {
                  if (docInvoice.IsReversal.equals("Y")) {
                    fact.createLine(docLine1, Account.getAccount(conn, dataEx[0].pExpenseAcct),
                        docInvoice.C_Currency_ID, "", data[j].taxamt, Fact_Acct_Group_ID,
                        docInvoice.nextSeqNo(docInvoice.getSeqNo()), docInvoice.DocumentType, conn);

                  } else {
                    fact.createLine(docLine1, Account.getAccount(conn, dataEx[0].pExpenseAcct),
                        docInvoice.C_Currency_ID, data[j].taxamt, "", Fact_Acct_Group_ID,
                        docInvoice.nextSeqNo(docInvoice.getSeqNo()), docInvoice.DocumentType, conn);
                  }
                } else if (docInvoice.DocumentType.equals(AcctServer.DOCTYPE_APCredit)) {
                  fact.createLine(docLine1, Account.getAccount(conn, dataEx[0].pExpenseAcct),
                      docInvoice.C_Currency_ID, "", data[j].taxamt, Fact_Acct_Group_ID,
                      docInvoice.nextSeqNo(docInvoice.getSeqNo()), docInvoice.DocumentType, conn);
                }
                cumulativeTaxLineAmount = cumulativeTaxLineAmount
                    .add(new BigDecimal(data[j].taxamt));
              } catch (ServletException e) {
                log4jDocInvoice.error("Exception in createLineForTaxUndeductable method: " + e);
              }
            } catch (ServletException e) {
              log4jDocInvoice.warn(e);
            }

          }
        }
      }

      // Expense DR
      for (int i = 0; docInvoice.p_lines != null && i < docInvoice.p_lines.length; i++) {
        String amount = docInvoice.p_lines[i].getAmount();
        String amountConverted = "";
        ConversionRateDoc conversionRateCurrentDoc = docInvoice.getConversionRateDoc(
            AcctServer.TABLEID_Invoice, docInvoice.Record_ID, docInvoice.C_Currency_ID,
            as.m_C_Currency_ID);
        if (conversionRateCurrentDoc != null) {
          amountConverted = AcctServer
              .applyRate(new BigDecimal(docInvoice.p_lines[i].getAmount()),
                  conversionRateCurrentDoc, true).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        } else {
          amountConverted = AcctServer.getConvertedAmt(docInvoice.p_lines[i].getAmount(),
              docInvoice.C_Currency_ID, as.m_C_Currency_ID, docInvoice.DateAcct, "",
              docInvoice.AD_Client_ID, docInvoice.AD_Org_ID, conn);
        }
        if (((DocLine_Invoice) docInvoice.p_lines[i]).isDeferred()) {
          amount = docInvoice.createAccDefExpenseFact(fact,
              (DocLine_Invoice) docInvoice.p_lines[i], ((DocLine_Invoice) docInvoice.p_lines[i])
                  .getAccount(ProductInfo.ACCTTYPE_P_Expense, as, conn),
              ((DocLine_Invoice) docInvoice.p_lines[i]).getAccount(
                  ProductInfo.ACCTTYPE_P_DefExpense, as, conn), amountConverted,
              as.m_C_Currency_ID, conn);
          if (docInvoice.IsReversal.equals("Y")) {
            fact.createLine(docInvoice.p_lines[i], ((DocLine_Invoice) docInvoice.p_lines[i])
                .getAccount(ProductInfo.ACCTTYPE_P_Expense, as, conn), as.m_C_Currency_ID, "",
                amount, Fact_Acct_Group_ID, docInvoice.nextSeqNo(docInvoice.getSeqNo()),
                docInvoice.DocumentType, conn);
          } else {
            fact.createLine(docInvoice.p_lines[i], ((DocLine_Invoice) docInvoice.p_lines[i])
                .getAccount(ProductInfo.ACCTTYPE_P_Expense, as, conn), as.m_C_Currency_ID, amount,
                "", Fact_Acct_Group_ID, docInvoice.nextSeqNo(docInvoice.getSeqNo()),
                docInvoice.DocumentType, conn);
          }
        } else {
          if (docInvoice.IsReversal.equals("Y")) {
            fact.createLine(docInvoice.p_lines[i], ((DocLine_Invoice) docInvoice.p_lines[i])
                .getAccount(ProductInfo.ACCTTYPE_P_Expense, as, conn), docInvoice.C_Currency_ID,
                "", amount, Fact_Acct_Group_ID, docInvoice.nextSeqNo(docInvoice.getSeqNo()),
                docInvoice.DocumentType, conn); // End IsTaxExpense
          } else {
            fact.createLine(docInvoice.p_lines[i], ((DocLine_Invoice) docInvoice.p_lines[i])
                .getAccount(ProductInfo.ACCTTYPE_P_Expense, as, conn), docInvoice.C_Currency_ID,
                amount, "", Fact_Acct_Group_ID, docInvoice.nextSeqNo(docInvoice.getSeqNo()),
                docInvoice.DocumentType, conn);
          }
        }
        // If expense has been deferred
        if (((DocLine_Invoice) docInvoice.p_lines[i]).isDeferred()
            && !amount.equals(amountConverted)) {
          amount = new BigDecimal(amountConverted).subtract(new BigDecimal(amount)).toString();
          if (docInvoice.IsReversal.equals("Y")) {
            fact.createLine(docInvoice.p_lines[i], ((DocLine_Invoice) docInvoice.p_lines[i])
                .getAccount(ProductInfo.ACCTTYPE_P_DefExpense, as, conn), as.m_C_Currency_ID, "",
                amount, Fact_Acct_Group_ID, docInvoice.nextSeqNo(docInvoice.getSeqNo()),
                docInvoice.DocumentType, conn);
          } else {
            fact.createLine(docInvoice.p_lines[i], ((DocLine_Invoice) docInvoice.p_lines[i])
                .getAccount(ProductInfo.ACCTTYPE_P_DefExpense, as, conn), as.m_C_Currency_ID,
                amount, "", Fact_Acct_Group_ID, docInvoice.nextSeqNo(docInvoice.getSeqNo()),
                docInvoice.DocumentType, conn);
          }
        }
      }
      // Set Locations
      FactLine[] fLines = fact.getLines();
      for (int i = 0; fLines != null && i < fLines.length; i++) {
        if (fLines[i] != null) {
          fLines[i].setLocationFromBPartner(docInvoice.C_BPartner_Location_ID, true, conn); // from
                                                                                            // Loc
          fLines[i].setLocationFromOrg(fLines[i].getAD_Org_ID(conn), false, conn); // to Loc
        }
      }
      docInvoice.updateProductInfo(as.getC_AcctSchema_ID(), conn, con); // only API
    }
    // APC
    else if (docInvoice.DocumentType.equals(AcctServer.DOCTYPE_APCredit)) {
      log4jDocInvoice.debug("Point 4");

      DocLineInvoiceData[] InvoiceLineNotConfig = DocLineInvoiceData.existInvoiceLineNotConfig(
          conn, docInvoice.Record_ID, as.getC_AcctSchema_ID(), docInvoice.C_BPartner_ID);

      if (InvoiceLineNotConfig.length > 0) {
        docInvoice.setStatus("E");
        OBError err = new OBError();
        err.setType("Error");
        err.setMessage(Utility.messageBD(conn, "SPAA_ErrorPosPurchaseInvoice", vars.getLanguage()));
        docInvoice.setMessageResult(err);
        return null;
      }

      Invoice invoice = OBDal.getInstance().get(Invoice.class, docInvoice.Record_ID);
      // Liability DR
      int p_linePosition = 0;
      if (docInvoice.getM_payments() == null || docInvoice.getM_payments().length == 0)
        for (int i = 0; docInvoice.m_debt_payments != null && i < docInvoice.m_debt_payments.length; i++) {
          BigDecimal amount = new BigDecimal(docInvoice.m_debt_payments[i].getAmount());
          p_linePosition = posForInvoiceLineNCProvedor(docInvoice, as, conn, fact,
              Fact_Acct_Group_ID, amount, p_linePosition, false);
          p_linePosition = totalamtForLineForPos.compareTo(BigDecimal.ZERO) == 0 ? p_linePosition + 1
              : p_linePosition;
        }
      else
        for (int i = 0; docInvoice.getM_payments() != null && i < docInvoice.getM_payments().length; i++) {
          BigDecimal amount = new BigDecimal(docInvoice.getM_payments()[i].getAmount());

          BigDecimal prepaidAmount = new BigDecimal(
              docInvoice.getM_payments()[i].getPrepaidAmount());

          p_linePosition = posForInvoiceLineNCProvedor(docInvoice, as, conn, fact,
              Fact_Acct_Group_ID, amount, p_linePosition, false);
          p_linePosition = totalamtForLineForPos.compareTo(BigDecimal.ZERO) == 0 ? p_linePosition + 1
              : p_linePosition;
          // Pre-payment: Probably not needed as at this point we can not generate pre-payments
          // against APC. Amount is negated
          if (docInvoice.getM_payments()[i].getC_Currency_ID_From().equals(as.m_C_Currency_ID)
              && prepaidAmount.compareTo(docInvoice.ZERO) != 0) {
            p_linePosition = posForInvoiceLineNCProvedor(docInvoice, as, conn, fact,
                Fact_Acct_Group_ID, prepaidAmount, p_linePosition, true);
            p_linePosition = totalamtForLineForPos.compareTo(BigDecimal.ZERO) == 0 ? p_linePosition + 1
                : p_linePosition;
          } else if (!docInvoice.getM_payments()[i].getC_Currency_ID_From().equals(
              as.m_C_Currency_ID)) {
            try {
              DocInvoiceData[] prepayments = DocInvoiceData.selectPrepayments(
                  docInvoice.getConnectionProvider(), docInvoice.getM_payments()[i].getLine_ID());
              for (int j = 0; j < prepayments.length; j++) {
                BigDecimal prePaymentAmt = docInvoice.convertAmount(new BigDecimal(
                    prepayments[j].prepaidamt).negate(), false, docInvoice.DateAcct,
                    AcctServer.TABLEID_Payment, prepayments[j].finPaymentId, docInvoice
                        .getM_payments()[i].getC_Currency_ID_From(), as.m_C_Currency_ID, docInvoice
                        .getM_payments()[i], as, fact, Fact_Acct_Group_ID, docInvoice
                        .nextSeqNo(docInvoice.getSeqNo()), conn);

                p_linePosition = posForInvoiceLineNCProvedor(docInvoice, as, conn, fact,
                    Fact_Acct_Group_ID, prePaymentAmt, p_linePosition, true);
                p_linePosition = totalamtForLineForPos.compareTo(BigDecimal.ZERO) == 0 ? p_linePosition + 1
                    : p_linePosition;
              }
            } catch (ServletException e) {
              log4jDocInvoice.warn(e);
            }
          }
        }
      if ((docInvoice.getM_payments() == null || docInvoice.getM_payments().length == 0)
          && (docInvoice.m_debt_payments == null || docInvoice.m_debt_payments.length == 0)) {

        p_linePosition = 0;
        BigDecimal debtPaymentAmount = new BigDecimal(docInvoice.Amounts[AcctServer.AMTTYPE_Gross]);
        p_linePosition = posForInvoiceLineNCProvedor(docInvoice, as, conn, fact,
            Fact_Acct_Group_ID, debtPaymentAmount, p_linePosition, true);
      }

      // Charge CR
      fact.createLine(null, docInvoice.getAccount(AcctServer.ACCTTYPE_Charge, as, conn),
          docInvoice.C_Currency_ID, "", docInvoice.getAmount(AcctServer.AMTTYPE_Charge),
          Fact_Acct_Group_ID, docInvoice.nextSeqNo(docInvoice.getSeqNo()), docInvoice.DocumentType,
          conn);
      // Liability DR For Line Invoice
      if (!invoice.isSalesTransaction()) {

        // posForInvoiceLineNCProvedor(docInvoice, as, conn, fact, Fact_Acct_Group_ID);
      }

      // If IsTaxExpense don't post taxes
      ClientInformation clientInfo = OBDal.getInstance().get(ClientInformation.class,
          docInvoice.AD_Client_ID);
      boolean isTaxExpense = false;
      try {
        OBContext.setAdminMode(true);

        isTaxExpense = clientInfo.isSipcIsTaxExpence();
      } finally {
        OBContext.restorePreviousMode();
      }

      // TaxCredit CR Only Withholdings
      DocTax[] taxExpenseWithholdings = loadWithholdingsTaxes(conn, docInvoice.Record_ID);
      for (int i = 0; taxExpenseWithholdings != null && i < taxExpenseWithholdings.length; i++) {
        // New docLine created to assign C_Tax_ID value to the entry
        DocLine docLine = new DocLine(docInvoice.DocumentType, docInvoice.Record_ID, "");
        docLine.m_C_Tax_ID = taxExpenseWithholdings[i].m_C_Tax_ID;
        if (taxExpenseWithholdings[i].m_isTaxUndeductable) {
          docInvoice.computeTaxUndeductableLine(conn, as, fact, docLine, Fact_Acct_Group_ID,
              taxExpenseWithholdings[i].m_C_Tax_ID, taxExpenseWithholdings[i].getAmount());

        } else {
          BigDecimal percentageFinalAccount = CashVATUtil._100;
          final BigDecimal taxesAmountTotal = new BigDecimal(
              StringUtils.isBlank(taxExpenseWithholdings[i].getAmount()) ? "0"
                  : taxExpenseWithholdings[i].getAmount());
          BigDecimal taxToTransAccount = BigDecimal.ZERO;
          if (docInvoice.isCashVAT) {
            percentageFinalAccount = CashVATUtil.calculatePrepaidPercentageForCashVATTax(
                taxExpenseWithholdings[i].m_C_Tax_ID, docInvoice.Record_ID);
            taxToTransAccount = CashVATUtil.calculatePercentageAmount(
                CashVATUtil._100.subtract(percentageFinalAccount), taxesAmountTotal,
                docInvoice.C_Currency_ID);
            fact.createLine(docLine,
                taxExpenseWithholdings[i].getAccount(DocTax.ACCTTYPE_TaxCredit_Trans, as, conn),
                docInvoice.C_Currency_ID, "", taxToTransAccount.toString(), Fact_Acct_Group_ID,
                docInvoice.nextSeqNo(docInvoice.getSeqNo()), docInvoice.DocumentType, conn);
          }
          final BigDecimal taxToFinalAccount = taxesAmountTotal.subtract(taxToTransAccount);
          fact.createLine(docLine,
              taxExpenseWithholdings[i].getAccount(DocTax.ACCTTYPE_TaxCredit, as, conn),
              docInvoice.C_Currency_ID, "", taxToFinalAccount.toString(), Fact_Acct_Group_ID,
              docInvoice.nextSeqNo(docInvoice.getSeqNo()), docInvoice.DocumentType, conn);
        }
      }
      // TaxLineCredit CR
      DocLineTax[] taxExpenseLines = loadLineTaxes(as, conn, docInvoice.Record_ID);
      for (int i = 0; taxExpenseLines != null && i < taxExpenseLines.length; i++) {
        // New docLine created to assign C_Tax_ID value to the entry
        DocLine docLine = new DocLine(docInvoice.DocumentType, docInvoice.Record_ID, "");
        docLine.m_C_Tax_ID = taxExpenseLines[i].m_C_Tax_ID;
        if (taxExpenseLines[i].m_isTaxUndeductable) {
          docInvoice.computeTaxUndeductableLine(conn, as, fact, docLine, Fact_Acct_Group_ID,
              taxExpenseLines[i].m_C_Tax_ID, taxExpenseLines[i].getAmount());

        } else {
          BigDecimal percentageFinalAccount = CashVATUtil._100;
          final BigDecimal taxesAmountTotal = new BigDecimal(StringUtils.isBlank(taxExpenseLines[i]
              .getAmount()) ? "0" : taxExpenseLines[i].getAmount());
          BigDecimal taxToTransAccount = BigDecimal.ZERO;
          if (docInvoice.isCashVAT && docInvoice.getM_taxes()[i].m_isCashVAT) {
            percentageFinalAccount = CashVATUtil.calculatePrepaidPercentageForCashVATTax(
                taxExpenseLines[i].m_C_Tax_ID, docInvoice.Record_ID);
            taxToTransAccount = CashVATUtil.calculatePercentageAmount(
                CashVATUtil._100.subtract(percentageFinalAccount), taxesAmountTotal,
                docInvoice.C_Currency_ID);
            if (isTaxExpense || invoice.isSIPCTaxExpenses() || taxExpenseLines[i].m_isTaxExpence) {
              fact.createLine(docLine, Account.getAccount(conn, taxExpenseLines[i].m_AssetAcct_ID),
                  docInvoice.C_Currency_ID, "", taxToTransAccount.toString(), Fact_Acct_Group_ID,
                  docInvoice.nextSeqNo(docInvoice.getSeqNo()), docInvoice.DocumentType, conn);
            } else {
              fact.createLine(docLine,
                  taxExpenseLines[i].getAccount(DocTax.ACCTTYPE_TaxCredit_Trans, as, conn),
                  docInvoice.C_Currency_ID, "", taxToTransAccount.toString(), Fact_Acct_Group_ID,
                  docInvoice.nextSeqNo(docInvoice.getSeqNo()), docInvoice.DocumentType, conn);
            }
          }
          final BigDecimal taxToFinalAccount = taxesAmountTotal.subtract(taxToTransAccount);
          if (isTaxExpense || invoice.isSIPCTaxExpenses() || taxExpenseLines[i].m_isTaxExpence) {
            fact.createLine(docLine, Account.getAccount(conn, taxExpenseLines[i].m_AssetAcct_ID),
                docInvoice.C_Currency_ID, "", taxToFinalAccount.toString(), Fact_Acct_Group_ID,
                docInvoice.nextSeqNo(docInvoice.getSeqNo()), docInvoice.DocumentType, conn);
          } else {
            fact.createLine(docLine,
                taxExpenseLines[i].getAccount(DocTax.ACCTTYPE_TaxCredit, as, conn),
                docInvoice.C_Currency_ID, "", taxToFinalAccount.toString(), Fact_Acct_Group_ID,
                docInvoice.nextSeqNo(docInvoice.getSeqNo()), docInvoice.DocumentType, conn);
          }
        }
      }
      // Expense CR
      for (int i = 0; docInvoice.p_lines != null && i < docInvoice.p_lines.length; i++) {
        String amount = docInvoice.p_lines[i].getAmount();
        String amountConverted = "";
        ConversionRateDoc conversionRateCurrentDoc = docInvoice.getConversionRateDoc(
            AcctServer.TABLEID_Invoice, docInvoice.Record_ID, docInvoice.C_Currency_ID,
            as.m_C_Currency_ID);
        if (conversionRateCurrentDoc != null) {
          amountConverted = AcctServer
              .applyRate(new BigDecimal(docInvoice.p_lines[i].getAmount()),
                  conversionRateCurrentDoc, true).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        } else {
          amountConverted = AcctServer.getConvertedAmt(docInvoice.p_lines[i].getAmount(),
              docInvoice.C_Currency_ID, as.m_C_Currency_ID, docInvoice.DateAcct, "",
              docInvoice.AD_Client_ID, docInvoice.AD_Org_ID, conn);
        }
        Account account = ((DocLine_Invoice) docInvoice.p_lines[i]).getAccount(
            ProductInfo.ACCTTYPE_P_Expense, as, conn);
        if (((DocLine_Invoice) docInvoice.p_lines[i]).isDeferred()) {
          amount = docInvoice.createAccDefExpenseFact(fact,
              (DocLine_Invoice) docInvoice.p_lines[i], account,
              ((DocLine_Invoice) docInvoice.p_lines[i]).getAccount(
                  ProductInfo.ACCTTYPE_P_DefExpense, as, conn), amountConverted,
              as.m_C_Currency_ID, conn);
          fact.createLine(docInvoice.p_lines[i], account, as.m_C_Currency_ID, "", amount,
              Fact_Acct_Group_ID, docInvoice.nextSeqNo(docInvoice.getSeqNo()),
              docInvoice.DocumentType, conn);
        } else {
          fact.createLine(docInvoice.p_lines[i], account, docInvoice.C_Currency_ID, "", amount,
              Fact_Acct_Group_ID, docInvoice.nextSeqNo(docInvoice.getSeqNo()),
              docInvoice.DocumentType, conn);
        }
        // If expense has been deferred
        if (((DocLine_Invoice) docInvoice.p_lines[i]).isDeferred()
            && !amount.equals(amountConverted)) {
          amount = new BigDecimal(amountConverted).subtract(new BigDecimal(amount)).toString();
          fact.createLine(docInvoice.p_lines[i], ((DocLine_Invoice) docInvoice.p_lines[i])
              .getAccount(ProductInfo.ACCTTYPE_P_DefExpense, as, conn), as.m_C_Currency_ID, "",
              amount, Fact_Acct_Group_ID, docInvoice.nextSeqNo(docInvoice.getSeqNo()),
              docInvoice.DocumentType, conn);
        }

      }
      // Set Locations
      FactLine[] fLines = fact.getLines();
      for (int i = 0; fLines != null && i < fLines.length; i++) {
        if (fLines[i] != null) {
          fLines[i].setLocationFromBPartner(docInvoice.C_BPartner_Location_ID, true, conn); // from
                                                                                            // Loc
          fLines[i].setLocationFromOrg(fLines[i].getAD_Org_ID(conn), false, conn); // to Loc
        }
      }
    } else {
      log4jDocInvoice.warn("Doc_Invoice - DocumentType unknown: " + docInvoice.DocumentType);
      fact = null;
    }
    docInvoice.setSeqNo("0");
    return fact;
  }

  private int posForInvoiceLineNCProvedor(DocInvoice docInvoice, AcctSchema as,
      ConnectionProvider conn, Fact fact, String Fact_Acct_Group_ID, BigDecimal debtPaymentAmount,
      int plinesPosition, boolean isPrepayment) throws ServletException {
    ConversionRateDoc conversionRateCurrentDoc = null;
    BigDecimal cuurentDebtPaymentAmount = debtPaymentAmount.negate();
    int i;
    for (i = plinesPosition; docInvoice.p_lines != null && i < docInvoice.p_lines.length; i++) {
      String amountConverted = "";

      BigDecimal ilTaxamt = new BigDecimal(DocLineInvoiceData.selectTaxTotalForInvoiceLine(conn,
          docInvoice.p_lines[i].m_TrxLine_ID)[0].ilTaxamt);

      InvoiceLine invoiceLine = OBDal.getInstance().get(InvoiceLine.class,
          docInvoice.p_lines[i].m_TrxLine_ID);

      BigDecimal totalamtForLine = ilTaxamt.add(new BigDecimal(docInvoice.p_lines[i].getAmount()));

      if (invoiceLine.getSswhInvoicetaxIncome() != null) {
        totalamtForLine = totalamtForLine.add(invoiceLine.getSswhInvoicetaxIncome().getTaxAmount());
      }

      if (invoiceLine.getSswhInvoicetaxVat() != null) {
        totalamtForLine = totalamtForLine.add(invoiceLine.getSswhInvoicetaxVat().getTaxAmount());
      }

      conversionRateCurrentDoc = docInvoice.getConversionRateDoc(AcctServer.TABLEID_Invoice,
          docInvoice.Record_ID, docInvoice.C_Currency_ID, as.m_C_Currency_ID);
      if (conversionRateCurrentDoc != null) {
        totalamtForLine = AcctServer.applyRate(totalamtForLine, conversionRateCurrentDoc, true)
            .setScale(2, BigDecimal.ROUND_HALF_UP);
      } else {
        totalamtForLine = new BigDecimal(AcctServer.getConvertedAmt(totalamtForLine.toString(),
            docInvoice.C_Currency_ID, as.m_C_Currency_ID, docInvoice.DateAcct, "",
            docInvoice.AD_Client_ID, docInvoice.AD_Org_ID, conn));
      }

      if (totalamtForLineForPos.compareTo(BigDecimal.ZERO) > 0) {
        totalamtForLine = totalamtForLine.subtract(totalamtForLineForPos);
        totalamtForLineForPos = BigDecimal.ZERO;
      }

      Account account = null;
      if (!isPrepayment) {
        account = getAccountNCProveedor(docInvoice, as, conn, i);
      } else {
        account = getAccountBPartner(docInvoice.C_BPartner_ID, as, isPrepayment,
            docInvoice.p_lines[i].m_TrxLine_ID, conn, docInvoice);
      }

      fact.createLine(
          docInvoice.p_lines[i],
          account,
          docInvoice.C_Currency_ID,
          (cuurentDebtPaymentAmount.compareTo(totalamtForLine) < 0) ? cuurentDebtPaymentAmount
              .toString() : totalamtForLine.toString(), "", Fact_Acct_Group_ID, docInvoice
              .nextSeqNo(docInvoice.getSeqNo()), docInvoice.DocumentType, conn);

      if ((cuurentDebtPaymentAmount.subtract(totalamtForLine)).compareTo(BigDecimal.ZERO) > 0) {
        cuurentDebtPaymentAmount = cuurentDebtPaymentAmount.subtract(totalamtForLine);
      } else {
        totalamtForLineForPos = totalamtForLine.subtract(cuurentDebtPaymentAmount);
        return i;
      }
    }

    totalamtForLineForPos = BigDecimal.ZERO;
    return i;
  }

  private Account getAccountNCProveedor(DocInvoice docInvoice, AcctSchema as,
      ConnectionProvider conn, int i) throws ServletException {
    String Account_ID = DocLineInvoiceData.selectAccountNCProveedor(conn, as.getC_AcctSchema_ID(),
        docInvoice.C_BPartner_ID, docInvoice.p_lines[i].m_TrxLine_ID)[0].accountNcprovedor;
    return Account.getAccount(conn, Account_ID);
  }

  private int posForInvoiceLine(DocInvoice docInvoice, AcctSchema as, ConnectionProvider conn,
      Fact fact, String Fact_Acct_Group_ID, BigDecimal debtPaymentAmount, int plinesPosition,
      boolean isPrepayment) throws ServletException {
    ConversionRateDoc conversionRateCurrentDoc;
    BigDecimal cuurentDebtPaymentAmount = debtPaymentAmount;
    int i;
    for (i = plinesPosition; docInvoice.p_lines != null && i < docInvoice.p_lines.length; i++) {
      String amountConverted = "";
      conversionRateCurrentDoc = docInvoice.getConversionRateDoc(AcctServer.TABLEID_Invoice,
          docInvoice.Record_ID, docInvoice.C_Currency_ID, as.m_C_Currency_ID);
      if (conversionRateCurrentDoc != null) {
        amountConverted = AcctServer
            .applyRate(new BigDecimal(docInvoice.p_lines[i].getAmount()), conversionRateCurrentDoc,
                true).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
      } else {
        amountConverted = AcctServer.getConvertedAmt(docInvoice.p_lines[i].getAmount(),
            docInvoice.C_Currency_ID, as.m_C_Currency_ID, docInvoice.DateAcct, "",
            docInvoice.AD_Client_ID, docInvoice.AD_Org_ID, conn);
      }

      BigDecimal ilTaxamt = new BigDecimal(DocLineInvoiceData.selectTaxTotalForInvoiceLine(conn,
          docInvoice.p_lines[i].m_TrxLine_ID)[0].ilTaxamt);

      InvoiceLine invoiceLine = OBDal.getInstance().get(InvoiceLine.class,
          docInvoice.p_lines[i].m_TrxLine_ID);

      BigDecimal totalamtForLine = ilTaxamt.add(new BigDecimal(amountConverted));
      if (invoiceLine.getSswhInvoicetaxIncome() != null) {
        totalamtForLine = totalamtForLine.add(invoiceLine.getSswhInvoicetaxIncome().getTaxAmount());
      }
      if (invoiceLine.getSswhInvoicetaxVat() != null) {
        totalamtForLine = totalamtForLine.add(invoiceLine.getSswhInvoicetaxVat().getTaxAmount());
      }

      if (totalamtForLineForPos.compareTo(BigDecimal.ZERO) > 0) {
        totalamtForLine = totalamtForLine.subtract(totalamtForLineForPos);
        totalamtForLineForPos = BigDecimal.ZERO;
      }

      Account account = null;
      if (!isPrepayment) {
        account = getAccountViability(docInvoice, as, conn, i);
      } else {
        account = getAccountBPartner(docInvoice.C_BPartner_ID, as, isPrepayment,
            docInvoice.p_lines[i].m_TrxLine_ID, conn, docInvoice);
      }

      fact.createLine(
          docInvoice.p_lines[i],
          account,
          docInvoice.C_Currency_ID,
          "",
          (cuurentDebtPaymentAmount.compareTo(totalamtForLine) < 0) ? cuurentDebtPaymentAmount
              .toString() : totalamtForLine.toString(), Fact_Acct_Group_ID, docInvoice
              .nextSeqNo(docInvoice.getSeqNo()), docInvoice.DocumentType, conn);

      if ((cuurentDebtPaymentAmount.subtract(totalamtForLine)).compareTo(BigDecimal.ZERO) > 0) {
        cuurentDebtPaymentAmount = cuurentDebtPaymentAmount.subtract(totalamtForLine);
      } else {
        totalamtForLineForPos = totalamtForLine.subtract(cuurentDebtPaymentAmount);
        return i;
      }

    }
    totalamtForLineForPos = BigDecimal.ZERO;
    return i;
  }

  private Account getAccountViability(DocInvoice docInvoice, AcctSchema as,
      ConnectionProvider conn, int i) throws ServletException {
    String Account_ID = DocLineInvoiceData.selectAccountBParnet(conn, as.getC_AcctSchema_ID(),
        docInvoice.C_BPartner_ID, docInvoice.p_lines[i].m_TrxLine_ID)[0].accountId;

    return Account.getAccount(conn, Account_ID);
  }

  private DocTax[] loadWithholdingsTaxes(ConnectionProvider conn, String Record_ID) {
    ArrayList<Object> list = new ArrayList<Object>();
    DocInvoiceData[] data = null;
    try {
      data = DocInvoiceData.selectWithholdings(conn, Record_ID);
    } catch (ServletException e) {
      log4jDocInvoice.warn(e);
    }
    log4jDocInvoice.debug("############### Taxes.length = " + data.length);
    for (int i = 0; i < data.length; i++) {
      String C_Tax_ID = data[i].cTaxId;
      String name = data[i].name;
      String rate = data[i].rate;

      String taxBaseAmt = data[i].taxbaseamt;
      String amount = data[i].taxamt;
      boolean isTaxDeductable = false;
      boolean isTaxUndeductable = ("Y".equals(data[i].ratetaxundeductable))
          || ("Y".equals(data[i].orgtaxundeductable));
      if ("Y".equals(data[i].orgtaxundeductable)) {
        /*
         * If any tax line level has tax deductable flag then override isTaxUndeductable flag for
         * intracommunity non tax deductible organization
         */
        if ("Y".equals(data[i].istaxdeductable)) {
          isTaxUndeductable = false;
          isTaxDeductable = true;
        }
      } else {
        // configured for intracommunity with tax liability
        if ("Y".equals(data[i].istaxdeductable)) {
          isTaxDeductable = true;
        }
      }
      DocTax taxLine = new DocTax(C_Tax_ID, name, rate, taxBaseAmt, amount, isTaxUndeductable,
          isTaxDeductable);
      list.add(taxLine);
    }
    // Return Array
    DocTax[] tl = new DocTax[list.size()];
    list.toArray(tl);
    return tl;
  } // loadTaxes

  // Load Line Taxes
  private DocLineTax[] loadLineTaxes(AcctSchema as, ConnectionProvider conn, String Record_ID) {
    ArrayList<Object> list = new ArrayList<Object>();
    DocInvoiceData[] data = null;
    try {
      data = DocInvoiceData.selectLine(conn, as.m_C_AcctSchema_ID, Record_ID);
    } catch (ServletException e) {
      log4jDocInvoice.warn(e);
    }
    log4jDocInvoice.debug("############### Taxes.length = " + data.length);
    for (int i = 0; i < data.length; i++) {
      String C_Tax_ID = data[i].cTaxId;
      String assetAcct = data[i].assetacct;
      boolean isTaxExpence = "Y".equals(data[i].istaxexpence);
      String name = data[i].name;
      String rate = data[i].rate;

      String taxBaseAmt = data[i].taxbaseamt;
      String amount = data[i].taxamt;
      boolean isTaxDeductable = false;
      boolean isTaxUndeductable = ("Y".equals(data[i].ratetaxundeductable))
          || ("Y".equals(data[i].orgtaxundeductable));
      if ("Y".equals(data[i].orgtaxundeductable)) {
        /*
         * If any tax line level has tax deductable flag then override isTaxUndeductable flag for
         * intracommunity non tax deductible organization
         */
        if ("Y".equals(data[i].istaxdeductable)) {
          isTaxUndeductable = false;
          isTaxDeductable = true;
        }
      } else {
        // configured for intracommunity with tax liability
        if ("Y".equals(data[i].istaxdeductable)) {
          isTaxDeductable = true;
        }
      }

      DocLineTax taxLine = new DocLineTax(C_Tax_ID, name, rate, taxBaseAmt, amount,
          isTaxUndeductable, isTaxDeductable, assetAcct, isTaxExpence);
      list.add(taxLine);
    }
    // Return Array
    DocLineTax[] tl = new DocLineTax[list.size()];
    list.toArray(tl);
    return tl;
  } // loadLineTaxes

  public final Account getAccountBPartner(String cBPartnerId, AcctSchema as, boolean isPrepayment,
      String invoiceLineId, ConnectionProvider conn, DocInvoice docInvoice) throws ServletException {

    String strValidCombination = "";

    InvoiceLine invoiceLine = OBDal.getInstance().get(InvoiceLine.class, invoiceLineId);

    StringBuilder hql = new StringBuilder();
    hql.append(" from VendorAccounts as va ");
    hql.append(" where va.businessPartner.id = :businessPartnerId and va.accountingSchema.id = :accountingSchemaId ");

    if (invoiceLine.getSfbBudgetCertLine() != null) {
      hql.append(" and va.spaaBudgetItem.id in ( select bc.budgetItem.id from InvoiceLine as il inner join il.sfbBudgetCertLine  bc ");
      hql.append(" where  il.id = :invoiceLineId ) ");
    } else {
      hql.append(" and va.vaspaaDefault = 'Y' ");
    }

    final Session session = OBDal.getInstance().getSession();
    final Query query = session.createQuery(hql.toString());

    query.setParameter("businessPartnerId", cBPartnerId);
    query.setParameter("accountingSchemaId", as.m_C_AcctSchema_ID);

    if (invoiceLine.getSfbBudgetCertLine() != null) {
      query.setParameter("invoiceLineId", invoiceLineId);
    }

    query.setMaxResults(1);
    VendorAccounts vendorAccounts = (VendorAccounts) query.uniqueResult();

    if (vendorAccounts != null && !isPrepayment) {
      strValidCombination = vendorAccounts.getVendorLiability().getId();
    }

    if (vendorAccounts != null && isPrepayment) {
      strValidCombination = vendorAccounts.getVendorPrepayment().getId();
    }

    if (strValidCombination.equals("")) {
      Map<String, String> parameters = new HashMap<String, String>();
      parameters.put("Account", (isPrepayment ? "@VendorPrepayment@" : "@VendorLiability@"));
      BusinessPartner bp = OBDal.getInstance().get(BusinessPartner.class, cBPartnerId);
      if (bp != null) {
        parameters.put("Entity", bp.getIdentifier());
      }
      parameters.put(
          "AccountingSchema",
          OBDal
              .getInstance()
              .get(org.openbravo.model.financialmgmt.accounting.coa.AcctSchema.class,
                  as.getC_AcctSchema_ID()).getIdentifier());
      docInvoice.setMessageResult(conn, AcctServer.STATUS_InvalidAccount, "error", parameters);
      throw new IllegalStateException();
    }

    return new Account(conn, strValidCombination);
  }

}
