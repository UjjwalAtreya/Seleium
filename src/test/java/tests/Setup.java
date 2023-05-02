package tests;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.TestNGException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import Utils.Helper;

import java.io.IOException;

import static Utils.Helper.prop;
import static Utils.Helper.readConfig;

public class Setup {

    static String browser;
    static String confFile;
    static String Hub;

    //Before Suite
    @BeforeSuite(alwaysRun = true, dependsOnMethods = "getConfigFile")
    public static void readConfigFile() {
        /*This function will read the config file and determines which test data to use for
        * the test */
        try {
            readConfig(confFile);
        } catch (Exception ignored) {

        }
    }

    public static WebDriver createInstance() throws IOException {
        /* This function will create a instance of chrome driver,
        * We need to add mre logics for different browser support..*/
        WebDriver driver;

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions option = new ChromeOptions();
            option.addArguments("disable-infobars");
            option.addArguments("--remote-allow-origins=*");

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(option);
            driver.manage().window().maximize();
            driver.get(prop.getProperty("BaseUrl"));

            return driver;
        }
        return null;
    }

    @BeforeSuite
    @Parameters({"configFile", "HubUrl"})
    public void getConfigFile(String configFile, String HubUrl) {
        /*This function will get the config file and hub url
         names form the testNg xml file*/
        confFile = configFile;
        Hub = HubUrl;
    }

    @BeforeMethod
    @Parameters({"browserName"})
    public void getRemoteUrl(String browserName) {
        /*This function will get the browser name as parameter and for which the
        * test should run on*/
        try {
            browser = browserName;
        } catch (Exception ignored) {

        }
    }

    @AfterMethod
    public void tearDown() {
        /*This function will quit the browser will all the test are completed*/
        try {
            WebDriver driver = Helper.getDriver();
            if (driver != null) {
                driver.quit();
            }
        } catch (TestNGException e) {
            e.printStackTrace();
        }
    }
}

