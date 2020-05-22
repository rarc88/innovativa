package ec.com.sidesoft.quick.billing.ad_callouts;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import javax.servlet.ServletException;

import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.financialmgmt.tax.TaxRate;
import org.openbravo.service.db.DalConnectionProvider;
import org.quartz.SchedulerContext;

import ec.com.sidesoft.quick.billing.SqbConfigUser;

public class Sqb_DiscountCalculate extends SimpleCallout {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public double dblPriceStandar, dblPriceList, dblqty;
	public static String dateTimeFormat;
	public static String sqlDateTimeFormat;
	private SchedulerContext ctx;
	public String strpartnerLocationAddress = "";

	@Override
	protected void execute(CalloutInfo info) throws ServletException {

		try {
			OBContext.setAdminMode();

			String language = OBContext.getOBContext().getLanguage().getLanguage();
			ConnectionProvider conn = new DalConnectionProvider(false);

			BigDecimal bgdDiscount = info.getBigDecimalParameter("inpdiscount");

			if (bgdDiscount.compareTo(BigDecimal.ZERO) == 1) {
				
			    User userQB = OBDal.getInstance().get(User.class, info.vars.getUser());
			    // Obtener configuración factura rápida
			    OBCriteria<SqbConfigUser> sqbConfigUser = OBDal.getInstance().createCriteria(
			        SqbConfigUser.class);
			    sqbConfigUser.add(Restrictions.eq(SqbConfigUser.PROPERTY_ACTIVE, true));
			    sqbConfigUser.add(Restrictions.eq(SqbConfigUser.PROPERTY_USER, userQB));

			    List<SqbConfigUser> sqbConfigUserList = sqbConfigUser.list();
			    if (sqbConfigUserList.size() == 0) {
					info.addResult("ERROR", "@Sqb_ErrorSetupQuickBilling@");
					throw new OBException(Utility.messageBD(conn, "Sqb_ErrorSetupQuickBilling", language));			    	
			    }
			    
			    int pricePrecision = sqbConfigUserList.get(0).getSQBConfigQuickbilling().getCurrency().getPricePrecision().intValue();
			    
				BigDecimal bgdQty = info.getBigDecimalParameter("inpqtyquickbilling");
				BigDecimal bgdPrice = info.getBigDecimalParameter("inppricequickbilling");
				BigDecimal bgdSubtotal = bgdQty.multiply(bgdPrice);

				BigDecimal bgdNewSubtotal = BigDecimal.ZERO;
				BigDecimal bgdTotalVAT = BigDecimal.ZERO;
				BigDecimal bgdDiscountAmt = (bgdSubtotal.multiply(bgdDiscount.divide(new BigDecimal(100)))).setScale(pricePrecision, RoundingMode.HALF_UP);
				bgdNewSubtotal = bgdSubtotal.subtract(bgdDiscountAmt);

				String strCTaxID = info.getStringParameter("inpcTaxId", null) == null ? "ND"
						: info.getStringParameter("inpcTaxId", null);
				if (strCTaxID.equals("ND")) {
					info.addResult("ERROR", "@Sqb_ErrorSetupTaxProduct@");
					throw new OBException(Utility.messageBD(conn, "Sqb_ErrorSetupTaxProduct", language));
				}
				OBCriteria<TaxRate> criteraTaxRate = OBDal.getInstance().createCriteria(TaxRate.class);
				criteraTaxRate.add(Restrictions.eq(TaxRate.PROPERTY_ID, strCTaxID));
				List<TaxRate> lstTaxtRate = criteraTaxRate.list();

				if (lstTaxtRate.size() > 0) {
					BigDecimal dblTaxVAT = BigDecimal.ZERO;

					BigDecimal dblTax = lstTaxtRate.get(0).getRate();
					if (dblTax.compareTo(BigDecimal.ZERO) == 1) {
						dblTaxVAT = dblTax.divide(new BigDecimal(100));
					}

					if (dblTaxVAT.compareTo(BigDecimal.ZERO) == 1) {
						bgdTotalVAT = bgdNewSubtotal.multiply(dblTaxVAT).setScale(pricePrecision, RoundingMode.HALF_UP);
					}
				}

				info.addResult("inpsubtotalQb", String.valueOf(bgdNewSubtotal));
				info.addResult("inpinitialSubtotal", String.valueOf(bgdSubtotal));
				info.addResult("inpvat", String.valueOf(bgdTotalVAT));
				info.addResult("inptotal", String.valueOf(bgdNewSubtotal.add(bgdTotalVAT)));
			}

		} catch (Exception e) {
			e.printStackTrace();
			info.addResult("ERROR", e.getMessage());
		} finally {
			OBContext.restorePreviousMode();
		}

	}

}