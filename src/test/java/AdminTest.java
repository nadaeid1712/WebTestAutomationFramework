
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

        @BeforeClass
        public void setUp() {

            adminPage = new AdminPage(driver);
        }

        @Test(priority = 1)
        public void openAdminMenu() {
            adminPage.clickAdminMenu();
            adminPage.clickUserManagementMenu();
        }

        @Test(priority = 2)
        public void searchUserTest() {
            adminPage.enterSearchUsername("Admin");
            adminPage.clickSearch();
            Assert.assertTrue(adminPage.isUserDisplayed("Admin"), "User not found in search results!");
        }

        @Test(priority = 3)
        public void addNewUserTest() {
            adminPage.clickAdd();
            adminPage.selectUserRoleForNewUser("ESS");
            adminPage.enterEmployeeNameForNewUser("John Smith");
            adminPage.enterUsernameForNewUser("john.smith");
            adminPage.selectStatusForNewUser("Enabled");
            adminPage.enterPasswordForNewUser("Password123!");
            adminPage.enterConfirmPasswordForNewUser("Password123!");
            adminPage.clickSaveUser();
        }

        @Test(priority = 4)
        public void deleteUserTest() {
            adminPage.enterSearchUsername("john.smith");
            adminPage.clickSearch();
            adminPage.selectAllUsers();
            adminPage.clickDelete();
            adminPage.confirmDelete();
        }
    }
