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
 * All portions are Copyright (C) 2013-2018 Openbravo SLU 
 * All Rights Reserved. 
 * Contributor(s):  ______________________________________.
 ************************************************************************
 */
package org.openbravo.event;

import java.util.Date;
import java.util.List;

import javax.enterprise.event.Observes;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.model.Entity;
import org.openbravo.base.model.ModelProvider;
import org.openbravo.base.model.Property;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.client.kernel.event.EntityDeleteEvent;
import org.openbravo.client.kernel.event.EntityPersistenceEventObserver;
import org.openbravo.client.kernel.event.EntityUpdateEvent;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.businessUtility.Preferences;
import org.openbravo.erpCommon.utility.PropertyException;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.Warehouse;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.common.order.OrderDiscount;
import org.openbravo.model.common.order.OrderLine;

public class OrderEventHandler extends EntityPersistenceEventObserver {

  private static final String DO_NOT_SYNC_WAREHOUSE_PREFERENCE = "DoNotSyncWarehouse";
  private static final String DO_NOT_SYNC_DATE_DELIVERED_PREFERENCE = "DoNotSyncDateDelivered";
  private static final String DO_NOT_SYNC_DATE_ORDERED_PREFERENCE = "DoNotSyncDateOrdered";
  private static Entity[] entities = { ModelProvider.getInstance().getEntity(Order.ENTITY_NAME) };
  protected Logger logger = Logger.getLogger(this.getClass());

  @Override
  protected Entity[] getObservedEntities() {
    return entities;
  }

  public void onUpdate(@Observes EntityUpdateEvent event) {
    if (!isValidEvent(event)) {
      return;
    }

    OrderParameters orderParameters = getOrderParameters(event);

    List<OrderLine> orderLines = getOrderLines(orderParameters);
    if (CollectionUtils.isNotEmpty(orderLines)) {
      updateOrderLinesValues(orderParameters, orderLines);
    }

    if (businessPartnerHasChanged(orderParameters)) {
      removeDiscountInformationFromOrder(orderParameters);
    }
  }

  public void onDelete(@Observes EntityDeleteEvent event) {
    if (!isValidEvent(event)) {
      return;
    }
    final Entity orderEntity = ModelProvider.getInstance().getEntity(Order.ENTITY_NAME);
    final Property quotationProperty = orderEntity.getProperty(Order.PROPERTY_QUOTATION);
    Order quotation = (Order) event.getCurrentState(quotationProperty);
    if (quotation != null) {
      quotation.setDocumentStatus("UE");
    }
  }

  private OrderParameters getOrderParameters(final EntityUpdateEvent event) {
    OrderParameters orderParameters = new OrderParameters();
    final Entity orderEntity = ModelProvider.getInstance().getEntity(Order.ENTITY_NAME);
    final Property orderDateProperty = orderEntity.getProperty(Order.PROPERTY_ORDERDATE);
    final Property scheduledDateProperty = orderEntity
        .getProperty(Order.PROPERTY_SCHEDULEDDELIVERYDATE);
    final Property warehouseProperty = orderEntity.getProperty(Order.PROPERTY_WAREHOUSE);
    final Property businessPartnerProperty = orderEntity
        .getProperty(Order.PROPERTY_BUSINESSPARTNER);

    orderParameters.setOrderId((String) event.getTargetInstance().getId());
    orderParameters.setNewOrderDate((Date) event.getCurrentState(orderDateProperty));
    orderParameters.setOldOrderDate((Date) event.getPreviousState(orderDateProperty));
    orderParameters.setNewScheduledDate((Date) event.getCurrentState(scheduledDateProperty));
    orderParameters.setOldScheduledDate((Date) event.getPreviousState(scheduledDateProperty));
    orderParameters.setNewWarehouse((Warehouse) event.getCurrentState(warehouseProperty));
    orderParameters.setOldWarehouse((Warehouse) event.getPreviousState(warehouseProperty));
    orderParameters.setNewBPId(((BusinessPartner) event.getCurrentState(businessPartnerProperty))
        .getId());
    orderParameters.setOldBPId(((BusinessPartner) event.getPreviousState(businessPartnerProperty))
        .getId());

    return orderParameters;
  }

  private List<OrderLine> getOrderLines(final OrderParameters orderParameters) {
    OBCriteria<OrderLine> orderLineCriteria = OBDal.getInstance().createCriteria(OrderLine.class);
    orderLineCriteria.add(Restrictions.eq(OrderLine.PROPERTY_SALESORDER,
        OBDal.getInstance().get(Order.class, orderParameters.getOrderId())));
    return orderLineCriteria.list();
  }

  private void updateOrderLinesValues(final OrderParameters orderParameters,
      final List<OrderLine> orderLines) {
    final boolean syncOrderDate = isOrderDateChangedAndPreferenceIsNotActivated(orderParameters);
    final boolean syncDeliveredDate = isScheduledDateChangedAndPreferenceIsNotActivated(orderParameters);
    final boolean syncWarehouse = isWarehouseChangedAndPreferenceIsNotActivated(orderParameters);

    if (syncOrderDate || syncDeliveredDate || syncWarehouse) {
      for (OrderLine lines : orderLines) {
        if (syncOrderDate) {
          lines.setOrderDate(orderParameters.getNewOrderDate());
        }
        if (syncDeliveredDate) {
          lines.setScheduledDeliveryDate(orderParameters.getNewScheduledDate());
        }
        if (syncWarehouse) {
          lines.setWarehouse(orderParameters.getNewWarehouse());
        }
      }
    }
  }

  private boolean isOrderDateChangedAndPreferenceIsNotActivated(
      final OrderParameters orderParameters) {
    boolean syncField = false;
    if (areDatesDifferent(orderParameters.getNewOrderDate(), orderParameters.getOldOrderDate())) {
      syncField = !StringUtils.equals(Preferences.YES,
          getPreferenceValue(DO_NOT_SYNC_DATE_ORDERED_PREFERENCE));
    }
    return syncField;
  }

  private boolean isScheduledDateChangedAndPreferenceIsNotActivated(
      final OrderParameters orderParameters) {
    boolean syncField = false;
    if (areDatesDifferent(orderParameters.getNewScheduledDate(),
        orderParameters.getOldScheduledDate())) {
      syncField = !StringUtils.equals(Preferences.YES,
          getPreferenceValue(DO_NOT_SYNC_DATE_DELIVERED_PREFERENCE));
    }
    return syncField;
  }

  private boolean isWarehouseChangedAndPreferenceIsNotActivated(
      final OrderParameters orderParameters) {
    boolean syncField = false;
    if (areObjectsDifferent(orderParameters.getNewWarehouse(), orderParameters.getOldWarehouse())) {
      syncField = !StringUtils.equals(Preferences.YES,
          getPreferenceValue(DO_NOT_SYNC_WAREHOUSE_PREFERENCE));
    }
    return syncField;
  }

  private boolean areDatesDifferent(final Date newDate, final Date oldDate) {
    return newDate != null && oldDate != null && newDate.compareTo(oldDate) != 0;
  }

  private boolean areObjectsDifferent(final BaseOBObject newObject, final BaseOBObject oldObject) {
    return newObject != null && oldObject != null
        && !StringUtils.equals(newObject.getId().toString(), oldObject.getId().toString());
  }

  private String getPreferenceValue(final String preferenceKey) {
    String syncField;
    try {
      syncField = Preferences.getPreferenceValue(preferenceKey, true, OBContext.getOBContext()
          .getCurrentClient(), OBContext.getOBContext().getCurrentOrganization(), OBContext
          .getOBContext().getUser(), OBContext.getOBContext().getRole(), null);
    } catch (PropertyException e) {
      // if property not found, sync the field
      syncField = Preferences.NO;
    }
    return syncField;
  }

  private boolean businessPartnerHasChanged(final OrderParameters orderParameters) {
    return !StringUtils.equals(orderParameters.getNewBPId(), orderParameters.getOldBPId());
  }

  private void removeDiscountInformationFromOrder(final OrderParameters orderParameters) {
    StringBuilder deleteHql = new StringBuilder();
    deleteHql.append(" delete from " + OrderDiscount.ENTITY_NAME);
    deleteHql.append(" where " + OrderDiscount.PROPERTY_SALESORDER + ".id = :orderId");
    Query deleteQry = OBDal.getInstance().getSession().createQuery(deleteHql.toString());
    deleteQry.setParameter("orderId", orderParameters.getOrderId());
    deleteQry.executeUpdate();
  }

  private class OrderParameters {
    String orderId;
    Date newOrderDate;
    Date oldOrderDate;
    Date newScheduledDate;
    Date oldScheduledDate;
    Warehouse newWarehouse;
    Warehouse oldWarehouse;
    String newBPId;
    String oldBPId;

    public OrderParameters() {
      this.orderId = null;
      this.newOrderDate = null;
      this.oldOrderDate = null;
      this.newScheduledDate = null;
      this.oldScheduledDate = null;
      this.newWarehouse = null;
      this.oldWarehouse = null;
      this.newBPId = null;
      this.oldBPId = null;
    }

    public String getOrderId() {
      return orderId;
    }

    public void setOrderId(String orderId) {
      this.orderId = orderId;
    }

    public Date getNewOrderDate() {
      return newOrderDate;
    }

    public void setNewOrderDate(Date newOrderDate) {
      this.newOrderDate = newOrderDate;
    }

    public Date getOldOrderDate() {
      return oldOrderDate;
    }

    public void setOldOrderDate(Date oldOrderDate) {
      this.oldOrderDate = oldOrderDate;
    }

    public Date getNewScheduledDate() {
      return newScheduledDate;
    }

    public void setNewScheduledDate(Date newScheduledDate) {
      this.newScheduledDate = newScheduledDate;
    }

    public Date getOldScheduledDate() {
      return oldScheduledDate;
    }

    public void setOldScheduledDate(Date oldScheduledDate) {
      this.oldScheduledDate = oldScheduledDate;
    }

    public Warehouse getNewWarehouse() {
      return newWarehouse;
    }

    public void setNewWarehouse(Warehouse newWarehouse) {
      this.newWarehouse = newWarehouse;
    }

    public Warehouse getOldWarehouse() {
      return oldWarehouse;
    }

    public void setOldWarehouse(Warehouse oldWarehouse) {
      this.oldWarehouse = oldWarehouse;
    }

    public String getNewBPId() {
      return newBPId;
    }

    public void setNewBPId(String newBPId) {
      this.newBPId = newBPId;
    }

    public String getOldBPId() {
      return oldBPId;
    }

    public void setOldBPId(String oldBPId) {
      this.oldBPId = oldBPId;
    }

  }
}
