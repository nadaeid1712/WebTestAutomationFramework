import Pages.LeaveListPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LeaveListTest extends BaseTest {

        @Test(priority = 2)
        public void testLeaveListFilters() {


            new LeaveListPage(driver).selectLeaveButton();


            new LeaveListPage(driver).waitForPage();  // ← أهم خطوة
            new LeaveListPage(driver).selectLeaveButton();

           new LeaveListPage (driver).selectStatus("Scheduled");
           new LeaveListPage (driver).clickSearch();

//            String actualStatus = driver.getFirstResultStatus();
//            Assert.assertEquals(actualStatus, "Scheduled",
//                    "❌ Expected status not found!");
//
//            System.out.println("✔ Filter applied correctly!");
        }
    }
















