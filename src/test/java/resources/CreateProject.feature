Feature: Create Project

  Background: With valids credentials account
    Given I put a valid user and Password

  Scenario: Create Project with a new Account
    Given I can create a new project with the following values
      | PROJECT_TITLE   | ProjectCucumbers8 |
      | PROJECT_ACCOUNT | Fundacion         |
      | PROJECT_VISIBLE | public            |
    Then I can verify the new project with "ProjectCucumbers8" project name

