package Utilities;

import Pages.InfoPage;
import org.testng.Assert;

public class AssertionUtils {




        public static void assertPersonalInfo(InfoPage page,
                                              String expectedFirst,
                                              String expectedMiddle,
                                              String expectedLast,
                                              String expectedOtherID,
                                              String expectedLicense) {

            Assert.assertEquals(page.getFirstName(), expectedFirst, "First name mismatch!");
            Assert.assertEquals(page.getMiddleName(), expectedMiddle, "Middle name mismatch!");
            Assert.assertEquals(page.getLastName(), expectedLast, "Last name mismatch!");
//            Assert.assertEquals(page.getOtherID(), expectedOtherID, "Other ID mismatch!");
//            Assert.assertEquals(page.getLicense(), expectedLicense, "License mismatch!");
        }
    }


