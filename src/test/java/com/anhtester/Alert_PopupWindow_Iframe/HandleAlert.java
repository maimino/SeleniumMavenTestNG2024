package com.anhtester.Alert_PopupWindow_Iframe;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.event.ActionListener;

public class HandleAlert extends BaseTest {
    @Test
    public void demoHandleAlertAccept() {
        driver.get("http://demo.seleniumeasy.com/javascript-alert-box-demo.html");
        sleep(2);

        //Mở Alert Message, click vào nút "Click me!" thứ nhất
        driver.findElement(By.xpath("(//button[text()='Click me!'])[1]")).click();
        sleep(1);

        //Khởi tạo class Alert thứ nhất
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();

        sleep(1);
    }

    @Test
    public void demoHandleAlertDismiss() {
        driver.get("http://demo.seleniumeasy.com/javascript-alert-box-demo.html");
        sleep(2);

        //Mở Alert Dismiss, click vào nút "Click me!" thứ 2
        driver.findElement(By.xpath("(//button[text()='Click me!'])[2]")).click();
        sleep(1);

        //Khởi tạo class Alert
        Alert alert2 = driver.switchTo().alert();
        alert2.dismiss();
        //driver.switchTo().alert().dismiss();

        Assert.assertTrue(driver.findElement(By.xpath("//p[@id='confirm-demo']")).isDisplayed(),
                "Chưa nhấn được nút Cancel");
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='confirm-demo']")).getText(),
                "You pressed Cancel!",
                "Khong nhan vao nut cancel");

        sleep(1);
    }

    @Test
    public void demoHandleAlertInputText() {
        driver.get("http://demo.seleniumeasy.com/javascript-alert-box-demo.html");
        sleep(2);

        //Mở Alert Input text, click nút thứ 3
        driver.findElement(By.xpath("//button[normalize-space()='Click for Prompt Box']")).click();
        sleep(1);

        //Khởi tạo class Alert
        Alert alert3 = driver.switchTo().alert();
        alert3.sendKeys("Anh Tester Demo Alert");
        alert3.accept();
        sleep(1);

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//p[@id='prompt-demo']"))).perform();

        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='prompt-demo']")).getText(),
                "You have entered 'Anh Tester Demo Alert' !",
                "Chưa điền được text");

        sleep(1);
    }

    @Test
    public void demoHandleAlertGetText() {
        driver.get("http://demo.seleniumeasy.com/javascript-alert-box-demo.html");
        sleep(2);

        driver.findElement(By.xpath("(//button[text()='Click me!'])[1]")).click();
        sleep(1);

        Alert alert1 = driver.switchTo().alert();
        String message = alert1.getText();
        System.out.println(message);
        Assert.assertEquals(message, "I am an alert box!", "Noi dung message khog dung");
        alert1.accept();

        sleep(1);
    }
}
