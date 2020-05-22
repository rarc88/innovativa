//Sqlc generated V1.O00-1
package ec.com.sidesoft.custom.payroll.partialpayment.ad_process;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

public class ArchPartialPaymentBankXLSData2 implements FieldProvider {
static Logger log4j = Logger.getLogger(ArchPartialPaymentBankXLSData2.class);
  private String InitRecordNumber="0";
  public String descripcion;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("descripcion"))
      return descripcion;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ArchPartialPaymentBankXLSData2[] description(ConnectionProvider connectionProvider, String scpp_approvalpayment_id)    throws ServletException {
    return description(connectionProvider, scpp_approvalpayment_id, 0, 0);
  }

  public static ArchPartialPaymentBankXLSData2[] description(ConnectionProvider connectionProvider, String scpp_approvalpayment_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select SSPH_Tenth_Settlement.description AS descripcion from scpp_approvalpayment " +
      "      left join SSPH_Tenth_Settlement  on scpp_approvalpayment.SSPH_Tenth_Settlement_id=SSPH_Tenth_Settlement.SSPH_Tenth_Settlement_id" +
      "      where scpp_approvalpayment.scpp_approvalpayment_id=?";

    ResultSet result;
    Vector<ArchPartialPaymentBankXLSData2> vector = new Vector<ArchPartialPaymentBankXLSData2>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, scpp_approvalpayment_id);

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
        ArchPartialPaymentBankXLSData2 objectArchPartialPaymentBankXLSData2 = new ArchPartialPaymentBankXLSData2();
        objectArchPartialPaymentBankXLSData2.descripcion = UtilSql.getValue(result, "descripcion");
        objectArchPartialPaymentBankXLSData2.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectArchPartialPaymentBankXLSData2);
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
    ArchPartialPaymentBankXLSData2 objectArchPartialPaymentBankXLSData2[] = new ArchPartialPaymentBankXLSData2[vector.size()];
    vector.copyInto(objectArchPartialPaymentBankXLSData2);
    return(objectArchPartialPaymentBankXLSData2);
  }
}
