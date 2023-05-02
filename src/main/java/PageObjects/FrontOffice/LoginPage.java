package PageObjects.FrontOffice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(id = "Email")
    public WebElement emailTextField;
    @FindBy(id = "Pin")
    public WebElement pinTextField;
    @FindBy(xpath = "//button[contains(text(),'Sign In')]")
    public WebElement submitButton;
    @FindBy(xpath = "//div[@class='form-floating mb-3']//span[@class='text-danger pt-3 d-block']")
    public WebElement errorMessage;
    @FindBy(id = "Email-error")
    public WebElement invalidUsernameMessage;
    @FindBy(xpath = "//input[@type='password']/../span[2]")
    public WebElement invalidPasswordMessage;
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setEmailInput(String userEmail) {
        emailTextField.sendKeys(userEmail);
    }

    public void setPinInput(String userPin) {
        pinTextField.sendKeys(userPin);
    }

    public void clickOnSubmitBtn() {
        submitButton.click();
    }

    public WebElement errorMessage() {
        return errorMessage;
    }

    public String emailValidationMessage() {
        return invalidUsernameMessage.getText();
    }

    public String passwordValidationMessage() throws InterruptedException {
        Thread.sleep(2000);
        return invalidPasswordMessage.getText();
    }


}
