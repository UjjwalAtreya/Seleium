package Tests;

import Helpers.Helper;
import Helpers.Hooks;
import PageObjects.LoginPage;
import org.testng.annotations.Test;
import static Helpers.Helper.*;

public class LoginTest extends Hooks {

    @Test
    public void testWithValidCredentials(){
        System.out.println(Thread.currentThread().getId());
        System.out.println("Driver is ======"+Helper.getDriver());
        LoginPage loginPage = new LoginPage(Helper.getDriver());
        loginPage.enterUserName(prop.getProperty("username"));
        loginPage.enterPassword(prop.getProperty("username"));
        loginPage.clickLoginButton();
    }
    @Test
    public void testWithValidCredentials1(){
        System.out.println(Thread.currentThread().getId());
        System.out.println("Driver is ======"+Helper.getDriver());
        LoginPage loginPage = new LoginPage(Helper.getDriver());
        loginPage.enterUserName(prop.getProperty("username"));
        loginPage.enterPassword(prop.getProperty("username"));
        loginPage.clickLoginButton();
    }
    @Test
    public void testWithValidCredentials2(){
        System.out.println(Thread.currentThread().getId());
        System.out.println("Driver is ======"+Helper.getDriver());
        LoginPage loginPage = new LoginPage(Helper.getDriver());
        loginPage.enterUserName(prop.getProperty("username"));
        loginPage.enterPassword(prop.getProperty("username"));
        loginPage.clickLoginButton();
    }
}
