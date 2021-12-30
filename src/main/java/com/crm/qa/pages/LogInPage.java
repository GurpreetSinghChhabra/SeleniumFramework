package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends TestBase {

    //Page Factory - Object Repository
    @FindBy(xpath="//input[@type='submit']")
    @CacheLookup
    WebElement LogInBtn;

    @FindBy(name="username")
    @CacheLookup
    WebElement username;

    @FindBy(name="password")
    @CacheLookup
    WebElement password;

    @FindBy(xpath ="//img[@class='img-responsive']")
    WebElement crmLogo;

    public LogInPage(){
        PageFactory.initElements(driver,this);
    }

    public HomePage login(String uname, String pswd){
        username.sendKeys(uname);
        password.sendKeys(pswd);
        LogInBtn.click();
        return new HomePage();
    }

    public String validateLogInPageTitle(){
        return driver.getTitle();
    }

    public boolean validateCRMLogo(){

        boolean isDisplayed = crmLogo.isDisplayed();
        return isDisplayed;

    }


}
