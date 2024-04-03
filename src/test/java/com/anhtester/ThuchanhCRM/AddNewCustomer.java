package com.anhtester.ThuchanhCRM;

import com.anhtester.common.BaseTest;
import com.anhtester.locators.LocatorCRM;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddNewCustomer extends BaseTest {

    public void loginCRM(){
        driver.get(InfoCRM.URL);
        waitForPageLoaded();
        Assert.assertTrue(checkElementExist(LocatorCRM.headerLoginPage),"Khong phai trang login");
        setText(LocatorCRM.inputEmail, InfoCRM.EMAIL);
        setText(LocatorCRM.inputPassword, InfoCRM.PASSWORD);
        clickElement(LocatorCRM.buttonLogin);
        waitForPageLoaded();

        Assert.assertTrue(checkElementExist(LocatorCRM.menuDashboard), "Khong den duoc trang dashboard");
    }

    //CUSTOMERS
    String COMPANY_NAME = "Cty TNHH 3 thanh vien";
    String VAT_NUMBER = "333";
    String PHONE_CUSTOMER = "094326547";
    String WEBSITE_NAME = "https://ctytnhh3tv.com";
    String SEARCH_GROUP = "VIP";
    String CURRENCY_TYPE = "USD";
    String ADDRESS_NAME = "TT Trau Quy - Gia Lam";
    String CITY_NAME = "Ha Noi";
    String STATE_NAME = "ABC";
    String ZIP_CODE = "1001";
    String COUNTRY_NAME = "Vietnam";


    @Test
    public void testAddNewCustomer(){
        loginCRM();

        clickElement(LocatorCRM.menuCustomers);
        waitForPageLoaded();
        Assert.assertTrue(checkElementExist(LocatorCRM.headerCustomersPage), "Khong phai trang Customer");
        Assert.assertEquals(getTextElement(LocatorCRM.headerCustomersPage),"Customers Summary", "Tieu de trang Customer khong dung");
        waitForPageLoaded();

        //Tao moi customer
        clickElement(LocatorCRM.buttonAddNewCustomer);
        setText(LocatorCRM.inputCompanyName, COMPANY_NAME);
        setText(LocatorCRM.inputVatNumber, VAT_NUMBER);
        setText(LocatorCRM.inputPhone, PHONE_CUSTOMER);
        setText(LocatorCRM.inputWebsite, WEBSITE_NAME);
        clickElement(LocatorCRM.dropdownGroups);
        waitForPageLoaded();
        setText(LocatorCRM.inputSearchGroup, SEARCH_GROUP);
        waitForPageLoaded();
        enterElement(LocatorCRM.inputSearchGroup);
        clickElement(LocatorCRM.dropdownGroups);
        clickElement(LocatorCRM.dropdownCurrency);
        waitForPageLoaded();
        setText(LocatorCRM.inputSearchCurrency, CURRENCY_TYPE);
        waitForPageLoaded();
        enterElement(LocatorCRM.inputSearchCurrency);
        clickElement(LocatorCRM.dropdownLanguage);
        waitForPageLoaded();
        clickElement(LocatorCRM.optionVietnamese);
        waitForPageLoaded();
        setText(LocatorCRM.inputAddress, ADDRESS_NAME);
        setText(LocatorCRM.inputCity, CITY_NAME);
        setText(LocatorCRM.inputState, STATE_NAME);
        setText(LocatorCRM.inptZipCode, ZIP_CODE);
        clickElement(LocatorCRM.dropdownCountry);
        waitForPageLoaded();
        setText(LocatorCRM.inputSearchCountry, COUNTRY_NAME);
        waitForPageLoaded();
        enterElement(LocatorCRM.inputSearchCountry);
        clickElement(LocatorCRM.buttonSaveCustomer);
        waitForPageLoaded();

        //Kiem tra customer vua tao moi
        clickElement(LocatorCRM.menuCustomers);
        clickElement(LocatorCRM.inputSearchCustomers);
        setText(LocatorCRM.inputSearchCustomers, COMPANY_NAME);
        sleep(3);
        Assert.assertTrue(checkElementExist(LocatorCRM.firstItemCustomerOnTable), "Khong tim thay customer vua tao");

        //Kiem tra gia tri sau khi tao moi
        clickElement(LocatorCRM.firstItemCustomerOnTable);
        waitForPageLoaded();
        Assert.assertEquals(getAttributeElement(LocatorCRM.inputCompanyName, "value"), COMPANY_NAME, "Company khong dung");
        Assert.assertEquals(getAttributeElement(LocatorCRM.inputVatNumber, "value"), VAT_NUMBER, "VAT number khong dung");
        Assert.assertEquals(getAttributeElement(LocatorCRM.inputPhone, "value"), PHONE_CUSTOMER, "Phone khong dung");
        Assert.assertEquals(getAttributeElement(LocatorCRM.inputWebsite, "value"), WEBSITE_NAME, "Website khong dung");
        Assert.assertEquals(getTextElement(LocatorCRM.dropdownGroups) , SEARCH_GROUP, "Groups khong dung");
        Assert.assertEquals(getTextElement(LocatorCRM.dropdownCurrency), CURRENCY_TYPE, "Currency khong dung");
        Assert.assertEquals(getTextElement(LocatorCRM.dropdownLanguage), "Vietnamese", "Default language khong dung");
        Assert.assertEquals(getAttributeElement(LocatorCRM.inputAddress, "value"), ADDRESS_NAME, "Address khong dung");
        Assert.assertEquals(getAttributeElement(LocatorCRM.inputCity   , "value"), CITY_NAME, "City khong dung");
        Assert.assertEquals(getAttributeElement(LocatorCRM.inptZipCode, "value"), ZIP_CODE, "Zip code khong dung");
        Assert.assertEquals(getTextElement(LocatorCRM.dropdownCountry), COUNTRY_NAME, "Country khong dung");
    }

    //CONTACT
    String FIRST_NAME = "Tran";
    String LAST_NAME = "Anh Nguyet";
    String POSITION = "Ha Noi";
    String EMAIL_CONTACT = "anhnguyettran@gmail.com";
    String PHONE_CONTACT = "984773645";
    String PASSWORD_CONTACT = "112233";

    @Test
    public void testAddNewContact() {
        loginCRM();

        clickElement(LocatorCRM.menuCustomers);
        Assert.assertTrue(checkElementExist(LocatorCRM.headerCustomersPage), "Khong den duoc trang Customer");
        Assert.assertEquals(getTextElement(LocatorCRM.headerCustomersPage), "Customers Summary", "Tieu de trang customer khong dung");
        waitForPageLoaded();

        //Tim kiem customer vua tao moi
        clickElement(LocatorCRM.inputSearchCustomers);
        setText(LocatorCRM.inputSearchCustomers, COMPANY_NAME);
        sleep(3);
        Assert.assertTrue(checkElementExist(LocatorCRM.firstItemCustomerOnTable), "Khong tim thay customer vua tao");
        clickElement(LocatorCRM.firstItemCustomerOnTable);

        //Tao moi contact cho customer vua tao
        waitForPageLoaded();
        clickElement(LocatorCRM.menuContacts);
        Assert.assertTrue(checkElementExist(LocatorCRM.headerContactPage), "Khong tim thay trang contact");
        clickElement(LocatorCRM.buttonAddNewContact);
        sleep(3);
        Assert.assertTrue(checkElementExist(LocatorCRM.headerAddNewContactDialog), "Khong tim thay popup tao moi contact");
        setText(LocatorCRM.inputProfileImage, System.getProperty("user.dir") + "\\src\\test\\java\\resource\\datatest\\chimmy.jpg");
        waitForPageLoaded();
        setText(LocatorCRM.inputFirstName, FIRST_NAME);
        setText(LocatorCRM.inputLastName, LAST_NAME);
        setText(LocatorCRM.inputPosition, POSITION);
        setText(LocatorCRM.inputEmailContact, EMAIL_CONTACT);
        setText(LocatorCRM.inputPhoneContact, PHONE_CONTACT);
        clickElement(LocatorCRM.dropdownDirection);
        waitForPageLoaded();
        clickElement(LocatorCRM.optionLTR);
        setText(LocatorCRM.inputPasswordContact, PASSWORD_CONTACT);
        //clickElement(LocatorCRM.checkboxDoNotSendEmail);
        clickElement(LocatorCRM.buttonSaveContact);

        //Tim kiem contact vua tao
        clickElement(LocatorCRM.inputSearchContact);
        setText(LocatorCRM.inputSearchContact, FIRST_NAME + LAST_NAME);
        waitForPageLoaded();
        Assert.assertTrue(checkElementExist(LocatorCRM.firstItemContactOnTable), "Khong tim thay contact vua tao");

        //Kiem tra gia tri sau khi tao moi contact
        waitForPageLoaded();
        clickElement(LocatorCRM.firstItemContactOnTable);
        waitForPageLoaded();
        Assert.assertEquals(getAttributeElement(LocatorCRM.inputFirstName, "value"), FIRST_NAME,"First name khong dung");
        Assert.assertEquals(getAttributeElement(LocatorCRM.inputLastName, "value"), LAST_NAME, "Last name khong dung");
        Assert.assertEquals(getAttributeElement(LocatorCRM.inputPosition, "value"), POSITION, "Position khong dung");
        Assert.assertEquals(getAttributeElement(LocatorCRM.inputEmailContact, "value"), EMAIL_CONTACT, "Email contact khong dung");
        Assert.assertEquals(getAttributeElement(LocatorCRM.inputPhoneContact, "value"), "+84" + PHONE_CONTACT, "Phone contact khong dung");
        Assert.assertEquals(getTextElement(LocatorCRM.dropdownDirection), "LTR" ,"Direction khong dung");
    }

    //PROJECT
    String PROJECT_NAME = "Demo Project";
    String TOTAL_RATE = "9";
    String ESTIMATED_HOURS = "5";
    String START_DATE = "26-03-2024";
    String DEADLINE = "26-04-2024";
    String TAGS = "demoproject";
    String DESCRIPTION = "abcdefgh";

//    @Test
//    public void testAddNewProject(){
//        loginCRM();
//
//        clickElement(LocatorCRM.menuProjects);
//        waitForPageLoaded();
//        Assert.assertTrue(checkElementExist(LocatorCRM.headerProjectsPage), "Khong den duoc trang Projects");
//        Assert.assertEquals(getTextElement(LocatorCRM.headerProjectsPage), "Projects Summary","Tieu de trang Projects khong  dung");
//
//        //Tao project
//        clickElement(LocatorCRM.buttonAddNewProject);
//        waitForPageLoaded();
//        Assert.assertTrue(checkElementExist(LocatorCRM.headerAddNewProjectPage), "Khong phai trang tao moi project");
//        setText(LocatorCRM.inputProjectName, PROJECT_NAME);
//        clickElement(LocatorCRM.dropdownCustomer);
//        setText(LocatorCRM.inputSearchCustomer, COMPANY_NAME);
//        waitForPageLoaded();
//        clickElement(LocatorCRM.resultSearchCustomer);
//        clickElement(LocatorCRM.dropdownBillingType);
//        waitForPageLoaded();
//        clickElement(LocatorCRM.optionBillingType);
//        waitForPageLoaded();
//        setText(LocatorCRM.inputTotalRate, TOTAL_RATE);
//        clickElement(LocatorCRM.dropdownStatus);
//        waitForPageLoaded();
//        clickElement(LocatorCRM.optionStatus);
//        setText(LocatorCRM.inputEstimatedHours, ESTIMATED_HOURS);
//        setText(LocatorCRM.inputStartdate, START_DATE);
//        setText(LocatorCRM.inputDeadline, DEADLINE);
//        setText(LocatorCRM.inputTags, TAGS);
//        setText(LocatorCRM.inputDesciption, DESCRIPTION);
//        clickElement(LocatorCRM.checkboxSendProject);
//    }
}
