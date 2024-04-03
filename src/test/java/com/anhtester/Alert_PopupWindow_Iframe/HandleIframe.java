package com.anhtester.Alert_PopupWindow_Iframe;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Base64;

public class HandleIframe extends BaseTest {
    @Test
    public void testIFrame01() throws InterruptedException {

        driver.navigate().to("https://anhtester.com/contact");
        Thread.sleep(10000);
        System.out.println("iframe total: " + driver.findElements(By.tagName("iframe")).size()); //dem tat ca cac iframe
        //----Switch to content of Messenger--------
        driver.switchTo().frame(0); //Thẻ iframe thứ nhất
        System.out.println(driver.findElement(By.tagName("strong")).getText());

        //----Switch to icon of Messenger---------

        //1. Switch to Parent WindowHandle
        driver.switchTo().parentFrame(); //Chuyển về nội dung chính không thuộc iframe nào

        //2. Switch to iframe icon of Messenger
        driver.switchTo().frame(1); //Thẻ iframe thứ hai
        driver.findElement(By.tagName("svg")).click(); //Nhấn icon để ẩn messenger chat đi

        Thread.sleep(2000);
    }

    @Test
    public void testIframeOnVNExpress(){
        driver.get("https://dantri.com.vn/");
        sleep(9);

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='aswift_1']")));
        sleep(2);
        int div = driver.findElements(By.xpath("//div[contains(@id, 'mys-wrapper')]")).size();
        System.out.println(div);
        driver.findElement(By.xpath("//div[contains(@id, 'mys-wrapper')]")).click();
    }
}
