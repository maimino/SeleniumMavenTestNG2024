package com.anhtester.ThuchanhPOM.tests;

import com.anhtester.ThuchanhPOM.pages.CustomerPage;
import com.anhtester.ThuchanhPOM.pages.DashboardPage;
import com.anhtester.ThuchanhPOM.pages.LoginPage;
import com.anhtester.common.BaseTest;
import com.anhtester.constants.ConfigData;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;

    @Test
    public void testOpenCustomerPage(){
        //Login
        loginPage = new LoginPage(driver);
        dashboardPage =loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();
        //Click menu Customer
        customerPage = dashboardPage.clickMenuCustomers(); //Xay ra lien ke trang
        customerPage.verifyCustomerPage();
    }

    @Test
    public void testAdminRole(){
        loginPage = new LoginPage(driver);
        dashboardPage =loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();
        dashboardPage.verifyMenuReportDisplay();
    }
}
