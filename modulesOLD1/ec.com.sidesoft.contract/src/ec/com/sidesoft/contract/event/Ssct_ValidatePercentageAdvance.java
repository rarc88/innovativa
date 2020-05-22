package ec.com.sidesoft.contract.event;

import java.util.List;

import javax.enterprise.event.Observes;
import javax.servlet.ServletException;

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

import ec.com.sidesoft.contract.ssctadvance;
import ec.com.sidesoft.contract.ssctcontract;

public class Ssct_ValidatePercentageAdvance extends EntityPersistenceEventObserver {

  private static Entity[] entities = { ModelProvider.getInstance().getEntity(
      ssctadvance.ENTITY_NAME) };

  @Override
  protected Entity[] getObservedEntities() {
    return entities;
  }

  public void onSave(@Observes EntityNewEvent event) {
    if (!isValidEvent(event)) {
      return;
    }

    final ssctadvance SsctAdvance = (ssctadvance) event.getTargetInstance();

    ReturnQuerySave(SsctAdvance);

  }

  public void onUpdate(@Observes EntityUpdateEvent event) throws ServletException {
    if (!isValidEvent(event)) {
      return;
    }

    final ssctadvance SsctAdvance = (ssctadvance) event.getTargetInstance();

    ReturnQueryUpdate(SsctAdvance);
  }

  private void ReturnQuerySave(ssctadvance Strserach) {
    ConnectionProvider conn = new DalConnectionProvider(false);
    String language = OBContext.getOBContext().getLanguage().getLanguage();

    long lngAdvance = Strserach.getAdvance();
    String StrContractID = Strserach.getContract().getId();

    ssctcontract SsctContractObject = OBDal.getInstance().get(ssctcontract.class, StrContractID);

    OBCriteria<ssctadvance> AdvanceCriteria = OBDal.getInstance().createCriteria(ssctadvance.class);
    AdvanceCriteria.add(Restrictions.eq(ssctadvance.PROPERTY_CONTRACT, SsctContractObject));
    List<ssctadvance> AdvanceCriteriaList = AdvanceCriteria.list();
    long lngAdvanceSum = 0;
    if (AdvanceCriteriaList.size() > 0) {
      for (ssctadvance ListAdvance : AdvanceCriteriaList) {
        lngAdvanceSum = lngAdvanceSum + ListAdvance.getAdvance();
      }
      lngAdvanceSum = lngAdvanceSum + lngAdvance;
      if (lngAdvanceSum > 100) {
        throw new OBException(Utility.messageBD(conn, "@Ssct_ValidatePercentage@", language));
      }
    }

  }

  private void ReturnQueryUpdate(ssctadvance Strserach) {
    ConnectionProvider conn = new DalConnectionProvider(false);
    String language = OBContext.getOBContext().getLanguage().getLanguage();

    @SuppressWarnings("unused")
    long lngAdvance = Strserach.getAdvance();
    String StrContractID = Strserach.getContract().getId();

    ssctcontract SsctContractObject = OBDal.getInstance().get(ssctcontract.class, StrContractID);

    OBCriteria<ssctadvance> AdvanceCriteria = OBDal.getInstance().createCriteria(ssctadvance.class);
    AdvanceCriteria.add(Restrictions.eq(ssctadvance.PROPERTY_CONTRACT, SsctContractObject));
    List<ssctadvance> AdvanceCriteriaList = AdvanceCriteria.list();
    long lngAdvanceSum = 0;
    if (AdvanceCriteriaList.size() > 0) {
      for (ssctadvance ListAdvance : AdvanceCriteriaList) {
        lngAdvanceSum = lngAdvanceSum + ListAdvance.getAdvance();
      }
      if (lngAdvanceSum > 100) {
        throw new OBException(Utility.messageBD(conn, "@Ssct_ValidatePercentage@", language));
      }
    }

  }
}
