package com.pepsico.retail.pages.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pepsico.retail.helpers.LibraryHelper;
import com.pepsico.retail.helpers.VisibilityHelper;
import com.pepsico.retail.pages.BasePage;

@Component
public class CentricBillingPage implements BasePage {

  @Autowired
  private VisibilityHelper visibilityHelper;

  @Autowired
  private LibraryHelper libraryHelper;

  @FindBy(how = How.XPATH, using = "//input[@id='BillingNewAddress_FirstName']")
  private WebElement firstName;

  @FindBy(how = How.XPATH, using = "//input[@id='BillingNewAddress_LastName']")
  private WebElement lastName;

  @FindBy(how = How.XPATH, using = "//input[@id='BillingNewAddress_Email']")
  private WebElement Email;

  @FindBy(how = How.XPATH, using = "//input[@id='BillingNewAddress_Company']")
  private WebElement Company;

  @FindBy(how = How.XPATH, using = "//select[@id='BillingNewAddress_CountryId']")
  private WebElement Country;

  @FindBy(how = How.XPATH, using = "//select[@id='BillingNewAddress_StateProvinceId']")
  private WebElement State;

  @FindBy(how = How.XPATH, using = "//input[@id='BillingNewAddress_City']")
  private WebElement City;

  @FindBy(how = How.XPATH, using = "//input[@id='BillingNewAddress_Address1']")
  private WebElement Address1;

  @FindBy(how = How.XPATH, using = "//input[@id='BillingNewAddress_ZipPostalCode']")
  private WebElement Zip;

  @FindBy(how = How.XPATH, using = "//input[@id='BillingNewAddress_PhoneNumber']")
  private WebElement Phone;

  @FindBy(how = How.XPATH, using = "//*[@class = \"page-title\"]/h1")
  private WebElement checkoutHeader;

  @FindBy(how = How.XPATH, using = "//*[@id = \"billing-buttons-container\"]/input")
  private WebElement continueButton;

  @FindBy(how = How.XPATH, using = "//*[@class = \"page-title\"]/h1")
  private WebElement continueHeader;

  @FindBy(how = How.XPATH, using = "//*[@id = \"shipping-buttons-container\"]/input")
  private WebElement checkoutContinueButton;

  @FindBy(how = How.XPATH, using = "//*[@id = \"PickUpInStore\"]")
  private WebElement storePickup;

  @FindBy(how = How.XPATH, using = "//*[@id = \"shipping-method-buttons-container\"]/input")
  private WebElement checkoutButton;

  public void enterBillingDetails(String firstname, String last_name, String email, String country, String state,
      String city, String address1, String zip, String phone) throws InterruptedException {
    visibilityHelper.waitForElementToVisible(firstName);
    firstName.sendKeys(firstname);
    lastName.sendKeys(last_name);
    Email.sendKeys(email);
    libraryHelper.scrollIntoView(Company);
    visibilityHelper.waitForElementToBeClickable(Country);
    libraryHelper.select(Country, 1);
    visibilityHelper.waitForSeconds();
    libraryHelper.select(State, 44);
    City.sendKeys(city);
    Address1.sendKeys(address1);
    Zip.sendKeys(zip);
    Phone.sendKeys(phone);
    continueButton.click();
    visibilityHelper.waitForElementToVisible(storePickup);
    libraryHelper.scrollIntoView(storePickup);
    checkoutContinueButton.click();
    visibilityHelper.waitForElementToBeClickable(checkoutButton);
    checkoutButton.click();
    visibilityHelper.waitForSeconds();

  }

  public void userDetails(String field, String value) throws InterruptedException {
    switch (field) {
      case "first_name":
        firstName.sendKeys(value);
        break;

      case "last_name":
        lastName.sendKeys(value);
        break;

      case "email":
        Email.sendKeys(value);
        break;

      case "country":
        visibilityHelper.waitForElementToBeClickable(Country);
        libraryHelper.select(Country, 1);
        break;

      case "state":
        visibilityHelper.waitForElementToBeClickable(State);
        visibilityHelper.waitForSeconds();
        libraryHelper.select(State, 44);
        break;

      case "city":
        City.sendKeys(value);
        break;

      case "address1":
        Address1.sendKeys(value);
        break;

      case "zip":
        Zip.sendKeys(value);
        break;

      case "phone":
        Phone.sendKeys(value);
        continueButton.click();
        visibilityHelper.waitForElementToVisible(storePickup);
        libraryHelper.scrollIntoView(storePickup);
        checkoutContinueButton.click();
        visibilityHelper.waitForElementToBeClickable(checkoutButton);
        checkoutButton.click();
        visibilityHelper.waitForSeconds();
        break;

    }
  }

  public boolean verifyCheckoutText() {
    visibilityHelper.waitForVisibilityOf(checkoutHeader);
    return checkoutHeader.isDisplayed();
  }
}
