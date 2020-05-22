package ec.com.sidesoft.innovativa.invoice.ad_callouts;

import javax.servlet.ServletException;

import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;
import org.openbravo.model.pricing.priceadjustment.PriceAdjustment;

public class InvoiceSalesPricingAdjustment extends SimpleCallout {

  /**
           * 
           */
  private static final long serialVersionUID = 12L;

  protected void execute(CalloutInfo info) throws ServletException {
    // TODO Auto-generated method stub

    String StrOfferID = info.getStringParameter("inpemSeiiMOfferId", null);
    PriceAdjustment ObjPriceAdj = OBDal.getInstance().get(PriceAdjustment.class, StrOfferID);

    if (ObjPriceAdj.getId() != null) {
      String StrPrice = ObjPriceAdj.getFixedPrice().toString();

      info.addResult("inppriceactual", StrPrice);
    }

  }

}
