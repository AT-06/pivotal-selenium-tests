Feature: Create Project

  Background: With valids credentials account
    Given I put a valid user and Password
    And I can create a new project with the following values
      | PROJECT_TITLE   | ProjectCucumbers |
      | PROJECT_ACCOUNT | Fundacion        |
      | PROJECT_VISIBLE | private          |
    Then I can verify the new project with "ProjectCucumbers" project name

  Scenario: Edit Project
    When I select any project "ProjectCucumbers"
    And I can edit the project
      | DESCRIPTION        | Pruebas    |
      | ENABLE_TASKS       | false      |
      | PUBLIC_ACCESS      | true       |
      | START_ITERATION    | Tuesday    |
      | PROJECT_START_DATE | 13/01/2020 |
    Then I can verify the message saved "Changes saved."

  Scenario: Delete Project
    When I click "ProjectCucumbers" settings
    Then I can verify the project deleted


