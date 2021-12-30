package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactsPage extends TestBase {

    @FindBy(xpath="//td[contains(text(),'Contacts')]")
    WebElement contactsLabel;

    @FindBy(name="title")
    WebElement title;

    @FindBy(id="first_name")
    WebElement firstName;

    @FindBy(id="surname")
    WebElement surname;

    @FindBy(name="client_lookup")
    WebElement company;

    @FindBy(xpath="//input[@type='submit' and name='Save']")
    WebElement saveButton;

    public ContactsPage(){
        PageFactory.initElements(driver,this);}

    public boolean verifyContactsLabel(){
        return contactsLabel.isDisplayed();
    }

    public boolean selectContact(String contactName){
        WebElement contactCheckBox = driver.findElement(By.xpath("//a[text()='"+contactName+"']/parent::td[@class='datalistrow']/preceding-sibling::td[@class='datalistrow']/input[@name='contact_id']"));
        contactCheckBox.click();
        return contactCheckBox.isSelected();
    }

    public void createNewContact(String titleVal, String fName, String lName, String companyName){

        Select titleCheckBox = new Select(title);
        titleCheckBox.selectByVisibleText(titleVal);
        firstName.sendKeys(fName);
        surname.sendKeys(lName);
        company.sendKeys(companyName);
        //saveButton.click();
    }




}
