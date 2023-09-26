package com.pepsico.retail.models.web.UserAccount;

import com.pepsico.retail.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

@Component
public class LogoutSection implements BasePage {

    @FindBy(how = How.XPATH, using = "//p[@name='undefined_container_image']")
    private WebElement logOutImage;

    @FindBy(how = How.XPATH, using = "//button[@id='undefined_container_link_logout']")
    private WebElement yesLogOutButton;

    @FindBy(how = How.XPATH, using = "//p[@name='undefined_container_description']//h5")
    private WebElement titleText;

    @FindBy(how = How.XPATH, using = "//div[contains(@name,'logout_primaryName')]")
    private WebElement logoutTitleText;


    public WebElement getLogoutText() {
        return logoutTitleText;
    }

    public WebElement getTitleText() {
        return titleText;
    }

    public WebElement getLogoutImage() {
        return logOutImage;
    }

    public WebElement getYesButton() {
        return yesLogOutButton;
    }
}
