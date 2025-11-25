import Pages.InfoPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InfoTest extends BaseTest {

    InfoPage myInfo;
    @BeforeMethod
    public void setUpPage() {
        myInfo = new InfoPage(driver);
    }

    @Test(dataProvider ="personalInfo", dataProviderClass = TestData.class, priority = 1)
    public void updatePersonalInfoTest(String middleName, String lastName, String otherId,
                                       String license, String dob, String gender, String maritalStatus) {

        myInfo.openMyInfoIfVisible();

        myInfo
                .setMiddleName(middleName)
                .setLastName(lastName)
                .setOtherID(otherId)
                .setLicense(license)
                .setDateOfBirth(dob)
                .setGender(gender)
                .setMaritalStatus(maritalStatus);

        myInfo.saveInfo();

        InfoAssertions.assertPersonalInfo(myInfo, middleName, lastName,
                otherId, license, dob, gender, maritalStatus);
    }

    @Test(priority = 2)
    public void testUploadAttachment() {
        String filePath = "C:\\Users\\Ohood\\IdeaProjects\\WebTestAutomationFramework3\\failedScreenshots\\ph.png";

        myInfo.uploadAttachment(filePath, "Test Upload File");

      InfoAssertions.assertAttachmentExists(myInfo, "ph.png");
    }

    @Test(priority = 3)
    public void testDeleteAttachment() {

        myInfo.deleteAttachment("ph.png");

        InfoAssertions.assertAttachmentNotExists(myInfo, "test.png");
    }

    @Test(priority = 4)
    public void testChangeProfilePicture() {
        myInfo.openMyInfo();
        myInfo.openProfilePic();
        myInfo.uploadPicture("C:\\Users\\Ohood\\IdeaProjects\\WebTestAutomationFramework3\\failedScreenshots\\ph.png");
        myInfo.savePicture();
        System.out.println("✔ Profile picture updated successfully!");
    }
}
