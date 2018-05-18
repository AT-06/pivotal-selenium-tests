Feature: Create Workspace
  Background: With valid credentials account
    Given I put a valid user and Password
    And I go to workspace tab
    And I can create a new "workspace 41" workspace
    Then I can verify the new workspace

  @acceptance
  Scenario: Create a new Workspace
    Given I select the last workspace created and I edit the workspace name "new workspace 55 edited" and press save
    Then Then I can verify the edit workspace

  @acceptance
  Scenario: Delete a Workspace
    Given I select the last workspace created and I delete the workspace
    Then Then I can verify the delete workspace