package com.sidesoft.flopec.budget.businessEvent;

import javax.enterprise.event.Observes;

import org.openbravo.base.exception.OBException;
import org.openbravo.base.model.Entity;
import org.openbravo.base.model.ModelProvider;
import org.openbravo.client.kernel.event.EntityPersistenceEventObserver;
import org.openbravo.client.kernel.event.EntityUpdateEvent;
import org.openbravo.dal.core.OBContext;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.service.db.DalConnectionProvider;

import com.sidesoft.flopec.budget.data.SFBBudgetVersion;

public class ValidateDateFrom extends EntityPersistenceEventObserver {
  private static Entity[] entities = { ModelProvider.getInstance().getEntity(
      SFBBudgetVersion.ENTITY_NAME) };

  @Override
  protected Entity[] getObservedEntities() {
    // TODO Auto-generated method stub
    return entities;
  }

  public void onUpdate(@Observes EntityUpdateEvent event) {
    if (!isValidEvent(event)) {
      return;
    }
    final SFBBudgetVersion newVesrion = (SFBBudgetVersion) event.getTargetInstance();
    if (newVesrion.getBaseVersion() != null) {
      validateDateFrom(newVesrion);
    }
  }

  private void validateDateFrom(SFBBudgetVersion newVesrion) {
    ConnectionProvider conn = new DalConnectionProvider(false);
    String language = OBContext.getOBContext().getLanguage().getLanguage();

    if (newVesrion.getDateFrom().compareTo(newVesrion.getBaseVersion().getDateFrom()) < 1) {
      throw new OBException(Utility.messageBD(conn, "SFB_VersionDateFrom", language));
    }
  }
}
