Feature: Create Project

  Background: With valids credentials account
    Given I put a valid user and Password

  Scenario: Create Project
    Given I can create a new project with the following values
      | PROJECT_TITLE   | ProjectCucumbers123 |
      | PROJECT_ACCOUNT | Fundacion           |
      | PROJECT_VISIBLE | public              |
    Then I can verify the new project with "ProjectCucumbers123" project name
