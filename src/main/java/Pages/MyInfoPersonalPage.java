package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyInfoPersonalPage {

    WebDriver driver;
    WebDriverWait wait;

    By myInfoMenu = By.xpath("//span[text()='My Info']");
    By firstNameInput = By.name("firstName");
    By middleNameInput = By.name("middleName");
    By lastNameInput = By.name("lastName");
    By otherIDInput = By.xpath("//label[text()='Other Id']/../following-sibling::div/input");
    By licenseInput = By.xpath("//label[text()='Driver's License Number']/../following-sibling::div/input");

    private By saveBtn = By.xpath("//button[contains(.,'Save')]");

    public  MyInfoPersonalPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(8));
    }

    public void openMyInfo() {
        wait.until(ExpectedConditions.elementToBeClickable(myInfoMenu)).click();
    }

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

    // getter example for validation
    public String getFirstName() {
        return driver.findElement(firstNameInput).getAttribute("value");
    }
}




