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

public class ModifySalaryData implements FieldProvider {
static Logger log4j = Logger.getLogger(ModifySalaryData.class);
  private String InitRecordNumber="0";
  public String fechamaxima;
  public String rucempresa;
  public String ciudad;
  public String anio;
  public String mes;
  public String msu;
  public String taxid;
  public String amount;
  public String cBpartnerId;
  public String ssprContractId;
  public String fechamaximalast;
  public String amountlast;
  public String estcode;
  public String terceros;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("fechamaxima"))
      return fechamaxima;
    else if (fieldName.equalsIgnoreCase("rucempresa"))
      return rucempresa;
    else if (fieldName.equalsIgnoreCase("ciudad"))
      return ciudad;
    else if (fieldName.equalsIgnoreCase("anio"))
      return anio;
    else if (fieldName.equalsIgnoreCase("mes"))
      return mes;
    else if (fieldName.equalsIgnoreCase("msu"))
      return msu;
    else if (fieldName.equalsIgnoreCase("taxid"))
      return taxid;
    else if (fieldName.equalsIgnoreCase("amount"))
      return amount;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("sspr_contract_id") || fieldName.equals("ssprContractId"))
      return ssprContractId;
    else if (fieldName.equalsIgnoreCase("fechamaximalast"))
      return fechamaximalast;
    else if (fieldName.equalsIgnoreCase("amountlast"))
      return amountlast;
    else if (fieldName.equalsIgnoreCase("estcode"))
      return estcode;
    else if (fieldName.equalsIgnoreCase("terceros"))
      return terceros;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ModifySalaryData[] select(ConnectionProvider connectionProvider, String c_period_id)    throws ServletException {
    return select(connectionProvider, c_period_id, 0, 0);
  }

  public static ModifySalaryData[] select(ConnectionProvider connectionProvider, String c_period_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		select reporte.fechamaxima," +
      "         reporte.rucempresa," +
      "         reporte.ciudad," +
      "         reporte.anio," +
      "         reporte.mes," +
      "         reporte.MSU," +
      "         reporte.taxid," +
      "         reporte.amount," +
      "         reporte.c_bpartner_id," +
      "         reporte.sspr_contract_id," +
      "         sfpr_evolution_salary.enddate as fechamaximalast," +
      "         sfpr_evolution_salary.amount as amountlast," +
      "         reporte.estcode," +
      "         cbp.name as terceros   " +
      "        from  " +
      "        (  " +
      "        select max(sfpr_evolution_salary.startdate) as fechamaxima," +
      "         ad_orginfo.taxid as rucempresa," +
      "         c_city.em_sspr_value as ciudad," +
      "         extract(year from c_period.startdate) anio," +
      "         case when extract(month from c_period.startdate) = 1 then '01'  " +
      "              when extract(month from c_period.startdate) = 2 then '02'  " +
      "              when extract(month from c_period.startdate) = 3 then '03'  " +
      "              when extract(month from c_period.startdate) = 4 then '04'  " +
      "              when extract(month from c_period.startdate) = 5 then '05'  " +
      "              when extract(month from c_period.startdate) = 6 then '06'  " +
      "              when extract(month from c_period.startdate) = 7 then '07'  " +
      "              when extract(month from c_period.startdate) = 8 then '08'  " +
      "              when extract(month from c_period.startdate) = 9 then '09'  " +
      "              when extract(month from c_period.startdate) = 10 then '10'  " +
      "              when extract(month from c_period.startdate) = 11 then '11'  " +
      "              when extract(month from c_period.startdate) = 12 then '12'  " +
      "         end as mes," +
      "         'MSU' as MSU," +
      "         c_bpartner.taxid," +
      "         sfpr_evolution_salary.amount," +
      "         sfpr_evolution_salary.sspr_contract_id," +
      "         c_bpartner.c_bpartner_id, " +
      "         '0' || j.name as estcode  " +
      "        from c_bpartner" +
      "        left join sspr_contract on sspr_contract.c_bpartner_id = c_bpartner.c_bpartner_id and sspr_contract.isactive = 'Y'  " +
      "        left join sfpr_evolution_salary on sfpr_evolution_salary.sspr_contract_id = sspr_contract.sspr_contract_id  " +
      "        left join ad_orginfo on ad_orginfo.ad_org_id = c_bpartner.ad_org_id   " +
      "        left join c_city on c_city.c_city_id = c_bpartner.em_sspr_city  " +
      "        left join c_period on c_period.c_period_id = ?  " +
      "        left join sspr_establishmentcode j on j.sspr_establishmentcode_id = c_bpartner.em_sspr_establishmentcode_id  " +
      "        where c_bpartner.isemployee = 'Y'  " +
      "        and sfpr_evolution_salary.startdate >= (select startdate from c_period where c_period_id = ?)  " +
      "        and sfpr_evolution_salary.startdate <= (select enddate from c_period where c_period_id = ?)  " +
      "        group by sfpr_evolution_salary.amount,  " +
      "        ad_orginfo.taxid," +
      "         c_city.em_sspr_value," +
      "         c_period.startdate," +
      "         c_bpartner.taxid," +
      "         sfpr_evolution_salary.sspr_contract_id," +
      "         c_bpartner.c_bpartner_id," +
      "         sfpr_evolution_salary.startdate, j.name" +
      "         ) reporte   " +
      "        left join sfpr_evolution_salary on sfpr_evolution_salary.sspr_contract_id = reporte.sspr_contract_id  " +
      "        left join c_bpartner cbp on cbp.c_bpartner_id = reporte.c_bpartner_id  " +
      "        where reporte.fechamaxima = (select max(sfpr_evolution_salary.startdate)   " +
      "            from c_bpartner  " +
      "            left join sspr_contract on sspr_contract.c_bpartner_id = c_bpartner.c_bpartner_id and sspr_contract.isactive = 'Y'  " +
      "            left join sfpr_evolution_salary on sfpr_evolution_salary.sspr_contract_id = sspr_contract.sspr_contract_id  " +
      "            left join ad_orginfo on ad_orginfo.ad_org_id = c_bpartner.ad_org_id  " +
      "            left join c_city on c_city.c_city_id = c_bpartner.em_sspr_city  " +
      "            left join c_period on c_period.c_period_id = ?  " +
      "            where c_bpartner.c_bpartner_id =  reporte.c_bpartner_id  " +
      "            and c_bpartner.isemployee = 'Y'  " +
      "            and sfpr_evolution_salary.startdate >= (select startdate from c_period where c_period_id = ?)  " +
      "            and sfpr_evolution_salary.startdate <= (select enddate from c_period where c_period_id = ?)  " +
      "            group by c_bpartner.c_bpartner_id)  " +
      "        and sfpr_evolution_salary.enddate in (select max(sfpr_evolution_salary.enddate) as fechamaximaanterior  " +
      "                 from c_bpartner  " +
      "                 left join sspr_contract on sspr_contract.c_bpartner_id = c_bpartner.c_bpartner_id and sspr_contract.isactive = 'Y'  " +
      "                 left join sfpr_evolution_salary on sfpr_evolution_salary.sspr_contract_id = sspr_contract.sspr_contract_id  " +
      "                where c_bpartner.c_bpartner_id = reporte.c_bpartner_id  " +
      "                and c_bpartner.isemployee = 'Y' " +
      "                 and sfpr_evolution_salary.enddate <= reporte.fechamaxima -1  " +
      "                 and sfpr_evolution_salary.sspr_contract_id = reporte.sspr_contract_id" +
      "                 )  " +
      "        and reporte.amount <> sfpr_evolution_salary.amount ";

    ResultSet result;
    Vector<ModifySalaryData> vector = new Vector<ModifySalaryData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_period_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_period_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_period_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_period_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_period_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_period_id);

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
        ModifySalaryData objectModifySalaryData = new ModifySalaryData();
        objectModifySalaryData.fechamaxima = UtilSql.getDateValue(result, "fechamaxima", "dd-MM-yyyy");
        objectModifySalaryData.rucempresa = UtilSql.getValue(result, "rucempresa");
        objectModifySalaryData.ciudad = UtilSql.getValue(result, "ciudad");
        objectModifySalaryData.anio = UtilSql.getValue(result, "anio");
        objectModifySalaryData.mes = UtilSql.getValue(result, "mes");
        objectModifySalaryData.msu = UtilSql.getValue(result, "msu");
        objectModifySalaryData.taxid = UtilSql.getValue(result, "taxid");
        objectModifySalaryData.amount = UtilSql.getValue(result, "amount");
        objectModifySalaryData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectModifySalaryData.ssprContractId = UtilSql.getValue(result, "sspr_contract_id");
        objectModifySalaryData.fechamaximalast = UtilSql.getDateValue(result, "fechamaximalast", "dd-MM-yyyy");
        objectModifySalaryData.amountlast = UtilSql.getValue(result, "amountlast");
        objectModifySalaryData.estcode = UtilSql.getValue(result, "estcode");
        objectModifySalaryData.terceros = UtilSql.getValue(result, "terceros");
        objectModifySalaryData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectModifySalaryData);
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
    ModifySalaryData objectModifySalaryData[] = new ModifySalaryData[vector.size()];
    vector.copyInto(objectModifySalaryData);
    return(objectModifySalaryData);
  }
}
