//Sqlc generated V1.O00-1
package ec.com.sidesoft.quick.billing.ad_callouts;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class SqbQuickBillingPriceData implements FieldProvider {
static Logger log4j = Logger.getLogger(SqbQuickBillingPriceData.class);
  private String InitRecordNumber="0";
  public String productoid;
  public String pricelist;
  public String pricestd;
  public String rownum;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("productoid"))
      return productoid;
    else if (fieldName.equalsIgnoreCase("pricelist"))
      return pricelist;
    else if (fieldName.equalsIgnoreCase("pricestd"))
      return pricestd;
    else if (fieldName.equals("rownum"))
      return rownum;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SqbQuickBillingPriceData[] selectprice(ConnectionProvider connectionProvider, String userid, String productid)    throws ServletException {
    return selectprice(connectionProvider, userid, productid, 0, 0);
  }

  public static SqbQuickBillingPriceData[] selectprice(ConnectionProvider connectionProvider, String userid, String productid, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "                select " +
      "                mpp.m_product_id as productoid," +
      "                mpp.pricelist as pricelist ,  " +
      "                mpp.pricestd  as pricestd       " +
      "                from m_pricelist mp     " +
      "                left join m_pricelist_version mpv on mp.m_pricelist_id = mpv.m_pricelist_id    " +
      "                left join m_productprice mpp on mpp.m_pricelist_version_id = mpv.m_pricelist_version_id    " +
      "                where mp.m_pricelist_id = (select m_pricelist_id" +
      "                        from sqb_config_user a" +
      "                        left join sqb_config_quickbilling b on b.sqb_config_quickbilling_id = a.sqb_config_quickbilling_id" +
      "                        where a.ad_user_id = ?)     " +
      "                 and mpv.validfrom = (select max(validfrom) as validfrom      " +
      "                                     from m_pricelist_version      " +
      "                                     where  m_pricelist_id = (select m_pricelist_id" +
      "                                from sqb_config_user a" +
      "                                left join sqb_config_quickbilling b on b.sqb_config_quickbilling_id = a.sqb_config_quickbilling_id" +
      "                                where a.ad_user_id = ?))" +
      "                  and mpp.m_product_id = ?  ";

    ResultSet result;
    Vector<SqbQuickBillingPriceData> vector = new Vector<SqbQuickBillingPriceData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, userid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, userid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productid);

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
        SqbQuickBillingPriceData objectSqbQuickBillingPriceData = new SqbQuickBillingPriceData();
        objectSqbQuickBillingPriceData.productoid = UtilSql.getValue(result, "productoid");
        objectSqbQuickBillingPriceData.pricelist = UtilSql.getValue(result, "pricelist");
        objectSqbQuickBillingPriceData.pricestd = UtilSql.getValue(result, "pricestd");
        objectSqbQuickBillingPriceData.rownum = Long.toString(countRecord);
        objectSqbQuickBillingPriceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSqbQuickBillingPriceData);
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
    SqbQuickBillingPriceData objectSqbQuickBillingPriceData[] = new SqbQuickBillingPriceData[vector.size()];
    vector.copyInto(objectSqbQuickBillingPriceData);
    return(objectSqbQuickBillingPriceData);
  }
}
