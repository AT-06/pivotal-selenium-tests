Feature: Create and Delete Project

  Background: With valid credentials account
    Given I put a valid user and Password
    And I post a new "project" to "/projects" endpoint
      | name             | Test New ProjectMay |
      | new_account_name | Fundacion  |
      | public           | false      |
    And save the response as "Project"
    Then I validate the status code 200

  @acceptance @PostConditionProject
  Scenario: Edit Project
    When I select any project "Project.name"
    And I can edit the project
      | DESCRIPTION        | ProjectNewTest |
      | ENABLE_TASKS       | false      |
      | PUBLIC_ACCESS      | false      |
      | START_ITERATION    | Tuesday    |
      | PROJECT_START_DATE | 14/01/2020 |
    Then I can verify the message saved "Changes saved."

  @acceptance
  Scenario: Delete Project
    When I click "Project.name" settings
    Then I can verify the project deleted

