package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import org.openqa.selenium.NoSuchElementException;

public class AdminPage {
    WebDriver driver;

    // Locators
    private final By adminMenuLocator = By.cssSelector("#menu_admin_viewAdminModule");
    private final By userManagementMenuLocator = By.cssSelector("#menu_admin_UserManagement");
    private final By searchUsernameLocator = By.cssSelector("input[name='searchSystemUser[userName]']");
    private final By searchButtonLocator = By.cssSelector("input#searchBtn");
    private final By resultTableRowsLocator = By.cssSelector("table#resultTable tbody tr");
    private final By addButtonLocator = By.cssSelector("#btnAdd");
    private final By deleteButtonLocator = By.cssSelector("#btnDelete");
    private final By selectAllCheckboxLocator = By.cssSelector("#ohrmList_chkSelectAll");
    private final By confirmDeleteButtonLocator = By.cssSelector("#dialogDeleteBtn");

    private final By userRoleLocator = By.cssSelector("select#systemUser_userType");
    private final By employeeNameLocator = By.cssSelector("input#systemUser_employeeName_empName");
    private final By usernameLocator = By.cssSelector("input#systemUser_userName");
    private final By statusLocator = By.cssSelector("select#systemUser_status");
    private final By passwordLocator = By.cssSelector("input#systemUser_password");
    private final By confirmPasswordLocator = By.cssSelector("input#systemUser_confirmPassword");
    private final By saveButtonLocator = By.cssSelector("#btnSave");

    // Constructor
    public AdminPage(WebDriver driver) {
        this.driver = driver;
    }

    // Admin Menu Actions
    public void clickAdminMenu() {
        driver.findElement(adminMenuLocator).click();
    }

    public void clickUserManagementMenu() {
        driver.findElement(userManagementMenuLocator).click();
    }

    // Search Actions
    public void enterSearchUsername(String username) {
        driver.findElement(searchUsernameLocator).clear();
        driver.findElement(searchUsernameLocator).sendKeys(username);
    }

    public void clickSearch() {
        driver.findElement(searchButtonLocator).click();
    }

    public boolean isUserDisplayed(String username) {
        List<WebElement> rows = driver.findElements(resultTableRowsLocator);
        for (WebElement row : rows) {
            if (row.getText().contains(username)) {
                return true;
            }
        }
        return false;
    }

    // Add/Delete Actions
    public void clickAdd() {
        driver.findElement(addButtonLocator).click();
    }

    public void selectUserRoleForNewUser(String role) {
        driver.findElement(userRoleLocator).sendKeys(role);
    }

    public void enterEmployeeNameForNewUser(String empName) {
        driver.findElement(employeeNameLocator).sendKeys(empName);
    }

    public void enterUsernameForNewUser(String username) {
        driver.findElement(usernameLocator).sendKeys(username);
    }

    public void selectStatusForNewUser(String status) {
        driver.findElement(statusLocator).sendKeys(status);
    }

    public void enterPasswordForNewUser(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
    }

    public void enterConfirmPasswordForNewUser(String password) {
        driver.findElement(confirmPasswordLocator).sendKeys(password);
    }

    public void clickSaveUser() {
        driver.findElement(saveButtonLocator).click();
    }

    public void selectAllUsers() {
        driver.findElement(selectAllCheckboxLocator).click();
    }

    public void clickDelete() {
        driver.findElement(deleteButtonLocator).click();
    }

    public void confirmDelete() {
        driver.findElement(confirmDeleteButtonLocator).click();
    }
}
