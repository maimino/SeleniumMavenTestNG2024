package com.anhtester.ThuchanhPOM.pages;

import com.anhtester.constants.ConfigData;
import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {
    //Khai bao driver cuc bo trong chinh class nay
    private WebDriver driver;
    private WebDriverWait wait;

    //Khai bao cac element dang doi tuong By(phuong thuc tim kiem)
    private By headerPage = By.xpath("//h1[normalize-space()='Login']");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@name='password']");
    private By buttonLogin = By.xpath("//button[@type='submit']");
    private By errorMessage = By.xpath("//div[@id='alerts']");

    //Khai bao ham xay dung de truyen driver tu ben ngoai vao chinh class nay su dung
    public LoginPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        new WebUI(driver); //bat buoc
    }
    private void setEmail(String email){
        //driver.findElement(inputEmail).sendKeys(email);
        //WebUI.getWebElement(inputEmail).sendKeys(email);
        WebUI.setText(inputEmail, email);
    }

    private void setPassword(String password){
        WebUI.setText(inputPassword,password);
    }

    private void clickLoginButton(){
        WebUI.clickElement(buttonLogin);
    }

    public void verifyLoginSuccess(){
        Assert.assertFalse(driver.getCurrentUrl().contains("authentication"), "Van dang o trang login");
    }

    public void verifyLoginFail(){
        Assert.assertTrue(driver.getCurrentUrl().contains("authentication"), "Khong con o trang login");
        Assert.assertTrue(WebUI.checkElementExist(errorMessage), "Error message not displayed");
        Assert.assertEquals(WebUI.getTextElement(errorMessage), "Invalid email or password", "Noi dung error message khong dung");
    }

    //Cac ham xu ly cho chinh trang nay
    public DashboardPage loginCRM(String email, String password){
        WebUI.openURL(ConfigData.URL);
        WebUI.waitForPageLoaded();
        setEmail(email);
        setPassword(password);
        clickLoginButton();

        return new DashboardPage(driver); //tao lien ket giua cac trang
    }
}
