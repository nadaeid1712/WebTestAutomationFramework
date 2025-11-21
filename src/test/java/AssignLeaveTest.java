import Pages.AssignLeavePage;
import io.qameta.allure.Allure;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

public class AssignLeaveTest extends BaseTest {

    @Test(priority = 2)

    public void createAssignLeave() {
Allure.step("Create Leave Page");
new AssignLeavePage(driver).checkAssignLeavePage();



    }
}





