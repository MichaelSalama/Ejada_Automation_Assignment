package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import utils.ConfigReader;
import utils.DriverFactory;

public class LoginSteps
{
    private LoginPage loginPage;
    private ProductsPage productsPage;

    @Given("I am on the login page")
    public void iAmOnTheLoginPage()
    {
        DriverFactory.getDriver().get(ConfigReader.get("app.url"));
        loginPage = new LoginPage(DriverFactory.getDriver());
    }

    @When("I login with username {string} and password {string}")
    public void iLoginWithUsernameAndPassword(String username, String password)
    {
        loginPage.login(username, password);
    }

    @Then("I should see {string}")
    public void iShouldSee(String expected)
    {
        if (expected.equals("Products page")) {
            Assert.assertTrue(productsPage.getPageUrl().contains("inventory.html"));
            //Assert.assertTrue(productsPage.isProductPageDisplayed());
        } else {
            String actualError = loginPage.getErrorMessage();
            Assert.assertTrue(actualError.contains(expected));
        }
    }
}
