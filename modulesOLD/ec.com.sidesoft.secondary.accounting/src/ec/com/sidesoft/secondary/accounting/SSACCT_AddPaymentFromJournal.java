package ec.com.sidesoft.secondary.accounting;

import javax.servlet.http.HttpServletRequest;

import org.openbravo.base.exception.OBException;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.client.kernel.RequestContext;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.DalBaseProcess;

public class SSACCT_AddPaymentFromJournal extends DalBaseProcess {

  @Override
  protected void doExecute(ProcessBundle bundle) throws Exception {
    int cont = 0;

    // Recover context and variables
    ConnectionProvider conn = bundle.getConnection();
    VariablesSecureApp varsAux = bundle.getContext().toVars();
    HttpServletRequest request = RequestContext.get().getRequest();

    OBContext.setOBContext(varsAux.getUser(), varsAux.getRole(), varsAux.getClient(),
        varsAux.getOrg());
    VariablesSecureApp vars = new VariablesSecureApp(request);

    // retrieve the parameters from the bundle
    final String journalId = (String) bundle.getParams().get("Ssacct_Journal_ID");
    String docAction = vars.getStringParameter("inpdocaction");
    if ("".equals(docAction)) {
      docAction = "CO";
    }

    try {
      // Set the docAction of the Journal (Complete, Reactivate, Close...)
      SSACCTJOURNAL journal = OBDal.getInstance().get(SSACCTJOURNAL.class, journalId);
      journal.setDocumentAction("--");
      journal.setDocumentStatus(docAction);
      journal.setProcessed(true);
      OBDal.getInstance().flush();
      // OBDal.getInstance().refresh(journal);

      // OBError is also used for successful results
      final OBError msg = new OBError();
      msg.setType("Success");
      msg.setTitle("@Success@");
      if (cont > 0) {
        msg.setMessage(" @FIN_NumberOfPayments@: " + cont);
      }

      bundle.setResult(msg);
      OBDal.getInstance().commitAndClose();

    } catch (final OBException e) {
      final OBError msg = new OBError();
      msg.setType("Error");
      msg.setMessage(e.getMessage());
      msg.setTitle("@Error@");
      OBDal.getInstance().rollbackAndClose();
      bundle.setResult(msg);
    }

  }

}
