package com.sidesoft.flopec.budget.ad_Process;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.model.common.invoice.InvoiceLine;
import org.openbravo.model.common.order.OrderLine;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.DalBaseProcess;
import org.openbravo.service.db.DalConnectionProvider;

import com.sidesoft.flopec.budget.data.SFBBudget;
import com.sidesoft.flopec.budget.data.SFBBudgetCertLine;
import com.sidesoft.flopec.budget.data.SFBBudgetCertificate;
import com.sidesoft.flopec.budget.data.SFBBudgetLine;
import com.sidesoft.flopec.budget.data.SFBBudgetVersion;

public class CloseCertificate extends DalBaseProcess {
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
    String v_certificate_status = (String) bundle.getParams().get("Certificate_Status");

    SFBBudgetCertificate certificate = OBDal.getInstance().get(SFBBudgetCertificate.class,
        certificateId);

    String language = OBContext.getOBContext().getLanguage().getLanguage();
    ConnectionProvider conn = new DalConnectionProvider(false);
    String successMessage = null;

    if (!certificate.getCommittedValue().equals(certificate.getExecutedValue())) {
      throw new OBException(Utility.messageBD(conn, "SFB_CertificateUsed", language));
    }

    if (certificate.getSfbBudgetCertLineList().isEmpty()) {
      message.setTitle(Utility.messageBD(conn, "SFB_CertificateWarning", language));
      message.setType("Warning");
      message.setMessage(Utility.messageBD(conn, "SFB_CertificateWithoutLines", language));
    } else if (certificate.getClosecert().equals("N")
        && !certificate.getCertificateStatus().equals("AP")) {
      message.setTitle(Utility.messageBD(conn, "SFB_CertificateWarning", language));
      message.setType("Warning");
      message.setMessage(Utility.messageBD(conn, "SFB_NoApprovedCloseStatus", language));
    } else if (certificate.getClosecert().equals("Y")) {
      // message.setTitle(Utility.messageBD(conn, "SFB_CertificateWarning", language));
      // message.setType("Warning");
      // message.setMessage(Utility.messageBD(conn, "SFB_CertificateClosedStatus", language));

      // Validar cuando el certificado es cerrado

      for (SFBBudgetCertLine certline : certificate.getSfbBudgetCertLineList()) {

        // Find any budget line with enough available amount
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
          BigDecimal budgetActualValue = certline.getBudgetActualValue();

          switch (calendar.get(Calendar.MONTH)) {
          case 0:
            budgetLine.setJANCommittedValue(budgetLine.getJANCommittedValue()
                .add(budgetActualValue));
            break;
          case 1:
            budgetLine.setFEBCommittedValue(budgetLine.getFEBCommittedValue()
                .add(budgetActualValue));
            break;
          case 2:
            budgetLine.setMARCommittedValue(budgetLine.getMARCommittedValue()
                .add(budgetActualValue));
            break;
          case 3:
            budgetLine.setAPRCommittedValue(budgetLine.getAPRCommittedValue()
                .add(budgetActualValue));
            break;
          case 4:
            budgetLine.setMAYCommittedValue(budgetLine.getMAYCommittedValue()
                .add(budgetActualValue));
            break;
          case 5:
            budgetLine.setJUNCommittedValue(budgetLine.getJUNCommittedValue()
                .add(budgetActualValue));
            break;
          case 6:
            budgetLine.setJULCommittedValue(budgetLine.getJULCommittedValue()
                .add(budgetActualValue));
            break;
          case 7:
            budgetLine.setAUGCommittedValue(budgetLine.getAUGCommittedValue()
                .add(budgetActualValue));
            break;
          case 8:
            budgetLine.setSEPCommittedValue(budgetLine.getSEPCommittedValue()
                .add(budgetActualValue));
            break;
          case 9:
            budgetLine.setOCTCommittedValue(budgetLine.getOCTCommittedValue()
                .add(budgetActualValue));
            break;
          case 10:
            budgetLine.setNOVCommittedValue(budgetLine.getNOVCommittedValue()
                .add(budgetActualValue));
            break;
          case 11:
            budgetLine.setDECCommittedValue(budgetLine.getDECCommittedValue()
                .add(budgetActualValue));
            break;
          }

          OBDal.getInstance().save(certline);
          OBDal.getInstance().save(budgetLine);
        }
      }

      OBDal.getInstance().flush(); // certificate lines update must precede certificate update in
                                   // order to prevent copied version update constraint.
      certificate.setProcess("Y");
      certificate.setCertificateStatus("AP");
      certificate.setClosecert("N");
      successMessage = "SFB_CertificateOpened";

      message.setTitle(Utility.messageBD(conn, "ProcessOK", language));
      message.setType("Success");
      message.setMessage(Utility.messageBD(conn, successMessage, language));
      OBDal.getInstance().save(certificate);
      OBDal.getInstance().flush();

    } else {
      if (certificate.getClosecert().equals("N")) {

        // Validar cuando el certificado es cerrado

        OBCriteria<SFBBudgetCertLine> ObjCertificateLine = OBDal.getInstance().createCriteria(
            SFBBudgetCertLine.class);

        ObjCertificateLine.add(Restrictions.eq(SFBBudgetCertLine.PROPERTY_SFBBUDGETCERTIFICATE,
            certificate));

        for (SFBBudgetCertLine certline : ObjCertificateLine.list()) {

          OBCriteria<OrderLine> objOrderLine = OBDal.getInstance().createCriteria(OrderLine.class);

          SFBBudgetCertLine Bcertline = OBDal.getInstance().get(SFBBudgetCertLine.class,
              certline.getId().toString());

          objOrderLine.add(Restrictions.eq(OrderLine.PROPERTY_SFBBUDGETCERTLINE, Bcertline));
          List<OrderLine> OrderLineList = objOrderLine.list();

          int NumOrderLine = OrderLineList.size();

          if (NumOrderLine > 0) {

            for (OrderLine OrderLines : objOrderLine.list()) {

              String strDocstatus = OrderLines.getSalesOrder().getDocumentStatus().toString();

              OrderLine strOrderlineID = OBDal.getInstance().get(OrderLine.class,
                  OrderLines.getId().toString());

              // if (!strDocstatus.equals("ND")){

              if (strDocstatus.equals("DR")) {

                throw new OBException(
                    Utility.messageBD(conn,
                        "@ERROR= CERTIFICADO TIENE RELACIONADO UN PEDIDO ES ESTADO BORRADOR@",
                        language));

              } else if (strDocstatus.equals("CO")) {

                OBCriteria<InvoiceLine> objInvoiceLine = OBDal.getInstance().createCriteria(
                    InvoiceLine.class);

                objInvoiceLine.add(Restrictions.eq(InvoiceLine.PROPERTY_SALESORDERLINE,
                    strOrderlineID));
                List<InvoiceLine> InvoiceLineList = objInvoiceLine.list();

                int NumInvoiceline = InvoiceLineList.size();

                if (NumInvoiceline > 0) {

                  for (InvoiceLine objInvoiceLine2 : objInvoiceLine.list()) {

                    if (objInvoiceLine2.getSalesOrderLine().getId().toString()
                        .equals(strOrderlineID.getId())) {

                      String strDocstatus2 = objInvoiceLine2.getInvoice().getDocumentStatus()
                          .toString();
                      if (NumInvoiceline == 0) {

                        throw new OBException(Utility.messageBD(conn,
                            "@ERROR= CERTIFICADO NO TIENE FACTURA RELACIONA@", language));

                      } else if (strDocstatus2.equals("DR")) {
                        throw new OBException(
                            Utility
                                .messageBD(
                                    conn,
                                    "@ERROR= CERTIFICADO TIENE RELACIONADO UNA FACTURA EN ESTADO BORRADOR@",
                                    language));
                      }
                    }

                  }
                } else {
                  throw new OBException(Utility.messageBD(conn,
                      "@ERROR= CERTIFICADO TIENE RELACIONADO SOLO LA ORDEN DE COMPRA", language));
                }

              }

            }

          }
          // else
          // {

          // throw new OBException(Utility.messageBD(conn,
          // "@ERROR= CERTIFICADO NO TIENE RELACIONADO UN PEDIDO DE COMPRA/FACTURA DE COMPRA",
          // language) );

          // }

        }
        // Fin Validación

        for (SFBBudgetCertLine certline : certificate.getSfbBudgetCertLineList()) {

          // Find any budget line with enough available amount
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
            BigDecimal budgetActualValue = certline.getBudgetActualValue();

            switch (calendar.get(Calendar.MONTH)) {
            case 0:
              budgetLine.setJANCommittedValue(budgetLine.getJANCommittedValue().subtract(
                  budgetActualValue));
              break;
            case 1:
              budgetLine.setFEBCommittedValue(budgetLine.getFEBCommittedValue().subtract(
                  budgetActualValue));
              break;
            case 2:
              budgetLine.setMARCommittedValue(budgetLine.getMARCommittedValue().subtract(
                  budgetActualValue));
              break;
            case 3:
              budgetLine.setAPRCommittedValue(budgetLine.getAPRCommittedValue().subtract(
                  budgetActualValue));
              break;
            case 4:
              budgetLine.setMAYCommittedValue(budgetLine.getMAYCommittedValue().subtract(
                  budgetActualValue));
              break;
            case 5:
              budgetLine.setJUNCommittedValue(budgetLine.getJUNCommittedValue().subtract(
                  budgetActualValue));
              break;
            case 6:
              budgetLine.setJULCommittedValue(budgetLine.getJULCommittedValue().subtract(
                  budgetActualValue));
              break;
            case 7:
              budgetLine.setAUGCommittedValue(budgetLine.getAUGCommittedValue().subtract(
                  budgetActualValue));
              break;
            case 8:
              budgetLine.setSEPCommittedValue(budgetLine.getSEPCommittedValue().subtract(
                  budgetActualValue));
              break;
            case 9:
              budgetLine.setOCTCommittedValue(budgetLine.getOCTCommittedValue().subtract(
                  budgetActualValue));
              break;
            case 10:
              budgetLine.setNOVCommittedValue(budgetLine.getNOVCommittedValue().subtract(
                  budgetActualValue));
              break;
            case 11:
              budgetLine.setDECCommittedValue(budgetLine.getDECCommittedValue().subtract(
                  budgetActualValue));
              break;
            }

            OBDal.getInstance().save(certline);
            OBDal.getInstance().save(budgetLine);
          }
        }

        OBDal.getInstance().flush(); // certificate lines update must precede certificate update in
                                     // order to prevent copied version update constraint.
        certificate.setProcess("Y");
        certificate.setCertificateStatus("CL");
        certificate.setClosecert("Y");
        successMessage = "SFB_CertificateClosed";
      }

      message.setTitle(Utility.messageBD(conn, "ProcessOK", language));
      message.setType("Success");
      message.setMessage(Utility.messageBD(conn, successMessage, language));
      OBDal.getInstance().save(certificate);
      OBDal.getInstance().flush();
    }
  }
}
