package ec.com.sidesoft.quick.billing.ad_callouts;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;

import org.hibernate.criterion.Restrictions;
import org.openbravo.base.ConfigParameters;
import org.openbravo.base.exception.OBException;
import org.openbravo.client.kernel.RequestContext;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.data.UtilSql;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.businessUtility.Tax;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.financialmgmt.tax.TaxRate;
import org.openbravo.service.db.DalConnectionProvider;
import org.quartz.SchedulerContext;

import ec.com.sidesoft.quick.billing.SqbConfigQuickBilling;
import ec.com.sidesoft.quick.billing.SqbConfigUser;
import ec.com.sidesoft.quick.billing.SqbQuickBilling;

public class Sqb_CalloutProduct extends Sqb_DiscountCalculate {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  public double dblPriceStandar, dblPriceList;
  public static String dateTimeFormat;
  public static String sqlDateTimeFormat;
  private SchedulerContext ctx;
  public String strpartnerLocationAddress = "";

  @Override
  protected void execute(CalloutInfo info) throws ServletException {

    try {
      OBContext.setAdminMode();

      // Instacia de Conexión
      String language = OBContext.getOBContext().getLanguage().getLanguage();
      ConnectionProvider conn = new DalConnectionProvider(false);
      String successMessage = null;

      // Obtener Datos Facturación Rápida
      String strProductID = info.getStringParameter("inpmProductId", null);
      BigDecimal bgdQty = info.getBigDecimalParameter("inpqtyquickbilling");
      BigDecimal bgdPrice = info.getBigDecimalParameter("inppricequickbilling");
      String strQuickBillingID = info.getStringParameter("inpsqbQuickbillingId", null);

      // Recuperar Formato de Fecha SQL
      ConfigParameters cf = ConfigParameters.retrieveFrom(RequestContext.get().getRequest()
          .getSession().getServletContext());
      dateTimeFormat = cf.getJavaDateTimeFormat();

      // Obtener el precio del Producto
      String strUser = OBContext.getOBContext().getUser().getId();

      dblPriceStandar = 0;
      dblPriceList = 0;

      if (!strUser.isEmpty()) {

        SqbQuickBillingPriceData[] sqbQuickBillingPrice = SqbQuickBillingPriceData.selectprice(this,
            strUser, strProductID);
        for (int i = 0; i < sqbQuickBillingPrice.length; i++) {
          dblPriceStandar = Double.valueOf(sqbQuickBillingPrice[i].pricestd);
          dblPriceList = Double.valueOf(sqbQuickBillingPrice[i].pricelist);
        }
        info.addResult("inppricequickbilling", String.valueOf(dblPriceStandar));
      } else {
        info.addResult("inppricequickbilling", String.valueOf("0"));
      }

      if (!bgdQty.equals(BigDecimal.ZERO) && (dblPriceStandar != 0.0)) {

        SqbQuickBilling obdalQuickBilling = OBDal.getInstance().get(SqbQuickBilling.class,
            strQuickBillingID);

        BusinessPartner obdalPartner = OBDal.getInstance().get(BusinessPartner.class,
            obdalQuickBilling.getBpartner().getId());

        int intCountPartnerLocation = obdalPartner.getBusinessPartnerLocationList().size();

        if (intCountPartnerLocation == 0) {
          throw new OBException(Utility.messageBD(conn, "@Sqb_ErrorPartnerLocationProduct@",
              language));

        }
        String strPartnerLocationID = obdalPartner.getBusinessPartnerLocationList().get(0).getId() == null ? "ND"
            : obdalPartner.getBusinessPartnerLocationList().get(0).getId();

        String strCTaxID = "ND";

        String strOrganizationLocationID = "ND";

        try {
          strOrganizationLocationID = getOrganizationInfoLocationID(conn, OBContext.getOBContext()
              .getCurrentOrganization().getId()) == null ? "ND" : getOrganizationInfoLocationID(
              conn, OBContext.getOBContext().getCurrentOrganization().getId());
        } catch (OBException e) {

        }

        if (strOrganizationLocationID.equals("ND")) {
          throw new OBException(Utility.messageBD(conn, "@Sqb_ErrorPartnerLocationProduct@",
              language));

        }

        try {
          strCTaxID = Tax.get(this, strProductID, format(new Date()), OBContext.getOBContext()
              .getCurrentOrganization().getId(), null, strPartnerLocationID,
              strOrganizationLocationID, null, true, false) == null ? "ND" : Tax.get(this,
              strProductID, format(new Date()), OBContext.getOBContext().getCurrentOrganization()
                  .getId(), null, strPartnerLocationID, strOrganizationLocationID, null, true,
              false);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        if (!strCTaxID.equals("ND")) {
          info.addResult("inpcTaxId", strCTaxID);

          OBCriteria<TaxRate> criteraTaxRate = OBDal.getInstance().createCriteria(TaxRate.class);
          criteraTaxRate.add(Restrictions.eq(TaxRate.PROPERTY_ID, strCTaxID));
          List<TaxRate> lstTaxtRate = criteraTaxRate.list();

          if (lstTaxtRate.size() >= 0) {

        	// Obtener configuración factura rápida
        	User userQB = OBDal.getInstance().get(User.class, info.vars.getUser());

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
      	  	
            double dblTax = Double.valueOf(lstTaxtRate.get(0).getRate().toString());
            double dblTaxVAT = 0;
            double dblTotalProduct = 0;
            double dblTotalVAT = 0;
            double dblGTotal = 0;

            if (dblTax > 0) {
              dblTaxVAT = dblTax / 100;
            }

            dblTotalProduct = bgdQty.doubleValue() * dblPriceStandar;

            if (dblTaxVAT > 0) {
            	dblTotalVAT = Double.valueOf((new BigDecimal(Double.toString(dblTotalProduct * dblTaxVAT)).setScale(pricePrecision, RoundingMode.HALF_UP)).toString());
            }

            dblGTotal = dblTotalProduct + dblTotalVAT;

            info.addResult("inppricequickbilling", String.valueOf(dblPriceStandar));
            info.addResult("inpsubtotalQb", String.valueOf(dblTotalProduct));
            info.addResult("inpvat", String.valueOf(dblTotalVAT));
            info.addResult("inptotal", String.valueOf(dblGTotal));
            info.addResult("inpcTaxId", strCTaxID);

          } else {
            info.addResult("inpsubtotalQb", "0");
            info.addResult("inpvat", "0");
            info.addResult("inptotal", "0");
          }
        }
      } else {

        info.addResult("inpsubtotalQb", "0");
        info.addResult("inpvat", "0");
        info.addResult("inptotal", "0");
      }
      super.execute(info);
    } finally {
      OBContext.restorePreviousMode();
    }

  }

  public static final String format(Date date) {
    return date == null ? null : new SimpleDateFormat(dateTimeFormat).format(date);
  }

  public ConfigParameters getConfigParameters() {
    return (ConfigParameters) ctx.get(ConfigParameters.CONFIG_ATTRIBUTE);
  }

  public static String getOrganizationInfoLocationID(ConnectionProvider connectionProvider,
      String strOrgID) throws ServletException {
    String strSql = "";
    strSql = strSql + "       select c_location_id from ad_orginfo  where ad_org_id='" + strOrgID
        + "'";

    ResultSet result;
    String strReturn = "ND";
    PreparedStatement st = null;

    try {
      st = connectionProvider.getPreparedStatement(strSql);

      result = st.executeQuery();
      if (result.next()) {
        strReturn = UtilSql.getValue(result, "c_location_id");
      }
      result.close();
    } catch (SQLException e) {
      // log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@"
          + e.getMessage());
    } catch (Exception ex) {
      // log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch (Exception ignore) {
        ignore.printStackTrace();
      }
    }
    return (strReturn);
  }
}