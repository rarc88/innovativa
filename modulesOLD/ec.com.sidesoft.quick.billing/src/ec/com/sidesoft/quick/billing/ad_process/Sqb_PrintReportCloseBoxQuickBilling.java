package ec.com.sidesoft.quick.billing.ad_process;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
//import org.openbravo.base.model.Table;
import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.model.ad.datamodel.Table;
import org.openbravo.model.ad.ui.Window;
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.utils.Replace;

import ec.com.sidesoft.custom.reports.SescrTemplateReport;

public class Sqb_PrintReportCloseBoxQuickBilling extends HttpSecureAppServlet {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private static Logger log4j = Logger.getLogger(Sqb_PrintReportCloseBoxQuickBilling.class);
  public String strDocumentId, str_Atachment, str_FTP;
  public Connection connection_DB = null;

  public void init(ServletConfig config) {
    super.init(config);
    boolHist = false;
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response,
      String strQuickBillingID, String strAtachments, String strFTP, Connection DBConnection)
      throws IOException, ServletException {
    VariablesSecureApp vars = new VariablesSecureApp(request);

    if (!strQuickBillingID.equals("")) {
      strDocumentId = strQuickBillingID;
      str_Atachment = strAtachments;
      str_FTP = strFTP;
      connection_DB = DBConnection;

      // normalize the string of ids to a comma separated list
      strDocumentId = strDocumentId.replaceAll("\\(|\\)|'", "");
      if (strDocumentId.length() == 0)
        throw new ServletException(Utility.messageBD(this, "NoDocument", vars.getLanguage()));

      if (log4j.isDebugEnabled())
        log4j.debug("strDocumentId: " + strDocumentId);
      printPagePDF(response, vars, strDocumentId, str_Atachment, str_FTP);
    } else {
      pageError(response);

    }
  }

  @SuppressWarnings("resource")
  private void printPagePDF(HttpServletResponse response, VariablesSecureApp vars,
      String strDocument2Id, String strAtachment, String str_FtpDirecotry) throws IOException,
      ServletException {
    ConnectionProvider conn = new DalConnectionProvider(false);
    String language = OBContext.getOBContext().getLanguage().getLanguage();

    String StrWindowdID = "";
    String StrTableID = "";
    StrWindowdID = "3A4D34306AB743069FF5A867CF0A3BBF";
    StrTableID = "B7EDE90944074C1CAC5FEEB057A2A92A";

    Window ADWindow = OBDal.getInstance().get(Window.class, StrWindowdID);
    Table ADTable = OBDal.getInstance().get(Table.class, StrTableID);

    OBCriteria<SescrTemplateReport> PrintWithh = OBDal.getInstance().createCriteria(
        SescrTemplateReport.class);
    PrintWithh.add(Restrictions.eq(SescrTemplateReport.PROPERTY_WINDOW, ADWindow));
    PrintWithh.add(Restrictions.isNull(SescrTemplateReport.PROPERTY_TABLE));
    // PrintWithh.add(Restrictions.eq(SescrTemplateReport.PROPERTY_ORGANIZATION, ADOrg));

    List<SescrTemplateReport> LstTemplate = PrintWithh.list();
    int ICountTemplate;
    ICountTemplate = LstTemplate.size();

    if (ICountTemplate == 0) {

      throw new OBException(Utility.messageBD(conn, "@Template no Found..@", language));

    }
    if (LstTemplate.get(0).getWindow().getId().equals(StrWindowdID)) {

      String StrRutaReport = LstTemplate.get(0).getTemplateDir();

      String strReportName = StrRutaReport + "/" + LstTemplate.get(0).getNameReport();

      final String strAttach = strAtachment;// globalParameters.strFTPDirectory + "/284-" +
                                            // classInfo.id;

      final String strLanguage = vars.getLanguage();

      strReportName = Replace.replace(Replace.replace(strReportName, "@basedesign@", strAttach),
          "@attach@", strAttach);

      if (log4j.isDebugEnabled())
        log4j.debug("Output: Report Close Quick Billing By User- pdf");

      // VALIDACION PARA SQL

      HashMap<String, Object> parameters = new HashMap<String, Object>();
      parameters.put("DOCUMENT_ID", strDocumentId);
      // String StrBaseWeb = getBaseDesignPath(strLanguage);
      // parameters.put("BASE_WEB", StrBaseWeb);

      // renderJR(vars, response, strReportName, "pdf", parameters, null, null);

      String StrNameReport = LstTemplate.get(0).getNameReport();

      String outputFile = "";
      outputFile = GetReport(strReportName, StrNameReport, parameters);

      File pdfFile = new File(outputFile);
      response.setContentLength((int) pdfFile.length());
      try {
        File downloadFile = new File(outputFile);
        FileInputStream inStream = new FileInputStream(downloadFile);

        FileInputStream ficheroInput = new FileInputStream(outputFile);

        int tamanoInput = ficheroInput.available();
        byte[] datosPDF = new byte[tamanoInput];

        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
        response.setContentType("application/pdf");
        response.setContentLength(tamanoInput);
        response.setHeader(headerKey, headerValue);

        // obtains response's output stream
        OutputStream outStream = response.getOutputStream();

        byte[] buffer = new byte[4096];
        int bytesRead = -1;

        while ((bytesRead = inStream.read(buffer)) != -1) {
          outStream.write(buffer, 0, bytesRead);
        }

        response.getOutputStream().write(datosPDF);
        inStream.close();
        outStream.close();
        printPageClosePopUpAndRefreshParent(response, vars);
      } catch (Exception e) {

      }

    }

  }

  public String GetReport(String strReportName, String StrNameReport,
      HashMap<String, Object> parameters) {
    JasperReport report = null;

    String SrtLinkReport = null;
    SrtLinkReport = strReportName;
    JasperPrint print;
    final String outputFile = str_FTP + "/" + StrNameReport.replace(".jrxml", ".pdf");

    try {
      parameters.put("REPORT_CONNECTION", connection_DB);
      report = JasperCompileManager.compileReport(SrtLinkReport);
      print = JasperFillManager.fillReport(report, parameters, connection_DB);
      JasperExportManager.exportReportToPdfFile(print, outputFile);
      connection_DB.close();

    } catch (Exception e) {
      throw new OBException("Error template: " + e.getMessage().toString());
    }

    return outputFile;
  }

  public String getServletInfo() {
    return "Servlet that processes the print action";
  } // End of getServletInfo() method
}