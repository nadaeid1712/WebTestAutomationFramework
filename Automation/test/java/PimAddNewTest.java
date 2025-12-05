import Pages.PimPage;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import java.io.IOException;


public class PimAddNewTest extends BaseTest {


    @Test(priority = 2)
    public  void addEmployeeButtonAppears(){
        Allure.step("Add Employee Button Active");
        new PimPage(driver).addEmployeeFirstForm();

    }

    @Test(dataProvider ="getEmployeeBd",dataProviderClass = TestData.class, priority = 3)
    public void addEmployeeBasic(String firstName,String middleName,String lastName){
        Allure.step("Add Employee inial data ");
        new PimPage(driver).addEmployeeBasicData(firstName,middleName,lastName);
        verifySuccessMessage();
    }
    @Test(dataProvider ="getEmployeeBdId",dataProviderClass = TestData.class, priority = 4)
    public void addLargeId(String firstName,String middleName,String lastName ,int id ) throws IOException {
        Allure.step("Add Employee large Id  ");
        new PimPage(driver).addEmployeeId(firstName,middleName,lastName,id);
        Assert.fail("Successfull,Sucessfully Saved");
    }
    @Test(dataProvider = "getEmployeeBdAccount",dataProviderClass = TestData.class,priority = 5)
    public void employeeAccount(String firstName,String middleName,String lastName,String imagePath ,String employeeAccount,String employeePassword,String confirmPw){
        Allure.step("create Employee account  ");
        new PimPage(driver).completeBasicEmployee(firstName,middleName,lastName,imagePath,employeeAccount,employeePassword,confirmPw);
        verifySuccessMessage();
    }

    @Test(dataProvider = "getFullFields",dataProviderClass = TestData.class,priority = 6)
    public void empolyeefullList(String firstName,String middleName,String lastName, String imagePath,String employeeAccount,String employeePassword,String confirmPw
            ,int driverLicence,String LicenceExpiryDate,int nationalityNum,int maritalNum, String dateOfBirth,int bloodNum,String testField ){
        Allure.step("Fill full data");
        new PimPage(driver).allFieldCompletion(firstName,middleName,lastName, imagePath,employeeAccount,employeePassword,confirmPw
                ,driverLicence,LicenceExpiryDate,nationalityNum ,maritalNum,dateOfBirth,bloodNum, testField );
        verifySuccessMessage();
    }




}
