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


        WebDriver driver = new ChromeDriver();
        String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

        @Test(dataProvider ="getLoginData" ,dataProviderClass = TestData.class,priority = 1)
        public void hrLogin(String username,String password){
        new LoginPage(driver).loginSteps(username,password);
    }



        @BeforeClass
        public void navigate() {
            driver.get(url);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        }

        @AfterClass
        public void quit() {
            driver.quit();

        }

      @AfterMethod
       public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("failedScreenshots\\" + testResult.getName() + "-"
                    + Arrays.toString(testResult.getParameters()) +  ".png"));
        }
    }




    }








