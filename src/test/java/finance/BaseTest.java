package finance;

import finance.util.PropertyLoader;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import ru.stqa.selenium.factory.WebDriverPool;

public class BaseTest {

    protected static String gridHubUrl;
    protected static String baseUrl;
    protected static Capabilities capabilities;

    protected WebDriver driver;

    @ClassRule
    public static ExternalResource webDriverProperties = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            baseUrl = PropertyLoader.loadProperty("site.url");
            gridHubUrl = PropertyLoader.loadProperty("grid2.hub");
            baseUrl = PropertyLoader.loadProperty("site.url");
            gridHubUrl = PropertyLoader.loadProperty("grid.url");
            if ("".equals(gridHubUrl)) {
                gridHubUrl = null;
            }
            capabilities = PropertyLoader.loadCapabilities();
        }

        ;
    };

    @Rule
    public ExternalResource webDriver = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            driver = WebDriverPool.DEFAULT.getDriver(gridHubUrl, capabilities);
        }

        ;
    };
}
