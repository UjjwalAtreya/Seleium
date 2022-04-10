package Tests;

import Helpers.Helper;
import Helpers.Hooks;
import PageObjects.LoginPage;
import org.testng.annotations.Test;
import static Helpers.Helper.*;

public class LoginTest extends Hooks {

    @Test
    public void testWithValidCredentials(){
        LoginPage loginPage = new LoginPage(Helper.getDriver());
        loginPage.enterUserName(prop.getProperty("username"));
        loginPage.enterPassword(prop.getProperty("username"));
        loginPage.clickLoginButton();
    }
    @Test
    public void testWithValidCredentials1(){
        LoginPage loginPage = new LoginPage(Helper.getDriver());
        loginPage.enterUserName(prop.getProperty("username"));
        loginPage.enterPassword(prop.getProperty("username"));
        loginPage.clickLoginButton();
    }
    @Test
    public void testWithValidCredentials2(){
        LoginPage loginPage = new LoginPage(Helper.getDriver());
        loginPage.enterUserName(prop.getProperty("username"));
        loginPage.enterPassword(prop.getProperty("username"));
        loginPage.clickLoginButton();
    }
}
