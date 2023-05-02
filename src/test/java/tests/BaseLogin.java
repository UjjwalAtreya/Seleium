package tests;

import PageObjects.BackOffice.BO_LoginPage;
import PageObjects.FrontOffice.LoginPage;
import Utils.Helper;

import java.io.IOException;
import static Utils.Helper.prop;

public class BaseLogin extends Setup {
    /* This is a base login class, all the test will call the valid test method in order to
    * login to the system before the test executes */

    public void validTest() throws InterruptedException, IOException {
        LoginPage loginPageObj = new LoginPage(Helper.getDriver());
        loginPageObj.setEmailInput(prop.getProperty("username"));
        loginPageObj.setPinInput(prop.getProperty("password"));
        loginPageObj.clickOnSubmitBtn();

    }
    public void BO_LoginTest(){
        BO_LoginPage bo_loginPageObj = new BO_LoginPage(Helper.getDriver());
        bo_loginPageObj.setBo_emailTextField(prop.getProperty("BO_username"));
        bo_loginPageObj.setBo_passwordTextField(prop.getProperty("BO_password"));
        bo_loginPageObj.clickBo_submitBtn();
    }
}
