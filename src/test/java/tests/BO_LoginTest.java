package tests;

import Utils.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.io.IOException;

public class BO_LoginTest extends BaseLogin {

    @Test(description = "Verify if user can login with valid credentials.")
    public void testLoginWithValidCredentials() throws InterruptedException, IOException {
        ExtentTestManager.getTest().getDescription();
        ExtentTestManager.getTest().log(LogStatus.INFO, "Login Using Valid Credentials", "");
        BO_LoginTest();
    }

}
