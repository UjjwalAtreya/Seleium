package tests.Tests;

import PageObjects.EmployeeCreation;
import PageObjects.UserManagement;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseLogin;
import Utils.ExtentTestManager;
import static Utils.Helper.prop;


import java.io.IOException;

import static Utils.Helper.getDriver;


public class Tests extends BaseLogin {
    @Test(description = "Verify if user can login with valid credentials.")
    public void testLoginWithValidCredentials() throws InterruptedException, IOException {
        ExtentTestManager.getTest().getDescription();
        ExtentTestManager.getTest().log(LogStatus.INFO, "Login Using Valid Credentials", "");
        loginFlow();
        ExtentTestManager.getTest().log(LogStatus.INFO, "Get Page title : ", getDriver().getTitle());
        String actualTitle = getDriver().getTitle();
        String expectedTitle = "OrangeHRM";
        try{
            Assert.assertEquals(actualTitle, expectedTitle, "Title of page do not match");
            ExtentTestManager.getTest().log(LogStatus.PASS, "Page Title asserted ", "");
        }catch (AssertionError error){
            Assert.fail();
            ExtentTestManager.getTest().log(LogStatus.FAIL, "Page Title not same ", error.getMessage());
        }
    }

    @Test(description = "Test to Verify Employee Creation..")
    public void testToVerifyIfEmployeeIsCreated() throws IOException, InterruptedException {
        ExtentTestManager.getTest().getDescription();
        ExtentTestManager.getTest().log(LogStatus.INFO, "Login Using Valid Credentials", "");
        loginFlow();
        ExtentTestManager.getTest().log(LogStatus.INFO, "Enter Employee Details", "");
        EmployeeCreation employeeCreation = new EmployeeCreation(getDriver());
        employeeCreation.clickMenuOption("PIM");
        employeeCreation.clickAddEmployeeButton();
        employeeCreation.enterEmployeeDetails(prop.getProperty("firstName"),prop.getProperty("lastName"));
        try {
            Assert.assertEquals(employeeCreation.getUserName(),
                    ""+prop.getProperty("firstName")+" "+prop.getProperty("lastName"));
            ExtentTestManager.getTest().log(LogStatus.PASS, "Employee Created Successfully..", "");
        }catch (AssertionError error){
            Assert.fail();
            ExtentTestManager.getTest().log(LogStatus.PASS, "Employee Not Created", error.getMessage());

        }
    }

    @Test
    public void testToVerifySearchFunctionalityInUserManagement() throws IOException, InterruptedException {
        ExtentTestManager.getTest().getDescription();
        ExtentTestManager.getTest().log(LogStatus.INFO, "Login Using Valid Credentials", "");
        loginFlow();
        ExtentTestManager.getTest().log(LogStatus.INFO, "Enter Search Text", "");
        EmployeeCreation employeeCreation = new EmployeeCreation(getDriver());
        UserManagement userManagement = new UserManagement(getDriver());
        employeeCreation.clickMenuOption("Admin");
        userManagement.enterSearchTextInSearchBox("Admin");
        try {
            Assert.assertEquals(userManagement.getSearchedItem(), ""+prop.getProperty("username"));
            ExtentTestManager.getTest().log(LogStatus.PASS, "Searched User Verified", "");
        }catch (AssertionError error){
            Assert.fail();
            ExtentTestManager.getTest().log(LogStatus.PASS, "No Search user returned", "");
        }


    }
}
