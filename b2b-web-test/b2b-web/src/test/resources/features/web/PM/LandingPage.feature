@E7121728 @F7394517
Feature: Verify Landing page elements

  @smoke @pi7.2 @p1 @US7465192 @US7479944
  Scenario: Verify ui elements of welcome container on landing page
    Given user navigate on the landing page
    Then user verify welcome container title on landing page
    And user verify welcome container image on landing page
    And user see title text for login on landing page
    And user see phone number and password text on landing page
    And user see fields for entering phone number and password on landing page
    And user see login button
    And user can see did you forget your password text on landing page
    And user see remember me text with radio button
    And user should see new to PepsiConnect massage
    And user see register now button

  @regression @pi7.2 @p1 @US7465168
  Scenario: Verify ui elements of descriptive area of the landing page
    When user navigate on the landing page
    Then user should see descriptive text on landing page
    And user should see descriptive image on landing page

  @regression @pi7.2 @p1 @US7465280
  Scenario: Verify ui elements of discover brand area of the landing page
    When user navigate on the landing page
    And user scroll down to see discover brand title
    Then user can see discover brand tiles
    And user can see discover brand images