package com.pepsico.retail.steps;


import com.pepsico.retail.helpers.VisibilityHelper;
import com.pepsico.retail.pages.common.LoginPage;
import com.pepsico.retail.pages.web.LanguagePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LanguageSteps {

    @Autowired
    private LanguagePage languagePage;

    @Autowired
    VisibilityHelper visibilityHelper;

    @Autowired
    private LoginPage loginPage;

    @Then("user should see English for selection")
    public void userShouldSeeEnglishForSelection() {
        assertTrue(languagePage.isSelectEnglishButtonDisplayed());
    }

    @When("user selects English language")
    public void userSelectsEnglishLanguage() {
        languagePage.clickEnglishSelection();
    }

    @Then("user should see {string} as default language")
    public void userShouldSeeAsDefaultLanguage(String defaultLanguage) {
        assertEquals(defaultLanguage, languagePage.displayedLanguage());
    }

    @Then("user should see {int} options under language selection")
    public void userShouldSeeOptionsUnderLanguageSelection(int languageCount) {
        Assert.assertEquals("language options are not dislayed",languageCount, languagePage.getNumberOfLanguage());
    }

    @When("user selects one of the language {string}")
    public void userSelectsOneOfTheLanguageFrom(String language) {
        languagePage.setSelectedLanguage(language);
    }

    @Then("the application language should changed to the desired {string}")
    public void theApplicationLanguageShouldChangedToTheDesired(String language) {
        if (language.equalsIgnoreCase("English")) {
            Assert.assertEquals("Application language  is changed to English", "Have an account? Please login", languagePage.changedLanguage(language));
        } else if (language.equals("Spanish")) {
            Assert.assertEquals("Application language  is not changed to Spanish", "¿Tienes una cuenta? Por favor Iniciar sesión", languagePage.changedLanguage(language));
        }
    }

    @Then("the application should show desired country flag {string}")
    public void theApplicationShouldShowDesiredCountryFlag(String flag) {
        if (flag.equalsIgnoreCase("England"))
            assertTrue("England flag not displayed", languagePage.isEnglandFlagDisplayed());
        else if (flag.equalsIgnoreCase("Colombian"))
            assertTrue("Colombian flag is not displayed", languagePage.isColombianFlagDisplayed());
    }

    @Then("user should see different language from {string}")
    public void userShouldSeeDifferentLanguageFrom(String language) {
        if (language.equalsIgnoreCase("English"))
            assertTrue("English language is not visible in dropdown", languagePage.isEnglishOptionFromDropDownDisplayed());
        else if (language.equalsIgnoreCase("Español"))
            assertTrue("Espanol is not visible", languagePage.isSpanishOptionFromDropDownDisplayed());
    }

    @When("user clicks the language selector button")
    public void userTapsTheLanguageSelector() {
        languagePage.clickLanguageSelector();
    }

    @Then("user should see {string} as default language instead of {string} language")
    public void userShouldSeeAsDefaultLanguageInsteadOfLanguage(String espanolLanguage, String spanishLanguage) {
        Assert.assertEquals("Default language expanol is not shown", espanolLanguage, languagePage.displayedLanguage());
        Assert.assertNotEquals("Spanish Language is displayed", spanishLanguage, languagePage.displayedLanguage());
    }

    @Given("user should login in the application with english as a language option")
    public void userShouldLoginInTheApplicationWithEnglishAsALanguageOption() {
        languagePage.clickLanguageSelector();
        languagePage.clickEnglishSelection();
        loginPage.login();
        }

    @Given("user should login in the application for multistore with english as a language option")
    public void userShouldLoginInTheApplicationForMultistoreWithEnglishAsALanguageOption() {
        languagePage.clickLanguageSelector();
        languagePage.clickEnglishSelection();
        loginPage.multiStoreLogin();

    }
}
