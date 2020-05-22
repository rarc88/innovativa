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
 * All portions are Copyright (C) 2014-2015 Openbravo SLU
 * All Rights Reserved.
 * Contributor(s):  ______________________________________.
 *************************************************************************
 */
package org.openbravo.modulescript;

import java.sql.PreparedStatement;
import org.apache.log4j.Logger;

import org.openbravo.database.ConnectionProvider;
import org.openbravo.modulescript.ModuleScript;

public class UpdatePaymentPlan extends ModuleScript {
  private static final Logger log4j = Logger.getLogger(UpdatePaymentPlan.class);
  public void execute() {
    try {
      ConnectionProvider cp = getConnectionProvider();
      boolean isExecuted = UpdatePaymentPlanData.isExecuted(cp);
      if (!isExecuted) {
        for (UpdatePaymentPlanData record : UpdatePaymentPlanData.getWrongRecords(cp)) {
          UpdatePaymentPlanData.update(cp, record.amount, record.amount, record.id);
        }        
        UpdatePaymentPlanData.createPreference(cp);
      }
    } catch (Exception e) {
      handleError(e);
    }
  }
  
  @Override
  protected ModuleScriptExecutionLimits getModuleScriptExecutionLimits() {
    return new ModuleScriptExecutionLimits("0", new OpenbravoVersion(3,0,21939), 
        new OpenbravoVersion(3,0,27021));
  }
}