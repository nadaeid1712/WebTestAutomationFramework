package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LeaveListPage {
    WebDriver leaveListPageDriver;

    // MENU
    By leaveMenu = By.cssSelector("a[href=\"/web/index.php/leave/viewLeaveModule\"]");
    // Leave List tab
    By leaveListTab = By.cssSelector("li[class=\"oxd-topbar-body-nav-tab --visited\"]");
    // DATE INPUTS
    By dateLocator = By.cssSelector("input[placeholder=\"yyyy-dd-mm\"]");
    // STATUS DROPDOWN
    By statusDropdown = By.xpath("(//div[@class='oxd-select-text-input'])[1]");
    // LEAVE TYPE DROPDOWN
    By leaveTypeDropdown = By.xpath("//label[text()=\"Leave Type\"]//following::div[1]");
    // EMPLOYEE NAME
    By employeeInput = By.xpath("//label[text()=\"Leave Type\"]//following::input[1]");
    // SUB UNIT DROPDOWN
    By subUnitDropdown = By.xpath("//label[text()=\"Sub Unit\"]//following::div[1]");
    //  SEARCH BUTTON
    By searchButton = By.cssSelector("button[type=\"submit\"]");
    //   RESET BUTTON
    By resetButton = By.cssSelector("button[type=\"reset\"]");

    public LeaveListPage(WebDriver driver) {
        leaveListPageDriver = driver;
    }

    // Open Leave List page
    public void openLeaveList() {
        leaveListPageDriver.findElement(leaveMenu).click();
        leaveListPageDriver.findElement(leaveListTab).click();
    }

    // Set Date Range
    public void searchDate() {
        leaveListPageDriver.findElements(dateLocator).get(0).sendKeys("2025-05-04");
        leaveListPageDriver.findElements(dateLocator).get(1).sendKeys("2025-11-12");
    }

    //Show Leave with Status
    // Show Leave with Status and select a specific option
    // Select Status
    public void selectLeaveStatus(String statusText) {

        leaveListPageDriver.findElement(statusDropdown).click();

        WebDriverWait wait = new WebDriverWait(leaveListPageDriver, Duration.ofSeconds(10));

        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@role='listbox']//span[text()='" + statusText + "']")));

        option.click();
    }

    public String getSelectedLeaveStatus() {
        return leaveListPageDriver.findElement(statusDropdown).getText();
    }

    // Get selected status for assertion
    public String getSelectedStatus() {
        return leaveListPageDriver.findElement(statusDropdown).getText();
    }

    //Show Leave Type
    // Show Leave Type and select a specific option
    public void selectLeaveType(String leaveType) {
        // Click on the dropdown
        leaveListPageDriver.findElement(leaveTypeDropdown).click();
        // Wait for the options to appear
        WebDriverWait wait = new WebDriverWait(leaveListPageDriver, Duration.ofSeconds(10));
        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@role='listbox']//span[text()='" + leaveType + "']")));
        // Click on the desired option
        option.click();
    }

    // Get selected leave type for assertion
    public String getSelectedLeaveType() {
        return leaveListPageDriver.findElement(leaveTypeDropdown).getText();
    }

    //Show Employee Name
    public void employeeName() {
        leaveListPageDriver.findElement(employeeInput).sendKeys("manda user");
    }

    //Show Sub Unit
    // Select Sub Unit
    public void selectSubUnit(String subUnit) {
        // Click the dropdown
        leaveListPageDriver.findElement(subUnitDropdown).click();

        // Wait for the list to appear
        WebDriverWait wait = new WebDriverWait(leaveListPageDriver, Duration.ofSeconds(10));
        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@role='listbox']//span[text()='" + subUnit + "']")));

        // Click the desired option
        option.click();
    }

    // Get selected Sub Unit for assertion
    public String getSelectedSubUnit() {
        return leaveListPageDriver.findElement(subUnitDropdown).getText();
    }

    // Search for leave entries
    public void clickSearch() {
        leaveListPageDriver.findElement(searchButton).click();
    }

    //reset
    public void setResetButton() {
        leaveListPageDriver.findElement(resetButton).click();
    }

}











