package com.anhtester.Assertions;

import com.anhtester.common.BaseTest;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoHardAssert extends BaseTest {
    @Test
    public void testLoginCRM(){
        driver.get("https://crm.anhtester.com/admin/authentication");

        //Assert header voi text cua no
        String header = driver.findElement(By.xpath("//h1[normalize-space()='Login']")).getText();
        Assert.assertEquals(header, "Login","Gia tri header sai"); //so sanh bang

        boolean checkButtonLogin = driver.findElement(By.xpath("//button[normalize-space()='Login']")).isEnabled();
        Assert.assertTrue(checkButtonLogin, "Nut login khong duoc bat"); //messge chi hien khi ket qua sai

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        String menuName = driver.findElement(By.xpath("//span[normalize-space()='Customers']")).getText();
        Assert.assertTrue(menuName.contains("Customer123"),"Gia tri menuName khong chua gia tri mong muon: " + menuName); //so sanh chua thong qua java
    }
}
