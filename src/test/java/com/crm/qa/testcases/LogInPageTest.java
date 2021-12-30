package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LogInPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInPageTest extends TestBase {

    static String HOME_PAGE_TITLE="Free CRM - CRM software for customer relationship management, sales, and support.";
    static String LOGIN_PAGE_URL="https://ui.cogmento.com/";
    LogInPage logInPage;

    public LogInPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialize();
        logInPage = new LogInPage();
    }

    @Test(priority=1)
    public void verifyLogInPageUrl(){
        String logInPageUrl = logInPage.getLogInPageUrl();
        Assert.assertEquals(logInPageUrl,LOGIN_PAGE_URL);
    }

/*    @Test
    public void verifyCRMLogoOnLogInPage(){
        boolean logoDisplayed= logInPage.validateCRMLogo();
        Assert.assertTrue(logoDisplayed);
    }*/

    @Test(priority=2)
    public void verifyFieldsOnLogInPage(){
        Assert.assertTrue(logInPage.isUserNameFieldPresent(),"Verify User Name field");
        Assert.assertTrue(logInPage.isPasswordFieldPresent(),"Verify Password field");
    }

    @Test(priority=3)
    public void verifyLogIn(){
        HomePage homePage = logInPage.login(prop.getProperty("username"), prop.getProperty("password"));
        //Assert.assertEquals(homePage.verifyHomPageTitle(),"CRMPRO");
        Assert.assertTrue(homePage.verifyTopHeader(),"Top Header Displayed after log in");
    }

    @Test(priority=4)
    public void verifyClassCRMLinkPresent(){
        Assert.assertTrue(logInPage.verifyClassicCRMLinkPresent() ,"Verify presence of Classic CRM Link");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
