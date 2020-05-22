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
 * All portions are Copyright (C) 2001-2017 Openbravo SLU 
 * All Rights Reserved. 
 * Contributor(s):  ______________________________________.
 ************************************************************************
 */
package org.openbravo.erpCommon.ad_callouts;

import javax.servlet.ServletException;

import org.apache.commons.lang.StringUtils;
import org.openbravo.base.filter.IsIDFilter;
import org.openbravo.erpCommon.utility.Utility;

public class SL_Invoice_DocType extends SimpleCallout {

  @Override
  protected void execute(CalloutInfo info) throws ServletException {

    String strChanged = info.getLastFieldChanged();
    if (log4j.isDebugEnabled()) {
      log4j.debug("CHANGED: " + strChanged);
    }

    // Parameters
    String strDocTypeTarget = info.getStringParameter("inpcDoctypetargetId", IsIDFilter.instance);
    String strCInvoiceId = info.getStringParameter("inpcInvoiceId", IsIDFilter.instance);

    SEInOutDocTypeData[] data = SEInOutDocTypeData.select(this, strDocTypeTarget);
    if (data != null && data.length > 0) {

      // Documentno
      // check if doc type target is different, in this case assign new
      // documentno otherwise maintain the previous one
      String strDoctypetargetinvoice = SEInOutDocTypeData.selectDoctypetargetinvoice(this,
          strCInvoiceId);
      if (StringUtils.isEmpty(strDoctypetargetinvoice)
          || !StringUtils.equals(strDoctypetargetinvoice, strDocTypeTarget)) {
        String strDocumentNo = StringUtils.equals(data[0].isdocnocontrolled, "Y") ? data[0].currentnext
            : Utility.getDocumentNo(this, info.vars.getClient(), "C_Invoice", false);
        info.addResult("inpdocumentno", "<" + strDocumentNo + ">");
      } else if (StringUtils.isNotEmpty(strDoctypetargetinvoice)
          && StringUtils.equals(strDoctypetargetinvoice, strDocTypeTarget)) {
        info.addResult("inpdocumentno",
            SEInOutDocTypeData.selectActualinvoicedocumentno(this, strCInvoiceId));
      }

      // DocBaseType
      info.addResult("inpdocbasetype", data[0].docbasetype);

      // Payment Rule
      if (StringUtils.endsWith(data[0].docbasetype, "C")) {
        // Payment Rule - Form Of Payment On Credit for Credit Memos Document Type
        info.addResult("inppaymentrule", "P");
      } else {
        // Payment Rule - No Form of Payment for non Credit Memos Document type.
        info.addResult("inppaymentrule", "");
      }
    }
  }
}
