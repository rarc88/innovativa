//Sqlc generated V1.O00-1
package com.sidesoft.hrm.payroll.reportcontracttype;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class ReportContractTypeData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReportContractTypeData.class);
  private String InitRecordNumber="0";
  public String trabajador;
  public String dnitrabajador;
  public String direciontrabajo;
  public String empresa;
  public String rucempresa;
  public String empresarepr;
  public String reprdni;
  public String reprdir;
  public String empdir;
  public String cargo;
  public String actividad;
  public String pago;
  public String fincont;
  public String empresafuncion;
  public String fechaactual;
  public String horainicia;
  public String horafinal;
  public String nrdias;
  public String contracttype;
  public String formatop;
  public String namecontract;
  public String entryDate;
  public String ciudad;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("trabajador"))
      return trabajador;
    else if (fieldName.equalsIgnoreCase("dnitrabajador"))
      return dnitrabajador;
    else if (fieldName.equalsIgnoreCase("direciontrabajo"))
      return direciontrabajo;
    else if (fieldName.equalsIgnoreCase("empresa"))
      return empresa;
    else if (fieldName.equalsIgnoreCase("rucempresa"))
      return rucempresa;
    else if (fieldName.equalsIgnoreCase("empresarepr"))
      return empresarepr;
    else if (fieldName.equalsIgnoreCase("reprdni"))
      return reprdni;
    else if (fieldName.equalsIgnoreCase("reprdir"))
      return reprdir;
    else if (fieldName.equalsIgnoreCase("empdir"))
      return empdir;
    else if (fieldName.equalsIgnoreCase("cargo"))
      return cargo;
    else if (fieldName.equalsIgnoreCase("actividad"))
      return actividad;
    else if (fieldName.equalsIgnoreCase("pago"))
      return pago;
    else if (fieldName.equalsIgnoreCase("fincont"))
      return fincont;
    else if (fieldName.equalsIgnoreCase("empresafuncion"))
      return empresafuncion;
    else if (fieldName.equalsIgnoreCase("fechaactual"))
      return fechaactual;
    else if (fieldName.equalsIgnoreCase("horainicia"))
      return horainicia;
    else if (fieldName.equalsIgnoreCase("horafinal"))
      return horafinal;
    else if (fieldName.equalsIgnoreCase("nrdias"))
      return nrdias;
    else if (fieldName.equalsIgnoreCase("contracttype"))
      return contracttype;
    else if (fieldName.equalsIgnoreCase("formatop"))
      return formatop;
    else if (fieldName.equalsIgnoreCase("namecontract"))
      return namecontract;
    else if (fieldName.equalsIgnoreCase("entry_date") || fieldName.equals("entryDate"))
      return entryDate;
    else if (fieldName.equalsIgnoreCase("ciudad"))
      return ciudad;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReportContractTypeData[] select(ConnectionProvider connectionProvider, String bparnterid)    throws ServletException {
    return select(connectionProvider, bparnterid, 0, 0);
  }

  public static ReportContractTypeData[] select(ConnectionProvider connectionProvider, String bparnterid, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "Select  " +
      " c.name as trabajador,  " +
      " c.taxid as dnitrabajador,  " +
      " to_char(l.address1||', '||l.city) as direciontrabajo,  " +
      " o.name as empresa,  " +
      " oi.taxid as rucempresa,  " +
      " (bp_o.name ) as empresarepr,  " +
      " (bp_o.taxid) as reprdni,  " +
      " reprdir1 as reprdir,  " +
      "  to_char(lc_o.address1||', '||lc_o.city ) as empdir,  " +
      " ch.name as cargo,  " +
      " ec.activity as actividad,   " +
      " trim(to_char(salaryev.permanentremuneration,'999999,990.00')) as pago,  " +
      " to_char(ec.startdate,'fmDD  Month  YYYY') as fincont,  " +
      " o.description as empresafuncion,  " +
      " to_char(now(),'fmDD  Month  YYYY') as fechaactual,  " +
      " to_char(ec.startdate,'HH24:MI:SS AM')  as horainicia,  " +
      " to_char(ec.enddate,'HH24:MI:SS')||' PM' as horafinal,  " +
      " to_char(round(to_number((now()-ec.startdate)),0)) ||' dia(s)' as nrdias,  " +
      " ctp.code as contracttype,  " +
      " ctp.format as formatop,  " +
      " ctp.name as namecontract,  " +
      " ((to_char(ec.startdate,'dd') ||  " +
      "case  " +
      "when to_number(to_char(ec.startdate,'MM')) = 1 then ' de Enero del '  " +
      "when to_number(to_char(ec.startdate,'MM')) = 2 then ' de Febrero del '  " +
      "when to_number(to_char(ec.startdate,'MM')) = 3 then ' de Marzo del '  " +
      "when to_number(to_char(ec.startdate,'MM')) = 4 then ' de Abril del '  " +
      "when to_number(to_char(ec.startdate,'MM')) = 5 then ' de Mayo del '  " +
      "when to_number(to_char(ec.startdate,'MM')) = 6 then ' de Junio del '  " +
      "when to_number(to_char(ec.startdate,'MM')) = 7 then ' de Julio del '  " +
      "when to_number(to_char(ec.startdate,'MM')) = 8 then ' de Agosto del '  " +
      "when to_number(to_char(ec.startdate,'MM')) = 9 then ' de Septiembre del '  " +
      "when to_number(to_char(ec.startdate,'MM')) = 10 then ' de Octubre del '  " +
      "when to_number(to_char(ec.startdate,'MM')) = 11 then ' de Noviembre del '  " +
      "when to_number(to_char(ec.startdate,'MM')) = 12 then ' de Diciembre del '  " +
      "end) || to_char(ec.startdate,'yyyy')) as entry_date  " +
      ",coalesce(to_char(cct.name),to_char(' ')) as ciudad   " +
      "  from c_bpartner c  " +
      " left join c_bpartner_location cl on cl.c_bpartner_id = c.c_bpartner_id  " +
      " left join c_location l  on l.c_location_id = cl.c_location_id  " +
      " left join ad_org o  on o.ad_org_id = c.ad_org_id  " +
      " left join ad_orginfo oi  on oi.ad_org_id = o.ad_org_id   " +
      " left join sspr_contract ec  on ec.c_bpartner_id = c.c_bpartner_id   " +
      " left join c_bpartner_location cc  on cc.c_bpartner_id = ec.c_bpartner_id and cc.isbillto = 'Y'   " +
      " left join sspr_contract_position cpst on cpst.sspr_contract_id = ec.sspr_contract_id   " +
      " left join sspr_position ch on ch.sspr_position_id = cpst.sspr_position_id   " +
      " left join sspr_contracttype ctp on ctp.sspr_contracttype_id = ec.sspr_contracttype_id   " +
      " left join c_location lc_o on  lc_o.c_location_id =oi.c_location_id   " +
      " left join  (Select to_char(l.address1||', '||l.city ) as reprdir1,c_bpartner_id from c_location l   " +
      " left join c_bpartner_location cl on cl.c_location_id = l.c_location_id   " +
      "  ) rep on  rep.c_bpartner_id =oi.c_bpartner_id  " +
      " left join c_bpartner bp_o on bp_o.c_bpartner_id = oi.c_bpartner_id  " +
      " left join (  " +
      "  select min(c.amount) as permanentremuneration,min(c.startdate) as fecha,b.c_bpartner_id,b.SSPR_CONTRACT_ID  from sfpr_evolution_salary c  " +
      "left join sspr_contract b on b.sspr_contract_id = c.sspr_contract_id  " +
      "left join c_bpartner a on a.c_bpartner_id = b.c_bpartner_id  " +
      "group by b.sspr_contract_id,b.c_bpartner_id,b.SSPR_CONTRACT_ID  " +
      " ) salaryev on ec.SSPR_CONTRACT_ID = salaryev.SSPR_CONTRACT_ID and salaryev.c_bpartner_id = c.c_bpartner_id " +
      " left join c_city cct on cct.c_city_id = ec.c_city_id  " +
      " where c.isemployee = 'Y'  " +
      " and cc.isactive='Y'  " +
      " AND  ec.SSPR_CONTRACT_ID IN  (SELECT SSPR_CONTRACT_ID  " +
      "  FROM SSPR_CONTRACT  " +
      "  WHERE STARTDATE =  " +
      "  (  " +
      "  select max(startdate)  " +
      "  from sspr_contract  " +
      "  where c_bpartner_id = ?  " +
      "  ))  " +
      "  and ec.c_bpartner_id = c.c_bpartner_id  " +
      "  and c.c_bpartner_id = ?     ";

    ResultSet result;
    Vector<ReportContractTypeData> vector = new Vector<ReportContractTypeData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bparnterid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bparnterid);

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
        ReportContractTypeData objectReportContractTypeData = new ReportContractTypeData();
        objectReportContractTypeData.trabajador = UtilSql.getValue(result, "trabajador");
        objectReportContractTypeData.dnitrabajador = UtilSql.getValue(result, "dnitrabajador");
        objectReportContractTypeData.direciontrabajo = UtilSql.getValue(result, "direciontrabajo");
        objectReportContractTypeData.empresa = UtilSql.getValue(result, "empresa");
        objectReportContractTypeData.rucempresa = UtilSql.getValue(result, "rucempresa");
        objectReportContractTypeData.empresarepr = UtilSql.getValue(result, "empresarepr");
        objectReportContractTypeData.reprdni = UtilSql.getValue(result, "reprdni");
        objectReportContractTypeData.reprdir = UtilSql.getValue(result, "reprdir");
        objectReportContractTypeData.empdir = UtilSql.getValue(result, "empdir");
        objectReportContractTypeData.cargo = UtilSql.getValue(result, "cargo");
        objectReportContractTypeData.actividad = UtilSql.getValue(result, "actividad");
        objectReportContractTypeData.pago = UtilSql.getValue(result, "pago");
        objectReportContractTypeData.fincont = UtilSql.getValue(result, "fincont");
        objectReportContractTypeData.empresafuncion = UtilSql.getValue(result, "empresafuncion");
        objectReportContractTypeData.fechaactual = UtilSql.getValue(result, "fechaactual");
        objectReportContractTypeData.horainicia = UtilSql.getValue(result, "horainicia");
        objectReportContractTypeData.horafinal = UtilSql.getValue(result, "horafinal");
        objectReportContractTypeData.nrdias = UtilSql.getValue(result, "nrdias");
        objectReportContractTypeData.contracttype = UtilSql.getValue(result, "contracttype");
        objectReportContractTypeData.formatop = UtilSql.getValue(result, "formatop");
        objectReportContractTypeData.namecontract = UtilSql.getValue(result, "namecontract");
        objectReportContractTypeData.entryDate = UtilSql.getValue(result, "entry_date");
        objectReportContractTypeData.ciudad = UtilSql.getValue(result, "ciudad");
        objectReportContractTypeData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReportContractTypeData);
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
    ReportContractTypeData objectReportContractTypeData[] = new ReportContractTypeData[vector.size()];
    vector.copyInto(objectReportContractTypeData);
    return(objectReportContractTypeData);
  }

  public static ReportContractTypeData[] set()    throws ServletException {
    ReportContractTypeData objectReportContractTypeData[] = new ReportContractTypeData[1];
    objectReportContractTypeData[0] = new ReportContractTypeData();
    objectReportContractTypeData[0].trabajador = "";
    objectReportContractTypeData[0].dnitrabajador = "";
    objectReportContractTypeData[0].direciontrabajo = "";
    objectReportContractTypeData[0].empresa = "";
    objectReportContractTypeData[0].rucempresa = "";
    objectReportContractTypeData[0].empresarepr = "";
    objectReportContractTypeData[0].reprdni = "";
    objectReportContractTypeData[0].reprdir = "";
    objectReportContractTypeData[0].empdir = "";
    objectReportContractTypeData[0].cargo = "";
    objectReportContractTypeData[0].actividad = "";
    objectReportContractTypeData[0].pago = "";
    objectReportContractTypeData[0].fincont = "";
    objectReportContractTypeData[0].empresafuncion = "";
    objectReportContractTypeData[0].fechaactual = "";
    objectReportContractTypeData[0].horainicia = "";
    objectReportContractTypeData[0].horafinal = "";
    objectReportContractTypeData[0].nrdias = "";
    objectReportContractTypeData[0].contracttype = "";
    objectReportContractTypeData[0].formatop = "";
    objectReportContractTypeData[0].namecontract = "";
    objectReportContractTypeData[0].entryDate = "";
    objectReportContractTypeData[0].ciudad = "";
    return objectReportContractTypeData;
  }
}
