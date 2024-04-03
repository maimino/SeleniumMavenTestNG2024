package com.anhtester.PageObjectModel.testcases;

import com.anhtester.PageObjectModel.pages.LoginPage;
import com.anhtester.common.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    //Khai bao doi tuong cua class LoginPage
    LoginPage loginPage;

    @Test
    @Parameters({"email", "password"})
    public void testLoginSuccess(String email, String password){
        loginPage = new LoginPage(driver);

        //Goi cac ham xu ly co san de su dung lai
        loginPage.loginCRM(email, password);
        waitForPageLoaded(); //Khi chuyen trang thi dung (load trang)
        loginPage.verifyLoginSuccess();
    }

    @Test
    public void testLoginWithEmailInvalid(){
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin123@example.com", "123456");
        loginPage.verifyLoginFail();
    }

    @Test
    public void testLoginWithPasswordInvalid(){
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@example.com", "abcd1234");
        loginPage.verifyLoginFail();
    }
}
