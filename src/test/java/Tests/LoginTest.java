package Tests;

import Helpers.Hooks;
import PageObjects.LoginPage;
import org.testng.annotations.Test;
import static Helpers.Helper.*;

public class LoginTest extends Hooks {

    @Test
    public void testWithValidCredentials(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserName(prop.getProperty("username"));
        loginPage.enterPassword(prop.getProperty("username"));
        loginPage.clickLoginButton();
    }
}
