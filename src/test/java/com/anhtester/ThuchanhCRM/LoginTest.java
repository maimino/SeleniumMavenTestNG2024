package com.anhtester.ThuchanhCRM;

import com.anhtester.common.BaseTest;
import com.anhtester.locators.LocatorCRM;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void testLoginSuccess(){
        driver.get(InfoCRM.URL);
        waitForPageLoaded();
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerLoginPage)).isDisplayed(), "Khong phai trang login");
        setText(LocatorCRM.inputEmail, InfoCRM.EMAIL);
        setText(LocatorCRM.inputPassword, InfoCRM.PASSWORD);
        clickElement(LocatorCRM.buttonLogin);
        waitForPageLoaded();

        boolean checkURL =  driver.getCurrentUrl().contains("authentication");
        Assert.assertFalse(checkURL); //assertFalse vi neu login thanh cong thi url khong duoc chua tu khoa "authentication"
        //boolean checkURLAfterLogin =  driver.getCurrentUrl().contains("admin");
        //Assert.assertTrue(checkURLAfterLogin);

        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.menuDashboard)).isDisplayed(), "Khong den duoc trang Dashboard");
    }

    /*Email hoac Password sai thi:
        - Hien message loi
        - Khong den duoc trang Dashboard
        - Van o lai trang login
        - URL chua tu khoa authentication
    */
    @Test
    public void testLoginWithEmailInvalid(){
        driver.get(InfoCRM.URL);
        waitForPageLoaded();
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerLoginPage)).isDisplayed(), "Khong phai trang login");
        setText(LocatorCRM.inputEmail, "admin@example123.com");
        setText(LocatorCRM.inputPassword, InfoCRM.PASSWORD);
        clickElement(LocatorCRM.buttonLogin);
        waitForPageLoaded();

        boolean checkURL =  driver.getCurrentUrl().contains("authentication");
        Assert.assertTrue(checkURL);
        Assert.assertTrue(checkElementExist(LocatorCRM.alertMessage), "Alert message khong xuat hien");
        Assert.assertEquals(getTextElement(LocatorCRM.alertMessage), "Invalid email or password");

        Assert.assertFalse(checkElementExist(LocatorCRM.menuDashboard), "Den duoc trang dashboard");
        Assert.assertTrue(checkElementExist(LocatorCRM.headerLoginPage), "Roi khoi trang login");
    }

    @Test
    public void testLoginWithPasswordlInvalid(){
        driver.get(InfoCRM.URL);
        waitForPageLoaded();
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerLoginPage)).isDisplayed(), "Khong phai trang login");
        setText(LocatorCRM.inputEmail, InfoCRM.EMAIL);
        setText(LocatorCRM.inputPassword, "111111");
        clickElement(LocatorCRM.buttonLogin);
        waitForPageLoaded();

        boolean checkURL =  driver.getCurrentUrl().contains("authentication");
        Assert.assertTrue(checkURL);
        Assert.assertTrue(checkElementExist(LocatorCRM.alertMessage), "Alert message khong xuat hien");
        Assert.assertEquals(getTextElement(LocatorCRM.alertMessage), "Invalid email or password");

        Assert.assertFalse(checkElementExist(LocatorCRM.menuDashboard), "Den duoc trang dashboard");

    }
}
