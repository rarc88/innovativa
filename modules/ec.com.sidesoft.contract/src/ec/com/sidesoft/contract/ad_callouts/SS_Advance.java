/*
 *************************************************************************
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
 * Contributor(s):  ___Fernanda_______.
 ************************************************************************
 */
//package org.openbravo.erpCommon.ad_callouts;
package ec.com.sidesoft.contract.ad_callouts;

import java.math.BigDecimal;

import javax.servlet.ServletException;

//import org.openbravo.erpCommon.businessUtility.BpartnerMiscData;
//importar el xsql - en estecaso desde eldirectorio - pakete
import org.hibernate.criterion.Restrictions;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;
import org.openbravo.model.financialmgmt.payment.FIN_Payment;

public class SS_Advance extends SimpleCallout {
  private static final long serialVersionUID = 1L;

  @SuppressWarnings("null")
  @Override
  protected void execute(CalloutInfo info) throws ServletException {

    String srtContractid = info.getStringParameter("inpssctContractId", null);
    String srtPaymentid = info.getStringParameter("inpfinPaymentId", null);

    if (!srtPaymentid.isEmpty()) {

      OBCriteria<FIN_Payment> ObjPaymentList = OBDal.getInstance()
          .createCriteria(FIN_Payment.class);
      ObjPaymentList.add(Restrictions.eq(FIN_Payment.PROPERTY_ID, srtPaymentid));

      if (ObjPaymentList.count() > 0) {

        // OBTENGO TOTAL DE FACTURA
        Double StrTotal = 0.00;
        StrTotal = Double.valueOf(ObjPaymentList.list().get(0).getAmount().toString());
        BigDecimal strFinalTotal = BigDecimal.valueOf(StrTotal);

        // ACTUALIZO VALORES EN EL REGISTRO

        if (StrTotal > 0) {
          info.addResult("inpgrandtotal", strFinalTotal);
        } else {
          info.addResult("inpgrandtotal", strFinalTotal);
        }

        if (StrTotal > 0) {
          info.addResult("inpbalance", strFinalTotal);
        } else {
          info.addResult("inpbalance", strFinalTotal);
        }

      }
    }
  }

}
