package tests.Listener;


import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import Utils.Helper;
import Utils.ExtentTestManager;


public class Retry implements IRetryAnalyzer {

    private int count = 0;
    private static int maxTry = 1; //run failed test 2 times

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {
            if (count < maxTry) {
                count++;
                iTestResult.setStatus(ITestResult.FAILURE);
                extendReportsFailOperations(iTestResult);
                return true;
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);
        }
        return false;
    }

    public void extendReportsFailOperations(ITestResult iTestResult) {
        String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) Helper.getDriver()).getScreenshotAs(OutputType.BASE64);
        String errorMessage = iTestResult.getThrowable().getMessage();
        ExtentTestManager.getTest().log(LogStatus.FAIL, "Re-Test Failed Again  : <br/>" + errorMessage,
                ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
    }
}
