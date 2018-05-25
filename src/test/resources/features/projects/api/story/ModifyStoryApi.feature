Feature: Create task into Story from a Project

  Background: With valid credentials account
    Given I post a new "project" to "/projects" endpoint
      | name             | Test New Project With Stories |
      | new_account_name | Fundacion  |
      | public           | false      |
    And save the response as "Project"
    Then I validate the status code 200
    And I post a new "story" to "/projects/[Project.id]/stories" endpoint
      | name | story 2 |
    And save the response as "Story"
    Then I validate the status code 200

  @acceptance @DeleteProject
  Scenario: Modify story with only the required field
    When I put a "story" to "/projects/[Project.id]/stories/[Story.id]" endpoint
      | name | modified story test |
    And save the response as "Story"
    Then I validate the status code 200

  @acceptance @DeleteProject
  Scenario: Delete story with only the required field
    When I delete a "story" with "/projects/[Project.id]/stories/[Story.id]" endpoint
    Then I validate the status code 204