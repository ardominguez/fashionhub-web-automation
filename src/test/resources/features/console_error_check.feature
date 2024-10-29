Feature: Console Error Check on Fashion Hub

  Scenario Outline: Verify no console errors when visiting Home page
    Given The customer is on the '<Page>' page
    Then In the '<Page>' page there should be no errors in the browser console

    Examples:
      | Page     |
      | Home     |
      | Products |
      | Cart     |
      | About    |
