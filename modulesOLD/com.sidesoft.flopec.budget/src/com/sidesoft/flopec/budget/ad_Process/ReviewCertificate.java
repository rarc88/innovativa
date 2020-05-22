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
import org.openbravo.model.ad.domain.Preference;
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

public class ReviewCertificate extends DalBaseProcess {
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
    String strStatus = certificate.getCertificateStatus();
    if (!strStatus.equals("RE") && !strStatus.equals("RW")) {
      message.setTitle(Utility.messageBD(conn, "SFB_CertificateWarning", language));
      message.setType("Warning");
      message.setMessage(Utility.messageBD(conn, "SFB_ReviewStatus", language));
    } else {
    	if(certificate.getReview().equals("Y")){
    		certificate.setReview("N");
    		certificate.setCertificateStatus("RW");
    	}else{
    		certificate.setReview("Y");
    		certificate.setCertificateStatus("RE");    		
    	}
    

      message.setTitle(Utility.messageBD(conn, "ProcessOK", language));
      message.setType("Success");
      message.setMessage(Utility.messageBD(conn, successMessage, language));
      OBDal.getInstance().save(certificate);
      OBDal.getInstance().flush();
    }
    }
}
