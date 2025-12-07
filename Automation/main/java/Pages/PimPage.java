package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
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
    By addEmployeePhotoLocator=By.cssSelector("input[type=\"file\"]");
    By peterAndersonButton=By.cssSelector("span[class=\"oxd-userdropdown-tab\"]");
    By logoutButtonLocator=By.cssSelector("a[href=\"/web/index.php/auth/logout\"]");
    By driverLicenceLocator=By.xpath("//label[text()=\"Driver's License Number\"]/following::input[1]");
    By driverLicenceExpiryDateLocator=By.xpath("//label[text()=\"License Expiry Date\"]/following::input[1]");
    By selectNationalityLocators=By.cssSelector("i[class=\"oxd-icon bi-caret-down-fill oxd-select-text--arrow\"]");
    //By selectNationalityLocators=By.cssSelector("//label[text()=\"Nationality\"]/following::div[1]");
    By selectMaritalLocator=By.xpath("//label[text()=\"Marital Status\"]/following::div[1]");
    By dateOfBirthLocator=By.xpath("//label[text()=\"Date of Birth\"]/following::input[1]");
    By maleButtonLocator=By.xpath("//label[text()=\"Gender\"]/following::span[1]");
    By femaleButtonLocator=By.xpath("//label[text()=\"Gender\"]/following::span[2]");
    By firstSaveButtonLocator=By.xpath("//p[@class=\"oxd-text oxd-text--p orangehrm-form-hint\"]/following::button[1]");
    By secondSaveButtonLocator=By.xpath("//p[@class=\"oxd-text oxd-text--p orangehrm-form-hint\"]/following::button[2]");
    By bloodTypeSelectLocator=By.xpath("//label[text()=\"Blood Type\"]/following::div[1]");
    By testFieldLocator=By.xpath("//label[text()=\"Test_Field\"]/following::input[1]");

    String photoPath="image/employee image 1.png" ;
    File file=new File(photoPath);


    public PimPage(WebDriver driver){pimDriver=driver;}

    public void waitForElementToBeClickable(By locator){
        WebDriverWait wait = new WebDriverWait(pimDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void selectFromDropdown(By locator,int b) {
        Actions actions = new Actions(pimDriver);

            pimDriver.findElement(locator).click();

        for (int i=0; i<b;i++){
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        actions.sendKeys(Keys.ENTER);

    }
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

    public void allFieldCompletion(String firstName,String middleName,String lastName, String imagePath,String employeeAccount,String employeePassword,String confirmPw
    ,int driverLicence,String LicenceExpiryDate,int nationalityNum,int maritalNum, String dateOfBirth,int bloodNum, String testField ){
        pimDriver.findElement(pimLocator).click();
        pimDriver.findElement(addEmployeeLocator).click();
        pimDriver.findElement(firstNameLocator).sendKeys(firstName);
        pimDriver.findElement(middleNameLocator).sendKeys(middleName);
        pimDriver.findElement(lastNameLocator).sendKeys(lastName);
        pimDriver.findElement(addEmployeePhotoLocator).sendKeys(imagePath);
        pimDriver.findElement(createLoginDetailsLocator).click();
        pimDriver.findElements(employeeUsernameLocator).get(0).sendKeys(employeeAccount);
        pimDriver.findElements(employeeUsernameLocator).get(1).sendKeys(employeePassword);
        pimDriver.findElements(employeeUsernameLocator).get(2).sendKeys(confirmPw);
        pimDriver.findElement(saveButtonLocater).click();
        waitForElementToBeClickable(driverLicenceLocator);
        pimDriver.findElement(driverLicenceLocator).click();
        pimDriver.findElement(driverLicenceLocator).sendKeys(String.valueOf(driverLicence));
        pimDriver.findElement(driverLicenceExpiryDateLocator).click();
        pimDriver.findElement(driverLicenceExpiryDateLocator).sendKeys(LicenceExpiryDate);
        selectFromDropdown(selectNationalityLocators,nationalityNum);
        selectFromDropdown(selectMaritalLocator,maritalNum);
        pimDriver.findElement(dateOfBirthLocator).sendKeys(dateOfBirth);
        pimDriver.findElement(maleButtonLocator).click();
        pimDriver.findElement(firstSaveButtonLocator).click();
        selectFromDropdown(bloodTypeSelectLocator,bloodNum);
        pimDriver.findElement(testFieldLocator).sendKeys(testField);
        pimDriver.findElement(secondSaveButtonLocator).click();


    }











}







