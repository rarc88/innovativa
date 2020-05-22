package com.sidesoft.flopec.budget.ad_Process;

import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.DalBaseProcess;
import org.openbravo.service.db.DalConnectionProvider;

import com.sidesoft.flopec.budget.data.SFBBudget;
import com.sidesoft.flopec.budget.data.SFBBudgetLine;
import com.sidesoft.flopec.budget.data.SFBBudgetLog;
import com.sidesoft.flopec.budget.data.SFBBudgetVersion;

public class ProcessLog extends DalBaseProcess {
  OBError message;
  boolean saveBudgetLineFrom;

  @Override
  protected void doExecute(ProcessBundle bundle) throws Exception {
    String language = OBContext.getOBContext().getLanguage().getLanguage();
    ConnectionProvider conn = new DalConnectionProvider(false);

    try {
      message = new OBError();
      processRequest(bundle);
    } catch (Exception e) {
      message.setTitle(Utility.messageBD(conn, "Error", language));
      message.setType("Error");
      message.setMessage(e.getMessage());
    } finally {
      bundle.setResult(message);
    }
    // Y process, N unprocess Status
  }

  private void processRequest(ProcessBundle bundle) {
    String logId = (String) bundle.getParams().get("SFB_Budget_Log_ID");
    SFBBudgetLog log = OBDal.getInstance().get(SFBBudgetLog.class, logId);

    String language = OBContext.getOBContext().getLanguage().getLanguage();
    ConnectionProvider conn = new DalConnectionProvider(false);
    String successMessage = null;

    SFBBudgetLine budgetLineFrom = null;

    if (log.getProcess().equals("N")) {

      // If movement
      if (log.getType().equals("M")) {
        // Find any budget line that match From Budget Item
        OBCriteria<SFBBudgetLine> obcBudgetLineFrom = OBDal.getInstance().createCriteria(
            SFBBudgetLine.class);
        obcBudgetLineFrom.add(Restrictions.eq(SFBBudgetLine.PROPERTY_CLIENT, log.getClient()));
        obcBudgetLineFrom.add(Restrictions.eq(SFBBudgetLine.PROPERTY_ORGANIZATION,
            log.getOrganization()));
        obcBudgetLineFrom.add(Restrictions.eq(SFBBudgetLine.PROPERTY_COSTCENTER,
            log.getCostCenter()));
        obcBudgetLineFrom.add(Restrictions.eq(SFBBudgetLine.PROPERTY_STDIMENSION,
            log.getStDimension()));
        obcBudgetLineFrom.add(Restrictions.eq(SFBBudgetLine.PROPERTY_BUDGETITEM,
            log.getBudgetItemFrom()));
        obcBudgetLineFrom.add(Restrictions.eq(SFBBudgetLine.PROPERTY_AREA, log.getArea()));
        obcBudgetLineFrom.add(Restrictions.ge(SFBBudgetLine.PROPERTY_AVAILABLEBALANCE,
            log.getValue()));

        obcBudgetLineFrom.createAlias(SFBBudgetLine.PROPERTY_SFBBUDGETVERSION, "version");
        obcBudgetLineFrom.add(Restrictions.eq("version." + SFBBudgetVersion.PROPERTY_VERSIONSTATUS,
            "AP"));

        obcBudgetLineFrom.createAlias("version." + SFBBudgetVersion.PROPERTY_SFBBUDGET, "budget");
        obcBudgetLineFrom.add(Restrictions.eq("budget." + SFBBudget.PROPERTY_TYPEOFBUDGET,
            log.getTypeOfBudget()));
        obcBudgetLineFrom.add(Restrictions.eq("budget." + SFBBudget.PROPERTY_YEAR, log.getYear()));

        // If not found
        if (obcBudgetLineFrom.count() == 0) {
          OBDal.getInstance().rollbackAndClose();
          throw new OBException(Utility.messageBD(conn, "SFB_NoFromBudgetItem", language));
        } else {
          Object o = obcBudgetLineFrom.list().get(0);
          Object[] os = (Object[]) o;
          budgetLineFrom = (SFBBudgetLine) os[2];

          switch (Integer.parseInt(log.getFromMonth())) {
          case 0:
            budgetLineFrom.setJANAdjustedValue(budgetLineFrom.getJANAdjustedValue().subtract(
                log.getValue()));
            break;
          case 1:
            budgetLineFrom.setFEBAdjustedValue(budgetLineFrom.getFEBAdjustedValue().subtract(
                log.getValue()));
            break;
          case 2:
            budgetLineFrom.setMARAdjustedValue(budgetLineFrom.getMARAdjustedValue().subtract(
                log.getValue()));
            break;
          case 3:
            budgetLineFrom.setAPRAdjustedValue(budgetLineFrom.getAPRAdjustedValue().subtract(
                log.getValue()));
            break;
          case 4:
            budgetLineFrom.setMAYAdjustedValue(budgetLineFrom.getMAYAdjustedValue().subtract(
                log.getValue()));
            break;
          case 5:
            budgetLineFrom.setJUNAdjustedValue(budgetLineFrom.getJUNAdjustedValue().subtract(
                log.getValue()));
            break;
          case 6:
            budgetLineFrom.setJULAdjustedValue(budgetLineFrom.getJULAdjustedValue().subtract(
                log.getValue()));
            break;
          case 7:
            budgetLineFrom.setAUGAdjustedValue(budgetLineFrom.getAUGAdjustedValue().subtract(
                log.getValue()));
            break;
          case 8:
            budgetLineFrom.setSEPAdjustedValue(budgetLineFrom.getSEPAdjustedValue().subtract(
                log.getValue()));
            break;
          case 9:
            budgetLineFrom.setOCTAdjustedValue(budgetLineFrom.getOCTAdjustedValue().subtract(
                log.getValue()));
            break;
          case 10:
            budgetLineFrom.setNOVAdjustedValue(budgetLineFrom.getNOVAdjustedValue().subtract(
                log.getValue()));
            break;
          case 11:
            budgetLineFrom.setDECAdjustedValue(budgetLineFrom.getDECAdjustedValue().subtract(
                log.getValue()));
            break;
          }

          // OBDal.getInstance().save(budgetLineFrom);
          saveBudgetLineFrom = true;

        }
      }

      // Find any budget line that match To Budget Item
      OBCriteria<SFBBudgetLine> obcBudgetLineTo = OBDal.getInstance().createCriteria(
          SFBBudgetLine.class);
      obcBudgetLineTo.add(Restrictions.eq(SFBBudgetLine.PROPERTY_CLIENT, log.getClient()));
      obcBudgetLineTo.add(Restrictions.eq(SFBBudgetLine.PROPERTY_ORGANIZATION,
          log.getOrganization()));
      obcBudgetLineTo.add(Restrictions.eq(SFBBudgetLine.PROPERTY_COSTCENTER, log.getCostCenter()));
      obcBudgetLineTo
          .add(Restrictions.eq(SFBBudgetLine.PROPERTY_STDIMENSION, log.getStDimension()));
      obcBudgetLineTo
          .add(Restrictions.eq(SFBBudgetLine.PROPERTY_BUDGETITEM, log.getBudgetItemTo()));
      obcBudgetLineTo.add(Restrictions.eq(SFBBudgetLine.PROPERTY_AREA, log.getArea()));

      obcBudgetLineTo.createAlias(SFBBudgetLine.PROPERTY_SFBBUDGETVERSION, "version");
      obcBudgetLineTo.add(Restrictions.eq("version." + SFBBudgetVersion.PROPERTY_VERSIONSTATUS,
          "AP"));

      obcBudgetLineTo.createAlias("version." + SFBBudgetVersion.PROPERTY_SFBBUDGET, "budget");
      obcBudgetLineTo.add(Restrictions.eq("budget." + SFBBudget.PROPERTY_TYPEOFBUDGET,
          log.getTypeOfBudget()));
      obcBudgetLineTo.add(Restrictions.eq("budget." + SFBBudget.PROPERTY_YEAR, log.getYear()));

      if (log.getType().equals("S")) {
          if (log.getTypeOfOperation().equals("L")) {
      obcBudgetLineTo.add(Restrictions.ge(SFBBudgetLine.PROPERTY_AVAILABLEBALANCE, log.getValue()));
      }}


      if (log.getType().equals("M")) {

        // If not found
        if (obcBudgetLineTo.count() == 0) {
          OBDal.getInstance().rollbackAndClose();
          throw new OBException(Utility.messageBD(conn, "SFB_NoToBudgetItem", language));
        } else {
          Object o = obcBudgetLineTo.list().get(0);
          Object[] os = (Object[]) o;
          SFBBudgetLine budgetLineTo = (SFBBudgetLine) os[2];

          switch (Integer.parseInt(log.getToMonth())) {
          case 0:
            budgetLineTo
                .setJANAdjustedValue(budgetLineTo.getJANAdjustedValue().add(log.getValue()));
            break;
          case 1:
            budgetLineTo
                .setFEBAdjustedValue(budgetLineTo.getFEBAdjustedValue().add(log.getValue()));
            break;
          case 2:
            budgetLineTo
                .setMARAdjustedValue(budgetLineTo.getMARAdjustedValue().add(log.getValue()));
            break;
          case 3:
            budgetLineTo
                .setAPRAdjustedValue(budgetLineTo.getAPRAdjustedValue().add(log.getValue()));
            break;
          case 4:
            budgetLineTo
                .setMAYAdjustedValue(budgetLineTo.getMAYAdjustedValue().add(log.getValue()));
            break;
          case 5:
            budgetLineTo
                .setJUNAdjustedValue(budgetLineTo.getJUNAdjustedValue().add(log.getValue()));
            break;
          case 6:
            budgetLineTo
                .setJULAdjustedValue(budgetLineTo.getJULAdjustedValue().add(log.getValue()));
            break;
          case 7:
            budgetLineTo
                .setAUGAdjustedValue(budgetLineTo.getAUGAdjustedValue().add(log.getValue()));
            break;
          case 8:
            budgetLineTo
                .setSEPAdjustedValue(budgetLineTo.getSEPAdjustedValue().add(log.getValue()));
            break;
          case 9:
            budgetLineTo
                .setOCTAdjustedValue(budgetLineTo.getOCTAdjustedValue().add(log.getValue()));
            break;
          case 10:
            budgetLineTo
                .setNOVAdjustedValue(budgetLineTo.getNOVAdjustedValue().add(log.getValue()));
            break;
          case 11:
            budgetLineTo
                .setDECAdjustedValue(budgetLineTo.getDECAdjustedValue().add(log.getValue()));
            break;
          }

          OBDal.getInstance().save(budgetLineTo);
          if (saveBudgetLineFrom || budgetLineFrom != null) {
            OBDal.getInstance().save(budgetLineFrom);
          }

          log.setProcess("Y");
          successMessage = "SFB_LogProcessed";
        }
      } else if (log.getType().equals("S")) {
        if (obcBudgetLineTo.count() == 0) {
          OBDal.getInstance().rollbackAndClose();
          throw new OBException(Utility.messageBD(conn, "SFB_NoToBudgetItem", language));
        } else {

          Object o = obcBudgetLineTo.list().get(0);
          Object[] os = (Object[]) o;
          SFBBudgetLine budgetLineTo = (SFBBudgetLine) os[2];

          if (log.getTypeOfOperation().equals("S")) {

            switch (Integer.parseInt(log.getToMonth())) {
            case 0:
              budgetLineTo.setJANAdjustedValue(budgetLineTo.getJANAdjustedValue().add(
                  log.getValue()));
              break;
            case 1:
              budgetLineTo.setFEBAdjustedValue(budgetLineTo.getFEBAdjustedValue().add(
                  log.getValue()));
              break;
            case 2:
              budgetLineTo.setMARAdjustedValue(budgetLineTo.getMARAdjustedValue().add(
                  log.getValue()));
              break;
            case 3:
              budgetLineTo.setAPRAdjustedValue(budgetLineTo.getAPRAdjustedValue().add(
                  log.getValue()));
              break;
            case 4:
              budgetLineTo.setMAYAdjustedValue(budgetLineTo.getMAYAdjustedValue().add(
                  log.getValue()));
              break;
            case 5:
              budgetLineTo.setJUNAdjustedValue(budgetLineTo.getJUNAdjustedValue().add(
                  log.getValue()));
              break;
            case 6:
              budgetLineTo.setJULAdjustedValue(budgetLineTo.getJULAdjustedValue().add(
                  log.getValue()));
              break;
            case 7:
              budgetLineTo.setAUGAdjustedValue(budgetLineTo.getAUGAdjustedValue().add(
                  log.getValue()));
              break;
            case 8:
              budgetLineTo.setSEPAdjustedValue(budgetLineTo.getSEPAdjustedValue().add(
                  log.getValue()));
              break;
            case 9:
              budgetLineTo.setOCTAdjustedValue(budgetLineTo.getOCTAdjustedValue().add(
                  log.getValue()));
              break;
            case 10:
              budgetLineTo.setNOVAdjustedValue(budgetLineTo.getNOVAdjustedValue().add(
                  log.getValue()));
              break;
            case 11:
              budgetLineTo.setDECAdjustedValue(budgetLineTo.getDECAdjustedValue().add(
                  log.getValue()));
              break;
            }

          } else if (log.getTypeOfOperation().equals("L")) {

            switch (Integer.parseInt(log.getToMonth())) {
            case 0:
              budgetLineTo.setJANAdjustedValue(budgetLineTo.getJANAdjustedValue().subtract(
                  log.getValue()));
              break;
            case 1:
              budgetLineTo.setFEBAdjustedValue(budgetLineTo.getFEBAdjustedValue().subtract(
                  log.getValue()));
              break;
            case 2:
              budgetLineTo.setMARAdjustedValue(budgetLineTo.getMARAdjustedValue().subtract(
                  log.getValue()));
              break;
            case 3:
              budgetLineTo.setAPRAdjustedValue(budgetLineTo.getAPRAdjustedValue().subtract(
                  log.getValue()));
              break;
            case 4:
              budgetLineTo.setMAYAdjustedValue(budgetLineTo.getMAYAdjustedValue().subtract(
                  log.getValue()));
              break;
            case 5:
              budgetLineTo.setJUNAdjustedValue(budgetLineTo.getJUNAdjustedValue().subtract(
                  log.getValue()));
              break;
            case 6:
              budgetLineTo.setJULAdjustedValue(budgetLineTo.getJULAdjustedValue().subtract(
                  log.getValue()));
              break;
            case 7:
              budgetLineTo.setAUGAdjustedValue(budgetLineTo.getAUGAdjustedValue().subtract(
                  log.getValue()));
              break;
            case 8:
              budgetLineTo.setSEPAdjustedValue(budgetLineTo.getSEPAdjustedValue().subtract(
                  log.getValue()));
              break;
            case 9:
              budgetLineTo.setOCTAdjustedValue(budgetLineTo.getOCTAdjustedValue().subtract(
                  log.getValue()));
              break;
            case 10:
              budgetLineTo.setNOVAdjustedValue(budgetLineTo.getNOVAdjustedValue().subtract(
                  log.getValue()));
              break;
            case 11:
              budgetLineTo.setDECAdjustedValue(budgetLineTo.getDECAdjustedValue().subtract(
                  log.getValue()));
              break;
            }

          }

          OBDal.getInstance().save(budgetLineTo);

          log.setProcess("Y");
          successMessage = "SFB_LogProcessed";

        }

      }

    } else if (log.getProcess().equals("Y")) {

      // If movement
      if (log.getType().equals("M")) {
        // Find any budget line that match From Budget Item
        OBCriteria<SFBBudgetLine> obcBudgetLineFrom = OBDal.getInstance().createCriteria(
            SFBBudgetLine.class);
        obcBudgetLineFrom.add(Restrictions.eq(SFBBudgetLine.PROPERTY_CLIENT, log.getClient()));
        obcBudgetLineFrom.add(Restrictions.eq(SFBBudgetLine.PROPERTY_ORGANIZATION,
            log.getOrganization()));
        obcBudgetLineFrom.add(Restrictions.eq(SFBBudgetLine.PROPERTY_COSTCENTER,
            log.getCostCenter()));
        obcBudgetLineFrom.add(Restrictions.eq(SFBBudgetLine.PROPERTY_STDIMENSION,
            log.getStDimension()));
        obcBudgetLineFrom.add(Restrictions.eq(SFBBudgetLine.PROPERTY_BUDGETITEM,
            log.getBudgetItemFrom()));
        obcBudgetLineFrom.add(Restrictions.eq(SFBBudgetLine.PROPERTY_AREA, log.getArea()));

        obcBudgetLineFrom.createAlias(SFBBudgetLine.PROPERTY_SFBBUDGETVERSION, "version");
        obcBudgetLineFrom.add(Restrictions.eq("version." + SFBBudgetVersion.PROPERTY_VERSIONSTATUS,
            "AP"));

        obcBudgetLineFrom.createAlias("version." + SFBBudgetVersion.PROPERTY_SFBBUDGET, "budget");
        obcBudgetLineFrom.add(Restrictions.eq("budget." + SFBBudget.PROPERTY_TYPEOFBUDGET,
            log.getTypeOfBudget()));
        obcBudgetLineFrom.add(Restrictions.eq("budget." + SFBBudget.PROPERTY_YEAR, log.getYear()));

        // If not found
        if (obcBudgetLineFrom.count() == 0) {
          OBDal.getInstance().rollbackAndClose();
          throw new OBException(Utility.messageBD(conn, "SFB_NoFromBudgetItem", language));
        } else {
          Object o = obcBudgetLineFrom.list().get(0);
          Object[] os = (Object[]) o;
          budgetLineFrom = (SFBBudgetLine) os[2];

          switch (Integer.parseInt(log.getFromMonth())) {
          case 0:
            budgetLineFrom.setJANAdjustedValue(budgetLineFrom.getJANAdjustedValue().add(
                log.getValue()));
            break;
          case 1:
            budgetLineFrom.setFEBAdjustedValue(budgetLineFrom.getFEBAdjustedValue().add(
                log.getValue()));
            break;
          case 2:
            budgetLineFrom.setMARAdjustedValue(budgetLineFrom.getMARAdjustedValue().add(
                log.getValue()));
            break;
          case 3:
            budgetLineFrom.setAPRAdjustedValue(budgetLineFrom.getAPRAdjustedValue().add(
                log.getValue()));
            break;
          case 4:
            budgetLineFrom.setMAYAdjustedValue(budgetLineFrom.getMAYAdjustedValue().add(
                log.getValue()));
            break;
          case 5:
            budgetLineFrom.setJUNAdjustedValue(budgetLineFrom.getJUNAdjustedValue().add(
                log.getValue()));
            break;
          case 6:
            budgetLineFrom.setJULAdjustedValue(budgetLineFrom.getJULAdjustedValue().add(
                log.getValue()));
            break;
          case 7:
            budgetLineFrom.setAUGAdjustedValue(budgetLineFrom.getAUGAdjustedValue().add(
                log.getValue()));
            break;
          case 8:
            budgetLineFrom.setSEPAdjustedValue(budgetLineFrom.getSEPAdjustedValue().add(
                log.getValue()));
            break;
          case 9:
            budgetLineFrom.setOCTAdjustedValue(budgetLineFrom.getOCTAdjustedValue().add(
                log.getValue()));
            break;
          case 10:
            budgetLineFrom.setNOVAdjustedValue(budgetLineFrom.getNOVAdjustedValue().add(
                log.getValue()));
            break;
          case 11:
            budgetLineFrom.setDECAdjustedValue(budgetLineFrom.getDECAdjustedValue().add(
                log.getValue()));
            break;
          }

          // OBDal.getInstance().save(budgetLineFrom);
          saveBudgetLineFrom = true;

        }
      }

      // Find any budget line that match To Budget Item
      OBCriteria<SFBBudgetLine> obcBudgetLineTo = OBDal.getInstance().createCriteria(
          SFBBudgetLine.class);
      obcBudgetLineTo.add(Restrictions.eq(SFBBudgetLine.PROPERTY_CLIENT, log.getClient()));
      obcBudgetLineTo.add(Restrictions.eq(SFBBudgetLine.PROPERTY_ORGANIZATION,
          log.getOrganization()));
      obcBudgetLineTo.add(Restrictions.eq(SFBBudgetLine.PROPERTY_COSTCENTER, log.getCostCenter()));
      obcBudgetLineTo
          .add(Restrictions.eq(SFBBudgetLine.PROPERTY_STDIMENSION, log.getStDimension()));
      obcBudgetLineTo
          .add(Restrictions.eq(SFBBudgetLine.PROPERTY_BUDGETITEM, log.getBudgetItemTo()));
      obcBudgetLineTo.add(Restrictions.eq(SFBBudgetLine.PROPERTY_AREA, log.getArea()));


      obcBudgetLineTo.add(Restrictions.ge(SFBBudgetLine.PROPERTY_AVAILABLEBALANCE, log.getValue()));

      obcBudgetLineTo.createAlias(SFBBudgetLine.PROPERTY_SFBBUDGETVERSION, "version");
      obcBudgetLineTo.add(Restrictions.eq("version." + SFBBudgetVersion.PROPERTY_VERSIONSTATUS,
          "AP"));

      obcBudgetLineTo.createAlias("version." + SFBBudgetVersion.PROPERTY_SFBBUDGET, "budget");
      obcBudgetLineTo.add(Restrictions.eq("budget." + SFBBudget.PROPERTY_TYPEOFBUDGET,
          log.getTypeOfBudget()));
      obcBudgetLineTo.add(Restrictions.eq("budget." + SFBBudget.PROPERTY_YEAR, log.getYear()));

      if (log.getType().equals("M")) {

        // If not found
        if (obcBudgetLineTo.count() == 0) {
          OBDal.getInstance().rollbackAndClose();
          throw new OBException(Utility.messageBD(conn, "SFB_NoToBudgetItem", language));
        } else {
          Object o = obcBudgetLineTo.list().get(0);
          Object[] os = (Object[]) o;
          SFBBudgetLine budgetLineTo = (SFBBudgetLine) os[2];

          switch (Integer.parseInt(log.getToMonth())) {
          case 0:
            budgetLineTo.setJANAdjustedValue(budgetLineTo.getJANAdjustedValue().subtract(
                log.getValue()));
            break;
          case 1:
            budgetLineTo.setFEBAdjustedValue(budgetLineTo.getFEBAdjustedValue().subtract(
                log.getValue()));
            break;
          case 2:
            budgetLineTo.setMARAdjustedValue(budgetLineTo.getMARAdjustedValue().subtract(
                log.getValue()));
            break;
          case 3:
            budgetLineTo.setAPRAdjustedValue(budgetLineTo.getAPRAdjustedValue().subtract(
                log.getValue()));
            break;
          case 4:
            budgetLineTo.setMAYAdjustedValue(budgetLineTo.getMAYAdjustedValue().subtract(
                log.getValue()));
            break;
          case 5:
            budgetLineTo.setJUNAdjustedValue(budgetLineTo.getJUNAdjustedValue().subtract(
                log.getValue()));
            break;
          case 6:
            budgetLineTo.setJULAdjustedValue(budgetLineTo.getJULAdjustedValue().subtract(
                log.getValue()));
            break;
          case 7:
            budgetLineTo.setAUGAdjustedValue(budgetLineTo.getAUGAdjustedValue().subtract(
                log.getValue()));
            break;
          case 8:
            budgetLineTo.setSEPAdjustedValue(budgetLineTo.getSEPAdjustedValue().subtract(
                log.getValue()));
            break;
          case 9:
            budgetLineTo.setOCTAdjustedValue(budgetLineTo.getOCTAdjustedValue().subtract(
                log.getValue()));
            break;
          case 10:
            budgetLineTo.setNOVAdjustedValue(budgetLineTo.getNOVAdjustedValue().subtract(
                log.getValue()));
            break;
          case 11:
            budgetLineTo.setDECAdjustedValue(budgetLineTo.getDECAdjustedValue().subtract(
                log.getValue()));
            break;
          }

          OBDal.getInstance().save(budgetLineTo);

          if (saveBudgetLineFrom || budgetLineFrom != null) {
            OBDal.getInstance().save(budgetLineFrom);
          }

          log.setProcess("N");
          successMessage = "SFB_LogUnprocessed";
        }
      } else if (log.getType().equals("S")) {

     OBCriteria<SFBBudgetLine> obcBudgetLineToS = OBDal.getInstance().createCriteria(
          SFBBudgetLine.class);
      obcBudgetLineToS.add(Restrictions.eq(SFBBudgetLine.PROPERTY_CLIENT, log.getClient()));
      obcBudgetLineToS.add(Restrictions.eq(SFBBudgetLine.PROPERTY_ORGANIZATION,
          log.getOrganization()));
      obcBudgetLineToS.add(Restrictions.eq(SFBBudgetLine.PROPERTY_COSTCENTER, log.getCostCenter()));
      obcBudgetLineToS
          .add(Restrictions.eq(SFBBudgetLine.PROPERTY_STDIMENSION, log.getStDimension()));
      obcBudgetLineToS
          .add(Restrictions.eq(SFBBudgetLine.PROPERTY_BUDGETITEM, log.getBudgetItemTo()));
      obcBudgetLineToS.add(Restrictions.eq(SFBBudgetLine.PROPERTY_AREA, log.getArea()));
      obcBudgetLineToS.createAlias(SFBBudgetLine.PROPERTY_SFBBUDGETVERSION, "version");
      obcBudgetLineToS.add(Restrictions.eq("version." + SFBBudgetVersion.PROPERTY_VERSIONSTATUS,"AP"));
      obcBudgetLineToS.createAlias("version." + SFBBudgetVersion.PROPERTY_SFBBUDGET, "budget");
      obcBudgetLineToS.add(Restrictions.eq("budget." + SFBBudget.PROPERTY_TYPEOFBUDGET,
          log.getTypeOfBudget()));
      obcBudgetLineToS.add(Restrictions.eq("budget." + SFBBudget.PROPERTY_YEAR, log.getYear()));
      if (log.getTypeOfOperation().equals("S")) {
      obcBudgetLineToS.add(Restrictions.ge(SFBBudgetLine.PROPERTY_AVAILABLEBALANCE, log.getValue()));
      }


        if (obcBudgetLineToS.count() == 0) {
          OBDal.getInstance().rollbackAndClose();
          throw new OBException(Utility.messageBD(conn, "SFB_NoToBudgetItem", language));
        } else {
          Object o = obcBudgetLineToS.list().get(0);
          Object[] os = (Object[]) o;
          SFBBudgetLine budgetLineToS = (SFBBudgetLine) os[2];

          if (log.getTypeOfOperation().equals("S")) {

            switch (Integer.parseInt(log.getToMonth())) {
            case 0:
              budgetLineToS.setJANAdjustedValue(budgetLineToS.getJANAdjustedValue().subtract(
                  log.getValue()));
              break;
            case 1:
              budgetLineToS.setFEBAdjustedValue(budgetLineToS.getFEBAdjustedValue().subtract(
                  log.getValue()));
              break;
            case 2:
              budgetLineToS.setMARAdjustedValue(budgetLineToS.getMARAdjustedValue().subtract(
                  log.getValue()));
              break;
            case 3:
              budgetLineToS.setAPRAdjustedValue(budgetLineToS.getAPRAdjustedValue().subtract(
                  log.getValue()));
              break;
            case 4:
              budgetLineToS.setMAYAdjustedValue(budgetLineToS.getMAYAdjustedValue().subtract(
                  log.getValue()));
              break;
            case 5:
              budgetLineToS.setJUNAdjustedValue(budgetLineToS.getJUNAdjustedValue().subtract(
                  log.getValue()));
              break;
            case 6:
              budgetLineToS.setJULAdjustedValue(budgetLineToS.getJULAdjustedValue().subtract(
                  log.getValue()));
              break;
            case 7:
              budgetLineToS.setAUGAdjustedValue(budgetLineToS.getAUGAdjustedValue().subtract(
                  log.getValue()));
              break;
            case 8:
              budgetLineToS.setSEPAdjustedValue(budgetLineToS.getSEPAdjustedValue().subtract(
                  log.getValue()));
              break;
            case 9:
              budgetLineToS.setOCTAdjustedValue(budgetLineToS.getOCTAdjustedValue().subtract(
                  log.getValue()));
              break;
            case 10:
              budgetLineToS.setNOVAdjustedValue(budgetLineToS.getNOVAdjustedValue().subtract(
                  log.getValue()));
              break;
            case 11:
              budgetLineToS.setDECAdjustedValue(budgetLineToS.getDECAdjustedValue().subtract(
                  log.getValue()));
              break;
            }

          } else if (log.getTypeOfOperation().equals("L")) {

         
            switch (Integer.parseInt(log.getToMonth())) {
            case 0:
              budgetLineToS.setJANAdjustedValue(budgetLineToS.getJANAdjustedValue().add(
                  log.getValue()));
              break;
            case 1:
              budgetLineToS.setFEBAdjustedValue(budgetLineToS.getFEBAdjustedValue().add(
                  log.getValue()));
              break;
            case 2:
              budgetLineToS.setMARAdjustedValue(budgetLineToS.getMARAdjustedValue().add(
                  log.getValue()));
              break;
            case 3:
              budgetLineToS.setAPRAdjustedValue(budgetLineToS.getAPRAdjustedValue().add(
                  log.getValue()));
              break;
            case 4:
              budgetLineToS.setMAYAdjustedValue(budgetLineToS.getMAYAdjustedValue().add(
                  log.getValue()));
              break;
            case 5:
              budgetLineToS.setJUNAdjustedValue(budgetLineToS.getJUNAdjustedValue().add(
                  log.getValue()));
              break;
            case 6:
              budgetLineToS.setJULAdjustedValue(budgetLineToS.getJULAdjustedValue().add(
                  log.getValue()));
              break;
            case 7:
              budgetLineToS.setAUGAdjustedValue(budgetLineToS.getAUGAdjustedValue().add(
                  log.getValue()));
              break;
            case 8:
              budgetLineToS.setSEPAdjustedValue(budgetLineToS.getSEPAdjustedValue().add(
                  log.getValue()));
              break;
            case 9:
              budgetLineToS.setOCTAdjustedValue(budgetLineToS.getOCTAdjustedValue().add(
                  log.getValue()));
              break;
            case 10:
              budgetLineToS.setNOVAdjustedValue(budgetLineToS.getNOVAdjustedValue().add(
                  log.getValue()));
              break;
            case 11:
              budgetLineToS.setDECAdjustedValue(budgetLineToS.getDECAdjustedValue().add(
                  log.getValue()));
              break;
            }

          }

          OBDal.getInstance().save(budgetLineToS);

          log.setProcess("N");
          successMessage = "SFB_LogUnprocessed";

        }

      }

    }

    message.setTitle(Utility.messageBD(conn, "ProcessOK", language));
    message.setType("Success");
    message.setMessage(Utility.messageBD(conn, successMessage, language));
    OBDal.getInstance().save(log);
    OBDal.getInstance().flush();
  }
}
