package Utils;



import com.google.common.base.Strings;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import java.util.Random;


public class Helper {

    public static Properties prop;
    public static String dataFolderBasePath = "suiteXml/config/";
    private static final Random random = new SecureRandom();
    // LocalWebDriverManager
    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();


    static {
        prop = new Properties();
    }


    public static void readConfig(String configFileName) throws IOException {
        try {
            if (configFileName == null || Strings.isNullOrEmpty(configFileName)) {
                configFileName = "test-data.xml";
            }
            File file = new File(dataFolderBasePath + configFileName);

            if (!file.exists()) {
                configFileName = "test-data.xml";
                file = new File(dataFolderBasePath + configFileName);
            }
            FileInputStream fileInput = new FileInputStream(file);
            prop.loadFromXML(fileInput);

            fileInput.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidPropertiesFormatException e) {
            throw new RuntimeException(e);
        }
    }


    //Take screenshot for failed test
    public static String takeScreenShot(String imageFileName) throws IOException, InterruptedException {
        TakesScreenshot screenshot = (TakesScreenshot) Helper.getDriver();
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "\\data\\images\\screenShotImage\\" + imageFileName + ".jpg"));
        String filePath = System.getProperty("user.dir") + "\\data\\images\\screenShotImage\\" + imageFileName + ".jpg";
        return filePath;
    }

    public static void waitForPageToBeReady() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        // Initially below given if condition will check ready state of page.
        if (js.executeScript("return document.readyState").toString().equals("complete")) {
            return;
        }
        // This loop will rotate for 25 times to check If page Is ready after every 1 second.
        int waitTime = 30; // 30 secs
        for (int i = 0; i < waitTime; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            //To check page ready state.
            if (js.executeScript("return document.readyState").toString().equals("complete")) {
                break;
            }
        }
    }

    public static WebDriver getDriver() {
        return webDriver.get();
    }

    public static void setWebDriver(WebDriver driver) {
        webDriver.set(driver);
    }
}

