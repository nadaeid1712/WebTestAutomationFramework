package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    // Locators
    By userNameLocator = By.name("username");
    By passWordLocator = By.name("password");
    By loginButtonLocator = By.cssSelector("button[type='submit']");
    By errorMsgLocator = By.cssSelector("p.oxd-alert-content-text");
    By dashboardLocator = By.cssSelector("h6.oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module");
    By forgotPasswordLocator = By.xpath("//p[text()='Forgot your password?']");
    By requiredFieldLocator = By.xpath("//*[text()='Required']");
    By userDropdownLocator = By.cssSelector("p.oxd-userdropdown-name"); // dropdown للـ logout
    By logoutButtonLocator = By.xpath("//a[text()='Logout']");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Actions
    public void loginSteps(String username, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameLocator)).clear();
        driver.findElement(userNameLocator).sendKeys(username);
        driver.findElement(passWordLocator).clear();
        driver.findElement(passWordLocator).sendKeys(password);
        driver.findElement(loginButtonLocator).click();
    }

    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsgLocator));
        return driver.findElement(errorMsgLocator).getText();
    }

    public boolean isLoginSuccessful() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardLocator));
            return driver.findElement(dashboardLocator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getPasswordFieldType() {
        return driver.findElement(passWordLocator).getAttribute("type");
    }

    public int getRequiredMessagesCount() {
        return driver.findElements(requiredFieldLocator).size();
    }

    public void clickForgotPassword() {
        driver.findElement(forgotPasswordLocator).click();
    }

    public void logout() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(userDropdownLocator)).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButtonLocator)).click();
        } catch (Exception e) {
        }
    }
}
