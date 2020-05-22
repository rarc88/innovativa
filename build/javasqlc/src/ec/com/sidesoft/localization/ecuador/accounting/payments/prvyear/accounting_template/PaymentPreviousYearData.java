//Sqlc generated V1.O00-1
package ec.com.sidesoft.localization.ecuador.accounting.payments.prvyear.accounting_template;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class PaymentPreviousYearData implements FieldProvider {
static Logger log4j = Logger.getLogger(PaymentPreviousYearData.class);
  private String InitRecordNumber="0";
  public String finPaymentId;
  public String finPaymentIdUsed;
  public String paymentdate;
  public String creditdate;
  public String paymentyear;
  public String credityear;
  public String previousyear;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("fin_payment_id") || fieldName.equals("finPaymentId"))
      return finPaymentId;
    else if (fieldName.equalsIgnoreCase("fin_payment_id_used") || fieldName.equals("finPaymentIdUsed"))
      return finPaymentIdUsed;
    else if (fieldName.equalsIgnoreCase("paymentdate"))
      return paymentdate;
    else if (fieldName.equalsIgnoreCase("creditdate"))
      return creditdate;
    else if (fieldName.equalsIgnoreCase("paymentyear"))
      return paymentyear;
    else if (fieldName.equalsIgnoreCase("credityear"))
      return credityear;
    else if (fieldName.equalsIgnoreCase("previousyear"))
      return previousyear;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static PaymentPreviousYearData[] selectPreviousYear(ConnectionProvider connectionProvider, String FIN_Payment_Credit_id)    throws ServletException {
    return selectPreviousYear(connectionProvider, FIN_Payment_Credit_id, 0, 0);
  }

  public static PaymentPreviousYearData[] selectPreviousYear(ConnectionProvider connectionProvider, String FIN_Payment_Credit_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       select a.fin_payment_id, a.fin_payment_id_used," +
      "		b.paymentdate as paymentdate, c.paymentdate as creditdate," +
      "		to_number(to_char(b.paymentdate,'YYYY')) as paymentyear," +
      "		to_number(to_char(c.paymentdate,'YYYY')) as credityear," +
      "		case when to_number(to_char(b.paymentdate,'YYYY')) <> to_number(to_char(c.paymentdate,'YYYY')) then 'true' else 'false' end previousyear" +
      "		from FIN_Payment_Credit a " +
      "		left join fin_payment b on b.fin_payment_id = a.fin_payment_id" +
      "		left join fin_payment c on c.fin_payment_id = a.fin_payment_id_used" +
      "		where a.FIN_Payment_Credit_id = ? ";

    ResultSet result;
    Vector<PaymentPreviousYearData> vector = new Vector<PaymentPreviousYearData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, FIN_Payment_Credit_id);

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
        PaymentPreviousYearData objectPaymentPreviousYearData = new PaymentPreviousYearData();
        objectPaymentPreviousYearData.finPaymentId = UtilSql.getValue(result, "fin_payment_id");
        objectPaymentPreviousYearData.finPaymentIdUsed = UtilSql.getValue(result, "fin_payment_id_used");
        objectPaymentPreviousYearData.paymentdate = UtilSql.getDateValue(result, "paymentdate", "dd-MM-yyyy");
        objectPaymentPreviousYearData.creditdate = UtilSql.getDateValue(result, "creditdate", "dd-MM-yyyy");
        objectPaymentPreviousYearData.paymentyear = UtilSql.getValue(result, "paymentyear");
        objectPaymentPreviousYearData.credityear = UtilSql.getValue(result, "credityear");
        objectPaymentPreviousYearData.previousyear = UtilSql.getValue(result, "previousyear");
        objectPaymentPreviousYearData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectPaymentPreviousYearData);
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
    PaymentPreviousYearData objectPaymentPreviousYearData[] = new PaymentPreviousYearData[vector.size()];
    vector.copyInto(objectPaymentPreviousYearData);
    return(objectPaymentPreviousYearData);
  }
}
