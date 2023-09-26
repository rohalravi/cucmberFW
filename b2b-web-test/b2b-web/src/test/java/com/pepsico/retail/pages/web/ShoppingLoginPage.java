package com.pepsico.retail.pages.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.pepsico.retail.helpers.VisibilityHelper;
import com.pepsico.retail.pages.BasePage;

@Component
public class ShoppingLoginPage implements BasePage{
    
    @Autowired
    VisibilityHelper visibilityHelper;

    @Value("${test.login}")
    private String testUserName;

    @Value("${test.password}")
    private String testPassword;


    @FindBy(how = How.XPATH, using = "//*[@id='Email']")
    private WebElement email;

    @FindBy(how = How.XPATH, using = "//*[@id='Password']")
    private WebElement password;

    @FindBy(how = How.XPATH, using = "//*[@class='button-1 login-button']")
    private WebElement loginButton;


    public void enterUsername(){
        visibilityHelper.waitForVisibilityOf(email);
        email.click();
        email.sendKeys(testUserName);
    }

    public void enterPassword(){
        password.click();
        password.sendKeys(testPassword);
    }

    public void clickLoginIn(){
        loginButton.click();
    }
}
