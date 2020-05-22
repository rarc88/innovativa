/*
 *************************************************************************
 * The contents of this file are subject to the Openbravo  Public  License
 * Version  1.0  (the  "License"),  being   the  Mozilla   Public  License
 * Version 1.1  with a permitted attribution clause; you may not  use this
 * file except in compliance with the License. You  may  obtain  a copy of
 * the License at http://www.openbravo.com/legal/license.html
 * Software distributed under the License  is  distributed  on  an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific  language  governing  rights  and  limitations
 * under the License.
 * The Original Code is Openbravo ERP.
 * The Initial Developer of the Original Code is Openbravo SLU
 * All portions are Copyright (C) 2014 Openbravo SLU
 * All Rights Reserved.
 * Contributor(s):  ______________________________________.
 *************************************************************************
 */
package org.openbravo.erpCommon.ad_forms;

import org.apache.log4j.Logger;

public class DocLine_LandedCost extends DocLine {
  private static final Logger log4jDocLine_LandedCost = Logger.getLogger(DocLine_LandedCost.class);

  public DocLine_LandedCost(String DocumentType, String TrxHeader_ID, String TrxLine_ID) {
    super(DocumentType, TrxHeader_ID, TrxLine_ID);
  }

  private String trxAmt;
  private String warehouseId;
  private String landedCostTypeId;

  public void setAmount(String amt) {
    trxAmt = amt;
  } // setAmounts

  public String getAmount() {
    return trxAmt;
  } // setAmounts

  public void setWarehouseId(String warehouse) {
    warehouseId = warehouse;
  }

  public String getWarehouseId() {
    return warehouseId;
  }

  public void setLandedCostTypeId(String landedCostType) {
    landedCostTypeId = landedCostType;
  }

  public String getLandedCostTypeId() {
    return landedCostTypeId;
  }

  public String getServletInfo() {
    return "Servlet for the accounting";
  } // end of getServletInfo() method

  public static Logger getLog4jdoclineLandedcost() {
    return log4jDocLine_LandedCost;
  }
}
