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

// import model
import org.openbravo.model.common.order.Order;
import ec.com.sidesoft.authorization.process.AuthorizationLevel;
import ec.com.sidesoft.authorization.process.ReasonRejection;
import ec.com.sidesoft.authorization.process.AuthorizationLLine;

public class AuthorizeLevel extends BaseActionHandler {

	private static final Logger log = Logger.getLogger(AuthorizeLevel.class);
	public String test = "";
	public AuthorizationLLine newLineAuthorizationLevel = null;
	public ReasonRejection reasonrejection = null;

	@Override
	protected JSONObject execute(Map<String, Object> parameters, String data) throws OBException {

		try {
			final JSONObject jsonData = new JSONObject(data);
			final JSONArray orderIds = jsonData.getJSONArray("orders");
			final String action = jsonData.getString("action");
			final String reasonId = jsonData.getString("reason");
						log.info(">> not match:\n " +data);
			for (int i = 0; i < orderIds.length(); i++) {
				final String orderId = orderIds.getString(i);
				// get the order
				final Order order = OBDal.getInstance().get(Order.class, orderId);
				// get the order
				if(reasonId!="null"){
				reasonrejection = OBDal.getInstance().get(ReasonRejection.class, reasonId);
				}else{}
				// get AuthorizationLevel of order
				final AuthorizationLevel authorizationlevel = OBDal.getInstance().get(AuthorizationLevel.class,
						order.getEcsapAuthLevel().getId());
				// get List of AuthorizationLevel of order
				OBCriteria<AuthorizationLevel> ObjAssetMainList = OBDal.getInstance()
						.createCriteria(AuthorizationLevel.class);

				Long authlevelcurrent = authorizationlevel.getValidationCode();

				for (AuthorizationLevel newauthorizationlevel : ObjAssetMainList.list()) {
					Long result = newauthorizationlevel.getValidationCode();

					if (authlevelcurrent + 1L == result && "authorize".equals(action)) {
						order.setEcsapAuthLevel(newauthorizationlevel);
						createLineAuthorizationLevel(order, authorizationlevel, reasonrejection);
					} else if (authlevelcurrent - authlevelcurrent == result && "reject".equals(action)) {
						order.setEcsapAuthLevel(newauthorizationlevel);
						createLineAuthorizationLevel(order, authorizationlevel, reasonrejection);
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

	public Long getSequenceNumber(Order order) throws OBException {
		OBCriteria<AuthorizationLLine> obc = OBDal.getInstance().createCriteria(AuthorizationLLine.class);
		obc.add(Restrictions.eq(AuthorizationLLine.PROPERTY_SALESORDER, order));
		obc.addOrderBy(AuthorizationLLine.PROPERTY_LINENO, false);
		obc.setFilterOnReadableOrganization(false);
		obc.setMaxResults(1);
		AuthorizationLLine attach = (AuthorizationLLine) obc.uniqueResult();
		if (attach == null) {
			return 10L;
		}
		return attach.getLineNo() + 10L;
	}

	public void createLineAuthorizationLevel(Order order, AuthorizationLevel authorizationlevel,ReasonRejection reasonrejection ) throws OBException {
		if (order != null && authorizationlevel != null) {

			newLineAuthorizationLevel = OBProvider.getInstance().get(AuthorizationLLine.class);
			newLineAuthorizationLevel.setOrganization(authorizationlevel.getOrganization());
			newLineAuthorizationLevel.setSalesOrder(order);
			newLineAuthorizationLevel.setLineNo(getSequenceNumber(order));
			newLineAuthorizationLevel.setUserContact(authorizationlevel.getUserContact());
			newLineAuthorizationLevel.setEcsapAuthorizationLevel(authorizationlevel);
			newLineAuthorizationLevel.setEcsapReasonRejection(reasonrejection);
			if(reasonrejection!=null){			
				newLineAuthorizationLevel.setEcsapReasonRejection(reasonrejection);
			}else{}
			OBDal.getInstance().save(newLineAuthorizationLevel);
		} else {
			// System.out.println("not found");
		}
	}

}