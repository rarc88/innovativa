package ec.com.sidesoft.secondary.accounting;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.servlet.ServletException;

import org.apache.commons.lang.StringUtils;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;

public class SSACCT_JournalLineAmt extends SimpleCallout {

  @Override
  protected void execute(CalloutInfo info) throws ServletException {
    // TODO Auto-generated method stub

    String strChanged = info.getLastFieldChanged();
    if (log4j.isDebugEnabled()) {
      log4j.debug("CHANGED: " + strChanged);
    }

    // Parameters
    String strSSACCTJournal = info.vars.getRequiredStringParameter("inpssacctJournalId");
    String strCurrencyRateType = info.vars.getStringParameter("inpcurrencyratetype", "S");
    BigDecimal amtSourceDr = info.getBigDecimalParameter("inpamtsourcedr");
    BigDecimal amtSourceCr = info.getBigDecimalParameter("inpamtsourcecr");

    String strAcctSchema = SLJournalLineAmtData.selectGeneralLedger(this, strSSACCTJournal);
    SLJournalLineAmtData[] data = SLJournalLineAmtData.select(this, strAcctSchema);
    int stdPrecision = 2;
    if (data != null && data.length > 0) {
      stdPrecision = Integer.valueOf(data[0].stdprecision);
    }

    if (StringUtils.equals(strChanged, "inpamtsourcedr")
        && amtSourceDr.compareTo(BigDecimal.ZERO) != 0) {
      amtSourceCr = BigDecimal.ZERO;
    }
    if (StringUtils.equals(strChanged, "inpamtsourcecr")
        && amtSourceCr.compareTo(BigDecimal.ZERO) != 0) {
      amtSourceDr = BigDecimal.ZERO;
    }

    SSACCTJOURNAL ssacctJournal = OBDal.getInstance().get(SSACCTJOURNAL.class, strSSACCTJournal);
    BigDecimal currencyRate = ssacctJournal.getRate().setScale(stdPrecision, RoundingMode.HALF_UP);
    BigDecimal amtAcctDr = amtSourceDr.multiply(currencyRate).setScale(stdPrecision,
        RoundingMode.HALF_UP);
    BigDecimal amtAcctCr = amtSourceCr.multiply(currencyRate).setScale(stdPrecision,
        RoundingMode.HALF_UP);

    info.addResult("inpamtacctdr", amtAcctDr);
    info.addResult("inpamtacctcr", amtAcctCr);
    info.addResult("inpamtsourcedr", amtSourceDr);
    info.addResult("inpamtsourcecr", amtSourceCr);
    info.addResult("inpcurrencyrate", currencyRate);
    info.addResult("inpcurrencyratetype", strCurrencyRateType);

  }

}
