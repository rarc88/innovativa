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

class RptFinalSettlementData implements FieldProvider {
static Logger log4j = Logger.getLogger(RptFinalSettlementData.class);
  private String InitRecordNumber="0";
  public String organizationid;
  public String organizacion;
  public String codigo;
  public String nombreempleado;
  public String ci;
  public String gerencia;
  public String cargo;
  public String fechaentrada;
  public String fechasalida;
  public String fecha;
  public String motivorenuncia;
  public String regimenlaboral;
  public String tipoconcepto;
  public String nombreconcepto;
  public String amount;
  public String rmu;
  public String tiemposervicio;
  public String saldovacaciones;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("organizationid"))
      return organizationid;
    else if (fieldName.equalsIgnoreCase("organizacion"))
      return organizacion;
    else if (fieldName.equalsIgnoreCase("codigo"))
      return codigo;
    else if (fieldName.equalsIgnoreCase("nombreempleado"))
      return nombreempleado;
    else if (fieldName.equalsIgnoreCase("ci"))
      return ci;
    else if (fieldName.equalsIgnoreCase("gerencia"))
      return gerencia;
    else if (fieldName.equalsIgnoreCase("cargo"))
      return cargo;
    else if (fieldName.equalsIgnoreCase("fechaentrada"))
      return fechaentrada;
    else if (fieldName.equalsIgnoreCase("fechasalida"))
      return fechasalida;
    else if (fieldName.equalsIgnoreCase("fecha"))
      return fecha;
    else if (fieldName.equalsIgnoreCase("motivorenuncia"))
      return motivorenuncia;
    else if (fieldName.equalsIgnoreCase("regimenlaboral"))
      return regimenlaboral;
    else if (fieldName.equalsIgnoreCase("tipoconcepto"))
      return tipoconcepto;
    else if (fieldName.equalsIgnoreCase("nombreconcepto"))
      return nombreconcepto;
    else if (fieldName.equalsIgnoreCase("amount"))
      return amount;
    else if (fieldName.equalsIgnoreCase("rmu"))
      return rmu;
    else if (fieldName.equalsIgnoreCase("tiemposervicio"))
      return tiemposervicio;
    else if (fieldName.equalsIgnoreCase("saldovacaciones"))
      return saldovacaciones;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static RptFinalSettlementData[] select(ConnectionProvider connectionProvider, String finalsettlement)    throws ServletException {
    return select(connectionProvider, finalsettlement, 0, 0);
  }

  public static RptFinalSettlementData[] select(ConnectionProvider connectionProvider, String finalsettlement, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select sspr_settlement.ad_org_id as organizationid," +
      "	      ad_org.name as organizacion," +
      "	      c_bpartner.value as codigo," +
      "	      c_bpartner.name as nombreempleado," +
      "	      c_bpartner.taxid as ci," +
      "	      c_costcenter.name as gerencia," +
      "	      sspr_position.name as cargo," +
      "	      to_char(sspr_contract.startdate) as fechaentrada," +
      "	      to_char(sspr_contract.enddate) as fechasalida," +
      "	      upper(c_location.city || ', ' || to_char(sspr_settlement.movementdate,'dd MONTH yyyy')) as fecha," +
      "	      case when Reasonendperiod = '01' then 'Renuncia Voluntaria'" +
      "		  when Reasonendperiod = '02' then 'Fin de Contrato'" +
      "		  when Reasonendperiod = '03' then 'Despido Intempestivo'" +
      "		  when Reasonendperiod = '04' then 'Visto Bueno'" +
      "	      end as motivorenuncia," +
      "	      sspr_labor_regime.name as regimenlaboral," +
      "	      case when sspr_concept.conceptsubtype = 'In' then 'INGRESOS'" +
      "		  when sspr_concept.conceptsubtype = 'Out' then 'DESCUENTOS'" +
      "	      end as tipoconcepto," +
      "	      sspr_concept.name as nombreconcepto," +
      "	      sspr_settlementline.totalnet as amount," +
      "	      c_bpartner.em_sspr_currentsalary as RMU," +
      "	      round((to_number(sspr_contract.enddate - sspr_contract.startdate )/365),2) as tiemposervicio," +
      "	      (select sum(nodays)" +
      "	      from sspr_vacations" +
      "	      where sspr_vacations.c_bpartner_id = c_bpartner.c_bpartner_id) as saldovacaciones" +
      "      from sspr_settlement " +
      "      left join sspr_settlementline on sspr_settlementline.sspr_settlement_id = sspr_settlement.sspr_settlement_id" +
      "      left join c_bpartner on c_bpartner.c_bpartner_id = sspr_settlement.c_bpartner_id" +
      "      left join c_costcenter on c_costcenter.c_costcenter_id = c_bpartner.em_sspr_costcenter_id" +
      "      left join sspr_contract on sspr_contract.c_bpartner_id = c_bpartner.c_bpartner_id and sspr_settlement.sspr_contract_id = sspr_contract.sspr_contract_id" +
      "      left join sspr_contract_position on sspr_contract_position.sspr_contract_id = sspr_contract.sspr_contract_id" +
      "      left join sspr_position on sspr_position.sspr_position_id = sspr_contract_position.sspr_position_id" +
      "      left join sspr_labor_regime on sspr_labor_regime.sspr_labor_regime_id = sspr_contract.sspr_labor_regime_id" +
      "      left join sspr_concept on sspr_concept.sspr_concept_id = sspr_settlementline.sspr_concept_id" +
      "      left join ad_org on ad_org.ad_org_id = sspr_settlement.ad_org_id" +
      "      left join ad_orginfo  on ad_orginfo.ad_org_id = ad_org.ad_org_id" +
      "      left join c_location on c_location.c_location_id = ad_orginfo.c_location_id" +
      "      where sspr_settlement.sspr_settlement_id = ?" +
      "      order by  sspr_concept.conceptsubtype, c_bpartner.name, sspr_concept.name";

    ResultSet result;
    Vector<RptFinalSettlementData> vector = new Vector<RptFinalSettlementData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, finalsettlement);

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
        RptFinalSettlementData objectRptFinalSettlementData = new RptFinalSettlementData();
        objectRptFinalSettlementData.organizationid = UtilSql.getValue(result, "organizationid");
        objectRptFinalSettlementData.organizacion = UtilSql.getValue(result, "organizacion");
        objectRptFinalSettlementData.codigo = UtilSql.getValue(result, "codigo");
        objectRptFinalSettlementData.nombreempleado = UtilSql.getValue(result, "nombreempleado");
        objectRptFinalSettlementData.ci = UtilSql.getValue(result, "ci");
        objectRptFinalSettlementData.gerencia = UtilSql.getValue(result, "gerencia");
        objectRptFinalSettlementData.cargo = UtilSql.getValue(result, "cargo");
        objectRptFinalSettlementData.fechaentrada = UtilSql.getValue(result, "fechaentrada");
        objectRptFinalSettlementData.fechasalida = UtilSql.getValue(result, "fechasalida");
        objectRptFinalSettlementData.fecha = UtilSql.getValue(result, "fecha");
        objectRptFinalSettlementData.motivorenuncia = UtilSql.getValue(result, "motivorenuncia");
        objectRptFinalSettlementData.regimenlaboral = UtilSql.getValue(result, "regimenlaboral");
        objectRptFinalSettlementData.tipoconcepto = UtilSql.getValue(result, "tipoconcepto");
        objectRptFinalSettlementData.nombreconcepto = UtilSql.getValue(result, "nombreconcepto");
        objectRptFinalSettlementData.amount = UtilSql.getValue(result, "amount");
        objectRptFinalSettlementData.rmu = UtilSql.getValue(result, "rmu");
        objectRptFinalSettlementData.tiemposervicio = UtilSql.getValue(result, "tiemposervicio");
        objectRptFinalSettlementData.saldovacaciones = UtilSql.getValue(result, "saldovacaciones");
        objectRptFinalSettlementData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptFinalSettlementData);
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
    RptFinalSettlementData objectRptFinalSettlementData[] = new RptFinalSettlementData[vector.size()];
    vector.copyInto(objectRptFinalSettlementData);
    return(objectRptFinalSettlementData);
  }

  public static RptFinalSettlementData[] set()    throws ServletException {
    RptFinalSettlementData objectRptFinalSettlementData[] = new RptFinalSettlementData[1];
    objectRptFinalSettlementData[0] = new RptFinalSettlementData();
    objectRptFinalSettlementData[0].organizationid = "";
    objectRptFinalSettlementData[0].organizacion = "";
    objectRptFinalSettlementData[0].codigo = "";
    objectRptFinalSettlementData[0].nombreempleado = "";
    objectRptFinalSettlementData[0].ci = "";
    objectRptFinalSettlementData[0].gerencia = "";
    objectRptFinalSettlementData[0].cargo = "";
    objectRptFinalSettlementData[0].fechaentrada = "";
    objectRptFinalSettlementData[0].fechasalida = "";
    objectRptFinalSettlementData[0].fecha = "";
    objectRptFinalSettlementData[0].motivorenuncia = "";
    objectRptFinalSettlementData[0].regimenlaboral = "";
    objectRptFinalSettlementData[0].tipoconcepto = "";
    objectRptFinalSettlementData[0].nombreconcepto = "";
    objectRptFinalSettlementData[0].amount = "";
    objectRptFinalSettlementData[0].rmu = "";
    objectRptFinalSettlementData[0].tiemposervicio = "";
    objectRptFinalSettlementData[0].saldovacaciones = "";
    return objectRptFinalSettlementData;
  }
}
