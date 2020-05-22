package ec.com.sidesoft.quick.billing.event;

import java.util.List;

import javax.enterprise.event.Observes;

import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.model.Entity;
import org.openbravo.base.model.ModelProvider;
import org.openbravo.client.kernel.event.EntityNewEvent;
import org.openbravo.client.kernel.event.EntityPersistenceEventObserver;
import org.openbravo.client.kernel.event.EntityUpdateEvent;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.service.db.DalConnectionProvider;

import ec.com.sidesoft.quick.billing.SqbConfigProduct;

public class Sqb_ConfigProductDefaultEvent extends EntityPersistenceEventObserver {
  private static Entity[] entities = { ModelProvider.getInstance().getEntity(
      SqbConfigProduct.ENTITY_NAME) };

  @Override
  protected Entity[] getObservedEntities() {
    return entities;
  }

  public void onSave(@Observes EntityNewEvent event) {
    if (!isValidEvent(event)) {
      return;
    }

    final SqbConfigProduct sqbConfigQBProduct = (SqbConfigProduct) event.getTargetInstance();

    String language = OBContext.getOBContext().getLanguage().getLanguage();
    ConnectionProvider conn = new DalConnectionProvider(false);

    if (sqbConfigQBProduct.isDefault()) {

      // Contar Productos por defecto
      OBCriteria<SqbConfigProduct> criteriaQBProduct = OBDal.getInstance().createCriteria(
          SqbConfigProduct.class);
      criteriaQBProduct.add(Restrictions.eq(SqbConfigProduct.PROPERTY_ISDEFAULT, true));
      // criteriaQBProduct.add(Restrictions.eq(SqbConfigProduct.PROPERTY_CREATEDBY, userQB));
      criteriaQBProduct.add(Restrictions.eq(SqbConfigProduct.PROPERTY_SQBCONFIGQUICKBILLING,
          sqbConfigQBProduct.getSQBConfigQuickbilling()));
      criteriaQBProduct.add(Restrictions.ne(SqbConfigProduct.PROPERTY_PRODUCT,
          sqbConfigQBProduct.getProduct()));

      List<SqbConfigProduct> sqbConfigProductList = criteriaQBProduct.list();
      if (sqbConfigProductList.size() >= 1) {
        OBDal.getInstance().rollbackAndClose();
        throw new OBException(Utility.messageBD(conn, "Sqb_ErrorProductQuickBilling", language));
      }
    }
  }

  public void onUpdate(@Observes EntityUpdateEvent event) {
    if (!isValidEvent(event)) {
      return;
    }
    final SqbConfigProduct sqbConfigQBProduct = (SqbConfigProduct) event.getTargetInstance();

    String language = OBContext.getOBContext().getLanguage().getLanguage();
    ConnectionProvider conn = new DalConnectionProvider(false);

    if (sqbConfigQBProduct.isDefault()) {

      // User userQB = OBDal.getInstance().get(User.class,
      // sqbConfigQBProduct.getCreatedBy().getId());

      // Contar Productos por defecto
      OBCriteria<SqbConfigProduct> criteriaQBProduct = OBDal.getInstance().createCriteria(
          SqbConfigProduct.class);
      criteriaQBProduct.add(Restrictions.eq(SqbConfigProduct.PROPERTY_ISDEFAULT, true));
      // criteriaQBProduct.add(Restrictions.eq(SqbConfigProduct.PROPERTY_CREATEDBY, userQB));
      criteriaQBProduct.add(Restrictions.eq(SqbConfigProduct.PROPERTY_SQBCONFIGQUICKBILLING,
          sqbConfigQBProduct.getSQBConfigQuickbilling()));
      criteriaQBProduct.add(Restrictions.ne(SqbConfigProduct.PROPERTY_PRODUCT,
          sqbConfigQBProduct.getProduct()));

      List<SqbConfigProduct> sqbConfigProductList = criteriaQBProduct.list();
      if (sqbConfigProductList.size() >= 1) {
        OBDal.getInstance().rollbackAndClose();
        throw new OBException(Utility.messageBD(conn, "Sqb_ErrorProductQuickBilling", language));
      }
    }
  }
}
