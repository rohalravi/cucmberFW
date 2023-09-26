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
public class CentricProductsPage implements BasePage {

    @Autowired
    private VisibilityHelper visibilityHelper;

    @Autowired
    private LibraryHelper libraryHelper;

    @Autowired
    private LibraryHelper libraryhelper;

    @FindBy(how = How.LINK_TEXT, using = "HTC One Mini Blue")
    private WebElement linkText;

    @FindBy(how = How.LINK_TEXT, using = "Adobe Photoshop CS4")
    private WebElement adobePhotoshop;

    @FindBy(how = How.XPATH, using = "//*[@data-productid =\"19\"]/div//child::div[3]//child::div[2]/input[1]")
    private WebElement addTo;

    @FindBy(how = How.XPATH, using = "//*[@data-productid =\"10\"]/div//child::div[3]//child::div[2]/input[1]")
    private WebElement adobeProductCS4;

    @FindBy(how = How.XPATH, using = "//*[@class = \"content\"]")
    private WebElement productText;

    @FindBy(how = How.XPATH, using = "//*[@class = \"cart-label\"]")
    private WebElement shoppingCart;

    @FindBy(how = How.XPATH, using = "//*[@class =\"button-1 search-button\"]")
    private WebElement searchButton;

    @FindBy(how = How.XPATH, using = "//*[@class =\"button-1 cart-button\"]")
    private WebElement goToCart;

    public boolean verifyText() {
        visibilityHelper.waitForVisibilityOf(linkText);
        return linkText.isDisplayed();
    }

    public boolean verifyProductText(String productText) {
        if (productText.equalsIgnoreCase("HTC")) {
            visibilityHelper.waitForVisibilityOf(linkText);
            return linkText.isDisplayed();
        } else {
            visibilityHelper.waitForVisibilityOf(adobePhotoshop);
            return adobePhotoshop.isDisplayed();
        }

    }

    public void addToCart(String deviceToBeSearched) throws InterruptedException {
        if (deviceToBeSearched.equalsIgnoreCase("HTC")) {
            libraryhelper.scrollIntoView(linkText);
            addTo.click();
        } else {
            libraryhelper.scrollIntoView(adobePhotoshop);
            adobeProductCS4.click();
        }
        visibilityHelper.waitForSeconds();
        libraryHelper.scrollIntoView(searchButton);
        libraryHelper.moveToElement(shoppingCart);
        visibilityHelper.waitForElementToVisible(goToCart);
        goToCart.click();
        visibilityHelper.waitForSeconds();

    }
}
