package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PimEmployeePage {

    //driver
    WebDriver pimEmployeeDriver;

    List<WebElement> selectEmployee =pimEmployeeDriver.findElements(By.cssSelector("i[class=\"oxd-icon bi-check oxd-checkbox-input-icon\"]"));
    int selectCount=selectEmployee.size();

//        loginDriver.findElements(selectAllButtonLocator).get(0).click();

    //Locator
    By employeeListLocator=By.xpath("//a[text()=\"Employee List\"]");
    By searchButtonLocator=By.cssSelector("button[class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space\"]");
    By selectAllButtonLocator=By.cssSelector("i[class=\"oxd-icon bi-check oxd-checkbox-input-icon\"]");



    // Constructor
    public PimEmployeePage(WebDriver driver){pimEmployeeDriver=driver;}
    //Methods








}
