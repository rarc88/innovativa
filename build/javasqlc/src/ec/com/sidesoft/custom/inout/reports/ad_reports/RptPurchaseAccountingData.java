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

class RptPurchaseAccountingData implements FieldProvider {
static Logger log4j = Logger.getLogger(RptPurchaseAccountingData.class);
  private String InitRecordNumber="0";
  public String organizationid;
  public String documentno;
  public String description;
  public String date1;
  public String partner;
  public String address;
  public String tax;
  public String authorization;
  public String expireddate;
  public String accountcod;
  public String det;
  public String debit;
  public String credit;
  public String formpay;
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
    else if (fieldName.equalsIgnoreCase("authorization"))
      return authorization;
    else if (fieldName.equalsIgnoreCase("expireddate"))
      return expireddate;
    else if (fieldName.equalsIgnoreCase("accountcod"))
      return accountcod;
    else if (fieldName.equalsIgnoreCase("det"))
      return det;
    else if (fieldName.equalsIgnoreCase("debit"))
      return debit;
    else if (fieldName.equalsIgnoreCase("credit"))
      return credit;
    else if (fieldName.equalsIgnoreCase("formpay"))
      return formpay;
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

  public static RptPurchaseAccountingData[] select(ConnectionProvider connectionProvider, String invoice)    throws ServletException {
    return select(connectionProvider, invoice, 0, 0);
  }

  public static RptPurchaseAccountingData[] select(ConnectionProvider connectionProvider, String invoice, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	    select i.ad_org_id as organizationid, 'ASIENTO DE COMPRAS ' || i.documentno as documentno, i.description as description, to_char(i.dateinvoiced) as date1," +
      "			bp.name as partner, cbl.name as address, bp.taxid as tax, i.EM_Sswh_Nroauthorization as authorization, to_char(i.EM_Sswh_Expirationdate) as expireddate," +
      "		e.value as accountcod, e.name as det, a.amtacctdr as debit, a.amtacctcr as credit," +
      "		fp.name as formpay, i.poreference as reference, cbl.phone as phone,cc.name as costcenter" +
      "		, upper(cd.name) || ' - ' || i.documentno as lbldocumentno" +
      "		,au.name as usuario" +
      "		,to_char(a.created, 'dd/MM/yyyy HH24:MI:SS') as creacion" +
      "		,to_char(now(),'dd/MM/yyyy') as fecha_actual   " +
      "		,i.poreference as referencia_fact " +
      "		from c_invoice i" +
      "		left join fact_acct a on a.record_id = i.c_invoice_id" +
      "		left join c_elementvalue e on e.c_elementvalue_id = a.account_id" +
      "		left join c_bpartner bp on bp.c_bpartner_id = i.c_bpartner_id" +
      "		left join c_bpartner_location cbl on cbl.c_bpartner_location_id = i.c_bpartner_location_id" +
      "		left join fin_paymentmethod fp on fp.fin_paymentmethod_id = i.FIN_Paymentmethod_ID  " +
      "		left join c_costcenter cc on cc.c_costcenter_id = a.c_costcenter_id" +
      "		left join c_doctype cd on cd.c_doctype_id = a.c_doctype_id  " +
      "		left join ad_user au on au.ad_user_id = a.createdby  " +
      "		where i.c_invoice_id =  ?";

    ResultSet result;
    Vector<RptPurchaseAccountingData> vector = new Vector<RptPurchaseAccountingData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoice);

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
        RptPurchaseAccountingData objectRptPurchaseAccountingData = new RptPurchaseAccountingData();
        objectRptPurchaseAccountingData.organizationid = UtilSql.getValue(result, "organizationid");
        objectRptPurchaseAccountingData.documentno = UtilSql.getValue(result, "documentno");
        objectRptPurchaseAccountingData.description = UtilSql.getValue(result, "description");
        objectRptPurchaseAccountingData.date1 = UtilSql.getValue(result, "date1");
        objectRptPurchaseAccountingData.partner = UtilSql.getValue(result, "partner");
        objectRptPurchaseAccountingData.address = UtilSql.getValue(result, "address");
        objectRptPurchaseAccountingData.tax = UtilSql.getValue(result, "tax");
        objectRptPurchaseAccountingData.authorization = UtilSql.getValue(result, "authorization");
        objectRptPurchaseAccountingData.expireddate = UtilSql.getValue(result, "expireddate");
        objectRptPurchaseAccountingData.accountcod = UtilSql.getValue(result, "accountcod");
        objectRptPurchaseAccountingData.det = UtilSql.getValue(result, "det");
        objectRptPurchaseAccountingData.debit = UtilSql.getValue(result, "debit");
        objectRptPurchaseAccountingData.credit = UtilSql.getValue(result, "credit");
        objectRptPurchaseAccountingData.formpay = UtilSql.getValue(result, "formpay");
        objectRptPurchaseAccountingData.reference = UtilSql.getValue(result, "reference");
        objectRptPurchaseAccountingData.phone = UtilSql.getValue(result, "phone");
        objectRptPurchaseAccountingData.costcenter = UtilSql.getValue(result, "costcenter");
        objectRptPurchaseAccountingData.lbldocumentno = UtilSql.getValue(result, "lbldocumentno");
        objectRptPurchaseAccountingData.usuario = UtilSql.getValue(result, "usuario");
        objectRptPurchaseAccountingData.creacion = UtilSql.getValue(result, "creacion");
        objectRptPurchaseAccountingData.fechaActual = UtilSql.getValue(result, "fecha_actual");
        objectRptPurchaseAccountingData.referenciaFact = UtilSql.getValue(result, "referencia_fact");
        objectRptPurchaseAccountingData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptPurchaseAccountingData);
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
    RptPurchaseAccountingData objectRptPurchaseAccountingData[] = new RptPurchaseAccountingData[vector.size()];
    vector.copyInto(objectRptPurchaseAccountingData);
    return(objectRptPurchaseAccountingData);
  }

  public static RptPurchaseAccountingData[] set()    throws ServletException {
    RptPurchaseAccountingData objectRptPurchaseAccountingData[] = new RptPurchaseAccountingData[1];
    objectRptPurchaseAccountingData[0] = new RptPurchaseAccountingData();
    objectRptPurchaseAccountingData[0].organizationid = "";
    objectRptPurchaseAccountingData[0].documentno = "";
    objectRptPurchaseAccountingData[0].description = "";
    objectRptPurchaseAccountingData[0].date1 = "";
    objectRptPurchaseAccountingData[0].partner = "";
    objectRptPurchaseAccountingData[0].address = "";
    objectRptPurchaseAccountingData[0].tax = "";
    objectRptPurchaseAccountingData[0].authorization = "";
    objectRptPurchaseAccountingData[0].expireddate = "";
    objectRptPurchaseAccountingData[0].accountcod = "";
    objectRptPurchaseAccountingData[0].det = "";
    objectRptPurchaseAccountingData[0].debit = "";
    objectRptPurchaseAccountingData[0].credit = "";
    objectRptPurchaseAccountingData[0].formpay = "";
    objectRptPurchaseAccountingData[0].reference = "";
    objectRptPurchaseAccountingData[0].phone = "";
    objectRptPurchaseAccountingData[0].costcenter = "";
    objectRptPurchaseAccountingData[0].lbldocumentno = "";
    objectRptPurchaseAccountingData[0].usuario = "";
    objectRptPurchaseAccountingData[0].creacion = "";
    objectRptPurchaseAccountingData[0].fechaActual = "";
    objectRptPurchaseAccountingData[0].referenciaFact = "";
    return objectRptPurchaseAccountingData;
  }
}
