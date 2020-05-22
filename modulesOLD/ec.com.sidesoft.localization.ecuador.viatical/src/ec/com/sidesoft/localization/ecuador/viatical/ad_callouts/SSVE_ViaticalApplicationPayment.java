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
 * All portions are Copyright (C) 2001-2009 Openbravo SLU
 * All Rights Reserved.
 * Contributor(s): Maykel Glez Hdez <mgonzalez@sidesoft.com.ec>.
 ************************************************************************
 */
//package org.openbravo.erpCommon.ad_callouts;
package ec.com.sidesoft.localization.ecuador.viatical.ad_callouts;

import java.math.BigDecimal;

import javax.servlet.ServletException;

import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;

import ec.com.sidesoft.localization.ecuador.viatical.SSVEViatical;
// classes required to retrieve product category data from the 
// database using the DAL

// the name of the class corresponds to the filename that holds it 
// hence, modules/modules/org.openbravo.howtos/src/org/openbravo/howtos/ad_callouts/ProductConstructSearchKey.java.
// The class must extend SimpleCallout
public class SSVE_ViaticalApplicationPayment extends SimpleCallout {

  private static final long serialVersionUID = 1L;

  @Override
  protected void execute(CalloutInfo info) throws ServletException {

    String strViatical = info.getStringParameter("inpemSsveViaticalId", null);// Viatical

    // Get data from database
    SSVEViatical viaticalApplication = OBDal.getInstance().get(SSVEViatical.class, strViatical);

    // Calculate and inject result
    if (viaticalApplication != null) {

      BigDecimal totalAmount = viaticalApplication.getTotalAmount();

      info.addResult("inpemSsveViaticalamount", totalAmount);

    } else {
      info.addResult("inpemSsveViaticalamount", BigDecimal.ZERO);
    }
  }
}