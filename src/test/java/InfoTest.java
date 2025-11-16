import Pages.InfoPage;
import Utilities.AssertionUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Instant;

public class InfoTest extends BaseTest {
    WebDriverWait wait;

    InfoPage myInfo;

//    @BeforeClass
//    public void setUpPage() {
//        myInfo = new InfoPage(driver); // driver is ready now
//    }

    @Test
    public void updatePersonalInfoTest() throws InterruptedException {

        myInfo.openMyInfo();

        // Test Data
        String firstName = "John";
        String middleName = "M";
        String lastName = "Doe";
        String otherId = "12345";
        String license = "DL987654";

        // Update Fields
        myInfo.setFirstName(firstName);
        myInfo.setMiddleName(middleName);
        myInfo.setLastName(lastName);
        myInfo.setOtherID(otherId);
        myInfo.setLicense(license);

        myInfo.clickSave();
        Instant wait;
       //
        // Run assertions
        AssertionUtils.assertPersonalInfo(
                myInfo, firstName, middleName, lastName, otherId, license
        );
    }
}
