package Listners;

import Helpers.Helper;
import Helpers.Hooks;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class WebDriverListener implements IInvokedMethodListener {
    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            WebDriver driver = null;
            try {
                driver = Hooks.createInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Helper.setWebDriver(driver);
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        //do something after Invocation

    }
}
