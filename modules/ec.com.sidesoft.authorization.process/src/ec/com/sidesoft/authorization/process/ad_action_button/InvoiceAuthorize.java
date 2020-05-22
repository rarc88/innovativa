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
 * All portions are Copyright (C) 2011 Openbravo SLU 
 * All Rights Reserved. 
 * Contributor(s):  __________Santiago Recalde_________________________.
 ************************************************************************
 */
package ec.com.sidesoft.authorization.process.ad_action_button;

import java.util.Map;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.openbravo.base.exception.OBException;
import org.openbravo.client.kernel.BaseActionHandler;
import org.openbravo.dal.service.OBDal;
import org.openbravo.dal.service.OBCriteria;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.provider.OBProvider;

import org.apache.log4j.Logger;

import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;

// import model
import org.openbravo.model.common.invoice.Invoice;
import ec.com.sidesoft.authorization.process.AuthorizationLevel;
import ec.com.sidesoft.authorization.process.AuthorizationInvoice;
import ec.com.sidesoft.authorization.process.ReasonRejection;


public class InvoiceAuthorize extends BaseActionHandler {

	private static final Logger log = Logger.getLogger(AuthorizeLevel.class);
	public String test = "";
	public AuthorizationInvoice newLineInvoiceAuthorization = null;
	public ReasonRejection reasonrejection = null;

	@Override
	protected JSONObject execute(Map<String, Object> parameters, String data) throws OBException {

		try {
			final JSONObject jsonData = new JSONObject(data);
			final JSONArray orderIds = jsonData.getJSONArray("orders");
			final String action = jsonData.getString("action");
			final String reasonId = jsonData.getString("reason");

			for (int i = 0; i < orderIds.length(); i++) {
				final String invoiceId = orderIds.getString(i);
				// get the invoice
				final Invoice invoice = OBDal.getInstance().get(Invoice.class, invoiceId);
				// get AuthorizationLevel of invoice
				final AuthorizationLevel authorizationlevel = OBDal.getInstance().get(AuthorizationLevel.class,
						invoice.getEcsapAuthLevel().getId());
				// get List of AuthorizationLevel of invoice
				OBCriteria<AuthorizationLevel> ObjAssetMainList = OBDal.getInstance()
						.createCriteria(AuthorizationLevel.class);
				if(reasonId!="null"){
				reasonrejection = OBDal.getInstance().get(ReasonRejection.class, reasonId);
				}else{}
				Long authlevelcurrent = authorizationlevel.getValidationCode();

				for (AuthorizationLevel newauthorizationlevel : ObjAssetMainList.list()) {
					Long result = newauthorizationlevel.getValidationCode();

					if (authlevelcurrent + 1L == result && "authorize".equals(action)) {
						invoice.setEcsapAuthLevel(newauthorizationlevel);
						createLineAuthorizationLevel(invoice, authorizationlevel, reasonrejection);
					} else if (authlevelcurrent - authlevelcurrent == result && "reject".equals(action)) {
						invoice.setEcsapAuthLevel(newauthorizationlevel);
						createLineAuthorizationLevel(invoice, authorizationlevel, reasonrejection);
					} else {
						// log.info(">> not match:\n " +
					}
				}
			}
			JSONObject result = new JSONObject();
			result.put("updated", "Success");
			return result;
		} catch (Exception e) {
			throw new OBException(e);
		}
	}

	public Long getSequenceNumber(Invoice invoice) throws OBException {
		OBCriteria<AuthorizationInvoice> obc = OBDal.getInstance().createCriteria(AuthorizationInvoice.class);
		obc.add(Restrictions.eq(AuthorizationInvoice.PROPERTY_INVOICE, invoice));
		obc.addOrderBy(AuthorizationInvoice.PROPERTY_LINENO, false);
		obc.setFilterOnReadableOrganization(false);
		obc.setMaxResults(1);
		AuthorizationInvoice attach = (AuthorizationInvoice) obc.uniqueResult();
		if (attach == null) {
			return 10L;
		}
		return attach.getLineNo() + 10L;
	}

	public void createLineAuthorizationLevel(Invoice invoice, AuthorizationLevel authorizationlevel,ReasonRejection reasonrejection ) throws OBException {
		if (invoice != null && authorizationlevel != null) {
			newLineInvoiceAuthorization = OBProvider.getInstance().get(AuthorizationInvoice.class);
			newLineInvoiceAuthorization.setOrganization(authorizationlevel.getOrganization());
			newLineInvoiceAuthorization.setInvoice(invoice);
			newLineInvoiceAuthorization.setLineNo(getSequenceNumber(invoice));
			newLineInvoiceAuthorization.setUserContact(authorizationlevel.getUserContact());
			newLineInvoiceAuthorization.setEcsapAuthorizationLevel(authorizationlevel);
			if(reasonrejection!=null){			
				newLineInvoiceAuthorization.setEcsapReasonRejection(reasonrejection);
			}else{}
			OBDal.getInstance().save(newLineInvoiceAuthorization);
		} else {
			// System.out.println("not found");
		}
	}

}