package ec.com.sidesoft.quick.billing.ad_callouts;

import javax.servlet.ServletException;

import org.openbravo.erpCommon.ad_callouts.SimpleCallout;

public class Sqb_UpdateNewFieldPartner extends SimpleCallout {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Override
  protected void execute(CalloutInfo info) throws ServletException {

    String strTaxid = info.getStringParameter("inptaxid", null);
    String strName = info.getStringParameter("inpname", null);
    info.addResult("inpemSqbNameTaxid", strTaxid + " - " + strName);

  }
}