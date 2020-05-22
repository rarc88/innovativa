package ec.com.sidesoft.localization.ecuador.viatical.budget;

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
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.model.common.enterprise.Organization;

import com.sidesoft.flopec.budget.data.SFBBudgetItem;
import com.sidesoft.hrm.payroll.ssprcategoryacct;

import ec.com.sidesoft.localization.ecuador.viatical.SsveViaticalConfigAcct;

public class ViaticalConfigAcctEventObserver extends EntityPersistenceEventObserver {
  private static Entity[] entities = { ModelProvider.getInstance().getEntity(
      SsveViaticalConfigAcct.ENTITY_NAME) };

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
    SsveViaticalConfigAcct viaticalConfigAcct = (SsveViaticalConfigAcct) event.getTargetInstance();
    Organization organization = viaticalConfigAcct.getOrganization();
    String viaticalAccountingType = viaticalConfigAcct.getViaticalAccountingType();
    boolean isSvtbAccountingbudget = viaticalConfigAcct.isSvtbAccountingbudget();
    ssprcategoryacct ssprCategoryAcct = viaticalConfigAcct.getAccountingCategory();
    SFBBudgetItem budgetItem = viaticalConfigAcct.getSvtbBudgetItem();

    Criterion organizationCriterion = Restrictions.eq(viaticalConfigAcct.PROPERTY_ORGANIZATION,
        organization);
    Criterion viaticalAccountingTypeCriterion = Restrictions.eq(
        viaticalConfigAcct.PROPERTY_VIATICALACCOUNTINGTYPE, viaticalAccountingType);
    Criterion isSvtbAccountingbudgetCriterion = Restrictions.eq(
        viaticalConfigAcct.PROPERTY_SVTBACCOUNTINGBUDGET, isSvtbAccountingbudget);
    Criterion ssprCategoryAcctCriterion = Restrictions.eq(
        viaticalConfigAcct.PROPERTY_ACCOUNTINGCATEGORY, ssprCategoryAcct);
    Criterion budgetItemCriterion = Restrictions.eq(viaticalConfigAcct.PROPERTY_SVTBBUDGETITEM,
        budgetItem);

    OBCriteria<SsveViaticalConfigAcct> existCriteria = OBDal.getInstance().createCriteria(
        SsveViaticalConfigAcct.class);

    if (event instanceof EntityNewEvent) {
      existCriteria.add(Restrictions.and(Restrictions.and(
          isSvtbAccountingbudget == true ? Restrictions.and(isSvtbAccountingbudgetCriterion,
              budgetItemCriterion) : Restrictions.and(isSvtbAccountingbudgetCriterion,
              ssprCategoryAcctCriterion), viaticalAccountingTypeCriterion), organizationCriterion));

    } else {
      existCriteria
          .add(Restrictions.and(Restrictions.ne(SsveViaticalConfigAcct.PROPERTY_ID,
              viaticalConfigAcct.getId()), Restrictions.and(Restrictions.and(
              isSvtbAccountingbudget == true ? Restrictions.and(isSvtbAccountingbudgetCriterion,
                  budgetItemCriterion) : Restrictions.and(isSvtbAccountingbudgetCriterion,
                  ssprCategoryAcctCriterion), viaticalAccountingTypeCriterion),
              organizationCriterion)));
    }

    existCriteria.setMaxResults(1);
    if (existCriteria.uniqueResult() != null) {
      throw new OBException(OBMessageUtils.messageBD("SVTB_ViaticalConfigAcctDuplicate"));
    }

  }
}
