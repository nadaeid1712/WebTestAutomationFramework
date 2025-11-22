package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class AdminPage {

    WebDriver driver;
    WebDriverWait wait;

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Admin menu locators
    By adminMenuLocator = By.xpath("//span[text()='Admin']/parent::a");
    By userManagementTabLocator = By.xpath("//span[normalize-space()='User Management']");
    // public so i can see it in test page
    public  By usersOptionLocator = By.xpath("//a[normalize-space()='Users']");

    // Users search screen locators
    By usernameInputLocator = By.xpath("//label[text()='Username']/../following-sibling::div//input");
    By userRoleDropdownLocator = By.xpath("//label[text()='User Role']/../following-sibling::div//div[contains(@class,'oxd-select-text')]");
    By employeeNameInputLocator = By.xpath("//label[text()='Employee Name']/../following-sibling::div//input");
    By statusDropdownLocator = By.xpath("//label[text()='Status']/../following-sibling::div//div[contains(@class,'oxd-select-text')]");
    By searchButtonLocator = By.xpath("//button[normalize-space()='Search']");
    By resetButtonLocator = By.xpath("//button[normalize-space()='Reset']");

    // Action locators
    By deleteActionLocator = By.xpath("//i[contains(@class,'bi-trash')]");
    By editActionLocator = By.xpath("//i[contains(@class,'bi-pencil-fill')]");

    // Add User locators
    By addButtonLocator = By.xpath("//button[text()=' Add ']");
    By userRoleLocator = By.xpath("//div[@class='oxd-select-text-input']");
    By empNameInputLocator = By.xpath("//input[@placeholder='Type for hints...']");
    By statusLocator = By.xpath("//div[@role='option' and text()='Admin']");
    By addUserNameLocator = By.xpath("//input[@placeholder='Username']");
    By passwordLocator1 = By.xpath("(//input[@type='password'])[1]");
    By passwordConfirmLocator = By.xpath("(//input[@type='password'])[2]");
    By saveButtonLocator = By.cssSelector("button.orangehrm-left-space");
    By cancelButtonLocator = By.xpath("//button[text()=' Cancel ']");

    //Actions

    //1- Navigate to Users page
    public void navigateToUsersPage() {
        driver.findElement(adminMenuLocator).click();
        driver.findElement(userManagementTabLocator).click();
        driver.findElement(usersOptionLocator).click();
    }

    //2- Search user
    public void searchUser(String username) {
        WebElement userInput = driver.findElement(usernameInputLocator);
        userInput.clear();
        userInput.sendKeys(username);
        driver.findElement(searchButtonLocator).click();
    }

    // 3-Click Add User button
    public void clickAddUser() {
        driver.findElement(addButtonLocator).click();
    }

    // 4-Fill Add User form screen
    public void addUser(String role, String empName, String username, String password) {
        // User Role dropdown
        driver.findElement(userRoleLocator).click();
        By roleOptionLocator = By.xpath("//div[@role='option' and text()='" + role + "']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(roleOptionLocator));
        driver.findElement(roleOptionLocator).click();

        // 5-Employee Name autocomplete
        WebElement empInput = driver.findElement(empNameInputLocator);
        empInput.sendKeys(empName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'oxd-autocomplete-option')]")));
        driver.findElement(By.xpath("//div[contains(@class,'oxd-autocomplete-option') and text()='" + empName + "']")).click();

        // Username
        driver.findElement(addUserNameLocator).sendKeys(username);

        // Password
        driver.findElement(passwordLocator1).sendKeys(password);
        driver.findElement(passwordConfirmLocator).sendKeys(password);

        // Save
        driver.findElement(saveButtonLocator).click();
    }
    // Cancel for Adding User
  public void cancelAddUser(){
    driver.findElement(cancelButtonLocator).click();

  }
    // Delete first user in the table
    public void deleteFirstUser() {
        driver.findElement(deleteActionLocator).click();
        By confirmButton = By.xpath("//button[text()=' Yes, Delete ']");
        wait.until(ExpectedConditions.elementToBeClickable(confirmButton)).click();
    }

    // Edit first user
    public void editFirstUser() {
        driver.findElement(editActionLocator).click();
    }

}