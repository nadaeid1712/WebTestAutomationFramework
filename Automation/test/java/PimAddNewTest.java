import Pages.PimPage;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.io.IOException;


public class PimAddNewTest extends BaseTest {


    @Test(priority = 2)
    public  void addEmployeeButtonAppears(){
        Allure.step("Add Employee Button Active");
        new PimPage(driver).addEmployeeFirstForm();



    }

    @Test(dataProvider ="getEmployeeBd",dataProviderClass = TestData.class, priority = 3)
    public void addEmployeeBasic(String firstName,String middleName,String lastName){
        new PimPage(driver).addEmployeeBasicData(firstName,middleName,lastName);
    }
    @Test(dataProvider ="getEmployeeBdId",dataProviderClass = TestData.class, priority = 4)
    public void addLargeId(String firstName,String middleName,String lastName ,int id ) throws IOException {
        new PimPage(driver).addEmployeeId(firstName,middleName,lastName,id);
        //Assert.fail("Successfull,Sucessfully Saved");
    }
    @Test(dataProvider = "getEmployeeBdAccount",dataProviderClass = TestData.class,priority = 4)
    public void employeeAccount(String firstName,String middleName,String lastName ,String employeeAccount,String employeePassword,String confirmPw){
        new PimPage(driver).completeBasicEmployee(firstName,middleName,lastName,employeeAccount,employeePassword,confirmPw);
    }



}
