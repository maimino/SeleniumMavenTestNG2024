package com.anhtester.ActionsClass;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DemoActionsClass extends BaseTest {
    @Test
    public void TestSendKeys() {

        //driver kế thừa từ class SetupBrowser
        driver.get("https://www.google.com/");

        // Element search box
        WebElement element = driver.findElement(By.xpath("//textarea[@name='q']"));

        // Tạo đối tượng của Actions class và để driver vào
        Actions action = new Actions(driver);

        // Dùng action để gọi hàm sendkeys điền dữ liệu. Không dùng sendKeys của WebElement
//        action.sendKeys(element, "Anh Tester").perform();
//        sleep(2);
//        action.sendKeys(Keys.ENTER).perform();

        //Gop 2 ham tren thanh 1 ham -> dung build()
        action.sendKeys(element, "Anh Tester").sendKeys(Keys.ENTER).build().perform();
        sleep(2);

        //Click vao title cua ket qua tim kiem ben tren
        WebElement elementTitlePage = driver.findElement(By.xpath("//a[@aria-label='Anh Tester Automation Testing']"));
        action.click(elementTitlePage).perform(); //Goi ham click de click element tren
        sleep(2);
    }

    //doubleClick de click nhanh 2 lan vao phan tu do
    @Test
    public void doubleClick() {
        driver.get("https://anhtester.com/");
        sleep(2);
        WebElement element = driver.findElement(By.xpath("//div[@class='col-lg-7']//h2[@class='section__title'][contains(text(),'Anh Tester')]"));

        Actions action = new Actions(driver);

        action.doubleClick(element).build().perform();
        sleep(2);
    }

    //contextClick de click chuot phai
    @Test
    public void contextClick(){
        driver.get("https://anhtester.com/");
        sleep(2);
        WebElement element = driver.findElement(By.xpath("//div[@class='col-lg-7']//h2[@class='section__title'][contains(text(),'Anh Tester')]"));

        Actions action = new Actions(driver);

        action.contextClick(element).build().perform();
        sleep(2);
    }

    //moveToElement
    @Test
    public void moveToElement() {
        driver.get("https://anhtester.com/");
        sleep(2);
        WebElement element = driver.findElement(By.xpath("//h2[contains(text(),'Kiến thức Automation Testing')]"));

        Actions action = new Actions(driver);

        //Move to element (di chuyển tới title Kiến thức Automation Testing)
        action.moveToElement(element).build().perform();

        sleep(2);
    }

    //dragAndDrop
    @Test
    public void demoDragAndDropWithActionClass() {
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        sleep(1);

        // Bắt element cần kéo
        WebElement From = driver.findElement(By.xpath("//div[@id='box6']"));
        // Bắt element cần thả đến
        WebElement To = driver.findElement(By.xpath("//div[@id='countries']//div[1]"));

        sleep(1);
        Actions action = new Actions(driver);
        // Kéo và thả
        action.dragAndDrop(From, To).build().perform();

        sleep(2);
    }

    //Chuyen van ban sang chu hoa
    @Test
    public void inputTextUppercase(){
        driver.get("https://www.google.com/");
        sleep(1);
        WebElement element = driver.findElement(By.xpath("//textarea[@name='q']"));

        Actions action = new Actions(driver);

        // Đè giữ phím SHIFT và nhập text -> Chữ in hoa
        action.keyDown(element, Keys.SHIFT).sendKeys("anh tester").build().perform();

        sleep(2);
    }

    //Cuon len va xuong trang
    @Test
    public void scrollPageDownAndUp() {
        driver.get("https://anhtester.com/");
        Actions action = new Actions(driver);

        sleep(1);
        // Scroll down
        action.keyDown(Keys.END).keyUp(Keys.END).perform();
        sleep(1);
        // Scroll up
        action.keyDown(Keys.HOME).keyUp(Keys.HOME).perform();

        sleep(1);
    }

    //Copy & Paste
    @Test
    public void copyAndPaste(){
        driver.get("https://anhtester.com/blogs");
        sleep(1);

        WebElement inputCourseElement = driver.findElement(By.xpath("//input[contains(@placeholder, 'Tìm kiếm khóa học')]"));
        WebElement inputBlogElement = driver.findElement(By.xpath("//input[contains(@placeholder, 'Tìm kiếm bài viết')]"));

        Actions action = new Actions(driver);

        sleep(1);
        // Nhập text vào ô search course
        inputCourseElement.sendKeys("Selenium");
        sleep(1);
        //Ctrl + a để bôi đen
        action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        sleep(1);
        //Ctrl + c để copy
        action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
        sleep(1);
        //click vào ô Blog search
        inputBlogElement.click();
        sleep(1);
        //Ctrl + v để dán
        action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();

        sleep(1);
    }

    //Lam moi trang
    @Test
    public void reloadPage() {
        driver.get("https://anhtester.com/");
        Actions action = new Actions(driver);

        sleep(1);

        action.keyDown(Keys.CONTROL).sendKeys(Keys.F5).build().perform();
        sleep(1);
    }
}
