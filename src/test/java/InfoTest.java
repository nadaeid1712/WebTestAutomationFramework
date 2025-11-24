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
    public void updatePersonalInfoTest( String middleName , String lastName, String otherId , String license , String dob ,String gender, String maritalStatus ){

        // Open My Info menu
        myInfo.openMyInfoIfVisible();

        // Click Edit to enable fields
       // myInfo.clickEdit();



        // ---------- Update Fields ----------
        myInfo
                .setMiddleName(middleName)
                .setLastName(lastName)
                .setOtherID(otherId)
                .setLicense(license)
                .setDateOfBirth(dob)


        ;

        // Save changes
        myInfo.clickSave();

        // ---------- Assertions ----------
        //Assert.assertEquals(myInfo.getFirstName(), firstName, "First name not updated");
        Assert.assertEquals(myInfo.getMiddleName(), middleName, "Middle name not updated");
        Assert.assertEquals(myInfo.getLastName(), lastName, "Last name not updated");
        Assert.assertEquals(myInfo.getOtherID(), otherId, "Other ID not updated");
        Assert.assertEquals(myInfo.getLicense(), license, "License not updated");
        Assert.assertEquals(myInfo.getDateOfBirth(), dob, "Date of Birth not updated");
        Assert.assertEquals(myInfo.getGender(), gender, "Gender not updated");
        Assert.assertEquals(myInfo.getMaritalStatus(), maritalStatus, "Marital Status not updated");

    }
//    @Test(priority = 2)
//    public void testUploadAttachment() throws Exception {
//
//        String filePath = System.getProperty("user.dir") + "/testFiles/test-document.pdf";
//        String description = "Test Upload File";
//        String fileName = "test-document.pdf";
//
//        myInfo.uploadAttachment(filePath, description);
//
//        // Assertion: verify file is uploaded
//        Assert.assertTrue(myInfo.isAttachmentPresent(fileName),
//                "Attachment was not uploaded successfully!");
//    }
//
//    @Test(priority = 3)
//    public void testDeleteAttachment() throws Exception {
//
//        String fileName = "test-document.pdf";
//
//        myInfo.deleteAttachment(fileName);
//
//        // Assertion: verify file is deleted
//        Assert.assertFalse(myInfo.isAttachmentPresent(fileName),
//                "Attachment was not deleted successfully!");
//    }
  @Test(priority = 1)
   public void testChangeProfilePicture() {

        myInfo.openMyInfo();

      myInfo.openProfilePic();//
      myInfo.uploadPicture("C:\\Users\\Ohood\\IdeaProjects\\WebTestAutomationFramework3\\failedScreenshots\\ph.png");

        myInfo.savePicture();

        System.out.println("✔ Profile picture updated successfully!");
    }

}
