@F7394601 @E7121728
Feature: Verify your rewards happy path screen

  @smoke @pi7.6 @p3 @US7366651
  Scenario Outline:validate the ui elements of the your rewards page happy path
    Given user navigate on the landing page
    And  user clicks the language selector button
    And user selects one of the language "English"
    When user provides the credentials as <phoneNumber> and <password> on login page
    And user selects and any one store on store selection screen
    And user click on next step button
    Then user should be presented on home page
    When user click on the profile icon on home page
    And user click on your rewards option
    Then user can see reward cards title text and card images
    And user can see order on and quantity texts
    And user validate date of the reward card and expand arrow

     Examples:
      | phoneNumber   | password    |
      | "300013000"  | "Tess@123"  |