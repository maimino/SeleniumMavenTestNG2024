package com.anhtester.NavigationPage.testcases;

import com.anhtester.NavigationPage.pages.CustomerPage;
import com.anhtester.NavigationPage.pages.DashboardPage;
import com.anhtester.NavigationPage.pages.LoginPage;
import com.anhtester.common.BaseTest;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;

    @Test
    public void testOpenCustomerPage(){
        //Login
        loginPage = new LoginPage(driver);
        dashboardPage =loginPage.loginCRM("admin@example.com","123456");

        //Click menu Customer
        customerPage = dashboardPage.clickMenuCustomers(); //Xay ra lien ke trang

        //Chuyen sang trang Customer
        customerPage.clickButtonAddnew();
    }

}
