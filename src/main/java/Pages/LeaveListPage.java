package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LeaveListPage {

    WebDriver LeaveListPageDriver;
    WebDriverWait wait;
    By leaveButtonLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[3]/a");
    By leaveListTitle = By.xpath("//h5[text()='Leave List']");
    By statusDropdown = By.xpath("(//div[contains(@class,'oxd-select-text-input')])[1]");
    By leaveTypeDropdown = By.xpath("(//div[contains(@class,'oxd-select-text-input')])[2]");
    By searchBtn = By.xpath("//button[@type='submit']");
    By resetBtn = By.xpath("//button[@type='reset']");
    By firstResultStatus = By.xpath("(//div[@class='oxd-table-card']//div[@role='cell'])[3]");


    public LeaveListPage(WebDriver driver) {
        LeaveListPageDriver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

        private By option (String text){
            return By.xpath("//span[normalize-space()='" + text + "']");
        }

        public void waitForPage () {
            wait.until(ExpectedConditions.visibilityOfElementLocated(leaveListTitle));
        }

        public void selectLeaveButton () {
            LeaveListPageDriver.findElement(leaveButtonLocator).click();
        }


        public void selectStatus (String status){
            wait.until(ExpectedConditions.elementToBeClickable(statusDropdown)).click();
            wait.until(ExpectedConditions.elementToBeClickable(option(status))).click();
        }

        public void selectLeaveType (String type){
            wait.until(ExpectedConditions.elementToBeClickable(leaveTypeDropdown)).click();
            wait.until(ExpectedConditions.elementToBeClickable(option(type))).click();
        }

        public void clickSearch () {
            wait.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();
        }

        public void clickReset () {
            wait.until(ExpectedConditions.elementToBeClickable(resetBtn)).click();
        }

        public String getFirstResultStatus () {
            WebElement statusCell =
                    wait.until(ExpectedConditions.visibilityOfElementLocated(firstResultStatus));
            return statusCell.getText().trim();
        }
    }








