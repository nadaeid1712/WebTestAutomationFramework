import Pages.LeaveApplyPage;
import Pages.PimPage;
import io.qameta.allure.Allure;
import org.testng.annotations.Test;

import java.time.Duration;

public class LeaveApplyTest  extends BaseTest{

    @Test(priority = 2)
    public void checkLeaveButton (){
        Allure.step("Check Leave Button");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        new LeaveApplyPage(driver).verifyLeaveButton();


    }

    @Test(priority = 3)
    public void checkApplyLeaveButton(){
        Allure.step("Check Apply Leave Button");
        new LeaveApplyPage(driver).openApplyPage();

    }


}
