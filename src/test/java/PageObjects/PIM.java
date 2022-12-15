package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class PIM {
    public WebDriver driver;

    @FindBy(xpath = "//li[@class='oxd-main-menu-item-wrapper'][2]")
    WebElement PIMMenu;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    WebElement addButton;

    @FindBy(xpath = "//input[@name='firstName']")
    WebElement eFirstName;

    @FindBy(xpath = "//input[@name='lastName']")
    WebElement eLastName;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement eSave ;

    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 --strong']")
    WebElement empName;


    public PIM(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void clickPIMMenu (){
        PIMMenu.click();
        addButton.click();
    }

    public void enterEmployeeFirstName(String empFirstName){
        eFirstName.sendKeys(empFirstName);
    }

    public void enterEmployeeLastName(String empLastName){
        eLastName.sendKeys(empLastName);
    }
    public void saveEmployee(){
        eSave.click();
    }
    public void verifyAddedEmployee(String eName){
        String empAddedName = empName.getText();
        if(empAddedName.contains(eName)){
            Assert.assertTrue(true);
        }
    }
}
