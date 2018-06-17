package org.fundacionjala.pivotal.steps.ui.story;

import cucumber.api.java.en.Then;
import org.fundacionjala.pivotal.pages.dashboard.DashBoard;
import org.fundacionjala.pivotal.pages.story.Story;
import org.fundacionjala.pivotal.util.Helper;

import org.testng.Assert;
import org.testng.asserts.Assertion;

/**
 * Class that contains the assertion steps of Story feature.
 */
public class StoryAssertionSteps {

    private Story story;
    private Helper feature;
    private DashBoard dashBoard;
    private final Assertion assertion;

    /**
     * Constructor for StorySteps class.
     *
     * @param story object.
     * @param feature     object.
     * @param dashBoard   object.
     * @param helper      object.
     */
    public StoryAssertionSteps(final Story story, final Helper feature,
                               final DashBoard dashBoard, final Helper helper) {
        this.assertion = helper.getAssertion();
        this.story = story;
        this.feature = feature;
        this.dashBoard = dashBoard;
    }

    /**
     * Verify that the new story was created.
     */
    @Then("^I verify the new story was created$")
    public void iVerifyTheNewStoryWasCreated() {
        assertion.assertEquals(feature.getStoryName(), story.verifyStoryName());
        dashBoard.setButtonDashborad();
    }

    /**
     * Verify that the parameters were edited.
     */
    @Then("^I verify the parameters were edited$")
    public void iVerifyTheParametersOfWereEdited() {
        assertion.assertEquals(feature.getStoryName(), story.verifyStoryName());
    }

    /**
     * Verify that the story was deleted.
     */
    @Then("^I verify that the story was deleted$")
    public void iVerifyThatTheStoryWasDeleted() {
        Assert.assertTrue(story.deleteMessageIsDisplayed());
    }
}
