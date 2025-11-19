package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver loginDriver;


    //Locators
    By userNameLocator = By.name("username");
    By passWordLocator = By.name("password");
    By loginButtonLocator = By.cssSelector("button[type=\"submit\"]");
    By errorMsgLocator = By.cssSelector("p.oxd-alert-content-text");
    By dashboardLocator = By.cssSelector("h6.oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module");
    By forgotPasswordLocator = By.xpath("//p[text()='Forgot your password?']");
    By requiredFieldLocator = By.xpath("//*[text()='Required']");


    // Constructor
    public LoginPage(WebDriver driver) {
        loginDriver = driver;
    }

    // Method (Action)

    public void loginSteps(String username, String password) {
        loginDriver.findElement(userNameLocator).sendKeys(username);
        loginDriver.findElement(passWordLocator).sendKeys(password);
        loginDriver.findElement(loginButtonLocator).click();

    }// Validation
    public String getErrorMessage() {
        return loginDriver.findElement(errorMsgLocator).getText();
    }

    public boolean isLoginSuccessful() {
        try {
            return loginDriver.findElement(dashboardLocator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getPasswordFieldType() {
        return loginDriver.findElement(passWordLocator).getAttribute("type");
    }

    public int getRequiredMessagesCount() {
        return loginDriver.findElements(requiredFieldLocator).size();
    }

    public void clickForgotPassword()
    {
        loginDriver.findElement(forgotPasswordLocator);
    }
}



