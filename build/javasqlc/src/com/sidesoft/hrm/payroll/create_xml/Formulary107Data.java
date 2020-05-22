//Sqlc generated V1.O00-1
package com.sidesoft.hrm.payroll.create_xml;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class Formulary107Data implements FieldProvider {
static Logger log4j = Logger.getLogger(Formulary107Data.class);
  private String InitRecordNumber="0";
  public String anioEntrega;
  public String mesEntrega;
  public String diaEntrega;
  public String taxidOrg;
  public String org;
  public String anio;
  public String cYearId;
  public String taxidEmployee;
  public String empleado;
  public String tipoidentificacion;
  public String numeroidentificacion;
  public String empleadoapellido;
  public String empleadonombre;
  public String codigoestab;
  public String pais;
  public String codigopais;
  public String aplicaconvenio;
  public String discapacitado;
  public String porcentajediscapacidad;
  public String tipoidentdiscapacidad;
  public String numeroidentifdiscapacidad;
  public String sueldo;
  public String bonos;
  public String utilidades;
  public String impuestorenta;
  public String decimotercero;
  public String decimocuarto;
  public String fondosreserva;
  public String compensacionsalariodigno;
  public String otrosingRentagravada;
  public String ingresosgrav349;
  public String sistemasalariodigno;
  public String aportepersonal;
  public String impuestorentacausado;
  public String valorimprettrabajador;
  public String gastosvivienda;
  public String gastossalud;
  public String gastoseducacion;
  public String gastoalimentacion;
  public String gastosvestimenta;
  public String ingresosgravados;
  public String aportepersonalo;
  public String exoneracionpordiscapacidad;
  public String exoneracionportercerasedad;
  public String valorimpret403;
  public String valorimpasumido405;
  public String baseimponiblegrav;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("anio_entrega") || fieldName.equals("anioEntrega"))
      return anioEntrega;
    else if (fieldName.equalsIgnoreCase("mes_entrega") || fieldName.equals("mesEntrega"))
      return mesEntrega;
    else if (fieldName.equalsIgnoreCase("dia_entrega") || fieldName.equals("diaEntrega"))
      return diaEntrega;
    else if (fieldName.equalsIgnoreCase("taxid_org") || fieldName.equals("taxidOrg"))
      return taxidOrg;
    else if (fieldName.equalsIgnoreCase("org"))
      return org;
    else if (fieldName.equalsIgnoreCase("anio"))
      return anio;
    else if (fieldName.equalsIgnoreCase("c_year_id") || fieldName.equals("cYearId"))
      return cYearId;
    else if (fieldName.equalsIgnoreCase("taxid_employee") || fieldName.equals("taxidEmployee"))
      return taxidEmployee;
    else if (fieldName.equalsIgnoreCase("empleado"))
      return empleado;
    else if (fieldName.equalsIgnoreCase("tipoidentificacion"))
      return tipoidentificacion;
    else if (fieldName.equalsIgnoreCase("numeroidentificacion"))
      return numeroidentificacion;
    else if (fieldName.equalsIgnoreCase("empleadoapellido"))
      return empleadoapellido;
    else if (fieldName.equalsIgnoreCase("empleadonombre"))
      return empleadonombre;
    else if (fieldName.equalsIgnoreCase("codigoestab"))
      return codigoestab;
    else if (fieldName.equalsIgnoreCase("pais"))
      return pais;
    else if (fieldName.equalsIgnoreCase("codigopais"))
      return codigopais;
    else if (fieldName.equalsIgnoreCase("aplicaconvenio"))
      return aplicaconvenio;
    else if (fieldName.equalsIgnoreCase("discapacitado"))
      return discapacitado;
    else if (fieldName.equalsIgnoreCase("porcentajediscapacidad"))
      return porcentajediscapacidad;
    else if (fieldName.equalsIgnoreCase("tipoidentdiscapacidad"))
      return tipoidentdiscapacidad;
    else if (fieldName.equalsIgnoreCase("numeroidentifdiscapacidad"))
      return numeroidentifdiscapacidad;
    else if (fieldName.equalsIgnoreCase("sueldo"))
      return sueldo;
    else if (fieldName.equalsIgnoreCase("bonos"))
      return bonos;
    else if (fieldName.equalsIgnoreCase("utilidades"))
      return utilidades;
    else if (fieldName.equalsIgnoreCase("impuestorenta"))
      return impuestorenta;
    else if (fieldName.equalsIgnoreCase("decimotercero"))
      return decimotercero;
    else if (fieldName.equalsIgnoreCase("decimocuarto"))
      return decimocuarto;
    else if (fieldName.equalsIgnoreCase("fondosreserva"))
      return fondosreserva;
    else if (fieldName.equalsIgnoreCase("compensacionsalariodigno"))
      return compensacionsalariodigno;
    else if (fieldName.equalsIgnoreCase("otrosing_rentagravada") || fieldName.equals("otrosingRentagravada"))
      return otrosingRentagravada;
    else if (fieldName.equalsIgnoreCase("ingresosgrav349"))
      return ingresosgrav349;
    else if (fieldName.equalsIgnoreCase("sistemasalariodigno"))
      return sistemasalariodigno;
    else if (fieldName.equalsIgnoreCase("aportepersonal"))
      return aportepersonal;
    else if (fieldName.equalsIgnoreCase("impuestorentacausado"))
      return impuestorentacausado;
    else if (fieldName.equalsIgnoreCase("valorimprettrabajador"))
      return valorimprettrabajador;
    else if (fieldName.equalsIgnoreCase("gastosvivienda"))
      return gastosvivienda;
    else if (fieldName.equalsIgnoreCase("gastossalud"))
      return gastossalud;
    else if (fieldName.equalsIgnoreCase("gastoseducacion"))
      return gastoseducacion;
    else if (fieldName.equalsIgnoreCase("gastoalimentacion"))
      return gastoalimentacion;
    else if (fieldName.equalsIgnoreCase("gastosvestimenta"))
      return gastosvestimenta;
    else if (fieldName.equalsIgnoreCase("ingresosgravados"))
      return ingresosgravados;
    else if (fieldName.equalsIgnoreCase("aportepersonalo"))
      return aportepersonalo;
    else if (fieldName.equalsIgnoreCase("exoneracionpordiscapacidad"))
      return exoneracionpordiscapacidad;
    else if (fieldName.equalsIgnoreCase("exoneracionportercerasedad"))
      return exoneracionportercerasedad;
    else if (fieldName.equalsIgnoreCase("valorimpret403"))
      return valorimpret403;
    else if (fieldName.equalsIgnoreCase("valorimpasumido405"))
      return valorimpasumido405;
    else if (fieldName.equalsIgnoreCase("baseimponiblegrav"))
      return baseimponiblegrav;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static Formulary107Data[] select(ConnectionProvider connectionProvider, String cYearID)    throws ServletException {
    return select(connectionProvider, cYearID, 0, 0);
  }

  public static Formulary107Data[] select(ConnectionProvider connectionProvider, String cYearID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    select anio_entrega" +
      ",mes_entrega" +
      ",dia_entrega" +
      ",taxid_org" +
      ",org" +
      ",f107general.year as anio" +
      ",c_year_id" +
      ",taxid_employee" +
      ",empleado" +
      ",tipoidentificacion" +
      ",numeroidentificacion" +
      ",empleadoapellido" +
      ",empleadonombre" +
      ",codigoestab" +
      ",pais" +
      ",codigopais" +
      ",aplicaconvenio" +
      ",discapacitado" +
      ",porcentajediscapacidad" +
      ",tipoidentdiscapacidad" +
      ",numeroidentifdiscapacidad" +
      ",sum(sueldo) as sueldo" +
      ",sum(bonos) as bonos" +
      ",sum(utilidades) as utilidades" +
      ",sum(impuestorenta) as impuestorenta" +
      ",sum(decimotercero) as decimotercero" +
      ",sum(decimocuarto) as decimocuarto" +
      ",sum(fondosreserva) as fondosreserva" +
      ",sum(compensacionsalariodigno) as compensacionsalariodigno" +
      ",sum(otrosing_rentagravada) as otrosing_rentagravada" +
      ",sum( ingresosgrav349) as ingresosgrav349" +
      ",to_number(1) as sistemasalariodigno" +
      ",sum(aportepersonal) as aportepersonal" +
      ",sum(impuestorentacausado) as impuestorentacausado" +
      ",sum(valorimprettrabajador) as valorimprettrabajador" +
      ",sum(gastosvivienda) as gastosvivienda" +
      ",sum(gastossalud) as gastossalud" +
      ",sum(gastoseducacion) as gastoseducacion" +
      ",sum(gastoalimentacion) as gastoalimentacion" +
      ",sum(gastosvestimenta) as gastosvestimenta" +
      ",sum(ingresosgravados) as ingresosgravados" +
      ",sum(aportepersonalo) as aportepersonalo" +
      ",sum(exoneracionpordiscapacidad) as exoneracionpordiscapacidad" +
      ",sum(exoneracionportercerasedad) as exoneracionportercerasedad" +
      ",sum(valorimpret403) as valorimpret403" +
      ",sum(valorimpasumido405) as valorimpasumido405" +
      ",sum(baseimponiblegrav) as baseimponiblegrav     " +
      "from   " +
      "( select sspr_formulary107_detail_v_id" +
      ",anio_entrega" +
      ",mes_entrega" +
      ",to_char(dia_entrega) as dia_entrega" +
      ",taxid_org" +
      ",to_char(org) as org" +
      ",sspr_formulary107_detail_v.year" +
      ",sspr_formulary107_detail_v.c_year_id" +
      ",taxid_employee" +
      ",empleado" +
      ",tipoidentificacion" +
      ",numeroidentificacion" +
      ",empleadoapellido" +
      ",empleadonombre" +
      ",codigoestab" +
      ",pais" +
      ",codigopais" +
      ",aplicaconvenio" +
      ",discapacitado" +
      ",porcentajediscapacidad" +
      ",tipoidentdiscapacidad" +
      ",numeroidentifdiscapacidad" +
      ",trunc(sueldo,4) as sueldo" +
      ",trunc(bonos,4) as bonos" +
      ",trunc(utilidades,4) as utilidades" +
      ",impuestorenta" +
      ",decimotercero,decimocuarto,fondosreserva,compensacionsalariodigno" +
      ",otrosing_rentagravada" +
      ",trunc(sueldo + bonos + utilidades,4) as ingresosgrav349" +
      ",to_number(1) as sistemasalariodigno" +
      ",aportepersonal" +
      ",impuestorentacausado" +
      ",valorimprettrabajador" +
      ",gastosvivienda" +
      ",gastossalud" +
      ",gastoseducacion" +
      ",gastoalimentacion" +
      ",gastosvestimenta" +
      ",ingresosgravados" +
      ",aportepersonalo" +
      ",exoneracionpordiscapacidad" +
      ",exoneracionportercerasedad" +
      ",valorimpret403" +
      ",valorimpasumido405" +
      ",baseimponiblegrav" +
      ",documentno" +
      ",ruccontador      " +
      "from sspr_formulary107_detail_v     " +
      "where sspr_formulary107_detail_v.c_year_id = ?      " +
      "union all    " +
      "select  to_char('') as sspr_formulary107_detail_v_id" +
      ",to_char(now(),'yyyy') as anio_entrega" +
      ",to_char(now(),'mm') as mes_entrega" +
      ",to_char(now(),'dd') as dia_entrega" +
      ",aoi.taxid as taxid_org" +
      ",to_char(ao.name) as org" +
      ",to_char(to_number(c_y.year) +1)  as year" +
      ",? as c_year_id" +
      ",cbp.taxid as taxid_employee" +
      ",cbp.name as empleado" +
      ",to_char(   " +
      "        CASE   " +
      "            WHEN cbp.em_sspr_documenttype = 'NI' THEN 'C'   " +
      "            WHEN cbp.em_sspr_documenttype = 'P' THEN 'P'   " +
      "            WHEN cbp.em_sspr_documenttype = 'SRT' THEN 'E'   " +
      "            ELSE NULL   " +
      "        END) as tipoidentificacion  " +
      ", cbp.em_sspr_documentno as numeroidentificacion   " +
      ", cbp.em_sspr_lastname as empleadoapellido" +
      ",cbp.em_sspr_firstname as empleadonombre" +
      ",se.value AS codigoestab" +
      ", to_char(CASE  " +
      "            WHEN cc.countrycode = 'EC' THEN '01'  " +
      "            ELSE '02'  " +
      "        END) pais" +
      ",cc.em_sspr_coderesidence as codigopais" +
      ",to_char(" +
      "        CASE  " +
      "            WHEN cc.em_sspr_applyagreement = 'Y' THEN 'SI'   " +
      "            ELSE 'NA'  " +
      "        END) AS aplicaconvenio   " +
      ", to_char(" +
      "        CASE  " +
      "            WHEN cbp.em_sspr_isdisabled = 'Y' THEN '02'   " +
      "            ELSE '01'  " +
      "        END) AS discapacitado   " +
      ", coalesce(cbp.em_sspr_disability,'0') AS porcentajediscapacidad   " +
      ", to_char(COALESCE(" +
      "        CASE    " +
      "            WHEN cbp.em_sspr_representsdisabled = 'Y' THEN   " +
      "            CASE   " +
      "                WHEN p.em_sspr_documenttype = 'NI' THEN 'C'   " +
      "                WHEN p.em_sspr_documenttype = 'P' THEN 'P'   " +
      "                WHEN p.em_sspr_documenttype = 'SRT' THEN 'E'  " +
      "                ELSE NULL  " +
      "            END   " +
      "            ELSE NULL   " +
      "        END, 'N')) AS tipoidentdiscapacidad  " +
      ", to_char(COALESCE(" +
      "        CASE " +
      "            WHEN cbp.em_sspr_representsdisabled = 'Y' THEN p.taxid   " +
      "            ELSE NULL   " +
      "        END, '999')) AS numeroidentifdiscapacidad" +
      ",to_number(0) as sueldo" +
      ",to_number(0) as bonos" +
      ",trunc(SU.TOTALPROFITS,4) as utilidades" +
      ",to_number(0) as impuestorenta" +
      ",to_number(0) as decimotercero,to_number(0) as decimocuarto  " +
      ",to_number(0) as fondosreserva,su.Wagecompensation as compensacionsalariodigno  " +
      ",to_number(0) as otrosing_rentagravada" +
      ",to_number(0) as  ingresosgrav349" +
      ",to_number(1) as  sistemasalariodigno" +
      ",to_number(0) as aportepersonal" +
      ",to_number(0) as impuestorentacausado" +
      ",to_number(0) as valorimprettrabajador" +
      ",to_number(0) as gastosvivienda" +
      ",to_number(0) as gastossalud" +
      ",to_number(0) as gastoseducacion" +
      ",to_number(0) as gastoalimentacion" +
      ",to_number(0) as gastosvestimenta" +
      ",to_number(0) as ingresosgravados" +
      ",to_number(0) as aportepersonalo" +
      ",to_number(0) as exoneracionpordiscapacidad" +
      ",to_number(0) as exoneracionportercerasedad" +
      ",to_number(0) as valorimpret403" +
      ",to_number(0) as valorimpasumido405" +
      ",to_number(0) as baseimponiblegrav" +
      ",to_char('') as documentno" +
      ",to_char('') as ruccontador        " +
      "FROM sspr_utilities SU    " +
      "LEFT JOIN C_YEAR C_Y ON C_Y.C_YEAR_ID = SU.C_YEAR_ID    " +
      "LEFT JOIN C_BPARTNER CBP ON CBP.C_BPARTNER_ID = SU.C_BPARTNER_ID     " +
      "LEFT JOIN c_bpartner_location cbpl ON cbpl.c_bpartner_id = cbp.c_bpartner_id AND cbpl.isactive = 'Y'    " +
      "LEFT JOIN c_location cl ON cbpl.c_location_id = cl.c_location_id     " +
      "LEFT JOIN c_country cc ON cl.c_country_id = cc.c_country_id    " +
      "LEFT JOIN sspr_establishmentcode se ON cbp.em_sspr_establishmentcode_id = se.sspr_establishmentcode_id    " +
      "LEFT JOIN c_bpartner p ON cbp.em_sspr_bpartner_disabled_id = p.c_bpartner_id    " +
      "LEFT JOIN ad_org ao ON ao.ad_org_id = su.ad_org_id   " +
      "LEFT JOIN ad_clientinfo y ON ao.ad_client_id = y.ad_client_id    " +
      "LEFT JOIN c_bpartner z ON y.em_sspr_c_bpartner_id = z.c_bpartner_id   " +
      "LEFT JOIN ad_orginfo aoi ON ao.ad_org_id = aoi.ad_org_id   " +
      "WHERE TO_NUMBER(trim(c_y.YEAR)) = (SELECT TO_NUMBER(CY.YEAR)-1  AS ANIO FROM C_YEAR CY WHERE CY.C_YEAR_ID = ?   " +
      ")     " +
      "and su.sspr_codeformulary107_id in ( select sspr_codeformulary107_id from sspr_codeformulary107  where typeconcept = 'UT')   " +
      "and SU.C_BPARTNER_ID is not null   " +
      "order by 10  " +
      ") f107general  " +
      "group by  anio_entrega" +
      ",mes_entrega" +
      ",dia_entrega" +
      ",taxid_org" +
      ",org" +
      ",f107general.year" +
      ",c_year_id" +
      ",taxid_employee" +
      ",empleado" +
      ",tipoidentificacion" +
      ",numeroidentificacion" +
      ",empleadoapellido" +
      ",empleadonombre" +
      ",codigoestab" +
      ",pais" +
      ",codigopais" +
      ",aplicaconvenio" +
      ",discapacitado" +
      ",porcentajediscapacidad" +
      ",tipoidentdiscapacidad" +
      ",numeroidentifdiscapacidad      " +
      "order by  empleado";

    ResultSet result;
    Vector<Formulary107Data> vector = new Vector<Formulary107Data>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cYearID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cYearID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cYearID);

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
        Formulary107Data objectFormulary107Data = new Formulary107Data();
        objectFormulary107Data.anioEntrega = UtilSql.getValue(result, "anio_entrega");
        objectFormulary107Data.mesEntrega = UtilSql.getValue(result, "mes_entrega");
        objectFormulary107Data.diaEntrega = UtilSql.getValue(result, "dia_entrega");
        objectFormulary107Data.taxidOrg = UtilSql.getValue(result, "taxid_org");
        objectFormulary107Data.org = UtilSql.getValue(result, "org");
        objectFormulary107Data.anio = UtilSql.getValue(result, "anio");
        objectFormulary107Data.cYearId = UtilSql.getValue(result, "c_year_id");
        objectFormulary107Data.taxidEmployee = UtilSql.getValue(result, "taxid_employee");
        objectFormulary107Data.empleado = UtilSql.getValue(result, "empleado");
        objectFormulary107Data.tipoidentificacion = UtilSql.getValue(result, "tipoidentificacion");
        objectFormulary107Data.numeroidentificacion = UtilSql.getValue(result, "numeroidentificacion");
        objectFormulary107Data.empleadoapellido = UtilSql.getValue(result, "empleadoapellido");
        objectFormulary107Data.empleadonombre = UtilSql.getValue(result, "empleadonombre");
        objectFormulary107Data.codigoestab = UtilSql.getValue(result, "codigoestab");
        objectFormulary107Data.pais = UtilSql.getValue(result, "pais");
        objectFormulary107Data.codigopais = UtilSql.getValue(result, "codigopais");
        objectFormulary107Data.aplicaconvenio = UtilSql.getValue(result, "aplicaconvenio");
        objectFormulary107Data.discapacitado = UtilSql.getValue(result, "discapacitado");
        objectFormulary107Data.porcentajediscapacidad = UtilSql.getValue(result, "porcentajediscapacidad");
        objectFormulary107Data.tipoidentdiscapacidad = UtilSql.getValue(result, "tipoidentdiscapacidad");
        objectFormulary107Data.numeroidentifdiscapacidad = UtilSql.getValue(result, "numeroidentifdiscapacidad");
        objectFormulary107Data.sueldo = UtilSql.getValue(result, "sueldo");
        objectFormulary107Data.bonos = UtilSql.getValue(result, "bonos");
        objectFormulary107Data.utilidades = UtilSql.getValue(result, "utilidades");
        objectFormulary107Data.impuestorenta = UtilSql.getValue(result, "impuestorenta");
        objectFormulary107Data.decimotercero = UtilSql.getValue(result, "decimotercero");
        objectFormulary107Data.decimocuarto = UtilSql.getValue(result, "decimocuarto");
        objectFormulary107Data.fondosreserva = UtilSql.getValue(result, "fondosreserva");
        objectFormulary107Data.compensacionsalariodigno = UtilSql.getValue(result, "compensacionsalariodigno");
        objectFormulary107Data.otrosingRentagravada = UtilSql.getValue(result, "otrosing_rentagravada");
        objectFormulary107Data.ingresosgrav349 = UtilSql.getValue(result, "ingresosgrav349");
        objectFormulary107Data.sistemasalariodigno = UtilSql.getValue(result, "sistemasalariodigno");
        objectFormulary107Data.aportepersonal = UtilSql.getValue(result, "aportepersonal");
        objectFormulary107Data.impuestorentacausado = UtilSql.getValue(result, "impuestorentacausado");
        objectFormulary107Data.valorimprettrabajador = UtilSql.getValue(result, "valorimprettrabajador");
        objectFormulary107Data.gastosvivienda = UtilSql.getValue(result, "gastosvivienda");
        objectFormulary107Data.gastossalud = UtilSql.getValue(result, "gastossalud");
        objectFormulary107Data.gastoseducacion = UtilSql.getValue(result, "gastoseducacion");
        objectFormulary107Data.gastoalimentacion = UtilSql.getValue(result, "gastoalimentacion");
        objectFormulary107Data.gastosvestimenta = UtilSql.getValue(result, "gastosvestimenta");
        objectFormulary107Data.ingresosgravados = UtilSql.getValue(result, "ingresosgravados");
        objectFormulary107Data.aportepersonalo = UtilSql.getValue(result, "aportepersonalo");
        objectFormulary107Data.exoneracionpordiscapacidad = UtilSql.getValue(result, "exoneracionpordiscapacidad");
        objectFormulary107Data.exoneracionportercerasedad = UtilSql.getValue(result, "exoneracionportercerasedad");
        objectFormulary107Data.valorimpret403 = UtilSql.getValue(result, "valorimpret403");
        objectFormulary107Data.valorimpasumido405 = UtilSql.getValue(result, "valorimpasumido405");
        objectFormulary107Data.baseimponiblegrav = UtilSql.getValue(result, "baseimponiblegrav");
        objectFormulary107Data.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectFormulary107Data);
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
    Formulary107Data objectFormulary107Data[] = new Formulary107Data[vector.size()];
    vector.copyInto(objectFormulary107Data);
    return(objectFormulary107Data);
  }
}
