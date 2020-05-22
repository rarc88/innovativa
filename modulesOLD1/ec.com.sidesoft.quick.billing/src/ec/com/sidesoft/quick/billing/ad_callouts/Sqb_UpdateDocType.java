package ec.com.sidesoft.quick.billing.ad_callouts;

import javax.servlet.ServletException;

import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;
import org.openbravo.model.ad.utility.Sequence;
import org.openbravo.model.common.enterprise.DocumentType;

public class Sqb_UpdateDocType extends SimpleCallout {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Override
  protected void execute(CalloutInfo info) throws ServletException {

    String documentTypeId = info.getStringParameter("inpcDoctypeId", null);
    DocumentType docObj = OBDal.getInstance().get(DocumentType.class, documentTypeId);

    if (docObj.getDocumentSequence() != null) {

      Sequence seq = docObj.getDocumentSequence();
      info.addResult("inpdocumentno", "<" + seq.getNextAssignedNumber().toString() + ">");

    }
  }
}
