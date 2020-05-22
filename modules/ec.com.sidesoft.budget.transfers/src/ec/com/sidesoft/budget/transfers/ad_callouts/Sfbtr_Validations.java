package ec.com.sidesoft.budget.transfers.ad_callouts;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;

import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.session.OBPropertiesProvider;
import org.openbravo.client.kernel.KernelConstants;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.accounting.UserDimension1;
import org.openbravo.model.financialmgmt.calendar.Year;
import org.openbravo.service.db.DalConnectionProvider;

import com.sidesoft.flopec.budget.data.SFBBudget;
import com.sidesoft.flopec.budget.data.SFBBudgetArea;
import com.sidesoft.flopec.budget.data.SFBBudgetItem;
import com.sidesoft.flopec.budget.data.SFBBudgetLine;
import com.sidesoft.flopec.budget.data.SFBBudgetVersion;

public class Sfbtr_Validations extends SimpleCallout {

  /**
   * 
   */

  @Override
  protected void execute(CalloutInfo info) throws ServletException {
    try {
      OBContext.setAdminMode();

      String language = OBContext.getOBContext().getLanguage().getLanguage();
      ConnectionProvider conn = new DalConnectionProvider(false);
      // RECUPERAR REGISTROS DE LA VENTANA
      String StrRegistrationDate = info.getStringParameter("inpregistrationDate", null);
      String strYearId = info.getStringParameter("inpcYearId", null);
      String strTypeOfBudget = info.getStringParameter("inptypeOfBudget", null);
      String strSFBBudgetArea = info.getStringParameter("inpsfbBudgetAreaId", null);
      String strCostcenter = info.getStringParameter("inpcCostcenterId", null);
      String strUserDimension1 = info.getStringParameter("inpuser1Id", null);
      String strSFBBudgetItem = info.getStringParameter("inpsfbBudgetItemId", null);

      Year ObjYear = OBDal.getInstance().get(Year.class, strYearId);
      SFBBudgetArea ObjSFBBudgetArea = OBDal.getInstance().get(SFBBudgetArea.class,
          strSFBBudgetArea);
      Costcenter ObjCostcenter = OBDal.getInstance().get(Costcenter.class, strCostcenter);
      UserDimension1 ObjUserDimension1 = OBDal.getInstance().get(UserDimension1.class,
          strUserDimension1);
      SFBBudgetItem ObjSFBBudgetItem = OBDal.getInstance().get(SFBBudgetItem.class,
          strSFBBudgetItem);

      String StrYear = ObjYear.getFiscalYear();

      // Validar Que la Fecha es igual al Ejercicio(Año).
      if (!StrRegistrationDate.contains(StrYear)) {
        info.addResult("inpregistrationDate", "");
        throw new OBException(Utility.messageBD(conn, "Sfbtr_RegistrationDate", language));
      }

      // Presupuesto
      if (strSFBBudgetItem != null && !strSFBBudgetItem.equals("")) {
        SFBBudgetLine budgetLineFrom = null;

        // Find any budget line that match From Budget Item
        OBCriteria<SFBBudgetLine> obcBudgetLine = OBDal.getInstance()
            .createCriteria(SFBBudgetLine.class);
        obcBudgetLine.add(Restrictions.eq(SFBBudgetLine.PROPERTY_COSTCENTER, ObjCostcenter));
        obcBudgetLine.add(Restrictions.eq(SFBBudgetLine.PROPERTY_STDIMENSION, ObjUserDimension1));
        obcBudgetLine.add(Restrictions.eq(SFBBudgetLine.PROPERTY_BUDGETITEM, ObjSFBBudgetItem));
        obcBudgetLine.add(Restrictions.eq(SFBBudgetLine.PROPERTY_AREA, ObjSFBBudgetArea));

        obcBudgetLine.createAlias(SFBBudgetLine.PROPERTY_SFBBUDGETVERSION, "version");
        obcBudgetLine
            .add(Restrictions.eq("version." + SFBBudgetVersion.PROPERTY_VERSIONSTATUS, "AP"));

        obcBudgetLine.createAlias("version." + SFBBudgetVersion.PROPERTY_SFBBUDGET, "budget");
        obcBudgetLine
            .add(Restrictions.eq("budget." + SFBBudget.PROPERTY_TYPEOFBUDGET, strTypeOfBudget));
        obcBudgetLine.add(Restrictions.eq("budget." + SFBBudget.PROPERTY_YEAR, ObjYear));

        // If not found
        if (obcBudgetLine.count() == 0) {
          OBDal.getInstance().rollbackAndClose();
          throw new OBException(Utility.messageBD(conn, "SFB_NoFromBudgetItem", language));
        } else {
          Object o = obcBudgetLine.list().get(0);
          Object[] os = (Object[]) o;
          budgetLineFrom = (SFBBudgetLine) os[2];
          info.addResult("inpavailableValue", budgetLineFrom.getActualValue().toString());
          info.addResult("inpsfbBudgetLineId", budgetLineFrom.getId());

        }
      }

    } catch (Exception e) {
      e.printStackTrace();
      info.addResult("ERROR", e.getMessage());
    } finally {
      OBContext.restorePreviousMode();
    }

  }

  protected Date formatDate(String date) throws ParseException {
    return new SimpleDateFormat((String) OBPropertiesProvider.getInstance().getOpenbravoProperties()
        .get(KernelConstants.DATETIME_FORMAT_PROPERTY)).parse(date);
  }
}
