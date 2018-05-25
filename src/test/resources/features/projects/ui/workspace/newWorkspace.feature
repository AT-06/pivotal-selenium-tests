Feature: Create Workspace
  Background: With valid credentials account
    Given I put a valid user and Password
    And I can create a new project with the following values
      | PROJECT_TITLE   | Project5   |
      | PROJECT_ACCOUNT | Fundacion  |
      | PROJECT_VISIBLE | public     |
    Then I can verify the new project with "Project5" project name

  @acceptance
  Scenario: Create a new Workspace
    Given I return to Dashboard and go to workspace tab
    And I can create a new "may 18 test 11" workspace
    Then I can verify the new workspace