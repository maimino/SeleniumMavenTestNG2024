package com.anhtester.ThuchanhPOM.tests;

import com.anhtester.ThuchanhPOM.pages.DashboardPage;
import com.anhtester.ThuchanhPOM.pages.LoginPage;
import com.anhtester.common.BaseTest;
import com.anhtester.keywords.WebUI;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test
    public void testLoginSuccess(){
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM("admin@example.com", "123456");
        waitForPageLoaded();
        loginPage.verifyLoginSuccess();
        WebUI.captureScreenImage("testLoginSuccess");
        dashboardPage.logOut();
    }

    @Test
    public void testLoginWithEmailInvalid(){
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM("admin123@example.com", "123456");
        loginPage.verifyLoginFail();
        WebUI.captureScreenImage("testLoginWithEmailInvalid");
    }

    @Test
    public void testLoginWithPasswordInvalid(){
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM("admin@example.com", "abcd1234");
        loginPage.verifyLoginFail();
        WebUI.captureScreenImage("testLoginWithPasswordInvalid");
    }
}
