
import Pages.AdminPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.*;


public class AdminTest extends BaseTest {

    AdminPage adminPage;

    @Test(priority = 2, description = "Add a new user")
    public void testAddUser() {
        adminPage = new AdminPage(driver);  //connect page with driver
        adminPage.navigateToUsersPage();    // Navigate to user page
        adminPage.clickAddUser();           // Click  Add
    // Data that i can enter to add
        adminPage.addUser("Admin", "John Smith", "john.smith1", "Password123!");
    }

    @Test(priority = 3, description = "Search for the added user")
    public void testSearchUser() {
        adminPage.navigateToUsersPage();
        adminPage.searchUser("john.smith1"); // search with username : john.smith1
    }

    @Test(priority = 4, description = "Edit the first user in the table")
    public void testEditUser() {
        adminPage.navigateToUsersPage();
        adminPage.editFirstUser();
        // Editing / update data in edit screen form
    }

    @Test(priority = 5, description = "Delete the first user in the table")
    public void testDeleteUser() {
        adminPage.navigateToUsersPage();
        adminPage.deleteFirstUser(); // delete action
    }

    @Test(priority = 6, description = "Cancel Add User form")
    public void testCancelAddUser() {
        adminPage.navigateToUsersPage();
        adminPage.clickAddUser();
        adminPage.cancelAddUser();
       // Assertion to ensure that after click cancel button AdminPage reload
        Assert.assertTrue(driver.findElement(adminPage.usersOptionLocator).isDisplayed(), "Failed: Add User form was not cancelled properly!");
    }

}
