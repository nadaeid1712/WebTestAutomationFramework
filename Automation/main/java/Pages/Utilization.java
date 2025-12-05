package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utilization {
    WebDriver driver;
    By successMessageLocators=By.cssSelector("div[aria-live=\"assertive\"]");


    public void waitForElementToBeClickable(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void selectFromDropdown(By locator, int b) {
        Actions actions = new Actions(driver);
            driver.findElement(locator).click();

        for (int i=0; i<b;i++){
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        actions.sendKeys(Keys.ENTER);
    }

}
