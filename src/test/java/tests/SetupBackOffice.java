package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class SetupBackOffice {

    @BeforeClass
    public void setup() throws InterruptedException {

    }

    @AfterClass
    public void clickSubmitBtnAndTeardown() throws InterruptedException{
        LandingPage landingPageObj = new LandingPage(myWebDriver);
        landingPageObj.getCouponValue().sendKeys("1");
        landingPageObj.getBillingCode().sendKeys("123");
        landingPageObj.clickSubmitBtn();
        Thread.sleep(2000);
        myWebDriver.quit();
    }

}
