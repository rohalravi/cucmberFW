package com.pepsico.retail.pages.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.Zip;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pepsico.retail.helpers.LibraryHelper;
import com.pepsico.retail.helpers.VisibilityHelper;
import com.pepsico.retail.pages.BasePage;
import org.junit.Assert;

@Component
public class CentricPaymentInfo implements BasePage {

    @Autowired
    private VisibilityHelper visibilityHelper;

    @Autowired
    private LibraryHelper libraryHelper;

    @FindBy(how = How.XPATH, using = "//*[@class= \"page-title\"]/h1")
    private WebElement paymentTitle;

    @FindBy(how = How.XPATH, using = "//input[@id='CardholderName']")
    private WebElement Name;

    @FindBy(how = How.XPATH, using = "//input[@id='CardNumber']")
    private WebElement CardNumber;

    @FindBy(how = How.XPATH, using = "//select[@id='ExpireMonth']")
    private WebElement CardMonth;

    @FindBy(how = How.XPATH, using = "//select[@id='ExpireYear']")
    private WebElement CardYear;

    @FindBy(how = How.XPATH, using = "//input[@id='CardCode']")
    private WebElement CardCVC;

    @FindBy(how = How.XPATH, using = "//*[@class = \"button-1 payment-info-next-step-button\"]")
    private WebElement PaymentContinue;

    @FindBy(how = How.XPATH, using = "//*[@class = \"product-name\"]")
    private WebElement productText;

    @FindBy(how = How.XPATH, using = "//*[@class = \"button-1 confirm-order-next-step-button\"]")
    private WebElement confirm;

    @FindBy(how = How.XPATH, using = "//*[@class = \"order-subtotal\"]//following-sibling::tr[3]//child::td[2]/span/strong")
    private WebElement price;

    @FindBy(how = How.XPATH, using = "//*[@class = \"section order-completed\"]/div/strong")
    private WebElement orderConfirmation;

    public boolean verifyPaymentScreenText() {
        visibilityHelper.waitForVisibilityOf(paymentTitle);
        return paymentTitle.isDisplayed();
    }

    public void enterPaymentDetails(String cc_name, String cc_number, String cc_month, String cc_year, String cc_cvc)
            throws InterruptedException {
        Name.sendKeys(cc_name);
        CardNumber.sendKeys(cc_number);
        libraryHelper.select(CardMonth, 3);
        libraryHelper.select(CardYear, 1);
        CardCVC.sendKeys(cc_cvc);
        PaymentContinue.click();
        visibilityHelper.waitForVisibilityOf(productText);
        libraryHelper.scrollIntoView(productText);
    }

    public void cardDetails(String field, String value) throws InterruptedException {
        switch (field) {
            case "cc_name":
                Name.sendKeys(value);
                break;

            case "cc_number":
                CardNumber.sendKeys(value);
                break;

            case "cc_month":
                visibilityHelper.waitForElementToBeClickable(CardMonth);
                libraryHelper.select(CardYear, 3);
                break;

            case "cc_year":
                visibilityHelper.waitForElementToBeClickable(CardYear);
                libraryHelper.select(CardYear, 1);
                break;

            case "cc_cvc":
                CardCVC.sendKeys(value);
                PaymentContinue.click();
                visibilityHelper.waitForVisibilityOf(productText);
                libraryHelper.scrollIntoView(productText);
                break;

        }
    }

    public void confirmPriceDetails(String Price) {
        if (Price.equalsIgnoreCase("$100.00\t")) {
            Assert.assertEquals(price.getText(), Price);
        } else {
            Assert.assertEquals(price.getText(), Price);
        }
        confirm.click();
    }

    public boolean orderConfirm() {
        visibilityHelper.waitForVisibilityOf(orderConfirmation);
        return orderConfirmation.isDisplayed();
    }
}
