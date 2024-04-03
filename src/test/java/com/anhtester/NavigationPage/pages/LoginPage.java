package com.anhtester.NavigationPage.pages;

import com.anhtester.constants.ConfigData;
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
    }
    private void setEmail(String email){
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputEmail));
        driver.findElement(inputEmail).sendKeys(email);
    }

    private void setPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputPassword));
        driver.findElement(inputPassword).sendKeys(password);
    }

    private void clickLoginButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonLogin));
        driver.findElement(buttonLogin).click();
    }

    public void verifyLoginSuccess(){
        Assert.assertFalse(driver.getCurrentUrl().contains("authentication"), "Van dang o trang login");
    }

    public void verifyLoginFail(){
        Assert.assertTrue(driver.getCurrentUrl().contains("authentication"), "Khong con o trang login");
        Assert.assertTrue(driver.findElement(errorMessage).isDisplayed(), "Error message not displayed");
        Assert.assertEquals(driver.findElement(errorMessage).getText(), "Invalid email or password", "Noi dung error message khong dung");
    }

    //Cac ham xu ly cho chinh trang nay
    public DashboardPage loginCRM(String email, String password){
        driver.get(ConfigData.URL);
        setEmail(email);
        setPassword(password);
        clickLoginButton();

        return new DashboardPage(driver); //tao lien ket giua cac trang
    }
}
