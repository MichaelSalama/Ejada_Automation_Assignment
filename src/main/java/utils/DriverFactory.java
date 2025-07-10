package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory
{
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver()
    {
        return driver.get();
    }

    public static void initDriver(String browser)
    {
        if (browser == null) {
            browser = ConfigReader.get("browser");
        }
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver());
                break;
            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }

        getDriver().manage().window().maximize();
    }

    public static void quitDriver()
    {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }
}
