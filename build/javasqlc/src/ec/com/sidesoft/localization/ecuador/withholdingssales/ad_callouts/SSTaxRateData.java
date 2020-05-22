//Sqlc generated V1.O00-1
package ec.com.sidesoft.localization.ecuador.withholdingssales.ad_callouts;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

public class SSTaxRateData implements FieldProvider {
static Logger log4j = Logger.getLogger(SSTaxRateData.class);
  private String InitRecordNumber="0";
  public String taxrate;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("taxrate"))
      return taxrate;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SSTaxRateData[] select(ConnectionProvider connectionProvider, String c_tax_id)    throws ServletException {
    return select(connectionProvider, c_tax_id, 0, 0);
  }

  public static SSTaxRateData[] select(ConnectionProvider connectionProvider, String c_tax_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		SELECT rate AS taxrate" +
      "        FROM c_tax" +
      "        WHERE c_tax_id = ?";

    ResultSet result;
    Vector<SSTaxRateData> vector = new Vector<SSTaxRateData>(0);
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
        SSTaxRateData objectSSTaxRateData = new SSTaxRateData();
        objectSSTaxRateData.taxrate = UtilSql.getValue(result, "taxrate");
        objectSSTaxRateData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSSTaxRateData);
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
    SSTaxRateData objectSSTaxRateData[] = new SSTaxRateData[vector.size()];
    vector.copyInto(objectSSTaxRateData);
    return(objectSSTaxRateData);
  }
}
