package com.pepsico.retail.models.web.UserAccount;

import com.pepsico.retail.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AnswerToYourQuestionSection implements BasePage {

    @FindBy(how = How.XPATH, using = "//span[@name='Faq_title']")
    private List<WebElement> faqTitle;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'MuiAccordionSummary-contentGutters')]")
    private List<WebElement> allSections;

    @FindBy(how = How.XPATH, using = "//div[contains(@id,'Ipanel0bh-content_')]")
    private List<WebElement> allSubSections;


    public List<WebElement> getFaqTitle(){
        return faqTitle;
    }

    public List<WebElement> getAllSections(){
        return allSections;
    }

    public List<WebElement> getAllSubSections() {
        return allSubSections;
    }






    }
