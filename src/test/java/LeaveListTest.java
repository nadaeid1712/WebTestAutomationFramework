import Pages.LeaveListPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LeaveListTest extends BaseTest {

        @Test(priority = 2)
        public void testLeaveListFilters() {


            LeaveListPage  leave =new LeaveListPage(driver);
            leave.selectLeaveButton();
            leave.waitForPage();  // ← أهم خطوة
            leave.selectLeaveButton();
            //leave.selectStatus("Scheduled");
            leave.clickSearch();

//            String actualStatus = driver.getFirstResultStatus();
//            Assert.assertEquals(actualStatus, "Scheduled",
//                    "❌ Expected status not found!");
//
//            System.out.println("✔ Filter applied correctly!");
        }
    }
















