Feature: Edit a project

  Background: With valid credentials account
    Given I put a valid user and Password

  Scenario: Edit Project
    When I select any project "ProjectCucumbers123"
    And I can edit the project
      | DESCRIPTION        | Pruebas   |
      | ENABLE_TASKS       | false     |
      | PUBLIC_ACCESS      | true      |
      | START_ITERATION    | Wednesday |
      | PROJECT_START_DATE | 23/5/2018 |
    Then I can verify the message saved "Changes saved."
