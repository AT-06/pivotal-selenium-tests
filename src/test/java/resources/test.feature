Feature: Test API
  Scenario: Test endpoint me
    Given I post a new project
      | name             | API Project test4 |
      | new_account_name | a                 |
      | public           | true              |
    Then I get body of the answer