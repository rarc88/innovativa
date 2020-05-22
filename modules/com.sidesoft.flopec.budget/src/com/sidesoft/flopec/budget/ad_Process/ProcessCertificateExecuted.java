package com.sidesoft.flopec.budget.ad_Process;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.StandardBasicTypes;
import org.openbravo.base.exception.OBException;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.dal.service.OBQuery;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.financial.FinancialUtils;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.common.invoice.InvoiceLine;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.common.order.OrderLine;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.DalBaseProcess;
import org.openbravo.service.db.DalConnectionProvider;

import com.sidesoft.flopec.budget.data.SFBBudget;
import com.sidesoft.flopec.budget.data.SFBBudgetCertLine;
import com.sidesoft.flopec.budget.data.SFBBudgetCertificate;
import com.sidesoft.flopec.budget.data.SFBBudgetLine;
import com.sidesoft.flopec.budget.data.SFBBudgetVersion;

public class ProcessCertificateExecuted extends DalBaseProcess {
  OBError message;

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
    String certificateId = (String) bundle.getParams().get("SFB_Budget_Certificate_ID");
    SFBBudgetCertificate certificate = OBDal.getInstance().get(SFBBudgetCertificate.class,
        certificateId);

    String language = OBContext.getOBContext().getLanguage().getLanguage();
    ConnectionProvider conn = new DalConnectionProvider(false);
    String successMessage = null;

    if (certificate.getSfbBudgetCertLineList().isEmpty()) {
      message.setTitle(Utility.messageBD(conn, "SFB_CertificateWarning", language));
      message.setType("Warning");
      message.setMessage(Utility.messageBD(conn, "SFB_CertificateWithoutLines", language));
    } else if (certificate.getProcessExecuted().equals("N")
        && !certificate.getCertificateStatus().equals("RE")) {
      message.setTitle(Utility.messageBD(conn, "SFB_CertificateWarning", language));
      message.setType("Warning");
      message.setMessage(Utility.messageBD(conn, "SFB_NoRequestedProcessStatus", language));
    } else if (certificate.getProcessExecuted().equals("Y")
        && !certificate.getCertificateStatus().equals("AP")) {
      message.setTitle(Utility.messageBD(conn, "SFB_CertificateWarning", language));
      message.setType("Warning");
      message.setMessage(Utility.messageBD(conn, "SFB_NoApprovedStatus", language));
    } else {
      if (certificate.getProcessExecuted().equals("N")) {
        Currency currencyTo = null;
        BigDecimal convertedAmount = null;

        for (SFBBudgetCertLine certline : certificate.getSfbBudgetCertLineList()) {
          // Convert certificate line amount
          OBCriteria<SFBBudget> obcBudget = OBDal.getInstance().createCriteria(SFBBudget.class);
          obcBudget.add(Restrictions.eq(SFBBudget.PROPERTY_CLIENT, certificate.getClient()));
          obcBudget.add(Restrictions.eq(SFBBudget.PROPERTY_ORGANIZATION,
              certificate.getOrganization()));
          obcBudget.add(Restrictions.eq(SFBBudget.PROPERTY_YEAR, certificate.getYear()));
          obcBudget.add(Restrictions.eq(SFBBudget.PROPERTY_TYPEOFBUDGET,
              certificate.getTypeOfBudget()));

          // If not budget
          if (obcBudget.count() == 0) {
            throw new OBException(Utility.messageBD(conn, "SFB_NoBudget", language));
          } else {
            currencyTo = obcBudget.list().get(0).getCurrency();
          }

          if (certificate.getCurrency() != currencyTo) {
            convertedAmount = FinancialUtils.getConvertedAmount(certline.getCertifiedValue(),
                certificate.getCurrency(), currencyTo, certificate.getDateIssue(),
                certificate.getOrganization(), "P");
          } else {
            convertedAmount = certline.getCertifiedValue();
          }

          // Find any budget line with enough available amount
          OBDal.getInstance().registerSQLFunction(
              "c_currency_convert_precision",
              new StandardSQLFunction("c_currency_convert_precision",
                  StandardBasicTypes.BIG_DECIMAL));
          final StringBuilder whereClause = new StringBuilder();
          final List<Object> parameters = new ArrayList<Object>();

          whereClause.append(" as bl ");
          whereClause.append(" left outer join bl." + SFBBudgetLine.PROPERTY_SFBBUDGETVERSION
              + " as bv ");
          whereClause
              .append(" left outer join bv." + SFBBudgetVersion.PROPERTY_SFBBUDGET + " as b");

          whereClause.append(" where bl." + SFBBudgetLine.PROPERTY_CLIENT + " = ? ");
          parameters.add(certline.getClient());
          whereClause.append(" and bl." + SFBBudgetLine.PROPERTY_ORGANIZATION + " = ? ");
          parameters.add(certline.getOrganization());
          whereClause.append(" and bl." + SFBBudgetLine.PROPERTY_COSTCENTER + " = ? ");
          parameters.add(certline.getCostCenter());
          whereClause.append(" and bl." + SFBBudgetLine.PROPERTY_STDIMENSION + " = ? ");
          parameters.add(certline.getStDimension());
          whereClause.append(" and bl." + SFBBudgetLine.PROPERTY_BUDGETITEM + " = ? ");
          parameters.add(certline.getBudgetItem());
          whereClause.append(" and bl." + SFBBudgetLine.PROPERTY_AREA + " = ? ");
          parameters.add(certificate.getArea());
          whereClause.append(" and bl." + SFBBudgetLine.PROPERTY_AVAILABLEBALANCE + " >= ");
          whereClause.append(" (select c_currency_convert_precision(sum(cl."
              + SFBBudgetCertLine.PROPERTY_CERTIFIEDVALUE + "), ?, b."
              + SFBBudget.PROPERTY_CURRENCY + ".id, to_date(?, 'yyyy-mm-dd'), null, bl."
              + SFBBudgetLine.PROPERTY_CLIENT + ".id, bl." + SFBBudgetLine.PROPERTY_ORGANIZATION
              + ".id, 'P') from " + SFBBudgetCertLine.ENTITY_NAME + " as cl");
          parameters.add(certificate.getCurrency().getId());
          parameters.add(new java.sql.Date(certificate.getDateIssue().getTime()).toString());
          whereClause.append(" where cl. " + SFBBudgetCertLine.PROPERTY_SFBBUDGETCERTIFICATE
              + " = ?");
          parameters.add(certificate);
          whereClause.append(" and cl." + SFBBudgetCertLine.PROPERTY_CLIENT + " = bl."
              + SFBBudgetLine.PROPERTY_CLIENT + " ");
          whereClause.append(" and cl." + SFBBudgetCertLine.PROPERTY_ORGANIZATION + " = bl."
              + SFBBudgetLine.PROPERTY_ORGANIZATION + " ");
          whereClause.append(" and cl." + SFBBudgetCertLine.PROPERTY_COSTCENTER + " = bl."
              + SFBBudgetLine.PROPERTY_COSTCENTER + " ");
          whereClause.append(" and cl." + SFBBudgetCertLine.PROPERTY_STDIMENSION + " = bl."
              + SFBBudgetLine.PROPERTY_STDIMENSION + " ");
          whereClause.append(" and cl." + SFBBudgetCertLine.PROPERTY_BUDGETITEM + " = bl."
              + SFBBudgetLine.PROPERTY_BUDGETITEM + " )");

          whereClause.append(" and bv." + SFBBudgetVersion.PROPERTY_VERSIONSTATUS + " = ? ");
          parameters.add("AP");

          whereClause.append(" and b." + SFBBudget.PROPERTY_TYPEOFBUDGET + " = ? ");
          parameters.add(certificate.getTypeOfBudget());
          whereClause.append(" and b." + SFBBudget.PROPERTY_YEAR + " = ? ");
          parameters.add(certificate.getYear());

          OBQuery<SFBBudgetLine> obcBudgetLine = OBDal.getInstance().createQuery(
              SFBBudgetLine.class, whereClause.toString());
          obcBudgetLine.setParameters(parameters);

          // If not found
          if (obcBudgetLine.count() == 0) {
            throw new OBException(Utility.messageBD(conn, "SFB_NoBudgetLine", language) + " ("
                + certline.getLineNo() + ")");
          } else {
            SFBBudgetLine budgetLine = obcBudgetLine.list().get(0);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(certificate.getDateIssue());

            switch (calendar.get(Calendar.MONTH)) {
            case 0:
              budgetLine.setJANCommittedValue(budgetLine.getJANCommittedValue()
                  .add(convertedAmount));
              budgetLine.setJANExecutedValue(budgetLine.getJANExecutedValue().add(convertedAmount));
              break;
            case 1:
              budgetLine.setFEBCommittedValue(budgetLine.getFEBCommittedValue()
                  .add(convertedAmount));
              budgetLine.setFEBExecutedValue(budgetLine.getFEBExecutedValue().add(convertedAmount));
              break;
            case 2:
              budgetLine.setMARCommittedValue(budgetLine.getMARCommittedValue()
                  .add(convertedAmount));
              budgetLine.setMARExecutedValue(budgetLine.getMARExecutedValue().add(convertedAmount));
              break;
            case 3:
              budgetLine.setAPRCommittedValue(budgetLine.getAPRCommittedValue()
                  .add(convertedAmount));
              budgetLine.setAPRExecutedValue(budgetLine.getAPRExecutedValue().add(convertedAmount));
              break;
            case 4:
              budgetLine.setMAYCommittedValue(budgetLine.getMAYCommittedValue()
                  .add(convertedAmount));
              budgetLine.setMAYExecutedValue(budgetLine.getMAYExecutedValue().add(convertedAmount));
              break;
            case 5:
              budgetLine.setJUNCommittedValue(budgetLine.getJUNCommittedValue()
                  .add(convertedAmount));
              budgetLine.setJUNExecutedValue(budgetLine.getJUNExecutedValue().add(convertedAmount));
              break;
            case 6:
              budgetLine.setJULCommittedValue(budgetLine.getJULCommittedValue()
                  .add(convertedAmount));
              budgetLine.setJULExecutedValue(budgetLine.getJULExecutedValue().add(convertedAmount));
              break;
            case 7:
              budgetLine.setAUGCommittedValue(budgetLine.getAUGCommittedValue()
                  .add(convertedAmount));
              budgetLine.setAUGExecutedValue(budgetLine.getAUGExecutedValue().add(convertedAmount));
              break;
            case 8:
              budgetLine.setSEPCommittedValue(budgetLine.getSEPCommittedValue()
                  .add(convertedAmount));
              budgetLine.setSEPExecutedValue(budgetLine.getSEPExecutedValue().add(convertedAmount));
              break;
            case 9:
              budgetLine.setOCTCommittedValue(budgetLine.getOCTCommittedValue()
                  .add(convertedAmount));
              budgetLine.setOCTExecutedValue(budgetLine.getOCTExecutedValue().add(convertedAmount));
              break;
            case 10:
              budgetLine.setNOVCommittedValue(budgetLine.getNOVCommittedValue()
                  .add(convertedAmount));
              budgetLine.setNOVExecutedValue(budgetLine.getNOVExecutedValue().add(convertedAmount));
              break;
            case 11:
              budgetLine.setDECCommittedValue(budgetLine.getDECCommittedValue()
                  .add(convertedAmount));
              budgetLine.setDECExecutedValue(budgetLine.getDECExecutedValue().add(convertedAmount));
              break;
            }

            certline.setBudgetCertifiedValue(convertedAmount);
            certline.setExecutedValue(certline.getCertifiedValue());
            certline.setBudgetExecutedValue(convertedAmount);

            OBDal.getInstance().save(certline);
            OBDal.getInstance().save(budgetLine);
          }
        }

        OBDal.getInstance().flush(); // certificate lines update must precede certificate update in
                                     // order to prevent copied version update constraint.
        certificate.setProcessExecuted("Y");
        certificate.setCertificateStatus("AP");
        successMessage = "SFB_CertificateProcessed";
      } else if (certificate.getProcessExecuted().equals("Y")) {
        // Check whether certificate is being used
        OBCriteria<OrderLine> obcOrderLine = OBDal.getInstance().createCriteria(OrderLine.class);
        obcOrderLine.add(Restrictions.eq(OrderLine.PROPERTY_CLIENT, certificate.getClient()));

        obcOrderLine.createAlias(OrderLine.PROPERTY_SALESORDER, "order");
        obcOrderLine.add(Restrictions.or(
            Restrictions.eq(OrderLine.PROPERTY_SFBHASHCODE, certificate.getHashCode()),
            Restrictions.eq("order." + Order.PROPERTY_SFBHASHCODE, certificate.getHashCode())));

        OBCriteria<InvoiceLine> obcInvoiceLine = OBDal.getInstance().createCriteria(
            InvoiceLine.class);
        obcInvoiceLine.add(Restrictions.eq(InvoiceLine.PROPERTY_CLIENT, certificate.getClient()));

        obcInvoiceLine.createAlias(InvoiceLine.PROPERTY_INVOICE, "invoice");
        obcInvoiceLine.add(Restrictions.or(
            Restrictions.eq(InvoiceLine.PROPERTY_SFBHASHCODE, certificate.getHashCode()),
            Restrictions.eq("invoice." + Invoice.PROPERTY_SFBHASHCODE, certificate.getHashCode())));

        // If found
        if (obcInvoiceLine.count() > 0 || obcOrderLine.count() > 0) {
          throw new OBException(Utility.messageBD(conn, "SFB_CertificateUsed", language));
        }

        for (SFBBudgetCertLine certline : certificate.getSfbBudgetCertLineList()) {
          // Find a budget line with the same cost center and budget item
          OBCriteria<SFBBudgetLine> obcBudgetLine = OBDal.getInstance().createCriteria(
              SFBBudgetLine.class);
          obcBudgetLine.add(Restrictions.eq(SFBBudgetLine.PROPERTY_CLIENT, certline.getClient()));
          obcBudgetLine.add(Restrictions.eq(SFBBudgetLine.PROPERTY_ORGANIZATION,
              certline.getOrganization()));
          obcBudgetLine.add(Restrictions.eq(SFBBudgetLine.PROPERTY_COSTCENTER,
              certline.getCostCenter()));
          obcBudgetLine.add(Restrictions.eq(SFBBudgetLine.PROPERTY_STDIMENSION,
              certline.getStDimension()));
          obcBudgetLine.add(Restrictions.eq(SFBBudgetLine.PROPERTY_BUDGETITEM,
              certline.getBudgetItem()));
          obcBudgetLine.add(Restrictions.eq(SFBBudgetLine.PROPERTY_AREA, certificate.getArea()));

          obcBudgetLine.createAlias(SFBBudgetLine.PROPERTY_SFBBUDGETVERSION, "version");
          obcBudgetLine.add(Restrictions.eq("version." + SFBBudgetVersion.PROPERTY_VERSIONSTATUS,
              "AP"));

          obcBudgetLine.createAlias("version." + SFBBudgetVersion.PROPERTY_SFBBUDGET, "budget");
          obcBudgetLine.add(Restrictions.eq("budget." + SFBBudget.PROPERTY_TYPEOFBUDGET,
              certificate.getTypeOfBudget()));
          obcBudgetLine.add(Restrictions.eq("budget." + SFBBudget.PROPERTY_YEAR,
              certificate.getYear()));

          // If not found
          if (obcBudgetLine.count() == 0) {
            throw new OBException(Utility.messageBD(conn, "SFB_NoBudgetLine", language) + " ("
                + certline.getLineNo() + ")");
          } else {
            Object o = obcBudgetLine.list().get(0);
            Object[] os = (Object[]) o;
            SFBBudgetLine budgetLine = (SFBBudgetLine) os[2];

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(certificate.getDateIssue());

            switch (calendar.get(Calendar.MONTH)) {
            case 0:
              budgetLine.setJANCommittedValue(budgetLine.getJANCommittedValue().subtract(
                  certline.getBudgetCertifiedValue()));
              budgetLine.setJANExecutedValue(budgetLine.getJANExecutedValue().subtract(
                  certline.getBudgetExecutedValue()));
              break;
            case 1:
              budgetLine.setFEBCommittedValue(budgetLine.getFEBCommittedValue().subtract(
                  certline.getBudgetCertifiedValue()));
              budgetLine.setFEBExecutedValue(budgetLine.getFEBExecutedValue().subtract(
                  certline.getBudgetExecutedValue()));
              break;
            case 2:
              budgetLine.setMARCommittedValue(budgetLine.getMARCommittedValue().subtract(
                  certline.getBudgetCertifiedValue()));
              budgetLine.setMARExecutedValue(budgetLine.getMARExecutedValue().subtract(
                  certline.getBudgetExecutedValue()));
              break;
            case 3:
              budgetLine.setAPRCommittedValue(budgetLine.getAPRCommittedValue().subtract(
                  certline.getBudgetCertifiedValue()));
              budgetLine.setAPRExecutedValue(budgetLine.getAPRExecutedValue().subtract(
                  certline.getBudgetExecutedValue()));
              break;
            case 4:
              budgetLine.setMAYCommittedValue(budgetLine.getMAYCommittedValue().subtract(
                  certline.getBudgetCertifiedValue()));
              budgetLine.setMAYExecutedValue(budgetLine.getMAYExecutedValue().subtract(
                  certline.getBudgetExecutedValue()));
              break;
            case 5:
              budgetLine.setJUNCommittedValue(budgetLine.getJUNCommittedValue().subtract(
                  certline.getBudgetCertifiedValue()));
              budgetLine.setJUNExecutedValue(budgetLine.getJUNExecutedValue().subtract(
                  certline.getBudgetExecutedValue()));
              break;
            case 6:
              budgetLine.setJULCommittedValue(budgetLine.getJULCommittedValue().subtract(
                  certline.getBudgetCertifiedValue()));
              budgetLine.setJULExecutedValue(budgetLine.getJULExecutedValue().subtract(
                  certline.getBudgetExecutedValue()));
              break;
            case 7:
              budgetLine.setAUGCommittedValue(budgetLine.getAUGCommittedValue().subtract(
                  certline.getBudgetCertifiedValue()));
              budgetLine.setAUGExecutedValue(budgetLine.getAUGExecutedValue().subtract(
                  certline.getBudgetExecutedValue()));
              break;
            case 8:
              budgetLine.setSEPCommittedValue(budgetLine.getSEPCommittedValue().subtract(
                  certline.getBudgetCertifiedValue()));
              budgetLine.setSEPExecutedValue(budgetLine.getSEPExecutedValue().subtract(
                  certline.getBudgetExecutedValue()));
              break;
            case 9:
              budgetLine.setOCTCommittedValue(budgetLine.getOCTCommittedValue().subtract(
                  certline.getBudgetCertifiedValue()));
              budgetLine.setOCTExecutedValue(budgetLine.getOCTExecutedValue().subtract(
                  certline.getBudgetExecutedValue()));
              break;
            case 10:
              budgetLine.setNOVCommittedValue(budgetLine.getNOVCommittedValue().subtract(
                  certline.getBudgetCertifiedValue()));
              budgetLine.setNOVExecutedValue(budgetLine.getNOVExecutedValue().subtract(
                  certline.getBudgetExecutedValue()));
              break;
            case 11:
              budgetLine.setDECCommittedValue(budgetLine.getDECCommittedValue().subtract(
                  certline.getBudgetCertifiedValue()));
              budgetLine.setDECExecutedValue(budgetLine.getDECExecutedValue().subtract(
                  certline.getBudgetExecutedValue()));
              break;
            }

            certline.setBudgetCertifiedValue(new BigDecimal("0"));
            certline.setExecutedValue(new BigDecimal("0"));
            certline.setBudgetExecutedValue(new BigDecimal("0"));

            OBDal.getInstance().save(certline);
            OBDal.getInstance().save(budgetLine);
          }
        }

        certificate.setProcessExecuted("N");
        certificate.setCertificateStatus("RE");
        successMessage = "SFB_CertificateUnprocessed";

      }

      message.setTitle(Utility.messageBD(conn, "ProcessOK", language));
      message.setType("Success");
      message.setMessage(Utility.messageBD(conn, successMessage, language));
      OBDal.getInstance().save(certificate);
      OBDal.getInstance().flush();
    }
  }
}
