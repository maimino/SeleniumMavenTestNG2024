package com.anhtester.JavascriptExecutor;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DemoJavascriptExecutor extends BaseTest {
    @Test
    public void testJavascriptExecutor01(){
        driver.get("https://cms.anhtester.com/");
        sleep(2);

        //By buttonCloseWelcomeDialog = By.xpath("//button[@data-key='website-popup']"); //cach 1
        WebElement buttonCLoseWelcomeDialog = driver.findElement(By.xpath("//button[@data-key='website-popup']")); //cach 2
        WebElement menuFlashSale = driver.findElement(By.xpath("//a[normalize-space()='Flash Sale']"));
        WebElement buttonViewALLCategories = driver.findElement(By.xpath("//a[normalize-space()='View All Categories']"));

//        //Cach thong thuong
//        buttonCLoseWelcomeDialog.click();
//        menuFlashSale.click();

        //Su dung JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", menuFlashSale); //Nhấp vào một Element
    }

    @Test
    public void testJavascriptExecutor02(){
        driver.get("https://cms.anhtester.com/");
        sleep(2);

        WebElement buttonCLoseWelcomeDialog = driver.findElement(By.xpath("//button[@data-key='website-popup']"));
        WebElement inputSearch = driver.findElement(By.xpath("//input[@id='search']"));

        buttonCLoseWelcomeDialog.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','laptop');", inputSearch);
    }

    @Test
    public void testJavascriptExecutor03(){
        driver.get("https://cms.anhtester.com/");
        sleep(2);

        WebElement buttonCLoseWelcomeDialog = driver.findElement(By.xpath("//button[@data-key='website-popup']"));
        WebElement buttonViewALLCategories = driver.findElement(By.xpath("//a[normalize-space()='View All Categories']"));

        buttonCLoseWelcomeDialog.click();
        sleep(1);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].scrollIntoView(true);", buttonViewALLCategories);
        //true-cuon chuot den vi tri top

        // false-cuon chuot den vi tri bottom
        js.executeScript("arguments[0].scrollIntoView(false);", buttonViewALLCategories); //Để cuộn tới 1 phần tử trong trang

        //Highlight phần tử trên web
        js.executeScript("arguments[0].style.border='3px solid black'", buttonViewALLCategories);
        sleep(2);

        buttonViewALLCategories.click();
        sleep(1);
    }
}
