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

public class DocBudgetCertificate extends AcctServer {
  private static final long serialVersionUID = 1L;
  private String SeqNo = "0";

  static Logger log4jDocBudgetCertificate = Logger.getLogger(DocBudgetCertificate.class);

  /** Budget Certificate */
  public static final String DOCTYPE_BudgetCertificate = "SFB_BC";

  /**
   * Constructor
   * 
   * @param AD_Client_ID
   *          AD_Client_ID
   */
  public DocBudgetCertificate(String AD_Client_ID, String AD_Org_ID,
      ConnectionProvider connectionProvider) {
    super(AD_Client_ID, AD_Org_ID, connectionProvider);
  }

  public String nextSeqNo(String oldSeqNo) {
    log4jDocBudgetCertificate.debug("DocInvoice - oldSeqNo = " + oldSeqNo);
    BigDecimal seqNo = new BigDecimal(oldSeqNo);
    SeqNo = (seqNo.add(new BigDecimal("10"))).toString();
    log4jDocBudgetCertificate.debug("DocInvoice - nextSeqNo = " + SeqNo);
    return SeqNo;
  }

  public void loadObjectFieldProvider(ConnectionProvider conn, String stradClientId, String Id)
      throws ServletException {
    setObjectFieldProvider(DocBudgetCertificateData.selectRecord(conn, stradClientId, Id));
  }

  /**
   * Load Specific Document Details
   * 
   * @return true if loadDocumentType was set
   */
  public boolean loadDocumentDetails(FieldProvider[] data, ConnectionProvider conn) {
    DocumentType = DOCTYPE_BudgetCertificate;
    log4jDocBudgetCertificate.debug("data.length = " + data.length + " - DocumentType = "
        + DocumentType);

    // Amounts
    Amounts[AcctServer.AMTTYPE_Gross] = data[0].getField("Certified_Value");
    if (Amounts[AcctServer.AMTTYPE_Gross] == null)
      Amounts[AcctServer.AMTTYPE_Gross] = ZERO.toString();

    loadDocumentType(); // lines require doc type

    // Contained Objects
    p_lines = loadLines(conn);
    log4jDocBudgetCertificate.debug("Lines=" + p_lines.length);
    return true;
  } // loadDocumentDetails

  /**
   * Load Budget Certificate Line
   * 
   * @return DocLine Array
   */
  private DocLine[] loadLines(ConnectionProvider conn) {
    ArrayList<Object> list = new ArrayList<Object>();
    DocLineBudgetCertificateData[] data = null;
    try {
      data = DocLineBudgetCertificateData.select(connectionProvider, Record_ID);
      for (int i = 0; data != null && i < data.length; i++) {
        String t_Line_ID = data[i].sfbBudgetCertLineId;
        DocLine_BudgetCertificate docLine = new DocLine_BudgetCertificate(DocumentType, Record_ID,
            t_Line_ID);
        docLine.loadAttributes(data[i], this);
        docLine.m_SSPR_Concept_ID = data[i].emSsbpSsprConceptId;
        docLine.m_SSPR_Category_Acct_ID = data[i].emSsbpSsprCategoryAcctId;
        docLine.c_conceptInfo = new ConceptInfo(docLine.m_SSPR_Concept_ID, conn);
        docLine.setAmount(data[i].budgetCertifiedValue);
        list.add(docLine);
      }
    } catch (ServletException e) {
      log4jDocBudgetCertificate.warn(e);
    }
    // Return Array
    DocLine[] dl = new DocLine[list.size()];
    list.toArray(dl);
    return dl;
  } // loadLines

  public Fact createFact(AcctSchema as, ConnectionProvider conn, Connection con,
      VariablesSecureApp vars) throws ServletException {

    log4jDocBudgetCertificate.debug("Starting create fact");

    // create Fact Header
    Fact fact = new Fact(this, as, Fact.POST_Actual);

    String Fact_Acct_Group_ID = SequenceIdData.getUUID();

    ConceptInfoData[] data = null;
    // Lines
    for (int i = 0; p_lines != null && i < p_lines.length; i++) {
      DocLine_BudgetCertificate line = (DocLine_BudgetCertificate) p_lines[i];

      try {
        data = ConceptInfoData.selectConceptAcctDetails(conn, line.m_SSPR_Concept_ID,
            as.getC_AcctSchema_ID(), line.m_SSPR_Category_Acct_ID);

        if (data[0].isaccountpayroll.equals("Y")) {
          Account account = ((DocLine_BudgetCertificate) p_lines[i]).getAccount(
              ConceptInfo.ACCTTYPE_C_Debit, as, line.m_SSPR_Category_Acct_ID, conn);

          fact.createLine(line, account, C_Currency_ID, line.getAmount(), "", Fact_Acct_Group_ID,
              nextSeqNo(SeqNo), DocumentType, conn);

          account = ((DocLine_BudgetCertificate) p_lines[i]).getAccount(
              ConceptInfo.ACCTTYPE_C_Credit, as, line.m_SSPR_Category_Acct_ID, conn);
          fact.createLine(line, account, C_Currency_ID, "", line.getAmount(), Fact_Acct_Group_ID,
              nextSeqNo(SeqNo), DocumentType, conn);
        } else {
          if (data[0].isliability.equals("Y")) {
            Account account = ((DocLine_BudgetCertificate) p_lines[i]).getAccount(
                ConceptInfo.ACCTTYPE_C_Debit, as, line.m_SSPR_Category_Acct_ID, conn);

            fact.createLine(line, account, C_Currency_ID, "", line.getAmount(), Fact_Acct_Group_ID,
                nextSeqNo(SeqNo), DocumentType, conn);
          } else {
            Account account = ((DocLine_BudgetCertificate) p_lines[i]).getAccount(
                ConceptInfo.ACCTTYPE_C_Debit, as, line.m_SSPR_Category_Acct_ID, conn);

            fact.createLine(line, account, C_Currency_ID, line.getAmount(), "", Fact_Acct_Group_ID,
                nextSeqNo(SeqNo), DocumentType, conn);
          }
        }
      } catch (ServletException e) {
        log4jDocBudgetCertificate.warn(e);
      }
    }

    FactLine closing = fact.balanceSource(conn);
    closing.setAccount(as, ConceptInfo.getAccountDefault(ConceptInfo.ACCTTYPE_C_Closing, as, conn));

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
