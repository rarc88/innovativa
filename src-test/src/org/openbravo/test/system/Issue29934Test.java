/*
 *************************************************************************
 * The contents of this file are subject to the Openbravo  Public  License
 * Version  1.1  (the  "License"),  being   the  Mozilla   Public  License
 * Version 1.1  with a permitted attribution clause; you may not  use this
 * file except in compliance with the License. You  may  obtain  a copy of
 * the License at http://www.openbravo.com/legal/license.html 
 * Software distributed under the License  is  distributed  on  an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific  language  governing  rights  and  limitations
 * under the License. 
 * The Original Code is Openbravo ERP. 
 * The Initial Developer of the Original Code is Openbravo SLU 
 * All portions are Copyright (C) 2015 Openbravo SLU 
 * All Rights Reserved. 
 * Contributor(s):  ______________________________________.
 ************************************************************************
 */

package org.openbravo.test.system;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.dal.core.OBContext;
import org.openbravo.model.ad.utility.DataSet;
import org.openbravo.service.dataset.DataSetService;
import org.openbravo.test.base.OBBaseTest;

/**
 * Tests this issue: https://issues.openbravo.com/view.php?id=29934 Extend VariablesBase to
 * internally store session values even if there is no session object
 * 
 * @author mtaal
 */

public class Issue29934Test extends OBBaseTest {

  /**
   * Test the {@link DataSetService#hasChanged(DataSet, Date)} method.
   */
  @Test
  public void doTest() {
    setTestUserContext();
    VariablesSecureApp app = new VariablesSecureApp(OBContext.getOBContext().getUser().getId(),
        OBContext.getOBContext().getCurrentClient().getId(), OBContext.getOBContext()
            .getCurrentOrganization().getId(), OBContext.getOBContext().getRole().getId());
    app.setSessionObject("abc", "val");
    assertTrue("val".equals(app.getSessionObject("abc")));
    assertTrue("val".equals(app.getSessionObject("ABC")));
    assertTrue(null == app.getSessionObject("ABD"));
    app.setSessionValue("TARGETQUERYSTRING", "tgstr");
    app.setSessionValue("TARGET", "tgvalue");
    assertTrue("tgstr".equals(app.getSessionObject("TARGETQUERYSTRING")));
    assertTrue("tgvalue".equals(app.getSessionObject("TARGET")));
    app.clearSession(false);
    assertTrue("tgstr".equals(app.getSessionObject("TARGETQUERYSTRING")));
    assertTrue("tgvalue".equals(app.getSessionObject("TARGET")));
    assertTrue(null == app.getSessionObject("ABC"));
    app.clearSession(true);
    assertTrue(null == app.getSessionObject("TARGETQUERYSTRING"));
    assertTrue(null == app.getSessionObject("TARGET"));
  }
}