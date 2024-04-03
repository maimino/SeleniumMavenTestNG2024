package com.anhtester.PageObjectModel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class DashboardPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    private By menuCustomers = By.xpath("//span[normalize-space()='Customers']");
    private By menuProjects = By.xpath("//span[normalize-space()='Projects']");
    private By menuTasks = By.xpath("//span[normalize-space()='Tasks']");
    private By dashboardOptions = By.xpath("//div[@class='screen-options-btn']");
    private By buttonAvatar = By.xpath("//li[@class='icon header-user-profile']/a");
    private By buttonLogout = By.xpath("//ul[@class='dropdown-menu animated fadeIn']//li[@class='header-logout']//a[@href='#'][normalize-space()='Logout']");

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void verifyDashboard(){
        Assert.assertTrue(driver.findElement(menuDashboard).isDisplayed(), "Khong den duoc trang Dashboard");
        Assert.assertTrue(driver.findElement(menuCustomers).isDisplayed(), "Trang Dashboard thieu menu Customers ");
        Assert.assertTrue(driver.findElement(menuProjects).isDisplayed(), "Trang Dashboard thieu menu Projects");
        Assert.assertTrue(driver.findElement(menuTasks).isDisplayed(), "Trang Dashboard thieu menu Tasks");
        Assert.assertTrue(driver.findElement(dashboardOptions).isDisplayed(), "Trang Dashboard thieu truong Dashboard Options");
    }

    public void clickDashboardOptions(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardOptions));
        driver.findElement(dashboardOptions).click();
    }

    public void clickAvatar(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonAvatar));
        driver.findElement(buttonAvatar).click();
    }

    public void clickLogoutButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonLogout));
        driver.findElement(buttonLogout).click();
    }

    public void verifyLogoutSuccess(){
        Assert.assertTrue(driver.getCurrentUrl().contains("authentication"), "Logout thanh cong");
    }

    public void verifyLogoutFail(){
        Assert.assertFalse(driver.getCurrentUrl().contains("authentication"), "Logout that bai");
        Assert.assertTrue(driver.findElement(menuDashboard).isDisplayed(), "Logout that bai. Van dang o trang Dashboard");
    }

    public void logoutCRM(){
        clickAvatar();
        clickLogoutButton();
    }
}