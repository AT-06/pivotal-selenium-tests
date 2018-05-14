Feature: Delete a project

  Background: With valid credentials account
    Given I put a valid user and Password

  Scenario: Delete Project
    When I click "ProjectCucumbers123" settings
    Then I expect the message: "TestDelete" was successfully deleted
