package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    private final By usernameField = By.name("username");
    private final By passwordField = By.name("password");
    private final By loginButton = By.cssSelector("button[type='submit']");
    private final By dashboardHeader = By.cssSelector("h6.oxd-text.oxd-text--h6");
    private final By errorMessages = By.cssSelector("p.oxd-text.oxd-text--p.oxd-alert-content-text"); // رسالة خطأ
    private final By requiredFieldMessages = By.cssSelector("span.oxd-input-field-error-message"); // رسائل required

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void waitForPageLoad() {
        wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
    }

    public void loginSteps(String username, String password) {
        waitForPageLoad();

        WebElement userInput = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        WebElement passInput = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));

        userInput.clear();
        userInput.sendKeys(username);

        passInput.clear();
        passInput.sendKeys(password);

        loginBtn.click();
    }

    public boolean isLoginSuccessful() {
        try {
            waitForPageLoad();
            wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardHeader));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public String getErrorMessage() {
        try {
            WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessages));
            return error.getText().trim();
        } catch (TimeoutException e) {
            return "";
        }
    }

    public int getRequiredMessagesCount() {
        try {
            List<WebElement> messages = driver.findElements(requiredFieldMessages);
            return messages.size();
        } catch (Exception e) {
            return 0;
        }
    }

    public String getPasswordFieldType() {
        try {
            WebElement passInput = driver.findElement(passwordField);
            return passInput.getAttribute("type");
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    public void logout() {
        try {
            driver.findElement(By.cssSelector("span.oxd-userdropdown-tab")).click();
            driver.findElement(By.cssSelector("a[href='/web/index.php/auth/logout']")).click();
        } catch (Exception e) {
        }
    }
}
