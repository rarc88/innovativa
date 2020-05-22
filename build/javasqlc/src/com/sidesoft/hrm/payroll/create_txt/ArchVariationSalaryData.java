//Sqlc generated V1.O00-1
package com.sidesoft.hrm.payroll.create_txt;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

public class ArchVariationSalaryData implements FieldProvider {
static Logger log4j = Logger.getLogger(ArchVariationSalaryData.class);
  private String InitRecordNumber="0";
  public String extra;
  public String ruc;
  public String ciudad;
  public String anio;
  public String mes;
  public String ci;
  public String constante;
  public String tipoTransaccion;
  public String estcode;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("extra"))
      return extra;
    else if (fieldName.equalsIgnoreCase("ruc"))
      return ruc;
    else if (fieldName.equalsIgnoreCase("ciudad"))
      return ciudad;
    else if (fieldName.equalsIgnoreCase("anio"))
      return anio;
    else if (fieldName.equalsIgnoreCase("mes"))
      return mes;
    else if (fieldName.equalsIgnoreCase("ci"))
      return ci;
    else if (fieldName.equalsIgnoreCase("constante"))
      return constante;
    else if (fieldName.equalsIgnoreCase("tipo_transaccion") || fieldName.equals("tipoTransaccion"))
      return tipoTransaccion;
    else if (fieldName.equalsIgnoreCase("estcode"))
      return estcode;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ArchVariationSalaryData[] select(ConnectionProvider connectionProvider, String ad_org_id, String c_period_id, String documentno, String c_city_id)    throws ServletException {
    return select(connectionProvider, ad_org_id, c_period_id, documentno, c_city_id, 0, 0);
  }

  public static ArchVariationSalaryData[] select(ConnectionProvider connectionProvider, String ad_org_id, String c_period_id, String documentno, String c_city_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		select sum(extra) as extra,ruc, ciudad,anio,mes,ci,'INS' as constante,'O' as tipo_transaccion, estcode" +
      "        from" +
      "        (select b.taxid ruc," +
      "            i.em_sspr_value as ciudad," +
      "            extract(year from d.enddate) anio," +
      "            case when extract(month from d.enddate) = 1 then '01'" +
      "                 when extract(month from d.enddate) = 2 then '02'" +
      "                 when extract(month from d.enddate) = 3 then '03'" +
      "                 when extract(month from d.enddate) = 4 then '04'" +
      "                 when extract(month from d.enddate) = 5 then '05'" +
      "                 when extract(month from d.enddate) = 6 then '06'" +
      "                 when extract(month from d.enddate) = 7 then '07'" +
      "                 when extract(month from d.enddate) = 8 then '08'" +
      "                 when extract(month from d.enddate) = 9 then '09'" +
      "                 when extract(month from d.enddate) = 10 then '10'" +
      "                 when extract(month from d.enddate) = 11 then '11'" +
      "                 when extract(month from d.enddate) = 12 then '12'" +
      "            end as mes," +
      "            f.taxid ci," +
      "            round(sum(g.amount),2) as extra," +
      "	    '0' || j.name as estcode" +
      "        from ad_org a" +
      "        left join AD_OrgInfo b on a.ad_org_id = b.ad_org_id" +
      "        left join SSPR_Payroll c on a.ad_org_id = c.ad_org_id" +
      "        left join c_period d on c.c_period_id =d.c_period_id" +
      "        left join SSPR_Payroll_Ticket e on c.sspr_payroll_id = e.sspr_payroll_id" +
      "        left join c_bpartner f on e.c_bpartner_id = f.c_bpartner_id" +
      "        left join SSPR_Payroll_Ticket_Concept g on e.sspr_payroll_ticket_id = g.sspr_payroll_ticket_id" +
      "        left join sspr_concept h on g.sspr_concept_id = h.sspr_concept_id" +
      "        left join c_city i on f.em_sspr_city = i.c_city_id" +
      "        left join sspr_establishmentcode j on j.sspr_establishmentcode_id = f.em_sspr_establishmentcode_id	" +
      "        where a.ad_org_id = ?" +
      "        and d.c_period_id  = ?" +
      "        and c.documentno = ?" +
      "        and (i.c_city_id = ? or ? is null)        " +
      "        and h.variationsalary = 'Y'" +
      "        group by b.taxid, d.enddate, f.taxid, g.amount, i.em_sspr_value, j.name) rt" +
      "        where extra > 0" +
      "        group by ruc, ciudad,anio,mes,ci,estcode";

    ResultSet result;
    Vector<ArchVariationSalaryData> vector = new Vector<ArchVariationSalaryData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_org_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_period_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_city_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_city_id);

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
        ArchVariationSalaryData objectArchVariationSalaryData = new ArchVariationSalaryData();
        objectArchVariationSalaryData.extra = UtilSql.getValue(result, "extra");
        objectArchVariationSalaryData.ruc = UtilSql.getValue(result, "ruc");
        objectArchVariationSalaryData.ciudad = UtilSql.getValue(result, "ciudad");
        objectArchVariationSalaryData.anio = UtilSql.getValue(result, "anio");
        objectArchVariationSalaryData.mes = UtilSql.getValue(result, "mes");
        objectArchVariationSalaryData.ci = UtilSql.getValue(result, "ci");
        objectArchVariationSalaryData.constante = UtilSql.getValue(result, "constante");
        objectArchVariationSalaryData.tipoTransaccion = UtilSql.getValue(result, "tipo_transaccion");
        objectArchVariationSalaryData.estcode = UtilSql.getValue(result, "estcode");
        objectArchVariationSalaryData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectArchVariationSalaryData);
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
    ArchVariationSalaryData objectArchVariationSalaryData[] = new ArchVariationSalaryData[vector.size()];
    vector.copyInto(objectArchVariationSalaryData);
    return(objectArchVariationSalaryData);
  }
}
