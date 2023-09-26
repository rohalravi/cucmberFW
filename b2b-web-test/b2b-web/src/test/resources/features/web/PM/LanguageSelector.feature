@F7473020 @E7121728
Feature: Language Selector dropdown

  @smoke @regression @pi7.2 @p2 @US7479914
  Scenario: verify default language is Espanol and 3 language options are available for selection
    Given user navigate on the landing page
    Then user should see "Spanish" as default language
    And the application should show desired country flag "Colombian"
    When user clicks the language selector button
    Then user should see 3 options under language selection

  @regression @pi7.2 @p1 @US7479914
  Scenario: Language selector works for selected language English
    Given user navigate on the landing page
    When  user clicks the language selector button
    And user selects one of the language "English"
    Then the application language should changed to the desired "English"

  @regression @pi7.2 @p1 @US7479914 @US7703955
  Scenario: Language selector works for selected language Chinese
    Given user navigate on the landing page
    When  user clicks the language selector button
    And user selects one of the language "中国人"
    Then the application language should changed to the desired "中国人"

  @regression @pi7.2 @p1 @US7479914
  Scenario: Language selector works for selected language
    Given user navigate on the landing page
    When  user clicks the language selector button
    And user selects one of the language "English"
    When user clicks the language selector button
    And user selects one of the language "Español"
    Then the application language should changed to the desired "Spanish"

  @regression @pi7.2 @p2 @US7479914
  Scenario: Verify flag is displayed for English Language
    Given user navigate on the landing page
    When user clicks the language selector button
    And user selects one of the language "English"
    Then the application should show desired country flag "England"
