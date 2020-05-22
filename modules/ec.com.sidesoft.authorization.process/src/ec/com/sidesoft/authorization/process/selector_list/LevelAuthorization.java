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
package ec.com.sidesoft.authorization.process.selector_list;

import java.util.Map;
import org.openbravo.dal.service.OBCriteria;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.openbravo.client.kernel.BaseActionHandler;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.service.db.DbUtility;

// import Models
import ec.com.sidesoft.authorization.process.ReasonRejection;


public class LevelAuthorization extends BaseActionHandler {

	private static final Logger log4j = Logger.getLogger(LevelAuthorization.class);

	// log.info(">> not match:\n ");
	// System.out.println("not found");

	@Override
	protected JSONObject execute(Map<String, Object> parameters, String data) {
		
		JSONObject response = new JSONObject();
		try {
			final JSONObject jsonData = new JSONObject(data);
			final String action = jsonData.getString("action");

			if ("ACTION_COMBO".equals(action)) {
				response.put("actionComboBox", getDataComboBox());
				return response;
			}
			return response;
		} catch (Exception e) {
			OBDal.getInstance().rollbackAndClose();
			log4j.error("OpenCloseProcess error: " + e.getMessage(), e);
			Throwable ex = DbUtility.getUnderlyingSQLException(e);
			String message = OBMessageUtils.translateError(ex.getMessage()).getMessage();
			try {
				JSONObject errorMessage = new JSONObject();
				errorMessage.put("severity", "error");
				errorMessage.put("text", message);
				response.put("message", errorMessage);
			} catch (JSONException ignore) {
			}
		}
		return response;
	}

	private JSONObject getDataComboBox() throws Exception {

		String defaultValue = null;
		JSONObject response = new JSONObject();
		JSONObject valueMap = new JSONObject();

		OBCriteria<ReasonRejection> reasonRejectionList = OBDal.getInstance()
				.createCriteria(ReasonRejection.class);

		for (ReasonRejection alv : reasonRejectionList.list()) {
			valueMap.put(alv.getId(), alv.getCommercialName());
		}
		defaultValue = reasonRejectionList.list().get(0).getId();
		response.put("valueMap", valueMap);
		response.put("defaultValue", defaultValue);
		return response;
	}
}