package ec.com.sidesoft.quick.billing.ad_callouts;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;

import org.openbravo.dal.core.OBContext;
import org.openbravo.data.UtilSql;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;
import org.openbravo.service.db.DalConnectionProvider;

public class Sqb_GetPartnerIfExist extends SimpleCallout {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Override
  protected void execute(CalloutInfo info) throws ServletException {

    @SuppressWarnings("unused")
    String language = OBContext.getOBContext().getLanguage().getLanguage();
    ConnectionProvider conn = new DalConnectionProvider(false);
    String strQTaxID = info.getStringParameter("inptaxid", null) == null ? "ND" : info
        .getStringParameter("inptaxid", null);

    if (!strQTaxID.equals("ND")) {
      Object objInfoPartner[] = new Object[6];
      objInfoPartner = getInformationParnter(conn, strQTaxID);

      if (objInfoPartner.length > 0) {
        info.addResult("inpname",
            String.valueOf(objInfoPartner[0] == null ? "" : objInfoPartner[0]));
        if (objInfoPartner.length >= 1) {
          info.addResult("inpphone",
              String.valueOf(objInfoPartner[1] == null ? "" : objInfoPartner[1]));
        }
        if (objInfoPartner.length >= 2) {
          info.addResult("inpaddress",
              String.valueOf(objInfoPartner[2] == null ? "" : objInfoPartner[2]));
        }
        if (objInfoPartner.length >= 3) {
          info.addResult("inpemail",
              String.valueOf(objInfoPartner[3] == null ? "" : objInfoPartner[3]));
        }
        if (objInfoPartner.length >= 4) {
          String strPartnerID = (String) (objInfoPartner[4] == null ? "" : objInfoPartner[4]);
          if (!strPartnerID.equals("")) {
            info.addResult("inpcBpartnerId", (strPartnerID));
          }
        }
        if (objInfoPartner.length >= 5) {
          info.addResult("inptaxidtype",
              String.valueOf(objInfoPartner[5] == null ? "" : objInfoPartner[5]));
        }
      }
    }
  }

  public static Object[] getInformationParnter(ConnectionProvider connectionProvider,
      String strPartnerTaxid) throws ServletException {
    Object objPartner[] = new Object[6];
    String strSql = "";
    strSql = strSql
        + "select "
        + " cbp.name as nombre"
        + " ,cbpl.phone as telefono"
        + " ,coalesce(cl.address1,'') || coalesce(cl.address2,'') as direccion"
        + " ,coalesce(sqb_get_partner_email( cbp.c_bpartner_id),'') as correo"
        + " ,cbp.c_bpartner_id as partner    "
        + ",(CASE sqb_partner_taxidtype(CBP.C_BPARTNER_ID) WHEN 'R'  THEN 'R'  "
        + "     WHEN 'D' THEN 'CI' WHEN 'P' THEN 'P' ELSE 'ND' END) as tipoci   "
        + "from c_bpartner cbp  "
        + " left join c_bpartner_location cbpl on cbp.c_bpartner_id = cbpl.c_bpartner_id and cbpl.isbillto= 'Y'  "
        + " left join c_location cl on cl.c_location_id = cbpl.c_location_id   "
        + " where cbp.taxid= '" + strPartnerTaxid + "' and cbp.isactive='Y'";

    ResultSet result;
    PreparedStatement st = null;

    try {
      st = connectionProvider.getPreparedStatement(strSql);

      result = st.executeQuery();
      if (result.next()) {
        objPartner[0] = UtilSql.getValue(result, "nombre");
        objPartner[1] = UtilSql.getValue(result, "telefono");
        objPartner[2] = UtilSql.getValue(result, "direccion");
        objPartner[3] = UtilSql.getValue(result, "correo");
        objPartner[4] = UtilSql.getValue(result, "partner");
        objPartner[5] = UtilSql.getValue(result, "tipoci");

      }

      result.close();
    } catch (SQLException e) {
      // log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
    } catch (Exception ex) {
      // log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch (Exception ignore) {
        ignore.printStackTrace();
      }
    }
    return objPartner;
  }
}