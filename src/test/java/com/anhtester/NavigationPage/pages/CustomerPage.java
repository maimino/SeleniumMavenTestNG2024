package com.anhtester.NavigationPage.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By buttonAddNewCustomer = By.xpath("//a[normalize-space()='New Customer']");
    private By inputSearchCustomer = By.xpath("//div[@id='clients_filter']//input[@type='search']");

    public CustomerPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void clickButtonAddnew() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonAddNewCustomer));
        driver.findElement(buttonAddNewCustomer).click();
    }

    public void searchCustomer(String customerName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonAddNewCustomer));
        driver.findElement(inputSearchCustomer).sendKeys(customerName);
    }

}
