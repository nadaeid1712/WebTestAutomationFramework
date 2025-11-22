import Pages.LoginPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;

public class BaseTest {

    protected WebDriver driver;
    protected String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @BeforeClass
    public void setupDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(url);

        File screenshotDir = new File("failedScreenshots");
        if (!screenshotDir.exists()) screenshotDir.mkdir();
    }

    @AfterClass
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterMethod
    public void takeScreenshotOnFailure(ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            try {
                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                String fileName = "failedScreenshots" + File.separator +
                        testResult.getName() + "-" +
                        Arrays.toString(testResult.getParameters()) + ".png";
                FileUtils.copyFile(scrFile, new File(fileName));
            } catch (IOException e) {
                System.out.println("Failed to take screenshot: " + e.getMessage());
            }
        }
    }
}
