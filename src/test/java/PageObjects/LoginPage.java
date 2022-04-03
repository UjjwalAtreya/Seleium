package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;

    @FindBy(xpath = "//input[@name='username']")
    WebElement usernameTextField;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordTextField;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement loginButton;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void enterUserName(String username){
        usernameTextField.sendKeys(username);
    }
    public void enterPassword(String password){
        passwordTextField.sendKeys(password);
    }
    public void clickLoginButton(){
        loginButton.click();
    }
}
