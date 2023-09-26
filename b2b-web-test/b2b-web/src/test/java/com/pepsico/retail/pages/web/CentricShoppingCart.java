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
public class CentricShoppingCart implements BasePage {

  @Autowired
  private VisibilityHelper visibilityHelper;

  @Autowired
  private LibraryHelper libraryHelper;

  @FindBy(how = How.XPATH, using = "//*[@class =\"page-title\"]/h1")
  private WebElement shoppingCartHeader;

  @FindBy(how = How.XPATH, using = "//*[@class = \"button-2 estimate-shipping-button\"]")
  private WebElement estimateShipping;

  @FindBy(how = How.XPATH, using = "//*[@id= 'termsofservice' and @type='checkbox']")
  private WebElement checkbox;

  @FindBy(how = How.XPATH, using = "//*[@id = \"checkout\"]")
  private WebElement checkoutButton;

  @FindBy(how = How.XPATH, using = "//*[@class = \"button-1 checkout-as-guest-button\"]")
  private WebElement checkoutAsGuestButton;

  public boolean verifyText() {
    visibilityHelper.waitForVisibilityOf(shoppingCartHeader);
    return shoppingCartHeader.isDisplayed();
  }

  public void guestCheckOut() throws InterruptedException {
    libraryHelper.scrollIntoView(checkbox);
    checkbox.click();
    checkoutButton.click();
    checkoutAsGuestButton.click();

  }
}
