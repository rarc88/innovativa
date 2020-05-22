//Sqlc generated V1.O00-1
package com.sidesoft.flopec.budget.reportrequestpayment;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class RptFinPaymentBudgetData implements FieldProvider {
static Logger log4j = Logger.getLogger(RptFinPaymentBudgetData.class);
  private String InitRecordNumber="0";
  public String finPaymentId;
  public String partnerRuc;
  public String writtingBy;
  public String documentoinvoice;
  public String anio;
  public String invoicedescription;
  public String localizacionUser;
  public String name1;
  public String namefiscal;
  public String nnf;
  public String titledocumyear;
  public String title;
  public String usser;
  public String valuecurrency;
  public String priceactual;
  public String currencyconvert;
  public String priceinletters;
  public String dateinvoiced;
  public String dateacct;
  public String createdbyName;
  public String area;
  public String factorconversion;
  public String grandtotalconvert;
  public String valor;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("fin_payment_id") || fieldName.equals("finPaymentId"))
      return finPaymentId;
    else if (fieldName.equalsIgnoreCase("partner_ruc") || fieldName.equals("partnerRuc"))
      return partnerRuc;
    else if (fieldName.equalsIgnoreCase("writting_by") || fieldName.equals("writtingBy"))
      return writtingBy;
    else if (fieldName.equalsIgnoreCase("documentoinvoice"))
      return documentoinvoice;
    else if (fieldName.equalsIgnoreCase("anio"))
      return anio;
    else if (fieldName.equalsIgnoreCase("invoicedescription"))
      return invoicedescription;
    else if (fieldName.equalsIgnoreCase("localizacion_user") || fieldName.equals("localizacionUser"))
      return localizacionUser;
    else if (fieldName.equalsIgnoreCase("name1"))
      return name1;
    else if (fieldName.equalsIgnoreCase("namefiscal"))
      return namefiscal;
    else if (fieldName.equalsIgnoreCase("nnf"))
      return nnf;
    else if (fieldName.equalsIgnoreCase("titledocumyear"))
      return titledocumyear;
    else if (fieldName.equalsIgnoreCase("title"))
      return title;
    else if (fieldName.equalsIgnoreCase("usser"))
      return usser;
    else if (fieldName.equalsIgnoreCase("valuecurrency"))
      return valuecurrency;
    else if (fieldName.equalsIgnoreCase("priceactual"))
      return priceactual;
    else if (fieldName.equalsIgnoreCase("currencyconvert"))
      return currencyconvert;
    else if (fieldName.equalsIgnoreCase("priceinletters"))
      return priceinletters;
    else if (fieldName.equalsIgnoreCase("dateinvoiced"))
      return dateinvoiced;
    else if (fieldName.equalsIgnoreCase("dateacct"))
      return dateacct;
    else if (fieldName.equalsIgnoreCase("createdby_name") || fieldName.equals("createdbyName"))
      return createdbyName;
    else if (fieldName.equalsIgnoreCase("area"))
      return area;
    else if (fieldName.equalsIgnoreCase("factorconversion"))
      return factorconversion;
    else if (fieldName.equalsIgnoreCase("grandtotalconvert"))
      return grandtotalconvert;
    else if (fieldName.equalsIgnoreCase("valor"))
      return valor;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static RptFinPaymentBudgetData[] select(ConnectionProvider connectionProvider, String invoice)    throws ServletException {
    return select(connectionProvider, invoice, 0, 0);
  }

  public static RptFinPaymentBudgetData[] select(ConnectionProvider connectionProvider, String invoice, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "select payment.fin_payment_id," +
      "partner.taxid as partner_ruc," +
      "coalesce(to_char(user_.name),'') || ' / ' || coalesce(to_char(sba.name),'') as writting_by," +
      "coalesce(to_char(payment.documentno),'') as documentoinvoice ," +
      "extract(year from payment.paymentdate) as anio," +
      "coalesce(to_char(payment.description),'') as invoicedescription," +
      "coalesce(to_char(partnerlocation.name),'')  as localizacion_user," +
      "coalesce(to_char(partner.name),'') as name1," +
      "coalesce(to_char(partner.name2),'') as NameFiscal," +
      "coalesce(to_char(partner.name),'') as NNF," +
      "coalesce(to_char(user_.title || ' - ' || payment.documentno || ' - ' ||  extract(year from payment.paymentdate)),'')  AS TitleDocumYear," +
      "coalesce(to_char(user_.title),'') as title," +
      "coalesce(to_char(user_.name),'') as usser," +
      "currency.iso_code as valuecurrency," +
      "payment.amount as priceactual ," +
      "'USD' as currencyconvert," +
      "coalesce(to_char((ssfl_convert_numbertoletters( (payment.amount)) || '          ' || currency.description)),'') as priceinletters," +
      "TO_CHAR(payment.created,'dd-MM-yyyy') AS dateinvoiced," +
      "TO_CHAR(payment.paymentdate,'dd-MM-yyyy') AS dateacct," +
      "USER_.name as createdby_name," +
      "sba.name as area," +
      "coalesce(to_number((case when payment.c_currency_id <> '100'  then cnvr.multiplyrate end)),0) as factorconversion," +
      "case when payment.c_currency_id ='100'then payment.amount else payment.amount * (coalesce(to_number((case when payment.c_currency_id <> '100'  then cnvr.multiplyrate end)),0))end as GrandTotalConvert," +
      "case when payment.c_currency_id ='100'then payment.amount else payment.amount * (coalesce(to_number((case when payment.c_currency_id <> '100'  then cnvr.multiplyrate end)),0))end as valor    " +
      " from fin_payment payment  " +
      " left join fin_payment_detail paymentdetail on paymentdetail.fin_payment_id = payment.fin_payment_id" +
      " left join c_bpartner partner on partner.c_bpartner_id =  payment.c_bpartner_id " +
      " left join c_bpartner_location partnerlocation on partnerlocation.c_bpartner_id = payment.c_bpartner_id and partnerlocation.isbillto='Y'" +
      " left join ad_user user_ on user_.ad_user_id = payment.createdby" +
      " left join c_currency currency on currency.c_currency_id = payment.c_currency_id " +
      " left join c_bpartner bpc on bpc.c_bpartner_id = payment.createdby" +
      " left join sfb_budget_area sba on sba.sfb_budget_area_id = payment.em_sfb_budget_area_id " +
      " left join c_conversion_rate cnvr on cnvr.c_currency_id = payment.c_currency_id and (payment.paymentdate between cnvr.validfrom and cnvr.validto )" +
      " WHERE payment.FIN_PAYMENT_ID = ?";

    ResultSet result;
    Vector<RptFinPaymentBudgetData> vector = new Vector<RptFinPaymentBudgetData>(0);
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
        RptFinPaymentBudgetData objectRptFinPaymentBudgetData = new RptFinPaymentBudgetData();
        objectRptFinPaymentBudgetData.finPaymentId = UtilSql.getValue(result, "fin_payment_id");
        objectRptFinPaymentBudgetData.partnerRuc = UtilSql.getValue(result, "partner_ruc");
        objectRptFinPaymentBudgetData.writtingBy = UtilSql.getValue(result, "writting_by");
        objectRptFinPaymentBudgetData.documentoinvoice = UtilSql.getValue(result, "documentoinvoice");
        objectRptFinPaymentBudgetData.anio = UtilSql.getValue(result, "anio");
        objectRptFinPaymentBudgetData.invoicedescription = UtilSql.getValue(result, "invoicedescription");
        objectRptFinPaymentBudgetData.localizacionUser = UtilSql.getValue(result, "localizacion_user");
        objectRptFinPaymentBudgetData.name1 = UtilSql.getValue(result, "name1");
        objectRptFinPaymentBudgetData.namefiscal = UtilSql.getValue(result, "namefiscal");
        objectRptFinPaymentBudgetData.nnf = UtilSql.getValue(result, "nnf");
        objectRptFinPaymentBudgetData.titledocumyear = UtilSql.getValue(result, "titledocumyear");
        objectRptFinPaymentBudgetData.title = UtilSql.getValue(result, "title");
        objectRptFinPaymentBudgetData.usser = UtilSql.getValue(result, "usser");
        objectRptFinPaymentBudgetData.valuecurrency = UtilSql.getValue(result, "valuecurrency");
        objectRptFinPaymentBudgetData.priceactual = UtilSql.getValue(result, "priceactual");
        objectRptFinPaymentBudgetData.currencyconvert = UtilSql.getValue(result, "currencyconvert");
        objectRptFinPaymentBudgetData.priceinletters = UtilSql.getValue(result, "priceinletters");
        objectRptFinPaymentBudgetData.dateinvoiced = UtilSql.getValue(result, "dateinvoiced");
        objectRptFinPaymentBudgetData.dateacct = UtilSql.getValue(result, "dateacct");
        objectRptFinPaymentBudgetData.createdbyName = UtilSql.getValue(result, "createdby_name");
        objectRptFinPaymentBudgetData.area = UtilSql.getValue(result, "area");
        objectRptFinPaymentBudgetData.factorconversion = UtilSql.getValue(result, "factorconversion");
        objectRptFinPaymentBudgetData.grandtotalconvert = UtilSql.getValue(result, "grandtotalconvert");
        objectRptFinPaymentBudgetData.valor = UtilSql.getValue(result, "valor");
        objectRptFinPaymentBudgetData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptFinPaymentBudgetData);
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
    RptFinPaymentBudgetData objectRptFinPaymentBudgetData[] = new RptFinPaymentBudgetData[vector.size()];
    vector.copyInto(objectRptFinPaymentBudgetData);
    return(objectRptFinPaymentBudgetData);
  }

  public static RptFinPaymentBudgetData[] set()    throws ServletException {
    RptFinPaymentBudgetData objectRptFinPaymentBudgetData[] = new RptFinPaymentBudgetData[1];
    objectRptFinPaymentBudgetData[0] = new RptFinPaymentBudgetData();
    objectRptFinPaymentBudgetData[0].finPaymentId = "";
    objectRptFinPaymentBudgetData[0].partnerRuc = "";
    objectRptFinPaymentBudgetData[0].writtingBy = "";
    objectRptFinPaymentBudgetData[0].documentoinvoice = "";
    objectRptFinPaymentBudgetData[0].anio = "";
    objectRptFinPaymentBudgetData[0].invoicedescription = "";
    objectRptFinPaymentBudgetData[0].localizacionUser = "";
    objectRptFinPaymentBudgetData[0].name1 = "";
    objectRptFinPaymentBudgetData[0].namefiscal = "";
    objectRptFinPaymentBudgetData[0].nnf = "";
    objectRptFinPaymentBudgetData[0].titledocumyear = "";
    objectRptFinPaymentBudgetData[0].title = "";
    objectRptFinPaymentBudgetData[0].usser = "";
    objectRptFinPaymentBudgetData[0].valuecurrency = "";
    objectRptFinPaymentBudgetData[0].priceactual = "";
    objectRptFinPaymentBudgetData[0].currencyconvert = "";
    objectRptFinPaymentBudgetData[0].priceinletters = "";
    objectRptFinPaymentBudgetData[0].dateinvoiced = "";
    objectRptFinPaymentBudgetData[0].dateacct = "";
    objectRptFinPaymentBudgetData[0].createdbyName = "";
    objectRptFinPaymentBudgetData[0].area = "";
    objectRptFinPaymentBudgetData[0].factorconversion = "";
    objectRptFinPaymentBudgetData[0].grandtotalconvert = "";
    objectRptFinPaymentBudgetData[0].valor = "";
    return objectRptFinPaymentBudgetData;
  }
}
