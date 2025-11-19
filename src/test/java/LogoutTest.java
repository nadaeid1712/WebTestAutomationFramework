
import Pages.LogoutPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    LogoutPage logoutPage;


    @Test(priority = 1)
    public void verifyLogoutButtonVisibility() {
        Assert.assertTrue(logoutPage.isLogoutButtonVisible(),
                "Logout button should be visible in the top menu.");
    }

    @Test(priority = 2)
    public void verifyLogoutFromAdminPage() {
        logoutPage.logout();
        Assert.assertTrue(logoutPage.isLogoutSuccessful(), "User should be redirected to Login page after logout.");
    }

    @Test(priority = 3)
    public void verifyBrowserBackButtonAfterLogout() {
        logoutPage.logout();
        driver.navigate().back();
        Assert.assertTrue(driver.getCurrentUrl().contains("/auth/login"),
                "User should not be able to access Dashboard/Admin pages using browser Back after logout.");
    }
}
