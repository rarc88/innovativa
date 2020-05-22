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
import org.openbravo.model.ad.access.User;
import org.openbravo.service.db.DalConnectionProvider;

import ec.com.sidesoft.quick.billing.SqbConfigQuickBilling;
import ec.com.sidesoft.quick.billing.SqbConfigUser;

public class Sqb_ConfigUserEvent extends EntityPersistenceEventObserver {
  private static Entity[] entities = { ModelProvider.getInstance().getEntity(
      SqbConfigUser.ENTITY_NAME) };

  @Override
  protected Entity[] getObservedEntities() {
    return entities;
  }

  public void onSave(@Observes EntityNewEvent event) {
    if (!isValidEvent(event)) {
      return;
    }

    final SqbConfigUser sqbConfigQBUser = (SqbConfigUser) event.getTargetInstance();

    String language = OBContext.getOBContext().getLanguage().getLanguage();
    ConnectionProvider conn = new DalConnectionProvider(false);

    if (sqbConfigQBUser.isActive()) {
      User userQB = OBDal.getInstance().get(User.class, sqbConfigQBUser.getUser().getId());

      SqbConfigQuickBilling obdalConfigQB = OBDal.getInstance().get(SqbConfigQuickBilling.class,
          sqbConfigQBUser.getSQBConfigQuickbilling().getId());

      // Revisa si el usuario ya existe en otra configuración con estado activo
      OBCriteria<SqbConfigUser> criteriaQBUser = OBDal.getInstance().createCriteria(
          SqbConfigUser.class);
      criteriaQBUser.add(Restrictions.eq(SqbConfigUser.PROPERTY_ACTIVE, true));
      criteriaQBUser.add(Restrictions.eq(SqbConfigUser.PROPERTY_USER, userQB));
      criteriaQBUser.add(Restrictions.ne(SqbConfigUser.PROPERTY_SQBCONFIGQUICKBILLING,
          obdalConfigQB));

      List<SqbConfigUser> sqbConfigProductList = criteriaQBUser.list();
      if (sqbConfigProductList.size() >= 1) {
        OBDal.getInstance().rollbackAndClose();
        throw new OBException(Utility.messageBD(conn, "Sqb_ValidateUser", language));
      }
    }
  }

  public void onUpdate(@Observes EntityUpdateEvent event) {
    if (!isValidEvent(event)) {
      return;
    }
    final SqbConfigUser sqbConfigQBUser = (SqbConfigUser) event.getTargetInstance();

    String language = OBContext.getOBContext().getLanguage().getLanguage();
    ConnectionProvider conn = new DalConnectionProvider(false);

    if (sqbConfigQBUser.isActive()) {
      User userQB = OBDal.getInstance().get(User.class, sqbConfigQBUser.getUser().getId());

      SqbConfigQuickBilling obdalConfigQB = OBDal.getInstance().get(SqbConfigQuickBilling.class,
          sqbConfigQBUser.getSQBConfigQuickbilling().getId());

      // Contar Productos por defecto
      OBCriteria<SqbConfigUser> criteriaQBUser = OBDal.getInstance().createCriteria(
          SqbConfigUser.class);
      criteriaQBUser.add(Restrictions.eq(SqbConfigUser.PROPERTY_ACTIVE, true));
      criteriaQBUser.add(Restrictions.eq(SqbConfigUser.PROPERTY_USER, userQB));
      criteriaQBUser.add(Restrictions.ne(SqbConfigUser.PROPERTY_SQBCONFIGQUICKBILLING,
          obdalConfigQB));

      List<SqbConfigUser> sqbConfigProductList = criteriaQBUser.list();
      if (sqbConfigProductList.size() >= 1) {
        OBDal.getInstance().rollbackAndClose();
        throw new OBException(Utility.messageBD(conn, "Sqb_ValidateUser", language));
      }
    }
  }
}
