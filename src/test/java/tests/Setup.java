package tests;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
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
        WebDriver driver = null;
        try {
            if(browser.equalsIgnoreCase("chrome")){
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                WebDriverManager.chromedriver().setup();
                driver= new ChromeDriver(options);
                driver.manage().window().maximize();
            } else if (browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                driver.manage().window().maximize();
            } else if (browser.equalsIgnoreCase("safari")) {
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                driver.manage().window().maximize();
            }
            driver.get(prop.getProperty("BaseUrl"));
            Thread.sleep(5000);
            return driver;
        } catch (Exception errorCreateInstance) {
            System.out.println("Cannot create Instance due to :" + errorCreateInstance);
        }
        return driver;
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

