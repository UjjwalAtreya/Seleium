package Helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.TestNGException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import static Helpers.Helper.*;

public class Hooks {
    @BeforeSuite
    public void loadData() throws InterruptedException {
        readConfig();
    }

    @AfterMethod
    public void tearDown(){
        try {
            WebDriver driver = Helper.getDriver();
            if (driver != null) {
                driver.quit();
            }
        } catch (TestNGException e) {
            e.printStackTrace();
        }
    }

    public static WebDriver createInstance() {
        WebDriver driver = null;
        try {
            System.out.println("Creating Instances For the test");
            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();
            driver.get(prop.getProperty("BaseUrl"));
            Helper.setWebDriver(driver);
            return driver;
        } catch (Exception errorCreateInstance) {
            System.out.println("Cannot create Instance due to :" + errorCreateInstance);
        }
        return driver;
    }
}
