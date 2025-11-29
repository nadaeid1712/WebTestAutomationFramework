package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

    public class LeaveApplyPage {

    WebDriver applyPageDriver;

   // By leaveButtonLocator = By.cssSelector("href=\"/web/index.php/leave/viewLeaveModule\"");
    By leaveButtonLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[3]/a");
    By applyButtonLocator = By.xpath("//a[text()='Apply']");
    By leaveTypeSelectButton = By.cssSelector("div[class=\"oxd-select-text oxd-select-text--active\"]");
    By personalTypeLocator = By.xpath("//div[text()='CAN - Personal']");
    By MatternityTypeLocator = By.xpath("//div[text()='CAN - Matternity']");
    By commentLocator = By.cssSelector("textarea[class=\"oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical\"]");
    By saveApplyLocator = By.cssSelector("button[type=\"submit\"]");


    public LeaveApplyPage(WebDriver driver) {
        applyPageDriver = driver;
    }

    public void verifyLeaveButton() {
        applyPageDriver.findElement(leaveButtonLocator).click();

    }
    public void openApplyPage () {
        applyPageDriver.findElement(leaveButtonLocator).click();
        applyPageDriver.findElement(applyButtonLocator).click();
    }
    public void fillMandatoryField(){
        applyPageDriver.findElement(leaveButtonLocator).click();
        applyPageDriver.findElement(applyButtonLocator).click();
        applyPageDriver.findElement(leaveTypeSelectButton).click();
        applyPageDriver.findElement(personalTypeLocator).click();
        applyPageDriver.findElement(commentLocator).sendKeys("Nada");
        applyPageDriver.findElement(saveApplyLocator).click();
    }

}