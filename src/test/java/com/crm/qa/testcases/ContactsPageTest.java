package com.crm.qa.testcases;


import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LogInPage;
import com.crm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactsPageTest extends TestBase {

    LogInPage logInPage;
    HomePage homePage;
    ContactsPage contactsPage;
    TestUtil testUtil;
    static String sheetName="contacts";

    public ContactsPageTest(){super();}

    @BeforeMethod
    public void setUp(){
        initialize();
        testUtil = new TestUtil();
        logInPage = new LogInPage();
        homePage = logInPage.login(prop.getProperty("username"),prop.getProperty("password"));
        testUtil.switchToFrame("mainpanel");
        contactsPage = homePage.clickContactsLink();
    }

    @Test
    public void verifyContactsPageDisplayed(){
        boolean contactsPageDisplayed = contactsPage.verifyContactsLabel();
        Assert.assertTrue(contactsPageDisplayed,"Contacts page is not displayed");
    }

    @Test //(retryAnalyzer = com.crm.qa.util.RetryAnalyzer.class)
    public void selectContact(){
        Assert.assertTrue(contactsPage.selectContact("Apple Malvia"),"Contact is not selected");
    }

    @DataProvider
    public Object[][] getCRMTestData(){
        Object data [][] = TestUtil.getTestData(sheetName);
        return data;
    }

    @Test (dataProvider = "getCRMTestData")
    public void openNewContactPage(String title, String firstName,String lastName, String companyName){
        homePage.clickNewContactLink();
        //contactsPage.createNewContact("Mr.", "Tom" , "Hood", "facebook");
        contactsPage.createNewContact(title,firstName,lastName, companyName);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
