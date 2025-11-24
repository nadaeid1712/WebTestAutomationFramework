package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v129.page.Page;

public class AssignLeavePage extends Page {

    WebDriver assignLeavePageDriver;
    By leaveButtonLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[3]/a");
    By assignLeaveButton = By.xpath(" //a[text()='Assign Leave']");
    //By employeeNameButton = By.cssSelector("input[fdprocessedid=\"276dn\"]");
    By employeeNameButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div/div/div[2]/div/div/input");
    By leaveTypeSelectButton = By.cssSelector("div[class=\"oxd-select-text oxd-select-text--active\"]");
    By personalTypeLocator = By.cssSelector("div[class=\"oxd-select-text-input\"]");
    By fromDateButton = By.cssSelector("//label[text()='From Date']");
    By toDateButton = By.cssSelector(" //label[text()='From Date']");
    By commentLocator = By.cssSelector("textarea[class=\"oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical\"]");
    By saveAssignLeaveLocator = By.cssSelector("button[type=\"submit\"]");


    public AssignLeavePage(WebDriver driver) {assignLeavePageDriver= driver;}


    public void checkAssignLeavePage() {

        assignLeavePageDriver.findElement(leaveButtonLocator).click();
        assignLeavePageDriver.findElement(assignLeaveButton).click();
        //assignLeavePageDriver.findElement(employeeNameButton).click();
        //assignLeavePageDriver.findElement(employeeNameButton).sendKeys("Ayman Weal Ali");

        assignLeavePageDriver.findElement(leaveTypeSelectButton).click();
        //assignLeavePageDriver.findElement(leaveTypeSelectButton).click();
        //assignLeavePageDriver.findElement(leaveTypeSelectButton).click();
        assignLeavePageDriver.findElement(personalTypeLocator).click();
        assignLeavePageDriver.findElement(fromDateButton).sendKeys("2025-11-11");
        assignLeavePageDriver.findElement(toDateButton).sendKeys("2025-11-12");
        assignLeavePageDriver.findElement(commentLocator).sendKeys("Done");
        assignLeavePageDriver.findElement(saveAssignLeaveLocator).click();

    }


}