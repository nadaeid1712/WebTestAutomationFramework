import Pages.AssignLeavePage;
import io.qameta.allure.Allure;
import org.testng.annotations.Test;

public class AssignLeaveTest extends BaseTest {

    @Test(priority = 2)

    public void navigateToAssignLeavePage() {
Allure.step("Assign Leave Page");
new AssignLeavePage(driver).checkAssignLeavePage();
// Assertion //
verifySuccessMessage();
Allure.step("Navigate to Assign Leave Page");
    }
    @Test(priority = 3)
    public void createLeave() {
        Allure.step("Create Leave");
        new AssignLeavePage(driver).createLeave();

        // Assertion //
        verifySuccessMessage();
        Allure.step("Navigate to Create Leave Page");







    }
}





