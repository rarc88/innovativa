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
 * All portions are Copyright (C) 2008-2017 Openbravo SLU 
 * All Rights Reserved. 
 * Contributor(s):
 *   Martin Taal <martin.taal@openbravo.com>,
 *   Ivan Perdomo <ivan.perdomo@openbravo.com>,
 *   Leo Arias <leo.arias@openbravo.com>.
 ************************************************************************
 */

package org.openbravo.test.dal;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeThat;

import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.criterion.Restrictions;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;
import org.openbravo.base.exception.OBSecurityException;
import org.openbravo.base.model.Property;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.base.session.OBPropertiesProvider;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.dal.core.DalUtil;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.core.SessionHandler;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.dal.service.OBQuery;
import org.openbravo.database.ExternalConnectionPool;
import org.openbravo.model.ad.system.SystemInformation;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.businesspartner.Category;
import org.openbravo.model.common.businesspartner.CategoryAccounts;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.financialmgmt.cashmgmt.CashBook;
import org.openbravo.model.financialmgmt.cashmgmt.CashBookAccounts;
import org.openbravo.model.materialmgmt.transaction.MaterialTransaction;
import org.openbravo.test.base.OBBaseTest;

/**
 * Test different parts of the dal api: {@link OBDal} and {@link OBCriteria}.
 * 
 * Note the testcases assume that they are run in the order defined in this class.
 * 
 * @author mtaal
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DalTest extends OBBaseTest {
  private static final Logger log = Logger.getLogger(DalTest.class);

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  /**
   * Test to assert save false in a null char(1) column - Part I
   */
  @Test
  public void testASaveBooleanValue1() {
    setSystemAdministratorContext();
    SystemInformation sysInfo = OBDal.getInstance().get(SystemInformation.class, "0");
    if (sysInfo.isEnableHeartbeat() == null) {
      sysInfo.setEnableHeartbeat(false);
    }
    OBDal.getInstance().save(sysInfo);
    OBDal.getInstance().commitAndClose();
  }

  /**
   * Test to assert save false in a null char(1) column - Part II
   */
  @Test
  public void testBSaveBooleanValue2() {
    setSystemAdministratorContext();
    SystemInformation sysInfo = OBDal.getInstance().get(SystemInformation.class, "0");
    assertTrue(sysInfo.isEnableHeartbeat() != null);
    OBDal.getInstance().commitAndClose();
  }

  /**
   * Test creates a {@link Category}, test simple save through {@link OBDal}. The new object is
   * removed in a later test.
   */
  @Test
  public void testCCreateBPGroup() {
    setTestUserContext();
    addReadWriteAccess(Category.class);
    final Category bpg = OBProvider.getInstance().get(Category.class);
    bpg.setDefault(true);
    bpg.setDescription("testdescription");
    bpg.setName("testname");
    bpg.setSearchKey("testvalue");
    bpg.setActive(true);
    OBDal.getInstance().save(bpg);
    OBDal.getInstance().commitAndClose();
  }

  /**
   * Test queries for the {@link Category} created in the previous step and removes it.
   */
  @Test
  public void testDRemoveBPGroup() {
    setTestUserContext();
    addReadWriteAccess(Category.class);
    addReadWriteAccess(CategoryAccounts.class);
    final OBCriteria<Category> obCriteria = OBDal.getInstance().createCriteria(Category.class);
    obCriteria.add(Restrictions.eq(Category.PROPERTY_NAME, "testname"));
    final List<Category> bpgs = obCriteria.list();
    assertEquals(1, bpgs.size());
    final Category bpg = bpgs.get(0);
    final OBContext obContext = OBContext.getOBContext();
    assertEquals(obContext.getUser().getId(), bpg.getCreatedBy().getId());
    assertEquals(obContext.getUser().getId(), bpg.getUpdatedBy().getId());

    // first delete the related accounts
    final OBCriteria<CategoryAccounts> obc2 = OBDal.getInstance().createCriteria(
        CategoryAccounts.class);
    obc2.add(Restrictions.eq(CategoryAccounts.PROPERTY_BUSINESSPARTNERCATEGORY, bpgs.get(0)));
    final List<CategoryAccounts> bpgas = obc2.list();
    for (final CategoryAccounts bga : bpgas) {
      OBDal.getInstance().refresh(bga);
      OBDal.getInstance().remove(bga);
    }
    OBDal.getInstance().remove(bpgs.get(0));
    OBDal.getInstance().commitAndClose();
  }

  /**
   * This test checks if the {@link Category} was removed in the previous step.
   */
  @Test
  public void testECheckBPGroupRemoved() {
    setTestUserContext();
    addReadWriteAccess(Category.class);
    final OBCriteria<Category> obc = OBDal.getInstance().createCriteria(Category.class);
    obc.add(Restrictions.eq(Category.PROPERTY_NAME, "testname"));
    final List<Category> bpgs = obc.list();
    assertEquals(0, bpgs.size());
  }

  // test querying for a specific currency and then updating it
  // should fail for a user
  @Test
  public void testFUpdateCurrencyByUser() {
    setUserContext("E12DC7B3FF8C4F64924A98195223B1F8");
    final OBCriteria<Currency> obc = OBDal.getInstance().createCriteria(Currency.class);
    obc.add(Restrictions.eq(Currency.PROPERTY_ISOCODE, DOLLAR));
    final List<Currency> cs = obc.list();
    assertEquals(1, cs.size());
    final Currency c = cs.get(0);
    // Call getValue and setValue directly to work around security checks on the description
    // that are not the objective of this test.
    c.setValue(Currency.PROPERTY_DESCRIPTION, c.getValue(Currency.PROPERTY_DESCRIPTION) + " a test");
    try {
      OBDal.getInstance().save(c);
      OBDal.getInstance().commitAndClose();
      fail("No security check");
    } catch (final OBSecurityException e) {
      // successful check
      rollback();
    }
  }

  /**
   * Test updates the description of {@link Currency} by the admin user.
   */
  @Test
  public void testGUpdateCurrencyByAdmin() {
    setTestAdminContext();
    Currency c = null;
    String prevDescription = null;
    String newDescription = null;
    {
      final OBCriteria<Currency> obc = OBDal.getInstance().createCriteria(Currency.class);
      obc.add(Restrictions.eq(Currency.PROPERTY_ISOCODE, DOLLAR));
      final List<Currency> cs = obc.list();
      assertEquals(1, cs.size());
      c = cs.get(0);
      prevDescription = c.getDescription();
      c.setDescription(c.getDescription() + " a test");
      newDescription = c.getDescription();
      OBDal.getInstance().save(c);
      commitTransaction();
    }

    // roll back the change, while doing some checks
    {
      final OBCriteria<Currency> obc = OBDal.getInstance().createCriteria(Currency.class);
      obc.add(Restrictions.eq(Currency.PROPERTY_ISOCODE, DOLLAR));
      final List<Currency> cs = obc.list();
      assertEquals(1, cs.size());
      final Currency newC = cs.get(0);
      assertTrue(c != newC);
      assertEquals(newDescription, newC.getDescription());
      newC.setDescription(prevDescription);
      commitTransaction();
    }
  }

  /**
   * Tests the toString method of the BaseOBObject ({@link BaseOBObject#toString()}).
   */
  @Test
  public void testHToString() {
    setTestAdminContext();
    final List<Product> products = OBDal.getInstance().createCriteria(Product.class).list();
    final StringBuilder sb = new StringBuilder();
    for (final Product p : products) {
      sb.append(p.toString());
    }
    OBDal.getInstance().commitAndClose();
  }

  /**
   * Tests a paged read of {@link MaterialTransaction} objects and print of the identifier. The
   * identifier of a transaction has been implemented such that it reads all the references (which
   * are non-null) and uses their identifier to create the identifier of the transaction. Also tests
   * sorting on the name of a related entity (in this case {@link MaterialTransaction#getProduct()
   * #getName()}.
   */
  @Test
  public void testITransaction25PageRead() {
    setTestUserContext();
    addReadWriteAccess(MaterialTransaction.class);
    final OBCriteria<MaterialTransaction> countObc = OBDal.getInstance().createCriteria(
        MaterialTransaction.class);
    final int count = countObc.count();
    final int pageSize = 25;
    int pageCount = 1 + (count / pageSize);
    if (pageCount > 25) {
      pageCount = 25;
    }
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < pageCount; i++) {
      final OBCriteria<MaterialTransaction> obc = OBDal.getInstance().createCriteria(
          MaterialTransaction.class);
      obc.addOrderBy(MaterialTransaction.PROPERTY_PRODUCT + "." + Product.PROPERTY_NAME, false);
      obc.setMaxResults(pageSize);
      obc.setFirstResult(i * pageSize);

      sb.append("\nPAGE>>> " + (1 + i));
      for (final MaterialTransaction t : obc.list()) {
        sb.append("\n" + t.getIdentifier());
      }
    }
    OBDal.getInstance().commitAndClose();
  }

  /**
   * Test reads 500 pages of the {@link MaterialTransaction} table and then prints how many
   * milliseconds one page took to retrieve.
   */
  @Test
  public void testJTransactionAllPagesTime() {
    setSystemAdministratorContext();
    final OBCriteria<MaterialTransaction> countObc = OBDal.getInstance().createCriteria(
        MaterialTransaction.class);
    final int count = countObc.count();
    long time = System.currentTimeMillis();
    final int pageSize = 25;
    int pageCount = 1 + (count / pageSize);
    pageCount = 500;
    long avg = 0;
    for (int i = 0; i < pageCount; i++) {
      final OBCriteria<MaterialTransaction> obc = OBDal.getInstance().createCriteria(
          MaterialTransaction.class);
      obc.addOrderBy(MaterialTransaction.PROPERTY_PRODUCT + "." + Product.PROPERTY_NAME, false);
      obc.setMaxResults(pageSize);
      obc.setFirstResult(i * pageSize);
      for (final MaterialTransaction t : obc.list()) {
        log.debug(t.getIdentifier());
        // System.err.println(t.getIdentifier() +
        // " client/organization " +
        // t.getClient().getName() + "/" +
        // t.getOrganization().getName());
      }
      if (avg == 0) {
        avg = System.currentTimeMillis() - time;
      } else {
        avg = (avg + System.currentTimeMillis() - time) / 2;
      }
      time = System.currentTimeMillis();
      SessionHandler.getInstance().commitAndClose();
    }
    OBDal.getInstance().commitAndClose();
    log.debug("Read " + pageCount + " pages with average " + avg + " milliSeconds per page");
  }

  /**
   * Tests paged read of {@link Currency} objects.
   */
  @Test
  public void testKCurrencyPageRead() {
    setSystemAdministratorContext();
    final int count = OBDal.getInstance().createCriteria(Currency.class).count();
    final int pageSize = 5;
    final int pageCount = 1 + (count / 5);
    for (int i = 0; i < pageCount; i++) {
      final OBCriteria<Currency> obc = OBDal.getInstance().createCriteria(Currency.class);
      obc.addOrderBy(Currency.PROPERTY_ISOCODE, false);
      obc.setMaxResults(pageSize);
      obc.setFirstResult(i * pageSize);

      log.debug("PAGE>>> " + (1 + i));
      for (final Currency c : obc.list()) {
        log.debug(c.getISOCode() + " " + c.getSymbol());
      }
    }
    OBDal.getInstance().commitAndClose();
  }

  /**
   * Tests paged read of {@link CashBook} objects.
   */
  @Test
  public void testLCashBookPageRead() {
    setSystemAdministratorContext();
    final int count = OBDal.getInstance().createCriteria(CashBook.ENTITY_NAME).count();
    final int pageSize = 5;
    final int pageCount = 1 + (count / 5);
    for (int i = 0; i < pageCount; i++) {
      final OBCriteria<CashBook> obc = OBDal.getInstance().createCriteria(CashBook.ENTITY_NAME);
      obc.setFirstResult(i * pageSize);
      obc.setMaxResults(pageSize);

      log.debug("CashBook PAGE>>> " + (1 + i));
      for (final CashBook c : obc.list()) {
        log.debug(c.getName() + " " + c.getDescription());
      }
    }
    OBDal.getInstance().commitAndClose();
  }

  /**
   * Tests if a database trigger is fired on creation of a {@link CashBook}.
   */
  @Test
  public void testMCashBookTrigger() {
    setTestUserContext();
    OBContext.setAdminMode(true);
    try {
      String cashBookId = "";
      {
        final OBCriteria<Currency> cc = OBDal.getInstance().createCriteria(Currency.class);
        cc.add(Restrictions.eq(Currency.PROPERTY_ISOCODE, DOLLAR));
        final List<Currency> cs = cc.list();
        final Currency currency = cs.get(0);
        final CashBook c = OBProvider.getInstance().get(CashBook.class);
        c.setName("c_" + System.currentTimeMillis());
        c.setDescription("test");
        c.setDefault(false);
        c.set(CashBook.PROPERTY_CURRENCY, currency);

        OBDal.getInstance().save(c);
        cashBookId = c.getId();
        SessionHandler.getInstance().commitAndClose();
      }

      // now check if the save indeed worked out by seeing if there is a
      // cashbook account
      final OBCriteria<CashBookAccounts> cbc = OBDal.getInstance().createCriteria(
          CashBookAccounts.ENTITY_NAME);
      cbc.add(Restrictions.eq(CashBookAccounts.PROPERTY_CASHBOOK + "." + CashBook.PROPERTY_ID,
          cashBookId));
      final List<?> cbas = cbc.list();
      assertTrue(cbas.size() > 0);
      for (final Object co : cbas) {
        final CashBookAccounts cba = (CashBookAccounts) co;
        log.debug(cba.getUpdated() + " " + cba.getCashbook().getName());
        OBDal.getInstance().remove(cba);
      }
      OBDal.getInstance().remove(OBDal.getInstance().get(CashBook.class, cashBookId));
    } finally {
      OBContext.restorePreviousMode();
    }
    OBDal.getInstance().commitAndClose();
  }

  @Test
  public void testNGetPropertyFromColumnName() {
    final Property property = DalUtil.getProperty("AD_COLUMN", "AD_COLUMN_ID");
    assertNotNull(property);
  }

  @Test
  public void getInexistentObjShouldBeNull() {
    BusinessPartner bp = OBDal.getInstance().get(BusinessPartner.class, "DummyId");

    assertThat(bp, is(nullValue()));
  }

  @Test
  public void getInexistentObjByEntityNameShouldBeNull() {
    BusinessPartner bp = (BusinessPartner) OBDal.getInstance().get(BusinessPartner.ENTITY_NAME,
        "DummyId");

    assertThat(bp, is(nullValue()));
  }

  @Test
  public void getInexistentObjShouldBeNullEvenIfItWasProxied() {
    @SuppressWarnings("unused")
    BusinessPartner bpProxy = OBDal.getInstance().getProxy(BusinessPartner.class, "DummyId");
    BusinessPartner bp = OBDal.getInstance().get(BusinessPartner.class, "DummyId");

    assertThat(bp, is(nullValue()));
  }

  @Test
  public void getInexistentObjByEntityNameShouldBeNullEvenIfItWasProxied() {
    @SuppressWarnings("unused")
    BusinessPartner bpProxy = (BusinessPartner) OBDal.getInstance().getProxy(
        BusinessPartner.ENTITY_NAME, "DummyId");
    BusinessPartner bp = (BusinessPartner) OBDal.getInstance().get(BusinessPartner.ENTITY_NAME,
        "DummyId");

    assertThat(bp, is(nullValue()));
  }

  @Test
  public void populatingProxyOfInexistentObjShouldFail() {
    BusinessPartner bpProxy = OBDal.getInstance().getProxy(BusinessPartner.class, "DummyId");

    thrown.expect(ObjectNotFoundException.class);
    // getting any property causes proxy population from db
    bpProxy.getName();
  }

  @Test
  public void countInOBCriteriaInitializesOnce() {
    setTestUserContext();
    setTestLogAppenderLevel(Level.WARN);

    final OBCriteria<Currency> obc = OBDal.getInstance().createCriteria(Currency.class);
    obc.add(Restrictions.eq(Currency.PROPERTY_ISOCODE, EURO));
    obc.count();

    assertThat(getTestLogAppender().getMessages(Level.WARN), hasSize(0));
  }

  @Test
  public void multipleInitializeCallsInOBCriteriaShouldThrowAWarning() {
    setTestUserContext();
    setTestLogAppenderLevel(Level.WARN);

    final OBCriteria<Currency> obc = OBDal.getInstance().createCriteria(Currency.class);
    obc.add(Restrictions.eq(Currency.PROPERTY_ISOCODE, EURO));
    if (obc.count() > 0) {
      obc.addOrderBy(Currency.PROPERTY_ISOCODE, false);
    }
    obc.list();

    assertThat(getTestLogAppender().getMessages(Level.WARN), hasSize(1));
  }

  @Test
  public void orderByShouldBeAppliedAfterCount() {
    setTestUserContext();

    final OBCriteria<Currency> obc = OBDal.getInstance().createCriteria(Currency.class);
    obc.add(Restrictions.or(
        //
        Restrictions.eq(Currency.PROPERTY_ISOCODE, EURO),
        Restrictions.eq(Currency.PROPERTY_ISOCODE, DOLLAR)));
    if (obc.count() > 0) {
      obc.addOrderBy(Currency.PROPERTY_ISOCODE, false);
    }

    assertEquals(DOLLAR, obc.list().get(0).getISOCode());
  }

  @Test
  public void defaultPoolIsClosedAfterCommit() {
    setTestUserContext();
    OBDal.getInstance().get(Currency.class, EURO_ID);
    OBDal.getInstance().commitAndClose();
    assertFalse(SessionHandler.isSessionHandlerPresent());
  }

  @Test
  public void defaultPoolIsClosedAfterRollback() {
    setTestUserContext();
    OBDal.getInstance().get(Currency.class, EURO_ID);
    OBDal.getInstance().rollbackAndClose();
    assertFalse(SessionHandler.isSessionHandlerPresent());
  }

  @Test
  public void defaultPoolCanBeUsedAfterCommit() {
    setTestUserContext();
    Currency currency = OBDal.getInstance().get(Currency.class, EURO_ID);
    OBDal.getInstance().commitAndClose();
    currency = OBDal.getInstance().get(Currency.class, DOLLAR_ID);
    assertEquals(DOLLAR, currency.getISOCode());
  }

  @Test
  public void defaultPoolCanBeUsedAfterRollback() {
    setTestUserContext();
    Currency currency = OBDal.getInstance().get(Currency.class, EURO_ID);
    OBDal.getInstance().rollbackAndClose();
    currency = OBDal.getInstance().get(Currency.class, DOLLAR_ID);
    assertEquals(DOLLAR, currency.getISOCode());
  }

  @Test
  public void readOnlyPoolNotClosedAfterCommitDefaultPool() {
    setTestUserContext();
    OBDal.getInstance().get(Currency.class, EURO_ID);
    OBDal.getReadOnlyInstance().get(Currency.class, EURO_ID);
    OBDal.getInstance().commitAndClose();
    boolean[] expectedAvailability = { false, true };
    boolean[] currentAvailability = {
        SessionHandler.isSessionHandlerPresent(ExternalConnectionPool.DEFAULT_POOL),
        SessionHandler.isSessionHandlerPresent(ExternalConnectionPool.READONLY_POOL) };
    assertThat("Session Handler is still present for the read-only pool", expectedAvailability,
        equalTo(currentAvailability));
  }

  @Test
  public void defaultPoolNotClosedAfterCommitReadOnlyPool() {
    setTestUserContext();
    OBDal.getInstance().get(Currency.class, EURO_ID);
    OBDal.getReadOnlyInstance().get(Currency.class, EURO_ID);
    OBDal.getReadOnlyInstance().commitAndClose();
    boolean[] expectedAvailability = { true, false };
    boolean[] currentAvailability = {
        SessionHandler.isSessionHandlerPresent(ExternalConnectionPool.DEFAULT_POOL),
        SessionHandler.isSessionHandlerPresent(ExternalConnectionPool.READONLY_POOL) };
    assertThat("Session Handler is still present for the default pool", expectedAvailability,
        equalTo(currentAvailability));
  }

  @Test
  public void readOnlyPoolCanBeUsedAfterClosingDefaultPool() {
    setTestUserContext();
    Currency currency = OBDal.getInstance().get(Currency.class, EURO_ID);
    OBDal.getInstance().commitAndClose();
    currency = OBDal.getReadOnlyInstance().get(Currency.class, DOLLAR_ID);
    assertEquals(DOLLAR, currency.getISOCode());
  }

  @Test
  public void defaultPoolCanBeUsedAfterClosingReadOnlyPool() {
    setTestUserContext();
    Currency currency = OBDal.getReadOnlyInstance().get(Currency.class, EURO_ID);
    OBDal.getReadOnlyInstance().commitAndClose();
    currency = OBDal.getInstance().get(Currency.class, DOLLAR_ID);
    assertEquals(DOLLAR, currency.getISOCode());
  }

  @Test
  public void readOnlyPoolCanNotInsert() {
    assumeThat("read-only pool is configured", isReadOnlyPoolDefined(), is(true));
    setTestUserContext();
    try {
      final Category category = OBProvider.getInstance().get(Category.class);
      category.setDefault(true);
      category.setDescription("ro_testdescription");
      category.setName("ro_testname");
      category.setSearchKey("ro_testvalue");
      category.setActive(true);
      OBDal.getReadOnlyInstance().save(category);
      OBDal.getReadOnlyInstance().commitAndClose();
    } catch (Exception ignored) {
    }
    final OBCriteria<Category> obCriteria = OBDal.getReadOnlyInstance().createCriteria(
        Category.class);
    obCriteria.add(Restrictions.eq(Category.PROPERTY_NAME, "ro_testname"));
    final List<Category> categories = obCriteria.list();
    assertEquals(0, categories.size());
  }

  @Test
  public void readOnlyPoolCanNotUpdate() {
    assumeThat("read-only pool is configured", isReadOnlyPoolDefined(), is(true));
    setTestUserContext();
    final String newDescription = "ro_testdescription";
    try {
      Category category = OBDal.getReadOnlyInstance().get(Category.class, TEST_BP_CATEGORY_ID);
      category.setDescription(newDescription);
      OBDal.getReadOnlyInstance().commitAndClose();
    } catch (Exception ignored) {
    }
    Category category = OBDal.getReadOnlyInstance().get(Category.class, TEST_BP_CATEGORY_ID);
    assertThat(newDescription, not(equalTo(category.getDescription())));
  }

  @Test
  public void readOnlyPoolCanNotDelete() {
    assumeThat("read-only pool is configured", isReadOnlyPoolDefined(), is(true));
    setTestUserContext();
    try {
      Category category = OBDal.getReadOnlyInstance().get(Category.class, TEST_BP_CATEGORY_ID);
      OBDal.getReadOnlyInstance().remove(category);
      OBDal.getReadOnlyInstance().commitAndClose();
    } catch (Exception ignored) {
    }
    Category category = OBDal.getInstance().get(Category.class, TEST_BP_CATEGORY_ID);
    assertNotNull(category);
  }

  private boolean isReadOnlyPoolDefined() {
    return OBPropertiesProvider.getInstance().getOpenbravoProperties()
        .containsKey("bbdd.readonly.url");
  }

  /**
   * Test to check that an OBQuery with a select clause can be executed properly without setting an
   * alias for the main entity of the query.
   */
  @Test
  public void testOBQueryWithoutAlias() {
    setTestUserContext();
    String isoCode = getISOCodeFromCurrencyId(EURO_ID, false);
    assertEquals(isoCode, EURO);
  }

  /**
   * Test to check that an OBQuery with a select clause can be executed properly by defining an
   * alias for the main entity of the query.
   */
  @Test
  public void testOBQueryWithAlias() {
    setTestUserContext();
    String isoCode = getISOCodeFromCurrencyId(EURO_ID, true);
    assertEquals(isoCode, EURO);
  }

  private String getISOCodeFromCurrencyId(String currencyId, boolean includeAlias) {
    String isoCode = null;
    try {
      StringBuilder hql = new StringBuilder();
      if (includeAlias) {
        hql.append(" as c");
        hql.append(" where c." + Currency.PROPERTY_ID);
      } else {
        hql.append(" where " + Currency.PROPERTY_ID);
      }
      hql.append(" = :currencyId");
      OBQuery<Currency> query = OBDal.getInstance().createQuery(Currency.class, hql.toString());
      query.setNamedParameter("currencyId", currencyId);
      query.setSelectClause(Currency.PROPERTY_ISOCODE);
      isoCode = (String) query.uniqueResultObject();
    } catch (Exception ignored) {
    }
    return isoCode;
  }
}
