package ec.com.sidesoft.secondary.accounting;

import java.util.Map;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.Query;
import org.openbravo.client.application.process.BaseProcessActionHandler;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.service.db.DbUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SSACCTDeletePosting extends BaseProcessActionHandler {

  private static final Logger log4j = LoggerFactory.getLogger(SSACCTDeletePosting.class);

  @Override
  protected JSONObject doExecute(Map<String, Object> parameters, String content) {
    JSONObject jsonResponse = new JSONObject();
    JSONObject errorMessage = new JSONObject();
    OBError msg = new OBError();
    JSONObject jsonRequest = null;
    try {
      try {
        jsonRequest = new JSONObject(content);
        JSONObject jsonparams = jsonRequest.getJSONObject("_params");
        boolean deleterecord = (Boolean) jsonparams.get("deleterecord");
        if (deleterecord) {
          // String strUpdate = "";
          String inpssacctJournalId = (String) jsonRequest.get("inpssacctJournalId");
          String tableId = jsonRequest.getString("inpTableId");
          String client = jsonRequest.getString("inpadClientId");
          SSACCTJOURNAL ssacctJournal = OBDal.getInstance().get(SSACCTJOURNAL.class,
              inpssacctJournalId);
          ssacctJournal.setPosted("N");
          OBDal.getInstance().flush();

          String strDelete = "delete from SSACCT_AccountingFactSecondary where table.id = :tableId and recordID = :transactions and client.id = :clientId ";
          final Query delete = OBDal.getInstance().getSession().createQuery(strDelete);
          delete.setString("tableId", tableId);
          delete.setString("transactions", inpssacctJournalId);
          delete.setString("clientId", client);
          int deleted = delete.executeUpdate();

          OBDal.getInstance().getConnection().commit();
          OBDal.getInstance().getSession().clear();

          msg.setType("Success");
          msg.setMessage(OBMessageUtils.messageBD("Success"));

          errorMessage = new JSONObject();

          errorMessage.put("severity", "success");
          errorMessage.put("text", msg.getMessage());
          jsonResponse.put("message", errorMessage);

          return jsonResponse;
        }
      } catch (final Exception e) {
        OBDal.getInstance().rollbackAndClose();
        String message = DbUtility.getUnderlyingSQLException(e).getMessage();
        log4j.error(message, e);
        errorMessage.put("severity", "error");
        errorMessage.put("title", OBMessageUtils.messageBD("Error"));
        errorMessage.put("text", message);
        jsonResponse.put("message", errorMessage);
        return jsonResponse;
      }
    } catch (JSONException e1) {
      e1.printStackTrace();
    }
    return jsonResponse;
  }

}
