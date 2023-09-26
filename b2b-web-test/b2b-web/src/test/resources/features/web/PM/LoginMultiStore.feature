@E7121728 @F7473027
Feature: User Login Multi Store Validations

  @smoke @regression @pi7.4 @p2 @US7479998
  Scenario Outline:Login button active after entering credentials in login fields in English language
    Given user navigate on the landing page
    And  user clicks the language selector button
    And user selects one of the language "English"
    When user provides the credentials as <phoneNumber> and <password> on login page
    Then user should see login button gets active
    Examples:
      | phoneNumber   | password       |
      | "7010701000"  | "Test@123"     |

  @smoke @regression @pi7.4 @p1 @US7479998
  Scenario Outline:validation of user navigate to store selection page on successful login credentials
    Given user navigate on the landing page
    And  user clicks the language selector button
    And user selects one of the language "English"
    When user provides the credentials as <phoneNumber> and <password> on login page
    And user click on login button on landing page
    Then user can see store selection screen
    Examples:
      | phoneNumber   | password       |
      | "7010701000"  | "Test@123"     |

  @smoke @regression @pi7.4 @p1 @US7479998
  Scenario Outline:validation of elements of store selection screen
    Given user navigate on the landing page
    And  user clicks the language selector button
    And user selects one of the language "English"
    When user provides the credentials as <phoneNumber> and <password> on login page
    And user click on login button on landing page
    Then user validate elements of store selection screen
    When user selects and any one store on store selection screen
    And user click on next step button
    Then user should be presented on home page
    Examples:
      | phoneNumber   | password       |
      | "7010701000"  | "Test@123"     |

  @smoke @phoneNumber @pi7.4 @p2 @US7479998
  Scenario Outline:validation of view all button functionality on store selection screen
    Given user navigate on the landing page
    And  user clicks the language selector button
    And user selects one of the language "English"
    When user provides the credentials as <phoneNumber> and <password> on login page
    And user click on login button on landing page
    Then user click on the view all link on store selection screen
    Examples:
      | phoneNumber   | password       |
      | "7010701000"  | "Test@123"     |

  @smoke @pi7.4 @p3 @US7479998
  Scenario Outline:validation the elements of the view all store pop up
    Given user navigate on the landing page
    And  user clicks the language selector button
    And user selects one of the language "English"
    When user provides the credentials as <phoneNumber> and <password> on login page
    And user click on login button on landing page
    And user click on the view all link on store selection screen
    Then user validate the elements of the store selection pop up on store selection screen
    And user can close store pop up by click on close button
    Examples:
      | phoneNumber   | password       |
      | "7010701000"  | "Test@123"     |
