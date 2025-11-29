import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        loginPage = new LoginPage(driver);
        driver.manage().deleteAllCookies();
        driver.get(url);
    }

    private void safeLogout() {
        try {
            loginPage.logout();
        } catch (Exception e) {
        }
    }

    @AfterMethod
    public void afterTest() {
        safeLogout();
    }

    @Test(priority = 2)
    public void verifyLoginWithEmptyFields() {
        loginPage.loginSteps("", "");
        Assert.assertEquals(loginPage.getRequiredMessagesCount(), 2,
                "Both username and password fields should be required.");
    }

    @Test(priority = 3)
    public void verifyLoginWithInvalidUsername() {
        loginPage.loginSteps("wrongUser", "admin123");
        Assert.assertEquals(loginPage.getErrorMessage(), "Invalid credentials");
    }
}
