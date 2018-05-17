Feature: Create and Delete Project

  Background: With valid credentials account
    Given I put a valid user and Password
    And I can create a new project with the following values
      | PROJECT_TITLE   | Project   |
      | PROJECT_ACCOUNT | Fundacion |
      | PROJECT_VISIBLE | private   |
    Then I can verify the new project with "Project" project name

  @acceptance
  Scenario: Edit Project
    When I select any project "Project"
    And I can edit the project
      | DESCRIPTION        | Pruebas    |
      | ENABLE_TASKS       | false      |
      | PUBLIC_ACCESS      | true       |
      | START_ITERATION    | Tuesday    |
      | PROJECT_START_DATE | 14/01/2020 |
    Then I can verify the message saved "Changes saved."

  @acceptance
  Scenario: Delete Project
    When I click "Project" settings
    Then I can verify the project deleted


