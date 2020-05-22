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

class RptRequestVacactionsData implements FieldProvider {
static Logger log4j = Logger.getLogger(RptRequestVacactionsData.class);
  private String InitRecordNumber="0";
  public String organizationid;
  public String documentno;
  public String doctype;
  public String fechacity;
  public String cpa;
  public String jefe;
  public String cargo;
  public String organizacion;
  public String citydefault;
  public String consideraciones;
  public String body;
  public String startdateout;
  public String enddateout;
  public String atentamente;
  public String ci;
  public String exclusives;
  public String autorizado1;
  public String autorizado2;
  public String autorizado3;
  public String autorizado4;
  public String copia;
  public String fechaImpresion;
  public String usuario;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("organizationid"))
      return organizationid;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("doctype"))
      return doctype;
    else if (fieldName.equalsIgnoreCase("fechacity"))
      return fechacity;
    else if (fieldName.equalsIgnoreCase("cpa"))
      return cpa;
    else if (fieldName.equalsIgnoreCase("jefe"))
      return jefe;
    else if (fieldName.equalsIgnoreCase("cargo"))
      return cargo;
    else if (fieldName.equalsIgnoreCase("organizacion"))
      return organizacion;
    else if (fieldName.equalsIgnoreCase("citydefault"))
      return citydefault;
    else if (fieldName.equalsIgnoreCase("consideraciones"))
      return consideraciones;
    else if (fieldName.equalsIgnoreCase("body"))
      return body;
    else if (fieldName.equalsIgnoreCase("startdateout"))
      return startdateout;
    else if (fieldName.equalsIgnoreCase("enddateout"))
      return enddateout;
    else if (fieldName.equalsIgnoreCase("atentamente"))
      return atentamente;
    else if (fieldName.equalsIgnoreCase("ci"))
      return ci;
    else if (fieldName.equalsIgnoreCase("exclusives"))
      return exclusives;
    else if (fieldName.equalsIgnoreCase("autorizado1"))
      return autorizado1;
    else if (fieldName.equalsIgnoreCase("autorizado2"))
      return autorizado2;
    else if (fieldName.equalsIgnoreCase("autorizado3"))
      return autorizado3;
    else if (fieldName.equalsIgnoreCase("autorizado4"))
      return autorizado4;
    else if (fieldName.equalsIgnoreCase("copia"))
      return copia;
    else if (fieldName.equalsIgnoreCase("fecha_impresion") || fieldName.equals("fechaImpresion"))
      return fechaImpresion;
    else if (fieldName.equalsIgnoreCase("usuario"))
      return usuario;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static RptRequestVacactionsData[] select(ConnectionProvider connectionProvider, String ad_user, String leave)    throws ServletException {
    return select(connectionProvider, ad_user, leave, 0, 0);
  }

  public static RptRequestVacactionsData[] select(ConnectionProvider connectionProvider, String ad_user, String leave, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "     	select a.ad_org_id as organizationid," +
      "        a.documentno, upper(b.printname) as doctype," +
      "        d.name || ', ' || to_number(to_char(a.stardateabsent,'dd')) || ' de '  ||" +
      "        case when to_char(a.stardateabsent,'mm') = '01' then 'Enero'" +
      "        when to_char(a.stardateabsent,'mm') = '02' then 'Febrero'" +
      "        when to_char(a.stardateabsent,'mm') = '03' then 'Marzo'" +
      "        when to_char(a.stardateabsent,'mm') = '04' then 'Abril'" +
      "        when to_char(a.stardateabsent,'mm') = '05' then 'Mayo'" +
      "        when to_char(a.stardateabsent,'mm') = '06' then 'Junio'" +
      "        when to_char(a.stardateabsent,'mm') = '07' then 'Julio'" +
      "        when to_char(a.stardateabsent,'mm') = '08' then 'Agosto'" +
      "        when to_char(a.stardateabsent,'mm') = '09' then 'Septiembre'" +
      "        when to_char(a.stardateabsent,'mm') = '10' then 'Octubre'" +
      "        when to_char(a.stardateabsent,'mm') = '11' then 'Noviembre'" +
      "        when to_char(a.stardateabsent,'mm') = '12' then 'Diciembre' end" +
      "        || ' del ' || to_char(a.stardateabsent,'yyyy')  as fechacity" +
      "        , 'CPA' as cpa," +
      "        coalesce(to_char(e.name),'No definido') as jefe, coalesce(to_char(h.name),'No definido') as cargo, i.social_name as organizacion," +
      "        'Ciudad' as citydefault," +
      "        'De mis consideraciones' as consideraciones," +
      "        'Yo, ' || c.name" +
      "               || ' solicito a Usted, se sirva autorizar el uso de mis vacaciones correspondiente al periodo del    '" +
      "               || (select to_char(min(aa.startdate),'yyyy') from sspr_leave_emp_vac aa where aa.sspr_leave_emp_id = a.sspr_leave_emp_id)" +
      "               || '    al    '" +
      "               || (select to_char(max(aa.enddate),'yyyy') from sspr_leave_emp_vac aa where aa.sspr_leave_emp_id = a.sspr_leave_emp_id) as body," +
      "        to_char(a.stardate,'dd-mm-yyyy') as startdateout," +
      "        to_char(a.enddate,'dd-mm-yyyy') as  enddateout," +
      "        'Atentamente' as atentamente," +
      "        'CI: ' ||c.taxid as ci," +
      "        'USO EXCLUSIVO DE RECURSOS HUMANOS' as exclusives," +
      "        'AUTORIZADO GERENCIA  Y/O PRESIDENCIA______________________' as autorizado1," +
      "        'AUTORIZADO RR.HH_____________________________________________' as autorizado2," +
      "        'NO AUTORIZADO GERENCIA Y/O PRESIDENCIA____________________' as autorizado3," +
      "        'NO AUTORIZADO RR.HH__________________________________________' as autorizado4," +
      "        '*Copia carpeta personal' as copia," +
      "    to_char(now(),'dd/MM/yyyy HH24:MI:SS') as fecha_impresion," +
      "    (select COALESCE(CB.NAME,AU.NAME) from AD_USER AU LEFT JOIN C_BPARTNER CB on CB.C_BPARTNER_ID   = AU.C_BPARTNER_ID where AU.AD_USER_ID= ?) as usuario" +
      "        from sspr_leave_emp a" +
      "        left join c_doctype b on b.c_doctype_id = a.c_doctype_id" +
      "        left join c_bpartner c on c.c_bpartner_id = a.c_bpartner_id" +
      "        left join c_city d on d.c_city_id = c.em_sspr_city" +
      "        left join c_bpartner e on e.c_bpartner_id = a.Authorizer_ID" +
      "        left join sspr_contract f on f.c_bpartner_id = e.c_bpartner_id and f.isactive = 'Y'" +
      "        left join sspr_contract_position g on g.sspr_contract_id = f.sspr_contract_id and g.isactive = 'Y'" +
      "        left join sspr_position h on h.sspr_position_id = g.sspr_position_id" +
      "        left join ad_org i on i.ad_org_id = a.ad_org_id" +
      "	where a.sspr_leave_emp_id = ?" +
      "	and g.startdate = (select max(startdate) from sspr_contract_position where  sspr_contract_id = f.sspr_contract_id and isactive = 'Y' )";

    ResultSet result;
    Vector<RptRequestVacactionsData> vector = new Vector<RptRequestVacactionsData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ad_user);
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
        RptRequestVacactionsData objectRptRequestVacactionsData = new RptRequestVacactionsData();
        objectRptRequestVacactionsData.organizationid = UtilSql.getValue(result, "organizationid");
        objectRptRequestVacactionsData.documentno = UtilSql.getValue(result, "documentno");
        objectRptRequestVacactionsData.doctype = UtilSql.getValue(result, "doctype");
        objectRptRequestVacactionsData.fechacity = UtilSql.getValue(result, "fechacity");
        objectRptRequestVacactionsData.cpa = UtilSql.getValue(result, "cpa");
        objectRptRequestVacactionsData.jefe = UtilSql.getValue(result, "jefe");
        objectRptRequestVacactionsData.cargo = UtilSql.getValue(result, "cargo");
        objectRptRequestVacactionsData.organizacion = UtilSql.getValue(result, "organizacion");
        objectRptRequestVacactionsData.citydefault = UtilSql.getValue(result, "citydefault");
        objectRptRequestVacactionsData.consideraciones = UtilSql.getValue(result, "consideraciones");
        objectRptRequestVacactionsData.body = UtilSql.getValue(result, "body");
        objectRptRequestVacactionsData.startdateout = UtilSql.getValue(result, "startdateout");
        objectRptRequestVacactionsData.enddateout = UtilSql.getValue(result, "enddateout");
        objectRptRequestVacactionsData.atentamente = UtilSql.getValue(result, "atentamente");
        objectRptRequestVacactionsData.ci = UtilSql.getValue(result, "ci");
        objectRptRequestVacactionsData.exclusives = UtilSql.getValue(result, "exclusives");
        objectRptRequestVacactionsData.autorizado1 = UtilSql.getValue(result, "autorizado1");
        objectRptRequestVacactionsData.autorizado2 = UtilSql.getValue(result, "autorizado2");
        objectRptRequestVacactionsData.autorizado3 = UtilSql.getValue(result, "autorizado3");
        objectRptRequestVacactionsData.autorizado4 = UtilSql.getValue(result, "autorizado4");
        objectRptRequestVacactionsData.copia = UtilSql.getValue(result, "copia");
        objectRptRequestVacactionsData.fechaImpresion = UtilSql.getValue(result, "fecha_impresion");
        objectRptRequestVacactionsData.usuario = UtilSql.getValue(result, "usuario");
        objectRptRequestVacactionsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptRequestVacactionsData);
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
    RptRequestVacactionsData objectRptRequestVacactionsData[] = new RptRequestVacactionsData[vector.size()];
    vector.copyInto(objectRptRequestVacactionsData);
    return(objectRptRequestVacactionsData);
  }

  public static RptRequestVacactionsData[] set()    throws ServletException {
    RptRequestVacactionsData objectRptRequestVacactionsData[] = new RptRequestVacactionsData[1];
    objectRptRequestVacactionsData[0] = new RptRequestVacactionsData();
    objectRptRequestVacactionsData[0].organizationid = "";
    objectRptRequestVacactionsData[0].documentno = "";
    objectRptRequestVacactionsData[0].doctype = "";
    objectRptRequestVacactionsData[0].fechacity = "";
    objectRptRequestVacactionsData[0].cpa = "";
    objectRptRequestVacactionsData[0].jefe = "";
    objectRptRequestVacactionsData[0].cargo = "";
    objectRptRequestVacactionsData[0].organizacion = "";
    objectRptRequestVacactionsData[0].citydefault = "";
    objectRptRequestVacactionsData[0].consideraciones = "";
    objectRptRequestVacactionsData[0].body = "";
    objectRptRequestVacactionsData[0].startdateout = "";
    objectRptRequestVacactionsData[0].enddateout = "";
    objectRptRequestVacactionsData[0].atentamente = "";
    objectRptRequestVacactionsData[0].ci = "";
    objectRptRequestVacactionsData[0].exclusives = "";
    objectRptRequestVacactionsData[0].autorizado1 = "";
    objectRptRequestVacactionsData[0].autorizado2 = "";
    objectRptRequestVacactionsData[0].autorizado3 = "";
    objectRptRequestVacactionsData[0].autorizado4 = "";
    objectRptRequestVacactionsData[0].copia = "";
    objectRptRequestVacactionsData[0].fechaImpresion = "";
    objectRptRequestVacactionsData[0].usuario = "";
    return objectRptRequestVacactionsData;
  }
}
