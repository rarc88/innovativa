package com.sidesoft.flopec.budget.ad_Process;

import java.util.ArrayList;
import java.util.Date;
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

import com.sidesoft.flopec.budget.data.SFBBudgetLine;
import com.sidesoft.flopec.budget.data.SFBBudgetVersion;

public class CreateVersion extends DalBaseProcess {
  OBError message;

  @Override
  protected void doExecute(ProcessBundle bundle) throws Exception {
    String language = OBContext.getOBContext().getLanguage().getLanguage();
    ConnectionProvider conn = new DalConnectionProvider(false);
    String title = null;
    String msg = null;

    try {
      message = new OBError();
      processRequest(bundle);
      message.setType("Success");
      title = Utility.messageBD(conn, "ProcessOK", language);
      message.setTitle(title);
      msg = Utility.messageBD(conn, "SFB_VersionCreated", language);
      message.setMessage(msg);
    } catch (Exception e) {
      message.setMessage(e.getMessage());
      title = Utility.messageBD(conn, "Error", language);
      message.setTitle(title);
      message.setType("Error");
    } finally {
      bundle.setResult(message);
    }
  }

  private void processRequest(ProcessBundle bundle) {
    // TODO Auto-generated method stub

    String versionId = (String) bundle.getParams().get("SFB_Budget_Version_ID");
    SFBBudgetVersion version = OBDal.getInstance().get(SFBBudgetVersion.class, versionId);

    // Check if budget has been approved
    OBCriteria<SFBBudgetVersion> obcApprovedVersion = OBDal.getInstance().createCriteria(
        SFBBudgetVersion.class);
    obcApprovedVersion.add(Restrictions.eq(SFBBudgetVersion.PROPERTY_SFBBUDGET,
        version.getSFBBudget()));
    obcApprovedVersion.add(Restrictions.eq(SFBBudgetVersion.PROPERTY_VERSIONSTATUS, "AP"));

    if (obcApprovedVersion.count() > 0) {
      ConnectionProvider conn = new DalConnectionProvider(false);
      String language = OBContext.getOBContext().getLanguage().getLanguage();
      String error_msg = Utility.messageBD(conn, "SFB_AlreadyApprovedVersion", language);
      throw new OBException(error_msg);
    }

    SFBBudgetVersion newVersion = OBProvider.getInstance().get(SFBBudgetVersion.class);
    newVersion.setSFBBudget(version.getSFBBudget());
    newVersion.setOrganization(version.getOrganization());
    newVersion.setDateFrom(new Date());
    newVersion.setBaseVersion(version);
    newVersion.setVersionStatus("DR");
    OBDal.getInstance().save(newVersion);
    version.getSFBBudget().getSfbBudgetVersionList().add(newVersion);
    createBudgetLines(version, newVersion);
    OBDal.getInstance().flush(); // Budget version update must precede budget lines update in
                                 // order to prevent copied version update constraint.
    version.setProcessed(true);
    version.setVersionStatus("CP");
    OBDal.getInstance().save(version);
    OBDal.getInstance().flush();
  }

  private void createBudgetLines(SFBBudgetVersion version, SFBBudgetVersion newVersion) {
    List<SFBBudgetLine> budgetLineList = null;
    for (SFBBudgetLine budgetLine : version.getSfbBudgetLineList()) {
      SFBBudgetLine line = OBProvider.getInstance().get(SFBBudgetLine.class);
      line.setOrganization(version.getOrganization());

      line.setBudgetItem(budgetLine.getBudgetItem());
      line.setCostCenter(budgetLine.getCostCenter());
      line.setStDimension(budgetLine.getStDimension());
      line.setArea(budgetLine.getArea());
      line.setTBN(budgetLine.isTBN());
      if (budgetLine.getJANAvailableBalance() != null) {
        line.setJANAvailableBalance(budgetLine.getJANAvailableBalance());
      }
      if (budgetLine.getJANBudgetedValue() != null) {
        line.setJANBudgetedValue(budgetLine.getJANBudgetedValue());
      }
      if (budgetLine.getJANAdjustedValue() != null) {
        line.setJANAdjustedValue(budgetLine.getJANAdjustedValue());
      }
      if (budgetLine.getJANCommittedValue() != null) {
        line.setJANCommittedValue(budgetLine.getJANCommittedValue());
      }
      if (budgetLine.getJANActualValue() != null) {
        line.setJANActualValue(budgetLine.getJANActualValue());
      }
      if (budgetLine.getFEBAvailableBalance() != null) {
        line.setFEBAvailableBalance(budgetLine.getFEBAvailableBalance());
      }
      if (budgetLine.getFEBBudgetedValue() != null) {
        line.setFEBBudgetedValue(budgetLine.getFEBBudgetedValue());
      }
      if (budgetLine.getFEBAdjustedValue() != null) {
        line.setFEBAdjustedValue(budgetLine.getFEBAdjustedValue());
      }
      if (budgetLine.getFEBCommittedValue() != null) {
        line.setFEBCommittedValue(budgetLine.getFEBCommittedValue());
      }
      if (budgetLine.getFEBActualValue() != null) {
        line.setFEBActualValue(budgetLine.getFEBActualValue());
      }
      if (budgetLine.getMARAvailableBalance() != null) {
        line.setMARAvailableBalance(budgetLine.getMARAvailableBalance());
      }
      if (budgetLine.getMARBudgetedValue() != null) {
        line.setMARBudgetedValue(budgetLine.getMARBudgetedValue());
      }
      if (budgetLine.getMARAdjustedValue() != null) {
        line.setMARAdjustedValue(budgetLine.getMARAdjustedValue());
      }
      if (budgetLine.getMARCommittedValue() != null) {
        line.setMARCommittedValue(budgetLine.getMARCommittedValue());
      }
      if (budgetLine.getMARActualValue() != null) {
        line.setMARActualValue(budgetLine.getMARActualValue());
      }
      if (budgetLine.getAPRAvailableBalance() != null) {
        line.setAPRAvailableBalance(budgetLine.getAPRAvailableBalance());
      }
      if (budgetLine.getAPRBudgetedValue() != null) {
        line.setAPRBudgetedValue(budgetLine.getAPRBudgetedValue());
      }
      if (budgetLine.getAPRAdjustedValue() != null) {
        line.setAPRAdjustedValue(budgetLine.getAPRAdjustedValue());
      }
      if (budgetLine.getAPRCommittedValue() != null) {
        line.setAPRCommittedValue(budgetLine.getAPRCommittedValue());
      }
      if (budgetLine.getAPRActualValue() != null) {
        line.setAPRActualValue(budgetLine.getAPRActualValue());
      }
      if (budgetLine.getMAYAvailableBalance() != null) {
        line.setMAYAvailableBalance(budgetLine.getMAYAvailableBalance());
      }
      if (budgetLine.getMAYBudgetedValue() != null) {
        line.setMAYBudgetedValue(budgetLine.getMAYBudgetedValue());
      }
      if (budgetLine.getMAYAdjustedValue() != null) {
        line.setMAYAdjustedValue(budgetLine.getMAYAdjustedValue());
      }
      if (budgetLine.getMAYCommittedValue() != null) {
        line.setMAYCommittedValue(budgetLine.getMAYCommittedValue());
      }
      if (budgetLine.getMAYActualValue() != null) {
        line.setMAYActualValue(budgetLine.getMAYActualValue());
      }
      if (budgetLine.getJUNAvailableBalance() != null) {
        line.setJUNAvailableBalance(budgetLine.getJUNAvailableBalance());
      }
      if (budgetLine.getJUNBudgetedValue() != null) {
        line.setJUNBudgetedValue(budgetLine.getJUNBudgetedValue());
      }
      if (budgetLine.getJUNAdjustedValue() != null) {
        line.setJUNAdjustedValue(budgetLine.getJUNAdjustedValue());
      }
      if (budgetLine.getJUNCommittedValue() != null) {
        line.setJUNCommittedValue(budgetLine.getJUNCommittedValue());
      }
      if (budgetLine.getJUNActualValue() != null) {
        line.setJUNActualValue(budgetLine.getJUNActualValue());
      }
      if (budgetLine.getJULAvailableBalance() != null) {
        line.setJULAvailableBalance(budgetLine.getJULAvailableBalance());
      }
      if (budgetLine.getJULBudgetedValue() != null) {
        line.setJULBudgetedValue(budgetLine.getJULBudgetedValue());
      }
      if (budgetLine.getJULAdjustedValue() != null) {
        line.setJULAdjustedValue(budgetLine.getJULAdjustedValue());
      }
      if (budgetLine.getJULCommittedValue() != null) {
        line.setJULCommittedValue(budgetLine.getJULCommittedValue());
      }
      if (budgetLine.getJULActualValue() != null) {
        line.setJULActualValue(budgetLine.getJULActualValue());
      }
      if (budgetLine.getAUGAvailableBalance() != null) {
        line.setAUGAvailableBalance(budgetLine.getAUGAvailableBalance());
      }
      if (budgetLine.getAUGBudgetedValue() != null) {
        line.setAUGBudgetedValue(budgetLine.getAUGBudgetedValue());
      }
      if (budgetLine.getAUGAdjustedValue() != null) {
        line.setAUGAdjustedValue(budgetLine.getAUGAdjustedValue());
      }
      if (budgetLine.getAUGCommittedValue() != null) {
        line.setAUGCommittedValue(budgetLine.getAUGCommittedValue());
      }
      if (budgetLine.getAUGActualValue() != null) {
        line.setAUGActualValue(budgetLine.getAUGActualValue());
      }
      if (budgetLine.getSEPAvailableBalance() != null) {
        line.setSEPAvailableBalance(budgetLine.getSEPAvailableBalance());
      }
      if (budgetLine.getSEPBudgetedValue() != null) {
        line.setSEPBudgetedValue(budgetLine.getSEPBudgetedValue());
      }
      if (budgetLine.getSEPAdjustedValue() != null) {
        line.setSEPAdjustedValue(budgetLine.getSEPAdjustedValue());
      }
      if (budgetLine.getSEPCommittedValue() != null) {
        line.setSEPCommittedValue(budgetLine.getSEPCommittedValue());
      }
      if (budgetLine.getSEPActualValue() != null) {
        line.setSEPActualValue(budgetLine.getSEPActualValue());
      }
      if (budgetLine.getOCTAvailableBalance() != null) {
        line.setOCTAvailableBalance(budgetLine.getOCTAvailableBalance());
      }
      if (budgetLine.getOCTBudgetedValue() != null) {
        line.setOCTBudgetedValue(budgetLine.getOCTBudgetedValue());
      }
      if (budgetLine.getOCTAdjustedValue() != null) {
        line.setOCTAdjustedValue(budgetLine.getOCTAdjustedValue());
      }
      if (budgetLine.getOCTCommittedValue() != null) {
        line.setOCTCommittedValue(budgetLine.getOCTCommittedValue());
      }
      if (budgetLine.getOCTActualValue() != null) {
        line.setOCTActualValue(budgetLine.getOCTActualValue());
      }
      if (budgetLine.getNOVAvailableBalance() != null) {
        line.setNOVAvailableBalance(budgetLine.getNOVAvailableBalance());
      }
      if (budgetLine.getNOVBudgetedValue() != null) {
        line.setNOVBudgetedValue(budgetLine.getNOVBudgetedValue());
      }
      if (budgetLine.getNOVAdjustedValue() != null) {
        line.setNOVAdjustedValue(budgetLine.getNOVAdjustedValue());
      }
      if (budgetLine.getNOVCommittedValue() != null) {
        line.setNOVCommittedValue(budgetLine.getNOVCommittedValue());
      }
      if (budgetLine.getNOVActualValue() != null) {
        line.setNOVActualValue(budgetLine.getNOVActualValue());
      }
      if (budgetLine.getDECAvailableBalance() != null) {
        line.setDECAvailableBalance(budgetLine.getDECAvailableBalance());
      }
      if (budgetLine.getDECBudgetedValue() != null) {
        line.setDECBudgetedValue(budgetLine.getDECBudgetedValue());
      }
      if (budgetLine.getDECAdjustedValue() != null) {
        line.setDECAdjustedValue(budgetLine.getDECAdjustedValue());
      }
      if (budgetLine.getDECCommittedValue() != null) {
        line.setDECCommittedValue(budgetLine.getDECCommittedValue());
      }
      if (budgetLine.getDECActualValue() != null) {
        line.setDECActualValue(budgetLine.getDECActualValue());
      }
      if (newVersion.getSfbBudgetLineList() == null) {
        budgetLineList = new ArrayList<SFBBudgetLine>();
      } else {
        budgetLineList = newVersion.getSfbBudgetLineList();
      }

      line.setLineNo(new Long(budgetLineList.size() * 10 + 10));
      line.setSFBBudgetVersion(newVersion);
      budgetLine.setProcessed(true);
      OBDal.getInstance().save(budgetLine);
      budgetLineList.add(line);
      OBDal.getInstance().save(line);
    }

    OBDal.getInstance().save(newVersion);
  }

}
