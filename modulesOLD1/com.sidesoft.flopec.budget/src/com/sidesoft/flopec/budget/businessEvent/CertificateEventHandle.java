package com.sidesoft.flopec.budget.businessEvent;

import java.util.List;

import javax.enterprise.event.Observes;

import org.hibernate.criterion.Restrictions;
import org.openbravo.base.model.Entity;
import org.openbravo.base.model.ModelProvider;
import org.openbravo.base.model.Property;
import org.openbravo.client.kernel.event.EntityNewEvent;
import org.openbravo.client.kernel.event.EntityPersistenceEventObserver;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;

import com.sidesoft.flopec.budget.data.SFBBudgetCertificate;

public class CertificateEventHandle extends EntityPersistenceEventObserver {
  private static Entity[] entities = { ModelProvider.getInstance().getEntity(
      SFBBudgetCertificate.ENTITY_NAME) };

  private String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

  @Override
  protected Entity[] getObservedEntities() {
    // TODO Auto-generated method stub
    return entities;
  }

  public void onSave(@Observes EntityNewEvent event) {
    if (!isValidEvent(event)) {
      return;
    }
    final Entity CertificateEntity = ModelProvider.getInstance().getEntity(
        SFBBudgetCertificate.ENTITY_NAME);
    final Property CertificateHashcodeProperty = CertificateEntity
        .getProperty(SFBBudgetCertificate.PROPERTY_HASHCODE);

    event.setCurrentState(CertificateHashcodeProperty, getHashCode());

  }

  private String getHashCode() {
    String hashcode = randomAlphaNumeric(10);
    while (true) {
      OBCriteria<SFBBudgetCertificate> certificateCritria = OBDal.getInstance().createCriteria(
          SFBBudgetCertificate.class);
      certificateCritria.add(Restrictions.eq(SFBBudgetCertificate.PROPERTY_HASHCODE, hashcode));
      List<SFBBudgetCertificate> certificateCriteriaList = certificateCritria.list();
      if (certificateCriteriaList.isEmpty()) {
        break;
      } else {
        hashcode = randomAlphaNumeric(8);
      }
    }

    return hashcode;
  }

  public String randomAlphaNumeric(int count) {
    StringBuilder builder = new StringBuilder();
    while (count-- != 0) {
      int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
      builder.append(ALPHA_NUMERIC_STRING.charAt(character));
    }
    return builder.toString();
  }
}