package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {

    WebDriver driver;

    // Locators
    By profileDropdownLocator = By.cssSelector("p.oxd-userdropdown-name");
    By logoutButtonLocator = By.xpath("//a[text()='Logout']");

    // Constructor
    public LogoutPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void clickProfileDropdown() {
        driver.findElement(profileDropdownLocator).click();
    }

    public void clickLogout() {
        driver.findElement(logoutButtonLocator).click();
    }

    public void logout() {
        clickProfileDropdown();
        clickLogout();
    }

    // Validation
    public boolean isLogoutSuccessful() {
        return driver.getCurrentUrl().contains("/auth/login");
    }

    // Method to check if Logout button is visible
    public boolean isLogoutButtonVisible() {
        clickProfileDropdown(); //  Dropdown
        return driver.findElement(logoutButtonLocator).isDisplayed();
    }
}
