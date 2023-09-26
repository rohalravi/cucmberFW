@E7121728 @F7473027
Feature: Validation of password recovery page

  Background: validate the user navigation to password recovery page
    Given user navigate on the landing page
    When user selects English language
    And user clicks on did you forget your password button on landing page
    Then user should navigate to the password recovery page

  @smoke @regression @pi7.3 @p1 @US7536688
  Scenario:validate the UI elements of the password recovery page
    Then user can see the forget password title text on password recovery page
    And user can see forget password sub text on password recovery page
    And user can see phone number text on password recovery page
    And user can see field to enter phone number with text in it as 'Enter your phone number'
    And user can see go back button with back arrow on it
    And user can see disabled verify button with forward arrow

  @smoke @regression @pi7.3 @p2 @US7536688
  Scenario:validate the user navigation to landing page from password recovery page
    When user click on go back button on password recovery page
    Then user can see did you forget your password text on landing page

  @smoke @regression @pi7.3 @p1 @US7536688
  Scenario: validate wrong phone number pop-up on entering wrong phone number
    Then user enter wrong phone number on password recovery page
    And click on verify button on password recovery page
    Then user can see error pop up
    And user validate elements of error pop-up
    When user click on try again button on error pop up
    Then user should navigate to the password recovery page