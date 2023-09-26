@E7121728 @F7394601
Feature: Search your store multistore

  @regression @pi7.6 @p2 @US7624743
  Scenario: Validation of search your store screen
    Given user should login in the application for multistore with english as a language option
    When user click on the view all link on store selection screen
    Then user should see your stores title text on store selection screen
    And user should see search store option store selection screen
    And user should see all list of store store selection screen
    And user should see select store and close options on store selection screen

    @regression @pi7.6 @p1 @US7624743
  Scenario Outline: Validate search functionality with valid search on store selection screen
    Given user should login in the application for multistore with english as a language option
    And user click on the view all link on store selection screen
    When user enters "<search>" text in search your stores
    Then user should see "<search>" results corresponding to search made
    And user should see select store and close options on store selection screen

    Examples:
      | search                         |
      | 101 CHESAPEAKE BLVD, ELKTON MD |
      | Global market                  |
      | 21921                          |

  @regression @pi7.6 @p2 @US7624743
  Scenario Outline: Validate search functionality with invalid search on store selection screen
    Given user should login in the application for multistore with english as a language option
    And user click on the view all link on store selection screen
    When user enters "<incorrect search>" text in search your stores
    Then user should see Sorry message on store selection screen
    When user click on close button
    Then store selection screen popup should be closed

    Examples:
      | incorrect search |
      | 0000000          |
      | -----            |










