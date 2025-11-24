package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class InfoPage {
    private WebDriver driver;
    private WebDriverWait wait;
    public InfoPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));   // faster
    }
    private By myInfoMenu = By.xpath("//a[contains(@href,'viewMyDetails')]");
    private By firstNameInput = By.name("firstName");
    private By middleNameInput = By.name("middleName");
    private By lastNameInput = By.name("lastName");
    private By otherIDInput = By.xpath("//label[text()='Other Id']/../following-sibling::div/input");
    private By licenseInput = By.xpath("//label[contains(text(),'Driver')]/../following-sibling::div/input");
    private By dobInput = By.xpath("//label[text()='Date of Birth']/../following-sibling::div//input");
    private By genderMale = By.cssSelector("input[value='1']");
    private By genderFemale = By.cssSelector("input[value='2']");

    private By maritalDropdown = By.xpath("//label[text()='Marital Status']/../following-sibling::div//select");

    private By saveBtn = By.xpath("//button[contains(.,'Save')]");
    // Attachments
    private By attachmentsTab = By.xpath("//h6[text()='Attachments']");
    private By addButton = By.cssSelector("button.oxd-button--text");
    private By fileInput = By.cssSelector("input[type='file']");
    private By descriptionTextarea = By.tagName("textarea");
    private By toast = By.cssSelector(".oxd-toast");

    private By confirmDeleteButton = By.cssSelector("button[class=\"oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin\"]");

    private By getRow(String fileName) {
        return By.xpath("//div[@class='oxd-table-card'][.//div[contains(text(),'" + fileName + "')]]");
    }

    private By overlay = By.cssSelector("div.oxd-overlay");

    // Profile pic
    private By profilePic = By.cssSelector("img.employee-image");
    private By savePictureButton = By.xpath("//button[contains(., 'Save')]");


    private WebElement visible(By loc) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loc));
    }

    private WebElement clickable(By loc) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(overlay));
        return wait.until(ExpectedConditions.elementToBeClickable(loc));
    }

    private void clearAndType(By locator, String value) {
        WebElement field = visible(locator);
        field.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        field.sendKeys(Keys.DELETE);
        field.sendKeys(value);
    }

    private void clickJS(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    private void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", element);
    }

    // ------------------- Navigation -------------------
    public void openMyInfoIfVisible() {
        if (!driver.findElements(myInfoMenu).isEmpty()) {
            clickable(myInfoMenu).click();
        }
    }

    public void openMyInfo() {
        clickable(myInfoMenu).click();
    }

    // ------------------- Setters -------------------
    public InfoPage setFirstName(String v) { clearAndType(firstNameInput, v); return this; }
    public InfoPage setMiddleName(String v) { clearAndType(middleNameInput, v); return this; }
    public InfoPage setLastName(String v) { clearAndType(lastNameInput, v); return this; }
    public InfoPage setOtherID(String v) { clearAndType(otherIDInput, v); return this; }
    public InfoPage setLicense(String v) { clearAndType(licenseInput, v); return this; }

    public InfoPage setDateOfBirth(String value) {
        WebElement e = clickable(dobInput);
        e.sendKeys(Keys.CONTROL + "a");
        e.sendKeys(Keys.DELETE);
        e.sendKeys(value);
        e.sendKeys(Keys.ENTER);
        return this;
    }

    public InfoPage setGender(String gender) {
        if (gender.equalsIgnoreCase("male")) clickable(genderMale).click();
        else clickable(genderFemale).click();
        return this;
    }

    public InfoPage setMaritalStatus(String status) {
        new Select(clickable(maritalDropdown)).selectByVisibleText(status);
        return this;
    }

    public String getFirstName() { return visible(firstNameInput).getAttribute("value"); }
    public String getMiddleName() { return visible(middleNameInput).getAttribute("value"); }
    public String getLastName() { return visible(lastNameInput).getAttribute("value"); }
    public String getOtherID() { return visible(otherIDInput).getAttribute("value"); }
    public String getLicense() { return visible(licenseInput).getAttribute("value"); }
    public String getDateOfBirth() { return visible(dobInput).getAttribute("value"); }

    public String getGender() {
        if (driver.findElement(genderMale).isSelected()) return "Male";
        if (driver.findElement(genderFemale).isSelected()) return "Female";
        return "";
    }

    public String getMaritalStatus() {
        return new Select(visible(maritalDropdown)).getFirstSelectedOption().getText();
    }

    // ------------------- Save -------------------
    public void saveInfo() {
        WebElement save = visible(saveBtn);
        scrollIntoView(save);
        clickJS(save);

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(toast));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(toast));
        } catch (Exception ignored) {}
    }

    // ------------------- Attachments -------------------
    public void openAttachments() {
        clickable(attachmentsTab).click();
    }

    public void uploadAttachment(String path, String description) {

        scrollIntoView(clickable(addButton));
        clickJS(driver.findElement(addButton));

        driver.findElement(fileInput).sendKeys(path);
        visible(descriptionTextarea).sendKeys(description);

        WebElement saveBtn = clickable(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[3]/div/form/div[3]/button[2]"));
        scrollIntoView(saveBtn);
        clickJS(saveBtn);

        wait.until(ExpectedConditions.invisibilityOfElementLocated(toast));
    }

    public void deleteAttachment(WebDriver driver, String fileName) {
       // openAttachments();
        WebElement row = wait.until(ExpectedConditions.visibilityOfElementLocated(getRow(fileName)));
        row.findElement(By.cssSelector("i[class=\"oxd-icon bi-trash\"]")).click();
        clickable(confirmDeleteButton).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.invisibilityOf(row));
    }


    public boolean isAttachmentPresent(String fileName) {
    //    openAttachments();
        return !driver.findElements(getRow(fileName)).isEmpty();
    }

    // ------------------- Profile Picture -------------------
    public void openProfilePic() {
        clickJS(visible(profilePic));
    }

    public void uploadPicture(String imagePath) {
        WebElement input = wait.until(ExpectedConditions.presenceOfElementLocated(fileInput));
        input.sendKeys(imagePath);
    }

    public void savePicture() {
        clickJS(visible(savePictureButton));
    }
}
