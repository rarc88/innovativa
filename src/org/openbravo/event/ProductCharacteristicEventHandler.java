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
 * All portions are Copyright (C) 2013-2015 Openbravo SLU
 * All Rights Reserved.
 * Contributor(s):  ______________________________________.
 *************************************************************************
 */
package org.openbravo.event;

import java.util.List;

import javax.enterprise.event.Observes;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.model.Entity;
import org.openbravo.base.model.ModelProvider;
import org.openbravo.base.model.Property;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.client.kernel.event.EntityDeleteEvent;
import org.openbravo.client.kernel.event.EntityNewEvent;
import org.openbravo.client.kernel.event.EntityPersistenceEventObserver;
import org.openbravo.client.kernel.event.EntityUpdateEvent;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.model.ad.access.CharacteristicSubsetValue;
import org.openbravo.model.common.plm.CharacteristicValue;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.plm.ProductCharacteristic;
import org.openbravo.model.common.plm.ProductCharacteristicConf;
import org.openbravo.model.common.plm.ProductCharacteristicValue;

public class ProductCharacteristicEventHandler extends EntityPersistenceEventObserver {
  private static Entity[] entities = { ModelProvider.getInstance().getEntity(
      ProductCharacteristic.ENTITY_NAME) };
  protected Logger logger = Logger.getLogger(this.getClass());

  @Override
  protected Entity[] getObservedEntities() {
    return entities;
  }

  public void onDelete(@Observes EntityDeleteEvent event) {
    if (!isValidEvent(event)) {
      return;
    }
    final ProductCharacteristic prCh = (ProductCharacteristic) event.getTargetInstance();
    if (prCh.isVariant() && prCh.getProduct().isGeneric()
        && !prCh.getProduct().getProductGenericProductList().isEmpty()) {
      throw new OBException(OBMessageUtils.messageBD("DeleteVariantChWithVariantsError"));
    }
    deleteProductCharacteristicValue(prCh);
  }

  public void onSave(@Observes EntityNewEvent event) {
    if (!isValidEvent(event)) {
      return;
    }
    final ProductCharacteristic prCh = (ProductCharacteristic) event.getTargetInstance();
    if (prCh.isVariant() && prCh.getProduct().isGeneric()) {
      if (!prCh.getProduct().getProductGenericProductList().isEmpty()) {
        throw new OBException(OBMessageUtils.messageBD("NewVariantChWithVariantsError"));
      }
      if (prCh.isDefinesPrice()) {
        // Check there is only 1.
        OBCriteria<ProductCharacteristic> criteria = OBDal.getInstance().createCriteria(
            ProductCharacteristic.class);
        criteria.add(Restrictions.eq(ProductCharacteristic.PROPERTY_PRODUCT, prCh.getProduct()));
        criteria.add(Restrictions.eq(ProductCharacteristic.PROPERTY_DEFINESPRICE, true));
        criteria.add(Restrictions.ne(ProductCharacteristic.PROPERTY_ID, prCh.getId()));
        criteria.setFilterOnActive(false);
        criteria.setMaxResults(1);
        if (criteria.uniqueResult() != null) {
          throw new OBException(OBMessageUtils.messageBD("DuplicateDefinesPrice"));
        }
      }
      if (prCh.isDefinesImage()) {
        // Check there is only 1.
        OBCriteria<ProductCharacteristic> criteria = OBDal.getInstance().createCriteria(
            ProductCharacteristic.class);
        criteria.add(Restrictions.eq(ProductCharacteristic.PROPERTY_PRODUCT, prCh.getProduct()));
        criteria.add(Restrictions.eq(ProductCharacteristic.PROPERTY_DEFINESIMAGE, true));
        criteria.add(Restrictions.ne(ProductCharacteristic.PROPERTY_ID, prCh.getId()));
        criteria.setFilterOnActive(false);
        criteria.setMaxResults(1);
        if (criteria.uniqueResult() != null) {
          throw new OBException(OBMessageUtils.messageBD("DuplicateDefinesImage"));
        }
      }
      final Entity prodCharEntity = ModelProvider.getInstance().getEntity(
          ProductCharacteristic.ENTITY_NAME);

      if (prCh.isExplodeConfigurationTab()) {
        final Property charConfListProperty = prodCharEntity
            .getProperty(ProductCharacteristic.PROPERTY_PRODUCTCHARACTERISTICCONFLIST);
        @SuppressWarnings("unchecked")
        List<ProductCharacteristicConf> prChConfs = (List<ProductCharacteristicConf>) event
            .getCurrentState(charConfListProperty);

        ScrollableResults scroll = getValuesToAdd(prCh);
        try {
          while (scroll.next()) {
            Object[] strChValue = scroll.get();
            String chValueId = (String) strChValue[0];
            String chValueCode = (String) strChValue[1];
            Boolean chValueActive = (Boolean) strChValue[2];
            prChConfs.add(getCharacteristicConf(prCh, chValueId, chValueCode, chValueActive));
          }
        } finally {
          scroll.close();
        }
      }
    }
  }

  public void onUpdate(@Observes EntityUpdateEvent event) {
    if (!isValidEvent(event)) {
      return;
    }
    final ProductCharacteristic prCh = (ProductCharacteristic) event.getTargetInstance();
    final Entity prodCharEntity = ModelProvider.getInstance().getEntity(
        ProductCharacteristic.ENTITY_NAME);

    final Property chProp = prodCharEntity
        .getProperty(ProductCharacteristic.PROPERTY_CHARACTERISTIC);
    final Property prdProp = prodCharEntity.getProperty(ProductCharacteristic.PROPERTY_PRODUCT);

    if (!event.getPreviousState(chProp).equals(event.getCurrentState(chProp))) {
      final Product prd = (Product) event.getCurrentState(prdProp);
      // Check there is only 1.
      OBCriteria<ProductCharacteristicValue> criteria = OBDal.getInstance().createCriteria(
          ProductCharacteristicValue.class);
      criteria.add(Restrictions.eq(ProductCharacteristicValue.PROPERTY_PRODUCT, prd));
      criteria.add(Restrictions.eq(ProductCharacteristicValue.PROPERTY_CHARACTERISTIC,
          event.getPreviousState(chProp)));
      criteria.setFilterOnActive(false);
      criteria.setMaxResults(1);
      if (criteria.uniqueResult() != null) {
        throw new OBException(OBMessageUtils.messageBD("UpdateProductChWithValue"));
      }
    }

    if (!prCh.isVariant() && prCh.getProduct().isGeneric()
        && !prCh.getProduct().getProductGenericProductList().isEmpty()) {
      throw new OBException(OBMessageUtils.messageBD("NewVariantChWithVariantsError"));
    }
    if (prCh.isVariant() && prCh.getProduct().isGeneric()) {
      final Property variantProperty = prodCharEntity
          .getProperty(ProductCharacteristic.PROPERTY_VARIANT);
      boolean oldIsVariant = (Boolean) event.getPreviousState(variantProperty);

      if (!prCh.getProduct().getProductGenericProductList().isEmpty() && !oldIsVariant) {
        throw new OBException(OBMessageUtils.messageBD("NewVariantChWithVariantsError"));
      }
      if (prCh.isDefinesPrice()) {
        // Check there is only 1.
        OBCriteria<ProductCharacteristic> criteria = OBDal.getInstance().createCriteria(
            ProductCharacteristic.class);
        criteria.add(Restrictions.eq(ProductCharacteristic.PROPERTY_PRODUCT, prCh.getProduct()));
        criteria.add(Restrictions.eq(ProductCharacteristic.PROPERTY_DEFINESPRICE, true));
        criteria.add(Restrictions.ne(ProductCharacteristic.PROPERTY_ID, prCh.getId()));
        criteria.setFilterOnActive(false);
        criteria.setMaxResults(1);
        if (criteria.uniqueResult() != null) {
          throw new OBException(OBMessageUtils.messageBD("DuplicateDefinesPrice"));
        }
      }
      if (prCh.isDefinesImage()) {
        // Check there is only 1.
        OBCriteria<ProductCharacteristic> criteria = OBDal.getInstance().createCriteria(
            ProductCharacteristic.class);
        criteria.add(Restrictions.eq(ProductCharacteristic.PROPERTY_PRODUCT, prCh.getProduct()));
        criteria.add(Restrictions.eq(ProductCharacteristic.PROPERTY_DEFINESIMAGE, true));
        criteria.add(Restrictions.ne(ProductCharacteristic.PROPERTY_ID, prCh.getId()));
        criteria.setFilterOnActive(false);
        criteria.setMaxResults(1);
        if (criteria.uniqueResult() != null) {
          throw new OBException(OBMessageUtils.messageBD("DuplicateDefinesImage"));
        }
      }

      if (prCh.isExplodeConfigurationTab()) {
        final Property charConfListProperty = prodCharEntity
            .getProperty(ProductCharacteristic.PROPERTY_PRODUCTCHARACTERISTICCONFLIST);
        @SuppressWarnings("unchecked")
        List<ProductCharacteristicConf> prChConfs = (List<ProductCharacteristicConf>) event
            .getCurrentState(charConfListProperty);

        StringBuffer hql = new StringBuffer();
        hql.append(" select cv." + CharacteristicValue.PROPERTY_ID);
        hql.append(" from " + ProductCharacteristicConf.ENTITY_NAME + " as pcc");
        hql.append(" join pcc." + ProductCharacteristicConf.PROPERTY_CHARACTERISTICVALUE + " as cv");
        hql.append(" where pcc." + ProductCharacteristicConf.PROPERTY_CHARACTERISTICOFPRODUCT
            + " = :pc");
        Query query = OBDal.getInstance().getSession().createQuery(hql.toString());
        query.setParameter("pc", prCh);
        @SuppressWarnings("unchecked")
        final List<String> existingValues = query.list();

        ScrollableResults scroll = getValuesToAdd(prCh);
        try {
          while (scroll.next()) {
            Object[] strChValue = scroll.get();
            String chValueId = (String) strChValue[0];
            String chValueCode = (String) strChValue[1];
            Boolean chValueActive = (Boolean) strChValue[2];

            if (existingValues.remove(chValueId)) {
              OBCriteria<ProductCharacteristicConf> prChConfCrit = OBDal.getInstance()
                  .createCriteria(ProductCharacteristicConf.class);
              prChConfCrit.add(Restrictions.eq(
                  ProductCharacteristicConf.PROPERTY_CHARACTERISTICOFPRODUCT, prCh));
              prChConfCrit.add(Restrictions.eq(
                  ProductCharacteristicConf.PROPERTY_CHARACTERISTICVALUE,
                  OBDal.getInstance().get(CharacteristicValue.class, chValueId)));
              prChConfCrit.setFilterOnActive(false);
              ProductCharacteristicConf prChConf = (ProductCharacteristicConf) prChConfCrit
                  .uniqueResult();
              prChConf.setCode(chValueCode);
              prChConf.setActive(chValueActive);
              continue;
            }
            prChConfs.add(getCharacteristicConf(prCh, chValueId, chValueCode, chValueActive));
          }
        } finally {
          scroll.close();
        }

        // remove not needed
        if (!existingValues.isEmpty()) {
          for (String strChValueId : existingValues) {
            OBCriteria<ProductCharacteristicConf> prChConfCrit = OBDal.getInstance()
                .createCriteria(ProductCharacteristicConf.class);
            prChConfCrit.add(Restrictions.eq(
                ProductCharacteristicConf.PROPERTY_CHARACTERISTICOFPRODUCT, prCh));
            prChConfCrit.add(Restrictions.eq(
                ProductCharacteristicConf.PROPERTY_CHARACTERISTICVALUE,
                OBDal.getInstance().get(CharacteristicValue.class, strChValueId)));
            prChConfCrit.setFilterOnActive(false);
            ProductCharacteristicConf prChConf = (ProductCharacteristicConf) prChConfCrit
                .uniqueResult();

            prChConfs.remove(prChConf);
            OBDal.getInstance().remove(prChConf);
          }
        }
      }
    }
  }

  private ScrollableResults getValuesToAdd(ProductCharacteristic prCh) {

    // If a subset is defined insert only values of it.
    if (prCh.getCharacteristicSubset() != null) {
      StringBuffer hql = new StringBuffer();
      hql.append(" select cv." + CharacteristicValue.PROPERTY_ID);
      hql.append(" , coalesce(csv." + CharacteristicSubsetValue.PROPERTY_CODE + ", cv."
          + CharacteristicValue.PROPERTY_CODE + ")");
      hql.append(" , cv." + CharacteristicValue.PROPERTY_ACTIVE);
      hql.append(" from " + CharacteristicSubsetValue.ENTITY_NAME + " as csv");
      hql.append(" join csv." + CharacteristicSubsetValue.PROPERTY_CHARACTERISTICVALUE + " as cv");
      hql.append(" where csv." + CharacteristicSubsetValue.PROPERTY_CHARACTERISTICSUBSET + " = :cs");
      Query query = OBDal.getInstance().getSession().createQuery(hql.toString());
      query.setParameter("cs", prCh.getCharacteristicSubset());
      return query.scroll(ScrollMode.FORWARD_ONLY);
    }

    // Add all not summary values.
    else {
      StringBuffer hql = new StringBuffer();
      hql.append(" select cv." + CharacteristicValue.PROPERTY_ID);
      hql.append(" , cv." + CharacteristicValue.PROPERTY_CODE);
      hql.append(" , cv." + CharacteristicValue.PROPERTY_ACTIVE);
      hql.append(" from " + CharacteristicValue.ENTITY_NAME + " as cv");
      hql.append(" where cv." + CharacteristicValue.PROPERTY_CHARACTERISTIC + " = :c");
      hql.append(" and cv." + CharacteristicValue.PROPERTY_SUMMARYLEVEL + " = false");
      Query query = OBDal.getInstance().getSession().createQuery(hql.toString());
      query.setParameter("c", prCh.getCharacteristic());
      return query.scroll(ScrollMode.FORWARD_ONLY);
    }
  }

  private ProductCharacteristicConf getCharacteristicConf(ProductCharacteristic prCh,
      String strCharacteristicValueId, String strCode, Boolean strActive) {
    ProductCharacteristicConf charConf = OBProvider.getInstance().get(
        ProductCharacteristicConf.class);
    charConf.setCharacteristicOfProduct(prCh);
    charConf.setOrganization(prCh.getOrganization());
    charConf.setCharacteristicValue((CharacteristicValue) OBDal.getInstance().getProxy(
        CharacteristicValue.ENTITY_NAME, strCharacteristicValueId));
    charConf.setCode(strCode);
    charConf.setActive(strActive);
    return charConf;
  }

  private void deleteProductCharacteristicValue(ProductCharacteristic productCharacteristic) {
    ScrollableResults scroll = null;
    try {
      OBCriteria<ProductCharacteristicValue> criteria = OBDal.getInstance().createCriteria(
          ProductCharacteristicValue.class);
      criteria.add(Restrictions.eq(ProductCharacteristicValue.PROPERTY_CHARACTERISTIC,
          productCharacteristic.getCharacteristic()));
      criteria.add(Restrictions.eq(ProductCharacteristicValue.PROPERTY_PRODUCT,
          productCharacteristic.getProduct()));
      scroll = criteria.scroll(ScrollMode.FORWARD_ONLY);
      int i = 0;
      while (scroll.next()) {
        ProductCharacteristicValue productCharacteristicValue = (ProductCharacteristicValue) scroll
            .get(0);
        OBDal.getInstance().remove(productCharacteristicValue);
        i++;
        if (i % 100 == 0) {
          OBDal.getInstance().flush();
          OBDal.getInstance().getSession().clear();
        }
      }
    } finally {
      scroll.close();
    }
  }
}
