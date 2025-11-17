import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class BaseTest {


        WebDriver driver = new ChromeDriver();
        String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

        @Test(dataProvider ="getLoginData" ,dataProviderClass = TestData.class,priority = 1)
        public void hrLogin(String username,String password){
            new LoginPage(driver).loginSteps(username,password);
        }



        @BeforeTest
        public void navigate() {
            driver.get(url);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        }

//        @AfterTest
//        public void close() {
//            driver.quit();
//
//        }
    }






