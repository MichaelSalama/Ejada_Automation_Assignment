package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractComponents
{
    @FindBy(id = "user-name")
    private WebElement usernameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(css = ".error-message-container")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username)
    {
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password)
    {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLogin()
    {
        loginButton.click();
    }

    public String getErrorMessage()
    {
        try {
            return errorMessage.getText();
        } catch (Exception e) {
            return "";
        }
    }

    public void login(String username, String password)
    {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}
