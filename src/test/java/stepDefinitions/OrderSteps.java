package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import utils.ConfigReader;
import utils.DriverFactory;

public class OrderSteps
{
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    @Given("I am logged in as {string}")
    public void iAmLoggedInAs(String username)
    {
        DriverFactory.getDriver().get(ConfigReader.get("app.url"));
        loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.login(username, "secret_sauce");
        productsPage = new ProductsPage(DriverFactory.getDriver());
        Assert.assertTrue(productsPage.isProductPageDisplayed());
    }


    @When("I add a product to the cart and complete the checkout")
    public void iAddAProductToTheCartAndCompleteTheCheckout()
    {
        productsPage.addFirstProductToCart();
        ;
        productsPage.goToCart();
        cartPage = new CartPage(DriverFactory.getDriver());
        Assert.assertTrue(cartPage.isCartPageDisplayed());
        cartPage.clickCheckout();
        checkoutPage = new CheckoutPage(DriverFactory.getDriver());
        checkoutPage.enterCheckoutInfo("Michael", "Salama", "12345");
        checkoutPage.clickContinue();
        checkoutPage.clickFinish();

    }

    @Then("I should see the order confirmation")
    public void iShouldSeeTheOrderConfirmation()
    {
        String confirmationMessage = checkoutPage.getConfirmationMessage();
        Assert.assertEquals(confirmationMessage, "Thank you for your order!");
    }
}
