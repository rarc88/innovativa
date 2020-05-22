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
 * All portions are Copyright (C) 2010 Openbravo SLU
 * All Rights Reserved.
 * Contributor(s):  __________Santiago Recalde_________________________.
 ************************************************************************
 */
package ec.com.sidesoft.authorization.process.ad_action_button;


import org.openbravo.dal.service.OBDal;
import org.apache.log4j.Logger;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.DalBaseProcess;

import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.openbravo.client.application.ApplicationConstants;
import org.openbravo.client.application.process.BaseProcessActionHandler;
import org.openbravo.client.application.process.ResponseActionsBuilder.MessageType;

public class ExampleJavaProcess extends DalBaseProcess {
  

    private static final Logger log = Logger.getLogger(ExampleJavaProcess.class);
  protected static final String LOGIN = "Openbravo";
  protected static final String PWD = "1234";

 
  public void doExecute(ProcessBundle bundle) throws Exception {
    try {
 
      // retrieve the parameters from the bundle
      final String bPartnerId = (String) bundle.getParams().get("cBpartnerId");
      final String organizationId = (String) bundle.getParams().get("adOrgId");
      final String tabId = (String) bundle.getParams().get("tabId"); 
 
      final String myString = (String) bundle.getParams().get("mystring");
       // Show a result
      final StringBuilder sb = new StringBuilder();



      // implement your process here
      // log.info(">> -------------");
      // log.info(">> bPartnerId: " + bPartnerId);
      HttpURLConnection con = createConnection(myString,"Get");
      int responseCode = con.getResponseCode();
		  // log.info("GET Response Code : " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			log.info(response.toString());
      final JSONObject jsonData = new JSONObject(response.toString());
      sb.append("Json Data information:<br/>");
      sb.append(jsonData.getString("title"));

		} else {
			log.info("GET request not worked");
		}
      // log.info(">> -------------");
  

      sb.append("<br/>Read information:<br/>");
      if (bPartnerId != null) {
        final BusinessPartner bPartner = OBDal.getInstance().get(BusinessPartner.class, bPartnerId);
        sb.append("Business Partner: " + bPartner.getIdentifier() + "<br/>");
      }
      if (organizationId != null) {
        final Organization organization = OBDal.getInstance().get(Organization.class,
            organizationId);
        sb.append("Organization: " + organization.getIdentifier() + "<br/>");
      }
      sb.append("MyString: " + myString + "<br/>");
 
      // OBError is also used for successful results
      final OBError msg = new OBError();
      msg.setType("Success");
      msg.setTitle("Read parameters!");
      msg.setMessage(sb.toString());
 
      bundle.setResult(msg);
 
    } catch (final Exception e) {
      e.printStackTrace(System.err);
      final OBError msg = new OBError();
      msg.setType("Error");
      msg.setMessage(e.getMessage());
      msg.setTitle("Error occurred");
      bundle.setResult(msg);
    }
  }


protected HttpURLConnection createConnection(String wsPart, String method) throws Exception {
// protected void createConnection(String wsPart, String method) throws Exception {

   Authenticator.setDefault(new Authenticator() {
      @Override
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(LOGIN, PWD.toCharArray());
      }
    });
    log.info(method + ": " + wsPart);
    final URL url = new URL( wsPart);
    final HttpURLConnection hc = (HttpURLConnection) url.openConnection();
    hc.setRequestMethod("GET");
    hc.setAllowUserInteraction(false);
    hc.setDefaultUseCaches(false);
    hc.setDoOutput(true);
    hc.setDoInput(true);
    hc.setInstanceFollowRedirects(true);
    hc.setUseCaches(false);
    // hc.setRequestProperty("Content-Type", "text/json");
    hc.setRequestProperty("Content-Type", "application/json"); 
    hc.setRequestProperty("Accept", "application/json"); 

    return hc;
  }

}
