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

class RptRequestLeave3Data implements FieldProvider {
static Logger log4j = Logger.getLogger(RptRequestLeave3Data.class);
  private String InitRecordNumber="0";
  public String tercero;
  public String taxidTercero;
  public String gerencia;
  public String unidad;
  public String puesto;
  public String jefe;
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
  public String anioactual;
  public String aniopasado;
  public String actividadesdes;
  public String note;
  public String detailsNames;
  public String parentezco;
  public String dDeath;
  public String mDeath;
  public String yDeath;
  public String detailsSinister;
  public String dSinister;
  public String mSinister;
  public String ySinister;
  public String dAuthorized;
  public String mAuthorized;
  public String yAuthorized;
  public String dStardate;
  public String mStardate;
  public String yStardate;
  public String org;
  public String autoriza;
  public String taxidAutoriza;

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
    else if (fieldName.equalsIgnoreCase("jefe"))
      return jefe;
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
    else if (fieldName.equalsIgnoreCase("anioactual"))
      return anioactual;
    else if (fieldName.equalsIgnoreCase("aniopasado"))
      return aniopasado;
    else if (fieldName.equalsIgnoreCase("actividadesdes"))
      return actividadesdes;
    else if (fieldName.equalsIgnoreCase("note"))
      return note;
    else if (fieldName.equalsIgnoreCase("details_names") || fieldName.equals("detailsNames"))
      return detailsNames;
    else if (fieldName.equalsIgnoreCase("parentezco"))
      return parentezco;
    else if (fieldName.equalsIgnoreCase("d_death") || fieldName.equals("dDeath"))
      return dDeath;
    else if (fieldName.equalsIgnoreCase("m_death") || fieldName.equals("mDeath"))
      return mDeath;
    else if (fieldName.equalsIgnoreCase("y_death") || fieldName.equals("yDeath"))
      return yDeath;
    else if (fieldName.equalsIgnoreCase("details_sinister") || fieldName.equals("detailsSinister"))
      return detailsSinister;
    else if (fieldName.equalsIgnoreCase("d_sinister") || fieldName.equals("dSinister"))
      return dSinister;
    else if (fieldName.equalsIgnoreCase("m_sinister") || fieldName.equals("mSinister"))
      return mSinister;
    else if (fieldName.equalsIgnoreCase("y_sinister") || fieldName.equals("ySinister"))
      return ySinister;
    else if (fieldName.equalsIgnoreCase("d_authorized") || fieldName.equals("dAuthorized"))
      return dAuthorized;
    else if (fieldName.equalsIgnoreCase("m_authorized") || fieldName.equals("mAuthorized"))
      return mAuthorized;
    else if (fieldName.equalsIgnoreCase("y_authorized") || fieldName.equals("yAuthorized"))
      return yAuthorized;
    else if (fieldName.equalsIgnoreCase("d_stardate") || fieldName.equals("dStardate"))
      return dStardate;
    else if (fieldName.equalsIgnoreCase("m_stardate") || fieldName.equals("mStardate"))
      return mStardate;
    else if (fieldName.equalsIgnoreCase("y_stardate") || fieldName.equals("yStardate"))
      return yStardate;
    else if (fieldName.equalsIgnoreCase("org"))
      return org;
    else if (fieldName.equalsIgnoreCase("autoriza"))
      return autoriza;
    else if (fieldName.equalsIgnoreCase("taxid_autoriza") || fieldName.equals("taxidAutoriza"))
      return taxidAutoriza;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static RptRequestLeave3Data[] select3(ConnectionProvider connectionProvider, String leave)    throws ServletException {
    return select3(connectionProvider, leave, 0, 0);
  }

  public static RptRequestLeave3Data[] select3(ConnectionProvider connectionProvider, String leave, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select b.name as tercero,to_char('CI:' || ' ' ||b.taxid) as taxid_tercero, d.name as gerencia,e.name as unidad, k.name as puesto,n.name as jefe," +
      "    l.name ||' , '|| to_char(a.AUTHORIZED_DATE,'dd-MM-yyyy') as AUTHORIZED_DATE," +
      "    to_char(a.nohours) as nohours,a.nodays,a.stardate,a.enddate,to_char(a.starthour,'hh:mm') as starthour,to_char(a.endhour,'hh:mm') as         endhour,f.name as reemplazo," +
      "    REVISION,WRITTENBY,APPROBEDBY,IDENTIFICACTION,SGI,VALIDED,ORIGINAL,COPY," +
      "    to_char(now(),'yyyy') as anioactual,to_char(to_number(to_char(now(),'yyyy'))-1) as aniopasado," +
      "    g.DESCRIPTION as actividadesdes,H.NOTE," +
      "    a.details_names,o.name as parentezco,to_char(a.date_death,'dd') as d_death,to_char(a.date_death,'mm') as m_death,to_char(a.date_death,'yyyy') as y_death," +
      "    a.details_sinister,to_char(a.date_sinister,'dd') as d_sinister,to_char(a.date_sinister,'mm') as m_sinister,to_char(a.date_sinister,'yyyy') as y_sinister," +
      "    to_char(a.AUTHORIZED_DATE,'dd') as d_AUTHORIZED,to_char(a.AUTHORIZED_DATE,'mm') as m_AUTHORIZED,to_char(a.AUTHORIZED_DATE,'yyyy') as y_AUTHORIZED," +
      "    to_char(a.stardate,'dd') as d_stardate,to_char(a.stardate,'mm') as m_stardate,to_char(a.stardate,'yyyy') as y_stardate,upper(p.name) as org, coalesce((select name from c_bpartner where c_bpartner_id = (select c_bpartner_id from sspr_leave_conf_default where isdefault_approver='Y' and isactive = 'Y')),q.name) as autoriza,coalesce((select to_char('CI:' || ' ' ||taxid) from c_bpartner where c_bpartner_id = (select c_bpartner_id from sspr_leave_conf_default where isdefault_approver='Y' and isactive = 'Y')),to_char('CI:' || ' ' ||q.taxid)) as taxid_autoriza from SSPR_LEAVE_EMP a left join c_bpartner b on a.c_bpartner_id = b.c_bpartner_id" +
      "    left join SSPR_LEAVE_EMP_MANT c on a.SSPR_LEAVE_TYPE_ID = c.SSPR_LEAVE_TYPE_ID and c.isactive='Y'" +
      "    left join C_COSTCENTER d on a.C_COSTCENTER_ID = d.C_COSTCENTER_ID" +
      "    left join SSHR_DEPARTMENT e on a.EM_SSHR_DEPARTMENT_ID = e.SSHR_DEPARTMENT_ID" +
      "    left join c_bpartner f on a.WHOREPLACE_ID = b.c_bpartner_id" +
      "    left join SSPR_LEAVE_EMP_DETAILS g on a.SSPR_LEAVE_EMP_ID = g.SSPR_LEAVE_EMP_ID" +
      "    left join SSPR_LEAVE_EMP_NOTES h on a.SSPR_LEAVE_TYPE_ID = h.SSPR_LEAVE_TYPE_ID and h.ISACTIVE ='Y'" +
      "    left join sspr_contract i on b.c_bpartner_id = i.c_bpartner_id" +
      "    left join sspr_contract_position j on i.sspr_contract_id = j.sspr_contract_id" +
      "    left join sspr_position k on j.sspr_position_id = k.sspr_position_id" +
      "    left join c_city l on a.c_city_id = l.c_city_id" +
      "    left join sshr_reportto m on b.c_bpartner_id = m.c_bpartner_id" +
      "    left join c_bpartner n on m.c_bpartner_boss = n.c_bpartner_id" +
      "    left join sspr_relationship o on a.sspr_relationship_id = o.sspr_relationship_id" +
      "    left join ad_org p on a.ad_org_id = p.ad_org_id" +
      "          left join c_bpartner q on a.AUTHORIZER_ID = q.c_bpartner_id" +
      "    where a.SSPR_LEAVE_EMP_id = ?";

    ResultSet result;
    Vector<RptRequestLeave3Data> vector = new Vector<RptRequestLeave3Data>(0);
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
        RptRequestLeave3Data objectRptRequestLeave3Data = new RptRequestLeave3Data();
        objectRptRequestLeave3Data.tercero = UtilSql.getValue(result, "tercero");
        objectRptRequestLeave3Data.taxidTercero = UtilSql.getValue(result, "taxid_tercero");
        objectRptRequestLeave3Data.gerencia = UtilSql.getValue(result, "gerencia");
        objectRptRequestLeave3Data.unidad = UtilSql.getValue(result, "unidad");
        objectRptRequestLeave3Data.puesto = UtilSql.getValue(result, "puesto");
        objectRptRequestLeave3Data.jefe = UtilSql.getValue(result, "jefe");
        objectRptRequestLeave3Data.authorizedDate = UtilSql.getValue(result, "authorized_date");
        objectRptRequestLeave3Data.nohours = UtilSql.getValue(result, "nohours");
        objectRptRequestLeave3Data.nodays = UtilSql.getValue(result, "nodays");
        objectRptRequestLeave3Data.stardate = UtilSql.getDateValue(result, "stardate", "dd-MM-yyyy");
        objectRptRequestLeave3Data.enddate = UtilSql.getDateValue(result, "enddate", "dd-MM-yyyy");
        objectRptRequestLeave3Data.starthour = UtilSql.getValue(result, "starthour");
        objectRptRequestLeave3Data.endhour = UtilSql.getValue(result, "endhour");
        objectRptRequestLeave3Data.reemplazo = UtilSql.getValue(result, "reemplazo");
        objectRptRequestLeave3Data.revision = UtilSql.getValue(result, "revision");
        objectRptRequestLeave3Data.writtenby = UtilSql.getValue(result, "writtenby");
        objectRptRequestLeave3Data.approbedby = UtilSql.getValue(result, "approbedby");
        objectRptRequestLeave3Data.identificaction = UtilSql.getValue(result, "identificaction");
        objectRptRequestLeave3Data.sgi = UtilSql.getValue(result, "sgi");
        objectRptRequestLeave3Data.valided = UtilSql.getValue(result, "valided");
        objectRptRequestLeave3Data.original = UtilSql.getValue(result, "original");
        objectRptRequestLeave3Data.copy = UtilSql.getValue(result, "copy");
        objectRptRequestLeave3Data.anioactual = UtilSql.getValue(result, "anioactual");
        objectRptRequestLeave3Data.aniopasado = UtilSql.getValue(result, "aniopasado");
        objectRptRequestLeave3Data.actividadesdes = UtilSql.getValue(result, "actividadesdes");
        objectRptRequestLeave3Data.note = UtilSql.getValue(result, "note");
        objectRptRequestLeave3Data.detailsNames = UtilSql.getValue(result, "details_names");
        objectRptRequestLeave3Data.parentezco = UtilSql.getValue(result, "parentezco");
        objectRptRequestLeave3Data.dDeath = UtilSql.getValue(result, "d_death");
        objectRptRequestLeave3Data.mDeath = UtilSql.getValue(result, "m_death");
        objectRptRequestLeave3Data.yDeath = UtilSql.getValue(result, "y_death");
        objectRptRequestLeave3Data.detailsSinister = UtilSql.getValue(result, "details_sinister");
        objectRptRequestLeave3Data.dSinister = UtilSql.getValue(result, "d_sinister");
        objectRptRequestLeave3Data.mSinister = UtilSql.getValue(result, "m_sinister");
        objectRptRequestLeave3Data.ySinister = UtilSql.getValue(result, "y_sinister");
        objectRptRequestLeave3Data.dAuthorized = UtilSql.getValue(result, "d_authorized");
        objectRptRequestLeave3Data.mAuthorized = UtilSql.getValue(result, "m_authorized");
        objectRptRequestLeave3Data.yAuthorized = UtilSql.getValue(result, "y_authorized");
        objectRptRequestLeave3Data.dStardate = UtilSql.getValue(result, "d_stardate");
        objectRptRequestLeave3Data.mStardate = UtilSql.getValue(result, "m_stardate");
        objectRptRequestLeave3Data.yStardate = UtilSql.getValue(result, "y_stardate");
        objectRptRequestLeave3Data.org = UtilSql.getValue(result, "org");
        objectRptRequestLeave3Data.autoriza = UtilSql.getValue(result, "autoriza");
        objectRptRequestLeave3Data.taxidAutoriza = UtilSql.getValue(result, "taxid_autoriza");
        objectRptRequestLeave3Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptRequestLeave3Data);
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
    RptRequestLeave3Data objectRptRequestLeave3Data[] = new RptRequestLeave3Data[vector.size()];
    vector.copyInto(objectRptRequestLeave3Data);
    return(objectRptRequestLeave3Data);
  }

  public static RptRequestLeave3Data[] set()    throws ServletException {
    RptRequestLeave3Data objectRptRequestLeave3Data[] = new RptRequestLeave3Data[1];
    objectRptRequestLeave3Data[0] = new RptRequestLeave3Data();
    objectRptRequestLeave3Data[0].tercero = "";
    objectRptRequestLeave3Data[0].taxidTercero = "";
    objectRptRequestLeave3Data[0].gerencia = "";
    objectRptRequestLeave3Data[0].unidad = "";
    objectRptRequestLeave3Data[0].puesto = "";
    objectRptRequestLeave3Data[0].jefe = "";
    objectRptRequestLeave3Data[0].authorizedDate = "";
    objectRptRequestLeave3Data[0].nohours = "";
    objectRptRequestLeave3Data[0].nodays = "";
    objectRptRequestLeave3Data[0].stardate = "";
    objectRptRequestLeave3Data[0].enddate = "";
    objectRptRequestLeave3Data[0].starthour = "";
    objectRptRequestLeave3Data[0].endhour = "";
    objectRptRequestLeave3Data[0].reemplazo = "";
    objectRptRequestLeave3Data[0].revision = "";
    objectRptRequestLeave3Data[0].writtenby = "";
    objectRptRequestLeave3Data[0].approbedby = "";
    objectRptRequestLeave3Data[0].identificaction = "";
    objectRptRequestLeave3Data[0].sgi = "";
    objectRptRequestLeave3Data[0].valided = "";
    objectRptRequestLeave3Data[0].original = "";
    objectRptRequestLeave3Data[0].copy = "";
    objectRptRequestLeave3Data[0].anioactual = "";
    objectRptRequestLeave3Data[0].aniopasado = "";
    objectRptRequestLeave3Data[0].actividadesdes = "";
    objectRptRequestLeave3Data[0].note = "";
    objectRptRequestLeave3Data[0].detailsNames = "";
    objectRptRequestLeave3Data[0].parentezco = "";
    objectRptRequestLeave3Data[0].dDeath = "";
    objectRptRequestLeave3Data[0].mDeath = "";
    objectRptRequestLeave3Data[0].yDeath = "";
    objectRptRequestLeave3Data[0].detailsSinister = "";
    objectRptRequestLeave3Data[0].dSinister = "";
    objectRptRequestLeave3Data[0].mSinister = "";
    objectRptRequestLeave3Data[0].ySinister = "";
    objectRptRequestLeave3Data[0].dAuthorized = "";
    objectRptRequestLeave3Data[0].mAuthorized = "";
    objectRptRequestLeave3Data[0].yAuthorized = "";
    objectRptRequestLeave3Data[0].dStardate = "";
    objectRptRequestLeave3Data[0].mStardate = "";
    objectRptRequestLeave3Data[0].yStardate = "";
    objectRptRequestLeave3Data[0].org = "";
    objectRptRequestLeave3Data[0].autoriza = "";
    objectRptRequestLeave3Data[0].taxidAutoriza = "";
    return objectRptRequestLeave3Data;
  }
}
