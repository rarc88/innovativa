package ec.com.sidesoft.quick.billing.event;

import javax.enterprise.event.Observes;

import org.openbravo.base.ConfigParameters;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.model.Entity;
import org.openbravo.base.model.ModelProvider;
import org.openbravo.base.model.Property;
import org.openbravo.client.kernel.event.EntityNewEvent;
import org.openbravo.client.kernel.event.EntityPersistenceEventObserver;
import org.openbravo.client.kernel.event.EntityUpdateEvent;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.model.ad.utility.Sequence;
import org.openbravo.model.financialmgmt.tax.TaxRate;
import org.openbravo.service.db.DalConnectionProvider;

import ec.com.sidesoft.quick.billing.SqbQuickBilling;

public class Sqb_UpdateSequenceDocumentoEvent extends EntityPersistenceEventObserver {

  public static String dateTimeFormat;
  public static String sqlDateTimeFormat;
  public TaxRate taxRate;
  public String successMessage = null;
  public ConfigParameters cf;
  public String language;
  private static Entity[] entities = { ModelProvider.getInstance().getEntity(
      SqbQuickBilling.ENTITY_NAME) };

  @Override
  protected Entity[] getObservedEntities() {
    return entities;
  }

  public void onSave(@Observes EntityNewEvent event) {
    if (!isValidEvent(event)) {
      return;
    }

    final SqbQuickBilling SqbQB = (SqbQuickBilling) event.getTargetInstance();
    ConnectionProvider conn = new DalConnectionProvider(false);

    if (SqbQB.getDocumentno() != null) {

      String seqnumber = SqbQB.getDocumentno();

      if (seqnumber.matches("^<.+>$")) {

        String subseqnumber = seqnumber.substring(1, seqnumber.length() - 1);

        final Entity loansEntity = ModelProvider.getInstance().getEntity(
            SqbQuickBilling.ENTITY_NAME);
        final Property valueProperty = loansEntity.getProperty(SqbQuickBilling.PROPERTY_DOCUMENTNO);

        event.setCurrentState(valueProperty, subseqnumber);

      }

      Sequence sequence = SqbQB.getDoctype().getDocumentSequence();
      sequence.setNextAssignedNumber(sequence.getNextAssignedNumber() + sequence.getIncrementBy());
    }

    // Revisión de los datos del Tercero antes de guardar la información

    String strTaxid = SqbQB.getTaxid() == null ? "ND" : SqbQB.getTaxid();
    String strName = SqbQB.getName() == null ? "ND" : SqbQB.getName();
    String strAddress = SqbQB.getAddress() == null ? "ND" : SqbQB.getAddress();
    String strEmail = SqbQB.getEmail() == null ? "ND" : SqbQB.getEmail();

    if (!strTaxid.equals("ND")) {

      if (strName.equals("ND"))
        throw new OBException(Utility.messageBD(conn, "Sqb_ErrorNamePartner", language));

      if (strAddress.equals("ND"))
        throw new OBException(Utility.messageBD(conn, "Sqb_ErrorAddressPartner", language));

      if (strEmail.equals("ND"))
        throw new OBException(Utility.messageBD(conn, "Sqb_ErrorEmailPartner", language));
    } else {
      if (!strName.equals("ND") || !strAddress.equals("ND") || !strEmail.equals("ND")) {
        if (strTaxid.equals("ND")) {
          throw new OBException(Utility.messageBD(conn, "Sqb_ErrorTaxid", language));
        }

      }

    }
  }

  public void onUpdate(@Observes EntityUpdateEvent event) {
    if (!isValidEvent(event)) {
      return;
    }

    final SqbQuickBilling SqbQB = (SqbQuickBilling) event.getTargetInstance();
    ConnectionProvider conn = new DalConnectionProvider(false);

    // Revisión de los datos del Tercero antes de guardar la información

    String strTaxid = SqbQB.getTaxid() == null ? "ND" : SqbQB.getTaxid();
    String strName = SqbQB.getName() == null ? "ND" : SqbQB.getName();
    String strAddress = SqbQB.getAddress() == null ? "ND" : SqbQB.getAddress();
    String strEmail = SqbQB.getEmail() == null ? "ND" : SqbQB.getEmail();

    if (!strTaxid.equals("ND")) {

      if (strName.equals("ND"))
        throw new OBException(Utility.messageBD(conn, "Sqb_ErrorNamePartner", language));

      if (strAddress.equals("ND"))
        throw new OBException(Utility.messageBD(conn, "Sqb_ErrorAddressPartner", language));

      if (strEmail.equals("ND"))
        throw new OBException(Utility.messageBD(conn, "Sqb_ErrorEmailPartner", language));

    } else {
      if (!strName.equals("ND") || !strAddress.equals("ND") || !strEmail.equals("ND")) {
        if (strTaxid.equals("ND")) {
          throw new OBException(Utility.messageBD(conn, "Sqb_ErrorTaxid", language));
        }

      }

    }
  }

}
