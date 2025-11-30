package Pages;
import org.openqa.selenium.*;
import org.openqa.selenium.devtools.v129.page.Page;
import java.util.List;

public class AssignLeavePage extends Page {

    // Driver
    WebDriver assignLeavePageDriver;

    //locators

    By leaveButtonLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[3]/a");
    By assignLeaveButton = By.xpath(" //a[text()='Assign Leave']");

    By employeeNameButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div/div/div[2]/div/div/input");
    By leaveTypeSelect=By.cssSelector("i[class=\"oxd-icon bi-caret-down-fill oxd-select-text--arrow\"]");
    By leaveTypeSelectButton = By.cssSelector("div[class=\"oxd-select-text oxd-select-text--active\"]");
    By personalTypeLocator = By.xpath("//div[text()=\"CAN - Personal\"] ");

    // By fromDateButton = By.cssSelector("//label[text()='From Date']");
    //By toDateButton = By.cssSelector(" //label[text()='From Date']");
    By commentLocator = By.cssSelector("textarea[class=\"oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical\"]");
    By saveAssignLeaveLocator = By.cssSelector("button[type=\"submit\"]");
    By dateButton=By.cssSelector("input[placeholder=\"yyyy-dd-mm\"]");

    // List<WebElement> date=assignLeavePageDriver.findElements(dateButton);

    // Constructor
    public AssignLeavePage(WebDriver driver) {assignLeavePageDriver= driver;}

    // Methods
    public void checkAssignLeavePage() {

        assignLeavePageDriver.findElement(leaveButtonLocator).click();
        assignLeavePageDriver.findElement(assignLeaveButton).click();

    }


    public void createLeave() {
        assignLeavePageDriver.findElement(leaveButtonLocator).click();
        assignLeavePageDriver.findElement(assignLeaveButton).click();
        //assignLeavePageDriver.findElement(employeeNameButton).click();
        assignLeavePageDriver.findElement(employeeNameButton).sendKeys("Ayman Wael Ali");
       // assignLeavePageDriver.findElement(leaveTypeSelect).click();

        //to date
        assignLeavePageDriver.findElements(dateButton).get(1).sendKeys("2025-11-12");
        //from date
        assignLeavePageDriver.findElements(dateButton).get(0).sendKeys("2025-11-11");

        assignLeavePageDriver.findElement(commentLocator).sendKeys("Done");
        assignLeavePageDriver.findElement(saveAssignLeaveLocator).click();

    }


    }
