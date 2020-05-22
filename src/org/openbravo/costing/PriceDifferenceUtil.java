/*
 *************************************************************************
 * The contents of this file are subject to the Openbravo  Public  License
 * Version  1.0  (the  "License"),  being   the  Mozilla   Public  License
 * Version 1.1  with a permitted attribution clause; you may not  use this
 * file except in compliance with the License. You  may  obtain  a copy of
 * the License at http://www.openbravo.com/legal/license.html
 * Software distributed under the License  is  distributed  on  an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific  language  governing  rights  and  limitations
 * under the License.
 * The Original Code is Openbravo ERP.
 * The Initial Developer of the Original Code is Openbravo SLU
 * All portions are Copyright (C) 2017 Openbravo SLU
 * All Rights Reserved.
 * Contributor(s):  ______________________________________.
 *************************************************************************
 */

package org.openbravo.costing;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jettison.json.JSONException;
import org.hibernate.Query;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.security.OrganizationStructureProvider;
import org.openbravo.dal.service.OBDal;
import org.openbravo.model.common.enterprise.Organization;

public class PriceDifferenceUtil {

  public static final String ALL_ORGANIZATIONS = "0";

  public static void setTransactionsReadyForPriceAdjustment(List<String> productIds,
      Date movementdate, Organization organization) throws JSONException {

    String strUpdate = "UPDATE MaterialMgmtMaterialTransaction trx"
        + " SET checkpricedifference = 'Y'"
        + " WHERE exists ("
        + " SELECT 1"
        + " FROM  ProcurementReceiptInvoiceMatch mpo"
        + " WHERE trx.isCostCalculated = 'Y' and mpo.goodsShipmentLine.id = trx.goodsShipmentLine.id  "
        + " AND trx.movementDate >= :date and trx.organization.id in (:orgIds)"
        + " AND trx.client.id = :clientId)";

    if (!productIds.isEmpty()) {
      strUpdate = strUpdate.concat(" AND product.id IN :productIds ");
    }

    Set<String> products = new HashSet<String>();
    products.addAll(productIds);
    Query update = OBDal.getInstance().getSession().createQuery(strUpdate);

    if (!productIds.isEmpty()) {
      update.setParameterList("productIds", products);
    }
    update.setParameterList("orgIds",
        new OrganizationStructureProvider().getChildTree(organization.getId(), true));
    update.setDate("date", movementdate);
    update.setParameter("clientId", OBContext.getOBContext().getCurrentClient().getId());

    update.executeUpdate();
  }

  public static List<Organization> getLegalOrganizationList(String orgId) {
    List<Organization> legalOrganizations = new ArrayList<>();
    Organization organization = OBDal.getInstance().get(Organization.class, orgId);
    OrganizationStructureProvider osp = new OrganizationStructureProvider();

    List<Organization> childLegalOrganizations = osp.getChildLegalEntitesList(organization);
    // It is not possible to have a legal entity below another legal entity, therefore
    if (childLegalOrganizations.isEmpty()) {
      // If there are legal entities below the Organization, return the list of them
      legalOrganizations.add(osp.getLegalEntity(organization));
    } else {
      // Else, return the first parent legal entity
      legalOrganizations.addAll(childLegalOrganizations);
    }
    return legalOrganizations;
  }

  public static boolean isAllOrganizations(String orgId) {
    return StringUtils.equals(PriceDifferenceUtil.ALL_ORGANIZATIONS, orgId);
  }
}
