@E7121728 @F7473027
Feature: User Login Single Store Validations

  @smoke @regression @pi7.3 @p1 @US7277963
  Scenario Outline:Login button active after entering credentials in login fields
    Given user navigate on the landing page
    And  user clicks the language selector button
    And user selects one of the language "English"
    When user provides the credentials as <phoneNumber> and <password> on login page
    Then user should see login button gets active
    Examples:
      | phoneNumber | password   |
      | "934498234" | "Test@123" |

  @smoke @regression @pi7.3 @p2 @US7277963
  Scenario Outline:Login button active after entering credentials in login fields in English language
    Given user navigate on the landing page
    And  user clicks the language selector button
    And user selects one of the language "English"
    When user provides the credentials as <phoneNumber> and <password> on login page
    Then user should see login button gets active and clickable
    Then user should be presented on home page
    Examples:
      | phoneNumber | password   |
      | "934498234" | "Test@123" |

  @smoke @regression @pi7.3 @p2 @US7536649
  Scenario Outline:validation of error message for phone number in login phone number field
    Given user navigate on the landing page
    And  user clicks the language selector button
    And user selects one of the language "English"
    When user provides the credentials as <phoneNumber> and <password> on login page
    Then user should see "<validation>" message for phoneNumber
    Examples:
      | phoneNumber | password       | validation                    |
      | "12345678"  | "Columbia@123" | Incorrect phone number format |

  @smoke @regression @pi7.4 @p2 @US7536649
  Scenario: Validate user see error pop for entering wrong credentials
    Given user navigate on the landing page
    And user clicks the language selector button
    And user selects one of the language "English"
    When user enters login credential to see popup <phoneNumber> and <password> on login page
    Then user should see pop up with message "Sorry, we could not recognize you:Please try again or contact our call center for support."
    And user should see cross icon and try again button on popup
    And helpLine banner pop up is visible at popup
    Examples:
      | phoneNumber | password       |
      | "123456789" | "Columbia@123" |


  @smoke @regression @pi7.4 @p2 @US7618996 @co
  Scenario: Validate user locked for entering wrong credentials
    Given user navigate on the landing page
    And user clicks the language selector button
    And user selects one of the language "English"
    When user enters login credential to see popup "980069001" and "Test@123" on login page
    Then user should see maximum attempt pop up with message "You have reached the maximum log in attempts. Please, call our helpline for further assistance."


  @smoke @pi7.4 @p3 @US7618996
  Scenario Outline:validation of try again button on error pop up while entering invalid login credentials
    Given user navigate on the landing page
    And  user clicks the language selector button
    And user selects one of the language "English"
    When user enters login credential to see popup <phoneNumber> and <password> on login page
    Then user should see pop up with message "Sorry, we could not recognize you:Please try again or contact our call center for support."
    And user validate elements of the error pop up
    When user click on try again button on wrong credential error pop up
    Then user navigate on the landing page
    Examples:
      | phoneNumber | password   |
      | "123456789" | "Tess@111" |


  @smoke @pi7.4 @p3 @US7618996
  Scenario Outline:validation of cross button on error pop up while entering invalid login credentials
    Given user navigate on the landing page
    And  user clicks the language selector button
    And user selects one of the language "English"
    When user enters login credential to see popup <phoneNumber> and <password> on login page
    Then user should see pop up with message "Sorry, we could not recognize you:Please try again or contact our call center for support."
    And user validate elements of the error pop up
    When user click on cross button on wrong credential error pop up
    Then user navigate on the landing page
    Examples:
      | phoneNumber | password   |
      | "123456789" | "Tess@111" |


  @smoke @regression @pi7.4 @p1 @US7662671
  Scenario Outline:validation of error message for phone number in login phone number field
    Given user navigate on the landing page
    And  user clicks the language selector button
    And user selects one of the language "English"
    When user provides the credentials as <phoneNumber> and <password> on login page
    Then user should see "<validation>" message for phoneNumber
    When user click on cross button in login field to reset phone number field
    Then user should not see "<validation>" message for phoneNumber
    Examples:
      | phoneNumber | password       | validation                    |
      | "12345678"  | "Columbia@123" | Incorrect phone number format |


  @smoke @regression @pi7.4 @p1 @US7662671
  Scenario Outline:validation of masking of password in login password field
    Given user navigate on the landing page
    And  user clicks the language selector button
    And user selects one of the language "English"
    When user provides the credentials as <phoneNumber> and <password> on login page
    Then password should be masked in password field on landing page
    When user clicks on eye icon of the password field on landing page
    Then password should be unmasked in the password fields on landing page
    Examples:
      | phoneNumber  | password   |
      | "1111112228" | "Tess@111" |