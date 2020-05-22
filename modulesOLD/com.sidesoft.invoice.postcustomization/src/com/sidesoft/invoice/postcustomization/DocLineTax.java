package com.sidesoft.invoice.postcustomization;

import org.apache.log4j.Logger;
import org.openbravo.erpCommon.ad_forms.DocTax;

public class DocLineTax extends DocTax {
  static Logger log4jDocTax = Logger.getLogger(DocTax.class);

  public DocLineTax(String C_Tax_ID, String name, String rate, String taxBaseAmt, String amount,
      boolean isUndeductable, boolean isTaxDeductable, String assetAcct, boolean isTaxExpence) {
    super(C_Tax_ID, name, rate, taxBaseAmt, amount, isUndeductable, isTaxDeductable);

    m_AssetAcct_ID = assetAcct;
    m_isTaxExpence = isTaxExpence;

  } // DocLineTax

  // DocLineTax

  /** AssetAcct ID */
  public String m_AssetAcct_ID = "";

  /** isTaxExpence */
  public boolean m_isTaxExpence = false;
}
