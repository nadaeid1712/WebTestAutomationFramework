package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PimPage {
    WebDriver pimDriver;
    By pimLocator= By.cssSelector("a[href='/web/index.php/pim/viewPimModule']");
    By addEmployeeLocator=By.xpath("//a[text()='Add Employee']");
    By firstNameLocator=By.name("firstName");
    By middleNameLocator=By.name("middleName");
    By lastNameLocator=By.name("lastName");
    By employeeIdLocator=By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input");
    By createLoginDetailsLocator=By.cssSelector("span[class=\"oxd-switch-input oxd-switch-input--active --label-right\"]");
    By saveButtonLocater=By.cssSelector("button[type=\"submit\"]");
    By cancelButtonLocator=By.cssSelector("button[class=\"oxd-button oxd-button--medium oxd-button--ghost\"]");
//    By employeeUsernameLocator=
//    By employeePasswordLocator=
//    By employeeConPasswordLocator=
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
        pimDriver.findElement(employeeIdLocator).sendKeys(String.valueOf(id));
        pimDriver.findElement(saveButtonLocater).click();
    }





}







