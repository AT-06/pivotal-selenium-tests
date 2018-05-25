Feature: Create new workspace

  Background: With valid credentials account
    Given I post a new "workspace" to "/my/workspaces" endpoint
      | name | new workspace to delete |
    And save the response as "Workspace"
    Then I validate the status code 200

  @acceptance
  Scenario: Delete workspace with only the required field
    Given I delete a "workspace" with "/my/workspaces/[Workspace.id]" endpoint
    Then I validate the status code 204