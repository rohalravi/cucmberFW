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
public class ShoppingCartPage implements BasePage{
    @Autowired
    VisibilityHelper visibilityHelper;

    @FindBy(how = How.XPATH, using = "//input[@id='termsofservice']")
    private WebElement termsOfService_ChkBox;
    

    @FindBy(how = How.XPATH, using = "//button[@id='checkout']")
    private WebElement checkOut_Btn;

    @FindBy(how = How.XPATH, using = "//input[@class='button-1 checkout-as-guest-button']")
    private WebElement checkOutGuest_Btn;        
    

    public void check_termsOfService(){
        visibilityHelper.waitForElementToVisible(termsOfService_ChkBox);
        termsOfService_ChkBox.click();
    }

    public void click_checkOut(){
        visibilityHelper.waitForElementToVisible(checkOut_Btn);
        checkOut_Btn.click();
    }

    public void click_checkOutAsGuest(){
        visibilityHelper.waitForElementToVisible(checkOutGuest_Btn);
        checkOutGuest_Btn.click();
    }


}
