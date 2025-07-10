package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends AbstractComponents
{
    @FindBy(className = "title")
    private WebElement pageTitle;
    private By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isCartPageDisplayed()
    {
        waitForElementToAppear(pageTitle);
        return (pageTitle).getText().equals("Your Cart");
    }

    public void clickCheckout()
    {
        driver.findElement(checkoutButton).click();
    }
}
