package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver loginDriver;


    //Locators
    By userNameLocator = By.name("username");
    By passWordLocator = By.name("password");
    By loginButtonLocator = By.cssSelector("button[type=\"submit\"]");

    // Constructor
    public LoginPage(WebDriver driver) {
        loginDriver = driver;
    }

    // Method (Action)
    public void typeUserName(String username) {
        loginDriver.findElement(userNameLocator).sendKeys(username);
    }

    public void typePassWord(String password) {
        loginDriver.findElement(passWordLocator).sendKeys(password);
    }

    public void loginSteps(String username, String password) {
        loginDriver.findElement(userNameLocator).sendKeys(username);
        loginDriver.findElement(passWordLocator).sendKeys(password);
        loginDriver.findElement(loginButtonLocator).click();

    }

}
