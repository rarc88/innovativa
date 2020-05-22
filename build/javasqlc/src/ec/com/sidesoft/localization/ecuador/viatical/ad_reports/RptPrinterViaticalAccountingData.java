//Sqlc generated V1.O00-1
package ec.com.sidesoft.localization.ecuador.viatical.ad_reports;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class RptPrinterViaticalAccountingData implements FieldProvider {
static Logger log4j = Logger.getLogger(RptPrinterViaticalAccountingData.class);
  private String InitRecordNumber="0";
  public String organizationid;
  public String documentno;
  public String description;
  public String date1;
  public String partner;
  public String address;
  public String tax;
  public String accountcod;
  public String det;
  public String debit;
  public String credit;
  public String reference;
  public String phone;
  public String costcenter;
  public String lbldocumentno;
  public String usuario;
  public String creacion;
  public String fechaActual;
  public String referenciaFact;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("organizationid"))
      return organizationid;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("date1"))
      return date1;
    else if (fieldName.equalsIgnoreCase("partner"))
      return partner;
    else if (fieldName.equalsIgnoreCase("address"))
      return address;
    else if (fieldName.equalsIgnoreCase("tax"))
      return tax;
    else if (fieldName.equalsIgnoreCase("accountcod"))
      return accountcod;
    else if (fieldName.equalsIgnoreCase("det"))
      return det;
    else if (fieldName.equalsIgnoreCase("debit"))
      return debit;
    else if (fieldName.equalsIgnoreCase("credit"))
      return credit;
    else if (fieldName.equalsIgnoreCase("reference"))
      return reference;
    else if (fieldName.equalsIgnoreCase("phone"))
      return phone;
    else if (fieldName.equalsIgnoreCase("costcenter"))
      return costcenter;
    else if (fieldName.equalsIgnoreCase("lbldocumentno"))
      return lbldocumentno;
    else if (fieldName.equalsIgnoreCase("usuario"))
      return usuario;
    else if (fieldName.equalsIgnoreCase("creacion"))
      return creacion;
    else if (fieldName.equalsIgnoreCase("fecha_actual") || fieldName.equals("fechaActual"))
      return fechaActual;
    else if (fieldName.equalsIgnoreCase("referencia_fact") || fieldName.equals("referenciaFact"))
      return referenciaFact;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static RptPrinterViaticalAccountingData[] select(ConnectionProvider connectionProvider, String viatical)    throws ServletException {
    return select(connectionProvider, viatical, 0, 0);
  }

  public static RptPrinterViaticalAccountingData[] select(ConnectionProvider connectionProvider, String viatical, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "			select" +
      "			i.ad_org_id as organizationid," +
      "			'ASIENTO DE VI��TICOS ' || i.documentno as documentno," +
      "			i.description as description," +
      "			to_char(i.viaticaldate) as date1," +
      "			bp.name as partner," +
      "			( SELECT name FROM c_bpartner_location " +
      "			WHERE c_bpartner_id = bp.c_bpartner_id " +
      "			AND created = (SELECT MAX(created) FROM c_bpartner_location " +
      "			WHERE c_bpartner_id = bp.c_bpartner_id)) as address," +
      "			bp.taxid as tax," +
      "			e.value as accountcod," +
      "			e.name as det," +
      "			a.amtacctdr as debit," +
      "			a.amtacctcr as credit," +
      "			i.documentno as reference," +
      "			( SELECT phone FROM c_bpartner_location " +
      "			WHERE c_bpartner_id = bp.c_bpartner_id " +
      "			AND created = (SELECT MAX(created) FROM c_bpartner_location " +
      "			WHERE c_bpartner_id = bp.c_bpartner_id)) as phone," +
      "			cc.name as costcenter" +
      "			, upper(cd.name) || ' - ' || i.documentno as lbldocumentno" +
      "			,au.name as usuario" +
      "			,to_char(a.created, 'dd/MM/yyyy HH24:MI:SS') as creacion" +
      "			,to_char(now(),'dd/MM/yyyy') as fecha_actual" +
      "			,i.leavewithpay as referencia_fact" +
      "			from SSVE_Viatical_Settlement i" +
      "			left join fact_acct a on a.record_id = i.ssve_viatical_settlement_id" +
      "			left join c_elementvalue e on e.c_elementvalue_id = a.account_id" +
      "			left join c_bpartner bp on bp.c_bpartner_id = i.c_bpartner_id" +
      "			left join c_costcenter cc on cc.c_costcenter_id = a.c_costcenter_id" +
      "			left join c_doctype cd on cd.c_doctype_id = a.c_doctype_id" +
      "			left join ad_user au on au.ad_user_id = a.createdby" +
      "			where i.ssve_viatical_settlement_id =  ?";

    ResultSet result;
    Vector<RptPrinterViaticalAccountingData> vector = new Vector<RptPrinterViaticalAccountingData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, viatical);

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
        RptPrinterViaticalAccountingData objectRptPrinterViaticalAccountingData = new RptPrinterViaticalAccountingData();
        objectRptPrinterViaticalAccountingData.organizationid = UtilSql.getValue(result, "organizationid");
        objectRptPrinterViaticalAccountingData.documentno = UtilSql.getValue(result, "documentno");
        objectRptPrinterViaticalAccountingData.description = UtilSql.getValue(result, "description");
        objectRptPrinterViaticalAccountingData.date1 = UtilSql.getValue(result, "date1");
        objectRptPrinterViaticalAccountingData.partner = UtilSql.getValue(result, "partner");
        objectRptPrinterViaticalAccountingData.address = UtilSql.getValue(result, "address");
        objectRptPrinterViaticalAccountingData.tax = UtilSql.getValue(result, "tax");
        objectRptPrinterViaticalAccountingData.accountcod = UtilSql.getValue(result, "accountcod");
        objectRptPrinterViaticalAccountingData.det = UtilSql.getValue(result, "det");
        objectRptPrinterViaticalAccountingData.debit = UtilSql.getValue(result, "debit");
        objectRptPrinterViaticalAccountingData.credit = UtilSql.getValue(result, "credit");
        objectRptPrinterViaticalAccountingData.reference = UtilSql.getValue(result, "reference");
        objectRptPrinterViaticalAccountingData.phone = UtilSql.getValue(result, "phone");
        objectRptPrinterViaticalAccountingData.costcenter = UtilSql.getValue(result, "costcenter");
        objectRptPrinterViaticalAccountingData.lbldocumentno = UtilSql.getValue(result, "lbldocumentno");
        objectRptPrinterViaticalAccountingData.usuario = UtilSql.getValue(result, "usuario");
        objectRptPrinterViaticalAccountingData.creacion = UtilSql.getValue(result, "creacion");
        objectRptPrinterViaticalAccountingData.fechaActual = UtilSql.getValue(result, "fecha_actual");
        objectRptPrinterViaticalAccountingData.referenciaFact = UtilSql.getValue(result, "referencia_fact");
        objectRptPrinterViaticalAccountingData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptPrinterViaticalAccountingData);
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
    RptPrinterViaticalAccountingData objectRptPrinterViaticalAccountingData[] = new RptPrinterViaticalAccountingData[vector.size()];
    vector.copyInto(objectRptPrinterViaticalAccountingData);
    return(objectRptPrinterViaticalAccountingData);
  }

  public static RptPrinterViaticalAccountingData[] set()    throws ServletException {
    RptPrinterViaticalAccountingData objectRptPrinterViaticalAccountingData[] = new RptPrinterViaticalAccountingData[1];
    objectRptPrinterViaticalAccountingData[0] = new RptPrinterViaticalAccountingData();
    objectRptPrinterViaticalAccountingData[0].organizationid = "";
    objectRptPrinterViaticalAccountingData[0].documentno = "";
    objectRptPrinterViaticalAccountingData[0].description = "";
    objectRptPrinterViaticalAccountingData[0].date1 = "";
    objectRptPrinterViaticalAccountingData[0].partner = "";
    objectRptPrinterViaticalAccountingData[0].address = "";
    objectRptPrinterViaticalAccountingData[0].tax = "";
    objectRptPrinterViaticalAccountingData[0].accountcod = "";
    objectRptPrinterViaticalAccountingData[0].det = "";
    objectRptPrinterViaticalAccountingData[0].debit = "";
    objectRptPrinterViaticalAccountingData[0].credit = "";
    objectRptPrinterViaticalAccountingData[0].reference = "";
    objectRptPrinterViaticalAccountingData[0].phone = "";
    objectRptPrinterViaticalAccountingData[0].costcenter = "";
    objectRptPrinterViaticalAccountingData[0].lbldocumentno = "";
    objectRptPrinterViaticalAccountingData[0].usuario = "";
    objectRptPrinterViaticalAccountingData[0].creacion = "";
    objectRptPrinterViaticalAccountingData[0].fechaActual = "";
    objectRptPrinterViaticalAccountingData[0].referenciaFact = "";
    return objectRptPrinterViaticalAccountingData;
  }
}
