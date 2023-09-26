package com.pepsico.retail.models.web.UserAccount;

import com.pepsico.retail.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

@Component
public class LegalPolicy implements BasePage {

    @FindBy(how = How.XPATH, using = "//span[@id='legalPolicy_title']")
    private WebElement legalPolicyTitle;

    @FindBy(how = How.XPATH, using = "//span[@id='title_download_legalPolicy']")
    private WebElement downloadText;

    @FindBy(how = How.XPATH, using = "//*[local-name()='svg' and @id='icon_download_legalPolicy']")
    private WebElement downloadIcon;


    public WebElement getLegalPolicyTitle() {
        return legalPolicyTitle;
    }

    public WebElement getDownloadText() {
        return downloadText;
    }

    public WebElement getDownloadIcon() {
        return downloadIcon;
    }



}










