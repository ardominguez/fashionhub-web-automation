Feature: Retrieve Open Pull Requests

  Scenario Outline: Export a list of open pull requests to CSV format
    Given The product owner visits '<repository>' repository pull requests page from '<owner>' owner
    When The product owner gets the list of open pull requests
    Then A CSV file with '<repository>' as name should be generated with the list of open pull requests

    Examples:
      | owner    | repository |
      | appwrite | appwrite   |
      | appwrite | pink       |