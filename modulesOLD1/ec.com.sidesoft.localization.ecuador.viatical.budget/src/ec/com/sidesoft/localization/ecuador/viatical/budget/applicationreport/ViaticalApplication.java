package ec.com.sidesoft.localization.ecuador.viatical.budget.applicationreport;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.erpCommon.utility.Utility;

@SuppressWarnings("serial")
public class ViaticalApplication extends HttpSecureAppServlet {
  private static Logger log4j = Logger.getLogger(ViaticalApplication.class);

  public void init(ServletConfig config) {
    super.init(config);
    boolHist = false;
  }

  @SuppressWarnings("unchecked")
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
    VariablesSecureApp vars = new VariablesSecureApp(request);

    if (vars.commandIn("DEFAULT")) {
      String strDocumentId = vars
          .getSessionValue("41A171004C1749978EDC07AFEE06782D|SSVE_VIATICAL_ID");// ID
                                                                                // WINDOW-CAMPO
                                                                                // REFERENCIA EN
                                                                                // LA VENTANA

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

  private void printPagePDF(HttpServletResponse response, VariablesSecureApp vars,
      String strDocumentId) throws IOException, ServletException {

    if (log4j.isDebugEnabled())
      log4j.debug("Output: Report_ViaticalApplication - pdf");

    ViaticalApplicationData[] data = ViaticalApplicationData.select(this, strDocumentId);// instancio
                                                                                         // un
    // objeto de la clase
    // data
    if (log4j.isDebugEnabled())
      log4j.debug("data: " + (data == null ? "null" : "not null"));
    if (data == null || data.length == 0)
      data = ViaticalApplicationData.set();

    HashMap<String, Object> parameters = new HashMap<String, Object>();
    parameters.put("DOCUMENT_ID", strDocumentId);// nombre del parametro igual al del reporte

    String strReportName = "@basedesign@/ec/com/sidesoft/localization/ecuador/viatical/budget/applicationreport/ViaticalApplication.jrxml";
    renderJR(vars, response, strReportName, "pdf", parameters, data, null);
  }

  public String getServletInfo() {
    return "Servlet that processes the print action";
  } // End of getServletInfo() method
}
