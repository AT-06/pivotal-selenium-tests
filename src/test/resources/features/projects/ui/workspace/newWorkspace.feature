Feature: Create Workspace
  Background: With valid credentials account
    Given I put a valid user and Password

  @acceptance @DeleteWorkspaceUI
  Scenario: Create a new Workspace
    Given I go to Dashboard and go to workspace tab
    And I can create a new "may 18 test 11" workspace
    Then I can verify the new workspace