package ec.com.sidesoft.quick.billing.ad_process;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.ConfigParameters;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.data.UtilSql;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Language;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.businesspartner.Category;
import org.openbravo.model.common.businesspartner.Location;
import org.openbravo.model.financialmgmt.tax.TaxRate;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.DalBaseProcess;
import org.openbravo.service.db.DalConnectionProvider;
import org.quartz.SchedulerContext;

import com.sidesoft.localization.ecuador.withholdings.Taxpayer;

import ec.com.sidesoft.quick.billing.SqbConfigQuickBilling;
import ec.com.sidesoft.quick.billing.SqbConfigUser;
import ec.com.sidesoft.quick.billing.SqbQuickBilling;

public class Sqb_CreateCustomerQuickBilling extends DalBaseProcess {
  OBError message;
  static Logger log4j = Logger.getLogger(Sqb_CreateCustomerQuickBilling.class);

  public static String dateTimeFormat;
  public static String sqlDateTimeFormat;
  private SchedulerContext ctx;
  public TaxRate taxRate;

  @Override
  protected void doExecute(ProcessBundle bundle) throws Exception {
    String language = OBContext.getOBContext().getLanguage().getLanguage();
    ConnectionProvider conn = new DalConnectionProvider(false);

    try {
      message = new OBError();
      processRequest(bundle);
    } catch (Exception e) {
      message.setTitle(Utility.messageBD(conn, "Error", language));
      message.setType("Error");
      message.setMessage(e.getMessage());
    } finally {
      bundle.setResult(message);
      conn.destroy();
    }
    // Y process, N unprocess Status
  }

  private void processRequest(ProcessBundle bundle) {
    String strQuicBillingID = (String) bundle.getParams().get("SQB_Quickbilling_ID");

    VariablesSecureApp vars = bundle.getContext().toVars();
    String strAdUserID = vars.getUser() == null ? "ND" : vars.getUser();
    // Obtener usuario logeado
    User userQB = OBDal.getInstance().get(User.class, strAdUserID);

    // Datos del nuevo Tercero

    SqbQuickBilling sqbQuickBilling = OBDal.getInstance().get(SqbQuickBilling.class,
        strQuicBillingID);
    String strTaxid = sqbQuickBilling.getTaxid() == null ? "ND" : sqbQuickBilling.getTaxid();
    String strTaxidType = sqbQuickBilling.getTaxidtype() == null ? "ND" : sqbQuickBilling
        .getTaxidtype();
    String strName = sqbQuickBilling.getName() == null ? "ND" : sqbQuickBilling.getName();
    String strAddress = sqbQuickBilling.getAddress() == null ? "ND" : sqbQuickBilling.getAddress();
    String strPhone = sqbQuickBilling.getPhone() == null ? "ND" : sqbQuickBilling.getPhone();
    String strEmail = sqbQuickBilling.getEmail() == null ? "ND" : sqbQuickBilling.getEmail();

    // Obtner Configuración para Crear la Factura
    OBCriteria<SqbConfigUser> sqbConfigUser = OBDal.getInstance().createCriteria(
        SqbConfigUser.class);
    sqbConfigUser.add(Restrictions.eq(SqbConfigUser.PROPERTY_ACTIVE, true));
    sqbConfigUser.add(Restrictions.eq(SqbConfigUser.PROPERTY_USER, userQB));

    List<SqbConfigUser> sqbConfigUserList = sqbConfigUser.list();

    if (sqbConfigUserList.size() == 1) {

      SqbConfigQuickBilling sqbConfigCustomerList = OBDal.getInstance().get(
          SqbConfigQuickBilling.class, sqbConfigUserList.get(0).getSQBConfigQuickbilling().getId());

      // Instacia de Conexión
      String language = OBContext.getOBContext().getLanguage().getLanguage();
      ConnectionProvider conn = new DalConnectionProvider(false);
      String successMessage = null;

      // Grupo de Terceros
      String strGroupPartnerID = sqbConfigCustomerList.getBpGroup().getId() == null ? "ND"
          : sqbConfigCustomerList.getBpGroup().getId();

      Category grpCategoryPartner = OBDal.getInstance().get(Category.class, strGroupPartnerID);

      // Tipo de Contribuyente
      String strTaxPayeID = sqbConfigCustomerList.getSswhTaxpayer().getId() == null ? "ND"
          : sqbConfigCustomerList.getSswhTaxpayer().getId();

      Taxpayer taxpayer_Partner = OBDal.getInstance().get(Taxpayer.class, strTaxPayeID);

      // Idioma

      String strLanguageID = sqbConfigCustomerList.getLanguage().getId() == null ? "ND"
          : sqbConfigCustomerList.getLanguage().getId();

      Language language_qb = OBDal.getInstance().get(Language.class, strLanguageID);

      // País

      String strCountry_ID = sqbConfigCustomerList.getCountry().getId() == null ? "ND"
          : sqbConfigCustomerList.getCountry().getId();

      if (!strTaxid.equals("ND") && !strAddress.equals("ND") && !strName.equals("ND")
          && !strEmail.equals("ND") && !strGroupPartnerID.equals("ND")
          && !strLanguageID.equals("ND") && !strCountry_ID.equals("ND")
          && !strTaxPayeID.equals("ND")) {

        String str_Taxid_Type = "";
        // Tipo de Identificación
        if (strTaxidType.equals("CI")) {
          str_Taxid_Type = "D";
        } else if (strTaxidType.equals("R")) {
          str_Taxid_Type = "R";
        } else if (strTaxidType.equals("P")) {
          str_Taxid_Type = "P";
        }

        // Primero se busca el tercero para actualizar los datos
        OBCriteria<BusinessPartner> criteriaPartner = OBDal.getInstance().createCriteria(
            BusinessPartner.class);
        criteriaPartner.add(Restrictions.eq(BusinessPartner.PROPERTY_TAXID, strTaxid));
        List<BusinessPartner> partnerList = criteriaPartner.list();

        String StrResultPartner = "ND";

        try {
          ConnectionProvider conn_partner = new DalConnectionProvider(false);
          StrResultPartner = searchPartnerTaxid(conn_partner, strTaxid);
        } catch (ServletException e2) {
          // TODO Auto-generated catch block
          e2.printStackTrace();
          System.out.println(e2.getMessage());
        }

        if (partnerList.size() == 0 && StrResultPartner.equals("ND")) {

          // Tercero

          BusinessPartner newPartner = OBProvider.getInstance().get(BusinessPartner.class);
          newPartner.setSearchKey(strTaxid);
          newPartner.setTaxID(strTaxid);
          newPartner.setName(strName);
          newPartner.setName2(strName);
          newPartner.setSswhTaxidtype(str_Taxid_Type);
          newPartner.setBusinessPartnerCategory(grpCategoryPartner);
          newPartner.setLanguage(language_qb);
          newPartner.setSSWHTaxpayer(taxpayer_Partner);
          newPartner.setCustomer(true);
          newPartner.setSqbNameTaxid(strTaxid + " - " + strName);
          OBDal.getInstance().save(newPartner);
          OBDal.getInstance().flush();

          // Dirección

          String strNewLocationID = "";
          String strAddress1 = "";
          String strAddress2 = "";

          String sCadena = strAddress;
          char[] aCaracteres;
          int intAddres = strAddress.length();
          aCaracteres = sCadena.toCharArray();
          if (intAddres > 0) {

            for (int x = 0; x < aCaracteres.length; x++) {

              if (x < 60) {
                strAddress1 = strAddress1 + aCaracteres[x];
              }
              if (x > 60 && x <= 120) {
                strAddress2 = strAddress2 + aCaracteres[x];
              }
            }
          }

          try {

            // Añadir datos en la tabla c_location
            strNewLocationID = getUUID(conn);
            NewLocation(conn, strNewLocationID, strAddress1, strAddress2, strCountry_ID);

          } catch (ServletException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
          sqbQuickBilling.setBpartner(newPartner);
          OBDal.getInstance().save(sqbQuickBilling);
          OBDal.getInstance().flush();

          SqbQuickBilling sqbQuickBilling2 = OBDal.getInstance().get(SqbQuickBilling.class,
              strQuicBillingID);

          try {
            // Añadir datos en la tabla c_bpartner_location

            String strNewLocationID2 = getUUID(conn);
            NewPartnerLocation(conn, strNewLocationID2, strNewLocationID, strAddress1, strPhone,
                sqbQuickBilling2.getBpartner().getId());
          } catch (ServletException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }

          // Actualizar Tercero con la configuración de Facturación Electrónica

          try {
            if (getSearchModule(conn).equals("OK")) {
              String strMessageUpdatePartner = "";
              strMessageUpdatePartner = ExecuteUpdatePartner(sqbQuickBilling.getBpartner().getId(),
                  strQuicBillingID);
              if (!strMessageUpdatePartner.equals("OK")) {
                throw new OBException(Utility.messageBD(conn, strMessageUpdatePartner, language));
              }
            }
          } catch (ServletException e1) {

            System.out.println(e1.getMessage());
          }

          message.setTitle(Utility.messageBD(conn, "ProcessOK", language));
          message.setType("Success");
          message.setMessage(Utility.messageBD(conn, successMessage, language));

        } else {

          if (StrResultPartner.equals("OK")) {

            String strBPartnerID = "";

            try {
              ConnectionProvider conn_partnerid = new DalConnectionProvider(false);
              strBPartnerID = getPartnerID(conn_partnerid, strTaxid);
            } catch (ServletException e3) {
              e3.printStackTrace();
              System.out.println(e3.getMessage());
            }

            // Actualiza los datos del Tercero en caso de que ya exista en la BDD
            BusinessPartner partnerUpdate = OBDal.getInstance().get(BusinessPartner.class,
                strBPartnerID);
            if (partnerUpdate.isActive()) {

              partnerUpdate.setSqbNameTaxid(strTaxid + " - " + strName);
              partnerUpdate.setName(strName);
              partnerUpdate.setName2(strName);
              OBDal.getInstance().save(partnerUpdate);

              // Dirección

              String strAddress1 = "";
              String strAddress2 = "";

              String sCadena = strAddress;
              char[] aCaracteres;
              int intAddres = strAddress.length();
              aCaracteres = sCadena.toCharArray();
              if (intAddres > 0) {

                for (int x = 0; x < aCaracteres.length; x++) {

                  if (x < 60) {
                    strAddress1 = strAddress1 + aCaracteres[x];
                  }
                  if (x > 60 && x <= 120) {
                    strAddress2 = strAddress2 + aCaracteres[x];
                  }
                }
              }

              OBCriteria<Location> partnerLocationUpdate = OBDal.getInstance().createCriteria(
                  Location.class);
              partnerLocationUpdate.add(Restrictions.eq(Location.PROPERTY_BUSINESSPARTNER,
                  partnerUpdate));
              List<Location> partnerLocationList = partnerLocationUpdate.list();

              if (partnerLocationList.size() > 0) {
                String strGeoLocation = "";
                strGeoLocation = partnerLocationList.get(0).getLocationAddress().getId() == null ? ""
                    : partnerLocationList.get(0).getLocationAddress().getId();
                try {
                  UpdateGeoLocation(conn, strGeoLocation, strAddress1, strAddress2, strCountry_ID);
                } catch (ServletException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
                }

                Location obdalLocation = OBDal.getInstance().get(Location.class,
                    partnerLocationList.get(0).getId());
                obdalLocation.setName(strAddress1);
                obdalLocation.setPhone(strPhone);

                sqbQuickBilling.setBpartner(partnerUpdate);
                OBDal.getInstance().save(sqbQuickBilling);
                OBDal.getInstance().save(obdalLocation);
                OBDal.getInstance().commitAndClose();
              }

              String strMessageUpdatePartner = ExecuteUpdatePartner(sqbQuickBilling.getBpartner()
                  .getId(), strQuicBillingID);

              message.setTitle(Utility.messageBD(conn, "ProcessOK", language));
              message.setType("Success");

              message.setMessage(Utility.messageBD(conn, successMessage, language));
            } else {
              throw new OBException(Utility.messageBD(conn, "Sqb_ErrorPartnerExist", language));

            }
          }

        }

      } else {
        if (strGroupPartnerID.equals("ND"))
          throw new OBException(Utility.messageBD(conn, "Sqb_ErrorGroupPartner", language));
        if (strTaxPayeID.equals("ND"))
          throw new OBException(Utility.messageBD(conn, "Sqb_ErrorTaxpayer", language));
        if (strLanguageID.equals("ND"))
          throw new OBException(Utility.messageBD(conn, "Sqb_ErrorLanguagePartner", language));
        if (strCountry_ID.equals("ND"))
          throw new OBException(Utility.messageBD(conn, "Sqb_ErrorCountryPartner", language));

        if (!strAddress.equals("ND") || !strName.equals("ND")) {

          if (strTaxid.equals("ND"))
            throw new OBException(Utility.messageBD(conn, "Sqb_ErrorTaxIDPartner", language));
          if (strName.equals("ND"))
            throw new OBException(Utility.messageBD(conn, "Sqb_ErrorNamePartner", language));
          if (strAddress.equals("ND"))
            throw new OBException(Utility.messageBD(conn, "Sqb_ErrorAddressPartner", language));

          if (strEmail.equals("ND"))
            throw new OBException(Utility.messageBD(conn, "Sqb_ErrorEmailPartner", language));
        }
      }
    }
  }

  public static final String format(Date date) {
    return date == null ? null : new SimpleDateFormat(dateTimeFormat).format(date);
  }

  public ConfigParameters getConfigParameters() {
    return (ConfigParameters) ctx.get(ConfigParameters.CONFIG_ATTRIBUTE);
  }

  public void NewLocation(ConnectionProvider connectionProvider, String strNewLocation,
      String strAdd1, String StrAdd2, String strCountryID) throws ServletException {
    String strSql = "";
    strSql = strSql
        + "insert into c_location(c_location_id, ad_client_id, ad_org_id, isactive, createdby, created, updatedby, updated, address1, address2, c_country_id) values('"
        + strNewLocation + "','" + OBContext.getOBContext().getCurrentClient().getId() + "','"
        + OBContext.getOBContext().getCurrentOrganization().getId() + "','Y','"
        + OBContext.getOBContext().getUser().getId() + "',now(),'"
        + OBContext.getOBContext().getUser().getId() + "',now(),'" + strAdd1 + "','" + StrAdd2
        + "','" + strCountryID + "')";

    int updateCount = 0;
    PreparedStatement st = null;

    try {
      st = connectionProvider.getPreparedStatement(strSql);

      updateCount = st.executeUpdate();
      st.close();
    } catch (SQLException e) {
      // log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      // throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" +
      // e.getMessage());
    } catch (Exception ex) {
      // log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      // throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
        connectionProvider.destroy();
      } catch (Exception ignore) {
        ignore.printStackTrace();
      }
    }
  }

  public void UpdateGeoLocation(ConnectionProvider connectionProvider, String strNewLocation,
      String strAdd1, String StrAdd2, String strCountryID) throws ServletException {
    String strSql = "";
    strSql = strSql + "update c_location set address1= '" + strAdd1 + "',  address2= '" + StrAdd2
        + "', c_country_id ='" + strCountryID + "' where c_location_id = '" + strNewLocation + "'";

    int updateCount = 0;
    PreparedStatement st = null;

    try {
      st = connectionProvider.getPreparedStatement(strSql);

      updateCount = st.executeUpdate();
      st.close();
    } catch (SQLException e) {
      // log4j.error("SQL error in query: " + strSql + "Exception:"+ e);
      // throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" +
      // e.getMessage());
    } catch (Exception ex) {
      // log4j.error("Exception in query: " + strSql + "Exception:"+ ex);
      // throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
        connectionProvider.destroy();
      } catch (Exception ignore) {
        ignore.printStackTrace();
      }
    }
  }

  public void NewPartnerLocation(ConnectionProvider connectionProvider, String strNewLocation,
      String strLocationID, String strAdd1, String str_Phone, String strPartnerID)
      throws ServletException {
    String strSql = "";
    strSql = strSql
        + "insert into c_bpartner_location(c_bpartner_location_id, ad_client_id, ad_org_id, isactive, createdby, created, updatedby, updated, name,isbillto, isshipto,ispayfrom,isremitto,c_bpartner_id, phone, c_location_id) values('"
        + strNewLocation + "','" + OBContext.getOBContext().getCurrentClient().getId() + "','"
        + OBContext.getOBContext().getCurrentOrganization().getId() + "','Y','"
        + OBContext.getOBContext().getUser().getId() + "',now(),'"
        + OBContext.getOBContext().getUser().getId() + "',now(),'" + strAdd1
        + "','Y','Y','Y','Y','" + strPartnerID + "','" + str_Phone.replace("ND", "") + "','"
        + strLocationID + "')";

    int updateCount = 0;
    PreparedStatement st = null;

    try {
      st = connectionProvider.getPreparedStatement(strSql);
      updateCount = st.executeUpdate();
      st.close();

    } catch (SQLException e) {
      log4j.error("SQL error in query: " + strSql + "Exception:" + e);
      // throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" +
      // e.getMessage());
    } catch (Exception ex) {
      log4j.error("Exception in query: " + strSql + "Exception:" + ex);
      // throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
        connectionProvider.destroy();
      } catch (Exception ignore) {
        ignore.printStackTrace();
      }
    }
  }

  public static String getUUID(ConnectionProvider connectionProvider) throws ServletException {
    String strSql = "";
    strSql = strSql + "       SELECT get_uuid() as name" + "       FROM dual";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    try {
      st = connectionProvider.getPreparedStatement(strSql);

      result = st.executeQuery();
      if (result.next()) {
        strReturn = UtilSql.getValue(result, "name");
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
        connectionProvider.destroy();
      } catch (Exception ignore) {
        ignore.printStackTrace();
      }
    }
    return (strReturn);
  }

  public static String searchPartnerTaxid(ConnectionProvider connectionProvider, String strTaxid)
      throws ServletException {
    String strSql = "";
    strSql = strSql + "       SELECT to_char('OK') as tercero from c_bpartner where taxid = '"
        + strTaxid + "'";

    ResultSet result;
    String strReturn = "ND";
    PreparedStatement st = null;

    try {
      st = connectionProvider.getPreparedStatement(strSql);

      result = st.executeQuery();
      if (result.next()) {
        strReturn = UtilSql.getValue(result, "tercero") == null ? "ND" : UtilSql.getValue(result,
            "tercero");
      }
      result.close();
      st.close();
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
        connectionProvider.destroy();
      } catch (Exception ignore) {
        ignore.printStackTrace();
      }
    }
    return (strReturn);
  }

  public static String getPartnerID(ConnectionProvider connectionProvider, String strTaxid)
      throws ServletException {
    String strSql = "";
    strSql = strSql + "       SELECT c_bpartner_id as tercero from c_bpartner where taxid = '"
        + strTaxid + "'";

    ResultSet result;
    String strReturn = "ND";
    PreparedStatement st = null;

    try {
      st = connectionProvider.getPreparedStatement(strSql);

      result = st.executeQuery();
      if (result.next()) {
        strReturn = UtilSql.getValue(result, "tercero") == null ? "ND" : UtilSql.getValue(result,
            "tercero");
      }
      result.close();
      st.close();
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
        connectionProvider.destroy();
      } catch (Exception ignore) {
        ignore.printStackTrace();
      }
    }
    return (strReturn);
  }

  public static String getSearchModule(ConnectionProvider connectionProvider)
      throws ServletException {
    String strSql = "";
    strSql = strSql + "       SELECT to_char('OK') as resultado"
        + "       FROM ad_module where javapackage ='" + "ec.cusoft.facturaec" + "'";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    try {
      st = connectionProvider.getPreparedStatement(strSql);

      result = st.executeQuery();
      if (result.next()) {
        strReturn = UtilSql.getValue(result, "resultado");
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
        connectionProvider.destroy();
      } catch (Exception ignore) {
        ignore.printStackTrace();
      }
    }
    return (strReturn);
  }

  public String ExecuteUpdatePartner(String strPartner, String str_QuickBilling) {
    try {
      org.openbravo.database.ConnectionProvider cp = new DalConnectionProvider(false);
      CallableStatement cs = cp.getConnection().prepareCall("{call SQB_PARTNER_UPDATE_FE(?,?)}");

      // client
      cs.setString(1, strPartner);
      cs.setString(2, str_QuickBilling);
      cs.execute();
      cs.close();
      return "OK";
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return e.getMessage().toString();
    }
  }
}