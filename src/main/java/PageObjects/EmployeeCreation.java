package PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static Utils.Helper.prop;

public class EmployeeCreation {

    @FindBy(xpath = "//ul[@class='oxd-main-menu']/li")
    public List<WebElement> menuptions;

    @FindBy(xpath = "(//div[@class='orangehrm-header-container'])/button")
    public WebElement addEmployeeButton;

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement firstNameTextField;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement lastNameTextField;

    @FindBy(xpath = "//div[@class='oxd-form-actions']/button[2]")
    public WebElement employeeSaveButton;

    @FindBy(xpath = "//div[@class='orangehrm-edit-employee-name']/h6")
    public WebElement userNameHeader;

    public WebDriver driver;
    public WebDriverWait wait;
    public EmployeeCreation(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickMenuOption(String menu){
        for (WebElement option:menuptions) {
            System.out.println(option.getText());
            if(option.getText().equalsIgnoreCase(menu)){
                option.click();
                break;
            }
        }
    }

    public void clickAddEmployeeButton() throws InterruptedException {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(addEmployeeButton));
        addEmployeeButton.click();
        Thread.sleep(3000);
    }

    public void enterEmployeeDetails(String fname,String lname) throws InterruptedException {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(employeeSaveButton));
        firstNameTextField.sendKeys(fname);
        lastNameTextField.sendKeys(lname);
        employeeSaveButton.click();
        //Thread.sleep(4000);
    }

    public String getUserName() throws InterruptedException {
       // driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(userNameHeader));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.
                textToBePresentInElement(userNameHeader,""+prop.getProperty("firstName")+" "+prop.getProperty("lastName")));
        return  userNameHeader.getText();
    }
}
