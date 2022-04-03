package Helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import static Helpers.Helper.*;

public class Hooks {
    public static WebDriver driver;
    @BeforeSuite
    public void loadData() throws InterruptedException {
        readConfig();
    }

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get(prop.getProperty("BaseUrl"));
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
}
