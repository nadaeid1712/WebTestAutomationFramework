import Pages.LoginPage;
import Pages.LogoutPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    LoginPage loginPage;
    LogoutPage logoutPage;

    @BeforeMethod
    public void setup() {
        loginPage = new LoginPage(driver);
        logoutPage = new LogoutPage(driver);

        driver.manage().deleteAllCookies();
        driver.get(url);

        loginPage.loginSteps("Admin", "admin123");
        Assert.assertTrue(loginPage.isLoginSuccessful(),
                "Login should be successful before testing logout");
    }

    @Test(priority = 1)
    public void verifyLogoutButtonVisibility() {
        Assert.assertTrue(logoutPage.isLogoutButtonVisible(),
                "Logout button should be visible in user menu.");
    }

    @Test(priority = 2)
    public void verifyLogoutFunctionality() {
        logoutPage.logout();
        Assert.assertTrue(logoutPage.isLogoutSuccessful(),
                "User should be redirected to login page after logout.");
    }
}
