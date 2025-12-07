package Pages;
import org.openqa.selenium.*;
import org.openqa.selenium.devtools.v129.page.Page;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AssignLeavePage extends Page {

    // Driver
    WebDriver assignLeavePageDriver;

    //locators

    By adminLocator=By.cssSelector("span[class=\"oxd-userdropdown-tab\"]");
    By leaveButtonLocator=By.cssSelector("a[href=\"/web/index.php/leave/viewLeaveModule\"]");
    By assignLeaveButton = By.xpath(" //a[text()='Assign Leave']");

    By employeeNameButton =By.xpath("//label[text()=\"Employee Name\"]/following::input[1]");
    By nameSearch=By.xpath("//div[@role=\"option\"]//following-sibling ::span[1]");
    // By employeeNameLocator=By.cssSelector("input[placeholder=\"Type for hints...\"]");
//    By leaveTypeSelect=By.cssSelector("i[class=\"oxd-icon bi-caret-down-fill oxd-select-text--arrow\"]");
//    By leaveTypeSelectButton = By.cssSelector("div[class=\"oxd-select-text oxd-select-text--active\"]");
    By leaveTypeSelectButton =By.xpath("//label[text()=\"Leave Type\"]/following::div[1]");
    By personalTypeLocator = By.xpath("//div[@role=\"option\"]/following::span[4]");

    By fromDateButton = By.xpath("//label[text()=\"From Date\"]/following::input[1]");
    By toDateButton = By.xpath("//label[text()=\"From Date\"]/following::input[2]");
    By commentLocator = By.cssSelector("textarea[class=\"oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical\"]");
    By saveAssignLeaveLocator = By.cssSelector("button[type=\"submit\"]");
    By dateButton=By.cssSelector("input[placeholder=\"yyyy-mm-dd\"]");

    //String nameAdmin=assignLeavePageDriver.findElement(adminLocator).getText();


    // Array//
    // List<WebElement> date=assignLeavePageDriver.findElements(dateButton);

    // Constructor
    public AssignLeavePage(WebDriver driver) {assignLeavePageDriver= driver;}

    // Methods
    public void checkAssignLeavePage() {

        assignLeavePageDriver.findElement(leaveButtonLocator).click();
        assignLeavePageDriver.findElement(assignLeaveButton).click();

    }


    public void createLeave() {
        String nameAdmin=assignLeavePageDriver.findElement(adminLocator).getText();
        assignLeavePageDriver.findElement(leaveButtonLocator).click();
        assignLeavePageDriver.findElement(assignLeaveButton).click();
        assignLeavePageDriver.findElement(employeeNameButton).click();
        assignLeavePageDriver.findElement(employeeNameButton).sendKeys(nameAdmin);
        assignLeavePageDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        assignLeavePageDriver.findElement(nameSearch).click();
        assignLeavePageDriver.findElement(leaveTypeSelectButton).click();
        assignLeavePageDriver.findElement(personalTypeLocator).click();
        //to date
        assignLeavePageDriver.findElements(dateButton).get(1).sendKeys("2025-11-12");
        //from date
        assignLeavePageDriver.findElements(dateButton).get(0).sendKeys("2025-11-11");
        assignLeavePageDriver.findElement(commentLocator).sendKeys("Done");
        assignLeavePageDriver.findElement(saveAssignLeaveLocator).click();

    }


}
