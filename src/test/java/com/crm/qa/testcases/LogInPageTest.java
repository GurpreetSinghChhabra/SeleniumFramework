package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LogInPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sun.rmi.runtime.Log;

public class LogInPageTest extends TestBase {

    static String HOME_PAGE_TITLE="Free CRM - CRM software for customer relationship management, sales, and support.";
    LogInPage logInPage;

    public LogInPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialize();
        logInPage = new LogInPage();
    }

    @Test
    public void verifyLogInPageTitle(){
        String logInPageTitle = logInPage.validateLogInPageTitle();
        Assert.assertEquals(logInPageTitle,HOME_PAGE_TITLE);
    }

    @Test
    public void verifyCRMLogoOnLogInPage(){
        boolean logoDisplayed= logInPage.validateCRMLogo();
        Assert.assertTrue(logoDisplayed);
    }

    @Test
    public void verifyLogIn(){
        HomePage homePage = logInPage.login(prop.getProperty("username"), prop.getProperty("password"));
        Assert.assertEquals(homePage.verifyHomPageTitle(),"CRMPRO");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
