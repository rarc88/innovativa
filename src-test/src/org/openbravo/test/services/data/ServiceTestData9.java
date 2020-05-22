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
 * All portions are Copyright (C) 2015 Openbravo SLU 
 * All Rights Reserved. 
 * Contributor(s):  ______________________________________.
 ************************************************************************
 */

package org.openbravo.test.services.data;

import java.math.BigDecimal;

import org.openbravo.erpCommon.utility.OBDateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceTestData9 extends ServiceTestData {

  final static private Logger log = LoggerFactory.getLogger(ServiceTestData9.class);

  @Override
  public void initialize() {
    setTestNumber("BACK-500");
    setTestDescription("Services missing configuration data. Missing Price Rule Version");
    try {
      setErrorMessage("@ServicePriceRuleVersionNotFound@ Warranty, @Date@: "
          + OBDateUtils.formatDate(OBDateUtils.getDate("01-04-2015")));
    } catch (Exception ex) {
      log.error("Error when executing ServiceTestData9: " + ex);
    }
    setBpartnerId(BP_CUSTOMER_A);
    setOrderDate("01-04-2015");
    setServiceId(SERVICE_WARRANTY);
    setProducts(new String[][] {//
    // ProductId, quantity, price, amount
    { PRODUCT_DISTRIBUTION_GOOD_A, "1", "10.00", "10.00" } //
    });
    setQuantity(BigDecimal.ONE);
    setPrice(new BigDecimal("250.00"));
    setPricelistId(PRICELIST_SALES);
  }
}
