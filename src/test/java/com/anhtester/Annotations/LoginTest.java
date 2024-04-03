package com.anhtester.Annotations;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test(priority = 1)
    public void  testLoginSuccess(){
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
    }

    @Test(priority = 2)
    public void testAddCustomer(){
        testLoginSuccess(); //Goi lai phan auto login tu testcase LoginSUccess
        driver.findElement(By.xpath("//span[normalize-space()='Customers']")).click();

    }
}
