package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends AbstractComponents
{
    @FindBy(className = "title")
    private WebElement pageTitle;
    private By productAddToCartButton = By.cssSelector("button.btn_inventory");
    private By shoppingCartLink = By.className("shopping_cart_link");

    public ProductsPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isProductPageDisplayed()
    {
        waitForElementToAppear(pageTitle);
        return (pageTitle).getText().equals("Products");
    }

    public void addFirstProductToCart()
    {
        driver.findElements(productAddToCartButton).get(0).click();
    }

    public void goToCart()
    {
        driver.findElement(shoppingCartLink).click();
    }

    public String getPageUrl()
    {
        return driver.getCurrentUrl().toLowerCase();
    }

}
