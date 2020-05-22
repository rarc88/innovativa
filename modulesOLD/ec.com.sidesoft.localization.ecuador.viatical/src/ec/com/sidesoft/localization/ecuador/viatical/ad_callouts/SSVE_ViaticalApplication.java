/*
 *************************************************************************
 * The contents of this file are subject to the Openbravo  Public  License
 * Version  1.1  (the  "License"),  being   the  Mozilla   Public  License
 * Version 1.1  with a permitted attribution clause; you may not  use this
 * file except in compliance with the License. You  may  obtain  a copy of
 * the License at http://www.openbravo.com/legal/license.html
 * Software distributed under the License  is  distributed  on  an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific  language  governing  rights  and  limitations
 * under the License.
 * The Original Code is Openbravo ERP.
 * The Initial Developer of the Original Code is Openbravo SLU
 * All portions are Copyright (C) 2001-2009 Openbravo SLU
 * All Rights Reserved.
 * Contributor(s): Maykel Glez Hdez <mgonzalez@sidesoft.com.ec>.
 ************************************************************************
 */
//package org.openbravo.erpCommon.ad_callouts;
package ec.com.sidesoft.localization.ecuador.viatical.ad_callouts;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;

import org.openbravo.base.session.OBPropertiesProvider;
import org.openbravo.client.kernel.KernelConstants;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;

import ec.com.sidesoft.localization.ecuador.viatical.SSVEViatical;
// classes required to retrieve product category data from the 
// database using the DAL

// the name of the class corresponds to the filename that holds it 
// hence, modules/modules/org.openbravo.howtos/src/org/openbravo/howtos/ad_callouts/ProductConstructSearchKey.java.
// The class must extend SimpleCallout
public class SSVE_ViaticalApplication extends SimpleCallout {

  private static final long serialVersionUID = 1L;

  @Override
  protected void execute(CalloutInfo info) throws ServletException {

    String strViatical = info.getStringParameter("inpssveViaticalId", null);// Viatical

    // Get data from database
    SSVEViatical viaticalApplication = OBDal.getInstance().get(SSVEViatical.class, strViatical);

    // Calculate and inject result
    if (viaticalApplication != null) {
      String leaveWithPay = viaticalApplication.getLeaveWithPay();
      String bPartner = (viaticalApplication.getBusinessPartner() != null) ? viaticalApplication
          .getBusinessPartner().getId() : "";
      String bpCity = (viaticalApplication.getEmployeeCity() != null) ? viaticalApplication
          .getEmployeeCity().getId() : "";
      String bpBank = (viaticalApplication.getSsfiBanktransfer() != null) ? viaticalApplication
          .getSsfiBanktransfer().getId() : "";
      String bpBankAccountType = viaticalApplication.getAccountType();
      String bpPosition = (viaticalApplication.getPosition() != null) ? viaticalApplication
          .getPosition().getId() : "";
      String bpNatIdentDoc = viaticalApplication.getNationalIdentificationDocument();
      String additionalFunds = (viaticalApplication.getAdditionalFunds() != null) ? viaticalApplication
          .getAdditionalFunds().toString() : "";
      String viaticalCity = (viaticalApplication.getCity() != null) ? viaticalApplication.getCity()
          .getId() : "";
      String viaticalCountry = (viaticalApplication.getCountry() != null) ? viaticalApplication
          .getCountry().getId() : "";
      String viaticalRegion = (viaticalApplication.getRegion() != null) ? viaticalApplication
          .getRegion().getId() : "";
      String viaticalCurrency = (viaticalApplication.getCurrency() != null) ? viaticalApplication
          .getCurrency().getId() : "";
      String viaticalType = viaticalApplication.getViaticalType();
      String viaticalDate = (viaticalApplication.getApplicationDate() != null) ? formatDate(viaticalApplication
          .getApplicationDate()) : "";
      String departureDate = (viaticalApplication.getDepartureDate() != null) ? formatDate(viaticalApplication
          .getDepartureDate()) : "";
      String departureTime = (viaticalApplication.getDepartureTime() != null) ? getGMTTime(
          viaticalApplication.getDepartureTime()).toString() : "";
      String arrivalDate = (viaticalApplication.getArrivalDate() != null) ? formatDate(viaticalApplication
          .getArrivalDate()) : "";
      String arrivalTime = (viaticalApplication.getArrivalTime() != null) ? getGMTTime(
          viaticalApplication.getArrivalTime()).toString() : "";
      String mobilDepartureDate = (viaticalApplication.getMobilDepartureDate() != null) ? formatDate(viaticalApplication
          .getMobilDepartureDate()) : "";
      String mobilDepartureTime = (viaticalApplication.getMobilDepartureTime() != null) ? getGMTTime(
          viaticalApplication.getMobilDepartureTime()).toString()
          : "";
      String mobilArrivalDate = (viaticalApplication.getMobilArrivalDate() != null) ? formatDate(viaticalApplication
          .getMobilArrivalDate()) : "";
      String mobilArrivalTime = (viaticalApplication.getMobilArrivalTime() != null) ? getGMTTime(
          viaticalApplication.getMobilArrivalTime()).toString() : "";
      String description = viaticalApplication.getDescription();
      String commissionPeople = viaticalApplication.getCommissionPeople();
      String mobilDescription = viaticalApplication.getMobilizationDescription();
      String mobilCity = (viaticalApplication.getMobilizationCity() != null) ? viaticalApplication
          .getMobilizationCity().getId() : "";
      String transportType = viaticalApplication.getTransportationType();
      String isBased = (viaticalApplication.isBased()) ? "Y" : "N";
      String isNotBudgetable = (viaticalApplication.isNotBudgetable()) ? "Y" : "N";
      String budgetArea = (viaticalApplication.getArea() != null) ? viaticalApplication.getArea()
          .getId() : "";
      String dimension1 = (viaticalApplication.getStDimension() != null) ? viaticalApplication
          .getStDimension().getId() : "";
      String costCenter = (viaticalApplication.getCostCenter() != null) ? viaticalApplication
          .getCostCenter().getId() : "";
      String hashCode = viaticalApplication.getHashCode();
      String budgetCertLine = (viaticalApplication.getCertificateLineForAdditionalValues() != null) ? viaticalApplication
          .getCertificateLineForAdditionalValues().getId() : "";

      // BigDecimal bdResult;

      info.addResult("inpleavewithpay", leaveWithPay);
      info.addResult("inpcBpartnerId", bPartner);
      info.addResult("inpemployeeCityId", bpCity);
      info.addResult("inpssfiBanktransferId", bpBank);
      info.addResult("inpbankaccounttype", bpBankAccountType);
      info.addResult("inpssprPositionId", bpPosition);
      info.addResult("inpnatidentdoc", bpNatIdentDoc);
      info.addResult("inpadditionalfunds", additionalFunds);
      info.addResult("inpcCityId", viaticalCity);
      info.addResult("inpcCountryId", viaticalCountry);
      info.addResult("inpcRegionId", viaticalRegion);
      info.addResult("inpcCurrencyId", viaticalCurrency);
      info.addResult("inpviaticaltype", viaticalType);
      info.addResult("inpviaticaldate", viaticalDate);
      info.addResult("inpdeparturedate", departureDate);
      info.addResult("inpdeparturetime", departureTime);
      info.addResult("inparrivaldate", arrivalDate);
      info.addResult("inparrivaltime", arrivalTime);
      info.addResult("inpmobildeparturedate", mobilDepartureDate);
      info.addResult("inpmobildeparturetime", mobilDepartureTime);
      info.addResult("inpmobilarrivaldate", mobilArrivalDate);
      info.addResult("inpmobilarrivaltime", mobilArrivalTime);
      info.addResult("inpdescription", description);
      info.addResult("inpcommissionpeople", commissionPeople);
      info.addResult("inpmobilizationdescription", mobilDescription);
      info.addResult("inpmobilizationCityId", mobilCity);
      info.addResult("inptransportationtype", transportType);
      info.addResult("inpisbased", isBased);
      info.addResult("isnotbudgetable", isNotBudgetable);
      info.addResult("inpsfbBudgetAreaId", budgetArea);
      info.addResult("inpuser1Id", dimension1);
      info.addResult("inpcCostcenterId", costCenter);
      info.addResult("inphashcode", hashCode);
      info.addResult("inpsfbBudgetCertLineId", budgetCertLine);
    }
  }

  protected Time getGMTTime(Timestamp ts) {

    Calendar calendar = Calendar.getInstance();
    int gmtMillisecondOffset = (calendar.get(Calendar.ZONE_OFFSET) + calendar
        .get(Calendar.DST_OFFSET));

    calendar.setTime(new Time(ts.getTime()));
    calendar.add(Calendar.MILLISECOND, -gmtMillisecondOffset);

    return new Time(calendar.getTime().getTime());
  }

  protected String formatDate(java.util.Date date) {
    return new SimpleDateFormat((String) OBPropertiesProvider.getInstance()
        .getOpenbravoProperties().get(KernelConstants.DATE_FORMAT_PROPERTY)).format(date);
  }
}