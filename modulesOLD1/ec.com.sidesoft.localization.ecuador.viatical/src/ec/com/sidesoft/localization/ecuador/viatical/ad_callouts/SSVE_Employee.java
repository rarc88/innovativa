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
 * Contributor(s):  ___Santos- 15112011-1310_______.
 ************************************************************************
 */
//package org.openbravo.erpCommon.ad_callouts;
package ec.com.sidesoft.localization.ecuador.viatical.ad_callouts;

import javax.servlet.ServletException;

import org.openbravo.erpCommon.ad_callouts.SimpleCallout;
// classes required to retrieve product category data from the 
// database using the DAL

// the name of the class corresponds to the filename that holds it 
// hence, modules/modules/org.openbravo.howtos/src/org/openbravo/howtos/ad_callouts/ProductConstructSearchKey.java.
// The class must extend SimpleCallout
public class SSVE_Employee extends SimpleCallout {

  private static final long serialVersionUID = 1L;

  @Override
  protected void execute(CalloutInfo info) throws ServletException {

    // String strProductName = info.getStringParameter("inpname", null);
    // String strProductCategoryId = info.getStringParameter("inpmProductCategoryId", null);
    // BigDecimal bdLineNetAmt = info.getBigDecimalParameter("inplinenetamt");// Line Amount
    // BigDecimal bdLineIVAAmt = info.getBigDecimalParameter("inplineivaamt");// Line Amount
    String strPartner = info.getStringParameter("inpcBpartnerId", null);// Tax
    // String strIsRental = info.getStringParameter("inpisrental", null);// Is Rental

    // Get data from database
    SSVEEmployeeData data[] = SSVEEmployeeData.select(this, strPartner);

    // Calculate and inject result
    if (data != null && data.length > 0) {

      String bpCity = data[0].emSsprCity;
      String bpBank = data[0].emSsfiBanktransferId;
      String bpBankAccountType = data[0].bankaccounttype;
      String bpPosition = data[0].ssprPositionId;
      String bpNatIdentDoc = data[0].taxid;

      // BigDecimal bdResult;

      info.addResult("inpemployeeCityId", bpCity);
      info.addResult("inpssfiBanktransferId", bpBank);
      info.addResult("inpbankaccounttype", bpBankAccountType);
      info.addResult("inpssprPositionId", bpPosition);
      info.addResult("inpnatidentdoc", bpNatIdentDoc);

      // if (strIsRental.equals("Y")) {
      // Calculate the result
      // bdResult = new BigDecimal(Math.abs(bdLineNetAmt.multiply(bdTaxRate)
      // .divide(new BigDecimal(100)).doubleValue()));
      // Inject the result into the response
      // } else if (strIsRental.equals("N")) {
      // Calculate the result
      // bdResult = new BigDecimal(Math.abs(bdLineIVAAmt.multiply(bdTaxRate)
      // .divide(new BigDecimal(100)).doubleValue()));
      // Inject the result into the response
      // info.addResult("inpwhivaamt", bdResult);
      // }

    }
  }

}