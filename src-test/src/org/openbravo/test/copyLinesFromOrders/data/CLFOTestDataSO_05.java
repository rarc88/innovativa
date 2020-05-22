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
 * All portions are Copyright (C) 2017-2018 Openbravo SLU 
 * All Rights Reserved. 
 * Contributor(s):  ______________________________________.
 ************************************************************************
 */

package org.openbravo.test.copyLinesFromOrders.data;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * Check that created line has as organization: If the Organization of the line that is being copied
 * belongs to the child tree of the Organization of the document header of the new line, use the
 * organization of the line being copied, else use the organization of the document header of the
 * new line.
 * 
 * Case B
 * 
 * @author Mark
 * 
 */
public class CLFOTestDataSO_05 extends CopyLinesFromOrdersTestData {

  private static String TEST_ORDERFROM1_DOCUMENTNO = "CLFOTestData5_OrderFrom1";
  private static String TEST_ORDERTO1_DOCUMENTNO = "CLFOTestData5_OrderTo1";

  @Override
  public void initialize() {

    // Order will be created from
    OrderData orderFrom1 = new OrderData();
    orderFrom1.setSales(true);
    orderFrom1.setPriceIncludingTaxes(false);
    orderFrom1.setDocumentNo(TEST_ORDERFROM1_DOCUMENTNO);
    orderFrom1.setDocumentTypeId(CLFOTestConstants.DOCUMENT_TYPE_STANDARD);
    orderFrom1.setBusinessPartnerId(BPartnerDataConstants.ALIMENTOS_Y_SUPERMERCADOS_ID);
    orderFrom1
        .setBusinessPartnerLocationId(BPartnerDataConstants.ALIMENTOS_Y_SUPERMERCADOS_LOCATION_ID);
    orderFrom1.setPriceListId(CLFOTestConstants.TARIFA_DE_VENTAS_PRICE_LIST_ID);
    orderFrom1.setOrganizationId(CLFOTestConstants.FB_ESPANA_NORTE_ORGANIZATION_ID);
    orderFrom1.setPaymentMethodId(CLFOTestConstants.PAYMENT_METHOD_1_SPAIN);
    orderFrom1.setPaymentTermsId(CLFOTestConstants.PAYMENT_TERMS_30_DAYS);
    orderFrom1.setWarehouseId(CLFOTestConstants.ESPANA_NORTE_WAREHOUSE);
    orderFrom1.setDeliveryDaysCountFromNow(0);
    orderFrom1.setDescription("");
    orderFrom1.setDescription("");
    setOrdersCopiedFrom(new OrderData[] { orderFrom1 });

    // Create lines to that order
    OrderLineData order1Line1 = new OrderLineData();
    order1Line1.setLineNo(10L);
    order1Line1.setBusinessPartnerId(BPartnerDataConstants.ALIMENTOS_Y_SUPERMERCADOS_ID);
    order1Line1
        .setBusinessPartnerLocationId(BPartnerDataConstants.ALIMENTOS_Y_SUPERMERCADOS_LOCATION_ID);
    order1Line1.setOrganizationId(CLFOTestConstants.FB_ESPANA_NORTE_ORGANIZATION_ID);
    order1Line1.setProductId(CLFOTestConstants.CERVEZA_ALE_PRODUCT_ID);
    order1Line1.setUomId(CLFOTestConstants.UNIT_UOM_ID);
    order1Line1.setOrderedQuantity(new BigDecimal("10"));
    order1Line1.setPrice(new BigDecimal("2.04"));
    order1Line1.setTaxId(CLFOTestConstants.ENTREGAS_IVA_21_TAX_ID);
    order1Line1.setWarehouseId(CLFOTestConstants.ESPANA_NORTE_WAREHOUSE);
    order1Line1.setDescription(CLFOTestConstants.LINE1_DESCRIPTION);
    setOrderLinesCopiedFrom(new OrderLineData[][] { new OrderLineData[] { order1Line1 } });

    // Information of the order that will be processed
    OrderData orderToBeProcessed = new OrderData();
    orderToBeProcessed.setSales(true);
    orderToBeProcessed.setPriceIncludingTaxes(false);
    orderToBeProcessed.setDocumentNo(TEST_ORDERTO1_DOCUMENTNO);
    orderToBeProcessed.setDocumentTypeId(CLFOTestConstants.DOCUMENT_TYPE_STANDARD);
    orderToBeProcessed.setBusinessPartnerId(BPartnerDataConstants.ALIMENTOS_Y_SUPERMERCADOS_ID);
    orderToBeProcessed
        .setBusinessPartnerLocationId(BPartnerDataConstants.ALIMENTOS_Y_SUPERMERCADOS_LOCATION_ID);
    orderToBeProcessed.setPriceListId(CLFOTestConstants.TARIFA_DE_VENTAS_PRICE_LIST_ID);
    orderToBeProcessed.setOrganizationId(CLFOTestConstants.FB_ESPANA_ORGANIZATION_ID);
    orderToBeProcessed.setPaymentMethodId(CLFOTestConstants.PAYMENT_METHOD_1_SPAIN);
    orderToBeProcessed.setPaymentTermsId(CLFOTestConstants.PAYMENT_TERMS_30_DAYS);
    orderToBeProcessed.setWarehouseId(CLFOTestConstants.ESPANA_NORTE_WAREHOUSE);
    orderToBeProcessed.setDeliveryDaysCountFromNow(0);
    setOrder(orderToBeProcessed);

    /**
     * This array will be used to verify the Order Header values after the process is executed. Has
     * the following structure: [Total Net Amount expected, Total Gross amount expected]
     */
    setExpectedOrderAmounts(new String[] { "20.40", "24.68" });

    /**
     * This Map will be used to verify the Order Lines values after the process is executed. Map has
     * the following structure: <Line No, [Product Name, Ordered Qty, UOM, Net Unit Price Expected,
     * List Price Expected, Gross Unit Price, Tax, Reference to PO/SO DocumentNo From it was
     * created, BP Address, Organization, Attribute Value, Operative Qty, Operative UOM]>
     */
    HashMap<String, String[]> expectedOrderLines = new HashMap<String, String[]>();
    expectedOrderLines.put("10", new String[] { CLFOTestConstants.CERVEZA_ALE_PRODUCT_NAME, "10",
        CLFOTestConstants.UNIT_UOM_NAME, "2.04", "2.04", "0",
        CLFOTestConstants.ENTREGAS_IVA_21_TAX_NAME, TEST_ORDERFROM1_DOCUMENTNO,
        BPartnerDataConstants.ALIMENTOS_Y_SUPERMERCADOS_LOCATION,
        CLFOTestConstants.FB_ESPANA_NORTE_ORGANIZATION_NAME, "", null, null,
        CLFOTestConstants.LINE1_DESCRIPTION });
    setExpectedOrderLines(expectedOrderLines);
  }

  @Override
  public String getTestNumber() {
    return "05";
  }

  @Override
  public String getTestDescription() {
    return "Check that created line has as organization: If the Organization of the line that is being copied belongs to the child tree of the Organization of the document header of the new line, use the organization of the line being copied, else use the organization of the document header of the new line. - Second Case";
  }

  @Override
  public boolean isExecuteAsQAAdmin() {
    return false;
  }

}