Feature: Create and Delete Project

  @acceptance @DeleteProject
  Scenario: Create Project with a new Account
      Given I post a new "project" to "/projects" endpoint
        | name             | Test New ProjectMay |
        | new_account_name | Fundacion  |
        | public           | false      |
      And save the response as "Project"
      Then I validate the status code 200
