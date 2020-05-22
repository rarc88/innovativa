//package org.openbravo.erpCommon.ad_forms;
package ec.com.sidesoft.budget.payroll.accounting;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.dal.core.OBContext;
import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.SequenceIdData;
import org.openbravo.erpCommon.utility.Utility;

import ec.com.sidesoft.budget.payroll.accounting.*;

import org.openbravo.erpCommon.ad_forms.AcctServer;
import org.openbravo.erpCommon.ad_forms.DocLine;
import org.openbravo.erpCommon.ad_forms.Fact;
import org.openbravo.erpCommon.ad_forms.AcctSchema;
import org.openbravo.erpCommon.ad_forms.Account;

import ec.com.sidesoft.budget.payroll.accounting.ConceptInfo;
import ec.com.sidesoft.budget.payroll.accounting.ConceptInfoData;
import ec.com.sidesoft.budget.payroll.accounting.ConceptInfoSettlementData;
import ec.com.sidesoft.budget.payroll.accounting.DocLineSettlementData;
import ec.com.sidesoft.budget.payroll.accounting.DocLine_Settlement;
import ec.com.sidesoft.budget.payroll.accounting.PayrollCategoryAcctData;

public class DocBudgetCertificate extends AcctServer {
  private static final long serialVersionUID = 1L;
  private String SeqNo = "0";
	public String strMessage = null;

  static Logger log4jDocBudgetCertificate = Logger.getLogger(DocBudgetCertificate.class);

  /** Budget Certificate */
  public static final String DOCTYPE_BudgetCertificate = "SFB_BC";

  /**
   * Constructor
   * 
   * @param AD_Client_ID
   *          AD_Client_ID
   */

  public DocBudgetCertificate(){
  }

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
    DocBudgetCertificateTypeData[] TypeCert = null;
    
    DocLineSettlementData[] dataStt = null;
    Integer line = 10;
    
    
    
   try {

	TypeCert = DocBudgetCertificateTypeData.selectTypeCertificate(connectionProvider,Record_ID);

	   if(TypeCert[0].emSsbpPayrolltype.equals("N")){
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
	   }else{
		   
		   dataStt = DocLineSettlementData.selectline(connectionProvider, TypeCert[0].emSsbpSsprSettlementId, TypeCert[0].emSsbpSsprSettlementId);
		      for (int i = 0; dataStt != null && i < dataStt.length; i++) {
		    	  String t_Line_ID = dataStt[i].ssprSettlementlineId;
		        DocLine_Settlement docLine = new DocLine_Settlement(DocumentType, Record_ID,
		            t_Line_ID);
		        docLine.loadAttributes(dataStt[i], this);
		        docLine.m_SSPR_Concept_ID = dataStt[i].ssprConceptId;
		        docLine.m_SSPR_Category_Acct_ID = dataStt[i].ssprCategoryAcctId;
		        docLine.c_conceptInfo = new ConceptInfo(docLine.m_SSPR_Concept_ID, conn);
		        docLine.setAmount(dataStt[i].totalnet);
		        docLine.m_IsBalance = "Y";
		        docLine.m_IsComplete = dataStt[i].iscomplete;
		        docLine.m_NameConcept = dataStt[i].nameconcept;
		        list.add(docLine);
		        line += 10;
		      }    
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

    BigDecimal closingAmt = ZERO;
    ConceptInfoData[] data = null;
    ConceptInfoSettlementData[] datatypeconcept = null;
    Double amount = 0.0;

    
    DocBudgetCertificateTypeData[] TypeCertFact = DocBudgetCertificateTypeData.selectTypeCertificate(connectionProvider,Record_ID);
    
    if(TypeCertFact[0].emSsbpPayrolltype.equals("N")){
    
	    // Lines Payroll
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
	
	            closingAmt.subtract(new BigDecimal(line.getAmount()));
	          } else {
	            Account account = ((DocLine_BudgetCertificate) p_lines[i]).getAccount(
	                ConceptInfo.ACCTTYPE_C_Debit, as, line.m_SSPR_Category_Acct_ID, conn);
	
	            fact.createLine(line, account, C_Currency_ID, line.getAmount(), "", Fact_Acct_Group_ID,
	                nextSeqNo(SeqNo), DocumentType, conn);
	
	            closingAmt.add(new BigDecimal(line.getAmount()));
	          }
	        }
	      } catch (ServletException e) {
	        log4jDocBudgetCertificate.warn(e);
	      }
	    }
	
	    if (closingAmt.compareTo(new BigDecimal(0)) == 1) { // Credit
	      Account account = ConceptInfo.getAccountDefault(ConceptInfo.ACCTTYPE_C_Closing, as, conn);
	      fact.createLine(null, account, C_Currency_ID, "", closingAmt.toString(), Fact_Acct_Group_ID,
	          nextSeqNo(SeqNo), DocumentType, conn);
	    } else if (closingAmt.compareTo(new BigDecimal(0)) == -1) { // Dedit
	      Account account = ConceptInfo.getAccountDefault(ConceptInfo.ACCTTYPE_C_Closing, as, conn);
	      fact.createLine(null, account, C_Currency_ID, closingAmt.abs().toString(), "",
	          Fact_Acct_Group_ID, nextSeqNo(SeqNo), DocumentType, conn);
	    }
    }else{
    	//Lines Settlement
    	
    	 // Lines
	     for (int i = 0; p_lines != null && i < p_lines.length; i++) {
	       DocLine_Settlement line = (DocLine_Settlement) p_lines[i];

	       try {
	         if (line.m_IsComplete.equals("N")) {
	         	  
	             data = ConceptInfoData.selectConceptAcctDetails(conn, line.m_SSPR_Concept_ID,
	                 as.getC_AcctSchema_ID(), line.m_SSPR_Category_Acct_ID);
	             
	             if (data.length > 0) {
	             	
	             	datatypeconcept = ConceptInfoSettlementData.selectConceptType(conn, line.m_SSPR_Concept_ID);
	             	
	             	if(datatypeconcept[0].conceptsubtype.equals("In")){
	             			Account account = ((DocLine_Settlement) p_lines[i]).getAccount(
	                             ConceptInfo.ACCTTYPE_C_Credit, as, line.m_SSPR_Category_Acct_ID, conn);

	             			if(account != null){
	             				 fact.createLine(line, account, C_Currency_ID, line.getAmount(), "",
	                                      Fact_Acct_Group_ID, nextSeqNo(SeqNo), DocumentType, conn);

	                                  amount += Double.parseDouble(line.getAmount());
	             			} else{
	             				String language = OBContext.getOBContext().getLanguage().getLanguage();
	                             strMessage = Utility.messageBD(conn, "No found account for the concept " + line.m_NameConcept, language);
	                             OBError err = new OBError();
	                             err.setType("Error");
	                             err.setMessage(strMessage);
	                             setMessageResult(err);
	             			}
	                        
	             	} else {
	             		
	             		Account account = ((DocLine_Settlement) p_lines[i]).getAccount(
	                             ConceptInfo.ACCTTYPE_C_Credit, as, line.m_SSPR_Category_Acct_ID, conn);

	             		if(account != null){
	             			
	             			fact.createLine(line, account, C_Currency_ID,"", line.getAmount(),
	                                 Fact_Acct_Group_ID, nextSeqNo(SeqNo), DocumentType, conn);

	                             amount -= Double.parseDouble(line.getAmount());
	             		} else {
	             			 String language = OBContext.getOBContext().getLanguage().getLanguage();
	                          strMessage = Utility.messageBD(conn, "No found account for the concept " + line.m_NameConcept, language);
	                          OBError err = new OBError();
	                          err.setType("Error");
	                          err.setMessage(strMessage);
	                          setMessageResult(err);
	             		}
	                         
	             	}
	                   

	             } else {
	               String language = OBContext.getOBContext().getLanguage().getLanguage();
	               strMessage = Utility.messageBD(conn, "SSPR_NoConceptAcct", language);
	               OBError err = new OBError();
	               err.setType("Error");
	               err.setMessage(strMessage);
	               setMessageResult(err);
	             }
	           
	         } else {
	             PayrollCategoryAcctData[] prCatAcct = null;
	             prCatAcct = PayrollCategoryAcctData.select(connectionProvider, line.m_C_BPartner_ID);
	             
	            if(prCatAcct[0].balanceacctId.equals("")  || prCatAcct[0].balanceacctId == null){
	            	
	                 	String language = OBContext.getOBContext().getLanguage().getLanguage();
	                     strMessage = Utility.messageBD(conn, "No found employee account ", language);
	                     OBError err = new OBError();
	                     err.setType("Error");
	                     err.setMessage(strMessage);
	                     setMessageResult(err);
	                     
	            }
	            
	             Account account = new Account(connectionProvider, prCatAcct[0].balanceacctId);
	             
	             if(account != null){
	             	  line.setAmount(amount.toString());
	                   fact.createLine(line, account , C_Currency_ID, "", line.getAmount(), Fact_Acct_Group_ID,
	                       nextSeqNo(SeqNo), DocumentType, conn);
	                   amount = 0.0;
	             }else {
	            	 String language = OBContext.getOBContext().getLanguage().getLanguage();
                     strMessage = Utility.messageBD(conn, "No found employee account ", language);
                     OBError err = new OBError();
                     err.setType("Error");
                     err.setMessage(strMessage);
                     setMessageResult(err);
	             }
	         }
	       } catch (ServletException e) {
	    	   log4jDocBudgetCertificate.warn(e);
	       }
	     }	    	
    }

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
