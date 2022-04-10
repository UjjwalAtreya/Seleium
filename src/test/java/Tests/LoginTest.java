package Tests;

import Helpers.Hooks;
import PageObjects.LoginPage;
import org.testng.annotations.Test;
import static Helpers.Helper.*;

public class LoginTest extends Hooks {

    @Test
    public void testWithValidCredentials(){
        System.out.println(Thread.currentThread().getId());
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.enterUserName(prop.getProperty("username"));
        loginPage.enterPassword(prop.getProperty("username"));
        loginPage.clickLoginButton();
    }
    @Test
    public void testWithValidCredentials1(){
        System.out.println(Thread.currentThread().getId());
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.enterUserName(prop.getProperty("username"));
        loginPage.enterPassword(prop.getProperty("username"));
        loginPage.clickLoginButton();
    }
    @Test
    public void testWithValidCredentials2(){
        System.out.println(Thread.currentThread().getId());
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.enterUserName(prop.getProperty("username"));
        loginPage.enterPassword(prop.getProperty("username"));
        loginPage.clickLoginButton();
    }
}
