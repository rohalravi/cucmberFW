package com.pepsico.retail.pages.web;

import com.pepsico.retail.helpers.LibraryHelper;
import com.pepsico.retail.helpers.VisibilityHelper;
import com.pepsico.retail.models.web.ProductCatalogueTile;
import com.pepsico.retail.models.web.PromotionCarouselComponent;
import com.pepsico.retail.models.web.RewardsTile;
import com.pepsico.retail.models.web.VideoAnnouncementCarouselComponent;
import com.pepsico.retail.pages.BasePage;

import org.junit.Assert;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShoppingHomePage implements BasePage{

    @Autowired
    VisibilityHelper visibilityHelper;
    
    @FindBy(how = How.XPATH, using = "//*[@id='small-searchterms']")
    private WebElement searchBox;

    @FindBy(how = How.XPATH, using = "//ul[@id='ui-id-1']")
    private WebElement searchList;

    @FindBy(how = How.XPATH, using = "//li/a[@class='ico-cart']")
    private WebElement cartIcon_lnk;
   
    @FindBy(how = How.XPATH, using = "//li/a/span[text()='HTC One Mini Blue']")
    private WebElement hTCOneFromList;

    @FindBy(how = How.XPATH, using = "//h2[text()=\"Welcome to our store\"]")
    private WebElement welcomeToStoreText;

    @FindBy(how = How.XPATH, using = "//a[@class=\"ico-login\"]")
    private WebElement loginIcon;
    

    public void searchProduct(String productName){
        searchBox.click();
        searchBox.sendKeys(productName);
        visibilityHelper.waitForVisibilityOf(searchList);
    }

    public void clickHTCOne(){
        visibilityHelper.waitForVisibilityOf(hTCOneFromList);
        hTCOneFromList.click();
    }

    public void clickCartIcon(){
        visibilityHelper.waitForVisibilityOf(cartIcon_lnk);
        cartIcon_lnk.click();
    }

    public void navigateToHomePage(){
        visibilityHelper.waitForVisibilityOf(welcomeToStoreText);
        Assert.assertEquals("User not navigated to home page", "Welcome to our store",welcomeToStoreText.getText().trim());
    }

    public void clickLoginLink(){
        loginIcon.click();
    }

    

    
}
