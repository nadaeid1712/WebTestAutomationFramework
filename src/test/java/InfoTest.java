import Pages.InfoPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InfoTest extends BaseTest {

    InfoPage myInfo;

    @BeforeMethod
    public void setUpPage() {
        myInfo = new InfoPage(driver);
    }

    @Test(dataProvider ="personalInfo",dataProviderClass = TestData.class, priority = 1)
    public void updatePersonalInfoTest(String firstName, String middleName , String lastName, String otherId , String license , String dob ,String gender, String maritalStatus ){

        // Open My Info menu
        myInfo.openMyInfoIfVisible();

        // Click Edit to enable fields
       // myInfo.clickEdit();

        // ---------- Test Data ----------
//        String firstName = "ohood";
//        String middleName = "a";
//        String lastName = "s";
//        String otherId = "55";
//        String license = "gg444";
//        String dob = "2023-02-10";
//        String gender = "female";
//        String maritalStatus = "Married";

        // ---------- Update Fields ----------
        myInfo.setFirstName(firstName)
                .setMiddleName(middleName)
                .setLastName(lastName)
                .setOtherID(otherId)
                .setLicense(license)
                .setDateOfBirth(dob)
              //  .setGender(gender)
                .setMaritalStatus(maritalStatus);  // <-- new line

        ;

        // Save changes
        myInfo.clickSave();

        // ---------- Assertions ----------
        Assert.assertEquals(myInfo.getFirstName(), firstName, "First name not updated");
        Assert.assertEquals(myInfo.getMiddleName(), middleName, "Middle name not updated");
        Assert.assertEquals(myInfo.getLastName(), lastName, "Last name not updated");
        Assert.assertEquals(myInfo.getOtherID(), otherId, "Other ID not updated");
        Assert.assertEquals(myInfo.getLicense(), license, "License not updated");
        Assert.assertEquals(myInfo.getDateOfBirth(), dob, "Date of Birth not updated");
        Assert.assertEquals(myInfo.getGender(), gender, "Gender not updated");
        Assert.assertEquals(myInfo.getMaritalStatus(), maritalStatus, "Marital Status not updated");

    }
    @Test(priority = 2)
    public void testUploadAttachment() throws Exception {

        String filePath = System.getProperty("user.dir") + "/testFiles/test-document.pdf";
        String description = "Test Upload File";
        String fileName = "test-document.pdf";

        myInfo.uploadAttachment(filePath, description);

        // Assertion: verify file is uploaded
        Assert.assertTrue(myInfo.isAttachmentPresent(fileName),
                "Attachment was not uploaded successfully!");
    }

    @Test(priority = 3)
    public void testDeleteAttachment() throws Exception {

        String fileName = "test-document.pdf";

        myInfo.deleteAttachment(fileName);

        // Assertion: verify file is deleted
        Assert.assertFalse(myInfo.isAttachmentPresent(fileName),
                "Attachment was not deleted successfully!");
    }




}
