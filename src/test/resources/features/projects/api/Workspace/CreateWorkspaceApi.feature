Feature: Create new workspace

  @acceptance @deleteWorkspace
  Scenario: Create task with only the required field
    When I post a new "workspace" to "/my/workspaces" endpoint
      | name | new workspace test 6|
    And save the response as "Workspace"
    Then I validate the status code 200