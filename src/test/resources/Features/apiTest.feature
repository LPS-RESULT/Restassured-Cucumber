Feature: Validate the Oxford Dictionary APIs

  As a Product Owner of Oxford Dictionary
  I want to get the meanings of English Words
  So that the user Retrieve dictionary information for a given word

  Acceptance Criteria
  User gets a response of 200 and is able to find the meanings of Valid words from the Retrieve dictionary information for a given word api
  User responds with a 404 for invalid words that do not exist

  @SmokeTests
  Scenario: validate the valid word search responses

    Given With valid API credentials
    When user search with valid word through api call
    Then user should get status_ok status code and meanings of the word

  @SmokeTests
  Scenario: validate the in valid word search responses
    Given With valid API credentials
    When user search with in valid word through api call
    Then user should get Not_Found status code and response content

  @RegressionTests
  Scenario: validate random word search responses
    Given With valid API credentials
    When user search words randomly through api call
    Then user should get approperiate status code and response content

