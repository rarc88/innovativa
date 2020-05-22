package ec.com.sidesoft.ws.invoicecreate.webservices.setinvoiceweb;

import java.io.InputStreamReader;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.criterion.Restrictions;
import org.openbravo.advpaymentmngt.dao.AdvPaymentMngtDao;
import org.openbravo.advpaymentmngt.dao.TransactionsDao;
import org.openbravo.advpaymentmngt.process.FIN_AddPayment;
import org.openbravo.advpaymentmngt.utility.FIN_Utility;
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
import org.openbravo.mobile.core.utils.OBMOBCUtils;
import org.openbravo.model.ad.utility.Sequence;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.businesspartner.Location;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.uom.UOM;
import org.openbravo.model.financialmgmt.payment.FIN_FinaccTransaction;
import org.openbravo.model.financialmgmt.payment.FIN_FinancialAccount;
import org.openbravo.model.financialmgmt.payment.FIN_Payment;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentDetail;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentMethod;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentSchedule;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentScheduleDetail;
import org.openbravo.model.financialmgmt.payment.FinAccPaymentMethod;
import org.openbravo.model.financialmgmt.payment.PaymentTerm;
import org.openbravo.model.financialmgmt.tax.TaxRate;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.common.invoice.InvoiceLine;
import org.openbravo.model.common.invoice.InvoiceTax;
import org.openbravo.model.pricing.pricelist.PriceList;
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.service.db.DbUtility;
import org.openbravo.service.web.WebService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.accounting.FIN_FinancialAccountAccounting;
import org.openbravo.model.financialmgmt.accounting.UserDimension1;
import org.openbravo.model.financialmgmt.accounting.UserDimension2;

import ec.com.sidesoft.ws.invoicecreate.data.SWSICConfig;
import ec.com.sidesoft.ws.invoicecreate.data.SWSICLogs;
import ec.com.sidesoft.ws.invoicecreate.webservices.util.ResponseWS;


public class InvoiceWebWS implements WebService {

  private static final Logger logger = Logger.getLogger(InvoiceWebWS.class);
  private static final long serialVersionUID = 1L;
  private static final ConnectionProvider connectionProvider = new DalConnectionProvider(false);
  private String strDocumentnoPaymentIn;
  private static Organization org;
  private static SWSICConfig utilConfig;
  private String strFinPaymentScheduleDetailID = "";
  ConnectionProvider cnn_insert2;

  @Override
  public void doPost(String path, HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    JsonElement element = new JsonParser().parse(new InputStreamReader(request.getInputStream()));
    JsonObject jsonInvoice = element.getAsJsonObject();
    JsonObject dataFactura = jsonInvoice.getAsJsonObject("data");
    ResponseWS responseWS = insertSalesInvoice(dataFactura);

    final String json = getResponse(responseWS);
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    final Writer w = response.getWriter();
    w.write(json);
    w.close();
  }

  @Override
  public void doDelete(String path, HttpServletRequest request, HttpServletResponse response)
      throws Exception {
  }

  @Override
  public void doPut(String path, HttpServletRequest request, HttpServletResponse response)
      throws Exception {
  }

  @Override
  public void doGet(String path, HttpServletRequest request, HttpServletResponse response)
      throws Exception {
  }

  public ResponseWS insertSalesInvoice(JsonObject dataFactura) throws JSONException {
    String documentNo = null;
    ResponseWS responseWS = new ResponseWS();
    
    try {
      
      // ORGANIZACION DEL PEDIDO
      String strOrgId = null;
      strOrgId = dataFactura.get("org_ob").getAsString();
      if (strOrgId == null || strOrgId.equals("")) {
        throw new OBException("El campo organizacion no debe estar vacio");
      }
      
      org = OBDal.getInstance().get(Organization.class, strOrgId);
      if (org == null) {
        throw new OBException("No existe la organizacion");
      }
      
      utilConfig = getConfig();
      if (utilConfig == null) {
        throw new OBException(
            "No existe una configuracion definida para la organizacion " + org.getName());
      }
      
      // TIPO DE DOCUMENTO DEL PEDIDO
      DocumentType docType = utilConfig.getDoctype();
      
      // FECHA DE FACTURA
      Date invoiceDate = new Date();
            
      // NUMERO DE DOCUMENTO DEL PEDIDO
      documentNo = Utility.getDocumentNo(OBDal.getInstance().getConnection(false),
          new DalConnectionProvider(), RequestContext.get().getVariablesSecureApp(), "",
          Invoice.TABLE_NAME, docType.getId(), docType.getId(), false, true);
      
      // METODO DE PAGO DEL PEDIDO
      FIN_PaymentMethod payMet = utilConfig.getFINPaymentmethod();
      if (payMet == null) {
        throw new OBException("Debe agregar el metodo de pago en la configuracion");
      }
      
      // TERCERO
      BusinessPartner bp = null;
      BusinessPartner bpOB = null;
      String strIdCustomer = dataFactura.get("customer_invoice_id").getAsString();
      if (strIdCustomer == null || strIdCustomer.equals("")) {
        throw new OBException("El campo Id del cliente no puede estar vacio");
      }
      
      bp = getBpartner(strIdCustomer);
      if (bp == null) {
        //SE CREA UN TERCERO SI NO EXISTE EN OB Y TAMPOCO ES CONSUMIDOR FINAL
        String strNameCustomer = dataFactura.get("customer_name").getAsString();
        String strPhoneCustomer = dataFactura.get("customer_phone").getAsString();
        String strEmailCustomer = dataFactura.get("customer_email").getAsString();
        String strDireccion = getSmartAddress(dataFactura.get("customer_address").getAsString());;
        String strDireccionReferenciaObs = getReference(dataFactura.get("customer_address").getAsString());;
        bpOB = createBpartner(strIdCustomer,utilConfig,strDireccion,strNameCustomer,strPhoneCustomer, strDireccionReferenciaObs, strEmailCustomer,payMet);
        if (bpOB == null) {
          throw new OBException("No existe un tercero con el codigo tax id: " + strIdCustomer);   
        }else {
          bp = bpOB;
        }
      }
      bp.getBusinessPartnerLocationList();  
      
      // DIRECCION DEL TERCERO
      Location bpAddress = getBpAddress(bp.getBusinessPartnerLocationList());
      if (bpAddress == null) {
        throw new OBException("El terceror " + bp.getName() + " no tiene definida una direccion");
      }
      
      // MONEDA DEL PEDIDO
      Currency currency = null;
      currency = utilConfig.getCurrency();
      
      // TERMINO DE PAGO
      PaymentTerm payTerms = utilConfig.getPaymentterm();
      if (payTerms == null) {
        throw new OBException("Debe agregar el termino de pago en la configuracion");
      }

      // LISTA DE PRECIOS
      PriceList priceList = utilConfig.getPricelist();
      if (priceList == null) {
        throw new OBException("Debe configurar una price list en la configuracion");
      }
          
      // CENTRO DE COSTO
      Costcenter costCenter = null; 
      costCenter = utilConfig.getCostcenter();
      if (costCenter == null) {
        throw new OBException("Debe configurar un centro de costo en la configuracion");
      }
      
      // USER 1
      UserDimension1 user1 = null; 
      user1 = utilConfig.getUser1();
      if (user1 == null) {
        throw new OBException("Debe configurar user1 en la configuracion");
      }
      
      // USER 2
      UserDimension2 user2 = null; 
      user2 = utilConfig.getUser2();
      if (user2 == null) {
        throw new OBException("Debe configurar user2 en la configuracion");
      }
      
      // DESCRIPCION DE LA FACTURA DE VENTA
      String strDescripcion = "Factura de Venta WS Nro " + documentNo + " \n" + utilConfig.getDescription();
      
      // CREANDO INSTANCIA DE LA FACTURA
      Invoice newInvoice = OBProvider.getInstance().get(Invoice.class);
      newInvoice.setInvoiceDate(invoiceDate);
      newInvoice.setAccountingDate(invoiceDate);
      newInvoice.setDocumentType(docType);
      newInvoice.setTransactionDocument(docType);
      newInvoice.setDocumentNo(documentNo);
      newInvoice.setDescription(strDescripcion);
      newInvoice.setBusinessPartner(bp);
      newInvoice.setPartnerAddress(bpAddress);
      newInvoice.setPriceList(priceList);
      newInvoice.setCurrency(currency);
      newInvoice.setPaymentMethod(payMet);
      newInvoice.setPaymentTerms(payTerms);
      newInvoice.setCostcenter(costCenter);
      newInvoice.setStDimension(user1);
      newInvoice.setNdDimension(user2);          
      newInvoice.setDocumentStatus("DR");
      newInvoice.setDocumentAction("CO");
      newInvoice.setProcessed(false);
      newInvoice.setPosted("N");
      newInvoice.setPrintDiscount(false);
      newInvoice.setSalesTransaction(true);
      newInvoice.setFormOfPayment("P");
      newInvoice.setSummedLineAmount(BigDecimal.ZERO);
      newInvoice.setGrandTotalAmount(BigDecimal.ZERO);
      OBDal.getInstance().save(newInvoice);
      OBDal.getInstance().flush();
      
      // ***********************************************      
      // INICIO VALIDACIONES DE LOS VALORES RESUMIDOS
      // ***********************************************
      String discountInvoice = null;
      BigDecimal discountInvoiceAmt = BigDecimal.ZERO;
      discountInvoice = dataFactura.get("discount").getAsString();
      if (discountInvoice == null || discountInvoice.equals("")) {
        throw new OBException("El campo descuento no puede estar vacio");
      }else {
        discountInvoiceAmt = new BigDecimal(discountInvoice);
      }

      String serviceTaxInvoice = null;
      BigDecimal serviceTaxInvoiceAmt = BigDecimal.ZERO;
      serviceTaxInvoice = dataFactura.get("service").getAsString();
      if (serviceTaxInvoice == null || serviceTaxInvoice.equals("")) {
        throw new OBException("El campo service no puede estar vacio");
      }else {
        serviceTaxInvoiceAmt = new BigDecimal(serviceTaxInvoice);
      }

      String ivaTaxInvoice = null;
      BigDecimal ivaTaxInvoiceAmt = BigDecimal.ZERO;
      ivaTaxInvoice = dataFactura.get("taxes").getAsString();
      if (ivaTaxInvoice == null || ivaTaxInvoice.equals("")) {
        throw new OBException("El campo taxes no puede estar vacio");
      }else {
        ivaTaxInvoiceAmt = new BigDecimal(ivaTaxInvoice);
      }

      String subtotalInvoice = null;
      BigDecimal subtotalInvoiceAmt = BigDecimal.ZERO;
      subtotalInvoice = dataFactura.get("subtotal").getAsString();
      if (subtotalInvoice == null || subtotalInvoice.equals("")) {
        throw new OBException("El campo subtotal no puede estar vacio");
      }else {
        subtotalInvoiceAmt = new BigDecimal(subtotalInvoice);
      }

      String totalInvoiceResume  = null;
      BigDecimal totalInvoiceResumeAmt = BigDecimal.ZERO;
      totalInvoiceResume = dataFactura.get("total").getAsString();
      if (totalInvoiceResume == null || totalInvoiceResume.equals("")) {
        throw new OBException("El campo total no puede estar vacio");
      }else {
        totalInvoiceResumeAmt = new BigDecimal(totalInvoiceResume);
      }
      
      // VALIDACIONES SUMATORIA SUBTOAL + IVA12 + SERVICIO - DESCUENTOS DEBE SER IGUAL AL TOTAL
      BigDecimal sumResume = subtotalInvoiceAmt.add(ivaTaxInvoiceAmt).add(serviceTaxInvoiceAmt);
      sumResume = sumResume.subtract(discountInvoiceAmt);
      
      if(!totalInvoiceResumeAmt.equals(sumResume)) {
        throw new OBException("Total General " + totalInvoiceResumeAmt + " no coincide con la operacion [ ( subtotal + servicio + impuesto ) - descuentos ] " + sumResume);
      }
      
      JsonArray lineasFactura = dataFactura.get("line_items").getAsJsonArray();
      if(lineasFactura.size() > 0) {
        
        // VALIDACIONES SUMATORIA DE LOS ITEMS DEBE DE SER IGUAL AL SUBTOTAL GENERAL
        validateSumItems(lineasFactura, subtotalInvoiceAmt, newInvoice, discountInvoiceAmt);
        
        // SUMATORIA DE LOS DESCUENTOS ITEM DEBE SER IGUAL AL DESCUENTO GENERAL
        validateSumItemsDiscounts(lineasFactura, discountInvoiceAmt, newInvoice);        
        
      }else {
        throw new OBException("La Factura de venta no tiene lineas.");
      }
      
      // VALIDACIONES SUMATORIA DE LOS METODOS DE PAGO DEBE DE SER IGUAL AL TOTAL
      JsonArray lineasPagos = dataFactura.get("payments").getAsJsonArray();
      if(lineasPagos.size() > 0) {
        validateSumPaymentMethods(lineasPagos, totalInvoiceResumeAmt, newInvoice);
      }else {
        throw new OBException("La Factura de venta no tiene metodos de pagos asignados");
      }  
    
      // ***********************************************
      // FIN VALIDACIONES DE LOS VALORES RESUMIDOS
      // ***********************************************  

      try {
        // Revisar si el módulo de presupuesto esta instalado
        ConnectionProvider cnn_up_budget = new DalConnectionProvider(true);

        update_Field_Budget(cnn_up_budget, newInvoice.getId());
        update_budget_area(cnn_up_budget, newInvoice.getId(),utilConfig.getId());
        
      } catch (ServletException e1) {
        e1.printStackTrace();
        throw new OBException(e1.getMessage());
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

      // INSERTAR LINEAS DE LAS FACTURAS        
      long numLine = 10;
      for (JsonElement lineOption : lineasFactura) {
        JsonObject lineObj = lineOption.getAsJsonObject();
        insertLineSalesInvoice(numLine, lineObj, newInvoice);        
        numLine = numLine + 10;
      }        
      
      // INSERTAR LINEA IMPUESTO DE SERVICIO
      String strService = dataFactura.get("service").getAsString();
      BigDecimal service = new BigDecimal(strService);
      if(service.compareTo(BigDecimal.ZERO) > 0) {
        insertServiceTaxes(service, newInvoice, subtotalInvoiceAmt);
      }
      
      String strIva0 = dataFactura.get("base_0").getAsString();
      BigDecimal iva0 = new BigDecimal(strIva0);
      if(iva0.compareTo( BigDecimal.ZERO) > 1) {
        System.out.println("Inserto iva 0% " + iva0);
      }  
    
      //PROCESO QUE COMPLETA LA FACTURA
      String strMessage = ExecuteCompleteInvoice(newInvoice.getId());
      if (strMessage.equals("OK")) {
        
        OBDal.getInstance().commitAndClose();

        /*try {
          // Revisar si el módulo de presupuesto esta instalado
          ConnectionProvider cnn_up_budget = new DalConnectionProvider(true);

          update_Field_Budget(cnn_up_budget, newInvoice.getId());
          update_budget_area(cnn_up_budget, newInvoice.getId(),utilConfig.getId());
          
        } catch (ServletException e1) {
          e1.printStackTrace();
          throw new OBException(e1.getMessage());
        }    */    
        
        // INSERTO LOS METODOS DE PAGOS
        long numLinePayment = 10;
        for (JsonElement lineOptionPayment : lineasPagos) {
          JsonObject lineObjPayment = lineOptionPayment.getAsJsonObject();
          insertPaymentMethods(numLinePayment, lineObjPayment, newInvoice, bp);
          numLinePayment = numLinePayment + 10;
        }          

        String gandTotal = getGrandTotal(newInvoice.getId());
        BigDecimal totalInvoice;
        if(gandTotal != null) {
          totalInvoice = new BigDecimal(gandTotal);
        }else {
          totalInvoice = new BigDecimal("0");
        }
        
        try {
          UpdateInvoicePaid(newInvoice.getId(), totalInvoice);
        } catch (ServletException e) {
          logger.error("Exception:" + e);
        }

        try {
          UpdateInvoiceSchedulePaid(newInvoice.getId(), totalInvoice);
        } catch (ServletException e) {
          logger.error("Exception:" + e);
        }
        
        try {
          if (!strFinPaymentScheduleDetailID.equals("")
              || !strFinPaymentScheduleDetailID.equals(null))
            DeleteInvoiceSchedulePaid(strFinPaymentScheduleDetailID);
        } catch (ServletException e) {
          logger.error("Exception:" + e);
        }
        
        OBDal.getInstance().commitAndClose();
        
      }else {
        throw new OBException("No se pudo completar la factura");
      }
      
      responseWS.setDocumentNo(documentNo);
      responseWS.setStatus("OK");
      responseWS.setMessage("La factura de venta fue creada exitosamente");
      
      saveLogWeb(dataFactura,utilConfig,newInvoice);
      
    } catch (OBException e) {
      String errorMsg = null;
      logger.error("Error al procesar transaccion" + e.getMessage(), e);
      OBDal.getInstance().rollbackAndClose();
      Throwable ex = DbUtility.getUnderlyingSQLException(e);
      if (ex.getMessage() != null) {
        errorMsg = "Error al insertar cabecera de la factura, " + ex.getMessage();
      } else if (e.getMessage() != null) {
        errorMsg = "Error al insertar cabecera de la factura, " + e.getMessage();
      } else {
        errorMsg = "Error al insertar cabecera de la factura, Error no tipificado por el sistema, revise la data enviada.";
      }

      responseWS.setDocumentNo("N/A");
      responseWS.setStatus("ERROR");
      responseWS.setMessage(errorMsg);

      return responseWS;
    }

    return responseWS;
  }
  
  private void validateSumItems(JsonArray lineasFactura, BigDecimal subtotalInvoiceAmt, Invoice newInvoice, BigDecimal discountInvoiceAmt) {
    
    BigDecimal sumItems = BigDecimal.ZERO;
    int stdPrecision = newInvoice.getCurrency().getStandardPrecision().intValue();
    for (JsonElement lineOption : lineasFactura) {
      JsonObject lineObj = lineOption.getAsJsonObject();
      // CANTIDAD VENDIDA
      BigDecimal qty = null;
      String strQty = lineObj.get("quantity").getAsString();
      if (strQty == null || strQty.equals("")) {
        throw new OBException("El campo cantidad en line_items no puede estar vacio");
      } else {
          qty = new BigDecimal(strQty);
      }
      
      BigDecimal price = null;
      String strLineNetAmt = lineObj.get("price").getAsString();
      
      if (strLineNetAmt == null || strLineNetAmt.equals("")) {
        throw new OBException("El campo precio en line_items no puede estar vacio");
      }
      price = new BigDecimal(strLineNetAmt);

      BigDecimal lineNetAmount = qty.multiply(price).setScale(stdPrecision, RoundingMode.HALF_UP);
      String strDiscount = null;
      strDiscount = lineObj.get("discount").getAsString();
      if (strDiscount == null || strDiscount.equals("")) {
        throw new OBException("El campo discount en line_items no puede estar vacio");
      }
      BigDecimal discountLine = new BigDecimal(strDiscount);
      
      if(discountLine.compareTo(BigDecimal.ZERO) > 0) {
        lineNetAmount = lineNetAmount.subtract(discountLine);
      }
      
      sumItems = sumItems.add(lineNetAmount);
      
    }
    
    if(!sumItems.equals(subtotalInvoiceAmt.subtract(discountInvoiceAmt))) {
      throw new OBException("Subtotal General " + subtotalInvoiceAmt.subtract(discountInvoiceAmt) +" no conincide con la sumatoria de los items de las lineas " + sumItems);
    }
    
  }
  
  private void validateSumItemsDiscounts(JsonArray lineasFactura, BigDecimal discountInvoiceAmt, Invoice newInvoice) {
    
    int stdPrecision = newInvoice.getCurrency().getStandardPrecision().intValue();
    BigDecimal sumItemsDiscount = BigDecimal.ZERO;
    for (JsonElement lineOption : lineasFactura) {
      JsonObject lineObj = lineOption.getAsJsonObject();
      
      String strDiscount = null;
      strDiscount = lineObj.get("discount").getAsString();
      if (strDiscount == null || strDiscount.equals("")) {
        throw new OBException("El campo discount en las lineas no puede estar vacio");
      }
      BigDecimal discountLine = new BigDecimal(strDiscount).setScale(stdPrecision, RoundingMode.HALF_UP);      
      sumItemsDiscount = sumItemsDiscount.add(discountLine).setScale(stdPrecision, RoundingMode.HALF_UP);
      
    }

    if(!sumItemsDiscount.equals(discountInvoiceAmt.setScale(stdPrecision, RoundingMode.HALF_UP))) {
      throw new OBException("Descuento General " + discountInvoiceAmt +" no conincide con la sumatoria de los descuentos de las lineas " + sumItemsDiscount);
    }

  }
  
  private void validateSumPaymentMethods(JsonArray lineasPagos, BigDecimal totalInvoiceResumeAmt,
  Invoice newInvoice) {

    BigDecimal sumPaymentsMethods = BigDecimal.ZERO;
    int stdPrecision = newInvoice.getCurrency().getStandardPrecision().intValue();
    for (JsonElement lineOption : lineasPagos) {

      JsonObject lineObj = lineOption.getAsJsonObject();

      BigDecimal amount = null;
      String strAmount = null;
      strAmount = lineObj.get("amount").getAsString();
      if (strAmount == null || strAmount.equals("")) {
        throw new OBException("El campo amount en payments no puede estar vacio");
      } else {
        amount = new BigDecimal(strAmount).setScale(stdPrecision, RoundingMode.HALF_UP);
      }

      sumPaymentsMethods = sumPaymentsMethods.add(amount).setScale(stdPrecision, RoundingMode.HALF_UP);

    }

    if(!totalInvoiceResumeAmt.equals(sumPaymentsMethods)) {
      throw new OBException("Total General " + totalInvoiceResumeAmt +" no conincide con la sumatoria de los montos de los métodos de pago " + sumPaymentsMethods);
    }

  }

  private void insertLineSalesInvoice(long numLine, JsonObject lineObj, Invoice newInvoice){
    
    String strProductId = lineObj.get("product_id").getAsString();
    String strTaxId = lineObj.get("tax_id").getAsString();
    
    // PRODUCTO DE LA LINEA
    Product product = OBDal.getInstance().get(Product.class, strProductId);
    
    // IMPUESTO DE LA LINEA
    TaxRate taxRate = OBDal.getInstance().get(TaxRate.class, strTaxId);
    
    // CANTIDAD VENDIDA
    BigDecimal qty = null;
    String strQty = lineObj.get("quantity").getAsString();
    qty = new BigDecimal(strQty);

    // UNIDAD DEL PRODUCTO
    UOM uom = OBDal.getInstance().get(UOM.class,product.getUOM().getId());
    
    // PRECIO
    int stdPrecision = newInvoice.getCurrency().getStandardPrecision().intValue();
    BigDecimal price = null;
    String strLineNetAmt = lineObj.get("price").getAsString();
    price = new BigDecimal(strLineNetAmt);
    
    // MONTO NETO DE LA LINEA
    BigDecimal lineNetAmount = qty.multiply(price).setScale(stdPrecision, RoundingMode.HALF_UP); 
    
    // DESCUENTO DE LA LINEA
    String strDiscount = null;
    strDiscount = lineObj.get("discount").getAsString();
    BigDecimal discountLine = new BigDecimal(strDiscount).setScale(stdPrecision, RoundingMode.HALF_UP);
    
    if(discountLine.compareTo(BigDecimal.ZERO) > 0) {
      lineNetAmount = lineNetAmount.subtract(discountLine).setScale(stdPrecision, RoundingMode.HALF_UP);
    }    

    InvoiceLine newInvoiceLine = OBProvider.getInstance().get(InvoiceLine.class);
    newInvoiceLine.setInvoice(newInvoice);
    newInvoiceLine.setLineNo(numLine);
    newInvoiceLine.setProduct(product);
    newInvoiceLine.setTax(taxRate);
    newInvoiceLine.setUOM(uom);
    newInvoiceLine.setLineNetAmount(lineNetAmount);
    newInvoiceLine.setListPrice(price);
    newInvoiceLine.setUnitPrice(price);
    newInvoiceLine.setPriceLimit(price);
    newInvoiceLine.setStandardPrice(price);
    newInvoiceLine.setInvoicedQuantity(qty);
    OBDal.getInstance().save(newInvoiceLine);
    OBDal.getInstance().flush();
    
    update_budgetline(connectionProvider, newInvoiceLine, newInvoice);

  }

  private void insertServiceTaxes(BigDecimal service, Invoice newInvoice, BigDecimal subtotal) {
   
    TaxRate tax = utilConfig.getTAXService();
    int pricePrecision = utilConfig.getCurrency().getPricePrecision().intValue(); 

    InvoiceTax invoiceTax = OBProvider.getInstance().get(InvoiceTax.class);
    invoiceTax.setTax(tax);    
    // BASE IMPONIBLE
    invoiceTax.setTaxableAmount(subtotal);
    // IMPUESTO
    invoiceTax.setTaxAmount(service.setScale(pricePrecision, RoundingMode.HALF_UP));
    invoiceTax.setInvoice(newInvoice);
    invoiceTax.setLineNo((long) 20);
    invoiceTax.setRecalculate(true);
    invoiceTax.setId(
        OBMOBCUtils.getUUIDbyString(invoiceTax.getInvoice().getId() + invoiceTax.getLineNo()));
    invoiceTax.setNewOBObject(true);
    newInvoice.getInvoiceTaxList().add(invoiceTax);
    updateGrandTotal(newInvoice.getId(), service);
    OBDal.getInstance().save(invoiceTax);
    OBDal.getInstance().flush();
    
  }

  private String ExecuteCompleteInvoice(String strInvoiceID) {
    try {
      org.openbravo.database.ConnectionProvider cp = new DalConnectionProvider(false);
      CallableStatement cs = cp.getConnection().prepareCall("{call C_INVOICE_POST(?,?)}");

      cs.setString(1, null);
      cs.setString(2, strInvoiceID);
      cs.execute();
      cs.close();
      return "OK";
    } catch (Exception e) {
      return e.getMessage().toString();
    }

  }

  private SWSICConfig getConfig() {
    SWSICConfig config = null;

    OBCriteria<SWSICConfig> cfgCrt = OBDal.getInstance().createCriteria(SWSICConfig.class);
    cfgCrt.add(Restrictions.eq(SWSICConfig.PROPERTY_ORGANIZATION, org));
    config = (SWSICConfig) cfgCrt.uniqueResult();

    return config;
  }
  
  private static String getGrandTotal(String invoice_id) {
    ConnectionProvider conn = new DalConnectionProvider(false);
    String strResult = null;
    try {

      String strSql = "SELECT grandtotal FROM c_invoice WHERE c_invoice_id = '" + invoice_id + "'";
      PreparedStatement st = null;

      st = conn.getPreparedStatement(strSql);
      ResultSet rsConsulta = st.executeQuery();

      while (rsConsulta.next()) {
        strResult = rsConsulta.getString("grandtotal");
      }

      return strResult;

    } catch (Exception e) {
      throw new OBException("Error al consultar el grandtotal del pedido. " + e.getMessage());
    }

  }
  
  private static void updateGrandTotal(String invoice_id, BigDecimal service) {
    
    ConnectionProvider conn = new DalConnectionProvider(false);
    String strSql = "UPDATE c_invoice SET grandtotal = (grandtotal + "+service+" ) WHERE c_invoice_id = '" + invoice_id + "'";    

    int updateCount = 0;
    PreparedStatement st = null;

    try {
      st = conn.getPreparedStatement(strSql);
      updateCount = st.executeUpdate();
      st.close();
    } catch (Exception e) {
      logger.error("Hubo Errores en la ejecucion de la funcion de reservas fuera de tiempo." + e.getMessage());
    } finally {
      try {
        conn.destroy();
      } catch (Exception e) {
      }
    }
  }
  
  private BusinessPartner getBpartner(String taxID) {
    BusinessPartner bp = null;

    OBCriteria<BusinessPartner> cfgCrt = OBDal.getInstance().createCriteria(BusinessPartner.class);
    cfgCrt.add(Restrictions.eq(BusinessPartner.PROPERTY_TAXID, taxID));
    bp = (BusinessPartner) cfgCrt.uniqueResult();

    return bp;
  }
  
  private BusinessPartner createBpartner(String taxID, SWSICConfig config, String direccion, String nombre, String telefono, String referencia, String correo, FIN_PaymentMethod payMet) {
          
    BusinessPartner bp = null;

    String typeTaxID;
    
    UUID uuid = UUID.randomUUID();
    String randomUUIDString = uuid.toString().replaceAll("-", "").toUpperCase();
    
    Integer sizeTaxID = taxID.length();
    if(sizeTaxID == 13) {
            typeTaxID = "R";
    }else {
            typeTaxID = "D";
    }

    String strSqlBPartner = null;

    strSqlBPartner = "INSERT INTO c_bpartner(\n"
        + "            c_bpartner_id, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, \n"
        + "            CREATED, CREATEDBY, UPDATED, UPDATEDBY, VALUE, NAME, NAME2, TAXID,  \n"
        + "            EM_SSWH_TAXPAYER_ID, EM_SSWH_TAXIDTYPE, C_BP_GROUP_ID, AD_LANGUAGE,"
        + "            m_pricelist_id,BP_Currency_ID, EM_EEI_Eeioice,"
        + "            EM_EEI_Email,EM_Eei_Portal_Pass, C_PaymentTerm_ID, FIN_Paymentmethod_ID)\n"
        + "    VALUES (?, ?, ?, 'Y', \n"
        + "             NOW(), ?, NOW(), ?, ?, ?, ?, ?, \n"
        + "             ?, ?, ?, ?, ?, ?, 'Y', ?, ?, ?, ?)";
    
    int updateCount = 0;
    PreparedStatement st = null;
    
    try {
      st = connectionProvider.getPreparedStatement(strSqlBPartner);
      
      st.setString(1, randomUUIDString);
      st.setString(2, config.getClient().getId());
      st.setString(3, "0");
      st.setString(4, config.getCreatedBy().getId());
      st.setString(5, config.getCreatedBy().getId());
      st.setString(6, taxID);
      st.setString(7, nombre.toUpperCase());
      st.setString(8, nombre.toUpperCase());
      st.setString(9, taxID);
      st.setString(10, config.getSswhTaxpayer().getId());
      st.setString(11, typeTaxID);
      st.setString(12, config.getBpGroup().getId());
      st.setString(13, config.getLanguage().getLanguage());
      st.setString(14, config.getPricelist().getId());
      st.setString(15, config.getCurrency().getId());
      st.setString(16, correo);
      st.setString(17, taxID);
      st.setString(18, config.getPaymentterm().getId());
      st.setString(19, config.getFINPaymentmethod().getId());
      
      updateCount = st.executeUpdate();
      if (updateCount > 0) {
        createLocGeo(randomUUIDString,config,direccion, telefono, referencia, nombre.toUpperCase(), correo);
        OBCriteria<BusinessPartner> cfgCrt = OBDal.getInstance().createCriteria(BusinessPartner.class);
        cfgCrt.add(Restrictions.eq(BusinessPartner.PROPERTY_TAXID, taxID));
        bp = (BusinessPartner) cfgCrt.uniqueResult();
      }
      
      st.close();
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch (Exception ignore) {
        System.out.println(ignore.getMessage());
        ignore.printStackTrace();
      }
    }           
        
    return bp;
  } 
  
  private void createLocGeo(String c_bpartner_id, SWSICConfig config, String direccion, String telefono,String referencia, String nombre, String correo) {

    UUID uuidLocation = UUID.randomUUID();
    String randomUUIDStringLocation = uuidLocation.toString().replaceAll("-", "").toUpperCase();

    String strSqlLocGeo = null;

    strSqlLocGeo = "INSERT INTO c_location(\n"
        + "            c_location_id, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, \n"
        + "            CREATED, CREATEDBY, UPDATED, UPDATEDBY, address1, address2,c_country_id )  \n"
        + "             VALUES ( ?, ?, ?, 'Y', NOW(), ?, NOW(), ?, ?, ?, ? )";
            
    int updateCount = 0;
    PreparedStatement st = null;
    
    try {
        
      st = connectionProvider.getPreparedStatement(strSqlLocGeo);
      
      st.setString(1, randomUUIDStringLocation);
      st.setString(2, config.getClient().getId());
      //st.setString(3, config.getOrganization().getId());
      st.setString(3, "0");
      st.setString(4, config.getCreatedBy().getId());
      st.setString(5, config.getCreatedBy().getId());
      st.setString(6, direccion);
      st.setString(7, referencia);
      st.setString(8, config.getCountry().getId());
      //st.setString(8, OBDal.getInstance().get(Country.class,"171").getId());

      updateCount = st.executeUpdate();
      if (updateCount > 0) {
        createLocationBPartner(c_bpartner_id,randomUUIDStringLocation, config, telefono, nombre, correo);
      }

      st.close();
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch (Exception ignore) {
        System.out.println(ignore.getMessage());
        ignore.printStackTrace();
      }
    }           
          
  }  
  
  private void createLocationBPartner(String c_bpartner_id, String c_location_id,SWSICConfig config,String telefono, String nombre, String correo) {

    UUID uuidLoc = UUID.randomUUID();
    String randomUUIDStringLoc = uuidLoc.toString().replaceAll("-", "").toUpperCase();
    
    String strSqlLocation = null;

    strSqlLocation = "INSERT INTO c_bpartner_location(\n"
    + "            c_bpartner_location_id, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, \n"
    + "            CREATED, CREATEDBY, UPDATED, UPDATEDBY, name, phone , c_bpartner_id, c_location_id, isbillto, isshipto, ispayfrom, isremitto)\n"
    + "             VALUES ( ? , ? , ? , 'Y' , NOW() , ? , NOW() , ? , ? , ? , ? , ?, 'Y', 'Y', 'Y','Y')";
                
    int updateCount = 0;
    PreparedStatement st = null;
    
    try {
        
      st = connectionProvider.getPreparedStatement(strSqlLocation);
      
      st.setString(1, randomUUIDStringLoc);
      st.setString(2, config.getClient().getId());
      st.setString(3, "0");
      st.setString(4, config.getCreatedBy().getId());
      st.setString(5, config.getCreatedBy().getId());
      st.setString(6, "CONTACTO FACTURA DE VENTA WS");
      st.setString(7, telefono);
      st.setString(8, c_bpartner_id);
      st.setString(9, c_location_id);
      
      updateCount = st.executeUpdate();
      if (updateCount > 0) {
        createContactPersonBPartner(c_bpartner_id,config,telefono, nombre, correo);
      }

      st.close();
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch (Exception ignore) {
        System.out.println(ignore.getMessage());
        ignore.printStackTrace();
      }
    }           
  
  }   
  
  private void createContactPersonBPartner(String c_bpartner_id, SWSICConfig config, String telefono, String nombre, String correo) {

    UUID uuidLoc = UUID.randomUUID();
    String randomUUIDStringContact = uuidLoc.toString().replaceAll("-", "").toUpperCase();

    String strSqlLocation = null;

    strSqlLocation = "INSERT INTO ad_user(\n"
    + "            ad_user_id, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, \n"
    + "            CREATED, CREATEDBY, UPDATED, UPDATEDBY, name, email, phone , c_bpartner_id, EM_Opcrm_Donotcall, username)\n"
    + "             VALUES ( ? , ? , ? , 'Y' , NOW() , ? , NOW() , ? , ? , ?, ?, ?, 'N', ?)";
      

    int updateCount = 0;
    PreparedStatement st = null;

    try {
        
      st = connectionProvider.getPreparedStatement(strSqlLocation);
      
      st.setString(1, randomUUIDStringContact);
      st.setString(2, config.getClient().getId());
      st.setString(3, "0");
      st.setString(4, config.getCreatedBy().getId());
      st.setString(5, config.getCreatedBy().getId());
      st.setString(6, nombre);
      st.setString(7, correo);
      st.setString(8, telefono);
      st.setString(9, c_bpartner_id);
      st.setString(10, nombre);
      
      updateCount = st.executeUpdate();
      if (updateCount > 0) {
        System.out.println("CONTACT PERSON BPARTNER INSERTADA");
      }

      st.close();
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch (Exception ignore) {
        ignore.printStackTrace();
      }
    }           

  }     
  
  private Location getBpAddress(List<Location> addressBp) {
    Location billaddress = null;

    for (Location location : addressBp) {
      if (location.isInvoiceToAddress()) {
        billaddress = location;
      }
    }

    if (billaddress == null && addressBp.size() > 0) {
      billaddress = (Location) addressBp.get(0);
    }

    return billaddress;
  }

  private String getResponse(ResponseWS response) {
    Gson gson = new Gson();
    String json = gson.toJson(response);
    return json;
  }
  
  private String getSmartAddress(String direccion) {
    String[] arraySmartAddress = direccion.split("\\|");
    String strDireccion = arraySmartAddress[0] + " " + arraySmartAddress[1] + " y "
        + arraySmartAddress[2];
    return strDireccion;
  }
  
  private String getReference(String direccion) {
    String[] arraySmartAddress = direccion.split("\\|");
    String strContactDelivery = arraySmartAddress[3];
    return strContactDelivery;
  }    
 
  private void insertPaymentMethods(long numLinePayment, JsonObject lineObjPayment,
      Invoice newInvoice, BusinessPartner bp) {
    
    String strfinPaymentID = null; 
    strfinPaymentID = lineObjPayment.get("payment_method").getAsString();
    if (strfinPaymentID == null || strfinPaymentID.equals("")) {
      throw new OBException("El campo payment_method no puede estar vacio");
    }

    String strPaymentAmount = null; 
    strPaymentAmount = lineObjPayment.get("amount").getAsString();

    if (strPaymentAmount == null || strPaymentAmount.equals("")) {
      throw new OBException("El campo amount en el metodo de pago no puede estar vacio");
    }    
    BigDecimal paymentAmount = new BigDecimal(strPaymentAmount);

    FIN_PaymentMethod finPaymentMethod = OBDal.getInstance().get(FIN_PaymentMethod.class,
        strfinPaymentID);
    
    String gandTotal = getGrandTotal(newInvoice.getId());
    BigDecimal total;
    BigDecimal zero = new BigDecimal("0");
    
    if(gandTotal != null) {
      total = new BigDecimal(gandTotal);
    }else {
      total = zero;
    }
    
    // NUMERO DE DOCUMENTO DEL PEDIDO
    String strDocReview = utilConfig.getDoctypePaymentIn().getId();

    DocumentType docTypePaymentIn = OBDal.getInstance().get(DocumentType.class,
        strDocReview);
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

    // GESTION Y EJECUCION DEL COBRO
    FIN_Payment newPayment = createPayment(utilConfig.getFINFinancialAccount().getId(),
      strDocumentnoPaymentIn, bp, new Date(), utilConfig.getCurrency(),total, total, 
      String.valueOf(paymentAmount), finPaymentMethod, newInvoice,total);  
    
    try {

      strfinPaymentID = newPayment.getId() == null ? "ND" : newPayment.getId();
      OBDal.getInstance().commitAndClose();

       if (!strfinPaymentID.equals("ND")) {
         insertFin_Transaction(strfinPaymentID, utilConfig.getFINFinancialAccount().getId(),
             String.valueOf(new Date()));
       }

    } catch (OBException e) {
      logger.error("Exception:" + e);
    }
        
  }

  public FIN_Payment createPayment(String strFin_AccountID, String strDocumentno,
      BusinessPartner businessPartner, Date paymentDate, Currency currency,
      BigDecimal exchangeRate, BigDecimal convertedAmount, String strActualPayment,
      FIN_PaymentMethod finPaymentMethod, Invoice newInvoice,
      BigDecimal bgdTotalPaid) {
    
    FIN_Payment payment = OBProvider.getInstance().get(FIN_Payment.class);

    JSONObject jsonResponse = new JSONObject();
    JSONObject jsonparams = null;

    String comingFrom = "TRANSACTION";

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
      payment = createNewPayment(jsonparams_cp, isReceipt, utilConfig.getOrganization(), businessPartner, paymentDate, currency, new BigDecimal("1"),
          convertedAmount, strActualPayment);
      
    } catch (JSONException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
    String strDifferenceAction = "refund";
    BigDecimal differenceAmount = BigDecimal.ZERO;
    BigDecimal paymentLineAmount = new BigDecimal(strActualPayment);

    payment.setAmount(paymentLineAmount);
    payment.setFinancialTransactionAmount(paymentLineAmount);
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
          
          String gandTotal = getGrandTotal(newInvoice.getId());
          BigDecimal total;
          BigDecimal zero = new BigDecimal("0");
          
          if(gandTotal != null) {
            total = new BigDecimal(gandTotal);
          }else {
            total = zero;
          }          

          FPS.setPaidAmount(total);
          FPS.setOutstandingAmount(BigDecimal.ZERO);
          OBDal.getInstance().save(FPS);
          OBDal.getInstance().commitAndClose();
          
          String strNewPD_ID;
          try {
            org.openbravo.database.ConnectionProvider cp = new DalConnectionProvider(false);

            strNewPD_ID = getUUID(cp);
            
            NewPaymentDetail(cp,strNewPD_ID, payment.getId(), paymentLineAmount);
            
            strFinPaymentScheduleDetailID = FPS.getId();

            NewPaymentSchedulDetail(cp,strNewPD_ID, paymentLineAmount, newInvoice.getBusinessPartner()
                .getId(), FPS.getId()); 

            UpdatePayment(cp,strFin_PaymentID, paymentLineAmount, newInvoice.getDocumentNo());
            
          } catch (ServletException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new OBException(e.getMessage());
          }

        } catch (OBException e) {
          OBDal.getInstance().rollbackAndClose();
          logger.error(e.getMessage());
          throw new OBException(e.getMessage());
        }
      }
    }

    if (strAction.equals("PRP") || strAction.equals("PPP") || strAction.equals("PRD")
        || strAction.equals("PPW")) {

      try {
        processPayment(payment, strAction, strDifferenceAction, differenceAmount,
            exchangeRate, jsonparams, comingFrom, newInvoice, bgdTotalPaid);
      } catch (Exception e) {
        e.printStackTrace();
        logger.error(e.getMessage());
        throw new OBException(e.getMessage());
      }

    }
    OBDal.getInstance().flush();

    return payment;

  }
  
  public void NewPaymentDetail(ConnectionProvider cp, String strNewPaymentDetailID,
      String strPaymentID, BigDecimal bgdAmount) throws ServletException {
    String strSql = "";
    strSql = strSql
        + "insert into fin_payment_detail(fin_payment_detail_id, ad_client_id, ad_org_id, isactive, createdby, created, updatedby, updated"
        + ", fin_payment_id, amount,refund,writeoffamt,c_glitem_id,isprepayment) values('"
        + strNewPaymentDetailID + "','" + utilConfig.getClient().getId()
        + "','" + utilConfig.getOrganization().getId() + "','Y','"
        + utilConfig.getUserContact().getId() + "',now(),'"
        + utilConfig.getUserContact().getId() + "',now(),'" + strPaymentID + "',"
        + bgdAmount + ",'N',0,null,'N')";

    int updateCount = 0;
    PreparedStatement st = null;

    try {
      st = cp.getPreparedStatement(strSql);
      updateCount = st.executeUpdate();
      st.close();

    } catch (SQLException e) {
      logger.error(e.getMessage());

    } catch (Exception ex) {
      logger.error(ex.getMessage());

    } finally {
      try {
        cp.releasePreparedStatement(st);
        cp.destroy();
      } catch (Exception ignore) {
        ignore.printStackTrace();
        logger.error(ignore.getMessage());

      }
    }
  }
  
  public void NewPaymentSchedulDetail(ConnectionProvider cp, String strPaymentDetailID, BigDecimal bgdAmount, String strPartnerID,
      String strPaymenSchedulID) throws ServletException {
    String strSql = "";
    strSql = strSql
        + "insert into fin_payment_scheduledetail(fin_payment_scheduledetail_id, ad_client_id, ad_org_id, isactive, createdby, created, updatedby, updated"
        + ", fin_payment_schedule_invoice, amount,writeoffamt,iscanceled,c_bpartner_id,fin_payment_detail_id) values("
        + "get_uuid(),'" + utilConfig.getClient().getId() + "','"
        + utilConfig.getOrganization().getId() + "','Y','"
        + utilConfig.getUserContact().getId() + "',now(),'"
        + utilConfig.getUserContact().getId() + "',now(),'" + strPaymenSchedulID + "',"
        + bgdAmount + ", 0,'N',null,'" + strPaymentDetailID + "')";

    int updateCount = 0;
    PreparedStatement st = null;

    try {
      st = cp.getPreparedStatement(strSql);
      updateCount = st.executeUpdate();
      st.close();

    } catch (SQLException e) {
      logger.error(e.getMessage());
    } catch (Exception ex) {
      logger.error(ex.getMessage());
    } finally {
      try {
        cp.releasePreparedStatement(st);
        cp.destroy();
      } catch (Exception ignore) {
        ignore.printStackTrace();
        logger.error(ignore.getMessage());
      }
    }
  } 
  
  public void UpdatePayment(ConnectionProvider cp, String strPaymentID, BigDecimal bgdAmount, String Documentno) throws ServletException {
    String strSql = "";
    strSql = strSql + "update fin_payment set status = 'RDNC',processed='Y', amount = " + bgdAmount
        + ",finacc_txn_convert_rate=1, c_costcenter_id = '" + utilConfig.getCostcenter().getId() + "' "
        + ",user1_id = '" + utilConfig.getUser1().getId() + "', user2_id = '" + utilConfig.getUser2().getId() + "' "
        + "where fin_payment_id ='" + strPaymentID + "'";
    
    int updateCount = 0;
    PreparedStatement st = null;

    try {
      st = cp.getPreparedStatement(strSql);
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
        cp.releasePreparedStatement(st);
        cp.destroy();
      } catch (Exception ignore) {
        ignore.printStackTrace();
      }
    }
  }
    

  private FIN_Payment createNewPayment(JSONObject jsonparams, boolean isReceipt, Organization org,
      BusinessPartner bPartner, Date paymentDate, Currency currency, BigDecimal conversionRate,
      BigDecimal convertedAmt, String strActualPayment) throws OBException, JSONException,
      SQLException {
    
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

    DocumentType documentType = FIN_Utility.getDocumentType(org, isReceipt ? "ARR" : "APP");
    String strDocBaseType = documentType.getDocumentCategory();

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
      strPaymentDocumentNo = FIN_Utility.getDocumentNo(documentType, "FIN_Payment");
    }

    FIN_Payment payment = (new AdvPaymentMngtDao()).getNewPayment(isReceipt, org, documentType,
        strPaymentDocumentNo, bPartner, paymentMethod, finAccount, strPaymentAmount, paymentDate,
        strReferenceNo, currency, conversionRate, convertedAmt);
    OBDal.getInstance().getConnection(true).commit();
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
  
  public void insertFin_Transaction(String selectedPaymentIds, String strFinancialAccountId,
      String strTransactionDate) {
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
            processTransaction(finTrans, "P", cnn_insert2);
          } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
          }

        }

        if (selectedPaymentIds != null && selectedPayments.size() > 0) {
          strMessage = selectedPayments.size() + " " + "@RowsInserted@";
        }

      }

    } catch (OBException e) {
      System.out.println(e.getMessage());

    } finally {
      OBContext.restorePreviousMode();

    }
  }
  
  private void processPayment(FIN_Payment payments, String strAction,
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
      payment = OBDal.getInstance().get(FIN_Payment.class, payment.getId());
    }

  }
  
  public void processTransaction(FIN_FinaccTransaction transaction, String strAction,
      ConnectionProvider conProvider) {
    try {

      if (strAction.equals("P")) {

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
        transaction.setDateAcct(new Date());
        transaction.setTransactionDate(new Date());
        OBDal.getInstance().save(financialAccount);
        OBDal.getInstance().save(transaction);
        OBDal.getInstance().flush();

        OBDal.getInstance().commitAndClose();
      }

    } catch (OBException e) {
      OBDal.getInstance().rollbackAndClose();
    }

  }
  
  public static void update_Field_Budget(ConnectionProvider cp, String strDocumentno)
      throws ServletException {
    String strSql = "";
    strSql = strSql + " SELECT swsic_partner_update_budget('" + strDocumentno + "') as updatebudget from dual";

    ResultSet result;
    String strReturn = "ND";
    PreparedStatement st = null;

    try {
      st = cp.getPreparedStatement(strSql);

      result = st.executeQuery();
      strReturn = "OK";

      result.close();
      st.close();
    } catch (SQLException e) {
      logger.error("SQL error in query: " + strSql + "Exception:" + e);
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@"
          + e.getMessage());
    } catch (Exception ex) {
      logger.error("Exception in query: " + strSql + "Exception:" + ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        cp.releasePreparedStatement(st);
        cp.destroy();
      } catch (Exception ignore) {
        ignore.printStackTrace();
      }
    }
  }
  
  public static void update_budget_area(ConnectionProvider cp, String strDocumentno, String strConfigId)
      throws OBException {
    String strSql = "";
    strSql = strSql + "SELECT swsic_update_budget_area(?,?) as updatebudgetarea from dual";

    ResultSet result;
    String strReturn = "ND";
    PreparedStatement st = null;

    try {
      st = cp.getPreparedStatement(strSql);
      st.setString(1, strDocumentno);
      st.setString(2, strConfigId);
      result = st.executeQuery();
      strReturn = "OK";

      result.close();
      st.close();
    } catch (SQLException e) {
      logger.error("SQL error in query: " + strSql + "Exception:" + e);
      throw new OBException( e.getMessage());
    } catch (Exception ex) {
      logger.error("Exception in query: " + strSql + "Exception:" + ex);
      throw new OBException(ex.getMessage());
    } finally {
      try {
        cp.releasePreparedStatement(st);
        cp.destroy();
      } catch (Exception ignore) {
        ignore.printStackTrace();
      }
    }
  }  
  
  public void UpdateInvoicePaid(String strInvoiceID, BigDecimal bgdAmount) throws ServletException {
   
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
      logger.error("SQL error in query: " + strSql + "Exception:" + e);
    } catch (Exception ex) {
      logger.error("Exception in query: " + strSql + "Exception:" + ex);
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch (Exception ignore) {
        ignore.printStackTrace();
      }
    }
  }
  
  private void UpdateInvoiceSchedulePaid(String strInvoiceID,BigDecimal bgdAmount) throws ServletException {
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
      logger.error("SQL error in query: " + strSql + "Exception:" + e);
    } catch (Exception ex) {
      logger.error("Exception in query: " + strSql + "Exception:" + ex);
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch (Exception ignore) {
        ignore.printStackTrace();
      }
    }
  }
  
  public void DeleteInvoiceSchedulePaid(String strScheludeDetail) throws ServletException {

    String strSql = "";
    strSql = strSql
        + "delete from fin_payment_scheduledetail where fin_payment_detail_id is null  and fin_payment_schedule_invoice = '"
        + strScheludeDetail + "'";

    int updateCount = 0;
    PreparedStatement st = null;

    try {
      st = connectionProvider.getPreparedStatement(strSql);
      updateCount = st.executeUpdate();
      st.close();

    } catch (SQLException e) {
      logger.error("SQL error in query: " + strSql + "Exception:" + e);
    } catch (Exception ex) {
      logger.error("Exception in query: " + strSql + "Exception:" + ex);
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch (Exception ignore) {
        ignore.printStackTrace();
      }
    }
  }
  
  public static void update_budgetline(ConnectionProvider conn, InvoiceLine invoiceline, Invoice invoice) 
      throws OBException {
    
    String strSql = "";
    strSql = strSql + "SELECT swsic_budget_impact(?,?,?,?,?,?,?,?,?,?) as updatebudgetarea from dual";

    ResultSet result;
    String strReturn = "ND";
    PreparedStatement st = null;
    
    String strDateInvoice = OBDateUtils.formatDate(invoice.getInvoiceDate());
    
    try {
      st = conn.getPreparedStatement(strSql);
      st.setString(1, invoiceline.getProduct().getId());
      st.setString(2, invoice.getCostcenter().getId());
      st.setString(3, invoice.getStDimension().getId());
      st.setString(4, utilConfig.getSwsicbBudgetArea().getId());
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
      throw new OBException( e.getMessage());
    } catch (Exception ex) {
      throw new OBException(ex.getMessage());
    } finally {
      try {
        conn.releasePreparedStatement(st);
        conn.destroy();
      } catch (Exception ignore) {
        ignore.printStackTrace();
      }
    }
  }
  
  public static String getUUID(ConnectionProvider connectionProvider) throws ServletException {
    String strSql = "";
    strSql = strSql + "SELECT get_uuid() as name FROM dual";

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
  
  private static void saveLogWeb(JsonObject dataFactura,SWSICConfig config, Invoice invoice) {

    UUID uuid = UUID.randomUUID();
    String randomUUIDString = uuid.toString().replaceAll("-", "").toUpperCase();

    SWSICLogs temp = OBProvider.getInstance().get(SWSICLogs.class);
    temp.setNewOBObject(true);
    temp.setId(randomUUIDString);
    temp.setClient(config.getClient());
    temp.setOrganization(config.getOrganization());
    temp.setJson(dataFactura.toString());
    temp.setInvoice(invoice);
    temp.setCreatedBy(config.getUserContact());
    temp.setUpdatedBy(config.getUserContact());
    OBDal.getInstance().save(temp);
    OBDal.getInstance().flush();

  }
  
}
