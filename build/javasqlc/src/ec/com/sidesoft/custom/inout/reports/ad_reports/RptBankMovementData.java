//Sqlc generated V1.O00-1
package ec.com.sidesoft.custom.inout.reports.ad_reports;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class RptBankMovementData implements FieldProvider {
static Logger log4j = Logger.getLogger(RptBankMovementData.class);
  private String InitRecordNumber="0";
  public String organizationid;
  public String typedocument;
  public String statementdate;
  public String concept;
  public String conceptacct;
  public String name;
  public String account;
  public String det;
  public String debit;
  public String credit;
  public String documentno;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("organizationid"))
      return organizationid;
    else if (fieldName.equalsIgnoreCase("typedocument"))
      return typedocument;
    else if (fieldName.equalsIgnoreCase("statementdate"))
      return statementdate;
    else if (fieldName.equalsIgnoreCase("concept"))
      return concept;
    else if (fieldName.equalsIgnoreCase("conceptacct"))
      return conceptacct;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("account"))
      return account;
    else if (fieldName.equalsIgnoreCase("det"))
      return det;
    else if (fieldName.equalsIgnoreCase("debit"))
      return debit;
    else if (fieldName.equalsIgnoreCase("credit"))
      return credit;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static RptBankMovementData[] select(ConnectionProvider connectionProvider, String fin_financial_account)    throws ServletException {
    return select(connectionProvider, fin_financial_account, 0, 0);
  }

  public static RptBankMovementData[] select(ConnectionProvider connectionProvider, String fin_financial_account, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	     select fa.ad_org_id as organizationid, case when ft.depositamt > 0 Then 'INGRESO ' when ft.paymentamt > 0 Then 'EGRESO ' end as typedocument" +
      "		,to_char(ft.statementdate) as statementdate, upper(ft.description) as concept, gl.name as conceptacct, bp.name as name," +
      "		e.value as account, e.name as det, fta.amtsourcedr as debit, fta.amtsourcecr as credit, fp.documentno as documentno" +
      "		from fin_financial_account fa" +
      "		left join fin_finacc_transaction ft on ft.fin_financial_account_id = fa.fin_financial_account_id" +
      "		left join c_glitem gl on gl.c_glitem_id = ft.c_glitem_id" +
      "		left join fin_payment fp on fp.fin_payment_id = ft.fin_payment_id" +
      "		left join c_bpartner bp on bp.c_bpartner_id = ft.c_bpartner_id" +
      "		left join aprm_finacc_transaction_acct_v fta on fta.fin_finacc_transaction_id = ft.fin_finacc_transaction_id" +
      "		left join c_elementvalue e on e.c_elementvalue_id = fta.c_elementvalue_id" +
      "		where ft.fin_finacc_transaction_id  = ?" +
      "		order by fta.seqno asc";

    ResultSet result;
    Vector<RptBankMovementData> vector = new Vector<RptBankMovementData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, fin_financial_account);

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
        RptBankMovementData objectRptBankMovementData = new RptBankMovementData();
        objectRptBankMovementData.organizationid = UtilSql.getValue(result, "organizationid");
        objectRptBankMovementData.typedocument = UtilSql.getValue(result, "typedocument");
        objectRptBankMovementData.statementdate = UtilSql.getValue(result, "statementdate");
        objectRptBankMovementData.concept = UtilSql.getValue(result, "concept");
        objectRptBankMovementData.conceptacct = UtilSql.getValue(result, "conceptacct");
        objectRptBankMovementData.name = UtilSql.getValue(result, "name");
        objectRptBankMovementData.account = UtilSql.getValue(result, "account");
        objectRptBankMovementData.det = UtilSql.getValue(result, "det");
        objectRptBankMovementData.debit = UtilSql.getValue(result, "debit");
        objectRptBankMovementData.credit = UtilSql.getValue(result, "credit");
        objectRptBankMovementData.documentno = UtilSql.getValue(result, "documentno");
        objectRptBankMovementData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptBankMovementData);
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
    RptBankMovementData objectRptBankMovementData[] = new RptBankMovementData[vector.size()];
    vector.copyInto(objectRptBankMovementData);
    return(objectRptBankMovementData);
  }

  public static RptBankMovementData[] set()    throws ServletException {
    RptBankMovementData objectRptBankMovementData[] = new RptBankMovementData[1];
    objectRptBankMovementData[0] = new RptBankMovementData();
    objectRptBankMovementData[0].organizationid = "";
    objectRptBankMovementData[0].typedocument = "";
    objectRptBankMovementData[0].statementdate = "";
    objectRptBankMovementData[0].concept = "";
    objectRptBankMovementData[0].conceptacct = "";
    objectRptBankMovementData[0].name = "";
    objectRptBankMovementData[0].account = "";
    objectRptBankMovementData[0].det = "";
    objectRptBankMovementData[0].debit = "";
    objectRptBankMovementData[0].credit = "";
    objectRptBankMovementData[0].documentno = "";
    return objectRptBankMovementData;
  }
}
