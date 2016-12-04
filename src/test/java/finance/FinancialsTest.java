package finance;

import finance.steps.FinancialsSteps;
import finance.util.CsvUtil;
import org.apache.commons.csv.CSVRecord;
import org.junit.Test;

public class FinancialsTest extends BaseTest {

    @Test
    public void testHomePageHasAHeader() {

        FinancialsSteps financialsSteps = new FinancialsSteps(driver);

        for (CSVRecord record : CsvUtil.getCSVRecords("financialsdata.csv")) {
            String company = record.get(0);
            Long reportedAmount = Long.parseLong(record.get(1));
            String url = String.format("https://finance.yahoo.com/quote/%s/financials?p=%s", company, company);
            driver.get(url);
            financialsSteps.checkLastTotalRevenueIsWithin20(reportedAmount);
        }
    }
}