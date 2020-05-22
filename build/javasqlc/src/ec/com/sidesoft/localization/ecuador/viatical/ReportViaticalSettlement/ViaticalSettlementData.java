//Sqlc generated V1.O00-1
package ec.com.sidesoft.localization.ecuador.viatical.ReportViaticalSettlement;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class ViaticalSettlementData implements FieldProvider {
static Logger log4j = Logger.getLogger(ViaticalSettlementData.class);
  private String InitRecordNumber="0";
  public String adOrgId;
  public String documentno;
  public String leavewithpay;
  public String commissionpeople;
  public String commissionresult;
  public String totaltransportationamt;
  public String additionalfunds;
  public String totalviatexp;
  public String advancedpayment;
  public String diff;
  public String operation;
  public String viaticalDate;
  public String empoyeeName;
  public String positionName;
  public String countryName;
  public String regionName;
  public String cityName;
  public String departmentName;
  public String viatical;
  public String subsistence;
  public String mobilization;
  public String viaticalDepartureDate;
  public String viaticalDepartureTime;
  public String viaticalArrivalDate;
  public String viaticalArrivalTime;
  public String mobilizationDepartureDate;
  public String mobilizationDepartureTime;
  public String mobilizationArrivalDate;
  public String mobilizationArrivalTime;
  public String description;
  public String natidentdoc;
  public String paymentAmount;
  public String totalamt;
  public String bankName;
  public String accountno;
  public String bankaccounttypeName;
  public String transportationType;
  public String trasportationName;
  public String route;
  public String transportationDepartureDate;
  public String transportationDepartureTime;
  public String transportationArrivalDate;
  public String transportationArrivalTime;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("leavewithpay"))
      return leavewithpay;
    else if (fieldName.equalsIgnoreCase("commissionpeople"))
      return commissionpeople;
    else if (fieldName.equalsIgnoreCase("commissionresult"))
      return commissionresult;
    else if (fieldName.equalsIgnoreCase("totaltransportationamt"))
      return totaltransportationamt;
    else if (fieldName.equalsIgnoreCase("additionalfunds"))
      return additionalfunds;
    else if (fieldName.equalsIgnoreCase("totalviatexp"))
      return totalviatexp;
    else if (fieldName.equalsIgnoreCase("advancedpayment"))
      return advancedpayment;
    else if (fieldName.equalsIgnoreCase("diff"))
      return diff;
    else if (fieldName.equalsIgnoreCase("operation"))
      return operation;
    else if (fieldName.equalsIgnoreCase("viatical_date") || fieldName.equals("viaticalDate"))
      return viaticalDate;
    else if (fieldName.equalsIgnoreCase("empoyee_name") || fieldName.equals("empoyeeName"))
      return empoyeeName;
    else if (fieldName.equalsIgnoreCase("position_name") || fieldName.equals("positionName"))
      return positionName;
    else if (fieldName.equalsIgnoreCase("country_name") || fieldName.equals("countryName"))
      return countryName;
    else if (fieldName.equalsIgnoreCase("region_name") || fieldName.equals("regionName"))
      return regionName;
    else if (fieldName.equalsIgnoreCase("city_name") || fieldName.equals("cityName"))
      return cityName;
    else if (fieldName.equalsIgnoreCase("department_name") || fieldName.equals("departmentName"))
      return departmentName;
    else if (fieldName.equalsIgnoreCase("viatical"))
      return viatical;
    else if (fieldName.equalsIgnoreCase("subsistence"))
      return subsistence;
    else if (fieldName.equalsIgnoreCase("mobilization"))
      return mobilization;
    else if (fieldName.equalsIgnoreCase("viatical_departure_date") || fieldName.equals("viaticalDepartureDate"))
      return viaticalDepartureDate;
    else if (fieldName.equalsIgnoreCase("viatical_departure_time") || fieldName.equals("viaticalDepartureTime"))
      return viaticalDepartureTime;
    else if (fieldName.equalsIgnoreCase("viatical_arrival_date") || fieldName.equals("viaticalArrivalDate"))
      return viaticalArrivalDate;
    else if (fieldName.equalsIgnoreCase("viatical_arrival_time") || fieldName.equals("viaticalArrivalTime"))
      return viaticalArrivalTime;
    else if (fieldName.equalsIgnoreCase("mobilization_departure_date") || fieldName.equals("mobilizationDepartureDate"))
      return mobilizationDepartureDate;
    else if (fieldName.equalsIgnoreCase("mobilization_departure_time") || fieldName.equals("mobilizationDepartureTime"))
      return mobilizationDepartureTime;
    else if (fieldName.equalsIgnoreCase("mobilization_arrival_date") || fieldName.equals("mobilizationArrivalDate"))
      return mobilizationArrivalDate;
    else if (fieldName.equalsIgnoreCase("mobilization_arrival_time") || fieldName.equals("mobilizationArrivalTime"))
      return mobilizationArrivalTime;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("natidentdoc"))
      return natidentdoc;
    else if (fieldName.equalsIgnoreCase("payment_amount") || fieldName.equals("paymentAmount"))
      return paymentAmount;
    else if (fieldName.equalsIgnoreCase("totalamt"))
      return totalamt;
    else if (fieldName.equalsIgnoreCase("bank_name") || fieldName.equals("bankName"))
      return bankName;
    else if (fieldName.equalsIgnoreCase("accountno"))
      return accountno;
    else if (fieldName.equalsIgnoreCase("bankaccounttype_name") || fieldName.equals("bankaccounttypeName"))
      return bankaccounttypeName;
    else if (fieldName.equalsIgnoreCase("transportation_type") || fieldName.equals("transportationType"))
      return transportationType;
    else if (fieldName.equalsIgnoreCase("trasportation_name") || fieldName.equals("trasportationName"))
      return trasportationName;
    else if (fieldName.equalsIgnoreCase("route"))
      return route;
    else if (fieldName.equalsIgnoreCase("transportation_departure_date") || fieldName.equals("transportationDepartureDate"))
      return transportationDepartureDate;
    else if (fieldName.equalsIgnoreCase("transportation_departure_time") || fieldName.equals("transportationDepartureTime"))
      return transportationDepartureTime;
    else if (fieldName.equalsIgnoreCase("transportation_arrival_date") || fieldName.equals("transportationArrivalDate"))
      return transportationArrivalDate;
    else if (fieldName.equalsIgnoreCase("transportation_arrival_time") || fieldName.equals("transportationArrivalTime"))
      return transportationArrivalTime;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ViaticalSettlementData[] select(ConnectionProvider connectionProvider, String ssve_viatical_id)    throws ServletException {
    return select(connectionProvider, ssve_viatical_id, 0, 0);
  }

  public static ViaticalSettlementData[] select(ConnectionProvider connectionProvider, String ssve_viatical_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            select  vs.ad_org_id," +
      "                    vs.documentno," +
      "                    vs.leavewithpay," +
      "                    vs.commissionpeople," +
      "                    vs.commissionresult," +
      "                    vs.totaltransportationamt," +
      "                    vs.additionalfunds," +
      "                    vs.totalamt - vs.totaltransportationamt - coalesce(vs.additionalfunds, 0) as totalviatexp," +
      "                    coalesce(fpva.amount, 0) as advancedpayment," +
      "                    coalesce(fpvs.amount, coalesce(vs.totalamt, 0) - coalesce(fpva.amount, 0)) as diff," +
      "                    case" +
      "                      when fpvs.isreceipt = 'Y' then 'RECIBIR'" +
      "                      when fpvs.isreceipt = 'N' then 'DEVOLVER'" +
      "                      when coalesce(vs.totalamt, 0) - coalesce(fpva.amount, 0) > 0 then 'RECIBIR'" +
      "                      when coalesce(vs.totalamt, 0) - coalesce(fpva.amount, 0) < 0 then 'DEVOLVER'" +
      "                      else 'CUADRADO'" +
      "                    end as operation," +
      "                    to_char(vs.viaticaldate, 'dd/MM/yyyy') as viatical_date," +
      "                    bp.name as empoyee_name," +
      "                    pos.name as position_name," +
      "                    coun.name as country_name," +
      "                    reg.name as region_name," +
      "                    cit.name as city_name," +
      "                    dep.name as department_name," +
      "                    (case vs.viaticaltype when 'V' then 'X' else '' end) as viatical," +
      "                    (case vs.viaticaltype when 'S' then 'X' else '' end) as subsistence," +
      "                    (case coalesce(vs.mobilizationamt,0) when 0 then '' else 'X' end) as mobilization," +
      "                    to_char(vs.departuredate, 'dd/MM/yyyy') as viatical_departure_date," +
      "                    to_char(vs.departuretime, 'HH24:MI') as viatical_departure_time," +
      "                    to_char(vs.arrivaldate, 'dd/MM/yyyy') as viatical_arrival_date," +
      "                    to_char(vs.arrivaltime, 'HH24:MI') as viatical_arrival_time," +
      "                    to_char(vs.mobildeparturedate, 'dd/MM/yyyy') as mobilization_departure_date," +
      "                    to_char(vs.mobildeparturetime, 'HH24:MI') as mobilization_departure_time," +
      "                    to_char(vs.mobilarrivaldate, 'dd/MM/yyyy') as mobilization_arrival_date," +
      "                    to_char(vs.mobilarrivaltime, 'HH24:MI') as mobilization_arrival_time," +
      "                    vs.description," +
      "                    vs.natidentdoc," +
      "                    coalesce(fpva.amount, va.totalamt) as payment_amount," +
      "                    vs.totalamt," +
      "                    bt.name as bank_name," +
      "                    ba.accountno," +
      "                    coalesce(reflibatrl.name, refliba.name) as bankaccounttype_name," +
      "                    coalesce(reflitratrl.name, reflitra.name) as transportation_type," +
      "                    tra.name as trasportation_name," +
      "                    tra.route," +
      "                    to_char(tra.departuredate, 'dd/MM/yyyy') as transportation_departure_date," +
      "                    to_char(tra.departuretime, 'HH24:MI') as transportation_departure_time," +
      "                    to_char(tra.arrivaldate, 'dd/MM/yyyy') as transportation_arrival_date," +
      "                    to_char(tra.arrivaltime, 'HH24:MI') as transportation_arrival_time" +
      "            from  ssve_viatical_settlement vs" +
      "            join  c_bpartner bp on bp.c_bpartner_id = vs.c_bpartner_id" +
      "            left join sshr_department dep on dep.sshr_department_id = bp.em_sshr_department_id" +
      "            join  sspr_position pos on vs.sspr_position_id = pos.sspr_position_id" +
      "            left join c_country coun on coun.c_country_id = vs.c_country_id" +
      "            left join c_region reg on reg.c_region_id = vs.c_region_id" +
      "            left join c_city cit on cit.c_city_id = vs.c_city_id" +
      "            left join (" +
      "              ssve_viatsettl_transp tra" +
      "              join ad_ref_list reflitra on reflitra.ad_reference_id = 'AE0B328126634E42BA2FB434B66552F4' and tra.transportationtype = reflitra.value" +
      "              left join ad_ref_list_trl reflitratrl on reflitra.ad_ref_list_id = reflitratrl.ad_ref_list_id and reflitratrl.ad_language = 'es_ES'" +
      "            )on tra.ssve_viatical_settlement_id = vs.ssve_viatical_settlement_id" +
      "            left join ssfi_banktransfer bt on bt.ssfi_banktransfer_id = vs.ssfi_banktransfer_id" +
      "            left join (" +
      "              c_bp_bankaccount ba" +
      "              left join ad_ref_list refliba on refliba.ad_reference_id = '216' and ba.bankaccounttype = refliba.value" +
      "              left join ad_ref_list_trl reflibatrl on refliba.ad_ref_list_id = reflibatrl.ad_ref_list_id and reflibatrl.ad_language = 'es_ES'" +
      "            )on ba.c_bpartner_id = bp.c_bpartner_id and ba.em_sswh_paymentautomatic = 'Y'" +
      "            left join fin_payment fpvs on fpvs.em_ssve_viat_settlement_id = vs.ssve_viatical_settlement_id" +
      "            join ssve_viatical va on va.ssve_viatical_id = vs.ssve_viatical_id" +
      "            left join fin_payment fpva on fpva.em_ssve_viatical_id = vs.ssve_viatical_id" +
      "            where vs.ssve_viatical_settlement_id = ?";

    ResultSet result;
    Vector<ViaticalSettlementData> vector = new Vector<ViaticalSettlementData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ssve_viatical_id);

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
        ViaticalSettlementData objectViaticalSettlementData = new ViaticalSettlementData();
        objectViaticalSettlementData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectViaticalSettlementData.documentno = UtilSql.getValue(result, "documentno");
        objectViaticalSettlementData.leavewithpay = UtilSql.getValue(result, "leavewithpay");
        objectViaticalSettlementData.commissionpeople = UtilSql.getValue(result, "commissionpeople");
        objectViaticalSettlementData.commissionresult = UtilSql.getValue(result, "commissionresult");
        objectViaticalSettlementData.totaltransportationamt = UtilSql.getValue(result, "totaltransportationamt");
        objectViaticalSettlementData.additionalfunds = UtilSql.getValue(result, "additionalfunds");
        objectViaticalSettlementData.totalviatexp = UtilSql.getValue(result, "totalviatexp");
        objectViaticalSettlementData.advancedpayment = UtilSql.getValue(result, "advancedpayment");
        objectViaticalSettlementData.diff = UtilSql.getValue(result, "diff");
        objectViaticalSettlementData.operation = UtilSql.getValue(result, "operation");
        objectViaticalSettlementData.viaticalDate = UtilSql.getValue(result, "viatical_date");
        objectViaticalSettlementData.empoyeeName = UtilSql.getValue(result, "empoyee_name");
        objectViaticalSettlementData.positionName = UtilSql.getValue(result, "position_name");
        objectViaticalSettlementData.countryName = UtilSql.getValue(result, "country_name");
        objectViaticalSettlementData.regionName = UtilSql.getValue(result, "region_name");
        objectViaticalSettlementData.cityName = UtilSql.getValue(result, "city_name");
        objectViaticalSettlementData.departmentName = UtilSql.getValue(result, "department_name");
        objectViaticalSettlementData.viatical = UtilSql.getValue(result, "viatical");
        objectViaticalSettlementData.subsistence = UtilSql.getValue(result, "subsistence");
        objectViaticalSettlementData.mobilization = UtilSql.getValue(result, "mobilization");
        objectViaticalSettlementData.viaticalDepartureDate = UtilSql.getValue(result, "viatical_departure_date");
        objectViaticalSettlementData.viaticalDepartureTime = UtilSql.getValue(result, "viatical_departure_time");
        objectViaticalSettlementData.viaticalArrivalDate = UtilSql.getValue(result, "viatical_arrival_date");
        objectViaticalSettlementData.viaticalArrivalTime = UtilSql.getValue(result, "viatical_arrival_time");
        objectViaticalSettlementData.mobilizationDepartureDate = UtilSql.getValue(result, "mobilization_departure_date");
        objectViaticalSettlementData.mobilizationDepartureTime = UtilSql.getValue(result, "mobilization_departure_time");
        objectViaticalSettlementData.mobilizationArrivalDate = UtilSql.getValue(result, "mobilization_arrival_date");
        objectViaticalSettlementData.mobilizationArrivalTime = UtilSql.getValue(result, "mobilization_arrival_time");
        objectViaticalSettlementData.description = UtilSql.getValue(result, "description");
        objectViaticalSettlementData.natidentdoc = UtilSql.getValue(result, "natidentdoc");
        objectViaticalSettlementData.paymentAmount = UtilSql.getValue(result, "payment_amount");
        objectViaticalSettlementData.totalamt = UtilSql.getValue(result, "totalamt");
        objectViaticalSettlementData.bankName = UtilSql.getValue(result, "bank_name");
        objectViaticalSettlementData.accountno = UtilSql.getValue(result, "accountno");
        objectViaticalSettlementData.bankaccounttypeName = UtilSql.getValue(result, "bankaccounttype_name");
        objectViaticalSettlementData.transportationType = UtilSql.getValue(result, "transportation_type");
        objectViaticalSettlementData.trasportationName = UtilSql.getValue(result, "trasportation_name");
        objectViaticalSettlementData.route = UtilSql.getValue(result, "route");
        objectViaticalSettlementData.transportationDepartureDate = UtilSql.getValue(result, "transportation_departure_date");
        objectViaticalSettlementData.transportationDepartureTime = UtilSql.getValue(result, "transportation_departure_time");
        objectViaticalSettlementData.transportationArrivalDate = UtilSql.getValue(result, "transportation_arrival_date");
        objectViaticalSettlementData.transportationArrivalTime = UtilSql.getValue(result, "transportation_arrival_time");
        objectViaticalSettlementData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectViaticalSettlementData);
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
    ViaticalSettlementData objectViaticalSettlementData[] = new ViaticalSettlementData[vector.size()];
    vector.copyInto(objectViaticalSettlementData);
    return(objectViaticalSettlementData);
  }

  public static ViaticalSettlementData[] set()    throws ServletException {
    ViaticalSettlementData objectViaticalSettlementData[] = new ViaticalSettlementData[1];
    objectViaticalSettlementData[0] = new ViaticalSettlementData();
    objectViaticalSettlementData[0].adOrgId = "";
    objectViaticalSettlementData[0].documentno = "";
    objectViaticalSettlementData[0].leavewithpay = "";
    objectViaticalSettlementData[0].commissionpeople = "";
    objectViaticalSettlementData[0].commissionresult = "";
    objectViaticalSettlementData[0].totaltransportationamt = "";
    objectViaticalSettlementData[0].additionalfunds = "";
    objectViaticalSettlementData[0].totalviatexp = "";
    objectViaticalSettlementData[0].advancedpayment = "";
    objectViaticalSettlementData[0].diff = "";
    objectViaticalSettlementData[0].operation = "";
    objectViaticalSettlementData[0].viaticalDate = "";
    objectViaticalSettlementData[0].empoyeeName = "";
    objectViaticalSettlementData[0].positionName = "";
    objectViaticalSettlementData[0].countryName = "";
    objectViaticalSettlementData[0].regionName = "";
    objectViaticalSettlementData[0].cityName = "";
    objectViaticalSettlementData[0].departmentName = "";
    objectViaticalSettlementData[0].viatical = "";
    objectViaticalSettlementData[0].subsistence = "";
    objectViaticalSettlementData[0].mobilization = "";
    objectViaticalSettlementData[0].viaticalDepartureDate = "";
    objectViaticalSettlementData[0].viaticalDepartureTime = "";
    objectViaticalSettlementData[0].viaticalArrivalDate = "";
    objectViaticalSettlementData[0].viaticalArrivalTime = "";
    objectViaticalSettlementData[0].mobilizationDepartureDate = "";
    objectViaticalSettlementData[0].mobilizationDepartureTime = "";
    objectViaticalSettlementData[0].mobilizationArrivalDate = "";
    objectViaticalSettlementData[0].mobilizationArrivalTime = "";
    objectViaticalSettlementData[0].description = "";
    objectViaticalSettlementData[0].natidentdoc = "";
    objectViaticalSettlementData[0].paymentAmount = "";
    objectViaticalSettlementData[0].totalamt = "";
    objectViaticalSettlementData[0].bankName = "";
    objectViaticalSettlementData[0].accountno = "";
    objectViaticalSettlementData[0].bankaccounttypeName = "";
    objectViaticalSettlementData[0].transportationType = "";
    objectViaticalSettlementData[0].trasportationName = "";
    objectViaticalSettlementData[0].route = "";
    objectViaticalSettlementData[0].transportationDepartureDate = "";
    objectViaticalSettlementData[0].transportationDepartureTime = "";
    objectViaticalSettlementData[0].transportationArrivalDate = "";
    objectViaticalSettlementData[0].transportationArrivalTime = "";
    return objectViaticalSettlementData;
  }
}
