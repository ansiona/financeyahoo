package finance.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class FinancialsBasePage extends BasePage {

    @FindBy(xpath = "//td[.='Total Revenue']/following-sibling::td")
    private WebElement lastTotalRevenue;

    public FinancialsBasePage(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement getLastTotalRevenue() {
        return lastTotalRevenue;
    }
}
