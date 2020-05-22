package ec.com.sidesoft.secondary.accounting;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.ad_forms.Account;
import org.openbravo.erpCommon.ad_forms.AcctSchema;
import org.openbravo.erpCommon.ad_forms.AcctServer;
import org.openbravo.erpCommon.ad_forms.DocLine;
import org.openbravo.erpCommon.ad_forms.Fact;
import org.openbravo.erpCommon.ad_forms.FactLine;
import org.openbravo.erpCommon.utility.Utility;

public class FactSecondary extends Fact {

  static Logger log4jFact = Logger.getLogger(FactSecondary.class);

  private AcctServer m_doc = null;

  /** Lines */
  private ArrayList<Object> m_lines = new ArrayList<Object>();

  /** Posting Type */
  private String m_postingType = null;

  public AcctServer getM_doc() {
    return m_doc;
  }

  public FactSecondary(AcctServer document, AcctSchema acctSchema, String defaultPostingType) {
    super(document, acctSchema, defaultPostingType);
    m_doc = document;
    m_postingType = defaultPostingType;
  }

  /**
   * Create and convert Fact Line. Used to create a DR and/or CR entry
   * 
   * @param docLine
   *          the document line or null
   * @param account
   *          if null, line is not created
   * @param C_Currency_ID
   *          the currency
   * @param debitAmt
   *          debit amount, can be null
   * @param creditAmt
   *          credit amount, can be null
   * @return Fact Line
   */
  public FactLine createLine(DocLine docLine, Account account, String C_Currency_ID,
      String debitAmt, String creditAmt, String Fact_Acct_Group_ID, String SeqNo,
      String DocBaseType, ConnectionProvider conn) {
    return createLine(docLine, account, C_Currency_ID, debitAmt, creditAmt, Fact_Acct_Group_ID,
        SeqNo, DocBaseType, m_doc.DateAcct, null, conn);
  }

  /**
   * Create and convert Fact Line using a specified conversion date. Used to create a DR and/or CR
   * entry
   * 
   * @param docLine
   *          the document line or null
   * @param account
   *          if null, line is not created
   * @param C_Currency_ID
   *          the currency
   * @param debitAmt
   *          debit amount, can be null
   * @param creditAmt
   *          credit amount, can be null
   * @param conversionDate
   *          Date to convert currencies if required
   * @param conversionRate
   *          The rate to use to convert from source amount to account amount. May be null
   * @return Fact Line
   */
  public FactLine createLine(DocLine docLine, Account account, String C_Currency_ID,
      String debitAmt, String creditAmt, String Fact_Acct_Group_ID, String SeqNo,
      String DocBaseType, String conversionDate, BigDecimal conversionRate, ConnectionProvider conn) {

    String localConversionDate = conversionDate;
    String localCreditAmt = creditAmt;
    String localDebitAmt = debitAmt;
    String strNegate = "";
    try {
      strNegate = FactLineData.selectNegate(conn, getM_acctSchema().m_C_AcctSchema_ID, DocBaseType);
      if (strNegate.equals(""))
        strNegate = FactLineData.selectDefaultNegate(conn, getM_acctSchema().m_C_AcctSchema_ID);
    } catch (ServletException e) {
    }
    if (strNegate.equals(""))
      strNegate = "Y";
    BigDecimal DebitAmt = new BigDecimal(localDebitAmt.equals("") ? "0.00" : localDebitAmt);
    BigDecimal CreditAmt = new BigDecimal(localCreditAmt.equals("") ? "0.00" : localCreditAmt);
    if (DebitAmt.compareTo(BigDecimal.ZERO) == 0 && CreditAmt.compareTo(BigDecimal.ZERO) == 0) {
      return null;
    }
    if (strNegate.equals("N") && (DebitAmt.compareTo(ZERO) < 0 || CreditAmt.compareTo(ZERO) < 0)) {
      BigDecimal convertedDebitAmt = BigDecimal.ZERO;
      BigDecimal convertedCreditAmt = BigDecimal.ZERO;
      if ("GLJ".equals(DocBaseType) && docLine != null) {
        convertedDebitAmt = StringUtils.isBlank(docLine.m_AmtAcctDr) ? ZERO : new BigDecimal(
            docLine.m_AmtAcctDr);
        convertedCreditAmt = StringUtils.isBlank(docLine.m_AmtAcctCr) ? ZERO : new BigDecimal(
            docLine.m_AmtAcctCr);
      }

      if (DebitAmt.compareTo(ZERO) < 0) {
        CreditAmt = CreditAmt.add(DebitAmt.abs());
        localCreditAmt = CreditAmt.toString();
        DebitAmt = BigDecimal.ZERO;
        localDebitAmt = DebitAmt.toString();
        if ("GLJ".equals(DocBaseType)) {
          convertedCreditAmt = convertedCreditAmt.add(convertedDebitAmt.abs());
          convertedDebitAmt = BigDecimal.ZERO;
        }

      }
      if (CreditAmt.compareTo(ZERO) < 0) {
        DebitAmt = DebitAmt.add(CreditAmt.abs());
        localDebitAmt = DebitAmt.toString();
        CreditAmt = BigDecimal.ZERO;
        localCreditAmt = CreditAmt.toString();
        if ("GLJ".equals(DocBaseType)) {
          convertedDebitAmt = convertedDebitAmt.add(convertedCreditAmt.abs());
          convertedCreditAmt = BigDecimal.ZERO;
        }
      }

      // If this is a manual entry then we need to recompute Amounts which were set in loadLines for
      // GL Journal Document
      if ("GLJ".equals(DocBaseType)) {
        docLine.setConvertedAmt(docLine.m_C_AcctSchema_ID, convertedDebitAmt.toString(),
            convertedCreditAmt.toString());
      }

      if (strNegate.equals("N") && (DebitAmt.compareTo(ZERO) < 0 || CreditAmt.compareTo(ZERO) < 0)) {
        return createLine(docLine, account, C_Currency_ID, CreditAmt.abs().toString(), DebitAmt
            .abs().toString(), Fact_Acct_Group_ID, SeqNo, DocBaseType, conn);
      }
    }

    log4jFact
        .debug("createLine - " + account + " - Dr=" + localDebitAmt + ", Cr=" + localCreditAmt);
    log4jFact.debug("Starting createline");
    // Data Check
    if (account == null) {
      log4jFact.debug("end of create line");
      m_doc.setStatus(AcctServer.STATUS_InvalidAccount);
      return null;
    }
    //
    log4jFact.debug("createLine - Fact_Acct_Group_ID = " + Fact_Acct_Group_ID);
    FactLineSecondary line = new FactLineSecondary(m_doc.AD_Table_ID, m_doc.Record_ID,
        docLine == null ? "" : docLine.m_TrxLine_ID, Fact_Acct_Group_ID, SeqNo, DocBaseType);
    log4jFact.debug("createLine - line.m_Fact_Acct_Group_ID = " + line.m_Fact_Acct_Group_ID);
    log4jFact.debug("Object created");
    line.setDocumentInfo(m_doc, docLine);
    line.setAD_Org_ID(m_doc.AD_Org_ID);
    // if (docLine!=null) line.setAD_Org_ID(docLine.m_AD_Org_ID);
    log4jFact.debug("document info set");
    line.setAccount(getM_acctSchema(), account);
    log4jFact.debug("account set");

    log4jFact.debug("C_Currency_ID: " + C_Currency_ID + " - debitAmt: " + localDebitAmt
        + " - creditAmt: " + localCreditAmt);
    // Amounts - one needs to be both not zero
    if (!line.setAmtSource(C_Currency_ID, localDebitAmt, localCreditAmt))
      return null;
    if (localConversionDate == null || localConversionDate.isEmpty()) {
      localConversionDate = m_doc.DateAcct;
    }
    log4jFact.debug("C_Currency_ID: " + getM_acctSchema().getC_Currency_ID()
        + " - ConversionDate: " + localConversionDate + " - CurrencyRateType: "
        + getM_acctSchema().getCurrencyRateType());
    // Convert
    boolean converted;
    if (conversionRate != null) {
      converted = line.convertByRate(getM_acctSchema().getC_Currency_ID(), conversionRate);
    } else {
      converted = line.convert(getM_acctSchema().getC_Currency_ID(), localConversionDate,
          getM_acctSchema().getCurrencyRateType(), conn);
    }
    if (!converted) {
      m_doc.setStatus(AcctServer.STATUS_NotConvertible);
      return null;
    }
    // Optionally overwrite Acct Amount
    if (docLine != null && !docLine.m_AmtAcctDr.equals("") && !docLine.m_AmtAcctCr.equals(""))
      line.setAmtAcct(docLine.m_AmtAcctDr, docLine.m_AmtAcctCr);
    // Info
    line.setJournalInfo(m_doc.GL_Category_ID);
    line.setPostingType(m_postingType);
    // Set Info
    line.setDocumentInfo(m_doc, docLine);
    //
    log4jFact.debug("createLine - " + m_doc.DocumentNo);
    log4jFact.debug("********************* Fact - createLine - DocumentNo - " + m_doc.DocumentNo
        + " -  m_lines.size() - " + m_lines.size());

    line.roundToCurrencyPrecision();
    String Record_ID2 = null;
    if (docLine != null) {
      Record_ID2 = docLine.m_Record_Id2;
    }
    if (StringUtils.isEmpty(Record_ID2)) {
      Record_ID2 = m_doc.m_Record_Id2;
    }
    line.setM_RecordID2(Record_ID2);
    log4jFact.debug("Fact - createLine - Record_ID2 = " + Record_ID2);

    m_lines.add(line);
    return line;
  } // createLine

  /**
   * Get Lines
   * 
   * @return FactLine Array
   */
  public FactLine[] getLines() {
    FactLine[] temp = new FactLine[m_lines.size()];
    m_lines.toArray(temp);
    return temp;
  } // getLines

  /**
   * Save Fact
   * 
   * @param con
   *          connection
   * @return true if all lines were saved
   */
  public boolean save(Connection con, ConnectionProvider conn, VariablesSecureApp vars)
      throws ServletException {
    // save Lines
    log4jFact.debug(" Fact - save() - m_lines.size - " + m_lines.size());
    if (m_lines.size() == 0)
      return true;

    // String accountNotMatch = getAccountNotMatch(con, conn, vars);
    // if (StringUtils.isNotBlank(accountNotMatch)) {
    // FactLineData[] cuenta = FactLineData.selectAccountValue(conn, accountNotMatch);
    // m_doc.setStatus("E");
    // OBError err = new OBError();
    // err.setType("Error");
    // err.setMessage(" No existen cuenta homologa para  la cuenta " + cuenta[0].value);
    // m_doc.setMessageResult(err);
    // return false;
    // }

    Set<String> recordID2Set = new HashSet<String>();
    for (int i = 0; i < m_lines.size(); i++) {
      FactLine fl = (FactLine) m_lines.get(i);
      if (!fl.save(con, conn, vars)) { // abort on first error
        log4jFact.warn("Save (fact): aborted. i=" + i);
        return false;
      }
      if (StringUtils.isNotEmpty(fl.getM_RecordID2())) {
        recordID2Set.add(fl.getM_RecordID2());
      }
    }
    if (!recordID2Set.isEmpty()) {
      for (Set<String> recordID2 : splitRecordID2Set(recordID2Set, 1000)) {
        // Update Balancing Date [Open Balances project]
        FactLineData.updateDateBalanced(con, conn, Utility.getInStrSet(recordID2));
      }
    }
    return true;
  } // commit

  /**
   * Dispose
   */
  public void dispose() {
    for (int i = 0; i < m_lines.size(); i++)
      ((FactLine) m_lines.get(i)).dispose();
    m_lines.clear();
    m_lines = null;
  } // dispose

}
