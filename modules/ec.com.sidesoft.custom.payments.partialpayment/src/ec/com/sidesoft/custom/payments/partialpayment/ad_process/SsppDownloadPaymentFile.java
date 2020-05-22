package ec.com.sidesoft.custom.payments.partialpayment.ad_process;

import java.io.OutputStream;
import java.text.SimpleDateFormat;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.log4j.Logger;
import org.openbravo.base.ConfigParameters;
import org.openbravo.base.secureApp.ClassInfoData;
import org.openbravo.base.session.OBPropertiesProvider;
import org.openbravo.client.kernel.KernelConstants;
import org.openbravo.client.kernel.RequestContext;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.DalBaseProcess;
import org.openbravo.xmlEngine.XmlEngine;

import ec.com.sidesoft.custom.payments.partialpayment.SSPPPAYMENTS;

public class SsppDownloadPaymentFile extends DalBaseProcess {

  public XmlEngine xmlEngine = null;
  public static String strDireccion;
  protected Logger log4j = Logger.getLogger(this.getClass());
  protected ConfigParameters globalParameters;
  protected ClassInfoData classInfo;

  public void doExecute(ProcessBundle bundle) throws Exception {

    final OBError message = new OBError();

    ConnectionProvider conn = bundle.getConnection();

    HttpServletResponse response = RequestContext.get().getResponse();
    HttpServletRequest request = RequestContext.get().getRequest();

    ServletContext context = request.getSession().getServletContext();
    globalParameters = ConfigParameters.retrieveFrom(context);

    try {
      OutputStream out = null;
      try {

        final String StrPaymentID = (String) bundle.getParams().get("Sspp_Payments_ID");

        SSPPPAYMENTS SsppPayment = OBDal.getInstance().get(SSPPPAYMENTS.class, StrPaymentID);

        if (!SsppPayment.getDocumentType().getId().isEmpty()) {

          response.setContentType("application/vnd.ms-excel");

          response.setHeader("Content-Disposition", "attachment; filename=TransferenciaLotes.xls");
          WritableWorkbook w = null;
          w = Workbook.createWorkbook(response.getOutputStream());
          WritableSheet s = w.createSheet("DETALLE DE PAGOS", 0);

          // Header
          s.addCell(new Label(0, 0, "CEDULA, RUC\n O PASAPORTE"));
          s.addCell(new Label(1, 0, "REFERENCIA"));
          s.addCell(new Label(2, 0, "NOMBRE"));
          s.addCell(new Label(3, 0, "INSTITUCIÓN\n FINANCIERA"));
          s.addCell(new Label(4, 0, "CUENTA\n BENEFICIARIO"));
          s.addCell(new Label(5, 0, "TIṔO CUENTA      "));
          s.addCell(new Label(6, 0, "VALOR"));
          s.addCell(new Label(7, 0, "CONCEPTO"));
          s.addCell(new Label(8, 0, "DETALLE"));

          SsppDownloadPaymentFileData data[] = SsppDownloadPaymentFileData.select(conn,
              StrPaymentID);
          if (data != null && data.length > 0) {
            int i = 1;
            for (SsppDownloadPaymentFileData CollSsppPaymentLine : data) {
              // Detail

              // Ruc, Pasaporte, Tarjeta de identificación
              s.addCell(new Label(0, i, CollSsppPaymentLine.cedulaRucPasaporte));

              // TIPO DE DOCUMETNO
              s.addCell(new Number(1, i, (Double.valueOf(CollSsppPaymentLine.referencia))));

              // NOMBRE DEL TERCERO
              String StrPartner = "";
              if (CollSsppPaymentLine.tercero.length() > 28) {

                StrPartner = CollSsppPaymentLine.tercero.toString().substring(0, 28) == null ? ""
                    : CollSsppPaymentLine.tercero.toString().substring(0, 28);
              } else {
                StrPartner = CollSsppPaymentLine.tercero == null ? "" : CollSsppPaymentLine.tercero;
              }

              s.addCell(new Label(2, i, StrPartner));

              // BANCO DE TRANSFERENCIA
              /*
               * String StrPartnerBankAccount = ""; try {
               * 
               * StrPartnerBankAccount = CollSsppPaymentLine.institucionFinanciera == null ? "" :
               * CollSsppPaymentLine.institucionFinanciera; } catch (Exception e) {
               * 
               * }
               * 
               * s.addCell(new Label(3, i, StrPartnerBankAccount == null ? "" :
               * StrPartnerBankAccount));
               */
              s.addCell(new Number(3, i,
                  (Double.valueOf(CollSsppPaymentLine.institucionFinanciera))));
              // NÚMERO DE CUENTA
              /*
               * String StrAccountNo = ""; try { StrAccountNo =
               * CollSsppPaymentLine.cuentaBeneficiario == null ? "" :
               * CollSsppPaymentLine.cuentaBeneficiario; } catch (Exception e) {
               * 
               * }
               * 
               * s.addCell(new Label(4, i, StrAccountNo == null ? "" : StrAccountNo));
               */
              s.addCell(new Number(4, i, (Double.valueOf(CollSsppPaymentLine.cuentaBeneficiario))));

              // TIPO DE CUENTA
              s.addCell(new Number(5, i, (Double.valueOf(CollSsppPaymentLine.tipoCuenta))));

              // VALOR
              s.addCell(new Number(6, i, (Double.valueOf(CollSsppPaymentLine.valor))));

              s.addCell(new Number(7, i, (Double.valueOf(CollSsppPaymentLine.concepto))));
              s.addCell(new Label(8, i, (CollSsppPaymentLine.detalle)));
              i++;

            }

            w.write();
            w.close();
          }
        }

      } catch (Exception e) {
        throw new ServletException("Exception in Excel Sample Servlet", e);
      } finally {
        if (out != null)
          out.close();
      }
    } finally {
      bundle.setResult(message);
    }
  }

  protected String formatDate(java.util.Date date) {
    return new SimpleDateFormat((String) OBPropertiesProvider.getInstance()
        .getOpenbravoProperties().get(KernelConstants.DATE_FORMAT_PROPERTY)).format(date);
  }

  public String getServletInfo() {
    return "Servlet PaymentReport.";
  } // end of getServletInfo() method

}
