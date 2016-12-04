package finance.steps;

import finance.pages.FinancialsBasePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.is;

public class FinancialsSteps {

    private WebDriver driver;
    private FinancialsBasePage financialsPage;

    public FinancialsSteps(final WebDriver driver) {
        this.financialsPage = PageFactory.initElements(driver, FinancialsBasePage.class);
    }

    public void checkLastTotalRevenueIsWithin20(final Long reportedAmount) {
        Long lastTotalRevenue = Long.parseLong(financialsPage.getLastTotalRevenue().getText().replace(",", "")) * 100;
        String message = String.format("%s is not within 20 percent of %s", reportedAmount, lastTotalRevenue);
        Assert.assertThat(message, lastTotalRevenue <= reportedAmount * 1.2 && lastTotalRevenue >= reportedAmount * 0.8, is(true));
    }
}
