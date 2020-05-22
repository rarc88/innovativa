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

class RptEntryCellarData implements FieldProvider {
static Logger log4j = Logger.getLogger(RptEntryCellarData.class);
  private String InitRecordNumber="0";
  public String organizationid;
  public String documentno;
  public String partner;
  public String address;
  public String phone;
  public String taxid;
  public String movementdate;
  public String formpay;
  public String conditionpay;
  public String referenceinvoice;
  public String product;
  public String productcod;
  public String movementqty;
  public String unitprice;
  public String amountline;
  public String tax;
  public String total;
  public String cOrderId;
  public String mProductId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("organizationid"))
      return organizationid;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("partner"))
      return partner;
    else if (fieldName.equalsIgnoreCase("address"))
      return address;
    else if (fieldName.equalsIgnoreCase("phone"))
      return phone;
    else if (fieldName.equalsIgnoreCase("taxid"))
      return taxid;
    else if (fieldName.equalsIgnoreCase("movementdate"))
      return movementdate;
    else if (fieldName.equalsIgnoreCase("formpay"))
      return formpay;
    else if (fieldName.equalsIgnoreCase("conditionpay"))
      return conditionpay;
    else if (fieldName.equalsIgnoreCase("referenceinvoice"))
      return referenceinvoice;
    else if (fieldName.equalsIgnoreCase("product"))
      return product;
    else if (fieldName.equalsIgnoreCase("productcod"))
      return productcod;
    else if (fieldName.equalsIgnoreCase("movementqty"))
      return movementqty;
    else if (fieldName.equalsIgnoreCase("unitprice"))
      return unitprice;
    else if (fieldName.equalsIgnoreCase("amountline"))
      return amountline;
    else if (fieldName.equalsIgnoreCase("tax"))
      return tax;
    else if (fieldName.equalsIgnoreCase("total"))
      return total;
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static RptEntryCellarData[] select(ConnectionProvider connectionProvider, String m_inout)    throws ServletException {
    return select(connectionProvider, m_inout, 0, 0);
  }

  public static RptEntryCellarData[] select(ConnectionProvider connectionProvider, String m_inout, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "         select io.ad_org_id as organizationid, 'INGRESO A BODEGA No. ' || io.documentno as documentno, cb.name as partner, cbl.name as address, cbl.phone as phone, cb.taxid, to_char(io.movementdate) as movementdate," +
      "        fp.name as formpay, cp.name as conditionpay, io.poreference as referenceinvoice," +
      "        p.name as product, p.value as productcod,coalesce(iol.movementqty,0) as movementqty, " +
      "        coalesce(co.pricelist,co1.pricelist, 0) as unitprice, " +
      "        round((coalesce(iol.movementqty,0) * coalesce(co.pricelist,co1.pricelist, 0)),2) as amountline, " +
      "        round((round((coalesce(iol.movementqty,0)*  coalesce(co.pricelist,co1.pricelist, 0)),2)  * coalesce(t.rate,t2.rate,0))/100,2) as tax, " +
      "        round((round((coalesce(iol.movementqty,0)*  coalesce(co.pricelist,co1.pricelist, 0)),2)  * coalesce(t.rate,t2.rate,0))/100,2) + " +
      "        round((coalesce(iol.movementqty,0) * coalesce(co.pricelist,co1.pricelist, 0)),2) as total," +
      "	io.c_order_id," +
      "        p.m_product_id " +
      "        from m_inout io" +
      "        left join m_inoutline iol on iol.m_inout_id = io.m_inout_id" +
      "        left join c_bpartner cb on cb.c_bpartner_id = io.c_bpartner_id" +
      "        left join c_bpartner_location cbl on cbl.c_bpartner_id = cb.c_bpartner_id and cbl.isbillto='Y' and cbl.isactive='Y'  " +
      "        left join c_location cl on cl.c_location_id = cbl.c_location_id" +
      "        left join fin_paymentmethod fp on fp.fin_paymentmethod_id = cb.po_paymentmethod_id" +
      "        left join C_PaymentTerm cp on cp.C_PaymentTerm_ID = cb.PO_PaymentTerm_ID" +
      "        left join m_product p on p.m_product_id = iol.m_product_id" +
      "        left join c_orderline co on co.c_orderline_id = iol.c_orderline_id" +
      "        left join c_tax t on t.c_tax_id = co.c_tax_id" +
      "        left join c_orderline co1 on co1.c_orderline_id = co.c_orderline_id   " +
      "        left join c_tax t2 on t2.c_tax_id =co1.c_tax_id" +
      "        where io.m_inout_id = ?  " +
      "	and co1.c_orderline_id = (select min(c_orderline_id) " +
      "		from(select co.c_orderline_id " +
      "		     from c_orderline co " +
      "		     where co.m_product_id = m_product_id and co.c_order_id= c_order_id " +
      "		     group by co.line ,co.created, co.c_orderline_id" +
      "		     order by co.line asc , co.created asc) cons)  " +
      "        order by iol.line asc";

    ResultSet result;
    Vector<RptEntryCellarData> vector = new Vector<RptEntryCellarData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, m_inout);

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
        RptEntryCellarData objectRptEntryCellarData = new RptEntryCellarData();
        objectRptEntryCellarData.organizationid = UtilSql.getValue(result, "organizationid");
        objectRptEntryCellarData.documentno = UtilSql.getValue(result, "documentno");
        objectRptEntryCellarData.partner = UtilSql.getValue(result, "partner");
        objectRptEntryCellarData.address = UtilSql.getValue(result, "address");
        objectRptEntryCellarData.phone = UtilSql.getValue(result, "phone");
        objectRptEntryCellarData.taxid = UtilSql.getValue(result, "taxid");
        objectRptEntryCellarData.movementdate = UtilSql.getValue(result, "movementdate");
        objectRptEntryCellarData.formpay = UtilSql.getValue(result, "formpay");
        objectRptEntryCellarData.conditionpay = UtilSql.getValue(result, "conditionpay");
        objectRptEntryCellarData.referenceinvoice = UtilSql.getValue(result, "referenceinvoice");
        objectRptEntryCellarData.product = UtilSql.getValue(result, "product");
        objectRptEntryCellarData.productcod = UtilSql.getValue(result, "productcod");
        objectRptEntryCellarData.movementqty = UtilSql.getValue(result, "movementqty");
        objectRptEntryCellarData.unitprice = UtilSql.getValue(result, "unitprice");
        objectRptEntryCellarData.amountline = UtilSql.getValue(result, "amountline");
        objectRptEntryCellarData.tax = UtilSql.getValue(result, "tax");
        objectRptEntryCellarData.total = UtilSql.getValue(result, "total");
        objectRptEntryCellarData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectRptEntryCellarData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectRptEntryCellarData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptEntryCellarData);
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
    RptEntryCellarData objectRptEntryCellarData[] = new RptEntryCellarData[vector.size()];
    vector.copyInto(objectRptEntryCellarData);
    return(objectRptEntryCellarData);
  }

  public static RptEntryCellarData[] set()    throws ServletException {
    RptEntryCellarData objectRptEntryCellarData[] = new RptEntryCellarData[1];
    objectRptEntryCellarData[0] = new RptEntryCellarData();
    objectRptEntryCellarData[0].organizationid = "";
    objectRptEntryCellarData[0].documentno = "";
    objectRptEntryCellarData[0].partner = "";
    objectRptEntryCellarData[0].address = "";
    objectRptEntryCellarData[0].phone = "";
    objectRptEntryCellarData[0].taxid = "";
    objectRptEntryCellarData[0].movementdate = "";
    objectRptEntryCellarData[0].formpay = "";
    objectRptEntryCellarData[0].conditionpay = "";
    objectRptEntryCellarData[0].referenceinvoice = "";
    objectRptEntryCellarData[0].product = "";
    objectRptEntryCellarData[0].productcod = "";
    objectRptEntryCellarData[0].movementqty = "";
    objectRptEntryCellarData[0].unitprice = "";
    objectRptEntryCellarData[0].amountline = "";
    objectRptEntryCellarData[0].tax = "";
    objectRptEntryCellarData[0].total = "";
    objectRptEntryCellarData[0].cOrderId = "";
    objectRptEntryCellarData[0].mProductId = "";
    return objectRptEntryCellarData;
  }
}
