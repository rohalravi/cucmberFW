package com.pepsico.retail.models.web;

import com.pepsico.retail.helpers.LibraryHelper;
import com.pepsico.retail.helpers.VisibilityHelper;
import com.pepsico.retail.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PromotionCarouselComponent implements BasePage {

    @FindBy(xpath = "//button[@name='promotions_rightArrowButton']")
    private WebElement nextArrow;

    @FindBy(xpath = "//h5[@name='promotions_title']")
    private WebElement promotionTitle;

    @FindBy(xpath = "//a[@id='btn_PromotionsHome_SeeAll']")
    private WebElement promotionSeeAllText;

    @FindBy(xpath = "//button[@name='promotions_leftArrowButton']")
    private WebElement previousArrow;

    @FindBy(xpath = "//div[@name='txt_Promotions_Subtitle']")
    private List<WebElement> allText;

    @FindBy(xpath = "//img[@name='img_Promotions_main']")
    private List<WebElement> images;

    @FindBy(xpath = "//button[@name='promotions_dots']")
    private List<WebElement> navDots;


    public WebElement getPromotionTitle() {
        return promotionTitle;
    }

    public WebElement getSeeAllText() {
        return promotionSeeAllText;
    }

    public WebElement getNextArrow() {
        return nextArrow;
    }

    public WebElement getPreviousArrow() {
        return previousArrow;
    }

    public List<WebElement> getActiveText() {
        return allText;
    }

    public List<WebElement> getCurrentText() {
        return allText;
    }

    public List<WebElement> getImages() {
        return images;
    }

    public List<WebElement> getNavDots() {
        return navDots;
    }

    public void clickOnPreviousArrow() {
        previousArrow.click();
    }

    public void clickOnNextArrow() {
        nextArrow.click();
    }

    public void navDotsClick(WebElement navDotsElem) {
        navDotsElem.click();
    }
}
