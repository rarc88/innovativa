//Sqlc generated V1.O00-1
package ec.com.sidesoft.localization.ecuador.viatical.ReportViaticalApplication;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class ViaticalApplicationData implements FieldProvider {
static Logger log4j = Logger.getLogger(ViaticalApplicationData.class);
  private String InitRecordNumber="0";
  public String adOrgId;
  public String documentno;
  public String leavewithpay;
  public String commissionpeople;
  public String totalamt;
  public String strtotalamt;
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
  public String feeding;
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
    else if (fieldName.equalsIgnoreCase("totalamt"))
      return totalamt;
    else if (fieldName.equalsIgnoreCase("strtotalamt"))
      return strtotalamt;
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
    else if (fieldName.equalsIgnoreCase("feeding"))
      return feeding;
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

  public static ViaticalApplicationData[] select(ConnectionProvider connectionProvider, String ssve_viatical_id)    throws ServletException {
    return select(connectionProvider, ssve_viatical_id, 0, 0);
  }

  public static ViaticalApplicationData[] select(ConnectionProvider connectionProvider, String ssve_viatical_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            select  va.ad_org_id," +
      "                    va.documentno," +
      "                    va.leavewithpay," +
      "                    va.commissionpeople," +
      "                    va.totalamt," +
      "                    ssve_numbertoletter_es(va.totalamt) as strtotalamt," +
      "                    to_char(va.viaticaldate, 'dd/MM/yyyy') as viatical_date," +
      "                    bp.name as empoyee_name," +
      "                    pos.name as position_name," +
      "                    coun.name as country_name," +
      "                    reg.name as region_name," +
      "                    cit.name as city_name," +
      "                    dep.name as department_name," +
      "                    (case va.viaticaltype when 'V' then 'X' else '' end) as viatical," +
      "                    (case va.viaticaltype when 'S' then 'X' else '' end) as subsistence," +
      "                    (case coalesce(va.mobilizationamt,0) when 0 then '' else 'X' end) as mobilization," +
      "                    (case coalesce(va.feedingamt,0) when 0 then '' else 'X' end) as feeding," +
      "                    to_char(va.departuredate, 'dd/MM/yyyy') as viatical_departure_date," +
      "                    to_char(va.departuretime, 'HH24:MI') as viatical_departure_time," +
      "                    to_char(va.arrivaldate, 'dd/MM/yyyy') as viatical_arrival_date," +
      "                    to_char(va.arrivaltime, 'HH24:MI') as viatical_arrival_time," +
      "                    to_char(va.mobildeparturedate, 'dd/MM/yyyy') as mobilization_departure_date," +
      "                    to_char(va.mobildeparturetime, 'HH24:MI') as mobilization_departure_time," +
      "                    to_char(va.mobilarrivaldate, 'dd/MM/yyyy') as mobilization_arrival_date," +
      "                    to_char(va.mobilarrivaltime, 'HH24:MI') as mobilization_arrival_time," +
      "                    va.description," +
      "                    va.natidentdoc," +
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
      "            from  ssve_viatical va" +
      "            join  c_bpartner bp on bp.c_bpartner_id = va.c_bpartner_id" +
      "            left join sshr_department dep on dep.sshr_department_id = bp.em_sshr_department_id" +
      "            join  sspr_position pos on va.sspr_position_id = pos.sspr_position_id" +
      "            left join c_country coun on coun.c_country_id = va.c_country_id" +
      "            left join c_region reg on reg.c_region_id = va.c_region_id" +
      "            left join c_city cit on cit.c_city_id = va.c_city_id" +
      "            left join (" +
      "              ssve_viatical_transp tra" +
      "              join ad_ref_list reflitra on reflitra.ad_reference_id = 'AE0B328126634E42BA2FB434B66552F4' and tra.transportationtype = reflitra.value" +
      "              left join ad_ref_list_trl reflitratrl on reflitra.ad_ref_list_id = reflitratrl.ad_ref_list_id and reflitratrl.ad_language = 'es_ES'" +
      "            )on tra.ssve_viatical_id = va.ssve_viatical_id" +
      "            left join c_bp_bankaccount ba on ba.c_bpartner_id = bp.c_bpartner_id and ba.em_sswh_paymentautomatic = 'Y'" +
      "            left join ssfi_banktransfer bt on bt.ssfi_banktransfer_id = va.ssfi_banktransfer_id" +
      "            left join ad_ref_list refliba on refliba.ad_reference_id = '216' and va.bankaccounttype = refliba.value" +
      "            left join ad_ref_list_trl reflibatrl on refliba.ad_ref_list_id = reflibatrl.ad_ref_list_id and reflibatrl.ad_language = 'es_ES'" +
      "            where va.ssve_viatical_id = ?";

    ResultSet result;
    Vector<ViaticalApplicationData> vector = new Vector<ViaticalApplicationData>(0);
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
        ViaticalApplicationData objectViaticalApplicationData = new ViaticalApplicationData();
        objectViaticalApplicationData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectViaticalApplicationData.documentno = UtilSql.getValue(result, "documentno");
        objectViaticalApplicationData.leavewithpay = UtilSql.getValue(result, "leavewithpay");
        objectViaticalApplicationData.commissionpeople = UtilSql.getValue(result, "commissionpeople");
        objectViaticalApplicationData.totalamt = UtilSql.getValue(result, "totalamt");
        objectViaticalApplicationData.strtotalamt = UtilSql.getValue(result, "strtotalamt");
        objectViaticalApplicationData.viaticalDate = UtilSql.getValue(result, "viatical_date");
        objectViaticalApplicationData.empoyeeName = UtilSql.getValue(result, "empoyee_name");
        objectViaticalApplicationData.positionName = UtilSql.getValue(result, "position_name");
        objectViaticalApplicationData.countryName = UtilSql.getValue(result, "country_name");
        objectViaticalApplicationData.regionName = UtilSql.getValue(result, "region_name");
        objectViaticalApplicationData.cityName = UtilSql.getValue(result, "city_name");
        objectViaticalApplicationData.departmentName = UtilSql.getValue(result, "department_name");
        objectViaticalApplicationData.viatical = UtilSql.getValue(result, "viatical");
        objectViaticalApplicationData.subsistence = UtilSql.getValue(result, "subsistence");
        objectViaticalApplicationData.mobilization = UtilSql.getValue(result, "mobilization");
        objectViaticalApplicationData.feeding = UtilSql.getValue(result, "feeding");
        objectViaticalApplicationData.viaticalDepartureDate = UtilSql.getValue(result, "viatical_departure_date");
        objectViaticalApplicationData.viaticalDepartureTime = UtilSql.getValue(result, "viatical_departure_time");
        objectViaticalApplicationData.viaticalArrivalDate = UtilSql.getValue(result, "viatical_arrival_date");
        objectViaticalApplicationData.viaticalArrivalTime = UtilSql.getValue(result, "viatical_arrival_time");
        objectViaticalApplicationData.mobilizationDepartureDate = UtilSql.getValue(result, "mobilization_departure_date");
        objectViaticalApplicationData.mobilizationDepartureTime = UtilSql.getValue(result, "mobilization_departure_time");
        objectViaticalApplicationData.mobilizationArrivalDate = UtilSql.getValue(result, "mobilization_arrival_date");
        objectViaticalApplicationData.mobilizationArrivalTime = UtilSql.getValue(result, "mobilization_arrival_time");
        objectViaticalApplicationData.description = UtilSql.getValue(result, "description");
        objectViaticalApplicationData.natidentdoc = UtilSql.getValue(result, "natidentdoc");
        objectViaticalApplicationData.bankName = UtilSql.getValue(result, "bank_name");
        objectViaticalApplicationData.accountno = UtilSql.getValue(result, "accountno");
        objectViaticalApplicationData.bankaccounttypeName = UtilSql.getValue(result, "bankaccounttype_name");
        objectViaticalApplicationData.transportationType = UtilSql.getValue(result, "transportation_type");
        objectViaticalApplicationData.trasportationName = UtilSql.getValue(result, "trasportation_name");
        objectViaticalApplicationData.route = UtilSql.getValue(result, "route");
        objectViaticalApplicationData.transportationDepartureDate = UtilSql.getValue(result, "transportation_departure_date");
        objectViaticalApplicationData.transportationDepartureTime = UtilSql.getValue(result, "transportation_departure_time");
        objectViaticalApplicationData.transportationArrivalDate = UtilSql.getValue(result, "transportation_arrival_date");
        objectViaticalApplicationData.transportationArrivalTime = UtilSql.getValue(result, "transportation_arrival_time");
        objectViaticalApplicationData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectViaticalApplicationData);
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
    ViaticalApplicationData objectViaticalApplicationData[] = new ViaticalApplicationData[vector.size()];
    vector.copyInto(objectViaticalApplicationData);
    return(objectViaticalApplicationData);
  }

  public static ViaticalApplicationData[] set()    throws ServletException {
    ViaticalApplicationData objectViaticalApplicationData[] = new ViaticalApplicationData[1];
    objectViaticalApplicationData[0] = new ViaticalApplicationData();
    objectViaticalApplicationData[0].adOrgId = "";
    objectViaticalApplicationData[0].documentno = "";
    objectViaticalApplicationData[0].leavewithpay = "";
    objectViaticalApplicationData[0].commissionpeople = "";
    objectViaticalApplicationData[0].totalamt = "";
    objectViaticalApplicationData[0].strtotalamt = "";
    objectViaticalApplicationData[0].viaticalDate = "";
    objectViaticalApplicationData[0].empoyeeName = "";
    objectViaticalApplicationData[0].positionName = "";
    objectViaticalApplicationData[0].countryName = "";
    objectViaticalApplicationData[0].regionName = "";
    objectViaticalApplicationData[0].cityName = "";
    objectViaticalApplicationData[0].departmentName = "";
    objectViaticalApplicationData[0].viatical = "";
    objectViaticalApplicationData[0].subsistence = "";
    objectViaticalApplicationData[0].mobilization = "";
    objectViaticalApplicationData[0].feeding = "";
    objectViaticalApplicationData[0].viaticalDepartureDate = "";
    objectViaticalApplicationData[0].viaticalDepartureTime = "";
    objectViaticalApplicationData[0].viaticalArrivalDate = "";
    objectViaticalApplicationData[0].viaticalArrivalTime = "";
    objectViaticalApplicationData[0].mobilizationDepartureDate = "";
    objectViaticalApplicationData[0].mobilizationDepartureTime = "";
    objectViaticalApplicationData[0].mobilizationArrivalDate = "";
    objectViaticalApplicationData[0].mobilizationArrivalTime = "";
    objectViaticalApplicationData[0].description = "";
    objectViaticalApplicationData[0].natidentdoc = "";
    objectViaticalApplicationData[0].bankName = "";
    objectViaticalApplicationData[0].accountno = "";
    objectViaticalApplicationData[0].bankaccounttypeName = "";
    objectViaticalApplicationData[0].transportationType = "";
    objectViaticalApplicationData[0].trasportationName = "";
    objectViaticalApplicationData[0].route = "";
    objectViaticalApplicationData[0].transportationDepartureDate = "";
    objectViaticalApplicationData[0].transportationDepartureTime = "";
    objectViaticalApplicationData[0].transportationArrivalDate = "";
    objectViaticalApplicationData[0].transportationArrivalTime = "";
    return objectViaticalApplicationData;
  }
}
