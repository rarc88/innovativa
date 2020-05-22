package com.sidesoft.ecuador.asset.allocation.ad_process;

import java.util.Calendar;

import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.DalBaseProcess;
import org.openbravo.service.db.DalConnectionProvider;

import com.sidesoft.ecuador.asset.allocation.SsalApplActive;

public class Approved_state extends DalBaseProcess {
  OBError message;

  protected void doExecute(ProcessBundle bundle) throws Exception {
    String language = OBContext.getOBContext().getLanguage().getLanguage();
    ConnectionProvider conn = new DalConnectionProvider(false);

    try {
      message = new OBError();
      processRequest(bundle);
    } catch (Exception e) {
      message.setTitle(Utility.messageBD(conn, "Ssal_Title_Approved_Error", language));
      message.setType("Error");
      message.setMessage(Utility.messageBD(conn, "Ssal_Error_Approved", language));
    } finally {
      bundle.setResult(message);
    }
    // Y process, N unprocess Status
  }

  private void processRequest(ProcessBundle bundle) {
    // Setting of the Variable idiom and Connection Session
    // Configurción de la variable idioma y la sesión de Conexión
    String language = OBContext.getOBContext().getLanguage().getLanguage();
    ConnectionProvider conn = new DalConnectionProvider(false);

    // Substract to value of the parametters session that corresponding to the
    // primary key of the table Ssal_Appl_Active
    // Substraemos el valor del parametro de sesión que corresponde a la
    // clave primaria de la tabla Ssal_Appl_Active

    String fixed_asset_id = (String) bundle.getParams().get("Ssal_Appl_Active_ID");

    // Declare an object of type SsalApplActive(Table Ssal_Appl_Active), sending as parametter
    // of the variable fixed_asset_id, that is equals to "Select * from Ssal_ApplActive where
    // Ssal_Appl_active = fixed_asset_id "

    // Declarar un objeto de tipo SsalApplActive(Table Ssal_Appl_Active), enviando como
    // parametro la variable fixed_asset_id, que es igual a "Select * from Ssal_ApplActive where
    // Ssal_Appl_active = fixed_asset_id "
    SsalApplActive fixed_asset = OBDal.getInstance().get(SsalApplActive.class, fixed_asset_id);

    Asset a_asset_id = fixed_asset.getAsset();
    Asset a_asset = OBDal.getInstance().get(Asset.class, a_asset_id.getId().toString());

    OBCriteria<SsalApplActive> ObjAssetList = OBDal.getInstance().createCriteria(
        SsalApplActive.class);
    ObjAssetList.add(Restrictions.eq(SsalApplActive.PROPERTY_ASSET, a_asset));
    ObjAssetList.add(Restrictions.eq(SsalApplActive.PROPERTY_PROCESSED, true));
    ObjAssetList.add(Restrictions.eq(SsalApplActive.PROPERTY_STATE, "3"));
    ObjAssetList.add(Restrictions.isNull(SsalApplActive.PROPERTY_ENDDATE));
    ObjAssetList.add(Restrictions.isNotNull(SsalApplActive.PROPERTY_CUSTODIAN));
    ObjAssetList.add(Restrictions.ne(SsalApplActive.PROPERTY_ID, fixed_asset_id));

    if (ObjAssetList.count() > 0) {

      throw new OBException("This asset is assigned to other custodian");
    } else {
      a_asset.setSsalIsavailable(false);
      fixed_asset.setState("3");
      fixed_asset.setProcessed(true);

      Calendar calendar = Calendar.getInstance();

      fixed_asset.setDateTransaction(calendar.getTime());

      message.setTitle(Utility.messageBD(conn, "ProcessOK", language));
      message.setType("Success");
      message.setMessage(Utility.messageBD(conn, "Request Approved Successfully", language));
      OBDal.getInstance().save(fixed_asset);
      OBDal.getInstance().flush();

    }
  }
}