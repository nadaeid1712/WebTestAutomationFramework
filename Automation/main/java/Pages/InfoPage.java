package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class InfoPage {
    private WebDriver driver;
    private Actions actions;

    public InfoPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);

        // implicit wait (allowed)
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));
    }

    private By myInfoMenu = By.xpath("//a[contains(@href,'viewMyDetails')]");
    private By firstNameInput = By.name("firstName");
    private By middleNameInput = By.name("middleName");
    private By lastNameInput = By.name("lastName");
    private By otherIDInput = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/div/div/input");
    private By licenseInput = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[1]/div[1]/div/div[2]/input");
    private By dobInput = By.xpath("//label[text()='Date of Birth']/../following-sibling::div//input");
    private By saveBtn = By.xpath("//button[contains(.,'Save')]");
    private By attachmentsTab = By.xpath("//h6[text()='Attachments']");
    private By addButton = By.cssSelector("button.oxd-button--text");
    private By fileInput = By.cssSelector("input[type='file']");
    private By descriptionTextarea = By.tagName("textarea");
    private By confirmDeleteButton = By.xpath("//button[contains(., 'Yes, Delete')]");
    private By profilePic = By.cssSelector("img.employee-image");
    private By savePictureButton = By.xpath("//button[contains(., 'Save')]");


    private void clearAndType(By locator, String value) {
        WebElement field = driver.findElement(locator);
        field.clear();
        field.sendKeys(value);
    }

    private void moveAndClick(By locator) {
        WebElement element = driver.findElement(locator);
        actions.moveToElement(element).click().perform();  // scrolls + clicks without JS
    }



    public void openMyInfo() {
        moveAndClick(myInfoMenu);
    }

    public InfoPage setFirstName(String v) {
        clearAndType(firstNameInput, v);
        return this;
    }

    public InfoPage setMiddleName(String v) {
        clearAndType(middleNameInput, v);
        return this;
    }

    public InfoPage setLastName(String v) {
        clearAndType(lastNameInput, v);
        return this;
    }

    public InfoPage setOtherID(String v) {
        clearAndType(otherIDInput, v);
        return this;
    }

    public InfoPage setLicense(String v) {
        clearAndType(licenseInput, v);
        return this;
    }

    public InfoPage setDateOfBirth(String v) {
        WebElement input = driver.findElement(dobInput);
        input.clear();
        input.sendKeys(v);
        input.sendKeys(Keys.ENTER);
        return this;
    }

    public String getFirstName() { return driver.findElement(firstNameInput).getAttribute("value"); }
    public String getMiddleName() { return driver.findElement(middleNameInput).getAttribute("value"); }
    public String getLastName() { return driver.findElement(lastNameInput).getAttribute("value"); }
    public String getOtherID() { return driver.findElement(otherIDInput).getAttribute("value"); }
    public String getLicense() { return driver.findElement(licenseInput).getAttribute("value"); }
    public String getDateOfBirth() { return driver.findElement(dobInput).getAttribute("value"); }

    public void saveInfo() {
        moveAndClick(saveBtn);
    }


    public void uploadAttachment(String path, String description) {

        moveAndClick(addButton);

        driver.findElement(fileInput).sendKeys(path);

        driver.findElement(descriptionTextarea).sendKeys(description);

        By saveAttachBtn = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[3]/div/form/div[3]/button[2]");
        moveAndClick(saveAttachBtn);
    }

    private By getRow(String fileName) {
        return By.xpath("//div[@class='oxd-table-card'][.//div[contains(text(),'" + fileName + "')]]");
    }

    public void deleteAttachment(String fileName) {
        WebElement row = driver.findElement(getRow(fileName));
        WebElement trash = row.findElement(By.cssSelector("i.bi-trash"));

        actions.moveToElement(trash).click().perform();
        actions.moveToElement(driver.findElement(confirmDeleteButton)).click().perform();
    }

    public boolean isAttachmentPresent(String fileName) {
        return !driver.findElements(getRow(fileName)).isEmpty();
    }


    public void openProfilePic() {
        moveAndClick(profilePic);
    }

    public void uploadPicture(String imagePath) {
        driver.findElement(fileInput).sendKeys(imagePath);
    }

    public void savePicture() {
        moveAndClick(savePictureButton);
    }
}
