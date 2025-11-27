import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest extends log  {

    LoginPage loginPage;

    @BeforeClass
    public void setupPage() {
        loginPage = new LoginPage(driver);
    }

    private void safeLogout() {
        try {
            loginPage.logout();
        } catch (Exception e) {
        }
    }

    @Test(priority = 2)
    public void verifyLoginWithInvalidUsername() {
        loginPage.loginSteps("wrongUser", "admin123");
        Assert.assertEquals(loginPage.getErrorMessage(), "Invalid credentials");
    }

    @Test(priority = 3)
    public void verifyLoginWithEmptyFields() {
        loginPage.loginSteps("", "");
        Assert.assertEquals(loginPage.getRequiredMessagesCount(), 2, "Both username and password fields should be required.");
    }

    @Test(priority = 4)
    public void verifyPasswordIsMasked() {
        String type = loginPage.getPasswordFieldType();
        Assert.assertEquals(type, "password", "Password field should be masked.");
        safeLogout();
    }

    @Test(dataProvider = "getLoginData", dataProviderClass = TestData.class, priority = 5)
    public void verifyPressingEnterTriggersLogin(String username, String password) {
        loginPage.loginSteps(username, password);
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login should work when pressing Enter.");
        safeLogout();
    }

}
