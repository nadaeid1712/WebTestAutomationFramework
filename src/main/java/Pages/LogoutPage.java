package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogoutPage {

    WebDriver driver;
    WebDriverWait wait;

    By userDropdownLocator = By.cssSelector("p.oxd-userdropdown-name");
    By logoutButtonLocator = By.xpath("//a[text()='Logout']");

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickUserDropdown() {
        try {
            WebElement dropdown = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(userDropdownLocator)
            );
            dropdown.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click();",
                    driver.findElement(userDropdownLocator)
            );
        }
    }

    public void clickLogout() {
        try {
            WebElement logoutBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(logoutButtonLocator)
            );
            logoutBtn.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click();",
                    driver.findElement(logoutButtonLocator)
            );
        }
    }

    public void logout() {
        clickUserDropdown();
        clickLogout();

        driver.manage().deleteAllCookies();

        try {
            wait.until(ExpectedConditions.urlContains("/auth/login"));
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript(
                    "window.location.href='/auth/login';"
            );
        }
    }

    public boolean isLogoutButtonVisible() {
        try {
            clickUserDropdown();
            WebElement logoutBtn = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(logoutButtonLocator)
            );
            return logoutBtn.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLogoutSuccessful() {
        try {
            return wait.until(ExpectedConditions.urlContains("/auth/login"));
        } catch (Exception e) {
            return false;
        }
    }
}
