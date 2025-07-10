package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends AbstractComponents
{
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By psotalCodeField = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");
    private By confirmationMessage = By.cssSelector(".complete-header");

    public CheckoutPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterCheckoutInfo(String firstName, String lastName, String postalCode)
    {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(psotalCodeField).sendKeys(postalCode);
    }

    public void clickContinue()
    {
        driver.findElement(continueButton).click();
    }

    public void clickFinish()
    {
        driver.findElement(finishButton).click();
    }

    public String getConfirmationMessage()
    {
        return driver.findElement(confirmationMessage).getText();
    }
}
