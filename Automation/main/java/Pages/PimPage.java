package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PimPage {
    WebDriver pimDriver;



    By pimLocator= By.cssSelector("a[href='/web/index.php/pim/viewPimModule']");
    By addEmployeeLocator=By.xpath("//a[text()='Add Employee']");
    By firstNameLocator=By.name("firstName");
    By middleNameLocator=By.name("middleName");
    By lastNameLocator=By.name("lastName");
    By employeeIdLocator=By.cssSelector("input[class=\"oxd-input oxd-input--active\"]");
    By createLoginDetailsLocator=By.cssSelector("span[class=\"oxd-switch-input oxd-switch-input--active --label-right\"]");
    By saveButtonLocater=By.cssSelector("button[type=\"submit\"]");
    By cancelButtonLocator=By.cssSelector("button[class=\"oxd-button oxd-button--medium oxd-button--ghost\"]");
    By employeeUsernameLocator=By.cssSelector("input[autocomplete=\"off\"]");
    By addEmployeePhotoLocator=By.cssSelector("i[class=\"oxd-icon bi-plus\"]");
    By peterAndersonButton=By.cssSelector("span[class=\"oxd-userdropdown-tab\"]");
    By logoutButtonLocator=By.cssSelector("a[href=\"/web/index.php/auth/logout\"]");
    //Employee list
    By maleButtonLocator=By.cssSelector("input[value=\"1\"]");
    By femaleButtonLocator=By.cssSelector("input[value=\"2\"]");

    public PimPage(WebDriver driver){pimDriver=driver;}

    public void addEmployeeFirstForm(){
        pimDriver.findElement(pimLocator).click();
        pimDriver.findElement(addEmployeeLocator).click();
    }
    public void addEmployeeBasicData(String firstName,String middleName,String lastName) {
        pimDriver.findElement(firstNameLocator).sendKeys(firstName);
        pimDriver.findElement(middleNameLocator).sendKeys(middleName);
        pimDriver.findElement(lastNameLocator).sendKeys(lastName);
        pimDriver.findElement(saveButtonLocater).click();
    }
    public void addEmployeeId(String firstName,String middleName,String lastName ,int id ){
        pimDriver.findElement(addEmployeeLocator).click();
        pimDriver.findElement(firstNameLocator).sendKeys(firstName);
        pimDriver.findElement(middleNameLocator).sendKeys(middleName);
        pimDriver.findElement(lastNameLocator).sendKeys(lastName);
        pimDriver.findElements(employeeIdLocator).get(1).sendKeys(String.valueOf(id));
        pimDriver.findElement(saveButtonLocater).click();
    }
    public void completeBasicEmployee(String firstName,String middleName,String lastName ,String employeeAccount,String employeePassword,String confirmPw){
        pimDriver.findElement(addEmployeeLocator).click();
       // pimDriver.findElement(addEmployeePhotoLocator).sendKeys("F:\\WebTestAutomationFramework5\\Automation\\failedScreenshots\\addLargeId-[Shady, Saad, Ali, 895742].jpg");
        pimDriver.findElement(firstNameLocator).sendKeys(firstName);
        pimDriver.findElement(middleNameLocator).sendKeys(middleName);
        pimDriver.findElement(lastNameLocator).sendKeys(lastName);
        pimDriver.findElement(createLoginDetailsLocator).click();
        pimDriver.findElements(employeeUsernameLocator).get(0).sendKeys(employeeAccount);
        pimDriver.findElements(employeeUsernameLocator).get(1).sendKeys(employeePassword);
        pimDriver.findElements(employeeUsernameLocator).get(2).sendKeys(confirmPw);
        pimDriver.findElement(saveButtonLocater).click();

    }











}







