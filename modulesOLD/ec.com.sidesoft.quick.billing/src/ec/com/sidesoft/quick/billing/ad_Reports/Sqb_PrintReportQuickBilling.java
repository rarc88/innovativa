package ec.com.sidesoft.quick.billing.ad_Reports;

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
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.utils.Replace;

import ec.com.sidesoft.custom.reports.SescrTemplateReport;
import ec.com.sidesoft.quick.billing.SqbQuickBilling;

@SuppressWarnings("serial")
public class Sqb_PrintReportQuickBilling extends HttpSecureAppServlet {

  public void init(ServletConfig config) {
    super.init(config);
    boolHist = false;
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
    VariablesSecureApp vars = new VariablesSecureApp(request);

    if (vars.commandIn("DEFAULT")) {
      String strDocumentId = vars
          .getSessionValue("3A4D34306AB743069FF5A867CF0A3BBF|SQB_QUICKBILLING_ID");

      // normalize the string of ids to a comma separated list
      strDocumentId = strDocumentId.replaceAll("\\(|\\)|'", "");
      if (strDocumentId.length() == 0)
        throw new ServletException(Utility.messageBD(this, "NoDocument", vars.getLanguage()));

      if (log4j.isDebugEnabled())
        log4j.debug("strDocumentId: " + strDocumentId);
      printPagePDF(response, vars, strDocumentId);
    } else {
      pageError(response);

    }
  }

  @SuppressWarnings("resource")
  private void printPagePDF(HttpServletResponse response, VariablesSecureApp vars,
      String strDocumentId) throws IOException, ServletException {
    ConnectionProvider conn = new DalConnectionProvider(false);
    String language = OBContext.getOBContext().getLanguage().getLanguage();

    String StrWindowdID = "";
    String StrTableID = "";
    StrWindowdID = "3A4D34306AB743069FF5A867CF0A3BBF";
    StrTableID = "B7EDE90944074C1CAC5FEEB057A2A92A";

    SqbQuickBilling sqbQuickBilling = OBDal.getInstance().get(SqbQuickBilling.class, strDocumentId);
    if (sqbQuickBilling.getDocstatus().equals("CO")) {
      String StrTransactionID = sqbQuickBilling.getInvoiceEMSqbQuickbillingIDList().get(0).getId() == null ? ""
          : sqbQuickBilling.getInvoiceEMSqbQuickbillingIDList().get(0).getId();

      Invoice CInvoice = OBDal.getInstance().get(Invoice.class, StrTransactionID);
      Organization ADOrg = OBDal.getInstance().get(Organization.class,
          CInvoice.getOrganization().getId().toString());

      Window ADWindow = OBDal.getInstance().get(Window.class, StrWindowdID);
      Table ADTable = OBDal.getInstance().get(Table.class, StrTableID);

      OBCriteria<SescrTemplateReport> PrintWithh = OBDal.getInstance().createCriteria(
          SescrTemplateReport.class);
      PrintWithh.add(Restrictions.eq(SescrTemplateReport.PROPERTY_WINDOW, ADWindow));
      PrintWithh.add(Restrictions.eq(SescrTemplateReport.PROPERTY_TABLE, ADTable));
      PrintWithh.add(Restrictions.eq(SescrTemplateReport.PROPERTY_ORGANIZATION, ADOrg));

      List<SescrTemplateReport> LstTemplate = PrintWithh.list();
      int ICountTemplate;
      ICountTemplate = LstTemplate.size();

      if (ICountTemplate == 0) {

        throw new OBException(Utility.messageBD(conn, "@Template no Found..@", language));

      }
      if (LstTemplate.get(0).getWindow().getId().equals(StrWindowdID)) {

        String StrRutaReport = LstTemplate.get(0).getTemplateDir();

        String strReportName = StrRutaReport + "/" + LstTemplate.get(0).getNameReport();

        final String strAttach = globalParameters.strFTPDirectory + "/284-" + classInfo.id;

        final String strLanguage = vars.getLanguage();

        final String strBaseDesign = getBaseDesignPath(strLanguage);

        strReportName = Replace.replace(
            Replace.replace(strReportName, "@basedesign@", strBaseDesign), "@attach@", strAttach);

        if (log4j.isDebugEnabled())
          log4j.debug("Output: Withholding - pdf");

        // VALIDACION PARA SQL

        HashMap<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("DOCUMENT_ID", StrTransactionID);

        String StrNameReport = LstTemplate.get(0).getNameReport();

        // response.setContentType("application/pdf;");
        // response.setHeader("Content-Disposition",
        // "attachment; filename=" + StrNameReport.replace(".jrxml", ".pdf"));

        String outputFile = "";
        outputFile = GetReport(strReportName, StrNameReport, parameters);

        File pdfFile = new File(outputFile);
        response.setContentLength((int) pdfFile.length());
        try {
          FileInputStream fileInputStream = null;
          fileInputStream = new FileInputStream(pdfFile);
          OutputStream responseOutputStream = response.getOutputStream();
          int bytes;
          while ((bytes = fileInputStream.read()) != -1) {
            responseOutputStream.write(bytes);
          }
          responseOutputStream.close();
          responseOutputStream.flush();
          printPageClosePopUpAndRefreshParent(response, vars);
        } catch (Exception e) {

        }

      }
    }
  }

  public String GetReport(String strReportName, String StrNameReport,
      HashMap<String, Object> parameters) {
    JasperReport report = null;

    String SrtLinkReport = null;
    SrtLinkReport = strReportName;
    JasperPrint print;
    Connection con = null;
    final String outputFile = globalParameters.strFTPDirectory + "/"
        + StrNameReport.replace(".jrxml", ".pdf");

    try {
      con = getTransactionConnection();
      parameters.put("REPORT_CONNECTION", con);
      report = JasperCompileManager.compileReport(SrtLinkReport);
      print = JasperFillManager.fillReport(report, parameters, con);
      JasperExportManager.exportReportToPdfFile(print, outputFile);
      con.close();

    } catch (Exception e) {
      log4j.debug("Error: Withholding - pdf");
    }

    return outputFile;
  }

  public String getServletInfo() {
    return "Servlet that processes the print action";
  } // End of getServletInfo() method
}
