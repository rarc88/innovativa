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

class RptRequestLeave2Data implements FieldProvider {
static Logger log4j = Logger.getLogger(RptRequestLeave2Data.class);
  private String InitRecordNumber="0";
  public String tercero;
  public String taxidTercero;
  public String gerencia;
  public String unidad;
  public String puesto;
  public String authorizedDate;
  public String nohours;
  public String nodays;
  public String stardate;
  public String enddate;
  public String starthour;
  public String endhour;
  public String reemplazo;
  public String taxidRemplazo;
  public String revision;
  public String writtenby;
  public String approbedby;
  public String identificaction;
  public String sgi;
  public String valided;
  public String original;
  public String copy;
  public String anioactual;
  public String aniopasado;
  public String actividadesdes;
  public String org;
  public String autoriza;
  public String taxidAutoriza;
  public String description;
  public String tipoPermiso;
  public String startdatePeriod;
  public String enddatePeriod;
  public String organizationid;
  public String fechaImpresion;
  public String diasnormalespendientes;
  public String diasadicionalespendientes;
  public String documentono;
  public String usuario;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("tercero"))
      return tercero;
    else if (fieldName.equalsIgnoreCase("taxid_tercero") || fieldName.equals("taxidTercero"))
      return taxidTercero;
    else if (fieldName.equalsIgnoreCase("gerencia"))
      return gerencia;
    else if (fieldName.equalsIgnoreCase("unidad"))
      return unidad;
    else if (fieldName.equalsIgnoreCase("puesto"))
      return puesto;
    else if (fieldName.equalsIgnoreCase("authorized_date") || fieldName.equals("authorizedDate"))
      return authorizedDate;
    else if (fieldName.equalsIgnoreCase("nohours"))
      return nohours;
    else if (fieldName.equalsIgnoreCase("nodays"))
      return nodays;
    else if (fieldName.equalsIgnoreCase("stardate"))
      return stardate;
    else if (fieldName.equalsIgnoreCase("enddate"))
      return enddate;
    else if (fieldName.equalsIgnoreCase("starthour"))
      return starthour;
    else if (fieldName.equalsIgnoreCase("endhour"))
      return endhour;
    else if (fieldName.equalsIgnoreCase("reemplazo"))
      return reemplazo;
    else if (fieldName.equalsIgnoreCase("taxid_remplazo") || fieldName.equals("taxidRemplazo"))
      return taxidRemplazo;
    else if (fieldName.equalsIgnoreCase("revision"))
      return revision;
    else if (fieldName.equalsIgnoreCase("writtenby"))
      return writtenby;
    else if (fieldName.equalsIgnoreCase("approbedby"))
      return approbedby;
    else if (fieldName.equalsIgnoreCase("identificaction"))
      return identificaction;
    else if (fieldName.equalsIgnoreCase("sgi"))
      return sgi;
    else if (fieldName.equalsIgnoreCase("valided"))
      return valided;
    else if (fieldName.equalsIgnoreCase("original"))
      return original;
    else if (fieldName.equalsIgnoreCase("copy"))
      return copy;
    else if (fieldName.equalsIgnoreCase("anioactual"))
      return anioactual;
    else if (fieldName.equalsIgnoreCase("aniopasado"))
      return aniopasado;
    else if (fieldName.equalsIgnoreCase("actividadesdes"))
      return actividadesdes;
    else if (fieldName.equalsIgnoreCase("org"))
      return org;
    else if (fieldName.equalsIgnoreCase("autoriza"))
      return autoriza;
    else if (fieldName.equalsIgnoreCase("taxid_autoriza") || fieldName.equals("taxidAutoriza"))
      return taxidAutoriza;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("tipo_permiso") || fieldName.equals("tipoPermiso"))
      return tipoPermiso;
    else if (fieldName.equalsIgnoreCase("startdate_period") || fieldName.equals("startdatePeriod"))
      return startdatePeriod;
    else if (fieldName.equalsIgnoreCase("enddate_period") || fieldName.equals("enddatePeriod"))
      return enddatePeriod;
    else if (fieldName.equalsIgnoreCase("organizationid"))
      return organizationid;
    else if (fieldName.equalsIgnoreCase("fecha_impresion") || fieldName.equals("fechaImpresion"))
      return fechaImpresion;
    else if (fieldName.equalsIgnoreCase("diasnormalespendientes"))
      return diasnormalespendientes;
    else if (fieldName.equalsIgnoreCase("diasadicionalespendientes"))
      return diasadicionalespendientes;
    else if (fieldName.equalsIgnoreCase("documentono"))
      return documentono;
    else if (fieldName.equalsIgnoreCase("usuario"))
      return usuario;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static RptRequestLeave2Data[] select(ConnectionProvider connectionProvider, String ad_user, String leave)    throws ServletException {
    return select(connectionProvider, ad_user, leave, 0, 0);
  }

  public static RptRequestLeave2Data[] select(ConnectionProvider connectionProvider, String ad_user, String leave, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "select b.name as tercero,to_char('CI:' || ' ' ||b.taxid) as taxid_tercero, d.name as gerencia,e.name as unidad, k.name as puesto, " +
      "    to_char(a.AUTHORIZED_DATE,'dd-MM-yyyy') as AUTHORIZED_DATE," +
      "    to_char(a.nohours) as nohours,a.nodays,to_char(a.stardate,'dd-MM-yyyy') as stardate,to_char(a.enddate,'dd-MM-yyyy') as enddate,to_char(a.starthour,'hh:mm') as starthour,to_char(a.endhour,'hh:mm') as      endhour,f.name as reemplazo,to_char('CI:' || ' ' ||f.taxid) as taxid_remplazo,REVISION,WRITTENBY,APPROBEDBY,IDENTIFICACTION,SGI,VALIDED,ORIGINAL,COPY,  " +
      "    to_char(now(),'yyyy') as anioactual,to_char(to_number(to_char(now(),'yyyy'))-1) as aniopasado,  " +
      "    g.DESCRIPTION as actividadesdes,upper(o.name) as org,coalesce((select name from c_bpartner where c_bpartner_id =  " +
      "    (select c_bpartner_id from sspr_leave_conf_default where isdefault_approver='Y' and isactive = 'Y')),q.name) as autoriza,  " +
      "    coalesce((select to_char('CI:' || ' ' ||taxid) from c_bpartner where c_bpartner_id = (select c_bpartner_id  " +
      "    from sspr_leave_conf_default where isdefault_approver='Y' and isactive = 'Y')),to_char('CI:' || ' ' ||q.taxid)) as taxid_autoriza,a.description,r.name as tipo_permiso,  " +
      "    to_char(dl.startdate_period,'dd/MM/yyyy') as startdate_period,to_char(dl.enddate_period,'dd/MM/yyyy') as enddate_period,  " +
      "    a.ad_org_id as organizationid, to_char(now(),'dd/MM/yyyy HH24:MI:SS') as fecha_impresion ,  " +
      "    (select sum(Nodays) from sspr_vacations  vc where b.c_bpartner_id = vc.c_bpartner_id) as diasnormalespendientes ,  " +
      "(select sum(Noadditionaltotal) from sspr_vacations  vc where b.c_bpartner_id = vc.c_bpartner_id) as diasadicionalespendientes , " +
      " a.documentno as documentono ," +
      "(SELECT COALESCE(CB.NAME,AU.NAME) FROM AD_USER AU LEFT JOIN C_BPARTNER CB ON CB.C_BPARTNER_ID = AU.C_BPARTNER_ID WHERE AU.AD_USER_ID= ? ) AS usuario" +
      "    from SSPR_LEAVE_EMP a left join c_bpartner b on a.c_bpartner_id = b.c_bpartner_id  " +
      "            left join SSPR_LEAVE_EMP_MANT c on a.SSPR_LEAVE_TYPE_ID = c.SSPR_LEAVE_TYPE_ID and c.isactive='Y' " +
      "            left join C_COSTCENTER d on a.C_COSTCENTER_ID = d.C_COSTCENTER_ID    " +
      "            left join SSHR_DEPARTMENT e on a.EM_SSHR_DEPARTMENT_ID = e.SSHR_DEPARTMENT_ID  " +
      "            left join c_bpartner f on a.WHOREPLACE_ID = f.c_bpartner_id  " +
      "            left join SSPR_LEAVE_EMP_DETAILS g on a.SSPR_LEAVE_EMP_ID = g.SSPR_LEAVE_EMP_ID  " +
      "            left join SSPR_LEAVE_EMP_NOTES h on a.SSPR_LEAVE_TYPE_ID = h.SSPR_LEAVE_TYPE_ID and h.ISACTIVE ='Y'  " +
      "            left join sspr_contract i on b.c_bpartner_id = i.c_bpartner_id  " +
      "            left join sspr_contract_position j on i.sspr_contract_id = j.sspr_contract_id  " +
      "            left join sspr_position k on j.sspr_position_id = k.sspr_position_id  " +
      "            left join ad_org o on a.ad_org_id = o.ad_org_id    " +
      "            left join c_bpartner q on a.AUTHORIZER_ID = q.c_bpartner_id  " +
      "      left join sspr_leave_type r on a.SSPR_LEAVE_TYPE_ID = r.SSPR_LEAVE_TYPE_ID  " +
      "      left join (select sspr_leave_emp_id, max(startdate) as startdate_period,max(enddate) as enddate_period  " +
      "      from sspr_leave_emp_vac group by sspr_leave_emp_id) dl on a.sspr_leave_emp_id = dl.sspr_leave_emp_id  " +
      " where a.SSPR_LEAVE_EMP_id = ?  ";

    ResultSet result;
    Vector<RptRequestLeave2Data> vector = new Vector<RptRequestLeave2Data>(0);
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
        RptRequestLeave2Data objectRptRequestLeave2Data = new RptRequestLeave2Data();
        objectRptRequestLeave2Data.tercero = UtilSql.getValue(result, "tercero");
        objectRptRequestLeave2Data.taxidTercero = UtilSql.getValue(result, "taxid_tercero");
        objectRptRequestLeave2Data.gerencia = UtilSql.getValue(result, "gerencia");
        objectRptRequestLeave2Data.unidad = UtilSql.getValue(result, "unidad");
        objectRptRequestLeave2Data.puesto = UtilSql.getValue(result, "puesto");
        objectRptRequestLeave2Data.authorizedDate = UtilSql.getValue(result, "authorized_date");
        objectRptRequestLeave2Data.nohours = UtilSql.getValue(result, "nohours");
        objectRptRequestLeave2Data.nodays = UtilSql.getValue(result, "nodays");
        objectRptRequestLeave2Data.stardate = UtilSql.getValue(result, "stardate");
        objectRptRequestLeave2Data.enddate = UtilSql.getValue(result, "enddate");
        objectRptRequestLeave2Data.starthour = UtilSql.getValue(result, "starthour");
        objectRptRequestLeave2Data.endhour = UtilSql.getValue(result, "endhour");
        objectRptRequestLeave2Data.reemplazo = UtilSql.getValue(result, "reemplazo");
        objectRptRequestLeave2Data.taxidRemplazo = UtilSql.getValue(result, "taxid_remplazo");
        objectRptRequestLeave2Data.revision = UtilSql.getValue(result, "revision");
        objectRptRequestLeave2Data.writtenby = UtilSql.getValue(result, "writtenby");
        objectRptRequestLeave2Data.approbedby = UtilSql.getValue(result, "approbedby");
        objectRptRequestLeave2Data.identificaction = UtilSql.getValue(result, "identificaction");
        objectRptRequestLeave2Data.sgi = UtilSql.getValue(result, "sgi");
        objectRptRequestLeave2Data.valided = UtilSql.getValue(result, "valided");
        objectRptRequestLeave2Data.original = UtilSql.getValue(result, "original");
        objectRptRequestLeave2Data.copy = UtilSql.getValue(result, "copy");
        objectRptRequestLeave2Data.anioactual = UtilSql.getValue(result, "anioactual");
        objectRptRequestLeave2Data.aniopasado = UtilSql.getValue(result, "aniopasado");
        objectRptRequestLeave2Data.actividadesdes = UtilSql.getValue(result, "actividadesdes");
        objectRptRequestLeave2Data.org = UtilSql.getValue(result, "org");
        objectRptRequestLeave2Data.autoriza = UtilSql.getValue(result, "autoriza");
        objectRptRequestLeave2Data.taxidAutoriza = UtilSql.getValue(result, "taxid_autoriza");
        objectRptRequestLeave2Data.description = UtilSql.getValue(result, "description");
        objectRptRequestLeave2Data.tipoPermiso = UtilSql.getValue(result, "tipo_permiso");
        objectRptRequestLeave2Data.startdatePeriod = UtilSql.getValue(result, "startdate_period");
        objectRptRequestLeave2Data.enddatePeriod = UtilSql.getValue(result, "enddate_period");
        objectRptRequestLeave2Data.organizationid = UtilSql.getValue(result, "organizationid");
        objectRptRequestLeave2Data.fechaImpresion = UtilSql.getValue(result, "fecha_impresion");
        objectRptRequestLeave2Data.diasnormalespendientes = UtilSql.getValue(result, "diasnormalespendientes");
        objectRptRequestLeave2Data.diasadicionalespendientes = UtilSql.getValue(result, "diasadicionalespendientes");
        objectRptRequestLeave2Data.documentono = UtilSql.getValue(result, "documentono");
        objectRptRequestLeave2Data.usuario = UtilSql.getValue(result, "usuario");
        objectRptRequestLeave2Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptRequestLeave2Data);
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
    RptRequestLeave2Data objectRptRequestLeave2Data[] = new RptRequestLeave2Data[vector.size()];
    vector.copyInto(objectRptRequestLeave2Data);
    return(objectRptRequestLeave2Data);
  }

  public static RptRequestLeave2Data[] set()    throws ServletException {
    RptRequestLeave2Data objectRptRequestLeave2Data[] = new RptRequestLeave2Data[1];
    objectRptRequestLeave2Data[0] = new RptRequestLeave2Data();
    objectRptRequestLeave2Data[0].tercero = "";
    objectRptRequestLeave2Data[0].taxidTercero = "";
    objectRptRequestLeave2Data[0].gerencia = "";
    objectRptRequestLeave2Data[0].unidad = "";
    objectRptRequestLeave2Data[0].puesto = "";
    objectRptRequestLeave2Data[0].authorizedDate = "";
    objectRptRequestLeave2Data[0].nohours = "";
    objectRptRequestLeave2Data[0].nodays = "";
    objectRptRequestLeave2Data[0].stardate = "";
    objectRptRequestLeave2Data[0].enddate = "";
    objectRptRequestLeave2Data[0].starthour = "";
    objectRptRequestLeave2Data[0].endhour = "";
    objectRptRequestLeave2Data[0].reemplazo = "";
    objectRptRequestLeave2Data[0].taxidRemplazo = "";
    objectRptRequestLeave2Data[0].revision = "";
    objectRptRequestLeave2Data[0].writtenby = "";
    objectRptRequestLeave2Data[0].approbedby = "";
    objectRptRequestLeave2Data[0].identificaction = "";
    objectRptRequestLeave2Data[0].sgi = "";
    objectRptRequestLeave2Data[0].valided = "";
    objectRptRequestLeave2Data[0].original = "";
    objectRptRequestLeave2Data[0].copy = "";
    objectRptRequestLeave2Data[0].anioactual = "";
    objectRptRequestLeave2Data[0].aniopasado = "";
    objectRptRequestLeave2Data[0].actividadesdes = "";
    objectRptRequestLeave2Data[0].org = "";
    objectRptRequestLeave2Data[0].autoriza = "";
    objectRptRequestLeave2Data[0].taxidAutoriza = "";
    objectRptRequestLeave2Data[0].description = "";
    objectRptRequestLeave2Data[0].tipoPermiso = "";
    objectRptRequestLeave2Data[0].startdatePeriod = "";
    objectRptRequestLeave2Data[0].enddatePeriod = "";
    objectRptRequestLeave2Data[0].organizationid = "";
    objectRptRequestLeave2Data[0].fechaImpresion = "";
    objectRptRequestLeave2Data[0].diasnormalespendientes = "";
    objectRptRequestLeave2Data[0].diasadicionalespendientes = "";
    objectRptRequestLeave2Data[0].documentono = "";
    objectRptRequestLeave2Data[0].usuario = "";
    return objectRptRequestLeave2Data;
  }
}
