package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.DriverFactory;

public class TestHooks
{
    @Before
    public void setUp(Scenario scenario)
    {
        String browserName = System.getProperty("browser");
        DriverFactory.initDriver(browserName);
    }

    @After
    public void tearDown(Scenario scenario)
    {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot");
        }
        DriverFactory.quitDriver();
    }
}
