package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LogInPage;
import com.crm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    LogInPage logInPAge;
    HomePage homePage;
    TestUtil testUtil;

    public HomePageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialize();
        logInPAge = new LogInPage();
        testUtil = new TestUtil();
        homePage = logInPAge.login(prop.getProperty("username"),prop.getProperty("password"));
    }

    @Test
    public void verifyHomePageTitle(){
        Assert.assertEquals(homePage.verifyHomPageTitle(),"CRMPRO");
    }

    @Test
    public void verifyCorrectUserName(){
        testUtil.switchToFrame("mainpanel");
        Assert.assertTrue(homePage.verifyUserName(),"Incorrect User Name displayed");
    }

    @Test
    public void VerifyContactsLinkTest(){
        testUtil.switchToFrame("mainpanel");
        homePage.clickContactsLink();
    }

    @AfterMethod
    public void teadDown(){
        driver.quit();
    }

}
