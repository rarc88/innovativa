//Sqlc generated V1.O00-1
package ec.com.sidesoft.localization.ecuador.viatical.ad_callouts;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

public class SSVEEmployeeData implements FieldProvider {
static Logger log4j = Logger.getLogger(SSVEEmployeeData.class);
  private String InitRecordNumber="0";
  public String emSsprCity;
  public String taxid;
  public String ssprPositionId;
  public String emSsfiBanktransferId;
  public String bankaccounttype;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("em_sspr_city") || fieldName.equals("emSsprCity"))
      return emSsprCity;
    else if (fieldName.equalsIgnoreCase("taxid"))
      return taxid;
    else if (fieldName.equalsIgnoreCase("sspr_position_id") || fieldName.equals("ssprPositionId"))
      return ssprPositionId;
    else if (fieldName.equalsIgnoreCase("em_ssfi_banktransfer_id") || fieldName.equals("emSsfiBanktransferId"))
      return emSsfiBanktransferId;
    else if (fieldName.equalsIgnoreCase("bankaccounttype"))
      return bankaccounttype;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SSVEEmployeeData[] select(ConnectionProvider connectionProvider, String c_tax_id)    throws ServletException {
    return select(connectionProvider, c_tax_id, 0, 0);
  }

  public static SSVEEmployeeData[] select(ConnectionProvider connectionProvider, String c_tax_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		SELECT BP.EM_SSPR_CITY, BP.TAXID, CONPOS.SSPR_POSITION_ID, BACC.EM_SSFI_BANKTRANSFER_ID, BACC.BANKACCOUNTTYPE" +
      "        FROM C_BPARTNER BP" +
      "        LEFT JOIN C_BPARTNER_LOCATION BPL ON BP.C_BPARTNER_ID = BPL.C_BPARTNER_ID" +
      "        LEFT JOIN SSPR_CONTRACT CON ON BP.C_BPARTNER_ID = CON.C_BPARTNER_ID" +
      "        LEFT JOIN SSPR_CONTRACT_POSITION CONPOS ON CONPOS.SSPR_CONTRACT_ID = CON.SSPR_CONTRACT_ID" +
      "        LEFT JOIN C_BP_BANKACCOUNT BACC ON BACC.C_BPARTNER_ID = BP.C_BPARTNER_ID" +
      "        WHERE BP.ISEMPLOYEE = 'Y' " +
      "        AND BP.C_BPARTNER_ID = ?";

    ResultSet result;
    Vector<SSVEEmployeeData> vector = new Vector<SSVEEmployeeData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_tax_id);

      result = st.executeQuery();
      long countRecord = 0;
      long countRecordSkip = 1;
      boolean continueResult = true;
      while(countRecordSkip < firstRegister && continueResult) {
        continueResult = result.next();
        countRecordSkip++;
      }
      while(continueResult && result.next()) {
        countRecord++;
        SSVEEmployeeData objectSSVEEmployeeData = new SSVEEmployeeData();
        objectSSVEEmployeeData.emSsprCity = UtilSql.getValue(result, "em_sspr_city");
        objectSSVEEmployeeData.taxid = UtilSql.getValue(result, "taxid");
        objectSSVEEmployeeData.ssprPositionId = UtilSql.getValue(result, "sspr_position_id");
        objectSSVEEmployeeData.emSsfiBanktransferId = UtilSql.getValue(result, "em_ssfi_banktransfer_id");
        objectSSVEEmployeeData.bankaccounttype = UtilSql.getValue(result, "bankaccounttype");
        objectSSVEEmployeeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSSVEEmployeeData);
        if (countRecord >= numberRegisters && numberRegisters != 0) {
          continueResult = false;
        }
      }
      result.close();
    } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    SSVEEmployeeData objectSSVEEmployeeData[] = new SSVEEmployeeData[vector.size()];
    vector.copyInto(objectSSVEEmployeeData);
    return(objectSSVEEmployeeData);
  }
}
