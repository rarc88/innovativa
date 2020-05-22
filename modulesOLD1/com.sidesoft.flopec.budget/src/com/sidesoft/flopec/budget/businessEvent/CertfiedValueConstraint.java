package com.sidesoft.flopec.budget.businessEvent;

import javax.enterprise.event.Observes;

import org.openbravo.base.exception.OBException;
import org.openbravo.base.model.Entity;
import org.openbravo.base.model.ModelProvider;
import org.openbravo.client.kernel.event.EntityNewEvent;
import org.openbravo.client.kernel.event.EntityPersistenceEventObserver;
import org.openbravo.client.kernel.event.EntityUpdateEvent;

import com.sidesoft.flopec.budget.data.SFBBudgetCertLine;

public class CertfiedValueConstraint extends EntityPersistenceEventObserver {
  private static Entity[] entities = { ModelProvider.getInstance().getEntity(
      SFBBudgetCertLine.ENTITY_NAME) };

  @Override
  protected Entity[] getObservedEntities() {
    // TODO Auto-generated method stub
    return entities;
  }

  public void onUpdate(@Observes EntityUpdateEvent event) {
    if (!isValidEvent(event)) {
      return;
    }
    final SFBBudgetCertLine certline = (SFBBudgetCertLine) event.getTargetInstance();
    validateNotNull(certline);
  }

  public void onSave(@Observes EntityNewEvent event) {
    if (!isValidEvent(event)) {
      return;
    }
    final SFBBudgetCertLine certline = (SFBBudgetCertLine) event.getTargetInstance();
    validateNotNull(certline);
  }

  private void validateNotNull(SFBBudgetCertLine certline) {
    if (certline.getCertifiedValue() == null) {
      throw new OBException("Certified Value cannot be null");
    }
  }
}
