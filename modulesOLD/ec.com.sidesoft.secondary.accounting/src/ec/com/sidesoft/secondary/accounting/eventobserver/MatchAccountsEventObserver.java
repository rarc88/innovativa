package ec.com.sidesoft.secondary.accounting.eventobserver;

import javax.enterprise.event.Observes;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.model.Entity;
import org.openbravo.base.model.ModelProvider;
import org.openbravo.client.kernel.event.EntityPersistenceEvent;
import org.openbravo.client.kernel.event.EntityPersistenceEventObserver;
import org.openbravo.client.kernel.event.EntityUpdateEvent;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.model.financialmgmt.accounting.coa.ElementValue;
import org.openbravo.service.db.DalConnectionProvider;

import ec.com.sidesoft.secondary.accounting.AccountingFactSecondary;
import ec.com.sidesoft.secondary.accounting.Ssacct_MatchAccounts;

public class MatchAccountsEventObserver extends EntityPersistenceEventObserver {

  private static Entity[] entities = { ModelProvider.getInstance().getEntity(
      Ssacct_MatchAccounts.ENTITY_NAME) };

  @Override
  protected Entity[] getObservedEntities() {
    return entities;
  }

  public void onUpdate(@Observes EntityUpdateEvent event) {
    if (!isValidEvent(event)) {
      return;
    }
    checkForExistTransaction(event);
  }

  private void checkForExistTransaction(final EntityPersistenceEvent event) {
    ConnectionProvider conn = new DalConnectionProvider(false);
    Ssacct_MatchAccounts MatchAccounts = (Ssacct_MatchAccounts) event.getTargetInstance();
    ElementValue account = MatchAccounts.getAccountIdDependent();

    Criterion acctExistTransactionRestrictions = Restrictions.eq(
        AccountingFactSecondary.PROPERTY_ACCOUNT, account);

    OBCriteria<AccountingFactSecondary> existCriteria = OBDal.getInstance().createCriteria(
        AccountingFactSecondary.class);

    existCriteria.add(acctExistTransactionRestrictions);

    existCriteria.setMaxResults(1);
    if (existCriteria.uniqueResult() != null) {
      throw new OBException(OBMessageUtils.messageBD("SSACCT_NOUpdateAccountDepen"));
    }

  }

}
