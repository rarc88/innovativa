package ec.com.sidesoft.quick.billing.ad_process;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.criterion.Restrictions;
import org.openbravo.advpaymentmngt.APRM_FinaccTransactionV;
import org.openbravo.advpaymentmngt.dao.AdvPaymentMngtDao;
import org.openbravo.advpaymentmngt.dao.TransactionsDao;
import org.openbravo.advpaymentmngt.process.FIN_AddPayment;
import org.openbravo.advpaymentmngt.process.FIN_TransactionProcess;
import org.openbravo.advpaymentmngt.utility.FIN_Utility;
import org.openbravo.base.ConfigParameters;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.client.kernel.RequestContext;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.security.OrganizationStructureProvider;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.data.UtilSql;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBDateUtils;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.utility.Sequence;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.businesspartner.Location;
import org.openbravo.model.common.currency.ConversionRateDoc;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.common.invoice.InvoiceLine;
import org.openbravo.model.common.uom.UOM;
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.accounting.FIN_FinancialAccountAccounting;
import org.openbravo.model.financialmgmt.accounting.UserDimension1;
import org.openbravo.model.financialmgmt.accounting.UserDimension2;
import org.openbravo.model.financialmgmt.payment.FIN_BankStatementLine;
import org.openbravo.model.financialmgmt.payment.FIN_FinaccTransaction;
import org.openbravo.model.financialmgmt.payment.FIN_FinancialAccount;
import org.openbravo.model.financialmgmt.payment.FIN_Payment;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentDetail;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentMethod;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentSchedule;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentScheduleDetail;
import org.openbravo.model.financialmgmt.payment.FIN_Reconciliation;
import org.openbravo.model.financialmgmt.payment.FinAccPaymentMethod;
import org.openbravo.model.financialmgmt.payment.PaymentTerm;
import org.openbravo.model.financialmgmt.tax.TaxRate;
import org.openbravo.model.pricing.pricelist.PriceList;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.DalBaseProcess;
import org.openbravo.service.db.DalConnectionProvider;
import org.quartz.SchedulerContext;

import ec.com.sidesoft.quick.billing.SqbConfigQuickBilling;
import ec.com.sidesoft.quick.billing.SqbConfigUser;
import ec.com.sidesoft.quick.billing.SqbQuickBilling;
import ec.com.sidesoft.quick.billing.SqbQuickBillingLine;

public class Sqb_CreateQuickBilling extends DalBaseProcess {
  OBError message;
  static Logger log4j = Logger.getLogger(Sqb_CreateQuickBilling.class);
  public static String dateTimeFormat;
  public static String sqlDateTimeFormat;
  private SchedulerContext ctx;
  public TaxRate taxRate;
  public String strNewInvoiceID;
  public String strAttachment;
  public String strFTP;
  public Connection connectionDB = null;
  public String strSearchInvoice;
  public ConfigParameters cf;
  public String successMessage = null;
  public String strFinancialAccountID = null;
  public String strDocumentnoPaymentIn;
  public String DocumentTypePaymentInId;
  public static final String TRXTYPE_BPDeposit = "BPD";
  public static final String TRXTYPE_BPWithdrawal = "BPW";
  public static final String TRXTYPE_BankFee = "BF";
  public String strFinPaymentScheduleDetailID = "";
  ConnectionProvider cnn_insert;
  ConnectionProvider cnn_insert2;
  Costcenter costCenter = null;
  UserDimension1 user1 = null;
  UserDimension2 user2 = null;
  
  // private AdvPaymentMngtDao dao;

  @Override
  protected void doExecute(ProcessBundle bundle) throws Exception {
    String language = OBContext.getOBContext().getLanguage().getLanguage();
    ConnectionProvider conn = new DalConnectionProvider(false);

    try {
      message = new OBError();
      processRequest(bundle);
    } catch (Exception e) {
      message.setTitle(Utility.messageBD(conn, "Error", language));
      message.setType("Error");
      message.setMessage(e.getMessage());
    } finally {
      bundle.setResult(message);
      conn.destroy();
    }
    // Y process, N unprocess Status
  }

  private void processRequest(ProcessBundle bundle) {
    try {
      String strQuicBillingID = (String) bundle.getParams().get("SQB_Quickbilling_ID");

      String language = OBContext.getOBContext().getLanguage().getLanguage();
      ConnectionProvider conn = new DalConnectionProvider(false);
      cnn_insert = bundle.getConnection();
      cnn_insert2 = bundle.getConnection();

      try {
        strSearchInvoice = getSearchInvoice(conn, strQuicBillingID) == null ? ""
            : getSearchInvoice(conn, strQuicBillingID);
      } catch (ServletException e1) {
        e1.printStackTrace();
      }
      if (strSearchInvoice.equals("OK")) {
        throw new OBException(Utility.messageBD(conn, "Sqb_ErrorCreateInvoice", language));
      }

      try {
        connectionDB = conn.getTransactionConnection();
      } catch (Exception e) {

      }

      // Recuperar Formato de Fecha SQL
      cf = ConfigParameters.retrieveFrom(RequestContext.get().getRequest().getSession()
          .getServletContext());
      dateTimeFormat = cf.getJavaDateTimeFormat();
      VariablesSecureApp vars = bundle.getContext().toVars();

      // store in session all the formats

      // String strNumberName = "generalQtyEdition";
      // vars.setSessionValue("#FormatOutput|" + strNumberName, "###,##0.00");
      // vars.setSessionValue("#DecimalSeparator|" + strNumberName, ".");
      // vars.setSessionValue("#GroupSeparator|" + strNumberName, ",");

      String strAdUserID = vars.getUser() == null ? "ND" : vars.getUser();

      // Obtener usuario logeado
      User userQB = OBDal.getInstance().get(User.class, strAdUserID);

      // Obtner Configuración para Crear la Factura
      OBCriteria<SqbConfigUser> sqbConfigUser = OBDal.getInstance().createCriteria(
          SqbConfigUser.class);
      sqbConfigUser.add(Restrictions.eq(SqbConfigUser.PROPERTY_ACTIVE, true));
      sqbConfigUser.add(Restrictions.eq(SqbConfigUser.PROPERTY_USER, userQB));

      List<SqbConfigUser> sqbConfigUserList = sqbConfigUser.list();

      if (sqbConfigUserList.size() > 0) {

        SqbConfigQuickBilling sqbConfigProductList = OBDal.getInstance().get(
            SqbConfigQuickBilling.class,
            sqbConfigUserList.get(0).getSQBConfigQuickbilling().getId());

        // ID Facturación Rápida

        SqbQuickBilling sqbQuickBilling = OBDal.getInstance().get(SqbQuickBilling.class,
            strQuicBillingID);
        
        // VALIDACION DEL MONTO DE LA FACTURA PARA EL TERCERO
        // VALIDACION PARA LA ORGANIZACION Y EL TERCERO
        OBCriteria<SqbConfigQuickBilling> sqbConfigProductListValidate = OBDal.getInstance().createCriteria(
            SqbConfigQuickBilling.class);
        sqbConfigProductListValidate.add(Restrictions.eq(SqbConfigQuickBilling.PROPERTY_ACTIVE, true));
        sqbConfigProductListValidate.add(Restrictions.eq(SqbConfigQuickBilling.PROPERTY_BPARTNER, sqbQuickBilling.getBpartner() ));
        sqbConfigProductListValidate.add(Restrictions.eq(SqbConfigQuickBilling.PROPERTY_ORGANIZATION, sqbQuickBilling.getOrganization() ));
        
        List<SqbConfigQuickBilling> sqbConfigProductListValidateList = sqbConfigProductListValidate.list();
        
        if (sqbConfigProductListValidateList.size() > 0) {
          
          if( sqbQuickBilling.getTotal().compareTo(sqbConfigProductListValidateList.get(0).getMAXBillingValue()) > 0 ) {
              message.setType("Error");
              message.setTitle(Utility.messageBD(cnn_insert, "Error", language));
              Map<String, String> parameters = new HashMap<String, String>();
              parameters.put("tercero", sqbQuickBilling.getBpartner().getName());
              parameters.put("maximo", sqbConfigProductListValidateList.get(0).getMAXBillingValue().setScale(2, BigDecimal.ROUND_HALF_UP).toString());
              message.setMessage(Utility.parseTranslation(cnn_insert, vars, parameters, language,
                  OBMessageUtils.messageBD("Sqb_ErrorTotalBiggerMax")));
              bundle.setResult(message);
              return;
          }
          
        }
        // VALIDACION DEL MONTO DE LA FACTURA PARA EL TERCERO        

        // Lista de Precios
        String strPriceListID = sqbConfigProductList.getPricelist().getId() == null ? "ND"
            : sqbConfigProductList.getPricelist().getId();

        PriceList priceList = OBDal.getInstance().get(PriceList.class, strPriceListID);

        // Tercero
        BusinessPartner bpartner = OBDal.getInstance().get(BusinessPartner.class,
            sqbQuickBilling.getBpartner().getId());

        // Dirección Tercero
        OBCriteria<Location> sqbBPartnerLocation = OBDal.getInstance().createCriteria(
            Location.class);
        sqbBPartnerLocation.add(Restrictions.eq(Location.PROPERTY_BUSINESSPARTNER, bpartner));
        List<Location> sqbBPartnerLocationList = sqbBPartnerLocation.list();

        Location bPartnerLocation = OBDal.getInstance().get(Location.class,
            sqbBPartnerLocationList.get(0).getId());

        // Tipo de Documento
        String strDocumentTypeID = sqbConfigProductList.getDoctype().getId() == null ? "ND"
            : sqbConfigProductList.getDoctype().getId();

        DocumentType docType = OBDal.getInstance().get(DocumentType.class, strDocumentTypeID);
        Sequence sequence = docType.getDocumentSequence();
        String strDocumentno = (sequence.getPrefix() == null ? "" : sequence.getPrefix().toString())
            + (sequence.getSuffix() == null ? "" : sequence.getSuffix().toString())
            + (sequence.getNextAssignedNumber() == null ? "" : sequence.getNextAssignedNumber()
                .toString());
        sequence
            .setNextAssignedNumber(sequence.getNextAssignedNumber() + sequence.getIncrementBy());

        // Moneda
        String strCurrencyID = sqbConfigProductList.getCurrency().getId() == null ? "ND"
            : sqbConfigProductList.getCurrency().getId();

        Currency currency = OBDal.getInstance().get(Currency.class, strCurrencyID);

        // Método de Pago

        String strfinPaymentID = "ND";
        if (!sqbConfigProductList.isPaymentmethodEnable()){
        	strfinPaymentID = sqbConfigProductList.getFINPaymentmethod().getId() == null ? "ND"
                    : sqbConfigProductList.getFINPaymentmethod().getId();
        }else{
        	strfinPaymentID = sqbQuickBilling.getFINPaymentmethod()== null ? "ND"
        			: sqbQuickBilling.getFINPaymentmethod().getId();
        }
        
        if (strfinPaymentID==null || strfinPaymentID.equals("ND")) {
            throw new OBException(Utility.messageBD(conn, "Método de pago no seleccionado. ", language));
        }

        FIN_PaymentMethod finPaymentMethod = OBDal.getInstance().get(FIN_PaymentMethod.class,
            strfinPaymentID);

        // Términos de Pago

        String strCPaymentTermtID = sqbConfigProductList.getPaymentterm().getId() == null ? "ND"
            : sqbConfigProductList.getPaymentterm().getId();

        // Revisa y realizá el cobro si esta marcado el check cobro automático
        if (sqbConfigProductList.isAutomaticPayment()) {
          strFinancialAccountID = sqbConfigProductList.getFINFinancialAccount().getId() == null ? "ND"
              : sqbConfigProductList.getFINFinancialAccount().getId();

          DocumentTypePaymentInId = sqbConfigProductList.getDoctypePaymentIn().getId() == null
              ? "ND"
              : sqbConfigProductList.getDoctypePaymentIn().getId();

          if (!DocumentTypePaymentInId.equals("ND")) {

            DocumentType docTypePaymentIn = OBDal.getInstance().get(DocumentType.class,
                DocumentTypePaymentInId);
            Sequence sequencePaymentIn = docTypePaymentIn.getDocumentSequence();
            strDocumentnoPaymentIn = (sequencePaymentIn.getPrefix() == null ? ""
                : sequencePaymentIn.getPrefix().toString())
                + (sequencePaymentIn.getSuffix() == null ? "" : sequencePaymentIn.getSuffix()
                    .toString())
                + (sequencePaymentIn.getNextAssignedNumber() == null ? "" : sequencePaymentIn
                    .getNextAssignedNumber().toString());
            sequencePaymentIn.setNextAssignedNumber(sequencePaymentIn.getNextAssignedNumber()
                + sequencePaymentIn.getIncrementBy());

            OBDal.getInstance().save(sequencePaymentIn);
          } else {
            strDocumentnoPaymentIn = "ND";
          }

        } else {
          strFinancialAccountID = "ND";
          strDocumentnoPaymentIn = "ND";
        }

        // Centro de Costos: Buque / Área
        String strcostCenterID = "ND";
        try {
          strcostCenterID = sqbConfigProductList.getCostcenter().getId() == null ? "ND"
              : sqbConfigProductList.getCostcenter().getId();
        } catch (Exception e) {
          log4j.error(e.getMessage());
        }

        if (!strcostCenterID.equals("ND")) {
          costCenter = OBDal.getInstance().get(Costcenter.class, strcostCenterID);
        }

        // Dimensión 1 : Línea de Negocio
        String struser1ID = "ND";
        try {
          struser1ID = sqbConfigProductList.getUser1().getId() == null ? "ND"
              : sqbConfigProductList.getUser1().getId();
        } catch (Exception e) {
          log4j.error(e.getMessage());
        }
        
        if (!struser1ID.equals("ND")) {
          user1 = OBDal.getInstance().get(UserDimension1.class, struser1ID);
        }

        // Dimensión 2 : Viaje o Contrato

        String struser2ID = "ND";

        try {
          struser2ID = sqbConfigProductList.getUser2().getId() == null ? "ND"
              : sqbConfigProductList.getUser2().getId();
        } catch (Exception e) {
          log4j.error(e.getMessage());
        }

        if (!struser2ID.equals("ND")) {
          user2 = OBDal.getInstance().get(UserDimension2.class, struser2ID);
        }

        if (!strPriceListID.equals("ND") && !strDocumentTypeID.equals("ND")
            && !strCurrencyID.equals("ND") && !strfinPaymentID.equals("ND")
            && !strCPaymentTermtID.equals("ND")) {

          PaymentTerm paymentTerm = OBDal.getInstance().get(PaymentTerm.class, strCPaymentTermtID);

          // Impuesto

          // Obtener el Impuesto IVA vigente
          /*
           * try { SqbQuickBillingTaxData sqbQuickBillingTax[] =
           * SqbQuickBillingTaxData.selectedtax(conn, format(new Date())); taxRate =
           * OBDal.getInstance().get(TaxRate.class, sqbQuickBillingTax[0].impuesto);
           * 
           * } catch (ServletException e) { e.printStackTrace(); }
           */

          DocumentType docTypeDefaul = OBDal.getInstance().get(DocumentType.class, "0");

          String strDocumentFE = "";
          try {
            strDocumentFE = getDocumentnoFE(conn, strDocumentno);
          } catch (ServletException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
          }
          // Crear Cabecera Factura
          Invoice newInvoice = OBProvider.getInstance().get(Invoice.class);
          newInvoice.setSqbQuickbilling(sqbQuickBilling);
          newInvoice.setInvoiceDate(new Date());
          newInvoice.setAccountingDate(new Date());
          newInvoice.setDocumentType(docTypeDefaul);
          newInvoice.setTransactionDocument(docType);
          newInvoice.setDocumentNo(strDocumentFE);
          newInvoice.setDescription((sqbConfigProductList.getDescription() == null ? ""
              : sqbConfigProductList.getDescription())
              + "\n"
              + "Nro. Factura Rápida: "
              + sqbQuickBilling.getDocumentno());
          newInvoice.setBusinessPartner(bpartner);
          newInvoice.setPartnerAddress(bPartnerLocation);
          newInvoice.setPriceList(priceList);
          newInvoice.setCurrency(currency);
          newInvoice.setPaymentMethod(finPaymentMethod);
          newInvoice.setPaymentTerms(paymentTerm);

          if (!strcostCenterID.equals("ND")) {
            newInvoice.setCostcenter(costCenter);
          }
          if (!struser1ID.endsWith("ND")) {
            newInvoice.setStDimension(user1);
          }

          if (!struser2ID.endsWith("ND")) {
            newInvoice.setNdDimension(user2);
            ;
          }

          newInvoice.setDocumentStatus("DR");
          newInvoice.setDocumentAction("CO");
          newInvoice.setProcessed(false);
          newInvoice.setPosted("N");
          newInvoice.setPrintDiscount(false);
          newInvoice.setSalesTransaction(true);
          newInvoice.setFormOfPayment("P");
          newInvoice.setSummedLineAmount(BigDecimal.ZERO);
          newInvoice.setGrandTotalAmount(BigDecimal.ZERO);
          OBDal.getInstance().save(sequence);
          OBDal.getInstance().save(newInvoice);
          OBDal.getInstance().flush();

          // Leer Lineas Quick billing Lines
          OBCriteria<SqbQuickBillingLine> ObcriteriaQbLines = OBDal.getInstance().createCriteria(
              SqbQuickBillingLine.class);
          ObcriteriaQbLines.add(Restrictions.eq(SqbQuickBillingLine.PROPERTY_SQBQUICKBILLING,
              sqbQuickBilling));
          List<SqbQuickBillingLine> sqbQBLineList = ObcriteriaQbLines.list();
          
          try {
            strNewInvoiceID = getInvoiceID(conn, sqbQuickBilling.getId());
          } catch (ServletException e) {
            e.printStackTrace();
          }
          
          try {
            // Revisar si el módulo de presupuesto esta instalado
            ConnectionProvider cnn_up_budget = new DalConnectionProvider(true);

            update_Field_Budget(cnn_up_budget, strNewInvoiceID);
            update_budget_area(cnn_up_budget, strNewInvoiceID, sqbConfigProductList.getId());
          } catch (OBException e1) {
              e1.printStackTrace();
              throw new OBException(e1.getMessage());
          }
          
          if (sqbQBLineList.size() > 0) {

            // Crear Lineas de la Factura

            for (SqbQuickBillingLine collectionQBLiine : sqbQBLineList) {

              taxRate = OBDal.getInstance().get(TaxRate.class, collectionQBLiine.getTax().getId());

              InvoiceLine newInvoiceLine = OBProvider.getInstance().get(InvoiceLine.class);
              newInvoiceLine.setInvoice(newInvoice);
              newInvoiceLine.setLineNo((long) 10);
              newInvoiceLine.setProduct(collectionQBLiine.getProduct());
              newInvoiceLine.setTax(taxRate);

              // Unidad de Medida

              UOM uom = OBDal.getInstance().get(UOM.class,
                  collectionQBLiine.getProduct().getUOM().getId());

              newInvoiceLine.setUOM(uom);
              // ADICION LINEA GROSS UNIT PRICE
              newInvoiceLine.setGrossUnitPrice(sqbQuickBilling.getTotal());
              newInvoiceLine.setTaxableAmount(collectionQBLiine.getSubtotalQb());
              newInvoiceLine.setTaxAmount(collectionQBLiine.getVat());
              newInvoiceLine.setLineNetAmount(collectionQBLiine.getSubtotalQb());
              newInvoiceLine.setListPrice(collectionQBLiine.getPricequickbilling());
              newInvoiceLine.setUnitPrice(collectionQBLiine.getPricequickbilling());
              newInvoiceLine.setPriceLimit(collectionQBLiine.getPricequickbilling());
              newInvoiceLine.setStandardPrice(collectionQBLiine.getPricequickbilling());
              newInvoiceLine.setInvoicedQuantity(collectionQBLiine.getQtyquickbilling());
              newInvoiceLine.setSsfiDiscount(collectionQBLiine.getDiscount());
              newInvoiceLine.setSsfiInitialSubtotal(collectionQBLiine.getInitialSubtotal());
              OBDal.getInstance().save(newInvoiceLine);

              sqbQuickBilling.setDocstatus("CO");
              sqbQuickBilling.setTotalStatusbar(sqbQuickBilling.getTotal());
              OBDal.getInstance().save(sqbQuickBilling);
              OBDal.getInstance().flush();
              
              update_budgetline(conn, newInvoiceLine, newInvoice, sqbConfigProductList);
            }

            // Configuración de la ruta temporal de OB para mostrar el reporte en la App.
            String printerPreference = getPrinterPreference(conn);
            if(printerPreference.equals("Y")){
              strAttachment = cf.getBaseDesignPath() + "/design/";
              strFTP = cf.strFTPDirectory;
              log4j.debug("Ruta attachment: " + strAttachment);
              log4j.debug("Ruta FTP: " + strFTP);              
            }


            

            // Proceso que completa la Factura
            String strMessage = ExecuteCompleteInvoice(strNewInvoiceID);
            if (strMessage.equals("OK")) {

              OBDal.getInstance().commitAndClose();
              
              // SE ACTUALIZA EL NUMERO DE FACTURA CLIENTE EN LA CABECERA
              updateInvoiceNumber(strNewInvoiceID, sqbQuickBilling.getId());

              // Generación e impresión del Ticket
              if(printerPreference.equals("Y")){
                printReport(vars, strNewInvoiceID);              
              }              

              if (!strFinancialAccountID.equals("ND") && !strDocumentnoPaymentIn.equals("ND")) {

                // Gestión y Ejecución del Cobro
                FIN_Payment newPayment = createPaymentQB(strFinancialAccountID,
                    strDocumentnoPaymentIn, DocumentTypePaymentInId, bpartner, new Date(), currency,
                    sqbQuickBilling.getTotal(), sqbQuickBilling.getTotal(),
                    String.valueOf(sqbQuickBilling.getTotal()), finPaymentMethod, vars, newInvoice,
                    sqbQuickBilling.getTotal());

                try {

                  strfinPaymentID = newPayment.getId() == null ? "ND" : newPayment.getId();
                  OBDal.getInstance().commitAndClose();

                  if (!strfinPaymentID.equals("ND")) {
                    
                    // VALIDACION PARA EL TOTAL DIFERENTE DE 0
                    if(sqbQuickBilling.getTotal().compareTo(BigDecimal.ZERO) != 0) {
                      insertFin_Transaction(strfinPaymentID, strFinancialAccountID,
                          String.valueOf(new Date()), null, vars, cnn_insert); 
                    }
                    
                  }

                } catch (OBException e) {
                  log4j.error("Exception:" + e);

                  log4j.error(e.getMessage());
                }

                try {

                  ConnectionProvider cnn_up = new DalConnectionProvider(true);

                  UpdateInvoicePaid(cnn_up, strNewInvoiceID, sqbQuickBilling.getTotal());

                } catch (ServletException e) {
                  log4j.error("Exception:" + e);

                }

                try {

                  ConnectionProvider cnn_up2 = new DalConnectionProvider(true);

                  UpdateInvoiceSchedulePaid(cnn_up2, strNewInvoiceID, sqbQuickBilling.getTotal());

                } catch (ServletException e) {
                  log4j.error("Exception:" + e);

                }

                try {

                  ConnectionProvider cnn_up3 = new DalConnectionProvider(true);

                  if (!strFinPaymentScheduleDetailID.equals("")
                      || !strFinPaymentScheduleDetailID.equals(null))
                    DeleteInvoiceSchedulePaid(cnn_up3, strFinPaymentScheduleDetailID);

                } catch (ServletException e) {
                  log4j.error("Exception:" + e);

                }
              }
              
              connectionDB.close();
              OBDal.getInstance().commitAndClose();
              
              message.setTitle(Utility.messageBD(conn, "ProcessOK", language));
              message.setType("Success");
              message.setMessage(Utility.messageBD(conn, successMessage, language));

            } else {
              throw new OBException(Utility.messageBD(conn, strMessage, language));
            }

          } else {

            OBDal.getInstance().rollbackAndClose();
            message.setTitle(Utility.messageBD(conn, "Error", language));
            message.setType("Error");
            message.setMessage(Utility.messageBD(conn, "Sqb_ErrorCreateInvoiceLine", language));
          }

        } else {
          message.setTitle(Utility.messageBD(conn, "Error", language));
          message.setType("Error");
          message.setMessage(Utility.messageBD(conn, "Sqb_ErrorSetupQuickBilling", language));
        }
      } else {
        message.setTitle(Utility.messageBD(conn, "Error", language));
        message.setType("Error");
        message.setMessage(Utility.messageBD(conn, "Sqb_ErrorSetupQuickBilling", language));

      }
    } catch (Exception e) {
      log4j.error(e.getMessage());
      message.setTitle("Error");
      message.setType("Error");
      message.setMessage(e.getMessage());

    }
  }
 
  public static final String format(Date date) {
    return date == null ? null : new SimpleDateFormat(dateTimeFormat).format(date);
  }

  public ConfigParameters getConfigParameters() {
    return (ConfigParameters) ctx.get(ConfigParameters.CONFIG_ATTRIBUTE);
  }

  public String ExecuteCompleteInvoice(String strInvoiceID) {
    try {
      org.openbravo.database.ConnectionProvider cp = new DalConnectionProvider(false);
      CallableStatement cs = cp.getConnection().prepareCall("{call C_INVOICE_POST(?,?)}");

      // client
      cs.setString(1, null);
      cs.setString(2, strInvoiceID);
      cs.execute();
      cs.close();
      return "OK";
    } catch (Exception e) {
      log4j.error(e.getMessage());
      return e.getMessage().toString();
    }

  }

  public static String getUUID(ConnectionProvider connectionProvider) throws ServletException {
    String strSql = "";
    strSql = strSql + "       SELECT get_uuid() as name" + "       FROM dual";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    try {
      st = connectionProvider.getPreparedStatement(strSql);

      result = st.executeQuery();
      if (result.next()) {
        strReturn = UtilSql.getValue(result, "name");
      }
      result.close();
      st.close();
    } catch (SQLException e) {
      // log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@"
          + e.getMessage());
    } catch (Exception ex) {
      // log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
        connectionProvider.destroy();
      } catch (Exception ignore) {
        ignore.printStackTrace();
      }
    }
    return (strReturn);
  }

  public static String getSearchInvoice(ConnectionProvider connectionProvider,
      String strQuickBilling_ID) throws ServletException {
    String strSql = "";
    strSql = strSql + "       SELECT to_char('OK') as resultado"
        + "       FROM c_invoice where em_sqb_quickbilling_id ='" + strQuickBilling_ID + "'";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    try {
      st = connectionProvider.getPreparedStatement(strSql);

      result = st.executeQuery();
      if (result.next()) {
        strReturn = UtilSql.getValue(result, "resultado");
      }
      result.close();
    } catch (SQLException e) {
      // log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@"
          + e.getMessage());
    } catch (Exception ex) {
      // log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
        connectionProvider.destroy();
      } catch (Exception ignore) {
        ignore.printStackTrace();
      }
    }
    return (strReturn);
  }

  public static String getInvoiceID(ConnectionProvider connectionProvider, String strInvoiceID)
      throws ServletException {
    String strSql = "";
    strSql = strSql
        + "       SELECT c_invoice_id as invoiceid FROM c_invoice where em_sqb_quickbilling_id = '"
        + strInvoiceID + "'";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    try {
      st = connectionProvider.getPreparedStatement(strSql);

      result = st.executeQuery();
      if (result.next()) {
        strReturn = UtilSql.getValue(result, "invoiceid");
      }
      result.close();
    } catch (SQLException e) {
      // log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@"
          + e.getMessage());
    } catch (Exception ex) {
      // log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
        connectionProvider.destroy();
      } catch (Exception ignore) {
        ignore.printStackTrace();
      }
    }
    return (strReturn);
  }

  public static String getDocumentnoFE(ConnectionProvider connectionProvider, String strDocumentno)
      throws ServletException {
    String strSql = "";
    strSql = strSql + "       SELECT sescr_returndocumentno('" + strDocumentno
        + "') as documentno from dual";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    try {
      st = connectionProvider.getPreparedStatement(strSql);

      result = st.executeQuery();
      if (result.next()) {
        strReturn = UtilSql.getValue(result, "documentno");
      }
      result.close();
    } catch (SQLException e) {
      log4j.error("SQL error in query: " + strSql + "Exception:" + e);
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@"
          + e.getMessage());
    } catch (Exception ex) {
      log4j.error("Exception in query: " + strSql + "Exception:" + ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
        connectionProvider.destroy();
      } catch (Exception ignore) {
        ignore.printStackTrace();
      }
    }
    return (strReturn);
  }

  public static void update_Field_Budget(ConnectionProvider connectionProvider, String strDocumentno)
      throws OBException {
    String strSql = "";
    strSql = strSql + "       SELECT sqb_partner_update_budget('" + strDocumentno
        + "') as updatebudget from dual";

    ResultSet result;
    String strReturn = "ND";
    PreparedStatement st = null;

    try {
      st = connectionProvider.getPreparedStatement(strSql);

      result = st.executeQuery();
      strReturn = "OK";

      result.close();
      st.close();
    } catch (SQLException e) {
      log4j.error("SQL error in query: " + strSql + "Exception:" + e);
      throw new OBException(e.getMessage());
    } catch (Exception ex) {
      log4j.error("Exception in query: " + strSql + "Exception:" + ex);
      throw new OBException(ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
        connectionProvider.destroy();
      } catch (Exception ignore) {
        ignore.printStackTrace();
      }
    }
  }

  public static void update_budgetline(ConnectionProvider conn, InvoiceLine invoiceline, Invoice invoice, SqbConfigQuickBilling sqbConfigProductList) 
      throws OBException {
    
    String strSql = "";
    strSql = strSql + "SELECT sqb_update_budget(?,?,?,?,?,?,?,?,?,?) as updatebudgetarea from dual";

    ResultSet result;
    String strReturn = "ND";
    PreparedStatement st = null;
    
    String strDateInvoice = OBDateUtils.formatDate(invoice.getInvoiceDate());
    
    try {
      st = conn.getPreparedStatement(strSql);
      st.setString(1, invoiceline.getProduct().getId());
      st.setString(2, invoice.getCostcenter().getId());
      st.setString(3, invoice.getStDimension().getId());
      st.setString(4, sqbConfigProductList.getSqbbuBudgetArea().getId());
      st.setString(5, invoice.getCurrency().getId());
      st.setString(6, strDateInvoice);
      st.setString(7, "");
      st.setBigDecimal(8, invoiceline.getLineNetAmount());
      st.setString(9, invoiceline.getClient().getId());
      st.setString(10, invoiceline.getOrganization().getId());
      result = st.executeQuery();
      strReturn = "OK";
      
      result.close();
      st.close();
    } catch (SQLException e) {
      //log4j.error("SQL error in query: " + strSql + "Exception:" + e);
      throw new OBException( e.getMessage());
    } catch (Exception ex) {
      //log4j.error("Exception in query: " + strSql + "Exception:" + ex);
      throw new OBException(ex.getMessage());
    } finally {
      try {
        conn.releasePreparedStatement(st);
        conn.destroy();
      } catch (Exception ignore) {
        ignore.printStackTrace();
      }
    }
    System.out.println(strReturn);
  }

  
  public static void update_budget_area(ConnectionProvider connectionProvider, String strDocumentno, String strConfigId)
	      throws OBException {
	    String strSql = "";
	    strSql = strSql + "       SELECT sqb_update_budget_area(?,?) as updatebudgetarea from dual";

	    ResultSet result;
	    String strReturn = "ND";
	    PreparedStatement st = null;

	    try {
	      st = connectionProvider.getPreparedStatement(strSql);
	      st.setString(1, strDocumentno);
	      st.setString(2, strConfigId);
	      result = st.executeQuery();
	      strReturn = "OK";

	      result.close();
	      st.close();
	    } catch (SQLException e) {
	      log4j.error("SQL error in query: " + strSql + "Exception:" + e);
	      throw new OBException( e.getMessage());
	    } catch (Exception ex) {
	      log4j.error("Exception in query: " + strSql + "Exception:" + ex);
	      throw new OBException(ex.getMessage());
	    } finally {
	      try {
	        connectionProvider.releasePreparedStatement(st);
	        connectionProvider.destroy();
	      } catch (Exception ignore) {
	        ignore.printStackTrace();
	      }
	    }
	  }

  public void printReport(VariablesSecureApp vars, String strQuickBillingID) {
    final HttpServletRequest request = RequestContext.get().getRequest();
    final HttpServletResponse response = RequestContext.get().getResponse();

    Sqb_PrintReportQuickBilling sqbPrintPDF = new Sqb_PrintReportQuickBilling();
    try {
      sqbPrintPDF.doPost(request, response, strQuickBillingID, strAttachment, strFTP, connectionDB);

    } catch (IOException e) {
      e.printStackTrace();
    } catch (ServletException e) {
      e.printStackTrace();
    }

  }

  public FIN_Payment createPaymentQB(String strFin_AccountID, String strDocumentno,
      String DocumentypeId, BusinessPartner businessPartner, Date paymentDate, Currency currency,
      BigDecimal exchangeRate, BigDecimal convertedAmount, String strActualPayment,
      FIN_PaymentMethod finPaymentMethod, VariablesSecureApp vars, Invoice newInvoice,
      BigDecimal bgdTotalPaid) {
    FIN_Payment payment = OBProvider.getInstance().get(FIN_Payment.class);

    JSONObject jsonResponse = new JSONObject();
    JSONObject jsonparams = null;

    String comingFrom = "TRANSACTION";
    try {
      jsonparams = jsonResponse.getJSONObject("_params");
    } catch (JSONException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    // Action to do
    final String strAction = "PRP";

    final boolean isReceipt = true;

    // Payment is already created. Load it.
    final String strFinPaymentID = "";

    try {
      JSONObject jsonparams_cp = new JSONObject();

      jsonparams_cp.put("fin_financial_account_id", strFin_AccountID);
      jsonparams_cp.put("payment_documentno", strDocumentno);
      jsonparams_cp.put("fin_paymentmethod_id", finPaymentMethod.getId());
      jsonparams_cp.put("reference_no", "");
      jsonparams_cp.put("payment_document_type_id", DocumentypeId);
      payment = createNewPayment(jsonparams_cp, isReceipt, OBContext.getOBContext()
          .getCurrentOrganization(), businessPartner, paymentDate, currency, new BigDecimal("1"),
          convertedAmount, strActualPayment);
    } catch (JSONException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    // List<String> pdToRemove = new ArrayList<String>();
    // pdToRemove = OBDao.getIDListFromOBObject(payment.getFINPaymentDetailList());
    // OverPayment action
    String strDifferenceAction = "refund";
    BigDecimal differenceAmount = BigDecimal.ZERO;

    payment.setAmount(new BigDecimal(strActualPayment));

    // FIN_AddPayment.setFinancialTransactionAmountAndRate(vars, payment, exchangeRate,
    // convertedAmount);
    payment.setFinancialTransactionAmount(new BigDecimal(strActualPayment));
    payment.setFinancialTransactionConvertRate(new BigDecimal("1"));
    OBDal.getInstance().save(payment);

    if (!payment.getId().isEmpty()) {

      String strFin_PaymentID = "";
      strFin_PaymentID = payment.getId();

      OBCriteria<FIN_PaymentSchedule> ObcriteriaFPS = OBDal.getInstance().createCriteria(
          FIN_PaymentSchedule.class);
      ObcriteriaFPS.add(Restrictions.eq(FIN_PaymentSchedule.PROPERTY_INVOICE, newInvoice));
      String strFinPaymeSchedulID = "";
      if (!ObcriteriaFPS.list().isEmpty()) {
        strFinPaymeSchedulID = ObcriteriaFPS.list().get(0).getId();

        try {
          FIN_PaymentSchedule FPS = OBDal.getInstance().get(FIN_PaymentSchedule.class,
              strFinPaymeSchedulID);

          FPS.setPaidAmount(bgdTotalPaid);
          FPS.setOutstandingAmount(BigDecimal.ZERO);
          OBDal.getInstance().save(FPS);
          OBDal.getInstance().commitAndClose();

          String strNewPD_ID;
          try {
            org.openbravo.database.ConnectionProvider cp = new DalConnectionProvider(false);

            strNewPD_ID = getUUID(cp);
            NewPaymentDetail(cp, strNewPD_ID, payment.getId(), bgdTotalPaid);

            strFinPaymentScheduleDetailID = FPS.getId();

            NewPaymentSchedulDetail(cp, strNewPD_ID, bgdTotalPaid, newInvoice.getBusinessPartner()
                .getId(), FPS.getId());

            UpdatePayment(cp, strFin_PaymentID, bgdTotalPaid, newInvoice.getDocumentNo());
          } catch (ServletException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            log4j.error(e.getMessage());
            // throw new OBException(Utility.messageBD(conn, e.toString(), language));

          }

        } catch (OBException e) {
          OBDal.getInstance().rollbackAndClose();
          log4j.error(e.getMessage());

          // throw new OBException(Utility.messageBD(conn, e.toString(), language));

        }
      }
    }

    if (strAction.equals("PRP") || strAction.equals("PPP") || strAction.equals("PRD")
        || strAction.equals("PPW")) {

      OBError message;
      try {
        message = processPayment(payment, strAction, strDifferenceAction, differenceAmount,
            exchangeRate, jsonparams, comingFrom, newInvoice, bgdTotalPaid);
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        log4j.error(e.getMessage());

        log4j.error(e.getMessage());
      }

    }
    OBDal.getInstance().flush();

    return payment;

  }

  private FIN_Payment createNewPayment(JSONObject jsonparams, boolean isReceipt, Organization org,
      BusinessPartner bPartner, Date paymentDate, Currency currency, BigDecimal conversionRate,
      BigDecimal convertedAmt, String strActualPayment) throws OBException, JSONException,
      SQLException {
    JSONObject obj = new JSONObject();

    String strPaymentDocumentNo = jsonparams.getString("payment_documentno");
    String strReferenceNo = "";
    if (jsonparams.get("reference_no") != JSONObject.NULL) {
      strReferenceNo = jsonparams.getString("reference_no");
    }
    String strFinancialAccountId = jsonparams.getString("fin_financial_account_id");
    FIN_FinancialAccount finAccount = OBDal.getInstance().get(FIN_FinancialAccount.class,
        strFinancialAccountId);
    String strPaymentMethodId = jsonparams.getString("fin_paymentmethod_id");
    FIN_PaymentMethod paymentMethod = OBDal.getInstance().get(FIN_PaymentMethod.class,
        strPaymentMethodId);

    boolean paymentDocumentEnabled = getDocumentConfirmation(finAccount, paymentMethod, isReceipt,
        strActualPayment, true);
    String strAction = (isReceipt ? "PRP" : "PPP");
    boolean documentEnabled = true;
    if ((strAction.equals("PRD") || strAction.equals("PPW") || FIN_Utility
        .isAutomaticDepositWithdrawn(finAccount, paymentMethod, isReceipt))
        && new BigDecimal(strActualPayment).signum() != 0) {
      documentEnabled = paymentDocumentEnabled
          || getDocumentConfirmation(finAccount, paymentMethod, isReceipt, strActualPayment, false);
    } else {
      documentEnabled = paymentDocumentEnabled;
    }
    /*******Tipo de Documento ********************/
    String strPaymentDocumentTypeId = jsonparams.getString("payment_document_type_id");
    DocumentType docTypePaymentIn = OBDal.getInstance().get(DocumentType.class,
        strPaymentDocumentTypeId);
    // DocumentType documentType = FIN_Utility.getDocumentType(org, isReceipt ? "ARR" : "APP");
    String strDocBaseType = docTypePaymentIn.getDocumentCategory();

    OrganizationStructureProvider osp = OBContext.getOBContext().getOrganizationStructureProvider(
        OBContext.getOBContext().getCurrentClient().getId());
    boolean orgLegalWithAccounting = osp.getLegalEntityOrBusinessUnit(org).getOrganizationType()
        .isLegalEntityWithAccounting();
    if (documentEnabled
        && !FIN_Utility.isPeriodOpen(OBContext.getOBContext().getCurrentClient().getId(),
            strDocBaseType, org.getId(), OBDateUtils.formatDate(paymentDate))
        && orgLegalWithAccounting) {
      String messag = OBMessageUtils.messageBD("PeriodNotAvailable");
      throw new OBException(messag);
    }

    String strPaymentAmount = "0";
    if (strPaymentDocumentNo.startsWith("<")) {
      // get DocumentNo
      strPaymentDocumentNo = FIN_Utility.getDocumentNo(docTypePaymentIn, "FIN_Payment");
    }

    FIN_Payment payment = (new AdvPaymentMngtDao()).getNewPayment(isReceipt, org, docTypePaymentIn,
        strPaymentDocumentNo, bPartner, paymentMethod, finAccount, strPaymentAmount, paymentDate,
        strReferenceNo, currency, conversionRate, convertedAmt);
    OBDal.getInstance().getConnection(true).commit();
    if (!costCenter.equals(null)) {
      payment.setCostCenter(costCenter);
    }
    if (!user1.equals(null)) {
      payment.setStDimension(user1);
    }

    if (!user2.equals(null)) {
      payment.setNdDimension(user2);
    }
    return payment;
  }

  private boolean getDocumentConfirmation(FIN_FinancialAccount finAccount,
      FIN_PaymentMethod finPaymentMethod, boolean isReceipt, String strPaymentAmount,
      boolean isPayment) {
    // Checks if this step is configured to generate accounting for the selected financial account
    boolean confirmation = false;
    OBContext.setAdminMode(true);
    try {
      OBCriteria<FinAccPaymentMethod> obCriteria = OBDal.getInstance().createCriteria(
          FinAccPaymentMethod.class);
      obCriteria.add(Restrictions.eq(FinAccPaymentMethod.PROPERTY_ACCOUNT, finAccount));
      obCriteria.add(Restrictions.eq(FinAccPaymentMethod.PROPERTY_PAYMENTMETHOD, finPaymentMethod));
      obCriteria.setFilterOnReadableClients(false);
      obCriteria.setFilterOnReadableOrganization(false);
      obCriteria.setMaxResults(1);
      FinAccPaymentMethod finAccPayMethod = (FinAccPaymentMethod) obCriteria.uniqueResult();
      String uponUse = "";
      if (isPayment) {
        if (isReceipt) {
          uponUse = finAccPayMethod.getUponReceiptUse();
        } else {
          uponUse = finAccPayMethod.getUponPaymentUse();
        }
      } else {
        if (isReceipt) {
          uponUse = finAccPayMethod.getUponDepositUse();
        } else {
          uponUse = finAccPayMethod.getUponWithdrawalUse();
        }
      }
      for (FIN_FinancialAccountAccounting account : finAccount.getFINFinancialAccountAcctList()) {
        if (confirmation) {
          return confirmation;
        }
        if (isReceipt) {
          if ("INT".equals(uponUse) && account.getInTransitPaymentAccountIN() != null) {
            confirmation = true;
          } else if ("DEP".equals(uponUse) && account.getDepositAccount() != null) {
            confirmation = true;
          } else if ("CLE".equals(uponUse) && account.getClearedPaymentAccount() != null) {
            confirmation = true;
          }
        } else {
          if ("INT".equals(uponUse) && account.getFINOutIntransitAcct() != null) {
            confirmation = true;
          } else if ("WIT".equals(uponUse) && account.getWithdrawalAccount() != null) {
            confirmation = true;
          } else if ("CLE".equals(uponUse) && account.getClearedPaymentAccountOUT() != null) {
            confirmation = true;
          }
        }
        // For payments with Amount ZERO always create an entry as no transaction will be created
        if (isPayment) {
          BigDecimal amount = new BigDecimal(strPaymentAmount);
          if (amount.signum() == 0) {
            confirmation = true;
          }
        }
      }
    } catch (Exception e) {
      return confirmation;
    } finally {
      OBContext.restorePreviousMode();
    }
    return confirmation;
  }

  private OBError processPayment(FIN_Payment payments, String strAction,
      String strDifferenceAction, BigDecimal refundAmount, BigDecimal exchangeRate,
      JSONObject jsonparams, String comingFrom, Invoice newInvoice, BigDecimal bgdTotalPaid)
      throws Exception {
    ConnectionProvider conn = new DalConnectionProvider(true);
    VariablesSecureApp vars = RequestContext.get().getVariablesSecureApp();
    FIN_Payment payment = payments;
    BigDecimal assignedAmount = BigDecimal.ZERO;
    for (FIN_PaymentDetail paymentDetail : payment.getFINPaymentDetailList()) {
      assignedAmount = assignedAmount.add(paymentDetail.getAmount());
    }

    /*
     * if (assignedAmount.compareTo(payment.getAmount()) == -1) { FIN_PaymentScheduleDetail
     * refundScheduleDetail = getNewPaymentScheduleDetail( payment.getOrganization(),
     * payment.getAmount().subtract(assignedAmount)); getNewPaymentDetail(payment,
     * refundScheduleDetail, payment.getAmount().subtract(assignedAmount), BigDecimal.ZERO, false,
     * null); }
     */

    OBError message2 = FIN_AddPayment.processPayment(vars, conn,
        (strAction.equals("PRP") || strAction.equals("PPP")) ? "P" : "D", payment, comingFrom);
    String strNewPaymentMessage = OBMessageUtils.parseTranslation("@PaymentCreated@" + " "
        + payment.getDocumentNo())
        + ".";
    if (!"Error".equalsIgnoreCase(message2.getType())) {
      message2.setMessage(strNewPaymentMessage + " " + message2.getMessage());
      message2.setType(message2.getType().toLowerCase());
    } else {
      conn = new DalConnectionProvider(true);
      OBDal.getInstance().getSession().clear();
      payment = OBDal.getInstance().get(FIN_Payment.class, payment.getId());
    }

    return message2;
  }

  public void NewPaymentDetail(ConnectionProvider connectionProvider, String strNewPaymentDetailID,
      String strPaymentID, BigDecimal bgdAmount) throws ServletException {
    String strSql = "";
    strSql = strSql
        + "insert into fin_payment_detail(fin_payment_detail_id, ad_client_id, ad_org_id, isactive, createdby, created, updatedby, updated"
        + ", fin_payment_id, amount,refund,writeoffamt,c_glitem_id,isprepayment) values('"
        + strNewPaymentDetailID + "','" + OBContext.getOBContext().getCurrentClient().getId()
        + "','" + OBContext.getOBContext().getCurrentOrganization().getId() + "','Y','"
        + OBContext.getOBContext().getUser().getId() + "',now(),'"
        + OBContext.getOBContext().getUser().getId() + "',now(),'" + strPaymentID + "',"
        + bgdAmount + ",'N',0,null,'N')";

    int updateCount = 0;
    PreparedStatement st = null;

    try {
      st = connectionProvider.getPreparedStatement(strSql);
      updateCount = st.executeUpdate();
      st.close();

    } catch (SQLException e) {
      log4j.error(e.getMessage());

    } catch (Exception ex) {
      log4j.error(ex.getMessage());

    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
        connectionProvider.destroy();
      } catch (Exception ignore) {
        ignore.printStackTrace();
        log4j.error(ignore.getMessage());

      }
    }
  }

  public void NewPaymentSchedulDetail(ConnectionProvider connectionProvider,
      String strPaymentDetailID, BigDecimal bgdAmount, String strPartnerID,
      String strPaymenSchedulID) throws ServletException {
    String strSql = "";
    strSql = strSql
        + "insert into fin_payment_scheduledetail(fin_payment_scheduledetail_id, ad_client_id, ad_org_id, isactive, createdby, created, updatedby, updated"
        + ", fin_payment_schedule_invoice, amount,writeoffamt,iscanceled,c_bpartner_id,fin_payment_detail_id) values("
        + "get_uuid(),'" + OBContext.getOBContext().getCurrentClient().getId() + "','"
        + OBContext.getOBContext().getCurrentOrganization().getId() + "','Y','"
        + OBContext.getOBContext().getUser().getId() + "',now(),'"
        + OBContext.getOBContext().getUser().getId() + "',now(),'" + strPaymenSchedulID + "',"
        + bgdAmount + ",0,'N',null,'" + strPaymentDetailID + "')";

    int updateCount = 0;
    PreparedStatement st = null;

    try {
      st = connectionProvider.getPreparedStatement(strSql);
      updateCount = st.executeUpdate();
      st.close();

    } catch (SQLException e) {
      // log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      // throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" +
      // e.getMessage());
      log4j.error(e.getMessage());
    } catch (Exception ex) {
      // log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      // throw new ServletException("@CODE=@" + ex.getMessage());
      log4j.error(ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
        connectionProvider.destroy();
      } catch (Exception ignore) {
        ignore.printStackTrace();
        log4j.error(ignore.getMessage());
      }
    }
  }

  public void UpdatePayment(ConnectionProvider connectionProvider, String strPaymentID,
      BigDecimal bgdAmount, String Documentno) throws ServletException {
    String strSql = "";
    strSql = strSql + "update fin_payment set status = 'RDNC',processed='Y', amount = " + bgdAmount
        + ",finacc_txn_convert_rate=1 where fin_payment_id ='" + strPaymentID + "'";

    int updateCount = 0;
    PreparedStatement st = null;

    try {
      st = connectionProvider.getPreparedStatement(strSql);
      updateCount = st.executeUpdate();
      st.close();

    } catch (SQLException e) {
      // log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      // throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" +
      // e.getMessage());
    } catch (Exception ex) {
      // log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      // throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
        connectionProvider.destroy();
      } catch (Exception ignore) {
        ignore.printStackTrace();
      }
    }
  }

  public void UpdateInvoicePaid(ConnectionProvider connectionProvider, String strInvoiceID,
      BigDecimal bgdAmount) throws ServletException {
    String strSql = "";
    strSql = strSql + "update c_invoice set ispaid='Y', updated=now(), updatedby = '"
        + OBContext.getOBContext().getUser().getId() + "',totalpaid=" + bgdAmount
        + ",outstandingamt=0, daystilldue =0, dueamt=0, percentageoverdue=0 where c_invoice_id = '"
        + strInvoiceID + "'";

    int updateCount = 0;
    PreparedStatement st = null;

    try {
      st = connectionProvider.getPreparedStatement(strSql);
      updateCount = st.executeUpdate();
      st.close();

    } catch (SQLException e) {
      log4j.error("SQL error in query: " + strSql + "Exception:" + e);
      // throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" +
      // e.getMessage());
    } catch (Exception ex) {
      log4j.error("Exception in query: " + strSql + "Exception:" + ex);
      // throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
        connectionProvider.destroy();
      } catch (Exception ignore) {
        ignore.printStackTrace();
      }
    }
  }

  public void UpdateInvoiceSchedulePaid(ConnectionProvider connectionProvider, String strInvoiceID,
      BigDecimal bgdAmount) throws ServletException {
    String strSql = "";
    strSql = strSql + "update fin_payment_schedule set  updated=now(), updatedby = '"
        + OBContext.getOBContext().getUser().getId() + "',outstandingamt=0 ,paidamt=" + bgdAmount
        + "  where c_invoice_id = '" + strInvoiceID + "'";

    int updateCount = 0;
    PreparedStatement st = null;

    try {
      st = connectionProvider.getPreparedStatement(strSql);
      updateCount = st.executeUpdate();
      st.close();

    } catch (SQLException e) {
      log4j.error("SQL error in query: " + strSql + "Exception:" + e);
      // throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" +
      // e.getMessage());
    } catch (Exception ex) {
      log4j.error("Exception in query: " + strSql + "Exception:" + ex);
      // throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
        connectionProvider.destroy();
      } catch (Exception ignore) {
        ignore.printStackTrace();
      }
    }
  }

  public void DeleteInvoiceSchedulePaid(ConnectionProvider connectionProvider,
      String strScheludeDetail) throws ServletException {
    String strSql = "";
    strSql = strSql
        + "delete from fin_payment_scheduledetail  where fin_payment_detail_id is null  and fin_payment_schedule_invoice = '"
        + strScheludeDetail + "'";

    int updateCount = 0;
    PreparedStatement st = null;

    try {
      st = connectionProvider.getPreparedStatement(strSql);
      updateCount = st.executeUpdate();
      st.close();

    } catch (SQLException e) {
      log4j.error("SQL error in query: " + strSql + "Exception:" + e);
      // throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" +
      // e.getMessage());
    } catch (Exception ex) {
      log4j.error("Exception in query: " + strSql + "Exception:" + ex);
      // throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
        connectionProvider.destroy();
      } catch (Exception ignore) {
        ignore.printStackTrace();
      }
    }
  }

  public void insertFin_Transaction(String selectedPaymentIds, String strFinancialAccountId,
      String strTransactionDate, String strFinBankStatementLineId, VariablesSecureApp vars,
      ConnectionProvider conn) {
    try {

      OBContext.setAdminMode();

      AdvPaymentMngtDao dao = new AdvPaymentMngtDao();
      String strMessage = "";
      OBError msg = new OBError();

      String strTransactionType = "P";
      if (strTransactionType.equals("P")) { // Payment

        List<FIN_Payment> selectedPayments = FIN_Utility.getOBObjectList(FIN_Payment.class,
            selectedPaymentIds);

        for (FIN_Payment p : selectedPayments) {
          BigDecimal depositAmt = FIN_Utility.getDepositAmount(p.isReceipt(),
              p.getFinancialTransactionAmount());
          BigDecimal paymentAmt = FIN_Utility.getPaymentAmount(p.isReceipt(),
              p.getFinancialTransactionAmount());

          String description = null;
          if (p.getDescription() != null) {
            description = p.getDescription().replace("\n", ". ");
          }

          FIN_FinaccTransaction finTrans = dao.getNewFinancialTransaction(
              p.getOrganization(),
              OBDal.getInstance().get(FIN_FinancialAccount.class, strFinancialAccountId),
              TransactionsDao.getTransactionMaxLineNo(OBDal.getInstance().get(
                  FIN_FinancialAccount.class, strFinancialAccountId)) + 10, p, description,
              new Date(), null, p.isReceipt() ? "RDNC" : "PWNC", depositAmt, paymentAmt, null,
              null, null, p.isReceipt() ? "BPD" : "BPW", new Date(), p.getCurrency(),
              p.getFinancialTransactionConvertRate(), p.getAmount());

          OBDal.getInstance().commitAndClose();
          try {
            // processTransactionError = processTransaction(vars, conn, "P", finTrans);
            processTransaction(finTrans, "P", cnn_insert2);
          } catch (Exception e) {
            e.printStackTrace();
            log4j.error(e.getMessage());
          }

          if (!"".equals(strFinBankStatementLineId)) {
            // matchBankStatementLine(vars, finTrans, strFinBankStatementLineId, dao);
          }
        }

        if (selectedPaymentIds != null && selectedPayments.size() > 0) {
          strMessage = selectedPayments.size() + " " + "@RowsInserted@";
        }

      }

      if ("".equals(strFinBankStatementLineId)) {
        // printPageClosePopUpAndRefreshParent(response, vars);
      } else {
        log4j.debug("Output: PopUp Response");

      }

    } catch (OBException e) {
      log4j.error(e.getMessage());

    } finally {
      OBContext.restorePreviousMode();

    }
  }

  @SuppressWarnings("unused")
  private void matchBankStatementLine(VariablesSecureApp vars, FIN_FinaccTransaction finTrans,
      String strFinBankStatementLineId, AdvPaymentMngtDao dao) {
    FIN_BankStatementLine bsline = dao.getObject(FIN_BankStatementLine.class,
        strFinBankStatementLineId);
    // The amounts must match
    if (bsline.getCramount().compareTo(finTrans.getDepositAmount()) != 0
        || bsline.getDramount().compareTo(finTrans.getPaymentAmount()) != 0) {
      vars.setSessionValue("AddTransaction|ShowJSMessage", "Y");
      vars.setSessionValue("AddTransaction|SelectedTransaction", finTrans.getId());
    } else {
      FIN_Reconciliation reconciliation = TransactionsDao.getLastReconciliation(
          finTrans.getAccount(), "N");
      bsline.setMatchingtype("AD");
      bsline.setFinancialAccountTransaction(finTrans);
      if (finTrans.getFinPayment() != null) {
        bsline.setBusinessPartner(finTrans.getFinPayment().getBusinessPartner());
        finTrans.getFinPayment().setStatus("RPPC");
      }
      finTrans.setReconciliation(reconciliation);
      finTrans.setStatus("RPPC");
      OBDal.getInstance().save(bsline);
      OBDal.getInstance().save(finTrans);
      OBDal.getInstance().flush();
    }
  }

  @SuppressWarnings("unused")
  private OBError processTransaction(VariablesSecureApp vars, ConnectionProvider conn,
      String strAction, FIN_FinaccTransaction transaction) throws Exception {
    ProcessBundle pb = new ProcessBundle("F68F2890E96D4D85A1DEF0274D105BCE", vars).init(conn);
    HashMap<String, Object> parameters = new HashMap<String, Object>();
    parameters.put("action", strAction);
    parameters.put("Fin_FinAcc_Transaction_ID", transaction.getId());
    pb.setParams(parameters);
    OBError myMessage = null;
    new FIN_TransactionProcess().execute(pb);
    myMessage = (OBError) pb.getResult();
    return myMessage;
  }

  public void processTransaction(FIN_FinaccTransaction transaction, String strAction,
      ConnectionProvider conProvider) {
    try {

      if (strAction.equals("P")) {
        // ***********************
        // Process Transaction
        // ***********************

        /*
         * if (documentEnabled && !FIN_Utility.isPeriodOpen(transaction.getClient().getId(),
         * AcctServer.DOCTYPE_FinAccTransaction, transaction.getOrganization().getId(),
         * OBDateUtils.formatDate(transaction.getDateAcct())) && orgLegalWithAccounting) {
         * OBDal.getInstance().rollbackAndClose(); return; }
         */
        final FIN_FinancialAccount financialAccount = transaction.getAccount();
        financialAccount.setCurrentBalance(financialAccount.getCurrentBalance().add(
            transaction.getDepositAmount().subtract(transaction.getPaymentAmount())));
        transaction.setProcessed(true);
        FIN_Payment payment = transaction.getFinPayment();
        if (payment != null) {
          if (transaction.getBusinessPartner() == null) {
            transaction.setBusinessPartner(payment.getBusinessPartner());
          }
          payment.setStatus(payment.isReceipt() ? "RDNC" : "PWNC");
          transaction.setStatus(payment.isReceipt() ? "RDNC" : "PWNC");
          OBDal.getInstance().save(payment);
          if (transaction.getDescription() == null || "".equals(transaction.getDescription())) {
            transaction.setDescription(payment.getDescription());
          }
          Boolean invoicePaidold = false;
          for (FIN_PaymentDetail pd : payment.getFINPaymentDetailList()) {
            for (FIN_PaymentScheduleDetail psd : pd.getFINPaymentScheduleDetailList()) {
              invoicePaidold = psd.isInvoicePaid();
              if (!invoicePaidold) {
                if ((FIN_Utility.invoicePaymentStatus(payment).equals(payment.getStatus()))) {
                  psd.setInvoicePaid(true);
                }
                if (psd.isInvoicePaid()) {
                  FIN_Utility.updatePaymentAmounts(psd);
                  FIN_Utility.updateBusinessPartnerCredit(payment);
                }
                OBDal.getInstance().save(psd);
              }
            }
          }

        } else {
          transaction.setStatus(transaction.getDepositAmount().compareTo(
              transaction.getPaymentAmount()) > 0 ? "RDNC" : "PWNC");
        }
        if (transaction.getForeignCurrency() != null
            && !transaction.getCurrency().equals(transaction.getForeignCurrency())
            && getConversionRateDocument(transaction).size() == 0) {
          insertConversionRateDocument(transaction);
        }
        transaction.setDateAcct(new Date());
        transaction.setTransactionDate(new Date());
        OBDal.getInstance().save(financialAccount);
        OBDal.getInstance().save(transaction);
        OBDal.getInstance().flush();
        // bundle.setResult(msg);
        OBDal.getInstance().commitAndClose();

      }

    } catch (OBException e) {
      OBDal.getInstance().rollbackAndClose();
      log4j.error(e.getMessage());
    }

  }

  private List<ConversionRateDoc> getConversionRateDocument(FIN_FinaccTransaction transaction) {
    OBContext.setAdminMode();
    try {
      OBCriteria<ConversionRateDoc> obc = OBDal.getInstance().createCriteria(
          ConversionRateDoc.class);
      obc.add(Restrictions.eq(ConversionRateDoc.PROPERTY_CURRENCY, transaction.getForeignCurrency()));
      obc.add(Restrictions.eq(ConversionRateDoc.PROPERTY_TOCURRENCY, transaction.getCurrency()));
      obc.add(Restrictions.eq(ConversionRateDoc.PROPERTY_FINANCIALACCOUNTTRANSACTION, transaction));
      return obc.list();
    } finally {
      OBContext.restorePreviousMode();
    }
  }

  private ConversionRateDoc insertConversionRateDocument(FIN_FinaccTransaction transaction) {
    OBContext.setAdminMode();
    try {
      ConversionRateDoc newConversionRateDoc = OBProvider.getInstance()
          .get(ConversionRateDoc.class);
      newConversionRateDoc.setOrganization(transaction.getOrganization());
      newConversionRateDoc.setCurrency(transaction.getForeignCurrency());
      newConversionRateDoc.setToCurrency(transaction.getCurrency());
      newConversionRateDoc.setRate(transaction.getForeignConversionRate());
      newConversionRateDoc.setForeignAmount(transaction.getForeignAmount());
      newConversionRateDoc.setFinancialAccountTransaction(OBDal.getInstance().get(
          APRM_FinaccTransactionV.class, transaction.getId()));
      OBDal.getInstance().save(newConversionRateDoc);
      OBDal.getInstance().flush();
      return newConversionRateDoc;
    } finally {
      OBContext.restorePreviousMode();
    }
  }

  public boolean getDocumentConfirmation(ConnectionProvider conn, String strRecordId) {
    boolean confirmation = false;
    OBContext.setAdminMode();
    try {
      FIN_FinaccTransaction transaction = OBDal.getInstance().get(FIN_FinaccTransaction.class,
          strRecordId);
      List<FIN_FinancialAccountAccounting> accounts = transaction.getAccount()
          .getFINFinancialAccountAcctList();
      FIN_Payment payment = transaction.getFinPayment();
      if (payment != null) {
        OBCriteria<FinAccPaymentMethod> obCriteria = OBDal.getInstance().createCriteria(
            FinAccPaymentMethod.class);
        obCriteria.add(Restrictions.eq(FinAccPaymentMethod.PROPERTY_ACCOUNT,
            transaction.getAccount()));
        obCriteria.add(Restrictions.eq(FinAccPaymentMethod.PROPERTY_PAYMENTMETHOD,
            payment.getPaymentMethod()));
        obCriteria.setFilterOnReadableClients(false);
        obCriteria.setFilterOnReadableOrganization(false);
        List<FinAccPaymentMethod> lines = obCriteria.list();
        for (FIN_FinancialAccountAccounting account : accounts) {
          if (confirmation)
            return confirmation;
          if (payment.isReceipt()) {
            if (("INT").equals(lines.get(0).getUponDepositUse())
                && account.getInTransitPaymentAccountIN() != null)
              confirmation = true;
            else if (("DEP").equals(lines.get(0).getUponDepositUse())
                && account.getDepositAccount() != null)
              confirmation = true;
            else if (("CLE").equals(lines.get(0).getUponDepositUse())
                && account.getClearedPaymentAccount() != null)
              confirmation = true;

            else if (null == (lines.get(0).getUponDepositUse())
                && null == (lines.get(0).getINUponClearingUse())
                && transaction.getAccount() != payment.getAccount()) {
              confirmation = true;
            }
          } else {
            if (("INT").equals(lines.get(0).getUponWithdrawalUse())
                && account.getFINOutIntransitAcct() != null)
              confirmation = true;
            else if (("WIT").equals(lines.get(0).getUponWithdrawalUse())
                && account.getWithdrawalAccount() != null)
              confirmation = true;
            else if (("CLE").equals(lines.get(0).getUponWithdrawalUse())
                && account.getClearedPaymentAccountOUT() != null)
              confirmation = true;
          }
        }

      } else {
        for (FIN_FinancialAccountAccounting account : accounts) {
          if (confirmation)
            return confirmation;
          if ((TRXTYPE_BPDeposit.equals(transaction.getTransactionType()) && account
              .getDepositAccount() != null)
              || (TRXTYPE_BPWithdrawal.equals(transaction.getTransactionType()) && account
                  .getWithdrawalAccount() != null)
              || (TRXTYPE_BankFee.equals(transaction.getTransactionType()) && account
                  .getWithdrawalAccount() != null))
            confirmation = true;
        }
      }
    } catch (Exception e) {
      return confirmation;
    } finally {
      OBContext.restorePreviousMode();
    }
    return confirmation;
  }
  
  private String getPrinterPreference(ConnectionProvider connectionProvider) throws ServletException {
    
    String strSql = "";
    strSql = strSql + "SELECT COALESCE((SELECT value \n"
        + "FROM ad_preference \n"
        + "WHERE property = 'SQB_PrintReceipt' \n"
        + "AND ad_module_id IS NULL \n"
        + "AND created = ( \n"
        + "   SELECT MAX(created) FROM ad_preference \n"
        + "   WHERE property = 'SQB_PrintReceipt' AND ad_module_id IS NULL) \n"
        + "),'Y') as preference \n";    

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    try {
      st = connectionProvider.getPreparedStatement(strSql);

      result = st.executeQuery();
      if (result.next()) {
        strReturn = UtilSql.getValue(result, "preference");
      }
      result.close();
      st.close();
    } catch (SQLException e) {
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@"
          + e.getMessage());
    } catch (Exception ex) {
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
        connectionProvider.destroy();
      } catch (Exception ignore) {
        ignore.printStackTrace();
      }
    }
    return (strReturn);
  } 
  
  private static void updateInvoiceNumber(String invoice_id, String sqb_quickbilling_id) {
    
    ConnectionProvider conn = new DalConnectionProvider(false);
    String strSql = "UPDATE sqb_quickbilling SET c_invoice_id = '"+invoice_id+"' WHERE sqb_quickbilling_id = '" + sqb_quickbilling_id + "'";    

    int updateCount = 0;
    PreparedStatement st = null;

    try {
      st = conn.getPreparedStatement(strSql);
      updateCount = st.executeUpdate();
      st.close();
    } catch (Exception e) {
      //logger.logln("Hubo Errores en la ejecucion de la funcion de reservas fuera de tiempo." + e.getMessage());
    } finally {
      try {
        conn.releasePreparedStatement(st);
        conn.destroy();
      } catch (Exception e) {
      }
    }
  }

}
