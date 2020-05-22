package ec.com.sidesoft.secondary.accounting;

import java.util.Map;

import org.openbravo.client.application.FilterExpression;

public class ElementValueFilterExpression implements FilterExpression {

  @Override
  public String getExpression(Map<String, String> requestMap) {
    StringBuilder sql = new StringBuilder();
    sql.append(" e.elementLevel = 'S' and e.summaryLevel = 'N'  ");
    sql.append(" and e.accountingElement.id in (select max(el.id) from FinancialMgmtElement el where el.organization.id = '"
        + requestMap.get("inpadOrgId") + "' ) ");
    return sql.toString();
  }
}
