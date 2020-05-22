package ec.com.sidesoft.custom.payroll.partialpayment.ad_process;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

//import org.apache.cxf.jaxrs.model.wadl.Descriptions;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.client.kernel.RequestContext;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.DalBaseProcess;
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.xmlEngine.XmlEngine;

import ec.com.sidesoft.custom.payroll.partialpayment.scppapprovalpayment;

public class PartialPaymentFIleTransferTXT extends DalBaseProcess {
  OBError message;

  public XmlEngine xmlEngine = null;
  public static String strDireccion;
  public String des="";

  @SuppressWarnings({ "deprecation", "null" })
  public void doExecute(ProcessBundle bundle) throws Exception {
    try {
      
      message = new OBError();
      processRequest(bundle);
    } catch (Exception e) {
      String language = OBContext.getOBContext().getLanguage().getLanguage();
      ConnectionProvider conn = new DalConnectionProvider(false);

      message.setMessage(e.getMessage());
      message.setTitle(Utility.messageBD(conn, "Error", language));
      message.setType("Error");
    } finally {
      bundle.setResult(message);
    }
  }

  private void processRequest(ProcessBundle bundle) {

    String language = OBContext.getOBContext().getLanguage().getLanguage();
    ConnectionProvider conn = new DalConnectionProvider(false);

    // VariablesSecureApp varsAux = bundle.getContext().toVars();
    HttpServletResponse response = RequestContext.get().getResponse();
    HttpServletRequest request = RequestContext.get().getRequest();
    
   

    try {

      // retrieve the parameters from the bundle
      // Recupera los parametros de la sesión
      final String strCApprovalPaymentId = (String) bundle.getParams().get(
          "Scpp_Approvalpayment_ID");
     

      OBCriteria<scppapprovalpayment> objApprovalPayment = OBDal.getInstance().createCriteria(
          scppapprovalpayment.class);
      objApprovalPayment.add(Restrictions
          .eq(scppapprovalpayment.PROPERTY_ID, strCApprovalPaymentId));

      // PARAMETRO PARA BANCO PICHINCHA Y BANCO CENTRAL
      String strSendNo = "111";
      String strOutputFileType = objApprovalPayment.list().get(0).getOutputFileType();
      String strDocumentNo = objApprovalPayment.list().get(0).getPayroll().getDocumentNo();
      String strTypeIncome = objApprovalPayment.list().get(0).getTypeOfIncome();
      

     
      // VALIDO TIPO DE ARCHIVO DE SALIDA
      if (strOutputFileType.equals("BP")) {

        try {
          
         

          // Get the Payroll Ticket data
          // Obtener los datos de la Boleta de Nomina
          ArchPartialPaymentPichinchaBankTXTData data[] = ArchPartialPaymentPichinchaBankTXTData
              .select(conn, strDocumentNo, strTypeIncome, strCApprovalPaymentId);
          
          
          
        
          
          if (data != null && data.length > 0) {
            bundle.setResult(message);

            // Prepar browser to receive file
            // Preparar el navegador para recibir el archivo
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/txt");
            response.setHeader("Content-Disposition", "attachment; filename=PichinchaTransfer.txt");
            // Build txt file
            // Consrtuir el archivo txt
            PrintWriter out = response.getWriter();
            try {
              // out.println((Utility.fileToString(file.getAbsolutePath())));

              Integer numberEmployee = 0;
              // BANDERA VALIDACION ERROR CUENTA
              Integer flag_error = 0;
              Integer flag_error_tercero = 0;
              Integer Sec_contrapartida = 1;
              
                //archPTransfData.
             

              for (ArchPartialPaymentPichinchaBankTXTData archPTransfData : data) {
                if (Double.valueOf(archPTransfData.valor) != 0) {
                  // VALIDA BANDERA ERROR PARA ESCRITURA

                  out.write(archPTransfData.pa);
                  out.write("       " + Sec_contrapartida);
                  out.write("       " + archPTransfData.moneda);
                  out.write("       " + (archPTransfData.valor).replace(".", ""));
                  out.write("       " + archPTransfData.formacobro);
                  out.write("       " + archPTransfData.tipocuenta);
                  out.write("       " + removeAcute(archPTransfData.cuenta));
                  out.write("       " + removeAcute(archPTransfData.referencia));
                  out.write("     " + archPTransfData.tipoidcliente);
                  out.write("     " + archPTransfData.numidcliente);
                  out.write("     " + removeAcute(archPTransfData.tercero));
                  out.write("     " + archPTransfData.code);
                  out.println();

                  Sec_contrapartida = Sec_contrapartida + 1;

                }
              }
              // Send file to browser
              // Enviar el archivo al navegador
              out.close();

            } catch (final Exception e) {
              e.printStackTrace(System.err);
              message.setTitle(Utility.messageBD(conn, "ProcessOK", language));
              message.setType("Error");
              message.setMessage(e.getMessage() + e.fillInStackTrace());
            } finally {
              bundle.setResult(message);
            }
          } else {
            throw new OBException(
                "No existen empleados configurados para la generacion del reporte. Revise la configuracion e intente denuevo.");
          }

        } finally {
          bundle.setResult(message);
        }
      } else if (strOutputFileType.equals("BC")) {

        try {

          // Get the Payroll Ticket data
          // Obtener los datos de la Boleta de Nomina
          ArchPartialPaymentCtralBankData data[] = ArchPartialPaymentCtralBankData.select(conn,
              strDocumentNo, strCApprovalPaymentId);
          if (data != null && data.length > 0) {
            bundle.setResult(message);

            // Prepar browser to receive file
            // Preparar el navegador para recibir el archivo
            response.setCharacterEncoding("Cp1252");
            response.setContentType("application/txt");
            response.setHeader("Content-Disposition", "attachment; filename=PaymentCtralBank.txt");
            // Build txt file
            // Consrtuir el archivo txt
            PrintWriter out = response.getWriter();
            try {

              Integer numberEmployee = 0;

              for (ArchPartialPaymentCtralBankData archPCBankData : data) {
                if (Double.valueOf(archPCBankData.totalnet) != 0) {
                  numberEmployee++;
                }
              }

              final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy h:mm:ss");
              final Date date = new Date();
              out.write(dateFormat.format(date).toString());
              out.write("," + strSendNo);
              out.write("," + numberEmployee.toString());
              out.write("," + data[0].constante1);
              out.write("," + data[0].totalnetemployee);
              out.write("," + data[0].constante2);
              out.write("," + data[0].constante3);
              out.write("," + data[0].constante4);
              out.write("," + removeAcute(data[0].razonsocial));
              out.write("," + removeAcute(data[0].city));
              out.println("," + data[0].period);
              Integer secuencial = 1;
              for (ArchPartialPaymentCtralBankData archPCBankData : data) {
                if (Double.valueOf(archPCBankData.totalnet) != 0) {
                  out.write(secuencial.toString());
                  out.write("," + archPCBankData.totalnet);
                  out.write("," + archPCBankData.codcategoryacct);
                  out.write("," + archPCBankData.bankcode);
                  out.write(","
                      + ((archPCBankData.accountno == null || archPCBankData.accountno.equals("") || archPCBankData.accountno
                          .isEmpty()) ? "ERROR TERCERO NO TIENE CUENTA CONFIGURADA PARA PAGOS AUTOMATICOS"
                          : archPCBankData.accountno));
                  out.write(","
                      + ((archPCBankData.bankaccounttype == null
                          || archPCBankData.bankaccounttype.equals("") || archPCBankData.bankaccounttype
                            .isEmpty()) ? "ERROR TERCERO NO TIENE CUENTA CONFIGURADA PARA PAGOS AUTOMATICOS"
                          : archPCBankData.bankaccounttype));
                  out.write("," + removeAcute(archPCBankData.employee));
                  out.write("," + removeAcute(archPCBankData.description));
                  out.println("," + archPCBankData.ci);
                  secuencial++;
                }
              }
              // Send file to browser
              // Enviar el archivo al navegador
              out.close();

            } catch (final Exception e) {
              e.printStackTrace(System.err);
              message.setTitle(Utility.messageBD(conn, "ProcessOK", language));
              message.setType("Error");
              message.setMessage(e.getMessage() + e.fillInStackTrace());
            } finally {
              bundle.setResult(message);
            }
          }

        } finally {
          bundle.setResult(message);
        }
      } else if (strOutputFileType.equals("XLS")) {
         

        ArchPartialPaymentBankXLSData2 descriptions[]=ArchPartialPaymentBankXLSData2.description(conn, strCApprovalPaymentId);
        for (ArchPartialPaymentBankXLSData2 data1 : descriptions)
          des=data1.descripcion;
        // INICIO XLS
        try {
          OutputStream out = null;
          try {

            scppapprovalpayment SsppApprovalPayment = OBDal.getInstance().get(
                scppapprovalpayment.class, strCApprovalPaymentId);
            

            if (!SsppApprovalPayment.getDocumentType().getId().isEmpty()) {

              response.setContentType("application/vnd.ms-excel");

              response.setHeader("Content-Disposition",
                  "attachment; filename=AprobacionPagosNomina.xls");
              WritableWorkbook w = null;
              w = Workbook.createWorkbook(response.getOutputStream());
              WritableSheet s = w.createSheet("Aprobación Pagos de Nómina", 0);

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
              
            
              
              ArchPartialPaymentBankXLSData data[] = ArchPartialPaymentBankXLSData.select(conn,
                  strCApprovalPaymentId);
              if (data != null && data.length > 0) {
                int i = 1;
                for (ArchPartialPaymentBankXLSData CollSsppPaymentLine : data) {
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
                    StrPartner = CollSsppPaymentLine.tercero == null ? ""
                        : CollSsppPaymentLine.tercero;
                  }

                  s.addCell(new Label(2, i, StrPartner));

                  // BANCO DE TRANSFERENCIA

                  s.addCell(new Number(3, i, (Double
                      .valueOf(CollSsppPaymentLine.institucionFinanciera))));

                  // NÚMERO DE CUENTA
                  s.addCell(new Number(4, i, (Double
                      .valueOf(CollSsppPaymentLine.cuentaBeneficiario))));

                  // TIPO DE CUENTA
                  s.addCell(new Number(5, i, (Double.valueOf(CollSsppPaymentLine.tipoCuenta))));

                  // VALOR
                  s.addCell(new Number(6, i, (Double.valueOf(CollSsppPaymentLine.valor))));

                  s.addCell(new Number(7, i, (Double.valueOf(CollSsppPaymentLine.concepto))));
                  if(des.equals(""))
                   s.addCell(new Label(8, i,CollSsppPaymentLine.detalle)); 
                  else
                   s.addCell(new Label(8, i,des));

                  
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
        // FIN XLS

      }

    } catch (final Exception e) {
      e.printStackTrace(System.err);
      message.setTitle(Utility.messageBD(conn, "ProcessOK", language));
      message.setType("Error");
      message.setMessage(e.getMessage() + e.fillInStackTrace());
    } finally {
      bundle.setResult(message);
    }
  }

  public static String removeAcute(String input) {
    // Cadena de caracteres original a sustituir.
    String original = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ";
    // Cadena de caracteres ASCII que reemplazarán los originales.
    String ascii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";
    String output = input;
    for (int i = 0; i < original.length(); i++) {
      // Reemplazamos los caracteres especiales.
      output = output.replace(original.charAt(i), ascii.charAt(i));
    }// for i
    return output;
  }// removeAcute

  private void FileBankPichinchaTxt(ProcessBundle bundle) {
  }

  private void FileBankCentralTxt(ProcessBundle bundle) {
  }

}
