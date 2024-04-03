package com.anhtester.Thuchanh;

import com.anhtester.common.BaseTest;
import com.anhtester.locators.LocatorCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo_AddCustomer extends BaseTest {

    String COMPANY_NAME = "CTY 2 thanh vien";


    public void loginCRM(){
        //Login
        driver.get("https://crm.anhtester.com/admin/authentication");
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerLoginPage)).isDisplayed(), "Khong phai trang login");
        driver.findElement(By.xpath(LocatorCRM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorCRM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorCRM.buttonLogin)).click();
        sleep(1);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.menuDashboard)).isDisplayed(), "Khong den duoc trang Dashboard");
    }

    @Test
    public void testAddNewCustomer(){

        //Login
        loginCRM();

        driver.findElement(By.xpath(LocatorCRM.menuCustomers)).click();
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerCustomersPage)).isDisplayed(), "Khong den duoc trang Customer");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCRM.headerCustomersPage)).getText(), "Customers Summary", "Ten header cua trang Customer khong dung");
        sleep(1);

        //Tao moi customer
        driver.findElement(By.xpath(LocatorCRM.buttonAddNewCustomer)).click();
        driver.findElement(By.xpath(LocatorCRM.inputCompanyName)).sendKeys(COMPANY_NAME);
        driver.findElement(By.xpath(LocatorCRM.inputVatNumber)).sendKeys("111");
        driver.findElement(By.xpath(LocatorCRM.inputPhone)).sendKeys("0921998365");
        driver.findElement(By.xpath(LocatorCRM.inputWebsite)).sendKeys("https://cty1tv.com");
        driver.findElement(By.xpath(LocatorCRM.dropdownGroups)).click();
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.inputSearchGroup)).sendKeys("Gold");
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.inputSearchGroup)).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath(LocatorCRM.dropdownGroups)).click();
        driver.findElement(By.xpath(LocatorCRM.dropdownCurrency)).click();
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.inputSearchCurrency)).sendKeys("usd");
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.inputSearchCurrency)).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath(LocatorCRM.dropdownCurrency)).click();
        driver.findElement(By.xpath(LocatorCRM.dropdownLanguage)).click();
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.optionVietnamese)).click();
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.dropdownLanguage)).click();
        driver.findElement(By.xpath(LocatorCRM.inputAddress)).sendKeys("Gia Lam - Ha Noi");
        driver.findElement(By.xpath(LocatorCRM.inputCity)).sendKeys("HA NOI");
        driver.findElement(By.xpath(LocatorCRM.inputState)).sendKeys("Ha Noi");
        driver.findElement(By.xpath(LocatorCRM.inptZipCode)).sendKeys("123");
        driver.findElement(By.xpath(LocatorCRM.dropdownCountry)).click();
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.inputSearchCountry)).sendKeys("vietnam");
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.inputSearchCountry)).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath(LocatorCRM.buttonSaveCustomer)).click();
        sleep(3);

        //Tim kiem customer vua tao moi
        driver.findElement(By.xpath(LocatorCRM.menuCustomers)).click();
        driver.findElement(By.xpath(LocatorCRM.inputSearchCustomers)).click();
        driver.findElement(By.xpath(LocatorCRM.inputSearchCustomers)).sendKeys(COMPANY_NAME);
        sleep(2);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.firstItemCustomerOnTable)).isDisplayed(), "Khong tim thay customer");

        //Kiem tra gia tri sau khi tao moi
        driver.findElement(By.xpath(LocatorCRM.firstItemCustomerOnTable)).click();
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputCompanyName)).getAttribute("value"), COMPANY_NAME, "Ten Comppany khong dung");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputVatNumber)).getAttribute("value"), "111", "VAT Number khong dung");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputPhone)).getAttribute("value"), "0921998365", "So dien thoai khong dung");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputWebsite)).getAttribute("value"), "https://cty1tv.com", "Website khong dung");
    }

    @Test
    public void AddNewContact() {

        loginCRM();

        driver.findElement(By.xpath(LocatorCRM.menuCustomers)).click();
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerCustomersPage)).isDisplayed(), "Khong den duoc trang Customer");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCRM.headerCustomersPage)).getText(), "Customers Summary", "Ten header cua trang Customer khong dung");
        sleep(1);

        //Tim kiem customer vua tao moi
        driver.findElement(By.xpath(LocatorCRM.menuCustomers)).click();
        driver.findElement(By.xpath(LocatorCRM.inputSearchCustomers)).click();
        driver.findElement(By.xpath(LocatorCRM.inputSearchCustomers)).sendKeys(COMPANY_NAME);
        sleep(2);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.firstItemCustomerOnTable)).isDisplayed(), "Khong tim thay customer");
        driver.findElement(By.xpath(LocatorCRM.firstItemCustomerOnTable)).click();

        //Add new contact
        driver.findElement(By.xpath(LocatorCRM.menuContacts)).click();
        sleep(2);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerContactPage)).isDisplayed(), "Khong tim thay trang contact");
        driver.findElement(By.xpath(LocatorCRM.buttonAddNewContact)).click();
        sleep(1);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerAddNewContactDialog)).isDisplayed(), "Khong tim thay popup tao moi contact");
        sleep(2);
        driver.findElement(By.xpath(LocatorCRM.inputProfileImage)).sendKeys( System.getProperty("user.dir") + "\\src\\test\\java\\resource\\datatest\\chimmy.jpg"); //Lay duong dan tuyet doi den 1 file bat ky
        sleep(2);
        driver.findElement(By.xpath(LocatorCRM.inputFirstName)).sendKeys("Vu");
        driver.findElement(By.xpath(LocatorCRM.inputLastName)).sendKeys("Khanh Linh");
        driver.findElement(By.xpath(LocatorCRM.inputPosition)).sendKeys("Gia Lam");
        driver.findElement(By.xpath(LocatorCRM.inputEmailContact)).sendKeys("khanhlinhvu@gmail.com");
        driver.findElement(By.xpath(LocatorCRM.inputPhoneContact)).sendKeys("984332176");
        driver.findElement(By.xpath(LocatorCRM.dropdownDirection)).click();
        driver.findElement(By.xpath(LocatorCRM.optionLTR)).click();
        driver.findElement(By.xpath(LocatorCRM.inputPasswordContact)).sendKeys("123456");
        //driver.findElement(By.xpath(LocatorCRM.buttonGeneratePassword)).click();
        //driver.findElement(By.xpath(LocatorCRM.buttonShowPassword)).click();
        driver.findElement(By.xpath(LocatorCRM.checkboxDoNotSendEmail)).click();
        driver.findElement(By.xpath(LocatorCRM.buttonSaveContact)).click();
        sleep(3);

        //Tim kiem contact vua tao
        driver.findElement(By.xpath(LocatorCRM.inputSearchContact)).click();
        driver.findElement(By.xpath(LocatorCRM.inputSearchContact)).sendKeys("Vu Khanh Linh");
        sleep(2);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.inputSearchContact)).isDisplayed(), "Khong tim thay contact");

        //Kiem tra gia tri sau khi tao moi contact
        driver.findElement(By.xpath(LocatorCRM.firstItemContactOnTable)).click();
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputFirstName)).getAttribute("value"), "Vu", "First name khong dung");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputLastName)).getAttribute("value"), "Khanh Linh", "Last name khong dung");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputEmailContact)).getAttribute("value"), "khanhlinhvu@gmail.com", "Email khong dung");
    }
}
