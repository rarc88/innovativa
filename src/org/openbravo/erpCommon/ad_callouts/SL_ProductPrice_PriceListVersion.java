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
 * All portions are Copyright (C) 2012-2017 Openbravo SLU 
 * All Rights Reserved. 
 * Contributor(s):  ______________________________________.
 ************************************************************************
 */
package org.openbravo.erpCommon.ad_callouts;

import javax.servlet.ServletException;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.openbravo.base.filter.IsIDFilter;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBDal;
import org.openbravo.model.ad.access.Role;
import org.openbravo.model.ad.access.RoleOrganization;
import org.openbravo.model.pricing.pricelist.PriceListVersion;

/* Replaced by {@link org.openbravo.event.ProductPriceObserver.ProductPriceObserver},
 * which always overrides the organization by the price list version one. Note that the
 * UI has a validation to display only Price List Versions belonging to organizations
 * with access for the role
 */
@Deprecated
public class SL_ProductPrice_PriceListVersion extends SimpleCallout {

  @Override
  protected void execute(CalloutInfo info) throws ServletException {

    String strChanged = info.getLastFieldChanged();
    if (log4j.isDebugEnabled()) {
      log4j.debug("CHANGED: " + strChanged);
    }

    // Parameters
    String strPriceListV = info.getStringParameter("inpmPricelistVersionId", IsIDFilter.instance);
    String strOrg = info.getStringParameter("inpadOrgId", IsIDFilter.instance);

    // If the role has access to the Price List Version Organization, we set this organization to
    // the record.
    PriceListVersion plv = OBDal.getInstance().get(PriceListVersion.class, strPriceListV);
    final String plvOrgId = plv.getOrganization().getId();
    Role role = OBDal.getInstance().get(Role.class, info.vars.getRole());
    boolean hasAccessTo = hasRoleOrganizationAccess(role.getId(), plvOrgId)
        || (StringUtils.contains(role.getUserLevel(), "C") && StringUtils.equals(plvOrgId, "0"));
    info.addResult("inpadOrgId", ((hasAccessTo) ? plvOrgId : strOrg));
  }

  private boolean hasRoleOrganizationAccess(String roleId, String orgId) {
    try {
      OBContext.setAdminMode(false);
      StringBuffer hqlString = new StringBuffer();
      hqlString.append(" select " + RoleOrganization.PROPERTY_ORGANIZATION + ".id");
      hqlString.append(" from " + RoleOrganization.ENTITY_NAME);
      hqlString.append(" where " + RoleOrganization.PROPERTY_ROLE + ".id = :roleId");
      hqlString.append(" and " + RoleOrganization.PROPERTY_ORGANIZATION + ".id = :orgId");
      Query query = OBDal.getInstance().getSession().createQuery(hqlString.toString());
      query.setParameter("roleId", roleId);
      query.setParameter("orgId", orgId);
      query.setMaxResults(1);
      return query.uniqueResult() != null;
    } finally {
      OBContext.restorePreviousMode();
    }
  }
}
