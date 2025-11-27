import Pages.LeaveListPage;
import Pages.PimPage;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LeaveListTest extends BaseTest {

    @Test(priority = 2)

    public  void openLeaveList(){
        Allure.step(" Button is Active");
        new LeaveListPage(driver).openLeaveList();



    }
    //new LeaveListPage(driver).openLeaveList();

    //new LeaveListPage(driver).setDateRange("2025-01-01", "2025-12-31");

   //new LeaveListPage(driver).selectFromDropdown(leavePage.statusDropdown, "Pending Approval");
    //new LeaveListPage(driver).selectFromDropdown(leavePage.leaveTypeDropdown, "FMLA US");
    //new LeaveListPage(driver).selectFromDropdown(leavePage.subUnitDropdown, "Engineering");


}
/*@Test(priority = 2)
    public  void addEmployeeButtonAppears(){
        Allure.step("Add Employee Button Active");
        new PimPage(driver).addEmployeeFirstForm();



    }*/
            /*LeaveListPage  leave =new LeaveListPage(driver);
            leave.selectLeaveButton();
            leave.waitForPage();
            leave.selectLeaveButton();
            //leave.selectStatus("Scheduled");
            leave.clickSearch();

//            String actualStatus = driver.getFirstResultStatus();
//            Assert.assertEquals(actualStatus, "Scheduled",
//                    "❌ Expected status not found!");
//
//            System.out.println("✔ Filter applied correctly!");
            public  void addEmployeeButtonAppears(){
                Allure.step("Add Employee Button Active");
                new PimPage(driver).addEmployeeFirstForm();*/

















