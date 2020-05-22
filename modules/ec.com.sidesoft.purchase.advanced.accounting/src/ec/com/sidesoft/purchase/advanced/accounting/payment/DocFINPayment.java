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
 * All portions are Copyright (C) 2010-2014 Openbravo SLU
 * All Rights Reserved.
 * Contributor(s):  ______________________________________.
 ************************************************************************
 */
package ec.com.sidesoft.purchase.advanced.accounting.payment;

import java.math.BigDecimal;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.openbravo.advpaymentmngt.utility.FIN_Utility;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.base.session.OBPropertiesProvider;
import org.openbravo.client.kernel.KernelConstants;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.dal.service.OBQuery;
import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.ad_forms.Account;
import org.openbravo.erpCommon.ad_forms.AcctSchema;
import org.openbravo.erpCommon.ad_forms.AcctServer;
import org.openbravo.erpCommon.ad_forms.DocLine;
import org.openbravo.erpCommon.ad_forms.Fact;
import org.openbravo.erpCommon.utility.CashVATUtil;
import org.openbravo.erpCommon.utility.FieldProviderFactory;
import org.openbravo.erpCommon.utility.OBDateUtils;
import org.openbravo.erpCommon.utility.SequenceIdData;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.businesspartner.CategoryAccounts;
import org.openbravo.model.common.businesspartner.CustomerAccounts;
import org.openbravo.model.common.businesspartner.VendorAccounts;
import org.openbravo.model.common.currency.ConversionRateDoc;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.AcctSchemaTableDocType;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.common.invoice.InvoiceLine;
import org.openbravo.model.financialmgmt.accounting.FIN_FinancialAccountAccounting;
import org.openbravo.model.financialmgmt.accounting.coa.AcctSchemaTable;
import org.openbravo.model.financialmgmt.gl.GLItem;
import org.openbravo.model.financialmgmt.payment.FIN_FinancialAccount;
import org.openbravo.model.financialmgmt.payment.FIN_Payment;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentDetail;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentMethod;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentSchedule;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentScheduleDetail;
import org.openbravo.model.financialmgmt.payment.FIN_Payment_Credit;
import org.openbravo.model.financialmgmt.payment.FinAccPaymentMethod;

public class DocFINPayment extends AcctServer {
  private static final long serialVersionUID = 1L;
  static Logger log4j = Logger.getLogger(DocFINPayment.class);

  String SeqNo = "0";
  String generatedAmount = "";
  String usedAmount = "";

  private Invoice invoice = null;

  public DocFINPayment() {
  }

  public DocFINPayment(String AD_Client_ID, String AD_Org_ID,
      ConnectionProvider connectionProvider) {
    super(AD_Client_ID, AD_Org_ID, connectionProvider);
  }

  @Override
  public boolean loadDocumentDetails(FieldProvider[] data, ConnectionProvider conn) {
    DateDoc = data[0].getField("PaymentDate");
    m_Record_Id2 = data[0].getField("recordId2");
    Amounts[AMTTYPE_Gross] = data[0].getField("Amount");
    generatedAmount = data[0].getField("GeneratedCredit");
    usedAmount = data[0].getField("UsedCredit");
    loadDocumentType();
    p_lines = loadLines();
    return true;
  }

  public FieldProviderFactory[] loadLinesFieldProvider(String Id) {
    FIN_Payment payment = OBDal.getInstance().get(FIN_Payment.class, Id);
    List<FIN_PaymentDetail> paymentDetails = FIN_Utility.getOrderedPaymentDetailList(payment);
    if (paymentDetails == null)
      return null;

    FieldProviderFactory[] data = new FieldProviderFactory[paymentDetails.size()];
    FIN_PaymentSchedule ps = null;
    FIN_PaymentDetail pd = null;
    OBContext.setAdminMode();
    try {
      for (int i = 0; i < data.length; i++) {
        // Details refunded used credit are excluded as the entry will be created using the credit
        // used
        if (paymentDetails.get(i).isRefund() && paymentDetails.get(i).isPrepayment()) {
          continue;
        }

        // If the Payment Detail has already been processed, skip it
        if (paymentDetails.get(i).equals(pd)) {
          continue;
        }
        pd = paymentDetails.get(i);

        data[i] = new FieldProviderFactory(null);
        FIN_PaymentSchedule psi = paymentDetails.get(i).getFINPaymentScheduleDetailList().get(0)
            .getInvoicePaymentSchedule();
        FIN_PaymentSchedule pso = paymentDetails.get(i).getFINPaymentScheduleDetailList().get(0)
            .getOrderPaymentSchedule();
        // Related to Issue Issue 19567. Some Payment Detail's amount and writeoff amount are merged
        // into one.
        // https://issues.openbravo.com/view.php?id=19567
        HashMap<String, BigDecimal> amountAndWriteOff = getPaymentDetailWriteOffAndAmount(
            paymentDetails, ps, psi, pso, i);
        BigDecimal amount = amountAndWriteOff.get("amount");
        BigDecimal writeOff = amountAndWriteOff.get("writeoff");
        if (amount == null) {
          data[i] = null;
          ps = psi;
          continue;
        } else {
          FieldProviderFactory.setField(data[i], "Amount", amount.toString());
        }
        ps = psi;

        FieldProviderFactory.setField(data[i], "AD_Client_ID",
            paymentDetails.get(i).getClient().getId());
        FieldProviderFactory.setField(data[i], "AD_Org_ID",
            paymentDetails.get(i).getOrganization().getId());
        FieldProviderFactory.setField(data[i], "FIN_Payment_Detail_ID",
            paymentDetails.get(i).getId());
        // Calculate Business Partner from payment header or from details if header is null or from
        // the PSD in case of GL Item
        BusinessPartner bPartner = payment.getBusinessPartner() != null
            ? payment.getBusinessPartner()
            : (paymentDetails.get(i).getFINPaymentScheduleDetailList().get(0)
                .getInvoicePaymentSchedule() != null
                    ? paymentDetails.get(i).getFINPaymentScheduleDetailList().get(0)
                        .getInvoicePaymentSchedule().getInvoice().getBusinessPartner()
                    : (paymentDetails.get(i).getFINPaymentScheduleDetailList().get(0)
                        .getOrderPaymentSchedule() != null
                            ? paymentDetails.get(i).getFINPaymentScheduleDetailList().get(0)
                                .getOrderPaymentSchedule().getOrder().getBusinessPartner()
                            : (paymentDetails.get(i).getFINPaymentScheduleDetailList().get(0)
                                .getBusinessPartner())));
        FieldProviderFactory.setField(data[i], "cBpartnerId",
            bPartner != null ? bPartner.getId() : "");
        FieldProviderFactory.setField(data[i], "DoubtFulDebtAmount", paymentDetails.get(i)
            .getFINPaymentScheduleDetailList().get(0).getDoubtfulDebtAmount().toString());
        FieldProviderFactory.setField(data[i], "WriteOffAmt", writeOff.toString());
        FieldProviderFactory.setField(data[i], "C_GLItem_ID",
            paymentDetails.get(i).getGLItem() != null ? paymentDetails.get(i).getGLItem().getId()
                : "");
        FieldProviderFactory.setField(data[i], "Refund",
            paymentDetails.get(i).isRefund() ? "Y" : "N");
        // Check if payment against invoice is in a previous date than invoice accounting date
        boolean isPaymentDatePriorToInvoiceDate = isPaymentDatePriorToInvoiceDate(
            paymentDetails.get(i));
        FieldProviderFactory.setField(data[i], "isprepayment",
            paymentDetails.get(i).isPrepayment() ? "Y"
                : (isPaymentDatePriorToInvoiceDate ? "Y" : "N"));
        FieldProviderFactory.setField(data[i], "isPaymentDatePriorToInvoiceDate",
            isPaymentDatePriorToInvoiceDate && !paymentDetails.get(i).isPrepayment() ? "Y" : "N");
        FieldProviderFactory.setField(data[i], "cProjectId", paymentDetails.get(i)
            .getFINPaymentScheduleDetailList().get(0).getInvoicePaymentSchedule() != null
            && paymentDetails.get(i).getFINPaymentScheduleDetailList().get(0)
                .getInvoicePaymentSchedule().getInvoice().getProject() != null
                    ? paymentDetails.get(i).getFINPaymentScheduleDetailList().get(0)
                        .getInvoicePaymentSchedule().getInvoice().getProject().getId()
                    : (paymentDetails.get(i).getFINPaymentScheduleDetailList().get(0)
                        .getOrderPaymentSchedule() != null
                        && paymentDetails.get(i).getFINPaymentScheduleDetailList().get(0)
                            .getOrderPaymentSchedule().getOrder().getProject() != null
                                ? paymentDetails.get(i).getFINPaymentScheduleDetailList().get(0)
                                    .getOrderPaymentSchedule().getOrder().getProject().getId()
                                : (paymentDetails.get(i).getFINPaymentScheduleDetailList().get(0)
                                    .getProject() != null
                                        ? paymentDetails.get(i).getFINPaymentScheduleDetailList()
                                            .get(0).getProject().getId()
                                        : "")));
        FieldProviderFactory.setField(data[i], "cCampaignId", paymentDetails.get(i)
            .getFINPaymentScheduleDetailList().get(0).getInvoicePaymentSchedule() != null
            && paymentDetails.get(i).getFINPaymentScheduleDetailList().get(0)
                .getInvoicePaymentSchedule().getInvoice().getSalesCampaign() != null
                    ? paymentDetails.get(i).getFINPaymentScheduleDetailList().get(0)
                        .getInvoicePaymentSchedule().getInvoice().getSalesCampaign().getId()
                    : (paymentDetails.get(i).getFINPaymentScheduleDetailList().get(0)
                        .getOrderPaymentSchedule() != null
                        && paymentDetails.get(i).getFINPaymentScheduleDetailList().get(0)
                            .getOrderPaymentSchedule().getOrder().getSalesCampaign() != null
                                ? paymentDetails.get(i).getFINPaymentScheduleDetailList().get(0)
                                    .getOrderPaymentSchedule().getOrder().getSalesCampaign().getId()
                                : (paymentDetails.get(i).getFINPaymentScheduleDetailList().get(0)
                                    .getSalesCampaign() != null
                                        ? paymentDetails.get(i).getFINPaymentScheduleDetailList()
                                            .get(0).getSalesCampaign().getId()
                                        : "")));
        FieldProviderFactory.setField(data[i], "cActivityId", paymentDetails.get(i)
            .getFINPaymentScheduleDetailList().get(0).getInvoicePaymentSchedule() != null
            && paymentDetails.get(i).getFINPaymentScheduleDetailList().get(0)
                .getInvoicePaymentSchedule().getInvoice().getActivity() != null
                    ? paymentDetails.get(i).getFINPaymentScheduleDetailList().get(0)
                        .getInvoicePaymentSchedule().getInvoice().getActivity().getId()
                    : (paymentDetails.get(i).getFINPaymentScheduleDetailList().get(0)
                        .getOrderPaymentSchedule() != null
                        && paymentDetails.get(i).getFINPaymentScheduleDetailList().get(0)
                            .getOrderPaymentSchedule().getOrder().getActivity() != null
                                ? paymentDetails.get(i).getFINPaymentScheduleDetailList().get(0)
                                    .getOrderPaymentSchedule().getOrder().getActivity().getId()
                                : (paymentDetails.get(i).getFINPaymentScheduleDetailList().get(0)
                                    .getActivity() != null
                                        ? paymentDetails.get(i).getFINPaymentScheduleDetailList()
                                            .get(0).getActivity().getId()
                                        : "")));
        FieldProviderFactory.setField(data[i], "mProductId",
            paymentDetails.get(i).getFINPaymentScheduleDetailList().get(0).getProduct() != null
                ? paymentDetails.get(i).getFINPaymentScheduleDetailList().get(0).getProduct()
                    .getId()
                : "");
        FieldProviderFactory.setField(data[i], "cSalesregionId",
            paymentDetails.get(i).getFINPaymentScheduleDetailList().get(0).getSalesRegion() != null
                ? paymentDetails.get(i).getFINPaymentScheduleDetailList().get(0).getSalesRegion()
                    .getId()
                : "");
        FieldProviderFactory.setField(data[i], "cCostcenterId", paymentDetails.get(i)
            .getFINPaymentScheduleDetailList().get(0).getInvoicePaymentSchedule() != null
            && paymentDetails.get(i).getFINPaymentScheduleDetailList().get(0)
                .getInvoicePaymentSchedule().getInvoice().getCostcenter() != null
                    ? paymentDetails.get(i).getFINPaymentScheduleDetailList().get(0)
                        .getInvoicePaymentSchedule().getInvoice().getCostcenter().getId()
                    : (paymentDetails.get(i).getFINPaymentScheduleDetailList().get(0)
                        .getOrderPaymentSchedule() != null
                        && paymentDetails.get(i).getFINPaymentScheduleDetailList().get(0)
                            .getOrderPaymentSchedule().getOrder().getCostcenter() != null
                                ? paymentDetails.get(i).getFINPaymentScheduleDetailList().get(0)
                                    .getOrderPaymentSchedule().getOrder().getCostcenter().getId()
                                : (paymentDetails.get(i).getFINPaymentScheduleDetailList().get(0)
                                    .getCostCenter() != null
                                        ? paymentDetails.get(i).getFINPaymentScheduleDetailList()
                                            .get(0).getCostCenter().getId()
                                        : "")));

        FieldProviderFactory.setField(data[i], "user1Id", paymentDetails.get(i)
            .getFINPaymentScheduleDetailList().get(0).getInvoicePaymentSchedule() != null
            && paymentDetails.get(i).getFINPaymentScheduleDetailList().get(0)
                .getInvoicePaymentSchedule().getInvoice().getStDimension() != null
                    ? paymentDetails.get(i).getFINPaymentScheduleDetailList().get(0)
                        .getInvoicePaymentSchedule().getInvoice().getStDimension().getId()
                    : (paymentDetails.get(i).getFINPaymentScheduleDetailList().get(0)
                        .getOrderPaymentSchedule() != null
                        && paymentDetails.get(i).getFINPaymentScheduleDetailList().get(0)
                            .getOrderPaymentSchedule().getOrder().getStDimension() != null
                                ? paymentDetails.get(i).getFINPaymentScheduleDetailList().get(0)
                                    .getOrderPaymentSchedule().getOrder().getStDimension().getId()
                                : (paymentDetails.get(i).getFINPaymentScheduleDetailList().get(0)
                                    .getStDimension() != null
                                        ? paymentDetails.get(i).getFINPaymentScheduleDetailList()
                                            .get(0).getStDimension().getId()
                                        : "")));
        FieldProviderFactory.setField(data[i], "user2Id", paymentDetails.get(i)
            .getFINPaymentScheduleDetailList().get(0).getInvoicePaymentSchedule() != null
            && paymentDetails.get(i).getFINPaymentScheduleDetailList().get(0)
                .getInvoicePaymentSchedule().getInvoice().getNdDimension() != null
                    ? paymentDetails.get(i).getFINPaymentScheduleDetailList().get(0)
                        .getInvoicePaymentSchedule().getInvoice().getNdDimension().getId()
                    : (paymentDetails.get(i).getFINPaymentScheduleDetailList().get(0)
                        .getOrderPaymentSchedule() != null
                        && paymentDetails.get(i).getFINPaymentScheduleDetailList().get(0)
                            .getOrderPaymentSchedule().getOrder().getNdDimension() != null
                                ? paymentDetails.get(i).getFINPaymentScheduleDetailList().get(0)
                                    .getOrderPaymentSchedule().getOrder().getNdDimension().getId()
                                : (paymentDetails.get(i).getFINPaymentScheduleDetailList().get(0)
                                    .getNdDimension() != null
                                        ? paymentDetails.get(i).getFINPaymentScheduleDetailList()
                                            .get(0).getNdDimension().getId()
                                        : "")));
        FieldProviderFactory.setField(data[i], "recordId2",
            paymentDetails.get(i).isPrepayment() ? (pso != null ? pso.getId() : "")
                : (psi != null ? psi.getId() : ""));

      }
    } finally {
      OBContext.restorePreviousMode();
    }
    return data;
  }

  private DocLine[] loadLines() {
    ArrayList<Object> list = new ArrayList<Object>();
    FieldProviderFactory[] data = loadLinesFieldProvider(Record_ID);
    if (data == null || data.length == 0)
      return null;
    for (int i = 0; i < data.length; i++) {
      if (data[i] == null)
        continue;
      String Line_ID = data[i].getField("FIN_Payment_Detail_ID");
      OBContext.setAdminMode();
      try {
        FIN_PaymentDetail detail = OBDal.getInstance().get(FIN_PaymentDetail.class, Line_ID);
        DocLine_FINPayment docLine = new DocLine_FINPayment(DocumentType, Record_ID, Line_ID);
        docLine.loadAttributes(data[i], this);
        docLine.setAmount(data[i].getField("Amount"));
        docLine.setIsPrepayment(data[i].getField("isprepayment"));
        docLine.setWriteOffAmt(data[i].getField("WriteOffAmt"));
        docLine.setDoubtFulDebtAmount(new BigDecimal(data[i].getField("DoubtFulDebtAmount")));
        docLine.setC_GLItem_ID(data[i].getField("C_GLItem_ID"));
        docLine.setPrepaymentAgainstInvoice(
            "Y".equals(data[i].getField("isPaymentDatePriorToInvoiceDate")) ? true : false);
        docLine.setInvoice(detail.getFINPaymentScheduleDetailList() != null
            && detail.getFINPaymentScheduleDetailList().get(0).getInvoicePaymentSchedule() != null
                ? detail.getFINPaymentScheduleDetailList().get(0).getInvoicePaymentSchedule()
                    .getInvoice()
                : null);
        docLine.m_Record_Id2 = data[i].getField("recordId2");
        docLine.setInvoiceTaxCashVAT_V(Line_ID);
        list.add(docLine);
      } finally {
        OBContext.restorePreviousMode();
      }
    }
    // Return Array
    DocLine_FINPayment[] dl = new DocLine_FINPayment[list.size()];
    list.toArray(dl);
    return dl;
  } // loadLines

  @Override
  public Fact createFact(AcctSchema as, ConnectionProvider conn, Connection con,
      VariablesSecureApp vars) throws ServletException {
    // Select specific definition
    String strClassname = "";
    final StringBuilder whereClause = new StringBuilder();
    Fact fact = new Fact(this, as, Fact.POST_Actual);
    String Fact_Acct_Group_ID = SequenceIdData.getUUID();
    String Fact_Acct_Group_ID2 = SequenceIdData.getUUID();
    String Fact_Acct_Group_ID3 = SequenceIdData.getUUID();

    int paymentyear = 0;
    int invoiceyear = 0;
    boolean previousyear = false;
    boolean previousyearpayment = false;
    PaymentPreviousYearData[] PaymentPreviousYear = null;

    OBContext.setAdminMode();
    try {
      whereClause.append(" as astdt ");
      whereClause.append(
          " where astdt.acctschemaTable.accountingSchema.id = '" + as.m_C_AcctSchema_ID + "'");
      whereClause.append(" and astdt.acctschemaTable.table.id = '" + AD_Table_ID + "'");
      whereClause.append(" and astdt.documentCategory = '" + DocumentType + "'");

      final OBQuery<AcctSchemaTableDocType> obqParameters = OBDal.getInstance()
          .createQuery(AcctSchemaTableDocType.class, whereClause.toString());
      final List<AcctSchemaTableDocType> acctSchemaTableDocTypes = obqParameters.list();

      if (acctSchemaTableDocTypes != null && acctSchemaTableDocTypes.size() > 0)
        strClassname = acctSchemaTableDocTypes.get(0).getCreatefactTemplate().getClassname();

      if (strClassname.equals("")) {
        final StringBuilder whereClause2 = new StringBuilder();

        whereClause2.append(" as ast ");
        whereClause2.append(" where ast.accountingSchema.id = '" + as.m_C_AcctSchema_ID + "'");
        whereClause2.append(" and ast.table.id = '" + AD_Table_ID + "'");

        final OBQuery<AcctSchemaTable> obqParameters2 = OBDal.getInstance()
            .createQuery(AcctSchemaTable.class, whereClause2.toString());
        final List<AcctSchemaTable> acctSchemaTables = obqParameters2.list();
        if (acctSchemaTables != null && acctSchemaTables.size() > 0
            && acctSchemaTables.get(0).getCreatefactTemplate() != null)
          strClassname = acctSchemaTables.get(0).getCreatefactTemplate().getClassname();
      }
      /*
       * if (!strClassname.equals("")) { try { DocFINPaymentTemplate newTemplate =
       * (DocFINPaymentTemplate) Class.forName(strClassname) .newInstance(); return
       * newTemplate.createFact(this, as, conn, con, vars); } catch (Exception e) {
       * log4j.error("Error while creating new instance for DocFINPaymentTemplate - ", e); } }
       */

      for (int i = 0; p_lines != null && i < p_lines.length; i++) {
        DocLine_FINPayment line = (DocLine_FINPayment) p_lines[i];

        boolean isReceipt = DocumentType.equals("ARR");
        boolean isPrepayment = line.getIsPrepayment().equals("Y");
        String bpartnerId = (line.m_C_BPartner_ID == null || line.m_C_BPartner_ID.equals(""))
            ? this.C_BPartner_ID
            : line.m_C_BPartner_ID;

        String bpAmount = line.getAmount();
        if (line.WriteOffAmt != null && !line.WriteOffAmt.equals("")
            && new BigDecimal(line.WriteOffAmt).compareTo(ZERO) != 0) {
          Account account = isReceipt ? getAccount(AcctServer.ACCTTYPE_WriteOff, as, conn)
              : getAccount(AcctServer.ACCTTYPE_WriteOff_Revenue, as, conn);
          if (account == null) {
            account = isReceipt ? getAccount(AcctServer.ACCTTYPE_WriteOffDefault, as, conn)
                : getAccount(AcctServer.ACCTTYPE_WriteOffDefault_Revenue, as, conn);
          }
          fact.createLine(line, account, C_Currency_ID, (isReceipt ? line.WriteOffAmt : ""),
              (isReceipt ? "" : line.WriteOffAmt), Fact_Acct_Group_ID, nextSeqNo(SeqNo),
              DocumentType, conn);
          bpAmount = new BigDecimal(bpAmount).add(new BigDecimal(line.WriteOffAmt)).toString();
        }
        if ("".equals(line.getC_GLItem_ID())) {
          String bpAmountConverted = bpAmount;
          invoice = line.getInvoice();

          paymentyear = 0;
          invoiceyear = 0;
          previousyear = false;

          if (invoice != null) {

            Calendar invoicedate = Calendar.getInstance();
            invoicedate.setTime(invoice.getAccountingDate());
            invoiceyear = invoicedate.get(Calendar.YEAR);

            OBPropertiesProvider obPropertiesProvider = OBPropertiesProvider.getInstance();
            Properties properties = obPropertiesProvider.getOpenbravoProperties();
            String strDateTimeFormat = (String) properties
                .get(KernelConstants.DATE_FORMAT_PROPERTY);
            try {
              Date result = new SimpleDateFormat(strDateTimeFormat).parse(DateAcct);
              Calendar paymentdate = Calendar.getInstance();
              paymentdate.setTime(result);
              paymentyear = paymentdate.get(Calendar.YEAR);
            } catch (ParseException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
            }
            if (invoiceyear != paymentyear) {
              previousyear = true;
            } else {
              previousyear = false;
            }
          }
          // }else{
          // previousyear = true;
          // }

          String strcCurrencyId = C_Currency_ID;
          if (!isOrderPrepayment(line.getLine_ID()) && invoice != null) {
            // To force opposite posting isReceipt is opposite as well. this is required when
            // looking backwards
            bpAmountConverted = convertAmount(new BigDecimal(bpAmount), !isReceipt, DateAcct,
                TABLEID_Invoice, invoice.getId(), C_Currency_ID, as.m_C_Currency_ID, line, as, fact,
                Fact_Acct_Group_ID, nextSeqNo(SeqNo), conn).toString();
            if (!isPrepayment) {
              if (line.getDoubtFulDebtAmount().signum() != 0) {
                BigDecimal doubtFulDebtAmount = convertAmount(line.getDoubtFulDebtAmount(),
                    isReceipt, DateAcct, TABLEID_Invoice, invoice.getId(), C_Currency_ID,
                    as.m_C_Currency_ID, line, as, fact, Fact_Acct_Group_ID, nextSeqNo(SeqNo), conn,
                    false);
                fact.createLine(line,
                    getAccountBPartnerPayment(bpartnerId, as, true, false, true, conn,
                        previousyear),
                    strcCurrencyId, "", doubtFulDebtAmount.toString(), Fact_Acct_Group_ID,
                    nextSeqNo(SeqNo), DocumentType, conn);
                bpAmountConverted = new BigDecimal(bpAmountConverted).subtract(doubtFulDebtAmount)
                    .toString();
                fact.createLine(line,
                    getAccountBPartnerAllowanceForDoubtfulDebt(bpartnerId, as, conn),
                    this.C_Currency_ID, doubtFulDebtAmount.toString(), "", Fact_Acct_Group_ID2,
                    nextSeqNo(SeqNo), DocumentType, conn);
                // Assign expense to the dimensions of the invoice lines
                BigDecimal assignedAmount = BigDecimal.ZERO;
                DocDoubtfulDebtData[] data = DocDoubtfulDebtData.select(conn, invoice.getId());
                Currency currency = OBDal.getInstance().get(Currency.class, C_Currency_ID);
                for (int j = 0; j < data.length; j++) {
                  BigDecimal lineAmount = doubtFulDebtAmount
                      .multiply(new BigDecimal(data[j].percentage)).setScale(
                          currency.getStandardPrecision().intValue(), BigDecimal.ROUND_HALF_UP);
                  if (j == data.length - 1) {
                    lineAmount = doubtFulDebtAmount.subtract(assignedAmount);
                  }
                  DocLine lineDD = new DocLine(DocumentType, Record_ID, "");
                  lineDD.m_A_Asset_ID = data[j].aAssetId;
                  lineDD.m_M_Product_ID = data[j].mProductId;
                  lineDD.m_C_Project_ID = data[j].cProjectId;
                  lineDD.m_C_BPartner_ID = data[j].cBpartnerId;
                  lineDD.m_C_Costcenter_ID = data[j].cCostcenterId;
                  lineDD.m_C_Campaign_ID = data[j].cCampaignId;
                  lineDD.m_C_Activity_ID = data[j].cActivityId;
                  lineDD.m_C_Glitem_ID = data[j].mCGlitemId;
                  lineDD.m_User1_ID = data[j].user1id;
                  lineDD.m_User2_ID = data[j].user2id;
                  lineDD.m_AD_Org_ID = data[j].adOrgId;
                  fact.createLine(lineDD,
                      getAccountBPartnerBadDebt(
                          (lineDD.m_C_BPartner_ID == null || lineDD.m_C_BPartner_ID.equals(""))
                              ? this.C_BPartner_ID
                              : lineDD.m_C_BPartner_ID,
                          false, as, conn),
                      this.C_Currency_ID, "", lineAmount.toString(), Fact_Acct_Group_ID2,
                      nextSeqNo(SeqNo), DocumentType, conn);
                  assignedAmount = assignedAmount.add(lineAmount);
                }
              }

              // Cash VAT
              SeqNo = CashVATUtil.createFactCashVAT(as, conn, fact, Fact_Acct_Group_ID, line,
                  invoice, DocumentType, C_Currency_ID, SeqNo);
            }
          }
          if (invoice != null) {
            if (invoice.getDocumentType().getDocumentCategory().equals(AcctServer.DOCTYPE_APInvoice)
                || invoice.getDocumentType().getDocumentCategory()
                    .equals(AcctServer.DOCTYPE_APCredit)) {
              posForInvoiceLine(line, invoice, as, conn, fact, Fact_Acct_Group_ID,
                  new BigDecimal(bpAmountConverted), isPrepayment, previousyear, strcCurrencyId);
            } else {
              fact.createLine(line,
                  getAccountBPartnerPayment(bpartnerId, as, isReceipt, isPrepayment, conn,
                      previousyear),
                  strcCurrencyId, (isReceipt ? "" : bpAmountConverted),
                  (isReceipt ? bpAmountConverted : ""), Fact_Acct_Group_ID, nextSeqNo(SeqNo),
                  DocumentType, conn);
            }
          } else {
            fact.createLine(line,
                getAccountBPartnerPayment(bpartnerId, as, isReceipt, isPrepayment, conn,
                    previousyear),
                strcCurrencyId, (isReceipt ? "" : bpAmountConverted),
                (isReceipt ? bpAmountConverted : ""), Fact_Acct_Group_ID, nextSeqNo(SeqNo),
                DocumentType, conn);
          }
          // If payment date is prior to invoice date book invoice as a pre-payment not as a regular
          // Receivable/Payable
          if (line.isPrepaymentAgainstInvoice()) {
            DocLine line2 = new DocLine(DocumentType, Record_ID, line.m_TrxLine_ID);
            line2.copyInfo(line);
            line2.m_DateAcct = OBDateUtils.formatDate(invoice.getAccountingDate());
            // checking if the prepayment account and ReceivablesNo account in the Business Partner
            // is the same.In this case we do not need to create more accounting lines
            if (invoice != null) {
              if (invoice.getDocumentType().getDocumentCategory()
                  .equals(AcctServer.DOCTYPE_APInvoice)
                  || invoice.getDocumentType().getDocumentCategory()
                      .equals(AcctServer.DOCTYPE_APCredit)) {
                posForInvoiceLinePrepaymentAgainstInvoice(line2, invoice, as, conn, fact,
                    Fact_Acct_Group_ID, new BigDecimal(bpAmountConverted), previousyear,
                    strcCurrencyId);
              } else {

                if (!getAccountBPartnerPayment(bpartnerId, as, isReceipt, true, conn,
                    previousyear).Account_ID
                        .equals(getAccountBPartnerPayment(bpartnerId, as, isReceipt, false, conn,
                            previousyear).Account_ID)) {
                  fact.createLine(line2,
                      getAccountBPartnerPayment(bpartnerId, as, isReceipt, false, conn,
                          previousyear),
                      strcCurrencyId, (isReceipt ? "" : bpAmountConverted),
                      (isReceipt ? bpAmountConverted : ""), Fact_Acct_Group_ID3, nextSeqNo(SeqNo),
                      DocumentType, conn);
                  fact.createLine(line2,
                      getAccountBPartnerPayment(bpartnerId, as, isReceipt, true, conn,
                          previousyear),
                      strcCurrencyId, (!isReceipt ? "" : bpAmountConverted),
                      (!isReceipt ? bpAmountConverted : ""), Fact_Acct_Group_ID3, nextSeqNo(SeqNo),
                      DocumentType, conn);
                }
              }
            } else {

              if (!getAccountBPartnerPayment(bpartnerId, as, isReceipt, true, conn,
                  previousyear).Account_ID
                      .equals(getAccountBPartnerPayment(bpartnerId, as, isReceipt, false, conn,
                          previousyear).Account_ID)) {
                fact.createLine(line2,
                    getAccountBPartnerPayment(bpartnerId, as, isReceipt, false, conn, previousyear),
                    strcCurrencyId, (isReceipt ? "" : bpAmountConverted),
                    (isReceipt ? bpAmountConverted : ""), Fact_Acct_Group_ID3, nextSeqNo(SeqNo),
                    DocumentType, conn);
                fact.createLine(line2,
                    getAccountBPartnerPayment(bpartnerId, as, isReceipt, true, conn, previousyear),
                    strcCurrencyId, (!isReceipt ? "" : bpAmountConverted),
                    (!isReceipt ? bpAmountConverted : ""), Fact_Acct_Group_ID3, nextSeqNo(SeqNo),
                    DocumentType, conn);
              }
            }
          }
        } else {
          fact.createLine(line,
              getAccountGLItem(OBDal.getInstance().get(GLItem.class, line.getC_GLItem_ID()), as,
                  isReceipt, conn),
              C_Currency_ID, (isReceipt ? "" : bpAmount), (isReceipt ? bpAmount : ""),
              Fact_Acct_Group_ID, nextSeqNo(SeqNo), DocumentType, conn);
        }
      }
      FIN_Payment payment = OBDal.getInstance().get(FIN_Payment.class, Record_ID);
      if (BigDecimal.ZERO.compareTo(new BigDecimal(Amounts[AMTTYPE_Gross])) != 0) {
        fact.createLine(null,
            getAccount(conn, payment.getPaymentMethod(), payment.getAccount(), as,
                payment.isReceipt()),
            C_Currency_ID, (payment.isReceipt() ? Amounts[AMTTYPE_Gross] : ""),
            (payment.isReceipt() ? "" : Amounts[AMTTYPE_Gross]), Fact_Acct_Group_ID, "999999",
            DocumentType, conn);
      }
      // Pre-payment is consumed when Used Credit Amount not equals Zero. When consuming Credit no
      // credit is generated
      if (new BigDecimal(usedAmount).compareTo(ZERO) != 0
          && new BigDecimal(generatedAmount).compareTo(ZERO) == 0) {
        List<FIN_Payment_Credit> creditPayments = payment.getFINPaymentCreditList();
        BigDecimal amtDiff = BigDecimal.ZERO;
        for (FIN_Payment_Credit creditPayment : creditPayments) {

          previousyear = false;
          // Verifica origen del credito usado
          PaymentPreviousYear = PaymentPreviousYearData.selectPreviousYear(connectionProvider,
              creditPayment.getId());
          String flatcredityear = (String) PaymentPreviousYear[0].previousyear;

          if (flatcredityear.equals("true")) {
            previousyear = true;
          } else {
            previousyear = false;
          }

          String creditAmountConverted = convertAmount(creditPayment.getAmount(),
              creditPayment.getCreditPaymentUsed().isReceipt(), DateAcct, TABLEID_Payment,
              creditPayment.getCreditPaymentUsed().getId(),
              creditPayment.getCreditPaymentUsed().getCurrency().getId(), as.m_C_Currency_ID, null,
              as, fact, Fact_Acct_Group_ID, nextSeqNo(SeqNo), conn, false).toString();
          fact.createLine(null,
              getAccountBPartnerPayment(C_BPartner_ID, as,
                  creditPayment.getCreditPaymentUsed().isReceipt(), true, conn, previousyear),
              creditPayment.getCreditPaymentUsed().getCurrency().getId(),
              (creditPayment.getCreditPaymentUsed().isReceipt() ? creditAmountConverted : ""),
              (creditPayment.getCreditPaymentUsed().isReceipt() ? "" : creditAmountConverted),
              Fact_Acct_Group_ID, nextSeqNo(SeqNo), DocumentType, conn);
          amtDiff = amtDiff.add(creditPayment.getAmount())
              .subtract(new BigDecimal(creditAmountConverted));
        }
        if (!payment.isReceipt() && amtDiff.compareTo(BigDecimal.ZERO) == 1
            || payment.isReceipt() && amtDiff.compareTo(BigDecimal.ZERO) == -1) {
          fact.createLine(null, getAccount(AcctServer.ACCTTYPE_ConvertGainDefaultAmt, as, conn),
              payment.getCurrency().getId(), "", amtDiff.abs().toString(), Fact_Acct_Group_ID,
              nextSeqNo(SeqNo), DocumentType, conn);
        } else {
          fact.createLine(null, getAccount(AcctServer.ACCTTYPE_ConvertChargeDefaultAmt, as, conn),
              payment.getCurrency().getId(), amtDiff.abs().toString(), "", Fact_Acct_Group_ID,
              nextSeqNo(SeqNo), DocumentType, conn);
        }
        if (creditPayments.isEmpty()) {
          fact.createLine(null,
              getAccountBPartnerPayment(C_BPartner_ID, as, payment.isReceipt(), true, conn,
                  previousyear),
              C_Currency_ID, (payment.isReceipt() ? usedAmount : ""),
              (payment.isReceipt() ? "" : usedAmount), Fact_Acct_Group_ID, nextSeqNo(SeqNo),
              DocumentType, conn);
        }
      }
    } finally {
      OBContext.restorePreviousMode();
    }

    SeqNo = "0";
    return fact;
  }

  public boolean isOrderPrepayment(String paymentDetailID) {
    FIN_PaymentDetail pd = OBDal.getInstance().get(FIN_PaymentDetail.class, paymentDetailID);
    if (pd != null) {
      return pd.isPrepayment();
    }
    return false;
  }

  public String nextSeqNo(String oldSeqNo) {
    BigDecimal seqNo = new BigDecimal(oldSeqNo);
    SeqNo = (seqNo.add(new BigDecimal("10"))).toString();
    return SeqNo;
  }

  /**
   * Get Source Currency Balance - subtracts line amounts from total - no rounding
   * 
   * @return positive amount, if total is bigger than lines
   */
  @Override
  public BigDecimal getBalance() {
    BigDecimal retValue = ZERO;
    StringBuffer sb = new StringBuffer(" [");
    // Total
    retValue = retValue.add(new BigDecimal(getAmount(AcctServer.AMTTYPE_Gross)));
    if ((new BigDecimal(generatedAmount)).signum() == 0) {
      retValue = retValue.add(new BigDecimal(usedAmount));
    }
    sb.append(getAmount(AcctServer.AMTTYPE_Gross));
    // - Lines
    for (int i = 0; i < p_lines.length; i++) {
      BigDecimal lineBalance = new BigDecimal(((DocLine_FINPayment) p_lines[i]).Amount);
      retValue = retValue.subtract(lineBalance);
      sb.append("-").append(lineBalance);
    }
    sb.append("]");
    //
    log4j.debug(" Balance=" + retValue + sb.toString());
    return retValue;
  } // getBalance

  @Override
  public boolean getDocumentConfirmation(ConnectionProvider conn, String strRecordId) {
    // Checks if this step is configured to generate accounting for the selected financial account
    boolean confirmation = false;
    final String PAYMENT_RECEIVED = "RPR";
    final String PAYMENT_MADE = "PPM";
    final String DEPOSITED_NOT_CLEARED = "RDNC";
    final String WITHDRAWN_NOT_CLEARED = "PWNC";
    final String PAYMENT_CLEARED = "RPPC";
    OBContext.setAdminMode();
    try {
      FIN_Payment payment = OBDal.getInstance().get(FIN_Payment.class, strRecordId);
      // Posting can just happen if payment is in the right status
      if (payment.getStatus().equals(PAYMENT_RECEIVED) || payment.getStatus().equals(PAYMENT_MADE)
          || payment.getStatus().equals(DEPOSITED_NOT_CLEARED)
          || payment.getStatus().equals(WITHDRAWN_NOT_CLEARED)
          || payment.getStatus().equals(PAYMENT_CLEARED)) {
        OBCriteria<FinAccPaymentMethod> obCriteria = OBDal.getInstance()
            .createCriteria(FinAccPaymentMethod.class);
        obCriteria.add(Restrictions.eq(FinAccPaymentMethod.PROPERTY_ACCOUNT, payment.getAccount()));
        obCriteria.add(Restrictions.eq(FinAccPaymentMethod.PROPERTY_PAYMENTMETHOD,
            payment.getPaymentMethod()));
        obCriteria.setFilterOnReadableClients(false);
        obCriteria.setFilterOnReadableOrganization(false);
        List<FinAccPaymentMethod> lines = obCriteria.list();
        List<FIN_FinancialAccountAccounting> accounts = payment.getAccount()
            .getFINFinancialAccountAcctList();
        for (FIN_FinancialAccountAccounting account : accounts) {
          if (confirmation)
            return confirmation;
          if (payment.isReceipt()) {
            if (("INT").equals(lines.get(0).getUponReceiptUse())
                && account.getInTransitPaymentAccountIN() != null)
              confirmation = true;
            else if (("DEP").equals(lines.get(0).getUponReceiptUse())
                && account.getDepositAccount() != null)
              confirmation = true;
            else if (("CLE").equals(lines.get(0).getUponReceiptUse())
                && account.getClearedPaymentAccount() != null)
              confirmation = true;
          } else {
            if (("INT").equals(lines.get(0).getUponPaymentUse())
                && account.getFINOutIntransitAcct() != null)
              confirmation = true;
            else if (("WIT").equals(lines.get(0).getUponPaymentUse())
                && account.getWithdrawalAccount() != null)
              confirmation = true;
            else if (("CLE").equals(lines.get(0).getUponPaymentUse())
                && account.getClearedPaymentAccountOUT() != null)
              confirmation = true;
          }
          // For payments with Amount ZERO always create an entry as no transaction will be created
          if (payment.getAmount().compareTo(ZERO) == 0) {
            confirmation = true;
          }
        }
      }
    } catch (Exception e) {
      setStatus(STATUS_DocumentDisabled);
      return confirmation;
    } finally {
      OBContext.restorePreviousMode();
    }
    if (!confirmation)
      setStatus(STATUS_DocumentDisabled);
    return confirmation;
  }

  @Override
  public void loadObjectFieldProvider(ConnectionProvider conn, String strAD_Client_ID, String Id)
      throws ServletException {
    FIN_Payment payment = OBDal.getInstance().get(FIN_Payment.class, Id);
    FieldProviderFactory[] data = new FieldProviderFactory[1];
    data[0] = new FieldProviderFactory(null);
    FieldProviderFactory.setField(data[0], "AD_Client_ID", payment.getClient().getId());
    FieldProviderFactory.setField(data[0], "AD_Org_ID", payment.getOrganization().getId());
    FieldProviderFactory.setField(data[0], "C_BPartner_ID",
        payment.getBusinessPartner() != null ? payment.getBusinessPartner().getId() : "");
    FieldProviderFactory.setField(data[0], "DocumentNo", payment.getDocumentNo());
    String dateFormat = OBPropertiesProvider.getInstance().getOpenbravoProperties()
        .getProperty("dateFormat.java");
    SimpleDateFormat outputFormat = new SimpleDateFormat(dateFormat);
    FieldProviderFactory.setField(data[0], "PaymentDate",
        outputFormat.format(payment.getPaymentDate()));
    FieldProviderFactory.setField(data[0], "C_DocType_ID", payment.getDocumentType().getId());
    FieldProviderFactory.setField(data[0], "C_Currency_ID", payment.getCurrency().getId());
    FieldProviderFactory.setField(data[0], "Amount", payment.getAmount().toString());
    FieldProviderFactory.setField(data[0], "GeneratedCredit",
        payment.getGeneratedCredit().toString());
    FieldProviderFactory.setField(data[0], "UsedCredit", payment.getUsedCredit().toString());
    FieldProviderFactory.setField(data[0], "WriteOffAmt", payment.getWriteoffAmount().toString());
    FieldProviderFactory.setField(data[0], "Description", payment.getDescription());
    FieldProviderFactory.setField(data[0], "Posted", payment.getPosted());
    FieldProviderFactory.setField(data[0], "Processed", payment.isProcessed() ? "Y" : "N");
    FieldProviderFactory.setField(data[0], "Processing", payment.isProcessNow() ? "Y" : "N");
    FieldProviderFactory.setField(data[0], "C_Project_ID",
        payment.getProject() != null ? payment.getProject().getId() : "");
    FieldProviderFactory.setField(data[0], "C_Campaign_ID",
        payment.getSalesCampaign() != null ? payment.getSalesCampaign().getId() : "");
    FieldProviderFactory.setField(data[0], "C_Activity_ID",
        payment.getActivity() != null ? payment.getActivity().getId() : "");
    // User1_ID and User2_ID
    DocFINPaymentData[] paymentInfo = DocFINPaymentData.select(conn, payment.getId());
    if (paymentInfo.length > 0) {
      FieldProviderFactory.setField(data[0], "User1_ID", paymentInfo[0].user1Id);
      FieldProviderFactory.setField(data[0], "User2_ID", paymentInfo[0].user2Id);
      FieldProviderFactory.setField(data[0], "C_Costcenter_ID", paymentInfo[0].cCostcenterId);
    }
    // Used to match balances
    FieldProviderFactory.setField(data[0], "recordId2", payment.getId());
    setObjectFieldProvider(data);
  }

  /*
   * Retrieves Account for receipt / Payment for the given payment method + Financial Account
   */
  public Account getAccount(ConnectionProvider conn, FIN_PaymentMethod paymentMethod,
      FIN_FinancialAccount finAccount, AcctSchema as, boolean bIsReceipt) throws ServletException {
    OBContext.setAdminMode();
    Account account = null;
    try {
      OBCriteria<FIN_FinancialAccountAccounting> accounts = OBDal.getInstance()
          .createCriteria(FIN_FinancialAccountAccounting.class);
      accounts.add(Restrictions.eq(FIN_FinancialAccountAccounting.PROPERTY_ACCOUNT, finAccount));
      accounts.add(Restrictions.eq(FIN_FinancialAccountAccounting.PROPERTY_ACCOUNTINGSCHEMA,
          OBDal.getInstance().get(org.openbravo.model.financialmgmt.accounting.coa.AcctSchema.class,
              as.m_C_AcctSchema_ID)));
      accounts.add(Restrictions.eq(FIN_FinancialAccountAccounting.PROPERTY_ACTIVE, true));
      accounts.setFilterOnReadableClients(false);
      accounts.setFilterOnReadableOrganization(false);
      List<FIN_FinancialAccountAccounting> accountList = accounts.list();
      if (accountList == null || accountList.size() == 0)
        return null;
      OBCriteria<FinAccPaymentMethod> accPaymentMethod = OBDal.getInstance()
          .createCriteria(FinAccPaymentMethod.class);
      accPaymentMethod.add(Restrictions.eq(FinAccPaymentMethod.PROPERTY_ACCOUNT, finAccount));
      accPaymentMethod
          .add(Restrictions.eq(FinAccPaymentMethod.PROPERTY_PAYMENTMETHOD, paymentMethod));
      accPaymentMethod.setFilterOnReadableClients(false);
      accPaymentMethod.setFilterOnReadableOrganization(false);
      List<FinAccPaymentMethod> lines = accPaymentMethod.list();
      if (bIsReceipt) {
        account = getAccount(conn, lines.get(0).getUponReceiptUse(), accountList.get(0),
            bIsReceipt);
      } else {
        account = getAccount(conn, lines.get(0).getUponPaymentUse(), accountList.get(0),
            bIsReceipt);
      }
    } finally {
      OBContext.restorePreviousMode();
    }
    return account;
  }

  @Deprecated
  public String convertAmount(String Amount, boolean isReceipt, String mDateAcct,
      String conversionDate, String C_Currency_ID_From, String C_Currency_ID_To, DocLine line,
      AcctSchema as, Fact fact, String Fact_Acct_Group_ID, ConnectionProvider conn)
      throws ServletException {
    if (Amount == null || Amount.equals(""))
      return "0";
    if (C_Currency_ID_From.equals(C_Currency_ID_To))
      return Amount;
    else
      MultiCurrency = true;
    String Amt = getConvertedAmt(Amount, C_Currency_ID_From, C_Currency_ID_To, conversionDate, "",
        AD_Client_ID, AD_Org_ID, conn);
    if (log4j.isDebugEnabled())
      log4j.debug("Amt:" + Amt);

    String AmtTo = getConvertedAmt(Amount, C_Currency_ID_From, C_Currency_ID_To, mDateAcct, "",
        AD_Client_ID, AD_Org_ID, conn);
    if (log4j.isDebugEnabled())
      log4j.debug("AmtTo:" + AmtTo);

    BigDecimal AmtDiff = (new BigDecimal(AmtTo)).subtract(new BigDecimal(Amt));
    if (log4j.isDebugEnabled())
      log4j.debug("AmtDiff:" + AmtDiff);

    if (log4j.isDebugEnabled()) {
      log4j.debug("curr from:" + C_Currency_ID_From + " Curr to:" + C_Currency_ID_To + " convDate:"
          + conversionDate + " DateAcct:" + mDateAcct);
      log4j.debug("Amt:" + Amt + " AmtTo:" + AmtTo + " Diff:" + AmtDiff.toString());
    }

    if ((isReceipt && AmtDiff.compareTo(new BigDecimal("0.00")) == 1)
        || (!isReceipt && AmtDiff.compareTo(new BigDecimal("0.00")) == -1)) {
      fact.createLine(line, getAccount(AcctServer.ACCTTYPE_ConvertGainDefaultAmt, as, conn),
          C_Currency_ID_To, "", AmtDiff.abs().toString(), Fact_Acct_Group_ID, nextSeqNo(SeqNo),
          DocumentType, conn);
    } else {
      fact.createLine(line, getAccount(AcctServer.ACCTTYPE_ConvertChargeDefaultAmt, as, conn),
          C_Currency_ID_To, AmtDiff.abs().toString(), "", Fact_Acct_Group_ID, nextSeqNo(SeqNo),
          DocumentType, conn);
    }

    return Amt;
  }

  public String getSeqNo() {
    return SeqNo;
  }

  public void setSeqNo(String seqNo) {
    SeqNo = seqNo;
  }

  public String getGeneratedAmount() {
    return generatedAmount;
  }

  public void setGeneratedAmount(String generatedAmount) {
    this.generatedAmount = generatedAmount;
  }

  public String getUsedAmount() {
    return usedAmount;
  }

  public void setUsedAmount(String usedAmount) {
    this.usedAmount = usedAmount;
  }

  boolean isPaymentDatePriorToInvoiceDate(FIN_PaymentDetail paymentDetail) {
    List<FIN_PaymentScheduleDetail> schedDetails = paymentDetail.getFINPaymentScheduleDetailList();
    if (schedDetails.size() == 0) {
      return false;
    } else {
      if (schedDetails.get(0).getInvoicePaymentSchedule() != null
          && schedDetails.get(0).getInvoicePaymentSchedule().getInvoice().getAccountingDate()
              .after(paymentDetail.getFinPayment().getPaymentDate())) {
        return true;
      } else {
        return false;
      }
    }
  }

  public final Account getAccountBPartnerPayment(String cBPartnerId, AcctSchema as,
      boolean isReceipt, boolean isPrepayment, ConnectionProvider conn, boolean previousyear)
      throws ServletException {
    return getAccountBPartnerPayment(cBPartnerId, as, isReceipt, isPrepayment, false, conn,
        previousyear);
  }

  /**
   * Get the account for Accounting Schema
   * 
   * @param cBPartnerId
   *          business partner id
   * @param as
   *          accounting schema
   * @return Account
   */
  public final Account getAccountBPartnerPayment(String cBPartnerId, AcctSchema as,
      boolean isReceipt, boolean isPrepayment, boolean isDoubtfuldebt, ConnectionProvider conn,
      boolean previousyear) throws ServletException {

    String strValidCombination = "";
    OBContext.setAdminMode();
    try {
      if (isReceipt) {
        final StringBuilder whereClause = new StringBuilder();
        if (isDoubtfuldebt) {
          BusinessPartner bp = OBDal.getInstance().get(BusinessPartner.class, cBPartnerId);
          whereClause.append(" as cuscata ");
          whereClause.append(" where cuscata.businessPartnerCategory.id = :bpCategoryID");
          whereClause.append(" and cuscata.accountingSchema.id = :acctSchemaID");

          final OBQuery<CategoryAccounts> obqParameters = OBDal.getInstance()
              .createQuery(CategoryAccounts.class, whereClause.toString());
          obqParameters.setFilterOnReadableClients(false);
          obqParameters.setFilterOnReadableOrganization(false);
          obqParameters.setNamedParameter("bpCategoryID", bp.getBusinessPartnerCategory().getId());
          obqParameters.setNamedParameter("acctSchemaID", as.m_C_AcctSchema_ID);
          final List<CategoryAccounts> customerAccounts = obqParameters.list();
          if (customerAccounts != null && customerAccounts.size() > 0
              && customerAccounts.get(0).getDoubtfulDebtAccount() != null) {
            // validacion ventas años anteriores
            if (previousyear) {
              strValidCombination = customerAccounts.get(0).getSspyReceiptPrvyearAcct().getId();
            } else {
              strValidCombination = customerAccounts.get(0).getDoubtfulDebtAccount().getId();
            }
          }
          if (strValidCombination.equals("")) {
            Map<String, String> parameters = new HashMap<String, String>();
            parameters.put("Account", "@DoubtfulDebt@");
            parameters.put("Entity", bp.getBusinessPartnerCategory().getIdentifier());
            parameters.put("AccountingSchema",
                OBDal.getInstance()
                    .get(org.openbravo.model.financialmgmt.accounting.coa.AcctSchema.class,
                        as.getC_AcctSchema_ID())
                    .getIdentifier());
            setMessageResult(conn, STATUS_InvalidAccount, "error", parameters);
            throw new IllegalStateException();
          }
          return new Account(conn, strValidCombination);
        }

        whereClause.append(" as cusa ");
        whereClause.append(" where cusa.businessPartner.id = '" + cBPartnerId + "'");
        whereClause.append(" and cusa.accountingSchema.id = '" + as.m_C_AcctSchema_ID + "'");
        whereClause.append(" and (cusa.status is null or cusa.status = 'DE')");

        final OBQuery<CustomerAccounts> obqParameters = OBDal.getInstance()
            .createQuery(CustomerAccounts.class, whereClause.toString());
        obqParameters.setFilterOnReadableClients(false);
        obqParameters.setFilterOnReadableOrganization(false);
        final List<CustomerAccounts> customerAccounts = obqParameters.list();
        if (customerAccounts != null && customerAccounts.size() > 0
            && customerAccounts.get(0).getCustomerReceivablesNo() != null && !isPrepayment) {
          // Validacion ventas años anteriores
          if (previousyear) {
            strValidCombination = customerAccounts.get(0).getSspyReceiptPrvyearAcct().getId();
          } else {

            if (invoice != null
                && invoice.getDocumentType().getDocumentCategory()
                    .equals(AcctServer.DOCTYPE_ARCredit)
                && customerAccounts.get(0).getScnacNcproveedor() != null) {
              strValidCombination = customerAccounts.get(0).getScnacNcproveedor().getId();
            } else {
              strValidCombination = customerAccounts.get(0).getCustomerReceivablesNo().getId();
            }
          }
        }
        if (customerAccounts != null && customerAccounts.size() > 0
            && customerAccounts.get(0).getCustomerPrepayment() != null && isPrepayment) {
          // Validacion ventas años anteriores
          if (previousyear) {
            strValidCombination = customerAccounts.get(0).getSspyPrepaidPrvyearAcct().getId();
          } else {
            strValidCombination = customerAccounts.get(0).getCustomerPrepayment().getId();
          }
        }
      } else {
        final StringBuilder whereClause = new StringBuilder();

        whereClause.append(" as vena ");
        whereClause.append(" where vena.businessPartner.id = '" + cBPartnerId + "'");
        whereClause.append(" and vena.accountingSchema.id = '" + as.m_C_AcctSchema_ID + "'");
        whereClause.append(" and (vena.status is null or vena.status = 'DE')");
        whereClause.append(" and vena.spaaDefault = 'Y' ");

        final OBQuery<VendorAccounts> obqParameters = OBDal.getInstance()
            .createQuery(VendorAccounts.class, whereClause.toString());
        obqParameters.setFilterOnReadableClients(false);
        obqParameters.setFilterOnReadableOrganization(false);
        final List<VendorAccounts> vendorAccounts = obqParameters.list();
        if (vendorAccounts != null && vendorAccounts.size() > 0
            && vendorAccounts.get(0).getVendorLiability() != null && !isPrepayment) {
          // Validacion compras años anteiores
          if (previousyear) {
            strValidCombination = vendorAccounts.get(0).getSspyAcctpayPrvyearAcct().getId();
          } else {
            strValidCombination = vendorAccounts.get(0).getVendorLiability().getId();
          }
        }
        if (vendorAccounts != null && vendorAccounts.size() > 0
            && vendorAccounts.get(0).getVendorPrepayment() != null && isPrepayment) {
          // Validacion compras años anteriores
          if (previousyear) {
            strValidCombination = vendorAccounts.get(0).getSspyPrepaymtPrvyearAcct().getId();
          } else {
            strValidCombination = vendorAccounts.get(0).getVendorPrepayment().getId();
          }
        }
      }
      if (strValidCombination.equals("")) {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("Account",
            isReceipt ? (isPrepayment ? "@CustomerPrepayment@" : "@CustomerReceivables@")
                : (isPrepayment ? "@VendorPrepayment@" : "@VendorLiability@"));
        BusinessPartner bp = OBDal.getInstance().get(BusinessPartner.class, cBPartnerId);
        if (bp != null) {
          parameters.put("Entity", bp.getIdentifier());
        }
        parameters.put("AccountingSchema",
            OBDal.getInstance()
                .get(org.openbravo.model.financialmgmt.accounting.coa.AcctSchema.class,
                    as.getC_AcctSchema_ID())
                .getIdentifier());
        setMessageResult(conn, STATUS_InvalidAccount, "error", parameters);
        throw new IllegalStateException();
      }
    } finally {
      OBContext.restorePreviousMode();
    }
    return new Account(conn, strValidCombination);
  } // getAccount

  private void posForInvoiceLine(DocLine_FINPayment lineFINPaymen, Invoice invoice, AcctSchema as,
      ConnectionProvider conn, Fact fact, String Fact_Acct_Group_ID, BigDecimal credPaymentAmount,
      boolean isPrepayment, boolean previousyear, String strcCurrencyId) throws ServletException {
    List<InvoiceLine> invoiceLine = invoice.getInvoiceLineList();
    String bpartnerId = invoice.getBusinessPartner().getId();
    // invoice total paid amount
    BigDecimal paidAmnt = new BigDecimal(
        DocPaidInvoiceData.selectPaidAmt(conn, invoice.getId())[0].totalamt);
    // BigDecimal paidAmnt = BigDecimal.ZERO;
    BigDecimal curCredPaymentAmount = (credPaymentAmount.compareTo(BigDecimal.ZERO) < 0)
        ? credPaymentAmount.negate()
        : credPaymentAmount;

    for (int i = 0; i < invoiceLine.size(); i++) {
      InvoiceLine line = invoiceLine.get(i);
      BigDecimal totalamtForLine = getAmounConverted(conn, line);
      Account account = null;

      // currency for line
      totalamtForLine = getPaymentForLine(invoice, as, conn, totalamtForLine);

      if (paidAmnt.compareTo(BigDecimal.ZERO) > 0) {
        if (paidAmnt.compareTo(totalamtForLine) > 0) {
          paidAmnt = paidAmnt.subtract(totalamtForLine);
          totalamtForLine = BigDecimal.ZERO;
        } else if (paidAmnt.compareTo(totalamtForLine) == 0) {
          paidAmnt = BigDecimal.ZERO;
          totalamtForLine = BigDecimal.ZERO;
        } else {
          totalamtForLine = totalamtForLine.subtract(paidAmnt);
          paidAmnt = BigDecimal.ZERO;
        }
      }
      if (paidAmnt.compareTo(BigDecimal.ZERO) == 0
          & totalamtForLine.compareTo(BigDecimal.ZERO) > 0) {
        if (line.getSfbBudgetCertLine() != null) {
          account = getAccountBPartner(bpartnerId, as, isPrepayment, line.getId(), conn,
              previousyear);
        } else {
          account = getAccountBPartnerPayment(bpartnerId, as, false, isPrepayment, conn,
              previousyear);
        }

        if (curCredPaymentAmount.compareTo(totalamtForLine) < 0) {
          fact.createLine(lineFINPaymen, account, strcCurrencyId,

              (credPaymentAmount.compareTo(BigDecimal.ZERO) > 0)
                  ? ((curCredPaymentAmount.compareTo(BigDecimal.ZERO) < 0)
                      ? curCredPaymentAmount.negate().toString()
                      : curCredPaymentAmount.toString())
                  : "",
              (credPaymentAmount.compareTo(BigDecimal.ZERO) < 0)
                  ? ((curCredPaymentAmount.compareTo(BigDecimal.ZERO) < 0)
                      ? curCredPaymentAmount.negate().toString()
                      : curCredPaymentAmount.toString())
                  : "",
              Fact_Acct_Group_ID, nextSeqNo(SeqNo), DocumentType, conn);
          break;
        }

        fact.createLine(lineFINPaymen, account, strcCurrencyId,
            (credPaymentAmount.compareTo(BigDecimal.ZERO) > 0)
                ? ((totalamtForLine.compareTo(BigDecimal.ZERO) < 0)
                    ? totalamtForLine.negate().toString()
                    : totalamtForLine.toString())
                : "",
            (credPaymentAmount.compareTo(BigDecimal.ZERO) < 0)
                ? ((totalamtForLine.compareTo(BigDecimal.ZERO) < 0)
                    ? totalamtForLine.negate().toString()
                    : totalamtForLine.toString())
                : "",
            Fact_Acct_Group_ID, nextSeqNo(SeqNo), DocumentType, conn);

        curCredPaymentAmount = curCredPaymentAmount.subtract(totalamtForLine);
      }

    }
  }

  private BigDecimal getPaymentForLine(Invoice invoice, AcctSchema as, ConnectionProvider conn,
      BigDecimal totalamtForLine) {
    ConversionRateDoc conversionRateCurrentDoc = getConversionRateDoc(AcctServer.TABLEID_Invoice,
        invoice.getId(), invoice.getCurrency().getId(), as.m_C_Currency_ID);

    BigDecimal totalamtForLineConversion = BigDecimal.ZERO;
    if (conversionRateCurrentDoc != null) {
      totalamtForLineConversion = AcctServer
          .applyRate(totalamtForLine, conversionRateCurrentDoc, true)
          .setScale(2, BigDecimal.ROUND_HALF_UP);
    } else {
      totalamtForLineConversion = new BigDecimal(AcctServer.getConvertedAmt(
          totalamtForLine.toString(), invoice.getCurrency().getId(), as.m_C_Currency_ID, DateAcct,
          "", invoice.getClient().getId(), invoice.getOrganization().getId(), conn));
    }
    return totalamtForLineConversion;
  }

  private void posForInvoiceLinePrepaymentAgainstInvoice(DocLine lineFINPaymen, Invoice invoice,
      AcctSchema as, ConnectionProvider conn, Fact fact, String Fact_Acct_Group_ID,
      BigDecimal credPaymentAmount, boolean previousyear, String strcCurrencyId)
      throws ServletException {
    List<InvoiceLine> invoiceLine = invoice.getInvoiceLineList();
    String bpartnerId = invoice.getBusinessPartner().getId();

    BigDecimal curCredPaymentAmount = credPaymentAmount;

    for (int i = 0; i < invoiceLine.size(); i++) {
      InvoiceLine line = invoiceLine.get(i);

      BigDecimal totalamtForLine = getAmounConverted(conn, line);

      Account account = null;
      Account account2 = null;
      if (line.getSfbBudgetCertLine() != null) {
        account = getAccountBPartner(bpartnerId, as, true, line.getId(), conn, previousyear);
        account2 = getAccountBPartner(bpartnerId, as, false, line.getId(), conn, previousyear);

      } else {
        account = getAccountBPartnerPayment(bpartnerId, as, false, true, conn, previousyear);
        account2 = getAccountBPartnerPayment(bpartnerId, as, false, false, conn, previousyear);
      }

      totalamtForLine = getPaymentForLine(invoice, as, conn, totalamtForLine);

      if (!account.Account_ID.equals(account2.Account_ID)) {
        fact.createLine(lineFINPaymen, account, strcCurrencyId, totalamtForLine.toString(), "",
            Fact_Acct_Group_ID, nextSeqNo(SeqNo), DocumentType, conn);
        fact.createLine(lineFINPaymen, account2, strcCurrencyId, totalamtForLine.toString(), "",
            Fact_Acct_Group_ID, nextSeqNo(SeqNo), DocumentType, conn);
      }

      curCredPaymentAmount = curCredPaymentAmount.subtract(totalamtForLine);

    }
  }

  private BigDecimal getAmounConverted(ConnectionProvider conn, InvoiceLine line)
      throws ServletException {
    BigDecimal amountConverted = getAmount(line.getLineNetAmount().toString(),
        line.getListPrice().toString(), line.getInvoicedQuantity().toString());

    BigDecimal ilTaxamt = new BigDecimal(
        DocLineInvoiceData.selectTaxTotalForInvoiceLine(conn, line.getId())[0].ilTaxamt);

    BigDecimal totalamtForLine = ilTaxamt.add(amountConverted);
    if (line.getSswhInvoicetaxIncome() != null) {
      totalamtForLine = totalamtForLine.add(line.getSswhInvoicetaxIncome().getTaxAmount());
    }
    if (line.getSswhInvoicetaxVat() != null) {
      totalamtForLine = totalamtForLine.add(line.getSswhInvoicetaxVat().getTaxAmount());
    }
    return totalamtForLine;
  }

  public BigDecimal getAmount(String LineNetAmt, String PriceList, String Qty) {
    String m_LineNetAmt = (LineNetAmt == "0") ? ZERO.toString() : LineNetAmt;
    BigDecimal b_Qty = new BigDecimal(Qty);
    BigDecimal b_PriceList = new BigDecimal(PriceList);
    String m_ListAmt = ZERO.toString();
    if (!PriceList.equals("") && !Qty.equals(""))
      m_ListAmt = b_PriceList.multiply(b_Qty).toString();
    if (m_ListAmt.equals(ZERO.toString()))
      m_ListAmt = m_LineNetAmt;
    return new BigDecimal(m_ListAmt);
  }

  public final Account getAccountBPartner(String cBPartnerId, AcctSchema as, boolean isPrepayment,
      String invoiceLineId, ConnectionProvider conn, boolean previousyear) throws ServletException {

    String strValidCombination = "";

    InvoiceLine invoiceLine = OBDal.getInstance().get(InvoiceLine.class, invoiceLineId);

    StringBuilder hql = new StringBuilder();
    hql.append(" from VendorAccounts as va ");
    hql.append(
        " where va.businessPartner.id = :businessPartnerId and va.accountingSchema.id = :accountingSchemaId ");

    if (invoiceLine.getSfbBudgetCertLine() != null) {
      hql.append(
          " and va.spaaBudgetItem.id in ( select bc.budgetItem.id from InvoiceLine as il inner join il.sfbBudgetCertLine  bc ");
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

    if (vendorAccounts != null && !isPrepayment && vendorAccounts.getVendorLiability() != null) {
      if (!previousyear) {
        if (invoice.getDocumentType().getDocumentCategory().equals(AcctServer.DOCTYPE_APCredit)
            && vendorAccounts.getSpaaNcproveedor() != null) {
          strValidCombination = vendorAccounts.getSpaaNcproveedor().getId();
        } else {
          strValidCombination = vendorAccounts.getVendorLiability().getId();
        }
      } else {
        strValidCombination = vendorAccounts.getSspyAcctpayPrvyearAcct().getId();
      }
    }

    if (vendorAccounts != null && isPrepayment && vendorAccounts.getVendorPrepayment() != null) {
      if (previousyear) {
        strValidCombination = vendorAccounts.getSspyPrepaymtPrvyearAcct().getId();
      } else {
        strValidCombination = vendorAccounts.getVendorPrepayment().getId();
      }
    }

    if (strValidCombination.equals("")) {
      Map<String, String> parameters = new HashMap<String, String>();
      parameters.put("Account", (isPrepayment ? "@VendorPrepayment@" : "@VendorLiability@"));
      BusinessPartner bp = OBDal.getInstance().get(BusinessPartner.class, cBPartnerId);
      if (bp != null) {
        parameters.put("Entity", bp.getIdentifier());
      }
      parameters.put("AccountingSchema",
          OBDal.getInstance().get(org.openbravo.model.financialmgmt.accounting.coa.AcctSchema.class,
              as.getC_AcctSchema_ID()).getIdentifier());
      setMessageResult(conn, STATUS_InvalidAccount, "error", parameters);
      throw new IllegalStateException();
    }

    return new Account(conn, strValidCombination);
  }

}
