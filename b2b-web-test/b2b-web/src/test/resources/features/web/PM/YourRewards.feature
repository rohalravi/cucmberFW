@F7394601 @E7121728
Feature: Verify your rewards screen

  Background: user navigate to your stores screen
    Given user should login in the application with english as a language option
    When user click on the profile icon on home page
    And user click on your rewards option

  @regression @pi7.6 @p1 @US7366651
  Scenario: Validate the ui elements of the your rewards unhappy path screen
    Then user see "Your Rewards" text as title of reward page
    And user see reward points details, badge and trade point button
    And user can see unhappy path image
    And user can see text message for unhappy path
    And user can see reward catalogue button