package Pages;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;


public class InfoPage {

    WebDriver driver;
    WebDriverWait wait;
   // button[type="submit"]
    // ---------- Locators ----------
    // My info menu (only used if visible)
    By myInfoMenu = By.xpath("//a[contains(@href,'viewMyDetails')]");

    // Inputs
    By firstNameInput = By.name("firstName");
    By middleNameInput = By.name("middleName");
    By lastNameInput = By.name("lastName");
    By otherIDInput = By.xpath("//label[text()='Other Id']/../following-sibling::div/input");
    By licenseInput = By.xpath("//label[contains(text(),'Driver')]/../following-sibling::div/input");


     By uploadInput = By.cssSelector("i[class=\"oxd-icon bi-plus\"]");
     By saveBtn = By.xpath("//button[contains(.,'Save')]");By myInfoTab = By.xpath("//span[text()='My Info']");
     By profilePic = By.cssSelector("img.employee-image");

    // Date of Birth
    By dobInput = By.xpath("//label[text()='Date of Birth']/../following-sibling::div//input");
    // Gender
    By genderMaleRadio = By.xpath("//input[@type='radio' and @value='1']");
    By genderFemaleRadio = By.cssSelector("input[value=\"2\"]");
    By maritalStatusDropdown = By.xpath("//label[text()='Marital Status']/../following-sibling::div//select");

    // Save button
   // By saveBtn = By.xpath("//button[contains(.,'Save')]");
    By personalDetailsTab = By.xpath("//a[contains(@href,'personalDetails')]");
    By attachmentsTab = By.xpath("//h6[text()='Attachments']");

    // ---------- Attachment Section Locators ----------
    private By addButton = By.cssSelector("button[class=\"oxd-button oxd-button--medium oxd-button--text\"]");
    private By fileInput = By.xpath("//input[@type='file']");
    private By descriptionTextarea = By.xpath("//textarea");
    private By saveButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[3]/div/form/div[3]/button[2]");
    private By confirmDeleteButton = By.xpath("//button[contains(., 'Yes, Delete')]");

    // Get attachment row by filename
    private By getRow(String fileName) {
        return By.xpath("//div[@class='oxd-table-card'][.//div[contains(text(), '" + fileName + "')]]");
    }


    public InfoPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(8));
    }

    // ---------- Optional Navigation ----------
    public void openMyInfoIfVisible() {
        List<WebElement> items = driver.findElements(myInfoMenu);
        if (!items.isEmpty()) {
            wait.until(ExpectedConditions.elementToBeClickable(myInfoMenu)).click();
        }
    }

    // ---------- Utility ----------
    private void clearAndType(By locator, String value) {
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        field.sendKeys(Keys.CONTROL + "a");
        field.sendKeys(Keys.DELETE);
        field.sendKeys(value);
    }

    // ---------- Setters ----------
    public InfoPage setFirstName(String value) { clearAndType(firstNameInput, value); return this; }
    public InfoPage setMiddleName(String value) { clearAndType(middleNameInput, value); return this; }
    public InfoPage setLastName(String value) { clearAndType(lastNameInput, value); return this; }
    public InfoPage setOtherID(String value) { clearAndType(otherIDInput, value); return this; }
    public InfoPage setLicense(String value) { clearAndType(licenseInput, value); return this; }

    // ---------- Setter ----------
    public InfoPage setMaritalStatus(String status) {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(maritalStatusDropdown));
        Select select = new Select(dropdown);
        select.selectByVisibleText(status);
        return this;
    }

    // ---------- Getter ----------
    public String getMaritalStatus() {
        WebElement dropdown = driver.findElement(maritalStatusDropdown);
        Select select = new Select(dropdown);
        return select.getFirstSelectedOption().getText();
    }

    public InfoPage setDateOfBirth(String value) {
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(dobInput));
        e.sendKeys(Keys.CONTROL + "a");
        e.sendKeys(Keys.DELETE);
        e.sendKeys(value);
        e.sendKeys(Keys.ENTER); // important for OrangeHRM
        return this;
    }

    public InfoPage setGender(String gender) {
        if (gender.equalsIgnoreCase("male")) {
            wait.until(ExpectedConditions.elementToBeClickable(genderMaleRadio)).click();
        } else if (gender.equalsIgnoreCase("female")) {
            wait.until(ExpectedConditions.elementToBeClickable(genderFemaleRadio)).click();
        }
        return this;
    }


public void clickSave() {
    try {
        // Wait for the Save button to be visible
        WebElement save = wait.until(ExpectedConditions.visibilityOfElementLocated(saveBtn));

        // Scroll it into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", save);

        // Try normal Selenium click first
        try {
            wait.until(ExpectedConditions.elementToBeClickable(save)).click();
        } catch (ElementClickInterceptedException e) {
            // If intercepted, use JS click as fallback
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", save);
        }

        // Optional: wait for success toast notification
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector(".oxd-toast-container")
            ));
        } catch (Exception ignored) {}

    } catch (TimeoutException e) {
        throw new RuntimeException("Save button was not found or not clickable.", e);
    }
}



    // ---------- Getters ----------
    public String getFirstName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameInput))
                .getAttribute("value");
    }

    public String getMiddleName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(middleNameInput))
                .getAttribute("value");
    }

    public String getLastName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameInput))
                .getAttribute("value");
    }

    public String getOtherID() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(otherIDInput))
                .getAttribute("value");
    }

    public String getLicense() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(licenseInput))
                .getAttribute("value");
    }

    public String getDateOfBirth() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(dobInput))
                .getAttribute("value");
    }

    public String getGender() {
        if (wait.until(ExpectedConditions.visibilityOfElementLocated(genderMaleRadio)).isSelected())
            return "Male";
        if (wait.until(ExpectedConditions.visibilityOfElementLocated(genderFemaleRadio)).isSelected())
            return "Female";
        return "";
    }
    // ---------- Wait Helpers ----------
    private void waitForOverlayToDisappear() {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(
                    By.cssSelector("div.oxd-overlay")
            ));
        } catch (Exception ignored) {
        }
    }

    private WebElement clickable(By locator) {
        waitForOverlayToDisappear();
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // ---------- Navigation ----------
    public void openMyInfo() {
        clickable(myInfoMenu).click();
    }

    public void openPersonalDetails() {
        clickable(personalDetailsTab).click();
    }

    public void openAttachments() {
        clickable(attachmentsTab).click();
        waitForOverlayToDisappear();
    }
    public void uploadAttachment(String filePath, String description) {
        openAttachments();

        WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(addButton));
        scrollAndClick(addBtn);

        WebElement fileInputElement = wait.until(ExpectedConditions.presenceOfElementLocated(fileInput));
        fileInputElement.sendKeys(filePath);

        WebElement descTextarea = wait.until(ExpectedConditions.visibilityOfElementLocated(descriptionTextarea));
        descTextarea.sendKeys(description);

        WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        scrollAndClick(saveBtn);

        // الانتظار على إشعار النجاح بدلاً من الزر
        By toastMessage = By.cssSelector(".oxd-toast");
        wait.until(ExpectedConditions.visibilityOfElementLocated(toastMessage));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(toastMessage));
    }


    /**
     * Utility لتمرير العنصر إلى منتصف الشاشة ثم الضغط عليه
     * يساعد على حل مشاكل ElementClickInterceptedException
     */
    private void scrollAndClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            // إذا تم اعتراض النقر، استخدم JS click
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }













    public void deleteAttachment(WebDriver driver, String fileName) {
        openAttachments();
        WebElement row = wait.until(ExpectedConditions.visibilityOfElementLocated(getRow(fileName)));
        row.findElement(By.cssSelector("i[class=\"oxd-icon bi-trash\"]")).click();
        clickable(confirmDeleteButton).click();
        wait.until(ExpectedConditions.invisibilityOf(row));
    }

    public boolean isAttachmentPresent(String fileName) {
        openAttachments();
        List<WebElement> rows = driver.findElements(getRow(fileName));
        return !rows.isEmpty();
    }
    public void openProfilePic() {
        driver.findElement(profilePic).click();
    }


public void uploadPicture(String imagePath) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    WebElement fileInput = wait.until(
            ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='file']"))
    );

    fileInput.sendKeys(imagePath);  // send directly to hidden input
}
    public void savePicture() {
        driver.findElement(saveBtn).click();
    }
}



