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

public class UtilitiesCSVData implements FieldProvider {
static Logger log4j = Logger.getLogger(UtilitiesCSVData.class);
  private String InitRecordNumber="0";
  public String cedula;
  public String apellido;
  public String nombre;
  public String genero;
  public String ocupacion;
  public String cargaFamiliar;
  public String diasLaborados;
  public String tipoPagoUtilidad;
  public String jornadaParcial;
  public String horasSemanaJparcial;
  public String discapacitado;
  public String rucEmpresa;
  public String decimoTercero;
  public String decimoCuarto;
  public String participacionUtil;
  public String salarioPercibido;
  public String fondoReserva;
  public String comision;
  public String anticipoUtilidad;
  public String retencionJudicial;
  public String impuestoRetencion;
  public String informacionMdt;
  public String tipoPagoSalario;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("cedula"))
      return cedula;
    else if (fieldName.equalsIgnoreCase("apellido"))
      return apellido;
    else if (fieldName.equalsIgnoreCase("nombre"))
      return nombre;
    else if (fieldName.equalsIgnoreCase("genero"))
      return genero;
    else if (fieldName.equalsIgnoreCase("ocupacion"))
      return ocupacion;
    else if (fieldName.equalsIgnoreCase("carga_familiar") || fieldName.equals("cargaFamiliar"))
      return cargaFamiliar;
    else if (fieldName.equalsIgnoreCase("dias_laborados") || fieldName.equals("diasLaborados"))
      return diasLaborados;
    else if (fieldName.equalsIgnoreCase("tipo_pago_utilidad") || fieldName.equals("tipoPagoUtilidad"))
      return tipoPagoUtilidad;
    else if (fieldName.equalsIgnoreCase("jornada_parcial") || fieldName.equals("jornadaParcial"))
      return jornadaParcial;
    else if (fieldName.equalsIgnoreCase("horas_semana_jparcial") || fieldName.equals("horasSemanaJparcial"))
      return horasSemanaJparcial;
    else if (fieldName.equalsIgnoreCase("discapacitado"))
      return discapacitado;
    else if (fieldName.equalsIgnoreCase("ruc_empresa") || fieldName.equals("rucEmpresa"))
      return rucEmpresa;
    else if (fieldName.equalsIgnoreCase("decimo_tercero") || fieldName.equals("decimoTercero"))
      return decimoTercero;
    else if (fieldName.equalsIgnoreCase("decimo_cuarto") || fieldName.equals("decimoCuarto"))
      return decimoCuarto;
    else if (fieldName.equalsIgnoreCase("participacion_util") || fieldName.equals("participacionUtil"))
      return participacionUtil;
    else if (fieldName.equalsIgnoreCase("salario_percibido") || fieldName.equals("salarioPercibido"))
      return salarioPercibido;
    else if (fieldName.equalsIgnoreCase("fondo_reserva") || fieldName.equals("fondoReserva"))
      return fondoReserva;
    else if (fieldName.equalsIgnoreCase("comision"))
      return comision;
    else if (fieldName.equalsIgnoreCase("anticipo_utilidad") || fieldName.equals("anticipoUtilidad"))
      return anticipoUtilidad;
    else if (fieldName.equalsIgnoreCase("retencion_judicial") || fieldName.equals("retencionJudicial"))
      return retencionJudicial;
    else if (fieldName.equalsIgnoreCase("impuesto_retencion") || fieldName.equals("impuestoRetencion"))
      return impuestoRetencion;
    else if (fieldName.equalsIgnoreCase("informacion_mdt") || fieldName.equals("informacionMdt"))
      return informacionMdt;
    else if (fieldName.equalsIgnoreCase("tipo_pago_salario") || fieldName.equals("tipoPagoSalario"))
      return tipoPagoSalario;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static UtilitiesCSVData[] select(ConnectionProvider connectionProvider, String C_YEAR_ID)    throws ServletException {
    return select(connectionProvider, C_YEAR_ID, 0, 0);
  }

  public static UtilitiesCSVData[] select(ConnectionProvider connectionProvider, String C_YEAR_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select (case EM_SSPR_Documenttype when 'NI' then em_sspr_documentno   " +
      "when 'P' THEN '#UIO' || em_sspr_documentno  " +
      "end) as cedula" +
      ",coalesce(cbp.em_sspr_lastname,'') as apellido " +
      ",coalesce(cbp.em_sspr_firstname,'') as nombre" +
      ",coalesce((case cbp.em_sshr_gender when 'MASCULINO'then 'M' else 'F' end),'') as genero" +
      ",coalesce(cbp.em_sspr_cod_ocupac_iess,'0') as ocupacion" +
      ",cast(coalesce(su.numbercharges,0) as int) as carga_familiar" +
      ",cast(coalesce(dias_laborados,0) as int) as dias_laborados" +
      ",coalesce((case cbp.em_sspr_typeofincome  " +
      "        when 'H' then 'P'   " +
      "        when 'D' then 'A'   " +
      "        when 'MDTD' then 'D'  " +
      "        when 'DPW' then 'RP'  " +
      "        when 'MDTW' then 'RD'  " +
      "        when 'AACW' then 'RA'  " +
      "        end),'') as tipo_pago_utilidad" +
      ",coalesce( to_char(case (select spc.isparttime from sspr_contract spc where spc.isactive='Y' and spc.c_bpartner_id= cbp.c_bpartner_id and spc.created =" +
      "(select max(spc2.created) from sspr_contract spc2 where spc2.isactive='Y' and spc2.c_bpartner_id= cbp.c_bpartner_id ) )" +
      "when 'Y' then 'X'" +
      "else ' '" +
      "end),' ') as jornada_parcial" +
      ",coalesce( (select to_char(spc.weeklyhoursparttime) from sspr_contract spc where spc.isparttime='Y' and spc.isactive='Y' and spc.c_bpartner_id= cbp.c_bpartner_id and spc.created =" +
      "(select max(spc2.created) from sspr_contract spc2 where spc2.isparttime='Y' and spc2.isactive='Y' and spc2.c_bpartner_id= cbp.c_bpartner_id ) )" +
      ",' ') as horas_semana_jparcial        " +
      ",coalesce((case cbp.EM_Sspr_Isdisabled when 'Y' then 'X' else '' end),'') as discapacitado" +
      ",to_char('') as ruc_empresa" +
      ",coalesce(round(coalesce(decimo_tercero,0) + coalesce(liq_dt.importe,0) + coalesce(nom_dt.importe,0) + coalesce(decimo_ter_acum,0),2),0) as decimo_tercero" +
      ",coalesce(round(coalesce(decimo_cuarto,0) + coalesce(liq_dc.importe,0) + coalesce(nom_dc.importe,0) + coalesce(decimo_crt_acum,0),2),0) as decimo_cuarto" +
      ",coalesce(round(part_util.totalprofits,2),0) + coalesce(round(part_uti2.particpia_util2,2),0) as participacion_util" +
      ",coalesce(round(coalesce(salario_percibido,0) + coalesce(liq_sal_per.total_liquid,0),2),0) as salario_percibido" +
      ",coalesce(round(coalesce(fondo_reserva,0)  + coalesce(resv_liq.total_resv,0),2),0) as fondo_reserva" +
      ",coalesce(round(coalesce(comision,0) + coalesce(com_liq.total_liquid_com,0),2),0) as comision" +
      ",to_number(0) as anticipo_utilidad" +
      ",to_number(su.judicial_retention) as retencion_judicial" +
      ",to_number(0) as impuesto_retencion" +
      ",to_char('') as informacion_mdt" +
      ",coalesce((case cbp.em_sspr_typeofincome   " +
      "        when 'H' then 'P'  " +
      "        when 'D' then 'A' " +
      "        when 'MDTD' then 'D'  " +
      "        when 'DPW' then 'RP'  " +
      "        when 'MDTW' then 'RD'  " +
      "        when 'AACW' then 'RA'   " +
      "        end),'')  as tipo_pago_salario   " +
      "  from sspr_utilities su     " +
      "  left join (  " +
      "  select totalprofits,c_bpartner_id from sspr_utilities    " +
      "  where c_year_id = (select c_year_id from c_year where to_number(year) =((select to_number(year) from c_year where c_year_id = ?  ) -1) )  " +
      "  )  part_util on part_util.c_bpartner_id = su.c_bpartner_id    " +
      "  join c_bpartner cbp on cbp.c_bpartner_id = su.c_bpartner_id    " +
      "   join ad_org ao on ao.ad_org_id = su.ad_org_id    " +
      "  join ad_orginfo aoi on aoi.ad_org_id = ao.ad_org_id   " +
      "  left join ( " +
      "select stsl.c_bpartner_id " +
      ",sts.documentno   " +
      ", coalesce(stsl.adjustedamt,0) as decimo_tercero      " +
      "from ssph_tenth_settlement_line stsl   " +
      "  left join ssph_tenth_settlement sts on sts.ssph_tenth_settlement_id=stsl.ssph_tenth_settlement_id   " +
      "  left join c_bpartner bp on bp.c_bpartner_id=stsl.c_bpartner_id   " +
      "  left join c_year pp on pp.c_year_id=sts.c_year_id    " +
      "  left join sspr_labor_regime ssrg on ssrg.sspr_labor_regime_id=sts.sspr_labor_regime_id   " +
      "  left join ad_org og on og.ad_org_id=sts.ad_org_id   " +
      "WHERE sts.c_year_id= ?    " +
      "and sts.typeconcept = '13TH'  " +
      ")  decimot on decimot.c_bpartner_id = su.c_bpartner_id  " +
      "  left join (" +
      "select cbp.c_bpartner_id  " +
      ",cbp.name as tercero  " +
      ",sum(sptc.amount) as importe   " +
      "  from sspr_payroll sp  " +
      "  join sspr_payroll_ticket  spt on sp.sspr_payroll_id = spt.sspr_payroll_id   " +
      "  join sspr_payroll_ticket_concept sptc on sptc.sspr_payroll_ticket_id = spt.sspr_payroll_ticket_id  " +
      "  join sspr_concept sc on sc.sspr_concept_id = sptc.sspr_concept_id  " +
      "  join c_bpartner cbp on cbp.c_bpartner_id = spt.c_bpartner_id  " +
      "  left join sspr_contract sct on sct.c_bpartner_id = cbp.c_bpartner_id  and sct.isactive='Y'" +
      "  left join c_period cp on cp.c_period_id = sp.c_period_id  " +
      "where sc.isiess = 'Y'    and cp.c_year_id = ?      " +
      "and sptc.sspr_concept_id in (select sspr_conceptout_id from sspr_process_payroll   " +
      "   where processname = 'TT')  " +
      "group by cbp.c_bpartner_id    " +
      ",cbp.name ) nom_dt on nom_dt.c_bpartner_id = su.c_bpartner_id   " +
      "   left join (" +
      "select cbp.c_bpartner_id  " +
      ",cbp.name as tercero  " +
      ",sum(ssl.amount) as importe     " +
      "   from sspr_settlement ss   " +
      "   join sspr_settlementline ssl on ss.sspr_settlement_id = ssl.sspr_settlement_id   " +
      "   join c_bpartner cbp on cbp.c_bpartner_id = ss.c_bpartner_id    " +
      "   where to_number(to_char(ss.movementdate,'yyyy')) = (select c_year.year from c_year where c_year_id = ?     " +
      "    )  and ssl.sspr_concept_id in (select sspr_concept_id from sspr_benefit_dismissal where value in ('13TH','13a Remuneración'))    " +
      "  group by cbp.c_bpartner_id,cbp.name  " +
      ") liq_dt on liq_dt.c_bpartner_id = su.c_bpartner_id  " +
      "   left join ( " +
      "select stsl.c_bpartner_id" +
      ",sts.documentno" +
      ", coalesce(stsl.adjustedamt,0) as decimo_cuarto  " +
      "   from ssph_tenth_settlement_line stsl   " +
      "   left join ssph_tenth_settlement sts on sts.ssph_tenth_settlement_id=stsl.ssph_tenth_settlement_id  " +
      "   left join c_bpartner bp on bp.c_bpartner_id=stsl.c_bpartner_id  " +
      "   left join c_year pp on pp.c_year_id=sts.c_year_id  " +
      "   left join sspr_labor_regime ssrg on ssrg.sspr_labor_regime_id=sts.sspr_labor_regime_id  " +
      "   left join ad_org og on og.ad_org_id=sts.ad_org_id  " +
      "  WHERE   sts.c_year_id= ?   " +
      "and sts.typeconcept = '14TH'  " +
      ") decimoc on decimoc.c_bpartner_id = su.c_bpartner_id   " +
      "   left join (  " +
      "select cbp.c_bpartner_id " +
      ",cbp.name as tercero   " +
      ",sum(sptc.amount) as importe    " +
      "  from sspr_payroll sp   " +
      "  join sspr_payroll_ticket  spt on sp.sspr_payroll_id = spt.sspr_payroll_id   " +
      "   join sspr_payroll_ticket_concept sptc on sptc.sspr_payroll_ticket_id = spt.sspr_payroll_ticket_id   " +
      "   join sspr_concept sc on sc.sspr_concept_id = sptc.sspr_concept_id  " +
      "   join c_bpartner cbp on cbp.c_bpartner_id = spt.c_bpartner_id  " +
      "   left join sspr_contract sct on sct.c_bpartner_id = cbp.c_bpartner_id  and sct.isactive='Y'" +
      "   left join c_period cp on cp.c_period_id = sp.c_period_id  " +
      "  where sc.isiess = 'Y'   " +
      "and cp.c_year_id = ?    " +
      "and sptc.sspr_concept_id in (select sspr_conceptout_id from sspr_process_payroll   " +
      "   where processname = 'FT')" +
      "group by cbp.c_bpartner_id  " +
      ",cbp.name ) nom_dc on nom_dc.c_bpartner_id = su.c_bpartner_id   " +
      "  left join (   " +
      "select cbp.c_bpartner_id  " +
      ",cbp.name as tercero  " +
      ",sum(ssl.amount) as importe    " +
      "   from sspr_settlement ss   " +
      "   join sspr_settlementline ssl on ss.sspr_settlement_id = ssl.sspr_settlement_id  " +
      "   join c_bpartner cbp on cbp.c_bpartner_id = ss.c_bpartner_id    " +
      "   where to_number(to_char(ss.movementdate,'yyyy')) = (select c_year.year from c_year where c_year_id = ?      " +
      "    )    and ssl.sspr_concept_id in (select sspr_concept_id from sspr_benefit_dismissal where value in ('14TH','14a Remuneración'))     " +
      "  group by cbp.c_bpartner_id,cbp.name  " +
      " ) liq_dc on liq_dc.c_bpartner_id = su.c_bpartner_id  " +
      "   left join (  " +
      "   select sal_per.c_bpartner_id,(coalesce(salario_percibido,0)) as salario_percibido    " +
      "   from (  " +
      "select cbp.c_bpartner_id  " +
      ",cbp.name as tercero  " +
      ",sum(sptc.amount) as salario_percibido    " +
      "   from sspr_payroll sp  " +
      "   join sspr_payroll_ticket  spt on sp.sspr_payroll_id = spt.sspr_payroll_id  " +
      "   join sspr_payroll_ticket_concept sptc on sptc.sspr_payroll_ticket_id = spt.sspr_payroll_ticket_id  " +
      "   join sspr_concept sc on sc.sspr_concept_id = sptc.sspr_concept_id  " +
      "   join c_bpartner cbp on cbp.c_bpartner_id = spt.c_bpartner_id  " +
      "   left join c_period cp on cp.c_period_id = sp.c_period_id  " +
      "   where sp.ispayroll ='Y' and sp.isliquidation = 'N'  " +
      "and cp.c_year_id = ?    " +
      "and sc.concepttypepayroll='SL'   " +
      "  group by cbp.c_bpartner_id,cbp.name   " +
      "  ) sal_per   " +
      ") salario_per on  salario_per.c_bpartner_id = su.c_bpartner_id    " +
      "     left join ( " +
      "   select  ss.c_bpartner_id,sum(ssl.totalnet) as total_liquid   " +
      "    from sspr_settlement ss   " +
      "    join sspr_settlementline ssl on ss.sspr_settlement_id = ssl.sspr_settlement_id   " +
      "    join sspr_concept sc on sc.sspr_concept_id = ssl.sspr_concept_id    " +
      "    where  sc.concepttypepayroll='SL'   and sc.concepttype='F'    " +
      "    and to_number(to_char(ss.movementdate,'yyyy')) = (select c_year.year from c_year where c_year_id = ?   )   " +
      "    group by ss.c_bpartner_id   " +
      "   ) liq_sal_per on liq_sal_per.c_bpartner_id = su.c_bpartner_id   " +
      "  left join   " +
      "(" +
      "select fres.c_bpartner_id, (coalesce(sum(fondo_reserva),0)) as fondo_reserva     " +
      "    from    (" +
      "    select cbp.c_bpartner_id" +
      "    ,cbp.name as tercero  " +
      "    ,round(sptc.amount,2) as fondo_reserva " +
      "    ,cp.name     " +
      "    ,sp.ispayroll" +
      "    ,sp.isliquidation      " +
      "   from sspr_payroll sp      " +
      "   join sspr_payroll_ticket  spt on sp.sspr_payroll_id = spt.sspr_payroll_id     " +
      "   join sspr_payroll_ticket_concept sptc on sptc.sspr_payroll_ticket_id = spt.sspr_payroll_ticket_id     " +
      "   left join c_bpartner cbp on cbp.c_bpartner_id = spt.c_bpartner_id      " +
      "   join sspr_concept sc on sc.sspr_concept_id = sptc.sspr_concept_id        " +
      "   left join c_period cp on cp.c_period_id = sp.c_period_id     " +
      "   where  cp.c_year_id = ?    " +
      "    and ((sp.ispayroll = 'Y' and sp.isliquidation ='N') or (sp.ispayroll = 'N' and sp.isliquidation ='Y')" +
      "    or (sp.ispayroll = 'N' and sp.isliquidation ='N'))       " +
      "    and sptc.sspr_concept_id in (   " +
      "    select sspr_concept_id from sspr_concept            " +
      "    where sspr_codeformulary107_id in (select sspr_codeformulary107_id from sspr_codeformulary107 where typeconcept = 'RF')" +
      "    )     " +
      "    group by cbp.c_bpartner_id,cbp.name,sptc.amount,cp.name ,sp.ispayroll ,sp.isliquidation           " +
      "    order by 2    " +
      "    ) fres   " +
      "group by fres.c_bpartner_id " +
      ") freserva on freserva.c_bpartner_id  = su.c_bpartner_id   " +
      "   left join (  " +
      "    select ss.c_bpartner_id,sum(ssl.totalnet) as total_resv      " +
      "    from sspr_settlement ss    " +
      "    join c_bpartner cbp on cbp.c_bpartner_id = ss.c_bpartner_id      " +
      "    join sspr_settlementline ssl on ssl.sspr_settlement_id = ss.sspr_settlement_id   " +
      "    where to_number(to_char(ss.movementdate,'yyyy')) = (select c_year.year from c_year where c_year_id = ?      " +
      "    )  " +
      "    and ssl.sspr_concept_id in (" +
      "    select sspr_concept_id from sspr_concept         " +
      "    where sspr_codeformulary107_id in (select sspr_codeformulary107_id from sspr_codeformulary107 where typeconcept = 'RF')" +
      "    )    " +
      "    group by ss.c_bpartner_id        " +
      "    )  resv_liq on resv_liq.c_bpartner_id = su.c_bpartner_id  " +
      "   left join (   " +
      "   select  comis.c_bpartner_id, (coalesce(comision,0)) as comision   " +
      "from  (   " +
      "select cbp.c_bpartner_id    " +
      ",cbp.name as tercero    " +
      ",sum(sptc.amount) as comision    " +
      "   from sspr_payroll sp     " +
      "   join sspr_payroll_ticket  spt on sp.sspr_payroll_id = spt.sspr_payroll_id    " +
      "   join sspr_payroll_ticket_concept sptc on sptc.sspr_payroll_ticket_id = spt.sspr_payroll_ticket_id    " +
      "   join sspr_concept sc on sc.sspr_concept_id = sptc.sspr_concept_id     " +
      "   join c_bpartner cbp on cbp.c_bpartner_id = spt.c_bpartner_id       " +
      "   left join c_period cp on cp.c_period_id = sp.c_period_id    " +
      "   where (sp.ispayroll ='Y' and sp.isliquidation = 'N')   " +
      "and cp.c_year_id = ?     " +
      "and sc.affectationtype='Y'    " +
      "and sc.conceptsubtype='In'    " +
      "and sc.iscumulative ='Y'    " +
      "and sc.isiess = 'Y'   " +
      "and sc.isincomecalculated='Y'  " +
      "and SC.concepttypepayroll <> 'SL'        " +
      "group by cbp.c_bpartner_id,cbp.name   " +
      ") comis     " +
      ") comision on comision.c_bpartner_id  = su.c_bpartner_id   " +
      "left join  " +
      "( " +
      "select   ss.c_bpartner_id,sum(ssl.totalnet) as total_liquid_com     " +
      "from sspr_settlement ss     " +
      "join c_bpartner cbp on cbp.c_bpartner_id = ss.c_bpartner_id     " +
      "join sspr_settlementline ssl on ssl.sspr_settlement_id = ss.sspr_settlement_id       " +
      "where to_number(to_char(ss.movementdate,'yyyy')) = (select c_year.year from c_year where c_year_id = ?     " +
      ")  and ssl.sspr_concept_id in (select sspr_concept_id from sspr_concept where  concepttypepayroll = 'IE' AND iscumulative ='Y'      " +
      "and isiess = 'Y'  and isincomecalculated='Y' and concepttypepayroll <> 'SL')     " +
      "group by ss.c_bpartner_id  " +
      ") com_liq on com_liq.c_bpartner_id = su.c_bpartner_id    " +
      "   left join (   " +
      "select cbp.c_bpartner_id   " +
      ",cbp.name as tercero  " +
      ",sum(spt.workeddays) as dias_laborados    " +
      "    from sspr_payroll sp    " +
      "   join sspr_payroll_ticket  spt on sp.sspr_payroll_id = spt.sspr_payroll_id    " +
      "   join c_bpartner cbp on cbp.c_bpartner_id = spt.c_bpartner_id    " +
      "   left join c_period cp on cp.c_period_id = sp.c_period_id    " +
      "  where  " +
      "(" +
      "(sp.ispayroll ='Y' and sp.isliquidation = 'N') or (sp.ispayroll ='N' and sp.isliquidation = 'Y')  " +
      ")" +
      "  and cp.c_year_id = ?     " +
      " group by cbp.c_bpartner_id,cbp.name     " +
      ") diaslab on diaslab.c_bpartner_id  = su.c_bpartner_id     " +
      "left join" +
      "(" +
      "SELECT  cbp.c_bpartner_id" +
      ",sum(sptc.amount) as decimo_ter_acum   " +
      "from sspr_payroll sp    " +
      "left join sspr_payroll_ticket  spt on sp.sspr_payroll_id = spt.sspr_payroll_id   " +
      "left join sspr_payroll_ticket_concept sptc on sptc.sspr_payroll_ticket_id = spt.sspr_payroll_ticket_id   " +
      "left join sspr_concept sc on sc.sspr_concept_id = sptc.sspr_concept_id   " +
      "left join c_bpartner cbp on cbp.c_bpartner_id = spt.c_bpartner_id    " +
      "left join sspr_contract sct on sct.c_bpartner_id = cbp.c_bpartner_id   and sct.isactive='Y'" +
      "left join c_period cp on cp.c_period_id = sp.c_period_id   " +
      "left join c_year pp on cp.c_year_id = pp.c_year_id   " +
      "left join ad_org ao on ao.ad_org_id = sp.ad_org_id   " +
      "where  sc.sspr_concept_id in ((select sspr_conceptout_id from sspr_process_payroll   " +
      "   where processname = 'TT'))   " +
      "and (sp.ispayroll= 'Y' and sp.isliquidation='N')    " +
      "and cp.c_year_id= ?    " +
      "group by cbp.c_bpartner_id   " +
      ") dec_ter_acum on dec_ter_acum.c_bpartner_id  = su.c_bpartner_id      " +
      "left join " +
      "(" +
      "SELECT  cbp.c_bpartner_id" +
      ",sum(sptc.amount) as decimo_crt_acum    " +
      "from sspr_payroll sp    " +
      "left join sspr_payroll_ticket  spt on sp.sspr_payroll_id = spt.sspr_payroll_id   " +
      "left join sspr_payroll_ticket_concept sptc on sptc.sspr_payroll_ticket_id = spt.sspr_payroll_ticket_id    " +
      "left join sspr_concept sc on sc.sspr_concept_id = sptc.sspr_concept_id   " +
      "left join c_bpartner cbp on cbp.c_bpartner_id = spt.c_bpartner_id   " +
      "left join sspr_contract sct on sct.c_bpartner_id = cbp.c_bpartner_id    and sct.isactive='Y'" +
      "left join c_period cp on cp.c_period_id = sp.c_period_id   " +
      "left join c_year pp on cp.c_year_id = pp.c_year_id   " +
      "left join ad_org ao on ao.ad_org_id = sp.ad_org_id   " +
      "where  sc.sspr_concept_id in ((select sspr_conceptout_id from sspr_process_payroll   " +
      "   where processname = 'FT'))  " +
      "and (sp.ispayroll= 'Y' and sp.isliquidation='N')    " +
      "and cp.c_year_id= ?    " +
      "group by cbp.c_bpartner_id  " +
      ") dec_crt_acum on dec_crt_acum.c_bpartner_id  = su.c_bpartner_id   " +
      "left join (select  cbp.c_bpartner_id    " +
      ",cbp.name as tercero    " +
      ",sum(sptc.amount) as particpia_util2     " +
      "  from sspr_payroll sp   " +
      "  join sspr_payroll_ticket  spt on sp.sspr_payroll_id = spt.sspr_payroll_id     " +
      "  join sspr_payroll_ticket_concept sptc on sptc.sspr_payroll_ticket_id = spt.sspr_payroll_ticket_id   " +
      "  join sspr_concept sc on sc.sspr_concept_id = sptc.sspr_concept_id    " +
      "  join c_bpartner cbp on cbp.c_bpartner_id = spt.c_bpartner_id     " +
      "  left join c_period cp on cp.c_period_id = sp.c_period_id    " +
      "where  cp.c_year_id = ? " +
      "and sptc.sspr_concept_id in (select sspr_concept_id from sspr_concept    " +
      "where Sspr_Codeformulary107_ID in   " +
      "(select Sspr_Codeformulary107_ID from Sspr_Codeformulary107 where typeconcept = 'UT'))  " +
      "group by cbp.c_bpartner_id    " +
      ",cbp.name ) part_uti2 on part_uti2.c_bpartner_id = su.c_bpartner_id   " +
      "where su.c_year_id = ?      " +
      "union all     " +
      "select  coalesce(ssd.taxid_partner,'') as cedula  " +
      ",coalesce(ssd.surname,'') as apellido  " +
      ",coalesce(ssd.name,'') as nombre  " +
      ",coalesce(ssd.gender,'') as genero   " +
      ",coalesce(ssd.occup_code_iess,'0') as ocupacion   " +
      ",cast(coalesce(su.numbercharges,0) as int) as carga_familiar  " +
      ",cast(coalesce(su.workeddays,0) as int) as dias_laborados  " +
      ",coalesce((case ssd.paymenttype     " +
      "        when 'H' then 'P'   " +
      "        when 'D' then 'A'  " +
      "        when 'MDTD' then 'D'    " +
      "        when 'DPW' then 'RP'    " +
      "        when 'MDTW' then 'RD'    " +
      "        when 'AACW' then 'RA'     " +
      "        end),'')  as tipo_pago_salario" +
      "                ,to_char('')  as jornada_parcial" +
      ",to_char(' ') as horas_semana_jparcial       " +
      ", to_char(' ') as discapacitado " +
      ", coalesce(ssd.taxid_company,'') as ruc_empresa" +
      ",to_number(0) as decimo_tercero" +
      ",to_number(0) as decimo_cuarto" +
      ",to_number(0) as participacion_util" +
      ",to_number(0) as salario_percibido" +
      ",to_number(0) as fondo_reserva" +
      ",to_number(0) as comision" +
      ",to_number(0) as anticipo_utilidad" +
      ",to_number(su.judicial_retention) as retencion_judicial " +
      ",to_number(0) as impuesto_retencion" +
      ",to_char('') as informacion_mdt" +
      ",coalesce((case ssd.paymenttype     " +
      "        when 'H' then 'P'    " +
      "        when 'D' then 'A'   " +
      "        when 'MDTD' then 'D'    " +
      "        when 'DPW' then 'RP'    " +
      "        when 'MDTW' then 'RD'    " +
      "        when 'AACW' then 'RA'     " +
      "        end),'')  as tipo_pago_salario     " +
      "from sspr_supplementary_data ssd    " +
      "join sspr_utilities su on su.sspr_supplementary_data_id = ssd.sspr_supplementary_data_id   " +
      "where su.c_year_id =?   " +
      "order by 1 ";

    ResultSet result;
    Vector<UtilitiesCSVData> vector = new Vector<UtilitiesCSVData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_YEAR_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_YEAR_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_YEAR_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_YEAR_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_YEAR_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_YEAR_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_YEAR_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_YEAR_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_YEAR_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_YEAR_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_YEAR_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_YEAR_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_YEAR_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_YEAR_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_YEAR_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_YEAR_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_YEAR_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_YEAR_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_YEAR_ID);

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
        UtilitiesCSVData objectUtilitiesCSVData = new UtilitiesCSVData();
        objectUtilitiesCSVData.cedula = UtilSql.getValue(result, "cedula");
        objectUtilitiesCSVData.apellido = UtilSql.getValue(result, "apellido");
        objectUtilitiesCSVData.nombre = UtilSql.getValue(result, "nombre");
        objectUtilitiesCSVData.genero = UtilSql.getValue(result, "genero");
        objectUtilitiesCSVData.ocupacion = UtilSql.getValue(result, "ocupacion");
        objectUtilitiesCSVData.cargaFamiliar = UtilSql.getValue(result, "carga_familiar");
        objectUtilitiesCSVData.diasLaborados = UtilSql.getValue(result, "dias_laborados");
        objectUtilitiesCSVData.tipoPagoUtilidad = UtilSql.getValue(result, "tipo_pago_utilidad");
        objectUtilitiesCSVData.jornadaParcial = UtilSql.getValue(result, "jornada_parcial");
        objectUtilitiesCSVData.horasSemanaJparcial = UtilSql.getValue(result, "horas_semana_jparcial");
        objectUtilitiesCSVData.discapacitado = UtilSql.getValue(result, "discapacitado");
        objectUtilitiesCSVData.rucEmpresa = UtilSql.getValue(result, "ruc_empresa");
        objectUtilitiesCSVData.decimoTercero = UtilSql.getValue(result, "decimo_tercero");
        objectUtilitiesCSVData.decimoCuarto = UtilSql.getValue(result, "decimo_cuarto");
        objectUtilitiesCSVData.participacionUtil = UtilSql.getValue(result, "participacion_util");
        objectUtilitiesCSVData.salarioPercibido = UtilSql.getValue(result, "salario_percibido");
        objectUtilitiesCSVData.fondoReserva = UtilSql.getValue(result, "fondo_reserva");
        objectUtilitiesCSVData.comision = UtilSql.getValue(result, "comision");
        objectUtilitiesCSVData.anticipoUtilidad = UtilSql.getValue(result, "anticipo_utilidad");
        objectUtilitiesCSVData.retencionJudicial = UtilSql.getValue(result, "retencion_judicial");
        objectUtilitiesCSVData.impuestoRetencion = UtilSql.getValue(result, "impuesto_retencion");
        objectUtilitiesCSVData.informacionMdt = UtilSql.getValue(result, "informacion_mdt");
        objectUtilitiesCSVData.tipoPagoSalario = UtilSql.getValue(result, "tipo_pago_salario");
        objectUtilitiesCSVData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectUtilitiesCSVData);
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
    UtilitiesCSVData objectUtilitiesCSVData[] = new UtilitiesCSVData[vector.size()];
    vector.copyInto(objectUtilitiesCSVData);
    return(objectUtilitiesCSVData);
  }
}
