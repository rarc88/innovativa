package com.sidesoft.ecuador.asset.allocation.event;

import javax.enterprise.event.Observes;

import org.openbravo.base.model.Entity;
import org.openbravo.base.model.ModelProvider;
import org.openbravo.base.model.Property;
import org.openbravo.client.kernel.event.EntityNewEvent;
import org.openbravo.client.kernel.event.EntityPersistenceEventObserver;
import org.openbravo.model.ad.utility.Sequence;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;

public class UpdateSequenceNumberEvent extends EntityPersistenceEventObserver {

  private static Entity[] entities = { ModelProvider.getInstance().getEntity(Asset.ENTITY_NAME) };

  @Override
  protected Entity[] getObservedEntities() {
    return entities;
  }

  public void onSave(@Observes EntityNewEvent event) {
    if (!isValidEvent(event)) {
      return;
    }

    final Asset Assetobj = (Asset) event.getTargetInstance();

    if (Assetobj.getDocumentNo() != null) {

      String seqnumber = Assetobj.getDocumentNo();

      if (seqnumber.matches("^<.+>$")) {

        String subseqnumber = seqnumber.substring(1, seqnumber.length() - 1);

        final Entity loansEntity = ModelProvider.getInstance().getEntity(Asset.ENTITY_NAME);
        final Property valueProperty = loansEntity.getProperty(Asset.PROPERTY_DOCUMENTNO);

        event.setCurrentState(valueProperty, subseqnumber);

      }

      if (Assetobj.getSsalCDoctype() != null && Assetobj.getSsalCDoctype().isSequencedDocument()) {
        Sequence sequence = Assetobj.getSsalCDoctype().getDocumentSequence();
        if (sequence != null && sequence.isAutoNumbering()) {
          sequence.setNextAssignedNumber(sequence.getNextAssignedNumber()
              + sequence.getIncrementBy());

        }
      }
    }

  }
}
