package com.pepsico.retail.models.web;

import com.pepsico.retail.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VideoAnnouncementCarouselComponent implements BasePage {

    @FindBy(xpath = "//button[@name='undefined_leftArrowButton']")
    private WebElement nextArrow;

    @FindBy(xpath = "//p[@name='announcement_title']")
    private WebElement announcementTitle;

    @FindBy(xpath = "//button[@name='undefined_rightArrowButton']")
    private WebElement previousArrow;

    @FindBy(xpath = "//p[@name='undefined_title']")
    private List<WebElement> allText;

    @FindBy(xpath = "//img[@class='makeStyles-image-182']")
    private List<WebElement> images;

    @FindBy(xpath = "//button[@name='undefined_dots']")
    private List<WebElement> navDots;


    public WebElement getVideoAnnouncementTitle() {
        return announcementTitle;
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
