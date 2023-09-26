package com.pepsico.retail.pages.web;

import com.pepsico.retail.helpers.LibraryHelper;
import com.pepsico.retail.helpers.VisibilityHelper;
import com.pepsico.retail.models.web.ProductCatalogueTile;
import com.pepsico.retail.models.web.PromotionCarouselComponent;
import com.pepsico.retail.models.web.RewardsTile;
import com.pepsico.retail.models.web.VideoAnnouncementCarouselComponent;
import com.pepsico.retail.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShoppingProductPage implements BasePage{

    @Autowired
    VisibilityHelper visibilityHelper;

    @FindBy(how = How.XPATH, using = "//input[contains(@id,'add-to-cart')]")
    private WebElement addToCartBtn;

    @FindBy(how = How.XPATH, using = "//div[@class='bar-notification success']/p[@class='content']")
    private WebElement productAddedSuccessMsg;

    @FindBy(how = How.XPATH, using = "//div[@class='bar-notification success']/span")
    private WebElement closeSuccessbar;
    
    

    public void clickAddToCart(){
        visibilityHelper.waitForVisibilityOf(addToCartBtn);
        addToCartBtn.click();
    }

    public void checkProductAddedSuccessMsg(){
        visibilityHelper.waitForVisibilityOf(productAddedSuccessMsg);
    }

    public void closeSuccessMsg(){
        closeSuccessbar.click();
    }



}
