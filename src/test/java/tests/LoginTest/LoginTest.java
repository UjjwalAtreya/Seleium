package tests.LoginTest;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseLogin;
import Utils.ExtentTestManager;
import Utils.Helper;


import java.io.IOException;




public class LoginTest extends BaseLogin {


    //  Login Test For Valid Username and Password
    @Test(description = "Verify if user can login with valid credentials.")
    public void testLoginWithValidCredentials() throws InterruptedException, IOException {
        ExtentTestManager.getTest().getDescription();
        ExtentTestManager.getTest().log(LogStatus.INFO, "Login Using Valid Credentials", "");
        validTest();

        ExtentTestManager.getTest().log(LogStatus.INFO, "Get Page title : ", Helper.getDriver().getTitle());
        String actualTitle = Helper.getDriver().getTitle();
        String expectedTitle = "Login";
        try{
            Assert.assertEquals(actualTitle, expectedTitle, "Page title should be related to dashboard.");
            ExtentTestManager.getTest().log(LogStatus.PASS, "Page Title asserted ", "");
        }catch (AssertionError error){
            Assert.fail();
            ExtentTestManager.getTest().log(LogStatus.FAIL, "Page Title not same ", error.getMessage());
        }

    }
}
