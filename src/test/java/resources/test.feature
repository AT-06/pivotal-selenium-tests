Feature: Test API

  Scenario: Test post new project
    Given I post a new project
      | name             | name projectyyyy |
      | new_account_name | a            |
      | public           | true         |
    Then I get body of the answer

  Scenario: Test delete a project
    Given I delete a project
      | project_id  | 2172279 |
    Then status code is 204

