import Pages.PimPage;
import org.testng.annotations.Test;

public class PinAddNewTest extends BasicTest {
    @Test(priority = 2)
    public  void addEmployeeButtonAppears(){
        new PimPage(driver).addEmployeeFirstForm();
    }

    @Test(dataProvider ="getEmployeeBd",dataProviderClass = TestData.class, priority = 3)
    public void addEmployeeBasic(String firstName,String middleName,String lastName){
        new PimPage(driver).addEmployeeBasicData(firstName,middleName,lastName);
    }
    @Test(dataProvider ="getEmployeeBdId",dataProviderClass = TestData.class, priority = 4)
    public void addLargeId(String firstName,String middleName,String lastName ,int id ){
        new PimPage(driver).addEmployeeId(firstName,middleName,lastName,id);
    }



}
