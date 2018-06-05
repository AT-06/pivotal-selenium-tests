Feature: Create Workspace
  Background: With valid credentials account
    Given I post a new "workspace" to "/my/workspaces" endpoint
      | name | new workspace to modify |
    And save the response as "Workspace"
    And I validate the status code 200
    Then I put a valid user and Password

  @acceptance @deleteWorkspace
  Scenario: Modify a new Workspace
    Given I go to workspace
    Given I edit the workspace name "new workspace 55 edited" and press save
    Then I can verify the edit workspace

  @acceptance @deleteWorkspace
  Scenario: Delete a Workspace
    Given I select the last workspace created and I delete it
    Then I can verify the delete workspace