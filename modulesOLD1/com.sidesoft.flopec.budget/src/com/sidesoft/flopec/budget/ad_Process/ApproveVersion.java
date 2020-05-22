package com.sidesoft.flopec.budget.ad_Process;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.DalBaseProcess;
import org.openbravo.service.db.DalConnectionProvider;

import com.sidesoft.flopec.budget.data.SFBBudgetConfiguration;
import com.sidesoft.flopec.budget.data.SFBBudgetLine;
import com.sidesoft.flopec.budget.data.SFBBudgetVersion;

public class ApproveVersion extends DalBaseProcess {
  OBError message;

  @Override
  protected void doExecute(ProcessBundle bundle) throws Exception {
    try {
      message = new OBError();
      processRequest(bundle);
    } catch (Exception e) {
      String language = OBContext.getOBContext().getLanguage().getLanguage();
      ConnectionProvider conn = new DalConnectionProvider(false);

      message.setMessage(e.getMessage());
      message.setTitle(Utility.messageBD(conn, "Error", language));
      message.setType("Error");
    } finally {
      bundle.setResult(message);
    }
  }

  private void processRequest(ProcessBundle bundle) {
    String versionId = (String) bundle.getParams().get("SFB_Budget_Version_ID");
    SFBBudgetVersion version = OBDal.getInstance().get(SFBBudgetVersion.class, versionId);
    OBCriteria<SFBBudgetVersion> budgetVersionCriteria = OBDal.getInstance().createCriteria(
        SFBBudgetVersion.class);
    budgetVersionCriteria.add(Restrictions.eq(SFBBudgetVersion.PROPERTY_SFBBUDGET,
        version.getSFBBudget()));
    budgetVersionCriteria.add(Restrictions.eq(SFBBudgetVersion.PROPERTY_VERSIONSTATUS, "AP"));
    List<SFBBudgetVersion> budgetVersionCriteriaList = budgetVersionCriteria.list();

    String language = OBContext.getOBContext().getLanguage().getLanguage();
    ConnectionProvider conn = new DalConnectionProvider(false);

    if (budgetVersionCriteriaList.isEmpty()) {
      // Add new Exchange Difference line

      // Get Budget Configuration
      OBCriteria<SFBBudgetConfiguration> budgetConfigurationCriteria = OBDal.getInstance()
          .createCriteria(SFBBudgetConfiguration.class);
      budgetConfigurationCriteria.add(Restrictions.eq(SFBBudgetConfiguration.PROPERTY_CLIENT,
          version.getClient()));
      budgetConfigurationCriteria.add(Restrictions.eq(SFBBudgetConfiguration.PROPERTY_ORGANIZATION,
          version.getOrganization()));
      List<SFBBudgetConfiguration> budgetConfigurationCriteriaList = budgetConfigurationCriteria
          .list();

      if (budgetConfigurationCriteriaList.isEmpty()) {
        String error_msg = Utility.messageBD(conn, "SFB_NoBudgetConfiguration", language);
        throw new OBException(error_msg);
      }

      SFBBudgetConfiguration configuration = budgetConfigurationCriteriaList.get(0);

      SFBBudgetLine line = OBProvider.getInstance().get(SFBBudgetLine.class);
      line.setOrganization(version.getOrganization());
      line.setBudgetItem(configuration.getBudgetItem());
      line.setCostCenter(configuration.getCostCenter());
      line.setStDimension(configuration.getStDimension());
      line.setExchange(true);
      line.setLineNo(new Long(version.getSfbBudgetLineList().size() * 10 + 10));
      line.setSFBBudgetVersion(version);
      line.setArea(configuration.getArea());
      version.getSfbBudgetLineList().add(line);
      OBDal.getInstance().save(line);

      // Approve Version
      version.setVersionStatus("AP");
      version.getSFBBudget().setBudgetStatus("AP");
      message.setMessage(Utility.messageBD(conn, "SFB_VersionApproved", language));
      message.setType("Success");
      message.setTitle(Utility.messageBD(conn, "ProcessOK", language));
      OBDal.getInstance().save(version);
      OBDal.getInstance().flush();
    } else {
      String error_msg = Utility.messageBD(conn, "SFB_AlreadyApprovedVersion", language);
      throw new OBException(error_msg);
    }
  }
}
