package ec.com.sidesoft.secondary.accounting;

import java.util.Map;

import org.openbravo.client.application.FilterExpression;

public class AccountElementFilterExpression implements FilterExpression {

  @Override
  public String getExpression(Map<String, String> requestMap) {

    String inpelemtId = requestMap.get("inpelementId");
    StringBuilder whereClause = new StringBuilder();
    whereClause.append(" e.elementLevel = 'S' and e.summaryLevel = 'N' ");
    whereClause.append(" and e.accountingElement.id = '" + inpelemtId + "' ");
    return whereClause.toString();
  }

}
