import Pages.MyInfoPersonalPage;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyInfoTest extends BasicTest{

    MyInfoPersonalPage myInfo=new MyInfoPersonalPage(driver);;




    @Test(priority = 2)
    public void updatePersonalInfoTest() throws InterruptedException {
        Allure.step("My INfo.");

        // Open My Info page
        myInfo.openMyInfo();

        // Update details
        String firstName = "John";
        String middleName = "M";
        String lastName = "Doe";
        String otherId = "12345";
        String license = "DL987654";

        myInfo.setFirstName(firstName);
        myInfo.setMiddleName(middleName);
        myInfo.setLastName(lastName);
        myInfo.setOtherID(otherId);
        myInfo.setLicense(license);

        // Save changes
        myInfo.clickSave();

        Thread.sleep(2000); // wait for save to complete (or better: wait for success message)

        // Validation
        Assert.assertEquals(myInfo.getFirstName(), firstName, "First Name did not update correctly");
        // Similarly, you can add getters/asserts for lastName, middleName, etc.
    }


}


