package com.anhtester.NavigationPage.testcases;

import com.anhtester.NavigationPage.pages.DashboardPage;
import com.anhtester.NavigationPage.pages.LoginPage;
import com.anhtester.common.BaseTest;
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
        dashboardPage.logOut();
    }

    @Test
    public void testLoginWithEmailInvalid(){
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM("admin123@example.com", "123456");
        loginPage.verifyLoginFail();
    }
}
