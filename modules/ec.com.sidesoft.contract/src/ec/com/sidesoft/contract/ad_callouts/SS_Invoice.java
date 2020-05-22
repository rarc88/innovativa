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
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;

//import org.openbravo.erpCommon.businessUtility.BpartnerMiscData;
//importar el xsql - en estecaso desde eldirectorio - pakete
import org.hibernate.criterion.Restrictions;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.common.invoice.InvoiceTax;
import org.openbravo.model.financialmgmt.tax.TaxRate;

public class SS_Invoice extends SimpleCallout {
  private static final long serialVersionUID = 1L;

  @SuppressWarnings("null")
  @Override
  protected void execute(CalloutInfo info) throws ServletException {

    String srtContractid = info.getStringParameter("inpssctContractId", null);
    String srtInvoiceid = info.getStringParameter("inpcInvoiceId", null);
    String srtPaymentid = info.getStringParameter("inpfinPaymentId", null);

    if (!srtInvoiceid.isEmpty()) {

      // OBCriteria<Invoice> ObjInvoiceList = OBDal.getInstance().createCriteria(Invoice.class);
      // ObjInvoiceList.add(Restrictions.eq(Invoice.PROPERTY_ID, srtInvoiceid));

      Invoice ObjInvoiceList = OBDal.getInstance().get(Invoice.class, srtInvoiceid);

      if (!ObjInvoiceList.getId().isEmpty()) {

        // OBTENGO ID DEL TAX IVA
        Double strRate = 12.00;

        BigDecimal StrRateV = BigDecimal.valueOf(strRate);
        BigDecimal StrRateV2 = BigDecimal.valueOf(strRate);

        OBCriteria<TaxRate> ObjTaxList = OBDal.getInstance().createCriteria(TaxRate.class);
        ObjTaxList.add(Restrictions.eq("rate", StrRateV2));

        String strIdtax = ObjTaxList.list().get(0).getId().toString();

        TaxRate ObjectTaxRate = OBDal.getInstance().get(TaxRate.class, strIdtax);

        // for (TaxRate OBJTaxList : ObjTaxList.list()) {
        // OBTENGO LINEA DE IMPUESTO DE LA FACTURA

        OBCriteria<InvoiceTax> ObjInvoiceTaxList = OBDal.getInstance().createCriteria(
            InvoiceTax.class);
        ObjInvoiceTaxList.add(Restrictions.eq(InvoiceTax.PROPERTY_INVOICE, ObjInvoiceList));
        ObjInvoiceTaxList.add(Restrictions.eq(InvoiceTax.PROPERTY_TAX, ObjectTaxRate));

        /*
         * InvoiceTax ObjInvoiceTaxList = findDALInstance(false, InvoiceTax.class, new
         * Value("invoice", ObjInvoiceList), new Value("tax", ObjectTaxRate));
         */

        // OBTENGO VALOR DEL IVA
        Double StrIva = 0.00;
        if (ObjInvoiceTaxList.count() > 0) {
          StrIva = Double.valueOf(ObjInvoiceTaxList.list().get(0).getTaxAmount().toString());
        }
        BigDecimal strFinalIva = BigDecimal.valueOf(StrIva);

        // OBTENGO SUBTOTAL DE FACTURA
        Double StrTotallines = 0.00;
        StrTotallines = Double.valueOf(ObjInvoiceList.getSummedLineAmount().toString());
        BigDecimal strFinalTotallines = BigDecimal.valueOf(StrTotallines);

        // OBTENGO TOTAL DE FACTURA
        Double StrTotal = 0.00;
        StrTotal = Double.valueOf(ObjInvoiceList.getGrandTotalAmount().toString());
        BigDecimal strFinalTotal = BigDecimal.valueOf(StrTotal);

        // OBTENGO FECHA DE FACTURA
        Date StrDate = null;
        StrDate = ObjInvoiceList.getInvoiceDate();

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String dates = "";

        dates = formatter.format(StrDate);

        // ACTUALIZO VALORES EN EL REGISTRO
        if (StrIva > 0) {
          info.addResult("inpvat", strFinalIva);
        } else {
          info.addResult("inpvat", strFinalIva);
        }

        if (StrTotallines > 0) {
          info.addResult("inptotallines", strFinalTotallines);
        } else {
          info.addResult("inptotallines", strFinalTotallines);
        }
        if (StrTotal > 0) {
          info.addResult("inpgrandtotal", strFinalTotal);
        } else {
          info.addResult("inpgrandtotal", strFinalTotal);
        }

        if (!dates.isEmpty()) {
          info.addResult("inpdateinvoiced", dates);
        } else {
          info.addResult("inpdateinvoiced", dates);
        }
        // }
      }
    }
  }

}
