package com.anhtester.PageObjectModel.testcases;

import com.anhtester.PageObjectModel.pages.DashboardPage;
import com.anhtester.PageObjectModel.pages.LoginPage;
import com.anhtester.common.BaseTest;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;

    public void testLogin(){
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@example.com", "123456");
        waitForPageLoaded();
        loginPage.verifyLoginSuccess();
    }

    @Test
    public void testDashboard(){
        testLogin();
        dashboardPage = new DashboardPage(driver);
        dashboardPage.verifyDashboard();
        waitForPageLoaded();
        dashboardPage.clickDashboardOptions();
        waitForPageLoaded();
        dashboardPage.logoutCRM();
        dashboardPage.verifyLogoutSuccess();
    }
}
