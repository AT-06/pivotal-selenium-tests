Feature: Create Project

  Background: With valids credentials account
    Given I put a valid user and Password

  Scenario: Create Project
    Given I can create a new project with the following values
      | PROJECT_TITLE   | ProjectCucumbers |
      | PROJECT_ACCOUNT | Fundacion       |
      | PROJECT_VISIBLE | private         |
    Then I can verify the new project with "ProjectCucumbers" project name

  Scenario: Delete Project
    When I click "AT-06" settings
    And I click on delete project button
    Then I expect the message: "TestDelete" was successfully deleted
