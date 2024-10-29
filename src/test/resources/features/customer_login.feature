Feature: Customer Login to Fashion Hub

  Background:
    Given The customer is on the login page

  Scenario: Verify customer is logged in successfully with valid credentials
    When The customer enters valid credentials
    And The customer clicks the login button
    Then The customer should be redirected to the Account page
    And The customer should see a welcome message
    And The customer should see a logout button

  Scenario: Verify customer cannot log in with invalid credentials
    When The customer enters invalid credentials
    And The customer clicks the login button
    Then The customer should remain on the login page
    And The customer should see an error message