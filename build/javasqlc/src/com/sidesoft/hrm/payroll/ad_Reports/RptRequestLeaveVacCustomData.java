//Sqlc generated V1.O00-1
package com.sidesoft.hrm.payroll.ad_Reports;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class RptRequestLeaveVacCustomData implements FieldProvider {
static Logger log4j = Logger.getLogger(RptRequestLeaveVacCustomData.class);
  private String InitRecordNumber="0";
  public String tercero;
  public String fechaingreso;
  public String compania;
  public String puesto;
  public String area;
  public String lugar;
  public String stardate;
  public String enddate;
  public String nodays;
  public String fechaingresoempleado;
  public String periodo;
  public String diasbasicosPeriodo;
  public String diasadicionalesPeriodo;
  public String diasbasicoGoza;
  public String diasadicionalesGoza;
  public String diasbasicoSaldo;
  public String diasadicionalesSaldo;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("tercero"))
      return tercero;
    else if (fieldName.equalsIgnoreCase("fechaingreso"))
      return fechaingreso;
    else if (fieldName.equalsIgnoreCase("compania"))
      return compania;
    else if (fieldName.equalsIgnoreCase("puesto"))
      return puesto;
    else if (fieldName.equalsIgnoreCase("area"))
      return area;
    else if (fieldName.equalsIgnoreCase("lugar"))
      return lugar;
    else if (fieldName.equalsIgnoreCase("stardate"))
      return stardate;
    else if (fieldName.equalsIgnoreCase("enddate"))
      return enddate;
    else if (fieldName.equalsIgnoreCase("nodays"))
      return nodays;
    else if (fieldName.equalsIgnoreCase("fechaingresoempleado"))
      return fechaingresoempleado;
    else if (fieldName.equalsIgnoreCase("periodo"))
      return periodo;
    else if (fieldName.equalsIgnoreCase("diasbasicos_periodo") || fieldName.equals("diasbasicosPeriodo"))
      return diasbasicosPeriodo;
    else if (fieldName.equalsIgnoreCase("diasadicionales_periodo") || fieldName.equals("diasadicionalesPeriodo"))
      return diasadicionalesPeriodo;
    else if (fieldName.equalsIgnoreCase("diasbasico_goza") || fieldName.equals("diasbasicoGoza"))
      return diasbasicoGoza;
    else if (fieldName.equalsIgnoreCase("diasadicionales_goza") || fieldName.equals("diasadicionalesGoza"))
      return diasadicionalesGoza;
    else if (fieldName.equalsIgnoreCase("diasbasico_saldo") || fieldName.equals("diasbasicoSaldo"))
      return diasbasicoSaldo;
    else if (fieldName.equalsIgnoreCase("diasadicionales_saldo") || fieldName.equals("diasadicionalesSaldo"))
      return diasadicionalesSaldo;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static RptRequestLeaveVacCustomData[] selectv(ConnectionProvider connectionProvider, String leave)    throws ServletException {
    return selectv(connectionProvider, leave, 0, 0);
  }

  public static RptRequestLeaveVacCustomData[] selectv(ConnectionProvider connectionProvider, String leave, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "     select b.name as tercero," +
      "   to_char(stardateabsent,'dd-MM-yyyy') as fechaingreso," +
      "   p.description as compania," +
      "   k.name as puesto," +
      "   d.name as area," +
      "   e.name as lugar," +
      "   to_char(a.stardate,'dd-MM-yyyy') as stardate," +
      "   to_char(a.enddate,'dd-MM-yyyy') as enddate," +
      "   a.nodays," +
      "   to_char(a.enddate + 1,'dd-MM-yyyy') as fechaingresoempleado," +
      "   to_char(entrydate,'yyyy')||'-'||to_char(end_date,'yyyy') as periodo," +
      "   CASE WHEN Q.Sspr_Vacations_ID = F.Sspr_Vacations_ID THEN F.Nodays +  CASE WHEN Typevacations = 'DN' THEN a.nodays ELSE 0 END ELSE F.Nodays END  AS diasbasicos_periodo," +
      "   CASE WHEN Q.Sspr_Vacations_ID = F.Sspr_Vacations_ID THEN F.Noadditionaltotal + CASE WHEN Typevacations = 'DA' THEN a.nodays ELSE 0 END ELSE F.Noadditionaltotal END  as diasadicionales_periodo," +
      "   CASE WHEN Typevacations = 'DN' THEN CASE WHEN Q.Sspr_Vacations_ID = F.Sspr_Vacations_ID THEN a.nodays ELSE NULL END  ELSE 0 END  as diasbasico_goza," +
      "   CASE WHEN Typevacations = 'DA' THEN CASE WHEN Q.Sspr_Vacations_ID = F.Sspr_Vacations_ID THEN a.nodays ELSE NULL END  ELSE 0 END  as diasadicionales_goza," +
      "   F.Nodays as diasbasico_saldo," +
      "   F.Noadditionaltotal as diasadicionales_saldo from SSPR_LEAVE_EMP a left join c_bpartner b on a.c_bpartner_id = b.c_bpartner_id" +
      "    left join sspr_contract i on b.c_bpartner_id = i.c_bpartner_id" +
      "    left join sspr_contract_position j on i.sspr_contract_id = j.sspr_contract_id" +
      "    left join sspr_position k on j.sspr_position_id = k.sspr_position_id" +
      "    left join C_COSTCENTER d on a.C_COSTCENTER_ID = d.C_COSTCENTER_ID" +
      "    left join SSHR_DEPARTMENT e on a.EM_SSHR_DEPARTMENT_ID = e.SSHR_DEPARTMENT_ID" +
      "    left join ad_org p on a.ad_org_id = p.ad_org_id" +
      "    LEFT JOIN sspr_leave_emp_vac Q ON A.SSPR_LEAVE_EMP_ID = Q.SSPR_LEAVE_EMP_ID" +
      "    left join sspr_vacations f on a.c_bpartner_id = f.c_bpartner_id   " +
      "	where a.SSPR_LEAVE_EMP_id = ?  " +
      "	AND ENTRYDATE >=(SELECT ENTRYDATE FROM sspr_vacations WHERE sspr_vacations.Sspr_Vacations_ID= Q.Sspr_Vacations_ID)   " +
      "	order by 11";

    ResultSet result;
    Vector<RptRequestLeaveVacCustomData> vector = new Vector<RptRequestLeaveVacCustomData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, leave);

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
        RptRequestLeaveVacCustomData objectRptRequestLeaveVacCustomData = new RptRequestLeaveVacCustomData();
        objectRptRequestLeaveVacCustomData.tercero = UtilSql.getValue(result, "tercero");
        objectRptRequestLeaveVacCustomData.fechaingreso = UtilSql.getValue(result, "fechaingreso");
        objectRptRequestLeaveVacCustomData.compania = UtilSql.getValue(result, "compania");
        objectRptRequestLeaveVacCustomData.puesto = UtilSql.getValue(result, "puesto");
        objectRptRequestLeaveVacCustomData.area = UtilSql.getValue(result, "area");
        objectRptRequestLeaveVacCustomData.lugar = UtilSql.getValue(result, "lugar");
        objectRptRequestLeaveVacCustomData.stardate = UtilSql.getValue(result, "stardate");
        objectRptRequestLeaveVacCustomData.enddate = UtilSql.getValue(result, "enddate");
        objectRptRequestLeaveVacCustomData.nodays = UtilSql.getValue(result, "nodays");
        objectRptRequestLeaveVacCustomData.fechaingresoempleado = UtilSql.getValue(result, "fechaingresoempleado");
        objectRptRequestLeaveVacCustomData.periodo = UtilSql.getValue(result, "periodo");
        objectRptRequestLeaveVacCustomData.diasbasicosPeriodo = UtilSql.getValue(result, "diasbasicos_periodo");
        objectRptRequestLeaveVacCustomData.diasadicionalesPeriodo = UtilSql.getValue(result, "diasadicionales_periodo");
        objectRptRequestLeaveVacCustomData.diasbasicoGoza = UtilSql.getValue(result, "diasbasico_goza");
        objectRptRequestLeaveVacCustomData.diasadicionalesGoza = UtilSql.getValue(result, "diasadicionales_goza");
        objectRptRequestLeaveVacCustomData.diasbasicoSaldo = UtilSql.getValue(result, "diasbasico_saldo");
        objectRptRequestLeaveVacCustomData.diasadicionalesSaldo = UtilSql.getValue(result, "diasadicionales_saldo");
        objectRptRequestLeaveVacCustomData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptRequestLeaveVacCustomData);
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
    RptRequestLeaveVacCustomData objectRptRequestLeaveVacCustomData[] = new RptRequestLeaveVacCustomData[vector.size()];
    vector.copyInto(objectRptRequestLeaveVacCustomData);
    return(objectRptRequestLeaveVacCustomData);
  }

  public static RptRequestLeaveVacCustomData[] set()    throws ServletException {
    RptRequestLeaveVacCustomData objectRptRequestLeaveVacCustomData[] = new RptRequestLeaveVacCustomData[1];
    objectRptRequestLeaveVacCustomData[0] = new RptRequestLeaveVacCustomData();
    objectRptRequestLeaveVacCustomData[0].tercero = "";
    objectRptRequestLeaveVacCustomData[0].fechaingreso = "";
    objectRptRequestLeaveVacCustomData[0].compania = "";
    objectRptRequestLeaveVacCustomData[0].puesto = "";
    objectRptRequestLeaveVacCustomData[0].area = "";
    objectRptRequestLeaveVacCustomData[0].lugar = "";
    objectRptRequestLeaveVacCustomData[0].stardate = "";
    objectRptRequestLeaveVacCustomData[0].enddate = "";
    objectRptRequestLeaveVacCustomData[0].nodays = "";
    objectRptRequestLeaveVacCustomData[0].fechaingresoempleado = "";
    objectRptRequestLeaveVacCustomData[0].periodo = "";
    objectRptRequestLeaveVacCustomData[0].diasbasicosPeriodo = "";
    objectRptRequestLeaveVacCustomData[0].diasadicionalesPeriodo = "";
    objectRptRequestLeaveVacCustomData[0].diasbasicoGoza = "";
    objectRptRequestLeaveVacCustomData[0].diasadicionalesGoza = "";
    objectRptRequestLeaveVacCustomData[0].diasbasicoSaldo = "";
    objectRptRequestLeaveVacCustomData[0].diasadicionalesSaldo = "";
    return objectRptRequestLeaveVacCustomData;
  }
}
