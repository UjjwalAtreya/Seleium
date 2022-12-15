package Tests;

import Helpers.Helper;
import Helpers.Hooks;
import PageObjects.DashboardPage;
import PageObjects.LoginPage;
import PageObjects.PIM;
import org.testng.annotations.Test;
import static Helpers.Helper.*;

public class AllTest extends Hooks {

    @Test
    public void testWithValidCredentials() throws InterruptedException {
        LoginPage loginPage = new LoginPage(Helper.getDriver());
        loginPage.enterUserName(prop.getProperty("username"));
        loginPage.enterPassword(prop.getProperty("username"));
        loginPage.clickLoginButton();
        loginPage.validateLogin();
    }
    @Test
    public void testToVerifyQuickLaunchMenu() throws InterruptedException {
        LoginPage loginPage = new LoginPage(Helper.getDriver());
        DashboardPage dashboardPage = new DashboardPage(Helper.getDriver());
        loginPage.enterUserName(prop.getProperty("username"));
        loginPage.enterPassword(prop.getProperty("username"));
        loginPage.clickLoginButton();
        loginPage.validateLogin();
        dashboardPage.verifyAssignLeaveInQuickMenu(prop.getProperty("AssignLeave"));
    }

    @Test
    public void testToVerifyIfEmployeeIsAddedOrNot() throws InterruptedException {
        LoginPage loginPage = new LoginPage(Helper.getDriver());
        PIM pim = new PIM(Helper.getDriver());
        loginPage.enterUserName(prop.getProperty("username"));
        loginPage.enterPassword(prop.getProperty("username"));
        loginPage.clickLoginButton();
        pim.clickPIMMenu();
        pim.enterEmployeeFirstName(prop.getProperty("firstName"));
        pim.enterEmployeeLastName(prop.getProperty("lastName"));
        pim.saveEmployee();
    }
}
