package com.pepsico.retail.models.web;

import com.pepsico.retail.helpers.LibraryHelper;
import com.pepsico.retail.helpers.VisibilityHelper;
import com.pepsico.retail.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductCatalogueTile implements BasePage {

    @Autowired
    private LibraryHelper libraryHelper;

    @Autowired
    private VisibilityHelper visibilityHelper;

    @FindBy(how = How.XPATH, using = "//p[@name='product_catalogue_container_title']")
    private WebElement productTitle;

    @FindBy(how = How.XPATH, using = "//a[@id='product_catalogue_container_title_link']")
    private WebElement seeALLOption;


    @FindBy(how = How.XPATH, using = "//p[@name='product_catalogue_container_description']")
    private WebElement rewardsSubTitle;

    @FindBy(how = How.XPATH, using = "//img[contains(@id,'itemCard_image')]")
    private List<WebElement> productImage;

    @FindBy(how = How.XPATH, using = "//div[contains(@id,'product_catalogue_container_card_content_title')]")
    private List<WebElement> productCardTitle;

    @FindBy(how = How.XPATH, using = "//div[contains(@id,'product_catalogue_container_card_content_title')]")
    private List<WebElement> productCardPrice;

    @FindBy(how = How.XPATH, using = "//button[contains(@name,'itemCard_primaryBtn')]")
    private List<WebElement> addToBasketButton;

    public void navigateToProductCatalogueSection() {
        libraryHelper.executeJS("window.scrollBy(0,700)", "");
    }

    public WebElement getProductTitle() {
        return productTitle;
    }

    public WebElement getSeeALLOption() {
        return seeALLOption;
    }

    public List<WebElement> getProductImage() {
        return productImage;
    }

    public List<WebElement> getProductCardTitle() {
        return productCardTitle;
    }

    public List<WebElement> getProductCardPrice() {
        return productCardPrice;
    }

    public List<WebElement> getAddToBasketButton() {
        return addToBasketButton;
    }
}
