Feature: Create Project

  Background: With valids credentials account
    Given I put a valid user and Password


  Scenario: Create Project with exist Account
    Given I can create a new project with the following values and exist Account
      | PROJECT_TITLE   | ProjectCucumbers3 |
      | PROJECT_ACCOUNT | cc                |
      | PROJECT_VISIBLE | private           |
    Then I can verify the new project with "ProjectCucumbers3" project name

  Scenario: Create Project with a new Account
    Given I can create a new project with the following values
      | PROJECT_TITLE   | ProjectCucumbers3 |
      | PROJECT_ACCOUNT | Fundacion         |
      | PROJECT_VISIBLE | public            |
    Then I can verify the new project with "ProjectCucumbers3" project name

