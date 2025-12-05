import Pages.LeaveListPage;
import Pages.PimPage;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LeaveListTest extends BaseTest {

    @Test(priority = 2)
    public void openLeaveList() {
        Allure.step("Open Leave List Page");
        new LeaveListPage(driver).openLeaveList();
    }
    @Test(priority = 3)
    public void setDateRange() {
        Allure.step("Set Date Range");
        new LeaveListPage(driver).searchDate();
    }
    @Test(priority = 4)
    public void showLeaveStatus() {
        Allure.step("Select Status = Scheduled");
        LeaveListPage leaveListPage = new LeaveListPage(driver);

        leaveListPage.selectLeaveStatus("Scheduled");

        String selectedStatus = leaveListPage.getSelectedLeaveStatus();
        Assert.assertEquals(selectedStatus, "Scheduled", "Status selected correctly");
    }
    @Test(priority = 5)
    public void showLeaveType() {
        Allure.step("Select Leave Type as CAN - Personal");
        LeaveListPage leaveListPage = new LeaveListPage(driver);
        leaveListPage.selectLeaveType("CAN - Personal");

        // Assertion to verify the selected value
        String selectedLeaveType = leaveListPage.getSelectedLeaveType();
        Assert.assertEquals(selectedLeaveType, "CAN - Personal", "Leave Type selected correctly");
    }
    @Test(priority = 6)
    public void employeeName() {
        Allure.step("Show Employee Name");
        new LeaveListPage(driver).employeeName();
    }
    @Test(priority = 7)
    public void showSubUnit() {
        Allure.step("Select Sub Unit as Administration");
        LeaveListPage leaveListPage = new LeaveListPage(driver);
        leaveListPage.selectSubUnit("Administration");

        // Assertion
        String selectedSubUnit = leaveListPage.getSelectedSubUnit();
        Assert.assertEquals(selectedSubUnit, "Administration", "Sub Unit selected correctly");
    }
    @Test(priority = 8)
    public void clickSearch() {
        Allure.step("Click Search");
        new LeaveListPage(driver).clickSearch();
    }
    @Test(priority = 9)
    public void setReset() {
        Allure.step("Click Reset");
        new LeaveListPage(driver).setResetButton();
    }

}














