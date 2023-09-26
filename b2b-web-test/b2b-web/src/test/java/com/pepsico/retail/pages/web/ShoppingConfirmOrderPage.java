package com.pepsico.retail.pages.web;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pepsico.retail.helpers.VisibilityHelper;
import com.pepsico.retail.pages.BasePage;

@Component
public class ShoppingConfirmOrderPage implements BasePage{
    
    @Autowired
    VisibilityHelper visibilityHelper;

    @FindBy(how = How.XPATH, using = "//tr[@class='order-total']//span[@class='value-summary']")
    private WebElement totalOrderValue;

    @FindBy(how = How.XPATH, using = "//div[@id='confirm-order-buttons-container']/input")
    private WebElement confirmOrderContinueBtn;

    public void validate_orderPrice(String expVal){
        visibilityHelper.waitForVisibilityOf(totalOrderValue);
        String actVal = totalOrderValue.getText().toString();
        Assert.assertEquals("Price doesnot match", expVal,actVal );
    }

    public void click_confirmOrderContinueBtn(){
        confirmOrderContinueBtn.click();
    }

}
