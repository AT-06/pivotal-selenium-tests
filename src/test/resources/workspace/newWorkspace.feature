Feature: Create Workspace
  Background: With valid credentials account
    Given I put a valid user and Password
    And I can create a new project with the following values
      | PROJECT_TITLE   | Projectx   |
      | PROJECT_ACCOUNT | Fundacion  |
      | PROJECT_VISIBLE | public     |
    Then I can verify the new project with "Projectx" project name

  @acceptance
  Scenario: Create a new Workspace
    Given I return to Dashboard and go to workspace tab
    And I can create a new "workspace test" workspace
    Then I can verify the new workspace