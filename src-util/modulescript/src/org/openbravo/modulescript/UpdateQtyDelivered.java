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
 * All portions are Copyright (C) 2016 Openbravo SLU
 * All Rights Reserved.
 * Contributor(s):  ______________________________________.
 ************************************************************************
 */

package org.openbravo.modulescript;

import org.apache.log4j.Logger;
import org.openbravo.database.ConnectionProvider;

/**
 * Updates C_Orderline.QtyDelivered and C_Order.IsDelivered columns only for RTV flows. These
 * columns will be used later on by the RTV shipment P&E.
 * 
 * This module script should be extended in the future to update these columns in other flows.
 */
public class UpdateQtyDelivered extends ModuleScript {

  private static final Logger log4j = Logger.getLogger(UpdateQtyDelivered.class);

  @Override
  public void execute() {
    try {
      ConnectionProvider cp = getConnectionProvider();
      log4j.info("This moduleScript can take long to finish. Please be patient...");

      int orderLinesUpdated = UpdateQtyDeliveredData.updateQtyDelivered(cp);
      if (orderLinesUpdated > 0) {
        log4j.info("Updated " + orderLinesUpdated + " order lines.");
      }

      int orderUpdated = UpdateQtyDeliveredData.updateIsDelivered(cp);
      if (orderUpdated > 0) {
        log4j.info("Updated " + orderUpdated + " orders.");
      }

    } catch (Exception e) {
      handleError(e);
    }
  }

  @Override
  protected ModuleScriptExecutionLimits getModuleScriptExecutionLimits() {
    return new ModuleScriptExecutionLimits("0", null, new OpenbravoVersion(3, 0, 30668));
  }
}
