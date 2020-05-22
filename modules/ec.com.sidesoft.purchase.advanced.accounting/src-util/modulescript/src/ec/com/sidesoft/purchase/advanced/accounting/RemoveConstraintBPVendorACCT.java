package ec.com.sidesoft.purchase.advanced.accounting;

import java.sql.PreparedStatement;

import org.apache.log4j.Logger;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.modulescript.ModuleScript;

public class RemoveConstraintBPVendorACCT extends ModuleScript {
  private static final Logger log4j = Logger.getLogger(RemoveConstraintBPVendorACCT.class);

  @Override
  public void execute() {
    ConnectionProvider cp = getConnectionProvider();
    PreparedStatement ps;
    try {
      ps = cp
          .getPreparedStatement("ALTER TABLE c_bp_vendor_acct DROP CONSTRAINT c_bp_vendor_acct_acctschema_un; ");
      ps.executeUpdate();
    } catch (Exception e) {
      System.out.println("The c_bp_vendor_acct_acctschema_un constraint is not exist.");
    }
  }

}
