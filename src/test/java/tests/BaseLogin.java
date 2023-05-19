package tests;

import PageObjects.LoginPage;
import Utils.Helper;

import java.io.IOException;
import static Utils.Helper.prop;

public class BaseLogin extends Setup {
    public void loginFlow() throws InterruptedException, IOException {
        LoginPage loginPageObj = new LoginPage(Helper.getDriver());
        loginPageObj.enterUserName(prop.getProperty("username"));
        loginPageObj.enterPassword(prop.getProperty("password"));
        loginPageObj.clickSubmitButton();
        Thread.sleep(3000);
    }
}
