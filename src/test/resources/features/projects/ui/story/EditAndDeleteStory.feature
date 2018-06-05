Feature: Delete Story

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
    And I validate the status code 200
    Then I put a valid user and Password

  @acceptance @DeleteProject @DeleteAccount @SoftAssert
  Scenario: Edit a story
    Given I go to project
    When I edit the next parameters
      | STORY_NAME  | StoryEdited           |
      | STORY_TYPE  | bug                   |
      | BLOCKERS    | blockerTestEdited     |
      | DESCRIPTION | descriptionTestEdited |
      | LABEL       | descriptionTestEdited |
      | COMMENT     | commentTestEdited     |
    Then I verify the parameters were edited

  @acceptance @DeleteProject @DeleteAccount
  Scenario: Delete a story
    Given I go to project
    And I delete the story
    And I verify that the story was deleted
    Then Assert all