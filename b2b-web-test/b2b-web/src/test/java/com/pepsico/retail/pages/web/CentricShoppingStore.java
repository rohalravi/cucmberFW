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
public class CentricShoppingStore implements BasePage {

    @Autowired
    private VisibilityHelper visibilityHelper;

    @Autowired
    private LibraryHelper libraryhelper;

    @FindBy(how = How.XPATH, using = "//*[@id =\"small-searchterms\"]")
    private WebElement searchBox;

    @FindBy(how = How.XPATH, using = "//*[@class =\"button-1 search-box-button\"]")
    private WebElement searchButton;

    @FindBy(how = How.XPATH, using = "//*[@class = \"topic-block-title\"]/h2")
    private WebElement welcomeText;

    @FindBy(how = How.LINK_TEXT, using = "HTC One Mini Blue")
    private WebElement htcMobile;

    @FindBy(how = How.LINK_TEXT, using = "Adobe Photoshop CS4")
    private WebElement adobePhotoshop;

    public boolean verifyWelcomeText() {
        visibilityHelper.waitForVisibilityOf(welcomeText);
        return welcomeText.isDisplayed();
    }

    public void search(String Product) throws InterruptedException {
        searchBox.sendKeys(Product);
        searchButton.click();
        if (Product.equalsIgnoreCase("HTC")) {
            libraryhelper.scrollIntoView(htcMobile);
        } else {
            libraryhelper.scrollIntoView(adobePhotoshop);
        }

    }

}
