package com.pepsico.retail.pages.web;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.pepsico.retail.helpers.VisibilityHelper;
import com.pepsico.retail.pages.BasePage;

@Component
public class ShoppingBillingDetailPage implements BasePage {

    @Autowired
    VisibilityHelper visibilityHelper;

    @FindBy(how = How.XPATH, using = "//input[@id='BillingNewAddress_FirstName']")
    private WebElement firstName;

    @FindBy(how = How.XPATH, using = "//input[@id='BillingNewAddress_LastName']")
    private WebElement lastName;

    @FindBy(how = How.XPATH, using = "//input[@id='BillingNewAddress_Email']")
    private WebElement emailId;

    @FindBy(how = How.XPATH, using = "//input[@id='BillingNewAddress_Company']")
    private WebElement company;

    @FindBy(how = How.XPATH, using = "//input[@id='BillingNewAddress_CountryId']")
    private WebElement countryId;

    @FindBy(how = How.XPATH, using = "//input[@id='BillingNewAddress_StateProvinceId']")
    private WebElement stateId;

    @FindBy(how = How.XPATH, using = "//input[@id='BillingNewAddress_City']")
    private WebElement city;

    @FindBy(how = How.XPATH, using = "//input[@id='BillingNewAddress_Address1']")
    private WebElement address1;

    @FindBy(how = How.XPATH, using = "//input[@id='BillingNewAddress_ZipPostalCode']")
    private WebElement postalCode;

    @FindBy(how = How.XPATH, using = "//input[@id='BillingNewAddress_PhoneNumber']")
    private WebElement phoneNumber;

    @FindBy(how = How.XPATH, using = "//select[@id='BillingNewAddress_CountryId']")
    private WebElement country;

    @FindBy(how = How.XPATH, using = "//ul//li[contains(@id,'Transfer_Points_menu_item')]/div/span")
    private List<WebElement> countryList;

    @FindBy(how = How.XPATH, using = "//select[@id='BillingNewAddress_StateProvinceId']")
    private WebElement state;

    @FindBy(how = How.XPATH, using = "//div[@id='billing-buttons-container']/input")
    private WebElement billingContinueBtn;

    @FindBy(how = How.XPATH, using = "//div[@id='shipping-buttons-container']/input")
    private WebElement shippingContinueBtn;

     @FindBy(how = How.XPATH, using = "//div[@id='shipping-method-buttons-container']/input")
    private WebElement shippingMethodContinueBtn;

    @FindBy(how = How.XPATH, using = "//label[text()='Next Day Air ($10.00)']//preceding-sibling::input")
    private WebElement shippingMethodNxtDay;

    

    public void enter_firstName(String fname) {
        firstName.sendKeys(fname);
    }

    public void enter_lastName(String lname) {
        lastName.sendKeys(lname);
    }

    public void enter_email(String email) {
        emailId.clear();
        emailId.sendKeys(email);
    }

    public void enter_company(String compName) {
        company.sendKeys(compName);
    }

    public void enter_city(String cityName) {
        city.sendKeys(cityName);
    }

    public void enter_address1(String addDetail) {
        address1.sendKeys(addDetail);
    }

    public void enter_postalCode(String postcode) {
        postalCode.sendKeys(postcode);
    }

    public void enter_phoneNumber(String phonenum) {
        phoneNumber.sendKeys(phonenum);
    }

    public void select_country(String contName) {
        Select countryDropdown = new Select(country);
        countryDropdown.selectByVisibleText(contName);
    }

    public void select_state(String stateName) throws InterruptedException {
        Select stateDropdown = new Select(state);
        stateDropdown.selectByVisibleText(stateName);
    }

    public void click_billingContinueBtn() {
        visibilityHelper.waitForElementToVisible(billingContinueBtn);
        billingContinueBtn.click();
    }
    public void click_shippingContinueBtn() {
        visibilityHelper.waitForElementToVisible(shippingContinueBtn);
        shippingContinueBtn.click();
    }

    public void click_shippingMethodContinueBtn() {
        visibilityHelper.waitForElementToVisible(shippingMethodContinueBtn);
        shippingMethodContinueBtn.click();
    }

    public void clickRadio_shippingMethodNxtDay(){
        visibilityHelper.waitForElementToVisible(shippingMethodNxtDay);
        shippingMethodNxtDay.click();
    }

    public void fillBillingDetail(String key, String value){
        switch(key){
            case "first_name":
                firstName.sendKeys(value);
                break;

            case "last_name": 
                lastName.sendKeys(value);
                break;  
            
            case "address1":
                address1.sendKeys(value);
                break; 

            case "country":
                Select countryDropdown = new Select(country);
                countryDropdown.selectByVisibleText(value);
                break;

            case "state": 
                Select stateDropdown = new Select(state);
                stateDropdown.selectByVisibleText(value);
                break;

            case "city": 
                city.sendKeys(value);
                break;

            case "zip": 
                postalCode.sendKeys(value);
                break;

            case "email": 
                emailId.sendKeys(value);
                break;

            case "phone": 
                phoneNumber.sendKeys(value);
                break;

        }

    }

}
