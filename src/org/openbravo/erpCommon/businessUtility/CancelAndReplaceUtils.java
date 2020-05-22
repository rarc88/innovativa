/*
 *************************************************************************
 * The contents of this file are subject to the Openbravo  Public  License
 * Version  1.0  (the  "License"),  being   the  Mozilla   Public  License
 * Version 1.1  with a permitted attribution clause; you may not  use this
 * file except in compliance with the License. You  may  obtain  a copy of
 * the License at http://www.openbravo.com/legal/license.html
 * Software distributed under the License  is  distributed  on  an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific  language  governing  rights  and  limitations
 * under the License.
 * The Original Code is Openbravo ERP.
 * The Initial Developer of the Original Code is Openbravo SLU
 * All portions are Copyright (C) 2016-2018 Openbravo SLU
 * All Rights Reserved.
 * Contributor(s):  ______________________________________.
 *************************************************************************
 */
package org.openbravo.erpCommon.businessUtility;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.openbravo.advpaymentmngt.process.FIN_AddPayment;
import org.openbravo.advpaymentmngt.process.FIN_PaymentProcess;
import org.openbravo.advpaymentmngt.utility.FIN_Utility;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.model.Entity;
import org.openbravo.base.model.ModelProvider;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.base.weld.WeldUtils;
import org.openbravo.client.kernel.RequestContext;
import org.openbravo.dal.core.DalUtil;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.core.TriggerHandler;
import org.openbravo.dal.security.OrganizationStructureProvider;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.dal.service.OBQuery;
import org.openbravo.erpCommon.ad_forms.AcctServer;
import org.openbravo.erpCommon.utility.OBDateUtils;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.erpCommon.utility.PropertyException;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.materialmgmt.ReservationUtils;
import org.openbravo.model.ad.access.OrderLineTax;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Locator;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.invoice.InvoiceLine;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.common.order.OrderLine;
import org.openbravo.model.common.order.OrderLineOffer;
import org.openbravo.model.common.order.OrderTax;
import org.openbravo.model.common.order.OrderlineServiceRelation;
import org.openbravo.model.common.plm.AttributeSetInstance;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.financialmgmt.payment.FIN_FinancialAccount;
import org.openbravo.model.financialmgmt.payment.FIN_Payment;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentMethod;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentSchedule;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentScheduleDetail;
import org.openbravo.model.materialmgmt.onhandquantity.Reservation;
import org.openbravo.model.materialmgmt.transaction.MaterialTransaction;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOut;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOutLine;
import org.openbravo.service.db.CallStoredProcedure;
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.service.db.DbUtility;

public class CancelAndReplaceUtils {
  private static Logger log4j = Logger.getLogger(CancelAndReplaceUtils.class);
  private static final BigDecimal NEGATIVE_ONE = new BigDecimal("-1");
  private static final String HYPHENONE = "-1";
  private static final String HYPHEN = "-";
  public static final String CREATE_NETTING_SHIPMENT = "CancelAndReplaceCreateNetShipment";
  public static final String ASSOCIATE_SHIPMENT_TO_REPLACE_TICKET = "CancelAndReplaceAssociateShipmentToNewTicket";
  public static final String ENABLE_STOCK_RESERVATIONS = "StockReservations";
  public static final String REVERSE_PREFIX = "*R*";
  public static final String ZERO_PAYMENT_SUFIX = "*Z*";
  public static final String DOCTYPE_MatShipment = "MMS";
  public static final int PAYMENT_DOCNO_LENGTH = 30;

  private static Map<String, String> linesRelations = new HashMap<>();

  /**
   * Process that creates a replacement order in temporary status in order to Cancel and Replace an
   * original order
   * 
   * @param oldOrder
   *          Order that will be cancelled and replaced
   */
  public static Order createReplacementOrder(Order oldOrder) {
    // Create new Order header
    Order newOrder = (Order) DalUtil.copy(oldOrder, false, true);
    // Change order values
    newOrder.setProcessed(false);
    newOrder.setPosted("N");
    newOrder.setDocumentStatus("TMP");
    newOrder.setDocumentAction("CO");
    newOrder.setGrandTotalAmount(BigDecimal.ZERO);
    newOrder.setSummedLineAmount(BigDecimal.ZERO);
    Date today = new Date();
    newOrder.setOrderDate(today);
    newOrder.setReplacedorder(oldOrder);
    String newDocumentNo = CancelAndReplaceUtils.getNextCancelDocNo(oldOrder.getDocumentNo());
    newOrder.setDocumentNo(newDocumentNo);
    OBDal.getInstance().save(newOrder);

    String newOrderId = newOrder.getId();

    // Create new Order lines
    ScrollableResults orderLines = null;
    long i = 0;
    try {
      orderLines = getOrderLineList(oldOrder);
      while (orderLines.next()) {
        OrderLine oldOrderLine = (OrderLine) orderLines.get(0);
        // Skip discount lines as they will be created when booking the replacement order
        if (oldOrderLine.getOrderDiscount() != null) {
          continue;
        }
        OrderLine newOrderLine = (OrderLine) DalUtil.copy(oldOrderLine, false, true);
        newOrderLine.setDeliveredQuantity(BigDecimal.ZERO);
        newOrderLine.setReservedQuantity(BigDecimal.ZERO);
        newOrderLine.setInvoicedQuantity(BigDecimal.ZERO);
        newOrderLine.setSalesOrder(newOrder);
        newOrderLine.setReplacedorderline(oldOrderLine);
        newOrder.getOrderLineList().add(newOrderLine);
        OBDal.getInstance().save(newOrderLine);
        if ((++i % 100) == 0) {
          OBDal.getInstance().flush();
          OBDal.getInstance().getSession().clear();
          newOrder = OBDal.getInstance().get(Order.class, newOrderId);
        }
      }
    } finally {
      if (orderLines != null) {
        orderLines.close();
      }
    }
    // Flush before updating Relations between Products and services to ensure all the Order Lines
    // have been calculated properly
    OBDal.getInstance().flush();
    updateRelationsBetweenOrderLinesProductsAndServices(newOrder);
    return newOrder;
  }

  /**
   * Update the relationships between the services and products in the new order lines. After all
   * the lines are created, it is needed to update relations taking into account if those relations
   * were present in the lines they are replacing
   * 
   * @param order
   *          The new created order where the lines will be updated
   */
  private static void updateRelationsBetweenOrderLinesProductsAndServices(Order order) {
    ScrollableResults newOrderLines = null;
    try {
      int i = 0;
      newOrderLines = getOrderLinesListWithReplacedLineWithRelatedService(order);
      while (newOrderLines.next()) {
        updateOrderLineRelatedServices((OrderLine) newOrderLines.get(0));

        if ((++i % 100) == 0) {
          OBDal.getInstance().flush();
          OBDal.getInstance().getSession().clear();
        }
      }
    } finally {
      if (newOrderLines != null) {
        newOrderLines.close();
      }
    }
  }

  private static ScrollableResults getOrderLinesListWithReplacedLineWithRelatedService(Order order) {
    StringBuilder hql = new StringBuilder("");
    hql.append(" select ol ");
    hql.append(" from OrderLine ol");
    hql.append(" join ol.replacedorderline rol "); // Explicit join to avoid null values
    hql.append(" where rol.orderlineServiceRelationList is not empty");
    hql.append(" and ol.salesOrder.id = :orderId");

    Query query = OBDal.getInstance().getSession().createQuery(hql.toString());
    query.setParameter("orderId", order.getId());
    return query.scroll(ScrollMode.FORWARD_ONLY);
  }

  private static void updateOrderLineRelatedServices(OrderLine orderLine) {
    Order order = orderLine.getSalesOrder();
    OrderLine replacedOrderLine = orderLine.getReplacedorderline();
    List<OrderlineServiceRelation> replacedRelatedServices = replacedOrderLine
        .getOrderlineServiceRelationList();
    for (OrderlineServiceRelation replacedRelatedService : replacedRelatedServices) {
      OrderLine replacedRelatedOrderLine = replacedRelatedService.getOrderlineRelated();
      OrderLine orderLineReplacingRelatedOrderLine = getOrderLineReplacingRelatedOrderLine(order,
          replacedRelatedOrderLine);
      addNewOrderLineServiceRelation(orderLine, orderLineReplacingRelatedOrderLine);
    }
  }

  /**
   * Method returns the order line of an order that is replacing an specific order line
   * 
   * @param order
   *          The order where the order line will be searched
   * @param replacedOrderLine
   *          The replaced order line that is searching for
   * @return The order line that is replacing the one passed as parameter
   */
  private static OrderLine getOrderLineReplacingRelatedOrderLine(Order order,
      OrderLine replacedOrderLine) {
    OBCriteria<OrderLine> orderLinesCriteria = OBDal.getInstance().createCriteria(OrderLine.class);
    orderLinesCriteria.add(Restrictions.eq(OrderLine.PROPERTY_SALESORDER, order));
    orderLinesCriteria
        .add(Restrictions.eq(OrderLine.PROPERTY_REPLACEDORDERLINE, replacedOrderLine));
    orderLinesCriteria.setMaxResults(1);

    return (OrderLine) orderLinesCriteria.uniqueResult();
  }

  private static void addNewOrderLineServiceRelation(OrderLine orderLine, OrderLine orderLineRelated) {
    OrderlineServiceRelation newOrderLineServiceRelation = getNewOrderLineServiceRelation(
        orderLine, orderLineRelated);
    orderLine.getOrderlineServiceRelationList().add(newOrderLineServiceRelation);
  }

  private static OrderlineServiceRelation getNewOrderLineServiceRelation(OrderLine orderLine,
      OrderLine orderLineRelated) {
    OrderlineServiceRelation newOrderLineServiceRelation = OBProvider.getInstance().get(
        OrderlineServiceRelation.class);
    newOrderLineServiceRelation.setClient(orderLine.getClient());
    newOrderLineServiceRelation.setOrganization(orderLine.getOrganization());
    newOrderLineServiceRelation.setAmount(orderLine.getLineGrossAmount());
    newOrderLineServiceRelation.setOrderlineRelated(orderLineRelated);
    newOrderLineServiceRelation.setQuantity(orderLine.getOrderedQuantity());
    newOrderLineServiceRelation.setSalesOrderLine(orderLine);
    OBDal.getInstance().save(newOrderLineServiceRelation);
    return newOrderLineServiceRelation;
  }

  /**
   * Method that given an Order Id it cancels it and creates another one equal but with negative
   * quantities.
   * 
   * @param newOrderId
   *          Id of the Sales Order to be cancelled.
   * @param jsonorder
   *          Parameter with order information coming from Web POS.
   * @param useOrderDocumentNoForRelatedDocs
   *          flag coming from Web POS. If it is true, it will set the same document of the order to
   *          netting payment.
   */
  public static Order cancelOrder(String newOrderId, JSONObject jsonorder,
      boolean useOrderDocumentNoForRelatedDocs) {
    return cancelAndReplaceOrder(newOrderId, jsonorder, useOrderDocumentNoForRelatedDocs, false);
  }

  /**
   * * Method that given an Order Id it cancels it and creates another one equal but with negative
   * quantities. It also creates a new order replacing the cancelled one.
   * 
   * @param newOrderId
   *          Id of the Sales Order to be cancelled.
   * @param jsonorder
   *          Parameter with order information coming from Web POS
   * @param useOrderDocumentNoForRelatedDocs
   *          . flag coming from Web POS. If it is true, it will set the same document of the order
   *          to netting payment.
   */
  public static Order cancelAndReplaceOrder(String newOrderId, JSONObject jsonorder,
      boolean useOrderDocumentNoForRelatedDocs) {
    return cancelAndReplaceOrder(newOrderId, jsonorder, useOrderDocumentNoForRelatedDocs, true);
  }

  /**
   * Process that cancels an existing order and creates another one inverse of the original. If it
   * is indicated a new order is created with received modifications that replaces the original one.
   * 
   * This process will create a netting goods shipment to leave the original order and the inverse
   * order completely delivered, and if anything is delivered was delivered in the original order it
   * will be delivered so in the new one.
   * 
   * The same behavior of shipments will be implemented with payments.
   * 
   * @param orderId
   *          Order Id of the new order or of the old order, depending on replaceOrder boolean.
   * @param jsonorder
   *          JSON Object of the order coming from Web POS
   * @param useOrderDocumentNoForRelatedDocs
   *          OBPOS_UseOrderDocumentNoForRelatedDocs preference from Web POS.
   * @param replaceOrder
   *          If replaceOrder == true, the original order will be cancelled and replaced with a new
   *          one, if == false, it will only be cancelled
   */
  private static Order cancelAndReplaceOrder(String orderId, JSONObject jsonorder,
      boolean useOrderDocumentNoForRelatedDocs, boolean replaceOrder) {
    ScrollableResults orderLines = null;
    ScrollableResults shipmentLines = null;
    Order newOrder = null;
    Order oldOrder = null;
    String newOrderId = null;
    String oldOrderId = null;
    String inverseOrderId = null;
    OBContext.setAdminMode(false);
    try {

      boolean triggersDisabled = false;
      if (jsonorder != null && replaceOrder) {
        triggersDisabled = true;
      }

      // If replaceOrder == true, the original order will be cancelled and replaced with a new one,
      // if == false, it will only be cancelled
      if (replaceOrder) {
        // Get new Order
        newOrder = OBDal.getInstance().get(Order.class, orderId);
        newOrderId = newOrder.getId();
        // Get old Order
        oldOrder = newOrder.getReplacedorder();
        oldOrderId = oldOrder.getId();
      } else {
        // Get old Order
        oldOrder = OBDal.getInstance().get(Order.class, orderId);
        oldOrderId = oldOrder.getId();
      }
      oldOrder = lockOrder(oldOrder);

      // Added check in case Cancel and Replace button is hit more than once
      if (oldOrder.isCancelled()) {
        throw new OBException(String.format(OBMessageUtils.messageBD("IsCancelled"),
            oldOrder.getDocumentNo()));
      }
      // Close old reservations
      closeOldReservations(oldOrder);

      // Refresh documents
      if (newOrderId != null) {
        newOrder = OBDal.getInstance().get(Order.class, newOrderId);
      }

      oldOrder = OBDal.getInstance().get(Order.class, oldOrderId);

      // Get documentNo for the inverse Order Header coming from jsonorder, if exists
      String negativeDocNo = jsonorder != null && jsonorder.has("negativeDocNo") ? jsonorder
          .getString("negativeDocNo") : null;

      // Create inverse Order header
      Order inverseOrder = createInverseOrder(oldOrder, negativeDocNo, triggersDisabled);
      inverseOrderId = inverseOrder.getId();

      // Define netting goods shipment and its lines
      ShipmentInOut nettingGoodsShipment = null;
      String nettingGoodsShipmentId = null;

      // Get preferences values
      boolean createNettingGoodsShipment = getCreateNettingGoodsShipmentPreferenceValue(oldOrder);
      boolean associateShipmentToNewReceipt = getAssociateGoodsShipmentToNewSalesOrderPreferenceValue(oldOrder);

      // Iterate old order lines
      orderLines = getOrderLineList(oldOrder);
      long lineNoCounter = 1, i = 0;
      while (orderLines.next()) {
        OrderLine oldOrderLine = (OrderLine) orderLines.get(0);

        // Create inverse Order line
        OrderLine inverseOrderLine = createInverseOrderLine(oldOrderLine, inverseOrder,
            replaceOrder, triggersDisabled);

        // Netting goods shipment is created
        if (createNettingGoodsShipment && inverseOrderLine != null) {
          // Create Netting goods shipment Header
          if (nettingGoodsShipment == null) {
            nettingGoodsShipment = createNettingGoodShipmentHeader(oldOrder);
            nettingGoodsShipment.setNettingshipment(true);
            nettingGoodsShipmentId = nettingGoodsShipment.getId();
          }

          // Create Netting goods shipment Line for the old order line
          BigDecimal movementQty = oldOrderLine.getOrderedQuantity().subtract(
              oldOrderLine.getDeliveredQuantity());
          BigDecimal oldOrderLineDeliveredQty = oldOrderLine.getDeliveredQuantity();
          oldOrderLine.setDeliveredQuantity(BigDecimal.ZERO);
          OBDal.getInstance().save(oldOrderLine);
          OBDal.getInstance().flush();
          if (movementQty.compareTo(BigDecimal.ZERO) != 0) {
            createNettingShipmentLine(nettingGoodsShipment, oldOrderLine, lineNoCounter++,
                movementQty, triggersDisabled);
          }
          // Create Netting goods shipment Line for the inverse order line
          movementQty = inverseOrderLine.getOrderedQuantity().subtract(
              inverseOrderLine.getDeliveredQuantity());
          if (movementQty.compareTo(BigDecimal.ZERO) != 0) {
            createNettingShipmentLine(nettingGoodsShipment, inverseOrderLine, lineNoCounter++,
                movementQty, triggersDisabled);
          }

          if (replaceOrder) {
            // Get the the new order line that replaces the old order line, should be only one
            OrderLine newOrderLine = getReplacementOrderLine(newOrder, oldOrderLine);
            if (newOrderLine != null) {
              ShipmentInOutLine newGoodsShipmentLine = null;
              // Create Netting goods shipment Line for the new order line
              movementQty = oldOrderLineDeliveredQty;
              BigDecimal newOrderLineDeliveredQty = newOrderLine.getDeliveredQuantity();
              newOrderLine.setDeliveredQuantity(BigDecimal.ZERO);
              OBDal.getInstance().save(newOrderLine);
              OBDal.getInstance().flush();
              if (movementQty.compareTo(BigDecimal.ZERO) != 0) {
                newGoodsShipmentLine = createNettingShipmentLine(nettingGoodsShipment,
                    newOrderLine, lineNoCounter++, movementQty, triggersDisabled);
              }
              if (newOrderLineDeliveredQty == null
                  || newOrderLineDeliveredQty.compareTo(BigDecimal.ZERO) == 0) {
                // Set new order line delivered quantity to old order line ordered quantity, this
                // case coming from Backend (nothing is delivered)
                newOrderLine.setDeliveredQuantity(movementQty);
              } else {
                // Set new order line delivered quantity to previous delivery quantity, this case
                // coming from Web POS (everything is delivered)
                newOrderLine.setDeliveredQuantity(newOrderLineDeliveredQty);
              }
              OBDal.getInstance().save(newOrderLine);
              if (jsonorder != null && newGoodsShipmentLine != null) {
                // Associate the new shipment line to the new invoice line (if exists)
                final InvoiceLine newInvoiceLine = getNewInvoiceLine(newOrderLine);
                if (newInvoiceLine != null) {
                  newInvoiceLine.setGoodsShipmentLine(newGoodsShipmentLine);
                  OBDal.getInstance().save(newInvoiceLine);
                }
              }
            }
          }
          // Shipment lines of original order lines are reassigned to the new order line
        } else if (associateShipmentToNewReceipt && replaceOrder) {
          try {
            shipmentLines = getShipmentLineListOfOrderLine(oldOrderLine);
            long k = 0;
            List<ShipmentInOut> shipments = new ArrayList<ShipmentInOut>();
            List<ShipmentInOutLine> shipLines = new ArrayList<ShipmentInOutLine>();
            while (shipmentLines.next()) {
              ShipmentInOutLine shipLine = (ShipmentInOutLine) shipmentLines.get(0);
              // The netting shipment is flagged as unprocessed.
              ShipmentInOut shipment = shipLine.getShipmentReceipt();
              if (shipment.isProcessed()) {
                unprocessShipmentHeader(shipment);
                shipments.add(shipment);
              }
              // Get the the new order line that replaces the old order line, should be only one
              OrderLine newOrderLine = getReplacementOrderLine(newOrder, oldOrderLine);
              if (newOrderLine != null) {
                shipLine.setSalesOrderLine(newOrderLine);
                if (jsonorder == null) {
                  newOrderLine.setDeliveredQuantity(newOrderLine.getDeliveredQuantity().add(
                      shipLine.getMovementQuantity()));
                  OBDal.getInstance().save(newOrderLine);
                }
                OBDal.getInstance().save(shipLine);
                // The old invoice line cannot have a relation to the shipment line. Later, after
                // the shipments are created, the invoice will be created for the new order (if
                // required).
                final OBCriteria<InvoiceLine> oldInvoiceLineCriteria = OBDal.getInstance()
                    .createCriteria(InvoiceLine.class);
                oldInvoiceLineCriteria.add(Restrictions.eq(InvoiceLine.PROPERTY_SALESORDERLINE,
                    oldOrderLine));
                oldInvoiceLineCriteria.add(Restrictions.eq(InvoiceLine.PROPERTY_GOODSSHIPMENTLINE,
                    shipLine));
                oldInvoiceLineCriteria.setMaxResults(1);
                final InvoiceLine oldInvoiceLine = (InvoiceLine) oldInvoiceLineCriteria
                    .uniqueResult();
                if (oldInvoiceLine != null) {
                  oldInvoiceLine.setGoodsShipmentLine(null);
                  OBDal.getInstance().save(oldInvoiceLine);
                }
              }
              shipLines.add(shipLine);
              if ((++k % 100) == 0) {
                OBDal.getInstance().flush();
                for (ShipmentInOutLine shipLineToRemove : shipLines) {
                  OBDal.getInstance().getSession().evict(shipLineToRemove);
                }
                shipLines.clear();
              }
            }
            OBDal.getInstance().flush();
            // The netting shipment is flagged as processed.
            for (ShipmentInOut ship : shipments) {
              OBDal.getInstance().refresh(ship);
              processShipmentHeader(ship);
            }
          } finally {
            if (shipmentLines != null) {
              shipmentLines.close();
            }
          }
          // Netting shipment is not created and original shipment lines are not associated to the
          // new order line. Set delivered quantity of the new order line to same as original order
          // line. Do this only in backend workflow, as everything is always delivered in Web POS
        } else if (jsonorder == null) {
          // Get the the new order line that replaces the old order line, should be only one
          OrderLine newOrderLine = getReplacementOrderLine(newOrder, oldOrderLine);
          if (newOrderLine != null) {
            newOrderLine.setDeliveredQuantity(oldOrderLine.getDeliveredQuantity());
          }
        }

        // Set old order delivered quantity to the ordered quantity
        oldOrderLine.setDeliveredQuantity(oldOrderLine.getOrderedQuantity());
        OBDal.getInstance().save(oldOrderLine);

        // Set inverse order delivered quantity to ordered quantity
        if (inverseOrderLine != null) {
          inverseOrderLine.setDeliveredQuantity(inverseOrderLine.getOrderedQuantity());
          OBDal.getInstance().save(inverseOrderLine);
        }
        if ((++i % 100) == 0) {
          OBDal.getInstance().flush();
          OBDal.getInstance().getSession().clear();

          // Refresh documents
          if (nettingGoodsShipmentId != null) {
            nettingGoodsShipment = OBDal.getInstance().get(ShipmentInOut.class,
                nettingGoodsShipmentId);
          }
          if (replaceOrder) {
            newOrder = OBDal.getInstance().get(Order.class, newOrderId);
          }
          oldOrder = OBDal.getInstance().get(Order.class, oldOrderId);
          inverseOrder = OBDal.getInstance().get(Order.class, inverseOrderId);
        }
      }
      // Create or update the needed services relations
      updateServicesRelations(jsonorder, oldOrder, inverseOrder, newOrder, replaceOrder);
      // The netting shipment is flaged as processed.
      if (nettingGoodsShipment != null) {
        processShipmentHeader(nettingGoodsShipment);
      }
      if (!triggersDisabled) {
        callCOrderTaxAdjustment(inverseOrder);
      }

      // Close inverse order
      inverseOrder.setDocumentStatus("CL");
      inverseOrder.setDocumentAction("--");
      inverseOrder.setCancelled(true);
      inverseOrder.setProcessed(true);
      inverseOrder.setProcessNow(false);
      OBDal.getInstance().save(inverseOrder);

      // Close original order
      oldOrder.setDocumentStatus("CL");
      oldOrder.setDocumentAction("--");
      oldOrder.setReplacementorder(newOrder);
      oldOrder.setCancelled(true);
      oldOrder.setProcessed(true);
      oldOrder.setProcessNow(false);
      OBDal.getInstance().save(oldOrder);

      // Complete new order and generate good shipment and sales invoice
      if (!triggersDisabled && replaceOrder) {
        newOrder.setDocumentStatus("DR");
        OBDal.getInstance().save(newOrder);
        callCOrderPost(newOrder);
      }

      // Only create new reservations for new orders if coming from Web POS. For backend workflow it
      // will attend to Order Line Reservation field.
      if (newOrder != null && jsonorder != null) {
        // Create new reservations
        createNewReservations(newOrder);
      }

      // Refresh documents
      if (nettingGoodsShipmentId != null) {
        nettingGoodsShipment = OBDal.getInstance().get(ShipmentInOut.class, nettingGoodsShipmentId);
      }
      if (replaceOrder) {
        newOrder = OBDal.getInstance().get(Order.class, newOrderId);
      }
      oldOrder = OBDal.getInstance().get(Order.class, oldOrderId);
      inverseOrder = OBDal.getInstance().get(Order.class, inverseOrderId);

      // Payment Creation only to orders with grand total different than ZERO
      // Get the payment schedule detail of the oldOrder
      if (oldOrder.getGrandTotalAmount().compareTo(BigDecimal.ZERO) != 0) {
        createPayments(oldOrder, newOrder, inverseOrder, jsonorder,
            useOrderDocumentNoForRelatedDocs, replaceOrder, triggersDisabled);
      }

      // Calling Cancelandreplaceorderhook
      WeldUtils.getInstanceFromStaticBeanManager(CancelAndReplaceOrderHookCaller.class)
          .executeHook(replaceOrder, triggersDisabled, oldOrder, newOrder, inverseOrder, jsonorder);

    } catch (Exception e1) {
      Throwable e2 = DbUtility.getUnderlyingSQLException(e1);
      log4j.error("Error executing Cancel and Replace", e1);
      throw new OBException(e2.getMessage());
    } finally {
      if (orderLines != null) {
        orderLines.close();
      }
      OBContext.restorePreviousMode();
    }
    return newOrder;
  }

  private static void callCOrderPost(Order order) throws OBException {
    final List<Object> parameters = new ArrayList<Object>();
    parameters.add(null);
    parameters.add(order.getId());
    final String procedureName = "c_order_post1";
    CallStoredProcedure.getInstance().call(procedureName, parameters, null, true, false);
  }

  private static void callCOrderTaxAdjustment(Order order) throws OBException {
    final List<Object> parameters = new ArrayList<Object>();
    parameters.add(order.getId());
    parameters.add(2);
    parameters.add("CO");
    final String procedureName = "C_ORDERTAX_ADJUSTMENT";
    CallStoredProcedure.getInstance().call(procedureName, parameters, null, true, false);
  }

  private static Order createInverseOrder(Order oldOrder, String documentNo,
      boolean triggersDisabled) throws JSONException, ParseException {
    Order inverseOrder = (Order) DalUtil.copy(oldOrder, false, true);
    // Change order values
    inverseOrder.setCreatedBy(OBContext.getOBContext().getUser());
    inverseOrder.setPosted("N");
    inverseOrder.setProcessed(false);
    inverseOrder.setDocumentStatus("DR");
    inverseOrder.setDocumentAction("CO");
    if (triggersDisabled) {
      inverseOrder.setGrandTotalAmount(oldOrder.getGrandTotalAmount().negate());
      inverseOrder.setSummedLineAmount(oldOrder.getSummedLineAmount().negate());
    } else {
      inverseOrder.setGrandTotalAmount(BigDecimal.ZERO);
      inverseOrder.setSummedLineAmount(BigDecimal.ZERO);
    }

    Date today = new Date();
    inverseOrder.setOrderDate(OBDateUtils.getDate(OBDateUtils.formatDate(today)));
    inverseOrder.setCreationDate(today);
    inverseOrder.setUpdated(today);
    inverseOrder.setScheduledDeliveryDate(today);
    String newDocumentNo = documentNo;
    if (newDocumentNo == null) {
      newDocumentNo = oldOrder.getDocumentNo() + REVERSE_PREFIX;
    }
    inverseOrder.setDocumentNo(newDocumentNo);
    inverseOrder.setCancelledorder(oldOrder);
    OBDal.getInstance().save(inverseOrder);

    // Copy old order taxes to inverse, it is done when is executed from Web POS because triggers
    // are disabled
    if (triggersDisabled) {
      createInverseOrderTaxes(oldOrder, inverseOrder);
    }

    return inverseOrder;
  }

  private static void createInverseOrderTaxes(Order oldOrder, Order inverseOrder) {
    for (OrderTax orderTax : oldOrder.getOrderTaxList()) {
      OrderTax inverseOrderTax = (OrderTax) DalUtil.copy(orderTax, false, true);
      BigDecimal inverseTaxAmount = orderTax.getTaxAmount().negate();
      BigDecimal inverseTaxableAmount = orderTax.getTaxableAmount().negate();
      inverseOrderTax.setTaxAmount(inverseTaxAmount);
      inverseOrderTax.setTaxableAmount(inverseTaxableAmount);
      inverseOrderTax.setSalesOrder(inverseOrder);
      inverseOrder.getOrderTaxList().add(inverseOrderTax);
      OBDal.getInstance().save(inverseOrderTax);
    }
    OBDal.getInstance().flush();
  }

  private static OrderLine createInverseOrderLine(OrderLine oldOrderLine, Order inverseOrder,
      boolean replaceOrder, boolean triggersDisabled) {
    if (!replaceOrder
        && oldOrderLine.getDeliveredQuantity().compareTo(oldOrderLine.getOrderedQuantity()) == 0) {
      return null;
    }
    OrderLine inverseOrderLine = (OrderLine) DalUtil.copy(oldOrderLine, false, true);
    inverseOrderLine.setSalesOrder(inverseOrder);
    if (!replaceOrder && oldOrderLine.getDeliveredQuantity().compareTo(BigDecimal.ZERO) == 1) {
      BigDecimal inverseOrderedQuantity = oldOrderLine.getOrderedQuantity()
          .subtract(oldOrderLine.getDeliveredQuantity()).negate();
      inverseOrderLine.setOrderedQuantity(inverseOrderedQuantity);
    } else {
      inverseOrderLine.setOrderedQuantity(inverseOrderLine.getOrderedQuantity().negate());
    }
    if (triggersDisabled) {
      inverseOrderLine.setLineGrossAmount(oldOrderLine.getLineGrossAmount().negate());
      inverseOrderLine.setLineNetAmount(oldOrderLine.getLineNetAmount().negate());
    }
    // Set inverse order delivered quantity zero
    inverseOrderLine.setDeliveredQuantity(BigDecimal.ZERO);
    inverseOrderLine.setReservedQuantity(BigDecimal.ZERO);
    inverseOrderLine.setInvoicedQuantity(BigDecimal.ZERO);

    inverseOrder.getOrderLineList().add(inverseOrderLine);
    OBDal.getInstance().save(inverseOrderLine);

    // Copy the discounts of the original line
    createInverseOrderLineDiscounts(oldOrderLine, inverseOrderLine);
    // Copy old order taxes to inverse, it is done when is executed from Web POS because triggers
    // are disabled
    if (triggersDisabled) {
      createInverseOrderLineTaxes(oldOrderLine, inverseOrderLine);
    }

    linesRelations.put(oldOrderLine.getId(), inverseOrderLine.getId());

    return inverseOrderLine;
  }

  private static void createInverseOrderLineDiscounts(OrderLine oldOrderLine,
      OrderLine inverseOrderLine) {
    for (OrderLineOffer orderLineOffer : oldOrderLine.getOrderLineOfferList()) {
      final OrderLineOffer inverseOrderLineOffer = (OrderLineOffer) DalUtil.copy(orderLineOffer,
          false, true);
      inverseOrderLineOffer.setBaseGrossUnitPrice(inverseOrderLineOffer.getBaseGrossUnitPrice()
          .negate());
      inverseOrderLineOffer.setDisplayedTotalAmount(inverseOrderLineOffer.getDisplayedTotalAmount()
          .negate());
      inverseOrderLineOffer.setPriceAdjustmentAmt(inverseOrderLineOffer.getPriceAdjustmentAmt()
          .negate());
      inverseOrderLineOffer.setTotalAmount(inverseOrderLineOffer.getTotalAmount().negate());
      inverseOrderLineOffer.setSalesOrderLine(inverseOrderLine);
      OBDal.getInstance().save(inverseOrderLineOffer);
    }
    OBDal.getInstance().flush();
  }

  private static void createInverseOrderLineTaxes(OrderLine oldOrderLine, OrderLine inverseOrderLine) {
    for (OrderLineTax orderLineTax : oldOrderLine.getOrderLineTaxList()) {
      final OrderLineTax inverseOrderLineTax = (OrderLineTax) DalUtil.copy(orderLineTax, false,
          true);
      BigDecimal inverseTaxAmount = orderLineTax.getTaxAmount().negate();
      BigDecimal inverseTaxableAmount = orderLineTax.getTaxableAmount().negate();
      inverseOrderLineTax.setTaxAmount(inverseTaxAmount);
      inverseOrderLineTax.setTaxableAmount(inverseTaxableAmount);
      inverseOrderLineTax.setSalesOrder(inverseOrderLine.getSalesOrder());
      inverseOrderLineTax.setSalesOrderLine(inverseOrderLine);
      inverseOrderLine.getOrderLineTaxList().add(inverseOrderLineTax);
      inverseOrderLine.getSalesOrder().getOrderLineTaxList().add(inverseOrderLineTax);
      OBDal.getInstance().save(inverseOrderLineTax);
    }
    OBDal.getInstance().flush();
  }

  private static ShipmentInOut createNettingGoodShipmentHeader(Order oldOrder) {
    ShipmentInOut nettingGoodsShipment = null;
    nettingGoodsShipment = OBProvider.getInstance().get(ShipmentInOut.class);
    nettingGoodsShipment.setOrganization(oldOrder.getOrganization());
    DocumentType goodsShipmentDocumentType = FIN_Utility.getDocumentType(
        oldOrder.getOrganization(), DOCTYPE_MatShipment);
    nettingGoodsShipment.setDocumentType(goodsShipmentDocumentType);
    nettingGoodsShipment.setWarehouse(oldOrder.getWarehouse());
    nettingGoodsShipment.setBusinessPartner(oldOrder.getBusinessPartner());
    nettingGoodsShipment.setPartnerAddress(oldOrder.getPartnerAddress());
    Date today = new Date();
    nettingGoodsShipment.setMovementDate(today);
    nettingGoodsShipment.setAccountingDate(today);
    nettingGoodsShipment.setSalesOrder(null);
    nettingGoodsShipment.setPosted("N");
    nettingGoodsShipment.setProcessed(false);
    nettingGoodsShipment.setDocumentStatus("DR");
    nettingGoodsShipment.setDocumentAction("CO");
    nettingGoodsShipment.setMovementType("C-");
    nettingGoodsShipment.setProcessGoodsJava("--");
    nettingGoodsShipment.setSalesTransaction(oldOrder.isSalesTransaction());
    String nettingGoodsShipmentDocumentNo = FIN_Utility.getDocumentNo(
        nettingGoodsShipment.getDocumentType(), ShipmentInOut.TABLE_NAME);
    nettingGoodsShipment.setDocumentNo(nettingGoodsShipmentDocumentNo);
    OBDal.getInstance().save(nettingGoodsShipment);
    return nettingGoodsShipment;
  }

  /**
   * Method that creates a netting goods shipment line for a netting shipment.
   * 
   * @param nettingGoodsShipment
   *          The header of the shipment.
   * @param orderLine
   *          OrderLine what the shipment line delivers
   * @param lineNoCounter
   *          Line number of the shipment line.
   * @param movementQty
   *          Movement quantity of the shipment line.
   * @param triggersDisabled
   *          Flag that tells if triggers are disabled or not while executing this method.
   */
  private static ShipmentInOutLine createNettingShipmentLine(ShipmentInOut nettingGoodsShipment,
      OrderLine orderLine, long lineNoCounter, BigDecimal movementQty, boolean triggersDisabled) {
    ShipmentInOutLine newGoodsShipmentLine = null;
    newGoodsShipmentLine = OBProvider.getInstance().get(ShipmentInOutLine.class);
    newGoodsShipmentLine.setOrganization(orderLine.getOrganization());
    newGoodsShipmentLine.setProduct(orderLine.getProduct());
    newGoodsShipmentLine.setUOM(orderLine.getUOM());
    // Get first storage bin
    Locator locator1 = nettingGoodsShipment.getWarehouse().getLocatorList().get(0);
    newGoodsShipmentLine.setStorageBin(locator1);
    newGoodsShipmentLine.setLineNo(10 * lineNoCounter);
    newGoodsShipmentLine.setSalesOrderLine(orderLine);
    newGoodsShipmentLine.setShipmentReceipt(nettingGoodsShipment);
    newGoodsShipmentLine.setMovementQuantity(movementQty);

    // Create Material Transaction record
    createMTransaction(newGoodsShipmentLine, triggersDisabled);

    OBDal.getInstance().save(newGoodsShipmentLine);
    return newGoodsShipmentLine;
  }

  private static void closeOldReservations(Order oldOrder) {
    if (getEnableStockReservationsPreferenceValue(oldOrder)) {
      ScrollableResults oldOrderLines = null;
      try {
        // Iterate old order lines
        oldOrderLines = getOrderLineList(oldOrder);
        int i = 0;
        while (oldOrderLines.next()) {
          OrderLine oldOrderLine = (OrderLine) oldOrderLines.get(0);
          Reservation reservation = getReservationForOrderLine(oldOrderLine);
          if (reservation != null) {
            ReservationUtils.processReserve(reservation, "CL");
          }
          if ((++i % 100) == 0) {
            OBDal.getInstance().flush();
            OBDal.getInstance().getSession().clear();
          }
        }
      } catch (Exception e) {
        log4j.error("Error in CancelAndReplaceUtils.releaseOldReservations", e);
        throw new OBException(e.getMessage(), e);
      } finally {
        if (oldOrderLines != null) {
          oldOrderLines.close();
        }
      }
    }
  }

  private static void createNewReservations(Order newOrder) {
    if (getEnableStockReservationsPreferenceValue(newOrder)) {
      ScrollableResults newOrderLines = null;
      try {
        // Iterate old order lines
        newOrderLines = getOrderLineList(newOrder);
        int i = 0;
        while (newOrderLines.next()) {
          OrderLine newOrderLine = (OrderLine) newOrderLines.get(0);
          if (newOrderLine.getDeliveredQuantity() != null) {
            if (newOrderLine.getOrderedQuantity().subtract(newOrderLine.getDeliveredQuantity())
                .compareTo(BigDecimal.ZERO) == 0) {
              continue;
            }
          }
          Reservation reservation = getReservationForOrderLine(newOrderLine.getReplacedorderline());
          if (reservation != null) {
            ReservationUtils.createReserveFromSalesOrderLine(newOrderLine, true);
          }
          if ((++i % 100) == 0) {
            OBDal.getInstance().flush();
            OBDal.getInstance().getSession().clear();
          }
        }
      } catch (Exception e) {
        log4j.error("Error in CancelAndReplaceUtils.createNewReservations", e);
        throw new OBException(e.getMessage(), e);
      } finally {
        if (newOrderLines != null) {
          newOrderLines.close();
        }
      }
    }
  }

  private static Reservation getReservationForOrderLine(OrderLine line) {
    OBCriteria<Reservation> reservationCriteria = OBDal.getInstance().createCriteria(
        Reservation.class);
    reservationCriteria.add(Restrictions.eq(Reservation.PROPERTY_SALESORDERLINE, line));
    reservationCriteria.setMaxResults(1);
    Reservation reservation = (Reservation) reservationCriteria.uniqueResult();
    return reservation;
  }

  private static ScrollableResults getOrderLineList(Order order) {
    OBCriteria<OrderLine> orderLinesCriteria = OBDal.getInstance().createCriteria(OrderLine.class);
    orderLinesCriteria.add(Restrictions.eq(OrderLine.PROPERTY_SALESORDER, order));

    ScrollableResults orderLines = orderLinesCriteria.scroll(ScrollMode.FORWARD_ONLY);
    return orderLines;
  }

  private static ScrollableResults getShipmentLineListOfOrderLine(OrderLine line) {
    OBCriteria<ShipmentInOutLine> goodsShipmentLineCriteria = OBDal.getInstance().createCriteria(
        ShipmentInOutLine.class);
    goodsShipmentLineCriteria.add(Restrictions.eq(ShipmentInOutLine.PROPERTY_SALESORDERLINE, line));
    ScrollableResults shipmentLines = goodsShipmentLineCriteria.scroll(ScrollMode.FORWARD_ONLY);
    return shipmentLines;
  }

  private static InvoiceLine getNewInvoiceLine(OrderLine orderLine) {
    final OBCriteria<InvoiceLine> newInvoiceLineCriteria = OBDal.getInstance().createCriteria(
        InvoiceLine.class);
    newInvoiceLineCriteria.add(Restrictions.eq(InvoiceLine.PROPERTY_SALESORDERLINE, orderLine));
    newInvoiceLineCriteria.add(Restrictions.isNull(InvoiceLine.PROPERTY_GOODSSHIPMENTLINE));
    newInvoiceLineCriteria.setMaxResults(1);
    return (InvoiceLine) newInvoiceLineCriteria.uniqueResult();
  }

  /**
   * This method creates an M_TRANSACTION record for a given M_INOUT_LINE. This is done because
   * M_INOUT_POST is not executed for a Netting Shipment, so material transactions needs to be
   * created manually. If triggers are disabled, as it happens when the process is executed from Web
   * POS it is necessary to manually update the stock running M_UPDATE_INVENTORY stored procedure.
   * 
   * @param line
   *          Shipment Line related to the transaction.
   * @param updateStockStatement
   *          M_UPDATE_INVENTORY callable statement.
   * @param triggersDisabled
   *          Flag that tells if triggers are disabled or not while executing this method.
   */
  private static void createMTransaction(ShipmentInOutLine line, boolean triggersDisabled) {
    Product prod = line.getProduct();
    if (prod.getProductType().equals("I") && line.getProduct().isStocked()) {
      // Stock is changed only for stocked products of type "Item"
      MaterialTransaction transaction = OBProvider.getInstance().get(MaterialTransaction.class);
      transaction.setOrganization(line.getOrganization());
      transaction.setMovementType(line.getShipmentReceipt().getMovementType());
      transaction.setProduct(prod);
      transaction.setStorageBin(line.getStorageBin());
      transaction.setOrderUOM(line.getOrderUOM());
      transaction.setUOM(line.getUOM());
      transaction.setOrderQuantity(line.getOrderQuantity());
      transaction.setMovementQuantity(line.getMovementQuantity().multiply(NEGATIVE_ONE));
      transaction.setMovementDate(line.getShipmentReceipt().getMovementDate());
      transaction.setGoodsShipmentLine(line);
      if (line.getAttributeSetValue() != null) {
        transaction.setAttributeSetValue(line.getAttributeSetValue());
      } else if (prod.getAttributeSet() != null
          && (prod.getUseAttributeSetValueAs() == null || !"F".equals(prod
              .getUseAttributeSetValueAs())) && prod.getAttributeSet().isRequireAtLeastOneValue()) {
        // Set fake AttributeSetInstance to transaction line for netting shipment as otherwise it
        // will return an error when the product has an attribute set and
        // "Is Required at Least One Value" property of the attribute set is "Y"
        AttributeSetInstance attr = OBProvider.getInstance().get(AttributeSetInstance.class);
        attr.setAttributeSet(prod.getAttributeSet());
        attr.setDescription("1");
        OBDal.getInstance().save(attr);
        transaction.setAttributeSetValue(attr);
      }

      // Execute M_UPDATE_INVENTORY stored procedure, it is done when is executed from Web POS
      // because triggers are disabled
      if (triggersDisabled) {
        updateInventory(transaction);
      }

      OBDal.getInstance().save(transaction);
    }
  }

  /**
   * Method that creates the relation between products and services for the inverse order. Also, if
   * the old order has or has a relation with a deferred service, this relation must be moved to the
   * new tickets product.
   * 
   * @param oldOrder
   *          The order that have been canceled.
   * @param inverseOrder
   *          The order that is canceling the old order.
   * @param newOrder
   *          The order that is replacing the old order.
   * @param replaceOrder
   *          If true, the process is C&R, otherwise is a CL process.
   * @throws JSONException
   */
  private static void updateServicesRelations(JSONObject jsonorder, Order oldOrder,
      Order inverseOrder, Order newOrder, boolean replaceOrder) throws JSONException {
    final List<String> createdRelations = new ArrayList<>();
    final List<OrderlineServiceRelation> relationsToRemove = new ArrayList<>();
    final OBCriteria<OrderLine> oldOrderLineCriteria = OBDal.getInstance().createCriteria(
        OrderLine.class);
    oldOrderLineCriteria.add(Restrictions.eq(OrderLine.PROPERTY_SALESORDER, oldOrder));
    for (final OrderLine oldOrderLine : oldOrderLineCriteria.list()) {
      final StringBuffer where = new StringBuffer();
      where.append(" WHERE (" + OrderlineServiceRelation.PROPERTY_SALESORDERLINE
          + " = :salesorderline");
      where.append(" OR " + OrderlineServiceRelation.PROPERTY_ORDERLINERELATED
          + " = :salesorderline)");
      final OBQuery<OrderlineServiceRelation> serviceRelationQuery = OBDal.getInstance()
          .createQuery(OrderlineServiceRelation.class, where.toString());
      serviceRelationQuery.setNamedParameter("salesorderline", oldOrderLine);
      for (final OrderlineServiceRelation serviceRelation : serviceRelationQuery.list()) {
        if (!createdRelations.contains(serviceRelation.getId())) {
          createdRelations.add(serviceRelation.getId());
          if (linesRelations.containsKey(serviceRelation.getSalesOrderLine().getId())
              && linesRelations.containsKey(serviceRelation.getOrderlineRelated().getId())) {
            // Create a new relation if is not a deferred service or a product with a deferred
            // service
            final OrderlineServiceRelation inverseServiceRelation = (OrderlineServiceRelation) DalUtil
                .copy(serviceRelation, false, true);
            final OrderLine inverseServiceLine = OBDal.getInstance().get(OrderLine.class,
                linesRelations.get(serviceRelation.getSalesOrderLine().getId()));
            inverseServiceRelation.setSalesOrderLine(inverseServiceLine);
            final OrderLine inverseProductLine = OBDal.getInstance().get(OrderLine.class,
                linesRelations.get(serviceRelation.getOrderlineRelated().getId()));
            inverseServiceRelation.setOrderlineRelated(inverseProductLine);
            inverseServiceRelation.setAmount(inverseServiceRelation.getAmount().negate());
            inverseServiceRelation.setQuantity(inverseServiceRelation.getQuantity().negate());
            OBDal.getInstance().save(inverseServiceRelation);
          } else {
            // Is a deferred relation
            if (replaceOrder) {
              if (linesRelations.containsKey(serviceRelation.getOrderlineRelated().getId())) {
                // A product is being replaced, so the service relation must be removed (the new
                // relation is added in the new ticket synchronization)
                OrderLine newOrderLine = null;
                final OBCriteria<OrderLine> newOrderLineCriteria = OBDal.getInstance()
                    .createCriteria(OrderLine.class);
                if (jsonorder != null) {
                  final JSONArray lines = jsonorder.getJSONArray("lines");
                  for (int i = 0; i < lines.length(); i++) {
                    final JSONObject line = lines.getJSONObject(i);
                    if (line.has("linepos")
                        && (line.getInt("linepos") + 1) * 10 == oldOrderLine.getLineNo()) {
                      newOrderLineCriteria.add(Restrictions.eq(OrderLine.PROPERTY_SALESORDER,
                          newOrder));
                      newOrderLineCriteria.add(Restrictions.eq(OrderLine.PROPERTY_LINENO,
                          (long) ((i + 1) * 10)));
                      newOrderLineCriteria.setMaxResults(1);
                      newOrderLine = (OrderLine) newOrderLineCriteria.uniqueResult();
                      break;
                    }
                  }
                } else {
                  newOrderLineCriteria.add(Restrictions.eq(OrderLine.PROPERTY_REPLACEDORDERLINE,
                      oldOrderLine));
                  newOrderLineCriteria.setMaxResults(1);
                  newOrderLine = (OrderLine) newOrderLineCriteria.uniqueResult();
                }
                if (newOrderLine != null) {
                  // The product haven't been removed during the C&R process. The relation must be
                  // moved from the original order to the new order.
                  serviceRelation.setOrderlineRelated(newOrderLine);
                  OBDal.getInstance().save(serviceRelation);
                } else {
                  // The product have been removed during the C&R process. The service relation must
                  // be removed.
                  relationsToRemove.add(serviceRelation);
                }
              } else {
                // A deferred service has been replaced (or canceled), so the relation must also be
                // created for the inverse order
                final OrderLine inverseServiceLine = OBDal.getInstance().get(OrderLine.class,
                    linesRelations.get(serviceRelation.getSalesOrderLine().getId()));
                final OrderlineServiceRelation inverseServiceRelation = (OrderlineServiceRelation) DalUtil
                    .copy(serviceRelation, false, true);
                inverseServiceRelation.setSalesOrderLine(inverseServiceLine);
                inverseServiceRelation.setAmount(inverseServiceRelation.getAmount().negate());
                inverseServiceRelation.setQuantity(inverseServiceRelation.getQuantity().negate());
                OBDal.getInstance().save(inverseServiceRelation);
              }
            } else {
              if (!linesRelations.containsKey(serviceRelation.getSalesOrderLine().getId())
                  && linesRelations.containsKey(serviceRelation.getOrderlineRelated().getId())
                  && serviceRelation.getOrderlineRelated().getSalesOrder().getId()
                      .equals(oldOrder.getId())) {
                if (serviceRelation.getSalesOrderLine().getSalesOrder().getId()
                    .equals(oldOrder.getId())) {
                  // A product with a related delivered service (in the same ticket) is being
                  // canceled. The relation between the original product and the service must be
                  // removed.
                  relationsToRemove.add(serviceRelation);
                } else {
                  if (serviceRelation.getSalesOrderLine().getSalesOrder().isCancelled()
                      && serviceRelation.getSalesOrderLine().getSalesOrder().getCancelledorder() != null) {
                    // A product is being canceled that contains a deferred service that has been
                    // already canceled. The relation created from the canceled service to the
                    // original product must be moved to the canceled product.
                    final OrderLine inverseProductLine = OBDal.getInstance().get(OrderLine.class,
                        linesRelations.get(serviceRelation.getOrderlineRelated().getId()));
                    serviceRelation.setOrderlineRelated(inverseProductLine);
                    OBDal.getInstance().save(serviceRelation);
                  }
                }
              } else {
                // The CL has a service that is being canceled, which is related to a product in
                // other ticket (the product is deferred) or to a product that have been delivered
                // in the same ticket. The new cancellation line of this service must also be
                // related to the product.
                final OrderLine inverseServiceLine = OBDal.getInstance().get(OrderLine.class,
                    linesRelations.get(serviceRelation.getSalesOrderLine().getId()));
                final OrderlineServiceRelation inverseServiceRelation = (OrderlineServiceRelation) DalUtil
                    .copy(serviceRelation, false, true);
                inverseServiceRelation.setSalesOrderLine(inverseServiceLine);
                inverseServiceRelation.setAmount(inverseServiceRelation.getAmount().negate());
                inverseServiceRelation.setQuantity(inverseServiceRelation.getQuantity().negate());
                OBDal.getInstance().save(inverseServiceRelation);
              }
            }
          }
        }
      }
    }
    // Remove the services relation marked to remove
    for (final OrderlineServiceRelation serviceRelation : relationsToRemove) {
      OBDal.getInstance().remove(serviceRelation);
    }
    linesRelations.clear();
  }

  /**
   * Method that updates the inventory based on an M_TRANSACTION record.
   * 
   * @param transaction
   *          The transaction that triggers the update of the inventory.
   * @param updateStockStatement
   *          The query to be executed.
   */
  private static void updateInventory(MaterialTransaction transaction) {
    try {
      // Stock manipulation
      org.openbravo.database.ConnectionProvider cp = new DalConnectionProvider(false);
      CallableStatement updateStockStatement = cp.getConnection().prepareCall(
          "{call M_UPDATE_INVENTORY (?,?,?,?,?,?,?,?,?,?,?,?,?)}");
      // client
      updateStockStatement.setString(1, OBContext.getOBContext().getCurrentClient().getId());
      // org
      updateStockStatement.setString(2, OBContext.getOBContext().getCurrentOrganization().getId());
      // user
      updateStockStatement.setString(3, OBContext.getOBContext().getUser().getId());
      // product
      updateStockStatement.setString(4, transaction.getProduct().getId());
      // locator
      updateStockStatement.setString(5, transaction.getStorageBin().getId());
      // attributesetinstance
      updateStockStatement.setString(6, transaction.getAttributeSetValue() != null ? transaction
          .getAttributeSetValue().getId() : null);
      // uom
      updateStockStatement.setString(7, transaction.getUOM().getId());
      // product uom
      updateStockStatement.setString(8, null);
      // p_qty
      updateStockStatement.setBigDecimal(9,
          transaction.getMovementQuantity() != null ? transaction.getMovementQuantity() : null);
      // p_qtyorder
      updateStockStatement.setBigDecimal(10,
          transaction.getOrderQuantity() != null ? transaction.getOrderQuantity() : null);
      // p_dateLastInventory --- **
      updateStockStatement.setDate(11, null);
      // p_preqty
      updateStockStatement.setBigDecimal(12, BigDecimal.ZERO);
      // p_preqtyorder
      updateStockStatement.setBigDecimal(13, transaction.getOrderQuantity() != null ? transaction
          .getOrderQuantity().multiply(NEGATIVE_ONE) : null);

      updateStockStatement.execute();

    } catch (Exception e) {
      log4j.error("Error in CancelAndReplaceUtils.updateInventory", e);
      throw new OBException(e.getMessage(), e);
    }
  }

  /**
   * Process that flags the shipment as processed and Completed. M_INOUT_POST is not used as
   * triggers are disabled.
   * 
   * @param shipment
   */
  private static void processShipmentHeader(ShipmentInOut shipment) {
    shipment.setProcessed(true);
    shipment.setDocumentStatus("CO");
    shipment.setDocumentAction("--");
    OBDal.getInstance().save(shipment);
    OBDal.getInstance().flush();
  }

  /**
   * Process that flags the shipment as not processed and draft. M_INOUT_POST is not used as
   * triggers are disabled.
   * 
   * @param shipment
   */
  private static void unprocessShipmentHeader(ShipmentInOut shipment) {
    shipment.setProcessed(false);
    shipment.setDocumentStatus("DR");
    shipment.setDocumentAction("CO");
    OBDal.getInstance().save(shipment);
    OBDal.getInstance().flush();
  }

  private static void createPayments(Order oldOrder, Order newOrder, Order inverseOrder,
      JSONObject jsonorder, boolean useOrderDocumentNoForRelatedDocs, boolean replaceOrder,
      boolean triggersDisabled) {
    try {
      FIN_PaymentSchedule paymentSchedule = getPaymentScheduleOfOrder(oldOrder);
      if (paymentSchedule != null) {
        FIN_Payment nettingPayment = null;

        // Get outstanding amount on original order
        final String countHql = "select coalesce(sum(psd."
            + FIN_PaymentScheduleDetail.PROPERTY_AMOUNT + "), 0) as amount from "
            + FIN_PaymentScheduleDetail.ENTITY_NAME + " as psd where psd."
            + FIN_PaymentScheduleDetail.PROPERTY_ORDERPAYMENTSCHEDULE
            + ".id =:paymentScheduleId and psd."
            + FIN_PaymentScheduleDetail.PROPERTY_PAYMENTDETAILS + " is null";
        final Query qry = OBDal.getInstance().getSession().createQuery(countHql);
        qry.setParameter("paymentScheduleId", paymentSchedule.getId());
        qry.setMaxResults(1);
        BigDecimal outstandingAmount = (BigDecimal) qry.uniqueResult();
        BigDecimal paidAmount = paymentSchedule.getAmount().subtract(outstandingAmount);
        BigDecimal negativeAmount = BigDecimal.ZERO;

        if (replaceOrder) {
          boolean createPayments = true;
          // Pay fully inverse order in C&R.
          negativeAmount = paymentSchedule.getAmount().negate();
          if (!triggersDisabled) {
            // Only for BackEnd WorkFlow
            // Get the payment schedule of the new order to check the outstanding amount, could
            // have been automatically paid on C_ORDER_POST if is automatically invoiced and the
            // payment method of the financial account is configured as 'Automatic Receipt'
            FIN_PaymentSchedule paymentScheduleNewOrder = getPaymentScheduleOfOrder(newOrder);
            if (paymentScheduleNewOrder.getOutstandingAmount().compareTo(BigDecimal.ZERO) == 0) {
              createPayments = false;
            }
          }

          nettingPayment = payOriginalAndInverseOrder(jsonorder, oldOrder, inverseOrder,
              outstandingAmount, negativeAmount, useOrderDocumentNoForRelatedDocs);

          // Pay of the new order the amount already paid in original order
          if (createPayments && paidAmount.compareTo(BigDecimal.ZERO) != 0) {
            nettingPayment = createOrUdpatePayment(nettingPayment, newOrder, null, paidAmount,
                null, null, null);
            String description = nettingPayment.getDescription() + ": " + newOrder.getDocumentNo();
            String truncatedDescription = (description.length() > 255) ? description
                .substring(0, 252).concat("...").toString() : description.toString();
            nettingPayment.setDescription(truncatedDescription);
          }
        } else {
          // To only cancel a layaway two payments must be added to fully pay the old order and add
          // the same quantity in negative to the inverse order
          if (jsonorder.getJSONArray("payments").length() > 0) {
            WeldUtils.getInstanceFromStaticBeanManager(CancelLayawayPaymentsHookCaller.class)
                .executeHook(jsonorder, inverseOrder);

            if (!jsonorder.has("isPartiallyDelivered")
                || (jsonorder.has("isPartiallyDelivered") && !jsonorder
                    .getBoolean("isPartiallyDelivered"))) {
              // In a cancel layaway the gross value of the jsonorder was the amount to
              // return to the customer, not the amount of the ticket. In this case the amount and
              // outstanding needs to be fixed as are created in a wrong way.
              FIN_PaymentSchedule newPaymentSchedule = getPaymentScheduleOfOrder(inverseOrder);
              newPaymentSchedule.setAmount(paymentSchedule.getAmount().negate());
              newPaymentSchedule.setOutstandingAmount(newPaymentSchedule.getAmount().subtract(
                  newPaymentSchedule.getPaidAmount()));
              OBDal.getInstance().save(newPaymentSchedule);
            }
          }

          negativeAmount = outstandingAmount.negate();
          if (outstandingAmount.compareTo(BigDecimal.ZERO) != 0) {
            nettingPayment = payOriginalAndInverseOrder(jsonorder, oldOrder, inverseOrder,
                outstandingAmount, negativeAmount, useOrderDocumentNoForRelatedDocs);
          }
        }

        // Call to processPayment in order to process it
        if (triggersDisabled && replaceOrder) {
          TriggerHandler.getInstance().enable();
        }
        if (nettingPayment != null) {
          if (jsonorder != null && jsonorder.has("canceledorder")) {
            final JSONObject canceledOrder = jsonorder.getJSONObject("canceledorder");
            if (canceledOrder.has("paidOnCredit") && canceledOrder.getBoolean("paidOnCredit")) {
              final BusinessPartner bp = OBDal.getInstance().get(BusinessPartner.class,
                  canceledOrder.getJSONObject("bp").getString("id"));
              bp.setCreditUsed(bp.getCreditUsed().subtract(
                  BigDecimal.valueOf(canceledOrder.getDouble("creditAmount"))));
              OBDal.getInstance().save(bp);
            }
          }
          FIN_PaymentProcess.doProcessPayment(nettingPayment, "P", null, null);
        }
        if (triggersDisabled && replaceOrder) {
          TriggerHandler.getInstance().disable();
        }

      } else {
        throw new OBException("There is no payment plan for the order: " + oldOrder.getId());
      }

    } catch (Exception e1) {
      log4j.error("Error in CancelAndReplaceUtils.createPayments", e1);
      try {
        OBDal.getInstance().getConnection().rollback();
      } catch (Exception e2) {
        throw new OBException(e2);
      }
      Throwable e3 = DbUtility.getUnderlyingSQLException(e1);
      throw new OBException(e3);
    }
  }

  // Pay original order and inverse order.
  private static FIN_Payment payOriginalAndInverseOrder(JSONObject jsonorder, Order oldOrder,
      Order inverseOrder, BigDecimal outstandingAmount, BigDecimal negativeAmount,
      boolean useOrderDocumentNoForRelatedDocs) throws Exception {
    FIN_Payment nettingPayment = null;
    String paymentDocumentNo = null;
    FIN_PaymentMethod paymentPaymentMethod = null;
    FIN_FinancialAccount financialAccount = null;
    OrganizationStructureProvider osp = OBContext.getOBContext().getOrganizationStructureProvider(
        oldOrder.getOrganization().getClient().getId());
    if (jsonorder != null) {
      paymentPaymentMethod = OBDal.getInstance().get(FIN_PaymentMethod.class,
          (String) jsonorder.getJSONObject("defaultPaymentType").get("paymentMethodId"));
      financialAccount = OBDal.getInstance().get(FIN_FinancialAccount.class,
          (String) jsonorder.getJSONObject("defaultPaymentType").get("financialAccountId"));
    } else {
      paymentPaymentMethod = oldOrder.getPaymentMethod();
      // Find a financial account belong the organization tree
      if (oldOrder.getBusinessPartner().getAccount() != null
          && FIN_Utility.getFinancialAccountPaymentMethod(paymentPaymentMethod.getId(), oldOrder
              .getBusinessPartner().getAccount().getId(), true, oldOrder.getCurrency().getId()) != null
          && osp.isInNaturalTree(oldOrder.getBusinessPartner().getAccount().getOrganization(),
              OBDal.getInstance().get(Organization.class, oldOrder.getOrganization().getId()))) {
        financialAccount = oldOrder.getBusinessPartner().getAccount();
      } else {
        financialAccount = FIN_Utility.getFinancialAccountPaymentMethod(
            paymentPaymentMethod.getId(), null, true, oldOrder.getCurrency().getId(),
            oldOrder.getOrganization().getId()).getAccount();
      }
    }

    final DocumentType paymentDocumentType = FIN_Utility.getDocumentType(
        oldOrder.getOrganization(), AcctServer.DOCTYPE_ARReceipt);
    if (paymentDocumentType == null) {
      throw new OBException(OBMessageUtils.messageBD("NoDocTypeDefinedForPaymentIn"));
    }

    paymentDocumentNo = getPaymentDocumentNo(useOrderDocumentNoForRelatedDocs, oldOrder,
        paymentDocumentType);

    // Get Payment Description
    String description = getOrderDocumentNoLabel();
    description += ": " + inverseOrder.getDocumentNo();

    // Duplicate payment with negative amount
    nettingPayment = createOrUdpatePayment(nettingPayment, inverseOrder, paymentPaymentMethod,
        negativeAmount, paymentDocumentType, financialAccount, paymentDocumentNo);

    if (outstandingAmount.compareTo(BigDecimal.ZERO) > 0) {
      // Duplicate payment with positive amount
      nettingPayment = createOrUdpatePayment(nettingPayment, oldOrder, paymentPaymentMethod,
          outstandingAmount, paymentDocumentType, financialAccount, paymentDocumentNo);
      description += ": " + oldOrder.getDocumentNo() + "\n";
    }

    // Set amount and used credit to zero
    nettingPayment.setAmount(BigDecimal.ZERO);
    nettingPayment.setFinancialTransactionAmount(BigDecimal.ZERO);
    nettingPayment.setUsedCredit(BigDecimal.ZERO);
    String truncatedDescription = (description.length() > 255) ? description.substring(0, 252)
        .concat("...").toString() : description.toString();
    nettingPayment.setDescription(truncatedDescription);
    return nettingPayment;
  }

  /**
   * Method that given an amount, payment method, financial account, document type, and a document
   * number, it creates a payment for a given Order. Also a payment is passed as parameter, if that
   * payment is null a new payment is created, if not, a new detail is added to the payment.
   */
  private static FIN_Payment createOrUdpatePayment(FIN_Payment nettingPayment, Order order,
      FIN_PaymentMethod paymentPaymentMethod, BigDecimal amount, DocumentType paymentDocumentType,
      FIN_FinancialAccount financialAccount, String paymentDocumentNo) throws Exception {

    FIN_Payment _nettingPayment = nettingPayment;
    // Get the payment schedule of the order
    FIN_PaymentSchedule paymentSchedule = getPaymentScheduleOfOrder(order);
    if (paymentSchedule == null) {
      // Create a Payment Schedule if the order hasn't got
      paymentSchedule = OBProvider.getInstance().get(FIN_PaymentSchedule.class);
      paymentSchedule.setClient(order.getClient());
      paymentSchedule.setOrganization(order.getOrganization());
      paymentSchedule.setCurrency(order.getCurrency());
      paymentSchedule.setOrder(order);
      paymentSchedule.setFinPaymentmethod(order.getPaymentMethod());
      paymentSchedule.setAmount(amount);
      paymentSchedule.setOutstandingAmount(amount);
      paymentSchedule.setDueDate(order.getOrderDate());
      paymentSchedule.setExpectedDate(order.getOrderDate());
      if (ModelProvider.getInstance().getEntity(FIN_PaymentSchedule.class)
          .hasProperty("origDueDate")) {
        // This property is checked and set this way to force compatibility with both MP13, MP14
        // and
        // later releases of Openbravo. This property is mandatory and must be set. Check issue
        paymentSchedule.set("origDueDate", paymentSchedule.getDueDate());
      }
      paymentSchedule.setFINPaymentPriority(order.getFINPaymentPriority());
      OBDal.getInstance().save(paymentSchedule);
    }

    // Get the payment schedule detail of the order
    OBCriteria<FIN_PaymentScheduleDetail> paymentScheduleDetailCriteria = OBDal.getInstance()
        .createCriteria(FIN_PaymentScheduleDetail.class);
    paymentScheduleDetailCriteria.add(Restrictions.eq(
        FIN_PaymentScheduleDetail.PROPERTY_ORDERPAYMENTSCHEDULE, paymentSchedule));
    // There should be only one with null paymentDetails
    paymentScheduleDetailCriteria.add(Restrictions
        .isNull(FIN_PaymentScheduleDetail.PROPERTY_PAYMENTDETAILS));
    List<FIN_PaymentScheduleDetail> pendingPaymentScheduleDetailList = paymentScheduleDetailCriteria
        .list();

    List<FIN_PaymentScheduleDetail> paymentScheduleDetailList = new ArrayList<FIN_PaymentScheduleDetail>();
    HashMap<String, BigDecimal> paymentScheduleDetailAmount = new HashMap<String, BigDecimal>();
    FIN_PaymentScheduleDetail paymentScheduleDetail = null;
    if (pendingPaymentScheduleDetailList.size() != 0
        && pendingPaymentScheduleDetailList.get(0).getAmount().compareTo(amount) == 0) {
      paymentScheduleDetailList.addAll(pendingPaymentScheduleDetailList);
      paymentScheduleDetail = paymentScheduleDetailList.get(0);
      paymentScheduleDetailAmount.put(paymentScheduleDetail.getId(), amount);
    } else {
      // Two possibilities
      // 1.- All the payments have been created
      // 2.- The payment was created trough Web POS and therefore a payment schedule detail with
      // null payment detail is missing
      // Lets assume that in this point the payment was created trough Web POS
      // Create missing payment schedule detail
      paymentScheduleDetail = OBProvider.getInstance().get(FIN_PaymentScheduleDetail.class);
      paymentScheduleDetail.setOrganization(order.getOrganization());
      paymentScheduleDetail.setOrderPaymentSchedule(paymentSchedule);
      paymentScheduleDetail.setBusinessPartner(order.getBusinessPartner());
      paymentScheduleDetail.setAmount(amount);
      OBDal.getInstance().save(paymentScheduleDetail);
      paymentScheduleDetailList.add(paymentScheduleDetail);

      String paymentScheduleDetailId = paymentScheduleDetail.getId();
      paymentScheduleDetailAmount.put(paymentScheduleDetailId, amount);
    }
    if (_nettingPayment == null) {
      // Call to savePayment in order to create a new payment in
      _nettingPayment = FIN_AddPayment.savePayment(_nettingPayment, true, paymentDocumentType,
          paymentDocumentNo, order.getBusinessPartner(), paymentPaymentMethod, financialAccount,
          amount.toPlainString(), order.getOrderDate(), order.getOrganization(), null,
          paymentScheduleDetailList, paymentScheduleDetailAmount, false, false,
          order.getCurrency(), BigDecimal.ZERO, BigDecimal.ZERO);
    }
    // Create a new line
    else {
      FIN_AddPayment.updatePaymentDetail(paymentScheduleDetailList.get(0), _nettingPayment, amount,
          false);
    }
    return _nettingPayment;
  }

  private static String getOrderDocumentNoLabel() {
    String language = OBContext.getOBContext().getLanguage().getLanguage();
    String paymentDescription = Utility.messageBD(new DalConnectionProvider(false),
        "OrderDocumentno", language);
    return paymentDescription;
  }

  private static String getPaymentDocumentNo(boolean useOrderDocumentNoForRelatedDocs, Order order,
      DocumentType paymentDocumentType) {
    String paymentDocumentNo = null;
    // Get Payment DocumentNo
    Entity paymentEntity = ModelProvider.getInstance().getEntity(FIN_Payment.class);

    if (useOrderDocumentNoForRelatedDocs) {
      paymentDocumentNo = order.getDocumentNo();
    } else {
      paymentDocumentNo = Utility.getDocumentNo(OBDal.getInstance().getConnection(false),
          new DalConnectionProvider(false), RequestContext.get().getVariablesSecureApp(), "",
          paymentEntity.getTableName(), "",
          paymentDocumentType == null ? "" : paymentDocumentType.getId(), false, true);
    }
    return paymentDocumentNo;
  }

  /**
   * Process that generates a document number for an order which cancels another order.
   * 
   * @param documentNo
   *          Document number of the cancelled order.
   * @return The new document number for the order which cancels the old order.
   */
  private static String getNextCancelDocNo(String documentNo) {
    String newDocNo = "";
    String[] splittedDocNo = documentNo.split(HYPHEN);
    if (splittedDocNo.length > 1) {
      int nextNumber;
      try {
        nextNumber = Integer.parseInt(splittedDocNo[splittedDocNo.length - 1]) + 1;
        for (int i = 0; i < splittedDocNo.length; i++) {
          if (i == 0) {
            newDocNo = splittedDocNo[i] + HYPHEN;
          } else if (i < splittedDocNo.length - 1) {
            newDocNo += splittedDocNo[i] + HYPHEN;
          } else {
            newDocNo += nextNumber;
          }
        }
      } catch (NumberFormatException nfe) {
        newDocNo = documentNo + HYPHENONE;
      }
    } else {
      newDocNo = documentNo + HYPHENONE;
    }
    return newDocNo;
  }

  /**
   * Method to check if a netting shipment must be generated during the C&amp;R and CL process.
   * 
   * @param order
   *          The order that is being canceled.
   * @return True if is necessary to create the netting shipment.
   */
  public static boolean getCreateNettingGoodsShipmentPreferenceValue(Order order) {
    boolean createNettingGoodsShipment = false;
    try {
      createNettingGoodsShipment = Preferences.getPreferenceValue(CREATE_NETTING_SHIPMENT, true,
          OBContext.getOBContext().getCurrentClient(), order.getOrganization(),
          OBContext.getOBContext().getUser(), null, null).equals("Y");
    } catch (PropertyException e1) {
      createNettingGoodsShipment = false;
    }
    return createNettingGoodsShipment;
  }

  /**
   * Method to check if during the C&amp;R process the shipment lines must be moved from the old
   * order to the new order.
   * 
   * @param order
   *          The order that is being canceled.
   * @return True if the shipment lines must be moved to the new order.
   */
  public static boolean getAssociateGoodsShipmentToNewSalesOrderPreferenceValue(Order order) {
    boolean associateShipmentToNewReceipt = false;
    try {
      associateShipmentToNewReceipt = Preferences.getPreferenceValue(
          ASSOCIATE_SHIPMENT_TO_REPLACE_TICKET, true, OBContext.getOBContext().getCurrentClient(),
          order.getOrganization(), OBContext.getOBContext().getUser(), null, null).equals("Y");
    } catch (PropertyException e1) {
      associateShipmentToNewReceipt = false;
    }
    return associateShipmentToNewReceipt;
  }

  private static boolean getEnableStockReservationsPreferenceValue(Order order) {
    boolean enableStockReservations = false;
    try {
      enableStockReservations = ("Y").equals(Preferences.getPreferenceValue(
          CancelAndReplaceUtils.ENABLE_STOCK_RESERVATIONS, true, OBContext.getOBContext()
              .getCurrentClient(), order.getOrganization(), OBContext.getOBContext().getUser(),
          null, null));
    } catch (PropertyException e1) {
      enableStockReservations = false;
    }
    return enableStockReservations;
  }

  private static OrderLine getReplacementOrderLine(Order newOrder, OrderLine oldOrderLine) {
    OBCriteria<OrderLine> olc = OBDal.getInstance().createCriteria(OrderLine.class);
    olc.add(Restrictions.eq(OrderLine.PROPERTY_REPLACEDORDERLINE, oldOrderLine));
    olc.add(Restrictions.eq(OrderLine.PROPERTY_SALESORDER, newOrder));
    olc.setMaxResults(1);
    OrderLine newOrderLine = (OrderLine) olc.uniqueResult();
    return newOrderLine;
  }

  private static FIN_PaymentSchedule getPaymentScheduleOfOrder(Order order) {
    FIN_PaymentSchedule paymentSchedule;
    OBCriteria<FIN_PaymentSchedule> paymentScheduleCriteria = OBDal.getInstance().createCriteria(
        FIN_PaymentSchedule.class);
    paymentScheduleCriteria.add(Restrictions.eq(FIN_PaymentSchedule.PROPERTY_ORDER, order));
    paymentScheduleCriteria.setMaxResults(1);
    paymentSchedule = (FIN_PaymentSchedule) paymentScheduleCriteria.uniqueResult();
    return paymentSchedule;
  }

  private static Order lockOrder(Order order) {
    StringBuilder where = new StringBuilder("select c from " + Order.ENTITY_NAME
        + " c where id = :id");
    final Session session = OBDal.getInstance().getSession();
    final Query query = session.createQuery(where.toString());
    query.setParameter("id", order.getId());
    query.setMaxResults(1);
    query.setLockOptions(LockOptions.UPGRADE);
    return (Order) query.uniqueResult();
  }

}
