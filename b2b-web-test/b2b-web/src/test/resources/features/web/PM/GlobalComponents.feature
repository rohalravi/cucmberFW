@F7473020 @E7121728
Feature: Global components validations

  @regression @pi7.2 @p1 @US7286019 @webdd
  Scenario: Verify ui elements of global footer on the landing page
    When user navigate on the landing page
    When  user clicks the language selector button
    And user selects one of the language "English"
    Then user scroll down to footer
    And user should see need help button and phone icon in footer
    When user click on need help button
    And helpLine pop up is visible at bottom of screen
    When user click on hide massage button on pop up
    Then user should see need help button and phone icon in footer

  @regression @pi7.2 @p1 @US7286019
  Scenario: Verify ui elements of the helpline pop up on clicking phone icon
    When user navigate on the landing page
    And  user clicks the language selector button
    And user selects one of the language "English"
    Then user scroll down to footer
    When user click on phone icon in footer
    Then helpLine pop up is visible at bottom of screen
    When user click on hide massage button on pop up
    Then user should see need help button and phone icon in footer

  @regression @pi7.3 @p1 @US7500413
  Scenario Outline: Verify header navigation menu items
    Given user should login in the application with english as a language option
    Then navigation menu items "Home,Rewards,Activities,Order" should be available on the header section of the page.
    And menu header should contain search products option,your profile,basket icon and notification icon
    And user should see home tab highlighted
    When user click on "<menuItems>" in the header main navigation
    Then "<menuItems>" in the header main navigation should be highlighted
    Examples:
      | menuItems  |
      | Rewards    |
      | Activities |
      | Order      |

  @regression @pi7.5 @p1 @US7630303
  Scenario: Validate back to top button functionality
    Given user should login in the application with english as a language option
    When user scroll down to back to top button
    Then user should see back to top button
    When user clicks on back to top button
    Then user should scroll back up