//Sqlc generated V1.O00-1
package ec.com.sidesoft.quick.billing.event;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class SqbBEventQuickBillingTaxData implements FieldProvider {
static Logger log4j = Logger.getLogger(SqbBEventQuickBillingTaxData.class);
  private String InitRecordNumber="0";
  public String indice;
  public String impuesto;
  public String rownum;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("indice"))
      return indice;
    else if (fieldName.equalsIgnoreCase("impuesto"))
      return impuesto;
    else if (fieldName.equals("rownum"))
      return rownum;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SqbBEventQuickBillingTaxData[] selectedtax(ConnectionProvider connectionProvider, String dateinvoice)    throws ServletException {
    return selectedtax(connectionProvider, dateinvoice, 0, 0);
  }

  public static SqbBEventQuickBillingTaxData[] selectedtax(ConnectionProvider connectionProvider, String dateinvoice, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "                select to_number(e.rate) as indice" +
      "                ,e.c_tax_id  as impuesto  " +
      "                from c_tax e where  e.rate <> 0     " +
      "                and e.istaxdeductable ='Y'   " +
      "                and validfrom = (select max(validfrom)  as validfrom    " +
      "                                from c_tax e where e.rate <> 0     " +
      "                                and e.istaxdeductable ='Y' and validfrom <= ?" +
      "                                )";

    ResultSet result;
    Vector<SqbBEventQuickBillingTaxData> vector = new Vector<SqbBEventQuickBillingTaxData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateinvoice);

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
        SqbBEventQuickBillingTaxData objectSqbBEventQuickBillingTaxData = new SqbBEventQuickBillingTaxData();
        objectSqbBEventQuickBillingTaxData.indice = UtilSql.getValue(result, "indice");
        objectSqbBEventQuickBillingTaxData.impuesto = UtilSql.getValue(result, "impuesto");
        objectSqbBEventQuickBillingTaxData.rownum = Long.toString(countRecord);
        objectSqbBEventQuickBillingTaxData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSqbBEventQuickBillingTaxData);
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
    SqbBEventQuickBillingTaxData objectSqbBEventQuickBillingTaxData[] = new SqbBEventQuickBillingTaxData[vector.size()];
    vector.copyInto(objectSqbBEventQuickBillingTaxData);
    return(objectSqbBEventQuickBillingTaxData);
  }
}
