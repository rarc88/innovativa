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

class RptRequestLeave5Data implements FieldProvider {
static Logger log4j = Logger.getLogger(RptRequestLeave5Data.class);
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
  public String revision;
  public String writtenby;
  public String approbedby;
  public String identificaction;
  public String sgi;
  public String valided;
  public String original;
  public String copy;
  public String actividadesdes;
  public String note;
  public String org;
  public String autorizado;
  public String taxidAutorizado;
  public String descripcionPersonal;
  public String descripcionOficial;
  public String cuidad;

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
    else if (fieldName.equalsIgnoreCase("actividadesdes"))
      return actividadesdes;
    else if (fieldName.equalsIgnoreCase("note"))
      return note;
    else if (fieldName.equalsIgnoreCase("org"))
      return org;
    else if (fieldName.equalsIgnoreCase("autorizado"))
      return autorizado;
    else if (fieldName.equalsIgnoreCase("taxid_autorizado") || fieldName.equals("taxidAutorizado"))
      return taxidAutorizado;
    else if (fieldName.equalsIgnoreCase("descripcion_personal") || fieldName.equals("descripcionPersonal"))
      return descripcionPersonal;
    else if (fieldName.equalsIgnoreCase("descripcion_oficial") || fieldName.equals("descripcionOficial"))
      return descripcionOficial;
    else if (fieldName.equalsIgnoreCase("cuidad"))
      return cuidad;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static RptRequestLeave5Data[] select5(ConnectionProvider connectionProvider, String leave)    throws ServletException {
    return select5(connectionProvider, leave, 0, 0);
  }

  public static RptRequestLeave5Data[] select5(ConnectionProvider connectionProvider, String leave, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select b.name as tercero,to_char('CI:' || ' ' ||b.taxid) as taxid_tercero, d.name as gerencia,e.name as unidad, k.name as puesto," +
      "    a.AUTHORIZED_DATE," +
      "    to_char(a.nohours) as nohours,a.nodays,to_char(a.stardate,'dd-MM-yyyy') as stardate,to_char(a.enddate,'dd-MM-yyyy') as enddate,to_char(a.starthour,'hh:mm') as starthour,to_char(a.endhour,'hh:mm') as      endhour,f.name as reemplazo," +
      "    REVISION,WRITTENBY,APPROBEDBY,IDENTIFICACTION,SGI,VALIDED,ORIGINAL,COPY," +
      "    g.DESCRIPTION as actividadesdes,H.NOTE, upper(o.name) as org, coalesce((select name from c_bpartner where c_bpartner_id = (select c_bpartner_id from sspr_leave_conf_default where isdefault_approver='Y' and isactive = 'Y')),l.name) as autorizado,coalesce((select to_char('CI:' || ' ' ||taxid) from c_bpartner where c_bpartner_id = (select c_bpartner_id from sspr_leave_conf_default where isdefault_approver='Y' and isactive = 'Y')),to_char('CI:' || ' ' ||l.taxid)) as taxid_autorizado," +
      "    case when a.oficial_specs is null then m.description else '' end as descripcion_personal," +
      "    case when a.oficial_specs is not null then a.oficial_specs else '' end as descripcion_oficial,n.name as cuidad from SSPR_LEAVE_EMP a" +
      "    left join ad_org o on a.ad_org_id = o.ad_org_id" +
      "        left join c_bpartner l on a.AUTHORIZER_ID = l.c_bpartner_id" +
      "        left join sspr_leave_category m on a.sspr_leave_category_id = m.sspr_leave_category_id" +
      "    left join c_bpartner b on a.c_bpartner_id = b.c_bpartner_id" +
      "    left join SSPR_LEAVE_EMP_MANT c on a.SSPR_LEAVE_TYPE_ID = c.SSPR_LEAVE_TYPE_ID and c.isactive='Y'" +
      "    left join C_COSTCENTER d on a.C_COSTCENTER_ID = d.C_COSTCENTER_ID" +
      "    left join SSHR_DEPARTMENT e on a.EM_SSHR_DEPARTMENT_ID = e.SSHR_DEPARTMENT_ID" +
      "    left join c_bpartner f on a.WHOREPLACE_ID = b.c_bpartner_id" +
      "    left join SSPR_LEAVE_EMP_DETAILS g on a.SSPR_LEAVE_EMP_ID = g.SSPR_LEAVE_EMP_ID" +
      "    left join SSPR_LEAVE_EMP_NOTES h on a.SSPR_LEAVE_TYPE_ID = h.SSPR_LEAVE_TYPE_ID and h.ISACTIVE ='Y'" +
      "    left join sspr_contract i on b.c_bpartner_id = i.c_bpartner_id" +
      "    left join sspr_contract_position j on i.sspr_contract_id = j.sspr_contract_id" +
      "    left join sspr_position k on j.sspr_position_id = k.sspr_position_id" +
      "          left join c_city n on a.c_city_id = n.c_city_id where a.SSPR_LEAVE_EMP_id = ?";

    ResultSet result;
    Vector<RptRequestLeave5Data> vector = new Vector<RptRequestLeave5Data>(0);
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
        RptRequestLeave5Data objectRptRequestLeave5Data = new RptRequestLeave5Data();
        objectRptRequestLeave5Data.tercero = UtilSql.getValue(result, "tercero");
        objectRptRequestLeave5Data.taxidTercero = UtilSql.getValue(result, "taxid_tercero");
        objectRptRequestLeave5Data.gerencia = UtilSql.getValue(result, "gerencia");
        objectRptRequestLeave5Data.unidad = UtilSql.getValue(result, "unidad");
        objectRptRequestLeave5Data.puesto = UtilSql.getValue(result, "puesto");
        objectRptRequestLeave5Data.authorizedDate = UtilSql.getDateValue(result, "authorized_date", "dd-MM-yyyy");
        objectRptRequestLeave5Data.nohours = UtilSql.getValue(result, "nohours");
        objectRptRequestLeave5Data.nodays = UtilSql.getValue(result, "nodays");
        objectRptRequestLeave5Data.stardate = UtilSql.getValue(result, "stardate");
        objectRptRequestLeave5Data.enddate = UtilSql.getValue(result, "enddate");
        objectRptRequestLeave5Data.starthour = UtilSql.getValue(result, "starthour");
        objectRptRequestLeave5Data.endhour = UtilSql.getValue(result, "endhour");
        objectRptRequestLeave5Data.reemplazo = UtilSql.getValue(result, "reemplazo");
        objectRptRequestLeave5Data.revision = UtilSql.getValue(result, "revision");
        objectRptRequestLeave5Data.writtenby = UtilSql.getValue(result, "writtenby");
        objectRptRequestLeave5Data.approbedby = UtilSql.getValue(result, "approbedby");
        objectRptRequestLeave5Data.identificaction = UtilSql.getValue(result, "identificaction");
        objectRptRequestLeave5Data.sgi = UtilSql.getValue(result, "sgi");
        objectRptRequestLeave5Data.valided = UtilSql.getValue(result, "valided");
        objectRptRequestLeave5Data.original = UtilSql.getValue(result, "original");
        objectRptRequestLeave5Data.copy = UtilSql.getValue(result, "copy");
        objectRptRequestLeave5Data.actividadesdes = UtilSql.getValue(result, "actividadesdes");
        objectRptRequestLeave5Data.note = UtilSql.getValue(result, "note");
        objectRptRequestLeave5Data.org = UtilSql.getValue(result, "org");
        objectRptRequestLeave5Data.autorizado = UtilSql.getValue(result, "autorizado");
        objectRptRequestLeave5Data.taxidAutorizado = UtilSql.getValue(result, "taxid_autorizado");
        objectRptRequestLeave5Data.descripcionPersonal = UtilSql.getValue(result, "descripcion_personal");
        objectRptRequestLeave5Data.descripcionOficial = UtilSql.getValue(result, "descripcion_oficial");
        objectRptRequestLeave5Data.cuidad = UtilSql.getValue(result, "cuidad");
        objectRptRequestLeave5Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptRequestLeave5Data);
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
    RptRequestLeave5Data objectRptRequestLeave5Data[] = new RptRequestLeave5Data[vector.size()];
    vector.copyInto(objectRptRequestLeave5Data);
    return(objectRptRequestLeave5Data);
  }

  public static RptRequestLeave5Data[] set()    throws ServletException {
    RptRequestLeave5Data objectRptRequestLeave5Data[] = new RptRequestLeave5Data[1];
    objectRptRequestLeave5Data[0] = new RptRequestLeave5Data();
    objectRptRequestLeave5Data[0].tercero = "";
    objectRptRequestLeave5Data[0].taxidTercero = "";
    objectRptRequestLeave5Data[0].gerencia = "";
    objectRptRequestLeave5Data[0].unidad = "";
    objectRptRequestLeave5Data[0].puesto = "";
    objectRptRequestLeave5Data[0].authorizedDate = "";
    objectRptRequestLeave5Data[0].nohours = "";
    objectRptRequestLeave5Data[0].nodays = "";
    objectRptRequestLeave5Data[0].stardate = "";
    objectRptRequestLeave5Data[0].enddate = "";
    objectRptRequestLeave5Data[0].starthour = "";
    objectRptRequestLeave5Data[0].endhour = "";
    objectRptRequestLeave5Data[0].reemplazo = "";
    objectRptRequestLeave5Data[0].revision = "";
    objectRptRequestLeave5Data[0].writtenby = "";
    objectRptRequestLeave5Data[0].approbedby = "";
    objectRptRequestLeave5Data[0].identificaction = "";
    objectRptRequestLeave5Data[0].sgi = "";
    objectRptRequestLeave5Data[0].valided = "";
    objectRptRequestLeave5Data[0].original = "";
    objectRptRequestLeave5Data[0].copy = "";
    objectRptRequestLeave5Data[0].actividadesdes = "";
    objectRptRequestLeave5Data[0].note = "";
    objectRptRequestLeave5Data[0].org = "";
    objectRptRequestLeave5Data[0].autorizado = "";
    objectRptRequestLeave5Data[0].taxidAutorizado = "";
    objectRptRequestLeave5Data[0].descripcionPersonal = "";
    objectRptRequestLeave5Data[0].descripcionOficial = "";
    objectRptRequestLeave5Data[0].cuidad = "";
    return objectRptRequestLeave5Data;
  }
}
