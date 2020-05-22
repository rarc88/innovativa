package com.sidesoft.flopec.budget.ad_Process;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperPrint;

import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;

public class CertificateReport extends HttpSecureAppServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) {
		super.init(config);
		boolHist = false;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		VariablesSecureApp vars = new VariablesSecureApp(request);

		if (vars.commandIn("DEFAULT")) {
			String documentId = vars
					.getSessionValue("PrintCertificate.SFB_Budget_Certificate_ID");
			if (documentId.equals(""))
				documentId = vars
						.getSessionValue("PrintCertificate.inpsfbBudgetCertificateId");
			printPagePartePDF(response, vars, documentId);
		} else
			pageError(response);
	}

	void printPagePartePDF(HttpServletResponse response,
			VariablesSecureApp vars, String documentId) throws IOException,
			ServletException {
		if (log4j.isDebugEnabled())
			log4j.debug("Output: Certificate_header - pdf");
		JasperPrint jasperPrint;

		String strReportName = "@basedesign@/com/sidesoft/flopec/budget/ad_Reports/Certificate.jrxml";
		response.setHeader("Content-disposition",
				"inline; filename=Certificate_header.pdf");

		HashMap<String, Object> parameters = new HashMap<String, Object>();

		documentId = documentId.replaceAll("\\(|\\)|'", "");
		parameters.put("DOCUMENT_ID", documentId);

		renderJR(vars, response, strReportName, "pdf", parameters, null, null);
	}

	public String getServletInfo() {
		return "Servlet that presents the RptMInout seeker";
	} // End of getServletInfo() method
}