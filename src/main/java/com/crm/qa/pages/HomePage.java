package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends TestBase {

    @FindBy(xpath="//td[contains(text(),'User: group automation ')]")
    WebElement userNameLabel;

    @FindBy(xpath="//a[contains(text(),'Contacts')]")
    //@CacheLookup
    WebElement contactsLink;

    @FindBy(xpath="//a[contains(text(),'New Contact')]")
    WebElement newContactLink;

    @FindBy(xpath="//a[contains(text(),'Deals')]")
    WebElement dealsLink;

    @FindBy(xpath="//a[contains(text(),'Tasks')]")
    WebElement taskLink;

    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    public String verifyHomPageTitle(){
        return driver.getTitle();
    }

    public boolean verifyUserName(){
        return userNameLabel.isDisplayed();
    }

    public ContactsPage clickContactsLink(){
        contactsLink.click();
        return new ContactsPage();
    }

    public DealsPage clickDealsLink(){
        dealsLink.click();
        return new DealsPage();
    }

    public TasksPage clickTasksLink(){
        taskLink.click();
        return new TasksPage();
    }

    public void clickNewContactLink(){
        //action.moveToElement(contactsLabel).build().perform();
        //action.moveToElement(contactsLabel).moveToElement(newContactLink).click().build().perform();
        //Point point = contactsLink.getLocation();

        wait.until(ExpectedConditions.visibilityOf(userNameLabel));
        userNameLabel.click();
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'New Contact')]")));
        Actions action = new Actions(driver);
        //wait.until(ExpectedConditions.elementToBeClickable(contactsLink));
        //action.moveToElement(contactsLink,point.getX(),point.getY()).build().perform();
        action.moveToElement(contactsLink).build().perform();
        newContactLink.click();
    }

}
