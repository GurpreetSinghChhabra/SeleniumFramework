package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends TestBase {

    //Page Factory - Object Repository
    @FindBy(xpath="//div[text()='Login']")
    @CacheLookup
    WebElement LogInBtn;

    @FindBy(name="email")
    @CacheLookup
    WebElement username;

    @FindBy(name="password")
    @CacheLookup
    WebElement password;

    @FindBy(xpath ="//a[text()='Classic CRM']")
    WebElement linkClassicFreeCRM;

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

    public boolean isUserNameFieldPresent(){
        return username.isDisplayed();
    }

    public boolean isPasswordFieldPresent(){
        return password.isDisplayed();
    }

    public boolean verifyClassicCRMLinkPresent(){
        return linkClassicFreeCRM.isDisplayed();
    }

    public String getLogInPageUrl(){
        return driver.getCurrentUrl();
    }


}
