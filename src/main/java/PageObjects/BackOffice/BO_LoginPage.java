package PageObjects.BackOffice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BO_LoginPage {

    WebDriver driver;

    public BO_LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "UserName")
    public WebElement bo_emailTextField;

    @FindBy(id = "Password")
    public WebElement bo_passwordTextField;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement bo_submitBtn;

    public void setBo_emailTextField(String userEmail) {
        bo_emailTextField.sendKeys(userEmail);
    }

    public void setBo_passwordTextField(String userPin) {
        bo_passwordTextField.sendKeys(userPin);
    }

    public void clickBo_submitBtn() {
        bo_submitBtn.click();
    }



}
