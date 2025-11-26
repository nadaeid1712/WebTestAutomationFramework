import Pages.InfoPage;
import org.testng.Assert;

public class InfoAssertions {

    /**
     * Asserts all personal information fields on the Info page.
     */
    public static void assertPersonalInfo(
            InfoPage page,
            String FirstName,
            String middleName,
            String lastName,
            String otherId,
            String license,
            String dob
           ) {
        Assert.assertEquals(page.getFirstName(), FirstName, "First Name not updated");

        Assert.assertEquals(page.getMiddleName(), middleName, "Middle name not updated");
        Assert.assertEquals(page.getLastName(), lastName, "Last name not updated");
        Assert.assertEquals(page.getOtherID(), otherId, "Other ID not updated");
        Assert.assertEquals(page.getLicense(), license, "License not updated");
        Assert.assertEquals(page.getDateOfBirth(), dob, "Date of Birth not updated");
    }

    /**
     * Asserts that an attachment exists.
     */
    public static void assertAttachmentExists(InfoPage page, String fileName) {
        Assert.assertTrue(page.isAttachmentPresent(fileName),
                "Attachment '" + fileName + "' was expected to exist, but it does NOT!");
    }

    /**
     * Asserts that an attachment does NOT exist.
     */
    public static void assertAttachmentNotExists(InfoPage page, String fileName) {
        Assert.assertFalse(page.isAttachmentPresent(fileName),
                "Attachment '" + fileName + "' was expected to be deleted, but it still exists!");
    }
}
