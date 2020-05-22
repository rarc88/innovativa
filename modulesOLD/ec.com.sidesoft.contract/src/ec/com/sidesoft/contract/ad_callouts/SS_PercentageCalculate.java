/* The contents of this file are subject to the Openbravo  Public  License
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

import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;

import ec.com.sidesoft.contract.ssctpayment;
//import org.openbravo.erpCommon.businessUtility.BpartnerMiscData;
//importar el xsql - en estecaso desde eldirectorio - pakete

public class SS_PercentageCalculate extends SimpleCallout {
  private static final long serialVersionUID = 1L;

  @SuppressWarnings("null")
  @Override
  protected void execute(CalloutInfo info) throws ServletException {

    BigDecimal srtTotallines = info.getBigDecimalParameter("inptotallines");
    BigDecimal srtAccrued = info.getBigDecimalParameter("inpamountaccrued");
    BigDecimal srtPaid = info.getBigDecimalParameter("inpamountpaid");
    BigDecimal srtPercentage = info.getBigDecimalParameter("inppercentagePayment");
    BigDecimal srtGrandtotal = info.getBigDecimalParameter("inpgrandtotal");
    String srtPercentage_Advanced = info.getStringParameter("inppercentageAdvanced", null);
    String srtPayment_Adv_ID = info.getStringParameter("inpssctPaymentAdvId", null);
    ssctpayment advPayment = OBDal.getInstance().get(ssctpayment.class, srtPayment_Adv_ID);

    // CALCULO DE VALOR DE LA FACTURA
    BigDecimal StrPorcentage = srtPercentage.divide(BigDecimal.valueOf(100));
    BigDecimal StrValorDevengado = BigDecimal.ZERO;
    if (srtPercentage_Advanced.equals("Y")) {
      if (advPayment != null) {
        BigDecimal srtGrandtotal_adv = advPayment.getGrandTotalAmount();
        StrValorDevengado = srtGrandtotal_adv.multiply(StrPorcentage);
      } else {
        StrValorDevengado = BigDecimal.ZERO;
      }
    } else {
      StrValorDevengado = srtTotallines.multiply(StrPorcentage);
    }

    BigDecimal StrValorPendientePago = srtTotallines.subtract(StrValorDevengado);
    BigDecimal StrValorPendientePagoImp = srtGrandtotal.subtract(StrValorDevengado);

    if (!StrValorDevengado.equals(0)) {
      info.addResult("inpamountaccrued", StrValorDevengado);
    } else {
      info.addResult("inpamountaccrued", StrValorDevengado);
    }

    if (!StrValorPendientePago.equals(0)) {
      info.addResult("inpamountpaid", StrValorPendientePago);
    } else {
      info.addResult("inpamountpaid", StrValorPendientePago);
    }

    if (!StrValorPendientePago.equals(0)) {
      info.addResult("inpamountpaidtax", StrValorPendientePagoImp);
    } else {
      info.addResult("inpamountpaidtax", StrValorPendientePagoImp);
    }
  }
}
