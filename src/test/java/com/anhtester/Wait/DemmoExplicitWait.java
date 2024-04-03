package com.anhtester.Wait;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class DemmoExplicitWait extends BaseTest {
    @Test
    public void testExplicitWait01(){

        driver.get("https://hrm.anhtester.com/");

        //Set timeout
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.id("iusername")).sendKeys("admin_example");
        driver.findElement(By.id("ipassword")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Click menu dự án
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Projects')]")));

        driver.findElement(By.xpath("//span[contains(text(),'Projects')]")).click();

        sleep(2);
        driver.quit();
    }
}
