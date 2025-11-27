package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePicPage {

    private WebDriver driver;

    private By uploadInput = By.cssSelector("input[type='file']");
    private By saveBtn = By.xpath("//button[contains(.,'Save')]");

    public ProfilePicPage(WebDriver driver) {
        this.driver = driver;
    }

    public void uploadPicture(String imagePath) {
        driver.findElement(uploadInput).sendKeys(imagePath);
    }

    public void savePicture() {
        driver.findElement(saveBtn).click();
    }
}

