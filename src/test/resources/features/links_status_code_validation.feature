Feature: Status code validation for links on Fashion Hub

  Scenario: Verify all links return valid status codes
    Given The customer is on the homepage
    When The customer get each link on the page
    Then Each link should return a status code of 200 or 30x

  Scenario: Verify all links return valid status codes
    Given The customer is on the homepage
    When The customer get each link on the page
    Then No link should return a status code of 40x