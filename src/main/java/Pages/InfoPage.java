package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InfoPage {

    WebDriver driver;
    WebDriverWait wait;

    By myInfoMenu = By.xpath("//span[text()='My Info']");
    By firstNameInput = By.name("firstName");
    By middleNameInput = By.name("middleName");
    By lastNameInput = By.name("lastName");

    By otherIDInput = By.xpath("//label[text()='Other Id']/../following-sibling::div/input");

    // FIXED: Escaped apostrophe inside Java string
    By licenseInput = By.xpath("//label[text()=\"Driver's License Number\"]/../following-sibling::div/input");

    private By saveBtn = By.xpath("//button[contains(.,'Save')]");

    public InfoPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(8));
    }

    public void openMyInfo() {
        wait.until(ExpectedConditions.elementToBeClickable(myInfoMenu)).click();
    }

    // ---------------------- SETTERS ----------------------

    public void setFirstName(String value) {
        driver.findElement(firstNameInput).clear();
        driver.findElement(firstNameInput).sendKeys(value);
    }

    public void setMiddleName(String value) {
        driver.findElement(middleNameInput).clear();
        driver.findElement(middleNameInput).sendKeys(value);
    }

    public void setLastName(String value) {
        driver.findElement(lastNameInput).clear();
        driver.findElement(lastNameInput).sendKeys(value);
    }

    public void setOtherID(String value) {
        driver.findElement(otherIDInput).clear();
        driver.findElement(otherIDInput).sendKeys(value);
    }

    public void setLicense(String value) {
        driver.findElement(licenseInput).clear();
        driver.findElement(licenseInput).sendKeys(value);
    }

    public void clickSave() {
        wait.until(ExpectedConditions.elementToBeClickable(saveBtn)).click();
    }

    // ---------------------- GETTERS ----------------------

    public String getFirstName() {
        return driver.findElement(firstNameInput).getAttribute("value");
    }

    public String getMiddleName() {
        return driver.findElement(middleNameInput).getAttribute("value");
    }

    public String getLastName() {
        return driver.findElement(lastNameInput).getAttribute("value");
    }

    public String getOtherID() {
        return driver.findElement(otherIDInput).getAttribute("value");
    }

    public String getLicense() {
        return driver.findElement(licenseInput).getAttribute("value");
    }
}
