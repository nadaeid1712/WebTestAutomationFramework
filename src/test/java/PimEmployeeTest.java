import Pages.PimEmployeePage;
import Pages.PimPage;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PimEmployeeTest extends BaseTest {


    PimEmployeePage pDriver = new PimEmployeePage(driver);

    @Test(priority = 1)

    public void search() {
        Allure.step("Search Employee");
        pDriver.searchEmployee();
    }

    @Test(priority = 2)
    public void resetSearch() {
        Allure.step("Reset the search ");
        pDriver.resetSearch();

    }
    @Test(priority = 4)
    public void multiDelete(){
        Allure.step("Delete multi employees");
        pDriver.deleteEmployees();
    }
    @Test(priority = 3)
    public void deleteCancellation(){
        Allure.step("Cancel delete employees ");
        pDriver.cancelDeleteEmpolyees();
    }


}









