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

class RptRequestLeaveData implements FieldProvider {
static Logger log4j = Logger.getLogger(RptRequestLeaveData.class);
  private String InitRecordNumber="0";
  public String organizationid;
  public String nombreempleado;
  public String fechainicial;
  public String fechafinal;
  public String tipopermiso;
  public String estado;
  public String description;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("organizationid"))
      return organizationid;
    else if (fieldName.equalsIgnoreCase("nombreempleado"))
      return nombreempleado;
    else if (fieldName.equalsIgnoreCase("fechainicial"))
      return fechainicial;
    else if (fieldName.equalsIgnoreCase("fechafinal"))
      return fechafinal;
    else if (fieldName.equalsIgnoreCase("tipopermiso"))
      return tipopermiso;
    else if (fieldName.equalsIgnoreCase("estado"))
      return estado;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static RptRequestLeaveData[] select(ConnectionProvider connectionProvider, String leave)    throws ServletException {
    return select(connectionProvider, leave, 0, 0);
  }

  public static RptRequestLeaveData[] select(ConnectionProvider connectionProvider, String leave, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            select sspr_leave_emp.ad_org_id as organizationid," +
      "            c_bpartner.name as nombreempleado," +
      "            to_char(sspr_leave_emp.stardate) as fechainicial," +
      "            to_char(sspr_leave_emp.enddate) as fechafinal," +
      "            sspr_leave_type.name as tipopermiso," +
      "            case when sspr_leave_emp.status = 'ap' then 'Aprobado' end as estado," +
      "            sspr_leave_emp.description" +
      "            from sspr_leave_emp" +
      "            left join c_bpartner on c_bpartner.c_bpartner_id = sspr_leave_emp.c_bpartner_id" +
      "            left join sspr_leave_type on sspr_leave_type.sspr_leave_type_id = sspr_leave_emp.sspr_leave_type_id" +
      "            where sspr_leave_emp.sspr_leave_emp_id = ?" +
      "                and sspr_leave_emp.status = 'ap'";

    ResultSet result;
    Vector<RptRequestLeaveData> vector = new Vector<RptRequestLeaveData>(0);
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
        RptRequestLeaveData objectRptRequestLeaveData = new RptRequestLeaveData();
        objectRptRequestLeaveData.organizationid = UtilSql.getValue(result, "organizationid");
        objectRptRequestLeaveData.nombreempleado = UtilSql.getValue(result, "nombreempleado");
        objectRptRequestLeaveData.fechainicial = UtilSql.getValue(result, "fechainicial");
        objectRptRequestLeaveData.fechafinal = UtilSql.getValue(result, "fechafinal");
        objectRptRequestLeaveData.tipopermiso = UtilSql.getValue(result, "tipopermiso");
        objectRptRequestLeaveData.estado = UtilSql.getValue(result, "estado");
        objectRptRequestLeaveData.description = UtilSql.getValue(result, "description");
        objectRptRequestLeaveData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptRequestLeaveData);
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
    RptRequestLeaveData objectRptRequestLeaveData[] = new RptRequestLeaveData[vector.size()];
    vector.copyInto(objectRptRequestLeaveData);
    return(objectRptRequestLeaveData);
  }

  public static RptRequestLeaveData[] set()    throws ServletException {
    RptRequestLeaveData objectRptRequestLeaveData[] = new RptRequestLeaveData[1];
    objectRptRequestLeaveData[0] = new RptRequestLeaveData();
    objectRptRequestLeaveData[0].organizationid = "";
    objectRptRequestLeaveData[0].nombreempleado = "";
    objectRptRequestLeaveData[0].fechainicial = "";
    objectRptRequestLeaveData[0].fechafinal = "";
    objectRptRequestLeaveData[0].tipopermiso = "";
    objectRptRequestLeaveData[0].estado = "";
    objectRptRequestLeaveData[0].description = "";
    return objectRptRequestLeaveData;
  }
}
