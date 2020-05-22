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

public class ServiceTestData5 extends ServiceTestData {

  @Override
  public void initialize() {
    setTestNumber("BACK-300");
    setTestDescription("Service of Quantity Rule = 'As per product'");
    setBpartnerId(BP_CUSTOMER_A);
    setServiceId(SERVICE_WARRANTY);
    setProducts(new String[][] {//
    // ProductId, quantity, price, amount
    { PRODUCT_DISTRIBUTION_GOOD_A, "15", "10", "150" } //
    });
    setQuantity(BigDecimal.ONE);
    setPrice(new BigDecimal("200.00"));
    setServicePriceResult(new BigDecimal("202.00"));
    setServiceAmountResult(new BigDecimal("3030.00"));
    setServiceQtyResult(new BigDecimal("15"));
    setPricelistId(PRICELIST_SALES);
  }
}
