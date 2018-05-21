package org.fundacionjala.pivotal.steps.story;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.pivotal.objects.story.DescriptionsStory;
import org.fundacionjala.pivotal.objects.story.Story;
import org.testng.Assert;

import java.util.Map;

/**
 * EditAndDeleteStorySteps class that edit and delete a story.
 */
public class EditAndDeleteStorySteps {
    private Story story;

    /**
     * Constructor for EditAndDeleteStorySteps class.
     *
     * @param story object.
     */
    public EditAndDeleteStorySteps(final Story story) {
        this.story = story;
    }

    /**
     * First step to delete a story.
     */
    @Given("^I delete the story$")
    public void iDeleteTheStory() {
        story.deleteStory();
    }

    /**
     * Verify that the story was deleted.
     */
    @Then("^I verify that the story was deleted$")
    public void iVerifyThatTheStoryWasDeleted() {
        Assert.assertTrue(story.deleteMessageIsDisplayed());
    }

    /**
     * First step to edit a story.
     *
     * @param values parameters to edit.
     */
    @When("^I edit the next parameters$")
    public void iEditTheNextParameters(final Map<DescriptionsStory, String> values) {
        story.clickSToryExpander();
        values.keySet().stream().forEach(step -> story.getStrategyStepMap(values).get(step).execute());
        story.setButtonCloseEdit();
    }

    /**
     * Verify that the parameters were edited.
     *
     * @param storyName parameters to edit.
     */
    @Then("^I verify the parameters of \"([^\"]*)\" were edited$")
    public void iVerifyTheParametersOfWereEdited(final String storyName) {
        Assert.assertEquals(storyName, story.verifyStoryName());
    }
}
