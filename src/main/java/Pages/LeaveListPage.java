package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LeaveListPage {
    WebDriver leaveListPageDriver;

    // --- MENU ---
    By leaveMenu = By.xpath("//span[text()='Leave']/parent::a");
    // Leave List tab
    By leaveListTab = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[6]/a");
    // --- DATE INPUTS ---
    By fromDate= By.xpath("//input[@placeholder='From Date']");
    By toDate= By.xpath("//input[@placeholder='To Date']");
    // --- STATUS DROPDOWN ---
    By statusDropdown = By.xpath("(//div[@class='oxd-select-text-input'])[1]");
    // --- LEAVE TYPE DROPDOWN ---
    By leaveTypeDropdown = By.xpath("(//div[@class='oxd-select-text-input'])[2]");
    // --- EMPLOYEE NAME ---
    By employeeInput = By.xpath("//input[@placeholder='Type for hints...']");
    // --- SUB UNIT DROPDOWN ---
    By subUnitDropdown = By.xpath("(//div[@class='oxd-select-text-input'])[3]");
    // --- SEARCH BUTTON ---
    By searchButton = By.xpath("//button[.=' Search ']");
    // --- RESET BUTTON ---
    By resetButton = By.xpath("//button[.=' Reset ']");
    public LeaveListPage(WebDriver driver){
        leaveListPageDriver=driver;
    }
    // Open Leave List page
    public void openLeaveList() {
        leaveListPageDriver.findElement(leaveMenu).click();
        leaveListPageDriver.findElement(leaveListTab).click();
    }

    // Set Date Range
    public void setDateRange(String from, String to) {
        leaveListPageDriver.findElement(fromDate).clear();
        leaveListPageDriver.findElement(fromDate).sendKeys(from);

        leaveListPageDriver.findElement(toDate).clear();
        leaveListPageDriver.findElement(toDate).sendKeys(to);
    }

    // Select from dropdown by visible text (generic)
    public void selectFromDropdown(By dropdown, String option) {
        leaveListPageDriver.findElement(dropdown).click();
        By optionLocator = By.xpath("//div[@role='option']//span[text()='" + option + "']");
        leaveListPageDriver.findElement(optionLocator).click();
    }

    // Search for leave entries
    public void clickSearch() {
        leaveListPageDriver.findElement(searchButton).click();
    }
    //reset
    public void setResetButton() {
        leaveListPageDriver.findElement(resetButton).click();
    }}












