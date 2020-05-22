package ec.com.sidesoft.purchase.advanced.accounting.eventobserver;

import javax.enterprise.event.Observes;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.model.Entity;
import org.openbravo.base.model.ModelProvider;
import org.openbravo.client.kernel.event.EntityNewEvent;
import org.openbravo.client.kernel.event.EntityPersistenceEvent;
import org.openbravo.client.kernel.event.EntityPersistenceEventObserver;
import org.openbravo.client.kernel.event.EntityUpdateEvent;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.businesspartner.VendorAccounts;
import org.openbravo.model.financialmgmt.accounting.coa.AcctSchema;
import org.openbravo.service.db.DalConnectionProvider;

import com.sidesoft.flopec.budget.data.SFBBudgetItem;

public class VendorAccountsEventObserver extends EntityPersistenceEventObserver {
  private static Entity[] entities = { ModelProvider.getInstance().getEntity(
      VendorAccounts.ENTITY_NAME) };

  @Override
  protected Entity[] getObservedEntities() {
    return entities;
  }

  public void onSave(@Observes EntityNewEvent event) {
    if (!isValidEvent(event)) {
      return;
    }
    checkForDuplicates(event);
  }

  public void onUpdate(@Observes EntityUpdateEvent event) {
    if (!isValidEvent(event)) {
      return;
    }
    checkForDuplicates(event);
  }

  private void checkForDuplicates(final EntityPersistenceEvent event) {

    ConnectionProvider conn = new DalConnectionProvider(false);

    VendorAccounts target = (VendorAccounts) event.getTargetInstance();
    AcctSchema acctSchema = target.getAccountingSchema();
    BusinessPartner businessPartner = target.getBusinessPartner();
    SFBBudgetItem sFBBudgetItem = target.getSpaaBudgetItem();

    Criterion acctSchemaRestrictions = Restrictions.eq(VendorAccounts.PROPERTY_ACCOUNTINGSCHEMA,
        acctSchema);
    Criterion businessPartnerRestrictions = Restrictions.eq(
        VendorAccounts.PROPERTY_BUSINESSPARTNER, businessPartner);

    Criterion sFBBudgetItemRestrictions = null;
    Criterion sFBSpaaDefaultRestrictions = null;
    if (!target.isSpaaDefault()) {

      sFBBudgetItemRestrictions = (sFBBudgetItem == null) ? Restrictions
          .isNull(VendorAccounts.PROPERTY_SPAABUDGETITEM) : Restrictions.eq(
          VendorAccounts.PROPERTY_SPAABUDGETITEM, sFBBudgetItem);
    } else {
      sFBSpaaDefaultRestrictions = Restrictions.eq(VendorAccounts.PROPERTY_SPAADEFAULT,
          target.isSpaaDefault());
    }

    OBCriteria<VendorAccounts> existCriteria = OBDal.getInstance().createCriteria(
        VendorAccounts.class);

    if (event instanceof EntityNewEvent) {
      existCriteria.add(Restrictions.and(Restrictions.and(acctSchemaRestrictions,
          businessPartnerRestrictions),
          sFBBudgetItemRestrictions == null ? sFBSpaaDefaultRestrictions
              : sFBBudgetItemRestrictions));

    } else {
      existCriteria.add(Restrictions.and(
          Restrictions.ne(VendorAccounts.PROPERTY_ID, target.getId()), Restrictions.and(
              Restrictions.and(acctSchemaRestrictions, businessPartnerRestrictions),
              sFBBudgetItemRestrictions == null ? sFBSpaaDefaultRestrictions
                  : sFBBudgetItemRestrictions)));
    }

    existCriteria.setMaxResults(1);
    if (existCriteria.uniqueResult() != null) {
      if (sFBBudgetItemRestrictions != null) {
        throw new OBException(OBMessageUtils.messageBD("SPAA_VendorAccountsDuplicate"));
      } else {
        throw new OBException(OBMessageUtils.messageBD("SPAA_DefaultConfig"));
      }
    }
  }

}
