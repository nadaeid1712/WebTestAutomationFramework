package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PimEmployeePage {

    //driver
    WebDriver pimEmployeeDriver;
//    List<WebElement> employeeSearch=pimEmployeeDriver.findElements(By.cssSelector("input[placeholder=\"Type for hints...\"]"));
//    int search =employeeSearch.size();
//
//    List<WebElement> selectEmployee =pimEmployeeDriver.findElements(By.cssSelector("i[class=\"oxd-icon bi-check oxd-checkbox-input-icon\"]"));
//    int selectCount=selectEmployee.size();



    //Locator
    By pimLocator= By.cssSelector("a[href='/web/index.php/pim/viewPimModule']");
    By searchEmployeeButtonLocator=By.xpath("//a[text()=\"Employee List\"]");
    By searchButtonLocator=By.cssSelector("button[class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space\"]");
    By resetButtonLocator=By.cssSelector("button[type=\"reset\"]");
    By selectAllButtonLocator=By.cssSelector("i[class=\"oxd-icon bi-check oxd-checkbox-input-icon\"]");
    By deleteSelectedButtonLocator=By.cssSelector("button[class=\"oxd-button oxd-button--medium oxd-button--label-danger orangehrm-horizontal-margin\"]");
    By yesDeleteButton=By.cssSelector("button[class=\"oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin\"]");
    By noCancelButton=By.cssSelector("button[class=\"oxd-button oxd-button--medium oxd-button--ghost orangehrm-button-margin\"]");




    // Constructor
    public PimEmployeePage(WebDriver driver){pimEmployeeDriver=driver;}
    //Methods
    public void searchEmployee(){
        pimEmployeeDriver.findElement(pimLocator).click();
        pimEmployeeDriver.findElements(searchEmployeeButtonLocator).get(0).sendKeys("A");
        pimEmployeeDriver.findElement(searchButtonLocator).click();

    }
    public void resetSearch(){

        searchEmployee();
        pimEmployeeDriver.findElement(resetButtonLocator).click();

    }
    public void deleteEmployees(){
        pimEmployeeDriver.findElements(selectAllButtonLocator).get(1).click();
        pimEmployeeDriver.findElements(selectAllButtonLocator).get(2).click();
        pimEmployeeDriver.findElements(selectAllButtonLocator).get(3).click();
        pimEmployeeDriver.findElement(deleteSelectedButtonLocator).click();
        pimEmployeeDriver.findElement(yesDeleteButton).click();
    }
    public void cancelDeleteEmpolyees(){
        pimEmployeeDriver.findElements(selectAllButtonLocator).get(1).click();
        pimEmployeeDriver.findElements(selectAllButtonLocator).get(2).click();
        pimEmployeeDriver.findElements(selectAllButtonLocator).get(3).click();
        pimEmployeeDriver.findElement(deleteSelectedButtonLocator).click();
        pimEmployeeDriver.findElement(noCancelButton).click();

    }








}
