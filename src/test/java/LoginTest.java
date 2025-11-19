import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {


    LoginPage loginPage=new LoginPage(driver);

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
}

//@Test(priority = 6)
//public void verifyPressingEnterTriggersLogin() {
@Test(dataProvider ="getLoginData" ,dataProviderClass = TestData.class,priority = 5)
public void verifyPressingEnterTriggersLogin(String username,String password){
    new LoginPage(driver).loginSteps(username,password);

    Assert.assertTrue(loginPage.isLoginSuccessful(), "Login should work when pressing Enter.");
}

@Test(priority = 6)
public void verifyForgotPasswordLink() {
    loginPage.clickForgotPassword();
}

@Test(priority = 7)
public void verifyCaseSensitivityOfPassword() {
    loginPage.loginSteps("Admin", "ADMIN123");
    Assert.assertEquals(loginPage.getErrorMessage(), "Invalid credentials");
}

@Test(priority = 8)
public void verifyCaseSensitivityOfUsername() {
    loginPage.loginSteps("ADMIN", "admin123");
    Assert.assertEquals(loginPage.getErrorMessage(), "Invalid credentials");
}

@Test(priority = 9)
public void verifyErrorMessageDisappearsAfterCorrection() {
    loginPage.loginSteps("Admin", "wrong123");
    Assert.assertEquals(loginPage.getErrorMessage(), "Invalid credentials");
    loginPage.loginSteps("Admin", "admin123");
    Assert.assertTrue(loginPage.isLoginSuccessful(), "Error message should disappear after correct credentials.");
}

@Test(priority = 10)
public void verifyDashboardCannotBeAccessedDirectly() {
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
    Assert.assertTrue(driver.getCurrentUrl().contains("auth/login"), "User should be redirected to login page if not logged in.");
}

@Test(priority = 11)
public void verifyBrowserBackButtonAfterLogin() {
    loginPage.loginSteps("Admin", "admin123");
    Assert.assertTrue(loginPage.isLoginSuccessful());
    driver.navigate().back();
    Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "User should remain on Dashboard after pressing Back.");
}

}


