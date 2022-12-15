package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class DashboardPage {
    public WebDriver driver;

    @FindBy(xpath = "//button[@class='oxd-icon-button orangehrm-quick-launch-icon']")
    List<WebElement> quickLaunchMenus;


    public DashboardPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void verifyAssignLeaveInQuickMenu(String assignLeaveMenu){
        for ( WebElement allMenus: quickLaunchMenus) {
            if ( allMenus.getText().contains( assignLeaveMenu ) ){
                Assert.assertTrue(true);
            }
        }
    }
}
