package org.openbravo.erpCommon.ad_forms;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.SequenceIdData;

public class DocViaticalSettlement extends AcctServer {
  private static final long serialVersionUID = 1L;
  private String SeqNo = "0";

  static Logger log4jDocViaticalSettlement = Logger.getLogger(DocViaticalSettlement.class);

  /** Withholding Sale */
  public static final String DOCTYPE_DocViaticalSettlement = "SSVE_VS";

  /**
   * Constructor
   * 
   * @param AD_Client_ID
   *          AD_Client_ID
   */
  public DocViaticalSettlement(String AD_Client_ID, String AD_Org_ID,
      ConnectionProvider connectionProvider) {
    super(AD_Client_ID, AD_Org_ID, connectionProvider);
  }

  public String nextSeqNo(String oldSeqNo) {
    log4jDocViaticalSettlement.debug("DocViaticalSettlement - oldSeqNo = " + oldSeqNo);
    BigDecimal seqNo = new BigDecimal(oldSeqNo);
    SeqNo = (seqNo.add(new BigDecimal("10"))).toString();
    log4jDocViaticalSettlement.debug("DocViaticalSettlement - nextSeqNo = " + SeqNo);
    return SeqNo;
  }

  public void loadObjectFieldProvider(ConnectionProvider conn, String stradClientId, String Id)
      throws ServletException {
    setObjectFieldProvider(DocViaticalSettlementData.selectRecord(conn, Id, stradClientId));
  }

  /**
   * Load Specific Document Details
   * 
   * @return true if loadDocumentType was set
   */
  public boolean loadDocumentDetails(FieldProvider[] data, ConnectionProvider conn) {
    DocumentType = DOCTYPE_DocViaticalSettlement;
    log4jDocViaticalSettlement.debug("data.length = " + data.length + " - DocumentType = "
        + DocumentType);

    // Amounts
    Amounts[AcctServer.AMTTYPE_Gross] = data[0].getField("Total_Amt");
    if (Amounts[AcctServer.AMTTYPE_Gross] == null)
      Amounts[AcctServer.AMTTYPE_Gross] = ZERO.toString();

    loadDocumentType(); // lines require doc type

    // Contained Objects
    p_lines = loadLines(conn);
    log4jDocViaticalSettlement.debug("Lines=" + p_lines.length);
    return true;
  } // loadDocumentDetails

  /**
   * Load Withholding Sale Line
   * 
   * @return DocLine Array
   */
  private DocLine[] loadLines(ConnectionProvider conn) {
    ArrayList<Object> list = new ArrayList<Object>();
    // DocLineWithholdingSaleData[] data = null;
    DocViaticalSettlementData[] headerData = null;
    Account account = null;
    String isDebit = "";
    try {

      // Get header data
      headerData = DocViaticalSettlementData.selectRecord(conn, Record_ID, AD_Client_ID);
      if (headerData.length > 0) {
        //
        account = new Account(conn, headerData[0].cExpenseaccountId);
        isDebit = "Y";
        DocLine_ViaticalSettlement docLine = new DocLine_ViaticalSettlement(DocumentType,
            Record_ID, null);
        docLine.loadAttributes(headerData[0], this);
        docLine.setAccount(account);
        docLine.m_C_Costcenter_ID = headerData[0].cCostcenterId;
        docLine.m_User1_ID = headerData[0].user1Id;
        docLine.m_Is_Debit = isDebit;
        docLine.setAmount(headerData[0].totalAmt);
        list.add(docLine);

        account = new Account(conn, headerData[0].cPayableaccountId);
        isDebit = "N";
        docLine = new DocLine_ViaticalSettlement(DocumentType, Record_ID, null);
        docLine.loadAttributes(headerData[0], this);
        docLine.setAccount(account);
        docLine.m_Is_Debit = isDebit;
        docLine.setAmount(headerData[0].totalAmt);
        list.add(docLine);
      }
    } catch (ServletException e) {
      log4jDocViaticalSettlement.warn(e);
    }
    // Return Array
    DocLine[] dl = new DocLine[list.size()];
    list.toArray(dl);
    return dl;
  } // loadLines

  public Fact createFact(AcctSchema as, ConnectionProvider conn, Connection con,
      VariablesSecureApp vars) throws ServletException {

    log4jDocViaticalSettlement.debug("Starting create fact");

    // create Fact Header
    Fact fact = new Fact(this, as, Fact.POST_Actual);

    String Fact_Acct_Group_ID = SequenceIdData.getUUID();

    // SSWSConceptInfoData[] data = null;
    // Lines
    for (int i = 0; p_lines != null && i < p_lines.length; i++) {
      DocLine_ViaticalSettlement line = (DocLine_ViaticalSettlement) p_lines[i];

      String debitAmount = "";
      String creditAmount = "";

      debitAmount = (line.m_Is_Debit == "Y") ? line.getAmount() : "";
      creditAmount = (line.m_Is_Debit == "N") ? line.getAmount() : "";
      fact.createLine(line, ((DocLine_ViaticalSettlement) p_lines[i]).getAccount(), C_Currency_ID,
          debitAmount, creditAmount, Fact_Acct_Group_ID, nextSeqNo(SeqNo), DocumentType, conn);

      // try { data = SSWSConceptInfoData.selectConceptAcctDetails(conn, as.getC_AcctSchema_ID(),
      // line.m_SSWS_Category_Acct_ID);
      //
      // if (data[0].isaccountpayroll.equals("Y")) { Account account = ((DocLine_WithholdingSale)
      // p_lines[i]).getAccount( ConceptInfo.ACCTTYPE_C_Debit, as, line.m_SSWS_Category_Acct_ID,
      // conn);
      //
      // fact.createLine(line, account, C_Currency_ID, line.getAmount(), "", Fact_Acct_Group_ID,
      // nextSeqNo(SeqNo), DocumentType, conn);
      //
      // account = ((DocLine_WithholdingSale) p_lines[i]).getAccount( ConceptInfo.ACCTTYPE_C_Credit,
      // as, line.m_SSWS_Category_Acct_ID, conn); fact.createLine(line, account, C_Currency_ID, "",
      // line.getAmount(), Fact_Acct_Group_ID, nextSeqNo(SeqNo), DocumentType, conn); } else { if
      // (data[0].isliability.equals("Y")) { Account account = ((DocLine_WithholdingSale)
      // p_lines[i]).getAccount( ConceptInfo.ACCTTYPE_C_Debit, as, line.m_SSWS_Category_Acct_ID,
      // conn);
      //
      // fact.createLine(line, account, C_Currency_ID, "", line.getAmount(), Fact_Acct_Group_ID,
      // nextSeqNo(SeqNo), DocumentType, conn); } else { Account account =
      // ((DocLine_WithholdingSale) p_lines[i]).getAccount( ConceptInfo.ACCTTYPE_C_Debit, as,
      // line.m_SSWS_Category_Acct_ID, conn);
      //
      // fact.createLine(line, account, C_Currency_ID, line.getAmount(), "", Fact_Acct_Group_ID,
      // nextSeqNo(SeqNo), DocumentType, conn); } } } catch (ServletException e) {
      // log4jDocWithholdingSale.warn(e); }

    }

    // FactLine closing = fact.balanceSource(conn);
    // closing.setAccount(as, ConceptInfo.getAccountDefault(ConceptInfo.ACCTTYPE_C_Closing, as,
    // conn));

    SeqNo = "0";
    return fact;

  }// createFact

  /**
   * Get Source Currency Balance - subtracts line amounts from total - no rounding
   * 
   * @return positive amount, if total invoice is bigger than lines
   */
  public BigDecimal getBalance() {
    return ZERO; // Lines are balanced
  } // getBalance

  /**
   * Get Document Confirmation
   * 
   * not used
   */
  public boolean getDocumentConfirmation(ConnectionProvider conn, String strRecordId) {
    return true;
  }

  public String getServletInfo() {
    return "Servlet for the accounting";
  } // end of getServletInfo() method
}
