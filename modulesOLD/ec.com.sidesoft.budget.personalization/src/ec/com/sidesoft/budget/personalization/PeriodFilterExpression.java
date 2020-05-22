package ec.com.sidesoft.budget.personalization;

import java.util.Map;

import org.openbravo.client.application.FilterExpression;

public class PeriodFilterExpression implements FilterExpression {

  @Override
  public String getExpression(Map<String, String> requestMap) {
    StringBuilder whereClause = new StringBuilder();
    whereClause.append(" e.year.id = '" + requestMap.get("inpcYearId") + "' ");
    whereClause
        .append(" and  Exists (select 1 from PeriodControlLog pl where pl.periodNo.id  = e.id and  pl.periodAction = 'O' )");
    return whereClause.toString();
  }

}
