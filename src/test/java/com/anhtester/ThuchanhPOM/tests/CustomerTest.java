package com.anhtester.ThuchanhPOM.tests;

import com.anhtester.ThuchanhPOM.pages.CustomerPage;
import com.anhtester.ThuchanhPOM.pages.DashboardPage;
import com.anhtester.ThuchanhPOM.pages.LoginPage;
import com.anhtester.common.BaseTest;
import com.anhtester.constants.ConfigData;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;

    @Test
    public void testAddNewCustomer(){
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        customerPage = dashboardPage.clickMenuCustomers();
        customerPage.verifyCustomerPage();

        customerPage.clickButtonAddnew();

        String CUSTOMER_NAME = "CTY 4 thanh vien";
        customerPage.inputFormData(CUSTOMER_NAME);
        customerPage.searchAndVerifyCustomer(CUSTOMER_NAME);
        customerPage.verifyCustomerDetail(CUSTOMER_NAME);
    }
}
