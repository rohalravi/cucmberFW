package com.pepsico.retail.pages.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pepsico.retail.helpers.VisibilityHelper;
import com.pepsico.retail.pages.BasePage;

@Component
public class ShoppingPaymentDetailPage implements BasePage{
    
    @Autowired
    VisibilityHelper visibilityHelper;

    @FindBy(how = How.XPATH, using = "//select[@id='CreditCardType']")
    private WebElement selectCreditCard;

    @FindBy(how = How.XPATH, using = "//input[@id='CardholderName']")
    private WebElement cardHolderName;

    @FindBy(how = How.XPATH, using = "//input[@id='CardNumber']")
    private WebElement cardNumber;

    @FindBy(how = How.XPATH, using = "//select[@id='ExpireMonth']")
    private WebElement expireMonth;

    @FindBy(how = How.XPATH, using = "//select[@id='ExpireYear']")
    private WebElement expireYear;

    @FindBy(how = How.XPATH, using = "//input[@id='CardCode']")
    private WebElement cardCode;

    @FindBy(how = How.XPATH, using = "//div[@id='payment-info-buttons-container']/input")
    private WebElement paymentInfoContinueBtn;

    public void enter_cardholder_name(String cardHolder_name){
        cardHolderName.sendKeys(cardHolder_name);
    }

    public void enter_cardnumber(String card_number){
        cardNumber.sendKeys(card_number);
    }

    public void enter_cardcode(String card_cord){
        cardCode.sendKeys(card_cord);
    }

    public void select_card_type(String card_type){
        visibilityHelper.waitForVisibilityOf(selectCreditCard);
        Select creditTypeDD = new Select(selectCreditCard);
        creditTypeDD.selectByVisibleText(card_type);
       
    }

    public void select_expire_month(String month){
        Select monthDD = new Select(expireMonth);
        monthDD.selectByVisibleText(month);
    }

    public void select_expire_year(String year){
        Select yearDD = new Select(expireYear);
        yearDD.selectByVisibleText(year);
    }

    public void click_paymentInfoContinueBtn(){
        paymentInfoContinueBtn.click();
    }

}
